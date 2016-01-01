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