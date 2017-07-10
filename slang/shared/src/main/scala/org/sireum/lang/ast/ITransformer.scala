// #Sireum
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

package org.sireum.lang.ast

import org.sireum._

object ITransformer {

  @datatype class PreResult[Context, T](ctx: Context,
                                        continue: B,
                                        resultOpt: Option[T])

  @datatype class Result[Context, T](ctx: Context,
                                     resultOpt: Option[T])

  @sig trait Pre[Context] {

    @pure def transformTopUnit(ctx: Context, topUnit: TopUnit): PreResult[Context, TopUnit] = {
      topUnit match {
        case topUnit: TopUnit.Program => transformProgram(ctx, topUnit)
        case topUnit: TopUnit.SequentUnit => transformSequentUnit(ctx, topUnit)
        case topUnit: TopUnit.TruthTableUnit => transformTruthTableUnit(ctx, topUnit)
      }
    }

    @pure def transformProgram(ctx: Context, program: TopUnit.Program): PreResult[Context, TopUnit] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformSequentUnit(ctx: Context, sequent: TopUnit.SequentUnit): PreResult[Context, TopUnit] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformTruthTableUnit(ctx: Context, truthTable: TopUnit.TruthTableUnit): PreResult[Context, TopUnit] = {
      return PreResult(ctx, T, None())
    }

  }

  @sig trait Post[Context] {

    @pure def transformTopUnit(ctx: Context, topUnit: TopUnit): Result[Context, TopUnit] = {
      topUnit match {
        case topUnit: TopUnit.Program => transformProgram(ctx, topUnit)
        case topUnit: TopUnit.SequentUnit => transformSequentUnit(ctx, topUnit)
        case topUnit: TopUnit.TruthTableUnit => transformTruthTableUnit(ctx, topUnit)
      }
    }

    @pure def transformProgram(ctx: Context, program: TopUnit.Program): Result[Context, TopUnit] = {
      return Result(ctx, None())
    }

    @pure def transformSequentUnit(ctx: Context, sequent: TopUnit.SequentUnit): Result[Context, TopUnit] = {
      return Result(ctx, None())
    }

    @pure def transformTruthTableUnit(ctx: Context, truthTable: TopUnit.TruthTableUnit): Result[Context, TopUnit] = {
      return Result(ctx, None())
    }
  }

  @pure def transformOption[Context, T](ctx: Context, option: Option[T], @pure f: (Context, T) => Result[Context, T]): Result[Context, Option[T]] = {
    option match {
      case Some(v) =>
        val r = f(ctx, v)
        r.resultOpt match {
          case Some(_) => return Result(r.ctx, Some(r.resultOpt))
          case _ => return Result(r.ctx, None())
        }
      case _ => return Result(ctx, None())
    }
  }

  @pure def transformISZ[Context, T](ctx: Context, s: IS[Z, T], @pure f: (Context, T) => Result[Context, T]): Result[Context, IS[Z, T]] = {
    val s2 = SI.toMS(s)
    var changed = F
    var ctxi = ctx
    for (i <- s2.indices) {
      val e = s(i)
      val r = f(ctxi, e)
      ctxi = r.ctx
      changed = changed | r.resultOpt.nonEmpty
      s2(i) = r.resultOpt.getOrElse(e)
    }
    if (changed) {
      return Result(ctxi, Some(SM.toIS(s2)))
    } else {
      return Result(ctxi, None())
    }
  }

  @pure def transformMSZ[Context, T](ctx: Context, s: MS[Z, T], @pure f: (Context, T) => Result[Context, T]): Result[Context, MS[Z, T]] = {
    var s2 = MS[Z, T]()
    var changed = F
    var ctxi = ctx
    for (i <- s2.indices) {
      val e = s(i)
      val r = f(ctxi, e)
      ctxi = r.ctx
      changed = changed | r.resultOpt.nonEmpty
      s2 = s2 :+ r.resultOpt.getOrElse(e)
    }
    if (changed) {
      return Result(ctxi, Some(s2))
    } else {
      return Result(ctxi, None())
    }
  }

}

