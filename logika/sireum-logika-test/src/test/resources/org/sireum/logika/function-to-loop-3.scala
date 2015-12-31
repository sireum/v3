import org.sireum.logika._

l"""{ fact
        def f(n: Z): Z
        base. f(0) == 1
        rec.  all x: Z |
                x > 0 -> f(x) == f(x-1) * x         }"""
def factorial(n: Z): Z = {
  l"""{ requires  n >= 0
        ensures   result == f(n)                    }"""
  l"""{ 1. n >= 0                  premise          }"""
  var i: Z = 0
  l"""{ 1. i == 0                  premise          }"""
  var r: Z = 1
  l"""{ 1. i == 0                  premise
        2. r == 1                  premise
        3. r == f(i)               algebra 1 2 base
        4. i >= 0                  algebra 1        }"""
  while (i != n) {
    l"""{ invariant  r == f(i)
                     i >= 0
          modifies i, r                             }"""
    l"""{ 1. i != n                premise
          2. r == f(i)             premise
          3. i >= 0                premise          }"""
    i = i + 1
    l"""{ 1. i == i_old + 1        premise
        2. i_old >= 0              premise
        3. i_old == i - 1          algebra 1
        4. r == f(i_old)           premise
        5. r == f(i-1)             subst1 3 4
        6. i > 0                   algebra 1 2      }"""
    r = r * i
    l"""{ 1. r == r_old * i        premise
        2. r_old == f(i-1)         premise
        3. i > 0                   premise
        4. r == f(i-1) * i         algebra 2 1
        5. i > 0 ->
             f(i) == f(i-1) * i    foralle rec i
        6. f(i) == f(i-1) * i      ->e 5 3
        7. r == f(i)               subst2 6 4
        8. i >= 0                  algebra 3        }"""
  }
  l"""{ 1. not(i != n)             premise
        2. i == n                  algebra 1
        3. r == f(i)               premise
        4. r == f(n)               subst1 2 3       }"""
  return r
}