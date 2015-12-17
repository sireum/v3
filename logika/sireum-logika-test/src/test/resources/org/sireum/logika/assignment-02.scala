import org.sireum.logika._

val x: Z = 0
l"""{ 1. x == 0       premise     }"""

val y: Z = 2 + x
l"""{ 1. y == 2 + x   premise
      2. x == 0       premise
      3. y == 2 + 0   algebra 1 2 }"""