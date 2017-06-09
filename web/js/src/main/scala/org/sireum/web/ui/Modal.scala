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


package org.sireum.web.ui

import org.scalajs.dom
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.html.{Anchor, Button, Div, Input, Label, Paragraph}
import org.scalajs.dom.raw.KeyboardEvent
import org.sireum.web.playground.{GitHub, Playground}

import scala.collection.immutable.SortedMap
import scalatags.Text.all._
import scalatags.Text.tags2._
import org.sireum.web.util._

object Modal {
  val escape = 27
  val enter = 13

  def confirm(titleText: String, labelText: String, success: () => Unit): Unit =
    confirm(titleText, div(cls := "field", label(cls := "label")(labelText)), success)

  def confirm(titleText: String,
              body: Frag,
              success: () => Unit): Unit = {
    val modal = render[Div](
      div(cls := "modal is-active",
        div(cls := "modal-background"),
        div(cls := "modal-card",
          header(cls := "modal-card-head",
            p(cls := "modal-card-title")(titleText),
            button(id := "modal-delete", cls := "delete")
          ),
          section(cls := "modal-card-body", body),
          footer(cls := "modal-card-foot",
            a(id := "modal-ok", cls := "button is-success")("Ok"),
            a(id := "modal-cancel", cls := "button is-danger is-focused")("Cancel")
          )
        )
      )
    )

    val oldKeyup = dom.document.onkeyup

    dom.document.body.appendChild(modal)

    def close(): Unit = {
      dom.document.onkeyup = oldKeyup
      dom.document.body.removeChild(modal)
      Playground.editor.focus()
    }

    val okButton = $[Anchor]("#modal-ok")
    okButton.onclick = (_: MouseEvent) => if (okButton.getAttribute("disabled") != "true") {
      okButton.className += " is-loading"
      okButton.setAttribute("disabled", "true")
      success()
      close()
    }

    val closeF = (_: MouseEvent) => close()
    $[Button]("#modal-delete").onclick = closeF
    $[Anchor]("#modal-cancel").onclick = closeF

    dom.document.onkeyup = (e: KeyboardEvent) => {
      e.keyCode match {
        case `escape` => close()
        case _ =>
      }
    }
  }

  def textInput(titleText: String,
                labelText: String,
                placeholderText: String,
                validator: String => Boolean,
                success: String => Unit): Unit = {
    val modal = render[Div](
      div(cls := "modal is-active",
        div(cls := "modal-background"),
        div(cls := "modal-card",
          header(cls := "modal-card-head",
            p(cls := "modal-card-title")(titleText),
            button(id := "modal-delete", cls := "delete")
          ),
          section(cls := "modal-card-body",
            div(cls := "field",
              label(cls := "label")(labelText),
              p(cls := "control",
                input(id := "modal-input", cls := "input is-danger", `type` := "text", placeholder := placeholderText)
              )
            )
          ),
          footer(cls := "modal-card-foot",
            a(id := "modal-ok", cls := "button", disabled := true)("Ok"),
            a(id := "modal-cancel", cls := "button is-danger")("Cancel")
          )
        )
      )
    )

    val oldKeyup = dom.document.onkeyup

    dom.document.body.appendChild(modal)

    def close(): Unit = {
      dom.document.onkeyup = oldKeyup
      dom.document.body.removeChild(modal)
      Playground.editor.focus()
    }

    val okButton = $[Anchor]("#modal-ok")
    val textInput = $[Input]("#modal-input")

    def ok(): Unit = {
      if (okButton.getAttribute("disabled") != "true") {
        close()
        success(textInput.value)
      }
    }

    okButton.onclick = (_: MouseEvent) => ok()

    val closeF = (_: MouseEvent) => close()
    $[Button]("#modal-delete").onclick = closeF
    $[Anchor]("#modal-cancel").onclick = closeF

    textInput.onkeyup = (e: KeyboardEvent) => {
      e.keyCode match {
        case `escape` => close()
        case `enter` => ok()
        case _ =>
          if (validator(textInput.value)) {
            textInput.className = "input is-success"
            okButton.className = "button is-success"
            okButton.removeAttribute("disabled")
          } else {
            textInput.className = "input is-danger"
            okButton.className = "button"
            okButton.setAttribute("disabled", "true")
          }
      }
    }

    dom.document.onkeyup = (e: KeyboardEvent) => {
      e.keyCode match {
        case `escape` => close()
        case `enter` => ok()
        case _ =>
      }
    }

    textInput.focus()
  }


