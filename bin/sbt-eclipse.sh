#!/bin/bash
SCRIPT_HOME=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
${SCRIPT_HOME}/sbt-launch.sh eclipse
