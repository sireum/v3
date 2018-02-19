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

package org.sireum.lang.tools

import java.io.File

import org.sireum.message._
import org.sireum.lang.ast._
import org.sireum.lang.parser.SlangParser
import org.sireum.lang.symbol.GlobalDeclarationResolver
import org.sireum.util.FileUtil
import org.sireum.{HashMap => SHashMap, None => SNone, Option => SOption, Some => SSome, String => SString}

object SerializerGenJvm {
  val messageKind = "JsonGen"

  def apply(
    allowSireumPackage: Boolean,
    mode: SerializerGen.Mode.Type,
    licenseOpt: Option[File],
    src: File,
    dest: File,
    nameOpt: SOption[SString],
    reporter: Reporter
  ): SOption[String] = {
    val srcText = FileUtil.readFile(src)
    val srcUri = FileUtil.toUri(src)
    val r = SlangParser(allowSireumPackage, isWorksheet = false, isDiet = false, SSome(srcUri), srcText, reporter)
    r.unitOpt match {
      case SSome(p: TopUnit.Program) =>
        val gdr = GlobalDeclarationResolver(SHashMap.empty, SHashMap.empty, reporter)
        gdr.resolveProgram(p)
        val lOpt = licenseOpt match {
          case Some(f) => SSome(SString(FileUtil.readFile(f).trim))
          case _ => SNone[SString]()
        }
        val fOpt = SSome(SString(dest.getParentFile.toURI.relativize(src.toURI).toString))
        val gen =
          SerializerGen.Gen(mode, gdr.globalNameMap, gdr.globalTypeMap, Util.ids2strings(p.packageName.ids), reporter)
        reporter.reports(gen.reporter.messages)
        SSome(gen.gen(lOpt, fOpt, nameOpt).render.value)
      case _ =>
        reporter.error(SNone(), messageKind, "Expecting program input.")
        return SNone()
    }
  }
}
