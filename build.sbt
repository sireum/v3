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

import ProjectInfo._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.complete.Parsers.spaceDelimited
import sbtassembly.AssemblyKeys.{assemblyMergeStrategy, assemblyOutputPath}
import sbtassembly.{AssemblyUtils, MergeStrategy}
import sbtassembly.AssemblyPlugin._
import org.scalajs.jsdependencies.sbtplugin.AbstractJSDep
import sbt.Project

val isRelease = System.getenv("SIREUM_RELEASE") != null

lazy val properties = {
  def findPropFile(): String = {
    def err(): Nothing = {
      throw new Error("Need to supply property 'org.sireum.version.file', property 'org.sireum.home', or 'SIREUM_HOME' env var.")
    }
    def checkFile(f: File): String = {
      if (f.isFile && f.canRead) return f.getCanonicalFile.getAbsolutePath
      err()
    }
    val propFile = System.getProperty("org.sireum.version.file")
    if (propFile == null) {
      var sireumHome = System.getProperty("org.sireum.home")
      if (sireumHome != null) {
        return checkFile(new File(sireumHome, "versions.properties"))
      }
      sireumHome = System.getenv("SIREUM_HOME") 
      if (sireumHome != null) {
        return checkFile(new File(sireumHome, "versions.properties"))
      }
      err()
    } else {
      checkFile(new File(propFile))
    }
  }
  val propFile = findPropFile()
  println(s"[info] Loading Sireum dependency versions from $propFile ...")
  val ps = new _root_.java.util.Properties()
  IO.load(ps, new File(propFile))
  ps
}

def property(key: String): String = {
  val value = properties.getProperty(key)
  if (value == null) {
    throw new Error(s"Need to supply property '$key'.")
  }
  value
}

def ghLatestTag(owner: String, repo: String): String = {
  import ammonite.ops._
  val out = %%("git", "ls-remote", "--tags", "--refs", "--sort=v:refname", s"https://github.com/$owner/$repo.git")(pwd).out
  val lines = for (line <- out.lines if line.contains("refs/tags/4.")) yield line
  val last = lines(lines.length - 1)
  last.substring(last.indexOf("refs/tags/") + "refs/tags/".length).trim
}

val sireumVersion = "3"

lazy val scalaVer = property("org.sireum.version.scala")

lazy val scalaPar = property("org.sireum.version.parcollection")

lazy val sireumScalacVersion = property("org.sireum.version.scalac-plugin") // ghLatestTag("sireum", "scalac-plugin")

lazy val metaVersion = property("org.sireum.version.scalameta")

lazy val scalaTestVersion = property("org.sireum.version.scalatest")

lazy val scalaJsDomVersion = property("org.sireum.version.scalajsdom")

lazy val scalaJsJQueryVersion = property("org.sireum.version.scalajsjquery")

lazy val scalaTagsVersion = property("org.sireum.version.scalatags")

lazy val parboiled2Version = property("org.sireum.version.parboiled2")

lazy val shapelessVersion = property("org.sireum.version.shapeless")

lazy val caskVersion = property("org.sireum.version.cask")

lazy val asmVersion = property("org.sireum.version.asm")

lazy val jgraphtVersion = property("org.sireum.version.jgrapht")

lazy val upickleVersion = property("org.sireum.version.upickle")

lazy val java8CompatVersion = property("org.sireum.version.java8compat")

lazy val antlrRuntimeVersion = property("org.sireum.version.antlr")

lazy val stVersion = property("org.sireum.version.stringtemplate")

lazy val ammoniteOpsVersion = property("org.sireum.version.ammonite-ops")

lazy val diffVersion = property("org.sireum.version.diff")

lazy val snakeYamlVersion = property("org.sireum.version.snakeyaml")

lazy val junitInterfaceVersion = property("org.sireum.version.junit-interface")

lazy val nuprocessVersion = property("org.sireum.version.nuprocess")

lazy val utestVersion = property("org.sireum.version.utest")

