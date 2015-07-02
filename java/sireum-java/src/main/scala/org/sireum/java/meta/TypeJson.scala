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
// This file was auto-generated from org.sireum.java.meta.Type

package org.sireum.java.meta

import upickle.Js
import org.sireum.util.Json._

object TypeJson {
  import scala.language.implicitConversions

  implicit def fromType(o: org.sireum.java.meta.Type): Js.Obj =
    o match {
      case o: org.sireum.java.meta.ArrayType =>
        Js.Obj(
          (".class", Js.Str("ArrayType")),
          ("element", fromType(o.element))
        )
      case org.sireum.java.meta.BooleanType =>
        Js.Obj((".class", Js.Str("BooleanType")))
      case org.sireum.java.meta.ByteType =>
        Js.Obj((".class", Js.Str("ByteType")))
      case org.sireum.java.meta.CharType =>
        Js.Obj((".class", Js.Str("CharType")))
      case org.sireum.java.meta.DoubleType =>
        Js.Obj((".class", Js.Str("DoubleType")))
      case org.sireum.java.meta.FloatType =>
        Js.Obj((".class", Js.Str("FloatType")))
      case org.sireum.java.meta.IntType =>
        Js.Obj((".class", Js.Str("IntType")))
      case org.sireum.java.meta.LongType =>
        Js.Obj((".class", Js.Str("LongType")))
      case o: org.sireum.java.meta.ObjectType =>
        Js.Obj(
          (".class", Js.Str("ObjectType")),
          ("name", fromStr(o.name))
        )
      case org.sireum.java.meta.ShortType =>
        Js.Obj((".class", Js.Str("ShortType")))
      case org.sireum.java.meta.VoidType =>
        Js.Obj((".class", Js.Str("VoidType")))
    }

  implicit def toType[T <: org.sireum.java.meta.Type](v: Js.Value): T =
    (v: @unchecked) match {
      case o: Js.Obj =>
        (o.value.head._2.asInstanceOf[Js.Str].value match {
           case "ArrayType" =>
             org.sireum.java.meta.ArrayType(toType[Type](o.value(1)._2))
           case "BooleanType" => org.sireum.java.meta.BooleanType
           case "ByteType" => org.sireum.java.meta.ByteType
           case "CharType" => org.sireum.java.meta.CharType
           case "DoubleType" => org.sireum.java.meta.DoubleType
           case "FloatType" => org.sireum.java.meta.FloatType
           case "IntType" => org.sireum.java.meta.IntType
           case "LongType" => org.sireum.java.meta.LongType
           case "ObjectType" =>
             org.sireum.java.meta.ObjectType(toStr(o.value(1)._2))
           case "ShortType" => org.sireum.java.meta.ShortType
           case "VoidType" => org.sireum.java.meta.VoidType
         }).asInstanceOf[T]
    }
}