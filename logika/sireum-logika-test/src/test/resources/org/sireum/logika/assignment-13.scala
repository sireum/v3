import org.sireum.logika._

var x: Z = readInt()
// the precondition is that x falls in the range, 1,2,..,99

assert(x > 0 && x < 100)
l"""{ 1. x > 0 ∧ x < 100           premise     }"""

x = x + 1
l"""{ 1. x_old > 0 ∧ x_old < 100   premise
      2. x_old > 0                 ∧e1 1
      3. x == x_old + 1            premise
      4. x_old + 1 > 1             algebra 2
      5. x > 1                     algebra 3 4
      6. x_old < 100               ∧e2 1
      7. x_old + 1 < 101           algebra 6
      8. x < 101                   algebra 3 7
      9. x > 1 ∧ x < 101           ∧i 5 8      }"""
// the postcondition is that x falls in the range, 2,3,...,100
