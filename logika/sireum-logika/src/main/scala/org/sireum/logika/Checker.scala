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
import org.sireum.util.Rewriter.TraversalMode
import org.sireum.util._

object Checker {
  private[logika] final val top = BooleanLit(true)
  private[logika] final val bottom = BooleanLit(false)

  final def check(unitNode: UnitNode, autoEnabled: Boolean)(
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
          val r = ProofContext(s.mode,
            autoEnabled = false, isetEmpty, s.premises.toSet,
            vars, imapEmpty, imapEmpty).check(proof).isDefined
          val exps = proof.steps.flatMap(_ match {
            case s: RegularStep => Some(s.exp)
            case _ => None
          }).toSet
          for (c <- s.conclusions) {
            if (!exps.contains(c)) {
              val cLi = nodeLocMap(c)
              reporter.error(cLi.lineBegin, cLi.columnBegin, cLi.offset,
                s"The sequent conclusion has not been proved.")
            }
          }
          if (r) reporter.info(s"${unitNode.mode.value} logic proof is accepted.")
          else reporter.error(s"${unitNode.mode.value} logic proof is rejected.")
          r
        case _ =>
          reporter.error(s"${unitNode.mode.value} logic proof is yet to be done.")
          false
      }
    case program: Program =>
      implicit val nodeLocMap = program.nodeLocMap
      ProofContext(program.mode,
        autoEnabled, isetEmpty, isetEmpty, isetEmpty,
        imapEmpty ++ program.fact.factOrFunDecls.flatMap(_ match {
          case f: Fact => Some(f.id.value -> f.exp)
          case _ => None
        }), imapEmpty).check(program)
    case _: Proof => assert(assertion = false, "Unexpected situation."); false
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
}

