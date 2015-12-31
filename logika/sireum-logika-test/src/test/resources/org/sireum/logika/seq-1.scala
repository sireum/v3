import org.sireum.logika._

val a: ZS = ZS(2, 4, 6, 0)

l"""{ 1. a == ZS(2,4,6,0)                   premise
      2. {
           3. i: Z
           4. {
                5. 0 <= i && i < 3          assume
                6. 0 <= i                   &&e1 5
                7. i < 3                    &&e2 5
                8. a(i) > 1                 algebra 6 7 1
              }
           9. 0 <= i && i < 3 -> a(i) > 1   ->i 4
         }
     10. all j: 0 ..< 3 | a(j) > 1          alli 2
     11. 0 <= 3                             algebra
     12. 3 < a.size                         algebra 1     }"""
a(3) = 5

l"""{ 1. all j: 0 ..< 3 | a_old(j) > 1      premise
      2. a(3) == 5                          premise
     21. all q_i: 0 ..< a.size |
           q_i != 3 -> a(q_i) == a_old(q_i) premise
     22. a.size == a_old.size               premise
     23. 3 < a_old.size                     premise
      3. {
           4. i: Z
           5. 0 <= i &&
                 i < 3 -> a_old(i) > 1      alle 1 i
           6. {
                7. 0 <= i && i <= 3         assume
                8. 0 <= i                   &&e1 7
                9. i <= 3                   &&e2 7
               10. {
                    11. i < 3               assume
                    12. 0 <= i && i < 3     &&i 8 11
                    13. a_old(i) > 1        ->e 5 12
                    14. 0 <= i &&
                          i < a.size ->
                          (i != 3 ->
                          a(i) == a_old(i)) alle 21 i
                    24. i < a.size          algebra 11 23 22
                    25. 0 <= i &&
                          i < a.size        &&i 8 24
                    26. i != 3 ->
                          a(i) == a_old(i)  ->e 14 25
                    27. i != 3              algebra 11
                    28. a(i) == a_old(i)    ->e 26 27
                    29. a(i) > 1            algebra 13 28
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
     20. all j: 0 .. 3 | a(j) > 1           alli 3
     30. 3 < a.size                         algebra 22 23 }"""
val b: ZS = a.clone

l"""{ 1. all j: 0 .. 3 | a(j) > 1           premise
      2. b == a                             premise
      3. 0 <= 0                             algebra
      4. 3 < a.size                         premise
      5. 0 < b.size                         algebra 4 2 }"""
b(0) = 1

l"""{ 1. b(0) == 1                          premise
      2. all j: 0 .. 3 | a(j) > 1           premise
      3. 0 <= 0 && 0 <= 3 -> a(0) > 1       alle 2 0
      4. 0 <= 0                             algebra
      5. 0 <= 3                             algebra
      6. 0 <= 0 && 0 <= 3                   andi 4 5
      7. a(0) > 1                           ->e 3 6      }"""
println(s"$a, $b")
