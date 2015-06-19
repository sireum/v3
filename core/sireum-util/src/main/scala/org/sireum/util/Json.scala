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

import upickle.Js

object Json {

  type To = CaseClass --\ ISeq[(String, Js.Value)]
  type From = Iterable[Js.Value] --\ CaseClass

  trait CaseClassConverter {
    def to: To

    def from: From
  }

  @inline
  final def fromAnyVal(v: AnyVal): Js.Value =
    v match {
      case true => Js.True
      case false => Js.False
      case v: Byte => Js.Num(v)
      case v: Short => Js.Num(v)
      case v: Char => Js.Str(v.toString)
      case v: Int => Js.Num(v)
      case v: Long => Js.Num(v)
      case v: Float => Js.Num(v)
      case v: Double => Js.Num(v)
    }

  @inline
  final def fromStr(s: String): Js.Str = Js.Str(s)

  @inline
  final def fromSeq[T](c: CSeq[T], f: T => Js.Value): Js.Arr =
    Js.Arr(c.map(f): _*)

  @inline
  final def fromOption[T](c: Option[T], f: T => Js.Value): Js.Arr =
    Js.Arr(c.map(f).toSeq: _*)

  @inline
  final def toVector[T](v: Js.Value, f: Js.Value => T): Vector[T] =
    v match {
      case a: Js.Arr =>
        var r = ivectorEmpty[T]
        for (v <- a.value) {
          r = r :+ f(v)
        }
        r
      case _ => sys.error("Unexpected Js.Value for a sequence: " + v)
    }

  @inline
  final def toOption[T](v: Js.Value, f: Js.Value => T): Option[T] =
    v match {
      case a: Js.Arr =>
        a.value match {
          case Seq(value) => Some(f(value))
          case _ => None
        }
      case _ => sys.error("Unexpected Js.Value for an option: " + v)
    }

  @inline
  final def toBoolean(v: Js.Value): Boolean =
    v match {
      case Js.True => true
      case Js.False => false
      case _ => sys.error("Unexpected Js.Value for a Boolean: " + v)
    }

  @inline
  final def toByte(v: Js.Value): Byte =
    v match {
      case Js.Num(d) => d.toByte
      case _ => sys.error("Unexpected Js.Value for an Int: " + v)
    }

  @inline
  final def toChar(v: Js.Value): Int =
    v match {
      case Js.Str(s) => s.charAt(0)
      case _ => sys.error("Unexpected Js.Value for an Int: " + v)
    }

  @inline
  final def toShort(v: Js.Value): Short =
    v match {
      case Js.Num(d) => d.toShort
      case _ => sys.error("Unexpected Js.Value for an Int: " + v)
    }

  @inline
  final def toInt(v: Js.Value): Int =
    v match {
      case Js.Num(d) => d.toInt
      case _ => sys.error("Unexpected Js.Value for an Int: " + v)
    }

  @inline
  final def toLong(v: Js.Value): Long =
    v match {
      case Js.Num(d) => d.toLong
      case _ => sys.error("Unexpected Js.Value for an Int: " + v)
    }

  @inline
  final def toFloat(v: Js.Value): Float =
    v match {
      case Js.Num(d) => d.toFloat
      case _ => sys.error("Unexpected Js.Value for an Int: " + v)
    }

  @inline
  final def toDouble(v: Js.Value): Double =
    v match {
      case Js.Num(d) => d
      case _ => sys.error("Unexpected Js.Value for an Int: " + v)
    }

  @inline
  final def toStr(v: Js.Value): String =
    v match {
      case Js.Str(s) => s
      case _ => sys.error("Unexpected Js.Value for an Int: " + v)
    }
}

import Json._

final class Json {
  private val caseClassConverterMap =
    mmapEmpty[String, CaseClassConverter]

  val CLASS_DESC = ".class"

  def register[T](ccName: String,
                  c: CaseClassConverter): Unit = {
    if (caseClassConverterMap.contains(ccName)) {
      sys.error("Cannot re-register a Json converter for: " + ccName)
    }
    caseClassConverterMap(ccName) = c
  }

  @inline
  def fromCaseClass(cc: CaseClass): Js.Obj =
    Js.Obj(
      caseClassConverterMap(cc.productPrefix).to(cc) :+
        (CLASS_DESC -> Js.Str(cc.productPrefix)): _*)

  @inline
  def toCaseClass[T <: CaseClass](v: Js.Value): T = v match {
    case o: Js.Obj =>
      val kvs = o.value
      val (`CLASS_DESC`, Js.Str(v)) = kvs.head
      val vs = kvs.drop(1).map(_._2)
      caseClassConverterMap(v).from(vs).asInstanceOf[T]
    case _ => sys.error("Unexpected Js.Value for a Product: " + v)
  }

  def +(other: Json): Json = {
    val r = new Json
    val ikeys = caseClassConverterMap.keySet.
      intersect(other.caseClassConverterMap.keySet)
    if (ikeys.nonEmpty)
      sys.error("Cannot combine Json due to duplicate converter keys:" + ikeys)

    r.caseClassConverterMap ++= caseClassConverterMap
    r.caseClassConverterMap ++= other.caseClassConverterMap
    r
  }
}
