∀x human(x) → mortal(x),  ∀y mortal(y) → soul(y)  ⊢
  ∀x human(x) → soul(x)
{
  1. ∀x human(x) → mortal(x)               premise
  2. ∀y mortal(y) → soul(y)                premise
  3. {
       4. a
       5. {
            6. human(a)                    assume
            7. human(a) → mortal(a)        ∀e 1 a
            8. mortal(a)                   →e 7 6
            9. mortal(a) → soul(a)         ∀e 2 a
           10. soul(a)                     →e 9 8
          }
      11. human(a) → soul(a)               →i 5
     }
 12. ∀x human(x) → soul(x)                 ∀i 3
}