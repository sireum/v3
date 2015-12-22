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

package org.sireum.logika.ast

import org.sireum.logika.util._
import org.sireum.logika.tipe._
import org.sireum.util._

object Node {
  type Seq[T] = IVector[T]

  final def emptySeq[T] = ivectorEmpty[T]

  final def seq[T](es: T*) = ivector(es: _*)

  final def seq[T](es: Iterable[T]) = es.toVector

  final private[ast] def detectMode(unitNode: UnitNode): Unit = {
    var m = LogicMode.Propositional
    Visitor.build({
      case _: IntType | _: BooleanType | _: IntSeqType |
           _: BooleanLit | _: SeqLit =>
        m = LogicMode.Programming
        false
      case _: Mul | _: Div | _: Rem | _: Add | _: Sub |
           _: Lt | _: Le | _: Gt | _: Ge |
           _: Minus | _: IntLit |
           _: Apply | _: Quant if m == LogicMode.Propositional =>
        m = LogicMode.Predicate
        false
    })(unitNode)
    unitNode.mode = m
  }

  final private[ast] def checkWellFormed(unitNode: UnitNode)
                                        (implicit reporter: Reporter): Unit = {
    val nodeLocMap = unitNode.nodeLocMap.clone
    val isPredicate = unitNode.mode == LogicMode.Predicate
    val isProgram = unitNode.mode == LogicMode.Programming
    var applyMap = imapEmpty[String, Apply]
    lazy val v: Any => Boolean = Visitor.build({
      case n: Quant =>
        if (isPredicate) n.domainOpt match {
          case Some(_) =>
            val li = nodeLocMap(n.ids.last)
            reporter.error(li.lineBegin, li.columnBegin, li.offset,
              s"Predicate logic mode disallows explicit type specification in quantifications.")
          case _ =>
        } else if (isProgram && n.domainOpt.isEmpty) {
          val li = nodeLocMap(n.ids.last)
          reporter.error(li.lineBegin, li.columnBegin, li.offset,
            s"Program logic mode requires explicit type specification in quantifications.")
        }
        true
      case n: QuantAssumeStep =>
        if (isPredicate) n.typeOpt match {
          case Some(_) =>
            val li = nodeLocMap(n.id)
            reporter.error(li.lineBegin, li.columnBegin, li.offset,
              s"Predicate logic mode disallows explicit type specification in quantifications.")
          case _ =>
        } else if (isProgram && n.typeOpt.isEmpty) {
          val li = nodeLocMap(n.id)
          reporter.error(li.lineBegin, li.columnBegin, li.offset,
            s"Program logic mode requires explicit type specification in quantifications.")
        }
        true
      case n@Id(id) if !isProgram =>
        applyMap.get(id) match {
          case Some(a) =>
            if (a.args.nonEmpty) {
              val a2Li = nodeLocMap(a)
              reporter.error(a2Li.lineBegin, a2Li.columnBegin, a2Li.offset,
                s"The number of arguments for $id differs from the one at [${a2Li.lineBegin}, ${a2Li.columnBegin}].")
            }
          case _ =>
            val a = Apply(n, Node.emptySeq)
            nodeLocMap(a) = nodeLocMap(n)
            applyMap += (id -> a)
        }
        false
      case a@Apply(Id(id), args) if !isProgram =>
        applyMap.get(id) match {
          case Some(a2) =>
            if (a2.args.size != a.args.size) {
              val aLi = nodeLocMap(a)
              val a2Li = nodeLocMap(a2)
              reporter.error(aLi.lineBegin, aLi.columnBegin, aLi.offset,
                s"The number of arguments for $id differs from the one at [${a2Li.lineBegin}, ${a2Li.columnBegin}].")
            }
          case _ => applyMap += (id -> a)
        }
        for (arg <- args) v(arg)
        false
      case w: While =>
        for (s <- w.block.stmts) s match {
          case _: MethodDecl =>
            val sLi = nodeLocMap(s)
            reporter.error(sLi.lineBegin, sLi.columnBegin, sLi.offset,
              s"Methods cannot be defined inside a while-block.")
          case _ =>
        }
        true
      case i: If =>
        for (s <- i.trueBlock.stmts ++ i.falseBlock.stmts) s match {
          case _: MethodDecl =>
            val sLi = nodeLocMap(s)
            reporter.error(sLi.lineBegin, sLi.columnBegin, sLi.offset,
              s"Methods cannot be defined inside an if-block.")
          case _ =>
        }
        true
      case m: MethodDecl =>
        for (s <- m.block.stmts) s match {
          case _: MethodDecl =>
            val sLi = nodeLocMap(s)
            reporter.error(sLi.lineBegin, sLi.columnBegin, sLi.offset,
              s"Methods cannot be defined inside another method.")
          case _ =>
        }
        true
    })
    v(unitNode)
    if (unitNode.mode == LogicMode.Programming) unitNode match {
      case _: Program =>
      case _ =>
        reporter.error(s"Standalone sequent cannot use algebra.")
    }
  }
}

