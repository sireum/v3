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

package ffi

import scala.scalajs.js
import scala.scalajs.js.Promise
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.typedarray.ArrayBuffer

@js.native
@JSGlobal("JSZip")
object JsZip extends js.Object {
  def loadAsync(a: ArrayBuffer, option: js.Dynamic): Promise[JsZip] = js.native
}

@js.native
@JSGlobal("JSZip")
class JsZip extends js.Object {
  def forEach(f: js.Function2[String, ZipObject, Unit]): Unit = js.native
  def file(name: String, content: String): Unit = js.native
  def folder(name: String): JsZipFolder = js.native
  def generateAsync(option: js.Dynamic): Promise[js.Dynamic] = js.native
}

@js.native
trait ZipObject extends js.Object {
  def async(tpe: String): Promise[js.Dynamic] = js.native
}

@js.native
trait JsZipFolder extends js.Object {
  def file(name: String, content: String): Unit = js.native
}