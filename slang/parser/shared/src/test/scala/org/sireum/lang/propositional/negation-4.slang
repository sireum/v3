p, q → ¬p  ⊢  ¬q
{
  1. p                        premise
  2. q → ¬p                   premise
  3. {
       4. q                   assume
       5. ¬p                  →e 2 4
       6. ⊥                   ¬e 1 5
     }
  7. ¬q                       ¬i 3
}