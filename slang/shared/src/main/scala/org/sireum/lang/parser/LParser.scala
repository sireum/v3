/*
 Copyright (c) 2017, Robby, Kansas State University
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

package org.sireum.lang.parser

import scala.collection.immutable.ListSet
import scala.meta._
import scala.meta.inputs.Input
import scala.meta.internal.parsers.{InfixMode, ScalametaParser}
import scala.meta.internal.tokens.TokenInfo
import scala.meta.parsers.{Parse, ParseException, Parsed}
import scala.meta.tokenizers.TokenizeException
import scala.meta.tokens.TokensHelper
import scala.meta.tokens.Token.{BOF, Colon, Comma, Dot, EOF, Ident, KwCase, KwDef, KwIf, KwVal, LeftBrace, LeftBracket, LeftParen, RightBrace, RightBracket, RightParen}

object LParser {

  final case class DefContract(requires: List[(Option[Ident], Term)],
                               modifies: List[Term],
                               ensures: List[(Option[Ident], Term)],
                               subs: List[SubContract])

  final case class SubContract(id: Ident, params: List[(Boolean, Ident)], contract: DefContract)

  sealed trait WhereDef

  final case class ValWhereDef(id: Ident, tipe: Type, exp: Term) extends WhereDef

  final case class DefWhereDef(id: Ident, params: List[(Ident, Type)], rTipe: Type, defs: List[SpecDef]) extends WhereDef

  final case class SpecDef(idOpt: Option[Ident],
                           exp: Term,
                           isOtherwise: Boolean,
                           patternOpt: Option[Pat.Arg],
                           guardOpt: Option[Term],
                           where: List[WhereDef])

  sealed trait LClause

  final case class Invariants(value: List[(Option[Ident], Term)]) extends LClause

  final case class Facts(value: List[(Ident, Term)]) extends LClause

  final case class Theorem(value: List[(Ident, Sequent)]) extends LClause

  final case class Sequent(premises: List[Term], conclusions: List[Term], proofOpt: Option[Proof]) extends LClause

  final case class Proof(steps: List[ProofStep]) extends LClause

  sealed trait ProofStep {
    def step: Token.Constant.Int
  }

  final case class SubProof(step: Token.Constant.Int,
                            assumeStep: AssumeProofStep,
                            steps: List[ProofStep]) extends ProofStep

  final case class Ps(step: Token.Constant.Int, exp: Term, just: Just) extends ProofStep

  sealed trait AssumeProofStep extends ProofStep

  final case class Aps(step: Token.Constant.Int, exp: Term) extends AssumeProofStep

  final case class ForallIntroAps(step: Token.Constant.Int, fresh: List[(List[Ident], Option[Either[Type, (Term, Boolean, Term, Boolean)]])]) extends AssumeProofStep

  final case class ExistsElimAps(step: Token.Constant.Int, fresh: List[(List[Ident], Option[Either[Type, (Term, Boolean, Term, Boolean)]])], exp: Term) extends AssumeProofStep

  sealed trait Just {
    def pos: Position
  }

  final case class Premise(pos: Position) extends Just

  final case class AndIntro(pos: Position, steps: List[Token.Constant.Int]) extends Just

  final case class AndElim(pos: Position, is1: Boolean, andStep: Token.Constant.Int) extends Just

  final case class OrIntro(pos: Position, is1: Boolean, step: Token.Constant.Int) extends Just

  final case class OrElim(pos: Position, orStep: Token.Constant.Int, subProofSteps: List[Token.Constant.Int]) extends Just

  final case class ImplyIntro(pos: Position, subProofStep: Token.Constant.Int) extends Just

  final case class ImplyElim(pos: Position, implyStep: Token.Constant.Int, steps: List[Token.Constant.Int]) extends Just

  final case class NegIntro(pos: Position, subProofStep: Token.Constant.Int) extends Just

  final case class NegElim(pos: Position, step: Token.Constant.Int, negStep: Token.Constant.Int) extends Just

  final case class BottomElim(pos: Position, subProofStep: Token.Constant.Int) extends Just

  final case class Pbc(pos: Position, subProofStep: Token.Constant.Int) extends Just

  final case class ForallIntro(pos: Position, subProofStep: Token.Constant.Int) extends Just

  final case class ForallElim(pos: Position, forallStep: Token.Constant.Int, args: List[Term]) extends Just

  final case class ExistsIntro(pos: Position, existsStep: Token.Constant.Int, args: List[Term]) extends Just

  final case class ExistsElim(pos: Position, existsStep: Token.Constant.Int, subProofStep: Token.Constant.Int) extends Just

  final case class Fact(pos: Position, ref: Term.Ref) extends Just

  final case class Invariant(pos: Position, refOpt: Option[Term.Ref]) extends Just

  final case class Subst(pos: Position, isRight: Boolean, eqStep: Token.Constant.Int, step: Token.Constant.Int) extends Just

  final case class Auto(pos: Position, isAlgebra: Boolean, steps: List[Token.Constant.Int]) extends Just

  final case class Coq(pos: Position, path: Token.Constant.String, steps: List[Token.Constant.Int]) extends Just

  final case class TruthTable(stars: List[Int],
                              vars: List[Ident],
                              sepColumn: Int,
                              formula: Either[(Int, Sequent), Term],
                              rows: List[TruthTableRow],
                              conclusionOpt: Option[TruthTableConclusion])

  final case class BLit(column: Int, value: Boolean)

  final case class TruthTableRow(assignment: List[BLit],
                                 column: Int,
                                 values: List[BLit])

  sealed trait TruthTableConclusion

  final case object Valid extends TruthTableConclusion

  final case class Invalid(assignments: List[List[BLit]]) extends TruthTableConclusion

  final case object Tautology extends TruthTableConclusion

  final case object Contradiction extends TruthTableConclusion

  final case class Contingent(trueAssignments: List[List[BLit]],
                              falseAssignments: List[List[BLit]])
    extends TruthTableConclusion

  val forallTokens = ListSet("∀", "A", "all", "forall")
  val existsTokens = ListSet("∃", "E", "some", "exists")
  val quantTokens: ListSet[String] = forallTokens ++ existsTokens
  val lStmtFirst = ListSet("requires", "theorem", "fact")
  val implyInternalSym = "$->:"
  val sequentTokens = Set("⊢", "|-")
  val internalOpMap = Map(
    "→" -> implyInternalSym,
    "->" -> implyInternalSym,
    "∧" -> "&",
    "^" -> "&",
    "∨" -> "|",
    "V" -> "|",
    "¬" -> "!",
    "≠" -> "!=",
    "≤" -> "<=",
    "≥" -> ">=",
    "⊤" -> "T",
    "⊥" -> "F",
    "≡" -> "==",
    "⊻" -> "|^"
  )

  def isSequentToken(t: Token): Boolean = t.is[Ident] && sequentTokens.contains(t.text)

  lazy val parseTerm: Parse[Term] = toParse(_.parseTerm())

  implicit class ParseString(text: String)(implicit dialect: Dialect) {
    def parseFormula: Parsed[Term] = parseTerm(Input.String(text), dialect)
  }

  def toParse[T](fn: LParser => T): Parse[T] = (input, dialect) => {
    try {
      val parser = new LParser(input, dialect)
      Parsed.Success(fn(parser))
    } catch {
      case details@TokenizeException(pos, message) =>
        Parsed.Error(pos, message, details)
      case details@ParseException(pos, message) =>
        Parsed.Error(pos, message, details)
    }
  }
}

import LParser._

final class LParser(input: Input, dialect: Dialect) extends ScalametaParser(input, dialect) {
  parser =>

  object loutPattern extends PatternContextSensitive {
    override def infixTypeRest(t: Type, mode: InfixMode.Value): Type = {
      token match {
        case Ident(value) if value.forall(Character.isJavaIdentifierPart) => t
        case _ => super.infixTypeRest(t, mode)
      }
    }

    def argType(): Type = typ()

    def functionArgType(): Type.Arg = paramType()
  }

  class LimitingTokenIterator(var i: Int, val end: Int) extends TokenIterator {
    def hasNext: Boolean = i < parserTokens.length - 1

    def next(): Token = {
      if (!hasNext) throw new NoSuchElementException()
      i += 1
      token
    }

    def prevTokenPos: Int = if (i > 0) parserTokenPositions(Math.min(i, parserTokens.length - 1) - 1) else -1

    def tokenPos: Int = if (i > -1) parserTokenPositions(Math.min(i, parserTokens.length - 1)) else -1

    def token: Token = if (i > end) parserTokens(parserTokens.length - 1) else parserTokens(i)

    def fork: TokenIterator = new LimitingTokenIterator(i, end)
  }

  val justFirst = Set("assume", "premise", "Vi1", "Vi2", "Ve", "pbc", "Ai", "alli", "foralli",
    "Ae", "alle", "foralle", "Ei", "somei", "existsi", "Ee", "somee", "existse",
    "fact", "invariant", "subst", "algebra", "auto", "coq"
  )

  @inline def aheadNF[T](body: => T): T = {
    next()
    body
  }

  @inline def tokenCurrOrAfterNl(p: => Boolean): Boolean =
    p || TokensHelper.isNl(token) && ahead(p)


  val justPrefix: List[() => Option[(String, Int)]] = List(
    () => {
      var text = "∧"
      val r = isIdentOf("&") &&
        ahead {
          text += token.text
          (isIdentOf("i") || isIdentOf("e1") || isIdentOf("e2")) && aheadNF(token.is[Token.Constant.Int])
        }
      if (r) Some((text, 2)) else None
    },
    () => {
      var text = "∨"
      val r = isIdentOf("|") &&
        ahead {
          text += token.text
          (isIdentOf("i1") || isIdentOf("i2") || isIdentOf("e")) && aheadNF(token.is[Token.Constant.Int])
        }
      if (r) Some((text, 2)) else None
    },
    () => {
      var text = token.text
      val r = (isIdentOf(implyInternalSym) || isIdentOf("!") || isIdentOf("∀") || isIdentOf("∃")) &&
        ahead {
          text += token.text
          (isIdentOf("i") || isIdentOf("e")) && aheadNF(token.is[Token.Constant.Int])
        }
      if (r) Some((text, 2)) else None
    },
    () => {
      if (isIdentOf("F") && ahead(isIdentOf("e") && aheadNF(token.is[Token.Constant.Int]))) Some(("⊥e", 2)) else None
    },
    () => {
      if ( {
        val t1 = token
        isIdentOf("_") && ahead {
          val t2 = token
          isIdentOf("|") && t2.pos.start.offset == t1.pos.start.offset + 1 && aheadNF {
            val t3 = token
            isIdentOf("_") && t3.pos.start.offset == t2.pos.start.offset + 1 &&
              aheadNF(isIdentOf("e") && aheadNF(token.is[Token.Constant.Int]))
          }
        }
      }) Some(("⊥e", 4)) else None
    }
  )

  {
    in = new LimitingTokenIterator(0, parserTokens.length - 1)

    val sTokens = TokensHelper.extractArray(scannerTokens)
    val pTokens = TokensHelper.extractArray(parserTokens)
    var iS = 0
    var iP = 0
    while (iS < sTokens.length) {
      sTokens(iS) match {
        case t@Ident(value) => internalOpMap.get(value) match {
          case Some(op) =>
            val t2 = t.copy(value = op)
            sTokens(iS) = t2
            while (t.isNot[Ident] || (t ne pTokens(iP))) iP += 1
            pTokens(iP) = t2
          case _ =>
        }
        case _ =>
      }
      iS += 1
    }
  }


  def findJust(): (Int, String, Int) = {
    def continue: Boolean =
      if (token.is[RightBrace] || token.is[EOF]) false
      else if (TokensHelper.isNl(token) && ahead(token.is[Token.Constant.Int] && aheadNF(token.is[Dot]))) false
      else true

    def find(): Option[(String, Int)] = {
      if (token.is[Ident] && justFirst.contains(token.text))
        return Some((token.text, 1))
      for (jp <- justPrefix) {
        val r = jp()
        if (r.isDefined) return r
      }
      None
    }

    val oldIn = in
    try {
      in = oldIn.fork
      var just: Option[(String, Int)] = None
      while (continue && just.isEmpty) {
        next()
        just = find()
      }
      if (just.isDefined) (in.asInstanceOf[LimitingTokenIterator].i, just.get._1, just.get._2) else (-1, "", 0)
    } finally in = oldIn
  }

  def acceptToken[T <: Token : TokenInfo]: T = {
    val t = token
    accept[T]
    t.asInstanceOf[T]
  }

  def acceptInt: Token.Constant.Int = acceptToken[Token.Constant.Int]

  /** {{{
   *  SimpleExpr     ::= QuantExpr
   *                   |  ... super.simpleExpr()
   *  }}}
   */
  override def simpleExpr(): Term = {
    if (token.is[Ident] && quantTokens.contains(token.text)) quantExpr()
    else super.simpleExpr()
  }

  /** {{{
   *  QuantExpr      ::= QuantOp Idents [ `:' Domain ] [nl] Expr
   *
   *  Idents         ::= Ident { `,' Ident }
   *
   *  QuantOp        ::= Ident<∀> | Ident<A> | Ident<all> | Ident<forall> | Ident<∃> | Ident<E> | Ident<some> | Ident<exists>
   *
   *  Domain         ::= ( `(' | `<' | `[' ) Expr ',' Expr ( `)' | `>' | `]' )
   *                   |  Type
   *  }}}
   */
  private def quantExpr(): Term = autoPos {
    def acceptKw(kws: ListSet[String]): String = {
      val text = token.text
      if (token.is[Ident] && kws.contains(text)) {
        val r = token.text
        next()
        r
      } else {
        reporter.syntaxError(s"Either ${kws.mkString(" or ")} expected but $text found", at = token)
      }
    }

    acceptKw(quantTokens)
    val isForAll = forallTokens.contains(token.text)

    val ids: Term = identsTerm()

    if (token.isNot[Colon]) {
      newLineOpt()
      val e = expr()
      Term.Apply(
        Term.Name("L$Quant"),
        List[Term](Lit.Boolean(isForAll), ids, e))
    } else {
      next()
      domain() match {
        case Left(t) =>
          newLineOpt()
          val e = expr()
          Term.Apply(
            Term.Name("L$Quant"),
            List[Term](
              Lit.Boolean(isForAll),
              Term.Ascribe(ids, t),
              e))
        case Right((lo, loExact, hi, hiExact)) =>
          newLineOpt()
          val e = expr()
          Term.Apply(
            Term.Name("L$Quant"),
            List[Term](
              Lit.Boolean(isForAll),
              ids,
              Term.Tuple(List(lo, Lit.Boolean(loExact), hi, Lit.Boolean(hiExact))),
              e))
      }
    }
  }

  def domain(): Either[Type, (Term, Boolean, Term, Boolean)] =
    if (token.is[LeftParen] || token.is[LeftBracket]) {
      val loExact = token.is[LeftBracket]
      next()
      val lo = expr()
      accept[Comma]
      val hi = expr()
      val hiExact = token.is[RightBracket]
      if (hiExact) next() else accept[RightParen]
      Right((lo, loExact, hi, hiExact))
    } else Left(loutPattern.typ())

  def idents(): List[Ident] = {
    var ids = List(acceptToken[Ident])
    while (token.is[Comma]) {
      next()
      ids ::= acceptToken[Ident]
    }
    ids.reverse
  }

  def identsTerm(): Term = {
    val ids = idents().map(t => atPos(t.start, t.end)(Term.Name(t.text)))
    if (ids.size == 1) ids.head
    else Term.Tuple(ids.reverse)
  }

  /** {{{
   *  DefContract    ::= BOF {nl}
   *                     [ Ident<requires> {nl} NamedExprs ]
   *                     [ Ident<modifies> {nl} Expr { `,' {nl} Expr } ] {nl}
   *                     [ Ident<ensures> {nl} NamedExprs ]
   *                     { SubContract {nl} }
   *                     EOF
   *
   *  NamedExprs     ::= NamedExpr {nl} { NamedExpr {nl} }
   *
   *  NamedExpr      ::= [ Ident `:' {nl} ] Expr
   *
   *  SubContract    ::= def Ident `(' [ PureOpt Ident {`,' PureOpt Ident} `)' {nl} DefContract
   *
   *  PureOpt        ::= [ `@' Ident<pure> ]
   *  }}}
   */
  def defContract(): DefContract = {
    def pureOpt(): Boolean = {
      if (token.is[Token.At] && ahead(isIdentOf("pure"))) {
        nextTwice()
        true
      } else false
    }

    def subContract(): List[SubContract] = {
      var r = List[SubContract]()
      while (token.isNot[EOF]) {
        accept[KwDef]
        val ident = acceptToken[Ident]
        accept[LeftParen]
        val params = if (token.isNot[RightParen]) {
          var ps = List[(Boolean, Ident)]((pureOpt(), acceptToken[Ident]))
          while (token.is[Comma]) {
            next()
            ps ::= (pureOpt(), acceptToken[Ident])
          }
          ps
        } else List()
        accept[RightParen]
        newLinesOpt()
        r ::= SubContract(ident, params.reverse, defContract())
      }
      r.reverse
    }

    accept[BOF]
    newLinesOpt()
    val requires: List[(Option[Ident], Term)] = if (isIdentOf("requires")) {
      next()
      newLinesOpt()
      namedExprs(!(isIdentOf("modifies") || isIdentOf("ensures") || token.is[KwDef] || token.is[EOF]))
    } else List()
    val mods: List[Term] = modifies()
    val ensures: List[(Option[Ident], Term)] = if (isIdentOf("ensures")) {
      next()
      newLinesOpt()
      namedExprs(!(token.is[KwDef] || token.is[EOF]))
    } else List()
    val r = DefContract(requires, mods, ensures, subContract())
    accept[EOF]
    r
  }

  def modifies(): List[Term] = if (isIdentOf("modifies")) {
    next()
    newLinesOpt()
    var r = List[Term](expr())
    while (token.is[Comma]) {
      next()
      newLinesOpt()
      r ::= expr()
    }
    newLinesOpt()
    r.reverse
  } else List()

  def namedExpr(): (Option[Ident], Term) =
    if (token.is[Ident] && ahead(token.is[Colon])) {
      val ident = acceptToken[Ident]
      next()
      newLinesOpt()
      (Some(ident), expr())
    } else {
      (None, expr())
    }

  def namedExprs(continue: => Boolean): List[(Option[Ident], Term)] = {
    var r = List(namedExpr())
    newLinesOpt()
    while (continue) {
      r ::= namedExpr()
      newLinesOpt()
    }
    r.reverse
  }

  /** {{{
   *  SpecDefs       ::= BOF
   *                     {nl} SpecDef {nl} { SpecDef {nl} } [ WhereDefs {nl} ]
   *                     EOF
   *
   *  SpecDef        ::= `=' NamedExpr [`,' ( [ case Pattern ] [ Guard ] | Ident<otherwise> ) ] {nl} [ WhereDefs ]
   *
   *  WhereDefs      ::= Ident<where> {nl} WhereDef { {nl} WhereDef }
   *
   *  WhereDef       ::= val Ident `:' Type `=' Expr
   *                   |  def Ident `(' SpecParams `)' `:' Type {nl} SpecDef { {nl} SpecDef }
   *
   *  SpecParams     ::= SpecParam { `,' SpecParam }
   *
   *  SpecParam      ::= Id `:' Type
   *  }}}
   */
  def specDefs(): (List[SpecDef], List[WhereDef]) = {
    accept[BOF]
    newLinesOpt()
    var sds = List(specDef())
    newLinesOpt()
    while (token.isNot[EOF]) {
      sds ::= specDef()
      newLinesOpt()
    }
    val r = (sds.reverse, if (isIdentOf("where")) {
      val wds = whereDefs()
      newLinesOpt()
      wds
    } else List())
    accept[EOF]
    r
  }

  def specDef(): SpecDef = {
    accept[Token.Equals]
    val (idOpt, e) = namedExpr()
    val (isOtherwise, patternOpt, guardOpt) = if (token.is[Comma]) {
      next()
      val pOpt = if (token.is[KwCase]) {
        next()
        Some(pattern())
      } else None
      val gOpt = if (token.is[KwIf]) {
        next()
        Some(expr())
      } else None
      (false, pOpt, gOpt)
    } else if (isIdentOf("otherwise")) (true, None, None)
    else (false, None, None)
    newLinesOpt()
    val wds = if (isIdentOf("where")) whereDefs() else List()
    SpecDef(idOpt, e, isOtherwise, patternOpt, guardOpt, wds)
  }

  private def whereDefs(): List[WhereDef] = {
    def specParam(): (Ident, Type) = {
      val id = acceptToken[Ident]
      accept[Colon]
      (id, loutPattern.typ())
    }

    def specParams(): List[(Ident, Type)] = {
      var r = List(specParam())
      while (token.is[Comma]) {
        next()
        r ::= specParam()
      }
      r.reverse
    }

    def whereDef(): WhereDef = {
      if (token.is[KwVal]) {
        next()
        val id = acceptToken[Ident]
        accept[Colon]
        val t = loutPattern.typ()
        accept[Token.Equals]
        val e = expr()
        ValWhereDef(id, t, e)
      } else {
        accept[KwDef]
        val id = acceptToken[Ident]
        accept[LeftParen]
        val params = specParams()
        accept[RightParen]
        accept[Colon]
        val t = loutPattern.typ()
        newLinesOpt()
        var sds = List(specDef())
        while (tokenCurrOrAfterNl(token.is[Token.Equals])) {
          newLinesOpt()
          sds ::= specDef()
        }
        DefWhereDef(id, params, t, sds.reverse)
      }
    }

    next()
    newLinesOpt()
    var r = List(whereDef())
    while (tokenCurrOrAfterNl(token.is[Token.Equals])) {
      newLinesOpt()
      r ::= whereDef()
    }
    r.reverse
  }

  /** {{{
   *  LoopInvMod     ::= BOF {nl}
   *                     [ Ident<invariant> {nl} NamedExprs ]
   *                     [ Ident<modifies> {nl} Expr {`,' {nl} Expr} ] {nl}
   *                     EOF
   *  }}}
   */
  def loopInvMode(): (List[(Option[Ident], Term)], List[Term]) = {
    accept[BOF]
    val is = if (isIdentOf("invariant")) {
      next()
      newLinesOpt()
      namedExprs(token.isNot[EOF] || !isIdentOf("modifies"))
    } else List()
    val mods = modifies()
    accept[EOF]
    (is, mods)
  }

  /** {{{
   *  LClause        ::= BOF {nl}
   *                     ( Invariants
   *                     | Facts
   *                     | Theorems
   *                     | Sequent
   *                     | Proof
   *                     ) EOF
   *  }}}
   */
  def lClause(): LClause = {
    accept[BOF]
    newLinesOpt()
    val r: LClause =
      if (isIdentOf("invariant")) invariants()
      else if (isIdentOf("fact")) facts()
      else if (isIdentOf("theorem")) theorems()
      else if (token.is[LeftBrace]) proof()
      else {
        val i = findTokenPos(isSequentToken, t => t.isNot[LeftBrace])
        if (i < 0) reporter.syntaxError(s"Either invariant, fact, theorem, { ... }, or ... ⊢ ... expected", at = token)
        sequent(i)
      }
    accept[EOF]
    r
  }

  /** {{{
   *  Invariants     ::= Ident<invariant> {nl} NamedExprs
   *  }}}
   */
  private def invariants(): Invariants = {
    next()
    newLinesOpt()
    Invariants(namedExprs(token.isNot[EOF]))
  }

  /** {{{
   *  Facts          ::= Ident<fact> {nl} Fact {nl} { Fact {nl} }
   *
   *  Fact           ::= Ident `:' {nl} Expr
   *  }}}
   */
  private def facts(): Facts = {
    next()
    newLinesOpt()
    val nes = namedExprs(token.isNot[EOF])
    for ((idOpt, e) <- nes if idOpt.isEmpty) {
      reporter.syntaxError("A Slang fact needs to be named.", at = e.tokens(dialect).head)
    }
    Facts(nes.map(p => (p._1.get, p._2)))
  }

  /** {{{
   *  Theorems       ::= Ident<theorem> {nl} Theorem {nl} { Theorem {nl} }
   *
   *  Theorem        ::= Ident `:' {nl} Sequent
   *  }}}
   */
  private def theorems(): Theorem = {
    def theorem(): (Ident, Sequent) = {
      val id = acceptToken[Ident]
      accept[Colon]
      newLinesOpt()
      (id, sequent())
    }

    next()
    newLinesOpt()
    var ts = List(theorem())
    newLinesOpt()
    while (token.is[Ident]) {
      ts ::= theorem()
      newLinesOpt()
    }
    Theorem(ts.reverse)
  }

  /** {{{
   *  Sequent       ::= [ Exprs ] {nl} ( Ident<|-> | Ident<⊢> ) {nl} Exprs {nl} [ Proof ]
   *
   *  Exprs         ::= Expr {`,' {nl} Expr}
   *  }}}
   */
  def sequent(sequentIndex: Int = findTokenPos(isSequentToken, t => t.isNot[LeftBrace]), noProof: Boolean = false): Sequent = {
    if (sequentIndex < 0) reporter.syntaxError(s"... ⊢ ... expected", at = token)
    val emptyPremises = tokenCurrOrAfterNl(isSequentToken(token))
    var oldIn = in.asInstanceOf[LimitingTokenIterator]
    val premises = if (emptyPremises) List() else {
      in = new LimitingTokenIterator(oldIn.i, sequentIndex - 1)
      exprs()
    }
    in = new LimitingTokenIterator(sequentIndex + 1, oldIn.end)
    newLinesOpt()
    val proofIndex = if (noProof) -1 else findTokenPos(t => t.is[LeftBrace], t => true)
    if (proofIndex < 0) {
      val conclusions = exprs()
      newLinesOpt()
      Sequent(premises, conclusions, None)
    } else {
      oldIn = in.asInstanceOf[LimitingTokenIterator]
      in = new LimitingTokenIterator(oldIn.i, proofIndex - 1)
      val conclusions = exprs()
      in = new LimitingTokenIterator(proofIndex, oldIn.end)
      Sequent(premises, conclusions, Some(proof()))
    }
  }

  def exprs(): List[Term] = {
    var r = List(expr())
    while (token.is[Comma]) {
      next()
      newLinesOpt()
      r ::= expr()
    }
    r.reverse
  }

  def findTokenPos(p: Token => Boolean, continue: Token => Boolean): Int = {
    val lti = in.fork.asInstanceOf[LimitingTokenIterator]
    var found = p(lti.token)
    while (!found && token.isNot[EOF] && continue(lti.token)) {
      lti.next()
      found = p(lti.token)
    }
    if (found) lti.i else -1
  }

  /** {{{
   *  Proof          ::= `{' { {nl} ProofStep } {nl} `}' {nl}
   *
   *  ProofStep      ::= Int `.' Expr Just
   *                   |  Int `.' SubProof
   *
   *  SubProof       ::= `{' {nl} AssumeStep { {nl} ProofStep } {nl} `}'
   *
   *  AssumeStep     ::= Int `.' Expr Ident<assume>
   *                   |  Int `.' Idents Ident<assume>
   *                   |  Int `.' Idents `:' Domain { {nl} Idents `:' Domain } Ident<assume>
   *                   |  Int `.' Idents {nl} Expr Ident<assume>
   *                   |  Int `.' Idents `:' Domain { {nl} Idents `:' Domain } {nl} Expr Ident<assume>
   *
   *  Just           ::= Ident<premise>
   *                   |  ( Ident<∧> | Ident<^> ) Ident<i>                                  Int Int { Int }
   *                   |  ( Ident<∧> | Ident<^> ) Ident<e1>                                 Int
   *                   |  ( Ident<∧> | Ident<^> ) Ident<e2>                                 Int
   *                   |  ( Ident<∨> Ident<i1> | Ident<Vi1> )                               Int
   *                   |  ( Ident<∨> Ident<i2> | Ident<Vi2> )                               Int
   *                   |  ( Ident<∨> Ident<e> | Ident<Ve> )                                 Int Int Int { Int }
   *                   |  ( Ident<→> | Ident<->> ) Ident<i>                                 Int
   *                   |  ( Ident<→> | Ident<->> ) Ident<e>                                 Int Int { Int }
   *                   |  ( Ident<¬> | Ident<~> | Ident<!> ) Ident<i>                       Int
   *                   |  ( Ident<¬> | Ident<~> | Ident<!> ) Ident<e>                       Int Int
   *                   |  ( Ident<⊥> | Ident<_> `|' Ident<_> ) Ident<e>                     Int
   *                   |  Ident<pbc>                                                        Int
   *                   |  ( Ident<∀> Ident<i> | Ident<Ai> | Ident<alli> | Ident<foralli> )  Int
   *                   |  ( Ident<∀> Ident<e> | Ident<Ae> | Ident<alle> | Ident<foralle> )  Int {nl} Expr { `,' {nl} Expr }
   *                   |  ( Ident<∃> Ident<i> | Ident<Ei> | Ident<somei> | Ident<existsi> ) Int {nl} Expr { `,' {nl} Expr }
   *                   |  ( Ident<∃> Ident<e> | Ident<Ee> | Ident<somee> | Ident<existse> ) Int Int
   *                   |  Ident<fact>                                                       QualId
   *                   |  Ident<invariant>                                                  [ QualId ]
   *                   |  Ident<subst>                                                      Int ( '<' | '>' ) Int
   *                   |  Ident<algebra>                                                    { Int }
   *                   |  Ident<auto>                                                       { Int }
   *                   |  Ident<coq>                                                        String { Int }
   *  }}}
   */
  private def proof(): Proof = {
    def just(kind: String, offset: Int): Just = {
      val startPoint = token.pos.start
      (0 until offset - 1).foreach(_ => next())
      val endPoint = token.pos.end
      next()
      val pos = Position.Range(Input.Slice(input, startPoint.offset, endPoint.offset), startPoint, endPoint)
      kind match {
        case "premise" => Premise(pos)
        case "∧i" =>
          var steps = List(acceptInt)
          steps ::= acceptInt
          while (token.is[Token.Constant.Int]) {
            steps ::= acceptInt
          }
          AndIntro(pos, steps.reverse)
        case "∧e1" => AndElim(pos, is1 = true, acceptInt)
        case "∧e2" => AndElim(pos, is1 = false, acceptInt)
        case "∨i1" => OrIntro(pos, is1 = true, acceptInt)
        case "∨i2" => OrIntro(pos, is1 = false, acceptInt)
        case "∨e" =>
          val orStep = acceptInt
          var steps = List(acceptInt)
          steps ::= acceptInt
          while (token.is[Token.Constant.Int]) {
            steps ::= acceptInt
          }
          OrElim(pos, orStep, steps.reverse)
        case "→i" => ImplyIntro(pos, acceptInt)
        case "→e" =>
          val implyStep = acceptInt
          var steps = List(acceptInt)
          while (token.is[Token.Constant.Int]) {
            steps ::= acceptInt
          }
          ImplyElim(pos, implyStep, steps.reverse)
        case "¬i" => NegIntro(pos, acceptInt)
        case "¬e" =>
          val step = acceptInt
          NegElim(pos, step, acceptInt)
        case "⊥e" => BottomElim(pos, acceptInt)
        case "pbc" => Pbc(pos, acceptInt)
        case "∀i" => ForallIntro(pos, acceptInt)
        case "∀e" =>
          val qstep = acceptInt
          newLinesOpt()
          ForallElim(pos, qstep, exprs())
        case "∃i" =>
          val qstep = acceptInt
          newLinesOpt()
          ExistsIntro(pos, qstep, exprs())
        case "∃e" =>
          val existsStep = acceptInt
          ExistsElim(pos, existsStep, acceptInt)
        case "fact" => Fact(pos, qualId())
        case "invariant" => if (token.is[Ident]) Invariant(pos, Some(qualId())) else Invariant(pos, None)
        case "subst" =>
          val eqStep = acceptInt
          val isRight = ">" == acceptToken[Ident].value
          Subst(pos, isRight, eqStep, acceptInt)
        case "algebra" | "auto" =>
          val isAlgebra = "algebra" == kind
          var steps = List[Token.Constant.Int]()
          while (token.is[Token.Constant.Int]) {
            steps ::= acceptInt
          }
          Auto(pos, isAlgebra, steps.reverse)
        case "coq" =>
          val path = acceptToken[Token.Constant.String]
          var steps = List[Token.Constant.Int]()
          while (token.is[Token.Constant.Int]) {
            steps ::= acceptInt
          }
          Coq(pos, path, steps.reverse)
      }
    }

    def exprJustH(justPos: Int, justKind: String, justOffset: Int): (Term, Just) = {
      in = new LimitingTokenIterator(in.tokenPos, justPos - 1)
      val e = expr()
      in = new LimitingTokenIterator(justPos, parserTokens.length - 1)
      (e, just(justKind, justOffset))
    }

    def exprJust(stepNo: Token.Constant.Int): (Term, Just) = {
      val (justPos, justKind, justOffset) = findJust()
      if (justPos == -1) reporter.syntaxError(s"No justification found for proof step ${stepNo.value}.", at = token)
      exprJustH(justPos, justKind, justOffset)
    }

    def freshVar(): (Ident, Type) = {
      val id = acceptToken[Ident]
      accept[Colon]
      (id, loutPattern.typ())
    }

    def assumeStep(): AssumeProofStep = {
      val n = acceptToken[Token.Constant.Int]
      val (justPos, justKind, _) = findJust()

      def isAssume: Boolean = in.asInstanceOf[LimitingTokenIterator].i == justPos

      if (justPos < 0) reporter.syntaxError(s"Could not find assume justification.", at = token)
      else if ("assume" != justKind) reporter.syntaxError(s"Expected assume but found $justKind.", at = parserTokens(justPos))
      val oldIn = in.asInstanceOf[LimitingTokenIterator]
      try {
        in = new LimitingTokenIterator(oldIn.i, justPos - 1)
        val e = expr()
        if (isAssume) Aps(n, e)
        else {
          in = new LimitingTokenIterator(oldIn.i, justPos - 1)
          val ids = idents()
          if (isAssume) ForallIntroAps(n, List((ids, None)))
          else if (token.is[Colon]) {
            next()
            var fresh = List((ids, Some(domain())))
            while (tokenCurrOrAfterNl(token.is[Ident] && aheadNF(token.is[Comma] || token.is[Colon]))) {
              newLinesOpt()
              fresh ::= (idents(), Some(domain()))
            }
            if (isAssume) ForallIntroAps(n, fresh.reverse)
            else {
              newLinesOpt()
              val e = expr()
              if (isAssume) ExistsElimAps(n, fresh.reverse, e)
              else reporter.syntaxError(s"Expected assume but found ${token.text}", at = token)
            }
          } else {
            newLinesOpt()
            val e = expr()
            if (isAssume) ExistsElimAps(n, List((ids, None)), e)
            else reporter.syntaxError(s"Expected assume but found ${token.text}", at = token)
          }
        }
      } finally in = new LimitingTokenIterator(justPos + 1, oldIn.end)
    }

    def subProof(step: Token.Constant.Int): SubProof = {
      next()
      newLinesOpt()
      val as = assumeStep()
      var pss = List[ProofStep]()
      while (tokenCurrOrAfterNl(token.isNot[RightBrace]) && token.isNot[EOF]) {
        newLinesOpt()
        pss ::= proofStep()
      }
      newLinesOpt()
      accept[RightBrace]
      SubProof(step, as, pss.reverse)
    }

    def proofStep(): ProofStep = {
      val n = acceptInt
      accept[Dot]
      if (token.is[LeftBrace]) {
        subProof(n)
      } else {
        val (e, j) = exprJust(n)
        Ps(n, e, j)
      }
    }

    accept[LeftBrace]
    var pss = List[ProofStep]()
    while (tokenCurrOrAfterNl(token.isNot[RightBrace]) && token.isNot[EOF]) {
      newLinesOpt()
      pss ::= proofStep()
    }
    newLinesOpt()
    accept[RightBrace]
    newLinesOpt()
    Proof(pss.reverse)
  }

  /** {{{
   *  TruthTable     ::= BOF {nl}
   *                     Ident<*> { Ident<*> } {nl}
   *                     Ident<----...> {nl}
   *                     { Ident } Ident<|> ( Sequent | Expr ) {nl}   // Sequent without Proof
   *                     Ident<----...> {nl}
   *                     { TruthTableRow {nl} }
   *                     Ident<----...> {nl}
   *                     [ TruthTableConc {nl} ]
   *                     EOF
   *
   *  TruthTableRow  ::= [ BLits ] Ident<|> BLits
   *
   *  BLits          ::= BLit { BLit }
   *
   *  BLit           ::= Ident<T> | Ident<F>                          // Can be sequenced without whitespace
   *
   *  TruthTableConc ::= Ident<Valid>
   *                   |  Ident<Invalid> { {nl} `[' BLits `]' }
   *                   |  Ident<Tautology>
   *                   |  Ident<Contradiction>
   *                   |  Ident<Contingent> {nl}
    *                      [ Ident<-> ] Ident<T> `:' {nl} `[' BLits `]' { {nl} `[' BLits `]' } {nl}
    *                      [ Ident<-> ] Ident<F> `:' {nl} `[' BLits `]' { {nl} `[' BLits `]' }
   *  }}}
   */
  def truthTable(): TruthTable = {
    def conclusion(isSequent: Boolean): Option[TruthTableConclusion] = {
      def assignment(): List[BLit] = {
        newLinesOpt()
        accept[LeftBracket]
        val r = blits()
        accept[RightBracket]
        r
      }

      if (token.isNot[Ident]) return None
      val text = token.text
      next()
      val r = if (isSequent)
        text match {
          case "Valid" => Valid
          case "Invalid" =>
            var assignments = List[List[BLit]]()
            while (tokenCurrOrAfterNl(token.is[LeftBracket]))
              assignments ::= assignment()
            Invalid(assignments.reverse)
          case _ => reporter.syntaxError(s"Either Valid or Invalid expected but found $text", at = token)
        }
      else
        text match {
          case "Tautology" => Tautology
          case "Contradiction" => Contradiction
          case "Contingent" =>
            newLinesOpt()
            if (isIdentOf("-")) next()
            if (!isIdentOf("T")) reporter.syntaxError(s"T expected but found ${token.text}", at = token)
            next()
            accept[Colon]
            var truthAssignments = List(assignment())
            while (tokenCurrOrAfterNl(token.is[LeftBracket]))
              truthAssignments ::= assignment()
            newLinesOpt()
            if (isIdentOf("-")) next()
            if (!isIdentOf("F")) reporter.syntaxError(s"T expected but found ${token.text}", at = token)
            next()
            accept[Colon]
            var falseAssignments = List(assignment())
            while (tokenCurrOrAfterNl(token.is[LeftBracket]))
              falseAssignments ::= assignment()
            Contingent(truthAssignments.reverse, falseAssignments.reverse)
          case _ => reporter.syntaxError(s"Either Tautology, Contradiction, or Contingent expected but found $text", at = token)
        }
      newLinesOpt()
      Some(r)
    }

    def blits(): List[BLit] = {
      def isBlit: Boolean = token.is[Ident] && token.text.forall(c => c == 'T' || c == 'F')

      def blit(): List[BLit] = {
        val text = token.text
        next()
        val column = token.pos.start.column
        (for (j <- 0 until text.length) yield {
          BLit(column + j, text.charAt(j) == 'T')
        }).toList
      }

      var r = blit()
      while (isBlit) {
        r ++= blit()
      }
      r
    }

    def isHLine(t: Token): Boolean = token.text.length > 3 && token.text.forall(_ == '-')

    def acceptHLine(): Unit = {
      if (isHLine(token)) next()
      else reporter.syntaxError(s"----... expected but found ${token.text}", at = token)
      newLinesOpt()
    }

    var vars = List[Ident]()
    var sep: Point = Point.None
    var formula: Either[(Int, Sequent), Term] = null

    def header(): Unit = {
      while (!isIdentOf("|") && token.isNot[EOF]) {
        vars ::= acceptToken[Ident]
      }
      vars = vars.reverse
      sep = token.pos.start
      next()
      val i = findTokenPos(isSequentToken, isHLine)
      formula =
        if (i < 0) Right(expr())
        else Left((parserTokens(i).pos.start.column, sequent()))
      newLinesOpt()
    }

    var stars = List[Int]()

    def start(): Unit = {
      if (isIdentOf("*")) {
        stars ::= token.pos.start.column
        next()
      } else reporter.syntaxError(s"* expected but found ${token.text}", at = token)

      while (isIdentOf("*")) {
        stars ::= token.pos.start.column
        next()
      }
      newLinesOpt()
      stars = stars.reverse
    }

    var rows = List[TruthTableRow]()

    def row(): Unit = {
      val assignment = if (!isIdentOf("|")) blits() else List()
      if (!isIdentOf("|")) reporter.syntaxError(s"| expected but found ${token.text}", at = token)
      next()
      rows ::= TruthTableRow(assignment, token.pos.start.column, blits())
      newLinesOpt()
    }

    accept[BOF]
    newLinesOpt()
    start()
    acceptHLine()
    header()
    acceptHLine()
    while (!isHLine(token) && token.isNot[EOF]) row()
    acceptHLine()
    val r = TruthTable(stars, vars, sep.column, formula, rows.reverse, conclusion(formula.isLeft))
    newLinesOpt()
    accept[EOF]
    r
  }
}
