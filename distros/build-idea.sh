#!/bin/bash -e
export SCRIPT_DIR=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
$SCRIPT_DIR/build.sh
$SCRIPT_DIR/../bin/sbt-launch.sh idea-distros
