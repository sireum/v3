import org.sireum.logika._

val g: ZS = ZS(0, 0)
l"""{ 1. g == ZS(0, 0)  premise
      2. 0 < g.size     algebra 1
      3. g(0) == 0      algebra 1  }"""
l"""{ invariant
        0 < g.size
        g(0) == 0                  }"""

def f(): Z = {
  l"""{ modifies  g
        ensures   result == 0      }"""

  l"""{ 1. g(0) == 0    premise
        2. 0 < g.size   premise
        3. 0 <= 0       algebra    }"""
  val ans: Z = g(0)
  l"""{ 1. g(0) == 0    premise
        2. ans == g(0)  premise
        3. 0 < g.size   premise
        4. ans == 0     subst1 1 2 }"""
  return ans
}
val x: Z = f()
l"""{ 1. x == 0          premise   }"""
