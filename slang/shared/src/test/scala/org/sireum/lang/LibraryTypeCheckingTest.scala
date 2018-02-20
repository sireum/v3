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
      val bin = CustomMessagePack.fromTypeHierarchy(th)
      val Either.Left(th2) = CustomMessagePack.toTypeHierarchy(bin)
      assert(th == th2)
      //collectStats(th.nameMap, th.typeMap)
      reporter.printMessages()
      !reporter.hasIssue
    }

    /*
    def collectStats(os: Any*): Unit = {
      final case class Wrapper(o: Any) {
        override def hashCode: Int = o.hashCode

        override def equals(ow: Any): Boolean = {
          ow match {
            case Wrapper(other) => try o == other catch { case _: Throwable => false }
            case _ => false
          }
        }
      }
      val map = scala.collection.mutable.HashMap[Wrapper, Z]()
      def collect(o: Any): Unit = {
        o match {
          case o: Some[_] => collect(o.value); return
          case o: HashMap[_, _] => for (e <- o.entries) { collect(e._1); collect(e._2) }; return
          case o: Map[_, _] => for (e <- o.entries) { collect(e._1); collect(e._2) }; return
          case o: HashSMap[_, _] => for (e <- o.entries) { collect(e._1); collect(e._2) }; return
          case o: Set[_] => for (e <- o.elements) collect(e); return
          case o: HashSet[_] => for (e <- o.elements) collect(e); return
          case o: HashSSet[_] => for (e <- o.elements) collect(e); return
          case o: Bag[_] => for (e <- o.elements) collect(e); return
          case o: HashBag[_] => for (e <- o.elements) collect(e); return
          case o: Stack[_] => for (e <- o.elements) collect(e); return
          case o: Poset[_] => for (e <- o.nodes) collect(e); return
          case _: ZLike[_] | _: B  | _: C | _: F32 | _: F64 | _: R | _: String | _: None[_] => return
          case o: DatatypeSig => for (e <- o.$content.tail) collect(e._2)
          case o: RecordSig => for (e <- o.$content.tail) collect(e._2)
          case o: IS[_, _] => for (e <- o) collect(e); return
          case o: MS[_, _] => for (e <- o) collect(e); return
          case (o1, o2) => collect(o1); collect(o2); return
          case _: _root_.org.sireum.Immutable with _root_.scala.Ordered[_] => return
          case _ => println(s"Ignoring ${o.getClass}: $o"); return
        }
        val ow = Wrapper(o)
        map.put(ow, map.getOrElse[Z](ow, 0) + 1)
      }
      for (o <- os) {
        collect(o)
      }
      for (e <- map.toSeq.sortWith((p1, p2) => p1._2 > p2._2)) {
        println(s"${e._1.o.getClass.getName}: ${e._2}")
      }
    }
   */
  }
}
