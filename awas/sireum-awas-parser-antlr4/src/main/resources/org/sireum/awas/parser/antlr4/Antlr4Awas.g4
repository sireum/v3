grammar Antlr4Awas;

modelFile
  : model EOF
  ;

model
  : modelElement*
  ;

modelElement
  : componentDecl
  | connectionDecl
  | enumDecl
  ;

componentDecl
  : 'component' ID
      ( 'ports' port*
        ( 'dependencies' dependency* )?
      )?
      ( 'properties' property* )?
      states?
  ;

connectionDecl
  : 'connection'
    from=ID ( '.' fromPort=ID )?
    '->'
    to=ID ( '.' toPort=ID )?
      ( 'properties' property* )?
  ;

enumDecl
  : 'enum' id=ID
    ( 'extends' supers+=ID ( ',' supers+=ID )* )?
    // enum elements are defined in the profile
  ;

states
  : 'states' '=' '[' ID ( ',' ID )* ']' // the initial state is the first declared one
      ( 'transitions' transition* )?
  ;

transition
  : fromState=ID '-[' /* TODO */ ']->' toState=ID
  ;

dependency
  : fromPort=ID '->' toPort=ID
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
  | 'Set' '[' type ']'                               #SetType
  | 'Seq' '[' type ']'                               #SeqType
  | 'Map' '[' basicType ',' type ']'                 #MapType
  ;

basicType
  : 'Boolean'                                        #BooleanType
  | 'Integer'                                        #IntegerType
  | 'Real'                                           #RealType
  | 'String'                                         #StringType
  | ID                                               #EnumType
  ;

init
  : 'true'                                           #True
  | 'false'                                          #False
  | INTEGER                                          #Integer
  | REAL                                             #Real
  | STRING                                           #String
  | ID                                               #EnumElement
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
  :   '/*' .*? '*/' -> skip
  ;

LINE_COMMENT
  :   '//' ~[\r\n]* -> skip
  ;

ERROR_CHAR
  : .
  ;
