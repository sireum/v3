# Notes on Slang Syntax

## ``<ST-INTERP>``


The string-template interpolator ``st"``...``"`` (single-line) or 
``st"""``...``""`` (multi-line) provide a lightweight 
string-template functionality similar to 
[StringTemplate](http://stringtemplate.org), except it uses
Slang as the templating language for template conditionals 
(if-else expressions) and definitions (as functions), etc.; 
thus, symbol definitions are compiler checked.

In essence, they behave similarly to 
``s"``...``"`` or ``s"""``...``"""`` with ``.stripMargin``, 
except they create ``ST`` objects instead of ``String``, and 
a ``String`` object will be constructed upon calling ``.render`` 
on a ``ST`` object (i.e., lazy ``String`` construction); 
this avoids possibly expensive (intermediate) ``String`` creations 
when nesting string-template interpolations. 

Similar to [StringTemplate](http://stringtemplate.org), 
nested indentations will be automatically computed and rendered 
based on template argument columns.
Moreover, a sequence of template arguments (with an optional 
associated argument separator) can be specified.

### Example

```scala
import org.sireum._

val className = "Foo"

val barBody = 5

val bar =
  st"""def bar =
      |  $barBody"""                 // preceeding whitespaces and | after a newline are stripped (if any)

println(bar)

println()

println(bar.render)

println()

def barrF[T](s: ISZ[T]): ST = {
  return st"""def barr =
             |  $s"""                // a sequence of value (separated by default by the empty string "")
}

val barr = barrF(ISZ(3, 4))

println(barr)

println()

println(barr.render)

println()

val foo =
  st"""class $className {
      |  ${(ISZ(bar, barr), "\n")}   // a sequence of Templates separated by "\n"
      |}"""                          // (bar and barr are indented with the column of $ as the baseline)

println(foo)

println()

println(foo.render)
```

#### Output (compiled w/ ``-Yrangepos``)

```
  st"""def bar =
      |  $barBody"""

def bar =
  5

         st"""def barr =
             |  $s"""

def barr =
  34

  st"""class $className {
      |  ${(ISZ(bar, barr), "\n")}   // a sequence of Templates separated by "\n"
      |}"""

class Foo {
  def bar =
    5
  def barr =
    34   // a sequence of Templates separated by "\n"
}
```

#### Output (compiled w/o ``-Yrangepos``)

```
st"..."

def bar =
  5

st"..."

def barr =
  34

st"..."

class Foo {
  def bar =
    5
  def barr =
    34   // a sequence of Templates separated by "\n"
}
```