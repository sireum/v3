grammar Antlr4Awas;

@header {
// @formatter:off
}

modelFile
  : model EOF
  ;

model
  : unitDecl*
  ;

unitDecl
  : namespaceDecl?
    importEnumDecl*
    enclosureDecl?
    modelElement+
  ;

namespaceDecl
  : 'namespace' name
  ;

name
  : ID ( '::' ID )*
  ;

importEnumDecl
  : 'import' name ( '.' elem=ID )? ( 'as' alias=ID )?
  ;

enclosureDecl
  : 'enclosure' ID
      ( 'ports' port* )?
  ; // TODO: properties propagation

modelElement
  : componentDecl
  | connectionDecl
  | enumDecl
  | enclosureAssembly
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
    fromComponent=ID ( '.' fromPort=ID )?
    '->'
    toComponent=ID ( '.' toPort=ID )?
      ( 'properties' property* )?
  ;

enumDecl
  : 'enum' 'lattice'? id=ID
    ( 'extends' supers+=ID ( ',' supers+=ID )* )?
    // non-lattice enum elements are defined in the profile
    // lattices are singleton enum hierarchy
  ;

enclosureAssembly
  : 'assembly' ID 'for' name
      ( 'ports' portAlias* )?
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

portAlias
  : mod=( 'in' | 'out' ) id=ID ( 'as' alias=ID )?
  | id=ID 'as' alias=ID
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
  | name                                             #EnumType
  ;

init
  : 'true'                                           #True
  | 'false'                                          #False
  | INTEGER                                          #Integer
  | REAL                                             #Real
  | STRING                                           #String
  | name ( '.' ID )?                                 #EnumElement
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
  : '/*' .*? '*/' -> skip
  ;

LINE_COMMENT
  : '//' ~[\r\n]* -> skip
  ;

ERROR_CHAR
  : .
  ;
