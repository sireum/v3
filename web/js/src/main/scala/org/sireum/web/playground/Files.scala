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
  val slangExt = ".slang"
  val fileKey = "sireum://"
  val lastFilenameKey = "org.sireum.filename.last"
  val filenamesKey = "org.sireum.filenames"
  val cursorKey = "org.sireum.cursor"
  val newText = "import org.sireum._\n\n"
  val newTextLine: Int = newText.count(_ == '\n')
  val untitled: String = "Untitled" + slangExt

  final case class FileData(line: Int, column: Int, text: String)

  lazy val filenameSelection: Select = {
    val r = $[Select]("#filename")
    r.onchange = { (_: Event) => load(Files.selectedFilename) }
    r
  }

  def lookup(key: String): Option[String] =
    Option(dom.window.localStorage.getItem(key))

  def update(key: String, value: String): Unit =
    dom.window.localStorage.setItem(key, value)

  def remove(key: String): Unit = {
    dom.window.localStorage.removeItem(key)
  }

  def updateFilenames(fs: js.Array[String]): Unit =
    update(filenamesKey, js.JSON.stringify(fs))

  def lookupFilenames(): (String, js.Array[String]) = {
    lookup(filenamesKey) match {
      case Some(fs) => (lookup(lastFilenameKey).getOrElse(untitled), js.JSON.parse(fs).asInstanceOf[js.Array[String]])
      case _ =>
        val f = untitled
        val fs = js.Array(f)
        updateFilenames(js.Array(f))
        (f, fs)
    }
  }

  def load(filename: String): Unit = {
    filenameSelection.selectedIndex = lookupFilenames()._2.indexOf(filename)
    val FileData(l, c, text) = lookup(fileKey + filename) match {
      case Some(data) =>
        import upickle.default._
        read[FileData](data)
      case _ =>
        FileData(newText.count(_ == '\n') + 1, 1, newText)
    }
    editor.getModel().setValue(text)
    editor.setPosition(jsObj(lineNumber = l, column = c))
    update(lastFilenameKey, filename)
    editor.focus()
  }

  def save(filename: String, line: Int, column: Int, text: String): Unit = {
    import upickle.default._
    val data = FileData(line = line, column = column, text = text)
    update(fileKey + filename, write(data))
  }

  def selectedFilename: String = {
    val selectedIndex = filenameSelection.selectedIndex
    filenameSelection.options(selectedIndex).value.replaceAllLiterally(" ", "")
  }

  def isValidFilename(filename: String): Boolean =
    filename.trim != "" &&      filename.forall {
      case '/' => true
      case c => c.isLetterOrDigit
    }

  def isValidNewFilename(filename: String): Boolean =
    isValidFilename(filename) && {
      val fs = Files.lookupFilenames()._2
      !fs.contains(filename + slangExt)
    }

  def newFile(filename: String, textOpt: Option[String]): Unit = {
    val (_, fs) = lookupFilenames()
    val f = filename + slangExt
    val newFs = (fs :+ f).sorted
    textOpt match {
      case Some(text) => save(f, 1, 1, text)
      case _ =>
    }
    updateFilenames(newFs)
    updateSelection(f, newFs)
  }

  def deleteFile(filename: String): Unit = {
    remove(fileKey + filename)
    val (_, fs) = lookupFilenames()
    if (fs.length == 1) {
      val newFs = js.Array(untitled)
      updateFilenames(newFs)
      updateSelection(untitled, newFs)
    } else {
      val i = fs.indexOf(filename)
      val selectedFilename = fs(
        if (i == 0) 1
        else if (i == fs.length - 1) i - 1
        else i + 1)
      fs.remove(i)
      updateFilenames(fs)
      updateSelection(selectedFilename, fs)
    }
  }

  def loadFiles(): Unit = {
    val (selected, fs) = lookupFilenames()
    updateSelection(selected, fs)
  }

  def updateSelection(selectedFilename: String, filenames: js.Array[String]): Unit = {
    require(filenames.contains(selectedFilename))
    filenameSelection.innerHTML = (for (f <- filenames) yield
      option(selected := (f == selectedFilename), filename(f)).render).mkString("\n")
    load(selectedFilename)
  }

  def filename(name: String): RawFrag =
    raw(s"$name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")

}
