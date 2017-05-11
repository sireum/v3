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
import org.scalajs.dom.html.{Anchor, Button, Div, Input, Paragraph}
import org.scalajs.dom.raw.{Element, KeyboardEvent}
import org.sireum.web.playground.GitHub

import scalatags.Text.all._
import scalatags.Text.tags2._
import org.sireum.web.util._

object Modal {
  val escape = 27
  val enter = 13

  def confirm(titleText: String,
              labelText: String,
              success: () => Unit): Unit = {
    val modal = render[Div](
      div(cls := "modal is-active",
        div(cls := "modal-background"),
        div(cls := "modal-card",
          header(cls := "modal-card-head",
            p(cls := "modal-card-title")(titleText),
            button(id := "modal-delete", cls := "delete")
          ),
          section(cls := "modal-card-body",
            div(cls := "field", label(cls := "label")(labelText))
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

    def close(): Unit = {
      dom.document.onkeyup = oldKeyup
      dom.document.body.removeChild(modal)
    }

    val okButton = $[Anchor]("#modal-ok")
    okButton.onclick = (_: MouseEvent) => {
      close()
      success()
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


  def gitHubToken(titleText: String,
                  authOpt: Option[GitHub.RepoAuth],
                  pull: GitHub.RepoAuth => Unit,
                  push: GitHub.RepoAuth => Unit): Unit = {
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
              label(cls := "label")("User/Organization"),
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
              label(cls := "label")("Personal Token"),
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
            a(id := "modal-pull", cls := "button")("Pull"),
            a(id := "modal-push", cls := "button")("Push"),
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

    def updateUrl(): Unit = {
      var ok = true
      val user = if (userInput.value.trim != "") userInput.value else {
        ok = false
        "<user>"
      }
      val repo = if (repoInput.value.trim != "") repoInput.value else {
        ok = false
        "<repo>"
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
    }

    def updatePullPushButtons(): Unit =
      if (!pushButton.className.contains("is-loading") && !pullButton.className.contains("is-loading"))
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
    }

    var notifyCloseOpt: Option[() => Unit] = None

    def closeNotify(): Unit = {
      notifyCloseOpt.foreach(f => f())
      notifyCloseOpt = None
    }

    val couldNotConnect: () => Unit = () => {
      notifyCloseOpt = Some(Notification.notify(
        $[Element](".modal-card-body"), Notification.Kind.Error,
        "Could not connect to the specified repository."))
    }

    pullButton.onclick = (_: MouseEvent) => {
      if (pullButton.getAttribute("disabled") != "true") {
        closeNotify()
        pullButton.className += " is-loading"
        pushButton.setAttribute("disabled", "true")
        val auth = GitHub.RepoAuth(userInput.value, repoInput.value, tokenInput.value)
        GitHub.test(auth, () => {
          close()
          pull(auth)
        }, couldNotConnect)
      }
    }

    pushButton.onclick = (_: MouseEvent) => {
      if (pushButton.getAttribute("disabled") != "true") {
        closeNotify()
        pushButton.className += " is-loading"
        pullButton.setAttribute("disabled", "true")
        val auth = GitHub.RepoAuth(userInput.value, repoInput.value, tokenInput.value)
        GitHub.test(auth, () => {
          close()
          push(auth)
        },
          couldNotConnect)
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

    authOpt match {
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
}
