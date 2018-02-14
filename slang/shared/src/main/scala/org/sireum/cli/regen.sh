#!/usr/bin/env bash
: ${SIREUM_HOME:=$( cd "$( dirname "$0" )"/../../../../../../../.. &> /dev/null && pwd )}
$SIREUM_HOME/platform/java/bin/java -jar $SIREUM_HOME/bin/sireum.jar util cligen -l $SIREUM_HOME/license.txt -p org.sireum.cli -w 25,55 CliConfig.sc
