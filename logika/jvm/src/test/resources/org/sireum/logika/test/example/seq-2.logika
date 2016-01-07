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

val g: ZS = ZS(2, 4)
l"""{ 1. g == ZS(2, 4)                           premise
      2. g(0) > 0                                algebra 1
      3. g.size >= 1                             algebra 1
      4. g(0) > 0 and g.size >= 1                andi 2 3    }"""
l"""{ invariant  g(0) > 0 and g.size >= 1                    }"""

def f(x: Z, y: Z): Z = {
  l"""{ pre      x == 0 and y > x
        modifies g
        post     g(0) > result                               }"""

  l"""{ 1. g(0) > 0 and g.size >= 1              premise
        2. x == 0 and y > x                      premise
        3. x == 0                                ande1 2
        4. 0 <= x                                algebra 3
        5. g.size >= 1                           ande2 1
        6. x < g.size                            algebra 3 5 }"""
  g(x) = y
  l"""{  1. g(x) == y                            premise
         2. g_old(0) > 0 and g_old.size >= 1     premise
         3. x == 0 and y > x                     premise
         4. g.size == g_old.size                 premise
         5. g_old.size >= 1                      ande2 2
         6. g.size >= 1                          subst2 4 5
         7. x == 0                               ande1 3
         8. y > x                                ande2 3
         9. g(0) == y                            subst1 7 1
        10. g(0) > x                             subst2 9 8
        11. g(0) > 0                             subst1 7 10
        12. g(0) > 0 and g.size >= 1             andi 11 6   }"""
  return x
}
l"""{ 1. 0 == 0                                  algebra
      2. 2 > 0                                   algebra
      3. (0 == 0) and (2 > 0)                    andi 1 2    }"""
f(0, 2)
l"""{ 1. g(0) > 0 and g.size >= 1                invariant
      2. g(0) > 0                                ande1 1     }"""
