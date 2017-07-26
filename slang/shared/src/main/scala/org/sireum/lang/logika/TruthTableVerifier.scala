// #Sireum
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

package org.sireum.lang.logika

import org.sireum._
import org.sireum.lang.util.Reporter
import org.sireum.lang.{ast => AST}

object TruthTableVerifier {
  val kind: String = "Truth Table Verifier"
  val vs: ISZ[B] = ISZ(T, F)

  def verify(tt: AST.TopUnit.TruthTableUnit, reporter: Reporter): Unit = {

    def checkStarPositionsForm(): Unit = {
      val varSet: HashSet[String] = {
        var r = HashSet.empty[String]
        for (id <- tt.vars) {
          val x = id.value
          if (r.contains(x)) {
            reporter.error(id.attr.posOpt, kind, s"Redeclaration of '$x'.")
          } else {
            r = r.add(x)
          }
        }
        r
      }
      def checkExp(e: AST.Exp): Unit = {
        var hasError = F
        e match {
          case _: AST.Exp.LitB =>
          case e: AST.Exp.Ident =>
            val x = e.id.value
            if (!varSet.contains(x)) {
              reporter.error(e.posOpt, kind, s"Undeclared usage '$x'.")
            }
          case e: AST.Exp.Binary =>
            e.op match {
              case AST.Exp.BinaryOp.And =>
              case AST.Exp.BinaryOp.Or =>
              case AST.Exp.BinaryOp.Imply =>
              case _ => hasError = T
            }
            checkExp(e.left)
            checkExp(e.right)
          case e: AST.Exp.Unary =>
            e.op match {
              case AST.Exp.UnaryOp.Not =>
              case AST.Exp.UnaryOp.Complement =>
              case _ => hasError = T
            }
            checkExp(e.exp)
          case _ => hasError = T
        }
        if (hasError) {
          reporter.error(e.posOpt, kind, "Unallowable expression in truth table.")
        }
      }

      var i = 0
      val stars: ISZ[AST.PosInfo] = tt.stars
      for (e <- tt.sequent.premises ++ tt.sequent.conclusions) {
        if (i < stars.size) {
          val posOpt = Some(stars(i))
          if (!AST.Util.beginColumnEqual(posOpt, e.posOpt)) {
            reporter.error(posOpt, kind, "Invalid * position.")
          }
        } else {
          reporter.error(e.posOpt, kind, "No associated * found.")
        }
        checkExp(e)
        i = i + 1
      }
    }

    def checkRowAssignments(): Unit = {
      @pure def allAssignments(i: Z,
                               keys: ISZ[String],
                               ss: ISZ[ISZ[B]]): ISZ[ISZ[B]] = {
        if (i >= keys.size) {
          return ss
        }
        return allAssignments(i + 1, keys, for (s <- ss; v <- vs) yield s :+ v)
      }

      val vars: ISZ[String] = for (id <- tt.vars) yield id.value
      val assignments = Set.empty.addAll(allAssignments(0, vars, ISZ(ISZ())))
      var currentAssignments = assignments
      for (row <- tt.rows) {
        val ra: ISZ[AST.Exp.LitB] = row.assignment
        if (ra.size != vars.size) {
          reporter.error(AST.Util.posOptRange(ra(0).attr.posOpt,
            ra(ra.size - 1).attr.posOpt), kind, "Invalid number of truth assignment values.")
        }
        if (tt.separator.beginColumn != row.separator.beginColumn) {
          reporter.error(Some(row.separator), kind, "Invalid separator position.")
        }
        val rowAssignment = for (b <- ra) yield b.value
        if (!assignments.contains(rowAssignment)) {
          reporter.error(AST.Util.posOptRange(ra(0).attr.posOpt,
            ra(ra.size - 1).attr.posOpt), kind, s"Invalid truth assignment $rowAssignment.")
        } else {
          if (currentAssignments.contains(rowAssignment)) {
            currentAssignments = currentAssignments.remove(rowAssignment)
          } else {
            reporter.error(AST.Util.posOptRange(ra(0).attr.posOpt,
              ra(ra.size - 1).attr.posOpt), kind,
              s"Duplicated truth assignment $rowAssignment.")
          }
        }
      }
      if (currentAssignments.nonEmpty) {
        reporter.error(None(), kind, "There are still missing truth assignments.")
      }
    }

    def checkAssignments(): Unit = {
      def buildStore(assignment: ISZ[AST.Exp.LitB]): HashMap[String, B] = {
        val vars: ISZ[AST.Id] = tt.vars
        val size = vars.size
        var store = HashMap.emptyInit[String, B](size)
        for (i <- 0 until size) {
          val x = vars(i)
          val v = assignment(i)
          if (!AST.Util.beginColumnEqual(x.attr.posOpt, v.attr.posOpt)) {
            reporter.error(v.attr.posOpt, kind, "Invalid asssignment position.")
          }
          store = store.put(x.value, v.value)
        }
        return store
      }

      for (row <- tt.rows) {
        val ra: ISZ[AST.Exp.LitB] = row.assignment
        val store = buildStore(ra)
        var resultMap = HashMap.empty[Z, B]

        def evalExp(e: AST.Exp): Option[B] = {
          def putResult(vOpt: Option[B]): Unit = {
            vOpt match {
              case Some(v) => resultMap = resultMap.put(AST.Util.beginColumn(e.posOpt), v)
              case _ =>
            }
          }
          e match {
            case e: AST.Exp.Ident =>
              val r = store.get(e.id.value)
              putResult(r)
              return r
            case e: AST.Exp.Binary =>
              val r: Option[B] = e.op match {
                case AST.Exp.BinaryOp.And =>
                  for (v1 <- evalExp(e.left); v2 <- evalExp(e.right)) yield v1 & v2
                case AST.Exp.BinaryOp.Or =>
                  for (v1 <- evalExp(e.left); v2 <- evalExp(e.right)) yield v1 | v2
                case AST.Exp.BinaryOp.Imply =>
                  for (v1 <- evalExp(e.left); v2 <- evalExp(e.right)) yield !v1 | v2
                case _ => None()
              }
              putResult(r)
              return r
            case e: AST.Exp.Unary =>
              if (e.op == AST.Exp.UnaryOp.Not || e.op == AST.Exp.UnaryOp.Complement) {
                val r: Option[B] = for (v <- evalExp(e.exp)) yield !v
                putResult(r)
                return r
              } else {
                return None()
              }
            case _ => return None()
          }
        }

      }
    }

    checkStarPositionsForm()

    if (reporter.hasIssue) {
      return
    }

    checkRowAssignments()

    if (reporter.hasIssue) {
      return
    }

    checkAssignments()

    return
  }
}
