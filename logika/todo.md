Logika To-Dos
=============

* Change propositional/predicate logic detection to only based on the
  sequent (excluding proof)
  
  - Need to generate errors for usages of forall/exists in propositional
  
* Change SymeExe checker to be compatible with Forward checker

* Add cone of influence in SymExe to optimize validity query

* Add sat/validity query caching in server mode to optimize IVE
  interaction (i.e., remember all queries and their result of previous
  verification, if any)

* Add concrete evaluation to optimize SymExe

* Add unrolling SymExe

* Document SymExe mode 


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
