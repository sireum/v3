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
        |component C
        |  ports
        |    in cIn
        |    out cOut
        |
        |connection A -> B
        |connection B -> C
        |connection C -> A
      """.stripMargin))
    ,
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
  )

  def parsePass(input: String): Boolean = {
    Builder(input).isDefined
  }
}