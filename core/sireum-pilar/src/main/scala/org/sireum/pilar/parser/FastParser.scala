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
import org.sireum.pilar.parser.FastParser._
import org.sireum.util._

final class FastParser(input: String,
                       reporter: Reporter = ConsoleReporter)(
  max: Natural = input.length,
  private var line: PosInteger = 1,
  private var column: PosInteger = 1,
  private var offset: Natural = 0) {
  val min = offset

  def parseExp(recover: () => Unit): Option[Exp] = {
    implicit val begin = (line, column, offset)

    val rOpt = parsePrimaryExp2(recover)

    if (rOpt.isEmpty) return None
    val r = rOpt.get

    parseWhiteSpace()

    var ok = true
    var (kind, (continue, i)) = peekID()
    var suffix = Node.emptySeq[(Id, Exp)]
    while (ok && continue) {
      val id = parseID(kind, i, recover).get

      parseWhiteSpace()

      parsePrimaryExp2(recover) match {
        case Some(e) => suffix = suffix :+ ((id, e))
        case _ => ok = false
      }

      if (ok) {
        parseWhiteSpace()

        val p = peekID()
        kind = p._1
        continue = p._2._1
        i = p._2._2
      }
    }
    if (ok && suffix.nonEmpty) {
      val (op, right) = suffix.head
      Some(BinaryExp(r, op, right, suffix.tail).
        at(line, column, offset))
    } else Some(r)
  }

  def parsePrimaryExp2(recover: () => Unit): Option[Exp] = {
    implicit val begin = (line, column, offset)

    var r =
      parsePrimaryExp(recover) match {
        case Some(prim) => prim
        case None => return None
      }

    parseWhiteSpace()

    var ok = true
    while (charEq(peek(), '(') && ok) {
      parseArg(recover) match {
        case Some(es) =>
          r = CallExp(r, es) at(line, column, offset)
        case _ => ok = false
      }
      parseWhiteSpace()
    }
    Some(r)
  }

  def parseArg(recover: () => Unit): Option[Node.Seq[Exp]] = {
    def rcv(): Unit = {
      var i = findChar(',')
      if (i >= 0) {
        consume(i)
        return
      }
      i = findChar(')')
      if (i >= 0) {
        consume(i)
        return
      }
    }

    implicit val begin = (line, column, offset)

    var ok = matchChar('(') { s =>
      reporter.error(begin._1, begin._2, begin._3,
        s"Expecting: '(', but found $s")
      recover()
    }
    if (!ok) return None

    var es = Node.emptySeq[Exp]

    parseWhiteSpace()

    if (charEq(peek(), ')')) {
      consume()
      return Some(es)
    }

    val eOpt = parseExp(recover)
    if (eOpt.isEmpty) return None

    parseWhiteSpace()

    es = es :+ eOpt.get

    while (charEq(peek(), ',') && ok) {
      consume()
      parseWhiteSpace()
      parseExp(rcv) match {
        case Some(e2) => es = es :+ e2
        case _ => ok = false
      }
      parseWhiteSpace()
    }
    ok = ok && matchChar(')') { s =>
      reporter.error(line, column, offset,
        s"Expecting: ')', but found $s")
      recover()
    }
    if (ok) Some(es) else None
  }

  def parsePrimaryExp(recover: () => Unit): Option[Exp] = {
    @inline
    def parseTupleExp(): Option[Exp] = {
      def rcv(): Unit = {
        var i = findChar(',')
        if (i >= 0) {
          consume(i)
          return
        }
        i = findChar(')')
        if (i >= 0) {
          consume(i)
          return
        }
      }

      implicit val begin = (line, column, offset)

      consume()

      parseWhiteSpace()

      val eOpt = parseExp(rcv)
      if (eOpt.isEmpty) return None
      val e = eOpt.get
      var ok = true
      var es = Node.seq(e)
      while (charEq(peek(), ',') && ok) {
        consume()
        parseWhiteSpace()
        parseExp(rcv) match {
          case Some(e2) => es = es :+ e2
          case _ => ok = false
        }
        parseWhiteSpace()
      }
      ok = ok && matchChar(')') { s =>
        reporter.error(line, column, offset,
          s"Expecting: ')', but found $s")
        recover()
      }
      if (ok) {
        Some(TupleExp(es, parseAnnotations(recover)).
          at(line, column, offset))
      } else None
    }

    @inline
    def parseIdOrLitExp(): Option[Exp] = {
      implicit val begin = (line, column, offset)

      val idOpt = parseID(recover)
      if (idOpt.isEmpty) return None
      val id = idOpt.get
      peek() match {
        case '\'' | '\"' =>
          parseLIT(recover).map(raw =>
            LiteralExp(id, raw).at(line, column, offset))
        case _ =>
          val r = IdExp(id)
          r.locationInfoOpt = id.locationInfoOpt
          Some(r)
      }
    }

    if (charEq(peek(), '(')) parseTupleExp()
    else parseIdOrLitExp()
  }

  def parseAnnotations(recover: () => Unit): Node.Seq[Annotation] = {
    def rcv(): Unit = {
      val i = findChar('@')
      if (i >= 0) consume(i)
      else recover()
    }

    var r = Node.emptySeq[Annotation]
    while (charEq(peek(), '@')) {
      parseAnnotation(rcv).foreach(a => r = r :+ a)
    }
    r
  }

  def parseAnnotation(recover: () => Unit): Option[Annotation] = {
    implicit val begin = (line, column, offset)

    if (!matchChar('@') { s =>
      reporter.error(begin._1, begin._2, begin._3,
        s"Expecting: '@', but found $s")
      recover()
    }) return None

    parseWhiteSpace()
    for (
      id <- parseID(recover);
      raw <- {
        parseWhiteSpace()
        parseLIT(recover)
      }) yield {
      Annotation(id, raw) at(line, column, offset)
    }
  }

  def parseID(recover: () => Unit): Option[Id] =
    peek() match {
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

  def parseLIT(recover: () => Unit): Option[Raw] =
    peek() match {
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

  @inline
  private def parseID(kind: Id.Value, i: Natural, recover: () => Unit) =
    kind match {
      case Id.Simple => parseSimpleID(ok = true, i, recover)
      case Id.Dot => parseDotID(ok = true, i, recover)
      case Id.Complex => parseComplexID(ok = true, i, recover)
    }

  @inline
  private def parseComplexID(ok: Boolean, i: Natural, recover: () => Unit) = {
    implicit val begin = (line, column, offset)
    if (ok) {
      consume(i)
      Some(Id(input.substring(begin._3 + 1, offset - 1), Id.Complex).
        at(line, column, offset))
    } else {
      reporter.error(begin._1, begin._2, begin._3,
        s"Expecting a complex identifier form but found: '${input.substring(begin._3, offset + i)}'")
      recover()
      None
    }
  }

  @inline
  private def parseDotID(ok: Boolean, i: Natural, recover: () => Unit) = {
    implicit val begin = (line, column, offset)
    if (ok) {
      consume(i)
      Some(Id(input.substring(begin._3 + 1, offset), Id.Dot).
        at(line, column, offset))
    } else {
      reporter.error(begin._1, begin._2, begin._3,
        s"Expecting a dot identifier form but found: '${input.substring(begin._3, offset + i)}'")
      recover()
      None
    }
  }

  @inline
  private def parseSimpleID(ok: Boolean, i: Natural, recover: () => Unit) = {
    implicit val begin = (line, column, offset)
    if (ok) {
      consume(i)
      Some(Id(input.substring(begin._3, offset), Id.Simple).
        at(line, column, offset))
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
  }

  @inline
  private def peekID() = peek() match {
    case '`' => (Id.Complex, peekComplexID())
    case '.' => (Id.Dot, peekDotID())
    case _ => (Id.Simple, peekSimpleID())
  }

  @inline
  private def peekSimpleID() = peekOneStar(0, isJavaLetter, isJavaDigitOrLetter)

  @inline
  private def peekDotID(offset: Natural = 0) =
    peekOnePlus(offset, '.', isNotSeparator)

  @inline
  private def peekComplexID(offset: Natural = 0) =
    peekOnePlusOne(offset, '`', isComplexIDChar, '`')

  @inline
  private def parseSimpleLIT(ok: Boolean, i: Natural, recover: () => Unit) = {
    implicit val begin = (line, column, offset)
    if (ok) {
      consume(i)
      Some(Raw(input.substring(begin._3 + 1, offset)).
        at(line, column, offset))
    } else {
      reporter.error(begin._1, begin._2, begin._3,
        s"Expecting a single-quoted string literal but found: '${input.substring(begin._3, offset + i)}'")
      recover()
      None
    }
  }

  @inline
  private def parseComplexLIT(ok: Boolean, i: Natural, recover: () => Unit): Option[Raw] = {
    implicit val begin = (line, column, offset)
    if (ok) {
      consume(i)
      Some(Raw(input.substring(begin._3 + 1, offset - 1).
        replaceAll( """\\\\""", "\\").
        replaceAll( """\\"""", "\"")).
        at(line, column, offset))
    } else {
      reporter.error(begin._1, begin._2, begin._3,
        s"Expecting a multi-line string literal but found: '${input.substring(begin._3, offset + i)}'")
      recover()
      None
    }
  }

  private def peekLIT(): (Boolean, (Boolean, Natural)) = {
    peek() match {
      case '\'' => (true, peekSimpleLIT())
      case '"' => (false, peekComplexLIT())
      case _ => (false, (false, 0))
    }
  }

  private def peekSimpleLIT(offset: Natural = 0) =
    peekOneStar(offset, (c) => charEq(c, '\''), isNotSeparator)

  private def peekComplexLIT(offset: Natural = 0): (Boolean, Natural) = {
    // http://hackingoff.com/compilers/regular-expression-to-nfa-dfa
    // "(N|S("|S))*"
    // N is any char that is not "
    // S is \
    var state = 0
    var i = 0
    var ok = true
    var continue = true
    while (ok && continue) {
      val c = peek(offset + i)
      state match {
        case 0 =>
          c match {
            case '"' =>
              state = 1
              i += 1
            case _ => ok = false
          }
        case 1 =>
          c match {
            case '"' =>
              state = 2
              i += 1
            case '\\' =>
              state = 4
              i += 1
            case _ =>
              if (charNe(c, '"')) {
                state = 3
                i += 1
              } else ok = false
          }
        case 2 =>
          continue = false
        case 3 =>
          c match {
            case '"' =>
              state = 2
              i += 1
            case '\\' =>
              state = 4
              i += 1
            case _ =>
              if (charNe(c, '"')) {
                // state = 3
                i += 1
              } else ok = false
          }
        case 4 =>
          c match {
            case '"' =>
              state = 5
              i += 1
            case '\\' =>
              state = 6
              i += 1
            case _ => ok = false
          }
        case 5 =>
          c match {
            case '"' =>
              state = 2
              i += 1
            case '\\' =>
              state = 4
              i += 1
            case _ =>
              if (charNe(c, '"')) {
                state = 3
                i += 1
              } else ok = false
          }
        case 6 =>
          c match {
            case '"' =>
              state = 2
              i += 1
            case '\\' =>
              state = 4
              i += 1
            case _ =>
              if (charNe(c, '"')) {
                state = 3
                i += 1
              } else ok = false
          }
      }
    }
    (ok, offset + i)
  }

  private def peekOnePlusOne(offset: Natural,
                             C: Char,
                             D: Int => Boolean,
                             E: Char): (Boolean, Natural) = {
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
      val c = peek(offset + i)
      state match {
        case 0 =>
          if (charEq(c, C)) {
            state = 1
            i += 1
          } else ok = false
        case 1 =>
          if (D(c)) {
            state = 2
            i += 1
          } else ok = false
        case 2 =>
          if (charEq(c, E)) {
            state = 3
            i += 1
          } else if (D(c)) {
            // state = 2
            i += 1
          } else ok = false
        case 3 => continue = false
      }
    }
    (ok, offset + i)
  }

  private def peekOnePlus(offset: Natural,
                          C: Char,
                          D: CharSentinel => Boolean): (Boolean, Natural) = {
    // http://hackingoff.com/compilers/regular-expression-to-nfa-dfa
    // CD+
    // C is the starting character
    // D is the predicate for acceptable following characters
    var state = 0
    var i = 0
    var ok = true
    var continue = true
    while (ok && continue) {
      val c = peek(offset + i)
      state match {
        case 0 =>
          if (charEq(c, C)) {
            state = 1
            i += 1

          } else ok = false
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
    (ok, offset + i)
  }

  private def peekOneStar(offset: Natural,
                          C: CharSentinel => Boolean,
                          D: CharSentinel => Boolean): (Boolean, Natural) = {
    // http://hackingoff.com/compilers/regular-expression-to-nfa-dfa
    // CD*
    // C is the predicate for starting character
    // D is the predicate for acceptable following characters
    var state = 0
    var i = 0
    var ok = true
    var continue = true
    while (ok && continue) {
      val c = peek(offset + i)
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
    (ok, offset + i)
  }

  private def peekCharSeq(s: String): Boolean = {
    var i = 0
    while (i < s.length) {
      if (charNe(peek(i), s.charAt(i))) return false
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
    } else {
      true
    }
  }

  @inline
  private def matchCharSeq(s: String)(
    implicit begin: (Int, Int, Int)): Boolean = {
    var i = 0
    var ok = true
    while (i < s.length && ok) {
      if (charNe(peek(), s.charAt(i))) {
        ok = false
        if (i == 0)
          reporter.error(begin._1, begin._2, begin._3,
            s"Expecting: '$s', but found nothing")
        else
          reporter.error(begin._1, begin._2, begin._3,
            s"Expecting: '$s', but found: '${input.substring(begin._3, offset)}'")
      } else consume()
      i += 1
    }
    ok
  }

  private def parseWhiteSpace(): Unit = {
    while (isWhitespace(peek())) consume()
  }

  @inline
  private def matchChar(char: Char)(f: String => Unit): Boolean = {
    val c = peek()
    if (charNe(c, char)) {
      if (c == EOF) f(" nothing") else f(s": '${c.asInstanceOf[Char]}'")
      false
    } else {
      consume()
      true
    }
  }

  @inline
  private def findChar(c: Char): Natural = {
    var i = 0
    var d = peek(i)
    while (d != EOF && charNe(d, c)) {
      d match {
        case '"' =>
          val (ok, j) = peekComplexLIT(i)
          if (ok)
            i = j + 1
        case '\'' =>
          val (ok, j) = peekSimpleLIT(i)
          if (ok)
            i = j + 1
        case '`' =>
          val (ok, j) = peekComplexID(i)
          if (ok)
            i = j + 1
        case '.' =>
          val (ok, j) = peekDotID(i)
          if (ok)
            i = j + 1
        case _ =>
          i += 1
      }
      d = peek(i)
    }
    if (charEq(d, c)) i else -1
  }

  @inline
  private def consume(n: Natural): Unit = {
    var i = 0
    while (i < n) {
      consume()
      i += 1
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
  private def peek(index: Natural = 0): CharSentinel = {
    val n = offset + index
    if (0 <= n && n < max) input.charAt(n) else EOF
  }

  @inline
  private def isJavaLetter(c: CharSentinel) =
    (c >= 'a' && c <= 'z') ||
      (c >= 'A' && c <= 'Z') ||
      charEq(c, '$') || charEq(c, '_')

  @inline
  private def isJavaDigit(c: CharSentinel) = c >= '0' && c <= '9'

  @inline
  private def isJavaDigitOrLetter(c: CharSentinel) =
    isJavaDigit(c) || isJavaLetter(c)

  @inline
  private def isWhitespace(c: CharSentinel) = c match {
    case ' ' | '\r' | '\n' | '\t' | '\u000C' => true
    case _ => false
  }

  @inline
  private def isSeparator(c: CharSentinel) =
    if (isWhitespace(c)) true
    else c match {
      case ';' | '(' | ',' | ')' | '{' | '}' | '\'' |
           '\"' | '#' | ':' | '@' | '`' | EOF => true
      case _ => false
    }

  @inline
  private def isNotSeparator(c: CharSentinel) = !isSeparator(c)

  @inline
  private def isComplexIDChar(c: CharSentinel) = c match {
    case '\r' | '\n' | '\t' | '\u000C' | '`' => false
    case _ => true
  }

  @inline
  private def isEOF(c: CharSentinel) = c == EOF

  @inline
  private def charEq(cs: CharSentinel, c: Char) = cs == c.toInt

  @inline
  private def charNe(cs: CharSentinel, c: Char) = cs != c.toInt
}

object FastParser {
  final val EOF = naturalSentinel

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

  private[parser] implicit class At[T <: Node](val n: T) extends AnyVal {
    def at(line: PosInteger,
           column: PosInteger,
           offset: Natural)(
            implicit t: (Int, Int, Int)): T = {
      n.locationInfoOpt = Some(org.sireum.util.LocationInfo(
        t._1, t._2, line, column, t._3, offset - t._3 + 1
      ))
      n
    }
  }

}
