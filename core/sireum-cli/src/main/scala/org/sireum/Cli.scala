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

// This file was auto-generated from SireumOption

package org.sireum

object Cli {
  private type CSeq[T] = scala.collection.Seq[T]
  private type M = Vector[(String, (CSeq[String], Int, Product) => Unit)]

  final val topCommand = "sireum"

  final def main(args: Array[String]): Unit = {
    new Cli(oPrintln, ePrintln).parseSireumOption(args, 0)
  }

  private implicit class At[T](val a: CSeq[T]) extends AnyVal {
    def at(i: Int): Option[T] =
      if (i < a.length) Some(a(i)) else None
  }

  private def oPrintln(line: String): Unit = {
    Console.out.println(line)
    Console.out.flush()
  }

  private def ePrintln(line: String): Unit = {
    Console.err.println(line)
    Console.err.flush()
  }
}

final class Cli(outPrintln: String => Unit, errPrintln: String => Unit) {

  import Cli._

  val modeSireumOptionMap: M = Vector(
    ("pilar", parsePilarOption _),
    ("util", parseUtilOption _)
  )
  val modePilarOptionMap: M = Vector(
    ("parser", parsePilarParserOption _)
  )
  val modeUtilOptionMap: M = Vector(
    ("reflect", parseUtilReflectOption _)
  )
  val modeUtilReflectOptionMap: M = Vector(
    ("cli", parseCliGenOption _),
    ("json", parseJsonGenOption _),
    ("rewriter", parseRewriterGenOption _)
  )

  def parseSireumOption(args: CSeq[String],
                        index: Int,
                        o: Product = org.sireum.option.SireumOption()): Unit = {

    if (index < 0 || index >= args.length) {
      outPrintln(
        // @formatter:off
        """
          |Sireum: A Software Analysis Platform (v3)
          |(c) 2011-2015, SAnToS Laboratory, Kansas State University
          |http://sireum.org
          |
          |Usage: sireum <mode>
          |
          |Available mode(s):
          |
          |pilar    Pilar tooling
          |util     Utility tooling
        """.stripMargin.trim
        // @formatter:on
      )
      return
    }
    select(args, index, modeSireumOptionMap, o)
  }

  def parsePilarOption(args: CSeq[String],
                       index: Int,
                       o: Product = org.sireum.option.PilarOption()): Unit = {

    if (index < 0 || index >= args.length) {
      outPrintln(
        // @formatter:off
        """
          |Pilar: Sireum's Intermediate Representation (IR)
          |
          |Usage: sireum pilar <mode>
          |
          |Available mode(s):
          |
          |parser    Pilar parser
        """.stripMargin.trim
        // @formatter:on
      )
      return
    }
    select(args, index, modePilarOptionMap, o)
  }

  def parseUtilOption(args: CSeq[String],
                      index: Int,
                      o: Product = org.sireum.option.UtilOption()): Unit = {

    if (index < 0 || index >= args.length) {
      outPrintln(
        // @formatter:off
        """
          |Sireum Utility Tooling
          |
          |Usage: sireum util <mode>
          |
          |Available mode(s):
          |
          |reflect    Reflective tooling
        """.stripMargin.trim
        // @formatter:on
      )
      return
    }
    select(args, index, modeUtilOptionMap, o)
  }

  def parseUtilReflectOption(args: CSeq[String],
                             index: Int,
                             o: Product = org.sireum.option.UtilReflectOption()): Unit = {

    if (index < 0 || index >= args.length) {
      outPrintln(
        // @formatter:off
        """
          |Sireum Reflective Tooling
          |
          |Usage: sireum util reflect <mode>
          |
          |Available mode(s):
          |
          |cli         CLI Generator
          |json        JSON Binding Generator
          |rewriter    Case Class Rewriter Generator
        """.stripMargin.trim
        // @formatter:on
      )
      return
    }
    select(args, index, modeUtilReflectOptionMap, o)
  }

