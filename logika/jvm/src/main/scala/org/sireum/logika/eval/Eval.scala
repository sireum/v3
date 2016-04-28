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

package org.sireum.logika.eval

import org.sireum.logika.ast._
import org.sireum.logika.math._
import org.sireum.logika.collection._
import org.sireum.util._

object Eval {
  type Value = Any
  type Store = IMap[String, Value]

  final private val z8Type = Z8Type()
  final private val z16Type = Z16Type()
  final private val z32Type = Z32Type()
  final private val z64Type = Z64Type()
  final private val nType = NType()
  final private val n8Type = N8Type()
  final private val n16Type = N16Type()
  final private val n32Type = N32Type()
  final private val n64Type = N64Type()
  final private val s8Type = S8Type()
  final private val s16Type = S16Type()
  final private val s32Type = S32Type()
  final private val s64Type = S32Type()
  final private val u8Type = U8Type()
  final private val u16Type = U16Type()
  final private val u32Type = U32Type()
  final private val u64Type = U64Type()
  final private val bsType = BSType()
  final private val zsType = ZSType()
  final private val z8sType = Z8SType()
  final private val z16sType = Z16SType()
  final private val z32sType = Z32SType()
  final private val z64sType = Z64SType()
  final private val nsType = NSType()
  final private val n8sType = N8SType()
  final private val n16sType = N16SType()
  final private val n32sType = N32SType()
  final private val n64sType = N64SType()
  final private val s8sType = S8SType()
  final private val s16sType = S16SType()
  final private val s32sType = S32SType()
  final private val s64sType = S64SType()
  final private val u8sType = U8SType()
  final private val u16sType = U16SType()
  final private val u32sType = U32SType()
  final private val u64sType = U64SType()
  final private val rsType = RSType()
  final private val f32sType = F32SType()
  final private val f64sType = F64SType()

  def simplify(bitWidth: Int, store: Store)(e: Exp): Exp = {
    org.sireum.logika.ast.Rewriter.build[Exp](
      mode = org.sireum.util.Rewriter.TraversalMode.BOTTOM_UP)({
      case n: BooleanLit => n
      case n: IntLit => n
      case n: RealLit => n
      case n: FloatLit => n
      case n: SeqLit => n
      case n: Exp => evalExp(store)(n) match {
        case Some(v) => toLit(bitWidth, v)
        case _ => n
      }
    })(e)
  }

  def assignVar(store: Store)(x: String, e: Exp): Option[(Store, Value)] =
    for (v <- evalExp(store)(e)) yield (store + (x -> v), v)

