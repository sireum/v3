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

package org.sireum.pilar.parser

import java.io._
import java.nio.file.Files
import java.util.Random

import org.sireum.option.PilarParserOption
import org.sireum.pilar.ast._
import org.sireum.util._

object Parser {
  def run(option: PilarParserOption,
          outPrintln: String => Unit,
          errPrintln: String => Unit): Boolean = {
    var printUsage = false
    val im = PilarParserOption.InputMode
    val om = PilarParserOption.OutputMode

    val stdin = option.standardInput

    var ok = true
    var inputs = ivectorEmpty[(PilarParserOption.InputMode.Type, File)]

    val outputFile = option.outputFile.map { o =>
      val f = new File(o)
      val fParent = f.getParentFile
      if (!fParent.exists()) {
        ok = false
        errPrintln(s"Output directory '${fParent.getPath}' does not exist")
      } else if (f.exists()) {
        outPrintln(s"Output file '$o'exists; it will be overwritten")
      }
      f
    }

    val inputMode =
      option.inputMode match {
        case im.Pilar | im.JSON | im.Scala => option.inputMode
        case im.Auto =>
          if (stdin) {
            errPrintln(s"Cannot use input mode '${im.Auto}' for standard input")
            outPrintln(s"Defaulting to '${im.Pilar}'")
            im.Pilar
          } else im.Auto
        case mode =>
          errPrintln(s"'$mode' is not a valid input mode")
          if (stdin) ok = false
          else outPrintln(s"Defaulting to '${im.Auto}'")
          im.Auto
      }

    val maxErrors =
      if (option.maxErrors < 0) {
        errPrintln("Maximum number of errors cannot be lower than zero")
        val n = new Random().nextInt(Int.MaxValue) + 1
        outPrintln(s"Defaulting to '$n'")
        n
      } else {
        option.maxErrors
      }

    val outputMode =
      if (om.elements.contains(option.outputMode))
        option.outputMode
      else {
        errPrintln(s"Output mode '${option.outputMode}' is not recognized")
        val m = om.elements(new Random().nextInt(om.elements.size))
        outPrintln(s"Defaulting to '$m'")
        m
      }

    if (option.inputs.nonEmpty) {
      if (stdin) {
        outPrintln("Using standard input stream")
        outPrintln(s"Ignoring input files:")
        option.inputs.foreach(outPrintln)
      } else {
        for (i <- option.inputs) {
          val f = new File(i)
          if (f.exists()) {
            val mode =
              if (inputMode == im.Auto) {
                val fname = f.getName
                val i = fname.lastIndexOf('.')
                if (i <= 0) im.Auto
                else {
                  fname.substring(i + 1) match {
                    case "plr" => im.Pilar
                    case "json" => im.JSON
                    case "sc" | "scala" => im.Scala
                    case _ => im.Auto
                  }
                }
              } else {
                option.inputMode
              }
            if (mode == im.Auto) {
              errPrintln(s"Cannot guess input mode for '$i' based on its file extension")
              outPrintln("Only .plr, .json, .sc, or .scala are recognized")
              ok = false
            }
            inputs = inputs :+(mode, f)
          } else {
            ok = false
            errPrintln(s"Input file '$i' does not exist")
          }
        }
      }
    }

    if (ok && !stdin && inputs.isEmpty) {
      printUsage = true
      ok = false
    }

    if (!ok) return printUsage

    val inputStrings =
      if (stdin)
        ivector((inputMode, io.Source.stdin.getLines().mkString(System.lineSeparator())))
      else
        inputs.map(f => (f._1, new String(Files.readAllBytes(f._2.toPath))))


    val modelOpts =
      inputStrings.zipWithIndex.map { t =>
        val ((mode, text), i) = t
        val modelOpt =
          mode match {
            case im.Pilar =>
              if (option.antlr4) {
                Builder(text, maxErrors)
              } else {
                FastParser(text, maxErrors)
              }
            case im.JSON =>
              try {
                Some(Pickling.unpickle[Model](text))
              } catch {
                case t: Throwable =>
                  errPrintln("Ill-formed JSON input")
                  None
              }
            case im.Scala =>
              try {
                Some(org.sireum.util.reflect.Reflection.eval[Model](text))
              } catch {
                case t: Throwable =>
                  errPrintln("Ill-formed Scala input")
                  None
              }
          }
        (modelOpt, i)
      }
    val models = modelOpts.toVector.sortBy(_._2).flatMap(_._1)

    if (models.isEmpty) {
      errPrintln("No result produced")
      return false
    }

    val model =
      if (models.size == 1) models.head
      else models.foldLeft(Model(Node.emptySeq))(_ + _)

    val result =
      outputMode match {
        case om.Pilar =>
          PrettyPrinter(model)
        case om.Scala =>
          s"""import org.sireum.pilar.ast._
             |${ProductUtil.toScalaString(model)}
         """.stripMargin
        case om.JSON =>
          Pickling.pickle(model)
      }
    outputFile match {
      case Some(f) =>
        Files.write(f.toPath, result.getBytes)
        outPrintln(s"Written result to ${option.outputFile.get}")
      case _ => outPrintln(result)
    }

    printUsage
  }
}
