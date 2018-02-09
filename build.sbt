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

val sireumVersion = "3"

val scalaVer = "2.12.4"

val sireumScalacVersion = "3.2.5"

val metaVersion = "3.2.0"

val scalaTestVersion = "3.0.1"

val scalaJsDomVersion = "0.9.4"

val scalaJsJQueryVersion = "0.9.2"

val scalaTagsVersion = "0.6.7"

val asmVersion = "6.0"

val jgraphtVersion = "1.1.0"

val upickleVersion = "0.5.1"

val java8CompatVersion = "0.8.0"

val antlrRuntimeVersion = "4.7.1"

val stVersion = "4.0.8"

val ammoniteOpsVersion = "1.0.3"

val diffVersion = "1.1.11"

val snakeYamlVersion = "1.19"

val junitInterfaceVersion = "0.11"

val utestVersion = "0.6.3"

val spireVersion = "0.13.0"

val scalajsonVersion = "1.0.0-M4"

val BUILD_FILENAME = "BUILD"

val isParallelBuild = "false" != System.getenv("SIREUM_PARALLEL_BUILD")

val distros = TaskKey[Unit]("distros", "Build Sireum distributions.")
val iveDistros = TaskKey[Unit]("ive-distros", "Build Sireum IVE distributions.")
val devDistros = TaskKey[Unit]("dev-distros", "Build Sireum-dev distributions.")
val devIveDistros = TaskKey[Unit]("dev-ive-distros", "Build Sireum-dev IVE distributions.")
val depDot = InputKey[Unit]("dep-dot", "Print project dependency in dot.")
val refreshSlang = TaskKey[Unit]("refresh-slang", "Refresh Slang files.")

iveDistros / traceLevel := -1
Global / parallelExecution := isParallelBuild
Global / concurrentRestrictions ++= (if (isParallelBuild) Seq() else Seq(Tags.limitAll(1)))

addCommandAlias("fatjar", "; project sireum; assembly")

lazy val sireumSettings = Seq(
  organization := "org.sireum",
  version := sireumVersion,
  incOptions := incOptions.value.withLogRecompileOnMacro(false),
  scalaVersion := scalaVer,
  retrieveManaged := true,
  scalacOptions ++= Seq("-target:jvm-1.8", "-deprecation",
    "-Ydelambdafy:method", "-feature", "-unchecked", "-Xfatal-warnings"),
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "utf8"),
  Compile / doc / javacOptions := Seq("-notimestamp", "-linksource"),
  Compile / doc / scalacOptions := Seq("-groups", "-implicits"),
  Test / logBuffered := false,
  autoAPIMappings := true,
  apiURL := Some(url("http://v3.sireum.org/api/")),
  resolvers += Resolver.sonatypeRepo("public"),
  dependencyUpdatesFilter -= moduleFilter(organization = "org.scalatest"),
  dependencyUpdatesFilter -= moduleFilter(organization = "org.eclipse.jetty")
)

lazy val sireumSharedSettings = sireumSettings ++ Seq(
  libraryDependencies ++= Seq(
    "com.lihaoyi" %%% "upickle" % upickleVersion
  )
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
    "com.novocode" % "junit-interface" % junitInterfaceVersion
  ),
  Test / parallelExecution := true,
  testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")
)

lazy val sireumJsSettings = sireumSharedSettings ++ Seq(
  scalacOptions ++= Seq("-feature"),
  Test / parallelExecution := false,
  relativeSourceMaps := true,
  Global / scalaJSStage := (if (isRelease) FullOptStage else FastOptStage),
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVer,
    "com.lihaoyi" %%% "utest" % utestVersion
  ),
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
    "be.doeraene" %%% "scalajs-jquery" % scalaJsJQueryVersion,
    "com.lihaoyi" %%% "scalatags" % scalaTagsVersion
  )
)

lazy val slangSettings = sireumSettings ++ Seq(
  scalacOptions ++= Seq("-Yrangepos"),
  addCompilerPlugin("org.sireum" %% "scalac-plugin" % sireumScalacVersion)
)

val depOpt = Some("test->test;compile->compile;test->compile")