  def assignSeq(store: Store)(id: Id, index: Exp, e: Exp): Option[(Store, Value, Value)] =
    for (ms <- evalExp(store)(id);
         i <- evalExp(store)(index);
         v <- evalExp(store)(e)) yield (ms, i, v) match {
      case (ms: BS.Value, i: Z, v: Boolean) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: ZS.Value, i: Z, v: Z) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: Z8S.Value, i: Z, v: Z8.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: Z16S.Value, i: Z, v: Z16.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: Z32S.Value, i: Z, v: Z32.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: Z64S.Value, i: Z, v: Z64.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: NS.Value, i: Z, v: N) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: N8S.Value, i: Z, v: N8.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: N16S.Value, i: Z, v: N16.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: N32S.Value, i: Z, v: N32.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: N64S.Value, i: Z, v: N64.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: S8S.Value, i: Z, v: S8.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: S16S.Value, i: Z, v: S16.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: S32S.Value, i: Z, v: S32.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: S64S.Value, i: Z, v: S64.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: U8S.Value, i: Z, v: U8.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: U16S.Value, i: Z, v: U16.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: U32S.Value, i: Z, v: U32.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: U64S.Value, i: Z, v: U64.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: RS.Value, i: Z, v: R) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: F32S.Value, i: Z, v: F32.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
      case (ms: F64S.Value, i: Z, v: F64.Value) =>
        val ms2 = ms.clone
        ms2(i) = v
        (store + (id.value -> ms2), ms2, v)
    }

  def evalExp(store: Store)(e: Exp): Option[Value] =
    try {
      new Eval(store).eval(e)
    } catch {
      case _: IndexOutOfBoundsException |
           _: ArithmeticException |
           _: IllegalArgumentException => None
    }

  def toLit(bitWidth: Int, v: Value): Exp = v match {
    case v: Boolean => BooleanLit(v)
    case v: Z => IntLit(v.toString, bitWidth, None)
    case v: ZRange#Value =>
      v.bitWidth match {
        case 8 => IntLit(v.toString, 8, Some(z8Type))
        case 16 => IntLit(v.toString, 16, Some(z16Type))
        case 32 => IntLit(v.toString, 32, Some(z32Type))
        case 64 => IntLit(v.toString, 64, Some(z64Type))
      }
    case v: N => IntLit(v.toString, bitWidth, Some(nType))
    case v: NRange#Value =>
      v.bitWidth match {
        case 8 => IntLit(v.toString, 8, Some(n8Type))
        case 16 => IntLit(v.toString, 16, Some(n16Type))
        case 32 => IntLit(v.toString, 32, Some(n32Type))
        case 64 => IntLit(v.toString, 64, Some(n64Type))
      }
    case v: S#Value =>
      v.bitWidth match {
        case 8 => IntLit(v.toString, 8, Some(s8Type))
        case 16 => IntLit(v.toString, 16, Some(s16Type))
        case 32 => IntLit(v.toString, 32, Some(s32Type))
        case 64 => IntLit(v.toString, 64, Some(s64Type))
      }
    case v: U#Value =>
      v.bitWidth match {
        case 8 => IntLit(v.toString, 8, Some(u8Type))
        case 16 => IntLit(v.toString, 16, Some(u16Type))
        case 32 => IntLit(v.toString, 32, Some(u32Type))
        case 64 => IntLit(v.toString, 64, Some(u64Type))
      }
    case v: R => RealLit(v.toString)
    case v: F#Value =>
      v.bitWidth match {
        case 32 => FloatLit(v.floatValue.toString + "f")
        case 64 => FloatLit(v.doubleValue.toString + "d")
      }
    case v: BS.Value => SeqLit(bsType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: ZS.Value => SeqLit(zsType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: Z8S.Value => SeqLit(z8sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: Z16S.Value => SeqLit(z16sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: Z32S.Value => SeqLit(z32sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: Z64S.Value => SeqLit(z64sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: NS.Value => SeqLit(nsType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: N8S.Value => SeqLit(n8sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: N16S.Value => SeqLit(n16sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: N32S.Value => SeqLit(n32sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: N64S.Value => SeqLit(n64sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: S8S.Value => SeqLit(s8sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: S16S.Value => SeqLit(s16sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: S32S.Value => SeqLit(s32sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: S64S.Value => SeqLit(s64sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: U8S.Value => SeqLit(u8sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: U16S.Value => SeqLit(u16sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: U32S.Value => SeqLit(u32sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: U64S.Value => SeqLit(u64sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: RS.Value => SeqLit(rsType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: F32S.Value => SeqLit(f32sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
    case v: F64S.Value => SeqLit(f64sType, v.elements.toVector.map(e => toLit(bitWidth, e)))
  }
}

import Eval._

private final class Eval(store: Store) {

  def eval(exp: Exp): Option[Value] = exp match {
    case BooleanLit(v) => Some(v)
    case Id(v) => store.get(v)
    case Size(e) => for (v <- eval(e)) yield v match {
      case v: BS.Value => v.size
      case v: ZS.Value => v.size
      case v: Z8S.Value => v.size
      case v: Z16S.Value => v.size
      case v: Z32S.Value => v.size
      case v: Z64S.Value => v.size
      case v: NS.Value => v.size
      case v: N8S.Value => v.size
      case v: N16S.Value => v.size
      case v: N32S.Value => v.size
      case v: N64S.Value => v.size
      case v: S8S.Value => v.size
      case v: S16S.Value => v.size
      case v: S32S.Value => v.size
      case v: S64S.Value => v.size
      case v: U8S.Value => v.size
      case v: U16S.Value => v.size
      case v: U32S.Value => v.size
      case v: U64S.Value => v.size
      case v: RS.Value => v.size
      case v: F32S.Value => v.size
      case v: F64S.Value => v.size
    }
    case Clone(id) => for (v <- eval(id)) yield v match {
      case v: BS.Value => v.clone
      case v: ZS.Value => v.clone
      case v: Z8S.Value => v.clone
      case v: Z16S.Value => v.clone
      case v: Z32S.Value => v.clone
      case v: Z64S.Value => v.clone
      case v: NS.Value => v.clone
      case v: N8S.Value => v.clone
      case v: N16S.Value => v.clone
      case v: N32S.Value => v.clone
      case v: N64S.Value => v.clone
      case v: S8S.Value => v.clone
      case v: S16S.Value => v.clone
      case v: S32S.Value => v.clone
      case v: S64S.Value => v.clone
      case v: U8S.Value => v.clone
      case v: U16S.Value => v.clone
      case v: U32S.Value => v.clone
      case v: U64S.Value => v.clone
      case v: RS.Value => v.clone
      case v: F32S.Value => v.clone
      case v: F64S.Value => v.clone
    }
    case e: Result => store.get("result")
    case Apply(id, Seq(arg)) =>
      try for (ms <- eval(id);
               i <- eval(arg)) yield (ms, i) match {
        case (ms: BS.Value, i: Z) => ms(i)
        case (ms: ZS.Value, i: Z) => ms(i)
        case (ms: Z8S.Value, i: Z) => ms(i)
        case (ms: Z16S.Value, i: Z) => ms(i)
        case (ms: Z32S.Value, i: Z) => ms(i)
        case (ms: Z64S.Value, i: Z) => ms(i)
        case (ms: NS.Value, i: Z) => ms(i)
        case (ms: N8S.Value, i: Z) => ms(i)
        case (ms: N16S.Value, i: Z) => ms(i)
        case (ms: N32S.Value, i: Z) => ms(i)
        case (ms: N64S.Value, i: Z) => ms(i)
        case (ms: S8S.Value, i: Z) => ms(i)
        case (ms: S16S.Value, i: Z) => ms(i)
        case (ms: S32S.Value, i: Z) => ms(i)
        case (ms: S64S.Value, i: Z) => ms(i)
        case (ms: U8S.Value, i: Z) => ms(i)
        case (ms: U16S.Value, i: Z) => ms(i)
        case (ms: U32S.Value, i: Z) => ms(i)
        case (ms: U64S.Value, i: Z) => ms(i)
        case (ms: RS.Value, i: Z) => ms(i)
        case (ms: F32S.Value, i: Z) => ms(i)
        case (ms: F64S.Value, i: Z) => ms(i)
        case (v, _) if !v.isInstanceOf[MS[_]] => None
      }
      catch {
        case _: IndexOutOfBoundsException => None
      }
    case e: RandomInt => None
    case e: ReadInt => None
    case e: IntLit =>
      val v = Z(e.normalize)
      Some(if (e.tpeOpt.isDefined) e.tpeOpt.get match {
        case _: ZType => v
        case _: Z8Type => v.toZ8
        case _: Z16Type => v.toZ16
        case _: Z32Type => v.toZ32
        case _: Z64Type => v.toZ64
        case _: NType => v
        case _: N8Type => v.toN8
        case _: N16Type => v.toN16
        case _: N32Type => v.toN32
        case _: N64Type => v.toN64
        case _: S8Type => v.toS8
        case _: S16Type => v.toS16
        case _: S32Type => v.toS32
        case _: S64Type => v.toS64
        case _: U8Type => v.toU8
        case _: U16Type => v.toU16
        case _: U32Type => v.toU32
        case _: U64Type => v.toU64
      } else v)
    case e: FloatLit =>
      Some(e.primitiveValue match {
        case Left(v) => F32(v)
        case Right(v) => F64(v)
      })
    case e: RealLit => Some(R(e.value))
    case e: IntMin =>
      if (e.bitWidth == 0) None
      else {
        val v = Z(e.value)
        Some(e.integralType match {
          case _: ZType => v.toZ
          case _: Z8Type => v.toZ8
          case _: Z16Type => v.toZ16
          case _: Z32Type => v.toZ32
          case _: Z64Type => v.toZ64
          case _: NType => v
          case _: N8Type => v.toN8
          case _: N16Type => v.toN16
          case _: N32Type => v.toN32
          case _: N64Type => v.toN64
          case _: S8Type => v.toS8
          case _: S16Type => v.toS16
          case _: S32Type => v.toS32
          case _: S64Type => v.toS64
          case _: U8Type => v.toU8
          case _: U16Type => v.toU16
          case _: U32Type => v.toU32
          case _: U64Type => v.toU64
        })
      }
    case e: IntMax =>
      if (e.bitWidth == 0) None
      else {
        val v = Z(e.value)
        Some(e.integralType match {
          case _: ZType => v.toZ
          case _: Z8Type => v.toZ8
          case _: Z16Type => v.toZ16
          case _: Z32Type => v.toZ32
          case _: Z64Type => v.toZ64
          case _: NType => v
          case _: N8Type => v.toN8
          case _: N16Type => v.toN16
          case _: N32Type => v.toN32
          case _: N64Type => v.toN64
          case _: S8Type => v.toS8
          case _: S16Type => v.toS16
          case _: S32Type => v.toS32
          case _: S64Type => v.toS64
          case _: U8Type => v.toU8
          case _: U16Type => v.toU16
          case _: U32Type => v.toU32
          case _: U64Type => v.toU64
        })
      }
    case e: Random => None
    case e: Mul =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: Z, v2: Z) => v1 * v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 * v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 * v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 * v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 * v2
        case (v1: N, v2: N) => v1 * v2
        case (v1: N8.Value, v2: N8.Value) => v1 * v2
        case (v1: N16.Value, v2: N16.Value) => v1 * v2
        case (v1: N32.Value, v2: N32.Value) => v1 * v2
        case (v1: N64.Value, v2: N64.Value) => v1 * v2
        case (v1: S8.Value, v2: S8.Value) => v1 * v2
        case (v1: S16.Value, v2: S16.Value) => v1 * v2
        case (v1: S32.Value, v2: S32.Value) => v1 * v2
        case (v1: S64.Value, v2: S64.Value) => v1 * v2
        case (v1: U8.Value, v2: U8.Value) => v1 * v2
        case (v1: U16.Value, v2: U16.Value) => v1 * v2
        case (v1: U32.Value, v2: U32.Value) => v1 * v2
        case (v1: U64.Value, v2: U64.Value) => v1 * v2
        case (v1: R, v2: R) => v1 * v2
        case (v1: F32.Value, v2: F32.Value) => v1 * v2
        case (v1: F64.Value, v2: F64.Value) => v1 * v2
      }
    case e: Div =>
      try for (v1 <- eval(e.left);
               v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: Z, v2: Z) => v1 / v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 / v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 / v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 / v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 / v2
        case (v1: N, v2: N) => v1 / v2
        case (v1: N8.Value, v2: N8.Value) => v1 / v2
        case (v1: N16.Value, v2: N16.Value) => v1 / v2
        case (v1: N32.Value, v2: N32.Value) => v1 / v2
        case (v1: N64.Value, v2: N64.Value) => v1 / v2
        case (v1: S8.Value, v2: S8.Value) => v1 / v2
        case (v1: S16.Value, v2: S16.Value) => v1 / v2
        case (v1: S32.Value, v2: S32.Value) => v1 / v2
        case (v1: S64.Value, v2: S64.Value) => v1 / v2
        case (v1: U8.Value, v2: U8.Value) => v1 / v2
        case (v1: U16.Value, v2: U16.Value) => v1 / v2
        case (v1: U32.Value, v2: U32.Value) => v1 / v2
        case (v1: U64.Value, v2: U64.Value) => v1 / v2
        case (v1: R, v2: R) => v1 / v2
        case (v1: F32.Value, v2: F32.Value) => v1 / v2
        case (v1: F64.Value, v2: F64.Value) => v1 / v2
      } catch {
        case _: ArithmeticException => None
      }
    case e: Rem =>
      try for (v1 <- eval(e.left);
               v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: Z, v2: Z) => v1 % v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 % v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 % v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 % v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 % v2
        case (v1: N, v2: N) => v1 % v2
        case (v1: N8.Value, v2: N8.Value) => v1 % v2
        case (v1: N16.Value, v2: N16.Value) => v1 % v2
        case (v1: N32.Value, v2: N32.Value) => v1 % v2
        case (v1: N64.Value, v2: N64.Value) => v1 % v2
        case (v1: S8.Value, v2: S8.Value) => v1 % v2
        case (v1: S16.Value, v2: S16.Value) => v1 % v2
        case (v1: S32.Value, v2: S32.Value) => v1 % v2
        case (v1: S64.Value, v2: S64.Value) => v1 % v2
        case (v1: U8.Value, v2: U8.Value) => v1 % v2
        case (v1: U16.Value, v2: U16.Value) => v1 % v2
        case (v1: U32.Value, v2: U32.Value) => v1 % v2
        case (v1: U64.Value, v2: U64.Value) => v1 % v2
        case (v1: R, v2: R) => v1 % v2
        case (v1: F32.Value, v2: F32.Value) => v1 % v2
        case (v1: F64.Value, v2: F64.Value) => v1 % v2
      } catch {
        case _: ArithmeticException => None
      }
    case e: Add =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: Z, v2: Z) => v1 + v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 + v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 + v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 + v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 + v2
        case (v1: N, v2: N) => v1 + v2
        case (v1: N8.Value, v2: N8.Value) => v1 + v2
        case (v1: N16.Value, v2: N16.Value) => v1 + v2
        case (v1: N32.Value, v2: N32.Value) => v1 + v2
        case (v1: N64.Value, v2: N64.Value) => v1 + v2
        case (v1: S8.Value, v2: S8.Value) => v1 + v2
        case (v1: S16.Value, v2: S16.Value) => v1 + v2
        case (v1: S32.Value, v2: S32.Value) => v1 + v2
        case (v1: S64.Value, v2: S64.Value) => v1 + v2
        case (v1: U8.Value, v2: U8.Value) => v1 + v2
        case (v1: U16.Value, v2: U16.Value) => v1 + v2
        case (v1: U32.Value, v2: U32.Value) => v1 + v2
        case (v1: U64.Value, v2: U64.Value) => v1 + v2
        case (v1: R, v2: R) => v1 + v2
        case (v1: F32.Value, v2: F32.Value) => v1 + v2
        case (v1: F64.Value, v2: F64.Value) => v1 + v2
      }
    case e: Sub =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: Z, v2: Z) => v1 - v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 - v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 - v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 - v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 - v2
        case (v1: N, v2: N) => v1 - v2
        case (v1: N8.Value, v2: N8.Value) => v1 - v2
        case (v1: N16.Value, v2: N16.Value) => v1 - v2
        case (v1: N32.Value, v2: N32.Value) => v1 - v2
        case (v1: N64.Value, v2: N64.Value) => v1 - v2
        case (v1: S8.Value, v2: S8.Value) => v1 - v2
        case (v1: S16.Value, v2: S16.Value) => v1 - v2
        case (v1: S32.Value, v2: S32.Value) => v1 - v2
        case (v1: S64.Value, v2: S64.Value) => v1 - v2
        case (v1: U8.Value, v2: U8.Value) => v1 - v2
        case (v1: U16.Value, v2: U16.Value) => v1 - v2
        case (v1: U32.Value, v2: U32.Value) => v1 - v2
        case (v1: U64.Value, v2: U64.Value) => v1 - v2
        case (v1: R, v2: R) => v1 - v2
        case (v1: F32.Value, v2: F32.Value) => v1 - v2
        case (v1: F64.Value, v2: F64.Value) => v1 - v2
      }
    case e: Lt =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: Z, v2: Z) => v1 < v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 < v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 < v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 < v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 < v2
        case (v1: N, v2: N) => v1 < v2
        case (v1: N8.Value, v2: N8.Value) => v1 < v2
        case (v1: N16.Value, v2: N16.Value) => v1 < v2
        case (v1: N32.Value, v2: N32.Value) => v1 < v2
        case (v1: N64.Value, v2: N64.Value) => v1 < v2
        case (v1: S8.Value, v2: S8.Value) => v1 < v2
        case (v1: S16.Value, v2: S16.Value) => v1 < v2
        case (v1: S32.Value, v2: S32.Value) => v1 < v2
        case (v1: S64.Value, v2: S64.Value) => v1 < v2
        case (v1: U8.Value, v2: U8.Value) => v1 < v2
        case (v1: U16.Value, v2: U16.Value) => v1 < v2
        case (v1: U32.Value, v2: U32.Value) => v1 < v2
        case (v1: U64.Value, v2: U64.Value) => v1 < v2
        case (v1: R, v2: R) => v1 < v2
        case (v1: F32.Value, v2: F32.Value) => v1 < v2
        case (v1: F64.Value, v2: F64.Value) => v1 < v2
      }
    case e: Le =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: Z, v2: Z) => v1 <= v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 <= v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 <= v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 <= v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 <= v2
        case (v1: N, v2: N) => v1 <= v2
        case (v1: N8.Value, v2: N8.Value) => v1 <= v2
        case (v1: N16.Value, v2: N16.Value) => v1 <= v2
        case (v1: N32.Value, v2: N32.Value) => v1 <= v2
        case (v1: N64.Value, v2: N64.Value) => v1 <= v2
        case (v1: S8.Value, v2: S8.Value) => v1 <= v2
        case (v1: S16.Value, v2: S16.Value) => v1 <= v2
        case (v1: S32.Value, v2: S32.Value) => v1 <= v2
        case (v1: S64.Value, v2: S64.Value) => v1 <= v2
        case (v1: U8.Value, v2: U8.Value) => v1 <= v2
        case (v1: U16.Value, v2: U16.Value) => v1 <= v2
        case (v1: U32.Value, v2: U32.Value) => v1 <= v2
        case (v1: U64.Value, v2: U64.Value) => v1 <= v2
        case (v1: R, v2: R) => v1 <= v2
        case (v1: F32.Value, v2: F32.Value) => v1 <= v2
        case (v1: F64.Value, v2: F64.Value) => v1 <= v2
      }
    case e: Gt =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: Z, v2: Z) => v1 > v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 > v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 > v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 > v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 > v2
        case (v1: N, v2: N) => v1 > v2
        case (v1: N8.Value, v2: N8.Value) => v1 > v2
        case (v1: N16.Value, v2: N16.Value) => v1 > v2
        case (v1: N32.Value, v2: N32.Value) => v1 > v2
        case (v1: N64.Value, v2: N64.Value) => v1 > v2
        case (v1: S8.Value, v2: S8.Value) => v1 > v2
        case (v1: S16.Value, v2: S16.Value) => v1 > v2
        case (v1: S32.Value, v2: S32.Value) => v1 > v2
        case (v1: S64.Value, v2: S64.Value) => v1 > v2
        case (v1: U8.Value, v2: U8.Value) => v1 > v2
        case (v1: U16.Value, v2: U16.Value) => v1 > v2
        case (v1: U32.Value, v2: U32.Value) => v1 > v2
        case (v1: U64.Value, v2: U64.Value) => v1 > v2
        case (v1: R, v2: R) => v1 > v2
        case (v1: F32.Value, v2: F32.Value) => v1 > v2
        case (v1: F64.Value, v2: F64.Value) => v1 > v2
      }
    case e: Ge =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: Z, v2: Z) => v1 >= v2
        case (v1: Z8.Value, v2: Z8.Value) => v1 >= v2
        case (v1: Z16.Value, v2: Z16.Value) => v1 >= v2
        case (v1: Z32.Value, v2: Z32.Value) => v1 >= v2
        case (v1: Z64.Value, v2: Z64.Value) => v1 >= v2
        case (v1: N, v2: N) => v1 >= v2
        case (v1: N8.Value, v2: N8.Value) => v1 >= v2
        case (v1: N16.Value, v2: N16.Value) => v1 >= v2
        case (v1: N32.Value, v2: N32.Value) => v1 >= v2
        case (v1: N64.Value, v2: N64.Value) => v1 >= v2
        case (v1: S8.Value, v2: S8.Value) => v1 >= v2
        case (v1: S16.Value, v2: S16.Value) => v1 >= v2
        case (v1: S32.Value, v2: S32.Value) => v1 >= v2
        case (v1: S64.Value, v2: S64.Value) => v1 >= v2
        case (v1: U8.Value, v2: U8.Value) => v1 >= v2
        case (v1: U16.Value, v2: U16.Value) => v1 >= v2
        case (v1: U32.Value, v2: U32.Value) => v1 >= v2
        case (v1: U64.Value, v2: U64.Value) => v1 >= v2
        case (v1: R, v2: R) => v1 >= v2
        case (v1: F32.Value, v2: F32.Value) => v1 >= v2
        case (v1: F64.Value, v2: F64.Value) => v1 >= v2
      }
    case e: Shr =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: S8.Value, v2: S8.Value) => v1 >> v2
        case (v1: S16.Value, v2: S16.Value) => v1 >> v2
        case (v1: S32.Value, v2: S32.Value) => v1 >> v2
        case (v1: S64.Value, v2: S64.Value) => v1 >> v2
      }
    case e: UShr =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: S8.Value, v2: S8.Value) => v1 >>> v2
        case (v1: S16.Value, v2: S16.Value) => v1 >>> v2
        case (v1: S32.Value, v2: S32.Value) => v1 >>> v2
        case (v1: S64.Value, v2: S64.Value) => v1 >>> v2
        case (v1: U8.Value, v2: U8.Value) => v1 >>> v2
        case (v1: U16.Value, v2: U16.Value) => v1 >>> v2
        case (v1: U32.Value, v2: U32.Value) => v1 >>> v2
        case (v1: U64.Value, v2: U64.Value) => v1 >>> v2
      }
    case e: Shl =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: S8.Value, v2: S8.Value) => v1 << v2
        case (v1: S16.Value, v2: S16.Value) => v1 << v2
        case (v1: S32.Value, v2: S32.Value) => v1 << v2
        case (v1: S64.Value, v2: S64.Value) => v1 << v2
        case (v1: U8.Value, v2: U8.Value) => v1 << v2
        case (v1: U16.Value, v2: U16.Value) => v1 << v2
        case (v1: U32.Value, v2: U32.Value) => v1 << v2
        case (v1: U64.Value, v2: U64.Value) => v1 << v2
      }
    case e: Eq =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield v1 == v2
    case e: Ne =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield v1 != v2
    case e: Append =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: BS.Value, v2: Boolean) => v1 :+ v2
        case (v1: ZS.Value, v2: Z) => v1 :+ v2
        case (v1: Z8S.Value, v2: Z8.Value) => v1 :+ v2
        case (v1: Z16S.Value, v2: Z16.Value) => v1 :+ v2
        case (v1: Z32S.Value, v2: Z32.Value) => v1 :+ v2
        case (v1: Z64S.Value, v2: Z64.Value) => v1 :+ v2
        case (v1: NS.Value, v2: N) => v1 :+ v2
        case (v1: N8S.Value, v2: N8.Value) => v1 :+ v2
        case (v1: N16S.Value, v2: N16.Value) => v1 :+ v2
        case (v1: N32S.Value, v2: N32.Value) => v1 :+ v2
        case (v1: N64S.Value, v2: N64.Value) => v1 :+ v2
        case (v1: S8S.Value, v2: S8.Value) => v1 :+ v2
        case (v1: S16S.Value, v2: S16.Value) => v1 :+ v2
        case (v1: S32S.Value, v2: S32.Value) => v1 :+ v2
        case (v1: S64S.Value, v2: S64.Value) => v1 :+ v2
        case (v1: U8S.Value, v2: U8.Value) => v1 :+ v2
        case (v1: U16S.Value, v2: U16.Value) => v1 :+ v2
        case (v1: U32S.Value, v2: U32.Value) => v1 :+ v2
        case (v1: U64S.Value, v2: U64.Value) => v1 :+ v2
        case (v1: RS.Value, v2: R) => v1 :+ v2
        case (v1: F32S.Value, v2: F32.Value) => v1 :+ v2
        case (v1: F64S.Value, v2: F64.Value) => v1 :+ v2
      }
    case e: Prepend =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v2, v1) match {
        case (v2: BS.Value, v1: Boolean) => v1 +: v2
        case (v2: ZS.Value, v1: Z) => v1 +: v2
        case (v2: Z8S.Value, v1: Z8.Value) => v1 +: v2
        case (v2: Z16S.Value, v1: Z16.Value) => v1 +: v2
        case (v2: Z32S.Value, v1: Z32.Value) => v1 +: v2
        case (v2: Z64S.Value, v1: Z64.Value) => v1 +: v2
        case (v2: NS.Value, v1: N) => v1 +: v2
        case (v2: N8S.Value, v1: N8.Value) => v1 +: v2
        case (v2: N16S.Value, v1: N16.Value) => v1 +: v2
        case (v2: N32S.Value, v1: N32.Value) => v1 +: v2
        case (v2: N64S.Value, v1: N64.Value) => v1 +: v2
        case (v2: S8S.Value, v1: S8.Value) => v1 +: v2
        case (v2: S16S.Value, v1: S16.Value) => v1 +: v2
        case (v2: S32S.Value, v1: S32.Value) => v1 +: v2
        case (v2: S64S.Value, v1: S64.Value) => v1 +: v2
        case (v2: U8S.Value, v1: U8.Value) => v1 +: v2
        case (v2: U16S.Value, v1: U16.Value) => v1 +: v2
        case (v2: U32S.Value, v1: U32.Value) => v1 +: v2
        case (v2: U64S.Value, v1: U64.Value) => v1 +: v2
        case (v2: RS.Value, v1: R) => v1 +: v2
        case (v2: F32S.Value, v1: F32.Value) => v1 +: v2
        case (v2: F64S.Value, v1: F64.Value) => v1 +: v2
      }
    case e: And =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: Boolean, v2: Boolean) => v1 & v2
        case (v1: S8.Value, v2: S8.Value) => v1 & v2
        case (v1: S16.Value, v2: S16.Value) => v1 & v2
        case (v1: S32.Value, v2: S32.Value) => v1 & v2
        case (v1: S64.Value, v2: S64.Value) => v1 & v2
        case (v1: U8.Value, v2: U8.Value) => v1 & v2
        case (v1: U16.Value, v2: U16.Value) => v1 & v2
        case (v1: U32.Value, v2: U32.Value) => v1 & v2
        case (v1: U64.Value, v2: U64.Value) => v1 & v2
      }
    case e: Xor =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: Boolean, v2: Boolean) => v1 ^ v2
        case (v1: S8.Value, v2: S8.Value) => v1 ^| v2
        case (v1: S16.Value, v2: S16.Value) => v1 ^| v2
        case (v1: S32.Value, v2: S32.Value) => v1 ^| v2
        case (v1: S64.Value, v2: S64.Value) => v1 ^| v2
        case (v1: U8.Value, v2: U8.Value) => v1 ^| v2
        case (v1: U16.Value, v2: U16.Value) => v1 ^| v2
        case (v1: U32.Value, v2: U32.Value) => v1 ^| v2
        case (v1: U64.Value, v2: U64.Value) => v1 ^| v2
      }
    case e: Or =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: Boolean, v2: Boolean) => v1 | v2
        case (v1: S8.Value, v2: S8.Value) => v1 | v2
        case (v1: S16.Value, v2: S16.Value) => v1 | v2
        case (v1: S32.Value, v2: S32.Value) => v1 | v2
        case (v1: S64.Value, v2: S64.Value) => v1 | v2
        case (v1: U8.Value, v2: U8.Value) => v1 | v2
        case (v1: U16.Value, v2: U16.Value) => v1 | v2
        case (v1: U32.Value, v2: U32.Value) => v1 | v2
        case (v1: U64.Value, v2: U64.Value) => v1 | v2
      }
    case e: Implies =>
      for (v1 <- eval(e.left);
           v2 <- eval(e.right)) yield (v1, v2) match {
        case (v1: Boolean, v2: Boolean) => !v1 | v2
      }
    case e: Not =>
      for (v <- eval(e.exp)) yield v match {
        case v: Boolean => !v
        case v: S8.Value => ~v
        case v: S16.Value => ~v
        case v: S32.Value => ~v
        case v: S64.Value => ~v
        case v: U8.Value => ~v
        case v: U16.Value => ~v
        case v: U32.Value => ~v
        case v: U64.Value => ~v
      }
    case e: Minus =>
      for (v <- eval(e.exp)) yield v match {
        case v: Z => -v
        case v: S8.Value => -v
        case v: S16.Value => -v
        case v: S32.Value => -v
        case v: S64.Value => -v
        case v: R => -v
        case v: F32.Value => -v
        case v: F64.Value => -v
      }
    case e: ForAll => None
    case e: Exists => None
    case e: SeqLit =>
      var args = ivectorEmpty[Value]
      for (arg <- e.args) eval(arg) match {
        case Some(v) => args :+= arg
        case _ => return None
      }
      Some(e.tpe match {
        case _: BSType => BS(args.map(_.asInstanceOf[Boolean]): _*)
        case _: ZSType => ZS(args.map(_.asInstanceOf[Z]): _*)
        case _: Z8SType => Z8S(args.map(_.asInstanceOf[Z8.Value]): _*)
        case _: Z16SType => Z16S(args.map(_.asInstanceOf[Z16.Value]): _*)
        case _: Z32SType => Z32S(args.map(_.asInstanceOf[Z32.Value]): _*)
        case _: Z64SType => Z64S(args.map(_.asInstanceOf[Z64.Value]): _*)
        case _: NSType => NS(args.map(_.asInstanceOf[N]): _*)
        case _: N8SType => N8S(args.map(_.asInstanceOf[N8.Value]): _*)
        case _: N16SType => N16S(args.map(_.asInstanceOf[N16.Value]): _*)
        case _: N32SType => N32S(args.map(_.asInstanceOf[N32.Value]): _*)
        case _: N64SType => N64S(args.map(_.asInstanceOf[N64.Value]): _*)
        case _: S8SType => S8S(args.map(_.asInstanceOf[S8.Value]): _*)
        case _: S16SType => S16S(args.map(_.asInstanceOf[S16.Value]): _*)
        case _: S32SType => S32S(args.map(_.asInstanceOf[S32.Value]): _*)
        case _: S64SType => S64S(args.map(_.asInstanceOf[S64.Value]): _*)
        case _: U8SType => U8S(args.map(_.asInstanceOf[U8.Value]): _*)
        case _: U16SType => U16S(args.map(_.asInstanceOf[U16.Value]): _*)
        case _: U32SType => U32S(args.map(_.asInstanceOf[U32.Value]): _*)
        case _: U64SType => U64S(args.map(_.asInstanceOf[U64.Value]): _*)
        case _: RSType => RS(args.map(_.asInstanceOf[R]): _*)
        case _: F32SType => F32S(args.map(_.asInstanceOf[F32.Value]): _*)
        case _: F64SType => F64S(args.map(_.asInstanceOf[F64.Value]): _*)
      })
  }
}
