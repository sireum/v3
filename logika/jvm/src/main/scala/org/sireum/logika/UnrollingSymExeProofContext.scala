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
import org.sireum.util.Rewriter.TraversalMode
import org.sireum.util._

private object UnrollingSymExeProofContext {
  private val varCounter = new scala.util.DynamicVariable(mmapEmpty[String, Natural])

  sealed trait Status

  object Normal extends Status

  final case class Return(stmt: Stmt) extends Status

  final case class Error(stmt: Stmt) extends Status

  final case class Infeasible(stmt: Stmt) extends Status

  final case class BoundExhaustion(stmt: Stmt) extends Status

  private def isNormal(pc: UnrollingSymExeProofContext): Boolean =
    pc.status == Normal
}

import UnrollingSymExeProofContext._

private final case class
UnrollingSymExeProofContext(unitNode: Program,
                            autoEnabled: Boolean,
                            timeoutInMs: Int,
                            checkSat: Boolean,
                            hintEnabled: Boolean,
                            inscribeSummoningsEnabled: Boolean,
                            coneInfluenceEnabled: Boolean,
                            bitWidth: Int,
                            status: UnrollingSymExeProofContext.Status = UnrollingSymExeProofContext.Normal,
                            schedule: ISeq[(Int, Int)] = ivectorEmpty,
                            invariants: ILinkedSet[Exp] = ilinkedSetEmpty,
                            premises: ILinkedSet[Exp] = ilinkedSetEmpty,
                            vars: ISet[String] = isetEmpty,
                            facts: IMap[String, Exp] = imapEmpty,
                            provedSteps: IMap[Natural, ProofStep] = imapEmpty,
                            declaredStepNumbers: IMap[Natural, LocationInfo] = imapEmpty,
                            inMethod: Boolean = false,
                            satFacts: Boolean = true,
                            stmtBound: CMap[Stmt, Int] = midmapEmpty,
                            loopBound: Int = 10,
                            recursionBound: Int = 10,
                            useMethodContract: Boolean = true,
                            store: eval.Eval.Store = imapEmpty)
                           (implicit reporter: AccumulatingTagReporter)
  extends ProofContext[UnrollingSymExeProofContext] {
  val isSymExe = true
  var validCache = imapEmpty[(ISeq[Exp], ISeq[Exp]), Boolean]
  val unboundedBitWidth = bitWidth == 0
  lazy val zMin = IntMin(bitWidth, ZType())
  lazy val zMax = IntMax(bitWidth, ZType())
  val z8Min = IntMin(8, Z8Type())
  val z8Max = IntMax(8, Z8Type())
  val z16Min = IntMin(16, Z16Type())
  val z16Max = IntMax(16, Z16Type())
  val z32Min = IntMin(32, Z32Type())
  val z32Max = IntMax(32, Z32Type())
  val z64Min = IntMin(64, Z64Type())
  val z64Max = IntMax(64, Z64Type())
  val nMin = Checker.zero
  lazy val nMax = IntMax(bitWidth, NType())
  val n8Max = IntMax(8, N8Type())
  val n16Max = IntMax(16, N16Type())
  val n32Max = IntMax(32, N32Type())
  val n64Max = IntMax(64, N64Type())
  val topConclusion = ivector(Checker.top)

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

  def check(line: Int): Boolean = {
    val nodeLocMap = unitNode.nodeLocMap
    unitNode.block.stmts.find({
      case md: MethodDecl =>
        val li = nodeLocMap(md)
        if (li.lineBegin <= line && line <= li.lineEnd) true
        else false
      case _ => false
    }) match {
      case Some(md: MethodDecl) =>
        varCounter.withValue(mmapEmpty) {
          val initPcOpt = init
          if (initPcOpt.isEmpty) return false
          initPcOpt.get.check(md).
            forall(_.status == Normal)
        }
      case _ => check
    }
  }

  override def isValid(title: String, li: LocationInfo,
                       premises: => Iterable[Exp], conclusions: Iterable[Exp]): Boolean = {
    val cs = conclusions.toVector.map(eval.Eval.simplify(bitWidth, store))
    if (cs.forall({
      case BooleanLit(true) => true
      case _ => false
    })) return true
    val key = (premises.toVector, cs)
    validCache.get(key) match {
      case Some(r) => r
      case _ =>
        val r = super.isValid(title, li, premises, cs)
        validCache += key -> r
        r
    }
  }

  override def hasRuntimeError(stmt: Stmt): Boolean = {
    var _ps: Option[ISeq[Exp]] = None
    def ps: ISeq[Exp] = {
      if (_ps.isDefined) return _ps.get
      def rwQuant(q: Quant[_], apply: (Node.Seq[Id], Option[QuantDomain], Exp) => Quant[_],
                  ids: Node.Seq[Id], qdOpt: Option[QuantDomain], e: Exp, t: Type): Quant[_] = t match {
        case _: ZType if bitWidth != 0 => ForAll(ids, qdOpt, Implies(And(Le(zMin, e), Le(e, zMax)), e))
        case _: Z8Type => ForAll(ids, qdOpt, Implies(And(Le(z8Min, e), Le(e, z8Max)), e))
        case _: Z16Type => ForAll(ids, qdOpt, Implies(And(Le(z16Min, e), Le(e, z16Max)), e))
        case _: Z32Type => ForAll(ids, qdOpt, Implies(And(Le(z32Min, e), Le(e, z32Max)), e))
        case _: Z64Type => ForAll(ids, qdOpt, Implies(And(Le(z64Min, e), Le(e, z64Max)), e))
        case _: NType =>
          if (bitWidth == 0) ForAll(ids, qdOpt, Implies(Le(nMin, e), e))
          else ForAll(ids, qdOpt, Implies(And(Le(nMin, e), Le(e, nMax)), e))
        case _: N8Type => ForAll(ids, qdOpt, Implies(And(Le(nMin, e), Le(e, n8Max)), e))
        case _: N16Type => ForAll(ids, qdOpt, Implies(And(Le(nMin, e), Le(e, n16Max)), e))
        case _: N32Type => ForAll(ids, qdOpt, Implies(And(Le(nMin, e), Le(e, n32Max)), e))
        case _: N64Type => ForAll(ids, qdOpt, Implies(And(Le(nMin, e), Le(e, n64Max)), e))
        case _ => q
      }
      val rw = ast.Rewriter.build[Exp]()({
        case q@ForAll(ids, qdOpt@Some(TypeDomain(t)), e) => rwQuant(q, ForAll, ids, qdOpt, e, t)
        case q@Exists(ids, qdOpt@Some(TypeDomain(t)), e) => rwQuant(q, Exists, ids, qdOpt, e, t)
      })
      var integralIds = isetEmpty[String]
      var r = ivectorEmpty[Exp]
      val visitor = Visitor.build({
        case id: Id if !integralIds.contains(id.value) && id.tipe.isInstanceOf[tipe.IntegralTipe] =>
          id.tipe match {
            case tipe.Z if bitWidth != 0 => r :+= And(Le(zMin, id), Le(id, zMax))
            case tipe.Z8 => r :+= And(Le(z8Min, id), Le(id, z8Max))
            case tipe.Z16 => r :+= And(Le(z16Min, id), Le(id, z16Max))
            case tipe.Z32 => r :+= And(Le(z32Min, id), Le(id, z32Max))
            case tipe.Z64 => r :+= And(Le(z64Min, id), Le(id, z64Max))
            case tipe.N =>
              if (bitWidth == 0) r :+= Le(nMin, id)
              else r :+= And(Le(nMin, id), Le(id, n8Max))
            case tipe.N8 => r :+= And(Le(nMin, id), Le(id, n8Max))
            case tipe.N16 => r :+= And(Le(nMin, id), Le(id, n16Max))
            case tipe.N32 => r :+= And(Le(nMin, id), Le(id, n32Max))
            case tipe.N64 => r :+= And(Le(nMin, id), Le(id, n64Max))
            case _ =>
          }
          integralIds += id.value
          false
      })
      for (p <- facts.values.toVector ++ premises) {
        r :+= rw(p)
        visitor(p)
      }
      _ps = Some(r)
      r
    }
    var hasError = false
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
      if (!isValid("division", nodeLocMap(e), ps, ivector(req))) {
        error(e, s"Could not automatically deduce that the divisor is non-zero.")
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
      if (!isValid("indexing low-bound", nodeLocMap(e), ps, ivector(req1))) {
        hasError = true
        error(e, "Could not automatically deduce that the sequence index is non-negative.")
      }
      if (!isValid("indexing high-bound", nodeLocMap(e), ps, ivector(req2))) {
        hasError = true
        error(e, s"Could not automatically deduce that the index is less than the sequence size.")
      }
      true
    }
    def rangeCheck(ts: String, e: Exp, min: Exp, max: Exp): Unit = {
      val es = {
        val sb = new StringBuilder
        e.buildString(sb, inProof = false)
        sb.toString
      }
      val lReq = Le(min, e)
      if (!isValid(s"$ts.Min ≤ $es", nodeLocMap(e), ps, ivector(lReq))) {
        error(e, s"Could not automatically deduce that the operation does not underflow (${Exp.toString(min, inProof = false)}).")
        hasError = true
      }
      val hReq = Le(e, max)
      if (!isValid(s"$es ≤ $ts.Max", nodeLocMap(e), ps, ivector(hReq))) {
        error(e, s"Could not automatically deduce that the operation does not overflow (${Exp.toString(max, inProof = false)}).")
        hasError = true
      }
    }

    def rangeCheckTipe(e: Exp, t: tipe.Tipe): Unit = {
      import org.sireum.logika.tipe._
      t match {
        case tipe.Z if bitWidth != 0 => rangeCheck("Z", e, zMin, zMax)
        case Z8 => rangeCheck("Z8", e, z8Min, z8Max)
        case Z16 => rangeCheck("Z16", e, z16Min, z16Max)
        case Z32 => rangeCheck("Z32", e, z32Min, z32Max)
        case Z64 => rangeCheck("Z64", e, z64Min, z64Max)
        case tipe.N if bitWidth != 0 => rangeCheck("N", e, nMin, nMax)
        case N8 => rangeCheck("N8", e, nMin, n8Max)
        case N16 => rangeCheck("N16", e, nMin, n16Max)
        case N32 => rangeCheck("N32", e, nMin, n32Max)
        case N64 => rangeCheck("N64", e, nMin, n64Max)
        case _ =>
      }
    }

    def nonNegativeCheck(e: Exp, t: tipe.Tipe): Unit = {
      val es = {
        val sb = new StringBuilder
        e.buildString(sb, inProof = false)
        sb.toString
      }
      val zero = t.asInstanceOf[tipe.ModuloIntegralTipe] match {
        case tipe.S8 => IntLit("0", 8, Some(S8Type()))
        case tipe.S16 => IntLit("0", 16, Some(S16Type()))
        case tipe.S32 => IntLit("0", 32, Some(S32Type()))
        case tipe.S64 => IntLit("0", 64, Some(S64Type()))
        case tipe.U8 => IntLit("0", 8, Some(U8Type()))
        case tipe.U16 => IntLit("0", 16, Some(U16Type()))
        case tipe.U32 => IntLit("0", 32, Some(U32Type()))
        case tipe.U64 => IntLit("0", 64, Some(U64Type()))
      }
      val req = Le(zero, e)
      req.tipe = t
      if (!isValid(s"0 ≤ $es", nodeLocMap(e), ps, ivector(req))) {
        error(e, s"Could not automatically deduce that the shift right-operand is non-negative.")
        hasError = true
      }
    }

    Visitor.build({
      case _: Block => false
      case _: LoopInv => false
      case e: Add => rangeCheckTipe(e, e.tipe); false
      case e: Sub => rangeCheckTipe(e, e.tipe); false
      case e: Mul => rangeCheckTipe(e, e.tipe); false
      case e: Div => rangeCheckTipe(e, e.tipe); divisor(e.right, e.tipe.asInstanceOf[tipe.IntegralTipe]); false
      case e: Rem => rangeCheckTipe(e, e.tipe); divisor(e.right, e.tipe.asInstanceOf[tipe.IntegralTipe]); false
      case e: Minus => rangeCheckTipe(e, e.tipe); false
      case e: Shl => nonNegativeCheck(e.right, e.tipe); false
      case e: Shr => nonNegativeCheck(e.right, e.tipe); false
      case e: UShr => nonNegativeCheck(e.right, e.tipe); false
      case a@Apply(id, Seq(e)) if id.tipe.isInstanceOf[tipe.MSeq] => index(id, e)
      case SeqAssign(id, e, _) => index(id, e)
    })(stmt)
    hasError
  }

  def bound(stmt: Stmt, isLoop: Boolean): Option[UnrollingSymExeProofContext] = {
    val m = stmtBound.asInstanceOf[MIdMap[Stmt, Int]].clone()
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
    )) return None
    Some(copy(facts = facts, satFacts = isSat))
  }

  def check(stmt: MethodDecl): ISeq[UnrollingSymExeProofContext] = {
    val invs = if (stmt.isHelper) ilinkedSetEmpty else invariants
    val effectivePre = invs ++ stmt.contract.requires.exps
    val effectivePost = invs ++ stmt.contract.ensures.exps
    val preLi = nodeLocMap(
      if (stmt.contract.requires.exps.isEmpty) stmt
      else stmt.contract.requires.exps.head)
    val effectiveSatFacts = if (satFacts) facts.values else ivectorEmpty
    var hasError =
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
      )
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
      )
    if (hasError) return ivector(updateStatus(Error(stmt)))
    val modifiedIds = stmt.contract.modifies.ids.toSet
    val mods = modifiedIds.map(id => Eq(id, newId(id.value + "_in", id.tipe)))
    var (pc2s, r) = copy(premises = ilinkedSetEmpty ++ effectivePre ++ mods,
      inMethod = true).check(stmt.block).partition(isNormal)
    for (pc2 <- pc2s) {
      hasError = false
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
      if (hasError) r :+= pc2.updateStatus(Error(stmt))
      else r :+= pc2.updateStatus(Return(stmt))
    }
    r
  }

  def check(block: Block): ISeq[UnrollingSymExeProofContext] = {
    var r = ivectorEmpty[UnrollingSymExeProofContext]
    var pcs: GenSeq[UnrollingSymExeProofContext] = ivector(this).par
    for (stmt <- block.stmts) {
      val vc = varCounter.value
      val (next, done) = (for (pc <- pcs) yield {
        varCounter.withValue(vc) {
          if (stmt.isInstanceOf[ProofStmt]) pc.check(stmt)
          else pc.cleanup.check(stmt)
        }
      }).flatten.partition(isNormal)
      pcs = next
      r ++= done
    }
    r ++ pcs
  }

  def oldId(id: Id): Id = newId(s"${id.value}_old", id.tipe)

  def updateStatus(s: Status): UnrollingSymExeProofContext = copy(status = s)

  def check(stmt: Stmt): ISeq[UnrollingSymExeProofContext] = {
    val effectiveSatFacts = if (satFacts) facts.values else ivectorEmpty
    def mkSize(id: Id): Size = {
      val r = Size(id)
      r.tipe = id.tipe
      r
    }
    if (!stmt.isInstanceOf[ProofElementStmt] &&
      !stmt.isInstanceOf[MethodDecl]) {
      if (hasRuntimeError(stmt))
        return ivector(updateStatus(Error(stmt)))
    }
    stmt match {
      case ProofStmt(proof) =>
        check(proof).map(_.copy(
          premises = filter(premises ++ extractClaims(proof, reverse = false)),
          provedSteps = imapEmpty)).toVector
      case SequentStmt(sequent) =>
        if (sequent.premises.nonEmpty) {
          if (!isValid("sequent premises", nodeLocMap(stmt), premises, sequent.premises)) {
            error(stmt, "Could not automatically deduce the specified sequent's premises.")
            return ivector(updateStatus(Error(stmt)))
          }
          if (sequent.conclusions == topConclusion)
            ivector(copy(premises = ilinkedSetEmpty ++ sequent.premises))
          else {
            if (!isValid("sequent conclusions", nodeLocMap(stmt), sequent.premises, sequent.conclusions)) {
              error(stmt, "Could not automatically deduce the specified sequent's conclusions from its premises.")
              return ivector(updateStatus(Error(stmt)))
            }
            ivector(copy(premises = filter(premises ++ sequent.premises ++ sequent.conclusions)))
          }
        } else if (sequent.conclusions == topConclusion) {
          ivector(copy(premises = ilinkedSetEmpty))
        } else {
          if (!isValid("sequent conclusions", nodeLocMap(stmt), premises ++ facts.values, sequent.conclusions)) {
            error(stmt, "Could not automatically deduce the specified sequent's conclusions.")
            return ivector(updateStatus(Error(stmt)))
          }
          ivector(copy(premises = filter(premises ++ sequent.conclusions)))
        }
      case Assert(e) =>
        if (!isValid("", nodeLocMap(stmt), premises ++ facts.values, ivector(e))) {
          error(stmt, s"Could not automatically deduce the assertion validity.")
          checkSat("", nodeLocMap(stmt), premises ++ effectiveSatFacts + e,
            unsatMsg = s"The assertion is unsatisfiable.",
            unknownMsg = s"The assertion might not be satisfiable.",
            timeoutMsg = s"Could not check satisfiability of the assertion due to timeout.")
          return ivector(updateStatus(Error(stmt)))
        }
        ivector(copy(premises = premises + e))
      case Assume(e) =>
        eval.Eval.evalExp(store)(e) match {
          case Some(true) =>
          case _ =>
            if (!checkSat("", nodeLocMap(stmt), premises ++ effectiveSatFacts + e,
              unsatMsg = s"The assumption is unsatisfiable.",
              unknownMsg = s"The assumption might not be satisfiable.",
              timeoutMsg = s"Could not check satisfiability of the assumption due to timeout."
            )) {
              return ivector(updateStatus(Infeasible(stmt)))
            }
        }
        ivector(copy(premises = premises + e))
      case SeqAssign(id, index, exp) =>
        val old = oldId(id)
        val m = imapEmpty[Node, Node] + (id -> old)
        eval.Eval.assignSeq(store)(id, index, exp) match {
          case Some((store2, ms, v)) =>
            ivector(copy(premises =
              premises.map(e => subst(e, m)) + Eq(id, eval.Eval.toLit(bitWidth, ms)),
              store = store2))
          case _ =>
            val qVar = newId("q_i", tipe.Z)
            ivector(copy(premises =
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
                ), store = store - id.value))
        }
      case ExpStmt(exp) =>
        val (he, pc2) = invoke(exp, None)
        if (he) ivector(pc2.updateStatus(Error(stmt)))
        else ivector(pc2)
      case a: VarAssign =>
        val id = a.id
        val exp = a.exp
        exp match {
          case _: ReadInt => assign(id)
          case _: RandomInt => assign(id)
          case _: Random => assign(id)
          case exp: Clone => assign(id, exp.id)
          case exp: Apply if exp.id.tipe != tipe.ZS =>
            val (he, pc2) = invoke(exp, Some(id))
            if (he) ivector(pc2.updateStatus(Error(stmt)))
            else ivector(pc2)
          case _ => assign(id, exp)
        }
      case If(exp, thenBlock, elseBlock) =>
        val expSimplified = eval.Eval.simplify(bitWidth, store)(exp)
        val ps = premises ++ facts.values
        val negExpSimplified = eval.Eval.simplify(bitWidth, store)(Not(expSimplified))
        val tcs =
          if (util.Z3.checkSat(timeoutInMs, isSymExe = true,
            coneOfInfluence(ps, ivector(expSimplified)) :+ expSimplified: _*)._2 != util.Z3.Unsat)
            copy(premises = premises + expSimplified).check(thenBlock)
          else ivectorEmpty
        val fcs =
          if (util.Z3.checkSat(timeoutInMs, isSymExe = true,
            coneOfInfluence(ps, ivector(negExpSimplified)) :+ negExpSimplified: _*)._2 != util.Z3.Unsat)
            copy(premises = premises + negExpSimplified).check(elseBlock)
          else ivectorEmpty
        tcs ++ fcs
      case stmt: MethodDecl => ivector(this)
      case InvStmt(inv) =>
        val ps = premises ++ facts.values
        var hasError = false
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
        if (hasError) ivector(updateStatus(Error(stmt)))
        else ivector(copy(invariants = invariants ++ inv.exps))
      case _: FactStmt => ivector(this)
      case While(exp, loopBlock, loopInv) =>
        val es = loopInv.invariant.exps
        val ps = premises ++ facts.values
        def checkLoopInv(): Boolean = {
          var hasError = true
          for (e <- es)
            if (!isValid("loop invariant", nodeLocMap(e), ps, ivector(e))) {
              error(e, s"Could not automatically deduce the loop invariant.")
              hasError = true
            }
          !hasError
        }
        if (checkLoopInv()) return ivector(updateStatus(Error(stmt)))
        val expSimplified = eval.Eval.simplify(bitWidth, store)(exp)
        val negExpSimplified = eval.Eval.simplify(bitWidth, store)(Not(expSimplified))
        lazy val cond = premises + expSimplified
        lazy val ncond = premises + negExpSimplified
        val (loop, exit) =
          (util.Z3.checkSat(timeoutInMs, isSymExe = true,
            coneOfInfluence(ps, ivector(expSimplified)) :+ expSimplified: _*)._2 != util.Z3.Unsat,
            util.Z3.checkSat(timeoutInMs, isSymExe = true,
              coneOfInfluence(ps, ivector(negExpSimplified)) :+ negExpSimplified: _*)._2 != util.Z3.Unsat)
        (loop, exit) match {
          case (true, true) =>
            bound(stmt, isLoop = true) match {
              case Some(pc2) =>
                val tcs = pc2.copy(premises = cond).check(loopBlock).flatMap(_.check(stmt))
                val fc = copy(premises = ncond)
                tcs :+ fc
              case _ =>
                warn(stmt, "Loop-bound exhausted.")
                ivector(copy(premises = cond).updateStatus(BoundExhaustion(stmt)),
                  copy(premises = ncond))
            }
          case (true, false) =>
            bound(stmt, isLoop = true) match {
              case Some(pc2) =>
                pc2.copy(premises = cond).check(loopBlock).flatMap(_.check(stmt))
              case _ =>
                warn(stmt, "Loop-bound exhausted.")
                ivector(copy(premises = cond).updateStatus(BoundExhaustion(stmt)))
            }
          case (false, true) =>
            ivector(copy(premises = ncond))
          case (false, false) =>
            ivectorEmpty
        }
      case _: Print => ivector(this)
    }
  }

  def assign(id: Id, exp: Exp): ISeq[UnrollingSymExeProofContext] = {
    val sst = expRewriter(Map[Node, Node](id -> oldId(id)))
    eval.Eval.assignVar(store)(id.value, exp) match {
      case Some((store2, v)) =>
        ivector(copy(premises = premises.map(sst) +
          Eq(id, eval.Eval.toLit(bitWidth, v)), store = store2))
      case _ =>
        ivector(copy(premises = premises.map(sst) +
          Eq(id, sst(eval.Eval.simplify(bitWidth, store)(exp))),
          store = store - id.value))
    }
  }

  def assign(id: Id): ISeq[UnrollingSymExeProofContext] = {
    val sst = expRewriter(Map[Node, Node](id -> oldId(id)))
    ivector(copy(premises = premises.map(sst), store = store - id.value))
  }

  def invoke(a: Apply, lhsOpt: Option[Id]): (Boolean, UnrollingSymExeProofContext) = {
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

  def cleanup: UnrollingSymExeProofContext =
    copy(premises = rewriteOld(filter(premises)),
      provedSteps = imapEmpty, declaredStepNumbers = imapEmpty)

  def rewriteOld(premises: ILinkedSet[Exp]): ILinkedSet[Exp] = {
    val m = mmapEmpty[String, Int]
    var r = ilinkedSetEmpty[Exp]
    for (e <- premises) {
      r += ast.Rewriter.build[Exp](TraversalMode.BOTTOM_UP)({
        case idOld@Id(value) if value.endsWith("_old") =>
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
          newId(s"${name}_$n", idOld.tipe)
      })(e)
    }
    r
  }

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

  override def check(step: RegularStep): Option[UnrollingSymExeProofContext] = {
    val num = step.num.value
    step match {
      case Premise(_, exp) =>
        if (premises.contains(exp) || exp == Checker.top) addProvedStep(step)
        else if (deduce(num, exp, ivectorEmpty, isAuto = true)) addProvedStep(step)
        else error(exp, s"Could not find the claimed premise in step #$num.")
      case _ => super.check(step)
    }
  }

  def make(vars: ISet[String],
           provedSteps: IMap[Natural, ProofStep],
           declaredStepNumbers: IMap[Natural, LocationInfo],
           premises: ILinkedSet[Exp]): UnrollingSymExeProofContext =
    copy(vars = vars, provedSteps = provedSteps,
      declaredStepNumbers = declaredStepNumbers, premises = premises)
}
