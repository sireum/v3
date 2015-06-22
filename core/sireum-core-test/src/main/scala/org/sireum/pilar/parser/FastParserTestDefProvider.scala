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

import org.sireum.test._
import org.sireum.pilar.ast._
import org.sireum.util._

final class FastParserTestDefProvider(tf: TestFramework)
  extends TestDefProvider {

  private val noRecover = { () => }

  override val testDefs: ISeq[TestDef] = ivector(

    EqualTest("AnnRecovery",
      parseAnnotations("@ 5 sdaekcn;sgej() @type 'Int", reporter(2)),
      Seq(Annotation(Id("type"), Raw("Int")))),

    EqualTest("AnnRecoveryString",
      parseAnnotations("@ 5 \"@\" sdaekcn;sgej() @type 'Int", reporter(2)),
      Seq(Annotation(Id("type"), Raw("Int")))),

    EqualOptTest("SimpleLit",
      parseLIT("'abc"),
      Raw("abc")),

    EqualOptTest("StringLit",
      parseLIT("\"abc\\\"abc\""),
      Raw("abc\"abc")),

    EqualOptTest("EmptyLit",
      parseLIT("'"),
      Raw("")),

    EqualOptTest("SimpleID1",
      parseID("abc"),
      Id("abc")),

    EqualOptTest("SimpleID2",
      parseID("abc2"),
      Id("abc2")),

    EqualOptTest("SimpleIDNotEnd1",
      parseID("abc3:"),
      Id("abc3")),

    EqualOptTest("SimpleIDNotEnd2",
      parseID( """s!s"""),
      Id("s")),

    EqualOptTest("OpID",
      parseID("+"),
      Id("+", Id.Op)),

    EqualOptTest("ComplexID",
      parseID( """`a"sdsbc2`"""),
      Id( """a"sdsbc2""", Id.Complex)),

    EqualOptTest("PrimaryExpSimpleID1",
      parsePrimaryExp("abc"),
      IdExp(Id("abc"))),

    EqualOptTest("PrimaryExpSimpleID2",
      parsePrimaryExp("abc2"),
      IdExp(Id("abc2"))),

    EqualOptTest("PrimaryExpSimpleIDNotEnd1",
      parsePrimaryExp("abc3:"),
      IdExp(Id("abc3"))),

    EqualOptTest("PrimaryExpSimpleIDNotEnd2",
      parsePrimaryExp( """s!s"""),
      IdExp(Id("s"))),

    EqualOptTest("PrimaryExpOpID",
      parsePrimaryExp("+"),
      IdExp(Id("+", Id.Op))),

    EqualOptTest("PrimaryExpComplexID",
      parsePrimaryExp( """`a"sdsbc2`"""),
      IdExp(Id( """a"sdsbc2""", Id.Complex))),

    EqualOptTest("PrimaryExpLit",
      parsePrimaryExp( """z'-1"""),
      LiteralExp(Id("z"), Raw("-1"))),

    EqualOptTest("PrimaryExpTuple",
      parsePrimaryExp( """(z'-1, b'true ,usd'1_000_000)"""),
      TupleExp(
        Node.seq(
          LiteralExp(Id("z"), Raw("-1")),
          LiteralExp(Id("b"), Raw("true")),
          LiteralExp(Id("usd"), Raw("1_000_000"))),
        Node.emptySeq)),

    EqualOptTest("Annotation",
      parseAnnotation( """@z'111"""),
      Annotation(Id("z"), Raw("111"))),

    EqualOptTest("ExpSimpleID1",
      parseExp("abc"),
      IdExp(Id("abc"))),

    EqualOptTest("ExpSimpleID2",
      parseExp("abc2"),
      IdExp(Id("abc2"))),

    EqualOptTest("ExpSimpleIDNotEnd1",
      parseExp("abc3:"),
      IdExp(Id("abc3"))),

    EqualOptTest("ExpSimpleIDNotEnd2",
      parseExp( """s,s"""),
      IdExp(Id("s"))),

    EqualOptTest("ExpOpID",
      parseExp("+"),
      IdExp(Id("+", Id.Op))),

    EqualOptTest("ExpComplexID",
      parseExp( """`a"sdsbc2`"""),
      IdExp(Id( """a"sdsbc2""", Id.Complex))),

    EqualOptTest("ExpLit",
      parseExp( """z'-1"""),
      LiteralExp(Id("z"), Raw("-1"))),

    EqualOptTest("ExpTuple",
      parseExp( """(z'-1, b'true ,usd'1_000_000)"""),
      TupleExp(
        Node.seq(
          LiteralExp(Id("z"), Raw("-1")),
          LiteralExp(Id("b"), Raw("true")),
          LiteralExp(Id("usd"), Raw("1_000_000"))),
        Node.emptySeq)
    ),
    EqualOptTest("ExpPrefixExp",
      parseExp("a(b,c)"),
      CallExp(IdExp(Id("a")), Node.seq(IdExp(Id("b")), IdExp(Id("c"))))),

    EqualOptTest("ExpInfixExp",
      parseExp("a(b,c) + z'5 * z'6"),
      BinaryExp(
        CallExp(IdExp(Id("a")), Node.seq(IdExp(Id("b")), IdExp(Id("c")))),
        Id("+", Id.Op),
        LiteralExp(Id("z"), Raw("5")),
        Node.seq(
          (Id("*", Id.Op), LiteralExp(Id("z"), Raw("6")))
        )
      )),

    EqualOptTest("ExpPrefixRecovery",
      parseExp( """a( 5, x ,4)""", reporter(3, 9)),
      IdExp(Id("a"))),

    EmptyIterableTest("IDError",
      parseID( """:s""", reporter(0))),

    EmptyIterableTest("PrimaryExpIDError",
      parsePrimaryExp( """:s""", reporter(0))),

    EmptyIterableTest("ExpTupleRecovery",
      parseExp( """( 5, x ,4)""", reporter(2, 8)))
  )

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
        tf.assertEquals(offset, _offset(i))
        i += 1
      }
    }
}