lazy val runtimeVersion = property("org.sireum.version.library") // ghLatestTag("sireum", "kekinian")

val BUILD_FILENAME = "BUILD"

val isParallelBuild = "false" != System.getenv("SIREUM_PARALLEL_BUILD")

val distros = TaskKey[Unit]("distros", "Build Sireum distributions.")
val iveDistros = TaskKey[Unit]("ive-distros", "Build Sireum IVE distributions.")
val devDistros = TaskKey[Unit]("dev-distros", "Build Sireum-dev distributions.")
val devIveDistros = TaskKey[Unit]("dev-ive-distros", "Build Sireum-dev IVE distributions.")
val depDot = InputKey[Unit]("dep-dot", "Print project dependency in dot.")
val refreshSlang = TaskKey[Unit]("refresh-slang", "Refresh Slang files.")

Global / parallelExecution := isParallelBuild
Global / concurrentRestrictions ++= (if (isParallelBuild) Seq() else Seq(Tags.limitAll(1)))

addCommandAlias("refresh-slang", "; project sireum; refreshSlang")
addCommandAlias("fatjar", "; project sireum; assembly")

lazy val sireumSettings = Seq(
  organization := "org.sireum",
  version := sireumVersion,
  incOptions := incOptions.value.withLogRecompileOnMacro(false),
  scalaVersion := scalaVer,
  retrieveManaged := true,
  scalacOptions ++= Seq(
    "-target:jvm-1.8",
    "-deprecation",
    "-Ydelambdafy:method",
    "-feature",
    "-unchecked",
    "-Xfatal-warnings"
  ),
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "utf8"),
  Compile / doc / javacOptions := Seq("-notimestamp", "-linksource"),
  Compile / doc / scalacOptions := Seq("-groups", "-implicits"),
  Test / logBuffered := false,
  autoAPIMappings := true,
  apiURL := Some(url("http://v3.sireum.org/api/")),
  resolvers ++= Seq(Resolver.sonatypeRepo("public"), "jitpack" at "https://jitpack.io"),
  dependencyUpdatesFilter -= moduleFilter(organization = "com.lihaoyi", name = "upickle"),
  dependencyUpdatesFilter -= moduleFilter(organization = "org.scalatest"),
  dependencyUpdatesFilter -= moduleFilter(organization = "org.eclipse.jetty")
)

lazy val sireumSharedSettings = sireumSettings ++ Seq(
  libraryDependencies ++= Seq("com.lihaoyi" %%% "upickle" % upickleVersion)
)

lazy val sireumJvmSettings = sireumSharedSettings ++ Seq(
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVer,
    "org.scala-lang" % "scala-compiler" % scalaVer,
    "org.scala-lang.modules" %% "scala-java8-compat" % java8CompatVersion,
    "org.antlr" % "antlr4-runtime" % antlrRuntimeVersion,
    "org.antlr" % "ST4" % stVersion,
    "org.yaml" % "snakeyaml" % snakeYamlVersion,
    "org.ow2.asm" % "asm" % asmVersion,
    "org.ow2.asm" % "asm-commons" % asmVersion,
    "org.ow2.asm" % "asm-util" % asmVersion,
    "org.jgrapht" % "jgrapht-core" % jgraphtVersion,
    "org.jgrapht" % "jgrapht-io" % jgraphtVersion,
    "com.lihaoyi" %% "ammonite-ops" % ammoniteOpsVersion,
    "com.sksamuel.diff" % "diff" % diffVersion,
    "com.zaxxer" % "nuprocess" % nuprocessVersion,
    "com.novocode" % "junit-interface" % junitInterfaceVersion
  ),
  testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")
)

lazy val sireumJsSettings = sireumSharedSettings ++ Seq(
  scalacOptions ++= Seq("-feature"),
  //relativeSourceMaps := true,
  Global / scalaJSStage := (if (isRelease) FullOptStage else FastOptStage),
  libraryDependencies ++= Seq("org.scala-lang" % "scala-reflect" % scalaVer, "com.lihaoyi" %%% "utest" % utestVersion),
  testFrameworks += new TestFramework("utest.runner.Framework")
)

