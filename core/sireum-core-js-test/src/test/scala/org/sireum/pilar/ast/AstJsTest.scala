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

import org.sireum.util._
import utest._

object AstJsTest extends TestSuite {
  def tests = TestSuite {

    val emptyModel = Model(ivectorEmpty, ivectorEmpty)

    val model =
      Model(
        ivector(
          GlobalVarDecl(Id("x"),
            ivector(Annotation(Id("type"), Raw("Int"))))),
        ivector(
          Annotation(Id("object"), Raw("1")))
      )

    'EmptyModel {
      emptyModel match {
        case Model(elements, anns) =>
          assert(elements.isEmpty, anns.isEmpty)
      }
    }

    'RewriteAnnotationOffset {
      val model2 = Rewriter.build() {
        case Annotation(Id(_, _), raw) =>
          Annotation(Id("Z"), raw)
      }(model)

      Visitor.build({
        case a: Annotation =>
          assert(a.id.value == "Z")
          false
      })(model2)

      assert(model ne model2)
    }

    'PicklingEmptyModel {
      import Pickling._
      assert(emptyModel == unpickle[Model](pickle(emptyModel)))
    }

    'PicklingModel {
      import Pickling._
      assert(model == unpickle[Model](pickle(model)))
    }
  }
}
