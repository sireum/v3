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

import org.sireum.{B, F, ISZ, T, Z, None => SNone, Option => SOption, Some => SSome, String => SString}
import org.sireum.lang.ast.{ContractExp, VarFragment, WhereDef}
import org.sireum.lang.util.AccumulatingReporter

import scala.collection.immutable.ListSet
import scala.meta._
import scala.meta.inputs.Input
import scala.meta.internal.parsers.{InfixMode, ModifiedScalametaParser}
import scala.meta.internal.tokens.TokenInfo
import scala.meta.tokens.TokensHelper
import scala.meta.tokens.Token.{BOF, Colon, Comma, Dot, EOF, Ident, KwCase, KwDef, KwIf, KwVal, LeftBrace, LeftBracket, LeftParen, RightBrace, RightBracket, RightParen}
import org.sireum.lang.{ast => AST}

object LParser {

  val forallTokens = ListSet("∀", "A", "all", "forall")
  val existsTokens = ListSet("∃", "E", "some", "exists")
  val quantTokens: ListSet[String] = forallTokens ++ existsTokens
  val lStmtFirst = ListSet("requires", "theorem", "fact")
  val implyInternalSym = "$->:"
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
    "⊻" -> "|^",
    "⊢" -> "|-"
  )

  def apply[T](text: String, reporter: AccumulatingReporter)(f: (LParser, AccumulatingReporter) => T): T = {
    val input = Input.String(text.replaceAllLiterally("\r\n", "\n"))  // WORKAROUND: scalameta crlf issues
    val dialect = SlangParser.scalaDialect(isWorksheet = false)
    val slangParser = new SlangParser(
      input = input,
      dialect = dialect,
      allowSireumPackage = false,
      hashSireum = false,
      isDiet = false,
      fileUriOpt = org.sireum.None(),
      isWorksheet = false,
      text = text,
      reporter = reporter)
    f(new LParser(input, dialect, slangParser), reporter)
  }
}

import LParser._

