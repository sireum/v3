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
                              timeoutInMs: PosInteger,
                              checkSatEnabled: Boolean,
                              hintEnabled: Boolean,
                              inscribeSummoningsEnabled: Boolean,
                              coneInfluenceEnabled: Boolean,
                              bitWidth: Natural,
                              facts: IMap[String, ast.Exp],
                              invariants: ILinkedSet[ast.Exp] = ilinkedSetEmpty,
                              premises: ILinkedSet[ast.Exp] = ilinkedSetEmpty,
                              vars: ISet[String] = isetEmpty,
                              provedSteps: IMap[Natural, ast.ProofStep] = imapEmpty,
                              declaredStepNumbers: IMap[Natural, LocationInfo] = imapEmpty,
                              mdOpt: Option[ast.MethodDecl] = None,
                              satFacts: Boolean = true,
                              oldIdLineMap: IMap[ast.Id, (Natural, PosInteger)] = imapEmpty)
                             (implicit reporter: AccumulatingTagReporter)
  extends SymExeProofContext[SummarizingSymExeProofContext] {

  def check: Boolean = {
    val program = unitNode
    val (isSat, ok) = checkSatFacts
    if (!ok) return false
    copy(satFacts = isSat).check(program.block)
    !reporter.hasError
  }

  def check(block: ast.Block, checkReturn: Boolean = false): Option[SummarizingSymExeProofContext] = {
    var pcOpt: Option[SummarizingSymExeProofContext] = Some(this)
    for (stmt <- block.stmts if pcOpt.isDefined) {
      val pc =
        if (stmt.isInstanceOf[ast.ProofStmt]) pcOpt.get
        else pcOpt.get.cleanup
      pcOpt = pc.check(stmt)
    }
    (pcOpt, block.returnOpt) match {
      case (Some(pc), Some(ret)) =>
        pc.checkPostCondition(nodeLocMap(ret), ret.expOpt)
        pcOpt = None
      case (Some(pc), _) if checkReturn =>
        val li = nodeLocMap(block)
        pc.checkPostCondition(li.copy(
          lineBegin = li.lineEnd,
          columnBegin = li.columnEnd - 1,
          offset = li.offset + li.length - 1,
          length = 1), None)
        pcOpt = None
      case _ =>
    }
    pcOpt
  }

  def checkPostCondition(li: LocationInfo, retExpOpt: Option[ast.Exp]): Unit = {
    assert(mdOpt.nonEmpty)
    val md = mdOpt.get
    val invs = if (md.isHelper) ilinkedSetEmpty else invariants
    val modifiedIds = md.contract.modifies.ids.toSet
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
    val ps = premises ++ facts.values
    for (e <- modifiedInvariants)
      if (!isValid(s"Global Invariant", li, ps, ivector(e))) {
        val eLi = nodeLocMap(e)
        error(li, s"Could not automatically deduce the global invariant specified at [${eLi.lineBegin}, ${eLi.columnBegin}].")
      }
    val post = md.contract.ensures.exps
    val postSubstMap = retExpOpt match {
      case Some(e) => imapEmpty[ast.Node, ast.Node] + (ast.Result() -> e)
      case _ => imapEmpty[ast.Node, ast.Node]
    }
    for (e <- post)
      if (!isValid("Post-condition", li, ps, ivector(subst(e, postSubstMap)))) {
        val eLi = nodeLocMap(e)
        error(li, s"Could not automatically deduce the post-condition specified at [${eLi.lineBegin}, ${eLi.columnBegin}].")
      }
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
          if (!isValid("Sequent Premises", nodeLocMap(stmt), premises, sequent.premises)) {
            hasError = true
            error(stmt, "Could not automatically deduce the specified sequent's premises.")
          }
          if (sequent.conclusions == topConclusion)
            Some(copy(premises = ilinkedSetEmpty ++ sequent.premises))
          else {
            if (!isValid("Sequent Conclusions", nodeLocMap(stmt), sequent.premises, sequent.conclusions)) {
              hasError = true
              error(stmt, "Could not automatically deduce the specified sequent's conclusions from its premises.")
            }
            Some(copy(premises = filter(premises ++ sequent.premises ++ sequent.conclusions)))
          }
        } else if (sequent.conclusions == topConclusion) {
          Some(copy(premises = ilinkedSetEmpty))
        } else {
          if (!isValid("Sequent Conclusions", nodeLocMap(stmt), premises ++ facts.values, sequent.conclusions)) {
            hasError = true
            error(stmt, "Could not automatically deduce the specified sequent's conclusions.")
          }
          Some(copy(premises = filter(premises ++ sequent.conclusions)))
        }
      case ast.Assert(e) =>
        if (!isValid("Assertion", nodeLocMap(stmt), premises ++ facts.values, ivector(e))) {
          error(stmt, s"Could not automatically deduce the assertion validity.")
          hasError = true
          checkSat("Assertion", nodeLocMap(stmt), premises ++ effectiveSatFacts + e, genMessage = true,
            unsatMsg = s"The assertion is unsatisfiable.",
            unknownMsg = s"The assertion might not be satisfiable.",
            timeoutMsg = s"Could not check satisfiability of the assertion due to timeout.")
        }
        Some(copy(premises = premises + e))
      case ast.Assume(e) =>
        hasError = !checkSat("Assumption", nodeLocMap(stmt),
          premises ++ effectiveSatFacts + e, genMessage = true,
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
      case ast.ExpStmt(exp) => Some(invoke(exp, None))
      case a: ast.VarAssign =>
        val id = a.id
        val exp = a.exp
        exp match {
          case _: ast.ReadInt => assign(id)
          case _: ast.RandomInt => assign(id)
          case _: ast.Random => assign(id)
          case exp: ast.Clone => assign(id, exp.id)
          case exp: ast.Apply if !exp.expTipe.isInstanceOf[tipe.MSeq] =>
            Some(invoke(exp, Some(id)))
          case exp: ast.TypeMethodCallExp =>
            exp.id.value match {
              case "create" =>
                var req: ast.Exp = ast.Exp.Ge(tipe.Z, exp.args.head, Checker.zero)
                if (bitWidth != 0) {
                  req = ast.Exp.And(tipe.B, req, ast.Exp.Le(tipe.Z, exp.args.head, zMax))
                }
                if (isValid("Pre-condition", nodeLocMap(exp), premises, ivector(req))) {
                  val resultT = exp.id.tipe.asInstanceOf[tipe.Fn].result.asInstanceOf[tipe.MSeq]
                  val qVar = ast.Exp.Id(tipe.Z, "q_i")
                  val sz = ast.Exp.Size(resultT, id)
                  assign(id).map(pc => pc.copy(premises = pc.premises ++ ivector(
                    ast.Exp.Eq(tipe.Z, sz, exp.args.head),
                    ast.ForAll(ivector(qVar), Some(ast.Exp.RangeDomain(tipe.Z, Checker.zero, sz, loLt = false, hiLt = true)),
                      ast.Exp.Eq(resultT.result, ast.Exp.Apply(resultT, id, ivector(qVar)), exp.args(1)))
                  )))
                } else {
                  if (bitWidth != 0)
                    error(exp.args.head, s"Could not automatically deduce the size is non-negative and is at most ${zMax.value}.")
                  else
                    error(exp.args.head, s"Could not automatically deduce the size is non-negative.")
                  None
                }
            }
          case _ => assign(id, exp)
        }
      case stmt@ast.If(exp, thenBlock, elseBlock) =>
        val ncond = ast.Exp.Not(tipe.B, exp)
        val thenPcOpt =
          if (checkSat("True-Branch", nodeLocMap(exp),
            coneOfInfluence(premises, ivector(exp)) :+ exp,
            genMessage = false, "", "", ""))
            copy(premises = premises + exp).check(thenBlock)
          else None
        val elsePcOpt =
          if (checkSat("False-Branch", nodeLocMap(exp),
            coneOfInfluence(premises, ivector(exp)) :+ ncond,
            genMessage = false, "", "", ""))
            copy(premises = premises + ncond).check(elseBlock)
          else None
        (thenBlock.returnOpt.isEmpty, elseBlock.returnOpt.isEmpty) match {
          case (true, true) => (thenPcOpt, elsePcOpt) match {
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
            case (Some(thenPc), None) => Some(copy(premises = thenPc.cleanup.premises))
            case (None, Some(elsePc)) => Some(copy(premises = elsePc.cleanup.premises))
            case _ => None
          }
          case (true, false) => thenPcOpt match {
            case Some(thenPc) => Some(copy(premises = thenPc.cleanup.premises))
            case _ => None
          }
          case (false, true) => elsePcOpt match {
            case Some(elsePc) => Some(copy(premises = elsePc.cleanup.premises))
            case _ => None
          }
          case (false, false) => None
        }
      case stmt: ast.MethodDecl =>
        val invs = if (stmt.isHelper) ilinkedSetEmpty else invariants
        val effectivePre = invs ++ stmt.contract.requires.exps
        val effectivePost = invs ++ stmt.contract.ensures.exps
        val preLi = nodeLocMap(
          if (stmt.contract.requires.exps.isEmpty) stmt
          else stmt.contract.requires.exps.head)
        hasError =
          !checkSat("Effective Pre-condition", preLi,
            effectiveSatFacts ++ effectivePre, genMessage = true,
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
          !checkSat("Effective Post-condition", postLi,
            effectiveSatFacts ++ effectivePost, genMessage = true,
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
        val stmtLine = nodeLocMap(stmt).lineBegin
        var newOldIdLineMaps = oldIdLineMap.map(p => (p._1, (stmtLine, stmtLine)))
        for (id <- stmt.contract.modifies.ids) {
          newOldIdLineMaps += id -> (stmtLine, stmtLine)
        }
        for (p <- stmt.params) {
          val line = nodeLocMap(p.id).lineBegin
          newOldIdLineMaps += p.id -> (line, line)
        }
        copy(premises = ilinkedSetEmpty ++ effectivePre ++ mods,
          mdOpt = Some(stmt), oldIdLineMap = newOldIdLineMaps).
          check(stmt.block, checkReturn = true)
        Some(this.cleanup)
      case ast.InvStmt(inv) =>
        val ps = premises ++ facts.values
        for (e <- inv.exps)
          if (!isValid("Global Invariant", nodeLocMap(e), ps, ivector(e))) {
            error(e, s"Could not automatically deduce the global invariant.")
            hasError = true
          }
        if (hasError)
          checkSat("Global Invariant", nodeLocMap(stmt),
            effectiveSatFacts ++ inv.exps, genMessage = true,
            unsatMsg = s"The global invariant(s) are unsatisfiable.",
            unknownMsg = s"The global invariant(s) might not be satisfiable.",
            timeoutMsg = s"Could not check satisfiability of the global invariant(s) due to timeout.")
        Some(copy(invariants = invariants ++ inv.exps))
      case _: ast.FactStmt => Some(this)
      case stmt@ast.While(exp, loopBlock, loopInv) =>
        val es = loopInv.invariant.exps
        val lps = premises ++ facts.values
        val ncond = ast.Exp.Not(tipe.B, exp)
        for (e <- es)
          if (!isValid("Loop Invariant (beginning)", nodeLocMap(e), lps, ivector(e))) {
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
        if (!checkSat("True-Branch", nodeLocMap(exp),
          coneOfInfluence(lps, ivector(exp)) :+ exp, genMessage = false, "", "", "")) {
          warn(exp, s"The loop condition is always false, thus, the loop body will never be executed.")
        }
        if (!ast.AstUtil.hasReturn(loopBlock) &&
          !checkSat("False-Branch", nodeLocMap(exp),
            coneOfInfluence(ps, ivector(exp)) :+ ncond, genMessage = false, "", "", "")) {
          error(exp, s"The loop condition is always true, thus, the loop will never exit.")
        }
        var pc2 = this
        for (id <- loopInv.modifies.ids) {
          pc2 = pc2.defOldId(id, nodeLocMap(id).lineBegin)._1
        }
        pc2.copy(premises = ps + exp).check(loopBlock) match {
          case Some(pc3) =>
            hasError = hasError || pc3.hasRuntimeError(stmt)
            val ps2 = pc3.premises ++ pc3.facts.values
            for (e <- es)
              if (!isValid("Loop Invariant (end)", nodeLocMap(e), ps2, ivector(e))) {
                error(e, s"Could not deduce the loop invariant at the end of the loop.")
                hasError = true
              }
          case _ =>
        }
        Some(pc2.copy(premises = ps + ncond))
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

  def invoke(a: ast.Apply, lhsOpt: Option[ast.Id]): SummarizingSymExeProofContext = {
    val Some(Left(md)) = a.declOpt
    var invs = ivectorEmpty[ast.Exp]
    val modIds = md.contract.modifies.ids.map(_.value).toSet
    for (inv <- invariants if !md.isHelper) {
      var mod = false
      Visitor.build({
        case id: ast.Id =>
          if (modIds.contains(id.value))
            mod = true
          false
      })(inv)
      if (mod) invs :+= inv
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
    var postSubstMap = md.params.map(_.id).zip(a.args.map(subst(_, psm))).toMap[ast.Node, ast.Node]
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
    make(premises =
      premises.map(e => subst(e, premiseSubstMap)) ++ invs ++
        md.contract.ensures.exps.map(e => subst(e, postSubstMap))).
      copy(oldIdLineMap = pc2.oldIdLineMap)
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
