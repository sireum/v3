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

package org.sireum.logika.tipe

import org.sireum.logika.ast._
import org.sireum.util._

object TypeChecker {
  val kind = "Type Checker"

  final def check(programs: Program*)(
    implicit reporter: AccumulatingTagReporter): Boolean = {
    var typeMap = imapEmpty[String, (Tipe, Node, Program)]
    for (program <- programs) {
      val factOrFunDecls = program.block.stmts.flatMap(_ match {
        case stmt: FactStmt => Some(stmt.fact.factOrFunDecls)
        case _ => None
      }).flatten
      for (f@Fun(id, _, _) <- factOrFunDecls)
        typeMap = addId(typeMap, program, id, tipe(f), f)
      for (m@MethodDecl(_, id, _, _, _, _, _) <- program.block.stmts)
        typeMap = addId(typeMap, program, id, tipe(m), m)
    }
    if (reporter.hasError) return false
    for (program <- programs)
      TypeContext(typeMap, program).check(program)
    !reporter.hasError
  }

  private[tipe] def addId(typeMap: IMap[String, (Tipe, Node, Program)],
                          program: Program, id: Id, tipe: Tipe, decl: Node)(
                           implicit reporter: AccumulatingTagReporter): IMap[String, (Tipe, Node, Program)] = {
    id.tipe = tipe
    typeMap.get(id.value) match {
      case Some((_, other, otherProgram)) =>
        val otherLi = otherProgram.nodeLocMap(other)
        val message =
          if ((program eq otherProgram) || otherProgram.fileUriOpt.isEmpty)
            s"Identifier ${id.value} has been declared at [${otherLi.lineBegin}, ${otherLi.columnBegin}]."
          else
            s"Identifier ${id.value} has been declared at [${otherLi.lineBegin}, ${otherLi.columnBegin}] of ${otherProgram.fileUriOpt.get}."
        reporter.report(
          program.nodeLocMap(id).toLocationError(otherProgram.fileUriOpt,
            kind, message))
        typeMap
      case _ => typeMap + (id.value ->(id.tipe, decl, program))
    }
  }

  private[tipe] final def tipe(t: Type): Tipe = t match {
    case t: BooleanType => B
    case t: IntType => Z
    case t: IntSeqType => ZS
  }

  private[tipe] final def tipe(m: MethodDecl): FunTipe =
    FunTipe(m.params.map(p => tipe(p.tpe)),
      m.returnTypeOpt.map(tipe).getOrElse(UnitTipe))

  private[tipe] final def tipe(f: Fun): FunTipe =
    FunTipe(f.params.map(p => tipe(p.tpe)),
      tipe(f.returnType))
}

