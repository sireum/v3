// #Sireum
// @formatter:off

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

// This file is auto-generated from CliConfig.sc

package org.sireum.cli

import org.sireum._

object Cli {

  @datatype trait SireumOption

  @datatype class HelpOption extends SireumOption

  @datatype class LogikaOption(
    help: String,
    args: ISZ[String],
    auto: B,
    symexe: B,
    formula: String,
    bitwidth: Z,
    last: B,
    sat: B,
    server: B,
    timeout: Z
  ) extends SireumOption

  @datatype class CligenOption(
    help: String,
    args: ISZ[String],
    packageName: ISZ[String],
    name: String,
    width: ISZ[Z],
    license: ISZ[String],
    outputDir: ISZ[String]
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
            |logika                   Logika Verifier and Proof Checker
            |util                     Utility Tools""".render
      )
      return Some(HelpOption())
    }
    val opt = select("sireum", args, i, ISZ("logika", "util"))
    opt match {
      case Some(string"logika") => parseLogika(args, i + 1)
      case Some(string"util") => parseUtil(args, i + 1)
      case _ => return None()
    }
  }

  def parseLogika(args: ISZ[String], i: Z): Option[SireumOption] = {
    val help =
      st"""Sireum/Logika:
          |A Program Verifier and A Natural Deduction Proof Checker
          |... for Propositional, Predicate, and Programming Logics
          |
          |Available Options:
          |-a, --auto               Enables auto mode
          |-x, --symexe             Enables symbolic execution mode
          |-f, --formula            Enables symbolic execution mode (expects a string)
          |-b, --bitwidth           Default bitwidth for Z and N (expects one of { 0, 8,
          |                           16, 32, 64 })
          |-l, --last               Verifies the last file only
          |    --sat                Enables facts and contracts satisfiability checking
          |    --server             Enables symbolic execution mode
          |-t, --timeout            Timeout for SMT2 solver (in milliseconds) (expects an
          |                           integer; default is 1000)
          |-h, --help               Display this information""".render

    var auto: B = false
    var symexe: B = false
    var formula: String = ""
    var bitwidth: Z = 0
    var last: B = false
    var sat: B = false
    var server: B = false
    var timeout: Z = 1000
    var j = i
    var isOption = T
    while (j < args.size && isOption) {
      val arg = args(j)
      if (arg(0) == '-') {
        if (args(j) == "-h" || args(j) == "--help") {
          println(help)
          return Some(HelpOption())
        } else if (arg == "-a" || arg == "--auto") {
           val o = Some(!auto)
           o match {
             case Some(v) => auto = v
             case _ => return None()
           }
         } else if (arg == "-x" || arg == "--symexe") {
           val o = Some(!symexe)
           o match {
             case Some(v) => symexe = v
             case _ => return None()
           }
         } else if (arg == "-f" || arg == "--formula") {
           val o = parseString(args, j + 1)
           o match {
             case Some(v) => formula = v
             case _ => return None()
           }
         } else if (arg == "-b" || arg == "--bitwidth") {
           val o = parseNumChoice(args, j + 1, ISZ(z"0", z"8", z"16", z"32", z"64"))
           o match {
             case Some(v) => bitwidth = v
             case _ => return None()
           }
         } else if (arg == "-l" || arg == "--last") {
           val o = Some(!last)
           o match {
             case Some(v) => last = v
             case _ => return None()
           }
         } else if (arg == "--sat") {
           val o = Some(!sat)
           o match {
             case Some(v) => sat = v
             case _ => return None()
           }
         } else if (arg == "--server") {
           val o = Some(!server)
           o match {
             case Some(v) => server = v
             case _ => return None()
           }
         } else if (arg == "-t" || arg == "--timeout") {
           val o = parseNum(args, j + 1, Some(1000), None())
           o match {
             case Some(v) => timeout = v
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
    return Some(LogikaOption(help, parseArguments(args, j), auto, symexe, formula, bitwidth, last, sat, server, timeout))
  }

  def parseUtil(args: ISZ[String], i: Z): Option[SireumOption] = {
    if (i >= args.size) {
      println(
        st"""Sireum Utility Tools
            |
            |Available modes:
            |cligen                   Command-line interface generator""".render
      )
      return Some(HelpOption())
    }
    val opt = select("util", args, i, ISZ("cligen"))
    opt match {
      case Some(string"cligen") => parseCligen(args, i + 1)
      case _ => return None()
    }
  }

  def parseCligen(args: ISZ[String], i: Z): Option[SireumOption] = {
    val help =
      st"""Sireum CLI Generator
          |
          |Available Options:
          |-p, --package            Package name for the CLI @record class processor
          |                           (expects a string separated by "."; default is
          |                           "cli")
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
    var name: String = "Cli"
    var width: ISZ[Z] = ISZ()
    var license: ISZ[String] = ISZ[String]()
    var outputDir: ISZ[String] = ISZ(".")
    var j = i
    var isOption = T
    while (j < args.size && isOption) {
      val arg = args(j)
      if (arg(0) == '-') {
        if (args(j) == "-h" || args(j) == "--help") {
          println(help)
          return Some(HelpOption())
        } else if (arg == "-p" || arg == "--package") {
           val o = parseStrings(args, j + 1, '.')
           o match {
             case Some(v) => packageName = v
             case _ => return None()
           }
         } else if (arg == "-n" || arg == "--name") {
           val o = parseString(args, j + 1)
           o match {
             case Some(v) => name = v
             case _ => return None()
           }
         } else if (arg == "-w" || arg == "--width") {
           val o = parseNums(args, j + 1, ',', Some(0), None())
           o match {
             case Some(v) => width = v
             case _ => return None()
           }
         } else if (arg == "-l" || arg == "--license") {
           val o = parsePath(args, j + 1)
           o match {
             case Some(v) => license = v
             case _ => return None()
           }
         } else if (arg == "-o" || arg == "--output-dir") {
           val o = parsePath(args, j + 1)
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

  def parseArguments(args: ISZ[String], i: Z): ISZ[String] = {
    var r = ISZ[String]()
    var j = i
    while (j < args.size) {
      r = r :+ args(j)
      j = j + 1
    }
    return r
  }

  def parsePath(args: ISZ[String], i: Z): Option[ISZ[String]] = {
    return tokenize(args, i, "path", pathSep, F)
  }

  def parseStrings(args: ISZ[String], i: Z, sep: C): Option[ISZ[String]] = {
    tokenize(args, i, "string", sep, F) match {
      case r@Some(_) => return r
      case _ => return None()
    }
  }

  def parseString(args: ISZ[String], i: Z): Option[String] = {
    if (i >= args.size) {
      eprintln("Expecting a string, but none found.")
      return None()
    }
    return Some(args(i))
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
    val set = HashSet.empty[Z].addAll(choices)
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