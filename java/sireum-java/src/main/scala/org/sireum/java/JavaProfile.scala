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
  final val annotationGetDesc = "Get"
  final val annotationPutDesc = "Put"

  final val annotationGet = Annotation(Id(annotationGetDesc), RawLit(""))
  final val annotationPut = Annotation(Id(annotationPutDesc), RawLit(""))

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
  final val nullOp = "null"
  final val isNullOp = "isNull"
  final val isNonNullOp = "isNonNull"
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
  object ConstCmd extends CommandExtractor {

    final val extractor: Command --\ (String, String, String) = {
      case AssignAction(
      IdExp(Id(varName)),
      LiteralExp(Id(litId), RawLit(rawValue)), _) =>
        (varName, litId, rawValue)
    }

    final def apply(varName: String, litId: String, rawValue: String): AssignAction =
      AssignAction(
        idExp(varName),
        LiteralExp(Id(litId), RawLit(rawValue)))

    final def unapply(c: Command): Option[(String, String, String)] =
      applyOpt(extractor, c)
  }

  // LdcInsn
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

  // IntInsn
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
  object NewMultiArrayCmd extends CommandExtractor {
    final val extractor: Command --\ (String, meta.Type, CSeq[Exp]) = {
      case AssignAction(
      IdExp(Id(varName)),
      ExtExp(IdExp(Id(`newMultiArrayOp`)), args), _) =>
        val LiteralExp(_, ExtLit(tipe: meta.Type)) = args.head
        (varName, tipe, args.tail)
    }

    final def apply(varName: String, tipe: meta.Type, args: CSeq[Exp]): AssignAction =
      AssignAction(
        idExp(varName),
        ExtExp(idExp(newMultiArrayOp), typeLit(tipe) +: args.toVector))

    final def unapply(c: Command): Option[(String, meta.Type, CSeq[Exp])] =
      applyOpt(extractor, c)
  }

  // FieldInsn
  object GetStaticCmd extends CommandExtractor {
    final val extractor: Command --\ (String, String, meta.Type) = {
      case AssignAction(
      IdExp(Id(varName)),
      IdExp(Id(fieldName)),
      Seq(
      `annotationGet`,
      Annotation(_, ExtLit(tipe: meta.Type)))) =>
        (varName, fieldName, tipe)
    }

    final def apply(varName: String, fieldName: String, tipe: meta.Type): AssignAction =
      AssignAction(
        idExp(varName),
        idExp(fieldName),
        ivector(annotationGet, typeAnnotation(tipe)))

    final def unapply(c: Command): Option[(String, String, meta.Type)] =
      applyOpt(extractor, c)
  }

  // FieldInsn
  object PutStaticCmd extends CommandExtractor {
    final val extractor: Command --\ (String, String, meta.Type) = {
      case AssignAction(
      IdExp(Id(fieldName)),
      IdExp(Id(varName)),
      Seq(
      `annotationPut`,
      Annotation(_, ExtLit(tipe: meta.Type)))) =>
        (fieldName, varName, tipe)
    }

    final def apply(fieldName: String, varName: String, tipe: meta.Type): AssignAction =
      AssignAction(
        idExp(fieldName),
        idExp(varName),
        ivector(annotationPut, typeAnnotation(tipe)))

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
