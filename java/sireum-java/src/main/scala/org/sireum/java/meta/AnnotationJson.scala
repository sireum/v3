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

// @formatter:off
// This file was auto-generated from org.sireum.java.meta.MetaAnnotation

package org.sireum.java.meta

import upickle.Js
import org.sireum.util.Json._
import TypeJson._

object AnnotationJson {
  import scala.language.implicitConversions

  implicit def fromMetaAnnotation(o: org.sireum.java.meta.MetaAnnotation): Js.Obj =
    o match {
      case o: org.sireum.java.meta.Annotation =>
        Js.Obj(
          (".class", Js.Str("Annotation")),
          ("args", fromSeq(o.args)(fromMetaAnnotation))
        )
      case o: org.sireum.java.meta.Arg =>
        Js.Obj(
          (".class", Js.Str("Arg")),
          ("name", fromStr(o.name)),
          ("value", fromMetaAnnotation(o.value))
        )
      case o: org.sireum.java.meta.ArrayValue =>
        Js.Obj(
          (".class", Js.Str("ArrayValue")),
          ("elements", fromSeq(o.elements)(fromMetaAnnotation))
        )
      case o: org.sireum.java.meta.ByteValue =>
        Js.Obj(
          (".class", Js.Str("ByteValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.CharValue =>
        Js.Obj(
          (".class", Js.Str("CharValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.DoubleValue =>
        Js.Obj(
          (".class", Js.Str("DoubleValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.EnumValue =>
        Js.Obj(
          (".class", Js.Str("EnumValue")),
          ("name", fromStr(o.name)),
          ("tipe", fromType(o.tipe)),
          ("value", fromStr(o.value))
        )
      case org.sireum.java.meta.FalseValue =>
        Js.Obj((".class", Js.Str("FalseValue")))
      case o: org.sireum.java.meta.FloatValue =>
        Js.Obj(
          (".class", Js.Str("FloatValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.IntValue =>
        Js.Obj(
          (".class", Js.Str("IntValue")),
          ("value", fromAnyVal(o.value))
        )
      case o: org.sireum.java.meta.LongValue =>
        Js.Obj(
          (".class", Js.Str("LongValue")),
          ("value", fromAnyVal(o.value))
        )
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
      case org.sireum.java.meta.TrueValue =>
        Js.Obj((".class", Js.Str("TrueValue")))
    }

  implicit def toMetaAnnotation[T <: org.sireum.java.meta.MetaAnnotation](v: Js.Value): T =
    (v: @unchecked) match {
      case o: Js.Obj =>
        (o.value.head._2.asInstanceOf[Js.Str].value match {
           case "Annotation" =>
             org.sireum.java.meta.Annotation(toVector(o.value(1)._2)(toMetaAnnotation[Arg]))
           case "Arg" =>
             org.sireum.java.meta.Arg(toStr(o.value(1)._2), toMetaAnnotation[ArgValue](o.value(2)._2))
           case "ArrayValue" =>
             org.sireum.java.meta.ArrayValue(toVector(o.value(1)._2)(toMetaAnnotation[ArgValue]))
           case "ByteValue" =>
             org.sireum.java.meta.ByteValue(toByte(o.value(1)._2))
           case "CharValue" =>
             org.sireum.java.meta.CharValue(toChar(o.value(1)._2))
           case "DoubleValue" =>
             org.sireum.java.meta.DoubleValue(toDouble(o.value(1)._2))
           case "EnumValue" =>
             org.sireum.java.meta.EnumValue(toStr(o.value(1)._2), toType[Type](o.value(2)._2), toStr(o.value(3)._2))
           case "FalseValue" => org.sireum.java.meta.FalseValue
           case "FloatValue" =>
             org.sireum.java.meta.FloatValue(toFloat(o.value(1)._2))
           case "IntValue" =>
             org.sireum.java.meta.IntValue(toInt(o.value(1)._2))
           case "LongValue" =>
             org.sireum.java.meta.LongValue(toLong(o.value(1)._2))
           case "ShortValue" =>
             org.sireum.java.meta.ShortValue(toShort(o.value(1)._2))
           case "StringValue" =>
             org.sireum.java.meta.StringValue(toStr(o.value(1)._2))
           case "TrueValue" => org.sireum.java.meta.TrueValue
         }).asInstanceOf[T]
    }
}