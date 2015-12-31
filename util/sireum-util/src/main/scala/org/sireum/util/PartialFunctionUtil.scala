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

import scala.collection.Map
import scala.util.control.NoStackTrace


object PartialFunctionUtil {
  def empty[A, B] = Map[A, B]()

  def default[A, B](b: B): A --\ B = {
    case _ => b
  }

  def toPartialFunction[K, V](f : K => V) =
    new PartialFunction[K, V] {
      def apply(k : K) = f(k)
      def isDefinedAt(k : K) = true
    }

  val EMPTY_MAP = Map()

  def isEmpty(f: _ --\ _) = f == EMPTY_MAP

  def orElse[A, B, A1 <: A, B1 >: B] //
  (f1: A --\ B, f2: A1 --\ B1): A1 --\ B1 =
    if (isEmpty(f1)) f2
    else if (isEmpty(f2)) f1
    else f1 orElse f2

  def orElses[A, B](fs: (A --\ B)*): A --\ B = orElses(fs)

  def orElses[A, B](fs: Iterable[A --\ B]): A --\ B =
    new PartialFunction[A, B] {
      lazy val pfs = {
        val r = marrayEmpty[A --\ B]
        for (f <- fs)
          if (!isEmpty(f))
            r += f
        r
      }
      def apply(a : A) : B = {
        for (f <- pfs)
          if (f isDefinedAt a) return f(a)
        sys.error("Undefined operation for input: " + a)
      }

      def isDefinedAt(a : A) : Boolean = {
        for (f <- pfs)
          if (f isDefinedAt a) return true
        false
      }
    }

  def chain[A, B, A1 <: A, B1 >: B] //
  (f1: A --\ B, f2: A1 --\ B1): A1 --\ B1 =
    if (isEmpty(f1)) f2
    else
      new PartialFunction[A1, B1] {
        def apply(a : A1) =
          if (f1 isDefinedAt a)
            try { f1(a) }
            catch {
              case ex : ChainUndefined =>
                if (f2 isDefinedAt a) f2(a)
                else throw ex
            }
          else f2(a)

        def isDefinedAt(a : A1) =
          (f1 isDefinedAt a) || (f2 isDefinedAt a)
      }

  def applyOpt[A, B](pf: A --\ B, arg: A): Option[B] = {
    if (pf isDefinedAt arg) Some(pf(arg))
    else None
  }

  final class ChainUndefined extends NoStackTrace
}