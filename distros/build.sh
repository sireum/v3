#!/bin/bash -e
export SCRIPT_DIR=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
cd $SCRIPT_DIR
rm -fR sireum-v3-mac64.zip sireum-v3-linux64.zip sireum-v3-win64.zip sireum-v3-VER sireum-v3
export SIREUM_SKIP_BUILD=false
git clone -b master https://github.com/sireum/v3.git sireum-v3
if [ -d idea ] && [ "$SIREUM_IDEA_DISTROS" == "true" ]; then
  mv idea sireum-v3/distros
fi
if [ -d resource_hacker ] && [ "$SIREUM_IDEA_DISTROS" == "true" ]; then
  mv resource_hacker sireum-v3/resources/distro
fi
cd sireum-v3
export SIREUM_PARALLEL_BUILD=false
bin/sbt-launch.sh clean test:compile test
./sireum
bin/sbt-launch.sh distros
if [ "$SIREUM_IDEA_DISTROS" != "true" ]; then
  mv $SCRIPT_DIR/sireum-v3/distros/*.zip $SCRIPT_DIR/
  mv $SCRIPT_DIR/sireum-v3/distros/sireum-v3-VER $SCRIPT_DIR/
  rm -fR sireum-v3
fi