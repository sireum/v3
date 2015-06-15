/*
Copyright (c) 2011-2013 Robby, Kansas State University.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
*/

import java.io._
import java.util.Calendar
import java.util.Date
import java.util.Properties
import java.text.SimpleDateFormat
import java.util.zip.ZipFile
import java.nio.file.Files
import java.nio.file.attribute.PosixFilePermission
import java.nio.file.attribute.PosixFilePermission
import java.util.zip.ZipEntry
import java.security.MessageDigest
import java.security.DigestInputStream

/**
 * @author <a href="mailto:robby@k-state.edu">Robby</a>
 */
object UpdateSiteBuilder {
  final val SAPP_EXT = ".sapp"
  final val SAPP_LINK_EXT = ".sapp_link"
  final val SAPP_INFO = ".sapp_info"

  final val BUFFER_SIZE = 1024
  final val DOWNLOAD_URL = "http://www.sireum.org/download"
  final val DEV_WINDOW_MS = 1000l /* s */ * 60 /* m */ * 60 /* h */ * 24 /* d */ * 7 /* w */ * 2
  final val STABLE_WINDOW = 14

  val out = scala.Console.out
  val err = scala.Console.err
  val timeStampFormat = new SimpleDateFormat("yyyyMMdd-HHmmss")
  val dayFormat = new SimpleDateFormat("yyyyMMdd")

  val nonLatestDirectoryFileFilter = new FileFilter {
    def accept(file : File) : Boolean = {
      file.getName != "latest" && file.isDirectory
    }
  }

  val timeStampSort = { (f1 : File, f2 : File) =>
    if (f1.getName.length < 5 && f2.getName.length < 5)
      Integer.parseInt(f1.getName) > Integer.parseInt(f2.getName)
    else if (f1.getName.length < 5) false
    else if (f2.getName.length < 5) true
    else {
      val time1 = timeStampFormat.parse(f1.getName).getTime
      val time2 = timeStampFormat.parse(f2.getName).getTime
      time1 > time2
    }
  }

  def timeStamp(time : Date) = timeStampFormat.format(time)

  def dayStamp(time : Date) = dayFormat.format(time)

  def publishDist(args : Seq[String]) {
    args match {
      case Seq(mode, destDirPath, distDirPath) =>
        val distDir = new File(distDirPath)
        if (!distDir.exists) {
          sys.error(distDir.getAbsolutePath + " does not exist!")
        }
        val isStable = mode == "stable"
        val upSitePath = if (isStable) "/stable/latest" else "/dev/latest"
        val updateSite = new File(destDirPath + upSitePath)
        if (!updateSite.exists) {
          sys.error(updateSite.getAbsolutePath + " does not exist!")
        }
        buildDistributions(isStable, updateSite, distDir)
      case _ =>
        outPrintln("Usage: ( stable | dev ) <dest-dir> <dist-dir>")
    }
  }

  def publishUpdate(args : Seq[String]) {
    args match {
      case Seq(mode, srcDirPath, destDirPath) if mode == "stable" || mode == "dev" =>
        val srcDir = new File(srcDirPath)
        if (!srcDir.exists()) {
          sys.error(srcDir.getAbsolutePath + " does not exist!")
        }
        if (!srcDir.isDirectory) {
          sys.error(srcDir.getAbsolutePath + " is not a directory!")
        }
        val destDir = new File(destDirPath)
        if (!destDir.exists()) {
          sys.error(destDir.getAbsolutePath + " does not exist!")
        }
        if (!destDir.isDirectory) {
          sys.error(destDir.getAbsolutePath + " is not a directory!")
        }
        val time = new Date
        if (mode == "dev") {
          val devDir = new File(destDir, "dev")
          val dir = buildUpdateSite(srcDir, destDir, time, false)
          deleteOldDevSites(devDir, time)
          //archiveMonthly(devDir, srcDir, time)
          symlink(dir)
        } else {
          val stableDir = new File(destDir, "stable")
          val dir = buildUpdateSite(srcDir, destDir, time, true)
          deleteOldStableSites(stableDir, time)
          symlink(dir)
        }
        buildUpdateSiteListing(destDir, time)
      case _ =>
        outPrintln("Usage: ( stable | dev ) <src-dir> <dest-dir>")
    }
  }

  def errPrintln(s : String) {
    err.println(s)
    err.flush
  }

