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

val a: ZS = ZS(2, 4, 6, 0)

l"""{ 1. a == ZS(2,4,6,0)                               premise
      2. {
           3. i: Z
           4. {
                5. 0 <= i && i < 3                      assume
                6. 0 <= i                               &&e1 5
                7. i < 3                                &&e2 5
                8. a(i) > 1                             algebra 6 7 1
              }
           9. 0 <= i && i < 3 -> a(i) > 1               ->i 4
         }
     10. all j: 0 ..< 3 | a(j) > 1                      alli 2
     11. 0 <= 3                                         algebra
     12. 3 < a.size                                     algebra 1        }"""
a(3) = 5

l"""{ 1. all j: 0 ..< 3 | a_old(j) > 1                  premise
      2. a(3) == 5                                      premise
      3. all q_i: 0 ..< a.size |
           q_i != 3 -> a(q_i) == a_old(q_i)             premise
      4. a.size == a_old.size                           premise
      5. 3 < a_old.size                                 premise
      6. {
           7. i: Z
           8. 0 <= i && i < 3 -> a_old(i) > 1           alle 1 i
           9. {
               10. 0 <= i && i <= 3                     assume
               11. 0 <= i                               &&e1 10
               12. i <= 3                               &&e2 10
               13. {
                    14. i < 3                           assume
                    15. 0 <= i && i < 3                 &&i 11 14
                    16. a_old(i) > 1                    ->e 8 15
                    17. 0 <= i && i < a.size ->
                          (i != 3 -> a(i) == a_old(i))  alle 3 i
                    18. i < a.size                      algebra 14 4 5
                    19. 0 <= i && i < a.size            &&i 11 18
                    20. i != 3 -> a(i) == a_old(i)      ->e 17 19
                    21. i != 3                          algebra 14
                    22. a(i) == a_old(i)                ->e 20 21
                    23. a(i) > 1                        algebra 22 16
                   }
               24. {
                    25. i == 3                          assume
                    26. a(i) > 1                        algebra 25 2
                   }
               // note: <= means < or ==
               27. a(i) > 1                             ore 12 13 24
              }
          28. 0 <= i && i <= 3 -> a(i) > 1              ->i 9
         }
     29. all j: 0 .. 3 | a(j) > 1                       alli 6
     30. 3 < a.size                                     algebra 4 5      }"""
val b: ZS = a.clone

l"""{ 1. all j: 0 .. 3 | a(j) > 1                       premise
      2. b == a                                         premise
      3. 0 <= 0                                         algebra
      4. 3 < a.size                                     premise
      5. 0 < b.size                                     algebra 4 2      }"""
b(0) = 1

l"""{ 1. b(0) == 1                                      premise
      2. all j: 0 .. 3 | a(j) > 1                       premise
      3. 0 <= 0 && 0 <= 3 -> a(0) > 1                   alle 2 0
      4. 0 <= 0                                         algebra
      5. 0 <= 3                                         algebra
      6. 0 <= 0 && 0 <= 3                               andi 4 5
      7. a(0) > 1                                       ->e 3 6          }"""
println(s"$a, $b")
