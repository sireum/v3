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
import org.scalajs.sbtplugin.cross.CrossProject
import sbt.complete.Parsers.spaceDelimited
import sbtassembly.AssemblyKeys.{assemblyMergeStrategy, assemblyOutputPath}
import sbtassembly.{AssemblyUtils, MergeStrategy}
import sbtassembly.AssemblyPlugin._

val isRelease = System.getenv("SIREUM_RELEASE") != null

val scalaVer = "2.12.2"

val metaVersion = "1.8.0"

val paradiseVersion = "3.0.0-M9"

val scalaTestVersion = "3.0.1"

val sireumVersion = "3"

val sireumScalacVersion = "3.0.0-14"

val silencerVersion = "0.5"

val BUILD_FILENAME = "BUILD"

val isParallelBuild = "false" != System.getenv("SIREUM_PARALLEL_BUILD")

val distros = TaskKey[Unit]("distros", "Build Sireum distributions.")
val iveDistros = TaskKey[Unit]("ive-distros", "Build Sireum IVE distributions.")
val devDistros = TaskKey[Unit]("dev-distros", "Build Sireum-dev distributions.")
val devIveDistros = TaskKey[Unit]("dev-ive-distros", "Build Sireum-dev IVE distributions.")
val depDot = InputKey[Unit]("dep-dot", "Print project dependency in dot.")

traceLevel in iveDistros := -1

lazy val sireumSettings = Seq(
  organization := "org.sireum",
  version := sireumVersion,
  incOptions := incOptions.value.withNameHashing(true),
  incOptions := incOptions.value.withLogRecompileOnMacro(false),
  scalaVersion := scalaVer,
  retrieveManaged := true,
  scalacOptions ++= Seq("-target:jvm-1.8", "-deprecation",
    "-Ydelambdafy:method", "-feature", "-unchecked", "-Xfatal-warnings"),
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
  javacOptions in(Compile, doc) := Seq("-notimestamp", "-linksource"),
  scalacOptions in(Compile, doc) := Seq("-groups", "-implicits"),
  logBuffered in Test := false,
  autoAPIMappings := true,
  apiURL := Some(url("http://v3.sireum.org/api/")),
  parallelExecution in Global := isParallelBuild,
  libraryDependencies += "com.github.ghik" %% "silencer-lib" % silencerVersion,
  resolvers += Resolver.sonatypeRepo("public"),
  addCompilerPlugin("com.github.ghik" %% "silencer-plugin" % "0.5")
)

lazy val sireumSharedSettings = sireumSettings ++ Seq(
  libraryDependencies ++= Seq(
    "com.lihaoyi" %%% "upickle" % "0.4.4"
  )
)

lazy val sireumJvmSettings = sireumSharedSettings ++ Seq(
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVer,
    "org.scala-lang" % "scala-compiler" % scalaVer,
    "org.scala-lang.modules" %% "scala-java8-compat" % "0.8.0",
    "org.antlr" % "antlr4-runtime" % "4.7",
    "org.antlr" % "ST4" % "4.0.8",
    "org.yaml" % "snakeyaml" % "1.18",
    "org.ow2.asm" % "asm" % "5.2",
    "org.ow2.asm" % "asm-commons" % "5.2",
    "org.ow2.asm" % "asm-util" % "5.2",
    "org.jgrapht" % "jgrapht-core" % "1.0.1",
    "org.jgrapht" % "jgrapht-ext" % "1.0.1",
    "com.lihaoyi" %% "ammonite-ops" % "1.0.0",
    "com.sksamuel.diff" % "diff" % "1.1.11",
    "com.novocode" % "junit-interface" % "0.11"
  ),
  parallelExecution in Test := true,
  testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")
)

lazy val sireumJsSettings = sireumSharedSettings ++ Seq(
  scalacOptions ++= Seq("-feature"),
  parallelExecution in Test := false,
  relativeSourceMaps := true,
  scalaJSStage in Global := (if (isRelease) FullOptStage else FastOptStage),
  jsEnv := new org.scalajs.jsenv.nodejs.NodeJSEnv(),
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVer,
    "com.lihaoyi" %%% "utest" % "0.4.8"
  ),
  testFrameworks += new TestFramework("utest.runner.Framework")
)

