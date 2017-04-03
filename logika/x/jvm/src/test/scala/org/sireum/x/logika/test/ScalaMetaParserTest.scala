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

package org.sireum.x.logika.test

import org.sireum.x.logika.parser.ScalaMetaParser

class ScalaMetaParserTest extends LogikaXSpec {

  "Passing" - {

    "Empty Source" in {
      val r = ScalaMetaParser(None,
        """
        """)
      r == ScalaMetaParser.Result(None, Vector())
    }

    "Empty Package a.b.c" in {
      val r = ScalaMetaParser(None,
        """package a.b.c
        """)
      r.program.nonEmpty && r.tags.isEmpty
    }
  }

  "Failing" - {

    "Not Package or Logika Import" - {
      * {
        val r = ScalaMetaParser(None,
          """class A
          """)
        r.program.isEmpty && r.tags.nonEmpty
      }
      * {
        val r = ScalaMetaParser(None,
          """trait B
          """)
        r.program.isEmpty && r.tags.nonEmpty
      }
      * {
        val r = ScalaMetaParser(None,
          """object A
          """)
        r.program.isEmpty && r.tags.nonEmpty
      }
      * {
        val r = ScalaMetaParser(None,
          """import a.b.c
          """)
        r.program.isEmpty && r.tags.nonEmpty
      }
    }

    "Object Modifiers" - {
      * {
        val r = ScalaMetaParser(None,
          """final object A
          """)
        r.program.isEmpty && r.tags.nonEmpty
      }
      * {
        val r = ScalaMetaParser(None,
          """private object A
          """)
        r.program.isEmpty && r.tags.nonEmpty
      }
    }

    "Object Early Initializations" - {
      * {
        val r = ScalaMetaParser(None,
          """object A extends { val x: Z = 5 } with B
          """)
        r.program.isEmpty && r.tags.nonEmpty
      }
    }

    "Object Super Constructor Calls" - {
      * {
        val r = ScalaMetaParser(None,
          """object A extends with B(5)
          """)
        r.program.isEmpty && r.tags.nonEmpty
      }
    }
  }
}
