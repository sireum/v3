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

package org.sireum.x.logika.ast

import org.sireum.logika._

/* @datatype */ trait
UnitNode

/* @datatype */ case class
Id(value: String)

/* @datatype */ case class
Name(ids: ISZ[Id])

/* @datatype */ case class
Program(fileUriOpt: Option[String],
        packageName: Name,
        block: Block)
  extends UnitNode

/* @datatype */ case class
Block(stmts: ISZ[Stmt])

/* @datatype */ trait
Stmt

/* @datatype */ case class
ObjectStmt(id: Id, stmts: ISZ[Stmt])
  extends Stmt

/* @datatype */ case class
VarStmt(isVal: B,
        id: Id,
        tpe: Type,
        init: Option[Exp])
  extends Stmt

/* @datatype */ case class
MethodStmt(isPure: B,
           sig: MethodSig,
           contract: MethodContract,
           blockOpt: Option[Block])
  extends Stmt

/* @datatype */ case class
ExtMethodStmt(isPure: B,
              sig: MethodSig,
              contract: MethodContract)
  extends Stmt

/* @datatype */ case class
SpecMethodStmt(sig: MethodSig,
               defs: ISZ[SpecMethodDef],
               whereOpt: Option[WhereClause])
  extends Stmt

/* @datatype */ case class
MethodSig(id: Id,
          typeParams: ISZ[TypeParam],
          params: ISZ[Param],
          returnType: Type)

/* @datatype */ case class
Param(id: Id,
      tpe: Type)

/* @datatype */ trait
Type

/* @datatype */ case class
NamedType(name: Name,
          typeArgs: ISZ[Type])
  extends Type

/* @datatype */ case class
FunType(args: ISZ[Type],
        ret: Type)
  extends Type

/* @datatype */ case class
TupleType(args: ISZ[Type])
  extends Type

/* @datatype */ case class
TypeParam(id: Id,
          superType: Option[NamedType])

/* @datatype */ case class
MethodContract(reads: ISZ[Name],
               requires: ISZ[Exp],
               modifies: ISZ[Name],
               ensures: ISZ[Exp],
               subs: ISZ[SubMethodContract])

/* @datatype */ case class
SubMethodContract(isPure: B,
                  id: Id,
                  args: ISZ[Id],
                  contract: MethodContract)

/* @datatype */ case class
SpecMethodDef(idOpt: Option[Id],
              exp: Exp,
              pattern: Option[Case],
              cond: Option[Exp])

/* @datatype */ trait
Case

/* @datatype */ case class
TypeCase(id: Id,
         tpe: Type)
  extends Case

/* @datatype */ case class
StructureCase(idOpt: Option[Id],
              name: Name,
              patterns: ISZ[Pattern])
  extends Case

/* @datatype */ case class
WildcardCase()
  extends Case

/* @datatype */ trait
Pattern

/* @datatype */ case class
VarPattern(id: Id)
  extends Pattern

/* @datatype */ case class
StructurePattern(idOpt: Option[Id],
                 name: Name,
                 patterns: ISZ[Pattern])
  extends Pattern

/* @datatype */ case class
WhereClause(assigns: ISZ[Assign])

/* @datatype */ trait
Assign

/* @datatype */ case class
ExpAssign(lhs: Exp,
          rhs: Exp)
  extends Assign

/* @datatype */ case class
PatternAssign(name: Name,
              patterns: ISZ[Pattern])
  extends Assign

/* @datatype */ case class
ExpStmt(exp: Exp)
  extends Stmt

/* @datatype */ trait Exp

/* @datatype */ case class
NameExp(name: Name)
  extends Exp