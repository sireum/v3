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

package org.sireum.cli

import org.sireum._
import org.sireum.message._
import org.sireum.cli.Cli.SlangTipeOption
import _root_.java.io._
import _root_.java.nio.file._
import _root_.java.nio.charset._

import ammonite.ops._
import org.sireum.lang.ast.TopUnit
import org.sireum.lang.parser.Parser

import scala.collection.JavaConverters._
import org.sireum.lang.symbol._
import org.sireum.lang.tipe._

object SlangTipe {

  val InvalidLibrary: Int = -1
  val InvalidMode: Int = -2
  val InvalidPath: Int = -3
  val InvalidFile: Int = -4
  val InvalidSources: Int = -5
  val InvalidSlangFiles: Int = -6
  val InvalidForceNames: Int = -7
  val InternalError: Int = -8

  def run(o: SlangTipeOption): Int = {
    def readFile(f: File): (Option[String], String) = {
      val file = f.getCanonicalFile.getAbsoluteFile
      (Some(file.toURI.toASCIIString), read ! ammonite.ops.Path(file))
    }
    if (o.args.isEmpty && o.sourcepath.isEmpty) {
      println(o.help)
      println()
      println("Please either specify sourcepath or Slang files as arguments")
      return 0
    }
    if (o.force.nonEmpty && !o.outline) {
      eprintln("Forcing type checking can only be used when outline is enabled")
      return InvalidMode
    }

    var start = 0l
    var used = 0l
    val rt = Runtime.getRuntime
    def startTime(): Unit = {
      start = System.currentTimeMillis
    }
    def stopTime(): Unit = {
      if (o.verbose) {
        val end = System.currentTimeMillis
        val newUsed = rt.totalMemory - rt.freeMemory
        if (newUsed > used) {
          used = newUsed
        }
        println(f"Time: ${end - start} ms, Memory: ${newUsed / 1024d / 1024d}%.2f MB")
      }
    }

    val begin = System.currentTimeMillis

    if (o.verbose && o.args.nonEmpty) {
      println("Reading Slang file arguments ...")
      startTime()
    }

    var slangFiles = ISZ[(String, (Option[String], String))]()
    for (arg <- o.args) {
      val f = new File(arg.value)
      if (!f.exists) {
        eprintln(s"File $arg does not exist.")
        return InvalidFile
      } else if (!f.isFile) {
        eprintln(s"Path $arg is not a file.")
        return InvalidFile
      } else if (!f.getName.endsWith(".slang")) {
        eprintln(s"Can only accept .slang files as arguments")
        return InvalidFile
      }
      slangFiles = slangFiles :+ (arg, readFile(f))
    }

    if (o.verbose) {
      if (o.args.nonEmpty) {
        stopTime()
        println()
      }
      println("Reading sourcepath files ...")
      startTime()
    }

    var sources = ISZ[(Option[String], String)]()
    def collectFiles(f: File): Unit = {
      if (f.isDirectory) {
        for (file <- f.listFiles()) {
          collectFiles(file)
        }
      } else if (f.isFile) {
        if (f.getName.endsWith(".scala")) {
          var isSlang = F
          for (firstLine <- Files.lines(f.toPath, StandardCharsets.UTF_8).limit(1).iterator.asScala) {
            isSlang = firstLine
              .replaceAllLiterally(" ", "")
              .replaceAllLiterally("\t", "")
              .replaceAllLiterally("\r", "")
              .contains("#Sireum")
          }
          if (isSlang) {
            sources = sources :+ readFile(f)
            if (o.verbose) println(s"Read ${f.getCanonicalPath}")
          }
        }
      }
    }

    for (p <- o.sourcepath) {
      val f = new File(p.value)
      if (!f.exists) {
        eprintln(s"Source path '$p' does not exist.")
        return InvalidPath
      } else {
        collectFiles(f)
      }
    }

    if (o.sourcepath.nonEmpty && sources.isEmpty) {
      eprintln("Did not find any sources in the specified sourcepath")
      return InvalidSources
    }
    stopTime()

    if (o.verbose) {
      println()
      println(
        s"Parsing, resolving, ${if (o.outline) "and type outlining" else "type outlining, and type checking"} Slang library files ..."
      )
      startTime()
    }

    var (th, reporter): (TypeHierarchy, Reporter) = if (o.outline) {
      val p = TypeChecker.libraryReporter
      (p._1.typeHierarchy, p._2)
    } else {
      val p = TypeChecker.checkedLibraryReporter
      (p._1.typeHierarchy, p._2)
    }

    if (reporter.hasIssue) {
      reporter.printMessages()
      return InvalidLibrary
    }
    stopTime()

    if (o.verbose) {
      println()
      println("Parsing and resolving Slang sourcepath programs ...")
      startTime()
    }

    val t = Resolver.parseProgramAndGloballyResolve(sources, th.nameMap, th.typeMap)
    if (t._1.hasIssue) {
      t._1.printMessages()
      return InvalidSources
    }
    stopTime()

    if (o.verbose) {
      println()
      println("Building type hierarchy of Slang sourcepath programs ...")
      startTime()
    }

    th = TypeHierarchy.build(th(nameMap = t._3, typeMap = t._4), reporter)
    if (reporter.hasIssue) {
      reporter.printMessages()
      return InvalidSources
    }
    stopTime()

    if (o.verbose) {
      println()
      println("Type outlining Slang sourcepath programs ...")
      startTime()
    }

    th = TypeOutliner.checkOutline(th, reporter)
    if (reporter.hasIssue) {
      reporter.printMessages()
      return InvalidSources
    }
    stopTime()

    if (o.outline) {
      var nameMap: Resolver.NameMap = HashMap.empty
      var typeMap: Resolver.TypeMap = HashMap.empty

      if (o.verbose && o.force.nonEmpty) {
        println()
        println("Type checking Slang entities in the force list ...")
        startTime()
      }

      var ok = T
      for (name <- o.force) {
        val ids = ISZ[String](name.value.split('.').map(id => String(id)): _*)
        var found = F
        th.nameMap.get(ids) match {
          case Some(info: Info.Object) =>
            nameMap = nameMap + ids ~> info
            found = T
          case _ =>
        }
        th.typeMap.get(ids) match {
          case Some(info: TypeInfo.Sig) =>
            typeMap = typeMap + ids ~> info
            found = T
          case Some(info: TypeInfo.AbstractDatatype) =>
            typeMap = typeMap + ids ~> info
            found = T
          case _ =>
        }
        if (!found) {
          eprintln(st"No object, trait, or class with name '${(ids, ".")}' was found".render)
          ok = F
        }
      }
      if (!ok) {
        return InvalidForceNames
      }

      th = TypeChecker.checkComponents(th, nameMap, typeMap, reporter)

      if (reporter.hasIssue) {
        reporter.printMessages()
        return InvalidSources
      }
      if (o.force.nonEmpty) stopTime()

    } else {

      if (o.verbose) {
        println()
        println("Type checking Slang sourcepath programs ...")
        startTime()
      }

      th = TypeChecker.checkComponents(th, th.nameMap, th.typeMap, reporter)

      if (reporter.hasIssue) {
        reporter.printMessages()
        return InvalidSources
      }
      stopTime()

      if (o.verbose) {
        println()
        println(
          "Sanity checking computed symbol and type information of Slang library files and sourcepath programs ..."
        )
        startTime()
      }

      PostTipeAttrChecker.checkNameTypeMaps(th.nameMap, th.typeMap, reporter)

      if (reporter.hasIssue) {
        reporter.printMessages()
        return InternalError
      }
      stopTime()
    }

    val thOpt: Option[TypeHierarchy] = Some(th)

    for (slangFile <- slangFiles) {

      if (o.verbose) {
        println()
        println(s"Parsing, resolving, type outlining, and type checking ${slangFile._1} ...")
        startTime()
      }

      Parser.parseTopUnit(slangFile._2._2, F, T, F, slangFile._2._1, reporter) match {
        case Some(p: TopUnit.Program) =>
          val p2 = TypeChecker.checkWorksheet(thOpt, p, reporter)
          if (reporter.hasIssue) {
            reporter.printMessages()
            return InvalidSlangFiles
          }
          stopTime()

          if (o.verbose) {
            println()
            println(s"Sanity checking computed symbol and type information of ${slangFile._1} ...")
            startTime()
          }

          PostTipeAttrChecker.checkProgram(p2, reporter)

          if (reporter.hasIssue) {
            reporter.printMessages()
            return InternalError
          }
          stopTime()

        case Some(_) => eprintln(s"File '${slangFile._1}' does not contain a Slang program")
        case _ =>
      }
    }

    if (o.verbose) {
      val newUsed = rt.totalMemory - rt.freeMemory
      if (newUsed > used) {
        used = newUsed
      }
      println()
      println(
        f"Ok! Total time: ${(System.currentTimeMillis - begin) / 1000d}%.2f s, Max memory: ${used / 1024d / 1024d}%.2f MB"
      )
    }

    return 0
  }
}