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

@Mode(
  name = "sireum",
  header =
    """
      |Sireum: A Software Analysis Platform (v3)
      |(c) 2011-2015, SAnToS Laboratory, Kansas State University
      |http://sireum.org
    """,
  description = ""
)
final case class SireumOption(pilar: PilarOption = PilarOption())


@Mode(
  name = "pilar",
  header =
    """
      |Pilar: Sireum's Intermediate Representation (IR)
    """,
  description = "Pilar tooling"
)
final case class PilarOption(parser: PilarParserOption = PilarParserOption())


@Main(
  name = "parser",
  header =
    """
      |Pilar Parser
      |... and pretty printer
      |... and JSON serializer/deserializer
    """,
  description = "Pilar parser",
  handlerObject = "org.sireum.pilar.parser.Parser"
)
final case class PilarParserOption(@Opt(shortKey = Some("in"), description = "Use standard input stream")
                                   var standardInput: Boolean = false,

                                   @Opt(shortKey = Some("f"), description = "Output file (if unspecified, use standard output stream)")
                                   var outputFile: Option[String] = None,

                                   @Opt(shortKey = Some("i"), description = "Input mode")
                                   var inputMode: PilarParserOption.InputMode.Type = PilarParserOption.InputMode.Auto,

                                   @Opt(shortKey = Some("o"), description = "Output mode")
                                   var outputMode: PilarParserOption.OutputMode.Type = PilarParserOption.InputMode.JSON,

                                   @Opt(shortKey = Some("a"), description = "Use ANTLR4 Pilar parser instead of hand-written one")
                                   var antlr4: Boolean = false,

                                   @Opt(shortKey = Some("e"), description = "Maximum number of errors found before parsing stop")
                                   var maxErrors: Int = 10,

                                   @Args(name = "file", description = "Input files")
                                   var inputs: ISeq[String] = Vector())

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
