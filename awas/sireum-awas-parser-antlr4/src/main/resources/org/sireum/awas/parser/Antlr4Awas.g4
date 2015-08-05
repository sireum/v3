grammar Antlr4Awas;

@header {
// @formatter:off
}

modelFile
  : model EOF
  ;

model
  : ( 'types' typeDecl* )?
    ( 'constants' constantDecl* )?
    ( 'components' componentDecl* )?
    ( 'connections' connectionDecl* )?
  ;

typeDecl
  : typeAliasDecl
  | enumDecl
  | latticeDecl
  | recordDecl
  | statesDecl
  ;

componentDecl
  : 'component'? name
      ( 'ports' port* )?
      ( 'properties' property* )?
  ;

connectionDecl
  : 'connection'? name ':'
    fromComponent=name '.' fromPort=ID
    '->'
    toComponent=name '.' toPort=ID
      ( 'properties' property* )?
  ;

typeAliasDecl
  : 'alias' name '=' type
  ;

enumDecl
  : // enum elements can be defined in the profile
    'enum' n=name
    ( 'extends' supers+=name ( ',' supers+=name )* )?
    (
      '{' elements+=ID ( ',' elements+=ID )* '}'
    )?
  ;

latticeDecl
  : 'lattice' n=name
    ( 'extends' supers+=name ( ',' supers+=name )* )?
  ;

recordDecl
  : 'record' name
      field+
  ;

field
  : ID ':' type
  ;

statesDecl
  : 'states' name '[' ID ( ',' ID )* ']'
  ;

port
  : mod=( 'in' | 'out' ) ID
  ;

property
  : ID ':' type ( '=' init )?
  ;

constantDecl
  : name ':' type '=' init
  ;

type
  : basicType                                        #BaseType
  | 'Option' '[' type ']'                            #OptionType
  | 'Set' '[' type ']'                               #SetType
  | 'Seq' '[' type ']'                               #SeqType
  | 'Map' '[' basicType ',' type ']'                 #MapType
  ;

basicType
  : 'Boolean'                                        #BooleanType
  | 'Integer'
     ( '(' lo=intConstant ',' hi=intConstant ')' )?  #IntegerType
  | 'Real'                                           #RealType
  | 'String'                                         #StringType
  | 'component'                                      #ComponentType
  | 'port'                                           #PortType
  | name                                             #NamedType
  ;

intConstant
  : INTEGER                                          #LitIntConstant
  | name                                             #NamedIntConstant
  | '_'                                              #ArbitraryIntConstant
  ;

init
  : 'true'                                           #True
  | 'false'                                          #False
  | INTEGER                                          #Integer
  | REAL                                             #Real
  | STRING                                           #String
  | name '(' ID '=' init ( ',' ID '=' init )* ')'    #Record
  | name ( '.' ID )?                                 #EnumOrLatticeOrConstant
  | 'component' name                                 #ComponentRef
  | 'port' name '.' ID                               #PortRef
  | 'None' '[' type ']'                              #None
  | 'Some' '[' type ']' '(' init ')'                 #Some
  | 'Set' '[' type ']'
    '(' ( init ( ',' init )* )? ')'                  #Set
  | 'Seq' '[' type ']'
    '(' ( init ( ',' init )* )? ')'                  #Seq
  | 'Map'
     '[' basicType ',' type ']'
    '(' (  mapEntry ( ',' mapEntry )* )? ')'         #Map
  ;

mapEntry
  : key=init '->' value=init
  ;

name
  : ID ( '::' ID )*
  ;

/* TODO: nested component
enclosureDecl
  : 'enclosure' ID
      ( 'ports' port* )?
  ;
*/

/* TODO: nested component
enclosureAssembly
  : 'assembly' ID 'for' name
      ( 'ports' portAlias* )?  // TODO: properties propagation
  ;
*/

/* TODO: states and transitions
states
  : 'states' '=' '[' ID ( ',' ID )* ']' // the initial state is the first declared one
      ( 'transitions' transition* )?
  ;

transition
  : fromState=ID '-[' TODO ']->' toState=ID
  ;
*/

/* TODO: intra-flow
flow
  : 'flow' id=ID ':' fromPort=ID '->' toPort=ID
  ;
*/

/* TODO: nested component
portAlias
  : mod=( 'in' | 'out' ) id=ID ( 'as' alias=ID )?
  | id=ID 'as' alias=ID
  ;
*/

INTEGER
  : '0' | [1-9] [0-9]*
  ;

REAL
  : ( '0' | [1-9] [0-9]* ) '.' [0-9]+
  ;

STRING
  : '\"' ( ~["] | '"' '"' )* '\"'
  ;

ID
  : [a-zA-Z$_] [a-zA-Z0-9$_]*
  | '`' ~[\r\n\t\u000C`]+ '`'
  ;

WS
  : [ \r\n\t\u000C]+ -> skip
  ;

COMMENT
  : '/*' .*? '*/' -> skip
  ;

LINE_COMMENT
  : '//' ~[\r\n]* -> skip
  ;

ERROR_CHAR
  : .
  ;
