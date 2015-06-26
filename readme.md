Requirements
============

* [Sireum v2](http://sireum.org) with the Build feature installed:

  `sireum install Build`

  and set `SIREUM_HOME` to Sireum v2 directory.

* [Node.js](https://nodejs.org)


Building and Testing Sireum using Sbt
=====================================

Run: `bin/sbt-launch.sh test`


Assembling a Fat Jar
====================

Run: `bin/sbt-launch.sh assembly`
 
The jar will be located at `jvm/target/scala-2.11/sireum-v3.jar`


Running Sireum from the Fat Jar
===============================

Let `sireum` be an alias for: `java -jar path/to/sireum-v3.jar`

e.g., in bash:

```bash
alias sireum="java -jar jvm/target/scala-2.11/sireum-v3.jar"
```

Run: `sireum`

```
Sireum: A Software Analysis Platform (v3)
(c) 2011-2015, SAnToS Laboratory, Kansas State University
http://sireum.org

Usage: sireum <mode>

Available mode:

pilar    Pilar IR tooling
```

Another example: `sireum pilar` (or simply `sireum p`)

```
Pilar: Sireum's Intermediate Representation (IR)

Usage: sireum pilar <mode>

Available mode:

parser   Pilar parser, pretty printer, JSON de/serializer
```

More example: `sireum p p -h`

```
Pilar Parser
... and pretty printer and JSON de/serializer

Usage: sireum pilar parser <file-1> ... <file-N>

Options:
 -a,  --antlr4            Use ANTLR4 Pilar parser instead of a hand-written one
 -e,  --max-errors        Maximum number of errors found before parsing stop
                            Default: 10
 -i,  --input-mode        Input mode { auto, pilar, json, scala }
                            Default: auto
-in,  --standard-input    Use standard input stream
 -f,  --output-file       Output file (if unspecified, use standard output)
 -o,  --output-mode       Output mode { pilar, json, scala }
                            Default: json
 -h,  --help              Display usage information
```
