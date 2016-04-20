/*
 Copyright (c) 2016, Robby, Galois Inc. and Kansas State University
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

 * Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

 * Neither the names of the copyright holders nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

// Adaptation of https://github.com/cjerdonek/formal-rcv/blob/master/src/Plurality.v

import org.sireum.logika._

l"""{ fact
        // count is a proof function that given
        // * cElection -- an election votes (as an integer array where
        //   each integer represents a vote for a candidate #),
        // * cCandidate -- a candidate (as an integer representing the
        //   candidate #), and
        // * cN -- a number in 0 .. cElection.size,
        // it totals the number of votes for the candidate at indices 0 .. N - 1.
        // The behavior of count is specified as axioms (recursive)
        def count(cElection: ZS, cCandidate: Z, cN: Z): Z
          base. ∀ce: ZS  ∀cc: Z  count(ce, cc, 0) == 0
          rec.  ∀ce: ZS  ∀cc: Z  ∀ cj: (1 .. ce.size)
                  (ce(cj - 1) == cc  →  count(ce, cc, cj) == count(ce, cc, cj - 1) + 1) ∧
                  (ce(cj - 1) ≠ cc  →  count(ce, cc, cj) == count(ce, cc, cj - 1))
}"""
def runPluralityElection(numOfCandidates: Z, election: ZS): Z = {
  l"""{ requires numOfCandidates ≥ 0
                 ∀j: (0 ..< election.size)  election(j) >= 0  ∧  election(j) < numOfCandidates
        ensures  (0 ≤ result  ∧  result < numOfCandidates)  →
                   ∀c: (0 ..< numOfCandidates)
                     result ≠ c  →
                       count(election, result, election.size) > count(election, c, election.size)
                 numOfCandidates == 0  →  result < 0
                 result < 0 ∧ numOfCandidates ≠ 0 →  // TODO: spec need more inspection
                  (∃c1: (0 ..< numOfCandidates)
                     (∃c2: (0 ..< numOfCandidates)
                        (c1 ≠ c2 →
                           (count(election, c1, election.size) == count(election, c2, election.size)))))
  }"""

  // create a map of candidate # to the total votes for the candidate (initially zero)
  // no direct array creation for a given size yet :-(
  var tally: ZS = ZS()
  var i: Z = 0
  while (i < numOfCandidates) {
    l"""{ invariant ∀j: (0 ..< tally.size)  tally(j) == 0
                    tally.size == i
                    0 ≤ i  ∧  i ≤ numOfCandidates
          modifies  tally, i }"""
    tally = tally :+ 0 // append 0
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
  // no winner by default (by returning -1); no option type yet :-(
  var winningCandidate: Z = -1
  if (numOfCandidates > 0) {
    winningCandidate = 0
    var max: Z = tally(0)
    i = 1
    while (i < tally.size) {
      l"""{ invariant max == tally(winningCandidate)
                      ∀c: (0 ..< numOfCandidates)  tally(c) == count(election, c, election.size)
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
      l"""{ invariant ¬tied →
                        ∀c: (0 ..< i)
                          winningCandidate ≠ c  →
                            count(election, winningCandidate, election.size) > count(election, c, election.size)
                      tied →
                        ∃c: (0 ..< i)
                          winningCandidate ≠ c  →
                            count(election, winningCandidate, election.size) == count(election, c, election.size)
                      ∀c: (0 ..< tally.size)
                        winningCandidate ≠ c  →
                          count(election, winningCandidate, election.size) >= count(election, c, election.size)
                      0 ≤ i  ∧  i ≤ tally.size
                      0 ≤ winningCandidate  ∧  winningCandidate < tally.size
          modifies  tied, i }"""
      if (i != winningCandidate & tally(i) == tally(winningCandidate)) {
        tied = true
      }
      i = i + 1
    }

    // no winner if there is a tie
    if (tied) {
      winningCandidate = -1
    }
  }

  return winningCandidate
}

//runPluralityElection(4, ZS())              // Output: -1
//runPluralityElection(4, ZS(0, 2, 3, 3))    // Output: 3
//runPluralityElection(4, ZS(0, 2, 3, 2, 3)) // Output: -1
//runPluralityElection(4, ZS(0, 2, 3, 2))    // Output: 2
