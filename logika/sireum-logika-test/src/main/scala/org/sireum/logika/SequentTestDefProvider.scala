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
        """p ∨ q, r  ⊢  (p ∧ r) ∨ (q ∧ r)
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
        """p, q, r  ⊢  r ∧ (q ∧ p)
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
        """p ∧ (q ∧ r)  ⊢  r ∧ p
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
        """p  ⊢  p ∨ q
          |{
          |  1. p                        premise
          |  2. p ∨ q                    ∨i1 1
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("or-2a",
      ast(
        """p ∧ q  ⊢  p ∨ q
          |{
          |  1. p ∧ q                    premise
          |  2. p                        ∧e1 1
          |  3. p ∨ q                    ∨i1 2
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("or-2b",
      ast(
        """p ∧ q  ⊢  p ∨ q
          |{
          |  1. p ∧ q                    premise
          |  2. q                        ∧e2 1
          |  3. p ∨ q                    ∨i1 2
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("or-3",
      ast(
        """p ∨ q,  r  ⊢  (p ∧ r) ∨ (q ∧ r)
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
    ConditionTest("implies-1",
      ast(
        """(p ∧ q) → r,  p → q,  p  ⊢  r
          |{
          |  1. (p ∧ q) → r              premise
          |  2. p → q                    premise
          |  3. p                        premise
          |  4. q                        →e 2 3
          |  5. p ∧ q                    ∧i 3 4
          |  6. r                        →e 1 5
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("implies-2",
      ast(
        """(p ∨ q) → r,  q  ⊢  r
          |{
          |  1. (p ∨ q) → r              premise
          |  2. q                        premise
          |  3. p ∨ q                    ∨i1 2
          |  4. r                        →e 1 3
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("implies-3a",
      ast(
        """q  ⊢  p → q
          |{
          |  1. q                        premise
          |  2. {
          |       3. p                   assume
          |       4. q                   premise
          |     }
          |  5. p → q                   →i 2
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("implies-3b",
      ast(
        """q  ⊢  p → q
          |{
          |  1. {
          |       2. p                   assume
          |       3. q                   premise
          |     }
          |  4. p → q                   →i 1
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("implies-4",
      ast(
        """p → r,  q → r  ⊢  (p ∨ q) → r
          |{
          |  1. p → r                    premise
          |  2. q → r                    premise
          |  3. {
          |       4. p ∨ q               assume
          |       5. {
          |            6. p              assume
          |            7. r              →e 1 6
          |          }
          |       8. {
          |            9. q              assume
          |           10. r              →e 2 9
          |          }
          |      11. r                   ∨e 4 5 8
          |     }
          | 12. (p ∨ q) → r             →i 3
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("negation-1",
      ast(
        """p ∨ q,  ¬p  ⊢  q
          |{
          |  1. p ∨ q                    premise
          |  2. ¬p                       premise
          |  3. {
          |       4. p                   assume
          |       5. ⊥                   ¬e 4 2
          |       6. q                   ⊥e 5
          |     }
          |  7. {
          |       8. q                   assume
          |     }
          |  9. q                        ∨e 1 3 7
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("negation-2",
      ast(
        """¬p  ⊢  p → q
          |{
          |  1. ¬p                       premise
          |  2. {
          |       3. p                   assume
          |       4. ⊥                   ¬e 3 1
          |       5. q                   ⊥e 4
          |     }
          |  6. p → q                    →i 2
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("negation-3",
      ast(
        """p → ¬q  ⊢  ¬(p ∧ q)
          |{
          |  1. p → ¬q                   premise
          |  2. {
          |       3. p ∧ q               assume
          |       4. p                   ∧e1 3
          |       5. q                   ∧e2 3
          |       6. ¬q                  →e 1 4
          |       7. ⊥                   ¬e 5 6
          |     }
          |  6. ¬(p ∧ q)                 ¬i 2
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("negation-4",
      ast(
        """p, q → ¬p  ⊢  ¬q
          |{
          |  1. p                        premise
          |  2. q → ¬p                   premise
          |  3. {
          |       4. q                   assume
          |       5. ¬p                  →e 2 4
          |       6. ⊥                   ¬e 1 5
          |     }
          |  7. ¬q                       ¬i 3
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("negation-5",
      ast(
        """p  ⊢  ¬¬p
          |{
          |  1. p                        premise
          |  2. {
          |       3. ¬p                  assume
          |       4. ⊥                   ¬e 1 3
          |     }
          |  5. ¬¬p                      ¬i 2
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("negation-6",
      ast(
        """¬¬p  ⊢  p
          |{
          |  1. ¬¬p                      premise
          |  2. {
          |       3. ¬p                  assume
          |       4. ⊥                   ¬e 3 1
          |     }
          |  5. p                        Pbc 2
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("negation-7",
      ast(
        """¬(¬p ∨ ¬q)  ⊢  p ∧ q
          |{
          |  1. ¬(¬p ∨ ¬q)               premise
          |  2. {
          |       3. ¬p                  assume
          |       4. ¬p ∨ ¬q             ∨i1 3
          |       5. ⊥                   ¬e 4 1
          |     }
          |  5. p                        Pbc 2
          |  6. {
          |       7. ¬q                  assume
          |       8. ¬p ∨ ¬q             ∨i2 7
          |       9. ⊥                   ¬e 8 1
          |     }
          | 10. q                        Pbc 6
          | 11. p ∧ q                    ∧i 5 10
          |}
        """.stripMargin, LogicMode.Propositional))
    ,
    ConditionTest("negation-8",
      ast(
        """⊢  p ∨ ¬p
          |{
          |  1. {
          |       2. ¬(p ∨ ¬p)           assume
          |       3. {
          |            4. p              assume
          |            5. p ∨ ¬p         ∨i1 4
          |            6. ⊥              ¬e 5 2
          |          }
          |       7. ¬p                  ¬i 3
          |       8. p ∨ ¬p              ∨i2 3
          |       9. ⊥                   ¬e 8 2
          |     }
          | 10. p ∨ ¬p                   Pbc 1
          |}
        """.stripMargin, LogicMode.Propositional))
  )

  def ast(text: String, m: LogicMode): Boolean = {
    val sequentOpt = Builder[Sequent](text)
    sequentOpt.isDefined && m == sequentOpt.get.mode
  }
}