lazy val webSettings = sireumSettings ++ Seq(
  Compile / fastOptJS / crossTarget := (Compile / classDirectory).value,
  Compile / packageJSDependencies / crossTarget := (Compile / classDirectory).value,
  Compile / fullOptJS / crossTarget := (Compile / classDirectory).value / "min",
  Compile / packageMinifiedJSDependencies / crossTarget := (Compile / classDirectory).value / "min",
  packageJSDependencies / skip := false,
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % scalaJsDomVersion,
    "org.scala-js" %%% "scala-js-macrotask-executor" % "1.0.0",
    "be.doeraene" %%% "scalajs-jquery" % scalaJsJQueryVersion,
    "com.lihaoyi" %%% "scalatags" % scalaTagsVersion
  )
)

lazy val commonSlangSettings = Seq(
  addCompilerPlugin("org.sireum" %% "scalac-plugin" % sireumScalacVersion),
  libraryDependencies += "org.sireum.kekinian" %%% "library-shared" % runtimeVersion)

lazy val slangSettings = sireumSettings ++ commonSlangSettings ++ Seq(
  scalacOptions ++= Seq("-Yrangepos"),
  libraryDependencies += "org.sireum.kekinian" %%% "test" % runtimeVersion % "test")

val depOpt = Some("test->test;compile->compile;test->compile")

def toSbtJvmProject(pi: ProjectInfo, settings: Seq[Def.Setting[_]] = sireumJvmSettings): Project =
  Project(id = pi.id, base = pi.baseDir / "jvm")
    .settings(Seq(name := pi.name) ++ settings: _*)
    .dependsOn(pi.dependencies.flatMap { p =>
      if (p.isCross)
        Seq(ClasspathDependency(LocalProject(p.id), depOpt), ClasspathDependency(LocalProject(p.id + "-jvm"), depOpt))
      else Seq(ClasspathDependency(LocalProject(p.id), depOpt))
    }: _*)
    .settings()
    .disablePlugins(AssemblyPlugin)

def toSbtCrossProject(pi: ProjectInfo, settings: Seq[Def.Setting[_]] = Vector()): (Project, Project, Project) = {
  val shared = Project(id = pi.id, base = pi.baseDir / "shared")
    .settings(Seq(name := pi.name) ++ sireumSharedSettings ++ settings: _*)
    .dependsOn(pi.dependencies.map { p =>
      ClasspathDependency(LocalProject(p.id), depOpt)
    }: _*)
    .disablePlugins(AssemblyPlugin)
  val cp = crossProject(JSPlatform, JVMPlatform).crossType(CrossType.Full)
    .in(file("."))
    .settings(name := pi.id)
    .jvmConfigure((it: sbt.Project) => { it.withId( pi.id + "-jvm").in(pi.baseDir/"jvm")})
    .jsConfigure(_.withId(pi.id + "-js").in(pi.baseDir/"js"))
    .jsConfigure(_.enablePlugins(JSDependenciesPlugin))
  val jvm =
    cp.jvm
      .settings(sireumJvmSettings ++ settings)
      .settings(name := pi.id + "-jvm")
      .disablePlugins(AssemblyPlugin)
      .dependsOn(shared % depOpt.get)
      .dependsOn(pi.dependencies.map { p =>
        ClasspathDependency(LocalProject(p.id), depOpt)
      }: _*)
      .dependsOn(pi.dependencies.map { p =>
        ClasspathDependency(LocalProject(p.id + "-jvm"), depOpt)
      }: _*)
  val js =
    cp.js
      .settings(sireumJsSettings ++ settings)
      .disablePlugins(AssemblyPlugin)
      .dependsOn(shared % depOpt.get)
      .dependsOn(pi.dependencies.map { p =>
        ClasspathDependency(LocalProject(p.id), depOpt)
      }: _*)
      .dependsOn(pi.dependencies.map { p =>
        ClasspathDependency(LocalProject(p.id + "-js"), depOpt)
      }: _*)
  (shared, jvm, js)
}

