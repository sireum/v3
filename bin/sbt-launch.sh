#!/bin/bash
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
: ${JAVA_PROPERTIES:=-Dsbt.log.format=false -Dfile.encoding=UTF-8}
${JAVA} ${JAVA_OPTIONS} ${JAVA_PROPERTIES} -jar ${SBT_JAR} "$@"
