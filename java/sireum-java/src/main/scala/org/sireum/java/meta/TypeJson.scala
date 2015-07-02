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
      case o: org.sireum.java.meta.Array =>
        Js.Obj(
          (".class", Js.Str("Array")),
          ("element", fromType(o.element))
        )
      case org.sireum.java.meta.Boolean =>
        Js.Obj((".class", Js.Str("Boolean")))
      case org.sireum.java.meta.Byte =>
        Js.Obj((".class", Js.Str("Byte")))
      case org.sireum.java.meta.Char =>
        Js.Obj((".class", Js.Str("Char")))
      case org.sireum.java.meta.Double =>
        Js.Obj((".class", Js.Str("Double")))
      case org.sireum.java.meta.Float =>
        Js.Obj((".class", Js.Str("Float")))
      case org.sireum.java.meta.Int =>
        Js.Obj((".class", Js.Str("Int")))
      case org.sireum.java.meta.Long =>
        Js.Obj((".class", Js.Str("Long")))
      case o: org.sireum.java.meta.Object =>
        Js.Obj(
          (".class", Js.Str("Object")),
          ("name", fromStr(o.name))
        )
      case org.sireum.java.meta.Short =>
        Js.Obj((".class", Js.Str("Short")))
      case org.sireum.java.meta.Void =>
        Js.Obj((".class", Js.Str("Void")))
    }

  implicit def toType[T <: org.sireum.java.meta.Type](v: Js.Value): T =
    (v: @unchecked) match {
      case o: Js.Obj =>
        (o.value.head._2.asInstanceOf[Js.Str].value match {
           case "Array" =>
             org.sireum.java.meta.Array(toType[Type](o.value(1)._2))
           case "Boolean" => org.sireum.java.meta.Boolean
           case "Byte" => org.sireum.java.meta.Byte
           case "Char" => org.sireum.java.meta.Char
           case "Double" => org.sireum.java.meta.Double
           case "Float" => org.sireum.java.meta.Float
           case "Int" => org.sireum.java.meta.Int
           case "Long" => org.sireum.java.meta.Long
           case "Object" =>
             org.sireum.java.meta.Object(toStr(o.value(1)._2))
           case "Short" => org.sireum.java.meta.Short
           case "Void" => org.sireum.java.meta.Void
         }).asInstanceOf[T]
    }
}