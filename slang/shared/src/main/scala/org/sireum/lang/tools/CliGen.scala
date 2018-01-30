// #Sireum
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
 */

package org.sireum.lang.tools

import org.sireum._

object CliGen {

  @datatype trait CliOpt {
    def name: String

    def description: String

    def header: String
  }

  object CliOpt {

    val tqs: String = "\"\"\""

    @datatype class Group(val name: String,
                          val description: String,
                          val header: String,
                          subs: ISZ[CliOpt]) extends CliOpt

    @datatype class Tool(val name: String,
                         val description: String,
                         val header: String,
                         usage: String,
                         opts: ISZ[Opt],
                         groups: ISZ[OptGroup]) extends CliOpt

    @datatype class OptGroup(name: String,
                             opts: ISZ[Opt])

    @datatype class Opt(name: String,
                        longKey: String,
                        shortKey: Option[C],
                        tpe: Type,
                        description: String)

    @datatype trait Type

    object Type {

      @datatype class Flag(default: B) extends Type

      @datatype class Num(sep: Option[C],
                          default: Z,
                          min: Option[Z],
                          max: Option[Z]) extends Type

      @datatype class NumChoice(sep: Option[C],
                                choices: ISZ[Z]) extends Type

      @datatype class Str(sep: Option[C], default: Option[String]) extends Type

      @datatype class Choice(name: String, sep: Option[C], elements: ISZ[String]) extends Type

      @datatype class Path(multiple: B, default: Option[String]) extends Type

    }

  }

}

import CliGen.CliOpt._

@record class CliGen(firstColumnLimit: Z, secondColumnLimit: Z) {
  var decls: ISZ[ST] = ISZ()
  var parser: ISZ[ST] = ISZ()
  var enumNames: Set[String] = Set.empty

