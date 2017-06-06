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

@datatype trait TopUnit

object TopUnit {

  @datatype class Program(fileUriOpt: Option[String],
                          packageName: Name,
                          body: Body)
    extends TopUnit

}

@datatype trait Stmt {
  def attr: Attr
}

@sig sealed trait AssignExp

object Stmt {

  @datatype class Import(importers: ISZ[Import.Importer],
                         @hidden attr: Attr)
    extends Stmt

  object Import {

    @datatype class Importer(name: Name, selectorsOpt: Option[ISZ[Selector]])

    @datatype class Selector(from: Id, to: Id)

  }

  @datatype class Var(isVal: B,
                      id: Id,
                      tpeOpt: Option[Type],
                      initOpt: Option[AssignExp],
                      @hidden attr: Attr)
    extends Stmt

  @datatype class VarPattern(isVal: B,
                             pattern: Pattern,
                             tpeOpt: Option[Type],
                             initOpt: Option[AssignExp],
                             @hidden attr: Attr)
    extends Stmt

  @datatype class SpecVar(isVal: B,
                          id: Id,
                          tpe: Type,
                          @hidden attr: Attr)
    extends Stmt

  @datatype class Method(isPure: B,
                         sig: MethodSig,
                         contract: MethodContract,
                         bodyOpt: Option[Body],
                         @hidden attr: Attr)
    extends Stmt

  @datatype class ExtMethod(isPure: B,
                            sig: MethodSig,
                            contract: MethodContract,
                            @hidden attr: Attr)
    extends Stmt

  @datatype class SpecMethod(sig: MethodSig,
                             defs: ISZ[SpecMethodDef],
                             where: ISZ[Assign],
                             @hidden attr: Attr)
    extends Stmt

  @datatype class Enum(id: Id,
                       elements: ISZ[Id],
                       @hidden attr: Attr)
    extends Stmt

  @datatype class Object(isExt: B,
                         id: Id,
                         parents: ISZ[Type],
                         stmts: ISZ[Stmt],
                         @hidden attr: Attr)
    extends Stmt

  @datatype class Sig(id: Id,
                      typeParams: ISZ[TypeParam],
                      parents: ISZ[Type],
                      selfTypeOpt: Option[Type],
                      stmt: ISZ[Stmt],
                      @hidden attr: Attr)
    extends Stmt

  @datatype class AbstractDatatype(isRoot: B,
                                   isDatatype: B,
                                   id: Id,
                                   typeParams: ISZ[TypeParam],
                                   params: ISZ[AbstractDatatypeParam],
                                   parents: ISZ[Type],
                                   stmt: ISZ[Stmt],
                                   @hidden attr: Attr)
    extends Stmt

  @datatype class Rich(isRoot: B,
                       id: Id,
                       typeParams: ISZ[TypeParam],
                       params: ISZ[Param],
                       parents: ISZ[Type],
                       stmt: ISZ[Stmt],
                       @hidden attr: Attr)
    extends Stmt

  @datatype class TypeAlias(id: Id,
                            typeParams: ISZ[TypeParam],
                            tpe: Type,
                            @hidden attr: Attr)
    extends Stmt

  @datatype class Assign(lhs: Exp,
                         rhs: AssignExp,
                         @hidden attr: Attr)
    extends Stmt

  @datatype class AssignUp(lhs: Exp,
                           rhs: AssignExp,
                           @hidden attr: Attr)
    extends Stmt

  @datatype class AssignPattern(lhs: Pattern,
                                rhs: AssignExp,
                                @hidden attr: Attr)
    extends Stmt

  @datatype class Block(body: Body,
                        @hidden attr: Attr)
    extends Stmt with AssignExp

  @datatype class If(cond: Exp,
                     thenbody: Body,
                     elsebody: Body,
                     @hidden attr: Attr)
    extends Stmt with AssignExp

  @datatype class Match(cond: Exp,
                        cases: ISZ[Case],
                        @hidden attr: Attr)
    extends Stmt with AssignExp

