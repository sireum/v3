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
import org.sireum.util._

private object SymExeProofContext {
  private val varCounter = new scala.util.DynamicVariable(mmapEmpty[String, Natural])
}

import SymExeProofContext._

private final case class
SymExeProofContext(unitNode: Program,
                   autoEnabled: Boolean,
                   timeoutInMs: Int,
                   checkSat: Boolean,
                   hintEnabled: Boolean,
                   inscribeSummoningsEnabled: Boolean,
                   bitWidth: Int,
                   invariants: ILinkedSet[Exp] = ilinkedSetEmpty,
                   premises: ILinkedSet[Exp] = ilinkedSetEmpty,
                   vars: ISet[String] = isetEmpty,
                   facts: IMap[String, Exp] = imapEmpty,
                   provedSteps: IMap[Natural, ProofStep] = imapEmpty,
                   declaredStepNumbers: IMap[Natural, LocationInfo] = imapEmpty,
                   methodOpt: Option[MethodDecl] = None,
                   satFacts: Boolean = true)
                  (implicit reporter: AccumulatingTagReporter) extends ProofContext[SymExeProofContext] {

  var validCache = imapEmpty[(ISeq[Exp], ISeq[Exp]), Boolean]
  val unboundedBitWidth = bitWidth == 0
  lazy val zMin = IntMin(bitWidth, ZType())
  lazy val zMax = IntMax(bitWidth, ZType())

  override def isValid(title: String, li: LocationInfo,
                       premises: Iterable[Exp], conclusions: Iterable[Exp]): Boolean = {
    val key = (premises.toVector, conclusions.toVector)
    validCache.get(key) match {
      case Some(r) => r
      case _ =>
        val r = super.isValid(title, li, premises, conclusions)
        validCache += key -> r
        r
    }
  }

  override def hasRuntimeError(stmt: Stmt): Boolean = {
    if (super.hasRuntimeError(stmt)) return true
    else if (unboundedBitWidth) return false
    val rw = ast.Rewriter.build[Exp]()({
      case ForAll(ids, Some(TypeDomain(_: ZType)), e) =>
        ForAll(ids, Some(RangeDomain(zMin, zMax, loLt = false, hiLt = false)), e)
      case Exists(ids, Some(TypeDomain(_: ZType)), e) =>
        Exists(ids, Some(RangeDomain(zMin, zMax, loLt = false, hiLt = false)), e)
    })
    var ps = ivectorEmpty[Exp]
    var zIds = isetEmpty[String]
    val visitor = Visitor.build({
      case id: Id if id.tipe == tipe.Z && !zIds.contains(id.value) =>
        ps :+= And(Le(zMin, id), Le(id, zMax))
        zIds += id.value
        false
    })
    for (p <- facts.values.toVector ++ premises) {
      ps :+= rw(p)
      visitor(p)
    }
    var hasError = false
    def boundCheck(n: Node, e: Exp, min: Exp, max: Exp): Boolean = {
      val oldPs = ps
      val oldIds = zIds
      visitor(e)
      val lReq = Le(min, e)
      if (!isValid("Z.Min", nodeLocMap(e), ps, ivector(lReq))) {
        error(n, s"Could not automatically deduce that the operation does not underflow (${Exp.toString(min, inProof = false)}).")
        hasError = true
      }
      val hReq = Le(e, max)
      if (!isValid("Z.Max", nodeLocMap(e), ps, ivector(hReq))) {
        error(n, s"Could not automatically deduce that the operation does not overflow (${Exp.toString(max, inProof = false)}).")
        hasError = true
      }
      ps = oldPs
      zIds = oldIds
      true
    }

    Visitor.build({
      case _: Block => false
      case _: LoopInv => false
      case a: SeqAssign => boundCheck(a, a.exp, zMin, zMax)
      case a: Assign if a.id.tipe == tipe.Z => boundCheck(a, a.exp, zMin, zMax)
      case a: VarDecl if a.id.tipe == tipe.Z => boundCheck(a, a.exp, zMin, zMax)
      case e: Add if e.tipe == tipe.Z => boundCheck(e, e, zMin, zMax)
      case e: Sub if e.tipe == tipe.Z => boundCheck(e, e, zMin, zMax)
      case e: Mul if e.tipe == tipe.Z => boundCheck(e, e, zMin, zMax)
      case e: Div if e.tipe == tipe.Z => boundCheck(e, e, zMin, zMax)
      case e: Rem if e.tipe == tipe.Z => boundCheck(e, e, zMin, zMax)
      case e: Minus if e.tipe == tipe.Z => boundCheck(e, e, zMin, zMax)
    })(stmt)
    hasError
  }

  def check: Boolean = {
    val program = unitNode
    val facts = this.facts ++ program.block.stmts.flatMap(_ match {
      case FactStmt(fs) => fs.factOrFunDecls.flatMap(_ match {
        case f: Fact => Some(f.id.value -> f.exp)
        case _ => None
      })
      case _ => ivectorEmpty
    })
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
    varCounter.withValue(mmapEmpty) {
      copy(facts = facts, satFacts = isSat).check(program.block).isDefined
    }
  }

  def check(block: Block): Option[SymExeProofContext] = {
    var pcOpt: Option[SymExeProofContext] = Some(this)
    for (stmt <- block.stmts if pcOpt.isDefined) {
      val pc =
        if (stmt.isInstanceOf[ProofStmt]) pcOpt.get
        else pcOpt.get.cleanup
      pcOpt = pc.check(stmt)
    }
    pcOpt
  }

  def oldId(id: Id): Id = {
    val c = varCounter.value.getOrElseUpdate(id.value, 0)
    newId(s"${id.value}_$c", id.tipe)
  }

  def check(stmt: Stmt): Option[SymExeProofContext] = {
    def mkSize(id: Id): Size = {
      val r = Size(id)
      r.tipe = id.tipe
      r
    }
    var hasError = false
    if (!stmt.isInstanceOf[ProofElementStmt] &&
      !stmt.isInstanceOf[MethodDecl]) {
      hasError = hasRuntimeError(stmt) || hasError
    }
    val pcOpt = stmt match {
      case ProofStmt(proof) =>
        check(proof) match {
          case Some(pc2) =>
            Some(pc2.copy(
              premises = filter(premises ++ extractClaims(proof, reverse = false)),
              provedSteps = imapEmpty))
          case _ => None
        }
      case SequentStmt(sequent) =>
        if (sequent.premises.nonEmpty) {
          if (!isValid("sequent premises", nodeLocMap(stmt), premises, sequent.premises)) {
            hasError = true
            error(stmt, "Could not automatically deduce the specified sequent's premises.")
          }
          if (!isValid("sequent conclusions", nodeLocMap(stmt), sequent.premises, sequent.conclusions)) {
            hasError = true
            error(stmt, "Could not automatically deduce the specified sequent's conclusions from its premises.")
          }
        } else if (!isValid("sequent conclusions", nodeLocMap(stmt), premises ++ facts.values, sequent.conclusions)) {
          hasError = true
          error(stmt, "Could not automatically deduce the specified sequent's conclusions.")
        }
        Some(copy(premises =
          filter(ilinkedSetEmpty ++ sequent.premises ++ sequent.conclusions)))
      case Assert(e) =>
        if (!isValid("", nodeLocMap(stmt), premises ++ facts.values, ivector(e))) {
          error(stmt, s"Could not automatically deduce the assertion validity.")
          hasError = true
          checkSat("", nodeLocMap(stmt), ivector(e),
            unsatMsg = s"The assertion is unsatisfiable.",
            unknownMsg = s"The assertion might not be satisfiable.",
            timeoutMsg = s"Could not check satisfiability of the assertion due to timeout.")
        }
        Some(copy(premises = premises + e))
      case Assume(e) =>
        hasError = !checkSat("", nodeLocMap(stmt), ivector(e),
          unsatMsg = s"The assumption is unsatisfiable.",
          unknownMsg = s"The assumption might not be satisfiable.",
          timeoutMsg = s"Could not check satisfiability of the assumption due to timeout."
        ) || hasError
        Some(copy(premises = premises + e))
      case SeqAssign(id, index, exp) =>
        val old = oldId(id)
        val m = imapEmpty[Node, Node] + (id -> old)
        val qVar = newId("q_i", tipe.Z)
        Some(copy(premises =
          premises.map(e => subst(e, m)) ++
            ivector(
              Eq(mkSize(id), mkSize(old)),
              Eq(Apply(id, Node.seq(subst(index, m))), subst(exp, m)),
              ForAll(
                Node.seq(qVar),
                Some(RangeDomain(Checker.zero, mkSize(id),
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
        val preLi = nodeLocMap(
          if (stmt.contract.requires.exps.isEmpty) stmt
          else stmt.contract.requires.exps.head)
        hasError =
          !checkSat("effective precondition", preLi,
            (if (satFacts) facts.values else ivectorEmpty) ++ effectivePre,
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
            (if (satFacts) facts.values else ivectorEmpty) ++ effectivePost,
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
        val mods = modifiedIds.map(id => Eq(id, newId(id.value + "_in", id.tipe)))
        copy(premises = ilinkedSetEmpty ++ effectivePre ++ mods, methodOpt = Some(stmt)).
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
            val ps = pc2.premises ++ pc2.facts.values
            for (e <- modifiedInvariants)
              if (!isValid(s"global invariant", nodeLocMap(stmt), ps, ivector(e))) {
                error(e, s"Could not automatically deduce the global invariant at the end of method ${stmt.id.value}.")
                hasError = true
              }
            val post = stmt.contract.ensures.exps
            val postSubstMap = stmt.returnExpOpt match {
              case Some(e) => imapEmpty[Node, Node] + (Result() -> e)
              case _ => imapEmpty[Node, Node]
            }
            for (e <- post)
              if (!isValid("postcondition", nodeLocMap(e), ps, ivector(subst(e, postSubstMap)))) {
                error(e, s"Could not automatically deduce the post-condition of method ${stmt.id.value}.")
                hasError = true
              }
          case _ => hasError = true
        }
        Some(this.cleanup)
      case InvStmt(inv) =>
        val ps = premises ++ facts.values
        for (e <- inv.exps)
          if (!isValid("", nodeLocMap(e), ps, ivector(e))) {
            error(e, s"Could not automatically deduce the global invariant.")
            hasError = true
          }
        if (hasError)
          checkSat("global invariant", nodeLocMap(stmt),
            (if (satFacts) facts.values else ivectorEmpty) ++ inv.exps,
            unsatMsg = s"The global invariant(s) are unsatisfiable.",
            unknownMsg = s"The global invariant(s) might not be satisfiable.",
            timeoutMsg = s"Could not check satisfiability of the global invariant(s) due to timeout.")
        Some(copy(invariants = invariants ++ inv.exps))
      case _: FactStmt => Some(this)
      case While(exp, loopBlock, loopInv) =>
        val es = loopInv.invariant.exps
        val lps = premises ++ facts.values
        for (e <- es)
          if (!isValid("loop invariant (beginning)", nodeLocMap(e), lps, ivector(e))) {
            error(e, s"Could not automatically deduce the loop invariant at the beginning of the loop.")
            hasError = true
          }
        var ps = ilinkedSetEmpty ++ es
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
        copy(premises = ps + exp).
          check(loopBlock) match {
          case Some(pc2) =>
            val ps = pc2.premises ++ pc2.facts.values
            for (e <- es)
              if (!isValid("loop invariant (end)", nodeLocMap(e), ps, ivector(e))) {
                error(e, s"Could not deduce the loop invariant at the end of the loop.")
                hasError = true
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

  def assign(id: Id, exp: Exp): Option[SymExeProofContext] = {
    val sst = expRewriter(Map[Node, Node](id -> oldId(id)))
    Some(copy(premises = premises.map(sst) + Eq(id, sst(exp))))
  }

  def assign(id: Id): Option[SymExeProofContext] = {
    val sst = expRewriter(Map[Node, Node](id -> oldId(id)))
    Some(copy(premises = premises.map(sst)))
  }

  def invoke(a: Apply, lhsOpt: Option[Id]): (Boolean, SymExeProofContext) = {
    var hasError = false
    val md = a.declOpt.get
    var postSubstMap = md.params.map(_.id).zip(a.args).toMap[Node, Node]
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
    val ps = premises ++ facts.values
    for (inv <- invs if methodOpt.isDefined)
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
    val (lhs, psm) = lhsOpt match {
      case Some(x) =>
        (x, imapEmpty[Node, Node] + (x -> oldId(x)))
      case _ =>
        (newId(md.id.value + "_result",
          md.id.tipe.asInstanceOf[tipe.Fn].result),
          imapEmpty[Node, Node])
    }
    var premiseSubstMap = psm
    postSubstMap += Result() -> lhs
    var modParams = isetEmpty[String]
    for ((p, arg@Id(_)) <- md.params.map(_.id).zip(a.args) if modIds.contains(p.value)) {
      modParams += p.value
      val arg_old = oldId(arg)
      val p_in = newId(p.value + "_in", p.tipe)
      premiseSubstMap += arg -> arg_old
      postSubstMap += arg -> arg_old
      postSubstMap += p -> arg
      postSubstMap += p_in -> oldId(arg)
    }
    for (g <- md.contract.modifies.ids if !modParams.contains(g.value)) {
      val g_old = oldId(g)
      val g_in = newId(g.value + "_in", g.tipe)
      premiseSubstMap += g -> g_old
      postSubstMap += g_in -> g_old
    }
    (hasError, make(premises =
      premises.map(e => subst(e, premiseSubstMap)) ++ invs ++
        md.contract.ensures.exps.map(e => subst(e, postSubstMap))
    ))
  }

  def cleanup: SymExeProofContext =
    copy(premises = filter(premises), provedSteps = imapEmpty,
      declaredStepNumbers = imapEmpty)

  def filter(premises: ILinkedSet[Exp]): ILinkedSet[Exp] = {
    def keep(e: Exp) = {
      var r = true
      Visitor.build({
        case Id(value) if value.endsWith("_result") =>
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
           premises: ILinkedSet[Exp]): SymExeProofContext =
    copy(vars = vars, provedSteps = provedSteps,
      declaredStepNumbers = declaredStepNumbers, premises = premises)
}
