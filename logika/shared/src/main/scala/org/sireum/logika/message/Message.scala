/*
 Copyright (c) 2016, Robby, Kansas State University
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

package org.sireum.logika.message

import org.sireum.util._

object Message {
  def pickleInput(m: InputMessage): String =
    upickle.json.write(InputMessageJson.fromInputMessage(m))

  def unpickleInput[T <: InputMessage](s: String): T =
    InputMessageJson.toInputMessage[T](upickle.json.read(s))

  def pickleOutput(m: OutputMessage): String =
    upickle.json.write(OutputMessageJson.fromOutputMessage(m))

  def unpickleOutput[T <: OutputMessage](s: String): T =
    OutputMessageJson.toOutputMessage[T](upickle.json.read(s))
}

sealed trait InputMessage extends Product

case object Terminate extends InputMessage

final case class Check(requestId: String,
                       isBackground: Boolean,
                       kind: CheckerKind.Value,
                       hintEnabled: Boolean,
                       inscribeSummoningsEnabled: Boolean,
                       proofs: Vector[ProofFile],
                       lastOnly: Boolean,
                       autoEnabled: Boolean,
                       timeout: Int,
                       checkSatEnabled: Boolean,
                       bitWidth: Int)
  extends InputMessage

object CheckerKind extends Enum {
  final val Forward = Value("forward")
  final val Backward = Value("backward")
  final val SymExe = Value("symexe")
}

final case class ProofFile(fileUriOpt: Option[FileResourceUri],
                           content: String) extends InputMessage

sealed trait OutputMessage extends Product

final case class Result(requestId: String,
                        isBackground: Boolean,
                        tags: Vector[Tag]) extends OutputMessage
