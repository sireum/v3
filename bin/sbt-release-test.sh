#!/bin/bash
SCRIPT_HOME=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
SIREUM_RELEASE=true ${SCRIPT_HOME}/sbt-launch.sh clean compile test:compile test

