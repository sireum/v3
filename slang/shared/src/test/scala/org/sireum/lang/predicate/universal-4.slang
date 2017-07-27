∀x healthy(x) → happy(x)  ⊢
  (∀y healthy(y)) → ∀x happy(x)
{
  1. ∀x healthy(x) → happy(x)              premise
  2. {
       3. ∀y healthy(y)                    assume
       4. {
            5. a
            6. healthy(a)                  ∀e 3 a
            7. healthy(a) → happy(a)       ∀e 1 a
            8. happy(a)                    →e 7 6
          }
       9. ∀x happy(x)                      ∀i 4
     }
 10. (∀y healthy(y)) → ∀x happy(x)         →i 2
}