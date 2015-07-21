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
		null, "'namespace'", "'::'", "'import'", "'.'", "'as'", "'enclosure'", 
		"'ports'", "'component'", "'flows'", "'properties'", "'connection'", "'->'", 
		"'enum'", "'extends'", "','", "'{'", "'}'", "'lattice'", "'assembly'", 
		"'for'", "'states'", "'='", "'['", "']'", "'transitions'", "'-['", "']->'", 
		"'in'", "'out'", "':'", "'Set'", "'Seq'", "'Map'", "'Boolean'", "'Integer'", 
		"'Real'", "'String'", "'true'", "'false'", "'('", "')'"
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__7) | (1L << T__10) | (1L << T__12) | (1L << T__18))) != 0)) {
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
			if (_la==T__5) {
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
		public Token elem;
		public Token alias;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4AwasParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4AwasParser.ID, i);
		}
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
				((ImportEnumDeclContext)_localctx).elem = match(ID);
				}
			}

			setState(89);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(87);
				match(T__4);
				setState(88);
				((ImportEnumDeclContext)_localctx).alias = match(ID);
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
			setState(91);
			match(T__5);
			setState(92);
			match(ID);
			setState(100);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(93);
				match(T__6);
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__27 || _la==T__28) {
					{
					{
					setState(94);
					port();
					}
					}
					setState(99);
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
			setState(106);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				componentDecl();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				connectionDecl();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				enumDecl();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(105);
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
			setState(108);
			match(T__7);
			setState(109);
			match(ID);
			setState(126);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(110);
				match(T__6);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__27 || _la==T__28) {
					{
					{
					setState(111);
					port();
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(124);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(117);
					match(T__8);
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==ID) {
						{
						{
						setState(118);
						dependency();
						}
						}
						setState(123);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
			}

			setState(135);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(128);
				match(T__9);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(129);
					property();
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(138);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(137);
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
			setState(140);
			match(T__10);
			setState(141);
			((ConnectionDeclContext)_localctx).fromComponent = match(ID);
			setState(144);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(142);
				match(T__3);
				setState(143);
				((ConnectionDeclContext)_localctx).fromPort = match(ID);
				}
			}

			setState(146);
			match(T__11);
			setState(147);
			((ConnectionDeclContext)_localctx).toComponent = match(ID);
			setState(150);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(148);
				match(T__3);
				setState(149);
				((ConnectionDeclContext)_localctx).toPort = match(ID);
				}
			}

			setState(159);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(152);
				match(T__9);
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(153);
					property();
					}
					}
					setState(158);
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
		public List<Token> elements = new ArrayList<Token>();
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
			setState(200);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(T__12);
				setState(162);
				((EnumDeclContext)_localctx).id = match(ID);
				setState(172);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(163);
					match(T__13);
					setState(164);
					((EnumDeclContext)_localctx).ID = match(ID);
					((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).ID);
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__14) {
						{
						{
						setState(165);
						match(T__14);
						setState(166);
						((EnumDeclContext)_localctx).ID = match(ID);
						((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).ID);
						}
						}
						setState(171);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(184);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(174);
					match(T__15);
					setState(175);
					((EnumDeclContext)_localctx).ID = match(ID);
					((EnumDeclContext)_localctx).elements.add(((EnumDeclContext)_localctx).ID);
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__14) {
						{
						{
						setState(176);
						match(T__14);
						setState(177);
						((EnumDeclContext)_localctx).ID = match(ID);
						((EnumDeclContext)_localctx).elements.add(((EnumDeclContext)_localctx).ID);
						}
						}
						setState(182);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(183);
					match(T__16);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				match(T__12);
				setState(187);
				match(T__17);
				setState(188);
				((EnumDeclContext)_localctx).id = match(ID);
				setState(198);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(189);
					match(T__13);
					setState(190);
					((EnumDeclContext)_localctx).ID = match(ID);
					((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).ID);
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__14) {
						{
						{
						setState(191);
						match(T__14);
						setState(192);
						((EnumDeclContext)_localctx).ID = match(ID);
						((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).ID);
						}
						}
						setState(197);
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
			setState(202);
			match(T__18);
			setState(203);
			match(ID);
			setState(204);
			match(T__19);
			setState(205);
			name();
			setState(213);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(206);
				match(T__6);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << ID))) != 0)) {
					{
					{
					setState(207);
					portAlias();
					}
					}
					setState(212);
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
			setState(215);
			match(T__20);
			setState(216);
			match(T__21);
			setState(217);
			match(T__22);
			setState(218);
			match(ID);
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(219);
				match(T__14);
				setState(220);
				match(ID);
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(226);
			match(T__23);
			setState(234);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(227);
				match(T__24);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(228);
					transition();
					}
					}
					setState(233);
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
			setState(236);
			((TransitionContext)_localctx).fromState = match(ID);
			setState(237);
			match(T__25);
			setState(238);
			match(T__26);
			setState(239);
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
			setState(241);
			((DependencyContext)_localctx).fromPort = match(ID);
			setState(242);
			match(T__11);
			setState(243);
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
			setState(245);
			((PortContext)_localctx).mod = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__27 || _la==T__28) ) {
				((PortContext)_localctx).mod = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(246);
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
			setState(257);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				((PortAliasContext)_localctx).mod = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__27 || _la==T__28) ) {
					((PortAliasContext)_localctx).mod = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(249);
				((PortAliasContext)_localctx).id = match(ID);
				setState(252);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(250);
					match(T__4);
					setState(251);
					((PortAliasContext)_localctx).alias = match(ID);
					}
				}

				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				((PortAliasContext)_localctx).id = match(ID);
				setState(255);
				match(T__4);
				setState(256);
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
			setState(269);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(ID);
				setState(260);
				match(T__29);
				setState(261);
				type();
				setState(264);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(262);
					match(T__21);
					setState(263);
					init();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				match(ID);
				setState(267);
				match(T__21);
				setState(268);
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
			setState(289);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case ID:
				_localctx = new BaseTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				basicType();
				}
				break;
			case T__30:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				match(T__30);
				setState(273);
				match(T__22);
				setState(274);
				type();
				setState(275);
				match(T__23);
				}
				break;
			case T__31:
				_localctx = new SeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(277);
				match(T__31);
				setState(278);
				match(T__22);
				setState(279);
				type();
				setState(280);
				match(T__23);
				}
				break;
			case T__32:
				_localctx = new MapTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(282);
				match(T__32);
				setState(283);
				match(T__22);
				setState(284);
				basicType();
				setState(285);
				match(T__14);
				setState(286);
				type();
				setState(287);
				match(T__23);
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
			setState(296);
			switch (_input.LA(1)) {
			case T__33:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				match(T__33);
				}
				break;
			case T__34:
				_localctx = new IntegerTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				match(T__34);
				}
				break;
			case T__35:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(293);
				match(T__35);
				}
				break;
			case T__36:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(294);
				match(T__36);
				}
				break;
			case ID:
				_localctx = new EnumTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(295);
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
		public TerminalNode ID() { return getToken(Antlr4AwasParser.ID, 0); }
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
			setState(367);
			switch (_input.LA(1)) {
			case T__37:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				match(T__37);
				}
				break;
			case T__38:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				match(T__38);
				}
				break;
			case INTEGER:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(300);
				match(INTEGER);
				}
				break;
			case REAL:
				_localctx = new RealContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(301);
				match(REAL);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(302);
				match(STRING);
				}
				break;
			case ID:
				_localctx = new EnumElementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(303);
				name();
				setState(306);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(304);
					match(T__3);
					setState(305);
					match(ID);
					}
				}

				}
				break;
			case T__30:
				_localctx = new SetContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(308);
				match(T__30);
				setState(313);
				_la = _input.LA(1);
				if (_la==T__22) {
					{
					setState(309);
					match(T__22);
					setState(310);
					type();
					setState(311);
					match(T__23);
					}
				}

				setState(315);
				match(T__39);
				setState(324);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__37) | (1L << T__38) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(316);
					init();
					setState(321);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__14) {
						{
						{
						setState(317);
						match(T__14);
						setState(318);
						init();
						}
						}
						setState(323);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(326);
				match(T__40);
				}
				break;
			case T__31:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(327);
				match(T__31);
				setState(332);
				_la = _input.LA(1);
				if (_la==T__22) {
					{
					setState(328);
					match(T__22);
					setState(329);
					type();
					setState(330);
					match(T__23);
					}
				}

				setState(334);
				match(T__39);
				setState(343);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__37) | (1L << T__38) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(335);
					init();
					setState(340);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__14) {
						{
						{
						setState(336);
						match(T__14);
						setState(337);
						init();
						}
						}
						setState(342);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(345);
				match(T__40);
				}
				break;
			case T__32:
				_localctx = new MapContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(346);
				match(T__32);
				setState(353);
				_la = _input.LA(1);
				if (_la==T__22) {
					{
					setState(347);
					match(T__22);
					setState(348);
					basicType();
					setState(349);
					match(T__14);
					setState(350);
					type();
					setState(351);
					match(T__23);
					}
				}

				setState(355);
				match(T__39);
				setState(364);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__37) | (1L << T__38) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(356);
					mapEntry();
					setState(361);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__14) {
						{
						{
						setState(357);
						match(T__14);
						setState(358);
						mapEntry();
						}
						}
						setState(363);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(366);
				match(T__40);
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
			setState(369);
			((MapEntryContext)_localctx).key = init();
			setState(370);
			match(T__11);
			setState(371);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63\u0178\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\3\7\3"+
		"\63\n\3\f\3\16\3\66\13\3\3\4\5\49\n\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4"+
		"\5\4B\n\4\3\4\6\4E\n\4\r\4\16\4F\3\5\3\5\3\5\3\6\3\6\3\6\7\6O\n\6\f\6"+
		"\16\6R\13\6\3\7\3\7\3\7\3\7\5\7X\n\7\3\7\3\7\5\7\\\n\7\3\b\3\b\3\b\3\b"+
		"\7\bb\n\b\f\b\16\be\13\b\5\bg\n\b\3\t\3\t\3\t\3\t\5\tm\n\t\3\n\3\n\3\n"+
		"\3\n\7\ns\n\n\f\n\16\nv\13\n\3\n\3\n\7\nz\n\n\f\n\16\n}\13\n\5\n\177\n"+
		"\n\5\n\u0081\n\n\3\n\3\n\7\n\u0085\n\n\f\n\16\n\u0088\13\n\5\n\u008a\n"+
		"\n\3\n\5\n\u008d\n\n\3\13\3\13\3\13\3\13\5\13\u0093\n\13\3\13\3\13\3\13"+
		"\3\13\5\13\u0099\n\13\3\13\3\13\7\13\u009d\n\13\f\13\16\13\u00a0\13\13"+
		"\5\13\u00a2\n\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00aa\n\f\f\f\16\f\u00ad"+
		"\13\f\5\f\u00af\n\f\3\f\3\f\3\f\3\f\7\f\u00b5\n\f\f\f\16\f\u00b8\13\f"+
		"\3\f\5\f\u00bb\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00c4\n\f\f\f\16\f"+
		"\u00c7\13\f\5\f\u00c9\n\f\5\f\u00cb\n\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00d3"+
		"\n\r\f\r\16\r\u00d6\13\r\5\r\u00d8\n\r\3\16\3\16\3\16\3\16\3\16\3\16\7"+
		"\16\u00e0\n\16\f\16\16\16\u00e3\13\16\3\16\3\16\3\16\7\16\u00e8\n\16\f"+
		"\16\16\16\u00eb\13\16\5\16\u00ed\n\16\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\5\22\u00ff\n\22\3\22"+
		"\3\22\3\22\5\22\u0104\n\22\3\23\3\23\3\23\3\23\3\23\5\23\u010b\n\23\3"+
		"\23\3\23\3\23\5\23\u0110\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0124\n\24\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u012b\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u0135\n\26\3\26\3\26\3\26\3\26\3\26\5\26\u013c\n\26\3\26\3"+
		"\26\3\26\3\26\7\26\u0142\n\26\f\26\16\26\u0145\13\26\5\26\u0147\n\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\5\26\u014f\n\26\3\26\3\26\3\26\3\26\7\26"+
		"\u0155\n\26\f\26\16\26\u0158\13\26\5\26\u015a\n\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u0164\n\26\3\26\3\26\3\26\3\26\7\26\u016a\n"+
		"\26\f\26\16\26\u016d\13\26\5\26\u016f\n\26\3\26\5\26\u0172\n\26\3\27\3"+
		"\27\3\27\3\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,\2\3\3\2\36\37\u01a2\2.\3\2\2\2\4\64\3\2\2\2\68\3\2\2\2\bH\3\2\2\2"+
		"\nK\3\2\2\2\fS\3\2\2\2\16]\3\2\2\2\20l\3\2\2\2\22n\3\2\2\2\24\u008e\3"+
		"\2\2\2\26\u00ca\3\2\2\2\30\u00cc\3\2\2\2\32\u00d9\3\2\2\2\34\u00ee\3\2"+
		"\2\2\36\u00f3\3\2\2\2 \u00f7\3\2\2\2\"\u0103\3\2\2\2$\u010f\3\2\2\2&\u0123"+
		"\3\2\2\2(\u012a\3\2\2\2*\u0171\3\2\2\2,\u0173\3\2\2\2./\5\4\3\2/\60\7"+
		"\2\2\3\60\3\3\2\2\2\61\63\5\6\4\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3"+
		"\2\2\2\64\65\3\2\2\2\65\5\3\2\2\2\66\64\3\2\2\2\679\5\b\5\28\67\3\2\2"+
		"\289\3\2\2\29=\3\2\2\2:<\5\f\7\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2"+
		"\2>A\3\2\2\2?=\3\2\2\2@B\5\16\b\2A@\3\2\2\2AB\3\2\2\2BD\3\2\2\2CE\5\20"+
		"\t\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\7\3\2\2\2HI\7\3\2\2IJ\5"+
		"\n\6\2J\t\3\2\2\2KP\7/\2\2LM\7\4\2\2MO\7/\2\2NL\3\2\2\2OR\3\2\2\2PN\3"+
		"\2\2\2PQ\3\2\2\2Q\13\3\2\2\2RP\3\2\2\2ST\7\5\2\2TW\5\n\6\2UV\7\6\2\2V"+
		"X\7/\2\2WU\3\2\2\2WX\3\2\2\2X[\3\2\2\2YZ\7\7\2\2Z\\\7/\2\2[Y\3\2\2\2["+
		"\\\3\2\2\2\\\r\3\2\2\2]^\7\b\2\2^f\7/\2\2_c\7\t\2\2`b\5 \21\2a`\3\2\2"+
		"\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2dg\3\2\2\2ec\3\2\2\2f_\3\2\2\2fg\3\2\2"+
		"\2g\17\3\2\2\2hm\5\22\n\2im\5\24\13\2jm\5\26\f\2km\5\30\r\2lh\3\2\2\2"+
		"li\3\2\2\2lj\3\2\2\2lk\3\2\2\2m\21\3\2\2\2no\7\n\2\2o\u0080\7/\2\2pt\7"+
		"\t\2\2qs\5 \21\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u~\3\2\2\2vt\3"+
		"\2\2\2w{\7\13\2\2xz\5\36\20\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2"+
		"|\177\3\2\2\2}{\3\2\2\2~w\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080"+
		"p\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0089\3\2\2\2\u0082\u0086\7\f\2\2"+
		"\u0083\u0085\5$\23\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u0082\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u008d\5\32"+
		"\16\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\23\3\2\2\2\u008e\u008f"+
		"\7\r\2\2\u008f\u0092\7/\2\2\u0090\u0091\7\6\2\2\u0091\u0093\7/\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\7\16"+
		"\2\2\u0095\u0098\7/\2\2\u0096\u0097\7\6\2\2\u0097\u0099\7/\2\2\u0098\u0096"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u00a1\3\2\2\2\u009a\u009e\7\f\2\2\u009b"+
		"\u009d\5$\23\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u009a\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\25\3\2\2\2\u00a3\u00a4\7\17\2"+
		"\2\u00a4\u00ae\7/\2\2\u00a5\u00a6\7\20\2\2\u00a6\u00ab\7/\2\2\u00a7\u00a8"+
		"\7\21\2\2\u00a8\u00aa\7/\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2"+
		"\2\2\u00ae\u00a5\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ba\3\2\2\2\u00b0"+
		"\u00b1\7\22\2\2\u00b1\u00b6\7/\2\2\u00b2\u00b3\7\21\2\2\u00b3\u00b5\7"+
		"/\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bb\7\23"+
		"\2\2\u00ba\u00b0\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00cb\3\2\2\2\u00bc"+
		"\u00bd\7\17\2\2\u00bd\u00be\7\24\2\2\u00be\u00c8\7/\2\2\u00bf\u00c0\7"+
		"\20\2\2\u00c0\u00c5\7/\2\2\u00c1\u00c2\7\21\2\2\u00c2\u00c4\7/\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2"+
		"\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00bf\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00a3\3\2\2\2\u00ca\u00bc\3\2"+
		"\2\2\u00cb\27\3\2\2\2\u00cc\u00cd\7\25\2\2\u00cd\u00ce\7/\2\2\u00ce\u00cf"+
		"\7\26\2\2\u00cf\u00d7\5\n\6\2\u00d0\u00d4\7\t\2\2\u00d1\u00d3\5\"\22\2"+
		"\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5"+
		"\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d0\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\31\3\2\2\2\u00d9\u00da\7\27\2\2\u00da\u00db\7\30"+
		"\2\2\u00db\u00dc\7\31\2\2\u00dc\u00e1\7/\2\2\u00dd\u00de\7\21\2\2\u00de"+
		"\u00e0\7/\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2"+
		"\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4"+
		"\u00ec\7\32\2\2\u00e5\u00e9\7\33\2\2\u00e6\u00e8\5\34\17\2\u00e7\u00e6"+
		"\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00e5\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed\33\3\2\2\2\u00ee\u00ef\7/\2\2\u00ef\u00f0\7\34\2\2\u00f0\u00f1"+
		"\7\35\2\2\u00f1\u00f2\7/\2\2\u00f2\35\3\2\2\2\u00f3\u00f4\7/\2\2\u00f4"+
		"\u00f5\7\16\2\2\u00f5\u00f6\7/\2\2\u00f6\37\3\2\2\2\u00f7\u00f8\t\2\2"+
		"\2\u00f8\u00f9\7/\2\2\u00f9!\3\2\2\2\u00fa\u00fb\t\2\2\2\u00fb\u00fe\7"+
		"/\2\2\u00fc\u00fd\7\7\2\2\u00fd\u00ff\7/\2\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0104\3\2\2\2\u0100\u0101\7/\2\2\u0101\u0102\7\7"+
		"\2\2\u0102\u0104\7/\2\2\u0103\u00fa\3\2\2\2\u0103\u0100\3\2\2\2\u0104"+
		"#\3\2\2\2\u0105\u0106\7/\2\2\u0106\u0107\7 \2\2\u0107\u010a\5&\24\2\u0108"+
		"\u0109\7\30\2\2\u0109\u010b\5*\26\2\u010a\u0108\3\2\2\2\u010a\u010b\3"+
		"\2\2\2\u010b\u0110\3\2\2\2\u010c\u010d\7/\2\2\u010d\u010e\7\30\2\2\u010e"+
		"\u0110\5*\26\2\u010f\u0105\3\2\2\2\u010f\u010c\3\2\2\2\u0110%\3\2\2\2"+
		"\u0111\u0124\5(\25\2\u0112\u0113\7!\2\2\u0113\u0114\7\31\2\2\u0114\u0115"+
		"\5&\24\2\u0115\u0116\7\32\2\2\u0116\u0124\3\2\2\2\u0117\u0118\7\"\2\2"+
		"\u0118\u0119\7\31\2\2\u0119\u011a\5&\24\2\u011a\u011b\7\32\2\2\u011b\u0124"+
		"\3\2\2\2\u011c\u011d\7#\2\2\u011d\u011e\7\31\2\2\u011e\u011f\5(\25\2\u011f"+
		"\u0120\7\21\2\2\u0120\u0121\5&\24\2\u0121\u0122\7\32\2\2\u0122\u0124\3"+
		"\2\2\2\u0123\u0111\3\2\2\2\u0123\u0112\3\2\2\2\u0123\u0117\3\2\2\2\u0123"+
		"\u011c\3\2\2\2\u0124\'\3\2\2\2\u0125\u012b\7$\2\2\u0126\u012b\7%\2\2\u0127"+
		"\u012b\7&\2\2\u0128\u012b\7\'\2\2\u0129\u012b\5\n\6\2\u012a\u0125\3\2"+
		"\2\2\u012a\u0126\3\2\2\2\u012a\u0127\3\2\2\2\u012a\u0128\3\2\2\2\u012a"+
		"\u0129\3\2\2\2\u012b)\3\2\2\2\u012c\u0172\7(\2\2\u012d\u0172\7)\2\2\u012e"+
		"\u0172\7,\2\2\u012f\u0172\7-\2\2\u0130\u0172\7.\2\2\u0131\u0134\5\n\6"+
		"\2\u0132\u0133\7\6\2\2\u0133\u0135\7/\2\2\u0134\u0132\3\2\2\2\u0134\u0135"+
		"\3\2\2\2\u0135\u0172\3\2\2\2\u0136\u013b\7!\2\2\u0137\u0138\7\31\2\2\u0138"+
		"\u0139\5&\24\2\u0139\u013a\7\32\2\2\u013a\u013c\3\2\2\2\u013b\u0137\3"+
		"\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u0146\7*\2\2\u013e"+
		"\u0143\5*\26\2\u013f\u0140\7\21\2\2\u0140\u0142\5*\26\2\u0141\u013f\3"+
		"\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u013e\3\2\2\2\u0146\u0147\3\2"+
		"\2\2\u0147\u0148\3\2\2\2\u0148\u0172\7+\2\2\u0149\u014e\7\"\2\2\u014a"+
		"\u014b\7\31\2\2\u014b\u014c\5&\24\2\u014c\u014d\7\32\2\2\u014d\u014f\3"+
		"\2\2\2\u014e\u014a\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u0159\7*\2\2\u0151\u0156\5*\26\2\u0152\u0153\7\21\2\2\u0153\u0155\5*"+
		"\26\2\u0154\u0152\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156"+
		"\u0157\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u0151\3\2"+
		"\2\2\u0159\u015a\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u0172\7+\2\2\u015c"+
		"\u0163\7#\2\2\u015d\u015e\7\31\2\2\u015e\u015f\5(\25\2\u015f\u0160\7\21"+
		"\2\2\u0160\u0161\5&\24\2\u0161\u0162\7\32\2\2\u0162\u0164\3\2\2\2\u0163"+
		"\u015d\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u016e\7*"+
		"\2\2\u0166\u016b\5,\27\2\u0167\u0168\7\21\2\2\u0168\u016a\5,\27\2\u0169"+
		"\u0167\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2"+
		"\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u0166\3\2\2\2\u016e"+
		"\u016f\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0172\7+\2\2\u0171\u012c\3\2"+
		"\2\2\u0171\u012d\3\2\2\2\u0171\u012e\3\2\2\2\u0171\u012f\3\2\2\2\u0171"+
		"\u0130\3\2\2\2\u0171\u0131\3\2\2\2\u0171\u0136\3\2\2\2\u0171\u0149\3\2"+
		"\2\2\u0171\u015c\3\2\2\2\u0172+\3\2\2\2\u0173\u0174\5*\26\2\u0174\u0175"+
		"\7\16\2\2\u0175\u0176\5*\26\2\u0176-\3\2\2\2\65\648=AFPW[cflt{~\u0080"+
		"\u0086\u0089\u008c\u0092\u0098\u009e\u00a1\u00ab\u00ae\u00b6\u00ba\u00c5"+
		"\u00c8\u00ca\u00d4\u00d7\u00e1\u00e9\u00ec\u00fe\u0103\u010a\u010f\u0123"+
		"\u012a\u0134\u013b\u0143\u0146\u014e\u0156\u0159\u0163\u016b\u016e\u0171";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}