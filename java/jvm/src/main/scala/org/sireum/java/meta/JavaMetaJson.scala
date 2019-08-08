/*
Copyright (c) 2019, Robby, Kansas State University
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

import org.sireum.util.Json._

object JavaMetaJson {
  import scala.language.implicitConversions

  implicit def fromJavaMeta(o: org.sireum.java.meta.JavaMeta): ujson.Obj =
    o match {
      case o: org.sireum.java.meta.Annotation =>
        ujson.Obj(
          (".class", ujson.Str("Annotation")),
          ("tipe", fromStr(o.tipe)),
          ("args", fromSeq(o.args)(fromJavaMeta))
        )
      case o: org.sireum.java.meta.Arg =>
        ujson.Obj(
          (".class", ujson.Str("Arg")),
          ("name", fromStr(o.name)),
          ("value", fromJavaMeta(o.value))
        )
      case org.sireum.java.meta.ArrayElement =>
        ujson.Obj((".class", ujson.Str("ArrayElement")))
      case o: org.sireum.java.meta.ArrayType =>
        ujson.Obj(
          (".class", ujson.Str("ArrayType")),
          ("element", fromJavaMeta(o.element))
        )
      case o: org.sireum.java.meta.ArrayValue =>
        ujson.Obj(
          (".class", ujson.Str("ArrayValue")),
          ("elements", fromSeq(o.elements)(fromJavaMeta))
        )
      case o: org.sireum.java.meta.Attribute =>
        ujson.Obj(
          (".class", ujson.Str("Attribute")),
          ("tipe", fromStr(o.tipe)),
          ("value", fromByteArray(o.value))
        )
      case org.sireum.java.meta.BooleanType =>
        ujson.Obj((".class", ujson.Str("BooleanType")))
      case org.sireum.java.meta.ByteType =>
        ujson.Obj((".class", ujson.Str("ByteType")))
      case o: org.sireum.java.meta.ByteValue =>
        ujson.Obj(
          (".class", ujson.Str("ByteValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.CastTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("CastTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.Catch =>
        ujson.Obj(
          (".class", ujson.Str("Catch")),
          ("labelStart", fromStr(o.labelStart)),
          ("labelEnd", fromStr(o.labelEnd)),
          ("labelHandler", fromStr(o.labelHandler)),
          ("tipeOpt", fromOption(o.tipeOpt)(fromStr)),
          ("annotations", fromSeq(o.annotations)(fromJavaMeta))
        )
      case org.sireum.java.meta.CharType =>
        ujson.Obj((".class", ujson.Str("CharType")))
      case o: org.sireum.java.meta.CharValue =>
        ujson.Obj(
          (".class", ujson.Str("CharValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.Class =>
        ujson.Obj(
          (".class", ujson.Str("Class")),
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
          ("fields", fromSeq(o.fields)(fromJavaMeta)),
          ("methods", fromSeq(o.methods)(fromJavaMeta))
        )
      case o: org.sireum.java.meta.ClassExtendsTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("ClassExtendsTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.ClassTypeParameterBoundTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("ClassTypeParameterBoundTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.ClassTypeParameterTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("ClassTypeParameterTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.ConstructorInvocationTypeArgumentTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("ConstructorInvocationTypeArgumentTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.ConstructorReferenceTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("ConstructorReferenceTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.ConstructorReferenceTypeArgumentTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("ConstructorReferenceTypeArgumentTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case org.sireum.java.meta.DoubleType =>
        ujson.Obj((".class", ujson.Str("DoubleType")))
      case o: org.sireum.java.meta.DoubleValue =>
        ujson.Obj(
          (".class", ujson.Str("DoubleValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.EntityAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("EntityAnnotation")),
          ("annotation", fromJavaMeta(o.annotation)),
          ("visible", fromAnyVal(o.visible))
        )
      case o: org.sireum.java.meta.EnumValue =>
        ujson.Obj(
          (".class", ujson.Str("EnumValue")),
          ("tipe", fromStr(o.tipe)),
          ("value", fromStr(o.value))
        )
      case o: org.sireum.java.meta.ExceptionParameterTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("ExceptionParameterTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case org.sireum.java.meta.FalseValue =>
        ujson.Obj((".class", ujson.Str("FalseValue")))
      case o: org.sireum.java.meta.Field =>
        ujson.Obj(
          (".class", ujson.Str("Field")),
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
        ujson.Obj(
          (".class", ujson.Str("FieldTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case org.sireum.java.meta.FloatType =>
        ujson.Obj((".class", ujson.Str("FloatType")))
      case o: org.sireum.java.meta.FloatValue =>
        ujson.Obj(
          (".class", ujson.Str("FloatValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.GetFieldHandle =>
        ujson.Obj(
          (".class", ujson.Str("GetFieldHandle")),
          ("className", fromStr(o.className)),
          ("name", fromStr(o.name)),
          ("desc", fromStr(o.desc)),
          ("tipe", fromJavaMeta(o.tipe))
        )
      case o: org.sireum.java.meta.GetStaticFieldHandle =>
        ujson.Obj(
          (".class", ujson.Str("GetStaticFieldHandle")),
          ("className", fromStr(o.className)),
          ("name", fromStr(o.name)),
          ("desc", fromStr(o.desc)),
          ("tipe", fromJavaMeta(o.tipe))
        )
      case o: org.sireum.java.meta.InnerClass =>
        ujson.Obj(
          (".class", ujson.Str("InnerClass")),
          ("name", fromStr(o.name)),
          ("outerNameOpt", fromOption(o.outerNameOpt)(fromStr)),
          ("innerNameOpt", fromOption(o.innerNameOpt)(fromStr)),
          ("modifiers", fromSeq(o.modifiers)(fromStr))
        )
      case org.sireum.java.meta.InnerType =>
        ujson.Obj((".class", ujson.Str("InnerType")))
      case o: org.sireum.java.meta.InstanceOfTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("InstanceOfTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case org.sireum.java.meta.IntType =>
        ujson.Obj((".class", ujson.Str("IntType")))
      case o: org.sireum.java.meta.IntValue =>
        ujson.Obj(
          (".class", ujson.Str("IntValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.InvokeInterfaceHandle =>
        ujson.Obj(
          (".class", ujson.Str("InvokeInterfaceHandle")),
          ("className", fromStr(o.className)),
          ("name", fromStr(o.name)),
          ("desc", fromStr(o.desc)),
          ("tipe", fromJavaMeta(o.tipe))
        )
      case o: org.sireum.java.meta.InvokeSpecialHandle =>
        ujson.Obj(
          (".class", ujson.Str("InvokeSpecialHandle")),
          ("className", fromStr(o.className)),
          ("name", fromStr(o.name)),
          ("desc", fromStr(o.desc)),
          ("tipe", fromJavaMeta(o.tipe))
        )
      case o: org.sireum.java.meta.InvokeStaticHandle =>
        ujson.Obj(
          (".class", ujson.Str("InvokeStaticHandle")),
          ("className", fromStr(o.className)),
          ("name", fromStr(o.name)),
          ("desc", fromStr(o.desc)),
          ("tipe", fromJavaMeta(o.tipe))
        )
      case o: org.sireum.java.meta.InvokeVirtualHandle =>
        ujson.Obj(
          (".class", ujson.Str("InvokeVirtualHandle")),
          ("className", fromStr(o.className)),
          ("name", fromStr(o.name)),
          ("desc", fromStr(o.desc)),
          ("tipe", fromJavaMeta(o.tipe))
        )
      case o: org.sireum.java.meta.LocalVar =>
        ujson.Obj(
          (".class", ujson.Str("LocalVar")),
          ("name", fromStr(o.name)),
          ("tipe", fromJavaMeta(o.tipe)),
          ("signatureOpt", fromOption(o.signatureOpt)(fromStr)),
          ("labelStart", fromStr(o.labelStart)),
          ("labelEnd", fromStr(o.labelEnd)),
          ("index", fromAnyVal(o.index))
        )
      case o: org.sireum.java.meta.LocalVarAnnotationElement =>
        ujson.Obj(
          (".class", ujson.Str("LocalVarAnnotationElement")),
          ("labelStart", fromStr(o.labelStart)),
          ("labelEnd", fromStr(o.labelEnd)),
          ("index", fromAnyVal(o.index))
        )
      case o: org.sireum.java.meta.LocalVariableTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("LocalVariableTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation)),
          ("elements", fromSeq(o.elements)(fromJavaMeta))
        )
      case org.sireum.java.meta.LongType =>
        ujson.Obj((".class", ujson.Str("LongType")))
      case o: org.sireum.java.meta.LongValue =>
        ujson.Obj(
          (".class", ujson.Str("LongValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.Method =>
        ujson.Obj(
          (".class", ujson.Str("Method")),
          ("modifiers", fromSeq(o.modifiers)(fromStr)),
          ("name", fromStr(o.name)),
          ("tipe", fromJavaMeta(o.tipe)),
          ("signatureOpt", fromOption(o.signatureOpt)(fromStr)),
          ("exceptions", fromSeq(o.exceptions)(fromStr)),
          ("parameters", fromSeq(o.parameters)(fromJavaMeta)),
          ("annotationDefaultOpt", fromOption(o.annotationDefaultOpt)(fromJavaMeta)),
          ("annotations", fromSeq(o.annotations)(fromJavaMeta)),
          ("typeAnnotations", fromSeq(o.typeAnnotations)(fromJavaMeta)),
          ("attributes", fromSeq(o.attributes)(fromJavaMeta)),
          ("localVars", fromSeq(o.localVars)(fromJavaMeta)),
          ("localVarTypeAnnotations", fromSeq(o.localVarTypeAnnotations)(fromJavaMeta))
        )
      case o: org.sireum.java.meta.MethodFormalParameterTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("MethodFormalParameterTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.MethodInvocationTypeArgumentTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("MethodInvocationTypeArgumentTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.MethodReceiverTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("MethodReceiverTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.MethodReferenceTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("MethodReferenceTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.MethodReferenceTypeArgumentTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("MethodReferenceTypeArgumentTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.MethodReturnTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("MethodReturnTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.MethodType =>
        ujson.Obj(
          (".class", ujson.Str("MethodType")),
          ("desc", fromStr(o.desc)),
          ("parameterTypes", fromSeq(o.parameterTypes)(fromJavaMeta)),
          ("returnType", fromJavaMeta(o.returnType))
        )
      case o: org.sireum.java.meta.MethodTypeParameterBoundTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("MethodTypeParameterBoundTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.MethodTypeParameterTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("MethodTypeParameterTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.NewInvokeSpecialHandle =>
        ujson.Obj(
          (".class", ujson.Str("NewInvokeSpecialHandle")),
          ("className", fromStr(o.className)),
          ("name", fromStr(o.name)),
          ("desc", fromStr(o.desc)),
          ("tipe", fromJavaMeta(o.tipe))
        )
      case o: org.sireum.java.meta.NewTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("NewTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case o: org.sireum.java.meta.OuterClass =>
        ujson.Obj(
          (".class", ujson.Str("OuterClass")),
          ("name", fromStr(o.name)),
          ("methodNameDescOpt", fromOption(o.methodNameDescOpt)(fromTuple2))
        )
      case o: org.sireum.java.meta.Parameter =>
        ujson.Obj(
          (".class", ujson.Str("Parameter")),
          ("modifiers", fromSeq(o.modifiers)(fromStr)),
          ("nameOpt", fromOption(o.nameOpt)(fromStr)),
          ("annotations", fromSeq(o.annotations)(fromJavaMeta))
        )
      case o: org.sireum.java.meta.PutFieldHandle =>
        ujson.Obj(
          (".class", ujson.Str("PutFieldHandle")),
          ("className", fromStr(o.className)),
          ("name", fromStr(o.name)),
          ("desc", fromStr(o.desc)),
          ("tipe", fromJavaMeta(o.tipe))
        )
      case o: org.sireum.java.meta.PutStaticFieldHandle =>
        ujson.Obj(
          (".class", ujson.Str("PutStaticFieldHandle")),
          ("className", fromStr(o.className)),
          ("name", fromStr(o.name)),
          ("desc", fromStr(o.desc)),
          ("tipe", fromJavaMeta(o.tipe))
        )
      case o: org.sireum.java.meta.ResourceVariableTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("ResourceVariableTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation)),
          ("elements", fromSeq(o.elements)(fromJavaMeta))
        )
      case org.sireum.java.meta.ShortType =>
        ujson.Obj((".class", ujson.Str("ShortType")))
      case o: org.sireum.java.meta.ShortValue =>
        ujson.Obj(
          (".class", ujson.Str("ShortValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.StringValue =>
        ujson.Obj(
          (".class", ujson.Str("StringValue")),
          ("value", fromStr(o.value))
        )
      case o: org.sireum.java.meta.ThrowsTypeAnnotation =>
        ujson.Obj(
          (".class", ujson.Str("ThrowsTypeAnnotation")),
          ("typePathOpt", fromOption(o.typePathOpt)(fromJavaMeta)),
          ("annotation", fromJavaMeta(o.annotation))
        )
      case org.sireum.java.meta.TrueValue =>
        ujson.Obj((".class", ujson.Str("TrueValue")))
      case o: org.sireum.java.meta.TypeArgument =>
        ujson.Obj(
          (".class", ujson.Str("TypeArgument")),
          ("index", fromAnyVal(o.index))
        )
      case o: org.sireum.java.meta.TypePath =>
        ujson.Obj(
          (".class", ujson.Str("TypePath")),
          ("steps", fromSeq(o.steps)(fromJavaMeta))
        )
      case o: org.sireum.java.meta.TypeValue =>
        ujson.Obj(
          (".class", ujson.Str("TypeValue")),
          ("tipe", fromJavaMeta(o.tipe))
        )
      case org.sireum.java.meta.VoidType =>
        ujson.Obj((".class", ujson.Str("VoidType")))
      case org.sireum.java.meta.WildcardBound =>
        ujson.Obj((".class", ujson.Str("WildcardBound")))
      case o: org.sireum.java.meta._ObjectType =>
        ujson.Obj(
          (".class", ujson.Str("_ObjectType")),
          ("name", fromStr(o.name))
        )
    }

  implicit def toJavaMeta[T <: org.sireum.java.meta.JavaMeta](v: ujson.Value): T =
    (v: @unchecked) match {
      case o: ujson.Obj =>
        (o.value.head._2.asInstanceOf[ujson.Str].value match {
           case "Annotation" =>
             org.sireum.java.meta.Annotation(toStr(o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toJavaMeta[Arg]))
           case "Arg" =>
             org.sireum.java.meta.Arg(toStr(o.value.toSeq(1)._2), toJavaMeta[ArgValue](o.value.toSeq(2)._2))
           case "ArrayElement" => org.sireum.java.meta.ArrayElement
           case "ArrayType" =>
             org.sireum.java.meta.ArrayType(toJavaMeta[Type](o.value.toSeq(1)._2))
           case "ArrayValue" =>
             org.sireum.java.meta.ArrayValue(toVector(o.value.toSeq(1)._2)(toJavaMeta[ArgValue]))
           case "Attribute" =>
             org.sireum.java.meta.Attribute(toStr(o.value.toSeq(1)._2), toByteArray(o.value.toSeq(2)._2))
           case "BooleanType" => org.sireum.java.meta.BooleanType
           case "ByteType" => org.sireum.java.meta.ByteType
           case "ByteValue" =>
             org.sireum.java.meta.ByteValue(toByte(o.value.toSeq(1)._2))
           case "CastTypeAnnotation" =>
             org.sireum.java.meta.CastTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "Catch" =>
             org.sireum.java.meta.Catch(toStr(o.value.toSeq(1)._2), toStr(o.value.toSeq(2)._2), toStr(o.value.toSeq(3)._2), toOption(o.value.toSeq(4)._2)(toStr), toVector(o.value.toSeq(5)._2)(toJavaMeta[ExceptionParameterTypeAnnotation]))
           case "CharType" => org.sireum.java.meta.CharType
           case "CharValue" =>
             org.sireum.java.meta.CharValue(toChar(o.value.toSeq(1)._2))
           case "Class" =>
             org.sireum.java.meta.Class(toInt(o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toStr), toStr(o.value.toSeq(3)._2), toOption(o.value.toSeq(4)._2)(toStr), toOption(o.value.toSeq(5)._2)(toStr), toVector(o.value.toSeq(6)._2)(toStr), toOption(o.value.toSeq(7)._2)(toStr), toOption(o.value.toSeq(8)._2)(toStr), toOption(o.value.toSeq(9)._2)(toJavaMeta[OuterClass]), toVector(o.value.toSeq(10)._2)(toJavaMeta[EntityAnnotation]), toVector(o.value.toSeq(11)._2)(toJavaMeta[ClassTypeAnnotation]), toVector(o.value.toSeq(12)._2)(toJavaMeta[Attribute]), toVector(o.value.toSeq(13)._2)(toJavaMeta[InnerClass]), toVector(o.value.toSeq(14)._2)(toJavaMeta[Field]), toVector(o.value.toSeq(15)._2)(toJavaMeta[Method]))
           case "ClassExtendsTypeAnnotation" =>
             org.sireum.java.meta.ClassExtendsTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "ClassTypeParameterBoundTypeAnnotation" =>
             org.sireum.java.meta.ClassTypeParameterBoundTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "ClassTypeParameterTypeAnnotation" =>
             org.sireum.java.meta.ClassTypeParameterTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "ConstructorInvocationTypeArgumentTypeAnnotation" =>
             org.sireum.java.meta.ConstructorInvocationTypeArgumentTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "ConstructorReferenceTypeAnnotation" =>
             org.sireum.java.meta.ConstructorReferenceTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "ConstructorReferenceTypeArgumentTypeAnnotation" =>
             org.sireum.java.meta.ConstructorReferenceTypeArgumentTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "DoubleType" => org.sireum.java.meta.DoubleType
           case "DoubleValue" =>
             org.sireum.java.meta.DoubleValue(toDouble(o.value.toSeq(1)._2))
           case "EntityAnnotation" =>
             org.sireum.java.meta.EntityAnnotation(toJavaMeta[Annotation](o.value.toSeq(1)._2), toBoolean(o.value.toSeq(2)._2))
           case "EnumValue" =>
             org.sireum.java.meta.EnumValue(toStr(o.value.toSeq(1)._2), toStr(o.value.toSeq(2)._2))
           case "ExceptionParameterTypeAnnotation" =>
             org.sireum.java.meta.ExceptionParameterTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "FalseValue" => org.sireum.java.meta.FalseValue
           case "Field" =>
             org.sireum.java.meta.Field(toVector(o.value.toSeq(1)._2)(toStr), toStr(o.value.toSeq(2)._2), toJavaMeta[Type](o.value.toSeq(3)._2), toOption(o.value.toSeq(4)._2)(toStr), toOption(o.value.toSeq(5)._2)(toJavaMeta[InitValue]), toVector(o.value.toSeq(6)._2)(toJavaMeta[EntityAnnotation]), toVector(o.value.toSeq(7)._2)(toJavaMeta[FieldTypeAnnotation]), toVector(o.value.toSeq(8)._2)(toJavaMeta[Attribute]))
           case "FieldTypeAnnotation" =>
             org.sireum.java.meta.FieldTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "FloatType" => org.sireum.java.meta.FloatType
           case "FloatValue" =>
             org.sireum.java.meta.FloatValue(toFloat(o.value.toSeq(1)._2))
           case "GetFieldHandle" =>
             org.sireum.java.meta.GetFieldHandle(toStr(o.value.toSeq(1)._2), toStr(o.value.toSeq(2)._2), toStr(o.value.toSeq(3)._2), toJavaMeta[Type](o.value.toSeq(4)._2))
           case "GetStaticFieldHandle" =>
             org.sireum.java.meta.GetStaticFieldHandle(toStr(o.value.toSeq(1)._2), toStr(o.value.toSeq(2)._2), toStr(o.value.toSeq(3)._2), toJavaMeta[Type](o.value.toSeq(4)._2))
           case "InnerClass" =>
             org.sireum.java.meta.InnerClass(toStr(o.value.toSeq(1)._2), toOption(o.value.toSeq(2)._2)(toStr), toOption(o.value.toSeq(3)._2)(toStr), toVector(o.value.toSeq(4)._2)(toStr))
           case "InnerType" => org.sireum.java.meta.InnerType
           case "InstanceOfTypeAnnotation" =>
             org.sireum.java.meta.InstanceOfTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "IntType" => org.sireum.java.meta.IntType
           case "IntValue" =>
             org.sireum.java.meta.IntValue(toInt(o.value.toSeq(1)._2))
           case "InvokeInterfaceHandle" =>
             org.sireum.java.meta.InvokeInterfaceHandle(toStr(o.value.toSeq(1)._2), toStr(o.value.toSeq(2)._2), toStr(o.value.toSeq(3)._2), toJavaMeta[MethodType](o.value.toSeq(4)._2))
           case "InvokeSpecialHandle" =>
             org.sireum.java.meta.InvokeSpecialHandle(toStr(o.value.toSeq(1)._2), toStr(o.value.toSeq(2)._2), toStr(o.value.toSeq(3)._2), toJavaMeta[MethodType](o.value.toSeq(4)._2))
           case "InvokeStaticHandle" =>
             org.sireum.java.meta.InvokeStaticHandle(toStr(o.value.toSeq(1)._2), toStr(o.value.toSeq(2)._2), toStr(o.value.toSeq(3)._2), toJavaMeta[MethodType](o.value.toSeq(4)._2))
           case "InvokeVirtualHandle" =>
             org.sireum.java.meta.InvokeVirtualHandle(toStr(o.value.toSeq(1)._2), toStr(o.value.toSeq(2)._2), toStr(o.value.toSeq(3)._2), toJavaMeta[MethodType](o.value.toSeq(4)._2))
           case "LocalVar" =>
             org.sireum.java.meta.LocalVar(toStr(o.value.toSeq(1)._2), toJavaMeta[Type](o.value.toSeq(2)._2), toOption(o.value.toSeq(3)._2)(toStr), toStr(o.value.toSeq(4)._2), toStr(o.value.toSeq(5)._2), toInt(o.value.toSeq(6)._2))
           case "LocalVarAnnotationElement" =>
             org.sireum.java.meta.LocalVarAnnotationElement(toStr(o.value.toSeq(1)._2), toStr(o.value.toSeq(2)._2), toInt(o.value.toSeq(3)._2))
           case "LocalVariableTypeAnnotation" =>
             org.sireum.java.meta.LocalVariableTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2), toVector(o.value.toSeq(3)._2)(toJavaMeta[LocalVarAnnotationElement]))
           case "LongType" => org.sireum.java.meta.LongType
           case "LongValue" =>
             org.sireum.java.meta.LongValue(toLong(o.value.toSeq(1)._2))
           case "Method" =>
             org.sireum.java.meta.Method(toVector(o.value.toSeq(1)._2)(toStr), toStr(o.value.toSeq(2)._2), toJavaMeta[MethodType](o.value.toSeq(3)._2), toOption(o.value.toSeq(4)._2)(toStr), toVector(o.value.toSeq(5)._2)(toStr), toVector(o.value.toSeq(6)._2)(toJavaMeta[Parameter]), toOption(o.value.toSeq(7)._2)(toJavaMeta[Annotation]), toVector(o.value.toSeq(8)._2)(toJavaMeta[EntityAnnotation]), toVector(o.value.toSeq(9)._2)(toJavaMeta[MethodTypeAnnotation]), toVector(o.value.toSeq(10)._2)(toJavaMeta[Attribute]), toVector(o.value.toSeq(11)._2)(toJavaMeta[LocalVar]), toVector(o.value.toSeq(12)._2)(toJavaMeta[LocalVarTypeAnnotation]))
           case "MethodFormalParameterTypeAnnotation" =>
             org.sireum.java.meta.MethodFormalParameterTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "MethodInvocationTypeArgumentTypeAnnotation" =>
             org.sireum.java.meta.MethodInvocationTypeArgumentTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "MethodReceiverTypeAnnotation" =>
             org.sireum.java.meta.MethodReceiverTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "MethodReferenceTypeAnnotation" =>
             org.sireum.java.meta.MethodReferenceTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "MethodReferenceTypeArgumentTypeAnnotation" =>
             org.sireum.java.meta.MethodReferenceTypeArgumentTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "MethodReturnTypeAnnotation" =>
             org.sireum.java.meta.MethodReturnTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "MethodType" =>
             org.sireum.java.meta.MethodType(toStr(o.value.toSeq(1)._2), toVector(o.value.toSeq(2)._2)(toJavaMeta[Type]), toJavaMeta[Type](o.value.toSeq(3)._2))
           case "MethodTypeParameterBoundTypeAnnotation" =>
             org.sireum.java.meta.MethodTypeParameterBoundTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "MethodTypeParameterTypeAnnotation" =>
             org.sireum.java.meta.MethodTypeParameterTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "NewInvokeSpecialHandle" =>
             org.sireum.java.meta.NewInvokeSpecialHandle(toStr(o.value.toSeq(1)._2), toStr(o.value.toSeq(2)._2), toStr(o.value.toSeq(3)._2), toJavaMeta[MethodType](o.value.toSeq(4)._2))
           case "NewTypeAnnotation" =>
             org.sireum.java.meta.NewTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "OuterClass" =>
             org.sireum.java.meta.OuterClass(toStr(o.value.toSeq(1)._2), toOption(o.value.toSeq(2)._2)(toTuple2))
           case "Parameter" =>
             org.sireum.java.meta.Parameter(toVector(o.value.toSeq(1)._2)(toStr), toOption(o.value.toSeq(2)._2)(toStr), toVector(o.value.toSeq(3)._2)(toJavaMeta[EntityAnnotation]))
           case "PutFieldHandle" =>
             org.sireum.java.meta.PutFieldHandle(toStr(o.value.toSeq(1)._2), toStr(o.value.toSeq(2)._2), toStr(o.value.toSeq(3)._2), toJavaMeta[Type](o.value.toSeq(4)._2))
           case "PutStaticFieldHandle" =>
             org.sireum.java.meta.PutStaticFieldHandle(toStr(o.value.toSeq(1)._2), toStr(o.value.toSeq(2)._2), toStr(o.value.toSeq(3)._2), toJavaMeta[Type](o.value.toSeq(4)._2))
           case "ResourceVariableTypeAnnotation" =>
             org.sireum.java.meta.ResourceVariableTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2), toVector(o.value.toSeq(3)._2)(toJavaMeta[LocalVarAnnotationElement]))
           case "ShortType" => org.sireum.java.meta.ShortType
           case "ShortValue" =>
             org.sireum.java.meta.ShortValue(toShort(o.value.toSeq(1)._2))
           case "StringValue" =>
             org.sireum.java.meta.StringValue(toStr(o.value.toSeq(1)._2))
           case "ThrowsTypeAnnotation" =>
             org.sireum.java.meta.ThrowsTypeAnnotation(toOption(o.value.toSeq(1)._2)(toJavaMeta[TypePath]), toJavaMeta[EntityAnnotation](o.value.toSeq(2)._2))
           case "TrueValue" => org.sireum.java.meta.TrueValue
           case "TypeArgument" =>
             org.sireum.java.meta.TypeArgument(toInt(o.value.toSeq(1)._2))
           case "TypePath" =>
             org.sireum.java.meta.TypePath(toVector(o.value.toSeq(1)._2)(toJavaMeta[Step]))
           case "TypeValue" =>
             org.sireum.java.meta.TypeValue(toJavaMeta[Type](o.value.toSeq(1)._2))
           case "VoidType" => org.sireum.java.meta.VoidType
           case "WildcardBound" => org.sireum.java.meta.WildcardBound
           case "_ObjectType" =>
             org.sireum.java.meta._ObjectType(toStrIntern(o.value.toSeq(1)._2))
         }).asInstanceOf[T]
    }
}