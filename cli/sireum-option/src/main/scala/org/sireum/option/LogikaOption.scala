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

@Main(
  name = "logika",
  header =
    """
      |Sireum Logika -- A Natural Deduction Proof Checker
      |... for Propositional, Predicate, and Programming Logic
    """,
  description = "Logika Proof Checker",
  handler = "org.sireum.logika.ProofChecker"
)
final case class LogikaOption(@BeanProperty
                              @Opt(shortKey = Some("a"), description = "Enable auto mode (programming logic)")
                              var auto: Boolean = false,
                              @BeanProperty
                              @Opt(shortKey = None, description = "Enable sat checking of facts and method contracts")
                              var sat: Boolean = false,
                              @BeanProperty
                              @Opt(shortKey = Some("s"), description = "Sequent matching the propositional/predicate logic input file's")
                              var sequent: OptionBean[String] = none(), @BeanProperty
                              @Opt(shortKey = Some("t"), description = "Timeout for algebra and auto (in milliseconds)")
                              var timeout: Int = 2000,
                              @BeanProperty
                              @Arg(name = "{file.txt, file.scala}")
                              var input: String = "") {
  def this() = this(false, false, none(), 2000, "")
}