// Cross Projects
lazy val utilPI = new ProjectInfo("util", isCross = true)
lazy val utilT = toSbtCrossProject(utilPI)
lazy val utilShared = utilT._1
lazy val utilJvm = utilT._2
lazy val utilJs = utilT._3.settings(webSettings: _*)

lazy val testPI = new ProjectInfo("test", isCross = true, utilPI)
lazy val testT = toSbtCrossProject(testPI)
lazy val testShared = testT._1
lazy val testJvm = testT._2
lazy val testJs = testT._3

lazy val pilarPI = new ProjectInfo("pilar", isCross = true, utilPI, testPI)
lazy val pilarT = toSbtCrossProject(pilarPI)
lazy val pilarShared = pilarT._1
lazy val pilarJvm = pilarT._2
lazy val pilarJs = pilarT._3

lazy val logikaPI = new ProjectInfo("logika", isCross = true, utilPI, testPI)
lazy val logikaT = toSbtCrossProject(logikaPI)
lazy val logikaShared = logikaT._1
lazy val logikaJvm = logikaT._2
  .settings(
    Compile / unmanagedResourceDirectories ++= Seq(
      logikaT._2.base / "c-runtime" / "include",
      logikaT._2.base / "c-runtime" / "src",
      logikaT._2.base / "c-runtime" / "cmake"
    ),
    libraryDependencies += "org.sireum.kekinian" %% "library" % runtimeVersion
  )
lazy val logikaJs = logikaT._3

lazy val webPI = new ProjectInfo("web", isCross = true, utilPI)
lazy val webT = toSbtCrossProject(webPI, slangSettings)
lazy val webShared = webT._1
lazy val webJvm = webT._2
lazy val webJs = webT._3.settings(webSettings: _*)

lazy val airPI = new ProjectInfo("aadl/ir", isCross = true, utilPI, testPI)
lazy val airT = toSbtCrossProject(airPI,slangSettings)
lazy val airShared = airT._1
lazy val airJvm = airT._2
lazy val airJs = airT._3

// Jvm Projects

lazy val javaPI = new ProjectInfo("java", isCross = false, utilPI, testPI, pilarPI)
lazy val java = toSbtJvmProject(javaPI)

lazy val cliPI = new ProjectInfo("cli", isCross = false, utilPI, testPI, pilarPI, javaPI, logikaPI)
lazy val cli = toSbtJvmProject(cliPI, sireumJvmSettings ++ commonSlangSettings)

lazy val awasPI = new ProjectInfo("awas", isCross = true, utilPI, testPI, airPI)
lazy val awasT = toSbtCrossProject(
  awasPI,
  slangSettings ++ Seq(
  Test / parallelExecution := false,
  libraryDependencies ++= Seq(
    "com.chuusai" %%% "shapeless" % shapelessVersion,
    "com.lihaoyi" %%% "scalatags" % scalaTagsVersion,
    "org.parboiled" %%% "parboiled" % parboiled2Version,
    "org.scala-lang.modules" %% "scala-async" % "0.10.0",
    "com.lihaoyi" %% "cask" % caskVersion,
    "com.github.japgolly.scalajs-react" %% "extra_sjs1" % "1.7.7"
  )))

lazy val awasShared = awasT._1
lazy val awasJvm = awasT._2

