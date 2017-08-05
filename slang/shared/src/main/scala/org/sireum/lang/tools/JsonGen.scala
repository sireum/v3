// #Sireum
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

package org.sireum.lang.tools

import org.sireum._

object JsonGen {

  object Template {

    def stMain(licenseOpt: Option[String],
               packageNames: ISZ[String],
               name: Option[String],
               printers: ISZ[ST],
               parsers: ISZ[ST],
               fromsTos: ISZ[ST]): ST = {
      return st"""// #Sireum
                 |$licenseOpt
                 |${(packageNames, ".")}
                 |
                 |import org.sireum._
                 |import org.sireum.Json.Printer._
                 |
                 |object ${name.getOrElse("JSON")} {
                 |
                 |  object Printer {
                 |
                 |    ${(printers, "\n\n")}
                 |
                 |  }
                 |
                 |  @record Parser(input: String) {
                 |    val parser: Json.Parser = Json.Parser.create(input)
                 |
                 |    ${(parsers, "\n\n")}
                 |
                 |    def eof(): B = {
                 |      val r = parser.eof()
                 |      return r
                 |    }
                 |
                 |    def errorOpt: Option[Json.ErrorMsg] = {
                 |      return parser.errorOpt
                 |    }
                 |
                 |  }
                 |
                 |  def to[T](s: String, f: Parser => T): Either[T, Json.ErrorMsg] = {
                 |    val parser = Parser(s)
                 |    val r = f(parser)
                 |    parser.eof()
                 |    val eOpt = parser.errorOpt
                 |    eOpt match {
                 |      case Some(e) => return Either(None(), Some(e))
                 |      case _ => return Either(Some(r), None())
                 |    }
                 |  }
                 |
                 |  ${(fromsTos, "\n\n")}
                 |
                 |}"""
    }

    def stFrom(name: ST, tpe: ST): ST = {
      return st"""def from$name(o: $tpe) = {
                 |  return Printer.print$name(o).render
                 |}"""
    }

    def stTo(name: ST, tpe: ST): ST = {
      return st"""def to$name(s: String): Either[$tpe, Json.ErrorMsg] = {
                 |  def f$name(parser: Parser): $tpe = {
                 |    var r = parser.parse$name()
                 |    return r
                 |  }
                 |  val r = to(s, f$name)
                 |  return r
                 |}"""
    }

    def stPrintRoot(name: ST, tpe: ST, rootCases: ISZ[ST]): ST = {
      return st"""@pure def print$name(o: $tpe): ST = {
                 |  o match {
                 |    ${(rootCases, "\n")}
                 |  }
                 |}"""
    }

    def stPrintRootCase(name: ST, tpe: ST): ST = {
      return st"case o: $tpe => return print$name(o)"
    }

    def stPrint(name: ST, tpe: ST, fields: ISZ[ST]): ST = {
      return st"""@pure def print$name(o: $tpe): ST = {
                 |  return printObject(ISZ(
                 |    ${(fields, ",\n")}
                 |  ))
                 |}"""
    }

    def stPrintField(fieldName: String, fieldValue: ST): ST = {
      return st"""("$fieldName", $fieldValue)"""
    }

    def stPrintValue(name: ST, fieldName: String): ST = {
      return st"print$name(o.$fieldName)"
    }

    def stPrintEnum(name: ST, tpe: ST, printEnumCases: ISZ[ST]): ST = {
      return st"""@pure def print$name(o: $tpe.Type): ST = {
                 |  val value: String = o match {
                 |    ${(printEnumCases, "\n")}
                 |  }
                 |  return printObject(ISZ(
                 |    ("type", printString("$tpe")),
                 |    ("value", printString(value))
                 |  ))
                 |}"""
    }

    def stPrintEnumCase(elementName: ST, tpe: ST): ST = {
      return st"""case $tpe.$elementName => "$elementName""""
    }

    def stPrintIS(isSimple: B, name: ST,
                  fieldName: String, indexType: String): ST = {
      return st"printIS$indexType(${if (isSimple) "T" else "F"}, o.$fieldName, print$name)"
    }

