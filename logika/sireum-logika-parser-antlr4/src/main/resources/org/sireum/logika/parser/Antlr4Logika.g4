/*
Copyright (c) 2015, Robby, Kansas State University
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

grammar Antlr4Logika;

/*
========================================
Symbol    Unicode    ASCII
----------------------------------------
  ⊥        22A5      _|_      false  F
  ⊤        22A4      true     T
  ≤        2264      <=
  ≥        2265      >=
  ≠        2260      !=
  ¬        00AC      not      !      ~
  ∧        2227      and      &&
  ∨        2228      or       ||
  ⇒        21D2      implies  =>
  →        2192      implies  ->
  ∀        2200      forall   all    A
  ∃        2203      exists   some   E
  ⊢        22A2      |-       ---+
========================================

Note: ---+ means at least three minus (-) characters
*/

@header {
// @formatter:off
}

sequentFile: sequent proof? NL* EOF ;

proofFile: proof EOF ;

programFile: program EOF ;

sequent // note: all newlines inside a sequent are whitespaces
  : ( premises+=formula ( ',' premises+=formula )* )?
    ( '|-' | '⊢' )
    conclusions+=formula ( ',' conclusions+=formula )*
  | premises+=formula*
    HLINE
    conclusions+=formula+
  ;

proof: '{' proofStep? ( NL+ proofStep? )* '}' ;

proofStep
  : NUM '.' formula justification                       #Step
  | sub=NUM '.' '{' NL*
    assume=NUM '.'
    ( fresh=ID
    | fresh=ID? formula 'assume' )
    ( NL+ proofStep )*
    '}'                                                 #SubProof
  ;

formula
  : ( 'false' | 'F' | '_|_' | '⊥' )                     #False   // propositional logic
  | ( 'true' | 'T' )                                    #True    // propositional logic
  | ID                                                  #Var     // propositional logic
  | '(' formula ')'                                     #Paren   // propositional logic
  | '$result'                                           #Result  // program logic
  | fun=ID '(' formula ( ',' formula )* ')'             #Apply   // predicate logic
  | INT                                                 #Int     // algebra
  | l=formula op=( '*' | '/' | '%' ) NL? r=formula      #Binary  // algebra
  | l=formula op=( '+' | '-' ) NL? r=formula            #Binary  // algebra
  | l=formula
    op=( '<' | '<=' | '≤' | '>' | '>=' | '≥' ) NL?
    r=formula                                           #Binary  // algebra
  | l=formula
    op=( '=' |'==' | '!=' | '≠' ) NL?
    r=formula                                           #Binary  // algebra
  | op='-' formula                                      #Unary   // algebra
  | op=( 'not' | '!' | '~' | '¬' ) formula              #Unary   // propositional logic
  | l=formula ( 'and' | '&&' | '∧' ) NL? r=formula      #Binary  // propositional logic
  | l=formula ( 'or' | '||' | '∨' ) NL? r=formula       #Binary  // propositional logic
  | l=formula ( 'implies' | '->' | '=>' | '→' | '⇒' )
    NL? r=formula                                       #Binary  // propositional logic
  | qformula                                            #Quant   // predicate logic
  ;

qformula
  : q=( 'forall' | 'all' | 'A' | '∀'
      | 'exists' | 'some' | 'E' | '∃' )
    qVars+=ID ( ',' qVars+=ID )*
    '|' NL?
    formula
  ;

