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

object CaseClassHelperGen {
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
    getResource("CaseClassHelperGen.stg"), "UTF-8", '$', '$')

  final def generate(root: Type): ST = {
    val h = hierarchy(root.typeSymbol.asClass)
    val stMain = stg.getInstanceOf("main")
    val rootClassSymbol = root.typeSymbol.asClass
    val packageName = {
      val fn = rootClassSymbol.fullName
      fn.substring(0, fn.lastIndexOf("."))
    }
    val rootName = name(root)

    stMain.add("packageName", packageName)
    stMain.add("name", rootName)

    for (
      c <- h.keys.filterNot(_.isAbstract).
        toSeq.sortBy(_.asClass.fullName)
    ) {
      val cc = reflect.Reflection.CaseClass.
        caseClassType(c.asType.toType, processAnnotations = false)
      val typeName = name(cc.tipe)

      val stCaseFrom = stg.getInstanceOf("caseFrom").
        add("name", typeName)
      stMain.add("fromCase", stCaseFrom)

      val stCaseTo = stg.getInstanceOf("caseTo").
        add("name", typeName)
      stMain.add("toCase", stCaseTo)

      val stConsEntry = stg.getInstanceOf("constructorEntry").
        add("name", typeName)
      stMain.add("entry", stConsEntry)

      var i = 0
      for (p <- cc.params) {
        {
          val (et, b) = entryType(p.name, p.tipe)
          stConsEntry.add("et", et)
          if (b) stConsEntry.add("ec", s"cast(${p.name})")
          else stConsEntry.add("ec", p.name)
        }
        {
          val (tipe, typeArgOpt) = fromType(p.tipe)
          val stArg = stg.getInstanceOf("caseFromArg").
            add("name", p.name).
            add("type", tipe)
          typeArgOpt.foreach(arg => stArg.add("arg", arg))
          stCaseFrom.add("arg", stArg)
        }
        {
          val (tipe, typeArgOpt) = toType(p.tipe)
          val stArg = stg.getInstanceOf("caseToArg").
            add("type", tipe).add("i", i + 1)
          typeArgOpt.foreach(arg => stArg.add("arg", arg))
          stCaseTo.add("arg", stArg)
        }
        i += 1
      }
    }
    stMain
  }

  private def name(t: Type) =
    t.typeSymbol.asClass.name.decodedName.toString

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

  private def fromType1(t: Type) = fromType(t)._1

  private def fromType(t: Type): (String, ISeq[String]) =
    t match {
      case _ if t <:< anyValType =>
        ("fromAnyVal", ivectorEmpty)
      case _ if t =:= stringType =>
        ("fromStr", ivectorEmpty)
      case _ if t.dealias.erasure =:= optionType =>
        ("fromOption", t.typeArgs.map(fromType1))
      case _ if t.dealias.erasure =:= vectorType =>
        ("fromSeq", t.typeArgs.map(fromType1))
      case _ if t.dealias.erasure =:= tuple2Type =>
        ("fromTuple2", t.typeArgs.map(fromType1))
      case _ if t.dealias.erasure =:= tuple3Type =>
        ("fromTuple3", t.typeArgs.map(fromType1))
      case _ if t <:< productType =>
        ("from", ivectorEmpty)
    }

  private def toType1(t: Type) = toType(t)._1

  private def toType(t: Type): (String, ISeq[String]) =
    t match {
      case _ if t <:< anyValType =>
        ("to" + name(t), ivectorEmpty)
      case _ if t =:= stringType =>
        ("toStr", ivectorEmpty)
      case _ if t.dealias.erasure =:= optionType =>
        ("toOption", t.typeArgs.map(toType1))
      case _ if t.dealias.erasure =:= vectorType =>
        ("toVector", t.typeArgs.map(toType1))
      case _ if t.dealias.erasure =:= tuple2Type =>
        ("toTuple2", t.typeArgs.map(toType1))
      case _ if t.dealias.erasure =:= tuple3Type =>
        ("toTuple3", t.typeArgs.map(toType1))
      case _ if t <:< productType =>
        (s"to[${name(t)}]", ivectorEmpty)
    }

  private def hierarchy(c: ClassSymbol,
                        map: Hierarchy = mmapEmpty): Hierarchy = {
    val subs = c.knownDirectSubclasses
    map(c) = subs
    for (sub <- subs) {
      hierarchy(sub.asClass, map)
    }
    map
  }

  def main(args: Array[String]): Unit = {
    println(CaseClassHelperGen.generate(typeOf[org.sireum.pilar.ast.Node]).render())
  }
}