  def gen(licenseOpt: Option[String],
          fileUriOpt: Option[String],
          packageNames: ISZ[String],
          name: String,
          config: Group): ST = {
    val topName = s"${ops.StringOps(config.name).firstToUpper}Option"

    group(topName, config)

    val license: Option[ST] = licenseOpt.map((text: String) =>
      st"""/*
          | $text
          | */
          |""")
    val fileUri: Option[ST] = fileUriOpt.map((text: String) =>
      st"""// This file is auto-generated from $text
          |""")
    val packageName: Option[ST] =
      if (packageNames.nonEmpty) Some(
        st"""package ${(packageNames, ".")}
            |""") else None[ST]()
    val r =
      st"""// #Sireum
          |// @formatter:off
          |
          |$license
          |$fileUri
          |$packageName
          |import org.sireum._
          |
          |object $name {
          |
          |  @datatype trait $topName
          |
          |  @datatype class HelpOption extends $topName
          |
          |  ${(decls, "\n\n")}
          |}
          |
          |import $name._
          |
          |@record class $name(pathSep: C) {
          |
          |  ${(parser, "\n\n")}
          |
          |  def parseArguments(args: ISZ[String], i: Z): ISZ[String] = {
          |    var r = ISZ[String]()
          |    var j = i
          |    while (j < args.size) {
          |      r = r :+ args(j)
          |      j = j + 1
          |    }
          |    return r
          |  }
          |
          |  def parsePaths(args: ISZ[String], i: Z): Option[ISZ[String]] = {
          |    return tokenize(args, i, "path", pathSep, F)
          |  }
          |
          |  def parsePath(args: ISZ[String], i: Z): Option[String] = {
          |    if (i >= args.size) {
          |      eprintln("Expecting a path, but none found.")
          |    }
          |    return Some(args(i))
          |  }
          |
          |  def parseStrings(args: ISZ[String], i: Z, sep: C): Option[ISZ[String]] = {
          |    tokenize(args, i, "string", sep, F) match {
          |      case r@Some(_) => return r
          |      case _ => return None()
          |    }
          |  }
          |
          |  def parseString(args: ISZ[String], i: Z): Option[String] = {
          |    if (i >= args.size) {
          |      eprintln("Expecting a string, but none found.")
          |      return None()
          |    }
          |    return Some(args(i))
          |  }
          |
          |  def parseNums(args: ISZ[String], i: Z, sep: C, minOpt: Option[Z], maxOpt: Option[Z]): Option[ISZ[Z]] = {
          |    tokenize(args, i, "integer", sep, T) match {
          |      case Some(sargs) =>
          |        var r = ISZ[Z]()
          |        for (arg <- sargs) {
          |          parseNumH(arg, minOpt, maxOpt) match {
          |            case Some(n) => r = r :+ n
          |            case _ => return None()
          |          }
          |        }
          |        return Some(r)
          |      case _ => return None()
          |    }
          |  }
          |
          |  def tokenize(args: ISZ[String], i: Z, tpe: String, sep: C, removeWhitespace: B): Option[ISZ[String]] = {
          |    if (i >= args.size) {
          |      eprintln(s"Expecting a sequence of $$tpe separated by '$$sep', but none found.")
          |      return None()
          |    }
          |    val arg = args(i)
          |    return Some(tokenizeH(arg, sep, removeWhitespace))
          |  }
          |
          |  def tokenizeH(arg: String, sep: C, removeWhitespace: B): ISZ[String] = {
          |    val argCis = conversions.String.toCis(arg)
          |    var r = ISZ[String]()
          |    var cis = ISZ[C]()
          |    var j = 0
          |    while (j < argCis.size) {
          |      val c = argCis(j)
          |      if (c == sep) {
          |        r = r :+ conversions.String.fromCis(cis)
          |        cis = ISZ[C]()
          |      } else {
          |        val allowed: B = c match {
          |          case c"\n" => !removeWhitespace
          |          case c" " => !removeWhitespace
          |          case c"\r" => !removeWhitespace
          |          case c"\t" => !removeWhitespace
          |          case _ => T
          |        }
          |        if (allowed) {
          |          cis = cis :+ c
          |        }
          |      }
          |      j = j + 1
          |    }
          |    if (cis.size > 0) {
          |      r = r :+ conversions.String.fromCis(cis)
          |    }
          |    return r
          |  }
          |
          |  def parseNumChoice(args: ISZ[String], i: Z, choices: ISZ[Z]): Option[Z] = {
          |    val set = HashSet.empty[Z].addAll(choices)
          |    parseNum(args, i, None(), None()) match {
          |      case r@Some(n) =>
          |        if (set.contains(n)) {
          |          return r
          |        } else {
          |          eprintln(s"Expecting one of the following: $$set, but found $$n.")
          |          return None()
          |        }
          |      case r => return r
          |    }
          |  }
          |
          |  def parseNum(args: ISZ[String], i: Z, minOpt: Option[Z], maxOpt: Option[Z]): Option[Z] = {
          |    if (i >= args.size) {
          |      eprintln(s"Expecting an integer, but none found.")
          |      return None()
          |    }
          |    return parseNumH(args(i), minOpt, maxOpt)
          |  }
          |
          |  def parseNumH(arg: String, minOpt: Option[Z], maxOpt: Option[Z]): Option[Z] = {
          |    Z(arg) match {
          |      case Some(n) =>
          |        minOpt match {
          |          case Some(min) =>
          |            if (n < min) {
          |              eprintln(s"Expecting an integer at least $$min, but found $$n.")
          |              return None()
          |            }
          |          case _ =>
          |        }
          |        maxOpt match {
          |          case Some(max) =>
          |            if (n > max) {
          |              eprintln(s"Expecting an integer at most $$max, but found $$n.")
          |              return None()
          |            }
          |            return Some(n)
          |          case _ =>
          |        }
          |        return Some(n)
          |      case _ =>
          |        eprintln(s"Expecting an integer, but found '$$arg'.")
          |        return None()
          |    }
          |  }
          |
          |  def select(mode: String, args: ISZ[String], i: Z, choices: ISZ[String]): Option[String] = {
          |    val arg = args(i)
          |    var cs = ISZ[String]()
          |    for (c <- choices) {
          |      if (ops.StringOps(c).startsWith(arg)) {
          |        cs = cs :+ c
          |      }
          |    }
          |    cs.size match {
          |      case z"0" =>
          |        eprintln(s"$$arg is not a mode of $$mode.")
          |        return None()
          |      case z"1" => return Some(cs(0))
          |      case _ =>
          |        eprintln(
          |          st${tqs}Which one of the following modes did you mean by '$$arg'?
          |              |$${(cs, "\n")}$tqs.render)
          |        return None()
          |    }
          |  }
          |}"""
    return r
  }

