// #Sireum
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

package org.sireum.lang.symbol

import org.sireum._
import Resolver._
import org.sireum.lang.ast.Exp.Quant
import org.sireum.lang.ast.LClause.Sequent
import org.sireum.lang.ast.MTransformer.PreResult
import org.sireum.lang.ast._
import org.sireum.lang.util.Reporter

object SequentResolver {
  @datatype class QScope(nameMap: HashMap[String, Id],
                         outerOpt: Option[QScope]) {
    @pure def resolve(name: String): Option[Id] = {
      nameMap.get(name) match {
        case Some(id) => return Some(id)
        case _ =>
          outerOpt match {
            case Some(outer) => return outer.resolve(name)
            case _ => return None()
          }
      }
    }
  }

  @record class DeclResolver(var scope: QScope,
                             var freeVarMap: HashMap[String, (Id, Z)],
                             reporter: Reporter)
    extends MTransformer.PrePost {

    override def preExpQuant(o: Quant): MTransformer.PreResult[Exp] = {
      var newScope = QScope(HashMap.empty, Some(scope))

      for (vf <- o.varFragments) {
        vf.domainOpt match {
          case Some(domain) => reporter.error(domain.attr.posOpt, s"Predicate logic sequents cannot have quantified variable domains.")
          case _ =>
        }
        for (id <- vf.ids) {
          val key = id.value
          newScope.resolve(key) match {
            case Some(_) => reporter.error(id.attr.posOpt, s"$key has been previously declared.")
            case _ => up(newScope.nameMap) = newScope.nameMap.put(key, id)
          }
        }
      }
      scope = newScope
      return PreResult(T, MNone())
    }

    override def postExpQuant(o: Quant): MOption[Exp] = {
      scope.outerOpt match {
        case Some(outer) => scope = outer
        case _ => reporter.internalError(o.attr.posOpt, s"Unexpected scoping situation when resolving quantification.")
      }
      return MNone()
    }

    override def postExpInvoke(o: Exp.Invoke): MOption[Exp] = {
      val key = o.id.value
      scope.resolve(key) match {
        case Some(_) => reporter.error(o.id.attr.posOpt, s"Cannot use a quantified variable as a function.")
        case _ =>
          freeVarMap.get(key) match {
            case Some((id, _)) => freeVarMap = freeVarMap.put(key, (id, o.args.size))
            case _ => reporter.internalError(o.attr.posOpt, s"Unexpected unresolved function/predicate application.")
          }
      }
      return MNone()
    }

    override def preExpIdent(o: Exp.Ident): PreResult[Exp] = {
      val id = o.id
      val k = id.value
      scope.resolve(k) match {
        case Some(_) =>
        case _ =>
          freeVarMap.get(k) match {
            case Some(_) =>
            case _ => freeVarMap = freeVarMap.put(id.value, (id, 0))
          }
      }
      return PreResult(F, MNone())
    }
  }

  def resolveDecl(freeVarMap: HashMap[String, (Id, Z)],
                  reporter: Reporter,
                  e: Exp): HashMap[String, (Id, Z)] = {
    val dr = DeclResolver(QScope(HashMap.empty,  None()), freeVarMap, reporter)
    MTransformer(dr).transformExp(e)
    return dr.freeVarMap
  }

  def resolve(sequent: Sequent, reporter: Reporter): Unit = {
    var freeVarMap = HashMap.empty[String, (Id, Z)]
    for (e <- sequent.premises) {
      freeVarMap = resolveDecl(freeVarMap, reporter, e)
    }
    var conclusions = ISZ[Exp]()
    for (e <- sequent.conclusions) {
      freeVarMap = resolveDecl(freeVarMap, reporter, e)
    }
    // TODO: resolve proof
  }
}
