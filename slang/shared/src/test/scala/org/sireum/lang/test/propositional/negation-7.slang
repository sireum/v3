¬(¬p ∨ ¬q)  ⊢  p ∧ q
{
  1. ¬(¬p ∨ ¬q)               premise
  2. {
       3. ¬p                  assume
       4. ¬p ∨ ¬q             ∨i1 3
       5. ⊥                   ¬e 4 1
     }
  6. p                        pbc 2
  7. {
       8. ¬q                  assume
       9. ¬p ∨ ¬q             ∨i2 8
      10. ⊥                   ¬e 9 1
     }
 11. q                        pbc 7
 12. p ∧ q                    ∧i 6 11
}