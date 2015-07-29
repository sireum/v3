#!/bin/bash
SCRIPT_HOME=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
SIREUM="java -jar ${SCRIPT_HOME}/../jvm/target/scala-2.11/sireum.jar"
${SCRIPT_HOME}/sbt-launch.sh assembly
${SIREUM} util reflect rewriter -d core/sireum-pilar/src/main/scala -c org.sireum.pilar.ast.Rewriter -l license.txt org.sireum.pilar.ast.Node
${SIREUM} util reflect json -d core/sireum-pilar/src/main/scala -c org.sireum.pilar.ast.Json -l license.txt org.sireum.pilar.ast.Node
${SIREUM} util reflect cli -c org.sireum.Cli -d core/sireum-cli/src/main/scala -l license.txt org.sireum.option.SireumOption
${SIREUM} util reflect json -d java/sireum-java/src/main/scala -c org.sireum.java.meta.JavaMetaJson -l license.txt org.sireum.java.meta.JavaMeta
