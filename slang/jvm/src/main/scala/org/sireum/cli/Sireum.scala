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

import org.sireum.lang.tools._
import org.sireum.lang.util.AccumulatingReporter

object Sireum extends App {
  System.exit(Cli(_root_.java.io.File.pathSeparatorChar).
    parseSireum(ISZ(args.map(s => s: String): _*), Z(0)) match {
    case Some(o: Cli.LogikaOption) => logika(o)
    case Some(o: Cli.CligenOption) => cliGen(o)
    case Some(o: Cli.SergenOption) => serGen(o)
    case Some(o: Cli.TransgenOption) => transGen(o)
    case Some(_: Cli.HelpOption) => 0
    case _ => -1
  })

  def logika(o: Cli.LogikaOption): Int = {
    println(s"Coming soon!")
    println()
    println(o.help)
    0 // TODO
  }

  def cliGen(o: Cli.CligenOption): Int = try {
    o.args.size match {
      case z"0" => println(o.help); return 0
      case z"1" =>
      case _ => println(s"Expecting one argument, but found ${o.args.size}."); return -1
    }
    val lOpt = path2fileOpt("license file", o.license, T)
    val src = paths2fileOpt("config file", o.args, T).get
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

  def serGen(o: Cli.SergenOption): Int = try {
    o.args.size match {
      case z"0" => println(o.help); return 0
      case z"1" =>
      case _ => println(s"Expecting one argument, but found ${o.args.size}."); return -1
    }
    val lOpt = path2fileOpt("license file", o.license, T)
    val src = paths2fileOpt("Slang file", o.args, T).get
    val destDir = path2fileOpt("output directory", o.outputDir, T).get
    if (!destDir.isDirectory) error(s"Path ${destDir.getPath} is not a directory")
    for (m <- o.modes) {
      val (name, mode) = m match {
        case Cli.SerializerMode.Json =>
          (if (o.modes.size > 1)
            if (o.name.value == "") String(o.name + "JSON") else o.name
          else if (o.name.value == "") String("JSON") else o.name, SerializerGen.Mode.JSON)
        case Cli.SerializerMode.Msgpack =>
          (if (o.modes.size > 1)
            if (o.name.value == "") String(o.name + "MsgPack") else o.name
          else if (o.name.value == "") String("MsgPack") else o.name, SerializerGen.Mode.MessagePack)
      }
      val dest = new File(destDir, name.value + ".scala")
      val reporter = AccumulatingReporter.create
      SerializerGenJvm(T, mode, lOpt, src, dest, Some(name), reporter) match {
        case Some(out) =>
          val fw = new FileWriter(dest)
          fw.write(out)
          fw.close()
          println(s"Wrote ${dest.getAbsolutePath}")
        case _ =>
          reporter.printMessages()
      }
    }
    0
  } catch {
    case e: Throwable =>
      eprintln(e.getMessage)
      -1
  }

  def transGen(o: Cli.TransgenOption): Int = try {
    o.args.size match {
      case z"0" => println(o.help); return 0
      case z"1" =>
      case _ => println(s"Expecting one argument, but found ${o.args.size}."); return -1
    }
    val lOpt = path2fileOpt("license file", o.license, T)
    val src = paths2fileOpt("Slang file", o.args, T).get
    val destDir = path2fileOpt("output directory", o.outputDir, T).get
    if (!destDir.isDirectory) error(s"Path ${destDir.getPath} is not a directory")
    for (m <- o.modes) {
      val (name, mode) = m match {
        case Cli.TransformerMode.Immutable =>
          (if (o.modes.size > 1)
            if (o.name.value == "") String(o.name + "Transformer") else o.name
          else if (o.name.value == "") String("Transformer") else o.name, T)
        case Cli.TransformerMode.Mutable =>
          (if (o.modes.size > 1)
            if (o.name.value == "") String("M" + o.name + "Transformer") else o.name
          else if (o.name.value == "") String("MTransformer") else o.name, F)
      }
      val dest = new File(destDir, name.value + ".scala")
      val reporter = AccumulatingReporter.create
      TransformerGenJvm(T, mode, lOpt, src, dest, Some(name), reporter) match {
        case Some(out) =>
          val fw = new FileWriter(dest)
          fw.write(out)
          fw.close()
          println(s"Wrote ${dest.getAbsolutePath}")
        case _ =>
          reporter.printMessages()
      }
    }
    0
  } catch {
    case e: Throwable =>
      eprintln(e.getMessage)
      -1
  }

  def paths2fileOpt(pathFor: String,
                    path: ISZ[String],
                    checkExist: B): scala.Option[File] = {
    path.size match {
      case z"0" => scala.None
      case z"1" =>
        val f = new File(path(0).value)
        if (checkExist && !f.exists) error(s"File ${path(0)} does not exist.")
        return scala.Some(f)
      case _ =>
        error(s"Expecting a path for $pathFor, but found multiple.")
    }
  }

  def path2fileOpt(pathFor: String,
                   path: String,
                   checkExist: B): scala.Option[File] = {
    if (path.value == "") return scala.None
    val f = new File(path.value)
    if (checkExist && !f.exists) error(s"File '${path(0)}' does not exist.")
    return scala.Some(f.getCanonicalFile)
  }

  def error(msg: Predef.String): Nothing = {
    throw new RuntimeException(msg)
  }

}
