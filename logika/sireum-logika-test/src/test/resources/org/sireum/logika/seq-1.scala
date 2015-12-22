import org.sireum.logika._

val a: ZS = ZS(2, 4, 6, 0)

l"""{ 1. a == ZS(2,4,6,0)                   premise
      2. {
           3. i: Z
           4. {
                5. 0 <= i && i <= 2         assume
                6. a(i) > 1                 algebra 5 1
              }
           5. 0 <= i && i <= 2 -> a(i) > 1  ->i 4
         }
      6. all j: 0 .. 2 | a(j) > 1           alli 2       }"""
a(3) = 5

l"""{ 1. all j: 0 .. 2 | a(j) > 1           premise
      2. a(3) == 5                          premise
      3. {
           4. i: Z
           5. 0 <= i && i <= 2 -> a(i) > 1  alle 1 i
           6. {
                7. 0 <= i && i <= 3         assume
                8. 0 <= i                   &&e1 7
                9. i <= 3                   &&e2 7
               10. {
                    11. i < 3               assume
                    12. i <= 2              algebra 11
                    13. 0 <= i && i <= 2    andi 8 12
                    14. a(i) > 1            ->e 5 13
                   }
               15. {
                    16. i == 3              assume
                    17. a(i) > 1            algebra 16 2
                   }
               // note: <= means < or ==
               18. a(i) > 1                 ore 9 10 15
              }
          19. 0 <= i && i <= 3 -> a(i) > 1  ->i 6
         }
     20. all j: 0 .. 3 | a(j) > 1           alli 3       }"""
val b: ZS = a.clone

l"""{ 1. all j: 0 .. 3 | a(j) > 1           premise
      2. b == a                             premise      }"""
b(0) = 1

l"""{ 1. b(0) == 1                          premise
      2. all j: 0 .. 3 | a(j) > 1           premise
      3. 0 <= 0 && 0 <= 3 -> a(0) > 1       alle 2 0
      4. 0 <= 0                             algebra
      5. 0 <= 3                             algebra
      6. 0 <= 0 && 0 <= 3                   andi 4 5
      7. a(0) > 1                           ->e 3 6      }"""
println(s"$a, $b")
