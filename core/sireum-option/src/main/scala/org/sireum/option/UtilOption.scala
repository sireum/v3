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

package org.sireum.option

import org.sireum.option.annotation._
import org.sireum.util._

import scala.beans.BeanProperty

@Mode(
  name = "util",
  header =
    """
      |Sireum Utility Tooling
    """,
  description = "Utility tooling"
)
final case class UtilOption(@BeanProperty
                            var reflect: UtilReflectOption = UtilReflectOption())

@Mode(
  name = "reflect",
  header =
    """
      |Sireum Reflective Tooling
    """,
  description = "Reflective tooling"
)
final case class UtilReflectOption(@BeanProperty
                                   var cliGen: CliGenOption = CliGenOption(),
                                   @BeanProperty
                                   var jsonGen: JsonGenOption = JsonGenOption(),
                                   @BeanProperty
                                   var rewriterGen: RewriterGenOption = RewriterGenOption())


sealed trait ReflectGenOption {
  def className: String

  def outputDir: OptionBean[String]

  def licenseFile: OptionBean[String]

  def rootClassName: String
}

@Main(
  name = "cli",
  header =
    """
      |Sireum CLI Generator
    """,
  description = "CLI Generator",
  handler = "org.sireum.util.reflect.ReflectGen"
)
final case class CliGenOption(@BeanProperty
                              @Opt(shortKey = Some("c"), description = "Output fully-qualified class name")
                              var className: String = "Cli",
                              @BeanProperty
                              @Opt(shortKey = Some("d"), description = "Output directory\n(If unspecified, use standard output stream)")
                              var outputDir: OptionBean[String] = NoneBean(),
                              @BeanProperty
                              @Opt(shortKey = Some("l"), description = "File containing license for output")
                              var licenseFile: OptionBean[String] = NoneBean(),
                              @BeanProperty
                              @Arg("root-class-name")
                              var rootClassName: String = "")
  extends ReflectGenOption

@Main(
  name = "json",
  header =
    """
      |Sireum JSON Binding Generator
    """,
  description = "JSON Binding Generator",
  handler = "org.sireum.util.reflect.ReflectGen"
)
final case class JsonGenOption(@BeanProperty
                               @Opt(shortKey = Some("c"), description = "Output fully-qualified class name")
                               var className: String = "Json",
                               @BeanProperty
                               @Opt(shortKey = Some("d"), description = "Output directory\n(If unspecified, use standard output stream)")
                               var outputDir: OptionBean[String] = NoneBean(),
                               @Opt(shortKey = Some("l"), description = "File containing license for output")
                               var licenseFile: OptionBean[String] = NoneBean(),
                               @BeanProperty
                               @Arg("root-class-name")
                               var rootClassName: String = "")
  extends ReflectGenOption

@Main(
  name = "rewriter",
  header =
    """
      |Sireum Case Class Rewriter Generator
    """,
  description = "Case Class Rewriter Generator",
  handler = "org.sireum.util.reflect.ReflectGen"
)
final case class RewriterGenOption(@BeanProperty
                                   @Opt(shortKey = Some("c"), description = "Output fully-qualified class name")
                                   var className: String = "Rewriter",
                                   @BeanProperty
                                   @Opt(shortKey = Some("d"), description = "Output directory\n(If unspecified, use standard output stream)")
                                   var outputDir: OptionBean[String] = NoneBean(),
                                   @Opt(shortKey = Some("l"), description = "File containing license for output")
                                   var licenseFile: OptionBean[String] = NoneBean(),
                                   @BeanProperty
                                   @Arg("root-class-name")
                                   var rootClassName: String = "")
  extends ReflectGenOption
