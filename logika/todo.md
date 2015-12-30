Logika To-Do
============

* Rework programming logic examples to use subst1 and subst2 whenever applicable

* Implement proof checker

  * Check fact satisfiability first
  
  * Check method pre/post-condition satisfiability
  
* Add helper methods

* Add inductively defined datatypes using trait and case class (with multiple trait inheritance)
  
  * distinguish immutable/mutable case classes
  
  * requires modification on type checker (assignable based on subtyping)
  
    * assignment
    
    * method call
    
    * equality/inequality ops

* Add sequence of trait/class

* Add match statement with pattern matching on trait/class

* Add support for multiple program files (?)