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

package org.sireum.util.reflect

import java.io.File
import java.nio.file.Files

import org.sireum.option._
import org.sireum.util._

object ReflectGen {

  final def run(option: CliGenOption,
                outPrintln: String => Unit,
                errPrintln: String => Unit): Boolean = {
    val optOpt = check(option, outPrintln, errPrintln)
    if (optOpt.isEmpty) return false
    val opt = optOpt.get

    val o =
      try {
        val companionClass =
          Class.forName(
            Reflection.companion(opt.root, processAnnotations = false).
              get._1.asModule.fullName)
        val o = companionClass.getMethod("make").invoke(null)
        if (o.getClass.getName != option.rootClassName) {
          errPrintln(s"'${option.rootClassName}' companion 'make()' method does not return an object of type '${option.rootClassName}'")
          return false
        } else if (!o.isInstanceOf[AnyRef with Product]) {
          errPrintln(s"'${option.rootClassName}' is not a case class")
          return false
        }
        o.asInstanceOf[AnyRef with Product]
      } catch {
        case t: Throwable =>
          errPrintln(s"Could not find '${option.rootClassName}' companion 'make():${option.rootClassName}' method")
          return false
      }

    write(
      opt,
      new CliGen(opt.licenseFileOpt, opt.packageNameOpt, opt.className).
        generate(o),
      outPrintln)
  }

  final def run(option: JsonGenOption,
                outPrintln: String => Unit,
                errPrintln: String => Unit): Boolean = {
    val optOpt = check(option, outPrintln, errPrintln)
    if (optOpt.isEmpty) return false
    val opt = optOpt.get

    val root = Reflection.getTypeOfClass(opt.root)

    write(
      opt,
      RewriterJsonGen.generateJson(opt.licenseFileOpt,
        opt.packageNameOpt, opt.className, root),
      outPrintln)
  }

  final def run(option: RewriterGenOption,
                outPrintln: String => Unit,
                errPrintln: String => Unit): Boolean = {
    val optOpt = check(option, outPrintln, errPrintln)
    if (optOpt.isEmpty) return false
    val opt = optOpt.get

    val root = Reflection.getTypeOfClass(opt.root)

    write(
      opt,
      RewriterJsonGen.generateRewriter(opt.licenseFileOpt,
        opt.packageNameOpt, opt.className, root),
      outPrintln)
  }

  private def write(opt: ReflectGenOpt,
                    s: String,
                    outPrintln: String => Unit): Boolean = {
    opt.outputFileOpt match {
      case Some(f) =>
        Files.write(f.toPath, s.getBytes)
        outPrintln(s"Written ${f.getAbsolutePath}")
      case _ => outPrintln(s)
    }
    false
  }

  private def check(option: ReflectGenOption,
                    outPrintln: String => Unit,
                    errPrintln: String => Unit): Option[ReflectGenOpt] = {
    var ok = true
    val clazz =
      try {
        Class.forName(option.rootClassName)
      } catch {
        case t: Throwable =>
          errPrintln(s"Could not find class named: '${option.rootClassName}'")
          ok = false
          null
      }

    val licenseFile =
      option.licenseFile match {
        case SomeBean(path) =>
          val f = new File(path)
          if (f.isFile) {
            Some(new String(Files.readAllBytes(f.toPath)).trim)
          } else {
            errPrintln(s"Could not read license file: '$path'")
            ok = false
            None
          }
        case _ => None
      }

    val (outputFile, packageName, className) =
      option.outputDir match {
        case SomeBean(path) =>
          val d = new File(path)
          if (d.isFile) {
            errPrintln(s"Output directory is a file: '$path'")
            ok = false
            (None, None, "")
          } else {
            if (!d.exists()) {
              outPrintln(s"Output directory does not exist; it will be created")
            }
            val i = option.className.lastIndexOf('.')
            val (packageName, className) =
              if (i < 0) (None, option.className)
              else
                (Some(option.className.substring(0, i)),
                  option.className.substring(i + 1))
            (Some(new File(d, option.className.replaceAll("\\.", "/") + ".scala")),
              packageName, className)
          }
        case _ => (None, None, "")
      }

    if (ok) {
      outputFile.foreach { f =>
        val d = f.getParentFile
        if (!d.exists() && !d.mkdirs()) {
          ok = false
          errPrintln(s"Could not create directory: '${d.getAbsolutePath}'")
        }
      }
    }

    if (ok)
      Some(ReflectGenOpt(packageName, className, licenseFile, outputFile, clazz))
    else None
  }

  private case class ReflectGenOpt(packageNameOpt: Option[String],
                                   className: String,
                                   licenseFileOpt: Option[String],
                                   outputFileOpt: Option[File],
                                   root: Class[_])
}
