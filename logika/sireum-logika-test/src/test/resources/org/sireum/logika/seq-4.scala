import org.sireum.logika._

var a: ZS = ZS(2, 4, 6, 0)

l"""{ 1. a == ZS(2, 4, 6, 0)         premise     }"""
a = a :+ 1 // append
l"""{ 1. a == a_old :+ 1             premise
      2. a_old == ZS(2, 4, 6, 0)     premise
      3. a == ZS(2, 4, 6, 0, 1)      algebra 1 2 }"""
a = 3 +: a // prepend
l"""{ 1. a == 3 +: a_old             premise
      2. a_old == ZS(2, 4, 6, 0, 1)  premise
      3. a == ZS(3, 2, 4, 6, 0, 1)   algebra 1 2 }"""