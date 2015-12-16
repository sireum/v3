// Generated from /Users/robby/Repositories/Sireum-Private/sireum-v3/logika/sireum-logika-parser-antlr4/src/main/resources/org/sireum/logika/parser/Antlr4Logika.g4 by ANTLR 4.5.1
package org.sireum.logika.parser;

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
public class Antlr4LogikaParser extends Parser {
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
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, T__82=83, T__83=84, T__84=85, T__85=86, T__86=87, 
		T__87=88, T__88=89, T__89=90, T__90=91, T__91=92, T__92=93, T__93=94, 
		T__94=95, T__95=96, T__96=97, T__97=98, T__98=99, T__99=100, T__100=101, 
		T__101=102, T__102=103, T__103=104, T__104=105, T__105=106, T__106=107, 
		T__107=108, T__108=109, T__109=110, T__110=111, T__111=112, T__112=113, 
		T__113=114, T__114=115, T__115=116, T__116=117, T__117=118, HLINE=119, 
		NUM=120, ID=121, STRING=122, RESERVED=123, NL=124, LINE_COMMENT=125, COMMENT=126, 
		WS=127, ERROR_CHAR=128;
	public static final int
		RULE_sequentFile = 0, RULE_proofFile = 1, RULE_programFile = 2, RULE_sequent = 3, 
		RULE_proof = 4, RULE_proofStep = 5, RULE_formula = 6, RULE_qformula = 7, 
		RULE_type = 8, RULE_justification = 9, RULE_numOrId = 10, RULE_program = 11, 
		RULE_lgk = 12, RULE_facts = 13, RULE_factOrFun = 14, RULE_fact = 15, RULE_fun = 16, 
		RULE_param = 17, RULE_stmts = 18, RULE_stmt = 19, RULE_exp = 20, RULE_loopInvariant = 21, 
		RULE_modifies = 22, RULE_methodContract = 23, RULE_invariants = 24;
	public static final String[] ruleNames = {
		"sequentFile", "proofFile", "programFile", "sequent", "proof", "proofStep", 
		"formula", "qformula", "type", "justification", "numOrId", "program", 
		"lgk", "facts", "factOrFun", "fact", "fun", "param", "stmts", "stmt", 
		"exp", "loopInvariant", "modifies", "methodContract", "invariants"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'|-'", "'⊢'", "'{'", "'}'", "'.'", "'assume'", "'true'", 
		"'T'", "'⊤'", "'false'", "'F'", "'_|_'", "'⊥'", "'('", "')      '", "'$result'", 
		"')'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<'", "'<='", "'≤'", "'>'", 
		"'>='", "'≥'", "'='", "'=='", "'!='", "'≠'", "'not'", "'!'", "'~'", "'¬'", 
		"'and'", "'&&'", "'∧'", "'or'", "'||'", "'∨'", "'implies'", "'->'", "'→'", 
		"'forall'", "'all'", "'A'", "'∀'", "'exists'", "'some'", "'E'", "'∃'", 
		"':'", "'|'", "'Boolean'", "'B'", "'BigInt'", "'Z'", "'Seq'", "'['", "']'", 
		"'ZS'", "'premise'", "'andi'", "'ande1'", "'ande2'", "'ori1'", "'ori2'", 
		"'ore'", "'impliesi'", "'impliese'", "'noti'", "'negi'", "'note'", "'nege'", 
		"'bottome'", "'falsee'", "'Pbc'", "'foralli'", "'alli'", "'Ai'", "'foralle'", 
		"'alle'", "'Ae'", "'existsi'", "'somei'", "'Ei'", "'existse'", "'somee'", 
		"'Ee'", "'algebra'", "'auto'", "'import'", "'logika'", "'_'", "'\"\"\"'", 
		"'fact'", "'def'", "'var'", "'val'", "'assert'", "'if'", "'else'", "'while'", 
		"'readInt'", "'print'", "'println'", "'+:'", "':+'", "'Unit'", "'return'", 
		"'Zs'", "'invariant'", "'modifies'", "'requires'", "'ensures'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "HLINE", 
		"NUM", "ID", "STRING", "RESERVED", "NL", "LINE_COMMENT", "COMMENT", "WS", 
		"ERROR_CHAR"
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
	public String getGrammarFileName() { return "Antlr4Logika.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Antlr4LogikaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SequentFileContext extends ParserRuleContext {
		public SequentContext sequent() {
			return getRuleContext(SequentContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Antlr4LogikaParser.EOF, 0); }
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public ProofContext proof() {
			return getRuleContext(ProofContext.class,0);
		}
		public SequentFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequentFile; }
	}

