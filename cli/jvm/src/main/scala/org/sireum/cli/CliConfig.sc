/*
 Copyright (c) 2018, Robby, Kansas State University
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
 */ {

  import org.sireum._
  import org.sireum.cli.CliOpt._

  val logikaTool: Tool = Tool(
    name = "logika",
    command = "logika",
    description = "Logika verifier and proof checker",
    header =
      st"""Sireum/Logika:
          |A Program Verifier and A Natural Deduction Proof Checker
          |... for Propositional, Predicate, and Programming Logics""".render,
    usage = "<option>* <file>+",
    opts = ISZ(
      Opt(name = "formula", longKey = "formula", shortKey = Some('f'),
        tpe = Type.Str(sep = None(), default = None()),
        description = "Formula/sequent matching the truth table/logic input file's"),
      Opt(name = "server", longKey = "server", shortKey = None(),
        tpe = Type.Flag(F), description = "Enable server mode")
    ),
    groups = ISZ(
      OptGroup(name = "Programming Logic", opts = ISZ(
        Opt(name = "auto", longKey = "auto", shortKey = Some('a'),
          tpe = Type.Flag(F), description = "Enable auto mode"),
        Opt(name = "bitwidth", longKey = "bitwidth", shortKey = Some('b'),
          tpe = Type.NumChoice(sep = None(), choices = ISZ(0, 8, 16, 32, 64)),
          description = "Default integer bit-width for symbolic execution & translation"),
        Opt(name = "c", longKey = "c", shortKey = None(),
          tpe = Type.Path(multiple = F, default = None()),
          description = "File/directory path for C translation"),
        Opt(name = "compare", longKey = "compare", shortKey = None(),
          tpe = Type.Flag(F), description = "Compare well-formed input program files (sans contracts/prints)"),
        Opt(name = "last", longKey = "last", shortKey = Some('l'),
          tpe = Type.Flag(F), description = "Check last program only"),
        Opt(name = "run", longKey = "run", shortKey = None(),
          tpe = Type.Flag(F), description = "Run input program file(s)"),
        Opt(name = "sat", longKey = "sat", shortKey = None(),
          tpe = Type.Flag(F), description = "Enable sat checking of facts and contracts"),
        Opt(name = "symexe", longKey = "symexe", shortKey = Some('x'),
          tpe = Type.Flag(F), description = "Enable symbolic execution"),
        Opt(name = "timeout", longKey = "timeout", shortKey = Some('t'),
          tpe = Type.Num(sep = None(), default = 1000, min = Some(1000), max = None()),
          description = "Timeout for algebra and auto (in milliseconds)"))
      ),
      OptGroup(name = "Symbol Conversion", opts = ISZ(
        Opt(name = "ascii", longKey = "ascii", shortKey = None(),
          tpe = Type.Flag(F), description = "Convert to ASCII"),
        Opt(name = "unicode", longKey = "unicode", shortKey = None(),
          tpe = Type.Flag(F), description = "Convert to Unicode"))
      )
    )
  )

  val awasTool: Tool = Tool(
    name = "awas",
    command = "awas",
    description = "Generate Awas from AADL model",
    header = "Awas generator",
    usage = "??",
    opts = ISZ(),
    groups = ISZ()
  )

  val aadlGroup: Group = Group(
    name = "aadl",
    description = "AADL Tools",
    header = "Sireum AADL Tools",
    unlisted = F,
    subs = ISZ(awasTool)
  )

  val xGroup: Group = Group(
    name = "x",
    description = "Experimental Tools",
    header = "Sireum Experimental Tools",
    unlisted = T,
    subs = ISZ(aadlGroup, org.sireum.lang.cli.group)
  )
  val mainGroup: Group = Group(
    name = "sireum",
    description = "",
    header =
      st"""Sireum: A Software Analysis Platform (v3)
          |(c) 2018, SAnToS Laboratory, Kansas State University""".render,
    unlisted = F,
    subs = ISZ(logikaTool, xGroup)
  )

  mainGroup

}
