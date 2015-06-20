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

package org.sireum.pilar.parser

import org.sireum.pilar.ast._
import org.sireum.util._

import FastParser._

final class FastParser(input: String,
                       reporter: Reporter = ConsoleReporter)(
                        max: Int = input.length,
                        private var offset: Int = 0,
                        private var line: Int = 1,
                        private var column: Int = 1) {
  val min = offset
  val threeQuotes = "\"\"\""

  def parseExp(): Option[Exp] = ???

  def parsePrimaryExp(): Option[Exp] = {
    implicit val begin = (line, column, offset)
    def parseTupleExp() = {
      consume()
      parseWhiteSpace()
      parseExp().flatMap { e =>
        parseWhiteSpace()
        var ok = true
        var es = ivector(e)
        while (peek() == ',' && ok) {
          consume()
          parseWhiteSpace()
          parseExp() match {
            case Some(e2) => es = es :+ e2
            case _ => ok = false
          }
          parseWhiteSpace()
        }
        ok = ok && matchChar(')') {
          reporter.error(line, column, offset,
            s"Expecting: ')', but found: '${input.charAt(offset)}'")
        }
        if (!ok) None
        else {
          val anns = parseAnnotations()
          val r = TupleExp(es, anns) at(offset, line, column)
          parseWhiteSpace()
          Some(r)
        }
      }
    }

    def parseIdOrLitExp() = {
      val r = parseID().flatMap { id =>
        parseWhiteSpace()
        peek() match {
          case '\'' | '\"' =>
            parseLIT().map(raw => LiteralExp(id, raw).
              at(offset, line, column))
          case _ =>
            val r = IdExp(id)
            r.locationInfoOpt = id.locationInfoOpt
            Some(r)
        }
      }
      parseWhiteSpace()
      r
    }

    if (peek() == '(') parseTupleExp()
    else parseIdOrLitExp()
  }

  def parseAnnotations(): Node.Seq[Annotation] = ???


  def parseAnnotation(): Option[Annotation] = {
    implicit val begin = (line, column, offset)

    if (matchChar('@') {
      reporter.error(begin._1, begin._2, begin._3,
        s"Expecting: '@', but found: '${input.charAt(begin._3)}'")
      consume()
    }) {
      (parseID(), parseLIT()) match {
        case (Some(id), Some(raw)) =>
          val r = Some(Annotation(id, raw) at(offset, line, column))
          parseWhiteSpace()
          r
        case _ => None
      }
    } else None
  }

  def parseID(): Option[Id] = {
    @inline
    def isComplexIDChar(c: Int) = c match {
      case '\r' | '\n' | '\t' | '\u000C' | '`' => false
      case _ => true
    }

    implicit val begin = (line, column, offset)

    @inline
    def parseComplexID() = {
      consume()
      while (isComplexIDChar(peek())) consume()
      if (matchChar('`') {
        reporter.error(begin._1, begin._2, begin._3,
          s"Invalid identifier form: '${input.substring(begin._3, offset)}'")
      })
        Some(Id(input.substring(begin._3 + 1, offset - 1),
          simple = false) at(offset, line, column))
      else None
    }

    @inline
    def parseDotID() = {
      consume()
      var c = peek()
      while (!isWhitespace(c) && !isEOF(c)) {
        consume()
        c = peek()
      }
      Some(Id(input.substring(begin._3 + 1, offset), simple = false).
        at(offset, line, column))
    }

    @inline
    def parseSimpleID() = {
      var c = peek()
      if (!isJavaLetter(c)) {
        reporter.error(line, column, offset,
          s"Invalid first character for an identifier: '${c.asInstanceOf[Char]}'")
        consume()
        None
      } else {
        consume()
        var error = false
        while (!isSeparator(peek()) && !error) {
          c = peek()
          if (!(isJavaDigit(c) || isJavaLetter(c))) {
            error = true
            reporter.error(line, column, offset,
              s"Invalid character for an identifier: '${c.asInstanceOf[Char]}'")
          }
          consume()
        }
        if (error) None
        else Some(Id(input.substring(begin._3, offset), simple = true).
          at(offset, line, column))
      }
    }

    val r = peek() match {
      case '`' => parseComplexID()
      case '.' => parseDotID()
      case _ => parseSimpleID()
    }
    parseWhiteSpace()
    r
  }

  def parseLIT(): Option[Raw] = {
    implicit val begin = (line, column, offset)

    @inline
    def parseSimpleLIT() = {
      consume()
      var c = peek()
      while (!isWhitespace(c) && !isEOF(c)) {
        consume()
        c = peek()
      }
      Some(Raw(input.substring(begin._3 + 1, offset)).
        at(offset, line, column))
    }

    @inline
    def parseComplexLIT() = {
      var ok = true
      var continue = true
      while (continue && ok) {
        ok = matchCharSeq(threeQuotes)
        if (ok) {
          while (!isEOF(peek()) && !peekCharSeq(threeQuotes)) {
            consume()
          }
          ok = !isEOF(peek()) && matchCharSeq(threeQuotes)
          continue = if (ok) peekCharSeq(threeQuotes) else false
        }
      }
      if (!ok) None
      else Some(Raw(input.substring(begin._3 + 3, offset - 3).
        replaceAll(threeQuotes + threeQuotes, threeQuotes)).
        at(offset, line, column))
    }

    val r = peek() match {
      case '\'' => parseSimpleLIT()
      case '"' => parseComplexLIT()
      case c =>
        reporter.error(line, column, offset,
          s"Invalid character for a literal string: '${c.asInstanceOf[Char]}'")
        consume()
        None
    }
    parseWhiteSpace()
    r
  }

  private def peekCharSeq(s: String): Boolean = {
    var i = 0
    while (i < s.length) {
      if (peek(i) != s.charAt(i)) return false
      i += 1
    }
    true
  }

  @inline
  private def matchKeyword(s: String)(
    implicit begin: (Int, Int, Int)): Boolean = {
    matchCharSeq(s)
    if (!isSeparator(peek())) {
      reporter.error(begin._1, begin._2, begin._3,
        s"Expecting keyword: '$s', but found: '${input.substring(begin._3, offset + 1)}'")
      false
    } else true
  }

  private def matchCharSeq(s: String)(
    implicit begin: (Int, Int, Int)): Boolean = {
    var i = 0
    var ok = true
    while (i < s.length && ok) {
      if (s.charAt(i) != peek()) {
        ok = false
        reporter.error(begin._1, begin._2, begin._3,
          s"Expecting: '$s', but found: '${input.substring(begin._3, offset)}'")
      }
      consume()
      i += 1
    }
    ok
  }

  @inline
  private def parseWhiteSpace(): Unit = {
    while (isWhitespace(peek())) consume()
  }

  @inline
  private def matchChar(char: Int)(f: => Unit): Boolean = {
    val c = peek()
    if (c != char) {
      f
      false
    } else {
      consume()
      true
    }
  }

  @inline
  private def consume(): Char = {
    val c = input.charAt(offset)
    if (c == '\n') {
      line += 1
      column = 1
    } else {
      column += 1
    }
    offset += 1
    c
  }

  @inline
  private def peek(index: Int = 0): Int = {
    val n = offset + index
    if (n < max && n >= 0) input.charAt(n) else -1
  }
}

