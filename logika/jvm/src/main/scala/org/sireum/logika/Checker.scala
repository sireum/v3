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

import org.sireum.logika.message.CheckerKind
import org.sireum.logika.tipe.TypeChecker
import org.sireum.logika.util._
import org.sireum.util.Rewriter.TraversalMode
import org.sireum.util._

object Checker {
  private[logika] final val top = ast.BooleanLit(true)
  private[logika] final val bottom = ast.BooleanLit(false)
  private[logika] final val zero = ast.IntLit("0", 0, None)
  private[logika] final val kind = "Proof Checker"

  final def typeCheck(m: message.Check)(
    implicit reporter: AccumulatingTagReporter): (Boolean, Boolean, Natural, ISeq[ast.UnitNode]) = {
    val isSymExe = m.kind == message.CheckerKind.SummarizingSymExe ||
      m.kind == message.CheckerKind.UnrollingSymExe
    val bitWidth = if (isSymExe) m.bitWidth else 0
    val autoEnabled = m.autoEnabled || isSymExe

    var unitNodes = ivectorEmpty[ast.UnitNode]
    for (message.ProofFile(fileUriOpt, text) <- m.proofs) {
      ast.Builder(fileUriOpt, text, bitWidth, autoEnabled).foreach(unitNodes :+= _)
    }
    if (reporter.hasError) {
      reporter.report(ErrorMessage("AST",
        if (m.proofs.size > 1) "The inputs are ill-formed."
        else "The input is ill-formed."))
      return (true, autoEnabled, bitWidth, unitNodes)
    }
    if (unitNodes.forall(_.isInstanceOf[ast.Program])) {
      val programs = unitNodes.map(_.asInstanceOf[ast.Program])
      if (TypeChecker.check(m.kind == CheckerKind.UnrollingSymExe, bitWidth, programs: _*)) {
        var hasError = false
        for (program <- programs) {
          def symExeOnly(n: ast.Exp): Unit =
            error(program.fileUriOpt, program.nodeLocMap(n), s"${ast.Exp.toString(n, inProof = false)} can only be used in symbolic execution.")

          try Visitor.build({
            case n: ast.TypeMethodCallExp if !isSymExe => symExeOnly(n); throw new RuntimeException
            case n: ast.Random if !isSymExe => symExeOnly(n); throw new RuntimeException
            case t: ast.IntegralType if !t.isInstanceOf[ast.ZType] && !isSymExe =>
              val ts = {
                val sb = new StringBuilder
                t.buildString(sb)
                sb.toString
              }
              error(program.fileUriOpt, program.nodeLocMap(t), s"Type $ts can only be used in symbolic execution.")
              throw new RuntimeException
            case t: ast.SeqType if !t.isInstanceOf[ast.ZSType] && !isSymExe =>
              val ts = {
                val sb = new StringBuilder
                t.buildString(sb)
                sb.toString
              }
              error(program.fileUriOpt, program.nodeLocMap(t), s"Type $ts can only be used in symbolic execution.")
              throw new RuntimeException
          })(program) catch {
            case _: RuntimeException => hasError = true
          }
        }
      }
    }
    if (reporter.hasError) {
      reporter.report(ErrorMessage("AST",
        if (m.proofs.size > 1) "The inputs are ill-formed."
        else "The input is ill-formed."))
      return (true, autoEnabled, bitWidth, unitNodes)
    }
    (reporter.hasError, autoEnabled, bitWidth, unitNodes)
  }

  final def check(m: message.Check)(
    implicit reporter: AccumulatingTagReporter): message.Result = {
    val (hasError, autoEnabled, bitWidth, unitNodes) = typeCheck(m)
    if (hasError) return message.Result(m.requestId, m.isBackground, reporter.tags.toVector)

    if (unitNodes.forall(_.isInstanceOf[ast.Program])) {
      val programs = unitNodes.map(_.asInstanceOf[ast.Program])
      var factMap = imapEmpty[String, ast.Exp]
      for (program <- programs) factMap ++= extractFacts(program)

      if (m.lastOnly)
        check(programs.last, m.kind, autoEnabled, m.timeout, m.checkSatEnabled,
          m.hintEnabled, m.inscribeSummoningsEnabled, m.coneInfluenceEnabled, bitWidth,
          m.loopBound, m.recursionBound, m.useMethodContract, factMap)
      else
        for (program <- programs)
          check(program, m.kind, autoEnabled, m.timeout, m.checkSatEnabled,
            m.hintEnabled, m.inscribeSummoningsEnabled, m.coneInfluenceEnabled, bitWidth,
            m.loopBound, m.recursionBound, m.useMethodContract, factMap)
    } else if (unitNodes.forall(_.isInstanceOf[ast.Sequent])) {
      val sequents = unitNodes.map(_.asInstanceOf[ast.Sequent])
      if (m.lastOnly)
        reporter.report(WarningMessage("AST", "Last mode is only applicable for checking programs."))
      for (sequent <- sequents)
        check(sequent, m.kind, autoEnabled = false, m.timeout, m.checkSatEnabled, m.hintEnabled)
    } else if (unitNodes.forall(_.isInstanceOf[ast.TruthTable])) {
      val truthTables = unitNodes.map(_.asInstanceOf[ast.TruthTable])
      if (m.lastOnly)
        reporter.report(WarningMessage("AST", "Last mode is only applicable for checking programs."))
      for (tt <- truthTables)
        check(tt, m.kind, autoEnabled = false, m.timeout, m.checkSatEnabled, m.hintEnabled)
    } else {
      reporter.report(ErrorMessage("AST", "Cannot check mixed programs/sequents/truth tables."))
    }
    message.Result(m.requestId, m.isBackground, reporter.tags.toVector)
  }

