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
import org.sireum.U64._

object Util {

  @pure def ids2strings(ids: ISZ[Id]): ISZ[String] = {
    val r = MSZ.create[String](ids.size, "")
    for (i <- ids.indices) {
      r(i) = ids(i).value
    }
    return r.toIS
  }

  @pure def fileUriOptEq(posOpt1: Option[PosInfo], posOpt2: Option[PosInfo]): B = {
    (posOpt1, posOpt2) match {
      case (Some(pos1), Some(pos2)) => return pos1.fileUriOpt == pos2.fileUriOpt
      case _ => return F
    }
  }

  @pure def beginColumn(posOpt: Option[PosInfo]): Z = {
    l""" requires ∃pos: PosInfo  posOpt == Some(pos) """
    posOpt match {
      case Some(pos) => return pos.beginColumn
      case _ => return 0
    }
  }

  @pure def beginColumnEqual(posOpt1: Option[PosInfo], posOpt2: Option[PosInfo]): B = {
    (posOpt1, posOpt2) match {
      case (Some(pos1), Some(pos2)) => return pos1.beginColumn == pos2.beginColumn
      case _ => return F
    }
  }

  @pure def posOptRangeA(attr1: Attr, attr2: Attr): Option[PosInfo] = {
    return posOptRange(attr1.posOpt, attr2.posOpt)
  }

  @pure def posOptRangeTA(attr1: TypedAttr, attr2: TypedAttr): Option[PosInfo] = {
    return posOptRange(attr1.posOpt, attr2.posOpt)
  }

  @pure def posOptRangeRA(attr1: ResolvedAttr, attr2: ResolvedAttr): Option[PosInfo] = {
    return posOptRange(attr1.posOpt, attr2.posOpt)
  }

  @pure def posOptRange(posOpt1: Option[PosInfo], posOpt2: Option[PosInfo]): Option[PosInfo] = {
    posOpt1 match {
      case Some(pos1) =>
        posOpt2 match {
          case Some(pos2) =>
            val offset = pos1.offset
            val length = pos2.offset + pos2.length - offset
            Some(PosInfo(pos1.fileInfo, (conversions.Z.toU64(offset) << u64"32") | conversions.Z.toU64(length)))
          case _ => return posOpt1
        }
      case _ => return posOpt2
    }
  }

  def unop(op: Exp.UnaryOp.Type): String = {
    op match {
      case Exp.UnaryOp.Not => return "!"
      case Exp.UnaryOp.Plus => return "+"
      case Exp.UnaryOp.Minus => return "-"
      case Exp.UnaryOp.Complement => return "~"
    }
  }

  def unopId(op: Exp.UnaryOp.Type): String = {
    op match {
      case Exp.UnaryOp.Not => return "unary_!"
      case Exp.UnaryOp.Plus => return "unary_+"
      case Exp.UnaryOp.Minus => return "unary_-"
      case Exp.UnaryOp.Complement => return "unary_~"
    }
  }

  @pure def isBoolBinop(op: String): B = {
    op match {
      case Exp.BinaryOp.Eq => return T
      case Exp.BinaryOp.Ne => return T
      case Exp.BinaryOp.And => return T
      case Exp.BinaryOp.Or => return T
      case Exp.BinaryOp.Xor => return T
      case Exp.BinaryOp.Imply => return T
      case Exp.BinaryOp.CondAnd => return T
      case Exp.BinaryOp.CondOr => return T
      case _ => return F
    }
  }

  @pure def isArithBinop(op: String): B = {
    op match {
      case Exp.BinaryOp.Add => return T
      case Exp.BinaryOp.Sub => return T
      case Exp.BinaryOp.Mul => return T
      case Exp.BinaryOp.Div => return T
      case Exp.BinaryOp.Rem => return T
      case _ => return F
    }
  }

  @pure def isBitsBinop(op: String): B = {
    op match {
      case Exp.BinaryOp.Shl => return T
      case Exp.BinaryOp.Shr => return T
      case Exp.BinaryOp.Ushr => return T
      case Exp.BinaryOp.And => return T
      case Exp.BinaryOp.Or => return T
      case Exp.BinaryOp.Xor => return T
      case _ => return F
    }
  }

  @pure def isCompareBinop(op: String): B = {
    op match {
      case Exp.BinaryOp.Eq => return T
      case Exp.BinaryOp.Ne => return T
      case Exp.BinaryOp.Lt => return T
      case Exp.BinaryOp.Le => return T
      case Exp.BinaryOp.Gt => return T
      case Exp.BinaryOp.Ge => return T
      case _ => return F
    }
  }
}
