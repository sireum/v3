/*
Copyright (c) 2016, Robby, Kansas State University
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
   ⊤         22A4      true       T
   ⊥         22A5      false      F       _|_
   ≤         2264      <=
   ≥         2265      >=
   ≠         2260      !=
   ¬         00AC      not        !        ~
   ∧         2227      and        &&       ^
   ∨         2228      or         ||       V
   →         21D2      implies    ->
   ∀         2200      forall     all      A
   ∃         2203      exists     some     E
   ⊢         22A2      |-         ---+
==============================================

Note: ---+ means at least three minus (-) characters
*/

@header {
// @formatter:off
}

file
  : sequent NL* proof? NL* EOF                          #SequentFile
  | program EOF                                         #ProgramFile
  ;

sequent // note: all newlines inside a sequent are whitespaces
  : ( premises+=formula ( ',' premises+=formula )* )?
    ( '|-' | '⊢' )
    conclusions+=formula ( ',' conclusions+=formula )*
  | premises+=formula*
    HLINE
    conclusions+=formula+
  ;

proof: tb='{' proofStep? ( NL+ proofStep? )* te='}' NL* ;

proofStep
  : NUM '.' formula justification                       #Step
  | sub=NUM '.' NL* '{' NL*
    assume=NUM '.'
    ( ID (':' type )?
    | formula ate='assume'
    | ID (':' type )? formula ate='assume' )
    ( NL+ proofStep? )*
    '}'                                                 #SubProof
  ;

formula
  : t=( 'true' | 'T' | '⊤'
      | 'false' | 'F' | '_|_' | '⊥' )                   #Boolean // propositional logic
  | tb=ID ( '.' te=ID /* $te.text=="size" */ )?         #Var     // propositional logic
  | '(' formula ')'                                     #Paren   // propositional logic
  | 'result'                                            #Result  // programming logic
  | ID '(' formula ( ',' formula )* ')'                 #Apply   // predicate logic
  | NUM                                                 #Int     // algebra
  | 'Z' '(' STRING ')'                                  #BigInt  // algebra
  | 'ZS' '(' ( exp ( ',' exp )* )? ')'                  #Seq     // algebra
  | l=formula op=( '*' | '/' | '%' ) NL? r=formula      #Binary  // algebra
  | l=formula op=( '+' | '-' | '+:' ) NL? r=formula     #Binary  // algebra
  | op='-' formula                                      #Unary   // algebra
  | l=formula op=':+' NL? r=formula                     #Binary  // algebra
  | l=formula
    op=( '=' |'==' | '!=' | '≠' ) NL?
    r=formula                                           #Binary  // algebra
  | op=( 'not' | '!' | '~' | '¬' ) formula              #Unary   // propositional logic
  | l=formula
    op=( '<' | '<=' | '≤' | '>' | '>=' | '≥' ) NL?
    r=formula                                           #Binary  // algebra
  | l=formula
    op=( 'and' | '&&' | '^' | '∧' ) NL? r=formula       #Binary  // propositional logic
  | l=formula
    op=( 'or' | '||' | 'V' | '∨' ) NL? r=formula        #Binary  // propositional logic
  | l=formula
    op=( 'implies' | '->' | '→' ) NL? r=formula         #Binary  // propositional logic
  | qformula                                            #Quant   // predicate logic
  ;

qformula
  : q=( 'forall' | 'all' | 'A' | '∀'
      | 'exists' | 'some' | 'E' | '∃' )
    vars+=ID ( ',' vars+=ID )*
    ( ':' type
    | ':' lo=exp ll='<'? '..' lh='<'? hi=exp
    )? '|' NL?
    formula
  ;

type
  : t='B'                                               #BooleanType
  | t='Z'                                               #IntType
  | t='ZS'                                              #IntSeqType
  ;

