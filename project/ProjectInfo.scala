/*
Copyright (c) 2013 Robby, Kansas State University.        
All rights reserved. This program and the accompanying materials      
are made available under the terms of the Eclipse Public License v1.0 
which accompanies this distribution, and is available at              
http://www.eclipse.org/legal/epl-v10.html                             
*/

import sbt._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter

/**
  * @author <a href="mailto:robby@k-state.edu">Robby</a>
  */
object ProjectInfo {
  var projectInfos = Vector[ProjectInfo]()
  val ignoredFiles = Set[String](
  )

  final def dotDependency(args: Seq[String]): Unit = {
    val filename =
      args match {
        case Seq(file) => file
        case _ => "project-dependency.dot"
      }
    val depTrans = transitiveDependencies()
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

  private def transitiveDependencies() = {
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
}

/**
  * @author <a href="mailto:robby@k-state.edu">Robby</a>
  */
final case class ProjectInfo(name: String, isCross: Boolean,
                             dependencies: ProjectInfo*) {

  import ProjectInfo._

  projectInfos = projectInfos.:+(this)
  val id = name.toLowerCase.replace(' ', '-').replace('/', '-')
  val baseDir = file(name.toLowerCase.replace(' ', '-'))

  def genDot(seen: scala.collection.mutable.Set[String], pw: PrintWriter): Unit = {
    if (seen.contains(name)) return

    seen += name
    pw.println("  \"" + name + "\" [shape=\"box\"]")
    for (pi <- dependencies)
      pw.println("  \"" + name + "\" -> \"" + pi.name + "\"")
  }

  override def toString = {
    def h(t: Traversable[Object]) =
      if (t.isEmpty) "None"
      else "\n" + t.foldLeft("")((s, o) => s + "* " + o.toString + "\n")
    s"""
Project Name:         $name
Project Directory:    ${baseDir.getPath}
Project Dependencies: ${h(dependencies.map(_.name))}
      """
  }
}
