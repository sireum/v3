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
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.sireum.pilar.ast

import scala.util.Success

object Picklers {
  implicit val nodeJsonPickler = {
    import prickle._
    import Pickler._

    implicit val idPickler =
      CompositePickler[Id].concreteType[IdImpl]
    implicit val rawPickler =
      CompositePickler[Raw].concreteType[RawImpl]
    implicit val annotationPickler =
      CompositePickler[Annotation].concreteType[AnnotationImpl]
    implicit val modelElementPickler =
      CompositePickler[ModelElement].
        concreteType[GlobalVarDeclImpl]
    implicit val modelPickler =
      CompositePickler[Model].concreteType[ModelImpl]

    CompositePickler[Node].
      concreteType[AnnotationImpl].
      concreteType[GlobalVarDeclImpl].
      concreteType[IdImpl].
      concreteType[ModelImpl].
      concreteType[RawImpl]
  }

  implicit val nodeJsonBPickler = {
    import boopickle._
    import Pickler._

    implicit val idPickler =
      CompositePickler[Id].addConcreteType[IdImpl]
    implicit val rawPickler =
      CompositePickler[Raw].addConcreteType[RawImpl]
    implicit val annotationPickler =
      CompositePickler[Annotation].addConcreteType[AnnotationImpl]
    implicit val modelElementPickler =
      CompositePickler[ModelElement].
        addConcreteType[GlobalVarDeclImpl]
    implicit val modelPickler =
      CompositePickler[Model].addConcreteType[ModelImpl]

    CompositePickler[Node].
      addConcreteType[AnnotationImpl].
      addConcreteType[GlobalVarDeclImpl].
      addConcreteType[IdImpl].
      addConcreteType[ModelImpl].
      addConcreteType[RawImpl]
  }

  def fromJson[T <: Node](s: String): T = {
    prickle.Unpickle[Node].fromString(s) match {
      case Success(n) => n.asInstanceOf[T]
      case _ => throw new Error(s"Error deserializing AST from:\n$s")
    }
  }

  def fromJson[T <: Node](b: Array[Byte]): T = {
    boopickle.Unpickle[Node].
      fromBytes(java.nio.ByteBuffer.wrap(b)).asInstanceOf[T]
  }

  def toJsonString(node: Node) =
    prickle.Pickle.intoString(node)

  def toJsonBytes(node: Node) =
    boopickle.Pickle.intoBytes(node).array()
}
