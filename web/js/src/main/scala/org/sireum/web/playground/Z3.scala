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

package org.sireum.web.playground

import org.scalajs.dom
import org.scalajs.dom.WebSocket
import org.sireum.web.ui.Modal
import org.sireum.web.util._

import scala.scalajs.js.{Date, JSON}

object Z3 {
  val portKey = "org.sireum.wsd.port"
  var last: Double = 0

  def lookupPort: Int =
    Option(dom.window.localStorage.getItem(portKey)).map(_.toInt).getOrElse(8888)

  def updatePort(value: Int): Unit =
    dom.window.localStorage.setItem(portKey, value.toString)

  def erase(): Unit = {
    dom.window.localStorage.removeItem(portKey)
  }

  def query(script: String, callback: String => Unit): Unit = {
    val ws = new WebSocket(s"ws://localhost:$lookupPort")
    ws.onmessage = e => {
      val o = JSON.parse(e.data.toString)
      if (o.id.toString.toDouble >= last) callback(o.output.toString)
      ws.close(3001)
    }
    ws.onclose = e => {
      if (e.code != 3001)
        Modal.wsd(lookupPort, port => {
          if (port != lookupPort) updatePort(port)
          query(script, callback)
        })
    }
    ws.onopen = _ => ws.send(JSON.stringify(jsObj(id = new Date().getTime().toString, input = script)))
  }
}
