#!/bin/bash -e
export SCRIPT_DIR=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
cd $SCRIPT_DIR
rm -fR sireum-v3-mac64.zip sireum-v3-linux64.zip sireum-v3-win64.zip sireum-v3-VER sireum-v3
rm -fR sireum-v3-dev-mac64.zip sireum-v3-dev-linux64.zip sireum-v3-dev-win64.zip sireum-v3-dev-VER sireum-v3-dev
export SIREUM_SKIP_BUILD=false
if [ "${SIREUM_DEV_DISTROS}" == "true" ]; then
  git clone -b master https://github.com/sireum/v3.git sireum-v3
else
  git clone -b release https://github.com/sireum/v3.git sireum-v3
fi
if [ -d idea ] && [ "$SIREUM_IDEA_DISTROS" == "true" ]; then
  cd sireum-v3/distros
  ln -s ../../idea
  cd ../..
fi
if [ -d resource_hacker ] && [ "$SIREUM_IDEA_DISTROS" == "true" ]; then
  cd sireum-v3/resources/distro
  ln -s ../../resource_hacker
  cd ../../..
fi
if [ -e $SCRIPT_DIR/../build.sbt ]; then
  cp $SCRIPT_DIR/../build.sbt sireum-v3/build.sbt
  cp $SCRIPT_DIR/../bin/prelude.sh sireum-v3/bin/prelude.sh
  cp $SCRIPT_DIR/../project/Distros.scala sireum-v3/project/Distros.scala
fi
cd sireum-v3
export SIREUM_PARALLEL_BUILD=false
#bin/sbt-launch.sh clean test:compile test
./sireum
if [ "${SIREUM_DEV_DISTROS}" == "true" ]; then
  bin/sbt-launch.sh dev-distros
else
  bin/sbt-launch.sh distros
fi
if [ "$SIREUM_IDEA_DISTROS" != "true" ]; then
  if [ -z $SIREUM_DISTRO_BUILD_DIR ]; then
    mv $SCRIPT_DIR/sireum-v3/distros/*.zip $SCRIPT_DIR/
    mv $SCRIPT_DIR/sireum-v3/distros/sireum-v3*-VER $SCRIPT_DIR/
  else
    mv $SIREUM_DISTRO_BUILD_DIR/distros/*.zip $SCRIPT_DIR/
    mv $SIREUM_DISTRO_BUILD_DIR/distros/sireum-v3*-VER $SCRIPT_DIR/
  fi
  rm -fR sireum-v3 sireum-v3-dev
fi