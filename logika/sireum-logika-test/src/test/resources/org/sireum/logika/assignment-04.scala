import org.sireum.logika._

val x: Z = readInt()

val y: Z = x + 1
l"""{ 1. y == x + 1         premise     }"""

val z: Z = x - 1
l"""{ 1. y == x + 1         premise
      2. z == x - 1         premise
      3. x == y - 1         algebra 1
      4. z == (y - 1) - 1   algebra 3 2
      5. z == y - 2         algebra 4   }"""
