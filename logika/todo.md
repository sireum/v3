Logika To-Do
============

* Make return keyword optional 

* Add helper methods that do not require and ensure invariants

* Add randomInt() and randomInt(lo: Z, hi: Z)

* Add inductively defined datatypes using traits and immutable case classes (with multiple trait inheritance)
 
  * requires modifications on the type checker (assignable based on subtyping)
  
    * assignment
    
    * method call
    
    * equality/inequality ops
    
  * need to gen equality ops for Z3
    
* Add match statement for pattern matching traits/case classes

* create examples such as list, nat, etc. as inductive types and prove their properties (ala Coq)

* Add type inference (boolean, integer, sequence of integer, uninterpreted function) 
  for predicate logic + algebra sequent to enable auto validity checking

* Add support for multiple program files
  
* Add first-class (immutable) option, tuple, sequence, set, and map