  def outPrintln(s : String) {
    out.println(s)
    out.flush
  }

  def printUsage {
    outPrintln("Usage: ( stable | dev ) <src-dir> <dest-dir> <dist-dir>")
  }

  def buildDistributions(isStable : Boolean, updateSiteDir : File, distDir : File) {

    for (platform <- Seq("mac64", "linux64", "win64")) {
      val dSireum = new File(distDir, "Sireum")

      val dMetadata = new File(dSireum, ".metadata")
      val dPlatform = new File(dSireum, "apps/platform")
      val dMPlatform = new File(dMetadata, "apps/platform")
      dPlatform.mkdirs
      dMPlatform.mkdirs

      val isWin = platform == "win32" || platform == "win64"
      val script = if (isWin) "sireum.bat" else "sireum"

      exec(Seq("cp", new File(updateSiteDir, script).getAbsolutePath, dSireum.getAbsolutePath + "/"))
      exec(Seq("chmod", "775", dSireum.getAbsolutePath + "/" + script))
      exec(Seq("cp", new File(updateSiteDir, "BUILD").getAbsolutePath, dMetadata.getAbsolutePath + "/"))

      {
        val installedF = new File(dMetadata, "installed-features.txt")
        outPrintln("Creating " + installedF.getAbsolutePath)
        val pw = new PrintWriter(new FileWriter(installedF))
        pw.println("Platform.sapp")
        pw.close
      }

      {
        val javaSapp = new File(updateSiteDir, "apps/platform/java-" + platform + ".sapp")
        outPrintln("Unzipping " + javaSapp.getAbsolutePath)
        unzip(javaSapp, dPlatform, None)

        val javaSappChecksum = new File(dMPlatform, "java-" + platform + ".sapp.checksum")
        val checksum = getChecksum(javaSapp)
        outPrintln("Writing checkum (" + checksum + ") to " + javaSappChecksum.getAbsolutePath)
        write(javaSappChecksum, checksum)

        exec(Seq("mv", dPlatform.getAbsolutePath + "/java.new", dPlatform.getAbsolutePath + "/java"))
      }

      {
        val scalaSapp = new File(updateSiteDir, "apps/platform/scala.sapp")
        outPrintln("Unzipping " + scalaSapp.getAbsolutePath)
        unzip(scalaSapp, dPlatform, None)

        val scalaSappChecksum = new File(dMPlatform, "scala.sapp.checksum")
        val checksum = getChecksum(scalaSapp)
        outPrintln("Writing checkum (" + checksum + ") to " + scalaSappChecksum.getAbsolutePath)
        write(scalaSappChecksum, checksum)

        exec(Seq("mv", dPlatform.getAbsolutePath + "/scala.new", dPlatform.getAbsolutePath + "/scala"))
      }

      val filename = "sireum-" + (if (isStable) "stable" else "dev") + "-" + platform +
        (if (isWin) ".zip" else ".tar.gz")

      val file = new File(distDir, filename)

      if (file.exists)
        file.delete

      if (isWin)
        exec(Seq("zip", "-qr", filename, dSireum.getName), Some(distDir))
      else
        exec(Seq("tar", "cfz", filename, dSireum.getName), Some(distDir))

      exec(Seq("chmod", "775", file.getAbsolutePath))
      exec(Seq("chmod", "-R", "+w", dSireum.getAbsolutePath))
      exec(Seq("rm", "-R", dSireum.getAbsolutePath))
    }
  }

  def buildUpdateSite(srcDir : File, destDir : File, time : Date, isStable : Boolean) = {
    val timestamp = timeStamp(time)
    val text = if (isStable) "stable" else "dev"
    val dir = new File(new File(destDir, text), timestamp)

    // create update dir
    outPrintln("Creating directory: " + dir.getCanonicalPath)
    dir.getParentFile.mkdirs

    // make sireum script executable
    exec(Seq("chmod", "+x", new File(srcDir, "sireum").getAbsolutePath))

    // copy update files
    exec(Seq("cp", "-R", srcDir.getAbsolutePath, dir.getAbsolutePath))

    // write BUILD
    outPrintln("Writing BUILD: " + text + "-" + timestamp)
    val pwBuild = new PrintWriter(new FileWriter(new File(dir, "BUILD")))
    pwBuild.println(text + "-" + timestamp)
    pwBuild.close

    // write HTML redirect
    outPrintln("Writing index.html")
    val pwIndex = new PrintWriter(new FileWriter(new File(dir, "index.html")))
    val index = """<html>
  <head>
    <title>Sireum Update Site</title>
    <meta http-equiv="refresh" content="0;url=${URL}">
  </head>
  <body>
  </body>
</html>""".replace("${URL}", DOWNLOAD_URL)
    outPrintln(index)
    pwIndex.println(index)
    pwIndex.close

    // create latest symlink
    val latest = new File(new File(destDir, text), "latest")
    exec(Seq("rm", "-f", latest.getAbsolutePath))
    exec(Seq("ln", "-s", dir.getName, latest.getCanonicalPath), Some(dir.getParentFile))

    gitTag(srcDir, isStable, timestamp)

    dir
  }

