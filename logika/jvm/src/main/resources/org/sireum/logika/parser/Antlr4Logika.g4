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
   ¬         00AC      not   neg  !        ~
   ∧         2227      and        &        ^
   ∨         2228      or         |        V
   →         21D2      implies    ->
   ∀         2200      forall     all      A
   ∃         2203      exists     some     E
   ⊢         22A2      |-
==============================================

Note: ---+ means at least three minus (-) characters
and it is used for truth table and a different form of sequent
*/

@header {
// @formatter:off
}

file
  : truthTable EOF                                      #TruthTableFile
  | NL* sequent NL* proof? NL* EOF                      #SequentFile
  | program EOF                                         #ProgramFile
  ;

truthTable
  : NL*
    star='*' NL+
    HLINE NL+
    vars+=ID+ bar='|' formula NL+
    HLINE
    ( NL+ row )*
    NL+ HLINE
    ( NL+ status )?
    NL*
  ;

row
  : model+=bool* bar='|' eval+=bool*
  ;

bool
  : t=( 'T' | '⊤' | 'F' | '⊥' )
  ;

status
  : ID // ID in { "Tautology", "Contradictory", "Contingent" }
    ( // when "Contingent"
      NL+
      t='-' ( 'T' | '⊤' ) ':'
      ( NL* tContingentAssignments+=assignments )*
      NL+
      '-' ( 'F' | '⊥' ) ':'
      ( NL* fContingentAssignments+=assignments )*
    )?
  ;

assignments
  : '[' bool+ ']'
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

primFormula
  : t=( 'true' | 'T' | '⊤'
      | 'false' | 'F' | '_|_' | '⊥' )                   #Boolean     // propositional logic
  | '(' formula ')'                                     #Paren       // propositional logic
  | tb='result' '(' formula ( ',' formula )* ')'        #ApplyResult // programming logic
  | 'result'                                            #Result      // programming logic
  | ID '(' formula ( ',' formula )* ')'                 #Apply       // predicate logic
  | tb=ID                                               #Var         // propositional logic
  | NUM                                                 #Int         // programming logic
  | INT                                                 #IntLit      // programming logic
  | REAL                                                #RLit        // programming logic
  | FLOAT                                               #FloatLit    // programming logic
  | t=( 'B'
      | 'Z'    | 'Z8'   | 'Z16'  | 'Z32'  | 'Z64'
      | 'N'    | 'N8'   | 'N16'  | 'N32'  | 'N64'
               | 'S8'   | 'S16'  | 'S32'  | 'S64'
               | 'U8'   | 'U16'  | 'U32'  | 'U64'
      | 'R'    | 'F32'  | 'F64' )
      '.' ID                                            #TypeAccess  // programming logic
      // ID in { "Min", "Max", "random" }
  | t=( 'BS'
      | 'ZS' | 'Z8S'  | 'Z16S' | 'Z32S' | 'Z64S'
      | 'NS' | 'N8S'  | 'N16S' | 'N32S' | 'N64S'
             | 'S8S'  | 'S16S' | 'S32S' | 'S64S'
             | 'U8S'  | 'U16S' | 'U32S' | 'U64S'
      | 'RS' | 'F32S' | 'F64S' )
    '(' ( exp ( ',' exp )* )? ')'                       #Seq         // programming logic
  ;

