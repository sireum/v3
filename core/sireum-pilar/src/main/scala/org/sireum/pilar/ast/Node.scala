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

package org.sireum.pilar.ast

import org.sireum.util._

object Node {
  type NodeSeq[T <: Node] = IVector[T]

  final val json: Json = new Json
}


import org.sireum.pilar.ast.Node._
import org.sireum.pilar.ast.Internal._


sealed trait Node extends CaseClass


sealed trait Annotated {
  def annotations: NodeSeq[Annotation]
}


final case class
Model(annotations: NodeSeq[Annotation],
      elements: NodeSeq[ModelElement]) extends Node with Annotated {

  override val fieldNames = modelFieldNames

  override def make(children: AnyRef*) = model(children)
}


final case class
Annotation(id: Id,
           raw: Raw) extends Node {

  override val fieldNames = annotationFieldNames

  override def make(children: AnyRef*) = annotation(children)
}


final case class
Id(value: String,
   simple: Boolean = true) extends Node {

  override val fieldNames = idFieldNames

  override def make(children: AnyRef*) = id(children)
}


final case class
Raw(value: String,
    simple: Boolean = true) extends Node {

  override val fieldNames = rawFieldNames

  override def make(children: AnyRef*) = raw(children)
}


sealed trait ModelElement extends Node with Annotated


final case class
GlobalVarDecl(id: Id,
              annotations: NodeSeq[Annotation]) extends ModelElement {

  override val fieldNames = globalVarDeclFieldNames

  override def make(children: AnyRef*) = globalVarDecl(children)
}


final case class
ProcedureDecl(id: Id,
              params: NodeSeq[ParamDecl],
              annotations: NodeSeq[Annotation],
              bodyOpt: Option[ProcedureBody]) extends ModelElement {

  override val fieldNames = procedureDeclFieldNames

  override def make(children: AnyRef*) = procedureDecl(children)
}


final case class
ParamDecl(id: Id,
          annotations: NodeSeq[Annotation]) extends Node with Annotated {

  override val fieldNames = paramDeclFieldNames

  override def make(children: AnyRef*) = paramDecl(children)
}


final case class
ProcedureBody(locals: NodeSeq[LocalVarDecl],
              locations: NodeSeq[Location]) extends Node {

  override val fieldNames = procedureBodyFieldNames

  override def make(children: AnyRef*) = procedureBody(children)
}


final case class
LocalVarDecl(id: Id,
             annotations: NodeSeq[Annotation]) extends Node with Annotated {

  override val fieldNames = localVarDeclFieldNames

  override def make(children: AnyRef*) = localVarDecl(children)
}


sealed trait Location extends Node with Annotated


final case class
CallLocation(label: Id,
             lhsOpt: Option[Exp],
             id: Id,
             args: NodeSeq[Exp],
             target: Id,
             annotations: NodeSeq[Annotation]) extends Location {

  override val fieldNames = callLocationFieldNames

  override def make(children: AnyRef*) = callLocation(children)
}

final case class
BlockLocation(label: Id,
              actions: NodeSeq[Action],
              jump: Jump,
              annotations: NodeSeq[Annotation]) extends Location {
  {
    var i = 0
    while (i < actions.size) {
      actions(i).commandIndex = i
      i += 1
    }
    jump.commandIndex = i
  }

  override val fieldNames = blockLocationFieldNames

  override def make(children: AnyRef*) = blockLocation(children)
}


sealed trait Command extends Node with Annotated {
  private var _index = -1

  final def commandIndex = _index

  final private[ast] def commandIndex_=(i: Int): Unit = {
    _index = i
  }
}


sealed trait Action extends Command


final case class
AssignAction(lhs: Exp,
             rhs: Exp,
             annotations: NodeSeq[Annotation]) extends Action {

  override val fieldNames = assignActionFieldNames

  override def make(children: AnyRef*) = assignAction(children)
}


final case class
AssertAction(exp: Exp,
             annotations: NodeSeq[Annotation]) extends Action {

  override val fieldNames = assertActionFieldNames

  override def make(children: AnyRef*) = assertAction(children)
}


final case class
AssumeAction(exp: Exp,
             annotations: NodeSeq[Annotation]) extends Action {

  override val fieldNames = assumeActionFieldNames

  override def make(children: AnyRef*) = assumeAction(children)
}


final case class
ExtAction(id: Id,
          args: NodeSeq[Exp],
          annotations: NodeSeq[Annotation]) extends Action {

  override val fieldNames = extActionFieldNames

  override def make(children: AnyRef*) = extAction(children)
}


sealed trait Jump extends Command


final case class
GotoJump(target: Id,
         annotations: NodeSeq[Annotation]) extends Jump {

  override val fieldNames = gotoJumpFieldNames

  override def make(children: AnyRef*) = gotoJump(children)
}


final case class
IfJump(exp: Exp,
       tTarget: Id,
       fTarget: Id,
       annotations: NodeSeq[Annotation]) extends Jump {

  override val fieldNames = ifJumpFieldNames

  override def make(children: AnyRef*) = ifJump(children)
}


final case class
ReturnJump(expOpt: Option[Exp],
           annotations: NodeSeq[Annotation]) extends Jump {

  override val fieldNames = returnJumpFieldNames

  override def make(children: AnyRef*) = returnJump(children)
}


final case class
SwitchJump(exp: Exp,
           cases: NodeSeq[SwitchCase],
           annotations: NodeSeq[Annotation]) extends Jump {

  override val fieldNames = switchJumpFieldNames

  override def make(children: AnyRef*) = switchJump(children)
}


final case class
SwitchCase(expOpt: Option[LiteralExp],
           target: Id) extends Node {

  override val fieldNames = switchCaseFieldNames

  override def make(children: AnyRef*) = switchCase(children)
}


final case class
ExtJump(id: Id,
        args: NodeSeq[Exp],
        annotations: NodeSeq[Annotation]) extends Jump {

  override val fieldNames = extJumpFieldNames

  override def make(children: AnyRef*) = extJump(children)
}


sealed trait Exp extends Node


final case class
LiteralExp(id: Id,
           raw: Raw) extends Exp {

  override val fieldNames = literalExpFieldNames

  override def make(children: AnyRef*) = literalExp(children)
}


final case class
IdExp(id: Id) extends Exp {

  override val fieldNames = idExpFieldNames

  override def make(children: AnyRef*) = idExp(children)
}


final case class
TupleExp(exps: NodeSeq[Exp],
         annotations: NodeSeq[Annotation]) extends Exp with Annotated {

  override val fieldNames = tupleExpFieldNames

  override def make(children: AnyRef*) = tupleExp(children)
}


final case class
BinaryExp(left: Exp,
          op: Id,
          right: Exp) extends Exp {

  override val fieldNames = binaryExpFieldNames

  override def make(children: AnyRef*) = binaryExp(children)
}


final case class
CallExp(exp: Exp,
        args: NodeSeq[Exp]) extends Exp {

  override val fieldNames = callExpFieldNames

  override def make(children: AnyRef*) = callExp(children)
}
