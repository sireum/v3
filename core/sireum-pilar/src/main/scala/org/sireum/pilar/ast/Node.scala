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

package org.sireum.pilar.ast

import org.sireum.util._


sealed trait Node
  extends NodeLocation
  with Rewritable
  with Product {

  final override val hashCode: Int =
    subTrees.hashCode()

  final override def equals(other: Any): Boolean =
    other match {
      case other: Node =>
        ProductUtil.equals(subTrees, other.subTrees)
      case _ => false
    }

  final override def getChildren: ISeq[AnyRef] =
    ProductUtil.getChildren(this)

  final override def getNumOfChildren: Int =
    ProductUtil.getNumOfChildren(this)

  private[ast] def subTrees: Product
}


object NodeLocation {
  final val LOC_DEFAULT = -1
}

import org.sireum.pilar.ast.NodeLocation.LOC_DEFAULT

sealed trait NodeLocation {
  private[ast] var _line: Int
  private[ast] var _column: Int

  final def hasLoc: Boolean =
    _line != LOC_DEFAULT &&
      _column != LOC_DEFAULT

  final def line: Int = _line

  final def column: Int = _column

  final private[ast] def line_=(line: Int): Unit = {
    _line = line
  }

  final private[ast] def column_=(column: Int): Unit = {
    _column = column
  }
}


sealed trait Annotated {
  final def annotation(id: String): Option[Annotation] =
    annotations.find(_.id.value == id)

  def annotations: ISeq[Annotation]
}


object Model {
  final def apply(annotations: ISeq[Annotation],
                  elements: ISeq[ModelElement],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): Model =
    ModelImpl(annotations.toVector, elements.toVector,
      line, column)

  final def unapply(m: Model) = Some(m.elements)
}

sealed trait Model extends Node with Annotated {
  final private[ast] def subTrees = (annotations, elements)

  final def copy(annotations: ISeq[Annotation] = this.annotations,
                 elements: ISeq[ModelElement] = this.elements,
                 line: Int = this.line,
                 column: Int = this.column): Model =
    Model(annotations, elements, line, column)

  def elements: ISeq[ModelElement]
}

private final case class
ModelImpl(annotations: IVector[Annotation],
          elements: IVector[ModelElement],
          private[ast] var _line: Int,
          private[ast] var _column: Int)
  extends Model {

  override def make(children: AnyRef*): Model = {
    val Seq(anns: IVector[_], es: IVector[_],
    ob: Integer, oe: Integer) =
      children
    ModelImpl(cast(anns), cast(es), ob, oe)
  }
}


object Id {
  final def apply(value: String,
                  isSimple: Boolean = true,
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): Id =
    IdImpl(value.intern(), isSimple, line, column)

  final def unapply(id: Id) = Some(id.value)
}

sealed trait Id extends Node {
  final private[ast] def subTrees = Tuple1(value)

  final def copy(value: String = this.value,
                 isSimple: Boolean = this.isSimple,
                 line: Int = this.line,
                 column: Int = this.column): Id =
    Id(value, isSimple, line, column)

  def value: String

  def isSimple: Boolean
}

private final case class
IdImpl(value: String,
       isSimple: Boolean,
       private[ast] var _line: Int,
       private[ast] var _column: Int)
  extends Id {

  override def make(children: AnyRef*): Id = {
    val Seq(value: String, b: java.lang.Boolean,
    ob: Integer, oe: Integer) =
      children
    IdImpl(value, b, ob, oe)
  }
}


object Raw {
  final def apply(value: String,
                  isSimple: Boolean = true,
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): Raw =
    RawImpl(value, isSimple, line, column)

  final def unapply(raw: Raw) = Some(raw.value)
}

sealed trait Raw extends Node {
  final private[ast] def subTrees = Tuple1(value)

  final def copy(value: String = this.value,
                 isSimple: Boolean = this.isSimple,
                 line: Int = this.line,
                 column: Int = this.column): Raw =
    Raw(value, isSimple, line, column)

  def value: String

  def isSimple: Boolean
}

private final case class
RawImpl(value: String,
        isSimple: Boolean,
        private[ast] var _line: Int,
        private[ast] var _column: Int)
  extends Raw {

  override def make(children: AnyRef*): Raw = {
    val Seq(value: String, isSimple: java.lang.Boolean,
    ob: Integer, oe: Integer) =
      children
    RawImpl(value, isSimple, ob, oe)
  }
}


