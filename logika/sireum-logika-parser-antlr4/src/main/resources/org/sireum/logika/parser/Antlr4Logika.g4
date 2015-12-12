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


@header {
// @formatter:off
}


sequent
  : ( premises+=formula ( ',' premises+=formula )* )?
    '|-'
    conclusions+=formula ( ',' conclusions+=formula )*
  ;

proof
  : '{' proofStep* '}'
  ;

proofStep
  : NUM '.' formula justification                       #Step
  | '{'
    NUM '.'
    ( fresh=ID
    | fresh=ID? formula 'assume'
    )
    proofStep*
    '}'                                                 #SubProof
  ;

formula
  : '_|_'                                               #Bottom  // propositional logic
  | ID                                                  #Var     // propositional logic
  | '(' formula ')'                                     #Paren   // propositional logic
  | '$result'                                           #Result  // program logic
  | fun=ID '(' formula ( ',' formula )* ')'             #Apply   // predicate logic
  | INT                                                 #Int     // algebra
  | l=formula op=( '*' | '/' | '%' ) r=formula          #Binary  // algebra
  | l=formula op=( '+' | '-' ) r=formula                #Binary  // algebra
  | l=formula op=( '>' | '>=' | '<' | '<=' ) r=formula  #Binary  // algebra
  | l=formula op=( '==' | '!=' ) r=formula              #Binary  // algebra
  | op='-' formula                                      #Unary   // algebra
  | op=NOT formula                                      #Unary   // propositional logic
  | l=formula AND r=formula                             #Binary  // propositional logic
  | l=formula OR r=formula                              #Binary  // propositional logic
  | l=formula IMPLIES r=formula                         #Binary  // propositional logic
  | qformula                                            #Quant   // predicate logic
  ;

qformula
  : q=( FORALL | EXISTS )
    qVar+=ID ( ',' qVar+=ID )* '|' formula
  ;

justification
  : 'premise'                                           #Premise
  | ANDI lStep=NUM rStep=NUM                            #AndIntro
  | ANDE1 andStep=NUM                                   #AndElim1
  | ANDE2 andStep=NUM                                   #AndElim2
  | ORI1 orStep=NUM                                     #OrIntro1
  | ORI2 orStep=NUM                                     #OrIntro2
  | ORE orStep=NUM lSubProof=NUM rSubProof=NUM          #OrElim
  | IMPLIESI impliesStep=NUM                            #ImpliesIntro
  | IMPLIESE impliesStep=NUM                            #ImpliesElim
  | NOTI step=NUM                                       #NegIntro
  | NOTE step=NUM notStep=NUM                           #NegElim
  | '_|_e' bottomStep=NUM                               #BottomElim
  | 'Pbc' subProof=NUM                                  #Pbc
  | FORALLI subProof=NUM                                #ForallIntro
  | FORALLE stepOrFact=numOrId args+=numOrId+           #ForallElim
  | EXISTSI stepOrFact=numOrId args+=ID+                #ExistsIntro
  | EXISTSE existsStep=NUM subproof=NUM                 #Exists
  | 'algebra' steps+=NUM*                               #Algebra
  | 'auto' stepOrFact+=numOrId*                         #Auto
  ;

numOrId
  : NUM
  | ID
  ;

program
  : 'import' org=ID '.' sireum=ID '.' logika=ID '.' '_'
    stmt*
  ;

stmt
  : access=( 'var' | 'val' ) ID ':' type '=' exp        #VarDeclStmt
  | ID '=' exp                                          #AssignVarStmt
  | 'assert' '(' exp ')'                                #AssertStmt
  | 'if' '(' exp ')' '{' ( ts+=stmt )* '}'
    'else' '{' (fs+=stmt )* '}'                         #IfStmt
  | 'while' '(' exp ')' '{'
    ( 'l' '"""' loopInvariant '"""' )?
    stmt*
    '}'                                                 #WhileStmt
  | ID '=' 'readInt' '(' STRING? ')'                    #ReadIntStmt
  | 'println' '(' ( ID ( ',' ID )* )? ')'               #PrintStmt
  | ( l=ID '=' )? r=ID '(' ( exp ( ','exp )* )? ')'     #MethodInvocationStmt
  | ID '=' ID '.' 'clone'                               #ArrayCloneStmt
  | ID '(' exp ')' '=' exp                              #AssignArrayStmt
  | methodDecl                                          #MethodDeclStmt
  | 'l' '"""'
    ( proof
    | sequent
    | invariants
    | facts
    ) '"""'                                             #LogikaStmt
  ;