def getAwasJSDep(base : File) : Seq[AbstractJSDep] = {
  val finder: PathFinder = (base / "src") ** "*.js"
  if (finder.get.nonEmpty) {
    Seq(
      ProvidedJS / "min/jquery.js",
      ProvidedJS / "min/goldenlayout.js" dependsOn "min/jquery.js",
      ProvidedJS / "min/viz.js" dependsOn "min/jquery.js",
      //      ProvidedJS / "min/SVGPanZoom.min.js" dependsOn "min/jquery.js",
      ProvidedJS / "min/svg-pan-zoom.min.js",
      ProvidedJS / "min/jquery.treetable.js" dependsOn "min/jquery.js",
      ProvidedJS / "min/jquery.terminal.min.js" dependsOn "min/jquery.js",
      ProvidedJS / "min/jquery.mousewheel-min.js" dependsOn "min/jquery.js",
      ProvidedJS / "min/jquery.amaran.js" dependsOn "min/jquery.js",
      ProvidedJS / "min/bulma-quickview.min.js" dependsOn "min/jquery.js",
      ProvidedJS / "min/quickview.wrapper.js" dependsOn "min/jquery.js",
      ProvidedJS / "min/jquery.tinycolorpicker.js" dependsOn "min/jquery.js",
      ProvidedJS / "min/FileSaver.min.js"
    )
  } else {
    Seq()
  }
}

lazy val awasJs = {
//  println("-------------"+baseDirectory.value.getPath)
  awasT._3.enablePlugins(ScalaJSBundlerPlugin).enablePlugins(JSDependenciesPlugin)
    .settings(webSettings: _*)
    .settings(
      jsDependencies ++= getAwasJSDep(baseDirectory.value),
      webpack / version := "4.20.2",
      webpackMonitoredDirectories += baseDirectory.value / "min/css",
      webpackBundlingMode := BundlingMode.LibraryAndApplication(),
      scalaJSLinkerConfig ~= {
        _.withModuleKind(ModuleKind.CommonJSModule)
      },
      packageJSDependencies / skip := false
    )
  }

lazy val awasJarPI = new ProjectInfo("awas-jar", isCross = false, awasPI)

val commonMergeStratergy: Def.Initialize[String => MergeStrategy] = Def.setting {
  case PathList("scalac-plugin.xml") => MergeStrategy.discard
  case PathList("transformed", _*) => MergeStrategy.discard
  case PathList("Scratch.class") => MergeStrategy.discard
  case PathList("Scratch$.class") => MergeStrategy.discard
  case PathList("Scratch$delayedInit$body.class") => MergeStrategy.discard
  case PathList("sh4d3", "scala", "meta", _*) => MergeStrategy.first
  case PathList("sh4d3", "sourcecode", _*) => MergeStrategy.first
  case PathList("sh4d3", "geny", _*) => MergeStrategy.first
  case PathList("scala-collection-compat.properties") => MergeStrategy.first
  case PathList("org", "sireum", _*) =>
    new MergeStrategy {
      override def name: String = "sireum"

      override def apply(tempDir: File, path: String, files: Seq[File]): Either[String, Seq[(File, String)]] = {
        if (files.size == 1) return Right(Seq(files.head -> path))
        val nonSharedFiles =
          files.flatMap { f =>
            val sourceDir = AssemblyUtils.sourceOfFileForMerge(tempDir, f)._1
            if (sourceDir.getAbsolutePath.contains("/shared/")) None else Some(f)
          }
        Right(Seq(nonSharedFiles.head -> path))
      }
    }
  case "module-info.class" => MergeStrategy.discard
  case x =>
    (assembly / assemblyMergeStrategy).value(x)

}


lazy val awasJar = project.enablePlugins(AssemblyPlugin).dependsOn(awasJarPI.dependencies.map { p => ClasspathDependency(LocalProject(p.id + "-jvm"), depOpt)
}: _*)
  .settings(scalaVersion := scalaVer,
    assemblySettings ++ Seq(
      assembly / logLevel := Level.Error,
      assembly / assemblyJarName := "awas.jar",
      assembly / assemblyOption := (assembly / assemblyOption).value.copy(includeScala = false),
      assembly / assemblyExcludedJars := {
        val cp = (assembly / fullClasspath).value
        cp filter { x =>
          x.data.getName.contains("scalapb") ||
            x.data.getName.contains("protobuf") ||
            x.data.getName.contains("junit")
        }
      },
      assembly / assemblyMergeStrategy := commonMergeStratergy.value,
      skip / publish := true))

