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

package org.sireum

import scala.annotation.Annotation

package object logika {
  type B = Boolean
  type Z = BigInt

  final val T = true
  final val F = false

  final def Z(s: String): Z = BigInt(s)

  final def Z(i: Int): Z = BigInt(i)

  final implicit class Logika(val sc: StringContext) extends AnyVal {

    import scala.language.experimental.macros

    def l(args: Any*): Unit = macro _lImpl

  }

  final def _lImpl(c: scala.reflect.macros.blackbox.Context)(
    args: c.Expr[Any]*): c.Expr[Unit] =
    c.universe.reify {}

  final implicit class ZHelper(val n: Z) extends AnyVal {
    def ==(other: Int): Boolean = n == Z(other)
  }

  import scala.collection.mutable.{ListMap => LM}

  object ZS {
    final def apply(args: Z*): ZS = {
      val lm = LM[Z, Z]()
      var i = BigInt(0)
      for (e <- args) {
        lm(i) = e
        i += 1
      }
      new ZS(lm, i)
    }
  }

  final class ZS private[logika](lmArg: LM[Z, Z], lmSize: Z) {
    private[logika] val lm: LM[Z, Z] = lmArg

    val size: Z = lmSize

    def apply(index: Z): Z = {
      lm.get(index) match {
        case Some(value) => value
        case _ => throw new IndexOutOfBoundsException(index.toString)
      }
    }

    def update(index: Z, value: Z): Unit = {
      if (lm.contains(index)) lm(index) = value
      else throw new IndexOutOfBoundsException(index.toString)
    }

    def :+(value: Z): ZS = {
      val lm = LM[Z, Z]()
      for ((i, v) <- this.lm) {
        lm(i) = v
      }
      lm(BigInt(lm.size)) = value
      new ZS(lm, this.lm.size + 1)
    }

    def +:(value: Z): ZS = {
      val lm = LM[Z, Z]()
      lm(BigInt(0)) = value
      for ((i, v) <- this.lm) {
        lm(i + 1) = v
      }
      new ZS(lm, this.lm.size + 1)
    }

    override def clone: ZS = new ZS(lm.clone, size)

    override def toString: String = {
      val sb = new StringBuilder
      sb.append('[')
      if (lm.nonEmpty) {
        var i: Z = 0
        sb.append(lm(i))
        i += 1
        while (i < size) {
          sb.append(", ")
          sb.append(lm(i))
          i += 1
        }
      }
      sb.append(']')
      sb.toString
    }
  }

  final def readInt(msg: String = "Enter an integer: "): Z = {
    while (true) {
      Console.out.print(msg)
      Console.out.flush()
      val s = Console.in.readLine()
      try {
        return Z(s)
      } catch {
        case _: Throwable =>
          Console.err.println(s"Invalid integer format: $s.")
          Console.err.flush()
      }
    }
    Z(0)
  }

  final def println(as: Any*): Unit = {
    print(as: _*)
    scala.Predef.println()
  }

  final def print(as: Any*): Unit =
    for (a <- as) scala.Predef.print(a)

  final def randomInt(): Z =
    BigInt(
      numbits = new scala.util.Random().nextInt(1024),
      rnd = new scala.util.Random())

  final class helper extends Annotation

}
