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

package org.sireum.logika.tipe

import org.sireum.logika.ast._
import org.sireum.logika.util._
import org.sireum.util._

object TypeChecker {
  final def check(program: Program)(
    implicit reporter: Reporter): Boolean = {
    val r2 = new Reporter {
      var hasError = false

      override def error(message: String): Unit = {
        hasError = true
        reporter.error(message)
      }

      override def warn(message: String): Unit =
        reporter.warn(message)

      override def warn(line: PosInteger,
                        column: PosInteger,
                        offset: Natural, message: String): Unit =
        reporter.warn(line, column, offset, message)

      override def error(line: PosInteger,
                         column: PosInteger,
                         offset: Natural, message: String): Unit = {
        hasError = true
        reporter.error(line, column, offset, message)
      }

      override def info(message: String): Unit =
        reporter.info(message)

      override def info(line: PosInteger, column: PosInteger, offset: Natural, message: String): Unit =
        reporter.info(line, column, offset, message)
    }
    implicit val nodeLocMap = program.nodeLocMap
    var typeMap = imapEmpty[String, (Tipe, Node)]
    for (f@Fun(id, _, _) <- program.fact.factOrFunDecls) {
      typeMap += id.value ->(tipe(f), f)
    }
    for (m@MethodDecl(id, _, _, _, _, _) <- program.block.stmts) {
      typeMap += id.value ->(tipe(m), m)
    }
    TypeContext(typeMap)(nodeLocMap, r2).check(program.block)
    !r2.hasError
  }

  private[tipe] final def tipe(t: Type): Tipe = t match {
    case t: BooleanType => B
    case t: IntType => Z
    case t: IntSeqType => ZS
  }

  private final def tipe(m: MethodDecl): FunTipe =
    FunTipe(m.params.map(p => tipe(p.tpe)),
      m.returnTypeOpt.map(tipe).getOrElse(UnitTipe))

  private final def tipe(f: Fun): FunTipe =
    FunTipe(f.params.map(p => tipe(p.tpe)),
      tipe(f.returnType))
}

