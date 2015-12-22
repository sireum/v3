Requirements
============

Supported platforms (64-bit only):

* OS X (tested on El Capitan -- 10.11)

* Linux (tested on Ubuntu 14.04)

* Windows (tested on Windows 7)


All Supported Platforms
-----------------------

* Required tools: `bash`, `git`, `unzip`, `wget`

Windows
-------

* Required tools: [MSYS2](https://msys2.github.io)

  ```bash
  pacman -S git unzip wget
  ```
  
Running Sireum
==============

Run: `./sireum`

(If this is your first time running the script, it first:

* downloads
  [Zulu JDK](https://www.azul.com/products/zulu/), 
  [Node.js](https://nodejs.org/)
  and 
  [Sbt](http://www.scala-sbt.org),
  and then installs them under the `platform` directory;

* downloads
  [Z3](https://github.com/Z3Prover/z3/wiki) 
  and installs it under the `apps` directory; and

* [builds](#building-and-testing-sireum-using-sbt)
  and
  [assembles](#assembling-sireum-jar)
  Sireum.)

```
Sireum: A Software Analysis Platform (v3)
(c) 2011-2015, SAnToS Laboratory, Kansas State University
http://sireum.org

Usage: sireum <mode>

Available mode(s):

java      Java tooling
logika    Logika Proof Checker
pilar     Pilar tooling
util      Utility Tools
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


Sireum Logika
=============

Logika is a natural deduction proof checker for propositional, predicate, and programming logic
developed for teaching [K-State CIS 301: Logical Foundations of Programming](http://proglogics.santoslab.org).

Logika is inspired by:

* The [Natural Deduction Proof Checker (NDPC)](http://people.cis.ksu.edu/~schmidt/301s14/NDPC/ndpc-pe.jar)
  tool ([User's Guide](http://people.cis.ksu.edu/~schmidt/301s14/NDPC/user_manual.pdf)
  for propositional and predicate logic developed by Mr. Brian Mulanda, Dr. Rodney Howell, and 
  Mr. James Thompson.

* The [Floyd-Hoare Program Logic Proof Checker](http://people.cis.ksu.edu/~schmidt/301s14/cis301.zip)
  and the [Programming Logic](http://people.cis.ksu.edu/~schmidt/301s14/Lectures/home.html)
  lecture notes by Professor Emeritus David Schmidt.

Logika is a combination of both tools; it uses the same
[input language](https://github.com/santoslab/sireum-v3/blob/master/logika/sireum-logika-parser-antlr4/src/main/resources/org/sireum/logika/parser/Antlr4Logika.g4)
for reasoning about propositional, predicate, and programming logic (i.e., the propositional logic 
input language is a subset of the predicate logic input language, which in turn, is a subset of the
programming logic input language).
The programming input language is a restricted subset of the Scala programming language that can be
run by using the regular Scala interpreter.

Currently, the propositional and predicate logic proof checker portion of the tool has been fully
implemented; the programming logic checker still requires the following components to be
implemented: (a) proof checker, (b) runtime assertion compiler to regular Scala programs that embed 
contracts as assertions.
The proof checker will make use a high-performing SMT solver such as 
[Z3](https://github.com/Z3Prover/z3).

Some examples are available at the following links:

* [Propositional and predicate logic examples](https://github.com/santoslab/sireum-v3/blob/master/logika/sireum-logika-test/src/main/scala/org/sireum/logika/SequentTestDefProvider.scala)
  (status: **all verified**)

* [Programming logic examples](https://github.com/santoslab/sireum-v3/tree/master/logika/sireum-logika-test/src/test/resources/org/sireum/logika)
  (status: parsed, ast built, symbol resolved, type checked; all examples runnable by the Scala interpreter, requires [Logika runtime lib](https://github.com/santoslab/sireum-v3/blob/master/logika/sireum-logika/src/main/scala/org/sireum/logika/package.scala))

The propositional and predicate logic proof checker can be run via the command line.
Here is an example:
```
¬(¬p ∨ ¬q) ⊢ p ∧ q
{
  1. ¬(¬p ∨ ¬q)         premise
  2. {
       3. ¬p            assume
       4. ¬p ∨ ¬q       ∨i1 3 
       5. ⊥             ¬e 4 1
     }
  6. p                  Pbc 2
  7. {
       8. ¬q            assume
       9. ¬p ∨ ¬q       ∨i2 8 
      10. ⊥             ¬e 9 1
     }
 11. q                  Pbc 7
 12. p ∧ q              ∧i 6 11
}
```
To run Logika, save the above example in a file (e.g., `test.txt`) and then issue the command
(provided that you follow the instructions above to build and run Sireum):
```bash
sireum logika test.txt
```
which will show:
```
Propositional logic proof is accepted.
```
One can specify the sequent to prove as a command line to ensure that the proof in the file is
the one that is expected as follows:
```bash
sireum logika -s "¬(¬p ∨ ¬q) ⊢ p ∧ q" test.txt
```
If the provided sequent is different than the one in the file, the tool rejects it. For example:
```bash
sireum logika -s "p, q ⊢ p ∧ q" test.txt
```
will result:
```
The specified sequent is different than the one in the file.
Specified:
p, q ⊢ p ∧ q
File:
¬(¬p ∨ ¬q) ⊢ p ∧ q
```
If one introduced a bug in the proof, such as using ∨i1 instead of ∨i2 in step #9 in the above example,
Logika will output:
```
[12, 10] The disjunction's left sub-expression in step #9 does not match #8 for Or-intro1.
Propositional logic proof is rejected.
```


Building and Testing Sireum using Sbt
=====================================

Run: `bin/sbt-launch.sh test`

**Warning:** If you use Gradle (on other projects), your Ivy2 cache might be corrupted.
In such case, Sbt will complain about unresolved dependencies, e.g.:

```
...
[warn] 	::::::::::::::::::::::::::::::::::::::::::::::
[warn] 	::          UNRESOLVED DEPENDENCIES         ::
[warn] 	::::::::::::::::::::::::::::::::::::::::::::::
[warn] 	:: junit#junit;4.11: configuration not found in junit#junit;4.11: 'master(compile)'. Missing configuration: 'compile'. It was required from com.novocode#junit-interface;0.11 compile
[warn] 	::::::::::::::::::::::::::::::::::::::::::::::
[warn]
[warn] 	Note: Unresolved dependencies path:
[warn] 		junit:junit:4.11
[warn] 		  +- com.novocode:junit-interface:0.11 (/Users/rvprasad/Workspace/sireum-v3/project/SireumBuild.scala#L163)
[warn] 		  +- org.sireum:sireum-core-test_2.11:3.0-SNAPSHOT ()
...
sbt.ResolveException: unresolved dependency: junit#junit;4.11: configuration not found in junit#junit;4.11: 'master(compile)'. Missing configuration: 'compile'. It was required from com.novocode#junit-interface;0.11 compile
	at sbt.IvyActions$.sbt$IvyActions$$resolve(IvyActions.scala:291)
	at sbt.IvyActions$$anonfun$updateEither$1.apply(IvyActions.scala:188)
	at sbt.IvyActions$$anonfun$updateEither$1.apply(IvyActions.scala:165)
  ...
```

To fix it, you need to delete your Ivy2 cache in, for example, `~/.ivy2/cache` (you can delete only the specific
corrupted library cache such as junit for the example above; in the worst case, delete all cache).

Once you deleted the corrupted cache, run Sbt again and it should work.
You can then check that your Gradle builds still work once Sbt fixed/recreated your Ivy2 cache.


Assembling Sireum Jar
=====================

Run: `bin/sbt-launch.sh assembly`
 
The jar will be located at `jvm/target/scala-2.11/sireum.jar`


Development Environment
=======================

IntelliJ is the recommended IDE for Sireum v3 development.
Jetbrains has graciously provided free licenses for IntelliJ Ultimate for Sireum project members
(claim a license [here](https://docs.google.com/document/d/1YC1KY4qALJ10VoHfF9KAdqP9vGq5v5MlOvGAKKL697U/edit#));
however, you can also use IntelliJ Community Edition.

Download
--------

Since Sireum uses Java 8 and IntelliJ might not run on some Oracle JDK 8 versions,
Jetbrains provided a custom build for IntelliJ that includes a custom OpenJDK 8 build
(this also makes it unnecessary to install system-wide JDK such as Apple Java 6 in OS X):

* Ultimate Edition: http://download.jetbrains.com/idea/ideaIU-15.0.2-custom-jdk-bundled.dmg

* Community Edition: http://download.jetbrains.com/idea/ideaIC-15.0.2-custom-jdk-bundled.dmg

(The download URLs for other platforms are simply the download URLs for regular builds with `-custom-jdk-bundled`
inserted before the file extension.)

Once installed, simply open Sireum v3 in IntelliJ by pointing it to your local Sireum v3 git repository.
Anytime that you are asked for a JDK, point it to `platform/java`.

**Note:** You can opt to use the Zulu JDK that Sireum uses to run IntelliJ instead of IntelliJ's custom JDK.
To do so, exit IntelliJ (if it is running), then, for OS X:

```bash
cd "/Applications/IntelliJ IDEA 15.app/Contents/jre/jdk/Contents"
sudo rm -fR Home
sudo ln -s absolute/path/of/platform/java Home
```

Plugins
-------

You need to install some plugins for Sireum v3 development
(by opening `IntelliJ`->`Preference`->`Plugin` and click "Browse repositories..."):

* .ignore
* ANTLR v4 grammar plugin
* ASM Bytecode Outline
* BashSupport
* gfm
* MultiMarkdown
* Python
* ReStructuredText Support
* SBT ([idea-sbt-plugin](https://github.com/orfjackal/idea-sbt-plugin)) (**see notes below**)
* Scala

Other plugins that you might be interested are:

* ColourChooser
* Compare Directories
* Docker integration
* Haskell
* LaTeX
* MPS BaseLanguage support
* MPS Build languages
* MPS Core
* MPS Version Control support
* nginx Support
* Vagrant

Preferences
-----------

* Set IntelliJ's Sbt’s preferences by opening `IntelliJ`->`Preference`->`Build, Execution, Deployment`->`Build Tools`->`SBT`

  * `Max Heap Size`: `4096`

  * `VM Parameters`: `-XX:+UseG1GC -XX:ReservedCodeCacheSize=900m -Xss1M -XX:+CMSClassUnloadingEnabled`

* IntelliJ uses `make` as the default build system.
  For Scala projects, this means that it often misses some dependencies when compiling Scala codebase.
  To address this, use the SBT ([idea-sbt-plugin](https://github.com/orfjackal/idea-sbt-plugin)) plugin.
  
  * Set `idea-sbt-plugin` settings by opening `IntelliJ`->`Preference`->`Other Settings`->`SBT`

    * `VM parameters`: `-Xmx4G -XX:+UseG1GC -XX:ReservedCodeCacheSize=900m -Xss1M -XX:+CMSClassUnloadingEnabled`

    * Check `Use alternative JRE` and point it to `platform/java`

  * In `Run`->`Edit Configurations...`->`Defaults`->{`Application`, `JUnit`, etc.}:

    * Remove `Make` in `Before launch:`

    * Add `SBT` in `Before launch:` then select either `products` (for apps) or `test:products` (for tests) and
      check `Run in current module...`
      
    * Add `SIREUM_HOME` environment variable and set it to the absolute path of the directory containing this file.


Alternative IDE
---------------
You can also use Eclipse that is shipped in [Sireum v2 Shortcake](http://sireum.org/software.html#shortcake).
Run:
```bash
bin/sbt-eclipse.sh
```
Then, import the existing projects into your Eclipse workspace (after setting up some preferences).