formula
  : primFormula ( '.' ID )*                             #PFormula
    /* ID in { "size" } */
  | l=formula op=( '*' | '/' | '%' ) NL? r=formula      #Binary      // programming logic
  | l=formula op=( '+' | '-' ) NL? r=formula            #Binary      // programming logic
  | <assoc=right> l=formula op='+:' NL? r=formula       #Binary      // programming logic
  | l=formula op=':+' NL? r=formula                     #Binary      // programming logic
  | l=formula
    op=( '<' | '<=' | '≤' | '>' | '>=' | '≥'
       | '>>' | '>>>' | '<<' ) NL? r=formula            #Binary      // programming logic
  | l=formula
    op=( '=' |'==' | '!=' | '≠' ) NL?
    r=formula                                           #Binary      // programming logic
  | op='-' formula                                      #Unary       // programming logic
  | op=( 'not' | 'neg' | '!' | '~' | '¬' ) formula      #Unary       // propositional logic
  | l=formula
    op=( 'and' | '&' | '^' | '∧' ) NL? r=formula        #Binary      // propositional logic
  | l=formula op=( 'xor' | '^|' ) NL? r=formula         #Binary      // propositional logic
  | l=formula
    op=( 'or' | '|' | 'V' | '∨' ) NL? r=formula         #Binary      // propositional logic
  | <assoc=right> l=formula
    op=( 'implies' | '->' | '→' ) NL? r=formula         #Binary      // propositional logic
  | qformula                                            #Quant       // predicate logic
  ;

qformula
  : q=( 'forall' | 'all' | 'A' | '∀'
      | 'exists' | 'some' | 'E' | '∃' )
    vars+=ID ( ',' vars+=ID )*
    ( ':' type
    | ':' '(' lo=formula ll='<'? '..' lh='<'? hi=formula ')'
    )? NL?
    qf=formula
  ;

type
  : t=( 'B'
      | 'Z'   | 'Z8'   | 'Z16'  | 'Z32'  | 'Z64'
      | 'N'   | 'N8'   | 'N16'  | 'N32'  | 'N64'
              | 'S8'   | 'S16'  | 'S32'  | 'S64'
              | 'U8'   | 'U16'  | 'U32'  | 'U64'
      | 'R'   | 'F32'  | 'F64'
      | 'BS'
      | 'ZS'  | 'Z8S'  | 'Z16S' | 'Z32S' | 'Z64S'
      | 'NS'  | 'N8S'  | 'N16S' | 'N32S' | 'N64S'
              | 'S8S'  | 'S16S' | 'S32S' | 'S64S'
              | 'U8S'  | 'U16S' | 'U32S' | 'U64S'
      | 'RS'  | 'F32S' | 'F64S' )
  ;

