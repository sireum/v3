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
val n: Z = readInt("Type a non-negative int: ")
assert(n >= 0)
l"""{ 1. n >= 0                  premise           }"""
var i: Z = 0
var r: Z = 1
l"""{ 1. i == 0                  premise
      2. r == 1                  premise
      3. r == f(i)               algebra 1 2 base
      4. i >= 0                  algebra 1         }"""
while (i != n) {
  l"""{ invariant  r == f(i)
                   i >= 0
        modifies i, r                              }"""
  l"""{ 1. i != n                premise
        2. r == f(i)             premise
        3. i >= 0                premise           }"""
  i = i + 1
  l"""{ 1. i == i_old + 1        premise
        2. i_old >= 0            premise
        3. i_old == i - 1        algebra 1
        4. r == f(i_old)         premise
        5. r == f(i-1)           subst1 3 4
        6. i > 0                 algebra 1 2       }"""
  r = r * i
  l"""{ 1. r == r_old * i        premise
        2. r_old == f(i-1)       premise
        3. i > 0                 premise
        4. r == f(i-1) * i       algebra 2 1
        5. i > 0 ->
             f(i) == f(i-1) * i  foralle rec i
        6. f(i) == f(i-1) * i    ->e 5 3
        7. r == f(i)             subst2 6 4
        8. i >= 0                algebra 3         }"""
}

l"""{ 1. not(i != n)             premise
      2. i == n                  algebra 1
      3. r == f(i)               premise
      4. r == f(n)               subst1 2 3        }"""
println(s"$n, $r")