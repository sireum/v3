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
==============================================
 Symbol     Unicode    ASCII
----------------------------------------------
   ⊥         22A5      _|_        false    F
   ⊤         22A4      true       T
   ≤         2264      <=
   ≥         2265      >=
   ≠         2260      !=
   ¬         00AC      not        !        ~
   ∧         2227      and        &&
   ∨         2228      or         ||
 ⇒  →       21D2      implies    =>      ->
   ∀         2200      forall     all      A
   ∃         2203      exists     some     E
   ⊢         22A2      |-         ---+
==============================================

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
    tb=( '|-' | '⊢' )
    conclusions+=formula ( ',' conclusions+=formula )*
  | premises+=formula*
    tb=HLINE
    conclusions+=formula+
  ;

proof: tb='{' proofStep? ( NL+ proofStep? )* te='}' NL* ;

proofStep
  : tb=NUM '.' formula justification                    #Step
  | sub=NUM '.' NL* '{' NL*
    assume=NUM '.'
    ( fresh=ID
    | fresh=ID? formula 'assume' )
    ( NL+ proofStep )*
    te='}'                                              #SubProof
  ;

formula
  : t=( 'false' | 'F' | '_|_' | '⊥' )                   #False   // propositional logic
  | t=( 'true' | 'T' )                                  #True    // propositional logic
  | tb=ID ( '.' te=SIZE )?                              #Var     // propositional logic
  | tb='(' formula te=')'                               #Paren   // propositional logic
  | t='$result'                                         #Result  // program logic
  | fun=ID '(' formula ( ',' formula )* te=')'          #Apply   // predicate logic
  | t=INT                                               #Int     // algebra
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
    gVars+=ID+ '|' NL? formula
  ;

justification
  : t='premise'                                         #Premise
  | ( tb='andi' | tb=( '&&' | '∧' ) INTRO )
    lStep=NUM rStep=NUM                                 #AndIntro
  | ( tb='ande1' | tb=( '&&' | '∧' ) ELIM1 )
    andStep=NUM                                         #AndElim1
  | ( tb='ande2' | tb=( '&&' | '∧' ) ELIM2 )
    andStep=NUM                                         #AndElim2
  | ( tb='ori1' | tb=( '||' | '∨' ) INTRO1 )
    orStep=NUM                                          #OrIntro1
  | ( tb='ori2' | tb=( '||' | '∨' ) INTRO2 )
    orStep=NUM                                          #OrIntro2
  | ( tb='ore' | tb=( '||' | '∨' ) ELIM )
    orStep=NUM lSubProof=NUM rSubProof=NUM              #OrElim
  | ( tb='impliesi'
    | tb=( '->' | '=>' | '→' | '⇒' ) INTRO )
    impliesStep=NUM                                     #ImpliesIntro
  | ( tb='impliese'
    | tb=( '->' | '=>' | '→' | '⇒' ) ELIM )
    impliesStep=NUM antecedentStep=NUM                  #ImpliesElim
  | ( tb='noti' | tb='negi'
    | tb=( '!' | '~' | '¬' ) INTRO ) subProof=NUM       #NegIntro
  | ( tb='note' | tb='nege'
    | tb=( '!' | '~' | '¬' ) ELIM )
    step=NUM notStep=NUM                                #NegElim
  | tb=( 'falsee' | '_|_' | '⊥' ) ELIM falseStep=NUM    #FalseElim
  | tb='Pbc' subProof=NUM                               #Pbc
  | ( tb='foralli' | tb='alli' | tb='Ai'
    | tb='∀' INTRO ) subProof=NUM                       #ForallIntro
  | ( tb='foralle' | tb='alle' | tb='Ae'
    | tb='∀' ELIM ) stepOrFact=numOrId formula+         #ForallElim
  | ( tb='existsi' | tb='somei' | tb='Ei'
    | tb='∃' INTRO ) existsStep=NUM formula+            #ExistsIntro
  | ( tb='existse' | tb='somee' | tb='Ee'
    | tb='∃' ELIM ) stepOrFact=numOrId subproof=NUM     #Exists
  | tb='algebra' steps+=NUM*                            #Algebra
  | tb='auto' stepOrFacts+=numOrId*                     #Auto
  ;

numOrId: t=(NUM | ID);

program
  : ( tb='import' ORG '.' SIREUM '.' LOGIKA '.' te='_'
    stmts )?
  ;

stmts: stmt? ( NL+ stmt? )* ;

