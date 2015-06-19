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

package org.sireum

package object util {
  type --\[D, I] = PartialFunction[D, I]

  type Uri = String

  type VisitorFunction = Any --\ Boolean
  type RewriteFunction = Any --\ Any

  type CSeq[T] = scala.collection.Seq[T]
  type CMap[K, V] = scala.collection.Map[K, V]
  type CSet[T] = scala.collection.Set[T]

  type GenSeq[T] = scala.collection.GenSeq[T]

  type MSeq[T] = scala.collection.mutable.Seq[T]
  type MBitSet = scala.collection.mutable.BitSet
  type MBuffer[T] = scala.collection.mutable.Buffer[T]
  type MArray[T] = scala.collection.mutable.ArrayBuffer[T]
  type MList[T] = scala.collection.mutable.ListBuffer[T]
  type MMap[K, V] = scala.collection.mutable.Map[K, V]
  type MIdMap[K, V] = MMap[K, V]
  type MConcMap[K, V] = scala.collection.concurrent.Map[K, V]
  type MSet[T] = scala.collection.mutable.Set[T]
  type MLinkedSet[T] = scala.collection.mutable.LinkedHashSet[T]
  type MLinkedMap[K, V] = scala.collection.mutable.LinkedHashMap[K, V]
  type MIdSet[T] = MMap[T, T]
  type MStack[T] = scala.collection.mutable.Stack[T]

  @inline
  def mbitsetEmpty() : MBitSet = scala.collection.mutable.BitSet.empty

  @inline
  def mbitsetEmpty(size : Int) : MBitSet = new scala.collection.mutable.BitSet(size)

  @inline
  def marrayEmpty[T] : MArray[T] = scala.collection.mutable.ArrayBuffer.empty[T]

  @inline
  def mlistEmpty[T] : MList[T] = scala.collection.mutable.ListBuffer.empty[T]

  @inline
  def mmapEmpty[K, V] : MMap[K, V] = scala.collection.mutable.Map.empty[K, V]

  @inline
  def mlinkedSetEmpty[T] : MLinkedSet[T] = scala.collection.mutable.LinkedHashSet.empty[T]

  @inline
  def mlinkedMapEmpty[K, V] : MLinkedMap[K, V] = scala.collection.mutable.LinkedHashMap.empty[K, V]

  @inline
  def msetEmpty[T] : MSet[T] = scala.collection.mutable.Set.empty[T]

  @inline
  def mstackEmpty[T]: MStack[T] = new scala.collection.mutable.Stack[T]

  type IBitSet = scala.collection.immutable.BitSet
  type ISeq[T] = scala.collection.immutable.Seq[T]
  type IVector[T] = scala.collection.immutable.Vector[T]
  type IList[T] = scala.collection.immutable.List[T]
  type IMap[K, V] = scala.collection.immutable.Map[K, V]
  type ILinkedMap[K, V] = scala.collection.immutable.ListMap[K, V]
  type ISortedMap[K, V] = scala.collection.immutable.SortedMap[K, V]
  type ISet[T] = scala.collection.immutable.Set[T]
  type ISortedSet[T] = scala.collection.immutable.SortedSet[T]
  type IStack[T] = scala.collection.immutable.List[T]

  @inline
  def ibitsetEmpty : IBitSet = scala.collection.immutable.BitSet.empty

  @inline
  def ilistEmpty[T] : IList[T] = scala.collection.immutable.List.empty[T]

  @inline
  def ilist[T](args : T*) : IList[T] = List(args : _*)

  @inline
  def ivectorEmpty[T] : IVector[T] = scala.collection.immutable.Vector.empty[T]

  @inline
  def ivector[T](args : T*) : IVector[T] = Vector(args : _*)

  @inline
  def seq2ivect[T](seq : CSeq[T]) : IVector[T] = {
    val vb = Vector.newBuilder[T]
    vb ++= seq
    vb.result()
  }

  @inline
  def imapEmpty[K, V] : IMap[K, V] = scala.collection.immutable.Map.empty[K, V]

  @inline
  def ilinkedMapEmpty[K, V] : ILinkedMap[K, V] = scala.collection.immutable.ListMap.empty[K, V]

  @inline
  def ilinkedMap[K, V](ps : (K, V)*) : ILinkedMap[K, V] = {
    var r = ilinkedMapEmpty[K, V]
    for (p <- ps)
      r = r + p
    r
  }

  @inline
  def isortedMapEmpty[K, V](implicit ord: Ordering[K]): ISortedMap[K, V] = scala.collection.immutable.SortedMap.empty[K, V]

  @inline
  def isetEmpty[T] : ISet[T] = scala.collection.immutable.Set.empty[T]

  @inline
  def isortedSetEmpty[T](implicit ord: Ordering[T]): ISortedSet[T] = scala.collection.immutable.SortedSet.empty[T]

  @inline
  def istackEmpty[T] : IStack[T] = scala.collection.immutable.List.empty[T]

  @inline
  def cintersect[T](s1 : CSet[T], s2 : CSet[T]) = s1.intersect(s2)

  @inline
  def cunion[T](s1 : CSet[T], s2 : CSet[T]) = s1.union(s2)

  @inline
  def bigCIntersect[T](it : Iterable[CSet[T]]) : CSet[T] =
    it.size match {
      case 0 => Set()
      case 1 => it.iterator.next()
      case _ => it.reduce(cintersect[T])
    }

  @inline
  def bigCUnion[T](it : Iterable[CSet[T]]) : CSet[T] =
    it.size match {
      case 0 => Set()
      case 1 => it.iterator.next()
      case _ => it.reduce(cunion[T])
    }

  @inline
  def iintersect[T](s1 : ISet[T], s2 : ISet[T]) = s1.intersect(s2)

  @inline
  def iunion[T](s1 : ISet[T], s2 : ISet[T]) = s1.union(s2)

  @inline
  def bigIIntersect[T](it : Iterable[ISet[T]]) : ISet[T] =
    it.size match {
      case 0 => Set()
      case 1 => it.iterator.next()
      case _ => it.reduce(iintersect[T])
    }

  @inline
  def bigIUnion[T](it : Iterable[ISet[T]]) : ISet[T] =
    it.size match {
      case 0 => Set()
      case 1 => it.iterator.next()
      case _ => it.reduce(iunion[T])
    }

  trait IsBoolean {
    def asBoolean : Boolean

    override def equals(other : Any) =
      other match {
        case other : Boolean   => this.asBoolean == other
        case other : IsBoolean => this.asBoolean == other.asBoolean
        case _                 => false
      }

    override def hashCode = asBoolean.hashCode
  }

  implicit class IStackPushPop[E](val l : IStack[E]) extends AnyVal {
    def pop() : (E, IStack[E]) = (l.head, l.tail)
    def push(e : E) : IStack[E] = e::l
  }


  @inline
  def cast[T](t: IVector[_]): IVector[T] = t.map(_.asInstanceOf[T])

  @inline
  def cast[T](t: Option[_]): Option[T] = t.map(_.asInstanceOf[T])

  @inline
  def cast[T1, T2](t: (_, _)): (T1, T2) =
    (t._1.asInstanceOf[T1], t._2.asInstanceOf[T2])

  @inline
  def cast[T1, T2, T3](t: (_, _, _)): (T1, T2, T3) =
    (t._1.asInstanceOf[T1], t._2.asInstanceOf[T2], t._3.asInstanceOf[T3])
}
