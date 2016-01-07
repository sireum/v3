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
