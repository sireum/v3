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

package org.sireum.awas.ftpc

import org.sireum.awas.ast.Model
import org.sireum.awas.graph.{AwasEdge, AwasGraph}
import org.sireum.awas.ast._
import org.sireum.util._
import scalax.collection.mutable.Graph

/**
  * Created by hariharan on 1/26/16.
  */
trait FptcGraph[Node] extends AwasGraph[Node]


object FptcGraph {
  type GNode = AwasGraphNode
  type GEdge = AwasEdge[GNode]

  def apply(m: Model): FptcGraph[GNode] = {
    val printer = PrettyPrinter

    val result = new Fg[GNode]()

    var compMap = imapEmpty[String, Node]


    Visitor.build({
      case cp : ComponentDecl => {
        //todo
      }
        false
    })(m)

    result
  }

  private class Fg[Node] extends FptcGraph[Node] {
    val graph = Graph[Node, AwasEdge]()
  }
}


final case class AwasGraphNode(node : Node)