final class LParser(input: Input,
                    dialect: Dialect,
                    sparser: SlangParser)
  extends ModifiedScalametaParser(input, dialect) {

  object loutPattern extends PatternContextSensitive {
    override def infixTypeRest(t: Type, mode: InfixMode.Value): Type = {
      token match {
        case Ident(value) if value.forall(Character.isJavaIdentifierPart) => t
        case _ => super.infixTypeRest(t, mode)
      }
    }

    def argType(): Type = typ()

    def functionArgType(): Type = paramType()
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
      var text = ""
      val r = (isIdentOf(implyInternalSym) || isIdentOf("!") || isIdentOf("¬") || isIdentOf("~") || isIdentOf("∀") || isIdentOf("∃")) && {
        text = token.asInstanceOf[Ident].value
        ahead {
          text += token.text
          (isIdentOf("i") || isIdentOf("e")) && aheadNF(token.is[Token.Constant.Int])
        }
      }
      if (r) Some((text.replaceAllLiterally("!", "¬").replaceAllLiterally("~", "¬").replaceAllLiterally(implyInternalSym, "→"), 2)) else None
    },
    () => {
      if (isIdentOf("F") && ahead(isIdentOf("e") && aheadNF(token.is[Token.Constant.Int]))) Some(("⊥e", 2)) else None
    },
    () => {
      if ( {
        val t1 = token
        isIdentOf("_") && ahead {
          val t2 = token
          isIdentOf("|") && t2.pos.start == t1.pos.start + 1 && aheadNF {
            val t3 = token
            isIdentOf("_") && t3.pos.start == t2.pos.start + 1 &&
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
            while (t ne pTokens(iP)) iP += 1
            pTokens(iP) = t2
          case _ =>
        }
        case _ =>
      }
      iS += 1
    }
  }

  def isSequentToken(t: Token): Boolean = t match {
    case Ident(value) => "|-" == value
    case _ => false
  }

  def findJust(): (Int, String, Int) = {
    def continue: Boolean =
      if (token.is[RightBrace] || token.is[EOF]) false
      else if (TokensHelper.isNl(token) && ahead(token.is[Token.Constant.Int] && aheadNF(token.is[Dot]))) false
      else true

    def find(): Option[(String, Int)] = token match {
      case Ident(value) if justFirst.contains(value) => return Some((value, 1))
      case _ =>
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

  def acceptIdent(expected: String): Ident = token match {
    case Ident(value) if value == expected =>
      val r = token.asInstanceOf[Ident]
      next()
      r
    case _ => reporter.syntaxError(s"$expected expected but ${TokensHelper.name(token)} found.", at = token)
  }

  def acceptInt: AST.Exp.LitZ = {
    val t = acceptToken[Token.Constant.Int]
    AST.Exp.LitZ(Z(t.value.toInt), sparser.attr(t.pos))
  }

  override def isInfixOp: Boolean = token match {
    case Ident(value) if value.forall(Character.isJavaIdentifierPart) || value == "∀" || value == "∃" => false
    case Ident(_) => true
    case _ => false
  }

  /** {{{
   *  SimplExpr      ::= QuantExpr
   *                    |  ... super.simpleExpr()
   *  }}}
   */
  override def simpleExpr(allowRepeated: Boolean): Term = token match {
    case Ident(value) if quantTokens.contains(value) => quantExpr()
    case _ => super.simpleExpr(allowRepeated)
  }

  /** {{{
   *  QuantExpr      ::= QuantOp Idents [ `:' Domain ] [nl] PostfixExpr
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
    def acceptKw(kws: ListSet[String]): String = token match {
      case Ident(value) if kws.contains(value) =>
        next()
        value
      case _ => reporter.syntaxError(s"Either ${kws.mkString(" or ")} expected but ${TokensHelper.name(token)} found", at = token)
    }

    val isForAll = forallTokens.contains(acceptKw(quantTokens))

    val ids: Term = {
      var r = List[Term.Name](autoPos {
        Term.Name(acceptToken[Ident].value)
      })

      while (token.is[Comma]) {
        accept[Comma]
        r ::= autoPos {
          Term.Name(acceptToken[Ident].value)
        }
      }
      if (r.size > 1) Term.Tuple(r.reverse) else r.head
    }

    if (token.isNot[Colon]) {
      newLineOpt()
      val e = expr()
      Term.Apply(
        Term.Name("L$Quant"),
        List[Term](Lit.Boolean(isForAll), ids, e))
    } else {
      next()
      domainRaw() match {
        case Left(t) =>
          newLineOpt()
          val e = expr()
          Term.Apply(
            Term.Name("L$Quant"),
            List[Term](Lit.Boolean(isForAll), Term.Ascribe(ids, t), e))
        case Right(q) =>
          newLineOpt()
          val e = expr()
          Term.Apply(
            Term.Name("L$Quant"),
            List[Term](Lit.Boolean(isForAll), ids, q, e))
      }
    }
  }

  def domainRaw(): Either[Type, Term.Tuple] =
    if (token.is[LeftParen] || token.is[LeftBracket])
      Right(autoPos {
        val loExact = token.is[LeftBracket]
        next()
        val lo = expr()
        accept[Comma]
        val hi = expr()
        val hiExact = token.is[RightBracket]
        if (hiExact) next() else accept[RightParen]
        Term.Tuple(List(lo, Lit.Boolean(loExact), hi, Lit.Boolean(hiExact)))
      })
    else Left(loutPattern.typ())

  def domain(): AST.Domain = domainRaw() match {
    case Left(t) => AST.Domain.Type(sparser.translateType(t), sparser.typedAttr(t.pos))
    case Right(tt@Term.Tuple(Seq(lo, loExact: Lit.Boolean, hi, hiExact: Lit.Boolean, _))) =>
      AST.Domain.Range(
        sparser.translateExp(lo),
        if (loExact.value) T else F,
        sparser.translateExp(hi),
        if (hiExact.value) T else F,
        sparser.typedAttr(tt.pos))
  }

  def idents(): List[Ident] = {
    var ids = List(acceptToken[Ident])
    while (token.is[Comma]) {
      next()
      ids ::= acceptToken[Ident]
    }
    ids.reverse
  }

  def id(ident: Ident): AST.Id = AST.Id(ident.value, sparser.attr(ident.pos))

  def isz[T](l: List[T]): ISZ[T] = ISZ(l: _*)

  /** {{{
   *  DefContract    ::= BOF {nl}
   *                     [ Ident<reads> {nl} Expr { `,' {nl} Expr } ] {nl}
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
   *  SubContract    ::= def Ident `(' Ident {`,' Ident} `)' {nl} DefContract
   *
   *  PureOpt        ::= [ `@' Ident<pure> ]
   *  }}}
   */
  def defContract(): AST.Contract = {
    def pureOpt(): B = {
      if (token.is[Token.At] && ahead(isIdentOf("pure"))) {
        nextTwice()
        T
      } else F
    }

    def subContract(): List[AST.SubContract] = {
      var r = List[AST.SubContract]()
      while (token.isNot[EOF]) {
        accept[KwDef]
        val ident = id(acceptToken[Ident])
        accept[LeftParen]
        val params = if (token.isNot[RightParen]) {
          var ps = List(id(acceptToken[Ident]))
          while (token.is[Comma]) {
            next()
            ps ::= id(acceptToken[Ident])
          }
          ps
        } else List()
        accept[RightParen]
        newLinesOpt()
        r ::= AST.SubContract(ident, isz(params.reverse), defContract())
      }
      r.reverse
    }

    accept[BOF]
    newLinesOpt()
    val reads: List[AST.Exp] = readsModifies("reads")
    val requires: List[ContractExp] = if (isIdentOf("requires")) {
      next()
      newLinesOpt()
      namedExprs(!(isIdentOf("modifies") || isIdentOf("ensures") || token.is[KwDef] || token.is[EOF]))
    } else List()
    val mods: List[AST.Exp] = readsModifies("modifies")
    val ensures: List[ContractExp] = if (isIdentOf("ensures")) {
      next()
      newLinesOpt()
      namedExprs(!(token.is[KwDef] || token.is[EOF]))
    } else List()
    val r = AST.Contract(isz(reads), isz(requires), isz(mods), isz(ensures), isz(subContract()))
    accept[EOF]
    r
  }

  def readsModifies(keyword: String): List[AST.Exp] = if (isIdentOf(keyword)) {
    next()
    newLinesOpt()
    var r = List(sparser.translateExp(expr()))
    while (token.is[Comma]) {
      next()
      newLinesOpt()
      r ::= sparser.translateExp(expr())
    }
    newLinesOpt()
    r.reverse
  } else List()

  def namedExpr(): ContractExp =
    if (token.is[Ident] && ahead(token.is[Colon])) {
      val ident = acceptToken[Ident]
      next()
      newLinesOpt()
      AST.ContractExp(SSome(id(ident)), sparser.translateExp(expr()))
    } else {
      AST.ContractExp(SNone(), sparser.translateExp(expr()))
    }

  def namedExprs(continue: => Boolean): List[ContractExp] = {
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
   *  SpecDef        ::= `=' NamedExpr [`,' ( [ case Pattern ] [ if PostfixExpr ] | Ident<otherwise> ) ]
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
  def specDefs(): (List[AST.SpecDef], List[AST.WhereDef]) = {
    accept[BOF]
    newLinesOpt()
    var sds = List(specDef())
    newLinesOpt()
    while (token.isNot[EOF] && !isIdentOf("where")) {
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

  def specDef(): AST.SpecDef = {
    accept[Token.Equals]
    val AST.ContractExp(idOpt, e) = namedExpr()
    val (isOtherwise, patternOpt, guardOpt) = if (token.is[Comma]) {
      next()
      val pOpt: SOption[AST.Pattern] = if (token.is[KwCase]) {
        next()
        SSome(sparser.translatePattern(pattern()))
      } else SNone()
      val gOpt: SOption[AST.Exp] = if (token.is[KwIf]) {
        next()
        SSome(sparser.translateExp(postfixExpr(allowRepeated = false)))
      } else SNone()
      (F, pOpt, gOpt)
    } else if (isIdentOf("otherwise")) (T, SNone[AST.Pattern](), SNone[AST.Exp]())
    else (F, SNone[AST.Pattern](), SNone[AST.Exp]())
    AST.SpecDef(idOpt, e, isOtherwise, patternOpt, guardOpt)
  }

  private def whereDefs(): List[WhereDef] = {
    def specParam(): AST.Param = {
      val ident = id(acceptToken[Ident])
      accept[Colon]
      AST.Param(F, ident, sparser.translateType(loutPattern.typ()))
    }

    def specParams(): List[AST.Param] = {
      var r = List(specParam())
      while (token.is[Comma]) {
        next()
        r ::= specParam()
      }
      r.reverse
    }

    def whereDef(): AST.WhereDef = {
      if (token.is[KwVal]) {
        next()
        val ident = id(acceptToken[Ident])
        accept[Colon]
        val t = sparser.translateType(loutPattern.typ())
        accept[Token.Equals]
        val e = sparser.translateExp(expr())
        AST.WhereDef.Val(ident, t, e)
      } else {
        accept[KwDef]
        val ident = id(acceptToken[Ident])
        accept[LeftParen]
        val params = specParams()
        accept[RightParen]
        accept[Colon]
        val t = sparser.translateType(loutPattern.typ())
        newLinesOpt()
        var sds = List(specDef())
        while (tokenCurrOrAfterNl(token.is[Token.Equals])) {
          newLinesOpt()
          sds ::= specDef()
        }
        AST.WhereDef.Def(ident, isz(params), t, isz(sds.reverse))
      }
    }

    next()
    newLinesOpt()
    var r = List(whereDef())
    while (tokenCurrOrAfterNl(token.is[Token.KwVal] || token.is[Token.KwDef])) {
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
  def loopInvMode(): (List[AST.ContractExp], List[AST.Exp]) = {
    accept[BOF]
    val is = if (isIdentOf("invariant")) {
      next()
      newLinesOpt()
      namedExprs(token.isNot[EOF] || !isIdentOf("modifies"))
    } else List()
    val mods = readsModifies("modifies")
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
  def lClause(): AST.LClause = {
    accept[BOF]
    newLinesOpt()
    val r: AST.LClause =
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
  private def invariants(): AST.LClause.Invariants = {
    next()
    newLinesOpt()
    AST.LClause.Invariants(isz(namedExprs(token.isNot[EOF])))
  }

  /** {{{
   *  Facts          ::= Ident<fact> {nl} Fact {nl} { Fact {nl} }
   *
   *  Fact           ::= Ident `:' {nl} Expr
   *  }}}
   */
  private def facts(): AST.LClause.Facts = {
    def fact(): AST.LClause.Fact = {
      val ident = id(acceptToken[Ident])
      accept[Colon]
      newLinesOpt()
      AST.LClause.Fact(ident, sparser.translateExp(expr()))
    }

    next()
    newLinesOpt()
    var fs = List(fact())
    newLinesOpt()
    while (token.is[Ident] && ahead(token.is[Colon])) {
      fs ::= fact()
    }
    AST.LClause.Facts(isz(fs.reverse))
  }

  /** {{{
   *  Theorems       ::= Ident<theorem> {nl} Theorem {nl} { Theorem {nl} }
   *
   *  Theorem        ::= Ident `:' {nl} Sequent
   *  }}}
   */
  private def theorems(): AST.LClause.Theorems = {
    def theorem(): AST.LClause.Theorem = {
      val ident = id(acceptToken[Ident])
      accept[Colon]
      newLinesOpt()
      AST.LClause.Theorem(ident, sequent())
    }

    next()
    newLinesOpt()
    var ts = List(theorem())
    newLinesOpt()
    while (token.is[Ident]) {
      ts ::= theorem()
      newLinesOpt()
    }
    AST.LClause.Theorems(isz(ts.reverse))
  }

  /** {{{
   *  Sequent       ::= [ Exprs ] {nl} ( Ident<|-> | Ident<⊢> ) {nl} Exprs {nl} [ Proof ]
   *
   *  Exprs         ::= Expr {`,' {nl} Expr}
   *  }}}
   */
  def sequent(sequentIndex: Int = findTokenPos(isSequentToken, t => t.isNot[LeftBrace]),
              noProof: Boolean = false): AST.LClause.Sequent = {
    if (sequentIndex < 0) reporter.syntaxError(s"... ⊢ ... expected", at = token)
    val emptyPremises = tokenCurrOrAfterNl(isSequentToken(token))
    var oldIn = in.asInstanceOf[LimitingTokenIterator]
    val premises = if (emptyPremises) List() else {
      in = new LimitingTokenIterator(oldIn.i, sequentIndex - 1)
      exprs()
    }
    in = new LimitingTokenIterator(sequentIndex + 1, oldIn.end)
    newLinesOpt()
    val proofIndex = if (noProof) -1 else findTokenPos(t => t.is[LeftBrace], _ => true)
    if (proofIndex < 0) {
      val conclusions = exprs()
      newLinesOpt()
      AST.LClause.Sequent(isz(premises), isz(conclusions), SNone())
    } else {
      oldIn = in.asInstanceOf[LimitingTokenIterator]
      in = new LimitingTokenIterator(oldIn.i, proofIndex - 1)
      val conclusions = exprs()
      in = new LimitingTokenIterator(proofIndex, oldIn.end)
      AST.LClause.Sequent(isz(premises), isz(conclusions), SSome(proof()))
    }
  }

  def exprs(): List[AST.Exp] = {
    var r = List(sparser.translateExp(expr()))
    while (token.is[Comma]) {
      next()
      newLinesOpt()
      r ::= sparser.translateExp(expr())
    }
    r.reverse
  }

  def findTokenPos(p: Token => Boolean, continue: Token => Boolean): Int = {
    val lti = in.fork.asInstanceOf[LimitingTokenIterator]
    var found = p(lti.token)
    while (!found && lti.token.isNot[EOF] && continue(lti.token)) {
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
   *                   |  Int `.' Idents
   *                   |  Int `.' Idents `:' Domain { {nl} Idents `:' Domain }
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
   *                   |  Ident<subst>                                                      ( '<' | '>' ) Int Int
   *                   |  Ident<algebra>                                                    { Int }
   *                   |  Ident<auto>                                                       { Int }
   *                   |  Ident<coq>                                                        String { Int }
   *  }}}
   */
  private def proof(): AST.LClause.Proof = {
    def just(kind: String, offset: Int): AST.Just = {
      val input = token.pos.input
      val startPoint = token.pos.start
      (0 until offset - 1).foreach(_ => next())
      val endPoint = token.pos.end
      next()
      val attr = sparser.attr(Position.Range(input, startPoint, endPoint))
      kind match {
        case "premise" => AST.Just.Premise(attr)
        case "∧i" =>
          var steps = List(acceptInt)
          steps ::= acceptInt
          while (token.is[Token.Constant.Int]) {
            steps ::= acceptInt
          }
          AST.Just.AndIntro(isz(steps.reverse), attr)
        case "∧e1" => AST.Just.AndElim(T, acceptInt, attr)
        case "∧e2" => AST.Just.AndElim(F, acceptInt, attr)
        case "∨i1" => AST.Just.OrIntro(T, acceptInt, attr)
        case "∨i2" => AST.Just.OrIntro(F, acceptInt, attr)
        case "∨e" =>
          val orStep = acceptInt
          var steps = List(acceptInt)
          steps ::= acceptInt
          while (token.is[Token.Constant.Int]) {
            steps ::= acceptInt
          }
          AST.Just.OrElim(orStep, isz(steps.reverse), attr)
        case "→i" => AST.Just.ImplyIntro(acceptInt, attr)
        case "→e" =>
          val implyStep = acceptInt
          var steps = List(acceptInt)
          while (token.is[Token.Constant.Int]) {
            steps ::= acceptInt
          }
          AST.Just.ImplyElim(implyStep, isz(steps.reverse), attr)
        case "¬i" => AST.Just.NegIntro(acceptInt, attr)
        case "¬e" =>
          val step = acceptInt
          AST.Just.NegElim(step, acceptInt, attr)
        case "⊥e" => AST.Just.BottomElim(acceptInt, attr)
        case "pbc" => AST.Just.Pbc(acceptInt, attr)
        case "∀i" => AST.Just.ForallIntro(acceptInt, attr)
        case "∀e" =>
          val qstep = acceptInt
          newLinesOpt()
          AST.Just.ForallElim(qstep, isz(exprs()), attr)
        case "∃i" =>
          val qstep = acceptInt
          newLinesOpt()
          AST.Just.ExistsIntro(qstep, isz(exprs()), attr)
        case "∃e" =>
          val existsStep = acceptInt
          AST.Just.ExistsElim(existsStep, acceptInt, attr)
        case "fact" => AST.Just.Fact(name(), attr)
        case "invariant" =>
          if (token.is[Ident]) AST.Just.Invariant(SSome(name()), attr)
          else AST.Just.Invariant(SNone(), attr)
        case "subst" =>
          val isRight = if (">" == acceptToken[Ident].value) T else F
          val eqStep = acceptInt
          AST.Just.Subst(isRight, eqStep, acceptInt, attr)
        case "algebra" | "auto" =>
          val isAlgebra = if ("algebra" == kind) T else F
          var steps = List[AST.Exp.LitZ]()
          while (token.is[Token.Constant.Int]) {
            steps ::= acceptInt
          }
          AST.Just.Auto(isAlgebra, isz(steps.reverse), attr)
        case "coq" =>
          val t = acceptToken[Token.Constant.String]
          val path = AST.Exp.LitString(t.value, sparser.attr(t.pos))
          var steps = List[AST.Exp.LitZ]()
          while (token.is[Token.Constant.Int]) {
            steps ::= acceptInt
          }
          AST.Just.Coq(path, isz(steps.reverse), attr)
      }
    }

    def name(): AST.Name = {
      val qId = qualId()
      AST.Name(sparser.ref2IS(qId), sparser.attr(qId.pos))
    }

    def exprJustH(justPos: Int, justKind: String, justOffset: Int): (AST.Exp, AST.Just) = {
      in = new LimitingTokenIterator(in.asInstanceOf[LimitingTokenIterator].i, justPos - 1)
      val ex = expr()
      val e = try {
        sparser.translateExp(ex)
      } catch {
        case exc: ArrayIndexOutOfBoundsException =>
          println(ex.syntax)
          throw exc
      }
      in = new LimitingTokenIterator(justPos, parserTokens.length - 1)
      (e, just(justKind, justOffset))
    }

    def exprJust(stepNo: AST.Exp.LitZ): (AST.Exp, AST.Just) = {
      val (justPos, justKind, justOffset) = findJust()
      if (justPos == -1) reporter.syntaxError(s"No justification found for proof step ${stepNo.value}.", at = token)
      exprJustH(justPos, justKind, justOffset)
    }

    def assumeStep(): AST.AssumeProofStep = {
      val n = acceptInt
      accept[Dot]
      val (justPos, justKind, _) = findJust()

      def isAssume: Boolean = in.asInstanceOf[LimitingTokenIterator].i == justPos

      if (justPos < 0) {
        val ids = idents().map(id)
        if (token.is[Colon]) {
          next()
          var fresh = List(AST.VarFragment(isz(ids), SSome(domain())))
          while (tokenCurrOrAfterNl(token.is[Ident] && aheadNF(token.is[Comma] || token.is[Colon]))) {
            newLinesOpt()
            fresh ::= AST.VarFragment(isz(idents().map(id)), SSome(domain()))
          }
          AST.AssumeProofStep.ForallIntroAps(n, isz(fresh.reverse))
        } else AST.AssumeProofStep.ForallIntroAps(n, ISZ(AST.VarFragment(isz(ids), SNone())))
      } else if ("assume" != justKind) reporter.syntaxError(s"Expected assume but $justKind found", at = parserTokens(justPos))
      else {
        val oldIn = in.asInstanceOf[LimitingTokenIterator]
        try {
          in = new LimitingTokenIterator(oldIn.i, justPos - 1)

          val e = sparser.translateExp(expr())
          if (isAssume) AST.AssumeProofStep.Regular(n, e)
          else {
            in = new LimitingTokenIterator(oldIn.i, justPos - 1)
            val ids = idents().map(id)
            if (token.is[Colon]) {
              next()
              var fresh = List(VarFragment(isz(ids), SSome(domain())))
              while (tokenCurrOrAfterNl(token.is[Ident] && aheadNF(token.is[Comma] || token.is[Colon]))) {
                newLinesOpt()
                fresh ::= VarFragment(isz(idents().map(id)), SSome(domain()))
              }
              newLinesOpt()
              val e = sparser.translateExp(expr())
              if (isAssume) AST.AssumeProofStep.ExistsElimAps(n, isz(fresh.reverse), e)
              else reporter.syntaxError(s"Expected assume but ${TokensHelper.name(token)} found", at = token)
            } else {
              newLinesOpt()
              val e = sparser.translateExp(expr())
              if (isAssume) AST.AssumeProofStep.ExistsElimAps(n, ISZ(VarFragment(isz(ids), SNone())), e)
              else reporter.syntaxError(s"Expected assume but ${TokensHelper.name(token)} found", at = token)
            }
          }
        } finally in = new LimitingTokenIterator(justPos + 1, oldIn.end)
      }
    }

    def subProof(step: AST.Exp.LitZ): AST.ProofStep.SubProof = {
      next()
      newLinesOpt()
      val as = assumeStep()
      var pss = List[AST.ProofStep]()
      while (tokenCurrOrAfterNl(token.isNot[RightBrace]) && token.isNot[EOF]) {
        newLinesOpt()
        pss ::= proofStep()
      }
      newLinesOpt()
      accept[RightBrace]
      AST.ProofStep.SubProof(step, as, isz(pss.reverse))
    }

    def proofStep(): AST.ProofStep = {
      val n = acceptInt
      accept[Dot]
      if (token.is[LeftBrace]) {
        subProof(n)
      } else {
        val (e, j) = exprJust(n)
        AST.ProofStep.Basic(n, e, j)
      }
    }

    accept[LeftBrace]
    var pss = List[AST.ProofStep]()
    while (tokenCurrOrAfterNl(token.isNot[RightBrace]) && token.isNot[EOF]) {
      newLinesOpt()
      pss ::= proofStep()
    }
    newLinesOpt()
    accept[RightBrace]
    newLinesOpt()
    AST.LClause.Proof(isz(pss.reverse))
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
   *  TruthTableConc ::= Ident<Valid> { {nl} `[' BLits `]' }
   *                   |  Ident<Invalid> { {nl} `[' BLits `]' }
   *                   |  Ident<Tautology>
   *                   |  Ident<Contradictory>
   *                   |  Ident<Contingent> {nl}
   *                      [ Ident<-> ] Ident<T> `:' {nl} `[' BLits `]' { {nl} `[' BLits `]' } {nl}
   *                      [ Ident<-> ] Ident<F> `:' {nl} `[' BLits `]' { {nl} `[' BLits `]' }
   *  }}}
   */
  def truthTable(fileUriOpt: SOption[SString]): SlangParser.Result = {
    def conclusion(isSequent: Boolean): SOption[AST.TruthTable.Conclusion] = {
      def assignment(): AST.TruthTable.Assignment = {
        newLinesOpt()
        accept[LeftBracket]
        val r = blits()
        accept[RightBracket]
        r
      }

      if (token.isNot[Ident]) return SNone()
      val text = token match {
        case Ident(value) => value
        case _ => return SNone()
      }
      val attr = sparser.attr(token.pos)
      val r = if (isSequent)
        text match {
          case "Valid" | "Invalid" =>
            next()
            val isValid = if (text == "Valid") T else F
            var assignments = List[AST.TruthTable.Assignment](assignment())
            newLinesOpt()
            while (tokenCurrOrAfterNl(token.is[LeftBracket])) {
              assignments ::= assignment()
            }
            AST.TruthTable.Conclusion.Validity(isValid, isz(assignments.reverse), attr)
          case _ => reporter.syntaxError(s"Either Valid or Invalid expected but found $text", at = token)
        }
      else
        text match {
          case "Tautology" =>
            next()
            AST.TruthTable.Conclusion.Tautology(attr)
          case "Contradictory" =>
            next()
            AST.TruthTable.Conclusion.Contradictory(attr)
          case "Contingent" =>
            next()
            newLinesOpt()
            if (isIdentOf("-")) next()
            if (!isIdentOf("T")) reporter.syntaxError(s"T expected but ${TokensHelper.name(token)} found", at = token)
            next()
            accept[Colon]
            var truthAssignments = List(assignment())
            while (tokenCurrOrAfterNl(token.is[LeftBracket]))
              truthAssignments ::= assignment()
            newLinesOpt()
            if (isIdentOf("-")) next()
            if (!isIdentOf("F")) reporter.syntaxError(s"T expected but ${TokensHelper.name(token)} found", at = token)
            next()
            accept[Colon]
            var falseAssignments = List(assignment())
            while (tokenCurrOrAfterNl(token.is[LeftBracket]))
              falseAssignments ::= assignment()
            AST.TruthTable.Conclusion.Contingent(isz(truthAssignments.reverse), isz(falseAssignments.reverse), attr)
          case _ => reporter.syntaxError(s"Either Tautology, Contradictory, or Contingent expected but found $text", at = token)
        }
      newLinesOpt()
      SSome(r)
    }

    def blits(): AST.TruthTable.Assignment = {
      def isBlit: Boolean = token match {
        case Ident(value) => value.forall(c => c == 'T' || c == 'F')
        case _ => false
      }

      def blit(): List[AST.Exp.LitB] = {
        val token = acceptToken[Ident]
        val offset = token.pos.start
        val value = token.value
        (for (j <- 0 until value.length) yield {
          AST.Exp.LitB(value.charAt(j) == 'T',
            sparser.attr(Position.Range(input, offset + j, offset + j + 1)))
        }).toList
      }

      if (!isBlit) reporter.syntaxError(s"Either T or F expected, but ${TokensHelper.name(token)} found", at = token)
      var r = blit()
      while (isBlit) {
        r ++= blit()
      }
      AST.TruthTable.Assignment(isz(r), AST.Attr(AST.Util.posOptRange(r.head.posOpt, r.last.posOpt)))
    }

    def isHLine(t: Token): Boolean = token match {
      case Ident(value) => value.length > 3 && value.forall(_ == '-')
      case _ => false
    }

    def acceptHLine(): Unit = {
      if (isHLine(token)) next()
      else reporter.syntaxError(s"----... expected but ${TokensHelper.name(token)} found", at = token)
      newLinesOpt()
    }

    var vars = List[AST.Id]()
    var sep: AST.PosInfo = null
    var formula: AST.LClause.Sequent = null
    var isSequent: B = F

    def header(): Unit = {
      while (!isIdentOf("|") && token.isNot[EOF]) {
        vars ::= id(acceptToken[Ident])
      }
      vars = vars.reverse
      sep = sparser.posInfo(token.pos)
      acceptIdent("|")
      val i = findTokenPos(isSequentToken, t => !isHLine(t))
      formula =
        if (i < 0) AST.LClause.Sequent(ISZ(), ISZ(sparser.translateExp(expr())), SNone())
        else {
          isSequent = T
          sequent(noProof = true)
        }
      newLinesOpt()
    }

    var stars = List[AST.PosInfo]()

    def start(): Unit = {
      if (isIdentOf("*")) {
        stars ::= sparser.posInfo(token.pos)
        next()
      } else reporter.syntaxError(s"* expected but ${TokensHelper.name(token)} found", at = token)

      while (isIdentOf("*")) {
        stars ::= sparser.posInfo(token.pos)
        next()
      }
      newLinesOpt()
      stars = stars.reverse
    }

    var rows = List[AST.TruthTable.Row]()

    def row(): Unit = {
      val assignment = if (!isIdentOf("|")) blits() else AST.TruthTable.Assignment(ISZ(), AST.Attr(SNone()))
      val t = acceptIdent("|")
      rows ::= AST.TruthTable.Row(assignment, sparser.posInfo(t.pos), blits())
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
    val r = AST.TopUnit.TruthTableUnit(
      fileUriOpt,
      isz(stars),
      isz(vars),
      sep,
      isSequent,
      formula,
      isz(rows.reverse),
      conclusion(isSequent))
    newLinesOpt()
    accept[EOF]
    SlangParser.Result(input.text, hashSireum = false, SSome(r))
  }

  def sequentFile(fileUriOpt: SOption[SString]): SlangParser.Result = {
    accept[BOF]
    newLinesOpt()
    val r = sequent()
    accept[EOF]
    SlangParser.Result(input.text, hashSireum = false, SSome(AST.TopUnit.SequentUnit(fileUriOpt, r)))
  }
}