private final case class
ProofContext(mode: LogicMode,
             autoEnabled: Boolean,
             invariants: ISet[Exp],
             premises: ISet[Exp],
             vars: ISet[String],
             facts: IMap[String, Exp],
             provedSteps: IMap[Int, ProofStep])
            (implicit reporter: Reporter,
             nodeLocMap: MIdMap[Node, LocationInfo]) {

  def check(program: Program): Boolean = {
    Z3.checkSat(facts.values.toVector: _*) match {
      case Z3.Sat =>
      case Z3.Unsat =>
        reporter.error("The set of facts are unsatisfiable.")
        return false
      case Z3.Unknown => reporter.warn("The set of facts might not be satisfiable.")
      case Z3.Timeout => reporter.warn("Could not determine the satisfiability of facts due to timeout.")
      case Z3.Error => return false
    }
    check(program.block).isDefined
  }

  def check(block: Block): Option[ProofContext] = {
    var hasError = false
    var pcOpt: Option[ProofContext] = Some(this)
    for (stmt <- block.stmts if pcOpt.isDefined) {
      val pc =
        if (stmt.isInstanceOf[ProofStmt]) pcOpt.get
        else pcOpt.get.cleanup
      pcOpt =
        stmt match {
          case ProofStmt(proof) =>
            pc.check(proof) match {
              case Some(pc2) =>
                Some(pc2.copy(
                  premises = filter(extractClaims(proof)),
                  provedSteps = imapEmpty))
              case _ => None
            }
          case SequentStmt(sequent) =>
            var i = 1
            for (premise <- sequent.premises) {
              if (!pc.premises.contains(premise)) {
                hasError = true
                error(premise, s"Could not find claimed premise #$i.")
              }
              i += 1
            }
            if (!autoEnabled) {
              hasError = true
              error(stmt, s"Auto is not enabled, but sequent is used.")
            }
            if (!Z3.isValid(sequent.premises, sequent.conclusions)) {
              hasError = true
              error(stmt, "Could not automatically deduce validity of the specified sequent.")
            }
            Some(pc.copy(premises = sequent.conclusions.toSet))
          case Assert(e) =>
            Some(pc.copy(premises = pc.premises + e))
          case VarAssign(id, exp) =>
            exp match {
              case _: ReadInt => pcOpt
              case exp: Clone => pc.assign(id, exp.id)
              case exp: Apply => ???
              case _ => pc.assign(id, exp)
            }
          case If(exp, thenBlock, elseBlock) =>
            val thenPcOpt = copy(premises = premises + exp).check(thenBlock)
            val elsePcOpt = copy(premises = premises + Not(exp)).check(elseBlock)
            (thenPcOpt, elsePcOpt) match {
              case (Some(thenPc), Some(elsePc)) =>
                Some(copy(premises =
                  orClaims(thenPc.premises, elsePc.premises)))
              case _ => None
            }
        }
    }
    if (hasError) None else pcOpt.map(_.cleanup)
  }

  def orClaims(es1: Iterable[Exp], es2: Iterable[Exp]): ISet[Exp] =
    (for (e1 <- es1; e2 <- es2) yield
      ivector(Or(e1, e2)) ++
        (if (e1 != e2) ivectorEmpty else ivector(e1))).
      flatten.toSet

  def extractClaims(pg: ProofGroup): ISet[Exp] =
    pg.allSteps.flatMap(_ match {
      case step: RegularStep => Some(step.exp)
      case _ => None
    }).toSet

  def assign(id: Id, exp: Exp): Option[ProofContext] = {
    val sst = expRewriter(Map[Node, Node](id -> Id(id.value + "_old")))
    Some(copy(premises = premises.map(sst) + Eq(id, sst(exp))))
  }

  def cleanup: ProofContext =
    copy(premises = filter(premises), provedSteps = imapEmpty)

  def filter(premises: ISet[Exp]): ISet[Exp] = {
    def keep(e: Exp) = {
      var r = true
      Visitor.build({
        case Id(value) =>
          if (value.endsWith("_old") ||
            value.endsWith("_result") || value.startsWith("_"))
            r = false
          false
      })(e)
      r
    }
    premises.filter(keep)
  }

  def check(proofGroup: ProofGroup): Option[ProofContext] = {
    var addedVars = isetEmpty[String]
    var pcOpt: Option[ProofContext] =
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
        case _ => Some(this)
      }
    for (step <- proofGroup.steps if pcOpt.isDefined)
      step match {
        case p: RegularStep => pcOpt = pcOpt.flatMap(_.check(p))
        case p: SubProof => pcOpt = pcOpt.get.check(p)
        case _: ForAllAssumeStep => assert(assertion = false, "Unexpected situation.")
      }
    pcOpt.map(pc => pc.copy(vars = pc.vars -- addedVars))
  }

  def check(step: RegularStep): Option[ProofContext] = {
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
                if (ls.exp != Checker.bottom) {
                  error(ls.exp, s"The conclusion in step #${subProof.value} is expected to be a falsicum (⊥) for Negation-intro of #$num.")
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
                if (ls.exp != Checker.bottom) {
                  error(ls.exp, s"The conclusion of step #${subProof.value} is expected to be a falsicum (⊥) for Pbc of #$num.")
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
        var hasError = true
        (findRegularStepOrFactExp(eqStep, num),
          findRegularStepExp(step2, num)) match {
          case (Some(Eq(exp1, exp2)), Some(e)) =>
            val expected =
              org.sireum.logika.ast.Rewriter.build[Exp]()({
                case `exp2` => exp1
              })(e)
            if (expected != exp) {
              val eqStepText = text(eqStep)
              error(exp, s"The expression in step #$num does not match the substituted expression of [left of #$eqStepText/right of #$eqStepText]#${step2.value} for Subst1.")
            }
          case (Some(_), Some(_)) =>
            error(eqStep, s"The second expression argument of step #${text(eqStep)} for Subst1 in step #$num has to be an equality.")
            hasError = true
          case _ => hasError = true
        }
        if (hasError) None else addProvedStep(step)
      case Subst2(_, exp, eqStep, step2) =>
        var hasError = true
        (findRegularStepOrFactExp(eqStep, num),
          findRegularStepExp(step2, num)) match {
          case (Some(Eq(exp1, exp2)), Some(e)) =>
            val expected =
              org.sireum.logika.ast.Rewriter.build[Exp]()({
                case `exp1` => exp2
              })(e)
            if (expected != exp) {
              val eqStepText = text(eqStep)
              error(exp, s"The expression in step #$num does not match the substituted expression of [right of #$eqStepText/left of #$eqStepText]#${step2.value} for Subst2.")
            }
          case (Some(_), Some(_)) =>
            error(eqStep, s"The second expression argument of step #${text(eqStep)} for Subst2 in step #$num has to be an equality.")
            hasError = true
          case _ => hasError = true
        }
        if (hasError) None else addProvedStep(step)
      case Algebra(_, exp, stepOrFacts) =>
        if (deduce(num, exp, stepOrFacts, checkAlgebraExp))
          addProvedStep(step)
        else None
      case ForAllIntro(_, q, subProof) =>
        findSubProof(subProof, num) match {
          case Some(sp) =>
            var hasError = false
            (sp.first, sp.last) match {
              case (fs: ForAllAssumeStep, ls: RegularStep) =>
                val freshVarId = fs.id
                val freshVar = freshVarId.value
                if (!Checker.collectVars(ls.exp).contains(freshVar))
                  warn(ls.exp, s"The conclusion in step #${subProof.value} does not use the fresh variable $freshVar introducted in #${fs.num.value}.")
                val expected = subst(q.simplify.exp, Map(q.ids.head -> freshVarId))
                if (expected != ls.exp) {
                  error(q, s"Supplying $freshVar for ${q.ids.head} in step #$num does not produce matching expression in #${ls.num.value} for Forall-intro.")
                  hasError = true
                }
              case (fs, ls) =>
                if (!fs.isInstanceOf[ForAllAssumeStep])
                  error(sp, s"Wrong form for the start of Forall-intro in step #$num that is expected to have only a fresh variable.")
                if (!ls.isInstanceOf[RegularStep])
                  error(sp, s"Wrong form for Forall-intro conclusion in step #$num.")
                hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case _ => None
        }
      case ForAllElim(_, exp, stepOrFact, args) =>
        findRegularStepOrFactExp(stepOrFact, num) match {
          case Some(q: ForAll) =>
            buildSubstMap(q.simplify, args) match {
              case Some((m, e)) =>
                val expected = subst(e, m)
                if (exp != expected) {
                  error(exp, s"Supplying the specified arguments to the quantification ${text(stepOrFact)} does not produce matching expression in #$num for Forall-elim.")
                  None
                } else addProvedStep(step)
              case _ => error(step, s"The numbers of quantified variables and arguments do not match in Forall-elim of step #$num.")
            }
          case Some(_) => error(stepOrFact, s"Forall-elim in $num requires a universal quantification ${text(stepOrFact)}.")
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
      case ExistsElim(_, exp, stepOrFact, subProof) =>
        findRegularStepOrFactExp(stepOrFact, num) match {
          case Some(q: Exists) =>
            findSubProof(subProof, num) match {
              case Some(sp) =>
                var hasError = false
                sp.first match {
                  case fs: ExistsAssumeStep =>
                    val freshVar = fs.id.value
                    val expected = subst(q.simplify.exp, Map(q.ids.head -> Id(freshVar)))
                    if (expected != fs.exp) {
                      error(exp, s"Supplying $freshVar for ${q.ids.head} ${text(stepOrFact)} does not produce matching expression in the assumption of #${subProof.value} for Exists-elim.")
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
          case Some(_) => error(stepOrFact, s"Exists-elim in step #$num requires an existensial quantification ${text(stepOrFact)}.")
          case _ => None
        }
      case Auto(_, exp, stepOrFacts) =>
        if (!autoEnabled)
          error(step, s"Auto is not enabled, but used in step #$num.")
        if (deduce(num, exp, stepOrFacts, e => true)) addProvedStep(step)
        else None
      case Invariant(_, exp) =>
        if (invariants.contains(exp)) addProvedStep(step)
        else error(exp, s"Could not find the invariant in step #$num.")
      case _: ExistsAssumeStep | _: PlainAssumeStep =>
        assert(assertion = false, "Unexpected situation.")
        None
    }
  }

  def deduce(num: Int, exp: Exp, stepOrFacts: Node.Seq[NumOrId],
             f: Exp => Boolean): Boolean = {
    var antecedents = Node.emptySeq[Exp]
    var hasError = false
    for (numOrId <- stepOrFacts)
      findRegularStepOrFactExp(numOrId, num) match {
        case Some(e) => if (f(e)) antecedents :+= e
        case _ => hasError = true
      }
    if (hasError) return false
    if (Z3.isValid(antecedents, ivector(exp))) true
    else {
      error(exp, s"Could not automatically deduce the claim in step#$num.")
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

  def text(stepOrFact: NumOrId): String = stepOrFact match {
    case Num(num) => s"in #$num"
    case Id(id) => s"fact named $id"
  }

  def findRegularStepOrFactExp(stepOrFact: NumOrId, stepNum: Int): Option[Exp] =
    stepOrFact match {
      case num: Num => findRegularStepExp(num, stepNum)
      case id: Id => facts.get(id.value) match {
        case eOpt@Some(_) => eOpt
        case _ =>
          val (l, c, o) = lineColumnOffset(stepOrFact)
          reporter.error(l, c, o, s"Could not find the referenced fact ${id.value} in #$stepNum.")
          None
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

  def addVar(id: Id, stepNum: Int): Option[ProofContext] = {
    val varId = id.value
    if (vars.contains(varId)) {
      error(id, s"The variable $varId in step #$stepNum, is not fresh.")
      None
    } else Some(copy(vars = vars + varId))
  }

  def lineColumnOffset(n: Node): (Int, Int, Int) = {
    val li = nodeLocMap(n)
    (li.lineBegin, li.columnBegin, li.offset)
  }

  def findSubProof(num: Num, stepNum: Int): Option[SubProof] = {
    provedSteps.get(num.value) match {
      case Some(r: SubProof) => Some(r)
      case Some(_) =>
        val (l, c, o) = lineColumnOffset(num)
        reporter.error(l, c, o, s"#${num.value} should be a sub-proof.")
        None
      case _ =>
        val (l, c, o) = lineColumnOffset(num)
        reporter.error(l, c, o, s"Could not find the referenced sub-proof #${num.value} in #$stepNum.")
        None
    }
  }

  def findRegularStepExp(num: Num, stepNum: Int): Option[Exp] =
    provedSteps.get(num.value) match {
      case Some(r: RegularStep) => Some(r.exp)
      case _ =>
        val (l, c, o) = lineColumnOffset(num)
        reporter.error(l, c, o, s"Could not find the referenced step #${num.value} in #$stepNum.")
        None
    }

  def error(n: Node, msg: String): Option[ProofContext] = {
    val (l, c, o) = lineColumnOffset(n)
    reporter.error(l, c, o, msg)
    None
  }

  def warn(n: Node, msg: String): Option[ProofContext] = {
    val (l, c, o) = lineColumnOffset(n)
    reporter.warn(l, c, o, msg)
    None
  }
}
