// For You To Do:
// - revise deposit's pre-condition to "amount > 0" and re-prove deposit's contract
// - define withdraw's contract (pre/post-conditions, and return clause)
// - prove that withdraw satisfies the pre/post-conditions and global invariant

import org.sireum.logika._

var balance: Z = 0
var elite: B = false
val eliteMin: Z = 1000000 // $1M is the minimum balance for elite members

l"""{ 1. balance == 0                            premise
      2. elite == false                          premise
      3. balance ≥ 0                             algebra 1
      4. ¬elite                                  algebra 2
      5. ¬elite ∨ balance ≥ eliteMin             ori1 4      }"""

l"""{ invariant
        balance ≥ 0
        ¬elite ∨ balance ≥ eliteMin                          }"""

// note that balance_in is the initial value of balance at the function entry point
def deposit(amount: Z): B = {
  l"""{ requires  amount ≥ 0
        modifies  balance, elite
        ensures   balance_in == balance - amount  }"""

  l"""{ 1. amount ≥ 0                            premise
        2. balance == balance_in                 premise
        3. balance ≥ 0                           premise
        4. ¬elite ∨ balance ≥ eliteMin           premise     }"""
  balance = balance + amount

  l"""{ 1.  balance == balance_old + amount      premise
        2.  balance_old ≥ 0                      premise
        3.  ¬elite ∨ balance_old ≥ eliteMin      premise
        4.  balance_old == balance_in            premise
        5.  amount ≥ 0                           premise
        6.  balance_old == balance - amount      algebra 1
        7.  balance_in == balance - amount       algebra 6 4
        8.  balance - amount ≥ 0                 algebra 6 2
        9.  balance ≥ 0                          algebra 8 5 }"""
  if (balance >= eliteMin) {

    l"""{ 1. balance ≥ 0                         premise
          2. balance_in == balance - amount      premise
          3. balance ≥ eliteMin                  premise     }"""
    elite = true
    l"""{ 1. balance ≥ 0                         premise
          2. balance_in == balance - amount      premise
          3. balance ≥ eliteMin                  premise
          4. ¬elite ∨ balance ≥ eliteMin         ∨i2 3       }"""

  } else {

    l"""{ 1. balance ≥ 0                         premise
          2. balance_in == balance - amount      premise     }"""
    elite = false
    l"""{ 1. balance ≥ 0                         premise
          2. balance_in == balance - amount      premise
          3. elite == false                      premise
          4. ¬elite                              algebra 3
          5. ¬elite ∨ balance ≥ eliteMin         ∨i1 4       }"""
  }

  l"""{ 1. balance_in == balance - amount        premise
        2. balance ≥ 0                           premise
        3. ¬elite ∨ balance ≥ eliteMin           premise     }"""
  return elite
}

/*
def withdraw(amount: Z): B = {
  l"""{ modifies  balance, elite                             }"""

  balance = balance - amount

  if (balance >= eliteMin) {
    elite = true
  } else {
    elite = false
  }

  return elite
}
*/