¬p  ⊢  p → q
{
  1. ¬p                       premise
  2. {
       3. p                   assume
       4. ⊥                   ¬e 3 1
       5. q                   ⊥e 4
     }
  6. p → q                    →i 2
}