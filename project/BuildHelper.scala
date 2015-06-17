import java.io.{BufferedInputStream, BufferedReader, FileInputStream, FileReader, FileWriter, PrintWriter}
import java.security.{DigestInputStream, MessageDigest}
import java.text.SimpleDateFormat
import java.util.{Date, Properties}

import sbt._

import scala.collection._

object BuildHelper {

  val env = {
    import scala.collection.JavaConversions._
    val env = System.getenv
    val envl = new Array[String](env.size)
    var i = 0
    for (e <- env) {
      envl(i) = e._1 + "=" + e._2
      i = i + 1
    }
    envl
  }

  def relativize(baseDir: File)(f: File) = {
    IO.relativize(baseDir, f) match {
      case Some(s) => s
      case _ => sys.error("Error: " + f.getAbsolutePath)
    }
  }

  def timeStamp = {
    val dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss")
    val date = new Date
    dateFormat.format(date)
  }

  def updateDist(sireumDir: File, projectInfoMap: mutable.Map[String, ProjectInfo],
                 dirs: scala.collection.Seq[String]) {

    println("Sireum dir: " + sireumDir.getAbsolutePath)

    val (uds, appDirs) =
      dirs.toList match {
        case List("-h") =>
          println("Usage: [<update-temp-dir>] <app-dir>*")
          return
        case updateTempDir :: apDirs => (UpdateDirs(new File(updateTempDir)), apDirs)
        case Nil => (UpdateDirs(sireumDir / "update"), mutable.Seq())
      }

    val checksums = newProperties

    def relBase = relativize(uds.baseDir) _

    def addChecksum(f: File) {
      checksums.put(relBase(f), getChecksum(f))
    }

    def addAppChecksum(f: File, fOrig: File) {
      val fOrigChecksum = new File(fOrig.getParentFile, fOrig.getName + ".checksum")
      val checksum =
        if (fOrigChecksum.exists && fOrigChecksum.lastModified >= fOrig.lastModified)
          readLine(fOrigChecksum).trim
        else {
          val r = getChecksum(fOrig)
          val pw = new PrintWriter(new FileWriter(fOrigChecksum))
          pw.println(r)
          pw.close()
          r
        }
      checksums.put(relBase(f), checksum)
    }

    val fileMap = mutable.Map[File, File]()
    val appFeatureMap = newProperties
    val appFeatureReq = mutable.Set[String]()

    def addAppFiles(appsDir: File) {
      def getAppName(s: String) = s.toLowerCase.replace(" ", "-")

      if (!appsDir.exists)
        sys.error(appsDir.getAbsolutePath + " does not exist!")

      val SAPP_EXT = ".sapp"
      for (d <- appsDir.listFiles) {
        if (d.isDirectory) {
          val appFeatureName = d.getName + SAPP_EXT
          var appName = getAppName(d.getName)
          val files = mutable.ArrayBuffer[String]()

          def loadAppInfo(f: File) {
            val file = new File(f.getAbsolutePath + ".properties")
            if (file.exists) {
              val p = new Properties
              val fr = new FileReader(file)
              p.load(fr)
              fr.close()
              if (p.containsKey("dependsOn")) {
                for (f <- p.getProperty("dependsOn").split(",")) {
                  var fName = f.trim
                  val featureName = if (fName.endsWith(SAPP_EXT)) fName else fName + SAPP_EXT
                  files += featureName
                  appFeatureReq += featureName
                }
              }
            }
          }

          for (
            f <- d.listFiles if f.getName.indexOf(SAPP_EXT) >= 0
            && !f.getName.endsWith(".properties")
            && !f.getName.endsWith(".checksum")
          ) {
            loadAppInfo(f)
            var fName = f.getName
            var unmanaged = false
            if (!fName.endsWith(SAPP_EXT)) {
              val i = fName.lastIndexOf(".")
              val reqApp = fName.substring(i + 1)
              if (reqApp == "unmanaged") {
                unmanaged = true
              } else {
                val reqAppFeatureName = reqApp + SAPP_EXT
                files += reqAppFeatureName
                appFeatureReq += reqAppFeatureName
              }
              fName = fName.substring(0, i)
              assert(fName.endsWith(SAPP_EXT), fName)
              appName = getAppName(reqApp)
            }
            val relPath =
              if (unmanaged) "apps/" + fName
              else "apps/" + appName + "/" + fName

            val fApp = uds.baseDir / relPath
            fileMap(f) = fApp
            if (f.lastModified != fApp.lastModified)
              IO.copyFile(f, fApp, preserveLastModified = true)
            addAppChecksum(fApp, f)
            files += relPath
          }
          if (files.nonEmpty)
            appFeatureMap(appFeatureName) = files.reduce({ (s1, s2) => s1 + "," + s2 })
        }
      }
    }

    try {
      addAppFiles(new File(SireumBuild.APPS_STASH_PATH))
      for (appDir <- appDirs) {
        val d = new File(appDir)
        println("Using " + d.getAbsolutePath)
        addAppFiles(d)
      }
      if (!appFeatureReq.subsetOf(appFeatureMap.keys.toSet)) {
        println(appFeatureReq)
        println(appFeatureMap.keys)
        assert(false)
      }
    } catch {
      case e: Throwable =>
        e.printStackTrace()
        throw e
    }

    withTempDir(sireumDir, "temp") { tempDir =>

      for (pi <- projectInfoMap.values) {
        for (f <- pi.libFiles)
          if (fudgeJar(f, tempDir)) {
            val fLib = uds.libDir / f.getName
            IO.copyFile(f, fLib, preserveLastModified = true)
            fileMap(f) = fLib
            addChecksum(fLib)
          }

        for (f <- pi.srcFiles)
          if (fudgeJar(f, tempDir)) {
            val fSrc = uds.srcDir / f.getName.replace(".jar", ".zip")
            IO.copyFile(f, fSrc, preserveLastModified = true)
            fileMap(f) = fSrc
            addChecksum(fSrc)
          }

        for (f <- pi.licensesFiles) {
          val fLicense = uds.licensesDir / f.getName
          IO.copyFile(f, fLicense, preserveLastModified = true)
          fileMap(f) = fLicense
          addChecksum(fLicense)
        }
      }
    }

    // copy scripts
    val launcherDir = sireumDir / "codebase/core/sireum-distro/scripts"
    val script = launcherDir / "sireum"
    val winScript = launcherDir / "sireum.bat"
    val fScript = uds.baseDir / script.getName
    val fWinScript = uds.baseDir / winScript.getName
    IO.copyFile(script, fScript, preserveLastModified = true)
    fileMap(script) = fScript
    addChecksum(fScript)
    IO.copyFile(winScript, fWinScript, preserveLastModified = true)
    fileMap(winScript) = fWinScript
    addChecksum(fWinScript)
    for (fPath <- SireumBuild.deletedFiles) {
      checksums(fPath) = "0"
    }

    // copy properties
    val propsDir = sireumDir / "codebase/core/sireum-cli/src/main/scala/org/sireum/cli"
    val props = propsDir / "sireum.properties"
    val fprops = uds.baseDir / props.getName
    IO.copyFile(props, fprops, preserveLastModified = true)
    fileMap(props) = fprops
    addChecksum(fprops)

    writeProperties(uds.baseDir / "checksums.properties", checksums)
    writeFeatures(uds.baseDir, projectInfoMap, fileMap, appFeatureMap)
    writeBuildStamp(uds.baseDir)
  }

