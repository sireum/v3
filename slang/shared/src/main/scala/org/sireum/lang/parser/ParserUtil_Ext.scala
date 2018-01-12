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

package org.sireum.lang.parser

import org.sireum._
import org.sireum.lang.util._

import scala.meta._
import scala.meta.internal.parsers.ModifiedScalametaParser
import scala.util._

object ParserUtil_Ext {

  def parseStmt[T](text: String): T = {
    val reporter = AccumulatingReporter.create
    val (dialect, input) = SlangParser.scalaDialect(isWorksheet = false)(text.value)
    val metap = new ModifiedScalametaParser(input, dialect)
    val stat = Try(metap.parseStat) match {
      case Success(s) => s
      case Failure(e) => err(e.getMessage)
    }
    val stmt = new SlangParser(text.value, input, dialect,
      allowSireumPackage = false, hashSireum = true, isWorksheet = false,
      isDiet = false, None(), reporter).translateStat(Enclosing.Method)(stat)
    reporter.printMessages()
    if (reporter.hasIssue) err()
    stmt.asInstanceOf[T]
  }

  def parseExp[T](text: String): T = {
    val reporter = AccumulatingReporter.create
    val (dialect, input) = SlangParser.scalaDialect(isWorksheet = false)(text.value)
    val metap = new ModifiedScalametaParser(input, dialect)
    val term = Try(metap.parseTerm) match {
      case Success(t) => t
      case Failure(e) => err(e.getMessage)
    }
    val exp = new SlangParser(text.value, input, dialect,
      allowSireumPackage = false, hashSireum = true, isWorksheet = false,
      isDiet = false, None(), reporter).translateExp(term)
    reporter.printMessages()
    if (reporter.hasIssue) err()
    exp.asInstanceOf[T]
  }

  def parseTopUnit[T](text: String,
                      allowSireum: B,
                      isWorksheet: B,
                      isDiet: B,
                      fileUriOpt: Option[String],
                      reporter: Reporter): Option[T] =
    SlangParser(allowSireum, isWorksheet, isDiet, fileUriOpt,
      text.value, reporter).unitOpt.map(_.asInstanceOf[T])

  def err(s: Predef.String = "Can only be used for non-erroneous Slang statement."): Nothing = halt(s)
}
