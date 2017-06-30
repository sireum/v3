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

import org.sireum.test._
import org.sireum.util._
import org.sireum.lang.parser.SlangParser

class ScalaMetaParserTest extends SireumSpec {
  {

    implicit val _spec: SireumSpec = this

    "Passing" - {

      passing("", addImport = false)

      passing("import org.sireum._", addImport = false)

      passing("package a.b.c; import org.sireum._", addImport = false)


      "Var/Val" - {

        passing("val x: Z = 4", isWorksheet = true)

        passing("var x: Z = 4", isWorksheet = true)

        passing("@spec val x: Z = $", isWorksheet = true)

        passing("@spec var x: Z = $", isWorksheet = true)

        passing("@ext object Foo { var x: Z = 4 }")

        passing("@ext object Foo { var x: Z = $ }")

      }

      "Method" - {

        passing("def f: Z = {}", isWorksheet = true)

        passing("def f(x: Z): Z = {}", isWorksheet = true)

        passing("@spec def f(x: Z): Z = $", isWorksheet = true)

        passing("@spec def f(x: Z): Z = l\"\"\" = 1\"\"\"", isWorksheet = true)

        passing("@pure def f(x: Z): Z = {}", isWorksheet = true)

      }

      "Object" - {

        passing("object Foo")

        passing("object Bar", isWorksheet = true)

        passing("object Foo { val x: Z = 10; var y: Z = 11 }")

      }

      "Type" - {

        passing("def f(x: ISZ[Z]): Z = {}", isWorksheet = true)

        passing("def f(x: A[Z, Z]): Z = {}", isWorksheet = true)

        passing("def f(x: (Z, Z)): Z = {}", isWorksheet = true)

        passing("def f(x: (Z, Z, (Z))): Z = {}", isWorksheet = true)

        passing("def f(x: (Z, Z, (Z, Y))): Z = {}", isWorksheet = true)

        passing("def f(x: Z => Z): Z = {}", isWorksheet = true)

        passing("def f(x: (Z) => Z): Z = {}", isWorksheet = true)

        passing("def f(x: (Z, Z) => Z): Z = {}", isWorksheet = true)

      }

      "Type Param" - {

        passing("def f[T](x: T, y: Z): T = {}", isWorksheet = true)

        passing("def f[T](x: Z): Z = {}", isWorksheet = true)

        passing("def f[A, B <: A](x: A, y: Z): B = {}", isWorksheet = true)

      }

      "Ext Object" - {

        passing("@ext object Foo")

        "Method" - {

          passing("@ext object Foo { def f: Z = $ }")

          passing("@ext object Foo { @pure def f: Z = $ }")

          passing("@ext object Foo { def f: Z = l\"\"\"reads g\nmodifies g\"\"\" }")
        }
      }
    }

