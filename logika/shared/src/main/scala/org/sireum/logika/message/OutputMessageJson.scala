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
// This file was auto-generated from org.sireum.logika.message.OutputMessage

package org.sireum.logika.message

import upickle.Js
import org.sireum.util.Json._
import org.sireum.util._
import org.sireum.util.TagJson._

object OutputMessageJson {
  import scala.language.implicitConversions

  implicit def fromOutputMessage(o: org.sireum.logika.message.OutputMessage): Js.Obj =
    o match {
      case o: org.sireum.logika.message.Result =>
        Js.Obj(
          (".class", Js.Str("Result")),
          ("requestId", fromStr(o.requestId)),
          ("isBackground", fromAnyVal(o.isBackground)),
          ("tags", fromSeq(o.tags)(fromTag))
        )
    }

  implicit def toOutputMessage[T <: org.sireum.logika.message.OutputMessage](v: Js.Value): T =
    (v: @unchecked) match {
      case o: Js.Obj =>
        (o.value.head._2.asInstanceOf[Js.Str].value match {
           case "Result" =>
             org.sireum.logika.message.Result(toStr(o.value(1)._2), toBoolean(o.value(2)._2), toVector(o.value(3)._2)(toTag[Tag]))
         }).asInstanceOf[T]
    }
}