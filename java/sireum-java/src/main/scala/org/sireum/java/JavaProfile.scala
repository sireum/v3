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

package org.sireum.java

import org.sireum.pilar.ast._
import org.sireum.util._

object JavaProfile {
  final val annotationClassDesc = "Class"
  final val annotationTypeDesc = "Type"
  final val annotationTypeAnnotationDesc = "TypeAnnotation"
  final val annotationCatchDesc = "Catch"
  final val annotationGetStaticDesc = "GetStatic"
  final val annotationPutStaticDesc = "PutStatic"
  final val annotationLoadDesc = "Load"
  final val annotationStoreDesc = "Store"

  final val annotationGetStatic = Annotation(Id(annotationGetStaticDesc), RawLit(""))
  final val annotationPutStatic = Annotation(Id(annotationPutStaticDesc), RawLit(""))
  final val annotationLoad = Annotation(Id(annotationLoadDesc), RawLit(""))
  final val annotationStore = Annotation(Id(annotationStoreDesc), RawLit(""))

  final val byteDesc = "b"
  final val charDesc = "c"
  final val shortDesc = "s"
  final val intDesc = "i"
  final val longDesc = "l"
  final val floatDesc = "f"
  final val doubleDesc = "d"
  final val stringDesc = "str"
  final val typeDesc = "t"
  final val handleDesc = "h"

  final val objectDesc = "o"
  final val labelPrefix = "L"
  final val tempVarPrefix = "t$"
  final val localVarPrefix = "l$"
  final val thisLocalVarName = "this"