justification
  : t='premise'                                         #Premise
  | ( tb='andi'  | tb=( '&' | '∧' | '^' ) ID ) // ID=="i"
    lStep=NUM rStep=NUM                                 #AndIntro
  | ( tb=('ande1' | 'ande2' )
    | tb=( '&' | '∧' | '^' ) ID ) // ID=="e1" or ID=="e2"
    andStep=NUM                                         #AndElim
  | ( tb=( 'ori1' | 'Vi1' | 'ori2' | 'Vi2' )
    | tb=( '|' | '∨' ) ID ) // ID=="i1" or ID=="i2"
    step=NUM                                            #OrIntro
  | ( tb=( 'ore' | 'Ve' )
    | tb=( '|' | '∨' ) ID ) // ID=="e"
    orStep=NUM lSubProof=NUM rSubProof=NUM              #OrElim
  | tb='impliesi' subProof=NUM                          #ImpliesIntro
  | tb='impliese' impliesStep=NUM antecedentStep=NUM    #ImpliesElim
  | {("->".equals(_input.LT(1).getText()) ||
      "→".equals(_input.LT(1).getText())) &&
     "i".equals(_input.LT(2).getText())}?
    tb=( '->' | '→' ) ID // ID=="i"
    subProof=NUM                                        #ImpliesIntro
  | {("->".equals(_input.LT(1).getText()) ||
      "→".equals(_input.LT(1).getText())) &&
      "e".equals(_input.LT(2).getText())}?
    tb=( '->' | '→' ) ID // ID=="e"
    impliesStep=NUM antecedentStep=NUM                  #ImpliesElim
  | tb=( 'noti' | 'negi' ) subProof=NUM                 #NegIntro
  | tb=('note' | 'nege') step=NUM negStep=NUM           #NegElim
  | {("!".equals(_input.LT(1).getText()) ||
      "~".equals(_input.LT(1).getText()) ||
      "¬".equals(_input.LT(1).getText())) &&
     "i".equals(_input.LT(2).getText())}?
    tb=( '!' | '~' | '¬' ) ID // ID=="i"
    subProof=NUM                                        #NegIntro
  | {("!".equals(_input.LT(1).getText()) ||
      "~".equals(_input.LT(1).getText()) ||
      "¬".equals(_input.LT(1).getText())) &&
     "e".equals(_input.LT(2).getText())}?
    tb=( '!' | '~' | '¬' ) ID // ID=="e"
    step=NUM negStep=NUM                                #NegElim
  | ( tb=( 'bottome' | 'falsee' )
    | tb=('_|_' | '⊥' ) ID // ID=="e"
    ) bottomStep=NUM                                    #BottomElim
  | tb='pbc' subProof=NUM                               #Pbc
  | tb='subst1' eqStep=NUM step=NUM                     #Subst1
  | tb='subst2' eqStep=NUM step=NUM                     #Subst2
  | tb='algebra' steps+=NUM*                            #Algebra
  | tb=('foralli' | 'alli' | 'Ai') subProof=NUM         #ForallIntro
  | tb=('foralle' | 'alle' | 'Ae')
    step=NUM formula+                                   #ForallElim
  | {"∀".equals(_input.LT(1).getText()) &&
     "i".equals(_input.LT(2).getText())}?
    tb='∀' ID // ID=="i"
    subProof=NUM                                        #ForallIntro
  | {"∀".equals(_input.LT(1).getText()) &&
     "e".equals(_input.LT(2).getText())}?
    tb='∀' ID // ID=="e"
    step=NUM formula+                                   #ForallElim
  | tb=( 'existsi' | 'somei' | 'Ei' )
    existsStep=NUM formula+                             #ExistsIntro
  | tb=( 'existse' | 'somee' | 'Ee' )
    step=NUM subProof=NUM                               #ExistsElim
  | {"∃".equals(_input.LT(1).getText()) &&
     "i".equals(_input.LT(2).getText())}?
    tb='∃' ID existsStep=NUM formula+                   #ExistsIntro
  | {"∃".equals(_input.LT(1).getText()) &&
     "e".equals(_input.LT(2).getText())}?
    tb='∃' t=ID // ID=="e"
    step=NUM subProof=NUM                               #ExistsElim
  | tb='invariant'                                      #Invariant
  | tb='fact' ID                                        #Fct
  | tb='auto' steps+=NUM*                               #Auto
  ;

program: NL* ( impor NL+ stmts )? ;

impor
  : tb='import' org=ID '.' sireum=ID '.' logika=ID '.' te='_'
    // org=="org" && sireum=="sireum" && logika=="logika"
  ;

facts
  : '{' NL*
    ftb='fact' NL*
    factOrFun ( NL+ factOrFun? )*
    te='}' NL* ;

factOrFun: fact | fun ;

fact: ID '.' formula ;

fun
  : tb='def' ID  NL?
    '(' param ( ',' param )* ')' ':' type
    ( NL* funDef )*
  ;

funDef
  : '=' e=formula ',' NL* 'if' c=formula '(' ID ')'
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
    '(' ( stringOrExp ( ',' stringOrExp )* )? ')'       #PrintStmt
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
    | facts
    ) '"""'                                             #LogikaStmt
  | impor                                               #ImportStmt
  | exp                                                 #ExpStmt
  ;

stringOrExp
  : STRING
  | exp
  ;

