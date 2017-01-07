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

package org.sireum.logika.transpiler

import org.stringtemplate.v4._
import org.sireum.logika._
import org.sireum.util._

object C {

  final case class Result(stMainHeader: ST,
                          stMain: ST)

  private val stg: STGroup = new STGroupFile(getClass.getResource("c.stg"), "UTF-8", '$', '$')

  private val keywords = Set(
    "auto", "break", "case", "char", "const", "continue",
    "default", "do", "double", "else", "enum", "extern", "float", "for",
    "goto", "if", "int", "long", "register", "return", "short", "signed",
    "sizeof", "static", "struct", "switch", "typedef", "union", "unsigned",
    "void", "volatile", "while")

  private val uiMax: BigInt = BigInt(2).pow(32) - 1

  private val zOpMap = Map(
    "+" -> "L_add_Z",
    "-" -> "L_sub_Z",
    "*" -> "L_mul_Z",
    "/" -> "L_div_Z",
    "%" -> "L_rem_Z",
    "==" -> "L_eq_Z",
    "!=" -> "L_ne_Z",
    "<" -> "L_lt_Z",
    "<=" -> "L_le_Z",
    ">" -> "L_gt_Z",
    ">=" -> "L_ge_Z")

  private val nOpMap = Map(
    "+" -> "L_add_N",
    "-" -> "L_sub_N",
    "*" -> "L_mul_N",
    "/" -> "L_div_N",
    "%" -> "L_rem_N",
    "==" -> "L_eq_N",
    "!=" -> "L_ne_N",
    "<" -> "L_lt_N",
    "<=" -> "L_le_N",
    ">" -> "L_gt_N",
    ">=" -> "L_ge_N")

  private val opMap = Map(
    "&" -> "&&",
    "|" -> "||",
    "|^" -> "^",
    ":+" -> "append",
    "+:" -> "prepend",
    "++" -> "appends")

  private val noResult: ST = stg.getInstanceOf("lit").add("e", "???")

  def apply(programs: ISeq[ast.Program], bitWidth: Natural)(
    implicit reporter: TagReporter): Result = {
    val result = Result(stg.getInstanceOf("mainH"), stg.getInstanceOf("main"))
    for (p <- programs) new C(p, bitWidth, result)
    result
  }
}

import C._

