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
// This file was auto-generated from org.sireum.java.meta.MetaTypePath

package org.sireum.java.meta

import upickle.Js
import org.sireum.util.Json._

object TypePathJson {
  import scala.language.implicitConversions

  implicit def fromMetaTypePath(o: org.sireum.java.meta.MetaTypePath): Js.Obj =
    o match {
      case org.sireum.java.meta.ArrayElement =>
        Js.Obj((".class", Js.Str("ArrayElement")))
      case org.sireum.java.meta.InnerType =>
        Js.Obj((".class", Js.Str("InnerType")))
      case o: org.sireum.java.meta.TypeArgument =>
        Js.Obj(
          (".class", Js.Str("TypeArgument")),
          ("index", fromAnyVal(o.index))
        )
      case o: org.sireum.java.meta.TypePath =>
        Js.Obj(
          (".class", Js.Str("TypePath")),
          ("steps", fromSeq(o.steps)(fromMetaTypePath))
        )
      case org.sireum.java.meta.WildcardBound =>
        Js.Obj((".class", Js.Str("WildcardBound")))
    }

  implicit def toMetaTypePath[T <: org.sireum.java.meta.MetaTypePath](v: Js.Value): T =
    (v: @unchecked) match {
      case o: Js.Obj =>
        (o.value.head._2.asInstanceOf[Js.Str].value match {
           case "ArrayElement" => org.sireum.java.meta.ArrayElement
           case "InnerType" => org.sireum.java.meta.InnerType
           case "TypeArgument" =>
             org.sireum.java.meta.TypeArgument(toInt(o.value(1)._2))
           case "TypePath" =>
             org.sireum.java.meta.TypePath(toVector(o.value(1)._2)(toMetaTypePath[Step]))
           case "WildcardBound" => org.sireum.java.meta.WildcardBound
         }).asInstanceOf[T]
    }
}