exp
  : ID                                                  #IdExp
  | INT                                                 #IntExp
  | 'BigInt' '(' STRING ')'                             #BigIntExp
  | 'Seq' '(' exp ( ',' exp )? ')'                      #SeqExp
  | '(' exp ')'                                         #ParenExp
  | op=( '-' | '!' ) exp                                #UnaryExp
  | l=exp op=( '*' | '/' | '%' ) r=exp                  #BinaryExp
  | l=exp op=( '+' | '-' ) r=exp                        #BinaryExp
  | l=exp op=( '>' | '>=' | '<' | '<=' ) r=exp          #BinaryExp
  | l=exp op=( '==' | '!=' ) r=exp                      #BinaryExp
  | l=exp ( '&&' ) r=exp                                #BinaryExp
  | l=exp ( '||' ) r=exp                                #BinaryExp
  ;

type
  : 'BigInt'                                            #IntType
  | 'Seq' '[' 'BigInt' ']'                              #IntSeqType
  ;

loopInvariant
  : '{'
    'invariant' formula
    modifies
    '}'
  ;

modifies
  : 'modifies' ( ID* | ID ( ',' ID )* )
  ;

methodDecl
  : 'def' ID
    '(' ( param ( ',' param )* )? ')' ':' type '='
    '{'
    ( 'l' '"""' methodContract '"""' )?
    stmt*
    'return' exp?
    '}'
  ;

param
  : ID ':' type
  ;

methodContract
  : '{'
    ( 'requires' formula )?
    modifies?
    ( 'ensures' formula )?
    '}'
  ;

invariants
  : '{' 'invariant' formula+ '}'
  ;

facts
  : '{' 'fact' fact+ '}'
  ;

fact
  : ID '.' qformula
  ;

sequentFile
  : sequent proof? EOF
  ;

proofFile
  : proof EOF
  ;

programFile
  : program EOF
  ;


NOT
  : 'not' | '~' | '!'
  ;

AND
  : 'and' | '^' | '&&'
  ;

OR
  : 'or' | 'v' | '||'
  ;

IMPLIES
  : 'implies' | '=>'| '==>' | '-->'
  ;

FORALL
  : 'forall' | 'all' | 'A' | '∀' // Unicode 2200
  ;

EXISTS
  : 'exists' | 'some' | 'E' | '∃' // Unicode 2203
  ;

ANDI
  : 'andi' | '^i' | '&&i'
  ;

ANDE1
  : 'ande1' | '^e1' | '&&e1'
  ;

ANDE2
  : 'ande2' | '^e2' | '&&e2'
  ;

ORI1
  : 'ori1' | 'vi1' | '||i1'
  ;

ORI2
  : 'ori2' | 'vi2' | '||i2'
  ;

ORE
  : 'ore' | 've' | '||e'
  ;

IMPLIESI
  : 'impliesi' | '=>i' | '==>i' | '-->i'
  ;

IMPLIESE
  : 'impliese' | '=>e' | '==>e' | '-->e'
  ;

NOTI
  : 'noti' | '~i' | '!i'
  ;

NOTE
  : 'note' | '~e' | '!e'
  ;

FORALLI
  : 'foalli' | 'alli' | 'Ai' | '∀i'
  ;

FORALLE
  : 'foalle' | 'alle' | 'Ae' | '∀e'
  ;

EXISTSI
  : 'existsi' | 'somei' | 'Ei' | '∃i'
  ;

EXISTSE
  : 'existse' | 'somee' | 'Ee' | '∃e'
  ;

INT
  : '0' | '-'? [1-9] [0-9]*
  ;

NUM
  : '0' | [1-9] [0-9]*
  ;

ID
  : [a-zA-Z] [a-zA-Z0-9]*
  ;

STRING
  : '"' ('\u0020'| '\u0021'|'\u0023' .. '\u007F')* '"' // all printable chars and no escape chars
  ;

LINE_COMMENT
  : '//' ~[\r\n]* -> skip
  ;

COMMENT
  : '/*' .*? '*/' -> skip
  ;

WS
  : [ \r\n\t\u000C]+ -> skip
  ;

ERROR_CHAR
  : .
  ;