  final val addOp = "+"
  final val subOp = "-"
  final val mulOp = "*"
  final val divOp = "/"
  final val remOp = "%"
  final val negOp = "-"
  final val shlOp = "<<"
  final val shrOp = ">>"
  final val ushrOp = ">>>"
  final val andOp = "&"
  final val orOp = "|"
  final val xorOp = "^"
  final val cmpOp = ">=<"
  final val ltOp = "<"
  final val leOp = "<="
  final val gtOp = ">"
  final val geOp = ">="
  final val eqOp = "=="
  final val neOp = "!="
  final val fieldAccessOp = "."
  final val nullConstOp = "null"
  final val nullOp = "isNull"
  final val nonNullOp = "isNonNull"
  final val arrayLengthOp = "len"
  final val throwOp = "throw"
  final val monitorEnterOp = "monitorEnter"
  final val monitorExitOp = "monitorExit"
  final val newOp = "new"
  final val newArrayOp = "newArray"
  final val newMultiArrayOp = "newMultiArray"
  final val classOfOp = "classOf"
  final val methodTypeOp = "methodType"
  final val lineNumberOp = "lineNumber"
  final val invokeVirtualOp = "invokeVirtual"
  final val invokeSpecialOp = "invokeSpecial"
  final val invokeStaticOp = "invokeStatic"
  final val invokeInterfaceOp = "invokeInterface"
  final val invokeDynamicOp = "invokeDynamic"
  final val checkCastOp = "checkCast"
  final val instanceOfOp = "isInstanceOf"
  final val iaddOp = opSuffix(addOp, intDesc)
  final val isubOp = opSuffix(subOp, intDesc)
  final val imulOp = opSuffix(mulOp, intDesc)
  final val idivOp = opSuffix(divOp, intDesc)
  final val iremOp = opSuffix(addOp, intDesc)
  final val laddOp = opSuffix(addOp, longDesc)
  final val lsubOp = opSuffix(subOp, longDesc)
  final val lmulOp = opSuffix(mulOp, longDesc)
  final val ldivOp = opSuffix(divOp, longDesc)
  final val lremOp = opSuffix(addOp, longDesc)
  final val faddOp = opSuffix(addOp, floatDesc)
  final val fsubOp = opSuffix(subOp, floatDesc)
  final val fmulOp = opSuffix(mulOp, floatDesc)
  final val fdivOp = opSuffix(divOp, floatDesc)
  final val fremOp = opSuffix(addOp, floatDesc)
  final val daddOp = opSuffix(addOp, doubleDesc)
  final val dsubOp = opSuffix(subOp, doubleDesc)
  final val dmulOp = opSuffix(mulOp, doubleDesc)
  final val ddivOp = opSuffix(divOp, doubleDesc)
  final val dremOp = opSuffix(addOp, doubleDesc)
  final val inegOp = opSuffix(negOp, intDesc)
  final val lnegOp = opSuffix(negOp, longDesc)
  final val fnegOp = opSuffix(negOp, floatDesc)
  final val dnegOp = opSuffix(negOp, doubleDesc)
  final val ishlOp = opSuffix(shlOp, intDesc)
  final val lshlOp = opSuffix(shlOp, longDesc)
  final val ishrOp = opSuffix(shrOp, intDesc)
  final val lshrOp = opSuffix(shrOp, longDesc)
  final val iushrOp = opSuffix(ushrOp, intDesc)
  final val lushrOp = opSuffix(ushrOp, longDesc)
  final val iandOp = opSuffix(andOp, intDesc)
  final val landOp = opSuffix(andOp, longDesc)
  final val iorOp = opSuffix(orOp, intDesc)
  final val lorOp = opSuffix(orOp, longDesc)
  final val ixorOp = opSuffix(xorOp, intDesc)
  final val lxorOp = opSuffix(xorOp, longDesc)
  final val i2lOp = convOp(intDesc, longDesc)
  final val i2fOp = convOp(intDesc, floatDesc)
  final val i2dOp = convOp(intDesc, doubleDesc)
  final val l2iOp = convOp(longDesc, intDesc)
  final val l2fOp = convOp(longDesc, floatDesc)
  final val l2dOp = convOp(longDesc, doubleDesc)
  final val f2iOp = convOp(floatDesc, intDesc)
  final val f2lOp = convOp(floatDesc, longDesc)
  final val f2dOp = convOp(floatDesc, doubleDesc)
  final val d2iOp = convOp(doubleDesc, intDesc)
  final val d2lOp = convOp(doubleDesc, longDesc)
  final val d2fOp = convOp(doubleDesc, floatDesc)
  final val i2bOp = convOp(intDesc, byteDesc)
  final val i2cOp = convOp(intDesc, charDesc)
  final val i2sOp = convOp(intDesc, shortDesc)
  final val ieqOp = opSuffix(eqOp, intDesc)
  final val ineOp = opSuffix(neOp, intDesc)
  final val iltOp = opSuffix(ltOp, intDesc)
  final val ileOp = opSuffix(leOp, intDesc)
  final val igtOp = opSuffix(gtOp, intDesc)
  final val igeOp = opSuffix(geOp, intDesc)
  final val oeqOp = opSuffix(eqOp, objectDesc)
  final val oneOp = opSuffix(neOp, objectDesc)
  final val lcmpOp = opSuffix(cmpOp, longDesc)
  final val fcmplOp = opSuffix(ltOp, floatDesc)
  final val dcmplOp = opSuffix(ltOp, doubleDesc)
  final val fcmpgOp = opSuffix(gtOp, floatDesc)
  final val dcmpgOp = opSuffix(gtOp, doubleDesc)
  final val topType = meta.ObjectType("java.lang.Object")
  final val booleanArrayType = meta.ArrayType(meta.BooleanType)
  final val byteArrayType = meta.ArrayType(meta.ByteType)
  final val charArrayType = meta.ArrayType(meta.CharType)
  final val shortArrayType = meta.ArrayType(meta.ShortType)
  final val intArrayType = meta.ArrayType(meta.IntType)
  final val longArrayType = meta.ArrayType(meta.LongType)
  final val floatArrayType = meta.ArrayType(meta.FloatType)
  final val doubleArrayType = meta.ArrayType(meta.DoubleType)

  final val constDescs = Set(intDesc, floatDesc, longDesc, doubleDesc, stringDesc, handleDesc)
  final val invokeOps = Set(invokeInterfaceOp, invokeSpecialOp, invokeStaticOp, invokeVirtualOp)
  final val iifOps = Set(ieqOp, ineOp, iltOp, igeOp, igtOp, ileOp)
  final val loadStoreTypes = Set(meta.IntType, meta.LongType, meta.FloatType, meta.DoubleType, topType)

  final def isInvokeOp(op: String) = invokeOps.contains(op)

  final def isIifOp(op: String) = iifOps.contains(op)

  final def isOifOp(op: String) = op == oeqOp || op == oneOp

  final def isNullOp(op: String) = op == nullOp || op == nonNullOp

  final def toOifOp(b: Boolean): String = if (b) oeqOp else oneOp

  final def toNullOp(b: Boolean): String = if (b) nullOp else nonNullOp

  final def fromOifOp(op: String): Boolean = if (op == oeqOp) true else false