import ITransformer._

@datatype class ITransformer[Context](pre: Pre[Context], post: Post[Context]) {

  @pure def transformTopUnit(ctx: Context, topUnit: TopUnit): Result[Context, TopUnit] = {
    val preR = pre.transformTopUnit(ctx, topUnit)
    val r: Result[Context, TopUnit] = if (preR.continue) {
      transformTopUnitCont(preR.ctx, preR.resultOpt.getOrElse(topUnit), preR.resultOpt.nonEmpty)
    } else if (preR.resultOpt.nonEmpty) {
      Result(preR.ctx, Some(preR.resultOpt.getOrElse(topUnit)))
    } else {
      Result(preR.ctx, None())
    }
    val hasChanged = r.resultOpt.nonEmpty
    val temp = r.resultOpt.getOrElse(topUnit)
    val postR = post.transformTopUnit(ctx, temp)
    if (postR.resultOpt.nonEmpty) {
      return postR
    } else if (hasChanged) {
      return Result(postR.ctx, Some(temp))
    } else {
      return Result(postR.ctx, None())
    }
  }

  @pure def transformTopUnitCont(ctx: Context, topUnit: TopUnit, hasChanged: B): Result[Context, TopUnit] = {
    topUnit match {
      case topUnit@TopUnit.Program(_, packageName, body) =>
        val r1 = transformName(ctx, packageName)
        val r2 = transformBody(r1.ctx, body)
        if (hasChanged | r1.resultOpt.nonEmpty | r2.resultOpt.nonEmpty) {
          return Result(r2.ctx, Some(topUnit(packageName = r1.resultOpt.getOrElse(packageName), body = r2.resultOpt.getOrElse(body))))
        } else {
          return Result(r2.ctx, None())
        }
      case topUnit@TopUnit.SequentUnit(_, sequent) =>
        val r1 = transformSequent(ctx, sequent)
        if (hasChanged | r1.resultOpt.nonEmpty) {
          return Result(r1.ctx, Some(topUnit(sequent = r1.resultOpt.getOrElse(sequent))))
        } else {
          return Result(r1.ctx, None())
        }
      case topUnit@TopUnit.TruthTableUnit(_, _, vars, _, _, sequent, rows, conclusionOpt) =>
        val r1 = transformISZ(ctx, vars, transformId _)
        val r2 = transformSequent(r1.ctx, sequent)
        val r3 = transformISZ(r2.ctx, rows, transformRow _)
        val r4 = transformOption(r3.ctx, conclusionOpt, transformConclusion _)
        if (hasChanged | r1.resultOpt.nonEmpty | r2.resultOpt.nonEmpty | r3.resultOpt.nonEmpty | r4.resultOpt.nonEmpty) {
          return Result(r4.ctx, Some(topUnit(vars = r1.resultOpt.getOrElse(vars), sequent = r2.resultOpt.getOrElse(sequent), rows = r3.resultOpt.getOrElse(rows), conclusionOpt = r4.resultOpt.getOrElse(conclusionOpt))))
        } else {
          return Result(r4.ctx, None())
        }
    }
  }

  @pure def transformName(ctx: Context, name: Name): Result[Context, Name] = {
    ???
  }

  @pure def transformBody(ctx: Context, body: Body): Result[Context, Body] = {
    ???
  }

  @pure def transformSequent(ctx: Context, sequent: LClause.Sequent): Result[Context, LClause.Sequent] = {
    ???
  }

  @pure def transformId(ctx: Context, id: Id): Result[Context, Id] = {
    ???
  }

  @pure def transformRow(ctx: Context, row: TruthTable.Row): Result[Context, TruthTable.Row] = {
    ???
  }

  @pure def transformConclusion(ctx: Context, conclusion: TruthTable.Conclusion): Result[Context, TruthTable.Conclusion] = {
    ???
  }
}

