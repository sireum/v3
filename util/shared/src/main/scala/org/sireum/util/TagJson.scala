/*
Copyright (c) 2016, Robby, Kansas State University
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
// This file was auto-generated from org.sireum.util.Tag

package org.sireum.util

import upickle.Js
import org.sireum.util.Json._

object TagJson {
  import scala.language.implicitConversions

  implicit def fromTag(o: org.sireum.util.Tag): Js.Obj =
    o match {
      case o: org.sireum.util.ErrorMessage =>
        Js.Obj(
          (".class", Js.Str("ErrorMessage")),
          ("kind", fromStr(o.kind)),
          ("message", fromStr(o.message))
        )
      case o: org.sireum.util.FileLocationInfoErrorMessage =>
        Js.Obj(
          (".class", Js.Str("FileLocationInfoErrorMessage")),
          ("kind", fromStr(o.kind)),
          ("uri", fromStr(o.uri)),
          ("lineBegin", fromAnyVal(o.lineBegin)),
          ("columnBegin", fromAnyVal(o.columnBegin)),
          ("lineEnd", fromAnyVal(o.lineEnd)),
          ("columnEnd", fromAnyVal(o.columnEnd)),
          ("offset", fromAnyVal(o.offset)),
          ("length", fromAnyVal(o.length)),
          ("message", fromStr(o.message))
        )
      case o: org.sireum.util.FileLocationInfoInfoMessage =>
        Js.Obj(
          (".class", Js.Str("FileLocationInfoInfoMessage")),
          ("kind", fromStr(o.kind)),
          ("uri", fromStr(o.uri)),
          ("lineBegin", fromAnyVal(o.lineBegin)),
          ("columnBegin", fromAnyVal(o.columnBegin)),
          ("lineEnd", fromAnyVal(o.lineEnd)),
          ("columnEnd", fromAnyVal(o.columnEnd)),
          ("offset", fromAnyVal(o.offset)),
          ("length", fromAnyVal(o.length)),
          ("message", fromStr(o.message))
        )
      case o: org.sireum.util.FileLocationInfoWarningMessage =>
        Js.Obj(
          (".class", Js.Str("FileLocationInfoWarningMessage")),
          ("kind", fromStr(o.kind)),
          ("uri", fromStr(o.uri)),
          ("lineBegin", fromAnyVal(o.lineBegin)),
          ("columnBegin", fromAnyVal(o.columnBegin)),
          ("lineEnd", fromAnyVal(o.lineEnd)),
          ("columnEnd", fromAnyVal(o.columnEnd)),
          ("offset", fromAnyVal(o.offset)),
          ("length", fromAnyVal(o.length)),
          ("message", fromStr(o.message))
        )
      case o: org.sireum.util.InfoMessage =>
        Js.Obj(
          (".class", Js.Str("InfoMessage")),
          ("kind", fromStr(o.kind)),
          ("message", fromStr(o.message))
        )
      case o: org.sireum.util.InternalErrorMessage =>
        Js.Obj(
          (".class", Js.Str("InternalErrorMessage")),
          ("kind", fromStr(o.kind)),
          ("message", fromStr(o.message))
        )
      case o: org.sireum.util.LocationInfo =>
        Js.Obj(
          (".class", Js.Str("LocationInfo")),
          ("lineBegin", fromAnyVal(o.lineBegin)),
          ("columnBegin", fromAnyVal(o.columnBegin)),
          ("lineEnd", fromAnyVal(o.lineEnd)),
          ("columnEnd", fromAnyVal(o.columnEnd)),
          ("offset", fromAnyVal(o.offset)),
          ("length", fromAnyVal(o.length))
        )
      case o: org.sireum.util.LocationInfoErrorMessage =>
        Js.Obj(
          (".class", Js.Str("LocationInfoErrorMessage")),
          ("kind", fromStr(o.kind)),
          ("lineBegin", fromAnyVal(o.lineBegin)),
          ("columnBegin", fromAnyVal(o.columnBegin)),
          ("lineEnd", fromAnyVal(o.lineEnd)),
          ("columnEnd", fromAnyVal(o.columnEnd)),
          ("offset", fromAnyVal(o.offset)),
          ("length", fromAnyVal(o.length)),
          ("message", fromStr(o.message))
        )
      case o: org.sireum.util.LocationInfoInfoMessage =>
        Js.Obj(
          (".class", Js.Str("LocationInfoInfoMessage")),
          ("kind", fromStr(o.kind)),
          ("lineBegin", fromAnyVal(o.lineBegin)),
          ("columnBegin", fromAnyVal(o.columnBegin)),
          ("lineEnd", fromAnyVal(o.lineEnd)),
          ("columnEnd", fromAnyVal(o.columnEnd)),
          ("offset", fromAnyVal(o.offset)),
          ("length", fromAnyVal(o.length)),
          ("message", fromStr(o.message))
        )
      case o: org.sireum.util.LocationInfoWarningMessage =>
        Js.Obj(
          (".class", Js.Str("LocationInfoWarningMessage")),
          ("kind", fromStr(o.kind)),
          ("lineBegin", fromAnyVal(o.lineBegin)),
          ("columnBegin", fromAnyVal(o.columnBegin)),
          ("lineEnd", fromAnyVal(o.lineEnd)),
          ("columnEnd", fromAnyVal(o.columnEnd)),
          ("offset", fromAnyVal(o.offset)),
          ("length", fromAnyVal(o.length)),
          ("message", fromStr(o.message))
        )
      case o: org.sireum.util.WarningMessage =>
        Js.Obj(
          (".class", Js.Str("WarningMessage")),
          ("kind", fromStr(o.kind)),
          ("message", fromStr(o.message))
        )
    }

  implicit def toTag[T <: org.sireum.util.Tag](v: Js.Value): T =
    (v: @unchecked) match {
      case o: Js.Obj =>
        (o.value.head._2.asInstanceOf[Js.Str].value match {
           case "ErrorMessage" =>
             org.sireum.util.ErrorMessage(toStr(o.value(1)._2), toStr(o.value(2)._2))
           case "FileLocationInfoErrorMessage" =>
             org.sireum.util.FileLocationInfoErrorMessage(toStr(o.value(1)._2), toStr(o.value(2)._2), toInt(o.value(3)._2), toInt(o.value(4)._2), toInt(o.value(5)._2), toInt(o.value(6)._2), toInt(o.value(7)._2), toInt(o.value(8)._2), toStr(o.value(9)._2))
           case "FileLocationInfoInfoMessage" =>
             org.sireum.util.FileLocationInfoInfoMessage(toStr(o.value(1)._2), toStr(o.value(2)._2), toInt(o.value(3)._2), toInt(o.value(4)._2), toInt(o.value(5)._2), toInt(o.value(6)._2), toInt(o.value(7)._2), toInt(o.value(8)._2), toStr(o.value(9)._2))
           case "FileLocationInfoWarningMessage" =>
             org.sireum.util.FileLocationInfoWarningMessage(toStr(o.value(1)._2), toStr(o.value(2)._2), toInt(o.value(3)._2), toInt(o.value(4)._2), toInt(o.value(5)._2), toInt(o.value(6)._2), toInt(o.value(7)._2), toInt(o.value(8)._2), toStr(o.value(9)._2))
           case "InfoMessage" =>
             org.sireum.util.InfoMessage(toStr(o.value(1)._2), toStr(o.value(2)._2))
           case "InternalErrorMessage" =>
             org.sireum.util.InternalErrorMessage(toStr(o.value(1)._2), toStr(o.value(2)._2))
           case "LocationInfo" =>
             org.sireum.util.LocationInfo(toInt(o.value(1)._2), toInt(o.value(2)._2), toInt(o.value(3)._2), toInt(o.value(4)._2), toInt(o.value(5)._2), toInt(o.value(6)._2))
           case "LocationInfoErrorMessage" =>
             org.sireum.util.LocationInfoErrorMessage(toStr(o.value(1)._2), toInt(o.value(2)._2), toInt(o.value(3)._2), toInt(o.value(4)._2), toInt(o.value(5)._2), toInt(o.value(6)._2), toInt(o.value(7)._2), toStr(o.value(8)._2))
           case "LocationInfoInfoMessage" =>
             org.sireum.util.LocationInfoInfoMessage(toStr(o.value(1)._2), toInt(o.value(2)._2), toInt(o.value(3)._2), toInt(o.value(4)._2), toInt(o.value(5)._2), toInt(o.value(6)._2), toInt(o.value(7)._2), toStr(o.value(8)._2))
           case "LocationInfoWarningMessage" =>
             org.sireum.util.LocationInfoWarningMessage(toStr(o.value(1)._2), toInt(o.value(2)._2), toInt(o.value(3)._2), toInt(o.value(4)._2), toInt(o.value(5)._2), toInt(o.value(6)._2), toInt(o.value(7)._2), toStr(o.value(8)._2))
           case "WarningMessage" =>
             org.sireum.util.WarningMessage(toStr(o.value(1)._2), toStr(o.value(2)._2))
         }).asInstanceOf[T]
    }
}