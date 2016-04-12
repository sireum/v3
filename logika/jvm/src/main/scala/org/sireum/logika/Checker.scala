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
import org.sireum.logika.message.CheckerKind
import org.sireum.logika.tipe.TypeChecker
import org.sireum.logika.util._
import org.sireum.util.Rewriter.TraversalMode
import org.sireum.util._

object Checker {
  private[logika] final val top = BooleanLit(true)
  private[logika] final val bottom = BooleanLit(false)
  private[logika] final val zero = IntLit("0", 0, None)
  private[logika] final val kind = "Proof Checker"

  final def check(m: message.Check)(
    implicit reporter: AccumulatingTagReporter): message.Result = {
    val autoEnabled = m.autoEnabled || m.kind == message.CheckerKind.SummarizingSymExe
    var unitNodes = ivectorEmpty[UnitNode]
    for (message.ProofFile(fileUriOpt, text) <- m.proofs) {
      Builder(fileUriOpt, text, m.bitWidth, autoEnabled).foreach(unitNodes :+= _)
    }
    if (reporter.hasError) {
      reporter.report(ErrorMessage("AST",
        if (m.proofs.size > 1) "The inputs are ill-formed."
        else "The input is ill-formed."))
      return message.Result(m.requestId, m.isBackground, reporter.tags.toVector)
    }
    if (unitNodes.forall(_.isInstanceOf[Program])) {
      val programs = unitNodes.map(_.asInstanceOf[Program])
      if (TypeChecker.check(programs: _*)) {
        var hasError = false
        for (program <- programs)
          try Visitor.build({
            case t: IntegralType if !t.isInstanceOf[ZType] && m.kind != CheckerKind.SummarizingSymExe =>
              val ts = {
                val sb = new StringBuilder
                t.buildString(sb)
                sb.toString
              }
              error(program.fileUriOpt, program.nodeLocMap(t), s"Type $ts can only be used in symbolic execution.")
              throw new RuntimeException
            case t: SeqType if !t.isInstanceOf[ZSType] && m.kind != CheckerKind.SummarizingSymExe =>
              val ts = {
                val sb = new StringBuilder
                t.buildString(sb)
                sb.toString
              }
              error(program.fileUriOpt, program.nodeLocMap(t), s"Type $ts can only be used in symbolic execution.")
              throw new RuntimeException
          })(program) catch {
            case t: RuntimeException => hasError = true
          }

        if (!hasError) {
          if (m.lastOnly)
            check(programs.last, m.kind, autoEnabled, m.timeout, m.checkSatEnabled,
              m.hintEnabled, m.inscribeSummoningsEnabled, m.coneInfluenceEnabled, m.bitWidth)
          else
            for (program <- programs)
              check(program, m.kind, autoEnabled, m.timeout, m.checkSatEnabled,
                m.hintEnabled, m.inscribeSummoningsEnabled, m.coneInfluenceEnabled, m.bitWidth)
        }
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
        check(sequent, m.kind, autoEnabled = false, m.timeout, m.checkSatEnabled, m.hintEnabled)
    } else {
      reporter.report(ErrorMessage("AST", "Cannot check mixed programs and sequents."))
    }
    message.Result(m.requestId, m.isBackground, reporter.tags.toVector)
  }

  final def check(unitNode: UnitNode, checkerKind: message.CheckerKind.Value,
                  autoEnabled: Boolean = false,
                  timeoutInMs: Int = 2000, checkSat: Boolean = false,
                  hintEnabled: Boolean = false,
                  inscribeSummoningsEnabled: Boolean = false,
                  coneInfluenceEnabled: Boolean = false,
                  bitWidth: Int = 0)(
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
          var r = new SequentProofContext(s, autoEnabled, timeoutInMs,
            checkSat, hintEnabled, inscribeSummoningsEnabled,
            premises = ilinkedSetEmpty ++ s.premises).
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
        case _: SequentStmt => hasProof = true; false
        case _: ProofStmt => hasProof = true; false
        case _: Assert => hasProof = true; false
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
      val r = checkerKind match {
        case message.CheckerKind.Forward =>
          ForwardProofContext(program, autoEnabled, timeoutInMs,
            checkSat, hintEnabled, inscribeSummoningsEnabled, coneInfluenceEnabled).check
        case message.CheckerKind.Backward =>
          BackwardProofContext(program, autoEnabled, timeoutInMs,
            checkSat, hintEnabled, inscribeSummoningsEnabled, coneInfluenceEnabled).check
        case message.CheckerKind.SummarizingSymExe =>
          SummarizingSymExeProofContext(program, autoEnabled, timeoutInMs,
            checkSat, hintEnabled, inscribeSummoningsEnabled, coneInfluenceEnabled, bitWidth).check
        case message.CheckerKind.UnrollingSymExe =>
          UnrollingSymExeProofContext(program, autoEnabled, timeoutInMs,
            checkSat, hintEnabled, inscribeSummoningsEnabled, coneInfluenceEnabled, bitWidth).check
      }
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

  def inscribeSummoningsEnabled: Boolean

  def coneInfluenceEnabled: Boolean

  def isSymExe: Boolean

  def make(vars: ISet[String] = vars,
           provedSteps: IMap[Natural, ProofStep] = provedSteps,
           declaredStepNumbers: IMap[Natural, LocationInfo] = declaredStepNumbers,
           premises: ILinkedSet[Exp] = premises): T

  def checkSat(title: String, li: LocationInfo, exps: Iterable[Exp],
               unsatMsg: => String, unknownMsg: => String,
               timeoutMsg: => String): Boolean = {
    val es = exps.toVector
    if (checkSat) {
      val (script, r) = Z3.checkSat(satTimeoutInMs, isSymExe, es: _*)
      if (inscribeSummoningsEnabled) {
        val lineSep = scala.util.Properties.lineSeparator
        val sb = new StringBuilder
        if ("" == title) sb.append("; Satisfiability: ")
        else sb.append(s"; Satisfiability of $title: ")
        sb.append(r)
        sb.append(lineSep)
        for (e <- es) {
          sb.append(";   ")
          sb.append(Exp.toString(e, inProof = true))
          sb.append(lineSep)
        }
        sb.append(lineSep)
        sb.append(script)
        reporter.report(li.toLocationInfo(fileUriOpt, "summoning", sb.toString))
      }
      r match {
        case Z3.Sat =>
          true
        case Z3.Unsat =>
          error(li, unsatMsg); false
        case Z3.Unknown =>
          reporter.report(li.toLocationWarning(fileUriOpt, "checksat", unknownMsg))
          true
        case Z3.Timeout =>
          reporter.report(li.toLocationWarning(fileUriOpt, "checksat", timeoutMsg))
          true
        case Z3.Error =>
          false
      }
    } else true
  }

  def coneOfInfluence(premises: Iterable[Exp],
                      conclusions: Iterable[Exp]): IVector[Exp] = {
    def collectIds(e: Exp): Set[String] = {
      var ids = isetEmpty[String]
      Visitor.build({
        case Id(value) => ids += value
          false
      })(e)
      ids
    }
    var relevantIds = conclusions.toVector.flatMap(collectIds)
    if (relevantIds.isEmpty) return Node.emptySeq
    val m = midmapEmpty[Exp, (Set[String], Int)]
    var i = 0
    for (e <- premises) {
      m(e) = (collectIds(e), i)
      i += 1
    }
    var changed = true
    var relevantPremises = ivectorEmpty[Exp]
    var temp = premises
    while (changed) {
      val (rps, t) = temp.partition(e => {
        val eIds = m(e)._1
        eIds.exists(relevantIds.contains)
      })
      temp = t
      relevantPremises ++= rps
      relevantIds ++= rps.flatMap(e => m(e)._1)
      changed = rps.nonEmpty
    }
    relevantPremises.sortWith((e1, e2) => m(e1)._2 > m(e2)._2)
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
        unitNode.mode match {
          case LogicMode.Propositional | LogicMode.Predicate =>
            error(step, s"Algebra cannot be used in ${unitNode.mode} Logic.")
            None
          case LogicMode.Programming =>
            if (deduce(num, exp, steps, isAuto = false))
              addProvedStep(step)
            else None
        }
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
        unitNode.mode match {
          case LogicMode.Propositional | LogicMode.Predicate =>
            error(step, s"Auto cannot be used in ${unitNode.mode} Logic.")
            None
          case LogicMode.Programming =>
            if (deduce(num, exp, steps, isAuto = true)) addProvedStep(step)
            else None
        }
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
    if (isValid("", nodeLocMap(exp), antecedents, ivector(exp))) true
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
    assert(!vars.contains(varId))
    Some(make(vars = vars + varId))
  }

  def isValid(title: String, li: LocationInfo,
              premises: Iterable[Exp], conclusions: Iterable[Exp]): Boolean = {
    val ps =
      if (coneInfluenceEnabled)
        util.Z3.checkSat(satTimeoutInMs,
          isSymExe = true, And(conclusions.toVector))._2 match {
          case util.Z3.Sat => coneOfInfluence(premises, conclusions)
          case _ => premises
        }
      else premises

    val (script, r) = Z3.isValid(timeoutInMs, isSymExe, ps.toVector, conclusions.toVector)
    if (inscribeSummoningsEnabled) {
      val lineSep = scala.util.Properties.lineSeparator
      val sb = new StringBuilder
      if ("" == title) sb.append("; Validity: ")
      else sb.append(s"; Validity of $title: ")
      sb.append(r match {
        case Z3.Unsat => "Valid"
        case Z3.Sat => "Invalid"
        case Z3.Timeout => "Don't Know (Timeout)"
        case Z3.Unknown => "Don't Know"
        case Z3.Error => "Error"
      })
      sb.append(lineSep)
      var i = 0
      for (p <- ps) {
        sb.append(";   ")
        sb.append(Exp.toString(p, inProof = true))
        if (i + 1 != ps.size) sb.append(',')
        sb.append(lineSep)
        i += 1
      }
      sb.append(";     ⊢")
      sb.append(lineSep)
      i = 0
      for (c <- conclusions) {
        sb.append(";   ")
        sb.append(Exp.toString(c, inProof = true))
        if (i + 1 != conclusions.size) sb.append(',')
        sb.append(lineSep)
        i += 1
      }
      sb.append(lineSep)
      sb.append(script)
      reporter.report(li.toLocationInfo(fileUriOpt, "summoning", sb.toString))
    }
    r == Z3.Unsat
  }

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
    for (e1 <- es1; e2 <- es2)
      if (e1 == e2)
        r += e1
      else
        r += Or(e1, e2)
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

  def hasRuntimeError(stmt: Stmt): Boolean = {
    var hasError = false
    lazy val ps = premises ++ facts.values
    def divisor(e: Exp, t: tipe.IntegralTipe): Boolean = {
      val tpe = t match {
        case tipe.Z => ZType()
        case tipe.Z8 => Z8Type()
        case tipe.Z16 => Z16Type()
        case tipe.Z32 => Z32Type()
        case tipe.Z64 => Z64Type()
        case tipe.N => NType()
        case tipe.N8 => N8Type()
        case tipe.N16 => N16Type()
        case tipe.N32 => N32Type()
        case tipe.N64 => N64Type()
        case tipe.S8 => S8Type()
        case tipe.S16 => S16Type()
        case tipe.S32 => S32Type()
        case tipe.S64 => S64Type()
        case tipe.U8 => U8Type()
        case tipe.U16 => U16Type()
        case tipe.U32 => U32Type()
        case tipe.U64 => U64Type()
      }
      val req = Ne(e, IntLit("0", tpe.bitWidth, Some(tpe)))
      req.tipe = t
      if (autoEnabled) {
        if (!isValid("division", nodeLocMap(e), ps, ivector(req))) {
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
      req1.tipe = tipe.Z
      val sz = Size(id)
      sz.tipe = id.tipe
      val req2 = Lt(e, sz)
      req2.tipe = tipe.Z
      if (autoEnabled) {
        if (!isValid("indexing low-bound", nodeLocMap(e), ps, ivector(req1))) {
          hasError = true
          error(e, "Could not automatically deduce that the sequence index is non-negative.")
        }
        if (!isValid("indexing high-bound", nodeLocMap(e), ps, ivector(req2))) {
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
      case e@Div(_, e2) => divisor(e2, e.tipe.asInstanceOf[tipe.IntegralTipe])
      case e@Rem(_, e2) => divisor(e2, e.tipe.asInstanceOf[tipe.IntegralTipe])
      case a@Apply(id, Seq(e)) if id.tipe.isInstanceOf[tipe.MSeq] => index(id, e)
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

  def error(n: Node, msg: String): Option[T] = error(nodeLocMap(n), msg)

  def error(li: LocationInfo, msg: String): Option[T] = {
    reporter.report(li.toLocationError(fileUriOpt, Checker.kind, msg))
    None
  }

  def warn(n: Node, msg: String): Unit = warn(nodeLocMap(n), msg)

  def warn(li: LocationInfo, msg: String): Unit =
    reporter.report(li.toLocationWarning(fileUriOpt, Checker.kind, msg))
}
