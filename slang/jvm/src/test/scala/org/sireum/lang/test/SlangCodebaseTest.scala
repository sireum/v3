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

package org.sireum.lang.test

import org.sireum._
import org.sireum.lang.symbol._
import org.sireum.lang.tipe._
import org.sireum.test.SireumSpec

class SlangCodebaseTest extends SireumSpec {

  *("Slang") {
    val (initNameMap, initTypeMap) = Resolver.addBuiltIns(HashMap.empty, HashMap.empty)
    val (reporter, _, nameMap, typeMap) = Resolver.parseProgramAndGloballyResolve(
      ISZ((org.sireum.Library_Ext.map.toSeq ++ org.sireum.lang.$SlangFiles.map.toSeq).
        map(p => (Some(String(p._1.mkString("/"))), String(p._2))): _*),
      initNameMap, initTypeMap)
    def report(): Boolean = {
      if (reporter.hasIssue) {
        reporter.printMessages()
        assert(F)
        return false
      }
      true
    }
    report()
    val th = TypeHierarchy.build(TypeHierarchy(nameMap, typeMap, Poset.empty, HashMap.empty), reporter)
    report()
    val thOutlined = TypeOutliner.checkOutline(th, reporter)
    val tc = TypeChecker(thOutlined, ISZ(), F)
    for (ti <- tc.typeMap.values) {
      ti match {
        case ti: TypeInfo.Sig =>
          if (!ti.outlined) {
            reporter.error(None(), "", st"Type ${(ti.name, ".")} is not outlined!".render)
          }
        case ti: TypeInfo.AbstractDatatype =>
          if (!ti.outlined) {
            reporter.error(None(), "", st"Type ${(ti.name, ".")} is not outlined!".render)
          }
        case _ =>
      }
    }
    for (info <- tc.nameMap.values) {
      info match {
        case info: Info.Var =>
          if (!info.outlined) {
            reporter.error(None(), "", st"Var ${(info.name, ".")} is not outlined!".render)
          }
        case info: Info.SpecVar =>
          if (!info.outlined) {
            reporter.error(None(), "", st"Spec var ${(info.name, ".")} is not outlined!".render)
          }
        case info: Info.Method =>
          if (!info.outlined) {
            reporter.error(None(), "", st"Method ${(info.name, ".")} is not outlined!".render)
          }
        case info: Info.SpecMethod =>
          if (!info.outlined) {
            reporter.error(None(), "", st"Spec method ${(info.name, ".")} is not outlined!".render)
          }
        case info: Info.ExtMethod =>
          if (!info.outlined) {
            reporter.error(None(), "", st"@ext object method ${(info.name, ".")} is not outlined!".render)
          }
        case _ =>
      }
    }
    report()
  }

}
