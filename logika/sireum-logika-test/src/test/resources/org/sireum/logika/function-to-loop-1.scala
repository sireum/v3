import org.sireum.logika._

l"""{ fact
        def f(n: Z): Z
        base. f(0) == 1
        rec.  all x: Z | f(x) == f(x-1) * n        }"""
def factorial(n: Z): Z = {
  l"""{ requires  n >= 0
        ensures   result == f(n)                   }"""
  var ans: Z = 1
  if (n == 0) {
    l"""{ 1. ans == 1               premise
          2. ans == f(0)            subst2 base 1
          3. n == 0                 premise
          4. ans == f(n)            subst2 3 2     }"""
  } else {
    l"""{ 1. not(n == 0)            premise
          2. n >= 0                 premise
          3. n - 1 >= 0             algebra 1 2    }"""
    val sub: Z = factorial(n - 1)
    l"""{ 1. sub == f(n - 1)        premise        }"""
    ans = n * sub
    l"""{ 1. ans == n * sub         premise
          2. sub == f(n-1)          premise
          3. ans == n * f(n-1)      subst1 2 1
          4. ans == f(n-1) * n      algebra 3
          5. f(n) == f(n-1) * n     foralle base n
          6. ans == f(n)            subst2 5 4     }"""
  }
  l"""{ 1.  ans == f(n)             premise        }"""
  return ans
}