private final case class
TypeContext(typeMap: IMap[String, (Tipe, Node, Program)],
            program: Program)(
             implicit reporter: AccumulatingTagReporter) {

  private val someB = Some(B)
  private val someZ = Some(Z)
  private val someZS = Some(ZS)

  def check(p: Program): Unit = {
    check(p.block)(None)
    for (stmt <- p.block.stmts) {
      val applyOpt =
        stmt match {
          case VarDecl(_, _, _, a: Apply) => Some(a)
          case Assign(_, a: Apply) => Some(a)
          case ExpStmt(a) => Some(a)
          case _ => None
        }
      applyOpt.foreach(_.declOpt.foreach { d =>
        if (d.isHelper) {
          error(applyOpt.get, s"Cannot directly call a helper method in the program main level.")
        }
      })
    }
  }

  def check(b: Block)(
    implicit mOpt: Option[MethodDecl]): TypeContext = {
    var tc = this
    for (stmt <- b.stmts) tc = tc.check(stmt)
    tc
  }

  def check(stmt: Stmt)(
    implicit mOpt: Option[MethodDecl]): TypeContext = stmt match {
    case VarDecl(isVar, id, t, exp) =>
      id.tipe = TypeChecker.tipe(t)
      check(exp, allowMethod = true)(allowFun = false, mOpt).foreach(tExp =>
        if (id.tipe != tExp)
          error(stmt, s"${if (isVar) "Var" else "Val"} declaration requires the same type on both left and right expressions, but found ${id.tipe} and $tExp, respectively."))
      copy(typeMap = TypeChecker.addId(typeMap, program, id, id.tipe, stmt))
    case Assign(id, exp) =>
      for (tExp <- check(exp, allowMethod = true)(allowFun = false, mOpt))
        typeMap.get(id.value) match {
          case Some((tId, vd: VarDecl, _)) if vd.isVar =>
            id.tipe = tId
            if (tId != tExp)
              error(stmt, s"Assignment requires the same type on both left and right expressions, but found $tId and $tExp, respectively.")
            else if (tId == ZS)
              exp match {
                case _: SeqLit | _: Clone | _: Prepend | _: Append =>
                case _ =>
                  error(stmt, s"Assignment to a var of ZS type can only be done from a ZS literal, clone, prepend (+:), or append (:+).")
              }
          case _ =>
            error(stmt, s"Can only assign to a var.")
        }
      this
    case Assume(exp) => b(exp)(allowFun = false, mOpt); this
    case Assert(exp) => b(exp)(allowFun = false, mOpt); this
    case ExpStmt(exp) =>
      check(exp, allowMethod = true)(allowFun = false, mOpt); this
    case If(exp, trueBlock, falseBlock) =>
      b(exp)(allowFun = false, mOpt)
      check(trueBlock)
      check(falseBlock)
      this
    case While(exp, block, loopInv) =>
      for (iExp <- loopInv.invariant.exps) b(iExp)(allowFun = true, mOpt)
      checkModifies(loopInv.modifies, block, stmt)
      b(exp)(allowFun = false, mOpt)
      check(block)
      this
    case p: Print =>
      for (arg <- p.args) arg match {
        case exp: Exp => check(exp, allowMethod = false)(allowFun = false, mOpt)
        case _ =>
      }
      this
    case SeqAssign(id, index, exp) =>
      zs(id)(allowFun = false, mOpt)
      id.tipe = ZS
      z(index)(allowFun = false, mOpt)
      z(exp)(allowFun = false, mOpt)
      this
    case md: MethodDecl =>
      var tm = typeMap
      for (p <- md.params)
        tm = TypeChecker.addId(tm, program, p.id, TypeChecker.tipe(p.tpe), p)
      var tc = copy(typeMap = tm)
      for (e <- md.contract.requires.exps) tc.b(e)(allowFun = true, mOpt)
      tc.checkModifies(md.contract.modifies, md.block, md)
      tc = tc.check(md.block)(Some(md))
      md.returnTypeOpt match {
        case Some(rt) =>
          val t = TypeChecker.tipe(rt)
          val tcPost = copy(
            typeMap = TypeChecker.addId(tm, program, Id("result"), t, md))
          for (e <- md.contract.ensures.exps)
            tcPost.b(e)(allowFun = true, mOpt)
          md.returnExpOpt match {
            case Some(e) =>
              tc.check(e, allowMethod = false)(
                allowFun = false, mOpt) match {
                case Some(t2) =>
                  if (t != t2)
                    error(e, s"Expecting return type $t, but found $t2.")
                case _ =>
              }
            case _ =>
              if (md.returnTypeOpt.isEmpty)
                error(md.returnExpOpt.get, s"Unexpected return expression.")
          }
        case _ =>
          for (e <- md.contract.ensures.exps) tc.b(e)(allowFun = true, mOpt)
      }
      this
    case ProofStmt(proof) => check(proof); this
    case stmt@SequentStmt(sequent) =>
      for (e <- sequent.premises) b(e)(allowFun = true, mOpt)
      for (e <- sequent.conclusions) b(e)(allowFun = true, mOpt)
      sequent.proofOpt.foreach(check)
      this
    case InvStmt(inv) => for (e <- inv.exps) b(e)(allowFun = true, mOpt); this
    case FactStmt(facts) =>
      for (Fact(_, e) <- facts.factOrFunDecls)
        check(e, allowMethod = false)(allowFun = true, None)
      this
  }

  def check(p: ProofGroup): Unit = {
    var tc = this
    for (step <- p.allSteps) step match {
      case step: RegularStep =>
        tc.b(step.exp)(allowFun = true, None)
      case step: QuantAssumeStep =>
        tc = copy(typeMap =
          TypeChecker.addId(typeMap, program, step.id,
            TypeChecker.tipe(step.typeOpt.get), step))
      case step: ProofGroup => tc.check(step)
      case _ =>
    }
  }

  def checkModifies(m: Modifies, block: Block, node: Node): Unit = {
    var modifiedVars = isetEmpty[Id]
    for (id <- m.ids) {
      if (modifiedVars.contains(id)) {
        warn(id, s"$id has already been declared as modifiable.")
      }
      modifiedVars += id
      typeMap.get(id.value) match {
        case Some((_, VarDecl(true, _, _, _), _)) =>
        case Some((ZS, _, _)) =>
        case Some(_) =>
          error(id, s"Only variable or sequence value can be modified.")
        case _ => tipe(id)
      }
    }
    if (node.isInstanceOf[While])
      for (id <- collectAssignedVars(block) -- modifiedVars) {
        val li = program.nodeLocMap(id)
        error(node, s"Identifier ${id.value} is assigned at [${li.lineBegin}, ${li.columnBegin}] inside the loop but not declared in the loop modifies clause.")
      }
    else {
      for (id <- (collectAssignedVars(block) & typeMap.keySet.map(Id)) -- modifiedVars) {
        val li = program.nodeLocMap(id)
        error(node, s"Identifier ${id.value} is assigned at [${li.lineBegin}, ${li.columnBegin}] but not declared in the function modifies clause.")
      }
    }
  }

  def check(e: Exp, allowMethod: Boolean = false)(
    implicit allowFun: Boolean,
    mOpt: Option[MethodDecl]): Option[Tipe] =
    e match {
      case _: BooleanLit => someB
      case e: Id => val r = tipe(e); r.foreach(e.tipe = _); r
      case e: Size => zs(e.id); someZ
      case e: Clone =>
        if (!allowMethod) error(e.id, s"ZS clone is only allowed at statement level.")
        zs(e.id)
        someZS
      case e: Result =>
        val r = tipe(Id("result")); r.foreach(e.tipe = _); r
      case e: Apply =>
        val isMethod =
          typeMap.get(e.id.value) match {
            case Some((_, md: MethodDecl, _)) =>
              if (!allowMethod)
                error(e.id, s"Method invocation is only allowed at statement level.")
              e.declOpt = Some(md)
              mOpt match {
                case Some(caller) =>
                  val ids = md.contract.modifies.ids.toSet -- caller.contract.modifies.ids.toSet
                  ids.size match {
                    case 0 =>
                    case 1 => error(e.id, s"Variable ${ids.head.value} is modified by method ${md.id.value} but not in the modifies clause of method ${caller.id.value} which invokes ${md.id.value}.")
                    case _ =>
                      val sb = new StringBuilder(ids.head.value)
                      for (id <- ids.tail) {
                        sb.append(", ")
                        sb.append(id)
                      }
                      error(e.id, s"Variables $sb are modified by method ${md.id.value} but not in the modifies clause of method ${caller.id.value} which invokes ${md.id.value}.")
                  }
                case _ =>
              }
              true
            case Some((_, fun: Fun, _)) =>
              if (!allowFun)
                error(e.id, s"Use of proof function is only allowed in proof context.")
              false
            case _ =>
              false
          }
        check(e.id) match {
          case Some(t: Fn) =>
            if (e.args.size != t.params.size) {
              val text = if (isMethod) "Method" else "Proof function"
              error(e, s"$text ${e.id.value} requires ${t.params.size} arguments, but found ${e.args.size}.")
            }
            for ((arg, pType) <- e.args.zip(t.params)) {
              check(arg) match {
                case Some(`pType`) =>
                case Some(argType) =>
                  error(arg, s"Expecting type $pType, but found $t.")
                case _ =>
              }
            }
            Some(t.result)
          case Some(t) =>
            if (e.args.size == 1)
              error(e.id, s"Expecting a function/ZS type, but found $t.")
            else
              error(e.id, s"Expecting a function type, but found $t.")
            None
          case _ => None
        }
      case _: RandomInt =>
        if (!allowMethod)
          error(e, s"Invoking randomInt is only allowed at statement level.")
        someZ
      case _: ReadInt =>
        if (!allowMethod)
          error(e, s"Invoking readInt is only allowed at statement level.")
        someZ
      case _: IntLit => someZ
      case e: BinaryExp =>
        e match {
          case _: Mul | _: Div | _: Rem | _: Add | _: Sub =>
            z(e.left); z(e.right); someZ
          case _: Lt | _: Le | _: Gt | _: Ge =>
            z(e.left); z(e.right); someB
          case e: EqualityExp =>
            for (t1 <- check(e.left); t2 <- check(e.right))
              if (t1 != t2) {
                val op = if (e.isInstanceOf[Eq]) "equal" else "not-equal"
                error(e.right, s"The $op binary operator requires the same type on both left and right expressions, but found $t1 and $t2, respectively.")
              } else {
                e.tipe = t1
              }
            someB
          case _: Append =>
            zs(e.left)
            z(e.right)
            someZS
          case _: Prepend =>
            z(e.left)
            zs(e.right)
            someZS
          case _: And | _: Or | _: Implies =>
            b(e.left); b(e.right); someB
        }
      case e: Not => b(e.exp); someB
      case e: Minus => z(e.exp); someZ
      case e: Quant[_] =>
        val t = e.domainOpt match {
          case Some(TypeDomain(tpe)) => TypeChecker.tipe(tpe)
          case Some(RangeDomain(lo, hi, _, _)) => z(lo); z(hi); Z
          case None => assert(assertion = false, "Unexpected situation."); Z
        }
        var tm = typeMap
        for (id <- e.ids) {
          tm = TypeChecker.addId(tm, program, id, t, e)
          id.tipe = t
        }
        copy(typeMap = tm).check(e.exp)
        someB
      case e: SeqLit => for (arg <- e.args) z(arg); someZS
    }

  def collectAssignedVars(b: Block): ISet[Id] = {
    var r = isetEmpty[Id]
    Visitor.build({
      case Assign(id, _) => r += id; false
      case SeqAssign(id, _, _) => r += id; false
    })(b)
    r
  }

  def b(e: Exp)(implicit allowFun: Boolean, mOpt: Option[MethodDecl]): Unit =
    check(e) match {
      case Some(B) =>
      case Some(t) => error(e, s"Expecting an expression of type B, but found $t.")
      case _ =>
    }

  def z(e: Exp)(implicit allowFun: Boolean, mOpt: Option[MethodDecl]): Unit =
    check(e) match {
      case Some(Z) =>
      case Some(t) => error(e, s"Expecting an expression of type Z, but found $t.")
      case _ =>
    }

  def zs(e: Exp)(implicit allowFun: Boolean, mOpt: Option[MethodDecl]): Unit =
    check(e) match {
      case Some(ZS) =>
      case Some(t) => error(e, s"Expecting an expression of type ZS, but found $t.")
      case _ =>
    }

  def tipe(id: Id): Option[Tipe] = typeMap.get(id.value) match {
    case Some((t, _, _)) => Some(t)
    case _ =>
      if (id.value.endsWith("_old")) {
        typeMap.get(id.value.substring(0, id.value.length - 4)) match {
          case Some((t, _, _)) => return Some(t)
          case _ =>
        }
      } else if (id.value.endsWith("_in")) {
        typeMap.get(id.value.substring(0, id.value.length - 3)) match {
          case Some((t, _, _)) => return Some(t)
          case _ =>
        }
      }
      error(id, s"Undeclared identifier ${id.value}.")
      None
  }

  def warn(n: Node, msg: String): Unit =
    reporter.report(program.nodeLocMap(n).
      toLocationWarning(program.fileUriOpt, TypeChecker.kind, msg))

  def error(n: Node, msg: String): Unit =
    reporter.report(program.nodeLocMap(n).
      toLocationError(program.fileUriOpt, TypeChecker.kind, msg))
}


