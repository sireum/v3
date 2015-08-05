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
		RULE_recordDecl = 8, RULE_field = 9, RULE_port = 10, RULE_flow = 11, RULE_property = 12, 
		RULE_constantDecl = 13, RULE_type = 14, RULE_basicType = 15, RULE_intConstant = 16, 
		RULE_init = 17, RULE_mapEntry = 18, RULE_name = 19;
	public static final String[] ruleNames = {
		"modelFile", "model", "typeDecl", "componentDecl", "connectionDecl", "typeAliasDecl", 
		"enumDecl", "latticeDecl", "recordDecl", "field", "port", "flow", "property", 
		"constantDecl", "type", "basicType", "intConstant", "init", "mapEntry", 
		"name"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'types'", "'constants'", "'components'", "'connections'", "'ports'", 
		"'flows'", "'properties'", "':'", "'.'", "'{'", "','", "'}'", "'->'", 
		"'alias'", "'='", "'enum'", "'extends'", "'lattice'", "'record'", "'in'", 
		"'out'", "'_'", "'Option'", "'['", "']'", "'Set'", "'Seq'", "'Map'", "'Boolean'", 
		"'Integer'", "'('", "')'", "'Real'", "'String'", "'component'", "'port'", 
		"'true'", "'false'", "'None'", "'Some'", "'::'"
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18))) != 0)) {
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
				while (_la==ID) {
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
				while (_la==ID) {
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
		public TypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecl; }
	}

	public final TypeDeclContext typeDecl() throws RecognitionException {
		TypeDeclContext _localctx = new TypeDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeDecl);
		try {
			setState(83);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				typeAliasDecl();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				enumDecl();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				latticeDecl();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(82);
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
		public List<FlowContext> flow() {
			return getRuleContexts(FlowContext.class);
		}
		public FlowContext flow(int i) {
			return getRuleContext(FlowContext.class,i);
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
			setState(85);
			name();
			setState(93);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(86);
				match(T__4);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__19 || _la==T__20) {
					{
					{
					setState(87);
					port();
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(102);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(95);
				match(T__5);
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(96);
						flow();
						}
						} 
					}
					setState(101);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				}
			}

			setState(111);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(104);
				match(T__6);
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(105);
						property();
						}
						} 
					}
					setState(110);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public NameContext name;
		public List<NameContext> fromE = new ArrayList<NameContext>();
		public NameContext toComponent;
		public Token toPort;
		public List<NameContext> toE = new ArrayList<NameContext>();
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
			setState(113);
			name();
			setState(114);
			match(T__7);
			setState(115);
			((ConnectionDeclContext)_localctx).fromComponent = name();
			setState(116);
			match(T__8);
			setState(117);
			((ConnectionDeclContext)_localctx).fromPort = match(ID);
			setState(129);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(118);
				match(T__9);
				setState(119);
				((ConnectionDeclContext)_localctx).name = name();
				((ConnectionDeclContext)_localctx).fromE.add(((ConnectionDeclContext)_localctx).name);
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(120);
					match(T__10);
					setState(121);
					((ConnectionDeclContext)_localctx).name = name();
					((ConnectionDeclContext)_localctx).fromE.add(((ConnectionDeclContext)_localctx).name);
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(127);
				match(T__11);
				}
			}

			setState(131);
			match(T__12);
			setState(132);
			((ConnectionDeclContext)_localctx).toComponent = name();
			setState(133);
			match(T__8);
			setState(134);
			((ConnectionDeclContext)_localctx).toPort = match(ID);
			setState(146);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(135);
				match(T__9);
				setState(136);
				((ConnectionDeclContext)_localctx).name = name();
				((ConnectionDeclContext)_localctx).toE.add(((ConnectionDeclContext)_localctx).name);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(137);
					match(T__10);
					setState(138);
					((ConnectionDeclContext)_localctx).name = name();
					((ConnectionDeclContext)_localctx).toE.add(((ConnectionDeclContext)_localctx).name);
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(144);
				match(T__11);
				}
			}

			setState(155);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(148);
				match(T__6);
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(149);
						property();
						}
						} 
					}
					setState(154);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
			setState(157);
			match(T__13);
			setState(158);
			name();
			setState(159);
			match(T__14);
			setState(160);
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
			setState(162);
			match(T__15);
			setState(163);
			((EnumDeclContext)_localctx).n = name();
			setState(173);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(164);
				match(T__16);
				setState(165);
				((EnumDeclContext)_localctx).name = name();
				((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).name);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(166);
					match(T__10);
					setState(167);
					((EnumDeclContext)_localctx).name = name();
					((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).name);
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(185);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(175);
				match(T__9);
				setState(176);
				((EnumDeclContext)_localctx).ID = match(ID);
				((EnumDeclContext)_localctx).elements.add(((EnumDeclContext)_localctx).ID);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(177);
					match(T__10);
					setState(178);
					((EnumDeclContext)_localctx).ID = match(ID);
					((EnumDeclContext)_localctx).elements.add(((EnumDeclContext)_localctx).ID);
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(184);
				match(T__11);
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
			setState(187);
			match(T__17);
			setState(188);
			((LatticeDeclContext)_localctx).n = name();
			setState(198);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(189);
				match(T__16);
				setState(190);
				((LatticeDeclContext)_localctx).name = name();
				((LatticeDeclContext)_localctx).supers.add(((LatticeDeclContext)_localctx).name);
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(191);
					match(T__10);
					setState(192);
					((LatticeDeclContext)_localctx).name = name();
					((LatticeDeclContext)_localctx).supers.add(((LatticeDeclContext)_localctx).name);
					}
					}
					setState(197);
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
			setState(200);
			match(T__18);
			setState(201);
			name();
			setState(203); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(202);
				field();
				}
				}
				setState(205); 
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
			setState(207);
			match(ID);
			setState(208);
			match(T__7);
			setState(209);
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
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
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
			setState(211);
			((PortContext)_localctx).mod = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__19 || _la==T__20) ) {
				((PortContext)_localctx).mod = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(212);
			match(ID);
			setState(215);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(213);
				match(T__7);
				setState(214);
				name();
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

	public static class FlowContext extends ParserRuleContext {
		public Token id;
		public Token from;
		public NameContext name;
		public List<NameContext> fromE = new ArrayList<NameContext>();
		public Token to;
		public List<NameContext> toE = new ArrayList<NameContext>();
		public List<TerminalNode> ID() { return getTokens(Antlr4AwasParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4AwasParser.ID, i);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public FlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flow; }
	}

	public final FlowContext flow() throws RecognitionException {
		FlowContext _localctx = new FlowContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_flow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			((FlowContext)_localctx).id = match(ID);
			setState(218);
			match(T__7);
			setState(232);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(219);
				((FlowContext)_localctx).from = match(ID);
				setState(220);
				match(T__9);
				setState(221);
				((FlowContext)_localctx).name = name();
				((FlowContext)_localctx).fromE.add(((FlowContext)_localctx).name);
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(222);
					match(T__10);
					setState(223);
					((FlowContext)_localctx).name = name();
					((FlowContext)_localctx).fromE.add(((FlowContext)_localctx).name);
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(229);
				match(T__11);
				}
				break;
			case T__21:
				{
				setState(231);
				match(T__21);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(234);
			match(T__12);
			setState(248);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(235);
				((FlowContext)_localctx).to = match(ID);
				setState(236);
				match(T__9);
				setState(237);
				((FlowContext)_localctx).name = name();
				((FlowContext)_localctx).toE.add(((FlowContext)_localctx).name);
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(238);
					match(T__10);
					setState(239);
					((FlowContext)_localctx).name = name();
					((FlowContext)_localctx).toE.add(((FlowContext)_localctx).name);
					}
					}
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(245);
				match(T__11);
				}
				break;
			case T__21:
				{
				setState(247);
				match(T__21);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
			setState(250);
			match(ID);
			setState(251);
			match(T__7);
			setState(252);
			type();
			setState(255);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(253);
				match(T__14);
				setState(254);
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
			setState(257);
			name();
			setState(258);
			match(T__7);
			setState(259);
			type();
			setState(260);
			match(T__14);
			setState(261);
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
			setState(286);
			switch (_input.LA(1)) {
			case T__28:
			case T__29:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case ID:
				_localctx = new BaseTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				basicType();
				}
				break;
			case T__22:
				_localctx = new OptionTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				match(T__22);
				setState(265);
				match(T__23);
				setState(266);
				type();
				setState(267);
				match(T__24);
				}
				break;
			case T__25:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(269);
				match(T__25);
				setState(270);
				match(T__23);
				setState(271);
				type();
				setState(272);
				match(T__24);
				}
				break;
			case T__26:
				_localctx = new SeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(274);
				match(T__26);
				setState(275);
				match(T__23);
				setState(276);
				type();
				setState(277);
				match(T__24);
				}
				break;
			case T__27:
				_localctx = new MapTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(279);
				match(T__27);
				setState(280);
				match(T__23);
				setState(281);
				basicType();
				setState(282);
				match(T__10);
				setState(283);
				type();
				setState(284);
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
		enterRule(_localctx, 30, RULE_basicType);
		int _la;
		try {
			setState(303);
			switch (_input.LA(1)) {
			case T__28:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(T__28);
				}
				break;
			case T__29:
				_localctx = new IntegerTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				match(T__29);
				setState(296);
				_la = _input.LA(1);
				if (_la==T__30) {
					{
					setState(290);
					match(T__30);
					setState(291);
					((IntegerTypeContext)_localctx).lo = intConstant();
					setState(292);
					match(T__10);
					setState(293);
					((IntegerTypeContext)_localctx).hi = intConstant();
					setState(294);
					match(T__31);
					}
				}

				}
				break;
			case T__32:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
				match(T__32);
				}
				break;
			case T__33:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(299);
				match(T__33);
				}
				break;
			case T__34:
				_localctx = new ComponentTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(300);
				match(T__34);
				}
				break;
			case T__35:
				_localctx = new PortTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(301);
				match(T__35);
				}
				break;
			case ID:
				_localctx = new NamedTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(302);
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
			setState(308);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new LitIntConstantContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				match(INTEGER);
				}
				break;
			case ID:
				_localctx = new NamedIntConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
				name();
				}
				break;
			case T__21:
				_localctx = new ArbitraryIntConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(307);
				match(T__21);
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
		enterRule(_localctx, 34, RULE_init);
		int _la;
		try {
			setState(409);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				match(T__36);
				}
				break;
			case 2:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				match(T__37);
				}
				break;
			case 3:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(312);
				match(INTEGER);
				}
				break;
			case 4:
				_localctx = new RealContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(313);
				match(REAL);
				}
				break;
			case 5:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(314);
				match(STRING);
				}
				break;
			case 6:
				_localctx = new RecordContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(315);
				name();
				setState(316);
				match(T__30);
				setState(317);
				match(ID);
				setState(318);
				match(T__14);
				setState(319);
				init();
				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(320);
					match(T__10);
					setState(321);
					match(ID);
					setState(322);
					match(T__14);
					setState(323);
					init();
					}
					}
					setState(328);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(329);
				match(T__31);
				}
				break;
			case 7:
				_localctx = new EnumOrLatticeOrConstantContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(331);
				name();
				setState(334);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(332);
					match(T__8);
					setState(333);
					match(ID);
					}
				}

				}
				break;
			case 8:
				_localctx = new ComponentRefContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(336);
				match(T__34);
				setState(337);
				name();
				}
				break;
			case 9:
				_localctx = new PortRefContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(338);
				match(T__35);
				setState(339);
				name();
				setState(340);
				match(T__8);
				setState(341);
				match(ID);
				}
				break;
			case 10:
				_localctx = new NoneContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(343);
				match(T__38);
				setState(344);
				match(T__23);
				setState(345);
				type();
				setState(346);
				match(T__24);
				}
				break;
			case 11:
				_localctx = new SomeContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(348);
				match(T__39);
				setState(349);
				match(T__23);
				setState(350);
				type();
				setState(351);
				match(T__24);
				setState(352);
				match(T__30);
				setState(353);
				init();
				setState(354);
				match(T__31);
				}
				break;
			case 12:
				_localctx = new SetContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(356);
				match(T__25);
				setState(357);
				match(T__23);
				setState(358);
				type();
				setState(359);
				match(T__24);
				setState(360);
				match(T__30);
				setState(369);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(361);
					init();
					setState(366);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(362);
						match(T__10);
						setState(363);
						init();
						}
						}
						setState(368);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(371);
				match(T__31);
				}
				break;
			case 13:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(373);
				match(T__26);
				setState(374);
				match(T__23);
				setState(375);
				type();
				setState(376);
				match(T__24);
				setState(377);
				match(T__30);
				setState(386);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(378);
					init();
					setState(383);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(379);
						match(T__10);
						setState(380);
						init();
						}
						}
						setState(385);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(388);
				match(T__31);
				}
				break;
			case 14:
				_localctx = new MapContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(390);
				match(T__27);
				setState(391);
				match(T__23);
				setState(392);
				basicType();
				setState(393);
				match(T__10);
				setState(394);
				type();
				setState(395);
				match(T__24);
				setState(396);
				match(T__30);
				setState(405);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(397);
					mapEntry();
					setState(402);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(398);
						match(T__10);
						setState(399);
						mapEntry();
						}
						}
						setState(404);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(407);
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
		enterRule(_localctx, 36, RULE_mapEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			((MapEntryContext)_localctx).key = init();
			setState(412);
			match(T__12);
			setState(413);
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
			setState(415);
			match(ID);
			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__40) {
				{
				{
				setState(416);
				match(T__40);
				setState(417);
				match(ID);
				}
				}
				setState(422);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63\u01aa\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\3\3\3\7\3\60\n\3\f\3\16\3"+
		"\63\13\3\5\3\65\n\3\3\3\3\3\7\39\n\3\f\3\16\3<\13\3\5\3>\n\3\3\3\3\3\7"+
		"\3B\n\3\f\3\16\3E\13\3\5\3G\n\3\3\3\3\3\7\3K\n\3\f\3\16\3N\13\3\5\3P\n"+
		"\3\3\4\3\4\3\4\3\4\5\4V\n\4\3\5\3\5\3\5\7\5[\n\5\f\5\16\5^\13\5\5\5`\n"+
		"\5\3\5\3\5\7\5d\n\5\f\5\16\5g\13\5\5\5i\n\5\3\5\3\5\7\5m\n\5\f\5\16\5"+
		"p\13\5\5\5r\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6}\n\6\f\6\16\6"+
		"\u0080\13\6\3\6\3\6\5\6\u0084\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6"+
		"\u008e\n\6\f\6\16\6\u0091\13\6\3\6\3\6\5\6\u0095\n\6\3\6\3\6\7\6\u0099"+
		"\n\6\f\6\16\6\u009c\13\6\5\6\u009e\n\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\7\b\u00ab\n\b\f\b\16\b\u00ae\13\b\5\b\u00b0\n\b\3\b\3\b\3"+
		"\b\3\b\7\b\u00b6\n\b\f\b\16\b\u00b9\13\b\3\b\5\b\u00bc\n\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\7\t\u00c4\n\t\f\t\16\t\u00c7\13\t\5\t\u00c9\n\t\3\n\3\n\3"+
		"\n\6\n\u00ce\n\n\r\n\16\n\u00cf\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\5"+
		"\f\u00da\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00e3\n\r\f\r\16\r\u00e6"+
		"\13\r\3\r\3\r\3\r\5\r\u00eb\n\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00f3\n\r"+
		"\f\r\16\r\u00f6\13\r\3\r\3\r\3\r\5\r\u00fb\n\r\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u0102\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u0121\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u012b\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u0132\n\21\3\22\3"+
		"\22\3\22\5\22\u0137\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\7\23\u0147\n\23\f\23\16\23\u014a\13\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u0151\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u016f\n\23\f\23\16\23\u0172\13"+
		"\23\5\23\u0174\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\7\23\u0180\n\23\f\23\16\23\u0183\13\23\5\23\u0185\n\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0193\n\23\f\23\16"+
		"\23\u0196\13\23\5\23\u0198\n\23\3\23\3\23\5\23\u019c\n\23\3\24\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\7\25\u01a5\n\25\f\25\16\25\u01a8\13\25\3\25\2"+
		"\2\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\3\3\2\26\27\u01dc"+
		"\2*\3\2\2\2\4\64\3\2\2\2\6U\3\2\2\2\bW\3\2\2\2\ns\3\2\2\2\f\u009f\3\2"+
		"\2\2\16\u00a4\3\2\2\2\20\u00bd\3\2\2\2\22\u00ca\3\2\2\2\24\u00d1\3\2\2"+
		"\2\26\u00d5\3\2\2\2\30\u00db\3\2\2\2\32\u00fc\3\2\2\2\34\u0103\3\2\2\2"+
		"\36\u0120\3\2\2\2 \u0131\3\2\2\2\"\u0136\3\2\2\2$\u019b\3\2\2\2&\u019d"+
		"\3\2\2\2(\u01a1\3\2\2\2*+\5\4\3\2+,\7\2\2\3,\3\3\2\2\2-\61\7\3\2\2.\60"+
		"\5\6\4\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\65\3\2\2"+
		"\2\63\61\3\2\2\2\64-\3\2\2\2\64\65\3\2\2\2\65=\3\2\2\2\66:\7\4\2\2\67"+
		"9\5\34\17\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;>\3\2\2\2<:\3\2"+
		"\2\2=\66\3\2\2\2=>\3\2\2\2>F\3\2\2\2?C\7\5\2\2@B\5\b\5\2A@\3\2\2\2BE\3"+
		"\2\2\2CA\3\2\2\2CD\3\2\2\2DG\3\2\2\2EC\3\2\2\2F?\3\2\2\2FG\3\2\2\2GO\3"+
		"\2\2\2HL\7\6\2\2IK\5\n\6\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MP\3"+
		"\2\2\2NL\3\2\2\2OH\3\2\2\2OP\3\2\2\2P\5\3\2\2\2QV\5\f\7\2RV\5\16\b\2S"+
		"V\5\20\t\2TV\5\22\n\2UQ\3\2\2\2UR\3\2\2\2US\3\2\2\2UT\3\2\2\2V\7\3\2\2"+
		"\2W_\5(\25\2X\\\7\7\2\2Y[\5\26\f\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3"+
		"\2\2\2]`\3\2\2\2^\\\3\2\2\2_X\3\2\2\2_`\3\2\2\2`h\3\2\2\2ae\7\b\2\2bd"+
		"\5\30\r\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fi\3\2\2\2ge\3\2\2\2"+
		"ha\3\2\2\2hi\3\2\2\2iq\3\2\2\2jn\7\t\2\2km\5\32\16\2lk\3\2\2\2mp\3\2\2"+
		"\2nl\3\2\2\2no\3\2\2\2or\3\2\2\2pn\3\2\2\2qj\3\2\2\2qr\3\2\2\2r\t\3\2"+
		"\2\2st\5(\25\2tu\7\n\2\2uv\5(\25\2vw\7\13\2\2w\u0083\7/\2\2xy\7\f\2\2"+
		"y~\5(\25\2z{\7\r\2\2{}\5(\25\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177"+
		"\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\16\2\2\u0082\u0084"+
		"\3\2\2\2\u0083x\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0086\7\17\2\2\u0086\u0087\5(\25\2\u0087\u0088\7\13\2\2\u0088\u0094\7"+
		"/\2\2\u0089\u008a\7\f\2\2\u008a\u008f\5(\25\2\u008b\u008c\7\r\2\2\u008c"+
		"\u008e\5(\25\2\u008d\u008b\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0093\7\16\2\2\u0093\u0095\3\2\2\2\u0094\u0089\3\2\2\2\u0094\u0095\3"+
		"\2\2\2\u0095\u009d\3\2\2\2\u0096\u009a\7\t\2\2\u0097\u0099\5\32\16\2\u0098"+
		"\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2"+
		"\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u0096\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\13\3\2\2\2\u009f\u00a0\7\20\2\2\u00a0\u00a1\5(\25"+
		"\2\u00a1\u00a2\7\21\2\2\u00a2\u00a3\5\36\20\2\u00a3\r\3\2\2\2\u00a4\u00a5"+
		"\7\22\2\2\u00a5\u00af\5(\25\2\u00a6\u00a7\7\23\2\2\u00a7\u00ac\5(\25\2"+
		"\u00a8\u00a9\7\r\2\2\u00a9\u00ab\5(\25\2\u00aa\u00a8\3\2\2\2\u00ab\u00ae"+
		"\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00a6\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00bb\3\2"+
		"\2\2\u00b1\u00b2\7\f\2\2\u00b2\u00b7\7/\2\2\u00b3\u00b4\7\r\2\2\u00b4"+
		"\u00b6\7/\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2"+
		"\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba"+
		"\u00bc\7\16\2\2\u00bb\u00b1\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\17\3\2\2"+
		"\2\u00bd\u00be\7\24\2\2\u00be\u00c8\5(\25\2\u00bf\u00c0\7\23\2\2\u00c0"+
		"\u00c5\5(\25\2\u00c1\u00c2\7\r\2\2\u00c2\u00c4\5(\25\2\u00c3\u00c1\3\2"+
		"\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00bf\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\21\3\2\2\2\u00ca\u00cb\7\25\2\2\u00cb\u00cd\5(\25\2\u00cc\u00ce"+
		"\5\24\13\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00cd\3\2\2\2"+
		"\u00cf\u00d0\3\2\2\2\u00d0\23\3\2\2\2\u00d1\u00d2\7/\2\2\u00d2\u00d3\7"+
		"\n\2\2\u00d3\u00d4\5\36\20\2\u00d4\25\3\2\2\2\u00d5\u00d6\t\2\2\2\u00d6"+
		"\u00d9\7/\2\2\u00d7\u00d8\7\n\2\2\u00d8\u00da\5(\25\2\u00d9\u00d7\3\2"+
		"\2\2\u00d9\u00da\3\2\2\2\u00da\27\3\2\2\2\u00db\u00dc\7/\2\2\u00dc\u00ea"+
		"\7\n\2\2\u00dd\u00de\7/\2\2\u00de\u00df\7\f\2\2\u00df\u00e4\5(\25\2\u00e0"+
		"\u00e1\7\r\2\2\u00e1\u00e3\5(\25\2\u00e2\u00e0\3\2\2\2\u00e3\u00e6\3\2"+
		"\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e7\u00e8\7\16\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00eb\7"+
		"\30\2\2\u00ea\u00dd\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00fa\7\17\2\2\u00ed\u00ee\7/\2\2\u00ee\u00ef\7\f\2\2\u00ef\u00f4\5("+
		"\25\2\u00f0\u00f1\7\r\2\2\u00f1\u00f3\5(\25\2\u00f2\u00f0\3\2\2\2\u00f3"+
		"\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2"+
		"\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8\7\16\2\2\u00f8\u00fb\3\2\2\2\u00f9"+
		"\u00fb\7\30\2\2\u00fa\u00ed\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb\31\3\2\2"+
		"\2\u00fc\u00fd\7/\2\2\u00fd\u00fe\7\n\2\2\u00fe\u0101\5\36\20\2\u00ff"+
		"\u0100\7\21\2\2\u0100\u0102\5$\23\2\u0101\u00ff\3\2\2\2\u0101\u0102\3"+
		"\2\2\2\u0102\33\3\2\2\2\u0103\u0104\5(\25\2\u0104\u0105\7\n\2\2\u0105"+
		"\u0106\5\36\20\2\u0106\u0107\7\21\2\2\u0107\u0108\5$\23\2\u0108\35\3\2"+
		"\2\2\u0109\u0121\5 \21\2\u010a\u010b\7\31\2\2\u010b\u010c\7\32\2\2\u010c"+
		"\u010d\5\36\20\2\u010d\u010e\7\33\2\2\u010e\u0121\3\2\2\2\u010f\u0110"+
		"\7\34\2\2\u0110\u0111\7\32\2\2\u0111\u0112\5\36\20\2\u0112\u0113\7\33"+
		"\2\2\u0113\u0121\3\2\2\2\u0114\u0115\7\35\2\2\u0115\u0116\7\32\2\2\u0116"+
		"\u0117\5\36\20\2\u0117\u0118\7\33\2\2\u0118\u0121\3\2\2\2\u0119\u011a"+
		"\7\36\2\2\u011a\u011b\7\32\2\2\u011b\u011c\5 \21\2\u011c\u011d\7\r\2\2"+
		"\u011d\u011e\5\36\20\2\u011e\u011f\7\33\2\2\u011f\u0121\3\2\2\2\u0120"+
		"\u0109\3\2\2\2\u0120\u010a\3\2\2\2\u0120\u010f\3\2\2\2\u0120\u0114\3\2"+
		"\2\2\u0120\u0119\3\2\2\2\u0121\37\3\2\2\2\u0122\u0132\7\37\2\2\u0123\u012a"+
		"\7 \2\2\u0124\u0125\7!\2\2\u0125\u0126\5\"\22\2\u0126\u0127\7\r\2\2\u0127"+
		"\u0128\5\"\22\2\u0128\u0129\7\"\2\2\u0129\u012b\3\2\2\2\u012a\u0124\3"+
		"\2\2\2\u012a\u012b\3\2\2\2\u012b\u0132\3\2\2\2\u012c\u0132\7#\2\2\u012d"+
		"\u0132\7$\2\2\u012e\u0132\7%\2\2\u012f\u0132\7&\2\2\u0130\u0132\5(\25"+
		"\2\u0131\u0122\3\2\2\2\u0131\u0123\3\2\2\2\u0131\u012c\3\2\2\2\u0131\u012d"+
		"\3\2\2\2\u0131\u012e\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0130\3\2\2\2\u0132"+
		"!\3\2\2\2\u0133\u0137\7,\2\2\u0134\u0137\5(\25\2\u0135\u0137\7\30\2\2"+
		"\u0136\u0133\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0135\3\2\2\2\u0137#\3"+
		"\2\2\2\u0138\u019c\7\'\2\2\u0139\u019c\7(\2\2\u013a\u019c\7,\2\2\u013b"+
		"\u019c\7-\2\2\u013c\u019c\7.\2\2\u013d\u013e\5(\25\2\u013e\u013f\7!\2"+
		"\2\u013f\u0140\7/\2\2\u0140\u0141\7\21\2\2\u0141\u0148\5$\23\2\u0142\u0143"+
		"\7\r\2\2\u0143\u0144\7/\2\2\u0144\u0145\7\21\2\2\u0145\u0147\5$\23\2\u0146"+
		"\u0142\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2"+
		"\2\2\u0149\u014b\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u014c\7\"\2\2\u014c"+
		"\u019c\3\2\2\2\u014d\u0150\5(\25\2\u014e\u014f\7\13\2\2\u014f\u0151\7"+
		"/\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u019c\3\2\2\2\u0152"+
		"\u0153\7%\2\2\u0153\u019c\5(\25\2\u0154\u0155\7&\2\2\u0155\u0156\5(\25"+
		"\2\u0156\u0157\7\13\2\2\u0157\u0158\7/\2\2\u0158\u019c\3\2\2\2\u0159\u015a"+
		"\7)\2\2\u015a\u015b\7\32\2\2\u015b\u015c\5\36\20\2\u015c\u015d\7\33\2"+
		"\2\u015d\u019c\3\2\2\2\u015e\u015f\7*\2\2\u015f\u0160\7\32\2\2\u0160\u0161"+
		"\5\36\20\2\u0161\u0162\7\33\2\2\u0162\u0163\7!\2\2\u0163\u0164\5$\23\2"+
		"\u0164\u0165\7\"\2\2\u0165\u019c\3\2\2\2\u0166\u0167\7\34\2\2\u0167\u0168"+
		"\7\32\2\2\u0168\u0169\5\36\20\2\u0169\u016a\7\33\2\2\u016a\u0173\7!\2"+
		"\2\u016b\u0170\5$\23\2\u016c\u016d\7\r\2\2\u016d\u016f\5$\23\2\u016e\u016c"+
		"\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171"+
		"\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u016b\3\2\2\2\u0173\u0174\3\2"+
		"\2\2\u0174\u0175\3\2\2\2\u0175\u0176\7\"\2\2\u0176\u019c\3\2\2\2\u0177"+
		"\u0178\7\35\2\2\u0178\u0179\7\32\2\2\u0179\u017a\5\36\20\2\u017a\u017b"+
		"\7\33\2\2\u017b\u0184\7!\2\2\u017c\u0181\5$\23\2\u017d\u017e\7\r\2\2\u017e"+
		"\u0180\5$\23\2\u017f\u017d\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2"+
		"\2\2\u0181\u0182\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0184"+
		"\u017c\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\7\""+
		"\2\2\u0187\u019c\3\2\2\2\u0188\u0189\7\36\2\2\u0189\u018a\7\32\2\2\u018a"+
		"\u018b\5 \21\2\u018b\u018c\7\r\2\2\u018c\u018d\5\36\20\2\u018d\u018e\7"+
		"\33\2\2\u018e\u0197\7!\2\2\u018f\u0194\5&\24\2\u0190\u0191\7\r\2\2\u0191"+
		"\u0193\5&\24\2\u0192\u0190\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2"+
		"\2\2\u0194\u0195\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0197"+
		"\u018f\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a\7\""+
		"\2\2\u019a\u019c\3\2\2\2\u019b\u0138\3\2\2\2\u019b\u0139\3\2\2\2\u019b"+
		"\u013a\3\2\2\2\u019b\u013b\3\2\2\2\u019b\u013c\3\2\2\2\u019b\u013d\3\2"+
		"\2\2\u019b\u014d\3\2\2\2\u019b\u0152\3\2\2\2\u019b\u0154\3\2\2\2\u019b"+
		"\u0159\3\2\2\2\u019b\u015e\3\2\2\2\u019b\u0166\3\2\2\2\u019b\u0177\3\2"+
		"\2\2\u019b\u0188\3\2\2\2\u019c%\3\2\2\2\u019d\u019e\5$\23\2\u019e\u019f"+
		"\7\17\2\2\u019f\u01a0\5$\23\2\u01a0\'\3\2\2\2\u01a1\u01a6\7/\2\2\u01a2"+
		"\u01a3\7+\2\2\u01a3\u01a5\7/\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a8\3\2\2"+
		"\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7)\3\2\2\2\u01a8\u01a6"+
		"\3\2\2\2\62\61\64:=CFLOU\\_ehnq~\u0083\u008f\u0094\u009a\u009d\u00ac\u00af"+
		"\u00b7\u00bb\u00c5\u00c8\u00cf\u00d9\u00e4\u00ea\u00f4\u00fa\u0101\u0120"+
		"\u012a\u0131\u0136\u0148\u0150\u0170\u0173\u0181\u0184\u0194\u0197\u019b"+
		"\u01a6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}