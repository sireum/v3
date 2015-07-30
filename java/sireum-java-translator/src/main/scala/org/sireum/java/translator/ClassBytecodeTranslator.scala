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

  final def apply(bytecode: Array[Byte]): Model =
    apply(new ClassReader(bytecode))

  final def apply(name: String): Model =
    apply(new ClassReader(name))

  final def apply(cr: ClassReader): Model = {
    val cbt = new ClassBytecodeTranslator
    cr.accept(cbt, ClassReader.EXPAND_FRAMES)
    cbt.model()
  }

  def main(args: Array[String]): Unit = {
    val model = ClassBytecodeTranslator("org.sireum.java.translator.ClassBytecodeTranslator")
    println(PrettyPrinter(model))
  }
}

import org.sireum.java.JavaProfile._
import org.sireum.java.translator.ClassBytecodeTranslator._

final private class ClassBytecodeTranslator extends ClassVisitor(asmApi) {

  private var version: Int = _
  private var modifiers = ivectorEmpty[meta.ClassModifier.Type]
  private var className: String = _
  private var signatureOpt: Option[String] = None
  private var superNameOpt: Option[String] = None
  private var interfaces = ivectorEmpty[String]
  private var sourceOpt: Option[String] = None
  private var debugOpt: Option[String] = None
  private var outerClassOpt: Option[meta.OuterClass] = None
  private var annotations = ivectorEmpty[meta.EntityAnnotation]
  private var typeAnnotations = ivectorEmpty[meta.ClassTypeAnnotation]
  private var attributes = ivectorEmpty[meta.Attribute]
  private var innerClasses = ivectorEmpty[meta.InnerClass]
  private var fields = ivectorEmpty[meta.Field]
  private var globalVarDecls = ivectorEmpty[GlobalVarDecl]

  def model(): Model =
    Model(
      globalVarDecls,
      ivector(
        Annotation(Id(annotationClassDesc),
          ExtLit(
            meta.Class(
              version,
              modifiers,
              className,
              signatureOpt,
              superNameOpt,
              interfaces,
              sourceOpt,
              debugOpt,
              outerClassOpt,
              annotations,
              typeAnnotations,
              attributes,
              innerClasses,
              fields)
          )
        )
      )
    )

  override def visitAttribute(attr: Attribute): Unit =
    attributes :+= attribute(attr)

