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

import org.sireum.logika.ast._
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

  private[logika] var satCacheEnabled = false
  private[logika] var satCachePrev: MMap[Object, (String, CheckResult)] = {
    import scala.collection.JavaConversions._
    new ConcurrentHashMap[Object, (String, CheckResult)]
  }
  private[logika] var satCacheCurrent: MMap[Object, (String, CheckResult)] = {
    import scala.collection.JavaConversions._
    new ConcurrentHashMap[Object, (String, CheckResult)]
  }

  val z3: String = {
    import java.io._
    val z3Filename = OsUtil.detect match {
      case OsArch.Win => "z3.exe"
      case _ => "z3"
    }
    val z3Bin = new File(System.getenv("SIREUM_HOME"), s"/apps/z3/bin/$z3Filename")
    if (z3Bin.canExecute) z3Bin.getAbsolutePath
    else z3Filename
  }

  def isValid(timeoutInMs: Int, isSymExe: Boolean, premises: Node.Seq[Exp], conclusions: Node.Seq[Exp])(
    implicit reporter: TagReporter, nodeLocMap: MIdMap[Node, LocationInfo]): (String, CheckResult) =
    if (premises.isEmpty) checkSat(timeoutInMs, isSymExe, Not(And(conclusions)))
    else checkSat(timeoutInMs, isSymExe, Not(Implies(And(premises), And(conclusions))))

  def checkSat(timeoutInMs: Int, isSymExe: Boolean, es: Exp*)(
    implicit reporter: TagReporter, nodeLocMap: MIdMap[Node, LocationInfo]): (String, CheckResult) = {
    def f() = new Z3(timeoutInMs, isSymExe).checkSat(es: _*)
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

private final class Z3(timeout: Int, isSymExe: Boolean)(
  implicit reporter: TagReporter,
  nodeLocMap: MIdMap[Node, LocationInfo]) {

  import Z3._

  val stg = new STGroupFile(getClass.getResource("z3.stg"), "UTF-8", '$', '$')
  val typeMap: MMap[String, Tipe] = mmapEmpty[String, Tipe]
  val lineSep = scala.util.Properties.lineSeparator
  var seqCounter = 0
  val stMain = {
    val st = stg.getInstanceOf("main")
    if (isSymExe) st.add("symexe", true)
    st
  }
  val rounding = "RNE"

  def checkSat(es: Exp*): (String, CheckResult) = {
    for (e <- es) {
      stMain.add("e",
        stg.getInstanceOf("assertion").
          add("e", translate(e))).add("e", lineSep)
      Visitor.build({
        case q: Quant[_] =>
          for (id <- q.ids) typeMap -= id.value
          true
      })(e)
    }
    for ((name, tipe) <- typeMap)
      stMain.add("d", translate(name, tipe)).
        add("d", lineSep)

    val z3Script = stMain.render()
    val result = {
      val input =
        OsUtil.detect match {
          case OsArch.Win =>
            ivector(z3, "/smt2", s"/t:$timeout", "/in")
          case _ =>
            ivector(z3, "-smt2", s"-t:$timeout", "-in")
        }
      new Exec().run(0, input, Some(z3Script), None)
    }

    val r =
      result match {
        case Exec.StringResult(s, _) =>
          s.substring(0, s.indexOf('\n')).trim match {
            case "unsat" => Unsat
            case "unknown" => Unknown
            case "sat" => Sat
            case "timeout" => Timeout
            case _ =>
              reporter.report(InternalErrorMessage("Z3",
                s"""Error occurred when calling Z3 for the following script:
$z3Script
Z3 output:
$s"""))
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
  }

  def translate(n: BigInt, tpe: IntegralType): ST = {
    val lit = tpe match {
      case _: S8Type | _: U8Type =>
        val v: java.lang.Byte = n.toByte
        String.format("#x%02X", v)
      case _: S16Type | _: U16Type =>
        val v: java.lang.Short = n.toShort
        String.format("#x%04X", v)
      case _: S32Type | _: U32Type =>
        val v: java.lang.Integer = n.toInt
        String.format("#x%08X", v)
      case _: S64Type | _: U64Type =>
        val v: java.lang.Long = n.toLong
        String.format("#x%016X", v)
      case _ => if (n < 0) s"(- ${-n})" else n.toString
    }
    stg.getInstanceOf("lit").add("value", lit)
  }

  def translate(e: Exp): ST =
    e match {
      case BooleanLit(value) =>
        stg.getInstanceOf(if (value) "truelit" else "falselit")
      case id: Id =>
        typeMap(id.value) = id.tipe
        stg.getInstanceOf("id").add("value", id.value)
      case e@Size(id) =>
        stg.getInstanceOf("size").add("id", translate(id)).
          add("tipe", translate(e.tipe))
      case e: Result =>
        val id = Id("result")
        id.tipe = e.tipe
        translate(id)
      case e: Apply =>
        if (e.id.tipe.isInstanceOf[org.sireum.logika.tipe.MSeq])
          stg.getInstanceOf("index").add("a", translate(e.id)).
            add("i", translate(e.args.head))
        else {
          val r = stg.getInstanceOf("apply").add("id", translate(e.id))
          for (arg <- e.args) r.add("exp", translate(arg))
          r
        }
      case e@IntLit(value, _, tpeOpt) =>
        val n = e.normalize
        val lit = tpeOpt match {
          case Some(tpe) => translate(n, tpe)
          case _ => value
        }
        stg.getInstanceOf("lit").add("value", lit)
      case e@FloatLit(value) =>
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
      case RealLit(value) =>
        if (value.head == '-')
          stg.getInstanceOf("lit").add("value", s"(- ${value.tail}")
        else
          stg.getInstanceOf("lit").add("value", value)
      case e: IntMin =>
        translate(e.value, e.integralType)
      case e: IntMax =>
        translate(e.value, e.integralType)
      case e@Prepend(left, right) =>
        val c = freshSeq()
        val a = translate(right)
        val v = translate(left)
        stMain.add("a",
          stg.getInstanceOf("prepend").add("c", c).add("a", a).add("v", v).
            add("tipe", translate(e.tipe))
        ).add("a", lineSep)
        stg.getInstanceOf("a").add("c", c)
      case e@Append(left, right) =>
        val c = freshSeq()
        val a = translate(left)
        val v = translate(right)
        stMain.add("a",
          stg.getInstanceOf("append").add("c", c).add("a", a).add("v", v).
            add("tipe", e.tipe)
        ).add("a", lineSep)
        stg.getInstanceOf("a").add("c", c)
      case e: BinaryExp =>
        val op =
          e match {
            case e@Ne(left, right) =>
              val eq = Eq(left, right)
              eq.tipe = e.tipe
              return translate(Not(eq))
            case e: Mul =>
              e.tipe match {
                case S8 | S16 | S32 | S64 |
                     U8 | U16 | U32 | U64 => "bvmul"
                case F32 | F64 => s"fp.mul $rounding"
                case _ => "*"
              }
            case e: Div =>
              e.tipe match {
                case S8 | S16 | S32 | S64 => "bvsdiv"
                case U8 | U16 | U32 | U64 => "bvudiv"
                case F32 | F64 => s"fp.div $rounding"
                case _ => "div"
              }
            case e: Rem =>
              e.tipe match {
                case S8 | S16 | S32 | S64 => "bvsrem"
                case U8 | U16 | U32 | U64 => "bvurem"
                case F32 | F64 => "fp.rem"
                case _ => "rem"
              }
            case e: Add =>
              e.tipe match {
                case S8 | S16 | S32 | S64 |
                     U8 | U16 | U32 | U64 => "bvadd"
                case F32 | F64 => s"fp.add $rounding"
                case _ => "+"
              }
            case e: Sub =>
              e.tipe match {
                case S8 | S16 | S32 | S64 |
                     U8 | U16 | U32 | U64 => "bvsub"
                case F32 | F64 => s"fp.sub $rounding"
                case _ => "-"
              }
            case e: Lt =>
              e.tipe match {
                case S8 | S16 | S32 | S64 => "bvslt"
                case U8 | U16 | U32 | U64 => "bvult"
                case F32 | F64 => "fp.lt"
                case _ => "<"
              }
            case e: Le =>
              e.tipe match {
                case S8 | S16 | S32 | S64 => "bvsle"
                case U8 | U16 | U32 | U64 => "bvule"
                case F32 | F64 => "fp.leq"
                case _ => "<="
              }
            case e: Gt =>
              e.tipe match {
                case S8 | S16 | S32 | S64 => "bvsgt"
                case U8 | U16 | U32 | U64 => "bvugt"
                case F32 | F64 => "fp.gt"
                case _ => ">"
              }
            case e: Ge =>
              e.tipe match {
                case S8 | S16 | S32 | S64 => "bvsge"
                case U8 | U16 | U32 | U64 => "bvuge"
                case F32 | F64 => "fp.geq"
                case _ => ">="
              }
            case e: Shl => "bvshl"
            case e: Shr =>
              e.tipe match {
                case U8 | U16 | U32 | U64 => "bvlshr"
                case _ => "bvashr"
              }
            case e: UShr => "bvlshr"
            case e: Eq =>
              e.tipe match {
                case _: org.sireum.logika.tipe.MSeq =>
                  return stg.getInstanceOf("equal").add("a1", translate(e.left)).
                    add("a2", translate(e.right)).add("tipe", translate(e.tipe))
                case F32 | F64 => "fp.eq"
                case _ => "="
              }
            case e: And =>
              e.tipe match {
                case S8 | S16 | S32 | S64 |
                     U8 | U16 | U32 | U64 => "bvand"
                case _ => "and"
              }
            case e: Xor =>
              e.tipe match {
                case S8 | S16 | S32 | S64 |
                     U8 | U16 | U32 | U64 => "bvxor"
                case _ => "xor"
              }
            case e: Or =>
              e.tipe match {
                case S8 | S16 | S32 | S64 |
                     U8 | U16 | U32 | U64 => "bvor"
                case _ => "or"
              }
            case e: Implies => "=>"
            case _: Append | _: Prepend =>
              assert(assertion = false, "Unexpected situation.")
              "???"
          }
        stg.getInstanceOf("binary").add("op", op).
          add("left", translate(e.left)).add("right", translate(e.right))
      case e: UnaryExp =>
        e match {
          case Not(exp) =>
            e.tipe match {
              case S8 | S16 | S32 | S64 |
                   U8 | U16 | U32 | U64 =>
                stg.getInstanceOf("unary").add("op", "bvnot").
                  add("exp", translate(exp))
              case _ =>
                stg.getInstanceOf("unary").add("op", "not").
                  add("exp", translate(exp))
            }
          case Minus(exp) =>
            e.tipe match {
              case S8 | S16 | S32 | S64 |
                   U8 | U16 | U32 | U64 =>
                stg.getInstanceOf("unary").add("op", "bvneg").
                  add("exp", translate(exp))
              case F32 | F64 =>
                stg.getInstanceOf("unary").add("op", "fp.neg").
                  add("exp", translate(exp))
              case _ =>
                stg.getInstanceOf("unary").add("op", "-").
                  add("exp", translate(exp))
            }
        }
      case e: Quant[_] =>
        val isForAll = e.isInstanceOf[ForAll]
        val stType = e.domainOpt match {
          case Some(_: RangeDomain) => return translate(e.simplify)
          case Some(TypeDomain(tpe)) => translate(tpe)
          case None => assert(assertion = false, "Unexpected situation.")
        }
        val st = stg.getInstanceOf("quant").
          add("op", if (isForAll) "forall" else "exists").
          add("exp", translate(e.exp))
        for (id <- e.ids)
          st.add("param",
            stg.getInstanceOf("param").add("id", translate(id)).
              add("tipe", stType))
        st
      case e: SeqLit =>
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
            add("v", translate(args.head)).add("tipe", tipe)
          i += 1
          for (arg <- args.tail) {
            stZsExp = stg.getInstanceOf("seqexp").add("i", i).
              add("v", translate(arg)).add("a", stZsExp).add("tipe", tipe)
            i += 1
          }
          stZs.add("exp", stZsExp)
        }
        stMain.add("a", stZs).add("a", lineSep)
        stg.getInstanceOf("a").add("c", c)
      case _: RandomInt | _: ReadInt | _: Clone | _: Random =>
        assert(assertion = false, "Unexpected situation.")
        null
    }

  def freshSeq(): Int = {
    val r = seqCounter
    seqCounter += 1
    r
  }

  def translate(name: String, tipe: Tipe): ST =
    tipe match {
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

  def translate(tipe: Tipe): String = tipe match {
    case B => "B"
    case Z => "Z"
    case Z8 => "Z8"
    case Z16 => "Z16"
    case Z32 => "Z32"
    case Z64 => "Z64"
    case N => "N"
    case N8 => "N8"
    case N16 => "N16"
    case N32 => "N32"
    case N64 => "N64"
    case S8 => "S8"
    case S16 => "S16"
    case S32 => "S32"
    case S64 => "S64"
    case U8 => "U8"
    case U16 => "U16"
    case U32 => "U32"
    case U64 => "U64"
    case R => "R"
    case F32 => "F32"
    case F64 => "F64"
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

  def translate(tpe: Type): String = tpe match {
    case _: BType => "B"
    case _: ZType => "Z"
    case _: Z8Type => "Z8"
    case _: Z16Type => "Z16"
    case _: Z32Type => "Z32"
    case _: Z64Type => "Z64"
    case _: NType => "N"
    case _: N8Type => "N8"
    case _: N16Type => "N16"
    case _: N32Type => "N32"
    case _: N64Type => "N64"
    case _: S8Type => "S8"
    case _: S16Type => "S16"
    case _: S32Type => "S32"
    case _: S64Type => "S64"
    case _: U8Type => "U8"
    case _: U16Type => "U16"
    case _: U32Type => "U32"
    case _: U64Type => "U64"
    case _: RType => "R"
    case _: F32Type => "F32"
    case _: F64Type => "F64"
    case _: BSType => stMain.add("BS", true); "BS"
    case _: ZSType => "ZS"
    case _: Z8SType => stMain.add("Z8S", true); "Z8S"
    case _: Z16SType => stMain.add("Z16S", true); "Z16S"
    case _: Z32SType => stMain.add("Z32S", true); "Z32S"
    case _: Z64SType => stMain.add("Z64S", true); "Z64S"
    case _: NSType => stMain.add("NS", true); "NS"
    case _: N8SType => stMain.add("N8S", true); "N8S"
    case _: N16SType => stMain.add("N16S", true); "N16S"
    case _: N32SType => stMain.add("N32S", true); "N32S"
    case _: N64SType => stMain.add("N64S", true); "N64S"
    case _: S8SType => stMain.add("S8S", true); "S8S"
    case _: S16SType => stMain.add("S16S", true); "S16S"
    case _: S32SType => stMain.add("S32S", true); "S32S"
    case _: S64SType => stMain.add("S64S", true); "S64S"
    case _: U8SType => stMain.add("U8S", true); "U8S"
    case _: U16SType => stMain.add("U16S", true); "U16S"
    case _: U32SType => stMain.add("U32S", true); "U32S"
    case _: U64SType => stMain.add("U64S", true); "U64S"
    case _: RSType => stMain.add("RS", true); "RS"
    case _: F32SType => stMain.add("F32S", true); "F32S"
    case _: F64SType => stMain.add("F64S", true); "F64S"
  }
}
