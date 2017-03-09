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

package org.sireum

import scala.annotation.StaticAnnotation

package object logika {

  type B = _B

  val T: B = ???

  val F: B = ???

  type Z = _Z

  type Z8 = _Z8

  type Z16 = _Z16

  type Z32 = _Z32

  type Z64 = _Z64

  type N = _N

  type N8 = _N8

  type N16 = _N16

  type N32 = _N32

  type N64 = _N64

  type S8 = _S8

  type S16 = _S16

  type S32 = _S32

  type S64 = _S64

  type U8 = _U8

  type U16 = _U16

  type U32 = _U32

  type U64 = _U64

  type F32 = _F32

  type F64 = _F64

  type R = _R

  def readInt(msg: String = ""): Z = ???

  def randomInt(): Z = ???

  def println(arg: Any*): Unit = ???

  def print(arg: Any*): Unit = ???


  trait MS[I, E] extends _S[I, E, MS[I, E]]

  object MS {
    def apply[I <: _IntegralNumber[I], E](elements: E*): MS[I, E] = ???

    def create[I <: _IntegralNumber[I], E](size: I, default: E): MS[I, E] =
      l"""{ requires size ≥ 0
            ensures  result.size == size
                     ∀i: (0 ..< result.size) result(i) == default }""" {
        ???
      }
  }


  trait IS[I, E] extends _S[I, E, IS[I, E]]

  object IS {
    @pure def apply[I <: _IntegralNumber[I], E](elements: E*): IS[I, E] = ???

    @pure def create[I <: _IntegralNumber[I], E](size: I, default: E): IS[I, E] =
      l"""{ requires size ≥ 0
            ensures  result.size == size
                     ∀i: (0 ..< result.size) result(i) == default }""" {
        ???
      }
  }


  type ZS = MS[Z, Z]

  object ZS {
    @pure def apply(elements: Z*): ZS = ???

    @pure def create(size: Z, default: Z): ZS =
      l"""{ requires size ≥ 0
            ensures  result.size == size
                     ∀i: (0 ..< result.size) result(i) == default }""" {
        ???
      }
  }

  final class native extends StaticAnnotation

  final class pure extends StaticAnnotation

  final implicit class _Logika(val sc: StringContext) extends AnyVal {
    def z(args: Any*): Z = ???

    def z8(args: Any*): Z8 = ???

    def z16(args: Any*): Z16 = ???

    def z32(args: Any*): Z32 = ???

    def z64(args: Any*): Z64 = ???

    def n(args: Any*): N = ???

    def n8(args: Any*): N8 = ???

    def n16(args: Any*): N16 = ???

    def n32(args: Any*): N32 = ???

    def n64(args: Any*): N64 = ???

    def s8(args: Any*): S8 = ???

    def s16(args: Any*): S16 = ???

    def s32(args: Any*): S32 = ???

    def s64(args: Any*): S64 = ???

    def u8(args: Any*): U8 = ???

    def u16(args: Any*): U16 = ???

    def u32(args: Any*): U32 = ???

    def u64(args: Any*): U64 = ???

    def f32(args: Any*): F32 = ???

    def f64(args: Any*): F64 = ???

    def r(args: Any*): R = ???

    def l[T](args: Any*): Any => T = ???

    def c[T](args: Any*): T = ???
  }

}
