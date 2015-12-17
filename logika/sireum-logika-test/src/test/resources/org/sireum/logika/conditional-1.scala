import org.sireum.logika._

val x: Z = readInt()
val y: Z = readInt()
var max: Z = 0

if (x > y) {

  l"""{  1. x > y                                          premise     }"""
  max = x
  l"""{  1. max == x                                       premise
         2. max >= x                                       algebra 1
         3. x > y                                          premise
         4. max > y                                        algebra 1 3
         5. max >= y                                       algebra 4
         6. max >= x and max >= y                          andi 2 5
         7. (max >= x and max >= y) and max == x           andi 6 1    }"""

} else {

  l"""{  1. not (x > y)                                    premise     }"""
  max = y
  l"""{  1. max == y                                       premise
         2. max >= y                                       algebra 1
         3. not (x > y)                                    premise
         4. y >= x                                         algebra 3
         5. max >= x                                       algebra 1 4
         6. max >= x and max >= y                          andi 5 2
         7. (max >= x and max >= y) and max == y           andi 6 1    }"""
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
            9. max == y                                    ande2 8
          }
       9. max >= x and max >= y                            ore 1 2 6
      10. max == x or max == y                             ore 1 2 6   }"""
