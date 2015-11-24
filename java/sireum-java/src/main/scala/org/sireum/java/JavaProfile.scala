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

  private[java] object Helper {
    final val annotationClassDesc = "Class"
    final val annotationTypeDesc = "Type"
    final val annotationTypeAnnotationDesc = "TypeAnnotation"
    final val annotationCatchDesc = "Catch"
    final val annotationGetStaticDesc = "GetStatic"
    final val annotationPutStaticDesc = "PutStatic"
    final val annotationLoadDesc = "Load"
    final val annotationStoreDesc = "Store"
    final val annotationArrayLoadDesc = "ArrayLoad"
    final val annotationArrayStoreDesc = "ArrayStore"

    final val annotationGetStatic = Annotation(Id(annotationGetStaticDesc), RawLit(""))
    final val annotationPutStatic = Annotation(Id(annotationPutStaticDesc), RawLit(""))
    final val annotationLoad = Annotation(Id(annotationLoadDesc), RawLit(""))
    final val annotationStore = Annotation(Id(annotationStoreDesc), RawLit(""))
    final val annotationArrayLoad = Annotation(Id(annotationArrayLoadDesc), RawLit(""))
    final val annotationArrayStore = Annotation(Id(annotationArrayStoreDesc), RawLit(""))

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
    final val iIfOps = Set(ieqOp, ineOp, iltOp, igeOp, igtOp, ileOp)
    final val loadStoreTypes = Set(meta.IntType, meta.LongType, meta.FloatType, meta.DoubleType, topType)
    final val binOps =
      Set(iaddOp, laddOp, faddOp, daddOp, isubOp, lsubOp, fsubOp, dsubOp,
        imulOp, lmulOp, fmulOp, dmulOp, idivOp, ldivOp, fdivOp, ddivOp,
        iremOp, lremOp, fremOp, dremOp, ishlOp, lshlOp, ishrOp, lshrOp, iushrOp, lushrOp,
        iandOp, landOp, iorOp, lorOp, ixorOp, lxorOp, lcmpOp, fcmplOp, fcmpgOp, dcmplOp, dcmpgOp)
    final val unOps =
      Set(inegOp, lnegOp, fnegOp, dnegOp, i2lOp, i2fOp, i2dOp, l2iOp, l2fOp, l2dOp,
        f2iOp, f2lOp, f2dOp, d2iOp, d2lOp, d2fOp, i2bOp, i2cOp, i2sOp, arrayLengthOp)

    final val intZeroLit = intLit(0)

    @inline
    final def isInvokeOp(op: String) = invokeOps.contains(op)

    @inline
    final def isIIfOp(op: String) = iIfOps.contains(op)

    @inline
    final def isOIfOp(op: String) = op == oeqOp || op == oneOp

    @inline
    final def isNullOp(op: String) = op == nullOp || op == nonNullOp

    @inline
    final def toOIfOp(b: Boolean): String = if (b) oeqOp else oneOp

    @inline
    final def toNullOp(b: Boolean): String = if (b) nullOp else nonNullOp

    @inline
    final def fromOIfOp(op: String): Boolean = op == oeqOp

    @inline
    final def fromNullOp(op: String): Boolean = op == nullOp

    @inline
    final def isBinOp(op: String): Boolean = binOps.contains(op)

    @inline
    final def isUnOp(op: String): Boolean = unOps.contains(op)

    @inline
    final def isMonitorOp(op: String): Boolean = op == monitorEnterOp || op == monitorExitOp

    @inline
    final def toMonitorOp(b: Boolean): String = if (b) monitorEnterOp else monitorExitOp

    @inline
    final def fromMonitorOp(op: String): Boolean = op == monitorEnterOp

    @inline
    final def idExp(name: String) = IdExp(Id(name))

    @inline
    final def intLit(n: Int) = LiteralExp(Id(intDesc), ExtLit(n))

    @inline
    final def stringLit(s: String) = LiteralExp(Id(stringDesc), ExtLit(s))

    @inline
    final def typeLit(tipe: meta.Type): LiteralExp =
      LiteralExp(Id(typeDesc), ExtLit(tipe))

    @inline
    final def typeAnnotation(tipe: meta.Type): Annotation =
      Annotation(Id(annotationTypeDesc), ExtLit(tipe))

    @inline
    final def convOp(from: String, to: String) =
      s"${from}2$$ to"

    @inline
    final def opSuffix(op: String, suffix: String) =
      s"${op}_$suffix"

    @inline
    final def qFieldName(className: String, name: String) =
      s"$className.$name"

    @inline
    final def qMethodName(className: String, name: String, desc: String) =
      s"$className.$name$desc"
  }

  import Helper._

  object ConstKind extends Enumeration {
    type Type = Value
    final val Byte, Short, Int, Float, Long, Double, String, Handle = Value
    final val to: IMap[Type, String] = Map(
      Byte -> byteDesc, Short -> shortDesc, Int -> intDesc, Float -> floatDesc,
      Long -> longDesc, Double -> doubleDesc, String -> stringDesc, Handle -> handleDesc
    )
    final val toType: IMap[Type, meta.Type] = Map(
      Byte -> meta.ByteType, Short -> meta.ShortType, Int -> meta.IntType,
      Float -> meta.FloatType, Long -> meta.LongType, Double -> meta.DoubleType,
      String -> topType, Handle -> topType
    )
    final val from: IMap[String, Type] = to.map(p => (p._2, p._1))
  }

  object InvokeOp extends Enumeration {
    type Type = Value
    final val Virtual, Special, Static, Interface = Value
    final val to: IMap[Type, String] = Map(
      Interface -> invokeInterfaceOp, Special -> invokeSpecialOp,
      Static -> invokeStaticOp, Virtual -> invokeVirtualOp
    )
    final val from: IMap[String, Type] = to.map(p => (p._2, p._1))
  }

  object ICmpOp extends Enumeration {
    type Type = Value
    final val Eq, Ne, Lt, Ge, Gt, Le = Value
    final val to: IMap[Type, String] = Map(
      Eq -> ieqOp, Ne -> ineOp, Lt -> iltOp, Ge -> igeOp, Gt -> igtOp, Le -> ileOp
    )
    final val from: IMap[String, Type] = to.map(p => (p._2, p._1))
  }

  object BinOp extends Enumeration {
    type Type = Value
    final val IAdd, LAdd, FAdd, DAdd, ISub, LSub, FSub, DSub, IMul, LMul, FMul, DMul,
    IDiv, LDiv, FDiv, DDiv, IRem, LRem, FRem, DRem, IShl, LShl, IShr, LShr, IUshr, LUshr,
    IAnd, LAnd, IOr, LOr, IXor, LXor, LCmp, FCmpl, FCmpg, DCmpl, DCmpg = Value
    final val to: IMap[Type, String] = Map(
      IAdd -> iaddOp, LAdd -> laddOp, FAdd -> faddOp, DAdd -> daddOp, ISub -> isubOp,
      LSub -> lsubOp, FSub -> fsubOp, DSub -> dsubOp, IMul -> imulOp, LMul -> lmulOp,
      FMul -> fmulOp, DMul -> dmulOp, IDiv -> idivOp, LDiv -> ldivOp, FDiv -> fdivOp,
      DDiv -> ddivOp, IRem -> iremOp, LRem -> lremOp, FRem -> fremOp, DRem -> dremOp,
      IShl -> ishlOp, LShl -> lshlOp, IShr -> ishrOp, LShr -> lshrOp, IUshr -> iushrOp,
      LUshr -> lushrOp, IAnd -> iandOp, LAnd -> landOp, IOr -> iorOp, LOr -> lorOp,
      IXor -> ixorOp, LXor -> lxorOp, LCmp -> lcmpOp, FCmpl -> fcmplOp, FCmpg -> fcmpgOp,
      DCmpl -> dcmplOp, DCmpg -> dcmpgOp
    )
    final val from: IMap[String, Type] = to.map(p => (p._2, p._1))
  }

  object UnOp extends Enumeration {
    type Type = Value
    final val INeg, LNeg, FNeg, DNeg, I2L, I2F, I2D, L2I, L2F, L2D,
    F2I, F2L, F2D, D2I, D2L, D2F, I2B, I2C, I2S, ArrayLength = Value
    final val to: IMap[Type, String] = Map(
      INeg -> inegOp, LNeg -> lnegOp, FNeg -> fnegOp, DNeg -> dnegOp, I2L -> i2lOp,
      I2F -> i2fOp, I2D -> i2dOp, L2I -> l2iOp, L2F -> l2fOp, L2D -> l2dOp,
      F2I -> f2iOp, F2L -> f2lOp, F2D -> f2dOp, D2I -> d2iOp, D2L -> d2lOp,
      D2F -> d2fOp, I2B -> i2bOp, I2C -> i2cOp, I2S -> i2sOp, ArrayLength -> arrayLengthOp
    )
    final val from: IMap[String, Type] = to.map(p => (p._2, p._1))
  }

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
    final val extractor: Command --\ (String, meta.Type, CSeq[String]) = {
      case AssignAction(
      IdExp(Id(varName)),
      ExtExp(IdExp(Id(`newMultiArrayOp`)),
      Seq(LiteralExp(_, ExtLit(tipe: meta.Type)), args@_*)), _) =>
        (varName, tipe, args.map(_.asInstanceOf[IdExp].id.value))
    }

    final def apply(varName: String, tipe: meta.Type, argVarNames: CSeq[String]): AssignAction =
      AssignAction(
        idExp(varName),
        ExtExp(idExp(newMultiArrayOp), typeLit(tipe) +: argVarNames.toVector.map(idExp)))

    final def unapply(c: Command): Option[(String, meta.Type, CSeq[String])] =
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
    final val extractor: Location --\ (InvokeOp.Type, String, Option[String], String, Boolean, CSeq[String], String) = {
      case CallLocation(Id(labelId), lhsOpt, Id(op), Seq(IdExp(Id(methodName)), LiteralExp(_, ExtLit(n: Int)), TupleExp(argVarNames, _)), Id(nextLabelId), _) if isInvokeOp(op) =>
        (InvokeOp.from(op), labelId, for (lhs@IdExp(Id(varName)) <- lhsOpt) yield varName, methodName, if (n == 0) false else true, argVarNames.map(_.asInstanceOf[IdExp].id.value), nextLabelId)
    }

    final def apply(labelId: String, lhsOpt: Option[String], iop: InvokeOp.Type, methodName: String, itf: Boolean, argsVarNames: CSeq[String], nextLabelId: String): CallLocation = {
      CallLocation(Id(labelId), lhsOpt.map(idExp), Id(InvokeOp.to(iop)), ivector(idExp(methodName), intLit(if (itf) 1 else 0), TupleExp(argsVarNames.toVector.map(idExp))), Id(nextLabelId))
    }

    final def unapply(l: Location): Option[(InvokeOp.Type, String, Option[String], String, Boolean, CSeq[String], String)] =
      applyOpt(extractor, l)

    private[java] final def apply(lhsOpt: Option[String], iop: InvokeOp.Type, methodName: String, itf: Boolean, argVarNames: CSeq[String], nextLabelId: String): ExtJump =
      lhsOpt match {
        case Some(varName) =>
          ExtJump(Id(InvokeOp.to(iop)), ivector(idExp(varName), idExp(methodName), intLit(if (itf) 1 else 0), TupleExp(argVarNames.toVector.map(idExp)), idExp(nextLabelId)))
        case _ =>
          ExtJump(Id(InvokeOp.to(iop)), ivector(idExp(methodName), intLit(if (itf) 1 else 0), TupleExp(argVarNames.toVector.map(idExp)), idExp(nextLabelId)))
      }

    private[java] final def unapply(c: Command): Option[(Option[String], InvokeOp.Type, String, Boolean, CSeq[String], String)] =
      c match {
        case ExtJump(Id(op), Seq(IdExp(Id(varName)), IdExp(Id(methodName)), LiteralExp(_, ExtLit(n: Int)), TupleExp(argVarNames, _), IdExp(Id(nextLabelId))), _) if isInvokeOp(op) =>
          Some((Some(varName), InvokeOp.from(op), methodName, if (n == 0) false else true, argVarNames.map(_.asInstanceOf[IdExp].id.value), nextLabelId))
        case ExtJump(Id(op), Seq(IdExp(Id(methodName)), LiteralExp(_, ExtLit(n: Int)), TupleExp(argVarNames, _), IdExp(Id(nextLabelId))), _) if isInvokeOp(op) =>
          Some((None, InvokeOp.from(op), methodName, if (n == 0) false else true, argVarNames.map(_.asInstanceOf[IdExp].id.value), nextLabelId))
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
    final val extractor: Command --\ (String, ICmpOp.Type, String) = {
      case IfJump(BinaryExp(IdExp(Id(varName)), Id(op), LiteralExp(_, ExtLit(0))), Id(trueLabel), _, _) if isIIfOp(op) =>
        (varName, ICmpOp.from(op), trueLabel)
    }

    final def apply(varName: String, cop: ICmpOp.Type, trueLabel: String, falseLabel: String): IfJump =
      IfJump(BinaryExp(idExp(varName), Id(ICmpOp.to(cop)), intZeroLit), Id(trueLabel), Id(falseLabel))

    final def unapply(c: Command): Option[(String, ICmpOp.Type, String)] =
      applyOpt(extractor, c)
  }

  // JumpInsn
  //
  // if <varName1> <op> <varName2> then <trueLabel> else <falseLabel>;
  //
  // where <op> ::= ==_i | !=_i | >_i | >=_i | <_i | <=_i
  //       <falseLabel> should be next block's label
  object IfIntCmd extends CommandExtractor {
    final val extractor: Command --\ (String, ICmpOp.Type, String, String) = {
      case IfJump(BinaryExp(IdExp(Id(varName1)), Id(op), IdExp(Id(varName2))), Id(trueLabel), _, _) if isIIfOp(op) =>
        (varName1, ICmpOp.from(op), varName2, trueLabel)
    }

    final def apply(varName1: String, cop: ICmpOp.Type, varName2: String, trueLabel: String, falseLabel: String): IfJump =
      IfJump(BinaryExp(idExp(varName1), Id(ICmpOp.to(cop)), idExp(varName2)), Id(trueLabel), Id(falseLabel))

    final def unapply(c: Command): Option[(String, ICmpOp.Type, String, String)] =
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
      case IfJump(BinaryExp(IdExp(Id(varName1)), Id(op), IdExp(Id(varName2))), Id(trueLabel), _, _) if isOIfOp(op) =>
        (varName1, fromOIfOp(op), varName2, trueLabel)
    }

    final def apply(varName1: String, isEq: Boolean, varName2: String, trueLabel: String, falseLabel: String): IfJump =
      IfJump(BinaryExp(idExp(varName1), Id(toOIfOp(isEq)), idExp(varName2)), Id(trueLabel), Id(falseLabel))

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

  // Insn
  //
  // <varName> := <arrayVarName>(<indexVarName>) @ArrayLoad @Type«<tipe>»
  object ArrayLoadCmd extends CommandExtractor {
    final val extractor: Command --\ (String, String, String, meta.Type) = {
      case AssignAction(
      IdExp(Id(varName)),
      ExtExp(IdExp(Id(arrayVarName)), Seq(
      IdExp(Id(indexVarName)))),
      Seq(`annotationArrayLoad`,
      Annotation(_, ExtLit(tipe: meta.Type)), _*)) =>
        (varName, arrayVarName, indexVarName, tipe)
    }

    final def apply(varName: String, arrayVarName: String, indexVarName: String, tipe: meta.Type): AssignAction =
      AssignAction(
        idExp(varName),
        ExtExp(idExp(arrayVarName), ivector(
          idExp(indexVarName))),
        ivector(annotationArrayLoad, typeAnnotation(tipe)))

    final def unapply(c: Command): Option[(String, String, String, meta.Type)] =
      applyOpt(extractor, c)
  }

  // Insn
  //
  // <arrayVarName>(<indexVarName>) := <varName> @ArrayStore @Type«<tipe>»
  object ArrayStoreCmd extends CommandExtractor {
    final val extractor: Command --\ (String, String, String, meta.Type) = {
      case AssignAction(
      ExtExp(IdExp(Id(arrayVarName)), Seq(
      IdExp(Id(indexVarName)))),
      IdExp(Id(varName)),
      Seq(`annotationArrayStore`,
      Annotation(_, ExtLit(tipe: meta.Type)), _*)) =>
        (arrayVarName, indexVarName, varName, tipe)
    }

    final def apply(arrayVarName: String, indexVarName: String, varName: String, tipe: meta.Type): AssignAction =
      AssignAction(
        ExtExp(idExp(arrayVarName), ivector(
          idExp(indexVarName))),
        idExp(varName),
        ivector(annotationArrayLoad, typeAnnotation(tipe)))

    final def unapply(c: Command): Option[(String, String, String, meta.Type)] =
      applyOpt(extractor, c)
  }

  // Insn
  //
  // return [<varName>];
  object ReturnCmd extends CommandExtractor {
    final val extractor: Command --\ Option[String] = {
      case ReturnJump(Some(IdExp(Id(varName))), _) =>
        Some(varName)
      case ReturnJump(None, _) =>
        None
    }

    final def apply(varNameOpt: Option[String]): ReturnJump =
      varNameOpt match {
        case Some(varName) => ReturnJump(Some(idExp(varName)))
        case _ => ReturnJump(None)
      }

    final def unapply(c: Command): Option[String] =
      applyOpt(extractor, c).flatten
  }

  // Insn
  //
  // <varName> := null();
  object NullCmd extends CommandExtractor {
    final val extractor: Command --\ Tuple1[String] = {
      case AssignAction(
      IdExp(Id(varName)),
      ExtExp(IdExp(Id(`nullConstOp`)), _), _) =>
        Tuple1(varName)
    }

    final def apply(varName: String): AssignAction =
      AssignAction(
        idExp(varName),
        ExtExp(idExp(nullConstOp), ivectorEmpty))

    final def unapply(c: Command): Option[String] =
      applyOpt(extractor, c).map(_._1)
  }

  // Insn
  //
  // <varName> := <varName1> <op> <varName2>;
  //
  // where isBinOp(<op>) is true
  object BinaryCmd extends CommandExtractor {
    final val extractor: Command --\ (String, String, BinOp.Type, String) = {
      case AssignAction(
      IdExp(Id(varName)),
      BinaryExp(
      IdExp(Id(varName1)),
      Id(op),
      IdExp(Id(varName2))), _) if isBinOp(op) =>
        (varName, varName1, BinOp.from(op), varName2)
    }

    final def apply(varName: String, varName1: String, binop: BinOp.Type, varName2: String) =
      AssignAction(
        idExp(varName),
        BinaryExp(
          idExp(varName1),
          Id(BinOp.to(binop)),
          idExp(varName2)))

    final def unapply(c: Command): Option[(String, String, BinOp.Type, String)] =
      applyOpt(extractor, c)
  }

  // Insn
  //
  // <lVarName> := <op>(<rVarName>);
  //
  // where isUnOp(<op>) is true
  object UnaryCmd extends CommandExtractor {
    final val extractor: Command --\ (String, UnOp.Type, String) = {
      case AssignAction(
      IdExp(Id(lVarName)),
      ExtExp(
      IdExp(Id(op)),
      Seq(IdExp(Id(rVarName)))), _) if isUnOp(op) =>
        (lVarName, UnOp.from(op), rVarName)
    }

    final def apply(lVarName: String, unop: UnOp.Type, rVarName: String): AssignAction =
      AssignAction(
        idExp(lVarName),
        ExtExp(
          idExp(UnOp.to(unop)),
          ivector(idExp(rVarName))))

    final def unapply(c: Command): Option[(String, UnOp.Type, String)] =
      applyOpt(extractor, c)
  }

  // Insn
  //
  // jext throw(<varName>);
  object ThrowCmd extends CommandExtractor {
    final val extractor: Command --\ Tuple1[String] = {
      case ExtJump(Id(`throwOp`), Seq(IdExp(Id(varName))), _) =>
        Tuple1(varName)
    }

    final def apply(varName: String): ExtJump =
      ExtJump(Id(throwOp), ivector(idExp(varName)))

    final def unapply(c: Command): Option[String] =
      applyOpt(extractor, c).map(_._1)
  }

  // Insn
  //
  // ext <op>(<varName>);
  //
  // where <op> ::= monitorEnter, if isEnter is true
  //              | monitorExit, otherwise
  object MonitorCmd extends CommandExtractor {
    final val extractor: Command --\ (Boolean, String) = {
      case ExtAction(Id(op), Seq(IdExp(Id(varName))), _) if isMonitorOp(op) =>
        (fromMonitorOp(op), varName)
    }

    final def apply(isEnter: Boolean, varName: String) =
      ExtAction(Id(toMonitorOp(isEnter)), ivector(idExp(varName)))

    final def unapply(c: Command): Option[(Boolean, String)] =
      applyOpt(extractor, c)
  }

  // InvokeDynamicInsn
  //
  // call [<lhsOpt> :=] invokeDynamic(<objectVarName>, <methodName>, t«<methodTipe>», h«<bsm>», (<bsmArg-1>, ..., <bsmArg-N), (<arg-1>, ..., <arg-M>)) goto <nextLabelId>;
  object InvokeDynamicLoc extends LocationExtractor {
    final val extractor: Location --\ (String, Option[String], String, meta.Type, meta.Handle, CSeq[BsmArg], CSeq[String], String) = {
      case CallLocation(Id(labelId), lhsOpt, Id(`invokeDynamicOp`),
      Seq(IdExp(Id(methodName)), LiteralExp(_, ExtLit(methodType: meta.Type)),
      LiteralExp(_, ExtLit(bsm: meta.Handle)),
      TupleExp(bArgs, _), TupleExp(args, _)),
      Id(nextLabelId), _) =>
        (labelId, for (lhs@IdExp(Id(varName)) <- lhsOpt) yield varName, methodName, methodType, bsm, bArgs.map(BsmArg.from), args.map(_.asInstanceOf[IdExp].id.value), nextLabelId)
    }

    final def apply(labelId: String, lhsOpt: Option[String], methodName: String, methodType: meta.Type, bsm: meta.Handle, bArgs: CSeq[BsmArg], args: CSeq[String], nextLabelId: String): CallLocation =
      CallLocation(Id(labelId), lhsOpt.map(idExp), Id(`invokeDynamicOp`),
        ivector(idExp(methodName), typeLit(methodType), LiteralExp(Id(handleDesc), ExtLit(bsm)),
          TupleExp(bArgs.toVector.map(_.to)), TupleExp(args.toVector.map(idExp))),
        Id(nextLabelId))

    final def unapply(l: Location): Option[(String, Option[String], String, meta.Type, meta.Handle, CSeq[BsmArg], CSeq[String], String)] =
      applyOpt(extractor, l)

    private[java] final def apply(lhsOpt: Option[String], methodName: String, methodType: meta.Type, bsm: meta.Handle, bsmArgs: CSeq[BsmArg], args: CSeq[String], nextLabelId: String) =
      lhsOpt match {
        case Some(varName) =>
          ExtJump(Id(invokeDynamicOp), ivector(
            idExp(varName), idExp(methodName), typeLit(methodType),
            LiteralExp(Id(handleDesc), ExtLit(bsm)),
            TupleExp(bsmArgs.toVector.map(_.to)), TupleExp(args.toVector.map(idExp)),
            idExp(nextLabelId)))
        case _ =>
          ExtJump(Id(invokeDynamicOp), ivector(
            idExp(methodName), typeLit(methodType),
            LiteralExp(Id(handleDesc), ExtLit(bsm)),
            TupleExp(bsmArgs.toVector.map(_.to)), TupleExp(args.toVector.map(idExp)),
            idExp(nextLabelId)))
      }

    private[java] final def unapply(c: Command): Option[(Option[String], String, meta.Type, meta.Handle, CSeq[BsmArg], CSeq[String], String)] =
      c match {
        case ExtJump(Id(`invokeDynamicOp`), Seq(
        IdExp(Id(varName)), IdExp(Id(methodName)), LiteralExp(_, ExtLit(methodType: meta.Type)),
        LiteralExp(_, ExtLit(bsm: meta.Handle)),
        TupleExp(bsmArgs, _), TupleExp(args, _),
        IdExp(Id(nextLabelId))), _) =>
          Some((Some(varName), methodName, methodType, bsm, bsmArgs.map(BsmArg.from), args.map(_.asInstanceOf[IdExp].id.value), nextLabelId))
        case ExtJump(Id(`invokeDynamicOp`), Seq(
        IdExp(Id(methodName)), LiteralExp(_, ExtLit(methodType: meta.Type)),
        LiteralExp(_, ExtLit(bsm: meta.Handle)),
        TupleExp(bsmArgs, _), TupleExp(args, _),
        IdExp(Id(nextLabelId))), _) =>
          Some((None, methodName, methodType, bsm, bsmArgs.map(BsmArg.from), args.map(_.asInstanceOf[IdExp].id.value), nextLabelId))
        case _ => None
      }

    sealed trait BsmArg {
      def to: Exp
    }

    object BsmArg {
      def from(e: Exp): BsmArg =
        (e: @unchecked) match {
          case LiteralExp(_, ExtLit(value: Int)) => IntBsmArg(value)
          case LiteralExp(_, ExtLit(value: Float)) => FloatBsmArg(value)
          case LiteralExp(_, ExtLit(value: Double)) => DoubleBsmArg(value)
          case LiteralExp(_, ExtLit(value: Long)) => LongBsmArg(value)
          case LiteralExp(_, ExtLit(value: String)) => StringBsmArg(value)
          case LiteralExp(_, ExtLit(value: meta.Type)) => TypeBsmArg(value)
          case LiteralExp(_, ExtLit(value: meta.Handle)) => HandleBsmArg(value)
        }
    }

    final case class IntBsmArg(value: Int) extends BsmArg {
      def to: Exp = intLit(value)
    }

    final case class FloatBsmArg(value: Float) extends BsmArg {
      def to: Exp = LiteralExp(Id(floatDesc), ExtLit(value))
    }

    final case class DoubleBsmArg(value: Double) extends BsmArg {
      def to: Exp = LiteralExp(Id(doubleDesc), ExtLit(value))
    }

    final case class LongBsmArg(value: Long) extends BsmArg {
      def to: Exp = LiteralExp(Id(longDesc), ExtLit(value))
    }

    final case class StringBsmArg(value: String) extends BsmArg {
      def to: Exp = stringLit(value)
    }

    final case class TypeBsmArg(value: meta.Type) extends BsmArg {
      def to: Exp = LiteralExp(Id(typeDesc), ExtLit(value))
    }

    final case class HandleBsmArg(value: meta.Handle) extends BsmArg {
      def to: Exp = LiteralExp(Id(handleDesc), ExtLit(value))
    }

  }

}
