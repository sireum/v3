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
  final val READ_INPUT_FAILED_EXIT_CODE: Int = -1
  final val BIT_WIDTH_UNSUPPORTED_EXIT_CODE: Int = -2
  final val FORMULA_MISCONFIGURED_EXIT_CODE: Int = -3
  final val SYMBOL_CONVERSION_FAILED_EXIT_CODE: Int = -4
  final val COMPARE_FAILED_EXIT_CODE: Int = -5
  final val RUN_FAILED_EXIT_CODE: Int = -6
  final val RUN_ERROR_EXIT_CODE: Int = -7
  final val VERIFICATION_FAILED_EXIT_CODE: Int = -8
  final val FORMULA_DIFF_EXIT_CODE: Int = -9
  final val TRANSLATION_FAILED_EXIT_CODE: Int = -10

  def run(option: LogikaOption,
          outPrintln: String => Unit,
          errPrintln: String => Unit): Boolean =
    new Main(option, outPrintln, errPrintln).run()
}

import Main._

class Main(option: LogikaOption,
           outPrintln: String => Unit,
           errPrintln: String => Unit) {
  def run(): Boolean = {
    runServer(option)

    if (option.input.isEmpty) return true

    val proofs = readProofs(option)

    checkBitWidth(option)

    checkFormula(option)

    convertSymbols(option, proofs)

    compare(option, proofs)

    val checkMessage = message.Check(
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

    implicit val reporter: AccumulatingTagReporter = new ConsoleTagReporter

    run(option, checkMessage, proofs)

    translateC(option, checkMessage, proofs)

    Checker.check(checkMessage)
    if (reporter.hasError) sys.exit(VERIFICATION_FAILED_EXIT_CODE)

    checkSequent(option, proofs)

    false
  }

  def compare(option: LogikaOption, proofs: ISeq[message.ProofFile]): Unit = {
    if (!option.compare) return
    if (option.input.length < 2) {
      errPrintln("Program comparison requires more than one program input files.")
      sys.exit(COMPARE_FAILED_EXIT_CODE)
    }
    var hasError = false
    var fileProofContent: ISeq[(FileResourceUri, Program, String)] = ivectorEmpty
    for (proof <- proofs) {
      val (failed, _, _, unitNodes) = {
        Checker.typeCheck(message.Check(
          requestId = "",
          isBackground = false,
          kind =
            if (option.symexe) message.CheckerKind.SummarizingSymExe
            else message.CheckerKind.Forward,
          hintEnabled = false,
          inscribeSummoningsEnabled = false,
          coneInfluenceEnabled = false,
          proofs = ivector(proof),
          lastOnly = option.last,
          autoEnabled = option.auto,
          timeout = option.timeout,
          checkSatEnabled = option.sat,
          bitWidth = option.bitwidth,
          loopBound = 10,
          recursionBound = 10,
          useMethodContract = true))(new ConsoleTagReporter)
      }
      if (failed) {
        hasError = true
      } else {
        if (unitNodes.head.isInstanceOf[Program]) {
          implicit val reporter: AccumulatingTagReporter = new ConsoleTagReporter
          val (newContent, p) = AstUtil.wipe(None, proof.content, option.bitwidth, autoEnabled = true)
          fileProofContent :+= (proof.fileUriOpt.get, p, newContent)
        } else {
          hasError = true
          errPrintln(s"Cannot compare ${proof.fileUriOpt.get} because it is not a program.")
        }
      }
    }
    if (hasError) sys.exit(COMPARE_FAILED_EXIT_CODE)
    val (anchorFileUri, anchorProgram, anchorContent) = fileProofContent.head
    import java.io.File
    import com.sksamuel.diffpatch.DiffMatchPatch
    val anchorFile = new File(anchorFileUri)
    val wipedAnchorFile = new File(anchorFile.getParentFile, s"anchor-${anchorFile.getName}")
    for ((fileUri, program, content) <- fileProofContent.tail if program != anchorProgram) try {
      errPrintln(s"The program AST (sans contracts and prints) of $fileUri is structurally different than $anchorFileUri.")
      if (!hasError) {
        if (FileUtil.writeFile(wipedAnchorFile, anchorContent))
          outPrintln(s"Wrote to ${wipedAnchorFile.getCanonicalPath}.")
        else {
          errPrintln(s"Could not write to ${wipedAnchorFile.getCanonicalPath}.")
          sys.exit(COMPARE_FAILED_EXIT_CODE)
        }
      }
      hasError = true
      val file = new File(fileUri)
      val wipedFile = new File(file.getParentFile, s"wiped-${file.getName}")
      if (FileUtil.writeFile(wipedFile, content))
        outPrintln(s"Wrote to ${wipedFile.getCanonicalPath}.")
      else {
        errPrintln(s"Could not write to ${wipedFile.getCanonicalPath}.")
        sys.exit(COMPARE_FAILED_EXIT_CODE)
      }
      val dmp = new DiffMatchPatch()
      val htmlFile = new File(file.getParentFile, s"diff-${file.getName}.html")
      val diffs = dmp.diff_main(anchorContent, content)
      val html = dmp.diff_prettyHtml(diffs)
      assert(!(diffs.size == 1 && diffs.get(0).operation == DiffMatchPatch.Operation.EQUAL))
      val lines = html.split("&para;").indices.map(_.toString).mkString(" \\a ")
      if (FileUtil.writeFile(htmlFile,
        s"""<html>
           |  <head>
           |    <title>Diff Between ${wipedAnchorFile.getName} and ${wipedFile.getName}</title>
           |    <style>
           |    body {
           |      background-color: #eee;
           |      color: #555;
           |    }
           |
           |    div.code {
           |      font-family: "Meslo", monospace;
           |      background-color: #fff;
           |      width: em(440);
           |      margin: 4em auto;
           |      padding: 0.5em;
           |      border-radius: .25em;
           |      box-shadow: .1em .1em .5em rgba(0,0,0,.45);
           |      white-space: pre;
           |      position: relative;
           |      overflow: hidden;
           |      padding-left: 4.5em;
           |    }
           |
           |    div.code:before {
           |      content: "$lines \\a";
           |      color: silver;
           |      display: inline-block;
           |      position: absolute;
           |      left: 0em;
           |      padding: 0 .5em;
           |      margin-right: .5em;
           |      border-right: 1px solid #ddd;
           |    }
           |    </style>
           |  </head>
           |  <body>
           |    <h1>Diff Between <a href="${wipedAnchorFile.toURI.toURL}">${wipedAnchorFile.getName}</a> and <a href="${wipedFile.toURI.toURL}">${wipedFile.getName}</a></h1>
           |    <div class="code">$html</div>
           |  </body>
           |</html>""".stripMargin))
        outPrintln(s"Wrote diff report to ${htmlFile.getCanonicalPath}.")
      else {
        errPrintln(s"Could not write diff report to ${htmlFile.getCanonicalPath}.")
        sys.exit(COMPARE_FAILED_EXIT_CODE)
      }
    } catch {
      case t: Throwable =>
        hasError = true
        errPrintln(t.getMessage)
    }
    if (hasError) sys.exit(COMPARE_FAILED_EXIT_CODE)
    sys.exit
  }

  def checkFormula(option: LogikaOption): Unit = {
    if (option.input.length > 1 && option.formula.nonEmpty) {
      errPrintln("Formula cannot be provided when checking multiple files.")
      sys.exit(FORMULA_MISCONFIGURED_EXIT_CODE)
    }
  }

  def checkBitWidth(option: LogikaOption): Unit = {
    option.bitwidth match {
      case 0 =>
      case 8 | 16 | 32 | 64 =>
        if (!option.symexe) {
          errPrintln(s"Bit-width ${option.bitwidth} is only supported on symbolic execution mode.")
          sys.exit(BIT_WIDTH_UNSUPPORTED_EXIT_CODE)
        }
      case _ =>
        errPrintln(s"Unsupported bit-width: ${option.bitwidth}; only 8, 16, 32, 64, and 0 are supported (0 means arbitrary-precision).")
        sys.exit(BIT_WIDTH_UNSUPPORTED_EXIT_CODE)
    }
  }

  def checkSequent(option: LogikaOption, proofs: ISeq[message.ProofFile])(
    implicit reporter: AccumulatingTagReporter): Unit = {
    if (option.formula.isEmpty) return
    var failed = false
    Builder(None, proofs.head.content, 0, isAutoEnabled = false) match {
      case Some(s: Sequent) =>
        for (text <- option.formula) {
          Builder(None, text, 0, isAutoEnabled = false) match {
            case Some(sequent: Sequent) =>
              if (!(s.premises == sequent.premises &&
                s.conclusions == sequent.conclusions)) {
                val li = s.nodeLocMap(s.conclusions.last)
                var end = li.offset
                val text = proofs.head.content
                while (text.charAt(end) != '{') end += 1
                failed = true
                errPrintln(
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
        for (text <- option.formula) {
          Builder(None, '⊢' + text, 0, isAutoEnabled = false) match {
            case Some(sequent: Sequent) =>
              if (sequent.conclusions.head != tt.formula) {
                val li = tt.nodeLocMap(tt.formula)
                var start = li.offset
                var end = li.offset
                val text = proofs.head.content
                while (text.charAt(start) != '|') start -= 1
                while (text.charAt(end) != '\n') end += 1
                failed = true
                errPrintln(
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
    if (failed) sys.exit(FORMULA_DIFF_EXIT_CODE)
  }

  def readProofs(option: LogikaOption): IVector[message.ProofFile] = {
    var failed = false
    val proofs = option.input.toVector.flatMap { filePath =>
      import java.io._
      val f = new File(filePath)
      if (!f.exists) {
        errPrintln(s"File ${f.getAbsolutePath} does not exist.")
        failed = true
        None
      } else {
        val fr = new FileReader(f)
        val fText = FileUtil.readFile(fr)
        fr.close()
        Some(message.ProofFile(
          fileUriOpt =
            if (option.input.length == 1) None
            else Some(f.getCanonicalPath),
          content = fText))
      }
    }
    if (failed) sys.exit(READ_INPUT_FAILED_EXIT_CODE)
    proofs
  }

  def translateC(option: LogikaOption, checkMessage: message.Check,
                 proofs: ISeq[message.ProofFile])(
                  implicit reporter: AccumulatingTagReporter): Unit = {
    if (option.c.isEmpty) return
    val file = {
      val f = new java.io.File(option.c.get)
      if (f.isDirectory)
        new java.io.File(f, option.input.map(removeExt).mkString("+") + ".c")
      else f
    }
    val filename = file.getName
    if (!filename.endsWith(".c")) {
      errPrintln(s"Invalid C file extension ${file.getName}.")
      sys.exit(TRANSLATION_FAILED_EXIT_CODE)
    }

    val (hasError, _, bitWidth, unitNodes) = Checker.typeCheck(checkMessage)
    if (hasError) sys.exit(TRANSLATION_FAILED_EXIT_CODE)
    var allPrograms = true
    for ((input, unitNode) <- option.input.zip(unitNodes)) {
      if (!unitNode.isInstanceOf[Program]) {
        errPrintln(s"Cannot translate $input because it is not a Logika program.")
        allPrograms = false
      }
    }
    if (!allPrograms) sys.exit(TRANSLATION_FAILED_EXIT_CODE)

    val r = transpiler.C(unitNodes.map(_.asInstanceOf[Program]), bitWidth)
    if (reporter.hasError) {
      sys.exit(TRANSLATION_FAILED_EXIT_CODE)
    }
    if (option.input.length == 1) {
      val comment = s"// Generated from ${new java.io.File(option.input.head).getCanonicalPath}"
      r.stMain.add("comment", comment)
      r.stMainHeader.add("comment", comment)
    }
    if (FileUtil.writeFile(file, alignRightLineComment(r.stMain.render())))
      outPrintln(s"Wrote to ${file.getCanonicalPath}.")
    else {
      errPrintln(s"Could not write to ${file.getCanonicalPath}.")
      sys.exit(TRANSLATION_FAILED_EXIT_CODE)
    }

    val name = filename.substring(0, filename.length - 2)
    val filenameH = name + ".h"
    val fileH = new java.io.File(file.getParentFile, filenameH)
    if (FileUtil.writeFile(fileH, alignRightLineComment(r.stMainHeader.render())))
      outPrintln(s"Wrote to ${fileH.getCanonicalPath}.")
    else {
      errPrintln(s"Could not write to ${fileH.getCanonicalPath}.")
      sys.exit(TRANSLATION_FAILED_EXIT_CODE)
    }

    val fileCMake = new java.io.File(file.getParentFile, "CMakeLists.txt")
    if (FileUtil.writeFile(fileCMake, r.stCMake.add("name", name).render()))
      outPrintln(s"Wrote to ${fileCMake.getCanonicalPath}.")
    else {
      errPrintln(s"Could not write to ${fileCMake.getCanonicalPath}.")
      sys.exit(TRANSLATION_FAILED_EXIT_CODE)
    }

    for ((fName, fText) <- r.files) {
      val fFile = new java.io.File(file.getParentFile, fName)
      if (FileUtil.writeFile(fFile, fText))
        outPrintln(s"Wrote to ${fFile.getCanonicalPath}.")
      else {
        errPrintln(s"Could not write to ${fFile.getCanonicalPath}.")
        sys.exit(TRANSLATION_FAILED_EXIT_CODE)
      }
    }
  }

  def alignRightLineComment(text: String, prefix: String = "// L"): String = {
    val lines = text.lines.toVector
    var maxCommentColumn = -1
    for (line <- lines) {
      var i = line.lastIndexOf(prefix)
      if (i > maxCommentColumn) maxCommentColumn = i
    }
    if (maxCommentColumn < 0) return text
    maxCommentColumn += 3
    val sb = new StringBuilder
    val lineSep = scala.util.Properties.lineSeparator
    for (line <- lines) {
      val i = line.lastIndexOf(prefix)
      if (i >= 0) {
        sb.append(line.substring(0, i))
        for (i <- 0 until maxCommentColumn - i) {
          sb.append(' ')
        }
        sb.append(line.substring(i))
      } else sb.append(line)
      sb.append(lineSep)
    }
    sb.toString.trim + lineSep
  }

  def removeExt(filepath: String): String = {
    val filename = new java.io.File(filepath).getName
    val i = filename.lastIndexOf('.')
    if (i >= 0) filename.substring(0, i)
    else filename
  }

  def run(option: LogikaOption, checkMessage: message.Check,
          proofs: ISeq[message.ProofFile])(
           implicit reporter: AccumulatingTagReporter): Unit = {
    if (!option.run) return
    val (hasError, _, _, unitNodes) = Checker.typeCheck(checkMessage)
    if (hasError) sys.exit(RUN_FAILED_EXIT_CODE)
    var allPrograms = true
    for ((input, unitNode) <- option.input.zip(unitNodes)) {
      if (!unitNode.isInstanceOf[Program]) {
        errPrintln(s"Cannot run $input because it is not a Logika program.")
        allPrograms = false
      }
    }
    if (!allPrograms) sys.exit(RUN_FAILED_EXIT_CODE)

    import java.io._
    import ammonite.ops._
    val sireumHome = Option(System.getenv("SIREUM_HOME")) match {
      case Some(v) => Path(new File(v))
      case _ =>
        errPrintln("Could not detect Sireum installation directory.")
        sys.exit(RUN_FAILED_EXIT_CODE)
    }
    val javaHome = sireumHome / 'platform / 'java
    val scalaHome = sireumHome / 'platform / 'scala
    val scalaScript =
      OsUtil.detect match {
        case OsArch.Win => scalaHome / 'bin / "scala.bat"
        case _ => scalaHome / 'bin / 'scala
      }
    val sireumJar = sireumHome / 'bin / "sireum.jar"

    try {
      proofs.size match {
        case 1 =>
          val programPath = new File(option.input.head).getCanonicalPath
          %(scalaScript, "-nc", "-nowarn", "-cp", sireumJar, programPath,
            JAVA_HOME = javaHome, SCALA_HOME = scalaHome)(pwd)
        case _ =>
          val programText = proofs.map(_.content).mkString(scala.util.Properties.lineSeparator)
          %(scalaScript, "-nc", "-nowarn", "-cp", sireumJar, "-e", programText,
            JAVA_HOME = javaHome, SCALA_HOME = scalaHome)(pwd)
      }
      sys.exit
    } catch {
      case _: InteractiveShelloutException => sys.exit(RUN_ERROR_EXIT_CODE)
    }
  }

  def convertSymbols(option: LogikaOption, proofs: ISeq[message.ProofFile]): Unit = {
    if (!(option.ascii || option.unicode)) return
    val fileContents = option.input.zip(proofs).
      map(p => (new java.io.File(p._1), p._2.content))
    var hasError = false
    for ((f, asciiOpt, uniOpt) <- fileContents.map(p =>
      (p._1,
        if (option.ascii) Some(SymbolConverter.toASCII(p._2)) else None,
        if (option.unicode) Some(SymbolConverter.toUnicode(p._2)) else None)))
      try {
        import java.io._
        asciiOpt.foreach { content =>
          val f2 = new File(f.getParentFile, s"ascii-${f.getName}")
          if (FileUtil.writeFile(f2, content))
            outPrintln(s"Wrote to ${f2.getCanonicalPath}.")
          else {
            errPrintln(s"Could not write to ${f2.getCanonicalPath}.")
            sys.exit(SYMBOL_CONVERSION_FAILED_EXIT_CODE)
          }
        }
        uniOpt.foreach { content =>
          val f2 = new File(f.getParentFile, s"unicode-${f.getName}.")
          if (FileUtil.writeFile(f2, content))
            outPrintln(s"Wrote to ${f2.getCanonicalPath}.")
          else {
            errPrintln(s"Could not write to ${f2.getCanonicalPath}.")
            sys.exit(SYMBOL_CONVERSION_FAILED_EXIT_CODE)
          }
        }
      } catch {
        case t: Throwable =>
          hasError = true
          errPrintln(t.getMessage)
      }
    if (hasError) sys.exit(SYMBOL_CONVERSION_FAILED_EXIT_CODE)
  }

  def runServer(option: LogikaOption): Unit = {
    if (!option.server) return

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
    sys.exit
  }
}
