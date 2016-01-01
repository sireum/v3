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

package org.sireum.util

object StringUtil {

  @inline
  final def escape(c: Char,
                   sb: StringBuilder): StringBuilder = {
    c match {
      case '\b' => sb.append("\\b")
      case '\t' => sb.append("\\t")
      case '\n' => sb.append("\\n")
      case '\f' => sb.append("\\f")
      case '\r' => sb.append("\\r")
      case '\"' => sb.append("\\\"")
      case '\'' => sb.append("\\\'")
      case '\\' => sb.append("\\\\")
      case _ =>
        if ((0 <= c && c < 32) || (c > 255)) {
          sb.append("\\u")
          val s = c.toInt.toHexString
          var i = 0
          val n = 4 - s.length
          while (i < n) {
            sb.append('0')
            i += 1
          }
          sb.append(s)
        } else {
          sb.append(c)
        }
    }
    sb
  }

  @inline
  final def escape(s: String,
                   sb: StringBuilder = new StringBuilder): StringBuilder = {
    for (c <- s) escape(c, sb)
    sb
  }
}