val depOpt = Some("test->test;compile->compile;test->compile")

def toSbtJvmProject(pi: ProjectInfo, settings: Seq[Def.Setting[_]] = sireumJvmSettings): Project =
  Project(
    id = pi.id,
    settings = settings,
    base = pi.baseDir / "jvm").
    dependsOn(pi.dependencies.flatMap { p =>
      if (p.isCross)
        Seq(ClasspathDependency(LocalProject(p.id), depOpt),
          ClasspathDependency(LocalProject(p.id + "-jvm"), depOpt))
      else Seq(ClasspathDependency(LocalProject(p.id), depOpt))
    }: _*).
    settings(name := pi.name).disablePlugins(AssemblyPlugin)

def toSbtCrossProject(pi: ProjectInfo, settings: Seq[Def.Setting[_]] = Vector()): (Project, Project, Project) = {
  val shared = Project(
    id = pi.id,
    settings = sireumSharedSettings ++ settings,
    base = pi.baseDir / "shared").
    dependsOn(pi.dependencies.map { p =>
      ClasspathDependency(LocalProject(p.id), depOpt)
    }: _*).
    settings(name := pi.name).disablePlugins(AssemblyPlugin)
  val cp = CrossProject(
    jvmId = pi.id + "-jvm",
    jsId = pi.id + "-js",
    base = pi.baseDir,
    crossType = CrossType.Full).settings(name := pi.id)
  val jvm =
    cp.jvm.settings(sireumJvmSettings ++ settings).disablePlugins(AssemblyPlugin).
      dependsOn(shared % depOpt.get).
      dependsOn(pi.dependencies.map { p =>
        ClasspathDependency(LocalProject(p.id), depOpt)
      }: _*).
      dependsOn(pi.dependencies.map { p =>
        ClasspathDependency(LocalProject(p.id + "-jvm"), depOpt)
      }: _*)
  val js =
    cp.js.settings(sireumJsSettings ++ settings).disablePlugins(AssemblyPlugin).
      dependsOn(shared % depOpt.get).
      dependsOn(pi.dependencies.map { p =>
        ClasspathDependency(LocalProject(p.id), depOpt)
      }: _*).
      dependsOn(pi.dependencies.map { p =>
        ClasspathDependency(LocalProject(p.id + "-js"), depOpt)
      }: _*).enablePlugins(ScalaJSPlugin)
  (shared, jvm, js)
}

// Cross Projects
lazy val utilPI = new ProjectInfo("util", isCross = true)
lazy val utilT = toSbtCrossProject(utilPI)
lazy val utilShared = utilT._1
lazy val utilJvm = utilT._2
lazy val utilJs = utilT._3

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
lazy val logikaJvm = logikaT._2.settings(
  parallelExecution in Test := false,
  unmanagedResourceDirectories in Compile ++= Seq(
    logikaT._2.base / "c-runtime" / "include",
    logikaT._2.base / "c-runtime" / "src",
    logikaT._2.base / "c-runtime" / "cmake"
  )
).dependsOn(runtimeJvm, preludeJvm)
lazy val logikaJs = logikaT._3

lazy val runtimePI = new ProjectInfo("runtime/runtime", isCross = true)
lazy val runtimeT = toSbtCrossProject(runtimePI, Seq(
  libraryDependencies ++= Seq(
    "org.scalameta" %%% "scalameta" % metaVersion,
    "org.spire-math" %%% "spire" % "0.13.0"),
  addCompilerPlugin("org.scalameta" % "paradise" % paradiseVersion cross CrossVersion.full)))
lazy val runtimeShared = runtimeT._1
lazy val runtimeJvm = runtimeT._2
lazy val runtimeJs = runtimeT._3

