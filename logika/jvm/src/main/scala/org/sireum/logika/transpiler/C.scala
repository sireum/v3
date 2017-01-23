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
                          stMain: ST,
                          stCMake: ST,
                          files: MMap[String, String])

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


  private val maskLimit: Natural = 32

  private val maskId: String = "$"

  def read(filename: String, result: Result): Unit =
    if (!result.files.contains(filename)) {
      val r = new java.io.BufferedReader(
        new java.io.InputStreamReader(
          getClass.getResourceAsStream("/" + filename)))
      val lines = r.lines().toArray
      r.close()
      val sb = new StringBuilder
      for (line <- lines) {
        sb.append(line)
        sb.append(scala.util.Properties.lineSeparator)
      }
      result.files(filename) = sb.toString
    }

  def apply(programs: ISeq[ast.Program], bitWidth: Natural)(
    implicit reporter: TagReporter): Result = {
    val result = Result(stg.getInstanceOf("mainH"),
      stg.getInstanceOf("main"), stg.getInstanceOf("cmake"), mmapEmpty[String, String])
    read("logika.c", result)
    read("logika.h", result)
    if (bitWidth == 0) {
      result.stCMake.add("gmp", true)
      read("FindGMP.cmake", result)
    }
    for (p <- programs) new C(p, bitWidth, result)
    result.stCMake.add("bitWidth", bitWidth)
    for (f <- result.files.keys if f.endsWith(".c")) result.stCMake.add("file", f)
    result
  }

  def isInternalRefType(id: ast.Id, bitWidth: Natural): Boolean = isInternalRefType(id.tipe, bitWidth)

  def isInternalRefType(t: tipe.Tipe, bitWidth: Natural): Boolean = t match {
    case _: tipe.MSeq => true
    case tipe.Z | tipe.N => bitWidth == 0
    case _ => false
  }

  def isRefType(id: ast.Id): Boolean = isRefType(id.tipe)

  def isRefType(t: tipe.Tipe): Boolean = t match {
    case _: tipe.MSeq => true
    case _ => false
  }
}

import C._

