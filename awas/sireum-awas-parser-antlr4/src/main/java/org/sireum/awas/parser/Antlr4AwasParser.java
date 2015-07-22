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
		T__38=39, T__39=40, INTEGER=41, REAL=42, STRING=43, ID=44, WS=45, COMMENT=46, 
		LINE_COMMENT=47, ERROR_CHAR=48;
	public static final int
		RULE_modelFile = 0, RULE_model = 1, RULE_unitDecl = 2, RULE_namespaceDecl = 3, 
		RULE_name = 4, RULE_importDecl = 5, RULE_typeDecl = 6, RULE_componentDecl = 7, 
		RULE_connectionDecl = 8, RULE_enumDecl = 9, RULE_latticeDecl = 10, RULE_recordDecl = 11, 
		RULE_field = 12, RULE_port = 13, RULE_property = 14, RULE_type = 15, RULE_basicType = 16, 
		RULE_init = 17, RULE_mapEntry = 18;
	public static final String[] ruleNames = {
		"modelFile", "model", "unitDecl", "namespaceDecl", "name", "importDecl", 
		"typeDecl", "componentDecl", "connectionDecl", "enumDecl", "latticeDecl", 
		"recordDecl", "field", "port", "property", "type", "basicType", "init", 
		"mapEntry"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'types'", "'components'", "'connections'", "'namespace'", "'::'", 
		"'import'", "'.'", "'as'", "'component'", "'ports'", "'properties'", "'connection'", 
		"':'", "'->'", "'enum'", "'extends'", "','", "'{'", "'}'", "'lattice'", 
		"'record'", "'in'", "'out'", "'='", "'Option'", "'['", "']'", "'Set'", 
		"'Seq'", "'Map'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'true'", 
		"'false'", "'('", "')'", "'None'", "'Some'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "INTEGER", "REAL", "STRING", "ID", "WS", 
		"COMMENT", "LINE_COMMENT", "ERROR_CHAR"
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
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(41);
				unitDecl();
				}
				}
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__5))) != 0) );
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
		public List<ImportDeclContext> importDecl() {
			return getRuleContexts(ImportDeclContext.class);
		}
		public ImportDeclContext importDecl(int i) {
			return getRuleContext(ImportDeclContext.class,i);
		}
		public List<ComponentDeclContext> componentDecl() {
			return getRuleContexts(ComponentDeclContext.class);
		}
		public ComponentDeclContext componentDecl(int i) {
			return getRuleContext(ComponentDeclContext.class,i);
		}
		public List<TypeDeclContext> typeDecl() {
			return getRuleContexts(TypeDeclContext.class);
		}
		public TypeDeclContext typeDecl(int i) {
			return getRuleContext(TypeDeclContext.class,i);
		}
		public List<ConnectionDeclContext> connectionDecl() {
			return getRuleContexts(ConnectionDeclContext.class);
		}
		public ConnectionDeclContext connectionDecl(int i) {
			return getRuleContext(ConnectionDeclContext.class,i);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(46);
				namespaceDecl();
				}
			}

			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(49);
				importDecl();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(55);
				match(T__0);
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__19) | (1L << T__20))) != 0)) {
					{
					{
					setState(56);
					typeDecl();
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(64);
			match(T__1);
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				componentDecl();
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__8 || _la==ID );
			setState(77);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(70);
				match(T__2);
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11 || _la==ID) {
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
			setState(79);
			match(T__3);
			setState(80);
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
			setState(82);
			match(ID);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(83);
				match(T__4);
				setState(84);
				match(ID);
				}
				}
				setState(89);
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

	public static class ImportDeclContext extends ParserRuleContext {
		public Token elem;
		public Token alias;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4AwasParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4AwasParser.ID, i);
		}
		public ImportDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDecl; }
	}

	public final ImportDeclContext importDecl() throws RecognitionException {
		ImportDeclContext _localctx = new ImportDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_importDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__5);
			setState(91);
			name();
			setState(94);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(92);
				match(T__6);
				setState(93);
				((ImportDeclContext)_localctx).elem = match(ID);
				}
			}

			setState(98);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(96);
				match(T__7);
				setState(97);
				((ImportDeclContext)_localctx).alias = match(ID);
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
		enterRule(_localctx, 12, RULE_typeDecl);
		try {
			setState(103);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				enumDecl();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				latticeDecl();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
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
		public TerminalNode ID() { return getToken(Antlr4AwasParser.ID, 0); }
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
		enterRule(_localctx, 14, RULE_componentDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(105);
				match(T__8);
				}
			}

			setState(108);
			match(ID);
			setState(116);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(109);
				match(T__9);
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__21 || _la==T__22) {
					{
					{
					setState(110);
					port();
					}
					}
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(125);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(118);
				match(T__10);
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(119);
						property();
						}
						} 
					}
					setState(124);
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

	public static class ConnectionDeclContext extends ParserRuleContext {
		public Token id;
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
		enterRule(_localctx, 16, RULE_connectionDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(127);
				match(T__11);
				}
			}

			setState(130);
			((ConnectionDeclContext)_localctx).id = match(ID);
			setState(131);
			match(T__12);
			setState(132);
			((ConnectionDeclContext)_localctx).fromComponent = match(ID);
			setState(135);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(133);
				match(T__6);
				setState(134);
				((ConnectionDeclContext)_localctx).fromPort = match(ID);
				}
			}

			setState(137);
			match(T__13);
			setState(138);
			((ConnectionDeclContext)_localctx).toComponent = match(ID);
			setState(141);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(139);
				match(T__6);
				setState(140);
				((ConnectionDeclContext)_localctx).toPort = match(ID);
				}
			}

			setState(150);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(143);
				match(T__10);
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(144);
						property();
						}
						} 
					}
					setState(149);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		enterRule(_localctx, 18, RULE_enumDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__14);
			setState(153);
			((EnumDeclContext)_localctx).id = match(ID);
			setState(163);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(154);
				match(T__15);
				setState(155);
				((EnumDeclContext)_localctx).ID = match(ID);
				((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).ID);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(156);
					match(T__16);
					setState(157);
					((EnumDeclContext)_localctx).ID = match(ID);
					((EnumDeclContext)_localctx).supers.add(((EnumDeclContext)_localctx).ID);
					}
					}
					setState(162);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(175);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(165);
				match(T__17);
				setState(166);
				((EnumDeclContext)_localctx).ID = match(ID);
				((EnumDeclContext)_localctx).elements.add(((EnumDeclContext)_localctx).ID);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(167);
					match(T__16);
					setState(168);
					((EnumDeclContext)_localctx).ID = match(ID);
					((EnumDeclContext)_localctx).elements.add(((EnumDeclContext)_localctx).ID);
					}
					}
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(174);
				match(T__18);
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
		public Token id;
		public Token ID;
		public List<Token> supers = new ArrayList<Token>();
		public List<TerminalNode> ID() { return getTokens(Antlr4AwasParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4AwasParser.ID, i);
		}
		public LatticeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_latticeDecl; }
	}

	public final LatticeDeclContext latticeDecl() throws RecognitionException {
		LatticeDeclContext _localctx = new LatticeDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_latticeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(T__19);
			setState(178);
			((LatticeDeclContext)_localctx).id = match(ID);
			setState(188);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(179);
				match(T__15);
				setState(180);
				((LatticeDeclContext)_localctx).ID = match(ID);
				((LatticeDeclContext)_localctx).supers.add(((LatticeDeclContext)_localctx).ID);
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(181);
					match(T__16);
					setState(182);
					((LatticeDeclContext)_localctx).ID = match(ID);
					((LatticeDeclContext)_localctx).supers.add(((LatticeDeclContext)_localctx).ID);
					}
					}
					setState(187);
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
		public TerminalNode ID() { return getToken(Antlr4AwasParser.ID, 0); }
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
		enterRule(_localctx, 22, RULE_recordDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__20);
			setState(191);
			match(ID);
			setState(193); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(192);
				field();
				}
				}
				setState(195); 
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
		enterRule(_localctx, 24, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(ID);
			setState(198);
			match(T__12);
			setState(199);
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
		enterRule(_localctx, 26, RULE_port);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			((PortContext)_localctx).mod = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==T__22) ) {
				((PortContext)_localctx).mod = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(202);
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
		enterRule(_localctx, 28, RULE_property);
		int _la;
		try {
			setState(214);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				match(ID);
				setState(205);
				match(T__12);
				setState(206);
				type();
				setState(209);
				_la = _input.LA(1);
				if (_la==T__23) {
					{
					setState(207);
					match(T__23);
					setState(208);
					init();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(ID);
				setState(212);
				match(T__23);
				setState(213);
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
		enterRule(_localctx, 30, RULE_type);
		try {
			setState(239);
			switch (_input.LA(1)) {
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case ID:
				_localctx = new BaseTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				basicType();
				}
				break;
			case T__24:
				_localctx = new OptionTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				match(T__24);
				setState(218);
				match(T__25);
				setState(219);
				type();
				setState(220);
				match(T__26);
				}
				break;
			case T__27:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(222);
				match(T__27);
				setState(223);
				match(T__25);
				setState(224);
				type();
				setState(225);
				match(T__26);
				}
				break;
			case T__28:
				_localctx = new SeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(227);
				match(T__28);
				setState(228);
				match(T__25);
				setState(229);
				type();
				setState(230);
				match(T__26);
				}
				break;
			case T__29:
				_localctx = new MapTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(232);
				match(T__29);
				setState(233);
				match(T__25);
				setState(234);
				basicType();
				setState(235);
				match(T__16);
				setState(236);
				type();
				setState(237);
				match(T__26);
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

	public final BasicTypeContext basicType() throws RecognitionException {
		BasicTypeContext _localctx = new BasicTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_basicType);
		try {
			setState(246);
			switch (_input.LA(1)) {
			case T__30:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				match(T__30);
				}
				break;
			case T__31:
				_localctx = new IntegerTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				match(T__31);
				}
				break;
			case T__32:
				_localctx = new RealTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(243);
				match(T__32);
				}
				break;
			case T__33:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(244);
				match(T__33);
				}
				break;
			case ID:
				_localctx = new NamedTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(245);
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
	public static class SomeContext extends InitContext {
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SomeContext(InitContext ctx) { copyFrom(ctx); }
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
	public static class RecordContext extends InitContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<InitContext> init() {
			return getRuleContexts(InitContext.class);
		}
		public InitContext init(int i) {
			return getRuleContext(InitContext.class,i);
		}
		public RecordContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class FalseContext extends InitContext {
		public FalseContext(InitContext ctx) { copyFrom(ctx); }
	}
	public static class StringContext extends InitContext {
		public TerminalNode STRING() { return getToken(Antlr4AwasParser.STRING, 0); }
		public StringContext(InitContext ctx) { copyFrom(ctx); }
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
	public static class EnumOrLatticeContext extends InitContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode ID() { return getToken(Antlr4AwasParser.ID, 0); }
		public EnumOrLatticeContext(InitContext ctx) { copyFrom(ctx); }
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_init);
		int _la;
		try {
			setState(347);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				match(T__34);
				}
				break;
			case 2:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				match(T__35);
				}
				break;
			case 3:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(250);
				match(INTEGER);
				}
				break;
			case 4:
				_localctx = new RealContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(251);
				match(REAL);
				}
				break;
			case 5:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(252);
				match(STRING);
				}
				break;
			case 6:
				_localctx = new RecordContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(253);
				name();
				setState(254);
				match(T__36);
				setState(255);
				init();
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(256);
					match(T__16);
					setState(257);
					init();
					}
					}
					setState(262);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(263);
				match(T__37);
				}
				break;
			case 7:
				_localctx = new EnumOrLatticeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(265);
				name();
				setState(268);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(266);
					match(T__6);
					setState(267);
					match(ID);
					}
				}

				}
				break;
			case 8:
				_localctx = new NoneContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(270);
				match(T__38);
				setState(275);
				_la = _input.LA(1);
				if (_la==T__25) {
					{
					setState(271);
					match(T__25);
					setState(272);
					type();
					setState(273);
					match(T__26);
					}
				}

				}
				break;
			case 9:
				_localctx = new SomeContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(277);
				match(T__39);
				setState(282);
				_la = _input.LA(1);
				if (_la==T__25) {
					{
					setState(278);
					match(T__25);
					setState(279);
					type();
					setState(280);
					match(T__26);
					}
				}

				setState(284);
				match(T__36);
				setState(285);
				init();
				setState(286);
				match(T__37);
				}
				break;
			case 10:
				_localctx = new SetContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(288);
				match(T__27);
				setState(293);
				_la = _input.LA(1);
				if (_la==T__25) {
					{
					setState(289);
					match(T__25);
					setState(290);
					type();
					setState(291);
					match(T__26);
					}
				}

				setState(295);
				match(T__36);
				setState(304);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__34) | (1L << T__35) | (1L << T__38) | (1L << T__39) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(296);
					init();
					setState(301);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__16) {
						{
						{
						setState(297);
						match(T__16);
						setState(298);
						init();
						}
						}
						setState(303);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(306);
				match(T__37);
				}
				break;
			case 11:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(307);
				match(T__28);
				setState(312);
				_la = _input.LA(1);
				if (_la==T__25) {
					{
					setState(308);
					match(T__25);
					setState(309);
					type();
					setState(310);
					match(T__26);
					}
				}

				setState(314);
				match(T__36);
				setState(323);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__34) | (1L << T__35) | (1L << T__38) | (1L << T__39) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(315);
					init();
					setState(320);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__16) {
						{
						{
						setState(316);
						match(T__16);
						setState(317);
						init();
						}
						}
						setState(322);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(325);
				match(T__37);
				}
				break;
			case 12:
				_localctx = new MapContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(326);
				match(T__29);
				setState(333);
				_la = _input.LA(1);
				if (_la==T__25) {
					{
					setState(327);
					match(T__25);
					setState(328);
					basicType();
					setState(329);
					match(T__16);
					setState(330);
					type();
					setState(331);
					match(T__26);
					}
				}

				setState(335);
				match(T__36);
				setState(344);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__34) | (1L << T__35) | (1L << T__38) | (1L << T__39) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					setState(336);
					mapEntry();
					setState(341);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__16) {
						{
						{
						setState(337);
						match(T__16);
						setState(338);
						mapEntry();
						}
						}
						setState(343);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(346);
				match(T__37);
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
			setState(349);
			((MapEntryContext)_localctx).key = init();
			setState(350);
			match(T__13);
			setState(351);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u0164\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\3\6\3-\n\3\r\3\16\3.\3\4\5\4\62\n\4"+
		"\3\4\7\4\65\n\4\f\4\16\48\13\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\5\4A\n"+
		"\4\3\4\3\4\6\4E\n\4\r\4\16\4F\3\4\3\4\7\4K\n\4\f\4\16\4N\13\4\5\4P\n\4"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\7\6X\n\6\f\6\16\6[\13\6\3\7\3\7\3\7\3\7\5\7a"+
		"\n\7\3\7\3\7\5\7e\n\7\3\b\3\b\3\b\5\bj\n\b\3\t\5\tm\n\t\3\t\3\t\3\t\7"+
		"\tr\n\t\f\t\16\tu\13\t\5\tw\n\t\3\t\3\t\7\t{\n\t\f\t\16\t~\13\t\5\t\u0080"+
		"\n\t\3\n\5\n\u0083\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u008a\n\n\3\n\3\n\3\n\3"+
		"\n\5\n\u0090\n\n\3\n\3\n\7\n\u0094\n\n\f\n\16\n\u0097\13\n\5\n\u0099\n"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00a1\n\13\f\13\16\13\u00a4\13\13"+
		"\5\13\u00a6\n\13\3\13\3\13\3\13\3\13\7\13\u00ac\n\13\f\13\16\13\u00af"+
		"\13\13\3\13\5\13\u00b2\n\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00ba\n\f\f\f"+
		"\16\f\u00bd\13\f\5\f\u00bf\n\f\3\r\3\r\3\r\6\r\u00c4\n\r\r\r\16\r\u00c5"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\5\20\u00d4"+
		"\n\20\3\20\3\20\3\20\5\20\u00d9\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u00f2\n\21\3\22\3\22\3\22\3\22\3\22\5\22\u00f9\n\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0105\n\23\f\23"+
		"\16\23\u0108\13\23\3\23\3\23\3\23\3\23\3\23\5\23\u010f\n\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u0116\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u011d\n"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0128\n\23\3\23"+
		"\3\23\3\23\3\23\7\23\u012e\n\23\f\23\16\23\u0131\13\23\5\23\u0133\n\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u013b\n\23\3\23\3\23\3\23\3\23\7\23"+
		"\u0141\n\23\f\23\16\23\u0144\13\23\5\23\u0146\n\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u0150\n\23\3\23\3\23\3\23\3\23\7\23\u0156\n"+
		"\23\f\23\16\23\u0159\13\23\5\23\u015b\n\23\3\23\5\23\u015e\n\23\3\24\3"+
		"\24\3\24\3\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"\2\3\3\2\30\31\u0190\2(\3\2\2\2\4,\3\2\2\2\6\61\3\2\2\2\bQ\3\2\2\2\nT"+
		"\3\2\2\2\f\\\3\2\2\2\16i\3\2\2\2\20l\3\2\2\2\22\u0082\3\2\2\2\24\u009a"+
		"\3\2\2\2\26\u00b3\3\2\2\2\30\u00c0\3\2\2\2\32\u00c7\3\2\2\2\34\u00cb\3"+
		"\2\2\2\36\u00d8\3\2\2\2 \u00f1\3\2\2\2\"\u00f8\3\2\2\2$\u015d\3\2\2\2"+
		"&\u015f\3\2\2\2()\5\4\3\2)*\7\2\2\3*\3\3\2\2\2+-\5\6\4\2,+\3\2\2\2-.\3"+
		"\2\2\2.,\3\2\2\2./\3\2\2\2/\5\3\2\2\2\60\62\5\b\5\2\61\60\3\2\2\2\61\62"+
		"\3\2\2\2\62\66\3\2\2\2\63\65\5\f\7\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3"+
		"\2\2\2\66\67\3\2\2\2\67@\3\2\2\28\66\3\2\2\29=\7\3\2\2:<\5\16\b\2;:\3"+
		"\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>A\3\2\2\2?=\3\2\2\2@9\3\2\2\2@A\3"+
		"\2\2\2AB\3\2\2\2BD\7\4\2\2CE\5\20\t\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG"+
		"\3\2\2\2GO\3\2\2\2HL\7\5\2\2IK\5\22\n\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2"+
		"LM\3\2\2\2MP\3\2\2\2NL\3\2\2\2OH\3\2\2\2OP\3\2\2\2P\7\3\2\2\2QR\7\6\2"+
		"\2RS\5\n\6\2S\t\3\2\2\2TY\7.\2\2UV\7\7\2\2VX\7.\2\2WU\3\2\2\2X[\3\2\2"+
		"\2YW\3\2\2\2YZ\3\2\2\2Z\13\3\2\2\2[Y\3\2\2\2\\]\7\b\2\2]`\5\n\6\2^_\7"+
		"\t\2\2_a\7.\2\2`^\3\2\2\2`a\3\2\2\2ad\3\2\2\2bc\7\n\2\2ce\7.\2\2db\3\2"+
		"\2\2de\3\2\2\2e\r\3\2\2\2fj\5\24\13\2gj\5\26\f\2hj\5\30\r\2if\3\2\2\2"+
		"ig\3\2\2\2ih\3\2\2\2j\17\3\2\2\2km\7\13\2\2lk\3\2\2\2lm\3\2\2\2mn\3\2"+
		"\2\2nv\7.\2\2os\7\f\2\2pr\5\34\17\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3"+
		"\2\2\2tw\3\2\2\2us\3\2\2\2vo\3\2\2\2vw\3\2\2\2w\177\3\2\2\2x|\7\r\2\2"+
		"y{\5\36\20\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\u0080\3\2\2\2~|"+
		"\3\2\2\2\177x\3\2\2\2\177\u0080\3\2\2\2\u0080\21\3\2\2\2\u0081\u0083\7"+
		"\16\2\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0085\7.\2\2\u0085\u0086\7\17\2\2\u0086\u0089\7.\2\2\u0087\u0088\7\t"+
		"\2\2\u0088\u008a\7.\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008c\7\20\2\2\u008c\u008f\7.\2\2\u008d\u008e\7\t"+
		"\2\2\u008e\u0090\7.\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0098\3\2\2\2\u0091\u0095\7\r\2\2\u0092\u0094\5\36\20\2\u0093\u0092\3"+
		"\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0091\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\23\3\2\2\2\u009a\u009b\7\21\2\2\u009b\u00a5\7.\2\2\u009c\u009d"+
		"\7\22\2\2\u009d\u00a2\7.\2\2\u009e\u009f\7\23\2\2\u009f\u00a1\7.\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u009c\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00b1\3\2\2\2\u00a7\u00a8\7\24\2\2\u00a8\u00ad\7"+
		".\2\2\u00a9\u00aa\7\23\2\2\u00aa\u00ac\7.\2\2\u00ab\u00a9\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\7\25\2\2\u00b1\u00a7\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\25\3\2\2\2\u00b3\u00b4\7\26\2\2\u00b4\u00be\7.\2"+
		"\2\u00b5\u00b6\7\22\2\2\u00b6\u00bb\7.\2\2\u00b7\u00b8\7\23\2\2\u00b8"+
		"\u00ba\7.\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2"+
		"\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00b5\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\27\3\2\2\2\u00c0\u00c1\7\27\2"+
		"\2\u00c1\u00c3\7.\2\2\u00c2\u00c4\5\32\16\2\u00c3\u00c2\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\31\3\2\2"+
		"\2\u00c7\u00c8\7.\2\2\u00c8\u00c9\7\17\2\2\u00c9\u00ca\5 \21\2\u00ca\33"+
		"\3\2\2\2\u00cb\u00cc\t\2\2\2\u00cc\u00cd\7.\2\2\u00cd\35\3\2\2\2\u00ce"+
		"\u00cf\7.\2\2\u00cf\u00d0\7\17\2\2\u00d0\u00d3\5 \21\2\u00d1\u00d2\7\32"+
		"\2\2\u00d2\u00d4\5$\23\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d9\3\2\2\2\u00d5\u00d6\7.\2\2\u00d6\u00d7\7\32\2\2\u00d7\u00d9\5$"+
		"\23\2\u00d8\u00ce\3\2\2\2\u00d8\u00d5\3\2\2\2\u00d9\37\3\2\2\2\u00da\u00f2"+
		"\5\"\22\2\u00db\u00dc\7\33\2\2\u00dc\u00dd\7\34\2\2\u00dd\u00de\5 \21"+
		"\2\u00de\u00df\7\35\2\2\u00df\u00f2\3\2\2\2\u00e0\u00e1\7\36\2\2\u00e1"+
		"\u00e2\7\34\2\2\u00e2\u00e3\5 \21\2\u00e3\u00e4\7\35\2\2\u00e4\u00f2\3"+
		"\2\2\2\u00e5\u00e6\7\37\2\2\u00e6\u00e7\7\34\2\2\u00e7\u00e8\5 \21\2\u00e8"+
		"\u00e9\7\35\2\2\u00e9\u00f2\3\2\2\2\u00ea\u00eb\7 \2\2\u00eb\u00ec\7\34"+
		"\2\2\u00ec\u00ed\5\"\22\2\u00ed\u00ee\7\23\2\2\u00ee\u00ef\5 \21\2\u00ef"+
		"\u00f0\7\35\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00da\3\2\2\2\u00f1\u00db\3"+
		"\2\2\2\u00f1\u00e0\3\2\2\2\u00f1\u00e5\3\2\2\2\u00f1\u00ea\3\2\2\2\u00f2"+
		"!\3\2\2\2\u00f3\u00f9\7!\2\2\u00f4\u00f9\7\"\2\2\u00f5\u00f9\7#\2\2\u00f6"+
		"\u00f9\7$\2\2\u00f7\u00f9\5\n\6\2\u00f8\u00f3\3\2\2\2\u00f8\u00f4\3\2"+
		"\2\2\u00f8\u00f5\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9"+
		"#\3\2\2\2\u00fa\u015e\7%\2\2\u00fb\u015e\7&\2\2\u00fc\u015e\7+\2\2\u00fd"+
		"\u015e\7,\2\2\u00fe\u015e\7-\2\2\u00ff\u0100\5\n\6\2\u0100\u0101\7\'\2"+
		"\2\u0101\u0106\5$\23\2\u0102\u0103\7\23\2\2\u0103\u0105\5$\23\2\u0104"+
		"\u0102\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2"+
		"\2\2\u0107\u0109\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010a\7(\2\2\u010a"+
		"\u015e\3\2\2\2\u010b\u010e\5\n\6\2\u010c\u010d\7\t\2\2\u010d\u010f\7."+
		"\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u015e\3\2\2\2\u0110"+
		"\u0115\7)\2\2\u0111\u0112\7\34\2\2\u0112\u0113\5 \21\2\u0113\u0114\7\35"+
		"\2\2\u0114\u0116\3\2\2\2\u0115\u0111\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"\u015e\3\2\2\2\u0117\u011c\7*\2\2\u0118\u0119\7\34\2\2\u0119\u011a\5 "+
		"\21\2\u011a\u011b\7\35\2\2\u011b\u011d\3\2\2\2\u011c\u0118\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\7\'\2\2\u011f\u0120\5$"+
		"\23\2\u0120\u0121\7(\2\2\u0121\u015e\3\2\2\2\u0122\u0127\7\36\2\2\u0123"+
		"\u0124\7\34\2\2\u0124\u0125\5 \21\2\u0125\u0126\7\35\2\2\u0126\u0128\3"+
		"\2\2\2\u0127\u0123\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\u0132\7\'\2\2\u012a\u012f\5$\23\2\u012b\u012c\7\23\2\2\u012c\u012e\5"+
		"$\23\2\u012d\u012b\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u012a\3\2"+
		"\2\2\u0132\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u015e\7(\2\2\u0135"+
		"\u013a\7\37\2\2\u0136\u0137\7\34\2\2\u0137\u0138\5 \21\2\u0138\u0139\7"+
		"\35\2\2\u0139\u013b\3\2\2\2\u013a\u0136\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u0145\7\'\2\2\u013d\u0142\5$\23\2\u013e\u013f\7\23"+
		"\2\2\u013f\u0141\5$\23\2\u0140\u013e\3\2\2\2\u0141\u0144\3\2\2\2\u0142"+
		"\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2"+
		"\2\2\u0145\u013d\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\3\2\2\2\u0147"+
		"\u015e\7(\2\2\u0148\u014f\7 \2\2\u0149\u014a\7\34\2\2\u014a\u014b\5\""+
		"\22\2\u014b\u014c\7\23\2\2\u014c\u014d\5 \21\2\u014d\u014e\7\35\2\2\u014e"+
		"\u0150\3\2\2\2\u014f\u0149\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2"+
		"\2\2\u0151\u015a\7\'\2\2\u0152\u0157\5&\24\2\u0153\u0154\7\23\2\2\u0154"+
		"\u0156\5&\24\2\u0155\u0153\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2"+
		"\2\2\u0157\u0158\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u015a"+
		"\u0152\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\7("+
		"\2\2\u015d\u00fa\3\2\2\2\u015d\u00fb\3\2\2\2\u015d\u00fc\3\2\2\2\u015d"+
		"\u00fd\3\2\2\2\u015d\u00fe\3\2\2\2\u015d\u00ff\3\2\2\2\u015d\u010b\3\2"+
		"\2\2\u015d\u0110\3\2\2\2\u015d\u0117\3\2\2\2\u015d\u0122\3\2\2\2\u015d"+
		"\u0135\3\2\2\2\u015d\u0148\3\2\2\2\u015e%\3\2\2\2\u015f\u0160\5$\23\2"+
		"\u0160\u0161\7\20\2\2\u0161\u0162\5$\23\2\u0162\'\3\2\2\2\61.\61\66=@"+
		"FLOY`dilsv|\177\u0082\u0089\u008f\u0095\u0098\u00a2\u00a5\u00ad\u00b1"+
		"\u00bb\u00be\u00c5\u00d3\u00d8\u00f1\u00f8\u0106\u010e\u0115\u011c\u0127"+
		"\u012f\u0132\u013a\u0142\u0145\u014f\u0157\u015a\u015d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}