object Annotation {
  final def apply(id: Id, raw: Raw,
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): Annotation =
    AnnotationImpl(id, raw, line, column)

  final def unapply(a: Annotation) = Some(a.subTrees)
}

sealed trait Annotation extends Node {
  final private[ast] def subTrees = (id, raw)

  final def copy(id: Id = this.id,
                 raw: Raw = this.raw,
                 line: Int = this.line,
                 column: Int = this.column): Annotation =
    Annotation(id, raw, line, column)

  def id: Id

  def raw: Raw
}

private final case class
AnnotationImpl(id: Id,
               raw: Raw,
               private[ast] var _line: Int,
               private[ast] var _column: Int)
  extends Annotation {

  override def make(children: AnyRef*): Annotation = {
    val Seq(id: Id, raw: Raw, ob: Integer, oe: Integer) =
      children
    AnnotationImpl(id, raw, ob, oe)
  }
}


sealed trait ModelElement extends Node with Annotated


object GlobalVarDecl {
  final def apply(id: Id, annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): GlobalVarDecl =
    GlobalVarDeclImpl(id, annotations.toVector, line, column)

  final def unapply(gvd: GlobalVarDecl) = Some(gvd.id)
}

sealed trait GlobalVarDecl extends ModelElement {
  final private[ast] def subTrees = (id, annotations)

  final def copy(id: Id = this.id,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.column): GlobalVarDecl =
    GlobalVarDecl(id, annotations, line, column)

  def id: Id
}

private final case class
GlobalVarDeclImpl(id: Id,
                  annotations: IVector[Annotation],
                  private[ast] var _line: Int,
                  private[ast] var _column: Int)
  extends GlobalVarDecl {

  override def make(children: AnyRef*): GlobalVarDecl = {
    val Seq(id: Id, anns: IVector[_], ob: Integer, oe: Integer) =
      children
    GlobalVarDeclImpl(id, cast(anns), ob, oe)
  }
}


object ProcedureDecl {
  final def apply(id: Id, params: ISeq[ParamDecl],
                  annotations: ISeq[Annotation],
                  bodyOpt: Option[ProcedureBody],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): ProcedureDecl =
    ProcedureDeclImpl(id, params.toVector, annotations.toVector,
      bodyOpt, line, column)

  final def unapply(p: ProcedureDecl) =
    Some((p.id, p.params, p.bodyOpt))
}

sealed trait ProcedureDecl extends ModelElement {
  final private[ast] def subTrees =
    (id, params, annotations, bodyOpt)

  final def copy(id: Id = this.id,
                 params: ISeq[ParamDecl] = this.params,
                 annotations: ISeq[Annotation] = this.annotations,
                 bodyOpt: Option[ProcedureBody] = this.bodyOpt,
                 line: Int = this.line,
                 column: Int = this.column): ProcedureDecl =
    ProcedureDecl(id, params, annotations, bodyOpt, line, column)

  def id: Id

  def params: ISeq[ParamDecl]

  def bodyOpt: Option[ProcedureBody]
}

private final case class
ProcedureDeclImpl(id: Id,
                  params: IVector[ParamDecl],
                  annotations: IVector[Annotation],
                  bodyOpt: Option[ProcedureBody],
                  private[ast] var _line: Int,
                  private[ast] var _column: Int)
  extends ProcedureDecl {

  override def make(children: AnyRef*): ProcedureDecl = {
    val Seq(id: Id, ps: IVector[_], anns: IVector[_],
    bo: Option[_], ob: Integer, oe: Integer) =
      children
    ProcedureDeclImpl(id, cast(ps), cast(anns),
      cast(bo), ob, oe)
  }
}


object ParamDecl {
  final def apply(id: Id, annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): ParamDecl =
    ParamDeclImpl(id, annotations.toVector, line, column)

  final def unapply(p: ParamDecl) = Some(p.id)
}

sealed trait ParamDecl extends Node with Annotated {
  final private[ast] def subTrees = (id, annotations)

  final def copy(id: Id = this.id,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.column): ParamDecl =
    ParamDecl(id, annotations, line, column)

  def id: Id
}

