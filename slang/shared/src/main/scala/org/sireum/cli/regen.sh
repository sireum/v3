#!/usr/bin/env bash
CLI=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
ROOT=$CLI/../../../../../../../..
JAVA=$ROOT/platform/java/bin/java
$JAVA -cp $ROOT/bin/sireum.jar org.sireum.cli.Sireum util cligen -l $ROOT/license.txt -p org.sireum.cli -w 25,55 CliConfig.sc
