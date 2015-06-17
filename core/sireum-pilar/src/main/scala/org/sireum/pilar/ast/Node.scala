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

  override def getChildren: ISeq[AnyRef] = {
    var r = ivectorEmpty[AnyRef]
    for (e <- productIterator) {
      r = r :+ e.asInstanceOf[AnyRef]
    }
    r
  }

  override def getNumOfChildren: Int = productArity
}


object NodeLocation {
  final val OFFSET_DEFAULT = -1
}

import org.sireum.pilar.ast.NodeLocation.OFFSET_DEFAULT

sealed trait NodeLocation {
  private[ast] var _offsetBegin: Int
  private[ast] var _offsetEnd: Int

  def hasOffset: Boolean =
    _offsetBegin != OFFSET_DEFAULT &&
      _offsetEnd != OFFSET_DEFAULT

  def offsetBegin: Int = _offsetBegin

  def offsetEnd: Int = _offsetEnd

  private[ast] def offsetBegin_=(offset: Int): Unit = {
    _offsetBegin = offset
  }

  private[ast] def offsetEnd_=(offset: Int): Unit = {
    _offsetEnd = offset
  }
}

object AnnotatedNode

sealed trait AnnotatedNode extends Node {
  def annotations: ISeq[Annotation]

  def annotation(id: String): Option[Annotation] =
    annotations.find(_.id.value == id)
}


object Model {
  def apply(annotations: ISeq[Annotation],
            elements: ISeq[ModelElement],
            offsetBegin: Int = OFFSET_DEFAULT,
            offsetEnd: Int = OFFSET_DEFAULT): Model =
    ModelImpl(annotations, elements, offsetBegin, offsetEnd)

  def unapply(m: Model) = Some(m.elements)
}

sealed trait Model extends AnnotatedNode {
  def elements: ISeq[ModelElement]

  def copy(annotations: ISeq[Annotation] = this.annotations,
           elements: ISeq[ModelElement] = this.elements,
           offsetBegin: Int = this.offsetBegin,
           offsetEnd: Int = this.offsetEnd): Model =
    Model(annotations, elements, offsetBegin, offsetEnd)
}

private[ast] final case class
ModelImpl(annotations: ISeq[Annotation],
          elements: ISeq[ModelElement],
          private[ast] var _offsetBegin: Int,
          private[ast] var _offsetEnd: Int)
  extends Model {

  override def make(children: AnyRef*): Model = {
    val Seq(anns: ISeq[_], es: ISeq[_], ob: Integer, oe: Integer) =
      children
    ModelImpl(cast(anns), cast(es), ob, oe)
  }
}


object Id {
  def apply(value: String,
            offsetBegin: Int = OFFSET_DEFAULT,
            offsetEnd: Int = OFFSET_DEFAULT): Id =
    IdImpl(value.intern(), offsetBegin, offsetEnd)

  def unapply(id: Id) = Some(id.value)
}

sealed trait Id extends Node {
  def value: String

  def copy(value: String = this.value,
           offsetBegin: Int = this.offsetBegin,
           offsetEnd: Int = this.offsetEnd): Id =
    Id(value, offsetBegin, offsetEnd)
}

private[ast] final case class
IdImpl(value: String,
       private[ast] var _offsetBegin: Int,
       private[ast] var _offsetEnd: Int)
  extends Id {

  override def make(children: AnyRef*): Id = {
    val Seq(value: String, ob: Integer, oe: Integer) =
      children
    IdImpl(value, ob, oe)
  }
}


object Raw {
  def apply(value: String,
            offsetBegin: Int = OFFSET_DEFAULT,
            offsetEnd: Int = OFFSET_DEFAULT): Raw =
    RawImpl(value, offsetBegin, offsetEnd)

  def unapply(raw: Raw) = Some(raw.value)
}

sealed trait Raw extends Node {
  def value: String

  def copy(value: String = this.value,
           offsetBegin: Int = this.offsetBegin,
           offsetEnd: Int = this.offsetEnd): Raw =
    Raw(value, offsetBegin, offsetEnd)
}

private[ast] final case class
RawImpl(value: String,
        private[ast] var _offsetBegin: Int,
        private[ast] var _offsetEnd: Int)
  extends Raw {

  override def make(children: AnyRef*): Raw = {
    val Seq(value: String, ob: Integer, oe: Integer) =
      children
    RawImpl(value, ob, oe)
  }
}


object Annotation {
  def apply(id: Id, raw: Raw,
            offsetBegin: Int = OFFSET_DEFAULT,
            offsetEnd: Int = OFFSET_DEFAULT): Annotation =
    AnnotationImpl(id, raw, offsetBegin, offsetEnd)

  def unapply(a: Annotation) = Some((a.id, a.raw))
}

sealed trait Annotation extends Node {
  def id: Id

  def raw: Raw

  def copy(id: Id = this.id,
           raw: Raw = this.raw,
           offsetBegin: Int = this.offsetBegin,
           offsetEnd: Int = this.offsetEnd): Annotation =
    Annotation(id, raw, offsetBegin, offsetEnd)
}

private[ast] final case class
AnnotationImpl(id: Id,
               raw: Raw,
               private[ast] var _offsetBegin: Int,
               private[ast] var _offsetEnd: Int)
  extends Annotation {

  override def make(children: AnyRef*): AnnotationImpl = {
    val Seq(id: Id, raw: Raw, ob: Integer, oe: Integer) =
      children
    AnnotationImpl(id, raw, ob, oe)
  }
}


sealed trait ModelElement extends AnnotatedNode


object GlobalVarDecl {
  def apply(id: Id, annotations: ISeq[Annotation],
            offsetBegin: Int = OFFSET_DEFAULT,
            offsetEnd: Int = OFFSET_DEFAULT): GlobalVarDecl =
    GlobalVarDeclImpl(id, annotations, offsetBegin, offsetEnd)

  def unapply(gvd: GlobalVarDecl) = Some(gvd.id)
}

sealed trait GlobalVarDecl extends ModelElement {
  def id: Id

  def copy(id: Id = this.id,
           annotations: ISeq[Annotation] = this.annotations,
           offsetBegin: Int = this.offsetBegin,
           offsetEnd: Int = this.offsetEnd): GlobalVarDecl =
    GlobalVarDecl(id, annotations, offsetBegin, offsetEnd)
}

private[ast] final case class
GlobalVarDeclImpl(id: Id,
                  annotations: ISeq[Annotation],
                  private[ast] var _offsetBegin: Int,
                  private[ast] var _offsetEnd: Int)
  extends GlobalVarDecl {

  override def make(children: AnyRef*): GlobalVarDeclImpl = {
    val Seq(id: Id, anns: ISeq[_], ob: Integer, oe: Integer) =
      children
    GlobalVarDeclImpl(id, cast(anns), ob, oe)
  }
}
