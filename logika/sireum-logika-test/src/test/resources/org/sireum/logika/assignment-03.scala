import org.sireum.logika._

val x: Z = 0
l"""{ 1. x == 0        premise     }"""

val y: Z = 2 + x
l"""{ 1. x == 0        premise
      2. y == 2 + x    premise     }"""


val z: Z = 2 + x
l"""{ 1. y == 2 + x    premise
      2. z == 2 + x    premise
      3. z == y        algebra 1 2 }"""
