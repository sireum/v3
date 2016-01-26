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

package org.sireum.awas.ast

import org.sireum.util._

import scala.collection.immutable.ListMap

object PrettyPrinter {
  def apply(m: Model): String = {
    val sb = new StringBuilder
    new PrettyPrinter(sb).print(m)
    sb.toString().trim
  }
}

final class PrettyPrinter(sb: StringBuilder) {
  def print(m: Model, indent: Natural = 0): Unit = {
    implicit val _indent = indent

    if(!m.types.isEmpty) {
      sb.append("types")
      println()
      print(m.types.head, indent+1)
      for(tt <- m.types.tail) {
        println()
        print(tt, indent + 1)
      }
      println()
    }

    if(!m.constants.isEmpty) {
      sb.append("constants")
      println()
      print(m.constants.head, indent + 1)
      for(ct <- m.constants.tail) {
        println()
        print(ct, indent +1)
      }
      println()
    }

    if(!m.components.isEmpty) {
      sb.append("components")
      println()
      print(m.components.head, indent + 1)
      for(ct <- m.components.tail) {
        println()
        print(ct, indent + 1)
      }
      println()
    }

    if(!m.connections.isEmpty) {
      sb.append("connections")
      println()
      print(m.connections.head, indent+1)
      for(ct <- m.connections.tail) {
        println()
        print(ct, indent+1)
      }
      println()
    }
  }

  def print(td: TypeDecl, indent: Natural) : Unit = {
    td match {
      case td:AliasDecl => print(td.asInstanceOf[AliasDecl], indent)
      case td:EnumDecl => print(td.asInstanceOf[EnumDecl], indent)
      case td:LatticeDecl => print(td.asInstanceOf[LatticeDecl], indent)
      case td:RecordDecl => print(td.asInstanceOf[RecordDecl], indent)
    }
  }

  def print(compd: ComponentDecl, indent: Natural) : Unit ={
    printIndent(indent)
    print(compd.compName)
    println()
    if(!compd.ports.isEmpty) {
      printIndent(indent+1)
      sb.append("ports")
      println()
      print(compd.ports.head, indent+2)
      for(cp <- compd.ports.tail) {
        println()
        print(cp, indent+2)
      }
     println()
    }
    if(!compd.flows.isEmpty) {
      printIndent(indent+1)
      sb.append("flows")
      println()
      print(compd.flows.head, indent+2)
      for(cf <- compd.flows.tail) {
        println()
        print(cf, indent+2)
      }
      println()
    }
    if(!compd.properties.isEmpty) {
      printIndent(indent+1)
      sb.append("properties")
      println()
      print(compd.properties.head, indent + 2)
      for(cp <- compd.properties.tail) {
        println()
        print(cp, indent + 2)
      }
      println()
    }
  }

  def print(cd : ConnectionDecl, indent: Natural) : Unit = {
    printIndent(indent)
    print(cd.connName)
    sb.append(" : ")
    print(cd.fromComp)
    sb.append(".")
    print(cd.fromPort)
    if(!cd.fromE.isEmpty) {
      sb.append("{")
      print(cd.fromE.head)
      for(et <- cd.fromE.tail) {
        sb.append(", ")
        print(et)
      }
      sb.append("}")
    }
    sb.append(" -> ")
    print(cd.toComp)
    sb.append(".")
    print(cd.toPort)

    if(!cd.toE.isEmpty) {
      sb.append("{")
      print(cd.toE.head)
      for(et <- cd.toE.tail) {
        sb.append(", ")
        print(et)
      }
      sb.append("}")
    }
    println()
    if(!cd.properties.isEmpty) {
      printIndent(indent+1)
      sb.append("properties")
      println()
      print(cd.properties.head, indent + 2)
      for(cp <- cd.properties.tail) {
        println()
        print(cp, indent + 2)
      }
      println()
    }

  }