def toSbtJvmProject(pi: ProjectInfo, settings: Seq[Def.Setting[_]] = sireumJvmSettings): Project =
  Project(
    id = pi.id,
    base = pi.baseDir / "jvm").
    settings(Seq(name := pi.name) ++ settings: _*).
    dependsOn(pi.dependencies.flatMap { p =>
      if (p.isCross)
        Seq(ClasspathDependency(LocalProject(p.id), depOpt),
          ClasspathDependency(LocalProject(p.id + "-jvm"), depOpt))
      else Seq(ClasspathDependency(LocalProject(p.id), depOpt))
    }: _*).
    settings().disablePlugins(AssemblyPlugin)

def toSbtCrossProject(pi: ProjectInfo, settings: Seq[Def.Setting[_]] = Vector()): (Project, Project, Project) = {
  val shared = Project(
    id = pi.id,
    base = pi.baseDir / "shared").
    settings(Seq(name := pi.name) ++ sireumSharedSettings ++ settings: _*).
    dependsOn(pi.dependencies.map { p =>
      ClasspathDependency(LocalProject(p.id), depOpt)
    }: _*).
    disablePlugins(AssemblyPlugin)
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
  Test / parallelExecution := false,
  Compile / unmanagedResourceDirectories ++= Seq(
    logikaT._2.base / "c-runtime" / "include",
    logikaT._2.base / "c-runtime" / "src",
    logikaT._2.base / "c-runtime" / "cmake"
  )
).dependsOn(macrosJvm, libraryJvm)
lazy val logikaJs = logikaT._3

lazy val macrosPI = new ProjectInfo("runtime/macros", isCross = true)
lazy val macrosT = toSbtCrossProject(macrosPI, Seq(
  Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-l", "SireumRuntime"),
  libraryDependencies ++= Seq(
    "org.spire-math" %%% "spire" % spireVersion)))
lazy val macrosShared = macrosT._1
lazy val macrosJvm = macrosT._2
lazy val macrosJs = macrosT._3

lazy val libraryPI = new ProjectInfo("runtime/library", isCross = true, macrosPI)
lazy val libraryT = toSbtCrossProject(libraryPI, slangSettings ++ Seq(
  Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-l", "SireumRuntime"),
  libraryDependencies ++= Seq(
    "org.scala-lang.platform" %%% "scalajson" % scalajsonVersion,
    "org.scalatest" %%% "scalatest" % scalaTestVersion % "test")))
lazy val libraryShared = libraryT._1
lazy val libraryJvm = libraryT._2
lazy val libraryJs = libraryT._3

lazy val slangPI = new ProjectInfo("slang", isCross = true, macrosPI, libraryPI)
lazy val slangT = toSbtCrossProject(slangPI, slangSettings ++ Seq(
  libraryDependencies ++= Seq(
    "org.scalameta" %%% "scalameta" % metaVersion,
    "org.scalatest" %%% "scalatest" % scalaTestVersion % "test"
  ),
  Test / parallelExecution := true
))
lazy val slangShared = slangT._1
lazy val slangJvm = slangT._2
lazy val slangJs = slangT._3

lazy val commonPI = new ProjectInfo("common", isCross = true, utilPI)
lazy val commonT = toSbtCrossProject(commonPI)
lazy val commonShared = commonT._1
lazy val commonJvm = commonT._2
lazy val commonJs = commonT._3.settings(webSettings: _*)

lazy val webPI = new ProjectInfo("web", isCross = true, macrosPI, libraryPI, utilPI, commonPI)
lazy val webT = toSbtCrossProject(webPI, slangSettings ++ Seq(
  libraryDependencies ++= Seq(
    "org.scalatest" %%% "scalatest" % scalaTestVersion % "test"
  ),
  Test / parallelExecution := true
))
lazy val webShared = webT._1
lazy val webJvm = webT._2
lazy val webJs = webT._3.settings(webSettings: _*)

lazy val skemaPI = new ProjectInfo("aadl/skema", isCross = true, utilPI, testPI, macrosPI, libraryPI, slangPI)
lazy val skemaT = toSbtCrossProject(skemaPI, slangSettings ++ Seq(
  libraryDependencies ++= Seq(
    "org.scalatest" %%% "scalatest" % scalaTestVersion % "test"
  ),
  Test / parallelExecution := true
))
lazy val skemaShared = skemaT._1
lazy val skemaJvm = skemaT._2
lazy val skemaJs = skemaT._3

