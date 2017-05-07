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

package org.sireum.web

import monaco.editor.IEditorConstructionOptions
import org.scalajs.dom
import org.scalajs.dom.raw.{Event, UIEvent}
import org.scalajs.jquery.jQuery

import org.sireum.web.util.JsObject

import scala.scalajs.js
import scalatex.PlaygroundSpa

object Playground {

  def updateView(editor: monaco.editor.IEditor): Unit = {
    val height = dom.window.innerHeight - 90
    jQuery("#view").height(height)
    jQuery("#columns").height(height)
    jQuery("#editor").height(height)
    jQuery("#output").height(height)
    editor.layout()
    editor.focus()
    jQuery("body").css("background-color", "#8e44ad")
    jQuery("#output").css("background-color", "lightgrey")
  }

  def apply(): Unit = {
    jQuery("body").append(PlaygroundSpa().render)

    js.Dynamic.literal
    val editor = monaco.editor.Editor.create(dom.document.getElementById("editor"), JsObject(
      value = "",
      language = "slang",
      fontSize = 16
    ).asInstanceOf[IEditorConstructionOptions])

    dom.document.onreadystatechange = (_: Event) => updateView(editor)
    dom.window.onresize = (_: UIEvent) => updateView(editor)
  }

  val slangId = "slang"
}