  def writeBuildStamp(baseDir: File) {
    val pw = new PrintWriter(new FileWriter(baseDir / SireumBuild.BUILD_FILENAME))
    pw.println(timeStamp)
    pw.close()
  }

  def writeFeatures(baseDir: File, projectInfoMap: mutable.Map[String, ProjectInfo],
                    fileMap: mutable.Map[File, File],
                    appFeatures: mutable.Map[String, String]) {
    val f = baseDir / "features.properties"
    val features = newProperties
    val r = relativize(baseDir) _
    val fn = { f: File =>
      if (fileMap.contains(f))
        List(r(fileMap(f)))
      else List()
    }

    for (pi <- projectInfoMap.values) {
      val v = pi.dependencies.map {
        _.name
      } ++
        pi.depFeatures.map {
          _ + ".sapp"
        } ++
        pi.libFiles.flatMap(fn) ++
        pi.srcFiles.flatMap(fn) ++
        pi.licensesFiles.flatMap(fn)
      if (v.nonEmpty)
        features.put(pi.name, v.reduce({ (s1, s2) => s1 + "," + s2 }))
    }

    writeProperties(f, features, appFeatures)
  }

  def newProperties: mutable.Map[String, String] = {
    import scala.collection.JavaConversions._

    new java.util.TreeMap[String, String]()
  }

