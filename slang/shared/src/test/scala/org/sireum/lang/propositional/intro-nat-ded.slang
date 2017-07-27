p ∨ q, r  ⊢  (p ∧ r) ∨ (q ∧ r)
{
  1. p ∨ q                    premise
  2. r                        premise
  3. {
       4. p                   assume
       5. p ∧ r               ∧i 4 2
       6. (p ∧ r) ∨ (q ∧ r)   ∨i1 5
     }
  7. {
       8. q                   assume
       9. q ∧ r               ∧i 8 2
      10. (p ∧ r) ∨ (q ∧ r)   ∨i2 9
     }
 11. (p ∧ r) ∨ (q ∧ r)        ∨e 1 3 7
}