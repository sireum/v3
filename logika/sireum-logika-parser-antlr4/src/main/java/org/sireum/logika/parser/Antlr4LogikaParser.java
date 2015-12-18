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
		T__119=120, T__120=121, T__121=122, T__122=123, T__123=124, T__124=125, 
		HLINE=126, NUM=127, ID=128, STRING=129, RESERVED=130, NL=131, LINE_COMMENT=132, 
		COMMENT=133, WS=134, ERROR_CHAR=135;
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
		"'BigInt'", "'Z'", "'Seq'", "'ZS'", "'*'", "'/'", "'%'", "'+'", "'-'", 
		"'<'", "'<='", "'≤'", "'>'", "'>='", "'≥'", "'='", "'=='", "'!='", "'≠'", 
		"'not'", "'!'", "'~'", "'¬'", "'and'", "'&&'", "'^'", "'∧'", "'or'", "'||'", 
		"'V'", "'∨'", "'implies'", "'->'", "'→'", "'forall'", "'all'", "'A'", 
		"'∀'", "'exists'", "'some'", "'E'", "'∃'", "':'", "'|'", "'Boolean'", 
		"'B'", "'['", "']'", "'premise'", "'andi'", "'^i'", "'ande1'", "'^e1'", 
		"'ande2'", "'^e2'", "'ori1'", "'Vi1'", "'ori2'", "'Vi2'", "'ore'", "'Ve'", 
		"'impliesi'", "'impliese'", "'noti'", "'negi'", "'note'", "'nege'", "'bottome'", 
		"'falsee'", "'Pbc'", "'foralli'", "'alli'", "'Ai'", "'foralle'", "'alle'", 
		"'Ae'", "'existsi'", "'somei'", "'Ei'", "'existse'", "'somee'", "'Ee'", 
		"'algebra'", "'invariant'", "'auto'", "'import'", "'logika'", "'_'", "'\"\"\"'", 
		"'fact'", "'def'", "'var'", "'val'", "'assert'", "'if'", "'else'", "'while'", 
		"'print'", "'println'", "'Unit'", "'return'", "'readInt'", "'+:'", "'modifies'", 
		"'requires'", "'pre'", "'ensures'", "'post'"
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
		null, null, null, null, null, null, "HLINE", "NUM", "ID", "STRING", "RESERVED", 
		"NL", "LINE_COMMENT", "COMMENT", "WS", "ERROR_CHAR"
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
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID) {
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID );
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
				((UnaryContext)_localctx).op = match(T__25);
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
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
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
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
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
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(213);
				match(T__14);
				setState(222);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__37))) != 0) || ((((_la - 119)) & ~0x3f) == 0 && ((1L << (_la - 119)) & ((1L << (T__118 - 119)) | (1L << (NUM - 119)) | (1L << (ID - 119)))) != 0)) {
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
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
						if ( !(_la==T__24 || _la==T__25) ) {
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) ) {
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43))) != 0)) ) {
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0)) ) {
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__48) | (1L << T__49) | (1L << T__50))) != 0)) ) {
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
			setState(275);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0)) ) {
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
			setState(286);
			_la = _input.LA(1);
			if (_la==T__59) {
				{
				setState(284);
				match(T__59);
				setState(285);
				type();
				}
			}

			setState(288);
			match(T__60);
			setState(290);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(289);
				match(NL);
				}
			}

			setState(292);
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
			setState(313);
			switch (_input.LA(1)) {
			case T__61:
			case T__62:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				((BooleanTypeContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__61 || _la==T__62) ) {
					((BooleanTypeContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case T__17:
			case T__18:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				((IntTypeContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
					((IntTypeContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case T__19:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(296);
				((IntSeqTypeContext)_localctx).tb = match(T__19);
				setState(297);
				match(T__63);
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(298);
					match(NL);
					}
					}
					setState(303);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(304);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(308);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(305);
					match(NL);
					}
					}
					setState(310);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(311);
				((IntSeqTypeContext)_localctx).te = match(T__64);
				}
				break;
			case T__20:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(312);
				((IntSeqTypeContext)_localctx).t = match(T__20);
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
			setState(439);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(315);
				((PremiseContext)_localctx).t = match(T__65);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				switch (_input.LA(1)) {
				case T__66:
				case T__67:
					{
					setState(316);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__66 || _la==T__67) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__41:
				case T__43:
					{
					setState(317);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__41 || _la==T__43) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(318);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(321);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(322);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(326);
				switch (_input.LA(1)) {
				case T__68:
				case T__69:
				case T__70:
				case T__71:
					{
					setState(323);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (T__68 - 69)) | (1L << (T__69 - 69)) | (1L << (T__70 - 69)) | (1L << (T__71 - 69)))) != 0)) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__41:
				case T__43:
					{
					setState(324);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__41 || _la==T__43) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(332);
				switch (_input.LA(1)) {
				case T__72:
				case T__73:
				case T__74:
				case T__75:
					{
					setState(329);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__74 - 73)) | (1L << (T__75 - 73)))) != 0)) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__45:
				case T__47:
					{
					setState(330);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__45 || _la==T__47) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(338);
				switch (_input.LA(1)) {
				case T__76:
				case T__77:
					{
					setState(335);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__76 || _la==T__77) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__45:
				case T__47:
					{
					setState(336);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__45 || _la==T__47) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(337);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(340);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(341);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(342);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(346);
				switch (_input.LA(1)) {
				case T__78:
					{
					setState(343);
					((ImpliesIntroContext)_localctx).tb = match(T__78);
					}
					break;
				case T__49:
				case T__50:
					{
					setState(344);
					((ImpliesIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__49 || _la==T__50) ) {
						((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(352);
				switch (_input.LA(1)) {
				case T__79:
					{
					setState(349);
					((ImpliesElimContext)_localctx).tb = match(T__79);
					}
					break;
				case T__49:
				case T__50:
					{
					setState(350);
					((ImpliesElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__49 || _la==T__50) ) {
						((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(351);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(354);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(355);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(359);
				switch (_input.LA(1)) {
				case T__80:
				case T__81:
					{
					setState(356);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__80 || _la==T__81) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__37:
				case T__38:
				case T__39:
					{
					setState(357);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(358);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(361);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(366);
				switch (_input.LA(1)) {
				case T__82:
					{
					setState(362);
					((NegElimContext)_localctx).tb = match(T__82);
					}
					break;
				case T__83:
					{
					setState(363);
					((NegElimContext)_localctx).tb = match(T__83);
					}
					break;
				case T__37:
				case T__38:
				case T__39:
					{
					setState(364);
					((NegElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
						((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(365);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(368);
				((NegElimContext)_localctx).step = match(NUM);
				setState(369);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(373);
				switch (_input.LA(1)) {
				case T__84:
				case T__85:
					{
					setState(370);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__84 || _la==T__85) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__12:
				case T__13:
					{
					setState(371);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__12 || _la==T__13) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(372);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(375);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 11:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(376);
				((PbcContext)_localctx).tb = match(T__86);
				setState(377);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 12:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(383);
				switch (_input.LA(1)) {
				case T__87:
					{
					setState(378);
					((ForallIntroContext)_localctx).tb = match(T__87);
					}
					break;
				case T__88:
					{
					setState(379);
					((ForallIntroContext)_localctx).tb = match(T__88);
					}
					break;
				case T__89:
					{
					setState(380);
					((ForallIntroContext)_localctx).tb = match(T__89);
					}
					break;
				case T__54:
					{
					setState(381);
					((ForallIntroContext)_localctx).tb = match(T__54);
					setState(382);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(385);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(391);
				switch (_input.LA(1)) {
				case T__90:
					{
					setState(386);
					((ForallElimContext)_localctx).tb = match(T__90);
					}
					break;
				case T__91:
					{
					setState(387);
					((ForallElimContext)_localctx).tb = match(T__91);
					}
					break;
				case T__92:
					{
					setState(388);
					((ForallElimContext)_localctx).tb = match(T__92);
					}
					break;
				case T__54:
					{
					setState(389);
					((ForallElimContext)_localctx).tb = match(T__54);
					setState(390);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(393);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 14:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(399);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (T__93 - 94)) | (1L << (T__94 - 94)) | (1L << (T__95 - 94)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(400);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(402); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(401);
					formula(0);
					}
					}
					setState(404); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 15:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(406);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (T__96 - 97)) | (1L << (T__97 - 97)) | (1L << (T__98 - 97)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(407);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(408);
				((ExistsElimContext)_localctx).subproof = match(NUM);
				}
				break;
			case 16:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(410);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(411);
				((ExistsIntroContext)_localctx).tb = match(T__58);
				setState(412);
				match(ID);
				setState(413);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(415); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(414);
					formula(0);
					}
					}
					setState(417); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 17:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(419);
				((ExistsElimContext)_localctx).tb = match(T__58);
				setState(420);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(421);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(422);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(424);
				((AlgebraContext)_localctx).tb = match(T__99);
				setState(428);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(425);
					((AlgebraContext)_localctx).numOrId = numOrId();
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).numOrId);
					}
					}
					setState(430);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(431);
				((InvariantContext)_localctx).tb = match(T__100);
				}
				break;
			case 20:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(432);
				((AutoContext)_localctx).tb = match(T__101);
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(433);
					((AutoContext)_localctx).numOrId = numOrId();
					((AutoContext)_localctx).stepOrFacts.add(((AutoContext)_localctx).numOrId);
					}
					}
					setState(438);
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
			setState(441);
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
			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(443);
				match(NL);
				}
				}
				setState(448);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(475);
			_la = _input.LA(1);
			if (_la==T__102) {
				{
				setState(449);
				((ProgramContext)_localctx).tb = match(T__102);
				setState(450);
				((ProgramContext)_localctx).org = match(ID);
				setState(451);
				match(T__5);
				setState(452);
				((ProgramContext)_localctx).sireum = match(ID);
				setState(453);
				match(T__5);
				setState(454);
				match(T__103);
				setState(455);
				match(T__5);
				setState(456);
				((ProgramContext)_localctx).te = match(T__104);
				setState(458); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(457);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(460); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(472);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(462);
					lgk();
					setState(463);
					match(T__105);
					setState(464);
					facts();
					setState(465);
					((ProgramContext)_localctx).te = match(T__105);
					setState(469);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(466);
							match(NL);
							}
							} 
						}
						setState(471);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
					}
					}
					break;
				}
				setState(474);
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
			setState(477);
			_la = _input.LA(1);
			if ( !(_la==T__103 || _la==ID) ) {
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
			setState(479);
			match(T__3);
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
			((FactsContext)_localctx).ftb = match(T__106);
			setState(490);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(487);
					match(NL);
					}
					} 
				}
				setState(492);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			}
			setState(494);
			_la = _input.LA(1);
			if (_la==T__107 || _la==ID) {
				{
				setState(493);
				factOrFun();
				}
			}

			setState(506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(497); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(496);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(499); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(502);
				_la = _input.LA(1);
				if (_la==T__107 || _la==ID) {
					{
					setState(501);
					factOrFun();
					}
				}

				}
				}
				setState(508);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(509);
			((FactsContext)_localctx).te = match(T__4);
			setState(513);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(510);
				match(NL);
				}
				}
				setState(515);
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
			setState(518);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(516);
				fact();
				}
				break;
			case T__107:
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
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
			setState(520);
			match(ID);
			setState(521);
			match(T__5);
			setState(522);
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
			setState(524);
			((FunContext)_localctx).tb = match(T__107);
			setState(525);
			match(ID);
			setState(527);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(526);
				match(NL);
				}
			}

			setState(529);
			match(T__14);
			setState(530);
			param();
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(531);
				match(T__0);
				setState(532);
				param();
				}
				}
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(538);
			match(T__15);
			setState(539);
			match(T__59);
			setState(540);
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
			setState(542);
			match(ID);
			setState(543);
			match(T__59);
			setState(544);
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
			setState(547);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__37))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (T__103 - 104)) | (1L << (T__107 - 104)) | (1L << (T__108 - 104)) | (1L << (T__109 - 104)) | (1L << (T__110 - 104)) | (1L << (T__111 - 104)) | (1L << (T__113 - 104)) | (1L << (T__114 - 104)) | (1L << (T__115 - 104)) | (1L << (T__118 - 104)) | (1L << (NUM - 104)) | (1L << (ID - 104)))) != 0)) {
				{
				setState(546);
				stmt();
				}
			}

			setState(559);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(550); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(549);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(552); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(555);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__37))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (T__103 - 104)) | (1L << (T__107 - 104)) | (1L << (T__108 - 104)) | (1L << (T__109 - 104)) | (1L << (T__110 - 104)) | (1L << (T__111 - 104)) | (1L << (T__113 - 104)) | (1L << (T__114 - 104)) | (1L << (T__115 - 104)) | (1L << (T__118 - 104)) | (1L << (NUM - 104)) | (1L << (ID - 104)))) != 0)) {
					{
					setState(554);
					stmt();
					}
				}

				}
				}
				setState(561);
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
			setState(723);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(562);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__108 || _la==T__109) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(563);
				match(ID);
				setState(564);
				match(T__59);
				setState(565);
				type();
				setState(566);
				match(T__32);
				setState(568);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(567);
					match(NL);
					}
				}

				setState(570);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(572);
				match(ID);
				setState(573);
				match(T__32);
				setState(575);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(574);
					match(NL);
					}
				}

				setState(577);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(578);
				match(T__110);
				setState(579);
				match(T__14);
				setState(580);
				exp(0);
				setState(581);
				match(T__15);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(583);
				match(T__111);
				setState(584);
				match(T__14);
				setState(585);
				exp(0);
				setState(586);
				match(T__15);
				setState(590);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(587);
					match(NL);
					}
					}
					setState(592);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(593);
				match(T__3);
				setState(594);
				((IfStmtContext)_localctx).ts = stmts();
				setState(595);
				match(T__4);
				setState(607);
				_la = _input.LA(1);
				if (_la==T__112) {
					{
					setState(596);
					match(T__112);
					setState(600);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(597);
						match(NL);
						}
						}
						setState(602);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(603);
					match(T__3);
					setState(604);
					((IfStmtContext)_localctx).fs = stmts();
					setState(605);
					match(T__4);
					}
				}

				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(609);
				match(T__113);
				setState(610);
				match(T__14);
				setState(611);
				exp(0);
				setState(612);
				match(T__15);
				setState(616);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(613);
					match(NL);
					}
					}
					setState(618);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(619);
				match(T__3);
				setState(631);
				switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
				case 1:
					{
					setState(623);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(620);
						match(NL);
						}
						}
						setState(625);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(626);
					lgk();
					setState(627);
					match(T__105);
					setState(628);
					loopInvariant();
					setState(629);
					match(T__105);
					}
					break;
				}
				setState(633);
				stmts();
				setState(634);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(636);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__114 || _la==T__115) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(637);
				match(T__14);
				setState(638);
				((PrintStmtContext)_localctx).s = match(ID);
				setState(639);
				match(STRING);
				setState(640);
				match(T__15);
				}
				break;
			case 7:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(641);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(642);
				match(T__14);
				setState(643);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(644);
				match(T__15);
				setState(645);
				match(T__32);
				setState(647);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(646);
					match(NL);
					}
				}

				setState(649);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 8:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(651);
				match(T__107);
				setState(652);
				match(ID);
				setState(654);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(653);
					match(NL);
					}
				}

				setState(656);
				match(T__14);
				setState(665);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(657);
					param();
					setState(662);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(658);
						match(T__0);
						setState(659);
						param();
						}
						}
						setState(664);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(667);
				match(T__15);
				setState(668);
				match(T__59);
				setState(671);
				switch (_input.LA(1)) {
				case T__17:
				case T__18:
				case T__19:
				case T__20:
				case T__61:
				case T__62:
					{
					setState(669);
					type();
					}
					break;
				case T__116:
					{
					setState(670);
					match(T__116);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(673);
				match(T__32);
				setState(677);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(674);
					match(NL);
					}
					}
					setState(679);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(680);
				match(T__3);
				setState(698);
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
				case 1:
					{
					setState(684);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(681);
						match(NL);
						}
						}
						setState(686);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(687);
					lgk();
					setState(688);
					match(T__105);
					setState(689);
					methodContract();
					setState(693);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(690);
						match(NL);
						}
						}
						setState(695);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(696);
					match(T__105);
					}
					break;
				}
				setState(700);
				stmts();
				setState(709);
				_la = _input.LA(1);
				if (_la==T__117) {
					{
					setState(701);
					((MethodDeclStmtContext)_localctx).rtb = match(T__117);
					setState(702);
					exp(0);
					setState(706);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(703);
						match(NL);
						}
						}
						setState(708);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(711);
				match(T__4);
				}
				break;
			case 9:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(713);
				lgk();
				setState(714);
				match(T__105);
				setState(718);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(715);
					proof();
					}
					break;
				case 2:
					{
					setState(716);
					sequent();
					}
					break;
				case 3:
					{
					setState(717);
					invariants();
					}
					break;
				}
				setState(720);
				match(T__105);
				}
				break;
			case 10:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(722);
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
			setState(774);
			switch (_input.LA(1)) {
			case T__25:
			case T__37:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(726);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__25 || _la==T__37) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(727);
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
				setState(728);
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
				setState(729);
				match(NUM);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(730);
				((IdExpContext)_localctx).tb = match(ID);
				setState(745);
				switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
				case 1:
					{
					setState(731);
					match(T__14);
					setState(740);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__37))) != 0) || ((((_la - 119)) & ~0x3f) == 0 && ((1L << (_la - 119)) & ((1L << (T__118 - 119)) | (1L << (NUM - 119)) | (1L << (ID - 119)))) != 0)) {
						{
						setState(732);
						exp(0);
						setState(737);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__0) {
							{
							{
							setState(733);
							match(T__0);
							setState(734);
							exp(0);
							}
							}
							setState(739);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(742);
					match(T__15);
					}
					break;
				case 2:
					{
					setState(743);
					match(T__5);
					setState(744);
					((IdExpContext)_localctx).te = match(ID);
					}
					break;
				}
				}
				break;
			case T__17:
			case T__18:
				{
				_localctx = new BigIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(747);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(748);
				match(T__14);
				setState(749);
				match(STRING);
				setState(750);
				match(T__15);
				}
				break;
			case T__19:
			case T__20:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(751);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(752);
				match(T__14);
				setState(761);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__37))) != 0) || ((((_la - 119)) & ~0x3f) == 0 && ((1L << (_la - 119)) & ((1L << (T__118 - 119)) | (1L << (NUM - 119)) | (1L << (ID - 119)))) != 0)) {
					{
					setState(753);
					exp(0);
					setState(758);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(754);
						match(T__0);
						setState(755);
						exp(0);
						}
						}
						setState(760);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(763);
				match(T__15);
				}
				break;
			case T__118:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(764);
				match(T__118);
				setState(765);
				match(T__14);
				setState(767);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(766);
					match(STRING);
					}
				}

				setState(769);
				match(T__15);
				}
				break;
			case T__14:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(770);
				match(T__14);
				setState(771);
				exp(0);
				setState(772);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(820);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(818);
					switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(776);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(777);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(779);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(778);
							match(NL);
							}
						}

						setState(781);
						((BinaryExpContext)_localctx).r = exp(8);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(782);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(783);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25 || _la==T__119) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(785);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(784);
							match(NL);
							}
						}

						setState(787);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(788);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(789);
						((BinaryExpContext)_localctx).op = match(T__119);
						setState(791);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(790);
							match(NL);
							}
						}

						setState(793);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(794);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(795);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__29) | (1L << T__30))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(797);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(796);
							match(NL);
							}
						}

						setState(799);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(800);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(801);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__33 || _la==T__34) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(803);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(802);
							match(NL);
							}
						}

						setState(805);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(806);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(807);
						((BinaryExpContext)_localctx).op = match(T__41);
						setState(809);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(808);
							match(NL);
							}
						}

						setState(811);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(812);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(813);
						((BinaryExpContext)_localctx).op = match(T__45);
						setState(815);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(814);
							match(NL);
							}
						}

						setState(817);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(822);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
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
			setState(823);
			((LoopInvariantContext)_localctx).tb = match(T__3);
			setState(827);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(824);
				match(NL);
				}
				}
				setState(829);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(830);
			((LoopInvariantContext)_localctx).itb = match(T__100);
			setState(834);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(831);
					match(NL);
					}
					} 
				}
				setState(836);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			}
			setState(838);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID) {
				{
				setState(837);
				formula(0);
				}
			}

			setState(850);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(841); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(840);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(843); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(846);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID) {
					{
					setState(845);
					formula(0);
					}
				}

				}
				}
				setState(852);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(853);
			modifies();
			setState(854);
			((LoopInvariantContext)_localctx).te = match(T__4);
			setState(858);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(855);
				match(NL);
				}
				}
				setState(860);
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
			setState(861);
			((ModifiesContext)_localctx).tb = match(T__120);
			setState(870);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(862);
				match(ID);
				setState(867);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(863);
					match(T__0);
					setState(864);
					match(ID);
					}
					}
					setState(869);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(875);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,123,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(872);
					match(NL);
					}
					} 
				}
				setState(877);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,123,_ctx);
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
			setState(878);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(882);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
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
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			}
			setState(906);
			_la = _input.LA(1);
			if (_la==T__121 || _la==T__122) {
				{
				setState(885);
				_la = _input.LA(1);
				if ( !(_la==T__121 || _la==T__122) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(889);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(886);
					match(NL);
					}
					}
					setState(891);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(892);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(903);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(894); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(893);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(896); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(899);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID) {
							{
							setState(898);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(905);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
				}
				}
			}

			setState(911);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(908);
					match(NL);
					}
					} 
				}
				setState(913);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			}
			setState(915);
			_la = _input.LA(1);
			if (_la==T__120) {
				{
				setState(914);
				modifies();
				}
			}

			setState(938);
			_la = _input.LA(1);
			if (_la==T__123 || _la==T__124) {
				{
				setState(917);
				_la = _input.LA(1);
				if ( !(_la==T__123 || _la==T__124) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(921);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(918);
					match(NL);
					}
					}
					setState(923);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(924);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(935);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(926); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(925);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(928); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(931);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID) {
							{
							setState(930);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(937);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
				}
				}
			}

			setState(943);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(940);
				match(NL);
				}
				}
				setState(945);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(946);
			((MethodContractContext)_localctx).te = match(T__4);
			setState(950);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(947);
					match(NL);
					}
					} 
				}
				setState(952);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
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
			setState(953);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(957);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(954);
				match(NL);
				}
				}
				setState(959);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(960);
			match(T__100);
			setState(964);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(961);
					match(NL);
					}
					} 
				}
				setState(966);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			}
			setState(968);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID) {
				{
				setState(967);
				formula(0);
				}
			}

			setState(980);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(971); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(970);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(973); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(976);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID) {
					{
					setState(975);
					formula(0);
					}
				}

				}
				}
				setState(982);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(983);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(987);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(984);
				match(NL);
				}
				}
				setState(989);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0089\u03e1\4\2\t"+
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
		"\t\3\t\5\t\u0121\n\t\3\t\3\t\5\t\u0125\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\7\n\u012e\n\n\f\n\16\n\u0131\13\n\3\n\3\n\7\n\u0135\n\n\f\n\16\n\u0138"+
		"\13\n\3\n\3\n\5\n\u013c\n\n\3\13\3\13\3\13\3\13\5\13\u0142\n\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u0149\n\13\3\13\3\13\3\13\3\13\5\13\u014f\n\13"+
		"\3\13\3\13\3\13\3\13\5\13\u0155\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u015d\n\13\3\13\3\13\3\13\3\13\5\13\u0163\n\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u016a\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0171\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u0178\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u0182\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u018a\n\13\3\13\3"+
		"\13\6\13\u018e\n\13\r\13\16\13\u018f\3\13\3\13\3\13\6\13\u0195\n\13\r"+
		"\13\16\13\u0196\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u01a2"+
		"\n\13\r\13\16\13\u01a3\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u01ad\n"+
		"\13\f\13\16\13\u01b0\13\13\3\13\3\13\3\13\7\13\u01b5\n\13\f\13\16\13\u01b8"+
		"\13\13\5\13\u01ba\n\13\3\f\3\f\3\r\7\r\u01bf\n\r\f\r\16\r\u01c2\13\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u01cd\n\r\r\r\16\r\u01ce\3\r\3"+
		"\r\3\r\3\r\3\r\7\r\u01d6\n\r\f\r\16\r\u01d9\13\r\5\r\u01db\n\r\3\r\5\r"+
		"\u01de\n\r\3\16\3\16\3\17\3\17\7\17\u01e4\n\17\f\17\16\17\u01e7\13\17"+
		"\3\17\3\17\7\17\u01eb\n\17\f\17\16\17\u01ee\13\17\3\17\5\17\u01f1\n\17"+
		"\3\17\6\17\u01f4\n\17\r\17\16\17\u01f5\3\17\5\17\u01f9\n\17\7\17\u01fb"+
		"\n\17\f\17\16\17\u01fe\13\17\3\17\3\17\7\17\u0202\n\17\f\17\16\17\u0205"+
		"\13\17\3\20\3\20\5\20\u0209\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\5"+
		"\22\u0212\n\22\3\22\3\22\3\22\3\22\7\22\u0218\n\22\f\22\16\22\u021b\13"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\5\24\u0226\n\24\3\24"+
		"\6\24\u0229\n\24\r\24\16\24\u022a\3\24\5\24\u022e\n\24\7\24\u0230\n\24"+
		"\f\24\16\24\u0233\13\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u023b\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u0242\n\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\7\25\u024f\n\25\f\25\16\25\u0252\13\25\3\25"+
		"\3\25\3\25\3\25\3\25\7\25\u0259\n\25\f\25\16\25\u025c\13\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0262\n\25\3\25\3\25\3\25\3\25\3\25\7\25\u0269\n\25\f"+
		"\25\16\25\u026c\13\25\3\25\3\25\7\25\u0270\n\25\f\25\16\25\u0273\13\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u027a\n\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u028a\n\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0291\n\25\3\25\3\25\3\25\3\25\7\25\u0297\n\25\f\25\16"+
		"\25\u029a\13\25\5\25\u029c\n\25\3\25\3\25\3\25\3\25\5\25\u02a2\n\25\3"+
		"\25\3\25\7\25\u02a6\n\25\f\25\16\25\u02a9\13\25\3\25\3\25\7\25\u02ad\n"+
		"\25\f\25\16\25\u02b0\13\25\3\25\3\25\3\25\3\25\7\25\u02b6\n\25\f\25\16"+
		"\25\u02b9\13\25\3\25\3\25\5\25\u02bd\n\25\3\25\3\25\3\25\3\25\7\25\u02c3"+
		"\n\25\f\25\16\25\u02c6\13\25\5\25\u02c8\n\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u02d1\n\25\3\25\3\25\3\25\5\25\u02d6\n\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u02e2\n\26\f\26\16\26\u02e5"+
		"\13\26\5\26\u02e7\n\26\3\26\3\26\3\26\5\26\u02ec\n\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\7\26\u02f7\n\26\f\26\16\26\u02fa\13\26\5"+
		"\26\u02fc\n\26\3\26\3\26\3\26\3\26\5\26\u0302\n\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u0309\n\26\3\26\3\26\3\26\5\26\u030e\n\26\3\26\3\26\3\26\3"+
		"\26\5\26\u0314\n\26\3\26\3\26\3\26\3\26\5\26\u031a\n\26\3\26\3\26\3\26"+
		"\3\26\5\26\u0320\n\26\3\26\3\26\3\26\3\26\5\26\u0326\n\26\3\26\3\26\3"+
		"\26\3\26\5\26\u032c\n\26\3\26\3\26\3\26\3\26\5\26\u0332\n\26\3\26\7\26"+
		"\u0335\n\26\f\26\16\26\u0338\13\26\3\27\3\27\7\27\u033c\n\27\f\27\16\27"+
		"\u033f\13\27\3\27\3\27\7\27\u0343\n\27\f\27\16\27\u0346\13\27\3\27\5\27"+
		"\u0349\n\27\3\27\6\27\u034c\n\27\r\27\16\27\u034d\3\27\5\27\u0351\n\27"+
		"\7\27\u0353\n\27\f\27\16\27\u0356\13\27\3\27\3\27\3\27\7\27\u035b\n\27"+
		"\f\27\16\27\u035e\13\27\3\30\3\30\3\30\3\30\7\30\u0364\n\30\f\30\16\30"+
		"\u0367\13\30\5\30\u0369\n\30\3\30\7\30\u036c\n\30\f\30\16\30\u036f\13"+
		"\30\3\31\3\31\7\31\u0373\n\31\f\31\16\31\u0376\13\31\3\31\3\31\7\31\u037a"+
		"\n\31\f\31\16\31\u037d\13\31\3\31\3\31\6\31\u0381\n\31\r\31\16\31\u0382"+
		"\3\31\5\31\u0386\n\31\7\31\u0388\n\31\f\31\16\31\u038b\13\31\5\31\u038d"+
		"\n\31\3\31\7\31\u0390\n\31\f\31\16\31\u0393\13\31\3\31\5\31\u0396\n\31"+
		"\3\31\3\31\7\31\u039a\n\31\f\31\16\31\u039d\13\31\3\31\3\31\6\31\u03a1"+
		"\n\31\r\31\16\31\u03a2\3\31\5\31\u03a6\n\31\7\31\u03a8\n\31\f\31\16\31"+
		"\u03ab\13\31\5\31\u03ad\n\31\3\31\7\31\u03b0\n\31\f\31\16\31\u03b3\13"+
		"\31\3\31\3\31\7\31\u03b7\n\31\f\31\16\31\u03ba\13\31\3\32\3\32\7\32\u03be"+
		"\n\32\f\32\16\32\u03c1\13\32\3\32\3\32\7\32\u03c5\n\32\f\32\16\32\u03c8"+
		"\13\32\3\32\5\32\u03cb\n\32\3\32\6\32\u03ce\n\32\r\32\16\32\u03cf\3\32"+
		"\5\32\u03d3\n\32\7\32\u03d5\n\32\f\32\16\32\u03d8\13\32\3\32\3\32\7\32"+
		"\u03dc\n\32\f\32\16\32\u03df\13\32\3\32\2\4\16*\33\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\2\'\3\2\4\5\3\2\'*\3\2\n\20\3\2\24\25"+
		"\3\2\26\27\3\2\30\32\3\2\33\34\3\2\35\"\3\2#&\3\2+.\3\2/\62\3\2\63\65"+
		"\3\2\66=\3\2@A\3\2EF\4\2,,..\3\2GJ\3\2KN\4\2\60\60\62\62\3\2OP\3\2\64"+
		"\65\3\2ST\3\2(*\3\2WX\3\2\17\20\3\2`b\3\2ce\3\2\u0081\u0082\4\2jj\u0082"+
		"\u0082\3\2op\3\2uv\4\2\34\34((\4\2\33\34zz\4\2\35\36 !\3\2$%\3\2|}\3\2"+
		"~\177\u0496\2\64\3\2\2\2\4F\3\2\2\2\6I\3\2\2\2\bk\3\2\2\2\nm\3\2\2\2\f"+
		"\u00b3\3\2\2\2\16\u00e4\3\2\2\2\20\u0115\3\2\2\2\22\u013b\3\2\2\2\24\u01b9"+
		"\3\2\2\2\26\u01bb\3\2\2\2\30\u01c0\3\2\2\2\32\u01df\3\2\2\2\34\u01e1\3"+
		"\2\2\2\36\u0208\3\2\2\2 \u020a\3\2\2\2\"\u020e\3\2\2\2$\u0220\3\2\2\2"+
		"&\u0225\3\2\2\2(\u02d5\3\2\2\2*\u0308\3\2\2\2,\u0339\3\2\2\2.\u035f\3"+
		"\2\2\2\60\u0370\3\2\2\2\62\u03bb\3\2\2\2\648\5\b\5\2\65\67\7\u0085\2\2"+
		"\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29<\3\2\2\2:8\3\2\2\2;"+
		"=\5\n\6\2<;\3\2\2\2<=\3\2\2\2=A\3\2\2\2>@\7\u0085\2\2?>\3\2\2\2@C\3\2"+
		"\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\2\2\3E\3\3\2\2\2FG\5"+
		"\n\6\2GH\7\2\2\3H\5\3\2\2\2IJ\5\30\r\2JK\7\2\2\3K\7\3\2\2\2LQ\5\16\b\2"+
		"MN\7\3\2\2NP\5\16\b\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RU\3\2\2"+
		"\2SQ\3\2\2\2TL\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\t\2\2\2W\\\5\16\b\2XY\7\3"+
		"\2\2Y[\5\16\b\2ZX\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]l\3\2\2\2^\\"+
		"\3\2\2\2_a\5\16\b\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2"+
		"db\3\2\2\2eg\7\u0080\2\2fh\5\16\b\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3"+
		"\2\2\2jl\3\2\2\2kT\3\2\2\2kb\3\2\2\2l\t\3\2\2\2mo\7\6\2\2np\5\f\7\2on"+
		"\3\2\2\2op\3\2\2\2p{\3\2\2\2qs\7\u0085\2\2rq\3\2\2\2st\3\2\2\2tr\3\2\2"+
		"\2tu\3\2\2\2uw\3\2\2\2vx\5\f\7\2wv\3\2\2\2wx\3\2\2\2xz\3\2\2\2yr\3\2\2"+
		"\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2~\u0082\7\7\2\2\177"+
		"\u0081\7\u0085\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3"+
		"\2\2\2\u0082\u0083\3\2\2\2\u0083\13\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"\u0086\7\u0081\2\2\u0086\u0087\7\b\2\2\u0087\u0088\5\16\b\2\u0088\u0089"+
		"\5\24\13\2\u0089\u00b4\3\2\2\2\u008a\u008b\7\u0081\2\2\u008b\u008f\7\b"+
		"\2\2\u008c\u008e\7\u0085\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0092\u0096\7\6\2\2\u0093\u0095\7\u0085\2\2\u0094\u0093\3\2\2\2\u0095"+
		"\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0099\u009a\7\u0081\2\2\u009a\u00a3\7\b\2\2\u009b"+
		"\u00a4\7\u0082\2\2\u009c\u009d\5\16\b\2\u009d\u009e\7\t\2\2\u009e\u00a4"+
		"\3\2\2\2\u009f\u00a0\7\u0082\2\2\u00a0\u00a1\5\16\b\2\u00a1\u00a2\7\t"+
		"\2\2\u00a2\u00a4\3\2\2\2\u00a3\u009b\3\2\2\2\u00a3\u009c\3\2\2\2\u00a3"+
		"\u009f\3\2\2\2\u00a4\u00af\3\2\2\2\u00a5\u00a7\7\u0085\2\2\u00a6\u00a5"+
		"\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00ab\3\2\2\2\u00aa\u00ac\5\f\7\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00a6\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2"+
		"\2\2\u00b2\u00b4\7\7\2\2\u00b3\u0085\3\2\2\2\u00b3\u008a\3\2\2\2\u00b4"+
		"\r\3\2\2\2\u00b5\u00b6\b\b\1\2\u00b6\u00b7\7\34\2\2\u00b7\u00e5\5\16\b"+
		"\b\u00b8\u00b9\t\3\2\2\u00b9\u00e5\5\16\b\7\u00ba\u00e5\t\4\2\2\u00bb"+
		"\u00be\7\u0082\2\2\u00bc\u00bd\7\b\2\2\u00bd\u00bf\7\u0082\2\2\u00be\u00bc"+
		"\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00e5\3\2\2\2\u00c0\u00c1\7\21\2\2"+
		"\u00c1\u00c2\5\16\b\2\u00c2\u00c3\7\22\2\2\u00c3\u00e5\3\2\2\2\u00c4\u00e5"+
		"\7\23\2\2\u00c5\u00c6\7\u0082\2\2\u00c6\u00c7\7\21\2\2\u00c7\u00cc\5\16"+
		"\b\2\u00c8\u00c9\7\3\2\2\u00c9\u00cb\5\16\b\2\u00ca\u00c8\3\2\2\2\u00cb"+
		"\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2"+
		"\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\7\22\2\2\u00d0\u00e5\3\2\2\2\u00d1"+
		"\u00e5\7\u0081\2\2\u00d2\u00d3\t\5\2\2\u00d3\u00d4\7\21\2\2\u00d4\u00d5"+
		"\7\u0083\2\2\u00d5\u00e5\7\22\2\2\u00d6\u00d7\t\6\2\2\u00d7\u00e0\7\21"+
		"\2\2\u00d8\u00dd\5*\26\2\u00d9\u00da\7\3\2\2\u00da\u00dc\5*\26\2\u00db"+
		"\u00d9\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2"+
		"\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00d8\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e5\7\22\2\2\u00e3\u00e5\5"+
		"\20\t\2\u00e4\u00b5\3\2\2\2\u00e4\u00b8\3\2\2\2\u00e4\u00ba\3\2\2\2\u00e4"+
		"\u00bb\3\2\2\2\u00e4\u00c0\3\2\2\2\u00e4\u00c4\3\2\2\2\u00e4\u00c5\3\2"+
		"\2\2\u00e4\u00d1\3\2\2\2\u00e4\u00d2\3\2\2\2\u00e4\u00d6\3\2\2\2\u00e4"+
		"\u00e3\3\2\2\2\u00e5\u0112\3\2\2\2\u00e6\u00e7\f\f\2\2\u00e7\u00e9\t\7"+
		"\2\2\u00e8\u00ea\7\u0085\2\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\u0111\5\16\b\r\u00ec\u00ed\f\13\2\2\u00ed\u00ef\t"+
		"\b\2\2\u00ee\u00f0\7\u0085\2\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2"+
		"\u00f0\u00f1\3\2\2\2\u00f1\u0111\5\16\b\f\u00f2\u00f3\f\n\2\2\u00f3\u00f5"+
		"\t\t\2\2\u00f4\u00f6\7\u0085\2\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2"+
		"\2\u00f6\u00f7\3\2\2\2\u00f7\u0111\5\16\b\13\u00f8\u00f9\f\t\2\2\u00f9"+
		"\u00fb\t\n\2\2\u00fa\u00fc\7\u0085\2\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc"+
		"\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u0111\5\16\b\n\u00fe\u00ff\f\6\2\2"+
		"\u00ff\u0101\t\13\2\2\u0100\u0102\7\u0085\2\2\u0101\u0100\3\2\2\2\u0101"+
		"\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0111\5\16\b\7\u0104\u0105\f"+
		"\5\2\2\u0105\u0107\t\f\2\2\u0106\u0108\7\u0085\2\2\u0107\u0106\3\2\2\2"+
		"\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u0111\5\16\b\6\u010a\u010b"+
		"\f\4\2\2\u010b\u010d\t\r\2\2\u010c\u010e\7\u0085\2\2\u010d\u010c\3\2\2"+
		"\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\5\16\b\5\u0110"+
		"\u00e6\3\2\2\2\u0110\u00ec\3\2\2\2\u0110\u00f2\3\2\2\2\u0110\u00f8\3\2"+
		"\2\2\u0110\u00fe\3\2\2\2\u0110\u0104\3\2\2\2\u0110\u010a\3\2\2\2\u0111"+
		"\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\17\3\2\2"+
		"\2\u0114\u0112\3\2\2\2\u0115\u0116\t\16\2\2\u0116\u011b\7\u0082\2\2\u0117"+
		"\u0118\7\3\2\2\u0118\u011a\7\u0082\2\2\u0119\u0117\3\2\2\2\u011a\u011d"+
		"\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u0120\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011e\u011f\7>\2\2\u011f\u0121\5\22\n\2\u0120\u011e\3\2"+
		"\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0124\7?\2\2\u0123"+
		"\u0125\7\u0085\2\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126"+
		"\3\2\2\2\u0126\u0127\5\16\b\2\u0127\21\3\2\2\2\u0128\u013c\t\17\2\2\u0129"+
		"\u013c\t\5\2\2\u012a\u012b\7\26\2\2\u012b\u012f\7B\2\2\u012c\u012e\7\u0085"+
		"\2\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0136\t\5"+
		"\2\2\u0133\u0135\7\u0085\2\2\u0134\u0133\3\2\2\2\u0135\u0138\3\2\2\2\u0136"+
		"\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0139\3\2\2\2\u0138\u0136\3\2"+
		"\2\2\u0139\u013c\7C\2\2\u013a\u013c\7\27\2\2\u013b\u0128\3\2\2\2\u013b"+
		"\u0129\3\2\2\2\u013b\u012a\3\2\2\2\u013b\u013a\3\2\2\2\u013c\23\3\2\2"+
		"\2\u013d\u01ba\7D\2\2\u013e\u0142\t\20\2\2\u013f\u0140\t\21\2\2\u0140"+
		"\u0142\7\u0082\2\2\u0141\u013e\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0143"+
		"\3\2\2\2\u0143\u0144\7\u0081\2\2\u0144\u01ba\7\u0081\2\2\u0145\u0149\t"+
		"\22\2\2\u0146\u0147\t\21\2\2\u0147\u0149\7\u0082\2\2\u0148\u0145\3\2\2"+
		"\2\u0148\u0146\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u01ba\7\u0081\2\2\u014b"+
		"\u014f\t\23\2\2\u014c\u014d\t\24\2\2\u014d\u014f\7\u0082\2\2\u014e\u014b"+
		"\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u01ba\7\u0081\2"+
		"\2\u0151\u0155\t\25\2\2\u0152\u0153\t\24\2\2\u0153\u0155\7\u0082\2\2\u0154"+
		"\u0151\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\7\u0081"+
		"\2\2\u0157\u0158\7\u0081\2\2\u0158\u01ba\7\u0081\2\2\u0159\u015d\7Q\2"+
		"\2\u015a\u015b\t\26\2\2\u015b\u015d\7\u0082\2\2\u015c\u0159\3\2\2\2\u015c"+
		"\u015a\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u01ba\7\u0081\2\2\u015f\u0163"+
		"\7R\2\2\u0160\u0161\t\26\2\2\u0161\u0163\7\u0082\2\2\u0162\u015f\3\2\2"+
		"\2\u0162\u0160\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\7\u0081\2\2\u0165"+
		"\u01ba\7\u0081\2\2\u0166\u016a\t\27\2\2\u0167\u0168\t\30\2\2\u0168\u016a"+
		"\7\u0082\2\2\u0169\u0166\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016b\3\2\2"+
		"\2\u016b\u01ba\7\u0081\2\2\u016c\u0171\7U\2\2\u016d\u0171\7V\2\2\u016e"+
		"\u016f\t\30\2\2\u016f\u0171\7\u0082\2\2\u0170\u016c\3\2\2\2\u0170\u016d"+
		"\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0173\7\u0081\2"+
		"\2\u0173\u01ba\7\u0081\2\2\u0174\u0178\t\31\2\2\u0175\u0176\t\32\2\2\u0176"+
		"\u0178\7\u0082\2\2\u0177\u0174\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u0179"+
		"\3\2\2\2\u0179\u01ba\7\u0081\2\2\u017a\u017b\7Y\2\2\u017b\u01ba\7\u0081"+
		"\2\2\u017c\u0182\7Z\2\2\u017d\u0182\7[\2\2\u017e\u0182\7\\\2\2\u017f\u0180"+
		"\79\2\2\u0180\u0182\7\u0082\2\2\u0181\u017c\3\2\2\2\u0181\u017d\3\2\2"+
		"\2\u0181\u017e\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u01ba"+
		"\7\u0081\2\2\u0184\u018a\7]\2\2\u0185\u018a\7^\2\2\u0186\u018a\7_\2\2"+
		"\u0187\u0188\79\2\2\u0188\u018a\7\u0082\2\2\u0189\u0184\3\2\2\2\u0189"+
		"\u0185\3\2\2\2\u0189\u0186\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018b\3\2"+
		"\2\2\u018b\u018d\5\26\f\2\u018c\u018e\5\16\b\2\u018d\u018c\3\2\2\2\u018e"+
		"\u018f\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u01ba\3\2"+
		"\2\2\u0191\u0192\t\33\2\2\u0192\u0194\7\u0081\2\2\u0193\u0195\5\16\b\2"+
		"\u0194\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197"+
		"\3\2\2\2\u0197\u01ba\3\2\2\2\u0198\u0199\t\34\2\2\u0199\u019a\5\26\f\2"+
		"\u019a\u019b\7\u0081\2\2\u019b\u01ba\3\2\2\2\u019c\u019d\6\13\t\2\u019d"+
		"\u019e\7=\2\2\u019e\u019f\7\u0082\2\2\u019f\u01a1\7\u0081\2\2\u01a0\u01a2"+
		"\5\16\b\2\u01a1\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a1\3\2\2\2"+
		"\u01a3\u01a4\3\2\2\2\u01a4\u01ba\3\2\2\2\u01a5\u01a6\7=\2\2\u01a6\u01a7"+
		"\7\u0082\2\2\u01a7\u01a8\5\26\f\2\u01a8\u01a9\7\u0081\2\2\u01a9\u01ba"+
		"\3\2\2\2\u01aa\u01ae\7f\2\2\u01ab\u01ad\5\26\f\2\u01ac\u01ab\3\2\2\2\u01ad"+
		"\u01b0\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01ba\3\2"+
		"\2\2\u01b0\u01ae\3\2\2\2\u01b1\u01ba\7g\2\2\u01b2\u01b6\7h\2\2\u01b3\u01b5"+
		"\5\26\f\2\u01b4\u01b3\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2"+
		"\u01b6\u01b7\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u013d"+
		"\3\2\2\2\u01b9\u0141\3\2\2\2\u01b9\u0148\3\2\2\2\u01b9\u014e\3\2\2\2\u01b9"+
		"\u0154\3\2\2\2\u01b9\u015c\3\2\2\2\u01b9\u0162\3\2\2\2\u01b9\u0169\3\2"+
		"\2\2\u01b9\u0170\3\2\2\2\u01b9\u0177\3\2\2\2\u01b9\u017a\3\2\2\2\u01b9"+
		"\u0181\3\2\2\2\u01b9\u0189\3\2\2\2\u01b9\u0191\3\2\2\2\u01b9\u0198\3\2"+
		"\2\2\u01b9\u019c\3\2\2\2\u01b9\u01a5\3\2\2\2\u01b9\u01aa\3\2\2\2\u01b9"+
		"\u01b1\3\2\2\2\u01b9\u01b2\3\2\2\2\u01ba\25\3\2\2\2\u01bb\u01bc\t\35\2"+
		"\2\u01bc\27\3\2\2\2\u01bd\u01bf\7\u0085\2\2\u01be\u01bd\3\2\2\2\u01bf"+
		"\u01c2\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01dd\3\2"+
		"\2\2\u01c2\u01c0\3\2\2\2\u01c3\u01c4\7i\2\2\u01c4\u01c5\7\u0082\2\2\u01c5"+
		"\u01c6\7\b\2\2\u01c6\u01c7\7\u0082\2\2\u01c7\u01c8\7\b\2\2\u01c8\u01c9"+
		"\7j\2\2\u01c9\u01ca\7\b\2\2\u01ca\u01cc\7k\2\2\u01cb\u01cd\7\u0085\2\2"+
		"\u01cc\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf"+
		"\3\2\2\2\u01cf\u01da\3\2\2\2\u01d0\u01d1\5\32\16\2\u01d1\u01d2\7l\2\2"+
		"\u01d2\u01d3\5\34\17\2\u01d3\u01d7\7l\2\2\u01d4\u01d6\7\u0085\2\2\u01d5"+
		"\u01d4\3\2\2\2\u01d6\u01d9\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2"+
		"\2\2\u01d8\u01db\3\2\2\2\u01d9\u01d7\3\2\2\2\u01da\u01d0\3\2\2\2\u01da"+
		"\u01db\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01de\5&\24\2\u01dd\u01c3\3\2"+
		"\2\2\u01dd\u01de\3\2\2\2\u01de\31\3\2\2\2\u01df\u01e0\t\36\2\2\u01e0\33"+
		"\3\2\2\2\u01e1\u01e5\7\6\2\2\u01e2\u01e4\7\u0085\2\2\u01e3\u01e2\3\2\2"+
		"\2\u01e4\u01e7\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e8"+
		"\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e8\u01ec\7m\2\2\u01e9\u01eb\7\u0085\2"+
		"\2\u01ea\u01e9\3\2\2\2\u01eb\u01ee\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed"+
		"\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ef\u01f1\5\36\20\2"+
		"\u01f0\u01ef\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01fc\3\2\2\2\u01f2\u01f4"+
		"\7\u0085\2\2\u01f3\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f3\3\2\2"+
		"\2\u01f5\u01f6\3\2\2\2\u01f6\u01f8\3\2\2\2\u01f7\u01f9\5\36\20\2\u01f8"+
		"\u01f7\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fb\3\2\2\2\u01fa\u01f3\3\2"+
		"\2\2\u01fb\u01fe\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd"+
		"\u01ff\3\2\2\2\u01fe\u01fc\3\2\2\2\u01ff\u0203\7\7\2\2\u0200\u0202\7\u0085"+
		"\2\2\u0201\u0200\3\2\2\2\u0202\u0205\3\2\2\2\u0203\u0201\3\2\2\2\u0203"+
		"\u0204\3\2\2\2\u0204\35\3\2\2\2\u0205\u0203\3\2\2\2\u0206\u0209\5 \21"+
		"\2\u0207\u0209\5\"\22\2\u0208\u0206\3\2\2\2\u0208\u0207\3\2\2\2\u0209"+
		"\37\3\2\2\2\u020a\u020b\7\u0082\2\2\u020b\u020c\7\b\2\2\u020c\u020d\5"+
		"\16\b\2\u020d!\3\2\2\2\u020e\u020f\7n\2\2\u020f\u0211\7\u0082\2\2\u0210"+
		"\u0212\7\u0085\2\2\u0211\u0210\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213"+
		"\3\2\2\2\u0213\u0214\7\21\2\2\u0214\u0219\5$\23\2\u0215\u0216\7\3\2\2"+
		"\u0216\u0218\5$\23\2\u0217\u0215\3\2\2\2\u0218\u021b\3\2\2\2\u0219\u0217"+
		"\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021c\3\2\2\2\u021b\u0219\3\2\2\2\u021c"+
		"\u021d\7\22\2\2\u021d\u021e\7>\2\2\u021e\u021f\5\22\n\2\u021f#\3\2\2\2"+
		"\u0220\u0221\7\u0082\2\2\u0221\u0222\7>\2\2\u0222\u0223\5\22\n\2\u0223"+
		"%\3\2\2\2\u0224\u0226\5(\25\2\u0225\u0224\3\2\2\2\u0225\u0226\3\2\2\2"+
		"\u0226\u0231\3\2\2\2\u0227\u0229\7\u0085\2\2\u0228\u0227\3\2\2\2\u0229"+
		"\u022a\3\2\2\2\u022a\u0228\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u022d\3\2"+
		"\2\2\u022c\u022e\5(\25\2\u022d\u022c\3\2\2\2\u022d\u022e\3\2\2\2\u022e"+
		"\u0230\3\2\2\2\u022f\u0228\3\2\2\2\u0230\u0233\3\2\2\2\u0231\u022f\3\2"+
		"\2\2\u0231\u0232\3\2\2\2\u0232\'\3\2\2\2\u0233\u0231\3\2\2\2\u0234\u0235"+
		"\t\37\2\2\u0235\u0236\7\u0082\2\2\u0236\u0237\7>\2\2\u0237\u0238\5\22"+
		"\n\2\u0238\u023a\7#\2\2\u0239\u023b\7\u0085\2\2\u023a\u0239\3\2\2\2\u023a"+
		"\u023b\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023d\5*\26\2\u023d\u02d6\3\2"+
		"\2\2\u023e\u023f\7\u0082\2\2\u023f\u0241\7#\2\2\u0240\u0242\7\u0085\2"+
		"\2\u0241\u0240\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u02d6"+
		"\5*\26\2\u0244\u0245\7q\2\2\u0245\u0246\7\21\2\2\u0246\u0247\5*\26\2\u0247"+
		"\u0248\7\22\2\2\u0248\u02d6\3\2\2\2\u0249\u024a\7r\2\2\u024a\u024b\7\21"+
		"\2\2\u024b\u024c\5*\26\2\u024c\u0250\7\22\2\2\u024d\u024f\7\u0085\2\2"+
		"\u024e\u024d\3\2\2\2\u024f\u0252\3\2\2\2\u0250\u024e\3\2\2\2\u0250\u0251"+
		"\3\2\2\2\u0251\u0253\3\2\2\2\u0252\u0250\3\2\2\2\u0253\u0254\7\6\2\2\u0254"+
		"\u0255\5&\24\2\u0255\u0261\7\7\2\2\u0256\u025a\7s\2\2\u0257\u0259\7\u0085"+
		"\2\2\u0258\u0257\3\2\2\2\u0259\u025c\3\2\2\2\u025a\u0258\3\2\2\2\u025a"+
		"\u025b\3\2\2\2\u025b\u025d\3\2\2\2\u025c\u025a\3\2\2\2\u025d\u025e\7\6"+
		"\2\2\u025e\u025f\5&\24\2\u025f\u0260\7\7\2\2\u0260\u0262\3\2\2\2\u0261"+
		"\u0256\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u02d6\3\2\2\2\u0263\u0264\7t"+
		"\2\2\u0264\u0265\7\21\2\2\u0265\u0266\5*\26\2\u0266\u026a\7\22\2\2\u0267"+
		"\u0269\7\u0085\2\2\u0268\u0267\3\2\2\2\u0269\u026c\3\2\2\2\u026a\u0268"+
		"\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026d\3\2\2\2\u026c\u026a\3\2\2\2\u026d"+
		"\u0279\7\6\2\2\u026e\u0270\7\u0085\2\2\u026f\u026e\3\2\2\2\u0270\u0273"+
		"\3\2\2\2\u0271\u026f\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0274\3\2\2\2\u0273"+
		"\u0271\3\2\2\2\u0274\u0275\5\32\16\2\u0275\u0276\7l\2\2\u0276\u0277\5"+
		",\27\2\u0277\u0278\7l\2\2\u0278\u027a\3\2\2\2\u0279\u0271\3\2\2\2\u0279"+
		"\u027a\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027c\5&\24\2\u027c\u027d\7\7"+
		"\2\2\u027d\u02d6\3\2\2\2\u027e\u027f\t \2\2\u027f\u0280\7\21\2\2\u0280"+
		"\u0281\7\u0082\2\2\u0281\u0282\7\u0083\2\2\u0282\u02d6\7\22\2\2\u0283"+
		"\u0284\7\u0082\2\2\u0284\u0285\7\21\2\2\u0285\u0286\5*\26\2\u0286\u0287"+
		"\7\22\2\2\u0287\u0289\7#\2\2\u0288\u028a\7\u0085\2\2\u0289\u0288\3\2\2"+
		"\2\u0289\u028a\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u028c\5*\26\2\u028c\u02d6"+
		"\3\2\2\2\u028d\u028e\7n\2\2\u028e\u0290\7\u0082\2\2\u028f\u0291\7\u0085"+
		"\2\2\u0290\u028f\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0292\3\2\2\2\u0292"+
		"\u029b\7\21\2\2\u0293\u0298\5$\23\2\u0294\u0295\7\3\2\2\u0295\u0297\5"+
		"$\23\2\u0296\u0294\3\2\2\2\u0297\u029a\3\2\2\2\u0298\u0296\3\2\2\2\u0298"+
		"\u0299\3\2\2\2\u0299\u029c\3\2\2\2\u029a\u0298\3\2\2\2\u029b\u0293\3\2"+
		"\2\2\u029b\u029c\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029e\7\22\2\2\u029e"+
		"\u02a1\7>\2\2\u029f\u02a2\5\22\n\2\u02a0\u02a2\7w\2\2\u02a1\u029f\3\2"+
		"\2\2\u02a1\u02a0\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3\u02a7\7#\2\2\u02a4"+
		"\u02a6\7\u0085\2\2\u02a5\u02a4\3\2\2\2\u02a6\u02a9\3\2\2\2\u02a7\u02a5"+
		"\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02aa\3\2\2\2\u02a9\u02a7\3\2\2\2\u02aa"+
		"\u02bc\7\6\2\2\u02ab\u02ad\7\u0085\2\2\u02ac\u02ab\3\2\2\2\u02ad\u02b0"+
		"\3\2\2\2\u02ae\u02ac\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b1\3\2\2\2\u02b0"+
		"\u02ae\3\2\2\2\u02b1\u02b2\5\32\16\2\u02b2\u02b3\7l\2\2\u02b3\u02b7\5"+
		"\60\31\2\u02b4\u02b6\7\u0085\2\2\u02b5\u02b4\3\2\2\2\u02b6\u02b9\3\2\2"+
		"\2\u02b7\u02b5\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02ba\3\2\2\2\u02b9\u02b7"+
		"\3\2\2\2\u02ba\u02bb\7l\2\2\u02bb\u02bd\3\2\2\2\u02bc\u02ae\3\2\2\2\u02bc"+
		"\u02bd\3\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02c7\5&\24\2\u02bf\u02c0\7x"+
		"\2\2\u02c0\u02c4\5*\26\2\u02c1\u02c3\7\u0085\2\2\u02c2\u02c1\3\2\2\2\u02c3"+
		"\u02c6\3\2\2\2\u02c4\u02c2\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5\u02c8\3\2"+
		"\2\2\u02c6\u02c4\3\2\2\2\u02c7\u02bf\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8"+
		"\u02c9\3\2\2\2\u02c9\u02ca\7\7\2\2\u02ca\u02d6\3\2\2\2\u02cb\u02cc\5\32"+
		"\16\2\u02cc\u02d0\7l\2\2\u02cd\u02d1\5\n\6\2\u02ce\u02d1\5\b\5\2\u02cf"+
		"\u02d1\5\62\32\2\u02d0\u02cd\3\2\2\2\u02d0\u02ce\3\2\2\2\u02d0\u02cf\3"+
		"\2\2\2\u02d1\u02d2\3\2\2\2\u02d2\u02d3\7l\2\2\u02d3\u02d6\3\2\2\2\u02d4"+
		"\u02d6\5*\26\2\u02d5\u0234\3\2\2\2\u02d5\u023e\3\2\2\2\u02d5\u0244\3\2"+
		"\2\2\u02d5\u0249\3\2\2\2\u02d5\u0263\3\2\2\2\u02d5\u027e\3\2\2\2\u02d5"+
		"\u0283\3\2\2\2\u02d5\u028d\3\2\2\2\u02d5\u02cb\3\2\2\2\u02d5\u02d4\3\2"+
		"\2\2\u02d6)\3\2\2\2\u02d7\u02d8\b\26\1\2\u02d8\u02d9\t!\2\2\u02d9\u0309"+
		"\5*\26\n\u02da\u0309\t\4\2\2\u02db\u0309\7\u0081\2\2\u02dc\u02eb\7\u0082"+
		"\2\2\u02dd\u02e6\7\21\2\2\u02de\u02e3\5*\26\2\u02df\u02e0\7\3\2\2\u02e0"+
		"\u02e2\5*\26\2\u02e1\u02df\3\2\2\2\u02e2\u02e5\3\2\2\2\u02e3\u02e1\3\2"+
		"\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e7\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e6"+
		"\u02de\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02ec\7\22"+
		"\2\2\u02e9\u02ea\7\b\2\2\u02ea\u02ec\7\u0082\2\2\u02eb\u02dd\3\2\2\2\u02eb"+
		"\u02e9\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec\u0309\3\2\2\2\u02ed\u02ee\t\5"+
		"\2\2\u02ee\u02ef\7\21\2\2\u02ef\u02f0\7\u0083\2\2\u02f0\u0309\7\22\2\2"+
		"\u02f1\u02f2\t\6\2\2\u02f2\u02fb\7\21\2\2\u02f3\u02f8\5*\26\2\u02f4\u02f5"+
		"\7\3\2\2\u02f5\u02f7\5*\26\2\u02f6\u02f4\3\2\2\2\u02f7\u02fa\3\2\2\2\u02f8"+
		"\u02f6\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fc\3\2\2\2\u02fa\u02f8\3\2"+
		"\2\2\u02fb\u02f3\3\2\2\2\u02fb\u02fc\3\2\2\2\u02fc\u02fd\3\2\2\2\u02fd"+
		"\u0309\7\22\2\2\u02fe\u02ff\7y\2\2\u02ff\u0301\7\21\2\2\u0300\u0302\7"+
		"\u0083\2\2\u0301\u0300\3\2\2\2\u0301\u0302\3\2\2\2\u0302\u0303\3\2\2\2"+
		"\u0303\u0309\7\22\2\2\u0304\u0305\7\21\2\2\u0305\u0306\5*\26\2\u0306\u0307"+
		"\7\22\2\2\u0307\u0309\3\2\2\2\u0308\u02d7\3\2\2\2\u0308\u02da\3\2\2\2"+
		"\u0308\u02db\3\2\2\2\u0308\u02dc\3\2\2\2\u0308\u02ed\3\2\2\2\u0308\u02f1"+
		"\3\2\2\2\u0308\u02fe\3\2\2\2\u0308\u0304\3\2\2\2\u0309\u0336\3\2\2\2\u030a"+
		"\u030b\f\t\2\2\u030b\u030d\t\7\2\2\u030c\u030e\7\u0085\2\2\u030d\u030c"+
		"\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u0335\5*\26\n\u0310"+
		"\u0311\f\b\2\2\u0311\u0313\t\"\2\2\u0312\u0314\7\u0085\2\2\u0313\u0312"+
		"\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0335\5*\26\t\u0316"+
		"\u0317\f\7\2\2\u0317\u0319\7z\2\2\u0318\u031a\7\u0085\2\2\u0319\u0318"+
		"\3\2\2\2\u0319\u031a\3\2\2\2\u031a\u031b\3\2\2\2\u031b\u0335\5*\26\b\u031c"+
		"\u031d\f\6\2\2\u031d\u031f\t#\2\2\u031e\u0320\7\u0085\2\2\u031f\u031e"+
		"\3\2\2\2\u031f\u0320\3\2\2\2\u0320\u0321\3\2\2\2\u0321\u0335\5*\26\7\u0322"+
		"\u0323\f\5\2\2\u0323\u0325\t$\2\2\u0324\u0326\7\u0085\2\2\u0325\u0324"+
		"\3\2\2\2\u0325\u0326\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u0335\5*\26\6\u0328"+
		"\u0329\f\4\2\2\u0329\u032b\7,\2\2\u032a\u032c\7\u0085\2\2\u032b\u032a"+
		"\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u032d\3\2\2\2\u032d\u0335\5*\26\5\u032e"+
		"\u032f\f\3\2\2\u032f\u0331\7\60\2\2\u0330\u0332\7\u0085\2\2\u0331\u0330"+
		"\3\2\2\2\u0331\u0332\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u0335\5*\26\4\u0334"+
		"\u030a\3\2\2\2\u0334\u0310\3\2\2\2\u0334\u0316\3\2\2\2\u0334\u031c\3\2"+
		"\2\2\u0334\u0322\3\2\2\2\u0334\u0328\3\2\2\2\u0334\u032e\3\2\2\2\u0335"+
		"\u0338\3\2\2\2\u0336\u0334\3\2\2\2\u0336\u0337\3\2\2\2\u0337+\3\2\2\2"+
		"\u0338\u0336\3\2\2\2\u0339\u033d\7\6\2\2\u033a\u033c\7\u0085\2\2\u033b"+
		"\u033a\3\2\2\2\u033c\u033f\3\2\2\2\u033d\u033b\3\2\2\2\u033d\u033e\3\2"+
		"\2\2\u033e\u0340\3\2\2\2\u033f\u033d\3\2\2\2\u0340\u0344\7g\2\2\u0341"+
		"\u0343\7\u0085\2\2\u0342\u0341\3\2\2\2\u0343\u0346\3\2\2\2\u0344\u0342"+
		"\3\2\2\2\u0344\u0345\3\2\2\2\u0345\u0348\3\2\2\2\u0346\u0344\3\2\2\2\u0347"+
		"\u0349\5\16\b\2\u0348\u0347\3\2\2\2\u0348\u0349\3\2\2\2\u0349\u0354\3"+
		"\2\2\2\u034a\u034c\7\u0085\2\2\u034b\u034a\3\2\2\2\u034c\u034d\3\2\2\2"+
		"\u034d\u034b\3\2\2\2\u034d\u034e\3\2\2\2\u034e\u0350\3\2\2\2\u034f\u0351"+
		"\5\16\b\2\u0350\u034f\3\2\2\2\u0350\u0351\3\2\2\2\u0351\u0353\3\2\2\2"+
		"\u0352\u034b\3\2\2\2\u0353\u0356\3\2\2\2\u0354\u0352\3\2\2\2\u0354\u0355"+
		"\3\2\2\2\u0355\u0357\3\2\2\2\u0356\u0354\3\2\2\2\u0357\u0358\5.\30\2\u0358"+
		"\u035c\7\7\2\2\u0359\u035b\7\u0085\2\2\u035a\u0359\3\2\2\2\u035b\u035e"+
		"\3\2\2\2\u035c\u035a\3\2\2\2\u035c\u035d\3\2\2\2\u035d-\3\2\2\2\u035e"+
		"\u035c\3\2\2\2\u035f\u0368\7{\2\2\u0360\u0365\7\u0082\2\2\u0361\u0362"+
		"\7\3\2\2\u0362\u0364\7\u0082\2\2\u0363\u0361\3\2\2\2\u0364\u0367\3\2\2"+
		"\2\u0365\u0363\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u0369\3\2\2\2\u0367\u0365"+
		"\3\2\2\2\u0368\u0360\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u036d\3\2\2\2\u036a"+
		"\u036c\7\u0085\2\2\u036b\u036a\3\2\2\2\u036c\u036f\3\2\2\2\u036d\u036b"+
		"\3\2\2\2\u036d\u036e\3\2\2\2\u036e/\3\2\2\2\u036f\u036d\3\2\2\2\u0370"+
		"\u0374\7\6\2\2\u0371\u0373\7\u0085\2\2\u0372\u0371\3\2\2\2\u0373\u0376"+
		"\3\2\2\2\u0374\u0372\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u038c\3\2\2\2\u0376"+
		"\u0374\3\2\2\2\u0377\u037b\t%\2\2\u0378\u037a\7\u0085\2\2\u0379\u0378"+
		"\3\2\2\2\u037a\u037d\3\2\2\2\u037b\u0379\3\2\2\2\u037b\u037c\3\2\2\2\u037c"+
		"\u037e\3\2\2\2\u037d\u037b\3\2\2\2\u037e\u0389\5\16\b\2\u037f\u0381\7"+
		"\u0085\2\2\u0380\u037f\3\2\2\2\u0381\u0382\3\2\2\2\u0382\u0380\3\2\2\2"+
		"\u0382\u0383\3\2\2\2\u0383\u0385\3\2\2\2\u0384\u0386\5\16\b\2\u0385\u0384"+
		"\3\2\2\2\u0385\u0386\3\2\2\2\u0386\u0388\3\2\2\2\u0387\u0380\3\2\2\2\u0388"+
		"\u038b\3\2\2\2\u0389\u0387\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u038d\3\2"+
		"\2\2\u038b\u0389\3\2\2\2\u038c\u0377\3\2\2\2\u038c\u038d\3\2\2\2\u038d"+
		"\u0391\3\2\2\2\u038e\u0390\7\u0085\2\2\u038f\u038e\3\2\2\2\u0390\u0393"+
		"\3\2\2\2\u0391\u038f\3\2\2\2\u0391\u0392\3\2\2\2\u0392\u0395\3\2\2\2\u0393"+
		"\u0391\3\2\2\2\u0394\u0396\5.\30\2\u0395\u0394\3\2\2\2\u0395\u0396\3\2"+
		"\2\2\u0396\u03ac\3\2\2\2\u0397\u039b\t&\2\2\u0398\u039a\7\u0085\2\2\u0399"+
		"\u0398\3\2\2\2\u039a\u039d\3\2\2\2\u039b\u0399\3\2\2\2\u039b\u039c\3\2"+
		"\2\2\u039c\u039e\3\2\2\2\u039d\u039b\3\2\2\2\u039e\u03a9\5\16\b\2\u039f"+
		"\u03a1\7\u0085\2\2\u03a0\u039f\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2\u03a0"+
		"\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3\u03a5\3\2\2\2\u03a4\u03a6\5\16\b\2"+
		"\u03a5\u03a4\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6\u03a8\3\2\2\2\u03a7\u03a0"+
		"\3\2\2\2\u03a8\u03ab\3\2\2\2\u03a9\u03a7\3\2\2\2\u03a9\u03aa\3\2\2\2\u03aa"+
		"\u03ad\3\2\2\2\u03ab\u03a9\3\2\2\2\u03ac\u0397\3\2\2\2\u03ac\u03ad\3\2"+
		"\2\2\u03ad\u03b1\3\2\2\2\u03ae\u03b0\7\u0085\2\2\u03af\u03ae\3\2\2\2\u03b0"+
		"\u03b3\3\2\2\2\u03b1\u03af\3\2\2\2\u03b1\u03b2\3\2\2\2\u03b2\u03b4\3\2"+
		"\2\2\u03b3\u03b1\3\2\2\2\u03b4\u03b8\7\7\2\2\u03b5\u03b7\7\u0085\2\2\u03b6"+
		"\u03b5\3\2\2\2\u03b7\u03ba\3\2\2\2\u03b8\u03b6\3\2\2\2\u03b8\u03b9\3\2"+
		"\2\2\u03b9\61\3\2\2\2\u03ba\u03b8\3\2\2\2\u03bb\u03bf\7\6\2\2\u03bc\u03be"+
		"\7\u0085\2\2\u03bd\u03bc\3\2\2\2\u03be\u03c1\3\2\2\2\u03bf\u03bd\3\2\2"+
		"\2\u03bf\u03c0\3\2\2\2\u03c0\u03c2\3\2\2\2\u03c1\u03bf\3\2\2\2\u03c2\u03c6"+
		"\7g\2\2\u03c3\u03c5\7\u0085\2\2\u03c4\u03c3\3\2\2\2\u03c5\u03c8\3\2\2"+
		"\2\u03c6\u03c4\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7\u03ca\3\2\2\2\u03c8\u03c6"+
		"\3\2\2\2\u03c9\u03cb\5\16\b\2\u03ca\u03c9\3\2\2\2\u03ca\u03cb\3\2\2\2"+
		"\u03cb\u03d6\3\2\2\2\u03cc\u03ce\7\u0085\2\2\u03cd\u03cc\3\2\2\2\u03ce"+
		"\u03cf\3\2\2\2\u03cf\u03cd\3\2\2\2\u03cf\u03d0\3\2\2\2\u03d0\u03d2\3\2"+
		"\2\2\u03d1\u03d3\5\16\b\2\u03d2\u03d1\3\2\2\2\u03d2\u03d3\3\2\2\2\u03d3"+
		"\u03d5\3\2\2\2\u03d4\u03cd\3\2\2\2\u03d5\u03d8\3\2\2\2\u03d6\u03d4\3\2"+
		"\2\2\u03d6\u03d7\3\2\2\2\u03d7\u03d9\3\2\2\2\u03d8\u03d6\3\2\2\2\u03d9"+
		"\u03dd\7\7\2\2\u03da\u03dc\7\u0085\2\2\u03db\u03da\3\2\2\2\u03dc\u03df"+
		"\3\2\2\2\u03dd\u03db\3\2\2\2\u03dd\u03de\3\2\2\2\u03de\63\3\2\2\2\u03df"+
		"\u03dd\3\2\2\2\u00948<AQT\\bikotw{\u0082\u008f\u0096\u00a3\u00a8\u00ab"+
		"\u00af\u00b3\u00be\u00cc\u00dd\u00e0\u00e4\u00e9\u00ef\u00f5\u00fb\u0101"+
		"\u0107\u010d\u0110\u0112\u011b\u0120\u0124\u012f\u0136\u013b\u0141\u0148"+
		"\u014e\u0154\u015c\u0162\u0169\u0170\u0177\u0181\u0189\u018f\u0196\u01a3"+
		"\u01ae\u01b6\u01b9\u01c0\u01ce\u01d7\u01da\u01dd\u01e5\u01ec\u01f0\u01f5"+
		"\u01f8\u01fc\u0203\u0208\u0211\u0219\u0225\u022a\u022d\u0231\u023a\u0241"+
		"\u0250\u025a\u0261\u026a\u0271\u0279\u0289\u0290\u0298\u029b\u02a1\u02a7"+
		"\u02ae\u02b7\u02bc\u02c4\u02c7\u02d0\u02d5\u02e3\u02e6\u02eb\u02f8\u02fb"+
		"\u0301\u0308\u030d\u0313\u0319\u031f\u0325\u032b\u0331\u0334\u0336\u033d"+
		"\u0344\u0348\u034d\u0350\u0354\u035c\u0365\u0368\u036d\u0374\u037b\u0382"+
		"\u0385\u0389\u038c\u0391\u0395\u039b\u03a2\u03a5\u03a9\u03ac\u03b1\u03b8"+
		"\u03bf\u03c6\u03ca\u03cf\u03d2\u03d6\u03dd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}