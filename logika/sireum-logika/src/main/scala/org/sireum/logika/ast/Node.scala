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

import org.sireum.util._

object Node {
  type Seq[T] = IVector[T]

  final def emptySeq[T] = ivectorEmpty[T]

  final def seq[T](es: T*) = ivector(es: _*)

  final def seq[T](es: Iterable[T]) = es.toVector
}

sealed trait Node extends Product

sealed trait NumOrId extends Node

final case class Num(value: Natural) extends NumOrId

sealed trait UnitNode extends Node {
  var nodeLocMap: MIdMap[Node, LocationInfo] = midmapEmpty
}

final case class Sequent(premises: Node.Seq[Exp],
                         conclusions: Node.Seq[Exp],
                         proof: Option[Proof]) extends UnitNode

final case class Proof(proofSteps: Node.Seq[ProofStep]) extends UnitNode

sealed trait ProofStep extends Node {
  def num: Num
}

sealed trait RegularStep extends ProofStep {
  def exp: Exp
}

final case class Premise(num: Num,
                         exp: Exp) extends RegularStep

final case class AndIntro(num: Num,
                          exp: Exp,
                          leftStep: Num,
                          rightStep: Num) extends RegularStep

final case class AndElim1(num: Num,
                          exp: Exp,
                          andStep: Num) extends RegularStep

final case class AndElim2(num: Num,
                          exp: Exp,
                          andStep: Num) extends RegularStep

final case class OrIntro1(num: Num,
                          exp: Exp,
                          orStep: Num) extends RegularStep

final case class OrIntro2(num: Num,
                          exp: Exp,
                          orStep: Num) extends RegularStep

final case class OrElim(num: Num,
                        exp: Exp,
                        orStep: Num,
                        leftSubProof: Num,
                        rightSubProof: Num) extends RegularStep

final case class ImpliesIntro(num: Num,
                              exp: Exp,
                              impliesStep: Num) extends RegularStep

final case class ImpliesElim(num: Num,
                             exp: Exp,
                             impliesStep: Num,
                             antecedentStep: Num) extends RegularStep

final case class NegIntro(num: Num,
                          exp: Exp,
                          subProof: Num) extends RegularStep

final case class NegElim(num: Num,
                         exp: Exp,
                         step: Num,
                         negStep: Num) extends RegularStep

final case class FalseElim(num: Num,
                           exp: Exp,
                           falseStep: Num) extends RegularStep

final case class Pbc(num: Num,
                     exp: Exp,
                     subProof: Num) extends RegularStep

final case class ForallIntro(num: Num,
                             exp: Exp,
                             subProof: Num) extends RegularStep

final case class ForallElim(num: Num,
                            exp: Exp,
                            stepOrFact: NumOrId,
                            args: Node.Seq[Exp]) extends RegularStep

final case class ExistsIntro(num: Num,
                             exp: Exp,
                             stepOrFact: NumOrId,
                             args: Node.Seq[Exp]) extends RegularStep

final case class ExistsElim(num: Num,
                            exp: Exp,
                            stepOrFact: NumOrId,
                            subProof: Num) extends RegularStep

final case class Algebra(num: Num,
                         exp: Exp,
                         stepOrFact: NumOrId,
                         nums: Node.Seq[Num]) extends RegularStep

final case class Auto(num: Num,
                      exp: Exp,
                      stepOrFacts: Node.Seq[NumOrId]) extends RegularStep

final case class SubProof(num: Num,
                          assume: AssumeStep,
                          steps: Node.Seq[ProofStep]) extends UnitNode

sealed trait AssumeStep extends ProofStep

final case class PlainAssumeStep(num: Num,
                                 exp: Exp)
  extends AssumeStep with RegularStep

final case class ForallAssumeStep(num: Num,
                                  id: Id) extends AssumeStep

final case class ExistsAssumeStep(num: Num,
                                  id: Id,
                                  exp: Exp)
  extends AssumeStep with RegularStep

sealed trait Exp extends Node

final case class BooleanLit(value: Boolean) extends Exp

final case class Id(value: String) extends Exp with NumOrId

final case class Paren(exp: Exp) extends Exp {
  override def hashCode(): Int = exp.hashCode()

  override def equals(other: Any): Boolean = exp.equals(other)
}

