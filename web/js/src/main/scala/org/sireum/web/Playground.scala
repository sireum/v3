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

import monaco.editor.IEditorConstructionOptions
import org.scalajs.dom
import org.scalajs.dom.html.Div
import org.scalajs.dom.raw.{Event, UIEvent}
import org.sireum.web.util._

import scalatags.Text.all._
import scala.scalajs.js
import scalatex.PlaygroundSpa

object Playground {

  def filename(name: String): RawFrag =
    raw(s"$name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")

  def updateView(editor: monaco.editor.IEditor): Unit = {
    val height = s"${dom.window.innerHeight - 90}px"
    $[Div]("#editor").style.height = height
    val output = $[Div]("#output")
    output.style.height = height
    editor.layout()
    editor.focus()
    dom.document.body.style.backgroundColor = "#8e44ad"
    output.style.backgroundColor = "lightgrey"
  }

  def apply(): Unit = {
    dom.document.body.appendChild(render(PlaygroundSpa()))

    monaco.languages.Languages.register(jsObj(id = slangId ))
    val langModel = monaco.editor.Editor.createModel(slangModelText, "javascript")
    monaco.languages.Languages.setMonarchTokensProvider(slangId, eval("(function(){ " + langModel.getValue() + "; })()"))

    js.Dynamic.literal
    val editor = monaco.editor.Editor.create($[Div]("#editor"),
      jsObj[IEditorConstructionOptions](
        value = "",
        language = slangId,
        fontSize = 16
      ))

    dom.document.onreadystatechange = (_: Event) => updateView(editor)
    dom.window.onresize = (_: UIEvent) => updateView(editor)

//    dom.window.setTimeout(() => {
//      val filenameSelection = $[Select]("#filename")
//      val innerHtml = filenameSelection.options.map { o => o.selected = false; o.innerHTML }.mkString("\n")
//      val newOption = option(selected := true, filename("Very Long Filename Here")).render
//      filenameSelection.innerHTML = s"$innerHtml\n$newOption"
//    }, 2000)
  }

  val slangId = "slang"

  val slangModelText: String =
    """return {
      |      keywords: [
      |        'case', 'class', 'def', 'do', 'else', 'extends', 'false',
      |        'for', 'if', 'import', 'match', 'object',
      |        'package', 'return', 'sealed', 'this', 'trait',
      |        'true', 'type', 'val', 'var', 'while', 'with', 'yield',
      |        'T', 'F'
      |      ],
      |
      |      typeKeywords: [
      |        'B',
      |        'Z', 'Z8', 'Z16', 'Z32', 'Z64',
      |        'N', 'N8', 'N16', 'N32', 'N64',
      |        'S8', 'S16', 'S32', 'S64',
      |        'U8', 'U16', 'U32', 'U64',
      |        'F32', 'F64', 'R',
      |        'IS', 'MS',
      |        'MSZ', 'MSZ8', 'MSZ16', 'MSZ32', 'MSZ64',
      |        'MSN', 'MSN8', 'MSN16', 'MSN32', 'MSN64',
      |        'MSS8', 'MSS16', 'MSS32', 'MSS64',
      |        'MSU8', 'MSU16', 'MSU32', 'MSU64',
      |        'ISZ', 'ISZ8', 'ISZ16', 'ISZ32', 'ISZ64',
      |        'ISN', 'ISN8', 'ISN16', 'ISN32', 'ISN64',
      |        'ISS8', 'ISS16', 'ISS32', 'ISS64',
      |        'ISU8', 'ISU16', 'ISU32', 'ISU64',
      |        'Unit'
      |      ],
      |
      |      operators: [
      |        '=', '>', '<', '!', '~', ':',
      |        '==', '<=', '>=', '!=',
      |        '+', '-', '*', '/', '&', '|', '|^', '%', '<<',
      |        '>>', '>>>'
      |      ],
      |
      |  symbols:  /[=><!~?:&|+\-*\/\^%]+/,
      |
      |  escapes: /\\(?:[abfnrtv\\"']|x[0-9A-Fa-f]{1,4}|u[0-9A-Fa-f]{4}|U[0-9A-Fa-f]{8})/,
      |
      |  tokenizer: {
      |    root: [
      |      // identifiers and keywords
      |      [/[a-z_$][\w$]*/, { cases: { '@typeKeywords': 'keyword',
      |                                   '@keywords': 'keyword',
      |                                   '@default': 'identifier' } }],
      |      [/[A-Z][\w\$]*/, 'type.identifier' ],  // to show class names nicely
      |
      |      // whitespace
      |      { include: '@whitespace' },
      |
      |      // delimiters and operators
      |      [/[{}()\[\]]/, '@brackets'],
      |      [/[<>](?!@symbols)/, '@brackets'],
      |      [/@symbols/, { cases: { '@operators': 'operator',
      |                              '@default'  : '' } } ],
      |
      |      // @ annotations.
      |      [/@\s*[a-zA-Z_\$][\w\$]*/, { token: 'annotation' }],
      |
      |      // numbers
      |      [/\d*\.\d+([eE][\-+]?\d+)?/, 'number.float'],
      |      [/0[xX][0-9a-fA-F]+/, 'number.hex'],
      |      [/\d+/, 'number'],
      |
      |      // delimiter: after number because of .\d floats
      |      [/[;,.]/, 'delimiter'],
      |
      |      // strings
      |      [/"([^"\\]|\\.)*$/, 'string.invalid' ],  // non-teminated string
      |      [/"/,  { token: 'string.quote', bracket: '@open', next: '@string' } ],
      |
      |      // characters
      |      [/'[^\\']'/, 'string'],
      |      [/(')(@escapes)(')/, ['string','string.escape','string']],
      |      [/'/, 'string.invalid']
      |    ],
      |
      |    comment: [
      |      [/[^\/*]+/, 'comment' ],
      |      [/\/\*/,    'comment', '@push' ],    // nested comment
      |      ["\\*/",    'comment', '@pop'  ],
      |      [/[\/*]/,   'comment' ]
      |    ],
      |
      |    string: [
      |      [/[^\\"]+/,  'string'],
      |      [/@escapes/, 'string.escape'],
      |      [/\\./,      'string.escape.invalid'],
      |      [/"/,        { token: 'string.quote', bracket: '@close', next: '@pop' } ]
      |    ],
      |
      |    whitespace: [
      |      [/[ \t\r\n]+/, 'white'],
      |      [/\/\*/,       'comment', '@comment' ],
      |      [/\/\/.*$/,    'comment'],
      |    ],
      |  },
      |};
    """.stripMargin.trim
}
