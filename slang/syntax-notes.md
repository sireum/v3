# Notes on Slang Syntax

## ``<TEMPLATE-INTERP>``

The template interpolator ``st"``...``"`` (single-line) or 
``st"""``...``""`` (multi-line) behave similarly to 
``s"``...``"`` or ``s"""``...``"""``, except they create 
Template objects instead of String. 

A String object will be constructed upon calling ``.render`` 
on a Template object; this avoids possibly expensive 
(intermediate) String creations when nesting template 
interpolations. 

In addition, nested indentation will be automatically computed 
template argument columns.

A sequence of template arguments (with an optional 
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

val barr =
  st"""def barr =
      |  ${ISZ(3, 4)}"""             // a sequence of value (separated by default by the empty string "")

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

println()
```

#### Output (compiled w/ ``-Yrangepos``)

```
st"""def bar =
        |  $barBody"""

def bar =
  5

st"""def barr =
        |  ${ISZ(3, 4)}"""

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
Template

def bar =
  5

Template

def barr =
  34

Template

class Foo {
  def bar =
    5
  def barr =
    34   // a sequence of Templates separated by "\n"
}
```