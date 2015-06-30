Requirements
============

All Platforms
-------------

* Tools: `git`, `unzip`, `wget`

Windows
-------

* [MSYS2](https://msys2.github.io)

  ```bash
  pacman -S git unzip wget
  ```


Building and Testing Sireum using Sbt
=====================================

Run: `bin/sbt-launch.sh test`


Assembling a Fat Jar
====================

Run: `bin/sbt-launch.sh assembly`
 
The jar will be located at `jvm/target/scala-2.11/sireum.jar`


Running Sireum from the Fat Jar
===============================

Let `sireum` be an alias for: `java -jar path/to/sireum.jar`

e.g., in bash:

```bash
alias sireum="java -jar jvm/target/scala-2.11/sireum.jar"
```

Run: `sireum`

```
Sireum: A Software Analysis Platform (v3)
(c) 2011-2015, SAnToS Laboratory, Kansas State University
http://sireum.org

Usage: sireum <mode>

Available mode(s):

pilar    Pilar tooling
util     Utility tooling
```

Another example: `sireum pilar` (or simply `sireum p`)

```
Pilar: Sireum's Intermediate Representation (IR)

Usage: sireum pilar <mode>

Available mode(s):

parser    Pilar parser
```

More example: `sireum p p`

```
Pilar Parser
... and pretty printer and JSON de/serializer

Usage: sireum pilar parser <file-1> ... <file-N>

Options:
 -a, --antlr4            Use ANTLR4 Pilar parser instead of hand-written one
 -e, --max-errors        Maximum number of errors found before parsing stop
                           Default: 10
 -f, --output-file       Output file
                         (if unspecified, use standard output stream)
 -i, --input-mode        Input mode { auto, pilar, json, scala }
                           Default: auto
-in, --standard-input    Use standard input stream
 -o, --output-mode       Output mode { pilar, json, scala }
                           Default: json
 -h, --help              Display usage information
```

Try:
```
prompt> sireum p p -i pilar -in↩
def foo(x) {↩
#L1 return x;↩
}↩
⌃D
```
Output (line-wrapped per 80 characters):
```
{".class":"Model","elements":[{".class":"ProcedureDecl","id":{".class":"Id","val
ue":"foo"},"params":[{".class":"ParamDecl","id":{".class":"Id","value":"x"},"ann
otations":[]}],"bodyOpt":[{".class":"ProcedureBody","locals":[],"locations":[{".
class":"BlockLocation","label":{".class":"Id","value":"L1"},"actions":[],"jump":
{".class":"ReturnJump","expOpt":[{".class":"IdExp","id":{".class":"Id","value":"
x"}}],"annotations":[]},"annotations":[]}]}],"annotations":[]}],"annotations":[]
}
```
