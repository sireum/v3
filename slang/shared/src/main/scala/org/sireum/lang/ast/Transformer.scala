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

object Transformer {

  @datatype class PreResult[Context, T](ctx: Context,
                                        continue: B,
                                        resultOpt: Option[T])

  @datatype class Result[Context, T](ctx: Context,
                                     resultOpt: Option[T])

  @sig trait Pre[Context] {

    @pure def transformProgram(ctx: Context, program: TopUnit.Program): PreResult[Context, TopUnit] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformSequent(ctx: Context, sequent: TopUnit.Sequent): PreResult[Context, TopUnit] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformTruthTable(ctx: Context, truthTable: TopUnit.TruthTable): PreResult[Context, TopUnit] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformName(ctx: Context, name: Name): PreResult[Context, Name] = {
      return PreResult(ctx, T, None())
    }

    @pure def transformBody(ctx: Context, body: Body): PreResult[Context, Body] = {
      return PreResult(ctx, T, None())
    }

  }

  @sig trait Post[Context] {

    @pure def transformProgram(ctx: Context, program: TopUnit.Program): Result[Context, TopUnit] = {
      return Result(ctx, None())
    }

    @pure def transformSequent(ctx: Context, sequent: TopUnit.Sequent): Result[Context, TopUnit] = {
      return Result(ctx, None())
    }

    @pure def transformTruthTable(ctx: Context, truthTable: TopUnit.TruthTable): Result[Context, TopUnit] = {
      return Result(ctx, None())
    }
  }

  @datatype class TopDown[Context](pre: Pre[Context]) {

    @pure def transformTopUnit(ctx: Context, topUnit: TopUnit): Result[Context, TopUnit] = {
      val r: PreResult[Context, TopUnit] = topUnit match {
        case topUnit: TopUnit.Program => pre.transformProgram(ctx, topUnit)
        case topUnit: TopUnit.Sequent => pre.transformSequent(ctx, topUnit)
        case topUnit: TopUnit.TruthTable => pre.transformTruthTable(ctx, topUnit)
      }
      if (r.continue) {
        return transformTopUnitCont(r.ctx, r.resultOpt.getOrElse(topUnit), r.resultOpt.nonEmpty)
      } else if (r.resultOpt.nonEmpty) {
        return Result(r.ctx, Some(r.resultOpt.getOrElse(topUnit)))
      } else {
        return Result(r.ctx, None())
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
        case topUnit@TopUnit.Sequent(_, sequent) =>
          val r1 = transformSequent(ctx, sequent)
          if (hasChanged | r1.resultOpt.nonEmpty) {
            return Result(r1.ctx, Some(topUnit(sequent = r1.resultOpt.getOrElse(sequent))))
          } else {
            return Result(r1.ctx, None())
          }
        case topUnit@TopUnit.TruthTable(_, _, vars, _, _, sequent, rows, conclusionOpt) =>
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

    @pure def transformISZ[T](ctx: Context, is: IS[Z, T], @pure f: (Context, T) => Result[Context, T]): Result[Context, IS[Z, T]] = {
      var is2 = ISZ[T]()
      var changed = F
      var ctxi = ctx
      for (e <- is) {
        val r = f(ctxi, e)
        ctxi = r.ctx
        changed = changed | r.resultOpt.nonEmpty
        is2 = is2 :+ r.resultOpt.getOrElse(e)
      }
      if (changed) {
        return Result(ctxi, Some(is2))
      } else {
        return Result(ctxi, None())
      }
    }

    @pure def transformOption[T](ctx: Context, option: Option[T], @pure f: (Context, T) => Result[Context, T]): Result[Context, Option[T]] = {
      option match {
        case Some(v) =>
          val r = f(ctx, v)
          r.resultOpt match {
            case Some(_) => Result(r.ctx, Some(r.resultOpt))
            case _ => Result(r.ctx, None())
          }
        case _ => return Result(ctx, None())
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

  /*
    object BottomUp {

      def transformTopUnit[Context](post: Post[Context], ctx: Context, topUnit: TopUnit): (Context, Option[TopUnit]) = {
        topUnit match {
          case topUnit@TopUnit.Program(fileUriOpt, packageName, body) =>
            val (ctx2, topUnitOpt) = post.transformProgram(ctx, topUnit)
          case topUnit@TopUnit.Sequent(fileUriOpt, sequent) =>
            val (ctx2, topUnitOpt) = post.transformProgram(ctx, topUnit)
          case topUnit@TopUnit.TruthTable(fileUriOpt, stars, vars, sepColumn, isSequent, sequent, rows, conclusionOpt) =>
            val (ctx2, topUnitOpt) = post.transformProgram(ctx, topUnit)
        }
      }

    }
  */

}
