// #Sireum
/*
 Copyright (c) 2018, Robby, Kansas State University
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

package org.sireum.lang.tipe

import org.sireum._
import org.sireum.lang.ast._
import org.sireum.lang.symbol.Resolver._
import org.sireum.lang.util.Reporter

object PostTipeAttrChecker {
  val AttrResult: MTransformer.PreResult[Attr] = MTransformer.PreResult[Attr](F, MNone())
  val ContractResult: MTransformer.PreResult[Contract] = MTransformer.PreResult[Contract](F, MNone()) // TODO: Unskip contract
  val StmtResult: MTransformer.PreResult[Stmt] = MTransformer.PreResult[Stmt](T, MNone())
  val LStmtResult: MTransformer.PreResult[Stmt] = MTransformer.PreResult[Stmt](F, MNone()) // TODO: Unskip contract
  val ResolvedResult: MTransformer.PreResult[ResolvedAttr] = MTransformer.PreResult[ResolvedAttr](F, MNone())
  val SpecDefResult: MTransformer.PreResult[SpecDef] = MTransformer.PreResult[SpecDef](F, MNone()) // TODO: Unskip contract
  val TypedResult: MTransformer.PreResult[TypedAttr] = MTransformer.PreResult[TypedAttr](F, MNone())
  val WhereDefResult: MTransformer.PreResult[WhereDef] = MTransformer.PreResult[WhereDef](F, MNone()) // TODO: Unskip contract

  def check(nameMap: NameMap, typeMap: TypeMap, reporter: Reporter): Unit = {
    val t = PostTipeAttrChecker(HashSSet.empty)
    for (info <- nameMap.values) {
      info match {
        case info: Info.Object =>
          for (parent <- info.ast.parents) {
            t.transformType(parent)
          }
          for (stmt <- info.ast.stmts) {
            stmt match {
              case _: Stmt.Object =>
              case _ => t.transformStmt(stmt)
            }
          }
        case _ =>
      }
    }
    for (info <- typeMap.values) {
      info match {
        case info: TypeInfo.Sig => t.transformStmt(info.ast)
        case info: TypeInfo.AbstractDatatype => t.transformStmt(info.ast)
        case _ =>
      }
    }
    reporter.reports(t.messages.elements)
  }

  def check(stmt: Stmt, reporter: Reporter): Unit = {
    val t = PostTipeAttrChecker(HashSSet.empty)
    t.transformStmt(stmt)
    reporter.reports(t.messages.elements)
  }

  def check(program: TopUnit.Program, reporter: Reporter): Unit = {
    val t = PostTipeAttrChecker(HashSSet.empty)
    t.transformTopUnit(program)
    reporter.reports(t.messages.elements)
  }
}

@record class PostTipeAttrChecker(var messages: HashSSet[Reporter.Message]) extends MTransformer {

  override def preContract(o: Contract): MTransformer.PreResult[Contract] = {
    return PostTipeAttrChecker.ContractResult
  }

  override def preStmt(o: Stmt): MTransformer.PreResult[Stmt] = {
    o match {
      case _: Stmt.LStmt => return PostTipeAttrChecker.LStmtResult
      case _ => return PostTipeAttrChecker.StmtResult
    }
  }

  override def preSpecDef(o: SpecDef): MTransformer.PreResult[SpecDef] = {
    return PostTipeAttrChecker.SpecDefResult
  }

  override def preWhereDef(o: WhereDef): MTransformer.PreResult[WhereDef] = {
    return PostTipeAttrChecker.WhereDefResult
  }

  override def preAttr(o: Attr): MTransformer.PreResult[Attr] = {
    return PostTipeAttrChecker.AttrResult
  }

  override def preResolvedAttr(o: ResolvedAttr): MTransformer.PreResult[ResolvedAttr] = {
    if (o.typedOpt.isEmpty) {
      emptyError(T, o.posOpt)
    }
    if (o.resOpt.isEmpty) {
      emptyError(F, o.posOpt)
    }
    return PostTipeAttrChecker.ResolvedResult
  }

  override def preTypedAttr(o: TypedAttr): MTransformer.PreResult[TypedAttr] = {
    if (o.typedOpt.isEmpty) {
      emptyError(T, o.posOpt)
    }
    return PostTipeAttrChecker.TypedResult
  }

  def emptyError(isType: B, posOpt: Option[PosInfo]): Unit = {
    val m = Reporter.Message(Reporter.Message.Level.InternalError, posOpt, TypeChecker.typeCheckerKind,
      s"Empty ${if (isType) "type" else "symbol"} information after type checking phase")
    if (m.fileUriOpt.isEmpty || !messages.contains(m)) {
      messages = messages + m
    }
  }
}
