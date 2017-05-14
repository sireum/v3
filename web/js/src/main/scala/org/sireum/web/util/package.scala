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

package org.sireum.web

import org.scalajs.dom
import org.scalajs.dom.raw.{DocumentFragment, Element, Node, NodeList}
import org.scalajs.jquery.jQuery

import scala.scalajs.js
import scalatags.generic.Frag
import scala.language.dynamics

package object util {
  object jsObj extends scala.Dynamic {
    def applyDynamicNamed[T](name: String)(fields: (String, Any)*): T =
      js.Dictionary(fields: _*).asInstanceOf[T]

    def applyDynamic[T](name: String)(fields: (String, Any)*): T =
      js.Dictionary(fields: _*).asInstanceOf[T]
  }

  def $[T](node: Element, selector: String): T = {
    var rOpt: Option[T] = None

    def recId(node: Element, id: String): Unit = {
      if (node.id == id)
        rOpt = Some(node.asInstanceOf[T])
      val childNodes = node.children
      for (i <- 0 until childNodes.length if rOpt.isEmpty)
        recId(childNodes(i), id)

    }

    def recClass(node: Element, cls: String): Unit = {
      if (Option(node.getAttribute("class")).exists(_.split(" ").contains(cls)))
        rOpt = Some(node.asInstanceOf[T])
      val childNodes = node.children
      for (i <- 0 until childNodes.length if rOpt.isEmpty)
        recId(childNodes(i), cls)
    }

    if (selector.startsWith("#")) recId(node, selector.substring(1))
    else if (selector.startsWith(".")) recClass(node, selector.substring(1))
    val Some(r) = rOpt
    r
  }

  def $[T](selector: String): T = {
    jQuery(selector)(0).asInstanceOf[T]
  }

  def $$[T](selector: String): js.Array[T] = {
    jQuery(selector).asInstanceOf[js.Array[T]]
  }

  def create[T](tagName: String): T = {
    dom.document.createElement(tagName).asInstanceOf[T]
  }

  def templateContent(frag: Frag[_, _]): DocumentFragment = {
    val template = create[HtmlTemplateElement]("template")
    template.innerHTML = frag.render.toString.trim
    template.content
  }

  def render[T](frag: Frag[_, _]): T = {
    templateContent(frag).firstChild.asInstanceOf[T]
  }

  def renders(frag: Frag[_, _]): NodeList = {
    templateContent(frag).childNodes
  }

  def eval[T](text: String): T = {
    js.eval(text).asInstanceOf[T]
  }

  def click(selector: String): Unit =
    jQuery(selector).trigger("click")

  @js.native
  trait HtmlTemplateElement extends Element {
    def content: DocumentFragment
  }

  implicit class ToDynamic(val o: js.Any) extends AnyVal {
    def dyn: js.Dynamic = o.asInstanceOf[js.Dynamic]
  }
}
