/*
 Copyright (c) 2018, Robby, Kansas State University
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

package org.sireum.lang

import org.sireum._
import org.sireum.message._
import org.sireum.lang.symbol._
import org.sireum.lang.tipe._
import org.sireum.test.SireumSpec

class LibraryTypeCheckingTest extends SireumSpec {

  {

    implicit val _spec: SireumSpec = this

    * {
      val (tc, rep) = TypeChecker.libraryReporter
      rep.printMessages()
      assert(!rep.hasIssue)
      def nameInfo(th: TypeHierarchy, name: Predef.String): Resolver.NameMap = {
        val ids = ISZ(name.split('.').map(s => s: String): _*)
        return HashMap ++ ISZ((ids, th.nameMap.get(ids).get))
      }
      def typeInfo(th: TypeHierarchy, name: Predef.String): Resolver.TypeMap = {
        val ids = ISZ(name.split('.').map(s => s: String): _*)
        return HashMap ++ ISZ((ids, th.typeMap.get(ids).get))
      }
      val reporter = Reporter.create
      reporter.reports(rep.messages)
      val all = T
      val name = ""
      val nameMap: Resolver.NameMap = if (all) tc.typeHierarchy.nameMap else nameInfo(tc.typeHierarchy, name)
      val typeMap: Resolver.TypeMap = if (all) tc.typeHierarchy.typeMap else typeInfo(tc.typeHierarchy, name)
      val th = TypeChecker.checkComponents(tc.typeHierarchy, nameMap, typeMap, reporter)
      if (!reporter.hasError) {
        if (all) {
          PostTipeAttrChecker.checkNameTypeMaps(th.nameMap, th.typeMap, reporter)
        } else {
          PostTipeAttrChecker.checkNameTypeMaps(nameInfo(th, name), typeInfo(th, name), reporter)
        }
      }
      reporter.printMessages()
      !reporter.hasIssue
    }

  }
}
