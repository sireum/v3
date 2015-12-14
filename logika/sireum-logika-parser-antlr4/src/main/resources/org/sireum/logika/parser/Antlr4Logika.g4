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
  ∀        2200      forall   all    A
  ∃        2203      exists   some   E
  ⊢        22A2      |-       ---+
========================================

Note: ---+ means at least three minus (-) characters
*/

@header {
// @formatter:off
}

sequentFile
  : sequent proof? EOF ;

proofFile
  : proof EOF ;

programFile
  : program EOF ;

sequent
  : ( premises+=formula ( ',' premises+=formula )* )?
    ( '|-' | '⊢' )
    conclusions+=formula ( ',' conclusions+=formula )*
  | premises+=formula*
    HLINE
    conclusions+=formula+
  ;

proof
  : '{' proofStep* '}' ;

proofStep
  : NUM '.' formula justification                       #Step
  | sub=NUM '.' '{'
    assume=NUM '.'
    ( fresh=ID
    | fresh=ID? formula 'assume' )
    proofStep*
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
  | l=formula op=( '*' | '/' | '%' ) r=formula          #Binary  // algebra
  | l=formula op=( '+' | '-' ) r=formula                #Binary  // algebra
  | l=formula
    op=( '<' | '<=' | '≤' | '>' | '>=' | '≥' )
    r=formula                                           #Binary  // algebra
  | l=formula op=( '=' |'==' | '!=' | '≠' ) r=formula   #Binary  // algebra
  | op='-' formula                                      #Unary   // algebra
  | op=( 'not' | '!' | '~' | '¬' ) formula              #Unary   // propositional logic
  | l=formula ( 'and' | '&&' | '∧' ) r=formula          #Binary  // propositional logic
  | l=formula ( 'or' | '||' | '∨' ) r=formula           #Binary  // propositional logic
  | l=formula ( 'implies' | '⇒' | '=>' ) r=formula     #Binary  // propositional logic
  | qformula                                            #Quant   // predicate logic
  ;

qformula
  : q=( 'forall' | 'all' | 'A' | '∀'
      | 'exists' | 'some' | 'E' | '∃' )
    qVar+=ID ( ',' qVar+=ID )*
    '|'
    formula
  ;

justification
  : 'premise'                                           #Premise
  | ( 'andi' | ( '&&' | '∧' ) ruleIntro )
    lStep=NUM ',' rStep=NUM                             #AndIntro
  | ( 'ande1' | ( '&&' | '∧' ) ruleElim1 )
    andStep=NUM                                         #AndElim1
  | ( 'ande2' | ( '&&' | '∧' ) ruleElim2 )
    andStep=NUM                                         #AndElim2
  | ( 'ori1' | ( '||' | '∨' ) ruleIntro1 )
    orStep=NUM                                          #OrIntro1
  | ( 'ori2' | ( '||' | '∨' ) ruleIntro2 )
    orStep=NUM                                          #OrIntro2
  | ( 'ore' | ( '||' | '∨' ) ruleElim )
    orStep=NUM ',' lSubProof=NUM ',' rSubProof=NUM      #OrElim
  | ( 'impliesi' | ( '⇒' | '=>' ) ruleIntro )
    impliesStep=NUM                                     #ImpliesIntro
  | ( 'impliese' | ( '⇒' | '=>' ) ruleElim )
    impliesStep=NUM                                     #ImpliesElim
  | ( 'noti' | ( '!' | '~' | '¬' ) ruleIntro )
    step=NUM                                            #NegIntro
  | ( 'note' | ( '!' | '~' | '¬' ) ruleElim )
    step=NUM ',' notStep=NUM                            #NegElim
  | ( 'falsee' | '_|_' | '⊥' ) ruleElim falseStep=NUM   #FalseElim
  | 'Pbc' subProof=NUM                                  #Pbc
  | ( 'foalli' | 'alli' | 'Ai' | '∀' ruleIntro )
    subProof=NUM                                        #ForallIntro
  | ( 'foalle' | 'alle' | 'Ae' | '∀' ruleElim )
    stepOrFact=numOrId ',' args=numOrIds                #ForallElim
  | ( 'existsi' | 'somei' | 'Ei' | '∃' ruleIntro )
    existsStep=NUM ',' args=ids                         #ExistsIntro
  | ( 'existse' | 'somee' | 'Ee' | '∃' ruleElim )
    stepOrFact=numOrId ',' subproof=NUM                 #Exists
  | 'algebra' steps=nums?                               #Algebra
  | 'auto' stepOrFact=numOrIds?                         #Auto
  ;

ruleIntro
  : i=ID { "i".equals($i.text) }? ;

ruleIntro1
  : i1=ID { "i1".equals($i1.text) }? ;

ruleIntro2
  : i2=ID { "i2".equals($i2.text) }? ;

