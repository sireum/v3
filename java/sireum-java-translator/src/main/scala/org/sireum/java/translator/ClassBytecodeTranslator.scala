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
import org.sireum.pilar.ast._
import org.sireum.util._

object ClassBytecodeTranslator {
  final val asmApi = Opcodes.ASM5

  def apply(bytecode: Array[Byte]): Model =
    apply(new ClassReader(bytecode))

  def apply(name: String): Model =
    apply(new ClassReader(name))

  def apply(cr: ClassReader): Model = {
    val cbt = new ClassBytecodeTranslator
    cr.accept(cbt, ClassReader.EXPAND_FRAMES)
    cbt.model()
  }

  def main(args: Array[String]): Unit = {
    println(ClassBytecodeTranslator("org.sireum.java.translator.ClassBytecodeTranslator"))
  }
}

import org.sireum.java.translator.ClassBytecodeTranslator._

final private class ClassBytecodeTranslator extends ClassVisitor(asmApi) {

  private var version: Int = _
  private var modifiers = ivectorEmpty[meta.Modifier.Type]
  private var name: String = _
  private var signatureOpt: Option[String] = None
  private var superNameOpt: Option[String] = None
  private var interfaces = ivectorEmpty[String]
  private var sourceOpt: Option[String] = None
  private var debugOpt: Option[String] = None
  private var outerClassOpt: Option[meta.OuterClass] = None
  private var annotations = ivectorEmpty[meta.EntityAnnotation]
  private var typeAnnotations = ivectorEmpty[meta.ClassTypeAnnotation]
  private var innerClasses = ivectorEmpty[meta.InnerClass]
  private var attributes = ivectorEmpty[meta.Attribute]

  def model(): Model =
    Model(
      ivectorEmpty,
      ivector(
        Annotation(Id("JavaClass"),
          ExtLit(
            meta.Class(
              version,
              modifiers,
              name,
              signatureOpt,
              superNameOpt,
              interfaces,
              sourceOpt,
              debugOpt,
              outerClassOpt,
              innerClasses,
              attributes)
          )
        )
      )
    )

  override def visitAttribute(attr: Attribute): Unit =
    attributes :+= attribute(attr)

  override def visitTypeAnnotation(typeRef: Int,
                                   typePath: TypePath,
                                   desc: String,
                                   visible: Boolean): AnnotationVisitor = {
    import AnnotationTranslator._
    stack = stack.push(E(false, marrayEmpty, { args =>
      val ea = meta.EntityAnnotation(meta.Annotation(fromDesc(desc),
        args.toVector.map(_.asInstanceOf[meta.Arg])), visible)
      val typePathOpt = Option(typePath).map(this.typePath)
      val ta =
        typeRef match {
          case TypeReference.CLASS_TYPE_PARAMETER =>
            meta.ClassTypeParameterAnnotation(typePathOpt, ea)
          case TypeReference.CLASS_TYPE_PARAMETER_BOUND =>
            meta.ClassTypeParameterBoundAnnotation(typePathOpt, ea)
          case TypeReference.CLASS_EXTENDS =>
            meta.ClassExtendsAnnotation(typePathOpt, ea)
        }
      typeAnnotations :+= ta
    }))
    AnnotationTranslator
  }

  override def visitField(access: Int,
                          name: String,
                          desc: String,
                          signature: String,
                          value: scala.Any): FieldVisitor =
    null // TODO: new FieldTranslator(access, name, desc, signature, value)

  override def visit(version: Int,
                     access: Int,
                     name: String,
                     signature: String,
                     superName: String,
                     interfaces: Array[String]): Unit = {
    this.version = version
    this.modifiers = mods(access)
    this.name = fromInternalName(name)
    signatureOpt = Option(signature).map(fromInternalName)
    this.superNameOpt = Option(superName).map(fromInternalName)
    this.interfaces =
      if (interfaces != null) ivectorEmpty[String]
      else interfaces.toVector.map(fromInternalName)
  }

  override def visitEnd(): Unit = {}

  override def visitSource(source: String, debug: String): Unit = {
    this.sourceOpt = Option(source)
    this.debugOpt = Option(debug)
  }

  override def visitMethod(access: Int,
                           name: String,
                           desc: String,
                           signature: String,
                           exceptions: Array[String]): MethodVisitor =
    null // TODO: new MethodTranslator(access, name, desc, signature, exceptions)

  override def visitAnnotation(desc: String,
                               visible: Boolean): AnnotationVisitor = {
    import AnnotationTranslator._
    stack = stack.push(E(false, marrayEmpty, { args =>
      annotations :+= meta.EntityAnnotation(meta.Annotation(fromDesc(desc),
        args.toVector.map(_.asInstanceOf[meta.Arg])), visible)
    }))
    AnnotationTranslator
  }

  override def visitInnerClass(name: String,
                               outerName: String,
                               innerName: String,
                               access: Int): Unit =
    innerClasses :+= meta.InnerClass(fromInternalName(name),
      Option(outerName).map(fromInternalName),
      Option(innerName).map(fromInternalName),
      mods(access))

  override def visitOuterClass(owner: String,
                               name: String,
                               desc: String): Unit = {
    val o = fromInternalName(owner)
    outerClassOpt = Some(
      if (name != null && desc != null)
        meta.OuterClass(o, Some((name, desc)))
      else
        meta.OuterClass(o, None))
  }

