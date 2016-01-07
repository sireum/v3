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

val x: Z = readInt()
val y: Z = readInt()
var max: Z = 0

if (x > y) {

  l"""{  1. x > y                                          premise    }"""
  max = x
  l"""{  1. max == x                                       premise
         2. max >= x                                       algebra 1
         3. x > y                                          premise
         4. max > y                                        subst2 1 3
         5. max >= y                                       algebra 4
         6. max >= x and max >= y                          andi 2 5
         7. (max >= x and max >= y) and max == x           andi 6 1   }"""

} else {

  l"""{  1. not (x > y)                                    premise    }"""
  max = y
  l"""{  1. max == y                                       premise
         2. max >= y                                       algebra 1
         3. not (x > y)                                    premise
         4. y >= x                                         algebra 3
         5. max >= x                                       subst2 1 4
         6. max >= x and max >= y                          andi 5 2
         7. (max >= x and max >= y) and max == y           andi 6 1   }"""
}
l"""{  1. ((max >= x and max >= y) and max == x) or
            ((max >= x and max >= y) and max == y)         premise
       2. {
            3. (max >= x and max >= y) and max == x        assume
            4. max >= x and max >= y                       ande1 3
            5. max == x                                    ande2 3
          }
       6. {
            7. (max >= x and max >= y) and max == y        assume
            8. max >= x and max >= y                       ande1 7
            9. max == y                                    ande2 7
          }
      10. max >= x and max >= y                            ore 1 2 6
      11. max == x or max == y                             ore 1 2 6  }"""
