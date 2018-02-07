// #Sireum
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

@ext object Parser {

  @pure def parseStmt[T](text: String): T = $

  @pure def parseExp[T](text: String): T = $

  def parseTopUnit[T](text: String,
                      allowSireum: B,
                      isWorksheet: B,
                      isDiet: B,
                      fileUriOpt: Option[String],
                      reporter: Reporter): Option[T] = $
}

@datatype class Parser(text: String) {

  @pure def parseStmt[T]: T = {
    return Parser.parseStmt[T](text)
  }

  @pure def parseExp[T]: T = {
    return Parser.parseExp[T](text)
  }

  def parseTopUnit[T](allowSireum: B,
                      isWorksheet: B,
                      isDiet: B,
                      fileUriOpt: Option[String],
                      reporter: Reporter): Option[T] = {
    val r = Parser.parseTopUnit[T](text, allowSireum, isWorksheet, isDiet, fileUriOpt, reporter)
    return r
  }
}
