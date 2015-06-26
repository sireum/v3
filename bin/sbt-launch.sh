#!/bin/bash
JAVA=platform/java/bin/java
SBT_JAR=platform/sbt/bin/sbt-launch.jar
SETUP=bin/setup.sh
if [ ! -x ${JAVA} ] || [ ! -f ${SBT_JAR} ]; then
  echo "Could not find ${JAVA}; running ${SETUP}..."
  echo
  /bin/bash ${SETUP}
fi
if [ ! -x ${JAVA} ] || [ ! -f ${SBT_JAR} ]; then
  echo
  echo "Still could not find ${JAVA} or ${SBT_JAR}; aborting..."
  exit
fi
: ${JAVA_OPTIONS:=-Xmx4G -XX:+UseG1GC -XX:ReservedCodeCacheSize=900m -Xss1M -XX:+CMSClassUnloadingEnabled}
: ${JAVA_PROPERTIES:=-Dsbt.log.format=false}
${JAVA} ${JAVA_OPTIONS} ${JAVA_PROPERTIES} -jar ${SBT_JAR} "$@"
