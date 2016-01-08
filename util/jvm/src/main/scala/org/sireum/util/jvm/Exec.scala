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

package org.sireum.util.jvm

import java.io._
import org.sireum.util._

import scala.sys.process.ProcessIO

object Exec {

  sealed abstract class Result

  object Timeout extends Result

  case class ExceptionRaised(e: Exception) extends Result

  case class StringResult(s: String, exitValue: Int) extends Result

}

final class Exec {
  private val sb = new StringBuffer

  val env = mmapEmpty[String, String]

  def process(args: Seq[String],
              writeInput: OutputStream => Unit,
              processOutput: InputStream => Unit,
              extraEnv: (String, String)*): scala.sys.process.Process = {
    scala.sys.process.Process({
      val pb = new java.lang.ProcessBuilder(args: _*)
      pb.redirectErrorStream(true)
      val m = pb.environment
      for ((k, v) <- env ++ extraEnv) {
        m.put(k, v)
      }
      pb
    }).run(new ProcessIO(writeInput, processOutput, errorF).daemonized())
  }

  def run(waitTime: Long, args: Seq[String], input: Option[String],
          extraEnv: (String, String)*): Exec.Result =
    run(waitTime, args, input, None, extraEnv: _*)

  def run(waitTime: Long, args: Seq[String], input: Option[String],
          dir: Option[File], extraEnv: (String, String)*): Exec.Result = {
    import scala.sys.process._
    import scala.concurrent._
    import scala.concurrent.duration._
    import scala.concurrent.ExecutionContext.Implicits.global
    try {
      val p = Process({
        val pb = new java.lang.ProcessBuilder(args: _*)
        pb.redirectErrorStream(true)
        dir.foreach(d => pb.directory(d))
        val m = pb.environment
        for ((k, v) <- env ++ extraEnv) {
          m.put(k, v)
        }
        pb
      }).run(new ProcessIO(inputF(input), outputF, errorF))
      if (waitTime <= 0) {
        val x = p.exitValue
        Exec.StringResult(sb.toString, x)
      } else {

        val x = Await.result(Future {
          p.exitValue
        }, waitTime.millis)
        Exec.StringResult(sb.toString, x)
      }
    } catch {
      case _: TimeoutException => Exec.Timeout
      case e: Exception => Exec.ExceptionRaised(e)
    }
  }

  def inputF(in: Option[String])(out: OutputStream) {
    val osw = new OutputStreamWriter(out)
    try in match {
      case Some(s) => osw.write(s, 0, s.length)
      case _ =>
    }
    finally osw.close()
  }

  def outputF(is: InputStream) {
    val buffer = new Array[Byte](10 * 1024)
    try {
      var n = is.read(buffer)
      while (n != -1) {
        sb.append(new String(buffer, 0, n))
        n = is.read(buffer)
      }
    } finally is.close()
  }

  def errorF(is: InputStream) {
    try while (is.read != -1) {} finally is.close()
  }
}