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
import org.sireum.lang.symbol.Resolver
import org.sireum.lang.tipe._
import org.sireum.test.SireumSpec

class SlangCodebaseTest extends SireumSpec {

  *("Slang") {
    val (initNameMap, initTypeMap) = Resolver.addBuiltIns(HashMap.empty, HashMap.empty)
    val (reporter, nameMap, typeMap) = Resolver.parseProgramAndGloballyResolve(
      ISZ((org.sireum.$SlangFiles.map.toSeq ++ org.sireum.lang.$SlangFiles.map.toSeq).
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
    val tc = TypeChecker(thOutlined)
    for (ti <- tc.typeMap.values) {
      ti match {
        case ti: Resolver.TypeInfo.Sig => assert(ti.outlined, st"Type ${(ti.name, ".")} is not outlined!".render)
        case ti: Resolver.TypeInfo.AbstractDatatype => assert(ti.outlined, st"Type ${(ti.name, ".")} is not outlined!".render)
        case _ =>
      }
    }
    for (info <- tc.nameMap.values) {
      info match {
        case info: Resolver.Info.Var => assert(info.outlined, st"Var ${(info.name, ".")} is not outlined!".render)
        case info: Resolver.Info.SpecVar => assert(info.outlined, st"Spec var ${(info.name, ".")} is not outlined!".render)
        case info: Resolver.Info.Method => assert(info.outlined, st"Method ${(info.name, ".")} is not outlined!".render)
        case info: Resolver.Info.SpecMethod => assert(info.outlined, st"Spec method ${(info.name, ".")} is not outlined!".render)
        case _ =>
      }
    }
    report()
  }

}
