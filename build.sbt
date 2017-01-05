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

import ProjectInfo._
import org.scalajs.sbtplugin.cross.CrossProject
import sbt.complete.Parsers.spaceDelimited
import sbtassembly.AssemblyKeys.{assemblyMergeStrategy, assemblyOutputPath}
import sbtassembly.{AssemblyUtils, MergeStrategy}
import sbtassembly.AssemblyPlugin._

val isRelease = System.getenv("SIREUM_RELEASE") != null

val scalaVer = "2.12.1"

val sireumVer = "3"

val BUILD_FILENAME = "BUILD"

val isParallelBuild = "false" != System.getenv("SIREUM_PARALLEL_BUILD")

val distros = TaskKey[Unit]("distros", "Build Sireum distributions.")
val ideaDistros = TaskKey[Unit]("idea-distros", "Build Sireum IntelliJ distributions.")
val depDot = InputKey[Unit]("dep-dot", "Print project dependency in dot.")

traceLevel in ideaDistros := -1

lazy val sireum = Project(
  id = "sireum",
  settings = sireumSharedSettings ++ Seq(
    name := "Sireum",
    distros := {
      Distros.build()
    },
    ideaDistros := {
      Distros.buildIdea()
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

lazy val sireumJvm =
  Project(
    id = "sireum-jvm",
    settings = sireumJvmSettings ++ assemblySettings ++
      Seq(
        name := "Sireum.jvm",
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

lazy val subProjectsJvm = Seq(
  utilJvm, testJvm, pilarJvm,
  logikaJvm, java, cli, awas
)

lazy val subProjectsJs = Seq(
  utilJs, testJs, pilarJs, logikaJs
)

lazy val subProjectJvmReferences =
  subProjectsJvm.map(x => x: ProjectReference)

lazy val subProjectJvmClasspathDeps =
  subProjectsJvm.map(x => x: ClasspathDep[ProjectReference])

lazy val subProjectJsReferences =
  subProjectsJs.map(x => x: ProjectReference)

lazy val sireumSharedSettings = Seq(
  organization := "org.sireum",
  version := sireumVer,
  incOptions := incOptions.value.withNameHashing(true),
  scalaVersion := scalaVer,
  retrieveManaged := true,
  scalacOptions ++= Seq("-target:jvm-1.8", "-deprecation",
    "-Ydelambdafy:method", "-feature", "-unchecked"),
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
  javacOptions in(Compile, doc) := Seq("-notimestamp", "-linksource"),
  libraryDependencies ++= Seq(
    "com.lihaoyi" %%% "upickle" % "0.4.4"
  ),
  scalacOptions in(Compile, doc) := Seq("-groups", "-implicits"),
  autoAPIMappings := true,
  apiURL := Some(url("http://v3.sireum.org/api/")),
  parallelExecution in Global := isParallelBuild
)

lazy val sireumJvmSettings = sireumSharedSettings ++ Seq(
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVer,
    "org.scala-lang" % "scala-compiler" % scalaVer,
    "org.scala-lang.modules" %% "scala-java8-compat" % "0.8.0",
    "org.sireum" %% "logika-runtime" % "3.0.0-10",
    "org.antlr" % "antlr4-runtime" % "4.6",
    "org.antlr" % "ST4" % "4.0.8",
    "org.yaml" % "snakeyaml" % "1.17",
    "org.ow2.asm" % "asm" % "5.1",
    "org.ow2.asm" % "asm-commons" % "5.1",
    "org.ow2.asm" % "asm-util" % "5.1",
    "org.jgrapht" % "jgrapht-core" % "1.0.0",
    "org.jgrapht" % "jgrapht-ext" % "1.0.0",
    "org.scala-graph" %% "graph-core" % "1.11.4",
    "org.scala-graph" %% "graph-dot" % "1.11.0",
    "com.lihaoyi" %% "ammonite-ops" % "0.8.1",
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
  jsEnv := NodeJSEnv().value,
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVer,
    "com.lihaoyi" %%% "utest" % "0.4.4"
  ),
  testFrameworks += new TestFramework("utest.runner.Framework")
)

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
  parallelExecution in Test := false
)
lazy val logikaJs = logikaT._3

// Jvm Projects

lazy val javaPI = new ProjectInfo("java", isCross = false, utilPI, testPI, pilarPI)
lazy val java = toSbtJvmProject(javaPI)

lazy val cliPI = new ProjectInfo("cli", isCross = false, utilPI, testPI, pilarPI, javaPI, logikaPI)
lazy val cli = toSbtJvmProject(cliPI)

lazy val awasPI = new ProjectInfo("awas", isCross = false, utilPI, testPI)
lazy val awas = toSbtJvmProject(awasPI)

// Js Projects

//

def toSbtJvmProject(pi: ProjectInfo): Project =
  Project(
    id = pi.id,
    settings = sireumJvmSettings,
    base = pi.baseDir / "jvm").
    dependsOn(pi.dependencies.flatMap { p =>
      if (p.isCross)
        Seq(ClasspathDependency(LocalProject(p.id), None),
          ClasspathDependency(LocalProject(p.id + "-jvm"), None))
      else Seq(ClasspathDependency(LocalProject(p.id), None))
    }: _*).
    settings(name := pi.name).disablePlugins(AssemblyPlugin)

def toSbtCrossProject(pi: ProjectInfo): (Project, Project, Project) = {
  val shared = Project(
    id = pi.id,
    settings = sireumSharedSettings,
    base = pi.baseDir / "shared").
    dependsOn(pi.dependencies.map { p =>
      ClasspathDependency(LocalProject(p.id), None)
    }: _*).
    settings(name := pi.name).disablePlugins(AssemblyPlugin)
  val cp = CrossProject(
    jvmId = pi.id + "-jvm",
    jsId = pi.id + "-js",
    base = pi.baseDir,
    crossType = CrossType.Full)
  val jvm =
    cp.jvm.settings(sireumJvmSettings).disablePlugins(AssemblyPlugin).
      dependsOn(shared).
      dependsOn(pi.dependencies.map { p =>
        ClasspathDependency(LocalProject(p.id), None)
      }: _*).
      dependsOn(pi.dependencies.map { p =>
        ClasspathDependency(LocalProject(p.id + "-jvm"), None)
      }: _*)
  val js =
    cp.js.settings(sireumJsSettings).disablePlugins(AssemblyPlugin).
      dependsOn(shared).
      dependsOn(pi.dependencies.map { p =>
        ClasspathDependency(LocalProject(p.id), None)
      }: _*).
      dependsOn(pi.dependencies.map { p =>
        ClasspathDependency(LocalProject(p.id + "-js"), None)
      }: _*).enablePlugins(ScalaJSPlugin)
  (shared, jvm, js)
}