  @datatype class While(cond: Exp,
                        modifies: ISZ[Name],
                        invariants: ISZ[Exp],
                        body: Body,
                        @hidden attr: Attr)
    extends Stmt

  @datatype class DoWhile(cond: Exp,
                          modifies: ISZ[Name],
                          invariants: ISZ[Exp],
                          body: Body,
                          @hidden attr: Attr)
    extends Stmt

  @datatype class For(id: Id,
                      range: Range,
                      condOpt: Option[Exp],
                      modifies: ISZ[Name],
                      invariants: ISZ[Exp],
                      body: Body,
                      @hidden attr: Attr)
    extends Stmt

  @datatype class Return(expOpt: Option[Exp],
                         @hidden attr: Attr)
    extends Stmt

  @datatype class Expr(exp: Exp,
                       @hidden attr: Attr)
    extends Stmt with AssignExp

}

@datatype class Case(pattern: Pattern,
                     condOpt: Option[Exp],
                     body: Body)

@datatype trait Range

object Range {

  @datatype class Expr(exp: Exp) extends Range

  @datatype class Indices(isReverse: B, exp: Exp) extends Range

  @datatype class Step(isInclusive: B, start: Exp, end: Exp, byOpt: Option[Exp]) extends Range

}

@datatype trait Type

object Type {

  @datatype class Named(name: Name,
                        typeArgs: ISZ[Type],
                        attr: TypedAttr)
    extends Type

  @datatype class Fun(args: ISZ[Type],
                      ret: Type,
                      attr: TypedAttr)
    extends Type

  @datatype class Tuple(args: ISZ[Type],
                        attr: TypedAttr)
    extends Type

}

@datatype trait Pattern

object Pattern {

  @datatype class Literal(lit: Lit)
    extends Pattern

  @datatype class Variable(id: Id)
    extends Pattern

  @datatype class Wildcard
    extends Pattern

  @datatype class SeqWildcard
    extends Pattern

  @datatype class Structure(idOpt: Option[Id],
                            nameOpt: Option[Name],
                            patterns: ISZ[Pattern])
    extends Pattern

}

@datatype trait Exp

@sig sealed trait Lit

object Exp {

  @datatype class LitB(value: B)
    extends Exp with Lit

  @datatype class LitC(value: C)
    extends Exp with Lit

  @datatype class LitZ(value: Z)
    extends Exp with Lit

  @datatype class LitZ8(value: Z8)
    extends Exp with Lit

  @datatype class LitZ16(value: Z16)
    extends Exp with Lit

  @datatype class LitZ32(value: Z32)
    extends Exp with Lit

  @datatype class LitZ64(value: Z64)
    extends Exp with Lit

  @datatype class LitN(value: N)
    extends Exp with Lit

  @datatype class LitN8(value: N8)
    extends Exp with Lit

  @datatype class LitN16(value: N16)
    extends Exp with Lit

  @datatype class LitN32(value: N32)
    extends Exp with Lit

  @datatype class LitN64(value: N64)
    extends Exp with Lit

  @datatype class LitS8(value: S8)
    extends Exp with Lit

  @datatype class LitS16(value: S16)
    extends Exp with Lit

  @datatype class LitS32(value: S32)
    extends Exp with Lit

  @datatype class LitS64(value: S64)
    extends Exp with Lit

  @datatype class LitU8(value: U8)
    extends Exp with Lit

  @datatype class LitU16(value: U16)
    extends Exp with Lit

  @datatype class LitU32(value: U32)
    extends Exp with Lit

  @datatype class LitU64(value: U64)
    extends Exp with Lit

  @datatype class LitF32(value: F32)
    extends Exp with Lit

  @datatype class LitF64(value: F64)
    extends Exp with Lit

  @datatype class LitR(value: R)
    extends Exp with Lit

