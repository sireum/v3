import org.sireum.logika._

val x: Z = 1
l"""{ 1. x == 1             premise}"""

val y: Z = 2
l"""{ 1. x == 1             premise
      2. x == 1 ∨ y == 5    ∨i1 1   }"""
