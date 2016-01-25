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

package org.sireum.awas.ast

import org.sireum.util._

object Node {
  type Seq[T] = IVector[T]

  final def emptySeq[T] = ivectorEmpty[T]

  final def seq[T](es: T*) = ivector(es: _*)

  final def seq[T](es: Iterable[T]) = es.toVector
}

sealed trait Node extends Product

sealed trait TypeDecl extends Node

final case class Model(types: Node.Seq[TypeDecl],
                       constants: Node.Seq[ConstantDecl],
                       components: Node.Seq[ComponentDecl],
                       connections: Node.Seq[ConnectionDecl]) extends Node {
  var nodeLocMap: MIdMap[Node, LocationInfo] = midmapEmpty
}

final case class ConstantDecl(name: Name, constType: Type, init: Init) extends Node

final case class ComponentDecl(compName: Name,
                               ports: Node.Seq[Port],
                               flows: Node.Seq[Flow],
                               properties: Node.Seq[Property]) extends Node

final case class ConnectionDecl(connName: Name,
                                fromComp: Name,
                                fromPort: Id,
                                fromE:Node.Seq[Name],
                                toComp: Name,
                                toPort: Id,
                                toE:Node.Seq[Name],
                                properties:Node.Seq[Property]) extends Node

final case class Port(isIn : Boolean, id : Id, name: Option[Name]) extends Node

final case class Flow(id: Id,
                      from: Option[Id],
                      fromE: Node.Seq[Name],
                      to:Option[Id],
                      toE: Node.Seq[Name]) extends Node

final case class Property(id: Id, PropType: Type, value: Option[Init]) extends Node

final case class AliasDecl(name: Name, typeName: Type) extends TypeDecl

final case class EnumDecl(name: Name,
                          superEnums: Node.Seq[Name],
                          elements: Node.Seq[Id]) extends TypeDecl

final case class LatticeDecl(name: Name,
                             superLattice: Node.Seq[Name]) extends TypeDecl

final case class RecordDecl(name: Name, fields: Node.Seq[FieldDecl]) extends TypeDecl

final case class FieldDecl(id : Id, fieldType: Type) extends Node

object Id {
  def apply(value: String): Id = _Id(value.intern())

  def unapply(id: Id): Option[String] = Some(id.value)
}

sealed trait Id extends Node {
  def value: String
}

private final case class
_Id(value: String) extends Id {
  override def toString =
    s"Id($value)"
}

final case class Name(value: Node.Seq[Id]) extends Node

sealed trait Init extends Node

final case class BooleanInit(value: Boolean) extends Init

final case class IntegerInit(value: Integer) extends Init

final case class RealInit(value: Double) extends Init

final case class StringInit(value: String) extends Init

final case class RecordInit(name: Name, fields: IMap[Id, Init]) extends Init

final case class NameRefInit(name: Name, ref: Option[Id]) extends Init

final case class NoneInit(typeInit: Type) extends Init

final case class SomeInit(typeInit: Type, value: Init) extends Init

final case class SetInit(typeInit: Type, value: ISet[Init]) extends Init

final case class SeqInit(typeInit: Type, value: Node.Seq[Init]) extends Init

final case class MapInit(keyType: BasicType,
                         valueType: Type,
                         value: IMap[Init, Init]) extends Init


//-----------------------Types---------------------------//
sealed trait Type extends Node

sealed trait CompoundType extends Type

sealed trait BasicType extends Type

final case class OptionTypeDecl(typeVal : Type) extends CompoundType

final case class SetTypeDecl(typeVal : Type) extends CompoundType

final case class SeqTypeDecl(typeVal : Type) extends CompoundType

final case class MapTypeDecl(keyType: BasicType,
                             valueType: Type) extends CompoundType

final case class BooleanTypeDecl() extends BasicType

final case class IntegerTypeDecl(value: Option[(IntTypeDisc, IntTypeDisc)])
  extends BasicType

sealed trait IntTypeDisc extends Node

final case class IntLit(value: Integer) extends IntTypeDisc

final case class NamedIntType(value: Name) extends IntTypeDisc

final case class ArbitrartyIntType() extends IntTypeDisc

final case class RealTypeDecl() extends BasicType

final case class StringTypeDecl() extends BasicType

final case class ComponentTypeDecl() extends BasicType

final case class PortTypeDecl() extends BasicType

final case class NamedTypeDecl(value: Name) extends BasicType