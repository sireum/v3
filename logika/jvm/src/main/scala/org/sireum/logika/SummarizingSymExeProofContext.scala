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

import org.sireum.util.Rewriter.TraversalMode
import org.sireum.util._

private final case class
SummarizingSymExeProofContext(unitNode: ast.Program,
                              autoEnabled: Boolean,
                              timeoutInMs: PosInteger,
                              checkSat: Boolean,
                              hintEnabled: Boolean,
                              inscribeSummoningsEnabled: Boolean,
                              coneInfluenceEnabled: Boolean,
                              bitWidth: Natural,
                              invariants: ILinkedSet[ast.Exp] = ilinkedSetEmpty,
                              premises: ILinkedSet[ast.Exp] = ilinkedSetEmpty,
                              vars: ISet[String] = isetEmpty,
                              facts: IMap[String, ast.Exp] = imapEmpty,
                              provedSteps: IMap[Natural, ast.ProofStep] = imapEmpty,
                              declaredStepNumbers: IMap[Natural, LocationInfo] = imapEmpty,
                              inMethod: Boolean = false,
                              satFacts: Boolean = true,
                              oldIdLineMap: IMap[ast.Id, (Natural, PosInteger)] = imapEmpty)
                             (implicit reporter: AccumulatingTagReporter)
  extends SymExeProofContext[SummarizingSymExeProofContext] {

  def check: Boolean = {
    val program = unitNode
    val facts = extractFacts
    var isSat = true
    if (facts.nonEmpty && !checkSat("facts", nodeLocMap(program), facts.values,
      unsatMsg = "The specified set of facts are unsatisfiable.",
      unknownMsg = {
        isSat = false
        "The set of facts might not be satisfiable."
      },
      timeoutMsg = {
        isSat = false
        "Could not check satisfiability of the set of facts due to timeout."
      }
    )) return false
    copy(facts = facts, satFacts = isSat).check(program.block).isDefined
  }

  def check(block: ast.Block): Option[SummarizingSymExeProofContext] = {
    var pcOpt: Option[SummarizingSymExeProofContext] = Some(this)
    for (stmt <- block.stmts if pcOpt.isDefined) {
      val pc =
        if (stmt.isInstanceOf[ast.ProofStmt]) pcOpt.get
        else pcOpt.get.cleanup
      pcOpt = pc.check(stmt)
    }
    pcOpt
  }

  def check(stmt: ast.Stmt): Option[SummarizingSymExeProofContext] = {
    val effectiveSatFacts = if (satFacts) facts.values else ivectorEmpty
    var hasError = false
    if (!stmt.isInstanceOf[ast.ProofElementStmt] &&
      !stmt.isInstanceOf[ast.MethodDecl]) {
      hasError = hasRuntimeError(stmt) || hasError
    }
    val pcOpt = stmt match {
      case ast.ProofStmt(proof) =>
        check(proof).map(_.copy(
          premises = filter(premises ++ extractClaims(proof, reverse = false)),
          provedSteps = imapEmpty))
      case ast.SequentStmt(sequent) =>
        if (sequent.premises.nonEmpty) {
          if (!isValid("sequent premises", nodeLocMap(stmt), premises, sequent.premises)) {
            hasError = true
            error(stmt, "Could not automatically deduce the specified sequent's premises.")
          }
          if (sequent.conclusions == topConclusion)
            Some(copy(premises = ilinkedSetEmpty ++ sequent.premises))
          else {
            if (!isValid("sequent conclusions", nodeLocMap(stmt), sequent.premises, sequent.conclusions)) {
              hasError = true
              error(stmt, "Could not automatically deduce the specified sequent's conclusions from its premises.")
            }
            Some(copy(premises = filter(premises ++ sequent.premises ++ sequent.conclusions)))
          }
        } else if (sequent.conclusions == topConclusion) {
          Some(copy(premises = ilinkedSetEmpty))
        } else {
          if (!isValid("sequent conclusions", nodeLocMap(stmt), premises ++ facts.values, sequent.conclusions)) {
            hasError = true
            error(stmt, "Could not automatically deduce the specified sequent's conclusions.")
          }
          Some(copy(premises = filter(premises ++ sequent.conclusions)))
        }
      case ast.Assert(e) =>
        if (!isValid("", nodeLocMap(stmt), premises ++ facts.values, ivector(e))) {
          error(stmt, s"Could not automatically deduce the assertion validity.")
          hasError = true
          checkSat("", nodeLocMap(stmt), premises ++ effectiveSatFacts + e,
            unsatMsg = s"The assertion is unsatisfiable.",
            unknownMsg = s"The assertion might not be satisfiable.",
            timeoutMsg = s"Could not check satisfiability of the assertion due to timeout.")
        }
        Some(copy(premises = premises + e))
      case ast.Assume(e) =>
        hasError = !checkSat("", nodeLocMap(stmt),
          premises ++ effectiveSatFacts + e,
          unsatMsg = s"The assumption is unsatisfiable.",
          unknownMsg = s"The assumption might not be satisfiable.",
          timeoutMsg = s"Could not check satisfiability of the assumption due to timeout."
        ) || hasError
        Some(copy(premises = premises + e))
      case ast.SeqAssign(id, index, exp) =>
        val (pc2, old) = defOldId(id, nodeLocMap(id).lineBegin)
        val m = imapEmpty[ast.Node, ast.Node] + (id -> old)
        val qVar = ast.Exp.Id(tipe.Z, "q_i")
        val t = id.tipe.asInstanceOf[tipe.Fn].result
        import ast.Exp
        Some(pc2.copy(premises =
          premises.map(e => subst(e, m)) ++
            ivector(
              Exp.Eq(tipe.Z, Exp.Size(id.tipe, id), Exp.Size(old.tipe, old)),
              Exp.Eq(t, Exp.Apply(id.tipe, id, ast.Node.seq(subst(index, m))), subst(exp, m)),
              ast.ForAll(
                ast.Node.seq(qVar),
                Some(ast.Exp.RangeDomain(tipe.Z, Checker.zero, Exp.Size(id.tipe, id),
                  loLt = false, hiLt = true)),
                Exp.Implies(tipe.B,
                  Exp.Ne(tipe.Z, qVar, index),
                  Exp.Eq(t, Exp.Apply(id.tipe, id, ast.Node.seq(qVar)), Exp.Apply(old.tipe, old, ast.Node.seq(qVar)))
                )
              )
            )))
      case ast.ExpStmt(exp) =>
        val (he, pc2) = invoke(exp, None)
        hasError ||= he
        Some(pc2)
      case a: ast.VarAssign =>
        val id = a.id
        val exp = a.exp
        exp match {
          case _: ast.ReadInt => assign(id)
          case _: ast.RandomInt => assign(id)
          case _: ast.Random => assign(id)
          case exp: ast.Clone => assign(id, exp.id)
          case exp: ast.Apply if !exp.expTipe.isInstanceOf[tipe.MSeq] =>
            val (he, pc2) = invoke(exp, Some(id))
            hasError ||= he
            Some(pc2)
          case exp: ast.TypeMethodCallExp =>
            exp.id.value match {
              case "create" =>
                val req = ast.Exp.Ge(tipe.Z, exp.args.head, Checker.zero)
                if (isValid("precondition", nodeLocMap(exp), premises, ivector(req))) {
                  val resultT = exp.id.tipe.asInstanceOf[tipe.Fn].result.asInstanceOf[tipe.MSeq]
                  val qVar = ast.Exp.Id(tipe.Z, "q_i")
                  val sz = ast.Exp.Size(resultT, id)
                  assign(id).map(pc => pc.copy(premises = pc.premises ++ ivector(
                    ast.Exp.Eq(tipe.Z, sz, exp.args.head),
                    ast.ForAll(ivector(qVar), Some(ast.Exp.RangeDomain(tipe.Z, Checker.zero, sz, loLt = false, hiLt = true)),
                      ast.Exp.Eq(resultT.result, ast.Exp.Apply(resultT, id, ivector(qVar)), exp.args(1)))
                  )))
                } else {
                  error(exp.args.head, s"Could not automatically deduce the size is non-negative.")
                  None
                }
            }
          case _ => assign(id, exp)
        }
      case stmt@ast.If(exp, thenBlock, elseBlock) =>
        val thenPcOpt = copy(premises = premises + exp).check(thenBlock)
        val elsePcOpt = copy(premises = premises + ast.Exp.Not(tipe.B, exp)).check(elseBlock)
        (thenPcOpt, elsePcOpt) match {
          case (Some(thenPc), Some(elsePc)) =>
            var thenPremises = thenPc.cleanup.premises
            var elsePremises = elsePc.cleanup.premises
            val commonPremises = thenPremises.intersect(elsePremises)

            var modifiedIds = scala.collection.immutable.TreeSet.empty[ast.Id](
              Ordering.fromLessThan(_.value > _.value))
            for ((k, v) <- thenPc.oldIdLineMap if (oldIdLineMap.get(k) match {
              case Some(v2) => v != v2
              case _ => false
            })) {
              modifiedIds += k
            }
            for ((k, v) <- elsePc.oldIdLineMap if (oldIdLineMap.get(k) match {
              case Some(v2) => v != v2
              case _ => false
            })) {
              modifiedIds += k
            }
            var nextOldIdLineMap = oldIdLineMap
            val line = nodeLocMap(stmt).lineEnd
            for (id <- modifiedIds) {
              val newThenId = symId(id.tipe, id.value, thenPc.oldIdLineMap(id)._2)
              val newElseId = symId(id.tipe, id.value, elsePc.oldIdLineMap(id)._2)
              val thenSubstMap = Map[ast.Node, ast.Node](id -> newThenId)
              val elseSubstMap = Map[ast.Node, ast.Node](id -> newElseId)
              thenPremises = thenPremises.map(p => subst(p, thenSubstMap))
              elsePremises = elsePremises.map(p => subst(p, elseSubstMap))
              thenPremises += ast.Exp.Eq(id.tipe, id, newThenId)
              elsePremises += ast.Exp.Eq(id.tipe, id, newElseId)
              nextOldIdLineMap = nextOldIdLineMap + (id -> (line, line))
            }

            import ast.Exp
            Some(copy(premises = commonPremises +
              Exp.Or(tipe.B, Exp.And((thenPremises -- commonPremises).toVector),
                Exp.And((elsePremises -- commonPremises).toVector)),
              oldIdLineMap = nextOldIdLineMap))
          case _ => None
        }
      case stmt: ast.MethodDecl =>
        val invs = if (stmt.isHelper) ilinkedSetEmpty else invariants
        val effectivePre = invs ++ stmt.contract.requires.exps
        val effectivePost = invs ++ stmt.contract.ensures.exps
        val preLi = nodeLocMap(
          if (stmt.contract.requires.exps.isEmpty) stmt
          else stmt.contract.requires.exps.head)
        hasError =
          !checkSat("effective precondition", preLi,
            effectiveSatFacts ++ effectivePre,
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
        val postLi = nodeLocMap(
          if (stmt.contract.ensures.exps.isEmpty) stmt
          else stmt.contract.ensures.exps.head)
        hasError =
          !checkSat("effective postcondition", postLi,
            effectiveSatFacts ++ effectivePost,
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
        val mods = modifiedIds.map(id => ast.Exp.Eq(id.tipe, id, ast.Exp.Id(id.tipe, id.value + "_in")))
        copy(premises = ilinkedSetEmpty ++ effectivePre ++ mods, inMethod = false).
          check(stmt.block) match {
          case Some(pc2) =>
            var modifiedInvariants = ilinkedSetEmpty[ast.Exp]
            for (e <- invs) {
              var modified = false
              Visitor.build({
                case id: ast.Id =>
                  if (modifiedIds.contains(id)) {
                    modified = true
                  }
                  false
              })(e)
              if (modified) modifiedInvariants += e
            }
            val ps = pc2.premises ++ pc2.facts.values
            for (e <- modifiedInvariants)
              if (!isValid(s"global invariant", nodeLocMap(stmt), ps, ivector(e))) {
                error(e, s"Could not automatically deduce the global invariant at the end of method ${stmt.id.value}.")
                hasError = true
              }
            val post = stmt.contract.ensures.exps
            val postSubstMap = stmt.returnExpOpt match {
              case Some(e) => imapEmpty[ast.Node, ast.Node] + (ast.Result() -> e)
              case _ => imapEmpty[ast.Node, ast.Node]
            }
            for (e <- post)
              if (!isValid("postcondition", nodeLocMap(e), ps, ivector(subst(e, postSubstMap)))) {
                error(e, s"Could not automatically deduce the post-condition of method ${stmt.id.value}.")
                hasError = true
              }
          case _ => hasError = true
        }
        Some(this.cleanup)
      case ast.InvStmt(inv) =>
        val ps = premises ++ facts.values
        for (e <- inv.exps)
          if (!isValid("", nodeLocMap(e), ps, ivector(e))) {
            error(e, s"Could not automatically deduce the global invariant.")
            hasError = true
          }
        if (hasError)
          checkSat("global invariant", nodeLocMap(stmt),
            effectiveSatFacts ++ inv.exps,
            unsatMsg = s"The global invariant(s) are unsatisfiable.",
            unknownMsg = s"The global invariant(s) might not be satisfiable.",
            timeoutMsg = s"Could not check satisfiability of the global invariant(s) due to timeout.")
        Some(copy(invariants = invariants ++ inv.exps))
      case _: ast.FactStmt => Some(this)
      case stmt@ast.While(exp, loopBlock, loopInv) =>
        val es = loopInv.invariant.exps
        val lps = premises ++ facts.values
        for (e <- es)
          if (!isValid("loop invariant (beginning)", nodeLocMap(e), lps, ivector(e))) {
            error(e, s"Could not automatically deduce the loop invariant at the beginning of the loop.")
            hasError = true
          }
        var ps = ilinkedSetEmpty ++ es
        var modifiedIds = loopInv.modifies.ids.toSet
        for (premise <- premises) {
          var propagate = true
          lazy val v: Any => Boolean = Visitor.build({
            case n: ast.Quant[_] if n.ids.exists(modifiedIds.contains(_)) =>
              val oldModifiedIds = modifiedIds
              modifiedIds --= n.ids
              v(n)
              modifiedIds = oldModifiedIds
              false
            case ast.Id(value) =>
              val i = value.indexOf('_')
              val id = if (i >= 0) value.substring(0, i) else value
              if (modifiedIds.contains(ast.Id(id))) propagate = false
              false
          })
          v(premise)
          if (propagate) ps += premise
        }
        var pc2 = this
        for (id <- loopInv.modifies.ids) {
          pc2 = defOldId(id, nodeLocMap(id).lineBegin)._1
        }
        pc2.copy(premises = ps + exp).
          check(loopBlock) match {
          case Some(pc3) =>
            hasError = hasError || pc3.hasRuntimeError(stmt)
            val ps2 = pc3.premises ++ pc3.facts.values
            for (e <- es)
              if (!isValid("loop invariant (end)", nodeLocMap(e), ps2, ivector(e))) {
                error(e, s"Could not deduce the loop invariant at the end of the loop.")
                hasError = true
              }
            Some(copy(premises = ps + ast.Exp.Not(tipe.B, exp),
              oldIdLineMap = pc2.oldIdLineMap))
          case _ => None
        }
      case _: ast.Print => Some(this)
    }
    generateHint(premises, stmt,
      pcOpt.map(_.premises).getOrElse(ilinkedSetEmpty))
    if (hasError) None else pcOpt
  }

  def assign(id: ast.Id, exp: ast.Exp): Option[SummarizingSymExeProofContext] = {
    val (pc2, oid) = defOldId(id, nodeLocMap(id).lineBegin)
    val sst = expRewriter(Map[ast.Node, ast.Node](id -> oid))
    Some(pc2.copy(premises = premises.map(sst) + ast.Exp.Eq(id.tipe, id, sst(exp))))
  }

  def assign(id: ast.Id): Option[SummarizingSymExeProofContext] = {
    val (pc2, oid) = defOldId(id, nodeLocMap(id).lineBegin)
    val sst = expRewriter(Map[ast.Node, ast.Node](id -> oid))
    Some(pc2.copy(premises = premises.map(sst)))
  }

  def invoke(a: ast.Apply, lhsOpt: Option[ast.Id]): (Boolean, SummarizingSymExeProofContext) = {
    var hasError = false
    val md = a.declOpt.get
    var postSubstMap = md.params.map(_.id).zip(a.args).toMap[ast.Node, ast.Node]
    val isHelper = md.isHelper
    var invs = ivectorEmpty[ast.Exp]
    val modIds = md.contract.modifies.ids.map(_.value).toSet
    for (inv <- invariants if !isHelper) {
      var mod = false
      Visitor.build({
        case id: ast.Id =>
          if (modIds.contains(id.value))
            mod = true
          false
      })(inv)
      if (mod) invs :+= inv
    }
    val ps = premises ++ facts.values
    for (inv <- invs if inMethod)
      if (!isValid("invariant", nodeLocMap(a), ps, ivector(inv))) {
        val li = nodeLocMap(inv)
        error(a, s"Could not automatically deduce the invariant of method ${md.id.value} defined at [${li.lineBegin}, ${li.columnBegin}].")
        hasError = true
      }
    for (pre <- md.contract.requires.exps)
      if (!isValid("precondition", nodeLocMap(a), ps, ivector(subst(pre, postSubstMap)))) {
        val li = nodeLocMap(pre)
        error(a, s"Could not automatically deduce the pre-condition of method ${md.id.value} defined at [${li.lineBegin}, ${li.columnBegin}].")
        hasError = true
      }
    var pc2 = this
    val (lhs, psm) = lhsOpt match {
      case Some(x) =>
        val (pc3, x_old) = defOldId(x, nodeLocMap(x).lineBegin)
        pc2 = pc3
        (x, imapEmpty[ast.Node, ast.Node] + (x -> x_old))
      case _ =>
        (ast.Exp.Id(md.id.tipe.asInstanceOf[tipe.Fn].result,
          md.id.value + "_result"),
          imapEmpty[ast.Node, ast.Node])
    }
    var premiseSubstMap = psm
    postSubstMap += ast.Result() -> lhs
    var modParams = isetEmpty[String]
    for ((p, arg@ast.Id(_)) <- md.params.map(_.id).zip(a.args) if modIds.contains(p.value)) {
      modParams += p.value
      val (pc3, arg_old) = defOldId(arg, nodeLocMap(a).lineBegin)
      pc2 = pc3
      val p_in = ast.Exp.Id(p.tipe, p.value + "_in")
      premiseSubstMap += arg -> arg_old
      postSubstMap += arg -> arg_old
      postSubstMap += p -> arg
      postSubstMap += p_in -> arg_old
    }
    for (g <- md.contract.modifies.ids if !modParams.contains(g.value)) {
      val (pc3, g_old) = defOldId(g, nodeLocMap(a).lineBegin)
      pc2 = pc3
      val g_in = ast.Exp.Id(g.tipe, g.value + "_in")
      premiseSubstMap += g -> g_old
      postSubstMap += g_in -> g_old
    }
    (hasError, make(premises =
      premises.map(e => subst(e, premiseSubstMap)) ++ invs ++
        md.contract.ensures.exps.map(e => subst(e, postSubstMap))
    ).copy(oldIdLineMap = pc2.oldIdLineMap))
  }

  def cleanup: SummarizingSymExeProofContext =
    copy(premises = rewriteOld(filter(premises)),
      provedSteps = imapEmpty, declaredStepNumbers = imapEmpty)

  def rewriteOld(premises: ILinkedSet[ast.Exp]): ILinkedSet[ast.Exp] = {
    var r = ilinkedSetEmpty[ast.Exp]
    for (e <- premises) {
      r += ast.Rewriter.build[ast.Exp](TraversalMode.BOTTOM_UP)({
        case idOld@ast.Id(value) if value.endsWith("_old") =>
          val name = value.substring(0, value.length - 4)
          val n = oldIdLineMap(ast.Id(name))._1
          symId(idOld.tipe, name, n)
      })(e)
    }
    r
  }

  override def check(step: ast.RegularStep): Option[SummarizingSymExeProofContext] = {
    val num = step.num.value
    step match {
      case ast.Premise(_, exp) =>
        if (premises.contains(exp) || exp == Checker.top) addProvedStep(step)
        else if (deduce(num, exp, ivectorEmpty, isAuto = true)) addProvedStep(step)
        else error(exp, s"Could not find the claimed premise in step #$num.")
      case _ => super.check(step)
    }
  }

  def defOldId(id: ast.Id, line: PosInteger): (SummarizingSymExeProofContext, ast.Id) = {
    val prevLine = oldIdLineMap.get(id) match {
      case Some((_, next)) => next
      case _ => 0
    }
    val pc = copy(oldIdLineMap = oldIdLineMap + (id -> (prevLine, line)))
    (pc, ast.Exp.Id(id.tipe, s"${id.value}_old"))
  }

  def symId(t: tipe.Tipe, name: String, line: PosInteger) =
    ast.Exp.Id(t, s"${name}_$line")

  def make(vars: ISet[String],
           provedSteps: IMap[Natural, ast.ProofStep],
           declaredStepNumbers: IMap[Natural, LocationInfo],
           premises: ILinkedSet[ast.Exp]): SummarizingSymExeProofContext =
    copy(vars = vars, provedSteps = provedSteps,
      declaredStepNumbers = declaredStepNumbers, premises = premises)
}
