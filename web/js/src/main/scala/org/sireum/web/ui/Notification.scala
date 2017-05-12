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

import org.scalajs.dom.html.{Button, Div}
import org.scalajs.dom.raw.{Element, MouseEvent}

import scalatags.Text.all._
import org.sireum.web.util._

object Notification {

  object Kind extends Enumeration {
    type Type = Value
    val Plain, Primary, Info, Warning, Error, Success = Value
  }

  def notify(parent: Element, tpe: Kind.Type, message: Frag): () => Unit = {
    val ncls = tpe match {
      case Kind.Plain => ""
      case Kind.Primary => "is-primary"
      case Kind.Info => "is-warning"
      case Kind.Warning => "is-warning"
      case Kind.Error => "is-danger"
      case Kind.Success => "is-success"
    }

    val bid = s"notify-delete-${System.currentTimeMillis()}"

    val notification = render[Div](div(cls := s"notification $ncls", button(id := bid, cls := "delete"))(message))

    parent.appendChild(notification)

    var isClosed = false
    val close: () => Unit = () => if (!isClosed) {
      isClosed = true
      parent.removeChild(notification)
    }

    $[Button](s"#$bid").onclick = (_: MouseEvent) => close()

    close
  }
}
