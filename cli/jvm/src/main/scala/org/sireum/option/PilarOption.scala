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
  name = "pilar",
  header =
    """
      |Pilar: Sireum's Intermediate Representation (IR)
    """,
  description = "Pilar tooling"
)
final case class PilarOption(@BeanProperty
                             var parser: PilarParserOption = PilarParserOption()) {
  def this() = this(PilarParserOption())
}


@Main(
  name = "parser",
  header =
    """
      |Pilar Parser
      |... and pretty printer and JSON de/serializer
    """,
  description = "Pilar parser",
  handler = "org.sireum.pilar.parser.Parser"
)
final case class PilarParserOption(@BeanProperty
                                   @Opt(shortKey = Some("in"), description = "Use standard input stream")
                                   var standardInput: Boolean = false,

                                   @BeanProperty
                                   @Opt(shortKey = Some("f"), description = "Output file\n(if unspecified, use standard output stream)")
                                   var outputFile: OptionBean[String] = none(),

                                   @BeanProperty
                                   @EnumOpt(shortKey = Some("i"), elements = Seq("auto", "pilar", "json", "scala"), description = "Input mode")
                                   var inputMode: PilarParserOption.InputMode.Type = PilarParserOption.InputMode.Auto,

                                   @BeanProperty
                                   @EnumOpt(shortKey = Some("o"), elements = Seq("pilar", "json", "scala"), description = "Output mode")
                                   var outputMode: PilarParserOption.OutputMode.Type = PilarParserOption.InputMode.JSON,

                                   @BeanProperty
                                   @Opt(shortKey = Some("a"), description = "Use ANTLR4 Pilar parser instead of hand-written one")
                                   var antlr4: Boolean = false,

                                   @BeanProperty
                                   @Opt(shortKey = Some("e"), description = "Maximum number of errors found before parsing stop")
                                   var maxErrors: Int = 10,

                                   @BeanProperty
                                   @Arg(name = "file")
                                   var inputs: Array[String] = Array()) {
  def this() = this(false, none(), PilarParserOption.InputMode.Auto, PilarParserOption.OutputMode.JSON, false, 10, Array())
}

object PilarParserOption {

  object InputMode extends Enum("") {
    type Type = Value
    val Auto = Value("auto")
    val Pilar = Value("pilar")
    val JSON = Value("json")
    val Scala = Value("scala")
  }

  object OutputMode extends Enum("") {
    type Type = Value
    val Pilar = Value("pilar")
    val JSON = Value("json")
    val Scala = Value("scala")
  }

}