  override def visitTypeAnnotation(typeRef: Int,
                                   tp: TypePath,
                                   desc: String,
                                   visible: Boolean): AnnotationVisitor = {
    import AnnotationTranslator._
    stack = stack.push(E(false, marrayEmpty, { args =>
      val ea = meta.EntityAnnotation(meta.Annotation(fromDesc(desc),
        args.toVector.map(_.asInstanceOf[meta.Arg])), visible)
      val typePathOpt = Option(tp).map(typePath)
      val ta =
        typeRef match {
          case TypeReference.CLASS_TYPE_PARAMETER =>
            meta.ClassTypeParameterTypeAnnotation(typePathOpt, ea)
          case TypeReference.CLASS_TYPE_PARAMETER_BOUND =>
            meta.ClassTypeParameterBoundTypeAnnotation(typePathOpt, ea)
          case TypeReference.CLASS_EXTENDS =>
            meta.ClassExtendsTypeAnnotation(typePathOpt, ea)
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
    new FieldTranslator(access, name, desc, signature, value)

  override def visit(version: Int,
                     access: Int,
                     className: String,
                     signature: String,
                     superName: String,
                     interfaces: Array[String]): Unit = {
    this.version = version
    this.modifiers = classModifiers(access)
    this.className = fromInternalName(className)
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
  /* TODO:  new JSRInlinerAdapter(
      new MethodTranslator(access, name, desc, signature, exceptions),
      access, name, desc, signature, exceptions) */
    null

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
      classModifiers(access))

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

  private def classModifiers(access: Int): IVector[meta.ClassModifier.Type] = {
    var r = ivectorEmpty[meta.ClassModifier.Type]
    import Opcodes._
    if ((access & ACC_ABSTRACT) != 0) r :+= meta.ClassModifier.Abstract
    if ((access & ACC_ANNOTATION) != 0) r :+= meta.ClassModifier.Annotation
    if ((access & ACC_DEPRECATED) != 0) r :+= meta.ClassModifier.Deprecated
    if ((access & ACC_ENUM) != 0) r :+= meta.ClassModifier.Enum
    if ((access & ACC_FINAL) != 0) r :+= meta.ClassModifier.Final
    if ((access & ACC_INTERFACE) != 0) r :+= meta.ClassModifier.Interface
    if ((access & ACC_PRIVATE) != 0) r :+= meta.ClassModifier.Private
    if ((access & ACC_PROTECTED) != 0) r :+= meta.ClassModifier.Protected
    if ((access & ACC_PUBLIC) != 0) r :+= meta.ClassModifier.Public
    if ((access & ACC_SUPER) != 0) r :+= meta.ClassModifier.Super
    if ((access & ACC_SYNTHETIC) != 0) r :+= meta.ClassModifier.Synthetic
    r
  }

  private def methodModifiers(access: Int): IVector[meta.MethodModifier.Type] = {
    var r = ivectorEmpty[meta.MethodModifier.Type]
    import Opcodes._
    if ((access & ACC_ABSTRACT) != 0) r :+= meta.MethodModifier.Abstract
    if ((access & ACC_BRIDGE) != 0) r :+= meta.MethodModifier.Bridge
    if ((access & ACC_DEPRECATED) != 0) r :+= meta.MethodModifier.Deprecated
    if ((access & ACC_FINAL) != 0) r :+= meta.MethodModifier.Final
    if ((access & ACC_NATIVE) != 0) r :+= meta.MethodModifier.Native
    if ((access & ACC_PRIVATE) != 0) r :+= meta.MethodModifier.Private
    if ((access & ACC_PROTECTED) != 0) r :+= meta.MethodModifier.Protected
    if ((access & ACC_PUBLIC) != 0) r :+= meta.MethodModifier.Public
    if ((access & ACC_STATIC) != 0) r :+= meta.MethodModifier.Static
    if ((access & ACC_STRICT) != 0) r :+= meta.MethodModifier.Strict
    if ((access & ACC_SYNCHRONIZED) != 0) r :+= meta.MethodModifier.Synchronized
    if ((access & ACC_SYNTHETIC) != 0) r :+= meta.MethodModifier.Synthetic
    if ((access & ACC_VARARGS) != 0) r :+= meta.MethodModifier.VarArgs
    r
  }


  private def fieldModifiers(access: Int): IVector[meta.FieldModifier.Type] = {
    var r = ivectorEmpty[meta.FieldModifier.Type]
    import Opcodes._
    if ((access & ACC_DEPRECATED) != 0) r :+= meta.FieldModifier.Deprecated
    if ((access & ACC_ENUM) != 0) r :+= meta.FieldModifier.Enum
    if ((access & ACC_FINAL) != 0) r :+= meta.FieldModifier.Final
    if ((access & ACC_PRIVATE) != 0) r :+= meta.FieldModifier.Private
    if ((access & ACC_PROTECTED) != 0) r :+= meta.FieldModifier.Protected
    if ((access & ACC_PUBLIC) != 0) r :+= meta.FieldModifier.Public
    if ((access & ACC_STATIC) != 0) r :+= meta.FieldModifier.Static
    if ((access & ACC_SYNTHETIC) != 0) r :+= meta.FieldModifier.Synthetic
    if ((access & ACC_TRANSIENT) != 0) r :+= meta.FieldModifier.Transient
    if ((access & ACC_VOLATILE) != 0) r :+= meta.FieldModifier.Volatile
    r
  }


  private def parameterModifiers(access: Int): IVector[meta.ParameterModifier.Type] = {
    var r = ivectorEmpty[meta.ParameterModifier.Type]
    import Opcodes._
    if ((access & ACC_FINAL) != 0) r :+= meta.ParameterModifier.Final
    if ((access & ACC_MANDATED) != 0) r :+= meta.ParameterModifier.Mandated
    if ((access & ACC_SYNTHETIC) != 0) r :+= meta.ParameterModifier.Synthetic
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

    final case class E(noName: Boolean,
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
        (if (stack.top.noName) value else meta.Arg(name, value))
    }
  }

  private final class FieldTranslator(access: Int,
                                      fieldName: String,
                                      desc: String,
                                      signature: String,
                                      value: scala.Any) extends FieldVisitor(asmApi) {
    private var annotations = ivectorEmpty[meta.EntityAnnotation]
    private var typeAnnotations = ivectorEmpty[meta.FieldTypeAnnotation]
    private var attributes = ivectorEmpty[meta.Attribute]

    override def visitAttribute(attr: Attribute): Unit =
      attributes :+= attribute(attr)

    override def visitTypeAnnotation(typeRef: Int,
                                     tp: TypePath,
                                     desc: Uri,
                                     visible: Boolean): AnnotationVisitor = {
      import AnnotationTranslator._
      stack = stack.push(E(false, marrayEmpty, { args =>
        val ea = meta.EntityAnnotation(meta.Annotation(fromDesc(desc),
          args.toVector.map(_.asInstanceOf[meta.Arg])), visible)
        val typePathOpt = Option(tp).map(typePath)
        val ta =
          typeRef match {
            case TypeReference.FIELD =>
              meta.FieldTypeAnnotation(typePathOpt, ea)
          }
        typeAnnotations :+= ta
      }))
      AnnotationTranslator
    }

    override def visitEnd(): Unit = {
      val modifiers = fieldModifiers(access)
      fields :+=
        meta.Field(
          modifiers,
          fieldName,
          descToType(desc),
          Option(signature),
          Option(value).map(initValue),
          annotations,
          typeAnnotations,
          attributes
        )
      if (modifiers.contains(meta.FieldModifier.Static)) {
        globalVarDecls :+= GlobalVarDecl(Id(s"$className.$fieldName"))
      }
    }

    override def visitAnnotation(desc: Uri, visible: Boolean): AnnotationVisitor = {
      import AnnotationTranslator._
      stack = stack.push(E(false, marrayEmpty, { args =>
        annotations :+= meta.EntityAnnotation(meta.Annotation(fromDesc(desc),
          args.toVector.map(_.asInstanceOf[meta.Arg])), visible)
      }))
      AnnotationTranslator
    }

    private def initValue(value: Any): meta.InitValue =
      value match {
        case value: Int => meta.IntValue(value)
        case value: Long => meta.LongValue(value)
        case value: Float => meta.FloatValue(value)
        case value: Double => meta.DoubleValue(value)
        case value: String => meta.StringValue(value)
      }
  }

  private final class MethodTranslator(access: Int,
                                       methodName: String,
                                       desc: String,
                                       signature: String,
                                       exceptions: Array[String]) extends MethodVisitor(asmApi) {

    private var paramNameModifiers = ivectorEmpty[(Option[String], IVector[meta.ParameterModifier.Type])]
    private val paramAnnotations = mmapEmpty[Int, IVector[meta.EntityAnnotation]].
      withDefault(ivectorEmpty)
    private var annotationDefaultOpt: Option[meta.Annotation] = None
    private var annotations = ivectorEmpty[meta.EntityAnnotation]
    private var typeAnnotations = ivectorEmpty[meta.MethodTypeAnnotation]
    private var attributes = ivectorEmpty[meta.Attribute]
    private var hasCode = false
    private var labelCounter = 0
    private val labelToNameMap = mmapEmpty[Label, String]
    private var blocks = ilinkedMapEmpty[String, MArray[Command]]
    private var currentName: String = null
    private var currentBlock: MArray[Command] = null
    private val varStack = mstackEmpty[(String, meta.Type)]
    private var maxLocalSlots = 0
    private var maxStackSlots = 0
    private var maxTempVar = 0

    override def visitLocalVariable(name: String,
                                    desc: String,
                                    signature: String,
                                    start: Label,
                                    end: Label,
                                    index: Int): Unit = ???

    override def visitAttribute(attr: Attribute): Unit =
      attributes :+= attribute(attr)

    override def visitCode(): Unit = {
      hasCode = true
    }

    override def visitIincInsn(`var`: Int,
                               increment: Int): Unit = ???

    override def visitLdcInsn(cst: scala.Any): Unit = ???

    override def visitTypeAnnotation(typeRef: Int,
                                     tp: TypePath,
                                     desc: String,
                                     visible: Boolean): AnnotationVisitor = {
      import AnnotationTranslator._
      stack = stack.push(E(false, marrayEmpty, { args =>
        val ea = meta.EntityAnnotation(meta.Annotation(fromDesc(desc),
          args.toVector.map(_.asInstanceOf[meta.Arg])), visible)
        val typePathOpt = Option(tp).map(typePath)
        val ta =
          typeRef match {
            case TypeReference.METHOD_TYPE_PARAMETER =>
              meta.MethodTypeParameterTypeAnnotation(typePathOpt, ea)
            case TypeReference.METHOD_TYPE_PARAMETER_BOUND =>
              meta.MethodTypeParameterBoundTypeAnnotation(typePathOpt, ea)
            case TypeReference.METHOD_RETURN =>
              meta.MethodReturnTypeAnnotation(typePathOpt, ea)
            case TypeReference.METHOD_RECEIVER =>
              meta.MethodReceiverTypeAnnotation(typePathOpt, ea)
            case TypeReference.METHOD_FORMAL_PARAMETER =>
              meta.MethodFormalParameterTypeAnnotation(typePathOpt, ea)
            case TypeReference.THROWS =>
              meta.ThrowsTypeAnnotation(typePathOpt, ea)
          }
        typeAnnotations :+= ta
      }))
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

    override def visitParameter(name: String, access: Int): Unit =
      paramNameModifiers :+=(Option(name), parameterModifiers(access))

    override def visitTypeInsn(opcode: Int, `type`: String): Unit = ???

    override def visitAnnotation(desc: String, visible: Boolean): AnnotationVisitor = {
      import AnnotationTranslator._
      stack = stack.push(E(false, marrayEmpty, { args =>
        annotations :+= meta.EntityAnnotation(meta.Annotation(fromDesc(desc),
          args.toVector.map(_.asInstanceOf[meta.Arg])), visible)
      }))
      AnnotationTranslator
    }

    override def visitMaxs(maxStack: Int, maxLocals: Int): Unit = {
      maxLocalSlots = maxLocals
      maxStackSlots = maxStack
    }

    override def visitParameterAnnotation(parameter: Int,
                                          desc: String,
                                          visible: Boolean): AnnotationVisitor = {
      import AnnotationTranslator._
      stack = stack.push(E(false, marrayEmpty, { args =>
        val a = meta.EntityAnnotation(meta.Annotation(fromDesc(desc),
          args.toVector.map(_.asInstanceOf[meta.Arg])), visible)
        paramAnnotations(parameter) = paramAnnotations(parameter) :+ a
      }))
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
      import AnnotationTranslator._
      stack = stack.push(E(true, marrayEmpty, { args =>
        annotationDefaultOpt =
          Some(meta.Annotation(fromDesc(desc),
            ivector(meta.Arg("value",
              args.head.asInstanceOf[meta.ArgValue]))))
      }))
      AnnotationTranslator
    }

    override def visitInsn(opcode: Int): Unit = {
      def arrayLoad(tipe: meta.Type): Unit = {
        splitBlock()
        val (index, indexType) = varStack.pop()
        val (array, arrayType) = varStack.pop()
        assert(isIntType(indexType) && isObjectType(arrayType))
        val t = tempVar()
        command(
          AssignAction(
            IdExp(Id(t)),
            ExtExp(IdExp(Id(array)), ivector(
              IdExp(Id(index)),
              typeLit(tipe)))
          )
        )
        varStack.push((t, tipe))
      }

      def arrayStore(valueTypeCheck: meta.Type => Boolean,
                     tipe: meta.Type): Unit = {
        splitBlock()
        val (value, valueType) = varStack.pop()
        val (index, indexType) = varStack.pop()
        val (array, arrayType) = varStack.pop()
        assert(isIntType(indexType) && isObjectType(arrayType) &&
          valueTypeCheck(valueType))
        command(
          AssignAction(
            ExtExp(IdExp(Id(array)), ivector(
              IdExp(Id(index)),
              typeLit(tipe))),
            IdExp(Id(value))
          )
        )
      }

      def returnJump(argCheck: meta.Type => Boolean, tipe: meta.Type) = {
        val (t, tipe2) = varStack.pop()
        assert(argCheck(tipe2))
        command(ReturnJump(Some(IdExp(Id(t))),
          ivector(Annotation(Id(annotationTypeDesc), typeLit(tipe).lit))))
      }

      opcode match {
        case Opcodes.NOP => // skip
        case Opcodes.ACONST_NULL =>
          val t = tempVar()
          command(
            AssignAction(
              IdExp(Id(t)),
              ExtExp(IdExp(Id("null")), ivectorEmpty)))
          varStack.push((t, topType))
        case Opcodes.ICONST_M1 => const(intDesc, -1, meta.IntType)
        case Opcodes.ICONST_0 => const(intDesc, 0, meta.IntType)
        case Opcodes.ICONST_1 => const(intDesc, 1, meta.IntType)
        case Opcodes.ICONST_2 => const(intDesc, 2, meta.IntType)
        case Opcodes.ICONST_3 => const(intDesc, 3, meta.IntType)
        case Opcodes.ICONST_4 => const(intDesc, 4, meta.IntType)
        case Opcodes.ICONST_5 => const(intDesc, 5, meta.IntType)
        case Opcodes.LCONST_0 => const(longDesc, 0l, meta.LongType)
        case Opcodes.LCONST_1 => const(longDesc, 1l, meta.LongType)
        case Opcodes.FCONST_0 => const(floatDesc, 0.0f, meta.FloatType)
        case Opcodes.FCONST_1 => const(floatDesc, 1.0f, meta.FloatType)
        case Opcodes.FCONST_2 => const(floatDesc, 2.0f, meta.FloatType)
        case Opcodes.DCONST_0 => const(doubleDesc, 0.0d, meta.DoubleType)
        case Opcodes.DCONST_1 => const(doubleDesc, 1.0d, meta.DoubleType)
        case Opcodes.IALOAD => arrayLoad(meta.IntType)
        case Opcodes.LALOAD => arrayLoad(meta.LongType)
        case Opcodes.FALOAD => arrayLoad(meta.FloatType)
        case Opcodes.DALOAD => arrayLoad(meta.DoubleType)
        case Opcodes.AALOAD => arrayLoad(topType)
        case Opcodes.BALOAD => arrayLoad(meta.ByteType)
        case Opcodes.CALOAD => arrayLoad(meta.CharType)
        case Opcodes.SALOAD => arrayLoad(meta.ShortType)
        case Opcodes.IASTORE => arrayStore(isIntType, meta.IntType)
        case Opcodes.LASTORE => arrayStore(isLongType, meta.LongType)
        case Opcodes.FASTORE => arrayStore(isFloatType, meta.FloatType)
        case Opcodes.DASTORE => arrayStore(isDoubleType, meta.DoubleType)
        case Opcodes.AASTORE => arrayStore(isObjectType, topType)
        case Opcodes.BASTORE => arrayStore(isIntType, meta.ByteType)
        case Opcodes.CASTORE => arrayStore(isIntType, meta.CharType)
        case Opcodes.SASTORE => arrayStore(isIntType, meta.ShortType)
        case Opcodes.POP => varStack.pop()
        case Opcodes.POP2 =>
          val (_, tipe) = varStack.pop()
          if (isSingleWord(tipe)) varStack.pop()
        case Opcodes.DUP =>
          val p@(_, tipe) = varStack.top
          assert(isSingleWord(tipe))
          varStack.push(p)
        case Opcodes.DUP_X1 =>
          val p1@(_, tipe1) = varStack.pop()
          val p2@(_, tipe2) = varStack.pop()
          assert(isSingleWord(tipe1) && isSingleWord(tipe2))
          varStack.push(p1)
          varStack.push(p2)
          varStack.push(p1)
        case Opcodes.DUP_X2 =>
          val p1@(_, tipe1) = varStack.pop()
          assert(isSingleWord(tipe1))
          val p2@(_, tipe2) = varStack.pop()
          if (isSingleWord(tipe2)) {
            val p3 = varStack.pop()
            varStack.push(p1)
            varStack.push(p3)
            varStack.push(p2)
            varStack.push(p1)
          } else {
            varStack.push(p1)
            varStack.push(p2)
            varStack.push(p1)
          }
        case Opcodes.DUP2 =>
          val p1@(_, tipe1) = varStack.pop()
          if (isSingleWord(tipe1)) {
            val p2 = varStack.pop()
            varStack.push(p2)
            varStack.push(p1)
            varStack.push(p2)
            varStack.push(p1)
          } else {
            varStack.push(p1)
          }
        case Opcodes.DUP2_X1 =>
          val p1@(_, tipe1) = varStack.pop()
          if (isSingleWord(tipe1)) {
            val p2 = varStack.pop()
            val p3@(_, tipe3) = varStack.pop()
            assert(isSingleWord(tipe3))
            varStack.push(p2)
            varStack.push(p1)
            varStack.push(p3)
            varStack.push(p2)
            varStack.push(p1)
          } else {
            val p2@(_, tipe2) = varStack.pop()
            assert(isSingleWord(tipe2))
            varStack.push(p1)
            varStack.push(p2)
            varStack.push(p1)
          }
        case Opcodes.DUP2_X2 =>
          val p1@(_, tipe1) = varStack.pop()
          if (isSingleWord(tipe1)) {
            val p2 = varStack.pop()
            val p3@(_, tipe3) = varStack.pop()
            if (isSingleWord(tipe3)) {
              val p4 = varStack.pop()
              varStack.push(p2)
              varStack.push(p1)
              varStack.push(p4)
              varStack.push(p3)
              varStack.push(p2)
              varStack.push(p1)
            } else {
              varStack.push(p2)
              varStack.push(p1)
              varStack.push(p3)
              varStack.push(p2)
              varStack.push(p1)
            }
          } else {
            val p2@(_, tipe2) = varStack.pop()
            if (isSingleWord(tipe2)) {
              val p3 = varStack.pop()
              varStack.push(p1)
              varStack.push(p3)
              varStack.push(p2)
              varStack.push(p1)
            } else {
              varStack.push(p1)
              varStack.push(p2)
              varStack.push(p1)
            }
          }
        case Opcodes.SWAP =>
          val p1@(_, tipe1) = varStack.pop()
          val p2@(_, tipe2) = varStack.pop()
          assert(isSingleWord(tipe1) && isSingleWord(tipe2))
          varStack.push(p1)
          varStack.push(p2)
        case Opcodes.IADD => binop(iaddOp, isIntType, isIntType, meta.IntType)
        case Opcodes.LADD => binop(laddOp, isLongType, isLongType, meta.LongType)
        case Opcodes.FADD => binop(faddOp, isFloatType, isFloatType, meta.FloatType)
        case Opcodes.DADD => binop(daddOp, isDoubleType, isDoubleType, meta.DoubleType)
        case Opcodes.ISUB => binop(isubOp, isIntType, isIntType, meta.IntType)
        case Opcodes.LSUB => binop(lsubOp, isLongType, isLongType, meta.LongType)
        case Opcodes.FSUB => binop(fsubOp, isFloatType, isFloatType, meta.FloatType)
        case Opcodes.DSUB => binop(dsubOp, isDoubleType, isDoubleType, meta.DoubleType)
        case Opcodes.IMUL => binop(imulOp, isIntType, isIntType, meta.IntType)
        case Opcodes.LMUL => binop(lmulOp, isLongType, isLongType, meta.LongType)
        case Opcodes.FMUL => binop(fmulOp, isFloatType, isFloatType, meta.FloatType)
        case Opcodes.DMUL => binop(dmulOp, isDoubleType, isDoubleType, meta.DoubleType)
        case Opcodes.IDIV => binop(idivOp, isIntType, isIntType, meta.IntType)
        case Opcodes.LDIV => binop(ldivOp, isLongType, isLongType, meta.LongType)
        case Opcodes.FDIV => binop(fdivOp, isFloatType, isFloatType, meta.FloatType)
        case Opcodes.DDIV => binop(ddivOp, isDoubleType, isDoubleType, meta.DoubleType)
        case Opcodes.IREM => binop(iremOp, isIntType, isIntType, meta.IntType)
        case Opcodes.LREM => binop(lremOp, isLongType, isLongType, meta.LongType)
        case Opcodes.FREM => binop(fremOp, isFloatType, isFloatType, meta.FloatType)
        case Opcodes.DREM => binop(dremOp, isDoubleType, isDoubleType, meta.DoubleType)
        case Opcodes.INEG => unop(inegOp, isIntType, meta.IntType)
        case Opcodes.LNEG => unop(lnegOp, isLongType, meta.LongType)
        case Opcodes.FNEG => unop(fnegOp, isFloatType, meta.FloatType)
        case Opcodes.DNEG => unop(dnegOp, isDoubleType, meta.DoubleType)
        case Opcodes.ISHL => binop(ishlOp, isIntType, isIntType, meta.IntType)
        case Opcodes.LSHL => binop(lshlOp, isLongType, isIntType, meta.LongType)
        case Opcodes.ISHR => binop(ishrOp, isIntType, isIntType, meta.IntType)
        case Opcodes.LSHR => binop(lshrOp, isLongType, isIntType, meta.LongType)
        case Opcodes.IUSHR => binop(iushrOp, isIntType, isIntType, meta.IntType)
        case Opcodes.LUSHR => binop(lushrOp, isLongType, isIntType, meta.LongType)
        case Opcodes.IAND => binop(iandOp, isIntType, isIntType, meta.IntType)
        case Opcodes.LAND => binop(landOp, isLongType, isLongType, meta.LongType)
        case Opcodes.IOR => binop(iorOp, isIntType, isIntType, meta.IntType)
        case Opcodes.LOR => binop(lorOp, isLongType, isLongType, meta.LongType)
        case Opcodes.IXOR => binop(ixorOp, isIntType, isIntType, meta.IntType)
        case Opcodes.LXOR => binop(lxorOp, isLongType, isLongType, meta.LongType)
        case Opcodes.I2L => unop(i2lOp, isIntType, meta.LongType)
        case Opcodes.I2F => unop(i2fOp, isIntType, meta.FloatType)
        case Opcodes.I2D => unop(i2dOp, isIntType, meta.DoubleType)
        case Opcodes.L2I => unop(l2iOp, isLongType, meta.IntType)
        case Opcodes.L2F => unop(l2fOp, isLongType, meta.FloatType)
        case Opcodes.L2D => unop(l2dOp, isLongType, meta.DoubleType)
        case Opcodes.F2I => unop(f2iOp, isFloatType, meta.IntType)
        case Opcodes.F2L => unop(f2lOp, isFloatType, meta.LongType)
        case Opcodes.F2D => unop(f2dOp, isFloatType, meta.DoubleType)
        case Opcodes.D2I => unop(d2iOp, isDoubleType, meta.IntType)
        case Opcodes.D2L => unop(d2lOp, isDoubleType, meta.LongType)
        case Opcodes.D2F => unop(d2fOp, isDoubleType, meta.FloatType)
        case Opcodes.I2B => unop(i2bOp, isIntType, meta.ByteType)
        case Opcodes.I2C => unop(i2cOp, isIntType, meta.CharType)
        case Opcodes.I2S => unop(i2sOp, isIntType, meta.ShortType)
        case Opcodes.LCMP => binop(lcmpOp, isLongType, isLongType, meta.IntType)
        case Opcodes.FCMPL => binop(fcmplOp, isFloatType, isFloatType, meta.IntType)
        case Opcodes.FCMPG => binop(fcmpgOp, isFloatType, isFloatType, meta.IntType)
        case Opcodes.DCMPL => binop(dcmplOp, isDoubleType, isDoubleType, meta.IntType)
        case Opcodes.DCMPG => binop(dcmpgOp, isDoubleType, isDoubleType, meta.IntType)
        case Opcodes.IRETURN => returnJump(isIntType, meta.IntType)
        case Opcodes.LRETURN => returnJump(isLongType, meta.LongType)
        case Opcodes.FRETURN => returnJump(isFloatType, meta.FloatType)
        case Opcodes.DRETURN => returnJump(isDoubleType, meta.DoubleType)
        case Opcodes.ARETURN => returnJump(isObjectType, topType)
        case Opcodes.RETURN =>
          assert(varStack.isEmpty)
          command(ReturnJump(None, ivectorEmpty))
        case Opcodes.ARRAYLENGTH => unop(arrayLengthOp, isObjectType, meta.IntType)
        case Opcodes.ATHROW =>
          val (t, tipe) = varStack.pop()
          assert(isObjectType(tipe))
          command(ExtJump(Id(throwOp), ivector(IdExp(Id(t)))))
        case Opcodes.MONITORENTER =>
          splitBlock()
          val (t, tipe) = varStack.pop()
          assert(isObjectType(tipe))
          command(ExtAction(Id(monitorEnterOp), ivector(IdExp(Id(t)))))
        case Opcodes.MONITOREXIT =>
          splitBlock()
          val (t, tipe) = varStack.pop()
          assert(isObjectType(tipe))
          command(ExtAction(Id(monitorExitOp), ivector(IdExp(Id(t)))))
      }
    }

    override def visitInvokeDynamicInsn(name: String,
                                        desc: String,
                                        bsm: Handle,
                                        bsmArgs: AnyRef*): Unit = ???

    override def visitLabel(label: Label): Unit =
      newBlock(labelName(label))

    private def tempVar(): String = {
      val n = varStack.size
      if (n > maxTempVar) maxTempVar = n
      s"$tempVarPrefix$n"
    }

    private def splitBlock(): Unit = {
      val oldBlock = currentBlock
      val ln = newLabelName()
      newBlock(ln)
      oldBlock += GotoJump(Id(ln), ivectorEmpty)
    }

    private def newBlock(labelName: String): Unit = {
      currentName = labelName
      currentBlock = marrayEmpty[Command]
      blocks = blocks + (currentName -> currentBlock)
    }

    private def const(id: String, n: AnyVal, tipe: meta.Type): Unit = {
      val t = tempVar()
      command(
        AssignAction(
          IdExp(Id(t)),
          LiteralExp(Id(id), RawLit(n.toString))))
      varStack.push((t, tipe))
    }

    private def unop(op: String,
                     argTypeCheck: meta.Type => Boolean,
                     tipe: meta.Type): Unit = {
      val (t1, tipe1) = varStack.pop()
      assert(argTypeCheck(tipe1))
      val t = tempVar()
      command(
        AssignAction(
          IdExp(Id(t)),
          ExtExp(
            IdExp(Id(op)),
            ivector(IdExp(Id(t1))))))
      varStack.push((t, tipe))
    }

    private def binop(op: String,
                      argTypeCheck1: meta.Type => Boolean,
                      argTypeCheck2: meta.Type => Boolean,
                      tipe: meta.Type): Unit = {
      val (t2, tipe2) = varStack.pop()
      val (t1, tipe1) = varStack.pop()
      assert(argTypeCheck1(tipe1) && argTypeCheck2(tipe2))
      val t = tempVar()
      command(
        AssignAction(
          IdExp(Id(t)),
          BinaryExp(
            IdExp(Id(t1)),
            Id(op),
            IdExp(Id(t2)))))
      varStack.push((t, tipe))
    }

    @inline
    private def isSingleWord(tipe: meta.Type) =
      !(tipe == meta.LongType || tipe == meta.DoubleType)

    @inline
    private def isIntType(tipe: meta.Type) =
      tipe == meta.IntType || tipe == meta.ByteType ||
        tipe == meta.CharType || tipe == meta.ShortType

    @inline
    private def isLongType(tipe: meta.Type) =
      tipe == meta.LongType

    @inline
    private def isFloatType(tipe: meta.Type) =
      tipe == meta.FloatType

    @inline
    private def isDoubleType(tipe: meta.Type) =
      tipe == meta.LongType

    @inline
    private def isObjectType(tipe: meta.Type) =
      tipe.isInstanceOf[meta.ObjectType] ||
        tipe.isInstanceOf[meta.ArrayType]

    @inline
    private def typeLit(tipe: meta.Type): LiteralExp =
      LiteralExp(Id(typeDesc), ExtLit(tipe))

    @inline
    private def command(c: Command): Unit = {
      currentBlock += c
    }

    @inline
    private def labelName(label: Label): String =
      labelToNameMap.getOrElseUpdate(label, newLabelName())

    @inline
    private def newLabelName(): String = {
      val r = s"$labelPrefix$labelCounter"
      labelCounter += 1
      r
    }
  }

}
