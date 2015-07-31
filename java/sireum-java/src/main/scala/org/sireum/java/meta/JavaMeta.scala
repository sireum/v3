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

import org.sireum.java.JavaProfile
import org.sireum.pilar.ast.Node
import org.sireum.util._
import org.sireum.util.Json.InternString

object JavaMeta {
  type Seq[T] = IVector[T]

  private var initialized = false

  val pickle: Any --\ String = {
    case o: JavaMeta =>
      upickle.json.write(JavaMetaJson.fromJavaMeta(o))
  }

  val unpickle = new PartialFunction[String, Any] {
    override def isDefinedAt(o: String): Boolean = true

    override def apply(o: String): Any =
      JavaMetaJson.toJavaMeta(upickle.json.read(o))
  }

  @inline
  def init(): Unit = {
    if (!initialized) {
      initialized = true
      val pickler = (pickle, unpickle)
      Node.extern(JavaProfile.annotationClassDesc, pickler)
      Node.extern(JavaProfile.annotationTypeDesc, pickler)
      Node.extern(JavaProfile.typeDesc, pickler)
      Node.extern(JavaProfile.handleDesc, pickler)
      Node.extern(JavaProfile.byteDesc, ( {
        case o: Byte => o.toString
      }, {
        case s => s.toByte
      }))
      Node.extern(JavaProfile.charDesc, ( {
        case o: Char => o.toString
      }, {
        case s => s.head
      }))
      Node.extern(JavaProfile.shortDesc, ( {
        case o: Short => o.toString
      }, {
        case s => s.toShort
      }))
      Node.extern(JavaProfile.intDesc, ( {
        case o: Int => o.toString
      }, {
        case s => s.toInt
      }))
      Node.extern(JavaProfile.longDesc, ( {
        case o: Long => o.toString
      }, {
        case s => s.toLong
      }))
      Node.extern(JavaProfile.floatDesc, ( {
        case o: Float => o.toString
      }, {
        case s => s.toFloat
      }))
      Node.extern(JavaProfile.doubleDesc, ( {
        case o: Char => o.toString
      }, {
        case s => s.toDouble
      }))
      Node.extern(JavaProfile.stringDesc, ( {
        case o: String => o
      }, {
        case s => s
      }))
    }
  }
}

import JavaMeta._

sealed trait JavaMeta extends Product {
  JavaMeta.init()
}

final case class Class(version: Int,
                       modifiers: Seq[ClassModifier.Type],
                       name: String,
                       signatureOpt: Option[String],
                       superNameOpt: Option[String],
                       interfaces: Seq[String],
                       sourceOpt: Option[String],
                       debugOpt: Option[String],
                       outerClassOpt: Option[OuterClass],
                       annotations: Seq[EntityAnnotation],
                       typeAnnotation: Seq[ClassTypeAnnotation],
                       attributes: Seq[Attribute],
                       innerClasses: Seq[InnerClass],
                       fields: Seq[Field],
                       methods: Seq[Method]) extends JavaMeta

final case class EntityAnnotation(annotation: Annotation,
                                  visible: Boolean) extends JavaMeta

final case class OuterClass(name: String,
                            methodNameDescOpt: Option[(String, String)]) extends JavaMeta

final case class InnerClass(name: String,
                            outerNameOpt: Option[String],
                            innerNameOpt: Option[String],
                            modifiers: Seq[ClassModifier.Type]) extends JavaMeta

object ClassModifier extends Enum("") {
  type Type = Value
  final val Public = Value("Public")
  final val Private = Value("Private")
  final val Protected = Value("Protected")
  final val Final = Value("Final")
  final val Super = Value("Super")
  final val Interface = Value("Interface")
  final val Abstract = Value("Abstract")
  final val Synthetic = Value("Synthetic")
  final val Annotation = Value("Annotation")
  final val Enum = Value("Enum")
  final val Deprecated = Value("Deprecated")
}

object MethodModifier extends Enum("") {
  type Type = Value
  final val Public = Value("Public")
  final val Private = Value("Private")
  final val Protected = Value("Protected")
  final val Static = Value("Static")
  final val Final = Value("Final")
  final val Synchronized = Value("Synchronized")
  final val Bridge = Value("Bridge")
  final val VarArgs = Value("VarArgs")
  final val Native = Value("Native")
  final val Abstract = Value("Abstract")
  final val Strict = Value("Strict")
  final val Synthetic = Value("Synthetic")
  final val Deprecated = Value("Deprecated")
}

object FieldModifier extends Enum("") {
  type Type = Value
  final val Public = Value("Public")
  final val Private = Value("Private")
  final val Protected = Value("Protected")
  final val Static = Value("Static")
  final val Final = Value("Final")
  final val Volatile = Value("Volatile")
  final val Transient = Value("Transient")
  final val Synthetic = Value("Synthetic")
  final val Enum = Value("Enum")
  final val Deprecated = Value("Deprecated")
}

object ParameterModifier extends Enum("") {
  type Type = Value
  final val Final = Value("Final")
  final val Synthetic = Value("Synthetic")
  final val Mandated = Value("Mandated")
}

sealed trait TypeAnnotation extends JavaMeta {
  def typePathOpt: Option[TypePath]

