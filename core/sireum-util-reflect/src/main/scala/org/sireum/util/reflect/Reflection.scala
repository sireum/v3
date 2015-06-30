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

package org.sireum.util.reflect

import java.lang.reflect.{InvocationHandler, Proxy}

import org.sireum.util._

object Reflection {

  import scala.reflect.runtime.universe._

  final val classLoader = {
    val cl = getClass.getClassLoader
    if (cl == null) ClassLoader.getSystemClassLoader else cl
  }

  final val mirror = runtimeMirror(classLoader)

  final val booleanType = typeOf[Boolean]
  final val charType = typeOf[Character]
  final val shortType = typeOf[Short]
  final val intType = typeOf[Int]
  final val longType = typeOf[Long]
  final val floatType = typeOf[Float]
  final val doubleType = typeOf[Double]
  final val bigIntType = typeOf[BigInt]
  final val stringType = typeOf[String]
  final val productType = typeOf[Product].erasure
  final val seqType = typeOf[CSeq[_]].erasure
  final val noneType = typeOf[None.type]


  def typeCheck(t: Tree, m: Mirror = mirror): Tree = {
    import scala.tools.reflect.ToolBox

    val tb = m.mkToolBox()
    tb.typecheck(t)
  }

  def eval[T](expr: String, m: Mirror = mirror) = {
    import scala.tools.reflect.ToolBox

    val tb = m.mkToolBox()
    tb.eval(tb.parse(expr)).asInstanceOf[T]
  }

  def evalExpr[T](expr: Expr[T], m: Mirror = mirror) = {
    import scala.tools.reflect.ToolBox

    val tb = m.mkToolBox()
    tb.eval(expr.tree).asInstanceOf[T]
  }

  def parse(expr: String, m: Mirror = mirror): Tree = {
    import scala.tools.reflect.ToolBox

    val tb = m.mkToolBox()
    tb.parse(expr)
  }

  def ast(expr: String, m: Mirror = mirror): Tree = {
    import scala.tools.reflect.ToolBox

    val tb = m.mkToolBox()
    tb.typecheck(tb.parse(expr))
  }

  def reify[T](expr: String, m: Mirror = mirror): T = {

    eval[T](s"{ import scala.reflect.runtime.universe._; reify { $expr } }", m)
  }

  @inline
  def classMirror(c: Class[_], m: Mirror = mirror): ClassMirror = {
    m.reflectClass(m.classSymbol(c))
  }

  @inline
  def companion[T](
                    c: Class[T], processAnnotations: Boolean,
                    m: Mirror = mirror): Option[(Symbol, Any, ISeq[Annotation])] = {
    val classSymbol = m.classSymbol(c)
    val companionSymbol = classSymbol.companion
    if (companionSymbol.isModule) {
      val moduleSymbol = companionSymbol.asModule
      val moduleMirror = m.reflectModule(moduleSymbol)
      try
        Some((companionSymbol, moduleMirror.instance,
          if (processAnnotations)
            moduleSymbol.annotations.toVector.map(annotation(_, m))
          else ivectorEmpty))
      catch {
        case e: ClassNotFoundException => None
      }
    } else None
  }

  @inline
  def fullName(t: Type) = t.typeSymbol.fullName

  @inline
  def constructor(t: Type) =
    t.decl(termNames.CONSTRUCTOR).asTerm.alternatives.head.asMethod

  @inline
  def getType(o: Any, m: Mirror = mirror): Type = {
    val os = m.reflect(o).symbol
    os.asType.toType
  }

  @inline
  def getTypeOfClass(c: Class[_], m: Mirror = mirror): Type =
    m.classSymbol(c).toType

  @inline
  def getClassOfType(t: Type, m: Mirror = mirror): Class[_] =
    m.runtimeClass(t.typeSymbol.asClass)

  def classInits(tipe: Type, obj: Any,
                 includeInherited: Boolean,
                 m: Mirror = mirror): IMap[String, Object] = {
    var result = imapEmpty[String, Object]
    for (
      d <- if (includeInherited) tipe.members else tipe.decls //
      if d.isTerm && (d.asTerm.isVal || d.asTerm.isVar)
    ) {
      val name = d.name.decodedName.toString.trim
      val im = m.reflect(obj)
      val value = im.reflectField(d.asTerm).get.asInstanceOf[Object]
      result += (name -> value)
    }
    result
  }

