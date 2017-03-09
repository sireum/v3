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

package org.sireum.logika

trait _B {
  def unary_!(): B

  def &(other: B): B

  def |(other: B): B

  def |^(other: B): B
}

trait _Number[N <: _Number[N]] {
  def unary_- : N

  def +(other: N): N

  def -(other: N): N

  def *(other: N): N

  def /(other: N): N

  def %(other: N): N

  def >(other: N): N

  def >=(other: N): N

  def <(other: N): N

  def <=(other: N): N
}

trait _Natural

trait _IntegralNumber[N <: _IntegralNumber[N]] extends _Number[N] {
  def ==(other: N): B

  def !=(other: N): B
}

trait _ModuloIntegralNumber[N <: _ModuloIntegralNumber[N]] extends _IntegralNumber[N] {
  def unary_~(): N

  def &(other: N): N

  def |(other: N): N

  def ^|(other: N): N

  def <<(distance: N): N

  def >>>(distance: N): N
}

trait _FloatingPointNumber[N <: _FloatingPointNumber[N]] extends _Number[N]

trait _Z extends _IntegralNumber[Z]

trait _Z8 extends _ModuloIntegralNumber[Z8]

trait _Z16 extends _ModuloIntegralNumber[Z16]

trait _Z32 extends _ModuloIntegralNumber[Z32]

trait _Z64 extends _ModuloIntegralNumber[Z64]

trait _N extends _IntegralNumber[N] with _Natural

trait _N8 extends _ModuloIntegralNumber[N8] with _Natural

trait _N16 extends _ModuloIntegralNumber[N16] with _Natural

trait _N32 extends _ModuloIntegralNumber[N32] with _Natural

trait _N64 extends _ModuloIntegralNumber[N64] with _Natural

trait _S8 extends _ModuloIntegralNumber[S8]

trait _S16 extends _ModuloIntegralNumber[S16]

trait _S32 extends _ModuloIntegralNumber[S32]

trait _S64 extends _ModuloIntegralNumber[S64]

trait _U8 extends _ModuloIntegralNumber[U8] with _Natural

trait _U16 extends _ModuloIntegralNumber[U16] with _Natural

trait _U32 extends _ModuloIntegralNumber[U32] with _Natural

trait _U64 extends _ModuloIntegralNumber[U64] with _Natural

trait _F32 extends _FloatingPointNumber[F32]

trait _F64 extends _FloatingPointNumber[F64]

trait _R extends _Number[R]

trait _S[I, E, S <: _S[I, E, S]] {
  def ==(other: S): B

  def !=(other: S): B

  def :+(e: E): S

  def +:(e: E): S

  def ++(other: S): S
}