  def print(ad : AliasDecl, indent: Natural) : Unit ={
    printIndent(indent)
    sb.append("alias ")
    print(ad.name)
    sb.append(" = ")
    print(ad.typeName)
    println()
  }

  def print(ed: EnumDecl, indent: Natural):Unit = {
    printIndent(indent)
    sb.append("enum ")
    print(ed.name)
    if(!ed.superEnums.isEmpty) {
      sb.append(" extends ")
      print(ed.superEnums.head)
      for(edt<-ed.superEnums.tail) {
        sb.append(", ")
        print(edt)
      }
    }
    if(!ed.elements.isEmpty) {
      sb.append(" {")
      print(ed.elements.head)
      for(et <- ed.elements.tail) {
        sb.append(", ")
        print(et)
      }
      sb.append("}")
    }
    println()
  }

  def print(ld: LatticeDecl, indent: Natural) : Unit = {
    printIndent(indent)
    sb.append("lattice ")
    print(ld.name)
    if(!ld.superLattice.isEmpty) {
      sb.append(" extends ")
      print(ld.superLattice.head)
      for(ldt<-ld.superLattice.tail) {
        sb.append(", ")
        print(ldt)
      }
    }
    println()
  }

  def print(rd : RecordDecl, indent: Natural) : Unit ={
    printIndent(indent)
    sb.append("record ")
    print(rd.name)
    println()
    printIndent(indent+1)
    print(rd.fields.head)
    for(ft <- rd.fields.tail) {
      println()
      printIndent(indent + 1)
      print(ft)
    }
    println()
  }

  def print(f: FieldDecl) : Unit ={
    print(f.id)
    sb.append(" : ")
    print(f.fieldType)
  }

  def print(p : Port, indent: Natural) : Unit = {
    printIndent(indent)
    if(p.isIn) {sb.append("in ")} else {sb.append("out ")}
    print(p.id)
    p.name match {
      case None =>
      case _ =>
        sb.append(" : ")
        print(p.name.get)
    }
  }

  def print(f : Flow, indent: Natural) : Unit ={
    printIndent(indent)
    print(f.id)
    sb.append(" : ")
    f.from match {
      case None => sb.append("_")
      case _ =>
        print(f.from.get)
        sb.append("{")
        print(f.fromE.head)
        for(fe <- f.fromE.tail) {
          sb.append(", ")
          print(fe)
        }
        sb.append("}")
    }
    sb.append(" -> ")
    f.to match {
      case None => sb.append("_")
      case _ =>
        print(f.to.get)
        sb.append("{")
        print(f.toE.head)
        for(te <- f.toE.tail) {
          sb.append(", ")
          print(te)
        }
        sb.append("}")
    }
  }

  def print(p : Property, indent: Natural) : Unit={
    printIndent(indent)
    print(p.id)
    sb.append(" : ")
    print(p.propType)
    p.value match {
      case None =>
      case _ =>
        sb.append(" = ")
        print(p.value.get)
    }


  }

  def print(cd: ConstantDecl, indent:Natural): Unit = {
    printIndent(indent)
    print(cd.name)
    sb.append(" : ")
    print(cd.constType)
    sb.append(" = ")
    print(cd.init)
  }

  def print(t : Type) : Unit = {
    t match {
      case t:CompoundType => print(t.asInstanceOf[CompoundType])
      case t:BasicType => print(t.asInstanceOf[BasicType])
    }
  }

  def print(ct: CompoundType):Unit = {
    ct match {
      case OptionTypeDecl(typeVal) =>
        sb.append("Option[")
        print(typeVal)
        sb.append("]")
      case SetTypeDecl(typeVal) =>
        sb.append("Set[")
        print(typeVal)
        sb.append("]")
      case SeqTypeDecl(typeVal) =>
        sb.append("Seq[")
        print(typeVal)
        sb.append("]")
      case MapTypeDecl(keyType, valueType) =>
        sb.append("Map[")
        print(keyType)
        sb.append(", ")
        print(valueType)
        sb.append("]")
    }
  }

