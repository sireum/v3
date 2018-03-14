package org.sireum.common

import org.scalajs.dom
import org.scalajs.dom.raw.{DocumentFragment, Element, NodeList}
import org.scalajs.jquery.jQuery
import scala.language.dynamics
import scala.scalajs.js
import scalatags.generic.Frag

object JSutil {
  object Platform extends Enumeration {
    type Type = Value
    val Unsupported, Mac, Linux, Windows, iOS, Android = Value
  }

  object Browser extends Enumeration {
    type Type = Value
    val Unsupported, Safari, Firefox, Chrome = Value
  }

  object jsObj extends scala.Dynamic {
    def applyDynamicNamed[T](name: String)(fields: (String, Any)*): T =
      js.Dictionary(fields: _*).asInstanceOf[T]

    def applyDynamic[T](name: String)(fields: (String, Any)*): T =
      js.Dictionary(fields: _*).asInstanceOf[T]
  }

  val detectedPlatform: Platform.Type = {
    val ua = dom.window.navigator.userAgent
    if (ua.contains("like Mac")) Platform.iOS
    else if (ua.contains("Mac")) Platform.Mac
    else if (ua.contains("Android")) Platform.Android
    else if (ua.contains("Linux")) Platform.Linux
    else if (ua.contains("X11")) Platform.Linux
    else if (ua.contains("Win")) Platform.Windows
    else Platform.Unsupported
  }

  val detectedBrowser: Browser.Type = {
    val ua = dom.window.navigator.userAgent
    if (ua.contains("Chrome")) Browser.Chrome
    else if (ua.contains("Safari")) Browser.Safari
    else if (ua.contains("Firefox")) Browser.Firefox
    else Browser.Unsupported
  }

  val isMobile: Boolean = detectedPlatform == Platform.iOS || detectedPlatform == Platform.Android

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
    Option(jQuery(selector)).map(_(0)).orNull.asInstanceOf[T]
  }

  def $$[T](selector: String): js.Array[T] = {
    Option(jQuery(selector)).orNull.asInstanceOf[js.Array[T]]
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

  def delay(n: Long): Unit = {
    jQuery.asInstanceOf[js.Dynamic].delay(n)
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