  final def fromNullOp(op: String): Boolean = if (op == nullOp) true else false

  final val intZeroLit = intLit(0)

  object ConstKind extends Enumeration {
    type Type = Value
    final val Byte, Short, Int, Float, Long, Double, String, Handle = Value

    final def to(ck: Type): String = ck match {
      case Byte => byteDesc
      case Short => shortDesc
      case Int => intDesc
      case Float => floatDesc
      case Long => longDesc
      case Double => doubleDesc
      case String => stringDesc
      case Handle => handleDesc
    }

    final def toType(ck: Type): meta.Type = ck match {
      case Byte => meta.ByteType
      case Short => meta.ShortType
      case Int => meta.IntType
      case Float => meta.FloatType
      case Long => meta.LongType
      case Double => meta.DoubleType
      case String => topType
      case Handle => topType
    }

    final def from(desc: String): Type = desc match {
      case `byteDesc` => Byte
      case `shortDesc` => Short
      case `intDesc` => Int
      case `floatDesc` => Float
      case `longDesc` => Long
      case `doubleDesc` => Double
      case `stringDesc` => String
      case `handleDesc` => Handle
    }
  }

  object InvokeOp extends Enumeration {
    type Type = Value
    final val Virtual, Special, Static, Interface = Value

    final def to(iop: Type): String = iop match {
      case Interface => invokeInterfaceOp
      case Special => invokeSpecialOp
      case Static => invokeStaticOp
      case Virtual => invokeVirtualOp
    }

    final def from(op: String): Type = op match {
      case `invokeInterfaceOp` => Interface
      case `invokeSpecialOp` => Special
      case `invokeStaticOp` => Static
      case `invokeVirtualOp` => Virtual
    }
  }

  object IcmpOp extends Enumeration {
    type Type = Value
    final val Eq, Ne, Lt, Ge, Gt, Le = Value

    final def to(cop: IcmpOp.Type): String = cop match {
      case IcmpOp.Eq => ieqOp
      case IcmpOp.Ne => ineOp
      case IcmpOp.Lt => iltOp
      case IcmpOp.Ge => igeOp
      case IcmpOp.Gt => igtOp
      case IcmpOp.Le => ileOp
    }

    final def from(op: String): IcmpOp.Type = op match {
      case `ieqOp` => IcmpOp.Eq
      case `ineOp` => IcmpOp.Ne
      case `iltOp` => IcmpOp.Lt
      case `igeOp` => IcmpOp.Ge
      case `igtOp` => IcmpOp.Gt
      case `ileOp` => IcmpOp.Le
    }
  }

  @inline
  private def convOp(from: String, to: String) =
    s"${from}2$$ to"

  @inline
  private def opSuffix(op: String, suffix: String) =
    s"${op}_$suffix"

  @inline
  def qFieldName(className: String, name: String) =
    s"$className.$name"

  @inline
  def qMethodName(className: String, name: String, desc: String) =
    s"$className.$name$desc"

  import Node._
  import PartialFunctionUtil.applyOpt

  // IincInsn
  //
  // <varName> := <varName2> +_i <increment>;
  object IincCmd extends CommandExtractor {
    final val extractor: Command --\ (String, Int) = {
      case AssignAction(
      IdExp(Id(varName)),
      BinaryExp(
      IdExp(Id(varName2)),
      Id(`iaddOp`),
      LiteralExp(_, ExtLit(increment: Int))), _)
        if varName == varName2 =>
        (varName, increment)
    }

    final def apply(varName: String, increment: Int): AssignAction =
      AssignAction(
        idExp(varName),
        BinaryExp(
          idExp(varName),
          Id(iaddOp),
          intLit(increment))
      )

    final def unapply(c: Command): Option[(String, Int)] =
      applyOpt(extractor, c)
  }

  // LdcInsn, IntInsn, Insn
  //
  // <varName> := <litId> «<rawValue>»;
  object ConstCmd extends CommandExtractor {

    final val extractor: Command --\ (String, ConstKind.Type, String) = {
      case AssignAction(
      IdExp(Id(varName)),
      LiteralExp(Id(litId), RawLit(rawValue)), _) =>
        (varName, ConstKind.from(litId), rawValue)
    }

    final def apply(varName: String, ck: ConstKind.Type, rawValue: String): AssignAction =
      AssignAction(
        idExp(varName),
        LiteralExp(Id(ConstKind.to(ck)), RawLit(rawValue)))

