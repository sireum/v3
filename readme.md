# Sireum: A Software Analysis Platform (v3)

[![Build Status](https://api.shippable.com/projects/569e46641895ca44747022a7/badge/master)](https://app.shippable.com/projects/569e46641895ca44747022a7)

[Simplified BSD License](license.md)


## Available Products

* [Sireum Logika: A Natural Deduction Proof Checker for Propositional, Predicate, and Programming Logics](http://logika.sireum.org)


## Requirements

Supported platforms (64-bit only):

* OS X (test platform: El Capitan -- 10.11)

* Linux (test platform: Ubuntu 14.04)

* Windows (test platform: Windows 10)


### All Supported Platforms

* Required tools: `bash`, `git`, `unzip`, `wget`

### Windows

* Required tools: [MSYS2](https://msys2.github.io)

  ```bash
  pacman -S git unzip wget
  ```
  
## Installing Sireum

* Using HTTPS:

  ```bash
  git clone https://github.com/sireum/v3.git sireum-v3
  ```

* Using SSH:
 
  ```bash
  git clone git@github.com:sireum/v3.git sireum-v3
  ```

## Running Sireum

Run:

```bash
sireum-v3/sireum
```

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
(c) 2011-2016, SAnToS Laboratory, Kansas State University
http://sireum.org

Usage: sireum <mode>

Available mode(s):

java      Java tooling
logika    Logika Proof Checker
pilar     Pilar tooling
util      Utility Tools
```

The rest of this document assumes `sireum` refers to `sireum-v3/sireum`.

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

## Building and Testing Sireum using Sbt

Run: `sireum-v3/bin/sbt-launch.sh test`

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
[warn] 		  +- com.novocode:junit-interface:0.11 (.../Workspace/sireum-v3/project/SireumBuild.scala#L163)
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


## Assembling Sireum Jar

Run: `sireum-v3/bin/sbt-launch.sh assembly`
 
The jar will be located at `sireum-v3/bin/sireum.jar`


## Development Environment

[IntelliJ IDEA](https://www.jetbrains.com/idea/) 
is the recommended IDE for Sireum v3 development.
JetBrains has graciously provided free licenses for IntelliJ Ultimate for Sireum project members
(claim a license [here](https://docs.google.com/document/d/1YC1KY4qALJ10VoHfF9KAdqP9vGq5v5MlOvGAKKL697U/edit#));
however, you can also use IntelliJ Community Edition.

### Download

JetBrains provides IntelliJ that includes a custom OpenJDK 8 build
(this also makes it unnecessary to install system-wide JDK such as Apple Java 6 in OS X):

* Ultimate Edition: http://download.jetbrains.com/idea/ideaIU-15.0.2-custom-jdk-bundled.dmg

* Community Edition: http://download.jetbrains.com/idea/ideaIC-15.0.2-custom-jdk-bundled.dmg

(The download URLs for other platforms are simply the download URLs for regular builds with `-custom-jdk-bundled`
inserted before the file extension.)

Once installed, simply open Sireum v3 in IntelliJ by pointing it to your local Sireum v3 git repository
(see [IntelliJ's doc](https://www.jetbrains.com/idea/help/getting-started-with-sbt.html#import_project)).
Anytime that you are asked for a JDK, point it to `sireum-v3/platform/java`
(note: you need to run Sireum at least once).

**Note:** You can opt to use the Zulu JDK that Sireum uses to run IntelliJ instead of IntelliJ's custom JDK.
To do so, exit IntelliJ (if it is running), then, for OS X:

```bash
cd "/Applications/IntelliJ IDEA 15.app/Contents/jre/jdk/Contents"
sudo rm -fR Home
sudo ln -s /absolute/path/of/sireum-v3/platform/java Home
```

### Plugins

You need to install some plugins for Sireum v3 development
(by opening `IntelliJ`->`Preference`->`Plugin` and click "Browse repositories..."):

* .ignore
* ANTLR v4 grammar plugin
* ASM Bytecode Outline
* BashSupport
* Batch Scripts Support
* CMD
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
* LaTeX

### Setting Preferences

* Set IntelliJ's Sbt’s preferences by opening `IntelliJ`->`Preference`->`Build, Execution, Deployment`->`Build Tools`->`SBT`

  * `Max Heap Size`: `4096`

  * `VM Parameters`: `-XX:+UseG1GC -XX:ReservedCodeCacheSize=900m -Xss1M -XX:+CMSClassUnloadingEnabled`

* IntelliJ uses `make` as the default build system.
  For Scala projects, it is best to Sbt using the ([idea-sbt-plugin](https://github.com/orfjackal/idea-sbt-plugin)) plugin.
  
  * Set `idea-sbt-plugin` settings by opening `IntelliJ`->`Preference`->`Other Settings`->`SBT`

    * `VM parameters`: `-Xmx4G -XX:+UseG1GC -XX:ReservedCodeCacheSize=900m -Xss1M -XX:+CMSClassUnloadingEnabled`

    * Check `Use alternative JRE` and point it to `platform/java`

  * In `Run`->`Edit Configurations...`->`Defaults`->{`Application`, `JUnit`, etc.}:

    * Remove `Make` in `Before launch:`

    * Add `SBT` in `Before launch:` then select either `products` (for apps) or `test:products` (for tests) and
      check `Run in current module...`
      
    * Add `SIREUM_HOME` environment variable and set it to the absolute path of the directory containing this file.


### Alternative IDE

You can also use Eclipse that is shipped in [Sireum v2 Shortcake](http://sireum.org/software.html#shortcake).
Run:
```bash
sireum-v3/bin/sbt-eclipse.sh
```
Then, import the existing projects into your Eclipse workspace (after setting up some preferences).
