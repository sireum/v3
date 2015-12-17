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

package org.sireum.logika

import org.sireum.logika.ast._
import org.sireum.logika.util._
import org.sireum.util._

object Checker {
  final def check(unitNode: UnitNode)(
    implicit reporter: Reporter): Boolean = unitNode match {
    case s: Sequent =>
      assert(s.mode == LogicMode.Propositional ||
        s.mode == LogicMode.Predicate)
      var vars = isetEmpty[String]
      for (e <- s.premises ++ s.conclusions)
        vars ++= collectVars(e)
      s.proofOpt match {
        case Some(proof) =>
          implicit val nodeLocMap = s.nodeLocMap
          check(proof, ProofContext(s.mode, s.premises.toSet, vars,
            imapEmpty, imapEmpty)).isDefined
        case _ =>
          ???
      }
  }

  private def check(proofGroup: ProofGroup,
                    pc: ProofContext): Option[ProofContext] = {
    var pcOpt: Option[ProofContext] =
      proofGroup match {
        case p: SubProof =>
          val popt =
            p.assumeStep match {
              case PlainAssumeStep(_, exp) =>
                pc.addProvedStep(p.assumeStep)
              case ForallAssumeStep(_, id) => pc.addVar(id)
              case ExistsAssumeStep(_, id, exp) =>
                pc.addVar(id).flatMap(_.addProvedStep(p.assumeStep))
            }
          popt.flatMap(_.addProvedStep(p))
        case _ => Some(pc)
      }
    for (step <- proofGroup.steps if pcOpt.isDefined) step match {
      case p: RegularStep =>
        pcOpt = pcOpt.flatMap(_.check(p))
      case p: SubProof =>
        pcOpt = check(p, pcOpt.get)
    }
    pcOpt
  }

  private final def collectVars(e: Exp): ISet[String] = {
    var result = isetEmpty[String]
    Visitor.build({
      case Id(value) =>
        result += value
        false
    })(e)
    result
  }
}