    final def unapply(c: Command): Option[(String, ConstKind.Type, String)] =
      applyOpt(extractor, c)
  }

  // LdcInsn
  //
  // <varName> := methodType(t«<tipe>»);
  object MethodTypeCmd extends CommandExtractor {
    final val extractor: Command --\ (String, meta.Type) = {
      case AssignAction(
      IdExp(Id(varName)),
      ExtExp(IdExp(Id(`methodTypeOp`)),
      Seq(LiteralExp(_, ExtLit(tipe: meta.Type)))), _) =>
        (varName, tipe)
    }

    final def apply(varName: String, tipe: meta.Type): AssignAction =
      AssignAction(
        idExp(varName),
        ExtExp(idExp(methodTypeOp), ivector(typeLit(tipe)))
      )

    final def unapply(c: Command): Option[(String, meta.Type)] =
      applyOpt(extractor, c)
  }

  // LdcInsn
  //
  // <varName> := classOf(t«<tipe>»);
  object ClassOfCmd extends CommandExtractor {
    final val extractor: Command --\ (String, meta.Type) = {
      case AssignAction(
      IdExp(Id(varName)),
      ExtExp(IdExp(Id(`classOfOp`)),
      Seq(LiteralExp(_, ExtLit(tipe: meta.Type)))), _) =>
        (varName, tipe)
    }

    final def apply(varName: String, tipe: meta.Type): AssignAction =
      AssignAction(
        idExp(varName),
        ExtExp(idExp(classOfOp), ivector(typeLit(tipe)))
      )

    final def unapply(c: Command): Option[(String, meta.Type)] =
      applyOpt(extractor, c)
  }

  // TableSwitchInsn, LookupSwitchInsn
  //
  // switch <varName>
  //   case i'<n_1> : <label_1>
  //   ...
  //   case i'<n_N> : <label_N>
  //   default      : <dflt>;
  object SwitchCmd extends CommandExtractor {
    final val extractor: Command --\ (String, Seq[(Int, String)], String) = {
      case SwitchJump(IdExp(Id(varName)), scs, _) =>
        (varName,
          for (sc@SwitchCase(Some(LiteralExp(_, ExtLit(n: Int))), Id(label)) <- scs)
            yield (n, label),
          scs.last.target.value)
    }

    final def apply(varName: String, dflt: String, scs: CSeq[(Int, String)]): SwitchJump =
      SwitchJump(
        idExp(varName),
        scs.toVector.map(p =>
          SwitchCase(Some(intLit(p._1)), Id(p._2))) :+
          SwitchCase(None, Id(dflt)))

    final def unapply(c: Command): Option[(String, Seq[(Int, String)], String)] =
      applyOpt(extractor, c)
  }

  // IntInsn, TypeInsn
  //
  // <varName> := newArray(<sizeVarName>, t«<tipe>»);
  object NewArrayCmd extends CommandExtractor {
    final val extractor: Command --\ (String, String, meta.Type) = {
      case AssignAction(
      IdExp(Id(varName)),
      ExtExp(IdExp(Id(`newArrayOp`)),
      Seq(IdExp(Id(sizeVarName)), LiteralExp(_, ExtLit(tipe: meta.Type)))), _) =>
        (varName, sizeVarName, tipe)
    }

    final def apply(varName: String, sizeVarName: String, tipe: meta.Type): AssignAction =
      AssignAction(
        idExp(varName),
        ExtExp(idExp(newArrayOp),
          ivector(idExp(sizeVarName), typeLit(tipe))))

    final def unapply(c: Command): Option[(String, String, meta.Type)] =
      applyOpt(extractor, c)
  }

  // LineNumber
  //
  // ext lineNumber(<line>);
  object LineNumberCmd extends CommandExtractor {
    final val extractor: Command --\ Tuple1[Int] = {
      case ExtAction(
      Id(`lineNumberOp`),
      Seq(LiteralExp(_, ExtLit(line: Int))), _) => Tuple1(line)
    }

    final def apply(line: Int): ExtAction =
      ExtAction(Id(lineNumberOp), ivector(intLit(line)))

    final def unapply(c: Command): Option[Int] =
      applyOpt(extractor, c).map(_._1)
  }

