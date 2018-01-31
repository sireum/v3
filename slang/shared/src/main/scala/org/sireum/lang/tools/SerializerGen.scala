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
import org.sireum.ops._
import org.sireum.lang.{ast => AST}
import org.sireum.lang.symbol.Resolver._
import org.sireum.lang.util._

object SerializerGen {

  @enum object Mode {
    'JSON
    'MessagePack
  }

  @datatype trait Template {
    @pure def main(licenseOpt: Option[String],
                   fileUriOpt: Option[String],
                   packageNames: ISZ[String],
                   name: Option[String],
                   constants: ISZ[ST],
                   printers: ISZ[ST],
                   parsers: ISZ[ST],
                   fromsTos: ISZ[ST]): ST

    @pure def from(name: ST, tpe: ST): ST

    @pure def to(name: ST, tpe: ST): ST

    @pure def printRoot(name: ST, tpe: ST, printRootCases: ISZ[ST]): ST

    @pure def printRootCase(name: ST, tpe: ST): ST

    @pure def printObject(name: ST, tpe: ST, printFields: ISZ[ST]): ST

    @pure def printField(fieldName: String, fieldValue: ST): ST

    @pure def printValue(name: ST, fieldName: String): ST

    @pure def printEnum(name: ST, tpe: ST, printEnumCases: ISZ[ST]): ST

    @pure def printEnumCase(elementName: String, tpe: ST): ST

    @pure def printIS(isSimple: B, name: ST,
                      fieldName: String, indexType: String): ST

    @pure def printMS(isSimple: B, name: ST,
                      fieldName: String, indexType: String): ST

    @pure def printOption(name: ST, fieldName: String): ST

    @pure def printMOption(name: ST, fieldName: String): ST

    @pure def printEither(name0: ST, name1: ST, fieldName: String): ST

    @pure def printMEither(name0: ST, name1: ST, fieldName: String): ST

    @pure def parseRoot(name: ST, tpe: ST,
                        childrenTpes: ISZ[ST],
                        parseRootCases: ISZ[ST]): ST

    @pure def parseRootCase(name: ST, tpe: ST): ST

    @pure def parseObject(name: ST, tpe: ST,
                          parseFields: ISZ[ST],
                          fieldNames: ISZ[String]): ST

    @pure def parseField(fieldName: String, parseValue: ST): ST

    @pure def parseBuiltIn(suffixes: ISZ[ST]): ST

    @pure def parseValue(suffixes: ISZ[ST]): ST

    @pure def parseEnum(name: ST, tpe: ST, parseEnumCases: ISZ[ST]): ST

    @pure def parseEnumCase(elementName: String, tpe: ST): ST

    @pure def parseIS(indexType: String, parseValue: ST): ST

    @pure def parseMS(indexType: String, parseValue: ST): ST

    @pure def parseOption(parseValue: ST): ST

    @pure def parseMOption(parseValue: ST): ST

    @pure def parseEither(parseValue0: ST, parseValue1: ST): ST

    @pure def parseMEither(parseValue0: ST, parseValue1: ST): ST
  }

  @datatype class JsonTemplate extends Template {

    @pure def main(licenseOpt: Option[String],
                   fileUriOpt: Option[String],
                   packageNames: ISZ[String],
                   name: Option[String],
                   constants: ISZ[ST],
                   printers: ISZ[ST],
                   parsers: ISZ[ST],
                   fromsTos: ISZ[ST]): ST = {
      val license: Option[ST] = licenseOpt.map((text: String) =>
        st"""/*
            | $text
            | */
            |""")
      val fileUri: Option[ST] = fileUriOpt.map((text: String) =>
        st"""// This file is auto-generated from $text
            |""")
      val packageName: Option[ST] =
        if (packageNames.nonEmpty) Some( st"""package ${(packageNames, ".")}
                                             |""") else None[ST]()
      return st"""// #Sireum
                 |// @formatter:off
                 |
                 |$license
                 |$fileUri
                 |$packageName
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
                 |  @record class Parser(input: String) {
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
                 |  def to[T](s: String, f: Parser => T): T = {
                 |    val parser = Parser(s)
                 |    val r = f(parser)
                 |    parser.eof()
                 |    return r
                 |  }
                 |
                 |  ${(fromsTos, "\n\n")}
                 |
                 |}"""
    }

