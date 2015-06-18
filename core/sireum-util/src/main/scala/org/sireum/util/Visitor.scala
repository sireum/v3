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

trait Visitable {
  def getNumOfChildren: Int

  def getChildren: ISeq[AnyRef]
}

object Visitor {

  object TraversalMode extends Enum("TraversalMode") {
    type Type = Value
    final val TOP_DOWN = Value("TOP_DOWN")
    final val BOTTOM_UP = Value("BOTTON_UP")
  }

  def map(fs : ISeq[VisitorFunction],
          parallel : Boolean = false) : VisitorFunction = {
    case x : Any =>
      (if (parallel) fs.par else fs).
        map({ f => if (f isDefinedAt x) f(x) else true }).
        foldLeft(false)((x, y) => x || y)
  }

  def atMostOne(fs : ISeq[VisitorFunction],
                parallel : Boolean = false) : VisitorFunction = {
    case x : Any if (if (parallel) fs.par else fs).exists(_.isDefinedAt(x)) =>
      val rs = (if (parallel) fs.par else fs).
        map({ f => if (f isDefinedAt x) (true, f(x)) else (false, false) })
      var result = false
      var found = false
      for (r <- rs) {
        if (r._1) {
          assert(!found)
          found = true
          result = r._2
        }
      }
      result
  }

  def first(fs : ISeq[VisitorFunction],
            parallel : Boolean = false) : VisitorFunction = {
    case x : Any if (if (parallel) fs.par else fs).exists(_.isDefinedAt(x)) =>
      val size = fs.size
      var i = 0
      var found = false
      var result = false
      while (i < size && !found) {
        val f = fs(i)
        if (f.isDefinedAt(x)) {
          found = true
          result = f(x)
        }
        i += 1
      }
      result
  }

  def seq1(f : VisitorFunction, g : VisitorFunction) =
    new PartialFunction[Any, Boolean] {
      def isDefinedAt(o : Any) = f.isDefinedAt(o) || g.isDefinedAt(o)
      def apply(o : Any) = {
        val result = if (f.isDefinedAt(o)) f(o) else true
        if (g.isDefinedAt(o)) g(o)
        result
      }
    }

  def build(f : VisitorFunction,
            mode : TraversalMode.Type = TraversalMode.TOP_DOWN) =
    { x : Any =>
      mode match {
        case TraversalMode.TOP_DOWN  => visit(Some({ _ => f }))(x)
        case TraversalMode.BOTTOM_UP => visit(None, Some({ _ => f }))(x)
      }
    }

  def buildEnd(f : VisitorFunction, g : VisitorFunction,
               mode : TraversalMode.Type = TraversalMode.TOP_DOWN) =
    { x : Any =>
      mode match {
        case TraversalMode.TOP_DOWN  => visit(Some({ _ => f }), Some({ _ => g }))(x)
        case TraversalMode.BOTTOM_UP => visit(None, Some({ _ => seq1(f, g) }))(x)
      }
    }

  trait VisitorStackProvider {
    def stack : IList[VisitorStackElementRoot]
  }

  trait VisitorStackElement {
    def value : Any
  }

  private[util] abstract class VisitorStackElementRoot extends VisitorStackElement {
    def hasNext : Boolean
    def next : Any
    def nextIndex : Int
    def currIndex = nextIndex - 1
    override def toString = "[" + currIndex + ", " + value.toString + "]"
  }

  private[util] class TraversableStackElement(val value : scala.collection.Traversable[_])
      extends VisitorStackElementRoot {
    var nextIndex = 0
    var curr : Any = null
    val it = value.toIterator
    def hasNext = it.hasNext

    def next = {
      curr = it.next(); nextIndex += 1; curr
    }
  }

  private[util] class ProductStackElement(val value : Product)
      extends VisitorStackElementRoot {
    var nextIndex = 0
    var curr : Any = null
    def hasNext = nextIndex < value.productArity
    def next = { curr = value.productElement(nextIndex); nextIndex += 1; curr }
  }

  private[util] class VisitableStackElement(val value : Visitable)
      extends VisitorStackElementRoot {
    var nextIndex = 0
    var curr : Any = null
    val children = value.getChildren
    def hasNext = nextIndex < value.getNumOfChildren
    def next = { curr = children(nextIndex); nextIndex += 1; curr }
  }

  def visit(fnPre : Option[VisitorStackProvider => VisitorFunction],
            fnPost : Option[VisitorStackProvider => VisitorFunction] = None) //
            (o : Any) : Boolean = {
    var _stack = ilistEmpty[VisitorStackElementRoot]

    val vsp = new VisitorStackProvider {
      def stack = _stack
    }

    val (hasPre, f) =
      if (fnPre.isDefined) (true, fnPre.get(vsp)) else (false, null)
    val (hasPost, g) =
      if (fnPost.isDefined) (true, fnPost.get(vsp)) else (false, null)

    require(hasPre || hasPost)

      def push(o : Any) {
        o match {
          case t : scala.collection.Traversable[_] =>
            _stack = new TraversableStackElement(t) :: _stack
          case p : Product =>
            _stack = new ProductStackElement(p) :: _stack
          case v : Visitable =>
            _stack = new VisitableStackElement(v) :: _stack
          case _ =>
        }
      }

      @inline
      def peek = _stack.head

    def pop() {
        if (hasPost && g.isDefinedAt(peek.value))
          g(peek.value)
        _stack = _stack.tail
      }

      @tailrec
      def isEmpty : Boolean = {
        if (_stack.isEmpty) true
        else if (_stack.head.hasNext) false
        else {
          pop()
          isEmpty
        }
      }

    var result = true

      def add(n : Any) {
        if (hasPre && f.isDefinedAt(n)) {
          if (f(n))
            push(n)
          else result = false
        } else push(n)
      }

    add(o)
    while (!isEmpty)
      add(peek.next)
    result
  }
}