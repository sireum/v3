p ∨ q,  ¬p  ⊢  q
{
  1. p ∨ q                    premise
  2. ¬p                       premise
  3. {
       4. p                   assume
       5. ⊥                   ¬e 4 2
       6. q                   ⊥e 5
     }
  7. {
       8. q                   assume
     }
  9. q                        ∨e 1 3 7
}