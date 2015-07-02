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

package org.sireum.java.meta

import org.sireum.util._

object MetaAnnotation {
  type Seq[T] = IVector[T]
}

sealed trait MetaAnnotation extends Product

sealed trait ArgValue extends MetaAnnotation

final case class Annotation(tipe: ObjectType, args: MetaAnnotation.Seq[Arg]) extends ArgValue

final case class Arg(name: String, value: ArgValue) extends MetaAnnotation

case object TrueValue extends ArgValue

case object FalseValue extends ArgValue

final case class ByteValue(value: Byte) extends ArgValue

final case class CharValue(value: Char) extends ArgValue

final case class ShortValue(value: Short) extends ArgValue

final case class IntValue(value: Int) extends ArgValue

final case class LongValue(value: Long) extends ArgValue

final case class FloatValue(value: Float) extends ArgValue

final case class DoubleValue(value: Double) extends ArgValue

final case class StringValue(value: String) extends ArgValue

final case class EnumValue(tipe: ObjectType,
                           value: String) extends ArgValue

final case class ArrayValue(elements: MetaAnnotation.Seq[ArgValue]) extends ArgValue