  def tool(topName: String, c: Tool): Unit = {
    var applyArgs = ISZ[String]("help", "parseArguments(args, j)")
    var params = ISZ[ST](st"help: String", st"args: ISZ[String]")
    var vars = ISZ[ST]()
    for (opt <- c.opts) {
      val (t, init) = tpe(opt.tpe)
      val p = st"${opt.name}: $t"
      applyArgs = applyArgs :+ opt.name
      params = params :+ p
      vars = vars :+ st"var $p = $init"
    }
    for (optg <- c.groups) {
      for (opt <- optg.opts) {
        val (t, init) = tpe(opt.tpe)
        val p = st"${opt.name}: $t"
        applyArgs = applyArgs :+ opt.name
        params = params :+ p
        vars = vars :+ st"var $p = $init"
      }
    }

    val name = ops.StringOps(c.name).firstToUpper

    decls = decls :+
      st"""@datatype class ${name}Option(
          |  ${(params, ",\n")}
          |) extends $topName"""

    val optss = ("|Available Options:", c.opts) +:
      c.groups.map[(String, ISZ[Opt])]((g: OptGroup) => (s"|${g.name} Options:", g.opts))

    var options = ISZ[ST]()
    for (topts <- optss) {

      var triples = ISZ[(String, String, String)]()
      for (opt <- topts._2) {
        val shortKey: String = if (opt.shortKey.isEmpty) "" else s"-${opt.shortKey.get}"
        val longKey: String = s"--${opt.longKey}"
        val desc: String = opt.tpe match {
            case t: Type.Choice =>
              if (t.sep.nonEmpty) st"${opt.description} (expects one or more of { ${(t.elements, ", ")} }; default: ${t.elements(0)})".render
              else st"${opt.description} (expects one of { ${(t.elements, ", ")} }; default: ${t.elements(0)})".render
            case _: Type.Flag => opt.description
            case t: Type.Num =>
              if (t.sep.isEmpty) s"${opt.description} (expects an integer; default is ${t.default})"
              else s"${opt.description} (expects an int-list separated by '${t.sep.get}')"
            case t: Type.NumChoice => st"${opt.description} (expects one of { ${(t.choices, ", ")} })".render
            case t: Type.Path =>
              if (t.multiple) {
                if (t.default.isEmpty) s"${opt.description} (expects paths)"
                else s"""${opt.description} (expects paths; default is "${t.default.get}")"""
              } else {
                if (t.default.isEmpty) s"${opt.description} (expects a path)"
                else s"""${opt.description} (expects a path; default is "${t.default.get}")"""
              }
            case t: Type.Str =>
              if (t.sep.isEmpty) s"${opt.description} (expects a string)"
              else if (t.default.isEmpty) s"""${opt.description} (expects a string separated by "${t.sep.get}")"""
              else s"""${opt.description} (expects a string separated by "${t.sep.get}"; default is "${t.default.get}")"""
        }
        triples = triples :+ ((shortKey, longKey, desc))
      }
      options = options :+
        st"""|
             |${topts._1}
             |${(columnize(triples), "\n")}
             |${columnize(ISZ(("-h", "--help", "Display this information")))}"""
    }

    var cases = ISZ[ST]()

    def optCase(opt: Opt): Unit = {
      val parse: String = opt.tpe match {
        case t: Type.Choice =>
          if (t.sep.nonEmpty) s"parse${ops.StringOps(t.name).firstToUpper}s(args, j + 1)"
          else s"parse${ops.StringOps(t.name).firstToUpper}(args, j + 1)"
        case _: Type.Flag => s"Some(!${opt.name})"
        case t: Type.Num =>
          val r: String = t.sep match {
            case Some(sep) => s"""parseNums(args, j + 1, '$sep', ${t.min}, ${t.max})"""
            case _ => s"parseNum(args, j + 1, ${t.min}, ${t.max})"
          }
          r
        case t: Type.NumChoice => st"""parseNumChoice(args, j + 1, ISZ(z"${(t.choices, "\", z\"")}"))""".render
        case t: Type.Path => if (t.multiple) s"parsePaths(args, j + 1)" else s"parsePath(args, j + 1)"
        case t: Type.Str =>
          val r: String = t.sep match {
            case Some(sep) => s"""parseStrings(args, j + 1, '$sep')"""
            case _ => s"parseString(args, j + 1)"
          }
          r
      }
      val sh: String = if (opt.shortKey.isEmpty) "" else s"""arg == "-${opt.shortKey.get}" || """
      cases = cases :+
        st""" else if (${sh}arg == "--${opt.longKey}") {
            |  val o = $parse
            |  o match {
            |    case Some(v) => ${opt.name} = v
            |    case _ => return None()
            |  }
            |}"""
    }

    for (opt <- c.opts) {
      optCase(opt)
    }
    for (group <- c.groups) {
      for (opt <- group.opts) {
        optCase(opt)
      }
    }

    val inc: (String, String) = if (cases.nonEmpty) ("var j = i", "j = j + 2") else ("val j = i", "")

    parser = parser :+
      st"""def parse$name(args: ISZ[String], i: Z): Option[$topName] = {
          |  val help =
          |    st$tqs${(tokenizeH(c.header, '\n', F), "\n        |")}
          |        |
          |        |Usage: ${c.usage}
          |        ${(options, "\n")}$tqs.render
          |
          |  ${(vars, "\n")}
          |  ${inc._1}
          |  var isOption = T
          |  while (j < args.size && isOption) {
          |    val arg = args(j)
          |    if (arg(0) == '-') {
          |      if (args(j) == "-h" || args(j) == "--help") {
          |        println(help)
          |        return Some(HelpOption())
          |      }$cases else {
          |        eprintln(s"Unrecognized option '$$arg'.")
          |        return None()
          |      }
          |      ${inc._2}
          |    } else {
          |      isOption = F
          |    }
          |  }
          |  return Some(${name}Option(${(applyArgs, ", ")}))
          |}"""
  }

