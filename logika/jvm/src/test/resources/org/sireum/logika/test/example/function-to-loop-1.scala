/*
 Copyright (c) 2016, Robby, Kansas State University
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met:

 1. Redistributions of source code must retain the above copyright notice, this
    list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright notice,
    this list of conditions and the following disclaimer in the documentation
    and/or other materials provided with the distribution.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.sireum.logika._

l"""{ fact
        def f(n: Z): Z
        base. f(0) == 1
        rec.  all x: Z |
                x > 0 -> f(x) == f(x-1) * x        }"""
def factorial(n: Z): Z = {
  l"""{ requires  n >= 0
        ensures   result == f(n)                   }"""
  var ans: Z = 1
  l"""{ 1. n >= 0                   premise
        2. ans == 1                 premise        }"""
  if (n == 0) {
    l"""{ 1. ans == 1               premise
          2. ans == f(0)            subst2 base 1
          3. n == 0                 premise
          4. ans == f(n)            subst2 3 2     }"""
  } else {
    l"""{ 1. not(n == 0)            premise
          2. n >= 0                 premise
          3. n > 0                  algebra 1 2
          4. n - 1 >= 0             algebra 1 2    }"""
    val sub: Z = factorial(n - 1)
    l"""{ 1. sub == f(n - 1)        premise
          2. n > 0                  premise        }"""
    ans = n * sub
    l"""{ 1. ans == n * sub         premise
          2. sub == f(n-1)          premise
          3. n > 0                  premise
          4. ans == n * f(n-1)      subst1 2 1
          5. ans == f(n-1) * n      algebra 4
          6. n > 0 ->
                f(n) == f(n-1) * n  foralle rec n
          7. f(n) == f(n-1) * n     ->e 6 3
          8. ans == f(n)            subst2 7 5     }"""
  }
  l"""{ 1.  ans == f(n)             premise        }"""
  return ans
}