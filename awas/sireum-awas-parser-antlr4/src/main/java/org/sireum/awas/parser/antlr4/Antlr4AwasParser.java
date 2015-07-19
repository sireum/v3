// Generated from /Users/robby/Repositories/Sireum-Private/sireum-v3/awas/sireum-awas-parser-antlr4/src/main/resources/org/sireum/awas/parser/antlr4/Antlr4Awas.g4 by ANTLR 4.5.1
package org.sireum.awas.parser.antlr4;

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
		INTEGER=39, REAL=40, STRING=41, ID=42, WS=43, COMMENT=44, LINE_COMMENT=45, 
		ERROR_CHAR=46;
	public static final int
		RULE_modelFile = 0, RULE_model = 1, RULE_unitDecl = 2, RULE_namespaceDecl = 3, 
		RULE_name = 4, RULE_importEnumDecl = 5, RULE_enclosureDecl = 6, RULE_modelElement = 7, 
		RULE_componentDecl = 8, RULE_connectionDecl = 9, RULE_enumDecl = 10, RULE_states = 11, 
		RULE_transition = 12, RULE_dependency = 13, RULE_port = 14, RULE_portAlias = 15, 
		RULE_property = 16, RULE_type = 17, RULE_basicType = 18, RULE_init = 19, 
		RULE_mapEntry = 20;
	public static final String[] ruleNames = {
		"modelFile", "model", "unitDecl", "namespaceDecl", "name", "importEnumDecl", 
		"enclosureDecl", "modelElement", "componentDecl", "connectionDecl", "enumDecl", 
		"states", "transition", "dependency", "port", "portAlias", "property", 
		"type", "basicType", "init", "mapEntry"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'namespace'", "'::'", "'import'", "'as'", "'enclosure'", "'ports'", 
		"'for'", "'component'", "'dependencies'", "'properties'", "'connection'", 
		"'.'", "'->'", "'enum'", "'lattice'", "'extends'", "','", "'states'", 
		"'='", "'['", "']'", "'transitions'", "'-['", "']->'", "'in'", "'out'", 
		"':'", "'Set'", "'Seq'", "'Map'", "'Boolean'", "'Integer'", "'Real'", 
		"'String'", "'true'", "'false'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "INTEGER", "REAL", "STRING", "ID", "WS", "COMMENT", 
		"LINE_COMMENT", "ERROR_CHAR"
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
			setState(42);
			model();
			setState(43);
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
		public List<UnitDeclContext> unitDecl() {
			return getRuleContexts(UnitDeclContext.class);
		}
		public UnitDeclContext unitDecl(int i) {
			return getRuleContext(UnitDeclContext.class,i);
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
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__4) | (1L << T__7) | (1L << T__10) | (1L << T__13))) != 0)) {
				{
				{
				setState(45);
				unitDecl();
				}
				}
				setState(50);
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

	public static class UnitDeclContext extends ParserRuleContext {
		public NamespaceDeclContext namespaceDecl() {
			return getRuleContext(NamespaceDeclContext.class,0);
		}
		public List<ImportEnumDeclContext> importEnumDecl() {
			return getRuleContexts(ImportEnumDeclContext.class);
		}
		public ImportEnumDeclContext importEnumDecl(int i) {
			return getRuleContext(ImportEnumDeclContext.class,i);
		}
		public EnclosureDeclContext enclosureDecl() {
			return getRuleContext(EnclosureDeclContext.class,0);
		}
		public List<ModelElementContext> modelElement() {
			return getRuleContexts(ModelElementContext.class);
		}
		public ModelElementContext modelElement(int i) {
			return getRuleContext(ModelElementContext.class,i);
		}
		public UnitDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unitDecl; }
	}

	public final UnitDeclContext unitDecl() throws RecognitionException {
		UnitDeclContext _localctx = new UnitDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unitDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(51);
				namespaceDecl();
				}
			}

			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(54);
				importEnumDecl();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(60);
				enclosureDecl();
				}
			}

			setState(64); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(63);
					modelElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(66); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class NamespaceDeclContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public NamespaceDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceDecl; }
	}

	public final NamespaceDeclContext namespaceDecl() throws RecognitionException {
		NamespaceDeclContext _localctx = new NamespaceDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_namespaceDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__0);
			setState(69);
			name();
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
		enterRule(_localctx, 8, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(ID);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(72);
				match(T__1);
				setState(73);
				match(ID);
				}
				}
				setState(78);
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

	public static class ImportEnumDeclContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode ID() { return getToken(Antlr4AwasParser.ID, 0); }
		public ImportEnumDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importEnumDecl; }
	}

	public final ImportEnumDeclContext importEnumDecl() throws RecognitionException {
		ImportEnumDeclContext _localctx = new ImportEnumDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_importEnumDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__2);
			setState(80);
			name();
			setState(83);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(81);
				match(T__3);
				setState(82);
				match(ID);
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

	public static class EnclosureDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Antlr4AwasParser.ID, 0); }
		public List<PortContext> port() {
			return getRuleContexts(PortContext.class);
		}
		public PortContext port(int i) {
			return getRuleContext(PortContext.class,i);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<PortAliasContext> portAlias() {
			return getRuleContexts(PortAliasContext.class);
		}
		public PortAliasContext portAlias(int i) {
			return getRuleContext(PortAliasContext.class,i);
		}
		public EnclosureDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enclosureDecl; }
	}

	public final EnclosureDeclContext enclosureDecl() throws RecognitionException {
		EnclosureDeclContext _localctx = new EnclosureDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_enclosureDecl);
		int _la;
		try {
			setState(109);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(T__4);
				setState(86);
				match(ID);
				setState(94);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(87);
					match(T__5);
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__24 || _la==T__25) {
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

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				match(T__4);
				setState(97);
				match(ID);
				setState(98);
				match(T__6);
				setState(99);
				name();
				setState(107);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(100);
					match(T__5);
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << ID))) != 0)) {
						{
						{
						setState(101);
						portAlias();
						}
						}
						setState(106);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

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

	public static class ModelElementContext extends ParserRuleContext {
		public ComponentDeclContext componentDecl() {
			return getRuleContext(ComponentDeclContext.class,0);
		}
		public ConnectionDeclContext connectionDecl() {
			return getRuleContext(ConnectionDeclContext.class,0);
		}
		public EnumDeclContext enumDecl() {
			return getRuleContext(EnumDeclContext.class,0);
		}
		public ModelElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelElement; }
	}

	public final ModelElementContext modelElement() throws RecognitionException {
		ModelElementContext _localctx = new ModelElementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_modelElement);
		try {
			setState(114);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				componentDecl();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				connectionDecl();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				enumDecl();
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
		public TerminalNode ID() { return getToken(Antlr4AwasParser.ID, 0); }
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
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
		public List<DependencyContext> dependency() {
			return getRuleContexts(DependencyContext.class);
		}
		public DependencyContext dependency(int i) {
			return getRuleContext(DependencyContext.class,i);
		}
		public ComponentDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentDecl; }
	}

	public final ComponentDeclContext componentDecl() throws RecognitionException {
		ComponentDeclContext _localctx = new ComponentDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_componentDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__7);
			setState(117);
			match(ID);
			setState(134);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(118);
				match(T__5);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__24 || _la==T__25) {
					{
					{
					setState(119);
					port();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(132);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(125);
					match(T__8);
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==ID) {
						{
						{
						setState(126);
						dependency();
						}
						}
						setState(131);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
			}

			setState(143);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(136);
				match(T__9);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(137);
					property();
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(146);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(145);
				states();
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
		public Token fromComponent;
		public Token fromPort;
		public Token toComponent;
		public Token toPort;
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
		enterRule(_localctx, 18, RULE_connectionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__10);
			setState(149);
			((ConnectionDeclContext)_localctx).fromComponent = match(ID);
			setState(152);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(150);
				match(T__11);
				setState(151);
				((ConnectionDeclContext)_localctx).fromPort = match(ID);
				}
			}

			setState(154);
			match(T__12);
			setState(155);
			((ConnectionDeclContext)_localctx).toComponent = match(ID);
			setState(158);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(156);
				match(T__11);
				setState(157);
				((ConnectionDeclContext)_localctx).toPort = match(ID);
				}
			}

			setState(167);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(160);
				match(T__9);
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(161);
					property();
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

	public static class EnumDeclContext extends ParserRuleContext {
		public Token id;
		public Token ID;
		public List<Token> supers = new ArrayList<Token>();
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
		enterRule(_localctx, 20, RULE_enumDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__13);
			setState(171);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(170);
				match(T__14);
				}
			}

			setState(173);
			((EnumDeclContext)_localctx).id = match(ID);
			setState(183);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(174);
				match(T__15);
				setState(175);
				((EnumDeclContext)_localctx).ID = match(ID);
				((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).ID);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(176);
					match(T__16);
					setState(177);
					((EnumDeclContext)_localctx).ID = match(ID);
					((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).ID);
					}
					}
					setState(182);
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

	public static class StatesContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(Antlr4AwasParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4AwasParser.ID, i);
		}
		public List<TransitionContext> transition() {
			return getRuleContexts(TransitionContext.class);
		}
		public TransitionContext transition(int i) {
			return getRuleContext(TransitionContext.class,i);
		}
		public StatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_states; }
	}

	public final StatesContext states() throws RecognitionException {
		StatesContext _localctx = new StatesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_states);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__17);
			setState(186);
			match(T__18);
			setState(187);
			match(T__19);
			setState(188);
			match(ID);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(189);
				match(T__16);
				setState(190);
				match(ID);
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196);
			match(T__20);
			setState(204);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(197);
				match(T__21);
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(198);
					transition();
					}
					}
					setState(203);
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

	public static class TransitionContext extends ParserRuleContext {
		public Token fromState;
		public Token toState;
		public List<TerminalNode> ID() { return getTokens(Antlr4AwasParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4AwasParser.ID, i);
		}
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_transition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			((TransitionContext)_localctx).fromState = match(ID);
			setState(207);
			match(T__22);
			setState(208);
			match(T__23);
			setState(209);
			((TransitionContext)_localctx).toState = match(ID);
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

	public static class DependencyContext extends ParserRuleContext {
		public Token fromPort;
		public Token toPort;
		public List<TerminalNode> ID() { return getTokens(Antlr4AwasParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4AwasParser.ID, i);
		}
		public DependencyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependency; }
	}

	public final DependencyContext dependency() throws RecognitionException {
		DependencyContext _localctx = new DependencyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_dependency);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			((DependencyContext)_localctx).fromPort = match(ID);
			setState(212);
			match(T__12);
			setState(213);
			((DependencyContext)_localctx).toPort = match(ID);
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
		enterRule(_localctx, 28, RULE_port);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			((PortContext)_localctx).mod = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__24 || _la==T__25) ) {
				((PortContext)_localctx).mod = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(216);
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

	public static class PortAliasContext extends ParserRuleContext {
		public Token mod;
		public Token id;
		public Token alias;
		public List<TerminalNode> ID() { return getTokens(Antlr4AwasParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4AwasParser.ID, i);
		}
		public PortAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_portAlias; }
	}

	public final PortAliasContext portAlias() throws RecognitionException {
		PortAliasContext _localctx = new PortAliasContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_portAlias);
		int _la;
		try {
			setState(227);
			switch (_input.LA(1)) {
			case T__24:
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				((PortAliasContext)_localctx).mod = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__25) ) {
					((PortAliasContext)_localctx).mod = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(219);
				((PortAliasContext)_localctx).id = match(ID);
				setState(222);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(220);
					match(T__3);
					setState(221);
					((PortAliasContext)_localctx).alias = match(ID);
					}
				}

				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				((PortAliasContext)_localctx).id = match(ID);
				setState(225);
				match(T__3);
				setState(226);
				((PortAliasContext)_localctx).alias = match(ID);
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
		enterRule(_localctx, 32, RULE_property);
		int _la;
		try {
			setState(239);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				match(ID);
				setState(230);
				match(T__26);
				setState(231);
				type();
				setState(234);
				_la = _input.LA(1);
				if (_la==T__18) {
					{
					setState(232);
					match(T__18);
					setState(233);
					init();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(ID);
				setState(237);
				match(T__18);
				setState(238);
				init();
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
		enterRule(_localctx, 34, RULE_type);
		try {
			setState(259);
			switch (_input.LA(1)) {
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case ID:
				_localctx = new BaseTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				basicType();
				}
				break;
			case T__27:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				match(T__27);
				setState(243);
				match(T__19);
				setState(244);
				type();
				setState(245);
				match(T__20);
				}
				break;
			case T__28:
				_localctx = new SeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				match(T__28);
				setState(248);
				match(T__19);
				setState(249);
				type();
				setState(250);
				match(T__20);
				}
				break;
			case T__29:
				_localctx = new MapTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(252);
				match(T__29);
				setState(253);
				match(T__19);
				setState(254);
				basicType();
				setState(255);
				match(T__16);
				setState(256);
				type();
				setState(257);
				match(T__20);
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
		public IntegerTypeContext(BasicTypeContext ctx) { copyFrom(ctx); }
	}
	public static class StringTypeContext extends BasicTypeContext {
		public StringTypeContext(BasicTypeContext ctx) { copyFrom(ctx); }
	}
	public static class EnumTypeContext extends BasicTypeContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public EnumTypeContext(BasicTypeContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanTypeContext extends BasicTypeContext {
		public BooleanTypeContext(BasicTypeContext ctx) { copyFrom(ctx); }
	}
	public static class RealTypeContext extends BasicTypeContext {
		public RealTypeContext(BasicTypeContext ctx) { copyFrom(ctx); }
	}

	public final BasicTypeContext basicType() throws RecognitionException {
		BasicTypeContext _localctx = new BasicTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_basicType);
		try {
			setState(266);
			switch (_input.LA(1)) {
			case T__30:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				match(T__30);
				}
				break;
			case T__31:
				_localctx = new IntegerTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				match(T__31);
				}
				break;
			case T__32:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				match(T__32);
				}
				break;
			case T__33:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(264);
				match(T__33);
				}
				break;
			case ID:
				_localctx = new EnumTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(265);
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
	public static class IntegerContext extends InitContext {
		public TerminalNode INTEGER() { return getToken(Antlr4AwasParser.INTEGER, 0); }
		public IntegerContext(InitContext ctx) { copyFrom(ctx); }
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
	public static class RealContext extends InitContext {
		public TerminalNode REAL() { return getToken(Antlr4AwasParser.REAL, 0); }
		public RealContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class TrueContext extends InitContext {
		public TrueContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class FalseContext extends InitContext {
		public FalseContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class StringContext extends InitContext {
		public TerminalNode STRING() { return getToken(Antlr4AwasParser.STRING, 0); }
		public StringContext(InitContext ctx) { copyFrom(ctx); }
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
	public static class EnumElementContext extends InitContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public EnumElementContext(InitContext ctx) { copyFrom(ctx); }
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
		enterRule(_localctx, 38, RULE_init);
		int _la;
		try {
			setState(333);
			switch (_input.LA(1)) {
			case T__34:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				match(T__34);
				}
				break;
			case T__35:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				match(T__35);
				}
				break;
			case INTEGER:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(270);
				match(INTEGER);
				}
				break;
			case REAL:
				_localctx = new RealContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(271);
				match(REAL);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(272);
				match(STRING);
				}
				break;
			case ID:
				_localctx = new EnumElementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(273);
				name();
				}
				break;
			case T__27:
				_localctx = new SetContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(274);
				match(T__27);
				setState(279);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(275);
					match(T__19);
					setState(276);
					type();
					setState(277);
					match(T__20);
					}
				}

				setState(281);
				match(T__36);
				setState(290);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__34) | (1L << T__35) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(282);
					init();
					setState(287);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__16) {
						{
						{
						setState(283);
						match(T__16);
						setState(284);
						init();
						}
						}
						setState(289);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(292);
				match(T__37);
				}
				break;
			case T__28:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(293);
				match(T__28);
				setState(298);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(294);
					match(T__19);
					setState(295);
					type();
					setState(296);
					match(T__20);
					}
				}

				setState(300);
				match(T__36);
				setState(309);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__34) | (1L << T__35) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(301);
					init();
					setState(306);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__16) {
						{
						{
						setState(302);
						match(T__16);
						setState(303);
						init();
						}
						}
						setState(308);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(311);
				match(T__37);
				}
				break;
			case T__29:
				_localctx = new MapContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(312);
				match(T__29);
				setState(319);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(313);
					match(T__19);
					setState(314);
					basicType();
					setState(315);
					match(T__16);
					setState(316);
					type();
					setState(317);
					match(T__20);
					}
				}

				setState(321);
				match(T__36);
				setState(330);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__34) | (1L << T__35) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(322);
					mapEntry();
					setState(327);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__16) {
						{
						{
						setState(323);
						match(T__16);
						setState(324);
						mapEntry();
						}
						}
						setState(329);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(332);
				match(T__37);
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
		enterRule(_localctx, 40, RULE_mapEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			((MapEntryContext)_localctx).key = init();
			setState(336);
			match(T__12);
			setState(337);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\60\u0156\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\3\7\3\61\n\3\f"+
		"\3\16\3\64\13\3\3\4\5\4\67\n\4\3\4\7\4:\n\4\f\4\16\4=\13\4\3\4\5\4@\n"+
		"\4\3\4\6\4C\n\4\r\4\16\4D\3\5\3\5\3\5\3\6\3\6\3\6\7\6M\n\6\f\6\16\6P\13"+
		"\6\3\7\3\7\3\7\3\7\5\7V\n\7\3\b\3\b\3\b\3\b\7\b\\\n\b\f\b\16\b_\13\b\5"+
		"\ba\n\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bi\n\b\f\b\16\bl\13\b\5\bn\n\b\5\bp"+
		"\n\b\3\t\3\t\3\t\5\tu\n\t\3\n\3\n\3\n\3\n\7\n{\n\n\f\n\16\n~\13\n\3\n"+
		"\3\n\7\n\u0082\n\n\f\n\16\n\u0085\13\n\5\n\u0087\n\n\5\n\u0089\n\n\3\n"+
		"\3\n\7\n\u008d\n\n\f\n\16\n\u0090\13\n\5\n\u0092\n\n\3\n\5\n\u0095\n\n"+
		"\3\13\3\13\3\13\3\13\5\13\u009b\n\13\3\13\3\13\3\13\3\13\5\13\u00a1\n"+
		"\13\3\13\3\13\7\13\u00a5\n\13\f\13\16\13\u00a8\13\13\5\13\u00aa\n\13\3"+
		"\f\3\f\5\f\u00ae\n\f\3\f\3\f\3\f\3\f\3\f\7\f\u00b5\n\f\f\f\16\f\u00b8"+
		"\13\f\5\f\u00ba\n\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00c2\n\r\f\r\16\r\u00c5"+
		"\13\r\3\r\3\r\3\r\7\r\u00ca\n\r\f\r\16\r\u00cd\13\r\5\r\u00cf\n\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\5\21\u00e1\n\21\3\21\3\21\3\21\5\21\u00e6\n\21\3\22\3\22\3\22\3"+
		"\22\3\22\5\22\u00ed\n\22\3\22\3\22\3\22\5\22\u00f2\n\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u0106\n\23\3\24\3\24\3\24\3\24\3\24\5\24\u010d\n\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u011a\n\25\3\25"+
		"\3\25\3\25\3\25\7\25\u0120\n\25\f\25\16\25\u0123\13\25\5\25\u0125\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u012d\n\25\3\25\3\25\3\25\3\25\7\25"+
		"\u0133\n\25\f\25\16\25\u0136\13\25\5\25\u0138\n\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u0142\n\25\3\25\3\25\3\25\3\25\7\25\u0148\n"+
		"\25\f\25\16\25\u014b\13\25\5\25\u014d\n\25\3\25\5\25\u0150\n\25\3\26\3"+
		"\26\3\26\3\26\3\26\2\2\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*\2\3\3\2\33\34\u017b\2,\3\2\2\2\4\62\3\2\2\2\6\66\3\2\2\2\bF\3\2\2\2"+
		"\nI\3\2\2\2\fQ\3\2\2\2\16o\3\2\2\2\20t\3\2\2\2\22v\3\2\2\2\24\u0096\3"+
		"\2\2\2\26\u00ab\3\2\2\2\30\u00bb\3\2\2\2\32\u00d0\3\2\2\2\34\u00d5\3\2"+
		"\2\2\36\u00d9\3\2\2\2 \u00e5\3\2\2\2\"\u00f1\3\2\2\2$\u0105\3\2\2\2&\u010c"+
		"\3\2\2\2(\u014f\3\2\2\2*\u0151\3\2\2\2,-\5\4\3\2-.\7\2\2\3.\3\3\2\2\2"+
		"/\61\5\6\4\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63"+
		"\5\3\2\2\2\64\62\3\2\2\2\65\67\5\b\5\2\66\65\3\2\2\2\66\67\3\2\2\2\67"+
		";\3\2\2\28:\5\f\7\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<?\3\2\2\2"+
		"=;\3\2\2\2>@\5\16\b\2?>\3\2\2\2?@\3\2\2\2@B\3\2\2\2AC\5\20\t\2BA\3\2\2"+
		"\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\7\3\2\2\2FG\7\3\2\2GH\5\n\6\2H\t\3\2"+
		"\2\2IN\7,\2\2JK\7\4\2\2KM\7,\2\2LJ\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2"+
		"\2O\13\3\2\2\2PN\3\2\2\2QR\7\5\2\2RU\5\n\6\2ST\7\6\2\2TV\7,\2\2US\3\2"+
		"\2\2UV\3\2\2\2V\r\3\2\2\2WX\7\7\2\2X`\7,\2\2Y]\7\b\2\2Z\\\5\36\20\2[Z"+
		"\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^a\3\2\2\2_]\3\2\2\2`Y\3\2\2\2"+
		"`a\3\2\2\2ap\3\2\2\2bc\7\7\2\2cd\7,\2\2de\7\t\2\2em\5\n\6\2fj\7\b\2\2"+
		"gi\5 \21\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2kn\3\2\2\2lj\3\2\2\2"+
		"mf\3\2\2\2mn\3\2\2\2np\3\2\2\2oW\3\2\2\2ob\3\2\2\2p\17\3\2\2\2qu\5\22"+
		"\n\2ru\5\24\13\2su\5\26\f\2tq\3\2\2\2tr\3\2\2\2ts\3\2\2\2u\21\3\2\2\2"+
		"vw\7\n\2\2w\u0088\7,\2\2x|\7\b\2\2y{\5\36\20\2zy\3\2\2\2{~\3\2\2\2|z\3"+
		"\2\2\2|}\3\2\2\2}\u0086\3\2\2\2~|\3\2\2\2\177\u0083\7\13\2\2\u0080\u0082"+
		"\5\34\17\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2"+
		"\u0083\u0084\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0086\177"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088x\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\u0091\3\2\2\2\u008a\u008e\7\f\2\2\u008b\u008d\5\""+
		"\22\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u008a\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0095\5\30\r\2\u0094"+
		"\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\23\3\2\2\2\u0096\u0097\7\r\2"+
		"\2\u0097\u009a\7,\2\2\u0098\u0099\7\16\2\2\u0099\u009b\7,\2\2\u009a\u0098"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\7\17\2\2"+
		"\u009d\u00a0\7,\2\2\u009e\u009f\7\16\2\2\u009f\u00a1\7,\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a9\3\2\2\2\u00a2\u00a6\7\f\2\2\u00a3"+
		"\u00a5\5\"\22\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3"+
		"\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00a2\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\25\3\2\2\2\u00ab\u00ad\7\20\2"+
		"\2\u00ac\u00ae\7\21\2\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b9\7,\2\2\u00b0\u00b1\7\22\2\2\u00b1\u00b6\7,"+
		"\2\2\u00b2\u00b3\7\23\2\2\u00b3\u00b5\7,\2\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00ba\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00b0\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\27\3\2\2\2\u00bb\u00bc\7\24\2\2\u00bc\u00bd\7\25\2\2\u00bd\u00be\7\26"+
		"\2\2\u00be\u00c3\7,\2\2\u00bf\u00c0\7\23\2\2\u00c0\u00c2\7,\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00ce\7\27\2\2\u00c7"+
		"\u00cb\7\30\2\2\u00c8\u00ca\5\32\16\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd"+
		"\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00ce\u00c7\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\31\3\2\2"+
		"\2\u00d0\u00d1\7,\2\2\u00d1\u00d2\7\31\2\2\u00d2\u00d3\7\32\2\2\u00d3"+
		"\u00d4\7,\2\2\u00d4\33\3\2\2\2\u00d5\u00d6\7,\2\2\u00d6\u00d7\7\17\2\2"+
		"\u00d7\u00d8\7,\2\2\u00d8\35\3\2\2\2\u00d9\u00da\t\2\2\2\u00da\u00db\7"+
		",\2\2\u00db\37\3\2\2\2\u00dc\u00dd\t\2\2\2\u00dd\u00e0\7,\2\2\u00de\u00df"+
		"\7\6\2\2\u00df\u00e1\7,\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00e6\3\2\2\2\u00e2\u00e3\7,\2\2\u00e3\u00e4\7\6\2\2\u00e4\u00e6\7,\2"+
		"\2\u00e5\u00dc\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e6!\3\2\2\2\u00e7\u00e8"+
		"\7,\2\2\u00e8\u00e9\7\35\2\2\u00e9\u00ec\5$\23\2\u00ea\u00eb\7\25\2\2"+
		"\u00eb\u00ed\5(\25\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f2"+
		"\3\2\2\2\u00ee\u00ef\7,\2\2\u00ef\u00f0\7\25\2\2\u00f0\u00f2\5(\25\2\u00f1"+
		"\u00e7\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f2#\3\2\2\2\u00f3\u0106\5&\24\2"+
		"\u00f4\u00f5\7\36\2\2\u00f5\u00f6\7\26\2\2\u00f6\u00f7\5$\23\2\u00f7\u00f8"+
		"\7\27\2\2\u00f8\u0106\3\2\2\2\u00f9\u00fa\7\37\2\2\u00fa\u00fb\7\26\2"+
		"\2\u00fb\u00fc\5$\23\2\u00fc\u00fd\7\27\2\2\u00fd\u0106\3\2\2\2\u00fe"+
		"\u00ff\7 \2\2\u00ff\u0100\7\26\2\2\u0100\u0101\5&\24\2\u0101\u0102\7\23"+
		"\2\2\u0102\u0103\5$\23\2\u0103\u0104\7\27\2\2\u0104\u0106\3\2\2\2\u0105"+
		"\u00f3\3\2\2\2\u0105\u00f4\3\2\2\2\u0105\u00f9\3\2\2\2\u0105\u00fe\3\2"+
		"\2\2\u0106%\3\2\2\2\u0107\u010d\7!\2\2\u0108\u010d\7\"\2\2\u0109\u010d"+
		"\7#\2\2\u010a\u010d\7$\2\2\u010b\u010d\5\n\6\2\u010c\u0107\3\2\2\2\u010c"+
		"\u0108\3\2\2\2\u010c\u0109\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010b\3\2"+
		"\2\2\u010d\'\3\2\2\2\u010e\u0150\7%\2\2\u010f\u0150\7&\2\2\u0110\u0150"+
		"\7)\2\2\u0111\u0150\7*\2\2\u0112\u0150\7+\2\2\u0113\u0150\5\n\6\2\u0114"+
		"\u0119\7\36\2\2\u0115\u0116\7\26\2\2\u0116\u0117\5$\23\2\u0117\u0118\7"+
		"\27\2\2\u0118\u011a\3\2\2\2\u0119\u0115\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b\u0124\7\'\2\2\u011c\u0121\5(\25\2\u011d\u011e\7\23"+
		"\2\2\u011e\u0120\5(\25\2\u011f\u011d\3\2\2\2\u0120\u0123\3\2\2\2\u0121"+
		"\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2"+
		"\2\2\u0124\u011c\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\3\2\2\2\u0126"+
		"\u0150\7(\2\2\u0127\u012c\7\37\2\2\u0128\u0129\7\26\2\2\u0129\u012a\5"+
		"$\23\2\u012a\u012b\7\27\2\2\u012b\u012d\3\2\2\2\u012c\u0128\3\2\2\2\u012c"+
		"\u012d\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0137\7\'\2\2\u012f\u0134\5("+
		"\25\2\u0130\u0131\7\23\2\2\u0131\u0133\5(\25\2\u0132\u0130\3\2\2\2\u0133"+
		"\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0138\3\2"+
		"\2\2\u0136\u0134\3\2\2\2\u0137\u012f\3\2\2\2\u0137\u0138\3\2\2\2\u0138"+
		"\u0139\3\2\2\2\u0139\u0150\7(\2\2\u013a\u0141\7 \2\2\u013b\u013c\7\26"+
		"\2\2\u013c\u013d\5&\24\2\u013d\u013e\7\23\2\2\u013e\u013f\5$\23\2\u013f"+
		"\u0140\7\27\2\2\u0140\u0142\3\2\2\2\u0141\u013b\3\2\2\2\u0141\u0142\3"+
		"\2\2\2\u0142\u0143\3\2\2\2\u0143\u014c\7\'\2\2\u0144\u0149\5*\26\2\u0145"+
		"\u0146\7\23\2\2\u0146\u0148\5*\26\2\u0147\u0145\3\2\2\2\u0148\u014b\3"+
		"\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014d\3\2\2\2\u014b"+
		"\u0149\3\2\2\2\u014c\u0144\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\3\2"+
		"\2\2\u014e\u0150\7(\2\2\u014f\u010e\3\2\2\2\u014f\u010f\3\2\2\2\u014f"+
		"\u0110\3\2\2\2\u014f\u0111\3\2\2\2\u014f\u0112\3\2\2\2\u014f\u0113\3\2"+
		"\2\2\u014f\u0114\3\2\2\2\u014f\u0127\3\2\2\2\u014f\u013a\3\2\2\2\u0150"+
		")\3\2\2\2\u0151\u0152\5(\25\2\u0152\u0153\7\17\2\2\u0153\u0154\5(\25\2"+
		"\u0154+\3\2\2\2\60\62\66;?DNU]`jmot|\u0083\u0086\u0088\u008e\u0091\u0094"+
		"\u009a\u00a0\u00a6\u00a9\u00ad\u00b6\u00b9\u00c3\u00cb\u00ce\u00e0\u00e5"+
		"\u00ec\u00f1\u0105\u010c\u0119\u0121\u0124\u012c\u0134\u0137\u0141\u0149"+
		"\u014c\u014f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}