  def choiceEnum(name: String, c: Type.Choice): Unit = {
    if (enumNames.contains(name)) {
      return
    }
    enumNames = enumNames.add(name)
    val elements: ISZ[String] = for (e <- c.elements) yield ops.StringOps(e).firstToUpper
    decls = decls :+
      st"""@enum object $name {
          |  ${(elements.map((e: String) => s"'$e"), "\n")}
          |}"""
    val cases: ISZ[String] = for (e <- c.elements) yield s"""case "$e" => return Some($name.${ops.StringOps(e).firstToUpper})"""
    parser = parser :+
      st"""def parse${name}H(arg: String): Option[$name.Type] = {
          |  arg.native match {
          |    ${(cases, "\n")}
          |    case s =>
          |      eprintln(s"Expecting one of the following: { ${(c.elements, ", ")} }, but found '$$s'.")
          |      return None()
          |  }
          |}"""
    parser = parser :+
      st"""def parse$name(args: ISZ[String], i: Z): Option[$name.Type] = {
          |  if (i >= args.size) {
          |    eprintln("Expecting one of the following: { ${(c.elements, ", ")} }, but none found.")
          |    return None()
          |  }
          |  val r = parse${name}H(args(i))
          |  return r
          |}"""
    if (c.sep.isEmpty) {
      return
    }
    parser = parser :+
      st"""def parse${name}s(args: ISZ[String], i: Z): Option[ISZ[$name.Type]] = {
          |  val tokensOpt = tokenize(args, i, "$name", '${c.sep.get}', T)
          |  if (tokensOpt.isEmpty) {
          |    return None()
          |  }
          |  var r = ISZ[$name.Type]()
          |  for (token <- tokensOpt.get) {
          |    val e = parse${name}H(token)
          |    e match {
          |      case Some(v) => r = r :+ v
          |      case _ => return None()
          |    }
          |  }
          |  return Some(r)
          |}"""
  }