object LogicMode {
  private var counter = 0
  final val Propositional = LogicMode("Propositional")
  final val Predicate = LogicMode("Predicate")
  final val Programming = LogicMode("Program")
  val valueOf: ILinkedMap[String, LogicMode] = ilinkedMap(
    Propositional.value -> Propositional,
    Predicate.value -> Predicate,
    Programming.value -> Programming
  )

  def valueOf(index: Int): LogicMode =
    valueOf.values.toSeq(index)
}

final case class LogicMode private(value: String) {
  val ordinal = {
    val o = LogicMode.counter
    LogicMode.counter += 1
    o
  }

  override def toString = value
}

sealed trait Node extends Product

sealed trait UnitNode extends Node {
  var nodeLocMap: MIdMap[Node, LocationInfo] = midmapEmpty
  var mode = LogicMode.Programming
}

final case class Sequent(premises: Node.Seq[Exp],
                         conclusions: Node.Seq[Exp],
                         proofOpt: Option[Proof])
  extends UnitNode {
  private val eqs = (premises.toSet, conclusions.toSet)
  override val hashCode: Int = eqs.hashCode

  Node.detectMode(this)
}

sealed trait ProofStep extends Node {
  def num: Num
}

sealed trait NumOrId extends Node

final case class Num(value: Natural) extends NumOrId

sealed trait ProofGroup extends Node {
  def steps: Node.Seq[ProofStep]

  def allSteps: Node.Seq[ProofStep]

  def first: ProofStep

  def last: ProofStep
}

final case class Proof(steps: Node.Seq[ProofStep])
  extends UnitNode with ProofGroup {
  Node.detectMode(this)

  override def allSteps = steps

  override def first = steps.head

  override def last = steps.last
}

sealed trait RegularStep extends ProofStep {
  def exp: Exp
}

final case class Premise(num: Num,
                         exp: Exp) extends RegularStep

final case class AndIntro(num: Num,
                          exp: And,
                          leftStep: Num,
                          rightStep: Num) extends RegularStep

final case class AndElim1(num: Num,
                          exp: Exp,
                          andStep: Num) extends RegularStep

final case class AndElim2(num: Num,
                          exp: Exp,
                          andStep: Num) extends RegularStep

final case class OrIntro1(num: Num,
                          exp: Or,
                          step: Num) extends RegularStep

final case class OrIntro2(num: Num,
                          exp: Or,
                          step: Num) extends RegularStep

final case class OrElim(num: Num,
                        exp: Exp,
                        orStep: Num,
                        leftSubProof: Num,
                        rightSubProof: Num) extends RegularStep

final case class ImpliesIntro(num: Num,
                              exp: Implies,
                              subProof: Num)
  extends RegularStep

final case class ImpliesElim(num: Num,
                             exp: Exp,
                             impliesStep: Num,
                             antecedentStep: Num)
  extends RegularStep

final case class NegIntro(num: Num,
                          exp: Not,
                          subProof: Num) extends RegularStep

