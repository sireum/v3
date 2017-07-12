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

package org.sireum.lang.tools

import java.io.File

import org.sireum.lang.ast._
import org.sireum.lang.parser.SlangParser
import org.sireum.lang.symbol.{GlobalDeclarationResolver, Resolver}
import org.sireum.lang.util.Reporter
import org.stringtemplate.v4.{ST, STGroup, STGroupFile}
import org.sireum.{ISZ, Poset, Map => SMap, None => SNone, Option => SOption, Some => SSome, String => SString}
import org.sireum.math._Z
import org.sireum.util.{ErrorTag, LocationInfoTag, MessageTag, WarningTag}
import org.sireum.util.jvm.FileUtil

object TransformerGen {
  def apply(allowSireumPackage: Boolean,
            isImmutable: Boolean,
            licenseOpt: Option[File],
            src: File,
            dest: File,
            nameOpt: Option[String],
            reporter: Reporter = new Reporter {
              def error(posOpt: SOption[PosInfo], message: SString): Unit = {
                posOpt match {
                  case SSome(pos) => Console.err.println(s"[${pos.beginLine}, ${pos.beginColumn}] $message")
                  case _ => Console.err.println(message)
                }
                Console.err.flush()
              }

              def warn(posOpt: SOption[PosInfo], message: SString): Unit = {
                posOpt match {
                  case SSome(pos) => Console.out.println(s"[${pos.beginLine}, ${pos.beginColumn}] $message")
                  case _ => Console.out.println(message)
                }
                Console.out.flush()
              }
            }): Option[String] = {
    val srcText = FileUtil.readFile(src)._1
    val srcUri = FileUtil.toUri(src)
    val r = SlangParser(allowSireumPackage, isWorksheet = false, isDiet = false, Some(srcUri), srcText)
    if (r.tags.nonEmpty) {
      for (tag <- r.tags) (tag: @unchecked) match {
        case tag: ErrorTag with LocationInfoTag with MessageTag =>
          reporter.error(SSome(PosInfo(SSome(srcUri), tag.lineBegin, tag.columnBegin,
            tag.lineEnd, tag.columnEnd, tag.offset, tag.length)), tag.message)
      }
      return None
    }
    r.unitOpt match {
      case SSome(p: TopUnit.Program) =>
        val gdr = GlobalDeclarationResolver(SMap.empty, SMap.empty, reporter)
        gdr.resolveProgram(p)
        Some(new TransformerGen(
          isImmutable,
          licenseOpt.map(FileUtil.readFile(_)._1.trim),
          Some(dest.getParentFile.toPath.relativize(src.toPath).toString),
          nameOpt.getOrElse(if (isImmutable) "Transformer" else "MTransformer"),
          Util.ids2strings(p.packageName.ids),
          gdr.globalNameMap,
          gdr.globalTypeMap,
          reporter).gen().render().replaceAllLiterally(System.lineSeparator, "\n").trim)
      case _ =>
        reporter.error(SNone(), "Expecting program input.")
        return None
    }
  }
}

