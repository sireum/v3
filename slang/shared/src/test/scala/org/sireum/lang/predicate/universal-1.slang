∀x human(x) → mortal(x),  human(Socrates)  ⊢
  mortal(Socrates)
{
  1. ∀x human(x) → mortal(x)               premise
  2. human(Socrates)                       premise
  3. human(Socrates) → mortal(Socrates)    ∀e 1 Socrates
  4. mortal(Socrates)                      →e 3 2
}