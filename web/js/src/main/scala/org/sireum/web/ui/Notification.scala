/*
 Copyright (c) 2017, Robby, Kansas State University
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

package org.sireum.web.ui

import ffi.Amaran
import scala.scalajs.js

object Notification {

  object Kind extends Enumeration {
    type Type = Value
    val Plain, Primary, Info, Warning, Error, Success = Value
  }

  def notify(tpe: Kind.Type, message: String): Unit = {
    val (bgColor, color) = tpe match {
      case Kind.Plain => ("#f9f5fb", "#4e4e4e")
      case Kind.Primary => ("#8e44ad", "#ffffff")
      case Kind.Info => ("#3498db", "#ffffff")
      case Kind.Warning => ("#ff7518", "#ffffff")
      case Kind.Error => ("#e74c3c", "#ffffff")
      case Kind.Success => ("#2ecc71", "#ffffff")
    }
    Amaran.amaran(js.Dynamic.literal(
      theme = "colorful",
      content = js.Dynamic.literal(
        bgcolor = bgColor,
        color = color,
        message = message
      ),
      position = "bottom right",
      inEffect = "slideRight",
      outEffect = "slideRight",
      resetTimeout = "true"
    ))
  }
}
