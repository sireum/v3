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
        def sum(a: ZS, i: Z): Z
        base. all a: ZS | sum(a, 0) == 0
        rec.  all a: ZS |
                all n: Z |
                  sum(a, n + 1) == sum(a, n) + a(n)      }"""
def add(a: ZS): Z = {
  l"""{ post   result == sum(a, a.size)                  }"""

  var answer: Z = 0

  l"""{ 1. answer == 0                      premise
        2. sum(a, 0) == 0                   alle base a
        3. answer == sum(a, 0)              subst2 2 1   }"""
  var i: Z = 0

  l"""{ 1. answer == sum(a, 0)              premise
        2. i == 0                           premise
        3. answer == sum(a, i)              subst2 2 1
        4. 0 <= a.size                      algebra
        5. i <= a.size                      subst2 2 4
        6. 0 <= i                           algebra 2    }"""
  while (i != a.size) {
    l"""{ invariant  answer == sum(a, i)
                     0 <= i
                     i <= a.size
          modifies   answer, i                           }"""

    l"""{ 1. answer == sum(a, i)            premise
          2. 0 <= i                         premise
          3. i <= a.size                    premise
          4. i != a.size                    premise
          5. i < a.size                     algebra 3 4  }"""
    answer = answer + a(i)
    l"""{ 1. answer == answer_old + a(i)    premise
          2. answer_old == sum(a, i)        premise
          3. answer == sum(a, i) + a(i)     algebra 2 1
          4. sum(a,i+1) == sum(a,i) + a(i)  alle rec a i
          5. answer == sum(a, i+1)          subst2 4 3
          6. i < a.size                     premise
          7. 0 <= i                         premise      }"""

    i = i + 1
    l"""{ 1. answer == sum(a, i_old+1)      premise
          2. i == i_old + 1                 premise
          3. answer == sum(a, i)            subst2 2 1
          4. 0 <= i_old                     premise
          5. 0 <= i                         algebra 2 4
          6. i_old < a.size                 premise
          7. i <= a.size                    algebra 2 6  }"""
  }
  l"""{ 1. answer == sum(a,i)               premise
        2. not (i != a.size)                premise
        3. i == a.size                      algebra 2
        4. answer == sum(a, a.size)         subst1 3 1   }"""
  return answer
}