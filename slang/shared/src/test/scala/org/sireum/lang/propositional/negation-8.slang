⊢  p ∨ ¬p
{
  1. {
       2. ¬(p ∨ ¬p)           assume
       3. {
            4. p              assume
            5. p ∨ ¬p         ∨i1 4
            6. ⊥              ¬e 5 2
          }
       7. ¬p                  ¬i 3
       8. p ∨ ¬p              ∨i2 7
       9. ⊥                   ¬e 8 2
     }
 10. p ∨ ¬p                   pbc 1
}