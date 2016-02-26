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

package org.sireum.logika.tipe

import org.sireum.util._

object Tipe {
  type Seq[T] = IVector[T]

  final def emptySeq[T] = ivectorEmpty[T]

  final def seq[T](es: T*) = ivector(es: _*)

  final def seq[T](es: Iterable[T]) = es.toVector
}

sealed trait Tipe

case object UnitTipe extends Tipe {
  override def toString = "Unit"
}

case object B extends Tipe

sealed trait NumberTipe extends Tipe

sealed trait IntegralTipe extends NumberTipe

sealed trait SignedIntegralTipe extends IntegralTipe

sealed trait UnsignedIntegralTipe extends IntegralTipe

sealed trait ModuloIntegralTipe extends IntegralTipe

case object Z extends SignedIntegralTipe

case object Z8 extends SignedIntegralTipe

case object Z16 extends SignedIntegralTipe

case object Z32 extends SignedIntegralTipe

case object Z64 extends SignedIntegralTipe

case object N extends UnsignedIntegralTipe

case object N8 extends UnsignedIntegralTipe

case object N16 extends UnsignedIntegralTipe

case object N32 extends UnsignedIntegralTipe

case object N64 extends UnsignedIntegralTipe

case object S8 extends SignedIntegralTipe with ModuloIntegralTipe

case object S16 extends SignedIntegralTipe with ModuloIntegralTipe

case object S32 extends SignedIntegralTipe with ModuloIntegralTipe

case object S64 extends SignedIntegralTipe with ModuloIntegralTipe

case object U8 extends UnsignedIntegralTipe with ModuloIntegralTipe

case object U16 extends UnsignedIntegralTipe with ModuloIntegralTipe

case object U32 extends UnsignedIntegralTipe with ModuloIntegralTipe

case object U64 extends UnsignedIntegralTipe with ModuloIntegralTipe

case object R extends NumberTipe

sealed trait FloatingPointTipe extends NumberTipe

case object F32 extends FloatingPointTipe

case object F64 extends FloatingPointTipe

sealed trait Fn extends Tipe {
  def params: Tipe.Seq[Tipe]

  def result: Tipe
}

sealed trait MSeq extends Fn

case object BS extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = B
}

case object ZS extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = Z
}

case object Z8S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = Z8
}

case object Z16S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = Z16
}

case object Z32S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = Z32
}

case object Z64S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = Z64
}

case object NS extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = N
}

case object N8S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = N8
}

case object N16S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = N16
}

case object N32S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = N32
}

case object N64S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = N64
}

case object S8S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = S8
}

case object S16S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = S8
}

case object S32S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = S8
}

case object S64S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = S8
}

case object U8S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = U8
}

case object U16S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = U16
}

case object U32S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = U32
}

case object U64S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = U8
}

case object RS extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = R
}

case object F32S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = F32
}

case object F64S extends MSeq {
  final val params = Tipe.seq(Z)
  final val result = F64
}

final case class FunTipe(params: Tipe.Seq[Tipe], result: Tipe)
  extends Fn {
  override def toString: String = {
    val sb = new StringBuilder
    if (params.size == 1) {
      sb.append(params.head)
      sb.append(" => ")
    } else {
      sb.append('(')
      sb.append(") => ")
    }
    sb.append(result)
    sb.toString
  }
}