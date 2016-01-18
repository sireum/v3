/*
 Copyright (c) 2016, Robby, Kansas State University
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met:

 1. Redistributions of source code must retain the above copyright notice, this
    list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright notice,
    this list of conditions and the following disclaimer in the documentation
    and/or other materials provided with the distribution.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sireum.logika.ast

import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree._

import java.io.StringReader

import org.sireum.logika.parser.Antlr4LogikaParser._
import org.sireum.logika.parser._
import org.sireum.util._
import org.sireum.util.jvm.Antlr4Util._

final private class Builder(fileUriOpt: Option[FileResourceUri])(
  implicit reporter: AccumulatingTagReporter) {

  private implicit val nodeLocMap = midmapEmpty[AnyRef, LocationInfo]
  val constMap = MIdMap[Node, BigInt]()
  val zero = BigInt(0)
  val maxInt = BigInt(Int.MaxValue)
  val minInt = BigInt(Int.MinValue)

  private def build(ctx: FileContext): UnitNode = {
    val r =
      ctx match {
        case ctx: SequentFileContext => build(ctx)
        case ctx: ProgramFileContext => build(ctx)
      }
    r.fileUriOpt = fileUriOpt
    r.nodeLocMap = nodeLocMap.asInstanceOf[MIdMap[Node, LocationInfo]]
    r
  }

  private def build(ctx: SequentFileContext): Sequent =
    if (ctx.proof != null) build(ctx.sequent).
      copy(proofOpt = Some(build(ctx.proof))) at ctx
    else build(ctx.sequent)

  private def build(ctx: ProgramFileContext): Program =
    build(ctx.program)

  private def build(ctx: SequentContext): Sequent =
    Sequent(
      Option(ctx.premises).map(_.map(build)).getOrElse(Node.emptySeq),
      ctx.conclusions.map(build),
      None) at ctx

  private def build(ctx: ProofContext): Proof =
    Proof(Option(ctx.proofStep).map(_.map(build)).
      getOrElse(Node.emptySeq)) at(ctx.tb, ctx.te)

  private def build(ctx: ProofStepContext): ProofStep = ctx match {
    case ctx: StepContext => build(ctx)
    case ctx: SubProofContext => build(ctx)
  }

  private def build(ctx: StepContext): RegularStep = {
    val num = buildNum(ctx.NUM)
    val exp = build(ctx.formula)
    val r =
      ctx.justification match {
        case ctx: PremiseContext => Premise(num, exp)
        case ctx: AndIntroContext =>
          errorIf(num, ctx.ID, ctx.tb, "i", "andi")
          exp match {
            case exp: And =>
              AndIntro(num, exp, buildNum(ctx.lStep), buildNum(ctx.rStep))
            case _ =>
              error(ctx.tb, s"And-intro in step #${num.value} requires a conjunction.")
              AndIntro(num, And(exp, exp), buildNum(ctx.lStep),
                buildNum(ctx.rStep))
          }
        case ctx: AndElimContext =>
          val andStep = buildNum(ctx.andStep)
          ctx.tb.getText match {
            case "ande1" => AndElim1(num, exp, andStep)
            case "ande2" => AndElim2(num, exp, andStep)
            case tb => ctx.ID.getText match {
              case "e1" => AndElim1(num, exp, andStep)
              case "e2" => AndElim2(num, exp, andStep)
              case id =>
                error(ctx.tb, ctx.ID, s"Unrecognized justification $tb$id in step #${num.value}.")
                AndElim1(num, exp, andStep)
            }
          }
        case ctx: OrIntroContext =>
          val orStep = buildNum(ctx.step)
          val e = exp match {
            case exp: Or => exp
            case _ =>
              error(ctx.tb, s"Or-intro in step #${num.value} requires a disjunction.")
              Or(exp, exp)
          }
          val tb = ctx.tb.getText
          tb match {
            case "ori1" | "Vi1" => OrIntro1(num, e, orStep)
            case "ori2" | "Vi2" => OrIntro2(num, e, orStep)
            case _ => ctx.ID.getText match {
              case "i1" => OrIntro1(num, e, orStep)
              case "i2" => OrIntro2(num, e, orStep)
              case id =>
                error(ctx.tb, ctx.ID, s"Unrecognized justification $tb$id in step #${num.value}.")
                OrIntro1(num, e, orStep)
            }
          }
        case ctx: OrElimContext =>
          val orStep = buildNum(ctx.orStep)
          val lSubProof = buildNum(ctx.lSubProof)
          val rSubProof = buildNum(ctx.rSubProof)
          errorIf(num, ctx.ID, ctx.tb, "e", "ore", "Ve")
          OrElim(num, exp, orStep, lSubProof, rSubProof)
        case ctx: ImpliesIntroContext =>
          val subProof = buildNum(ctx.subProof)
          errorIf(num, ctx.ID, ctx.tb, "i", "impliesi")
          val e = exp match {
            case exp: Implies => exp
            case _ =>
              error(ctx.tb, s"Implies-intro in step #${num.value} requires an implication.")
              Implies(exp, exp)
          }
          ImpliesIntro(num, e, subProof)
        case ctx: ImpliesElimContext =>
          val impliesStep = buildNum(ctx.impliesStep)
          val antecedentStep = buildNum(ctx.antecedentStep)
          errorIf(num, ctx.ID, ctx.tb, "e", "impliese")
          ImpliesElim(num, exp, impliesStep, antecedentStep)
        case ctx: NegIntroContext =>
          val subProof = buildNum(ctx.subProof)
          errorIf(num, ctx.ID, ctx.tb, "i", "noti", "negi")
          val e = exp match {
            case exp: Not => exp
            case _ =>
              error(ctx.tb, s"Negation-intro in step #${num.value} requires a negation.")
              Not(exp)
          }
          NegIntro(num, e, subProof)
        case ctx: NegElimContext =>
          val step = buildNum(ctx.step)
          val notStep = buildNum(ctx.negStep)
          errorIf(num, ctx.ID, ctx.tb, "e", "note", "nege")
          NegElim(num, exp, step, notStep)
        case ctx: BottomElimContext =>
          val bottomStep = buildNum(ctx.bottomStep)
          errorIf(num, ctx.ID, ctx.tb, "e", "bottome", "falsee")
          BottomElim(num, exp, bottomStep)
        case ctx: PbcContext =>
          val subProof = buildNum(ctx.subProof)
          Pbc(num, exp, subProof)
        case ctx: Subst1Context =>
          Subst1(num, exp, buildNum(ctx.eqStep), buildNum(ctx.step))
        case ctx: Subst2Context =>
          Subst2(num, exp, buildNum(ctx.eqStep), buildNum(ctx.step))
        case ctx: AlgebraContext =>
          Algebra(num, exp, Option(ctx.steps).map(_.map(buildNum)).
            getOrElse(Node.emptySeq))
        case ctx: ForallIntroContext =>
          val subProof = buildNum(ctx.subProof)
          errorIf(num, ctx.ID, ctx.tb, "i", "foralli", "alli", "Ai")
          val e = exp match {
            case exp: ForAll => exp
            case _ =>
              error(ctx.tb, s"Forall-intro in step #${num.value} requires a universal quantification.")
              ForAll(Node.emptySeq, None, exp)
          }
          ForAllIntro(num, e, subProof)
        case ctx: ForallElimContext =>
          val step = buildNum(ctx.step)
          errorIf(num, ctx.ID, ctx.tb, "e", "foralle", "alle", "Ae")
          ForAllElim(num, exp, step, ctx.formula.map(build))
        case ctx: ExistsIntroContext =>
          val existsStep = buildNum(ctx.existsStep)
          errorIf(num, ctx.ID, ctx.tb, "i", "existsi", "somei", "Ei")
          val e = exp match {
            case exp: Exists => exp
            case _ =>
              error(ctx.tb, s"Exists-intro in step #${num.value} requires an existensial quantification.")
              Exists(Node.emptySeq, None, exp)
          }
          ExistsIntro(num, e, existsStep, ctx.formula.map(build))
        case ctx: ExistsElimContext =>
          val step = buildNum(ctx.step)
          val subProof = buildNum(ctx.subProof)
          errorIf(num, ctx.ID, ctx.tb, "e", "existse", "somee", "Ee")
          ExistsElim(num, exp, step, subProof)
        case ctx: InvariantContext =>
          Invariant(num, exp)
        case ctx: FctContext =>
          FactJust(num, exp, buildId(ctx.ID))
        case ctx: AutoContext =>
          Auto(num, exp, Option(ctx.steps).map(_.map(buildNum)).
            getOrElse(Node.emptySeq))
      }
    r at ctx
  }

  private def build(ctx: SubProofContext): SubProof = {
    val num = buildNum(ctx.sub)
    val assume = buildNum(ctx.assume)
    val assumeStep =
      if (ctx.ate != null)
        if (ctx.ID != null)
          ExistsAssumeStep(assume, buildId(ctx.ID),
            Option(ctx.`type`).map(build),
            build(ctx.formula)) at(ctx.assume, ctx.ate)
        else
          PlainAssumeStep(assume,
            build(ctx.formula)) at(ctx.assume, ctx.ate)
      else
        ForAllAssumeStep(assume,
          buildId(ctx.ID), Option(ctx.`type`).map(build)) at ctx.ID
    SubProof(num, assumeStep, Option(ctx.proofStep).map(_.map(build)).
      getOrElse(Node.emptySeq)) at ctx
  }

  private def build(ctx: FormulaContext): Exp = {
    val r = ctx match {
      case ctx: BooleanContext =>
        ctx.t.getText match {
          case "true" | "T" | "⊤" => BooleanLit(true)
          case "false" | "F" | "_|_" | "⊥" => BooleanLit(false)
        }
      case ctx: VarContext =>
        val r = buildId(ctx.tb)
        if (ctx.te != null) {
          errorIf(ctx.te, "size")
          Size(r)
        } else r
      case ctx: ParenContext =>
        val r = build(ctx.formula)
        r.hasParen = true
        r
      case ctx: ResultContext => Result()
      case ctx: ApplyContext =>
        Apply(buildId(ctx.ID), ctx.formula.map(build))
      case ctx: IntContext =>
        val r = buildInt(ctx.NUM)
        constMap(r) = BigInt(r.value)
        r
      case ctx: BigIntContext => IntLit(ctx.STRING.getText)
      case ctx: SeqContext =>
        SeqLit(Option(ctx.exp).map(_.map(build)).getOrElse(Node.emptySeq))
      case ctx: BinaryContext =>
        val lExp = build(ctx.l)
        val rExp = build(ctx.r)
        ctx.op.getText match {
          case "*" =>
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp)) {
              checkIntMaxMin(ctx.op, lN * rN)
            }
            Mul(lExp, rExp)
          case "/" =>
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp)) {
              if (rN == zero) error(rExp, s"Division by zero detected.")
              else checkIntMaxMin(ctx.op, lN / rN)
            }
            Div(lExp, rExp)
          case "%" =>
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp)) {
              if (rN == zero) error(rExp, s"Division by zero detected.")
              else checkIntMaxMin(ctx.op, lN % rN)
            }
            Rem(lExp, rExp)
          case "+" =>
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp))
              checkIntMaxMin(ctx.op, lN + rN)
            Add(lExp, rExp)
          case "-" =>
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp))
              checkIntMaxMin(ctx.op, lN - rN)
            Sub(lExp, rExp)
          case ":+" => Append(lExp, rExp)
          case "+:" => Prepend(lExp, rExp)
          case "<" => Lt(lExp, rExp)
          case "<=" | "≤" => Le(lExp, rExp)
          case ">" => Gt(lExp, rExp)
          case ">=" | "≥" => Ge(lExp, rExp)
          case "=" | "==" => Eq(lExp, rExp)
          case "!=" | "≠" => Ne(lExp, rExp)
          case "and" | "&" | "∧" | "^" => And(lExp, rExp)
          case "or" | "|" | "∨" | "V" => Or(lExp, rExp)
          case "implies" | "->" | "→" => Implies(lExp, rExp)
        }
      case ctx: UnaryContext =>
        val exp = build(ctx.formula)
        ctx.op.getText match {
          case "-" =>
            constMap.get(exp) match {
              case Some(n) => checkIntMaxMin(ctx.op, -n)
              case _ =>
            }
            Minus(exp)
          case "not" | "!" | "~" | "¬" => Not(exp)
        }
      case ctx: QuantContext => build(ctx.qformula)
    }
    r at ctx
  }

  private def buildInt(t: Token): IntLit = IntLit(t.getText)

  private def build(ctx: QformulaContext): Quant[_] = {
    val apply =
      ctx.q.getText match {
        case "forall" | "all" | "A" | "∀" => ForAll
        case "exists" | "some" | "E" | "∃" => Exists
      }
    val domain =
      if (ctx.`type` != null) {
        Some(TypeDomain(build(ctx.`type`)) at ctx.`type`)
      } else if (ctx.lo != null) {
        val lo = build(ctx.lo)
        val hi = build(ctx.hi)
        Some(
          RangeDomain(lo, hi, ctx.ll != null,
            ctx.lh != null) at(lo, hi))
      } else None
    apply(ctx.vars.map(buildId), domain,
      build(ctx.formula)) at ctx
  }

  private def build(ctx: TypeContext): Type = {
    val r = ctx match {
      case ctx: BooleanTypeContext => BooleanType()
      case ctx: IntTypeContext => IntType()
      case ctx: IntSeqTypeContext => IntSeqType()
    }
    r at ctx
  }

  private def build(ctx: ProgramContext): Program =
    if (ctx.impor != null) {
      checkImport(ctx.impor)
      Program(build(ctx.stmts)) at ctx
    } else Program(Block(Node.emptySeq))

  private def checkImport(ctx: ImporContext): Unit =
    if (!("org" == ctx.org.getText && "sireum" == ctx.sireum.getText &&
      "logika" == ctx.logika.getText))
      error(ctx.org, s"Can only import from org.sireum.logika.")

  private def build(ctx: FactsContext): Facts =
    Facts(ctx.factOrFun.map(build)) at(ctx.ftb, ctx.te)

  private def build(ctx: FactOrFunContext): FactOrFun =
    if (ctx.fact != null) build(ctx.fact) else build(ctx.fun)

  private def build(ctx: FactContext): Fact =
    Fact(buildId(ctx.ID), build(ctx.formula)) at ctx

  private def build(ctx: FunContext): Fun = {
    if (ctx.ID.getText.indexOf('_') >= 0)
      error(ctx.ID, s"Underscore is a reserved character for fun identifier.")
    Fun(buildId(ctx.ID), ctx.param.map(build), build(ctx.`type`)) at ctx
  }

  private def build(ctx: ParamContext): Param = {
    if (ctx.ID.getText.indexOf('_') >= 0)
      error(ctx.ID, s"Underscore is a reserved character for parameter identifier.")
    Param(buildId(ctx.ID), build(ctx.`type`)) at ctx
  }

  private def build(ctx: StmtsContext): Block =
    Block(Option(ctx.stmt) match {
      case Some(stmts) => for (stmt <- stmts; s <- build(stmt)) yield s
      case None => Node.emptySeq
    })

  private def build(ctx: StmtContext): Option[Stmt] = {
    val rOpt: Option[Stmt] =
      ctx match {
        case ctx: VarDeclStmtContext =>
          val isVar = ctx.modifier.getText == "var"
          if (ctx.ID.getText.indexOf('_') >= 0)
            if (isVar)
              error(ctx.ID, s"Underscore is a reserved character for var identifier.")
            else
              error(ctx.ID, s"Underscore is a reserved character for val identifier.")
          Some(VarDecl(isVar, buildId(ctx.ID),
            build(ctx.`type`), build(ctx.exp)))
        case ctx: AssignVarStmtContext =>
          Some(Assign(buildId(ctx.ID), build(ctx.exp)))
        case ctx: AssumeStmtContext => Some(Assume(build(ctx.exp)))
        case ctx: AssertStmtContext => Some(Assert(build(ctx.exp)))
        case ctx: IfStmtContext =>
          Some(If(build(ctx.exp), build(ctx.ts),
            Option(ctx.fs).map(build).getOrElse(Block(Node.emptySeq))))
        case ctx: WhileStmtContext =>
          Some(While(build(ctx.exp), build(ctx.stmts),
            Option(ctx.loopInvariant).map(build).getOrElse(
              LoopInv(Inv(Node.emptySeq), Modifies(Node.emptySeq)))))
        case ctx: PrintStmtContext =>
          val args = Option(ctx.stringOrExp) match {
            case Some(stringOrExps) =>
              stringOrExps.toVector.map { stringOrExp =>
                if (stringOrExp.STRING != null) {
                  val text = stringOrExp.STRING.getText
                  StringLit(text.substring(1, text.length - 1)) at stringOrExp.STRING
                } else build(stringOrExp.exp)
              }
            case None => Node.emptySeq
          }
          Some(Print(ctx.op.getText == "println", args))
        case ctx: SeqAssignStmtContext =>
          Some(SeqAssign(buildId(ctx.tb), build(ctx.index), build(ctx.r)))
        case ctx: MethodDeclStmtContext =>
          if (ctx.id.getText.indexOf('_') >= 0)
            error(ctx.id, s"Underscore is a reserved character for method identifier.")
          val isHelper =
            if (ctx.helper != null) {
              if (ctx.helper.getText != "helper")
                error(ctx.helper, s"Only helper annotation is allowed instead of ${ctx.helper.getText}.")
              true
            } else false
          Some(MethodDecl(isHelper, buildId(ctx.id),
            Option(ctx.param).map(_.map(build)).getOrElse(Node.emptySeq),
            Option(ctx.`type`).map(build),
            Option(ctx.methodContract).map(build).getOrElse(
              MethodContract(Requires(Node.emptySeq),
                Modifies(Node.emptySeq),
                Ensures(Node.emptySeq))),
            build(ctx.stmts), Option(ctx.exp).map(build)))
        case ctx: LogikaStmtContext =>
          Some((ctx.proof, ctx.sequent, ctx.invariants, ctx.facts) match {
            case (proof, null, null, null) => ProofStmt(build(proof))
            case (null, sequent, null, null) => SequentStmt(build(sequent))
            case (null, null, invariants, null) => InvStmt(build(invariants))
            case (null, null, null, facts) => FactStmt(build(facts))
          })
        case ctx: ImportStmtContext => checkImport(ctx.impor); None
        case ctx: ExpStmtContext =>
          Some(build(ctx.exp) match {
            case e: Apply => ExpStmt(e)
            case e =>
              error(e, s"Only method invocation expression is allowed as a statement.")
              ExpStmt(Apply(Id("???"), Node.seq(e)))
          })
      }
    rOpt.map(_ at ctx)
  }

  private def build(ctx: ExpContext): Exp = {
    val r = ctx match {
      case ctx: BooleanExpContext =>
        ctx.t.getText match {
          case "true" | "T" | "⊤" => BooleanLit(true)
          case "false" | "F" | "_|_" | "⊥" => BooleanLit(false)
        }
      case ctx: IntExpContext =>
        val r = buildInt(ctx.NUM)
        constMap(r) = BigInt(r.value)
        r
      case ctx: IdExpContext =>
        val r = buildId(ctx.tb)
        if (ctx.exp != null && ctx.t != null) {
          Apply(r,
            Option(ctx.exp).map(_.map(build)).getOrElse(Node.emptySeq))
        } else ctx.te match {
          case null => r
          case te if te.getText == "size" => Size(r)
          case te if te.getText == "clone" => Clone(r)
          case te =>
            error(ctx.te, s"Expecting size or clone instead of ${te.getText}")
            r
        }
      case ctx: BigIntExpContext => IntLit(ctx.STRING.getText)
      case ctx: SeqExpContext =>
        SeqLit(Option(ctx.exp).map(_.map(build)).getOrElse(Node.emptySeq))
      case ctx: RandomIntExpContext => RandomInt()
      case ctx: ReadIntExpContext =>
        ReadInt(Option(ctx.STRING).map { x =>
          val text = x.getText
          StringLit(text.substring(1, text.length - 1))
        })
      case ctx: ParenExpContext =>
        val r = build(ctx.exp)
        r.hasParen = true
        r
      case ctx: UnaryExpContext =>
        val exp = build(ctx.exp)
        ctx.op.getText match {
          case "-" =>
            constMap.get(exp) match {
              case Some(n) => checkIntMaxMin(ctx.op, -n)
              case _ =>
            }
            Minus(exp)
          case "not" | "neg" | "!" | "~" | "¬" => Not(exp)
        }
      case ctx: BinaryExpContext =>
        val lExp = build(ctx.l)
        val rExp = build(ctx.r)
        ctx.op.getText match {
          case "*" =>
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp))
              checkIntMaxMin(ctx.op, lN * rN)
            Mul(lExp, rExp)
          case "/" =>
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp)) {
              if (rN == zero) error(rExp, s"Divide by zero detected.")
              else checkIntMaxMin(ctx.op, lN / rN)
            }
            Div(lExp, rExp)
          case "%" =>
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp)) {
              if (rN == zero) error(rExp, s"Modulo by zero detected.")
              else checkIntMaxMin(ctx.op, lN % rN)
            }
            Rem(lExp, rExp)
          case "+" =>
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp))
              checkIntMaxMin(ctx.op, lN + rN)
            Add(lExp, rExp)
          case "-" =>
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp))
              checkIntMaxMin(ctx.op, lN - rN)
            Sub(lExp, rExp)
          case ":+" => Append(lExp, rExp)
          case "+:" => Prepend(lExp, rExp)
          case "<" => Lt(lExp, rExp)
          case "<=" | "≤" => Le(lExp, rExp)
          case ">" => Gt(lExp, rExp)
          case ">=" | "≥" => Ge(lExp, rExp)
          case "=" | "==" => Eq(lExp, rExp)
          case "!=" | "≠" => Ne(lExp, rExp)
          case "and" | "&" | "∧" | "^" => And(lExp, rExp)
          case "or" | "|" | "∨" | "V" => Or(lExp, rExp)
          case "implies" | "->" | "→" => Implies(lExp, rExp)
        }
    }
    r at ctx
  }

  private def build(ctx: LoopInvariantContext): LoopInv = {
    val inv = Inv(Option(ctx.formula).map(_.map(build)).
      getOrElse(Node.emptySeq))

    LoopInv(
      if (inv.exps.isEmpty) inv
      else inv at(ctx.itb, inv.exps.last),
      Option(ctx.modifies).map(build).
        getOrElse(Modifies(Node.emptySeq))) at(ctx.tb, ctx.te)
  }

  private def build(ctx: ModifiesContext): Modifies = {
    val ids = ctx.ID.map(buildId)
    Modifies(ids) at(ctx.tb, ids.last)
  }

  private def build(ctx: MethodContractContext): MethodContract =
    MethodContract(
      Requires(Option(ctx.rs).map(_.map(build)).getOrElse(Node.emptySeq)),
      Option(ctx.modifies).map(build).getOrElse(Modifies(Node.emptySeq)),
      Ensures(Option(ctx.es).map(_.map(build)).getOrElse(Node.emptySeq))) at
      (ctx.tb, ctx.te)

  private def build(ctx: InvariantsContext): Inv =
    Inv(ctx.formula.map(build)) at(ctx.tb, ctx.te)

  private def buildId(tn: TerminalNode): Id = buildId(tn.getSymbol)

  private def buildId(t: Token): Id =
    Id(t.getText) at t

  private def buildNum(t: Token): Num = {
    val num = Num(t.getText.toInt) at t
    if (num.value < 0) {
      error(t, "Proof step numbers should not be negative.")
    }
    num
  }

  private def checkIntMaxMin(t: Token, value: BigInt): Unit = {
    if (value < minInt) {
      error(t, s"""32-bit integer underflow is detected, please use Z("...") to construct an arbitrary-precision integer.""")
    } else if (value > maxInt) {
      error(t, s"""32-bit integer overflow is detected, please use Z("...") to construct an arbitrary-precision integer.""")
    }
  }

  private def errorIf(t: Token, tText: String): Unit = {
    if (t.getText != tText)
      error(t, s"Expecting $tText instead of ${t.getText}")
  }

  private def errorIf(num: Num, id: Token, op: Token,
                      idText: String, opTexts: String*): Unit = {
    if (!(opTexts.contains(op.getText) || id.getText == idText))
      error(op, id,
        s"Unrecognized justification ${op.getText}${id.getText} in step #${num.value}.")
  }

  private def error(t: Token, msg: String): Unit =
    Builder.error("AST", fileUriOpt, t, t, msg)

  private def error(t: Token, t2: Token, msg: String): Unit =
    Builder.error("AST", fileUriOpt, t, t2, msg)

  private def error(n: Node, msg: String): Unit =
    Builder.error("AST", fileUriOpt, n, msg)

  import scala.language.implicitConversions

  @inline
  private implicit def toNodeSeq[T](ns: java.lang.Iterable[T]): Node.Seq[T] =
    Node.seq[T](scala.collection.JavaConversions.iterableAsScalaIterable(ns))

  @inline
  private implicit def toToken(n: TerminalNode): Token =
    if (n == null) null else n.getSymbol
}

object Builder {
  private final val terminateStmtTokens = Set(
    "this", "null", "true", "false", "return", "type", ")", "]", "}", "_"
  )
  private final val nonBeginStmtTokens = Set(
    "catch", "else", "extends", "finally", "forSome", "match", "with", "yield",
    ",", ".", ":", "=", "=>", "⇒", "[", ")", "]", "}", "<-", "<:", "<%", ">:", "#"
  )

  import org.antlr.v4.runtime._

  def apply(fileUriOpt: Option[FileResourceUri],
            input: String, maxErrors: Natural = 0)(
             implicit reporter: AccumulatingTagReporter): Option[UnitNode] = {
    class ParsingEscape extends RuntimeException
    object Mode extends Enumeration {
      val Sequent, Program = Value
    }

    val sr = new StringReader(input)
    val inputStream = new ANTLRInputStream(sr)
    val lexer = new Antlr4LogikaLexer(inputStream)
    val tokenStream = new CommonTokenStream(lexer)
    tokenStream.fill()
    val mode = {
      import scala.collection.JavaConversions._
      var firstTokenOpt: Option[Token] = None
      for (t <- tokenStream.getTokens() if firstTokenOpt.isEmpty) {
        if (t.getType != Antlr4LogikaLexer.NL &&
          t.getChannel == Lexer.DEFAULT_TOKEN_CHANNEL)
          firstTokenOpt = Some(t)
      }
      firstTokenOpt match {
        case Some(t) =>
          if (t.getText == "import") Mode.Program
          else Mode.Sequent
        case _ => Mode.Program
      }
    }
    {
      import scala.collection.JavaConversions._
      var inLogikaStmt = false
      lexer.reset()
      val tokens = lexer.getAllTokens
      for (t <- tokens) {
        val tText = t.getText
        if (tText == "l\"\"\"")
          inLogikaStmt = true
        else if (tText == "\"\"\"")
          inLogikaStmt = false
        else if (inLogikaStmt) {
          if (t.getType == Antlr4LogikaLexer.COMMENT)
            error("Parser", fileUriOpt, t, "Block comment cannot appear inside l\"\"\" ... \"\"\"")
          else if (tText.exists(_ == '$'))
            error("Parser", fileUriOpt, t, "$ cannot appear inside l\"\"\" ... \"\"\"")
        }
      }
    }
    val parser = new Antlr4LogikaParser(tokenStream)
    parser.removeErrorListeners()
    parser.addErrorListener(new BaseErrorListener {
      var errors = 0

      override def syntaxError(recognizer: Recognizer[_, _],
                               offendingSymbol: Any,
                               line: PosInteger,
                               charPositionInLine: PosInteger,
                               msg: String,
                               e: RecognitionException): Unit = {
        val token = offendingSymbol.asInstanceOf[Token]
        error("Parser", fileUriOpt, token,
          msg.replace("no viable alternative", "invalid syntax starting"))
        errors += 1
        if (maxErrors > 0 && errors >= maxErrors) {
          throw new ParsingEscape
        }
      }
    })


    try {
      val r =
        mode match {
          case Mode.Sequent =>
            orientNewlines(tokenStream, isProgram = false)
            val parseTree = parser.file()
            if (!reporter.hasError) {
              val ast = new Builder(fileUriOpt).build(parseTree)
              if (!reporter.hasError) Some(ast)
              else None
            } else None
          case Mode.Program =>
            orientNewlines(tokenStream, isProgram = true)
            val parseTree = parser.file()
            if (!reporter.hasError) {
              val ast = new Builder(fileUriOpt).build(parseTree)
              if (!reporter.hasError) Some(ast)
              else None
            } else None
        }
      r match {
        case Some(un) =>
          un.input = input
          Node.checkWellFormed(un)
          if (!reporter.hasError) r else None
        case None => None
      }
    } catch {
      case _: ParsingEscape => None
    }
  }

  private def orientNewlines(cts: CommonTokenStream,
                             isProgram: Boolean): Unit = {
    import Antlr4LogikaLexer.{ID, NL, NUM}
    val tokens: CSeq[Token] = {
      import scala.collection.JavaConversions._
      cts.getTokens
    }
    if (tokens.isEmpty) {
      return
    }

    if (!isProgram) {
      var stop = false
      for (t <- tokens if !stop) {
        if (t.getText == "{") stop = true
        else if (t.getType == NL) hide(t)
      }
    }

    var i = 0
    var parens = 0
    val size = tokens.size
    while (tokens(i).getType != IntStream.EOF) {
      val token = tokens(i)
      token.getText match {
        case "(" => parens += 1
        case ")" if parens > 0 => parens -= 1
        case text if token.getType == NL =>
          if (parens > 0) {
            token.asInstanceOf[CommonToken].
              setChannel(Token.HIDDEN_CHANNEL)
          } else {
            var skip = true
            if (i > 0) {
              val prevToken = tokens(i - 1)
              if (terminateStmtTokens.
                contains(prevToken.getText)) {
                skip = false
              } else
                prevToken.getType match {
                  case ID | NUM => skip = false
                  case _ =>
                }
            }
            if (i < size - 1) {
              val nextToken = tokens(i + 1)
              if (!nonBeginStmtTokens.contains(nextToken.getText)) {
                skip = false
              }
            }
            if (skip) {
              hide(token)
            }
          }
        case _ =>
      }
      i += 1
    }
  }

  private def error(kind: String, fileUriOpt: Option[FileResourceUri],
                    n: Node, msg: String)(
                     implicit reporter: AccumulatingTagReporter,
                     nodeLocMap: MIdMap[AnyRef, LocationInfo]): Unit =
    reporter.report(nodeLocMap(n).toLocationError(fileUriOpt, kind, msg))

  private def error(kind: String, fileUriOpt: Option[FileResourceUri],
                    t: Token, msg: String)(
                     implicit reporter: AccumulatingTagReporter): Unit =
    error(kind, fileUriOpt, t, t, msg)

  private def error(kind: String, fileUriOpt: Option[FileResourceUri],
                    t: Token, t2: Token, msg: String)(
                     implicit reporter: AccumulatingTagReporter): Unit = {
    val lb = t.getLine
    val cb = t.getCharPositionInLine
    val off = t.getStartIndex
    val len = t2.getStopIndex - t.getStartIndex + 1
    val (le, ce) = end(t2.getLine, t2.getCharPositionInLine, t2.getText)
    fileUriOpt match {
      case Some(fileUri) =>
        reporter.report(
          FileLocationInfoErrorMessage(
            kind = kind,
            uri = fileUri,
            lineBegin = lb,
            columnBegin = cb,
            lineEnd = le,
            columnEnd = ce,
            offset = off,
            length = len,
            message = msg))
      case _ =>
        reporter.report(
          LocationInfoErrorMessage(
            kind = kind,
            lineBegin = lb,
            columnBegin = cb,
            lineEnd = le,
            columnEnd = ce,
            offset = off,
            length = len,
            message = msg))
    }
  }

  private def hide(t: Token): Unit = {
    t.asInstanceOf[CommonToken].setChannel(Token.HIDDEN_CHANNEL)
  }
}