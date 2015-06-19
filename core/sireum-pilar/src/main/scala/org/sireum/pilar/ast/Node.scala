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
}


import org.sireum.pilar.ast.Node._


sealed trait Node extends CaseClass


sealed trait Annotated {
  def annotations: NodeSeq[Annotation]
}


final case class
Model(annotations: NodeSeq[Annotation],
      elements: NodeSeq[ModelElement]) extends Node with Annotated


final case class
Annotation(id: Id,
           raw: Raw) extends Node


final case class
Id(value: String,
   simple: Boolean = true) extends Node


final case class
Raw(value: String,
    simple: Boolean = true) extends Node


sealed trait ModelElement extends Node with Annotated


final case class
GlobalVarDecl(id: Id,
              annotations: NodeSeq[Annotation]) extends ModelElement


final case class
ProcedureDecl(id: Id,
              params: NodeSeq[ParamDecl],
              annotations: NodeSeq[Annotation],
              bodyOpt: Option[ProcedureBody]) extends ModelElement


final case class
ParamDecl(id: Id,
          annotations: NodeSeq[Annotation]) extends Node with Annotated


final case class
ProcedureBody(locals: NodeSeq[LocalVarDecl],
              locations: NodeSeq[Location]) extends Node


final case class
LocalVarDecl(id: Id,
             annotations: NodeSeq[Annotation]) extends Node with Annotated


sealed trait Location extends Node with Annotated


final case class
CallLocation(label: Id,
             lhsOpt: Option[Exp],
             id: Id,
             args: NodeSeq[Exp],
             target: Id,
             annotations: NodeSeq[Annotation]) extends Location


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
             annotations: NodeSeq[Annotation]) extends Action


final case class
AssertAction(exp: Exp,
             annotations: NodeSeq[Annotation]) extends Action


final case class
AssumeAction(exp: Exp,
             annotations: NodeSeq[Annotation]) extends Action


final case class
ExtAction(id: Id,
          args: NodeSeq[Exp],
          annotations: NodeSeq[Annotation]) extends Action


sealed trait Jump extends Command


final case class
GotoJump(target: Id,
         annotations: NodeSeq[Annotation]) extends Jump


final case class
IfJump(exp: Exp,
       tTarget: Id,
       fTarget: Id,
       annotations: NodeSeq[Annotation]) extends Jump


final case class
ReturnJump(expOpt: Option[Exp],
           annotations: NodeSeq[Annotation]) extends Jump


final case class
SwitchJump(exp: Exp,
           cases: NodeSeq[SwitchCase],
           annotations: NodeSeq[Annotation]) extends Jump


final case class
SwitchCase(expOpt: Option[LiteralExp],
           target: Id) extends Node


final case class
ExtJump(id: Id,
        args: NodeSeq[Exp],
        annotations: NodeSeq[Annotation]) extends Jump


sealed trait Exp extends Node


final case class
LiteralExp(id: Id,
           raw: Raw) extends Exp


final case class
IdExp(id: Id) extends Exp


final case class
TupleExp(exps: NodeSeq[Exp],
         annotations: NodeSeq[Annotation]) extends Exp with Annotated


final case class
BinaryExp(left: Exp,
          op: Id,
          right: Exp) extends Exp


final case class
CallExp(exp: Exp,
        args: NodeSeq[Exp]) extends Exp
