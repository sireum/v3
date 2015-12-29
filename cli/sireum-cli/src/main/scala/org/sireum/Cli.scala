/*
Copyright (c) 2011-2015, Robby, Kansas State University
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

// @formatter:off
// This file was auto-generated from org.sireum.option.SireumOption

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

  def oPrintln(line: String): Unit = {
    Console.out.println(line)
    Console.out.flush()
  }

  def ePrintln(line: String): Unit = {
    Console.err.println(line)
    Console.err.flush()
  }
}

final class Cli(outPrintln: String => Unit, errPrintln: String => Unit) {

  import Cli._

  val modeSireumOptionMap: M = Vector(
    ("util", parseUtilOption _),
    ("java", parseJavaOption _),
    ("pilar", parsePilarOption _),
    ("logika", parseLogikaOption _)
  )
  val modeUtilOptionMap: M = Vector(
    ("option", parseUtilOptionOption _),
    ("reflect", parseUtilReflectOption _)
  )
  val modeUtilReflectOptionMap: M = Vector(
    ("cli", parseCliGenOption _),
    ("json", parseJsonGenOption _),
    ("rewriter", parseRewriterGenOption _)
  )
  val modeJavaOptionMap: M = Vector(
    ("translator", parseJavaBytecodeTranslatorOption _)
  )
  val modePilarOptionMap: M = Vector(
    ("parser", parsePilarParserOption _)
  )

  def parseSireumOption(args: CSeq[String],
                       index: Int,
                       o: Product = org.sireum.option.SireumOption()): Unit = {

    if (index < 0 || index >= args.length) {
      outPrintln(
        """
          |Sireum: A Software Analysis Platform (v3)
          |(c) 2011-2015, SAnToS Laboratory, Kansas State University
          |http://sireum.org
          |
          |Usage: sireum <mode>
          |
          |Available mode(s):
          |
          |java      Java tooling
          |logika    Logika Proof Checker
          |pilar     Pilar tooling
          |util      Utility Tools
        """.stripMargin.trim
      )
      return
    }
    select(args, index, modeSireumOptionMap, o)
  }

  def parseUtilOption(args: CSeq[String],
                       index: Int,
                       o: Product = org.sireum.option.UtilOption()): Unit = {

    if (index < 0 || index >= args.length) {
      outPrintln(
        """
          |Sireum Utility Tools
          |
          |Usage: sireum util <mode>
          |
          |Available mode(s):
          |
          |option     Option printer
          |reflect    Reflective tooling
        """.stripMargin.trim
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
        """
          |Sireum Reflective Tooling
          |
          |Usage: sireum util reflect <mode>
          |
          |Available mode(s):
          |
          |cli         CLI generator
          |json        JSON binding generator
          |rewriter    Rewriter generator
        """.stripMargin.trim
      )
      return
    }
    select(args, index, modeUtilReflectOptionMap, o)
  }

  def parseJavaOption(args: CSeq[String],
                       index: Int,
                       o: Product = org.sireum.option.JavaOption()): Unit = {

    if (index < 0 || index >= args.length) {
      outPrintln(
        """
          |Sireum Java Tooling
          |
          |Usage: sireum java <mode>
          |
          |Available mode(s):
          |
          |translator    Java bytecode translator
        """.stripMargin.trim
      )
      return
    }
    select(args, index, modeJavaOptionMap, o)
  }

  def parsePilarOption(args: CSeq[String],
                       index: Int,
                       o: Product = org.sireum.option.PilarOption()): Unit = {

    if (index < 0 || index >= args.length) {
      outPrintln(
        """
          |Pilar: Sireum's Intermediate Representation (IR)
          |
          |Usage: sireum pilar <mode>
          |
          |Available mode(s):
          |
          |parser    Pilar parser
        """.stripMargin.trim
      )
      return
    }
    select(args, index, modePilarOptionMap, o)
  }

  def parseUtilOptionOption(args: CSeq[String],
                             index: Int,
                             o: Product = org.sireum.option.UtilOptionOption()): Unit = {
    val option = o.asInstanceOf[org.sireum.option.UtilOptionOption]
    def printUsage(): Unit = {
      outPrintln(
        s"""
           |Sireum Option Printer
           |
           |Usage: sireum util option 
           |
           |
        """.stripMargin.trim
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
        case arg =>
          if (arg.startsWith("--") || arg.startsWith("-")) {
            errPrintln(s"Unrecognized option: '$arg'")
          }
          processingOptions = false
      }

      if (processingOptions) i += 1
    }


    if (foundHelp || org.Sireum.run(option, outPrintln, errPrintln)) {
      printUsage()
    }
  }

  def parseCliGenOption(args: CSeq[String],
                             index: Int,
                             o: Product = org.sireum.option.CliGenOption()): Unit = {
    val option = o.asInstanceOf[org.sireum.option.CliGenOption]
    def printUsage(): Unit = {
      outPrintln(
        s"""
           |Sireum Command-Line Interface (CLI) Generator
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
          i += 1
          args.at(i) match {
            case Some(arg) =>
              option.outputDir = org.sireum.util.some(arg)
            case _ =>
              errPrintln("Expecting a value for output dir")
              return
          }
        case "-l" | "--license-file" =>
          i += 1
          args.at(i) match {
            case Some(arg) =>
              option.licenseFile = org.sireum.util.some(arg)
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
           |-i, --imports         Class names of other JSON bindings or packages to import
           |                        Default: "${option.imports.mkString(",")}"
           |-l, --license-file    File containing license for output
           |-r, --roots           Class names of other roots to import
           |                        Default: "${option.roots.mkString(",")}"
           |-h, --help            Display usage information
        """.stripMargin.trim
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
          i += 1
          args.at(i) match {
            case Some(arg) =>
              option.outputDir = org.sireum.util.some(arg)
            case _ =>
              errPrintln("Expecting a value for output dir")
              return
          }
        case "-i" | "--imports" =>
          i += 1
          args.at(i) match {
            case Some(arg) => option.imports = arg.split(',').map(_.trim)
            case _ =>
              errPrintln("Expected a string value for imports")
          }
        case "-r" | "--roots" =>
          i += 1
          args.at(i) match {
            case Some(arg) => option.roots = arg.split(',').map(_.trim)
            case _ =>
              errPrintln("Expected a string value for roots")
          }
        case "-l" | "--license-file" =>
          i += 1
          args.at(i) match {
            case Some(arg) =>
              option.licenseFile = org.sireum.util.some(arg)
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
        s"""
           |Sireum Rewriter Generator
           |
           |Usage: sireum util reflect rewriter <root-class-name>
           |
           |Options:
           |-c, --class-name      Output fully-qualified class name
           |                        Default: ${option.className}
           |-d, --output-dir      Output directory
           |                      (If unspecified, use standard output stream)
           |-i, --imports         Class names of other rewriters to import
           |                        Default: "${option.imports.mkString(",")}"
           |-l, --license-file    File containing license for output
           |-h, --help            Display usage information
        """.stripMargin.trim
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
          i += 1
          args.at(i) match {
            case Some(arg) =>
              option.outputDir = org.sireum.util.some(arg)
            case _ =>
              errPrintln("Expecting a value for output dir")
              return
          }
        case "-i" | "--imports" =>
          i += 1
          args.at(i) match {
            case Some(arg) => option.imports = arg.split(',').map(_.trim)
            case _ =>
              errPrintln("Expected a string value for imports")
          }
        case "-l" | "--license-file" =>
          i += 1
          args.at(i) match {
            case Some(arg) =>
              option.licenseFile = org.sireum.util.some(arg)
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

  def parseJavaBytecodeTranslatorOption(args: CSeq[String],
                             index: Int,
                             o: Product = org.sireum.option.JavaBytecodeTranslatorOption()): Unit = {
    val option = o.asInstanceOf[org.sireum.option.JavaBytecodeTranslatorOption]
    def printUsage(): Unit = {
      outPrintln(
        s"""
           |Sireum Java Bytecode Translator
           |
           |Usage: sireum java translator <{class-name,file.{class,zip,jar},dir-path}-1> ... <{class-name,file.{class,zip,jar},dir-path}-N>
           |
           |Options:
           |-v, --verbose    Verbose mode
           |-h, --help       Display usage information
        """.stripMargin.trim
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
        case "-v" | "--verbose" =>
          option.verbose = true
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

    if (foundHelp || org.sireum.java.translator.JavaBytecodeTranslator.run(option, outPrintln, errPrintln)) {
      printUsage()
    }
  }

  def parsePilarParserOption(args: CSeq[String],
                             index: Int,
                             o: Product = org.sireum.option.PilarParserOption()): Unit = {
    val option = o.asInstanceOf[org.sireum.option.PilarParserOption]
    def printUsage(): Unit = {
      outPrintln(
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
           | -i, --input-mode        Input mode { auto, pilar, json, scala }
           |                           Default: ${option.inputMode}
           |-in, --standard-input    Use standard input stream
           | -o, --output-mode       Output mode { pilar, json, scala }
           |                           Default: ${option.outputMode}
           | -h, --help              Display usage information
        """.stripMargin.trim
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
          i += 1
          args.at(i) match {
            case Some(arg) =>
              option.outputFile = org.sireum.util.some(arg)
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

  def parseLogikaOption(args: CSeq[String],
                             index: Int,
                             o: Product = org.sireum.option.LogikaOption()): Unit = {
    val option = o.asInstanceOf[org.sireum.option.LogikaOption]
    def printUsage(): Unit = {
      outPrintln(
        s"""
           |Sireum Logika -- A Natural Deduction Proof Checker
           |... for Propositional, Predicate, and Programming Logic
           |
           |Usage: sireum logika <{file.txt, file.scala}>
           |
           |Options:
           |-a, --auto       Enable auto in programming logic proof step justification
           |-s, --sequent    Sequent matching the input file's
           |-h, --help       Display usage information
        """.stripMargin.trim
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
        case "-s" | "--sequent" =>
          i += 1
          args.at(i) match {
            case Some(arg) =>
              option.sequent = org.sireum.util.some(arg)
            case _ =>
              errPrintln("Expecting a value for sequent")
              return
          }
        case "-a" | "--auto" =>
          option.auto = true
        case arg =>
          if (arg.startsWith("--") || arg.startsWith("-")) {
            errPrintln(s"Unrecognized option: '$arg'")
          }
          processingOptions = false
      }

      if (processingOptions) i += 1
    }

    if (i < len) {
      option.input = args(i)
      i += 1
    } else {
      printUsage()
      outPrintln("")
      errPrintln("Expected a value for input")
      return
    }

    if (foundHelp || org.sireum.logika.ProofChecker.run(option, outPrintln, errPrintln)) {
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