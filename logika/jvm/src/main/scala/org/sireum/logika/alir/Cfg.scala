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

package org.sireum.logika.alir

import org.jgrapht.ext.DOTExporter
import org.jgrapht.graph.DefaultDirectedGraph
import org.sireum.logika.ast._
import org.sireum.util._

object Cfg {

  object Node {
    def apply(stmt: Stmt): StmtNode = StmtNode(stmt)

    def apply(label: String): VirtualNode = VirtualNode(None, label)

    def apply(md: MethodDecl, label: String): VirtualNode = VirtualNode(Some(md), label)

    def apply(mdOpt: Option[MethodDecl], label: String): VirtualNode = VirtualNode(mdOpt, label)

    def apply(ret: Return): ReturnNode = ReturnNode(ret)
  }

  sealed trait Node

  final case class VirtualNode private(mdOpt: Option[MethodDecl], label: String) extends Node

  final case class StmtNode private(stmt: Stmt) extends Node {
    override def hashCode: Int = System.identityHashCode(stmt)

    override def equals(other: Any): Boolean = hashCode == other.hashCode
  }

  final case class ReturnNode private(ret: Return) extends Node {
    override def hashCode: Int = System.identityHashCode(ret)

    override def equals(other: Any): Boolean = hashCode == other.hashCode
  }

  final class Edge(val label: String) {
    def this() {
      this("")
    }

    override def toString: String = label
  }

  def apply(md: MethodDecl): Cfg =
    build(Some(md), md.block)

  def apply(p: Program): Cfg =
    build(None, p.block)

  private def build(mdOpt: Option[MethodDecl], block: Block): Cfg =
    new CfgImpl(mdOpt).buildStart(block)
}

trait Cfg {
  val startNode: Cfg.VirtualNode
  val endNode: Cfg.VirtualNode

  def nodes: ISet[Cfg.Node]

  def succ(n: Cfg.Node): ISet[Cfg.Node]

  def pred(n: Cfg.Node): ISet[Cfg.Node]

  def succs(n: Cfg.Node): ISet[Cfg.Node]

  def preds(n: Cfg.Node): ISet[Cfg.Node]

  def unreachableNodes: ISet[Cfg.Node]

  def toDotString(unitNode: UnitNode): String
}

private final class CfgImpl(mdOpt: Option[MethodDecl]) extends Cfg {
  override val startNode = Cfg.Node(mdOpt, "start")
  override val endNode = Cfg.Node(mdOpt, "end")

  var frozen = false
  var nodes: ISet[Cfg.Node] = isetEmpty

  val graph = new DefaultDirectedGraph[Cfg.Node, Cfg.Edge](classOf[Cfg.Edge])
  var nodeMap: MIdMap[AnyRef, Cfg.Node] = midmapEmpty

  def node(stmt: Stmt): Cfg.StmtNode = nodeMap.getOrElseUpdate(stmt, {
    require(!frozen)
    val r = Cfg.Node(stmt)
    graph.addVertex(r)
    r
  }).asInstanceOf[Cfg.StmtNode]

  def node(b: Block): Cfg.ReturnNode = {
    require(b.returnOpt.isDefined)
    nodeMap.getOrElseUpdate(b, {
      require(!frozen)
      val r = Cfg.Node(b.returnOpt.get)
      graph.addVertex(r)
      r
    }).asInstanceOf[Cfg.ReturnNode]
  }

  def succ(n: Cfg.Node): ISet[Cfg.Node] = {
    import scala.collection.JavaConverters._
    var r = isetEmpty[Cfg.Node]
    r ++= graph.outgoingEdgesOf(n).asScala.map(graph.getEdgeTarget)
    r
  }

  def pred(n: Cfg.Node): ISet[Cfg.Node] = {
    import scala.collection.JavaConverters._
    var r = isetEmpty[Cfg.Node]
    r ++= graph.incomingEdgesOf(n).asScala.map(graph.getEdgeSource)
    r
  }