stmt
  : modifier=( 'var' | 'val' ) ID ':' type '=' exp      #VarDeclStmt
  | tb=ID '=' exp                                       #AssignVarStmt
  | tb='assert' '(' exp te=')'                          #AssertStmt
  | tb='if' '(' exp ')' NL* ttb='{' ts=stmts tte='}'
    'else' ftb='{' fs=stmts fte='}'                     #IfStmt
  | tb='while' '(' exp ')' NL* ltb='{'
    ( NL* lgk '"""' NL* loopInvariant NL* '"""' )?
    stmts
    lte='}'                                             #WhileStmt
  | tb=ID '=' 'readInt' '(' STRING? te=')'              #ReadIntStmt
  | op=( 'print' | 'println' ) '(' S STRING te=')'      #PrintStmt
  | ( id=ID '=' )? m=ID '(' ( exp ( ','exp )* )? te=')' #MethodInvocationStmt
  | tb=ID '=' ID '.' te=CLONE                           #SeqCloneStmt
  | tb=ID '(' exp ')' '=' exp                           #SeqAssignStmt
  | id=ID '=' exp op='+:' seq=ID                        #SeqPendStmt
  | id=ID '=' seq=ID op=':+' exp                        #SeqPendStmt
  | methodDecl                                          #MethodDeclStmt
  | lgk '"""' NL*
    ( proof
    | invariants
    | facts      )
    NL* te='"""'                                        #LogikaStmt
  ;

lgk: t=(L | LOGIKA) ;

exp
  : t=( 'true' | 'T' )                                  #TrueExp
  | t=( 'false' | 'F' )                                 #FalseExp
  | t=INT                                               #IntExp
  | tb=ID ( '(' exp te=')' | '.' te=SIZE )?             #IdExp
  | tb=( 'BigInt' | 'Z' ) '(' STRING te=')'             #BigIntExp
  | tb=( 'Seq' | 'Zs' ) '(' exp ( ',' exp )? te=')'     #SeqExp
  | tb='(' exp te=')'                                   #ParenExp
  | op=( '-' | '!' ) exp                                #UnaryExp
  | l=exp op=( '*' | '/' | '%' ) NL? r=exp              #BinaryExp
  | l=exp op=( '+' | '-' )  NL? r=exp                   #BinaryExp
  | l=exp op=( '>' | '>=' | '<' | '<=' )  NL? r=exp     #BinaryExp
  | l=exp op=( '==' | '!=' )  NL? r=exp                 #BinaryExp
  | l=exp ( '&&' ) NL? r=exp                            #BinaryExp
  | l=exp ( '||' ) NL? r=exp                            #BinaryExp
  ;

type
  : t=( 'Boolean' | 'B' )                               #Boolean
  | t=( 'BigInt' | 'Z' )                                #IntType
  | tb='Seq' '[' NL* ( 'BigInt' | 'Z' ) NL* te=']'      #IntSeqType
  | t='Zs'                                              #IntSeqType
  ;

loopInvariant
  : tb='{' NL*
    itb='invariant'
    ( formula? ( NL+ formula? )* )
    modifies
    te='}'
  ;

modifies
  : tb='modifies' ID+ NL* ;

methodDecl
  : tb='def' ID  NL?
    '(' ( param ( ',' param )* )? ')' ':' ( type | 'Unit' ) te='='
    mtb='{'
    ( NL* lgk '"""' NL* methodContract NL* '"""' )?
    stmts
    rtb='return' exp? NL*
    mte='}'
  ;

param: tb=ID ':' type ;

methodContract
  : tb='{' NL*
    ( rtb='requires' NL* formula ( NL+ formula? )* )? NL*
    modifies?
    ( rte='ensures' NL* formula ( NL+ formula? )* )? NL*
    te='}'
  ;

invariants
  : tb='{' NL*
    itb='invariant' NL* formula? ( NL+ formula? )*
    te='}'
  ;

facts
  : tb='{' NL*
    ftb='fact' NL* fact? ( NL+ fact? )*
    te='}' ;

fact: tb=ID '.' qformula ;

HLINE: '-' '-' '-'+ ;

INT: '0' | '-'? [1-9] [0-9]* ;

NUM: '0' | [1-9] [0-9]* ;

ID: [a-zA-Z] [a-zA-Z0-9]* ;

STRING: '"' ('\u0020'| '\u0021'|'\u0023' .. '\u007F')* '"' ; // all printable chars and no escape chars

INTRO: 'i' -> type(ID) ;

INTRO1: 'i1' -> type(ID) ;

INTRO2: 'i2' -> type(ID) ;

ELIM: 'e' -> type(ID) ;

ELIM1: 'e1' -> type(ID) ;

ELIM2: 'e2' -> type(ID) ;

ORG: 'org' -> type(ID) ;

SIREUM: 'sireum' -> type(ID) ;

LOGIKA: 'logika' -> type(ID) ;

L: 'l' -> type(ID) ;

S: 's' -> type(ID);

CLONE: 'clone' -> type(ID) ;

SIZE: 'size' -> type(ID) ;

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

NL: '\r'? '\n' ;
// newlines are processed after lexing according to:
// http://www.scala-lang.org/files/archive/spec/2.11/01-lexical-syntax.html#newline-characters

LINE_COMMENT: '//' ~[\r\n]* -> skip ;

COMMENT: '/*' .*? '*/' -> skip ;

WS: [ \t\u000C]+ -> skip ;

ERROR_CHAR: . ;
