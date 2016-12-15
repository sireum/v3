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

import java.io.StringWriter

import org.sireum.logika.message.ProofFile
import org.sireum.option.LogikaOption
import org.sireum.logika.ast._
import org.sireum.logika.util.SymbolConverter
import org.sireum.util._
import org.sireum.util.jvm._

object Main {
  def run(option: LogikaOption,
          outPrintln: String => Unit,
          errPrintln: String => Unit): Boolean =
    new Main(option, outPrintln, errPrintln).run()
}

class Main(option: LogikaOption,
           outPrintln: String => Unit,
           errPrintln: String => Unit) {
  def run(): Boolean = {
    if (option.server) return runServer()

    if (option.input.isEmpty)
      return true

    if (option.input.length > 1 && option.formula.nonEmpty) {
      errPrintln("Formula cannot be provided when checking multiple files.")
      return false
    }

    if (option.ascii && option.unicode) {
      errPrintln("Cannot convert to ASCII and Unicode at the same time.")
      return false
    }

    if (option.ascii || option.unicode) {
      var hasError = false
      val contents = option.input.toVector.flatMap { filename =>
        import java.io._
        val f = new File(filename)
        if (!f.exists) {
          errPrintln(s"File ${f.getAbsolutePath} does not exist.")
          hasError = true
          None
        } else {
          val fr = new FileReader(f)
          val fText = FileUtil.readFile(fr)
          fr.close()
          Some(f, fText)
        }
      }
      if (hasError) return false
      val (prefix, newFileContents) =
        if (option.ascii) {
          ("ascii", contents.map(p => (p._1, SymbolConverter.toASCII(p._2))))
        } else {
          ("unicode", contents.map(p => (p._1, SymbolConverter.toUnicode(p._2))))
        }
      for ((f, newContent) <- newFileContents) {
        import java.io._
        val f2 = new File(f.getParentFile, s"$prefix-${f.getName}")
        FileUtil.writeFile(f2, newContent)
        outPrintln(s"Wrote to ${f2.getCanonicalPath}")
      }
      return false
    }

    var hasError = false
    val proofs =
      option.input.toVector.flatMap { filename =>
        import java.io._
        val f = new File(filename)
        if (!f.exists) {
          errPrintln(s"File ${f.getAbsolutePath} does not exist.")
          hasError = true
          None
        } else {
          val fr = new FileReader(f)
          val fText = FileUtil.readFile(fr)
          fr.close()
          Some(message.ProofFile(if (option.input.length == 1) None else Some(filename), fText))
        }
      }
    option.bitwidth match {
      case 0 | 8 | 16 | 32 | 64 =>
      case _ =>
        errPrintln(s"Unsupported bit-width: ${option.bitwidth}; only 8, 16, 32, 64, and 0 are supported (0 means arbitrary-precision).")
        hasError = true
    }
    if (hasError) return false

    implicit val reporter = new ConsoleTagReporter

    hasError = Checker.check(message.Check(
      requestId = "",
      isBackground = false,
      kind =
        if (option.symexe) message.CheckerKind.SummarizingSymExe
        else message.CheckerKind.Forward,
      hintEnabled = false,
      inscribeSummoningsEnabled = false,
      coneInfluenceEnabled = false,
      proofs = proofs,
      lastOnly = option.last,
      autoEnabled = option.auto,
      timeout = option.timeout,
      checkSatEnabled = option.sat,
      bitWidth = option.bitwidth,
      loopBound = 10,
      recursionBound = 10,
      useMethodContract = true)
    ).tags.exists(_.isInstanceOf[ErrorTag])

    if (hasError) return false

    if (option.formula.nonEmpty) {
      Builder(None, proofs.head.content, 0, isAutoEnabled = false) match {
        case Some(s: Sequent) =>
          option.formula.foreach {
            text =>
              Builder(None, text, 0, isAutoEnabled = false) match {
                case Some(sequent: Sequent) =>
                  if (!(s.premises == sequent.premises &&
                    s.conclusions == sequent.conclusions)) {
                    val li = s.nodeLocMap(s.conclusions.last)
                    var end = li.offset
                    val text = proofs.head.content
                    while (text.charAt(end) != '{') end += 1
                    outPrintln(
                      s"""The specified sequent is different than the one in the file.
                         |Specified:
                         |${option.formula.get}
                         |File:
                         |${proofs.head.content.substring(0, end).trim}""".stripMargin)
                  }
                case _ =>
              }
          }
        case Some(tt: TruthTable) =>
          option.formula.foreach {
            text =>
              Builder(None, '⊢' + text, 0, isAutoEnabled = false) match {
                case Some(sequent: Sequent) =>
                  if (sequent.conclusions.head != tt.formula) {
                    val li = tt.nodeLocMap(tt.formula)
                    var start = li.offset
                    var end = li.offset
                    val text = proofs.head.content
                    while (text.charAt(start) != '|') start -= 1
                    while (text.charAt(end) != '\n') end += 1
                    outPrintln(
                      s"""The specified formula is different than the one in the file.
                         |Specified:
                         |${option.formula.get}
                         |File:
                         |${text.substring(start + 1, end).trim}""".stripMargin)
                  }
                case _ =>
              }
          }
        case _ =>
      }
    }

    false
  }

  def runServer(): Boolean = {
    def internalError(requestId: String, t: Throwable): Unit = {
      val sw = new StringWriter
      sw.append("An error was thrown when processing the input message.")
      sw.append(scala.util.Properties.lineSeparator)
      t.printStackTrace(new java.io.PrintWriter(sw))
      Console.out.println(message.Message.pickleOutput(message.Result(
        "", isBackground = false, ivector(InternalErrorMessage("CLI", sw.toString)))))
      Console.out.flush()
    }
    import org.sireum.logika.util.Z3
    var line = Console.in.readLine()
    var exit = false
    Z3.satCacheEnabled = true
    while (!exit && line != null) {
      try {
        if (line.trim != "")
          message.Message.unpickleInput[message.InputMessage](line) match {
            case message.Terminate => exit = true
            case m: message.Check =>
              implicit val reporter = new AccumulatingTagReporter
              try {
                Console.out.println(message.Message.pickleOutput(Checker.check(m)))
                Console.out.flush()
              } catch {
                case t: Throwable => internalError(m.requestId, t)
              }
            case _: ProofFile => assert(false)
          }
      } catch {
        case t: Throwable => internalError("", t)
      }
      if (!exit) {
        val t = Z3.satCachePrev
        t.clear()
        Z3.satCachePrev = Z3.satCacheCurrent
        Z3.satCacheCurrent = t
        line = Console.in.readLine()
      }
    }
    false
  }
}