  def parsePilarParserOption(args: CSeq[String],
                             index: Int,
                             o: Product = org.sireum.option.PilarParserOption()): Unit = {
    val option = o.asInstanceOf[org.sireum.option.PilarParserOption]
    def printUsage(): Unit = {
      outPrintln(
        // @formatter:off
        s"""
           |Pilar Parser
           |... and pretty printer and JSON de/serializer
           |
           |Usage: sireum pilar parser <file-1> ... <file-N>
           |
           |Options:
           | -a, --antlr4            Use ANTLR4 Pilar parser instead of hand-written one
           | -e, --max-errors        Maximum number of errors found before parsing stop
           |                           Default: ${option.maxErrors}
           | -f, --output-file       Output file
           |                         (if unspecified, use standard output stream)
           | -i, --input-mode        Input mode
           |                           Default: ${option.inputMode}
           |-in, --standard-input    Use standard input stream
           | -o, --output-mode       Output mode
           |                           Default: ${option.outputMode}
           | -h, --help              Display usage information
        """.stripMargin.trim
        // @formatter:on
      )
    }
    val len = args.length
    var foundHelp = false

    var i = index
    var processingOptions = true
    while (i < len && processingOptions) {
      args(i) match {
        case "-h" | "--help" =>
          foundHelp = true
        case "-in" | "--standard-input" =>
          option.standardInput = true
        case "-f" | "--output-file" =>
          args.at(i) match {
            case Some(arg) =>
              option.outputFile = org.sireum.util.SomeBean(arg)
            case _ =>
              errPrintln("Expecting a value for output file")
              return
          }
        case "-i" | "--input-mode" =>
          i += 1
          args.at(i) match {
            case Some("auto") => option.inputMode = "auto"
            case Some("pilar") => option.inputMode = "pilar"
            case Some("json") => option.inputMode = "json"
            case Some("scala") => option.inputMode = "scala"
            case Some(arg) =>
              errPrintln(s"Only either { auto, pilar, json, scala } is allowed for input mode instead of '$arg'")
              return
            case None =>
              errPrintln("Expected either { auto, pilar, json, scala } for input mode")
              return
          }
        case "-o" | "--output-mode" =>
          i += 1
          args.at(i) match {
            case Some("pilar") => option.outputMode = "pilar"
            case Some("json") => option.outputMode = "json"
            case Some("scala") => option.outputMode = "scala"
            case Some(arg) =>
              errPrintln(s"Only either { pilar, json, scala } is allowed for output mode instead of '$arg'")
              return
            case None =>
              errPrintln("Expected either { pilar, json, scala } for output mode")
              return
          }
        case "-a" | "--antlr4" =>
          option.antlr4 = true
        case "-e" | "--max-errors" =>
          i += 1
          args.at(i) match {
            case Some(arg) =>
              try {
                option.maxErrors = arg.toInt
              } catch {
                case t: Throwable =>
                  errPrintln(s"Invalid integer for max errors: '$arg'")
                  return
              }
            case _ =>
              errPrintln("Expected an integer value for max errors")
          }
        case arg =>
          if (arg.startsWith("--") || arg.startsWith("-")) {
            errPrintln(s"Unrecognized option: '$arg'")
          }
          processingOptions = false
      }

      if (processingOptions) i += 1
    }

    while (i < len) {
      option.inputs = option.inputs :+ args(i)
      i += 1
    }

    if (foundHelp || org.sireum.pilar.parser.Parser.run(option, outPrintln, errPrintln)) {
      printUsage()
    }
  }

  def parseCliGenOption(args: CSeq[String],
                        index: Int,
                        o: Product = org.sireum.option.CliGenOption()): Unit = {
    val option = o.asInstanceOf[org.sireum.option.CliGenOption]
    def printUsage(): Unit = {
      outPrintln(
        // @formatter:off
        s"""
           |Sireum CLI Generator
           |
           |Usage: sireum util reflect cli <root-class-name>
           |
           |Options:
           |-c, --class-name      Output fully-qualified class name
           |                        Default: ${option.className}
           |-d, --output-dir      Output directory
           |                      (If unspecified, use standard output stream)
           |-l, --license-file    File containing license for output
           |-h, --help            Display usage information
        """.stripMargin.trim
        // @formatter:on
      )
    }
    val len = args.length
    var foundHelp = false

    var i = index
    var processingOptions = true
    while (i < len && processingOptions) {
      args(i) match {
        case "-h" | "--help" =>
          foundHelp = true
        case "-c" | "--class-name" =>
          i += 1
          args.at(i) match {
            case Some(arg) => option.className = arg
            case _ =>
              errPrintln("Expected a string value for class name")
          }
        case "-d" | "--output-dir" =>
          args.at(i) match {
            case Some(arg) =>
              option.outputDir = org.sireum.util.SomeBean(arg)
            case _ =>
              errPrintln("Expecting a value for output dir")
              return
          }
        case "-l" | "--license-file" =>
          args.at(i) match {
            case Some(arg) =>
              option.licenseFile = org.sireum.util.SomeBean(arg)
            case _ =>
              errPrintln("Expecting a value for license file")
              return
          }
        case arg =>
          if (arg.startsWith("--") || arg.startsWith("-")) {
            errPrintln(s"Unrecognized option: '$arg'")
          }
          processingOptions = false
      }

      if (processingOptions) i += 1
    }

    if (i < len) {
      option.rootClassName = args(i)
      i += 1
    } else {
      printUsage()
      outPrintln("")
      errPrintln("Expected a value for root class name")
      return
    }

    if (foundHelp || org.sireum.util.reflect.ReflectGen.run(option, outPrintln, errPrintln)) {
      printUsage()
    }
  }

