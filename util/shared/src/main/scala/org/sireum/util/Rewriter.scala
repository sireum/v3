/*
Copyright (c) 2011-2015, Robby, Kansas State University
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

package org.sireum.util

import scala.annotation.tailrec

object Rewriter {

  type ConstructorMap = IMap[String, Traversable[AnyRef] => Product]

  object TraversalMode extends Enum("TraversalMode") {
    type Type = Value
    val TOP_DOWN = Value("TOP_DOWN")
    val BOTTOM_UP = Value("BOTTOM_UP")
  }

  def all(f: RewriteFunction, g: RewriteFunction): RewriteFunction =
    new PartialFunction[Any, Any] {
      def isDefinedAt(o: Any) = true

      def apply(o: Any) = {
        val o1 = if (f.isDefinedAt(o)) f(o) else o
        if (g.isDefinedAt(o1)) g(o1) else o1
      }
    }

  def all(fs: ISeq[RewriteFunction]): RewriteFunction =
    new PartialFunction[Any, Any] {
      def isDefinedAt(o: Any) = true

      def apply(o: Any) = {
        var r = o
        for (f <- fs) {
          if (f.isDefinedAt(r))
            r = f(r)
        }
        r
      }
    }

  def build[T](m: ConstructorMap)(
    mode: TraversalMode.Type,
    f: RewriteFunction) = { x: T =>
    mode match {
      case TraversalMode.TOP_DOWN =>
        rewrite(m, Some({ _ => f }), None)(x)
      case TraversalMode.BOTTOM_UP =>
        rewrite(m, None, Some({ _ => f }))(x)
    }
  }

  def buildEnd[T](m: ConstructorMap)(
    mode: TraversalMode.Type,
    f: RewriteFunction,
    g: RewriteFunction) = { x: T =>
    mode match {
      case TraversalMode.TOP_DOWN =>
        rewrite(m, Some({ _ => f }), Some({ _ => g }))(x)
      case TraversalMode.BOTTOM_UP =>
        rewrite(m, None, Some({ _ => all(f, g) }))(x)
    }
  }

  import Visitor._

  private[util] trait ProductStackElement[T] {
    def newChildren: Array[Object]

    var isDirty: Boolean

    def makeWithNewChildren: T

    def newChild(i: Int, oPrevious: Any, o: Any) {
      isDirty = isDirty || !same(oPrevious, o)
      newChildren(i) = o.asInstanceOf[Object]
    }

    private def same(v1: Any, v2: Any): Boolean =
      (v1, v2) match {
        case (v1: Product2[_, _], v2: Product2[_, _]) =>
          same(v1._1, v2._1) && same(v1._2, v2._2)
        case (v1: AnyRef, v2: AnyRef) => v1 eq v2
        case _ => v1 == v2
      }
  }

  private[util] class
  RTraversableStackElement(value: scala.collection.Traversable[_],
                           alwaysCopy: Boolean,
                           r: Any => Any)
    extends TraversableStackElement(value)
    with ProductStackElement[scala.collection.Traversable[_]] {
    val newChildren = new Array[Object](value.size)
    var isDirty = alwaysCopy

    import scala.collection.generic.CanBuildFrom
    import scala.language.higherKinds

    def makeWithNewChildren =
      if (isDirty)
        value match {
          case m: ILinkedMap[_, _] =>
            makeHelperM(value.asInstanceOf[ILinkedMap[Any, Any]])
          case m: scala.collection.Map[_, _] =>
            makeHelperM(value.
              asInstanceOf[scala.collection.Map[Any, Any]])
          case t: IVector[_] =>
            makeHelperT(value.asInstanceOf[IVector[Any]])
          case _ =>
            makeHelperT(value.
              asInstanceOf[scala.collection.Traversable[Any]])
        }
      else value

    private def makeHelperT[CC[_] <: scala.collection.Traversable[Any]](t: CC[Any]) //
                                                                       (implicit cbf: CanBuildFrom[CC[Any], Any, CC[Any]]): CC[Any] = {
      val b = cbf(t)
      b.sizeHint(t.size)
      b ++= newChildren
      b.result()
    }

    private def makeHelperM[CC[V, W] <: scala.collection.Map[V, W]](t: CC[Any, Any]) //
                                                                   (implicit cbf: CanBuildFrom[CC[Any, Any], (Any, Any), CC[Any, Any]]): CC[Any, Any] = {
      val b = cbf(t)
      b.sizeHint(t.size)
      b ++= newChildren.map(_.asInstanceOf[(Any, Any)])
      b.result()
    }
  }

  private[util] class
  RProductStackElement(m: ConstructorMap,
                       override val value: Product,
                       alwaysCopy: Boolean)
    extends Visitor.ProductStackElement(value)
    with ProductStackElement[Product] {
    val newChildren = new Array[Object](value.productArity)
    var isDirty = alwaysCopy

    def makeWithNewChildren =
      if (isDirty)
        value match {
          case Some(_) => Some(newChildren(0))
          case (_, _) => (newChildren(0), newChildren(1))
          case (_, _, _) => (newChildren(0), newChildren(1), newChildren(3))
          case _ =>
            m(value.productPrefix)(newChildren)
        }
      else value
  }

  def rewrite[T](m: ConstructorMap,
                 fnPre: Option[VisitorStackProvider => RewriteFunction],
                 fnPost: Option[VisitorStackProvider => RewriteFunction],
                 alwaysCopy: Boolean = false)(o: T): T = {

    var _stack = ilistEmpty[VisitorStackElementRoot with ProductStackElement[_]]

    val vsp = new VisitorStackProvider {
      def stack = _stack
    }

    val (hasPre, f) =
      if (fnPre.isDefined) (true, fnPre.get(vsp)) else (false, null)
    val (hasPost, g) =
      if (fnPost.isDefined) (true, fnPost.get(vsp)) else (false, null)

    @inline
    def peek = _stack.head

    def pop = {
      val oldV = peek.value
      val v = peek.makeWithNewChildren
      val result =
        if (hasPost && g.isDefinedAt(v)) (oldV, g(v)) else (oldV, v)
      _stack = _stack.tail
      result
    }

    var result: Any = o

    @tailrec
    def isEmpty: Boolean = {
      if (_stack.isEmpty) true
      else if (_stack.head.hasNext)
        false
      else {
        val p = pop
        if (_stack.isEmpty) result = p._2
        else peek.newChild(peek.currIndex, p._1, p._2)
        isEmpty
      }
    }

    def rewriter(o: Any): Any = {
      def push(o: Any) {
        o match {
          case t: scala.collection.Traversable[_] =>
            _stack = new RTraversableStackElement(t, alwaysCopy, rewriter) :: _stack
          case v: Product =>
            _stack = new RProductStackElement(m, v, alwaysCopy) :: _stack
          case _ =>
        }
      }

      def add(n: Any) {
        val (shouldPush, r) =
          if (hasPre && f.isDefinedAt(n)) (false, f(n)) else (true, n)
        if (_stack.isEmpty) push(r)
        else {
          peek.newChild(peek.currIndex, n, r)
          if (shouldPush)
            push(r)
        }
      }

      add(o)
      while (!isEmpty)
        add(peek.next)
      result
    }

    rewriter(o).asInstanceOf[T]
  }
}