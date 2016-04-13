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
// This file was auto-generated from org.sireum.logika.message.InputMessage

package org.sireum.logika.message

import upickle.Js
import org.sireum.util.Json._

object InputMessageJson {
  import scala.language.implicitConversions

  implicit def fromInputMessage(o: org.sireum.logika.message.InputMessage): Js.Obj =
    o match {
      case o: org.sireum.logika.message.Check =>
        Js.Obj(
          (".class", Js.Str("Check")),
          ("requestId", fromStr(o.requestId)),
          ("isBackground", fromAnyVal(o.isBackground)),
          ("kind", fromStr(o.kind)),
          ("hintEnabled", fromAnyVal(o.hintEnabled)),
          ("inscribeSummoningsEnabled", fromAnyVal(o.inscribeSummoningsEnabled)),
          ("coneInfluenceEnabled", fromAnyVal(o.coneInfluenceEnabled)),
          ("proofs", fromSeq(o.proofs)(fromInputMessage)),
          ("lastOnly", fromAnyVal(o.lastOnly)),
          ("autoEnabled", fromAnyVal(o.autoEnabled)),
          ("timeout", fromAnyVal(o.timeout)),
          ("checkSatEnabled", fromAnyVal(o.checkSatEnabled)),
          ("bitWidth", fromAnyVal(o.bitWidth)),
          ("loopBound", fromAnyVal(o.loopBound)),
          ("recursionBound", fromAnyVal(o.recursionBound)),
          ("useMethodContract", fromAnyVal(o.useMethodContract))
        )
      case o: org.sireum.logika.message.ProofFile =>
        Js.Obj(
          (".class", Js.Str("ProofFile")),
          ("fileUriOpt", fromOption(o.fileUriOpt)(fromStr)),
          ("content", fromStr(o.content))
        )
      case org.sireum.logika.message.Terminate =>
        Js.Obj((".class", Js.Str("Terminate")))
    }

  implicit def toInputMessage[T <: org.sireum.logika.message.InputMessage](v: Js.Value): T =
    (v: @unchecked) match {
      case o: Js.Obj =>
        (o.value.head._2.asInstanceOf[Js.Str].value match {
           case "Check" =>
             org.sireum.logika.message.Check(toStr(o.value(1)._2), toBoolean(o.value(2)._2), toStr(o.value(3)._2), toBoolean(o.value(4)._2), toBoolean(o.value(5)._2), toBoolean(o.value(6)._2), toVector(o.value(7)._2)(toInputMessage[ProofFile]), toBoolean(o.value(8)._2), toBoolean(o.value(9)._2), toInt(o.value(10)._2), toBoolean(o.value(11)._2), toInt(o.value(12)._2), toInt(o.value(13)._2), toInt(o.value(14)._2), toBoolean(o.value(15)._2))
           case "ProofFile" =>
             org.sireum.logika.message.ProofFile(toOption(o.value(1)._2)(toStr), toStr(o.value(2)._2))
           case "Terminate" => org.sireum.logika.message.Terminate
         }).asInstanceOf[T]
    }
}