// Jvm Projects

lazy val javaPI = new ProjectInfo("java", isCross = false, utilPI, testPI, pilarPI)
lazy val java = toSbtJvmProject(javaPI)

lazy val cliPI = new ProjectInfo("cli", isCross = false, utilPI, testPI, pilarPI, javaPI, logikaPI, slangPI)
lazy val cli = toSbtJvmProject(cliPI)

lazy val awasPI = new ProjectInfo("awas", isCross = true, utilPI, testPI, commonPI, skemaPI)
lazy val awasT = toSbtCrossProject(awasPI, Seq(Test / parallelExecution := false))

lazy val awasShared = awasT._1
lazy val awasJvm = awasT._2.settings(
  libraryDependencies ++= Seq(
    "com.lihaoyi" %%% "scalatags" % scalaTagsVersion
  ))
lazy val awasJs = awasT._3.settings(webSettings: _*)

lazy val arsitPI = new ProjectInfo("aadl/arsit", isCross = false,
  utilPI, testPI, commonPI, macrosPI, libraryPI, slangPI, skemaPI)
lazy val arsit = toSbtJvmProject(arsitPI, slangSettings ++ Seq(
  Test / parallelExecution := true
))

lazy val minixPI = new ProjectInfo("aadl/minix", isCross = false,
  macrosPI, libraryPI, skemaPI)
lazy val minix = toSbtJvmProject(minixPI, slangSettings ++ Seq(
  Test / parallelExecution := true
))

// Js Projects

lazy val subProjectsJvm = Seq(
  utilJvm, testJvm, pilarJvm,
  macrosJvm, libraryJvm, logikaJvm, slangJvm, java, cli, awasJvm, skemaJvm, arsit, minix
)

lazy val subProjectsJs = Seq(
  utilJs, testJs, pilarJs,
  macrosJs, libraryJs, logikaJs, slangJs, commonJs, awasJs, skemaJs
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
    base = file("jvm")).
    settings(sireumJvmSettings ++ assemblySettings ++
      Seq(
        name := "Sireum.jvm",
        libraryDependencies += "org.sireum" %% "scalac-plugin" % sireumScalacVersion,
        assembly / mainClass := Some("org.sireum.cli.Sireum"),
        assembly / assemblyOutputPath := file("bin/sireum.jar"),
        assembly / test := {},
        assembly / logLevel := Level.Error,
        assembly / assemblyMergeStrategy := {
          case PathList("transformed", _*) =>  MergeStrategy.discard
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
          case "module-info.class" => MergeStrategy.discard
          case x =>
            val oldStrategy = (assembly / assemblyMergeStrategy).value
            oldStrategy(x)
        }
      ): _*).
    aggregate(subProjectJvmReferences: _*).
    dependsOn(subProjectJvmClasspathDeps: _*)

lazy val sireumJs =
  Project(
    id = "sireum-js",
    base = file("js")).
    settings(sireumSharedSettings ++
      Seq(
        name := "Sireum.js"): _*).
    aggregate(subProjectJsReferences: _*).
    disablePlugins(AssemblyPlugin)


lazy val sireum = Project(
  id = "sireum",
  base = file(".")).
  settings(sireumSharedSettings ++ Seq(
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
      val runtimeFile = Path(new File(rootDir, "runtime/library/shared/src/main/scala/org/sireum/Library_Ext.scala").getCanonicalFile)
      val slangFile = Path(new File(rootDir, "slang/shared/src/main/scala/org/sireum/lang/$SlangFiles.scala").getCanonicalFile)

      def touche(p: Path): Unit = {
        val text = read ! p
        if (text.last == '\n') {
          write.over(p, text.trim)
        } else {
          write.over(p, text + '\n')
        }
      }

      touche(runtimeFile)
      touche(slangFile)
    },
    initialize := {
      val required = Set("1.8", "9")
      val current = sys.props("java.specification.version")
      assert(required.contains(current), s"Unsupported Java version: $current (required: $required)")
    },
    publish := {},
    publishLocal := {}
  ): _*).
  aggregate(sireumJvm, sireumJs).disablePlugins(AssemblyPlugin)
