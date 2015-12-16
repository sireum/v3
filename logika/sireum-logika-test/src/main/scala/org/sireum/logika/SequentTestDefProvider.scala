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

package org.sireum.logika

import org.sireum.logika.ast.{Builder, LogicMode, Program, Sequent}
import org.sireum.test._
import org.sireum.util._

final class SequentTestDefProvider(tf: TestFramework)
  extends TestDefProvider {

  override def testDefs: ISeq[TestDef] = ivector(
    ConditionTest("intro-nat-ded-1",
      ast(
        """p ∨ q, r |- (p ∧ r) ∨ (q ∧ r)
          |{
          |  1. p ∨ q                    premise
          |  2. r                        premise
          |  3. {
          |       4. p                   assume
          |       5. p ∧ r               ∧i 4 2
          |       6. (p ∧ r) ∨ (q ∧ r)   ∨i1 5
          |     }
          |  7. {
          |       8. q                   assume
          |       9. q ∧ r               ∧i 8 2
          |      10. (p ∧ r) ∨ (q ∧ r)   ∨i1 9
          |     }
          | 11. (p ∧ r) ∨ (q ∧ r)        ∨e 1 3 7
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("and-1",
      ast(
        """p, q, r |- r ∧ (q ∧ p)
          |{
          |  1. p                      premise
          |  2. q                      premise
          |  3. r                      premise
          |  4. q ∧ p                  ∧i 2 1
          |  5. r ∧ (q ∧ p)            ∧i 3 4
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("and-2",
      ast(
        """p ∧ (q ∧ r) |- r ∧ p
          |{
          |  1. p ∧ (q ∧ r)              premise
          |  2. p                        ∧e1 1
          |  3. q ∧ r                    ∧e2 1
          |  4. r                        ∧e2 3
          |  5. r ∧ p                    ∧i 4 2
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("or-1",
      ast(
        """p |- p ∨ q
          |{
          |  1. p                        premise
          |  2. p ∨ q                    ∨i1 1
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("or-2a",
      ast(
        """p ∧ q |- p ∨ q
          |{
          |  1. p ∧ q                    premise
          |  2. p                        ∧e1 1
          |  3. p ∨ q                    ∨i1 2
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("or-2b",
      ast(
        """p ∧ q |- p ∨ q
          |{
          |  1. p ∧ q                    premise
          |  2. q                        ∧e2 1
          |  3. p ∨ q                    ∨i1 2
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("or-2b",
      ast(
        """p ∧ q |- p ∨ q
          |{
          |  1. p ∧ q                    premise
          |  2. q                        ∧e2 1
          |  3. p ∨ q                    ∨i1 2
          |}
        """.stripMargin, LogicMode.Propositional))
  )

  def ast(text: String, m: LogicMode): Boolean = {
    val sequentOpt = Builder[Sequent](text)
    sequentOpt.isDefined && m == sequentOpt.get.mode
  }
}