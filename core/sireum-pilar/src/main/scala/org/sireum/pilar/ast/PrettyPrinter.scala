/*
Copyright (c) 2015, Robby, Kansas State University
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

package org.sireum.pilar.ast

import org.sireum.pilar.parser.FastParser
import org.sireum.util._

final class PrettyPrinter(sb: StringBuilder) {
  private type SB = StringBuilder

  def print(m: Model, indent: Natural = 0): Unit = {
    implicit val _indent = indent

    for (a <- m.annotations) {
      printIndent(indent)
      print(a)
      println()
    }
    for (e <- m.elements) {
      println()
      printIndent(indent)
      print(m)
    }
  }

  def print(a: Annotation): Unit = {
    sb.append('@')
    print(a.id)
    print(a.raw)
  }

  def print(id: Id): Unit = {
    import FastParser._
    val s = id.value
    if (isOpIDFirstChar(s.charAt(0)) || isSimpleID(s)._1) {
      sb.append(s)
    } else {
      sb.append('`')
      sb.append(s)
      sb.append('`')
    }
  }

  def print(raw: Raw): Unit = {
    val s = raw.value
    if (s.forall(isSimpleLITTrailingChar)) {
      sb.append('\'')
      sb.append(s)
    } else {
      sb.append('"')
      sb.append(
        s.replaceAll("\\", """\\\\""").
          replaceAll("\"", """\\""""))
      sb.append('"')
    }
  }

  def print(e: ModelElement, indent: Natural): Unit =
    e match {
      case e: GlobalVarDecl => print(e, indent)
      case e: ProcedureDecl => print(e, indent)
    }

  def print(gvd: GlobalVarDecl, indent: Natural): Unit = {
    sb.append("global var ")
    sb.append(gvd.id)
    if (gvd.annotations.size > 1) {
      for (a <- gvd.annotations) {
        println()
        printIndent(indent + 2)
        sb.append(' ')
        print(a)
      }
    } else {
      for (a <- gvd.annotations) {
        sb.append(' ')
        print(a)
      }
    }
    sb.append(';')
    println()
  }

  def print(pd: ProcedureDecl, indent: Natural): Unit = {
    val pos = sb.size
    sb.append("def ")
    print(pd.id)
    sb.append('(')
    pd.params.size match {
      case 0 => sb.append(')')
      case _ =>
        val paramIndent = indent + (sb.size - pos) / 2 + 1
        println()
        printIndent(paramIndent)
        print(pd.params.head, paramIndent)

        for (p <- pd.params.tail) {
          sb.append(',')
          println()
          printIndent(paramIndent)
          print(p, paramIndent)
        }
        sb.append(')')
    }

    for (a <- pd.annotations) {
      println()
      printIndent(indent + 2)
      print(a)
    }

    if (pd.bodyOpt.isEmpty) {
      sb.append(';')
      return
    }
    val body = pd.bodyOpt.get

    if (pd.annotations.nonEmpty) {
      println()
      printIndent(indent)
      sb.append('{')
    } else {
      sb.append(" {")
    }

    println()
    printIndent(indent + 1)
    sb.append("var")

    for (local <- body.locals) {
      println()
      printIndent(indent + 2)
      print(local, indent + 2)
    }

    println()

    for (l <- body.locations) {
      println()
      printIndent(indent + 1)
      print(l, indent + 1)
    }

    println()
    printIndent(indent)
    sb.append('}')
    println()
  }

  @inline
  def print(p: ParamDecl, indent: Natural): Unit = {
    sb.append(p.id)
    if (p.annotations.size > 1) {
      for (a <- p.annotations) {
        println()
        printIndent(indent + 1)
        print(a)
      }
    } else {
      for (a <- p.annotations) {
        sb.append(' ')
        print(a)
      }
    }
  }

  @inline
  def print(lvd: LocalVarDecl, indent: Natural): Unit = {
    sb.append(lvd.id)
    if (lvd.annotations.size > 1) {
      for (a <- lvd.annotations) {
        println()
        printIndent(indent + 1)
        print(a)
      }
    } else {
      for (a <- lvd.annotations) {
        sb.append(' ')
        print(a)
      }
    }
    sb.append(';')
  }

  @inline
  def print(l: Location, indent: Natural): Unit = {
    sb.append('#')
    print(l.label)

    for (a <- l.annotations) {
      println()
      printIndent(indent + 2)
      print(a)
    }

    println()
    l match {
      case CallLocation(_, lhsOpt, id, args, target, _) =>
        printIndent(indent + 1)
        sb.append("call ")
        if (lhsOpt.isDefined) {
          print(lhsOpt.get)
          sb.append(" := ")
        }
        print(id)
        print(args)
        sb.append(" goto ")
        print(target)
        sb.append(';')
      case BlockLocation(_, actions, jump, _) =>
        for (a <- actions) {
          printIndent(indent + 1)
          print(a, indent + 3)
          println()
        }
        printIndent(indent + 1)
        print(jump, indent)
    }
  }

  @inline
  def print(a: Action, indent: Natural): Unit = {
    a match {
      case AssignAction(lhs, rhs, _) =>
        print(lhs)
        sb.append(" := ")
        print(rhs)
      case AssertAction(exp, _) =>
        sb.append("assert ")
        print(exp)
      case AssumeAction(exp, _) =>
        sb.append("assume ")
        print(exp)
      case ExtAction(id, args, _) =>
        sb.append("ext ")
        print(id)
        print(args)
    }
    for (a <- a.annotations) {
      println()
      printIndent(indent)
      print(a)
    }
    sb.append(';')
  }

  @inline
  def print(j: Jump, indent: Natural): Unit = {
    j match {
      case GotoJump(target, _) =>
        sb.append("goto ")
        print(target)
      case IfJump(exp, tTarget, fTarget, _) =>
        sb.append("if ")
        print(exp)
        sb.append(" then ")
        print(tTarget)
        sb.append(" else ")
        print(fTarget)
      case ReturnJump(expOpt, _) =>
        sb.append("return ")
        expOpt.foreach(print)
      case SwitchJump(exp, cases, _) =>
        sb.append("switch ")
        print(exp)
        for (SwitchCase(expOpt, target) <- cases) {
          println()
          printIndent(indent)
          expOpt match {
            case Some(e) =>
              sb.append("case ")
              print(e)
              sb.append(": ")
              print(target)
            case _ =>
              sb.append("default: ")
              print(target)
          }
        }
      case j: ExtJump =>
        sb.append("jext ")
        print(j.id)
        print(j.args)
    }
    for (a <- j.annotations) {
      println()
      printIndent(indent + 2)
      print(a)
    }
    sb.append(';')
  }

  @inline
  def print(es: ISeq[Exp]): Unit = {
    sb.append('(')
    if (es.nonEmpty) {
      print(es.head)

      for (e <- es.tail) {
        sb.append(", ")
        print(e)
      }
    }
    sb.append(')')
  }

  @inline
  def print(e: Exp): Unit = e match {
    case LiteralExp(id, raw) =>
      print(id)
      print(raw)
    case IdExp(id) =>
      print(id)
    case TupleExp(es, annotations) =>
      print(es)
      for (a <- annotations) {
        sb.append(' ')
        print(a)
      }
    case InfixExp(left, op, right, rest) =>
      print(left)
      sb.append(' ')
      print(op)
      sb.append(' ')
      print(right)
      for ((op2, right2) <- rest) {
        print(op2)
        sb.append(' ')
        print(right2)
      }
    case ExtExp(exp, args) =>
  }

  @inline
  private def printIndent(indent: Natural): Unit = {
    var i = 0
    while (i < indent) {
      sb.append("  ")
      i += 1
    }
  }

  @inline
  private def println(): Unit = {
    sb.append('\n')
  }

  @inline
  private def isSimpleLITTrailingChar(c: Char) =
    FastParser.isSimpleLITTrailingChar(c)

  @inline
  private def isSimpleID(s: String) = {
    import FastParser._
    peekOneStar(s.charAt, 0, isJavaLetter, isJavaDigitOrLetter)
  }
}
