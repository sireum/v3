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

package org.sireum.java.translator

import org.objectweb.asm._

import org.sireum.java._
import org.sireum.util._

object ClassBytecodeTranslator {
  final val asmApi = Opcodes.ASM5

}

import ClassBytecodeTranslator._

final class ClassBytecodeTranslator extends ClassVisitor(asmApi) {

  private object AnnotationTranslator extends AnnotationVisitor(asmApi) {

    final case class E(isArray: Boolean,
                       args: MArray[AnyRef],
                       endFun: MArray[AnyRef] => Unit)

    private final var stack: IStack[E] = istackEmpty

    final override def visitArray(name: String): AnnotationVisitor = {
      stack = stack.push(E(true, marrayEmpty, { args =>
        val v = meta.ArrayValue(
          args.toVector.map(_.asInstanceOf[meta.ArgValue]))
        addValue(name, v)
      }))
      this
    }

    final override def visit(name: String, value: Any): Unit = {
      def toArgValue(v: Any): meta.ArgValue =
        v match {
          case true => meta.TrueValue
          case false => meta.FalseValue
          case v: Byte => meta.ByteValue(v)
          case v: Char => meta.CharValue(v)
          case v: Short => meta.ShortValue(v)
          case v: Int => meta.IntValue(v)
          case v: Long => meta.LongValue(v)
          case v: Float => meta.FloatValue(v)
          case v: Double => meta.DoubleValue(v)
          case v: String => meta.StringValue(v)
          case v: Type => descToType(v.getDescriptor)
          case v: Array[Any] =>
            meta.ArrayValue(v.toVector.map(toArgValue))
        }
      addValue(name, toArgValue(value))
    }

    final override def visitEnd(): Unit = {
      val (E(_, args, f), s) = stack.pop()
      stack = s
      f(args)
    }

    final override def visitEnum(name: String,
                                 desc: String,
                                 value: String): Unit =
      addValue(name, meta.EnumValue(descToType(desc), value))

    final override def visitAnnotation(name: String,
                                       desc: String): AnnotationVisitor = {
      stack = stack.push(E(false, marrayEmpty, { args =>
        val v = meta.Annotation(descToType(desc),
          args.toVector.map(_.asInstanceOf[meta.Arg]))
        addValue(name, v)
      }))
      this
    }

    private def addValue(name: String, value: meta.ArgValue): Unit = {
      stack.top.args +=
        (if (stack.top.isArray) value else meta.Arg(name, value))
    }
  }

  private final class MethodTranslator extends MethodVisitor(asmApi) {
    override def visitLocalVariable(name: String,
                                    desc: String,
                                    signature: String,
                                    start: Label,
                                    end: Label,
                                    index: Int): Unit = ???

    override def visitAttribute(attr: Attribute): Unit = ???

    override def visitCode(): Unit = ???

    override def visitIincInsn(`var`: Int,
                               increment: Int): Unit = ???

    override def visitLdcInsn(cst: scala.Any): Unit = ???

    override def visitTypeAnnotation(typeRef: Int,
                                     typePath: TypePath,
                                     desc: String,
                                     visible: Boolean): AnnotationVisitor = {
      ???
      AnnotationTranslator
    }

    override def visitTableSwitchInsn(min: Int,
                                      max: Int,
                                      dflt: Label,
                                      labels: Label*): Unit = ???

    override def visitInsnAnnotation(typeRef: Int,
                                     typePath: TypePath,
                                     desc: String,
                                     visible: Boolean): AnnotationVisitor = {
      ???
      AnnotationTranslator
    }

    override def visitLookupSwitchInsn(dflt: Label,
                                       keys: Array[Int],
                                       labels: Array[Label]): Unit = ???

    override def visitIntInsn(opcode: Int, operand: Int): Unit = ???

    override def visitLineNumber(line: Int, start: Label): Unit = ???

    override def visitMultiANewArrayInsn(desc: String, dims: Int): Unit = ???

    override def visitFieldInsn(opcode: Int,
                                owner: String,
                                name: String,
                                desc: String): Unit = ???

    override def visitMethodInsn(opcode: Int,
                                 owner: String,
                                 name: String,
                                 desc: String,
                                 itf: Boolean): Unit = ???

    override def visitLocalVariableAnnotation(typeRef: Int,
                                              typePath: TypePath,
                                              start: Array[Label],
                                              end: Array[Label],
                                              index: Array[Int],
                                              desc: String,
                                              visible: Boolean): AnnotationVisitor = {
      ???
      AnnotationTranslator
    }

    override def visitJumpInsn(opcode: Int, label: Label): Unit = ???

    override def visitVarInsn(opcode: Int, `var`: Int): Unit = ???

    override def visitFrame(`type`: Int,
                            nLocal: Int,
                            local: Array[AnyRef],
                            nStack: Int,
                            stack: Array[AnyRef]): Unit = ???

    override def visitEnd(): Unit = ???

    override def visitParameter(name: String, access: Int): Unit = ???

    override def visitTypeInsn(opcode: Int, `type`: String): Unit = ???

    override def visitAnnotation(desc: String, visible: Boolean): AnnotationVisitor = {
      ???
      AnnotationTranslator
    }

    override def visitMaxs(maxStack: Int, maxLocals: Int): Unit = ???

    override def visitParameterAnnotation(parameter: Int,
                                          desc: String,
                                          visible: Boolean): AnnotationVisitor = {
      ???
      AnnotationTranslator
    }

    override def visitTryCatchAnnotation(typeRef: Int,
                                         typePath: TypePath,
                                         desc: String,
                                         visible: Boolean): AnnotationVisitor = {
      ???
      AnnotationTranslator
    }

    override def visitTryCatchBlock(start: Label,
                                    end: Label,
                                    handler: Label,
                                    `type`: String): Unit = ???

    override def visitAnnotationDefault(): AnnotationVisitor = {
      ???
      AnnotationTranslator
    }

    override def visitInsn(opcode: Int): Unit = ???

    override def visitInvokeDynamicInsn(name: String,
                                        desc: String,
                                        bsm: Handle,
                                        bsmArgs: AnyRef*): Unit = ???

    override def visitLabel(label: Label): Unit = ???
  }

  override def visitAttribute(attr: Attribute): Unit =
    ???

  override def visitTypeAnnotation(typeRef: Int,
                                   typePath: TypePath,
                                   desc: String,
                                   visible: Boolean): AnnotationVisitor = {
    ???
    AnnotationTranslator
  }

  override def visitField(access: Int,
                          name: String,
                          desc: String,
                          signature: String,
                          value: scala.Any): FieldVisitor = ???

  override def visit(version: Int,
                     access: Int,
                     name: String,
                     signature: String,
                     superName: String,
                     interfaces: Array[String]): Unit = ???

  override def visitEnd(): Unit = ???

  override def visitSource(source: String, debug: String): Unit = ???

  override def visitMethod(access: Int,
                           name: String,
                           desc: String,
                           signature: String,
                           exceptions: Array[String]): MethodVisitor = ???

  override def visitAnnotation(desc: String,
                               visible: Boolean): AnnotationVisitor = {
    ???
    AnnotationTranslator
  }

  override def visitInnerClass(name: String,
                               outerName: String,
                               innerName: String,
                               access: Int): Unit = ???

  override def visitOuterClass(owner: String,
                               name: String,
                               desc: String): Unit = ???

  private def descToType[T <: meta.Type](desc: String): T = ???
}