  // MultiANewArrayInsn
  //
  // <varName> := newMultiArray(t«<tipe>», <argVarName_1>, ..., <argVarName_N>);
  object NewMultiArrayCmd extends CommandExtractor {
    final val extractor: Command --\ (String, meta.Type, CSeq[IdExp]) = {
      case AssignAction(
      IdExp(Id(varName)),
      ExtExp(IdExp(Id(`newMultiArrayOp`)),
      Seq(LiteralExp(_, ExtLit(tipe: meta.Type)), args@_*)), _) =>
        (varName, tipe, args.map(_.asInstanceOf[IdExp]))
    }

    final def apply(varName: String, tipe: meta.Type, argVarNames: CSeq[IdExp]): AssignAction =
      AssignAction(
        idExp(varName),
        ExtExp(idExp(newMultiArrayOp), typeLit(tipe) +: argVarNames.toVector))

    final def unapply(c: Command): Option[(String, meta.Type, CSeq[IdExp])] =
      applyOpt(extractor, c)
  }

  // FieldInsn
  //
  // <varName> := <fieldName> @GetStatic @Type«<tipe>»;
  object GetStaticCmd extends CommandExtractor {
    final val extractor: Command --\ (String, String, meta.Type) = {
      case AssignAction(
      IdExp(Id(varName)),
      IdExp(Id(fieldName)),
      Seq(
      `annotationGetStatic`,
      Annotation(_, ExtLit(tipe: meta.Type)), _*)) =>
        (varName, fieldName, tipe)
    }

    final def apply(varName: String, fieldName: String, tipe: meta.Type): AssignAction =
      AssignAction(
        idExp(varName),
        idExp(fieldName),
        ivector(annotationGetStatic, typeAnnotation(tipe)))

    final def unapply(c: Command): Option[(String, String, meta.Type)] =
      applyOpt(extractor, c)
  }

  // FieldInsn
  //
  // <fieldName> := <varName> @PutStatic @Type«<tipe>»;
  object PutStaticCmd extends CommandExtractor {
    final val extractor: Command --\ (String, String, meta.Type) = {
      case AssignAction(
      IdExp(Id(fieldName)),
      IdExp(Id(varName)),
      Seq(
      `annotationPutStatic`,
      Annotation(_, ExtLit(tipe: meta.Type)), _*)) =>
        (fieldName, varName, tipe)
    }

    final def apply(fieldName: String, varName: String, tipe: meta.Type): AssignAction =
      AssignAction(
        idExp(fieldName),
        idExp(varName),
        ivector(annotationPutStatic, typeAnnotation(tipe)))

    final def unapply(c: Command): Option[(String, String, meta.Type)] =
      applyOpt(extractor, c)
  }

  // FieldInsn
  //
  // <varName> := <objectVarName> . <fieldName> @Type«<tipe>»;
  object GetFieldCmd extends CommandExtractor {
    final val extractor: Command --\ (String, String, String, meta.Type) = {
      case AssignAction(
      IdExp(Id(varName)),
      BinaryExp(IdExp(Id(objectVarName)), Id(`fieldAccessOp`), IdExp(Id(fieldName))),
      Seq(Annotation(_, ExtLit(tipe: meta.Type)), _*)) =>
        (varName, objectVarName, fieldName, tipe)
    }

    final def apply(varName: String, objectVarName: String, fieldName: String, tipe: meta.Type): AssignAction =
      AssignAction(
        idExp(varName),
        BinaryExp(idExp(objectVarName), Id(fieldAccessOp), idExp(fieldName)),
        ivector(typeAnnotation(tipe)))

    final def unapply(c: Command): Option[(String, String, String, meta.Type)] =
      applyOpt(extractor, c)
  }

  // FieldInsn
  //
  // <objectVarName> . <fieldName> := <varName> @Type«<tipe>»;
  object PutFieldCmd extends CommandExtractor {
    final val extractor: Command --\ (String, String, String, meta.Type) = {
      case AssignAction(
      BinaryExp(IdExp(Id(objectVarName)), Id(`fieldAccessOp`), IdExp(Id(fieldName))),
      IdExp(Id(varName)),
      Seq(Annotation(_, ExtLit(tipe: meta.Type)), _*)) =>
        (objectVarName, fieldName, varName, tipe)
    }

    final def apply(objectVarName: String, fieldName: String, varName: String, tipe: meta.Type): AssignAction =
      AssignAction(
        BinaryExp(idExp(objectVarName), Id(fieldAccessOp), idExp(fieldName)),
        idExp(varName),
        ivector(typeAnnotation(tipe)))

    final def unapply(c: Command): Option[(String, String, String, meta.Type)] =
      applyOpt(extractor, c)
  }

