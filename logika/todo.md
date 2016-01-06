Logika To-Dos
=============

* Support configurable file types

* Add hint mode

* Create website with user manual


Future Work
===========

* Add truth table and logic gates circuit output for propositional logic 

* Add inductively defined datatypes using traits and immutable case classes (with multiple trait inheritance)
 
  * requires modifications on the type checker (assignable based on subtyping)
  
    * assignment
    
    * method call
    
    * equality/inequality ops
    
  * need to gen equality ops for Z3
    
* Add match statement for pattern matching traits/case classes

* create examples such as list, nat, etc. as inductive types and prove their properties (ala Coq)

* Add type inference (boolean, integer, sequence of integer, uninterpreted function) 
  for predicate logic (+ algebra) to enable auto validity checking

* Add first-class (immutable) option, tuple, sequence, set, and map
