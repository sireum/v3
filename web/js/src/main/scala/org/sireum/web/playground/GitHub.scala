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
import org.sireum.web.util._

import scala.collection.immutable.SortedSet
import scala.scalajs.js

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

  def test(repoAuth: GitHub.RepoAuth,
           success: () => Unit,
           error: () => Unit): Unit =
    new github.GitHub(jsObj(token = repoAuth.token)).getRepo(repoAuth.user, repoAuth.repo).getDetails {
      case (null, _, _) =>
        update(repoAuth)
        success()
      case _ => error()
    }

  def findFiles(repoAuth: GitHub.RepoAuth,
                filePathFilter: String => Boolean,
                success: SortedSet[String] => Unit): Unit = {
    val repo = new github.GitHub(jsObj(token = repoAuth.token)).getRepo(repoAuth.user, repoAuth.repo)

    def recurseDir(path: String, f: List[String] => Unit): Unit = {
      repo.getContents(null, path, raw = false, {
        case (null, (files: js.Array[js.Dynamic]@unchecked), _) =>
          def dir(fs: List[String], dirPaths: List[String]): Unit = dirPaths match {
            case Nil => f(fs)
            case head :: tail => recurseDir(head, fs2 => dir(fs ++ fs2, tail))
          }

          var fs = List[String]()
          var dirPaths = List[String]()
          for (e <- files) e.`type`.toString match {
            case "dir" => dirPaths = e.path.toString :: dirPaths
            case "file" if filePathFilter(e.name.toString) => fs = e.path.toString :: fs
            case _ =>
          }
          dir(fs, dirPaths)
      })
    }

    repo.getContributors({
      case (null, result, _) if result != null => recurseDir(null, l => success(SortedSet(l: _*)))
      case (null, _, _) => success(SortedSet())
    })
  }
}
