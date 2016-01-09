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

package org.sireum.util.jvm

import java.io._
import java.net.URI
import java.nio.file._
import java.nio.file.attribute._
import org.sireum.util._

object FileUtil {

  def toFile(fileUri: FileResourceUri) =
    new File(new URI(fileUri))

  def fileUri(claz: Class[_], path: String) =
    toUri(new File(claz.getResource(path).toURI))

  def toUri(path: String): FileResourceUri = toUri(new File(path))

  def toUri(f: File): FileResourceUri = f.getCanonicalFile.toURI.toASCIIString

  def toFilePath(fileUri: FileResourceUri) =
    toFile(fileUri).getAbsolutePath

  def filename(fileUri: FileResourceUri) =
    toFile(fileUri).getName

  def listFiles(dirUri: FileResourceUri, ext: String,
                recursive: Boolean = false,
                result: MArray[FileResourceUri] = marrayEmpty[FileResourceUri]) //
  : ISeq[FileResourceUri] = {
    val dir = toFile(dirUri)
    if (dir.exists)
      dir.listFiles((dir, name) => name.endsWith(ext)).
        foreach { f => if (f.isFile) result += toUri(f) }
    if (recursive)
      dir.listFiles.foreach { f =>
        if (f.isDirectory) listFiles(toUri(f), ext, recursive, result)
      }
    result.toList
  }

  def readFile(r: java.io.Reader): String = {
    val buffer = new Array[Char](1024)
    var n = r.read(buffer)
    val sb = new StringBuilder
    while (n != -1) {
      sb.appendAll(buffer, 0, n)
      n = r.read(buffer)
    }
    sb.toString
  }

  def readFile(fileUri: FileResourceUri): (String, FileResourceUri) = {
    val uri = new URI(fileUri)
    val file = new File(uri)

    assert(file.exists)

    val size = file.length

    assert(size < Int.MaxValue)

    val buffer = new Array[Byte](size.toInt)
    val stream = uri.toURL.openStream
    stream.read(buffer)
    (new String(buffer), file.getAbsoluteFile.toURI.toASCIIString)
  }

  def readFileLines(fileUri: FileResourceUri): (ISeq[String], FileResourceUri) = {
    val uri = new URI(fileUri)
    val file = new File(uri)

    assert(file.exists)

    val stream = uri.toURL.openStream
    val lnr = new LineNumberReader(new InputStreamReader(stream))
    var line = lnr.readLine
    var result = ivectorEmpty[String]
    while (line != null) {
      result :+= line
      line = lnr.readLine
    }
    (result, file.getAbsoluteFile.toURI.toASCIIString)
  }

  def walkFileTree(d: Path, f: (Boolean, Path) => Unit, isDir: Boolean) {
    Files.walkFileTree(d, new SimpleFileVisitor[Path] {
      override def preVisitDirectory(
                                      d: Path, attrs: BasicFileAttributes) = {
        f(true, d)
        FileVisitResult.CONTINUE
      }

      override def visitFile(
                              p: Path, attrs: BasicFileAttributes) = {
        if (!isDir) f(false, p)
        FileVisitResult.CONTINUE
      }
    })
  }

  def delete(d: Path): Boolean = {
    var ok = true
    Files.walkFileTree(d, new SimpleFileVisitor[Path] {
      override def postVisitDirectory(d: Path,
                                      exc: IOException) =
        delete(d)

      override def visitFile(p: Path,
                             attrs: BasicFileAttributes) =
        delete(p)

      override def visitFileFailed(p: Path, exc: IOException) =
        delete(p)

      private def delete(p: Path) = {
        ok = ok && Files.deleteIfExists(p)
        if (ok) FileVisitResult.CONTINUE
        else FileVisitResult.TERMINATE
      }
    })
    ok
  }

  def writeFile(fileUri: FileResourceUri, content: String): Unit = {
    val fw = new FileWriter(toFile(fileUri))
    try fw.write(content) finally fw.close()
  }
}