/*
Copyright (c) 2014-2017 EPFL

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

  * Redistributions of source code must retain the above copyright notice,
    this list of conditions and the following disclaimer.
  * Redistributions in binary form must reproduce the above copyright notice,
    this list of conditions and the following disclaimer in the documentation
    and/or other materials provided with the distribution.
  * Neither the name of the EPFL nor the names of its contributors
    may be used to endorse or promote products derived from this software
    without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scala.meta.internal.parsers

import org.scalameta.{debug, unreachable}

import scala.collection.immutable.{List, Nil}
import scala.meta.inputs.Input
import scala.meta.tokens.Token.{Ident, LeftBrace, LeftBracket, LeftParen, Unquote}
import scala.meta.{Dialect, Term}

class ModifiedScalametaParser(input: Input, dialect: Dialect)
  extends ScalametaParser(input: Input, dialect: Dialect) {

  def isInfixOp: Boolean = token.is[Ident]

  override def postfixExpr(allowRepeated: Boolean): Term = {
    val ctx  = termInfixContext
    val base = ctx.stack

    // Skip to later in the `postfixExpr` method to start mental debugging.
    // rhsStartK/rhsEndK may be bigger than then extent of rhsK,
    // so we really have to track them separately.
    def loop(rhsStartK: Pos, rhsK: ctx.Rhs, rhsEndK: Pos): ctx.Rhs = {
      if (!isInfixOp && !token.is[Unquote]) { // MODIFIED: token.is[Ident] => isInfixOp
        // Infix chain has ended.
        // In the running example, we're at `a + b[]`
        // with base = List([a +]), rhsK = List([b]).
        rhsK
      } else {
        // Infix chain continues.
        // In the running example, we're at `a [+] b`.
        val op = termName() // op = [+]
        val targs = if (token.is[LeftBracket]) exprTypeArgs() else Nil // targs = Nil

        // Check whether we're still infix or already postfix by testing the current token.
        // In the running example, we're at `a + [b]` (infix).
        // If we were parsing `val c = a b`, then we'd be at `val c = a b[]` (postfix).
        newLineOptWhenFollowing(_.is[ExprIntro])
        if (token.is[ExprIntro]) {
          // Infix chain continues, so we need to reduce the stack.
          // In the running example, base = List(), rhsK = [a].
          val lhsK = ctx.reduceStack(base, rhsK, rhsEndK, Some(op)) // lhsK = [a]
          val lhsStartK = Math.min(rhsStartK.startTokenPos, lhsK.head.startTokenPos)
          ctx.push(lhsStartK, lhsK, rhsEndK, op, targs) // afterwards, ctx.stack = List([a +])

          val preRhsKplus1 = in.token
          var rhsStartKplus1: Pos = IndexPos(in.tokenPos)
          val rhsKplus1 = argumentExprsOrPrefixExpr()
          var rhsEndKplus1: Pos = IndexPos(in.prevTokenPos)
          if (preRhsKplus1.isNot[LeftBrace] && preRhsKplus1.isNot[LeftParen]) {
            rhsStartKplus1 = TreePos(rhsKplus1.head)
            rhsEndKplus1 = TreePos(rhsKplus1.head)
          }

          // Try to continue the infix chain.
          loop(rhsStartKplus1, rhsKplus1, rhsEndKplus1) // base = List([a +]), rhsKplus1 = List([b])
        } else {
          // Infix chain has ended with a postfix expression.
          // This never happens in the running example.
          // TODO: The two type conversions that I have to do here are unfortunate,
          // but I don't have time to figure our an elegant way of approaching this
          val lhsQual = ctx.reduceStack(base, rhsK, rhsEndK, Some(op))
          val finQual = lhsQual match { case List(finQual) => finQual; case _ => unreachable(debug(lhsQual)) }
          if (targs.nonEmpty) reporter.syntaxError("type application is not allowed for postfix operators", at = token)
          ctx.toRhs(atPos(finQual, op)(Term.Select(finQual, op)))
        }
      }
    }

    // Start the infix chain.
    // We'll use `a + b` as our running example.
    val rhs0 = ctx.toRhs(prefixExpr(allowRepeated))

    // Iteratively read the infix chain via `loop`.
    // rhs0 is now [a]
    // If the next token is not an ident or an unquote, the infix chain ends immediately,
    // and `postfixExpr` becomes a fallthrough.
    val rhsN = loop(rhs0.head, rhs0, rhs0.head)

    // Infix chain has ended.
    // base contains pending UnfinishedInfix parts and rhsN is the final rhs.
    // For our running example, this'll be List([a +]) and [b].
    // Afterwards, `lhsResult` will be List([a + b]).
    val lhsResult = ctx.reduceStack(base, rhsN, in.prevTokenPos, None)

    // This is something not captured by the type system.
    // When applied to a result of `loop`, `reduceStack` will produce a singleton list.
    lhsResult match { case List(finResult) => finResult; case _ => unreachable(debug(lhsResult)) }
  }

}
