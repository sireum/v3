p → ¬q  ⊢  ¬(p ∧ q)
{
  1. p → ¬q                   premise
  2. {
       3. p ∧ q               assume
       4. p                   ∧e1 3
       5. q                   ∧e2 3
       6. ¬q                  →e 1 4
       7. ⊥                   ¬e 5 6
     }
  8. ¬(p ∧ q)                 ¬i 2
}                                    