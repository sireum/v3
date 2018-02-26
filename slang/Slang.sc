import $file.runtime.Sireum, Sireum.Module._
import $file.runtime.Runtime
import mill._
import mill.scalalib._

trait Module extends CrossJvmJs {

  final override def jvmDeps = Seq()

  final override def jsDeps = Seq()

  final override def scalacPluginIvyDeps = Agg(
    ivy"org.sireum::scalac-plugin:$scalacPluginVersion"
  )

  final override def testIvyDeps = Agg(
    ivy"org.scalatest::scalatest::$scalaTestVersion"
  )

  final override def jvmTestIvyDeps = Agg.empty

  final override def jsTestIvyDeps = Agg.empty

  final override def testScalacPluginIvyDeps = scalacPluginIvyDeps

  final override def jvmTestFrameworks = Seq("org.scalatest.tools.Framework")

  final override def jsTestFrameworks = jvmTestFrameworks

}

object Module {

  trait Ast extends Module {

    final override def ivyDeps = Agg.empty

    final override def deps = Seq(libraryObject)

    def libraryObject: Runtime.Module.Library
  }

  trait Parser extends Module {

    final override def ivyDeps = Agg(
      ivy"org.scalameta::scalameta::$scalaMetaVersion"
    )

    final override def deps = Seq(libraryObject, astObject)

    def libraryObject: Runtime.Module.Library

    def astObject: Ast

  }

  trait Tipe extends Module {

    final override def ivyDeps = Agg.empty

    final override def deps = Seq(libraryObject, astObject, parserObject)

    def libraryObject: Runtime.Module.Library

    def astObject: Ast

    def parserObject: Parser

  }

}

