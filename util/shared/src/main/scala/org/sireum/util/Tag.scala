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

package org.sireum.util

sealed trait Tag extends Product

sealed trait KindTag extends Tag {
  def kind: String
}

sealed trait UriTag extends Tag {
  def uri: Uri
}

sealed trait LocationInfoTag extends Tag {
  def lineBegin: PosInteger

  def columnBegin: PosInteger

  def lineEnd: PosInteger

  def columnEnd: PosInteger

  def offset: Natural

  def length: Natural

  def toFileLocationError(fileUriOpt: Option[FileResourceUri],
                          kind: String, msg: String) =
    fileUriOpt match {
      case Some(fileUri) =>
        FileLocationInfoErrorMessage(
          kind = kind,
          uri = fileUri,
          lineBegin = lineBegin,
          columnBegin = columnBegin,
          lineEnd = lineEnd,
          columnEnd = columnEnd,
          offset = offset,
          length = length,
          message = msg)
      case _ =>
        LocationInfoErrorMessage(
          kind = kind,
          lineBegin = lineBegin,
          columnBegin = columnBegin,
          lineEnd = lineEnd,
          columnEnd = columnEnd,
          offset = offset,
          length = length,
          message = msg)
    }

  def toFileLocationWarning(fileUriOpt: Option[FileResourceUri],
                            kind: String, msg: String) =
    fileUriOpt match {
      case Some(fileUri) =>
        FileLocationInfoWarningMessage(
          kind = kind,
          uri = fileUri,
          lineBegin = lineBegin,
          columnBegin = columnBegin,
          lineEnd = lineEnd,
          columnEnd = columnEnd,
          offset = offset,
          length = length,
          message = msg)
      case _ =>
        LocationInfoWarningMessage(
          kind = kind,
          lineBegin = lineBegin,
          columnBegin = columnBegin,
          lineEnd = lineEnd,
          columnEnd = columnEnd,
          offset = offset,
          length = length,
          message = msg)
    }

  def toFileLocationInfo(fileUriOpt: Option[FileResourceUri],
                         kind: String, msg: String) =
    fileUriOpt match {
      case Some(fileUri) =>
        FileLocationInfoInfoMessage(
          kind = kind,
          uri = fileUri,
          lineBegin = lineBegin,
          columnBegin = columnBegin,
          lineEnd = lineEnd,
          columnEnd = columnEnd,
          offset = offset,
          length = length,
          message = msg)
      case _ =>
        LocationInfoInfoMessage(
          kind = kind,
          lineBegin = lineBegin,
          columnBegin = columnBegin,
          lineEnd = lineEnd,
          columnEnd = columnEnd,
          offset = offset,
          length = length,
          message = msg)
    }
}

sealed trait SeverityTag extends Tag

sealed trait InternalErrorTag extends SeverityTag

sealed trait ErrorTag extends SeverityTag

sealed trait WarningTag extends SeverityTag

sealed trait InfoTag extends SeverityTag

sealed trait MessageTag extends Tag {
  def message: String
}

final case class
LocationInfo(lineBegin: PosInteger,
             columnBegin: PosInteger,
             lineEnd: PosInteger,
             columnEnd: PosInteger,
             offset: Natural,
             length: Natural)
  extends LocationInfoTag

final case class
FileLocationInfoErrorMessage(kind: String,
                             uri: Uri,
                             lineBegin: PosInteger,
                             columnBegin: PosInteger,
                             lineEnd: PosInteger,
                             columnEnd: PosInteger,
                             offset: Natural,
                             length: Natural,
                             message: String)
  extends UriTag
  with LocationInfoTag
  with ErrorTag
  with MessageTag


final case class
FileLocationInfoWarningMessage(kind: String,
                               uri: Uri,
                               lineBegin: PosInteger,
                               columnBegin: PosInteger,
                               lineEnd: PosInteger,
                               columnEnd: PosInteger,
                               offset: Natural,
                               length: Natural,
                               message: String)
  extends UriTag
  with LocationInfoTag
  with WarningTag
  with MessageTag


final case class
FileLocationInfoInfoMessage(kind: String,
                            uri: Uri,
                            lineBegin: PosInteger,
                            columnBegin: PosInteger,
                            lineEnd: PosInteger,
                            columnEnd: PosInteger,
                            offset: Natural,
                            length: Natural,
                            message: String)
  extends UriTag
  with LocationInfoTag
  with InfoTag
  with MessageTag


final case class
LocationInfoErrorMessage(kind: String,
                         lineBegin: PosInteger,
                         columnBegin: PosInteger,
                         lineEnd: PosInteger,
                         columnEnd: PosInteger,
                         offset: Natural,
                         length: Natural,
                         message: String)
  extends LocationInfoTag
  with ErrorTag
  with MessageTag


final case class
LocationInfoWarningMessage(kind: String,
                           lineBegin: PosInteger,
                           columnBegin: PosInteger,
                           lineEnd: PosInteger,
                           columnEnd: PosInteger,
                           offset: Natural,
                           length: Natural,
                           message: String)
  extends LocationInfoTag
  with WarningTag
  with MessageTag


final case class
LocationInfoInfoMessage(kind: String,
                        lineBegin: PosInteger,
                        columnBegin: PosInteger,
                        lineEnd: PosInteger,
                        columnEnd: PosInteger,
                        offset: Natural,
                        length: Natural,
                        message: String)
  extends LocationInfoTag
  with InfoTag
  with MessageTag


final case class
InternalErrorMessage(kind: String,
                     message: String)
  extends InternalErrorTag
  with MessageTag


final case class
ErrorMessage(kind: String,
             message: String)
  extends ErrorTag
  with MessageTag


final case class
WarningMessage(kind: String,
               message: String)
  extends WarningTag
  with MessageTag


final case class
InfoMessage(kind: String,
            message: String)
  extends InfoTag
  with MessageTag