  // MethodInsn
  //
  // #<labelId> call [<lhsOpt> :=] <op>(<methodName>, <n>, (<argVarName_1>, ..., <argVarName_N>)) goto <nextLabelId>);
  //
  // where <op> ::= invokeVirtual | invokeSpecial | invokeStatic | invokeInterface
  //       <n>  ::= 0, if <itf> is false
  //              | 1, otherwise
  object InvokeLoc extends LocationExtractor {
    final val extractor: Location --\ (InvokeOp.Type, String, Option[String], String, Boolean, CSeq[IdExp], String) = {
      case CallLocation(Id(labelId), lhsOpt, Id(op), Seq(IdExp(Id(methodName)), LiteralExp(_, ExtLit(n: Int)), TupleExp(argVarNames, _)), Id(nextLabelId), _) if isInvokeOp(op) =>
        (InvokeOp.from(op), labelId, for (lhs@IdExp(Id(varName)) <- lhsOpt) yield varName, methodName, if (n == 0) false else true, argVarNames.map(_.asInstanceOf[IdExp]), nextLabelId)
    }

    final def apply(labelId: String, lhsOpt: Option[String], iop: InvokeOp.Type, methodName: String, itf: Boolean, argsVarNames: CSeq[IdExp], nextLabelId: String): CallLocation = {
      CallLocation(Id(labelId), lhsOpt.map(idExp), Id(InvokeOp.to(iop)), ivector(idExp(methodName), intLit(if (itf) 1 else 0), TupleExp(argsVarNames.toVector)), Id(nextLabelId))
    }

    final def unapply(l: Location): Option[(InvokeOp.Type, String, Option[String], String, Boolean, CSeq[IdExp], String)] =
      applyOpt(extractor, l)

    private[java] final def apply(lhsOpt: Option[String], iop: InvokeOp.Type, methodName: String, itf: Boolean, argVarNames: CSeq[IdExp], nextLabelId: String): ExtJump =
      lhsOpt match {
        case Some(varName) =>
          ExtJump(Id(InvokeOp.to(iop)), ivector(idExp(varName), idExp(methodName), intLit(if (itf) 1 else 0), TupleExp(argVarNames.toVector), idExp(nextLabelId)))
        case _ =>
          ExtJump(Id(InvokeOp.to(iop)), ivector(idExp(methodName), intLit(if (itf) 1 else 0), TupleExp(argVarNames.toVector), idExp(nextLabelId)))
      }

    private[java] final def unapply(c: Command): Option[(Option[String], InvokeOp.Type, String, Boolean, CSeq[IdExp], String)] =
      c match {
        case ExtJump(Id(op), Seq(IdExp(Id(varName)), IdExp(Id(methodName)), LiteralExp(_, ExtLit(n: Int)), TupleExp(argVarNames, _), IdExp(Id(nextLabelId))), _) if isInvokeOp(op) =>
          Some((Some(varName), InvokeOp.from(op), methodName, if (n == 0) false else true, argVarNames.map(_.asInstanceOf[IdExp]), nextLabelId))
        case ExtJump(Id(op), Seq(IdExp(Id(methodName)), LiteralExp(_, ExtLit(n: Int)), TupleExp(argVarNames, _), IdExp(Id(nextLabelId))), _) if isInvokeOp(op) =>
          Some((None, InvokeOp.from(op), methodName, if (n == 0) false else true, argVarNames.map(_.asInstanceOf[IdExp]), nextLabelId))
        case _ => None
      }
  }

  // JumpInsn
  //
  // if <varName> <op> i'0 then <trueLabel> else <falseLabel>;
  //
  // where <op> ::= ==_i | !=_i | >_i | >=_i | <_i | <=_i
  //       <falseLabel> should be next block's label
  object IfInt0Cmd extends CommandExtractor {
    final val extractor: Command --\ (String, IcmpOp.Type, String) = {
      case IfJump(BinaryExp(IdExp(Id(varName)), Id(op), LiteralExp(_, ExtLit(0))), Id(trueLabel), _, _) if isIifOp(op) =>
        (varName, IcmpOp.from(op), trueLabel)
    }

    final def apply(varName: String, cop: IcmpOp.Type, trueLabel: String, falseLabel: String): IfJump =
      IfJump(BinaryExp(idExp(varName), Id(IcmpOp.to(cop)), intZeroLit), Id(trueLabel), Id(falseLabel))

