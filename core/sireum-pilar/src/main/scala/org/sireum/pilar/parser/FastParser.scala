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
  val fourQuotes = "\"\"\"\""

  def parseExp(): Option[Exp] = ???

  def parsePrimaryExp(recover: () => Unit): Option[Exp] = {
    implicit val begin = (line, column, offset)
    def parseTupleExp() = {
      consume()
      parseWhiteSpace()
      val rOpt = parseExp().flatMap { e =>
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
        if (ok) {
          val anns = parseAnnotations()
          Some(TupleExp(es, anns) at(offset, line, column))
        } else None
      }
      rOpt match {
        case Some(_) =>
          parseWhiteSpace()
          rOpt
        case _ =>
          recover()
          None
      }
    }

    def parseIdOrLitExp() = {
      parseID(recover).flatMap { id =>
        parseWhiteSpace()
        peek() match {
          case '\'' | '\"' =>
            parseLIT(recover).map(raw =>
              LiteralExp(id, raw).at(offset, line, column))
          case _ =>
            val r = IdExp(id)
            r.locationInfoOpt = id.locationInfoOpt
            Some(r)
        }
      }
    }

    val r =
      if (peek() == '(') parseTupleExp()
      else parseIdOrLitExp()
    parseWhiteSpace()
    r
  }

  def parseAnnotations(): Node.Seq[Annotation] = ???


  def parseAnnotation(recover: () => Unit): Option[Annotation] = {
    implicit val begin = (line, column, offset)

    if (matchChar('@') {
      reporter.error(begin._1, begin._2, begin._3,
        s"Expecting: '@', but found: '${input.charAt(begin._3)}'")
      recover()
    }) {
      for (
        id <- parseID(recover);
        raw <- {
          parseWhiteSpace()
          parseLIT(recover)
        }) yield {
        val r = Annotation(id, raw) at(offset, line, column)
        parseWhiteSpace()
        r
      }
    } else None
  }

  def parseID(recover: () => Unit): Option[Id] = {
    val r = peek() match {
      case '`' =>
        val (ok, i) = peekComplexID()
        parseComplexID(ok, i, recover)
      case '.' =>
        val (ok, i) = peekDotID()
        parseDotID(ok, i, recover)
      case _ =>
        val (ok, i) = peekSimpleID()
        parseSimpleID(ok, i, recover)
    }
    parseWhiteSpace()
    r
  }

  @inline
  def parseComplexID(ok: Boolean, i: Int, recover: () => Unit) = {
    implicit val begin = (line, column, offset)
    val r =
      if (ok) {
        for (j <- 0 until i) consume()
        Some(Id(input.substring(begin._3 + 1, offset - 1), Id.Complex).
          at(offset, line, column))
      } else {
        reporter.error(begin._1, begin._2, begin._3,
          s"Expecting a complex identifier form but found: '${input.substring(begin._3, offset + i)}'")
        recover()
        None
      }
    parseWhiteSpace()
    r
  }

  @inline
  def parseDotID(ok: Boolean, i: Int, recover: () => Unit) = {
    implicit val begin = (line, column, offset)
    val r =
      if (ok) {
        for (j <- 0 until i) consume()
        Some(Id(input.substring(begin._3 + 1, offset), Id.Dot).
          at(offset, line, column))
      } else {
        reporter.error(begin._1, begin._2, begin._3,
          s"Expecting a dot identifier form but found: '${input.substring(begin._3, offset + i)}'")
        recover()
        None
      }
    parseWhiteSpace()
    r
  }

  @inline
  def parseSimpleID(ok: Boolean, i: Int, recover: () => Unit) = {
    implicit val begin = (line, column, offset)
    val r =
      if (ok) {
        for (j <- 0 until i) consume()
        Some(Id(input.substring(begin._3, offset), Id.Simple).
          at(offset, line, column))
      } else {
        if (i == 0)
          reporter.error(begin._1, begin._2, begin._3,
            "Expecting an identifier but found" + (
              if (offset + i < max) s": '${peek().asInstanceOf[Char]}'"
              else " nothing"))
        else
          reporter.error(begin._1, begin._2, begin._3,
            s"Expecting a simple identifier form but found: '${input.substring(begin._3, offset + i)}'")
        recover()
        None
      }
    parseWhiteSpace()
    r
  }

  def peekID() = peek() match {
    case '`' => (Id.Complex, peekComplexID())
    case '.' => (Id.Dot, peekDotID())
    case _ => (Id.Simple, peekSimpleID())
  }

  def peekSimpleID() = peekOneStar(isJavaLetter, isJavaDigitOrLetter)

  def peekDotID() =
    peekOnePlus('.', isNotSeparator)

  def peekComplexID() = peekOnePlusOne('`', isComplexIDChar, '`')

  def parseLIT(recover: () => Unit): Option[Raw] = {
    val r = peek() match {
      case '\'' =>
        val (ok, i) = peekSimpleLIT()
        parseSimpleLIT(ok, i, recover)
      case '"' =>
        val (ok, i) = peekComplexLIT()
        parseComplexLIT(ok, i, recover)
      case c =>
        reporter.error(line, column, offset,
          s"Invalid character for a literal string: '${c.asInstanceOf[Char]}'")
        recover()
        None
    }
    parseWhiteSpace()
    r
  }

  @inline
  def parseSimpleLIT(ok: Boolean, i: Int, recover: () => Unit) = {
    implicit val begin = (line, column, offset)
    val r =
      if (ok) {
        for (j <- 0 until i) consume()
        Some(Raw(input.substring(begin._3 + 1, offset)).
          at(offset, line, column))
      } else {
        reporter.error(begin._1, begin._2, begin._3,
          s"Expecting a single-quoted string literal but found: '${input.substring(begin._3, offset + i)}'")
        recover()
        None
      }
    parseWhiteSpace()
    r
  }

  @inline
  def parseComplexLIT(ok: Boolean, i: Int, recover: () => Unit): Option[Raw] = {
    implicit val begin = (line, column, offset)
    val r =
      if (ok) {
        for (j <- 0 until i) consume()
        Some(Raw(input.substring(begin._3 + 3, offset - 3)).
          at(offset, line, column))
      } else {
        reporter.error(begin._1, begin._2, begin._3,
          s"Expecting a multi-line string literal but found: '${input.substring(begin._3, offset + i)}'")
        recover()
        None
      }
    parseWhiteSpace()
    r
  }

  private def peekLIT(): (Boolean, (Boolean, Int)) = {
    peek() match {
      case '\'' => (true, peekSimpleLIT())
      case '"' => (false, peekComplexLIT())
      case _ => (false, (false, 0))
    }
  }

  private def peekSimpleLIT() = peekOnePlus('\'', isNotSeparator)

  private def peekComplexLIT(): (Boolean, Int) = {
    // http://hackingoff.com/compilers/regular-expression-to-nfa-dfa
    // """(A|"("|A)|""("|A)|"""("|A))*""""*
    // A is any char that is not "
    var state = 0
    var i = 0
    var ok = true
    var continue = true
    while (ok && continue) {
      val c = peek(i)
      state match {
        case 0 | 1 | 2 =>
          c match {
            case '"' =>
              state += 1
              i += 1
            case _ => ok = false
          }
        case 3 =>
          c match {
            case EOF => ok = false
            case '"' =>
              state = 4
              i += 1
            case _ =>
              state = 5
              i += 1
          }
        case 4 =>
          c match {
            case EOF => ok = false
            case '"' =>
              state = 6
              i += 1
            case _ =>
              state = 7
              i += 1
          }
        case 5 =>
          c match {
            case EOF => ok = false
            case '"' =>
              state = 4
              i += 1
            case _ =>
              // state = 5
              i += 1
          }
        case 6 =>
          c match {
            case EOF => ok = false
            case '"' =>
              state = 8
              i += 1
            case _ =>
              state = 9
              i += 1
          }
        case 7 =>
          c match {
            case EOF => ok = false
            case '"' =>
              state = 4
              i += 1
            case _ =>
              state = 5
              i += 1
          }
        case 8 =>
          c match {
            case EOF => continue = false
            case '"' =>
              state = 10
              i += 1
            case _ =>
              state = 11
              i += 1
          }
        case 9 =>
          c match {
            case EOF => ok = false
            case '"' =>
              state = 4
              i += 1
            case _ =>
              state = 5
              i += 1
          }
        case 10 =>
          c match {
            case EOF => continue = false
            case '"' =>
              state = 12
              i += 1
            case _ =>
              state = 13
              i += 1
          }
        case 11 =>
          c match {
            case EOF => ok = false
            case '"' =>
              state = 4
              i += 1
            case _ =>
              state = 5
              i += 1
          }
        case 12 =>
          c match {
            case EOF => continue = false
            case '"' =>
              state = 14
              i += 1
            case _ =>
              state = 15
              i += 1
          }
        case 13 =>
          c match {
            case EOF => ok = false
            case '"' =>
              state = 4
              i += 1
            case _ =>
              state = 5
              i += 1
          }
        case 14 =>
          c match {
            case EOF => continue = false
            case '"' =>
              state = 16
              i += 1
            case _ =>
              state = 17
              i += 1
          }
        case 15 =>
          c match {
            case EOF => ok = false
            case '"' =>
              state = 4
              i += 1
            case _ =>
              state = 5
              i += 1
          }
        case 16 =>
          c match {
            case EOF => continue = false
            case '"' =>
              state = 14
              i += 1
            case _ =>
              state = 15
              i += 1
          }
        case 17 =>
          c match {
            case EOF => ok = false
            case '"' =>
              state = 4
              i += 1
            case _ =>
              state = 5
              i += 1
          }
      }
    }
    (ok, i)
  }

  private def peekOnePlusOne(C: Char,
                             D: Int => Boolean,
                             E: Char): (Boolean, Int) = {
    // http://hackingoff.com/compilers/regular-expression-to-nfa-dfa
    // CD+E
    // C is the starting character
    // D is the predicate for acceptable following characters until E
    // E is the ending character
    var state = 0
    var i = 0
    var ok = true
    var continue = true
    while (ok && continue) {
      val c = peek(i)
      state match {
        case 0 =>
          c match {
            case C =>
              state = 1
              i += 1
            case _ => ok = false
          }
        case 1 =>
          if (D(c)) {
            state = 2
            i += 1
          } else ok = false
        case 2 =>
          c match {
            case E =>
              state = 3
              i += 1
            case _ if D(c) =>
              // state = 2
              i += 1
            case _ => ok = false
          }
        case 3 => continue = false
      }
    }
    (ok, i)
  }

  private def peekOnePlus(C: Char, D: Int => Boolean): (Boolean, Int) = {
    // http://hackingoff.com/compilers/regular-expression-to-nfa-dfa
    // CD+
    // C is the starting character
    // D is the predicate for acceptable following characters
    var state = 0
    var i = 0
    var ok = true
    var continue = true
    while (ok && continue) {
      val c = peek(i)
      state match {
        case 0 =>
          c match {
            case C =>
              state = 1
              i += 1
            case _ => ok = false
          }
        case 1 =>
          if (D(c)) {
            state = 2
            i += 1
          } else ok = false
        case 2 =>
          if (D(c)) {
            // state = 2
            i += 1
          } else continue = false
      }
    }
    (ok, i)
  }

  private def peekOneStar(C: Int => Boolean, D: Int => Boolean): (Boolean, Int) = {
    // http://hackingoff.com/compilers/regular-expression-to-nfa-dfa
    // CD*
    // C is the predicate for starting character
    // D is the predicate for acceptable following characters
    var state = 0
    var i = 0
    var ok = true
    var continue = true
    while (ok && continue) {
      val c = peek(i)
      state match {
        case 0 =>
          if (C(c)) {
            state = 1
            i += 1
          } else ok = false
        case 1 =>
          if (D(c)) {
            state = 2
            i += 1
          } else continue = false
        case 2 =>
          if (D(c)) {
            // state = 2
            i += 1
          } else continue = false
      }
    }
    (ok, i)
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
      } else consume()
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
    if (0 <= n && n < max) input.charAt(n) else EOF
  }
}

object FastParser {
  final val EOF = -1

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
  final def isJavaDigitOrLetter(c: Int) = isJavaDigit(c) || isJavaLetter(c)

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
           '\"' | '#' | ':' | '@' | '`' | EOF => true
      case _ => false
    }

  @inline
  final def isNotSeparator(c: Int) = !isSeparator(c)

  @inline
  def isComplexIDChar(c: Int) = c match {
    case '\r' | '\n' | '\t' | '\u000C' | '`' => false
    case _ => true
  }

  @inline
  final def isEOF(c: Int) = c == EOF
}
