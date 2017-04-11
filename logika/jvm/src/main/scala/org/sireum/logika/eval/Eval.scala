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

import org.sireum.logika._
import org.sireum.logika.ast._
import org.sireum.util._

object Eval {

  final case class Value(tpe: tipe.Tipe, value: Any)

  type Store = IMap[String, Value]

  final private val bType = BType()
  final private val zType = ZType()
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
  final private val f32Type = F32Type()
  final private val f64Type = F64Type()
  final private val rType = RType()
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
  final private val s64sType = S32SType()
  final private val u8sType = U8SType()
  final private val u16sType = U16SType()
  final private val u32sType = U32SType()
  final private val u64sType = U64SType()
  final private val f32sType = F32SType()
  final private val f64sType = F64SType()
  final private val rsType = RSType()

  def toZ(n: Any): Z = n match {
    case n: Z => n
    case n: N => n.toZ
    case n: Byte => _Z(n)
    case n: Short => _Z(n)
    case n: Int => _Z(n)
    case n: Long => _Z(n)
    case n: spire.math.UByte => _Z(n.toLong)
    case n: spire.math.UShort => _Z(n.toLong)
    case n: spire.math.UInt => _Z(n.toLong)
    case n: spire.math.ULong => _Z(n.toBigInt)
  }

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
    for (Value(msType, ms) <- evalExp(store)(id);
         Value(_, i) <- evalExp(store)(index);
         vv@Value(_, v) <- evalExp(store)(e)) yield ((ms, i, v): @unchecked) match {
      case (ms: MS[_, _], _, v: Value) =>
        val ms2 = ms.clone.asInstanceOf[MS[Any, Value]]
        ms2(toZ(i)) = v
        val ms2v = Value(msType, ms2)
        (store + (id.value -> ms2v), ms2v, vv)
    }

  def evalExp(store: Store)(e: Exp): Option[Value] =
    try {
      new Eval(store).eval(e)
    } catch {
      case _: IndexOutOfBoundsException |
           _: ArithmeticException |
           _: IllegalArgumentException => None
    }

  def toLit(bitWidth: Int, v: Value): Exp = (v: @unchecked) match {
    case Value(_, v: Boolean) => BooleanLit(v)
    case Value(_, v: Z) => IntLit(v.toString, bitWidth, None)
    case Value(tipe.Z8, v: Byte) => IntLit(v.toString, 8, Some(z8Type))
    case Value(tipe.Z16, v: Short) => IntLit(v.toString, 16, Some(z16Type))
    case Value(tipe.Z32, v: Int) => IntLit(v.toString, 32, Some(z32Type))
    case Value(tipe.Z64, v: Long) => IntLit(v.toString, 64, Some(z64Type))
    case Value(tipe.S8, v: Byte) => IntLit(v.toString, 8, Some(s8Type))
    case Value(tipe.S16, v: Short) => IntLit(v.toString, 16, Some(s16Type))
    case Value(tipe.S32, v: Int) => IntLit(v.toString, 32, Some(s32Type))
    case Value(tipe.S64, v: Long) => IntLit(v.toString, 64, Some(s64Type))
    case Value(_, v: N) => IntLit(v.toString, bitWidth, Some(nType))
    case Value(tipe.N8, v: spire.math.UByte) => IntLit(v.toString, 8, Some(n8Type))
    case Value(tipe.N16, v: spire.math.UShort) => IntLit(v.toString, 16, Some(n16Type))
    case Value(tipe.N32, v: spire.math.UInt) => IntLit(v.toString, 32, Some(n32Type))
    case Value(tipe.N64, v: spire.math.ULong) => IntLit(v.toString, 64, Some(n64Type))
    case Value(tipe.U8, v: spire.math.UByte) => IntLit(v.toString, 8, Some(u8Type))
    case Value(tipe.U16, v: spire.math.UShort) => IntLit(v.toString, 16, Some(u16Type))
    case Value(tipe.U32, v: spire.math.UInt) => IntLit(v.toString, 32, Some(u32Type))
    case Value(tipe.U64, v: spire.math.ULong) => IntLit(v.toString, 64, Some(u64Type))
    case Value(_, v: R) => RealLit(v.toString)
    case Value(_, v: Float) => FloatLit(v.floatValue.toString + "f")
    case Value(_, v: Double) => FloatLit(v.doubleValue.toString + "d")
    case Value(t: tipe.MSeq, v: MS[_, _]) =>
      SeqLit(tipe2Type(t).asInstanceOf[SeqType],
        v.elements.toVector.map(e => toLit(bitWidth, Value(t.result, e))))
  }

