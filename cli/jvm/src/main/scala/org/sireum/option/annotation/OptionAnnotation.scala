/*
Copyright (c) 2015, Robby, Kansas State University
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

package org.sireum.option.annotation

import scala.annotation.StaticAnnotation
import scala.annotation.meta.getter

sealed trait OptionAnnotation extends StaticAnnotation

sealed trait NamedOptionAnnotation extends OptionAnnotation {
  def name: String
}

sealed trait OptAnnotation extends OptionAnnotation {
  def shortKey: Option[String]

  def description: String
}

sealed trait GroupOptAnnotation extends OptAnnotation {
  def groupName: String
}

sealed trait EnumOptAnnotation {
  def elements: Seq[String]
}

final case class Mode(name: String,
                      header: String,
                      description: String)
  extends NamedOptionAnnotation

final case class Main(name: String,
                      header: String,
                      description: String,
                      handler: String)
  extends NamedOptionAnnotation

@getter
final case class Opt(shortKey: Option[String],
                     description: String)
  extends OptAnnotation

@getter
final case class EnumOpt(shortKey: Option[String],
                         elements: Seq[String],
                         description: String)
  extends OptAnnotation with EnumOptAnnotation

@getter
final case class Opts(shortKey: Option[String],
                      description: String)
  extends OptAnnotation

@getter
final case class GroupOpt(shortKey: Option[String],
                          description: String,
                          groupName: String)
  extends GroupOptAnnotation

@getter
final case class EnumGroupOpt(shortKey: Option[String],
                              elements: Seq[String],
                              description: String,
                              groupName: String)
  extends GroupOptAnnotation with EnumOptAnnotation

@getter
final case class Arg(name: String)
  extends NamedOptionAnnotation
