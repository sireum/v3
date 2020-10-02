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

package org.sireum.test

import org.sireum.util._

trait TestFramework {
  def assertEquals(expected: Any, result: Any): Unit

  def assertEqualsRaw(expected: Any, result: Any): Unit

  def assertEmpty(it: Iterable[_]): Unit

  def assertTrue(b: Boolean) : Unit
}

trait TestDef {
  private[test] var _single: Boolean = false

  def name: String

  def test(tf: TestFramework): Unit

  def single: this.type = {
    _single = true
    this
  }

  def isSingle = _single
}

object EqualTest {
  def apply(name: String, result: => Any, expected: => Any): EqualTest =
    new EqualTest(name, () => result, () => expected)
}

final class EqualTest(val name: String,
                      result: () => Any,
                      expected: () => Any) extends TestDef {
  override def test(tf: TestFramework): Unit = {
    tf.assertEquals(expected(), result())
  }
}

object EqualOptTest {
  def apply(name: String, result: => Option[Any], expected: => Any): EqualOptTest =
    new EqualOptTest(name, () => result, () => expected)
}

final class EqualOptTest(val name: String,
                         result: () => Option[_],
                         expected: () => Any) extends TestDef {
  override def test(tf: TestFramework): Unit = {
    tf.assertEquals(expected(), result().get)
  }
}

object EmptyIterableTest {
  def apply(name: String, result: => Iterable[Any]): EmptyIterableTest =
    new EmptyIterableTest(name, () => result)
}

final class EmptyIterableTest(val name: String, it: () => Iterable[Any]) extends TestDef {
  override def test(tf: TestFramework): Unit = {
    tf.assertEmpty(it())
  }
}

object ConditionTest {
  def apply(name: String, condition: => Boolean): ConditionTest =
    new ConditionTest(name, () => condition)
}

final class ConditionTest(val name: String, condition: () => Boolean) extends TestDef {
  override def test(tf: TestFramework): Unit = {
    tf.assertTrue(condition())
  }
}

trait TestDefProvider {
  def testDefs: ISeq[TestDef]

  def enabledTestDefs: ISeq[TestDef] = {
    testDefs.find(_._single) match {
      case Some(td) => ivector(td)
      case _ => testDefs
    }
  }
}
