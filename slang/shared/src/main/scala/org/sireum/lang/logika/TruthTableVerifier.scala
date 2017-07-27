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
  type Assignment = ISZ[B]
  val kind: String = "Truth Table Verifier"
  val vs: Assignment = ISZ(T, F)

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

    def checkRowAssignments(): B = {
      @pure def allAssignments(i: Z,
                               keys: ISZ[String],
                               ss: ISZ[Assignment]): ISZ[Assignment] = {
        if (i >= keys.size) {
          return ss
        }
        return allAssignments(i + 1, keys, for (s <- ss; v <- vs) yield s :+ v)
      }

      val vars: ISZ[String] = for (id <- tt.vars) yield id.value
      val assignments = Set.empty.addAll(allAssignments(0, vars, ISZ(ISZ())))
      var currentAssignments = assignments
      for (row <- tt.rows) {
        val ra: ISZ[AST.Exp.LitB] = row.assignment.values
        if (ra.size != vars.size) {
          reporter.error(row.assignment.attr.posOpt, kind, "Invalid number of truth assignment values.")
        }
        if (tt.separator.beginColumn != row.separator.beginColumn) {
          reporter.error(Some(row.separator), kind, "Invalid separator position.")
        }
        val rowAssignment: Assignment = for (b <- ra) yield b.value
        if (!assignments.contains(rowAssignment)) {
          reporter.error(row.assignment.attr.posOpt, kind, s"Invalid truth assignment $rowAssignment.")
        } else {
          if (currentAssignments.contains(rowAssignment)) {
            currentAssignments = currentAssignments.remove(rowAssignment)
          } else {
            reporter.error(row.assignment.attr.posOpt, kind,
              s"Duplicated truth assignment $rowAssignment.")
          }
        }
      }
      if (currentAssignments.nonEmpty) {
        reporter.error(None(), kind, "There are still missing truth assignments.")
      }
      return currentAssignments.isEmpty
    }

    def checkAssignments(): (ISZ[Assignment], ISZ[Assignment]) = {
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

      var tas: ISZ[Assignment] = ISZ()
      var fas: ISZ[Assignment] = ISZ()

      for (row <- tt.rows) {
        val ra: ISZ[AST.Exp.LitB] = row.assignment.values
        val store = buildStore(ra)
        var resultMap = HashMap.empty[Z, (B, B)]

        def evalExp(e: AST.Exp): B = {
          def putResult(v: B, opt: B): Unit = {
            resultMap = resultMap.put(AST.Util.beginColumn(e.posOpt), (v, opt))
          }

          e match {
            case e: AST.Exp.Ident =>
              val r = store.get(e.id.value).getOrElse(F)
              putResult(r, T)
              return r
            case e: AST.Exp.Binary =>
              val r: B = e.op match {
                case AST.Exp.BinaryOp.And => evalExp(e.left) & evalExp(e.right)
                case AST.Exp.BinaryOp.Or => evalExp(e.left) | evalExp(e.right)
                case AST.Exp.BinaryOp.Imply => !evalExp(e.left) | evalExp(e.right)
                case _ => F
              }
              putResult(r, F)
              return r
            case e: AST.Exp.Unary =>
              val r: B =
                if (e.op == AST.Exp.UnaryOp.Not || e.op == AST.Exp.UnaryOp.Complement) !evalExp(e.exp)
                else F
              putResult(r, F)
              return r
            case _ => return F
          }
        }

        var p = T
        for (e <- tt.sequent.premises) {
          p = p & evalExp(e)
        }
        var c = T
        for (e <- tt.sequent.conclusions) {
          c = c & evalExp(e)
        }
        var rowValues: Assignment = ISZ[B]()
        var hasError = F
        for (b <- row.values.values) {
          val column = AST.Util.beginColumn(b.posOpt)
          resultMap.get(column) match {
            case Some(p@(v, _)) =>
              if (v != b.value) {
                hasError = T
              } else {
                rowValues = rowValues :+ v
              }
              resultMap.remove(column, p)
            case _ => reporter.error(b.posOpt, kind, "Invalid truth value position.")
          }
        }
        if (hasError) {
          reporter.error(row.values.attr.posOpt, kind, s"Some truth values are incorrect.")
        }
        var missing = F
        for (p <- resultMap.values if !p._2) {
          missing = T
        }
        if (missing) {
          reporter.error(row.values.attr.posOpt, kind, s"There are still some missing truth assignments.")
        }
        if ((tt.isSequent && p) || !tt.isSequent) {
          if (c) {
            tas = tas :+ rowValues
          } else {
            fas = fas :+ rowValues
          }
        }
      }
      return (tas, fas)
    }

    def checkConclusion(tas: ISZ[Assignment], fas: ISZ[Assignment]): Unit = {
      tt.conclusionOpt match {
        case Some(conclusion) =>
          if (tt.isSequent) {
            conclusion match {
              case conclusion: AST.TruthTable.Conclusion.Validity =>
                var set: Set[Assignment] =
                  if (conclusion.isValid) {
                    if (fas.nonEmpty) {
                      reporter.error(conclusion.attr.posOpt, kind, "Incorrect summary.")
                    }
                    Set.empty.addAll(tas)
                  } else {
                    if (fas.isEmpty) {
                      reporter.error(conclusion.attr.posOpt, kind, "Incorrect summary.")
                    }
                    Set.empty.addAll(fas)
                  }
                for (a <- conclusion.assignments) {
                  val ra = a.values
                  val w: Assignment = for (b <- ra) yield b.value
                  if (!set.contains(w)) {
                    reporter.error(a.attr.posOpt, kind, s"Incorrect witness.")
                  } else {
                    set = set.remove(w)
                  }
                }
                if (set.nonEmpty) {
                  reporter.error(conclusion.attr.posOpt, kind, "There are still some missing witnesses.")
                }
              case _ =>
            }
          } else {
            conclusion match {
              case conclusion: AST.TruthTable.Conclusion.Tautology if fas.nonEmpty =>
                reporter.error(conclusion.attr.posOpt, kind, "Incorrect summary.")
              case conclusion: AST.TruthTable.Conclusion.Contingent =>
                var taSet = Set.empty.addAll(tas)
                var faSet = Set.empty.addAll(fas)
                for (a <- conclusion.trueAssignments) {
                  val ra = a.values
                  val w: Assignment = for (b <- ra) yield b.value
                  if (!taSet.contains(w)) {
                    reporter.error(a.attr.posOpt, kind, s"Incorrect witness.")
                  } else {
                    taSet = taSet.remove(w)
                  }
                }
                for (a <- conclusion.falseAssignments) {
                  val ra = a.values
                  val w: Assignment = for (b <- ra) yield b.value
                  if (!faSet.contains(w)) {
                    reporter.error(a.attr.posOpt, kind, s"Incorrect witness.")
                  } else {
                    faSet = faSet.remove(w)
                  }
                }
                if (taSet.nonEmpty || faSet.nonEmpty) {
                  reporter.error(conclusion.attr.posOpt, kind, "There are still some missing witnesses.")
                }
              case conclusion: AST.TruthTable.Conclusion.Contradictory if tas.nonEmpty =>
                reporter.error(conclusion.attr.posOpt, kind, "Incorrect summary.")
              case _ =>
            }
          }
        case _ =>
          if (tt.isSequent) {
            reporter.error(None(), kind, "Missing 'Valid' or 'Invalid' summary.")
          } else {
            reporter.error(None(), kind, "Missing 'Tautology', 'Contingent', or 'Contradictory' summary.")
          }
      }
    }

    checkStarPositionsForm()

    if (reporter.hasIssue) {
      return
    }

    val all = checkRowAssignments()

    if (reporter.hasIssue) {
      return
    }

    val (tas, fas) = checkAssignments()

    if (all && !reporter.hasIssue) {
      checkConclusion(tas, fas)
    }

    return
  }
}
