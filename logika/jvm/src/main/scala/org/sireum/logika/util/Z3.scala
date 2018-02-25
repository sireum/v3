/*
 Copyright (c) 2016, Robby, Kansas State University
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

package org.sireum.logika.util

import java.io.StringWriter
import java.util.concurrent.ConcurrentHashMap

import org.sireum.logika.ast
import org.sireum.logika.tipe._
import org.sireum.util.jvm._
import org.sireum.util._

import org.stringtemplate.v4._

object Z3 {

  sealed trait CheckResult

  case object Sat extends CheckResult

  case object Unsat extends CheckResult

  case object Unknown extends CheckResult

  case object Timeout extends CheckResult

  case object Error extends CheckResult

  private[sireum] var satCacheEnabled = false
  private[sireum] var satCachePrev: MMap[Object, (String, CheckResult)] = mmapEmpty
  private[sireum] var satCacheCurrent: MMap[Object, (String, CheckResult)] = mmapEmpty

  val z3: String = synchronized {
    import java.io._
    val z3Filename = OsUtil.detect match {
      case OsArch.Win => "z3.exe"
      case _ => "z3"
    }
    val z3Bin = new File(System.getenv("SIREUM_HOME"), s"/apps/z3/bin/$z3Filename")
    if (z3Bin.canExecute) z3Bin.getAbsolutePath
    else z3Filename
  }

  def isValid(timeoutInMs: PosInteger, isSymExe: Boolean, bitWidth: Natural,
              premises: ast.Node.Seq[ast.Exp], conclusions: ast.Node.Seq[ast.Exp])(
               implicit reporter: TagReporter, nodeLocMap: MIdMap[ast.Node, LocationInfo]): (String, CheckResult) = {
    import ast.Exp
    import org.sireum.logika.tipe._
    if (premises.isEmpty) checkSat(timeoutInMs, isSymExe, isValidity = true, bitWidth,
      Exp.Not(B, Exp.And(conclusions)))
    else if (isSymExe)
      checkSat(timeoutInMs, isSymExe, isValidity = true, bitWidth,
        premises :+ Exp.Not(B, Exp.And(conclusions)): _*)
    else
      checkSat(timeoutInMs, isSymExe, isValidity = true, bitWidth,
        Exp.Not(B, Exp.Implies(B, Exp.And(premises), Exp.And(conclusions))))
  }

  def checkSat(timeoutInMs: PosInteger, isSymExe: Boolean, isValidity: Boolean, bitWidth: Natural, es: ast.Exp*)(
    implicit reporter: TagReporter, nodeLocMap: MIdMap[ast.Node, LocationInfo]): (String, CheckResult) =
    synchronized {
      def f() = new Z3(timeoutInMs, isSymExe, isValidity, bitWidth).checkSat(es: _*)

      if (satCacheEnabled) {
        val key: Object = es match {
          case Seq(e) => e
          case _ => es
        }
        satCachePrev.get(key) match {
          case Some(v) =>
            val cr = v._2
            val r = if (cr == Timeout || cr == Unknown) f() else v
            satCacheCurrent(key) = r
            r
          case _ =>
            val r = f()
            satCachePrev(key) = r
            satCacheCurrent(key) = r
            r
        }
      } else f()
    }
}

private final class Z3(timeout: PosInteger, isSymExe: Boolean, isValidity: Boolean, bitWidth: Natural)(
  implicit reporter: TagReporter,
  nodeLocMap: MIdMap[ast.Node, LocationInfo]) {

  import Z3._

  val stg: STGroup = new STGroupFile(getClass.getResource("z3.stg"), "UTF-8", '$', '$')
  var typeMap: IMap[String, Tipe] = imapEmpty[String, Tipe]
  val lineSep: String = scala.util.Properties.lineSeparator
  var seqCounter: Natural = 0
  val stMain: ST = {
    val st = stg.getInstanceOf("main")
    if (isSymExe) st.add("symexe", true)
    st
  }
  val rounding = "RNE"
  val hardTimeout: PosInteger = timeout + (timeout * 10) / 100

  def checkSat(es: ast.Exp*): (String, CheckResult) = try {
    val last = es.size - 1
    for (i <- es.indices) {
      val e = es(i)
      if (!e.isResolved) {
        Visitor.build({
          case e: ast.Exp if !e.isResolved =>
            assert(false, s"${ast.Exp.toString(e, inProof = true)}")
            false
        }, Visitor.TraversalMode.BOTTOM_UP)(e)
      }
      stMain.add("e",
        stg.getInstanceOf("assertion").
          add("e", translate(e, isValidity && i == last))).add("e", lineSep)
    }
    for ((name, tipe) <- typeMap)
      stMain.add("d", translate(name, tipe)).
        add("d", lineSep)

    val z3Script = stMain.render()
    //println(z3Script)

    try {
      val result = {
        val input =
          OsUtil.detect match {
            case OsArch.Win =>
              ivector(z3, "/smt2", s"/t:$timeout", "/in")
            case _ =>
              ivector(z3, "-smt2", s"-t:$timeout", "-in")
          }
        new Exec().run(hardTimeout, input, Some(z3Script), None)
      }

      val r =
        result match {
          case Exec.StringResult(s, _) =>
            val i = s.indexOf('\n')
            val result = if (i >= 0) s.substring(0, i).trim else s.trim
            result match {
              case "unsat" => Unsat
              case "unknown" => Unknown
              case "sat" => Sat
              case "timeout" => Timeout
              case _ =>
                //              for (e <- es) {
                //                println(ast.Exp.toString(e, inProof = true))
                //              }
                reporter.report(InternalErrorMessage("Z3",
                  s"""Error occurred when calling Z3 for the following script:
                     |$z3Script
                     |Z3 output:
                     |$s""".stripMargin))
                Error
            }
          case Exec.Timeout => Timeout
          case Exec.ExceptionRaised(err) =>
            val sw = new StringWriter
            val pw = new java.io.PrintWriter(sw)
            pw.append("Error occurred when calling Z3:")
            pw.append(lineSep)
            err.printStackTrace(pw)
            reporter.report(InternalErrorMessage("Z3", sw.toString))
            Error
        }
      (z3Script, r)
    } catch {
      case ex: Throwable =>
        val sw = new StringWriter
        ex.printStackTrace(new java.io.PrintWriter(sw))
        reporter.report(InternalErrorMessage("Z3",
          s"""Error occurred when calling Z3 for the following script:
             |$z3Script
             |Error:
             |${sw.toString}""".stripMargin))
        (z3Script, Error)
    }
  } catch {
    case ex: Throwable =>
      val sw = new StringWriter
      ex.printStackTrace(new java.io.PrintWriter(sw))
      reporter.report(InternalErrorMessage("Z3",
        s"""Error occurred when calling Z3:
           |${sw.toString}""".stripMargin))
      ("", Error)
  }

  def translate(n: BigInt, tpe: ast.IntegralType): ST = {
    val lit = ast.Type.normalize(bitWidth, tpe) match {
      case _: ast.S8Type =>
        stMain.add("S8", true)
        val v: java.lang.Byte = n.toByte
        String.format("#x%02X", v)
      case _: ast.S16Type =>
        stMain.add("S16", true)
        val v: java.lang.Short = n.toShort
        String.format("#x%04X", v)
      case _: ast.S32Type =>
        stMain.add("S32", true)
        val v: java.lang.Integer = n.toInt
        String.format("#x%08X", v)
      case _: ast.S64Type =>
        stMain.add("S64", true)
        val v: java.lang.Long = n.toLong
        String.format("#x%016X", v)
      case _: ast.U8Type =>
        stMain.add("U8", true)
        val v: java.lang.Byte = n.toByte
        String.format("#x%02X", v)
      case _: ast.U16Type =>
        stMain.add("U16", true)
        val v: java.lang.Short = n.toShort
        String.format("#x%04X", v)
      case _: ast.U32Type =>
        stMain.add("U32", true)
        val v: java.lang.Integer = n.toInt
        String.format("#x%08X", v)
      case _: ast.U64Type =>
        stMain.add("U64", true)
        val v: java.lang.Long = n.toLong
        String.format("#x%016X", v)
      case _ => if (n < 0) s"(- ${-n})" else n.toString
    }
    stg.getInstanceOf("lit").add("value", lit)
  }

  def normalizeTipe(t: org.sireum.logika.tipe.Tipe): org.sireum.logika.tipe.Tipe =
    org.sireum.logika.tipe.Tipe.normalize(bitWidth, t)

  def translate(e: ast.Exp, isArrayEq: Boolean): ST =
    e match {
      case ast.BooleanLit(value) =>
        stg.getInstanceOf(if (value) "truelit" else "falselit")
      case id: ast.Id =>
        typeMap += id.value -> id.tipe
        stg.getInstanceOf("id").add("value", id.value)
      case e@ast.Size(id) =>
        stg.getInstanceOf("size").add("id", translate(id, isArrayEq)).
          add("tipe", translate(e.tipe))
      case e: ast.Result =>
        translate(ast.Exp.Id(e.tipe, "result"), isArrayEq)
      case e: ast.Apply =>
        if (e.expTipe.isInstanceOf[org.sireum.logika.tipe.MSeq])
          stg.getInstanceOf("index").add("a", translate(e.exp, isArrayEq)).
            add("i", translate(e.args.head, isArrayEq))
        else {
          val r = stg.getInstanceOf("apply").add("id", translate(e.exp, isArrayEq))
          for (arg <- e.args) r.add("exp", translate(arg, isArrayEq))
          r
        }
      case e@ast.IntLit(_, _, tpeOpt) =>
        val n = e.normalize
        val lit = tpeOpt match {
          case Some(tpe) => translate(n, tpe)
          case _ => translate(n, ast.ZType())
        }
        stg.getInstanceOf("lit").add("value", lit)
      case e: ast.FloatLit =>
        import java.lang.{Float => JFloat, Double => JDouble, Integer => JInteger, Long => JLong}
        e.primitiveValue match {
          case Left(f) =>
            if (JFloat.isNaN(f)) {
              stg.getInstanceOf("lit").add("value", "F32_NaN")
            } else if (JFloat.NEGATIVE_INFINITY == f) {
              stg.getInstanceOf("lit").add("value", "F32_NInf")
            } else if (JFloat.POSITIVE_INFINITY == f) {
              stg.getInstanceOf("lit").add("value", "F32_PInf")
            } else {
              val bits = JFloat.floatToRawIntBits(f)
              val sign = if ((bits & 0x80000000) != 0) 1 else 0
              var eb = JInteger.toHexString((bits & 0x7f800000) >>> 23)
              eb = "#x" + (0 until (2 - eb.length)).map(_ => '0').mkString + eb
              var sb = JInteger.toBinaryString(bits & 0x007fffff)
              sb = "#b" + (0 until (23 - sb.length)).map(_ => '0').mkString + sb
              stg.getInstanceOf("fplit").add("sign", sign).add("eb", eb).add("sb", sb)
            }
          case Right(d) =>
            if (JDouble.isNaN(d)) {
              stg.getInstanceOf("lit").add("value", "F64_NaN")
            } else if (JDouble.NEGATIVE_INFINITY == d) {
              stg.getInstanceOf("lit").add("value", "F64_NInf")
            } else if (JDouble.POSITIVE_INFINITY == d) {
              stg.getInstanceOf("lit").add("value", "F64_PInf")
            } else {
              val bits = JDouble.doubleToRawLongBits(d)
              val sign = if ((bits & 0x8000000000000000L) != 0) 1 else 0
              var eb = JLong.toBinaryString((bits & 0x7ff0000000000000L) >>> 52)
              eb = "#b" + (0 until (11 - eb.length)).map(_ => '0').mkString + eb
              var sb = JLong.toHexString(bits & 0x000fffffffffffffL)
              sb = "#x" + (0 until (13 - sb.length)).map(_ => '0').mkString + sb
              stg.getInstanceOf("fplit").add("sign", sign).add("eb", eb).add("sb", sb)
            }
        }
      case ast.RealLit(value) =>
        if (value.head == '-')
          stg.getInstanceOf("lit").add("value", s"(- ${value.tail})")
        else
          stg.getInstanceOf("lit").add("value", value)
      case e: ast.IntMin =>
        translate(e.value, e.integralType)
      case e: ast.IntMax =>
        translate(e.value, e.integralType)
      case e@ast.Prepend(left, right) =>
        val c = freshSeq()
        val a = translate(right, isArrayEq)
        val v = translate(left, isArrayEq)
        stMain.add("a",
          stg.getInstanceOf("prepend").add("c", c).add("a", a).add("v", v).
            add("tipe", translate(e.tipe))
        ).add("a", lineSep)
        stg.getInstanceOf("a").add("c", c)
      case e@ast.Append(left, right) =>
        val c = freshSeq()
        val a = translate(left, isArrayEq)
        val v = translate(right, isArrayEq)
        stMain.add("a",
          stg.getInstanceOf("append").add("c", c).add("a", a).add("v", v).
            add("tipe", e.tipe)
        ).add("a", lineSep)
        stg.getInstanceOf("a").add("c", c)
      case e: ast.BinaryExp =>
        var multiLine = false
        val op =
          e match {
            case e@ast.Ne(left, right) =>
              val eq = ast.Exp.Eq(e.tipe, left, right)
              eq.tipe = e.tipe
              return translate(ast.Exp.Not(B, eq), isArrayEq)
            case e: ast.Mul =>
              normalizeTipe(e.tipe) match {
                case S8 | S16 | S32 | S64 |
                     U8 | U16 | U32 | U64 => "bvmul"
                case F32 | F64 => s"fp.mul $rounding"
                case _ => "*"
              }
            case e: ast.Div =>
              normalizeTipe(e.tipe) match {
                case S8 | S16 | S32 | S64 => "bvsdiv"
                case U8 | U16 | U32 | U64 => "bvudiv"
                case F32 | F64 => s"fp.div $rounding"
                case _ => "div"
              }
            case e: ast.Rem =>
              normalizeTipe(e.tipe) match {
                case S8 | S16 | S32 | S64 => "bvsrem"
                case U8 | U16 | U32 | U64 => "bvurem"
                case F32 | F64 => "fp.rem"
                case _ => "rem"
              }
            case e: ast.Add =>
              normalizeTipe(e.tipe) match {
                case S8 | S16 | S32 | S64 |
                     U8 | U16 | U32 | U64 => "bvadd"
                case F32 | F64 => s"fp.add $rounding"
                case _ => "+"
              }
            case e: ast.Sub =>
              normalizeTipe(e.tipe) match {
                case S8 | S16 | S32 | S64 |
                     U8 | U16 | U32 | U64 => "bvsub"
                case F32 | F64 => s"fp.sub $rounding"
                case _ => "-"
              }
            case e: ast.Lt =>
              normalizeTipe(e.tipe) match {
                case S8 | S16 | S32 | S64 => "bvslt"
                case U8 | U16 | U32 | U64 => "bvult"
                case F32 | F64 => "fp.lt"
                case _ => "<"
              }
            case e: ast.Le =>
              normalizeTipe(e.tipe) match {
                case S8 | S16 | S32 | S64 => "bvsle"
                case U8 | U16 | U32 | U64 => "bvule"
                case F32 | F64 => "fp.leq"
                case _ => "<="
              }
            case e: ast.Gt =>
              normalizeTipe(e.tipe) match {
                case S8 | S16 | S32 | S64 => "bvsgt"
                case U8 | U16 | U32 | U64 => "bvugt"
                case F32 | F64 => "fp.gt"
                case _ => ">"
              }
            case e: ast.Ge =>
              normalizeTipe(e.tipe) match {
                case S8 | S16 | S32 | S64 => "bvsge"
                case U8 | U16 | U32 | U64 => "bvuge"
                case F32 | F64 => "fp.geq"
                case _ => ">="
              }
            case _: ast.Shl => "bvshl"
            case e: ast.Shr =>
              normalizeTipe(e.tipe) match {
                case U8 | U16 | U32 | U64 => "bvlshr"
                case _ => "bvashr"
              }
            case _: ast.UShr => "bvlshr"
            case e: ast.Eq =>
              normalizeTipe(e.tipe) match {
                case _: org.sireum.logika.tipe.MSeq if isArrayEq =>
                  return stg.getInstanceOf("equal").add("a1", translate(e.left, isArrayEq)).
                    add("a2", translate(e.right, isArrayEq)).add("tipe", translate(e.tipe))
                case F32 | F64 => "fp.eq"
                case _ => "="
              }
            case e: ast.And =>
              multiLine = true
              normalizeTipe(e.tipe) match {
                case S8 | S16 | S32 | S64 |
                     U8 | U16 | U32 | U64 => "bvand"
                case _ =>
                  var l = ilistEmpty[ast.Exp]
                  var e2: ast.Exp = e
                  while (e2.isInstanceOf[ast.And]) {
                    val and = e2.asInstanceOf[ast.And]
                    l = and.right :: l
                    e2 = and.left
                  }
                  l = e2 :: l
                  if (l.size > 2) {
                    val st = stg.getInstanceOf("multi")
                    st.add("op", "and")
                    for (e <- l) {
                      st.add("exp", translate(e, isArrayEq))
                    }
                    return st
                  } else "and"
              }
            case e: ast.Xor =>
              normalizeTipe(e.tipe) match {
                case S8 | S16 | S32 | S64 |
                     U8 | U16 | U32 | U64 => "bvxor"
                case _ => "xor"
              }
            case e: ast.Or =>
              multiLine = true
              normalizeTipe(e.tipe) match {
                case S8 | S16 | S32 | S64 |
                     U8 | U16 | U32 | U64 => "bvor"
                case _ =>
                  var l = ilistEmpty[ast.Exp]
                  var e2: ast.Exp = e
                  while (e2.isInstanceOf[ast.Or]) {
                    val or = e2.asInstanceOf[ast.Or]
                    l = or.right :: l
                    e2 = or.left
                  }
                  l = e2 :: l
                  if (l.size > 2) {
                    val st = stg.getInstanceOf("multi")
                    st.add("op", "or")
                    for (e <- l) {
                      st.add("exp", translate(e, isArrayEq))
                    }
                    return st
                  } else "or"
              }
            case _: ast.Implies =>
              multiLine = true
              var l = ivectorEmpty[ast.Exp]
              var e2: ast.Exp = e
              while (e2.isInstanceOf[ast.Implies]) {
                val implies = e2.asInstanceOf[ast.Implies]
                l = l :+ implies.left
                e2 = implies.right
              }
              l = l :+ e2
              if (l.size > 2) {
                val st = stg.getInstanceOf("multi")
                st.add("op", "=>")
                for (e <- l) {
                  st.add("exp", translate(e, isArrayEq))
                }
                return st
              } else "=>"
            case _: ast.Append | _: ast.Prepend =>
              assert(assertion = false, "Unexpected situation.")
              "???"
          }
        stg.getInstanceOf(if (multiLine) "binaryLine" else "binary").add("op", op).
          add("left", translate(e.left, isArrayEq)).add("right", translate(e.right, isArrayEq))
      case e: ast.UnaryExp =>
        e match {
          case ast.Not(exp) =>
            normalizeTipe(e.tipe) match {
              case S8 | S16 | S32 | S64 |
                   U8 | U16 | U32 | U64 =>
                stg.getInstanceOf("unary").add("op", "bvnot").
                  add("exp", translate(exp, isArrayEq))
              case _ =>
                stg.getInstanceOf("unary").add("op", "not").
                  add("exp", translate(exp, isArrayEq))
            }
          case ast.Minus(exp) =>
            normalizeTipe(e.tipe) match {
              case S8 | S16 | S32 | S64 |
                   U8 | U16 | U32 | U64 =>
                stg.getInstanceOf("unary").add("op", "bvneg").
                  add("exp", translate(exp, isArrayEq))
              case F32 | F64 =>
                stg.getInstanceOf("unary").add("op", "fp.neg").
                  add("exp", translate(exp, isArrayEq))
              case _ =>
                stg.getInstanceOf("unary").add("op", "-").
                  add("exp", translate(exp, isArrayEq))
            }
        }
      case e: ast.Quant[_] =>
        val isForAll = e.isInstanceOf[ast.ForAll]
        val stType = e.domainOpt match {
          case Some(rd: ast.RangeDomain) =>
            val tpe = (rd.tipe: @unchecked) match {
              case Z => ast.ZType()
              case Z8 => ast.Z8Type()
              case Z16 => ast.Z16Type()
              case Z32 => ast.Z32Type()
              case Z64 => ast.Z64Type()
              case N => ast.NType()
              case N8 => ast.N8Type()
              case N16 => ast.N16Type()
              case N32 => ast.N32Type()
              case N64 => ast.N64Type()
              case S8 => ast.S8Type()
              case S16 => ast.S16Type()
              case S32 => ast.S32Type()
              case S64 => ast.S64Type()
              case U8 => ast.U8Type()
              case U16 => ast.U16Type()
              case U32 => ast.U32Type()
              case U64 => ast.U64Type()
              case R => ast.RType()
              case F32 => ast.F32SType()
              case F64 => ast.F32SType()
            }
            val q = e.simplify match {
              case e: ast.ForAll => e.copy(domainOpt = Some(ast.TypeDomain(tpe)))
              case e: ast.Exists => e.copy(domainOpt = Some(ast.TypeDomain(tpe)))
            }
            return translate(q, isArrayEq)
          case Some(ast.TypeDomain(tpe)) => translate(tpe)
          case None => assert(assertion = false, "Unexpected situation.")
        }
        val m = mmapEmpty[String, Tipe]
        val st = stg.getInstanceOf("quant")
        for (id <- e.ids) {
          val name = id.value
          typeMap.get(name) match {
            case Some(t) => m(name) = t
            case _ =>
          }
          typeMap += name -> id.tipe
          st.add("param",
            stg.getInstanceOf("param").add("id", translate(id, isArrayEq)).
              add("tipe", stType))
        }
        st.add("op", if (isForAll) "forall" else "exists").
          add("exp", translate(e.exp, isArrayEq))
        for (id <- e.ids) {
          val name = id.value
          m.get(name) match {
            case Some(t) => typeMap += name -> t
            case _ => typeMap -= name
          }
        }
        st
      case e: ast.SeqLit =>
        val c = freshSeq()
        val tipe = translate(e.tpe)
        val stZs = stg.getInstanceOf("declseq").add("c", c).
          add("size", e.args.size).add("tipe", tipe)
        if (e.args.isEmpty)
          stZs.add("exp", s"${tipe}_empty")
        else {
          val args = e.args
          var i = 0
          var stZsExp = stg.getInstanceOf("seqexp").add("i", i).
            add("v", translate(args.head, isArrayEq)).add("tipe", tipe)
          i += 1
          for (arg <- args.tail) {
            stZsExp = stg.getInstanceOf("seqexp").add("i", i).
              add("v", translate(arg, isArrayEq)).add("a", stZsExp).add("tipe", tipe)
            i += 1
          }
          stZs.add("exp", stZsExp)
        }
        stMain.add("a", stZs).add("a", lineSep)
        stg.getInstanceOf("a").add("c", c)
      case _: ast.RandomInt | _: ast.ReadInt |
           _: ast.Clone | _: ast.Random | _: ast.TypeMethodCallExp =>
        assert(assertion = false, "Unexpected situation.")
        null
    }

  def freshSeq(): Int = {
    val r = seqCounter
    seqCounter += 1
    r
  }

  def translate(name: String, tipe: Tipe): ST =
    normalizeTipe(tipe) match {
      case B | Z | Z8 | Z16 | Z32 | Z64 |
           N | N8 | N16 | N32 | N64 |
           S8 | S16 | S32 | S64 |
           U8 | U16 | U32 | U64 |
           R | F32 | F64 |
           BS | ZS | Z8S | Z16S | Z32S | Z64S |
           NS | N8S | N16S | N32S | N64S |
           S8S | S16S | S32S | S64S |
           U8S | U16S | U32S | U64S |
           RS | F32S | F64S =>
        stg.getInstanceOf("const").add("name", name).
          add("tipe", translate(tipe))
      case tipe: FunTipe =>
        val st = stg.getInstanceOf("fun").add("name", name).
          add("result", translate(tipe.result))
        for (p <- tipe.params) {
          st.add("param", translate(p))
        }
        st
      case UnitTipe =>
        assert(assertion = false, "Unexpected situation."); null
    }

  def translate(tipe: Tipe): String = normalizeTipe(tipe) match {
    case B => "B"
    case Z => "Z"
    case Z8 => stMain.add("Z8", true); "Z8"
    case Z16 => stMain.add("Z16", true); "Z16"
    case Z32 => stMain.add("Z32", true); "Z32"
    case Z64 => stMain.add("Z64", true); "Z64"
    case N => stMain.add("N", true); "N"
    case N8 => stMain.add("N8", true); "N8"
    case N16 => stMain.add("N16", true); "N16"
    case N32 => stMain.add("N32", true); "N32"
    case N64 => stMain.add("N64", true); "N64"
    case S8 => stMain.add("S8", true); "S8"
    case S16 => stMain.add("S16", true); "S16"
    case S32 => stMain.add("S32", true); "S32"
    case S64 => stMain.add("S64", true); "S64"
    case U8 => stMain.add("U8", true); "U8"
    case U16 => stMain.add("U16", true); "U16"
    case U32 => stMain.add("U32", true); "U32"
    case U64 => stMain.add("U64", true); "U64"
    case R => stMain.add("R", true); "R"
    case F32 => stMain.add("F32", true); "F32"
    case F64 => stMain.add("F64", true); "F64"
    case BS => stMain.add("BS", true); "BS"
    case ZS => "ZS"
    case Z8S => stMain.add("Z8S", true); "Z8S"
    case Z16S => stMain.add("Z16S", true); "Z16S"
    case Z32S => stMain.add("Z32S", true); "Z32S"
    case Z64S => stMain.add("Z64S", true); "Z64S"
    case NS => stMain.add("NS", true); "NS"
    case N8S => stMain.add("N8S", true); "N8S"
    case N16S => stMain.add("N16S", true); "N16S"
    case N32S => stMain.add("N32S", true); "N32S"
    case N64S => stMain.add("N64S", true); "N64S"
    case S8S => stMain.add("S8S", true); "S8S"
    case S16S => stMain.add("S16S", true); "S16S"
    case S32S => stMain.add("S32S", true); "S32S"
    case S64S => stMain.add("S64S", true); "S64S"
    case U8S => stMain.add("U8S", true); "U8S"
    case U16S => stMain.add("U16S", true); "U16S"
    case U32S => stMain.add("U32S", true); "U32S"
    case U64S => stMain.add("U64S", true); "U64S"
    case RS => stMain.add("RS", true); "RS"
    case F32S => stMain.add("F32S", true); "F32S"
    case F64S => stMain.add("F64S", true); "F64S"
    case _: FunTipe | UnitTipe =>
      assert(assertion = false, "Unexpected situation."); "???"
  }

  def translate(tpe: ast.Type): String = tpe match {
    case _: ast.BType => "B"
    case _: ast.ZType =>
      bitWidth match {
        case 0 => "Z"
        case 8 => stMain.add("Z8", true); "Z8"
        case 16 => stMain.add("Z16", true); "Z16"
        case 32 => stMain.add("Z32", true); "Z32"
        case 64 => stMain.add("Z64", true); "Z64"
      }
    case _: ast.Z8Type => stMain.add("Z8", true); "Z8"
    case _: ast.Z16Type => stMain.add("Z16", true); "Z16"
    case _: ast.Z32Type => stMain.add("Z32", true); "Z32"
    case _: ast.Z64Type => stMain.add("Z64", true); "Z64"
    case _: ast.NType => stMain.add("N", true); "N"
    case _: ast.N8Type => stMain.add("N8", true); "N8"
    case _: ast.N16Type => stMain.add("N16", true); "N16"
    case _: ast.N32Type => stMain.add("N32", true); "N32"
    case _: ast.N64Type => stMain.add("N64", true); "N64"
    case _: ast.S8Type => stMain.add("S8", true); "S8"
    case _: ast.S16Type => stMain.add("S16", true); "S16"
    case _: ast.S32Type => stMain.add("S32", true); "S32"
    case _: ast.S64Type => stMain.add("S64", true); "S64"
    case _: ast.U8Type => stMain.add("U8", true); "U8"
    case _: ast.U16Type => stMain.add("U16", true); "U16"
    case _: ast.U32Type => stMain.add("U32", true); "U32"
    case _: ast.U64Type => stMain.add("U64", true); "U64"
    case _: ast.RType => stMain.add("R", true); "R"
    case _: ast.F32Type => stMain.add("F32", true); "F32"
    case _: ast.F64Type => stMain.add("F64", true); "F64"
    case _: ast.BSType => stMain.add("BS", true); "BS"
    case _: ast.ZSType => "ZS"
    case _: ast.Z8SType => stMain.add("Z8S", true); "Z8S"
    case _: ast.Z16SType => stMain.add("Z16S", true); "Z16S"
    case _: ast.Z32SType => stMain.add("Z32S", true); "Z32S"
    case _: ast.Z64SType => stMain.add("Z64S", true); "Z64S"
    case _: ast.NSType => stMain.add("NS", true); "NS"
    case _: ast.N8SType => stMain.add("N8S", true); "N8S"
    case _: ast.N16SType => stMain.add("N16S", true); "N16S"
    case _: ast.N32SType => stMain.add("N32S", true); "N32S"
    case _: ast.N64SType => stMain.add("N64S", true); "N64S"
    case _: ast.S8SType => stMain.add("S8S", true); "S8S"
    case _: ast.S16SType => stMain.add("S16S", true); "S16S"
    case _: ast.S32SType => stMain.add("S32S", true); "S32S"
    case _: ast.S64SType => stMain.add("S64S", true); "S64S"
    case _: ast.U8SType => stMain.add("U8S", true); "U8S"
    case _: ast.U16SType => stMain.add("U16S", true); "U16S"
    case _: ast.U32SType => stMain.add("U32S", true); "U32S"
    case _: ast.U64SType => stMain.add("U64S", true); "U64S"
    case _: ast.RSType => stMain.add("RS", true); "RS"
    case _: ast.F32SType => stMain.add("F32S", true); "F32S"
    case _: ast.F64SType => stMain.add("F64S", true); "F64S"
  }
}