private final case class TypeContext(typeMap: IMap[String, (Tipe, Node)])(
  implicit val nodeLocMap: MIdMap[Node, LocationInfo],
  reporter: Reporter) {

  private val someB = Some(B)
  private val someZ = Some(Z)
  private val someZS = Some(ZS)

  def check(p: Program): Unit = {
    for (Fact(_, e) <- p.fact.factOrFunDecls)
      check(e, allowMethod = false)(allowFun = true)
    check(p.block)
  }

  def check(b: Block): TypeContext = {
    var tc = this
    for (stmt <- b.stmts) tc = tc.check(stmt)
    tc
  }

  def check(stmt: Stmt): TypeContext = stmt match {
    case VarDecl(_, id, t) =>
      TypeContext(addId(id, TypeChecker.tipe(t), stmt, typeMap))
    case Assign(id, exp) =>
      for (tExp <- check(exp, allowMethod = true)(allowFun = false))
        typeMap.get(id.value) match {
          case Some((tId, VarDecl(true, _, _))) =>
            if (tId != tExp)
              error(stmt, s"Assignment requires the same type on both left and right expressions, but found $tId and $tExp, respectively.")
          case _ =>
            error(stmt, s"Can only assign to a variable.")
        }
      this
    case Assert(exp) => b(exp)(allowFun = false); this
    case ExpStmt(exp) =>
      check(exp, allowMethod = true)(allowFun = false); this
    case If(exp, trueBlock, falseBlock) =>
      b(exp)(allowFun = false)
      check(trueBlock)
      check(falseBlock)
      this
    case While(exp, block, loopInv) =>
      for (iExp <- loopInv.invariant.exps) b(iExp)(allowFun = true)
      checkModifies(loopInv.modifies, block, stmt)
      b(exp)(allowFun = false)
      check(block)
      this
    case _: Print => this
    case SeqAssign(id, index, exp) =>
      zs(id)(allowFun = false)
      z(index)(allowFun = false)
      z(exp)(allowFun = false)
      this
    case md: MethodDecl =>
      var tm = typeMap
      for (p <- md.params)
        tm = addId(p.id, TypeChecker.tipe(p.tpe), p, tm)
      var tc = TypeContext(tm)
      for (e <- md.contract.requires.exps) tc.b(e)(allowFun = true)
      checkModifies(md.contract.modifies, md.block, md)
      for (e <- md.contract.ensures.exps) tc.b(e)(allowFun = true)
      tc = tc.check(md.block)
      for (rt <- md.returnTypeOpt) {
        val t = TypeChecker.tipe(rt)
        tm = addId(Id("result"), t, md, tm)
        md.returnExpOpt match {
          case Some(e) =>
            tc.check(e, allowMethod = false)(allowFun = false) match {
              case Some(t2) =>
                if (t != t2)
                  error(e, s"Expecting return type $t, but found $t2.")
              case _ =>
            }
          case _ =>
            if (md.returnTypeOpt.isEmpty)
              error(md.returnExpOpt.get, s"Unexpected return expression.")
        }
      }
      this
    case stmt@ProofStmt(proof) =>
      stmt.typeMap = typeMap.map(p => (p._1, p._2._1))
      check(proof)
      this
    case stmt@SequentStmt(sequent) =>
      stmt.typeMap = typeMap.map(p => (p._1, p._2._1))
      for (e <- sequent.premises) b(e)(allowFun = true)
      for (e <- sequent.conclusions) b(e)(allowFun = true)
      sequent.proofOpt.foreach(check)
      this
    case InvStmt(inv) => for (e <- inv.exps) b(e)(allowFun = true); this
  }

  def check(p: ProofGroup): Unit = {
    var tc = this
    for (step <- p.allSteps) step match {
      case step: RegularStep =>
        tc.b(step.exp)(allowFun = true)
      case step: QuantAssumeStep =>
        tc = TypeContext(addId(step.id,
          TypeChecker.tipe(step.typeOpt.get), step, typeMap))
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
        case Some((_, VarDecl(true, _, _))) =>
        case Some((_, VarDecl(false, _, IntSeqType()))) =>
        case Some(_) =>
          error(id, s"Only variable or sequence value can be modified.")
        case _ => tipe(id)
      }
    }
    if (node.isInstanceOf[While])
      for (id <- collectAssignedVars(block) -- modifiedVars) {
        val li = nodeLocMap(id)
        error(node, s"Identifier ${id.value} is assigned at [${li.lineBegin}, ${li.columnBegin}] inside the loop but not declared in the loop modifies clause.")
      }
    else {
      for (id <- (collectAssignedVars(block) & typeMap.keySet.map(Id)) -- modifiedVars) {
        val li = nodeLocMap(id)
        error(node, s"Identifier ${id.value} is assigned at [${li.lineBegin}, ${li.columnBegin}] but not declared in the function modifies clause.")
      }
    }
  }

  def check(e: Exp, allowMethod: Boolean = false)(
    implicit allowFun: Boolean): Option[Tipe] =
    e match {
      case _: BooleanLit => someB
      case e: Id => tipe(e)
      case e: Size => zs(e.id); someZ
      case e: Clone =>
        if (!allowMethod) error(e.id, s"ZS clone is only allowed at statement level.")
        zs(e.id)
        someZS
      case e: Result => tipe(Id("result"))
      case e: Apply =>
        val isMethod =
          typeMap.get(e.id.value) match {
            case Some((_, md: MethodDecl)) =>
              if (!allowMethod)
                error(e.id, s"Method invocation is only allowed at statement level.")
              true
            case Some((_, fun: Fun)) =>
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
              error(e.id, s"Expecting a function/seq type, but found $t.")
            else
              error(e.id, s"Expecting a function type, but found $t.")
            None
          case _ => None
        }
      case _: ReadInt | _: IntLit => someZ
      case e: BinaryExp =>
        e match {
          case _: Mul | _: Div | _: Rem | _: Add | _: Sub =>
            z(e.left); z(e.right); someZ
          case _: Lt | _: Le | _: Gt | _: Ge =>
            z(e.left); z(e.right); someB
          case _: Eq | _: Ne =>
            for (t1 <- check(e.left); t2 <- check(e.right))
              if (t1 != t2) {
                val op = if (e.isInstanceOf[Eq]) "equal" else "not-equal"
                error(e.right, s"The $op binary operator requires the same type on both left and right expressions, but found $t1 and $t2, respectively.")
              }
            someB
          case _: Append => zs(e.left); z(e.right); someZS
          case _: Prepend => z(e.left); zs(e.right); someZS
          case _: And | _: Or | _: Implies =>
            b(e.left); b(e.right); someB
        }
      case e: Not => b(e.exp); someB
      case e: Minus => z(e.exp); someZ
      case e: Quant =>
        val t = (e.domainOpt: @unchecked) match {
          case Some(TypeDomain(tpe)) => TypeChecker.tipe(tpe)
          case Some(RangeDomain(lo, hi)) =>
            z(lo); z(hi); Z
        }
        var tm = typeMap
        for (id <- e.ids) tm = addId(id, t, e, tm)
        TypeContext(tm).check(e.exp)
        someB
      case e: SeqLit => for (arg <- e.args) z(arg); someZS
    }

  def addId(id: Id, t: Tipe, n: Node, typeMap: IMap[String, (Tipe, Node)]) = {
    var r = typeMap
    typeMap.get(id.value) match {
      case Some((_, n2)) =>
        val li = nodeLocMap(n2)
        error(id, s"Identifier ${id.value} has already been declared at [${li.lineBegin}, ${li.columnBegin}].")
      case _ =>
        r += id.value -> ((t, n))
    }
    r
  }

  def collectAssignedVars(b: Block): ISet[Id] = {
    var r = isetEmpty[Id]
    Visitor.build({
      case Assign(id, _) => r += id; false
      case SeqAssign(id, _, _) => r += id; false
    })(b)
    r
  }

  def b(e: Exp)(implicit allowFun: Boolean): Unit =
    check(e)(allowFun) match {
      case Some(B) =>
      case Some(t) => error(e, s"Expecting an expression of type B, but found $t.")
      case _ =>
    }

  def z(e: Exp)(implicit allowFun: Boolean): Unit =
    check(e) match {
      case Some(Z) =>
      case Some(t) => error(e, s"Expecting an expression of type Z, but found $t.")
      case _ =>
    }

  def zs(e: Exp)(implicit allowFun: Boolean): Unit =
    check(e) match {
      case Some(ZS) =>
      case Some(t) => error(e, s"Expecting an expression of type ZS, but found $t.")
      case _ =>
    }

  def tipe(id: Id): Option[Tipe] = typeMap.get(id.value) match {
    case Some((t, _)) => Some(t)
    case _ =>
      if (id.value.endsWith("_old")) {
        typeMap.get(id.value.substring(0, id.value.length - 4)) match {
          case Some((t, _)) => return Some(t)
          case _ =>
        }
      } else if (id.value.endsWith("_in")) {
        typeMap.get(id.value.substring(0, id.value.length - 3)) match {
          case Some((t, _)) => return Some(t)
          case _ =>
        }
      }
      error(id, s"Undeclared identifier ${id.value}.")
      None
  }

  def warn(n: Node, msg: String): Unit = {
    val li = nodeLocMap(n)
    reporter.warn(li.lineBegin, li.columnBegin, li.offset, msg)
  }

  def error(n: Node, msg: String): Unit = {
    val li = nodeLocMap(n)
    reporter.error(li.lineBegin, li.columnBegin, li.offset, msg)
  }
}


