#!/usr/bin/env bash
export SCRIPT_HOME=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
: ${SIREUM_HOME:=$( cd "$( dirname "$0" )"/../../../../../../../.. &> /dev/null && pwd )}
cd ${SCRIPT_HOME}
rm -fR sireum
curl -Lo sireum http://files.sireum.org/sireum
chmod +x sireum
./sireum tools cligen -l ${SIREUM_HOME}/license.txt -p org.sireum.cli -w 25,55 CliConfig.sc