  def parseJsonGenOption(args: CSeq[String],
                         index: Int,
                         o: Product = org.sireum.option.JsonGenOption()): Unit = {
    val option = o.asInstanceOf[org.sireum.option.JsonGenOption]
    def printUsage(): Unit = {
      outPrintln(
        // @formatter:off
        s"""
           |Sireum JSON Binding Generator
           |
           |Usage: sireum util reflect json <root-class-name>
           |
           |Options:
           |-c, --class-name      Output fully-qualified class name
           |                        Default: ${option.className}
           |-d, --output-dir      Output directory
           |                      (If unspecified, use standard output stream)
           |-l, --license-file    File containing license for output
           |-h, --help            Display usage information
        """.stripMargin.trim
        // @formatter:on
      )
    }
    val len = args.length
    var foundHelp = false

    var i = index
    var processingOptions = true
    while (i < len && processingOptions) {
      args(i) match {
        case "-h" | "--help" =>
          foundHelp = true
        case "-c" | "--class-name" =>
          i += 1
          args.at(i) match {
            case Some(arg) => option.className = arg
            case _ =>
              errPrintln("Expected a string value for class name")
          }
        case "-d" | "--output-dir" =>
          args.at(i) match {
            case Some(arg) =>
              option.outputDir = org.sireum.util.SomeBean(arg)
            case _ =>
              errPrintln("Expecting a value for output dir")
              return
          }
        case "-l" | "--license-file" =>
          args.at(i) match {
            case Some(arg) =>
              option.licenseFile = org.sireum.util.SomeBean(arg)
            case _ =>
              errPrintln("Expecting a value for license file")
              return
          }
        case arg =>
          if (arg.startsWith("--") || arg.startsWith("-")) {
            errPrintln(s"Unrecognized option: '$arg'")
          }
          processingOptions = false
      }

      if (processingOptions) i += 1
    }

    if (i < len) {
      option.rootClassName = args(i)
      i += 1
    } else {
      printUsage()
      outPrintln("")
      errPrintln("Expected a value for root class name")
      return
    }

    if (foundHelp || org.sireum.util.reflect.ReflectGen.run(option, outPrintln, errPrintln)) {
      printUsage()
    }
  }

  def parseRewriterGenOption(args: CSeq[String],
                             index: Int,
                             o: Product = org.sireum.option.RewriterGenOption()): Unit = {
    val option = o.asInstanceOf[org.sireum.option.RewriterGenOption]
    def printUsage(): Unit = {
      outPrintln(
        // @formatter:off
        s"""
           |Sireum Case Class Rewriter Generator
           |
           |Usage: sireum util reflect rewriter <root-class-name>
           |
           |Options:
           |-c, --class-name      Output fully-qualified class name
           |                        Default: ${option.className}
           |-d, --output-dir      Output directory
           |                      (If unspecified, use standard output stream)
           |-l, --license-file    File containing license for output
           |-h, --help            Display usage information
        """.stripMargin.trim
        // @formatter:on
      )
    }
    val len = args.length
    var foundHelp = false

    var i = index
    var processingOptions = true
    while (i < len && processingOptions) {
      args(i) match {
        case "-h" | "--help" =>
          foundHelp = true
        case "-c" | "--class-name" =>
          i += 1
          args.at(i) match {
            case Some(arg) => option.className = arg
            case _ =>
              errPrintln("Expected a string value for class name")
          }
        case "-d" | "--output-dir" =>
          args.at(i) match {
            case Some(arg) =>
              option.outputDir = org.sireum.util.SomeBean(arg)
            case _ =>
              errPrintln("Expecting a value for output dir")
              return
          }
        case "-l" | "--license-file" =>
          args.at(i) match {
            case Some(arg) =>
              option.licenseFile = org.sireum.util.SomeBean(arg)
            case _ =>
              errPrintln("Expecting a value for license file")
              return
          }
        case arg =>
          if (arg.startsWith("--") || arg.startsWith("-")) {
            errPrintln(s"Unrecognized option: '$arg'")
          }
          processingOptions = false
      }

      if (processingOptions) i += 1
    }

    if (i < len) {
      option.rootClassName = args(i)
      i += 1
    } else {
      printUsage()
      outPrintln("")
      errPrintln("Expected a value for root class name")
      return
    }

    if (foundHelp || org.sireum.util.reflect.ReflectGen.run(option, outPrintln, errPrintln)) {
      printUsage()
    }
  }

  private def select(args: CSeq[String], index: Int, m: M, o: Product): Unit = {
    val arg = args(index)
    m.indexWhere(_._1 == arg) match {
      case -1 =>
        val selections = m.zipWithIndex.filter(_._1._1.startsWith(arg))
        selections.size match {
          case 0 =>
            errPrintln(s"$arg is not a mode for: sireum ${args.slice(0, index).mkString(" ")}")
          case 1 =>
            val p = o.productElement(selections.head._2).asInstanceOf[Product]
            selections.head._1._2(args, index + 1, p)
          case _ =>
            outPrintln("Did you mean one of the following modes?")
            for ((mode, _) <- selections) {
              outPrintln(mode._1)
            }
        }
      case i =>
        m(i)._2(args, index + 1, o.productElement(i).asInstanceOf[Product])
    }
  }
}