  def gitHubToken(repoAuthOpt: Option[GitHub.RepoAuth],
                  fileFilter: String => Boolean,
                  pull: (GitHub.RepoAuth, SortedMap[String, String]) => Unit,
                  push: (GitHub.RepoAuth, SortedMap[String, String]) => Unit): Unit = {
    val tokenRawLabel = """Personal Access Token (<a target="_blank" href="https://github.com/settings/tokens/new">with full control of private repositories</a>)"""
    val modal = render[Div](
      div(cls := "modal is-active",
        div(cls := "modal-background"),
        div(cls := "modal-card",
          header(cls := "modal-card-head",
            div(cls := "modal-card-title",
              span(cls := "icon is-medium", i(cls := "fa fa-github")),
              span(raw("&nbsp;GitHub"))
            ),
            button(id := "modal-delete", cls := "delete")
          ),
          section(cls := "modal-card-body",
            div(cls := "field",
              label(cls := "label")("Owner"),
              p(cls := "control",
                input(id := "modal-input-user", cls := "input is-danger", `type` := "text", placeholder := "Enter user/organization")
              )
            ),
            div(cls := "field",
              label(cls := "label")("Repository"),
              p(cls := "control",
                input(id := "modal-input-repo", cls := "input is-danger", `type` := "text", placeholder := "Enter repository")
              )
            ),
            div(cls := "field",
              label(id := "token", cls := "label")(raw(tokenRawLabel)),
              p(cls := "control",
                input(id := "modal-input-token", cls := "input is-danger", `type` := "text", placeholder := "Enter token")
              )
            ),
            div(cls := "field",
              label(cls := "label")("URL"),
              p(id := "modal-github-url")("https://github.com/<user>/<repo>.git")
            )
          ),
          footer(cls := "modal-card-foot",
            a(id := "modal-pull", cls := "button",
              span(raw("&nbsp;")),
              span(cls := "icon", i(cls := "fa fa-cloud-download")),
              span(raw("&nbsp;&nbsp;Pull&nbsp;"))
            ),
            a(id := "modal-push", cls := "button",
              span(raw("&nbsp;")),
              span(cls := "icon", i(cls := "fa fa-cloud-upload")),
              span(raw("&nbsp;&nbsp;Push&nbsp;"))
            ),
            a(id := "modal-cancel", cls := "button is-danger")("Cancel")
          )
        )
      )
    )

    val oldKeyup = dom.document.onkeyup

    dom.document.body.appendChild(modal)

    val userInput = $[Input]("#modal-input-user")
    val repoInput = $[Input]("#modal-input-repo")
    val tokenInput = $[Input]("#modal-input-token")
    val pullButton = $[Anchor]("#modal-pull")
    val pushButton = $[Anchor]("#modal-push")
    val gitHubUrl = $[Paragraph]("#modal-github-url")
    val tokenLabel = $[Label]("#token")

    def updateUrl(): Unit = {
      var ok = true
      val user = if (userInput.value.trim != "") userInput.value else {
        ok = false
        "〈owner〉"
      }
      val repo = if (repoInput.value.trim != "") repoInput.value else {
        ok = false
        "〈repo〉"
      }
      val url = s"https://github.com/$user/$repo.git"
      if (ok) gitHubUrl.innerHTML = s"""<a target="_blank" href="$url">$url</a>"""
      else gitHubUrl.innerHTML = url
    }

    def updateUserInput(): Unit = {
      if (userInput.value.trim != "") userInput.className = "input"
      else userInput.className = "input is-danger"
      updateUrl()
      updatePullPushButtons()
    }

    def updateRepoInput(): Unit = {
      if (repoInput.value.trim != "") repoInput.className = "input"
      else repoInput.className = "input is-danger"
      updateUrl()
      updatePullPushButtons()
    }

    def updateTokenInput(): Unit = {
      if (tokenInput.value.trim != "") tokenInput.className = "input"
      else tokenInput.className = "input is-danger"
      updatePullPushButtons()
      if (pullButton.getAttribute("disabled") != "true") {
        val repoAuth = GitHub.RepoAuth(userInput.value.trim, repoInput.value.trim, tokenInput.value.trim)
        val innerHtml = tokenLabel.innerHTML
        tokenLabel.innerHTML = tokenRawLabel
        GitHub.rateLimit(repoAuth, remaining => {
          val i = innerHtml.indexOf("<")
          val j = innerHtml.indexOf("</a>")
          tokenLabel.innerHTML = innerHtml.substring(0, i) + s"""<a target="_blank" href="https://developer.github.com/v3/#rate-limiting">rate limit remaining: $remaining""" + innerHtml.substring(j)
        })
      }
    }

    def updatePullPushButtons(force: Boolean = false): Unit =
      if (force || (!pushButton.className.contains("is-loading") && !pullButton.className.contains("is-loading")))
        if (!userInput.className.contains("is-danger") &&
          !repoInput.className.contains("is-danger") &&
          !tokenInput.className.contains("is-danger")) {
          pullButton.className = "button is-primary"
          pushButton.className = "button is-primary"
          pullButton.removeAttribute("disabled")
          pushButton.removeAttribute("disabled")
        } else {
          pullButton.className = "button"
          pushButton.className = "button"
          pullButton.setAttribute("disabled", "true")
          pushButton.setAttribute("disabled", "true")
        }

    def close(): Unit = {
      dom.document.onkeyup = oldKeyup
      dom.document.body.removeChild(modal)
      Playground.editor.focus()
    }

    def notifyError(err: String): Unit = {
      Notification.notify(Notification.Kind.Error, err)
      updatePullPushButtons(force = true)
    }

    val couldNotConnect = () => notifyError("Could not connect to the repository.")

    pullButton.onclick = (_: MouseEvent) => {
      if (pullButton.getAttribute("disabled") != "true") {
        pullButton.className += " is-loading"
        pushButton.setAttribute("disabled", "true")
        pullButton.setAttribute("disabled", "true")
        val repoAuth = GitHub.RepoAuth(userInput.value.trim, repoInput.value.trim, tokenInput.value.trim)
        GitHub.test(repoAuth, () =>
          GitHub.findFiles(repoAuth, fileFilter, fs =>
            GitHub.downloadFiles(repoAuth, fs, fm => {
              close()
              pull(repoAuth, fm)
            }, notifyError),
            notifyError),
          couldNotConnect
        )
      }
    }

    pushButton.onclick = (_: MouseEvent) => {
      if (pushButton.getAttribute("disabled") != "true") {
        pushButton.className += " is-loading"
        pushButton.setAttribute("disabled", "true")
        pullButton.setAttribute("disabled", "true")
        val repoAuth = GitHub.RepoAuth(userInput.value.trim, repoInput.value.trim, tokenInput.value.trim)
        GitHub.test(repoAuth, () =>
          GitHub.findFiles(repoAuth, fileFilter, fs =>
            GitHub.downloadFiles(repoAuth, fs, fm => {
              close()
              push(repoAuth, fm)
            }, notifyError),
            notifyError),
          couldNotConnect
        )
      }
    }

    val closeF = (_: MouseEvent) => close()
    $[Button]("#modal-delete").onclick = closeF
    $[Anchor]("#modal-cancel").onclick = closeF

    userInput.onkeyup = (_: KeyboardEvent) => updateUserInput()
    repoInput.onkeyup = (_: KeyboardEvent) => updateRepoInput()
    tokenInput.onkeyup = (_: KeyboardEvent) => updateTokenInput()

    dom.document.onkeyup = (e: KeyboardEvent) => {
      e.keyCode match {
        case `escape` => close()
        case _ =>
      }
    }

    repoAuthOpt match {
      case Some(auth) =>
        userInput.value = auth.user
        repoInput.value = auth.repo
        tokenInput.value = auth.token
      case _ =>
    }

    updateUserInput()
    updateRepoInput()
    updateTokenInput()

    if (userInput.value.trim == "") userInput.focus()
    else if (repoInput.value.trim == "") repoInput.focus()
    else if (tokenInput.value.trim == "") tokenInput.focus()
  }

