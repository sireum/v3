/*
Copyright (c) 2015, Robby, Kansas State University
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of the <organization> nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SE RVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.sireum.pilar.ast

import org.sireum.util._


object Node

sealed trait Node
  extends NodeLocation
  with Rewritable
  with Product {

  final override val hashCode: Int =
    subTree.hashCode()

  final override def equals(other: Any): Boolean =
    other match {
      case other: Node =>
        ProductUtil.equals(subTree, other.subTree)
      case _ => false
    }

  final override def getChildren: ISeq[AnyRef] =
    ProductUtil.getChildren(this)

  final override def getNumOfChildren: Int =
    ProductUtil.getNumOfChildren(this)

  private[ast] def subTree: Product
}


object NodeLocation {
  final val LOC_DEFAULT = -1
}

import org.sireum.pilar.ast.NodeLocation.LOC_DEFAULT

sealed trait NodeLocation {
  private[ast] var _line: Int
  private[ast] var _column: Int

  final def hasLoc: Boolean =
    _line != LOC_DEFAULT &&
      _column != LOC_DEFAULT

  final def line: Int = _line

  final def column: Int = _column

  final private[ast] def line_=(line: Int): Unit = {
    _line = line
  }

  final private[ast] def column_=(column: Int): Unit = {
    _column = column
  }
}

object AnnotatedNode

sealed trait AnnotatedNode extends Node {
  final def annotation(id: String): Option[Annotation] =
    annotations.find(_.id.value == id)

  def annotations: ISeq[Annotation]
}


object Model {
  final def apply(annotations: ISeq[Annotation],
                  elements: ISeq[ModelElement],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): Model =
    ModelImpl(annotations, elements, line, column)

  final def unapply(m: Model) = Some(m.elements)
}

sealed trait Model extends AnnotatedNode {
  final private[ast] def subTree = (annotations, elements)

  final def copy(annotations: ISeq[Annotation] = this.annotations,
                 elements: ISeq[ModelElement] = this.elements,
                 line: Int = this.line,
                 column: Int = this.column): Model =
    Model(annotations, elements, line, column)

  def elements: ISeq[ModelElement]
}

private final case class
ModelImpl(annotations: ISeq[Annotation],
          elements: ISeq[ModelElement],
          private[ast] var _line: Int,
          private[ast] var _column: Int)
  extends Model {

  override def make(children: AnyRef*): Model = {
    val Seq(anns: ISeq[_], es: ISeq[_], ob: Integer, oe: Integer) =
      children
    ModelImpl(cast(anns), cast(es), ob, oe)
  }
}


object Id {
  final def apply(value: String,
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): Id =
    IdImpl(value.intern(), line, column)

  final def unapply(id: Id) = Some(id.value)
}

sealed trait Id extends Node {
  final private[ast] def subTree = Tuple1(value)

  final def copy(value: String = this.value,
                 line: Int = this.line,
                 column: Int = this.column): Id =
    Id(value, line, column)

  def value: String
}

private final case class
IdImpl(value: String,
       private[ast] var _line: Int,
       private[ast] var _column: Int)
  extends Id {

  override def make(children: AnyRef*): Id = {
    val Seq(value: String, ob: Integer, oe: Integer) =
      children
    IdImpl(value, ob, oe)
  }
}


object Raw {
  final def apply(value: String,
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): Raw =
    RawImpl(value, line, column)

  final def unapply(raw: Raw) = Some(raw.value)
}

sealed trait Raw extends Node {
  final private[ast] def subTree = Tuple1(value)

  final def copy(value: String = this.value,
                 line: Int = this.line,
                 column: Int = this.column): Raw =
    Raw(value, line, column)

  def value: String
}

private final case class
RawImpl(value: String,
        private[ast] var _line: Int,
        private[ast] var _column: Int)
  extends Raw {

  override def make(children: AnyRef*): Raw = {
    val Seq(value: String, ob: Integer, oe: Integer) =
      children
    RawImpl(value, ob, oe)
  }
}


object Annotation {
  final def apply(id: Id, raw: Raw,
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): Annotation =
    AnnotationImpl(id, raw, line, column)

  final def unapply(a: Annotation) = Some(a.subTree)
}

sealed trait Annotation extends Node {
  final private[ast] def subTree = (id, raw)

  final def copy(id: Id = this.id,
                 raw: Raw = this.raw,
                 line: Int = this.line,
                 column: Int = this.column): Annotation =
    Annotation(id, raw, line, column)

  def id: Id

  def raw: Raw
}

private final case class
AnnotationImpl(id: Id,
               raw: Raw,
               private[ast] var _line: Int,
               private[ast] var _column: Int)
  extends Annotation {

  override def make(children: AnyRef*): Annotation = {
    val Seq(id: Id, raw: Raw, ob: Integer, oe: Integer) =
      children
    AnnotationImpl(id, raw, ob, oe)
  }
}


sealed trait ModelElement extends AnnotatedNode


object GlobalVarDecl {
  final def apply(id: Id, annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): GlobalVarDecl =
    GlobalVarDeclImpl(id, annotations, line, column)

  final def unapply(gvd: GlobalVarDecl) = Some(gvd.id)
}

sealed trait GlobalVarDecl extends ModelElement {
  final private[ast] def subTree = (id, annotations)

  final def copy(id: Id = this.id,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.column): GlobalVarDecl =
    GlobalVarDecl(id, annotations, line, column)

  def id: Id
}

private final case class
GlobalVarDeclImpl(id: Id,
                  annotations: ISeq[Annotation],
                  private[ast] var _line: Int,
                  private[ast] var _column: Int)
  extends GlobalVarDecl {

  override def make(children: AnyRef*): GlobalVarDecl = {
    val Seq(id: Id, anns: ISeq[_], ob: Integer, oe: Integer) =
      children
    GlobalVarDeclImpl(id, cast(anns), ob, oe)
  }
}


sealed trait Exp extends Node


object BinaryExp {
  final def apply(left: Exp, op: Id, right: Exp,
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): BinaryExp =
    BinaryExpImpl(left, op, right, line, column)

  final def unapply(e: BinaryExp) = Some(e.subTree)
}

sealed trait BinaryExp extends Exp {
  final private[ast] def subTree = (left, op, right)

  def left: Exp

  def op: Id

  def right: Exp
}

private final case class
BinaryExpImpl(left: Exp,
              op: Id,
              right: Exp,
              private[ast] var _line: Int,
              private[ast] var _column: Int)
  extends BinaryExp {

  override def make(children: AnyRef*): BinaryExp = {
    val Seq(left: Exp, op: Id, right: Exp, ob: Integer, oe: Integer) =
      children
    BinaryExpImpl(left, op, right, ob, oe)
  }
}


object TupleExp {
  final def apply(exps: ISeq[Exp],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): TupleExp =
    TupleExpImpl(exps, line, column)

  final def unapply(e: TupleExp) = Some(e.exps)
}

sealed trait TupleExp extends Exp {
  final private[ast] def subTree = Tuple1(exps)

  def exps: ISeq[Exp]
}

private final case class
TupleExpImpl(exps: ISeq[Exp],
             private[ast] var _line: Int,
             private[ast] var _column: Int)
  extends TupleExp {

  override def make(children: AnyRef*): TupleExp = {
    val Seq(exps: ISeq[_], ob: Integer, oe: Integer) =
      children
    TupleExpImpl(cast(exps), ob, oe)
  }
}


object IdExp {
  final def apply(id: Id,
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): IdExp =
    IdExpImpl(id, line, column)

  final def unapply(e: IdExp) = Some(e.id)
}

sealed trait IdExp extends Exp {
  final private[ast] def subTree = Tuple1(id)

  def id: Id
}

private final case class
IdExpImpl(id: Id,
          private[ast] var _line: Int,
          private[ast] var _column: Int)
  extends IdExp {

  override def make(children: AnyRef*): IdExp = {
    val Seq(id: Id, ob: Integer, oe: Integer) =
      children
    IdExpImpl(id, ob, oe)
  }
}


object LiteralExp {
  final def apply(id: Id, raw: Raw,
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): LiteralExp =
    LiteralExpImpl(id, raw, line, column)

  final def unapply(e: LiteralExp) = Some(e.subTree)
}

sealed trait LiteralExp extends Exp {
  final private[ast] def subTree = (id, raw)

  def id: Id

  def raw: Raw
}

private final case class
LiteralExpImpl(id: Id,
               raw: Raw,
               private[ast] var _line: Int,
               private[ast] var _column: Int)
  extends LiteralExp {

  override def make(children: AnyRef*): LiteralExp = {
    val Seq(id: Id, raw: Raw, ob: Integer, oe: Integer) =
      children
    LiteralExpImpl(id, raw, ob, oe)
  }
}
