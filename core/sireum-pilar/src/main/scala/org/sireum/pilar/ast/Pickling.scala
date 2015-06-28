/*
Copyright (c) 2015, Robby, Kansas State University
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

package org.sireum.pilar.ast

import org.sireum.util._
import upickle.Js

object Pickling {
  final val locField = ".loc"

  def pickle(node: Node): String = {
    val jsObj = Json.from(node)
    val o =
      node match {
        case node: Model if node.nodeLocMap.nonEmpty =>
          val m = node.nodeLocMap
          var locInfos = ivectorEmpty[Js.Arr]
          Visitor.build({
            case n: Node =>
              val info =
                m.get(n) match {
                  case Some(li) => org.sireum.util.Json.fromLocationInfo(li)
                  case _ => Js.Arr()
                }
              locInfos = locInfos :+ info
              true
          })(node)
          Js.Obj(jsObj.value :+(locField, Js.Arr(locInfos: _*)): _*)
        case _ => jsObj
      }
    upickle.json.write(o)
  }

  def unpickle[T <: Node](s: String): T = {
    val (v, locInfos) =
      upickle.json.read(s) match {
        case o: Js.Obj if
        o.value.last._1 == locField &&
          o.value.head._2.asInstanceOf[Js.Str].value == "Model" =>
          val a = o.value.last._2.asInstanceOf[Js.Arr]
          (Js.Obj(o.value.dropRight(1): _*),
            a.value.map(org.sireum.util.Json.toLocationInfo))
        case o => (o, ivectorEmpty)
      }
    Json.to[T](v) match {
      case m: Model if locInfos.nonEmpty =>
        var i = 0
        val nodeLocMap = MIdMap[Node, LocationInfo]()
        Visitor.build({
          case n: Node =>
            locInfos(i).foreach(nodeLocMap(n) = _)
            i += 1
            true
        })(m)
        m.nodeLocMap = nodeLocMap
        m.asInstanceOf[T]
      case n => n
    }
  }
}
