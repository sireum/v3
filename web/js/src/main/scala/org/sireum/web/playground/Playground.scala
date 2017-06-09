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

import ffi.monaco.KeyCode
import ffi.monaco.editor._
import ffi.monaco.languages.Languages
import org.scalajs.dom
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.html.{Anchor, Div, Input, Select}
import org.scalajs.dom.raw._
import org.sireum.web.ui.{Modal, Notification}

import scalatags.Text.all._
import scalatex.PlaygroundSpa
import org.sireum.web.util._

import scala.collection.immutable.SortedMap

object Playground {

  var editor: ffi.monaco.editor.IStandaloneCodeEditor = _

  def editorValue: String = editor.getModel().getValue(EndOfLinePreference.LF, preserveBOM = false)

  def updateView(): Unit = {
    val height = s"${dom.window.innerHeight - 90}px"
    $[Div]("#editor").style.height = height
    val output = $[Div]("#output")
    output.style.height = height
    editor.layout()
    editor.focus()
    dom.document.body.style.backgroundColor = "#8e44ad"
    output.style.backgroundColor = "#f8f3fa"
  }

  def apply(): Unit = {
    Languages.register(jsObj(id = slangId))
    Languages.setMonarchTokensProvider(slangId, eval("(function(){ " + slangModelText + "; })()"))

    Languages.register(jsObj(id = smt2Id))
    Languages.setMonarchTokensProvider(smt2Id, eval("(function(){ " + smt2ModelText + "; })()"))

    val mainDiv = render[Div](PlaygroundSpa())

    editor = Editor.create($[Div](mainDiv, "#editor"),
      jsObj[IEditorConstructionOptions](
        value = "",
        language = slangId,
        fontSize = 16
      ))

    def save(): Unit =
      Files.save(Files.selectedFilename, editor.getPosition().lineNumber.toInt,
        editor.getPosition().column.toInt, editorValue)

    editor.getModel().onDidChangeContent((e: IModelContentChangedEvent2) =>
      if (e.text.contains('\n'))
        Files.save(Files.selectedFilename, editor.getPosition().lineNumber.toInt + 1, 1, editorValue))

    editor.addCommand(KeyCode.F1, (() => ()).asInstanceOf[ICommandHandler], "")
    dom.window.onunload = (_: Event) => save()

    editor.onDidBlurEditor(() => save())
    editor.onDidBlurEditorText(() => save())

    $[Select](mainDiv, "#filename").onchange = (_: Event) => Files.load(Files.selectedFilename)

    dom.document.onreadystatechange = (_: Event) => {
      dom.document.body.appendChild(mainDiv)
      updateView()
      Files.loadFiles()
      dom.document.body.removeChild($[Div]("#welcome"))
    }
    dom.window.onresize = (_: UIEvent) => updateView()

    val runButton = $[Anchor](mainDiv, "#run")
    runButton.onclick = (_: MouseEvent) =>
      if (runButton.getAttribute("disabled") != "true")
        Notification.notify(Notification.Kind.Info, s"Slang execution coming soon.")

    $[Anchor](mainDiv, "#verify").onclick = (_: MouseEvent) => {
      if (Files.selectedFilename.endsWith(Files.smtExt))
        Z3.query(editorValue, result => $[Div](mainDiv, "#output").innerHTML = pre(result).render)
      else Notification.notify(Notification.Kind.Info, s"Slang verification coming soon.")
    }

    $[Anchor](mainDiv, "#options").onclick = (_: MouseEvent) =>
      Notification.notify(Notification.Kind.Info, s"Sireum configuration coming soon.")

    def appendSlangExtIfNoExt(filename: String): String =
      if (filename.endsWith(Files.slangExt) || filename.endsWith(Files.smtExt))
        filename
      else filename + Files.slangExt

    $[Anchor](mainDiv, "#add-file").onclick = (_: MouseEvent) =>
      Modal.textInput("New File", "Filename:", "Enter filename",
        filename => Files.isValidNewFilename(filename),
        filename => Files.newFile(appendSlangExtIfNoExt(filename), None)
      )

    $[Anchor](mainDiv, "#duplicate-file").onclick = (_: MouseEvent) =>
      Modal.textInput("Duplicate File", "Filename:", "Enter filename",
        filename => Files.isValidNewFilename(filename),
        filename => Files.newFile(appendSlangExtIfNoExt(filename), Some(editorValue))
      )

    $[Anchor](mainDiv, "#rename-file").onclick = (_: MouseEvent) =>
      Modal.textInput("Rename File", "Filename:", "Enter filename",
        filename => Files.isValidNewFilename(filename) && {
          val selected = Files.selectedFilename
          val newName = appendSlangExtIfNoExt(filename)
          selected.substring(selected.lastIndexOf('.')) == newName.substring(newName.lastIndexOf('.'))
        },
        filename => {
          val isSingle = Files.lookupFilenames()._2.length == 1
          Files.deleteFile(Files.selectedFilename)
          Files.newFile(appendSlangExtIfNoExt(filename), Some(editorValue))
          if (isSingle) Files.deleteFile(Files.untitled)
        }
      )

    $[Anchor](mainDiv, "#delete-file").onclick = (_: MouseEvent) => {
      val f = Files.selectedFilename
      Modal.confirm(s"Delete File",
        s"Are you sure you want to delete $f?",
        () => Files.deleteFile(f))
    }

    $[Anchor](mainDiv, "#clean").onclick = (_: MouseEvent) =>
      Modal.confirm(s"Erase Data",
        s"Are you sure you want to erase all data including files, etc.?",
        () => {
          GitHub.erase()
          Files.erase()
          Z3.erase()
          Files.loadFiles()
        })

    def incoming(title: String, successfulMessage: String, noChangesMessage: String,
                 fm: SortedMap[String, String]): Unit = if (fm.nonEmpty) {
      val changes = Files.incomingChanges(fm)
      if (changes.nonEmpty) {
        val tbl = table(cls := "table",
          thead(tr(th("File"), th("Change"))),
          tbody(changes.map(p => tr(th(p._1), td(p._2.toString))).toList))
        Modal.confirm(title,
          div(cls := "field", label(cls := "label")("Are you sure you want to incorporate the following incoming changes?"), tbl),
          () => {
            Files.mergeIncoming(changes, fm)
            Notification.notify(Notification.Kind.Success, successfulMessage)
          })
      } else Notification.notify(Notification.Kind.Info, noChangesMessage)
    }

    $[Anchor](mainDiv, "#download").onclick = (_: MouseEvent) =>
      Modal.textInput("Download As Zip", "Filename:", "Enter filename", _.nonEmpty,
        name => Files.saveZip(name + ".zip"))


    $[Anchor](mainDiv, "#upload").onclick = (_: MouseEvent) => click("#file-input")
    val fileInput = $[Input]("#file-input")
    fileInput.onchange = (e: Event) => Files.loadZips(e.target.dyn.files.asInstanceOf[FileList], fm =>
      incoming("Upload Zip", "Upload was successful.", "There were no changes to incorporate.", fm))


    $[Anchor](mainDiv, "#github").onclick = (_: MouseEvent) =>
      Modal.gitHubToken(
        GitHub.lookup(),
        _.endsWith(Files.slangExt),
        (_, fm) => incoming("Pull From GitHub", "Pull was successful.", "There were no changes to pull.", fm),
        (repoAuth, fm) => if (fm.nonEmpty) {
          val changes = Files.outgoingChanges(fm)
          if (changes.nonEmpty) {
            val tbl = table(cls := "table",
              thead(tr(th("File"), th("Change"))),
              tbody(changes.map(p => tr(th(p._1), td(p._2.toString))).toList))
            Modal.confirm("Push To GitHub",
              div(cls := "field", label(cls := "label")("Are you sure you want to perform the following outgoing changes?"), tbl),
              () => GitHub.pushChanges(repoAuth, changes, () => Notification.notify(Notification.Kind.Success, "Push was successful."),
                err => Notification.notify(Notification.Kind.Error, s"Push was unsuccessful (reason: $err).")))
          } else Notification.notify(Notification.Kind.Info, s"There were no changes to push.")
        })
  }

