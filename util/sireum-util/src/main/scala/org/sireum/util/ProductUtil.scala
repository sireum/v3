/*
Copyright (c) 2011-2015, Robby, Kansas State University
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

package org.sireum.util

object ProductUtil {
  @inline
  final def getChildren(p: Product): ISeq[AnyRef] = {
    var r = ivectorEmpty[AnyRef]
    for (e <- p.productIterator) {
      r = r :+ e.asInstanceOf[AnyRef]
    }
    r
  }

  @inline
  final def getNumOfChildren(p: Product): Int =
    p.productArity

  @inline
  final def hashCode(p: Product): Int =
    (p.productPrefix, getChildren(p)).hashCode()

  @inline
  final def equals(p1: Product, p2: Product): Boolean =
    if (p1.productArity != p2.productArity) false
    else if (p1.productPrefix != p2.productPrefix) false
    else p1.productIterator.zip(p2.productIterator).
      forall(p => p._1 == p._2)

  final def toScalaString(o: Any,
                          indent: Natural = 0,
                          sb: StringBuilder = new StringBuilder)(
                           implicit subs: CMap[String, String] = Map()): StringBuilder = {
    @inline
    def appendIndent(n: Natural): Unit = {
      var i = 0
      while (i < n) {
        sb.append("  ")
        i += 1
      }
    }

    @inline
    def appendLine(): Unit = {
      sb.append('\n')
    }

    @inline
    def appendIterator(n: Natural, it: Iterator[_]): Unit = {
      sb.append('(')

      n match {
        case 0 =>
          sb.append(')')
        case 1 =>
          toScalaString(it.next(), indent, sb)
          sb.append(')')
        case _ =>
          appendLine()
          var i = 0
          while (i < n) {
            appendIndent(indent + 1)
            toScalaString(it.next(), indent + 1, sb)
            if (i != n - 1) sb.append(',')
            appendLine()
            i += 1
          }
          appendIndent(indent)
          sb.append(')')
      }
    }

    import StringUtil._

    o match {
      case None =>
        sb.append("None")
      case Some(e) =>
        sb.append("Some(")
        appendLine()
        appendIndent(indent + 1)
        toScalaString(e, indent + 1, sb)
        appendLine()
        appendIndent(indent)
        sb.append(')')
      case o: Product =>
        val prefix = o.productPrefix
        var appendPrefix = true
        if (prefix.length > 5 && prefix.startsWith("Tuple")) {
          val c = prefix.charAt(5)
          if ('0' <= c && c <= '9')
            appendPrefix = false
        }
        if (appendPrefix)
          sb.append(subs.getOrElse(prefix, prefix))
        appendIterator(o.productArity, o.productIterator)
      case o: IVector[_] =>
        sb.append(subs.getOrElse("Vector", "Vector"))
        appendIterator(o.size, o.iterator)
      case o: IMap[_, _] =>
        sb.append(subs.getOrElse("Map", "Map"))
        appendIterator(o.size, o.iterator)
      case o: String =>
        sb.append('"')
        escape(o, sb)
        sb.append('"')
      case o: Boolean =>
        sb.append(o)
      case o: Byte =>
        sb.append(o)
      case o: Char =>
        sb.append('\'')
        escape(o, sb)
        sb.append('\'')
      case o: Short =>
        sb.append(o)
      case o: Int =>
        sb.append(o)
      case o: Long =>
        sb.append(o)
        sb.append('l')
      case o: Float =>
        sb.append(o)
      case o: Double =>
        sb.append(o)
        sb.append('d')
      case null =>
        "null"
    }
    sb
  }
}