private final case class
ParamDeclImpl(id: Id,
              annotations: IVector[Annotation],
              private[ast] var _line: Int,
              private[ast] var _column: Int)
  extends ParamDecl {

  override def make(children: AnyRef*): ParamDecl = {
    val Seq(id: Id, anns: IVector[_], ob: Integer, oe: Integer) =
      children
    ParamDeclImpl(id, cast(anns), ob, oe)
  }
}


object ProcedureBody {
  final def apply(locals: ISeq[LocalVarDecl],
                  locations: ISeq[Location],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): ProcedureBody =
    ProcedureBodyImpl(locals.toVector, locations.toVector,
      line, column)

  final def unapply(b: ProcedureBody) = Some(b.subTrees)
}

sealed trait ProcedureBody extends Node {
  final private[ast] def subTrees = (locals, locations)

  final def copy(locals: ISeq[LocalVarDecl] = this.locals,
                 locations: ISeq[Location] = this.locations,
                 line: Int = this.line,
                 column: Int = this.column): ProcedureBody =
    ProcedureBody(locals, locations, line, column)

  def locals: ISeq[LocalVarDecl]

  def locations: ISeq[Location]
}

private final case class
ProcedureBodyImpl(locals: IVector[LocalVarDecl],
                  locations: IVector[Location],
                  private[ast] var _line: Int,
                  private[ast] var _column: Int)
  extends ProcedureBody {

  override def make(children: AnyRef*): ProcedureBody = {
    val Seq(ls: IVector[_], locs: IVector[_],
    ob: Integer, oe: Integer) =
      children
    ProcedureBodyImpl(cast(ls), cast(locs), ob, oe)
  }
}


object LocalVarDecl {
  final def apply(id: Id, annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): LocalVarDecl =
    LocalVarDeclImpl(id, annotations.toVector, line, column)

  final def unapply(lvd: LocalVarDecl) = Some(lvd.id)
}

sealed trait LocalVarDecl extends Node with Annotated {
  final private[ast] def subTrees = (id, annotations)

  final def copy(id: Id = this.id,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.column): LocalVarDecl =
    LocalVarDecl(id, annotations, line, column)

  def id: Id
}

private final case class
LocalVarDeclImpl(id: Id,
                 annotations: IVector[Annotation],
                 private[ast] var _line: Int,
                 private[ast] var _column: Int)
  extends LocalVarDecl {

  override def make(children: AnyRef*): LocalVarDecl = {
    val Seq(id: Id, anns: IVector[_], ob: Integer, oe: Integer) =
      children
    LocalVarDeclImpl(id, cast(anns), ob, oe)
  }
}


sealed trait Location extends Node with Annotated


object CallLocation {
  final def apply(label: Id, lhsOpt: Option[Exp],
                  id: Id, args: ISeq[Exp],
                  target: Id, annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): CallLocation =
    CallLocationImpl(label, lhsOpt, id, args.toVector,
      target, annotations.toVector, line, column)

  final def unapply(l: CallLocation) =
    Some(l.label, l.lhsOpt, l.id, l.args, l.target)
}

sealed trait CallLocation extends Location {
  final private[ast] def subTrees =
    (label, lhsOpt, id, args, target, annotations)

  final def copy(label: Id = this.label,
                 lhsOpt: Option[Exp] = this.lhsOpt,
                 id: Id = this.id,
                 args: ISeq[Exp] = this.args,
                 target: Id = this.target,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.column): CallLocation =
    CallLocationImpl(label, lhsOpt, id, args.toVector,
      target, annotations.toVector, line, column)

  def label: Id

  def lhsOpt: Option[Exp]

  def id: Id

  def args: ISeq[Exp]

  def target: Id
}

private final case class
CallLocationImpl(label: Id, lhsOpt: Option[Exp],
                 id: Id, args: IVector[Exp], target: Id,
                 annotations: IVector[Annotation],
                 private[ast] var _line: Int,
                 private[ast] var _column: Int)
  extends CallLocation {

  override def make(children: AnyRef*): CallLocation = {
    val Seq(lbl: Id, l: Option[_], id: Id, args: IVector[_],
    target: Id, anns: IVector[_], ob: Integer, oe: Integer) =
      children
    CallLocationImpl(lbl, cast(l), id, cast(args), target,
      cast(anns), ob, oe)
  }
}


object BlockLocation {
  final def apply(label: Id, actions: ISeq[Action],
                  jump: Jump, annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): BlockLocation =
    BlockLocationImpl(label, actions.toVector, jump,
      annotations.toVector, line, column)