lazy val awasPub = project.settings(name := "awas-pub",
  Compile / packageBin := (assembly in(awasJar, Compile)).value)


lazy val minixPI = new ProjectInfo("aadl/minix", isCross = false, airPI)
lazy val minix = toSbtJvmProject(minixPI, slangSettings)

lazy val subProjectsJvm = Seq(
  utilJvm,
  testJvm,
  pilarJvm,
  logikaJvm,
  java,
  cli,
  awasJvm,
  airJvm,
  minix
)

// Js Projects

lazy val subProjectsJs = Seq(
  utilJs,
  testJs,
  pilarJs,
  logikaJs,
  awasJs,
  airJs
)

lazy val subProjectJvmReferences =
  subProjectsJvm.map(x => x: ProjectReference)

lazy val subProjectJvmClasspathDeps =
  subProjectsJvm.map(x => x: ClasspathDep[ProjectReference])

lazy val subProjectJsReferences =
  subProjectsJs.map(x => x: ProjectReference)

lazy val sireumJvm =
  Project(id = "sireum-jvm", base = file("jvm"))
    .settings(
      sireumJvmSettings ++ assemblySettings ++
        Seq(
          name := "Sireum.jvm",
          libraryDependencies += "org.sireum" %% "scalac-plugin" % sireumScalacVersion,
          assembly / mainClass := Some("org.sireum.cli.Sireum"),
          assembly / assemblyOutputPath := file("bin/sireum.jar"),
          assembly / test := {},
          assembly / logLevel := Level.Error,
          assembly / assemblyExcludedJars := {
            val cp = (assembly / fullClasspath).value
            cp filter { x =>
              x.data.getName.contains("scalapb") || x.data.getName.contains("protobuf")
            }
          },
          assembly / assemblyShadeRules := Seq(
            ShadeRule.rename("com.novocode.**" -> "sh4d3.com.novocode.@1").inAll,
            ShadeRule.rename("com.sksamuel.**" -> "sh4d3.com.sksamuel.@1").inAll,
            ShadeRule.rename("com.trueaccord.**" -> "sh4d3.com.trueaccord.@1").inAll,
            ShadeRule.rename("fastparse.**" -> "sh4d3.fastparse.@1").inAll,
            ShadeRule.rename("com.zaxxer.**" -> "sh4d3.com.zaxxer.@1").inAll,
            ShadeRule.rename("google.**" -> "sh4d3.google.@1").inAll,
            ShadeRule.rename("org.langmeta.**" -> "sh4d3.org.langmeta.@1").inAll,
            ShadeRule.rename("org.scalameta.**" -> "sh4d3.org.scalameta.@1").inAll,
            ShadeRule.rename("scala.meta.**" -> "sh4d3.scala.meta.@1").inAll,
            ShadeRule.rename("scalapb.**" -> "sh4d3.scalapb.@1").inAll,
            ShadeRule.rename("upickle.**" -> "sh4d3.upickle.@1").inAll,
            ShadeRule.rename("sbt.**" -> "sh4d3.sbt.@1").inAll,
            ShadeRule.rename("org.yaml.**" -> "sh4d3.org.yaml.@1").inAll,
            ShadeRule.rename("org.stringtemplate.**" -> "sh4d3.org.stringtemplate.@1").inAll,
            ShadeRule.rename("org.objectweb.**" -> "sh4d3.org.objectweb.@1").inAll,
            ShadeRule.rename("org.junit.**" -> "sh4d3.org.junit.@1").inAll,
            ShadeRule.rename("org.jgrapht.**" -> "sh4d3.org.jgrapht.@1").inAll,
            ShadeRule.rename("org.hamcrest.**" -> "sh4d3.org.hamcrest.@1").inAll,
            ShadeRule.rename("org.apache.**" -> "sh4d3.org.apache.@1").inAll,
            ShadeRule.rename("org.antlr.**" -> "sh4d3.org.antlr.@1").inAll,
            ShadeRule.rename("org.scalatools.**" -> "sh4d3.org.scalatools.@1").inAll,
            ShadeRule.rename("machinist.**" -> "sh4d3.machinist.@1").inAll,
            ShadeRule.rename("junit.**" -> "sh4d3.junit.@1").inAll,
            ShadeRule.rename("jawn.**" -> "sh4d3.jawn.@1").inAll,
            ShadeRule.rename("geny.**" -> "sh4d3.geny.@1").inAll,
            ShadeRule.rename("ammonite.**" -> "sh4d3.ammonite.@1").inAll,
            ShadeRule.rename("scalatags.**" -> "sh4d3.scalatags.@1").inAll,
            ShadeRule.rename("sourcecode.**" -> "sh4d3.sourcecode.@1").inAll,
            ShadeRule.rename("upack.**" -> "sh4d3.upack.@1").inAll,
            ShadeRule.rename("ujson.**" -> "sh4d3.ujson.@1").inAll,
            ShadeRule.rename("shapeless.**" -> "sh4d3.shapeless.@1").inAll,
            ShadeRule.rename("os.**" -> "sh4d3.os.@1").inLibrary("com.lihaoyi" %% "os-lib" % "latest.integration"),
            ShadeRule.rename("org.parboiled2.**" -> "sh4d3.org.parboiled2.@1").inAll,
            ShadeRule.rename("org.jheaps.**" -> "sh4d3.org.jheaps.@1").inAll,
            ShadeRule.rename("akka.**" -> "sh4d3.akka.@1").inAll,
            ShadeRule.rename("com.fasterxml.**" -> "sh4d3.com.fasterxml.@1").inAll,
            ShadeRule.rename("com.typesafe.**" -> "sh4d3.com.typesafe.@1").inAll,
            ShadeRule.rename("org.kohsuke.**" -> "sh4d3.org.kohsuke.@1").inAll
          ),
          assembly / assemblyMergeStrategy := commonMergeStratergy.value
        ): _*
    )
    .aggregate(subProjectJvmReferences: _*)
    .dependsOn(subProjectJvmClasspathDeps: _*)

