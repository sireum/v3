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

package org.sireum.util.reflect

import org.sireum.util._
import org.stringtemplate.v4._
import scala.reflect.runtime.universe._

object RewriterJsonGen {
  type Hierarchy = MMap[Symbol, ISet[Symbol]]
  final val anyValType = typeOf[AnyVal]
  final val stringType = typeOf[String]
  final val optionType = typeOf[Option[_]].erasure
  final val vectorType = typeOf[Vector[_]].erasure
  final val tuple2Type = typeOf[(_, _)].erasure
  final val tuple3Type = typeOf[(_, _, _)].erasure
  final val productType = typeOf[Product]
  final val anyValBoxMap = Map(
    "Boolean" -> "java.lang.Boolean",
    "Byte" -> "java.lang.Byte",
    "Char" -> "java.lang.Character",
    "Short" -> "java.lang.Short",
    "Int" -> "java.lang.Integer",
    "Long" -> "java.lang.Long",
    "Float" -> "java.lang.Float",
    "Double" -> "java.lang.Double"
  )
  val stg = new STGroupFile(getClass.
    getResource("RewriterJsonGen.stg"), "UTF-8", '%', '%')

  final def generateRewriter(licenseOpt: Option[String],
                             packageNameOpt: Option[String],
                             className: String,
                             root: Type,
                             imports: ISeq[String]): String = {
    val h = hierarchy(root.typeSymbol.asClass)
    val stMainRewriter = stg.getInstanceOf("mainRewriter").
      add("name", className)
    licenseOpt.foreach(l => stMainRewriter.add("license", l))
    packageNameOpt.foreach(p => stMainRewriter.add("packageName", p))
    imports.foreach(i => stMainRewriter.add("impor", i))

    stMainRewriter.add("rootClassFullName", fullName(root))
    for (
      c <- h.keys.filterNot(_.isAbstract).
        toSeq.sortBy(_.asClass.fullName)
    ) {

      if (c.isModuleClass) {
        val tipe = c.asType.toType
        val stConsEntry = stg.getInstanceOf("constructorModuleEntry").
          add("name", name(tipe)).add("fullName", fullName(tipe))
        stMainRewriter.add("entry", stConsEntry)
      } else {
        val cc = reflect.Reflection.CaseClass.
          caseClassType(c.asType.toType, processAnnotations = false)
        val typeName = name(cc.tipe)

        val stConsEntry = stg.getInstanceOf("constructorEntry").
          add("name", typeName).
          add("fullName", fullName(cc.tipe))
        stMainRewriter.add("entry", stConsEntry)

        var i = 0
        for (p <- cc.params) {
          {
            val (et, b) = entryType(p.name, p.tipe)
            stConsEntry.add("et", et)
            if (b) stConsEntry.add("ec", s"cast(${p.name})")
            else stConsEntry.add("ec", p.name)
          }
          i += 1
        }
      }
    }
    stMainRewriter.render()
  }

  final def generateJson(licenseOpt: Option[String],
                         packageNameOpt: Option[String],
                         className: String,
                         root: Type,
                         imports: ISeq[String]): String = {
    val h = hierarchy(root.typeSymbol.asClass)
    val stMainJson = stg.getInstanceOf("mainJson").
      add("name", className)
    licenseOpt.foreach(l => stMainJson.add("license", l))
    packageNameOpt.foreach(p => stMainJson.add("packageName", p))
    imports.foreach(i => stMainJson.add("impor", i))

    val rootClassName = name(root)

    stMainJson.
      add("rootClassFullName", fullName(root)).
      add("rootClassName", rootClassName)

    for (
      c <- h.keys.filterNot(_.isAbstract).
        toSeq.sortBy(_.asClass.fullName)
    ) {

      if (c.isModuleClass) {
        val tipe = c.asType.toType
        val typeName = name(tipe)
        val typeFullName = fullName(tipe)

        val stCaseFrom = stg.getInstanceOf("caseModuleFrom").
          add("name", typeName).add("fullName", typeFullName)
        stMainJson.add("fromCase", stCaseFrom)

        val stCaseTo = stg.getInstanceOf("caseModuleTo").
          add("name", typeName).add("fullName", typeFullName)
        stMainJson.add("toCase", stCaseTo)

      } else {
        val cc = reflect.Reflection.CaseClass.
          caseClassType(c.asType.toType, processAnnotations = false)
        val typeName = name(cc.tipe)
        val typeFullName = fullName(cc.tipe)

        val stCaseFrom = stg.getInstanceOf("caseFrom").
          add("name", typeName).add("fullName", typeFullName)
        stMainJson.add("fromCase", stCaseFrom)

        val stCaseTo = stg.getInstanceOf("caseTo").
          add("name", typeName).add("fullName", typeFullName)
        stMainJson.add("toCase", stCaseTo)

        var i = 0
        for (p <- cc.params) {
          {
            val (tipe, typeArgOpt) = fromType(p.tipe, root)
            val stArg = stg.getInstanceOf("caseFromArg").
              add("name", p.name).
              add("type", tipe)
            typeArgOpt.foreach(arg => stArg.add("arg", arg))
            stCaseFrom.add("arg", stArg)
          }
          {
            val (tipe, typeArgOpt) = toType(p.tipe, root)
            val stArg = stg.getInstanceOf("caseToArg").
              add("type", tipe).add("i", i + 1)
            typeArgOpt.foreach(arg => stArg.add("arg", arg))
            stCaseTo.add("arg", stArg)
          }
          i += 1
        }
      }
    }
    stMainJson.render()
  }