case object Result extends Exp

final case class Apply(id: Id,
                       args: Node.Seq[Exp]) extends Exp

final case class IntLit(value: BigInt) extends Exp

sealed trait BinaryExp {
  def left: Exp

  def op: String

  def right: Exp
}

final case class Mul(left: Exp, right: Exp) extends Exp {
  val op = "*"
}

final case class Div(left: Exp, right: Exp) extends Exp {
  val op = "/"
}

final case class Rem(left: Exp, right: Exp) extends Exp {
  val op = "%"
}

final case class Add(left: Exp, right: Exp) extends Exp {
  val op = "+"
}

final case class Sub(left: Exp, right: Exp) extends Exp {
  val op = "-"
}

final case class Lt(left: Exp, right: Exp) extends Exp {
  val op = "<"
}

final case class Le(left: Exp, right: Exp) extends Exp {
  val op = "<="
}

final case class Gt(left: Exp, right: Exp) extends Exp {
  val op = ">"
}

final case class Ge(left: Exp, right: Exp) extends Exp {
  val op = ">="
}

final case class Eq(left: Exp, right: Exp) extends Exp {
  val op = "=="
}

final case class Ne(left: Exp, right: Exp) extends Exp {
  val op = "!="
}

final case class And(left: Exp, right: Exp) extends Exp {
  val op = "&&"
}

final case class Or(left: Exp, right: Exp) extends Exp {
  val op = "||"
}

final case class Implies(left: Exp, right: Exp) extends Exp {
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

sealed trait Quant extends Node {
  def op: String

  def ids: Node.Seq[Id]

  def exp: Exp
}

final case class All(ids: Node.Seq[Id], exp: Exp) extends Quant {
  val op = "all"
  val ids2 = ids :+ Id("x")
  val ids3 = Id("x") +: ids
}

final case class Some(ids: Node.Seq[Id], exp: Exp) extends Quant {
  val op = "some"
}

final case class Seq(args: Node.Seq[Exp]) extends Exp

final case class Program(block: Block) extends UnitNode

final case class Block(stmts: Node.Seq[Stmt]) extends Node

sealed trait Stmt extends Node

final case class VarDecl(isVar: Boolean,
                         id: Id,
                         tipe: Type) extends Stmt

final case class Assign(id: Id,
                        exp: Exp) extends Stmt

final case class Assert(exp: Exp) extends Stmt

final case class If(exp: Exp,
                    trueBlock: Block,
                    falseBlock: Block) extends Stmt

final case class While(exp: Exp,
                       block: Block,
                       loopInvOpt: Option[LoopInv]) extends Stmt

final case class LoopInv(invariants: Node.Seq[Exp],
                         modifies: Node.Seq[Id]) extends Node

final case class ReadInt(id: Id,
                         msgOpt: Option[StringLit]) extends Stmt

final case class Print(isNewline: Boolean,
                       msg: StringLit) extends Stmt

final case class StringLit(value: String) extends Stmt

final case class MethodInvoke(idOpt: Option[Id],
                              methodId: Id,
                              args: Node.Seq[Exp]) extends Stmt

final case class SeqClone(lhs: Id,
                          rhs: Id) extends Stmt

final case class SeqAssign(id: Id,
                           index: Exp,
                           exp: Exp) extends Stmt

final case class SeqPend(isPrepend: Boolean,
                         id: Id,
                         exp: Exp) extends Stmt

final case class MethodDecl(id: Id,
                            params: Node.Seq[Param],
                            returnType: Option[Type],
                            contract: MethodContract,
                            block: Block,
                            returnExp: Option[Exp]) extends Stmt

final case class MethodContract(requiresOpt: Option[Exp],
                                modifies: Node.Seq[Id],
                                ensures: Option[Exp]) extends Stmt

final case class Param(id: Id,
                       tipe: Type) extends Node

final case class ProofStmt(proof: Proof) extends Stmt

final case class SequentStmt(sequent: Sequent) extends Stmt

final case class InvStmt(invs: Node.Seq[Exp]) extends Stmt

final case class FactStmt(exps: Node.Seq[Quant]) extends Stmt

sealed trait Type extends Node

case object BooleanType extends Type

case object IntType extends Type

case object IntSeqType extends Type
