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

package org.sireum.logika

import org.sireum.util.{LocationInfo, Visitor, _}

private abstract class
SymExeProofContext[T <: SymExeProofContext[T]](implicit reporter: AccumulatingTagReporter) extends ProofContext[T] {
  final val isSymExe = true
  final var validCache = imapEmpty[(ISeq[ast.Exp], ISeq[ast.Exp]), Boolean]
  final val unboundedBitWidth = bitWidth == 0
  final lazy val zMin = ast.IntMin(bitWidth, ast.ZType())
  final lazy val zMax = ast.IntMax(bitWidth, ast.ZType())
  final val z8Min = ast.IntMin(8, ast.Z8Type())
  final val z8Max = ast.IntMax(8, ast.Z8Type())
  final val z16Min = ast.IntMin(16, ast.Z16Type())
  final val z16Max = ast.IntMax(16, ast.Z16Type())
  final val z32Min = ast.IntMin(32, ast.Z32Type())
  final val z32Max = ast.IntMax(32, ast.Z32Type())
  final val z64Min = ast.IntMin(64, ast.Z64Type())
  final val z64Max = ast.IntMax(64, ast.Z64Type())
  final val nMin = Checker.zero
  final lazy val nMax = ast.IntMax(bitWidth, ast.NType())
  final val n8Max = ast.IntMax(8, ast.N8Type())
  final val n16Max = ast.IntMax(16, ast.N16Type())
  final val n32Max = ast.IntMax(32, ast.N32Type())
  final val n64Max = ast.IntMax(64, ast.N64Type())
  final val topConclusion = ivector(Checker.top)

  final override def isValid(title: String, li: LocationInfo,
                             premises: => Iterable[ast.Exp],
                             conclusions: Iterable[ast.Exp]): Boolean = {
    val key = (premises.toVector, conclusions.toVector)
    validCache.get(key) match {
      case Some(r) => r
      case _ =>
        val r = super.isValid(title, li, premises, conclusions)
        validCache += key -> r
        r
    }
  }

  final override def hasRuntimeError(stmt: ast.Stmt): Boolean = {
    import ast.Exp
    def zRange(id: ast.Id, lo: Exp, hi: Exp): ast.And =
      Exp.And(tipe.B, Exp.Le(tipe.Z, lo, id), Exp.Le(tipe.Z, id, hi))
    def nRange(id: ast.Id, lo: Exp, hi: Exp): ast.Exp =
      if (lo == hi) Exp.Le(tipe.Z, lo, id)
      else Exp.And(tipe.B, Exp.Le(tipe.Z, lo, id), Exp.Le(tipe.Z, id, hi))
    def zForAll(ids: ast.Node.Seq[ast.Id], t: ast.Type, lo: ast.Exp, hi: ast.Exp, e: Exp): ast.ForAll =
      ast.ForAll(ids, Some(ast.TypeDomain(t)), Exp.Implies(tipe.B, Exp.And(ids.map(zRange(_, lo, hi))), e))
    def zExists(ids: ast.Node.Seq[ast.Id], t: ast.Type, lo: ast.Exp, hi: ast.Exp, e: Exp): ast.Exists =
      ast.Exists(ids, Some(ast.TypeDomain(t)), Exp.And(tipe.B, Exp.And(ids.map(zRange(_, lo, hi))), e))
    def nForAll(ids: ast.Node.Seq[ast.Id], t: ast.Type, lo: ast.Exp, ignored: Exp, e: Exp): ast.ForAll =
      ast.ForAll(ids, Some(ast.TypeDomain(t)), Exp.Implies(tipe.B, Exp.And(ids.map(nRange(_, lo, lo))), e))
    def nExists(ids: ast.Node.Seq[ast.Id], t: ast.Type, lo: ast.Exp, ignored: Exp, e: Exp): ast.Exists =
      ast.Exists(ids, Some(ast.TypeDomain(t)), Exp.And(tipe.B, Exp.And(ids.map(nRange(_, lo, lo))), e))
    var _ps: Option[ISeq[ast.Exp]] = None
    def ps: ISeq[ast.Exp] = {
      if (_ps.isDefined) return _ps.get
      def rwQuant(q: ast.Quant[_],
                  apply: (ast.Node.Seq[ast.Id], ast.Type, ast.Exp, ast.Exp, ast.Exp) => ast.Quant[_],
                  ids: ast.Node.Seq[ast.Id],
                  qdOpt: Option[ast.QuantDomain],
                  e: ast.Exp,
                  t: ast.Type): ast.Quant[_] = t match {
        case t: ast.ZType if bitWidth != 0 => apply(ids, t, zMin, zMax, e)
        case t: ast.Z8Type => apply(ids, t, z8Min, z8Max, e)
        case t: ast.Z16Type => apply(ids, t, z16Min, z16Max, e)
        case t: ast.Z32Type => apply(ids, t, z32Min, z32Max, e)
        case t: ast.Z64Type => apply(ids, t, z64Min, z64Max, e)
        case t: ast.NType => apply(ids, t, nMin, if (bitWidth == 0) nMin else nMax, e)
        case t: ast.N8Type => apply(ids, t, nMin, n8Max, e)
        case t: ast.N16Type => apply(ids, t, nMin, n16Max, e)
        case t: ast.N32Type => apply(ids, t, nMin, n32Max, e)
        case t: ast.N64Type => apply(ids, t, nMin, n64Max, e)
        case _ => q
      }
      val rw = ast.Rewriter.build[Exp]()({
        case q@ast.ForAll(ids, qdOpt@Some(ast.TypeDomain(t: ast.NType)), e) if bitWidth == 0 =>
          rwQuant(q, nForAll, ids, qdOpt, e, t)
        case q@ast.Exists(ids, qdOpt@Some(ast.TypeDomain(t: ast.NType)), e) if bitWidth == 0 =>
          rwQuant(q, nExists, ids, qdOpt, e, t)
        case q@ast.ForAll(ids, qdOpt@Some(ast.TypeDomain(t)), e) =>
          rwQuant(q, zForAll, ids, qdOpt, e, t)
        case q@ast.Exists(ids, qdOpt@Some(ast.TypeDomain(t)), e) =>
          rwQuant(q, zExists, ids, qdOpt, e, t)
      })
      var integralIds = isetEmpty[String]
      var r = ivectorEmpty[Exp]
      lazy val visitor: Any => Boolean = Visitor.build({
        case q: ast.Quant[_] =>
          val ids = q.ids.map(_.value)
          integralIds ++= ids
          visitor(q.domainOpt)
          visitor(q.exp)
          integralIds --= ids
          false
        case id: ast.Id if !integralIds.contains(id.value) && id.tipe.isInstanceOf[tipe.IntegralTipe] =>
          id.tipe match {
            case tipe.Z if bitWidth != 0 => r :+= zRange(id, zMin, zMax)
            case tipe.Z8 => r :+= zRange(id, z8Min, z8Max)
            case tipe.Z16 => r :+= zRange(id, z16Min, z16Max)
            case tipe.Z32 => r :+= zRange(id, z32Min, z32Max)
            case tipe.Z64 => r :+= zRange(id, z64Min, z64Max)
            case tipe.N =>
              if (bitWidth == 0) r :+= nRange(id, nMin, nMin)
              else r :+= nRange(id, nMin, nMax)
            case tipe.N8 => r :+= nRange(id, nMin, n8Max)
            case tipe.N16 => r :+= nRange(id, nMin, n16Max)
            case tipe.N32 => r :+= nRange(id, nMin, n32Max)
            case tipe.N64 => r :+= nRange(id, nMin, n64Max)
            case _ =>
          }
          integralIds += id.value
          false
      })
      for (p <- facts.values.toVector ++ premises) {
        r :+= rw(p)
        visitor(p)
      }
      _ps = Some(r)
      r
    }
    var hasError = false
    def divisor(e: Exp, t: tipe.IntegralTipe): Boolean = {
      val tpe = t match {
        case tipe.Z => ast.ZType()
        case tipe.Z8 => ast.Z8Type()
        case tipe.Z16 => ast.Z16Type()
        case tipe.Z32 => ast.Z32Type()
        case tipe.Z64 => ast.Z64Type()
        case tipe.N => ast.NType()
        case tipe.N8 => ast.N8Type()
        case tipe.N16 => ast.N16Type()
        case tipe.N32 => ast.N32Type()
        case tipe.N64 => ast.N64Type()
        case tipe.S8 => ast.S8Type()
        case tipe.S16 => ast.S16Type()
        case tipe.S32 => ast.S32Type()
        case tipe.S64 => ast.S64Type()
        case tipe.U8 => ast.U8Type()
        case tipe.U16 => ast.U16Type()
        case tipe.U32 => ast.U32Type()
        case tipe.U64 => ast.U64Type()
      }
      val req = Exp.Ne(t, e, ast.IntLit("0", tpe.bitWidth, Some(tpe)))
      if (!isValid("division", nodeLocMap(e), ps, ivector(req))) {
        error(e, s"Could not automatically deduce that the divisor is non-zero.")
        hasError = true
      }
      true
    }
    def index(a: Exp, aTipe: tipe.Tipe, e: Exp): Boolean = {
      val req1 = Exp.Le(tipe.Z, Checker.zero, e)
      req1.tipe = tipe.Z
      val sz = Exp.Size(tipe.Z, a)
      sz.tipe = aTipe
      val req2 = Exp.Lt(tipe.Z, e, sz)
      req2.tipe = tipe.Z
      if (!isValid("indexing low-bound", nodeLocMap(e), ps, ivector(req1))) {
        hasError = true
        error(e, "Could not automatically deduce that the sequence index is non-negative.")
      }
      if (!isValid("indexing high-bound", nodeLocMap(e), ps, ivector(req2))) {
        hasError = true
        error(e, s"Could not automatically deduce that the index is less than the sequence size.")
      }
      true
    }
    def rangeCheck(t: tipe.Tipe, ts: String, e: Exp, min: Exp, max: Exp): Unit = {
      val es = Exp.toString(e, inProof = true)
      val lReq = Exp.Le(t, min, e)
      if (!isValid(s"$ts.Min ≤ $es", nodeLocMap(e), ps, ivector(lReq))) {
        error(e, s"Could not automatically deduce that the operation does not underflow (${Exp.toString(min, inProof = false)}).")
        hasError = true
      }
      val hReq = Exp.Le(t, e, max)
      if (!isValid(s"$es ≤ $ts.Max", nodeLocMap(e), ps, ivector(hReq))) {
        error(e, s"Could not automatically deduce that the operation does not overflow (${Exp.toString(max, inProof = false)}).")
        hasError = true
      }
    }

    def rangeCheckTipe(e: Exp, t: tipe.Tipe): Unit = t match {
      case tipe.Z if bitWidth != 0 => rangeCheck(tipe.Z, "Z", e, zMin, zMax)
      case tipe.Z8 => rangeCheck(tipe.Z8, "Z8", e, z8Min, z8Max)
      case tipe.Z16 => rangeCheck(tipe.Z16, "Z16", e, z16Min, z16Max)
      case tipe.Z32 => rangeCheck(tipe.Z32, "Z32", e, z32Min, z32Max)
      case tipe.Z64 => rangeCheck(tipe.Z64, "Z64", e, z64Min, z64Max)
      case tipe.N if bitWidth != 0 => rangeCheck(tipe.N, "N", e, nMin, nMax)
      case tipe.N8 => rangeCheck(tipe.N8, "N8", e, nMin, n8Max)
      case tipe.N16 => rangeCheck(tipe.N16, "N16", e, nMin, n16Max)
      case tipe.N32 => rangeCheck(tipe.N32, "N32", e, nMin, n32Max)
      case tipe.N64 => rangeCheck(tipe.N64, "N64", e, nMin, n64Max)
      case _ =>
    }

    def nonNegativeCheck(e: Exp, t: tipe.Tipe): Unit = {
      val es = Exp.toString(e, inProof = true)
      val zero = t.asInstanceOf[tipe.ModuloIntegralTipe] match {
        case tipe.S8 => ast.IntLit("0", 8, Some(ast.S8Type()))
        case tipe.S16 => ast.IntLit("0", 16, Some(ast.S16Type()))
        case tipe.S32 => ast.IntLit("0", 32, Some(ast.S32Type()))
        case tipe.S64 => ast.IntLit("0", 64, Some(ast.S64Type()))
        case tipe.U8 => ast.IntLit("0", 8, Some(ast.U8Type()))
        case tipe.U16 => ast.IntLit("0", 16, Some(ast.U16Type()))
        case tipe.U32 => ast.IntLit("0", 32, Some(ast.U32Type()))
        case tipe.U64 => ast.IntLit("0", 64, Some(ast.U64Type()))
      }
      val req = Exp.Le(t, zero, e)
      if (!isValid(s"0 ≤ $es", nodeLocMap(e), ps, ivector(req))) {
        error(e, s"Could not automatically deduce that the shift right-operand is non-negative.")
        hasError = true
      }
    }

    Visitor.build({
      case _: ast.Block => false
      case _: ast.LoopInv => false
      case e: ast.Add => rangeCheckTipe(e, e.tipe); false
      case e: ast.Sub => rangeCheckTipe(e, e.tipe); false
      case e: ast.Mul => rangeCheckTipe(e, e.tipe); false
      case e: ast.Div => rangeCheckTipe(e, e.tipe); divisor(e.right, e.tipe.asInstanceOf[tipe.IntegralTipe]); false
      case e: ast.Rem => rangeCheckTipe(e, e.tipe); divisor(e.right, e.tipe.asInstanceOf[tipe.IntegralTipe]); false
      case e: ast.Minus => rangeCheckTipe(e, e.tipe); false
      case e: ast.Shl => nonNegativeCheck(e.right, e.tipe); false
      case e: ast.Shr => nonNegativeCheck(e.right, e.tipe); false
      case e: ast.UShr => nonNegativeCheck(e.right, e.tipe); false
      case a@ast.Apply(exp, Seq(arg)) if a.expTipe.isInstanceOf[tipe.MSeq] => index(exp, a.expTipe, arg)
      case ast.SeqAssign(id, e, _) => index(id, id.tipe, e)
    })(stmt)
    hasError
  }

  final def oldId(id: ast.Id): ast.Id = ast.Exp.Id(id.tipe, s"${id.value}_old")

  final def filter(premises: ILinkedSet[ast.Exp]): ILinkedSet[ast.Exp] = {
    def keep(e: ast.Exp) = {
      var r = true
      Visitor.build({
        case ast.Id(value) if value.endsWith("_result") =>
          r = false
          false
      })(e)
      r
    }
    premises.filter(keep)
  }
}
