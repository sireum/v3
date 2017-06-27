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

import org.sireum.lang.parser.{LParser, ScalaMetaParser}
import org.sireum.test.SireumSpec

import scala.meta._

class LParserTest extends SireumSpec {
  {
    implicit val _spec: SireumSpec = this

    "Truth Table" - {
      def parse(title: String, input: String)(
        implicit pos: org.scalactic.source.Position, spec: SireumSpec): Unit = spec.*(title) {
        val parser = new LParser(Input.String(input), ScalaMetaParser.scalaDialect(true))
        val r: Boolean = try {
          val r = parser.truthTable()
          //println(r)
          true
        } catch {
          case e: ParseException =>
            Console.err.println(s"[${e.pos.start.line}, ${e.pos.end.line}] ${e.getMessage}")
            e.printStackTrace()
            false
        }
        r
      }

      parse("and",
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

      parse("or",
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

      parse("implication",
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

      parse("negation",
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

      parse("example-1",
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

      parse("example-2",
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

      parse("example-3",
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

      parse("example-4",
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

      parse("example-5",
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

      parse("intro-to-prop-logic-a",
        """        *    *    *
          |--------------------
          |p q | p → q, ¬q ⊢ ¬p
          |--------------------
          |T T |   T    F  T  F
          |T F |   F    T  T  F
          |F T |   T    F  T  T
          |F F |   T    T  T  T
          |--------------------
          |
          |Valid [FF]
        """.stripMargin)

      parse("intro-to-prop-logic-b",
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

      parse("intro-to-prop-logic-c",
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

      parse("sequent-1-a",
        """        *    *    *
          |--------------------
          |p q | p → q, ¬q ⊢ ¬q
          |--------------------
          |T T |   T    F  T F
          |T F |   F    T  T T
          |F T |   T    F  T F
          |F F |   T    T  T T
          |--------------------
          |
          |Valid [FF]
        """.stripMargin)

      parse("sequent-1-b",
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

      parse("sequent-1-c",
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

      parse("sequent-2-a",
        """        *     *
          |----------------
          |p q | p → q ⊢ ¬q
          |----------------
          |T T |   T   F F
          |T F |   F   T T
          |F T |   T   F F
          |F F |   T   T T
          |----------------
          |
          |Valid [TT] [FT]
        """.stripMargin)

      parse("sequent-2-b",
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
  }
}