  def print(bt: BasicType): Unit = {
    bt match {
      case BooleanTypeDecl() => sb.append("Boolean")
      case IntegerTypeDecl(value) =>
        sb.append("Integer")
        value match {
          case None =>
          case _ =>
            sb.append("(")
            print(value.get._1)
            sb.append(", ")
            print(value.get._2)
            sb.append(")")
        }
      case RealTypeDecl() => sb.append("Real")
      case StringTypeDecl() => sb.append("String")
      case ComponentTypeDecl() => sb.append("Component")
      case PortTypeDecl() => sb.append("Port")
      case NamedTypeDecl(value) => print(value)
    }
  }

  def print(itd: IntTypeDisc): Unit = {
    itd match {
      case IntLit(value) => sb.append(value)
      case NamedIntType(value) => print(value)
      case ArbitrartyIntType() => sb.append("_")
    }
  }

  def print(init : Init): Unit = {
    init match {
      case BooleanInit(value) => sb.append(value.toString)
      case IntegerInit(value) => sb.append(value.toString)
      case RealInit(value) => sb.append(value.toString)
      case StringInit(value) =>
        sb.append("\"")
        sb.append(value)
        sb.append("\"")
      case RecordInit(name, fields) =>
        print(name)
        sb.append("(")
        val sortedFields = ListMap(fields.toSeq:_*)
        print(sortedFields.head._1)
        sb.append(" = ")
        print(sortedFields.head._2)
        for(ft <- sortedFields.tail) {
          sb.append(", ")
          print(ft._1)
          sb.append(" = ")
          print(ft._2)
        }
        sb.append(")")
      case NameRefInit(name, ref) =>
        print(name)
        ref match {
          case Some(_) =>
            sb.append(" . ")
            print(ref.get)
          case None =>
        }
      case NoneInit(typeInit) =>
        sb.append("None[")
        print(typeInit)
        sb.append("]")
      case SomeInit(typeInit, value) =>
        sb.append("Some[")
        print(typeInit)
        sb.append("](")
        print(value)
        sb.append(")")
      case SetInit(typeInit, value) =>
        sb.append("Set[")
        print(typeInit)
        sb.append("](")
        val sortedSet = value
        print(sortedSet.head)
        for(sst <- sortedSet.tail) {
          sb.append(", ")
          print(sst)
        }
        sb.append(")")
      case SeqInit(typeInit, value) =>
        sb.append("Seq[")
        print(typeInit)
        sb.append("](")
        print(value.head)
        for(vt <- value.tail) {
          sb.append(", ")
          print(vt)
        }
        sb.append(")")
      case MapInit(keyType, valueType, value) =>
        sb.append("Map[")
        print(keyType)
        sb.append(", ")
        print(valueType)
        sb.append("](")
        val sortedValue = ListMap(value.toSeq:_*)
        print(sortedValue.head._1)
        sb.append(" -> ")
        print(sortedValue.head._2)
        for(svt <- sortedValue.tail) {
          sb.append(", ")
          print(svt._1)
          sb.append(" -> ")
          print(svt._2)
        }
        sb.append(")")
    }
  }

  def print(n : Name): Unit ={
    print(n.value.head)
    for (tn <- n.value.tail) {
      sb.append("::")
      print(tn)
    }
  }

  def print(i : Id): Unit ={
    sb.append(i.value)
  }

  @inline
  private def printIndent(indent: Natural): Unit = {
    var i = 0
    while (i < indent) {
      sb.append("  ")
      i += 1
    }
  }

  @inline
  private def println(): Unit = {
    sb.append('\n')
  }

  @inline
  private def peek(s: String)(index: Natural): NaturalSentinel =
    if (index < s.length) s.charAt(index) else naturalSentinel

}
