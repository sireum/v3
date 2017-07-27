vowel(e),  holds(square14, e)  ⊢
  ∃y,x vowel(y) ∧ holds(x, y)
{
  1. vowel(e)                              premise
  2. holds(square14, e)                    premise
  3. vowel(e) ∧ holds(square14, e)         ∧i 1 2
  4. ∃y,x vowel(y) ∧ holds(x, y)           ∃i 3 e, square14
}