    @pure def from(name: ST, tpe: ST): ST = {
      return st"""def from$name(o: $tpe, isCompact: B): String = {
                 |  val st = Printer.print$name(o)
                 |  if (isCompact) {
                 |    return st.renderCompact
                 |  } else {
                 |    return st.render
                 |  }
                 |}"""
    }

    @pure def to(name: ST, tpe: ST): ST = {
      return st"""def to$name(s: String): $tpe = {
                 |  def f$name(parser: Parser): $tpe = {
                 |    val r = parser.parse$name()
                 |    return r
                 |  }
                 |  val r = to(s, f$name)
                 |  return r
                 |}"""
    }

    @pure def printRoot(name: ST, tpe: ST, printRootCases: ISZ[ST]): ST = {
      return st"""@pure def print$name(o: $tpe): ST = {
                 |  o match {
                 |    ${(printRootCases, "\n")}
                 |  }
                 |}"""
    }

    @pure def printRootCase(name: ST, tpe: ST): ST = {
      return st"case o: $tpe => return print$name(o)"
    }

    @pure def printObject(name: ST, tpe: ST, printFields: ISZ[ST]): ST = {
      val fqs = "\"\"\"\""
      return st"""@pure def print$name(o: $tpe): ST = {
                 |  return printObject(ISZ(
                 |    ${(printField("type", st"st$fqs$tpe$fqs") +: printFields, ",\n")}
                 |  ))
                 |}"""
    }

    @pure def printField(fieldName: String, fieldValue: ST): ST = {
      return st"""("$fieldName", $fieldValue)"""
    }

    @pure def printValue(name: ST, fieldName: String): ST = {
      return st"print$name(o.$fieldName)"
    }

