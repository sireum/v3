#!/bin/bash -e
export SCRIPT_DIR=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
export SIREUM_IDEA_DISTROS=true
rm -f sireum-v3-idea* sireum-v3-dev-idea*
$SCRIPT_DIR/build.sh
if [ -e $SCRIPT_DIR/idea.exe ] && [ -e $SCRIPT_DIR/idea64.exe ]; then
  cp $SCRIPT_DIR/idea.exe $SCRIPT_DIR/idea64.exe sireum-v3/distros
fi
if [ -e $SCRIPT_DIR/../project/Distros.scala ]; then
  cp $SCRIPT_DIR/../project/Distros.scala $SCRIPT_DIR/sireum-v3/project/Distros.scala
fi
if [ "${SIREUM_DEV_DISTROS}" == "true" ]; then
  $SCRIPT_DIR/sireum-v3/bin/sbt-launch.sh devIveDistros
else
  $SCRIPT_DIR/sireum-v3/bin/sbt-launch.sh iveDistros
fi
if [ -z $SIREUM_DISTRO_BUILD_DIR ]; then
  mv $SCRIPT_DIR/sireum-v3/distros/*.zip $SCRIPT_DIR/
  mv $SCRIPT_DIR/sireum-v3/distros/*.tar.gz $SCRIPT_DIR/
  mv $SCRIPT_DIR/sireum-v3/distros/*.dmg $SCRIPT_DIR/
  mv $SCRIPT_DIR/sireum-v3/distros/sireum-v3*-VER $SCRIPT_DIR/
  if [ ! -d $SCRIPT_DIR/idea ]; then
    mv $SCRIPT_DIR/sireum-v3/distros/idea $SCRIPT_DIR/
  fi
fi
if [ ! -e $SCRIPT_DIR/idea.exe ] || [ ! -e $SCRIPT_DIR/idea64.exe ]; then
  cp $SCRIPT_DIR/sireum-v3/distros/idea.exe $SCRIPT_DIR/sireum-v3/distros/idea64.exe $SCRIPT_DIR/
fi

rm -fR $SCRIPT_DIR/sireum-v3 $SCRIPT_DIR/sireum-v3-dev
