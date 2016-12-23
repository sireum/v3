#!/bin/bash -e
export SCRIPT_DIR=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
cd $SCRIPT_DIR
export SIREUM_SKIP_BUILD=false
if [ ! -d sireum-v3 ]; then
  git clone https://github.com/sireum/v3.git sireum-v3
fi
cd sireum-v3
git checkout master
git pull --all
rm -fR distros
export SIREUM_PARALLEL_BUILD=false
bin/sbt-launch.sh clean test:compile test
./sireum
bin/sbt-launch.sh distros