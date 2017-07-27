∃s covered(s) ∧ (∃c vowel(c) ∧ holds(s, c)),
(∃x covered(x)) → ¬gameOver  ⊢  ¬gameOver
{
  1. ∃s covered(s) ∧ (∃c vowel(c) ∧ holds(s, c))         premise
  2. (∃x covered(x)) → ¬gameOver                         premise
  3. {
       4. a
          covered(a) ∧ (∃c vowel(c) ∧ holds(a, c))       assume
       5. covered(a)                                     ∧e1 4
       6. ∃x covered(x)                                  ∃i 5 a
     }
  7. ∃x covered(x)                                       ∃e 1 3
  8. ¬gameOver                                           →e 2 7
}