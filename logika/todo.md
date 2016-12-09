Logika To-Dos
=============

* Make sure to check non-aliasing for call arguments

* Quan rules check vars

* Add termination

* Auto loop inv at end should not have old

* Document Truth Table mode

* Document SymExe mode 


Future Work
===========

* Def as method

* Def without cond and with where

* Use line # for _old numbering

* Add functions to convert numbers

* Add @record

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