  def annotation: EntityAnnotation
}

sealed trait ClassTypeAnnotation extends TypeAnnotation

final case class ClassTypeParameterTypeAnnotation(typePathOpt: Option[TypePath],
                                                  annotation: EntityAnnotation) extends ClassTypeAnnotation

final case class ClassTypeParameterBoundTypeAnnotation(typePathOpt: Option[TypePath],
                                                       annotation: EntityAnnotation) extends ClassTypeAnnotation

final case class ClassExtendsTypeAnnotation(typePathOpt: Option[TypePath],
                                            annotation: EntityAnnotation) extends ClassTypeAnnotation

final case class Attribute(tipe: String,
                           value: Array[Byte]) extends JavaMeta

final case class Field(modifiers: Seq[FieldModifier.Type],
                       name: String,
                       tipe: Type,
                       signatureOpt: Option[String],
                       value: Option[InitValue],
                       annotations: Seq[EntityAnnotation],
                       typeAnnotations: Seq[FieldTypeAnnotation],
                       attributes: Seq[Attribute]) extends JavaMeta

final case class FieldTypeAnnotation(typePathOpt: Option[TypePath],
                                     annotation: EntityAnnotation) extends TypeAnnotation

final case class Method(modifiers: Seq[MethodModifier.Type],
                        name: String,
                        tipe: MethodType,
                        signatureOpt: Option[String],
                        exceptions: Seq[String],
                        parameters: Seq[Parameter],
                        annotationDefaultOpt: Option[Annotation],
                        annotations: Seq[EntityAnnotation],
                        typeAnnotations: Seq[MethodTypeAnnotation],
                        attributes: Seq[Attribute],
                        localVars: Seq[LocalVar]) extends JavaMeta

final case class Parameter(modifiers: Seq[ParameterModifier.Type],
                           nameOpt: Option[String],
                           annotations: Seq[EntityAnnotation]) extends JavaMeta

sealed trait MethodTypeAnnotation extends TypeAnnotation

final case class MethodTypeParameterTypeAnnotation(typePathOpt: Option[TypePath],
                                                   annotation: EntityAnnotation) extends MethodTypeAnnotation

final case class MethodTypeParameterBoundTypeAnnotation(typePathOpt: Option[TypePath],
                                                        annotation: EntityAnnotation) extends MethodTypeAnnotation

final case class MethodReturnTypeAnnotation(typePathOpt: Option[TypePath],
                                            annotation: EntityAnnotation) extends MethodTypeAnnotation

final case class MethodReceiverTypeAnnotation(typePathOpt: Option[TypePath],
                                              annotation: EntityAnnotation) extends MethodTypeAnnotation

final case class MethodFormalParameterTypeAnnotation(typePathOpt: Option[TypePath],
                                                     annotation: EntityAnnotation) extends MethodTypeAnnotation

final case class ThrowsTypeAnnotation(typePathOpt: Option[TypePath],
                                      annotation: EntityAnnotation) extends MethodTypeAnnotation

final case class LocalVar(name: String,
                          tipe: Type,
                          signatureOpt: Option[String],
                          labelStart: String,
                          labelEnd: String,
                          annotations: Seq[EntityAnnotation]) extends JavaMeta

sealed trait Handle extends JavaMeta {
  def className: String

  def name: String

  def desc: String

  def tipe: Type
}

sealed trait FieldHandle extends Handle {
  val fieldName = name
}

sealed trait MethodHandle extends Handle {
  val methodName = name
}

final case class GetFieldHandle(className: String,
                                name: String,
                                desc: String,
                                tipe: Type) extends FieldHandle

final case class GetStaticFieldHandle(className: String,
                                      name: String,
                                      desc: String,
                                      tipe: Type) extends FieldHandle

final case class PutFieldHandle(className: String,
                                name: String,
                                desc: String,
                                tipe: Type) extends FieldHandle

final case class PutStaticFieldHandle(className: String,
                                      name: String,
                                      desc: String,
                                      tipe: Type) extends FieldHandle

final case class InvokeVirtualHandle(className: String,
                                     name: String,
                                     desc: String,
                                     tipe: MethodType) extends MethodHandle

final case class InvokeStaticHandle(className: String,
                                    name: String,
                                    desc: String,
                                    tipe: MethodType) extends MethodHandle

final case class InvokeSpecialHandle(className: String,
                                     name: String,
                                     desc: String,
                                     tipe: MethodType) extends MethodHandle

final case class NewInvokeSpecialHandle(className: String,
                                        name: String,
                                        desc: String,
                                        tipe: MethodType) extends MethodHandle

final case class InvokeInterfaceHandle(className: String,
                                       name: String,
                                       desc: String,
                                       override val tipe: MethodType) extends MethodHandle

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

final case class TypeValue(tipe: Type) extends ArgValue

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

final case class MethodType(desc: String,
                            parameterTypes: Seq[Type],
                            returnType: Type) extends Type

final case class TypePath(steps: Seq[Step]) extends JavaMeta

sealed trait Step extends JavaMeta

case object ArrayElement extends Step

case object InnerType extends Step

case class TypeArgument(index: Natural) extends Step

case object WildcardBound extends Step
