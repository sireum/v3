#!/usr/bin/env bash
echo "Make sure to create Sireum fat jar first using Sbt before running this script."
fsc -reset
for i in *.scala; do
    scala -classpath ../../../../../../../../jvm/target/scala-2.11/sireum.jar $i
done
