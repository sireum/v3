Logika To-Do
============

* Add helper methods that do not assume and prove invariants 

* Add inductively defined datatypes using trait and case class (with multiple trait inheritance)
  
  * distinguish immutable/mutable case classes
  
  * examples: list, nat, ...

  * requires modifications on the type checker (assignable based on subtyping)
  
    * assignment
    
    * method call
    
    * equality/inequality ops
  
* Add sequence of trait/class

* Add match statement with pattern matching on trait/class

* Add type inference (B, Z, ZS) for predicate logic to enable auto validity sequent checking

* Add support for multiple program files