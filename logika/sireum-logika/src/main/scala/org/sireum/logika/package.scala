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

package org.sireum

package object logika {
  type B = Boolean
  type Z = BigInt
  type ZS = Seq[Z]

  final val T = true
  final val F = false

  final implicit class Logika(val sc: StringContext) extends AnyVal {
    def logika(args: Any*): Unit = {}

    def l(args: Any*): Unit = logika(args: _*)
  }

  final implicit class ZLiteral(val sc: StringContext) extends AnyVal {
    def Z(args: Any*): Z = {
      assert(args.isEmpty)
      val strings = sc.parts.iterator
      val buf = new StringBuilder(strings.next)
      while (strings.hasNext) {
        buf.append(strings.next)
      }
      val text = buf.toString
      BigInt(text)
    }
  }

  final implicit class ZHelper(val n: Z) extends AnyVal {
    def ==(other: Int): Boolean = n == BigInt(other)
  }

  final def ZS(zs: Z*): ZS = Seq(zs: _*)

  final def readInt(msg: String = "Enter an integer: "): Z = {
    Console.out.print(msg)
    Console.out.flush()
    BigInt(Console.in.readLine())
  }
}
