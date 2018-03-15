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

import java.io.{File, FileInputStream, FilenameFilter}
import java.util.jar.JarInputStream

import ammonite.ops._

object Distros {
  var isDev: Boolean = false
  lazy val dev: String = if (isDev) "-dev" else ""
  val baseDir: Path = {
    Option(System.getenv("SIREUM_DISTRO_BUILD_DIR")) match {
      case Some(v) => Path(new java.io.File(v))
      case _       => pwd
    }
  }
  val ideaDir: Path = baseDir / 'distros / 'idea

  implicit val wd: Path = baseDir
  lazy val VER: String = {
    %%('git, 'log, "-n", "1", "--pretty=format:%H")(pwd).out.lines.head.trim
  }

  lazy val ideaVer: String = if (isDev) "2017.3.5" else "2017.3.3"

  val ideaExtMap = Map(
    "mac" -> ".dmg",
    "win" -> ".exe",
    "linux" -> ".tar.gz"
  )

  val jarPlugins = Map(
    "rst" -> "rest.jar",
    "batch" -> "idea-batch.jar",
    "latex" -> "idea-latex.jar",
    "sireum-injector" -> "sireum-injector.jar"
  )

  lazy val pluginUpdateIdMap: Map[String, Int] = Map(
    "sireum" -> (if (isDev) 0 else 42206),
    "sireum-injector" -> (if (isDev) 0 else 42207),
    "jdt" -> 32149,
    "scala" -> (if (isDev) 42173 else 41523),
    "markdown" -> (if (isDev) 42241 else 39197),
    "asm" -> 41973,
    "bash" -> (if (isDev) 43928 else 38798),
    "batch" -> 22567,
    "compare" -> 24991,
    "python" -> (if (isDev) 42367 else 41833)
  ) ++ (if (isDev)
          Map(
            "rst" -> 14700,
            "latex" -> 18476,
            "antlr" -> 34128,
            "scalafmt" -> 41928,
            "jbsdk" -> 32949,
            "gitextender" -> 41256,
            "gittoolbox" -> 43506
          )
        else Map())

  lazy val pluginUpdateUrlMap: Map[String, (String, String)] = Map(
    //"ignore" -> ("2.3.2", "https://github.com/hsz/idea-gitignore/releases/download/v2.3.2/idea-gitignore-2.3.2.zip")
  )

  val ignoredIcons = Set("idea.icns",
                         "idea-dev.icns",
                         "idea.png",
                         "idea-dev.png",
                         "idea-dev.ico")

