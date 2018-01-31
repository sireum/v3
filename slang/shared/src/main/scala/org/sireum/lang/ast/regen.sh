#!/usr/bin/env bash
: ${SIREUM_HOME:=$( cd "$( dirname "$0" )"/../../../../../../../../.. &> /dev/null && pwd )}
$SIREUM_HOME/platform/java/bin/java -cp $SIREUM_HOME/bin/sireum.jar org.sireum.cli.Sireum util sergen -l $SIREUM_HOME/license.txt -m json,msgpack AST.scala
$SIREUM_HOME/platform/java/bin/java -cp $SIREUM_HOME/bin/sireum.jar org.sireum.cli.Sireum util transgen -l $SIREUM_HOME/license.txt -m immutable,mutable AST.scala