  def symlink(dir : File) {
    val parentDir = dir.getParentFile
    for (r <- parentDir.listFiles(nonLatestDirectoryFileFilter))
      if (!(r.getName.length < 5) && r.getName != dir.getName)
        try
          symlink(dir, r)
        catch {
          case e : Exception =>
            outPrintln("Error symlinking: " + r.getAbsolutePath)
            exec(Seq("rm", "-R", r.getAbsolutePath))
            return
        }
  }

  def symlink(latest : File, previous : File) {
    outPrintln("Creating symlinks for same files in " + previous.getAbsolutePath)
    val lChecksums = getChecksums(latest)
    val pChecksums = getChecksums(previous)

    for ((pFilePath, pChecksum) <- pChecksums) {
      lChecksums.get(pFilePath) match {
        case Some(lChecksum) if pChecksum == lChecksum => {
          outPrintln("Creating symlink for " + pFilePath)
          val pFile = new File(previous, pFilePath)
          val lFile = new File(latest, pFilePath)
          val path = pFile.toPath.relativize(lFile.toPath)
          exec(Seq("rm", pFile.getAbsolutePath))
          exec(Seq("ln", "-s", path.toString.substring(3)), Some(pFile.getParentFile))
        }
        case _ =>
      }
    }
    outPrintln("Symlinks creation done.")
  }

  def getChecksums(dir : File) : Map[String, String] = {
    var result = Map[String, String]()
    val p = new Properties
    val fis = new FileInputStream(new File(dir, "checksums.properties"))
    try {
      p.load(fis)
      val i = p.entrySet.iterator
      while (i.hasNext) {
        val e = i.next
        val key = e.getKey.toString
        val value = e.getValue.toString.toLowerCase
        if (value != "0")
          result = result + (key -> value)
      }
    } finally {
      fis.close
    }
    result
  }

  def clippy(text : String, bgcolor : String) =
    """
<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
        width="110"
        height="14"
        id="clippy" >
<param name="movie" value="clippy.swf"/>
<param name="allowScriptAccess" value="always" />
<param name="quality" value="high" />
<param name="scale" value="noscale" />
<param NAME="FlashVars" value="text=${text}">
<param name="bgcolor" value="${bgcolor}">
<embed src="clippy.swf"
       width="110"
       height="14"
       name="clippy"
       quality="high"
       allowScriptAccess="always"
       type="application/x-shockwave-flash"
       pluginspage="http://www.macromedia.com/go/getflashplayer"
       FlashVars="text=${text}"
       bgcolor="${bgcolor}"
/>
</object>
""".replace("${bgcolor}", bgcolor).replace("${text}", text)

