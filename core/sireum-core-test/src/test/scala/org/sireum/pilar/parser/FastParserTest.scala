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
import org.junit.Assert._
import org.sireum.pilar.ast._

final class FastParserTest {
  private val noRecover = { () => }

  @Test
  def parseLIT1(): Unit = {
    assertEquals(parseLIT("'abc").get, Raw("abc"))
  }

  @Test
  def parseLIT2(): Unit = {
    val r = parseLIT(
      "\"abc\\\"abc\"")
    val e = Raw("abc\"abc")
    assertEquals(r.get, e)
  }

  @Test
  def parseLIT3(): Unit = {
    assertEquals(parseLIT("'").get, Raw(""))
  }

  @Test
  def parseID1(): Unit = {
    assertEquals(parseID("abc").get, Id("abc"))
  }

  @Test
  def parseID2(): Unit = {
    assertEquals(parseID("abc2").get, Id("abc2"))
  }

  @Test
  def parseID3(): Unit = {
    assertEquals(parseID("abc3:").get, Id("abc3"))
  }

  @Test
  def parseID4(): Unit = {
    assertEquals(parseID(".+").get, Id("+", Id.Dot))
  }

  @Test
  def parseID5(): Unit = {
    assertEquals(parseID( """`a"sdsbc2`""").get,
      Id( """a"sdsbc2""", Id.Complex))
  }

  @Test
  def parseID6(): Unit = {
    assertEquals(parseID( """s!s""").get, Id("s"))
  }

  @Test
  def parseFID1(): Unit = {
    assertTrue(parseID( """!s""", reporter(0)).isEmpty)
  }

  @Test
  def parsePrimaryExp1(): Unit = {
    assertEquals(parsePrimaryExp("abc").get, IdExp(Id("abc")))
  }

  @Test
  def parsePrimaryExp2(): Unit = {
    assertEquals(parsePrimaryExp("abc2").get, IdExp(Id("abc2")))
  }

  @Test
  def parsePrimaryExp3(): Unit = {
    assertEquals(parsePrimaryExp("abc3:").get, IdExp(Id("abc3")))
  }

  @Test
  def parsePrimaryExp4(): Unit = {
    assertEquals(parsePrimaryExp(".+").get, IdExp(Id("+", Id.Dot)))
  }

  @Test
  def parsePrimaryExp5(): Unit = {
    assertEquals(
      parsePrimaryExp( """`a"sdsbc2`""").get,
      IdExp(Id( """a"sdsbc2""", Id.Complex)))
  }

  @Test
  def parsePrimaryExp6(): Unit = {
    assertEquals(parsePrimaryExp( """s!s""").get, IdExp(Id("s")))
  }

  @Test
  def parsePrimaryExp7(): Unit = {
    assertEquals(parsePrimaryExp( """z'-1""").get,
      LiteralExp(Id("z"), Raw("-1")))
  }

  @Test
  def parsePrimaryExp8(): Unit = {
    assertEquals(
      parsePrimaryExp( """(z'-1, b'true ,usd'1_000_000)""").get,
      TupleExp(
        Node.seq(
          LiteralExp(Id("z"), Raw("-1")),
          LiteralExp(Id("b"), Raw("true")),
          LiteralExp(Id("usd"), Raw("1_000_000"))),
        Node.emptySeq))
  }

  @Test
  def parseFPrimaryExp1(): Unit = {
    assertTrue(parsePrimaryExp( """!s""", reporter(0)).isEmpty)
  }

  @Test
  def parseAnnotation1(): Unit = {
    assertEquals(parseAnnotation( """@z'111""").get,
      Annotation(Id("z"), Raw("111")))
  }

  @Test
  def parseAnnotationRecovery1(): Unit = {
    assertEquals(
      parseAnnotations("@ 5 sdaekcn;sgej() @type 'Int", reporter(2)),
      Seq(Annotation(Id("type"), Raw("Int"))))
  }

  @Test
  def parseAnnotationRecovery2(): Unit = {
    assertEquals(
      parseAnnotations("@ 5 \"@\" sdaekcn;sgej() @type 'Int", reporter(2)),
      Seq(Annotation(Id("type"), Raw("Int"))))
  }

  @Test
  def parseExp1(): Unit = {
    assertEquals(parseExp("abc").get, IdExp(Id("abc")))
  }

  @Test
  def parseExp2(): Unit = {
    assertEquals(parseExp("abc2").get, IdExp(Id("abc2")))
  }

  @Test
  def parseExp3(): Unit = {
    assertEquals(parseExp("abc3:").get, IdExp(Id("abc3")))
  }

  @Test
  def parseExp4(): Unit = {
    assertEquals(parseExp(".+").get, IdExp(Id("+", Id.Dot)))
  }

  @Test
  def parseExp5(): Unit = {
    assertEquals(parseExp( """`a"sdsbc2`""").get,
      IdExp(Id( """a"sdsbc2""", Id.Complex)))
  }

  @Test
  def parseExp6(): Unit = {
    assertEquals(parseExp( """s!s""").get, IdExp(Id("s")))
  }

  @Test
  def parseExp7(): Unit = {
    assertEquals(parseExp( """z'-1""").get,
      LiteralExp(Id("z"), Raw("-1")))
  }

  @Test
  def parseExp8(): Unit = {
    val r = parseExp( """(z'-1, b'true ,usd'1_000_000)""").get
    val e =
      TupleExp(
        Node.seq(
          LiteralExp(Id("z"), Raw("-1")),
          LiteralExp(Id("b"), Raw("true")),
          LiteralExp(Id("usd"), Raw("1_000_000"))),
        Node.emptySeq)
    assertEquals(r, e)
  }

  @Test
  def parseExp9(): Unit = {
    val r = parseExp("a(b,c)").get
    val e = CallExp(IdExp(Id("a")), Node.seq(IdExp(Id("b")), IdExp(Id("c"))))
    assertEquals(r, e)
  }

  @Test
  def parseExp10(): Unit = {
    val r = parseExp("a(b,c) .+ z'5 .* z'6").get
    val expected = BinaryExp(
      CallExp(IdExp(Id("a")), Node.seq(IdExp(Id("b")), IdExp(Id("c")))),
      Id("+", Id.Dot),
      LiteralExp(Id("z"), Raw("5")),
      Node.seq(
        (Id("*", Id.Dot), LiteralExp(Id("z"), Raw("6")))
      )
    )
    assertEquals(r, expected)
  }

  @Test
  def parseTupleExpRecovery(): Unit = {
    assertTrue(parseExp( """( 5, x ,4)""", reporter(2, 8)).isEmpty)
  }

  @Test
  def parseCallExpRecovery(): Unit = {
    assertEquals(parseExp( """a( 5, x ,4)""", reporter(3, 9)).get,
      IdExp(Id("a")))
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

  private def reporter(_offset: Int*) =
    new FastParser.Reporter {
      var i = 0

      override def error(line: Int, column: Int,
                         offset: Int, message: String): Unit = {
        assertEquals(offset, _offset(i))
        i += 1
      }
    }
}
