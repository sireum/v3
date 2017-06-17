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

import scala.meta._
import scala.meta.inputs.Input
import scala.meta.internal.parsers.{InfixMode, ScalametaParser}
import scala.meta.parsers.{Parse, ParseException, Parsed}
import scala.meta.tokenizers.TokenizeException
import scala.meta.tokens.Token.{Colon, Comma, Dot, Ident, LeftBracket, LeftParen, RightBracket, RightParen}

object LParser {
  val forallTokens = Set("∀", "A")
  val existsTokens = Set("∃", "E")
  val quantTokens: Set[String] = forallTokens ++ existsTokens

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

class LParser(input: Input, dialect: Dialect) extends ScalametaParser(input, dialect) {
  parser =>

  object loutPattern extends PatternContextSensitive {
    override def infixType(mode: InfixMode.Value): Type = compoundType()

    def argType(): Type = typ()

    def functionArgType(): Type.Arg = paramType()
  }

  /** {{{
   *  SimpleExpr    ::= QuantExpr
   *                  |  ... super.simpleExpr()
   *  }}}
   */
  override def simpleExpr(): Term = {
    if (token.is[Ident] && quantTokens.contains(token.text)) quantExpr()
    else super.simpleExpr()
  }

  /** {{{
   *  QuantExpr     ::= ( Id<∀> | Id<A> | Id<∃> | Id<E> ) Id {`,' Id} `:' Domain Expr
   *
   *  Domain        ::= ( `(' | `<' | `[' ) Expr ',' Expr ( `)' | `>' | `]' )
   *                  |  Type
   *  }}}
   */
  private def quantExpr(): Term = autoPos {
    val isForAll = forallTokens.contains(token.text)
    accept[Ident]

    val ids: Term = identifiers()

    accept[Colon]

    if (token.is[LeftParen] || token.is[LeftBracket]) {
      val loExact = token.is[LeftBracket]
      next()
      val lo = expr()
      accept[Comma]
      val hi = expr()
      val hiExact = token.is[RightBracket]
      if (hiExact) next() else accept[RightParen]
      val e = expr()
      Term.Apply(
        Term.Name("L$Quant"),
        List[Term](
          Lit.Boolean(isForAll),
          ids,
          Term.Tuple(List(lo, Lit.Boolean(loExact), hi, Lit.Boolean(hiExact))),
          e)
      )
    } else {
      val t = loutPattern.typ()
      val e = expr()
      Term.Apply(
        Term.Name("L$Quant"),
        List[Term](
          Lit.Boolean(isForAll),
          Term.Ascribe(ids, t),
          e)
      )
    }
  }

  def identifiers(): Term = {
    var t = token
    accept[Ident]
    var ids = List(atPos(t.start, t.end)(Term.Name(t.text)))
    while (token.is[Comma]) {
      next()
      t = token
      accept[Ident]
      ids ::= atPos(t.start, t.end)(Term.Name(t.text))
    }
    if (ids.size == 1) ids.head
    else Term.Tuple(ids.reverse)
  }
}
