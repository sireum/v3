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

package org.sireum.cli

import org.sireum._
import _root_.java.io._
import org.sireum.lang.tools.CliGenJvm

object Sireum extends App {
  Cli(_root_.java.io.File.pathSeparatorChar).
    parseSireum(ISZ(args.map(s => s: String): _*), Z(0)) match {
    case Some(o: Cli.LogikaOption) => logika(o)
    case Some(o: Cli.CligenOption) => cliGen(o)
    case Some(o: Cli.HelpOption) => 0
    case _ => -1
  }

  def logika(o: Cli.LogikaOption): Int = {
    println(s"Coming soon: $o"); 0 // TODO
  }

  def cliGen(o: Cli.CligenOption): Int = try {
    if (o.args.size != 1) {
      eprintln(s"Expecting one argument, but found ${o.args.size}.")
      return -1
    }
    val lOpt = path2fileOpt("license file", o.license, T)
    val src = path2fileOpt("config file", o.args, T).get
    val destDir = path2fileOpt("output directory", o.outputDir, T).get
    if (!destDir.isDirectory) error(s"Path ${destDir.getPath} is not a directory")
    val dest = new File(destDir, o.name.value + ".scala")
    val (first, second) = o.width.size match {
      case z"2" => (o.width(0), o.width(1))
      case _ => (z"25", z"55")
    }
    val out = CliGenJvm(lOpt, src, dest, o.packageName, Some(o.name), first, second)
    val fw = new FileWriter(dest)
    fw.write(out)
    fw.close()
    println(s"Wrote ${dest.getAbsolutePath}")
    0
  } catch {
    case e: Throwable =>
      eprintln(e.getMessage)
      -1
  }

  def path2fileOpt(pathFor: String,
                   path: ISZ[String],
                   checkExist: B): Option[File] = {
    path.size match {
      case z"0" => None()
      case z"1" =>
        val f = new File(path(0).value)
        if (checkExist && !f.exists) error(s"File ${path(0)} does not exist.")
        return Some(f)
      case _ =>
        error(s"Expecting a path for $pathFor, but found multiple.")
    }
  }

  def error(msg: Predef.String): Nothing = {
    throw new RuntimeException(msg)
  }

}
