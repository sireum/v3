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

import ffi.Repository
import org.scalajs.dom
import org.sireum.web.playground.Files.ChangeMode
import org.sireum.web.ui.Notification

import scala.collection.immutable.{SortedMap, SortedSet}
import scala.scalajs.js
import org.sireum.common.JSutil._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Failure

object GitHub {

  final case class RepoAuth(user: String, repo: String, token: String)

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

  def gitHubRepo(repoAuth: RepoAuth): Repository =
    new ffi.GitHub(jsObj(token = repoAuth.token)).getRepo(repoAuth.user, repoAuth.repo)

  def rateLimit(repoAuth: RepoAuth, success: Int => Unit): Unit =
    new ffi.GitHub(jsObj(token = repoAuth.token)).getRateLimit().getRateLimit({
      case (err, result, _) if err == null => success(result.rate.remaining.toString.toInt)
      case _ =>
    })

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
            case head :: tail =>
              recurseDir(head, fs2 => dir(acc ++ fs2, tail))
          }

          var fs = List[String]()
          var dirPaths = List[String]()
          for (e <- files) e.`type`.toString match {
            case "dir" => dirPaths = e.path.toString :: dirPaths
            case "file" if filePathFilter(e.name.toString) => fs = e.path.toString :: fs
            case _ =>
          }
          dir(fs, dirPaths)
        case (err, _, _) => Notification.notify(Notification.Kind.Error, s"Error encountered when accessing directory ${if (path == null) "/" else path} (reason: ${err.message}).")
      })
    }

    repo.getContributors({
      case (null, result, _) if result != null => recurseDir(null, l => success(SortedSet(l: _*)))
      case (null, _, _) => success(SortedSet())
    })
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
              case ("file", encoding) => Notification.notify(Notification.Kind.Error, s"Unsupported file encoding $encoding for $head.")
            }
          case (err, _, _) => Notification.notify(Notification.Kind.Error, s"Could not get the file content of $head (reason: ${err.message.toString}).")
        })
    }

    recurseFiles(SortedMap(), files.toList)
  }

  def pushChanges(repoAuth: GitHub.RepoAuth, changes: SortedMap[String, ChangeMode.Type],
                  success: () => Unit, error: String => Unit): Unit = {
    val repo = gitHubRepo(repoAuth)

    var branch = "master"

    def recurseChanges(cs: List[(String, ChangeMode.Type)]): Unit = cs match {
      case Nil => success()
      case (f, cm) :: tail => cm match {
        case ChangeMode.Add | ChangeMode.Update =>
          val message = if (cm == ChangeMode.Add) s"Added $f." else s"Updated $f."
          repo.writeFile("master", s"$f?timestamp=0", Files.lookupContent(f).get, message, jsObj(encode = true), {
            case (err, _, _) if err == null => recurseChanges(tail)
            case (err, _, _) => Notification.notify(Notification.Kind.Error, s"Could not push file content of $f (reason: ${err.message.toString}).")
          }).toFuture.onComplete {
            case Failure(t) => Notification.notify(Notification.Kind.Error, s"Could not push file content of $f (reason: ${t.getMessage}).")
            case _ =>
          }
        case ChangeMode.Delete =>
          repo.deleteFile("master", s"$f?timestamp=0", {
            case (err, _, _) if err == null => recurseChanges(tail)
            case (err, _, _) => Notification.notify(Notification.Kind.Error, s"Could not delete file $f (reason: ${err.message.toString}).")
          })
      }
    }

    repo.getDetails({
      case (err, result, _) if err == null =>
        branch = result.default_branch.toString
        recurseChanges(changes.toList)
      case (err, _, _) => Notification.notify(Notification.Kind.Error, s"Could not determine the default repository branch (reason: ${err.message.toString}).")
     })
  }
}
