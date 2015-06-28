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

package org.sireum.pilar.ast

import org.sireum.pilar.parser.{FastParserTestDefProvider, FastParser}
import org.sireum.test._
import org.sireum.util._

final class AstTestDefProvider(tf: TestFramework)
  extends TestDefProvider {

  val emptyModel = Model(Node.emptySeq)

  val model =
    Model(
      Node.seq(
        GlobalVarDecl(Id("x"),
          ivector(Annotation(Id("type"), Raw("Int"))))),
      Node.seq(
        Annotation(Id("object"), Raw("1")))
    )

  lazy val modelFastParsed1 =
    FastParser(
      FastParserTestDefProvider.model1, createLocInfo = true).get

  lazy val modelFastParsed2 =
    FastParser(
      FastParserTestDefProvider.model2, createLocInfo = true).get

  lazy val modelFastParsed3 =
    FastParser(
      FastParserTestDefProvider.model3, createLocInfo = true).get

  override def testDefs: ISeq[TestDef] = ivector(

    ConditionTest("EmptyModel",
      emptyModel.elements.isEmpty && emptyModel.annotations.isEmpty)
    ,
    ConditionTest("RewriteAnnotationId", {
      val model2 = Rewriter.build() {
        case Annotation(Id(_), raw) =>
          Annotation(Id("Z"), raw)
      }(model)

      Visitor.build({
        case a: Annotation =>
          tf.assertEquals(a.id.value, "Z")
          false
      })(model2)

      model ne model2
    })
    ,
    EqualTest("PicklingEmptyModel", {
      import Pickling._
      unpickle[Model](pickle(emptyModel))
    }, emptyModel)
    ,
    EqualTest("PicklingModel", {
      import Pickling._
      unpickle[Model](pickle(model))
    }, model)
    ,
    EqualTest("PicklingModelFastParsed1", {
      import Pickling._
      unpickle[Model](pickle(modelFastParsed1))
    }, modelFastParsed1)
    ,
    EqualTest("PicklingModelFastParsed1Loc", {
      import Pickling._
      collectLocInfos(unpickle[Model](pickle(modelFastParsed1)))
    }, collectLocInfos(modelFastParsed1))
    ,
    EqualTest("PicklingModelFastParsed2", {
      import Pickling._
      unpickle[Model](pickle(modelFastParsed2))
    }, modelFastParsed2)
    ,
    EqualTest("PicklingModelFastParsed2Loc", {
      import Pickling._
      collectLocInfos(unpickle[Model](pickle(modelFastParsed2)))
    }, collectLocInfos(modelFastParsed2))
    ,
    EqualTest("PicklingModelFastParsed3", {
      import Pickling._
      unpickle[Model](pickle(modelFastParsed3))
    }, modelFastParsed3)
    ,
    EqualTest("PicklingModelFastParsed3Loc", {
      import Pickling._
      collectLocInfos(unpickle[Model](pickle(modelFastParsed3)))
    }, collectLocInfos(modelFastParsed3))
  )

  private def collectLocInfos(m: Model): ISeq[Option[LocationInfo]] = {
    var r = ivectorEmpty[Option[LocationInfo]]
    Visitor.build({
      case n: Node =>
        r = r :+ m.nodeLocMap.get(n)
        true
    })(m)
    r
  }
}
