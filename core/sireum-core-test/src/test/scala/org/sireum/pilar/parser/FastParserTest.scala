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

import org.junit.Test
import org.sireum.pilar.ast._

final class FastParserTest {
  private val threeQuotes = "\"\"\""
  private val sixQuotes = "\"\"\"\"\"\""

  private val noRecover = { () => }

  @Test
  def parseLIT1(): Unit = {
    assert(parseLIT("'abc") contains Raw("abc"))
  }

  @Test
  def parseLIT2(): Unit = {
    val r = parseLIT(
      s"${threeQuotes}abc${sixQuotes}abc$threeQuotes")
    val e = Raw(s"abc${sixQuotes}abc")
    assert(r contains e)
  }

  @Test
  def parseLIT3(): Unit = {
    assert(parseLIT("'") contains Raw(""))
  }

  @Test
  def parseID1(): Unit = {
    assert(parseID("abc") contains Id("abc"))
  }

  @Test
  def parseID2(): Unit = {
    assert(parseID("abc2") contains Id("abc2"))
  }

  @Test
  def parseID3(): Unit = {
    assert(parseID("abc3:") contains Id("abc3"))
  }

  @Test
  def parseID4(): Unit = {
    assert(parseID(".+") contains Id("+", Id.Dot))
  }

  @Test
  def parseID5(): Unit = {
    assert(parseID( """`a"sdsbc2`""") contains
      Id( """a"sdsbc2""", Id.Complex))
  }

  @Test
  def parseID6(): Unit = {
    assert(parseID( """s!s""") contains Id("s"))
  }

  @Test
  def parseFID1(): Unit = {
    assert(parseID( """!s""", reporter(0)).isEmpty)
  }

  @Test
  def parsePrimaryExp1(): Unit = {
    assert(parsePrimaryExp("abc") contains IdExp(Id("abc")))
  }

  @Test
  def parsePrimaryExp2(): Unit = {
    assert(parsePrimaryExp("abc2") contains IdExp(Id("abc2")))
  }

  @Test
  def parsePrimaryExp3(): Unit = {
    assert(parsePrimaryExp("abc3:") contains IdExp(Id("abc3")))
  }

  @Test
  def parsePrimaryExp4(): Unit = {
    assert(parsePrimaryExp(".+") contains IdExp(Id("+", Id.Dot)))
  }

  @Test
  def parsePrimaryExp5(): Unit = {
    assert(parsePrimaryExp( """`a"sdsbc2`""") contains
      IdExp(Id( """a"sdsbc2""", Id.Complex)))
  }

  @Test
  def parsePrimaryExp6(): Unit = {
    assert(parsePrimaryExp( """s!s""") contains IdExp(Id("s")))
  }

  @Test
  def parsePrimaryExp7(): Unit = {
    assert(parsePrimaryExp( """z'-1""") contains
      LiteralExp(Id("z"), Raw("-1")))
  }

  @Test
  def parsePrimaryExp8(): Unit = {
    assert(parsePrimaryExp( """(z'-1, b'true ,usd'1_000_000)""") contains
      TupleExp(
        Node.seq(
          LiteralExp(Id("z"), Raw("-1")),
          LiteralExp(Id("b"), Raw("true")),
          LiteralExp(Id("usd"), Raw("1_000_000"))),
        Node.emptySeq))
  }

  @Test
  def parseFPrimaryExp1(): Unit = {
    assert(parsePrimaryExp( """!s""", reporter(0)).isEmpty)
  }

  @Test
  def parseAnnotation1(): Unit = {
    assert(parseAnnotation( """@z'111""") contains
      Annotation(Id("z"), Raw("111")))
  }

  @Test
  def parseAnnotationRecovery(): Unit = {
    assert(parseAnnotations("@ 5 sdaekcn;sgej() @type 'Int", reporter(2)) ==
      Seq(Annotation(Id("type"), Raw("Int"))))
  }

  @Test
  def parseExp1(): Unit = {
    assert(parseExp("abc") contains IdExp(Id("abc")))
  }

  @Test
  def parseExp2(): Unit = {
    assert(parseExp("abc2") contains IdExp(Id("abc2")))
  }

  @Test
  def parseExp3(): Unit = {
    assert(parseExp("abc3:") contains IdExp(Id("abc3")))
  }

  @Test
  def parseExp4(): Unit = {
    assert(parseExp(".+") contains IdExp(Id("+", Id.Dot)))
  }

  @Test
  def parseExp5(): Unit = {
    assert(parseExp( """`a"sdsbc2`""") contains
      IdExp(Id( """a"sdsbc2""", Id.Complex)))
  }

  @Test
  def parseExp6(): Unit = {
    assert(parseExp( """s!s""") contains IdExp(Id("s")))
  }

  @Test
  def parseExp7(): Unit = {
    assert(parseExp( """z'-1""") contains
      LiteralExp(Id("z"), Raw("-1")))
  }

  @Test
  def parseExp8(): Unit = {
    val r = parseExp( """(z'-1, b'true ,usd'1_000_000)""")
    val e =
      TupleExp(
        Node.seq(
          LiteralExp(Id("z"), Raw("-1")),
          LiteralExp(Id("b"), Raw("true")),
          LiteralExp(Id("usd"), Raw("1_000_000"))),
        Node.emptySeq)
    assert(r contains e)
  }

  @Test
  def parseExp9(): Unit = {
    val r = parseExp("a(b,c)")
    val e = CallExp(IdExp(Id("a")), Node.seq(IdExp(Id("b")), IdExp(Id("c"))))
    assert(r contains e)
  }

  @Test
  def parseExp10(): Unit = {
    val r = parseExp("a(b,c) .+ z'5 .* z'6")
    val expected = BinaryExp(
      CallExp(IdExp(Id("a")), Node.seq(IdExp(Id("b")), IdExp(Id("c")))),
      Id("+", Id.Dot),
      LiteralExp(Id("z"), Raw("5")),
      Node.seq(
        (Id("*", Id.Dot), LiteralExp(Id("z"), Raw("6")))
      )
    )
    assert(r contains expected)
  }


  import FastParser._

  private def parseExp(s: String,
                       reporter: Reporter = ConsoleReporter) =
    new FastParser(s, reporter)().parseExp(noRecover)

  private def parsePrimaryExp(s: String,
                              reporter: Reporter = ConsoleReporter) =
    new FastParser(s, reporter)().parsePrimaryExp(noRecover)

  private def parseLIT(s: String,
                       reporter: Reporter = ConsoleReporter) =
    new FastParser(s, reporter)().parseLIT(noRecover)

  private def parseID(s: String,
                      reporter: Reporter = ConsoleReporter) =
    new FastParser(s, reporter)().parseID(noRecover)

  private def parseAnnotation(s: String,
                              reporter: Reporter = ConsoleReporter) =
    new FastParser(s, reporter)().parseAnnotation(noRecover)

  private def parseAnnotations(s: String,
                               reporter: Reporter = ConsoleReporter) =
    new FastParser(s, reporter)().parseAnnotations(noRecover)

  private def reporter(_offset: Int) =
    new FastParser.Reporter {
      override def error(line: Int, column: Int,
                         offset: Int, message: String): Unit = {
        assert(offset == _offset)
      }
    }
}