	public final SequentFileContext sequentFile() throws RecognitionException {
		SequentFileContext _localctx = new SequentFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sequentFile);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			sequent();
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(51);
					match(NL);
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(58);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(57);
				proof();
				}
			}

			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(60);
				match(NL);
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
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

	public static class ProofFileContext extends ParserRuleContext {
		public ProofContext proof() {
			return getRuleContext(ProofContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Antlr4LogikaParser.EOF, 0); }
		public ProofFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proofFile; }
	}

	public final ProofFileContext proofFile() throws RecognitionException {
		ProofFileContext _localctx = new ProofFileContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_proofFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			proof();
			setState(69);
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

	public static class ProgramFileContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Antlr4LogikaParser.EOF, 0); }
		public ProgramFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programFile; }
	}

	public final ProgramFileContext programFile() throws RecognitionException {
		ProgramFileContext _localctx = new ProgramFileContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_programFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			program();
			setState(72);
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

	public static class SequentContext extends ParserRuleContext {
		public FormulaContext formula;
		public List<FormulaContext> premises = new ArrayList<FormulaContext>();
		public List<FormulaContext> conclusions = new ArrayList<FormulaContext>();
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode HLINE() { return getToken(Antlr4LogikaParser.HLINE, 0); }
		public SequentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequent; }
	}

	public final SequentContext sequent() throws RecognitionException {
		SequentContext _localctx = new SequentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sequent);
		int _la;
		try {
			setState(105);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__22) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==NUM || _la==ID) {
					{
					setState(74);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(75);
						match(T__0);
						setState(76);
						((SequentContext)_localctx).formula = formula(0);
						((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
						}
						}
						setState(81);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(84);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(85);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(86);
					match(T__0);
					setState(87);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__22) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==NUM || _la==ID) {
					{
					{
					setState(93);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(99);
				match(HLINE);
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(100);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(103); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__22) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==NUM || _la==ID );
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

	public static class ProofContext extends ParserRuleContext {
		public Token tb;
		public Token te;
		public List<ProofStepContext> proofStep() {
			return getRuleContexts(ProofStepContext.class);
		}
		public ProofStepContext proofStep(int i) {
			return getRuleContext(ProofStepContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public ProofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proof; }
	}

	public final ProofContext proof() throws RecognitionException {
		ProofContext _localctx = new ProofContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_proof);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			((ProofContext)_localctx).tb = match(T__3);
			setState(109);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(108);
				proofStep();
				}
			}

			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(112); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(111);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(114); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(117);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(116);
					proofStep();
					}
				}

				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
			((ProofContext)_localctx).te = match(T__4);
			setState(128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(125);
					match(NL);
					}
					} 
				}
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class ProofStepContext extends ParserRuleContext {
		public ProofStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proofStep; }
	 
		public ProofStepContext() { }
		public void copyFrom(ProofStepContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubProofContext extends ProofStepContext {
		public Token sub;
		public Token assume;
		public Token fresh;
		public Token ate;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public List<ProofStepContext> proofStep() {
			return getRuleContexts(ProofStepContext.class);
		}
		public ProofStepContext proofStep(int i) {
			return getRuleContext(ProofStepContext.class,i);
		}
		public SubProofContext(ProofStepContext ctx) { copyFrom(ctx); }
	}
	public static class StepContext extends ProofStepContext {
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public JustificationContext justification() {
			return getRuleContext(JustificationContext.class,0);
		}
		public StepContext(ProofStepContext ctx) { copyFrom(ctx); }
	}

	public final ProofStepContext proofStep() throws RecognitionException {
		ProofStepContext _localctx = new ProofStepContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_proofStep);
		int _la;
		try {
			setState(174);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(NUM);
				setState(132);
				match(T__5);
				setState(133);
				formula(0);
				setState(134);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(137);
				match(T__5);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(138);
					match(NL);
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(144);
				match(T__3);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(145);
					match(NL);
					}
					}
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(151);
				((SubProofContext)_localctx).assume = match(NUM);
				setState(152);
				match(T__5);
				setState(160);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(153);
					((SubProofContext)_localctx).fresh = match(ID);
					}
					break;
				case 2:
					{
					setState(155);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(154);
						((SubProofContext)_localctx).fresh = match(ID);
						}
						break;
					}
					setState(157);
					formula(0);
					setState(158);
					((SubProofContext)_localctx).ate = match(T__6);
					}
					break;
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(163); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(162);
						match(NL);
						}
						}
						setState(165); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NL );
					setState(167);
					proofStep();
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				match(T__4);
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

	public static class FormulaContext extends ParserRuleContext {
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarContext extends FormulaContext {
		public Token tb;
		public Token te;
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public VarContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class ApplyContext extends FormulaContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ApplyContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class BinaryContext extends FormulaContext {
		public FormulaContext l;
		public Token op;
		public FormulaContext r;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public BinaryContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanContext extends FormulaContext {
		public Token t;
		public BooleanContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class UnaryContext extends FormulaContext {
		public Token op;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public UnaryContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class IntContext extends FormulaContext {
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public IntContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class ParenContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ParenContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class ResultContext extends FormulaContext {
		public ResultContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class QuantContext extends FormulaContext {
		public QformulaContext qformula() {
			return getRuleContext(QformulaContext.class,0);
		}
		public QuantContext(FormulaContext ctx) { copyFrom(ctx); }
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(177);
				((UnaryContext)_localctx).op = match(T__22);
				setState(178);
				formula(6);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(180);
				formula(5);
				}
				break;
			case 3:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				((BooleanContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
					((BooleanContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 4:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				((VarContext)_localctx).tb = match(ID);
				setState(185);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(183);
					match(T__5);
					setState(184);
					((VarContext)_localctx).te = match(ID);
					}
					break;
				}
				}
				break;
			case 5:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(T__14);
				setState(188);
				formula(0);
				setState(189);
				match(T__15);
				}
				break;
			case 6:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				match(T__16);
				}
				break;
			case 7:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(ID);
				setState(193);
				match(T__14);
				setState(194);
				formula(0);
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(195);
					match(T__0);
					setState(196);
					formula(0);
					}
					}
					setState(201);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(202);
				match(T__17);
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				match(NUM);
				}
				break;
			case 9:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(250);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(208);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(209);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(211);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(210);
							match(NL);
							}
						}

						setState(213);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(214);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(215);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(217);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(216);
							match(NL);
							}
						}

						setState(219);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(220);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(221);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(223);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(222);
							match(NL);
							}
						}

						setState(225);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(226);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(227);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(229);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(228);
							match(NL);
							}
						}

						setState(231);
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(232);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(233);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(235);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(234);
							match(NL);
							}
						}

						setState(237);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(238);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(239);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__41) | (1L << T__42))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(241);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(240);
							match(NL);
							}
						}

						setState(243);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(244);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(245);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(247);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(246);
							match(NL);
							}
						}

						setState(249);
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class QformulaContext extends ParserRuleContext {
		public Token q;
		public Token ID;
		public List<Token> vars = new ArrayList<Token>();
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public QformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qformula; }
	}

	public final QformulaContext qformula() throws RecognitionException {
		QformulaContext _localctx = new QformulaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_qformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(256);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(257);
				match(T__0);
				setState(258);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(266);
			_la = _input.LA(1);
			if (_la==T__54) {
				{
				setState(264);
				match(T__54);
				setState(265);
				type();
				}
			}

			setState(268);
			match(T__55);
			setState(270);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(269);
				match(NL);
				}
			}

			setState(272);
			formula(0);
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
	public static class BooleanTypeContext extends TypeContext {
		public Token t;
		public BooleanTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class IntSeqTypeContext extends TypeContext {
		public Token tb;
		public Token te;
		public Token t;
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public IntSeqTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class IntTypeContext extends TypeContext {
		public Token t;
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		int _la;
		try {
			setState(293);
			switch (_input.LA(1)) {
			case T__56:
			case T__57:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				((BooleanTypeContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__56 || _la==T__57) ) {
					((BooleanTypeContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case T__58:
			case T__59:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				((IntTypeContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__58 || _la==T__59) ) {
					((IntTypeContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case T__60:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(276);
				((IntSeqTypeContext)_localctx).tb = match(T__60);
				setState(277);
				match(T__61);
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(278);
					match(NL);
					}
					}
					setState(283);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(284);
				_la = _input.LA(1);
				if ( !(_la==T__58 || _la==T__59) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(285);
					match(NL);
					}
					}
					setState(290);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(291);
				((IntSeqTypeContext)_localctx).te = match(T__62);
				}
				break;
			case T__63:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(292);
				((IntSeqTypeContext)_localctx).t = match(T__63);
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

	public static class JustificationContext extends ParserRuleContext {
		public JustificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_justification; }
	 
		public JustificationContext() { }
		public void copyFrom(JustificationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForallElimContext extends JustificationContext {
		public Token tb;
		public NumOrIdContext stepOrFact;
		public NumOrIdContext numOrId() {
			return getRuleContext(NumOrIdContext.class,0);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ForallElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ExistsIntroContext extends JustificationContext {
		public Token tb;
		public Token existsStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ExistsIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndIntroContext extends JustificationContext {
		public Token tb;
		public Token lStep;
		public Token rStep;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public AndIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class OrIntroContext extends JustificationContext {
		public Token tb;
		public Token orStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public OrIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ForallIntroContext extends JustificationContext {
		public Token tb;
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ForallIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ExistsElimContext extends JustificationContext {
		public Token tb;
		public NumOrIdContext stepOrFact;
		public Token subproof;
		public Token t;
		public Token subProof;
		public NumOrIdContext numOrId() {
			return getRuleContext(NumOrIdContext.class,0);
		}
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ExistsElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ImpliesElimContext extends JustificationContext {
		public Token tb;
		public Token impliesStep;
		public Token antecedentStep;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ImpliesElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class PremiseContext extends JustificationContext {
		public Token t;
		public PremiseContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndElimContext extends JustificationContext {
		public Token tb;
		public Token andStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public AndElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class NegIntroContext extends JustificationContext {
		public Token tb;
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public NegIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class NegElimContext extends JustificationContext {
		public Token tb;
		public Token step;
		public Token negStep;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public NegElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class PbcContext extends JustificationContext {
		public Token tb;
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public PbcContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AutoContext extends JustificationContext {
		public Token tb;
		public NumOrIdContext numOrId;
		public List<NumOrIdContext> stepOrFacts = new ArrayList<NumOrIdContext>();
		public List<NumOrIdContext> numOrId() {
			return getRuleContexts(NumOrIdContext.class);
		}
		public NumOrIdContext numOrId(int i) {
			return getRuleContext(NumOrIdContext.class,i);
		}
		public AutoContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AlgebraContext extends JustificationContext {
		public Token tb;
		public Token NUM;
		public List<Token> steps = new ArrayList<Token>();
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public AlgebraContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class BottomElimContext extends JustificationContext {
		public Token tb;
		public Token bottomStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public BottomElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class OrElimContext extends JustificationContext {
		public Token tb;
		public Token orStep;
		public Token lSubProof;
		public Token rSubProof;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public OrElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ImpliesIntroContext extends JustificationContext {
		public Token tb;
		public Token impliesStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ImpliesIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}

	public final JustificationContext justification() throws RecognitionException {
		JustificationContext _localctx = new JustificationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_justification);
		int _la;
		try {
			setState(418);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				((PremiseContext)_localctx).t = match(T__64);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				switch (_input.LA(1)) {
				case T__65:
					{
					setState(296);
					((AndIntroContext)_localctx).tb = match(T__65);
					}
					break;
				case T__38:
				case T__39:
					{
					setState(297);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__38 || _la==T__39) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(298);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(301);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(302);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(306);
				switch (_input.LA(1)) {
				case T__66:
				case T__67:
					{
					setState(303);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__66 || _la==T__67) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__38:
				case T__39:
					{
					setState(304);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__38 || _la==T__39) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(305);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(308);
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(312);
				switch (_input.LA(1)) {
				case T__68:
				case T__69:
					{
					setState(309);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__68 || _la==T__69) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__41:
				case T__42:
					{
					setState(310);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__41 || _la==T__42) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(311);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(314);
				((OrIntroContext)_localctx).orStep = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(318);
				switch (_input.LA(1)) {
				case T__70:
					{
					setState(315);
					((OrElimContext)_localctx).tb = match(T__70);
					}
					break;
				case T__41:
				case T__42:
					{
					setState(316);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__41 || _la==T__42) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(317);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(320);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(321);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(322);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(326);
				switch (_input.LA(1)) {
				case T__71:
					{
					setState(323);
					((ImpliesIntroContext)_localctx).tb = match(T__71);
					}
					break;
				case T__44:
				case T__45:
					{
					setState(324);
					((ImpliesIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__44 || _la==T__45) ) {
						((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(325);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(328);
				((ImpliesIntroContext)_localctx).impliesStep = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(332);
				switch (_input.LA(1)) {
				case T__72:
					{
					setState(329);
					((ImpliesElimContext)_localctx).tb = match(T__72);
					}
					break;
				case T__44:
				case T__45:
					{
					setState(330);
					((ImpliesElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__44 || _la==T__45) ) {
						((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(331);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(334);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(335);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(339);
				switch (_input.LA(1)) {
				case T__73:
				case T__74:
					{
					setState(336);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__73 || _la==T__74) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__34:
				case T__35:
				case T__36:
					{
					setState(337);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(338);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(341);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(346);
				switch (_input.LA(1)) {
				case T__75:
					{
					setState(342);
					((NegElimContext)_localctx).tb = match(T__75);
					}
					break;
				case T__76:
					{
					setState(343);
					((NegElimContext)_localctx).tb = match(T__76);
					}
					break;
				case T__34:
				case T__35:
				case T__36:
					{
					setState(344);
					((NegElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) ) {
						((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(345);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(348);
				((NegElimContext)_localctx).step = match(NUM);
				setState(349);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(353);
				switch (_input.LA(1)) {
				case T__77:
				case T__78:
					{
					setState(350);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__77 || _la==T__78) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__12:
				case T__13:
					{
					setState(351);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__12 || _la==T__13) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(352);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(355);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 11:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(356);
				((PbcContext)_localctx).tb = match(T__79);
				setState(357);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 12:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(363);
				switch (_input.LA(1)) {
				case T__80:
					{
					setState(358);
					((ForallIntroContext)_localctx).tb = match(T__80);
					}
					break;
				case T__81:
					{
					setState(359);
					((ForallIntroContext)_localctx).tb = match(T__81);
					}
					break;
				case T__82:
					{
					setState(360);
					((ForallIntroContext)_localctx).tb = match(T__82);
					}
					break;
				case T__49:
					{
					setState(361);
					((ForallIntroContext)_localctx).tb = match(T__49);
					setState(362);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(365);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(371);
				switch (_input.LA(1)) {
				case T__83:
					{
					setState(366);
					((ForallElimContext)_localctx).tb = match(T__83);
					}
					break;
				case T__84:
					{
					setState(367);
					((ForallElimContext)_localctx).tb = match(T__84);
					}
					break;
				case T__85:
					{
					setState(368);
					((ForallElimContext)_localctx).tb = match(T__85);
					}
					break;
				case T__49:
					{
					setState(369);
					((ForallElimContext)_localctx).tb = match(T__49);
					setState(370);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(373);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
				setState(375); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(374);
					formula(0);
					}
					}
					setState(377); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__22) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 14:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(379);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__88 - 87)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(380);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(382); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(381);
					formula(0);
					}
					}
					setState(384); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__22) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 15:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(386);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (T__89 - 90)) | (1L << (T__90 - 90)) | (1L << (T__91 - 90)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(387);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(388);
				((ExistsElimContext)_localctx).subproof = match(NUM);
				}
				break;
			case 16:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(390);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(391);
				((ExistsIntroContext)_localctx).tb = match(T__53);
				setState(392);
				match(ID);
				setState(393);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(395); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(394);
					formula(0);
					}
					}
					setState(397); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__22) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 17:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(399);
				((ExistsElimContext)_localctx).tb = match(T__53);
				setState(400);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(401);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(402);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(404);
				((AlgebraContext)_localctx).tb = match(T__92);
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(405);
					((AlgebraContext)_localctx).NUM = match(NUM);
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).NUM);
					}
					}
					setState(410);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(411);
				((AutoContext)_localctx).tb = match(T__93);
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(412);
					((AutoContext)_localctx).numOrId = numOrId();
					((AutoContext)_localctx).stepOrFacts.add(((AutoContext)_localctx).numOrId);
					}
					}
					setState(417);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class NumOrIdContext extends ParserRuleContext {
		public Token t;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public NumOrIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numOrId; }
	}

	public final NumOrIdContext numOrId() throws RecognitionException {
		NumOrIdContext _localctx = new NumOrIdContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_numOrId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			((NumOrIdContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==NUM || _la==ID) ) {
				((NumOrIdContext)_localctx).t = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class ProgramContext extends ParserRuleContext {
		public Token tb;
		public Token org;
		public Token sireum;
		public Token te;
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public LgkContext lgk() {
			return getRuleContext(LgkContext.class,0);
		}
		public FactsContext facts() {
			return getRuleContext(FactsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			_la = _input.LA(1);
			if (_la==T__94) {
				{
				setState(422);
				((ProgramContext)_localctx).tb = match(T__94);
				setState(423);
				((ProgramContext)_localctx).org = match(ID);
				setState(424);
				match(T__5);
				setState(425);
				((ProgramContext)_localctx).sireum = match(ID);
				setState(426);
				match(T__5);
				setState(427);
				match(T__95);
				setState(428);
				match(T__5);
				setState(429);
				((ProgramContext)_localctx).te = match(T__96);
				setState(431); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(430);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(433); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(440);
				switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
				case 1:
					{
					setState(435);
					lgk();
					setState(436);
					match(T__97);
					setState(437);
					facts();
					setState(438);
					((ProgramContext)_localctx).te = match(T__97);
					}
					break;
				}
				setState(442);
				stmts();
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

	public static class LgkContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public LgkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lgk; }
	}

	public final LgkContext lgk() throws RecognitionException {
		LgkContext _localctx = new LgkContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_lgk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			_la = _input.LA(1);
			if ( !(_la==T__95 || _la==ID) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class FactsContext extends ParserRuleContext {
		public Token ftb;
		public Token te;
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public List<FactOrFunContext> factOrFun() {
			return getRuleContexts(FactOrFunContext.class);
		}
		public FactOrFunContext factOrFun(int i) {
			return getRuleContext(FactOrFunContext.class,i);
		}
		public FactsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_facts; }
	}

	public final FactsContext facts() throws RecognitionException {
		FactsContext _localctx = new FactsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_facts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			match(T__3);
			setState(451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(448);
				match(NL);
				}
				}
				setState(453);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(454);
			((FactsContext)_localctx).ftb = match(T__98);
			setState(458);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(455);
					match(NL);
					}
					} 
				}
				setState(460);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			}
			setState(462);
			_la = _input.LA(1);
			if (_la==T__99 || _la==ID) {
				{
				setState(461);
				factOrFun();
				}
			}

			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(465); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(464);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(467); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(470);
				_la = _input.LA(1);
				if (_la==T__99 || _la==ID) {
					{
					setState(469);
					factOrFun();
					}
				}

				}
				}
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(477);
			((FactsContext)_localctx).te = match(T__4);
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(478);
				match(NL);
				}
				}
				setState(483);
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

	public static class FactOrFunContext extends ParserRuleContext {
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public FactOrFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factOrFun; }
	}

	public final FactOrFunContext factOrFun() throws RecognitionException {
		FactOrFunContext _localctx = new FactOrFunContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_factOrFun);
		try {
			setState(486);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(484);
				fact();
				}
				break;
			case T__99:
				enterOuterAlt(_localctx, 2);
				{
				setState(485);
				fun();
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

	public static class FactContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public QformulaContext qformula() {
			return getRuleContext(QformulaContext.class,0);
		}
		public FactContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fact; }
	}

	public final FactContext fact() throws RecognitionException {
		FactContext _localctx = new FactContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fact);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			match(ID);
			setState(489);
			match(T__5);
			setState(490);
			qformula();
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

	public static class FunContext extends ParserRuleContext {
		public Token tb;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			((FunContext)_localctx).tb = match(T__99);
			setState(493);
			match(ID);
			setState(495);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(494);
				match(NL);
				}
			}

			setState(497);
			match(T__14);
			setState(498);
			param();
			setState(503);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(499);
				match(T__0);
				setState(500);
				param();
				}
				}
				setState(505);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(506);
			match(T__17);
			setState(507);
			match(T__54);
			setState(508);
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

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			match(ID);
			setState(511);
			match(T__54);
			setState(512);
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

	public static class StmtsContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			_la = _input.LA(1);
			if (((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (T__95 - 96)) | (1L << (T__99 - 96)) | (1L << (T__100 - 96)) | (1L << (T__101 - 96)) | (1L << (T__102 - 96)) | (1L << (T__103 - 96)) | (1L << (T__105 - 96)) | (1L << (T__107 - 96)) | (1L << (T__108 - 96)) | (1L << (ID - 96)))) != 0)) {
				{
				setState(514);
				stmt();
				}
			}

			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(518); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(517);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(520); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(523);
				_la = _input.LA(1);
				if (((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (T__95 - 96)) | (1L << (T__99 - 96)) | (1L << (T__100 - 96)) | (1L << (T__101 - 96)) | (1L << (T__102 - 96)) | (1L << (T__103 - 96)) | (1L << (T__105 - 96)) | (1L << (T__107 - 96)) | (1L << (T__108 - 96)) | (1L << (ID - 96)))) != 0)) {
					{
					setState(522);
					stmt();
					}
				}

				}
				}
				setState(529);
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

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MethodInvocationStmtContext extends StmtContext {
		public Token id;
		public Token m;
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public MethodInvocationStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class SeqAssignStmtContext extends StmtContext {
		public Token tb;
		public ExpContext index;
		public ExpContext r;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public SeqAssignStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssignVarStmtContext extends StmtContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public AssignVarStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class PrintStmtContext extends StmtContext {
		public Token op;
		public Token s;
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public PrintStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class SeqCloneStmtContext extends StmtContext {
		public Token tb;
		public Token s;
		public Token te;
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public SeqCloneStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class MethodDeclStmtContext extends StmtContext {
		public Token rtb;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public LgkContext lgk() {
			return getRuleContext(LgkContext.class,0);
		}
		public MethodContractContext methodContract() {
			return getRuleContext(MethodContractContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public MethodDeclStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class ReadIntStmtContext extends StmtContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public ReadIntStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class IfStmtContext extends StmtContext {
		public StmtsContext ts;
		public StmtsContext fs;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<StmtsContext> stmts() {
			return getRuleContexts(StmtsContext.class);
		}
		public StmtsContext stmts(int i) {
			return getRuleContext(StmtsContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class WhileStmtContext extends StmtContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public LgkContext lgk() {
			return getRuleContext(LgkContext.class,0);
		}
		public LoopInvariantContext loopInvariant() {
			return getRuleContext(LoopInvariantContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class LogikaStmtContext extends StmtContext {
		public LgkContext lgk() {
			return getRuleContext(LgkContext.class,0);
		}
		public ProofContext proof() {
			return getRuleContext(ProofContext.class,0);
		}
		public SequentContext sequent() {
			return getRuleContext(SequentContext.class,0);
		}
		public InvariantsContext invariants() {
			return getRuleContext(InvariantsContext.class,0);
		}
		public LogikaStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class VarDeclStmtContext extends StmtContext {
		public Token modifier;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public VarDeclStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class SeqPendStmtContext extends StmtContext {
		public Token id;
		public Token op;
		public Token seq;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public SeqPendStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssertStmtContext extends StmtContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssertStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_stmt);
		int _la;
		try {
			setState(750);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(530);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__100 || _la==T__101) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(531);
				match(ID);
				setState(532);
				match(T__54);
				setState(533);
				type();
				setState(534);
				match(T__29);
				setState(536);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(535);
					match(NL);
					}
				}

				setState(538);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(540);
				match(ID);
				setState(541);
				match(T__29);
				setState(543);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(542);
					match(NL);
					}
				}

				setState(545);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(546);
				match(T__102);
				setState(547);
				match(T__14);
				setState(548);
				exp(0);
				setState(549);
				match(T__17);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(551);
				match(T__103);
				setState(552);
				match(T__14);
				setState(553);
				exp(0);
				setState(554);
				match(T__17);
				setState(558);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(555);
					match(NL);
					}
					}
					setState(560);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(561);
				match(T__3);
				setState(562);
				((IfStmtContext)_localctx).ts = stmts();
				setState(563);
				match(T__4);
				setState(564);
				match(T__104);
				setState(568);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(565);
					match(NL);
					}
					}
					setState(570);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(571);
				match(T__3);
				setState(572);
				((IfStmtContext)_localctx).fs = stmts();
				setState(573);
				match(T__4);
				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(575);
				match(T__105);
				setState(576);
				match(T__14);
				setState(577);
				exp(0);
				setState(578);
				match(T__17);
				setState(582);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(579);
					match(NL);
					}
					}
					setState(584);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(585);
				match(T__3);
				setState(597);
				switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
				case 1:
					{
					setState(589);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(586);
						match(NL);
						}
						}
						setState(591);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(592);
					lgk();
					setState(593);
					match(T__97);
					setState(594);
					loopInvariant();
					setState(595);
					match(T__97);
					}
					break;
				}
				setState(599);
				stmts();
				setState(600);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new ReadIntStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(602);
				match(ID);
				setState(603);
				match(T__29);
				setState(605);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(604);
					match(NL);
					}
				}

				setState(607);
				match(T__106);
				setState(608);
				match(T__14);
				setState(610);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(609);
					match(STRING);
					}
				}

				setState(612);
				match(T__17);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(613);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__107 || _la==T__108) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(614);
				match(T__14);
				setState(615);
				((PrintStmtContext)_localctx).s = match(ID);
				setState(616);
				match(STRING);
				setState(617);
				match(T__17);
				}
				break;
			case 8:
				_localctx = new MethodInvocationStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(623);
				switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
				case 1:
					{
					setState(618);
					((MethodInvocationStmtContext)_localctx).id = match(ID);
					setState(619);
					match(T__29);
					setState(621);
					_la = _input.LA(1);
					if (_la==NL) {
						{
						setState(620);
						match(NL);
						}
					}

					}
					break;
				}
				setState(625);
				((MethodInvocationStmtContext)_localctx).m = match(ID);
				setState(626);
				match(T__14);
				setState(635);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__22) | (1L << T__34) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || ((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (T__113 - 114)) | (1L << (NUM - 114)) | (1L << (ID - 114)))) != 0)) {
					{
					setState(627);
					exp(0);
					setState(632);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(628);
						match(T__0);
						setState(629);
						exp(0);
						}
						}
						setState(634);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(637);
				match(T__17);
				}
				break;
			case 9:
				_localctx = new SeqCloneStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(638);
				((SeqCloneStmtContext)_localctx).tb = match(ID);
				setState(639);
				match(T__29);
				setState(641);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(640);
					match(NL);
					}
				}

				setState(643);
				((SeqCloneStmtContext)_localctx).s = match(ID);
				setState(644);
				match(T__5);
				setState(645);
				((SeqCloneStmtContext)_localctx).te = match(ID);
				}
				break;
			case 10:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(646);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(647);
				match(T__14);
				setState(648);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(649);
				match(T__17);
				setState(650);
				match(T__29);
				setState(652);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(651);
					match(NL);
					}
				}

				setState(654);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 11:
				_localctx = new SeqPendStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(656);
				((SeqPendStmtContext)_localctx).id = match(ID);
				setState(657);
				match(T__29);
				setState(659);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(658);
					match(NL);
					}
				}

				setState(661);
				exp(0);
				setState(662);
				((SeqPendStmtContext)_localctx).op = match(T__109);
				setState(664);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(663);
					match(NL);
					}
				}

				setState(666);
				((SeqPendStmtContext)_localctx).seq = match(ID);
				}
				break;
			case 12:
				_localctx = new SeqPendStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(668);
				((SeqPendStmtContext)_localctx).id = match(ID);
				setState(669);
				match(T__29);
				setState(671);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(670);
					match(NL);
					}
				}

				setState(673);
				((SeqPendStmtContext)_localctx).seq = match(ID);
				setState(674);
				((SeqPendStmtContext)_localctx).op = match(T__110);
				setState(676);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(675);
					match(NL);
					}
				}

				setState(678);
				exp(0);
				}
				break;
			case 13:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(679);
				match(T__99);
				setState(680);
				match(ID);
				setState(682);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(681);
					match(NL);
					}
				}

				setState(684);
				match(T__14);
				setState(693);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(685);
					param();
					setState(690);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(686);
						match(T__0);
						setState(687);
						param();
						}
						}
						setState(692);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(695);
				match(T__17);
				setState(696);
				match(T__54);
				setState(699);
				switch (_input.LA(1)) {
				case T__56:
				case T__57:
				case T__58:
				case T__59:
				case T__60:
				case T__63:
					{
					setState(697);
					type();
					}
					break;
				case T__111:
					{
					setState(698);
					match(T__111);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(701);
				match(T__29);
				setState(705);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(702);
					match(NL);
					}
					}
					setState(707);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(708);
				match(T__3);
				setState(726);
				switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
				case 1:
					{
					setState(712);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(709);
						match(NL);
						}
						}
						setState(714);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(715);
					lgk();
					setState(716);
					match(T__97);
					setState(717);
					methodContract();
					setState(721);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(718);
						match(NL);
						}
						}
						setState(723);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(724);
					match(T__97);
					}
					break;
				}
				setState(728);
				stmts();
				setState(729);
				((MethodDeclStmtContext)_localctx).rtb = match(T__112);
				setState(731);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__22) | (1L << T__34) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || ((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (T__113 - 114)) | (1L << (NUM - 114)) | (1L << (ID - 114)))) != 0)) {
					{
					setState(730);
					exp(0);
					}
				}

				setState(736);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(733);
					match(NL);
					}
					}
					setState(738);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(739);
				match(T__4);
				}
				break;
			case 14:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(741);
				lgk();
				setState(742);
				match(T__97);
				setState(746);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(743);
					proof();
					}
					break;
				case 2:
					{
					setState(744);
					sequent();
					}
					break;
				case 3:
					{
					setState(745);
					invariants();
					}
					break;
				}
				setState(748);
				match(T__97);
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdExpContext extends ExpContext {
		public Token tb;
		public Token te;
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public IdExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ParenExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanExpContext extends ExpContext {
		public Token t;
		public BooleanExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class BigIntExpContext extends ExpContext {
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public BigIntExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class UnaryExpContext extends ExpContext {
		public Token op;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public UnaryExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class IntExpContext extends ExpContext {
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public IntExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class SeqExpContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SeqExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class BinaryExpContext extends ExpContext {
		public ExpContext l;
		public Token op;
		public ExpContext r;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public BinaryExpContext(ExpContext ctx) { copyFrom(ctx); }
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(787);
			switch (_input.LA(1)) {
			case T__22:
			case T__34:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(753);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__34) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(754);
				exp(7);
				}
				break;
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
				{
				_localctx = new BooleanExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(755);
				((BooleanExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
					((BooleanExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case NUM:
				{
				_localctx = new IntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(756);
				match(NUM);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(757);
				((IdExpContext)_localctx).tb = match(ID);
				setState(764);
				switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
				case 1:
					{
					setState(758);
					match(T__14);
					setState(759);
					exp(0);
					setState(760);
					match(T__17);
					}
					break;
				case 2:
					{
					setState(762);
					match(T__5);
					setState(763);
					((IdExpContext)_localctx).te = match(ID);
					}
					break;
				}
				}
				break;
			case T__58:
			case T__59:
				{
				_localctx = new BigIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(766);
				_la = _input.LA(1);
				if ( !(_la==T__58 || _la==T__59) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(767);
				match(T__14);
				setState(768);
				match(STRING);
				setState(769);
				match(T__17);
				}
				break;
			case T__60:
			case T__113:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(770);
				_la = _input.LA(1);
				if ( !(_la==T__60 || _la==T__113) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(771);
				match(T__14);
				setState(780);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__22) | (1L << T__34) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || ((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (T__113 - 114)) | (1L << (NUM - 114)) | (1L << (ID - 114)))) != 0)) {
					{
					setState(772);
					exp(0);
					setState(777);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(773);
						match(T__0);
						setState(774);
						exp(0);
						}
						}
						setState(779);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(782);
				match(T__17);
				}
				break;
			case T__14:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(783);
				match(T__14);
				setState(784);
				exp(0);
				setState(785);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(827);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(825);
					switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(789);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(790);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(792);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(791);
							match(NL);
							}
						}

						setState(794);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(795);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(796);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(798);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(797);
							match(NL);
							}
						}

						setState(800);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(801);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(802);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__26) | (1L << T__27))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(804);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(803);
							match(NL);
							}
						}

						setState(806);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(807);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(808);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__30 || _la==T__31) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(810);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(809);
							match(NL);
							}
						}

						setState(812);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(813);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(814);
						match(T__38);
						}
						setState(816);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(815);
							match(NL);
							}
						}

						setState(818);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(819);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(820);
						match(T__41);
						}
						setState(822);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(821);
							match(NL);
							}
						}

						setState(824);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(829);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LoopInvariantContext extends ParserRuleContext {
		public Token tb;
		public Token itb;
		public Token te;
		public ModifiesContext modifies() {
			return getRuleContext(ModifiesContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public LoopInvariantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopInvariant; }
	}

	public final LoopInvariantContext loopInvariant() throws RecognitionException {
		LoopInvariantContext _localctx = new LoopInvariantContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_loopInvariant);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(830);
			((LoopInvariantContext)_localctx).tb = match(T__3);
			setState(834);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(831);
				match(NL);
				}
				}
				setState(836);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(837);
			((LoopInvariantContext)_localctx).itb = match(T__114);
			setState(841);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(838);
					match(NL);
					}
					} 
				}
				setState(843);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
			}
			setState(845);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__22) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==NUM || _la==ID) {
				{
				setState(844);
				formula(0);
				}
			}

			setState(857);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(848); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(847);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(850); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(853);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__22) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==NUM || _la==ID) {
					{
					setState(852);
					formula(0);
					}
				}

				}
				}
				setState(859);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(860);
			modifies();
			setState(861);
			((LoopInvariantContext)_localctx).te = match(T__4);
			setState(865);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(862);
				match(NL);
				}
				}
				setState(867);
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

	public static class ModifiesContext extends ParserRuleContext {
		public Token tb;
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public ModifiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifies; }
	}

	public final ModifiesContext modifies() throws RecognitionException {
		ModifiesContext _localctx = new ModifiesContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_modifies);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(868);
			((ModifiesContext)_localctx).tb = match(T__115);
			setState(877);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(869);
				match(ID);
				setState(874);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(870);
					match(T__0);
					setState(871);
					match(ID);
					}
					}
					setState(876);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(882);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(879);
					match(NL);
					}
					} 
				}
				setState(884);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
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

	public static class MethodContractContext extends ParserRuleContext {
		public Token tb;
		public FormulaContext formula;
		public List<FormulaContext> rs = new ArrayList<FormulaContext>();
		public List<FormulaContext> es = new ArrayList<FormulaContext>();
		public Token te;
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public ModifiesContext modifies() {
			return getRuleContext(ModifiesContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public MethodContractContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodContract; }
	}

	public final MethodContractContext methodContract() throws RecognitionException {
		MethodContractContext _localctx = new MethodContractContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_methodContract);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(885);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(889);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(886);
					match(NL);
					}
					} 
				}
				setState(891);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			}
			setState(913);
			_la = _input.LA(1);
			if (_la==T__116) {
				{
				setState(892);
				match(T__116);
				setState(896);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(893);
					match(NL);
					}
					}
					setState(898);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(899);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(910);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(901); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(900);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(903); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(906);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__22) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==NUM || _la==ID) {
							{
							setState(905);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(912);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
				}
				}
			}

			setState(918);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(915);
					match(NL);
					}
					} 
				}
				setState(920);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			}
			setState(922);
			_la = _input.LA(1);
			if (_la==T__115) {
				{
				setState(921);
				modifies();
				}
			}

			setState(945);
			_la = _input.LA(1);
			if (_la==T__117) {
				{
				setState(924);
				match(T__117);
				setState(928);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(925);
					match(NL);
					}
					}
					setState(930);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(931);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(942);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(933); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(932);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(935); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(938);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__22) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==NUM || _la==ID) {
							{
							setState(937);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(944);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
				}
				}
			}

			setState(950);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(947);
				match(NL);
				}
				}
				setState(952);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(953);
			((MethodContractContext)_localctx).te = match(T__4);
			setState(957);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(954);
					match(NL);
					}
					} 
				}
				setState(959);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
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

	public static class InvariantsContext extends ParserRuleContext {
		public Token tb;
		public Token te;
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public InvariantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invariants; }
	}

	public final InvariantsContext invariants() throws RecognitionException {
		InvariantsContext _localctx = new InvariantsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_invariants);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(960);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(964);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(961);
				match(NL);
				}
				}
				setState(966);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(967);
			match(T__114);
			setState(971);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(968);
					match(NL);
					}
					} 
				}
				setState(973);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
			}
			setState(975);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__22) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==NUM || _la==ID) {
				{
				setState(974);
				formula(0);
				}
			}

			setState(987);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(978); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(977);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(980); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(983);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__22) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==NUM || _la==ID) {
					{
					setState(982);
					formula(0);
					}
				}

				}
				}
				setState(989);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(990);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(994);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(991);
				match(NL);
				}
				}
				setState(996);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 9:
			return justification_sempred((JustificationContext)_localctx, predIndex);
		case 20:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean justification_sempred(JustificationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return "∃".equals(_input.LT(1).getText()) &&
		     "i".equals(_input.LT(2).getText());
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
		case 13:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0082\u03e8\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\5\2=\n\2\3\2\7\2@\n\2"+
		"\f\2\16\2C\13\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\7\5P\n\5\f"+
		"\5\16\5S\13\5\5\5U\n\5\3\5\3\5\3\5\3\5\7\5[\n\5\f\5\16\5^\13\5\3\5\7\5"+
		"a\n\5\f\5\16\5d\13\5\3\5\3\5\6\5h\n\5\r\5\16\5i\5\5l\n\5\3\6\3\6\5\6p"+
		"\n\6\3\6\6\6s\n\6\r\6\16\6t\3\6\5\6x\n\6\7\6z\n\6\f\6\16\6}\13\6\3\6\3"+
		"\6\7\6\u0081\n\6\f\6\16\6\u0084\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7"+
		"\7\u008e\n\7\f\7\16\7\u0091\13\7\3\7\3\7\7\7\u0095\n\7\f\7\16\7\u0098"+
		"\13\7\3\7\3\7\3\7\3\7\5\7\u009e\n\7\3\7\3\7\3\7\5\7\u00a3\n\7\3\7\6\7"+
		"\u00a6\n\7\r\7\16\7\u00a7\3\7\7\7\u00ab\n\7\f\7\16\7\u00ae\13\7\3\7\5"+
		"\7\u00b1\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00bc\n\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00c8\n\b\f\b\16\b\u00cb\13\b\3\b"+
		"\3\b\3\b\3\b\5\b\u00d1\n\b\3\b\3\b\3\b\5\b\u00d6\n\b\3\b\3\b\3\b\3\b\5"+
		"\b\u00dc\n\b\3\b\3\b\3\b\3\b\5\b\u00e2\n\b\3\b\3\b\3\b\3\b\5\b\u00e8\n"+
		"\b\3\b\3\b\3\b\3\b\5\b\u00ee\n\b\3\b\3\b\3\b\3\b\5\b\u00f4\n\b\3\b\3\b"+
		"\3\b\3\b\5\b\u00fa\n\b\3\b\7\b\u00fd\n\b\f\b\16\b\u0100\13\b\3\t\3\t\3"+
		"\t\3\t\7\t\u0106\n\t\f\t\16\t\u0109\13\t\3\t\3\t\5\t\u010d\n\t\3\t\3\t"+
		"\5\t\u0111\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\n\u011a\n\n\f\n\16\n\u011d"+
		"\13\n\3\n\3\n\7\n\u0121\n\n\f\n\16\n\u0124\13\n\3\n\3\n\5\n\u0128\n\n"+
		"\3\13\3\13\3\13\3\13\5\13\u012e\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0135"+
		"\n\13\3\13\3\13\3\13\3\13\5\13\u013b\n\13\3\13\3\13\3\13\3\13\5\13\u0141"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0149\n\13\3\13\3\13\3\13\3\13"+
		"\5\13\u014f\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0156\n\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u015d\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0164\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u016e\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u0176\n\13\3\13\3\13\6\13\u017a\n\13\r\13\16\13\u017b"+
		"\3\13\3\13\3\13\6\13\u0181\n\13\r\13\16\13\u0182\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\6\13\u018e\n\13\r\13\16\13\u018f\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u0199\n\13\f\13\16\13\u019c\13\13\3\13\3\13"+
		"\7\13\u01a0\n\13\f\13\16\13\u01a3\13\13\5\13\u01a5\n\13\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u01b2\n\r\r\r\16\r\u01b3\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u01bb\n\r\3\r\5\r\u01be\n\r\3\16\3\16\3\17\3\17\7\17\u01c4"+
		"\n\17\f\17\16\17\u01c7\13\17\3\17\3\17\7\17\u01cb\n\17\f\17\16\17\u01ce"+
		"\13\17\3\17\5\17\u01d1\n\17\3\17\6\17\u01d4\n\17\r\17\16\17\u01d5\3\17"+
		"\5\17\u01d9\n\17\7\17\u01db\n\17\f\17\16\17\u01de\13\17\3\17\3\17\7\17"+
		"\u01e2\n\17\f\17\16\17\u01e5\13\17\3\20\3\20\5\20\u01e9\n\20\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\5\22\u01f2\n\22\3\22\3\22\3\22\3\22\7\22\u01f8"+
		"\n\22\f\22\16\22\u01fb\13\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\24\5\24\u0206\n\24\3\24\6\24\u0209\n\24\r\24\16\24\u020a\3\24\5\24\u020e"+
		"\n\24\7\24\u0210\n\24\f\24\16\24\u0213\13\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u021b\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u0222\n\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u022f\n\25\f\25"+
		"\16\25\u0232\13\25\3\25\3\25\3\25\3\25\3\25\7\25\u0239\n\25\f\25\16\25"+
		"\u023c\13\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0247\n"+
		"\25\f\25\16\25\u024a\13\25\3\25\3\25\7\25\u024e\n\25\f\25\16\25\u0251"+
		"\13\25\3\25\3\25\3\25\3\25\3\25\5\25\u0258\n\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\5\25\u0260\n\25\3\25\3\25\3\25\5\25\u0265\n\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0270\n\25\5\25\u0272\n\25\3\25\3"+
		"\25\3\25\3\25\3\25\7\25\u0279\n\25\f\25\16\25\u027c\13\25\5\25\u027e\n"+
		"\25\3\25\3\25\3\25\3\25\5\25\u0284\n\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u028f\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u0296\n"+
		"\25\3\25\3\25\3\25\5\25\u029b\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u02a2"+
		"\n\25\3\25\3\25\3\25\5\25\u02a7\n\25\3\25\3\25\3\25\3\25\5\25\u02ad\n"+
		"\25\3\25\3\25\3\25\3\25\7\25\u02b3\n\25\f\25\16\25\u02b6\13\25\5\25\u02b8"+
		"\n\25\3\25\3\25\3\25\3\25\5\25\u02be\n\25\3\25\3\25\7\25\u02c2\n\25\f"+
		"\25\16\25\u02c5\13\25\3\25\3\25\7\25\u02c9\n\25\f\25\16\25\u02cc\13\25"+
		"\3\25\3\25\3\25\3\25\7\25\u02d2\n\25\f\25\16\25\u02d5\13\25\3\25\3\25"+
		"\5\25\u02d9\n\25\3\25\3\25\3\25\5\25\u02de\n\25\3\25\7\25\u02e1\n\25\f"+
		"\25\16\25\u02e4\13\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u02ed\n"+
		"\25\3\25\3\25\5\25\u02f1\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u02ff\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\7\26\u030a\n\26\f\26\16\26\u030d\13\26\5\26\u030f\n\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u0316\n\26\3\26\3\26\3\26\5\26\u031b\n\26\3"+
		"\26\3\26\3\26\3\26\5\26\u0321\n\26\3\26\3\26\3\26\3\26\5\26\u0327\n\26"+
		"\3\26\3\26\3\26\3\26\5\26\u032d\n\26\3\26\3\26\3\26\3\26\5\26\u0333\n"+
		"\26\3\26\3\26\3\26\3\26\5\26\u0339\n\26\3\26\7\26\u033c\n\26\f\26\16\26"+
		"\u033f\13\26\3\27\3\27\7\27\u0343\n\27\f\27\16\27\u0346\13\27\3\27\3\27"+
		"\7\27\u034a\n\27\f\27\16\27\u034d\13\27\3\27\5\27\u0350\n\27\3\27\6\27"+
		"\u0353\n\27\r\27\16\27\u0354\3\27\5\27\u0358\n\27\7\27\u035a\n\27\f\27"+
		"\16\27\u035d\13\27\3\27\3\27\3\27\7\27\u0362\n\27\f\27\16\27\u0365\13"+
		"\27\3\30\3\30\3\30\3\30\7\30\u036b\n\30\f\30\16\30\u036e\13\30\5\30\u0370"+
		"\n\30\3\30\7\30\u0373\n\30\f\30\16\30\u0376\13\30\3\31\3\31\7\31\u037a"+
		"\n\31\f\31\16\31\u037d\13\31\3\31\3\31\7\31\u0381\n\31\f\31\16\31\u0384"+
		"\13\31\3\31\3\31\6\31\u0388\n\31\r\31\16\31\u0389\3\31\5\31\u038d\n\31"+
		"\7\31\u038f\n\31\f\31\16\31\u0392\13\31\5\31\u0394\n\31\3\31\7\31\u0397"+
		"\n\31\f\31\16\31\u039a\13\31\3\31\5\31\u039d\n\31\3\31\3\31\7\31\u03a1"+
		"\n\31\f\31\16\31\u03a4\13\31\3\31\3\31\6\31\u03a8\n\31\r\31\16\31\u03a9"+
		"\3\31\5\31\u03ad\n\31\7\31\u03af\n\31\f\31\16\31\u03b2\13\31\5\31\u03b4"+
		"\n\31\3\31\7\31\u03b7\n\31\f\31\16\31\u03ba\13\31\3\31\3\31\7\31\u03be"+
		"\n\31\f\31\16\31\u03c1\13\31\3\32\3\32\7\32\u03c5\n\32\f\32\16\32\u03c8"+
		"\13\32\3\32\3\32\7\32\u03cc\n\32\f\32\16\32\u03cf\13\32\3\32\5\32\u03d2"+
		"\n\32\3\32\6\32\u03d5\n\32\r\32\16\32\u03d6\3\32\5\32\u03da\n\32\7\32"+
		"\u03dc\n\32\f\32\16\32\u03df\13\32\3\32\3\32\7\32\u03e3\n\32\f\32\16\32"+
		"\u03e6\13\32\3\32\2\4\16*\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\60\62\2\"\3\2\4\5\3\2$\'\3\2\n\20\3\2\25\27\3\2\30\31\3\2\32\37"+
		"\3\2 #\3\2(*\3\2+-\3\2.\60\3\2\618\3\2;<\3\2=>\3\2)*\3\2EF\3\2GH\3\2,"+
		"-\3\2/\60\3\2LM\3\2%\'\3\2PQ\3\2\17\20\3\2Y[\3\2\\^\3\2z{\4\2bb{{\3\2"+
		"gh\3\2no\4\2\31\31%%\4\2??tt\4\2\32\33\35\36\3\2!\"\u049d\2\64\3\2\2\2"+
		"\4F\3\2\2\2\6I\3\2\2\2\bk\3\2\2\2\nm\3\2\2\2\f\u00b0\3\2\2\2\16\u00d0"+
		"\3\2\2\2\20\u0101\3\2\2\2\22\u0127\3\2\2\2\24\u01a4\3\2\2\2\26\u01a6\3"+
		"\2\2\2\30\u01bd\3\2\2\2\32\u01bf\3\2\2\2\34\u01c1\3\2\2\2\36\u01e8\3\2"+
		"\2\2 \u01ea\3\2\2\2\"\u01ee\3\2\2\2$\u0200\3\2\2\2&\u0205\3\2\2\2(\u02f0"+
		"\3\2\2\2*\u0315\3\2\2\2,\u0340\3\2\2\2.\u0366\3\2\2\2\60\u0377\3\2\2\2"+
		"\62\u03c2\3\2\2\2\648\5\b\5\2\65\67\7~\2\2\66\65\3\2\2\2\67:\3\2\2\28"+
		"\66\3\2\2\289\3\2\2\29<\3\2\2\2:8\3\2\2\2;=\5\n\6\2<;\3\2\2\2<=\3\2\2"+
		"\2=A\3\2\2\2>@\7~\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2"+
		"\2CA\3\2\2\2DE\7\2\2\3E\3\3\2\2\2FG\5\n\6\2GH\7\2\2\3H\5\3\2\2\2IJ\5\30"+
		"\r\2JK\7\2\2\3K\7\3\2\2\2LQ\5\16\b\2MN\7\3\2\2NP\5\16\b\2OM\3\2\2\2PS"+
		"\3\2\2\2QO\3\2\2\2QR\3\2\2\2RU\3\2\2\2SQ\3\2\2\2TL\3\2\2\2TU\3\2\2\2U"+
		"V\3\2\2\2VW\t\2\2\2W\\\5\16\b\2XY\7\3\2\2Y[\5\16\b\2ZX\3\2\2\2[^\3\2\2"+
		"\2\\Z\3\2\2\2\\]\3\2\2\2]l\3\2\2\2^\\\3\2\2\2_a\5\16\b\2`_\3\2\2\2ad\3"+
		"\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2eg\7y\2\2fh\5\16\b\2gf\3"+
		"\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2kT\3\2\2\2kb\3\2\2\2l\t"+
		"\3\2\2\2mo\7\6\2\2np\5\f\7\2on\3\2\2\2op\3\2\2\2p{\3\2\2\2qs\7~\2\2rq"+
		"\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vx\5\f\7\2wv\3\2\2\2w"+
		"x\3\2\2\2xz\3\2\2\2yr\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2"+
		"}{\3\2\2\2~\u0082\7\7\2\2\177\u0081\7~\2\2\u0080\177\3\2\2\2\u0081\u0084"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\13\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0085\u0086\7z\2\2\u0086\u0087\7\b\2\2\u0087\u0088\5\16"+
		"\b\2\u0088\u0089\5\24\13\2\u0089\u00b1\3\2\2\2\u008a\u008b\7z\2\2\u008b"+
		"\u008f\7\b\2\2\u008c\u008e\7~\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0096\7\6\2\2\u0093\u0095\7~\2\2\u0094\u0093\3\2"+
		"\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\7z\2\2\u009a\u00a2\7\b"+
		"\2\2\u009b\u00a3\7{\2\2\u009c\u009e\7{\2\2\u009d\u009c\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\5\16\b\2\u00a0\u00a1\7\t\2\2"+
		"\u00a1\u00a3\3\2\2\2\u00a2\u009b\3\2\2\2\u00a2\u009d\3\2\2\2\u00a3\u00ac"+
		"\3\2\2\2\u00a4\u00a6\7~\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\5\f"+
		"\7\2\u00aa\u00a5\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\7\7"+
		"\2\2\u00b0\u0085\3\2\2\2\u00b0\u008a\3\2\2\2\u00b1\r\3\2\2\2\u00b2\u00b3"+
		"\b\b\1\2\u00b3\u00b4\7\31\2\2\u00b4\u00d1\5\16\b\b\u00b5\u00b6\t\3\2\2"+
		"\u00b6\u00d1\5\16\b\7\u00b7\u00d1\t\4\2\2\u00b8\u00bb\7{\2\2\u00b9\u00ba"+
		"\7\b\2\2\u00ba\u00bc\7{\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00d1\3\2\2\2\u00bd\u00be\7\21\2\2\u00be\u00bf\5\16\b\2\u00bf\u00c0\7"+
		"\22\2\2\u00c0\u00d1\3\2\2\2\u00c1\u00d1\7\23\2\2\u00c2\u00c3\7{\2\2\u00c3"+
		"\u00c4\7\21\2\2\u00c4\u00c9\5\16\b\2\u00c5\u00c6\7\3\2\2\u00c6\u00c8\5"+
		"\16\b\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7\24"+
		"\2\2\u00cd\u00d1\3\2\2\2\u00ce\u00d1\7z\2\2\u00cf\u00d1\5\20\t\2\u00d0"+
		"\u00b2\3\2\2\2\u00d0\u00b5\3\2\2\2\u00d0\u00b7\3\2\2\2\u00d0\u00b8\3\2"+
		"\2\2\u00d0\u00bd\3\2\2\2\u00d0\u00c1\3\2\2\2\u00d0\u00c2\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00fe\3\2\2\2\u00d2\u00d3\f\f"+
		"\2\2\u00d3\u00d5\t\5\2\2\u00d4\u00d6\7~\2\2\u00d5\u00d4\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00fd\5\16\b\r\u00d8\u00d9\f"+
		"\13\2\2\u00d9\u00db\t\6\2\2\u00da\u00dc\7~\2\2\u00db\u00da\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00fd\5\16\b\f\u00de\u00df\f"+
		"\n\2\2\u00df\u00e1\t\7\2\2\u00e0\u00e2\7~\2\2\u00e1\u00e0\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00fd\5\16\b\13\u00e4\u00e5\f"+
		"\t\2\2\u00e5\u00e7\t\b\2\2\u00e6\u00e8\7~\2\2\u00e7\u00e6\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00fd\5\16\b\n\u00ea\u00eb\f"+
		"\6\2\2\u00eb\u00ed\t\t\2\2\u00ec\u00ee\7~\2\2\u00ed\u00ec\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00fd\5\16\b\7\u00f0\u00f1\f"+
		"\5\2\2\u00f1\u00f3\t\n\2\2\u00f2\u00f4\7~\2\2\u00f3\u00f2\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00fd\5\16\b\6\u00f6\u00f7\f"+
		"\4\2\2\u00f7\u00f9\t\13\2\2\u00f8\u00fa\7~\2\2\u00f9\u00f8\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\5\16\b\5\u00fc\u00d2\3"+
		"\2\2\2\u00fc\u00d8\3\2\2\2\u00fc\u00de\3\2\2\2\u00fc\u00e4\3\2\2\2\u00fc"+
		"\u00ea\3\2\2\2\u00fc\u00f0\3\2\2\2\u00fc\u00f6\3\2\2\2\u00fd\u0100\3\2"+
		"\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\17\3\2\2\2\u0100\u00fe"+
		"\3\2\2\2\u0101\u0102\t\f\2\2\u0102\u0107\7{\2\2\u0103\u0104\7\3\2\2\u0104"+
		"\u0106\7{\2\2\u0105\u0103\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2"+
		"\2\2\u0107\u0108\3\2\2\2\u0108\u010c\3\2\2\2\u0109\u0107\3\2\2\2\u010a"+
		"\u010b\79\2\2\u010b\u010d\5\22\n\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2"+
		"\2\2\u010d\u010e\3\2\2\2\u010e\u0110\7:\2\2\u010f\u0111\7~\2\2\u0110\u010f"+
		"\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\5\16\b\2"+
		"\u0113\21\3\2\2\2\u0114\u0128\t\r\2\2\u0115\u0128\t\16\2\2\u0116\u0117"+
		"\7?\2\2\u0117\u011b\7@\2\2\u0118\u011a\7~\2\2\u0119\u0118\3\2\2\2\u011a"+
		"\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011e\3\2"+
		"\2\2\u011d\u011b\3\2\2\2\u011e\u0122\t\16\2\2\u011f\u0121\7~\2\2\u0120"+
		"\u011f\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123\u0125\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0128\7A\2\2\u0126"+
		"\u0128\7B\2\2\u0127\u0114\3\2\2\2\u0127\u0115\3\2\2\2\u0127\u0116\3\2"+
		"\2\2\u0127\u0126\3\2\2\2\u0128\23\3\2\2\2\u0129\u01a5\7C\2\2\u012a\u012e"+
		"\7D\2\2\u012b\u012c\t\17\2\2\u012c\u012e\7{\2\2\u012d\u012a\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\7z\2\2\u0130\u01a5\7z\2"+
		"\2\u0131\u0135\t\20\2\2\u0132\u0133\t\17\2\2\u0133\u0135\7{\2\2\u0134"+
		"\u0131\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u01a5\7z"+
		"\2\2\u0137\u013b\t\21\2\2\u0138\u0139\t\22\2\2\u0139\u013b\7{\2\2\u013a"+
		"\u0137\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u01a5\7z"+
		"\2\2\u013d\u0141\7I\2\2\u013e\u013f\t\22\2\2\u013f\u0141\7{\2\2\u0140"+
		"\u013d\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\7z"+
		"\2\2\u0143\u0144\7z\2\2\u0144\u01a5\7z\2\2\u0145\u0149\7J\2\2\u0146\u0147"+
		"\t\23\2\2\u0147\u0149\7{\2\2\u0148\u0145\3\2\2\2\u0148\u0146\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\u01a5\7z\2\2\u014b\u014f\7K\2\2\u014c\u014d\t\23"+
		"\2\2\u014d\u014f\7{\2\2\u014e\u014b\3\2\2\2\u014e\u014c\3\2\2\2\u014f"+
		"\u0150\3\2\2\2\u0150\u0151\7z\2\2\u0151\u01a5\7z\2\2\u0152\u0156\t\24"+
		"\2\2\u0153\u0154\t\25\2\2\u0154\u0156\7{\2\2\u0155\u0152\3\2\2\2\u0155"+
		"\u0153\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u01a5\7z\2\2\u0158\u015d\7N\2"+
		"\2\u0159\u015d\7O\2\2\u015a\u015b\t\25\2\2\u015b\u015d\7{\2\2\u015c\u0158"+
		"\3\2\2\2\u015c\u0159\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"\u015f\7z\2\2\u015f\u01a5\7z\2\2\u0160\u0164\t\26\2\2\u0161\u0162\t\27"+
		"\2\2\u0162\u0164\7{\2\2\u0163\u0160\3\2\2\2\u0163\u0161\3\2\2\2\u0164"+
		"\u0165\3\2\2\2\u0165\u01a5\7z\2\2\u0166\u0167\7R\2\2\u0167\u01a5\7z\2"+
		"\2\u0168\u016e\7S\2\2\u0169\u016e\7T\2\2\u016a\u016e\7U\2\2\u016b\u016c"+
		"\7\64\2\2\u016c\u016e\7{\2\2\u016d\u0168\3\2\2\2\u016d\u0169\3\2\2\2\u016d"+
		"\u016a\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u01a5\7z"+
		"\2\2\u0170\u0176\7V\2\2\u0171\u0176\7W\2\2\u0172\u0176\7X\2\2\u0173\u0174"+
		"\7\64\2\2\u0174\u0176\7{\2\2\u0175\u0170\3\2\2\2\u0175\u0171\3\2\2\2\u0175"+
		"\u0172\3\2\2\2\u0175\u0173\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0179\5\26"+
		"\f\2\u0178\u017a\5\16\b\2\u0179\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b"+
		"\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u01a5\3\2\2\2\u017d\u017e\t\30"+
		"\2\2\u017e\u0180\7z\2\2\u017f\u0181\5\16\b\2\u0180\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u01a5\3\2"+
		"\2\2\u0184\u0185\t\31\2\2\u0185\u0186\5\26\f\2\u0186\u0187\7z\2\2\u0187"+
		"\u01a5\3\2\2\2\u0188\u0189\6\13\t\2\u0189\u018a\78\2\2\u018a\u018b\7{"+
		"\2\2\u018b\u018d\7z\2\2\u018c\u018e\5\16\b\2\u018d\u018c\3\2\2\2\u018e"+
		"\u018f\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u01a5\3\2"+
		"\2\2\u0191\u0192\78\2\2\u0192\u0193\7{\2\2\u0193\u0194\5\26\f\2\u0194"+
		"\u0195\7z\2\2\u0195\u01a5\3\2\2\2\u0196\u019a\7_\2\2\u0197\u0199\7z\2"+
		"\2\u0198\u0197\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b"+
		"\3\2\2\2\u019b\u01a5\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u01a1\7`\2\2\u019e"+
		"\u01a0\5\26\f\2\u019f\u019e\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3"+
		"\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4"+
		"\u0129\3\2\2\2\u01a4\u012d\3\2\2\2\u01a4\u0134\3\2\2\2\u01a4\u013a\3\2"+
		"\2\2\u01a4\u0140\3\2\2\2\u01a4\u0148\3\2\2\2\u01a4\u014e\3\2\2\2\u01a4"+
		"\u0155\3\2\2\2\u01a4\u015c\3\2\2\2\u01a4\u0163\3\2\2\2\u01a4\u0166\3\2"+
		"\2\2\u01a4\u016d\3\2\2\2\u01a4\u0175\3\2\2\2\u01a4\u017d\3\2\2\2\u01a4"+
		"\u0184\3\2\2\2\u01a4\u0188\3\2\2\2\u01a4\u0191\3\2\2\2\u01a4\u0196\3\2"+
		"\2\2\u01a4\u019d\3\2\2\2\u01a5\25\3\2\2\2\u01a6\u01a7\t\32\2\2\u01a7\27"+
		"\3\2\2\2\u01a8\u01a9\7a\2\2\u01a9\u01aa\7{\2\2\u01aa\u01ab\7\b\2\2\u01ab"+
		"\u01ac\7{\2\2\u01ac\u01ad\7\b\2\2\u01ad\u01ae\7b\2\2\u01ae\u01af\7\b\2"+
		"\2\u01af\u01b1\7c\2\2\u01b0\u01b2\7~\2\2\u01b1\u01b0\3\2\2\2\u01b2\u01b3"+
		"\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01ba\3\2\2\2\u01b5"+
		"\u01b6\5\32\16\2\u01b6\u01b7\7d\2\2\u01b7\u01b8\5\34\17\2\u01b8\u01b9"+
		"\7d\2\2\u01b9\u01bb\3\2\2\2\u01ba\u01b5\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb"+
		"\u01bc\3\2\2\2\u01bc\u01be\5&\24\2\u01bd\u01a8\3\2\2\2\u01bd\u01be\3\2"+
		"\2\2\u01be\31\3\2\2\2\u01bf\u01c0\t\33\2\2\u01c0\33\3\2\2\2\u01c1\u01c5"+
		"\7\6\2\2\u01c2\u01c4\7~\2\2\u01c3\u01c2\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5"+
		"\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c8\3\2\2\2\u01c7\u01c5\3\2"+
		"\2\2\u01c8\u01cc\7e\2\2\u01c9\u01cb\7~\2\2\u01ca\u01c9\3\2\2\2\u01cb\u01ce"+
		"\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce"+
		"\u01cc\3\2\2\2\u01cf\u01d1\5\36\20\2\u01d0\u01cf\3\2\2\2\u01d0\u01d1\3"+
		"\2\2\2\u01d1\u01dc\3\2\2\2\u01d2\u01d4\7~\2\2\u01d3\u01d2\3\2\2\2\u01d4"+
		"\u01d5\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d8\3\2"+
		"\2\2\u01d7\u01d9\5\36\20\2\u01d8\u01d7\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01db\3\2\2\2\u01da\u01d3\3\2\2\2\u01db\u01de\3\2\2\2\u01dc\u01da\3\2"+
		"\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01df\3\2\2\2\u01de\u01dc\3\2\2\2\u01df"+
		"\u01e3\7\7\2\2\u01e0\u01e2\7~\2\2\u01e1\u01e0\3\2\2\2\u01e2\u01e5\3\2"+
		"\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\35\3\2\2\2\u01e5\u01e3"+
		"\3\2\2\2\u01e6\u01e9\5 \21\2\u01e7\u01e9\5\"\22\2\u01e8\u01e6\3\2\2\2"+
		"\u01e8\u01e7\3\2\2\2\u01e9\37\3\2\2\2\u01ea\u01eb\7{\2\2\u01eb\u01ec\7"+
		"\b\2\2\u01ec\u01ed\5\20\t\2\u01ed!\3\2\2\2\u01ee\u01ef\7f\2\2\u01ef\u01f1"+
		"\7{\2\2\u01f0\u01f2\7~\2\2\u01f1\u01f0\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2"+
		"\u01f3\3\2\2\2\u01f3\u01f4\7\21\2\2\u01f4\u01f9\5$\23\2\u01f5\u01f6\7"+
		"\3\2\2\u01f6\u01f8\5$\23\2\u01f7\u01f5\3\2\2\2\u01f8\u01fb\3\2\2\2\u01f9"+
		"\u01f7\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fc\3\2\2\2\u01fb\u01f9\3\2"+
		"\2\2\u01fc\u01fd\7\24\2\2\u01fd\u01fe\79\2\2\u01fe\u01ff\5\22\n\2\u01ff"+
		"#\3\2\2\2\u0200\u0201\7{\2\2\u0201\u0202\79\2\2\u0202\u0203\5\22\n\2\u0203"+
		"%\3\2\2\2\u0204\u0206\5(\25\2\u0205\u0204\3\2\2\2\u0205\u0206\3\2\2\2"+
		"\u0206\u0211\3\2\2\2\u0207\u0209\7~\2\2\u0208\u0207\3\2\2\2\u0209\u020a"+
		"\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020d\3\2\2\2\u020c"+
		"\u020e\5(\25\2\u020d\u020c\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u0210\3\2"+
		"\2\2\u020f\u0208\3\2\2\2\u0210\u0213\3\2\2\2\u0211\u020f\3\2\2\2\u0211"+
		"\u0212\3\2\2\2\u0212\'\3\2\2\2\u0213\u0211\3\2\2\2\u0214\u0215\t\34\2"+
		"\2\u0215\u0216\7{\2\2\u0216\u0217\79\2\2\u0217\u0218\5\22\n\2\u0218\u021a"+
		"\7 \2\2\u0219\u021b\7~\2\2\u021a\u0219\3\2\2\2\u021a\u021b\3\2\2\2\u021b"+
		"\u021c\3\2\2\2\u021c\u021d\5*\26\2\u021d\u02f1\3\2\2\2\u021e\u021f\7{"+
		"\2\2\u021f\u0221\7 \2\2\u0220\u0222\7~\2\2\u0221\u0220\3\2\2\2\u0221\u0222"+
		"\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u02f1\5*\26\2\u0224\u0225\7i\2\2\u0225"+
		"\u0226\7\21\2\2\u0226\u0227\5*\26\2\u0227\u0228\7\24\2\2\u0228\u02f1\3"+
		"\2\2\2\u0229\u022a\7j\2\2\u022a\u022b\7\21\2\2\u022b\u022c\5*\26\2\u022c"+
		"\u0230\7\24\2\2\u022d\u022f\7~\2\2\u022e\u022d\3\2\2\2\u022f\u0232\3\2"+
		"\2\2\u0230\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0233\3\2\2\2\u0232"+
		"\u0230\3\2\2\2\u0233\u0234\7\6\2\2\u0234\u0235\5&\24\2\u0235\u0236\7\7"+
		"\2\2\u0236\u023a\7k\2\2\u0237\u0239\7~\2\2\u0238\u0237\3\2\2\2\u0239\u023c"+
		"\3\2\2\2\u023a\u0238\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023d\3\2\2\2\u023c"+
		"\u023a\3\2\2\2\u023d\u023e\7\6\2\2\u023e\u023f\5&\24\2\u023f\u0240\7\7"+
		"\2\2\u0240\u02f1\3\2\2\2\u0241\u0242\7l\2\2\u0242\u0243\7\21\2\2\u0243"+
		"\u0244\5*\26\2\u0244\u0248\7\24\2\2\u0245\u0247\7~\2\2\u0246\u0245\3\2"+
		"\2\2\u0247\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249"+
		"\u024b\3\2\2\2\u024a\u0248\3\2\2\2\u024b\u0257\7\6\2\2\u024c\u024e\7~"+
		"\2\2\u024d\u024c\3\2\2\2\u024e\u0251\3\2\2\2\u024f\u024d\3\2\2\2\u024f"+
		"\u0250\3\2\2\2\u0250\u0252\3\2\2\2\u0251\u024f\3\2\2\2\u0252\u0253\5\32"+
		"\16\2\u0253\u0254\7d\2\2\u0254\u0255\5,\27\2\u0255\u0256\7d\2\2\u0256"+
		"\u0258\3\2\2\2\u0257\u024f\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u0259\3\2"+
		"\2\2\u0259\u025a\5&\24\2\u025a\u025b\7\7\2\2\u025b\u02f1\3\2\2\2\u025c"+
		"\u025d\7{\2\2\u025d\u025f\7 \2\2\u025e\u0260\7~\2\2\u025f\u025e\3\2\2"+
		"\2\u025f\u0260\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0262\7m\2\2\u0262\u0264"+
		"\7\21\2\2\u0263\u0265\7|\2\2\u0264\u0263\3\2\2\2\u0264\u0265\3\2\2\2\u0265"+
		"\u0266\3\2\2\2\u0266\u02f1\7\24\2\2\u0267\u0268\t\35\2\2\u0268\u0269\7"+
		"\21\2\2\u0269\u026a\7{\2\2\u026a\u026b\7|\2\2\u026b\u02f1\7\24\2\2\u026c"+
		"\u026d\7{\2\2\u026d\u026f\7 \2\2\u026e\u0270\7~\2\2\u026f\u026e\3\2\2"+
		"\2\u026f\u0270\3\2\2\2\u0270\u0272\3\2\2\2\u0271\u026c\3\2\2\2\u0271\u0272"+
		"\3\2\2\2\u0272\u0273\3\2\2\2\u0273\u0274\7{\2\2\u0274\u027d\7\21\2\2\u0275"+
		"\u027a\5*\26\2\u0276\u0277\7\3\2\2\u0277\u0279\5*\26\2\u0278\u0276\3\2"+
		"\2\2\u0279\u027c\3\2\2\2\u027a\u0278\3\2\2\2\u027a\u027b\3\2\2\2\u027b"+
		"\u027e\3\2\2\2\u027c\u027a\3\2\2\2\u027d\u0275\3\2\2\2\u027d\u027e\3\2"+
		"\2\2\u027e\u027f\3\2\2\2\u027f\u02f1\7\24\2\2\u0280\u0281\7{\2\2\u0281"+
		"\u0283\7 \2\2\u0282\u0284\7~\2\2\u0283\u0282\3\2\2\2\u0283\u0284\3\2\2"+
		"\2\u0284\u0285\3\2\2\2\u0285\u0286\7{\2\2\u0286\u0287\7\b\2\2\u0287\u02f1"+
		"\7{\2\2\u0288\u0289\7{\2\2\u0289\u028a\7\21\2\2\u028a\u028b\5*\26\2\u028b"+
		"\u028c\7\24\2\2\u028c\u028e\7 \2\2\u028d\u028f\7~\2\2\u028e\u028d\3\2"+
		"\2\2\u028e\u028f\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0291\5*\26\2\u0291"+
		"\u02f1\3\2\2\2\u0292\u0293\7{\2\2\u0293\u0295\7 \2\2\u0294\u0296\7~\2"+
		"\2\u0295\u0294\3\2\2\2\u0295\u0296\3\2\2\2\u0296\u0297\3\2\2\2\u0297\u0298"+
		"\5*\26\2\u0298\u029a\7p\2\2\u0299\u029b\7~\2\2\u029a\u0299\3\2\2\2\u029a"+
		"\u029b\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029d\7{\2\2\u029d\u02f1\3\2"+
		"\2\2\u029e\u029f\7{\2\2\u029f\u02a1\7 \2\2\u02a0\u02a2\7~\2\2\u02a1\u02a0"+
		"\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3\u02a4\7{\2\2\u02a4"+
		"\u02a6\7q\2\2\u02a5\u02a7\7~\2\2\u02a6\u02a5\3\2\2\2\u02a6\u02a7\3\2\2"+
		"\2\u02a7\u02a8\3\2\2\2\u02a8\u02f1\5*\26\2\u02a9\u02aa\7f\2\2\u02aa\u02ac"+
		"\7{\2\2\u02ab\u02ad\7~\2\2\u02ac\u02ab\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad"+
		"\u02ae\3\2\2\2\u02ae\u02b7\7\21\2\2\u02af\u02b4\5$\23\2\u02b0\u02b1\7"+
		"\3\2\2\u02b1\u02b3\5$\23\2\u02b2\u02b0\3\2\2\2\u02b3\u02b6\3\2\2\2\u02b4"+
		"\u02b2\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02b8\3\2\2\2\u02b6\u02b4\3\2"+
		"\2\2\u02b7\u02af\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9"+
		"\u02ba\7\24\2\2\u02ba\u02bd\79\2\2\u02bb\u02be\5\22\n\2\u02bc\u02be\7"+
		"r\2\2\u02bd\u02bb\3\2\2\2\u02bd\u02bc\3\2\2\2\u02be\u02bf\3\2\2\2\u02bf"+
		"\u02c3\7 \2\2\u02c0\u02c2\7~\2\2\u02c1\u02c0\3\2\2\2\u02c2\u02c5\3\2\2"+
		"\2\u02c3\u02c1\3\2\2\2\u02c3\u02c4\3\2\2\2\u02c4\u02c6\3\2\2\2\u02c5\u02c3"+
		"\3\2\2\2\u02c6\u02d8\7\6\2\2\u02c7\u02c9\7~\2\2\u02c8\u02c7\3\2\2\2\u02c9"+
		"\u02cc\3\2\2\2\u02ca\u02c8\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02cd\3\2"+
		"\2\2\u02cc\u02ca\3\2\2\2\u02cd\u02ce\5\32\16\2\u02ce\u02cf\7d\2\2\u02cf"+
		"\u02d3\5\60\31\2\u02d0\u02d2\7~\2\2\u02d1\u02d0\3\2\2\2\u02d2\u02d5\3"+
		"\2\2\2\u02d3\u02d1\3\2\2\2\u02d3\u02d4\3\2\2\2\u02d4\u02d6\3\2\2\2\u02d5"+
		"\u02d3\3\2\2\2\u02d6\u02d7\7d\2\2\u02d7\u02d9\3\2\2\2\u02d8\u02ca\3\2"+
		"\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02da\3\2\2\2\u02da\u02db\5&\24\2\u02db"+
		"\u02dd\7s\2\2\u02dc\u02de\5*\26\2\u02dd\u02dc\3\2\2\2\u02dd\u02de\3\2"+
		"\2\2\u02de\u02e2\3\2\2\2\u02df\u02e1\7~\2\2\u02e0\u02df\3\2\2\2\u02e1"+
		"\u02e4\3\2\2\2\u02e2\u02e0\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3\u02e5\3\2"+
		"\2\2\u02e4\u02e2\3\2\2\2\u02e5\u02e6\7\7\2\2\u02e6\u02f1\3\2\2\2\u02e7"+
		"\u02e8\5\32\16\2\u02e8\u02ec\7d\2\2\u02e9\u02ed\5\n\6\2\u02ea\u02ed\5"+
		"\b\5\2\u02eb\u02ed\5\62\32\2\u02ec\u02e9\3\2\2\2\u02ec\u02ea\3\2\2\2\u02ec"+
		"\u02eb\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee\u02ef\7d\2\2\u02ef\u02f1\3\2"+
		"\2\2\u02f0\u0214\3\2\2\2\u02f0\u021e\3\2\2\2\u02f0\u0224\3\2\2\2\u02f0"+
		"\u0229\3\2\2\2\u02f0\u0241\3\2\2\2\u02f0\u025c\3\2\2\2\u02f0\u0267\3\2"+
		"\2\2\u02f0\u0271\3\2\2\2\u02f0\u0280\3\2\2\2\u02f0\u0288\3\2\2\2\u02f0"+
		"\u0292\3\2\2\2\u02f0\u029e\3\2\2\2\u02f0\u02a9\3\2\2\2\u02f0\u02e7\3\2"+
		"\2\2\u02f1)\3\2\2\2\u02f2\u02f3\b\26\1\2\u02f3\u02f4\t\36\2\2\u02f4\u0316"+
		"\5*\26\t\u02f5\u0316\t\4\2\2\u02f6\u0316\7z\2\2\u02f7\u02fe\7{\2\2\u02f8"+
		"\u02f9\7\21\2\2\u02f9\u02fa\5*\26\2\u02fa\u02fb\7\24\2\2\u02fb\u02ff\3"+
		"\2\2\2\u02fc\u02fd\7\b\2\2\u02fd\u02ff\7{\2\2\u02fe\u02f8\3\2\2\2\u02fe"+
		"\u02fc\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0316\3\2\2\2\u0300\u0301\t\16"+
		"\2\2\u0301\u0302\7\21\2\2\u0302\u0303\7|\2\2\u0303\u0316\7\24\2\2\u0304"+
		"\u0305\t\37\2\2\u0305\u030e\7\21\2\2\u0306\u030b\5*\26\2\u0307\u0308\7"+
		"\3\2\2\u0308\u030a\5*\26\2\u0309\u0307\3\2\2\2\u030a\u030d\3\2\2\2\u030b"+
		"\u0309\3\2\2\2\u030b\u030c\3\2\2\2\u030c\u030f\3\2\2\2\u030d\u030b\3\2"+
		"\2\2\u030e\u0306\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u0310\3\2\2\2\u0310"+
		"\u0316\7\24\2\2\u0311\u0312\7\21\2\2\u0312\u0313\5*\26\2\u0313\u0314\7"+
		"\24\2\2\u0314\u0316\3\2\2\2\u0315\u02f2\3\2\2\2\u0315\u02f5\3\2\2\2\u0315"+
		"\u02f6\3\2\2\2\u0315\u02f7\3\2\2\2\u0315\u0300\3\2\2\2\u0315\u0304\3\2"+
		"\2\2\u0315\u0311\3\2\2\2\u0316\u033d\3\2\2\2\u0317\u0318\f\b\2\2\u0318"+
		"\u031a\t\5\2\2\u0319\u031b\7~\2\2\u031a\u0319\3\2\2\2\u031a\u031b\3\2"+
		"\2\2\u031b\u031c\3\2\2\2\u031c\u033c\5*\26\t\u031d\u031e\f\7\2\2\u031e"+
		"\u0320\t\6\2\2\u031f\u0321\7~\2\2\u0320\u031f\3\2\2\2\u0320\u0321\3\2"+
		"\2\2\u0321\u0322\3\2\2\2\u0322\u033c\5*\26\b\u0323\u0324\f\6\2\2\u0324"+
		"\u0326\t \2\2\u0325\u0327\7~\2\2\u0326\u0325\3\2\2\2\u0326\u0327\3\2\2"+
		"\2\u0327\u0328\3\2\2\2\u0328\u033c\5*\26\7\u0329\u032a\f\5\2\2\u032a\u032c"+
		"\t!\2\2\u032b\u032d\7~\2\2\u032c\u032b\3\2\2\2\u032c\u032d\3\2\2\2\u032d"+
		"\u032e\3\2\2\2\u032e\u033c\5*\26\6\u032f\u0330\f\4\2\2\u0330\u0332\7)"+
		"\2\2\u0331\u0333\7~\2\2\u0332\u0331\3\2\2\2\u0332\u0333\3\2\2\2\u0333"+
		"\u0334\3\2\2\2\u0334\u033c\5*\26\5\u0335\u0336\f\3\2\2\u0336\u0338\7,"+
		"\2\2\u0337\u0339\7~\2\2\u0338\u0337\3\2\2\2\u0338\u0339\3\2\2\2\u0339"+
		"\u033a\3\2\2\2\u033a\u033c\5*\26\4\u033b\u0317\3\2\2\2\u033b\u031d\3\2"+
		"\2\2\u033b\u0323\3\2\2\2\u033b\u0329\3\2\2\2\u033b\u032f\3\2\2\2\u033b"+
		"\u0335\3\2\2\2\u033c\u033f\3\2\2\2\u033d\u033b\3\2\2\2\u033d\u033e\3\2"+
		"\2\2\u033e+\3\2\2\2\u033f\u033d\3\2\2\2\u0340\u0344\7\6\2\2\u0341\u0343"+
		"\7~\2\2\u0342\u0341\3\2\2\2\u0343\u0346\3\2\2\2\u0344\u0342\3\2\2\2\u0344"+
		"\u0345\3\2\2\2\u0345\u0347\3\2\2\2\u0346\u0344\3\2\2\2\u0347\u034b\7u"+
		"\2\2\u0348\u034a\7~\2\2\u0349\u0348\3\2\2\2\u034a\u034d\3\2\2\2\u034b"+
		"\u0349\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u034f\3\2\2\2\u034d\u034b\3\2"+
		"\2\2\u034e\u0350\5\16\b\2\u034f\u034e\3\2\2\2\u034f\u0350\3\2\2\2\u0350"+
		"\u035b\3\2\2\2\u0351\u0353\7~\2\2\u0352\u0351\3\2\2\2\u0353\u0354\3\2"+
		"\2\2\u0354\u0352\3\2\2\2\u0354\u0355\3\2\2\2\u0355\u0357\3\2\2\2\u0356"+
		"\u0358\5\16\b\2\u0357\u0356\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u035a\3"+
		"\2\2\2\u0359\u0352\3\2\2\2\u035a\u035d\3\2\2\2\u035b\u0359\3\2\2\2\u035b"+
		"\u035c\3\2\2\2\u035c\u035e\3\2\2\2\u035d\u035b\3\2\2\2\u035e\u035f\5."+
		"\30\2\u035f\u0363\7\7\2\2\u0360\u0362\7~\2\2\u0361\u0360\3\2\2\2\u0362"+
		"\u0365\3\2\2\2\u0363\u0361\3\2\2\2\u0363\u0364\3\2\2\2\u0364-\3\2\2\2"+
		"\u0365\u0363\3\2\2\2\u0366\u036f\7v\2\2\u0367\u036c\7{\2\2\u0368\u0369"+
		"\7\3\2\2\u0369\u036b\7{\2\2\u036a\u0368\3\2\2\2\u036b\u036e\3\2\2\2\u036c"+
		"\u036a\3\2\2\2\u036c\u036d\3\2\2\2\u036d\u0370\3\2\2\2\u036e\u036c\3\2"+
		"\2\2\u036f\u0367\3\2\2\2\u036f\u0370\3\2\2\2\u0370\u0374\3\2\2\2\u0371"+
		"\u0373\7~\2\2\u0372\u0371\3\2\2\2\u0373\u0376\3\2\2\2\u0374\u0372\3\2"+
		"\2\2\u0374\u0375\3\2\2\2\u0375/\3\2\2\2\u0376\u0374\3\2\2\2\u0377\u037b"+
		"\7\6\2\2\u0378\u037a\7~\2\2\u0379\u0378\3\2\2\2\u037a\u037d\3\2\2\2\u037b"+
		"\u0379\3\2\2\2\u037b\u037c\3\2\2\2\u037c\u0393\3\2\2\2\u037d\u037b\3\2"+
		"\2\2\u037e\u0382\7w\2\2\u037f\u0381\7~\2\2\u0380\u037f\3\2\2\2\u0381\u0384"+
		"\3\2\2\2\u0382\u0380\3\2\2\2\u0382\u0383\3\2\2\2\u0383\u0385\3\2\2\2\u0384"+
		"\u0382\3\2\2\2\u0385\u0390\5\16\b\2\u0386\u0388\7~\2\2\u0387\u0386\3\2"+
		"\2\2\u0388\u0389\3\2\2\2\u0389\u0387\3\2\2\2\u0389\u038a\3\2\2\2\u038a"+
		"\u038c\3\2\2\2\u038b\u038d\5\16\b\2\u038c\u038b\3\2\2\2\u038c\u038d\3"+
		"\2\2\2\u038d\u038f\3\2\2\2\u038e\u0387\3\2\2\2\u038f\u0392\3\2\2\2\u0390"+
		"\u038e\3\2\2\2\u0390\u0391\3\2\2\2\u0391\u0394\3\2\2\2\u0392\u0390\3\2"+
		"\2\2\u0393\u037e\3\2\2\2\u0393\u0394\3\2\2\2\u0394\u0398\3\2\2\2\u0395"+
		"\u0397\7~\2\2\u0396\u0395\3\2\2\2\u0397\u039a\3\2\2\2\u0398\u0396\3\2"+
		"\2\2\u0398\u0399\3\2\2\2\u0399\u039c\3\2\2\2\u039a\u0398\3\2\2\2\u039b"+
		"\u039d\5.\30\2\u039c\u039b\3\2\2\2\u039c\u039d\3\2\2\2\u039d\u03b3\3\2"+
		"\2\2\u039e\u03a2\7x\2\2\u039f\u03a1\7~\2\2\u03a0\u039f\3\2\2\2\u03a1\u03a4"+
		"\3\2\2\2\u03a2\u03a0\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3\u03a5\3\2\2\2\u03a4"+
		"\u03a2\3\2\2\2\u03a5\u03b0\5\16\b\2\u03a6\u03a8\7~\2\2\u03a7\u03a6\3\2"+
		"\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03a7\3\2\2\2\u03a9\u03aa\3\2\2\2\u03aa"+
		"\u03ac\3\2\2\2\u03ab\u03ad\5\16\b\2\u03ac\u03ab\3\2\2\2\u03ac\u03ad\3"+
		"\2\2\2\u03ad\u03af\3\2\2\2\u03ae\u03a7\3\2\2\2\u03af\u03b2\3\2\2\2\u03b0"+
		"\u03ae\3\2\2\2\u03b0\u03b1\3\2\2\2\u03b1\u03b4\3\2\2\2\u03b2\u03b0\3\2"+
		"\2\2\u03b3\u039e\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03b8\3\2\2\2\u03b5"+
		"\u03b7\7~\2\2\u03b6\u03b5\3\2\2\2\u03b7\u03ba\3\2\2\2\u03b8\u03b6\3\2"+
		"\2\2\u03b8\u03b9\3\2\2\2\u03b9\u03bb\3\2\2\2\u03ba\u03b8\3\2\2\2\u03bb"+
		"\u03bf\7\7\2\2\u03bc\u03be\7~\2\2\u03bd\u03bc\3\2\2\2\u03be\u03c1\3\2"+
		"\2\2\u03bf\u03bd\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0\61\3\2\2\2\u03c1\u03bf"+
		"\3\2\2\2\u03c2\u03c6\7\6\2\2\u03c3\u03c5\7~\2\2\u03c4\u03c3\3\2\2\2\u03c5"+
		"\u03c8\3\2\2\2\u03c6\u03c4\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7\u03c9\3\2"+
		"\2\2\u03c8\u03c6\3\2\2\2\u03c9\u03cd\7u\2\2\u03ca\u03cc\7~\2\2\u03cb\u03ca"+
		"\3\2\2\2\u03cc\u03cf\3\2\2\2\u03cd\u03cb\3\2\2\2\u03cd\u03ce\3\2\2\2\u03ce"+
		"\u03d1\3\2\2\2\u03cf\u03cd\3\2\2\2\u03d0\u03d2\5\16\b\2\u03d1\u03d0\3"+
		"\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03dd\3\2\2\2\u03d3\u03d5\7~\2\2\u03d4"+
		"\u03d3\3\2\2\2\u03d5\u03d6\3\2\2\2\u03d6\u03d4\3\2\2\2\u03d6\u03d7\3\2"+
		"\2\2\u03d7\u03d9\3\2\2\2\u03d8\u03da\5\16\b\2\u03d9\u03d8\3\2\2\2\u03d9"+
		"\u03da\3\2\2\2\u03da\u03dc\3\2\2\2\u03db\u03d4\3\2\2\2\u03dc\u03df\3\2"+
		"\2\2\u03dd\u03db\3\2\2\2\u03dd\u03de\3\2\2\2\u03de\u03e0\3\2\2\2\u03df"+
		"\u03dd\3\2\2\2\u03e0\u03e4\7\7\2\2\u03e1\u03e3\7~\2\2\u03e2\u03e1\3\2"+
		"\2\2\u03e3\u03e6\3\2\2\2\u03e4\u03e2\3\2\2\2\u03e4\u03e5\3\2\2\2\u03e5"+
		"\63\3\2\2\2\u03e6\u03e4\3\2\2\2\u00968<AQT\\bikotw{\u0082\u008f\u0096"+
		"\u009d\u00a2\u00a7\u00ac\u00b0\u00bb\u00c9\u00d0\u00d5\u00db\u00e1\u00e7"+
		"\u00ed\u00f3\u00f9\u00fc\u00fe\u0107\u010c\u0110\u011b\u0122\u0127\u012d"+
		"\u0134\u013a\u0140\u0148\u014e\u0155\u015c\u0163\u016d\u0175\u017b\u0182"+
		"\u018f\u019a\u01a1\u01a4\u01b3\u01ba\u01bd\u01c5\u01cc\u01d0\u01d5\u01d8"+
		"\u01dc\u01e3\u01e8\u01f1\u01f9\u0205\u020a\u020d\u0211\u021a\u0221\u0230"+
		"\u023a\u0248\u024f\u0257\u025f\u0264\u026f\u0271\u027a\u027d\u0283\u028e"+
		"\u0295\u029a\u02a1\u02a6\u02ac\u02b4\u02b7\u02bd\u02c3\u02ca\u02d3\u02d8"+
		"\u02dd\u02e2\u02ec\u02f0\u02fe\u030b\u030e\u0315\u031a\u0320\u0326\u032c"+
		"\u0332\u0338\u033b\u033d\u0344\u034b\u034f\u0354\u0357\u035b\u0363\u036c"+
		"\u036f\u0374\u037b\u0382\u0389\u038c\u0390\u0393\u0398\u039c\u03a2\u03a9"+
		"\u03ac\u03b0\u03b3\u03b8\u03bf\u03c6\u03cd\u03d1\u03d6\u03d9\u03dd\u03e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}