    final def unapply(c: Command): Option[(String, IcmpOp.Type, String)] =
      applyOpt(extractor, c)
  }

  // JumpInsn
  //
  // if <varName1> <op> <varName2> then <trueLabel> else <falseLabel>;
  //
  // where <op> ::= ==_i | !=_i | >_i | >=_i | <_i | <=_i
  //       <falseLabel> should be next block's label
  object IfIntCmd extends CommandExtractor {
    final val extractor: Command --\ (String, IcmpOp.Type, String, String) = {
      case IfJump(BinaryExp(IdExp(Id(varName1)), Id(op), IdExp(Id(varName2))), Id(trueLabel), _, _) if isIifOp(op) =>
        (varName1, IcmpOp.from(op), varName2, trueLabel)
    }

    final def apply(varName1: String, cop: IcmpOp.Type, varName2: String, trueLabel: String, falseLabel: String): IfJump =
      IfJump(BinaryExp(idExp(varName1), Id(IcmpOp.to(cop)), idExp(varName2)), Id(trueLabel), Id(falseLabel))

    final def unapply(c: Command): Option[(String, IcmpOp.Type, String, String)] =
      applyOpt(extractor, c)
  }

  // JumpInsn
  //
  // if <varName1> <op> <varName2> then <trueLabel> else <falseLabel>;
  //
  // where <op> ::= ==_o | !=_o
  //       <falseLabel> should be next block's label
  object IfObjectCmd extends CommandExtractor {
    final val extractor: Command --\ (String, Boolean, String, String) = {
      case IfJump(BinaryExp(IdExp(Id(varName1)), Id(op), IdExp(Id(varName2))), Id(trueLabel), _, _) if isOifOp(op) =>
        (varName1, fromOifOp(op), varName2, trueLabel)
    }

    final def apply(varName1: String, isEq: Boolean, varName2: String, trueLabel: String, falseLabel: String): IfJump =
      IfJump(BinaryExp(idExp(varName1), Id(toOifOp(isEq)), idExp(varName2)), Id(trueLabel), Id(falseLabel))

    final def unapply(c: Command): Option[(String, Boolean, String, String)] =
      applyOpt(extractor, c)
  }

  // JumpInsn
  //
  // if <op>(<varName>) then <trueLabel> else <falseLabel>;
  //
  // where <op> ::= isNull, if <isNull> is true
  //              | isNonNull, otherwise
  //       <falseLabel> should be next block's label
  object IfNullCmd extends CommandExtractor {
    final val extractor: Command --\ (String, Boolean, String) = {
      case IfJump(ExtExp(IdExp(Id(op)), Seq(IdExp(Id(varName)))), Id(trueLabel), _, _) if isNullOp(op) =>
        (varName, fromNullOp(op), trueLabel)
    }

    final def apply(varName: String, isNull: Boolean, trueLabel: String, falseLabel: String): IfJump =
      IfJump(ExtExp(IdExp(Id(toNullOp(isNull))), ivector(IdExp(Id(varName)))), Id(trueLabel), Id(falseLabel))

    final def unapply(c: Command): Option[(String, Boolean, String)] =
      applyOpt(extractor, c)
  }

  // JumpInsn
  //
  // goto <label>;
  object GotoCmd extends CommandExtractor {
    final val extractor: Command --\ Tuple1[String] = {
      case GotoJump(Id(label), _) => Tuple1(label)
    }

    final def apply(label: String): GotoJump =
      GotoJump(Id(label))

    final def unapply(c: Command): Option[String] =
      applyOpt(extractor, c).map(_._1)
  }

  // VarInsn
  //
  // <lVarName> := <rVarName> @Load [@Type«<tipe>»];
  //
  // note: <tipe> is inserted if it is not an object type
  object LoadCmd extends CommandExtractor {
    final val extractor: Command --\ (String, String, meta.Type) = {
      case AssignAction(
      IdExp(Id(lVarName)),
      IdExp(Id(rVarName)),
      Seq(`annotationLoad`, anns@_*)) =>
        anns match {
          case Seq(Annotation(Id(`annotationTypeDesc`), ExtLit(tipe: meta.Type)), _*) =>
            (lVarName, rVarName, tipe)
          case _ =>
            (lVarName, rVarName, topType)
        }
    }

