/*
 Copyright (c) 2016, Robby, Kansas State University
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

import org.sireum.option.SireumOption
import org.sireum.option.annotation._
import org.sireum.util._
import Reflection._
import CaseClass._
import org.stringtemplate.v4._
import scala.reflect.runtime.universe._

object CliGen {
  private final val argType = typeOf[Arg]
  private final val enumOptType = typeOf[EnumOpt]
  private final val groupOptType = typeOf[GroupOpt]
  private final val mainType = typeOf[Main]
  private final val modeType = typeOf[Mode]
  private final val optType = typeOf[Opt]
  private final val optsType = typeOf[Opts]
  private final val optAnnType = typeOf[OptAnnotation]
  private final val cseqStringType = typeOf[CSeq[String]]
  private final val arrayStringType = typeOf[Array[String]]
  private final val optionType = typeOf[Option[_]].erasure
  private final val optionBeanType = typeOf[OptionBean[_]].erasure
  private final val optionStringType = typeOf[Option[String]]
  private final val optionBeanStringType = typeOf[OptionBean[String]]
  private final val booleanType = typeOf[Boolean]
  private final val intType = typeOf[Int]
  private final val stringType = typeOf[String]

  final val stg = new STGroupFile(getClass.
    getResource("CliGen.stg"), "UTF-8", '%', '%')

  def main(args: Array[String]): Unit = {
    println(
      new CliGen(
        Some(sireumV3License),
        Some("org.sireum"),
        "Cli").
        generate(SireumOption()))
  }
}

final class CliGen(licenseOpt: Option[String],
                   packageNameOpt: Option[String],
                   className: String) {

  import CliGen._

  val stMain = stg.getInstanceOf("main").
    add("name", className)
  licenseOpt.foreach(l => stMain.add("license", l))
  packageNameOpt.foreach(p => stMain.add("packageName", p))
  val seen = MIdMap[AnyRef, Any]()

  def generate(o: AnyRef with Product): String = {
    val ccTop = caseClassObject(o, processAnnotations = true, seen)

    val rootClassName = ccTop.tipe.typeSymbol.fullName

    stMain.add("rootClass", rootClassName)

    modeOrMain(ccTop.annotations) match {
      case Some(a: Reflection.Annotation) =>
        val topCommand = paramValue[String](a, "name")
        stMain.add("topCommand", topCommand)
        a.tipe match {
          case `mainType` => mainGen(ivector(topCommand), ccTop, a)
          case `modeType` => modeGen(ivector(topCommand), ccTop, a)
        }
      case _ =>
        sys.error(s"Root object $rootClassName should be either be Mode or Main")
    }

    stMain.render()
  }

  private def modeGen(commands: ISeq[String],
                      cc: CaseClass,
                      a: Reflection.Annotation): Unit = {
    val (pName, cName) =
      packageClassNames(cc.tipe.typeSymbol.asClass.fullName)
    val stModeMap = stg.getInstanceOf("modeMap").add("modeClass", cName)
    stMain.add("modeMap", stModeMap)
    val stModeUsage = stg.getInstanceOf("modeUsage")
    val stModeDef = stg.getInstanceOf("modeDef").add("packageName", pName).
      add("className", cName).add("modeUsage", stModeUsage)
    stMain.add("modeDef", stModeDef)

    for (l <- paramValue[String](a, "header").
      stripMargin.trim.split('\n')) {
      stModeUsage.add("header", l)
    }

    for (c <- commands) {
      stModeUsage.add("command", c.trim)
    }

    var modes = ivectorEmpty[(String, String)]
    for (p <- cc.params) {
      p.arg match {
        case Some(ccMember: CaseClass) =>
          modeOrMain(ccMember.annotations) match {
            case Some(a: Reflection.Annotation) =>
              val command = paramValue[String](a, "name")
              val description = paramValue[String](a, "description")
              modes = modes :+(command, description)
              stModeMap.add("modeMapEntry",
                stg.getInstanceOf("modeMapEntry").
                  add("command", command).
                  add("className", ccMember.tipe.typeSymbol.name.decodedName))
              a.tipe match {
                case `mainType` =>
                  mainGen(commands :+ command, ccMember, a)
                case `modeType` =>
                  modeGen(commands :+ command, ccMember, a)
              }
            case _ =>
              sys.error(s"Mode member $cName.${p.name} should either be a Mode or Main")
          }
        case _ =>
          sys.error(s"Mode member $cName.${p.name} should be a case class initialized with default value")
      }
    }

    val maxCommandLen =
      modes.sortBy(_._1.length).lastOption match {
        case Some((command, _)) => command.length
        case _ => 0
      }

    for ((command, description) <- modes.sortBy(_._1)) {
      val sb = new StringBuilder(command)
      for (i <- 0 until maxCommandLen - command.length) {
        sb.append(' ')
      }
      sb.append("    ")
      sb.append(description)
      stModeUsage.add("mode", sb.toString())
    }
  }

  private def paramValue[T](a: Reflection.Annotation, name: String) =
    a.params.find(_.name == name).get.value.asInstanceOf[T]


  private def mainGen(commands: ISeq[String],
                      cc: CaseClass,
                      a: Reflection.Annotation) = {
    val (pName, cName) =
      packageClassNames(cc.tipe.typeSymbol.asClass.fullName)
    val stMainUsage = stg.getInstanceOf("mainUsage")
    val stMainDef = stg.getInstanceOf("mainDef").add("packageName", pName).
      add("className", cName).add("mainUsage", stMainUsage).
      add("handler", paramValue(a, "handler"))

    stMain.add("mainDef", stMainDef)

    for (l <- paramValue[String](a, "header").
      stripMargin.trim.split('\n')) {
      stMainUsage.add("header", l)
    }

    for (c <- commands) {
      stMainUsage.add("command", c.trim)
    }

    val optionMap = mmapEmpty[String, ISeq[(Option[String], String, String, Option[String])]].
      withDefaultValue(ivectorEmpty)
    for (p <- cc.params) {
      optOrArg(p.annotations) match {
        case Some(pa) if pa.tipe <:< optAnnType =>
          val shortKeyOpt = paramValue[Option[String]](pa, "shortKey")
          val fieldName = p.name
          val (name, longKey) = nameLongKey(fieldName)

          var defaultOpt: Option[String] = None
          var description = paramValue[String](pa, "description")
          if (pa.tipe <:< enumOptType) {
            val elements = paramValue[Seq[String]](pa, "elements")
            if (!(p.tipe =:= stringType)) {
              sys.error(s"Enum main member $cName.${p.name} should be of type String")
            }

            defaultOpt = Some("Default: ${option." + fieldName + "}")
            val stOptionCaseEnum = stg.getInstanceOf("optionCaseEnum").
              add("longKey", longKey).add("fieldName", fieldName).
              add("name", name)
            shortKeyOpt.foreach(k => stOptionCaseEnum.add("shortKey", k))
            for (e <- elements) {
              stOptionCaseEnum.add("elem", e)
              stOptionCaseEnum.add("optionCaseEnumElem",
                stg.getInstanceOf("optionCaseEnumElem").
                  add("fieldName", fieldName).add("elem", e))
            }
            description = s"$description { ${elements.mkString(", ")} }"
            stMainDef.add("optionCase", stOptionCaseEnum)
          } else if (pa.tipe =:= optType || pa.tipe =:= groupOptType) {
            val st =
              p.tipe match {
                case `booleanType` =>
                  stg.getInstanceOf("optionCaseBoolean")
                case `intType` =>
                  defaultOpt = Some("Default: ${option." + fieldName + "}")
                  stg.getInstanceOf("optionCaseInt").add("name", name)
                case `stringType` =>
                  defaultOpt = Some("Default: ${option." + fieldName + "}")
                  stg.getInstanceOf("optionCaseString").add("name", name)
                case t if t <:< optionType || t <:< optionBeanType =>
                  val someClass =
                    if (t <:< optionType) "Some"
                    else "org.sireum.util.some"
                  stg.getInstanceOf("optionCaseOption").add("name", name).
                    add("someClass", someClass)
                case t if t <:< cseqStringType || t <:< arrayStringType =>
                  defaultOpt = Some("Default: \"${option." + fieldName + ".mkString(\",\")}\"")
                  stg.getInstanceOf("optionCaseString").add("comma", true).
                    add("name", name)
                case t =>
                  sys.error(s"Unhandled type '$t' for main member $cName.${p.name}")
              }
            shortKeyOpt.foreach(k => st.add("shortKey", k))
            stMainDef.add("optionCase",
              st.add("longKey", longKey).add("fieldName", fieldName))
          } else {
            assert(pa.tipe =:= optsType)
            if (!(p.tipe <:< cseqStringType)) {
              sys.error(s"Opts main member $cName.${p.name} should be a sequence of String")
            }
            val stOptionCaseStrings =
              stg.getInstanceOf("optionCaseStrings").
                add("longKey", longKey).add("fieldName", fieldName).
                add("name", name)
            shortKeyOpt.foreach(k => stOptionCaseStrings.add("shortKey", k))
            stMainDef.add("optionCase", stOptionCaseStrings)
          }
          val q = (shortKeyOpt, longKey, description, defaultOpt)
          if (pa.tipe <:< groupOptType) {
            val groupName = paramValue[String](pa, "groupName")
            optionMap(groupName) = optionMap(groupName) :+ q
          } else {
            optionMap("") = optionMap("") :+ q
          }
        case Some(pa) if pa.tipe <:< argType =>
          val fieldName = p.name
          val (name, _) = nameLongKey(fieldName)
          val displayName = paramValue[String](pa, "name")
          val st =
            p.tipe match {
              case t if t =:= stringType =>
                stMainUsage.add("arg", s"<$displayName>")
                stg.getInstanceOf("argString").add("name", name)
              case t if t <:< optionStringType =>
                stMainUsage.add("arg", s"[$displayName]")
                stg.getInstanceOf("argOptString").add("someClass", "Some")
              case t if t <:< optionBeanStringType =>
                stMainUsage.add("arg", s"[$displayName]")
                stg.getInstanceOf("argOptString").add("someClass", "org.sireum.util.some")
              case t if t =:= cseqStringType || t =:= arrayStringType =>
                stMainUsage.add("arg", s"<$displayName-1> ... <$displayName-N>")
                stg.getInstanceOf("argStrings")
              case t =>
                sys.error(s"Arg main member $cName.${p.name} should either be a String, String option, or a sequence of String")
            }
          stMainDef.add("arg", st.
            add("fieldName", fieldName))
        case _ =>
          sys.error(s"Main member $cName.${p.name} should be either Arg, EnumGroupOpt, EnumOpt, GroupOpt, Opt, or Opts")
      }
    }

    for ((groupName, qs) <- optionMap.toSeq.sortBy(_._1)) {
      implicit val sb = new StringBuilder()
      stMainUsage.add("option", sb)
      if (groupName != "") {
        sb.append(groupName)
        sb.append(' ')
      }
      sb.append("Options:")

      val shortKeyMaxLen = 1.max(qs.sortBy(_._1.getOrElse("").length).lastOption match {
        case Some((shortKeyOpt, _, _, _)) => shortKeyOpt.getOrElse("").length
        case _ => 0
      })
      val longKeyMaxLen = 4.max(qs.sortBy(_._2.length).lastOption match {
        case Some((_, longKey, _, _)) => longKey.length
        case _ => 0
      })

      val descIndent = 1 + shortKeyMaxLen + 4 + longKeyMaxLen + 4

      for ((shortKeyOpt, longKey, description, defaultOpt) <- qs.
        sortWith((q1, q2) => (q1._1, q2._1) match {
          case (Some(k1), Some(k2)) => k1.compareTo(k2) <= 0
          case (Some(_), None) => true
          case (None, Some(_)) => false
          case _ => q1._2.compareTo(q2._2) <= 0
        }) ++ (if (groupName != "") ivectorEmpty
      else ivector((Some("h"), "help", "Display usage information", None)))) {
        sb.append("\n|")
        shortKeyOpt match {
          case Some(shortKey) =>
            appendSpaces(shortKeyMaxLen - shortKey.length)
            sb.append('-')
            sb.append(shortKey)
            sb.append(", ")
          case _ =>
            appendSpaces(1 + shortKeyMaxLen + 2)
        }
        sb.append("--")
        sb.append(longKey)
        appendSpaces(longKeyMaxLen - longKey.length)
        val dLines = description.split('\n').map(_.trim)
        if (dLines.length > 0) {
          sb.append("    ")
          sb.append(dLines.head)
          for (l <- dLines.tail) {
            sb.append("\n|")
            appendSpaces(descIndent)
            sb.append(l)
          }
        }
        if (defaultOpt.isDefined) {
          sb.append("\n|")
          appendSpaces(descIndent + 2)
          sb.append(defaultOpt.get)
        }
      }
    }
  }

  private def appendSpaces(n: Int)(implicit sb: StringBuilder): Unit = {
    for (i <- 0 until n) sb.append(' ')
  }

  private def nameLongKey(s: String) = {
    val sb = new StringBuilder
    val sbLongKey = new StringBuilder
    for (c <- s) {
      if (c.isUpper) {
        val d = c.toLower
        sb.append(' ')
        sb.append(d)
        sbLongKey.append('-')
        sbLongKey.append(d)
      } else {
        sb.append(c)
        sbLongKey.append(c)
      }
    }
    (sb.toString(), sbLongKey.toString())
  }


  private def modeOrMain(as: Iterable[Reflection.Annotation]) =
    as.find(a => a.tipe =:= modeType || a.tipe =:= mainType)

  private def optOrArg(as: Iterable[Reflection.Annotation]) =
    as.find(a => a.tipe <:< optAnnType || a.tipe <:< argType)

  private def packageClassNames(s: String): (String, String) = {
    val i = s.lastIndexOf('.')
    (s.substring(0, i), s.substring(i + 1))
  }

}
