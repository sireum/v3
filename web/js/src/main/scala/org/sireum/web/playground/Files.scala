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

import monaco.editor.EndOfLinePreference
import org.scalajs.dom
import org.scalajs.dom.html.Select
import org.scalajs.dom.raw.Event
import org.sireum.web.playground.Playground.editor
import org.sireum.web.util._

import scala.scalajs.js
import scalatags.Text.all._

object Files {
  val fileKey = "sireum://"
  val lastFilenameKey = "org.sireum.filename.last"
  val filenamesKey = "org.sireum.filenames"
  val cursorKey = "org.sireum.cursor"
  val newText = "import org.sireum._\n\n"

  final case class FileData(line: Int, column: Int, text: String)

  lazy val filenameSelection: Select = {
    val r = $[Select]("#filename")
    r.onchange = { (_: Event) => load() }
    r
  }

  def lookup(key: String): Option[String] = {
    Option(dom.window.localStorage.getItem(key))
  }

  def update(key: String, value: String): Unit = {
    dom.window.localStorage.setItem(key, value)
  }

  def load(): Unit = {
    val FileData(l, c, text) = lookup(fileKey + selectedFilename) match {
      case Some(data) =>
        import upickle.default._
        read[FileData](data)
      case _ =>
        FileData(newText.count(_ == '\n') + 1, 1, newText)
    }
    editor.getModel().setValue(text)
    editor.setPosition(jsObj(lineNumber = l, column = c))
  }

  def save(line: Int, column: Int): Unit = {
    import upickle.default._
    val text = editor.getModel().getValue(EndOfLinePreference.LF, preserveBOM = false)
    val pos = editor.getPosition()
    val data = FileData(line = line, column = column, text = text)
    update(fileKey + selectedFilename, write(data))
  }

  def selectedFilename: String = {
    val selectedIndex = filenameSelection.selectedIndex
    filenameSelection.options(selectedIndex).value.replaceAllLiterally(" ", "")
  }

  def loadFiles(): Unit = {
    val (selected, filenames) = lookup(filenamesKey) match {
      case Some(fs) => (lookup(lastFilenameKey).get, js.JSON.parse(fs).asInstanceOf[js.Array[String]])
      case _ =>
        val fs = js.Array("Untitled.slang")
        update(filenamesKey, js.JSON.stringify(fs))
        ("Untitled.slang", fs)
    }
    updateSelection(selected, filenames)
  }

  def updateSelection(selectedFilename: String, filenames: js.Array[String]): Unit = {
    require(filenames.contains(selectedFilename))
    filenameSelection.innerHTML = (for (f <- filenames.sorted) yield
      option(selected := (f == selectedFilename), filename(f)).render).mkString("\n")
    update(lastFilenameKey, selectedFilename)
    load()
  }

  def filename(name: String): RawFrag =
    raw(s"$name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")

}
