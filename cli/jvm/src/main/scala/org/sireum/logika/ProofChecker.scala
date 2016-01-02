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

package org.sireum.logika

import java.io._
import org.sireum.option.LogikaOption
import org.sireum.logika.ast._
import org.sireum.util._
import org.sireum.util.jvm._

object ProofChecker {
  def run(option: LogikaOption,
          outPrintln: String => Unit,
          errPrintln: String => Unit): Boolean =
    new ProofChecker(option, outPrintln, errPrintln).run()
}

class ProofChecker(option: LogikaOption,
                   outPrintln: String => Unit,
                   errPrintln: String => Unit) {
  def run(): Boolean = {
    if (option.ide) return runIde()
    val fileUriOpt: Option[FileResourceUri] = None
    var hasError = false
    implicit val reporter = new ConsoleTagReporter
    val sequentOpt: Option[Sequent] = option.sequent.flatMap {
      text =>
        val r: Option[Sequent] =
          Builder[Sequent](fileUriOpt, text) match {
            case Some(s) => Some(s)
            case _ =>
              hasError = true
              None
          }
        r
    }
    if (option.input == none()) {
      errPrintln("No input provided.")
      return true
    }

    val f = new File(option.input.get)
    if (!f.exists) {
      errPrintln(s"File ${f.getAbsolutePath} does not exist.")
      hasError = true
    }
    if (hasError) return false

    val fr = new FileReader(f)
    val fText = FileUtil.readFile(fr)
    fr.close()
    if (f.getName.endsWith(".scala") || f.getName.endsWith(".sc")) {
      Builder[Program](fileUriOpt, fText) match {
        case Some(program) =>
          if (tipe.TypeChecker.check(program))
            Checker.check(program, option.auto,
              option.timeout, option.sat)
        case _ =>
      }
    } else {
      (sequentOpt, Builder[Sequent](fileUriOpt, fText)) match {
        case (Some(sequent), Some(s)) if !hasError =>
          if (s.premises == sequent.premises &&
            s.conclusions == sequent.conclusions) {
            Checker.check(s, autoEnabled = false, option.timeout)(new ConsoleTagReporter)
          } else {
            val li = s.nodeLocMap(s.conclusions.last)
            outPrintln(
              s"""The specified sequent is different than the one in the file.
                  |Specified:
                  |${option.sequent.get}
                  |File:
                  |${fText.substring(0, li.offset + li.length)}""".stripMargin)
          }
        case (None, Some(s)) if !hasError =>
          Checker.check(s, autoEnabled = false,
            option.timeout, option.sat)(reporter)
        case _ =>
      }
    }

    false
  }

  def runIde(): Boolean = {
    val kind = "CLI"
    false
  }
}