  def traitInits(clazz: Class[_]): IMap[String, Object] = {
    var cl = clazz.getClassLoader
    if (cl == null) {
      cl = ClassLoader.getSystemClassLoader
    }

    var init: Option[java.lang.reflect.Method] = None
    try {
      for (m <- cl.loadClass(clazz.getName + "$class").getMethods if init.isEmpty)
        if (m.getName == "$init$")
          init = Some(m)
    } catch {
      case e: Exception =>
    }

    if (init.isEmpty) return imapEmpty

    val encodedToDecodedSetterNameMap = mmapEmpty[String, String]

    for (m <- clazz.getDeclaredMethods) {
      val setterPrefix = clazz.getName.replace('.', '$') + "$_setter_$"
      val encoded = m.getName
      if (encoded.startsWith(setterPrefix)) {
        val decoded = encoded.substring(setterPrefix.length, encoded.length - 4)
        encodedToDecodedSetterNameMap(encoded) = decoded
      }
    }

    var result = imapEmpty[String, Object]

    init.get.invoke(null, Proxy.newProxyInstance(cl, Array[Class[_]](clazz),
      new InvocationHandler {
        def invoke(proxy: Object,
                   method: java.lang.reflect.Method,
                   args: Array[Object]) = {
          encodedToDecodedSetterNameMap.get(method.getName) match {
            case Some(decodedName) => result += (decodedName -> args(0))
            case _ =>
          }
          null
        }
      }))

    result
  }

  def annotation(a: scala.reflect.runtime.universe.Annotation,
                 m: Mirror = mirror): Annotation = {
    def isJavaAnnotation(t: Tree) =
      !(t.tpe <:< productType) && t.children.tail.forall {
        case _: AssignOrNamedArg => true
        case _ => false
      }
    def tree(tr: Tree): Any = {
      val tipe = tr.tpe
      if (tipe != null && tipe =:= noneType) return None
      tr match {
        case Literal(Constant(v)) => v
        case Apply(fun, args) =>
          tr.tpe match {
            case t if t <:< productType =>
              getClassOfType(t).getConstructors()(0).
                newInstance(args.map(tree).map(_.asInstanceOf[AnyRef]): _*)
            case t if t <:< seqType =>
              Vector(args.map(tree): _*)
          }
        case AssignOrNamedArg(_, rhs) =>
          tree(rhs)
        case _ =>
          sys.error("Unhandled reflection tree: " + showRaw(tr))
      }
    }
    val aType = a.tree.tpe
    if (isJavaAnnotation(a.tree)) {
      Annotation(aType, a.tree.children.tail.map({
        case AssignOrNamedArg(Ident(name), rhs) =>
          AnnotationArg(name.decodedName.toString, tree(rhs))
      }))
    } else if (aType <:< productType) {
      val cc =
        try CaseClass.caseClassType(aType, processAnnotations = false)
        catch {
          case t: Throwable =>
            sys.error("Only support case classes (or Java annotation) as annotation type")
        }
      Annotation(aType, cc.params.zip(a.tree.children.tail).map { p =>
        val (param, arg) = p
        AnnotationArg(param.name, tree(arg))
      })
    } else {
      sys.error("Unhandled annotation type: " + showRaw(a.tree))
    }
  }

  case class Annotation(tipe: Type,
                        params: ISeq[AnnotationArg]) {
    override def equals(obj: scala.Any): Boolean = obj match {
      case obj: Annotation => tipe =:= obj.tipe && params == obj.params
      case _ => false
    }
  }

  case class AnnotationArg(name: String,
                           value: Any)

  case class CaseClass(tipe: Type,
                       annotations: ISeq[Reflection.Annotation],
                       private[Reflection] var _params: ISeq[CaseClass.Param],
                       private[Reflection] var _properties: IMap[Any, Any]) {
    def params = _params

    def properties = _properties

    override def equals(obj: scala.Any): Boolean = obj match {
      case obj: CaseClass =>
        tipe =:= obj.tipe && annotations == obj.annotations &&
          params == obj.params && properties == obj.properties
      case _ => false
    }
  }

