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
    implicit reporter: Reporter): Unit = {
    implicit val nodeLocMap = program.nodeLocMap
    var typeMap = imapEmpty[String, (Tipe, Node)]
    for (f@Fun(id, _, _) <- program.fact.factOrFunDecls) {
      typeMap += id.value ->(tipe(f), f)
    }
    for (m@MethodDecl(id, _, _, _, _, _) <- program.block.stmts) {
      typeMap += id.value ->(tipe(m), m)
    }
  }

  private[tipe] final def tipe(t: Type): Tipe = t match {
    case t: BooleanType => B
    case t: IntType => Z
    case t: IntSeqType => ZS
  }

  private final def tipe(m: MethodDecl): FunTipe =
    FunTipe(m.params.map(p => tipe(p.tipe)),
      m.returnTypeOpt.map(tipe).getOrElse(UnitTipe))

  private final def tipe(f: Fun): FunTipe =
    FunTipe(f.params.map(p => tipe(p.tipe)),
      tipe(f.returnType))
}

private final case class TypeContext(typeMap: IMap[String, (Tipe, Node)])(
  implicit val nodeLocMap: MIdMap[Node, LocationInfo],
  reporter: Reporter) {

  private val someB = Some(B)
  private val someZ = Some(Z)
  private val someZS = Some(ZS)

  private[tipe] def check(e: Exp, allowMethod: Boolean = false)(
    implicit allowFun: Boolean): Option[Tipe] =
    e match {
      case _: BooleanLit => someB
      case e: Id => tipe(e)
      case e: Size => zs(e.id); someZ
      case e: Clone => zs(e.id); someZS
      case e: Result => tipe(Id("result"))
      case e: Apply =>
        if (!allowMethod || !allowFun)
          typeMap.get(e.id.value) match {
            case Some((_, md: MethodDecl)) if !allowMethod =>
              error(e.id, s"Method invocation is only allowed at statement level.")
            case Some((_, fun: Fun)) if !allowFun =>
              error(e.id, s"Use of proof function is only allowed in proof context.")
            case _ =>
          }
        check(e.id) match {
          case Some(t: Fn) =>
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
                error(e.right, s"The $op operator requires the same type on both left and right expressions, but found $t1 and $t2, respectively.")
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
        TypeContext(typeMap ++ e.ids.map(id => (id.value, (t, id)))).
          check(e.exp)
        someB
      case e: SeqLit => for (arg <- e.args) z(arg); someZS
    }

  def b(e: Exp): Unit =
    check(e)(allowFun = false) match {
      case Some(B) =>
      case Some(t) => error(e, s"Expecting type B, but found $t.")
      case _ =>
    }

  def z(e: Exp): Unit =
    check(e)(allowFun = false) match {
      case Some(Z) =>
      case Some(t) => error(e, s"Expecting type Z, but found $t.")
      case _ =>
    }

  def zs(e: Exp): Unit =
    check(e)(allowFun = false) match {
      case Some(ZS) =>
      case Some(t) => error(e, s"Expecting type ZS, but found $t.")
      case _ =>
    }

  def tipe(id: Id): Option[Tipe] = typeMap.get(id.value) match {
    case Some((t, _)) => Some(t)
    case _ =>
      error(id, s"Undeclared identifier ${
        id.value
      }.")
      None
  }

  def error(n: Node, msg: String): Unit = {
    val li = nodeLocMap(n)
    reporter.error(li.lineBegin, li.columnBegin, li.offset, msg)
  }
}


