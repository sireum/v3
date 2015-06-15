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

import NodeLocation.OFFSET_DEFAULT

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


abstract class AnnotatedNode {
  def annotations : AnnotationMap
}


object Model {
  def apply(annotations: AnnotationMap,
            elements: ISeq[ModelElement]) =
    ModelImpl(annotations, elements)

  def unapply(m: Model) = Some(m.elements)
}

abstract class Model extends AnnotatedNode {
  def elements: ISeq[ModelElement]
}

private[ast] final case class
ModelImpl(annotations: AnnotationMap,
          elements: ISeq[ModelElement],
          private[ast] var _offsetBegin: Int = OFFSET_DEFAULT,
          private[ast] var _offsetEnd: Int = OFFSET_DEFAULT)
  extends Model


object Id {
  def apply(value: String) = IdImpl(value.intern())

  def unapply(id: Id) = Some(id.value)
}

abstract class Id extends Node {
  def value : String
}

private[ast] final case class
IdImpl(value: String,
       private[ast] var _offsetBegin: Int = OFFSET_DEFAULT,
       private[ast] var _offsetEnd: Int = OFFSET_DEFAULT)
  extends Id


object Annotation {
  def apply(id: Id, raw: Any) = AnnotationImpl(id, raw)

  def unapply(a: Annotation) = Some((a.id, a.raw))
}

abstract class Annotation extends Node {
  def id : Id

  def raw[T] : T
}

private[ast] final case class
AnnotationImpl(id: Id,
               _raw: Any,
               private[ast] var _offsetBegin: Int = OFFSET_DEFAULT,
               private[ast] var _offsetEnd: Int = OFFSET_DEFAULT)
  extends Annotation {
  def raw[T] : T = _raw.asInstanceOf[T]
}


abstract class ModelElement extends AnnotatedNode