  final def unapply(l: BlockLocation) =
    Some(l.label, l.actions, l.jump)
}

sealed trait BlockLocation extends Location {
  final private[ast] def subTrees =
    (label, actions, annotations)

  final def apply(label: Id = this.label,
                  actions: ISeq[Action] = this.actions,
                  jump: Jump = this.jump,
                  annotations: ISeq[Annotation] = this.annotations,
                  line: Int = this.line,
                  column: Int = this.column): BlockLocation =
    BlockLocationImpl(label, actions.toVector, jump,
      annotations.toVector, line, column)

  def label: Id

  def actions: ISeq[Action]

  def jump: Jump
}

private final case class
BlockLocationImpl(label: Id,
                  actions: IVector[Action], jump: Jump,
                  annotations: IVector[Annotation],
                  private[ast] var _line: Int,
                  private[ast] var _column: Int)
  extends BlockLocation {

  {
    var i = 0
    while (i < actions.size) {
      actions(i).commandIndex = i
      i += 1
    }
    jump.commandIndex = i
  }

  override def make(children: AnyRef*): BlockLocation = {
    val Seq(lbl: Id, actions: IVector[_], j: Jump,
    anns: IVector[_], ob: Integer, oe: Integer) =
      children
    BlockLocationImpl(lbl, cast(actions), j,
      cast(anns), ob, oe)
  }
}


sealed trait Command extends Node with Annotated {
  private var _index = -1

  final def commandIndex = _index

  final private[ast] def commandIndex_=(i: Int): Unit = {
    _index = i
  }
}


sealed trait Action extends Command


object AssignAction {
  final def apply(lhs: Exp, rhs: Exp,
                  annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): AssignAction =
    AssignActionImpl(lhs, rhs,
      annotations.toVector, line, column)

  final def unapply(a: AssignAction) = Some((a.lhs, a.rhs))
}

sealed trait AssignAction extends Action {
  final private[ast] def subTrees = (lhs, rhs, annotations)

  final def copy(lhs: Exp = this.lhs,
                 rhs: Exp = this.rhs,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.column): AssignAction =
    AssignActionImpl(lhs, rhs,
      annotations.toVector, line, column)

  def lhs: Exp

  def rhs: Exp
}

private final case class
AssignActionImpl(lhs: Exp, rhs: Exp,
                 annotations: IVector[Annotation],
                 private[ast] var _line: Int,
                 private[ast] var _column: Int)
  extends AssignAction {

  override def make(children: AnyRef*): AssignAction = {
    val Seq(l: Exp, r: Exp, anns: IVector[_],
    ob: Integer, oe: Integer) =
      children
    AssignActionImpl(l, r, cast(anns), ob, oe)
  }
}


object AssertAction {
  final def apply(exp: Exp,
                  annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): AssertAction =
    AssertActionImpl(exp, annotations.toVector, line, column)

  final def unapply(a: AssertAction) = Some(a.exp)
}

sealed trait AssertAction extends Action {
  final private[ast] def subTrees = (exp, annotations)

  final def copy(exp: Exp = this.exp,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.column): AssertAction =
    AssertActionImpl(exp, annotations.toVector, line, column)

  def exp: Exp
}

private final case class
AssertActionImpl(exp: Exp,
                 annotations: IVector[Annotation],
                 private[ast] var _line: Int,
                 private[ast] var _column: Int)
  extends AssertAction {

  override def make(children: AnyRef*): AssertAction = {
    val Seq(e: Exp, anns: IVector[_],
    ob: Integer, oe: Integer) =
      children
    AssertActionImpl(e, cast(anns), ob, oe)
  }
}


object AssumeAction {
  final def apply(exp: Exp,
                  annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): AssumeAction =
    AssumeActionImpl(exp, annotations.toVector, line, column)

  final def unapply(a: AssumeAction) = Some(a.exp)
}

sealed trait AssumeAction extends Action {
  final private[ast] def subTrees = (exp, annotations)

  final def copy(exp: Exp = this.exp,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.column): AssumeAction =
    AssumeActionImpl(exp, annotations.toVector, line, column)

  def exp: Exp
}

private final case class
AssumeActionImpl(exp: Exp,
                 annotations: IVector[Annotation],
                 private[ast] var _line: Int,
                 private[ast] var _column: Int)
  extends AssumeAction {

  override def make(children: AnyRef*): AssumeAction = {
    val Seq(e: Exp, anns: IVector[_],
    ob: Integer, oe: Integer) =
      children
    AssumeActionImpl(e, cast(anns), ob, oe)
  }
}


