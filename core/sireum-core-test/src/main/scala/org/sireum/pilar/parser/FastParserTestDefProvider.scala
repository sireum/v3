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

    EqualTest("AnnotationRecovery",
      parseAnnotations("@ 5 sdaekcn;sgej(recovery skips here) @type 'Int", reporter(2)),
      Seq(Annotation(Id("type"), Raw("Int"))))
    ,
    EqualTest("AnnotationRecoveryString",
      parseAnnotations("@ 5 recovery ignore \"@\" inside string @type 'Int", reporter(2)),
      Seq(Annotation(Id("type"), Raw("Int"))))
    ,
    EqualOptTest("SimpleLit",
      parseLIT("'abc"),
      Raw("abc"))
    ,
    EqualOptTest("StringLit",
      parseLIT("\"abc\\\"abc\""),
      Raw("abc\"abc"))
    ,
    EqualOptTest("EmptyLit",
      parseLIT("'"),
      Raw(""))
    ,
    EqualOptTest("SimpleID1",
      parseID("abc"),
      Id("abc"))
    ,
    EqualOptTest("SimpleID2",
      parseID("abc2"),
      Id("abc2"))
    ,
    EqualOptTest("SimpleIDNotEnd1",
      parseID("abc3:"),
      Id("abc3"))
    ,
    EqualOptTest("SimpleIDNotEnd2",
      parseID( """s!s"""),
      Id("s"))
    ,
    EqualOptTest("OpID",
      parseID("+"),
      Id("+"))
    ,
    EqualOptTest("ComplexID",
      parseID( """`a"sdsbc2`"""),
      Id("a\"sdsbc2"))
    ,
    EqualOptTest("PrimaryExpSimpleID1",
      parsePrimaryExp("abc"),
      IdExp(Id("abc")))
    ,
    EqualOptTest("PrimaryExpSimpleID2",
      parsePrimaryExp("abc2"),
      IdExp(Id("abc2")))
    ,
    EqualOptTest("PrimaryExpSimpleIDNotEnd1",
      parsePrimaryExp("abc3:"),
      IdExp(Id("abc3")))
    ,
    EqualOptTest("PrimaryExpSimpleIDNotEnd2",
      parsePrimaryExp( """s!s"""),
      IdExp(Id("s")))
    ,
    EqualOptTest("PrimaryExpOpID",
      parsePrimaryExp("+"),
      IdExp(Id("+")))
    ,
    EqualOptTest("PrimaryExpComplexID",
      parsePrimaryExp( """`a"sdsbc2`"""),
      IdExp(Id("a\"sdsbc2")))
    ,
    EqualOptTest("PrimaryExpLit",
      parsePrimaryExp( """z'-1"""),
      LiteralExp(Id("z"), Raw("-1")))
    ,
    EqualOptTest("PrimaryExpTuple",
      parsePrimaryExp( """(z'-1, b'true ,usd'1_000_000)"""),
      TupleExp(
        Node.seq(
          LiteralExp(Id("z"), Raw("-1")),
          LiteralExp(Id("b"), Raw("true")),
          LiteralExp(Id("usd"), Raw("1_000_000"))
        )
      )
    )
    ,
    EqualOptTest("Annotation",
      parseAnnotation( """@z'111"""),
      Annotation(Id("z"), Raw("111")))
    ,
    EqualOptTest("ExpSimpleID1",
      parseExp("abc"),
      IdExp(Id("abc")))
    ,
    EqualOptTest("ExpSimpleID2",
      parseExp("abc2"),
      IdExp(Id("abc2")))
    ,
    EqualOptTest("ExpSimpleIDNotEnd1",
      parseExp("abc3:"),
      IdExp(Id("abc3")))
    ,
    EqualOptTest("ExpSimpleIDNotEnd2",
      parseExp( """s,s"""),
      IdExp(Id("s")))
    ,
    EqualOptTest("ExpOpID",
      parseExp("+"),
      IdExp(Id("+")))
    ,
    EqualOptTest("ExpComplexID",
      parseExp( """`a"sdsbc2`"""),
      IdExp(Id( """a"sdsbc2""")))
    ,
    EqualOptTest("ExpLit",
      parseExp("z'-1"),
      LiteralExp(Id("z"), Raw("-1")))
    ,
    EqualOptTest("ExpTuple",
      parseExp("(z'-1, b'true ,usd'1_000_000)"),
      TupleExp(
        Node.seq(
          LiteralExp(
            Id("z"),
            Raw("-1")
          ),
          LiteralExp(
            Id("b"),
            Raw("true")
          ),
          LiteralExp(
            Id("usd"),
            Raw("1_000_000")
          )
        )
      )
    )
    ,
    EqualOptTest("ExpPrefixExp",
      parseExp("a(b,c)"),
      CallExp(IdExp(Id("a")), Node.seq(IdExp(Id("b")), IdExp(Id("c")))))
    ,
    EqualOptTest("ExpInfixExp",
      parseExp("a(b,c) + z'5 * z'6"),
      GenBinaryExp(
        CallExp(IdExp(Id("a")), Node.seq(IdExp(Id("b")), IdExp(Id("c")))),
        Id("+"),
        LiteralExp(Id("z"), Raw("5")),
        Node.seq(
          (Id("*"), LiteralExp(Id("z"), Raw("6")))
        )
      ))
    ,
    EqualOptTest("ExpPrefixRecovery",
      parseExp("a( 5, x ,4)", reporter(3, 9)),
      IdExp(Id("a")))
    ,
    EmptyIterableTest("IDError",
      parseID(":s", reporter(0)))
    ,
    EmptyIterableTest("PrimaryExpIDError",
      parsePrimaryExp(":s", reporter(0)))
    ,
    EmptyIterableTest("ExpTupleRecovery",
      parseExp("( 5, x ,4)", reporter(2, 8)))
    ,
    EqualOptTest("AssignAction1",
      parseAction("x:=y+ z;"),
      AssignAction(
        IdExp(Id("x")),
        GenBinaryExp(
          IdExp(Id("y")),
          Id("+"),
          IdExp(Id("z")),
          Node.emptySeq),
        Node.emptySeq))
    ,
    EqualOptTest("AssignAction2",
      parseAction("x := d'1.0 + z * z'5;"),
      AssignAction(
        IdExp(Id("x")),
        GenBinaryExp(
          LiteralExp(Id("d"), Raw("1.0")),
          Id("+"),
          IdExp(Id("z")),
          Node.seq(
            (Id("*"), LiteralExp(Id("z"), Raw("5"))))),
        Node.emptySeq))
    ,
    EqualOptTest("AssignAction3",
      parseAction("x:=z'1@foo;"),
      AssignAction(
        IdExp(Id("x")),
        LiteralExp(Id("z"), Raw("1")),
        Node.seq(Annotation(Id("foo"), Raw("")))))
    ,
    EmptyIterableTest("AssignActionRecovery",
      parseAction("x := 5 + recovery skips this;", reporter(5)))
    ,
    EqualOptTest("AssertAction1",
      parseAction("assert b'true;"),
      AssertAction(
        LiteralExp(Id("b"), Raw("true")),
        Node.emptySeq))
    ,
    EqualOptTest("AssertAction2",
      parseAction("assert b'false;"),
      AssertAction(
        LiteralExp(Id("b"), Raw("false")),
        Node.emptySeq))
    ,
    EqualOptTest("AssertAction3",
      parseAction("assert x > z'0 & x < y;"),
      AssertAction(
        GenBinaryExp(
          IdExp(Id("x")),
          Id(">"),
          LiteralExp(Id("z"), Raw("0")),
          Node.seq(
            (Id("&"), IdExp(Id("x"))),
            (Id("<"), IdExp(Id("y"))))),
        Node.emptySeq))
    ,
    EmptyIterableTest("AssertActionRecovery",
      parseAction("assert 7 + recovery skips this;", reporter(7)))
    ,
    EqualOptTest("AssumeAction1",
      parseAction("assume b'true;"),
      AssumeAction(
        LiteralExp(Id("b"), Raw("true")),
        Node.emptySeq))
    ,
    EqualOptTest("AssumeAction2",
      parseAction("assume b'false;"),
      AssumeAction(
        LiteralExp(Id("b"), Raw("false")),
        Node.emptySeq))
    ,
    EqualOptTest("AssumeAction3",
      parseAction("assume x > z'0 & x < y;"),
      AssumeAction(
        GenBinaryExp(
          IdExp(Id("x")),
          Id(">"),
          LiteralExp(Id("z"), Raw("0")),
          Node.seq(
            (Id("&"), IdExp(Id("x"))),
            (Id("<"), IdExp(Id("y"))))),
        Node.emptySeq))
    ,
    EmptyIterableTest("AssumeActionRecovery",
      parseAction("assume 7 + recovery skips this;", reporter(7)))
    ,
    EqualOptTest("ExtAction1",
      parseAction("ext x(y,z);"),
      ExtAction(
        Id("x"),
        Node.seq(
          IdExp(Id("y")),
          IdExp(Id("z"))),
        Node.emptySeq))
    ,
    EmptyIterableTest("ExtActionRecovery",
      parseAction("ext x(6,recovery skip this);", reporter(6)))
    ,
    EqualOptTest("GotoJump1",
      parseJump("goto L0;"),
      GotoJump(Id("L0")))
    ,
    EmptyIterableTest("GotoJumpRecovery",
      parseJump("goto 5 recovery skip this;", reporter(5)))
    ,
    EqualOptTest("IfJump1",
      parseJump("if x then L0 else L1;"),
      IfJump(
        IdExp(Id("x")),
        Id("L0"),
        Id("L1")
      ))
    ,
    EmptyIterableTest("IfJumpRecovery1",
      parseJump("if 3 then L0 else L1;", reporter(3)))
    ,
    EmptyIterableTest("IfJumpRecovery2",
      parseJump("if x then 9 else L1;", reporter(10)))
    ,
    EmptyIterableTest("IfJumpRecovery3",
      parseJump("if x then L0 else 5;", reporter(18)))
    ,
    EqualOptTest("SwitchJump1",
      parseJump(
        """switch x
          |  case z'0: L0
          |  case z'1: L1
          |  default: L2;
        """.stripMargin),
      SwitchJump(
        IdExp(Id("x")),
        Node.seq(
          SwitchCase(
            Some(LiteralExp(Id("z"), Raw("0"))),
            Id("L0")
          ),
          SwitchCase(
            Some(LiteralExp(Id("z"), Raw("1"))),
            Id("L1")
          ),
          SwitchCase(
            None,
            Id("L2")
          )
        )))
    ,
    EqualOptTest("SwitchJump2",
      parseJump(
        """switch x
          |  case z'0: L0
          |  case z'1: L1;
        """.stripMargin),
      SwitchJump(
        IdExp(Id("x")),
        Node.seq(
          SwitchCase(
            Some(LiteralExp(Id("z"), Raw("0"))),
            Id("L0")
          ),
          SwitchCase(
            Some(LiteralExp(Id("z"), Raw("1"))),
            Id("L1")
          )
        )))
    ,
    EqualOptTest("SwitchJump3",
      parseJump(
        """switch x
          |  default: L2;
        """.stripMargin),
      SwitchJump(
        IdExp(Id("x")),
        Node.seq(
          SwitchCase(
            None,
            Id("L2")
          )
        )))
    ,
    EmptyIterableTest("SwitchJumpRecovery1",
      parseJump("switch 5 recovery skips this;", reporter(7)))
    ,
    EmptyIterableTest("SwitchJumpRecovery2",
      parseJump(
        """switch x
          | case 15 recovery skips this
          | and this;
        """.stripMargin, reporter(15)))
    ,
    EmptyIterableTest("SwitchJumpRecovery3",
      parseJump(
        """switch x
          | default 18 recovery skips this
          | and this;
        """.stripMargin, reporter(18)))
    ,
    EqualOptTest("ExtJump1",
      parseJump("jext x(y,z);"),
      ExtJump(
        Id("x"),
        Node.seq(
          IdExp(Id("y")),
          IdExp(Id("z"))),
        Node.emptySeq))
    ,
    EmptyIterableTest("ExtJumpRecovery",
      parseJump("jext x(7,recovery skip this);", reporter(7)))
  )

  import FastParser._

  private def parseAction(s: String,
                          reporter: Reporter = ConsoleReporter) = {
    val parser = new FastParser(s, reporter, createLocInfo = false)
    parser.parseWithEOF(parser.parseAction(noRecover))
  }

  private def parseJump(s: String,
                        reporter: Reporter = ConsoleReporter) = {
    val parser = new FastParser(s, reporter, createLocInfo = false)
    parser.parseWithEOF(parser.parseJump(noRecover))
  }

  private def parseExp(s: String,
                       reporter: Reporter = ConsoleReporter) =
    new FastParser(s, reporter, createLocInfo = false).parseExp(noRecover)

  private def parsePrimaryExp(s: String,
                              reporter: Reporter = ConsoleReporter) =
    new FastParser(s, reporter, createLocInfo = false).parsePrimaryExp(noRecover)

  private def parseLIT(s: String,
                       reporter: Reporter = ConsoleReporter) =
    new FastParser(s, reporter, createLocInfo = false).parseLIT(noRecover)

  private def parseID(s: String,
                      reporter: Reporter = ConsoleReporter) =
    new FastParser(s, reporter, createLocInfo = false).parseID(noRecover)

  private def parseAnnotation(s: String,
                              reporter: Reporter = ConsoleReporter) =
    new FastParser(s, reporter, createLocInfo = false).parseAnnotation(noRecover)

  private def parseAnnotations(s: String,
                               reporter: Reporter = ConsoleReporter) =
    new FastParser(s, reporter, createLocInfo = false).parseAnnotations(noRecover)

  private def reporter(_offset: Int*) =
    new FastParser.Reporter {
      var i = 0

      override def error(line: Int, column: Int,
                         offset: Int, message: String): Unit = {
        tf.assertEquals(_offset(i), offset)
        i += 1
      }
    }
}