lazy val preludePI = new ProjectInfo("runtime/prelude", isCross = true, runtimePI)
lazy val preludeT = toSbtCrossProject(preludePI, Seq(
  testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-l", "SireumRuntime"),
  libraryDependencies ++= Seq(
    "org.scalameta" %%% "scalameta" % metaVersion,
    "org.scalatest" %%% "scalatest" % scalaTestVersion % "test"
  ),
  unmanagedResourceDirectories in Compile += file("runtime/prelude/shared/src/main/scala"),
  addCompilerPlugin("org.sireum" %% "scalac-plugin" % sireumScalacVersion),
  addCompilerPlugin("org.scalameta" % "paradise" % paradiseVersion cross CrossVersion.full)))
lazy val preludeShared = preludeT._1
lazy val preludeJvm = preludeT._2
lazy val preludeJs = preludeT._3

lazy val slangPI = new ProjectInfo("slang", isCross = true, runtimePI, preludePI)
lazy val slangT = toSbtCrossProject(slangPI, Seq(
  scalacOptions ++= Seq("-Yrangepos"),
  libraryDependencies ++= Seq(
    "com.lihaoyi" %%% "fastparse" % "0.4.3",
    "org.scalameta" %% "scalameta" % metaVersion,
    "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
  ),
  addCompilerPlugin("org.sireum" %% "scalac-plugin" % sireumScalacVersion),
  addCompilerPlugin("org.scalameta" % "paradise" % paradiseVersion cross CrossVersion.full),
  parallelExecution in Test := true
))
lazy val slangShared = slangT._1
lazy val slangJvm = slangT._2
lazy val slangJs = slangT._3

lazy val commonPI = new ProjectInfo("common", isCross = true, utilPI)
lazy val commonT = toSbtCrossProject(commonPI)
lazy val commonShared = commonT._1
lazy val commonJvm = commonT._2
lazy val commonJs = commonT._3.settings(
  crossTarget in (Compile, fastOptJS) := (classDirectory in Compile).value,
  crossTarget in (Compile, packageJSDependencies) := (classDirectory in Compile).value,
  crossTarget in (Compile, fullOptJS) := (classDirectory in Compile).value / "min",
  crossTarget in (Compile, packageMinifiedJSDependencies) := (classDirectory in Compile).value / "min",
  skip in packageJSDependencies := false,
  jsDependencies += RuntimeDOM,
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.2",
    "be.doeraene" %%% "scalajs-jquery" % "0.9.2",
    "com.lihaoyi" %%% "scalatags" % "0.6.5"
  )
)

lazy val webPI = new ProjectInfo("web", isCross = true, runtimePI, preludePI, utilPI, commonPI)
lazy val webT = toSbtCrossProject(webPI, Seq(
  libraryDependencies ++= Seq(
    "org.scalameta" %% "scalameta" % metaVersion,
    "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
  ),
  addCompilerPlugin("org.sireum" %% "scalac-plugin" % sireumScalacVersion),
  addCompilerPlugin("org.scalameta" % "paradise" % paradiseVersion cross CrossVersion.full),
  parallelExecution in Test := true
))
lazy val webShared = webT._1
lazy val webJvm = webT._2
lazy val webJs = webT._3.settings(
  crossTarget in (Compile, fastOptJS) := (classDirectory in Compile).value,
  crossTarget in (Compile, packageJSDependencies) := (classDirectory in Compile).value,
  crossTarget in (Compile, fullOptJS) := (classDirectory in Compile).value / "min",
  crossTarget in (Compile, packageMinifiedJSDependencies) := (classDirectory in Compile).value / "min",
  skip in packageJSDependencies := false,
  jsDependencies += RuntimeDOM,
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.2",
    "be.doeraene" %%% "scalajs-jquery" % "0.9.2",
    "com.lihaoyi" %%% "scalatags" % "0.6.5"
  )
)

// Jvm Projects

lazy val javaPI = new ProjectInfo("java", isCross = false, utilPI, testPI, pilarPI)
lazy val java = toSbtJvmProject(javaPI)

lazy val cliPI = new ProjectInfo("cli", isCross = false, utilPI, testPI, pilarPI, javaPI, logikaPI)
lazy val cli = toSbtJvmProject(cliPI)

