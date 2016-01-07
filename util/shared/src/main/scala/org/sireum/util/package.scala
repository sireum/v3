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

package org.sireum

package object util {
  type Integer = Int
  type Natural = Int
  type NaturalSentinel = Int
  type PosInteger = Int
  type CharSentinel = Int

  type Uri = String
  type FileResourceUri = Uri

  type --\[-D, +I] = PartialFunction[D, I]

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
  type MConcMap[K, V] = scala.collection.concurrent.Map[K, V]
  type MSet[T] = scala.collection.mutable.Set[T]
  type MLinkedSet[T] = scala.collection.mutable.LinkedHashSet[T]
  type MLinkedMap[K, V] = scala.collection.mutable.LinkedHashMap[K, V]
  type MIdSet[T] = MMap[T, T]
  type MStack[T] = scala.collection.mutable.Stack[T]

  val naturalSentinel: NaturalSentinel = -1

  @inline
  final def mbitsetEmpty(): MBitSet = scala.collection.mutable.BitSet.empty

  @inline
  final def mbitsetEmpty(size: Int): MBitSet = new scala.collection.mutable.BitSet(size)

  @inline
  final def marrayEmpty[T]: MArray[T] = scala.collection.mutable.ArrayBuffer.empty[T]

  @inline
  final def mlistEmpty[T]: MList[T] = scala.collection.mutable.ListBuffer.empty[T]

  @inline
  final def mmapEmpty[K, V]: MMap[K, V] = scala.collection.mutable.Map.empty[K, V]

  @inline
  final def midmapEmpty[K <: AnyRef, V]: MIdMap[K, V] = MIdMap[K, V]()

  @inline
  final def mlinkedSetEmpty[T]: MLinkedSet[T] = scala.collection.mutable.LinkedHashSet.empty[T]

  @inline
  final def mlinkedMapEmpty[K, V]: MLinkedMap[K, V] = scala.collection.mutable.LinkedHashMap.empty[K, V]

  @inline
  final def msetEmpty[T]: MSet[T] = scala.collection.mutable.Set.empty[T]

  @inline
  final def mstackEmpty[T]: MStack[T] = new scala.collection.mutable.Stack[T]

  type IBitSet = scala.collection.immutable.BitSet
  type ISeq[T] = scala.collection.immutable.Seq[T]
  type IVector[T] = scala.collection.immutable.Vector[T]
  type IList[T] = scala.collection.immutable.List[T]
  type IMap[K, V] = scala.collection.immutable.Map[K, V]
  type ILinkedMap[K, V] = scala.collection.immutable.ListMap[K, V]
  type ISortedMap[K, V] = scala.collection.immutable.SortedMap[K, V]
  type ISet[T] = scala.collection.immutable.Set[T]
  type ILinkedSet[T] = scala.collection.immutable.ListSet[T]
  type ISortedSet[T] = scala.collection.immutable.SortedSet[T]
  type IStack[T] = scala.collection.immutable.List[T]

  @inline
  final def ibitsetEmpty: IBitSet = scala.collection.immutable.BitSet.empty

  @inline
  final def ilistEmpty[T]: IList[T] = scala.collection.immutable.List.empty[T]

  @inline
  final def ilist[T](args: T*): IList[T] = List(args: _*)

  @inline
  final def ivectorEmpty[T]: IVector[T] = scala.collection.immutable.Vector.empty[T]

  @inline
  final def ivector[T](args: T*): IVector[T] = Vector(args: _*)

  @inline
  final def seq2ivect[T](seq: CSeq[T]): IVector[T] = {
    val vb = Vector.newBuilder[T]
    vb ++= seq
    vb.result()
  }

  @inline
  final def imapEmpty[K, V]: IMap[K, V] = scala.collection.immutable.Map.empty[K, V]

  @inline
  final def ilinkedMapEmpty[K, V]: ILinkedMap[K, V] = scala.collection.immutable.ListMap.empty[K, V]

  @inline
  final def ilinkedMap[K, V](ps: (K, V)*): ILinkedMap[K, V] = {
    var r = ilinkedMapEmpty[K, V]
    for (p <- ps)
      r = r + p
    r
  }

  @inline
  final def isortedMapEmpty[K, V](implicit ord: Ordering[K]): ISortedMap[K, V] = scala.collection.immutable.SortedMap.empty[K, V]

  @inline
  final def isetEmpty[T]: ISet[T] = scala.collection.immutable.Set.empty[T]

  @inline
  final def ilinkedSetEmpty[T]: ILinkedSet[T] = scala.collection.immutable.ListSet.empty[T]

  @inline
  final def isortedSetEmpty[T](implicit ord: Ordering[T]): ISortedSet[T] = scala.collection.immutable.SortedSet.empty[T]

  @inline
  final def istackEmpty[T]: IStack[T] = scala.collection.immutable.List.empty[T]

  @inline
  final def cintersect[T](s1: CSet[T], s2: CSet[T]) = s1.intersect(s2)

  @inline
  final def cunion[T](s1: CSet[T], s2: CSet[T]) = s1.union(s2)

  @inline
  final def bigCIntersect[T](it: Iterable[CSet[T]]): CSet[T] =
    it.size match {
      case 0 => Set()
      case 1 => it.iterator.next()
      case _ => it.reduce(cintersect[T])
    }

  @inline
  final def bigCUnion[T](it: Iterable[CSet[T]]): CSet[T] =
    it.size match {
      case 0 => Set()
      case 1 => it.iterator.next()
      case _ => it.reduce(cunion[T])
    }

  @inline
  final def iintersect[T](s1: ISet[T], s2: ISet[T]) = s1.intersect(s2)

  @inline
  final def iunion[T](s1: ISet[T], s2: ISet[T]) = s1.union(s2)

  @inline
  final def bigIIntersect[T](it: Iterable[ISet[T]]): ISet[T] =
    it.size match {
      case 0 => Set()
      case 1 => it.iterator.next()
      case _ => it.reduce(iintersect[T])
    }

  @inline
  final def bigIUnion[T](it: Iterable[ISet[T]]): ISet[T] =
    it.size match {
      case 0 => Set()
      case 1 => it.iterator.next()
      case _ => it.reduce(iunion[T])
    }

  trait IsBoolean {
    def asBoolean: Boolean

    override def equals(other: Any) =
      other match {
        case other: Boolean => this.asBoolean == other
        case other: IsBoolean => this.asBoolean == other.asBoolean
        case _ => false
      }

    override def hashCode = asBoolean.hashCode
  }

  final implicit class IStackPushPop[E](val l: IStack[E]) extends AnyVal {
    def pop(): (E, IStack[E]) = (l.head, l.tail)

    def push(e: E): IStack[E] = e :: l

    def top = l.head
  }

  object CompareResult extends Enum("Compare") {
    type Type = Value
    val LT = Value("LT")
    val EQ = Value("EQ")
    val GT = Value("GT")
  }

  @inline
  final def compareResult(n: Int): CompareResult.Type = n match {
    case -1 => CompareResult.LT
    case 0 => CompareResult.EQ
    case 1 => CompareResult.GT
    case _ =>
      if (n < 0) CompareResult.LT
      else CompareResult.GT
  }


  @inline
  final def cast[T](t: IVector[_]): IVector[T] = t.map(_.asInstanceOf[T])

  @inline
  final def cast[T](t: Option[_]): Option[T] = t.map(_.asInstanceOf[T])

  @inline
  final def cast[T1, T2](t: (_, _)): (T1, T2) =
    (t._1.asInstanceOf[T1], t._2.asInstanceOf[T2])

  @inline
  final def cast[T1, T2, T3](t: (_, _, _)): (T1, T2, T3) =
    (t._1.asInstanceOf[T1], t._2.asInstanceOf[T2], t._3.asInstanceOf[T3])

  final val sireumV3License =
    """Copyright (c) 2011-2015, Robby, Kansas State University
      |All rights reserved.
      |
      |Redistribution and use in source and binary forms, with or without
      |modification, are permitted provided that the following conditions are met:
      |
      |1. Redistributions of source code must retain the above copyright notice, this
      |   list of conditions and the following disclaimer.
      |2. Redistributions in binary form must reproduce the above copyright notice,
      |   this list of conditions and the following disclaimer in the documentation
      |   and/or other materials provided with the distribution.
      |
      |THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
      |ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
      |WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
      |DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
      |ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
      |(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
      |LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
      |ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
      |(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
      |SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
    """.stripMargin.trim
}