  def tipe2Type(t: tipe.Tipe): Type = (t: @unchecked) match {
    case tipe.B => bType
    case tipe.Z => zType
    case tipe.Z8 => z8Type
    case tipe.Z16 => z16Type
    case tipe.Z32 => z32Type
    case tipe.Z64 => z64Type
    case tipe.N => nType
    case tipe.N8 => n8Type
    case tipe.N16 => n16Type
    case tipe.N32 => n32Type
    case tipe.N64 => n64Type
    case tipe.S8 => s8Type
    case tipe.S16 => s16Type
    case tipe.S32 => s32Type
    case tipe.S64 => s64Type
    case tipe.U8 => u8Type
    case tipe.U16 => u16Type
    case tipe.U32 => u32Type
    case tipe.U64 => u64Type
    case tipe.F32 => f32Type
    case tipe.F64 => f64Type
    case tipe.R => rType
    case tipe.BS => bsType
    case tipe.ZS => zsType
    case tipe.Z8S => z8sType
    case tipe.Z16S => z16sType
    case tipe.Z32S => z32sType
    case tipe.Z64S => z64sType
    case tipe.NS => nsType
    case tipe.N8S => n8sType
    case tipe.N16S => n16sType
    case tipe.N32S => n32sType
    case tipe.N64S => n64sType
    case tipe.S8S => s8sType
    case tipe.S16S => s16sType
    case tipe.S32S => s32sType
    case tipe.S64S => s64sType
    case tipe.U8S => u8sType
    case tipe.U16S => u16sType
    case tipe.U32S => u32sType
    case tipe.U64S => u64sType
    case tipe.F32S => f32sType
    case tipe.F64S => f64sType
    case tipe.RS => rsType
  }
}

import Eval._

private final class Eval(store: Store) {

  def int2v(tpeOpt: Option[Type], v: Z): Value = tpeOpt match {
    case Some(t) => (t: @unchecked) match {
      case _: ZType => Value(tipe.Z, v)
      case _: Z8Type => Value(tipe.Z8, Z.toZ8(v))
      case _: Z16Type => Value(tipe.Z16, Z.toZ16(v))
      case _: Z32Type => Value(tipe.Z32, Z.toZ32(v))
      case _: Z64Type => Value(tipe.Z64, Z.toZ64(v))
      case _: NType => Value(tipe.N, Z.toN(v))
      case _: N8Type => Value(tipe.N8, Z.toN8(v))
      case _: N16Type => Value(tipe.N16, Z.toN16(v))
      case _: N32Type => Value(tipe.N32, Z.toN32(v))
      case _: N64Type => Value(tipe.N64, Z.toN64(v))
      case _: S8Type => Value(tipe.S8, Z.toS8(v))
      case _: S16Type => Value(tipe.S16, Z.toS16(v))
      case _: S32Type => Value(tipe.S32, Z.toS32(v))
      case _: S64Type => Value(tipe.S64, Z.toS64(v))
      case _: U8Type => Value(tipe.U8, Z.toU8(v))
      case _: U16Type => Value(tipe.U16, Z.toU16(v))
      case _: U32Type => Value(tipe.U32, Z.toU32(v))
      case _: U64Type => Value(tipe.U64, Z.toU64(v))
    }
    case _ => Value(tipe.Z, v)
  }

