Requirements
============

* [Sireum v2](http://sireum.org) with the Build feature installed:

  `sireum install Build`

  and set `SIREUM_HOME` to Sireum v2 directory.

* [Node.js](https://nodejs.org)


Building and Testing Sireum using Sbt
=====================================

1. Run: `bin/sbt-launch.sh test`


Assembling a Fat Jar
====================

1. Run: `bin/sbt-launch.sh assembly`
   The jar will be located at `target-jvm/scala-2.11/sireum-v3.jar`