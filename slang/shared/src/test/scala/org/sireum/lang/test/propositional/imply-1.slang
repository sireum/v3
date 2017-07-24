(p ∧ q) → r,  p → q,  p  ⊢  r
{
  1. (p ∧ q) → r              premise
  2. p → q                    premise
  3. p                        premise
  4. q                        →e 2 3
  5. p ∧ q                    ∧i 3 4
  6. r                        →e 1 5
}