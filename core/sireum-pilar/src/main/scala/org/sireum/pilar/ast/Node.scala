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


sealed abstract class Node extends NodeLocation


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


abstract class AnnotatedNode extends Node {
  def annotations: ISeq[Annotation]

  def annotation(id: String): Option[Annotation] =
    annotations.find(_.id.value == id)
}


object Model {
  def apply(annotations: ISeq[Annotation],
            elements: ISeq[ModelElement]): Model =
    ModelImpl(annotations, elements)

  def unapply(m: Model) = Some(m.elements)
}

abstract class Model extends AnnotatedNode {
  def elements: ISeq[ModelElement]
}

private[ast] final case class
ModelImpl(annotations: ISeq[Annotation],
          elements: ISeq[ModelElement],
          private[ast] var _offsetBegin: Int = OFFSET_DEFAULT,
          private[ast] var _offsetEnd: Int = OFFSET_DEFAULT)
  extends Model


object Id {
  def apply(value: String): Id = IdImpl(value.intern())

  def unapply(id: Id) = Some(id.value)
}

abstract class Id extends Node {
  def value: String
}

private[ast] final case class
IdImpl(value: String,
       private[ast] var _offsetBegin: Int = OFFSET_DEFAULT,
       private[ast] var _offsetEnd: Int = OFFSET_DEFAULT)
  extends Id


object Raw {
  def apply(value: String): Raw = RawImpl(value)

  def unapply(raw: Raw) = Some(raw.value)
}

abstract class Raw extends Node {
  def value: String
}

private[ast] final case class
RawImpl(value: String,
        private[ast] var _offsetBegin: Int = OFFSET_DEFAULT,
        private[ast] var _offsetEnd: Int = OFFSET_DEFAULT)
  extends Raw


object Annotation {
  def apply(id: Id, raw: Raw): Annotation = AnnotationImpl(id, raw)

  def unapply(a: Annotation) = Some((a.id, a.raw))
}

abstract class Annotation extends Node {
  def id: Id

  def raw: Raw
}

private[ast] final case class
AnnotationImpl(id: Id,
               raw: Raw,
               private[ast] var _offsetBegin: Int = OFFSET_DEFAULT,
               private[ast] var _offsetEnd: Int = OFFSET_DEFAULT)
  extends Annotation


abstract class ModelElement extends AnnotatedNode


object GlobalVarDecl {
  def apply(id: Id, annotations: ISeq[Annotation]): GlobalVarDecl =
    GlobalVarDeclImpl(id, annotations)

  def unapply(gvd: GlobalVarDecl) = Some(gvd.id)
}

abstract class GlobalVarDecl extends ModelElement {
  def id: Id
}

private[ast] final case class
GlobalVarDeclImpl(id: Id,
                  annotations: ISeq[Annotation],
                  private[ast] var _offsetBegin: Int = OFFSET_DEFAULT,
                  private[ast] var _offsetEnd: Int = OFFSET_DEFAULT)
  extends GlobalVarDecl