  def group(topName: String, c: Group): Unit = {
    val choices: ISZ[String] = for (sub <- c.subs) yield sub.name
    val choiceCases: ISZ[ST] = for (sub <- c.subs) yield
      st"""case Some(string"${sub.name}") => parse${ops.StringOps(sub.name).firstToUpper}(args, i + 1)"""
    val columns: ISZ[(String, String, String)] = for (sub <- c.subs) yield (sub.name, "", sub.description)
    parser = parser :+
      st"""def parse${ops.StringOps(c.name).firstToUpper}(args: ISZ[String], i: Z): Option[$topName] = {
          |  if (i >= args.size) {
          |    println(
          |      st$tqs${(tokenizeH(c.header, '\n', F), "\n          |")}
          |          |
          |          |Available modes:
          |          ${(columnize(columns), "\n")}$tqs.render
          |    )
          |    return Some(HelpOption())
          |  }
          |  val opt = select("${c.name}", args, i, ISZ("${(choices, "\", \"")}"))
          |  opt match {
          |    ${(choiceCases, "\n")}
          |    case _ => return None()
          |  }
          |}"""

    for (sub <- c.subs) {
      sub match {
        case sub: Group => group(topName, sub)
        case sub: Tool => tool(topName, sub)
      }
    }
  }

  @pure def tpe(c: Type): (String, String) = {
    c match {
      case c: Type.Flag => return ("B", c.default.string)
      case c: Type.Num =>
        c.sep match {
          case Some(_) => return ("ISZ[Z]", s"ISZ()")
          case _ => return ("Z", c.default.string)
        }
      case c: Type.NumChoice => return ("Z", c.choices(0).string)
      case c: Type.Str =>
        c.sep match {
          case Some(_) => return ("ISZ[String]", if (c.default.isEmpty) "ISZ[String]()" else s"""ISZ("${c.default.get}")""")
          case _ => return ("String", if (c.default.isEmpty) "\"\"" else s""""${c.default.get}"""")
        }
      case c: Type.Choice =>
        val name = ops.StringOps(c.name).firstToUpper
        choiceEnum(name, c)
        return if (c.sep.nonEmpty) (s"ISZ[$name.Type]", s"ISZ($name.${ops.StringOps(c.elements(0)).firstToUpper})")
          else (s"$name.Type", s"$name.${ops.StringOps(c.elements(0)).firstToUpper}")
      case c: Type.Path =>
        return if (c.multiple) ("ISZ[String]", if (c.default.isEmpty) "ISZ[String]()" else s"""ISZ("${c.default.get}")""")
          else ("String", if (c.default.isEmpty) "\"\"" else s""""${c.default.get}"""")
    }
  }

  @pure def columnize(args: ISZ[(String, String, String)]): ISZ[String] = {
    var lines = ISZ[String]()

    def line(t: (String, String, String)): Unit = {
      var r: String =
        if (t._1 == "") s"|    ${t._2}"
        else if (t._2 == "") s"|${t._1}   "
        else s"|${t._1}, ${t._2}    "
      if (r.size > firstColumnLimit) {
        lines = lines :+ r
        r = st"|${for (i <- z"0" until firstColumnLimit) yield " "}".render
      } else {
        r = st"$r${for (i <- z"0" until (firstColumnLimit - r.size)) yield " "}".render
      }

      for (token <- tokenizeH(t._3, ' ', F)) {
        if (r.size + token.size + 1 > secondColumnLimit) {
          lines = lines :+ r
          r = st"|${for (i <- z"0" to firstColumnLimit) yield " "}".render
        }
        r = s"$r $token"
      }
      lines = lines :+ r
    }

    for (arg <- args) {
      line(arg)
    }
    return lines
  }

  @pure def tokenizeH(arg: String, sep: C, removeWhitespace: B): ISZ[String] = {
    val argCis = conversions.String.toCis(arg)
    var r = ISZ[String]()
    var cis = ISZ[C]()
    var j = 0
    while (j < argCis.size) {
      val c = argCis(j)
      if (c == sep) {
        r = r :+ conversions.String.fromCis(cis)
        cis = ISZ[C]()
      } else {
        val allowed: B = c match {
          case c"\n" => !removeWhitespace
          case c" " => !removeWhitespace
          case c"\r" => !removeWhitespace
          case c"\t" => !removeWhitespace
          case _ => T
        }
        if (allowed) {
          cis = cis :+ c
        }
      }
      j = j + 1
    }
    if (cis.size > 0) {
      r = r :+ conversions.String.fromCis(cis)
    }
    return r
  }
}
