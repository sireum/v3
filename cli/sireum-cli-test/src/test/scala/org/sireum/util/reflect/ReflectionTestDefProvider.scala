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

package org.sireum.util.reflect

import org.sireum.test._
import org.sireum.util._
import scala.reflect.runtime.universe._

import scala.annotation.StaticAnnotation
import scala.annotation.meta.getter

final class ReflectionTestDefProvider(tf: TestFramework)
  extends TestDefProvider {

  @getter
  case class FooAnn(x: Int, y: Boolean, o: Option[String]) extends StaticAnnotation

  case class Foo(@FooAnn(x = 10, y = true, o = None)
                 var f1: Int = 10)

  import Reflection.CaseClass.Param
  import Reflection.Annotation
  import Reflection.AnnotationArg

  override def testDefs: ISeq[TestDef] = ivector(

    ConditionTest("Test1", {
      tf.assertEqualsRaw(
        Reflection.CaseClass.caseClassObject(Foo(), processAnnotations = true,
          MIdMap()),
        Reflection.CaseClass(
          typeOf[ReflectionTestDefProvider.this.Foo],
          Vector(),
          Vector(
            Param("f1", typeOf[Int],
              Vector(
                Annotation(
                  typeOf[ReflectionTestDefProvider.this.FooAnn],
                  Vector(
                    AnnotationArg("x", 10),
                    AnnotationArg("y", true),
                    AnnotationArg("o", None)
                  )
                )
              ),
              Some(10)
            )
          ),
          Map()
        )
      )
      true
    })
  )
}
