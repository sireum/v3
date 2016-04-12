#!/bin/bash -e
export SIREUM_SKIP_BUILD=false
if [ ! -d sireum-v3 ]; then
  git clone https://github.com/sireum/v3.git sireum-v3
fi
cd sireum-v3
git pull --all
git checkout master
rm -fR distros
export SIREUM_PARALLEL_BUILD=false
bin/sbt-launch.sh clean test:compile test
./sireum
bin/sbt-launch.sh distros