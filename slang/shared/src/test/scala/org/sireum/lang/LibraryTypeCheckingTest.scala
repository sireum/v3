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
import org.sireum.lang.symbol._
import org.sireum.lang.tipe._
import org.sireum.lang.util.AccumulatingReporter
import org.sireum.test.SireumSpec

class LibraryTypeCheckingTest extends SireumSpec {

  {

    implicit val _spec: SireumSpec = this

    * {
      val (tc, rep) = TypeChecker.libraryReporter
      rep.printMessages()
      assert(!rep.hasIssue)
      def nameInfo(name: Predef.String): (ISZ[String], Resolver.Info) = {
        val ids = ISZ(name.split('.').map(s => s: String): _*)
        return (ids, tc.typeHierarchy.nameMap.get(ids).get)
      }
      def typeInfo(name: Predef.String): (ISZ[String], Resolver.TypeInfo) = {
        val ids = ISZ(name.split('.').map(s => s: String): _*)
        return (ids, tc.typeHierarchy.typeMap.get(ids).get)
      }
      val reporter = AccumulatingReporter.create
      reporter.reports(rep.messages)
      val all = T
      val name = ""
      val nameMap: Resolver.NameMap = if (all) tc.typeHierarchy.nameMap else HashMap ++ ISZ(nameInfo(name))
      val typeMap: Resolver.TypeMap = if (all) tc.typeHierarchy.typeMap else HashMap ++ ISZ(typeInfo(name))
      val th = TypeChecker.checkComponents(tc.typeHierarchy, nameMap, typeMap, reporter)
      PostTipeAttrChecker.checkNameTypeMaps(th.nameMap, th.typeMap, reporter)
      reporter.printMessages()
      !reporter.hasIssue
    }

  }
}
