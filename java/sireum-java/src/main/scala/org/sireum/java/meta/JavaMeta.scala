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

package org.sireum.java.meta

import org.sireum.util._
import org.sireum.util.Json.InternString

object JavaMeta {
  type Seq[T] = IVector[T]
}

import JavaMeta._

sealed trait JavaMeta extends Product

final case class Class(version: Int,
                       modifiers: Seq[Modifier.Type],
                       name: String,
                       signatureOpt: Option[String],
                       superNameOpt: Option[String],
                       interfaces: Seq[String],
                       sourceOpt: Option[String],
                       debugOpt: Option[String],
                       outerClassOpt: Option[OuterClass],
                       innerClasses: Seq[InnerClass],
                       attributes: Seq[Attribute]) extends JavaMeta

final case class EntityAnnotation(annotation: Annotation,
                                  visible: Boolean) extends JavaMeta

final case class OuterClass(name: String,
                            methodNameDescOpt: Option[(String, String)]) extends JavaMeta

final case class InnerClass(name: String,
                            outerNameOpt: Option[String],
                            innerNameOpt: Option[String],
                            modifiers: Seq[Modifier.Type])

object Modifier extends Enum("") {
  type Type = Value
  final val Abstract = Value("Abstract")
  final val Annotation = Value("Annotation")
  final val Bridge = Value("Bridge")
  final val Deprecated = Value("Deprecated")
  final val Enum = Value("Enum")
  final val Final = Value("Final")
  final val Interface = Value("Interface")
  final val Mandated = Value("Mandated")
  final val Native = Value("Native")
  final val Private = Value("Private")
  final val Protected = Value("Protected")
  final val Public = Value("Public")
  final val Static = Value("Static")
  final val Strict = Value("Strict")
  final val Super = Value("Super")
  final val Synchronized = Value("Synchronized")
  final val Synthetic = Value("Synthetic")
  final val Transient = Value("Transient")
  final val VarArgs = Value("VarArgs")
  final val Volatile = Value("Volatile")
}

sealed trait ClassTypeAnnotation extends JavaMeta {
  def typePathOpt: Option[TypePath]

  def annotation: EntityAnnotation
}

final case class ClassTypeParameterAnnotation(typePathOpt: Option[TypePath],
                                              annotation: EntityAnnotation) extends ClassTypeAnnotation

final case class ClassTypeParameterBoundAnnotation(typePathOpt: Option[TypePath],
                                                   annotation: EntityAnnotation) extends ClassTypeAnnotation

final case class ClassExtendsAnnotation(typePathOpt: Option[TypePath],
                                        annotation: EntityAnnotation) extends ClassTypeAnnotation

final case class Attribute(tipe: String,
                           value: Array[Byte]) extends JavaMeta

sealed trait ArgValue extends JavaMeta

final case class Annotation(tipe: String, args: JavaMeta.Seq[Arg]) extends ArgValue

final case class Arg(name: String, value: ArgValue) extends JavaMeta

sealed trait InitValue extends ArgValue

case object TrueValue extends ArgValue

case object FalseValue extends ArgValue

final case class ByteValue(value: Byte) extends ArgValue

final case class CharValue(value: Char) extends ArgValue

final case class ShortValue(value: Short) extends ArgValue

final case class IntValue(value: Int) extends InitValue

final case class LongValue(value: Long) extends InitValue

final case class FloatValue(value: Float) extends InitValue

final case class DoubleValue(value: Double) extends InitValue

final case class StringValue(value: String) extends InitValue

final case class EnumValue(tipe: String,
                           value: String) extends ArgValue

final case class ArrayValue(elements: JavaMeta.Seq[ArgValue]) extends ArgValue

sealed trait Type extends JavaMeta

case object VoidType extends Type

case object BooleanType extends Type

case object ByteType extends Type

case object CharType extends Type

case object ShortType extends Type

case object IntType extends Type

case object LongType extends Type

case object FloatType extends Type

case object DoubleType extends Type

object ObjectType {
  def apply(name: String): ObjectType = _ObjectType(name.intern())

  def unapply(o: ObjectType) = Some(o.name)
}

sealed trait ObjectType extends Type {
  def name: String
}

@InternString
private final case class _ObjectType(name: String) extends ObjectType {
  override def toString = s"ObjectType($name)"
}

final case class ArrayType(element: Type) extends Type

final case class TypePath(steps: Seq[Step]) extends JavaMeta

sealed trait Step extends JavaMeta

case object ArrayElement extends Step

case object InnerType extends Step

case class TypeArgument(index: Natural) extends Step

case object WildcardBound extends Step
