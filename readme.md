[![Build Status](https://api.shippable.com/projects/55534a22edd7f2c052ebbc87/badge?branchName=master)](https://app.shippable.com/projects/55534a22edd7f2c052ebbc87/builds/latest) 

Requirements
============

* [Sireum](http://sireum.org) with Build, Gnat, and Z3 features installed:

  `sireum install Build Gnat Z3`


Building and Testing Sireum using Sbt
=====================================

1. Set the `SIREUM_HOME` environment variable to point to Sireum's
   installation directory.

2. Add `SIREUM_HOME/apps/platform/java/bin` to the beginning of the `PATH`
   environment variable. 

3. Run: `./setup.sh` (or `./setup.sh` for shallow cloning version)

4. Run: `./sbt-launch.sh test`


Eclipse
=======

After running `./setup.sh`, import all nested Eclipse projects into your
workspace.

To resolve sireum-build Eclipse project dependency, 
run `SBT_DIR=sbt ./sbt-launch.sh compile` at least once.