  @datatype class LitBv(value: ISZ[B],
                        tpe: Type)
    extends Exp with Lit

  @datatype class LitString(value: String)
    extends Exp with Lit

  @datatype class StringInterpolate(lits: ISZ[LitString],
                                    args: ISZ[Exp])
    extends Exp

  @enum object UnaryOp {
    'Not
    'Plus
    'Minus
    'Complement
  }

  @datatype class Unary(op: UnaryOp.Type,
                        exp: Exp,
                        @hidden attr: TypedAttr)
    extends Exp

  @enum object BinaryOp {
    'Add
    'Sub
    'Mul
    'Div
    'Rem
    'Eq
    'Ne
    'Shl
    'Shr
    'Ushr
    'Lt
    'Le
    'Gt
    'Ge
    'And
    'Or
    'Xor
    'Imply
  }

  @datatype class Binary(left: Exp,
                         op: BinaryOp.Type,
                         right: Exp,
                         @hidden attr: TypedAttr)
    extends Exp

  @datatype class Ident(id: Id,
                        @hidden attr: ResolvedAttr)
    extends Exp

  @datatype class Eta(exp: Exp,
                      @hidden attr: ResolvedAttr)
    extends Exp

  @datatype class Tuple(args: ISZ[Exp],
                        @hidden attr: TypedAttr)
    extends Exp

  @datatype class Select(receiverOpt: Option[Exp],
                         id: Id,
                         targs: ISZ[Type],
                         @hidden attr: ResolvedAttr)
    extends Exp

  @datatype class Invoke(receiverOpt: Option[Exp],
                         id: Id,
                         targs: ISZ[Type],
                         args: ISZ[Exp],
                         @hidden attr: ResolvedAttr)
    extends Exp

  @datatype class InvokeNamed(receiverOpt: Option[Exp],
                              id: Id,
                              targs: ISZ[Type],
                              args: ISZ[(Id, Exp)],
                              @hidden attr: ResolvedAttr)
    extends Exp

  @datatype class If(cond: Exp,
                     thenExp: Exp,
                     elseExp: Exp,
                     @hidden attr: TypedAttr)
    extends Exp

}

@datatype class Id(value: String,
                   @hidden attr: Attr)

@datatype class Name(ids: ISZ[Id],
                     @hidden attr: Attr)

@datatype class Body(stmts: ISZ[Stmt])

@datatype class AbstractDatatypeParam(isHidden: B,
                                      isPure: B,
                                      id: Id,
                                      tpe: Type)

@datatype class MethodSig(id: Id,
                          typeParams: ISZ[TypeParam],
                          paramsOpt: Option[ISZ[Param]],
                          returnType: Type)

@datatype class Param(isPure: B,
                      id: Id,
                      tpe: Type)

@datatype class TypeParam(id: Id,
                          superTypeOpt: Option[Type])

@datatype class MethodContract(reads: ISZ[Name],
                               requires: ISZ[Exp],
                               modifies: ISZ[Name],
                               ensures: ISZ[Exp],
                               subs: ISZ[SubMethodContract])

@datatype class SubMethodContract(isPure: B,
                                  id: Id,
                                  args: ISZ[Id],
                                  contract: MethodContract)

@datatype class SpecMethodDef(idOpt: Option[Id],
                              exp: Exp,
                              pattern: Option[Case],
                              cond: Option[Exp])

@datatype class Attr(posInfoOpt: Option[PosInfo])

@datatype class TypedAttr(posInfoOpt: Option[PosInfo],
                          typeOpt: Option[Type])

@datatype class ResolvedAttr(posInfoOpt: Option[PosInfo],
                             resOpt: Option[ResolvedInfo],
                             typeOpt: Option[Type])

@datatype class ResolvedInfo(uri: String)

@datatype class PosInfo(fileUriOpt: Option[String],
                        beginLine: Z,
                        beginColumn: Z,
                        endLine: Z,
                        endColumn: Z,
                        offset: Z,
                        length: Z)