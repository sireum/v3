vowel(e),  holds(square14, e)  ⊢
  ∃y vowel(y) ∧ ∃x holds(x, y)
{
  1. vowel(e)                              premise
  2. holds(square14, e)                    premise
  3. ∃x holds(x, e)                        ∃i 2 square14
  4. vowel(e) ∧ ∃x holds(x, e)             ∧i 1 3
  5. ∃y vowel(y) ∧ ∃x holds(x, y)          ∃i 4 e
}