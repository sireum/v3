Logika To-Dos
=============

* Document programming logic input language

* Add well-formed-ness check for predicate logic

* Ensure transitivity of modifies clause checking


Future Work
===========

* Add automatic check of propositional and predicate logic sequents

* Add option to specify default range for integers

* Add truth table input language and checker, e.g.,

  ```
            *
  -------------- 
   p  q | p ∧ q 
  --------------
   T  T |   T  
   T  F |   F
   F  T |   F
   F  F |   F
  --------------
  Contingent
    T on (T, T)
    F on (T, F), (F, T), (F, F)
  Valid
  ```
  
* Add logic gates circuit output for propositional logic 

* Add jago tactic

* Add inductively defined datatypes using traits and immutable case classes (with multiple trait inheritance)
 
  * requires modifications on the type checker (assignable based on subtyping)
  
    * assignment
    
    * method call
    
    * equality/inequality ops
    
    * etc.
    
  * need to gen equality ops on complex types for Z3
    
* Add match statement for pattern matching traits/case classes

* create examples such as list, nat, etc. as inductive types and prove their properties (ala Coq)

* Add first-class (immutable) option, tuple, sequence, set, and map
