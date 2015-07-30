/*
Copyright (c) 2011-2015, Robby, Kansas State University
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

// @formatter:off
// This file was auto-generated from org.sireum.java.meta.JavaMeta

package org.sireum.java.meta

import upickle.Js
import org.sireum.util.Json._

object JavaMetaJson {
  import scala.language.implicitConversions

  implicit def fromJavaMeta(o: org.sireum.java.meta.JavaMeta): Js.Obj =
    o match {
      case o: org.sireum.java.meta.Annotation =>
        Js.Obj(
          (".class", Js.Str("Annotation")),
          ("tipe", fromStr(o.tipe)),
          ("args", fromSeq(o.args)(fromJavaMeta))
        )
      case o: org.sireum.java.meta.Arg =>
        Js.Obj(
          (".class", Js.Str("Arg")),
          ("name", fromStr(o.name)),
          ("value", fromJavaMeta(o.value))
        )
      case org.sireum.java.meta.ArrayElement =>
        Js.Obj((".class", Js.Str("ArrayElement")))
      case o: org.sireum.java.meta.ArrayType =>
        Js.Obj(
          (".class", Js.Str("ArrayType")),
          ("element", fromJavaMeta(o.element))
        )
      case o: org.sireum.java.meta.ArrayValue =>
        Js.Obj(
          (".class", Js.Str("ArrayValue")),
          ("elements", fromSeq(o.elements)(fromJavaMeta))
        )
      case o: org.sireum.java.meta.Attribute =>
        Js.Obj(
          (".class", Js.Str("Attribute")),
          ("tipe", fromStr(o.tipe)),
          ("value", fromByteArray(o.value))
        )
      case org.sireum.java.meta.BooleanType =>
        Js.Obj((".class", Js.Str("BooleanType")))
      case org.sireum.java.meta.ByteType =>
        Js.Obj((".class", Js.Str("ByteType")))
      case o: org.sireum.java.meta.ByteValue =>
        Js.Obj(
          (".class", Js.Str("ByteValue")),
          ("value", fromAnyVal(o.value))
        )
      case org.sireum.java.meta.CharType =>
        Js.Obj((".class", Js.Str("CharType")))
      case o: org.sireum.java.meta.CharValue =>
        Js.Obj(
          (".class", Js.Str("CharValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.Class =>
        Js.Obj(
          (".class", Js.Str("Class")),
          ("version", fromAnyVal(o.version)),
          ("modifiers", fromSeq(o.modifiers)(fromStr)),
          ("name", fromStr(o.name)),
          ("signatureOpt", fromOption(o.signatureOpt)(fromStr)),
          ("superNameOpt", fromOption(o.superNameOpt)(fromStr)),
          ("interfaces", fromSeq(o.interfaces)(fromStr)),
          ("sourceOpt", fromOption(o.sourceOpt)(fromStr)),
          ("debugOpt", fromOption(o.debugOpt)(fromStr)),
          ("outerClassOpt", fromOption(o.outerClassOpt)(fromJavaMeta)),
          ("annotations", fromSeq(o.annotations)(fromJavaMeta)),
          ("typeAnnotation", fromSeq(o.typeAnnotation)(fromJavaMeta)),
          ("attributes", fromSeq(o.attributes)(fromJavaMeta)),
          ("innerClasses", fromSeq(o.innerClasses)(fromJavaMeta)),
          ("fields", fromSeq(o.fields)(fromJavaMeta))
        )
      case o: org.sireum.java.meta.ClassExtendsTypeAnnotation =>
        Js.Obj(
          (".class", Js.Str("ClassExtendsTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.ClassTypeParameterBoundTypeAnnotation =>
        Js.Obj(
          (".class", Js.Str("ClassTypeParameterBoundTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.ClassTypeParameterTypeAnnotation =>
        Js.Obj(
          (".class", Js.Str("ClassTypeParameterTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case org.sireum.java.meta.DoubleType =>
        Js.Obj((".class", Js.Str("DoubleType")))
      case o: org.sireum.java.meta.DoubleValue =>
        Js.Obj(
          (".class", Js.Str("DoubleValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.EntityAnnotation =>
        Js.Obj(
          (".class", Js.Str("EntityAnnotation")),
          ("annotation", fromJavaMeta(o.annotation)),
          ("visible", fromAnyVal(o.visible))
        )
      case o: org.sireum.java.meta.EnumValue =>
        Js.Obj(
          (".class", Js.Str("EnumValue")),
          ("tipe", fromStr(o.tipe)),
          ("value", fromStr(o.value))
        )
      case org.sireum.java.meta.FalseValue =>
        Js.Obj((".class", Js.Str("FalseValue")))
      case o: org.sireum.java.meta.Field =>
        Js.Obj(
          (".class", Js.Str("Field")),
          ("modifiers", fromSeq(o.modifiers)(fromStr)),
          ("name", fromStr(o.name)),
          ("tipe", fromJavaMeta(o.tipe)),
          ("signatureOpt", fromOption(o.signatureOpt)(fromStr)),
          ("value", fromOption(o.value)(fromJavaMeta)),
          ("annotations", fromSeq(o.annotations)(fromJavaMeta)),
          ("typeAnnotations", fromSeq(o.typeAnnotations)(fromJavaMeta)),
          ("attributes", fromSeq(o.attributes)(fromJavaMeta))
        )
      case o: org.sireum.java.meta.FieldTypeAnnotation =>
        Js.Obj(
          (".class", Js.Str("FieldTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case org.sireum.java.meta.FloatType =>
        Js.Obj((".class", Js.Str("FloatType")))
      case o: org.sireum.java.meta.FloatValue =>
        Js.Obj(
          (".class", Js.Str("FloatValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.InnerClass =>
        Js.Obj(
          (".class", Js.Str("InnerClass")),
          ("name", fromStr(o.name)),
          ("outerNameOpt", fromOption(o.outerNameOpt)(fromStr)),
          ("innerNameOpt", fromOption(o.innerNameOpt)(fromStr)),
          ("modifiers", fromSeq(o.modifiers)(fromStr))
        )
      case org.sireum.java.meta.InnerType =>
        Js.Obj((".class", Js.Str("InnerType")))
      case org.sireum.java.meta.IntType =>
        Js.Obj((".class", Js.Str("IntType")))
      case o: org.sireum.java.meta.IntValue =>
        Js.Obj(
          (".class", Js.Str("IntValue")),
          ("value", fromAnyVal(o.value))
        )
      case org.sireum.java.meta.LongType =>
        Js.Obj((".class", Js.Str("LongType")))
      case o: org.sireum.java.meta.LongValue =>
        Js.Obj(
          (".class", Js.Str("LongValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.MethodFormalParameterTypeAnnotation =>
        Js.Obj(
          (".class", Js.Str("MethodFormalParameterTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.MethodReceiverTypeAnnotation =>
        Js.Obj(
          (".class", Js.Str("MethodReceiverTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.MethodReturnTypeAnnotation =>
        Js.Obj(
          (".class", Js.Str("MethodReturnTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.MethodTypeParameterBoundTypeAnnotation =>
        Js.Obj(
          (".class", Js.Str("MethodTypeParameterBoundTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.MethodTypeParameterTypeAnnotation =>
        Js.Obj(
          (".class", Js.Str("MethodTypeParameterTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.OuterClass =>
        Js.Obj(
          (".class", Js.Str("OuterClass")),
          ("name", fromStr(o.name)),
          ("methodNameDescOpt", fromOption(o.methodNameDescOpt)(fromTuple2))
        )
      case org.sireum.java.meta.ShortType =>
        Js.Obj((".class", Js.Str("ShortType")))
      case o: org.sireum.java.meta.ShortValue =>
        Js.Obj(
          (".class", Js.Str("ShortValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.StringValue =>
        Js.Obj(
          (".class", Js.Str("StringValue")),
          ("value", fromStr(o.value))
        )
      case o: org.sireum.java.meta.ThrowsTypeAnnotation =>
        Js.Obj(
          (".class", Js.Str("ThrowsTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case org.sireum.java.meta.TrueValue =>
        Js.Obj((".class", Js.Str("TrueValue")))
      case o: org.sireum.java.meta.TypeArgument =>
        Js.Obj(
          (".class", Js.Str("TypeArgument")),
          ("index", fromAnyVal(o.index))
        )
      case o: org.sireum.java.meta.TypePath =>
        Js.Obj(
          (".class", Js.Str("TypePath")),
          ("steps", fromSeq(o.steps)(fromJavaMeta))
        )
      case org.sireum.java.meta.VoidType =>
        Js.Obj((".class", Js.Str("VoidType")))
      case org.sireum.java.meta.WildcardBound =>
        Js.Obj((".class", Js.Str("WildcardBound")))
      case o: org.sireum.java.meta._ObjectType =>
        Js.Obj(
          (".class", Js.Str("_ObjectType")),
          ("name", fromStr(o.name))
        )
    }

  implicit def toJavaMeta[T <: org.sireum.java.meta.JavaMeta](v: Js.Value): T =
    (v: @unchecked) match {
      case o: Js.Obj =>
        (o.value.head._2.asInstanceOf[Js.Str].value match {
           case "Annotation" =>
             org.sireum.java.meta.Annotation(toStr(o.value(1)._2), toVector(o.value(2)._2)(toJavaMeta[Arg]))
           case "Arg" =>
             org.sireum.java.meta.Arg(toStr(o.value(1)._2), toJavaMeta[ArgValue](o.value(2)._2))
           case "ArrayElement" => org.sireum.java.meta.ArrayElement
           case "ArrayType" =>
             org.sireum.java.meta.ArrayType(toJavaMeta[Type](o.value(1)._2))
           case "ArrayValue" =>
             org.sireum.java.meta.ArrayValue(toVector(o.value(1)._2)(toJavaMeta[ArgValue]))
           case "Attribute" =>
             org.sireum.java.meta.Attribute(toStr(o.value(1)._2), toByteArray(o.value(2)._2))
           case "BooleanType" => org.sireum.java.meta.BooleanType
           case "ByteType" => org.sireum.java.meta.ByteType
           case "ByteValue" =>
             org.sireum.java.meta.ByteValue(toByte(o.value(1)._2))
           case "CharType" => org.sireum.java.meta.CharType
           case "CharValue" =>
             org.sireum.java.meta.CharValue(toChar(o.value(1)._2))
           case "Class" =>
             org.sireum.java.meta.Class(toInt(o.value(1)._2), toVector(o.value(2)._2)(toStr), toStr(o.value(3)._2), toOption(o.value(4)._2)(toStr), toOption(o.value(5)._2)(toStr), toVector(o.value(6)._2)(toStr), toOption(o.value(7)._2)(toStr), toOption(o.value(8)._2)(toStr), toOption(o.value(9)._2)(toJavaMeta[OuterClass]), toVector(o.value(10)._2)(toJavaMeta[EntityAnnotation]), toVector(o.value(11)._2)(toJavaMeta[ClassTypeAnnotation]), toVector(o.value(12)._2)(toJavaMeta[Attribute]), toVector(o.value(13)._2)(toJavaMeta[InnerClass]), toVector(o.value(14)._2)(toJavaMeta[Field]))
           case "ClassExtendsTypeAnnotation" =>
             org.sireum.java.meta.ClassExtendsTypeAnnotation(toOption(o.value(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value(2)._2))
           case "ClassTypeParameterBoundTypeAnnotation" =>
             org.sireum.java.meta.ClassTypeParameterBoundTypeAnnotation(toOption(o.value(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value(2)._2))
           case "ClassTypeParameterTypeAnnotation" =>
             org.sireum.java.meta.ClassTypeParameterTypeAnnotation(toOption(o.value(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value(2)._2))
           case "DoubleType" => org.sireum.java.meta.DoubleType
           case "DoubleValue" =>
             org.sireum.java.meta.DoubleValue(toDouble(o.value(1)._2))
           case "EntityAnnotation" =>
             org.sireum.java.meta.EntityAnnotation(toJavaMeta[Annotation](o.value(1)._2), toBoolean(o.value(2)._2))
           case "EnumValue" =>
             org.sireum.java.meta.EnumValue(toStr(o.value(1)._2), toStr(o.value(2)._2))
           case "FalseValue" => org.sireum.java.meta.FalseValue
           case "Field" =>
             org.sireum.java.meta.Field(toVector(o.value(1)._2)(toStr), toStr(o.value(2)._2), toJavaMeta[Type](o.value(3)._2), toOption(o.value(4)._2)(toStr), toOption(o.value(5)._2)(toJavaMeta[InitValue]), toVector(o.value(6)._2)(toJavaMeta[EntityAnnotation]), toVector(o.value(7)._2)(toJavaMeta[FieldTypeAnnotation]), toVector(o.value(8)._2)(toJavaMeta[Attribute]))
           case "FieldTypeAnnotation" =>
             org.sireum.java.meta.FieldTypeAnnotation(toOption(o.value(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value(2)._2))
           case "FloatType" => org.sireum.java.meta.FloatType
           case "FloatValue" =>
             org.sireum.java.meta.FloatValue(toFloat(o.value(1)._2))
           case "InnerClass" =>
             org.sireum.java.meta.InnerClass(toStr(o.value(1)._2), toOption(o.value(2)._2)(toStr), toOption(o.value(3)._2)(toStr), toVector(o.value(4)._2)(toStr))
           case "InnerType" => org.sireum.java.meta.InnerType
           case "IntType" => org.sireum.java.meta.IntType
           case "IntValue" =>
             org.sireum.java.meta.IntValue(toInt(o.value(1)._2))
           case "LongType" => org.sireum.java.meta.LongType
           case "LongValue" =>
             org.sireum.java.meta.LongValue(toLong(o.value(1)._2))
           case "MethodFormalParameterTypeAnnotation" =>
             org.sireum.java.meta.MethodFormalParameterTypeAnnotation(toOption(o.value(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value(2)._2))
           case "MethodReceiverTypeAnnotation" =>
             org.sireum.java.meta.MethodReceiverTypeAnnotation(toOption(o.value(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value(2)._2))
           case "MethodReturnTypeAnnotation" =>
             org.sireum.java.meta.MethodReturnTypeAnnotation(toOption(o.value(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value(2)._2))
           case "MethodTypeParameterBoundTypeAnnotation" =>
             org.sireum.java.meta.MethodTypeParameterBoundTypeAnnotation(toOption(o.value(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value(2)._2))
           case "MethodTypeParameterTypeAnnotation" =>
             org.sireum.java.meta.MethodTypeParameterTypeAnnotation(toOption(o.value(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value(2)._2))
           case "OuterClass" =>
             org.sireum.java.meta.OuterClass(toStr(o.value(1)._2), toOption(o.value(2)._2)(toTuple2))
           case "ShortType" => org.sireum.java.meta.ShortType
           case "ShortValue" =>
             org.sireum.java.meta.ShortValue(toShort(o.value(1)._2))
           case "StringValue" =>
             org.sireum.java.meta.StringValue(toStr(o.value(1)._2))
           case "ThrowsTypeAnnotation" =>
             org.sireum.java.meta.ThrowsTypeAnnotation(toOption(o.value(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value(2)._2))
           case "TrueValue" => org.sireum.java.meta.TrueValue
           case "TypeArgument" =>
             org.sireum.java.meta.TypeArgument(toInt(o.value(1)._2))
           case "TypePath" =>
             org.sireum.java.meta.TypePath(toVector(o.value(1)._2)(toJavaMeta[Step]))
           case "VoidType" => org.sireum.java.meta.VoidType
           case "WildcardBound" => org.sireum.java.meta.WildcardBound
           case "_ObjectType" =>
             org.sireum.java.meta._ObjectType(toStrIntern(o.value(1)._2))
         }).asInstanceOf[T]
    }
}