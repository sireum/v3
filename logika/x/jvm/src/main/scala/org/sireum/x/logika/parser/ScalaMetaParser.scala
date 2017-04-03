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


package org.sireum.x.logika.parser

import org.sireum.x.logika.{ast => AST}
import org.sireum.util._
import org.sireum.logika.{Z, IS}
import scala.meta._

object ScalaMetaParser {
  case class Result(program: Option[AST.Program], tags: ISeq[Tag])

  def apply(fileUriOpt: Option[FileResourceUri],
            text: String): Result = {

    text.parse[scala.meta.Source] match {
      case Parsed.Success(x) =>
        println("Input: " + x.structure)
        new ScalaMetaParser(fileUriOpt).parseSource(x)
      case pe: Parsed.Error =>
        Result(None, ivector(error(fileUriOpt, pe.pos, pe.message)))
    }
  }

  def error(fileUriOpt: Option[FileResourceUri],
            pos: scala.meta.Position,
            message: String): Tag = {
    val posStart = pos.start
    val posEnd = pos.end
    LocationInfo(
      posStart.line + 1,
      posStart.column + 1,
      posEnd.line + 1,
      posEnd.column + 1,
      posStart.offset,
      posEnd.offset - posStart.offset).
      toLocationError(fileUriOpt, "Logika Parser", message)
  }
}

import ScalaMetaParser._

sealed trait Stmt

class ScalaMetaParser(fileUriOpt: Option[FileResourceUri]) {
  var tags: IVector[Tag] = ivectorEmpty

  def error(pos: scala.meta.Position,
            message: String): Unit = {
    tags +:= ScalaMetaParser.error(fileUriOpt, pos, message)
  }

  def notLogika(pos: scala.meta.Position, message: String): Unit =
    error(pos, message + "not in the Logika language.")

  import scala.meta._

  def parseSource(source: scala.meta.Source): Result = source.stats match {
    case List(q"package $ref { ..$stats }") =>
      Result(
        Some(AST.Program(
          AST.Name(packageRef2IS(ref)),
          AST.Block(stats.toVector.flatMap(parseStat)))), tags)
    case q"import org.sireum.logika._" :: stats =>
      Result(
        Some(AST.Program(
          AST.Name(Vector()),
          AST.Block(stats.toVector.flatMap(parseStat)))), tags)
    case stats =>
      if (stats.nonEmpty)
        error(stats.head.pos, s"A Logika program should either start with 'package <name>' or 'import org.sireum.logika._'.")
      Result(None, tags)
  }

  def parseStat(stat: scala.meta.Stat): Option[AST.Stmt] = stat match {
    case q"..$mods object $name extends { ..$estats } with ..$ctorcalls { ..$stats }" =>
      var hasError = false
      if (mods.nonEmpty) {
        hasError = true
        notLogika(mods.head.pos, "Object modifiers are")
      }
      if (estats.nonEmpty) {
        hasError = true
        notLogika(mods.head.pos, "Object early initializations are")
      }
      if (ctorcalls.nonEmpty) {
        hasError = true
        notLogika(mods.head.pos, "Object super constructor calls are")
      }
      if (!hasError)
        Some(AST.ObjectStmt(name.value, stats.toVector.flatMap(parseStat)))
      else None
    case q"..$mods def $name[..$tparams]: $tpeopt = $exp" =>
      mods match {
        case mod"@ext" :: rest =>
          var hasError = false
          exp match {
            case Term.Name("$") =>
              ???
            case exp: Term.Interpolate if exp.prefix.value == "c" =>
              ???
            case _ =>
              hasError = true
              error(exp.pos, "Only $ or c\"\"\"{ ... }\"\"\" are allowed as Logika @ext object method expression.")
              None
          }
        case _ => ???
      }
    case q"..$mods def $name[..$tparams](..$params): $tpeopt = $exp" =>
      mods match {
        case mod"@native" :: rest =>
          var hasError = false
          exp match {
            case Term.Name("$") =>
              ???
            case exp: Term.Interpolate if exp.prefix.value == "c" =>
              ???
            case _ =>
              hasError = true
              error(exp.pos, "Only $ or c\"\"\"{ ... }\"\"\" are allowed as Logika @ext object method expression.")
              None
          }
        case _ =>
          ???
      }
    case _ => None
  }

  def packageRef2IS(ref: Term.Ref): IS[Z, String] =
    vector2is(ref.toString.split(".").toVector)

  import scala.language.implicitConversions

  implicit def vector2is[T](s: IVector[T]): IS[Z, T] =
    org.sireum.logika.collection._IS[Z, T](s: _*)

}