final case class NegElim(num: Num,
                         exp: Exp,
                         step: Num,
                         negStep: Num) extends RegularStep

final case class BottomElim(num: Num,
                            exp: Exp,
                            falseStep: Num) extends RegularStep

final case class Pbc(num: Num,
                     exp: Exp,
                     subProof: Num) extends RegularStep

final case class ForAllIntro(num: Num,
                             exp: ForAll,
                             subProof: Num)
  extends RegularStep

final case class ForAllElim(num: Num,
                            exp: Exp,
                            stepOrFact: NumOrId,
                            args: Node.Seq[Exp])
  extends RegularStep

final case class ExistsIntro(num: Num,
                             exp: Exists,
                             step: Num,
                             args: Node.Seq[Exp])
  extends RegularStep

final case class ExistsElim(num: Num,
                            exp: Exp,
                            stepOrFact: NumOrId,
                            subProof: Num) extends RegularStep

final case class Algebra(num: Num,
                         exp: Exp,
                         nums: Node.Seq[NumOrId])
  extends RegularStep

final case class Invariant(num: Num,
                           exp: Exp)
  extends RegularStep

final case class Auto(num: Num,
                      exp: Exp,
                      stepOrFacts: Node.Seq[NumOrId])
  extends RegularStep

final case class SubProof(num: Num,
                          assumeStep: AssumeStep,
                          steps: Node.Seq[ProofStep])
  extends ProofStep with ProofGroup {

  override def allSteps = assumeStep +: steps

  override def first = assumeStep

  override def last =
    if (steps.isEmpty) assumeStep else steps.last
}

sealed trait AssumeStep extends ProofStep

final case class PlainAssumeStep(num: Num,
                                 exp: Exp)
  extends AssumeStep with RegularStep

sealed trait QuantAssumeStep extends AssumeStep {
  def id: Id

  def typeOpt: Option[Type]
}

final case class ForAllAssumeStep(num: Num,
                                  id: Id,
                                  typeOpt: Option[Type])
  extends QuantAssumeStep

final case class ExistsAssumeStep(num: Num,
                                  id: Id,
                                  typeOpt: Option[Type],
                                  exp: Exp)
  extends QuantAssumeStep with RegularStep

sealed trait Exp extends Node {
  private[ast] var hasParen = false
}

final case class BooleanLit(value: Boolean) extends Exp

final case class Id(value: String) extends Exp with NumOrId

final case class Size(id: Id) extends Exp

final case class Clone(id: Id) extends Exp

final case class Result() extends Exp

final case class Apply(id: Id,
                       args: Node.Seq[Exp]) extends Exp

final case class ReadInt(msgOpt: Option[StringLit])
  extends Exp

final case class IntLit(value: String) extends Exp

sealed trait BinaryExp extends Exp {
  def left: Exp

  def op: String

  def right: Exp
}

final case class Mul(left: Exp, right: Exp) extends BinaryExp {
  val op = "*"
}

final case class Div(left: Exp, right: Exp) extends BinaryExp {
  val op = "/"
}

final case class Rem(left: Exp, right: Exp) extends BinaryExp {
  val op = "%"
}

final case class Add(left: Exp, right: Exp) extends BinaryExp {
  val op = "+"
}

final case class Sub(left: Exp, right: Exp) extends BinaryExp {
  val op = "-"
}

final case class Lt(left: Exp, right: Exp) extends BinaryExp {
  val op = "<"
}

final case class Le(left: Exp, right: Exp) extends BinaryExp {
  val op = "<="
}

final case class Gt(left: Exp, right: Exp) extends BinaryExp {
  val op = ">"
}

final case class Ge(left: Exp, right: Exp) extends BinaryExp {
  val op = ">="
}

final case class Eq(left: Exp, right: Exp) extends BinaryExp {
  val op = "=="
}

final case class Ne(left: Exp, right: Exp) extends BinaryExp {
  val op = "!="
}

final case class Append(left: Exp, right: Exp) extends BinaryExp {
  val op = "+:"
}