private final case class
ProofContext(mode: LogicMode,
             premises: ISet[Exp],
             vars: ISet[String],
             facts: IMap[String, Exp],
             provedSteps: IMap[Int, ProofStep])
            (implicit reporter: Reporter,
             nodeLocMap: MIdMap[Node, LocationInfo]) {

  def check(step: RegularStep): Option[ProofContext] = {
    val num = step.num.value
    step match {
      case Premise(_, exp) =>
        if (premises.contains(exp)) addProvedStep(step)
        else error(exp, s"Could not find the claimed premise in step #$num.")
      case AndIntro(_, and, lStep, rStep) =>
        (for (lExp <- findRegularStepExp(lStep);
              rExp <- findRegularStepExp(rStep)) yield {
          val expected = And(lExp, rExp)
          if (expected == step.exp) addProvedStep(step)
          else error(and, s"And-intro in step #$num with #${lStep.value} on the left and #${rStep.value} on the right does not produce the expressed form.")
        }).flatten
      case AndElim1(_, exp, andStep) =>
        findRegularStepExp(andStep) match {
          case Some(And(expected, _)) =>
            if (expected == exp) addProvedStep(step)
            else error(exp, s"The conjunction's left sub-expression in step #${andStep.value} does not match #$num for And-elim1.")
          case Some(_) => error(andStep, "And-elim1 requires a conjunction.")
          case _ => None
        }
      case AndElim2(_, exp, andStep) =>
        findRegularStepExp(andStep) match {
          case Some(And(_, expected)) =>
            if (expected == exp) addProvedStep(step)
            else error(exp, s"The conjunction's right sub-expression in step #${andStep.value} does not match #$num for And-elim2.")
          case Some(_) => error(andStep, "And-elim2 requires a conjunction.")
          case _ => None
        }
      case OrIntro1(_, or@Or(lExp, _), step2) =>
        findRegularStepExp(step2) match {
          case Some(expected) =>
            if (expected == lExp) addProvedStep(step)
            else error(lExp, s"The disjunction's left sub-expression in step #$num does not match #${step2.value} for Or-intro1.")
          case _ => None
        }
      case OrIntro2(_, or@Or(_, rExp), step2) =>
        findRegularStepExp(step2) match {
          case Some(expected) =>
            if (expected == rExp) addProvedStep(step)
            else error(rExp, s"The disjunction's right sub-expression in step #$num does not match #${step2.value} for Or-intro2.")
          case _ => None
        }
      case OrElim(_, exp, orStep, lSubProof, rSubProof) =>
        findRegularStepExp(orStep) match {
          case Some(Or(lExp, rExp)) =>
            val r =
              for (lsp <- findSubProof(lSubProof);
                   rsp <- findSubProof(rSubProof)) yield {
                var hasError = false
                (lsp.first, rsp.first, lsp.last, rsp.last) match {
                  case (lfs: PlainAssumeStep, rfs: PlainAssumeStep,
                  lls: RegularStep, rls: RegularStep) =>
                    if (lfs.exp != lExp) {
                      error(lSubProof, s"Assumed expression does not match the left sub-expression of #${orStep.value} for Or-elim.")
                      hasError = true
                    }
                    if (rfs.exp != rExp) {
                      error(lSubProof, s"Assumed expression does not match the right sub-expression of #${orStep.value} for Or-elim.")
                      hasError = true
                    }
                    if (lls.exp != exp) {
                      error(lSubProof, s"Conclusion of the left sub-proof does not match the expression in #$num for Or-elim.")
                      hasError = true
                    }
                    if (rls.exp != exp) {
                      error(lSubProof, s"Conclusion of the right sub-proof does not match the expression in #$num for Or-elim.")
                      hasError = true
                    }
                  case (lfs, rfs, lls, rls) =>
                    if (!lfs.isInstanceOf[PlainAssumeStep]) {
                      error(lSubProof, s"Wrong form for Or-elim left assumption.")
                    }
                    if (!rfs.isInstanceOf[PlainAssumeStep]) {
                      error(lSubProof, s"Wrong form for Or-elim right assumption.")
                    }
                    if (!lls.isInstanceOf[RegularStep]) {
                      error(lSubProof, s"Wrong form for Or-elim left conclusion.")
                    }
                    if (!rls.isInstanceOf[RegularStep]) {
                      error(lSubProof, s"Wrong form for Or-elim right conclusion.")
                    }
                    hasError = true
                }
                if (hasError) None else addProvedStep(step)
              }
            r.flatten
          case _ =>
            error(orStep, s"Or-elim requires a disjunction in step # ${orStep.value}.")
        }
      case ImpliesIntro(_, Implies(antecedent, conclusion), subProof) =>
        findSubProof(subProof) match {
          case Some(sp) =>
            var hasError = false
            (sp.first, sp.last) match {
              case (fs: PlainAssumeStep, ls: RegularStep) =>
                if (fs.exp != antecedent) {
                  error(antecedent, s"The antecedent of step #$num does not match the assumption of #${subProof.value} for Implies-intro.")
                  hasError = true
                }
                if (ls.exp != conclusion) {
                  error(antecedent, s"The consequent of step #$num does not match the conclusion of #${subProof.value} for Implies-intro.")
                  hasError = true
                }
              case (fs, ls) =>
                if (fs.isInstanceOf[PlainAssumeStep]) {
                  error(sp, s"Wrong form for Implies-intro assumption.")
                  hasError = true
                }
                if (ls.isInstanceOf[RegularStep]) {
                  error(sp, s"Wrong form for Implies-intro conclusion.")
                  hasError = true
                }
            }
            if (hasError) None else addProvedStep(step)
          case _ => None
        }
      case ImpliesElim(_, exp, impliesStep, antecedentStep) =>
        (findRegularStepExp(impliesStep),
          findRegularStepExp(antecedentStep)) match {
          case (Some(Implies(a, c)), Some(antecedent)) =>
            var hasError = false
            if (a != antecedent) {
              error(step, s"The expression in #${antecedentStep.value} does not match the antecedent in #${impliesStep.value} for Implies-elim of step #$num.")
              hasError = true
            }
            if (c != exp) {
              error(exp, s"The conclusion in #${impliesStep.value} does not match the expression in #$num for Implies-elim.")
              hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case (Some(_), _) =>
            error(impliesStep, s"Implies-elim requires an implication.")
            None
          case _ => None
        }
    }
  }

  def addProvedStep(step: ProofStep): Option[ProofContext] = {
    val num = step.num.value
    provedSteps.get(num) match {
      case Some(other) =>
        val (l, c, _) = lineColumnOffset(other)
        error(step, s"Step #$num has already been used in at line $l, column $c.")
        None
      case _ =>
        Some(copy(provedSteps = provedSteps + (num -> step)))
    }
  }

  def addVar(id: Id): Option[ProofContext] = {
    val varId = id.value
    if (vars.contains(varId)) {
      error(id, s"$varId is not fresh.")
      None
    } else Some(copy(vars = vars + varId))
  }

  def lineColumnOffset(n: Node): (Int, Int, Int) = {
    val li = nodeLocMap(n)
    (li.lineBegin, li.columnBegin, li.offset)
  }

  def findSubProof(num: Num): Option[SubProof] = {
    provedSteps.get(num.value) match {
      case Some(r: SubProof) => Some(r)
      case Some(_) =>
        val (l, c, o) = lineColumnOffset(num)
        reporter.error(l, c, o, s"#${num.value} should be a sub-proof.")
        None
      case _ =>
        val (l, c, o) = lineColumnOffset(num)
        reporter.error(l, c, o, s"Could not find the referenced sub-proof #${num.value}.")
        None
    }
  }

  def findRegularStepExp(num: Num): Option[Exp] =
    provedSteps.get(num.value) match {
      case Some(r: RegularStep) => Some(r.exp)
      case _ =>
        val (l, c, o) = lineColumnOffset(num)
        reporter.error(l, c, o, s"Could not find the referenced step #${num.value}.")
        None
    }

  def error(n: Node, msg: String): Option[ProofContext] = {
    val (l, c, o) = lineColumnOffset(n)
    reporter.error(l, c, o, msg)
    None
  }
}
