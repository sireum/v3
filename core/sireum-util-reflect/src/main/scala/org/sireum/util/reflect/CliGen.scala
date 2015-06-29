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

import org.sireum.option.SireumOption
import org.sireum.option.annotation._
import org.sireum.util._
import Reflection._
import CaseClass._
import org.stringtemplate.v4._
import scala.reflect.runtime.universe._

object CliGen {
  private final val argType = typeOf[Arg]
  private final val argOptType = typeOf[ArgOpt]
  private final val argsType = typeOf[Args]
  private final val groupOptType = typeOf[GroupOpt]
  private final val mainType = typeOf[Main]
  private final val modeType = typeOf[Mode]
  private final val optType = typeOf[Opt]

  final val stg = new STGroupFile(getClass.
    getResource("CliGen.stg"), "UTF-8", '%', '%')

  def main(args: Array[String]): Unit = {
    println(
      new CliGen("org.sireum.cli", "Cli").
        generate(SireumOption()).
        render())
  }
}

final class CliGen(packageName: String, className: String) {

  import CliGen._

  val stMain = stg.getInstanceOf("main").
    add("packageName", packageName).
    add("name", className)
  val seen = MIdMap[AnyRef, Any]()

  def generate(o: AnyRef with Product): ST = {
    val ccTop = caseClassObject(o, processAnnotations = true, seen)
    val rootClassName = Reflection.getClassOfType(ccTop.tipe).getSimpleName

    stMain.add("rootClass", rootClassName)

    modeOrMain(ccTop.annotations) match {
      case Some(a: Reflection.Annotation) =>
        val topCommand = paramValue(a, "name").toString
        stMain.add("topCommand", topCommand)
        a.tipe match {
          case `mainType` => mineMain(ivector(topCommand), ccTop, a)
          case `modeType` => mineMode(ivector(topCommand), ccTop, a)
        }
      case _ =>
        sys.error(s"Root object ${ccTop.tipe.typeSymbol.fullName} should be either be Mode or Main")
    }

    stMain
  }

  private def mineMode(commands: ISeq[String],
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

    for (l <- paramValue(a, "header").toString.
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
              val command = paramValue(a, "name").toString
              val description = paramValue(a, "description").toString
              modes = modes :+(command, description)
              stModeMap.add("modeMapEntry",
                stg.getInstanceOf("modeMapEntry").
                  add("command", command).
                  add("className", ccMember.tipe.typeSymbol.name.decodedName))
              a.tipe match {
                case `mainType` =>
                  mineMain(commands :+ command, ccMember, a)
                case `modeType` =>
                  mineMode(commands :+ command, ccMember, a)
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
      stModeUsage.add("command", sb.toString())
    }
  }

  private def paramValue(a: Reflection.Annotation, name: String) =
    a.params.find(_.name == name).get.value


  private def mineMain(commands: ISeq[String],
                       cc: CaseClass,
                       a: Reflection.Annotation) = {
    // TODO
  }

  private def modeOrMain(as: Iterable[Reflection.Annotation]) =
    as.find(a => a.tipe =:= modeType || a.tipe =:= mainType)

  private def packageClassNames(s: String): (String, String) = {
    val i = s.lastIndexOf('.')
    (s.substring(0, i), s.substring(i + 1))
  }

}