justification
  : 'premise'                                           #Premise
  | ( 'andi' | ( '&&' | '∧' ) INTRO )
    lStep=NUM ',' rStep=NUM                             #AndIntro
  | ( 'ande1' | ( '&&' | '∧' ) ELIM1 )
    andStep=NUM                                         #AndElim1
  | ( 'ande2' | ( '&&' | '∧' ) ELIM2 )
    andStep=NUM                                         #AndElim2
  | ( 'ori1' | ( '||' | '∨' ) INTRO1 )
    orStep=NUM                                          #OrIntro1
  | ( 'ori2' | ( '||' | '∨' ) INTRO2 )
    orStep=NUM                                          #OrIntro2
  | ( 'ore' | ( '||' | '∨' ) ELIM )
    orStep=NUM ',' lSubProof=NUM ',' rSubProof=NUM      #OrElim
  | ( 'impliesi' | ( '->' | '=>' | '→' | '⇒' ) INTRO )
    impliesStep=NUM                                     #ImpliesIntro
  | ( 'impliese' | ( '->' | '=>' | '→' | '⇒' ) ELIM )
    impliesStep=NUM ',' antecedentStep=NUM              #ImpliesElim
  | ( 'noti' | ( '!' | '~' | '¬' ) INTRO )
    subProof=NUM                                        #NegIntro
  | ( 'note' | ( '!' | '~' | '¬' ) ELIM )
    step=NUM ',' notStep=NUM                            #NegElim
  | ( 'falsee' | '_|_' | '⊥' ) ELIM falseStep=NUM       #FalseElim
  | 'Pbc' subProof=NUM                                  #Pbc
  | ( 'foralli' | 'alli' | 'Ai' | '∀' INTRO )
    subProof=NUM                                        #ForallIntro
  | ( 'foralle' | 'alle' | 'Ae' | '∀' ELIM )
    stepOrFact=numOrId ',' args=formulae                #ForallElim
  | ( 'existsi' | 'somei' | 'Ei' | '∃' INTRO )
    existsStep=NUM ',' args=formulae                    #ExistsIntro
  | ( 'existse' | 'somee' | 'Ee' | '∃' ELIM )
    stepOrFact=numOrId ',' subproof=NUM                 #Exists
  | 'algebra' steps=nums?                               #Algebra
  | 'auto' stepOrFacts=numOrIds?                         #Auto
  ;

INTRO: 'i' -> type(ID) ;

INTRO1: 'i1' -> type(ID) ;

INTRO2: 'i2' -> type(ID) ;

ELIM: 'e' -> type(ID) ;

ELIM1: 'e1' -> type(ID) ;

ELIM2: 'e2' -> type(ID) ;

nums: NUM ( ',' NUM )* ;

numOrIds: numOrId ( ',' numOrId )* ;

numOrId: NUM | ID ;

formulae: formula ( ',' formula )* ;

program
  : 'import' ORG '.' SIREUM '.' LOGIKA '.' '_'
    stmts
  ;

ORG: 'org' -> type(ID) ;

SIREUM: 'sireum' -> type(ID) ;

LOGIKA: 'logika' -> type(ID) ;

stmts: stmt? ( NL+ stmt? )* ;

stmt
  : modifier=( 'var' | 'val' ) ID ':' type '=' exp      #VarDeclStmt
  | ID '=' exp                                          #AssignVarStmt
  | 'assert' '(' exp ')'                                #AssertStmt
  | 'if' '(' exp ')' NL* '{' ts=stmts '}'
    'else' '{' fs=stmts '}'                             #IfStmt
  | 'while' '(' exp ')' NL* '{'
    ( NL* 'l' '"""' NL* loopInvariant NL* '"""' )?
    stmts
    '}'                                                 #WhileStmt
  | ID '=' READINT '(' STRING? ')'                      #ReadIntStmt
  | op=( PRINT | PRINTLN ) '(' 's' STRING ')'           #PrintStmt
  | ( id=ID '=' )? m=ID '(' ( exp ( ','exp )* )? ')'    #MethodInvocationStmt
  | ID '=' ID '.' CLONE                                 #SeqCloneStmt
  | ID '(' exp ')' '=' exp                              #SeqAssignStmt
  | id=ID '=' exp op='+:' seq=ID                        #SeqPendStmt
  | id=ID '=' seq=ID op=':+' exp                        #SeqPendStmt
  | methodDecl                                          #MethodDeclStmt
  | 'l' '"""' NL*
    ( proof
    | sequent
    | invariants
    | facts      )
    NL* '"""'                                           #LogikaStmt
  ;

