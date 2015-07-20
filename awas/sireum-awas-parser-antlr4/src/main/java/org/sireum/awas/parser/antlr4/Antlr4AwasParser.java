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
		T__38=39, INTEGER=40, REAL=41, STRING=42, ID=43, WS=44, COMMENT=45, LINE_COMMENT=46, 
		ERROR_CHAR=47;
	public static final int
		RULE_modelFile = 0, RULE_model = 1, RULE_unitDecl = 2, RULE_namespaceDecl = 3, 
		RULE_name = 4, RULE_importEnumDecl = 5, RULE_enclosureDecl = 6, RULE_modelElement = 7, 
		RULE_componentDecl = 8, RULE_connectionDecl = 9, RULE_enumDecl = 10, RULE_enclosureAssembly = 11, 
		RULE_states = 12, RULE_transition = 13, RULE_dependency = 14, RULE_port = 15, 
		RULE_portAlias = 16, RULE_property = 17, RULE_type = 18, RULE_basicType = 19, 
		RULE_init = 20, RULE_mapEntry = 21;
	public static final String[] ruleNames = {
		"modelFile", "model", "unitDecl", "namespaceDecl", "name", "importEnumDecl", 
		"enclosureDecl", "modelElement", "componentDecl", "connectionDecl", "enumDecl", 
		"enclosureAssembly", "states", "transition", "dependency", "port", "portAlias", 
		"property", "type", "basicType", "init", "mapEntry"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'namespace'", "'::'", "'import'", "'as'", "'enclosure'", "'ports'", 
		"'component'", "'dependencies'", "'properties'", "'connection'", "'.'", 
		"'->'", "'enum'", "'lattice'", "'extends'", "','", "'assembly'", "'for'", 
		"'states'", "'='", "'['", "']'", "'transitions'", "'-['", "']->'", "'in'", 
		"'out'", "':'", "'Set'", "'Seq'", "'Map'", "'Boolean'", "'Integer'", "'Real'", 
		"'String'", "'true'", "'false'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "INTEGER", "REAL", "STRING", "ID", "WS", "COMMENT", 
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
			setState(44);
			model();
			setState(45);
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
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__4) | (1L << T__6) | (1L << T__9) | (1L << T__12) | (1L << T__16))) != 0)) {
				{
				{
				setState(47);
				unitDecl();
				}
				}
				setState(52);
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
			setState(54);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(53);
				namespaceDecl();
				}
			}

			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(56);
				importEnumDecl();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(62);
				enclosureDecl();
				}
			}

			setState(66); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(65);
					modelElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(68); 
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
			setState(70);
			match(T__0);
			setState(71);
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
			setState(73);
			match(ID);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(74);
				match(T__1);
				setState(75);
				match(ID);
				}
				}
				setState(80);
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
			setState(81);
			match(T__2);
			setState(82);
			name();
			setState(85);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(83);
				match(T__3);
				setState(84);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__4);
			setState(88);
			match(ID);
			setState(96);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(89);
				match(T__5);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__25 || _la==T__26) {
					{
					{
					setState(90);
					port();
					}
					}
					setState(95);
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
		public EnclosureAssemblyContext enclosureAssembly() {
			return getRuleContext(EnclosureAssemblyContext.class,0);
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
			setState(102);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				componentDecl();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				connectionDecl();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				enumDecl();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				enclosureAssembly();
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
			setState(104);
			match(T__6);
			setState(105);
			match(ID);
			setState(122);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(106);
				match(T__5);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__25 || _la==T__26) {
					{
					{
					setState(107);
					port();
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(120);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(113);
					match(T__7);
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==ID) {
						{
						{
						setState(114);
						dependency();
						}
						}
						setState(119);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
			}

			setState(131);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(124);
				match(T__8);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(125);
					property();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(134);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(133);
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
			setState(136);
			match(T__9);
			setState(137);
			((ConnectionDeclContext)_localctx).fromComponent = match(ID);
			setState(140);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(138);
				match(T__10);
				setState(139);
				((ConnectionDeclContext)_localctx).fromPort = match(ID);
				}
			}

			setState(142);
			match(T__11);
			setState(143);
			((ConnectionDeclContext)_localctx).toComponent = match(ID);
			setState(146);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(144);
				match(T__10);
				setState(145);
				((ConnectionDeclContext)_localctx).toPort = match(ID);
				}
			}

			setState(155);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(148);
				match(T__8);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(149);
					property();
					}
					}
					setState(154);
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
			setState(157);
			match(T__12);
			setState(159);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(158);
				match(T__13);
				}
			}

			setState(161);
			((EnumDeclContext)_localctx).id = match(ID);
			setState(171);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(162);
				match(T__14);
				setState(163);
				((EnumDeclContext)_localctx).ID = match(ID);
				((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).ID);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(164);
					match(T__15);
					setState(165);
					((EnumDeclContext)_localctx).ID = match(ID);
					((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).ID);
					}
					}
					setState(170);
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

	public static class EnclosureAssemblyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Antlr4AwasParser.ID, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<PortAliasContext> portAlias() {
			return getRuleContexts(PortAliasContext.class);
		}
		public PortAliasContext portAlias(int i) {
			return getRuleContext(PortAliasContext.class,i);
		}
		public EnclosureAssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enclosureAssembly; }
	}

	public final EnclosureAssemblyContext enclosureAssembly() throws RecognitionException {
		EnclosureAssemblyContext _localctx = new EnclosureAssemblyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_enclosureAssembly);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__16);
			setState(174);
			match(ID);
			setState(175);
			match(T__17);
			setState(176);
			name();
			setState(184);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(177);
				match(T__5);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << ID))) != 0)) {
					{
					{
					setState(178);
					portAlias();
					}
					}
					setState(183);
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
		enterRule(_localctx, 24, RULE_states);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(T__18);
			setState(187);
			match(T__19);
			setState(188);
			match(T__20);
			setState(189);
			match(ID);
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(190);
				match(T__15);
				setState(191);
				match(ID);
				}
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(197);
			match(T__21);
			setState(205);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(198);
				match(T__22);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(199);
					transition();
					}
					}
					setState(204);
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
		enterRule(_localctx, 26, RULE_transition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			((TransitionContext)_localctx).fromState = match(ID);
			setState(208);
			match(T__23);
			setState(209);
			match(T__24);
			setState(210);
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
		enterRule(_localctx, 28, RULE_dependency);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			((DependencyContext)_localctx).fromPort = match(ID);
			setState(213);
			match(T__11);
			setState(214);
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
		enterRule(_localctx, 30, RULE_port);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			((PortContext)_localctx).mod = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__25 || _la==T__26) ) {
				((PortContext)_localctx).mod = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(217);
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
		enterRule(_localctx, 32, RULE_portAlias);
		int _la;
		try {
			setState(228);
			switch (_input.LA(1)) {
			case T__25:
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				((PortAliasContext)_localctx).mod = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__25 || _la==T__26) ) {
					((PortAliasContext)_localctx).mod = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(220);
				((PortAliasContext)_localctx).id = match(ID);
				setState(223);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(221);
					match(T__3);
					setState(222);
					((PortAliasContext)_localctx).alias = match(ID);
					}
				}

				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				((PortAliasContext)_localctx).id = match(ID);
				setState(226);
				match(T__3);
				setState(227);
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
		enterRule(_localctx, 34, RULE_property);
		int _la;
		try {
			setState(240);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(ID);
				setState(231);
				match(T__27);
				setState(232);
				type();
				setState(235);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(233);
					match(T__19);
					setState(234);
					init();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				match(ID);
				setState(238);
				match(T__19);
				setState(239);
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
		enterRule(_localctx, 36, RULE_type);
		try {
			setState(260);
			switch (_input.LA(1)) {
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case ID:
				_localctx = new BaseTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				basicType();
				}
				break;
			case T__28:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				match(T__28);
				setState(244);
				match(T__20);
				setState(245);
				type();
				setState(246);
				match(T__21);
				}
				break;
			case T__29:
				_localctx = new SeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				match(T__29);
				setState(249);
				match(T__20);
				setState(250);
				type();
				setState(251);
				match(T__21);
				}
				break;
			case T__30:
				_localctx = new MapTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(253);
				match(T__30);
				setState(254);
				match(T__20);
				setState(255);
				basicType();
				setState(256);
				match(T__15);
				setState(257);
				type();
				setState(258);
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
		enterRule(_localctx, 38, RULE_basicType);
		try {
			setState(267);
			switch (_input.LA(1)) {
			case T__31:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				match(T__31);
				}
				break;
			case T__32:
				_localctx = new IntegerTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				match(T__32);
				}
				break;
			case T__33:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(264);
				match(T__33);
				}
				break;
			case T__34:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(265);
				match(T__34);
				}
				break;
			case ID:
				_localctx = new EnumTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(266);
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
		enterRule(_localctx, 40, RULE_init);
		int _la;
		try {
			setState(334);
			switch (_input.LA(1)) {
			case T__35:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				match(T__35);
				}
				break;
			case T__36:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				match(T__36);
				}
				break;
			case INTEGER:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(271);
				match(INTEGER);
				}
				break;
			case REAL:
				_localctx = new RealContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(272);
				match(REAL);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(273);
				match(STRING);
				}
				break;
			case ID:
				_localctx = new EnumElementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(274);
				name();
				}
				break;
			case T__28:
				_localctx = new SetContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(275);
				match(T__28);
				setState(280);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(276);
					match(T__20);
					setState(277);
					type();
					setState(278);
					match(T__21);
					}
				}

				setState(282);
				match(T__37);
				setState(291);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__35) | (1L << T__36) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(283);
					init();
					setState(288);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(284);
						match(T__15);
						setState(285);
						init();
						}
						}
						setState(290);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(293);
				match(T__38);
				}
				break;
			case T__29:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(294);
				match(T__29);
				setState(299);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(295);
					match(T__20);
					setState(296);
					type();
					setState(297);
					match(T__21);
					}
				}

				setState(301);
				match(T__37);
				setState(310);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__35) | (1L << T__36) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(302);
					init();
					setState(307);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(303);
						match(T__15);
						setState(304);
						init();
						}
						}
						setState(309);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(312);
				match(T__38);
				}
				break;
			case T__30:
				_localctx = new MapContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(313);
				match(T__30);
				setState(320);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(314);
					match(T__20);
					setState(315);
					basicType();
					setState(316);
					match(T__15);
					setState(317);
					type();
					setState(318);
					match(T__21);
					}
				}

				setState(322);
				match(T__37);
				setState(331);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__35) | (1L << T__36) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(323);
					mapEntry();
					setState(328);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__15) {
						{
						{
						setState(324);
						match(T__15);
						setState(325);
						mapEntry();
						}
						}
						setState(330);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(333);
				match(T__38);
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
		enterRule(_localctx, 42, RULE_mapEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			((MapEntryContext)_localctx).key = init();
			setState(337);
			match(T__11);
			setState(338);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\61\u0157\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\3\7\3"+
		"\63\n\3\f\3\16\3\66\13\3\3\4\5\49\n\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4"+
		"\5\4B\n\4\3\4\6\4E\n\4\r\4\16\4F\3\5\3\5\3\5\3\6\3\6\3\6\7\6O\n\6\f\6"+
		"\16\6R\13\6\3\7\3\7\3\7\3\7\5\7X\n\7\3\b\3\b\3\b\3\b\7\b^\n\b\f\b\16\b"+
		"a\13\b\5\bc\n\b\3\t\3\t\3\t\3\t\5\ti\n\t\3\n\3\n\3\n\3\n\7\no\n\n\f\n"+
		"\16\nr\13\n\3\n\3\n\7\nv\n\n\f\n\16\ny\13\n\5\n{\n\n\5\n}\n\n\3\n\3\n"+
		"\7\n\u0081\n\n\f\n\16\n\u0084\13\n\5\n\u0086\n\n\3\n\5\n\u0089\n\n\3\13"+
		"\3\13\3\13\3\13\5\13\u008f\n\13\3\13\3\13\3\13\3\13\5\13\u0095\n\13\3"+
		"\13\3\13\7\13\u0099\n\13\f\13\16\13\u009c\13\13\5\13\u009e\n\13\3\f\3"+
		"\f\5\f\u00a2\n\f\3\f\3\f\3\f\3\f\3\f\7\f\u00a9\n\f\f\f\16\f\u00ac\13\f"+
		"\5\f\u00ae\n\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00b6\n\r\f\r\16\r\u00b9\13"+
		"\r\5\r\u00bb\n\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00c3\n\16\f\16\16"+
		"\16\u00c6\13\16\3\16\3\16\3\16\7\16\u00cb\n\16\f\16\16\16\u00ce\13\16"+
		"\5\16\u00d0\n\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\5\22\u00e2\n\22\3\22\3\22\3\22\5\22\u00e7\n"+
		"\22\3\23\3\23\3\23\3\23\3\23\5\23\u00ee\n\23\3\23\3\23\3\23\5\23\u00f3"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u0107\n\24\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u010e\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u011b\n\26\3\26\3\26\3\26\3\26\7\26\u0121\n\26\f\26\16\26\u0124\13\26"+
		"\5\26\u0126\n\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u012e\n\26\3\26\3"+
		"\26\3\26\3\26\7\26\u0134\n\26\f\26\16\26\u0137\13\26\5\26\u0139\n\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0143\n\26\3\26\3\26\3\26"+
		"\3\26\7\26\u0149\n\26\f\26\16\26\u014c\13\26\5\26\u014e\n\26\3\26\5\26"+
		"\u0151\n\26\3\27\3\27\3\27\3\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,\2\3\3\2\34\35\u017b\2.\3\2\2\2\4\64\3\2\2\2\68\3"+
		"\2\2\2\bH\3\2\2\2\nK\3\2\2\2\fS\3\2\2\2\16Y\3\2\2\2\20h\3\2\2\2\22j\3"+
		"\2\2\2\24\u008a\3\2\2\2\26\u009f\3\2\2\2\30\u00af\3\2\2\2\32\u00bc\3\2"+
		"\2\2\34\u00d1\3\2\2\2\36\u00d6\3\2\2\2 \u00da\3\2\2\2\"\u00e6\3\2\2\2"+
		"$\u00f2\3\2\2\2&\u0106\3\2\2\2(\u010d\3\2\2\2*\u0150\3\2\2\2,\u0152\3"+
		"\2\2\2./\5\4\3\2/\60\7\2\2\3\60\3\3\2\2\2\61\63\5\6\4\2\62\61\3\2\2\2"+
		"\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\5\3\2\2\2\66\64\3\2\2\2"+
		"\679\5\b\5\28\67\3\2\2\289\3\2\2\29=\3\2\2\2:<\5\f\7\2;:\3\2\2\2<?\3\2"+
		"\2\2=;\3\2\2\2=>\3\2\2\2>A\3\2\2\2?=\3\2\2\2@B\5\16\b\2A@\3\2\2\2AB\3"+
		"\2\2\2BD\3\2\2\2CE\5\20\t\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\7"+
		"\3\2\2\2HI\7\3\2\2IJ\5\n\6\2J\t\3\2\2\2KP\7-\2\2LM\7\4\2\2MO\7-\2\2NL"+
		"\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\13\3\2\2\2RP\3\2\2\2ST\7\5\2\2"+
		"TW\5\n\6\2UV\7\6\2\2VX\7-\2\2WU\3\2\2\2WX\3\2\2\2X\r\3\2\2\2YZ\7\7\2\2"+
		"Zb\7-\2\2[_\7\b\2\2\\^\5 \21\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2"+
		"\2`c\3\2\2\2a_\3\2\2\2b[\3\2\2\2bc\3\2\2\2c\17\3\2\2\2di\5\22\n\2ei\5"+
		"\24\13\2fi\5\26\f\2gi\5\30\r\2hd\3\2\2\2he\3\2\2\2hf\3\2\2\2hg\3\2\2\2"+
		"i\21\3\2\2\2jk\7\t\2\2k|\7-\2\2lp\7\b\2\2mo\5 \21\2nm\3\2\2\2or\3\2\2"+
		"\2pn\3\2\2\2pq\3\2\2\2qz\3\2\2\2rp\3\2\2\2sw\7\n\2\2tv\5\36\20\2ut\3\2"+
		"\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x{\3\2\2\2yw\3\2\2\2zs\3\2\2\2z{\3\2"+
		"\2\2{}\3\2\2\2|l\3\2\2\2|}\3\2\2\2}\u0085\3\2\2\2~\u0082\7\13\2\2\177"+
		"\u0081\5$\23\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2"+
		"\2\u0082\u0083\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0085~"+
		"\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0089\5\32\16\2"+
		"\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\23\3\2\2\2\u008a\u008b"+
		"\7\f\2\2\u008b\u008e\7-\2\2\u008c\u008d\7\r\2\2\u008d\u008f\7-\2\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\7\16"+
		"\2\2\u0091\u0094\7-\2\2\u0092\u0093\7\r\2\2\u0093\u0095\7-\2\2\u0094\u0092"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u009d\3\2\2\2\u0096\u009a\7\13\2\2"+
		"\u0097\u0099\5$\23\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009d"+
		"\u0096\3\2\2\2\u009d\u009e\3\2\2\2\u009e\25\3\2\2\2\u009f\u00a1\7\17\2"+
		"\2\u00a0\u00a2\7\20\2\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00ad\7-\2\2\u00a4\u00a5\7\21\2\2\u00a5\u00aa\7-"+
		"\2\2\u00a6\u00a7\7\22\2\2\u00a7\u00a9\7-\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ae\3\2"+
		"\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00a4\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\27\3\2\2\2\u00af\u00b0\7\23\2\2\u00b0\u00b1\7-\2\2\u00b1\u00b2\7\24\2"+
		"\2\u00b2\u00ba\5\n\6\2\u00b3\u00b7\7\b\2\2\u00b4\u00b6\5\"\22\2\u00b5"+
		"\u00b4\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2"+
		"\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00b3\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\31\3\2\2\2\u00bc\u00bd\7\25\2\2\u00bd\u00be\7\26"+
		"\2\2\u00be\u00bf\7\27\2\2\u00bf\u00c4\7-\2\2\u00c0\u00c1\7\22\2\2\u00c1"+
		"\u00c3\7-\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2"+
		"\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7"+
		"\u00cf\7\30\2\2\u00c8\u00cc\7\31\2\2\u00c9\u00cb\5\34\17\2\u00ca\u00c9"+
		"\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00c8\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\33\3\2\2\2\u00d1\u00d2\7-\2\2\u00d2\u00d3\7\32\2\2\u00d3\u00d4"+
		"\7\33\2\2\u00d4\u00d5\7-\2\2\u00d5\35\3\2\2\2\u00d6\u00d7\7-\2\2\u00d7"+
		"\u00d8\7\16\2\2\u00d8\u00d9\7-\2\2\u00d9\37\3\2\2\2\u00da\u00db\t\2\2"+
		"\2\u00db\u00dc\7-\2\2\u00dc!\3\2\2\2\u00dd\u00de\t\2\2\2\u00de\u00e1\7"+
		"-\2\2\u00df\u00e0\7\6\2\2\u00e0\u00e2\7-\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e7\3\2\2\2\u00e3\u00e4\7-\2\2\u00e4\u00e5\7\6"+
		"\2\2\u00e5\u00e7\7-\2\2\u00e6\u00dd\3\2\2\2\u00e6\u00e3\3\2\2\2\u00e7"+
		"#\3\2\2\2\u00e8\u00e9\7-\2\2\u00e9\u00ea\7\36\2\2\u00ea\u00ed\5&\24\2"+
		"\u00eb\u00ec\7\26\2\2\u00ec\u00ee\5*\26\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee"+
		"\3\2\2\2\u00ee\u00f3\3\2\2\2\u00ef\u00f0\7-\2\2\u00f0\u00f1\7\26\2\2\u00f1"+
		"\u00f3\5*\26\2\u00f2\u00e8\3\2\2\2\u00f2\u00ef\3\2\2\2\u00f3%\3\2\2\2"+
		"\u00f4\u0107\5(\25\2\u00f5\u00f6\7\37\2\2\u00f6\u00f7\7\27\2\2\u00f7\u00f8"+
		"\5&\24\2\u00f8\u00f9\7\30\2\2\u00f9\u0107\3\2\2\2\u00fa\u00fb\7 \2\2\u00fb"+
		"\u00fc\7\27\2\2\u00fc\u00fd\5&\24\2\u00fd\u00fe\7\30\2\2\u00fe\u0107\3"+
		"\2\2\2\u00ff\u0100\7!\2\2\u0100\u0101\7\27\2\2\u0101\u0102\5(\25\2\u0102"+
		"\u0103\7\22\2\2\u0103\u0104\5&\24\2\u0104\u0105\7\30\2\2\u0105\u0107\3"+
		"\2\2\2\u0106\u00f4\3\2\2\2\u0106\u00f5\3\2\2\2\u0106\u00fa\3\2\2\2\u0106"+
		"\u00ff\3\2\2\2\u0107\'\3\2\2\2\u0108\u010e\7\"\2\2\u0109\u010e\7#\2\2"+
		"\u010a\u010e\7$\2\2\u010b\u010e\7%\2\2\u010c\u010e\5\n\6\2\u010d\u0108"+
		"\3\2\2\2\u010d\u0109\3\2\2\2\u010d\u010a\3\2\2\2\u010d\u010b\3\2\2\2\u010d"+
		"\u010c\3\2\2\2\u010e)\3\2\2\2\u010f\u0151\7&\2\2\u0110\u0151\7\'\2\2\u0111"+
		"\u0151\7*\2\2\u0112\u0151\7+\2\2\u0113\u0151\7,\2\2\u0114\u0151\5\n\6"+
		"\2\u0115\u011a\7\37\2\2\u0116\u0117\7\27\2\2\u0117\u0118\5&\24\2\u0118"+
		"\u0119\7\30\2\2\u0119\u011b\3\2\2\2\u011a\u0116\3\2\2\2\u011a\u011b\3"+
		"\2\2\2\u011b\u011c\3\2\2\2\u011c\u0125\7(\2\2\u011d\u0122\5*\26\2\u011e"+
		"\u011f\7\22\2\2\u011f\u0121\5*\26\2\u0120\u011e\3\2\2\2\u0121\u0124\3"+
		"\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0126\3\2\2\2\u0124"+
		"\u0122\3\2\2\2\u0125\u011d\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\3\2"+
		"\2\2\u0127\u0151\7)\2\2\u0128\u012d\7 \2\2\u0129\u012a\7\27\2\2\u012a"+
		"\u012b\5&\24\2\u012b\u012c\7\30\2\2\u012c\u012e\3\2\2\2\u012d\u0129\3"+
		"\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0138\7(\2\2\u0130"+
		"\u0135\5*\26\2\u0131\u0132\7\22\2\2\u0132\u0134\5*\26\2\u0133\u0131\3"+
		"\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		"\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0130\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\u013a\3\2\2\2\u013a\u0151\7)\2\2\u013b\u0142\7!\2\2\u013c\u013d"+
		"\7\27\2\2\u013d\u013e\5(\25\2\u013e\u013f\7\22\2\2\u013f\u0140\5&\24\2"+
		"\u0140\u0141\7\30\2\2\u0141\u0143\3\2\2\2\u0142\u013c\3\2\2\2\u0142\u0143"+
		"\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u014d\7(\2\2\u0145\u014a\5,\27\2\u0146"+
		"\u0147\7\22\2\2\u0147\u0149\5,\27\2\u0148\u0146\3\2\2\2\u0149\u014c\3"+
		"\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014e\3\2\2\2\u014c"+
		"\u014a\3\2\2\2\u014d\u0145\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\3\2"+
		"\2\2\u014f\u0151\7)\2\2\u0150\u010f\3\2\2\2\u0150\u0110\3\2\2\2\u0150"+
		"\u0111\3\2\2\2\u0150\u0112\3\2\2\2\u0150\u0113\3\2\2\2\u0150\u0114\3\2"+
		"\2\2\u0150\u0115\3\2\2\2\u0150\u0128\3\2\2\2\u0150\u013b\3\2\2\2\u0151"+
		"+\3\2\2\2\u0152\u0153\5*\26\2\u0153\u0154\7\16\2\2\u0154\u0155\5*\26\2"+
		"\u0155-\3\2\2\2/\648=AFPW_bhpwz|\u0082\u0085\u0088\u008e\u0094\u009a\u009d"+
		"\u00a1\u00aa\u00ad\u00b7\u00ba\u00c4\u00cc\u00cf\u00e1\u00e6\u00ed\u00f2"+
		"\u0106\u010d\u011a\u0122\u0125\u012d\u0135\u0138\u0142\u014a\u014d\u0150";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}