lazy val awasPI = new ProjectInfo("awas", isCross = true, utilPI, testPI, commonPI)
lazy val awasT = toSbtCrossProject(awasPI, Seq(parallelExecution in Test := false))

lazy val awasShared = awasT._1
lazy val awasJvm = awasT._2.settings(libraryDependencies ++= Seq(
  "com.lihaoyi" %%% "scalatags" % "0.6.5"
))
lazy val awasJs = awasT._3.settings(
  crossTarget in(Compile, fastOptJS) := (classDirectory in Compile).value,
  crossTarget in(Compile, packageJSDependencies) := (classDirectory in Compile).value,
  crossTarget in(Compile, fullOptJS) := (classDirectory in Compile).value / "min",
  crossTarget in(Compile, packageMinifiedJSDependencies) := (classDirectory in Compile).value / "min",
  skip in packageJSDependencies := false,
  jsDependencies += RuntimeDOM,
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.2",
    "be.doeraene" %%% "scalajs-jquery" % "0.9.1",
    "com.lihaoyi" %%% "scalatags" % "0.6.5"
  )
)
// Js Projects


//

lazy val subProjectsJvm = Seq(
  utilJvm, testJvm, pilarJvm,
  runtimeJvm, preludeJvm, logikaJvm, slangJvm, java, cli, awasJvm
)

lazy val subProjectsJs = Seq(
  utilJs, testJs, pilarJs,
  runtimeJs, preludeJs, logikaJs, slangJs, commonJs, awasJs
)

lazy val subProjectJvmReferences =
  subProjectsJvm.map(x => x: ProjectReference)

lazy val subProjectJvmClasspathDeps =
  subProjectsJvm.map(x => x: ClasspathDep[ProjectReference])

lazy val subProjectJsReferences =
  subProjectsJs.map(x => x: ProjectReference)

lazy val sireumJvm =
  Project(
    id = "sireum-jvm",
    settings = sireumJvmSettings ++ assemblySettings ++
      Seq(
        name := "Sireum.jvm",
        libraryDependencies += "org.sireum" %% "scalac-plugin" % sireumScalacVersion,
        mainClass in assembly := Some("org.Sireum"),
        assemblyOutputPath in assembly := file("bin/sireum.jar"),
        test in assembly := {},
        logLevel in assembly := Level.Error,
        assemblyMergeStrategy in assembly := {
          case PathList("org", "sireum", _*) => new MergeStrategy {
            override def name: String = "sireum"

            override def apply(tempDir: File, path: String,
                               files: Seq[File]): Either[String, Seq[(File, String)]] = {
              if (files.size == 1) return Right(Seq(files.head -> path))
              val nonSharedFiles =
                files.flatMap { f =>
                  val sourceDir = AssemblyUtils.sourceOfFileForMerge(tempDir, f)._1
                  if (sourceDir.getAbsolutePath.contains("/shared/")) None else Some(f)
                }
              Right(Seq(nonSharedFiles.head -> path))
            }
          }
          case x =>
            val oldStrategy = (assemblyMergeStrategy in assembly).value
            oldStrategy(x)
        }
      ),
    base = file("jvm")).
    aggregate(subProjectJvmReferences: _*).
    dependsOn(subProjectJvmClasspathDeps: _*)

lazy val sireumJs =
  Project(
    id = "sireum-js",
    settings = sireumSharedSettings ++
      Seq(
        name := "Sireum.js"),
    base = file("js")).
    aggregate(subProjectJsReferences: _*).
    disablePlugins(AssemblyPlugin)


lazy val sireum = Project(
  id = "sireum",
  settings = sireumSharedSettings ++ Seq(
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
    initialize := {
      val required = "1.8"
      val current = sys.props("java.specification.version")
      assert(current == required, s"Unsupported Java version: $current (required: $required)")
    },
    publish := {},
    publishLocal := {}
  ),
  base = file(".")
).aggregate(sireumJvm, sireumJs).disablePlugins(AssemblyPlugin)