  def buildUpdateSiteListing(destDir : File, curr : Date) {
    val sbStable = new StringBuilder("<ul>\n")

    val stableDir = new File(destDir, "stable")
    val stables = stableDir.listFiles(nonLatestDirectoryFileFilter)
    for (stable <- skipSameDay(stables.sortWith(timeStampSort))) {

      val text = "http://update.sireum.org/stable/" + stable.getName
      sbStable.append("  <li>" + text + "&nbsp;" +
        clippy(text, "#FFFFFF") + "</li>\n")
    }

    sbStable.append("</ul>\n")

    //    val sbDev = new StringBuilder("<table border=\"0\">\n")
    //    sbDev.append("<tr>\n")
    //    sbDev.append("<td style=\"vertical-align: top;\">\n")
    //    sbDev.append("<ul>\n")
    val sbDev = new StringBuilder("<ul>\n")
    //    val sbDevMonth = new StringBuilder
    val devDir = new File(destDir, "dev")
    val devs = devDir.listFiles(nonLatestDirectoryFileFilter)
    for (dev <- skipSameDay(devs.sortWith(timeStampSort))) {
      //      if (dev.getName.length < 5) {
      //        sbDevMonth.append("  <li>" + dev.getName + "\n")
      //        sbDevMonth.append("    <ul>\n")
      //        for (devMonth <- dev.listFiles.reverse if devMonth.isDirectory) {
      //          val text = "http://update.sireum.org/dev/" + dev.getName +
      //            "/" + devMonth.getName
      //          sbDevMonth.append("    <li>" + text + "&nbsp;" + clippy(text, "#FFFFFF") +
      //            "</li>\n")
      //        }
      //        sbDevMonth.append("    </ul>\n")
      //        sbDevMonth.append("  </li>\n")
      //      } else {
      val text = "http://update.sireum.org/dev/" + dev.getName
      sbDev.append("  <li>" + text + "&nbsp;" +
        clippy(text, "#FFFFFF") + "</li>\n")
      //      }
    }
    sbDev.append("</ul>\n")
    //    sbDev.append("</td>\n")
    //    sbDev.append("<td style=\"vertical-align: top;\">\n")
    //    sbDev.append(sbDevMonth.toString)
    //    sbDev.append("</td>\n")
    //    sbDev.append("</tr>\n")
    //    sbDev.append("</table>\n")

    val listingStable = sbStable.toString
    outPrintln("Writing stable/listing.html")
    outPrintln(listingStable)
    val pwListingStable = new PrintWriter(new FileWriter(new File(destDir, "stable/listing.html")))
    pwListingStable.println(listingStable)
    pwListingStable.close

    val listingDev = sbDev.toString
    outPrintln("Writing dev/listing.html")
    outPrintln(listingDev)
    val pwListingDev = new PrintWriter(new FileWriter(new File(destDir, "dev/listing.html")))
    pwListingDev.println(listingDev)
    pwListingDev.close
  }

  def archiveMonthly(devDir : File, srcDir : File, time : Date) {
    val cal = Calendar.getInstance
    cal.setTime(time)
    if (cal.get(Calendar.DAY_OF_MONTH) != 1)
      return
    var year = cal.get(Calendar.YEAR)
    val mon = cal.get(Calendar.MONTH)
    if (mon == Calendar.JANUARY) {
      year -= 1
    }
    val yearDir = new File(devDir, year.toString)
    yearDir.mkdirs
    val monthDir = new File(yearDir, month(mon))

    // copy update files
    exec(Seq("cp", "-R", srcDir.getAbsolutePath, monthDir.getAbsolutePath))

    gitTag(srcDir, false, year.toString + month(mon))
  }

  def gitTag(srcDir : File, isStable : Boolean, tagid : String) {
    val id = (if (isStable) "stable" else "dev") + "-" + tagid
    val r = (new Function1[File, File] {
      def apply(s : File) : File = {
        if (s.getName() == "sireumv2") s
        else apply(s.getParentFile())
      }
    })(srcDir.getAbsoluteFile)
    Seq(r, new File(r, "codebase/bakar"), new File(r, "codebase/core"),
      new File(r, "codebase/prelude"), new File(r, "codebase/parser"),
      new File(r, "codebase/jawa"), new File(r, "codebase/amandroid")).foreach { f =>
        exec(Seq("git", "remote", "-v"), Some(f))
        exec(Seq("git", "tag", "-f", "-a", id, "-m", "'" + id + "'"), Some(f))
        exec(Seq("git", "push", "--tags"), Some(f))
      }
  }

  def month(num : Int) =
    num match {
      case Calendar.JANUARY   => "dec"
      case Calendar.FEBRUARY  => "jan"
      case Calendar.MARCH     => "feb"
      case Calendar.APRIL     => "mar"
      case Calendar.MAY       => "apr"
      case Calendar.JUNE      => "may"
      case Calendar.JULY      => "jun"
      case Calendar.AUGUST    => "jul"
      case Calendar.SEPTEMBER => "aug"
      case Calendar.OCTOBER   => "sep"
      case Calendar.NOVEMBER  => "oct"
      case Calendar.DECEMBER  => "nov"
    }

