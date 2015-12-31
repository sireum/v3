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

import scala.annotation.StaticAnnotation
import scala.annotation.meta.getter

object Json {

  @getter
  final class InternString extends StaticAnnotation

  @getter
  final class Extern extends StaticAnnotation

  import scala.language.implicitConversions

  implicit final def fromAnyVal(v: AnyVal): Js.Value =
    v match {
      case true => Js.True
      case false => Js.False
      case v: Byte => Js.Num(v)
      case v: Short => Js.Num(v)
      case v: Char => Js.Str(v.toString)
      case v: Int => Js.Num(v)
      case v: Long => Js.Str(v.toString)
      case v: Float => Js.Num(v)
      case v: Double => Js.Num(v)
    }

  implicit final def fromByteArray(a: Array[Byte]): Js.Value =
    Js.Str(a.map("%02X" format _).mkString)

  implicit final def fromStr(s: String): Js.Str = Js.Str(s)

  implicit final def fromSeq[T](c: CSeq[T])(
    implicit f: T => Js.Value): Js.Arr =
    Js.Arr(c.map(f): _*)

  implicit final def fromTuple2[T1, T2](t: (T1, T2))(
    implicit f1: T1 => Js.Value, f2: T2 => Js.Value): Js.Arr =
    Js.Arr(f1(t._1), f2(t._2))

  implicit final def fromTuple3[T1, T2, T3](t: (T1, T2, T3))(
    implicit
    f1: T1 => Js.Value,
    f2: T2 => Js.Value,
    f3: T3 => Js.Value): Js.Arr =
    Js.Arr(f1(t._1), f2(t._2), f3(t._3))

  implicit final def fromOption[T](c: Option[T])(
    implicit f: T => Js.Value): Js.Arr =
    Js.Arr(c.map(f).toSeq: _*)

  implicit final def fromLocationInfo(li: LocationInfo): Js.Arr = {
    Js.Arr(li.lineBegin, li.columnBegin, li.lineEnd, li.columnEnd,
      li.offset, li.length)
  }

  implicit final def toVector[T](v: Js.Value)(
    implicit f: Js.Value => T): Vector[T] =
    v match {
      case a: Js.Arr =>
        var r = ivectorEmpty[T]
        for (v <- a.value) {
          r = r :+ f(v)
        }
        r
      case _ => sys.error("Unexpected Js.Value for a sequence: " + v)
    }

  implicit final def toTuple2[T1, T2](v: Js.Value)(
    implicit
    f1: Js.Value => T1,
    f2: Js.Value => T2): (T1, T2) =
    v match {
      case a: Js.Arr =>
        (f1(a.value(0)), f2(a.value(1)))
      case _ => sys.error("Unexpected Js.Value for a pair: " + v)
    }

  implicit final def toTuple3[T1, T2, T3](v: Js.Value)(
    implicit
    f1: Js.Value => T1,
    f2: Js.Value => T2,
    f3: Js.Value => T3): (T1, T2, T3) =
    v match {
      case a: Js.Arr =>
        (f1(a.value(0)), f2(a.value(1)), f3(a.value(2)))
      case _ => sys.error("Unexpected Js.Value for a triplet: " + v)
    }

  implicit final def toOption[T](v: Js.Value)(
    implicit f: Js.Value => T): Option[T] =
    v match {
      case a: Js.Arr =>
        a.value match {
          case Seq(value) => Some(f(value))
          case _ => None
        }
      case _ => sys.error("Unexpected Js.Value for an option: " + v)
    }

  implicit final def toBoolean(v: Js.Value): Boolean =
    v match {
      case Js.True => true
      case Js.False => false
      case _ => sys.error("Unexpected Js.Value for a Boolean: " + v)
    }

  implicit final def toByte(v: Js.Value): Byte =
    v match {
      case Js.Num(d) => d.toByte
      case _ => sys.error("Unexpected Js.Value for a Byte: " + v)
    }

  implicit final def toChar(v: Js.Value): Char =
    v match {
      case Js.Str(s) => s.charAt(0)
      case _ => sys.error("Unexpected Js.Value for a Char: " + v)
    }

  implicit final def toShort(v: Js.Value): Short =
    v match {
      case Js.Num(d) => d.toShort
      case _ => sys.error("Unexpected Js.Value for a Short: " + v)
    }

  implicit final def toInt(v: Js.Value): Int =
    v match {
      case Js.Num(d) => d.toInt
      case _ => sys.error("Unexpected Js.Value for an Int: " + v)
    }

  implicit final def toLong(v: Js.Value): Long =
    v match {
      case Js.Str(s) => s.toLong
      case _ => sys.error("Unexpected Js.Value for a Long: " + v)
    }

  implicit final def toFloat(v: Js.Value): Float =
    v match {
      case Js.Num(d) => d.toFloat
      case _ => sys.error("Unexpected Js.Value for a Float: " + v)
    }

  implicit final def toDouble(v: Js.Value): Double =
    v match {
      case Js.Num(d) => d
      case _ => sys.error("Unexpected Js.Value for a Double: " + v)
    }

  implicit final def toByteArray(v: Js.Value): Array[Byte] =
    v match {
      case Js.Str(s) =>
        s.replaceAll("[^0-9A-Fa-f]", "").sliding(2, 2).
          toArray.map(Integer.parseInt(_, 16).toByte)
      case _ => sys.error("Unexpected Js.Value for an Array[Byte]: " + v)
    }

  final def toStrIntern(v: Js.Value): String =
    v match {
      case Js.Str(s) => s.intern()
      case _ => sys.error("Unexpected Js.Value for a String: " + v)
    }

  implicit final def toStr(v: Js.Value): String =
    v match {
      case Js.Str(s) => s
      case _ => sys.error("Unexpected Js.Value for a String: " + v)
    }

  implicit final def toLocationInfo(v: Js.Value): Option[LocationInfo] = v match {
    case a: Js.Arr =>
      if (a.value.isEmpty) None
      else {
        val Seq(lineBegin, columnBegin, lineEnd, columnEnd, offset, length) =
          a.value.map(toInt)
        Some(LocationInfo(lineBegin, columnBegin, lineEnd, columnEnd, offset, length))
      }
    case _ => sys.error("Unexpected Js.Value for a LocationInfo: " + v)
  }
}
