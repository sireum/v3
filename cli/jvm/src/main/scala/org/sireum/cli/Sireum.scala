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

import _root_.java.io._

import org.sireum._

object Sireum extends scala.App {
  System.exit(Cli(_root_.java.io.File.pathSeparatorChar).parseSireum(ISZ(args.map(s => s: String): _*), Z(0)) match {
    case Some(o: Cli.LogikaOption) => Logika.run(o)
    case Some(o: Cli.AwasOption) => awasGen(o)
    case Some(_: Cli.HelpOption) => 0
    case _ => -1
  })

  def awasGen(o: Cli.AwasOption): Int = {
    println(s"Coming soon!")
    println()
    println(o.help)
    0 // TODO
  }

  def paths2files(pathFor: String, paths: ISZ[String], checkExist: B): Seq[File] = {
    var r = Vector[File]()
    for (p <- paths) {
      r = r :+ paths2fileOpt(pathFor, ISZ(p), checkExist).get
    }
    r
  }

  def paths2fileOpt(pathFor: String, path: ISZ[String], checkExist: B): scala.Option[File] = {
    path.size match {
      case z"0" => scala.None
      case z"1" =>
        val f = new File(path(0).value)
        if (checkExist && !f.exists) error(s"File ${path(0)} does not exist.")
        return scala.Some(f.getCanonicalFile.getAbsoluteFile)
      case _ =>
        error(s"Expecting a path for $pathFor, but found multiple.")
    }
  }

  def path2fileOpt(pathFor: String, path: Option[String], checkExist: B): scala.Option[File] = {
    if (path.isEmpty) return scala.None
    val f = new File(path.get.value)
    if (checkExist && !f.exists) error(s"File '$path' does not exist.")
    return scala.Some(f.getCanonicalFile.getAbsoluteFile)
  }

  def error(msg: Predef.String): Nothing = {
    throw new RuntimeException(msg)
  }

}
