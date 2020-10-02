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
import org.sireum.util.Json.{Extern, InternString}

object Node {
  type Seq[T] = IVector[T]

  final def emptySeq[T] = ivectorEmpty[T]

  final def seq[T](es: T*) = ivector(es: _*)

  final def seq[T](es: Iterable[T]) = es.toVector

  final def externFrom(name: String) = org.sireum.pilar.ast.Json.externMap(name)._1

  final def externTo(name: String) = org.sireum.pilar.ast.Json.externMap(name)._2

  final def extern(name: String, fg: (Any --\ String, String --\ Any)): Unit = {
    org.sireum.pilar.ast.Json.externMap(name) = fg
  }

  trait CommandExtractor {
    def extractor: Command --\ Product
  }

  trait LocationExtractor {
    def extractor: Location --\ Product
  }
}

sealed trait Node extends Product

sealed trait Annotated {
  def annotations: Node.Seq[Annotation]
}


final case class
Model(elements: Node.Seq[ModelElement],
      annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Node with Annotated {
  var nodeLocMap: MIdMap[Node, LocationInfo] = midmapEmpty

  def +(other: Model): Model = {
    val r = Model(elements ++ other.elements, annotations ++ other.annotations)
    r.nodeLocMap ++= other.nodeLocMap
    r
  }
}


final case class
Annotation(id: Id,
           lit: Lit) extends Node

object Id {
  def apply(value: String): Id = _Id(value.intern())

  def unapply(id: Id): Option[String] = Some(id.value)
}

sealed trait Id extends Node {
  def value: String
}

@InternString
private final case class
_Id(value: String) extends Id {
  override def toString =
    s"Id($value)"
}


sealed trait Lit extends Node

final case class
RawLit(value: String) extends Lit

final case class
ExtLit(@Extern value: Any) extends Lit


sealed trait ModelElement extends Node with Annotated


final case class
GlobalVarDecl(id: Id,
              annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends ModelElement


final case class
ProcedureDecl(id: Id,
              params: Node.Seq[ParamDecl],
              bodyOpt: Option[ProcedureBody],
              annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends ModelElement


final case class
ParamDecl(id: Id,
          annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Node with Annotated


final case class
ProcedureBody(locals: Node.Seq[LocalVarDecl],
              locations: Node.Seq[Location]) extends Node


final case class
LocalVarDecl(id: Id,
             annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Node with Annotated


sealed trait Location extends Node with Annotated {
  def label: Id
}


final case class
CallLocation(label: Id,
             lhsOpt: Option[Exp],
             id: Id,
             args: Node.Seq[Exp],
             target: Id,
             annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Location


final case class
BlockLocation(label: Id,
              actions: Node.Seq[Action],
              jump: Jump,
              annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Location {
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
  private var _index: NaturalSentinel = naturalSentinel

  final def commandIndex = _index

  final private[ast] def commandIndex_=(i: Natural): Unit = {
    _index = i
  }

  def add(a: Annotation): Command
}


sealed trait Action extends Command


final case class
AssignAction(lhs: Exp,
             rhs: Exp,
             annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Action {
  def add(a: Annotation) = copy(annotations = annotations :+ a)
}


final case class
AssertAction(exp: Exp,
             annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Action {
  def add(a: Annotation) = copy(annotations = annotations :+ a)
}


final case class
AssumeAction(exp: Exp,
             annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Action {
  def add(a: Annotation) = copy(annotations = annotations :+ a)
}


final case class
ExtAction(id: Id,
          args: Node.Seq[Exp],
          annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Action {
  def add(a: Annotation) = copy(annotations = annotations :+ a)
}


sealed trait Jump extends Command


final case class
GotoJump(target: Id,
         annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Jump {
  def add(a: Annotation) = copy(annotations = annotations :+ a)
}


final case class
IfJump(exp: Exp,
       tTarget: Id,
       fTarget: Id,
       annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Jump {
  def add(a: Annotation) = copy(annotations = annotations :+ a)
}


final case class
ReturnJump(expOpt: Option[Exp],
           annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Jump {
  def add(a: Annotation) = copy(annotations = annotations :+ a)
}


final case class
SwitchJump(exp: Exp,
           cases: Node.Seq[SwitchCase],
           annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Jump {
  {
    for (i <- 0 until cases.length - 1) {
      assert(cases(i).expOpt.isDefined)
    }
  }

  def add(a: Annotation) = copy(annotations = annotations :+ a)
}


final case class
SwitchCase(expOpt: Option[LiteralExp],
           target: Id) extends Node


final case class
ExtJump(id: Id,
        args: Node.Seq[Exp],
        annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Jump {
  def add(a: Annotation) = copy(annotations = annotations :+ a)
}


sealed trait Exp extends Node


final case class
LiteralExp(id: Id,
           lit: Lit) extends Exp


final case class
IdExp(id: Id) extends Exp


final case class
TupleExp(exps: Node.Seq[Exp],
         annotations: Node.Seq[Annotation] = Node.emptySeq)
  extends Exp with Annotated


object BinaryExp {
  def apply(left: Exp,
            op: Id,
            right: Exp) =
    InfixExp(left, op, right)

  def unapply(g: InfixExp) =
    if (g.rest.isEmpty)
      Some((g.left, g.op, g.right))
    else None
}


final case class
InfixExp(left: Exp,
         op: Id,
         right: Exp,
         rest: Node.Seq[(Id, Exp)] = Node.emptySeq)
  extends Exp

final case class
ExtExp(exp: Exp,
       args: Node.Seq[Exp])
  extends Exp