class TransformerGen(isImmutable: Boolean,
                     licenseOpt: Option[String],
                     fileUriOpt: Option[String],
                     name: String,
                     packageName: ISZ[SString],
                     globalNameMap: SMap[ISZ[SString], Resolver.Info],
                     globalTypeMap: SMap[ISZ[SString], Resolver.TypeInfo],
                     reporter: Reporter) {

  val stg = new STGroupFile(
    getClass.getResource(
      if (isImmutable) "transformer.stg" else "mtransformer.stg"),
    "UTF-8", '$', '$')
  val stMain = stg.getInstanceOf("main")
  val packagePrefix =
    if (packageName.isEmpty) ""
    else packageName.elements.mkString(".") + "."

  val poset: Poset[ISZ[SString]] = {
    var r = Poset.empty[ISZ[SString]]

    def findParent(childName: ISZ[SString], name: ISZ[SString]): Option[ISZ[SString]] = {
      if (childName.isEmpty) return None
      val childPackageName = ISZ(childName.elements.dropRight(1): _*)
      val n = childPackageName ++ name
      if (r.parents.contains(n)) {
        return Some(n)
      }
      findParent(childPackageName, name)
    }

    for (ti <- globalTypeMap.values) {
      ti match {
        case ti: Resolver.AbstractDatatypeInfo if ti.ast.isRoot =>
          r = r.addNode(ti.name)
        case ti: Resolver.SigInfo =>
          r = r.addNode(ti.name)
        case _ =>
      }
    }
    for (ti <- globalTypeMap.values) {
      ti match {
        case ti: Resolver.AbstractDatatypeInfo if !ti.ast.isRoot =>
          for (t <- ti.ast.parents) {
            findParent(ti.name, Util.ids2strings(t.name.ids)) match {
              case Some(parentIds) =>
                globalTypeMap.get(parentIds) match {
                  case SSome(parent: Resolver.AbstractDatatypeInfo) =>
                    r = r.addChildren(parent.name, ISZ(ti.name))
                  case SSome(parent: Resolver.SigInfo) =>
                    r = r.addChildren(parent.name, ISZ(ti.name))
                  case _ =>
                }
              case _ =>
                reporter.error(t.attr.posInfoOpt, s"Could not find ${typeString(ti.name)}'s super type ${typeString(Util.ids2strings(t.name.ids))}.")
            }
          }
        case _ =>
      }
    }
    r
  }

  var optionAdded = false
  var moptionAdded = false
  var collAdded = Set[String]()
  var specificAdded = Set[String]()

  def gen(): ST = {
    licenseOpt.foreach(stMain.add("license", _))
    fileUriOpt.foreach(stMain.add("fileUri", _))
    for (id <- packageName) {
      stMain.add("packageName", id.value)
    }

    stMain.add("name", name)

    for (ti <- globalTypeMap.values) {
      ti match {
        case ti: Resolver.AbstractDatatypeInfo => genAdt(ti)
        case _ =>
      }
    }

    stMain
  }

  def adtParent(n: ISZ[SString]): Option[ISZ[SString]] = {
    var r = ISZ[SString]()
    for (name <- poset.parentsOf(n).elements if r.isEmpty)
      globalTypeMap.get(name) match {
        case SSome(_: Resolver.AbstractDatatypeInfo) => r = name
        case _ =>
      }
    if (r.isEmpty) None else Some(r)
  }

  def findName(currName: ISZ[SString], name: ISZ[SString]): Option[ISZ[SString]] = {
    if (currName.isEmpty) return None
    val currPackageName = ISZ(currName.elements.dropRight(1): _*)
    val n = currPackageName ++ name
    globalTypeMap.get(n) match {
      case SSome(_: Resolver.AbstractDatatypeInfo) => return Some(n)
      case _ =>
    }
    findName(currPackageName, name)
  }

  def genRoot(name: ISZ[SString], isSig: Boolean): Unit = {
    val rootTypeString = typeString(name)
    val rootTypeName = typeName(rootTypeString)
    val preMethodRootST = stg.getInstanceOf("preMethodRoot").
      add("typeName", rootTypeName).add("type", rootTypeString)
    val postMethodRootST = stg.getInstanceOf("postMethodRoot").
      add("typeName", rootTypeName).add("type", rootTypeString)
    val transformMethodMatchST = stg.getInstanceOf("transformMethodMatch").
      add("type", rootTypeString)
    val transformMethodST = stg.getInstanceOf("transformMethod").
      add("typeName", rootTypeName).
      add("type", rootTypeString).
      add("transformMethodMatch", transformMethodMatchST)
    if (isSig) {
      transformMethodST.
        add("preAdapt",
          stg.getInstanceOf("preAdaptUp").
            add("type", rootTypeString)).
        add("postAdapt",
          stg.getInstanceOf("postAdaptUp").
            add("type", rootTypeString))
    }
    stMain.add("preMethod", preMethodRootST)
    stMain.add("postMethod", postMethodRootST)
    stMain.add("transformMethod", transformMethodST)
    for (childIds <- poset.descendantsOf(name).elements) {
      globalTypeMap.get(childIds) match {
        case SSome(childTI: Resolver.AbstractDatatypeInfo) if !childTI.ast.isRoot =>
          val childTypeString = typeString(childIds)
          val childTypeName = typeName(childTypeString)
          preMethodRootST.add("preMethodRootCase", stg.getInstanceOf("preMethodRootCase").
            add("typeName", childTypeName).
            add("type", childTypeString))
          postMethodRootST.add("postMethodRootCase", stg.getInstanceOf("postMethodRootCase").
            add("typeName", childTypeName).
            add("type", childTypeString))
          val transformMethodCaseST = stg.getInstanceOf("transformMethodCase").
            add("type", childTypeString)
          transformMethodMatchST.add("transformMethodCase", transformMethodCaseST)
          genAdtChild(transformMethodCaseST, childTI)
        case _ =>
      }
    }
  }

  def genAdt(ti: Resolver.AbstractDatatypeInfo): Unit = {
    if (!ti.ast.isDatatype && isImmutable) {
      reporter.error(ti.ast.id.attr.posInfoOpt, s"Cannot generate immutable transformer for @record ${ti.ast.id.value}.")
      return
    }
    if (ti.ast.isRoot) genRoot(ti.name, isSig = false)
    else {
      val adTypeString = typeString(ti.name)
      val adTypeName = typeName(adTypeString)
      val superTypeString = adtParent(ti.name) match {
        case Some(name) => typeString(name)
        case _ => adTypeString
      }
      stMain.add("preMethod",
        stg.getInstanceOf("preMethod").
          add("typeName", adTypeName).
          add("type", adTypeString).
          add("superType", superTypeString))
      stMain.add("postMethod",
        stg.getInstanceOf("postMethod").
          add("typeName", adTypeName).
          add("type", adTypeString).
          add("superType", superTypeString))
      if (poset.parentsOf(ti.name).isEmpty) {
        val transformMethodMatchSimpleST = stg.getInstanceOf("transformMethodMatchSimple")
        stMain.add("transformMethod",
          stg.getInstanceOf("transformMethod").
            add("typeName", adTypeName).
            add("type", adTypeString).
            add("transformMethodMatch", transformMethodMatchSimpleST))
        genAdtChild(transformMethodMatchSimpleST, ti)
      }
    }
  }

  def transformSpecific(name: ISZ[SString]): Unit = {
    globalTypeMap.get(name) match {
      case SSome(ti: Resolver.AbstractDatatypeInfo) if !ti.ast.isRoot && adtParent(ti.name).nonEmpty =>
        val adTypeString = typeString(name)
        if (specificAdded.contains(adTypeString)) {
          return
        }
        specificAdded += adTypeString
        val adTypeName = typeName(adTypeString)
        val transformMethodMatchSimpleST = stg.getInstanceOf("transformMethodMatchSimple")
        stMain.add("transformMethod",
          stg.getInstanceOf("transformMethod").
            add("typeName", adTypeName).
            add("type", adTypeString).
            add("transformMethodMatch", transformMethodMatchSimpleST).
            add("preAdapt",
              stg.getInstanceOf("preAdaptDown").
                add("type", adTypeString)).
            add("postAdapt",
              stg.getInstanceOf("postAdaptDown").
                add("type", adTypeString)))
        genAdtChild(transformMethodMatchSimpleST, ti)
      case SSome(ti: Resolver.SigInfo) => genRoot(name, isSig = true)
      case _ =>
    }
  }

  def genAdtChild(st: ST, ti: Resolver.AbstractDatatypeInfo): Unit = {
    def addChangedUpdate(i: Int, fieldName: String): Unit = {
      st.add("transformMethodCaseChanged",
        stg.getInstanceOf("transformMethodCaseChanged").
          add("i", i))
      st.add("transformMethodCaseUpdate",
        stg.getInstanceOf("transformMethodCaseUpdate").
          add("i", i).
          add("fieldName", fieldName))
    }

    def transformMethodCaseMemberS(isImmutable: Boolean, i: Int, indexType: String, name: ISZ[SString], fieldName: String): Unit = {
      val adTypeString = typeString(name)
      val adTypeName = typeName(adTypeString)
      val transformMethodCaseMemberSST =
        stg.getInstanceOf(
          if (isImmutable) "transformMethodCaseMemberIS"
          else "transformMethodCaseMemberMS").
          add("i", i).
          add("indexType", indexType).
          add("typeName", adTypeName).
          add("type", adTypeString).
          add("fieldName", fieldName)
      if (this.isImmutable && i != 0) transformMethodCaseMemberSST.add("j", i - 1)
      st.add("transformMethodCaseMember", transformMethodCaseMemberSST)
      addChangedUpdate(i, fieldName)
      val coll = (if (isImmutable) "IS" else "MS") + indexType
      if (!collAdded.contains(coll)) {
        collAdded = collAdded + coll
        stMain.add("transformHelper",
          stg.getInstanceOf(if (isImmutable) "transformIS" else "transformMS").
            add("indexType", indexType))
      }
      transformSpecific(name)
    }

    var i = 0
    for (p <- ti.ast.params) {
      val fieldName = p.id.value.value
      p.tipe match {
        case t: Type.Named =>
          val ts = typeString(t)
          ts match {
            case "IS" | "MS" =>
              val isImmutable = ts == "IS"
              if (this.isImmutable && !isImmutable) {
                reporter.error(p.id.attr.posInfoOpt, s"MS unsupported in immutable transformer for parameter ${p.id.value}")
                return
              }
              adtNameOpt(ti.name, t.typeArgs(1)) match {
                case Some(name) =>
                  transformMethodCaseMemberS(isImmutable, i,
                    typeString(t.typeArgs(0).asInstanceOf[Type.Named]),
                    name, fieldName)
                  i += 1
                case _ =>
              }
            case "ISZ" | "ISZ8" | "ISZ16" | "ISZ32" | "ISZ64"
                 | "ISN" | "ISN8" | "ISN16" | "ISN32" | "ISN64"
                 | "ISS8" | "ISS16" | "ISS32" | "ISS64"
                 | "ISU8" | "ISU16" | "ISU32" | "ISU64"
                 | "MSZ" | "MSZ8" | "MSZ16" | "MSZ32" | "MSZ64"
                 | "MSN" | "MSN8" | "MSN16" | "MSN32" | "MSN64"
                 | "MSS8" | "MSS16" | "MSS32" | "MSS64"
                 | "MSU8" | "MSU16" | "MSU32" | "MSU64" =>
              val isImmutable = ts.substring(0, 2) == "IS"
              if (this.isImmutable && !isImmutable) {
                reporter.error(p.id.attr.posInfoOpt, s"MS unsupported in immutable transformer for parameter ${p.id.value}")
                return
              }
              adtNameOpt(ti.name, t.typeArgs(0)) match {
                case Some(name) =>
                  transformMethodCaseMemberS(isImmutable, i,
                    ts.substring(2),
                    name, fieldName)
                  i += 1
                case _ =>
              }
            case "Option" | "MOption" =>
              val isImmutable = ts == "Option"
              if (this.isImmutable && !isImmutable) {
                reporter.error(p.id.attr.posInfoOpt, s"MOption unsupported in immutable transformer for parameter ${p.id.value}")
                return
              }
              adtNameOpt(ti.name, t.typeArgs(0)) match {
                case Some(name) =>
                  val adTypeString = typeString(name)
                  val adTypeName = typeName(adTypeString)
                  val transformMethodCaseMemberOptionST = stg.getInstanceOf(
                    if (isImmutable) "transformMethodCaseMemberOption" else "transformMethodCaseMemberMOption").
                    add("i", i).
                    add("typeName", adTypeName).
                    add("type", adTypeString).
                    add("fieldName", fieldName)
                  if (this.isImmutable && i != 0) transformMethodCaseMemberOptionST.add("j", i - 1)
                  st.add("transformMethodCaseMember", transformMethodCaseMemberOptionST)
                  addChangedUpdate(i, fieldName)
                  if (isImmutable && !optionAdded) {
                    optionAdded = true
                    stMain.add("transformHelper", stg.getInstanceOf("transformOption"))
                  } else if (!isImmutable && !moptionAdded) {
                    moptionAdded = true
                    stMain.add("transformHelper", stg.getInstanceOf("transformMOption"))
                  }
                  transformSpecific(name)
                  i += 1
                case _ =>
              }
            case _ =>
              adtNameOpt(ti.name, Util.ids2strings(t.name.ids)) match {
                case Some(name) =>
                  val adTypeString = typeString(name)
                  val adTypeName = typeName(adTypeString)
                  val transformMethodCaseMemberST = stg.getInstanceOf("transformMethodCaseMember").
                    add("i", i).
                    add("typeName", adTypeName).
                    add("type", adTypeString).
                    add("fieldName", fieldName)
                  if (isImmutable && i != 0) transformMethodCaseMemberST.add("j", i - 1)
                  st.add("transformMethodCaseMember", transformMethodCaseMemberST)
                  addChangedUpdate(i, fieldName)
                  transformSpecific(name)
                  i += 1
                case _ =>
              }
          }
        case _ =>
          reporter.error(p.id.attr.posInfoOpt, s"Unsupported type for parameter ${p.id.value}")
      }
    }
    if (isImmutable && i != 0) st.add("i", i - 1)
  }

  def adtNameOpt(name: ISZ[SString], tipe: Type): Option[ISZ[SString]] = {
    tipe match {
      case tipe: Type.Named => adtNameOpt(name, Util.ids2strings(tipe.name.ids))
      case _ => None
    }
  }

  def adtNameOpt(name: ISZ[SString], ids: ISZ[SString]): Option[ISZ[SString]] = {
    findName(name, ids) match {
      case Some(adtName) => globalTypeMap.get(adtName) match {
        case SSome(ti: Resolver.AbstractDatatypeInfo) => Some(ti.name)
        case _ => None
      }
      case _ =>
        None
    }
  }

  def typeString(t: Type.Named): String = {
    typeString(Util.ids2strings(t.name.ids))
  }

  def typeString(ids: ISZ[SString]): String = {
    val typeName = ids.elements.mkString(".")
    if (typeName.startsWith(packagePrefix)) typeName.substring(packagePrefix.length)
    else typeName
  }

  def typeName(typeString: String): String =
    typeString.replaceAllLiterally(".", "")
}