    final def apply(lVarName: String, rVarName: String, tipe: meta.Type): AssignAction = {
      assert(loadStoreTypes.contains(tipe))
      AssignAction(
        idExp(lVarName),
        idExp(rVarName),
        if (tipe == topType) ivector(annotationLoad) else ivector(annotationLoad, typeAnnotation(tipe)))
    }

    final def unapply(c: Command): Option[(String, String, meta.Type)] =
      applyOpt(extractor, c)
  }

  // VarInsn
  //
  // <lVarName> := <rVarName> @Store [@Type«<tipe>»];
  //
  // note: <tipe> is inserted if it is not an object type
  object StoreCmd extends CommandExtractor {
    final val extractor: Command --\ (String, String, meta.Type) = {
      case AssignAction(
      IdExp(Id(lVarName)),
      IdExp(Id(rVarName)),
      Seq(`annotationStore`, anns@_*)) =>
        anns match {
          case Seq(Annotation(Id(`annotationTypeDesc`), ExtLit(tipe: meta.Type)), _*) =>
            (lVarName, rVarName, tipe)
          case _ =>
            (lVarName, rVarName, topType)
        }
    }

    final def apply(lVarName: String, rVarName: String, tipe: meta.Type): AssignAction = {
      assert(loadStoreTypes.contains(tipe))
      AssignAction(
        idExp(lVarName),
        idExp(rVarName),
        if (tipe == topType) ivector(annotationStore) else ivector(annotationStore, typeAnnotation(tipe)))
    }

    final def unapply(c: Command): Option[(String, String, meta.Type)] =
      applyOpt(extractor, c)
  }

  // TypeInsn
  //
  // <varName> := new(t«<tipe>»);
  object NewCmd extends CommandExtractor {
    final val extractor: Command --\ (String, meta.ObjectType) = {
      case AssignAction(
      IdExp(Id(varName)),
      ExtExp(IdExp(Id(`newOp`)),
      Seq(LiteralExp(_, ExtLit(tipe: meta.ObjectType)))), _) =>
        (varName, tipe)
    }

    final def apply(varName: String, tipe: meta.ObjectType): AssignAction =
      AssignAction(
        idExp(varName),
        ExtExp(idExp(newOp),
          ivector(typeLit(tipe))))

    final def unapply(c: Command): Option[(String, meta.ObjectType)] =
      applyOpt(extractor, c)
  }

  // TypeInsn
  //
  // ext checkCast(<varName>, t«<tipe>»);
  object CheckCastCmd extends CommandExtractor {
    final val extractor: Command --\ (String, meta.Type) = {
      case ExtAction(Id(`checkCastOp`),
      Seq(IdExp(Id(varName)), LiteralExp(_, ExtLit(tipe: meta.Type))), _) =>
        (varName, tipe)
    }

    final def apply(varName: String, tipe: meta.Type): ExtAction =
      ExtAction(Id(checkCastOp),
        ivector(idExp(varName), typeLit(tipe)))

    final def unapply(c: Command): Option[(String, meta.Type)] =
      applyOpt(extractor, c)
  }

  // TypeInsn
  //
  // <varName> := instanceOf(<objectVarName>, t«<tipe>»);
  object InstanceOfCmd extends CommandExtractor {
    final val extractor: Command --\ (String, String, meta.Type) = {
      case AssignAction(
      IdExp(Id(varName)),
      ExtExp(IdExp(Id(`instanceOfOp`)),
      Seq(IdExp(Id(objectVarName)), LiteralExp(_, ExtLit(tipe: meta.Type)))), _) =>
        (varName, objectVarName, tipe)
    }

    final def apply(varName: String, objectVarName: String, tipe: meta.Type): AssignAction =
      AssignAction(
        idExp(varName),
        ExtExp(idExp(instanceOfOp),
          ivector(idExp(objectVarName), typeLit(tipe))))

    final def unapply(c: Command): Option[(String, String, meta.Type)] =
      applyOpt(extractor, c)
  }

  @inline
  private def idExp(name: String) = IdExp(Id(name))

  @inline
  private def stringLit(s: String) = LiteralExp(Id(stringDesc), ExtLit(s))

  @inline
  private def intLit(n: Int) = LiteralExp(Id(intDesc), ExtLit(n))

  @inline
  private def typeLit(tipe: meta.Type): LiteralExp =
    LiteralExp(Id(typeDesc), ExtLit(tipe))

  @inline
  private def typeAnnotation(tipe: meta.Type): Annotation =
    Annotation(Id(annotationTypeDesc), ExtLit(tipe))
}
