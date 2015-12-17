import org.sireum.logika._

val x: Z = 1
val y: Z = 5

assert(x == 1 && y == 5)
l"""{ 1. x == 1 ∧ y == 5   premise
      2. x == 1            ∧e1 1
      3. y == 5            ∧e1 1   }"""
