// Generated from /Users/robby/Repositories/Sireum-Private/sireum-v3/awas/sireum-awas-parser-antlr4/src/main/resources/org/sireum/awas/parser/Antlr4Awas.g4 by ANTLR 4.5.1
package org.sireum.awas.parser;

// @formatter:off

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Antlr4AwasParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, INTEGER=43, REAL=44, STRING=45, 
		ID=46, WS=47, COMMENT=48, LINE_COMMENT=49, ERROR_CHAR=50;
	public static final int
		RULE_modelFile = 0, RULE_model = 1, RULE_typeDecl = 2, RULE_componentDecl = 3, 
		RULE_connectionDecl = 4, RULE_typeAliasDecl = 5, RULE_enumDecl = 6, RULE_latticeDecl = 7, 
		RULE_recordDecl = 8, RULE_field = 9, RULE_statesDecl = 10, RULE_port = 11, 
		RULE_property = 12, RULE_constantDecl = 13, RULE_type = 14, RULE_basicType = 15, 
		RULE_intConstant = 16, RULE_init = 17, RULE_mapEntry = 18, RULE_name = 19;
	public static final String[] ruleNames = {
		"modelFile", "model", "typeDecl", "componentDecl", "connectionDecl", "typeAliasDecl", 
		"enumDecl", "latticeDecl", "recordDecl", "field", "statesDecl", "port", 
		"property", "constantDecl", "type", "basicType", "intConstant", "init", 
		"mapEntry", "name"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'types'", "'constants'", "'components'", "'connections'", "'component'", 
		"'ports'", "'properties'", "'connection'", "':'", "'.'", "'->'", "'alias'", 
		"'='", "'enum'", "'extends'", "','", "'{'", "'}'", "'lattice'", "'record'", 
		"'states'", "'['", "']'", "'in'", "'out'", "'Option'", "'Set'", "'Seq'", 
		"'Map'", "'Boolean'", "'Integer'", "'('", "')'", "'Real'", "'String'", 
		"'port'", "'_'", "'true'", "'false'", "'None'", "'Some'", "'::'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "INTEGER", "REAL", "STRING", 
		"ID", "WS", "COMMENT", "LINE_COMMENT", "ERROR_CHAR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Antlr4Awas.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Antlr4AwasParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ModelFileContext extends ParserRuleContext {
		public ModelContext model() {
			return getRuleContext(ModelContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Antlr4AwasParser.EOF, 0); }
		public ModelFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelFile; }
	}

	public final ModelFileContext modelFile() throws RecognitionException {
		ModelFileContext _localctx = new ModelFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_modelFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			model();
			setState(41);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModelContext extends ParserRuleContext {
		public List<TypeDeclContext> typeDecl() {
			return getRuleContexts(TypeDeclContext.class);
		}
		public TypeDeclContext typeDecl(int i) {
			return getRuleContext(TypeDeclContext.class,i);
		}
		public List<ConstantDeclContext> constantDecl() {
			return getRuleContexts(ConstantDeclContext.class);
		}
		public ConstantDeclContext constantDecl(int i) {
			return getRuleContext(ConstantDeclContext.class,i);
		}
		public List<ComponentDeclContext> componentDecl() {
			return getRuleContexts(ComponentDeclContext.class);
		}
		public ComponentDeclContext componentDecl(int i) {
			return getRuleContext(ComponentDeclContext.class,i);
		}
		public List<ConnectionDeclContext> connectionDecl() {
			return getRuleContexts(ConnectionDeclContext.class);
		}
		public ConnectionDeclContext connectionDecl(int i) {
			return getRuleContext(ConnectionDeclContext.class,i);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
	}

	public final ModelContext model() throws RecognitionException {
		ModelContext _localctx = new ModelContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_model);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(43);
				match(T__0);
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__13) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) {
					{
					{
					setState(44);
					typeDecl();
					}
					}
					setState(49);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(59);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(52);
				match(T__1);
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(53);
					constantDecl();
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(68);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(61);
				match(T__2);
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4 || _la==ID) {
					{
					{
					setState(62);
					componentDecl();
					}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(77);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(70);
				match(T__3);
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7 || _la==ID) {
					{
					{
					setState(71);
					connectionDecl();
					}
					}
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclContext extends ParserRuleContext {
		public TypeAliasDeclContext typeAliasDecl() {
			return getRuleContext(TypeAliasDeclContext.class,0);
		}
		public EnumDeclContext enumDecl() {
			return getRuleContext(EnumDeclContext.class,0);
		}
		public LatticeDeclContext latticeDecl() {
			return getRuleContext(LatticeDeclContext.class,0);
		}
		public RecordDeclContext recordDecl() {
			return getRuleContext(RecordDeclContext.class,0);
		}
		public StatesDeclContext statesDecl() {
			return getRuleContext(StatesDeclContext.class,0);
		}
		public TypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecl; }
	}

	public final TypeDeclContext typeDecl() throws RecognitionException {
		TypeDeclContext _localctx = new TypeDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeDecl);
		try {
			setState(84);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				typeAliasDecl();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				enumDecl();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				latticeDecl();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 4);
				{
				setState(82);
				recordDecl();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				statesDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComponentDeclContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<PortContext> port() {
			return getRuleContexts(PortContext.class);
		}
		public PortContext port(int i) {
			return getRuleContext(PortContext.class,i);
		}
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public ComponentDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentDecl; }
	}

	public final ComponentDeclContext componentDecl() throws RecognitionException {
		ComponentDeclContext _localctx = new ComponentDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_componentDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(86);
				match(T__4);
				}
			}

			setState(89);
			name();
			setState(97);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(90);
				match(T__5);
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23 || _la==T__24) {
					{
					{
					setState(91);
					port();
					}
					}
					setState(96);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(106);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(99);
				match(T__6);
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(100);
						property();
						}
						} 
					}
					setState(105);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConnectionDeclContext extends ParserRuleContext {
		public NameContext fromComponent;
		public Token fromPort;
		public NameContext toComponent;
		public Token toPort;
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4AwasParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4AwasParser.ID, i);
		}
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public ConnectionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connectionDecl; }
	}

	public final ConnectionDeclContext connectionDecl() throws RecognitionException {
		ConnectionDeclContext _localctx = new ConnectionDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_connectionDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(108);
				match(T__7);
				}
			}

			setState(111);
			name();
			setState(112);
			match(T__8);
			setState(113);
			((ConnectionDeclContext)_localctx).fromComponent = name();
			setState(114);
			match(T__9);
			setState(115);
			((ConnectionDeclContext)_localctx).fromPort = match(ID);
			setState(116);
			match(T__10);
			setState(117);
			((ConnectionDeclContext)_localctx).toComponent = name();
			setState(118);
			match(T__9);
			setState(119);
			((ConnectionDeclContext)_localctx).toPort = match(ID);
			setState(127);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(120);
				match(T__6);
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(121);
						property();
						}
						} 
					}
					setState(126);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeAliasDeclContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeAliasDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeAliasDecl; }
	}

	public final TypeAliasDeclContext typeAliasDecl() throws RecognitionException {
		TypeAliasDeclContext _localctx = new TypeAliasDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeAliasDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__11);
			setState(130);
			name();
			setState(131);
			match(T__12);
			setState(132);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumDeclContext extends ParserRuleContext {
		public NameContext n;
		public NameContext name;
		public List<NameContext> supers = new ArrayList<NameContext>();
		public Token ID;
		public List<Token> elements = new ArrayList<Token>();
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4AwasParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4AwasParser.ID, i);
		}
		public EnumDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDecl; }
	}

	public final EnumDeclContext enumDecl() throws RecognitionException {
		EnumDeclContext _localctx = new EnumDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_enumDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__13);
			setState(135);
			((EnumDeclContext)_localctx).n = name();
			setState(145);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(136);
				match(T__14);
				setState(137);
				((EnumDeclContext)_localctx).name = name();
				((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).name);
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(138);
					match(T__15);
					setState(139);
					((EnumDeclContext)_localctx).name = name();
					((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).name);
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(157);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(147);
				match(T__16);
				setState(148);
				((EnumDeclContext)_localctx).ID = match(ID);
				((EnumDeclContext)_localctx).elements.add(((EnumDeclContext)_localctx).ID);
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(149);
					match(T__15);
					setState(150);
					((EnumDeclContext)_localctx).ID = match(ID);
					((EnumDeclContext)_localctx).elements.add(((EnumDeclContext)_localctx).ID);
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(156);
				match(T__17);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LatticeDeclContext extends ParserRuleContext {
		public NameContext n;
		public NameContext name;
		public List<NameContext> supers = new ArrayList<NameContext>();
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public LatticeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_latticeDecl; }
	}

	public final LatticeDeclContext latticeDecl() throws RecognitionException {
		LatticeDeclContext _localctx = new LatticeDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_latticeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__18);
			setState(160);
			((LatticeDeclContext)_localctx).n = name();
			setState(170);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(161);
				match(T__14);
				setState(162);
				((LatticeDeclContext)_localctx).name = name();
				((LatticeDeclContext)_localctx).supers.add(((LatticeDeclContext)_localctx).name);
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(163);
					match(T__15);
					setState(164);
					((LatticeDeclContext)_localctx).name = name();
					((LatticeDeclContext)_localctx).supers.add(((LatticeDeclContext)_localctx).name);
					}
					}
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecordDeclContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public RecordDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordDecl; }
	}

	public final RecordDeclContext recordDecl() throws RecognitionException {
		RecordDeclContext _localctx = new RecordDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_recordDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__19);
			setState(173);
			name();
			setState(175); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(174);
				field();
				}
				}
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Antlr4AwasParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(ID);
			setState(180);
			match(T__8);
			setState(181);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatesDeclContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4AwasParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4AwasParser.ID, i);
		}
		public StatesDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statesDecl; }
	}

	public final StatesDeclContext statesDecl() throws RecognitionException {
		StatesDeclContext _localctx = new StatesDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statesDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__20);
			setState(184);
			name();
			setState(185);
			match(T__21);
			setState(186);
			match(ID);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(187);
				match(T__15);
				setState(188);
				match(ID);
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(194);
			match(T__22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PortContext extends ParserRuleContext {
		public Token mod;
		public TerminalNode ID() { return getToken(Antlr4AwasParser.ID, 0); }
		public PortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_port; }
	}

	public final PortContext port() throws RecognitionException {
		PortContext _localctx = new PortContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_port);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			((PortContext)_localctx).mod = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__23 || _la==T__24) ) {
				((PortContext)_localctx).mod = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(197);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Antlr4AwasParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(ID);
			setState(200);
			match(T__8);
			setState(201);
			type();
			setState(204);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(202);
				match(T__12);
				setState(203);
				init();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantDeclContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public ConstantDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDecl; }
	}

	public final ConstantDeclContext constantDecl() throws RecognitionException {
		ConstantDeclContext _localctx = new ConstantDeclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constantDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			name();
			setState(207);
			match(T__8);
			setState(208);
			type();
			setState(209);
			match(T__12);
			setState(210);
			init();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BaseTypeContext extends TypeContext {
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public BaseTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class SetTypeContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SetTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class SeqTypeContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SeqTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class OptionTypeContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public OptionTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class MapTypeContext extends TypeContext {
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public MapTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_type);
		try {
			setState(235);
			switch (_input.LA(1)) {
			case T__4:
			case T__29:
			case T__30:
			case T__33:
			case T__34:
			case T__35:
			case ID:
				_localctx = new BaseTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				basicType();
				}
				break;
			case T__25:
				_localctx = new OptionTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(T__25);
				setState(214);
				match(T__21);
				setState(215);
				type();
				setState(216);
				match(T__22);
				}
				break;
			case T__26:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				match(T__26);
				setState(219);
				match(T__21);
				setState(220);
				type();
				setState(221);
				match(T__22);
				}
				break;
			case T__27:
				_localctx = new SeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(223);
				match(T__27);
				setState(224);
				match(T__21);
				setState(225);
				type();
				setState(226);
				match(T__22);
				}
				break;
			case T__28:
				_localctx = new MapTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(228);
				match(T__28);
				setState(229);
				match(T__21);
				setState(230);
				basicType();
				setState(231);
				match(T__15);
				setState(232);
				type();
				setState(233);
				match(T__22);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicTypeContext extends ParserRuleContext {
		public BasicTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicType; }
	 
		public BasicTypeContext() { }
		public void copyFrom(BasicTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntegerTypeContext extends BasicTypeContext {
		public IntConstantContext lo;
		public IntConstantContext hi;
		public List<IntConstantContext> intConstant() {
			return getRuleContexts(IntConstantContext.class);
		}
		public IntConstantContext intConstant(int i) {
			return getRuleContext(IntConstantContext.class,i);
		}
		public IntegerTypeContext(BasicTypeContext ctx) { copyFrom(ctx); }
	}
	public static class ComponentTypeContext extends BasicTypeContext {
		public ComponentTypeContext(BasicTypeContext ctx) { copyFrom(ctx); }
	}
	public static class StringTypeContext extends BasicTypeContext {
		public StringTypeContext(BasicTypeContext ctx) { copyFrom(ctx); }
	}
	public static class NamedTypeContext extends BasicTypeContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public NamedTypeContext(BasicTypeContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanTypeContext extends BasicTypeContext {
		public BooleanTypeContext(BasicTypeContext ctx) { copyFrom(ctx); }
	}
	public static class RealTypeContext extends BasicTypeContext {
		public RealTypeContext(BasicTypeContext ctx) { copyFrom(ctx); }
	}
	public static class PortTypeContext extends BasicTypeContext {
		public PortTypeContext(BasicTypeContext ctx) { copyFrom(ctx); }
	}

	public final BasicTypeContext basicType() throws RecognitionException {
		BasicTypeContext _localctx = new BasicTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_basicType);
		int _la;
		try {
			setState(252);
			switch (_input.LA(1)) {
			case T__29:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				match(T__29);
				}
				break;
			case T__30:
				_localctx = new IntegerTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				match(T__30);
				setState(245);
				_la = _input.LA(1);
				if (_la==T__31) {
					{
					setState(239);
					match(T__31);
					setState(240);
					((IntegerTypeContext)_localctx).lo = intConstant();
					setState(241);
					match(T__15);
					setState(242);
					((IntegerTypeContext)_localctx).hi = intConstant();
					setState(243);
					match(T__32);
					}
				}

				}
				break;
			case T__33:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				match(T__33);
				}
				break;
			case T__34:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(248);
				match(T__34);
				}
				break;
			case T__4:
				_localctx = new ComponentTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(249);
				match(T__4);
				}
				break;
			case T__35:
				_localctx = new PortTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(250);
				match(T__35);
				}
				break;
			case ID:
				_localctx = new NamedTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(251);
				name();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntConstantContext extends ParserRuleContext {
		public IntConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intConstant; }
	 
		public IntConstantContext() { }
		public void copyFrom(IntConstantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LitIntConstantContext extends IntConstantContext {
		public TerminalNode INTEGER() { return getToken(Antlr4AwasParser.INTEGER, 0); }
		public LitIntConstantContext(IntConstantContext ctx) { copyFrom(ctx); }
	}
	public static class ArbitraryIntConstantContext extends IntConstantContext {
		public ArbitraryIntConstantContext(IntConstantContext ctx) { copyFrom(ctx); }
	}
	public static class NamedIntConstantContext extends IntConstantContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public NamedIntConstantContext(IntConstantContext ctx) { copyFrom(ctx); }
	}

	public final IntConstantContext intConstant() throws RecognitionException {
		IntConstantContext _localctx = new IntConstantContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_intConstant);
		try {
			setState(257);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new LitIntConstantContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(INTEGER);
				}
				break;
			case ID:
				_localctx = new NamedIntConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				name();
				}
				break;
			case T__36:
				_localctx = new ArbitraryIntConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				match(T__36);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitContext extends ParserRuleContext {
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
	 
		public InitContext() { }
		public void copyFrom(InitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SetContext extends InitContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<InitContext> init() {
			return getRuleContexts(InitContext.class);
		}
		public InitContext init(int i) {
			return getRuleContext(InitContext.class,i);
		}
		public SetContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class EnumOrLatticeOrConstantContext extends InitContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode ID() { return getToken(Antlr4AwasParser.ID, 0); }
		public EnumOrLatticeOrConstantContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class TrueContext extends InitContext {
		public TrueContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class PortRefContext extends InitContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public PortRefContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class FalseContext extends InitContext {
		public FalseContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class StringContext extends InitContext {
		public TerminalNode STRING() { return getToken(Antlr4AwasParser.STRING, 0); }
		public StringContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class IntegerContext extends InitContext {
		public TerminalNode INTEGER() { return getToken(Antlr4AwasParser.INTEGER, 0); }
		public IntegerContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class SomeContext extends InitContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public SomeContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class RealContext extends InitContext {
		public TerminalNode REAL() { return getToken(Antlr4AwasParser.REAL, 0); }
		public RealContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class RecordContext extends InitContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4AwasParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4AwasParser.ID, i);
		}
		public List<InitContext> init() {
			return getRuleContexts(InitContext.class);
		}
		public InitContext init(int i) {
			return getRuleContext(InitContext.class,i);
		}
		public RecordContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class ComponentRefContext extends InitContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ComponentRefContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class NoneContext extends InitContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NoneContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class MapContext extends InitContext {
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<MapEntryContext> mapEntry() {
			return getRuleContexts(MapEntryContext.class);
		}
		public MapEntryContext mapEntry(int i) {
			return getRuleContext(MapEntryContext.class,i);
		}
		public MapContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class SeqContext extends InitContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<InitContext> init() {
			return getRuleContexts(InitContext.class);
		}
		public InitContext init(int i) {
			return getRuleContext(InitContext.class,i);
		}
		public SeqContext(InitContext ctx) { copyFrom(ctx); }
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_init);
		int _la;
		try {
			setState(355);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(T__37);
				}
				break;
			case 2:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(T__38);
				}
				break;
			case 3:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				match(INTEGER);
				}
				break;
			case 4:
				_localctx = new RealContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(262);
				match(REAL);
				}
				break;
			case 5:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(263);
				match(STRING);
				}
				break;
			case 6:
				_localctx = new RecordContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(264);
				name();
				setState(265);
				match(T__31);
				setState(266);
				match(ID);
				setState(267);
				match(T__12);
				setState(268);
				init();
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(269);
					match(T__15);
					setState(270);
					match(ID);
					setState(271);
					match(T__12);
					setState(272);
					init();
					}
					}
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(278);
				match(T__32);
				}
				break;
			case 7:
				_localctx = new EnumOrLatticeOrConstantContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(280);
				name();
				setState(283);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(281);
					match(T__9);
					setState(282);
					match(ID);
					}
				}

				}
				break;
			case 8:
				_localctx = new ComponentRefContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(285);
				match(T__4);
				setState(286);
				name();
				}
				break;
			case 9:
				_localctx = new PortRefContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(287);
				match(T__35);
				setState(288);
				name();
				}
				break;
			case 10:
				_localctx = new NoneContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(289);
				match(T__39);
				setState(290);
				match(T__21);
				setState(291);
				type();
				setState(292);
				match(T__22);
				}
				break;
			case 11:
				_localctx = new SomeContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(294);
				match(T__40);
				setState(295);
				match(T__21);
				setState(296);
				type();
				setState(297);
				match(T__22);
				setState(298);
				match(T__31);
				setState(299);
				init();
				setState(300);
				match(T__32);
				}
				break;
			case 12:
				_localctx = new SetContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(302);
				match(T__26);
				setState(303);
				match(T__21);
				setState(304);
				type();
				setState(305);
				match(T__22);
				setState(306);
				match(T__31);
				setState(315);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__35) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(307);
					init();
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(308);
						match(T__15);
						setState(309);
						init();
						}
						}
						setState(314);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(317);
				match(T__32);
				}
				break;
			case 13:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(319);
				match(T__27);
				setState(320);
				match(T__21);
				setState(321);
				type();
				setState(322);
				match(T__22);
				setState(323);
				match(T__31);
				setState(332);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__35) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(324);
					init();
					setState(329);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(325);
						match(T__15);
						setState(326);
						init();
						}
						}
						setState(331);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(334);
				match(T__32);
				}
				break;
			case 14:
				_localctx = new MapContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(336);
				match(T__28);
				setState(337);
				match(T__21);
				setState(338);
				basicType();
				setState(339);
				match(T__15);
				setState(340);
				type();
				setState(341);
				match(T__22);
				setState(342);
				match(T__31);
				setState(351);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__35) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(343);
					mapEntry();
					setState(348);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(344);
						match(T__15);
						setState(345);
						mapEntry();
						}
						}
						setState(350);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(353);
				match(T__32);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapEntryContext extends ParserRuleContext {
		public InitContext key;
		public InitContext value;
		public List<InitContext> init() {
			return getRuleContexts(InitContext.class);
		}
		public InitContext init(int i) {
			return getRuleContext(InitContext.class,i);
		}
		public MapEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapEntry; }
	}

	public final MapEntryContext mapEntry() throws RecognitionException {
		MapEntryContext _localctx = new MapEntryContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_mapEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			((MapEntryContext)_localctx).key = init();
			setState(358);
			match(T__10);
			setState(359);
			((MapEntryContext)_localctx).value = init();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(Antlr4AwasParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4AwasParser.ID, i);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			match(ID);
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__41) {
				{
				{
				setState(362);
				match(T__41);
				setState(363);
				match(ID);
				}
				}
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\64\u0174\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\3\3\3\7\3\60\n\3\f\3\16\3"+
		"\63\13\3\5\3\65\n\3\3\3\3\3\7\39\n\3\f\3\16\3<\13\3\5\3>\n\3\3\3\3\3\7"+
		"\3B\n\3\f\3\16\3E\13\3\5\3G\n\3\3\3\3\3\7\3K\n\3\f\3\16\3N\13\3\5\3P\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\5\4W\n\4\3\5\5\5Z\n\5\3\5\3\5\3\5\7\5_\n\5\f\5"+
		"\16\5b\13\5\5\5d\n\5\3\5\3\5\7\5h\n\5\f\5\16\5k\13\5\5\5m\n\5\3\6\5\6"+
		"p\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6}\n\6\f\6\16\6\u0080"+
		"\13\6\5\6\u0082\n\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u008f"+
		"\n\b\f\b\16\b\u0092\13\b\5\b\u0094\n\b\3\b\3\b\3\b\3\b\7\b\u009a\n\b\f"+
		"\b\16\b\u009d\13\b\3\b\5\b\u00a0\n\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00a8"+
		"\n\t\f\t\16\t\u00ab\13\t\5\t\u00ad\n\t\3\n\3\n\3\n\6\n\u00b2\n\n\r\n\16"+
		"\n\u00b3\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00c0\n\f\f\f"+
		"\16\f\u00c3\13\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\5\16\u00cf"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u00ee\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00f8\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u00ff\n\21\3\22\3\22\3\22\5"+
		"\22\u0104\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\7\23\u0114\n\23\f\23\16\23\u0117\13\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u011e\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u0139\n\23\f\23\16\23\u013c\13\23\5\23\u013e\n\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u014a\n\23\f\23\16"+
		"\23\u014d\13\23\5\23\u014f\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\7\23\u015d\n\23\f\23\16\23\u0160\13\23\5\23\u0162"+
		"\n\23\3\23\3\23\5\23\u0166\n\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\7\25"+
		"\u016f\n\25\f\25\16\25\u0172\13\25\3\25\2\2\26\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(\2\3\3\2\32\33\u019f\2*\3\2\2\2\4\64\3\2\2\2\6V\3"+
		"\2\2\2\bY\3\2\2\2\no\3\2\2\2\f\u0083\3\2\2\2\16\u0088\3\2\2\2\20\u00a1"+
		"\3\2\2\2\22\u00ae\3\2\2\2\24\u00b5\3\2\2\2\26\u00b9\3\2\2\2\30\u00c6\3"+
		"\2\2\2\32\u00c9\3\2\2\2\34\u00d0\3\2\2\2\36\u00ed\3\2\2\2 \u00fe\3\2\2"+
		"\2\"\u0103\3\2\2\2$\u0165\3\2\2\2&\u0167\3\2\2\2(\u016b\3\2\2\2*+\5\4"+
		"\3\2+,\7\2\2\3,\3\3\2\2\2-\61\7\3\2\2.\60\5\6\4\2/.\3\2\2\2\60\63\3\2"+
		"\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\64-\3\2\2\2"+
		"\64\65\3\2\2\2\65=\3\2\2\2\66:\7\4\2\2\679\5\34\17\28\67\3\2\2\29<\3\2"+
		"\2\2:8\3\2\2\2:;\3\2\2\2;>\3\2\2\2<:\3\2\2\2=\66\3\2\2\2=>\3\2\2\2>F\3"+
		"\2\2\2?C\7\5\2\2@B\5\b\5\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DG\3"+
		"\2\2\2EC\3\2\2\2F?\3\2\2\2FG\3\2\2\2GO\3\2\2\2HL\7\6\2\2IK\5\n\6\2JI\3"+
		"\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MP\3\2\2\2NL\3\2\2\2OH\3\2\2\2OP\3"+
		"\2\2\2P\5\3\2\2\2QW\5\f\7\2RW\5\16\b\2SW\5\20\t\2TW\5\22\n\2UW\5\26\f"+
		"\2VQ\3\2\2\2VR\3\2\2\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2W\7\3\2\2\2XZ\7\7"+
		"\2\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[c\5(\25\2\\`\7\b\2\2]_\5\30\r\2^]\3"+
		"\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ad\3\2\2\2b`\3\2\2\2c\\\3\2\2\2cd"+
		"\3\2\2\2dl\3\2\2\2ei\7\t\2\2fh\5\32\16\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2"+
		"ij\3\2\2\2jm\3\2\2\2ki\3\2\2\2le\3\2\2\2lm\3\2\2\2m\t\3\2\2\2np\7\n\2"+
		"\2on\3\2\2\2op\3\2\2\2pq\3\2\2\2qr\5(\25\2rs\7\13\2\2st\5(\25\2tu\7\f"+
		"\2\2uv\7\60\2\2vw\7\r\2\2wx\5(\25\2xy\7\f\2\2y\u0081\7\60\2\2z~\7\t\2"+
		"\2{}\5\32\16\2|{\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0082"+
		"\3\2\2\2\u0080~\3\2\2\2\u0081z\3\2\2\2\u0081\u0082\3\2\2\2\u0082\13\3"+
		"\2\2\2\u0083\u0084\7\16\2\2\u0084\u0085\5(\25\2\u0085\u0086\7\17\2\2\u0086"+
		"\u0087\5\36\20\2\u0087\r\3\2\2\2\u0088\u0089\7\20\2\2\u0089\u0093\5(\25"+
		"\2\u008a\u008b\7\21\2\2\u008b\u0090\5(\25\2\u008c\u008d\7\22\2\2\u008d"+
		"\u008f\5(\25\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0093"+
		"\u008a\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u009f\3\2\2\2\u0095\u0096\7\23"+
		"\2\2\u0096\u009b\7\60\2\2\u0097\u0098\7\22\2\2\u0098\u009a\7\60\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\7\24\2\2\u009f"+
		"\u0095\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\17\3\2\2\2\u00a1\u00a2\7\25\2"+
		"\2\u00a2\u00ac\5(\25\2\u00a3\u00a4\7\21\2\2\u00a4\u00a9\5(\25\2\u00a5"+
		"\u00a6\7\22\2\2\u00a6\u00a8\5(\25\2\u00a7\u00a5\3\2\2\2\u00a8\u00ab\3"+
		"\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ac\u00a3\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\21\3\2\2"+
		"\2\u00ae\u00af\7\26\2\2\u00af\u00b1\5(\25\2\u00b0\u00b2\5\24\13\2\u00b1"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\23\3\2\2\2\u00b5\u00b6\7\60\2\2\u00b6\u00b7\7\13\2\2\u00b7"+
		"\u00b8\5\36\20\2\u00b8\25\3\2\2\2\u00b9\u00ba\7\27\2\2\u00ba\u00bb\5("+
		"\25\2\u00bb\u00bc\7\30\2\2\u00bc\u00c1\7\60\2\2\u00bd\u00be\7\22\2\2\u00be"+
		"\u00c0\7\60\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3"+
		"\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4"+
		"\u00c5\7\31\2\2\u00c5\27\3\2\2\2\u00c6\u00c7\t\2\2\2\u00c7\u00c8\7\60"+
		"\2\2\u00c8\31\3\2\2\2\u00c9\u00ca\7\60\2\2\u00ca\u00cb\7\13\2\2\u00cb"+
		"\u00ce\5\36\20\2\u00cc\u00cd\7\17\2\2\u00cd\u00cf\5$\23\2\u00ce\u00cc"+
		"\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\33\3\2\2\2\u00d0\u00d1\5(\25\2\u00d1"+
		"\u00d2\7\13\2\2\u00d2\u00d3\5\36\20\2\u00d3\u00d4\7\17\2\2\u00d4\u00d5"+
		"\5$\23\2\u00d5\35\3\2\2\2\u00d6\u00ee\5 \21\2\u00d7\u00d8\7\34\2\2\u00d8"+
		"\u00d9\7\30\2\2\u00d9\u00da\5\36\20\2\u00da\u00db\7\31\2\2\u00db\u00ee"+
		"\3\2\2\2\u00dc\u00dd\7\35\2\2\u00dd\u00de\7\30\2\2\u00de\u00df\5\36\20"+
		"\2\u00df\u00e0\7\31\2\2\u00e0\u00ee\3\2\2\2\u00e1\u00e2\7\36\2\2\u00e2"+
		"\u00e3\7\30\2\2\u00e3\u00e4\5\36\20\2\u00e4\u00e5\7\31\2\2\u00e5\u00ee"+
		"\3\2\2\2\u00e6\u00e7\7\37\2\2\u00e7\u00e8\7\30\2\2\u00e8\u00e9\5 \21\2"+
		"\u00e9\u00ea\7\22\2\2\u00ea\u00eb\5\36\20\2\u00eb\u00ec\7\31\2\2\u00ec"+
		"\u00ee\3\2\2\2\u00ed\u00d6\3\2\2\2\u00ed\u00d7\3\2\2\2\u00ed\u00dc\3\2"+
		"\2\2\u00ed\u00e1\3\2\2\2\u00ed\u00e6\3\2\2\2\u00ee\37\3\2\2\2\u00ef\u00ff"+
		"\7 \2\2\u00f0\u00f7\7!\2\2\u00f1\u00f2\7\"\2\2\u00f2\u00f3\5\"\22\2\u00f3"+
		"\u00f4\7\22\2\2\u00f4\u00f5\5\"\22\2\u00f5\u00f6\7#\2\2\u00f6\u00f8\3"+
		"\2\2\2\u00f7\u00f1\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00ff\3\2\2\2\u00f9"+
		"\u00ff\7$\2\2\u00fa\u00ff\7%\2\2\u00fb\u00ff\7\7\2\2\u00fc\u00ff\7&\2"+
		"\2\u00fd\u00ff\5(\25\2\u00fe\u00ef\3\2\2\2\u00fe\u00f0\3\2\2\2\u00fe\u00f9"+
		"\3\2\2\2\u00fe\u00fa\3\2\2\2\u00fe\u00fb\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00fd\3\2\2\2\u00ff!\3\2\2\2\u0100\u0104\7-\2\2\u0101\u0104\5(\25\2\u0102"+
		"\u0104\7\'\2\2\u0103\u0100\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0102\3\2"+
		"\2\2\u0104#\3\2\2\2\u0105\u0166\7(\2\2\u0106\u0166\7)\2\2\u0107\u0166"+
		"\7-\2\2\u0108\u0166\7.\2\2\u0109\u0166\7/\2\2\u010a\u010b\5(\25\2\u010b"+
		"\u010c\7\"\2\2\u010c\u010d\7\60\2\2\u010d\u010e\7\17\2\2\u010e\u0115\5"+
		"$\23\2\u010f\u0110\7\22\2\2\u0110\u0111\7\60\2\2\u0111\u0112\7\17\2\2"+
		"\u0112\u0114\5$\23\2\u0113\u010f\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113"+
		"\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2\2\2\u0117\u0115\3\2\2\2\u0118"+
		"\u0119\7#\2\2\u0119\u0166\3\2\2\2\u011a\u011d\5(\25\2\u011b\u011c\7\f"+
		"\2\2\u011c\u011e\7\60\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"\u0166\3\2\2\2\u011f\u0120\7\7\2\2\u0120\u0166\5(\25\2\u0121\u0122\7&"+
		"\2\2\u0122\u0166\5(\25\2\u0123\u0124\7*\2\2\u0124\u0125\7\30\2\2\u0125"+
		"\u0126\5\36\20\2\u0126\u0127\7\31\2\2\u0127\u0166\3\2\2\2\u0128\u0129"+
		"\7+\2\2\u0129\u012a\7\30\2\2\u012a\u012b\5\36\20\2\u012b\u012c\7\31\2"+
		"\2\u012c\u012d\7\"\2\2\u012d\u012e\5$\23\2\u012e\u012f\7#\2\2\u012f\u0166"+
		"\3\2\2\2\u0130\u0131\7\35\2\2\u0131\u0132\7\30\2\2\u0132\u0133\5\36\20"+
		"\2\u0133\u0134\7\31\2\2\u0134\u013d\7\"\2\2\u0135\u013a\5$\23\2\u0136"+
		"\u0137\7\22\2\2\u0137\u0139\5$\23\2\u0138\u0136\3\2\2\2\u0139\u013c\3"+
		"\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013e\3\2\2\2\u013c"+
		"\u013a\3\2\2\2\u013d\u0135\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2"+
		"\2\2\u013f\u0140\7#\2\2\u0140\u0166\3\2\2\2\u0141\u0142\7\36\2\2\u0142"+
		"\u0143\7\30\2\2\u0143\u0144\5\36\20\2\u0144\u0145\7\31\2\2\u0145\u014e"+
		"\7\"\2\2\u0146\u014b\5$\23\2\u0147\u0148\7\22\2\2\u0148\u014a\5$\23\2"+
		"\u0149\u0147\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c"+
		"\3\2\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u0146\3\2\2\2\u014e"+
		"\u014f\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\7#\2\2\u0151\u0166\3\2"+
		"\2\2\u0152\u0153\7\37\2\2\u0153\u0154\7\30\2\2\u0154\u0155\5 \21\2\u0155"+
		"\u0156\7\22\2\2\u0156\u0157\5\36\20\2\u0157\u0158\7\31\2\2\u0158\u0161"+
		"\7\"\2\2\u0159\u015e\5&\24\2\u015a\u015b\7\22\2\2\u015b\u015d\5&\24\2"+
		"\u015c\u015a\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f"+
		"\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0159\3\2\2\2\u0161"+
		"\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\7#\2\2\u0164\u0166\3\2"+
		"\2\2\u0165\u0105\3\2\2\2\u0165\u0106\3\2\2\2\u0165\u0107\3\2\2\2\u0165"+
		"\u0108\3\2\2\2\u0165\u0109\3\2\2\2\u0165\u010a\3\2\2\2\u0165\u011a\3\2"+
		"\2\2\u0165\u011f\3\2\2\2\u0165\u0121\3\2\2\2\u0165\u0123\3\2\2\2\u0165"+
		"\u0128\3\2\2\2\u0165\u0130\3\2\2\2\u0165\u0141\3\2\2\2\u0165\u0152\3\2"+
		"\2\2\u0166%\3\2\2\2\u0167\u0168\5$\23\2\u0168\u0169\7\r\2\2\u0169\u016a"+
		"\5$\23\2\u016a\'\3\2\2\2\u016b\u0170\7\60\2\2\u016c\u016d\7,\2\2\u016d"+
		"\u016f\7\60\2\2\u016e\u016c\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u016e\3"+
		"\2\2\2\u0170\u0171\3\2\2\2\u0171)\3\2\2\2\u0172\u0170\3\2\2\2*\61\64:"+
		"=CFLOVY`cilo~\u0081\u0090\u0093\u009b\u009f\u00a9\u00ac\u00b3\u00c1\u00ce"+
		"\u00ed\u00f7\u00fe\u0103\u0115\u011d\u013a\u013d\u014b\u014e\u015e\u0161"+
		"\u0165\u0170";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}