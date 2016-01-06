import org.sireum.logika._

var x: Z = 0
l"""{ 1. x == 0     premise
      2. x >= 0     algebra 1 }"""
l"""{ invariant x >= 0        }"""

def f(): Unit = {
  l"""{ modifies x            }"""
  x = -1
  l"""{ 1. x == -1  premise   }"""
  g()
  l"""{ 1. x == 1   premise
        2. x >= 0   algebra 1 }"""
}

@helper def g(): Unit = {
  l"""{ modifies x
        post     x == 1       }"""
  x = 1
  l"""{ 1. x == 1   premise   }"""
}