justification
  : t='premise'                                         #Premise
  | ( tb=('andi' | '^i' ) | tb=( '&&' | '∧' ) ID ) // ID=="i"
    lStep=NUM rStep=NUM                                 #AndIntro
  | ( tb=('ande1' | '^e1' | 'ande2' | '^e2' )
    | tb=( '&&' | '∧' ) ID ) // ID=="e1" or ID=="e2"
    andStep=NUM                                         #AndElim
  | ( tb=( 'ori1' | 'Vi1' | 'ori2' | 'Vi2' )
    | tb=( '||' | '∨' ) ID ) // ID=="i1" or ID=="i2"
    step=NUM                                            #OrIntro
  | ( tb=( 'ore' | 'Ve' )
    | tb=( '||' | '∨' ) ID ) // ID=="e"
    orStep=NUM lSubProof=NUM rSubProof=NUM              #OrElim
  | ( tb='impliesi' | tb=( '->' | '→' ) ID ) // ID=="i"
    subProof=NUM                                        #ImpliesIntro
  | ( tb='impliese' | tb=( '->' | '→' ) ID ) // ID=="e"
    impliesStep=NUM antecedentStep=NUM                  #ImpliesElim
  | ( tb=( 'noti' | 'negi' )
    | tb=( '!' | '~' | '¬' ) ID // ID=="i"
    ) subProof=NUM                                      #NegIntro
  | ( tb='note' | tb='nege'
    | tb=( '!' | '~' | '¬' ) ID // ID=="e"
    ) step=NUM negStep=NUM                              #NegElim
  | ( tb=( 'bottome' | 'falsee' )
    | tb=('_|_' | '⊥' ) ID // ID=="e"
    ) bottomStep=NUM                                    #BottomElim
  | tb='Pbc' subProof=NUM                               #Pbc
  | tb='subst1' eqStep=numOrId step=NUM                 #Subst1
  | tb='subst2' eqStep=numOrId step=NUM                 #Subst2
  | tb='algebra' steps+=numOrId*                        #Algebra
  | ( tb='foralli' | tb='alli' | tb='Ai'
    | tb='∀' ID // ID=="i"
    ) subProof=NUM                                      #ForallIntro
  | ( tb='foralle' | tb='alle' | tb='Ae'
    | tb='∀' ID // ID=="e"
    ) stepOrFact=numOrId formula+                       #ForallElim
  | tb=( 'existsi' | 'somei' | 'Ei' )
    existsStep=NUM formula+                             #ExistsIntro
  | tb=( 'existse' | 'somee' | 'Ee' )
    stepOrFact=numOrId subproof=NUM                     #ExistsElim
  | {"∃".equals(_input.LT(1).getText()) &&
     "i".equals(_input.LT(2).getText())}?
    tb='∃' ID existsStep=NUM formula+                   #ExistsIntro
  | tb='∃' t=ID // ID=="e"
    stepOrFact=numOrId subProof=NUM                     #ExistsElim
  | tb='invariant'                                      #Invariant
  | tb='auto' stepOrFacts+=numOrId*                     #Auto
  ;

numOrId: t=( NUM | ID );

program
  : NL*
    ( tb='import' org=ID '.' sireum=ID '.' 'logika' '.' te='_' NL+
      // org=="org" && sireum="sireum"
      ( 'l"""' facts te='"""' NL* )?
      stmts
    )?
  ;

facts
  : '{' NL*
    ftb='fact' NL*
    factOrFun? ( NL+ factOrFun? )*
    te='}' NL* ;

factOrFun: fact | fun ;

fact: ID '.' formula ;

fun
  : tb='def' ID  NL?
    '(' param ( ',' param )* ')' ':' type
  ;

param: ID ':' type ;

stmts: stmt? ( NL+ stmt? )* ;

