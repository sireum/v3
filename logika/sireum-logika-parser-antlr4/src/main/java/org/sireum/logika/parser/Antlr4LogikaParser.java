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
		T__113=114, T__114=115, T__115=116, T__116=117, T__117=118, T__118=119, 
		T__119=120, T__120=121, HLINE=122, NUM=123, ID=124, STRING=125, RESERVED=126, 
		NL=127, LINE_COMMENT=128, COMMENT=129, WS=130, ERROR_CHAR=131;
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
		"'T'", "'⊤'", "'false'", "'F'", "'_|_'", "'⊥'", "'('", "')'", "'result'", 
		"'Z'", "'ZS'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<'", "'<='", "'≤'", 
		"'>'", "'>='", "'≥'", "'='", "'=='", "'!='", "'≠'", "'not'", "'!'", "'~'", 
		"'¬'", "'and'", "'&&'", "'^'", "'∧'", "'or'", "'||'", "'V'", "'∨'", "'implies'", 
		"'->'", "'→'", "'forall'", "'all'", "'A'", "'∀'", "'exists'", "'some'", 
		"'E'", "'∃'", "':'", "'..'", "'|'", "'B'", "'premise'", "'andi'", "'^i'", 
		"'ande1'", "'^e1'", "'ande2'", "'^e2'", "'ori1'", "'Vi1'", "'ori2'", "'Vi2'", 
		"'ore'", "'Ve'", "'impliesi'", "'impliese'", "'noti'", "'negi'", "'note'", 
		"'nege'", "'bottome'", "'falsee'", "'Pbc'", "'foralli'", "'alli'", "'Ai'", 
		"'foralle'", "'alle'", "'Ae'", "'existsi'", "'somei'", "'Ei'", "'existse'", 
		"'somee'", "'Ee'", "'algebra'", "'invariant'", "'auto'", "'import'", "'logika'", 
		"'_'", "'\"\"\"'", "'fact'", "'def'", "'var'", "'val'", "'assert'", "'if'", 
		"'else'", "'while'", "'print'", "'println'", "'Unit'", "'return'", "'readInt'", 
		"'+:'", "'modifies'", "'requires'", "'pre'", "'ensures'", "'post'"
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
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "HLINE", "NUM", "ID", "STRING", "RESERVED", "NL", "LINE_COMMENT", 
		"COMMENT", "WS", "ERROR_CHAR"
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
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56))) != 0) || _la==NUM || _la==ID) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56))) != 0) || _la==NUM || _la==ID) {
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56))) != 0) || _la==NUM || _la==ID );
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
		public Token ate;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
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
			int _alt;
			setState(177);
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
				setState(161);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(153);
					match(ID);
					}
					break;
				case 2:
					{
					setState(154);
					formula(0);
					setState(155);
					((SubProofContext)_localctx).ate = match(T__6);
					}
					break;
				case 3:
					{
					setState(157);
					match(ID);
					setState(158);
					formula(0);
					setState(159);
					((SubProofContext)_localctx).ate = match(T__6);
					}
					break;
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(164); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(163);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(166); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(169);
					_la = _input.LA(1);
					if (_la==NUM) {
						{
						setState(168);
						proofStep();
						}
					}

					}
					}
					setState(175);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(176);
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
	public static class BigIntContext extends FormulaContext {
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public BigIntContext(FormulaContext ctx) { copyFrom(ctx); }
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
	public static class SeqContext extends FormulaContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SeqContext(FormulaContext ctx) { copyFrom(ctx); }
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
			setState(226);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(180);
				((UnaryContext)_localctx).op = match(T__23);
				setState(181);
				formula(6);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(183);
				formula(5);
				}
				break;
			case 3:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
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
				setState(185);
				((VarContext)_localctx).tb = match(ID);
				setState(188);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(186);
					match(T__5);
					setState(187);
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
				setState(190);
				match(T__14);
				setState(191);
				formula(0);
				setState(192);
				match(T__15);
				}
				break;
			case 6:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				match(T__16);
				}
				break;
			case 7:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(ID);
				setState(196);
				match(T__14);
				setState(197);
				formula(0);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(198);
					match(T__0);
					setState(199);
					formula(0);
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(205);
				match(T__15);
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				match(NUM);
				}
				break;
			case 9:
				{
				_localctx = new BigIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				match(T__17);
				setState(209);
				match(T__14);
				setState(210);
				match(STRING);
				setState(211);
				match(T__15);
				}
				break;
			case 10:
				{
				_localctx = new SeqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				match(T__18);
				setState(213);
				match(T__14);
				setState(222);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__35))) != 0) || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (T__114 - 115)) | (1L << (NUM - 115)) | (1L << (ID - 115)))) != 0)) {
					{
					setState(214);
					exp(0);
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(215);
						match(T__0);
						setState(216);
						exp(0);
						}
						}
						setState(221);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(224);
				match(T__15);
				}
				break;
			case 11:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(272);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(270);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(228);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(229);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(231);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(230);
							match(NL);
							}
						}

						setState(233);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(234);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(235);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(237);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(236);
							match(NL);
							}
						}

						setState(239);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(240);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(241);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(243);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(242);
							match(NL);
							}
						}

						setState(245);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(246);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(247);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(249);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(248);
							match(NL);
							}
						}

						setState(251);
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(252);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(253);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(255);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(254);
							match(NL);
							}
						}

						setState(257);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(258);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(259);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(261);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(260);
							match(NL);
							}
						}

						setState(263);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(264);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(265);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__46) | (1L << T__47) | (1L << T__48))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(267);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(266);
							match(NL);
							}
						}

						setState(269);
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(274);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		public ExpContext lo;
		public ExpContext hi;
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
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
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
			setState(275);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(276);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(277);
				match(T__0);
				setState(278);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(291);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(284);
				match(T__57);
				setState(285);
				type();
				}
				break;
			case 2:
				{
				setState(286);
				match(T__57);
				setState(287);
				((QformulaContext)_localctx).lo = exp(0);
				setState(288);
				match(T__58);
				setState(289);
				((QformulaContext)_localctx).hi = exp(0);
				}
				break;
			}
			setState(293);
			match(T__59);
			setState(295);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(294);
				match(NL);
				}
			}

			setState(297);
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
		public Token t;
		public IntSeqTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class IntTypeContext extends TypeContext {
		public Token t;
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		try {
			setState(302);
			switch (_input.LA(1)) {
			case T__60:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				((BooleanTypeContext)_localctx).t = match(T__60);
				}
				break;
			case T__17:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				((IntTypeContext)_localctx).t = match(T__17);
				}
				break;
			case T__18:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(301);
				((IntSeqTypeContext)_localctx).t = match(T__18);
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
	public static class InvariantContext extends JustificationContext {
		public Token tb;
		public InvariantContext(JustificationContext ctx) { copyFrom(ctx); }
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
		public Token step;
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
		public NumOrIdContext numOrId;
		public List<NumOrIdContext> steps = new ArrayList<NumOrIdContext>();
		public List<NumOrIdContext> numOrId() {
			return getRuleContexts(NumOrIdContext.class);
		}
		public NumOrIdContext numOrId(int i) {
			return getRuleContext(NumOrIdContext.class,i);
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
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ImpliesIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}

	public final JustificationContext justification() throws RecognitionException {
		JustificationContext _localctx = new JustificationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_justification);
		int _la;
		try {
			setState(428);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				((PremiseContext)_localctx).t = match(T__61);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				switch (_input.LA(1)) {
				case T__62:
				case T__63:
					{
					setState(305);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__62 || _la==T__63) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__39:
				case T__41:
					{
					setState(306);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__39 || _la==T__41) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(307);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(310);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(311);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(315);
				switch (_input.LA(1)) {
				case T__64:
				case T__65:
				case T__66:
				case T__67:
					{
					setState(312);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__64 - 65)) | (1L << (T__65 - 65)) | (1L << (T__66 - 65)) | (1L << (T__67 - 65)))) != 0)) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__39:
				case T__41:
					{
					setState(313);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__39 || _la==T__41) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(314);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(317);
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(321);
				switch (_input.LA(1)) {
				case T__68:
				case T__69:
				case T__70:
				case T__71:
					{
					setState(318);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (T__68 - 69)) | (1L << (T__69 - 69)) | (1L << (T__70 - 69)) | (1L << (T__71 - 69)))) != 0)) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__43:
				case T__45:
					{
					setState(319);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__43 || _la==T__45) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(320);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(323);
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(327);
				switch (_input.LA(1)) {
				case T__72:
				case T__73:
					{
					setState(324);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__72 || _la==T__73) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__43:
				case T__45:
					{
					setState(325);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__43 || _la==T__45) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(326);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(329);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(330);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(331);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(335);
				switch (_input.LA(1)) {
				case T__74:
					{
					setState(332);
					((ImpliesIntroContext)_localctx).tb = match(T__74);
					}
					break;
				case T__47:
				case T__48:
					{
					setState(333);
					((ImpliesIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__47 || _la==T__48) ) {
						((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(334);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(337);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(341);
				switch (_input.LA(1)) {
				case T__75:
					{
					setState(338);
					((ImpliesElimContext)_localctx).tb = match(T__75);
					}
					break;
				case T__47:
				case T__48:
					{
					setState(339);
					((ImpliesElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__47 || _la==T__48) ) {
						((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(340);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(343);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(344);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(348);
				switch (_input.LA(1)) {
				case T__76:
				case T__77:
					{
					setState(345);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__76 || _la==T__77) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__35:
				case T__36:
				case T__37:
					{
					setState(346);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(347);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(350);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(355);
				switch (_input.LA(1)) {
				case T__78:
					{
					setState(351);
					((NegElimContext)_localctx).tb = match(T__78);
					}
					break;
				case T__79:
					{
					setState(352);
					((NegElimContext)_localctx).tb = match(T__79);
					}
					break;
				case T__35:
				case T__36:
				case T__37:
					{
					setState(353);
					((NegElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
						((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(354);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(357);
				((NegElimContext)_localctx).step = match(NUM);
				setState(358);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(362);
				switch (_input.LA(1)) {
				case T__80:
				case T__81:
					{
					setState(359);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__80 || _la==T__81) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__12:
				case T__13:
					{
					setState(360);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__12 || _la==T__13) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(361);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(364);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 11:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(365);
				((PbcContext)_localctx).tb = match(T__82);
				setState(366);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 12:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(372);
				switch (_input.LA(1)) {
				case T__83:
					{
					setState(367);
					((ForallIntroContext)_localctx).tb = match(T__83);
					}
					break;
				case T__84:
					{
					setState(368);
					((ForallIntroContext)_localctx).tb = match(T__84);
					}
					break;
				case T__85:
					{
					setState(369);
					((ForallIntroContext)_localctx).tb = match(T__85);
					}
					break;
				case T__52:
					{
					setState(370);
					((ForallIntroContext)_localctx).tb = match(T__52);
					setState(371);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(374);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(380);
				switch (_input.LA(1)) {
				case T__86:
					{
					setState(375);
					((ForallElimContext)_localctx).tb = match(T__86);
					}
					break;
				case T__87:
					{
					setState(376);
					((ForallElimContext)_localctx).tb = match(T__87);
					}
					break;
				case T__88:
					{
					setState(377);
					((ForallElimContext)_localctx).tb = match(T__88);
					}
					break;
				case T__52:
					{
					setState(378);
					((ForallElimContext)_localctx).tb = match(T__52);
					setState(379);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(382);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
				setState(384); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(383);
					formula(0);
					}
					}
					setState(386); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 14:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(388);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (T__89 - 90)) | (1L << (T__90 - 90)) | (1L << (T__91 - 90)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(389);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(391); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(390);
					formula(0);
					}
					}
					setState(393); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 15:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(395);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (T__92 - 93)) | (1L << (T__93 - 93)) | (1L << (T__94 - 93)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(396);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(397);
				((ExistsElimContext)_localctx).subproof = match(NUM);
				}
				break;
			case 16:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(399);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(400);
				((ExistsIntroContext)_localctx).tb = match(T__56);
				setState(401);
				match(ID);
				setState(402);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(404); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(403);
					formula(0);
					}
					}
					setState(406); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 17:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(408);
				((ExistsElimContext)_localctx).tb = match(T__56);
				setState(409);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(410);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(411);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(413);
				((AlgebraContext)_localctx).tb = match(T__95);
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(414);
					((AlgebraContext)_localctx).numOrId = numOrId();
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).numOrId);
					}
					}
					setState(419);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(420);
				((InvariantContext)_localctx).tb = match(T__96);
				}
				break;
			case 20:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(421);
				((AutoContext)_localctx).tb = match(T__97);
				setState(425);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(422);
					((AutoContext)_localctx).numOrId = numOrId();
					((AutoContext)_localctx).stepOrFacts.add(((AutoContext)_localctx).numOrId);
					}
					}
					setState(427);
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
			setState(430);
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
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
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
			setState(435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(432);
				match(NL);
				}
				}
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(464);
			_la = _input.LA(1);
			if (_la==T__98) {
				{
				setState(438);
				((ProgramContext)_localctx).tb = match(T__98);
				setState(439);
				((ProgramContext)_localctx).org = match(ID);
				setState(440);
				match(T__5);
				setState(441);
				((ProgramContext)_localctx).sireum = match(ID);
				setState(442);
				match(T__5);
				setState(443);
				match(T__99);
				setState(444);
				match(T__5);
				setState(445);
				((ProgramContext)_localctx).te = match(T__100);
				setState(447); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(446);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(449); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(461);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(451);
					lgk();
					setState(452);
					match(T__101);
					setState(453);
					facts();
					setState(454);
					((ProgramContext)_localctx).te = match(T__101);
					setState(458);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
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
						_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
					}
					}
					break;
				}
				setState(463);
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
			setState(466);
			_la = _input.LA(1);
			if ( !(_la==T__99 || _la==ID) ) {
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
			setState(468);
			match(T__3);
			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(469);
				match(NL);
				}
				}
				setState(474);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(475);
			((FactsContext)_localctx).ftb = match(T__102);
			setState(479);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(476);
					match(NL);
					}
					} 
				}
				setState(481);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			}
			setState(483);
			_la = _input.LA(1);
			if (_la==T__103 || _la==ID) {
				{
				setState(482);
				factOrFun();
				}
			}

			setState(495);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(486); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(485);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(488); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(491);
				_la = _input.LA(1);
				if (_la==T__103 || _la==ID) {
					{
					setState(490);
					factOrFun();
					}
				}

				}
				}
				setState(497);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(498);
			((FactsContext)_localctx).te = match(T__4);
			setState(502);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(499);
				match(NL);
				}
				}
				setState(504);
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
			setState(507);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(505);
				fact();
				}
				break;
			case T__103:
				enterOuterAlt(_localctx, 2);
				{
				setState(506);
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
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
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
			setState(509);
			match(ID);
			setState(510);
			match(T__5);
			setState(511);
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
			setState(513);
			((FunContext)_localctx).tb = match(T__103);
			setState(514);
			match(ID);
			setState(516);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(515);
				match(NL);
				}
			}

			setState(518);
			match(T__14);
			setState(519);
			param();
			setState(524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(520);
				match(T__0);
				setState(521);
				param();
				}
				}
				setState(526);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(527);
			match(T__15);
			setState(528);
			match(T__57);
			setState(529);
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
			setState(531);
			match(ID);
			setState(532);
			match(T__57);
			setState(533);
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
			setState(536);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__35))) != 0) || ((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (T__99 - 100)) | (1L << (T__103 - 100)) | (1L << (T__104 - 100)) | (1L << (T__105 - 100)) | (1L << (T__106 - 100)) | (1L << (T__107 - 100)) | (1L << (T__109 - 100)) | (1L << (T__110 - 100)) | (1L << (T__111 - 100)) | (1L << (T__114 - 100)) | (1L << (NUM - 100)) | (1L << (ID - 100)))) != 0)) {
				{
				setState(535);
				stmt();
				}
			}

			setState(548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(539); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(538);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(541); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(544);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__35))) != 0) || ((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (T__99 - 100)) | (1L << (T__103 - 100)) | (1L << (T__104 - 100)) | (1L << (T__105 - 100)) | (1L << (T__106 - 100)) | (1L << (T__107 - 100)) | (1L << (T__109 - 100)) | (1L << (T__110 - 100)) | (1L << (T__111 - 100)) | (1L << (T__114 - 100)) | (1L << (NUM - 100)) | (1L << (ID - 100)))) != 0)) {
					{
					setState(543);
					stmt();
					}
				}

				}
				}
				setState(550);
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
	public static class ExpStmtContext extends StmtContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssignVarStmtContext extends StmtContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
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
		public Token s;
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public PrintStmtContext(StmtContext ctx) { copyFrom(ctx); }
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
			setState(712);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(551);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__104 || _la==T__105) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(552);
				match(ID);
				setState(553);
				match(T__57);
				setState(554);
				type();
				setState(555);
				match(T__30);
				setState(557);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(556);
					match(NL);
					}
				}

				setState(559);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(561);
				match(ID);
				setState(562);
				match(T__30);
				setState(564);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(563);
					match(NL);
					}
				}

				setState(566);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(567);
				match(T__106);
				setState(568);
				match(T__14);
				setState(569);
				exp(0);
				setState(570);
				match(T__15);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(572);
				match(T__107);
				setState(573);
				match(T__14);
				setState(574);
				exp(0);
				setState(575);
				match(T__15);
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(576);
					match(NL);
					}
					}
					setState(581);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(582);
				match(T__3);
				setState(583);
				((IfStmtContext)_localctx).ts = stmts();
				setState(584);
				match(T__4);
				setState(596);
				_la = _input.LA(1);
				if (_la==T__108) {
					{
					setState(585);
					match(T__108);
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
					match(T__3);
					setState(593);
					((IfStmtContext)_localctx).fs = stmts();
					setState(594);
					match(T__4);
					}
				}

				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(598);
				match(T__109);
				setState(599);
				match(T__14);
				setState(600);
				exp(0);
				setState(601);
				match(T__15);
				setState(605);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(602);
					match(NL);
					}
					}
					setState(607);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(608);
				match(T__3);
				setState(620);
				switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
				case 1:
					{
					setState(612);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(609);
						match(NL);
						}
						}
						setState(614);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(615);
					lgk();
					setState(616);
					match(T__101);
					setState(617);
					loopInvariant();
					setState(618);
					match(T__101);
					}
					break;
				}
				setState(622);
				stmts();
				setState(623);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(625);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__110 || _la==T__111) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(626);
				match(T__14);
				setState(627);
				((PrintStmtContext)_localctx).s = match(ID);
				setState(628);
				match(STRING);
				setState(629);
				match(T__15);
				}
				break;
			case 7:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(630);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(631);
				match(T__14);
				setState(632);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(633);
				match(T__15);
				setState(634);
				match(T__30);
				setState(636);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(635);
					match(NL);
					}
				}

				setState(638);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 8:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(640);
				match(T__103);
				setState(641);
				match(ID);
				setState(643);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(642);
					match(NL);
					}
				}

				setState(645);
				match(T__14);
				setState(654);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(646);
					param();
					setState(651);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(647);
						match(T__0);
						setState(648);
						param();
						}
						}
						setState(653);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(656);
				match(T__15);
				setState(657);
				match(T__57);
				setState(660);
				switch (_input.LA(1)) {
				case T__17:
				case T__18:
				case T__60:
					{
					setState(658);
					type();
					}
					break;
				case T__112:
					{
					setState(659);
					match(T__112);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(662);
				match(T__30);
				setState(666);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(663);
					match(NL);
					}
					}
					setState(668);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(669);
				match(T__3);
				setState(687);
				switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
				case 1:
					{
					setState(673);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(670);
						match(NL);
						}
						}
						setState(675);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(676);
					lgk();
					setState(677);
					match(T__101);
					setState(678);
					methodContract();
					setState(682);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(679);
						match(NL);
						}
						}
						setState(684);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(685);
					match(T__101);
					}
					break;
				}
				setState(689);
				stmts();
				setState(698);
				_la = _input.LA(1);
				if (_la==T__113) {
					{
					setState(690);
					((MethodDeclStmtContext)_localctx).rtb = match(T__113);
					setState(691);
					exp(0);
					setState(695);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(692);
						match(NL);
						}
						}
						setState(697);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(700);
				match(T__4);
				}
				break;
			case 9:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(702);
				lgk();
				setState(703);
				match(T__101);
				setState(707);
				switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
				case 1:
					{
					setState(704);
					proof();
					}
					break;
				case 2:
					{
					setState(705);
					sequent();
					}
					break;
				case 3:
					{
					setState(706);
					invariants();
					}
					break;
				}
				setState(709);
				match(T__101);
				}
				break;
			case 10:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(711);
				exp(0);
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
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
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
	public static class ReadIntExpContext extends ExpContext {
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public ReadIntExpContext(ExpContext ctx) { copyFrom(ctx); }
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
			setState(763);
			switch (_input.LA(1)) {
			case T__23:
			case T__35:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(715);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__23 || _la==T__35) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(716);
				exp(8);
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
				setState(717);
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
				setState(718);
				match(NUM);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(719);
				((IdExpContext)_localctx).tb = match(ID);
				setState(734);
				switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
				case 1:
					{
					setState(720);
					match(T__14);
					setState(729);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__35))) != 0) || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (T__114 - 115)) | (1L << (NUM - 115)) | (1L << (ID - 115)))) != 0)) {
						{
						setState(721);
						exp(0);
						setState(726);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__0) {
							{
							{
							setState(722);
							match(T__0);
							setState(723);
							exp(0);
							}
							}
							setState(728);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(731);
					match(T__15);
					}
					break;
				case 2:
					{
					setState(732);
					match(T__5);
					setState(733);
					((IdExpContext)_localctx).te = match(ID);
					}
					break;
				}
				}
				break;
			case T__17:
				{
				_localctx = new BigIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(736);
				match(T__17);
				setState(737);
				match(T__14);
				setState(738);
				match(STRING);
				setState(739);
				match(T__15);
				}
				break;
			case T__18:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(740);
				match(T__18);
				setState(741);
				match(T__14);
				setState(750);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__35))) != 0) || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (T__114 - 115)) | (1L << (NUM - 115)) | (1L << (ID - 115)))) != 0)) {
					{
					setState(742);
					exp(0);
					setState(747);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(743);
						match(T__0);
						setState(744);
						exp(0);
						}
						}
						setState(749);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(752);
				match(T__15);
				}
				break;
			case T__114:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(753);
				match(T__114);
				setState(754);
				match(T__14);
				setState(756);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(755);
					match(STRING);
					}
				}

				setState(758);
				match(T__15);
				}
				break;
			case T__14:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(759);
				match(T__14);
				setState(760);
				exp(0);
				setState(761);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(809);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(807);
					switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(765);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(766);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(768);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(767);
							match(NL);
							}
						}

						setState(770);
						((BinaryExpContext)_localctx).r = exp(8);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(771);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(772);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23 || _la==T__115) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(774);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(773);
							match(NL);
							}
						}

						setState(776);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(777);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(778);
						((BinaryExpContext)_localctx).op = match(T__115);
						setState(780);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(779);
							match(NL);
							}
						}

						setState(782);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(783);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(784);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__27) | (1L << T__28))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(786);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(785);
							match(NL);
							}
						}

						setState(788);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(789);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(790);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__31 || _la==T__32) ) {
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
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(795);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(796);
						((BinaryExpContext)_localctx).op = match(T__39);
						setState(798);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(797);
							match(NL);
							}
						}

						setState(800);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(801);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(802);
						((BinaryExpContext)_localctx).op = match(T__43);
						setState(804);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(803);
							match(NL);
							}
						}

						setState(806);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(811);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
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
			setState(812);
			((LoopInvariantContext)_localctx).tb = match(T__3);
			setState(816);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(813);
				match(NL);
				}
				}
				setState(818);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(819);
			((LoopInvariantContext)_localctx).itb = match(T__96);
			setState(823);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(820);
					match(NL);
					}
					} 
				}
				setState(825);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			}
			setState(827);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56))) != 0) || _la==NUM || _la==ID) {
				{
				setState(826);
				formula(0);
				}
			}

			setState(839);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(830); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(829);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(832); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(835);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56))) != 0) || _la==NUM || _la==ID) {
					{
					setState(834);
					formula(0);
					}
				}

				}
				}
				setState(841);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(842);
			modifies();
			setState(843);
			((LoopInvariantContext)_localctx).te = match(T__4);
			setState(847);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(844);
				match(NL);
				}
				}
				setState(849);
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
			setState(850);
			((ModifiesContext)_localctx).tb = match(T__116);
			setState(859);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(851);
				match(ID);
				setState(856);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(852);
					match(T__0);
					setState(853);
					match(ID);
					}
					}
					setState(858);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(864);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(861);
					match(NL);
					}
					} 
				}
				setState(866);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
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
			setState(867);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(871);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(868);
					match(NL);
					}
					} 
				}
				setState(873);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
			}
			setState(895);
			_la = _input.LA(1);
			if (_la==T__117 || _la==T__118) {
				{
				setState(874);
				_la = _input.LA(1);
				if ( !(_la==T__117 || _la==T__118) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(878);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(875);
					match(NL);
					}
					}
					setState(880);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(881);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(892);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(883); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(882);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(885); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(888);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56))) != 0) || _la==NUM || _la==ID) {
							{
							setState(887);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(894);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
				}
				}
			}

			setState(900);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(897);
					match(NL);
					}
					} 
				}
				setState(902);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			}
			setState(904);
			_la = _input.LA(1);
			if (_la==T__116) {
				{
				setState(903);
				modifies();
				}
			}

			setState(927);
			_la = _input.LA(1);
			if (_la==T__119 || _la==T__120) {
				{
				setState(906);
				_la = _input.LA(1);
				if ( !(_la==T__119 || _la==T__120) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(910);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(907);
					match(NL);
					}
					}
					setState(912);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(913);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(924);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(915); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(914);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(917); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(920);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56))) != 0) || _la==NUM || _la==ID) {
							{
							setState(919);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(926);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
				}
				}
			}

			setState(932);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(929);
				match(NL);
				}
				}
				setState(934);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(935);
			((MethodContractContext)_localctx).te = match(T__4);
			setState(939);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(936);
					match(NL);
					}
					} 
				}
				setState(941);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
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
			setState(942);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(946);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(943);
				match(NL);
				}
				}
				setState(948);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(949);
			match(T__96);
			setState(953);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(950);
					match(NL);
					}
					} 
				}
				setState(955);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			}
			setState(957);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56))) != 0) || _la==NUM || _la==ID) {
				{
				setState(956);
				formula(0);
				}
			}

			setState(969);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(960); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(959);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(962); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(965);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__23) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56))) != 0) || _la==NUM || _la==ID) {
					{
					setState(964);
					formula(0);
					}
				}

				}
				}
				setState(971);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(972);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(976);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(973);
				match(NL);
				}
				}
				setState(978);
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
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 2);
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0085\u03d6\4\2\t"+
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
		"\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a4\n\7\3\7\6\7\u00a7"+
		"\n\7\r\7\16\7\u00a8\3\7\5\7\u00ac\n\7\7\7\u00ae\n\7\f\7\16\7\u00b1\13"+
		"\7\3\7\5\7\u00b4\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00bf\n\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00cb\n\b\f\b\16\b\u00ce"+
		"\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00dc\n\b\f"+
		"\b\16\b\u00df\13\b\5\b\u00e1\n\b\3\b\3\b\5\b\u00e5\n\b\3\b\3\b\3\b\5\b"+
		"\u00ea\n\b\3\b\3\b\3\b\3\b\5\b\u00f0\n\b\3\b\3\b\3\b\3\b\5\b\u00f6\n\b"+
		"\3\b\3\b\3\b\3\b\5\b\u00fc\n\b\3\b\3\b\3\b\3\b\5\b\u0102\n\b\3\b\3\b\3"+
		"\b\3\b\5\b\u0108\n\b\3\b\3\b\3\b\3\b\5\b\u010e\n\b\3\b\7\b\u0111\n\b\f"+
		"\b\16\b\u0114\13\b\3\t\3\t\3\t\3\t\7\t\u011a\n\t\f\t\16\t\u011d\13\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0126\n\t\3\t\3\t\5\t\u012a\n\t\3\t\3\t"+
		"\3\n\3\n\3\n\5\n\u0131\n\n\3\13\3\13\3\13\3\13\5\13\u0137\n\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u013e\n\13\3\13\3\13\3\13\3\13\5\13\u0144\n\13"+
		"\3\13\3\13\3\13\3\13\5\13\u014a\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u0152\n\13\3\13\3\13\3\13\3\13\5\13\u0158\n\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u015f\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0166\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u016d\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u0177\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u017f\n\13\3\13\3"+
		"\13\6\13\u0183\n\13\r\13\16\13\u0184\3\13\3\13\3\13\6\13\u018a\n\13\r"+
		"\13\16\13\u018b\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u0197"+
		"\n\13\r\13\16\13\u0198\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u01a2\n"+
		"\13\f\13\16\13\u01a5\13\13\3\13\3\13\3\13\7\13\u01aa\n\13\f\13\16\13\u01ad"+
		"\13\13\5\13\u01af\n\13\3\f\3\f\3\r\7\r\u01b4\n\r\f\r\16\r\u01b7\13\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u01c2\n\r\r\r\16\r\u01c3\3\r\3"+
		"\r\3\r\3\r\3\r\7\r\u01cb\n\r\f\r\16\r\u01ce\13\r\5\r\u01d0\n\r\3\r\5\r"+
		"\u01d3\n\r\3\16\3\16\3\17\3\17\7\17\u01d9\n\17\f\17\16\17\u01dc\13\17"+
		"\3\17\3\17\7\17\u01e0\n\17\f\17\16\17\u01e3\13\17\3\17\5\17\u01e6\n\17"+
		"\3\17\6\17\u01e9\n\17\r\17\16\17\u01ea\3\17\5\17\u01ee\n\17\7\17\u01f0"+
		"\n\17\f\17\16\17\u01f3\13\17\3\17\3\17\7\17\u01f7\n\17\f\17\16\17\u01fa"+
		"\13\17\3\20\3\20\5\20\u01fe\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\5"+
		"\22\u0207\n\22\3\22\3\22\3\22\3\22\7\22\u020d\n\22\f\22\16\22\u0210\13"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\5\24\u021b\n\24\3\24"+
		"\6\24\u021e\n\24\r\24\16\24\u021f\3\24\5\24\u0223\n\24\7\24\u0225\n\24"+
		"\f\24\16\24\u0228\13\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0230\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u0237\n\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\7\25\u0244\n\25\f\25\16\25\u0247\13\25\3\25"+
		"\3\25\3\25\3\25\3\25\7\25\u024e\n\25\f\25\16\25\u0251\13\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0257\n\25\3\25\3\25\3\25\3\25\3\25\7\25\u025e\n\25\f"+
		"\25\16\25\u0261\13\25\3\25\3\25\7\25\u0265\n\25\f\25\16\25\u0268\13\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u026f\n\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u027f\n\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0286\n\25\3\25\3\25\3\25\3\25\7\25\u028c\n\25\f\25\16"+
		"\25\u028f\13\25\5\25\u0291\n\25\3\25\3\25\3\25\3\25\5\25\u0297\n\25\3"+
		"\25\3\25\7\25\u029b\n\25\f\25\16\25\u029e\13\25\3\25\3\25\7\25\u02a2\n"+
		"\25\f\25\16\25\u02a5\13\25\3\25\3\25\3\25\3\25\7\25\u02ab\n\25\f\25\16"+
		"\25\u02ae\13\25\3\25\3\25\5\25\u02b2\n\25\3\25\3\25\3\25\3\25\7\25\u02b8"+
		"\n\25\f\25\16\25\u02bb\13\25\5\25\u02bd\n\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u02c6\n\25\3\25\3\25\3\25\5\25\u02cb\n\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u02d7\n\26\f\26\16\26\u02da"+
		"\13\26\5\26\u02dc\n\26\3\26\3\26\3\26\5\26\u02e1\n\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\7\26\u02ec\n\26\f\26\16\26\u02ef\13\26\5"+
		"\26\u02f1\n\26\3\26\3\26\3\26\3\26\5\26\u02f7\n\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u02fe\n\26\3\26\3\26\3\26\5\26\u0303\n\26\3\26\3\26\3\26\3"+
		"\26\5\26\u0309\n\26\3\26\3\26\3\26\3\26\5\26\u030f\n\26\3\26\3\26\3\26"+
		"\3\26\5\26\u0315\n\26\3\26\3\26\3\26\3\26\5\26\u031b\n\26\3\26\3\26\3"+
		"\26\3\26\5\26\u0321\n\26\3\26\3\26\3\26\3\26\5\26\u0327\n\26\3\26\7\26"+
		"\u032a\n\26\f\26\16\26\u032d\13\26\3\27\3\27\7\27\u0331\n\27\f\27\16\27"+
		"\u0334\13\27\3\27\3\27\7\27\u0338\n\27\f\27\16\27\u033b\13\27\3\27\5\27"+
		"\u033e\n\27\3\27\6\27\u0341\n\27\r\27\16\27\u0342\3\27\5\27\u0346\n\27"+
		"\7\27\u0348\n\27\f\27\16\27\u034b\13\27\3\27\3\27\3\27\7\27\u0350\n\27"+
		"\f\27\16\27\u0353\13\27\3\30\3\30\3\30\3\30\7\30\u0359\n\30\f\30\16\30"+
		"\u035c\13\30\5\30\u035e\n\30\3\30\7\30\u0361\n\30\f\30\16\30\u0364\13"+
		"\30\3\31\3\31\7\31\u0368\n\31\f\31\16\31\u036b\13\31\3\31\3\31\7\31\u036f"+
		"\n\31\f\31\16\31\u0372\13\31\3\31\3\31\6\31\u0376\n\31\r\31\16\31\u0377"+
		"\3\31\5\31\u037b\n\31\7\31\u037d\n\31\f\31\16\31\u0380\13\31\5\31\u0382"+
		"\n\31\3\31\7\31\u0385\n\31\f\31\16\31\u0388\13\31\3\31\5\31\u038b\n\31"+
		"\3\31\3\31\7\31\u038f\n\31\f\31\16\31\u0392\13\31\3\31\3\31\6\31\u0396"+
		"\n\31\r\31\16\31\u0397\3\31\5\31\u039b\n\31\7\31\u039d\n\31\f\31\16\31"+
		"\u03a0\13\31\5\31\u03a2\n\31\3\31\7\31\u03a5\n\31\f\31\16\31\u03a8\13"+
		"\31\3\31\3\31\7\31\u03ac\n\31\f\31\16\31\u03af\13\31\3\32\3\32\7\32\u03b3"+
		"\n\32\f\32\16\32\u03b6\13\32\3\32\3\32\7\32\u03ba\n\32\f\32\16\32\u03bd"+
		"\13\32\3\32\5\32\u03c0\n\32\3\32\6\32\u03c3\n\32\r\32\16\32\u03c4\3\32"+
		"\5\32\u03c8\n\32\7\32\u03ca\n\32\f\32\16\32\u03cd\13\32\3\32\3\32\7\32"+
		"\u03d1\n\32\f\32\16\32\u03d4\13\32\3\32\2\4\16*\33\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\2$\3\2\4\5\3\2%(\3\2\n\20\3\2\26\30"+
		"\3\2\31\32\3\2\33 \3\2!$\3\2),\3\2-\60\3\2\61\63\3\2\64;\3\2AB\4\2**,"+
		",\3\2CF\3\2GJ\4\2..\60\60\3\2KL\3\2\62\63\3\2OP\3\2&(\3\2ST\3\2\17\20"+
		"\3\2\\^\3\2_a\3\2}~\4\2ff~~\3\2kl\3\2qr\4\2\32\32&&\4\2\31\32vv\4\2\33"+
		"\34\36\37\3\2\"#\3\2xy\3\2z{\u0489\2\64\3\2\2\2\4F\3\2\2\2\6I\3\2\2\2"+
		"\bk\3\2\2\2\nm\3\2\2\2\f\u00b3\3\2\2\2\16\u00e4\3\2\2\2\20\u0115\3\2\2"+
		"\2\22\u0130\3\2\2\2\24\u01ae\3\2\2\2\26\u01b0\3\2\2\2\30\u01b5\3\2\2\2"+
		"\32\u01d4\3\2\2\2\34\u01d6\3\2\2\2\36\u01fd\3\2\2\2 \u01ff\3\2\2\2\"\u0203"+
		"\3\2\2\2$\u0215\3\2\2\2&\u021a\3\2\2\2(\u02ca\3\2\2\2*\u02fd\3\2\2\2,"+
		"\u032e\3\2\2\2.\u0354\3\2\2\2\60\u0365\3\2\2\2\62\u03b0\3\2\2\2\648\5"+
		"\b\5\2\65\67\7\u0081\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2"+
		"\29<\3\2\2\2:8\3\2\2\2;=\5\n\6\2<;\3\2\2\2<=\3\2\2\2=A\3\2\2\2>@\7\u0081"+
		"\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\2"+
		"\2\3E\3\3\2\2\2FG\5\n\6\2GH\7\2\2\3H\5\3\2\2\2IJ\5\30\r\2JK\7\2\2\3K\7"+
		"\3\2\2\2LQ\5\16\b\2MN\7\3\2\2NP\5\16\b\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2\2"+
		"QR\3\2\2\2RU\3\2\2\2SQ\3\2\2\2TL\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\t\2\2\2"+
		"W\\\5\16\b\2XY\7\3\2\2Y[\5\16\b\2ZX\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3"+
		"\2\2\2]l\3\2\2\2^\\\3\2\2\2_a\5\16\b\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2b"+
		"c\3\2\2\2ce\3\2\2\2db\3\2\2\2eg\7|\2\2fh\5\16\b\2gf\3\2\2\2hi\3\2\2\2"+
		"ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2kT\3\2\2\2kb\3\2\2\2l\t\3\2\2\2mo\7\6\2"+
		"\2np\5\f\7\2on\3\2\2\2op\3\2\2\2p{\3\2\2\2qs\7\u0081\2\2rq\3\2\2\2st\3"+
		"\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vx\5\f\7\2wv\3\2\2\2wx\3\2\2\2xz\3"+
		"\2\2\2yr\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2~\u0082"+
		"\7\7\2\2\177\u0081\7\u0081\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\13\3\2\2\2\u0084\u0082\3\2\2"+
		"\2\u0085\u0086\7}\2\2\u0086\u0087\7\b\2\2\u0087\u0088\5\16\b\2\u0088\u0089"+
		"\5\24\13\2\u0089\u00b4\3\2\2\2\u008a\u008b\7}\2\2\u008b\u008f\7\b\2\2"+
		"\u008c\u008e\7\u0081\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0092\u0096\7\6\2\2\u0093\u0095\7\u0081\2\2\u0094\u0093\3\2\2\2\u0095"+
		"\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0099\u009a\7}\2\2\u009a\u00a3\7\b\2\2\u009b"+
		"\u00a4\7~\2\2\u009c\u009d\5\16\b\2\u009d\u009e\7\t\2\2\u009e\u00a4\3\2"+
		"\2\2\u009f\u00a0\7~\2\2\u00a0\u00a1\5\16\b\2\u00a1\u00a2\7\t\2\2\u00a2"+
		"\u00a4\3\2\2\2\u00a3\u009b\3\2\2\2\u00a3\u009c\3\2\2\2\u00a3\u009f\3\2"+
		"\2\2\u00a4\u00af\3\2\2\2\u00a5\u00a7\7\u0081\2\2\u00a6\u00a5\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2"+
		"\2\2\u00aa\u00ac\5\f\7\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00ae\3\2\2\2\u00ad\u00a6\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2"+
		"\u00b4\7\7\2\2\u00b3\u0085\3\2\2\2\u00b3\u008a\3\2\2\2\u00b4\r\3\2\2\2"+
		"\u00b5\u00b6\b\b\1\2\u00b6\u00b7\7\32\2\2\u00b7\u00e5\5\16\b\b\u00b8\u00b9"+
		"\t\3\2\2\u00b9\u00e5\5\16\b\7\u00ba\u00e5\t\4\2\2\u00bb\u00be\7~\2\2\u00bc"+
		"\u00bd\7\b\2\2\u00bd\u00bf\7~\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\u00e5\3\2\2\2\u00c0\u00c1\7\21\2\2\u00c1\u00c2\5\16\b\2\u00c2"+
		"\u00c3\7\22\2\2\u00c3\u00e5\3\2\2\2\u00c4\u00e5\7\23\2\2\u00c5\u00c6\7"+
		"~\2\2\u00c6\u00c7\7\21\2\2\u00c7\u00cc\5\16\b\2\u00c8\u00c9\7\3\2\2\u00c9"+
		"\u00cb\5\16\b\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3"+
		"\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf"+
		"\u00d0\7\22\2\2\u00d0\u00e5\3\2\2\2\u00d1\u00e5\7}\2\2\u00d2\u00d3\7\24"+
		"\2\2\u00d3\u00d4\7\21\2\2\u00d4\u00d5\7\177\2\2\u00d5\u00e5\7\22\2\2\u00d6"+
		"\u00d7\7\25\2\2\u00d7\u00e0\7\21\2\2\u00d8\u00dd\5*\26\2\u00d9\u00da\7"+
		"\3\2\2\u00da\u00dc\5*\26\2\u00db\u00d9\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2"+
		"\2\2\u00e0\u00d8\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e5\7\22\2\2\u00e3\u00e5\5\20\t\2\u00e4\u00b5\3\2\2\2\u00e4\u00b8\3"+
		"\2\2\2\u00e4\u00ba\3\2\2\2\u00e4\u00bb\3\2\2\2\u00e4\u00c0\3\2\2\2\u00e4"+
		"\u00c4\3\2\2\2\u00e4\u00c5\3\2\2\2\u00e4\u00d1\3\2\2\2\u00e4\u00d2\3\2"+
		"\2\2\u00e4\u00d6\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u0112\3\2\2\2\u00e6"+
		"\u00e7\f\f\2\2\u00e7\u00e9\t\5\2\2\u00e8\u00ea\7\u0081\2\2\u00e9\u00e8"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u0111\5\16\b\r"+
		"\u00ec\u00ed\f\13\2\2\u00ed\u00ef\t\6\2\2\u00ee\u00f0\7\u0081\2\2\u00ef"+
		"\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u0111\5\16"+
		"\b\f\u00f2\u00f3\f\n\2\2\u00f3\u00f5\t\7\2\2\u00f4\u00f6\7\u0081\2\2\u00f5"+
		"\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u0111\5\16"+
		"\b\13\u00f8\u00f9\f\t\2\2\u00f9\u00fb\t\b\2\2\u00fa\u00fc\7\u0081\2\2"+
		"\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u0111"+
		"\5\16\b\n\u00fe\u00ff\f\6\2\2\u00ff\u0101\t\t\2\2\u0100\u0102\7\u0081"+
		"\2\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0111\5\16\b\7\u0104\u0105\f\5\2\2\u0105\u0107\t\n\2\2\u0106\u0108\7"+
		"\u0081\2\2\u0107\u0106\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2"+
		"\u0109\u0111\5\16\b\6\u010a\u010b\f\4\2\2\u010b\u010d\t\13\2\2\u010c\u010e"+
		"\7\u0081\2\2\u010d\u010c\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2"+
		"\2\u010f\u0111\5\16\b\5\u0110\u00e6\3\2\2\2\u0110\u00ec\3\2\2\2\u0110"+
		"\u00f2\3\2\2\2\u0110\u00f8\3\2\2\2\u0110\u00fe\3\2\2\2\u0110\u0104\3\2"+
		"\2\2\u0110\u010a\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\17\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0116\t\f\2"+
		"\2\u0116\u011b\7~\2\2\u0117\u0118\7\3\2\2\u0118\u011a\7~\2\2\u0119\u0117"+
		"\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c"+
		"\u0125\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u011f\7<\2\2\u011f\u0126\5\22"+
		"\n\2\u0120\u0121\7<\2\2\u0121\u0122\5*\26\2\u0122\u0123\7=\2\2\u0123\u0124"+
		"\5*\26\2\u0124\u0126\3\2\2\2\u0125\u011e\3\2\2\2\u0125\u0120\3\2\2\2\u0125"+
		"\u0126\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0129\7>\2\2\u0128\u012a\7\u0081"+
		"\2\2\u0129\u0128\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u012c\5\16\b\2\u012c\21\3\2\2\2\u012d\u0131\7?\2\2\u012e\u0131\7\24\2"+
		"\2\u012f\u0131\7\25\2\2\u0130\u012d\3\2\2\2\u0130\u012e\3\2\2\2\u0130"+
		"\u012f\3\2\2\2\u0131\23\3\2\2\2\u0132\u01af\7@\2\2\u0133\u0137\t\r\2\2"+
		"\u0134\u0135\t\16\2\2\u0135\u0137\7~\2\2\u0136\u0133\3\2\2\2\u0136\u0134"+
		"\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139\7}\2\2\u0139\u01af\7}\2\2\u013a"+
		"\u013e\t\17\2\2\u013b\u013c\t\16\2\2\u013c\u013e\7~\2\2\u013d\u013a\3"+
		"\2\2\2\u013d\u013b\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u01af\7}\2\2\u0140"+
		"\u0144\t\20\2\2\u0141\u0142\t\21\2\2\u0142\u0144\7~\2\2\u0143\u0140\3"+
		"\2\2\2\u0143\u0141\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u01af\7}\2\2\u0146"+
		"\u014a\t\22\2\2\u0147\u0148\t\21\2\2\u0148\u014a\7~\2\2\u0149\u0146\3"+
		"\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\7}\2\2\u014c"+
		"\u014d\7}\2\2\u014d\u01af\7}\2\2\u014e\u0152\7M\2\2\u014f\u0150\t\23\2"+
		"\2\u0150\u0152\7~\2\2\u0151\u014e\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0153"+
		"\3\2\2\2\u0153\u01af\7}\2\2\u0154\u0158\7N\2\2\u0155\u0156\t\23\2\2\u0156"+
		"\u0158\7~\2\2\u0157\u0154\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0159\3\2"+
		"\2\2\u0159\u015a\7}\2\2\u015a\u01af\7}\2\2\u015b\u015f\t\24\2\2\u015c"+
		"\u015d\t\25\2\2\u015d\u015f\7~\2\2\u015e\u015b\3\2\2\2\u015e\u015c\3\2"+
		"\2\2\u015f\u0160\3\2\2\2\u0160\u01af\7}\2\2\u0161\u0166\7Q\2\2\u0162\u0166"+
		"\7R\2\2\u0163\u0164\t\25\2\2\u0164\u0166\7~\2\2\u0165\u0161\3\2\2\2\u0165"+
		"\u0162\3\2\2\2\u0165\u0163\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0168\7}"+
		"\2\2\u0168\u01af\7}\2\2\u0169\u016d\t\26\2\2\u016a\u016b\t\27\2\2\u016b"+
		"\u016d\7~\2\2\u016c\u0169\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u016e\3\2"+
		"\2\2\u016e\u01af\7}\2\2\u016f\u0170\7U\2\2\u0170\u01af\7}\2\2\u0171\u0177"+
		"\7V\2\2\u0172\u0177\7W\2\2\u0173\u0177\7X\2\2\u0174\u0175\7\67\2\2\u0175"+
		"\u0177\7~\2\2\u0176\u0171\3\2\2\2\u0176\u0172\3\2\2\2\u0176\u0173\3\2"+
		"\2\2\u0176\u0174\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u01af\7}\2\2\u0179"+
		"\u017f\7Y\2\2\u017a\u017f\7Z\2\2\u017b\u017f\7[\2\2\u017c\u017d\7\67\2"+
		"\2\u017d\u017f\7~\2\2\u017e\u0179\3\2\2\2\u017e\u017a\3\2\2\2\u017e\u017b"+
		"\3\2\2\2\u017e\u017c\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0182\5\26\f\2"+
		"\u0181\u0183\5\16\b\2\u0182\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0182"+
		"\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u01af\3\2\2\2\u0186\u0187\t\30\2\2"+
		"\u0187\u0189\7}\2\2\u0188\u018a\5\16\b\2\u0189\u0188\3\2\2\2\u018a\u018b"+
		"\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u01af\3\2\2\2\u018d"+
		"\u018e\t\31\2\2\u018e\u018f\5\26\f\2\u018f\u0190\7}\2\2\u0190\u01af\3"+
		"\2\2\2\u0191\u0192\6\13\t\2\u0192\u0193\7;\2\2\u0193\u0194\7~\2\2\u0194"+
		"\u0196\7}\2\2\u0195\u0197\5\16\b\2\u0196\u0195\3\2\2\2\u0197\u0198\3\2"+
		"\2\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u01af\3\2\2\2\u019a"+
		"\u019b\7;\2\2\u019b\u019c\7~\2\2\u019c\u019d\5\26\f\2\u019d\u019e\7}\2"+
		"\2\u019e\u01af\3\2\2\2\u019f\u01a3\7b\2\2\u01a0\u01a2\5\26\f\2\u01a1\u01a0"+
		"\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4"+
		"\u01af\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01af\7c\2\2\u01a7\u01ab\7d\2"+
		"\2\u01a8\u01aa\5\26\f\2\u01a9\u01a8\3\2\2\2\u01aa\u01ad\3\2\2\2\u01ab"+
		"\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ab\3\2"+
		"\2\2\u01ae\u0132\3\2\2\2\u01ae\u0136\3\2\2\2\u01ae\u013d\3\2\2\2\u01ae"+
		"\u0143\3\2\2\2\u01ae\u0149\3\2\2\2\u01ae\u0151\3\2\2\2\u01ae\u0157\3\2"+
		"\2\2\u01ae\u015e\3\2\2\2\u01ae\u0165\3\2\2\2\u01ae\u016c\3\2\2\2\u01ae"+
		"\u016f\3\2\2\2\u01ae\u0176\3\2\2\2\u01ae\u017e\3\2\2\2\u01ae\u0186\3\2"+
		"\2\2\u01ae\u018d\3\2\2\2\u01ae\u0191\3\2\2\2\u01ae\u019a\3\2\2\2\u01ae"+
		"\u019f\3\2\2\2\u01ae\u01a6\3\2\2\2\u01ae\u01a7\3\2\2\2\u01af\25\3\2\2"+
		"\2\u01b0\u01b1\t\32\2\2\u01b1\27\3\2\2\2\u01b2\u01b4\7\u0081\2\2\u01b3"+
		"\u01b2\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3\2"+
		"\2\2\u01b6\u01d2\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b8\u01b9\7e\2\2\u01b9"+
		"\u01ba\7~\2\2\u01ba\u01bb\7\b\2\2\u01bb\u01bc\7~\2\2\u01bc\u01bd\7\b\2"+
		"\2\u01bd\u01be\7f\2\2\u01be\u01bf\7\b\2\2\u01bf\u01c1\7g\2\2\u01c0\u01c2"+
		"\7\u0081\2\2\u01c1\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c1\3\2\2"+
		"\2\u01c3\u01c4\3\2\2\2\u01c4\u01cf\3\2\2\2\u01c5\u01c6\5\32\16\2\u01c6"+
		"\u01c7\7h\2\2\u01c7\u01c8\5\34\17\2\u01c8\u01cc\7h\2\2\u01c9\u01cb\7\u0081"+
		"\2\2\u01ca\u01c9\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc"+
		"\u01cd\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01c5\3\2"+
		"\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d3\5&\24\2\u01d2"+
		"\u01b8\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\31\3\2\2\2\u01d4\u01d5\t\33\2"+
		"\2\u01d5\33\3\2\2\2\u01d6\u01da\7\6\2\2\u01d7\u01d9\7\u0081\2\2\u01d8"+
		"\u01d7\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2"+
		"\2\2\u01db\u01dd\3\2\2\2\u01dc\u01da\3\2\2\2\u01dd\u01e1\7i\2\2\u01de"+
		"\u01e0\7\u0081\2\2\u01df\u01de\3\2\2\2\u01e0\u01e3\3\2\2\2\u01e1\u01df"+
		"\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e4"+
		"\u01e6\5\36\20\2\u01e5\u01e4\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01f1\3"+
		"\2\2\2\u01e7\u01e9\7\u0081\2\2\u01e8\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2"+
		"\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ed\3\2\2\2\u01ec\u01ee"+
		"\5\36\20\2\u01ed\u01ec\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01f0\3\2\2\2"+
		"\u01ef\u01e8\3\2\2\2\u01f0\u01f3\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2"+
		"\3\2\2\2\u01f2\u01f4\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f4\u01f8\7\7\2\2\u01f5"+
		"\u01f7\7\u0081\2\2\u01f6\u01f5\3\2\2\2\u01f7\u01fa\3\2\2\2\u01f8\u01f6"+
		"\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\35\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fb"+
		"\u01fe\5 \21\2\u01fc\u01fe\5\"\22\2\u01fd\u01fb\3\2\2\2\u01fd\u01fc\3"+
		"\2\2\2\u01fe\37\3\2\2\2\u01ff\u0200\7~\2\2\u0200\u0201\7\b\2\2\u0201\u0202"+
		"\5\16\b\2\u0202!\3\2\2\2\u0203\u0204\7j\2\2\u0204\u0206\7~\2\2\u0205\u0207"+
		"\7\u0081\2\2\u0206\u0205\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0208\3\2\2"+
		"\2\u0208\u0209\7\21\2\2\u0209\u020e\5$\23\2\u020a\u020b\7\3\2\2\u020b"+
		"\u020d\5$\23\2\u020c\u020a\3\2\2\2\u020d\u0210\3\2\2\2\u020e\u020c\3\2"+
		"\2\2\u020e\u020f\3\2\2\2\u020f\u0211\3\2\2\2\u0210\u020e\3\2\2\2\u0211"+
		"\u0212\7\22\2\2\u0212\u0213\7<\2\2\u0213\u0214\5\22\n\2\u0214#\3\2\2\2"+
		"\u0215\u0216\7~\2\2\u0216\u0217\7<\2\2\u0217\u0218\5\22\n\2\u0218%\3\2"+
		"\2\2\u0219\u021b\5(\25\2\u021a\u0219\3\2\2\2\u021a\u021b\3\2\2\2\u021b"+
		"\u0226\3\2\2\2\u021c\u021e\7\u0081\2\2\u021d\u021c\3\2\2\2\u021e\u021f"+
		"\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u0222\3\2\2\2\u0221"+
		"\u0223\5(\25\2\u0222\u0221\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0225\3\2"+
		"\2\2\u0224\u021d\3\2\2\2\u0225\u0228\3\2\2\2\u0226\u0224\3\2\2\2\u0226"+
		"\u0227\3\2\2\2\u0227\'\3\2\2\2\u0228\u0226\3\2\2\2\u0229\u022a\t\34\2"+
		"\2\u022a\u022b\7~\2\2\u022b\u022c\7<\2\2\u022c\u022d\5\22\n\2\u022d\u022f"+
		"\7!\2\2\u022e\u0230\7\u0081\2\2\u022f\u022e\3\2\2\2\u022f\u0230\3\2\2"+
		"\2\u0230\u0231\3\2\2\2\u0231\u0232\5*\26\2\u0232\u02cb\3\2\2\2\u0233\u0234"+
		"\7~\2\2\u0234\u0236\7!\2\2\u0235\u0237\7\u0081\2\2\u0236\u0235\3\2\2\2"+
		"\u0236\u0237\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u02cb\5*\26\2\u0239\u023a"+
		"\7m\2\2\u023a\u023b\7\21\2\2\u023b\u023c\5*\26\2\u023c\u023d\7\22\2\2"+
		"\u023d\u02cb\3\2\2\2\u023e\u023f\7n\2\2\u023f\u0240\7\21\2\2\u0240\u0241"+
		"\5*\26\2\u0241\u0245\7\22\2\2\u0242\u0244\7\u0081\2\2\u0243\u0242\3\2"+
		"\2\2\u0244\u0247\3\2\2\2\u0245\u0243\3\2\2\2\u0245\u0246\3\2\2\2\u0246"+
		"\u0248\3\2\2\2\u0247\u0245\3\2\2\2\u0248\u0249\7\6\2\2\u0249\u024a\5&"+
		"\24\2\u024a\u0256\7\7\2\2\u024b\u024f\7o\2\2\u024c\u024e\7\u0081\2\2\u024d"+
		"\u024c\3\2\2\2\u024e\u0251\3\2\2\2\u024f\u024d\3\2\2\2\u024f\u0250\3\2"+
		"\2\2\u0250\u0252\3\2\2\2\u0251\u024f\3\2\2\2\u0252\u0253\7\6\2\2\u0253"+
		"\u0254\5&\24\2\u0254\u0255\7\7\2\2\u0255\u0257\3\2\2\2\u0256\u024b\3\2"+
		"\2\2\u0256\u0257\3\2\2\2\u0257\u02cb\3\2\2\2\u0258\u0259\7p\2\2\u0259"+
		"\u025a\7\21\2\2\u025a\u025b\5*\26\2\u025b\u025f\7\22\2\2\u025c\u025e\7"+
		"\u0081\2\2\u025d\u025c\3\2\2\2\u025e\u0261\3\2\2\2\u025f\u025d\3\2\2\2"+
		"\u025f\u0260\3\2\2\2\u0260\u0262\3\2\2\2\u0261\u025f\3\2\2\2\u0262\u026e"+
		"\7\6\2\2\u0263\u0265\7\u0081\2\2\u0264\u0263\3\2\2\2\u0265\u0268\3\2\2"+
		"\2\u0266\u0264\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0269\3\2\2\2\u0268\u0266"+
		"\3\2\2\2\u0269\u026a\5\32\16\2\u026a\u026b\7h\2\2\u026b\u026c\5,\27\2"+
		"\u026c\u026d\7h\2\2\u026d\u026f\3\2\2\2\u026e\u0266\3\2\2\2\u026e\u026f"+
		"\3\2\2\2\u026f\u0270\3\2\2\2\u0270\u0271\5&\24\2\u0271\u0272\7\7\2\2\u0272"+
		"\u02cb\3\2\2\2\u0273\u0274\t\35\2\2\u0274\u0275\7\21\2\2\u0275\u0276\7"+
		"~\2\2\u0276\u0277\7\177\2\2\u0277\u02cb\7\22\2\2\u0278\u0279\7~\2\2\u0279"+
		"\u027a\7\21\2\2\u027a\u027b\5*\26\2\u027b\u027c\7\22\2\2\u027c\u027e\7"+
		"!\2\2\u027d\u027f\7\u0081\2\2\u027e\u027d\3\2\2\2\u027e\u027f\3\2\2\2"+
		"\u027f\u0280\3\2\2\2\u0280\u0281\5*\26\2\u0281\u02cb\3\2\2\2\u0282\u0283"+
		"\7j\2\2\u0283\u0285\7~\2\2\u0284\u0286\7\u0081\2\2\u0285\u0284\3\2\2\2"+
		"\u0285\u0286\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0290\7\21\2\2\u0288\u028d"+
		"\5$\23\2\u0289\u028a\7\3\2\2\u028a\u028c\5$\23\2\u028b\u0289\3\2\2\2\u028c"+
		"\u028f\3\2\2\2\u028d\u028b\3\2\2\2\u028d\u028e\3\2\2\2\u028e\u0291\3\2"+
		"\2\2\u028f\u028d\3\2\2\2\u0290\u0288\3\2\2\2\u0290\u0291\3\2\2\2\u0291"+
		"\u0292\3\2\2\2\u0292\u0293\7\22\2\2\u0293\u0296\7<\2\2\u0294\u0297\5\22"+
		"\n\2\u0295\u0297\7s\2\2\u0296\u0294\3\2\2\2\u0296\u0295\3\2\2\2\u0297"+
		"\u0298\3\2\2\2\u0298\u029c\7!\2\2\u0299\u029b\7\u0081\2\2\u029a\u0299"+
		"\3\2\2\2\u029b\u029e\3\2\2\2\u029c\u029a\3\2\2\2\u029c\u029d\3\2\2\2\u029d"+
		"\u029f\3\2\2\2\u029e\u029c\3\2\2\2\u029f\u02b1\7\6\2\2\u02a0\u02a2\7\u0081"+
		"\2\2\u02a1\u02a0\3\2\2\2\u02a2\u02a5\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a3"+
		"\u02a4\3\2\2\2\u02a4\u02a6\3\2\2\2\u02a5\u02a3\3\2\2\2\u02a6\u02a7\5\32"+
		"\16\2\u02a7\u02a8\7h\2\2\u02a8\u02ac\5\60\31\2\u02a9\u02ab\7\u0081\2\2"+
		"\u02aa\u02a9\3\2\2\2\u02ab\u02ae\3\2\2\2\u02ac\u02aa\3\2\2\2\u02ac\u02ad"+
		"\3\2\2\2\u02ad\u02af\3\2\2\2\u02ae\u02ac\3\2\2\2\u02af\u02b0\7h\2\2\u02b0"+
		"\u02b2\3\2\2\2\u02b1\u02a3\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b3\3\2"+
		"\2\2\u02b3\u02bc\5&\24\2\u02b4\u02b5\7t\2\2\u02b5\u02b9\5*\26\2\u02b6"+
		"\u02b8\7\u0081\2\2\u02b7\u02b6\3\2\2\2\u02b8\u02bb\3\2\2\2\u02b9\u02b7"+
		"\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02bd\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bc"+
		"\u02b4\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02bf\7\7"+
		"\2\2\u02bf\u02cb\3\2\2\2\u02c0\u02c1\5\32\16\2\u02c1\u02c5\7h\2\2\u02c2"+
		"\u02c6\5\n\6\2\u02c3\u02c6\5\b\5\2\u02c4\u02c6\5\62\32\2\u02c5\u02c2\3"+
		"\2\2\2\u02c5\u02c3\3\2\2\2\u02c5\u02c4\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7"+
		"\u02c8\7h\2\2\u02c8\u02cb\3\2\2\2\u02c9\u02cb\5*\26\2\u02ca\u0229\3\2"+
		"\2\2\u02ca\u0233\3\2\2\2\u02ca\u0239\3\2\2\2\u02ca\u023e\3\2\2\2\u02ca"+
		"\u0258\3\2\2\2\u02ca\u0273\3\2\2\2\u02ca\u0278\3\2\2\2\u02ca\u0282\3\2"+
		"\2\2\u02ca\u02c0\3\2\2\2\u02ca\u02c9\3\2\2\2\u02cb)\3\2\2\2\u02cc\u02cd"+
		"\b\26\1\2\u02cd\u02ce\t\36\2\2\u02ce\u02fe\5*\26\n\u02cf\u02fe\t\4\2\2"+
		"\u02d0\u02fe\7}\2\2\u02d1\u02e0\7~\2\2\u02d2\u02db\7\21\2\2\u02d3\u02d8"+
		"\5*\26\2\u02d4\u02d5\7\3\2\2\u02d5\u02d7\5*\26\2\u02d6\u02d4\3\2\2\2\u02d7"+
		"\u02da\3\2\2\2\u02d8\u02d6\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02dc\3\2"+
		"\2\2\u02da\u02d8\3\2\2\2\u02db\u02d3\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc"+
		"\u02dd\3\2\2\2\u02dd\u02e1\7\22\2\2\u02de\u02df\7\b\2\2\u02df\u02e1\7"+
		"~\2\2\u02e0\u02d2\3\2\2\2\u02e0\u02de\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1"+
		"\u02fe\3\2\2\2\u02e2\u02e3\7\24\2\2\u02e3\u02e4\7\21\2\2\u02e4\u02e5\7"+
		"\177\2\2\u02e5\u02fe\7\22\2\2\u02e6\u02e7\7\25\2\2\u02e7\u02f0\7\21\2"+
		"\2\u02e8\u02ed\5*\26\2\u02e9\u02ea\7\3\2\2\u02ea\u02ec\5*\26\2\u02eb\u02e9"+
		"\3\2\2\2\u02ec\u02ef\3\2\2\2\u02ed\u02eb\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee"+
		"\u02f1\3\2\2\2\u02ef\u02ed\3\2\2\2\u02f0\u02e8\3\2\2\2\u02f0\u02f1\3\2"+
		"\2\2\u02f1\u02f2\3\2\2\2\u02f2\u02fe\7\22\2\2\u02f3\u02f4\7u\2\2\u02f4"+
		"\u02f6\7\21\2\2\u02f5\u02f7\7\177\2\2\u02f6\u02f5\3\2\2\2\u02f6\u02f7"+
		"\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02fe\7\22\2\2\u02f9\u02fa\7\21\2\2"+
		"\u02fa\u02fb\5*\26\2\u02fb\u02fc\7\22\2\2\u02fc\u02fe\3\2\2\2\u02fd\u02cc"+
		"\3\2\2\2\u02fd\u02cf\3\2\2\2\u02fd\u02d0\3\2\2\2\u02fd\u02d1\3\2\2\2\u02fd"+
		"\u02e2\3\2\2\2\u02fd\u02e6\3\2\2\2\u02fd\u02f3\3\2\2\2\u02fd\u02f9\3\2"+
		"\2\2\u02fe\u032b\3\2\2\2\u02ff\u0300\f\t\2\2\u0300\u0302\t\5\2\2\u0301"+
		"\u0303\7\u0081\2\2\u0302\u0301\3\2\2\2\u0302\u0303\3\2\2\2\u0303\u0304"+
		"\3\2\2\2\u0304\u032a\5*\26\n\u0305\u0306\f\b\2\2\u0306\u0308\t\37\2\2"+
		"\u0307\u0309\7\u0081\2\2\u0308\u0307\3\2\2\2\u0308\u0309\3\2\2\2\u0309"+
		"\u030a\3\2\2\2\u030a\u032a\5*\26\t\u030b\u030c\f\7\2\2\u030c\u030e\7v"+
		"\2\2\u030d\u030f\7\u0081\2\2\u030e\u030d\3\2\2\2\u030e\u030f\3\2\2\2\u030f"+
		"\u0310\3\2\2\2\u0310\u032a\5*\26\b\u0311\u0312\f\6\2\2\u0312\u0314\t "+
		"\2\2\u0313\u0315\7\u0081\2\2\u0314\u0313\3\2\2\2\u0314\u0315\3\2\2\2\u0315"+
		"\u0316\3\2\2\2\u0316\u032a\5*\26\7\u0317\u0318\f\5\2\2\u0318\u031a\t!"+
		"\2\2\u0319\u031b\7\u0081\2\2\u031a\u0319\3\2\2\2\u031a\u031b\3\2\2\2\u031b"+
		"\u031c\3\2\2\2\u031c\u032a\5*\26\6\u031d\u031e\f\4\2\2\u031e\u0320\7*"+
		"\2\2\u031f\u0321\7\u0081\2\2\u0320\u031f\3\2\2\2\u0320\u0321\3\2\2\2\u0321"+
		"\u0322\3\2\2\2\u0322\u032a\5*\26\5\u0323\u0324\f\3\2\2\u0324\u0326\7."+
		"\2\2\u0325\u0327\7\u0081\2\2\u0326\u0325\3\2\2\2\u0326\u0327\3\2\2\2\u0327"+
		"\u0328\3\2\2\2\u0328\u032a\5*\26\4\u0329\u02ff\3\2\2\2\u0329\u0305\3\2"+
		"\2\2\u0329\u030b\3\2\2\2\u0329\u0311\3\2\2\2\u0329\u0317\3\2\2\2\u0329"+
		"\u031d\3\2\2\2\u0329\u0323\3\2\2\2\u032a\u032d\3\2\2\2\u032b\u0329\3\2"+
		"\2\2\u032b\u032c\3\2\2\2\u032c+\3\2\2\2\u032d\u032b\3\2\2\2\u032e\u0332"+
		"\7\6\2\2\u032f\u0331\7\u0081\2\2\u0330\u032f\3\2\2\2\u0331\u0334\3\2\2"+
		"\2\u0332\u0330\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u0335\3\2\2\2\u0334\u0332"+
		"\3\2\2\2\u0335\u0339\7c\2\2\u0336\u0338\7\u0081\2\2\u0337\u0336\3\2\2"+
		"\2\u0338\u033b\3\2\2\2\u0339\u0337\3\2\2\2\u0339\u033a\3\2\2\2\u033a\u033d"+
		"\3\2\2\2\u033b\u0339\3\2\2\2\u033c\u033e\5\16\b\2\u033d\u033c\3\2\2\2"+
		"\u033d\u033e\3\2\2\2\u033e\u0349\3\2\2\2\u033f\u0341\7\u0081\2\2\u0340"+
		"\u033f\3\2\2\2\u0341\u0342\3\2\2\2\u0342\u0340\3\2\2\2\u0342\u0343\3\2"+
		"\2\2\u0343\u0345\3\2\2\2\u0344\u0346\5\16\b\2\u0345\u0344\3\2\2\2\u0345"+
		"\u0346\3\2\2\2\u0346\u0348\3\2\2\2\u0347\u0340\3\2\2\2\u0348\u034b\3\2"+
		"\2\2\u0349\u0347\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u034c\3\2\2\2\u034b"+
		"\u0349\3\2\2\2\u034c\u034d\5.\30\2\u034d\u0351\7\7\2\2\u034e\u0350\7\u0081"+
		"\2\2\u034f\u034e\3\2\2\2\u0350\u0353\3\2\2\2\u0351\u034f\3\2\2\2\u0351"+
		"\u0352\3\2\2\2\u0352-\3\2\2\2\u0353\u0351\3\2\2\2\u0354\u035d\7w\2\2\u0355"+
		"\u035a\7~\2\2\u0356\u0357\7\3\2\2\u0357\u0359\7~\2\2\u0358\u0356\3\2\2"+
		"\2\u0359\u035c\3\2\2\2\u035a\u0358\3\2\2\2\u035a\u035b\3\2\2\2\u035b\u035e"+
		"\3\2\2\2\u035c\u035a\3\2\2\2\u035d\u0355\3\2\2\2\u035d\u035e\3\2\2\2\u035e"+
		"\u0362\3\2\2\2\u035f\u0361\7\u0081\2\2\u0360\u035f\3\2\2\2\u0361\u0364"+
		"\3\2\2\2\u0362\u0360\3\2\2\2\u0362\u0363\3\2\2\2\u0363/\3\2\2\2\u0364"+
		"\u0362\3\2\2\2\u0365\u0369\7\6\2\2\u0366\u0368\7\u0081\2\2\u0367\u0366"+
		"\3\2\2\2\u0368\u036b\3\2\2\2\u0369\u0367\3\2\2\2\u0369\u036a\3\2\2\2\u036a"+
		"\u0381\3\2\2\2\u036b\u0369\3\2\2\2\u036c\u0370\t\"\2\2\u036d\u036f\7\u0081"+
		"\2\2\u036e\u036d\3\2\2\2\u036f\u0372\3\2\2\2\u0370\u036e\3\2\2\2\u0370"+
		"\u0371\3\2\2\2\u0371\u0373\3\2\2\2\u0372\u0370\3\2\2\2\u0373\u037e\5\16"+
		"\b\2\u0374\u0376\7\u0081\2\2\u0375\u0374\3\2\2\2\u0376\u0377\3\2\2\2\u0377"+
		"\u0375\3\2\2\2\u0377\u0378\3\2\2\2\u0378\u037a\3\2\2\2\u0379\u037b\5\16"+
		"\b\2\u037a\u0379\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u037d\3\2\2\2\u037c"+
		"\u0375\3\2\2\2\u037d\u0380\3\2\2\2\u037e\u037c\3\2\2\2\u037e\u037f\3\2"+
		"\2\2\u037f\u0382\3\2\2\2\u0380\u037e\3\2\2\2\u0381\u036c\3\2\2\2\u0381"+
		"\u0382\3\2\2\2\u0382\u0386\3\2\2\2\u0383\u0385\7\u0081\2\2\u0384\u0383"+
		"\3\2\2\2\u0385\u0388\3\2\2\2\u0386\u0384\3\2\2\2\u0386\u0387\3\2\2\2\u0387"+
		"\u038a\3\2\2\2\u0388\u0386\3\2\2\2\u0389\u038b\5.\30\2\u038a\u0389\3\2"+
		"\2\2\u038a\u038b\3\2\2\2\u038b\u03a1\3\2\2\2\u038c\u0390\t#\2\2\u038d"+
		"\u038f\7\u0081\2\2\u038e\u038d\3\2\2\2\u038f\u0392\3\2\2\2\u0390\u038e"+
		"\3\2\2\2\u0390\u0391\3\2\2\2\u0391\u0393\3\2\2\2\u0392\u0390\3\2\2\2\u0393"+
		"\u039e\5\16\b\2\u0394\u0396\7\u0081\2\2\u0395\u0394\3\2\2\2\u0396\u0397"+
		"\3\2\2\2\u0397\u0395\3\2\2\2\u0397\u0398\3\2\2\2\u0398\u039a\3\2\2\2\u0399"+
		"\u039b\5\16\b\2\u039a\u0399\3\2\2\2\u039a\u039b\3\2\2\2\u039b\u039d\3"+
		"\2\2\2\u039c\u0395\3\2\2\2\u039d\u03a0\3\2\2\2\u039e\u039c\3\2\2\2\u039e"+
		"\u039f\3\2\2\2\u039f\u03a2\3\2\2\2\u03a0\u039e\3\2\2\2\u03a1\u038c\3\2"+
		"\2\2\u03a1\u03a2\3\2\2\2\u03a2\u03a6\3\2\2\2\u03a3\u03a5\7\u0081\2\2\u03a4"+
		"\u03a3\3\2\2\2\u03a5\u03a8\3\2\2\2\u03a6\u03a4\3\2\2\2\u03a6\u03a7\3\2"+
		"\2\2\u03a7\u03a9\3\2\2\2\u03a8\u03a6\3\2\2\2\u03a9\u03ad\7\7\2\2\u03aa"+
		"\u03ac\7\u0081\2\2\u03ab\u03aa\3\2\2\2\u03ac\u03af\3\2\2\2\u03ad\u03ab"+
		"\3\2\2\2\u03ad\u03ae\3\2\2\2\u03ae\61\3\2\2\2\u03af\u03ad\3\2\2\2\u03b0"+
		"\u03b4\7\6\2\2\u03b1\u03b3\7\u0081\2\2\u03b2\u03b1\3\2\2\2\u03b3\u03b6"+
		"\3\2\2\2\u03b4\u03b2\3\2\2\2\u03b4\u03b5\3\2\2\2\u03b5\u03b7\3\2\2\2\u03b6"+
		"\u03b4\3\2\2\2\u03b7\u03bb\7c\2\2\u03b8\u03ba\7\u0081\2\2\u03b9\u03b8"+
		"\3\2\2\2\u03ba\u03bd\3\2\2\2\u03bb\u03b9\3\2\2\2\u03bb\u03bc\3\2\2\2\u03bc"+
		"\u03bf\3\2\2\2\u03bd\u03bb\3\2\2\2\u03be\u03c0\5\16\b\2\u03bf\u03be\3"+
		"\2\2\2\u03bf\u03c0\3\2\2\2\u03c0\u03cb\3\2\2\2\u03c1\u03c3\7\u0081\2\2"+
		"\u03c2\u03c1\3\2\2\2\u03c3\u03c4\3\2\2\2\u03c4\u03c2\3\2\2\2\u03c4\u03c5"+
		"\3\2\2\2\u03c5\u03c7\3\2\2\2\u03c6\u03c8\5\16\b\2\u03c7\u03c6\3\2\2\2"+
		"\u03c7\u03c8\3\2\2\2\u03c8\u03ca\3\2\2\2\u03c9\u03c2\3\2\2\2\u03ca\u03cd"+
		"\3\2\2\2\u03cb\u03c9\3\2\2\2\u03cb\u03cc\3\2\2\2\u03cc\u03ce\3\2\2\2\u03cd"+
		"\u03cb\3\2\2\2\u03ce\u03d2\7\7\2\2\u03cf\u03d1\7\u0081\2\2\u03d0\u03cf"+
		"\3\2\2\2\u03d1\u03d4\3\2\2\2\u03d2\u03d0\3\2\2\2\u03d2\u03d3\3\2\2\2\u03d3"+
		"\63\3\2\2\2\u03d4\u03d2\3\2\2\2\u00928<AQT\\bikotw{\u0082\u008f\u0096"+
		"\u00a3\u00a8\u00ab\u00af\u00b3\u00be\u00cc\u00dd\u00e0\u00e4\u00e9\u00ef"+
		"\u00f5\u00fb\u0101\u0107\u010d\u0110\u0112\u011b\u0125\u0129\u0130\u0136"+
		"\u013d\u0143\u0149\u0151\u0157\u015e\u0165\u016c\u0176\u017e\u0184\u018b"+
		"\u0198\u01a3\u01ab\u01ae\u01b5\u01c3\u01cc\u01cf\u01d2\u01da\u01e1\u01e5"+
		"\u01ea\u01ed\u01f1\u01f8\u01fd\u0206\u020e\u021a\u021f\u0222\u0226\u022f"+
		"\u0236\u0245\u024f\u0256\u025f\u0266\u026e\u027e\u0285\u028d\u0290\u0296"+
		"\u029c\u02a3\u02ac\u02b1\u02b9\u02bc\u02c5\u02ca\u02d8\u02db\u02e0\u02ed"+
		"\u02f0\u02f6\u02fd\u0302\u0308\u030e\u0314\u031a\u0320\u0326\u0329\u032b"+
		"\u0332\u0339\u033d\u0342\u0345\u0349\u0351\u035a\u035d\u0362\u0369\u0370"+
		"\u0377\u037a\u037e\u0381\u0386\u038a\u0390\u0397\u039a\u039e\u03a1\u03a6"+
		"\u03ad\u03b4\u03bb\u03bf\u03c4\u03c7\u03cb\u03d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}