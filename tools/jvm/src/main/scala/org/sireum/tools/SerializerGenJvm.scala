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

package org.sireum.tools

import java.io.File

import org.sireum.message._
import org.sireum.lang.ast._
import org.sireum.lang.parser.SlangParser
import org.sireum.util.FileUtil
import org.sireum.{ISZ, None => SNone, Option => SOption, Some => SSome, String => SString}
import org.sireum.U32._

object SerializerGenJvm {
  val messageKind = "JsonGen"

  def apply(
    allowSireumPackage: Boolean,
    mode: SerializerGen.Mode.Type,
    licenseOpt: Option[File],
    srcs: Seq[File],
    dest: File,
    packageNameOpt: SOption[ISZ[SString]],
    nameOpt: SOption[SString],
    reporter: Reporter
  ): SOption[String] = {
    val lOpt = licenseOpt match {
      case Some(f) => SSome(SString(FileUtil.readFile(f).trim))
      case _ => SNone[SString]()
    }
    var uris = Vector[String]()
    var sources = ISZ[(SOption[SString], SString)]()
    for (src <- srcs) {
      val srcText = FileUtil.readFile(src)
      val srcUri = FileUtil.toUri(src)
      uris = uris :+ src.getName
      sources = sources :+ ((SSome(SString(srcUri)), SString(srcText)))
    }
    val fOpt = {
      import org.sireum._
      SSome(st"${(uris, ", ")}".render)
    }
    val packageName: ISZ[SString] = packageNameOpt match {
      case SSome(pn) => pn
      case _ => ISZ()
    }
    val r = SerializerGen.gen(mode, sources, packageName, reporter, lOpt, fOpt, nameOpt)
    if (reporter.hasError) SNone() else SSome(r.render.value)
  }
}
