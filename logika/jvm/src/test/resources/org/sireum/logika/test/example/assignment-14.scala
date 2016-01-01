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

var dimes: Z = readInt()
var money: Z = dimes * 10

assert(money == dimes * 10)
l"""{ 1. money == dimes * 10                 premise    }"""

// Say that one more dime shows up:
dimes = dimes + 1
l"""{ 1. dimes == dimes_old + 1              premise
      2. money == dimes_old * 10             premise
      3. dimes_old == dimes - 1              algebra 1
      4. money == (dimes - 1) * 10           subst1 3 2 }"""

// The amount of money is less that what it should be; fix it:
money = money + 10
l"""{ 1. money_old == (dimes - 1) * 10       premise
      2. money == money_old + 10             premise
      3. money_old == money - 10             algebra 2
      4. money - 10 == ((dimes - 1) * 10)    subst1 3 1
      5. money == ((dimes - 1) * 10) + 10    algebra 4
      6. money == dimes * 10                 algebra 5  }"""
