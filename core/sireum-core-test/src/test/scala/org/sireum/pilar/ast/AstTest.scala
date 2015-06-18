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

import org.junit.Test
import org.sireum.util._

import scala.util.Random

class AstTest {

  val emptyModel = Model(ivectorEmpty, ivectorEmpty)

  val model =
    Model(
      ivector(
        Annotation(Id("object"), Raw("1"))),
      ivector(
        GlobalVarDecl(Id("x"),
          ivector(Annotation(Id("type"), Raw("Int"))))))

  @Test
  def testEmptyModel(): Unit = {
    emptyModel match {
      case Model(elements) => assert(elements.isEmpty, "Expected model with empty elements")
    }
  }

  @Test
  def testRewriteAnnotationOffset(): Unit = {
    val n = Random.nextInt().abs

    val model2 = Rewriter.build({
      case a: Annotation =>
        a.line = n
        a.column = n
        a
    })(model)

    Visitor.build({
      case a: Annotation =>
        assert(a.line == n && a.column == n, s"Expected annotation offset ($n, $n)")
        false
    })(model2)

    assert(model eq model2, "Expected model not changed due to offset updates")
  }

  @Test
  def testPicklingString(): Unit = {
    import Pickling._
    assert(model == from[Model](to(model)))
  }

  //  @Test
  //  def testPicklingBytes(): Unit = {
  //    import Pickling._
  //    assert(model == from[Model](toBytes(model)))
  //  }
}

