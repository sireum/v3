import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._
import sbt.complete.Parsers._

object SireumBuild extends Build {
  final val BUILD_FILENAME = "BUILD"
  final val CORE_DIR = "core/"

  val UPDATE_SITE_PATH = firstExists("Temp/update.sireum.org",
    "/research/santos/public_html/update.sireum.org")

  val APPS_STASH_PATH =
    if (System.getenv("APPS_PATH") != null)
      System.getenv("APPS_PATH")
    else
      firstExists("Temp/apps.sireum.org",
        "/research/santos/stash/apps.sireum.org",
        "/Volumes/santos/stash/apps.sireum.org")

  import ProjectInfo._

  val updateDist = InputKey[Unit]("update-dist", "Creates Sireum update site.")
  val updatePublish = InputKey[Unit]("update-publish", "Publishes Sireum update site.")
  val distPublish = InputKey[Unit]("dist-publish", "Publishes Distro distributions (managed Java and Scala).")
  val depDot = InputKey[Unit]("dep-dot", "Print project dependency in dot.")
  val cliGen = InputKey[Unit]("cligen", "Generate CLI.")

  lazy val sireum =
    Project(
      id = "sireum",
      settings = sireumSettings ++
        Seq(
          updateDist := {
            val args = spaceDelimited("<arg>").parsed
            BuildHelper.updateDist(baseDirectory.value, projectInfoMap, args)
          },
          updatePublish := {
            val args = spaceDelimited("<arg>").parsed
            UpdateSiteBuilder.publishUpdate(args)
          },
          distPublish := {
            val args = spaceDelimited("<arg>").parsed
            UpdateSiteBuilder.publishDist(args)
          },
          depDot := {
            val args = spaceDelimited("<arg>").parsed
            ProjectHelper.dotDependency(args, projectInfos)
          },
          cliGen := {
            val args = spaceDelimited("<arg>").parsed
            ProjectHelper.cliGen(args, projectInfos)
          }),
      base = file(".")) aggregate(
      util, pilar,
      pilarParser,
      coreTest,
      coreJsTest
      ) settings (
      name := "Sireum")

  final val scalaVer = "2.11.6"

  val sireumSettings = Seq(
    organization := "SAnToS Laboratory",
    artifactName := { (config: ScalaVersion, module: ModuleID, artifact: Artifact) =>
      artifact.name + (
        artifact.classifier match {
          case Some("sources") => "-src"
          case Some("javadoc") => "-doc"
          case _ => ""
        }) + "." + artifact.extension
    },
    incOptions := incOptions.value.withNameHashing(true),
    parallelExecution in Test := true,
    scalaVersion := scalaVer,
    scalacOptions ++= Seq("-target:jvm-1.8", "-Ybackend:GenBCode"),
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVer,
      "org.scala-lang" % "scala-compiler" % scalaVer,
      "com.github.benhutchison" %% "prickle" % "1.1.6",
      "me.chrons" %% "boopickle" % "1.0.0"
    ),
    scalacOptions in(Compile, doc) := Seq("-groups", "-implicits"),
    javacOptions in(Compile, doc) := Seq("-notimestamp", "-linksource"),
    autoAPIMappings := true,
    apiURL := Some(url("http://sireum.org/api/"))
  )

  val sireumJvmSettings = sireumSettings ++ Seq(
    libraryDependencies ++= Seq(
      "org.antlr" % "antlr4-runtime" % "4.5"
    )
  )

  val sireumJvmTestSettings = sireumJvmSettings ++ Seq(
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v"),
    libraryDependencies ++= Seq(
      "com.novocode" % "junit-interface" % "0.11" % "test"
    )
  )

  val sireumJsSettings = Seq(
    organization := "SAnToS Laboratory",
    incOptions := incOptions.value.withNameHashing(true),
    parallelExecution in Test := false,
    scalaVersion := scalaVer,
    relativeSourceMaps := true,
    scalacOptions ++= Seq("-target:jvm-1.8", "-Ybackend:GenBCode"),
    scalaJSStage in Global := FastOptStage,
    postLinkJSEnv := NodeJSEnv().value,
    libraryDependencies ++= Seq(
      "com.github.benhutchison" %%% "prickle" % "1.1.6",
      "me.chrons" %%% "boopickle" % "1.0.0"
    )
  )

  val sireumJsTestSettings = sireumJsSettings ++ Seq(
    libraryDependencies ++= Seq(
      "com.lihaoyi" %%% "utest" % "0.3.1"
    ),
    testFrameworks += new TestFramework("utest.runner.Framework")
  )

  lazy val util = toSbtProject(utilPI, sireumSettings)
  lazy val pilar = toSbtProject(pilarPI, sireumSettings)

  lazy val pilarParser = toSbtProject(pilarParserPI, sireumJvmSettings)

  lazy val coreTest = toSbtProject(coreTestPI, sireumJvmTestSettings)

  lazy val coreJsTest = toSbtJsProject(coreJsTestPI, sireumJsTestSettings)


  val utilPI = new ProjectInfo("Sireum Util", CORE_DIR, Seq())
  val pilarPI = new ProjectInfo("Sireum Pilar", CORE_DIR, Seq(), utilPI)

  val pilarParserPI = new ProjectInfo("Sireum Pilar Parser", CORE_DIR, Seq(), pilarPI)

  val coreTestPI = new ProjectInfo("Sireum Core Test", CORE_DIR, Seq(), utilPI, pilarPI, pilarParserPI)

  val coreJsTestPI = new ProjectInfo("Sireum Core Js Test", CORE_DIR, Seq(), utilPI, pilarPI)


  def firstExists(default: String, paths: String*): String = {
    for (p <- paths)
      if (new File(p).exists)
        return p
    val f = new File(System.getProperty("user.home") + "/" + default)
    f.mkdirs
    val path = f.getAbsolutePath
    println("Using " + path)
    path
  }

  def toSbtProject(pi: ProjectInfo, settings: Seq[Def.Setting[_]]): Project =
    Project(
      id = pi.id,
      settings = settings,
      base = pi.baseDir).
      dependsOn(pi.dependencies.map { p =>
      new ClasspathDependency(new LocalProject(p.id), None)
    }: _*).
      settings(name := pi.name)

  def toSbtJsProject(pi: ProjectInfo, settings: Seq[Def.Setting[_]]): Project = {
    val (jsPIs, purePIs) = pi.dependencies.partition(p => p.id.contains("-js"))
    Project(
      id = pi.id,
      settings = settings ++ Seq(
        name := pi.name,
        unmanagedSourceDirectories in Compile <++= baseDirectory { base =>
          purePIs.map { pi =>
            base / base.getAbsoluteFile.toPath.relativize((pi.baseDir / "src/main/scala").getAbsoluteFile.toPath).toString
          }
        }
      ),
      base = pi.baseDir).dependsOn(jsPIs.map(p =>
      new ClasspathDependency(new LocalProject(p.id), None)): _*
      ).enablePlugins(ScalaJSPlugin)
  }

  lazy val projectInfoMap = scala.collection.mutable.Map[String, ProjectInfo](

    Seq(
      utilPI
    ).map { pi => pi.id -> pi }: _*)

  val deletedFiles = Seq[String](
  )
}