  val hasExes: Boolean = (baseDir / 'distros / "idea.exe").toIO.isFile &&
    (baseDir / 'distros / "idea64.exe").toIO.isFile

  def buildIVEDev(): Unit = {
    isDev = true
    buildIVE()
  }

  def buildDev(): Unit = {
    isDev = true
    build()
  }

  def buildIVE(): Unit = {
    val ver = baseDir / 'distros / s"sireum-v3$dev-VER"
    if (!ver.toIO.exists) {
      sys.error(s"Could not find $ver!")
      sys.error("Need to run distros task first.")
      return
    }

    try {
      %%("7z", "-h")
    } catch {
      case _: Throwable => sys.error("Need 7z.")
    }

    try {
      %%("unzip", "-h")
    } catch {
      case _: Throwable => sys.error("Need unzip.")
    }

    downloadPlugins()
    buildIVE("mac")
    buildIVE("win")
    buildIVE("linux")

    //rm ! baseDir / 'distros / 'idea
  }

  def downloadPlugins(): Unit = {
    val pluginsDir = ideaDir / 'plugins
    mkdir ! pluginsDir
    for ((name, updateId) <- pluginUpdateIdMap
         if !(pluginsDir / s"$name-$updateId.zip").toIO.exists) {
      val url =
        s"https://plugins.jetbrains.com/plugin/download?pr=idea&updateId=$updateId"
      print(s"Downloading $name plugin from $url ... ")
      %%('wget, "-q", "-O", s"$name-$updateId.zip", url)(pluginsDir)
      println("done!")
    }
    for ((name, (version, url)) <- pluginUpdateUrlMap
         if !(pluginsDir / s"$name-$version.zip").toIO.exists) {
      print(s"Downloading $name plugin from $url ... ")
      %%('wget, "-q", "-O", s"$name-$version.zip", url)(pluginsDir)
      println("done!")
    }
  }

  def extractPlugins(p: Path): Unit = {
    println("Downloading idea plugins ...")
    for ((name, updateId) <- pluginUpdateIdMap) {
      jarPlugins.get(name) match {
        case Some(_) =>
          print(s"Copying $name plugin ... ")
          %%('cp,
             ideaDir / 'plugins / s"$name-$updateId.zip",
             p / jarPlugins(name))(p)
        case _ =>
          print(s"Extracting $name plugin ... ")
          %%('unzip, "-oq", ideaDir / 'plugins / s"$name-$updateId.zip")(p)
      }
      println("done!")
    }
    for ((name, (version, _)) <- pluginUpdateUrlMap) {
      jarPlugins.get(name) match {
        case Some(_) =>
          print(s"Copying $name plugin ... ")
          %%('cp,
             ideaDir / 'plugins / s"$name-$version.zip",
             p / jarPlugins(name))(p)
        case _ =>
          print(s"Extracting $name plugin ... ")
          %%('unzip, "-oq", ideaDir / 'plugins / s"$name-$version.zip")(p)
      }
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
        content.substring(0, j) + s"<string>Sireum$ideaVer$dev" + content
          .substring(k)
      case "win" =>
        s"idea.config.path=$${user.home}/.Sireum$ideaVer$dev/config\r\nidea.system.path=$${user.home}/.Sireum$ideaVer$dev/system\r\n" + content
      case "linux" =>
        s"idea.config.path=$${user.home}/.Sireum$ideaVer$dev/config\nidea.system.path=$${user.home}/.Sireum$ideaVer$dev/system\n" + content
    }
    rm ! p
    write(p, newContent)
    println("done!")
  }

  def patchVMOptions(platform: String, p: Path): Unit = {
    print(s"Patching $p ... ")
    val content = read ! p
    val dev = if (isDev) "-dev" else ""
    val newContent = platform match {
      case "win" =>
        s"${content.trim}\r\n-Dorg.sireum.ive=Sireum$ideaVer$dev\r\n-Dorg.sireum.ive.dev=$isDev\r\n-Dfile.encoding=UTF-8\r\n"
      case _ =>
        s"${content.trim}\n-Dorg.sireum.ive=Sireum$ideaVer$dev\n-Dorg.sireum.ive.dev=$isDev\n-Dfile.encoding=UTF-8\n"
    }
    rm ! p
    write(p, newContent)
    println("done!")
  }

  def patchImages(path: Path): Unit = {
    val filePath = path / 'lib / "resources.jar"
    print(s"Patching $filePath ... ")
    if (isDev)
      %%('zip,
         filePath,
         "idea_community_about.png",
         "idea_community_about@2x.png",
         "idea_community_logo.png",
         "idea_community_logo@2x.png")(
        pwd / 'resources / 'distro / 'images / 'dev)
    else
      %%('zip,
         filePath,
         "idea_community_about.png",
         "idea_community_about@2x.png",
         "idea_community_logo.png",
         "idea_community_logo@2x.png")(pwd / 'resources / 'distro / 'images)
    println("done!")
  }

  def patchIconExe(filePath: Path): Unit = {
    require(hasExes)
    print(s"Replacing $filePath ... ")
    %%('cp, pwd / 'distros / filePath.last, filePath)
    println("done!")
  }

  def patchIcon(platform: String, path: Path): Unit = {
    val iconsPath = pwd / 'resources / 'distro / 'icons
    val (dirPath, srcFilename, filename) = platform match {
      case "mac" =>
        if (isDev) (path / 'Resources, "idea-dev.icns", "idea.icns")
        else (path / 'Resources, "idea.icns", "idea.icns")
      case "win" =>
        patchIconExe(path / 'bin / "idea.exe")
        patchIconExe(path / 'bin / "idea64.exe")
        if (isDev) (path / 'bin, "idea-dev.ico", "idea.ico")
        else (path / 'bin, "idea.ico", "idea.ico")
      case "linux" =>
        if (isDev) (path / 'bin, "idea-dev.png", "idea.png")
        else (path / 'bin, "idea.png", "idea.png")
    }
    print(s"Replacing icon $dirPath/$filename ... ")
    %%('cp, srcFilename, dirPath / filename)(iconsPath)
    println("done!")
    val iconsJar = path / 'lib / "icons.jar"
    print(s"Patching $iconsJar ... ")
    val jis = new JarInputStream(new FileInputStream(iconsJar.toIO))
    var entries = Set[String]()
    var done = false
    do {
      Option(jis.getNextEntry) match {
        case Some(e) if !e.isDirectory => entries += e.getName
        case None                      => done = true
        case _                         =>
      }
    } while (!done)
    val entriesToUpdate =
      (for (f <- iconsPath.toIO.listFiles if !ignoredIcons.contains(f.getName))
        yield {
          require(entries.contains(f.getName),
                  s"File ${f.getName} is not in $iconsJar.")
          f.getName
        }).toVector
    val cmd = "zip" +: iconsJar.toString +: entriesToUpdate
    Shellout.executeStream(iconsPath,
                           Command(cmd, Map(), Shellout.executeStream))
    println("done!")
  }

  def buildIVE(platform: String): Unit = {
    println(s"Building Sireum$dev IVE ${platform}64 distro ...")
    val url =
      s"https://download.jetbrains.com/idea/ideaIC-$ideaVer${ideaExtMap(platform)}"
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
        val filter: FilenameFilter = (_: File, name: String) =>
          name.startsWith("IntelliJ")
        val dirPath = Path((root / 'Volumes).toIO.listFiles(filter)(0))
        val appPath = dirPath / dirPath.toIO.listFiles(filter)(0).getName
        %%('cp, "-R", appPath, tempDir / "Sireum.app")
        %%("hdiutil", "eject", dirPath)
        println("done!")
        extractPlugins(tempDir / "Sireum.app" / 'Contents / 'plugins)
        patchIdeaProperties(platform,
                            tempDir / "Sireum.app" / 'Contents / "Info.plist")
        patchVMOptions(
          platform,
          tempDir / "Sireum.app" / 'Contents / 'bin / "idea.vmoptions")
        patchImages(tempDir / "Sireum.app" / 'Contents)
        patchIcon(platform, tempDir / "Sireum.app" / 'Contents)
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
        patchImages(tempDir)
        patchIcon(platform, tempDir)
        %%('cp,
           "-p",
           pwd / 'resources / 'distro / "idea.bat",
           buildDir / platform / "sireum-v3")
        %%('cp,
           "-p",
           pwd / 'resources / 'distro / "idea64.bat",
           buildDir / platform / "sireum-v3")
        if (isDev)
          mv(buildDir / platform / "sireum-v3",
             buildDir / platform / s"sireum-v3$dev")
      case "linux" =>
        val tempDir = buildDir / platform / "sireum-v3" / 'apps
        mkdir ! tempDir
        %%("tar", "xf", file)(tempDir)
        mv(tempDir / tempDir.toIO.listFiles()(0).getName, tempDir / 'idea)
        println("done!")
        extractPlugins(tempDir / 'idea / 'plugins)
        patchIdeaProperties(platform,
                            tempDir / 'idea / 'bin / "idea.properties")
        patchVMOptions(platform, tempDir / 'idea / 'bin / "idea.vmoptions")
        patchVMOptions(platform, tempDir / 'idea / 'bin / "idea64.vmoptions")
        patchImages(tempDir / 'idea)
        patchIcon(platform, tempDir / 'idea)
        %%('cp,
           "-p",
           pwd / 'resources / 'distro / 'idea,
           buildDir / platform / "sireum-v3")
        %%('chmod, "+x", buildDir / platform / "sireum-v3" / 'idea)
        if (isDev)
          mv(buildDir / platform / "sireum-v3",
             buildDir / platform / s"sireum-v3$dev")
    }
    print("Extracting Sireum v3 distro ... ")
    platform match {
      case "mac" =>
        %%('unzip,
           "-oq",
           baseDir / 'distros / s"sireum-v3$dev-${platform}64.zip")(
          ideaDir / platform / "Sireum.app" / "Contents" / "Resources")
        if (isDev) {
          mv(
            ideaDir / platform / "Sireum.app" / "Contents" / "Resources" / s"sireum-v3$dev",
            ideaDir / platform / "Sireum.app" / "Contents" / "Resources" / "sireum-v3")
          mv(ideaDir / platform / "Sireum.app",
             ideaDir / platform / s"Sireum$dev.app")
        }
      case _ =>
        %%('unzip,
           "-oq",
           baseDir / 'distros / s"sireum-v3$dev-${platform}64.zip")(
          ideaDir / platform)
        mv(ideaDir / platform / s"sireum-v3$dev",
           ideaDir / platform / s"Sireum$dev")
    }
    println("done!")
    print(s"Packaging ${platform}64 idea distro ... ")
    platform match {
      case "mac" =>
        val bundle = baseDir / 'distros / s"sireum-v3$dev-ive-mac64.tar.gz"
        val bundleDmg = baseDir / 'distros / s"sireum-v3$dev-ive-mac64.dmg"
        rm ! bundle
        rm ! bundleDmg
        %%('tar, 'cfz, bundle, s"Sireum$dev.app")(ideaDir / platform)
        val ver =
          (read ! baseDir / 'distros / s"sireum-v3$dev-VER").substring(0, 7)
        val app = ideaDir / platform / s"Sireum$dev.app"
        val background = pwd / 'resources / 'distro / 'images / "dmg-background.png"
        val settings = pwd / 'resources / 'distro / "dmgbuild-settings.py"
        %%('dmgbuild,
           "-s",
           settings,
           "-D",
           s"app=$app",
           "-D",
           s"background=$background",
           s"Sireum v3 $ver",
           bundleDmg)(baseDir / 'distros)
        rm ! ideaDir / platform
      case "linux" =>
        val bundle = baseDir / 'distros / s"sireum-v3$dev-ive-linux64.zip"
        rm ! bundle
        %%('zip, "-r", bundle, s"Sireum$dev")(ideaDir / platform)
        rm ! ideaDir / platform
      case "win" =>
        val bundle = baseDir / 'distros / s"sireum-v3$dev-ive-win64.zip"
        rm ! bundle
        %%('zip, "-r", bundle, s"Sireum$dev")(ideaDir / platform)
        rm ! ideaDir / platform
    }
    println("done!")
  }

  def build(): Unit = {
    rm ! baseDir / 'distros / s"sireum-v3$dev-mac64.zip"
    rm ! baseDir / 'distros / s"sireum-v3$dev-win64.zip"
    rm ! baseDir / 'distros / s"sireum-v3$dev-linux64.zip"
    rm ! baseDir / 'distros / s"sireum-v3-wsd-mac64.zip"
    rm ! baseDir / 'distros / s"sireum-v3-wsd-win64.zip"
    rm ! baseDir / 'distros / s"sireum-v3-wsd-linux64.zip"
    rm ! baseDir / 'distros / s"sireum-v3$dev-VER"
    write(baseDir / 'distros / s"sireum-v3$dev-VER", VER)
    build("mac")
    build("win")
    build("linux")
  }

  def build(platform: String): Unit = {
    println(s"Building Sireum$dev for ${platform}64...")
    println()
    rm ! baseDir / 'distros / "sireum-v3"
    if (isDev) rm ! baseDir / 'distros / "sireum-v3-dev"
    mkdir ! baseDir / 'distros / "sireum-v3" / 'bin
    write(baseDir / 'distros / "sireum-v3" / 'bin / 'VER, VER)
    val licenseLines = read.lines ! pwd / "license.txt"
    platform match {
      case "win" =>
        write(baseDir / 'distros / "sireum-v3" / "license.txt",
              licenseLines.mkString("\r\n"))
        cp(pwd / 'resources / 'distro / "sireum.bat",
           baseDir / 'distros / "sireum-v3" / "sireum.bat")
      case _ =>
        write(baseDir / 'distros / "sireum-v3" / "license.txt",
              licenseLines.mkString("\n"))
        cp(pwd / "sireum", baseDir / 'distros / "sireum-v3" / "sireum")
    }
    cp(pwd / 'bin / "sireum.jar",
       baseDir / 'distros / "sireum-v3" / 'bin / "sireum.jar")
    cp(pwd / 'bin / "prelude.sh",
       baseDir / 'distros / "sireum-v3" / 'bin / "prelude.sh")
    %('bash,
      baseDir / 'distros / "sireum-v3" / 'bin / "prelude.sh",
      PLATFORM = platform,
      DISTROS = "true")
    rm ! baseDir / 'distros / "sireum-v3" / 'bin / "prelude.sh"
    if (isDev)
      mv(baseDir / 'distros / "sireum-v3",
         baseDir / 'distros / s"sireum-v3$dev")
    %('zip, "-qr", s"sireum-v3$dev-${platform}64.zip", s"sireum-v3$dev")(
      baseDir / 'distros)

    println(s"Building Sireum WSD for ${platform}64...")
    println()

    rm ! baseDir / 'distros / "sireum-v3-wsd"
    mkdir ! baseDir / 'distros / "sireum-v3-wsd"

    platform match {
      case "win" =>
        cp(
          baseDir / 'distros / s"sireum-v3$dev" / 'platform / 'node / 'bin / "node.exe",
          baseDir / 'distros / "sireum-v3-wsd" / "node.exe")
        cp(
          baseDir / 'distros / s"sireum-v3$dev" / 'apps / 'z3 / 'bin / "z3.exe",
          baseDir / 'distros / "sireum-v3-wsd" / "z3.exe")
        write(
          baseDir / 'distros / "sireum-v3-wsd" / "run.bat",
          """@echo off
            |setlocal
            |set SCRIPT_HOME=%~dp0
            |set PATH=%SCRIPT_HOME%;%PATH%
            |node.exe %SCRIPT_HOME%\wsd.js %*
          """.stripMargin.trim
        )
      case _ =>
        cp(
          baseDir / 'distros / s"sireum-v3$dev" / 'platform / 'node / 'bin / 'node,
          baseDir / 'distros / "sireum-v3-wsd" / 'node)
        cp(baseDir / 'distros / s"sireum-v3$dev" / 'apps / 'z3 / 'bin / 'z3,
           baseDir / 'distros / "sireum-v3-wsd" / 'z3)
        write(
          baseDir / 'distros / "sireum-v3-wsd" / "run.sh",
          """#!/bin/bash -e
            |SCRIPT_HOME=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
            |export PATH=$SCRIPT_HOME:$PATH
            |node $SCRIPT_HOME/wsd.js $*
          """.stripMargin.trim
        )
        %('chmod, "755", "run.sh")(baseDir / 'distros / "sireum-v3-wsd")
    }
    cp(pwd / 'resources / 'distro / "wsd.js" / "wsd.js",
       baseDir / 'distros / "sireum-v3-wsd" / "wsd.js")
    %%('npm, "install", "ws")(baseDir / 'distros / "sireum-v3-wsd")
    rm ! baseDir / 'distros / "sireum-v3-wsd" / "package-lock.json"

    %('zip, "-qr", s"sireum-v3-wsd-${platform}64.zip", s"sireum-v3-wsd")(
      baseDir / 'distros)

    rm ! baseDir / 'distros / s"sireum-v3-wsd"
    rm ! baseDir / 'distros / s"sireum-v3$dev"
  }
}