READINT: 'readInt' -> type(ID);

PRINT: 'print' -> type(ID);

PRINTLN: 'println' -> type(ID);

CLONE: 'clone' -> type(ID) ;

exp
  : 'true'                                              #TrueExp
  | 'false'                                             #FalseExp
  | INT                                                 #IntExp
  | ID ( '(' exp ')' | '.' SIZE )?                      #IdExp
  | 'BigInt' '(' STRING ')'                             #BigIntExp
  | 'Seq' '(' exp ( ',' exp )? ')'
    ( '(' exp ')' | '.' SIZE )?                         #SeqExp
  | '(' exp ')' ( '(' exp ')' | '.' SIZE )?             #ParenExp
  | op=( '-' | '!' ) NL? exp                            #UnaryExp
  | l=exp op=( '*' | '/' | '%' ) NL? r=exp              #BinaryExp
  | l=exp op=( '+' | '-' )  NL? r=exp                   #BinaryExp
  | l=exp op=( '>' | '>=' | '<' | '<=' )  NL? r=exp     #BinaryExp
  | l=exp op=( '==' | '!=' )  NL? r=exp                 #BinaryExp
  | l=exp ( '&&' ) NL? r=exp                            #BinaryExp
  | l=exp ( '||' ) NL? r=exp                            #BinaryExp
  ;

SIZE: 'size' -> type(ID) ;

type
  : 'Boolean'                                           #Boolean
  | 'BigInt'                                            #IntType
  | 'Seq' '[' NL* 'BigInt' NL* ']'                      #IntSeqType
  ;

loopInvariant
  : '{' NL*
    'invariant' formula? ( NL+ formula? )*
    modifies NL*
    '}'
  ;

modifies
  : 'modifies' ID ( ',' ID )* ;

methodDecl
  : 'def' ID  NL?
    '(' ( param ( ',' param )* )? ')' ':' ( type | 'Unit' ) '='
    '{'
    ( NL* 'l' '"""' NL* methodContract NL* '"""' )?
    stmts
    'return' exp? NL*
    '}'
  ;

param: ID ':' type ;

methodContract
  : '{' NL*
    ( 'requires' formula )? NL*
    modifies? NL*
    ( 'ensures' formula )? NL*
    '}'
  ;

invariants: '{' NL* 'invariant' formula? ( NL+ formula? )* '}' ;

facts: '{' NL* 'fact' fact? ( NL+ fact? )* '}' ;

fact: ID '.' qformula ;

HLINE: '-' '-' '-'+ ;

INT: '0' | '-'? [1-9] [0-9]* ;

NUM: '0' | [1-9] [0-9]* ;

ID: [a-zA-Z] [a-zA-Z0-9]* ;

STRING: '"' ('\u0020'| '\u0021'|'\u0023' .. '\u007F')* '"' ; // all printable chars and no escape chars

LINE_COMMENT: '//' ~[\r\n]* -> skip ;

COMMENT: '/*' .*? '*/' -> skip ;

NL: '\r'? '\n' ;
// newlines are processed after lexing according to:
// http://www.scala-lang.org/files/archive/spec/2.11/01-lexical-syntax.html#newline-characters

WS: [ \t\u000C]+ -> skip ;

RESERVED
  : 'abstract' | 'case' | 'catch' | 'class'
  | 'do' | 'extends' | 'final'
  | 'finally' | 'for' | 'forSome' | 'implicit'
  | 'lazy' | 'macro' | 'match' | 'new'
  | 'null' | 'object' | 'override' | 'package' | 'private'
  | 'protected' | 'sealed' | 'super' | 'this'
  | 'throw' | 'trait' | 'try' | 'type'
  | 'with' | 'yield'
  | '<-' | '<:' | '<%' | '>:' | '#' | '@'
  ;

ERROR_CHAR: . ;
