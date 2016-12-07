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

final private class Builder(fileUriOpt: Option[FileResourceUri], input: String, bitWidth: Int)(
  implicit reporter: AccumulatingTagReporter) {

  private implicit val nodeLocMap = midmapEmpty[AnyRef, LocationInfo]
  val constMap = MIdMap[Node, BigInt]()
  val zero = BigInt(0)
  val maxInt = BigInt(Int.MaxValue)
  val minInt = BigInt(Int.MinValue)
  val maxN64 = BigInt(2).pow(64) - 1

  private def build(ctx: FileContext): UnitNode = {
    val r =
      ctx match {
        case ctx: TruthTableFileContext => build(ctx)
        case ctx: SequentFileContext => build(ctx)
        case ctx: ProgramFileContext => build(ctx)
      }
    r.fileUriOpt = fileUriOpt
    r.nodeLocMap = nodeLocMap.asInstanceOf[MIdMap[Node, LocationInfo]]
    r
  }

  private def build(ctx: TruthTableFileContext): TruthTable =
    build(ctx.truthTable)

  private def build(ctx: TruthTableContext): TruthTable =
    TruthTable(
      TruthTableMarker() at ctx.star,
      ctx.vars.map(buildId),
      TruthTableMarker() at ctx.bar,
      build(ctx.formula),
      Option(ctx.row).map(_.map(build)).getOrElse(Node.emptySeq),
      Option(ctx.status).map(build)) at ctx

  private def build(ctx: RowContext): TruthTableRow = {
    val model = ctx.model.toVector.map(build)
    TruthTableRow(
      Assignments(model at(model.head, model.last)),
      TruthTableMarker() at ctx.bar,
      ctx.eval.map(build)) at ctx
  }

  private def build(ctx: BoolContext): BooleanLit =
    ctx.t.getText match {
      case "T" | "⊤" => BooleanLit(value = true) at ctx
      case "F" | "⊥" => BooleanLit(value = false) at ctx
    }

  private def build(ctx: StatusContext): TruthTableStatus =
    Option(ctx.t) match {
      case Some(_) =>
        ctx.ID.getText match {
          case "Tautology" =>
            error(ctx.t, s"Unexpected assignments.")
            ContradictoryStatus() at ctx.t
          case "Contradictory" =>
            error(ctx.t, s"Unexpected assignments.")
            ContradictoryStatus() at ctx.t
          case "Contingent" =>
            ContingentStatus(
              ctx.tContingentAssignments.map(build),
              ctx.fContingentAssignments.map(build)) at ctx
          case t =>
            error(ctx.ID, s"Expecting either Tautology, Contradictory, or Contingent, but found $t instead.")
            ContradictoryStatus() at ctx
        }
      case _ =>
        ctx.ID.getText match {
          case "Tautology" => TautologyStatus() at ctx
          case "Contradictory" => ContradictoryStatus() at ctx
          case "Contingent" =>
            error(ctx.ID, s"Expecting truth assignments for Contingent.")
            ContradictoryStatus() at ctx
          case t =>
            error(ctx.ID, s"Expecting either Tautology, Contradictory, or Contingent, but found $t instead.")
            ContradictoryStatus() at ctx
        }
    }

  private def build(ctx: AssignmentsContext): Assignments =
    Assignments(ctx.bool.map(build)) at ctx

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


  private def token2type(token: Token): Type = {
    val r = token.getText match {
      case "B" => BType()
      case "Z" => ZType()
      case "Z8" => Z8Type()
      case "Z16" => Z16Type()
      case "Z32" => Z32Type()
      case "Z64" => Z64Type()
      case "N" => NType()
      case "N8" => N8Type()
      case "N16" => N16Type()
      case "N32" => N32Type()
      case "N64" => N64Type()
      case "S8" => S8Type()
      case "S16" => S16Type()
      case "S32" => S32Type()
      case "S64" => S64Type()
      case "U8" => U8Type()
      case "U16" => U16Type()
      case "U32" => U32Type()
      case "U64" => U64Type()
      case "R" => RType()
      case "F32" => F32Type()
      case "F64" => F64Type()
      case "BS" => BSType()
      case "ZS" => ZSType()
      case "Z8S" => Z8SType()
      case "Z16S" => Z16SType()
      case "Z32S" => Z32SType()
      case "Z64S" => Z64SType()
      case "NS" => NSType()
      case "N8S" => N8SType()
      case "N16S" => N16SType()
      case "N32S" => N32SType()
      case "N64S" => N64SType()
      case "S8S" => S8SType()
      case "S16S" => S16SType()
      case "S32S" => S32SType()
      case "S64S" => S64SType()
      case "U8S" => U8SType()
      case "U16S" => U16SType()
      case "U32S" => U32SType()
      case "U64S" => U64SType()
      case "RS" => RSType()
      case "F32S" => F32SType()
      case "F64S" => F64SType()
    }
    r at token
  }

  private def build(ctx: PrimFormulaContext): Exp = {
    val r = ctx match {
      case ctx: BooleanContext =>
        ctx.t.getText match {
          case "true" | "T" | "⊤" => BooleanLit(true)
          case "false" | "F" | "_|_" | "⊥" => BooleanLit(false)
        }
      case ctx: VarContext =>
        buildId(ctx.tb)
      case ctx: ParenContext =>
        val r = build(ctx.formula)
        r.hasParen = true
        r
      case ctx: ApplyResultContext =>
        val r = Result() at ctx.tb
        Apply(r, ctx.formula.map(build))
      case ctx: ResultContext => Result()
      case ctx: ApplyContext =>
        Apply(buildId(ctx.ID), ctx.formula.map(build))
      case ctx: IntContext =>
        val r = IntLit(ctx.NUM.getText, bitWidth, None)
        checkIntMaxMin(ctx.NUM, BigInt(r.value), r)
        r
      case ctx: IntLitContext =>
        val t = ctx.INT
        var text = t.getText
        val i = text.indexOf('"')
        val ts = text.substring(0, i)
        text = text.substring(i + 1, text.length - 1).replaceAll(" ", "")
        try {
          val tpe = ts match {
            case "z" => ZType()
            case "z8" => Z8Type()
            case "z16" => Z16Type()
            case "z32" => Z32Type()
            case "z64" => Z64Type()
            case "n" => NType()
            case "n8" => N8Type()
            case "n16" => N16Type()
            case "n32" => N32Type()
            case "n64" => N64Type()
            case "s8" => S8Type()
            case "s16" => S16Type()
            case "s32" => S32Type()
            case "s64" => S64Type()
            case "u8" => U8Type()
            case "u16" => U16Type()
            case "u32" => U32Type()
            case "u64" => U64Type()
          }
          tpe at t
          var bw = tpe.bitWidth
          if (bw == 0) bw = bitWidth
          val r = IntLit(text, bw, Some(tpe))
          r.normalize
          r
        } catch {
          case e: IllegalStateException =>
            error(ctx.INT, e.getMessage)
            IntLit("0", bitWidth, None)
          case _: Throwable =>
            error(ctx.INT, s"Invalid ${ts.toUpperCase} literal ${t.getText}.")
            IntLit("0", bitWidth, None)
        }
      case ctx: RLitContext =>
        var text = ctx.REAL.getText
        text = text.substring(2, text.length - 1).replaceAll(" ", "")
        RealLit(text)
      case ctx: FloatLitContext =>
        val floatText = ctx.FLOAT.getText
        if (floatText.last.toUpper == 'F')
          try floatText.toFloat catch {
            case _: Throwable =>
              error(ctx.FLOAT, s"Invalid F32 literal $floatText.")
          }
        else
          try floatText.toDouble catch {
            case _: Throwable =>
              error(ctx.FLOAT, s"Invalid F64 literal $floatText.")
          }
        FloatLit(ctx.FLOAT.getText)
      case ctx: TypeAccessContext =>
        val t = token2type(ctx.t)
        ctx.ID.getText match {
          case "Min" =>
            t match {
              case t: IntegralType =>
                t match {
                  case _: ZType => checkBitWidth(ctx.ID, "Z")
                  case _ =>
                }
                var bw = t.bitWidth
                if (bw == 0) bw = bitWidth
                IntMin(bw, t)
              case _ =>
                error(ctx.ID, s"Cannot access ${ctx.ID.getText} from ${ctx.t.getText}.")
                IntMin(bitWidth, ZType())
            }
          case "Max" =>
            t match {
              case t: IntegralType =>
                t match {
                  case _: ZType => checkBitWidth(ctx.ID, "Z")
                  case _: NType => checkBitWidth(ctx.ID, "N")
                  case _ =>
                }
                var bw = t.bitWidth
                if (bw == 0) bw = bitWidth
                IntMax(bw, t)
              case _ =>
                error(ctx.ID, s"Cannot access ${ctx.ID.getText} from ${ctx.t.getText}.")
                IntMin(bitWidth, ZType())
            }
          case "random" => Random(t)
          case s =>
            error(ctx.ID, s"Expecting Min, Max, or random instead of $s.")
            IntMin(8, ZType())
        }
      case ctx: SeqContext =>
        SeqLit(token2type(ctx.t).asInstanceOf[SeqType],
          Option(ctx.exp).map(_.map(build)).getOrElse(Node.emptySeq))
    }
    if (!(nodeLocMap isDefinedAt r)) r at ctx
    else r
  }

  private def build(ctx: FormulaContext): Exp = {
    ctx match {
      case ctx: PFormulaContext =>
        var e = build(ctx.primFormula)
        for (id <- Option(ctx.ID).map(_.toVector).getOrElse(ivectorEmpty)) {
          e = id.getText match {
            case "size" => Size(e) at id
            case f =>
              error(id, s"Unrecognized field access $f.")
              e
          }
        }
        e
      case ctx: BinaryContext =>
        val lExp = build(ctx.l)
        val rExp = build(ctx.r)
        val r = ctx.op.getText match {
          case "*" =>
            val r = Mul(lExp, rExp)
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp)) {
              checkIntMaxMin(ctx.op, lN * rN, r)
            }
            r
          case "/" =>
            val r = Div(lExp, rExp)
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp)) {
              if (rN == zero) error(rExp, s"Division by zero detected.")
              else checkIntMaxMin(ctx.op, lN / rN, r)
            }
            r
          case "%" =>
            val r = Rem(lExp, rExp)
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp)) {
              if (rN == zero) error(rExp, s"Division by zero detected.")
              else checkIntMaxMin(ctx.op, lN % rN, r)
            }
            r
          case "+" =>
            val r = Add(lExp, rExp)
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp))
              checkIntMaxMin(ctx.op, lN + rN, r)
            r
          case "-" =>
            val r = Sub(lExp, rExp)
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp))
              checkIntMaxMin(ctx.op, lN - rN, r)
            r
          case ":+" => Append(lExp, rExp)
          case "+:" => Prepend(lExp, rExp)
          case "<" => Lt(lExp, rExp)
          case "<=" | "≤" => Le(lExp, rExp)
          case ">" => Gt(lExp, rExp)
          case ">=" | "≥" => Ge(lExp, rExp)
          case ">>" => Shr(lExp, rExp)
          case ">>>" => UShr(lExp, rExp)
          case "<<" => Shl(lExp, rExp)
          case "=" => Eq(lExp, rExp)
          case "==" =>
            val r = Eq(lExp, rExp)
            if (constMap.isDefinedAt(lExp) && !constMap.isDefinedAt(rExp)) {
              val lLi = nodeLocMap(lExp)
              val rLi = nodeLocMap(rExp)
              val lExpS = input.substring(lLi.offset, lLi.offset + lLi.length)
              val rExpS = input.substring(rLi.offset, rLi.offset + rLi.length)
              r at ctx
              error(r, s"Logika does not support $lExpS == $rExpS; please rewrite it to $rExpS == $lExpS.")
            }
            r
          case "≠" => Ne(lExp, rExp)
          case "!=" =>
            val r = Ne(lExp, rExp)
            if (constMap.isDefinedAt(lExp) && !constMap.isDefinedAt(rExp)) {
              val lLi = nodeLocMap(lExp)
              val rLi = nodeLocMap(rExp)
              val lExpS = input.substring(lLi.offset, lLi.offset + lLi.length)
              val rExpS = input.substring(rLi.offset, rLi.offset + rLi.length)
              r at ctx
              error(r, s"Logika does not support $lExpS != $rExpS; please rewrite it to $rExpS != $lExpS.")
            }
            r
          case "and" | "&" | "∧" | "^" => And(lExp, rExp)
          case "xor" | "^|" => Xor(lExp, rExp)
          case "or" | "|" | "∨" | "V" => Or(lExp, rExp)
          case "implies" | "->" | "→" => Implies(lExp, rExp)
        }
        r at ctx.op
      case ctx: UnaryContext =>
        val exp = build(ctx.formula)
        val r = ctx.op.getText match {
          case "-" =>
            val r = Minus(exp)
            constMap.get(exp) match {
              case Some(n) => checkIntMaxMin(ctx.op, -n, r)
              case _ =>
            }
            r
          case "not" | "!" | "¬" | "~" => Not(exp)
        }
        r at ctx.op
      case ctx: QuantContext => build(ctx.qformula)
    }
  }

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
      build(ctx.qf)) at ctx
  }

  private def build(ctx: TypeContext): Type =
    token2type(ctx.t) at ctx

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
    Fun(buildId(ctx.ID), ctx.param.map(build), build(ctx.`type`), ctx.funDef.map(build)) at ctx
  }

  private def build(ctx: FunDefContext): FunDef = {
    if (ctx.ID.getText.indexOf('_') >= 0)
      error(ctx.ID, s"Underscore is a reserved character for fun case identifier.")
    FunDef(buildId(ctx.ID), build(ctx.c), build(ctx.e)) at ctx
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

  private def build(ctx: PrimExpContext): Exp = {
    val r = ctx match {
      case ctx: BooleanExpContext =>
        ctx.t.getText match {
          case "true" | "T" | "⊤" => BooleanLit(true)
          case "false" | "F" | "_|_" | "⊥" => BooleanLit(false)
        }
      case ctx: IntExpContext =>
        val r = IntLit(ctx.NUM.getText, bitWidth, None)
        checkIntMaxMin(ctx.NUM, BigInt(r.value), r)
        r
      case ctx: IntLitExpContext =>
        val t = ctx.INT
        var text = t.getText
        val i = text.indexOf('"')
        val ts = text.substring(0, i)
        text = text.substring(i + 1, text.length - 1).replaceAll(" ", "")
        try {
          val tpe = ts match {
            case "z" => ZType()
            case "z8" => Z8Type()
            case "z16" => Z16Type()
            case "z32" => Z32Type()
            case "z64" => Z64Type()
            case "n" => NType()
            case "n8" => N8Type()
            case "n16" => N16Type()
            case "n32" => N32Type()
            case "n64" => N64Type()
            case "s8" => S8Type()
            case "s16" => S16Type()
            case "s32" => S32Type()
            case "s64" => S64Type()
            case "u8" => U8Type()
            case "u16" => U16Type()
            case "u32" => U32Type()
            case "u64" => U64Type()
          }
          tpe at t
          var bw = tpe.bitWidth
          if (bw == 0) bw = bitWidth
          val r = IntLit(text, bw, Some(tpe))
          r.normalize
          r
        } catch {
          case e: IllegalStateException =>
            error(ctx.INT, e.getMessage)
            IntLit("0", bitWidth, None)
          case _: Throwable =>
            error(ctx.INT, s"Invalid ${ts.toUpperCase} literal ${t.getText}.")
            IntLit("0", bitWidth, None)
        }
      case ctx: RLitExpContext =>
        var text = ctx.REAL.getText
        text = text.substring(2, text.length - 1).replaceAll(" ", "")
        RealLit(text)
      case ctx: VarExpContext =>
        buildId(ctx.ID)
      case ctx: TypeMethodCallExpContext =>
        val t = token2type(ctx.t)
        ctx.ID.getText match {
          case "create" =>
            TypeMethodCallExp(t, buildId(ctx.ID),
              Option(ctx.exp).map(_.map(build)).getOrElse(Node.emptySeq))
          case s =>
            error(ctx.ID, s"Expecting create instead of $s.")
            TypeMethodCallExp(t, buildId(ctx.ID), Node.emptySeq)
        }
      case ctx: TypeAccessExpContext =>
        val t = token2type(ctx.t)
        ctx.ID.getText match {
          case "Min" =>
            t match {
              case t: IntegralType =>
                t match {
                  case _: ZType => checkBitWidth(ctx.ID, "Z")
                  case _ =>
                }
                var bw = t.bitWidth
                if (bw == 0) bw = bitWidth
                IntMin(bw, t)
              case _ =>
                error(ctx.ID, s"Cannot access ${ctx.ID.getText} from ${ctx.t.getText}.")
                IntMin(bitWidth, ZType())
            }
          case "Max" =>
            t match {
              case t: IntegralType =>
                t match {
                  case _: ZType => checkBitWidth(ctx.ID, "Z")
                  case _: NType => checkBitWidth(ctx.ID, "N")
                  case _ =>
                }
                var bw = t.bitWidth
                if (bw == 0) bw = bitWidth
                IntMax(bw, t)
              case _ =>
                error(ctx.ID, s"Cannot access ${ctx.ID.getText} from ${ctx.t.getText}.")
                IntMin(bitWidth, ZType())
            }
          case "random" => Random(t)
          case s =>
            error(ctx.ID, s"Expecting Min, Max, or random instead of $s.")
            IntMin(8, ZType())
        }
      case ctx: FloatLitExpContext =>
        val floatText = ctx.FLOAT.getText
        if (floatText.last.toUpper == 'F')
          try floatText.toFloat catch {
            case _: Throwable =>
              error(ctx.FLOAT, "Invalid F32 literal.")
          }
        else
          try floatText.toDouble catch {
            case _: Throwable =>
              error(ctx.FLOAT, "Invalid F64 literal.")
          }
        FloatLit(ctx.FLOAT.getText)
      case ctx: SeqExpContext =>
        SeqLit(token2type(ctx.t).asInstanceOf[SeqType],
          Option(ctx.exp).map(_.map(build)).getOrElse(Node.emptySeq))
    }
    r at ctx
  }

  private def build(ctx: ExpContext): Exp = {
    ctx match {
      case ctx: InvokeExpContext =>
        Apply(buildId(ctx.tb), Option(ctx.exp).map(_.map(build)).getOrElse(Node.emptySeq)) at ctx
      case ctx: PExpContext =>
        var e = build(ctx.primExp)
        for (id <- Option(ctx.ID).map(_.toVector).getOrElse(ivectorEmpty)) {
          e = id.getText match {
            case "clone" => e match {
              case e: Id => Clone(e) at id
              case _ =>
                error(id, s"Cloning is only allowed from a variable reference expression.")
                Clone(Id("???"))
            }
            case "size" => Size(e) at id
            case f =>
              error(id, s"Unrecognized field access $f.")
              e
          }
        }
        e
      case ctx: RandomIntExpContext => RandomInt()
      case ctx: ReadIntExpContext =>
        ReadInt(Option(ctx.STRING).map { x =>
          val text = x.getText
          StringLit(text.substring(1, text.length - 1))
        }) at ctx
      case ctx: ParenExpContext =>
        val r = build(ctx.exp)
        r.hasParen = true
        r
      case ctx: UnaryExpContext =>
        val exp = build(ctx.exp)
        val r = ctx.op.getText match {
          case "-" =>
            val r = Minus(exp)
            constMap.get(exp) match {
              case Some(n) => checkIntMaxMin(ctx.op, -n, r)
              case _ =>
            }
            r
          case "not" | "neg" | "!" | "¬" | "~" => Not(exp)
        }
        r at ctx.op
      case ctx: BinaryExpContext =>
        val lExp = build(ctx.l)
        val rExp = build(ctx.r)
        val r = ctx.op.getText match {
          case "*" =>
            val r = Mul(lExp, rExp)
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp))
              checkIntMaxMin(ctx.op, lN * rN, r)
            r
          case "/" =>
            val r = Div(lExp, rExp)
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp)) {
              if (rN == zero) error(rExp, s"Divide by zero detected.")
              else checkIntMaxMin(ctx.op, lN / rN, r)
            }
            r
          case "%" =>
            val r = Rem(lExp, rExp)
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp)) {
              if (rN == zero) error(rExp, s"Modulo by zero detected.")
              else checkIntMaxMin(ctx.op, lN % rN, r)
            }
            r
          case "+" =>
            val r = Add(lExp, rExp)
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp))
              checkIntMaxMin(ctx.op, lN + rN, r)
            r
          case "-" =>
            val r = Sub(lExp, rExp)
            for (lN <- constMap.get(lExp);
                 rN <- constMap.get(rExp))
              checkIntMaxMin(ctx.op, lN - rN, r)
            r
          case ":+" => Append(lExp, rExp)
          case "+:" => Prepend(lExp, rExp)
          case "<" => Lt(lExp, rExp)
          case "<=" | "≤" => Le(lExp, rExp)
          case ">" => Gt(lExp, rExp)
          case ">=" | "≥" => Ge(lExp, rExp)
          case ">>" => Shr(lExp, rExp)
          case ">>>" => UShr(lExp, rExp)
          case "<<" => Shl(lExp, rExp)
          case "==" =>
            val r = Eq(lExp, rExp)
            if (constMap.isDefinedAt(lExp) && !constMap.isDefinedAt(rExp)) {
              val lLi = nodeLocMap(lExp)
              val rLi = nodeLocMap(rExp)
              val lExpS = input.substring(lLi.offset, lLi.offset + lLi.length)
              val rExpS = input.substring(rLi.offset, rLi.offset + rLi.length)
              r at ctx
              error(r, s"Logika does not support $lExpS == $rExpS; please rewrite it to $rExpS == $lExpS.")
            }
            r
          case "!=" =>
            val r = Ne(lExp, rExp)
            if (constMap.isDefinedAt(lExp) && !constMap.isDefinedAt(rExp)) {
              val lLi = nodeLocMap(lExp)
              val rLi = nodeLocMap(rExp)
              val lExpS = input.substring(lLi.offset, lLi.offset + lLi.length)
              val rExpS = input.substring(rLi.offset, rLi.offset + rLi.length)
              r at ctx
              error(r, s"Logika does not support $lExpS != $rExpS; please rewrite it to $rExpS != $lExpS.")
            }
            r
          case "&" => And(lExp, rExp)
          case "^|" => Xor(lExp, rExp)
          case "|" => Or(lExp, rExp)
        }
        r at ctx.op
    }
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

  private def checkBitWidth(t: TerminalNode, ts: String): Unit =
    if (bitWidth == 0) error(t, s"$ts.${t.getText} is used, but bit-width is unbounded.")

  private def checkIntMaxMin(t: Token, value: BigInt, e: Exp): Unit = {
    if (value < minInt)
      error(t, s"""32-bit integer underflow is detected, please use z"..." to construct an arbitrary-precision integer.""")
    else if (value > maxInt)
      error(t, s"""32-bit integer overflow is detected, please use z"..." to construct an arbitrary-precision integer.""")
    else constMap(e) = value
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
            input: String, bitWidth: Int,
            isAutoEnabled: Boolean, maxErrors: Natural = 0)(
             implicit reporter: AccumulatingTagReporter): Option[UnitNode] = {
    class ParsingEscape extends RuntimeException
    object Mode extends Enumeration {
      val TruthTable, Sequent, Program = Value
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
          t.getText match {
            case "*" => Mode.TruthTable
            case "import" => Mode.Program
            case _ => Mode.Sequent
          }
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
      val r = {
        val parseTree = mode match {
          case Mode.TruthTable =>
            parser.file()
          case Mode.Sequent =>
            orientNewlines(tokenStream, isProgram = false)
            parser.file()
          case Mode.Program =>
            orientNewlines(tokenStream, isProgram = true)
            parser.file()
        }
        if (!reporter.hasError) {
          val ast = new Builder(fileUriOpt, input, bitWidth).build(parseTree)
          if (!reporter.hasError) Some(ast)
          else None
        } else None
      }
      r match {
        case Some(un) =>
          un.input = input
          Node.checkWellFormed(un, isAutoEnabled = isAutoEnabled)
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
    var inLogikaStmt = false
    val size = tokens.size
    while (tokens(i).getType != IntStream.EOF) {
      val token = tokens(i)
      token.getText match {
        case "(" => parens += 1
        case ")" if parens > 0 => parens -= 1
        case "l\"\"\"" => inLogikaStmt = true
        case "{" if inLogikaStmt => inLogikaStmt = false
        case "\"\"\"" => inLogikaStmt = false
        case text if token.getType == NL =>
          if (parens > 0 || inLogikaStmt) {
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