  private def name(t: Type) =
    t.typeSymbol.asClass.name.decodedName.toString

  private def fullName(t: Type) =
    t.typeSymbol.asClass.fullName

  private def entryType(n: String, t: Type) =
    t match {
      case _ if t <:< anyValType =>
        (s"$n: ${anyValBoxMap(name(t))}", false)
      case _ if t =:= stringType =>
        (s"$n: String", false)
      case _ if t.dealias.erasure =:= optionType =>
        (s"$n: Option[_]", true)
      case _ if t.dealias.erasure =:= vectorType =>
        (s"$n: IVector[_]", true)
      case _ if t.dealias.erasure =:= tuple2Type =>
        (s"$n: (_, _)", true)
      case _ if t.dealias.erasure =:= tuple3Type =>
        (s"$n: (_, _, _)", true)
      case _ if t <:< productType =>
        (s"$n: ${name(t)}", false)
    }

  private def fromType1(root: Type)(t: Type) = fromType(t, root)._1

  private def fromType(t: Type, root: Type): (String, ISeq[String]) =
    t match {
      case _ if t <:< anyValType =>
        ("fromAnyVal", ivectorEmpty)
      case _ if t =:= stringType =>
        ("fromStr", ivectorEmpty)
      case _ if t.dealias.erasure =:= optionType =>
        ("fromOption", t.typeArgs.map(fromType1(root)))
      case _ if t.dealias.erasure =:= vectorType =>
        ("fromSeq", t.typeArgs.map(fromType1(root)))
      case _ if t.dealias.erasure =:= tuple2Type =>
        ("fromTuple2", t.typeArgs.map(fromType1(root)))
      case _ if t.dealias.erasure =:= tuple3Type =>
        ("fromTuple3", t.typeArgs.map(fromType1(root)))
      case _ if t <:< productType =>
        if (t <:< root)
          (s"from${name(root)}", ivectorEmpty)
        else
          (s"from${name(t)}", ivectorEmpty)
    }

  private def toType1(root: Type)(t: Type) = toType(t, root)._1

  private def toType(t: Type, root: Type): (String, ISeq[String]) =
    t match {
      case _ if t <:< anyValType =>
        ("to" + name(t), ivectorEmpty)
      case _ if t =:= stringType =>
        ("toStr", ivectorEmpty)
      case _ if t.dealias.erasure =:= optionType =>
        ("toOption", t.typeArgs.map(toType1(root)))
      case _ if t.dealias.erasure =:= vectorType =>
        ("toVector", t.typeArgs.map(toType1(root)))
      case _ if t.dealias.erasure =:= tuple2Type =>
        ("toTuple2", t.typeArgs.map(toType1(root)))
      case _ if t.dealias.erasure =:= tuple3Type =>
        ("toTuple3", t.typeArgs.map(toType1(root)))
      case _ if t <:< productType =>
        if (t <:< root)
          (s"to${name(root)}[${name(t)}]", ivectorEmpty)
        else
          (s"to${name(t)}[${name(t)}]", ivectorEmpty)
    }

  private def hierarchy(c: ClassSymbol,
                        map: Hierarchy = mmapEmpty): Hierarchy = {
    val subs = c.knownDirectSubclasses
    map(c) = subs
    for (sub <- subs) {
      if (!sub.isModule)
        hierarchy(sub.asClass, map)
    }
    map
  }

  def main(args: Array[String]): Unit = {
    val licenseOpt = Some(sireumV3License)
    val rewriter =
      RewriterJsonGen.generateRewriter(
        licenseOpt,
        Some("org.sireum.pilar.ast"),
        "Rewriter",
        typeOf[org.sireum.pilar.ast.Node],
        ivectorEmpty
      )
    val json =
      RewriterJsonGen.generateJson(
        licenseOpt,
        Some("org.sireum.pilar.ast"),
        "Json",
        typeOf[org.sireum.pilar.ast.Node],
        ivectorEmpty
      )
    println(rewriter)
    println(json)
  }
}
