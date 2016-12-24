#!/bin/bash -e
export SCRIPT_DIR=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
cd $SCRIPT_DIR
rm -fR *.zip sireum-v3-VER sireum-v3
export SIREUM_SKIP_BUILD=false
git clone -b master https://github.com/sireum/v3.git sireum-v3
cd sireum-v3
export SIREUM_PARALLEL_BUILD=false
bin/sbt-launch.sh clean test:compile test
./sireum
bin/sbt-launch.sh distros
mv $SCRIPT_DIR/sireum-v3/distros/*.zip $SCRIPT_DIR/
mv $SCRIPT_DIR/sireum-v3/distros/sireum-v3-VER $SCRIPT_DIR/
rm -fR $SCRIPT_DIR/sireum-v3