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

class FastParserTest {
  final val threeQuotes = "\"\"\""

  @Test
  def parseLIT1(): Unit = {
    assert(new FastParser("'abc")().parseLIT() contains Raw("abc"))
  }

  @Test
  def parseLIT2(): Unit = {
    assert(new FastParser(s"${threeQuotes}abc$threeQuotes${threeQuotes}abc$threeQuotes")().
      parseLIT() contains
      Raw("abc\"\"\"abc"))
  }

  @Test
  def parseID1(): Unit = {
    assert(new FastParser("abc")().parseID() contains Id("abc"))
  }

  @Test
  def parseID2(): Unit = {
    assert(new FastParser("abc2")().parseID() contains Id("abc2"))
  }

  @Test
  def parseID3(): Unit = {

    assert(new FastParser("abc3:")().parseID() contains Id("abc3"))
  }

  @Test
  def parseID4(): Unit = {

    assert(new FastParser(".+")().parseID() contains Id("+", simple = false))
  }

  @Test
  def parseID5(): Unit = {
    assert(new FastParser( """`a"sdsbc2`""")().parseID() contains
      Id( """a"sdsbc2""", simple = false))
  }

  @Test
  def parseID6(): Unit = {
    assert(new FastParser( """!s""", reporter(0))().parseID().isEmpty)
  }

  @Test
  def parseID7(): Unit = {
    assert(new FastParser( """s!s""", reporter(1))().parseID().isEmpty)
  }

  def reporter(_offset: Int) =
    new FastParser.Reporter {
      override def error(line: Int, column: Int, offset: Int, message: String): Unit = {
        assert(offset == _offset)
      }
    }
}