object FastParser {

  implicit class At[T <: Node](val n: T) extends AnyVal {
    def at(offset: Int, line: Int, column: Int)(
      implicit t: (Int, Int, Int)): T = {
      n.locationInfoOpt = Some(org.sireum.util.LocationInfo(
        t._1, t._2, line, column, t._3, offset - t._3 + 1
      ))
      n
    }
  }

  trait Reporter {
    def error(line: Int, column: Int, offset: Int, message: String): Unit
  }

  object ConsoleReporter extends Reporter {
    override def error(line: Int, column: Int, offset: Int,
                       message: String): Unit = {
      Console.err.println(s"[$line, $column] $message")
      Console.err.flush()
    }
  }

  @inline
  final def isJavaLetter(c: Int) =
    (c >= 'a' && c <= 'z') ||
      (c >= 'A' && c <= 'Z') ||
      (c == '$') || (c == '_')

  @inline
  final def isJavaDigit(c: Int) = c >= '0' && c <= '9'

  @inline
  final def isWhitespace(c: Int) = c match {
    case '\r' | '\n' | '\t' | '\u000C' => true
    case _ => false
  }

  @inline
  final def isSeparator(c: Int) =
    if (isWhitespace(c)) true
    else c match {
      case ';' | '(' | ',' | ')' | '{' | '}' | '\'' |
           '\"' | '#' | ':' | '|' | '_' | '@' | '`' | -1 => true
      case _ => false
    }

  @inline
  final def isEOF(c: Int) = c == -1
}