object ExtAction {
  final def apply(id: Id, args: ISeq[Exp],
                  annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): ExtAction =
    ExtActionImpl(id, args.toVector,
      annotations.toVector, line, column)

  final def unapply(a: ExtAction) = Some(a.id, a.args)
}

sealed trait ExtAction extends Action {
  final private[ast] def subTrees = (id, args, annotations)

  final def copy(id: Id = this.id,
                 args: ISeq[Exp] = this.args,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.column): ExtAction =
    ExtActionImpl(id, args.toVector,
      annotations.toVector, line, column)

  def id: Id

  def args: ISeq[Exp]
}

private final case class
ExtActionImpl(id: Id, args: IVector[Exp],
              annotations: IVector[Annotation],
              private[ast] var _line: Int,
              private[ast] var _column: Int)
  extends ExtAction {

  override def make(children: AnyRef*): ExtAction = {
    val Seq(id: Id, args: IVector[_], anns: IVector[_],
    ob: Integer, oe: Integer) =
      children
    ExtActionImpl(id, cast(args), cast(anns), ob, oe)
  }
}


sealed trait Jump extends Command


object GotoJump {
  final def apply(target: Id,
                  annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): GotoJump =
    GotoJumpImpl(target, annotations.toVector, line, column)

  final def unapply(j: GotoJump) = Some(j.target)
}

sealed trait GotoJump extends Jump {
  final private[ast] def subTrees = (target, annotations)

  final def copy(target: Id = this.target,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.column): GotoJump =
    GotoJumpImpl(target, annotations.toVector, line, column)

  def target: Id
}

private final case class
GotoJumpImpl(target: Id,
             annotations: IVector[Annotation],
             private[ast] var _line: Int,
             private[ast] var _column: Int)
  extends GotoJump {

  override def make(children: AnyRef*): GotoJump = {
    val Seq(t: Id, anns: IVector[_],
    ob: Integer, oe: Integer) =
      children
    GotoJumpImpl(t, cast(anns), ob, oe)
  }
}


object IfJump {
  final def apply(exp: Exp, tTarget: Id, fTarget: Id,
                  annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): IfJump =
    IfJumpImpl(exp, tTarget, fTarget,
      annotations.toVector, line, column)

  final def unapply(j: IfJump) =
    Some((j.exp, j.tTarget, j.fTarget))
}

sealed trait IfJump extends Jump {
  final private[ast] def subTrees =
    (exp, tTarget, fTarget, annotations)

  final def copy(exp: Exp = this.exp,
                 tTarget: Id = this.tTarget,
                 fTarget: Id = this.fTarget,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.column): IfJump =
    IfJumpImpl(exp, tTarget, fTarget,
      annotations.toVector, line, column)

  def exp: Exp

  def tTarget: Id

  def fTarget: Id
}

private final case class
IfJumpImpl(exp: Exp, tTarget: Id, fTarget: Id,
           annotations: IVector[Annotation],
           private[ast] var _line: Int,
           private[ast] var _column: Int)
  extends IfJump {

  override def make(children: AnyRef*): IfJump = {
    val Seq(e: Exp, t: Id, f: Id, anns: IVector[_],
    ob: Integer, oe: Integer) =
      children
    IfJumpImpl(e, t, f, cast(anns), ob, oe)
  }
}


object ReturnJump {
  final def apply(expOpt: Option[Exp],
                  annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): ReturnJump =
    ReturnJumpImpl(expOpt, annotations.toVector,
      line, column)

  final def unapply(j: ReturnJump) = Some(j.expOpt)
}

sealed trait ReturnJump extends Jump {
  final private[ast] def subTrees = (expOpt, annotations)

  final def copy(expOpt: Option[Exp] = this.expOpt,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.column): ReturnJump =
    ReturnJumpImpl(expOpt, annotations.toVector,
      line, column)

  def expOpt: Option[Exp]
}

private final case class
ReturnJumpImpl(expOpt: Option[Exp],
               annotations: IVector[Annotation],
               private[ast] var _line: Int,
               private[ast] var _column: Int)
  extends ReturnJump {

  override def make(children: AnyRef*): ReturnJump = {
    val Seq(eo: Option[_], anns: IVector[_],
    ob: Integer, oe: Integer) =
      children
    ReturnJumpImpl(cast(eo), cast(anns), ob, oe)
  }
}