  def eval(exp: Exp): Option[Value] = {
    val r: Option[Value] = exp match {
      case BooleanLit(v) => Some(Value(tipe.B, v))
      case Id(v) => store.get(v)
      case Size(e) => for (v <- eval(e)) yield (v: @unchecked) match {
        case Value(_, v: MS[_, _]) => Value(tipe.Z, v.size)
      }
      case Clone(id) => for (v <- eval(id)) yield (v: @unchecked) match {
        case Value(t, v: MS[_, _]) => Value(t, v.clone)
      }
      case exp: Result => Some(Value(exp.tipe, store.get("result")))
      case Apply(id, Seq(arg)) =>
        try for (Value(msType: tipe.MSeq, ms) <- eval(id);
                 Value(_, i) <- eval(arg)) yield ((ms, i): @unchecked) match {
          case (s: MS[_, _], _) => Value(msType.result, s.asInstanceOf[MS[Z, Value]](toZ(i)))
        } catch {
          case _: IndexOutOfBoundsException => None
        }
      case _: RandomInt => None
      case _: ReadInt => None
      case e: IntLit => Some(int2v(e.tpeOpt, _Z(e.normalize)))
      case e: FloatLit =>
        Some(e.primitiveValue match {
          case Left(v) => Value(tipe.F32, v)
          case Right(v) => Value(tipe.F64, v)
        })
      case e: RealLit => Some(Value(tipe.R, _R(e.value)))
      case e: IntMin =>
        if (e.bitWidth == 0) None
        else Some(int2v(Some(e.integralType), _Z(e.value)))
      case e: IntMax =>
        if (e.bitWidth == 0) None
        else Some(int2v(Some(e.integralType), _Z(e.value)))
      case _: Random => None
      case e: Mul =>
        for (Value(t, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(t, ((t, v1, v2): @unchecked) match {
          case (tipe.Z, v1: Z, v2: Z) => v1 * v2
          case (tipe.Z8, v1: Z8, v2: Z8) => Z.toZ8(v1 mul v2)
          case (tipe.Z16, v1: Z16, v2: Z16) => Z.toZ16(v1 mul v2)
          case (tipe.Z32, v1: Z32, v2: Z32) => Z.toZ32(v1 mul v2)
          case (tipe.Z64, v1: Z64, v2: Z64) => Z.toZ64(v1 mul v2)
          case (tipe.N, v1: N, v2: N) => v1 * v2
          case (tipe.N8, v1: N8, v2: N8) => Z.toN8(v1 mul v2)
          case (tipe.N16, v1: N16, v2: N16) => Z.toN16(v1 mul v2)
          case (tipe.N32, v1: N32, v2: N32) => Z.toN32(v1 mul v2)
          case (tipe.N64, v1: N64, v2: N64) => Z.toN64(v1 mul v2)
          case (tipe.S8, v1: S8, v2: S8) => v1 * v2
          case (tipe.S16, v1: S16, v2: S16) => v1 * v2
          case (tipe.S32, v1: S32, v2: S32) => v1 * v2
          case (tipe.S64, v1: S64, v2: S64) => v1 * v2
          case (tipe.U8, v1: U8, v2: U8) => v1 * v2
          case (tipe.U16, v1: U16, v2: U16) => v1 * v2
          case (tipe.U32, v1: U32, v2: U32) => v1 * v2
          case (tipe.U64, v1: U64, v2: U64) => v1 * v2
          case (tipe.R, v1: R, v2: R) => v1 * v2
          case (tipe.F32, v1: F32, v2: F32) => v1 * v2
          case (tipe.F64, v1: F64, v2: F64) => v1 * v2
        })
      case e: Div =>
        try for (Value(t, v1) <- eval(e.left);
                 Value(_, v2) <- eval(e.right)) yield Value(t, ((t, v1, v2): @unchecked) match {
          case (tipe.Z, v1: Z, v2: Z) => v1 / v2
          case (tipe.Z8, v1: Z8, v2: Z8) => Z.toZ8(v1 div v2)
          case (tipe.Z16, v1: Z16, v2: Z16) => Z.toZ16(v1 div v2)
          case (tipe.Z32, v1: Z32, v2: Z32) => Z.toZ32(v1 div v2)
          case (tipe.Z64, v1: Z64, v2: Z64) => Z.toZ64(v1 div v2)
          case (tipe.N, v1: N, v2: N) => v1 / v2
          case (tipe.N8, v1: N8, v2: N8) => Z.toN8(v1 div v2)
          case (tipe.N16, v1: N16, v2: N16) => Z.toN16(v1 div v2)
          case (tipe.N32, v1: N32, v2: N32) => Z.toN32(v1 div v2)
          case (tipe.N64, v1: N64, v2: N64) => Z.toN64(v1 div v2)
          case (tipe.S8, v1: S8, v2: S8) => v1 / v2
          case (tipe.S16, v1: S16, v2: S16) => v1 / v2
          case (tipe.S32, v1: S32, v2: S32) => v1 / v2
          case (tipe.S64, v1: S64, v2: S64) => v1 / v2
          case (tipe.U8, v1: U8, v2: U8) => v1 / v2
          case (tipe.U16, v1: U16, v2: U16) => v1 / v2
          case (tipe.U32, v1: U32, v2: U32) => v1 / v2
          case (tipe.U64, v1: U64, v2: U64) => v1 / v2
          case (tipe.R, v1: R, v2: R) => v1 / v2
          case (tipe.F32, v1: F32, v2: F32) => v1 / v2
          case (tipe.F64, v1: F64, v2: F64) => v1 / v2
        }) catch {
          case _: ArithmeticException => None
        }
      case e: Rem =>
        try for (Value(t, v1) <- eval(e.left);
                 Value(_, v2) <- eval(e.right)) yield Value(t, ((t, v1, v2): @unchecked) match {
          case (tipe.Z, v1: Z, v2: Z) => v1 % v2
          case (tipe.Z8, v1: Z8, v2: Z8) => Z.toZ8(v1 rem v2)
          case (tipe.Z16, v1: Z16, v2: Z16) => Z.toZ16(v1 rem v2)
          case (tipe.Z32, v1: Z32, v2: Z32) => Z.toZ32(v1 rem v2)
          case (tipe.Z64, v1: Z64, v2: Z64) => Z.toZ64(v1 rem v2)
          case (tipe.N, v1: N, v2: N) => v1 % v2
          case (tipe.N8, v1: N8, v2: N8) => Z.toN8(v1 rem v2)
          case (tipe.N16, v1: N16, v2: N16) => Z.toN16(v1 rem v2)
          case (tipe.N32, v1: N32, v2: N32) => Z.toN32(v1 rem v2)
          case (tipe.N64, v1: N64, v2: N64) => Z.toN64(v1 rem v2)
          case (tipe.S8, v1: S8, v2: S8) => v1 % v2
          case (tipe.S16, v1: S16, v2: S16) => v1 % v2
          case (tipe.S32, v1: S32, v2: S32) => v1 % v2
          case (tipe.S64, v1: S64, v2: S64) => v1 % v2
          case (tipe.U8, v1: U8, v2: U8) => v1 % v2
          case (tipe.U16, v1: U16, v2: U16) => v1 % v2
          case (tipe.U32, v1: U32, v2: U32) => v1 % v2
          case (tipe.U64, v1: U64, v2: U64) => v1 % v2
          case (tipe.R, v1: R, v2: R) => v1 % v2
          case (tipe.F32, v1: F32, v2: F32) => v1 % v2
          case (tipe.F64, v1: F64, v2: F64) => v1 % v2
        }) catch {
          case _: ArithmeticException => None
        }
      case e: Add =>
        for (Value(t, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(t, ((t, v1, v2): @unchecked) match {
          case (tipe.Z, v1: Z, v2: Z) => v1 + v2
          case (tipe.Z8, v1: Z8, v2: Z8) => Z.toZ8(v1 add v2)
          case (tipe.Z16, v1: Z16, v2: Z16) => Z.toZ16(v1 add v2)
          case (tipe.Z32, v1: Z32, v2: Z32) => Z.toZ32(v1 add v2)
          case (tipe.Z64, v1: Z64, v2: Z64) => Z.toZ64(v1 add v2)
          case (tipe.N, v1: N, v2: N) => v1 + v2
          case (tipe.N8, v1: N8, v2: N8) => Z.toN8(v1 add v2)
          case (tipe.N16, v1: N16, v2: N16) => Z.toN16(v1 add v2)
          case (tipe.N32, v1: N32, v2: N32) => Z.toN32(v1 add v2)
          case (tipe.N64, v1: N64, v2: N64) => Z.toN64(v1 add v2)
          case (tipe.S8, v1: S8, v2: S8) => v1 + v2
          case (tipe.S16, v1: S16, v2: S16) => v1 + v2
          case (tipe.S32, v1: S32, v2: S32) => v1 + v2
          case (tipe.S64, v1: S64, v2: S64) => v1 + v2
          case (tipe.U8, v1: U8, v2: U8) => v1 + v2
          case (tipe.U16, v1: U16, v2: U16) => v1 + v2
          case (tipe.U32, v1: U32, v2: U32) => v1 + v2
          case (tipe.U64, v1: U64, v2: U64) => v1 + v2
          case (tipe.R, v1: R, v2: R) => v1 + v2
          case (tipe.F32, v1: F32, v2: F32) => v1 + v2
          case (tipe.F64, v1: F64, v2: F64) => v1 + v2
        })
      case e: Sub =>
        for (Value(t, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(t, ((t, v1, v2): @unchecked) match {
          case (tipe.Z, v1: Z, v2: Z) => v1 - v2
          case (tipe.Z8, v1: Z8, v2: Z8) => Z.toZ8(v1 sub v2)
          case (tipe.Z16, v1: Z16, v2: Z16) => Z.toZ16(v1 sub v2)
          case (tipe.Z32, v1: Z32, v2: Z32) => Z.toZ32(v1 sub v2)
          case (tipe.Z64, v1: Z64, v2: Z64) => Z.toZ64(v1 sub v2)
          case (tipe.N, v1: N, v2: N) => v1 - v2
          case (tipe.N8, v1: N8, v2: N8) => Z.toN8(v1 sub v2)
          case (tipe.N16, v1: N16, v2: N16) => Z.toN16(v1 sub v2)
          case (tipe.N32, v1: N32, v2: N32) => Z.toN32(v1 sub v2)
          case (tipe.N64, v1: N64, v2: N64) => Z.toN64(v1 sub v2)
          case (tipe.S8, v1: S8, v2: S8) => v1 - v2
          case (tipe.S16, v1: S16, v2: S16) => v1 - v2
          case (tipe.S32, v1: S32, v2: S32) => v1 - v2
          case (tipe.S64, v1: S64, v2: S64) => v1 - v2
          case (tipe.U8, v1: U8, v2: U8) => v1 - v2
          case (tipe.U16, v1: U16, v2: U16) => v1 - v2
          case (tipe.U32, v1: U32, v2: U32) => v1 - v2
          case (tipe.U64, v1: U64, v2: U64) => v1 - v2
          case (tipe.R, v1: R, v2: R) => v1 - v2
          case (tipe.F32, v1: F32, v2: F32) => v1 - v2
          case (tipe.F64, v1: F64, v2: F64) => v1 - v2
        })
      case e: Lt =>
        for (Value(t, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(t, ((t, v1, v2): @unchecked) match {
          case (tipe.Z, v1: Z, v2: Z) => v1 < v2
          case (tipe.Z8, v1: Z8, v2: Z8) => v1 < v2
          case (tipe.Z16, v1: Z16, v2: Z16) => v1 < v2
          case (tipe.Z32, v1: Z32, v2: Z32) => v1 < v2
          case (tipe.Z64, v1: Z64, v2: Z64) => v1 < v2
          case (tipe.N, v1: N, v2: N) => v1 < v2
          case (tipe.N8, v1: N8, v2: N8) => v1 < v2
          case (tipe.N16, v1: N16, v2: N16) => v1 < v2
          case (tipe.N32, v1: N32, v2: N32) => v1 < v2
          case (tipe.N64, v1: N64, v2: N64) => v1 < v2
          case (tipe.S8, v1: S8, v2: S8) => v1 < v2
          case (tipe.S16, v1: S16, v2: S16) => v1 < v2
          case (tipe.S32, v1: S32, v2: S32) => v1 < v2
          case (tipe.S64, v1: S64, v2: S64) => v1 < v2
          case (tipe.U8, v1: U8, v2: U8) => v1 < v2
          case (tipe.U16, v1: U16, v2: U16) => v1 < v2
          case (tipe.U32, v1: U32, v2: U32) => v1 < v2
          case (tipe.U64, v1: U64, v2: U64) => v1 < v2
          case (tipe.R, v1: R, v2: R) => v1 < v2
          case (tipe.F32, v1: F32, v2: F32) => v1 < v2
          case (tipe.F64, v1: F64, v2: F64) => v1 < v2
        })
      case e: Le =>
        for (Value(t, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(t, ((t, v1, v2): @unchecked) match {
          case (tipe.Z, v1: Z, v2: Z) => v1 <= v2
          case (tipe.Z8, v1: Z8, v2: Z8) => v1 <= v2
          case (tipe.Z16, v1: Z16, v2: Z16) => v1 <= v2
          case (tipe.Z32, v1: Z32, v2: Z32) => v1 <= v2
          case (tipe.Z64, v1: Z64, v2: Z64) => v1 <= v2
          case (tipe.N, v1: N, v2: N) => v1 <= v2
          case (tipe.N8, v1: N8, v2: N8) => v1 <= v2
          case (tipe.N16, v1: N16, v2: N16) => v1 <= v2
          case (tipe.N32, v1: N32, v2: N32) => v1 <= v2
          case (tipe.N64, v1: N64, v2: N64) => v1 <= v2
          case (tipe.S8, v1: S8, v2: S8) => v1 <= v2
          case (tipe.S16, v1: S16, v2: S16) => v1 <= v2
          case (tipe.S32, v1: S32, v2: S32) => v1 <= v2
          case (tipe.S64, v1: S64, v2: S64) => v1 <= v2
          case (tipe.U8, v1: U8, v2: U8) => v1 <= v2
          case (tipe.U16, v1: U16, v2: U16) => v1 <= v2
          case (tipe.U32, v1: U32, v2: U32) => v1 <= v2
          case (tipe.U64, v1: U64, v2: U64) => v1 <= v2
          case (tipe.R, v1: R, v2: R) => v1 <= v2
          case (tipe.F32, v1: F32, v2: F32) => v1 <= v2
          case (tipe.F64, v1: F64, v2: F64) => v1 <= v2
        })
      case e: Gt =>
        for (Value(t, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(t, ((t, v1, v2): @unchecked) match {
          case (tipe.Z, v1: Z, v2: Z) => v1 > v2
          case (tipe.Z8, v1: Z8, v2: Z8) => v1 > v2
          case (tipe.Z16, v1: Z16, v2: Z16) => v1 > v2
          case (tipe.Z32, v1: Z32, v2: Z32) => v1 > v2
          case (tipe.Z64, v1: Z64, v2: Z64) => v1 > v2
          case (tipe.N, v1: N, v2: N) => v1 > v2
          case (tipe.N8, v1: N8, v2: N8) => v1 > v2
          case (tipe.N16, v1: N16, v2: N16) => v1 > v2
          case (tipe.N32, v1: N32, v2: N32) => v1 > v2
          case (tipe.N64, v1: N64, v2: N64) => v1 > v2
          case (tipe.S8, v1: S8, v2: S8) => v1 > v2
          case (tipe.S16, v1: S16, v2: S16) => v1 > v2
          case (tipe.S32, v1: S32, v2: S32) => v1 > v2
          case (tipe.S64, v1: S64, v2: S64) => v1 > v2
          case (tipe.U8, v1: U8, v2: U8) => v1 > v2
          case (tipe.U16, v1: U16, v2: U16) => v1 > v2
          case (tipe.U32, v1: U32, v2: U32) => v1 > v2
          case (tipe.U64, v1: U64, v2: U64) => v1 > v2
          case (tipe.R, v1: R, v2: R) => v1 > v2
          case (tipe.F32, v1: F32, v2: F32) => v1 > v2
          case (tipe.F64, v1: F64, v2: F64) => v1 > v2
        })
      case e: Ge =>
        for (Value(t, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(t, ((t, v1, v2): @unchecked) match {
          case (tipe.Z, v1: Z, v2: Z) => v1 >= v2
          case (tipe.Z8, v1: Z8, v2: Z8) => v1 >= v2
          case (tipe.Z16, v1: Z16, v2: Z16) => v1 >= v2
          case (tipe.Z32, v1: Z32, v2: Z32) => v1 >= v2
          case (tipe.Z64, v1: Z64, v2: Z64) => v1 >= v2
          case (tipe.N, v1: N, v2: N) => v1 >= v2
          case (tipe.N8, v1: N8, v2: N8) => v1 >= v2
          case (tipe.N16, v1: N16, v2: N16) => v1 >= v2
          case (tipe.N32, v1: N32, v2: N32) => v1 >= v2
          case (tipe.N64, v1: N64, v2: N64) => v1 >= v2
          case (tipe.S8, v1: S8, v2: S8) => v1 >= v2
          case (tipe.S16, v1: S16, v2: S16) => v1 >= v2
          case (tipe.S32, v1: S32, v2: S32) => v1 >= v2
          case (tipe.S64, v1: S64, v2: S64) => v1 >= v2
          case (tipe.U8, v1: U8, v2: U8) => v1 >= v2
          case (tipe.U16, v1: U16, v2: U16) => v1 >= v2
          case (tipe.U32, v1: U32, v2: U32) => v1 >= v2
          case (tipe.U64, v1: U64, v2: U64) => v1 >= v2
          case (tipe.R, v1: R, v2: R) => v1 >= v2
          case (tipe.F32, v1: F32, v2: F32) => v1 >= v2
          case (tipe.F64, v1: F64, v2: F64) => v1 >= v2
        })
      case e: Shr =>
        for (Value(t, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(t, ((v1, v2): @unchecked) match {
          case (v1: S8, v2: S8) => v1 >> v2
          case (v1: S16, v2: S16) => v1 >> v2
          case (v1: S32, v2: S32) => v1 >> v2
          case (v1: S64, v2: S64) => v1 >> v2
        })
      case e: UShr =>
        for (Value(t, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(t, ((v1, v2): @unchecked) match {
          case (v1: S8, v2: S8) => v1 >>> v2
          case (v1: S16, v2: S16) => v1 >>> v2
          case (v1: S32, v2: S32) => v1 >>> v2
          case (v1: S64, v2: S64) => v1 >>> v2
          case (v1: U8, v2: U8) => v1 >>> U8_Ext.toZ32(v2)
          case (v1: U16, v2: U16) => v1 >>> U16_Ext.toZ32(v2)
          case (v1: U32, v2: U32) => v1 >>> U32_Ext.toZ32(v2)
          case (v1: U64, v2: U64) => v1 >>> U64_Ext.toZ32(v2)
        })
      case e: Shl =>
        for (Value(t, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(t, ((v1, v2): @unchecked) match {
          case (v1: S8, v2: S8) => v1 << v2
          case (v1: S16, v2: S16) => v1 << v2
          case (v1: S32, v2: S32) => v1 << v2
          case (v1: S64, v2: S64) => v1 << v2
          case (v1: U8, v2: U8) => v1 << U8_Ext.toZ32(v2)
          case (v1: U16, v2: U16) => v1 << U16_Ext.toZ32(v2)
          case (v1: U32, v2: U32) => v1 << U32_Ext.toZ32(v2)
          case (v1: U64, v2: U64) => v1 << U64_Ext.toZ32(v2)
        })
      case e: Eq =>
        for (Value(_, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(tipe.B, v1 == v2)
      case e: Ne =>
        for (Value(_, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(tipe.B, v1 != v2)
      case e: Append =>
        for (Value(v1Type, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield ((v1, v2): @unchecked) match {
          case (v1: MS[_, _], v2: Any) => Value(v1Type, v1.asInstanceOf[MS[Z, Any]] :+ v2)
        }
      case e: Prepend =>
        for (Value(v1Type, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield ((v2, v1): @unchecked) match {
          case (v2: MS[_, _], v1: Any) => Value(v1Type, v1 +: v2.asInstanceOf[MS[Z, Any]])
        }
      case e: And =>
        for (Value(t, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(t, ((v1, v2): @unchecked) match {
          case (v1: Boolean, v2: Boolean) => v1 & v2
          case (v1: S8, v2: S8) => v1 & v2
          case (v1: S16, v2: S16) => v1 & v2
          case (v1: S32, v2: S32) => v1 & v2
          case (v1: S64, v2: S64) => v1 & v2
          case (v1: U8, v2: U8) => v1 & v2
          case (v1: U16, v2: U16) => v1 & v2
          case (v1: U32, v2: U32) => v1 & v2
          case (v1: U64, v2: U64) => v1 & v2
        })
      case e: Xor =>
        for (Value(t, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(t, ((v1, v2): @unchecked) match {
          case (v1: Boolean, v2: Boolean) => v1 ^ v2
          case (v1: S8, v2: S8) => v1 ^ v2
          case (v1: S16, v2: S16) => v1 ^ v2
          case (v1: S32, v2: S32) => v1 ^ v2
          case (v1: S64, v2: S64) => v1 ^ v2
          case (v1: U8, v2: U8) => v1 ^ v2
          case (v1: U16, v2: U16) => v1 ^ v2
          case (v1: U32, v2: U32) => v1 ^ v2
          case (v1: U64, v2: U64) => v1 ^ v2
        })
      case e: Or =>
        for (Value(t, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield Value(t, ((v1, v2): @unchecked) match {
          case (v1: Boolean, v2: Boolean) => v1 | v2
          case (v1: S8, v2: S8) => v1 | v2
          case (v1: S16, v2: S16) => v1 | v2
          case (v1: S32, v2: S32) => v1 | v2
          case (v1: S64, v2: S64) => v1 | v2
          case (v1: U8, v2: U8) => v1 | v2
          case (v1: U16, v2: U16) => v1 | v2
          case (v1: U32, v2: U32) => v1 | v2
          case (v1: U64, v2: U64) => v1 | v2
        })
      case e: Implies =>
        for (Value(_, v1) <- eval(e.left);
             Value(_, v2) <- eval(e.right)) yield ((v1, v2): @unchecked) match {
          case (v1: Boolean, v2: Boolean) => Value(tipe.B, !v1 | v2)
        }
      case e: Not =>
        for (Value(t, v) <- eval(e.exp)) yield Value(t, (v: @unchecked) match {
          case v: Boolean => !v
          case v: S8 => ~v
          case v: S16 => ~v
          case v: S32 => ~v
          case v: S64 => ~v
          case v: U8 => ~v
          case v: U16 => ~v
          case v: U32 => ~v
          case v: U64 => ~v
        })
      case e: Minus =>
        for (Value(t, v) <- eval(e.exp)) yield Value(t, (v: @unchecked) match {
          case v: Z => -v
          case v: S8 => -v
          case v: S16 => -v
          case v: S32 => -v
          case v: S64 => -v
          case v: R => -v
          case v: F32 => -v
          case v: F64 => -v
        })
      case _: ForAll => None
      case _: Exists => None
      case e: SeqLit =>
        var args = ivectorEmpty[Any]
        for (e <- e.args) eval(e) match {
          case Some(Value(_, arg)) => args :+= arg
          case _ => return None
        }
        Some(e.tpe match {
          case _: BSType => Value(tipe.BS, BS(args.map(_.asInstanceOf[Boolean]): _*))
          case _: ZSType => Value(tipe.ZS, ZS(args.map(_.asInstanceOf[Z]): _*))
          case _: Z8SType => Value(tipe.Z8S, Z8S(args.map(_.asInstanceOf[Z8]): _*))
          case _: Z16SType => Value(tipe.Z16S, Z16S(args.map(_.asInstanceOf[Z16]): _*))
          case _: Z32SType => Value(tipe.Z32S, Z32S(args.map(_.asInstanceOf[Z32]): _*))
          case _: Z64SType => Value(tipe.Z64S, Z64S(args.map(_.asInstanceOf[Z64]): _*))
          case _: NSType => Value(tipe.NS, NS(args.map(_.asInstanceOf[N]): _*))
          case _: N8SType => Value(tipe.N8S, N8S(args.map(_.asInstanceOf[N8]): _*))
          case _: N16SType => Value(tipe.N16S, N16S(args.map(_.asInstanceOf[N16]): _*))
          case _: N32SType => Value(tipe.N32S, N32S(args.map(_.asInstanceOf[N32]): _*))
          case _: N64SType => Value(tipe.N64S, N64S(args.map(_.asInstanceOf[N64]): _*))
          case _: S8SType => Value(tipe.S8S, S8S(args.map(_.asInstanceOf[S8]): _*))
          case _: S16SType => Value(tipe.S16S, S16S(args.map(_.asInstanceOf[S16]): _*))
          case _: S32SType => Value(tipe.S32S, S32S(args.map(_.asInstanceOf[S32]): _*))
          case _: S64SType => Value(tipe.S64S, S64S(args.map(_.asInstanceOf[S64]): _*))
          case _: U8SType => Value(tipe.U8S, U8S(args.map(_.asInstanceOf[U8]): _*))
          case _: U16SType => Value(tipe.U16S, U16S(args.map(_.asInstanceOf[U16]): _*))
          case _: U32SType => Value(tipe.U32S, U32S(args.map(_.asInstanceOf[U32]): _*))
          case _: U64SType => Value(tipe.U64S, U64S(args.map(_.asInstanceOf[U64]): _*))
          case _: RSType => Value(tipe.RS, RS(args.map(_.asInstanceOf[R]): _*))
          case _: F32SType => Value(tipe.F32S, F32S(args.map(_.asInstanceOf[F32]): _*))
          case _: F64SType => Value(tipe.F64S, F64S(args.map(_.asInstanceOf[F64]): _*))
        })
    }
    r.map({
      case Value(tipe.S8, n: Int) => Value(tipe.S8, n.toByte)
      case Value(tipe.S16, n: Int) => Value(tipe.S8, n.toShort)
      case v => v
    })
  }

  import scala.language.implicitConversions

  final implicit class ZOp(n: Any) {
    def add(m: Any): Z = toZ(n) + toZ(m)
    def sub(m: Any): Z = toZ(n) - toZ(m)
    def mul(m: Any): Z = toZ(n) * toZ(m)
    def div(m: Any): Z = toZ(n) / toZ(m)
    def rem(m: Any): Z = toZ(n) % toZ(m)
  }
}
