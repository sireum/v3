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

@datatype trait Stmt

object Stmt {

  @datatype class AbstractDatatype(isRoot: B,
                                   isDatatype: B,
                                   id: Id,
                                   typeParams: ISZ[TypeParam],
                                   params: ISZ[AbstractDatatypeParam],
                                   parents: ISZ[Type],
                                   stmt: ISZ[Stmt])
    extends Stmt

  @datatype class Sig(id: Id,
                      typeParams: ISZ[TypeParam],
                      parents: ISZ[Type],
                      stmt: ISZ[Stmt])
    extends Stmt

  @datatype class Object(isExt: B,
                         id: Id,
                         stmts: ISZ[Stmt])
    extends Stmt

  @datatype class Var(isVal: B,
                      id: Id,
                      tpeOpt: Option[Type],
                      initOpt: Option[Exp])
    extends Stmt

  @datatype class SpecVar(isVal: B,
                          id: Id,
                          tpe: Type)
    extends Stmt

  @datatype class Method(isPure: B,
                         sig: MethodSig,
                         contract: MethodContract,
                         bodyOpt: Option[Body])
    extends Stmt

  @datatype class ExtMethod(isPure: B,
                            sig: MethodSig,
                            contract: MethodContract)
    extends Stmt

  @datatype class SpecMethod(sig: MethodSig,
                             defs: ISZ[SpecMethodDef],
                             where: ISZ[Assign])
    extends Stmt

  @datatype class Expr(exp: Exp)
    extends Stmt

  @datatype class Block(body: Body)
    extends Stmt

  @datatype class If(cond: Exp,
                     thenbody: Body,
                     elsebody: Body)
    extends Stmt

  @datatype class While(isDoWhile: B,
                        cond: Exp,
                        modifies: ISZ[Name],
                        invariants: ISZ[Exp],
                        body: Body)
    extends Stmt

}

@datatype trait Type

object Type {

  @datatype class Named(name: Name,
                        typeArgs: ISZ[Type])
    extends Type

  @datatype class Fun(args: ISZ[Type],
                      ret: Type)
    extends Type

  @datatype class Tuple(args: ISZ[Type])
    extends Type

}

@datatype trait Case

object Case {

  @datatype class Typed(id: Id,
                        tpe: Type)
    extends Case

  @datatype class Structure(idOpt: Option[Id],
                            name: Name,
                            patterns: ISZ[Pattern])
    extends Case

  @datatype class Wildcard()
    extends Case

}

@datatype trait Pattern

object Pattern {

  @datatype class Var(id: Id)
    extends Pattern

  @datatype class Structure(idOpt: Option[Id],
                            nameOpt: Option[Name],
                            patterns: ISZ[Pattern])
    extends Pattern

}

@datatype trait Assign

object Assign {

  @datatype class Expr(lhs: Exp,
                       rhs: Exp)
    extends Assign

  @datatype class Pattern(nameOpt: Option[Name],
                          patterns: ISZ[Pattern])
    extends Assign

}

@datatype trait Exp

object Exp {

  @datatype class Ident(id: Id)
    extends Exp

}

@datatype class Id(value: String)

@datatype class Name(ids: ISZ[Id])

@datatype class Body(stmts: ISZ[Stmt])

@datatype class AbstractDatatypeParam(isHidden: B,
                                      isPure: B,
                                      id: Id,
                                      tpe: Type)
  extends Stmt


@datatype class MethodSig(id: Id,
                          typeParams: ISZ[TypeParam],
                          emptyParams: B,
                          params: ISZ[Param],
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
