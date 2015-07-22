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

package org.sireum.awas.parser

import org.sireum.awas.ast.Builder
import org.sireum.test._
import org.sireum.util._

final class Antlr4AwasParserTestDefProvider(tf: TestFramework)
  extends TestDefProvider {

  override def testDefs: ISeq[TestDef] = ivector(
    ConditionTest("properties", parsePass(
      """
        |types
        |
        |  lattice Top
        |
        |  lattice Left extends Top
        |
        |  lattice Right extends Top
        |
        |  lattice Bottom extends Left, Right
        |
        |  enum Error
        |
        |  enum Failure { AFail, BFail, CFail }
        |
        |  record R
        |    x: Integer
        |    y: Integer
        |
        |components
        |  A
        |    ports
        |      in aIn
        |      out aOut
        |    properties
        |      b0: Boolean
        |      b1 = true
        |      b2 = false
        |      b3: Boolean = true
        |      b4: Boolean = false
        |      x: Integer
        |      y = 4
        |      z: Integer = 5
        |      r0: Real
        |      r1 = 0.0
        |      r2: Real = 0.0
        |      s0: String
        |      s1 = "foo"
        |      s2: String = "bar"
        |      lat0: Top
        |      lat1 = Top
        |      lat2: Top = Left
        |      enum0: Failure
        |      enum1 = AFail
        |      enum2: Failure = BFail
        |      enum3: Error = Disconnected // checked with profile
        |      enum4 = Disconnected        // checked with profile
        |      rec0: R
        |      rec1 = R(1, 2)
        |      rec2: R = R(1, 2)
        |      set0: Set[Integer]
        |      set1 = Set(1, 2, 3)
        |      set2: Set[Integer] = Set[Integer](1, 2, 3)
        |      seq0: Seq[Integer]
        |      seq1 = Seq(1, 2, 3)
        |      seq2: Seq[Integer] = Seq[Integer](1, 2, 3)
        |      map0: Map[Integer, Integer]
        |      map1 = Map(1 -> 2, 2 -> 3, 3 -> 4)
        |      map2: Map[Integer, Integer] =
        |          Map[Integer, Integer](1 -> 2, 2 -> 3, 3 -> 4)
      """.stripMargin))
    ,
    ConditionTest("abcloop", parsePass(
      """
        |/*
        |
        |      ┌──── A ────┐       ┌──── B ────┐
        |      │           │       │           │
        |  ┌───▷aIn    aOut▷───────▷bIn    bOut▷──┐
        |  │   │           │       │           │  │
        |  │   └───────────┘       └───────────┘  │
        |  │                                      │
        |  │                                      │
        |  │             ┌──── C ────┐            │
        |  │             │           │            │
        |  └─────────────◁cOut    cIn◁────────────┘
        |                │           │
        |                └───────────┘
        |
        |*/
        |
        |components
        |  A
        |    ports
        |      in aIn
        |      out aOut
        |
        |  B
        |    ports
        |      in bIn
        |      out bOut
        |
        |  C
        |    ports
        |      in cIn
        |      out cOut
        |
        |connections
        |  A2B: A -> B
        |  B2C: B -> C
        |  C2A: C -> A
      """.stripMargin))
    /* , TODO: nested component
    ConditionTest("abNested", parsePass(
      """
        |/*
        |
        |   ┌───────────────────── AB ──────────────────────┐
        |   │                                               │
        |   │                                               │
        |   │      ┌──── A ────┐       ┌──── B ────┐        │
        |   │abIn  │           │       │           │   abOut│
        |   ▷──────▷aIn    aOut▷───────▷bIn    bOut▷────────▷
        |   │      │           │       │           │        │
        |   │      └───────────┘       └───────────┘        │
        |   │                                               │
        |   │                                               │
        |   └───────────────────────────────────────────────┘
        |
        |*/
        |
        |component AB
        |  ports
        |    in abIn
        |    out abOut
        |
        |enclosure AB
        |
        |component A
        |  ports
        |    in aIn
        |    out aOut
        |
        |component B
        |  ports
        |    in bIn
        |    out bOut
        |
        |connection AB -> A
        |connection A -> B
        |connection B -> AB
      """.stripMargin))
    ,
    ConditionTest("abNestedSeparateAssembly", parsePass(
      """
        |/*
        |
        |   ┌────────────────── sup::AB ────────────────────┐
        |   │                                               │
        |   │                                               │
        |   │      ┌─ sub::A ──┐       ┌─ sub::B ──┐        │
        |   │abIn  │           │       │           │   abOut│
        |   ▷──────▷aIn    aOut▷───────▷bIn    bOut▷────────▷
        |   │      │           │       │           │        │
        |   │      └───────────┘       └───────────┘        │
        |   │                                               │
        |   │                                               │
        |   └───────────────────────────────────────────────┘
        |
        |*/
        |
        |namespace sub
        |
        |enclosure MyEnclosure
        |  ports
        |    in enclosureIn
        |    out enclosureOut
        |
        |component A
        |  ports
        |    in aIn
        |    out aOut
        |
        |component B
        |  ports
        |    in bIn
        |    out bOut
        |
        |connection MyEnclosure -> A
        |connection A -> B
        |connection B -> MyEnclosure
        |
        |namespace sup
        |
        |component AB
        |  ports
        |    in abIn
        |    out abOut
        |
        |assembly AB for sub::MyEnclosure
        |  ports
        |    abIn as enclosureIn
        |    abOut as enclosureOut
      """.stripMargin))
     */
  )

  def parsePass(input: String): Boolean = {
    Builder(input).isDefined
  }
}