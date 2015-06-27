#!/bin/bash
SCRIPT_HOME=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
REPO=$( cd "$( dirname "$0" )"/.. &> /dev/null && pwd )
PRELUDE=${SCRIPT_HOME}/prelude.sh
/bin/bash ${SCRIPT_HOME}/prelude.sh
JAVA=${REPO}/platform/java/bin/java
SBT_JAR=${REPO}/platform/sbt/bin/sbt-launch.jar
NODE_BIN=${REPO}/platform/node/bin
if [ ! -x ${JAVA} ] || [ ! -f ${SBT_JAR} ] || [ ! -d ${NODE_BIN} ]; then
  echo
  echo "Could not find ${JAVA}, ${SBT_JAR}, or ${NODE_BIN}; aborting..."
  exit
fi
PATH=${NODE_BIN}:${PATH}
: ${JAVA_OPTIONS:=-Xmx4G -XX:+UseG1GC -XX:ReservedCodeCacheSize=900m -Xss1M -XX:+CMSClassUnloadingEnabled}
: ${JAVA_PROPERTIES:=-Dsbt.log.format=false}
${JAVA} ${JAVA_OPTIONS} ${JAVA_PROPERTIES} -jar ${SBT_JAR} "$@"
