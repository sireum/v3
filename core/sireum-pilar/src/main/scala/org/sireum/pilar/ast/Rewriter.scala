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

// This file is auto-generated from the Node class hierarchy

package org.sireum.pilar.ast

import org.sireum.util._

object Rewriter {

  import org.sireum.util.Rewriter._

  val constructorMap: ConstructorMap = Map(
    "Annotation" -> { es =>
      val Seq(id: Id, raw: Raw) = es
      Annotation(id, raw)
    },
    "AssertAction" -> { es =>
      val Seq(exp: Exp, annotations: IVector[_]) = es
      AssertAction(exp, cast(annotations))
    },
    "AssignAction" -> { es =>
      val Seq(lhs: Exp, rhs: Exp, annotations: IVector[_]) = es
      AssignAction(lhs, rhs, cast(annotations))
    },
    "AssumeAction" -> { es =>
      val Seq(exp: Exp, annotations: IVector[_]) = es
      AssumeAction(exp, cast(annotations))
    },
    "BinaryExp" -> { es =>
      val Seq(left: Exp, op: Id, right: Exp, rest: IVector[_]) = es
      BinaryExp(left, op, right, cast(rest))
    },
    "BlockLocation" -> { es =>
      val Seq(label: Id, actions: IVector[_], jump: Jump, annotations: IVector[_]) = es
      BlockLocation(label, cast(actions), jump, cast(annotations))
    },
    "CallExp" -> { es =>
      val Seq(exp: Exp, args: IVector[_]) = es
      CallExp(exp, cast(args))
    },
    "CallLocation" -> { es =>
      val Seq(label: Id, lhsOpt: Option[_], id: Id, args: IVector[_], target: Id, annotations: IVector[_]) = es
      CallLocation(label, cast(lhsOpt), id, cast(args), target, cast(annotations))
    },
    "ExtAction" -> { es =>
      val Seq(id: Id, args: IVector[_], annotations: IVector[_]) = es
      ExtAction(id, cast(args), cast(annotations))
    },
    "ExtJump" -> { es =>
      val Seq(id: Id, args: IVector[_], annotations: IVector[_]) = es
      ExtJump(id, cast(args), cast(annotations))
    },
    "GlobalVarDecl" -> { es =>
      val Seq(id: Id, annotations: IVector[_]) = es
      GlobalVarDecl(id, cast(annotations))
    },
    "GotoJump" -> { es =>
      val Seq(target: Id, annotations: IVector[_]) = es
      GotoJump(target, cast(annotations))
    },
    "Id" -> { es =>
      val Seq(value: String, kind: String) = es
      Id(value, kind)
    },
    "IdExp" -> { es =>
      val Seq(id: Id) = es
      IdExp(id)
    },
    "IfJump" -> { es =>
      val Seq(exp: Exp, tTarget: Id, fTarget: Id, annotations: IVector[_]) = es
      IfJump(exp, tTarget, fTarget, cast(annotations))
    },
    "LiteralExp" -> { es =>
      val Seq(id: Id, raw: Raw) = es
      LiteralExp(id, raw)
    },
    "LocalVarDecl" -> { es =>
      val Seq(id: Id, annotations: IVector[_]) = es
      LocalVarDecl(id, cast(annotations))
    },
    "Model" -> { es =>
      val Seq(annotations: IVector[_], elements: IVector[_]) = es
      Model(cast(annotations), cast(elements))
    },
    "ParamDecl" -> { es =>
      val Seq(id: Id, annotations: IVector[_]) = es
      ParamDecl(id, cast(annotations))
    },
    "ProcedureBody" -> { es =>
      val Seq(locals: IVector[_], locations: IVector[_]) = es
      ProcedureBody(cast(locals), cast(locations))
    },
    "ProcedureDecl" -> { es =>
      val Seq(id: Id, params: IVector[_], annotations: IVector[_], bodyOpt: Option[_]) = es
      ProcedureDecl(id, cast(params), cast(annotations), cast(bodyOpt))
    },
    "Raw" -> { es =>
      val Seq(value: String, simple: java.lang.Boolean) = es
      Raw(value, simple)
    },
    "ReturnJump" -> { es =>
      val Seq(expOpt: Option[_], annotations: IVector[_]) = es
      ReturnJump(cast(expOpt), cast(annotations))
    },
    "SwitchCase" -> { es =>
      val Seq(expOpt: Option[_], target: Id) = es
      SwitchCase(cast(expOpt), target)
    },
    "SwitchJump" -> { es =>
      val Seq(exp: Exp, cases: IVector[_], annotations: IVector[_]) = es
      SwitchJump(exp, cast(cases), cast(annotations))
    },
    "TupleExp" -> { es =>
      val Seq(exps: IVector[_], annotations: IVector[_]) = es
      TupleExp(cast(exps), cast(annotations))
    }
  )

  def build[T](mode: TraversalMode.Type = TraversalMode.TOP_DOWN)(
    f: RewriteFunction) =
    org.sireum.util.Rewriter.build[T](constructorMap)(mode, f)

  def buildEnd[T](mode: TraversalMode.Type = TraversalMode.TOP_DOWN)(
    f: RewriteFunction, g: RewriteFunction) =
    org.sireum.util.Rewriter.buildEnd[T](constructorMap)(mode, f, g)
}
