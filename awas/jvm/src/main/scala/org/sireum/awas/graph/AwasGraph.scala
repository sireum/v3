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

package org.sireum.awas.graph

import scalax.collection.mutable.Graph
import scalax.collection.GraphEdge._
import scalax.collection.GraphPredef._

/**
  * Created by hariharan on 1/27/16.
  */
trait AwasGraph[Node] {
  type Edge = AwasEdge[Node]

  def numOfNodes : Int = graph.nodes.size

  def nodes = graph.nodes

  def edges = graph.edges

  def hasEdge(n1 : Node, n2: Node) : Boolean = {
    val edge  = new AwasEdge[Node](this,(n1,n2))
    graph.find(graph.having(node = _ == edge)).isDefined
  }

  def numOfEdges : Int = graph.edges.size

  def hasNode(n : Node): Boolean = graph.find(n).isDefined

  def getNode(n : Node)  = {
    graph.get(n)
  }

  def addNode (node : Node) : Node ={
    graph.add(node)
    node
  }

  def addEdge (nodes : Product2[Node, Node]) = {
    val edge = new AwasEdge[Node](this, nodes)
    graph.add(edge)
    edge
  }

  protected def graph : Graph[Node, AwasEdge]

}

final class AwasEdge[Node](nodes : Product)
  extends DiEdge[Node](nodes)
  with EdgeCopy[AwasEdge]
  with OuterEdge[Node, AwasEdge] {
  override def copy[NodeNode](newNodes: Product) =
    new AwasEdge[NodeNode](newNodes)
}

object AwasEdge extends EdgeCompanion[AwasEdge] {
  val ~> = AwasEdge

  def apply[Node](from: Node, to: Node):AwasEdge[Node] = new AwasEdge[Node](NodeProduct(from, to))

//  protected[Collection]
  def from [Node](nodes : Product) = new AwasEdge[Node](nodes)

  def apply[Node](nodes: Product2[Node, Node]):AwasEdge[Node] = new AwasEdge[Node](nodes)

  def unapply[Node](e: AwasEdge[Node]):Option[(Node, Node)] = if (e eq null) None else Some((e.source, e.target))
}


