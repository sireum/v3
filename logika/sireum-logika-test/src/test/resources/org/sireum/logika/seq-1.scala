import org.sireum.logika._

val a: ZS = ZS(2, 4, 6, 0)

l"""{ 1. a == ZS(2,4,6,0)                          premise
      2. {
           3. i
           4. {
                5. 0 <= i && i < 3                 assume
                6. a(i) > 1                        algebra 5 1
              }
           5. 0 <= i && i < 3 -> a(i) > 1          ->i 4
         }
      6. all j: Z | 0 <= j && j < 3 -> a(j) > 1    alli 2       }"""
a(3) = 5

l"""{ 1. all j: Z | 0 <= j && j < 3 -> a(j) > 1    premise
      2. a(3) == 5                                 premise
      3. {
           4. i
           5. 0 <= i && i < 3 -> a(i) > 1          alle 1 i
           6. {
                7. 0 <= i && i <= 3                assume
                8. 0 <= i                          &&e1 7
                9. i <= 3                          &&e2 7
               10. {
                     11. i < 3                     assume
                     12. 0 <= i && i < 3           andi 8 11
                     13. a(i) > 1                  ->e 5 12
                   }
               14. {
                     15. i == 3                    assume
                     16. a(i) > 1                  algebra 15 2
                   }
               // note that <= means < or ==
               17. a(i) > 1                        ||e 9 10 14
              }
          18. 0 <= i && i <= 3 -> a(i) > 1         ->i 6
         }
     19. all j: Z | 0 <= j && j <= 3 -> a(j) > 1   alli 3       }"""
val b: ZS = a.clone

l"""{ 1. all j: Z | 0 <= j && j <= 3 -> a(j) > 1    premise
      2. b == a                                     premise     }"""
b(0) = 1

l"""{ 1. b(0) == 1                                  premise
      2. all j: Z | 0 <= j && j <= 3 -> a(j) > 1    premise
      3. a(0) > 1                                   foralle 2 0 }"""
println(s"$a, $b")