primExp
  : t=( 'true' | 'T' | '⊤'
      | 'false' | 'F' | '_|_' | '⊥' )                   #BooleanExp
  | NUM                                                 #IntExp
  | ID                                                  #VarExp
  | t=( 'BS'
      | 'ZS'   | 'Z8S'  | 'Z16S' | 'Z32S' | 'Z64S'
      | 'NS'   | 'N8S'  | 'N16S' | 'N32S' | 'N64S'
               | 'S8S'  | 'S16S' | 'S32S' | 'S64S'
               | 'U8S'  | 'U16S' | 'U32S' | 'U64S'
      | 'RS'   | 'F32S' | 'F64S' )
      '.' ID '(' ( exp ( ',' exp )* )? ')'              #TypeMethodCallExp
      // ID in { "create" }
  | t=( 'B'
      | 'Z'    | 'Z8'   | 'Z16'  | 'Z32'  | 'Z64'
      | 'N'    | 'N8'   | 'N16'  | 'N32'  | 'N64'
               | 'S8'   | 'S16'  | 'S32'  | 'S64'
               | 'U8'   | 'U16'  | 'U32'  | 'U64'
      | 'R'    | 'F32'  | 'F64'
      | 'BS'
      | 'ZS'   | 'Z8S'  | 'Z16S' | 'Z32S' | 'Z64S'
      | 'NS'   | 'N8S'  | 'N16S' | 'N32S' | 'N64S'
               | 'S8S'  | 'S16S' | 'S32S' | 'S64S'
               | 'U8S'  | 'U16S' | 'U32S' | 'U64S'
      | 'RS'   | 'F32S' | 'F64S' )
      '.' ID                                            #TypeAccessExp
      // ID in { "Min", "Max", "random" }
  | FLOAT                                               #FloatLitExp
  | INT                                                 #IntLitExp
  | REAL                                                #RLitExp
  | t=( 'BS'
      | 'ZS' | 'Z8S'  | 'Z16S' | 'Z32S' | 'Z64S'
      | 'NS' | 'N8S'  | 'N16S' | 'N32S' | 'N64S'
             | 'S8S'  | 'S16S' | 'S32S' | 'S64S'
             | 'U8S'  | 'U16S' | 'U32S' | 'U64S'
      | 'RS' | 'F32S' | 'F64S' )
    '(' ( exp ( ',' exp )* )? ')'                       #SeqExp
  ;

exp
  : tb=ID t='(' ( exp ( ',' exp )* )? ')'               #InvokeExp
  | primExp ( '.' ID )*                                 #PExp
    /* ID in { "size",
               "clone" // primExp === ID
             } */
  | 'randomInt' '(' ')'                                 #RandomIntExp
  | 'readInt' '(' STRING? ')'                           #ReadIntExp
  | '(' exp ')'                                         #ParenExp
  | op=( '-' | '!' | '~' ) exp                          #UnaryExp
  | l=exp op=( '*' | '/' | '%' ) NL? r=exp              #BinaryExp
  | l=exp op=( '+' | '-' )  NL? r=exp                   #BinaryExp
  | <assoc=right> l=exp op='+:' NL? r=exp               #BinaryExp
  | l=exp op=':+' NL? r=exp                             #BinaryExp
  | l=exp
    op=( '>' | '>=' | '<' | '<=' | '>>' | '>>>' | '<<' )
    NL?  r=exp                                          #BinaryExp
  | l=exp op=( '==' | '!=' )  NL? r=exp                 #BinaryExp
  | l=exp op='&' NL? r=exp                              #BinaryExp
  | l=exp op='^|' NL? r=exp                             #BinaryExp
  | l=exp op='|' NL? r=exp                              #BinaryExp
  ;

loopInvariant
  : tb='{' NL*
    modifies
    te='}' NL*
  | tb='{' NL*
    itb='invariant' NL* formula ( NL+ formula? )*
    modifies?
    te='}' NL*
  ;

modifies
  : tb='modifies' ID ( ',' ID )* NL* ;

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
    'invariant' NL* formula ( NL+ formula? )*
    te='}' NL*
  ;

HLINE: '-' '-' '-'+ ;

NUM: '0' | [1-9] [0-9]* ;