  def writeProperties(f: File, ms: mutable.Map[String, String]*) {
    val pw = new PrintWriter(new FileWriter(f))
    for (m <- ms)
      for (e <- m) {
        pw.print(e._1.replace(" ", "\\ "))
        pw.print("=")
        pw.println(e._2)
      }
    pw.close()
  }

  case class UpdateDirs(baseDir: File) {
    val libDir = baseDir / "lib"
    val srcDir = baseDir / "src"
    val licensesDir = baseDir / "licenses"
    //    val docDir = baseDir / "doc"
    //    val examplesDir = baseDir / "examples"

    IO.delete(baseDir)
    IO.createDirectory(baseDir)
    IO.createDirectory(libDir)
    IO.createDirectory(srcDir)
    IO.createDirectory(licensesDir)
    //    IO.createDirectory(doc)
    //    IO.createDirectory(examples)
  }

  def withTempDir[T](baseDir: File, tempName: String)(f: File => T): T = {
    val tempDir = baseDir / tempName
    val r = f(tempDir)
    IO.delete(tempDir)
    r
  }

  def allFilesToZip(anchor: File, dir: File, acc: mutable.Map[String, File]): Unit = {
    for (f <- dir.listFiles) {
      if (f.isDirectory)
        allFilesToZip(anchor, f, acc)
      else
        acc(IO.relativize(anchor, f).get) = f
    }
  }

  def fudgeJar(f: File, tempDir: File): Boolean = {
    if (!f.getName.startsWith("sireum-")) return true
    import scala.collection.JavaConversions._

    withTempDir(tempDir, f.getName.substring(0, f.getName.length - 4)) { fTempDir =>
      IO.unzip(f, fTempDir)
      val metaDir = fTempDir / "META-INF"
      if (metaDir.list == null || metaDir.list.length == 1)
        IO.delete(metaDir)
      else
        IO.delete(metaDir / "MANIFEST.MF")
      val filesToZip = new java.util.TreeMap[String, File]()
      allFilesToZip(fTempDir, fTempDir, filesToZip)
      if (filesToZip.isEmpty) {
        println("Empty jar: " + f.getAbsoluteFile)
        false
      } else {
        IO.delete(f)
        MyIO.zip(filesToZip.toSeq.map { p => (p._2, p._1) }, f, setTime = false)
        true
      }
    }
  }

  def getChecksum(file: File) = {
    val md = MessageDigest.getInstance("MD5")

    val is = new BufferedInputStream(new FileInputStream(file))
    try {
      val dis = new DigestInputStream(is, md)
      while (dis.read != -1) {}
    } finally is.close()

    val digest = md.digest

    val result = new StringBuilder
    for (i <- 0 until digest.length) {
      val s = Integer.toString(digest(i) & 0xff, 16)
      if (s.length == 1) result.append('0')
      result.append(s)
    }

    result.toString()
  }

  def readLine(file: File) = {
    val r = new BufferedReader(new FileReader(file))
    val result = r.readLine.trim
    r.close()
    result
  }
}
