#!/usr/bin/env bash
: ${SIREUM_HOME:=$( cd "$( dirname "$0" )"/../../../../../../../.. &> /dev/null && pwd )}
$SIREUM_HOME/platform/java/bin/java -cp $SIREUM_HOME/bin/sireum.jar org.sireum.cli.Sireum util cligen -l $SIREUM_HOME/license.txt -p org.sireum.cli -w 25,55 CliConfig.sc
