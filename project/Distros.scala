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

import ammonite.ops._

object Distros {
  implicit val wd = cwd
  lazy val VER = {
    %%('git, 'log, "-n", "1", "--pretty=format:%H").out.lines.head.trim
  }

  def build(): Unit = {
    rm ! cwd / 'distros
    write(cwd / 'distros / "sireum-v3-VER", VER)
    build("mac")
    build("win")
    build("linux")
  }

  def build(platform: String): Unit = {
    mkdir ! cwd / 'distros / "sireum-v3" / 'bin
    write(cwd / 'distros / "sireum-v3" / 'bin / 'VER, VER)
    val licenseLines = read.lines ! cwd / "license.txt"
    platform match {
      case "win" =>
        write(cwd / 'distros / "sireum-v3" / "license.txt", licenseLines.mkString("\r\n"))
        cp(cwd / 'resources / 'distro / "sireum.bat", cwd / 'distros / "sireum-v3" / "sireum.bat")
      case _ =>
        write(cwd / 'distros / "sireum-v3" / "license.txt", licenseLines.mkString("\n"))
        cp(cwd / "sireum", cwd / 'distros / "sireum-v3" / "sireum")
    }
    cp(cwd / 'bin / "sireum.jar", cwd / 'distros / "sireum-v3" / 'bin / "sireum.jar")
    cp(cwd / 'bin / "prelude.sh", cwd / 'distros / "sireum-v3" / 'bin / "prelude.sh")
    %('bash, cwd / 'distros / "sireum-v3" / 'bin / "prelude.sh", PLATFORM = platform, DISTROS = "true")
    rm ! cwd / 'distros / "sireum-v3" / 'bin / "prelude.sh"
    %('zip, "-qr", s"sireum-v3-${platform}64.zip", "sireum-v3")(cwd / 'distros)
    rm ! cwd / 'distros / "sireum-v3"
  }
}