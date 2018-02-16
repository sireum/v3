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
import org.sireum.cli.Cli.SlangCheckerOption
import _root_.java.io._
import _root_.java.nio.file._
import _root_.java.nio.charset._

import ammonite.ops._
import org.sireum.lang.ast.TopUnit
import org.sireum.lang.parser.Parser

import scala.collection.JavaConverters._
import org.sireum.lang.symbol.Resolver
import org.sireum.lang.tipe.{TypeChecker, TypeHierarchy, TypeOutliner}
import org.sireum.lang.util.AccumulatingReporter

object SlangChecker {

  val InvalidLibrary: Int = -1
  val InvalidMode: Int = -2
  val InvalidPath: Int = -3
  val InvalidFile: Int = -4
  val InvalidSources: Int = -5
  val InvalidSlangFiles: Int = -6
  val InvalidForceNames: Int = -7

  def run(o: SlangCheckerOption): Int = {
    def readFile(f: File): (Option[String], String) = {
      (Some(f.getCanonicalFile.toURI.toASCIIString), read ! ammonite.ops.Path(f))
    }
    if (o.args.isEmpty && o.sourcepath.isEmpty) {
      println(o.help)
      println()
      println("Please either specify sourcepath or Slang files as arguments.")
      return 0
    }
    if (o.force.nonEmpty && !o.outline) {
      eprintln("Forcing type checking can only be used when outline is used")
      return InvalidMode
    }
    var slangFiles = ISZ[(String, (Option[String], String))]()
    for (arg <- o.args) {
      val f = new File(arg.value)
      if (!f.exists) {
        eprintln(s"File '$arg' does not exist.")
        return InvalidFile
      } else if (!f.isFile) {
        eprintln(s"Path '$arg' is not a file.")
        return InvalidFile
      } else if (!f.getName.endsWith(".slang")) {
        eprintln(s"Can only accept .slang files as arguments")
        return InvalidFile
      }
      slangFiles = slangFiles :+ (arg, readFile(f))
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
            isSlang = firstLine.replaceAllLiterally(" ", "").replaceAllLiterally("\t", "").replaceAllLiterally("\r", "").contains("#Sireum")
          }
          if (isSlang) {
            sources = sources :+ readFile(f)
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

    var (th, reporter): (TypeHierarchy, AccumulatingReporter) = if (o.outline) {
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

    val t = Resolver.parseProgramAndGloballyResolve(sources, th.nameMap, th.typeMap)
    if (t._1.hasIssue) {
      t._1.printMessages()
      return InvalidSources
    }

    th = TypeHierarchy.build(th(nameMap = t._2, typeMap = t._3), reporter)
    if (reporter.hasIssue) {
      reporter.printMessages()
      return InvalidSources
    }

    th = TypeOutliner.checkOutline(th, reporter)
    if (reporter.hasIssue) {
      reporter.printMessages()
      return InvalidSources
    }

    if (o.outline) {
      var nameMap: Resolver.NameMap = HashMap.empty
      var typeMap: Resolver.TypeMap = HashMap.empty
      var ok = T
      for (name <- o.force) {
        val ids = ISZ[String](name.value.split('.').map(id => String(id)): _*)
        var found = F
        th.nameMap.get(ids) match {
          case Some(info: Resolver.Info.Object) =>
            nameMap = nameMap + ids ~> info
            found = T
          case _ =>
        }
        th.typeMap.get(ids) match {
          case Some(info: Resolver.TypeInfo.Sig) =>
            typeMap = typeMap + ids ~> info
            found = T
          case Some(info: Resolver.TypeInfo.AbstractDatatype) =>
            typeMap = typeMap + ids ~> info
            found = T
          case _ =>
        }
        if (!found) {
          eprintln(st"No object, trait, or class with name '${(ids, ".")}' was found.".render)
          ok = F
        }
      }
      if (!ok) {
        return InvalidForceNames
      }
      th = TypeChecker.checkComponents(th, nameMap, typeMap, reporter)
    } else {
      th = TypeChecker.checkComponents(th, th.nameMap, th.typeMap, reporter)
    }

    if (reporter.hasIssue) {
      reporter.printMessages()
      return InvalidSources
    }

    val thOpt: Option[TypeHierarchy] = Some(th)

    for (slangFile <- slangFiles) {
      Parser.parseTopUnit(slangFile._2._2, F, T, F, slangFile._2._1, reporter) match {
        case Some(p: TopUnit.Program) =>
          TypeChecker.checkWorksheet(thOpt, p, reporter)
        case Some(_) => eprintln(s"File '${slangFile._1}' does not contain a Slang program.")
        case _ =>
      }
    }

    if (reporter.hasIssue) {
      reporter.printMessages()
      return InvalidSlangFiles
    }

    return 0
  }
}
