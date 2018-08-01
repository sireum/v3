// #Sireum
// @formatter:off

/*
 Copyright (c) 2018, Robby, Kansas State University
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

// This file is auto-generated from CliConfig.sc

package org.sireum.cli

import org.sireum._

object Cli {

  @datatype trait SireumOption

  @datatype class HelpOption extends SireumOption

  @datatype class LogikaOption(
    help: String,
    args: ISZ[String],
    formula: Option[String],
    server: B,
    auto: B,
    bitwidth: Z,
    c: Option[String],
    compare: B,
    last: B,
    run: B,
    sat: B,
    symexe: B,
    timeout: Z,
    ascii: B,
    unicode: B
  ) extends SireumOption

  @datatype class CligenOption(
    help: String,
    args: ISZ[String],
    packageName: ISZ[String],
    name: Option[String],
    width: ISZ[Z],
    license: Option[String],
    outputDir: Option[String]
  ) extends SireumOption

  @enum object SerializerMode {
    'Json
    'Msgpack
  }

  @datatype class SergenOption(
    help: String,
    args: ISZ[String],
    modes: ISZ[SerializerMode.Type],
    packageName: ISZ[String],
    name: Option[String],
    license: Option[String],
    outputDir: Option[String]
  ) extends SireumOption

  @enum object TransformerMode {
    'Immutable
    'Mutable
  }

  @datatype class TransgenOption(
    help: String,
    args: ISZ[String],
    modes: ISZ[TransformerMode.Type],
    name: Option[String],
    license: Option[String],
    outputDir: Option[String]
  ) extends SireumOption

  @enum object Ipcmech {
    'MessageQueue
    'SharedMemory
  }

  @datatype class ArsitOption(
    help: String,
    args: ISZ[String],
    json: B,
    inputFile: Option[String],
    outputDir: Option[String],
    packageName: Option[String],
    noart: B,
    bless: B,
    genTrans: B,
    ipc: Ipcmech.Type
  ) extends SireumOption

  @datatype class AwasOption(
    help: String,
    args: ISZ[String]
  ) extends SireumOption

  @datatype class SlangTipeOption(
    help: String,
    args: ISZ[String],
    sourcepath: ISZ[String],
    outline: B,
    force: ISZ[String],
    verbose: B,
    save: Option[String],
    load: Option[String],
    gzip: B
  ) extends SireumOption
}

import Cli._

@record class Cli(pathSep: C) {

  def parseSireum(args: ISZ[String], i: Z): Option[SireumOption] = {
    if (i >= args.size) {
      println(
        st"""Sireum: A Software Analysis Platform (v3)
            |(c) 2018, SAnToS Laboratory, Kansas State University
            |
            |Available modes:
            |logika                   Logika verifier and proof checker
            |tools                    Utility tools""".render
      )
      return Some(HelpOption())
    }
    val opt = select("sireum", args, i, ISZ("logika", "tools", "x"))
    opt match {
      case Some(string"logika") => parseLogika(args, i + 1)
      case Some(string"tools") => parseTools(args, i + 1)
      case Some(string"x") => parseX(args, i + 1)
      case _ => return None()
    }
  }

  def parseLogika(args: ISZ[String], i: Z): Option[SireumOption] = {
    val help =
      st"""Sireum/Logika:
          |A Program Verifier and A Natural Deduction Proof Checker
          |... for Propositional, Predicate, and Programming Logics
          |
          |Usage: <option>* <file>+
          |
          |Available Options:
          |-f, --formula            Formula/sequent matching the truth table/logic input
          |                           file's (expects a string)
          |    --server             Enable server mode
          |-h, --help               Display this information
          |
          |Programming Logic Options:
          |-a, --auto               Enable auto mode
          |-b, --bitwidth           Default integer bit-width for symbolic execution &
          |                           translation (expects one of { 0, 8, 16, 32, 64 })
          |    --c                  File/directory path for C translation (expects a path)
          |    --compare            Compare well-formed input program files (sans
          |                           contracts/prints)
          |-l, --last               Check last program only
          |    --run                Run input program file(s)
          |    --sat                Enable sat checking of facts and contracts
          |-x, --symexe             Enable symbolic execution
          |-t, --timeout            Timeout for algebra and auto (in milliseconds)
          |                           (expects an integer; default is 1000)
          |
          |Symbol Conversion Options:
          |    --ascii              Convert to ASCII
          |    --unicode            Convert to Unicode""".render

    var formula: Option[String] = None[String]()
    var server: B = false
    var auto: B = false
    var bitwidth: Z = 0
    var c: Option[String] = None[String]()
    var compare: B = false
    var last: B = false
    var run: B = false
    var sat: B = false
    var symexe: B = false
    var timeout: Z = 1000
    var ascii: B = false
    var unicode: B = false
    var j = i
    var isOption = T
    while (j < args.size && isOption) {
      val arg = args(j)
      if (ops.StringOps(arg).first == '-') {
        if (args(j) == "-h" || args(j) == "--help") {
          println(help)
          return Some(HelpOption())
        } else if (arg == "-f" || arg == "--formula") {
           val o: Option[Option[String]] = parseString(args, j + 1)
           o match {
             case Some(v) => formula = v
             case _ => return None()
           }
         } else if (arg == "--server") {
           val o: Option[B] = { j = j - 1; Some(!server) }
           o match {
             case Some(v) => server = v
             case _ => return None()
           }
         } else if (arg == "-a" || arg == "--auto") {
           val o: Option[B] = { j = j - 1; Some(!auto) }
           o match {
             case Some(v) => auto = v
             case _ => return None()
           }
         } else if (arg == "-b" || arg == "--bitwidth") {
           val o: Option[Z] = parseNumChoice(args, j + 1, ISZ(z"0", z"8", z"16", z"32", z"64"))
           o match {
             case Some(v) => bitwidth = v
             case _ => return None()
           }
         } else if (arg == "--c") {
           val o: Option[Option[String]] = parsePath(args, j + 1)
           o match {
             case Some(v) => c = v
             case _ => return None()
           }
         } else if (arg == "--compare") {
           val o: Option[B] = { j = j - 1; Some(!compare) }
           o match {
             case Some(v) => compare = v
             case _ => return None()
           }
         } else if (arg == "-l" || arg == "--last") {
           val o: Option[B] = { j = j - 1; Some(!last) }
           o match {
             case Some(v) => last = v
             case _ => return None()
           }
         } else if (arg == "--run") {
           val o: Option[B] = { j = j - 1; Some(!run) }
           o match {
             case Some(v) => run = v
             case _ => return None()
           }
         } else if (arg == "--sat") {
           val o: Option[B] = { j = j - 1; Some(!sat) }
           o match {
             case Some(v) => sat = v
             case _ => return None()
           }
         } else if (arg == "-x" || arg == "--symexe") {
           val o: Option[B] = { j = j - 1; Some(!symexe) }
           o match {
             case Some(v) => symexe = v
             case _ => return None()
           }
         } else if (arg == "-t" || arg == "--timeout") {
           val o: Option[Z] = parseNum(args, j + 1, Some(1000), None())
           o match {
             case Some(v) => timeout = v
             case _ => return None()
           }
         } else if (arg == "--ascii") {
           val o: Option[B] = { j = j - 1; Some(!ascii) }
           o match {
             case Some(v) => ascii = v
             case _ => return None()
           }
         } else if (arg == "--unicode") {
           val o: Option[B] = { j = j - 1; Some(!unicode) }
           o match {
             case Some(v) => unicode = v
             case _ => return None()
           }
         } else {
          eprintln(s"Unrecognized option '$arg'.")
          return None()
        }
        j = j + 2
      } else {
        isOption = F
      }
    }
    return Some(LogikaOption(help, parseArguments(args, j), formula, server, auto, bitwidth, c, compare, last, run, sat, symexe, timeout, ascii, unicode))
  }

  def parseTools(args: ISZ[String], i: Z): Option[SireumOption] = {
    if (i >= args.size) {
      println(
        st"""Sireum Utility Tools
            |
            |Available modes:
            |cligen                   Command-line interface (CLI) generator
            |sergen                   De/Serializer generator
            |transgen                 Transformer (visitor/rewriter) generator""".render
      )
      return Some(HelpOption())
    }
    val opt = select("tools", args, i, ISZ("cligen", "sergen", "transgen"))
    opt match {
      case Some(string"cligen") => parseCligen(args, i + 1)
      case Some(string"sergen") => parseSergen(args, i + 1)
      case Some(string"transgen") => parseTransgen(args, i + 1)
      case _ => return None()
    }
  }

  def parseCligen(args: ISZ[String], i: Z): Option[SireumOption] = {
    val help =
      st"""Sireum CLI Generator
          |
          |Usage: <option>* <config-file>
          |
          |Available Options:
          |-p, --package            Package name for the CLI processor (expects a string
          |                           separated by "."; default is "cli")
          |-n, --name               Type simple name for the CLI @record class processor
          |                           (expects a string)
          |-w, --width              First (key) column (default: 25) and second column
          |                           (default: 55) max width (expects an int-list
          |                           separated by ',')
          |-l, --license            License file to be inserted in the file header
          |                           (expects a path)
          |-o, --output-dir         Output directory for the generated CLI Slang file
          |                           (expects a path; default is ".")
          |-h, --help               Display this information""".render

    var packageName: ISZ[String] = ISZ("cli")
    var name: Option[String] = Some("Cli")
    var width: ISZ[Z] = ISZ()
    var license: Option[String] = None[String]()
    var outputDir: Option[String] = Some(".")
    var j = i
    var isOption = T
    while (j < args.size && isOption) {
      val arg = args(j)
      if (ops.StringOps(arg).first == '-') {
        if (args(j) == "-h" || args(j) == "--help") {
          println(help)
          return Some(HelpOption())
        } else if (arg == "-p" || arg == "--package") {
           val o: Option[ISZ[String]] = parseStrings(args, j + 1, '.')
           o match {
             case Some(v) => packageName = v
             case _ => return None()
           }
         } else if (arg == "-n" || arg == "--name") {
           val o: Option[Option[String]] = parseString(args, j + 1)
           o match {
             case Some(v) => name = v
             case _ => return None()
           }
         } else if (arg == "-w" || arg == "--width") {
           val o: Option[ISZ[Z]] = parseNums(args, j + 1, ',', Some(0), None())
           o match {
             case Some(v) => width = v
             case _ => return None()
           }
         } else if (arg == "-l" || arg == "--license") {
           val o: Option[Option[String]] = parsePath(args, j + 1)
           o match {
             case Some(v) => license = v
             case _ => return None()
           }
         } else if (arg == "-o" || arg == "--output-dir") {
           val o: Option[Option[String]] = parsePath(args, j + 1)
           o match {
             case Some(v) => outputDir = v
             case _ => return None()
           }
         } else {
          eprintln(s"Unrecognized option '$arg'.")
          return None()
        }
        j = j + 2
      } else {
        isOption = F
      }
    }
    return Some(CligenOption(help, parseArguments(args, j), packageName, name, width, license, outputDir))
  }

  def parseSerializerModeH(arg: String): Option[SerializerMode.Type] = {
    arg.native match {
      case "json" => return Some(SerializerMode.Json)
      case "msgpack" => return Some(SerializerMode.Msgpack)
      case s =>
        eprintln(s"Expecting one of the following: { json, msgpack }, but found '$s'.")
        return None()
    }
  }

  def parseSerializerMode(args: ISZ[String], i: Z): Option[SerializerMode.Type] = {
    if (i >= args.size) {
      eprintln("Expecting one of the following: { json, msgpack }, but none found.")
      return None()
    }
    val r = parseSerializerModeH(args(i))
    return r
  }

  def parseSerializerModes(args: ISZ[String], i: Z): Option[ISZ[SerializerMode.Type]] = {
    val tokensOpt = tokenize(args, i, "SerializerMode", ',', T)
    if (tokensOpt.isEmpty) {
      return None()
    }
    var r = ISZ[SerializerMode.Type]()
    for (token <- tokensOpt.get) {
      val e = parseSerializerModeH(token)
      e match {
        case Some(v) => r = r :+ v
        case _ => return None()
      }
    }
    return Some(r)
  }

  def parseSergen(args: ISZ[String], i: Z): Option[SireumOption] = {
    val help =
      st"""Sireum De/Serializer Generator
          |
          |Usage: <option>* <slang-file>
          |
          |Available Options:
          |-m, --modes              De/serializer mode (expects one or more of { json,
          |                           msgpack }; default: json)
          |-p, --package            Type simple name for the de/serializers (default:
          |                           "Json" or "MsgPack") (expects a string separated by
          |                           ".")
          |-n, --name               Type simple name for the de/serializers (default:
          |                           "Json" or "MsgPack") (expects a string)
          |-l, --license            License file to be inserted in the file header
          |                           (expects a path)
          |-o, --output-dir         Output directory for the generated de/serializer Slang
          |                           files (expects a path; default is ".")
          |-h, --help               Display this information""".render

    var modes: ISZ[SerializerMode.Type] = ISZ(SerializerMode.Json)
    var packageName: ISZ[String] = ISZ[String]()
    var name: Option[String] = None[String]()
    var license: Option[String] = None[String]()
    var outputDir: Option[String] = Some(".")
    var j = i
    var isOption = T
    while (j < args.size && isOption) {
      val arg = args(j)
      if (ops.StringOps(arg).first == '-') {
        if (args(j) == "-h" || args(j) == "--help") {
          println(help)
          return Some(HelpOption())
        } else if (arg == "-m" || arg == "--modes") {
           val o: Option[ISZ[SerializerMode.Type]] = parseSerializerModes(args, j + 1)
           o match {
             case Some(v) => modes = v
             case _ => return None()
           }
         } else if (arg == "-p" || arg == "--package") {
           val o: Option[ISZ[String]] = parseStrings(args, j + 1, '.')
           o match {
             case Some(v) => packageName = v
             case _ => return None()
           }
         } else if (arg == "-n" || arg == "--name") {
           val o: Option[Option[String]] = parseString(args, j + 1)
           o match {
             case Some(v) => name = v
             case _ => return None()
           }
         } else if (arg == "-l" || arg == "--license") {
           val o: Option[Option[String]] = parsePath(args, j + 1)
           o match {
             case Some(v) => license = v
             case _ => return None()
           }
         } else if (arg == "-o" || arg == "--output-dir") {
           val o: Option[Option[String]] = parsePath(args, j + 1)
           o match {
             case Some(v) => outputDir = v
             case _ => return None()
           }
         } else {
          eprintln(s"Unrecognized option '$arg'.")
          return None()
        }
        j = j + 2
      } else {
        isOption = F
      }
    }
    return Some(SergenOption(help, parseArguments(args, j), modes, packageName, name, license, outputDir))
  }

  def parseTransformerModeH(arg: String): Option[TransformerMode.Type] = {
    arg.native match {
      case "immutable" => return Some(TransformerMode.Immutable)
      case "mutable" => return Some(TransformerMode.Mutable)
      case s =>
        eprintln(s"Expecting one of the following: { immutable, mutable }, but found '$s'.")
        return None()
    }
  }

  def parseTransformerMode(args: ISZ[String], i: Z): Option[TransformerMode.Type] = {
    if (i >= args.size) {
      eprintln("Expecting one of the following: { immutable, mutable }, but none found.")
      return None()
    }
    val r = parseTransformerModeH(args(i))
    return r
  }

  def parseTransformerModes(args: ISZ[String], i: Z): Option[ISZ[TransformerMode.Type]] = {
    val tokensOpt = tokenize(args, i, "TransformerMode", ',', T)
    if (tokensOpt.isEmpty) {
      return None()
    }
    var r = ISZ[TransformerMode.Type]()
    for (token <- tokensOpt.get) {
      val e = parseTransformerModeH(token)
      e match {
        case Some(v) => r = r :+ v
        case _ => return None()
      }
    }
    return Some(r)
  }

  def parseTransgen(args: ISZ[String], i: Z): Option[SireumOption] = {
    val help =
      st"""Sireum Transformer Generator
          |
          |Usage: <option>* <slang-file>
          |
          |Available Options:
          |-m, --modes              Transformer mode (expects one or more of { immutable,
          |                           mutable }; default: immutable)
          |-n, --name               Type simple name for the transformers (default:
          |                           "Transformer" or "MTransformer") (expects a string)
          |-l, --license            License file to be inserted in the file header
          |                           (expects a path)
          |-o, --output-dir         Output directory for the generated transformer Slang
          |                           files (expects a path; default is ".")
          |-h, --help               Display this information""".render

    var modes: ISZ[TransformerMode.Type] = ISZ(TransformerMode.Immutable)
    var name: Option[String] = None[String]()
    var license: Option[String] = None[String]()
    var outputDir: Option[String] = Some(".")
    var j = i
    var isOption = T
    while (j < args.size && isOption) {
      val arg = args(j)
      if (ops.StringOps(arg).first == '-') {
        if (args(j) == "-h" || args(j) == "--help") {
          println(help)
          return Some(HelpOption())
        } else if (arg == "-m" || arg == "--modes") {
           val o: Option[ISZ[TransformerMode.Type]] = parseTransformerModes(args, j + 1)
           o match {
             case Some(v) => modes = v
             case _ => return None()
           }
         } else if (arg == "-n" || arg == "--name") {
           val o: Option[Option[String]] = parseString(args, j + 1)
           o match {
             case Some(v) => name = v
             case _ => return None()
           }
         } else if (arg == "-l" || arg == "--license") {
           val o: Option[Option[String]] = parsePath(args, j + 1)
           o match {
             case Some(v) => license = v
             case _ => return None()
           }
         } else if (arg == "-o" || arg == "--output-dir") {
           val o: Option[Option[String]] = parsePath(args, j + 1)
           o match {
             case Some(v) => outputDir = v
             case _ => return None()
           }
         } else {
          eprintln(s"Unrecognized option '$arg'.")
          return None()
        }
        j = j + 2
      } else {
        isOption = F
      }
    }
    return Some(TransgenOption(help, parseArguments(args, j), modes, name, license, outputDir))
  }

  def parseX(args: ISZ[String], i: Z): Option[SireumOption] = {
    if (i >= args.size) {
      println(
        st"""Sireum Experimental Tools
            |
            |Available modes:
            |aadl                     AADL Tools
            |slang                    Slang toolbox""".render
      )
      return Some(HelpOption())
    }
    val opt = select("x", args, i, ISZ("aadl", "slang"))
    opt match {
      case Some(string"aadl") => parseAadl(args, i + 1)
      case Some(string"slang") => parseSlang(args, i + 1)
      case _ => return None()
    }
  }

  def parseAadl(args: ISZ[String], i: Z): Option[SireumOption] = {
    if (i >= args.size) {
      println(
        st"""Sireum AADL Tools
            |
            |Available modes:
            |arsit                    Generate Slang project from Aadl IR
            |awas                     Generate Awas from AADL model""".render
      )
      return Some(HelpOption())
    }
    val opt = select("aadl", args, i, ISZ("arsit", "awas"))
    opt match {
      case Some(string"arsit") => parseArsit(args, i + 1)
      case Some(string"awas") => parseAwas(args, i + 1)
      case _ => return None()
    }
  }

  def parseIpcmechH(arg: String): Option[Ipcmech.Type] = {
    arg.native match {
      case "MessageQueue" => return Some(Ipcmech.MessageQueue)
      case "SharedMemory" => return Some(Ipcmech.SharedMemory)
      case s =>
        eprintln(s"Expecting one of the following: { MessageQueue, SharedMemory }, but found '$s'.")
        return None()
    }
  }

  def parseIpcmech(args: ISZ[String], i: Z): Option[Ipcmech.Type] = {
    if (i >= args.size) {
      eprintln("Expecting one of the following: { MessageQueue, SharedMemory }, but none found.")
      return None()
    }
    val r = parseIpcmechH(args(i))
    return r
  }

  def parseArsit(args: ISZ[String], i: Z): Option[SireumOption] = {
    val help =
      st"""Slang Generator
          |
          |Usage: <option>*
          |
          |Available Options:
          |-j, --json               Input serialized using Json (otherwise MsgPack
          |                           assumed)
          |-f, --input-file         Read input from file rather than stdin (expects a
          |                           path)
          |-o, --output-dir         Output directory for the generated project files
          |                           (expects a path; default is ".")
          |    --package-name       Base package name for Slang project (output-dir's
          |                           simple name used if not provided) (expects a string)
          |    --noart              Do not embed ART project files
          |    --bless              Generate Bless entrypoints
          |-h, --help               Display this information
          |
          |Transpiler Options:
          |    --trans              Generate Slang/C code required for transpiler
          |    --ipc                IPC communication mechanism (requires 'trans' option)
          |                           (expects one of { MessageQueue, SharedMemory };
          |                           default: MessageQueue)""".render

    var json: B = false
    var inputFile: Option[String] = None[String]()
    var outputDir: Option[String] = Some(".")
    var packageName: Option[String] = None[String]()
    var noart: B = false
    var bless: B = false
    var genTrans: B = false
    var ipc: Ipcmech.Type = Ipcmech.MessageQueue
    var j = i
    var isOption = T
    while (j < args.size && isOption) {
      val arg = args(j)
      if (ops.StringOps(arg).first == '-') {
        if (args(j) == "-h" || args(j) == "--help") {
          println(help)
          return Some(HelpOption())
        } else if (arg == "-j" || arg == "--json") {
           val o: Option[B] = { j = j - 1; Some(!json) }
           o match {
             case Some(v) => json = v
             case _ => return None()
           }
         } else if (arg == "-f" || arg == "--input-file") {
           val o: Option[Option[String]] = parsePath(args, j + 1)
           o match {
             case Some(v) => inputFile = v
             case _ => return None()
           }
         } else if (arg == "-o" || arg == "--output-dir") {
           val o: Option[Option[String]] = parsePath(args, j + 1)
           o match {
             case Some(v) => outputDir = v
             case _ => return None()
           }
         } else if (arg == "--package-name") {
           val o: Option[Option[String]] = parseString(args, j + 1)
           o match {
             case Some(v) => packageName = v
             case _ => return None()
           }
         } else if (arg == "--noart") {
           val o: Option[B] = { j = j - 1; Some(!noart) }
           o match {
             case Some(v) => noart = v
             case _ => return None()
           }
         } else if (arg == "--bless") {
           val o: Option[B] = { j = j - 1; Some(!bless) }
           o match {
             case Some(v) => bless = v
             case _ => return None()
           }
         } else if (arg == "--trans") {
           val o: Option[B] = { j = j - 1; Some(!genTrans) }
           o match {
             case Some(v) => genTrans = v
             case _ => return None()
           }
         } else if (arg == "--ipc") {
           val o: Option[Ipcmech.Type] = parseIpcmech(args, j + 1)
           o match {
             case Some(v) => ipc = v
             case _ => return None()
           }
         } else {
          eprintln(s"Unrecognized option '$arg'.")
          return None()
        }
        j = j + 2
      } else {
        isOption = F
      }
    }
    return Some(ArsitOption(help, parseArguments(args, j), json, inputFile, outputDir, packageName, noart, bless, genTrans, ipc))
  }

  def parseAwas(args: ISZ[String], i: Z): Option[SireumOption] = {
    val help =
      st"""Awas generator
          |
          |Usage: ??
          |
          |Available Options:
          |-h, --help               Display this information""".render

    val j = i
    var isOption = T
    while (j < args.size && isOption) {
      val arg = args(j)
      if (ops.StringOps(arg).first == '-') {
        if (args(j) == "-h" || args(j) == "--help") {
          println(help)
          return Some(HelpOption())
        } else {
          eprintln(s"Unrecognized option '$arg'.")
          return None()
        }

      } else {
        isOption = F
      }
    }
    return Some(AwasOption(help, parseArguments(args, j)))
  }

  def parseSlang(args: ISZ[String], i: Z): Option[SireumOption] = {
    if (i >= args.size) {
      println(
        st"""The Sireum Language (Slang) Toolbox
            |
            |Available modes:
            |tipe                     Slang type checker""".render
      )
      return Some(HelpOption())
    }
    val opt = select("slang", args, i, ISZ("tipe"))
    opt match {
      case Some(string"tipe") => parseSlangTipe(args, i + 1)
      case _ => return None()
    }
  }

  def parseSlangTipe(args: ISZ[String], i: Z): Option[SireumOption] = {
    val help =
      st"""Slang Type Checker
          |
          |Usage: <option>* [<slang-file>]
          |
          |Available Options:
          |-s, --sourcepath         Sourcepath of Slang .scala files (expects path
          |                           strings)
          |-o, --outline            Perform type outlining only for files in the
          |                           sourcepath
          |-f, --force              Fully qualified names of traits, classes, and objects
          |                           to force full type checking on when type outlining
          |                           is enabled (expects a string separated by ",")
          |    --verbose            Enable verbose mode
          |-h, --help               Display this information
          |
          |Persistence Options:
          |    --save               Path to save type information to (outline should not
          |                           be enabled) (expects a path)
          |    --load               Path to load type information from (expects a path)
          |-z, --no-gzip            Disable gzip compression when saving and/or loading""".render

    var sourcepath: ISZ[String] = ISZ[String]()
    var outline: B = false
    var force: ISZ[String] = ISZ[String]()
    var verbose: B = false
    var save: Option[String] = None[String]()
    var load: Option[String] = None[String]()
    var gzip: B = true
    var j = i
    var isOption = T
    while (j < args.size && isOption) {
      val arg = args(j)
      if (ops.StringOps(arg).first == '-') {
        if (args(j) == "-h" || args(j) == "--help") {
          println(help)
          return Some(HelpOption())
        } else if (arg == "-s" || arg == "--sourcepath") {
           val o: Option[ISZ[String]] = parsePaths(args, j + 1)
           o match {
             case Some(v) => sourcepath = v
             case _ => return None()
           }
         } else if (arg == "-o" || arg == "--outline") {
           val o: Option[B] = { j = j - 1; Some(!outline) }
           o match {
             case Some(v) => outline = v
             case _ => return None()
           }
         } else if (arg == "-f" || arg == "--force") {
           val o: Option[ISZ[String]] = parseStrings(args, j + 1, ',')
           o match {
             case Some(v) => force = v
             case _ => return None()
           }
         } else if (arg == "--verbose") {
           val o: Option[B] = { j = j - 1; Some(!verbose) }
           o match {
             case Some(v) => verbose = v
             case _ => return None()
           }
         } else if (arg == "--save") {
           val o: Option[Option[String]] = parsePath(args, j + 1)
           o match {
             case Some(v) => save = v
             case _ => return None()
           }
         } else if (arg == "--load") {
           val o: Option[Option[String]] = parsePath(args, j + 1)
           o match {
             case Some(v) => load = v
             case _ => return None()
           }
         } else if (arg == "-z" || arg == "--no-gzip") {
           val o: Option[B] = { j = j - 1; Some(!gzip) }
           o match {
             case Some(v) => gzip = v
             case _ => return None()
           }
         } else {
          eprintln(s"Unrecognized option '$arg'.")
          return None()
        }
        j = j + 2
      } else {
        isOption = F
      }
    }
    return Some(SlangTipeOption(help, parseArguments(args, j), sourcepath, outline, force, verbose, save, load, gzip))
  }

  def parseArguments(args: ISZ[String], i: Z): ISZ[String] = {
    var r = ISZ[String]()
    var j = i
    while (j < args.size) {
      r = r :+ args(j)
      j = j + 1
    }
    return r
  }

  def parsePaths(args: ISZ[String], i: Z): Option[ISZ[String]] = {
    return tokenize(args, i, "path", pathSep, F)
  }

  def parsePath(args: ISZ[String], i: Z): Option[Option[String]] = {
    if (i >= args.size) {
      eprintln("Expecting a path, but none found.")
    }
    return Some(Some(args(i)))
  }

  def parseStrings(args: ISZ[String], i: Z, sep: C): Option[ISZ[String]] = {
    tokenize(args, i, "string", sep, F) match {
      case r@Some(_) => return r
      case _ => return None()
    }
  }

  def parseString(args: ISZ[String], i: Z): Option[Option[String]] = {
    if (i >= args.size) {
      eprintln("Expecting a string, but none found.")
      return None()
    }
    return Some(Some(args(i)))
  }

  def parseNums(args: ISZ[String], i: Z, sep: C, minOpt: Option[Z], maxOpt: Option[Z]): Option[ISZ[Z]] = {
    tokenize(args, i, "integer", sep, T) match {
      case Some(sargs) =>
        var r = ISZ[Z]()
        for (arg <- sargs) {
          parseNumH(arg, minOpt, maxOpt) match {
            case Some(n) => r = r :+ n
            case _ => return None()
          }
        }
        return Some(r)
      case _ => return None()
    }
  }

  def tokenize(args: ISZ[String], i: Z, tpe: String, sep: C, removeWhitespace: B): Option[ISZ[String]] = {
    if (i >= args.size) {
      eprintln(s"Expecting a sequence of $tpe separated by '$sep', but none found.")
      return None()
    }
    val arg = args(i)
    return Some(tokenizeH(arg, sep, removeWhitespace))
  }

  def tokenizeH(arg: String, sep: C, removeWhitespace: B): ISZ[String] = {
    val argCis = conversions.String.toCis(arg)
    var r = ISZ[String]()
    var cis = ISZ[C]()
    var j = 0
    while (j < argCis.size) {
      val c = argCis(j)
      if (c == sep) {
        r = r :+ conversions.String.fromCis(cis)
        cis = ISZ[C]()
      } else {
        val allowed: B = c match {
          case c"\n" => !removeWhitespace
          case c" " => !removeWhitespace
          case c"\r" => !removeWhitespace
          case c"\t" => !removeWhitespace
          case _ => T
        }
        if (allowed) {
          cis = cis :+ c
        }
      }
      j = j + 1
    }
    if (cis.size > 0) {
      r = r :+ conversions.String.fromCis(cis)
    }
    return r
  }

  def parseNumChoice(args: ISZ[String], i: Z, choices: ISZ[Z]): Option[Z] = {
    val set = HashSet.empty[Z] ++ choices
    parseNum(args, i, None(), None()) match {
      case r@Some(n) =>
        if (set.contains(n)) {
          return r
        } else {
          eprintln(s"Expecting one of the following: $set, but found $n.")
          return None()
        }
      case r => return r
    }
  }

  def parseNum(args: ISZ[String], i: Z, minOpt: Option[Z], maxOpt: Option[Z]): Option[Z] = {
    if (i >= args.size) {
      eprintln(s"Expecting an integer, but none found.")
      return None()
    }
    return parseNumH(args(i), minOpt, maxOpt)
  }

  def parseNumH(arg: String, minOpt: Option[Z], maxOpt: Option[Z]): Option[Z] = {
    Z(arg) match {
      case Some(n) =>
        minOpt match {
          case Some(min) =>
            if (n < min) {
              eprintln(s"Expecting an integer at least $min, but found $n.")
              return None()
            }
          case _ =>
        }
        maxOpt match {
          case Some(max) =>
            if (n > max) {
              eprintln(s"Expecting an integer at most $max, but found $n.")
              return None()
            }
            return Some(n)
          case _ =>
        }
        return Some(n)
      case _ =>
        eprintln(s"Expecting an integer, but found '$arg'.")
        return None()
    }
  }

  def select(mode: String, args: ISZ[String], i: Z, choices: ISZ[String]): Option[String] = {
    val arg = args(i)
    var cs = ISZ[String]()
    for (c <- choices) {
      if (ops.StringOps(c).startsWith(arg)) {
        cs = cs :+ c
      }
    }
    cs.size match {
      case z"0" =>
        eprintln(s"$arg is not a mode of $mode.")
        return None()
      case z"1" => return Some(cs(0))
      case _ =>
        eprintln(
          st"""Which one of the following modes did you mean by '$arg'?
              |${(cs, "\n")}""".render)
        return None()
    }
  }
}