    def stPrintMS(isSimple: B, name: ST,
                  fieldName: String, indexType: String): ST = {
      return st"printMS$indexType(${if (isSimple) "T" else "F"}, o.$fieldName, print$name)"
    }

    def stPrintOption(name: ST, fieldName: String): ST = {
      return st"printOption(o.$fieldName, print$name)"
    }

    def stPrintMOption(name: ST, fieldName: String): ST = {
      return st"printMOption(o.$fieldName, print$name)"
    }

    def stPrintEither(name0: ST, name1: ST, fieldName: String): ST = {
      return st"printEither(o.$fieldName, print$name0, print$name1)"
    }

    def stPrintMEither(name0: ST, name1: ST, fieldName: String): ST = {
      return st"printMEither(o.$fieldName, print$name0, print$name1)"
    }

    def stParseRoot(name: ST, tpe: ST, children: ISZ[ST], rootCases: ISZ[ST]): ST = {
      return st"""def parse$name(): $tpe = {
                 |  val t = parser.parseObjectTypes(ISZ(${(children, ", ")}))
                 |  t match {
                 |    ${(rootCases, "\n")}
                 |  }
                 |}"""
    }

    def stParseRootCase(name: ST, tpe: ST): ST = {
      return st"""case "$tpe" => val r = parse${name}T(T); return r"""
    }

    def stParse(name: ST, tpe: ST,
                parseFields: ISZ[ST], fieldNames: ISZ[ST]): ST = {
      return st"""def parse$name(): $tpe = {
                 |  val r = parse${name}T(F)
                 |  return r
                 |}
                 |
                 |def parse${name}T(typeParsed: B): $tpe = {
                 |  if (!typeParsed) {
                 |    parser.parseObjectType("$tpe")
                 |  }
                 |  ${(parseFields, "\n")}
                 |  return $tpe(${(fieldNames, ", ")})
                 |}"""
    }

    def stParseField(fieldName: String, parseValue: ST): ST = {
      return st"""parser.parseObjectKey("$fieldName")
                 |val $fieldName = $parseValue
                 |parser.parseObjectNext()"""
    }

    def stParseBuiltInValue(name: ST): ST = {
      return st"parser.parse$name()"
    }

    def stParseValue(name: ST): ST = {
      return st"parse$name()"
    }

    def stParseEnum(name: ST, tpe: ST, parseEnumCases: ISZ[ST]): ST = {
      return st"""def parse$name(): $tpe.Type = {
                 |  val r = parse${name}T(F)
                 |  return r
                 |}
                 |
                 |def parse${name}T(typeParsed: B): $tpe.Type = {
                 |  if (!typeParsed) {
                 |    parser.parseObjectType("$tpe")
                 |  }
                 |  parser.parseObjectKey("value")
                 |  val s = parser.parseString()
                 |  s match {
                 |    ${(parseEnumCases, "\n")}
                 |  }
                 |}"""
    }

    def stParseEnumCase(elementName: String, tpe: ST): ST = {
      return st"""case "$elementName" => return $tpe.$elementName"""
    }

    def stParseIS(indexType: String, parseValue: ST): ST = {
      return st"parser.parseIS$indexType($parseValue)"
    }

    def stParseMS(indexType: String, parseValue: ST): ST = {
      return st"parser.parseMS$indexType($parseValue)"
    }

    def stParseOption(parseValue: ST): ST = {
      return st"parser.parseOption($parseValue)"
    }

    def stParseMOption(parseValue: ST): ST = {
      return st"parser.parseMOption($parseValue)"
    }

    def stParseEither(parseValue0: ST, parseValue1: ST): ST = {
      return st"parser.parseEither($parseValue0, $parseValue1)"
    }

    def stParseMEither(parseValue0: ST, parseValue1: ST): ST = {
      return st"parser.parseMEither($parseValue0, $parseValue1)"
    }

  }

}
