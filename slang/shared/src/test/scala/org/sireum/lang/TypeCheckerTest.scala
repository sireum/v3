/*
 Copyright (c) 2018, Robby, Kansas State University
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

package org.sireum.lang

import org.sireum._
import org.sireum.lang.parser._
import org.sireum.lang.symbol._
import org.sireum.lang.tipe._
import org.sireum.lang.util.AccumulatingReporter
import org.sireum.test.SireumSpec

class TypeCheckerTest extends SireumSpec {

  {

    implicit val _spec: SireumSpec = this

    "Passing" - {

      "Worksheet" - {

        *(passingWorksheet(
          """import org.sireum._
            |val x: Either[B, Z] = MEither(rightOpt = MNone(), leftOpt = MSome(value = T))
          """.stripMargin
        ))

        *(passingWorksheet(
          """import org.sireum._
            |println(Map.empty[String, Z].put(value = 1, key = "A").get("B").getOrElse(default = 0))
          """.stripMargin
        ))

        *(passingWorksheet(
          """import org.sireum._
            |println(Z("0").getOrElse(1))
          """.stripMargin
        ))

        *(passingWorksheet(
          """import org.sireum._
            |val x: Either[B, Z] = Either(Some(T), None())
          """.stripMargin
        ))

        *(passingWorksheet(
          """import org.sireum._
            |println(Map.empty[String, Z].put("A", 1).get("B").getOrElse(0))
          """.stripMargin
        ))

        *(passingWorksheet(
          """import org.sireum._
            |var x: Z = 1
            |while (x > 0) {
            |  println("x is positive")
            |  x = 0
            |}
          """.stripMargin))

        *(passingWorksheet(
          """import org.sireum._
            |val x: Z = 1
            |if (x > 0) {
            |  println("x is positive")
            |}
          """.stripMargin))

        *(passingWorksheet(
          """import org.sireum._
            |val x: Z = 1
            |val y = x + 1
            |assert(y > x)
          """.stripMargin))

        *(passingWorksheet(
          """import org.sireum._
            |assert(3 > 0)
          """.stripMargin))

      }

      "Stmt" - {

        *(passingStmt("assert(true)"))

        *(passingStmt("assume(1 + 3 > 2)"))

        *(passingStmt("""assert(1 + 3 > 2, "ok")"""))

        *(passingStmt("""println(1, 2, "a", "b")"""))

        *(passingStmt("""eprintln(1, 2, "a", "b")"""))

        *(passingStmt("""print(1, 2, "a", "b")"""))

        *(passingStmt("""eprint(1, 2, "a", "b")"""))

        *(passingStmt("val x: org.sireum.Z = 1"))

        *(passingStmt("assert(org.sireum.T)"))

        *(passingStmt("assert(!org.sireum.F)"))

        *(passingStmt("""halt("foo")"""))
      }
    }

    "Failing" - {

      "Worksheet" - {

        *(failingWorksheet(
          """import org.sireum._
            |println(Z(s = "0").getOrElse(1))
          """.stripMargin,
          "Could not find parameter 's'"
        ))

      }

      "Stmt" - {

        *(failingStmt("assert(1)", "but found org.sireum.Z"))

        *(failingStmt("""halt(1)""", "but found org.sireum.Z"))

        *(failingStmt("""println(org.sireum.Map.empty)""", "Explicit type"))

        *(failingStmt("""println(org.sireum.Map.empty[org.sireum.Z])""", "Expecting 2 type arg"))

      }

    }
  }

  def passingStmt(input: Predef.String): Boolean = testStmt(input, isPassing = true)

  def failingStmt(input: Predef.String, msg: Predef.String): Boolean = testStmt(input, isPassing = false, msg)

  def passingWorksheet(input: Predef.String): Boolean = testWorksheet(input, isPassing = true)

  def failingWorksheet(input: Predef.String, msg: Predef.String): Boolean = testWorksheet(input, isPassing = false, msg)

  def testWorksheet(input: Predef.String, isPassing: Boolean, msg: Predef.String = ""): Boolean = {
    val reporter = AccumulatingReporter.create
    Parser(input).parseTopUnit[ast.TopUnit.Program](
      allowSireum = F, isWorksheet = T, isDiet = F, None(), reporter) match {
      case Some(program) =>
        val p = TypeChecker.checkWorksheet(program, reporter)
        if (reporter.hasIssue) {
          if (isPassing) {
            reporter.printMessages()
            return false
          } else {
            return reporter.messages.elements.exists(m => m.message.value.contains(msg))
          }
        }
        assert(isPassing)
        val t = ast.MTransformer(new ast.MTransformer.PrePost {
          def $owned: Boolean = F
          def $owned_=(b: Boolean): $internal.MutableMarker = this
          def $clone: $internal.MutableMarker = this
          def string: String = ""
          override def preTypedAttr(o: ast.TypedAttr): ast.MTransformer.PreResult[ast.TypedAttr] = {
            assert(o.typedOpt.nonEmpty)
            super.preTypedAttr(o)
          }
          override def preResolvedAttr(o: ast.ResolvedAttr): ast.MTransformer.PreResult[ast.ResolvedAttr] = {
            if (o.typedOpt.isEmpty) {
              new Throwable().printStackTrace()
            }
            assert(o.resOpt.nonEmpty && o.typedOpt.nonEmpty)
            super.preResolvedAttr(o)
          }

        })
        t.transformTopUnit(p)
      case _ =>
    }
    if (reporter.hasIssue) {
      reporter.printMessages()
    }
    !reporter.hasIssue
  }

  def testStmt(input: Predef.String, isPassing: Boolean, msg: Predef.String = ""): Boolean = {
    val (th, rep) = TypeChecker.typeHierarchyReporter
    if (rep.hasIssue) {
      rep.printMessages()
      return false
    }
    val typeChecker = TypeChecker(th, ISZ(), F)
    val stmt = Parser(input).parseStmt[ast.Stmt]
    val scope = Resolver.Scope.Local(HashMap.empty, HashMap.empty, None(), Some(Resolver.Scope.Global(ISZ(), ISZ(), ISZ())))
    val reporter = AccumulatingReporter.create
    typeChecker.checkStmt(scope, stmt, reporter) match {
      case (Some(_), checkedStmt) if isPassing =>
        if (reporter.hasIssue) {
          reporter.printMessages()
          return false
        }
        val t = ast.Transformer(new ast.Transformer.PrePost[Unit] {
          override def preTypedAttr(ctx: Unit, o: ast.TypedAttr): ast.Transformer.PreResult[Unit, ast.TypedAttr] = {
            assert(o.typedOpt.nonEmpty)
            super.preTypedAttr(ctx, o)
          }

          override def preResolvedAttr(ctx: Unit, o: ast.ResolvedAttr): ast.Transformer.PreResult[Unit, ast.ResolvedAttr] = {
            assert(o.resOpt.nonEmpty && o.typedOpt.nonEmpty)
            super.preResolvedAttr(ctx, o)
          }

          def string: String = ""
        })
        t.transformStmt((), checkedStmt)
        !reporter.hasIssue
      case _ =>
        !isPassing && reporter.errors.elements.exists(_.message.value.contains(msg))
    }
  }
}