stmt
  : modifier=( 'var' | 'val' ) ID ':' type '=' NL? exp  #VarDeclStmt
  | ID '=' NL? exp                                      #AssignVarStmt
  | 'assume' '(' exp ')'                                #AssumeStmt
  | 'assert' '(' exp ')'                                #AssertStmt
  | 'if' '(' exp ')' NL* '{' ts=stmts '}'
     ( 'else' NL* '{' fs=stmts '}' )?                   #IfStmt
  | 'while' '(' exp ')' NL* '{'
    ( NL* 'l"""' loopInvariant '"""' )?
    stmts
    '}'                                                 #WhileStmt
  | op=( 'print' | 'println' )
    '(' SSTRING ')'                                     #PrintStmt
  | tb=ID '(' index=exp ')' '=' NL? r=exp               #SeqAssignStmt
  | ( '@' helper=ID )? 'def' id=ID  NL?
    '(' ( param ( ',' param )* )? ')'
    ':' ( type | 'Unit' ) '=' NL*
    '{'
    ( NL* 'l"""' methodContract NL* '"""' )?
    stmts
    ( rtb='return' exp? NL* )?
    '}'                                                 #MethodDeclStmt
  | 'l"""'
    ( proof
    | sequent
    | invariants
    ) '"""'                                             #LogikaStmt
  | exp                                                 #ExpStmt
  ;

exp
  : t=( 'true' | 'T' | '⊤'
      | 'false' | 'F' | '_|_' | '⊥' )                   #BooleanExp
  | NUM                                                 #IntExp
  | tb=ID
    ( t='(' ( exp ( ',' exp )* )? ')'
    | '.' te=ID // te=="size" or te =="clone"
    )?                                                  #IdExp
  | 'Z' '(' STRING ')'                                  #BigIntExp
  | 'ZS' '(' ( exp ( ',' exp )* )? ')'                  #SeqExp
  | 'randomInt' '(' ')'                                 #RandomIntExp
  | 'readInt' '(' STRING? ')'                           #ReadIntExp
  | '(' exp ')'                                         #ParenExp
  | op=( '-' | '!' ) exp                                #UnaryExp
  | l=exp op=( '*' | '/' | '%' ) NL? r=exp              #BinaryExp
  | l=exp op=( '+' | '-' | '+:' )  NL? r=exp            #BinaryExp
  | l=exp op=':+' NL? r=exp                             #BinaryExp
  | l=exp op=( '>' | '>=' | '<' | '<=' )  NL? r=exp     #BinaryExp
  | l=exp op=( '==' | '!=' )  NL? r=exp                 #BinaryExp
  | l=exp op='&&' NL? r=exp                             #BinaryExp
  | l=exp op='||' NL? r=exp                             #BinaryExp
  ;

loopInvariant
  : tb='{' NL*
    itb='invariant' NL* formula? ( NL+ formula? )*
    modifies
    te='}' NL*
  ;

modifies
  : tb='modifies' ( ID ( ',' ID )* )? NL* ;

methodContract
  : tb='{' NL*
    ( ( 'requires' | 'pre' ) NL*
      rs+=formula ( NL+ rs+=formula? )* )? NL*
    modifies?
    ( ( 'ensures' | 'post' ) NL*
      es+=formula ( NL+ es+=formula? )* )? NL*
    te='}' NL*
  ;

invariants
  : tb='{' NL*
    'invariant' NL* formula? ( NL+ formula? )*
    te='}' NL*
  ;

HLINE: '-' '-' '-'+ ;

NUM: '0' | [1-9] [0-9]* ;

ID: [a-zA-Z] [a-zA-Z0-9_]* ;

SSTRING: 's' STRING ;

STRING: '"' ('\u0020'| '\u0021'|'\u0023' .. '\u007F')* '"' ; // all printable chars and no escape chars

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

LINE_COMMENT: '//' ~[\r\n]* -> channel(1) ;

COMMENT: '/*' .*? '*/' -> channel(1) ;

WS: [ \t\u000C]+ -> skip ;

ERROR_CHAR: . ;