    "Failing" - {

      failing("package org.sireum.logika", "org.sireum.logika", addImport = false)

      val packageFirstMember = "first member of packages"

      failing("package a.b.c", packageFirstMember, addImport = false)

      failing("package a.b.c; object Foo", packageFirstMember, addImport = false)

      failing("object Foo", "⊢", addImport = false)

      "Val/Var" - {

        val topMember = "expected class or object"

        failing("package a; import org.sireum._; val x: Z = 4", topMember, addImport = false)

        failing("package a; import org.sireum._; var x: Z = 4", topMember, addImport = false)

        val dollar = "'$' is only allowed"

        failing("val x: Z = $", dollar, isWorksheet = true)

        failing("var x: Z = $", dollar, isWorksheet = true)

        val enclosing = "inside methods or code blocks"

        failing("object O { val x = 5 }", enclosing)

        failing("object O { val x = 5 }", enclosing)

        val multiple = "Cannot define multiple"

        failing("val x, y: Z = 5", multiple, isWorksheet = true)

        failing("var x, y: Z = 5", multiple, isWorksheet = true)

        failing("@spec val x, y: Z = $", multiple, isWorksheet = true)

        failing("@spec var x, y: Z = $", multiple, isWorksheet = true)

        val specForm = "should have the form: '@spec"

        failing("@spec val x = 5", specForm, isWorksheet = true)

        failing("@spec var x = 5", specForm, isWorksheet = true)

        failing("@spec val x: Z = 5", specForm, isWorksheet = true)

        failing("@spec var x: Z = 5", specForm, isWorksheet = true)

        failing("var x: Z = _", "Uninitialized", isWorksheet = true)

        failing("var x = _", "unbound placeholder parameter", isWorksheet = true)

        failing("@spec @spec var x: Z = $", "Redundant @spec", isWorksheet = true)

        failing("private var x: Z = $", "Only the @spec modifier", isWorksheet = true)
      }

      "Method" - {

        failing("def f(x: Z)(y: Z): Z = {}", "multiple parameter tuples", isWorksheet = true)

        failing("def f(x: Z) = {}", "explicit return type", isWorksheet = true)

        failing("def f: Z = 4", "Only block", isWorksheet = true)

        val pureOrSpec = "@pure or @spec"

        failing("@ext def f(x: Z): Z = {}", pureOrSpec, isWorksheet = true)

        failing("@spec @pure def f(x: Z): Z = {}", pureOrSpec, isWorksheet = true)

        failing("@pure @spec def f(x: Z): Z = {}", pureOrSpec, isWorksheet = true)

        failing("@pure @pure def f(x: Z): Z = {}", "Redundant @pure", isWorksheet = true)

        failing("@spec @spec def f(x: Z): Z = {}", "Redundant @spec", isWorksheet = true)

        failing("@spec def f: Z = 4", "@spec method expression", isWorksheet = true)

        "Param" - {

          val paramTypeForms = "parameter should have the form"

          failing("def f(x: Z = 5): Z = {}", paramTypeForms, isWorksheet = true)

          failing("def f(x: => Z): Z = {}", "By name types", isWorksheet = true)

          failing("def f(x: Z*): Z = {}", "Repeated types", isWorksheet = true)
        }
      }

      "Object" - {

        "Modifier" - {
          val errMsg = "modifiers other than"

          failing("final object A", errMsg)

          failing("private object A", errMsg)
        }

        failing("object A extends { val x: Z = 5 } with B", "early init")

        failing("object A extends B(5)", "Super constructor")

      }

      "Ext Object" - {

        failing("@ext @ext object Foo", "Redundant @ext")

        failing("@ext object Foo { def f: Z = 4 }", "@ext object method expression")

      }

      "Type Param" - {

        val typeParamForms = "type parameters of the forms"

        failing("def f[T >: B](x: Z): Z = {}", typeParamForms, isWorksheet = true)

        failing("def f[T <% B](x: Z): Z = {}", typeParamForms, isWorksheet = true)

        failing("def f[T : TT](x: Z): Z = {}", typeParamForms, isWorksheet = true)

      }
    }
  }

  def parse(text: String, isWorksheet: Boolean, isPrelude: Boolean): SlangParser.Result =
    SlangParser(isPrelude, isWorksheet, isDiet = false, None, text)

  def passing(text: String,
              addImport: Boolean = true,
              isWorksheet: Boolean = false,
              isPrelude: Boolean = false)(
               implicit pos: org.scalactic.source.Position, spec: SireumSpec): Unit =
    spec.*(sub(text)) {
      val r = parse(s"${if (isPrelude) "" else "// #Sireum\n"}${if (addImport) "import org.sireum._; " else ""}$text",
        isWorksheet, isPrelude)
      val b = r.unitOpt.nonEmpty && r.tags.elements.isEmpty
      if (!b) report(r)
      b
    }

  def failing(text: String, msg: String,
              addImport: Boolean = true,
              isWorksheet: Boolean = false,
              isPrelude: Boolean = false)(
               implicit pos: org.scalactic.source.Position, spec: SireumSpec): Unit =
    spec.*(sub(text)) {
      val r = parse(s"${if (isPrelude) "" else "// #Sireum\n"}${if (addImport) "import org.sireum._; " else ""}$text",
        isWorksheet, isPrelude)
      val b = r.tags.elements.exists {
        case t: MessageTag => t.message.contains(msg)
        case _ => false
      }
      if (!b) report(r)
      b
    }

  def sub(text: String, max: Int = 100): String = {
    if (text.length <= max) text else text.substring(0, max) + " ... " + text.hashCode.toHexString
  }

  def report(r: SlangParser.Result): Unit = {
    System.err.println(r.text)
    System.err.println(r.unitOpt)
    val reporter = new ConsoleTagReporter
    r.tags.foreach(reporter.report)
  }
}
