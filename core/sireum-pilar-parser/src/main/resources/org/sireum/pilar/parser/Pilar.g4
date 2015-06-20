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

grammar Pilar;

model
  : annotation*
    modelElement+
  ;

modelElement
  : 'var' globalVarDecl+              #GlobalVar
  | procDecl                          #Procedure
  ;

globalVarDecl
  : ID annotation* ';'
  ;

procDecl
  : 'def' ID
    '(' param ( ',' param )* ')'
    annotation*
    ( procBody | ';' )
  ;

param
  : ID annotation*
  ;

procBody
  : '{'
    ( 'var' localVarDecl+ )?
    location+
    '}'
  ;

localVarDecl
  : ID annotation* ';'
  ;

location
  : '#' ID ':'
    annotation* transformation
  ;

transformation
  : 'call' ( exp ':=' )?
    p=ID arg 'goto' l=ID ';'          #Call
  | action* jump                      #Block
  ;

action
  : l=exp ':=' r=exp annotation* ';'  #AssignAction
  | 'assert' exp annotation* ';'      #AssertAction
  | 'assume' exp annotation* ';'      #AssumeAction
  | 'axt' ID arg annotation* ';'      #ExtAction
  ;

jump
  : 'goto' ID annotation* ';'         #GotoJump
  | 'if' exp 'then' t=ID
    'else' f=ID annotation* ';'       #IfJump
  | 'return' exp? annotation* ';'     #ReturnJump
  | 'switch' exp
    switchCase*
    b='case' u=ID /* must be _ */ ':'
    t=ID
    annotation* ';'                   #SwitchJump
  | 'jxt' ID arg annotation* ';'      #ExtJump
  ;

switchCase
  : 'case' lit ':' ID
  ;

exp
  : prim arg* expSuffix*
  ;

expSuffix
  : ID prim arg*
  ;

prim
  : lit                               #LitExp
  | ID                                #IdExp
  | '(' exp ( ',' exp )* ')'
    annotation*                       #TupleExp
  ;

arg
  : '(' ( exp ( ',' exp )* )? ')'
  ;

lit
  : ID LIT
  ;

annotation
  : '@' lit
  ;

LIT
  : '\'' ~[ \r\n\t\u000C;(,){}'"#:@`]*
  | '"""'
    ( ~["]
    | '"' .
    | '"' '"' .
    | '"' '"' '"' .
    )* '"""' '"'*
  ;


ID
  : [a-zA-Z$_] [a-zA-Z0-9$_]*
  | '.' ~[ \r\n\t\u000C;(,){}'"#:@`]+
  | '`' ~[\r\n\t\u000C`]+ '`'
  ;

WS
  : [ \r\n\t\u000C]+ -> skip
  ;

ERROR_CHAR
  : .
  ;
