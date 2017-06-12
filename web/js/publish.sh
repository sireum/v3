#!/usr/bin/env bash -e
SIREUM_HOME=$( cd "$( dirname "$0" )"/../.. &> /dev/null && pwd )
$SIREUM_HOME/bin/sbt-launch.sh "project web-js" clean fullOptJS
rm -fR playground
git clone git@github.com:sireum/playground
rm -fR playground/*
cp -R $SIREUM_HOME/web/js/target/scala-2.12/classes/* playground/
cd playground
rm -R ffi org scalatex index-dev.html JS_DEPENDENCIES web-jsdeps.js min/web-jsdeps.min.js min/web-opt.js.map
echo "play.sireum.org" > CNAME
sed  -i.old -e '$ d' min/web-opt.js
rm -f min/web-opt.js.old
git add --all
git commit -a -m "Updated."
git push
