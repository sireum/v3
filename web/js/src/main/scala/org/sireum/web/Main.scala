package org.sireum.web

import scala.scalajs.js.JSApp
import org.scalajs.jquery.jQuery

import scalatex._

object Main extends JSApp {
  def main(): Unit = {
    jQuery("body").append(Playground().render)
  }
}