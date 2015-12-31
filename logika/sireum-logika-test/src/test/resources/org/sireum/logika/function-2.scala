import org.sireum.logika._

def absValue(x: Z): Z = {
  l"""{ requires  x != 0
        ensures   result > 0           }"""

  var ans: Z = 0
  if (x < 0) {
    l"""{ 1. x != 0        premise
          2. x < 0         premise     }"""
    ans = -x
    l"""{ 1. x < 0         premise
          2. ans == -x     premise
          3. ans + x == 0  algebra 2
          4. x < ans + x   subst2 3 1
          5. ans > 0       algebra 4   }"""
  } else {
    l"""{ 1. x != 0        premise
          2. not (x < 0)   premise
          3. x >= 0        algebra 2
          4. x > 0         algebra 1 3 }"""
    ans = x
    l"""{ 1. ans == x      premise
          2. x > 0         premise
          3. ans > 0       subst2 1 2  }"""
  }
  l"""{ 1. ans > 0         premise     }"""
  return ans
}

val n: Z = readInt()
if (n != 0) {
  l"""{ 1. n != 0          premise     }"""
  val m: Z = absValue(n)
  l"""{ 1. m > 0           premise     }"""
}