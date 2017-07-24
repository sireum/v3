p → r,  q → r  ⊢  (p ∨ q) → r
{
  1. p → r                    premise
  2. q → r                    premise
  3. {
       4. p ∨ q               assume
       5. {
            6. p              assume
            7. r              →e 1 6
          }
       8. {
            9. q              assume
           10. r              →e 2 9
          }
      11. r                   ∨e 4 5 8
     }
 12. (p ∨ q) → r              →i 3
}