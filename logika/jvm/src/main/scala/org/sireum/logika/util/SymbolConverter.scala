/*
 Copyright (c) 2016, Robby, Kansas State University
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

package org.sireum.logika.util

import org.antlr.v4.runtime.{CharStreams, Token}
import org.sireum.logika.parser.Antlr4LogikaLexer
import org.sireum.util._

object SymbolConverter {
  def toASCII(input: String): String = {
    val sb = new StringBuilder
    var i = 0
    val tks = tokens(input)
    val len = tks.size

    def isPrevWhitespace: Boolean =
      if (i - 1 >= 0) tks(i - 1).getChannel == 2 else true

    def isNextWhitespace: Boolean =
      if (i + 1 < len) tks(i + 1).getChannel == 2 else true

    def isJust: Boolean = {
      var j = i + 1
      while (j < len && tks(j).getChannel == 2) j += 1
      val isId = j < len && tks(j).getType == Antlr4LogikaLexer.ID
      j += 1
      while (j < len && tks(j).getChannel == 2) j += 1
      j < len && isId && tks(j).getType == Antlr4LogikaLexer.NUM
    }

    def appendWs(c: Char): Unit = {
      if (!isPrevWhitespace) sb.append(' ')
      sb.append(c)
      if (!isNextWhitespace) sb.append(' ')
    }

    def appendJs(c: Char): Unit = {
      if (!isPrevWhitespace) sb.append(' ')
      sb.append(c)
      if (!isJust && !isNextWhitespace) sb.append(' ')
    }

    var inProof = false
    while (i < len) {
      val t = tks(i)
      t.getText.charAt(0) match {
        case '⊢' => sb.append("|-")
        case '∧' => sb.append('^')
        case '∨' => appendJs('V')
        case '¬' => sb.append('~')
        case '→' => sb.append("->")
        case '∀' => appendJs('A')
        case '∃' => appendJs('E')
        case '⊤' => appendWs('T')
        case '⊥' => sb.append("_|_")
        case '≤' => sb.append("<=")
        case '≥' => sb.append(">=")
        case '≠' => sb.append("!=")
        case _ =>
          t.getText match {
            case s@"l\"\"\"" => inProof = true; sb.append(s)
            case s@"\"\"\"" => inProof = false; sb.append(s)
            case "==" if inProof => sb.append('=')
            case s => sb.append(s)
          }
      }
      i += 1
    }
    adJust(sb.toString)
  }

  def toUnicode(input: String): String = {
    val sb = new StringBuilder
    var inProof = false
    for (t <- tokens(input)) t.getText match {
      case s@"l\"\"\"" => inProof = true; sb.append(s)
      case s@"\"\"\"" => inProof = false; sb.append(s)
      case "|-" => sb.append('⊢')
      case "^" | "and" => sb.append('∧')
      case "V" | "or" => sb.append('∨')
      case "~" | "not" => sb.append('¬')
      case "->" | "implies" => sb.append('→')
      case "A" | "all" | "forall" => sb.append('∀')
      case "E" | "some" | "exists" => sb.append('∃')
      case "andi" => sb.append("∧i")
      case "ande1" => sb.append("∧e1")
      case "ande2" => sb.append("∧e2")
      case "ori1" | "Vi1" => sb.append("∨i1")
      case "ori2" | "Vi2" => sb.append("∨i2")
      case "ore" | "Ve" => sb.append("∨e")
      case "impliesi" => sb.append("→i")
      case "impliese" => sb.append("→e")
      case "noti" | "negi" => sb.append("¬i")
      case "note" | "nege" => sb.append("¬e")
      case "bottome" | "falsee" => sb.append("⊥e")
      case "Ai" | "alli" | "foralli" => sb.append("∀i")
      case "Ae" | "alle" | "foralle" => sb.append("∀e")
      case "Ei" | "somei" | "existsi" => sb.append("∃i")
      case "Ee" | "somee" | "existse" => sb.append("∃e")
      case "_|_" => sb.append('⊥')
      case s =>
        if (inProof) {
          s match {
            case "==" => sb.append('=')
            case "<=" => sb.append('≤')
            case ">=" => sb.append('≥')
            case "!=" => sb.append('≠')
            case "!" => sb.append('¬')
            case "&" => sb.append('∧')
            case "|" => sb.append('∨')
            case _ => sb.append(s)
          }
        } else sb.append(s)
    }
    adJust(sb.toString)
  }

  private def space(n: Natural): String = {
    val sb = new StringBuilder
    for (_ <- 0 until n) {
      sb.append(' ')
    }
    sb.toString
  }

  private def insert(s: String, i: Int, sub: String) =
    new StringBuilder(s).insert(i, sub).toString

  private def adJust(input: String): String = {
    val tks = tokens(input.toString)
    var i = 0
    val len = tks.size
    var maxJustColumn = 0
    while (i < len) {
      val column = tks(i).getCharPositionInLine
      if (isJust(i, tks) && maxJustColumn < column) {
        maxJustColumn = column
      }
      i += 1
    }
    val lines = input.split('\n')
    i = 0
    while (i < len) {
      if (isJust(i, tks)) {
        val line = tks(i).getLine
        val column = tks(i).getCharPositionInLine
        if (maxJustColumn != column) {
          val l = lines(line - 1)
          lines(line - 1) = insert(l, column, space(maxJustColumn - column))
        }
      }
      i += 1
    }
    lines.mkString("\n")
  }

  private def isJust(i: Natural, tks: CSeq[Token]): Boolean = {
    val len = tks.size
    tks(i).getText match {
      case "premise" | "assume" | "andi" | "ande1" | "ande2" |
           "ori1" | "Vi1" | "ori2" | "Vi2" | "ore" | "Ve" |
           "impliese" | "impliese" | "noti" | "negi" | "note" | "nege" |
           "bottome" | "falsee" | "pbc" | "subst1" | "subst2" | "algebra" |
           "foralli" | "alli" | "Ai" | "foralle" | "alle" | "Ae" |
           "existsi" | "somei" | "Ei" | "existse" | "somee" | "Ee" |
           "auto" =>
        true
      case "invariant" =>
        var j = i + 1
        while (j < len && tks(j).getChannel == 2) j += 1
        val isNum = j < len && tks(j).getType == Antlr4LogikaLexer.NUM
        while (j < len && tks(j).getChannel == 2) j += 1
        j < len && isNum && tks(j).getType == Antlr4LogikaLexer.NL
      case "fact" =>
        var j = i + 1
        while (j < len && tks(j).getChannel == 2) j += 1
        val isId = j < len && tks(j).getType == Antlr4LogikaLexer.ID
        while (j < len && tks(j).getChannel == 2) j += 1
        j < len && isId && tks(j).getType == Antlr4LogikaLexer.NL
      case "&" | "∧" | "^" | "|" | "∨" | "->" | "→" | "!" | "~" | "¬" |
           "_|_" | "⊥" | "∀" | "∃" =>
        var j = i + 1
        while (j < len && tks(j).getChannel == 2) j += 1
        val isId = j < len && tks(j).getType == Antlr4LogikaLexer.ID
        j += 1
        while (j < len && tks(j).getChannel == 2) j += 1
        j < len && isId && tks(j).getType == Antlr4LogikaLexer.NUM
      case _ => false
    }
  }

  private def tokens(input: String): CSeq[Token] = {
    import scala.collection.JavaConverters._
    val inputStream = CharStreams.fromString(input)
    val lexer = new Antlr4LogikaLexer(inputStream)
    lexer.getAllTokens.asScala
  }

}