object SwitchJump {
  final def apply(exp: Exp, cases: ISeq[SwitchCase],
                  annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): SwitchJump =
    SwitchJumpImpl(exp, cases.toVector,
      annotations.toVector, line, column)

  final def unapply(j: SwitchJump) = Some((j.exp, j.cases))
}

sealed trait SwitchJump extends Jump {
  final private[ast] def subTrees = (exp, cases, annotations)

  final def copy(exp: Exp = this.exp,
                 cases: ISeq[SwitchCase] = this.cases,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.column): SwitchJump =
    SwitchJumpImpl(exp, cases.toVector,
      annotations.toVector, line, column)

  def exp: Exp

  def cases: ISeq[SwitchCase]
}

private final case class
SwitchJumpImpl(exp: Exp,
               cases: IVector[SwitchCase],
               annotations: IVector[Annotation],
               private[ast] var _line: Int,
               private[ast] var _column: Int)
  extends SwitchJump {

  override def make(children: AnyRef*): SwitchJump = {
    val Seq(e: Exp, cs: IVector[_], anns: IVector[_],
    ob: Integer, oe: Integer) =
      children
    SwitchJumpImpl(e, cast(cs), cast(anns), ob, oe)
  }
}


object SwitchCase {
  final def apply(expOpt: Option[LiteralExp], target: Id,
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): SwitchCase =
    SwitchCaseImpl(expOpt, target, line, column)

  final def unapply(j: SwitchCase) = Some(j.subTrees)
}

sealed trait SwitchCase extends Node {
  final private[ast] def subTrees = (expOpt, target)

  final def copy(expOpt: Option[LiteralExp] = this.expOpt,
                 target: Id = this.target,
                 line: Int = this.line,
                 column: Int = this.column): SwitchCase =
    SwitchCaseImpl(expOpt, target, line, column)

  def expOpt: Option[LiteralExp]

  def target: Id
}

private final case class
SwitchCaseImpl(expOpt: Option[LiteralExp],
               target: Id,
               private[ast] var _line: Int,
               private[ast] var _column: Int)
  extends SwitchCase {

  override def make(children: AnyRef*): SwitchCase = {
    val Seq(eo: Option[_], t: Id, ob: Integer, oe: Integer) =
      children
    SwitchCaseImpl(cast(eo), t, ob, oe)
  }
}


object ExtJump {
  final def apply(id: Id, args: ISeq[Exp],
                  annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): ExtJump =
    ExtJumpImpl(id, args.toVector, annotations.toVector,
      line, column)

  final def unapply(j: ExtJump) = Some((j.id, j.args))
}

sealed trait ExtJump extends Jump {
  final private[ast] def subTrees = (id, args, annotations)

  final def copy(id: Id = this.id,
                 args: ISeq[Exp] = this.args,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.column): ExtJump =
    ExtJumpImpl(id, args.toVector, annotations.toVector,
      line, column)

  def id: Id

  def args: ISeq[Exp]
}

private final case class
ExtJumpImpl(id: Id,
            args: IVector[Exp],
            annotations: IVector[Annotation],
            private[ast] var _line: Int,
            private[ast] var _column: Int)
  extends ExtJump {

  override def make(children: AnyRef*): ExtJump = {
    val Seq(id: Id, args: IVector[_], anns: IVector[_],
    ob: Integer, oe: Integer) =
      children
    ExtJumpImpl(id, cast(args), cast(anns), ob, oe)
  }
}


sealed trait Exp extends Node


object LiteralExp {
  final def apply(id: Id, raw: Raw,
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): LiteralExp =
    LiteralExpImpl(id, raw, line, column)

  final def unapply(e: LiteralExp) = Some(e.subTrees)
}

sealed trait LiteralExp extends Exp {
  final private[ast] def subTrees = (id, raw)

  final def copy(id: Id = this.id,
                 raw: Raw = this.raw,
                 line: Int = this.line,
                 column: Int = this.column): LiteralExp =
    LiteralExpImpl(id, raw, line, column)

  def id: Id

  def raw: Raw
}

