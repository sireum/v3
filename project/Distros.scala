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
  val baseDir: Path = {
    Option(System.getenv("SIREUM_DISTRO_BUILD_DIR")) match {
      case Some(v) => Path(new java.io.File(v))
      case _ => pwd
    }
  }
  val ideaDir: Path = baseDir / 'distros / 'idea

  implicit val wd: Path = baseDir
  lazy val VER: String = {
    %%('git, 'log, "-n", "1", "--pretty=format:%H")(pwd).out.lines.head.trim
  }

  val ideaVer = "2016.3.1"

  val ideaUrlMap = Map(
    "mac" -> s"https://download.jetbrains.com/idea/ideaIC-$ideaVer.dmg",
    "win" -> s"https://download.jetbrains.com/idea/ideaIC-$ideaVer.exe",
    "linux" -> s"https://download.jetbrains.com/idea/ideaIC-$ideaVer.tar.gz"
  )

  val pluginUrlMap = Map(
    "sireum" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=31248",
    "jdt" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=31124",
    "scala" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=30974",
    "sbt" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=22670",
    "markdown" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=30117",
    "snakeyaml" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=24503",
    "antlr" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=31133",
    "asm" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=18619",
    "bash" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=28046",
    "cmd" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=18875",
    "batch" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=22567",
    "compare" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=24991",
    "latex" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=18476",
    "python" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=30456",
    "rst" -> "https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=14700"
  )

  def buildIdea(): Unit = {
    if (!(baseDir / 'distros / "sireum-v3-VER").toIO.exists) {
      sys.error("Need to run distros task first.")
      return
    }

    downloadPlugins()
    if (System.getProperty("os.name").toLowerCase.contains("mac"))
      buildIdea("mac")
    buildIdea("win")
    buildIdea("linux")
  }

  def downloadPlugins(): Unit = {
    val pluginsDir = ideaDir / 'plugins
    mkdir ! pluginsDir
    for ((name, url) <- pluginUrlMap if !(pluginsDir / s"$name.zip").toIO.exists) {
      print(s"Downloading $name plugin from $url ... ")
      %%('wget, "-q", "-O", s"$name.zip", url)(pluginsDir)
      println("done!")
    }
  }

  def extractPlugins(p: Path): Unit = {
    println("Downloading idea plugins ...")
    for ((name, _) <- pluginUrlMap) {
      print(s"Extracting $name plugin ... ")
      %%('unzip, "-oq", ideaDir / 'plugins / s"$name.zip")(p)
      println("done!")
    }
  }

  def patchIdeaProperties(platform: String, p: Path): Unit = {
    print(s"Patching $p ... ")
    val content = read ! p
    val newContent = platform match {
      case "mac" =>
        val i = content.indexOf("idea.paths.selector")
        val j = content.indexOf("<string>", i)
        val k = content.indexOf("</string>", j)
        content.substring(0, j) + "<string>Sireum" + content.substring(k)
      case "win" =>
        "idea.config.path=${user.home}/.Sireum/config\r\nidea.system.path=${user.home}/.Sireum/system\r\n" + content
      case "linux" =>
        "idea.config.path=${user.home}/.Sireum/config\nidea.system.path=${user.home}/.Sireum/system\n" + content
    }
    rm ! p
    write(p, newContent)
    println("done!")
  }

  def patchVMOptions(platform: String, p: Path): Unit = {
    print(s"Patching $p ... ")
    val content = read ! p
    val newContent = platform match {
      case "win" => content + "\r\n-Dfile.encoding=UTF-8"
      case _ => content + "\n-Dfile.encoding=UTF-8"
    }
    rm ! p
    write(p, newContent)
    println("done!")
  }

  def buildIdea(platform: String): Unit = {
    println(s"Building Sireum v3 idea ${platform}64 distro ...")
    val url = ideaUrlMap(platform)
    val filename = url.substring(url.lastIndexOf('/') + 1)
    val buildDir = ideaDir
    %%('mkdir, "-p", buildDir)
    val file = buildDir / filename
    if (!file.toIO.exists) {
      print(s"Downloading from $url ... ")
      %%('wget, "-q", url)(buildDir)
      println("done!")
    }
    rm ! buildDir / platform
    print(s"Extracting $file ... ")
    platform match {
      case "mac" =>
        val tempDir = buildDir / platform
        mkdir ! tempDir
        %%("hdiutil", "attach", file)
        %%('cp, "-R", root / 'Volumes / "IntelliJ IDEA CE" / "IntelliJ IDEA CE.app", tempDir / "Sireum.app")
        %%("hdiutil", "eject", root / 'Volumes / "IntelliJ IDEA CE")
        println("done!")
        extractPlugins(tempDir / "Sireum.app" / 'Contents / 'plugins)
        patchIdeaProperties(platform, tempDir / "Sireum.app" / 'Contents / "Info.plist")
        patchVMOptions(platform, tempDir / "Sireum.app" / 'Contents / 'bin / "idea.vmoptions")
      case "win" =>
        val tempDir = buildDir / platform / "sireum-v3" / 'apps / 'idea
        mkdir ! tempDir
        %%("7z", "x", file)(tempDir)
        rm ! tempDir / '$PLUGINSDIR
        println("done!")
        extractPlugins(tempDir / 'plugins)
        patchIdeaProperties(platform, tempDir / 'bin / "idea.properties")
        patchVMOptions(platform, tempDir / 'bin / "idea.exe.vmoptions")
        patchVMOptions(platform, tempDir / 'bin / "idea64.exe.vmoptions")
        %%('cp, "-p", pwd / 'resources / 'distro / "idea.bat", buildDir / platform / "sireum-v3")
        %%('cp, "-p", pwd / 'resources / 'distro / "idea64.bat", buildDir / platform / "sireum-v3")
      case "linux" =>
        val tempDir = buildDir / platform / "sireum-v3" / 'apps
        mkdir ! tempDir
        %%("tar", "xf", file)(tempDir)
        mv(tempDir / tempDir.toIO.listFiles()(0).getName, tempDir / 'idea)
        println("done!")
        extractPlugins(tempDir / 'idea / 'plugins)
        patchIdeaProperties(platform, tempDir / 'idea / 'bin / "idea.properties")
        patchVMOptions(platform, tempDir / 'idea / 'bin / "idea.vmoptions")
        patchVMOptions(platform, tempDir / 'idea / 'bin / "idea64.vmoptions")
        %%('cp, "-p", pwd / 'resources / 'distro / "idea", buildDir / platform / "sireum-v3")
        %%('chmod, "+x", buildDir / platform / "sireum-v3" / "idea")
    }
    print("Extracting Sireum v3 distro ... ")
    platform match {
      case "mac" =>
        %%('unzip, "-oq", baseDir / 'distros / s"sireum-v3-${platform}64.zip")(baseDir / 'distros / 'idea / platform / "Sireum.app" / "Contents" / "Resources")
      case _ =>
        %%('unzip, "-oq", baseDir / 'distros / s"sireum-v3-${platform}64.zip")(baseDir / 'distros / 'idea / platform)
        mv(ideaDir / platform / "sireum-v3", ideaDir / platform / "Sireum")
    }
    println("done!")
    print(s"Packaging ${platform}64 idea distro ... ")
    platform match {
      case "mac" =>
        val bundle = baseDir / 'distros / "sireum-v3-idea-mac64.dmg"
        rm ! bundle
        %%('tar, "cfz", bundle, "Sireum.app")(ideaDir / platform)
        %%(pwd / 'resources / 'distro / "create-dmg" / "create-dmg",
          "--volname", "Sireum v3",
          "--hide-extension", "Sireum.app",
          "--icon-size", "64",
          "--icon", "Sireum.app", "0", "90",
          "--app-drop-link", "256", "90",
          "--window-size", "500", "150",
          "--background", pwd / 'resources / 'distro / "dmg-background.png",
          ideaDir / "sireum-v3-idea-mac64.dmg", "Sireum.app")(ideaDir / platform)
        rm ! ideaDir / platform
      case "linux" =>
        val bundle = baseDir / 'distros / "sireum-v3-idea-linux64.zip"
        rm ! bundle
        %%('zip, "-r", bundle, "Sireum")(ideaDir / platform)
        rm ! ideaDir / platform
      case "win" =>
        val bundle = baseDir / 'distros / "sireum-v3-idea-win64.zip"
        rm ! bundle
        %%('zip, "-r", bundle, "Sireum")(ideaDir / platform)
        rm ! ideaDir / platform
    }
    println("done!")
  }

  def build(): Unit = {
    rm ! baseDir / 'distros / "sireum-v3-mac64.zip"
    rm ! baseDir / 'distros / "sireum-v3-win64.zip"
    rm ! baseDir / 'distros / "sireum-v3-linux64.zip"
    rm ! baseDir / 'distros / "sireum-v3-VER"
    write(baseDir / 'distros / "sireum-v3-VER", VER)
    build("mac")
    build("win")
    build("linux")
  }

  def build(platform: String): Unit = {
    println(s"Building distro for ${platform}64...")
    println()
    rm ! baseDir / 'distros / "sireum-v3"
    mkdir ! baseDir / 'distros / "sireum-v3" / 'bin
    write(baseDir / 'distros / "sireum-v3" / 'bin / 'VER, VER)
    val licenseLines = read.lines ! pwd / "license.txt"
    platform match {
      case "win" =>
        write(baseDir / 'distros / "sireum-v3" / "license.txt", licenseLines.mkString("\r\n"))
        cp(pwd / 'resources / 'distro / "sireum.bat", baseDir / 'distros / "sireum-v3" / "sireum.bat")
      case _ =>
        write(baseDir / 'distros / "sireum-v3" / "license.txt", licenseLines.mkString("\n"))
        cp(pwd / "sireum", baseDir / 'distros / "sireum-v3" / "sireum")
    }
    cp(pwd / 'bin / "sireum.jar", baseDir / 'distros / "sireum-v3" / 'bin / "sireum.jar")
    cp(pwd / 'bin / "prelude.sh", baseDir / 'distros / "sireum-v3" / 'bin / "prelude.sh")
    %('bash, baseDir / 'distros / "sireum-v3" / 'bin / "prelude.sh", PLATFORM = platform, DISTROS = "true")
    rm ! baseDir / 'distros / "sireum-v3" / 'bin / "prelude.sh"
    %('zip, "-qr", s"sireum-v3-${platform}64.zip", "sireum-v3")(baseDir / 'distros)
    rm ! baseDir / 'distros / "sireum-v3"
  }
}