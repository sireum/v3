/*
Copyright (c) 2015, Robby, Kansas State University
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

// @formatter:off
// This file was auto-generated from org.sireum.pilar.ast.Node

package org.sireum.pilar.ast

import org.sireum.util._

object Rewriter {
  import org.sireum.util.Rewriter._

  val constructorMap : ConstructorMap = Map(
    ("Annotation", { es =>
      val Seq(id: Id, lit: Lit) = es
      org.sireum.pilar.ast.Annotation(id, lit)
    }),
    ("AssertAction", { es =>
      val Seq(exp: Exp, annotations: IVector[_]) = es
      org.sireum.pilar.ast.AssertAction(exp, cast(annotations))
    }),
    ("AssignAction", { es =>
      val Seq(lhs: Exp, rhs: Exp, annotations: IVector[_]) = es
      org.sireum.pilar.ast.AssignAction(lhs, rhs, cast(annotations))
    }),
    ("AssumeAction", { es =>
      val Seq(exp: Exp, annotations: IVector[_]) = es
      org.sireum.pilar.ast.AssumeAction(exp, cast(annotations))
    }),
    ("BlockLocation", { es =>
      val Seq(label: Id, actions: IVector[_], jump: Jump, annotations: IVector[_]) = es
      org.sireum.pilar.ast.BlockLocation(label, cast(actions), jump, cast(annotations))
    }),
    ("CallLocation", { es =>
      val Seq(label: Id, lhsOpt: Option[_], id: Id, args: IVector[_], target: Id, annotations: IVector[_]) = es
      org.sireum.pilar.ast.CallLocation(label, cast(lhsOpt), id, cast(args), target, cast(annotations))
    }),
    ("ExtAction", { es =>
      val Seq(id: Id, args: IVector[_], annotations: IVector[_]) = es
      org.sireum.pilar.ast.ExtAction(id, cast(args), cast(annotations))
    }),
    ("ExtExp", { es =>
      val Seq(exp: Exp, args: IVector[_]) = es
      org.sireum.pilar.ast.ExtExp(exp, cast(args))
    }),
    ("ExtJump", { es =>
      val Seq(id: Id, args: IVector[_], annotations: IVector[_]) = es
      org.sireum.pilar.ast.ExtJump(id, cast(args), cast(annotations))
    }),
    ("ExtLit", { es =>
      val Seq(value: Any) = es
      org.sireum.pilar.ast.ExtLit(value)
    }),
    ("GlobalVarDecl", { es =>
      val Seq(id: Id, annotations: IVector[_]) = es
      org.sireum.pilar.ast.GlobalVarDecl(id, cast(annotations))
    }),
    ("GotoJump", { es =>
      val Seq(target: Id, annotations: IVector[_]) = es
      org.sireum.pilar.ast.GotoJump(target, cast(annotations))
    }),
    ("IdExp", { es =>
      val Seq(id: Id) = es
      org.sireum.pilar.ast.IdExp(id)
    }),
    ("IfJump", { es =>
      val Seq(exp: Exp, tTarget: Id, fTarget: Id, annotations: IVector[_]) = es
      org.sireum.pilar.ast.IfJump(exp, tTarget, fTarget, cast(annotations))
    }),
    ("InfixExp", { es =>
      val Seq(left: Exp, op: Id, right: Exp, rest: IVector[_]) = es
      org.sireum.pilar.ast.InfixExp(left, op, right, cast(rest))
    }),
    ("LiteralExp", { es =>
      val Seq(id: Id, lit: Lit) = es
      org.sireum.pilar.ast.LiteralExp(id, lit)
    }),
    ("LocalVarDecl", { es =>
      val Seq(id: Id, annotations: IVector[_]) = es
      org.sireum.pilar.ast.LocalVarDecl(id, cast(annotations))
    }),
    ("Model", { es =>
      val Seq(elements: IVector[_], annotations: IVector[_]) = es
      org.sireum.pilar.ast.Model(cast(elements), cast(annotations))
    }),
    ("ParamDecl", { es =>
      val Seq(id: Id, annotations: IVector[_]) = es
      org.sireum.pilar.ast.ParamDecl(id, cast(annotations))
    }),
    ("ProcedureBody", { es =>
      val Seq(locals: IVector[_], locations: IVector[_]) = es
      org.sireum.pilar.ast.ProcedureBody(cast(locals), cast(locations))
    }),
    ("ProcedureDecl", { es =>
      val Seq(id: Id, params: IVector[_], bodyOpt: Option[_], annotations: IVector[_]) = es
      org.sireum.pilar.ast.ProcedureDecl(id, cast(params), cast(bodyOpt), cast(annotations))
    }),
    ("RawLit", { es =>
      val Seq(value: String) = es
      org.sireum.pilar.ast.RawLit(value)
    }),
    ("ReturnJump", { es =>
      val Seq(expOpt: Option[_], annotations: IVector[_]) = es
      org.sireum.pilar.ast.ReturnJump(cast(expOpt), cast(annotations))
    }),
    ("SwitchCase", { es =>
      val Seq(expOpt: Option[_], target: Id) = es
      org.sireum.pilar.ast.SwitchCase(cast(expOpt), target)
    }),
    ("SwitchJump", { es =>
      val Seq(exp: Exp, cases: IVector[_], annotations: IVector[_]) = es
      org.sireum.pilar.ast.SwitchJump(exp, cast(cases), cast(annotations))
    }),
    ("TupleExp", { es =>
      val Seq(exps: IVector[_], annotations: IVector[_]) = es
      org.sireum.pilar.ast.TupleExp(cast(exps), cast(annotations))
    }),
    ("_Id", { es =>
      val Seq(value: String) = es
      org.sireum.pilar.ast._Id(value)
    })
  )

  def build[T](mode: TraversalMode.Type = TraversalMode.TOP_DOWN)(
    f: RewriteFunction) =
    org.sireum.util.Rewriter.build[T](constructorMap)(mode, f)

  def buildEnd[T](mode: TraversalMode.Type = TraversalMode.TOP_DOWN)(
      f: RewriteFunction, g: RewriteFunction) =
    org.sireum.util.Rewriter.buildEnd[T](constructorMap)(mode, f, g)
}