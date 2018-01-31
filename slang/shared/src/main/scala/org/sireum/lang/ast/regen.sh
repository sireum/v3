#!/usr/bin/env bash
AST=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
ROOT=$AST/../../../../../../../../..
JAVA=$ROOT/platform/java/bin/java
$JAVA -cp $ROOT/bin/sireum.jar org.sireum.cli.Sireum util sergen -l $ROOT/license.txt -m json,msgpack AST.scala
$JAVA -cp $ROOT/bin/sireum.jar org.sireum.cli.Sireum util transgen -l $ROOT/license.txt -m immutable,mutable AST.scala