private class C(program: ast.Program,
                bitWidth: Natural,
                result: Result)(
                 implicit reporter: TagReporter) {
  val Result(stMainHeader, stMain, stCMake, _) = result
  val stProtos: ST = stg.getInstanceOf("protos")
  val stGlobals: ST = stg.getInstanceOf("globals")
  val stHeaderGlobals: ST = stg.getInstanceOf("globals")
  val stRunStmts: ST = stg.getInstanceOf("stmts")
  val stMethods: ST = stg.getInstanceOf("methods")
  var hasIO = false
  var hasRandom = false
  var hasTopLevel = false

  {
    stMainHeader.add("protos", stProtos)
    stMainHeader.add("globals", stHeaderGlobals)
    stMain.add("protos", stProtos)
    stMain.add("globals", stGlobals)
    stMain.add("stmts", stRunStmts)
    stMain.add("methods", stMethods)

    for (fileUri <- program.fileUriOpt) {
      val st = stg.getInstanceOf("lcomment").
        add("text", s"Generated from $fileUri")
      stProtos.add("comment", st)
      stGlobals.add("comment", st)
      stHeaderGlobals.add("comment", st)
      stRunStmts.add("comment", st)
      stMethods.add("comment", st)
    }

    translate(program.block, None,
      stRunStmts, isetEmpty, imapEmpty, None,
      shouldReturn = false)

    if (hasIO) {
      read("logika-io.h", result)
      read("logika-io.c", result)
      result.stMain.add("io", true)
    }
    if (hasRandom) {
      read("logika-random.h", result)
      read("logika-random.c", result)
      read("FindSodium.cmake", result)
      result.stMain.add("hasRandom", true)
      result.stCMake.add("sodium", true)
    }
    if (hasTopLevel) stMain.add("hasTopLevel", true)
    else stCMake.add("library", true)
  }

  def translate(block: ast.Block,
                mdOpt: Option[ast.MethodDecl],
                stStmts: ST,
                globalVars: ISet[ast.Id],
                declaredVars: IMap[ast.Id, ast.Type],
                retTypeNameOpt: Option[String],
                shouldReturn: Boolean): Unit = {
    var varDecls = declaredVars
    for (stmt <- block.stmts)
      for (tx <- translate(stmt, mdOpt, stStmts, varDecls, retTypeNameOpt))
        varDecls += tx
    if (shouldReturn || block.returnOpt.isDefined)
      translate(block.returnOpt, mdOpt.get, stStmts,
        varWipe(varDecls -- globalVars) _, retTypeNameOpt)
    else varWipe(varDecls -- (declaredVars.keySet -- globalVars))(None, stStmts)
  }

  def varWipe(declaredVars: IMap[ast.Id, ast.Type])
             (idOpt: Option[ast.Id], stStmts: ST): Unit = {
    val tAlias = idOpt.exists(isInternalRefType)
    for ((x, t) <- declaredVars.toVector.sortWith {
      (p1, p2) => p1._1.value.compare(p2._1.value) <= 0
    }) {
      if (!tAlias || !idOpt.contains(x))
        stStmts.add("stmt",
          stg.getInstanceOf("wipeStmt").
            add("t", typeName(t)).
            add("x", name(x)))
    }
  }

  def isInternalRefType(id: ast.Id): Boolean = C.isInternalRefType(id.tipe, bitWidth)

  def isInternalRefType(t: tipe.Tipe): Boolean = C.isInternalRefType(t, bitWidth)

  def translate(rOpt: Option[ast.Return],
                md: ast.MethodDecl,
                stStmts: ST,
                varWipeFun: (Option[ast.Id], ST) => Unit,
                retTypeNameOpt: Option[String]): Unit = {
    val idOpt = retTypeNameOpt match {
      case Some(t) =>
        val retExp = rOpt.get.expOpt.get
        stStmts.add("stmt",
          stg.getInstanceOf("assignStmt").
            add("no", lineNo(retExp)).
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
    val b = md.params.size > maskLimit
    for (i <- md.params.indices) {
      val p = md.params(i)
      val t = typeName(p.tpe)
      val x = name(p.id)
      if (isInternalRefType(p.id)) {
        stStmts.add("stmt",
          (if (b) stg.getInstanceOf("maskWipe")
          else stg.getInstanceOf(s"maskWipeF")).
            add("i", i).
            add("t", t).
            add("x", x))
      } else {
        stStmts.add("stmt",
          stg.getInstanceOf("wipeStmt").
            add("t", t).
            add("x", name(x)))
      }
    }
    rOpt match {
      case Some(r) =>
        val retST = stg.getInstanceOf("returnStmt").
          add("no", lineNo(r))
        r.expOpt.foreach(_ => retST.add("e", "result"))
        stStmts.add("stmt", retST)
      case _ =>
    }
  }

  def translate(stmt: ast.Stmt,
                mdOpt: Option[ast.MethodDecl],
                stStmts: ST,
                declaredVars: IMap[ast.Id, ast.Type],
                retTypeNameOpt: Option[String]): Option[(ast.Id, ast.Type)] = {
    def idType(id: ast.Id): ast.Type = {
      declaredVars.get(id) match {
        case Some(t) => t
        case _ =>
          for (md <- mdOpt; p <- md.params) {
            return p.tpe
          }
          throw new AssertionError(s"Unexpected case: could not find ${id.value} in $declaredVars and ${mdOpt.map(_.params.map(_.id.value))}.")
      }
    }

    val isGlobal = mdOpt.isEmpty
    if (isGlobal) hasTopLevel = true
    stmt match {
      case stmt: ast.VarDecl =>
        val line = lineNo(stmt)
        val t = typeName(stmt.tpe)
        val x = name(stmt.id)
        if (isGlobal) {
          stMain.add("hasGlobals", true)
          stMainHeader.add("hasGlobals", true)
          val globalST = stg.getInstanceOf("global").
            add("t", t).
            add("x", x).
            add("no", line)
          stGlobals.add("global", globalST)
          stHeaderGlobals.add("global", new ST(globalST).add("extern", true))
          stStmts.add("stmt",
            stg.getInstanceOf("assignStmt").
              add("no", line).
              add("x", x).
              add("e", translateRhs(stmt.tpe, stmt.exp)))
        } else {
          stStmts.add("stmt",
            stg.getInstanceOf("assignStmt").
              add("no", line).
              add("t", t).
              add("x", x).
              add("e", translateRhs(stmt.tpe, stmt.exp)))
        }
        Some((stmt.id, stmt.tpe))
      case stmt: ast.Assign =>
        if (isRefType(stmt.id))
          stStmts.add("stmt",
            stg.getInstanceOf("assignRefStmt").
              add("no", lineNo(stmt)).
              add("t", typeName(idType(stmt.id))).
              add("x", name(stmt.id)).
              add("e", translate(stmt.exp)))
        else
          stStmts.add("stmt",
            stg.getInstanceOf("assignStmt").
              add("no", lineNo(stmt)).
              add("x", name(stmt.id)).
              add("e", translateRhs(idType(stmt.id), stmt.exp)))
        None
      case stmt: ast.Assume =>
        stMain.add("assumption", true)
        stStmts.add("stmt",
          stg.getInstanceOf("assumeStmt").
            add("no", lineNo(stmt)).
            add("e", translate(stmt.exp)))
        None
      case stmt: ast.Assert =>
        stMain.add("assertion", true)
        stStmts.add("stmt",
          stg.getInstanceOf("assertStmt").
            add("no", lineNo(stmt)).
            add("e", translate(stmt.exp)))
        None
      case stmt: ast.ExpStmt =>
        stStmts.add("stmt",
          translate(stmt.exp).add("end", ";").
            add("no", lineNo(stmt)))
        None
      case stmt: ast.If =>
        val eST = translate(stmt.exp)
        if (stmt.exp.isInstanceOf[ast.BinaryExp] && bitWidth != 0)
          eST.remove("paren")
        val ifST = stg.getInstanceOf("ifStmt").
          add("no", lineNo(stmt)).
          add("e", eST)
        stStmts.add("stmt", ifST)
        val stTStmts = stg.getInstanceOf("stmts")
        ifST.add("tStmts", stTStmts)
        translate(stmt.trueBlock, mdOpt, stTStmts, isetEmpty,
          declaredVars, retTypeNameOpt, shouldReturn = false)
        if (stmt.falseBlock.stmts.nonEmpty ||
          stmt.falseBlock.returnOpt.nonEmpty) {
          val stFStmts = stg.getInstanceOf("stmts")
          ifST.add("fStmts", stFStmts)
          translate(stmt.falseBlock, mdOpt, stFStmts, isetEmpty,
            declaredVars, retTypeNameOpt, shouldReturn = false)
        }
        None
      case stmt: ast.While =>
        val eST = translate(stmt.exp)
        if (stmt.exp.isInstanceOf[ast.BinaryExp] && bitWidth != 0)
          eST.remove("paren")
        val whileST = stg.getInstanceOf("whileStmt").
          add("no", lineNo(stmt)).
          add("e", eST)
        stStmts.add("stmt", whileST)
        val stWStmts = stg.getInstanceOf("stmts")
        whileST.add("stmts", stWStmts)
        translate(stmt.block, mdOpt, stWStmts, isetEmpty,
          declaredVars, retTypeNameOpt, shouldReturn = false)
        None
      case stmt: ast.Print =>
        hasIO = true
        if (stmt.isNewline && stmt.args.isEmpty) {
          stStmts.add("stmt",
            stg.getInstanceOf("callExp").
              add("no", lineNo(stmt)).
              add("id", "L_println").add("end", ";"))
        } else {
          val printST = stg.getInstanceOf("printStmt").
            add("no", lineNo(stmt))
          stStmts.add("stmt", printST)
          for ((tOpt, arg) <- stmt.argTipes.zip(stmt.args)) {
            printST.add("stmt",
              arg match {
                case ast.StringLit(value) =>
                  stg.getInstanceOf("callExp").
                    add("id", "L_print").
                    add("e", escape(value)).
                    add("end", ";")
                case arg: ast.Exp =>
                  stg.getInstanceOf("callExp").
                    add("id", s"L_print_${typeName(arg, tOpt.get)}").
                    add("e", translate(arg)).add("end", ";")
              })
          }
          if (stmt.isNewline) {
            printST.add("stmt",
              stg.getInstanceOf("callExp").
                add("id", "L_println").add("end", ";"))
          }
        }
        None
      case stmt: ast.SeqAssign =>
        stmt.id.tipe match {
          case tipe.BS =>
            stStmts.add("stmt",
              stg.getInstanceOf("callExp").
                add("no", lineNo(stmt)).
                add("id", "L_set_BS").
                add("e", translate(stmt.id)).
                add("e", translate(stmt.index)).
                add("e", translate(stmt.exp)).
                add("end", ";"))
          case _ =>
            stStmts.add("stmt",
              stg.getInstanceOf("seqAssignStmt").
                add("no", lineNo(stmt)).
                add("x", translate(stmt.id)).
                add("i", translate(stmt.index)).
                add("e", translateRhs(
                  idType(stmt.id).
                    asInstanceOf[ast.SeqType].
                    elementType, stmt.exp)))
        }
        None
      case stmt: ast.MethodDecl =>
        stMainHeader.add("hasPrototypes", true)
        stMain.add("hasPrototypes", true)
        val mretTypeNameOpt = stmt.returnTypeOpt.map(typeName)
        val mName = name(stmt.id)
        val protoST = stg.getInstanceOf("proto").
          add("no", lineNo(stmt)).
          add("t", mretTypeNameOpt.getOrElse("void")).
          add("name", mName)
        val protoDefST = stg.getInstanceOf("protoDef").
          add("name", mName)
        val methodST = stg.getInstanceOf("method")
        methodST.add("proto", protoST)
        stMethods.add("method", methodST)
        var varDecls = declaredVars
        if (stmt.params.nonEmpty) {
          if (stmt.params.size > maskLimit) {
            protoST.add("param", stg.getInstanceOf("param").
              add("t", "BS").
              add("x", maskId))
            protoDefST.add("mask", stg.getInstanceOf("callExp").
              add("e", stmt.params.size).
              add("e", "F"))
          } else {
            protoST.add("param", stg.getInstanceOf("param").
              add("t", s"U$maskLimit").
              add("x", maskId))
            protoDefST.add("mask", "0")
          }
        }
        for (p <- stmt.params) {
          val idName = name(p.id)
          protoST.add("param",
            stg.getInstanceOf("param").
              add("t", typeName(p.tpe)).
              add("x", idName))
          protoDefST.add("paramId", idName)
        }
        val stMStmts = stg.getInstanceOf("stmts")
        methodST.add("stmts", stMStmts)
        translate(stmt.block, Some(stmt), stMStmts, declaredVars.keySet,
          varDecls, mretTypeNameOpt, shouldReturn = true)
        val protoST2 = new ST(protoST)
        protoST2.add("end", ";")
        stProtos.add("proto", protoST2)
        stProtos.add("proto", protoDefST)
        None
      case _: ast.ProofElementStmt | _: ast.ProofStmt |
           _: ast.SequentStmt | _: ast.InvStmt => None
    }
  }

  def translateRhs(t: ast.Type, e: ast.Exp): ST = t match {
    case _: ast.ZType | _: ast.NType if bitWidth == 0 && !shouldFree(e) =>
      stg.getInstanceOf("cloneExp").
        add("t", typeName(t)).
        add("e", translate(e))
    case _ => translate(e)
  }

  private def lineNo(n: ast.Node): PosInteger = {
    program.nodeLocMap(n).lineBegin
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
        case t: tipe.MSeq =>
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
          stg.getInstanceOf("callExp").
            add("id", "L_get_BS").
            add("e", translate(e.args.head))
        case _: tipe.MSeq =>
          val index = e.args.head
          stg.getInstanceOf("indexExp").
            add("e", translate(e.exp)).
            add("i", translate(index)).
            add("free", shouldFree(index))
        case _ =>
          val result = stg.getInstanceOf("callExp")
          e.declOpt match {
            case Some(Left(md)) if md.params.nonEmpty =>
              if (md.params.size > maskLimit) {
                result.add("e", bsMask(e.args))
              } else {
                var mask = 0
                for ((i, arg) <- md.params.indices.zip(e.args) if shouldFree(arg)) {
                  mask = mask | (1 << i)
                }
                result.add("e", s"0x${mask.toHexString.toUpperCase}UL")
              }
              result.add("id", s"_${name(md.id)}")
            case _ =>
              result.add("id", translate(e.exp))
          }
          for (arg <- e.args) {
            result.add("e", translate(arg))
          }
          result
      }
    case _: ast.RandomInt =>
      hasRandom = true
      stg.getInstanceOf("callExp").add("id", "L_random_Z")
    case e: ast.ReadInt =>
      hasIO = true
      stg.getInstanceOf("callExp").add("id", "L_read_Z").
        add("e", e.msgOpt.map(sl => escape(sl.value)).getOrElse("\"\""))
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
              stg.getInstanceOf("litCastExp").add("t", typeName(e, tipe.Z)).add("e", s"${n}L")
          }
        case 64 =>
          val t = e.tpeOpt.map(typeName).getOrElse(typeName(e, tipe.Z))
          if (Int.MinValue <= n && n <= Int.MaxValue) {
            stg.getInstanceOf("litCastExp").add("t", t).add("e", s"${n}UL")
          } else {
            val l = n.toLong
            val e1 = (l >>> 32) & 0xFFFFFFFF
            val e2 = l & 0xFFFFFFFF
            stg.getInstanceOf("lit64Exp").add("t", t).
              add("e1", e1).add("e2", e2).add("text", n)
          }
        case _ =>
          val t = e.tpeOpt.map(typeName).getOrElse(typeName(e, tipe.Z))
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
      hasRandom = true
      stg.getInstanceOf("callExp").
        add("id", s"L_random_${typeName(e.tpe)}")
    case e: ast.TypeMethodCallExp =>
      e.id.value match {
        case "create" =>
          val size = e.args.head
          val st = stg.getInstanceOf("createExp").add("t", typeName(e.tpe)).
            add("size", translate(size)).
            add("initValue", translate(e.args(1))).
            add("free", shouldFree(size))
          if (bitWidth == 0 && shouldFree(e.args(1))) st.add("t", "f")
          st
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
            case "==" | "!=" if e.tipe.isInstanceOf[tipe.MSeq] =>
              val opEq = if (e.isInstanceOf[ast.Eq]) "eq" else "ne"
              stg.getInstanceOf("callExp").
                add("id", s"L_${opEq}_${typeName(e, e.tipe)}" +
                  (if (shouldFree(e.left)) "l" else "") +
                  (if (shouldFree(e.right)) "r" else "")).
                add("e", translate(e.left)).
                add("e", translate(e.right))
            case _ =>
              stg.getInstanceOf("binExp").
                add("e1", translate(e.left)).
                add("op", opMap.getOrElse(op, op)).
                add("e2", translate(e.right)).
                add("paren", true)
          }
      }
    case e: ast.Not =>
      stg.getInstanceOf("unExp").add("op", "!").
        add("e", translate(e.exp)).
        add("paren", true)
    case e: ast.Minus =>
      e.tipe match {
        case tipe.Z if bitWidth == 0 =>
          stg.getInstanceOf("callExp").
            add("id", "L_neg_Z" + (if (shouldFree(e)) "f" else "")).
            add("e", translate(e.exp))
        case _ =>
          stg.getInstanceOf("unExp").add("op", "-").
            add("e", translate(e.exp)).
            add("paren", true)
      }
    case _: ast.Quant[_] =>
      internalError("Unexpected contract C translation: result.")
      noResult
    case e: ast.SeqLit =>
      val result = stg.getInstanceOf("callExp")
      result.add("id", s"L_${typeName(e.tpe)}")
      e.tpe.elementType match {
        case _: ast.ZType | _: ast.NType if bitWidth == 0 =>
          result.add("id", "f")
          result.add("e", bsMask(e.args))
        case _ =>
      }
      result.add("e", e.args.size)
      for (arg <- e.args) {
        result.add("e", translate(arg))
      }
      result
  }

  def bsMask(args: ast.Node.Seq[ast.Exp]): ST = {
    val sz = if (args.size > uiMax) s"${args.size}ULL" else s"${args.size}UL"
    if (args.forall(shouldFree)) {
      stg.getInstanceOf("callExp").
        add("id", "L_create_BS").add("e", sz).add("e", "T")
    } else if (!args.exists(shouldFree)) {
      stg.getInstanceOf("callExp").
        add("id", "L_create_BS").add("e", sz).add("e", "F")
    } else {
      val st = stg.getInstanceOf("callExp").add("id", "L_BS")
      for (e <- args) st.add("e", if (shouldFree(e)) "T" else "F")
      st
    }
  }

  def shouldFree(e: ast.Exp): Boolean = e match {
    case _: ast.Id => false
    case e: ast.Apply if e.expTipe.isInstanceOf[tipe.MSeq] => false
    case _ => true
  }

  def typeName(t: ast.Type): String = t match {
    case _: ast.BType => "B"
    case _: ast.ZType =>
      bitWidth match {
        case 0 => "Z"
        case 8 => "Z8"
        case 16 => "Z16"
        case 32 => "Z32"
        case 64 => "Z64"
      }
    case _: ast.Z8Type => "Z8"
    case _: ast.Z16Type => "Z16"
    case _: ast.Z32Type => "Z32"
    case _: ast.Z64Type => "Z64"
    case _: ast.NType =>
      bitWidth match {
        case 0 => "N"
        case 8 => "N8"
        case 16 => "N16"
        case 32 => "N32"
        case 64 => "N64"
      }
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
    case _: ast.ZSType =>
      bitWidth match {
        case 0 => "ZS"
        case 8 => "Z8S"
        case 16 => "Z16S"
        case 32 => "Z32S"
        case 64 => "Z64S"
      }
    case _: ast.Z8SType => "Z8S"
    case _: ast.Z16SType => "Z16S"
    case _: ast.Z32SType => "Z32S"
    case _: ast.Z64SType => "Z64S"
    case _: ast.NSType =>
      bitWidth match {
        case 0 => "NS"
        case 8 => "N8S"
        case 16 => "N16S"
        case 32 => "N32S"
        case 64 => "N64S"
      }
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
    case tipe.Z =>
      bitWidth match {
        case 0 => "Z"
        case 8 => "Z8"
        case 16 => "Z16"
        case 32 => "Z32"
        case 64 => "Z64"
      }
    case tipe.Z8 => "Z8"
    case tipe.Z16 => "Z16"
    case tipe.Z32 => "Z32"
    case tipe.Z64 => "Z64"
    case tipe.N =>
      bitWidth match {
        case 0 => "N"
        case 8 => "N8"
        case 16 => "N16"
        case 32 => "N32"
        case 64 => "N64"
      }
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
    case tipe.ZS =>
      bitWidth match {
        case 0 => "ZS"
        case 8 => "Z8S"
        case 16 => "Z16S"
        case 32 => "Z32S"
        case 64 => "Z64S"
      }
    case tipe.Z8S => "Z8S"
    case tipe.Z16S => "Z16S"
    case tipe.Z32S => "Z32S"
    case tipe.Z64S => "Z64S"
    case tipe.NS =>
      bitWidth match {
        case 0 => "NS"
        case 8 => "N8S"
        case 16 => "N16S"
        case 32 => "N32S"
        case 64 => "N64S"
      }
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