lazy val sireumJs =
  Project(id = "sireum-js", base = file("js"))
    .settings(
      sireumSharedSettings ++
        Seq(name := "Sireum.js"): _*
    )
    .aggregate(subProjectJsReferences: _*)
    .disablePlugins(AssemblyPlugin)

lazy val sireum = Project(id = "sireum", base = file("."))
  .settings(
    sireumSharedSettings ++ Seq(
      name := "Sireum",
      distros := {
        Distros.build()
      },
      iveDistros := {
        Distros.buildIVE()
      },
      devDistros := {
        Distros.buildDev()
      },
      devIveDistros := {
        Distros.buildIVEDev()
      },
      depDot := {
        val args = spaceDelimited("<arg>").parsed
        dotDependency(args)
      },
      refreshSlang := {
        import ammonite.ops._
        val rootDir = baseDirectory.value
        val runtimeFile =
          Path(new File(rootDir, "runtime/library/shared/src/main/scala/org/sireum/Library_Ext.scala").getCanonicalFile)
        val slangFile =
          Path(new File(rootDir, "slang/frontend/shared/src/main/scala/org/sireum/lang/$SlangFiles.scala").getCanonicalFile)

        def touche(p: Path): Unit = {
          val text = read ! p
          if (text.charAt(text.length - 1) == '\n') {
            write.over(p, text.trim)
          } else {
            write.over(p, text + '\n')
          }
        }

        touche(runtimeFile)
        touche(slangFile)
      },
      initialize := {
        val required = Set("1.8", "9", "10", "11", "14", "15", "16", "17")
        val current = sys.props("java.specification.version")
        assert(required.contains(current), s"Unsupported Java version: $current (required: $required)")
      },
      publish := {},
      publishLocal := {}
    ): _*
  )
  .aggregate(sireumJvm, sireumJs)
  .disablePlugins(AssemblyPlugin)
