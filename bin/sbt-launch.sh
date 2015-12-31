#!/bin/bash
#
# Copyright (c) 2015, Robby, Kansas State University
# All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are met:
#
# 1. Redistributions of source code must retain the above copyright notice, this
#    list of conditions and the following disclaimer.
# 2. Redistributions in binary form must reproduce the above copyright notice,
#    this list of conditions and the following disclaimer in the documentation
#    and/or other materials provided with the distribution.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
# ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
# WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
# DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
# ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
# (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
# LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
# ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
# (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
# SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
#
export SIREUM_HOME=$( cd "$( dirname "$0" )"/.. &> /dev/null && pwd )
PRELUDE=${SIREUM_HOME}/bin/prelude.sh
/bin/bash ${SIREUM_HOME}/bin/prelude.sh
JAVA=${SIREUM_HOME}/platform/java/bin/java
SBT_JAR=${SIREUM_HOME}/platform/sbt/bin/sbt-launch.jar
NODE_BIN=${SIREUM_HOME}/platform/node/bin
if [ ! -x ${JAVA} ] || [ ! -f ${SBT_JAR} ] || [ ! -d ${NODE_BIN} ]; then
  echo
  echo "Could not find ${JAVA}, ${SBT_JAR}, or ${NODE_BIN}; aborting..."
  exit
fi
PATH=${NODE_BIN}:${PATH}
: ${JAVA_OPTIONS:=-Xmx4G -XX:+UseG1GC -XX:ReservedCodeCacheSize=900m -Xss1M -XX:+CMSClassUnloadingEnabled}
: ${JAVA_PROPERTIES:=-Dsbt.log.format=false}
pushd ${SIREUM_HOME} > /dev/null
${JAVA} ${JAVA_OPTIONS} ${JAVA_PROPERTIES} -Dfile.encoding=UTF-8 -jar ${SBT_JAR} "$@"
popd > /dev/null