  final def check(unitNode: ast.UnitNode,
                  checkerKind: message.CheckerKind.Value, // kind of checker, using logika CheckerKind enumeration
                  autoEnabled: Boolean = false, // auto mode
                  timeoutInMs: PosInteger = 2000, // time out
                  checkSat: Boolean = false,
                  hintEnabled: Boolean = false, // hints
                  inscribeSummoningsEnabled: Boolean = false, // inscribe summonings
                  coneInfluenceEnabled: Boolean = false,
                  bitWidth: Natural = 0,
                  loopBound: Natural = 10, // loop bound
                  recursionBound: Natural = 10, // recursion bound
                  useMethodContract: Boolean = true,
                  factMap: IMap[String, ast.Exp] = imapEmpty)(
                   implicit reporter: AccumulatingTagReporter): Boolean = unitNode match {
    case tt: ast.TruthTable =>
      check(tt)
    case s: ast.Sequent =>
      assert(s.mode == ast.LogicMode.Propositional ||
        s.mode == ast.LogicMode.Predicate)
      implicit val fileUriOpt = s.fileUriOpt
      // create an empty set of strings to accumlate vars
      var vars = isetEmpty[String]
      // loop over premises and conclusions and find all variables
      // (why?)
      for (e <- s.premises ++ s.conclusions)
        vars ++= collectVars(e)
      s.proofOpt match {
        case Some(proof) =>
          // This AST is a proof, so extract the location map, and identify it as an implicit parameter
          implicit val nodeLocMap = s.nodeLocMap
          // Create a new sequent proof context
          // Why do we make a SequentProofContext here?  Is seems like this decision should be made elsewhere.
          // r is True if there is a proof
          var r = SequentProofContext(s, autoEnabled, timeoutInMs,
            checkSat, hintEnabled, inscribeSummoningsEnabled,
            premises = ilinkedSetEmpty ++ s.premises).
            check(proof).isDefined
          // I don't understand what these last two clauses do
          val exps = proof.steps.flatMap(_ match {
            case s: ast.RegularStep => Some(s.exp)
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
    case program: ast.Program =>
      implicit val fileUriOpt = program.fileUriOpt
      implicit val nodeLocMap = program.nodeLocMap
      var hasProof = false
      Visitor.build({
        case _: ast.SequentStmt => hasProof = true; false
        case _: ast.ProofStmt => hasProof = true; false
        case _: ast.Assert => hasProof = true; false
        case ast.InvStmt(inv) if inv.exps.nonEmpty =>
          hasProof = true; false
        case ast.Requires(exps) if exps.nonEmpty =>
          hasProof = true; false
        case ast.Ensures(exps) if exps.nonEmpty =>
          hasProof = true; false
        case ast.LoopInv(inv, _) if inv.exps.nonEmpty =>
          hasProof = true; false
      })(program)
      if (!hasProof) {
        reporter.report(WarningMessage(kind, "No programming logic proof element found."))
      }
      val r = checkerKind match {
        case message.CheckerKind.Forward =>
          ForwardProofContext(program, autoEnabled, timeoutInMs,
            checkSat, hintEnabled, inscribeSummoningsEnabled, coneInfluenceEnabled, factMap).check
        case message.CheckerKind.Backward =>
          reporter.report(InternalErrorMessage(kind, "Backward mode is unsupported yet."))
          return false
        case message.CheckerKind.SummarizingSymExe =>
          SummarizingSymExeProofContext(program, timeoutInMs,
            checkSat, hintEnabled, inscribeSummoningsEnabled, coneInfluenceEnabled, bitWidth, factMap).check
        case message.CheckerKind.UnrollingSymExe =>
          UnrollingSymExeProofContext(program, timeoutInMs,
            checkSat, hintEnabled, inscribeSummoningsEnabled, coneInfluenceEnabled, bitWidth, factMap,
            loopBound = loopBound, recursionBound = recursionBound,
            useMethodContract = useMethodContract).check
      }
      if (r) {
        if (hasProof)
          reporter.report(InfoMessage(kind, s"Programming logic proof is accepted."))
      } else reporter.report(ErrorMessage(kind, s"Programming logic proof is rejected."))
      r
  }

  def extractFacts(unitNode: ast.Program): IMap[String, ast.Exp] = {
    var m = imapEmpty[String, ast.Exp]
    for (stmt <- unitNode.block.stmts) stmt match {
      case stmt: ast.FactStmt =>
        for (fact <- stmt.fact.factOrFunDecls) fact match {
          case fact: ast.Fact =>
            m += fact.id.value -> fact.exp
          case _ =>
        }
      case _ =>
    }
    m
  }

  def check(tt: ast.TruthTable)(
    implicit reporter: AccumulatingTagReporter): Boolean = {
    val nodeLocMap = tt.nodeLocMap

    def errorH(n: ast.Node, msg: String): Unit =
      error(tt.fileUriOpt, nodeLocMap(n), msg)(reporter)

    var allAssignments = ivectorEmpty[IVector[Boolean]]

    def idValComb(i: Natural, acc: IVector[Boolean]): Unit =
      if (i == tt.ids.length) allAssignments :+= acc
      else {
        idValComb(i + 1, acc :+ true)
        idValComb(i + 1, acc :+ false)
      }

    idValComb(0, ivectorEmpty)
    var (expectedMap, trueAssignments, falseAssignments) = {
      var tAssignments = isetEmpty[IVector[Boolean]]
      var fAssignments = isetEmpty[IVector[Boolean]]
      var result = imapEmpty[IVector[Boolean], IMap[PosInteger, (ast.Exp, Boolean)]]
      for (a <- allAssignments) {
        val assignments = imapEmpty[String, Boolean] ++ tt.ids.map(_.value).zip(a)
        var m = imapEmpty[PosInteger, (ast.Exp, Boolean)]

        def eval(e: ast.Exp): Boolean = {
          val c = nodeLocMap(e).columnBegin
          val r = (e: @unchecked) match {
            case ast.Id(value) => assignments(value)
            case ast.Not(exp) => !eval(exp)
            case ast.And(e1, e2) => eval(e1) & eval(e2)
            case ast.Or(e1, e2) => eval(e1) | eval(e2)
            case ast.Implies(e1, e2) => !eval(e1) | eval(e2)
          }
          m += c -> (e, r)
          r
        }

        if (eval(tt.formula)) {
          tAssignments += a
        } else {
          fAssignments += a
        }
        result += a -> m
      }
      (result, tAssignments, fAssignments)
    }
    val barColumn = nodeLocMap(tt.bar).columnBegin
    for (row <- tt.rows) {
      val rowBarColumn = nodeLocMap(row.bar).columnBegin
      if (rowBarColumn != barColumn) {
        errorH(row.bar, s"Invalid location for | (expecting it to be at column $barColumn instead of $rowBarColumn).")
      }
      val assignments = row.assignments.value.map(_.value)
      var m = expectedMap(assignments)
      expectedMap -= assignments
      var rowHasError = false
      for (value <- row.values if !rowHasError) {
        val c = nodeLocMap(value).columnBegin
        m.get(c) match {
          case Some((_, expectedValue)) =>
            if (expectedValue != value.value) {
              rowHasError = true
              errorH(row, "Some expression values are invalid.")
            }
            m -= c
          case _ =>
            rowHasError = true
            errorH(value, s"Could not find the value's corresponding expression.")
        }
      }
      for ((e, _) <- m.values if !rowHasError) e match {
        case _: ast.Id =>
        case _ =>
          rowHasError = true
          errorH(row, "Missing some expression values.")
      }
    }
    if (expectedMap.nonEmpty) {
      errorH(tt.star, "Some assignments are missing.")
    }

    if (!reporter.hasError)
      tt.statusOpt match {
        case Some(status: ast.TautologyStatus) =>
          if (falseAssignments.nonEmpty) errorH(status, "It is not a Tautology.")
        case Some(status: ast.ContradictoryStatus) =>
          if (trueAssignments.nonEmpty) errorH(status, "It is not Contradictory.")
        case Some(status: ast.ContingentStatus) =>
          if (trueAssignments.isEmpty || falseAssignments.isEmpty)
            errorH(status, "It is not Contingent.")
          else {
            val tContingentAssignments = status.trueAssignments.map(_.value.map(_.value)).toSet
            if (tContingentAssignments != trueAssignments) {
              errorH(status, "Invalid assignments for true.")
            }
            val fContingentAssignments = status.falseAssignments.map(_.value.map(_.value)).toSet
            if (fContingentAssignments != falseAssignments) {
              errorH(status, "Invalid assignments for false.")
            }
          }
        case None =>
          errorH(tt.star, "Expecting Tautology, Contradictory, or Contingent.")
      }

    if (reporter.hasError) reporter.report(ErrorMessage("Truth Table Checker", s"Truth table is rejected."))
    else reporter.report(InfoMessage("Truth Table Checker", s"Truth table is accepted."))

    reporter.hasError
  }

  private[logika] final def collectVars(e: ast.Exp): ISet[String] = {
    var result = isetEmpty[String]
    Visitor.build({
      case ast.Id(value) =>
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

  val mode: ast.LogicMode = unitNode.mode
  val fileUriOpt: Option[FileResourceUri] = unitNode.fileUriOpt
  implicit val nodeLocMap: MIdMap[ast.Node, LocationInfo] = unitNode.nodeLocMap
  val satTimeoutInMs: PosInteger = scala.math.min(timeoutInMs / 2, 500)

  def unitNode: ast.UnitNode

  def premises: ILinkedSet[ast.Exp]

  def vars: ISet[String]

  def provedSteps: IMap[Natural, ast.ProofStep]

  def declaredStepNumbers: IMap[Natural, LocationInfo]

  def timeoutInMs: PosInteger

  def checkSatEnabled: Boolean

  def hintEnabled: Boolean

  def invariants: ILinkedSet[ast.Exp]

  def facts: IMap[String, ast.Exp]

  def autoEnabled: Boolean

  def inscribeSummoningsEnabled: Boolean

  def coneInfluenceEnabled: Boolean

  def isSymExe: Boolean

  def bitWidth: Natural

  def make(vars: ISet[String] = vars,
           provedSteps: IMap[Natural, ast.ProofStep] = provedSteps,
           declaredStepNumbers: IMap[Natural, LocationInfo] = declaredStepNumbers,
           premises: ILinkedSet[ast.Exp] = premises): T

  def extractFact(fun: ast.Fun, fd: ast.FunDef): ast.Exp = {
    val ft = fun.id.tipe.asInstanceOf[tipe.Fn]
    val f = ast.Exp.Apply(ft, fun.id, fun.params.map(_.id))
    var r: ast.Exp = fd.cond match {
      case ast.BooleanLit(true) => ast.Exp.Eq(ft.result, f, fd.exp)
      case ast.BooleanLit(false) => return ast.BooleanLit(true)
      case _ => ast.Exp.Implies(tipe.B, fd.cond, ast.Exp.Eq(ft.result, f, fd.exp))
    }
    for (p <- fun.params.reverse) {
      r = ast.ForAll(ivector(p.id), Some(ast.TypeDomain(p.tpe)), r)
    }
    r
  }

  def extractFact(md: ast.MethodDecl): Option[ast.Exp] = {
    require(md.contract.modifies.ids.isEmpty)
    lazy val post = subst(ast.Exp.And(md.contract.ensures.exps),
      Map[ast.Node, ast.Node](ast.Result() ->
        ast.Exp.Apply(md.id.tipe.asInstanceOf[tipe.Fn], md.id, md.params.map(_.id))))
    val eOpt = (md.contract.requires.exps.nonEmpty, md.contract.ensures.exps.nonEmpty) match {
      case (true, true) =>
        val pre = ast.Exp.And(md.contract.requires.exps)
        Some(ast.Exp.Implies(tipe.B, pre, post))
      case (false, true) =>
        Some(post)
      case (_, false) => None
    }
    for (e <- eOpt) yield {
      var r = e
      for (p <- md.params.reverse) {
        r = ast.ForAll(ivector(p.id), Some(ast.TypeDomain(p.tpe)), r)
      }
      r
    }
  }

  def additionalFacts(es: Iterable[ast.Exp]): ILinkedSet[ast.Exp] = {
    var r = ilinkedSetEmpty[ast.Exp]
    val seen = midmapEmpty[Object, Boolean]
    lazy val v: Any => Boolean = Visitor.build({
      case a: ast.Apply =>
        a.declOpt match {
          case Some(Left(md)) if !seen.contains(md) =>
            seen(md) = true
            for (e <- extractFact(md)) {
              r += e
              v(e)
            }
          case Some(Right(fun)) if !seen.contains(fun) =>
            seen(fun) = true
            for (fd <- fun.funDefs) {
              val e = extractFact(fun, fd)
              r += e
              v(e)
            }
          case _ =>
        }
        true
    })
    es.foreach(v)
    r
  }

  def checkSatFacts: (Boolean, Boolean) = {
    if (!checkSatEnabled) return (true, true)
    var fs = facts.values.toVector
    Visitor.build({
      case a: ast.Apply =>
        a.declOpt match {
          case Some(Right(fun)) =>
            for (funDef <- fun.funDefs) {
              fs :+= extractFact(fun, funDef)
            }
          case _ =>
        }
        true
    })(unitNode)
    var isSat = true
    if (fs.nonEmpty &&
      !checkSat("Facts", nodeLocMap(unitNode), fs, genMessage = true,
        unsatMsg = "The specified set of facts are unsatisfiable.",
        unknownMsg = {
          isSat = false
          "The set of facts might not be satisfiable."
        },
        timeoutMsg = {
          isSat = false
          "Could not check satisfiability of the set of facts due to timeout."
        })) return (isSat, false)
    (isSat, true)
  }

  def checkInvoke(a: ast.Apply): Boolean = {
    a.declOpt match {
      case Some(Left(md)) =>
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
        val postSubstMap = md.params.map(_.id).zip(a.args).toMap[ast.Node, ast.Node]
        if (autoEnabled) {
          val ps = premises ++ facts.values
          for (inv <- invs)
            if (!isValid("Global Invariant", nodeLocMap(a), ps, ivector(inv))) {
              val li = nodeLocMap(inv)
              error(a, s"Could not automatically deduce the global invariant specified at [${li.lineBegin}, ${li.columnBegin}].")
            }
          for (pre <- md.contract.requires.exps)
            if (!isValid("Pre-condition", nodeLocMap(a), ps, ivector(subst(pre, postSubstMap)))) {
              val li = nodeLocMap(pre)
              error(a, s"Could not automatically deduce the pre-condition of method ${md.id.value} specified at [${li.lineBegin}, ${li.columnBegin}].")
            }
        } else {
          for (inv <- invs)
            if (!premises.contains(inv)) {
              val li = nodeLocMap(inv)
              error(a, s"The global invariant specified at [${li.lineBegin}, ${li.columnBegin}] has not been proven.")
            }
          for (pre <- md.contract.requires.exps)
            if (!premises.contains(subst(pre, postSubstMap))) {
              val li = nodeLocMap(pre)
              error(a, s"The pre-condition of method ${md.id.value} specified at [${li.lineBegin}, ${li.columnBegin}] has not been proven.")
            }
        }
      case _ =>
    }
    true
  }

  def checkSat(title: String, li: LocationInfo, exps: Iterable[ast.Exp],
               genMessage: Boolean, unsatMsg: => String, unknownMsg: => String,
               timeoutMsg: => String): Boolean = {
    if (checkSatEnabled || !genMessage) {
      val es = additionalFacts(exps) ++ exps.toVector
      val (script, r) = Z3.checkSat(satTimeoutInMs, isSymExe, bitWidth, es.toVector: _*)
      if (inscribeSummoningsEnabled) {
        val lineSep = scala.util.Properties.lineSeparator
        val sb = new StringBuilder
        if ("" == title) sb.append("; Satisfiability: ")
        else sb.append(s"; Satisfiability of $title: ")
        sb.append(r match {
          case Z3.Unsat => "Unsat"
          case Z3.Sat => "Sat"
          case Z3.Timeout => "Don't Know (Timeout)"
          case Z3.Unknown => "Don't Know"
          case Z3.Error => "Error"
        })
        sb.append(lineSep)
        for (e <- es) {
          sb.append(";   ")
          sb.append(ast.Exp.toString(e, inProof = true))
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
          if (genMessage) error(li, unsatMsg)
          false
        case Z3.Unknown =>
          if (genMessage) reporter.report(li.toLocationWarning(fileUriOpt, "checksat", unknownMsg))
          true
        case Z3.Timeout =>
          if (genMessage) reporter.report(li.toLocationWarning(fileUriOpt, "checksat", timeoutMsg))
          true
        case Z3.Error =>
          true
      }
    } else true
  }

  def coneOfInfluence(premises: Iterable[ast.Exp],
                      conclusions: Iterable[ast.Exp]): IVector[ast.Exp] =
    if (coneInfluenceEnabled) {
      def collectIds(e: ast.Exp): Set[String] = {
        var ids = isetEmpty[String]
        Visitor.build({
          case ast.Id(value) => ids += value
            false
        })(e)
        ids
      }

      var relevantIds = conclusions.toVector.flatMap(collectIds)
      if (relevantIds.isEmpty) return ast.Node.emptySeq
      val m = midmapEmpty[ast.Exp, (Set[String], Natural)]
      var i = 0
      for (e <- premises) {
        m(e) = (collectIds(e), i)
        i += 1
      }
      var changed = true
      var relevantPremises = ivectorEmpty[ast.Exp]
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
    } else premises.toVector

  def check(proofGroup: ast.ProofGroup): Option[T] = {
    var addedVars = isetEmpty[String]
    var addedSteps = isetEmpty[Natural]
    var pcOpt: Option[T] =
      proofGroup match {
        // if proofGroup is a SubProof
        case p: ast.SubProof =>
          // consider the type of the first step in the subproof (the assume step)
          val popt = p.assumeStep match {
            case _: ast.PlainAssumeStep =>
              addedSteps += p.assumeStep.num.value
              addProvedStep(p.assumeStep)
            case ast.ForAllAssumeStep(num, id, _) =>
              addedVars += id.value
              addVar(id, num.value)
            case ast.ExistsAssumeStep(num, id, _, _) =>
              addedVars += id.value
              addedSteps += p.assumeStep.num.value
              addVar(id, num.value).flatMap(_.addProvedStep(p.assumeStep))
          }
          popt.flatMap(_.addProvedStep(p))
        case _ => Some(this.asInstanceOf[T])
      }
    for (step <- proofGroup.steps if pcOpt.isDefined) {
      addedSteps += step.num.value
      step match {
        case p: ast.RegularStep => pcOpt = pcOpt.flatMap(_.check(p))
        case p: ast.SubProof => pcOpt = pcOpt.get.check(p)
        case _: ast.ForAllAssumeStep => assert(assertion = false, "Unexpected situation.")
      }
    }
    pcOpt.map(pc => pc.make(
      vars = pc.vars -- addedVars,
      provedSteps = pc.provedSteps -- addedSteps))
  }

  def check(step: ast.RegularStep): Option[T] = {
    val num = step.num.value
    step match {
      case ast.Premise(_, exp) =>
        if (premises.contains(exp) || exp == Checker.top) addProvedStep(step)
        else error(exp, s"Could not find the claimed premise in step #$num.")
      case ast.AndIntro(_, and, lStep, rStep) =>
        (for (lExp <- findRegularStepExp(lStep, num);
              rExp <- findRegularStepExp(rStep, num)) yield {
          val expected = ast.Exp.And(tipe.B, lExp, rExp)
          if (expected == step.exp) addProvedStep(step)
          else error(and, s"And-intro in step #$num with #${lStep.value} on the left and #${rStep.value} on the right does not produce the expressed form.")
        }).flatten
      case ast.AndElim1(_, exp, andStep) =>
        findRegularStepExp(andStep, num) match {
          case Some(ast.And(expected, _)) =>
            if (expected == exp) addProvedStep(step)
            else error(exp, s"The conjunction's left sub-expression in step #${andStep.value} does not match #$num for And-elim1.")
          case Some(_) => error(andStep, s"And-elim1 in step #$num requires a conjunction.")
          case _ => None
        }
      case ast.AndElim2(_, exp, andStep) =>
        findRegularStepExp(andStep, num) match {
          case Some(ast.And(_, expected)) =>
            if (expected == exp) addProvedStep(step)
            else error(exp, s"The conjunction's right sub-expression in step #${andStep.value} does not match #$num for And-elim2.")
          case Some(_) => error(andStep, s"And-elim2 in step #$num requires a conjunction.")
          case _ => None
        }
      case ast.OrIntro1(_, ast.Or(lExp, _), step2) =>
        findRegularStepExp(step2, num) match {
          case Some(expected) =>
            if (expected == lExp) addProvedStep(step)
            else error(lExp, s"The disjunction's left sub-expression in step #$num does not match #${step2.value} for Or-intro1.")
          case _ => None
        }
      case ast.OrIntro2(_, ast.Or(_, rExp), step2) =>
        findRegularStepExp(step2, num) match {
          case Some(expected) =>
            if (expected == rExp) addProvedStep(step)
            else error(rExp, s"The disjunction's right sub-expression in step #$num does not match #${step2.value} for Or-intro2.")
          case _ => None
        }
      case ast.OrElim(_, exp, orStep, lSubProof, rSubProof) =>
        findRegularStepExp(orStep, num) match {
          case someE@Some(_: ast.Or | _: ast.Le | _: ast.Ge) =>
            val r =
              for (lsp <- findSubProof(lSubProof, num);
                   rsp <- findSubProof(rSubProof, num)) yield {
                var hasError = false
                (lsp.first, rsp.first) match {
                  case (lfs: ast.PlainAssumeStep, rfs: ast.PlainAssumeStep) =>
                    val (lExp, rExp) =
                      (someE.value: @unchecked) match {
                        case ast.Or(le, re) => (le, re)
                        case e@ast.Le(le, re) => (ast.Exp.Lt(e.tipe, le, re), ast.Exp.Eq(e.tipe, le, re))
                        case e@ast.Ge(le, re) => (ast.Exp.Gt(e.tipe, le, re), ast.Exp.Eq(e.tipe, le, re))
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
                    if (!lfs.isInstanceOf[ast.PlainAssumeStep])
                      error(lSubProof, s"Wrong form for Or-elim left assumption in step #$num.")
                    if (!rfs.isInstanceOf[ast.PlainAssumeStep])
                      error(lSubProof, s"Wrong form for Or-elim right assumption in step #$num.")
                    hasError = true
                }
                if (hasError) None else addProvedStep(step)
              }
            r.flatten
          case _ => error(orStep, s"Or-elim in step #$num requires a disjunction in step # ${orStep.value}.")
        }
      case ast.ImpliesIntro(_, ast.Implies(antecedent, conclusion), subProof) =>
        findSubProof(subProof, num) match {
          case Some(sp) =>
            var hasError = false
            sp.first match {
              case fs: ast.PlainAssumeStep =>
                if (fs.exp != antecedent) {
                  error(antecedent, s"The antecedent of step #$num does not match the assumption of #${subProof.value} for Implies-intro.")
                  hasError = true
                }
                val expectedClaims = extractClaims(sp)
                if (!expectedClaims.contains(conclusion)) {
                  error(antecedent, s"Could not find the consequent of step #$num in #${subProof.value} for Implies-intro.")
                  hasError = true
                }
              case _ =>
                error(sp, s"Wrong form for Implies-intro assumption in step #$num.")
                hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case _ => None
        }
      case ast.ImpliesElim(_, exp, impliesStep, antecedentStep) =>
        (findRegularStepExp(impliesStep, num),
          findRegularStepExp(antecedentStep, num)) match {
          case (Some(ast.Implies(a, c)), Some(antecedent)) =>
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
      case ast.NegIntro(_, exp, subProof) =>
        findSubProof(subProof, num) match {
          case Some(sp) =>
            var hasError = false
            (sp.first, sp.last) match {
              case (fs: ast.PlainAssumeStep, ls: ast.RegularStep) =>
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
                if (!fs.isInstanceOf[ast.PlainAssumeStep])
                  error(sp, s"Wrong form for Negation-intro assumption in step #$num.")
                if (!ls.isInstanceOf[ast.RegularStep])
                  error(sp, s"Wrong form for Negation-intro conclusion in step #$num.")
                hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case _ => None
        }
      case ast.NegElim(_, exp, step2, negStep) =>
        (findRegularStepExp(step2, num), findRegularStepExp(negStep, num)) match {
          case (Some(e1), Some(e2: ast.Not)) =>
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
          case (_, Some(_)) =>
            error(negStep, s"The second expression argument of step #${negStep.value} for Negation-elim in step #$num has to be negation.")
            None
          case _ => None
        }
      case ast.BottomElim(_, _, falseStep) =>
        findRegularStepExp(falseStep, num) match {
          case Some(e) =>
            if (e != Checker.bottom) {
              error(e, s"The expression of step #${falseStep.value} is expected to be a falsicum (⊥) for Bottom-elim of #$num.")
              None
            } else addProvedStep(step)
          case _ => None
        }
      case ast.Pbc(_, exp, subProof) =>
        findSubProof(subProof, num) match {
          case Some(sp: ast.SubProof) =>
            var hasError = false
            (sp.first, sp.last) match {
              case (fs: ast.PlainAssumeStep, ls: ast.RegularStep) =>
                if (fs.exp != ast.Not(exp)) {
                  error(exp, s"The negated expression in step #$num does not match the assumption in #${subProof.value} for Pbc.")
                  hasError = true
                }
                val expectedClaims = extractClaims(sp)
                if (!expectedClaims.contains(Checker.bottom)) {
                  error(ls.exp, s"Could not find falsicum (⊥) in step #${subProof.value} for Pbc of #$num.")
                  hasError = true
                }
              case (fs, ls) =>
                if (!fs.isInstanceOf[ast.PlainAssumeStep])
                  error(sp, s"Wrong form for Pbc assumption in step #$num.")
                if (ls.isInstanceOf[ast.RegularStep])
                  error(sp, s"Wrong form for Pbc conclusion in step #$num.")
                hasError = true
            }
            if (hasError) None else addProvedStep(step)
          case _ => None
        }
      case ast.Subst1(_, exp, eqStep, step2) =>
        var hasError = false
        (findRegularStepExp(eqStep, num),
          findRegularStepExp(step2, num)) match {
          case (Some(ast.Eq(exp1, exp2)), Some(e)) =>
            val expected =
              org.sireum.logika.ast.Rewriter.build[ast.Exp]()({
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
      case ast.Subst2(_, exp, eqStep, step2) =>
        var hasError = false
        (findRegularStepExp(eqStep, num),
          findRegularStepExp(step2, num)) match {
          case (Some(ast.Eq(exp1, exp2)), Some(e)) =>
            val expected =
              org.sireum.logika.ast.Rewriter.build[ast.Exp]()({
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
      case ast.Algebra(_, exp, steps) =>
        unitNode.mode match {
          case ast.LogicMode.Propositional | ast.LogicMode.Predicate =>
            error(step, s"Algebra cannot be used in ${unitNode.mode} Logic.")
            None
          case _ =>
            if (deduce(num, exp, steps, isAuto = false))
              addProvedStep(step)
            else None
        }
      case ast.ForAllIntro(_, q, subProof) =>
        findSubProof(subProof, num) match {
          case Some(sp) =>
            var hasError = true
            sp.first match {
              case fs: ast.ForAllAssumeStep =>
                val freshVarId = fs.id
                val freshVar = freshVarId.value
                for (step <- sp.steps.reverse if hasError) step match {
                  case step: ast.RegularStep if Checker.collectVars(step.exp).contains(freshVar) =>
                    val (m, e) = buildSubstMap(q.simplify, ivector(freshVarId)).get
                    val expected = subst(e, m)
                    val stepExpSimplified = step.exp match {
                      case stepExp: ast.Quant[_] => stepExp.simplify
                      case _ => step.exp
                    }
                    if (expected == stepExpSimplified) hasError = false
                  case _ =>
                }
                if (hasError) {
                  error(step, s"Could not find a suitable expression in #${subProof.value} for Forall-intro.")
                }
              case _ =>
                error(sp, s"Wrong form for the start of Forall-intro in step #$num that is expected to have only a fresh variable.")
            }
            if (hasError) None else addProvedStep(step)
          case _ => None
        }
      case ast.ForAllElim(_, exp, step2, args) =>
        findRegularStepExp(step2, num) match {
          case Some(q: ast.ForAll) =>
            buildSubstMap(q.simplify, args) match {
              case Some((m, e)) =>
                val expected = subst(e, m)
                val expSimplified = exp match {
                  case exp: ast.Quant[_] => exp.simplify
                  case _ => exp
                }
                if (expSimplified != expected) {
                  error(exp, s"Supplying the specified arguments to the quantification in step #${step2.value} does not produce matching expression in #$num for Forall-elim.")
                  None
                } else addProvedStep(step)
              case _ => error(step, s"The numbers of quantified variables and arguments do not match in Forall-elim of step #$num.")
            }
          case Some(_) => error(step2, s"Forall-elim in step #$num requires a universal quantification in #${step2.value}.")
          case _ => None
        }
      case ast.ExistsIntro(_, q, step2, args) =>
        findRegularStepExp(step2, num) match {
          case Some(result) =>
            buildSubstMap(q.simplify, args) match {
              case Some((m, e)) =>
                val expected = subst(e, m)
                val resultSimplified = result match {
                  case result: ast.Quant[_] => result.simplify
                  case _ => result
                }
                if (resultSimplified != expected) {
                  error(q, s"Supplying the specified arguments to the quantification in step #$num does not produce matching expression in #${step2.value} for Exists-intro.")
                  None
                } else addProvedStep(step)
              case _ => error(step, s"The numbers of quantified variables and arguments do not match in Exists-intro of step #$num.")
            }
          case _ => None
        }
      case ast.ExistsElim(_, exp, step2, subProof) =>
        findRegularStepExp(step2, num) match {
          case Some(q: ast.Exists) =>
            findSubProof(subProof, num) match {
              case Some(sp) =>
                var hasError = false
                sp.first match {
                  case fs: ast.ExistsAssumeStep =>
                    val freshVar = fs.id.value
                    val (m, e) = buildSubstMap(q.simplify, ivector(ast.Id(freshVar))).get
                    val expected = subst(e, m)
                    val fsExpSimplified = fs.exp match {
                      case fsExp: ast.Quant[_] => fsExp.simplify
                      case _ => fs.exp
                    }
                    if (expected != fsExpSimplified) {
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
                  case _ =>
                    error(sp, s"Wrong form for Exists-elim assumption in step #$num that is expected to have a fresh variable and a formula.")
                    hasError = true
                }
                if (hasError) None else addProvedStep(step)
              case _ => None
            }
          case Some(_) => error(step2, s"Exists-elim in step #$num requires an existensial quantification in #${step2.value}.")
          case _ => None
        }
      case ast.Auto(_, exp, steps) =>
        unitNode.mode match {
          case ast.LogicMode.Propositional | ast.LogicMode.Predicate =>
            error(step, s"Auto cannot be used in ${unitNode.mode} Logic.")
            None
          case _ =>
            if (deduce(num, exp, steps, isAuto = true)) addProvedStep(step)
            else None
        }
      case factJust@ast.FactJust(_, exp, id) =>
        val expected: Option[ast.Exp] = factJust.decl match {
          case Left3(fact) => Some(fact.exp)
          case Middle3((fun, funDef)) => Some(extractFact(fun, funDef))
          case Right3(md) => extractFact(md)
        }
        val result: Option[ast.Exp] = Some(exp)
        if (expected == result) addProvedStep(step)
        else error(exp, s"The expression in step #$num does not match the one in fact ${id.value}.")
      case ast.Invariant(_, exp) =>
        if (invariants.contains(exp)) addProvedStep(step)
        else error(exp, s"Could not find the invariant in step #$num.")
      case _: ast.ExistsAssumeStep | _: ast.PlainAssumeStep =>
        assert(assertion = false, "Unexpected situation.")
        None
    }
  }

  def deduce(num: Natural, exp: ast.Exp, steps: ast.Node.Seq[ast.Num],
             isAuto: Boolean): Boolean = {
    val antecedents =
      if (steps.nonEmpty) {
        var as = ast.Node.emptySeq[ast.Exp]
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
      else ast.Node.emptySeq[ast.Exp]
    val method = if (isAuto) "automatically" else "apply algebra to"
    if (isValid("", nodeLocMap(exp), antecedents, ivector(exp))) true
    else {
      error(exp, s"Could not $method deduce the claim in step#$num.")
      false
    }
  }

  def checkAlgebraExp(e: ast.Exp): Boolean = {
    var hasError = false
    Visitor.build({
      case e: ast.And =>
        hasError = true
        error(e, "Algebra justification cannot be used for conjunction.")
        true
      case e: ast.Or =>
        hasError = true
        error(e, "Algebra justification cannot be used for disjunction.")
        true
      case e: ast.Implies =>
        hasError = true
        error(e, "Algebra justification cannot be used for implication.")
        true
      case _: ast.Quant[_] =>
        hasError = true
        error(e, "Algebra justification cannot be used for quantification.")
        true
    })(e)
    !hasError
  }

  def expRewriter(m: IMap[ast.Node, ast.Node]): ast.Exp => ast.Exp =
    if (m.isEmpty) identity
    else org.sireum.logika.ast.Rewriter.build[ast.Exp](TraversalMode.TOP_DOWN) {
      case n: ast.Quant[_] if n.ids.exists(m.contains(_)) => expRewriter(m -- n.ids)(n)
      case n: ast.Node if m.isDefinedAt(n) => m(n)
    }

  def subst(e: ast.Exp, m: IMap[ast.Node, ast.Node]): ast.Exp = expRewriter(m)(e)

  def buildSubstMap(q: ast.Quant[_], args: ast.Node.Seq[ast.Exp]): Option[(IMap[ast.Node, ast.Node], ast.Exp)] = {
    val r = imapEmpty[ast.Node, ast.Node] ++ q.ids.zip(args)
    if (r.isEmpty) None
    else if (r.size < q.ids.size) {
      q match {
        case q: ast.ForAll =>
          Some((r, ast.ForAll(q.ids.slice(r.size, q.ids.size), q.domainOpt, q.exp)))
        case q: ast.Exists =>
          Some((r, ast.Exists(q.ids.slice(r.size, q.ids.size), q.domainOpt, q.exp)))
      }
    } else if (r.size < args.size) {
      q.exp match {
        case q2: ast.Quant[_] =>
          buildSubstMap(q2, args.slice(r.size, args.size)) match {
            case Some((m, e)) => Some((r ++ m, e))
            case _ => None
          }
        case _ => None
      }
    } else Some((r, q.exp))
  }

  def addProvedStep(step: ast.ProofStep): Option[T] = {
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

  def addVar(id: ast.Id, stepNum: Natural): Option[T] = {
    val varId = id.value
    assert(!vars.contains(varId))
    Some(make(vars = vars + varId))
  }

  def isValid(title: String, li: LocationInfo,
              premises: Iterable[ast.Exp], conclusions: Iterable[ast.Exp]): Boolean = {
    var ps = ilinkedSetEmpty[ast.Exp]
    ps ++= (if (coneInfluenceEnabled)
        util.Z3.checkSat(satTimeoutInMs, isSymExe = true, bitWidth,
          ast.Exp.And(conclusions.toVector))._2 match {
          case util.Z3.Sat => coneOfInfluence(premises, conclusions)
          case _ => premises
        }
    else premises)
    ps ++= additionalFacts(premises ++ conclusions)
    val (script, r) = Z3.isValid(timeoutInMs, isSymExe, bitWidth,
      ps.toVector, conclusions.toVector)
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
        sb.append(ast.Exp.toString(p, inProof = true))
        if (i + 1 != ps.size) sb.append(',')
        sb.append(lineSep)
        i += 1
      }
      sb.append(";     ⊢")
      sb.append(lineSep)
      i = 0
      for (c <- conclusions) {
        sb.append(";   ")
        sb.append(ast.Exp.toString(c, inProof = true))
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

  def findSubProof(num: ast.Num, stepNum: Natural): Option[ast.SubProof] = {
    provedSteps.get(num.value) match {
      case Some(r: ast.SubProof) => Some(r)
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

  def findRegularStepExp(num: ast.Num, stepNum: Natural): Option[ast.Exp] =
    provedSteps.get(num.value) match {
      case Some(r: ast.RegularStep) => Some(r.exp)
      case _ =>
        if (declaredStepNumbers.contains(num.value))
          error(num, s"Step #${num.value} is out of scope from #$stepNum.")
        else
          error(num, s"Could not find the referenced step #${num.value} in #$stepNum.")
        None
    }

  def orClaims(es1: Iterable[ast.Exp], es2: Iterable[ast.Exp]): ILinkedSet[ast.Exp] = {
    var r = ilinkedSetEmpty[ast.Exp]
    for (e1 <- es1; e2 <- es2)
      if (e1 == e2)
        r += e1
      else
        r += ast.Exp.Or(tipe.B, e1, e2)
    r
  }

  def extractClaims(pg: ast.ProofGroup,
                    reverse: Boolean = true): ILinkedSet[ast.Exp] = {
    var steps = pg.allSteps
    if (reverse) steps = steps.reverse
    ilinkedSetEmpty ++ steps.flatMap(_ match {
      case step: ast.RegularStep => Some(step.exp)
      case _ => None
    })
  }

  def generateHint(beforePremises: ILinkedSet[ast.Exp],
                   stmt: ast.Stmt,
                   afterPremises: ILinkedSet[ast.Exp]): Unit = {
    if (hintEnabled && (beforePremises.nonEmpty || afterPremises.nonEmpty) &&
      !stmt.isInstanceOf[ast.MethodDecl]) {
      val input = unitNode.input
      val li = nodeLocMap(stmt)
      var startOffset = input.lastIndexOf('\n', li.offset) + 1
      if (startOffset < 1) startOffset = 0
      var endOffset = input.indexOf('\n', li.offset + li.length)
      if (endOffset < 0) endOffset = input.length
      val sb = new StringBuilder

      def indent(): Unit = {
        for (_ <- 0 until li.columnBegin) {
          sb.append(' ')
        }
      }

      indent()
      sb.append("{\n")
      for (e <- beforePremises) {
        indent()
        sb.append("  ")
        sb.append(ast.Exp.toString(e, inProof = true))
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
        sb.append(ast.Exp.toString(e, inProof = true))
        sb.append('\n')
      }
      indent()
      sb.append("}")
      reporter.report(li.toLocationInfo(fileUriOpt, "hint", sb.toString))
    }
  }

  def error(n: ast.Node, msg: String): Option[T] = error(nodeLocMap(n), msg)

  def error(li: LocationInfo, msg: String): Option[T] = {
    reporter.report(li.toLocationError(fileUriOpt, Checker.kind, msg))
    None
  }

  def warn(n: ast.Node, msg: String): Unit = warn(nodeLocMap(n), msg)

  def warn(li: LocationInfo, msg: String): Unit =
    reporter.report(li.toLocationWarning(fileUriOpt, Checker.kind, msg))
}
