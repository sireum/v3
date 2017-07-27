∀x gt(inc(x), x),  ∀x gt(x, dec(x))  ⊢
  ∀x gt(inc(x), x) ∧ gt(x, dec(x))
{
  1. ∀x gt(inc(x), x)                      premise
  2. ∀x gt(x, dec(x))                      premise
  3. {
       4. a
       5. gt(inc(a), a)                    ∀e 1 a
       6. gt(a, dec(a))                    ∀e 2 a
       7. gt(inc(a), a) ∧ gt(a, dec(a))    ∧i 5 6
     }
  8. ∀x gt(inc(x), x) ∧ gt(x, dec(x))      ∀i 3
}