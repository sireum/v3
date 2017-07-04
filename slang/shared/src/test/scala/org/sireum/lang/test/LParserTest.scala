/*
 Copyright (c) 2017, Robby, Kansas State University
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

package org.sireum.lang.test

import org.sireum.lang.ast.TopUnit
import org.sireum.{None => SNone}
import org.sireum.lang.parser.{LParser, SlangParser}
import org.sireum.test.SireumSpec

import scala.meta._

class LParserTest extends SireumSpec {
  {
    implicit val _spec: SireumSpec = this

    "Truth Table" - {

      parseTruthTable("and",
        """        *
          |------------
          |p q | p ∧ q
          |------------
          |T T |   T
          |T F |   F
          |F T |   F
          |F F |   F
          |------------
          |
          |Contingent
          |- T: [T T]
          |- F: [T F] [F T] [F F]
        """.stripMargin)

      parseTruthTable("or",
        """        *
          |-----------
          |p q | p ∨ q
          |-----------
          |T T |   T
          |T F |   T
          |F T |   T
          |F F |   F
          |-----------
          |
          |Contingent
          |- T: [T T] [T F] [F T]
          |- F: [F F]
        """.stripMargin)

      parseTruthTable("implication",
        """        *
          |-----------
          |p q | p → q
          |-----------
          |T T |   T
          |T F |   F
          |F T |   T
          |F F |   T
          |-----------
          |
          |Contingent
          |- T: [T T] [F T] [F F]
          |- F: [T F]
        """.stripMargin)

      parseTruthTable("negation",
        """    *
          |------
          |p | ¬p
          |------
          |T | FT
          |F | TF
          |------
          |
          |Contingent
          |- T: [F]
          |- F: [T]
        """.stripMargin)

      parseTruthTable("example-1",
        """      *
          |--------------
          |p q | ¬(p ∧ q)
          |--------------
          |T T | F   T
          |T F | T   F
          |F T | T   F
          |F F | T   F
          |--------------
          |
          |Contingent
          |- T: [T F] [F T] [F F]
          |- F: [T T]
        """.stripMargin)

      parseTruthTable("example-2",
        """    *
          |-------------
          |p | ¬(p ∧ ¬p)
          |-------------
          |T | T   F F
          |F | T   F T
          |-------------
          |
          |Tautology
        """.stripMargin)

      parseTruthTable("example-3",
        """    *
          |-------------
          |p | ¬(p ∨ ¬p)
          |-------------
          |T | F   T F
          |F | F   T T
          |-------------
          |
          |Contradictory
        """.stripMargin)

      parseTruthTable("example-4",
        """                 *
          |--------------------
          |p q r | ¬(p ∧ q) ∨ r
          |--------------------
          |T T T | F   T    T
          |T T F | F   T    F
          |T F T | T   F    T
          |T F F | T   F    T
          |F T T | T   F    T
          |F T F | T   F    T
          |F F T | T   F    T
          |F F F | T   F    T
          |--------------------
          |
          |Contingent
          |- T: [TTT] [TFT] [TFF] [FTT] [FTF] [FFT] [FFF]
          |- F: [TTF]
        """.stripMargin)

      parseTruthTable("example-5",
        """         *
          |------------
          |p q | ¬p ∨ q
          |------------
          |T T | F  T
          |T F | F  F
          |F T | T  T
          |F F | T  T
          |------------
          |
          |Contingent
          |- T: [T T] [F T] [F F]
          |- F: [T F]
        """.stripMargin)

      parseTruthTable("intro-to-prop-logic-a",
        """        *    *    *
          |--------------------
          |p q | p → q, ¬q ⊢ ¬p
          |--------------------
          |T T |   T    F    F
          |T F |   F    T    F
          |F T |   T    F    T
          |F F |   T    T    T
          |--------------------
          |
          |Valid [FF]
        """.stripMargin)

      parseTruthTable("intro-to-prop-logic-b",
        """// Proof of p → q, ¬q ⊢ ¬p
          |
          |                   *
          |-----------------------
          |p q | (p → q) ∧ ¬q → ¬p
          |-----------------------
          |T T |    T    F F  T F
          |T F |    F    F T  T F
          |F T |    T    F F  T T
          |F F |    T    T T  T T
          |-----------------------
          |
          |Tautology
        """.stripMargin)

      parseTruthTable("intro-to-prop-logic-c",
        """// Proof of p → q, ¬q ⊢ ¬p
          |
          |              *
          |-----------------------
          |p q | (p → q) → ¬q → ¬p
          |-----------------------
          |T T |    T    T F  T F
          |T F |    F    T T  F F
          |F T |    T    T F  T T
          |F F |    T    T T  T T
          |-----------------------
          |
          |Tautology
        """.stripMargin)

      parseTruthTable("sequent-1-a",
        """        *    *    *
          |--------------------
          |p q | p → q, ¬q ⊢ ¬q
          |--------------------
          |T T |   T    F    F
          |T F |   F    T    T
          |F T |   T    F    F
          |F F |   T    T    T
          |--------------------
          |
          |Valid [FF]
        """.stripMargin)

      parseTruthTable("sequent-1-b",
        """                   *
          |-----------------------
          |p q | (p → q) ∧ ¬q → ¬q
          |-----------------------
          |T T |    T    F F  T F
          |T F |    F    F T  T T
          |F T |    T    F F  T F
          |F F |    T    T T  T T
          |-----------------------
          |
          |Tautology
        """.stripMargin)

      parseTruthTable("sequent-1-c",
        """              *
          |-----------------------
          |p q | (p → q) → ¬q → ¬q
          |-----------------------
          |T T |    T    T F  T F
          |T F |    F    T T  T T
          |F T |    T    T F  T F
          |F F |    T    T T  T T
          |-----------------------
          |
          |Tautology
        """.stripMargin)

      parseTruthTable("sequent-2-a",
        """        *     *
          |----------------
          |p q | p → q ⊢ ¬q
          |----------------
          |T T |   T     F
          |T F |   F     T
          |F T |   T     F
          |F F |   T     T
          |----------------
          |
          |Invalid [TT] [FT]
        """.stripMargin)

      parseTruthTable("sequent-2-b",
        """              *
          |------------------
          |p q | (p → q) → ¬q
          |------------------
          |T T |    T    F F
          |T F |    F    T T
          |F T |    T    F F
          |F F |    T    T T
          |------------------
          |
          |Contingent
          |T: [TF] [FF]
          |F: [TT] [FT]
        """.stripMargin)
    }

    "Propositional" - {
      parsePropositional("intro-nat-ded",
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
          |      10. (p ∧ r) ∨ (q ∧ r)   ∨i2 9
          |     }
          | 11. (p ∧ r) ∨ (q ∧ r)        ∨e 1 3 7
          |}
        """.stripMargin)

      parsePropositional("and-1",
        """p, q, r  ⊢  r ∧ (q ∧ p)
          |{
          |  1. p                        premise
          |  2. q                        premise
          |  3. r                        premise
          |  4. q ∧ p                    ∧i 2 1
          |  5. r ∧ (q ∧ p)              ∧i 3 4
          |}
        """.stripMargin)

      parsePropositional("and-2",
        """p ∧ (q ∧ r)  ⊢  r ∧ p
          |{
          |  1. p ∧ (q ∧ r)              premise
          |  2. p                        ∧e1 1
          |  3. q ∧ r                    ∧e2 1
          |  4. r                        ∧e2 3
          |  5. r ∧ p                    ∧i 4 2
          |}
        """.stripMargin)

      parsePropositional("or-1",
        """p  ⊢  p ∨ q
          |{
          |  1. p                        premise
          |  2. p ∨ q                    ∨i1 1
          |}
        """.stripMargin)

      parsePropositional("or-2a",
        """p ∧ q  ⊢  p ∨ q
          |{
          |  1. p ∧ q                    premise
          |  2. p                        ∧e1 1
          |  3. p ∨ q                    ∨i1 2
          |}
        """.stripMargin)

      parsePropositional("or-2b",
        """p ∧ q  ⊢  p ∨ q
          |{
          |  1. p ∧ q                    premise
          |  2. q                        ∧e2 1
          |  3. p ∨ q                    ∨i2 2
          |}
        """.stripMargin)

      parsePropositional("or-3",
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
          |      10. (p ∧ r) ∨ (q ∧ r)   ∨i2 9
          |     }
          | 11. (p ∧ r) ∨ (q ∧ r)        ∨e 1 3 7
          |}
        """.stripMargin)

      parsePropositional("implies-1",
        """(p ∧ q) → r,  p → q,  p  ⊢  r
          |{
          |  1. (p ∧ q) → r              premise
          |  2. p → q                    premise
          |  3. p                        premise
          |  4. q                        →e 2 3
          |  5. p ∧ q                    ∧i 3 4
          |  6. r                        →e 1 5
          |}
        """.stripMargin)

      parsePropositional("implies-2",
        """(p ∨ q) → r,  q  ⊢  r
          |{
          |  1. (p ∨ q) → r              premise
          |  2. q                        premise
          |  3. p ∨ q                    ∨i2 2
          |  4. r                        →e 1 3
          |}
        """.stripMargin)

      parsePropositional("implies-3a",
        """q  ⊢  p → q
          |{
          |  1. q                        premise
          |  2. {
          |       3. p                   assume
          |       4. q                   premise
          |     }
          |  5. p → q                    →i 2
          |}
        """.stripMargin)

      parsePropositional("implies-3b",
        """q  ⊢  p → q
          |{
          |  1. {
          |       2. p                   assume
          |       3. q                   premise
          |     }
          |  4. p → q                    →i 1
          |}
        """.stripMargin)

      parsePropositional("implies-4",
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
          | 12. (p ∨ q) → r              →i 3
          |}
        """.stripMargin)

      parsePropositional("negation-1",
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
        """.stripMargin)

      parsePropositional("negation-2",
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
        """.stripMargin)

      parsePropositional("negation-3",
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
          |  8. ¬(p ∧ q)                 ¬i 2
          |}
        """.stripMargin)

      parsePropositional("negation-4",
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
        """.stripMargin)

      parsePropositional("negation-5",
        """p  ⊢  ¬(¬p)
          |{
          |  1. p                        premise
          |  2. {
          |       3. ¬p                  assume
          |       4. ⊥                   ¬e 1 3
          |     }
          |  5. ¬(¬p)                    ¬i 2
          |}
        """.stripMargin)

      parsePropositional("negation-6",
        """¬(¬p)  ⊢  p
          |{
          |  1. ¬(¬p)                    premise
          |  2. {
          |       3. ¬p                  assume
          |       4. ⊥                   ¬e 3 1
          |     }
          |  5. p                        pbc 2
          |}
        """.stripMargin)

      parsePropositional("negation-7",
        """¬(¬p ∨ ¬q)  ⊢  p ∧ q
          |{
          |  1. ¬(¬p ∨ ¬q)               premise
          |  2. {
          |       3. ¬p                  assume
          |       4. ¬p ∨ ¬q             ∨i1 3
          |       5. ⊥                   ¬e 4 1
          |     }
          |  6. p                        pbc 2
          |  7. {
          |       8. ¬q                  assume
          |       9. ¬p ∨ ¬q             ∨i2 8
          |      10. ⊥                   ¬e 9 1
          |     }
          | 11. q                        pbc 7
          | 12. p ∧ q                    ∧i 6 11
          |}
        """.stripMargin)

      parsePropositional("negation-8",
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
          |       8. p ∨ ¬p              ∨i2 7
          |       9. ⊥                   ¬e 8 2
          |     }
          | 10. p ∨ ¬p                   pbc 1
          |}
        """.stripMargin)
    }

    "Predicate" - {

      parsePredicate("universal-1",
        """∀x human(x) → mortal(x),  human(Socrates)  ⊢
          |  mortal(Socrates)
          |{
          |  1. ∀x human(x) → mortal(x)               premise
          |  2. human(Socrates)                       premise
          |  3. human(Socrates) → mortal(Socrates)    ∀e 1 Socrates
          |  4. mortal(Socrates)                      →e 3 2
          |}
        """.stripMargin)

      parsePredicate("universal-2",
        """∀x gt(inc(x), x),  ∀x gt(x, dec(x))  ⊢
          |  ∀x gt(inc(x), x) ∧ gt(x, dec(x))
          |{
          |  1. ∀x gt(inc(x), x)                      premise
          |  2. ∀x gt(x, dec(x))                      premise
          |  3. {
          |       4. a
          |       5. gt(inc(a), a)                    ∀e 1 a
          |       6. gt(a, dec(a))                    ∀e 2 a
          |       7. gt(inc(a), a) ∧ gt(a, dec(a))    ∧i 5 6
          |     }
          |  8. ∀x gt(inc(x), x) ∧ gt(x, dec(x))      ∀i 3
          |}
        """.stripMargin)

      parsePredicate("universal-3",
        """∀x human(x) → mortal(x),  ∀y mortal(y) → soul(y)  ⊢
          |  ∀x human(x) → soul(x)
          |{
          |  1. ∀x human(x) → mortal(x)               premise
          |  2. ∀y mortal(y) → soul(y)                premise
          |  3. {
          |       4. a
          |       5. {
          |            6. human(a)                    assume
          |            7. human(a) → mortal(a)        ∀e 1 a
          |            8. mortal(a)                   →e 7 6
          |            9. mortal(a) → soul(a)         ∀e 2 a
          |           10. soul(a)                     →e 9 8
          |          }
          |      11. human(a) → soul(a)               →i 5
          |     }
          | 12. ∀x human(x) → soul(x)                 ∀i 3
          |}
        """.stripMargin)

      parsePredicate("universal-4",
        """∀x healthy(x) → happy(x)  ⊢
          |  (∀y healthy(y)) → ∀x happy(x)
          |{
          |  1. ∀x healthy(x) → happy(x)              premise
          |  2. {
          |       3. ∀y healthy(y)                    assume
          |       4. {
          |            5. a
          |            6. healthy(a)                  ∀e 3 a
          |            7. healthy(a) → happy(a)       ∀e 1 a
          |            8. happy(a)                    →e 7 6
          |          }
          |       9. ∀x happy(x)                      ∀i 4
          |     }
          | 10. (∀y healthy(y)) → ∀x happy(x)         →i 2
          |}
        """.stripMargin)

      parsePredicate("existensial-1",
        """human(Socrates),  mortal(Socrates)  ⊢
          |  ∃x human(x) ∧ mortal(x)
          |{
          |  1. human(Socrates)                       premise
          |  2. mortal(Socrates)                      premise
          |  3. human(Socrates) ∧ mortal(Socrates)    ∧i 1 2
          |  4. ∃x human(x) ∧ mortal(x)               ∃i 3 Socrates
          |}
        """.stripMargin)

      parsePredicate("existensial-2",
        """vowel(e),  holds(square14, e)  ⊢
          |  ∃y vowel(y) ∧ ∃x holds(x, y)
          |{
          |  1. vowel(e)                              premise
          |  2. holds(square14, e)                    premise
          |  3. ∃x holds(x, e)                        ∃i 2 square14
          |  4. vowel(e) ∧ ∃x holds(x, e)             ∧i 1 3
          |  5. ∃y vowel(y) ∧ ∃x holds(x, y)          ∃i 4 e
          |}
        """.stripMargin)

      parsePredicate("existensial-3",
        """vowel(e),  holds(square14, e)  ⊢
          |  ∃y,x vowel(y) ∧ holds(x, y)
          |{
          |  1. vowel(e)                              premise
          |  2. holds(square14, e)                    premise
          |  3. vowel(e) ∧ holds(square14, e)         ∧i 1 2
          |  4. ∃y,x vowel(y) ∧ holds(x, y)           ∃i 3 e, square14
          |}
        """.stripMargin)

      parsePredicate("existensial-4",
        """∀x human(x) → mortal(x),  ∃y human(y)  ⊢
          |  ∃z mortal(z)
          |{
          |  1. ∀x human(x) → mortal(x)               premise
          |  2. ∃y human(y)                           premise
          |  3. {
          |       4. a
          |          human(a)                         assume
          |       5. human(a) → mortal(a)             ∀e 1 a
          |       6. mortal(a)                        →e 5 4
          |       7. ∃z mortal(z)                     ∃i 6 a
          |     }
          |  8. ∃z mortal(z)                          ∃e 2 3
          |}
        """.stripMargin)

      parsePredicate("existensial-5",
        """∃s covered(s) ∧ (∃c vowel(c) ∧ holds(s, c)),
          |(∃x covered(x)) → ¬gameOver  ⊢  ¬gameOver
          |{
          |  1. ∃s covered(s) ∧ (∃c vowel(c) ∧ holds(s, c))         premise
          |  2. (∃x covered(x)) → ¬gameOver                         premise
          |  3. {
          |       4. a
          |          covered(a) ∧ (∃c vowel(c) ∧ holds(a, c))       assume
          |       5. covered(a)                                     ∧e1 4
          |       6. ∃x covered(x)                                  ∃i 5 a
          |     }
          |  7. ∃x covered(x)                                       ∃e 1 3
          |  8. ¬gameOver                                           →e 2 7
          |}
        """.stripMargin)

    }
  }

  def parsePredicate(title: String, input: String)(
    implicit pos: org.scalactic.source.Position, spec: SireumSpec): Unit =
    parser(title, input) { p =>
      val r = p.sequentFile(SNone())
      check(r) && r.unitOpt.exists(_.isInstanceOf[TopUnit.SequentUnit])
    }

  def parsePropositional(title: String, input: String)(
    implicit pos: org.scalactic.source.Position, spec: SireumSpec): Unit =
    parser(title, input) { p =>
      val r = p.sequentFile(SNone())
      check(r) && r.unitOpt.exists(_.isInstanceOf[TopUnit.SequentUnit])
    }

  def parseTruthTable(title: String, input: String)(
    implicit pos: org.scalactic.source.Position, spec: SireumSpec): Unit =
    parser(title, input) { p =>
      val r = p.truthTable(SNone())
      check(r) && r.unitOpt.exists(_.isInstanceOf[TopUnit.TruthTableUnit])
    }

  def check(r: SlangParser.Result): Boolean = {
    if (r.tags.nonEmpty) {
      r.tags.foreach(Console.err.println)
      Console.err.flush()
    }
    r.tags.isEmpty
  }

  def parser[T](title: String, input: String)(f: LParser => Boolean)(
    implicit pos: org.scalactic.source.Position, spec: SireumSpec): Unit = spec.*(title) {
    val r: Boolean = try {
      LParser[Boolean](input)(f)
      //println(fparser(parser)
    } catch {
      case e: TokenizeException =>
        Console.err.println(s"[${e.pos.start.line}, ${e.pos.end.line}] ${e.getMessage}")
        e.printStackTrace()
        false
      case e: ParseException =>
        Console.err.println(s"[${e.pos.start.line}, ${e.pos.end.line}] ${e.getMessage}")
        e.printStackTrace()
        false
    }
    r
  }
}