ID: [a-zA-Z] [a-zA-Z0-9_]* ;

REAL // space is ignored
    : 'r' '"' '-'? ( '0' | [1-9] [ 0-9]* ) ( '.' ' '* [0-9] [ 0-9]* )? '"'
    ;

INT // space is ignored
    : ( 'z' | 'z8' | 'z16' | 'z32' | 'z64'
      | 'n' | 'n8' | 'n16' | 'n32' | 'n64'
      | 's8' | 's16' | 's32' | 's64'
      | 'u8' | 'u16' | 'u32' | 'u64' )
      '"' ( '0' | '-'? ' '* [0-9] [ 0-9]* | '0x' ' '*  [0-9a-fA-F] [ 0-9a-fA-F]* ) '"'
    ;

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


// From https://github.com/antlr/grammars-v4/blob/master/java8/Java8.g4
/*
 * [The "BSD license"]
 *  Copyright (c) 2014 Terence Parr
 *  Copyright (c) 2014 Sam Harwell
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions
 *  are met:
 *
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. The name of the author may not be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 *  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 *  IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 *  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 *  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 *  THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
// §3.10.5 String Literals
STRING
	: '"' StringCharacters? '"'
	;

FLOAT
    : FloatingPointLiteral
    ;

fragment
StringCharacters
	:	StringCharacter+
	;
fragment
StringCharacter
	:	~["\\]
	|	EscapeSequence
	;
// §3.10.6 Escape Sequences for Character and String Literals
fragment
EscapeSequence
	:	'\\' [btnfr"'\\]
    |   UnicodeEscape // This is not in the spec but prevents having to preprocess the input
	;

// This is not in the spec but prevents having to preprocess the input
fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

// §3.10.1 Integer Literals

fragment
HexDigit
	:	[0-9a-fA-F]
	;

fragment
Digits
	:	Digit (DigitsAndUnderscores? Digit)?
	;

fragment
Digit
	:	'0'
	|	NonZeroDigit
	;

fragment
NonZeroDigit
	:	[1-9]
	;

fragment
DigitsAndUnderscores
	:	DigitOrUnderscore+
	;

fragment
DigitOrUnderscore
	:	Digit
	|	'_'
	;

fragment
HexNumeral
	:	'0' [xX] HexDigits
	;

fragment
HexDigits
	:	HexDigit (HexDigitsAndUnderscores? HexDigit)?
	;

fragment
HexDigitsAndUnderscores
	:	HexDigitOrUnderscore+
	;

fragment
HexDigitOrUnderscore
	:	HexDigit
	|	'_'
	;

// §3.10.2 Floating-Point Literals

fragment
FloatingPointLiteral
	:	DecimalFloatingPointLiteral
	|	HexadecimalFloatingPointLiteral
	;

fragment
DecimalFloatingPointLiteral
	:	/* the second Digits is modified to be non-optional */
	    Digits '.' Digits ExponentPart? FloatTypeSuffix?
	|	'.' Digits ExponentPart? FloatTypeSuffix?
	|	Digits ExponentPart FloatTypeSuffix?
	|	Digits FloatTypeSuffix
	;

fragment
ExponentPart
	:	ExponentIndicator SignedInteger
	;

fragment
ExponentIndicator
	:	[eE]
	;

fragment
SignedInteger
	:	Sign? Digits
	;

fragment
Sign
	:	[+-]
	;

fragment
FloatTypeSuffix
	:	[fFdD]
	;

fragment
HexadecimalFloatingPointLiteral
	:	HexSignificand BinaryExponent FloatTypeSuffix?
	;

fragment
HexSignificand
	:	HexNumeral '.'?
	|	'0' [xX] HexDigits? '.' HexDigits
	;

fragment
BinaryExponent
	:	BinaryExponentIndicator SignedInteger
	;

fragment
BinaryExponentIndicator
	:	[pP]
	;

ERROR_CHAR: . ;
