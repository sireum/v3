import org.sireum.logika._

val g: ZS = ZS(2, 4)
l"""{ invariant  g(0) > 0 and g.size >= 1                     }"""

def f(x: Z, y: Z): Z = {
  l"""{ pre      x == 0 and y > x
        modifies g
        post     g(0) > result                                }"""

  l"""{ 1. g(0) > 0 and g.size >= 1              premise
        2. x == 0 and y > x                      premise      }"""
  g(x) = y
  l"""{  1. g(x) == y                            premise
         2. g_old(0) > 0 and g_old.size >= 1     premise
         3. x == 0 and y > x                     premise
         4. g.size == g_old.size                 premise
         5. g_old.size >= 1                      ande2 2
         6. g.size >= 1                          algebra 4 5
         7. x == 0                               ande1 3
         8. y > x                                ande2 3
         9. g(0) == y                            algebra 7 1
        10. g(0) > x                             algebra 9 8
        11. g(0) > 0                             algebra 7 10
        12. g(0) > 0 and g.size >= 1             andi 11 6    }"""
  return x
}
l"""{ 1. 0 == 0                                  algebra
      2. 2 > 0                                   algebra
      3. (0 == 0) and (2 > 0)                    andi 1 2     }"""
f(0, 2)
l"""{ 1. g(0) > 0 and g.size >= 1                invariant
      2. g(0) > 0                                ande1 1      }"""