  val slangId = "slang"
  val smt2Id = "smt2"

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

  val smt2ModelText: String =
    """
      |// Difficulty: "Easy"
      |// SMT 2.0 language
      |// See http://www.rise4fun.com/z3 or http://www.smtlib.org/ for more information
      |return {
      |
      |  // Set defaultToken to invalid to see what you do not tokenize yet
      |  // defaultToken: 'invalid',
      |
      |  keywords: [
      |    'define-fun', 'define-const', 'assert', 'push', 'pop', 'assert', 'check-sat',
      |    'declare-const', 'declare-fun', 'get-model', 'get-value', 'declare-sort',
      |    'declare-datatypes', 'reset', 'eval', 'set-logic', 'help', 'get-assignment',
      |    'exit', 'get-proof', 'get-unsat-core', 'echo', 'let', 'forall', 'exists',
      |    'define-sort', 'set-option', 'get-option', 'set-info', 'check-sat-using', 'apply', 'simplify',
      |    'display', 'as', '!', 'get-info', 'declare-map', 'declare-rel', 'declare-var', 'rule',
      |    'query', 'get-user-tactics'
      |  ],
      |
      | operators: [
      |    '=', '>', '<', '<=', '>=', '=>', '+', '-', '*', '/',
      |  ],
      |
      |  builtins: [
      |    'mod', 'div', 'rem', '^', 'to_real', 'and', 'or', 'not', 'distinct',
      |    'to_int', 'is_int', '~', 'xor', 'if', 'ite', 'true', 'false', 'root-obj',
      |    'sat', 'unsat', 'const', 'map', 'store', 'select', 'sat', 'unsat',
      |    'bit1', 'bit0', 'bvneg', 'bvadd', 'bvsub', 'bvmul', 'bvsdiv', 'bvudiv', 'bvsrem',
      |    'bvurem', 'bvsmod',  'bvule', 'bvsle', 'bvuge', 'bvsge', 'bvult',
      |    'bvslt', 'bvugt', 'bvsgt', 'bvand', 'bvor', 'bvnot', 'bvxor', 'bvnand',
      |    'bvnor', 'bvxnor', 'concat', 'sign_extend', 'zero_extend', 'extract',
      |    'repeat', 'bvredor', 'bvredand', 'bvcomp', 'bvshl', 'bvlshr', 'bvashr',
      |    'rotate_left', 'rotate_right', 'get-assertions'
      |  ],
      |
      |  brackets: [
      |    ['(',')','delimiter.parenthesis'],
      |    ['{','}','delimiter.curly'],
      |    ['[',']','delimiter.square']
      |  ],
      |
      |  // we include these common regular expressions
      |  symbols:  /[=><~&|+\-*\/%@#]+/,
      |
      |  // C# style strings
      |  escapes: /\\(?:[abfnrtv\\"']|x[0-9A-Fa-f]{1,4}|u[0-9A-Fa-f]{4}|U[0-9A-Fa-f]{8})/,
      |
      |  // The main tokenizer for our languages
      |  tokenizer: {
      |    root: [
      |      // identifiers and keywords
      |      [/[a-z_][\w\-\.']*/, { cases: { '@builtins': 'predefined.identifier',
      |                                      '@keywords': 'keyword',
      |                                      '@default': 'identifier' } }],
      |      [/[A-Z][\w\-\.']*/, 'type.identifier' ],
      |      [/[:][\w\-\.']*/, 'string.identifier' ],
      |      [/[$?][\w\-\.']*/, 'constructor.identifier' ],
      |
      |      // whitespace
      |      { include: '@whitespace' },
      |
      |      // delimiters and operators
      |      [/[()\[\]]/, '@brackets'],
      |      [/@symbols/, { cases: { '@operators': 'predefined.operator',
      |                              '@default'  : 'operator' } } ],
      |
      |
      |      // numbers
      |      [/\d*\.\d+([eE][\-+]?\d+)?/, 'number.float'],
      |      [/0[xX][0-9a-fA-F]+/, 'number.hex'],
      |      [/#[xX][0-9a-fA-F]+/, 'number.hex'],
      |      [/#b[0-1]+/, 'number.binary'],
      |      [/\d+/, 'number'],
      |
      |      // delimiter: after number because of .\d floats
      |      [/[,.]/, 'delimiter'],
      |
      |      // strings
      |      [/"([^"\\]|\\.)*$/, 'string.invalid' ],  // non-teminated string
      |      [/"/,  { token: 'string.quote', bracket: '@open', next: '@string' } ],
      |
      |      // user values
      |      [/\{/, { token: 'string.curly', bracket: '@open', next: '@uservalue' } ],
      |    ],
      |
      |    uservalue: [
      |      [/[^\\\}]+/, 'string' ],
      |      [/\}/,       { token: 'string.curly', bracket: '@close', next: '@pop' } ],
      |      [/\\\}/,     'string.escape'],
      |      [/./,        'string']  // recover
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
      |      [/;.*$/,    'comment'],
      |    ],
      |  },
      |};
    """.stripMargin
}
