import org.sireum.logika._

val g: ZS = ZS(0, 0)
l"""{ invariant g(0) == 0          }"""

def f(): Z = {
  l"""{ modifies  g
        ensures   result == 0      }"""

  l"""{ 1. g(0) == 0    premise    }"""
  val ans: Z = g(0)
  l"""{ 1. g(0) == 0    premise
        2. ans == g(0)  premise
        3. ans == 0     subst1 1 2 }"""
  return ans
}
val x: Z = f()
l"""{ 1. x == 0          premise   }"""
