#!/usr/bin/env bash
echo "Make sure to create Sireum fat jar first using Sbt before running this script."
fsc -reset
for i in *.logika; do
    scala -classpath ../../../../../../../../bin/sireum.jar $i
done
