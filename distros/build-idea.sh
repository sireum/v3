#!/bin/bash -e
export SCRIPT_DIR=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
export SIREUM_IDEA_DISTROS=true
$SCRIPT_DIR/build.sh
$SCRIPT_DIR/sireum-v3/bin/sbt-launch.sh idea-distros
mv $SCRIPT_DIR/sireum-v3/distros/*.zip $SCRIPT_DIR/
mv $SCRIPT_DIR/sireum-v3/distros/*.tar.gz $SCRIPT_DIR/
mv $SCRIPT_DIR/sireum-v3/distros/*.dmg $SCRIPT_DIR/
mv $SCRIPT_DIR/sireum-v3/distros/sireum-v3-VER $SCRIPT_DIR/
mv $SCRIPT_DIR/sireum-v3/distros/idea $SCRIPT_DIR/
mv $SCRIPT_DIR/sireum-v3/resources/distro/resource_hacker $SCRIPT_DIR/
rm -fR sireum-v3