ruleElim
  : e=ID { "e".equals($e.text) }? ;

ruleElim1
  : e1=ID { "e1".equals($e1.text) }? ;

ruleElim2
  : e2=ID { "e2".equals($e2.text) }? ;

nums
  : NUM ( ',' NUM )* ;

numOrIds
  : numOrId ( ',' numOrId )* ;

numOrId
  : NUM
  | ID
  ;

ids
  : ID ( ',' ID )*
  ;

program
  : 'import' org=ID '.' sireum=ID '.' logika=ID '.' '_'
    stmts
    { "org".equals($org.text) &&
      "sireum".equals($sireum.text) &&
      "logika".equals($logika.text)    }?
  ;

stmts
  : stmt? ( ( ';' | NL+ ) stmt? )* ;

stmt
  : modifier=( 'var' | 'val' ) ID ':' type '=' exp      #VarDeclStmt
  | ID '=' exp                                          #AssignVarStmt
  | 'assert' '(' exp ')'                                #AssertStmt
  | 'if' '(' exp ')' NL* '{' ts=stmts '}'
    'else' '{' fs=stmts '}'                             #IfStmt
  | 'while' '(' exp ')' NL* '{'
    ( 'l' '"""' loopInvariant '"""' )?
    stmts
    '}'                                                 #WhileStmt
  | ID '=' 'readInt' '(' STRING? ')'                    #ReadIntStmt
  | op=('print' | 'println' ) '(' 's' STRING ')'        #PrintStmt
  | ( l=ID '=' )? r=ID '(' ( exp ( ','exp )* )? ')'     #MethodInvocationStmt
  | ID '=' ID '.' 'clone'                               #SeqCloneStmt
  | ID '(' exp ')' '=' exp                              #AssignArrayStmt
  | methodDecl                                          #MethodDeclStmt
  | 'l' '"""'
    ( proof
    | sequent
    | invariants
    | facts      )
    '"""'                                               #LogikaStmt
  ;

exp
  : 'true'                                              #TrueExp
  | 'false'                                             #FalseExp
  | INT                                                 #IntExp
  | ID ( '(' exp ')' )?                                 #IdExp
  | 'BigInt' '(' STRING ')'                             #BigIntExp
  | 'Seq' '(' exp ( ',' exp )? ')'                      #SeqExp
  | '(' exp ')'                                         #ParenExp
  | op=( '-' | '!' ) exp                                #UnaryExp
  | l=exp op=( '*' | '/' | '%' ) NL? r=exp              #BinaryExp
  | l=exp op=( '+' | '-' )  NL? r=exp                   #BinaryExp
  | l=exp op=( '>' | '>=' | '<' | '<=' )  NL? r=exp     #BinaryExp
  | l=exp op=( '==' | '!=' )  NL? r=exp                 #BinaryExp
  | l=exp ( '&&' ) NL? r=exp                            #BinaryExp
  | l=exp ( '||' ) NL? r=exp                            #BinaryExp
  ;

type
  : 'Boolean'                                           #Boolean
  | 'BigInt'                                            #IntType
  | 'Seq' '[' NL* 'BigInt' NL* ']'                      #IntSeqType
  ;

loopInvariant
  : '{'
    'invariant' formula
    modifies
    '}'
  ;

modifies
  : 'modifies' ID ( ',' ID )* ;

methodDecl
  : 'def' ID  NL?
    '(' ( param ( ',' param )* )? ')' ':' type '='
    '{'
    ( 'l' '"""' methodContract '"""' )?
    stmts
    'return' exp? NL*
    '}'
  ;

param
  : ID ':' type ;

methodContract
  : '{'
    ( 'requires' formula )?
    modifies?
    ( 'ensures' formula )?
    '}'
  ;

invariants
  : '{' 'invariant' formula+ '}' ;

facts
  : '{' 'fact' fact+ '}' ;

fact
  : ID '.' qformula ;


HLINE
  : '-' '-' '-'+
  ;

INT
  : '0' | '-'? [1-9] [0-9]* ;

NUM
  : '0' | [1-9] [0-9]* ;

ID
  : [a-zA-Z] [a-zA-Z0-9]* ;

STRING
  : '"' ('\u0020'| '\u0021'|'\u0023' .. '\u007F')* '"' ; // all printable chars and no escape chars

LINE_COMMENT
  : '//' ~[\r\n]* -> skip ;

COMMENT
  : '/*' .*? '*/' -> skip ;

NL
  : '\r'? '\n' // newlines are processed after lexing according to:
               // http://www.scala-lang.org/files/archive/spec/2.11/01-lexical-syntax.html#newline-characters
  ;

WS
  : [ \t\u000C]+ -> skip ;

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

ERROR_CHAR
  : . ;
