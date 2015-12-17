import org.sireum.logika._

var x: Z = readInt("Enter an integer > 0: ")

assert(x > 0)
l"""{ 1 . x > 0            premise   }"""

x = x + 1
l"""{ 1. x ==  x_old + 1   premise
      2. x_old > 0         premise
      3. x_old + 1 > 1     algebra 2
      4. x > 1             algebra 1 3 }"""
