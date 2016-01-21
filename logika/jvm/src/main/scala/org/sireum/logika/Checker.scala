/*
 Copyright (c) 2016, Robby, Kansas State University
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
import org.sireum.logika.tipe.TypeChecker
import org.sireum.logika.util._
import org.sireum.util.Rewriter.TraversalMode
import org.sireum.util._

object Checker {
  private[logika] final val top = BooleanLit(true)
  private[logika] final val bottom = BooleanLit(false)
  private[logika] final val zero = IntLit("0")
  private[logika] final val kind = "Proof Checker"

  final def check(m: message.Check)(
    implicit reporter: AccumulatingTagReporter): message.Result = {
    var unitNodes = ivectorEmpty[UnitNode]
    for (message.ProofFile(fileUriOpt, text) <- m.proofs) {
      Builder(fileUriOpt, text).foreach(unitNodes :+= _)
    }
    if (reporter.hasError) {
      reporter.report(ErrorMessage("AST",
        if (m.proofs.size > 1) "The inputs are ill-formed."
        else "The input is ill-formed."))
      return message.Result(m.requestId, m.isSilent, reporter.tags.toVector)
    }
    if (unitNodes.forall(_.isInstanceOf[Program])) {
      val programs = unitNodes.map(_.asInstanceOf[Program])
      if (TypeChecker.check(programs: _*)) {
        if (m.lastOnly)
          check(programs.last, m.autoEnabled, m.timeout, m.checkSat, m.hintEnabled)
        else
          for (program <- programs)
            check(program, m.autoEnabled, m.timeout, m.checkSat, m.hintEnabled)
      } else {
        reporter.report(ErrorMessage(TypeChecker.kind,
          if (m.proofs.size > 1) "The programs are ill-formed."
          else "The program is ill-formed."))
      }
    } else if (unitNodes.forall(_.isInstanceOf[Sequent])) {
      val sequents = unitNodes.map(_.asInstanceOf[Sequent])
      if (m.lastOnly)
        reporter.report(WarningMessage("AST", "Last mode is only applicable for checking programs."))
      for (sequent <- sequents)
        check(sequent, autoEnabled = false, m.timeout, m.checkSat, m.hintEnabled)
    } else {
      reporter.report(ErrorMessage("AST", "Cannot check mixed programs and sequents."))
    }
    message.Result(m.requestId, m.isSilent, reporter.tags.toVector)
  }

  final def check(unitNode: UnitNode, autoEnabled: Boolean = false,
                  timeoutInMs: Int = 2000, checkSat: Boolean = false,
                  hintEnabled: Boolean = false)(
                   implicit reporter: AccumulatingTagReporter): Boolean = unitNode match {
    case s: Sequent =>
      assert(s.mode == LogicMode.Propositional ||
        s.mode == LogicMode.Predicate)
      implicit val fileUriOpt = s.fileUriOpt
      var vars = isetEmpty[String]
      for (e <- s.premises ++ s.conclusions)
        vars ++= collectVars(e)
      s.proofOpt match {
        case Some(proof) =>
          implicit val nodeLocMap = s.nodeLocMap
          var r = DefaultProofContext(s, autoEnabled, timeoutInMs,
            checkSat, hintEnabled, premises = ilinkedSetEmpty ++ s.premises).
            check(proof).isDefined
          val exps = proof.steps.flatMap(_ match {
            case s: RegularStep => Some(s.exp)
            case _ => None
          }).toSet
          for (c <- s.conclusions)
            if (!exps.contains(c)) {
              r = false
              error(fileUriOpt, nodeLocMap(c), s"The sequent conclusion has not been proved.")
            }
          if (r) reporter.report(InfoMessage(kind, s"${unitNode.mode.value} logic proof is accepted."))
          else reporter.report(ErrorMessage(kind, s"${unitNode.mode.value} logic proof is rejected."))
          r
        case _ =>
          reporter.report(ErrorMessage(kind, s"${unitNode.mode.value} logic proof is yet to be done."))
          false
      }
    case program: Program =>
      implicit val fileUriOpt = program.fileUriOpt
      implicit val nodeLocMap = program.nodeLocMap
      var hasProof = false
      Visitor.build({
        case _: ProofStmt => hasProof = true; false
        case InvStmt(inv) if inv.exps.nonEmpty =>
          hasProof = true; false
        case Requires(exps) if exps.nonEmpty =>
          hasProof = true; false
        case Ensures(exps) if exps.nonEmpty =>
          hasProof = true; false
        case LoopInv(inv, _) if inv.exps.nonEmpty =>
          hasProof = true; false
      })(program)
      if (!hasProof) {
        reporter.report(WarningMessage(kind, "No programming logic proof element found."))
      }
      val r =
        DefaultProofContext(program, autoEnabled, timeoutInMs,
          checkSat, hintEnabled).check(program)
      if (r) {
        if (hasProof)
          reporter.report(InfoMessage(kind, s"Programming logic proof is accepted."))
      } else reporter.report(ErrorMessage(kind, s"Programming logic proof is rejected."))
      r
  }

  private[logika] final def collectVars(e: Exp): ISet[String] = {
    var result = isetEmpty[String]
    Visitor.build({
      case Id(value) =>
        result += value
        false
    })(e)
    result
  }

  private[logika] def error(fileUriOpt: Option[FileResourceUri],
                            li: LocationInfo, msg: String)(
                             implicit reporter: AccumulatingTagReporter): Unit = {
    reporter.report(li.toLocationError(fileUriOpt, kind, msg))
  }
}

private abstract class
ProofContext[T <: ProofContext[T]](implicit reporter: AccumulatingTagReporter) {

  val mode = unitNode.mode
  val fileUriOpt = unitNode.fileUriOpt
  implicit val nodeLocMap = unitNode.nodeLocMap
  val satTimeoutInMs = scala.math.min(timeoutInMs / 2, 500)

  def unitNode: UnitNode

  def premises: ILinkedSet[Exp]

  def vars: ISet[String]

  def provedSteps: IMap[Natural, ProofStep]

  def declaredStepNumbers: IMap[Natural, LocationInfo]

  def timeoutInMs: Natural

  def checkSat: Boolean

  def hintEnabled: Boolean

  def invariants: ILinkedSet[Exp]

  def facts: IMap[String, Exp]

  def autoEnabled: Boolean

  def make(vars: ISet[String] = vars,
           provedSteps: IMap[Natural, ProofStep] = provedSteps,
           declaredStepNumbers: IMap[Natural, LocationInfo] = declaredStepNumbers,
           premises: ILinkedSet[Exp] = premises): T

  def checkSat(exps: Iterable[Exp], unsatMsg: => String,
               unknownMsg: => String, timeoutMsg: => String): Boolean = {
    val es = (exps ++ facts.values).toVector
    !checkSat || (Z3.checkSat(satTimeoutInMs, es: _*) match {
      case Z3.Sat =>
        true
      case Z3.Unsat =>
        error(es.head, unsatMsg); false
      case Z3.Unknown =>
        warn(es.head, unknownMsg); true
      case Z3.Timeout =>
        warn(es.head, timeoutMsg); true
      case Z3.Error =>
        false
    })
  }

  def check(proofGroup: ProofGroup): Option[T] = {
    var addedVars = isetEmpty[String]
    var addedSteps = isetEmpty[Natural]
    var pcOpt: Option[T] =
      proofGroup match {
        case p: SubProof =>
          val popt = p.assumeStep match {
            case PlainAssumeStep(_, exp) =>
              addProvedStep(p.assumeStep)
            case ForAllAssumeStep(num, id, _) =>
              addedVars += id.value
              addVar(id, num.value)
            case ExistsAssumeStep(num, id, exp, _) =>
              addedVars += id.value
              addVar(id, num.value).flatMap(_.addProvedStep(p.assumeStep))
          }
          popt.flatMap(_.addProvedStep(p))
        case _ => Some(this.asInstanceOf[T])
      }
    for (step <- proofGroup.steps if pcOpt.isDefined) {
      addedSteps += step.num.value
      step match {
        case p: RegularStep => pcOpt = pcOpt.flatMap(_.check(p))
        case p: SubProof => pcOpt = pcOpt.get.check(p)
        case _: ForAllAssumeStep => assert(assertion = false, "Unexpected situation.")
      }
    }
    pcOpt.map(pc => pc.make(
      vars = pc.vars -- addedVars,
      provedSteps = pc.provedSteps -- addedSteps))
  }

  def check(step: RegularStep): Option[T] = {
    val num = step.num.value
    step match {
      case Premise(_, exp) =>
        if (premises.contains(exp) || exp == Checker.top) addProvedStep(step)
        else error(exp, s"Could not find the claimed premise in step #$num.")
      case AndIntro(_, and, lStep, rStep) =>
        (for (lExp <- findRegularStepExp(lStep, num);
              rExp <- findRegularStepExp(rStep, num)) yield {
          val expected = And(lExp, rExp)
          if (expected == step.exp) addProvedStep(step)
          else error(and, s"And-intro in step #$num with #${lStep.value} on the left and #${rStep.value} on the right does not produce the expressed form.")
        }).flatten
      case AndElim1(_, exp, andStep) =>
        findRegularStepExp(andStep, num) match {
          case Some(And(expected, _)) =>
            if (expected == exp) addProvedStep(step)
            else error(exp, s"The conjunction's left sub-expression in step #${andStep.value} does not match #$num for And-elim1.")
          case Some(_) => error(andStep, s"And-elim1 in step #$num requires a conjunction.")
          case _ => None
        }
      case AndElim2(_, exp, andStep) =>
        findRegularStepExp(andStep, num) match {
          case Some(And(_, expected)) =>
            if (expected == exp) addProvedStep(step)
            else error(exp, s"The conjunction's right sub-expression in step #${andStep.value} does not match #$num for And-elim2.")
          case Some(_) => error(andStep, s"And-elim2 in step #$num requires a conjunction.")
          case _ => None
        }
      case OrIntro1(_, or@Or(lExp, _), step2) =>
        findRegularStepExp(step2, num) match {
          case Some(expected) =>
            if (expected == lExp) addProvedStep(step)
            else error(lExp, s"The disjunction's left sub-expression in step #$num does not match #${step2.value} for Or-intro1.")
          case _ => None
        }
      case OrIntro2(_, or@Or(_, rExp), step2) =>
        findRegularStepExp(step2, num) match {
          case Some(expected) =>
            if (expected == rExp) addProvedStep(step)
            else error(rExp, s"The disjunction's right sub-expression in step #$num does not match #${step2.value} for Or-intro2.")
          case _ => None
        }
      case OrElim(_, exp, orStep, lSubProof, rSubProof) =>
        findRegularStepExp(orStep, num) match {
          case someE@Some(_: Or | _: Le | _: Ge) =>
            val r =
              for (lsp <- findSubProof(lSubProof, num);
                   rsp <- findSubProof(rSubProof, num)) yield {
                var hasError = false
                (lsp.first, rsp.first) match {
                  case (lfs: PlainAssumeStep, rfs: PlainAssumeStep) =>
                    val (lExp, rExp) =
                      (someE.x: @unchecked) match {
                        case Or(le, re) => (le, re)
                        case Le(le, re) => (Lt(le, re), Eq(le, re))
                        case Ge(le, re) => (Gt(le, re), Eq(le, re))
                      }
                    if (lfs.exp != lExp) {
                      error(lSubProof, s"Assumed expression does not match the left sub-expression of #${orStep.value} for Or-elim in step #$num.")
                      hasError = true
                    }
                    if (rfs.exp != rExp) {
                      error(lSubProof, s"Assumed expression does not match the right sub-expression of #${orStep.value} for Or-elim in step #$num.")
                      hasError = true
                    }
                    val expectedClaims =
                      orClaims(extractClaims(lsp), extractClaims(rsp))
                    if (!expectedClaims.contains(exp)) {
                      error(exp, s"Could not find the expression in step #$num in #${lSubProof.value} or #${rSubProof.value} for Or-elim.")
                      hasError = true
                    }
                  case (lfs, rfs) =>
                    if (!lfs.isInstanceOf[PlainAssumeStep])
                      error(lSubProof, s"Wrong form for Or-elim left assumption in step #$num.")
                    if (!rfs.isInstanceOf[PlainAssumeStep])
                      error(lSubProof, s"Wrong form for Or-elim right assumption in step #$num.")
                    hasError = true
                }
                if (hasError) None else addProvedStep(step)
              }
            r.flatten
          case _ => error(orStep, s"Or-elim in step #$num requires a disjunction in step # ${orStep.value}.")
        }
      case ImpliesIntro(_, Implies(antecedent, conclusion), subProof) =>
        findSubProof(subProof, num) match {
          case Some(sp) =>
            var hasError = false
            sp.first match {
              case fs: PlainAssumeStep =>
                if (fs.exp != antecedent) {
                  error(antecedent, s"The antecedent of step #$num does not match the assumption of #${subProof.value} for Implies-intro.")
                  hasError = true
                }
                val expectedClaims = extractClaims(sp)
                if (!expectedClaims.contains(conclusion)) {
                  error(antecedent, s"Could not find the consequent of step #$num in #${subProof.value} for Implies-intro.")
                  hasError = true
                }
              case fs =>
                error(sp, s"Wrong form for Implies-intro assumption in step #$num.")
                hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case _ => None
        }
      case ImpliesElim(_, exp, impliesStep, antecedentStep) =>
        (findRegularStepExp(impliesStep, num),
          findRegularStepExp(antecedentStep, num)) match {
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
            error(impliesStep, s"Implies-elim in step #$num requires an implication.")
            None
          case _ => None
        }
      case NegIntro(_, exp, subProof) =>
        findSubProof(subProof, num) match {
          case Some(sp) =>
            var hasError = false
            (sp.first, sp.last) match {
              case (fs: PlainAssumeStep, ls: RegularStep) =>
                if (fs.exp != exp.exp) {
                  error(exp.exp, s"The assumption in step #${subProof.value} does not match the non-negated expression of #$num for Negation-intro.")
                  hasError = true
                }
                val expectedClaims = extractClaims(sp)
                if (!expectedClaims.contains(Checker.bottom)) {
                  error(ls.exp, s"Could not find falsicum (⊥) in step #${subProof.value} for Negation-intro of #$num.")
                  hasError = true
                }
              case (fs, ls) =>
                if (!fs.isInstanceOf[PlainAssumeStep])
                  error(sp, s"Wrong form for Negation-intro assumption in step #$num.")
                if (!ls.isInstanceOf[RegularStep])
                  error(sp, s"Wrong form for Negation-intro conclusion in step #$num.")
                hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case _ => None
        }
      case NegElim(_, exp, step2, negStep) =>
        (findRegularStepExp(step2, num), findRegularStepExp(negStep, num)) match {
          case (Some(e1), Some(e2: Not)) =>
            var hasError = false
            if (e1 != e2.exp) {
              error(step, s"The negated expression of step #${step2.value} does not match #${negStep.value} for Negation-elim in #$num.")
              hasError = true
            }
            if (exp != Checker.bottom) {
              error(exp, s"The expression of step #$num is expected to be a falsicum (⊥) for Negation-elim.")
              hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case (_, Some(e2)) =>
            error(negStep, s"The second expression argument of step #${negStep.value} for Negation-elim in step #$num has to be negation.")
            None
          case _ => None
        }
      case BottomElim(_, exp, falseStep) =>
        findRegularStepExp(falseStep, num) match {
          case Some(e) =>
            if (e != Checker.bottom) {
              error(e, s"The expression of step #${falseStep.value} is expected to be a falsicum (⊥) for Bottom-elim of #$num.")
              None
            } else addProvedStep(step)
          case _ => None
        }
      case Pbc(_, exp, subProof) =>
        findSubProof(subProof, num) match {
          case Some(sp: SubProof) =>
            var hasError = false
            (sp.first, sp.last) match {
              case (fs: PlainAssumeStep, ls: RegularStep) =>
                if (fs.exp != Not(exp)) {
                  error(exp, s"The negated expression in step #$num does not match the assumption in #${subProof.value} for Pbc.")
                  hasError = true
                }
                val expectedClaims = extractClaims(sp)
                if (!expectedClaims.contains(Checker.bottom)) {
                  error(ls.exp, s"Could not find falsicum (⊥) in step #${subProof.value} for Pbc of #$num.")
                  hasError = true
                }
              case (fs, ls) =>
                if (!fs.isInstanceOf[PlainAssumeStep])
                  error(sp, s"Wrong form for Pbc assumption in step #$num.")
                if (ls.isInstanceOf[RegularStep])
                  error(sp, s"Wrong form for Pbc conclusion in step #$num.")
                hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case _ => None
        }
      case Subst1(_, exp, eqStep, step2) =>
        var hasError = false
        (findRegularStepExp(eqStep, num),
          findRegularStepExp(step2, num)) match {
          case (Some(Eq(exp1, exp2)), Some(e)) =>
            val expected =
              org.sireum.logika.ast.Rewriter.build[Exp]()({
                case `exp1` => exp2
              })(e)
            if (expected != exp) {
              error(exp, s"The expression in step #$num does not match the substituted expression of [left/right of ${eqStep.value}]#${step2.value} for Subst1.")
              hasError = true
            }
          case (Some(_), Some(_)) =>
            error(eqStep, s"The first expression argument of step #${eqStep.value} for Subst1 in step #$num has to be an equality.")
            hasError = true
          case _ => hasError = true
        }
        if (hasError) None else addProvedStep(step)
      case Subst2(_, exp, eqStep, step2) =>
        var hasError = false
        (findRegularStepExp(eqStep, num),
          findRegularStepExp(step2, num)) match {
          case (Some(Eq(exp1, exp2)), Some(e)) =>
            val expected =
              org.sireum.logika.ast.Rewriter.build[Exp]()({
                case `exp2` => exp1
              })(e)
            if (expected != exp) {
              error(exp, s"The expression in step #$num does not match the substituted expression of [right/left of #${eqStep.value}]#${step2.value} for Subst2.")
              hasError = true
            }
          case (Some(_), Some(_)) =>
            error(eqStep, s"The first expression argument of step #${eqStep.value} for Subst2 in step #$num has to be an equality.")
            hasError = true
          case _ => hasError = true
        }
        if (hasError) None else addProvedStep(step)
      case Algebra(_, exp, steps) =>
        if (deduce(num, exp, steps, isAuto = false))
          addProvedStep(step)
        else None
      case ForAllIntro(_, q, subProof) =>
        findSubProof(subProof, num) match {
          case Some(sp) =>
            var hasError = true
            sp.first match {
              case fs: ForAllAssumeStep =>
                val freshVarId = fs.id
                val freshVar = freshVarId.value
                for (step <- sp.steps.reverse if hasError) step match {
                  case step: RegularStep if Checker.collectVars(step.exp).contains(freshVar) =>
                    val expected = subst(q.simplify.exp, Map(q.ids.head -> freshVarId))
                    if (expected == step.exp) hasError = false
                  case _ =>
                }
                if (hasError) {
                  error(step, s"Could not find a suitable expression in #${subProof.value} for Forall-intro.")
                }
              case fs =>
                error(sp, s"Wrong form for the start of Forall-intro in step #$num that is expected to have only a fresh variable.")
            }
            if (hasError) None else addProvedStep(step)
          case _ => None
        }
      case ForAllElim(_, exp, step2, args) =>
        findRegularStepExp(step2, num) match {
          case Some(q: ForAll) =>
            buildSubstMap(q.simplify, args) match {
              case Some((m, e)) =>
                val expected = subst(e, m)
                if (exp != expected) {
                  error(exp, s"Supplying the specified arguments to the quantification in step #${step2.value} does not produce matching expression in #$num for Forall-elim.")
                  None
                } else addProvedStep(step)
              case _ => error(step, s"The numbers of quantified variables and arguments do not match in Forall-elim of step #$num.")
            }
          case Some(_) => error(step2, s"Forall-elim in step #$num requires a universal quantification in #${step2.value}.")
          case _ => None
        }
      case ExistsIntro(_, q, step2, args) =>
        findRegularStepExp(step2, num) match {
          case Some(result) =>
            buildSubstMap(q.simplify, args) match {
              case Some((m, e)) =>
                val expected = subst(e, m)
                if (result != expected) {
                  error(q, s"Supplying the specified arguments to the quantification in step #$num does not produce matching expression in #${step2.value} for Exists-intro.")
                  None
                } else addProvedStep(step)
              case _ => error(step, s"The numbers of quantified variables and arguments do not match in Exists-intro of step #$num.")
            }
          case _ => None
        }
      case ExistsElim(_, exp, step2, subProof) =>
        findRegularStepExp(step2, num) match {
          case Some(q: Exists) =>
            findSubProof(subProof, num) match {
              case Some(sp) =>
                var hasError = false
                sp.first match {
                  case fs: ExistsAssumeStep =>
                    val freshVar = fs.id.value
                    val expected = subst(q.simplify.exp, Map(q.ids.head -> Id(freshVar)))
                    if (expected != fs.exp) {
                      error(exp, s"Supplying $freshVar for ${q.ids.head} in step #${step2.value} does not produce matching expression in the assumption of #${subProof.value} for Exists-elim.")
                      hasError = true
                    }
                    val expectedClaims = extractClaims(sp)
                    if (!expectedClaims.contains(exp)) {
                      error(exp, s"Could not find the expression in step #$num in #${subProof.value} for Exists-elim.")
                      hasError = true
                    }
                    if (Checker.collectVars(exp).contains(freshVar)) {
                      error(exp, s"The expression in step #$num should not contain $freshVar for Exists-elim.")
                      hasError = true
                    }
                  case fs =>
                    error(sp, s"Wrong form for Exists-elim assumption in step #$num that is expected to have a fresh variable and a formula.")
                    hasError = true
                }
                if (hasError) None else addProvedStep(step)
              case _ => None
            }
          case Some(_) => error(step2, s"Exists-elim in step #$num requires an existensial quantification in #${step2.value}.")
          case _ => None
        }
      case Auto(_, exp, steps) =>
        if (!autoEnabled)
          error(step, s"Auto is not enabled, but used in step #$num.")
        if (deduce(num, exp, steps, isAuto = true)) addProvedStep(step)
        else None
      case FactJust(_, exp, id) =>
        facts.get(id.value) match {
          case Some(expected) =>
            if (expected == exp) addProvedStep(step)
            else error(exp, s"The expression in step #$num does not match the one in fact ${id.value}.")
          case _ => error(id, s"Could not find a fact ${id.value}.")
        }
      case Invariant(_, exp) =>
        if (invariants.contains(exp)) addProvedStep(step)
        else error(exp, s"Could not find the invariant in step #$num.")
      case _: ExistsAssumeStep | _: PlainAssumeStep =>
        assert(assertion = false, "Unexpected situation.")
        None
    }
  }

  def deduce(num: Int, exp: Exp, steps: Node.Seq[Num],
             isAuto: Boolean): Boolean = {
    val antecedents =
      if (steps.nonEmpty) {
        var as = Node.emptySeq[Exp]
        var hasError = false
        for (numOrId <- steps)
          findRegularStepExp(numOrId, num) match {
            case Some(e) =>
              if (!isAuto) {
                if (checkAlgebraExp(e)) as :+= e
                else {
                  error(numOrId, s"Could not apply algebra on formula with any logical connective other than negation.")
                  hasError = true
                }
              } else as :+= e
            case _ => hasError = true
          }
        if (hasError) return false else as
      } else if (isAuto) premises ++ facts.values
      else Node.emptySeq[Exp]
    val method = if (isAuto) "automatically" else "apply algebra to"
    if (isValid(antecedents, ivector(exp))) true
    else {
      error(exp, s"Could not $method deduce the claim in step#$num.")
      false
    }
  }

  def checkAlgebraExp(e: Exp): Boolean = {
    var hasError = false
    Visitor.build({
      case e: And =>
        hasError = true
        error(e, "Algebra justification cannot be used for conjunction.")
        true
      case e: Or =>
        hasError = true
        error(e, "Algebra justification cannot be used for disjunction.")
        true
      case e: Implies =>
        hasError = true
        error(e, "Algebra justification cannot be used for implication.")
        true
      case q: Quant[_] =>
        hasError = true
        error(e, "Algebra justification cannot be used for quantification.")
        true
    })(e)
    !hasError
  }

  def expRewriter(m: IMap[Node, Node]): Exp => Exp =
    org.sireum.logika.ast.Rewriter.build[Exp](TraversalMode.BOTTOM_UP) {
      case n: Node => m.getOrElse(n, n)
    }

  def subst(e: Exp, m: IMap[Node, Node]): Exp = expRewriter(m)(e)

  def buildSubstMap(q: Quant[_], args: Node.Seq[Exp]): Option[(IMap[Node, Node], Exp)] = {
    val r = imapEmpty[Node, Node] ++ q.ids.zip(args)
    if (r.isEmpty) None
    else if (r.size < q.ids.size) {
      q match {
        case q: ForAll =>
          Some((r, ForAll(q.ids.slice(r.size, q.ids.size), q.domainOpt, q.exp)))
        case q: Exists =>
          Some((r, Exists(q.ids.slice(r.size, q.ids.size), q.domainOpt, q.exp)))
      }
    } else if (r.size < args.size) {
      q.exp match {
        case q2: Quant[_] =>
          buildSubstMap(q2, args.slice(r.size, args.size)) match {
            case Some((m, e)) => Some((r ++ m, e))
            case _ => None
          }
        case _ => None
      }
    } else Some((r, q.exp))
  }

  def addProvedStep(step: ProofStep): Option[T] = {
    val num = step.num.value
    declaredStepNumbers.get(num) match {
      case Some(li) =>
        error(step, s"Step #$num has already been used in at line ${li.lineBegin}, column ${li.columnBegin}.")
        None
      case _ =>
        Some(make(provedSteps = provedSteps + (num -> step),
          declaredStepNumbers = declaredStepNumbers + (num -> nodeLocMap(step))))
    }
  }

  def addVar(id: Id, stepNum: Int): Option[T] = {
    val varId = id.value
    if (vars.contains(varId)) {
      error(id, s"The variable $varId in step #$stepNum, is not fresh.")
      None
    } else Some(make(vars = vars + varId))
  }

  def isValid(premises: Iterable[Exp], conclusions: Iterable[Exp]): Boolean =
    Z3.isValid(timeoutInMs, premises.toVector, conclusions.toVector)

  def newId(x: String, t: tipe.Tipe) = {
    val r = Id(x)
    r.tipe = t
    r
  }

  def findSubProof(num: Num, stepNum: Int): Option[SubProof] = {
    provedSteps.get(num.value) match {
      case Some(r: SubProof) => Some(r)
      case Some(_) =>
        error(num, s"#${num.value} should be a sub-proof.")
        None
      case _ =>
        if (declaredStepNumbers.contains(num.value))
          error(num, s"Step #${num.value} is out of scope from #$stepNum.")
        else
          error(num, s"Could not find the referenced sub-proof #${num.value} in #$stepNum.")
        None
    }
  }

  def findRegularStepExp(num: Num, stepNum: Int): Option[Exp] =
    provedSteps.get(num.value) match {
      case Some(r: RegularStep) => Some(r.exp)
      case _ =>
        if (declaredStepNumbers.contains(num.value))
          error(num, s"Step #${num.value} is out of scope from #$stepNum.")
        else
          error(num, s"Could not find the referenced step #${num.value} in #$stepNum.")
        None
    }

  def orClaims(es1: Iterable[Exp], es2: Iterable[Exp]): ILinkedSet[Exp] = {
    var r = ilinkedSetEmpty[Exp]
    for (e1 <- es1; e2 <- es2) {
      if (e1 == e2)
        r += e1
      r += Or(e1, e2)
    }
    r
  }

  def extractClaims(pg: ProofGroup,
                    reverse: Boolean = true): ILinkedSet[Exp] = {
    var steps = pg.allSteps
    if (reverse) steps = steps.reverse
    ilinkedSetEmpty ++ steps.flatMap(_ match {
      case step: RegularStep => Some(step.exp)
      case _ => None
    })
  }

  def checkRuntimeError(stmt: Stmt): Boolean = {
    var hasError = false
    def divisor(e: Exp): Boolean = {
      val req = Ne(e, Checker.zero)
      if (autoEnabled) {
        if (!isValid(premises ++ facts.values, ivector(req))) {
          error(e, s"Could not automatically deduce that the divisor is non-zero.")
          hasError = true
        }
      } else if (!premises.contains(req)) {
        error(e, s"Divisor has to be proven to be non-zero.")
        hasError = true
      }
      true
    }
    def index(id: Id, e: Exp): Boolean = {
      val req1 = Le(Checker.zero, e)
      val req2 = Lt(e, Size(id))
      if (autoEnabled) {
        val ps = premises ++ facts.values
        if (!isValid(ps, ivector(req1))) {
          hasError = true
          error(e, "Could not automatically deduce that the sequence index is non-negative.")
        }
        if (!isValid(ps, ivector(req2))) {
          hasError = true
          error(e, s"Could not automatically deduce that the index is less than the sequence size.")
        }
      } else {
        if (!premises.contains(req1)) {
          hasError = true
          error(e, "The sequence index has to be proven non-negative.")
        }
        if (!premises.contains(req2)) {
          hasError = true
          error(e, s"The sequence index has to be proven less than the sequence size.")
        }
      }
      true
    }
    Visitor.build({
      case _: Block => false
      case _: LoopInv => false
      case Div(_, e2) => divisor(e2)
      case Rem(_, e2) => divisor(e2)
      case a@Apply(id, Seq(e)) if id.tipe == tipe.ZS => index(id, e)
      case SeqAssign(id, e, _) => index(id, e)
    })(stmt)
    hasError
  }

  def generateHint(beforePremises: ILinkedSet[Exp],
                   stmt: Stmt,
                   afterPremises: ILinkedSet[Exp]): Unit = {
    if (hintEnabled && (beforePremises.nonEmpty || afterPremises.nonEmpty) &&
      !stmt.isInstanceOf[MethodDecl]) {
      val input = unitNode.input
      val li = nodeLocMap(stmt)
      var startOffset = input.lastIndexOf('\n', li.offset) + 1
      if (startOffset < 1) startOffset = 0
      var endOffset = input.indexOf('\n', li.offset + li.length)
      if (endOffset < 0) endOffset = input.length
      val sb = new StringBuilder
      def indent(): Unit = {
        for (i <- 0 until li.columnBegin) {
          sb.append(' ')
        }
      }
      indent()
      sb.append("{\n")
      for (e <- beforePremises) {
        indent()
        sb.append("  ")
        sb.append(Exp.toString(e, inProof = true))
        sb.append('\n')
      }
      indent()
      sb.append("}\n")
      sb.append(input.substring(startOffset, endOffset).
        replaceAll("\r", ""))
      sb.append('\n')
      indent()
      sb.append("{\n")
      for (e <- afterPremises) {
        indent()
        sb.append("  ")
        sb.append(Exp.toString(e, inProof = true))
        sb.append('\n')
      }
      indent()
      sb.append("}")
      reporter.report(li.toLocationInfo(fileUriOpt, "hint", sb.toString))
    }
  }

  def error(n: Node, msg: String): Option[T] = {
    reporter.report(nodeLocMap(n).toLocationError(fileUriOpt, Checker.kind, msg))
    None
  }

  def warn(n: Node, msg: String): Unit =
    reporter.report(nodeLocMap(n).toLocationWarning(fileUriOpt, Checker.kind, msg))
}

private final case class
DefaultProofContext(unitNode: UnitNode,
                    autoEnabled: Boolean,
                    timeoutInMs: Int,
                    checkSat: Boolean,
                    hintEnabled: Boolean,
                    invariants: ILinkedSet[Exp] = ilinkedSetEmpty,
                    premises: ILinkedSet[Exp] = ilinkedSetEmpty,
                    vars: ISet[String] = isetEmpty,
                    facts: IMap[String, Exp] = imapEmpty,
                    provedSteps: IMap[Natural, ProofStep] = imapEmpty,
                    declaredStepNumbers: IMap[Natural, LocationInfo] = imapEmpty)
                   (implicit reporter: AccumulatingTagReporter) extends ProofContext[DefaultProofContext] {

  def check(program: Program): Boolean = {
    val facts = this.facts ++ program.block.stmts.flatMap(_ match {
      case FactStmt(fs) => fs.factOrFunDecls.flatMap(_ match {
        case f: Fact => Some(f.id.value -> f.exp)
        case _ => None
      })
      case _ => ivectorEmpty
    })
    if (facts.nonEmpty && !checkSat(facts.values,
      unsatMsg = "The specified set of facts are unsatisfiable.",
      unknownMsg = "The set of facts might not be satisfiable.",
      timeoutMsg = "Could not check satisfiability of the set of facts due to timeout."
    )) return false
    copy(facts = facts).check(program.block).isDefined
  }

  def check(block: Block): Option[DefaultProofContext] = {
    var pcOpt: Option[DefaultProofContext] = Some(this)
    for (stmt <- block.stmts if pcOpt.isDefined) {
      val pc =
        if (stmt.isInstanceOf[ProofStmt]) pcOpt.get
        else pcOpt.get.cleanup
      pcOpt = pc.check(stmt)
    }
    pcOpt
  }

  def check(stmt: Stmt): Option[DefaultProofContext] = {
    var hasError = false
    if (!stmt.isInstanceOf[ProofElementStmt] &&
      !stmt.isInstanceOf[MethodDecl]) {
      hasError = checkRuntimeError(stmt) || hasError
    }
    val pcOpt = stmt match {
      case ProofStmt(proof) =>
        check(proof) match {
          case Some(pc2) =>
            Some(pc2.copy(
              premises = filter(
                (if (autoEnabled) premises else ilinkedSetEmpty) ++
                  extractClaims(proof, reverse = false)),
              provedSteps = imapEmpty))
          case _ => None
        }
      case SequentStmt(sequent) =>
        if (!autoEnabled) {
          hasError = true
          error(stmt, s"Auto is not enabled, but sequent is used.")
        }
        if (sequent.premises.nonEmpty) {
          if (!isValid(premises, sequent.premises)) {
            hasError = true
            error(stmt, "Could not automatically deduce the specified sequent's premises.")
          }
          if (!isValid(sequent.premises, sequent.conclusions)) {
            hasError = true
            error(stmt, "Could not automatically deduce the specified sequent's conclusions from its premises.")
          }
        } else if (!isValid(premises, sequent.conclusions)) {
          hasError = true
          error(stmt, "Could not automatically deduce the specified sequent's conclusions.")
        }
        Some(copy(premises =
          filter(ilinkedSetEmpty ++ sequent.premises ++ sequent.conclusions)))
      case Assert(e) =>
        if (autoEnabled) {
          if (!isValid(premises ++ facts.values, ivector(e))) {
            error(stmt, s"Could not automatically deduce the assertion validity.")
            hasError = true
            checkSat(ivector(e),
              unsatMsg = s"The assertion is unsatisfiable.",
              unknownMsg = s"The assertion might not be satisfiable.",
              timeoutMsg = s"Could not check satisfiability of the assertion due to timeout.")
          }
        } else {
          if (!premises.contains(e)) {
            error(e, s"The assertion has not been proven.")
            hasError = true
            checkSat(ivector(e),
              unsatMsg = s"The assertion is unsatisfiable.",
              unknownMsg = s"The assertion might not be satisfiable.",
              timeoutMsg = s"Could not check satisfiability of the assertion due to timeout.")
          }
        }
        Some(copy(premises = premises + e))
      case Assume(e) =>
        hasError = !checkSat(ivector(e),
          unsatMsg = s"The assumption is unsatisfiable.",
          unknownMsg = s"The assumption might not be satisfiable.",
          timeoutMsg = s"Could not check satisfiability of the assumption due to timeout."
        ) || hasError
        Some(copy(premises = premises + e))
      case SeqAssign(id, index, exp) =>
        val old = newId(id.value + "_old", id.tipe)
        val m = imapEmpty[Node, Node] + (id -> old)
        val qVar = newId("q_i", tipe.Z)
        Some(copy(premises =
          premises.map(e => subst(e, m)) ++
            ivector(
              Eq(Size(id), Size(old)),
              Eq(Apply(id, Node.seq(subst(index, m))), subst(exp, m)),
              ForAll(
                Node.seq(qVar),
                Some(RangeDomain(Checker.zero, Size(id),
                  loLt = false, hiLt = true)),
                Implies(
                  Ne(qVar, index),
                  Eq(Apply(id, Node.seq(qVar)), Apply(old, Node.seq(qVar)))
                )
              )
            )))
      case ExpStmt(exp) =>
        val (he, pc2) = invoke(exp, None)
        hasError ||= he
        Some(pc2)
      case a: VarAssign =>
        val id = a.id
        val exp = a.exp
        exp match {
          case _: ReadInt => assign(id)
          case _: RandomInt => assign(id)
          case exp: Clone => assign(id, exp.id)
          case exp: Apply if exp.id.tipe != tipe.ZS =>
            val (he, pc2) = invoke(exp, Some(id))
            hasError ||= he
            Some(pc2)
          case _ => assign(id, exp)
        }
      case If(exp, thenBlock, elseBlock) =>
        val thenPcOpt = copy(premises = premises + exp).check(thenBlock)
        val elsePcOpt = copy(premises = premises + Not(exp)).check(elseBlock)
        (thenPcOpt, elsePcOpt) match {
          case (Some(thenPc), Some(elsePc)) =>
            Some(copy(premises =
              orClaims(thenPc.cleanup.premises, elsePc.cleanup.premises)))
          case _ => None
        }
      case stmt: MethodDecl =>
        val invs = if (stmt.isHelper) ilinkedSetEmpty else invariants
        val effectivePre = invs ++ stmt.contract.requires.exps
        val effectivePost = invs ++ stmt.contract.ensures.exps
        hasError =
          !checkSat(effectivePre,
            unsatMsg = s"The effective pre-condition of method ${
              stmt.id.value
            } is unsatisfiable.",
            unknownMsg = s"The effective pre-condition of method ${
              stmt.id.value
            } might not be satisfiable.",
            timeoutMsg = s"Could not check satisfiability of the effective pre-condition of method ${
              stmt.id.value
            } due to timeout."
          ) || hasError
        hasError =
          !checkSat(effectivePost,
            unsatMsg = s"The effective post-condition of method ${
              stmt.id.value
            } is unsatisfiable.",
            unknownMsg = s"The effective post-condition of method ${
              stmt.id.value
            } might not be satisfiable.",
            timeoutMsg = s"Could not check satisfiability of the effective post-condition of method ${
              stmt.id.value
            } due to timeout."
          ) || hasError
        val modifiedIds = stmt.contract.modifies.ids.toSet
        val mods = modifiedIds.map(id =>
          Eq(id, newId(id.value + "_in", id.tipe)))
        copy(premises = ilinkedSetEmpty ++ effectivePre ++ mods).
          check(stmt.block) match {
          case Some(pc2) =>
            var modifiedInvariants = ilinkedSetEmpty[Exp]
            for (e <- invs) {
              var modified = false
              Visitor.build({
                case id: Id =>
                  if (modifiedIds.contains(id)) {
                    modified = true
                  }
                  false
              })(e)
              if (modified) modifiedInvariants += e
            }
            if (autoEnabled) {
              val ps = pc2.premises ++ pc2.facts.values
              for (e <- modifiedInvariants)
                if (!isValid(ps, ivector(e))) {
                  error(e, s"Could not automatically deduce the global invariant at the end of method ${stmt.id.value}.")
                  hasError = true
                }
            } else {
              for (e <- modifiedInvariants)
                if (!pc2.premises.contains(e)) {
                  error(e, s"The global invariant has not been proven at the end of method ${stmt.id.value}.")
                  hasError = true
                }
            }
            val post = stmt.contract.ensures.exps
            val postPremises = stmt.returnExpOpt match {
              case Some(e) =>
                val m = imapEmpty[Node, Node] + (e -> Result())
                pc2.premises.map(e => subst(e, m))
              case _ => pc2.premises
            }
            if (autoEnabled) {
              val ps = postPremises ++ pc2.facts.values
              for (e <- post)
                if (!isValid(ps, ivector(e))) {
                  error(e, s"Could not automatically deduce the post-condition of method ${stmt.id.value}.")
                  hasError = true
                }
            } else {
              for (e <- post)
                if (!postPremises.contains(e)) {
                  error(e, s"The post-condition of method ${stmt.id.value} has not been proven.")
                  hasError = true
                }
            }
          case _ => hasError = true
        }
        Some(this.cleanup)
      case InvStmt(inv) =>
        if (autoEnabled) {
          val ps = premises ++ facts.values
          for (e <- inv.exps)
            if (!isValid(ps, ivector(e))) {
              error(e, s"Could not automatically deduce the global invariant.")
              hasError = true
            }
          if (hasError)
            checkSat(inv.exps,
              unsatMsg = s"The global invariant(s) are unsatisfiable.",
              unknownMsg = s"The global invariant(s) might not be satisfiable.",
              timeoutMsg = s"Could not check satisfiability of the global invariant(s) due to timeout.")
        } else {
          for (e <- inv.exps)
            if (!premises.contains(e)) {
              error(e, s"The global invariant has not been proven.")
              hasError = true
            }
          if (hasError)
            checkSat(inv.exps,
              unsatMsg = s"The global invariant(s) are unsatisfiable.",
              unknownMsg = s"The global invariant(s) might not be satisfiable.",
              timeoutMsg = s"Could not check satisfiability of the global invariant(s) due to timeout.")
        }
        Some(copy(invariants = invariants ++ inv.exps))
      case _: FactStmt => Some(this)
      case While(exp, loopBlock, loopInv) =>
        val es = loopInv.invariant.exps
        if (autoEnabled) {
          val ps = premises ++ facts.values
          for (e <- es)
            if (!isValid(ps, ivector(e))) {
              error(e, s"Could not automatically deduce the loop invariant at the beginning of the loop.")
              hasError = true
            }
        } else {
          for (e <- es)
            if (!premises.contains(e)) {
              error(e, s"The loop invariant has not been proved at the beginning of the loop.")
              hasError = true
            }
        }
        var ps = ilinkedSetEmpty ++ es
        if (autoEnabled) {
          val modifiedIds = loopInv.modifies.ids.toSet
          for (premise <- premises) {
            var propagate = true
            Visitor.build({
              case id: Id =>
                if (modifiedIds.contains(id)) propagate = false
                false
            })(premise)
            if (propagate) ps += premise
          }
        }
        copy(premises = ps + exp).
          check(loopBlock) match {
          case Some(pc2) =>
            if (autoEnabled) {
              val ps = pc2.premises ++ pc2.facts.values
              for (e <- es)
                if (!isValid(ps, ivector(e))) {
                  error(e, s"Could not deduce the loop invariant at the end of the loop.")
                  hasError = true
                }
            } else {
              for (e <- es)
                if (!pc2.premises.contains(e)) {
                  error(e, s"The loop invariant has not been proved at the end of the loop.")
                  hasError = true
                }
            }
            Some(copy(premises = ps + Not(exp)))
          case _ => None
        }
      case _: Print => Some(this)
    }
    generateHint(premises, stmt,
      pcOpt.map(_.premises).getOrElse(ilinkedSetEmpty))
    if (hasError) None else pcOpt
  }

  def assign(id: Id, exp: Exp): Option[DefaultProofContext] = {
    val sst = expRewriter(Map[Node, Node](id -> newId(id.value + "_old", id.tipe)))
    Some(copy(premises = premises.map(sst) + Eq(id, sst(exp))))
  }

  def assign(id: Id): Option[DefaultProofContext] = {
    val sst = expRewriter(Map[Node, Node](id -> newId(id.value + "_old", id.tipe)))
    Some(copy(premises = premises.map(sst)))
  }

  def invoke(a: Apply, lhsOpt: Option[Id]): (Boolean, DefaultProofContext) = {
    var hasError = false
    val md = a.declOpt.get
    var postSubstMap = md.params.map(_.id).zip(a.args).toMap[Node, Node]
    val pres = md.contract.requires.exps.map(e => subst(e, postSubstMap))
    val isHelper = md.isHelper
    var invs = ivectorEmpty[Exp]
    val modIds = md.contract.modifies.ids.map(_.value).toSet
    for (inv <- invariants if !isHelper) {
      var mod = false
      Visitor.build({
        case id: Id =>
          if (modIds.contains(id.value))
            mod = true
          false
      })(inv)
      if (mod) invs :+= inv
    }
    if (autoEnabled) {
      val ps = premises ++ facts.values
      for (inv <- invs)
        if (!isValid(ps, ivector(inv))) {
          val li = nodeLocMap(inv)
          error(a, s"Could not automatically deduce the invariant of method ${md.id.value} defined at [${li.lineBegin}, ${li.columnBegin}].")
          hasError = true
        }
      for (pre <- pres)
        if (!isValid(ps, ivector(pre))) {
          val li = nodeLocMap(pre)
          error(a, s"Could not automatically deduce the pre-condition of method ${md.id.value} defined at [${li.lineBegin}, ${li.columnBegin}].")
          hasError = true
        }
    } else {
      for (inv <- invs)
        if (!premises.contains(inv)) {
          val li = nodeLocMap(inv)
          error(a, s"The invariant defined at [${li.lineBegin}, ${li.columnBegin}] has not been proven.")
          hasError = true
        }
      for (pre <- pres)
        if (!premises.contains(pre)) {
          val li = nodeLocMap(pre)
          error(a, s"The pre-condition of method ${md.id.value} defined at [${li.lineBegin}, ${li.columnBegin}] has not been proven.")
          hasError = true
        }
    }
    val (lhs, psm) = lhsOpt match {
      case Some(x) =>
        (x, imapEmpty[Node, Node] + (x -> newId(x.value + "_old", x.tipe)))
      case _ =>
        (newId(md.id.value + "_result",
          md.id.tipe.asInstanceOf[tipe.Fn].result),
          imapEmpty[Node, Node])
    }
    var premiseSubstMap = psm
    postSubstMap += Result() -> lhs
    var modParams = isetEmpty[String]
    for ((pid@Id(p), arg@Id(x)) <- md.params.map(_.id).zip(a.args) if modIds.contains(p)) {
      modParams += p
      premiseSubstMap += newId(x, arg.tipe) -> newId(x + "_old", arg.tipe)
      premiseSubstMap += newId(p, pid.tipe) -> newId(x, arg.tipe)
      postSubstMap += newId(x, arg.tipe) -> newId(x + "_old", arg.tipe)
      postSubstMap += newId(p, pid.tipe) -> newId(x, arg.tipe)
      postSubstMap += newId(p + "_in", pid.tipe) -> newId(x + "_old", arg.tipe)
    }
    for (id@Id(g) <- md.contract.modifies.ids if !modParams.contains(g)) {
      premiseSubstMap += newId(g, id.tipe) -> newId(g + "_old", id.tipe)
      postSubstMap += newId(g + "_in", id.tipe) -> newId(g + "_old", id.tipe)
    }
    (hasError, make(premises =
      premises.map(e => subst(e, premiseSubstMap)) ++ invs ++
        md.contract.ensures.exps.map(e => subst(e, postSubstMap))
    ))
  }

  def cleanup: DefaultProofContext =
    copy(premises = filter(premises), provedSteps = imapEmpty,
      declaredStepNumbers = imapEmpty)

  def filter(premises: ILinkedSet[Exp]): ILinkedSet[Exp] = {
    def keep(e: Exp) = {
      var r = true
      Visitor.build({
        case Id(value) =>
          if (value.endsWith("_old") ||
            value.endsWith("_result") || value == "q_i")
            r = false
          false
      })(e)
      r
    }
    premises.filter(keep)
  }

  def make(vars: ISet[String],
           provedSteps: IMap[Natural, ProofStep],
           declaredStepNumbers: IMap[Natural, LocationInfo],
           premises: ILinkedSet[Exp]): DefaultProofContext =
    copy(vars = vars, provedSteps = provedSteps,
      declaredStepNumbers = declaredStepNumbers, premises = premises)
}
