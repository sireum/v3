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

package org.sireum.web.playground

import org.scalajs.dom
import org.sireum.web.playground.Files.ChangeMode

import scala.collection.immutable.{SortedMap, SortedSet}
import scala.scalajs.js
import org.sireum.web.util._

object GitHub {

  final case class RepoAuth(user: String, repo: String, token: String)

  final case class Escape(msg: String) extends RuntimeException

  val repoAuthKey = "org.sireum.github"

  def lookup(): Option[GitHub.RepoAuth] = {
    import upickle.default._
    Option(dom.window.sessionStorage.getItem(repoAuthKey)).map(read[RepoAuth])
  }

  def update(repoAuth: GitHub.RepoAuth): Unit = {
    import upickle.default._
    dom.window.sessionStorage.setItem(repoAuthKey, write(repoAuth))
  }

  def erase(): Unit = {
    dom.window.sessionStorage.removeItem(repoAuthKey)
  }

  def gitHubRepo(repoAuth: RepoAuth): github.Repository =
    new github.GitHub(jsObj(token = repoAuth.token)).getRepo(repoAuth.user, repoAuth.repo)

  def test(repoAuth: GitHub.RepoAuth,
           success: () => Unit,
           error: () => Unit): Unit =
    gitHubRepo(repoAuth).getDetails {
      case (null, _, _) =>
        update(repoAuth)
        success()
      case _ => error()
    }

  def findFiles(repoAuth: GitHub.RepoAuth,
                filePathFilter: String => Boolean,
                success: SortedSet[String] => Unit,
                error: String => Unit): Unit = {
    val repo = gitHubRepo(repoAuth)

    def recurseDir(path: String, f: List[String] => Unit): Unit = {
      repo.getContents(null, if (path == null) null else s"$path?timestamp=0", raw = false, {
        case (null, (files: js.Array[js.Dynamic]@unchecked), _) =>
          def dir(acc: List[String], dirPaths: List[String]): Unit = dirPaths match {
            case Nil => f(acc)
            case head :: tail => recurseDir(head, fs2 => dir(acc ++ fs2, tail))
          }

          var fs = List[String]()
          var dirPaths = List[String]()
          for (e <- files) e.`type`.toString match {
            case "dir" => dirPaths = e.path.toString :: dirPaths
            case "file" if filePathFilter(e.name.toString) => fs = e.path.toString :: fs
            case _ =>
          }
          dir(fs, dirPaths)
        case (err, _, _) => throw Escape(err.message.toString)
      })
    }

    try {
      repo.getContributors({
        case (null, result, _) if result != null => recurseDir(null, l => success(SortedSet(l: _*)))
        case (null, _, _) => success(SortedSet())
      })
    } catch {
      case Escape(msg) => error(msg)
    }
  }

  def downloadFiles(repoAuth: GitHub.RepoAuth,
                    files: Iterable[String],
                    success: SortedMap[String, String] => Unit,
                    error: String => Unit): Unit = {
    val repo = gitHubRepo(repoAuth)

    def recurseFiles(acc: SortedMap[String, String], fs: List[String]): Unit = fs match {
      case Nil => success(acc)
      case head :: tail =>
        repo.getContents(null, s"$head?timestamp=0", raw = false, {
          case (err, result, _) if err == null =>
            ((result.`type`.toString, result.`encoding`.toString): @unchecked) match {
              case ("file", "base64") => recurseFiles(acc + (head -> dom.window.atob(result.`content`.toString)), tail)
              case ("submodule", _) => recurseFiles(acc, tail)
              case ("file", encoding) => throw Escape(s"Unsupported file encoding $encoding for $head")
            }
          case (err, _, _) => throw Escape(s"Could not get the file content of $head (reason: ${err.message.toString})")
        })
    }

    try recurseFiles(SortedMap(), files.toList)
    catch {
      case Escape(msg) => error(msg)
    }
  }

  def pushChanges(repoAuth: GitHub.RepoAuth, changes: SortedMap[String, ChangeMode.Type], error: String => Unit): Unit = {
    val repo = gitHubRepo(repoAuth)

    var branch = "master"

    def recurseChanges(cs: List[(String, ChangeMode.Type)]): Unit = cs match {
      case Nil =>
      case (f, cm) :: tail => cm match {
        case ChangeMode.Add | ChangeMode.Update =>
          val message = if (cm == ChangeMode.Add) s"Added $f." else s"Updated $f."
          repo.writeFile("master", s"$f?timestamp=0", Files.lookupContent(f).get, message, jsObj(encode = true), {
            case (err, _, _) if err == null => recurseChanges(tail)
            case (err, _, _) => throw Escape(err.message.toString)
          })
        case ChangeMode.Delete =>
          repo.deleteFile("master", s"$f?timestamp=0", {
            case (err, _, _) if err == null => recurseChanges(tail)
            case (err, _, _) => throw Escape(err.message.toString)
          })
      }
    }

    repo.getDetails({
      case (_, result, _) =>
        branch = result.default_branch.toString
        try recurseChanges(changes.toList)
        catch {
          case Escape(msg) => error(msg)
        }
    })
  }
}