private final case class
LiteralExpImpl(id: Id,
               raw: Raw,
               private[ast] var _line: Int,
               private[ast] var _column: Int)
  extends LiteralExp {

  override def make(children: AnyRef*): LiteralExp = {
    val Seq(id: Id, raw: Raw, ob: Integer, oe: Integer) =
      children
    LiteralExpImpl(id, raw, ob, oe)
  }
}


object IdExp {
  final def apply(id: Id,
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): IdExp =
    IdExpImpl(id, line, column)

  final def unapply(e: IdExp) = Some(e.id)
}

sealed trait IdExp extends Exp {
  final private[ast] def subTrees = Tuple1(id)

  final def copy(id: Id = this.id,
                 line: Int = this.line,
                 column: Int = this.column): IdExp =
    IdExp(id, line, column)

  def id: Id
}

private final case class
IdExpImpl(id: Id,
          private[ast] var _line: Int,
          private[ast] var _column: Int)
  extends IdExp {

  override def make(children: AnyRef*): IdExp = {
    val Seq(id: Id, ob: Integer, oe: Integer) =
      children
    IdExpImpl(id, ob, oe)
  }
}


object TupleExp {
  final def apply(exps: ISeq[Exp],
                  annotations: ISeq[Annotation],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): TupleExp =
    TupleExpImpl(exps.toVector, annotations.toVector,
      line, column)

  final def unapply(e: TupleExp) = Some(e.exps)
}

sealed trait TupleExp extends Exp with Annotated {
  final private[ast] def subTrees = (exps, annotations)

  final def copy(exps: ISeq[Exp] = this.exps,
                 annotations: ISeq[Annotation] = this.annotations,
                 line: Int = this.line,
                 column: Int = this.line): TupleExp =
    TupleExp(exps, annotations, line, column)

  def exps: ISeq[Exp]

  def annotations: ISeq[Annotation]
}

private final case class
TupleExpImpl(exps: IVector[Exp],
             annotations: IVector[Annotation],
             private[ast] var _line: Int,
             private[ast] var _column: Int)
  extends TupleExp {

  override def make(children: AnyRef*): TupleExp = {
    val Seq(es: IVector[_], anns: IVector[_],
    ob: Integer, oe: Integer) =
      children
    TupleExpImpl(cast(es), cast(anns), ob, oe)
  }
}


object BinaryExp {
  final def apply(left: Exp, op: Id, right: Exp,
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): BinaryExp =
    BinaryExpImpl(left, op, right, line, column)

  final def unapply(e: BinaryExp) = Some(e.subTrees)
}

sealed trait BinaryExp extends Exp {
  final private[ast] def subTrees = (left, op, right)

  final def copy(left: Exp = this.left,
                 op: Id = this.op,
                 right: Exp = this.right,
                 line: Int = this.line,
                 column: Int = this.column): BinaryExp =
    BinaryExp(left, op, right, line, column)

  def left: Exp

  def op: Id

  def right: Exp
}

private final case class
BinaryExpImpl(left: Exp, op: Id, right: Exp,
              private[ast] var _line: Int,
              private[ast] var _column: Int)
  extends BinaryExp {

  override def make(children: AnyRef*): BinaryExp = {
    val Seq(l: Exp, op: Id, r: Exp,
    ob: Integer, oe: Integer) =
      children
    BinaryExpImpl(l, op, r, ob, oe)
  }
}


object CallExp {
  final def apply(exp: Exp, args: ISeq[Exp],
                  line: Int = LOC_DEFAULT,
                  column: Int = LOC_DEFAULT): CallExp =
    CallExpImpl(exp, args.toVector, line, column)

  final def unapply(e: CallExp) = Some(e.subTrees)
}

sealed trait CallExp extends Exp {
  final private[ast] def subTrees = (exp, args)

  final def copy(exp: Exp = this.exp,
                 args: ISeq[Exp] = this.args,
                 line: Int = this.line,
                 column: Int = this.column): CallExp =
    CallExp(exp, args, line, column)

  def exp: Exp

  def args: ISeq[Exp]
}

private final case class
CallExpImpl(exp: Exp, args: IVector[Exp],
            private[ast] var _line: Int,
            private[ast] var _column: Int)
  extends CallExp {

  override def make(children: AnyRef*): CallExp = {
    val Seq(e: Exp, args: IVector[_], ob: Integer, oe: Integer) =
      children
    CallExpImpl(e, cast(args), ob, oe)
  }
}