private class C(program: ast.Program,
                bitWidth: Natural,
                result: Result)(
                 implicit reporter: TagReporter) {
  val Result(stMainHeader, stMain) = result
  val stProtos: ST = stg.getInstanceOf("protos")
  val stGlobals: ST = stg.getInstanceOf("globals")
  val stRunStmts: ST = stg.getInstanceOf("stmts")
  val stMethods: ST = stg.getInstanceOf("methods")

  {
    stMainHeader.add("protos", stProtos)
    stMain.add("globals", stGlobals)
    stMain.add("protos", stProtos)
    stMain.add("stmts", stRunStmts)
    stMain.add("methods", stMethods)

    for (fileUri <- program.fileUriOpt) {
      val st = stg.getInstanceOf("lcomment").
        add("text", s"Generated from $fileUri")
      stProtos.add("comment", st)
      stGlobals.add("comment", st)
      stRunStmts.add("comment", st)
      stMethods.add("comment", st)
    }

    translate(program.block, isGlobal = true,
      stRunStmts, ivectorEmpty, None, shouldReturn = true)
  }

  def translate(block: ast.Block,
                isGlobal: Boolean,
                stStmts: ST,
                declaredVars: ISeq[(String, String)],
                retTypeNameOpt: Option[String],
                shouldReturn: Boolean): Unit = {
    var varDecls = ivectorEmpty[(String, String)]
    for (stmt <- block.stmts)
      for (tx <- translate(stmt, isGlobal, stStmts, varDecls, retTypeNameOpt))
        varDecls :+= tx
    if (shouldReturn || block.returnOpt.isDefined)
      translate(block.returnOpt, stStmts,
        varWipe(varDecls ++ declaredVars), retTypeNameOpt)
    else varWipe(varDecls)(None, stStmts)
  }

  def varWipe(declaredVars: ISeq[(String, String)])
             (idOpt: Option[ast.Id], stStmts: ST): Unit = {
    val tAlias = idOpt.exists(_.tipe match {
      case _: MSeq[_] => true
      case tipe.Z | tipe.N => bitWidth == 0
      case _ => false
    })
    val idName = idOpt.map(_.value).getOrElse("")
    for ((t, x) <- declaredVars) {
      if (!tAlias || idName != x)
        stStmts.add("stmt",
          stg.getInstanceOf("callExp").
            add("id", s"L_wipe_$t").
            add("e", s"&${name(x)}").add("end", ";"))
    }
  }

  def translate(rOpt: Option[ast.Return],
                stStmts: ST,
                varWipeFun: (Option[ast.Id], ST) => Unit,
                retTypeNameOpt: Option[String]): Unit = {
    val idOpt =
      retTypeNameOpt match {
        case Some(t) =>
          val retExp = rOpt.get.expOpt.get
          stStmts.add("stmt",
            stg.getInstanceOf("assignStmt").
              add("no", program.nodeLocMap(retExp).lineBegin).
              add("t", t).
              add("x", "result").
              add("e", translate(retExp)))
          retExp match {
            case retExp: ast.Id => Some(retExp)
            case _ => None
          }
        case _ => None
      }
    varWipeFun(idOpt, stStmts)
    rOpt match {
      case Some(r) =>
        val retST = stg.getInstanceOf("returnStmt").
          add("no", program.nodeLocMap(r).lineBegin)
        r.expOpt.foreach(_ => retST.add("e", "result"))
        stStmts.add("stmt", retST)
      case _ =>
    }
  }

  def translate(stmt: ast.Stmt,
                isGlobal: Boolean,
                stStmts: ST,
                declaredVars: ISeq[(String, String)],
                retTypeNameOpt: Option[String]): Option[(String, String)] = stmt match {
    case stmt: ast.VarDecl =>
      val line = program.nodeLocMap(stmt).lineBegin
      val t = typeName(stmt.tpe)
      val x = name(stmt.id)
      if (isGlobal) {
        stGlobals.add("global",
          stg.getInstanceOf("global").
            add("t", t).
            add("x", x).
            add("no", line))
        stStmts.add("stmt",
          stg.getInstanceOf("assignStmt").
            add("no", line).
            add("x", x).
            add("e", translate(stmt.exp)))
      } else {
        stStmts.add("stmt",
          stg.getInstanceOf("assignStmt").
            add("no", line).
            add("t", t).
            add("x", x).
            add("e", translate(stmt.exp)))
      }
      Some((t, x))
    case stmt: ast.Assign =>
      stStmts.add("stmt",
        stg.getInstanceOf("assignStmt").
          add("no", program.nodeLocMap(stmt).lineBegin).
          add("x", name(stmt.id)).
          add("e", translate(stmt.exp)))
      None
    case stmt: ast.Assume =>
      stMain.add("assumption", true)
      stStmts.add("stmt",
        stg.getInstanceOf("assumeStmt").
          add("no", program.nodeLocMap(stmt).lineBegin).
          add("e", translate(stmt.exp)))
      None
    case stmt: ast.Assert =>
      stMain.add("assertion", true)
      stStmts.add("stmt",
        stg.getInstanceOf("assertStmt").
          add("no", program.nodeLocMap(stmt).lineBegin).
          add("e", translate(stmt.exp)))
      None
    case stmt: ast.ExpStmt =>
      stStmts.add("stmt",
        translate(stmt.exp).add("end", ";").
          add("no", program.nodeLocMap(stmt).lineBegin))
      None
    case stmt: ast.If =>
      val ifST = stg.getInstanceOf("ifStmt").
        add("no", program.nodeLocMap(stmt).lineBegin).
        add("e", translate(stmt.exp))
      stStmts.add("stmt", ifST)
      val stTStmts = stg.getInstanceOf("stmts")
      ifST.add("tStmts", stTStmts)
      translate(stmt.trueBlock, isGlobal, stTStmts,
        declaredVars, retTypeNameOpt, shouldReturn = false)
      if (stmt.falseBlock.stmts.nonEmpty ||
        stmt.falseBlock.returnOpt.nonEmpty) {
        val stFStmts = stg.getInstanceOf("stmts")
        ifST.add("fStmts", stFStmts)
        translate(stmt.falseBlock, isGlobal, stFStmts,
          declaredVars, retTypeNameOpt, shouldReturn = false)
      }
      None
    case stmt: ast.While =>
      val whileST = stg.getInstanceOf("whileStmt").
        add("no", program.nodeLocMap(stmt).lineBegin).
        add("e", translate(stmt.exp))
      stStmts.add("stmt", whileST)
      val stWStmts = stg.getInstanceOf("stmts")
      whileST.add("tStmts", stWStmts)
      translate(stmt.block, isGlobal, stWStmts,
        declaredVars, retTypeNameOpt, shouldReturn = false)
      None
    case stmt: ast.Print =>
      result.stMain.add("io", true)
      if (stmt.isNewline && stmt.args.isEmpty) {
        stStmts.add("stmt",
          stg.getInstanceOf("callExp").
            add("no", program.nodeLocMap(stmt).lineBegin).
            add("id", "L_println").add("end", ";"))
      } else {
        val printST = stg.getInstanceOf("printStmt").
          add("no", program.nodeLocMap(stmt).lineBegin).
          add("end", ";")
        stStmts.add("stmt", printST)
        for ((tOpt, arg) <- stmt.argTipes.zip(stmt.args)) {
          printST.add("stmt",
            arg match {
              case ast.StringLit(value) =>
                stg.getInstanceOf("callExp").
                  add("id", "L_print").
                  add("e", '"' + escape(value) + '"').
                  add("end", ";")
              case arg: ast.Exp =>
                stg.getInstanceOf("callExp").
                  add("id", s"L_print_${typeName(arg, tOpt.get)}").
                  add("e", translate(arg)).add("end", ";")
            })
        }
        if (stmt.isNewline) {
          stStmts.add("stmt",
            stg.getInstanceOf("callExp").
              add("no", program.nodeLocMap(stmt).lineBegin).
              add("id", "L_println").add("end", ";"))
        }
      }
      None
    case stmt: ast.SeqAssign =>
      stmt.id.tipe match {
        case tipe.BS =>
          stStmts.add("stmt",
            stg.getInstanceOf("callExp").
              add("no", program.nodeLocMap(stmt).lineBegin).
              add("id", "L_set_BS").
              add("e", translate(stmt.id)).
              add("e", translate(stmt.index)).
              add("e", translate(stmt.exp)).
              add("end", ";"))
        case _ =>
          stStmts.add("stmt",
            stg.getInstanceOf("seqAssignStmt").
              add("no", program.nodeLocMap(stmt).lineBegin).
              add("x", translate(stmt.id)).
              add("i", translate(stmt.index)).
              add("e", translate(stmt.exp)))
      }
      None
    case stmt: ast.MethodDecl =>
      val mretTypeNameOpt = stmt.returnTypeOpt.map(typeName)
      val protoST = stg.getInstanceOf("proto").
        add("no", program.nodeLocMap(stmt).lineBegin).
        add("t", mretTypeNameOpt.getOrElse("void")).
        add("name", name(stmt.id))
      val methodST = stg.getInstanceOf("method")
      stProtos.add("proto", protoST)
      methodST.add("proto", protoST)
      stMethods.add("method", methodST)
      val modIds = stmt.contract.modifies.ids.toSet
      for (p <- stmt.params)
        protoST.add("param",
          stg.getInstanceOf("param").
            add("mod", modIds.contains(p.id)).
            add("t", typeName(p.tpe)).
            add("x", name(p.id)))
      val stMStmts = stg.getInstanceOf("stmts")
      methodST.add("stmts", stMStmts)
      translate(stmt.block, isGlobal = false, stMStmts,
        ivectorEmpty, mretTypeNameOpt, shouldReturn = true)
      None
    case _: ast.ProofElementStmt | _: ast.ProofStmt |
         _: ast.SequentStmt | _: ast.InvStmt => None
  }

  def translate(e: ast.Exp): ST = e match {
    case ast.BooleanLit(value) =>
      stg.getInstanceOf("lit").add("e", if (value) "T" else "F")
    case e: ast.Id =>
      stg.getInstanceOf("lit").add("e", name(e))
    case e: ast.Size =>
      stg.getInstanceOf("sizeExp").add("e", translate(e.exp))
    case e: ast.Clone =>
      e.id.tipe match {
        case tipe.RS =>
          error(e.id, "C translation of RS is not currently supported.")
          noResult
        case t: MSeq[_] =>
          stg.getInstanceOf("cloneExp").
            add("t", typeName(e.id, t)).
            add("e", translate(e.id))
        case t =>
          internalError(s"Unexpected cloning on type ${typeName(e.id, t)}")
          noResult
      }
    case _: ast.Result =>
      internalError("Unexpected contract C translation: result.")
      noResult
    case e: ast.Apply =>
      e.expTipe match {
        case tipe.BS =>
          val result = stg.getInstanceOf("callExp")
          for (arg <- e.args) {
            result.add("e", translate(arg))
          }
          result.add("id", "L_get_BS")
        case _: MSeq[_] =>
          stg.getInstanceOf("indexExp").
            add("e", translate(e.exp)).
            add("i", translate(e.args.head))
        case _ =>
          val result = stg.getInstanceOf("callExp")
          for (arg <- e.args) {
            result.add("e", translate(arg))
          }
          result.add("id", translate(e.exp))
      }
    case _: ast.RandomInt =>
      result.stMain.add("io", true)
      stg.getInstanceOf("callExp").add("id", "L_random_Z")
    case _: ast.ReadInt =>
      result.stMain.add("io", true)
      stg.getInstanceOf("callExp").add("id", "L_read_Z")
    case e: ast.IntLit =>
      val n = e.normalize
      e.bitWidth match {
        case 0 =>
          e.tpeOpt match {
            case Some(_: ast.NType) =>
              if (0 <= n && n <= uiMax)
                stg.getInstanceOf("lit").add("e", s"L_Nui(${n}UL)")
              else
                stg.getInstanceOf("lit").add("e", "L_Nstr(\"" + n + "\")")
            case _ =>
              if (n.isValidInt)
                stg.getInstanceOf("lit").add("e", s"L_Zsi(${n}L)")
              else if (0 <= n && n <= uiMax)
                stg.getInstanceOf("lit").add("e", s"L_Zui(${n}UL)")
              else
                stg.getInstanceOf("lit").add("e", "L_Zstr(\"" + n + "\")")
          }
        case 32 =>
          e.tpeOpt match {
            case Some(_: ast.Z32Type) =>
              stg.getInstanceOf("litCastExp").add("t", "Z32").add("e", s"${n}L")
            case Some(_: ast.N32Type) =>
              stg.getInstanceOf("litCastExp").add("t", "N32").add("e", s"${n}UL")
            case Some(_: ast.S32Type) =>
              stg.getInstanceOf("litCastExp").add("t", "S32").add("e", s"${n}L")
            case Some(_: ast.U32Type) =>
              stg.getInstanceOf("litCastExp").add("t", "U32").add("e", s"${n}UL")
            case _ =>
              stg.getInstanceOf("litCastExp").add("t", "Z").add("e", s"${n}L")
          }
        case 64 =>
          val t = e.tpeOpt match {
            case Some(_: ast.Z64Type) => "Z64"
            case Some(_: ast.N64Type) => "N64"
            case Some(_: ast.S64Type) => "S64"
            case Some(_: ast.U64Type) => "U64"
            case _ => "Z"
          }
          val l = n.toLong
          val e1 = (l >>> 32) & 0xFFFFFFFF
          val e2 = l & 0xFFFFFFFF
          stg.getInstanceOf("lit64Exp").add("t", t).
            add("e1", e1).add("e2", e2).add("text", n)
        case _ =>
          val t = e.tpeOpt match {
            case Some(_: ast.Z8Type) => "Z8"
            case Some(_: ast.N8Type) => "N8"
            case Some(_: ast.S8Type) => "S8"
            case Some(_: ast.U8Type) => "U8"
            case Some(_: ast.Z16Type) => "Z16"
            case Some(_: ast.N16Type) => "N16"
            case Some(_: ast.S16Type) => "S16"
            case Some(_: ast.U16Type) => "U16"
            case _ => "Z"
          }
          stg.getInstanceOf("litCastExp").add("t", t).add("e", n)
      }
    case e: ast.FloatLit =>
      e.primitiveValue match {
        case Left(v) =>
          val s = java.lang.Float.floatToRawIntBits(v).toHexString
          stg.getInstanceOf("litCastExp").add("t", "F32").
            add("e", s"0x${s}UL").add("text", e.value)
        case Right(v) =>
          val s = java.lang.Double.doubleToRawLongBits(v).toHexString
          stg.getInstanceOf("litCastExp").add("t", "F32").
            add("e", s"0x${s}ULL").add("text", e.value)
      }
    case _: ast.RealLit =>
      error(e, "C translation of R is not currently supported.")
      noResult
    case e: ast.IntMin =>
      val lit = e.integralType match {
        case _: ast.ZType =>
          e.bitWidth match {
            case 8 => "Z8_Min"
            case 16 => "Z16_Min"
            case 32 => "Z32_Min"
            case 64 => "Z64_Min"
          }
        case _: ast.Z8Type => "Z8_Min"
        case _: ast.Z16Type => "Z16_Min"
        case _: ast.Z32Type => "Z32_Min"
        case _: ast.Z64Type => "Z64_Min"
        case _: ast.S8Type => "S8_Min"
        case _: ast.S16Type => "S16_Min"
        case _: ast.S32Type => "S32_Min"
        case _: ast.S64Type => "S64_Min"
        case _: ast.NType =>
          e.bitWidth match {
            case 8 => "N8_Min"
            case 16 => "N16_Min"
            case 32 => "N32_Min"
            case 64 => "N64_Min"
          }
        case _: ast.N8Type => "N8_Min"
        case _: ast.N16Type => "N16_Min"
        case _: ast.N32Type => "N32_Min"
        case _: ast.N64Type => "N64_Min"
        case _: ast.U8Type => "U8_Min"
        case _: ast.U16Type => "U16_Min"
        case _: ast.U32Type => "U32_Min"
        case _: ast.U64Type => "U64_Min"
      }
      stg.getInstanceOf("lit").add("e", lit)
    case e: ast.IntMax =>
      val lit = e.integralType match {
        case _: ast.ZType =>
          e.bitWidth match {
            case 8 => "Z8_Max"
            case 16 => "Z16_Max"
            case 32 => "Z32_Max"
            case 64 => "Z64_Max"
          }
        case _: ast.Z8Type => "Z8_Max"
        case _: ast.Z16Type => "Z16_Max"
        case _: ast.Z32Type => "Z32_Max"
        case _: ast.Z64Type => "Z64_Max"
        case _: ast.S8Type => "S8_Max"
        case _: ast.S16Type => "S16_Max"
        case _: ast.S32Type => "S32_Max"
        case _: ast.S64Type => "S64_Max"
        case _: ast.NType =>
          e.bitWidth match {
            case 8 => "N8_Max"
            case 16 => "N16_Max"
            case 32 => "N32_Max"
            case 64 => "N64_Max"
          }
        case _: ast.N8Type => "N8_Max"
        case _: ast.N16Type => "N16_Max"
        case _: ast.N32Type => "N32_Max"
        case _: ast.N64Type => "N64_Max"
        case _: ast.U8Type => "U8_Max"
        case _: ast.U16Type => "U16_Max"
        case _: ast.U32Type => "U32_Max"
        case _: ast.U64Type => "U64_Max"
      }
      stg.getInstanceOf("lit").add("e", lit)
    case e: ast.Random =>
      result.stMain.add("io", true)
      stg.getInstanceOf("callExp").
        add("id", s"L_random_${typeName(e.tpe)}")
    case e: ast.TypeMethodCallExp =>
      e.id.value match {
        case "create" =>
          stg.getInstanceOf("createExp").add("t", typeName(e.tpe)).
            add("size", translate(e.args.head)).
            add("initValue", translate(e.args(1)))
      }
    case e: ast.BinaryExp =>
      val op = e.op(false)
      e.tipe match {
        case tipe.Z if bitWidth == 0 =>
          val zOp = zOpMap(op) +
            (if (shouldFree(e.left)) "l" else "") +
            (if (shouldFree(e.right)) "r" else "")
          stg.getInstanceOf("callExp").add("id", zOp).
            add("e", translate(e.left)).
            add("e", translate(e.right))
        case tipe.N if bitWidth == 0 =>
          val nOp = nOpMap(op) +
            (if (shouldFree(e.left)) "l" else "") +
            (if (shouldFree(e.right)) "r" else "")
          stg.getInstanceOf("callExp").add("id", nOp).
            add("e", translate(e.left)).
            add("e", translate(e.right))
        case _ =>
          op match {
            case ":+" =>
              stg.getInstanceOf("callExp").
                add("id", s"L_${opMap(op)}_${typeName(e, e.tipe)}" +
                  (if (shouldFree(e.left)) "f" else "")).
                add("e", translate(e.left)).
                add("e", translate(e.right))
            case "+:" =>
              stg.getInstanceOf("callExp").
                add("id", s"L_${opMap(op)}_${typeName(e, e.tipe)}" +
                  (if (shouldFree(e.right)) "f" else "")).
                add("e", translate(e.left)).
                add("e", translate(e.right))
            case "++" =>
              stg.getInstanceOf("callExp").
                add("id", s"L_${opMap(op)}_${typeName(e, e.tipe)}" +
                  (if (shouldFree(e.left)) "l" else "") +
                  (if (shouldFree(e.right)) "r" else "")).
                add("e", translate(e.left)).
                add("e", translate(e.right))
            case _ =>
              stg.getInstanceOf("binExp").
                add("e1", translate(e.left)).
                add("op", opMap.getOrElse(op, op)).
                add("e2", translate(e.right))
          }
      }
    case e: ast.Not =>
      stg.getInstanceOf("unExp").add("op", "!").
        add("e", translate(e.exp))
    case e: ast.Minus =>
      e.tipe match {
        case tipe.Z if bitWidth == 0 =>
          stg.getInstanceOf("callExp").
            add("id", "L_neg_Z" + (if (shouldFree(e)) "f" else "")).
            add("e", translate(e))
        case _ =>
          stg.getInstanceOf("unExp").add("op", "-").
            add("e", translate(e))
      }
    case _: ast.Quant[_] =>
      internalError("Unexpected contract C translation: result.")
      noResult
    case e: ast.SeqLit =>
      val result = stg.getInstanceOf("callExp")
      for (arg <- e.args) {
        result.add("e", translate(arg))
      }
      result.add("id", s"L_${typeName(e.tpe)}")
  }

  def shouldFree(e: ast.Exp): Boolean = !e.isInstanceOf[ast.Id]

  def typeName(t: ast.Type): String = t match {
    case _: ast.BType => "B"
    case _: ast.ZType => "Z"
    case _: ast.Z8Type => "Z8"
    case _: ast.Z16Type => "Z16"
    case _: ast.Z32Type => "Z32"
    case _: ast.Z64Type => "Z64"
    case _: ast.NType => "N"
    case _: ast.N8Type => "N8"
    case _: ast.N16Type => "N16"
    case _: ast.N32Type => "N32"
    case _: ast.N64Type => "N64"
    case _: ast.S8Type => "S8"
    case _: ast.S16Type => "S16"
    case _: ast.S32Type => "S32"
    case _: ast.S64Type => "S64"
    case _: ast.U8Type => "U8"
    case _: ast.U16Type => "U16"
    case _: ast.U32Type => "U32"
    case _: ast.U64Type => "U64"
    case _: ast.RType =>
      error(t, "C translation of R is not currently supported.")
      "R"
    case _: ast.F32Type => "F32"
    case _: ast.F64Type => "F64"
    case _: ast.BSType => "BS"
    case _: ast.ZSType => "ZS"
    case _: ast.Z8SType => "Z8S"
    case _: ast.Z16SType => "Z16S"
    case _: ast.Z32SType => "Z32S"
    case _: ast.Z64SType => "Z64S"
    case _: ast.NSType => "NS"
    case _: ast.N8SType => "N8S"
    case _: ast.N16SType => "N16S"
    case _: ast.N32SType => "N32S"
    case _: ast.N64SType => "N64S"
    case _: ast.S8SType => "S8S"
    case _: ast.S16SType => "S16S"
    case _: ast.S32SType => "S32S"
    case _: ast.S64SType => "S64S"
    case _: ast.U8SType => "U8S"
    case _: ast.U16SType => "U16S"
    case _: ast.U32SType => "U32S"
    case _: ast.U64SType => "U64S"
    case _: ast.RSType =>
      error(t, "C translation of RS is not currently supported.")
      "RS"
    case _: ast.F32SType => "F32S"
    case _: ast.F64SType => "F64S"
  }

  def typeName(n: ast.Node, t: tipe.Tipe): String = t match {
    case tipe.B => "B"
    case tipe.Z => "Z"
    case tipe.Z8 => "Z8"
    case tipe.Z16 => "Z16"
    case tipe.Z32 => "Z32"
    case tipe.Z64 => "Z64"
    case tipe.N => "N"
    case tipe.N8 => "N8"
    case tipe.N16 => "N16"
    case tipe.N32 => "N32"
    case tipe.N64 => "N64"
    case tipe.S8 => "S8"
    case tipe.S16 => "S16"
    case tipe.S32 => "S32"
    case tipe.S64 => "S64"
    case tipe.U8 => "U8"
    case tipe.U16 => "U16"
    case tipe.U32 => "U32"
    case tipe.U64 => "U64"
    case tipe.R =>
      error(n, "C translation of R is not currently supported.")
      "R"
    case tipe.F32 => "F32"
    case tipe.F64 => "F64"
    case tipe.BS => "BS"
    case tipe.ZS => "ZS"
    case tipe.Z8S => "Z8S"
    case tipe.Z16S => "Z16S"
    case tipe.Z32S => "Z32S"
    case tipe.Z64S => "Z64S"
    case tipe.NS => "NS"
    case tipe.N8S => "N8S"
    case tipe.N16S => "N16S"
    case tipe.N32S => "N32S"
    case tipe.N64S => "N64S"
    case tipe.S8S => "S8S"
    case tipe.S16S => "S16S"
    case tipe.S32S => "S32S"
    case tipe.S64S => "S64S"
    case tipe.U8S => "U8S"
    case tipe.U16S => "U16S"
    case tipe.U32S => "U32S"
    case tipe.U64S => "U64S"
    case tipe.RS =>
      error(n, "C translation of RS is not currently supported.")
      "R"
    case tipe.F32S => "F32S"
    case tipe.F64S => "F64S"
    case tipe.UnitTipe =>
      internalError(s"Unexpected unit type.")
      "Z"
    case _: tipe.FunTipe =>
      internalError(s"Unexpected function type, $t.")
      "Z"
  }

  def name(id: ast.Id): String = name(id.value)

  def name(id: String): String =
    if (keywords.contains(id)) "_" + id else id

  def escape(raw: String): String = {
    import scala.reflect.runtime.universe._
    Literal(Constant(raw)).toString
  }

  def error(n: ast.Node, msg: String): Unit = {
    reporter.report(program.nodeLocMap(n).toLocationError(program.fileUriOpt, "C90", msg))
  }

  def internalError(msg: String): Unit = {
    reporter.report(InternalErrorMessage("C90", msg))
  }
}
