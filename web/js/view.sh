#!/usr/bin/env bash -e
SIREUM_HOME=$( cd "$( dirname "$0" )"/../.. &> /dev/null && pwd )
$SIREUM_HOME/bin/sbt-launch.sh "project web-js" clean fullOptJS
rm -fR playground
mkdir playground
cp -R $SIREUM_HOME/web/js/target/scala-2.12/classes/* playground/
cd playground
rm -R ffi org scalatex index-dev.html JS_DEPENDENCIES web-jsdeps.js min/web-jsdeps.min.js min/web-opt.js.map
open index.html