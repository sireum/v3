import org.sireum.logika._

var dimes: Z = readInt()
var money: Z = dimes * 10

assert(money == dimes * 10)
l"""{ 1. money == dimes * 10                 premise   }"""

// Say that one more dime shows up:
dimes = dimes + 1
l"""{ 1. dimes == dimes_old + 1              premise
      2. money == dimes_old * 10             premise
      3. dimes_old == dimes - 1              algebra 1
      4. money == (dimes - 1) * 10           algebra 3 2 }"""

// The amount of money is less that what it should be; fix it:
money = money + 10
l"""{ 1. money_old == (dimes - 1) * 10       premise
      2. money == money_old + 10             premise
      3. money_old == money - 10             algebra 2
      4. money - 10 == ((dimes - 1) * 10)    algebra 3 1
      5. money == ((dimes - 1) * 10) + 10    algebra 4
      6. money == dimes * 10                 algebra 5 }"""
