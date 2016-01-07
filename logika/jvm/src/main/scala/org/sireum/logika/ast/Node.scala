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

package org.sireum.logika.ast

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
           _: IntLit | _: SeqLit |
           _: Mul | _: Div | _: Rem | _: Add | _: Sub |
           _: Lt | _: Le | _: Gt | _: Ge |
           _: Minus =>
        m = LogicMode.Programming
        false
      case _: Apply | _: Quant[_] if m == LogicMode.Propositional =>
        m = LogicMode.Predicate
        false
    })(unitNode)
    unitNode.mode = m
  }

  implicit class At[T <: Node](n: Node)(
    implicit val nodeLocMap: MMap[Node, LocationInfo]) {
    def at(li: LocationInfo): T = {
      nodeLocMap(n) = li
      n.asInstanceOf[T]
    }

    def at(liBegin: LocationInfo, liEnd: LocationInfo): T = {
      nodeLocMap(n) = LocationInfo(
        lineBegin = liBegin.lineBegin,
        columnBegin = liBegin.columnBegin,
        offset = liBegin.offset,
        lineEnd = liEnd.lineEnd,
        columnEnd = liEnd.columnEnd,
        length = liEnd.offset + liEnd.length - liBegin.offset
      )
      n.asInstanceOf[T]
    }
  }

  final private[ast] def checkWellFormed(unitNode: UnitNode)
                                        (implicit reporter: AccumulatingTagReporter): Unit = {
    val nodeLocMap = unitNode.nodeLocMap.clone
    def error(n: Node, msg: String): Unit =
      reporter.report(nodeLocMap(n).toLocationError(
        unitNode.fileUriOpt, "Semantics", msg))

    val isPredicate = unitNode.mode == LogicMode.Predicate
    val isProgram = unitNode.mode == LogicMode.Programming
    var applyMap = imapEmpty[String, Apply]
    lazy val v: Any => Boolean = Visitor.build({
      case n: Quant[_] =>
        if (isPredicate)
          n.domainOpt match {
            case Some(d) =>
              error(d, s"Predicate logic mode disallows explicit type specification in quantifications.")
            case _ =>
          }
        else if (isProgram && n.domainOpt.isEmpty)
          error(n, s"Program logic mode requires explicit type specification in quantifications.")
        true
      case n: QuantAssumeStep =>
        if (isPredicate)
          n.typeOpt match {
            case Some(t) =>
              error(t, s"Predicate logic mode disallows explicit type specification in quantifications.")
            case _ =>
          }
        else if (isProgram && n.typeOpt.isEmpty)
          error(n, s"Program logic mode requires explicit type specification in quantifications.")
        true
      case n@Id(id) if !isProgram =>
        applyMap.get(id) match {
          case Some(a) =>
            if (a.args.nonEmpty) {
              val aLi = nodeLocMap(a)
              error(n, s"Identifier $id is used as a variable here but it was at [${aLi.lineBegin}, ${aLi.columnBegin}] as an uninterpreted function.")
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
              val a2Li = nodeLocMap(a2)
              error(a, s"The number of arguments for $id differs from the one at [${a2Li.lineBegin}, ${a2Li.columnBegin}].")
            }
          case _ => applyMap += (id -> a)
        }
        for (arg <- args) v(arg)
        false
      case w: While =>
        for (s <- w.block.stmts) s match {
          case _: MethodDecl =>
            error(s, s"Methods cannot be defined inside a while-block.")
          case _ =>
        }
        true
      case i: If =>
        for (s <- i.trueBlock.stmts ++ i.falseBlock.stmts) s match {
          case _: MethodDecl =>
            error(s, s"Methods cannot be defined inside an if-block.")
          case _ =>
        }
        true
      case m: MethodDecl =>
        for (s <- m.block.stmts) {
          s match {
            case _: MethodDecl =>
              error(s, s"Methods cannot be defined inside another method.")
            case _ =>
          }
          Visitor.build({
            case n: InvStmt =>
              error(s, s"Invariants cannot be defined inside a method.")
              false
            case n: Invariant =>
              error(s, s"Invariant justification cannot be used inside a method.")
              false
          })(s)
        }
        true
    })
    v(unitNode)
    if (unitNode.mode == LogicMode.Programming) unitNode match {
      case _: Program =>
      case _ =>
        reporter.report(ErrorMessage("Semantics", "Standalone sequent cannot use algebra."))
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
  var fileUriOpt: Option[FileResourceUri] = None
  var nodeLocMap: MIdMap[Node, LocationInfo] = midmapEmpty
  var mode = LogicMode.Programming
  var input: String = ""
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
  extends ProofGroup {
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

final case class Subst1(num: Num,
                        exp: Exp,
                        eqStep: NumOrId,
                        step: Num) extends RegularStep

final case class Subst2(num: Num,
                        exp: Exp,
                        eqStep: NumOrId,
                        step: Num) extends RegularStep

final case class Algebra(num: Num,
                         exp: Exp,
                         nums: Node.Seq[NumOrId])
  extends RegularStep

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

object Exp {
  final def toString(e: Exp, inProof: Boolean): String = {
    val sb = new StringBuilder
    e.buildString(sb, inProof)
    sb.toString
  }
}

sealed trait Exp extends Node {
  private[ast] var hasParen = false

  def buildString(sb: StringBuilder, inProof: Boolean): Unit

  def precedence: Int
}

sealed trait PrimaryExp extends Exp {
  final override def precedence: Int = 0
}

final case class BooleanLit(value: Boolean) extends PrimaryExp {
  override def buildString(sb: StringBuilder,
                           inProof: Boolean): Unit =
    sb.append(if (value) "T" else "F")
}

final case class Id(value: String) extends PrimaryExp with NumOrId {
  var tipe: Tipe = _

  override def buildString(sb: StringBuilder,
                           inProof: Boolean): Unit =
    sb.append(value)
}

final case class Size(id: Id) extends PrimaryExp {
  override def buildString(sb: StringBuilder,
                           inProof: Boolean): Unit = {
    id.buildString(sb, inProof)
    sb.append(".size")
  }
}

final case class Clone(id: Id) extends PrimaryExp {
  override def buildString(sb: StringBuilder,
                           inProof: Boolean): Unit = {
    id.buildString(sb, inProof)
    sb.append(".clone")
  }
}

final case class Result() extends PrimaryExp {
  var tipe: Tipe = _

  override def buildString(sb: StringBuilder,
                           inProof: Boolean): Unit = {
    sb.append("result")
  }
}

final case class Apply(id: Id,
                       args: Node.Seq[Exp]) extends PrimaryExp {
  var declOpt: Option[MethodDecl] = None

  override def buildString(sb: StringBuilder,
                           inProof: Boolean): Unit = {
    id.buildString(sb, inProof)
    sb.append('(')
    if (args.nonEmpty) {
      args.head.buildString(sb, inProof)
      for (arg <- args.tail) {
        sb.append(", ")
        arg.buildString(sb, inProof)
      }
    }
    sb.append(')')
  }
}

final case class RandomInt() extends PrimaryExp {
  override def buildString(sb: StringBuilder,
                           inProof: Boolean): Unit = {
    sb.append("randomInt()")
  }
}

final case class ReadInt(msgOpt: Option[StringLit])
  extends PrimaryExp {
  override def buildString(sb: StringBuilder,
                           inProof: Boolean): Unit = {
    sb.append("readInt()")
  }
}

final case class IntLit(value: String) extends PrimaryExp {
  override def buildString(sb: StringBuilder,
                           inProof: Boolean): Unit = {
    val n = BigInt(value)
    if (n < Int.MinValue || n > Int.MaxValue) {
      sb.append("Z(\"")
      sb.append(value)
      sb.append("\")")
    } else sb.append(value)
  }
}

sealed trait BinaryExp extends Exp {
  def left: Exp

  def op(inProof: Boolean): String

  def right: Exp

  final override def buildString(sb: StringBuilder,
                                 inProof: Boolean): Unit = {
    if (left.precedence > precedence) {
      sb.append('(')
      left.buildString(sb, inProof)
      sb.append(')')
    } else {
      left.buildString(sb, inProof)
    }
    sb.append(' ')
    sb.append(op(inProof))
    sb.append(' ')
    if (right.precedence > precedence) {
      sb.append('(')
      right.buildString(sb, inProof)
      sb.append(')')
    } else {
      right.buildString(sb, inProof)
    }
  }
}

sealed trait MultiplicativeExp extends BinaryExp {
  final override val precedence = 10
}

final case class Mul(left: Exp, right: Exp) extends MultiplicativeExp {
  def op(inProof: Boolean) = "*"
}

final case class Div(left: Exp, right: Exp) extends MultiplicativeExp {
  def op(inProof: Boolean) = "/"
}

final case class Rem(left: Exp, right: Exp) extends MultiplicativeExp {
  def op(inProof: Boolean) = "%"
}

sealed trait AdditiveExp extends BinaryExp {
  final override val precedence = 20
}

final case class Add(left: Exp, right: Exp) extends AdditiveExp {
  def op(inProof: Boolean) = "+"
}

final case class Sub(left: Exp, right: Exp) extends AdditiveExp {
  def op(inProof: Boolean) = "-"
}

sealed trait InequalityExp extends BinaryExp {
  final override val precedence = 50
}

final case class Lt(left: Exp, right: Exp) extends InequalityExp {
  def op(inProof: Boolean) = "<"
}

final case class Le(left: Exp, right: Exp) extends InequalityExp {
  def op(inProof: Boolean) = if (inProof) "≤" else "<="
}

final case class Gt(left: Exp, right: Exp) extends InequalityExp {
  def op(inProof: Boolean) = ">"
}

final case class Ge(left: Exp, right: Exp) extends InequalityExp {
  def op(inProof: Boolean) = if (inProof) "≥" else ">="
}

sealed trait EqualityExp extends BinaryExp {
  var tipe: Tipe = _

  final override val precedence = 40
}

final case class Eq(left: Exp, right: Exp) extends EqualityExp {
  def op(inProof: Boolean) = "=="
}

final case class Ne(left: Exp, right: Exp) extends EqualityExp {
  def op(inProof: Boolean) = if (inProof) "≠" else "!="
}

final case class Append(left: Exp, right: Exp) extends BinaryExp {
  def op(inProof: Boolean) = ":+"

  override val precedence = 40
}

final case class Prepend(left: Exp, right: Exp) extends BinaryExp {
  def op(inProof: Boolean) = "+:"

  override val precedence = 30
}

final case class And(left: Exp, right: Exp) extends BinaryExp {
  def op(inProof: Boolean) = if (inProof) "∧" else "&"

  override val precedence = 60
}

object And {
  def apply(args: ISeq[Exp]): Exp =
    if (args.isEmpty) BooleanLit(value = true)
    else {
      var r = args.head
      for (arg <- args.tail) {
        r = And(arg, r)
      }
      r
    }
}

final case class Or(left: Exp, right: Exp) extends BinaryExp {
  def op(inProof: Boolean) = if (inProof) "∨" else "|"

  override val precedence = 80
}

object Or {
  def apply(args: ISeq[Exp]): Exp =
    if (args.isEmpty) BooleanLit(value = false)
    else {
      var r = args.head
      for (arg <- args.tail) {
        r = Or(arg, r)
      }
      r
    }
}

final case class Implies(left: Exp, right: Exp) extends BinaryExp {
  def op(inProof: Boolean) = if (inProof) "→" else "->"

  override val precedence = 90
}

sealed trait UnaryExp extends Exp {
  def op(inProof: Boolean): String

  def exp: Exp

  final override def buildString(sb: StringBuilder,
                                 inProof: Boolean): Unit = {
    sb.append(op(inProof))
    if (exp.precedence > precedence) {
      sb.append('(')
      exp.buildString(sb, inProof)
      sb.append(')')
    } else exp.buildString(sb, inProof)
  }
}

final case class Not(exp: Exp) extends UnaryExp {
  def op(inProof: Boolean) = if (inProof) "¬" else "!"

  override def precedence: Int = 40
}

final case class Minus(exp: Exp) extends UnaryExp {
  def op(inProof: Boolean) = "-"

  override def precedence: Int = 20
}

sealed trait Quant[T <: Quant[T]] extends Exp {
  def op: String

  def ids: Node.Seq[Id]

  def domainOpt: Option[QuantDomain]

  def exp: Exp

  override val precedence = 100

  override final def buildString(sb: StringBuilder,
                                 inProof: Boolean): Unit = {
    sb.append(op)
    sb.append(' ')
    ids.head.buildString(sb, inProof)
    for (id <- ids.tail) {
      sb.append(", ")
      id.buildString(sb, inProof)
    }
    sb.append(' ')
    domainOpt match {
      case Some(t: TypeDomain) =>
        sb.append(": ")
        t.tpe.buildString(sb)
        sb.append(' ')
      case Some(r: RangeDomain) =>
        sb.append(": (")
        r.lo.buildString(sb, inProof)
        sb.append(" .. ")
        r.hi.buildString(sb, inProof)
        sb.append(") ")
      case None =>
    }
    exp.buildString(sb, inProof)
  }

  private var simplified: T = _

  final def simplify
  (implicit nodeLocMap: MIdMap[Node, LocationInfo]): T = {
    if (simplified != null) return simplified
    simplified =
      domainOpt match {
        case Some(rd@RangeDomain(lo, hi, loLt, hiLt)) =>
          val loLi = nodeLocMap(lo)
          val hiLi = nodeLocMap(hi)
          val rdLi = nodeLocMap(rd)
          val isForAll = isInstanceOf[ForAll]
          def range(id: Id, l: Exp, h: Exp): And = {
            val lApply = if (loLt) Lt else Le
            val rApply = if (hiLt) Lt else Le
            And(lApply(l, id) at loLi, rApply(id, h) at hiLi) at rdLi
          }
          val apply = if (isForAll) ForAll else Exists
          var antecedent = range(ids.head, lo, hi)
          for (id <- ids.tail) {
            val idLi = nodeLocMap(id)
            antecedent = And(antecedent, range(id, lo, hi)) at(idLi, rdLi)
          }
          val expLi = nodeLocMap(exp)
          apply(ids, Some(TypeDomain(IntType())),
            Implies(antecedent, exp) at(rdLi, expLi)).asInstanceOf[T]
        case _ => this.asInstanceOf[T]
      }
    simplified
  }
}

final case class ForAll(ids: Node.Seq[Id],
                        domainOpt: Option[QuantDomain],
                        exp: Exp)
  extends Quant[ForAll] {
  val op = "∀"
  val ids2 = ids :+ Id("x")
  val ids3 = Id("x") +: ids
}

final case class Exists(ids: Node.Seq[Id],
                        domainOpt: Option[QuantDomain],
                        exp: Exp)
  extends Quant[Exists] {
  val op = "∃"
}

sealed trait QuantDomain extends Node

final case class TypeDomain(tpe: Type) extends QuantDomain

final case class RangeDomain(lo: Exp,
                             hi: Exp,
                             loLt: Boolean,
                             hiLt: Boolean) extends QuantDomain

final case class SeqLit(args: Node.Seq[Exp]) extends PrimaryExp {
  override def buildString(sb: StringBuilder,
                           inProof: Boolean): Unit = {
    sb.append("ZS(")
    if (args.nonEmpty) {
      args.head.buildString(sb, inProof)
      for (arg <- args.tail) {
        sb.append(", ")
        arg.buildString(sb, inProof)
      }
      sb.append(')')
    }
  }
}

final case class Program(fact: Facts,
                         block: Block) extends UnitNode

final case class Block(stmts: Node.Seq[Stmt]) extends Node

sealed trait Stmt extends Node

sealed trait VarAssign extends Stmt {
  def id: Id

  def exp: Exp
}

final case class VarDecl(isVar: Boolean,
                         id: Id,
                         tpe: Type,
                         exp: Exp) extends VarAssign

final case class Assign(id: Id,
                        exp: Exp) extends VarAssign

final case class Assume(exp: Exp) extends Stmt

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

final case class StringLit(value: String) extends Node

final case class SeqAssign(id: Id,
                           index: Exp,
                           exp: Exp) extends Stmt

final case class MethodDecl(isHelper: Boolean,
                            id: Id,
                            params: Node.Seq[Param],
                            returnTypeOpt: Option[Type],
                            contract: MethodContract,
                            block: Block,
                            returnExpOpt: Option[Exp])
  extends Stmt

final case class MethodContract(requires: Requires,
                                modifies: Modifies,
                                ensures: Ensures)
  extends Node

final case class Requires(exps: Node.Seq[Exp]) extends Node

final case class Modifies(ids: Node.Seq[Id]) extends Node

final case class Ensures(exps: Node.Seq[Exp]) extends Node

final case class Param(id: Id,
                       tpe: Type) extends Node

sealed trait ProofElementStmt extends Stmt

final case class ProofStmt(proof: Proof) extends ProofElementStmt

final case class SequentStmt(sequent: Sequent) extends ProofElementStmt

final case class InvStmt(inv: Inv) extends ProofElementStmt

final case class Inv(exps: Node.Seq[Exp]) extends Node

final case class Facts(factOrFunDecls: Node.Seq[FactOrFun]) extends Node

sealed trait FactOrFun extends Node

final case class Fact(id: Id,
                      exp: Exp) extends FactOrFun

final case class Fun(id: Id,
                     params: Node.Seq[Param],
                     returnType: Type) extends FactOrFun

object Type {
  final def toString(t: Type): String = {
    val sb = new StringBuilder
    t.buildString(sb)
    sb.toString
  }
}

sealed trait Type extends Node {
  def buildString(sb: StringBuilder): Unit
}

final case class BooleanType() extends Type {
  override def buildString(sb: StringBuilder): Unit =
    sb.append("B")
}

final case class IntType() extends Type {
  override def buildString(sb: StringBuilder): Unit =
    sb.append("Z")
}

final case class IntSeqType() extends Type {
  override def buildString(sb: StringBuilder): Unit =
    sb.append("ZS")
}
