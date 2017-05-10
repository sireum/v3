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

import org.scalajs.dom
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.html.{Anchor, Button, Div, Input}
import org.scalajs.dom.raw.KeyboardEvent

import scalatags.Text.all._
import scalatags.Text.tags2._
import org.sireum.web.util._

object Modal {
  val escape = 27
  val enter = 13

  def confirm(titleText: String,
              labelText: String,
              success: () => Unit): Unit = {
    val modal = render[Div](
      div(cls := "modal is-active",
        div(cls := "modal-background"),
        div(cls := "modal-card",
          header(cls := "modal-card-head",
            p(cls := "modal-card-title")(titleText),
            button(id := "modal-delete", cls := "delete")
          ),
          section(cls := "modal-card-body",
            div(cls := "field", label(cls := "label")(labelText))
          ),
          footer(cls := "modal-card-foot",
            a(id := "modal-ok", cls := "button is-success")("Ok"),
            a(id := "modal-cancel", cls := "button is-danger")("Cancel")
          )
        )
      )
    )

    val oldKeyup = dom.document.onkeyup

    dom.document.body.appendChild(modal)

    def close(): Unit = {
      dom.document.onkeyup = oldKeyup
      dom.document.body.removeChild(modal)
    }

    def ok(): Unit = {
      close()
      success()
    }

    val okButton = $[Anchor]("#modal-ok")
    val closeF = (_: MouseEvent) => close()
    okButton.onclick = (_: MouseEvent) => ok()
    $[Button]("#modal-delete").onclick = closeF
    $[Anchor]("#modal-cancel").onclick = closeF

    dom.document.onkeyup = (e: KeyboardEvent) => {
      e.keyCode match {
        case `escape` => close()
        case `enter` => ok()
        case _ =>
      }
    }

  }

  def textInput(titleText: String,
                labelText: String,
                placeholderText: String,
                validator: String => Boolean,
                success: String => Unit): Unit = {
    val modal = render[Div](
      div(cls := "modal is-active",
        div(cls := "modal-background"),
        div(cls := "modal-card",
          header(cls := "modal-card-head",
            p(cls := "modal-card-title")(titleText),
            button(id := "modal-delete", cls := "delete")
          ),
          section(cls := "modal-card-body",
            div(cls := "field",
              label(cls := "label")(labelText),
              p(cls := "control",
                input(id := "modal-input", cls := "input is-danger", `type` := "text", placeholder := placeholderText)
              )
            )
          ),
          footer(cls := "modal-card-foot",
            a(id := "modal-ok", cls := "button", disabled := true)("Ok"),
            a(id := "modal-cancel", cls := "button is-danger")("Cancel")
          )
        )
      )
    )

    val oldKeyup = dom.document.onkeyup

    dom.document.body.appendChild(modal)

    def close(): Unit = {
      dom.document.onkeyup = oldKeyup
      dom.document.body.removeChild(modal)
    }

    val okButton = $[Anchor]("#modal-ok")
    val textInput = $[Input]("#modal-input")
    def ok(): Unit = {
      if (okButton.getAttribute("disabled") != "true") {
        close()
        success(textInput.value)
      }
    }

    val closeF = (_: MouseEvent) => close()
    okButton.onclick = (_: MouseEvent) => ok()
    $[Button]("#modal-delete").onclick = closeF
    $[Anchor]("#modal-cancel").onclick = closeF
    textInput.onkeyup = (e: KeyboardEvent) => {
      e.keyCode match {
        case `escape` => close()
        case `enter` => ok()
        case _ =>
          if (validator(textInput.value)) {
            textInput.className = "input is-success"
            okButton.className = "button is-success"
            okButton.setAttribute("disabled", "false")
          } else {
            textInput.className = "input is-danger"
            okButton.className = "button"
            okButton.setAttribute("disabled", "true")
          }
      }
    }
    dom.document.onkeyup = (e: KeyboardEvent) => {
      e.keyCode match {
        case `escape` => close()
        case `enter` => ok()
        case _ =>
      }
    }
    textInput.focus()
  }
}
