/*
 Copyright (c) 2016, Robby, Kansas State University
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met:

 1. Redistributions of source code must retain the above copyright notice, this
    list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright notice,
    this list of conditions and the following disclaimer in the documentation
    and/or other materials provided with the distribution.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ult, election.size) > count(election, c, election.size)
  }"""

  // create a map of candidate # to the total votes for the candidate (initially zero)
  var tally: ZS = ZS()
  var i: Z = 0
  while (i < numOfCandidates) {
    l"""{ invariant ∀j: (0 ..< tally.size)  tally(j) == 0
                    tally.size == i
          modifies  tally, i }"""
    tally = tally :+ 0  // append 0
    i = i + 1
  }

  // compute the total votes for each candidate
  i = 0
  while (i < election.size) {
    l"""{ invariant ∀c: (0 ..< numOfCandidates)  tally(c) == count(election, c, i)
                    tally.size == numOfCandidates
                    0 ≤ i  ∧  i ≤ election.size
          modifies  tally, i }"""
    val candidate: Z = election(i)
    tally(candidate) = tally(candidate) + 1
    i = i + 1
  }

  // compute the winning candidate based on max votes (can be more than one)
  var max: Z = tally(0)
  var winningCandidate: Z = 0
  i = 1
  while (i < tally.size) {
    l"""{ invariant max == tally(winningCandidate)
                    ∀c: (0 ..< i)
                      winningCandidate ≠ c  →
                        count(election, winningCandidate, election.size) >= count(election, c, election.size)
                    0 ≤ winningCandidate  ∧  winningCandidate < tally.size
                    0 ≤ i  ∧  i ≤ tally.size
          modifies  max, winningCandidate, i }"""
    val t: Z = tally(i)
    if (max < t) {
      max = t
      winningCandidate = i
    }
    i = i + 1
  }

  // detect if there is a tie
  i = 0
  var tied: B = false
  while (i < tally.size & !tied) {
    l"""{ invariant !tied →
                      ∀c: (0 ..< i)
                        winningCandidate ≠ c  →
                          count(election, winningCandidate, election.size) > count(election, c, election.size)
                    0 ≤ i  ∧  i ≤ tally.size
          modifies  tied, i }"""
    if (i != winningCandidate & tally(i) == tally(winningCandidate)) {
      tied = true
    }
    i = i + 1
  }

  // no winner if there is a tie (by returning -1; no option type yet :()
  if (tied) {
    winningCandidate = -1
  }

  return winningCandidate
}

//runPluralityElection(4, ZS())              // Output: -1
//runPluralityElection(4, ZS(0, 2, 3, 3))    // Output: 3
//runPluralityElection(4, ZS(0, 2, 3, 2, 3)) // Output: -1
//runPluralityElection(4, ZS(0, 2, 3, 2))    // Output: 2
