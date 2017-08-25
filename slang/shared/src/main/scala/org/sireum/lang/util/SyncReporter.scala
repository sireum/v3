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

package org.sireum.lang.util

import org.sireum._
import org.sireum.lang.ast._
import $internal.Macro.sync

final class SyncReporter(reporter: Reporter) extends Reporter {

  def hasIssue: B = sync(reporter, reporter.hasIssue)

  def internalError(posOpt: Option[PosInfo], kind: String, message: String): Unit =
    sync(reporter, reporter.internalError(posOpt, kind, message))

  def error(posOpt: Option[PosInfo], kind: String, message: String): Unit =
    sync(reporter, reporter.error(posOpt, kind, message))

  def warn(posOpt: Option[PosInfo], kind: String, message: String): Unit =
    sync(reporter, reporter.warn(posOpt, kind, message))

  def info(posOpt: Option[PosInfo], kind: String, message: String): Unit =
    sync(reporter, reporter.info(posOpt, kind, message))

  def string: String = halt("Unsupported")
  def $clone: Mutable = halt("Unsupported")
  def owned_=(b: Boolean): this.type = halt("Unsupported")
  def owned: Boolean = halt("Unsupported")
}
