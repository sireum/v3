grammar Antlr4Awas;

@header {
// @formatter:off
}

modelFile
  : model EOF
  ;

model
  : unitDecl+
  ;

unitDecl
  : namespaceDecl?
    importDecl*
    ( 'types' typeDecl* )?
    'components' componentDecl+
    ( 'connections' connectionDecl* )?
  ;

namespaceDecl
  : 'namespace' name
  ;

name
  : ID ( '::' ID )*
  ;

importDecl
  : 'import' name ( '.' elem=ID )? ( 'as' alias=ID )?
  ;

typeDecl
  : enumDecl
  | latticeDecl
  | recordDecl
  ;

componentDecl
  : 'component'? ID
      ( 'ports' port* )?
      ( 'properties' property* )?
  ;

connectionDecl
  : 'connection'? id=ID ':'
    fromComponent=ID ( '.' fromPort=ID )?
    '->'
    toComponent=ID ( '.' toPort=ID )?
      ( 'properties' property* )?
  ;

enumDecl
  : // enum elements can be defined in the profile
    'enum' id=ID
    ( 'extends' supers+=ID ( ',' supers+=ID )* )?
    (
      '{' elements+=ID ( ',' elements+=ID )* '}'
    )?
  ;

latticeDecl
  : 'lattice' id=ID
    ( 'extends' supers+=ID ( ',' supers+=ID )* )?
  ;

recordDecl
  : 'record' ID
      field+
  ;

field
  : ID ':' type
  ;


port
  : mod=( 'in' | 'out' ) ID
  ;

property
  : ID ':' type ( '=' init )?
  | ID '=' init
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
  | 'Integer'                                        #IntegerType
  | 'Real'                                           #RealType
  | 'String'                                         #StringType
  | name                                             #NamedType
  ;

init
  : 'true'                                           #True
  | 'false'                                          #False
  | INTEGER                                          #Integer
  | REAL                                             #Real
  | STRING                                           #String
  | name '(' init ( ',' init )* ')'                  #Record
  | name ( '.' ID )?                                 #EnumOrLattice
  | 'None' ( '[' type ']' )?                         #None
  | 'Some' ( '[' type ']' )? '(' init ')'            #Some
  | 'Set' ( '[' type ']' )?
    '(' ( init ( ',' init )* )? ')'                  #Set
  | 'Seq' ( '[' type ']' )?
    '(' ( init ( ',' init )* )? ')'                  #Seq
  | 'Map'
     ( '[' basicType ',' type ']' )?
    '(' (  mapEntry ( ',' mapEntry )* )? ')'         #Map
  ;

mapEntry
  : key=init '->' value=init
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
  : '\"' ( ~["] | '\\' ( '\\' | '"' ) )* '\"'
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