  def unreachableNodes: ISet[Cfg.Node] = nodes - startNode - endNode -- succs(startNode)

  def succs(n: Cfg.Node): ISet[Cfg.Node] = closure(n, succ)

  def preds(n: Cfg.Node): ISet[Cfg.Node] = closure(n, pred)

  override def toDotString(unitNode: UnitNode): String = {
    val dotExporter = new DOTExporter[Cfg.Node, Cfg.Edge](
      v => nodeName(isID = true, unitNode, v),
      v => nodeName(isID = false, unitNode, v),
      e => e.label)
    val sw = new java.io.StringWriter
    dotExporter.exportGraph(graph, sw)
    sw.toString
  }


  private def closure(n: Cfg.Node, f: Cfg.Node => ISet[Cfg.Node]): ISet[Cfg.Node] = {
    var r = f(n)
    var stable = false
    while (!stable) {
      val size = r.size
      r ++= r.flatMap(f)
      stable = size == r.size
    }
    r
  }

  def buildStart(n: Block): this.type = {
    graph.addVertex(startNode)
    graph.addVertex(endNode)
    Visitor.build({
      case n: Block if n.returnOpt.isDefined =>
        node(n)
        true
      case n: Stmt =>
        node(n)
        true
    })(n)
    build(startNode, n, endNode)
    removeIfEndNodes()
    frozen = true
    nodes += startNode
    import scala.collection.JavaConverters._
    for (node <- graph.vertexSet.asScala) {
      nodes += node
    }
    nodes += endNode
    this
  }

  private def removeIfEndNodes() = {
    import scala.collection.JavaConverters._
    for (stmt@If(_, _, _) <- nodeMap.keys) {
      val ifEnd = ifEndNode(stmt)
      for (predEdge <- graph.incomingEdgesOf(ifEnd).asScala;
           succEdge <- graph.outgoingEdgesOf(ifEnd).asScala) {
        graph.addEdge(graph.getEdgeSource(predEdge), graph.getEdgeTarget(succEdge))
      }
      graph.removeVertex(ifEnd)
    }
  }

  private def nodeName(isID: Boolean, unitNode: UnitNode, n: Cfg.Node): String = n match {
    case n: Cfg.StmtNode =>
      val li = unitNode.nodeLocMap(n.stmt)
      s"L${li.lineBegin}"
    case n: Cfg.VirtualNode =>
      val unitName = n.mdOpt match {
        case Some(md) => md.id.value
        case _ => "program"
      }
      val r = s"$unitName.${n.label}"
      if (isID) '"' + r + '"' else r
    case n: Cfg.ReturnNode =>
      n.ret.expOpt match {
        case Some(e) =>
          val r = s"return ${Exp.toString(e, inProof = false)}"
          if (isID) '"' + r + '"' else r
        case _ => "return"
      }
  }

  private def ifEndNode(stmt: If): Cfg.VirtualNode =
    Cfg.VirtualNode(None, System.identityHashCode(stmt).toString)

  private def build(pred: Cfg.Node, n: Block, succ: Cfg.Node): Unit = {
    var prev = pred
    for (stmt <- n.stmts) if (!stmt.isInstanceOf[MethodDecl]) {
      val node = Cfg.Node(stmt)
      graph.addEdge(prev, node)
      stmt match {
        case stmt: If =>
          val ifEnd = ifEndNode(stmt)
          graph.addVertex(ifEnd)
          build(node, stmt.trueBlock, ifEnd)
          build(node, stmt.falseBlock, ifEnd)
          prev = ifEnd
        case stmt: While =>
          build(node, stmt.block, node)
          prev = node
        case _ =>
          prev = node
      }
    }
    n.returnOpt match {
      case Some(_) =>
        val r = node(n)
        graph.addEdge(prev, r)
        graph.addEdge(r, endNode)
      case None =>
        graph.addEdge(prev, succ)
    }
  }
}
