object ProjectHelper {

  def transitiveDependencies(projectInfos : Vector[ProjectInfo]) = {
    var piMap = Map[String, ProjectInfo]()
    var depTrans = Map[String, Set[String]]()
    for (pi <- projectInfos) {
      piMap = piMap + (pi.name -> pi)
      depTrans = depTrans + (pi.name -> pi.dependencies.map(_.name).toSet)
    }
    var changed = true
    while (changed) {
      changed = false
      for ((pi, piDep) <- depTrans.toSeq) {
        var newPiDep = piDep
        for (pi2 <- piDep) {
          newPiDep = newPiDep ++ piMap(pi2).dependencies.map(_.name)
        }
        if (newPiDep.size != piDep.size) {
          changed = true
          depTrans = depTrans + (pi -> newPiDep)
        }
      }
    }
    depTrans
  }

  def cliGen(args : Seq[String], projectInfos : Vector[ProjectInfo]) {
    val (genClassName, destDir, className) = args match {
      case Seq(a, b, c) => (a, b, c)
      case _ =>
        println("Usage: cligen <gen-class-name> <dest-dir> <class-name>")
        sys.exit(1)
    }
    val sh = System.getenv("SIREUM_HOME")
    val cliargs = List(s"$sh/sireum", "tools", "cligen",
      "-c", genClassName, "-d", destDir, "-p", "org.sireum", className)
    import UpdateSiteBuilder.Exec._
    val e = new UpdateSiteBuilder.Exec()
    e.env("CLASSPATH") = projectInfos.map(_.libFiles.mkString(":")).mkString(":")
    e.run(-1, cliargs, None, None) match {
      case StringResult(s, 0) => println(s)
      case StringResult(s, c) =>
        Console.err.println(s)
        sys.exit(c)
      case ExceptionRaised(ex) =>
        Console.err.println(ex)
        sys.exit(1)
      case Timeout => sys.exit(1)
    }
  }

  def dotDependency(args : Seq[String], projectInfos : Vector[ProjectInfo]) {
    val filename =
      args match {
        case Seq(file) => file
        case _         => "project-dependency.dot"
      }
    val depTrans = transitiveDependencies(projectInfos)
    import java.io._
    val f = new File(filename)
    val fw = new FileWriter(f)
    try {
      val pw = new PrintWriter(fw)
      pw.println("digraph G {")
      for (pi <- projectInfos.reverse) {
        pw.println("  \"" + pi.name + "\" [shape=\"box\"]")
        val deps = pi.dependencies.map(_.name)
        for (pi2Name <- deps.toSet -- deps.flatMap(depTrans(_)))
          pw.println("  \"" + pi.name + "\" -> \"" + pi2Name + "\"")
      }
      pw.println("}")
      println("Project dependency graph written to: " + f.getCanonicalPath)
    } finally fw.close()
  }
}