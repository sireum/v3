import org.sireum.logika._

def test(x: Z): Unit = {
  l"""{
    requires  x > 0
    ensures   x >= 0
  }"""
}