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
SCRIPT_HOME=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
SIREUM_HOME=$( cd "$( dirname "$0" )"/.. &> /dev/null && pwd )
/bin/bash ${SCRIPT_HOME}/sbt-launch.sh assembly
SIREUM="${SIREUM_HOME}/platform/java/bin/java -jar ${SIREUM_HOME}/bin/sireum.jar"
${SIREUM} util reflect json -d ${SIREUM_HOME}/util/shared/src/main/scala -c org.sireum.util.TagJson -l ${SIREUM_HOME}/license.txt org.sireum.util.Tag
${SIREUM} util reflect rewriter -d ${SIREUM_HOME}/pilar/shared/src/main/scala -c org.sireum.pilar.ast.Rewriter -l ${SIREUM_HOME}/license.txt org.sireum.pilar.ast.Node
${SIREUM} util reflect json -d ${SIREUM_HOME}/pilar/shared/src/main/scala -c org.sireum.pilar.ast.Json -l ${SIREUM_HOME}/license.txt org.sireum.pilar.ast.Node
${SIREUM} util reflect cli -c org.sireum.Cli -d ${SIREUM_HOME}/cli/jvm/src/main/scala -l ${SIREUM_HOME}/license.txt org.sireum.option.SireumOption
${SIREUM} util reflect json -d ${SIREUM_HOME}/java/jvm/src/main/scala -c org.sireum.java.meta.JavaMetaJson -l ${SIREUM_HOME}/license.txt org.sireum.java.meta.JavaMeta
${SIREUM} util reflect rewriter -d ${SIREUM_HOME}/logika/jvm/src/main/scala -c org.sireum.logika.ast.Rewriter -l ${SIREUM_HOME}/license.txt org.sireum.logika.ast.Node
${SIREUM} util reflect json -d ${SIREUM_HOME}/logika/shared/src/main/scala -c org.sireum.logika.message.InputMessageJson -l ${SIREUM_HOME}/license.txt org.sireum.logika.message.InputMessage
${SIREUM} util reflect json -d ${SIREUM_HOME}/logika/shared/src/main/scala -c org.sireum.logika.message.OutputMessageJson -l ${SIREUM_HOME}/license.txt  -i "org.sireum.util,org.sireum.util.TagJson" org.sireum.logika.message.OutputMessage
/bin/bash ${SCRIPT_HOME}/sbt-launch.sh assembly
