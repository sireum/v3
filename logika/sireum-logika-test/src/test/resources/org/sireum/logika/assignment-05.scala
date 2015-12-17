import org.sireum.logika._

val x: Z = readInt("Enter x: ")

val y: Z = readInt("Enter y (> x): ")

assert(x > y)
l"""{ 1.  x > y      premise     }"""

val max: Z = x
l"""{ 1. max == x    premise
      2. x > y       premise
      3. max >= x    algebra 1
      4. max >= y    algebra 3 2 }"""