    @pure def printEnum(name: ST, tpe: ST, printEnumCases: ISZ[ST]): ST = {
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

    @pure def printEnumCase(elementName: String, tpe: ST): ST = {
      return st"""case $tpe.$elementName => "$elementName""""
    }

    @pure def printIS(isSimple: B, name: ST,
                      fieldName: String, indexType: String): ST = {
      return st"printIS$indexType(${if (isSimple) "T" else "F"}, o.$fieldName, print$name)"
    }

    @pure def printMS(isSimple: B, name: ST,
                      fieldName: String, indexType: String): ST = {
      return st"printMS$indexType(${if (isSimple) "T" else "F"}, o.$fieldName, print$name)"
    }

    @pure def printOption(name: ST, fieldName: String): ST = {
      return st"printOption(o.$fieldName, print$name)"
    }

    @pure def printMOption(name: ST, fieldName: String): ST = {
      return st"printMOption(o.$fieldName, print$name)"
    }

    @pure def printEither(name0: ST, name1: ST, fieldName: String): ST = {
      return st"printEither(o.$fieldName, print$name0, print$name1)"
    }

    @pure def printMEither(name0: ST, name1: ST, fieldName: String): ST = {
      return st"printMEither(o.$fieldName, print$name0, print$name1)"
    }

    @pure def parseRoot(name: ST, tpe: ST, childrenTpes: ISZ[ST], parseRootCases: ISZ[ST]): ST = {
      return st"""def parse$name(): $tpe = {
                 |  val t = parser.parseObjectTypes(ISZ("${(childrenTpes, "\", \"")}"))
                 |  t.native match {
                 |    ${(parseRootCases, "\n")}
                 |    case _ => halt(parser.errorMessage)
                 |  }
                 |}"""
    }

    @pure def parseRootCase(name: ST, tpe: ST): ST = {
      return st"""case "$tpe" => val r = parse${name}T(T); return r"""
    }

    @pure def parseObject(name: ST, tpe: ST,
                          parseFields: ISZ[ST], fieldNames: ISZ[String]): ST = {
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

    @pure def parseField(fieldName: String, parseValue: ST): ST = {
      return st"""parser.parseObjectKey("$fieldName")
                 |val $fieldName = $parseValue
                 |parser.parseObjectNext()"""
    }

    @pure def parseBuiltIn(suffixes: ISZ[ST]): ST = {
      return st"parser.parse$suffixes"
    }

    @pure def parseValue(suffixes: ISZ[ST]): ST = {
      return st"parse$suffixes"
    }

    @pure def parseEnum(name: ST, tpe: ST, parseEnumCases: ISZ[ST]): ST = {
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
                 |  parser.parseObjectNext()
                 |  s.native match {
                 |    ${(parseEnumCases, "\n")}
                 |    case _ => halt(parser.errorMessage)
                 |  }
                 |}"""
    }

    @pure def parseEnumCase(elementName: String, tpe: ST): ST = {
      return st"""case "$elementName" => return $tpe.$elementName"""
    }

    @pure def parseIS(indexType: String, parseValue: ST): ST = {
      return st"parser.parseIS$indexType($parseValue _)"
    }

    @pure def parseMS(indexType: String, parseValue: ST): ST = {
      return st"parser.parseMS$indexType($parseValue _)"
    }

    @pure def parseOption(parseValue: ST): ST = {
      return st"parser.parseOption($parseValue _)"
    }

    @pure def parseMOption(parseValue: ST): ST = {
      return st"parser.parseMOption($parseValue _)"
    }

    @pure def parseEither(parseValue0: ST, parseValue1: ST): ST = {
      return st"parser.parseEither($parseValue0 _, $parseValue1 _)"
    }

    @pure def parseMEither(parseValue0: ST, parseValue1: ST): ST = {
      return st"parser.parseMEither($parseValue0 _, $parseValue1 _)"
    }
  }

  @datatype class MessagePackTemplate extends Template {
    @pure def main(licenseOpt: Option[String],
                   fileUriOpt: Option[String],
                   packageNames: ISZ[String],
                   name: Option[String],
                   constants: ISZ[ST],
                   writers: ISZ[ST],
                   readers: ISZ[ST],
                   fromsTos: ISZ[ST]): ST = {
      val license: Option[ST] = licenseOpt.map((text: String) =>
        st"""/*
            | $text
            | */
            |""")
      val fileUri: Option[ST] = fileUriOpt.map((text: String) =>
        st"""// This file is auto-generated from $text
            |""")
      val packageName: Option[ST] =
        if (packageNames.nonEmpty) Some( st"""package ${(packageNames, ".")}
                                             |""") else None[ST]()
      return st"""// #Sireum
                 |// @formatter:off
                 |
                 |$license
                 |$fileUri
                 |$packageName
                 |import org.sireum._
                 |
                 |object ${name.getOrElse("MsgPack")} {
                 |
                 |  object Constants {
                 |
                 |    ${(constants, "\n\n")}
                 |
                 |  }
                 |
                 |  object Writer {
                 |
                 |    @record class Default(val writer: MessagePack.Writer) extends Writer
                 |
                 |  }
                 |
                 |  @msig trait Writer {
                 |
                 |    def writer: MessagePack.Writer
                 |
                 |    ${(writers, "\n\n")}
                 |
                 |    def writeB(b: B): Unit = {
                 |      writer.writeB(b)
                 |    }
                 |
                 |    def writeC(c: C): Unit = {
                 |      writer.writeC(c)
                 |    }
                 |
                 |    def writeZ(n: Z): Unit = {
                 |      writer.writeZ(n)
                 |    }
                 |
                 |    def writeZ8(n: Z8): Unit = {
                 |      writer.writeZ8(n)
                 |    }
                 |
                 |    def writeZ16(n: Z16): Unit = {
                 |      writer.writeZ16(n)
                 |    }
                 |
                 |    def writeZ32(n: Z32): Unit = {
                 |      writer.writeZ32(n)
                 |    }
                 |
                 |    def writeZ64(n: Z64): Unit = {
                 |      writer.writeZ64(n)
                 |    }
                 |
                 |    def writeN(n: N): Unit = {
                 |      writer.writeN(n)
                 |    }
                 |
                 |    def writeN8(n: N8): Unit = {
                 |      writer.writeN8(n)
                 |    }
                 |
                 |    def writeN16(n: N16): Unit = {
                 |      writer.writeN16(n)
                 |    }
                 |
                 |    def writeN32(n: N32): Unit = {
                 |      writer.writeN32(n)
                 |    }
                 |
                 |    def writeN64(n: N64): Unit = {
                 |      writer.writeN64(n)
                 |    }
                 |
                 |    def writeS8(n: S8): Unit = {
                 |      writer.writeS8(n)
                 |    }
                 |
                 |    def writeS16(n: S16): Unit = {
                 |      writer.writeS16(n)
                 |    }
                 |
                 |    def writeS32(n: S32): Unit = {
                 |      writer.writeS32(n)
                 |    }
                 |
                 |    def writeS64(n: S64): Unit = {
                 |      writer.writeS64(n)
                 |    }
                 |
                 |    def writeU8(n: U8): Unit = {
                 |      writer.writeU8(n)
                 |    }
                 |
                 |    def writeU16(n: U16): Unit = {
                 |      writer.writeU16(n)
                 |    }
                 |
                 |    def writeU32(n: U32): Unit = {
                 |      writer.writeU32(n)
                 |    }
                 |
                 |    def writeU64(n: U64): Unit = {
                 |      writer.writeU64(n)
                 |    }
                 |
                 |    def writeR(n: R): Unit = {
                 |      writer.writeR(n)
                 |    }
                 |
                 |    def writeF32(n: F32): Unit = {
                 |      writer.writeF32(n)
                 |    }
                 |
                 |    def writeF64(n: F64): Unit = {
                 |      writer.writeF64(n)
                 |    }
                 |
                 |    def writeString(s: String): Unit = {
                 |      writer.writeString(s)
                 |    }
                 |
                 |    def result: ISZ[U8] = {
                 |      return writer.result
                 |    }
                 |
                 |  }
                 |
                 |  object Reader {
                 |
                 |    @record class Default(val reader: MessagePack.Reader) extends Reader
                 |
                 |  }
                 |
                 |  @msig trait Reader {
                 |
                 |    def reader: MessagePack.Reader
                 |
                 |    ${(readers, "\n\n")}
                 |
                 |  }
                 |
                 |  def to[T](data: ISZ[U8], f: Reader => T): T = {
                 |    val rd = Reader.Default(MessagePack.reader(data))
                 |    rd.reader.init()
                 |    val r = f(rd)
                 |    return r
                 |  }
                 |
                 |  ${(fromsTos, "\n\n")}
                 |
                 |}"""
    }

    @pure def from(name: ST, tpe: ST): ST = {
      return st"""def from$name(o: $tpe, poolString: B): ISZ[U8] = {
                 |  val w = Writer.Default(MessagePack.writer(poolString))
                 |  w.write$name(o)
                 |  return w.result
                 |}"""
    }

    @pure def to(name: ST, tpe: ST): ST = {
      return st"""def to$name(data: ISZ[U8]): $tpe = {
                 |  def f$name(reader: Reader): $tpe = {
                 |    val r = reader.read$name()
                 |    return r
                 |  }
                 |  val r = to(data, f$name)
                 |  return r
                 |}"""
    }

    @pure def printRoot(name: ST, tpe: ST, printRootCases: ISZ[ST]): ST = {
      return st"""def write$name(o: $tpe): Unit = {
                 |  o match {
                 |    ${(printRootCases, "\n")}
                 |  }
                 |}"""
    }

    @pure def printRootCase(name: ST, tpe: ST): ST = {
      return st"case o: $tpe => write$name(o)"
    }

    @pure def printObject(name: ST, tpe: ST, printFields: ISZ[ST]): ST = {
      return st"""def write$name(o: $tpe): Unit = {
                 |  writer.writeZ(Constants.$name)
                 |  ${(printFields, "\n")}
                 |}"""
    }

    @pure def printField(fieldName: String, fieldValue: ST): ST = {
      return fieldValue
    }

    @pure def printValue(name: ST, fieldName: String): ST = {
      return st"write$name(o.$fieldName)"
    }

    @pure def printEnum(name: ST, tpe: ST, printEnumCases: ISZ[ST]): ST = {
      return st"""def write$name(o: $tpe.Type): Unit = {
                 |  writer.writeZ(o.ordinal)
                 |}"""
    }

    @pure def printEnumCase(elementName: String, tpe: ST): ST = {
      return st""
    }

    @pure def printIS(isSimple: B, name: ST,
                      fieldName: String, indexType: String): ST = {
      return st"writer.writeIS$indexType(o.$fieldName, write$name)"
    }

    @pure def printMS(isSimple: B, name: ST,
                      fieldName: String, indexType: String): ST = {
      return st"writer.writeMS$indexType(o.$fieldName, write$name)"
    }

    @pure def printOption(name: ST, fieldName: String): ST = {
      return st"writer.writeOption(o.$fieldName, write$name)"
    }

    @pure def printMOption(name: ST, fieldName: String): ST = {
      return st"writer.writeMOption(o.$fieldName, write$name)"
    }

    @pure def printEither(name0: ST, name1: ST, fieldName: String): ST = {
      return st"writer.writeEither(o.$fieldName, write$name0, write$name1)"
    }

    @pure def printMEither(name0: ST, name1: ST, fieldName: String): ST = {
      return st"writer.writeMEither(o.$fieldName, write$name0, write$name1)"
    }

    @pure def parseRoot(name: ST, tpe: ST, childrenTpes: ISZ[ST], parseRootCases: ISZ[ST]): ST = {
      return st"""def read$name(): $tpe = {
                 |  val t = reader.readZ()
                 |  t match {
                 |    ${(parseRootCases, "\n")}
                 |    case _ => halt(s"Unexpected type code $$t.")
                 |  }
                 |}"""
    }

    @pure def parseRootCase(name: ST, tpe: ST): ST = {
      return st"""case Constants.$name => val r = read${name}T(T); return r"""
    }

    @pure def parseObject(name: ST, tpe: ST,
                          parseFields: ISZ[ST], fieldNames: ISZ[String]): ST = {
      return st"""def read$name(): $tpe = {
                 |  val r = read${name}T(F)
                 |  return r
                 |}
                 |
                 |def read${name}T(typeParsed: B): $tpe = {
                 |  if (!typeParsed) {
                 |    reader.expectZ(Constants.$name)
                 |  }
                 |  ${(parseFields, "\n")}
                 |  return $tpe(${(fieldNames, ", ")})
                 |}"""
    }

    @pure def parseField(fieldName: String, parseValue: ST): ST = {
      return st"""val $fieldName = $parseValue"""
    }

    @pure def parseBuiltIn(suffixes: ISZ[ST]): ST = {
      return st"reader.read$suffixes"
    }

    @pure def parseValue(suffixes: ISZ[ST]): ST = {
      return st"read$suffixes"
    }

    @pure def parseEnum(name: ST, tpe: ST, parseEnumCases: ISZ[ST]): ST = {
      return st"""def read$name(): $tpe.Type = {
                 |  val r = reader.readZ()
                 |  return $tpe.byOrdinal(r).get
                 |}"""
    }

    @pure def parseEnumCase(elementName: String, tpe: ST): ST = {
      return st""
    }

    @pure def parseIS(indexType: String, parseValue: ST): ST = {
      return st"reader.readIS$indexType($parseValue _)"
    }

    @pure def parseMS(indexType: String, parseValue: ST): ST = {
      return st"reader.readMS$indexType($parseValue _)"
    }

    @pure def parseOption(parseValue: ST): ST = {
      return st"reader.readOption($parseValue _)"
    }

    @pure def parseMOption(parseValue: ST): ST = {
      return st"reader.readMOption($parseValue _)"
    }

    @pure def parseEither(parseValue0: ST, parseValue1: ST): ST = {
      return st"reader.readEither($parseValue0 _, $parseValue1 _)"
    }

    @pure def parseMEither(parseValue0: ST, parseValue1: ST): ST = {
      return st"reader.readMEither($parseValue0 _, $parseValue1 _)"
    }

  }

  val jsonGenKind: String = "JsonGen"

  @record class Gen(mode: Mode.Type,
                    globalNameMap: NameMap,
                    globalTypeMap: TypeMap,
                    packageName: QName,
                    reporter: Reporter) {

    val globalTypes: ISZ[TypeInfo] = sortedGlobalTypes(globalTypeMap)
    val poset: Poset[QName] = typePoset(globalTypeMap, globalTypes, reporter)

    var constants: ISZ[ST] = ISZ()
    var parsers: ISZ[ST] = ISZ()
    var printers: ISZ[ST] = ISZ()
    var fromsTos: ISZ[ST] = ISZ()

    val template: Template = mode match {
      case Mode.JSON => JsonTemplate()
      case Mode.MessagePack => MessagePackTemplate()
    }

    def gen(licenseOpt: Option[String],
            fileUriOpt: Option[String],
            name: Option[String]): ST = {
      for (ti <- globalTypes) {
        ti match {
          case ti: TypeInfo.AbstractDatatype => genAdt(ti)
          case ti: TypeInfo.Sig => genRoot(ti.name)
          case ti: TypeInfo.Enum => genEnum(ti)
          case _ =>
        }
      }
      return template.main(licenseOpt, fileUriOpt, packageName, name, constants, printers, parsers, fromsTos)
    }

    def genEnum(ti: TypeInfo.Enum): Unit = {
      val enumTypeString = typeNameString(packageName, ti.name)
      val enumTypeName = typeName(packageName, ti.name)
      printers = printers :+
        template.printEnum(enumTypeName, enumTypeString,
          for (e <- ti.elements.elements)
            yield template.printEnumCase(e, enumTypeString))
      parsers = parsers :+
        template.parseEnum(enumTypeName, enumTypeString,
          for (e <- ti.elements.elements)
            yield template.parseEnumCase(e, enumTypeString))
    }

    def genAdt(ti: TypeInfo.AbstractDatatype): Unit = {
      if (ti.ast.isRoot) {
        genRoot(ti.name)
      } else {
        val adTypeString = typeNameString(packageName, ti.name)
        val adTypeName = typeName(packageName, ti.name)
        var fieldNames = ISZ[String]()
        var printFields = ISZ[ST]()
        var parseFields = ISZ[ST]()
        for (param <- ti.ast.params) {
          param.tipe match {
            case tipe: AST.Type.Named =>
              val fieldName = param.id.value
              fieldNames = fieldNames :+ fieldName
              printFields = printFields :+ printField(ti, fieldName, tipe)
              parseFields = parseFields :+ parseField(ti, fieldName, tipe)
            case _ => reporter.error(param.id.attr.posOpt, jsonGenKind, s"Only named types are supported for @datatype/@record fields.")
          }
        }
        if (mode == Mode.MessagePack) {
          constants = constants :+ st"""val $adTypeName: Z = ${constants.size}"""
        }
        printers = printers :+ template.printObject(adTypeName, adTypeString, printFields)
        parsers = parsers :+ template.parseObject(adTypeName, adTypeString, parseFields, fieldNames)
        fromsTos = fromsTos :+ template.from(adTypeName, adTypeString) :+ template.to(adTypeName, adTypeString)
      }
    }

    def genRoot(name: QName): Unit = {
      val rootTypeString = typeNameString(packageName, name)
      val rootTypeName = typeName(packageName, name)
      var rootPrintCases = ISZ[ST]()
      var rootParseCases = ISZ[ST]()
      var childrenTypeStrings = ISZ[ST]()
      val descendants = poset.descendantsOf(name).elements
      val sortedDescendants: ISZ[TypeInfo] = {
        var r = ISZ[TypeInfo]()
        for (d <- descendants) {
          globalTypeMap.get(d) match {
            case Some(info) => r = r :+ info
            case _ =>
          }
        }
        ISZOps(r).sortWith(ltTypeInfo)
      }
      for (child <- sortedDescendants) {
        child match {
          case childTI: TypeInfo.AbstractDatatype if !childTI.ast.isRoot =>
            val childIds = childTI.name
            val childTypeString = typeNameString(packageName, childIds)
            val childTypeName = typeName(packageName, childIds)
            childrenTypeStrings = childrenTypeStrings :+ childTypeString
            rootPrintCases = rootPrintCases :+ template.printRootCase(childTypeName, childTypeString)
            rootParseCases = rootParseCases :+ template.parseRootCase(childTypeName, childTypeString)
          case _ =>
        }
      }
      printers = printers :+ template.printRoot(rootTypeName, rootTypeString, rootPrintCases)
      parsers = parsers :+ template.parseRoot(rootTypeName, rootTypeString, childrenTypeStrings, rootParseCases)
      fromsTos = fromsTos :+ template.from(rootTypeName, rootTypeString) :+ template.to(rootTypeName, rootTypeString)
    }

    def printField(ti: TypeInfo.AbstractDatatype, fieldName: String, tipe: AST.Type.Named): ST = {
      val v = printValue(ti, fieldName, tipe)
      return template.printField(fieldName, v)
    }

    def printValue(ti: TypeInfo.AbstractDatatype, fieldName: String, tipe: AST.Type.Named): ST = {
      val sOpt = s(ti, tipe)
      sOpt match {
        case Some((isImmutable, indexType, (isSimple, elementName))) =>
          if (isImmutable) {
            return template.printIS(isSimple, elementName, fieldName, indexType)
          } else {
            return template.printMS(isSimple, elementName, fieldName, indexType)
          }
        case _ =>
      }
      val optOpt = opt(ti, tipe)
      optOpt match {
        case Some((isImmutable, (_, elementName))) =>
          if (isImmutable) {
            return template.printOption(elementName, fieldName)
          } else {
            return template.printMOption(elementName, fieldName)
          }
        case _ =>
      }
      val eitherOpt = either(ti, tipe)
      eitherOpt match {
        case Some((isImmutable, (_, e0), (_, e1))) =>
          if (isImmutable) {
            return template.printEither(e0, e1, fieldName)
          } else {
            return template.printMEither(e0, e1, fieldName)
          }
        case _ =>
      }
      val p = basicOrTypeName(ti, tipe)
      template.printValue(p._2, fieldName)
    }

    def parseField(ti: TypeInfo.AbstractDatatype, fieldName: String, tipe: AST.Type.Named): ST = {
      val v = parseValue(ti, tipe)
      return template.parseField(fieldName, v)
    }

    def parseValue(ti: TypeInfo.AbstractDatatype, tipe: AST.Type.Named): ST = {
      val sOpt = s(ti, tipe)
      sOpt match {
        case Some((isImmutable, indexType, (isSimple, elementName))) =>
          val pe: ST =
            if (isSimple) template.parseBuiltIn(ISZ(elementName))
            else template.parseValue(ISZ(elementName))
          if (isImmutable) {
            return template.parseIS(indexType, pe)
          } else {
            return template.parseMS(indexType, pe)
          }
        case _ =>
      }
      val optOpt = opt(ti, tipe)
      optOpt match {
        case Some((isImmutable, (isSimple, elementName))) =>
          val pe: ST =
            if (isSimple) template.parseBuiltIn(ISZ(elementName))
            else template.parseValue(ISZ(elementName))
          if (isImmutable) {
            return template.parseOption(pe)
          } else {
            return template.parseMOption(pe)
          }
        case _ =>
      }
      val eitherOpt = either(ti, tipe)
      eitherOpt match {
        case Some((isImmutable, (isSimple0, e0), (isSimple1, e1))) =>
          val pe0: ST =
            if (isSimple0) template.parseBuiltIn(ISZ(e0))
            else template.parseValue(ISZ(e0))
          val pe1: ST =
            if (isSimple1) template.parseBuiltIn(ISZ(e1))
            else template.parseValue(ISZ(e1))
          if (isImmutable) {
            return template.parseEither(pe0, pe1)
          } else {
            return template.parseMEither(pe0, pe1)
          }
        case _ =>
      }
      val p = basicOrTypeName(ti, tipe)
      if (p._1) {
        return template.parseBuiltIn(ISZ(p._2, st"()"))
      } else {
        return template.parseValue(ISZ(p._2, st"()"))
      }
    }

    def either(ti: TypeInfo.AbstractDatatype, tipe: AST.Type.Named): Option[(B, (B, ST), (B, ST))] = {
      if (!(tipe.name.ids.size == 1 && tipe.typeArgs.size == 2)) {
        return None()
      }
      val name = tipe.name.ids(0).value
      name.native match {
        case "Either" =>
          val btn0 = basicOrTypeName(ti, tipe.typeArgs(0))
          val btn1 = basicOrTypeName(ti, tipe.typeArgs(1))
          return Some((T, btn0, btn1))
        case "MEither" =>
          val btn0 = basicOrTypeName(ti, tipe.typeArgs(0))
          val btn1 = basicOrTypeName(ti, tipe.typeArgs(1))
          return Some((T, btn0, btn1))
      }
    }

    def opt(ti: TypeInfo.AbstractDatatype, tipe: AST.Type.Named): Option[(B, (B, ST))] = {
      if (!(tipe.name.ids.size == 1 && tipe.typeArgs.size == 1)) {
        return None()
      }
      val name = tipe.name.ids(0).value
      name.native match {
        case "Option" =>
          val btn = basicOrTypeName(ti, tipe.typeArgs(0))
          return Some((T, btn))
        case "MOption" =>
          val btn = basicOrTypeName(ti, tipe.typeArgs(0))
          return Some((F, btn))
      }
    }

    def s(ti: TypeInfo.AbstractDatatype, tipe: AST.Type.Named): Option[(B, String, (B, ST))] = {
      if (!(tipe.name.ids.size == 1 && (tipe.typeArgs.size == 1 || tipe.typeArgs.size == 2))) {
        return None()
      }
      val name = tipe.name.ids(0).value
      if (name == "IS" || name == "MS") {
        val isImmutable = name == "IS"
        val et = tipe.typeArgs(1)
        val btn = basicOrTypeName(ti, et)
        (basic(tipe.typeArgs(0)), basic(et)) match {
          case (Some(it), Some(_)) => return Some((isImmutable, it, btn))
          case (Some(it), _) => return Some((isImmutable, it, btn))
          case _ => return None()
        }
      }
      val btn = basicOrTypeName(ti, tipe.typeArgs(0))
      name.native match {
        case "ISZ" => return Some((T, "Z", btn))
        case "MSZ" => return Some((F, "Z", btn))
        case _ => return None()
      }
    }

    def basicOrTypeName(ti: TypeInfo.AbstractDatatype, tipe: AST.Type): (B, ST) = {
      basic(tipe) match {
        case Some(typeName) => return (T, st"$typeName")
        case _ => tipe match {
          case tipe: AST.Type.Named =>
            ti.scope.resolveType(globalTypeMap, AST.Util.ids2strings(tipe.name.ids)) match {
              case Some(ti2) => return (F, typeName(packageName, ti2.name))
              case _ =>
                reporter.error(tipe.posOpt, jsonGenKind,
                  st"Could not find ${(AST.Util.ids2strings(tipe.name.ids), ".")}.".render)
                return (F, st"")
            }
          case _ =>
            reporter.error(tipe.posOpt, jsonGenKind, s"Only named types are supported for @datatype/@record fields.")
            return (F, st"")
        }

      }
    }

    @pure def basic(tipe: AST.Type): Option[String] = {
      tipe match {
        case tipe: AST.Type.Named =>
          if (tipe.typeArgs.nonEmpty || tipe.name.ids.size != 1) {
            return None()
          }
          val r = tipe.name.ids(0).value
          r.native match {
            case "B" =>
            case "C" =>
            case "Z" =>
            case "Z8" =>
            case "Z16" =>
            case "Z32" =>
            case "Z64" =>
            case "N" =>
            case "N8" =>
            case "N16" =>
            case "N32" =>
            case "N64" =>
            case "S8" =>
            case "S16" =>
            case "S32" =>
            case "S64" =>
            case "U8" =>
            case "U16" =>
            case "U32" =>
            case "U64" =>
            case "F32" =>
            case "F64" =>
            case "R" =>
            case "String" =>
            case _ => return None()
          }
          return Some(r)
        case _ => None()
      }
    }
  }

}
