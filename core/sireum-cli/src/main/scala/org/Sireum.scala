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

package org

import java.io.File
import java.nio.file.Files

import org.sireum.option._
import org.sireum.util._
import org.yaml.snakeyaml.{TypeDescription, Yaml}
import org.yaml.snakeyaml.constructor.Constructor
import org.yaml.snakeyaml.nodes.Tag
import org.yaml.snakeyaml.representer.Representer

object Sireum {
  private var topOption: Option[SireumOption] = None

  def main(args: Array[String]): Unit = {
    import org.sireum.Cli._

    val optionOpt = {
      val f =
        Option(System.getProperty("sireum.option")) match {
          case Some(p) =>
            new File(p.trim)
          case _ =>
            val dir = new File(this.getClass.getProtectionDomain.getCodeSource.
              getLocation.toURI.getPath).getParentFile
            new File(dir, "sireum.yaml")
        }
      try {
        if (!f.isFile) None
        else {
          val s = new String(Files.readAllBytes(f.toPath))
          val option = yamlLoad[SireumOption](s)
          Some(option)
        }
      } catch {
        case t: Throwable =>
          ePrintln(s"Error loading option from: '${f.getAbsolutePath}'")
          oPrintln("Falling back to default option")
          None
      }
    }
    val option = optionOpt.getOrElse(SireumOption())
    topOption = Some(option)
    new org.sireum.Cli(oPrintln, ePrintln).parseSireumOption(args, 0, option)
    topOption = None
  }

  def run(option: UtilOptionOption,
          outPrintln: String => Unit,
          errPrintln: String => Unit): Boolean = {
    outPrintln(yamlDump(topOption.getOrElse(SireumOption())))
    false
  }

  private def yamlDump(o: AnyRef): String = {
    val r = new Representer
    r.addClassTag(classOf[some[_]], new Tag("!some"))
    r.addClassTag(classOf[none[_]], new Tag("!none"))
    val s = new Yaml(new Constructor(classOf[SireumOption]), r).dump(o)
    s.substring(s.indexOf('\n') + 1).trim
  }

  private def yamlLoad[T](s: String): T = {
    val c = new Constructor(classOf[SireumOption])
    c.addTypeDescription(new TypeDescription(classOf[some[_]], "!some"))
    c.addTypeDescription(new TypeDescription(classOf[none[_]], "!none"))
    new Yaml(c).load(s).asInstanceOf[T]
  }
}
