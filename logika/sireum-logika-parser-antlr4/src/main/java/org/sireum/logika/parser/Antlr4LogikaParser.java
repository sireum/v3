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
		T__107=108, HLINE=109, INT=110, NUM=111, ID=112, STRING=113, LINE_COMMENT=114, 
		COMMENT=115, NL=116, WS=117, RESERVED=118, ERROR_CHAR=119, INTRO=120, 
		INTRO1=121, INTRO2=122, ELIM=123, ELIM1=124, ELIM2=125, ORG=126, SIREUM=127, 
		LOGIKA=128;
	public static final int
		RULE_sequentFile = 0, RULE_proofFile = 1, RULE_programFile = 2, RULE_sequent = 3, 
		RULE_proof = 4, RULE_proofStep = 5, RULE_formula = 6, RULE_qformula = 7, 
		RULE_justification = 8, RULE_nums = 9, RULE_numOrIds = 10, RULE_numOrId = 11, 
		RULE_ids = 12, RULE_program = 13, RULE_stmts = 14, RULE_stmt = 15, RULE_exp = 16, 
		RULE_type = 17, RULE_loopInvariant = 18, RULE_modifies = 19, RULE_methodDecl = 20, 
		RULE_param = 21, RULE_methodContract = 22, RULE_invariants = 23, RULE_facts = 24, 
		RULE_fact = 25;
	public static final String[] ruleNames = {
		"sequentFile", "proofFile", "programFile", "sequent", "proof", "proofStep", 
		"formula", "qformula", "justification", "nums", "numOrIds", "numOrId", 
		"ids", "program", "stmts", "stmt", "exp", "type", "loopInvariant", "modifies", 
		"methodDecl", "param", "methodContract", "invariants", "facts", "fact"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'|-'", "'⊢'", "'{'", "'}'", "'.'", "'assume'", "'false'", 
		"'F'", "'_|_'", "'⊥'", "'true'", "'T'", "'('", "')'", "'$result'", "'*'", 
		"'/'", "'%'", "'+'", "'-'", "'<'", "'<='", "'≤'", "'>'", "'>='", "'≥'", 
		"'='", "'=='", "'!='", "'≠'", "'not'", "'!'", "'~'", "'¬'", "'and'", "'&&'", 
		"'∧'", "'or'", "'||'", "'∨'", "'implies'", "'⇒'", "'=>'", "'forall'", 
		"'all'", "'A'", "'∀'", "'exists'", "'some'", "'E'", "'∃'", "'|'", "'premise'", 
		"'andi'", "'ande1'", "'ande2'", "'ori1'", "'ori2'", "'ore'", "'impliesi'", 
		"'impliese'", "'noti'", "'note'", "'falsee'", "'Pbc'", "'foralli'", "'alli'", 
		"'Ai'", "'foralle'", "'alle'", "'Ae'", "'existsi'", "'somei'", "'Ei'", 
		"'existse'", "'somee'", "'Ee'", "'algebra'", "'auto'", "'import'", "'_'", 
		"'var'", "'val'", "':'", "'assert'", "'if'", "'else'", "'while'", "'l'", 
		"'\"\"\"'", "'readInt'", "'print'", "'println'", "'s'", "'clone'", "'BigInt'", 
		"'Seq'", "'Boolean'", "'['", "']'", "'invariant'", "'modifies'", "'def'", 
		"'return'", "'requires'", "'ensures'", "'fact'", null, null, null, null, 
		null, null, null, null, null, null, null, "'i'", "'i1'", "'i2'", "'e'", 
		"'e1'", "'e2'", "'org'", "'sireum'", "'logika'"
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
		null, "HLINE", "INT", "NUM", "ID", "STRING", "LINE_COMMENT", "COMMENT", 
		"NL", "WS", "RESERVED", "ERROR_CHAR", "INTRO", "INTRO1", "INTRO2", "ELIM", 
		"ELIM1", "ELIM2", "ORG", "SIREUM", "LOGIKA"
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
		public ProofContext proof() {
			return getRuleContext(ProofContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			sequent();
			setState(54);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(53);
				proof();
				}
			}

			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(56);
				match(NL);
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
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
			setState(64);
			proof();
			setState(65);
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
			setState(67);
			program();
			setState(68);
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
			setState(101);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0) || _la==INT || _la==ID) {
					{
					setState(70);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(71);
						match(T__0);
						setState(72);
						((SequentContext)_localctx).formula = formula(0);
						((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
						}
						}
						setState(77);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(80);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(81);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(82);
					match(T__0);
					setState(83);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0) || _la==INT || _la==ID) {
					{
					{
					setState(89);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(95);
				match(HLINE);
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(96);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(99); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0) || _la==INT || _la==ID );
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
			setState(103);
			match(T__3);
			setState(105);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(104);
				proofStep();
				}
			}

			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(108); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(107);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(110); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(113);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(112);
					proofStep();
					}
				}

				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			match(T__4);
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
			setState(159);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(NUM);
				setState(123);
				match(T__5);
				setState(124);
				formula(0);
				setState(125);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(128);
				match(T__5);
				setState(129);
				match(T__3);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(130);
					match(NL);
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(136);
				((SubProofContext)_localctx).assume = match(NUM);
				setState(137);
				match(T__5);
				setState(145);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(138);
					((SubProofContext)_localctx).fresh = match(ID);
					}
					break;
				case 2:
					{
					setState(140);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						setState(139);
						((SubProofContext)_localctx).fresh = match(ID);
						}
						break;
					}
					setState(142);
					formula(0);
					setState(143);
					match(T__6);
					}
					break;
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(148); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(147);
						match(NL);
						}
						}
						setState(150); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NL );
					setState(152);
					proofStep();
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(158);
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
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public VarContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class ApplyContext extends FormulaContext {
		public Token fun;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ApplyContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class TrueContext extends FormulaContext {
		public TrueContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class FalseContext extends FormulaContext {
		public FalseContext(FormulaContext ctx) { copyFrom(ctx); }
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
	public static class UnaryContext extends FormulaContext {
		public Token op;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public UnaryContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class IntContext extends FormulaContext {
		public TerminalNode INT() { return getToken(Antlr4LogikaParser.INT, 0); }
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
			setState(188);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(162);
				((UnaryContext)_localctx).op = match(T__20);
				setState(163);
				formula(6);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(165);
				formula(5);
				}
				break;
			case 3:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 4:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__12) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 5:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(T__13);
				setState(170);
				formula(0);
				setState(171);
				match(T__14);
				}
				break;
			case 7:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173);
				match(T__15);
				}
				break;
			case 8:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				((ApplyContext)_localctx).fun = match(ID);
				setState(175);
				match(T__13);
				setState(176);
				formula(0);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(177);
					match(T__0);
					setState(178);
					formula(0);
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(184);
				match(T__14);
				}
				break;
			case 9:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				match(INT);
				}
				break;
			case 10:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(234);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(232);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(190);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(191);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(193);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(192);
							match(NL);
							}
						}

						setState(195);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(196);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(197);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(199);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(198);
							match(NL);
							}
						}

						setState(201);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(202);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(203);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(205);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(204);
							match(NL);
							}
						}

						setState(207);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(208);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(209);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(214);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(215);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
						_errHandler.recoverInline(this);
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
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(220);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(221);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__39) | (1L << T__40))) != 0)) ) {
						_errHandler.recoverInline(this);
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
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(226);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(227);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__41) | (1L << T__42) | (1L << T__43))) != 0)) ) {
						_errHandler.recoverInline(this);
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
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(236);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
		public List<Token> qVars = new ArrayList<Token>();
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
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
			setState(237);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(238);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).qVars.add(((QformulaContext)_localctx).ID);
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(239);
				match(T__0);
				setState(240);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).qVars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(246);
			match(T__52);
			setState(248);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(247);
				match(NL);
				}
			}

			setState(250);
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
		public NumOrIdContext stepOrFact;
		public NumOrIdsContext args;
		public NumOrIdContext numOrId() {
			return getRuleContext(NumOrIdContext.class,0);
		}
		public NumOrIdsContext numOrIds() {
			return getRuleContext(NumOrIdsContext.class,0);
		}
		public TerminalNode ELIM() { return getToken(Antlr4LogikaParser.ELIM, 0); }
		public ForallElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ExistsIntroContext extends JustificationContext {
		public Token existsStep;
		public IdsContext args;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public TerminalNode INTRO() { return getToken(Antlr4LogikaParser.INTRO, 0); }
		public ExistsIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndIntroContext extends JustificationContext {
		public Token lStep;
		public Token rStep;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public TerminalNode INTRO() { return getToken(Antlr4LogikaParser.INTRO, 0); }
		public AndIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ForallIntroContext extends JustificationContext {
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode INTRO() { return getToken(Antlr4LogikaParser.INTRO, 0); }
		public ForallIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ImpliesElimContext extends JustificationContext {
		public Token impliesStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ELIM() { return getToken(Antlr4LogikaParser.ELIM, 0); }
		public ImpliesElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class PremiseContext extends JustificationContext {
		public PremiseContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndElim2Context extends JustificationContext {
		public Token andStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ELIM2() { return getToken(Antlr4LogikaParser.ELIM2, 0); }
		public AndElim2Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class OrIntro2Context extends JustificationContext {
		public Token orStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode INTRO2() { return getToken(Antlr4LogikaParser.INTRO2, 0); }
		public OrIntro2Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class NegIntroContext extends JustificationContext {
		public Token step;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode INTRO() { return getToken(Antlr4LogikaParser.INTRO, 0); }
		public NegIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class NegElimContext extends JustificationContext {
		public Token step;
		public Token notStep;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public TerminalNode ELIM() { return getToken(Antlr4LogikaParser.ELIM, 0); }
		public NegElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class PbcContext extends JustificationContext {
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public PbcContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AutoContext extends JustificationContext {
		public NumOrIdsContext stepOrFact;
		public NumOrIdsContext numOrIds() {
			return getRuleContext(NumOrIdsContext.class,0);
		}
		public AutoContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class OrIntro1Context extends JustificationContext {
		public Token orStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode INTRO1() { return getToken(Antlr4LogikaParser.INTRO1, 0); }
		public OrIntro1Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndElim1Context extends JustificationContext {
		public Token andStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ELIM1() { return getToken(Antlr4LogikaParser.ELIM1, 0); }
		public AndElim1Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AlgebraContext extends JustificationContext {
		public NumsContext steps;
		public NumsContext nums() {
			return getRuleContext(NumsContext.class,0);
		}
		public AlgebraContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ExistsContext extends JustificationContext {
		public NumOrIdContext stepOrFact;
		public Token subproof;
		public NumOrIdContext numOrId() {
			return getRuleContext(NumOrIdContext.class,0);
		}
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ELIM() { return getToken(Antlr4LogikaParser.ELIM, 0); }
		public ExistsContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class OrElimContext extends JustificationContext {
		public Token orStep;
		public Token lSubProof;
		public Token rSubProof;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public TerminalNode ELIM() { return getToken(Antlr4LogikaParser.ELIM, 0); }
		public OrElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class FalseElimContext extends JustificationContext {
		public Token falseStep;
		public TerminalNode ELIM() { return getToken(Antlr4LogikaParser.ELIM, 0); }
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public FalseElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ImpliesIntroContext extends JustificationContext {
		public Token impliesStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode INTRO() { return getToken(Antlr4LogikaParser.INTRO, 0); }
		public ImpliesIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}

	public final JustificationContext justification() throws RecognitionException {
		JustificationContext _localctx = new JustificationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_justification);
		int _la;
		try {
			setState(374);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				match(T__53);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				switch (_input.LA(1)) {
				case T__54:
					{
					setState(253);
					match(T__54);
					}
					break;
				case T__36:
				case T__37:
					{
					setState(254);
					_la = _input.LA(1);
					if ( !(_la==T__36 || _la==T__37) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(255);
					match(INTRO);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(258);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(259);
				match(T__0);
				setState(260);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElim1Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(264);
				switch (_input.LA(1)) {
				case T__55:
					{
					setState(261);
					match(T__55);
					}
					break;
				case T__36:
				case T__37:
					{
					setState(262);
					_la = _input.LA(1);
					if ( !(_la==T__36 || _la==T__37) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(263);
					match(ELIM1);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(266);
				((AndElim1Context)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new AndElim2Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(270);
				switch (_input.LA(1)) {
				case T__56:
					{
					setState(267);
					match(T__56);
					}
					break;
				case T__36:
				case T__37:
					{
					setState(268);
					_la = _input.LA(1);
					if ( !(_la==T__36 || _la==T__37) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(269);
					match(ELIM2);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(272);
				((AndElim2Context)_localctx).andStep = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrIntro1Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(276);
				switch (_input.LA(1)) {
				case T__57:
					{
					setState(273);
					match(T__57);
					}
					break;
				case T__39:
				case T__40:
					{
					setState(274);
					_la = _input.LA(1);
					if ( !(_la==T__39 || _la==T__40) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(275);
					match(INTRO1);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(278);
				((OrIntro1Context)_localctx).orStep = match(NUM);
				}
				break;
			case 6:
				_localctx = new OrIntro2Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(282);
				switch (_input.LA(1)) {
				case T__58:
					{
					setState(279);
					match(T__58);
					}
					break;
				case T__39:
				case T__40:
					{
					setState(280);
					_la = _input.LA(1);
					if ( !(_la==T__39 || _la==T__40) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(281);
					match(INTRO2);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(284);
				((OrIntro2Context)_localctx).orStep = match(NUM);
				}
				break;
			case 7:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(288);
				switch (_input.LA(1)) {
				case T__59:
					{
					setState(285);
					match(T__59);
					}
					break;
				case T__39:
				case T__40:
					{
					setState(286);
					_la = _input.LA(1);
					if ( !(_la==T__39 || _la==T__40) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(287);
					match(ELIM);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(290);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(291);
				match(T__0);
				setState(292);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(293);
				match(T__0);
				setState(294);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 8:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(298);
				switch (_input.LA(1)) {
				case T__60:
					{
					setState(295);
					match(T__60);
					}
					break;
				case T__42:
				case T__43:
					{
					setState(296);
					_la = _input.LA(1);
					if ( !(_la==T__42 || _la==T__43) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(297);
					match(INTRO);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(300);
				((ImpliesIntroContext)_localctx).impliesStep = match(NUM);
				}
				break;
			case 9:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(304);
				switch (_input.LA(1)) {
				case T__61:
					{
					setState(301);
					match(T__61);
					}
					break;
				case T__42:
				case T__43:
					{
					setState(302);
					_la = _input.LA(1);
					if ( !(_la==T__42 || _la==T__43) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(303);
					match(ELIM);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(306);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(310);
				switch (_input.LA(1)) {
				case T__62:
					{
					setState(307);
					match(T__62);
					}
					break;
				case T__32:
				case T__33:
				case T__34:
					{
					setState(308);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(309);
					match(INTRO);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(312);
				((NegIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 11:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(316);
				switch (_input.LA(1)) {
				case T__63:
					{
					setState(313);
					match(T__63);
					}
					break;
				case T__32:
				case T__33:
				case T__34:
					{
					setState(314);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(315);
					match(ELIM);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(318);
				((NegElimContext)_localctx).step = match(NUM);
				setState(319);
				match(T__0);
				setState(320);
				((NegElimContext)_localctx).notStep = match(NUM);
				}
				break;
			case 12:
				_localctx = new FalseElimContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(321);
				_la = _input.LA(1);
				if ( !(((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__9 - 10)) | (1L << (T__10 - 10)) | (1L << (T__64 - 10)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(322);
				match(ELIM);
				setState(323);
				((FalseElimContext)_localctx).falseStep = match(NUM);
				}
				break;
			case 13:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(324);
				match(T__65);
				setState(325);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 14:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(331);
				switch (_input.LA(1)) {
				case T__66:
					{
					setState(326);
					match(T__66);
					}
					break;
				case T__67:
					{
					setState(327);
					match(T__67);
					}
					break;
				case T__68:
					{
					setState(328);
					match(T__68);
					}
					break;
				case T__47:
					{
					setState(329);
					match(T__47);
					setState(330);
					match(INTRO);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(333);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 15:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(339);
				switch (_input.LA(1)) {
				case T__69:
					{
					setState(334);
					match(T__69);
					}
					break;
				case T__70:
					{
					setState(335);
					match(T__70);
					}
					break;
				case T__71:
					{
					setState(336);
					match(T__71);
					}
					break;
				case T__47:
					{
					setState(337);
					match(T__47);
					setState(338);
					match(ELIM);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(341);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
				setState(342);
				match(T__0);
				setState(343);
				((ForallElimContext)_localctx).args = numOrIds();
				}
				break;
			case 16:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(350);
				switch (_input.LA(1)) {
				case T__72:
					{
					setState(345);
					match(T__72);
					}
					break;
				case T__73:
					{
					setState(346);
					match(T__73);
					}
					break;
				case T__74:
					{
					setState(347);
					match(T__74);
					}
					break;
				case T__51:
					{
					setState(348);
					match(T__51);
					setState(349);
					match(INTRO);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(352);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(353);
				match(T__0);
				setState(354);
				((ExistsIntroContext)_localctx).args = ids();
				}
				break;
			case 17:
				_localctx = new ExistsContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(360);
				switch (_input.LA(1)) {
				case T__75:
					{
					setState(355);
					match(T__75);
					}
					break;
				case T__76:
					{
					setState(356);
					match(T__76);
					}
					break;
				case T__77:
					{
					setState(357);
					match(T__77);
					}
					break;
				case T__51:
					{
					setState(358);
					match(T__51);
					setState(359);
					match(ELIM);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(362);
				((ExistsContext)_localctx).stepOrFact = numOrId();
				setState(363);
				match(T__0);
				setState(364);
				((ExistsContext)_localctx).subproof = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(366);
				match(T__78);
				setState(368);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(367);
					((AlgebraContext)_localctx).steps = nums();
					}
				}

				}
				break;
			case 19:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(370);
				match(T__79);
				setState(372);
				_la = _input.LA(1);
				if (_la==NUM || _la==ID) {
					{
					setState(371);
					((AutoContext)_localctx).stepOrFact = numOrIds();
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

	public static class NumsContext extends ParserRuleContext {
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public NumsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nums; }
	}

	public final NumsContext nums() throws RecognitionException {
		NumsContext _localctx = new NumsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nums);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			match(NUM);
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(377);
				match(T__0);
				setState(378);
				match(NUM);
				}
				}
				setState(383);
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

	public static class NumOrIdsContext extends ParserRuleContext {
		public List<NumOrIdContext> numOrId() {
			return getRuleContexts(NumOrIdContext.class);
		}
		public NumOrIdContext numOrId(int i) {
			return getRuleContext(NumOrIdContext.class,i);
		}
		public NumOrIdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numOrIds; }
	}

	public final NumOrIdsContext numOrIds() throws RecognitionException {
		NumOrIdsContext _localctx = new NumOrIdsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_numOrIds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			numOrId();
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(385);
				match(T__0);
				setState(386);
				numOrId();
				}
				}
				setState(391);
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

	public static class NumOrIdContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public NumOrIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numOrId; }
	}

	public final NumOrIdContext numOrId() throws RecognitionException {
		NumOrIdContext _localctx = new NumOrIdContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_numOrId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			_la = _input.LA(1);
			if ( !(_la==NUM || _la==ID) ) {
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

	public static class IdsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public IdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ids; }
	}

	public final IdsContext ids() throws RecognitionException {
		IdsContext _localctx = new IdsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			match(ID);
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(395);
				match(T__0);
				setState(396);
				match(ID);
				}
				}
				setState(401);
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

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode ORG() { return getToken(Antlr4LogikaParser.ORG, 0); }
		public TerminalNode SIREUM() { return getToken(Antlr4LogikaParser.SIREUM, 0); }
		public TerminalNode LOGIKA() { return getToken(Antlr4LogikaParser.LOGIKA, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			match(T__80);
			setState(403);
			match(ORG);
			setState(404);
			match(T__5);
			setState(405);
			match(SIREUM);
			setState(406);
			match(T__5);
			setState(407);
			match(LOGIKA);
			setState(408);
			match(T__5);
			setState(409);
			match(T__81);
			setState(410);
			stmts();
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
		enterRule(_localctx, 28, RULE_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			_la = _input.LA(1);
			if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__85 - 83)) | (1L << (T__86 - 83)) | (1L << (T__88 - 83)) | (1L << (T__89 - 83)) | (1L << (T__92 - 83)) | (1L << (T__93 - 83)) | (1L << (T__103 - 83)) | (1L << (ID - 83)))) != 0)) {
				{
				setState(412);
				stmt();
				}
			}

			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(416); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(415);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(418); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(421);
				_la = _input.LA(1);
				if (((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__85 - 83)) | (1L << (T__86 - 83)) | (1L << (T__88 - 83)) | (1L << (T__89 - 83)) | (1L << (T__92 - 83)) | (1L << (T__93 - 83)) | (1L << (T__103 - 83)) | (1L << (ID - 83)))) != 0)) {
					{
					setState(420);
					stmt();
					}
				}

				}
				}
				setState(427);
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
		public Token l;
		public Token r;
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
		public MethodInvocationStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssignVarStmtContext extends StmtContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssignVarStmtContext(StmtContext ctx) { copyFrom(ctx); }
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
	public static class PrintStmtContext extends StmtContext {
		public Token op;
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public PrintStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class SeqCloneStmtContext extends StmtContext {
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public SeqCloneStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class MethodDeclStmtContext extends StmtContext {
		public MethodDeclContext methodDecl() {
			return getRuleContext(MethodDeclContext.class,0);
		}
		public MethodDeclStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssignArrayStmtContext extends StmtContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public AssignArrayStmtContext(StmtContext ctx) { copyFrom(ctx); }
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
		public LoopInvariantContext loopInvariant() {
			return getRuleContext(LoopInvariantContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class ReadIntStmtContext extends StmtContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public ReadIntStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class LogikaStmtContext extends StmtContext {
		public ProofContext proof() {
			return getRuleContext(ProofContext.class,0);
		}
		public SequentContext sequent() {
			return getRuleContext(SequentContext.class,0);
		}
		public InvariantsContext invariants() {
			return getRuleContext(InvariantsContext.class,0);
		}
		public FactsContext facts() {
			return getRuleContext(FactsContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
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
		public VarDeclStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssertStmtContext extends StmtContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssertStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_stmt);
		int _la;
		try {
			setState(565);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(428);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__82 || _la==T__83) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(429);
				match(ID);
				setState(430);
				match(T__84);
				setState(431);
				type();
				setState(432);
				match(T__27);
				setState(433);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(435);
				match(ID);
				setState(436);
				match(T__27);
				setState(437);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(438);
				match(T__85);
				setState(439);
				match(T__13);
				setState(440);
				exp(0);
				setState(441);
				match(T__14);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(443);
				match(T__86);
				setState(444);
				match(T__13);
				setState(445);
				exp(0);
				setState(446);
				match(T__14);
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(447);
					match(NL);
					}
					}
					setState(452);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(453);
				match(T__3);
				setState(454);
				((IfStmtContext)_localctx).ts = stmts();
				setState(455);
				match(T__4);
				setState(456);
				match(T__87);
				setState(457);
				match(T__3);
				setState(458);
				((IfStmtContext)_localctx).fs = stmts();
				setState(459);
				match(T__4);
				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(461);
				match(T__88);
				setState(462);
				match(T__13);
				setState(463);
				exp(0);
				setState(464);
				match(T__14);
				setState(468);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(465);
					match(NL);
					}
					}
					setState(470);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(471);
				match(T__3);
				setState(495);
				switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
				case 1:
					{
					setState(475);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(472);
						match(NL);
						}
						}
						setState(477);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(478);
					match(T__89);
					setState(479);
					match(T__90);
					setState(483);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(480);
						match(NL);
						}
						}
						setState(485);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(486);
					loopInvariant();
					setState(490);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(487);
						match(NL);
						}
						}
						setState(492);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(493);
					match(T__90);
					}
					break;
				}
				setState(497);
				stmts();
				setState(498);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new ReadIntStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(500);
				match(ID);
				setState(501);
				match(T__27);
				setState(502);
				match(T__91);
				setState(503);
				match(T__13);
				setState(505);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(504);
					match(STRING);
					}
				}

				setState(507);
				match(T__14);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(508);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__92 || _la==T__93) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(509);
				match(T__13);
				setState(510);
				match(T__94);
				setState(511);
				match(STRING);
				setState(512);
				match(T__14);
				}
				break;
			case 8:
				_localctx = new MethodInvocationStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(515);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(513);
					((MethodInvocationStmtContext)_localctx).l = match(ID);
					setState(514);
					match(T__27);
					}
					break;
				}
				setState(517);
				((MethodInvocationStmtContext)_localctx).r = match(ID);
				setState(518);
				match(T__13);
				setState(527);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__11) | (1L << T__13) | (1L << T__20) | (1L << T__32))) != 0) || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (T__96 - 97)) | (1L << (T__97 - 97)) | (1L << (INT - 97)) | (1L << (ID - 97)))) != 0)) {
					{
					setState(519);
					exp(0);
					setState(524);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(520);
						match(T__0);
						setState(521);
						exp(0);
						}
						}
						setState(526);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(529);
				match(T__14);
				}
				break;
			case 9:
				_localctx = new SeqCloneStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(530);
				match(ID);
				setState(531);
				match(T__27);
				setState(532);
				match(ID);
				setState(533);
				match(T__5);
				setState(534);
				match(T__95);
				}
				break;
			case 10:
				_localctx = new AssignArrayStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(535);
				match(ID);
				setState(536);
				match(T__13);
				setState(537);
				exp(0);
				setState(538);
				match(T__14);
				setState(539);
				match(T__27);
				setState(540);
				exp(0);
				}
				break;
			case 11:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(542);
				methodDecl();
				}
				break;
			case 12:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(543);
				match(T__89);
				setState(544);
				match(T__90);
				setState(548);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(545);
					match(NL);
					}
					}
					setState(550);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(555);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(551);
					proof();
					}
					break;
				case 2:
					{
					setState(552);
					sequent();
					}
					break;
				case 3:
					{
					setState(553);
					invariants();
					}
					break;
				case 4:
					{
					setState(554);
					facts();
					}
					break;
				}
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(557);
					match(NL);
					}
					}
					setState(562);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(563);
				match(T__90);
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
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
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
	public static class FalseExpContext extends ExpContext {
		public FalseExpContext(ExpContext ctx) { copyFrom(ctx); }
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
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public UnaryExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class IntExpContext extends ExpContext {
		public TerminalNode INT() { return getToken(Antlr4LogikaParser.INT, 0); }
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
	public static class TrueExpContext extends ExpContext {
		public TrueExpContext(ExpContext ctx) { copyFrom(ctx); }
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			switch (_input.LA(1)) {
			case T__20:
			case T__32:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(568);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__32) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(570);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(569);
					match(NL);
					}
				}

				setState(572);
				exp(7);
				}
				break;
			case T__11:
				{
				_localctx = new TrueExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(573);
				match(T__11);
				}
				break;
			case T__7:
				{
				_localctx = new FalseExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(574);
				match(T__7);
				}
				break;
			case INT:
				{
				_localctx = new IntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(575);
				match(INT);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(576);
				match(ID);
				setState(581);
				switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
				case 1:
					{
					setState(577);
					match(T__13);
					setState(578);
					exp(0);
					setState(579);
					match(T__14);
					}
					break;
				}
				}
				break;
			case T__96:
				{
				_localctx = new BigIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(583);
				match(T__96);
				setState(584);
				match(T__13);
				setState(585);
				match(STRING);
				setState(586);
				match(T__14);
				}
				break;
			case T__97:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(587);
				match(T__97);
				setState(588);
				match(T__13);
				setState(589);
				exp(0);
				setState(592);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(590);
					match(T__0);
					setState(591);
					exp(0);
					}
				}

				setState(594);
				match(T__14);
				}
				break;
			case T__13:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(596);
				match(T__13);
				setState(597);
				exp(0);
				setState(598);
				match(T__14);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(640);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(638);
					switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(602);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(603);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(605);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(604);
							match(NL);
							}
						}

						setState(607);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(608);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(609);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(611);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(610);
							match(NL);
							}
						}

						setState(613);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(614);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(615);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__25))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(617);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(616);
							match(NL);
							}
						}

						setState(619);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(620);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(621);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(623);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(622);
							match(NL);
							}
						}

						setState(625);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(626);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(627);
						match(T__36);
						}
						setState(629);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(628);
							match(NL);
							}
						}

						setState(631);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(632);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(633);
						match(T__39);
						}
						setState(635);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(634);
							match(NL);
							}
						}

						setState(637);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(642);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
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
	public static class IntSeqTypeContext extends TypeContext {
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public IntSeqTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanContext extends TypeContext {
		public BooleanContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class IntTypeContext extends TypeContext {
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_type);
		int _la;
		try {
			setState(661);
			switch (_input.LA(1)) {
			case T__98:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(643);
				match(T__98);
				}
				break;
			case T__96:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(644);
				match(T__96);
				}
				break;
			case T__97:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(645);
				match(T__97);
				setState(646);
				match(T__99);
				setState(650);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(647);
					match(NL);
					}
					}
					setState(652);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(653);
				match(T__96);
				setState(657);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(654);
					match(NL);
					}
					}
					setState(659);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(660);
				match(T__100);
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

	public static class LoopInvariantContext extends ParserRuleContext {
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
		enterRule(_localctx, 36, RULE_loopInvariant);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(663);
			match(T__3);
			setState(667);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(664);
				match(NL);
				}
				}
				setState(669);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(670);
			match(T__101);
			setState(672);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0) || _la==INT || _la==ID) {
				{
				setState(671);
				formula(0);
				}
			}

			setState(684);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(675); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(674);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(677); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(680);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0) || _la==INT || _la==ID) {
					{
					setState(679);
					formula(0);
					}
				}

				}
				}
				setState(686);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(687);
			modifies();
			setState(691);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(688);
				match(NL);
				}
				}
				setState(693);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(694);
			match(T__4);
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
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public ModifiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifies; }
	}

	public final ModifiesContext modifies() throws RecognitionException {
		ModifiesContext _localctx = new ModifiesContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_modifies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			match(T__102);
			setState(697);
			match(ID);
			setState(702);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(698);
				match(T__0);
				setState(699);
				match(ID);
				}
				}
				setState(704);
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

	public static class MethodDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
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
		public MethodContractContext methodContract() {
			return getRuleContext(MethodContractContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705);
			match(T__103);
			setState(706);
			match(ID);
			setState(708);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(707);
				match(NL);
				}
			}

			setState(710);
			match(T__13);
			setState(719);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(711);
				param();
				setState(716);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(712);
					match(T__0);
					setState(713);
					param();
					}
					}
					setState(718);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(721);
			match(T__14);
			setState(722);
			match(T__84);
			setState(723);
			type();
			setState(724);
			match(T__27);
			setState(725);
			match(T__3);
			setState(749);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				{
				setState(729);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(726);
					match(NL);
					}
					}
					setState(731);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(732);
				match(T__89);
				setState(733);
				match(T__90);
				setState(737);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(734);
					match(NL);
					}
					}
					setState(739);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(740);
				methodContract();
				setState(744);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(741);
					match(NL);
					}
					}
					setState(746);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(747);
				match(T__90);
				}
				break;
			}
			setState(751);
			stmts();
			setState(752);
			match(T__104);
			setState(754);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__11) | (1L << T__13) | (1L << T__20) | (1L << T__32))) != 0) || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (T__96 - 97)) | (1L << (T__97 - 97)) | (1L << (INT - 97)) | (1L << (ID - 97)))) != 0)) {
				{
				setState(753);
				exp(0);
				}
			}

			setState(759);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(756);
				match(NL);
				}
				}
				setState(761);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(762);
			match(T__4);
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
		enterRule(_localctx, 42, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(764);
			match(ID);
			setState(765);
			match(T__84);
			setState(766);
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

	public static class MethodContractContext extends ParserRuleContext {
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
		public ModifiesContext modifies() {
			return getRuleContext(ModifiesContext.class,0);
		}
		public MethodContractContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodContract; }
	}

	public final MethodContractContext methodContract() throws RecognitionException {
		MethodContractContext _localctx = new MethodContractContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_methodContract);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(768);
			match(T__3);
			setState(772);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(769);
					match(NL);
					}
					} 
				}
				setState(774);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
			}
			setState(777);
			_la = _input.LA(1);
			if (_la==T__105) {
				{
				setState(775);
				match(T__105);
				setState(776);
				formula(0);
				}
			}

			setState(782);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(779);
					match(NL);
					}
					} 
				}
				setState(784);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
			}
			setState(786);
			_la = _input.LA(1);
			if (_la==T__102) {
				{
				setState(785);
				modifies();
				}
			}

			setState(791);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(788);
					match(NL);
					}
					} 
				}
				setState(793);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
			}
			setState(796);
			_la = _input.LA(1);
			if (_la==T__106) {
				{
				setState(794);
				match(T__106);
				setState(795);
				formula(0);
				}
			}

			setState(801);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(798);
				match(NL);
				}
				}
				setState(803);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(804);
			match(T__4);
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
		enterRule(_localctx, 46, RULE_invariants);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(806);
			match(T__3);
			setState(810);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(807);
				match(NL);
				}
				}
				setState(812);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(813);
			match(T__101);
			setState(815);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0) || _la==INT || _la==ID) {
				{
				setState(814);
				formula(0);
				}
			}

			setState(827);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(818); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(817);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(820); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(823);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0) || _la==INT || _la==ID) {
					{
					setState(822);
					formula(0);
					}
				}

				}
				}
				setState(829);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(830);
			match(T__4);
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
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public List<FactContext> fact() {
			return getRuleContexts(FactContext.class);
		}
		public FactContext fact(int i) {
			return getRuleContext(FactContext.class,i);
		}
		public FactsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_facts; }
	}

	public final FactsContext facts() throws RecognitionException {
		FactsContext _localctx = new FactsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_facts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(832);
			match(T__3);
			setState(836);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(833);
				match(NL);
				}
				}
				setState(838);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(839);
			match(T__107);
			setState(841);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(840);
				fact();
				}
			}

			setState(853);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(844); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(843);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(846); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(849);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(848);
					fact();
					}
				}

				}
				}
				setState(855);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(856);
			match(T__4);
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
		enterRule(_localctx, 50, RULE_fact);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(858);
			match(ID);
			setState(859);
			match(T__5);
			setState(860);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 16:
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
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0082\u0361\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\5\29\n\2\3\2\7\2<\n\2\f\2\16\2?\13\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\7\5L\n\5\f\5\16\5O\13\5\5\5Q"+
		"\n\5\3\5\3\5\3\5\3\5\7\5W\n\5\f\5\16\5Z\13\5\3\5\7\5]\n\5\f\5\16\5`\13"+
		"\5\3\5\3\5\6\5d\n\5\r\5\16\5e\5\5h\n\5\3\6\3\6\5\6l\n\6\3\6\6\6o\n\6\r"+
		"\6\16\6p\3\6\5\6t\n\6\7\6v\n\6\f\6\16\6y\13\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\7\7\u0086\n\7\f\7\16\7\u0089\13\7\3\7\3\7\3\7\3\7"+
		"\5\7\u008f\n\7\3\7\3\7\3\7\5\7\u0094\n\7\3\7\6\7\u0097\n\7\r\7\16\7\u0098"+
		"\3\7\7\7\u009c\n\7\f\7\16\7\u009f\13\7\3\7\5\7\u00a2\n\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00b6\n"+
		"\b\f\b\16\b\u00b9\13\b\3\b\3\b\3\b\3\b\5\b\u00bf\n\b\3\b\3\b\3\b\5\b\u00c4"+
		"\n\b\3\b\3\b\3\b\3\b\5\b\u00ca\n\b\3\b\3\b\3\b\3\b\5\b\u00d0\n\b\3\b\3"+
		"\b\3\b\3\b\5\b\u00d6\n\b\3\b\3\b\3\b\3\b\5\b\u00dc\n\b\3\b\3\b\3\b\3\b"+
		"\5\b\u00e2\n\b\3\b\3\b\3\b\3\b\5\b\u00e8\n\b\3\b\7\b\u00eb\n\b\f\b\16"+
		"\b\u00ee\13\b\3\t\3\t\3\t\3\t\7\t\u00f4\n\t\f\t\16\t\u00f7\13\t\3\t\3"+
		"\t\5\t\u00fb\n\t\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u0103\n\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u010b\n\n\3\n\3\n\3\n\3\n\5\n\u0111\n\n\3\n\3\n\3\n\3\n\5"+
		"\n\u0117\n\n\3\n\3\n\3\n\3\n\5\n\u011d\n\n\3\n\3\n\3\n\3\n\5\n\u0123\n"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u012d\n\n\3\n\3\n\3\n\3\n\5\n\u0133"+
		"\n\n\3\n\3\n\3\n\3\n\5\n\u0139\n\n\3\n\3\n\3\n\3\n\5\n\u013f\n\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u014e\n\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\n\u0156\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0161"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u016b\n\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\5\n\u0173\n\n\3\n\3\n\5\n\u0177\n\n\5\n\u0179\n\n\3\13\3\13\3\13"+
		"\7\13\u017e\n\13\f\13\16\13\u0181\13\13\3\f\3\f\3\f\7\f\u0186\n\f\f\f"+
		"\16\f\u0189\13\f\3\r\3\r\3\16\3\16\3\16\7\16\u0190\n\16\f\16\16\16\u0193"+
		"\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\5\20\u01a0"+
		"\n\20\3\20\6\20\u01a3\n\20\r\20\16\20\u01a4\3\20\5\20\u01a8\n\20\7\20"+
		"\u01aa\n\20\f\20\16\20\u01ad\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21"+
		"\u01c3\n\21\f\21\16\21\u01c6\13\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u01d5\n\21\f\21\16\21\u01d8\13\21"+
		"\3\21\3\21\7\21\u01dc\n\21\f\21\16\21\u01df\13\21\3\21\3\21\3\21\7\21"+
		"\u01e4\n\21\f\21\16\21\u01e7\13\21\3\21\3\21\7\21\u01eb\n\21\f\21\16\21"+
		"\u01ee\13\21\3\21\3\21\5\21\u01f2\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\5\21\u01fc\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u0206\n\21\3\21\3\21\3\21\3\21\3\21\7\21\u020d\n\21\f\21\16\21\u0210"+
		"\13\21\5\21\u0212\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0225\n\21\f\21\16\21\u0228"+
		"\13\21\3\21\3\21\3\21\3\21\5\21\u022e\n\21\3\21\7\21\u0231\n\21\f\21\16"+
		"\21\u0234\13\21\3\21\3\21\5\21\u0238\n\21\3\22\3\22\3\22\5\22\u023d\n"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0248\n\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0253\n\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\5\22\u025b\n\22\3\22\3\22\3\22\5\22\u0260\n\22\3\22\3"+
		"\22\3\22\3\22\5\22\u0266\n\22\3\22\3\22\3\22\3\22\5\22\u026c\n\22\3\22"+
		"\3\22\3\22\3\22\5\22\u0272\n\22\3\22\3\22\3\22\3\22\5\22\u0278\n\22\3"+
		"\22\3\22\3\22\3\22\5\22\u027e\n\22\3\22\7\22\u0281\n\22\f\22\16\22\u0284"+
		"\13\22\3\23\3\23\3\23\3\23\3\23\7\23\u028b\n\23\f\23\16\23\u028e\13\23"+
		"\3\23\3\23\7\23\u0292\n\23\f\23\16\23\u0295\13\23\3\23\5\23\u0298\n\23"+
		"\3\24\3\24\7\24\u029c\n\24\f\24\16\24\u029f\13\24\3\24\3\24\5\24\u02a3"+
		"\n\24\3\24\6\24\u02a6\n\24\r\24\16\24\u02a7\3\24\5\24\u02ab\n\24\7\24"+
		"\u02ad\n\24\f\24\16\24\u02b0\13\24\3\24\3\24\7\24\u02b4\n\24\f\24\16\24"+
		"\u02b7\13\24\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u02bf\n\25\f\25\16\25"+
		"\u02c2\13\25\3\26\3\26\3\26\5\26\u02c7\n\26\3\26\3\26\3\26\3\26\7\26\u02cd"+
		"\n\26\f\26\16\26\u02d0\13\26\5\26\u02d2\n\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\7\26\u02da\n\26\f\26\16\26\u02dd\13\26\3\26\3\26\3\26\7\26\u02e2"+
		"\n\26\f\26\16\26\u02e5\13\26\3\26\3\26\7\26\u02e9\n\26\f\26\16\26\u02ec"+
		"\13\26\3\26\3\26\5\26\u02f0\n\26\3\26\3\26\3\26\5\26\u02f5\n\26\3\26\7"+
		"\26\u02f8\n\26\f\26\16\26\u02fb\13\26\3\26\3\26\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\7\30\u0305\n\30\f\30\16\30\u0308\13\30\3\30\3\30\5\30\u030c\n"+
		"\30\3\30\7\30\u030f\n\30\f\30\16\30\u0312\13\30\3\30\5\30\u0315\n\30\3"+
		"\30\7\30\u0318\n\30\f\30\16\30\u031b\13\30\3\30\3\30\5\30\u031f\n\30\3"+
		"\30\7\30\u0322\n\30\f\30\16\30\u0325\13\30\3\30\3\30\3\31\3\31\7\31\u032b"+
		"\n\31\f\31\16\31\u032e\13\31\3\31\3\31\5\31\u0332\n\31\3\31\6\31\u0335"+
		"\n\31\r\31\16\31\u0336\3\31\5\31\u033a\n\31\7\31\u033c\n\31\f\31\16\31"+
		"\u033f\13\31\3\31\3\31\3\32\3\32\7\32\u0345\n\32\f\32\16\32\u0348\13\32"+
		"\3\32\3\32\5\32\u034c\n\32\3\32\6\32\u034f\n\32\r\32\16\32\u0350\3\32"+
		"\5\32\u0354\n\32\7\32\u0356\n\32\f\32\16\32\u0359\13\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\2\4\16\"\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\2\31\3\2\4\5\3\2\"%\3\2\n\r\3\2\16\17\3\2\23\25\3\2"+
		"\26\27\3\2\30\35\3\2\36!\3\2&(\3\2)+\3\2,.\3\2/\66\3\2\'(\3\2*+\3\2-."+
		"\3\2#%\4\2\f\rCC\3\2qr\3\2UV\3\2_`\4\2\27\27##\4\2\30\31\33\34\3\2\37"+
		" \u03f8\2\66\3\2\2\2\4B\3\2\2\2\6E\3\2\2\2\bg\3\2\2\2\ni\3\2\2\2\f\u00a1"+
		"\3\2\2\2\16\u00be\3\2\2\2\20\u00ef\3\2\2\2\22\u0178\3\2\2\2\24\u017a\3"+
		"\2\2\2\26\u0182\3\2\2\2\30\u018a\3\2\2\2\32\u018c\3\2\2\2\34\u0194\3\2"+
		"\2\2\36\u019f\3\2\2\2 \u0237\3\2\2\2\"\u025a\3\2\2\2$\u0297\3\2\2\2&\u0299"+
		"\3\2\2\2(\u02ba\3\2\2\2*\u02c3\3\2\2\2,\u02fe\3\2\2\2.\u0302\3\2\2\2\60"+
		"\u0328\3\2\2\2\62\u0342\3\2\2\2\64\u035c\3\2\2\2\668\5\b\5\2\679\5\n\6"+
		"\28\67\3\2\2\289\3\2\2\29=\3\2\2\2:<\7v\2\2;:\3\2\2\2<?\3\2\2\2=;\3\2"+
		"\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7\2\2\3A\3\3\2\2\2BC\5\n\6\2CD\7"+
		"\2\2\3D\5\3\2\2\2EF\5\34\17\2FG\7\2\2\3G\7\3\2\2\2HM\5\16\b\2IJ\7\3\2"+
		"\2JL\5\16\b\2KI\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NQ\3\2\2\2OM\3\2"+
		"\2\2PH\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\t\2\2\2SX\5\16\b\2TU\7\3\2\2UW\5"+
		"\16\b\2VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Yh\3\2\2\2ZX\3\2\2\2[]"+
		"\5\16\b\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2"+
		"\2ac\7o\2\2bd\5\16\b\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2"+
		"\2gP\3\2\2\2g^\3\2\2\2h\t\3\2\2\2ik\7\6\2\2jl\5\f\7\2kj\3\2\2\2kl\3\2"+
		"\2\2lw\3\2\2\2mo\7v\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2"+
		"\2\2rt\5\f\7\2sr\3\2\2\2st\3\2\2\2tv\3\2\2\2un\3\2\2\2vy\3\2\2\2wu\3\2"+
		"\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7\7\2\2{\13\3\2\2\2|}\7q\2\2}~\7"+
		"\b\2\2~\177\5\16\b\2\177\u0080\5\22\n\2\u0080\u00a2\3\2\2\2\u0081\u0082"+
		"\7q\2\2\u0082\u0083\7\b\2\2\u0083\u0087\7\6\2\2\u0084\u0086\7v\2\2\u0085"+
		"\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7q\2\2\u008b"+
		"\u0093\7\b\2\2\u008c\u0094\7r\2\2\u008d\u008f\7r\2\2\u008e\u008d\3\2\2"+
		"\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\5\16\b\2\u0091"+
		"\u0092\7\t\2\2\u0092\u0094\3\2\2\2\u0093\u008c\3\2\2\2\u0093\u008e\3\2"+
		"\2\2\u0094\u009d\3\2\2\2\u0095\u0097\7v\2\2\u0096\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009c\5\f\7\2\u009b\u0096\3\2\2\2\u009c\u009f\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u00a0\u00a2\7\7\2\2\u00a1|\3\2\2\2\u00a1\u0081\3\2\2\2\u00a2\r\3"+
		"\2\2\2\u00a3\u00a4\b\b\1\2\u00a4\u00a5\7\27\2\2\u00a5\u00bf\5\16\b\b\u00a6"+
		"\u00a7\t\3\2\2\u00a7\u00bf\5\16\b\7\u00a8\u00bf\t\4\2\2\u00a9\u00bf\t"+
		"\5\2\2\u00aa\u00bf\7r\2\2\u00ab\u00ac\7\20\2\2\u00ac\u00ad\5\16\b\2\u00ad"+
		"\u00ae\7\21\2\2\u00ae\u00bf\3\2\2\2\u00af\u00bf\7\22\2\2\u00b0\u00b1\7"+
		"r\2\2\u00b1\u00b2\7\20\2\2\u00b2\u00b7\5\16\b\2\u00b3\u00b4\7\3\2\2\u00b4"+
		"\u00b6\5\16\b\2\u00b5\u00b3\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3"+
		"\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba"+
		"\u00bb\7\21\2\2\u00bb\u00bf\3\2\2\2\u00bc\u00bf\7p\2\2\u00bd\u00bf\5\20"+
		"\t\2\u00be\u00a3\3\2\2\2\u00be\u00a6\3\2\2\2\u00be\u00a8\3\2\2\2\u00be"+
		"\u00a9\3\2\2\2\u00be\u00aa\3\2\2\2\u00be\u00ab\3\2\2\2\u00be\u00af\3\2"+
		"\2\2\u00be\u00b0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf"+
		"\u00ec\3\2\2\2\u00c0\u00c1\f\f\2\2\u00c1\u00c3\t\6\2\2\u00c2\u00c4\7v"+
		"\2\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00eb\5\16\b\r\u00c6\u00c7\f\13\2\2\u00c7\u00c9\t\7\2\2\u00c8\u00ca\7"+
		"v\2\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00eb\5\16\b\f\u00cc\u00cd\f\n\2\2\u00cd\u00cf\t\b\2\2\u00ce\u00d0\7"+
		"v\2\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00eb\5\16\b\13\u00d2\u00d3\f\t\2\2\u00d3\u00d5\t\t\2\2\u00d4\u00d6\7"+
		"v\2\2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7"+
		"\u00eb\5\16\b\n\u00d8\u00d9\f\6\2\2\u00d9\u00db\t\n\2\2\u00da\u00dc\7"+
		"v\2\2\u00db\u00da\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00eb\5\16\b\7\u00de\u00df\f\5\2\2\u00df\u00e1\t\13\2\2\u00e0\u00e2\7"+
		"v\2\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00eb\5\16\b\6\u00e4\u00e5\f\4\2\2\u00e5\u00e7\t\f\2\2\u00e6\u00e8\7"+
		"v\2\2\u00e7\u00e6\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\u00eb\5\16\b\5\u00ea\u00c0\3\2\2\2\u00ea\u00c6\3\2\2\2\u00ea\u00cc\3"+
		"\2\2\2\u00ea\u00d2\3\2\2\2\u00ea\u00d8\3\2\2\2\u00ea\u00de\3\2\2\2\u00ea"+
		"\u00e4\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed\17\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\t\r\2\2\u00f0\u00f5"+
		"\7r\2\2\u00f1\u00f2\7\3\2\2\u00f2\u00f4\7r\2\2\u00f3\u00f1\3\2\2\2\u00f4"+
		"\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2"+
		"\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00fa\7\67\2\2\u00f9\u00fb\7v\2\2\u00fa"+
		"\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\5\16"+
		"\b\2\u00fd\21\3\2\2\2\u00fe\u0179\78\2\2\u00ff\u0103\79\2\2\u0100\u0101"+
		"\t\16\2\2\u0101\u0103\7z\2\2\u0102\u00ff\3\2\2\2\u0102\u0100\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\u0105\7q\2\2\u0105\u0106\7\3\2\2\u0106\u0179\7q\2"+
		"\2\u0107\u010b\7:\2\2\u0108\u0109\t\16\2\2\u0109\u010b\7~\2\2\u010a\u0107"+
		"\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u0179\7q\2\2\u010d"+
		"\u0111\7;\2\2\u010e\u010f\t\16\2\2\u010f\u0111\7\177\2\2\u0110\u010d\3"+
		"\2\2\2\u0110\u010e\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0179\7q\2\2\u0113"+
		"\u0117\7<\2\2\u0114\u0115\t\17\2\2\u0115\u0117\7{\2\2\u0116\u0113\3\2"+
		"\2\2\u0116\u0114\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0179\7q\2\2\u0119"+
		"\u011d\7=\2\2\u011a\u011b\t\17\2\2\u011b\u011d\7|\2\2\u011c\u0119\3\2"+
		"\2\2\u011c\u011a\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0179\7q\2\2\u011f"+
		"\u0123\7>\2\2\u0120\u0121\t\17\2\2\u0121\u0123\7}\2\2\u0122\u011f\3\2"+
		"\2\2\u0122\u0120\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\7q\2\2\u0125"+
		"\u0126\7\3\2\2\u0126\u0127\7q\2\2\u0127\u0128\7\3\2\2\u0128\u0179\7q\2"+
		"\2\u0129\u012d\7?\2\2\u012a\u012b\t\20\2\2\u012b\u012d\7z\2\2\u012c\u0129"+
		"\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0179\7q\2\2\u012f"+
		"\u0133\7@\2\2\u0130\u0131\t\20\2\2\u0131\u0133\7}\2\2\u0132\u012f\3\2"+
		"\2\2\u0132\u0130\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0179\7q\2\2\u0135"+
		"\u0139\7A\2\2\u0136\u0137\t\21\2\2\u0137\u0139\7z\2\2\u0138\u0135\3\2"+
		"\2\2\u0138\u0136\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u0179\7q\2\2\u013b"+
		"\u013f\7B\2\2\u013c\u013d\t\21\2\2\u013d\u013f\7}\2\2\u013e\u013b\3\2"+
		"\2\2\u013e\u013c\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\7q\2\2\u0141"+
		"\u0142\7\3\2\2\u0142\u0179\7q\2\2\u0143\u0144\t\22\2\2\u0144\u0145\7}"+
		"\2\2\u0145\u0179\7q\2\2\u0146\u0147\7D\2\2\u0147\u0179\7q\2\2\u0148\u014e"+
		"\7E\2\2\u0149\u014e\7F\2\2\u014a\u014e\7G\2\2\u014b\u014c\7\62\2\2\u014c"+
		"\u014e\7z\2\2\u014d\u0148\3\2\2\2\u014d\u0149\3\2\2\2\u014d\u014a\3\2"+
		"\2\2\u014d\u014b\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0179\7q\2\2\u0150"+
		"\u0156\7H\2\2\u0151\u0156\7I\2\2\u0152\u0156\7J\2\2\u0153\u0154\7\62\2"+
		"\2\u0154\u0156\7}\2\2\u0155\u0150\3\2\2\2\u0155\u0151\3\2\2\2\u0155\u0152"+
		"\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\5\30\r\2"+
		"\u0158\u0159\7\3\2\2\u0159\u015a\5\26\f\2\u015a\u0179\3\2\2\2\u015b\u0161"+
		"\7K\2\2\u015c\u0161\7L\2\2\u015d\u0161\7M\2\2\u015e\u015f\7\66\2\2\u015f"+
		"\u0161\7z\2\2\u0160\u015b\3\2\2\2\u0160\u015c\3\2\2\2\u0160\u015d\3\2"+
		"\2\2\u0160\u015e\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\7q\2\2\u0163"+
		"\u0164\7\3\2\2\u0164\u0179\5\32\16\2\u0165\u016b\7N\2\2\u0166\u016b\7"+
		"O\2\2\u0167\u016b\7P\2\2\u0168\u0169\7\66\2\2\u0169\u016b\7}\2\2\u016a"+
		"\u0165\3\2\2\2\u016a\u0166\3\2\2\2\u016a\u0167\3\2\2\2\u016a\u0168\3\2"+
		"\2\2\u016b\u016c\3\2\2\2\u016c\u016d\5\30\r\2\u016d\u016e\7\3\2\2\u016e"+
		"\u016f\7q\2\2\u016f\u0179\3\2\2\2\u0170\u0172\7Q\2\2\u0171\u0173\5\24"+
		"\13\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0179\3\2\2\2\u0174"+
		"\u0176\7R\2\2\u0175\u0177\5\26\f\2\u0176\u0175\3\2\2\2\u0176\u0177\3\2"+
		"\2\2\u0177\u0179\3\2\2\2\u0178\u00fe\3\2\2\2\u0178\u0102\3\2\2\2\u0178"+
		"\u010a\3\2\2\2\u0178\u0110\3\2\2\2\u0178\u0116\3\2\2\2\u0178\u011c\3\2"+
		"\2\2\u0178\u0122\3\2\2\2\u0178\u012c\3\2\2\2\u0178\u0132\3\2\2\2\u0178"+
		"\u0138\3\2\2\2\u0178\u013e\3\2\2\2\u0178\u0143\3\2\2\2\u0178\u0146\3\2"+
		"\2\2\u0178\u014d\3\2\2\2\u0178\u0155\3\2\2\2\u0178\u0160\3\2\2\2\u0178"+
		"\u016a\3\2\2\2\u0178\u0170\3\2\2\2\u0178\u0174\3\2\2\2\u0179\23\3\2\2"+
		"\2\u017a\u017f\7q\2\2\u017b\u017c\7\3\2\2\u017c\u017e\7q\2\2\u017d\u017b"+
		"\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180"+
		"\25\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0187\5\30\r\2\u0183\u0184\7\3\2"+
		"\2\u0184\u0186\5\30\r\2\u0185\u0183\3\2\2\2\u0186\u0189\3\2\2\2\u0187"+
		"\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188\27\3\2\2\2\u0189\u0187\3\2\2"+
		"\2\u018a\u018b\t\23\2\2\u018b\31\3\2\2\2\u018c\u0191\7r\2\2\u018d\u018e"+
		"\7\3\2\2\u018e\u0190\7r\2\2\u018f\u018d\3\2\2\2\u0190\u0193\3\2\2\2\u0191"+
		"\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\33\3\2\2\2\u0193\u0191\3\2\2"+
		"\2\u0194\u0195\7S\2\2\u0195\u0196\7\u0080\2\2\u0196\u0197\7\b\2\2\u0197"+
		"\u0198\7\u0081\2\2\u0198\u0199\7\b\2\2\u0199\u019a\7\u0082\2\2\u019a\u019b"+
		"\7\b\2\2\u019b\u019c\7T\2\2\u019c\u019d\5\36\20\2\u019d\35\3\2\2\2\u019e"+
		"\u01a0\5 \21\2\u019f\u019e\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01ab\3\2"+
		"\2\2\u01a1\u01a3\7v\2\2\u01a2\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4"+
		"\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a7\3\2\2\2\u01a6\u01a8\5 "+
		"\21\2\u01a7\u01a6\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01aa\3\2\2\2\u01a9"+
		"\u01a2\3\2\2\2\u01aa\u01ad\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2"+
		"\2\2\u01ac\37\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ae\u01af\t\24\2\2\u01af\u01b0"+
		"\7r\2\2\u01b0\u01b1\7W\2\2\u01b1\u01b2\5$\23\2\u01b2\u01b3\7\36\2\2\u01b3"+
		"\u01b4\5\"\22\2\u01b4\u0238\3\2\2\2\u01b5\u01b6\7r\2\2\u01b6\u01b7\7\36"+
		"\2\2\u01b7\u0238\5\"\22\2\u01b8\u01b9\7X\2\2\u01b9\u01ba\7\20\2\2\u01ba"+
		"\u01bb\5\"\22\2\u01bb\u01bc\7\21\2\2\u01bc\u0238\3\2\2\2\u01bd\u01be\7"+
		"Y\2\2\u01be\u01bf\7\20\2\2\u01bf\u01c0\5\"\22\2\u01c0\u01c4\7\21\2\2\u01c1"+
		"\u01c3\7v\2\2\u01c2\u01c1\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2"+
		"\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7"+
		"\u01c8\7\6\2\2\u01c8\u01c9\5\36\20\2\u01c9\u01ca\7\7\2\2\u01ca\u01cb\7"+
		"Z\2\2\u01cb\u01cc\7\6\2\2\u01cc\u01cd\5\36\20\2\u01cd\u01ce\7\7\2\2\u01ce"+
		"\u0238\3\2\2\2\u01cf\u01d0\7[\2\2\u01d0\u01d1\7\20\2\2\u01d1\u01d2\5\""+
		"\22\2\u01d2\u01d6\7\21\2\2\u01d3\u01d5\7v\2\2\u01d4\u01d3\3\2\2\2\u01d5"+
		"\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d9\3\2"+
		"\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01f1\7\6\2\2\u01da\u01dc\7v\2\2\u01db"+
		"\u01da\3\2\2\2\u01dc\u01df\3\2\2\2\u01dd\u01db\3\2\2\2\u01dd\u01de\3\2"+
		"\2\2\u01de\u01e0\3\2\2\2\u01df\u01dd\3\2\2\2\u01e0\u01e1\7\\\2\2\u01e1"+
		"\u01e5\7]\2\2\u01e2\u01e4\7v\2\2\u01e3\u01e2\3\2\2\2\u01e4\u01e7\3\2\2"+
		"\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e8\3\2\2\2\u01e7\u01e5"+
		"\3\2\2\2\u01e8\u01ec\5&\24\2\u01e9\u01eb\7v\2\2\u01ea\u01e9\3\2\2\2\u01eb"+
		"\u01ee\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ef\3\2"+
		"\2\2\u01ee\u01ec\3\2\2\2\u01ef\u01f0\7]\2\2\u01f0\u01f2\3\2\2\2\u01f1"+
		"\u01dd\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\5\36"+
		"\20\2\u01f4\u01f5\7\7\2\2\u01f5\u0238\3\2\2\2\u01f6\u01f7\7r\2\2\u01f7"+
		"\u01f8\7\36\2\2\u01f8\u01f9\7^\2\2\u01f9\u01fb\7\20\2\2\u01fa\u01fc\7"+
		"s\2\2\u01fb\u01fa\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd"+
		"\u0238\7\21\2\2\u01fe\u01ff\t\25\2\2\u01ff\u0200\7\20\2\2\u0200\u0201"+
		"\7a\2\2\u0201\u0202\7s\2\2\u0202\u0238\7\21\2\2\u0203\u0204\7r\2\2\u0204"+
		"\u0206\7\36\2\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0207\3"+
		"\2\2\2\u0207\u0208\7r\2\2\u0208\u0211\7\20\2\2\u0209\u020e\5\"\22\2\u020a"+
		"\u020b\7\3\2\2\u020b\u020d\5\"\22\2\u020c\u020a\3\2\2\2\u020d\u0210\3"+
		"\2\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0212\3\2\2\2\u0210"+
		"\u020e\3\2\2\2\u0211\u0209\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213\3\2"+
		"\2\2\u0213\u0238\7\21\2\2\u0214\u0215\7r\2\2\u0215\u0216\7\36\2\2\u0216"+
		"\u0217\7r\2\2\u0217\u0218\7\b\2\2\u0218\u0238\7b\2\2\u0219\u021a\7r\2"+
		"\2\u021a\u021b\7\20\2\2\u021b\u021c\5\"\22\2\u021c\u021d\7\21\2\2\u021d"+
		"\u021e\7\36\2\2\u021e\u021f\5\"\22\2\u021f\u0238\3\2\2\2\u0220\u0238\5"+
		"*\26\2\u0221\u0222\7\\\2\2\u0222\u0226\7]\2\2\u0223\u0225\7v\2\2\u0224"+
		"\u0223\3\2\2\2\u0225\u0228\3\2\2\2\u0226\u0224\3\2\2\2\u0226\u0227\3\2"+
		"\2\2\u0227\u022d\3\2\2\2\u0228\u0226\3\2\2\2\u0229\u022e\5\n\6\2\u022a"+
		"\u022e\5\b\5\2\u022b\u022e\5\60\31\2\u022c\u022e\5\62\32\2\u022d\u0229"+
		"\3\2\2\2\u022d\u022a\3\2\2\2\u022d\u022b\3\2\2\2\u022d\u022c\3\2\2\2\u022e"+
		"\u0232\3\2\2\2\u022f\u0231\7v\2\2\u0230\u022f\3\2\2\2\u0231\u0234\3\2"+
		"\2\2\u0232\u0230\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0235\3\2\2\2\u0234"+
		"\u0232\3\2\2\2\u0235\u0236\7]\2\2\u0236\u0238\3\2\2\2\u0237\u01ae\3\2"+
		"\2\2\u0237\u01b5\3\2\2\2\u0237\u01b8\3\2\2\2\u0237\u01bd\3\2\2\2\u0237"+
		"\u01cf\3\2\2\2\u0237\u01f6\3\2\2\2\u0237\u01fe\3\2\2\2\u0237\u0205\3\2"+
		"\2\2\u0237\u0214\3\2\2\2\u0237\u0219\3\2\2\2\u0237\u0220\3\2\2\2\u0237"+
		"\u0221\3\2\2\2\u0238!\3\2\2\2\u0239\u023a\b\22\1\2\u023a\u023c\t\26\2"+
		"\2\u023b\u023d\7v\2\2\u023c\u023b\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u023e"+
		"\3\2\2\2\u023e\u025b\5\"\22\t\u023f\u025b\7\16\2\2\u0240\u025b\7\n\2\2"+
		"\u0241\u025b\7p\2\2\u0242\u0247\7r\2\2\u0243\u0244\7\20\2\2\u0244\u0245"+
		"\5\"\22\2\u0245\u0246\7\21\2\2\u0246\u0248\3\2\2\2\u0247\u0243\3\2\2\2"+
		"\u0247\u0248\3\2\2\2\u0248\u025b\3\2\2\2\u0249\u024a\7c\2\2\u024a\u024b"+
		"\7\20\2\2\u024b\u024c\7s\2\2\u024c\u025b\7\21\2\2\u024d\u024e\7d\2\2\u024e"+
		"\u024f\7\20\2\2\u024f\u0252\5\"\22\2\u0250\u0251\7\3\2\2\u0251\u0253\5"+
		"\"\22\2\u0252\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0254\3\2\2\2\u0254"+
		"\u0255\7\21\2\2\u0255\u025b\3\2\2\2\u0256\u0257\7\20\2\2\u0257\u0258\5"+
		"\"\22\2\u0258\u0259\7\21\2\2\u0259\u025b\3\2\2\2\u025a\u0239\3\2\2\2\u025a"+
		"\u023f\3\2\2\2\u025a\u0240\3\2\2\2\u025a\u0241\3\2\2\2\u025a\u0242\3\2"+
		"\2\2\u025a\u0249\3\2\2\2\u025a\u024d\3\2\2\2\u025a\u0256\3\2\2\2\u025b"+
		"\u0282\3\2\2\2\u025c\u025d\f\b\2\2\u025d\u025f\t\6\2\2\u025e\u0260\7v"+
		"\2\2\u025f\u025e\3\2\2\2\u025f\u0260\3\2\2\2\u0260\u0261\3\2\2\2\u0261"+
		"\u0281\5\"\22\t\u0262\u0263\f\7\2\2\u0263\u0265\t\7\2\2\u0264\u0266\7"+
		"v\2\2\u0265\u0264\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0267\3\2\2\2\u0267"+
		"\u0281\5\"\22\b\u0268\u0269\f\6\2\2\u0269\u026b\t\27\2\2\u026a\u026c\7"+
		"v\2\2\u026b\u026a\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026d\3\2\2\2\u026d"+
		"\u0281\5\"\22\7\u026e\u026f\f\5\2\2\u026f\u0271\t\30\2\2\u0270\u0272\7"+
		"v\2\2\u0271\u0270\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0273\3\2\2\2\u0273"+
		"\u0281\5\"\22\6\u0274\u0275\f\4\2\2\u0275\u0277\7\'\2\2\u0276\u0278\7"+
		"v\2\2\u0277\u0276\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u0279\3\2\2\2\u0279"+
		"\u0281\5\"\22\5\u027a\u027b\f\3\2\2\u027b\u027d\7*\2\2\u027c\u027e\7v"+
		"\2\2\u027d\u027c\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u027f\3\2\2\2\u027f"+
		"\u0281\5\"\22\4\u0280\u025c\3\2\2\2\u0280\u0262\3\2\2\2\u0280\u0268\3"+
		"\2\2\2\u0280\u026e\3\2\2\2\u0280\u0274\3\2\2\2\u0280\u027a\3\2\2\2\u0281"+
		"\u0284\3\2\2\2\u0282\u0280\3\2\2\2\u0282\u0283\3\2\2\2\u0283#\3\2\2\2"+
		"\u0284\u0282\3\2\2\2\u0285\u0298\7e\2\2\u0286\u0298\7c\2\2\u0287\u0288"+
		"\7d\2\2\u0288\u028c\7f\2\2\u0289\u028b\7v\2\2\u028a\u0289\3\2\2\2\u028b"+
		"\u028e\3\2\2\2\u028c\u028a\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u028f\3\2"+
		"\2\2\u028e\u028c\3\2\2\2\u028f\u0293\7c\2\2\u0290\u0292\7v\2\2\u0291\u0290"+
		"\3\2\2\2\u0292\u0295\3\2\2\2\u0293\u0291\3\2\2\2\u0293\u0294\3\2\2\2\u0294"+
		"\u0296\3\2\2\2\u0295\u0293\3\2\2\2\u0296\u0298\7g\2\2\u0297\u0285\3\2"+
		"\2\2\u0297\u0286\3\2\2\2\u0297\u0287\3\2\2\2\u0298%\3\2\2\2\u0299\u029d"+
		"\7\6\2\2\u029a\u029c\7v\2\2\u029b\u029a\3\2\2\2\u029c\u029f\3\2\2\2\u029d"+
		"\u029b\3\2\2\2\u029d\u029e\3\2\2\2\u029e\u02a0\3\2\2\2\u029f\u029d\3\2"+
		"\2\2\u02a0\u02a2\7h\2\2\u02a1\u02a3\5\16\b\2\u02a2\u02a1\3\2\2\2\u02a2"+
		"\u02a3\3\2\2\2\u02a3\u02ae\3\2\2\2\u02a4\u02a6\7v\2\2\u02a5\u02a4\3\2"+
		"\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02a5\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8"+
		"\u02aa\3\2\2\2\u02a9\u02ab\5\16\b\2\u02aa\u02a9\3\2\2\2\u02aa\u02ab\3"+
		"\2\2\2\u02ab\u02ad\3\2\2\2\u02ac\u02a5\3\2\2\2\u02ad\u02b0\3\2\2\2\u02ae"+
		"\u02ac\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b1\3\2\2\2\u02b0\u02ae\3\2"+
		"\2\2\u02b1\u02b5\5(\25\2\u02b2\u02b4\7v\2\2\u02b3\u02b2\3\2\2\2\u02b4"+
		"\u02b7\3\2\2\2\u02b5\u02b3\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b8\3\2"+
		"\2\2\u02b7\u02b5\3\2\2\2\u02b8\u02b9\7\7\2\2\u02b9\'\3\2\2\2\u02ba\u02bb"+
		"\7i\2\2\u02bb\u02c0\7r\2\2\u02bc\u02bd\7\3\2\2\u02bd\u02bf\7r\2\2\u02be"+
		"\u02bc\3\2\2\2\u02bf\u02c2\3\2\2\2\u02c0\u02be\3\2\2\2\u02c0\u02c1\3\2"+
		"\2\2\u02c1)\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c3\u02c4\7j\2\2\u02c4\u02c6"+
		"\7r\2\2\u02c5\u02c7\7v\2\2\u02c6\u02c5\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7"+
		"\u02c8\3\2\2\2\u02c8\u02d1\7\20\2\2\u02c9\u02ce\5,\27\2\u02ca\u02cb\7"+
		"\3\2\2\u02cb\u02cd\5,\27\2\u02cc\u02ca\3\2\2\2\u02cd\u02d0\3\2\2\2\u02ce"+
		"\u02cc\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf\u02d2\3\2\2\2\u02d0\u02ce\3\2"+
		"\2\2\u02d1\u02c9\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3"+
		"\u02d4\7\21\2\2\u02d4\u02d5\7W\2\2\u02d5\u02d6\5$\23\2\u02d6\u02d7\7\36"+
		"\2\2\u02d7\u02ef\7\6\2\2\u02d8\u02da\7v\2\2\u02d9\u02d8\3\2\2\2\u02da"+
		"\u02dd\3\2\2\2\u02db\u02d9\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02de\3\2"+
		"\2\2\u02dd\u02db\3\2\2\2\u02de\u02df\7\\\2\2\u02df\u02e3\7]\2\2\u02e0"+
		"\u02e2\7v\2\2\u02e1\u02e0\3\2\2\2\u02e2\u02e5\3\2\2\2\u02e3\u02e1\3\2"+
		"\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e6\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e6"+
		"\u02ea\5.\30\2\u02e7\u02e9\7v\2\2\u02e8\u02e7\3\2\2\2\u02e9\u02ec\3\2"+
		"\2\2\u02ea\u02e8\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ed\3\2\2\2\u02ec"+
		"\u02ea\3\2\2\2\u02ed\u02ee\7]\2\2\u02ee\u02f0\3\2\2\2\u02ef\u02db\3\2"+
		"\2\2\u02ef\u02f0\3\2\2\2\u02f0\u02f1\3\2\2\2\u02f1\u02f2\5\36\20\2\u02f2"+
		"\u02f4\7k\2\2\u02f3\u02f5\5\"\22\2\u02f4\u02f3\3\2\2\2\u02f4\u02f5\3\2"+
		"\2\2\u02f5\u02f9\3\2\2\2\u02f6\u02f8\7v\2\2\u02f7\u02f6\3\2\2\2\u02f8"+
		"\u02fb\3\2\2\2\u02f9\u02f7\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa\u02fc\3\2"+
		"\2\2\u02fb\u02f9\3\2\2\2\u02fc\u02fd\7\7\2\2\u02fd+\3\2\2\2\u02fe\u02ff"+
		"\7r\2\2\u02ff\u0300\7W\2\2\u0300\u0301\5$\23\2\u0301-\3\2\2\2\u0302\u0306"+
		"\7\6\2\2\u0303\u0305\7v\2\2\u0304\u0303\3\2\2\2\u0305\u0308\3\2\2\2\u0306"+
		"\u0304\3\2\2\2\u0306\u0307\3\2\2\2\u0307\u030b\3\2\2\2\u0308\u0306\3\2"+
		"\2\2\u0309\u030a\7l\2\2\u030a\u030c\5\16\b\2\u030b\u0309\3\2\2\2\u030b"+
		"\u030c\3\2\2\2\u030c\u0310\3\2\2\2\u030d\u030f\7v\2\2\u030e\u030d\3\2"+
		"\2\2\u030f\u0312\3\2\2\2\u0310\u030e\3\2\2\2\u0310\u0311\3\2\2\2\u0311"+
		"\u0314\3\2\2\2\u0312\u0310\3\2\2\2\u0313\u0315\5(\25\2\u0314\u0313\3\2"+
		"\2\2\u0314\u0315\3\2\2\2\u0315\u0319\3\2\2\2\u0316\u0318\7v\2\2\u0317"+
		"\u0316\3\2\2\2\u0318\u031b\3\2\2\2\u0319\u0317\3\2\2\2\u0319\u031a\3\2"+
		"\2\2\u031a\u031e\3\2\2\2\u031b\u0319\3\2\2\2\u031c\u031d\7m\2\2\u031d"+
		"\u031f\5\16\b\2\u031e\u031c\3\2\2\2\u031e\u031f\3\2\2\2\u031f\u0323\3"+
		"\2\2\2\u0320\u0322\7v\2\2\u0321\u0320\3\2\2\2\u0322\u0325\3\2\2\2\u0323"+
		"\u0321\3\2\2\2\u0323\u0324\3\2\2\2\u0324\u0326\3\2\2\2\u0325\u0323\3\2"+
		"\2\2\u0326\u0327\7\7\2\2\u0327/\3\2\2\2\u0328\u032c\7\6\2\2\u0329\u032b"+
		"\7v\2\2\u032a\u0329\3\2\2\2\u032b\u032e\3\2\2\2\u032c\u032a\3\2\2\2\u032c"+
		"\u032d\3\2\2\2\u032d\u032f\3\2\2\2\u032e\u032c\3\2\2\2\u032f\u0331\7h"+
		"\2\2\u0330\u0332\5\16\b\2\u0331\u0330\3\2\2\2\u0331\u0332\3\2\2\2\u0332"+
		"\u033d\3\2\2\2\u0333\u0335\7v\2\2\u0334\u0333\3\2\2\2\u0335\u0336\3\2"+
		"\2\2\u0336\u0334\3\2\2\2\u0336\u0337\3\2\2\2\u0337\u0339\3\2\2\2\u0338"+
		"\u033a\5\16\b\2\u0339\u0338\3\2\2\2\u0339\u033a\3\2\2\2\u033a\u033c\3"+
		"\2\2\2\u033b\u0334\3\2\2\2\u033c\u033f\3\2\2\2\u033d\u033b\3\2\2\2\u033d"+
		"\u033e\3\2\2\2\u033e\u0340\3\2\2\2\u033f\u033d\3\2\2\2\u0340\u0341\7\7"+
		"\2\2\u0341\61\3\2\2\2\u0342\u0346\7\6\2\2\u0343\u0345\7v\2\2\u0344\u0343"+
		"\3\2\2\2\u0345\u0348\3\2\2\2\u0346\u0344\3\2\2\2\u0346\u0347\3\2\2\2\u0347"+
		"\u0349\3\2\2\2\u0348\u0346\3\2\2\2\u0349\u034b\7n\2\2\u034a\u034c\5\64"+
		"\33\2\u034b\u034a\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u0357\3\2\2\2\u034d"+
		"\u034f\7v\2\2\u034e\u034d\3\2\2\2\u034f\u0350\3\2\2\2\u0350\u034e\3\2"+
		"\2\2\u0350\u0351\3\2\2\2\u0351\u0353\3\2\2\2\u0352\u0354\5\64\33\2\u0353"+
		"\u0352\3\2\2\2\u0353\u0354\3\2\2\2\u0354\u0356\3\2\2\2\u0355\u034e\3\2"+
		"\2\2\u0356\u0359\3\2\2\2\u0357\u0355\3\2\2\2\u0357\u0358\3\2\2\2\u0358"+
		"\u035a\3\2\2\2\u0359\u0357\3\2\2\2\u035a\u035b\7\7\2\2\u035b\63\3\2\2"+
		"\2\u035c\u035d\7r\2\2\u035d\u035e\7\b\2\2\u035e\u035f\5\20\t\2\u035f\65"+
		"\3\2\2\2w8=MPX^egkpsw\u0087\u008e\u0093\u0098\u009d\u00a1\u00b7\u00be"+
		"\u00c3\u00c9\u00cf\u00d5\u00db\u00e1\u00e7\u00ea\u00ec\u00f5\u00fa\u0102"+
		"\u010a\u0110\u0116\u011c\u0122\u012c\u0132\u0138\u013e\u014d\u0155\u0160"+
		"\u016a\u0172\u0176\u0178\u017f\u0187\u0191\u019f\u01a4\u01a7\u01ab\u01c4"+
		"\u01d6\u01dd\u01e5\u01ec\u01f1\u01fb\u0205\u020e\u0211\u0226\u022d\u0232"+
		"\u0237\u023c\u0247\u0252\u025a\u025f\u0265\u026b\u0271\u0277\u027d\u0280"+
		"\u0282\u028c\u0293\u0297\u029d\u02a2\u02a7\u02aa\u02ae\u02b5\u02c0\u02c6"+
		"\u02ce\u02d1\u02db\u02e3\u02ea\u02ef\u02f4\u02f9\u0306\u030b\u0310\u0314"+
		"\u0319\u031e\u0323\u032c\u0331\u0336\u0339\u033d\u0346\u034b\u0350\u0353"+
		"\u0357";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}