import org.sireum.logika._

val hours: Z = readInt("Type an int > 2: ")

assert(hours > 2)
l"""{ 1. hours > 2                premise     }"""

val minutes: Z = hours * 60
l"""{ 1. hours > 2                premise
      2. minutes == hours * 60    premise
      3. minutes > 120            algebra 1 2 }"""
