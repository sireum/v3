∀x human(x) → mortal(x),  ∃y human(y)  ⊢
  ∃z mortal(z)
{
  1. ∀x human(x) → mortal(x)               premise
  2. ∃y human(y)                           premise
  3. {
       4. a
          human(a)                         assume
       5. human(a) → mortal(a)             ∀e 1 a
       6. mortal(a)                        →e 5 4
       7. ∃z mortal(z)                     ∃i 6 a
     }
  8. ∃z mortal(z)                          ∃e 2 3
}