final case class Prepend(left: Exp, right: Exp) extends BinaryExp {
  val op = ":+"
}

final case class And(left: Exp, right: Exp) extends BinaryExp {
  val op = "&&"
}

final case class Or(left: Exp, right: Exp) extends BinaryExp {
  val op = "||"
}

final case class Implies(left: Exp, right: Exp) extends BinaryExp {
  val op = "->"
}

sealed trait UnaryExp extends Exp {
  def op: String

  def exp: Exp
}

final case class Not(exp: Exp) extends UnaryExp {
  val op = "!"
}

final case class Minus(exp: Exp) extends UnaryExp {
  val op = "-"
}

sealed trait Quant extends Exp {
  def op: String

  def ids: Node.Seq[Id]

  def domainOpt: Option[QuantDomain]

  def exp: Exp
}

final case class ForAll(ids: Node.Seq[Id],
                        domainOpt: Option[QuantDomain],
                        exp: Exp)
  extends Quant {
  val op = "all"
  val ids2 = ids :+ Id("x")
  val ids3 = Id("x") +: ids
}

final case class Exists(ids: Node.Seq[Id],
                        domainOpt: Option[QuantDomain],
                        exp: Exp)
  extends Quant {
  val op = "some"
}

sealed trait QuantDomain extends Node

final case class TypeDomain(tpe: Type) extends QuantDomain

final case class RangeDomain(lo: Exp, hi: Exp) extends QuantDomain

final case class SeqLit(args: Node.Seq[Exp]) extends Exp

final case class Program(fact: Facts,
                         block: Block) extends UnitNode

final case class Block(stmts: Node.Seq[Stmt]) extends Node

sealed trait Stmt extends Node

final case class VarDecl(isVar: Boolean,
                         id: Id,
                         tpe: Type) extends Stmt

final case class Assign(id: Id,
                        exp: Exp) extends Stmt

final case class Assert(exp: Exp) extends Stmt

final case class ExpStmt(exp: Apply) extends Stmt

final case class If(exp: Exp,
                    trueBlock: Block,
                    falseBlock: Block) extends Stmt

final case class While(exp: Exp,
                       block: Block,
                       loopInv: LoopInv) extends Stmt

final case class LoopInv(invariant: Inv,
                         modifies: Modifies) extends Node

final case class Print(isNewline: Boolean,
                       msg: StringLit) extends Stmt

final case class StringLit(value: String) extends Stmt

final case class SeqAssign(id: Id,
                           index: Exp,
                           exp: Exp) extends Stmt

final case class MethodDecl(id: Id,
                            params: Node.Seq[Param],
                            returnTypeOpt: Option[Type],
                            contract: MethodContract,
                            block: Block,
                            returnExpOpt: Option[Exp])
  extends Stmt

final case class MethodContract(requires: Requires,
                                modifies: Modifies,
                                ensures: Ensures)
  extends Stmt

final case class Requires(exps: Node.Seq[Exp]) extends Node

final case class Modifies(ids: Node.Seq[Id]) extends Node

final case class Ensures(exps: Node.Seq[Exp]) extends Node

final case class Param(id: Id,
                       tpe: Type) extends Node

final case class ProofStmt(proof: Proof) extends Stmt {
  var typeMap: IMap[String, Tipe] = imapEmpty
}

final case class SequentStmt(sequent: Sequent) extends Stmt {
  var typeMap: IMap[String, Tipe] = imapEmpty
}

final case class InvStmt(inv: Inv) extends Stmt

final case class Inv(exps: Node.Seq[Exp]) extends Node

final case class Facts(factOrFunDecls: Node.Seq[FactOrFun]) extends Node

sealed trait FactOrFun extends Node

final case class Fact(id: Id,
                      exp: Exp) extends FactOrFun

final case class Fun(id: Id,
                     params: Node.Seq[Param],
                     returnType: Type) extends FactOrFun

sealed trait Type extends Node

final case class BooleanType() extends Type

final case class IntType() extends Type

final case class IntSeqType() extends Type
