/*
Copyright (c) 2015, Robby, Kansas State University
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
import org.sireum.logika.util._
import org.sireum.util._
import org.sireum.util.jvm.Antlr4Util._

final private class Builder(implicit reporter: Reporter) {

  private implicit val nodeLocMap = midmapEmpty[AnyRef, LocationInfo]

  private def build(ctx: SequentFileContext): Sequent = {
    val r =
      if (ctx.proof != null) build(ctx.sequent).
        copy(proofOpt = Some(build(ctx.proof))) at ctx
      else build(ctx.sequent)
    r.nodeLocMap = nodeLocMap.asInstanceOf[MIdMap[Node, LocationInfo]]
    r
  }

  private def build(ctx: ProofFileContext): Proof = {
    val r = build(ctx.proof)
    r.nodeLocMap = nodeLocMap.asInstanceOf[MIdMap[Node, LocationInfo]]
    r
  }

  private def build(ctx: ProgramFileContext): Program = {
    val r = build(ctx.program)
    r.nodeLocMap = nodeLocMap.asInstanceOf[MIdMap[Node, LocationInfo]]
    r
  }

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
          errorIf(ctx.ID, ctx.tb, "i", "andi", "^i")
          AndIntro(num, exp, buildNum(ctx.lStep), buildNum(ctx.rStep))
        case ctx: AndElimContext =>
          val andStep = buildNum(ctx.andStep)
          ctx.tb.getText match {
            case "ande1" | "^e1" => AndElim1(num, exp, andStep)
            case "ande2" | "^e2" => AndElim2(num, exp, andStep)
            case tb => ctx.ID.getText match {
              case "e1" => AndElim1(num, exp, andStep)
              case "e2" => AndElim2(num, exp, andStep)
              case id =>
                error(ctx.tb, s"Unrecognized justification: $tb$id")
                AndElim1(num, exp, andStep)
            }
          }
        case ctx: OrIntroContext =>
          val orStep = buildNum(ctx.orStep)
          ctx.tb.getText match {
            case "ori1" | "Vi1" => OrIntro1(num, exp, orStep)
            case "ori2" | "Vi2" => OrIntro2(num, exp, orStep)
            case tb => ctx.ID.getText match {
              case "i1" => OrIntro1(num, exp, orStep)
              case "i2" => OrIntro2(num, exp, orStep)
              case id =>
                error(ctx.tb, s"Unrecognized justification: $tb$id")
                OrIntro1(num, exp, orStep)
            }
          }
        case ctx: OrElimContext =>
          val orStep = buildNum(ctx.orStep)
          val lSubProof = buildNum(ctx.lSubProof)
          val rSubProof = buildNum(ctx.rSubProof)
          errorIf(ctx.ID, ctx.tb, "e", "ore", "Ve")
          OrElim(num, exp, orStep, lSubProof, rSubProof)
        case ctx: ImpliesIntroContext =>
          val impliesStep = buildNum(ctx.impliesStep)
          errorIf(ctx.ID, ctx.tb, "i", "impliesi")
          ImpliesIntro(num, exp, impliesStep)
        case ctx: ImpliesElimContext =>
          val impliesStep = buildNum(ctx.impliesStep)
          val antecedentStep = buildNum(ctx.antecedentStep)
          errorIf(ctx.ID, ctx.tb, "e", "impliese")
          ImpliesElim(num, exp, impliesStep, antecedentStep)
        case ctx: NegIntroContext =>
          val subProof = buildNum(ctx.subProof)
          errorIf(ctx.ID, ctx.tb, "i", "noti", "negi")
          NegIntro(num, exp, subProof)
        case ctx: NegElimContext =>
          val step = buildNum(ctx.step)
          val notStep = buildNum(ctx.negStep)
          errorIf(ctx.ID, ctx.tb, "e", "note", "nege")
          NegElim(num, exp, step, notStep)
        case ctx: BottomElimContext =>
          val bottomStep = buildNum(ctx.bottomStep)
          errorIf(ctx.ID, ctx.tb, "e", "bottome", "falsee")
          BottomElim(num, exp, bottomStep)
        case ctx: PbcContext =>
          val subProof = buildNum(ctx.subProof)
          Pbc(num, exp, subProof)
        case ctx: ForallIntroContext =>
          val subProof = buildNum(ctx.subProof)
          errorIf(ctx.ID, ctx.tb, "i", "foralli", "alli", "Ai")
          ForallIntro(num, exp, subProof)
        case ctx: ForallElimContext =>
          val stepOrFact = build(ctx.stepOrFact)
          errorIf(ctx.ID, ctx.tb, "e", "foralle", "alle", "Ae")
          ForallElim(num, exp, stepOrFact, ctx.formula.map(build))
        case ctx: ExistsIntroContext =>
          val existsStep = buildNum(ctx.existsStep)
          errorIf(ctx.ID, ctx.tb, "i", "existsi", "somei", "Ei")
          ExistsIntro(num, exp, existsStep, ctx.formula.map(build))
        case ctx: ExistsElimContext =>
          val stepOrFact = build(ctx.stepOrFact)
          val subProof = buildNum(ctx.subProof)
          errorIf(ctx.ID, ctx.tb, "e", "existse", "somee", "Ee")
          ExistsElim(num, exp, stepOrFact, subProof)
        case ctx: AlgebraContext =>
          Algebra(num, exp, Option(ctx.steps).map(_.map(build)).
            getOrElse(Node.emptySeq))
        case ctx: InvariantContext =>
          Invariant(num, exp)
        case ctx: AutoContext =>
          Auto(num, exp, Option(ctx.stepOrFacts).map(_.map(build)).
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
            build(ctx.formula)) at(ctx.assume, ctx.ate)
        else
          PlainAssumeStep(assume,
            build(ctx.formula)) at(ctx.assume, ctx.ate)
      else
        ForallAssumeStep(assume, buildId(ctx.ID)) at ctx.ID
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
      case ctx: ParenContext => Paren(build(ctx.formula))
      case ctx: ResultContext => Result()
      case ctx: ApplyContext =>
        Apply(buildId(ctx.ID), ctx.formula.map(build))
      case ctx: IntContext => IntLit(BigInt(ctx.NUM.getText))
      case ctx: BigIntContext => IntLit(BigInt(ctx.STRING.getText))
      case ctx: SeqContext =>
        SeqLit(Option(ctx.exp).map(_.map(build)).getOrElse(Node.emptySeq))
      case ctx: BinaryContext =>
        val apply =
          ctx.op.getText match {
            case "*" => Mul
            case "/" => Div
            case "%" => Rem
            case "+" => Add
            case "-" => Sub
            case "<" => Lt
            case "<=" | "≤" => Le
            case ">" => Gt
            case ">=" | "≥" => Ge
            case "=" | "==" => Eq
            case "!=" | "≠" => Ne
            case "and" | "&&" | "∧" => And
            case "or" | "||" | "∨" => Or
            case "implies" | "->" | "→" => Implies
          }
        apply(build(ctx.l), build(ctx.r))
      case ctx: UnaryContext =>
        val apply =
          ctx.op.getText match {
            case "-" => Minus
            case "not" | "!" | "~" | "¬" => Not
          }
        apply(build(ctx.formula))
      case ctx: QuantContext => build(ctx.qformula)
    }
    r at ctx
  }

  private def build(ctx: QformulaContext): Quant = {
    val apply =
      ctx.q.getText match {
        case "forall" | "all" | "A" | "∀" => ForAll
        case "exists" | "some" | "E" | "∃" => Exists
      }
    apply(ctx.vars.map(buildId), Option(ctx.`type`).map(build),
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

  private def build(ctx: NumOrIdContext): NumOrId =
    Option(ctx.ID).map(buildId).getOrElse(buildNum(ctx.NUM))

  private def build(ctx: ProgramContext): Program =
    if (ctx.tb != null) {
      errorIf(ctx.org, ctx.sireum, "org", "sireum")
      val block = build(ctx.stmts)
      lgk(ctx.lgk)
      val r =
        if (ctx.lgk != null) Program(build(ctx.facts), block)
        else Program(Facts(Node.emptySeq), block)
      r at ctx
    } else Program(Facts(Node.emptySeq), Block(Node.emptySeq))

  private def lgk(ctx: LgkContext): Unit = {
    if (ctx != null && ctx.ID != null)
      errorIf(ctx.ID, "l")
  }

  private def build(ctx: FactsContext): Facts =
    Facts(Option(ctx.factOrFun).map(_.map(build)).
      getOrElse(Node.emptySeq) at(ctx.ftb, ctx.te))

  private def build(ctx: FactOrFunContext): FactOrFun =
    if (ctx.fact != null) build(ctx.fact) else build(ctx.fun)

  private def build(ctx: FactContext): Fact =
    Fact(buildId(ctx.ID), build(ctx.formula)) at ctx

  private def build(ctx: FunContext): Fun =
    Fun(buildId(ctx.ID), ctx.param.map(build), build(ctx.`type`)) at ctx

  private def build(ctx: ParamContext): Param =
    Param(buildId(ctx.ID), build(ctx.`type`)) at ctx

  private def build(ctx: StmtsContext): Block =
    Block(Option(ctx.stmt).map(_.map(build)).
      getOrElse(Node.emptySeq))

  private def build(ctx: StmtContext): Stmt = {
    val r =
      ctx match {
        case ctx: VarDeclStmtContext =>
          VarDecl(ctx.modifier.getText == "var", buildId(ctx.ID),
            build(ctx.`type`))
        case ctx: AssignVarStmtContext =>
          Assign(buildId(ctx.ID), build(ctx.exp))
        case ctx: AssertStmtContext => Assert(build(ctx.exp))
        case ctx: IfStmtContext =>
          If(build(ctx.exp), build(ctx.ts),
            Option(ctx.fs).map(build).getOrElse(Block(Node.emptySeq)))
        case ctx: WhileStmtContext =>
          While(build(ctx.exp), build(ctx.stmts),
            Option(ctx.loopInvariant).map(build).getOrElse(
              LoopInv(Inv(Node.emptySeq), Modifies(Node.emptySeq))))
        case ctx: PrintStmtContext =>
          errorIf(ctx.s, "s")
          Print(ctx.op.getText == "println", StringLit(ctx.STRING.getText))
        case ctx: SeqAssignStmtContext =>
          SeqAssign(buildId(ctx.tb), build(ctx.index), build(ctx.r))
        case ctx: MethodDeclStmtContext =>
          MethodDecl(buildId(ctx.ID),
            Option(ctx.param).map(_.map(build)).getOrElse(Node.emptySeq),
            Option(ctx.`type`).map(build),
            Option(ctx.methodContract).map(build).getOrElse(
              MethodContract(Requires(Node.emptySeq),
                Modifies(Node.emptySeq),
                Ensures(Node.emptySeq))),
            build(ctx.stmts), Option(ctx.exp).map(build))
        case ctx: LogikaStmtContext =>
          (ctx.proof, ctx.sequent, ctx.invariants) match {
            case (proof, null, null) => ProofStmt(build(proof))
            case (null, sequent, null) => SequentStmt(build(sequent))
            case (null, null, invariants) => InvStmt(build(invariants))
          }
        case ctx: ExpStmtContext => ExpStmt(build(ctx.exp))
      }
    r at ctx
  }

  private def build(ctx: ExpContext): Exp = {
    val r = ctx match {
      case ctx: BooleanExpContext =>
        ctx.t.getText match {
          case "true" | "T" | "⊤" => BooleanLit(true)
          case "false" | "F" | "_|_" | "⊥" => BooleanLit(false)
        }
      case ctx: IntExpContext => IntLit(BigInt(ctx.NUM.getText))
      case ctx: IdExpContext =>
        val r = buildId(ctx.tb)
        if (ctx.exp != null) {
          Apply(r,
            Option(ctx.exp).map(_.map(build)).getOrElse(Node.emptySeq))
        } else ctx.te match {
          case te if te.getText == "size" => Size(r)
          case te if te.getText == "clone" => Clone(r)
          case null => r
          case te =>
            reporter.error(ctx.te.getLine, ctx.te.getCharPositionInLine,
              ctx.te.getStartIndex,
              s"Expecting size or clone instead of ${te.getText}")
            r
        }
      case ctx: BigIntExpContext => IntLit(BigInt(ctx.STRING.getText))
      case ctx: SeqExpContext =>
        SeqLit(Option(ctx.exp).map(_.map(build)).getOrElse(Node.emptySeq))
      case ctx: ReadIntExpContext =>
        ReadInt(Option(ctx.STRING).map(x => StringLit(x.getText)))
      case ctx: ParenExpContext => Paren(build(ctx.exp))
      case ctx: UnaryExpContext =>
        val apply =
          ctx.op.getText match {
            case "-" => Minus
            case "!" => Not
          }
        apply(build(ctx.exp))
      case ctx: BinaryExpContext =>
        val apply =
          ctx.op.getText match {
            case "*" => Mul
            case "/" => Div
            case "%" => Rem
            case "+" => Add
            case "-" => Sub
            case "<" => Lt
            case "<=" => Le
            case ">" => Gt
            case ">=" => Ge
            case "==" => Eq
            case "!=" => Ne
            case "&&" => And
            case "||" => Or
            case ":+" => Append
            case "+:" => Prepend
          }
        apply(build(ctx.l), build(ctx.r))
    }
    r at ctx
  }

  private def build(ctx: LoopInvariantContext): LoopInv = {
    val inv = Inv(Option(ctx.formula).map(_.map(build)).
      getOrElse(Node.emptySeq))

    LoopInv(
      if (inv.exps.isEmpty) inv at ctx.itb
      else inv at(ctx.itb, inv.exps.last),
      build(ctx.modifies)) at(ctx.tb, ctx.te)
  }

  private def build(ctx: ModifiesContext): Modifies = {
    val ids = ctx.ID.map(buildId)
    Modifies(ids) at(ctx.tb, ids.last)
  }

  private def build(ctx: MethodContractContext): MethodContract =
    MethodContract(
      Requires(Option(ctx.rs).map(_.map(build)).getOrElse(Node.emptySeq)),
      Option(ctx.modifies).map(build).getOrElse(Modifies(Node.emptySeq)),
      Ensures(Option(ctx.rs).map(_.map(build)).getOrElse(Node.emptySeq))) at
      (ctx.tb, ctx.te)

  private def build(ctx: InvariantsContext): Inv =
    Inv(Option(ctx.formula).map(_.map(build)).getOrElse(Node.emptySeq)) at
      (ctx.tb, ctx.te)

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

  private def errorIf(t: Token, tText: String): Unit = {
    if (t.getText != tText)
      error(t, s"Expecting $tText instead of ${t.getText}")
  }

  private def errorIf(id: Token, op: Token,
                      idText: String, opTexts: String*): Unit = {
    if (!(opTexts.contains(op.getText) || id.getText == idText))
      error(op,
        s"Unrecognized justification: ${op.getText}${id.getText}")
  }

  private def error(t: Token, msg: String): Unit =
    reporter.error(t.getLine, t.getCharPositionInLine, t.getStartIndex, msg)

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

  private final val (sequentType, proofType, programType) = {
    import scala.reflect.runtime.universe._
    (typeOf[Sequent], typeOf[Proof], typeOf[Program])
  }

  import org.antlr.v4.runtime._
  import scala.reflect.runtime.universe._

  def apply[T <: UnitNode](input: String,
                           maxErrors: Natural = 0,
                           reporter: Reporter = ConsoleReporter)
                          (implicit tag: TypeTag[T]): Option[T] = {
    class ParsingEscape extends RuntimeException

    val sr = new StringReader(input)
    val inputStream = new ANTLRInputStream(sr)
    val lexer = new Antlr4LogikaLexer(inputStream)
    val tokenStream = new CommonTokenStream(lexer)
    val parser = new Antlr4LogikaParser(tokenStream)
    parser.removeErrorListeners()
    var success = true
    parser.addErrorListener(new BaseErrorListener {
      var errors = 0

      override def syntaxError(recognizer: Recognizer[_, _],
                               offendingSymbol: Any,
                               line: PosInteger,
                               charPositionInLine: PosInteger,
                               msg: String,
                               e: RecognitionException): Unit = {
        success = false
        val token = offendingSymbol.asInstanceOf[Token]
        val start = token.getStartIndex
        reporter.error(line, charPositionInLine, start, msg)
        errors += 1
        if (maxErrors > 0 && errors >= maxErrors) {
          throw new ParsingEscape
        }
      }
    })
    implicit val rptr = new Reporter {
      override def error(message: String): Unit = {
        success = false
        reporter.error(message)
      }

      override def error(line: PosInteger, column: PosInteger,
                         offset: Natural,
                         message: String): Unit = {
        success = false
        reporter.error(line, column, offset, message)
      }
    }
    try {
      val r =
        tag.tpe match {
          case `sequentType` =>
            orientNewlines(tokenStream, isProgram = false)
            val parseTree = parser.sequentFile()
            if (success) {
              val ast = new Builder().build(parseTree)
              if (success) Some(ast.asInstanceOf[T])
              else None
            } else None
          case `proofType` =>
            orientNewlines(tokenStream, isProgram = false)
            val parseTree = parser.proofFile()
            if (success) {
              val ast = new Builder().build(parseTree)
              if (success) Some(ast.asInstanceOf[T])
              else None
            } else None
          case `programType` =>
            orientNewlines(tokenStream, isProgram = true)
            val parseTree = parser.programFile()
            if (success) {
              val ast = new Builder().build(parseTree)
              if (success) Some(ast.asInstanceOf[T])
              else None
            } else None
        }
      r match {
        case Some(un) =>
          Node.checkWellFormed(un)
          if (success) r else None
        case None => None
      }
    } catch {
      case _: ParsingEscape => None
    }
  }

  private def orientNewlines(cts: CommonTokenStream,
                             isProgram: Boolean): Unit = {
    import Antlr4LogikaLexer.{ID, NL, NUM}
    cts.fill()
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

  private def hide(t: Token): Unit = {
    t.asInstanceOf[CommonToken].setChannel(Token.HIDDEN_CHANNEL)
  }
}