  private def typePath(tp: TypePath): meta.TypePath = {
    var steps = ivectorEmpty[meta.Step]
    val len = tp.getLength
    for (i <- 0 until len) {
      tp.getStep(i) match {
        case TypePath.ARRAY_ELEMENT =>
          steps :+= meta.ArrayElement
        case TypePath.INNER_TYPE =>
          steps :+= meta.InnerType
        case TypePath.TYPE_ARGUMENT =>
          steps :+= meta.TypeArgument(tp.getStepArgument(i))
        case TypePath.WILDCARD_BOUND =>
          steps :+= meta.WildcardBound
      }
    }
    meta.TypePath(steps)
  }

  @inline
  private def fromDesc(desc: String): String =
    descToType[meta.ObjectType](desc).name

  @inline
  private def descToType[T <: meta.Type](desc: String): T =
    typeToType[T](Type.getType(desc))

  @inline
  private def typeToType[T <: meta.Type](tipe: Type): T = {
    val t =
      tipe.getSort match {
        case Type.BOOLEAN => meta.BooleanType
        case Type.BYTE => meta.ByteType
        case Type.CHAR => meta.CharType
        case Type.SHORT => meta.ShortType
        case Type.INT => meta.IntType
        case Type.LONG => meta.LongType
        case Type.FLOAT => meta.FloatType
        case Type.DOUBLE => meta.DoubleType
        case Type.OBJECT => meta.ObjectType(tipe.getClassName)
        case Type.ARRAY => meta.ArrayType(typeToType(tipe.getElementType))
      }
    t.asInstanceOf[T]
  }

  @inline
  private def fromInternalName(n: String) = n.replaceAll("/", ".")

  private def mods(access: Int): IVector[meta.Modifier.Type] = {
    var r = ivectorEmpty[meta.Modifier.Type]
    import Opcodes._
    if ((access & ACC_ABSTRACT) != 0) r :+= meta.Modifier.Abstract
    if ((access & ACC_ANNOTATION) != 0) r :+= meta.Modifier.Annotation
    if ((access & ACC_BRIDGE) != 0) r :+= meta.Modifier.Bridge
    if ((access & ACC_DEPRECATED) != 0) r :+= meta.Modifier.Deprecated
    if ((access & ACC_ENUM) != 0) r :+= meta.Modifier.Enum
    if ((access & ACC_FINAL) != 0) r :+= meta.Modifier.Final
    if ((access & ACC_INTERFACE) != 0) r :+= meta.Modifier.Interface
    if ((access & ACC_MANDATED) != 0) r :+= meta.Modifier.Mandated
    if ((access & ACC_NATIVE) != 0) r :+= meta.Modifier.Native
    if ((access & ACC_PRIVATE) != 0) r :+= meta.Modifier.Private
    if ((access & ACC_PROTECTED) != 0) r :+= meta.Modifier.Protected
    if ((access & ACC_PUBLIC) != 0) r :+= meta.Modifier.Public
    if ((access & ACC_STATIC) != 0) r :+= meta.Modifier.Static
    if ((access & ACC_STRICT) != 0) r :+= meta.Modifier.Strict
    if ((access & ACC_SUPER) != 0) r :+= meta.Modifier.Super
    if ((access & ACC_SYNCHRONIZED) != 0) r :+= meta.Modifier.Synchronized
    if ((access & ACC_SYNTHETIC) != 0) r :+= meta.Modifier.Synthetic
    if ((access & ACC_TRANSIENT) != 0) r :+= meta.Modifier.Transient
    if ((access & ACC_VARARGS) != 0) r :+= meta.Modifier.VarArgs
    if ((access & ACC_VOLATILE) != 0) r :+= meta.Modifier.Volatile
    r
  }

  @inline
  private def attribute(a: Attribute): meta.Attribute = {
    for (f <- a.getClass.getDeclaredFields) {
      if (f.getType.isAssignableFrom(classOf[Array[Byte]])) {
        f.setAccessible(true)
        return meta.Attribute(
          a.`type`,
          f.get(a).asInstanceOf[Array[Byte]])
      }
    }
    sys.error("Could not retrieve attribute byte array")
  }

  private object AnnotationTranslator extends AnnotationVisitor(asmApi) {

    final case class E(isArray: Boolean,
                       args: MArray[AnyRef],
                       endFun: MArray[AnyRef] => Unit)

    final var stack: IStack[E] = istackEmpty

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
      addValue(name, meta.EnumValue(fromDesc(desc), value))

    final override def visitAnnotation(name: String,
                                       desc: String): AnnotationVisitor = {
      stack = stack.push(E(false, marrayEmpty, { args =>
        val v = meta.Annotation(fromDesc(desc),
          args.toVector.map(_.asInstanceOf[meta.Arg]))
        addValue(name, v)
      }))
      this
    }

    final def addValue(name: String, value: meta.ArgValue): Unit = {
      stack.top.args +=
        (if (stack.top.isArray) value else meta.Arg(name, value))
    }
  }

  private final class FieldTranslator(access: Int,
                                      name: String,
                                      desc: String,
                                      signature: String,
                                      value: scala.Any) extends FieldVisitor(asmApi) {
    override def visitAttribute(attr: Attribute): Unit = {
      ???
    }

    override def visitTypeAnnotation(typeRef: PosInteger, typePath: TypePath, desc: Uri, visible: Boolean): AnnotationVisitor = {
      ???
    }

    override def visitEnd(): Unit = {
      ???
    }

    override def visitAnnotation(desc: Uri, visible: Boolean): AnnotationVisitor = {
      ???
    }
  }

  private final class MethodTranslator(access: Int,
                                       name: String,
                                       desc: String,
                                       signature: String,
                                       exceptions: Array[String]) extends MethodVisitor(asmApi) {

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

}
