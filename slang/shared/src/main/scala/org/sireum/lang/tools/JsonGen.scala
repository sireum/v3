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
import org.sireum.lang.{ast => AST}
import org.sireum.lang.symbol.Resolver._
import org.sireum.lang.util._

object JsonGen {

  object Template {

    @pure def main(licenseOpt: Option[String],
                   fileUriOpt: Option[String],
                   packageNames: ISZ[String],
                   name: Option[String],
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

    @pure def from(name: ST, tpe: ST): ST = {
      return st"""def from$name(o: $tpe): String = {
                 |  return Printer.print$name(o).render
                 |}"""
    }

    @pure def to(name: ST, tpe: ST): ST = {
      return st"""def to$name(s: String): Either[$tpe, Json.ErrorMsg] = {
                 |  def f$name(parser: Parser): $tpe = {
                 |    var r = parser.parse$name()
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
      return st"""@pure def print$name(o: $tpe): ST = {
                 |  return printObject(ISZ(
                 |    ${(printFields, ",\n")}
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
                 |  t match {
                 |    ${(parseRootCases, "\n")}
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
                 |  s match {
                 |    ${(parseEnumCases, "\n")}
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

  val jsonGenKind: String = "JsonGen"

  @record class Gen(globalNameMap: NameMap,
                    globalTypeMap: TypeMap,
                    packageName: QName,
                    reporter: Reporter) {

    val globalTypes: ISZ[TypeInfo] = sortedGlobalTypes(globalTypeMap)
    val poset: Poset[QName] = typePoset(globalTypeMap, globalTypes, reporter)

    var parsers: ISZ[ST] = ISZ()
    var printers: ISZ[ST] = ISZ()
    var fromsTos: ISZ[ST] = ISZ()

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
      return Template.main(licenseOpt, fileUriOpt, packageName, name, printers, parsers, fromsTos)
    }

    def genEnum(ti: TypeInfo.Enum): Unit = {
      val enumTypeString = typeString(packageName, ti.name)
      val enumTypeName = typeName(packageName, ti.name)
      printers = printers :+
        Template.printEnum(enumTypeName, enumTypeString,
          for (e <- ti.elements.elements)
            yield Template.printEnumCase(e, enumTypeString))
      parsers = parsers :+
        Template.parseEnum(enumTypeName, enumTypeString,
          for (e <- ti.elements.elements)
            yield Template.parseEnumCase(e, enumTypeString))
    }

    def genAdt(ti: TypeInfo.AbstractDatatype): Unit = {
      if (ti.ast.isRoot) {
        genRoot(ti.name)
      } else {
        val adTypeString = typeString(packageName, ti.name)
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
        printers = printers :+ Template.printObject(adTypeName, adTypeString, printFields)
        parsers = parsers :+ Template.parseObject(adTypeName, adTypeString, parseFields, fieldNames)
        fromsTos = fromsTos :+ Template.from(adTypeName, adTypeString) :+ Template.to(adTypeName, adTypeString)
      }
    }

    def genRoot(name: QName): Unit = {
      val rootTypeString = typeString(packageName, name)
      val rootTypeName = typeName(packageName, name)
      var rootPrintCases = ISZ[ST]()
      var rootParseCases = ISZ[ST]()
      var childrenTypeNames = ISZ[ST]()
      for (childIds <- poset.descendantsOf(name).elements) {
        globalTypeMap.get(childIds) match {
          case Some(childTI: TypeInfo.AbstractDatatype) if !childTI.ast.isRoot =>
            val childTypeString = typeString(packageName, childIds)
            val childTypeName = typeName(packageName, childIds)
            childrenTypeNames = childrenTypeNames :+ childTypeName
            rootPrintCases = rootPrintCases :+ Template.printRootCase(childTypeName, childTypeString)
            rootParseCases = rootParseCases :+ Template.parseRootCase(childTypeName, childTypeString)
          case _ =>
        }
      }
      printers = printers :+ Template.printRoot(rootTypeName, rootTypeString, rootPrintCases)
      parsers = parsers :+ Template.parseRoot(rootTypeName, rootTypeString, childrenTypeNames, rootParseCases)
      fromsTos = fromsTos :+ Template.from(rootTypeName, rootTypeString) :+ Template.to(rootTypeName, rootTypeString)
    }

    def printField(ti: TypeInfo.AbstractDatatype, fieldName: String, tipe: AST.Type.Named): ST = {
      val v = printValue(ti, fieldName, tipe)
      return Template.printField(fieldName, v)
    }

    def printValue(ti: TypeInfo.AbstractDatatype, fieldName: String, tipe: AST.Type.Named): ST = {
      val sOpt = s(ti, tipe)
      sOpt match {
        case Some((isImmutable, indexType, (isSimple, elementName))) =>
          if (isImmutable) {
            return Template.printIS(isSimple, elementName, fieldName, indexType)
          } else {
            return Template.printMS(isSimple, elementName, fieldName, indexType)
          }
        case _ =>
      }
      val optOpt = opt(ti, tipe)
      optOpt match {
        case Some((isImmutable, (_, elementName))) =>
          if (isImmutable) {
            return Template.printOption(elementName, fieldName)
          } else {
            return Template.printMOption(elementName, fieldName)
          }
        case _ =>
      }
      val eitherOpt = either(ti, tipe)
      eitherOpt match {
        case Some((isImmutable, (_, e0), (_, e1))) =>
          if (isImmutable) {
            return Template.printEither(e0, e1, fieldName)
          } else {
            return Template.printMEither(e0, e1, fieldName)
          }
        case _ =>
      }
      val p = basicOrTypeName(ti, tipe)
      Template.printValue(p._2, fieldName)
    }

    def parseField(ti: TypeInfo.AbstractDatatype, fieldName: String, tipe: AST.Type.Named): ST = {
      val v = parseValue(ti, tipe)
      return Template.parseField(fieldName, v)
    }

    def parseValue(ti: TypeInfo.AbstractDatatype, tipe: AST.Type.Named): ST = {
      val sOpt = s(ti, tipe)
      sOpt match {
        case Some((isImmutable, indexType, (isSimple, elementName))) =>
          val pe: ST =
            if (isSimple) Template.parseBuiltIn(ISZ(elementName))
            else Template.parseValue(ISZ(elementName))
          if (isImmutable) {
            return Template.parseIS(indexType, pe)
          } else {
            return Template.parseMS(indexType, pe)
          }
        case _ =>
      }
      val optOpt = opt(ti, tipe)
      optOpt match {
        case Some((isImmutable, (isSimple, elementName))) =>
          val pe: ST =
            if (isSimple) Template.parseBuiltIn(ISZ(elementName))
            else Template.parseValue(ISZ(elementName))
          if (isImmutable) {
            return Template.parseOption(pe)
          } else {
            return Template.parseMOption(pe)
          }
        case _ =>
      }
      val eitherOpt = either(ti, tipe)
      eitherOpt match {
        case Some((isImmutable, (isSimple0, e0), (isSimple1, e1))) =>
          val pe0: ST =
            if (isSimple0) Template.parseBuiltIn(ISZ(e0))
            else Template.parseValue(ISZ(e0))
          val pe1: ST =
            if (isSimple1) Template.parseBuiltIn(ISZ(e1))
            else Template.parseValue(ISZ(e1))
          if (isImmutable) {
            return Template.parseEither(pe0, pe1)
          } else {
            return Template.parseMEither(pe0, pe1)
          }
        case _ =>
      }
      val p = basicOrTypeName(ti, tipe)
      if (p._1) {
        return Template.parseBuiltIn(ISZ(p._2, st"()"))
      } else {
        return Template.parseValue(ISZ(p._2, st"()"))
      }
    }

    def either(ti: TypeInfo.AbstractDatatype, tipe: AST.Type.Named): Option[(B, (B, ST), (B, ST))] = {
      if (!(tipe.name.ids.size == 1 && tipe.typeArgs.size == 2)) {
        return None()
      }
      val name = tipe.name.ids(0).value
      name match {
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
      name match {
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
      name match {
        case "ISZ" => return Some((T, "Z", btn))
        case "ISZ8" => return Some((T, "Z8", btn))
        case "ISZ16" => return Some((T, "Z16", btn))
        case "ISZ32" => return Some((T, "Z32", btn))
        case "ISZ64" => return Some((T, "Z64", btn))
        case "ISN" => return Some((T, "N", btn))
        case "ISN8" => return Some((T, "N8", btn))
        case "ISN16" => return Some((T, "N16", btn))
        case "ISN32" => return Some((T, "N32", btn))
        case "ISN64" => return Some((T, "N64", btn))
        case "ISS8" => return Some((T, "S8", btn))
        case "ISS16" => return Some((T, "S16", btn))
        case "ISS32" => return Some((T, "S32", btn))
        case "ISS64" => return Some((T, "S64", btn))
        case "ISU8" => return Some((T, "U8", btn))
        case "ISU16" => return Some((T, "U16", btn))
        case "ISU32" => return Some((T, "U32", btn))
        case "ISU64" => return Some((T, "U64", btn))
        case "MSZ" => return Some((F, "Z", btn))
        case "MSZ8" => return Some((F, "Z8", btn))
        case "MSZ16" => return Some((F, "Z16", btn))
        case "MSZ32" => return Some((F, "Z32", btn))
        case "MSZ64" => return Some((F, "Z64", btn))
        case "MSN" => return Some((F, "N", btn))
        case "MSN8" => return Some((F, "N8", btn))
        case "MSN16" => return Some((F, "N16", btn))
        case "MSN32" => return Some((F, "N32", btn))
        case "MSN64" => return Some((F, "N64", btn))
        case "MSS8" => return Some((F, "S8", btn))
        case "MSS16" => return Some((F, "S16", btn))
        case "MSS32" => return Some((F, "S32", btn))
        case "MSS64" => return Some((F, "S64", btn))
        case "MSU8" => return Some((F, "U8", btn))
        case "MSU16" => return Some((F, "U16", btn))
        case "MSU32" => return Some((F, "U32", btn))
        case "MSU64" => return Some((F, "U64", btn))
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
          r match {
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