  def skipSameDay(files : Array[File]) = {
    var curr = ""
    var fstables = List[File]()
    for (f <- files) {
      val fName = f.getName
      if (curr == "") {
        curr = fName
        fstables = f :: fstables
      } else if (fName.length < 5 || curr.length < 5
        || curr.substring(0, 8) != fName.substring(0, 8)) {
        curr = fName
        fstables = f :: fstables
      }
    }
    fstables.reverse.toArray
  }

  def deleteOldStableSites(stableDir : File, time : Date) {
    var stables = stableDir.listFiles(nonLatestDirectoryFileFilter)
    stables = stables.sortWith(timeStampSort)
    stables = skipSameDay(stables)
    if (stables.length > STABLE_WINDOW)
      for (i <- STABLE_WINDOW until stables.length)
        exec(Seq("rm", "-R", stables(i).getCanonicalPath))
  }

  def deleteOldDevSites(devDir : File, time : Date) {
    val currentTime = time.getTime
    val devs = devDir.listFiles(nonLatestDirectoryFileFilter)
    val day = dayStamp(time)
    for (dev <- devs) {
      if (dev.getName.length > 4) {
        val devTime = timeStampFormat.parse(dev.getName).getTime
        val lapse = currentTime - devTime
        if (lapse > DEV_WINDOW_MS)
          exec(Seq("rm", "-R", dev.getCanonicalPath))
      }
    }
  }

  def exec(cmd : Seq[String], dir : Option[File] = None) {
    outPrintln("Executing: " + cmd.mkString(" "))
    new Exec().run(-1, cmd, None, dir) match {
      case Exec.StringResult(s, exitValue) =>
        val text = s.trim
        if (text != "")
          outPrintln(s)
        if (exitValue != 0)
          sys.exit(exitValue)
      case Exec.ExceptionRaised(e) =>
        e.printStackTrace
        sys.exit(-1)
      case Exec.Timeout =>
        sys.error("Exec timeout!")
    }
  }

  /**
   * @author <a href="mailto:robby@k-state.edu">Robby</a>
   */
  object Exec {
    sealed abstract class Result
    object Timeout extends Result
    case class ExceptionRaised(e : Exception) extends Result
    case class StringResult(s : String, exitValue : Int) extends Result
  }

  /**
   * @author <a href="mailto:robby@k-state.edu">Robby</a>
   */
  final class Exec {
    private val sb = new StringBuffer

    val env = scala.collection.mutable.Map.empty[String, String]

    def run(waitTime : Long, args : Seq[String], input : Option[String],
            extraEnv : (String, String)*) : Exec.Result =
      run(waitTime, args, input, None, extraEnv : _*)

    def run(waitTime : Long, args : Seq[String], input : Option[String],
            dir : Option[File], extraEnv : (String, String)*) : Exec.Result = {
      import scala.sys.process._
      val p = Process({
        val pb = new java.lang.ProcessBuilder(args : _*)
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
        import scala.concurrent._
        import scala.concurrent.duration._
        import scala.concurrent.ExecutionContext.Implicits.global

        try {
          val x = Await.result(future { p.exitValue }, waitTime.millis)
          Exec.StringResult(sb.toString, x)
        } catch {
          case _ : TimeoutException =>
            p.destroy
            Exec.Timeout
        }
      }
    }

    def inputF(in : Option[String])(out : OutputStream) {
      val osw = new OutputStreamWriter(out)
      try in match {
        case Some(s) => osw.write(s, 0, s.length)
        case _       =>
      }
      finally osw.close
    }

    def outputF(is : InputStream) {
      val buffer = new Array[Byte](10 * 1024)
      try {
        var n = is.read(buffer)
        while (n != -1) {
          sb.append(new String(buffer, 0, n))
          n = is.read(buffer)
        }
      } finally is.close
    }

    def errorF(is : InputStream) {
      try while (is.read != -1) {} finally is.close
    }
  }

