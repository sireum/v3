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

private object UnrollingSymExeProofContext {
  private val varCounter = new scala.util.DynamicVariable(mmapEmpty[String, Natural])

  sealed trait Status

  object Normal extends Status

  final case class Return(stmt: ast.Stmt) extends Status

  final case class Error(stmt: ast.Stmt) extends Status

  final case class Infeasible(stmt: ast.Stmt) extends Status

  final case class BoundExhaustion(stmt: ast.Stmt) extends Status

  private def isNormal(pc: UnrollingSymExeProofContext): Boolean =
    pc.status == Normal
}

import UnrollingSymExeProofContext._

private final case class
UnrollingSymExeProofContext(unitNode: ast.Program,
                            timeoutInMs: PosInteger,
                            checkSatEnabled: Boolean,
                            hintEnabled: Boolean,
                            inscribeSummoningsEnabled: Boolean,
                            coneInfluenceEnabled: Boolean,
                            bitWidth: Natural,
                            facts: IMap[String, ast.Exp],
                            status: UnrollingSymExeProofContext.Status = UnrollingSymExeProofContext.Normal,
                            schedule: ISeq[(PosInteger, Natural)] = ivectorEmpty,
                            invariants: ILinkedSet[ast.Exp] = ilinkedSetEmpty,
                            premises: ILinkedSet[ast.Exp] = ilinkedSetEmpty,
                            vars: ISet[String] = isetEmpty,
                            provedSteps: IMap[Natural, ast.ProofStep] = imapEmpty,
                            declaredStepNumbers: IMap[Natural, LocationInfo] = imapEmpty,
                            mdOpt: Option[ast.MethodDecl] = None,
                            satFacts: Boolean = true,
                            stmtBound: CMap[ast.Stmt, Int] = midmapEmpty,
                            loopBound: Natural = 10,
                            recursionBound: Natural = 10,
                            useMethodContract: Boolean = true,
                            store: eval.Eval.Store = imapEmpty)
                           (implicit reporter: AccumulatingTagReporter)
  extends SymExeProofContext[UnrollingSymExeProofContext] {

  def check: Boolean = {
    varCounter.withValue(mmapEmpty) {
      val initPcOpt = init
      if (initPcOpt.isEmpty) return false
      val r = initPcOpt.get.check(unitNode.block)
      import java.io._
      val sw = new StringWriter
      val pw = new PrintWriter(sw)
      pw.println(s"Unrolling SymExe Path Statistics")
      pw.println(s"Normal: ${r.count(_.status == Normal)}")
      pw.println(s"Return: ${r.count(_.status.isInstanceOf[Return])}")
      pw.println(s"Error: ${r.count(_.status.isInstanceOf[Error])}")
      pw.println(s"Bound Exhaustion: ${r.count(_.status.isInstanceOf[BoundExhaustion])}")
      reporter.report(InfoMessage("usymexe", sw.toString))
      //      for (c <- r) {
      //        println(c.status)
      //        for (p <- c.premises) {
      //          val sb = new StringBuilder
      //          p.buildString(sb, inProof = true)
      //          println(sb.toString)
      //        }
      //        println()
      //      }
      r.forall(c => c.status == Normal || c.status.isInstanceOf[Return])
    }
  }

  def check(line: Natural): Boolean = {
    val nodeLocMap = unitNode.nodeLocMap
    unitNode.block.stmts.find({
      case md: ast.MethodDecl =>
        val li = nodeLocMap(md)
        if (li.lineBegin <= line && line <= li.lineEnd) true
        else false
      case _ => false
    }) match {
      case Some(md: ast.MethodDecl) =>
        varCounter.withValue(mmapEmpty) {
          val initPcOpt = init
          if (initPcOpt.isEmpty) return false
          initPcOpt.get.check(md).
            forall(_.status == Normal)
        }
      case _ => check
    }
  }

  def bound(stmt: ast.Stmt, isLoop: Boolean): Option[UnrollingSymExeProofContext] = {
    val m = stmtBound.asInstanceOf[MIdMap[ast.Stmt, Natural]].clone()
    stmtBound.get(stmt) match {
      case Some(n) =>
        if (isLoop) {
          if (n <= loopBound) {
            m(stmt) = n + 1
            Some(copy(stmtBound = m))
          } else None
        } else {
          if (n <= recursionBound) {
            m(stmt) = n + 1
            Some(copy(stmtBound = m))
          } else None
        }
      case _ =>
        m(stmt) = 1
        Some(copy(stmtBound = m))
    }
  }

  def init: Option[UnrollingSymExeProofContext] = {
    val (isSat, ok) = checkSatFacts
    if (!ok) return None
    Some(copy(satFacts = isSat))
  }

  def check(stmt: ast.MethodDecl): ISeq[UnrollingSymExeProofContext] = {
    val invs = if (stmt.isHelper) ilinkedSetEmpty else invariants
    val effectivePre = invs ++ stmt.contract.requires.exps
    val effectivePost = invs ++ stmt.contract.ensures.exps
    val preLi = nodeLocMap(
      if (stmt.contract.requires.exps.isEmpty) stmt
      else stmt.contract.requires.exps.head)
    val effectiveSatFacts = if (satFacts) facts.values else ivectorEmpty
    var hasError =
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
      )
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
      )
    if (hasError) return ivector(updateStatus(Error(stmt)))
    val modifiedIds = stmt.contract.modifies.ids.toSet
    val mods = modifiedIds.map(id => ast.Exp.Eq(id.tipe, id, ast.Exp.Id(id.tipe, id.value + "_in")))
    copy(premises = ilinkedSetEmpty ++ effectivePre ++ mods,
      mdOpt = Some(stmt)).check(stmt.block, checkReturn = true)
  }

  def check(block: ast.Block, checkReturn: Boolean = false): ISeq[UnrollingSymExeProofContext] = {
    var r = ivectorEmpty[UnrollingSymExeProofContext]
    var pcs: GenSeq[UnrollingSymExeProofContext] = ivector(this).par
    for (stmt <- block.stmts) {
      val vc = varCounter.value
      val (next, done) = (for (pc <- pcs) yield {
        varCounter.withValue(vc) {
          if (stmt.isInstanceOf[ast.ProofStmt]) pc.check(stmt)
          else pc.cleanup.check(stmt)
        }
      }).flatten.partition(isNormal)
      pcs = next
      r ++= done
    }
    block.returnOpt match {
      case Some(ret) =>
        r = r ++ (for (pc <- pcs) yield pc.checkPostCondition(nodeLocMap(ret), ret.expOpt))
      case _ =>
        if (checkReturn) {
          val li = nodeLocMap(block)
          val newLi = li.copy(
            lineBegin = li.lineEnd,
            columnBegin = li.columnEnd - 1,
            offset = li.offset + li.length - 1,
            length = 1)
          r = r ++ (for (pc <- pcs) yield pc.checkPostCondition(newLi, None))
        } else r = r ++ pcs
    }
    r
  }

  def checkPostCondition(li: LocationInfo, retExpOpt: Option[ast.Exp]): UnrollingSymExeProofContext = {
    assert(mdOpt.isDefined)
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
    var hasError = false
    val ps = premises ++ facts.values
    for (e <- modifiedInvariants)
      if (!isValid(s"Global Invariant", li, ps, ivector(e))) {
        val eLi = nodeLocMap(e)
        error(li, s"Could not automatically deduce the global invariant specified at [${eLi.lineBegin}, ${eLi.columnBegin}].")
        hasError = true
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
        hasError = true
      }
    if (hasError) updateStatus(Error(md))
    else updateStatus(Return(md))
  }

  def updateStatus(s: Status): UnrollingSymExeProofContext = copy(status = s)

  def check(stmt: ast.Stmt): ISeq[UnrollingSymExeProofContext] = {
    val effectiveSatFacts = if (satFacts) facts.values else ivectorEmpty
    if (!stmt.isInstanceOf[ast.ProofElementStmt] &&
      !stmt.isInstanceOf[ast.MethodDecl]) {
      if (hasRuntimeError(stmt))
        return ivector(updateStatus(Error(stmt)))
    }
    stmt match {
      case ast.ProofStmt(proof) =>
        check(proof).map(_.copy(
          premises = filter(premises ++ extractClaims(proof, reverse = false)),
          provedSteps = imapEmpty)).toVector
      case ast.SequentStmt(sequent) =>
        if (sequent.premises.nonEmpty) {
          if (!isValid("Sequent Premises", nodeLocMap(stmt), premises, sequent.premises)) {
            error(stmt, "Could not automatically deduce the specified sequent's premises.")
            return ivector(updateStatus(Error(stmt)))
          }
          if (sequent.conclusions == topConclusion)
            ivector(copy(premises = ilinkedSetEmpty ++ sequent.premises))
          else {
            if (!isValid("Sequent Conclusions", nodeLocMap(stmt), sequent.premises, sequent.conclusions)) {
              error(stmt, "Could not automatically deduce the specified sequent's conclusions from its premises.")
              return ivector(updateStatus(Error(stmt)))
            }
            ivector(copy(premises = filter(premises ++ sequent.premises ++ sequent.conclusions)))
          }
        } else if (sequent.conclusions == topConclusion) {
          ivector(copy(premises = ilinkedSetEmpty))
        } else {
          if (!isValid("Sequent Conclusions", nodeLocMap(stmt), premises ++ facts.values, sequent.conclusions)) {
            error(stmt, "Could not automatically deduce the specified sequent's conclusions.")
            return ivector(updateStatus(Error(stmt)))
          }
          ivector(copy(premises = filter(premises ++ sequent.conclusions)))
        }
      case ast.Assert(e) =>
        if (!isValid("Assertion", nodeLocMap(stmt), premises ++ facts.values, ivector(e))) {
          error(stmt, s"Could not automatically deduce the assertion validity.")
          checkSat("Assertion", nodeLocMap(stmt), premises ++ effectiveSatFacts + e, genMessage = true,
            unsatMsg = s"The assertion is unsatisfiable.",
            unknownMsg = s"The assertion might not be satisfiable.",
            timeoutMsg = s"Could not check satisfiability of the assertion due to timeout.")
          return ivector(updateStatus(Error(stmt)))
        }
        ivector(copy(premises = premises + e))
      case ast.Assume(e) =>
        eval.Eval.evalExp(store)(e) match {
          case Some(eval.Eval.Value(_, true)) =>
          case _ =>
            if (!checkSat("Assumption", nodeLocMap(stmt), premises ++ effectiveSatFacts + e, genMessage = true,
              unsatMsg = s"The assumption is unsatisfiable.",
              unknownMsg = s"The assumption might not be satisfiable.",
              timeoutMsg = s"Could not check satisfiability of the assumption due to timeout."
            )) {
              return ivector(updateStatus(Infeasible(stmt)))
            }
        }
        ivector(copy(premises = premises + e))
      case ast.SeqAssign(id, index, exp) =>
        val old = oldId(id)
        val m = imapEmpty[ast.Node, ast.Node] + (id -> old)
        eval.Eval.assignSeq(store)(id, index, exp) match {
          case Some((store2, ms, _)) =>
            ivector(copy(premises =
              premises.map(e => subst(e, m)) + ast.Exp.Eq(id.tipe, id, eval.Eval.toLit(bitWidth, ms)),
              store = store2))
          case _ =>
            val t = id.tipe.asInstanceOf[tipe.Fn].result
            import ast.Exp
            val qVar = Exp.Id(tipe.Z, "q_i")
            ivector(copy(premises =
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
                ), store = store - id.value))
        }
      case ast.ExpStmt(exp) => ivector(invoke(exp, None))
      case a: ast.VarAssign =>
        val id = a.id
        val exp = a.exp
        exp match {
          case _: ast.ReadInt => assign(id)
          case _: ast.RandomInt => assign(id)
          case _: ast.Random => assign(id)
          case exp: ast.Clone => assign(id, exp.id)
          case exp: ast.Apply if !exp.expTipe.isInstanceOf[tipe.MSeq] =>
            ivector(invoke(exp, Some(id)))
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
                    ast.ForAll(ivector(qVar), Some(ast.RangeDomain(Checker.zero, sz, loLt = false, hiLt = true)),
                      ast.Exp.Eq(resultT.result, ast.Exp.Apply(resultT, id, ivector(qVar)), exp.args(1)))
                  )))
                } else {
                  if (bitWidth != 0)
                    error(exp.args.head, s"Could not automatically deduce the size is non-negative and is at most ${zMax.value}.")
                  else
                    error(exp.args.head, s"Could not automatically deduce the size is non-negative.")
                  ivectorEmpty
                }
            }
          case _ => assign(id, exp)
        }
      case ast.If(exp, thenBlock, elseBlock) =>
        val expSimplified = eval.Eval.simplify(bitWidth, store)(exp)
        val ps = premises ++ facts.values
        val negExpSimplified = eval.Eval.simplify(bitWidth, store)(ast.Exp.Not(tipe.B, expSimplified))
        val tcs =
          if (checkSat("True-Branch", nodeLocMap(exp),
            coneOfInfluence(ps, ivector(expSimplified)) :+ expSimplified, genMessage = false, "", "", ""))
            copy(premises = premises + expSimplified).check(thenBlock)
          else ivectorEmpty
        val fcs =
          if (checkSat("False-Branch", nodeLocMap(exp),
            coneOfInfluence(ps, ivector(negExpSimplified)) :+ negExpSimplified, genMessage = false, "", "", ""))
            copy(premises = premises + negExpSimplified).check(elseBlock)
          else ivectorEmpty
        tcs ++ fcs
      case _: ast.MethodDecl => ivector(this)
      case ast.InvStmt(inv) =>
        val ps = premises ++ facts.values
        var hasError = false
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
        if (hasError) ivector(updateStatus(Error(stmt)))
        else ivector(copy(invariants = invariants ++ inv.exps))
      case _: ast.FactStmt => ivector(this)
      case ast.While(exp, loopBlock, loopInv) =>
        val es = loopInv.invariant.exps
        val ps = premises ++ facts.values

        def checkLoopInv(): Boolean = {
          var hasError = true
          for (e <- es)
            if (!isValid("Loop Invariant", nodeLocMap(e), ps, ivector(e))) {
              error(e, s"Could not automatically deduce the loop invariant.")
              hasError = true
            }
          !hasError
        }

        if (checkLoopInv()) return ivector(updateStatus(Error(stmt)))
        val expSimplified = eval.Eval.simplify(bitWidth, store)(exp)
        val negExpSimplified = eval.Eval.simplify(bitWidth, store)(ast.Exp.Not(tipe.B, expSimplified))
        lazy val cond = premises + expSimplified
        lazy val ncond = premises + negExpSimplified
        val (loop, exit) =
          (checkSat("True-Branch", nodeLocMap(exp),
            coneOfInfluence(ps, ivector(expSimplified)) :+ expSimplified, genMessage = false, "", "", ""),
            checkSat("False-Branch", nodeLocMap(exp),
              coneOfInfluence(ps, ivector(negExpSimplified)) :+ negExpSimplified, genMessage = false, "", "", ""))
        (loop, exit) match {
          case (true, true) =>
            bound(stmt, isLoop = true) match {
              case Some(pc2) =>
                val (next, done) = pc2.copy(premises = cond).check(loopBlock).partition(isNormal)
                val tcs = next.flatMap(_.check(stmt))
                val fc = copy(premises = ncond)
                (done ++ tcs) :+ fc
              case _ =>
                warn(stmt, "Loop-bound exhausted.")
                ivector(copy(premises = cond).updateStatus(BoundExhaustion(stmt)),
                  copy(premises = ncond))
            }
          case (true, false) =>
            bound(stmt, isLoop = true) match {
              case Some(pc2) =>
                val (next, done) = pc2.copy(premises = cond).check(loopBlock).partition(isNormal)
                done ++ next.flatMap(_.check(stmt))
              case _ =>
                warn(stmt, "Loop-bound exhausted.")
                ivector(copy(premises = cond).updateStatus(BoundExhaustion(stmt)))
            }
          case (false, true) =>
            ivector(copy(premises = ncond))
          case (false, false) =>
            ivectorEmpty
        }
      case _: ast.Print => ivector(this)
    }
  }

  def assign(id: ast.Id, exp: ast.Exp): ISeq[UnrollingSymExeProofContext] = {
    val sst = expRewriter(Map[ast.Node, ast.Node](id -> oldId(id)))
    eval.Eval.assignVar(store)(id.value, exp) match {
      case Some((store2, v)) =>
        ivector(copy(premises = premises.map(sst) +
          ast.Exp.Eq(id.tipe, id, eval.Eval.toLit(bitWidth, v)), store = store2))
      case _ =>
        ivector(copy(premises = premises.map(sst) +
          ast.Exp.Eq(id.tipe, id, sst(eval.Eval.simplify(bitWidth, store)(exp))),
          store = store - id.value))
    }
  }

  def assign(id: ast.Id): ISeq[UnrollingSymExeProofContext] = {
    val sst = expRewriter(Map[ast.Node, ast.Node](id -> oldId(id)))
    ivector(copy(premises = premises.map(sst), store = store - id.value))
  }

  def invoke(a: ast.Apply, lhsOpt: Option[ast.Id]): UnrollingSymExeProofContext = {
    val Some(Left(md)) = a.declOpt
    var postSubstMap = md.params.map(_.id).zip(a.args).toMap[ast.Node, ast.Node]
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
    val (lhs, psm) = lhsOpt match {
      case Some(x) =>
        (x, imapEmpty[ast.Node, ast.Node] + (x -> oldId(x)))
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
      val arg_old = oldId(arg)
      val p_in = ast.Exp.Id(p.tipe, p.value + "_in")
      premiseSubstMap += arg -> arg_old
      postSubstMap += arg -> arg_old
      postSubstMap += p -> arg
      postSubstMap += p_in -> oldId(arg)
    }
    for (g <- md.contract.modifies.ids if !modParams.contains(g.value)) {
      val g_old = oldId(g)
      val g_in = ast.Exp.Id(g.tipe, g.value + "_in")
      premiseSubstMap += g -> g_old
      postSubstMap += g_in -> g_old
    }
    make(premises =
      premises.map(e => subst(e, premiseSubstMap)) ++ invs ++
        md.contract.ensures.exps.map(e => subst(e, postSubstMap)))
  }

  def cleanup: UnrollingSymExeProofContext =
    copy(premises = rewriteOld(filter(premises)),
      provedSteps = imapEmpty, declaredStepNumbers = imapEmpty)

  def rewriteOld(premises: ILinkedSet[ast.Exp]): ILinkedSet[ast.Exp] = {
    val m = mmapEmpty[String, Natural]
    var r = ilinkedSetEmpty[ast.Exp]
    for (e <- premises) {
      r += ast.Rewriter.build[ast.Exp](TraversalMode.BOTTOM_UP)({
        case idOld@ast.Id(value) if value.endsWith("_old") =>
          val name = value.substring(0, value.length - 4)
          val n = m.get(name) match {
            case Some(c) => c
            case None =>
              var c = 0
              varCounter.synchronized {
                c = varCounter.value.getOrElseUpdate(name, 0)
                varCounter.value(name) = c + 1
              }
              m(name) = c
              c
          }
          ast.Exp.Id(idOld.tipe, s"${name}_$n")
      })(e)
    }
    r
  }

  override def check(step: ast.RegularStep): Option[UnrollingSymExeProofContext] = {
    val num = step.num.value
    step match {
      case ast.Premise(_, exp) =>
        if (premises.contains(exp) || exp == Checker.top) addProvedStep(step)
        else if (deduce(num, exp, ivectorEmpty, isAuto = true)) addProvedStep(step)
        else error(exp, s"Could not find the claimed premise in step #$num.")
      case _ => super.check(step)
    }
  }

  def oldId(id: ast.Id): ast.Id = ast.Exp.Id(id.tipe, s"${id.value}_old")

  def make(vars: ISet[String],
           provedSteps: IMap[Natural, ast.ProofStep],
           declaredStepNumbers: IMap[Natural, LocationInfo],
           premises: ILinkedSet[ast.Exp]): UnrollingSymExeProofContext =
    copy(vars = vars, provedSteps = provedSteps,
      declaredStepNumbers = declaredStepNumbers, premises = premises)
}
