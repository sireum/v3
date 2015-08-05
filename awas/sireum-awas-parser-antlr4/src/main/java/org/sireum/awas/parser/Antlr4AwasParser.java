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
		T__38=39, T__39=40, T__40=41, INTEGER=42, REAL=43, STRING=44, ID=45, WS=46, 
		COMMENT=47, LINE_COMMENT=48, ERROR_CHAR=49;
	public static final int
		RULE_modelFile = 0, RULE_model = 1, RULE_typeDecl = 2, RULE_componentDecl = 3, 
		RULE_connectionDecl = 4, RULE_typeAliasDecl = 5, RULE_enumDecl = 6, RULE_latticeDecl = 7, 
		RULE_recordDecl = 8, RULE_field = 9, RULE_port = 10, RULE_property = 11, 
		RULE_constantDecl = 12, RULE_type = 13, RULE_basicType = 14, RULE_intConstant = 15, 
		RULE_init = 16, RULE_mapEntry = 17, RULE_name = 18;
	public static final String[] ruleNames = {
		"modelFile", "model", "typeDecl", "componentDecl", "connectionDecl", "typeAliasDecl", 
		"enumDecl", "latticeDecl", "recordDecl", "field", "port", "property", 
		"constantDecl", "type", "basicType", "intConstant", "init", "mapEntry", 
		"name"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'types'", "'constants'", "'components'", "'connections'", "'component'", 
		"'ports'", "'properties'", "'connection'", "':'", "'.'", "'->'", "'alias'", 
		"'='", "'enum'", "'extends'", "','", "'{'", "'}'", "'lattice'", "'record'", 
		"'in'", "'out'", "'Option'", "'['", "']'", "'Set'", "'Seq'", "'Map'", 
		"'Boolean'", "'Integer'", "'('", "')'", "'Real'", "'String'", "'port'", 
		"'_'", "'true'", "'false'", "'None'", "'Some'", "'::'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "INTEGER", "REAL", "STRING", "ID", 
		"WS", "COMMENT", "LINE_COMMENT", "ERROR_CHAR"
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
			setState(38);
			model();
			setState(39);
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
			setState(48);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(41);
				match(T__0);
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__13) | (1L << T__18) | (1L << T__19))) != 0)) {
					{
					{
					setState(42);
					typeDecl();
					}
					}
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(57);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(50);
				match(T__1);
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(51);
					constantDecl();
					}
					}
					setState(56);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(66);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(59);
				match(T__2);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4 || _la==ID) {
					{
					{
					setState(60);
					componentDecl();
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(75);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(68);
				match(T__3);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7 || _la==ID) {
					{
					{
					setState(69);
					connectionDecl();
					}
					}
					setState(74);
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
		public TypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecl; }
	}

	public final TypeDeclContext typeDecl() throws RecognitionException {
		TypeDeclContext _localctx = new TypeDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeDecl);
		try {
			setState(81);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				typeAliasDecl();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				enumDecl();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				latticeDecl();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				recordDecl();
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
			setState(84);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(83);
				match(T__4);
				}
			}

			setState(86);
			name();
			setState(94);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(87);
				match(T__5);
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20 || _la==T__21) {
					{
					{
					setState(88);
					port();
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(103);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(96);
				match(T__6);
				setState(100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(97);
						property();
						}
						} 
					}
					setState(102);
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
			setState(106);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(105);
				match(T__7);
				}
			}

			setState(108);
			name();
			setState(109);
			match(T__8);
			setState(110);
			((ConnectionDeclContext)_localctx).fromComponent = name();
			setState(111);
			match(T__9);
			setState(112);
			((ConnectionDeclContext)_localctx).fromPort = match(ID);
			setState(113);
			match(T__10);
			setState(114);
			((ConnectionDeclContext)_localctx).toComponent = name();
			setState(115);
			match(T__9);
			setState(116);
			((ConnectionDeclContext)_localctx).toPort = match(ID);
			setState(124);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(117);
				match(T__6);
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(118);
						property();
						}
						} 
					}
					setState(123);
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
			setState(126);
			match(T__11);
			setState(127);
			name();
			setState(128);
			match(T__12);
			setState(129);
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
			setState(131);
			match(T__13);
			setState(132);
			((EnumDeclContext)_localctx).n = name();
			setState(142);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(133);
				match(T__14);
				setState(134);
				((EnumDeclContext)_localctx).name = name();
				((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).name);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(135);
					match(T__15);
					setState(136);
					((EnumDeclContext)_localctx).name = name();
					((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).name);
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(154);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(144);
				match(T__16);
				setState(145);
				((EnumDeclContext)_localctx).ID = match(ID);
				((EnumDeclContext)_localctx).elements.add(((EnumDeclContext)_localctx).ID);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(146);
					match(T__15);
					setState(147);
					((EnumDeclContext)_localctx).ID = match(ID);
					((EnumDeclContext)_localctx).elements.add(((EnumDeclContext)_localctx).ID);
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(153);
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
			setState(156);
			match(T__18);
			setState(157);
			((LatticeDeclContext)_localctx).n = name();
			setState(167);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(158);
				match(T__14);
				setState(159);
				((LatticeDeclContext)_localctx).name = name();
				((LatticeDeclContext)_localctx).supers.add(((LatticeDeclContext)_localctx).name);
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(160);
					match(T__15);
					setState(161);
					((LatticeDeclContext)_localctx).name = name();
					((LatticeDeclContext)_localctx).supers.add(((LatticeDeclContext)_localctx).name);
					}
					}
					setState(166);
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
			setState(169);
			match(T__19);
			setState(170);
			name();
			setState(172); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(171);
				field();
				}
				}
				setState(174); 
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
			setState(176);
			match(ID);
			setState(177);
			match(T__8);
			setState(178);
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
		enterRule(_localctx, 20, RULE_port);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			((PortContext)_localctx).mod = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__20 || _la==T__21) ) {
				((PortContext)_localctx).mod = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(181);
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
		enterRule(_localctx, 22, RULE_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(ID);
			setState(184);
			match(T__8);
			setState(185);
			type();
			setState(188);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(186);
				match(T__12);
				setState(187);
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
		enterRule(_localctx, 24, RULE_constantDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			name();
			setState(191);
			match(T__8);
			setState(192);
			type();
			setState(193);
			match(T__12);
			setState(194);
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
		enterRule(_localctx, 26, RULE_type);
		try {
			setState(219);
			switch (_input.LA(1)) {
			case T__4:
			case T__28:
			case T__29:
			case T__32:
			case T__33:
			case T__34:
			case ID:
				_localctx = new BaseTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				basicType();
				}
				break;
			case T__22:
				_localctx = new OptionTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(T__22);
				setState(198);
				match(T__23);
				setState(199);
				type();
				setState(200);
				match(T__24);
				}
				break;
			case T__25:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
				match(T__25);
				setState(203);
				match(T__23);
				setState(204);
				type();
				setState(205);
				match(T__24);
				}
				break;
			case T__26:
				_localctx = new SeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(207);
				match(T__26);
				setState(208);
				match(T__23);
				setState(209);
				type();
				setState(210);
				match(T__24);
				}
				break;
			case T__27:
				_localctx = new MapTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(212);
				match(T__27);
				setState(213);
				match(T__23);
				setState(214);
				basicType();
				setState(215);
				match(T__15);
				setState(216);
				type();
				setState(217);
				match(T__24);
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
		enterRule(_localctx, 28, RULE_basicType);
		int _la;
		try {
			setState(236);
			switch (_input.LA(1)) {
			case T__28:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(T__28);
				}
				break;
			case T__29:
				_localctx = new IntegerTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				match(T__29);
				setState(229);
				_la = _input.LA(1);
				if (_la==T__30) {
					{
					setState(223);
					match(T__30);
					setState(224);
					((IntegerTypeContext)_localctx).lo = intConstant();
					setState(225);
					match(T__15);
					setState(226);
					((IntegerTypeContext)_localctx).hi = intConstant();
					setState(227);
					match(T__31);
					}
				}

				}
				break;
			case T__32:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(231);
				match(T__32);
				}
				break;
			case T__33:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(232);
				match(T__33);
				}
				break;
			case T__4:
				_localctx = new ComponentTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(233);
				match(T__4);
				}
				break;
			case T__34:
				_localctx = new PortTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(234);
				match(T__34);
				}
				break;
			case ID:
				_localctx = new NamedTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(235);
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
		enterRule(_localctx, 30, RULE_intConstant);
		try {
			setState(241);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new LitIntConstantContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				match(INTEGER);
				}
				break;
			case ID:
				_localctx = new NamedIntConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				name();
				}
				break;
			case T__35:
				_localctx = new ArbitraryIntConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				match(T__35);
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
		public TerminalNode ID() { return getToken(Antlr4AwasParser.ID, 0); }
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
		enterRule(_localctx, 32, RULE_init);
		int _la;
		try {
			setState(342);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				match(T__36);
				}
				break;
			case 2:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				match(T__37);
				}
				break;
			case 3:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(245);
				match(INTEGER);
				}
				break;
			case 4:
				_localctx = new RealContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(246);
				match(REAL);
				}
				break;
			case 5:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(247);
				match(STRING);
				}
				break;
			case 6:
				_localctx = new RecordContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(248);
				name();
				setState(249);
				match(T__30);
				setState(250);
				match(ID);
				setState(251);
				match(T__12);
				setState(252);
				init();
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(253);
					match(T__15);
					setState(254);
					match(ID);
					setState(255);
					match(T__12);
					setState(256);
					init();
					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(262);
				match(T__31);
				}
				break;
			case 7:
				_localctx = new EnumOrLatticeOrConstantContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(264);
				name();
				setState(267);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(265);
					match(T__9);
					setState(266);
					match(ID);
					}
				}

				}
				break;
			case 8:
				_localctx = new ComponentRefContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(269);
				match(T__4);
				setState(270);
				name();
				}
				break;
			case 9:
				_localctx = new PortRefContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(271);
				match(T__34);
				setState(272);
				name();
				setState(273);
				match(T__9);
				setState(274);
				match(ID);
				}
				break;
			case 10:
				_localctx = new NoneContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(276);
				match(T__38);
				setState(277);
				match(T__23);
				setState(278);
				type();
				setState(279);
				match(T__24);
				}
				break;
			case 11:
				_localctx = new SomeContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(281);
				match(T__39);
				setState(282);
				match(T__23);
				setState(283);
				type();
				setState(284);
				match(T__24);
				setState(285);
				match(T__30);
				setState(286);
				init();
				setState(287);
				match(T__31);
				}
				break;
			case 12:
				_localctx = new SetContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(289);
				match(T__25);
				setState(290);
				match(T__23);
				setState(291);
				type();
				setState(292);
				match(T__24);
				setState(293);
				match(T__30);
				setState(302);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(294);
					init();
					setState(299);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(295);
						match(T__15);
						setState(296);
						init();
						}
						}
						setState(301);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(304);
				match(T__31);
				}
				break;
			case 13:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(306);
				match(T__26);
				setState(307);
				match(T__23);
				setState(308);
				type();
				setState(309);
				match(T__24);
				setState(310);
				match(T__30);
				setState(319);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(311);
					init();
					setState(316);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(312);
						match(T__15);
						setState(313);
						init();
						}
						}
						setState(318);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(321);
				match(T__31);
				}
				break;
			case 14:
				_localctx = new MapContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(323);
				match(T__27);
				setState(324);
				match(T__23);
				setState(325);
				basicType();
				setState(326);
				match(T__15);
				setState(327);
				type();
				setState(328);
				match(T__24);
				setState(329);
				match(T__30);
				setState(338);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(330);
					mapEntry();
					setState(335);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(331);
						match(T__15);
						setState(332);
						mapEntry();
						}
						}
						setState(337);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(340);
				match(T__31);
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
		enterRule(_localctx, 34, RULE_mapEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			((MapEntryContext)_localctx).key = init();
			setState(345);
			match(T__10);
			setState(346);
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
		enterRule(_localctx, 36, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(ID);
			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__40) {
				{
				{
				setState(349);
				match(T__40);
				setState(350);
				match(ID);
				}
				}
				setState(355);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63\u0167\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\5\3"+
		"\63\n\3\3\3\3\3\7\3\67\n\3\f\3\16\3:\13\3\5\3<\n\3\3\3\3\3\7\3@\n\3\f"+
		"\3\16\3C\13\3\5\3E\n\3\3\3\3\3\7\3I\n\3\f\3\16\3L\13\3\5\3N\n\3\3\4\3"+
		"\4\3\4\3\4\5\4T\n\4\3\5\5\5W\n\5\3\5\3\5\3\5\7\5\\\n\5\f\5\16\5_\13\5"+
		"\5\5a\n\5\3\5\3\5\7\5e\n\5\f\5\16\5h\13\5\5\5j\n\5\3\6\5\6m\n\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6z\n\6\f\6\16\6}\13\6\5\6\177"+
		"\n\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u008c\n\b\f\b\16"+
		"\b\u008f\13\b\5\b\u0091\n\b\3\b\3\b\3\b\3\b\7\b\u0097\n\b\f\b\16\b\u009a"+
		"\13\b\3\b\5\b\u009d\n\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00a5\n\t\f\t\16\t"+
		"\u00a8\13\t\5\t\u00aa\n\t\3\n\3\n\3\n\6\n\u00af\n\n\r\n\16\n\u00b0\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u00bf\n\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00de\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e8\n\20\3"+
		"\20\3\20\3\20\3\20\3\20\5\20\u00ef\n\20\3\21\3\21\3\21\5\21\u00f4\n\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\7\22\u0104\n\22\f\22\16\22\u0107\13\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u010e\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\7\22\u012c\n\22\f\22\16\22\u012f\13\22\5\22\u0131\n\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u013d\n\22\f\22\16"+
		"\22\u0140\13\22\5\22\u0142\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\7\22\u0150\n\22\f\22\16\22\u0153\13\22\5\22\u0155"+
		"\n\22\3\22\3\22\5\22\u0159\n\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24"+
		"\u0162\n\24\f\24\16\24\u0165\13\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&\2\3\3\2\27\30\u0191\2(\3\2\2\2\4\62\3\2\2\2\6S\3"+
		"\2\2\2\bV\3\2\2\2\nl\3\2\2\2\f\u0080\3\2\2\2\16\u0085\3\2\2\2\20\u009e"+
		"\3\2\2\2\22\u00ab\3\2\2\2\24\u00b2\3\2\2\2\26\u00b6\3\2\2\2\30\u00b9\3"+
		"\2\2\2\32\u00c0\3\2\2\2\34\u00dd\3\2\2\2\36\u00ee\3\2\2\2 \u00f3\3\2\2"+
		"\2\"\u0158\3\2\2\2$\u015a\3\2\2\2&\u015e\3\2\2\2()\5\4\3\2)*\7\2\2\3*"+
		"\3\3\2\2\2+/\7\3\2\2,.\5\6\4\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2"+
		"\2\2\60\63\3\2\2\2\61/\3\2\2\2\62+\3\2\2\2\62\63\3\2\2\2\63;\3\2\2\2\64"+
		"8\7\4\2\2\65\67\5\32\16\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2"+
		"\2\29<\3\2\2\2:8\3\2\2\2;\64\3\2\2\2;<\3\2\2\2<D\3\2\2\2=A\7\5\2\2>@\5"+
		"\b\5\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BE\3\2\2\2CA\3\2\2\2D=\3"+
		"\2\2\2DE\3\2\2\2EM\3\2\2\2FJ\7\6\2\2GI\5\n\6\2HG\3\2\2\2IL\3\2\2\2JH\3"+
		"\2\2\2JK\3\2\2\2KN\3\2\2\2LJ\3\2\2\2MF\3\2\2\2MN\3\2\2\2N\5\3\2\2\2OT"+
		"\5\f\7\2PT\5\16\b\2QT\5\20\t\2RT\5\22\n\2SO\3\2\2\2SP\3\2\2\2SQ\3\2\2"+
		"\2SR\3\2\2\2T\7\3\2\2\2UW\7\7\2\2VU\3\2\2\2VW\3\2\2\2WX\3\2\2\2X`\5&\24"+
		"\2Y]\7\b\2\2Z\\\5\26\f\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^a\3"+
		"\2\2\2_]\3\2\2\2`Y\3\2\2\2`a\3\2\2\2ai\3\2\2\2bf\7\t\2\2ce\5\30\r\2dc"+
		"\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gj\3\2\2\2hf\3\2\2\2ib\3\2\2\2i"+
		"j\3\2\2\2j\t\3\2\2\2km\7\n\2\2lk\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\5&\24\2"+
		"op\7\13\2\2pq\5&\24\2qr\7\f\2\2rs\7/\2\2st\7\r\2\2tu\5&\24\2uv\7\f\2\2"+
		"v~\7/\2\2w{\7\t\2\2xz\5\30\r\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2"+
		"|\177\3\2\2\2}{\3\2\2\2~w\3\2\2\2~\177\3\2\2\2\177\13\3\2\2\2\u0080\u0081"+
		"\7\16\2\2\u0081\u0082\5&\24\2\u0082\u0083\7\17\2\2\u0083\u0084\5\34\17"+
		"\2\u0084\r\3\2\2\2\u0085\u0086\7\20\2\2\u0086\u0090\5&\24\2\u0087\u0088"+
		"\7\21\2\2\u0088\u008d\5&\24\2\u0089\u008a\7\22\2\2\u008a\u008c\5&\24\2"+
		"\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0087\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u009c\3\2\2\2\u0092\u0093\7\23\2\2\u0093\u0098\7"+
		"/\2\2\u0094\u0095\7\22\2\2\u0095\u0097\7/\2\2\u0096\u0094\3\2\2\2\u0097"+
		"\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009b\u009d\7\24\2\2\u009c\u0092\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\17\3\2\2\2\u009e\u009f\7\25\2\2\u009f\u00a9\5&\24"+
		"\2\u00a0\u00a1\7\21\2\2\u00a1\u00a6\5&\24\2\u00a2\u00a3\7\22\2\2\u00a3"+
		"\u00a5\5&\24\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2"+
		"\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00a0\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\21\3\2\2\2\u00ab\u00ac\7\26\2"+
		"\2\u00ac\u00ae\5&\24\2\u00ad\u00af\5\24\13\2\u00ae\u00ad\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\23\3\2\2"+
		"\2\u00b2\u00b3\7/\2\2\u00b3\u00b4\7\13\2\2\u00b4\u00b5\5\34\17\2\u00b5"+
		"\25\3\2\2\2\u00b6\u00b7\t\2\2\2\u00b7\u00b8\7/\2\2\u00b8\27\3\2\2\2\u00b9"+
		"\u00ba\7/\2\2\u00ba\u00bb\7\13\2\2\u00bb\u00be\5\34\17\2\u00bc\u00bd\7"+
		"\17\2\2\u00bd\u00bf\5\"\22\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\31\3\2\2\2\u00c0\u00c1\5&\24\2\u00c1\u00c2\7\13\2\2\u00c2\u00c3\5\34"+
		"\17\2\u00c3\u00c4\7\17\2\2\u00c4\u00c5\5\"\22\2\u00c5\33\3\2\2\2\u00c6"+
		"\u00de\5\36\20\2\u00c7\u00c8\7\31\2\2\u00c8\u00c9\7\32\2\2\u00c9\u00ca"+
		"\5\34\17\2\u00ca\u00cb\7\33\2\2\u00cb\u00de\3\2\2\2\u00cc\u00cd\7\34\2"+
		"\2\u00cd\u00ce\7\32\2\2\u00ce\u00cf\5\34\17\2\u00cf\u00d0\7\33\2\2\u00d0"+
		"\u00de\3\2\2\2\u00d1\u00d2\7\35\2\2\u00d2\u00d3\7\32\2\2\u00d3\u00d4\5"+
		"\34\17\2\u00d4\u00d5\7\33\2\2\u00d5\u00de\3\2\2\2\u00d6\u00d7\7\36\2\2"+
		"\u00d7\u00d8\7\32\2\2\u00d8\u00d9\5\36\20\2\u00d9\u00da\7\22\2\2\u00da"+
		"\u00db\5\34\17\2\u00db\u00dc\7\33\2\2\u00dc\u00de\3\2\2\2\u00dd\u00c6"+
		"\3\2\2\2\u00dd\u00c7\3\2\2\2\u00dd\u00cc\3\2\2\2\u00dd\u00d1\3\2\2\2\u00dd"+
		"\u00d6\3\2\2\2\u00de\35\3\2\2\2\u00df\u00ef\7\37\2\2\u00e0\u00e7\7 \2"+
		"\2\u00e1\u00e2\7!\2\2\u00e2\u00e3\5 \21\2\u00e3\u00e4\7\22\2\2\u00e4\u00e5"+
		"\5 \21\2\u00e5\u00e6\7\"\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e1\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00ef\3\2\2\2\u00e9\u00ef\7#\2\2\u00ea\u00ef\7$\2"+
		"\2\u00eb\u00ef\7\7\2\2\u00ec\u00ef\7%\2\2\u00ed\u00ef\5&\24\2\u00ee\u00df"+
		"\3\2\2\2\u00ee\u00e0\3\2\2\2\u00ee\u00e9\3\2\2\2\u00ee\u00ea\3\2\2\2\u00ee"+
		"\u00eb\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\37\3\2\2"+
		"\2\u00f0\u00f4\7,\2\2\u00f1\u00f4\5&\24\2\u00f2\u00f4\7&\2\2\u00f3\u00f0"+
		"\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4!\3\2\2\2\u00f5"+
		"\u0159\7\'\2\2\u00f6\u0159\7(\2\2\u00f7\u0159\7,\2\2\u00f8\u0159\7-\2"+
		"\2\u00f9\u0159\7.\2\2\u00fa\u00fb\5&\24\2\u00fb\u00fc\7!\2\2\u00fc\u00fd"+
		"\7/\2\2\u00fd\u00fe\7\17\2\2\u00fe\u0105\5\"\22\2\u00ff\u0100\7\22\2\2"+
		"\u0100\u0101\7/\2\2\u0101\u0102\7\17\2\2\u0102\u0104\5\"\22\2\u0103\u00ff"+
		"\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\u0108\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7\"\2\2\u0109\u0159\3\2"+
		"\2\2\u010a\u010d\5&\24\2\u010b\u010c\7\f\2\2\u010c\u010e\7/\2\2\u010d"+
		"\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0159\3\2\2\2\u010f\u0110\7\7"+
		"\2\2\u0110\u0159\5&\24\2\u0111\u0112\7%\2\2\u0112\u0113\5&\24\2\u0113"+
		"\u0114\7\f\2\2\u0114\u0115\7/\2\2\u0115\u0159\3\2\2\2\u0116\u0117\7)\2"+
		"\2\u0117\u0118\7\32\2\2\u0118\u0119\5\34\17\2\u0119\u011a\7\33\2\2\u011a"+
		"\u0159\3\2\2\2\u011b\u011c\7*\2\2\u011c\u011d\7\32\2\2\u011d\u011e\5\34"+
		"\17\2\u011e\u011f\7\33\2\2\u011f\u0120\7!\2\2\u0120\u0121\5\"\22\2\u0121"+
		"\u0122\7\"\2\2\u0122\u0159\3\2\2\2\u0123\u0124\7\34\2\2\u0124\u0125\7"+
		"\32\2\2\u0125\u0126\5\34\17\2\u0126\u0127\7\33\2\2\u0127\u0130\7!\2\2"+
		"\u0128\u012d\5\"\22\2\u0129\u012a\7\22\2\2\u012a\u012c\5\"\22\2\u012b"+
		"\u0129\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2"+
		"\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0128\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\7\"\2\2\u0133\u0159\3\2"+
		"\2\2\u0134\u0135\7\35\2\2\u0135\u0136\7\32\2\2\u0136\u0137\5\34\17\2\u0137"+
		"\u0138\7\33\2\2\u0138\u0141\7!\2\2\u0139\u013e\5\"\22\2\u013a\u013b\7"+
		"\22\2\2\u013b\u013d\5\"\22\2\u013c\u013a\3\2\2\2\u013d\u0140\3\2\2\2\u013e"+
		"\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2"+
		"\2\2\u0141\u0139\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\3\2\2\2\u0143"+
		"\u0144\7\"\2\2\u0144\u0159\3\2\2\2\u0145\u0146\7\36\2\2\u0146\u0147\7"+
		"\32\2\2\u0147\u0148\5\36\20\2\u0148\u0149\7\22\2\2\u0149\u014a\5\34\17"+
		"\2\u014a\u014b\7\33\2\2\u014b\u0154\7!\2\2\u014c\u0151\5$\23\2\u014d\u014e"+
		"\7\22\2\2\u014e\u0150\5$\23\2\u014f\u014d\3\2\2\2\u0150\u0153\3\2\2\2"+
		"\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0155\3\2\2\2\u0153\u0151"+
		"\3\2\2\2\u0154\u014c\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\3\2\2\2\u0156"+
		"\u0157\7\"\2\2\u0157\u0159\3\2\2\2\u0158\u00f5\3\2\2\2\u0158\u00f6\3\2"+
		"\2\2\u0158\u00f7\3\2\2\2\u0158\u00f8\3\2\2\2\u0158\u00f9\3\2\2\2\u0158"+
		"\u00fa\3\2\2\2\u0158\u010a\3\2\2\2\u0158\u010f\3\2\2\2\u0158\u0111\3\2"+
		"\2\2\u0158\u0116\3\2\2\2\u0158\u011b\3\2\2\2\u0158\u0123\3\2\2\2\u0158"+
		"\u0134\3\2\2\2\u0158\u0145\3\2\2\2\u0159#\3\2\2\2\u015a\u015b\5\"\22\2"+
		"\u015b\u015c\7\r\2\2\u015c\u015d\5\"\22\2\u015d%\3\2\2\2\u015e\u0163\7"+
		"/\2\2\u015f\u0160\7+\2\2\u0160\u0162\7/\2\2\u0161\u015f\3\2\2\2\u0162"+
		"\u0165\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\'\3\2\2\2"+
		"\u0165\u0163\3\2\2\2)/\628;ADJMSV]`fil{~\u008d\u0090\u0098\u009c\u00a6"+
		"\u00a9\u00b0\u00be\u00dd\u00e7\u00ee\u00f3\u0105\u010d\u012d\u0130\u013e"+
		"\u0141\u0151\u0154\u0158\u0163";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}