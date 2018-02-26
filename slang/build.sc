import $file.runtime.Runtime
import $file.Slang
import ammonite.ops.up

object runtime extends mill.Module {

  object macros extends Runtime.Module.Macros

  object library extends Runtime.Module.Library {

    final override def macrosObject = macros

  }

}

object slang extends mill.Module {

  final override def millSourcePath = super.millSourcePath / up

  object ast extends Slang.Module.Ast {

    final override def libraryObject = runtime.library

  }

  object parser extends Slang.Module.Parser {

    final override def libraryObject = runtime.library

    final override def astObject = ast

  }

  object tipe extends Slang.Module.Tipe {

    final override def libraryObject = runtime.library

    final override def astObject = ast

    final override def parserObject = parser

  }

}