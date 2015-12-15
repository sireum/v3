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

package org.sireum.logika.parser

import java.io.StringReader

import org.sireum.logika.ast._
import org.sireum.util._

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

  trait Reporter {
    def error(line: PosInteger,
              column: PosInteger,
              offset: Natural,
              message: String): Unit
  }

  object ConsoleReporter extends Reporter {
    override def error(line: PosInteger,
                       column: PosInteger,
                       offset: Natural,
                       message: String): Unit = {
      Console.err.println(s"[$line, $column] $message")
      Console.err.flush()
    }
  }

  import org.antlr.v4.runtime._
  import scala.reflect.runtime.universe._

  def apply[T <: UnitNode](input: String,
                           maxErrors: Natural = 0,
                           reporter: Reporter = ConsoleReporter)
                          (implicit tag: TypeTag[T]) = {
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
    tag.tpe match {
      case `sequentType` =>
        orientNewlines(tokenStream, isProgram = false)
        parser.sequentFile()
      case `proofType` =>
        orientNewlines(tokenStream, isProgram = false)
        parser.proofFile()
      case `programType` =>
        orientNewlines(tokenStream, isProgram = true)
        parser.programFile()
    }
  }

  private def orientNewlines(cts: CommonTokenStream,
                             isProgram: Boolean): Unit = {
    import Antlr4LogikaLexer.{NL, ID, INT}
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
                  case ID | INT => skip = false
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
