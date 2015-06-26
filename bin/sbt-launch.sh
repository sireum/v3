#!/usr/bin/env bash
if [[ "$SIREUM_HOME" = "" ]] ; then
   echo "SIREUM_HOME is not set ...aborting"
   exit
fi
: ${SBT_JAR:=${SIREUM_HOME}/apps/build/sbt/bin/sbt-launch.jar}
if [[ ! -f ${SBT_JAR} ]] ; then
    echo "Could not find Sbt launch jar (SBT_JAR=$SBT_JAR) ...aborting."
    exit
fi
: ${SBT_DIR:=sbt}
mkdir -p ${SBT_DIR}
if [[ ! -d ${SBT_DIR} ]] ; then
    echo "Sbt cache directory is not found (SBT_DIR=$SBT_DIR) ...aborting."
    exit
fi
: ${JAVA_OPTIONS:=-Xmx4G -XX:+UseG1GC -XX:ReservedCodeCacheSize=900m -Xss1M -XX:+CMSClassUnloadingEnabled}
: ${JAVA_PROPERTIES:=-Dsbt.ivy.home=${SBT_DIR}/ivy2 -Dsbt.boot.directory=${SBT_DIR}/boot -Dsbt.log.format=false  -Dsbt.ivy.home=${SBT_DIR}/plugins}
java ${JAVA_OPTIONS} ${JAVA_PROPERTIES} -jar ${SBT_JAR} "$@"
