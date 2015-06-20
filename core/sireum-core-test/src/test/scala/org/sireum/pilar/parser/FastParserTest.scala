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
    assert(parseLIT(
      s"${threeQuotes}abc${sixQuotes}abc$threeQuotes") contains
      Raw(s"abc${sixQuotes}abc"))
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
    assert(parseID(".+") contains Id("+", simple = false))
  }

  @Test
  def parseID5(): Unit = {
    assert(parseID( """`a"sdsbc2`""") contains
      Id( """a"sdsbc2""", simple = false))
  }

  @Test
  def parseID6(): Unit = {
    assert(parseID( """!s""", reporter(0)).isEmpty)
  }

  @Test
  def parseID7(): Unit = {
    assert(parseID( """s!s""") contains Id("s"))
  }

  @Test
  def parseAnnotation1(): Unit = {
    assert(parseAnnotation( """@z'111""") contains
      Annotation(Id("z"), Raw("111")))
  }

  private def parseLIT(s: String) =
    new FastParser(s)().parseLIT(noRecover)

  private def parseID(s: String, reporter: FastParser.Reporter) =
    new FastParser(s, reporter)().parseID(noRecover)

  private def parseID(s: String) =
    new FastParser(s)().parseID(noRecover)

  private def parseAnnotation(s: String) =
    new FastParser(s)().parseAnnotation(noRecover)

  private def reporter(_offset: Int) =
    new FastParser.Reporter {
      override def error(line: Int, column: Int,
                         offset: Int, message: String): Unit = {
        assert(offset == _offset)
      }
    }
}
