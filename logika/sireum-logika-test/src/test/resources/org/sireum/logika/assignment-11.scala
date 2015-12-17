import org.sireum.logika._

var hours: Z = 4
l"""{ 1. hours == 4             premise     }"""

val minutes: Z = hours * 60
l"""{ 1. hours == 4             premise
      2. minutes == hours * 60  premise
      3. minutes == 240         algebra 1 2 }"""

hours = 5
l"""{ 1. hours == 5             premise
      2. minutes == 240         premise     }"""
