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

import ffi.{FileSaver, Zip, ZipObject}
import org.scalajs.dom
import org.scalajs.dom.html.Select
import org.scalajs.dom.raw.{FileList, FileReader, ProgressEvent}
import org.sireum.web.playground.Playground.editor
import org.sireum.web.ui.Notification

import scala.collection.immutable.SortedMap
import org.sireum.web.util._

import scala.scalajs.js
import scala.scalajs.js.typedarray.ArrayBuffer
import scala.util.{Failure, Success}
import scalatags.Text.all._
import scala.concurrent.ExecutionContext.Implicits.global

object Files {

  object ChangeMode extends Enumeration {
    type Type = Value
    val Add, Delete, Overwrite, Update = Value
  }

  val fileKey = "sireum://"
  val filenamesKey = "org.sireum.filenames"
  val lastFilenameKey = "org.sireum.filename.last"

  val slangExt = ".slang"
  val cursorKey = "org.sireum.cursor"
  val newText = "import org.sireum._\n\n"
  val newTextLine: Int = newText.count(_ == '\n')
  val untitled: String = "Untitled" + slangExt

  final case class FileData(line: Int, column: Int, text: String)

  lazy val filenameSelection: Select = $[Select]("#filename")

  def lookup(key: String): Option[String] =
    Option(dom.window.localStorage.getItem(key))

  def update(key: String, value: String): Unit =
    dom.window.localStorage.setItem(key, value)

  def remove(key: String): Unit = {
    dom.window.localStorage.removeItem(key)
  }

  def erase(): Unit = {
    val ls = dom.window.localStorage
    ls.removeItem(filenamesKey)
    ls.removeItem(lastFilenameKey)
    var keys = List[String]()
    for (i <- 0 until ls.length) {
      ls.key(i) match {
        case k if k.startsWith(fileKey) => keys ::= k
        case _ =>
      }
    }
    keys.foreach(ls.removeItem)
  }

  def lookupContent(filename: String): Option[String] = {
    import upickle.default._
    lookup(fileKey + filename).map(read[FileData](_).text)
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
    filename.trim != "" && !filename(0).isDigit && filename(0) != '/' &&
      filename.last != '/' && filename.forall {
      case '/' => true
      case c => c.isLetterOrDigit
    }

  def isValidNewFilename(filename: String): Boolean =
    isValidFilename(filename) && {
      val fs = Files.lookupFilenames()._2
      !fs.contains(filename + slangExt)
    }

  def newFile(f: String, textOpt: Option[String]): Unit = {
    require(f.endsWith(slangExt))
    val (_, fs) = lookupFilenames()
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


  def incomingChanges(fileContentMap: SortedMap[String, String]): SortedMap[String, ChangeMode.Type] = {
    val fs = lookupFilenames()._2.toSet
    var r = SortedMap[String, ChangeMode.Type]()
    for (f <- fileContentMap.keys)
      if (fs.contains(f)) {
        if (lookupContent(f).get != fileContentMap(f))
          r += f -> ChangeMode.Overwrite
      } else r += f -> ChangeMode.Add
    r
  }

  def mergeIncoming(changes: SortedMap[String, ChangeMode.Type], fileContentMap: SortedMap[String, String]): Unit = {
    for ((f, cm) <- changes) (cm: @unchecked) match {
      case ChangeMode.Add => Files.newFile(f, Some(fileContentMap(f)))
      case ChangeMode.Overwrite => Files.deleteFile(f); Files.newFile(f, Some(fileContentMap(f)))
    }
    Files.lookupContent(Files.untitled) match {
      case Some(text) if text.trim == Files.newText.trim => Files.deleteFile(Files.untitled)
      case _ =>
    }
  }

  def outgoingChanges(fileContentMap: Map[String, String]): SortedMap[String, ChangeMode.Type] = {
    var r = SortedMap[String, ChangeMode.Type]()
    val fs = lookupFilenames()._2.toSet
    for (f <- fs)
      if (fileContentMap.contains(f)) {
        if (lookupContent(f).get != fileContentMap(f))
          r += f -> ChangeMode.Update
      } else r += f -> ChangeMode.Add
    for (f <- fileContentMap.keys if !fs.contains(f))
      r += f -> ChangeMode.Delete
    r
  }

  def loadZips(files: FileList, success: SortedMap[String, String] => Unit): Unit = {
    var fileContentMap = SortedMap[String, String]()

    def recurseZips(zips: List[(String, ZipObject)]): Unit = zips match {
      case Nil => success(fileContentMap)
      case head :: tail =>
        val (path, o) = head
        o.async("text").toFuture.onComplete {
          case Success(text) =>
            fileContentMap.get(path) match {
              case Some(_) =>
                Notification.notify(Notification.Kind.Error, s"Found duplicate entry for $path; please upload the zip files separately.")
              case _ =>
                fileContentMap += path -> text.toString
                recurseZips(tail)
            }
          case Failure(_) => Notification.notify(Notification.Kind.Error, s"Error encountered when reading $head.")
        }
    }

    var zips = List[(String, ZipObject)]()

    def recurseArrayBuffer(abs: List[(String, ArrayBuffer)]): Unit = abs match {
      case Nil => recurseZips(zips)
      case head :: tail =>
        val f = Zip.loadAsync(head._2, jsObj(createFolders = true, checkCRC32 = true)).toFuture
        f.onComplete {
          case Success(zip) =>
            zip.forEach((path, o) => if (path.endsWith(Files.slangExt)) zips ::= (path, o))
            recurseArrayBuffer(tail)
          case Failure(_) =>
            Notification.notify(Notification.Kind.Error, s"Error encountered when reading ${head._1}.")
        }
    }

    var abs = List[(String, ArrayBuffer)]()

    def recurseFiles(i: Int): Unit = if (i < files.length) {
      val r = new FileReader
      r.onloadend = (_: ProgressEvent) => {
        abs ::= (files(i).name, r.result.asInstanceOf[ArrayBuffer])
        recurseFiles(i + 1)
      }
      r.readAsArrayBuffer(files(i))
    } else recurseArrayBuffer(abs)

    recurseFiles(0)
  }

  def saveZip(filename: String): Unit = {
    val zip = new Zip
    val (_, fs) = lookupFilenames()
    for (f <- fs) {
      val i = f.lastIndexOf('/')
      if (i < 0) zip.file(f, lookupContent(f).get) else {
        val folder = zip.folder(f.substring(0, i))
        folder.file(f.substring(i + 1), lookupContent(f).get)
      }
    }
    zip.generateAsync(jsObj(`type` = "blob")).toFuture.onComplete {
      case Success(blob) => FileSaver.saveAs(blob, filename)
      case Failure(t) => Notification.notify(Notification.Kind.Error, s"Error encountered when generating a zip file for $filename (reason: ${t.getMessage}).")
    }
  }
}
