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

import org.sireum.util._
import org.sireum.x.logika.parser.ScalaMetaParser

class ScalaMetaParserTest extends LogikaXSpec {

  "Passing" - {

    passing("")

    passing("package a.b.c")

    "Object" - {

      passing("object Foo")

      "Method" - {

        passing("object Foo { def f: Z = {} }")

        passing("object Foo { def f(x: Z): Z = {} }")

        passing("object Foo { @spec def f(x: Z): Z = $ }")

        passing("object Foo { @spec def f(x: Z): Z = c\"\"\"{ reads g }\"\"\" }")

        passing("object Foo { @pure def f(x: Z): Z = {} }")

        passing("object Foo { def f[T](x: T, y: Z): T = {} }")

        passing("object Foo { def f[A, B <: A](x: A, y: Z): B = {} }")
      }
    }

    "Ext Object" - {

      passing("@ext object Foo")

      "Method" - {

        passing("@ext object Foo { def f: Z = $ }")

        passing("@ext object Foo { @pure def f: Z = $ }")

        passing("@ext object Foo { def f: Z = c\"\"\"{ reads g }\"\"\" }")
      }
    }
  }

  "Failing" - {

    "Object" - {

      "Modifier" - {
        val errMsg = "modifiers other than"

        failing("final object A", errMsg)

        failing("private object A", errMsg)
      }

      failing("object A extends { val x: Z = 5 } with B", "early init")

      failing("object A extends B(5)", "super constructor")

      "Method" - {

        failing("object Foo { def f(x: Z)(y: Z): Z = {} }", "multiple parameter tuples")

        failing("object Foo { def f(x: Z) = {} }", "explicit return type")

        failing("object Foo { def f: Z = 4 }", "Only block")

        val pureOrSpec = "@pure or @spec"

        failing("object Foo { @ext def f(x: Z): Z = {} }", pureOrSpec)

        failing("object Foo { @spec @pure def f(x: Z): Z = $ }", pureOrSpec)

        failing("object Foo { @pure @spec def f(x: Z): Z = $ }", pureOrSpec)

        failing("object Foo { @pure @pure def f(x: Z): Z = {} }", "Redundant @pure")

        failing("object Foo { @spec @spec def f(x: Z): Z = $ }", "Redundant @spec")

        failing("object Foo { @spec def f: Z = 4 }", "@spec method expression")

        val paramTypeForms = "'<id> : <type>'"

        failing("object Foo { def f(x: Z = 5): Z = {} }", paramTypeForms)

        failing("object Foo { def f(@pure x: Z): Z = {} }", paramTypeForms)

        failing("object Foo { def f(x: => Z): Z = {} }", "By name types")

        failing("object Foo { def f(x: Z*): Z = {} }", "Repeated types")

        val typeParamForms = "'<id>' or '<id> <: <type>'"

        failing("object Foo { def f[T >: B](x: Z): Z = {} }", typeParamForms)

        failing("object Foo { def f[T <% B](x: Z): Z = {} }", typeParamForms)

        failing("object Foo { def f[T : TT](x: Z): Z = {} }", typeParamForms)

        failing("object Foo { def f[T <: (Z) => Z](x: Z): Z = {} }", "Type parameter bound")

        failing("object Foo { def f(x: (Z, Z)): Z = {} }", "Type '(Z, Z)' is")
      }
    }

    "Ext Object" - {
      failing("@ext object Foo { def f: Z = 4 }", "@ext object method expression")
    }
  }

  def parse(text: String): ScalaMetaParser.Result =
    ScalaMetaParser(isDiet = false, None, text)

  def passing(text: String)(implicit pos: org.scalactic.source.Position): Unit =
    *(text) {
      val r = parse(s"//#Logika\n$text")
      val b = r.program.nonEmpty && r.tags.isEmpty
      if (!b) report(r)
      b
    }

  def failing(text: String, msg: String)(implicit pos: org.scalactic.source.Position): Unit =
    *(text) {
      val r = parse(s"//#Logika\n$text")
      val b = r.tags.exists {
        case t: MessageTag => t.message.contains(msg)
        case _ => false
      }
      if (!b) report(r)
      b
    }

  def report(r: ScalaMetaParser.Result): Unit = {
    System.err.println(r.program)
    val reporter = new ConsoleTagReporter
    r.tags.foreach(reporter.report)
  }
}