  def wsd(port: Int, success: Int => Unit): Unit = {
    val modal = render[Div](
      div(cls := "modal is-active",
        div(cls := "modal-background"),
        div(cls := "modal-card",
          header(cls := "modal-card-head",
            p(cls := "modal-card-title")("Sireum WebSocket Daemon Required"),
            button(id := "modal-delete", cls := "delete")
          ),
          section(cls := "modal-card-body",
            div(cls := "field",
              label(cls := "label")("Port"),
              p(cls := "control",
                input(id := "modal-input-port", cls := "input", `type` := "text", placeholder := port.toString)
              )
            ),
            p("Please download and run ",
              a(target := "_blank", href := "https://github.com/sireum/v3-wsd.js", "Sireum WebSocket Daemon (WSD)."))
          ),
          footer(cls := "modal-card-foot",
            a(id := "modal-ok", cls := "button is-success")("Ok"),
            a(id := "modal-cancel", cls := "button is-danger is-focused")("Cancel")
          )
        )
      )
    )

    val oldKeyup = dom.document.onkeyup

    dom.document.body.appendChild(modal)

    val portInput = $[Input]("#modal-input-port")

    def close(): Unit = {
      dom.document.onkeyup = oldKeyup
      dom.document.body.removeChild(modal)
      Playground.editor.focus()
    }

    val okButton = $[Anchor]("#modal-ok")
    okButton.onclick = (_: MouseEvent) => if (okButton.getAttribute("disabled") != "true") {
      okButton.className += " is-loading"
      okButton.setAttribute("disabled", "true")
      val text = portInput.value.trim
      if ("" == text) success(port) else success(portInput.value.toInt)
      close()
    }

    val closeF = (_: MouseEvent) => close()
    $[Button]("#modal-delete").onclick = closeF
    $[Anchor]("#modal-cancel").onclick = closeF

    portInput.onkeyup = _ => {
      try {
        portInput.value.trim.toInt
        portInput.className = "input"
        okButton.removeAttribute("disabled")
      } catch {
        case _: Exception =>
          portInput.className = "input is-danger"
          okButton.setAttribute("disabled", "true")
      }
    }

    dom.document.onkeyup = (e: KeyboardEvent) => {
      e.keyCode match {
        case `escape` => close()
        case _ =>
      }
    }
  }
}