  def unzip(file : File, outputDir : File, pw : Option[PrintWriter]) {
    import scala.collection.JavaConversions._
    import scala.collection.mutable._

    val zipFile = new ZipFile(file)
    val dirLastModMap = Map[String, Long]()
    try {
      val entries = zipFile.entries
      for (e <- entries) {
        if (pw.isDefined)
          pw.get.println(e.getName)
        unzipEntry(zipFile, e, outputDir, dirLastModMap)
      }

      if (getOsString.indexOf("win") < 0) {
        val ze = zipFile.getEntry(".sapp_info")
        if (ze != null) {
          val is = zipFile.getInputStream(ze)
          val p = new Properties
          p.load(is)
          for (e <- p) {
            try {
              Files.setPosixFilePermissions(new File(outputDir, e._1).toPath,
                maskToPermSet(e._2.toInt))
            } catch {
              case e : IOException =>
            }
          }
        }
      }
    } finally zipFile.close

    for (
      path <- dirLastModMap.keys.toSeq.sortWith({
        (s1, s2) =>
          s1.compareTo(s2) > 0
      })
    ) {
      new File(path).setLastModified(dirLastModMap(path))
    }
  }

  def maskToPermSet(mask : Int) = {
    import scala.collection.mutable._
    val result = Set[PosixFilePermission]()
    val values = PosixFilePermission.values
    for (i <- 0 until values.length) {
      if ((mask & (1 << i)) > 0) {
        result += values(i)
      }
    }
    result
  }

  def unzipEntry(zipFile : ZipFile, entry : ZipEntry, outputDir : File,
                 dirLastModMap : scala.collection.mutable.Map[String, Long]) {
    val entryName = entry.getName
    if (!(entryName.indexOf("__MACOSX") < 0 &&
      entryName.indexOf(".DS_Store") < 0 &&
      entryName.indexOf(SAPP_INFO) < 0)) return

    if (entryName.endsWith(SAPP_LINK_EXT)) {
      val bytes = new Array[Byte](entry.getSize.toInt)
      val is = zipFile.getInputStream(entry)
      try {
        val n = is.read(bytes)
        assert(n == bytes.length)
      } finally is.close
      val outputFile = new File(outputDir,
        entryName.substring(0, entryName.length - SAPP_LINK_EXT.length))
      val path = new File(new String(bytes)).toPath
      try {
        Files.createSymbolicLink(outputFile.toPath, path)
      } catch {
        case e : IOException =>
          errPrintln("Could not create symbolic link: " +
            outputFile.getAbsolutePath + " to " + path)
      }
      val time = entry.getTime
      if (time != 0)
        outputFile.setLastModified(time)
      return
    }

    if (entry.isDirectory) {
      val dir = new File(outputDir, entryName)
      dir.mkdirs
      val time = entry.getTime
      if (time != 0) {
        dirLastModMap(dir.getAbsolutePath) = time
      }
    } else {
      val outputFile = new File(outputDir, entryName)
      if (!outputFile.getParentFile.exists)
        outputFile.getParentFile.mkdirs

      val is = new BufferedInputStream(zipFile.getInputStream(entry))
      val os = new BufferedOutputStream(new FileOutputStream(outputFile))

      try transfer(is, os)
      finally {
        os.close
        is.close
      }

      outputFile.setReadable(true)
      outputFile.setWritable(true)
      outputFile.setExecutable(true)

      val time = entry.getTime
      if (time != 0)
        outputFile.setLastModified(time)
    }
  }

  def transfer(is : InputStream, os : OutputStream) {
    val buf = new Array[Byte](BUFFER_SIZE)
    var len = is.read(buf)
    while (len > 0) {
      os.write(buf, 0, len)
      len = is.read(buf)
    }
  }

  def getOsString = {
    val osArch = System.getProperty("os.arch")
    val is64bit = osArch.contains("64")

    val osName = System.getProperty("os.name").toLowerCase()
    if (osName.indexOf("mac") >= 0)
      (if (is64bit) "mac64" else "mac32")
    else if (osName.indexOf("nux") >= 0)
      (if (is64bit) "linux64" else "linux32")
    else if (osName.indexOf("win") >= 0)
      (if (is64bit) "win64" else "win32")
    else
      "unsupported"
  }

  def getChecksum(file : File) = {
    val md = MessageDigest.getInstance("MD5")

    val is = new BufferedInputStream(new FileInputStream(file))
    try {
      val dis = new DigestInputStream(is, md)
      while (dis.read != -1) {}
    } finally is.close

    val digest = md.digest

    val result = new StringBuilder
    for (i <- 0 until digest.length) {
      val s = Integer.toString((digest(i) & 0xff), 16)
      if (s.length == 1) result.append('0')
      result.append(s)
    }

    result.toString
  }

  def write(file : File, text : String) {
    file.getParentFile.mkdirs
    val w = new PrintWriter(new FileWriter(file))
    w.println(text)
    w.close
  }
}
