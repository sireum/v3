/*
 Copyright (c) 2016, Robby, Kansas State University
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

package org.sireum.pilar.test.ast

import org.sireum.pilar.ast._
import org.sireum.pilar.parser._
import org.sireum.pilar.test.parser._
import org.sireum.test._
import org.sireum.util._

import PrettyPrinterTestDefProvider._

object PrettyPrinterTestDefProvider {
  final val model1 =
    """
      |def switchTest(x) {
      |var y;
      |
      |#L1 y := x + z'1 @bar;
      |    switch y
      |    case z'0: L2
      |    case z'1: L3
      |    default: L4 @foo;
      |
      |#L2 return z'10;
      |
      |#L3 return z'9;
      |
      |#L4 return z'0;
      |}
    """.stripMargin
}

final class PrettyPrinterTestDefProvider(tf: TestFramework)
  extends TestDefProvider {

  override def testDefs: ISeq[TestDef] = ivector(

    EqualTest("FPModel1",
      PrettyPrinter(FastParser(FastParserTestDefProvider.model1).get),
      """
        |global var z;
        |
        |def foo(x) {
        |
        |  #L0
        |    return x;
        |}
      """.stripMargin.trim
    )
    ,
    EqualTest("FPModel2",
      PrettyPrinter(FastParser(FastParserTestDefProvider.model2).get),
      """
        |def abs(x) {
        |
        |  #L0
        |    if x < z'0 then L1 else L2;
        |
        |  #L1
        |    return -(x);
        |
        |  #L2
        |    return x;
        |}
      """.stripMargin.trim)
    ,
    EqualTest("FPModel3",
      PrettyPrinter(FastParser(FastParserTestDefProvider.model3).get),
      """
        |def min(x, y) {
        |
        |  #L0
        |    if x <= y then L1 else L2;
        |
        |  #L1
        |    return x;
        |
        |  #L2
        |    return y;
        |}
      """.stripMargin.trim)
    ,
    EqualTest("Model1",
      PrettyPrinter(FastParser(model1).get),
      """
        |def switchTest(x) {
        |  var
        |    y;
        |
        |  #L1
        |    y := x + z'1
        |        @bar;
        |    switch y
        |      case z'0: L2
        |      case z'1: L3
        |      default: L4
        |        @foo;
        |
        |  #L2
        |    return z'10;
        |
        |  #L3
        |    return z'9;
        |
        |  #L4
        |    return z'0;
        |}
      """.stripMargin.trim)
  )

  def printAndParse(model: String) =
    PrettyPrinter(FastParser(model).get)
}