  object CaseClass {
    private val consCache =
      new scala.collection.mutable.WeakHashMap[java.lang.Class[_], //
        java.lang.reflect.Constructor[_]]

    def make[T](pClass: Class[T], elements: Object*): T = {
      val cons = consCache.getOrElseUpdate(pClass, pClass.getConstructors()(0))
      val result = cons.newInstance(elements: _*)
      result.asInstanceOf[T]
    }

    val caseClassCache: MMap[Class[_], CaseClass] = {
      import scala.collection.JavaConversions._
      new java.util.WeakHashMap[Class[_], CaseClass]()
    }

    @inline
    def newCaseClass[T](c: Class[T], args: Object*): T =
      make(c, args: _*)

    @inline
    def caseClassType(c: Class[_], processAnnotations: Boolean,
                      m: Mirror = mirror): CaseClass =
      caseClassCache.getOrElseUpdate(c,
        caseClassType(getTypeOfClass(c), processAnnotations, m))

    @inline
    def caseClassType(tipe: Type, processAnnotations: Boolean): CaseClass = {
      caseClassType(tipe, processAnnotations, mirror)
    }

    def caseClassType(tipe: Type, processAnnotations: Boolean, m: Mirror): CaseClass = {
      val ts = tipe.typeSymbol
      require(ts.asClass.isCaseClass)

      val cMethodSym = constructor(tipe)
      var params = ivectorEmpty[Param]
      for (p <- cMethodSym.paramLists.head) {
        val name = p.name.decodedName.toString
        val anns =
          if (processAnnotations) {
            val fd = tipe.decl(TermName(name))
            fd.annotations.toVector.map(annotation(_, m))
          } else
            ivectorEmpty
        params :+= Param(name, p.typeSignature, anns, None)
      }
      val anns =
        if (processAnnotations) ts.annotations.toVector.map(annotation(_, m))
        else ivectorEmpty
      CaseClass(tipe, anns, params, imapEmpty[Any, Any])
    }

    def caseClassObject[T <: AnyRef with Product](t: T, processAnnotations: Boolean,
                                                  seen: MIdMap[AnyRef, Any]): CaseClass = {

      val result = caseClassType(t.getClass, processAnnotations).copy()
      seen.put(t, result)

      implicit val iseen = seen
      implicit val ipa = processAnnotations

      var params = ivectorEmpty[Param]
      for (i <- result.params.indices)
        params :+= result.params(i).copy(arg = Some(value(t.productElement(i))))
      result._params = params

      result
    }

    private def value(v: Any)(
      implicit processAnnotations: Boolean, seen: MIdMap[AnyRef, Any]): Any =
      v match {
        case v: AnyRef =>
          if (seen.contains(v)) seen(v)
          else
            v match {
              case m: ILinkedMap[_, _] =>
                var newM = ilinkedMapEmpty[Any, Any]
                for ((k, v) <- m) newM += (value(k) -> value(v))
                newM
              case m: IMap[_, _] =>
                var newM = imapEmpty[Any, Any]
                for ((k, v) <- m) newM += (value(k) -> value(v))
                newM
              case tr: IVector[_] =>
                var newTr = ivectorEmpty[Any]
                for (e <- tr) newTr :+= value(e)
                newTr
              case tr: IList[_] =>
                var newTr = ilistEmpty[Any]
                for (e <- tr) newTr :+= value(e)
                newTr
              case p: Product => caseClassObject(p, processAnnotations, seen)
              case _ => v
            }
        case _ => v
      }

    case class Param(name: String,
                     tipe: Type,
                     annotations: ISeq[Annotation],
                     arg: Option[Any]) {
      override def equals(obj: scala.Any): Boolean = {
        obj match {
          case obj: Param =>
            name == obj.name && tipe =:= obj.tipe &&
              annotations == obj.annotations && arg == obj.arg
          case _ => false
        }
      }
    }

  }

}
