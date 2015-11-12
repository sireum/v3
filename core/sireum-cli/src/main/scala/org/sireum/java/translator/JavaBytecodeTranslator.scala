/*
Copyright (c) 2015, Robby, Kansas State University
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

package org.sireum.java.translator

import java.io._
import java.util.zip._

import org.sireum.option.JavaBytecodeTranslatorOption
import org.sireum.pilar.ast.PrettyPrinter

object JavaBytecodeTranslator {
  final val PILAR_EXT = ".plr"
  final val PILAR_ZIP_EXT = ".plz"
  final val ZIP_EXT = ".zip"
  final val JAR_EXT = ".jar"
  final val CLASS_EXT = ".class"

  def run(option: JavaBytecodeTranslatorOption,
          outPrintln: String => Unit,
          errPrintln: String => Unit): Boolean =
    new JavaBytecodeTranslator(option, outPrintln, errPrintln).run()
}

import JavaBytecodeTranslator._

class JavaBytecodeTranslator(option: JavaBytecodeTranslatorOption,
                             outPrintln: String => Unit,
                             errPrintln: String => Unit) {

  private def run(): Boolean = {
    val printUsage = option.getInputs.length == 0

    for (in <- option.getInputs) {
      val f = new File(in)
      lazy val fPath = f.getAbsolutePath
      if (f.isFile) {
        val name = f.getName
        if (name.endsWith(CLASS_EXT)) {
          translateClassFile(f)
        } else if (name.endsWith(ZIP_EXT) || name.endsWith(JAR_EXT)) {
          verbose(s"Translating file: $fPath ...")
          translateZip(f) match {
            case Some(o) =>
              verbose(s"Translated file: $fPath, to: ${o.getAbsolutePath}")
            case _ =>
              errPrintln(s"Error translating: $fPath")
          }
        } else {
          errPrintln(s"Cannot translate file: $fPath")
        }
      } else if (f.isDirectory) {
        verbose(s"Translating directory: $fPath ...")
        translateDir(f)
        verbose(s"Translated directory: $fPath ...")
      } else {
        try {
          Class.forName(in)
          translate(in)
          verbose(s"// Translated: $in")
        } catch {
          case e: ClassNotFoundException =>
            errPrintln(s"Could not find class: $in")
          case t: Throwable =>
            errPrintln(s"Error translating class: $in")
        }
      }
    }

    printUsage
  }

  private def verbose(msg: => String): Unit = {
    if (option.verbose) outPrintln(msg)
  }

  private def translateZip(f: File): Option[File] = {
    import scala.collection.JavaConversions._
    val zf = new ZipFile(f)
    val o = new File(f.getParentFile, removeExt(f.getName) + PILAR_ZIP_EXT)
    val zof = new ZipOutputStream(new FileOutputStream(o))
    var hasError = false
    try {
      for (ze: ZipEntry <- zf.entries) {
        val name = ze.getName
        val size = ze.getSize.toInt
        val buff = new Array[Byte](size)
        if (size != 0) {
          val zis = zf.getInputStream(ze)
          zis.read(buff)
        }
        if (name.endsWith(CLASS_EXT)) {
          val pilarEntryName = removeExt(name) + PILAR_EXT
          val ze2 = new ZipEntry(pilarEntryName)
          zof.putNextEntry(ze2)
          try {
            zof.write(translate(buff))
          } catch {
            case t: Throwable =>
              errPrintln(s"Error translating: $name")
              t.printStackTrace()
              if (o.exists()) o.deleteOnExit()
              hasError = true
          }
          zof.closeEntry()
          verbose(s"Translated file: $name, to: $pilarEntryName")
        } else {
          val ze2 = new ZipEntry(name)
          zof.putNextEntry(ze2)
          if (size != 0) zof.write(buff)
          zof.closeEntry()
          verbose(s"Copied entry: $name")
        }
      }
      if (hasError) None else Some(o)
    } finally {
      zof.close()
      zf.close()
    }
  }

  private def translateDir(d: File): Unit = {
    for (f <- d.listFiles) {
      if (f.isDirectory) translateDir(f)
      else if (f.getName.endsWith(CLASS_EXT)) translateClassFile(f)
    }
  }

  private def translateClassFile(f: File): Unit = {
    val d = f.getParentFile
    val buff = new Array[Byte](f.length.toInt)
    val fis = new FileInputStream(f)
    lazy val fPath = f.getAbsolutePath
    try {
      if (fis.read(buff) != -1) {
        val o = new File(d, removeExt(f.getName) + PILAR_EXT)
        val fw = new FileWriter(o)
        try {
          translate(buff, fw)
          verbose(s"Translated file: $fPath, to: .../${o.getName}")
        } catch {
          case t: Throwable =>
            errPrintln(s"Error translating: $fPath")
            t.printStackTrace()
        } finally {
          fw.close()
        }
      }
    } finally fis.close()
  }

  private def removeExt(filename: String): String = {
    val i = filename.lastIndexOf('.')
    if (i >= 0) filename.substring(0, i) else filename
  }

  private def translate(bytecode: Array[Byte]): Array[Byte] =
    PrettyPrinter(ClassBytecodeTranslator(bytecode)).getBytes

  private def translate(bytecode: Array[Byte], w: Writer): Unit = {
    w.append(PrettyPrinter(ClassBytecodeTranslator(bytecode)))
    w.flush()
  }

  private def translate(className: String): Unit = {
    outPrintln(PrettyPrinter(ClassBytecodeTranslator(className)))
  }
}
