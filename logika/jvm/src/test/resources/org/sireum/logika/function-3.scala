import org.sireum.logika._

val pi: Z = 3 // sorry --- the checker handles  ints  only  )-:
var c: Z = 0

def circumference(diameter: Z): Unit = {
  l"""{ requires  diameter >= 0 and pi >= 3
        modifies  c
        ensures   c == pi * diameter   }"""
  c = pi * diameter
}

val d: Z = readInt("Type diameter of a circle: ")
assert(d >= 0)
l"""{ 1. d >= 0              premise
      2. pi == 3             premise
      3. pi >= 3             algebra 2
      4. d >= 0 and pi >= 3  andi 1 3  }"""
// we proved the precondition for circumference
circumference(d)
// we get to assume its postcondition
l"""{ 1.  c == pi * d        premise   }"""
