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
			setState(176);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
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
					match(ID);
					}
					break;
				case 2:
					{
					setState(155);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(154);
						match(ID);
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
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(163); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(162);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(165); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(168);
					_la = _input.LA(1);
					if (_la==NUM) {
						{
						setState(167);
						proofStep();
						}
					}

					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175);
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
			setState(225);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(179);
				((UnaryContext)_localctx).op = match(T__25);
				setState(180);
				formula(6);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(182);
				formula(5);
				}
				break;
			case 3:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
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
				setState(184);
				((VarContext)_localctx).tb = match(ID);
				setState(187);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(185);
					match(T__5);
					setState(186);
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
				setState(189);
				match(T__14);
				setState(190);
				formula(0);
				setState(191);
				match(T__15);
				}
				break;
			case 6:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(T__16);
				}
				break;
			case 7:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				match(ID);
				setState(195);
				match(T__14);
				setState(196);
				formula(0);
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(197);
					match(T__0);
					setState(198);
					formula(0);
					}
					}
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(204);
				match(T__15);
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				match(NUM);
				}
				break;
			case 9:
				{
				_localctx = new BigIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(208);
				match(T__14);
				setState(209);
				match(STRING);
				setState(210);
				match(T__15);
				}
				break;
			case 10:
				{
				_localctx = new SeqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(212);
				match(T__14);
				setState(221);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__37))) != 0) || ((((_la - 119)) & ~0x3f) == 0 && ((1L << (_la - 119)) & ((1L << (T__118 - 119)) | (1L << (NUM - 119)) | (1L << (ID - 119)))) != 0)) {
					{
					setState(213);
					exp(0);
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(214);
						match(T__0);
						setState(215);
						exp(0);
						}
						}
						setState(220);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(223);
				match(T__15);
				}
				break;
			case 11:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(269);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(227);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(228);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(230);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(229);
							match(NL);
							}
						}

						setState(232);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(233);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(234);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(236);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(235);
							match(NL);
							}
						}

						setState(238);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(239);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(240);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(242);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(241);
							match(NL);
							}
						}

						setState(244);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(245);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(246);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(248);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(247);
							match(NL);
							}
						}

						setState(250);
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(251);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(252);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(254);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(253);
							match(NL);
							}
						}

						setState(256);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(257);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(258);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(260);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(259);
							match(NL);
							}
						}

						setState(262);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(263);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(264);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__48) | (1L << T__49) | (1L << T__50))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(266);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(265);
							match(NL);
							}
						}

						setState(268);
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
			setState(274);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(275);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(276);
				match(T__0);
				setState(277);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(285);
			_la = _input.LA(1);
			if (_la==T__59) {
				{
				setState(283);
				match(T__59);
				setState(284);
				type();
				}
			}

			setState(287);
			match(T__60);
			setState(289);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(288);
				match(NL);
				}
			}

			setState(291);
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
			setState(312);
			switch (_input.LA(1)) {
			case T__61:
			case T__62:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
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
				setState(294);
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
				setState(295);
				((IntSeqTypeContext)_localctx).tb = match(T__19);
				setState(296);
				match(T__63);
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(297);
					match(NL);
					}
					}
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(303);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(304);
					match(NL);
					}
					}
					setState(309);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(310);
				((IntSeqTypeContext)_localctx).te = match(T__64);
				}
				break;
			case T__20:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(311);
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
			setState(438);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				((PremiseContext)_localctx).t = match(T__65);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
				switch (_input.LA(1)) {
				case T__66:
				case T__67:
					{
					setState(315);
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
					setState(316);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__41 || _la==T__43) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(321);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(325);
				switch (_input.LA(1)) {
				case T__68:
				case T__69:
				case T__70:
				case T__71:
					{
					setState(322);
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
					setState(323);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__41 || _la==T__43) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(324);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(327);
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(331);
				switch (_input.LA(1)) {
				case T__72:
				case T__73:
				case T__74:
				case T__75:
					{
					setState(328);
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
					setState(329);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__45 || _la==T__47) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(330);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(333);
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(337);
				switch (_input.LA(1)) {
				case T__76:
				case T__77:
					{
					setState(334);
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
					setState(335);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__45 || _la==T__47) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(336);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(339);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(340);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(341);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(345);
				switch (_input.LA(1)) {
				case T__78:
					{
					setState(342);
					((ImpliesIntroContext)_localctx).tb = match(T__78);
					}
					break;
				case T__49:
				case T__50:
					{
					setState(343);
					((ImpliesIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__49 || _la==T__50) ) {
						((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(344);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(347);
				((ImpliesIntroContext)_localctx).impliesStep = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(351);
				switch (_input.LA(1)) {
				case T__79:
					{
					setState(348);
					((ImpliesElimContext)_localctx).tb = match(T__79);
					}
					break;
				case T__49:
				case T__50:
					{
					setState(349);
					((ImpliesElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__49 || _la==T__50) ) {
						((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(350);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(353);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(354);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(358);
				switch (_input.LA(1)) {
				case T__80:
				case T__81:
					{
					setState(355);
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
					setState(356);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(357);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(360);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(365);
				switch (_input.LA(1)) {
				case T__82:
					{
					setState(361);
					((NegElimContext)_localctx).tb = match(T__82);
					}
					break;
				case T__83:
					{
					setState(362);
					((NegElimContext)_localctx).tb = match(T__83);
					}
					break;
				case T__37:
				case T__38:
				case T__39:
					{
					setState(363);
					((NegElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
						((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(364);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(367);
				((NegElimContext)_localctx).step = match(NUM);
				setState(368);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(372);
				switch (_input.LA(1)) {
				case T__84:
				case T__85:
					{
					setState(369);
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
					setState(370);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__12 || _la==T__13) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(371);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(374);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 11:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(375);
				((PbcContext)_localctx).tb = match(T__86);
				setState(376);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 12:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(382);
				switch (_input.LA(1)) {
				case T__87:
					{
					setState(377);
					((ForallIntroContext)_localctx).tb = match(T__87);
					}
					break;
				case T__88:
					{
					setState(378);
					((ForallIntroContext)_localctx).tb = match(T__88);
					}
					break;
				case T__89:
					{
					setState(379);
					((ForallIntroContext)_localctx).tb = match(T__89);
					}
					break;
				case T__54:
					{
					setState(380);
					((ForallIntroContext)_localctx).tb = match(T__54);
					setState(381);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(384);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(390);
				switch (_input.LA(1)) {
				case T__90:
					{
					setState(385);
					((ForallElimContext)_localctx).tb = match(T__90);
					}
					break;
				case T__91:
					{
					setState(386);
					((ForallElimContext)_localctx).tb = match(T__91);
					}
					break;
				case T__92:
					{
					setState(387);
					((ForallElimContext)_localctx).tb = match(T__92);
					}
					break;
				case T__54:
					{
					setState(388);
					((ForallElimContext)_localctx).tb = match(T__54);
					setState(389);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(392);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
				setState(394); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(393);
					formula(0);
					}
					}
					setState(396); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 14:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(398);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (T__93 - 94)) | (1L << (T__94 - 94)) | (1L << (T__95 - 94)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(399);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(401); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(400);
					formula(0);
					}
					}
					setState(403); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 15:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(405);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (T__96 - 97)) | (1L << (T__97 - 97)) | (1L << (T__98 - 97)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(406);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(407);
				((ExistsElimContext)_localctx).subproof = match(NUM);
				}
				break;
			case 16:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(409);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(410);
				((ExistsIntroContext)_localctx).tb = match(T__58);
				setState(411);
				match(ID);
				setState(412);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(414); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(413);
					formula(0);
					}
					}
					setState(416); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 17:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(418);
				((ExistsElimContext)_localctx).tb = match(T__58);
				setState(419);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(420);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(421);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(423);
				((AlgebraContext)_localctx).tb = match(T__99);
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(424);
					((AlgebraContext)_localctx).numOrId = numOrId();
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).numOrId);
					}
					}
					setState(429);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(430);
				((InvariantContext)_localctx).tb = match(T__100);
				}
				break;
			case 20:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(431);
				((AutoContext)_localctx).tb = match(T__101);
				setState(435);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(432);
					((AutoContext)_localctx).numOrId = numOrId();
					((AutoContext)_localctx).stepOrFacts.add(((AutoContext)_localctx).numOrId);
					}
					}
					setState(437);
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
			setState(440);
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
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(442);
				match(NL);
				}
				}
				setState(447);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(474);
			_la = _input.LA(1);
			if (_la==T__102) {
				{
				setState(448);
				((ProgramContext)_localctx).tb = match(T__102);
				setState(449);
				((ProgramContext)_localctx).org = match(ID);
				setState(450);
				match(T__5);
				setState(451);
				((ProgramContext)_localctx).sireum = match(ID);
				setState(452);
				match(T__5);
				setState(453);
				match(T__103);
				setState(454);
				match(T__5);
				setState(455);
				((ProgramContext)_localctx).te = match(T__104);
				setState(457); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(456);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(459); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(471);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(461);
					lgk();
					setState(462);
					match(T__105);
					setState(463);
					facts();
					setState(464);
					((ProgramContext)_localctx).te = match(T__105);
					setState(468);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(465);
							match(NL);
							}
							} 
						}
						setState(470);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
					}
					}
					break;
				}
				setState(473);
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
			setState(476);
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
			setState(478);
			match(T__3);
			setState(482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(479);
				match(NL);
				}
				}
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(485);
			((FactsContext)_localctx).ftb = match(T__106);
			setState(489);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(486);
					match(NL);
					}
					} 
				}
				setState(491);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			}
			setState(493);
			_la = _input.LA(1);
			if (_la==T__107 || _la==ID) {
				{
				setState(492);
				factOrFun();
				}
			}

			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(496); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(495);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(498); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(501);
				_la = _input.LA(1);
				if (_la==T__107 || _la==ID) {
					{
					setState(500);
					factOrFun();
					}
				}

				}
				}
				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(508);
			((FactsContext)_localctx).te = match(T__4);
			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(509);
				match(NL);
				}
				}
				setState(514);
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
			setState(517);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(515);
				fact();
				}
				break;
			case T__107:
				enterOuterAlt(_localctx, 2);
				{
				setState(516);
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
			setState(519);
			match(ID);
			setState(520);
			match(T__5);
			setState(521);
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
			setState(523);
			((FunContext)_localctx).tb = match(T__107);
			setState(524);
			match(ID);
			setState(526);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(525);
				match(NL);
				}
			}

			setState(528);
			match(T__14);
			setState(529);
			param();
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(530);
				match(T__0);
				setState(531);
				param();
				}
				}
				setState(536);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(537);
			match(T__15);
			setState(538);
			match(T__59);
			setState(539);
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
			setState(541);
			match(ID);
			setState(542);
			match(T__59);
			setState(543);
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
			setState(546);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__37))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (T__103 - 104)) | (1L << (T__107 - 104)) | (1L << (T__108 - 104)) | (1L << (T__109 - 104)) | (1L << (T__110 - 104)) | (1L << (T__111 - 104)) | (1L << (T__113 - 104)) | (1L << (T__114 - 104)) | (1L << (T__115 - 104)) | (1L << (T__118 - 104)) | (1L << (NUM - 104)) | (1L << (ID - 104)))) != 0)) {
				{
				setState(545);
				stmt();
				}
			}

			setState(558);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(549); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(548);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(551); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(554);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__37))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (T__103 - 104)) | (1L << (T__107 - 104)) | (1L << (T__108 - 104)) | (1L << (T__109 - 104)) | (1L << (T__110 - 104)) | (1L << (T__111 - 104)) | (1L << (T__113 - 104)) | (1L << (T__114 - 104)) | (1L << (T__115 - 104)) | (1L << (T__118 - 104)) | (1L << (NUM - 104)) | (1L << (ID - 104)))) != 0)) {
					{
					setState(553);
					stmt();
					}
				}

				}
				}
				setState(560);
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
			setState(722);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(561);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__108 || _la==T__109) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(562);
				match(ID);
				setState(563);
				match(T__59);
				setState(564);
				type();
				setState(565);
				match(T__32);
				setState(567);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(566);
					match(NL);
					}
				}

				setState(569);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(571);
				match(ID);
				setState(572);
				match(T__32);
				setState(574);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(573);
					match(NL);
					}
				}

				setState(576);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(577);
				match(T__110);
				setState(578);
				match(T__14);
				setState(579);
				exp(0);
				setState(580);
				match(T__15);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(582);
				match(T__111);
				setState(583);
				match(T__14);
				setState(584);
				exp(0);
				setState(585);
				match(T__15);
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
				((IfStmtContext)_localctx).ts = stmts();
				setState(594);
				match(T__4);
				setState(606);
				_la = _input.LA(1);
				if (_la==T__112) {
					{
					setState(595);
					match(T__112);
					setState(599);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(596);
						match(NL);
						}
						}
						setState(601);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(602);
					match(T__3);
					setState(603);
					((IfStmtContext)_localctx).fs = stmts();
					setState(604);
					match(T__4);
					}
				}

				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(608);
				match(T__113);
				setState(609);
				match(T__14);
				setState(610);
				exp(0);
				setState(611);
				match(T__15);
				setState(615);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(612);
					match(NL);
					}
					}
					setState(617);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(618);
				match(T__3);
				setState(630);
				switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
				case 1:
					{
					setState(622);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(619);
						match(NL);
						}
						}
						setState(624);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(625);
					lgk();
					setState(626);
					match(T__105);
					setState(627);
					loopInvariant();
					setState(628);
					match(T__105);
					}
					break;
				}
				setState(632);
				stmts();
				setState(633);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(635);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__114 || _la==T__115) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(636);
				match(T__14);
				setState(637);
				((PrintStmtContext)_localctx).s = match(ID);
				setState(638);
				match(STRING);
				setState(639);
				match(T__15);
				}
				break;
			case 7:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(640);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(641);
				match(T__14);
				setState(642);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(643);
				match(T__15);
				setState(644);
				match(T__32);
				setState(646);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(645);
					match(NL);
					}
				}

				setState(648);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 8:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(650);
				match(T__107);
				setState(651);
				match(ID);
				setState(653);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(652);
					match(NL);
					}
				}

				setState(655);
				match(T__14);
				setState(664);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(656);
					param();
					setState(661);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(657);
						match(T__0);
						setState(658);
						param();
						}
						}
						setState(663);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(666);
				match(T__15);
				setState(667);
				match(T__59);
				setState(670);
				switch (_input.LA(1)) {
				case T__17:
				case T__18:
				case T__19:
				case T__20:
				case T__61:
				case T__62:
					{
					setState(668);
					type();
					}
					break;
				case T__116:
					{
					setState(669);
					match(T__116);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(672);
				match(T__32);
				setState(676);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(673);
					match(NL);
					}
					}
					setState(678);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(679);
				match(T__3);
				setState(697);
				switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
				case 1:
					{
					setState(683);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(680);
						match(NL);
						}
						}
						setState(685);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(686);
					lgk();
					setState(687);
					match(T__105);
					setState(688);
					methodContract();
					setState(692);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(689);
						match(NL);
						}
						}
						setState(694);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(695);
					match(T__105);
					}
					break;
				}
				setState(699);
				stmts();
				setState(708);
				_la = _input.LA(1);
				if (_la==T__117) {
					{
					setState(700);
					((MethodDeclStmtContext)_localctx).rtb = match(T__117);
					setState(701);
					exp(0);
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
					}
				}

				setState(710);
				match(T__4);
				}
				break;
			case 9:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(712);
				lgk();
				setState(713);
				match(T__105);
				setState(717);
				switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
				case 1:
					{
					setState(714);
					proof();
					}
					break;
				case 2:
					{
					setState(715);
					sequent();
					}
					break;
				case 3:
					{
					setState(716);
					invariants();
					}
					break;
				}
				setState(719);
				match(T__105);
				}
				break;
			case 10:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(721);
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
			setState(773);
			switch (_input.LA(1)) {
			case T__25:
			case T__37:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(725);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__25 || _la==T__37) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(726);
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
				setState(727);
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
				setState(728);
				match(NUM);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(729);
				((IdExpContext)_localctx).tb = match(ID);
				setState(744);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(730);
					match(T__14);
					setState(739);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__37))) != 0) || ((((_la - 119)) & ~0x3f) == 0 && ((1L << (_la - 119)) & ((1L << (T__118 - 119)) | (1L << (NUM - 119)) | (1L << (ID - 119)))) != 0)) {
						{
						setState(731);
						exp(0);
						setState(736);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__0) {
							{
							{
							setState(732);
							match(T__0);
							setState(733);
							exp(0);
							}
							}
							setState(738);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(741);
					match(T__15);
					}
					break;
				case 2:
					{
					setState(742);
					match(T__5);
					setState(743);
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
				setState(746);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(747);
				match(T__14);
				setState(748);
				match(STRING);
				setState(749);
				match(T__15);
				}
				break;
			case T__19:
			case T__20:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(750);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(751);
				match(T__14);
				setState(760);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__37))) != 0) || ((((_la - 119)) & ~0x3f) == 0 && ((1L << (_la - 119)) & ((1L << (T__118 - 119)) | (1L << (NUM - 119)) | (1L << (ID - 119)))) != 0)) {
					{
					setState(752);
					exp(0);
					setState(757);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(753);
						match(T__0);
						setState(754);
						exp(0);
						}
						}
						setState(759);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(762);
				match(T__15);
				}
				break;
			case T__118:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(763);
				match(T__118);
				setState(764);
				match(T__14);
				setState(766);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(765);
					match(STRING);
					}
				}

				setState(768);
				match(T__15);
				}
				break;
			case T__14:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(769);
				match(T__14);
				setState(770);
				exp(0);
				setState(771);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(819);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(817);
					switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(775);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(776);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(778);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(777);
							match(NL);
							}
						}

						setState(780);
						((BinaryExpContext)_localctx).r = exp(8);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(781);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(782);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25 || _la==T__119) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(784);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(783);
							match(NL);
							}
						}

						setState(786);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(787);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(788);
						((BinaryExpContext)_localctx).op = match(T__119);
						setState(790);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(789);
							match(NL);
							}
						}

						setState(792);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(793);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(794);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__29) | (1L << T__30))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(796);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(795);
							match(NL);
							}
						}

						setState(798);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(799);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(800);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__33 || _la==T__34) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(802);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(801);
							match(NL);
							}
						}

						setState(804);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(805);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(806);
						((BinaryExpContext)_localctx).op = match(T__41);
						setState(808);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(807);
							match(NL);
							}
						}

						setState(810);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(811);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(812);
						((BinaryExpContext)_localctx).op = match(T__45);
						setState(814);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(813);
							match(NL);
							}
						}

						setState(816);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(821);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
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
			setState(822);
			((LoopInvariantContext)_localctx).tb = match(T__3);
			setState(826);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(823);
				match(NL);
				}
				}
				setState(828);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(829);
			((LoopInvariantContext)_localctx).itb = match(T__100);
			setState(833);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,116,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(830);
					match(NL);
					}
					} 
				}
				setState(835);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,116,_ctx);
			}
			setState(837);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID) {
				{
				setState(836);
				formula(0);
				}
			}

			setState(849);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(840); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(839);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(842); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(845);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID) {
					{
					setState(844);
					formula(0);
					}
				}

				}
				}
				setState(851);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(852);
			modifies();
			setState(853);
			((LoopInvariantContext)_localctx).te = match(T__4);
			setState(857);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(854);
				match(NL);
				}
				}
				setState(859);
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
			setState(860);
			((ModifiesContext)_localctx).tb = match(T__120);
			setState(869);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(861);
				match(ID);
				setState(866);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(862);
					match(T__0);
					setState(863);
					match(ID);
					}
					}
					setState(868);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(874);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(871);
					match(NL);
					}
					} 
				}
				setState(876);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
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
			setState(877);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(881);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(878);
					match(NL);
					}
					} 
				}
				setState(883);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			}
			setState(905);
			_la = _input.LA(1);
			if (_la==T__121 || _la==T__122) {
				{
				setState(884);
				_la = _input.LA(1);
				if ( !(_la==T__121 || _la==T__122) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(888);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(885);
					match(NL);
					}
					}
					setState(890);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(891);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(902);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(893); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(892);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(895); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(898);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID) {
							{
							setState(897);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(904);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
				}
				}
			}

			setState(910);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(907);
					match(NL);
					}
					} 
				}
				setState(912);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			}
			setState(914);
			_la = _input.LA(1);
			if (_la==T__120) {
				{
				setState(913);
				modifies();
				}
			}

			setState(937);
			_la = _input.LA(1);
			if (_la==T__123 || _la==T__124) {
				{
				setState(916);
				_la = _input.LA(1);
				if ( !(_la==T__123 || _la==T__124) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(920);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(917);
					match(NL);
					}
					}
					setState(922);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(923);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(934);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(925); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(924);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(927); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(930);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID) {
							{
							setState(929);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(936);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
				}
				}
			}

			setState(942);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(939);
				match(NL);
				}
				}
				setState(944);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(945);
			((MethodContractContext)_localctx).te = match(T__4);
			setState(949);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(946);
					match(NL);
					}
					} 
				}
				setState(951);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
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
			setState(952);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(956);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(953);
				match(NL);
				}
				}
				setState(958);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(959);
			match(T__100);
			setState(963);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(960);
					match(NL);
					}
					} 
				}
				setState(965);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			}
			setState(967);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID) {
				{
				setState(966);
				formula(0);
				}
			}

			setState(979);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(970); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(969);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(972); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,143,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(975);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__25) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0) || _la==NUM || _la==ID) {
					{
					setState(974);
					formula(0);
					}
				}

				}
				}
				setState(981);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(982);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(986);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(983);
				match(NL);
				}
				}
				setState(988);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0089\u03e0\4\2\t"+
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
		"\u00a6\n\7\r\7\16\7\u00a7\3\7\5\7\u00ab\n\7\7\7\u00ad\n\7\f\7\16\7\u00b0"+
		"\13\7\3\7\5\7\u00b3\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00be"+
		"\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00ca\n\b\f\b\16\b\u00cd"+
		"\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00db\n\b\f"+
		"\b\16\b\u00de\13\b\5\b\u00e0\n\b\3\b\3\b\5\b\u00e4\n\b\3\b\3\b\3\b\5\b"+
		"\u00e9\n\b\3\b\3\b\3\b\3\b\5\b\u00ef\n\b\3\b\3\b\3\b\3\b\5\b\u00f5\n\b"+
		"\3\b\3\b\3\b\3\b\5\b\u00fb\n\b\3\b\3\b\3\b\3\b\5\b\u0101\n\b\3\b\3\b\3"+
		"\b\3\b\5\b\u0107\n\b\3\b\3\b\3\b\3\b\5\b\u010d\n\b\3\b\7\b\u0110\n\b\f"+
		"\b\16\b\u0113\13\b\3\t\3\t\3\t\3\t\7\t\u0119\n\t\f\t\16\t\u011c\13\t\3"+
		"\t\3\t\5\t\u0120\n\t\3\t\3\t\5\t\u0124\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\7\n\u012d\n\n\f\n\16\n\u0130\13\n\3\n\3\n\7\n\u0134\n\n\f\n\16\n\u0137"+
		"\13\n\3\n\3\n\5\n\u013b\n\n\3\13\3\13\3\13\3\13\5\13\u0141\n\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u0148\n\13\3\13\3\13\3\13\3\13\5\13\u014e\n\13"+
		"\3\13\3\13\3\13\3\13\5\13\u0154\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u015c\n\13\3\13\3\13\3\13\3\13\5\13\u0162\n\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u0169\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0170\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u0177\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u0181\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0189\n\13\3\13\3"+
		"\13\6\13\u018d\n\13\r\13\16\13\u018e\3\13\3\13\3\13\6\13\u0194\n\13\r"+
		"\13\16\13\u0195\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u01a1"+
		"\n\13\r\13\16\13\u01a2\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u01ac\n"+
		"\13\f\13\16\13\u01af\13\13\3\13\3\13\3\13\7\13\u01b4\n\13\f\13\16\13\u01b7"+
		"\13\13\5\13\u01b9\n\13\3\f\3\f\3\r\7\r\u01be\n\r\f\r\16\r\u01c1\13\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u01cc\n\r\r\r\16\r\u01cd\3\r\3"+
		"\r\3\r\3\r\3\r\7\r\u01d5\n\r\f\r\16\r\u01d8\13\r\5\r\u01da\n\r\3\r\5\r"+
		"\u01dd\n\r\3\16\3\16\3\17\3\17\7\17\u01e3\n\17\f\17\16\17\u01e6\13\17"+
		"\3\17\3\17\7\17\u01ea\n\17\f\17\16\17\u01ed\13\17\3\17\5\17\u01f0\n\17"+
		"\3\17\6\17\u01f3\n\17\r\17\16\17\u01f4\3\17\5\17\u01f8\n\17\7\17\u01fa"+
		"\n\17\f\17\16\17\u01fd\13\17\3\17\3\17\7\17\u0201\n\17\f\17\16\17\u0204"+
		"\13\17\3\20\3\20\5\20\u0208\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\5"+
		"\22\u0211\n\22\3\22\3\22\3\22\3\22\7\22\u0217\n\22\f\22\16\22\u021a\13"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\5\24\u0225\n\24\3\24"+
		"\6\24\u0228\n\24\r\24\16\24\u0229\3\24\5\24\u022d\n\24\7\24\u022f\n\24"+
		"\f\24\16\24\u0232\13\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u023a\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u0241\n\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\7\25\u024e\n\25\f\25\16\25\u0251\13\25\3\25"+
		"\3\25\3\25\3\25\3\25\7\25\u0258\n\25\f\25\16\25\u025b\13\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0261\n\25\3\25\3\25\3\25\3\25\3\25\7\25\u0268\n\25\f"+
		"\25\16\25\u026b\13\25\3\25\3\25\7\25\u026f\n\25\f\25\16\25\u0272\13\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u0279\n\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0289\n\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0290\n\25\3\25\3\25\3\25\3\25\7\25\u0296\n\25\f\25\16"+
		"\25\u0299\13\25\5\25\u029b\n\25\3\25\3\25\3\25\3\25\5\25\u02a1\n\25\3"+
		"\25\3\25\7\25\u02a5\n\25\f\25\16\25\u02a8\13\25\3\25\3\25\7\25\u02ac\n"+
		"\25\f\25\16\25\u02af\13\25\3\25\3\25\3\25\3\25\7\25\u02b5\n\25\f\25\16"+
		"\25\u02b8\13\25\3\25\3\25\5\25\u02bc\n\25\3\25\3\25\3\25\3\25\7\25\u02c2"+
		"\n\25\f\25\16\25\u02c5\13\25\5\25\u02c7\n\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u02d0\n\25\3\25\3\25\3\25\5\25\u02d5\n\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u02e1\n\26\f\26\16\26\u02e4"+
		"\13\26\5\26\u02e6\n\26\3\26\3\26\3\26\5\26\u02eb\n\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\7\26\u02f6\n\26\f\26\16\26\u02f9\13\26\5"+
		"\26\u02fb\n\26\3\26\3\26\3\26\3\26\5\26\u0301\n\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u0308\n\26\3\26\3\26\3\26\5\26\u030d\n\26\3\26\3\26\3\26\3"+
		"\26\5\26\u0313\n\26\3\26\3\26\3\26\3\26\5\26\u0319\n\26\3\26\3\26\3\26"+
		"\3\26\5\26\u031f\n\26\3\26\3\26\3\26\3\26\5\26\u0325\n\26\3\26\3\26\3"+
		"\26\3\26\5\26\u032b\n\26\3\26\3\26\3\26\3\26\5\26\u0331\n\26\3\26\7\26"+
		"\u0334\n\26\f\26\16\26\u0337\13\26\3\27\3\27\7\27\u033b\n\27\f\27\16\27"+
		"\u033e\13\27\3\27\3\27\7\27\u0342\n\27\f\27\16\27\u0345\13\27\3\27\5\27"+
		"\u0348\n\27\3\27\6\27\u034b\n\27\r\27\16\27\u034c\3\27\5\27\u0350\n\27"+
		"\7\27\u0352\n\27\f\27\16\27\u0355\13\27\3\27\3\27\3\27\7\27\u035a\n\27"+
		"\f\27\16\27\u035d\13\27\3\30\3\30\3\30\3\30\7\30\u0363\n\30\f\30\16\30"+
		"\u0366\13\30\5\30\u0368\n\30\3\30\7\30\u036b\n\30\f\30\16\30\u036e\13"+
		"\30\3\31\3\31\7\31\u0372\n\31\f\31\16\31\u0375\13\31\3\31\3\31\7\31\u0379"+
		"\n\31\f\31\16\31\u037c\13\31\3\31\3\31\6\31\u0380\n\31\r\31\16\31\u0381"+
		"\3\31\5\31\u0385\n\31\7\31\u0387\n\31\f\31\16\31\u038a\13\31\5\31\u038c"+
		"\n\31\3\31\7\31\u038f\n\31\f\31\16\31\u0392\13\31\3\31\5\31\u0395\n\31"+
		"\3\31\3\31\7\31\u0399\n\31\f\31\16\31\u039c\13\31\3\31\3\31\6\31\u03a0"+
		"\n\31\r\31\16\31\u03a1\3\31\5\31\u03a5\n\31\7\31\u03a7\n\31\f\31\16\31"+
		"\u03aa\13\31\5\31\u03ac\n\31\3\31\7\31\u03af\n\31\f\31\16\31\u03b2\13"+
		"\31\3\31\3\31\7\31\u03b6\n\31\f\31\16\31\u03b9\13\31\3\32\3\32\7\32\u03bd"+
		"\n\32\f\32\16\32\u03c0\13\32\3\32\3\32\7\32\u03c4\n\32\f\32\16\32\u03c7"+
		"\13\32\3\32\5\32\u03ca\n\32\3\32\6\32\u03cd\n\32\r\32\16\32\u03ce\3\32"+
		"\5\32\u03d2\n\32\7\32\u03d4\n\32\f\32\16\32\u03d7\13\32\3\32\3\32\7\32"+
		"\u03db\n\32\f\32\16\32\u03de\13\32\3\32\2\4\16*\33\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\2\'\3\2\4\5\3\2\'*\3\2\n\20\3\2\24\25"+
		"\3\2\26\27\3\2\30\32\3\2\33\34\3\2\35\"\3\2#&\3\2+.\3\2/\62\3\2\63\65"+
		"\3\2\66=\3\2@A\3\2EF\4\2,,..\3\2GJ\3\2KN\4\2\60\60\62\62\3\2OP\3\2\64"+
		"\65\3\2ST\3\2(*\3\2WX\3\2\17\20\3\2`b\3\2ce\3\2\u0081\u0082\4\2jj\u0082"+
		"\u0082\3\2op\3\2uv\4\2\34\34((\4\2\33\34zz\4\2\35\36 !\3\2$%\3\2|}\3\2"+
		"~\177\u0495\2\64\3\2\2\2\4F\3\2\2\2\6I\3\2\2\2\bk\3\2\2\2\nm\3\2\2\2\f"+
		"\u00b2\3\2\2\2\16\u00e3\3\2\2\2\20\u0114\3\2\2\2\22\u013a\3\2\2\2\24\u01b8"+
		"\3\2\2\2\26\u01ba\3\2\2\2\30\u01bf\3\2\2\2\32\u01de\3\2\2\2\34\u01e0\3"+
		"\2\2\2\36\u0207\3\2\2\2 \u0209\3\2\2\2\"\u020d\3\2\2\2$\u021f\3\2\2\2"+
		"&\u0224\3\2\2\2(\u02d4\3\2\2\2*\u0307\3\2\2\2,\u0338\3\2\2\2.\u035e\3"+
		"\2\2\2\60\u036f\3\2\2\2\62\u03ba\3\2\2\2\648\5\b\5\2\65\67\7\u0085\2\2"+
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
		"\5\24\13\2\u0089\u00b3\3\2\2\2\u008a\u008b\7\u0081\2\2\u008b\u008f\7\b"+
		"\2\2\u008c\u008e\7\u0085\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0092\u0096\7\6\2\2\u0093\u0095\7\u0085\2\2\u0094\u0093\3\2\2\2\u0095"+
		"\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0099\u009a\7\u0081\2\2\u009a\u00a2\7\b\2\2\u009b"+
		"\u00a3\7\u0082\2\2\u009c\u009e\7\u0082\2\2\u009d\u009c\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\5\16\b\2\u00a0\u00a1\7\t\2\2"+
		"\u00a1\u00a3\3\2\2\2\u00a2\u009b\3\2\2\2\u00a2\u009d\3\2\2\2\u00a3\u00ae"+
		"\3\2\2\2\u00a4\u00a6\7\u0085\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2"+
		"\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00ab"+
		"\5\f\7\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac"+
		"\u00a5\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b3\7\7\2\2\u00b2"+
		"\u0085\3\2\2\2\u00b2\u008a\3\2\2\2\u00b3\r\3\2\2\2\u00b4\u00b5\b\b\1\2"+
		"\u00b5\u00b6\7\34\2\2\u00b6\u00e4\5\16\b\b\u00b7\u00b8\t\3\2\2\u00b8\u00e4"+
		"\5\16\b\7\u00b9\u00e4\t\4\2\2\u00ba\u00bd\7\u0082\2\2\u00bb\u00bc\7\b"+
		"\2\2\u00bc\u00be\7\u0082\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00e4\3\2\2\2\u00bf\u00c0\7\21\2\2\u00c0\u00c1\5\16\b\2\u00c1\u00c2\7"+
		"\22\2\2\u00c2\u00e4\3\2\2\2\u00c3\u00e4\7\23\2\2\u00c4\u00c5\7\u0082\2"+
		"\2\u00c5\u00c6\7\21\2\2\u00c6\u00cb\5\16\b\2\u00c7\u00c8\7\3\2\2\u00c8"+
		"\u00ca\5\16\b\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3"+
		"\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce"+
		"\u00cf\7\22\2\2\u00cf\u00e4\3\2\2\2\u00d0\u00e4\7\u0081\2\2\u00d1\u00d2"+
		"\t\5\2\2\u00d2\u00d3\7\21\2\2\u00d3\u00d4\7\u0083\2\2\u00d4\u00e4\7\22"+
		"\2\2\u00d5\u00d6\t\6\2\2\u00d6\u00df\7\21\2\2\u00d7\u00dc\5*\26\2\u00d8"+
		"\u00d9\7\3\2\2\u00d9\u00db\5*\26\2\u00da\u00d8\3\2\2\2\u00db\u00de\3\2"+
		"\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00df\u00d7\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\u00e4\7\22\2\2\u00e2\u00e4\5\20\t\2\u00e3\u00b4\3\2\2\2\u00e3"+
		"\u00b7\3\2\2\2\u00e3\u00b9\3\2\2\2\u00e3\u00ba\3\2\2\2\u00e3\u00bf\3\2"+
		"\2\2\u00e3\u00c3\3\2\2\2\u00e3\u00c4\3\2\2\2\u00e3\u00d0\3\2\2\2\u00e3"+
		"\u00d1\3\2\2\2\u00e3\u00d5\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u0111\3\2"+
		"\2\2\u00e5\u00e6\f\f\2\2\u00e6\u00e8\t\7\2\2\u00e7\u00e9\7\u0085\2\2\u00e8"+
		"\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u0110\5\16"+
		"\b\r\u00eb\u00ec\f\13\2\2\u00ec\u00ee\t\b\2\2\u00ed\u00ef\7\u0085\2\2"+
		"\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u0110"+
		"\5\16\b\f\u00f1\u00f2\f\n\2\2\u00f2\u00f4\t\t\2\2\u00f3\u00f5\7\u0085"+
		"\2\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u0110\5\16\b\13\u00f7\u00f8\f\t\2\2\u00f8\u00fa\t\n\2\2\u00f9\u00fb\7"+
		"\u0085\2\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2"+
		"\u00fc\u0110\5\16\b\n\u00fd\u00fe\f\6\2\2\u00fe\u0100\t\13\2\2\u00ff\u0101"+
		"\7\u0085\2\2\u0100\u00ff\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102\3\2\2"+
		"\2\u0102\u0110\5\16\b\7\u0103\u0104\f\5\2\2\u0104\u0106\t\f\2\2\u0105"+
		"\u0107\7\u0085\2\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108"+
		"\3\2\2\2\u0108\u0110\5\16\b\6\u0109\u010a\f\4\2\2\u010a\u010c\t\r\2\2"+
		"\u010b\u010d\7\u0085\2\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u0110\5\16\b\5\u010f\u00e5\3\2\2\2\u010f\u00eb\3"+
		"\2\2\2\u010f\u00f1\3\2\2\2\u010f\u00f7\3\2\2\2\u010f\u00fd\3\2\2\2\u010f"+
		"\u0103\3\2\2\2\u010f\u0109\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2"+
		"\2\2\u0111\u0112\3\2\2\2\u0112\17\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115"+
		"\t\16\2\2\u0115\u011a\7\u0082\2\2\u0116\u0117\7\3\2\2\u0117\u0119\7\u0082"+
		"\2\2\u0118\u0116\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b\u011f\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\7>"+
		"\2\2\u011e\u0120\5\22\n\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u0123\7?\2\2\u0122\u0124\7\u0085\2\2\u0123\u0122"+
		"\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\5\16\b\2"+
		"\u0126\21\3\2\2\2\u0127\u013b\t\17\2\2\u0128\u013b\t\5\2\2\u0129\u012a"+
		"\7\26\2\2\u012a\u012e\7B\2\2\u012b\u012d\7\u0085\2\2\u012c\u012b\3\2\2"+
		"\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131"+
		"\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0135\t\5\2\2\u0132\u0134\7\u0085\2"+
		"\2\u0133\u0132\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136"+
		"\3\2\2\2\u0136\u0138\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u013b\7C\2\2\u0139"+
		"\u013b\7\27\2\2\u013a\u0127\3\2\2\2\u013a\u0128\3\2\2\2\u013a\u0129\3"+
		"\2\2\2\u013a\u0139\3\2\2\2\u013b\23\3\2\2\2\u013c\u01b9\7D\2\2\u013d\u0141"+
		"\t\20\2\2\u013e\u013f\t\21\2\2\u013f\u0141\7\u0082\2\2\u0140\u013d\3\2"+
		"\2\2\u0140\u013e\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\7\u0081\2\2\u0143"+
		"\u01b9\7\u0081\2\2\u0144\u0148\t\22\2\2\u0145\u0146\t\21\2\2\u0146\u0148"+
		"\7\u0082\2\2\u0147\u0144\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0149\3\2\2"+
		"\2\u0149\u01b9\7\u0081\2\2\u014a\u014e\t\23\2\2\u014b\u014c\t\24\2\2\u014c"+
		"\u014e\7\u0082\2\2\u014d\u014a\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u014f"+
		"\3\2\2\2\u014f\u01b9\7\u0081\2\2\u0150\u0154\t\25\2\2\u0151\u0152\t\24"+
		"\2\2\u0152\u0154\7\u0082\2\2\u0153\u0150\3\2\2\2\u0153\u0151\3\2\2\2\u0154"+
		"\u0155\3\2\2\2\u0155\u0156\7\u0081\2\2\u0156\u0157\7\u0081\2\2\u0157\u01b9"+
		"\7\u0081\2\2\u0158\u015c\7Q\2\2\u0159\u015a\t\26\2\2\u015a\u015c\7\u0082"+
		"\2\2\u015b\u0158\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"\u01b9\7\u0081\2\2\u015e\u0162\7R\2\2\u015f\u0160\t\26\2\2\u0160\u0162"+
		"\7\u0082\2\2\u0161\u015e\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u0163\3\2\2"+
		"\2\u0163\u0164\7\u0081\2\2\u0164\u01b9\7\u0081\2\2\u0165\u0169\t\27\2"+
		"\2\u0166\u0167\t\30\2\2\u0167\u0169\7\u0082\2\2\u0168\u0165\3\2\2\2\u0168"+
		"\u0166\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u01b9\7\u0081\2\2\u016b\u0170"+
		"\7U\2\2\u016c\u0170\7V\2\2\u016d\u016e\t\30\2\2\u016e\u0170\7\u0082\2"+
		"\2\u016f\u016b\3\2\2\2\u016f\u016c\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u0171"+
		"\3\2\2\2\u0171\u0172\7\u0081\2\2\u0172\u01b9\7\u0081\2\2\u0173\u0177\t"+
		"\31\2\2\u0174\u0175\t\32\2\2\u0175\u0177\7\u0082\2\2\u0176\u0173\3\2\2"+
		"\2\u0176\u0174\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u01b9\7\u0081\2\2\u0179"+
		"\u017a\7Y\2\2\u017a\u01b9\7\u0081\2\2\u017b\u0181\7Z\2\2\u017c\u0181\7"+
		"[\2\2\u017d\u0181\7\\\2\2\u017e\u017f\79\2\2\u017f\u0181\7\u0082\2\2\u0180"+
		"\u017b\3\2\2\2\u0180\u017c\3\2\2\2\u0180\u017d\3\2\2\2\u0180\u017e\3\2"+
		"\2\2\u0181\u0182\3\2\2\2\u0182\u01b9\7\u0081\2\2\u0183\u0189\7]\2\2\u0184"+
		"\u0189\7^\2\2\u0185\u0189\7_\2\2\u0186\u0187\79\2\2\u0187\u0189\7\u0082"+
		"\2\2\u0188\u0183\3\2\2\2\u0188\u0184\3\2\2\2\u0188\u0185\3\2\2\2\u0188"+
		"\u0186\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018c\5\26\f\2\u018b\u018d\5"+
		"\16\b\2\u018c\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018c\3\2\2\2\u018e"+
		"\u018f\3\2\2\2\u018f\u01b9\3\2\2\2\u0190\u0191\t\33\2\2\u0191\u0193\7"+
		"\u0081\2\2\u0192\u0194\5\16\b\2\u0193\u0192\3\2\2\2\u0194\u0195\3\2\2"+
		"\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u01b9\3\2\2\2\u0197\u0198"+
		"\t\34\2\2\u0198\u0199\5\26\f\2\u0199\u019a\7\u0081\2\2\u019a\u01b9\3\2"+
		"\2\2\u019b\u019c\6\13\t\2\u019c\u019d\7=\2\2\u019d\u019e\7\u0082\2\2\u019e"+
		"\u01a0\7\u0081\2\2\u019f\u01a1\5\16\b\2\u01a0\u019f\3\2\2\2\u01a1\u01a2"+
		"\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01b9\3\2\2\2\u01a4"+
		"\u01a5\7=\2\2\u01a5\u01a6\7\u0082\2\2\u01a6\u01a7\5\26\f\2\u01a7\u01a8"+
		"\7\u0081\2\2\u01a8\u01b9\3\2\2\2\u01a9\u01ad\7f\2\2\u01aa\u01ac\5\26\f"+
		"\2\u01ab\u01aa\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae"+
		"\3\2\2\2\u01ae\u01b9\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b9\7g\2\2\u01b1"+
		"\u01b5\7h\2\2\u01b2\u01b4\5\26\f\2\u01b3\u01b2\3\2\2\2\u01b4\u01b7\3\2"+
		"\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7"+
		"\u01b5\3\2\2\2\u01b8\u013c\3\2\2\2\u01b8\u0140\3\2\2\2\u01b8\u0147\3\2"+
		"\2\2\u01b8\u014d\3\2\2\2\u01b8\u0153\3\2\2\2\u01b8\u015b\3\2\2\2\u01b8"+
		"\u0161\3\2\2\2\u01b8\u0168\3\2\2\2\u01b8\u016f\3\2\2\2\u01b8\u0176\3\2"+
		"\2\2\u01b8\u0179\3\2\2\2\u01b8\u0180\3\2\2\2\u01b8\u0188\3\2\2\2\u01b8"+
		"\u0190\3\2\2\2\u01b8\u0197\3\2\2\2\u01b8\u019b\3\2\2\2\u01b8\u01a4\3\2"+
		"\2\2\u01b8\u01a9\3\2\2\2\u01b8\u01b0\3\2\2\2\u01b8\u01b1\3\2\2\2\u01b9"+
		"\25\3\2\2\2\u01ba\u01bb\t\35\2\2\u01bb\27\3\2\2\2\u01bc\u01be\7\u0085"+
		"\2\2\u01bd\u01bc\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf"+
		"\u01c0\3\2\2\2\u01c0\u01dc\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01c3\7i"+
		"\2\2\u01c3\u01c4\7\u0082\2\2\u01c4\u01c5\7\b\2\2\u01c5\u01c6\7\u0082\2"+
		"\2\u01c6\u01c7\7\b\2\2\u01c7\u01c8\7j\2\2\u01c8\u01c9\7\b\2\2\u01c9\u01cb"+
		"\7k\2\2\u01ca\u01cc\7\u0085\2\2\u01cb\u01ca\3\2\2\2\u01cc\u01cd\3\2\2"+
		"\2\u01cd\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d9\3\2\2\2\u01cf\u01d0"+
		"\5\32\16\2\u01d0\u01d1\7l\2\2\u01d1\u01d2\5\34\17\2\u01d2\u01d6\7l\2\2"+
		"\u01d3\u01d5\7\u0085\2\2\u01d4\u01d3\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6"+
		"\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01da\3\2\2\2\u01d8\u01d6\3\2"+
		"\2\2\u01d9\u01cf\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\3\2\2\2\u01db"+
		"\u01dd\5&\24\2\u01dc\u01c2\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\31\3\2\2"+
		"\2\u01de\u01df\t\36\2\2\u01df\33\3\2\2\2\u01e0\u01e4\7\6\2\2\u01e1\u01e3"+
		"\7\u0085\2\2\u01e2\u01e1\3\2\2\2\u01e3\u01e6\3\2\2\2\u01e4\u01e2\3\2\2"+
		"\2\u01e4\u01e5\3\2\2\2\u01e5\u01e7\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e7\u01eb"+
		"\7m\2\2\u01e8\u01ea\7\u0085\2\2\u01e9\u01e8\3\2\2\2\u01ea\u01ed\3\2\2"+
		"\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ef\3\2\2\2\u01ed\u01eb"+
		"\3\2\2\2\u01ee\u01f0\5\36\20\2\u01ef\u01ee\3\2\2\2\u01ef\u01f0\3\2\2\2"+
		"\u01f0\u01fb\3\2\2\2\u01f1\u01f3\7\u0085\2\2\u01f2\u01f1\3\2\2\2\u01f3"+
		"\u01f4\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f7\3\2"+
		"\2\2\u01f6\u01f8\5\36\20\2\u01f7\u01f6\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8"+
		"\u01fa\3\2\2\2\u01f9\u01f2\3\2\2\2\u01fa\u01fd\3\2\2\2\u01fb\u01f9\3\2"+
		"\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fe\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fe"+
		"\u0202\7\7\2\2\u01ff\u0201\7\u0085\2\2\u0200\u01ff\3\2\2\2\u0201\u0204"+
		"\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\35\3\2\2\2\u0204"+
		"\u0202\3\2\2\2\u0205\u0208\5 \21\2\u0206\u0208\5\"\22\2\u0207\u0205\3"+
		"\2\2\2\u0207\u0206\3\2\2\2\u0208\37\3\2\2\2\u0209\u020a\7\u0082\2\2\u020a"+
		"\u020b\7\b\2\2\u020b\u020c\5\16\b\2\u020c!\3\2\2\2\u020d\u020e\7n\2\2"+
		"\u020e\u0210\7\u0082\2\2\u020f\u0211\7\u0085\2\2\u0210\u020f\3\2\2\2\u0210"+
		"\u0211\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213\7\21\2\2\u0213\u0218\5"+
		"$\23\2\u0214\u0215\7\3\2\2\u0215\u0217\5$\23\2\u0216\u0214\3\2\2\2\u0217"+
		"\u021a\3\2\2\2\u0218\u0216\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021b\3\2"+
		"\2\2\u021a\u0218\3\2\2\2\u021b\u021c\7\22\2\2\u021c\u021d\7>\2\2\u021d"+
		"\u021e\5\22\n\2\u021e#\3\2\2\2\u021f\u0220\7\u0082\2\2\u0220\u0221\7>"+
		"\2\2\u0221\u0222\5\22\n\2\u0222%\3\2\2\2\u0223\u0225\5(\25\2\u0224\u0223"+
		"\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0230\3\2\2\2\u0226\u0228\7\u0085\2"+
		"\2\u0227\u0226\3\2\2\2\u0228\u0229\3\2\2\2\u0229\u0227\3\2\2\2\u0229\u022a"+
		"\3\2\2\2\u022a\u022c\3\2\2\2\u022b\u022d\5(\25\2\u022c\u022b\3\2\2\2\u022c"+
		"\u022d\3\2\2\2\u022d\u022f\3\2\2\2\u022e\u0227\3\2\2\2\u022f\u0232\3\2"+
		"\2\2\u0230\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231\'\3\2\2\2\u0232\u0230"+
		"\3\2\2\2\u0233\u0234\t\37\2\2\u0234\u0235\7\u0082\2\2\u0235\u0236\7>\2"+
		"\2\u0236\u0237\5\22\n\2\u0237\u0239\7#\2\2\u0238\u023a\7\u0085\2\2\u0239"+
		"\u0238\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\5*"+
		"\26\2\u023c\u02d5\3\2\2\2\u023d\u023e\7\u0082\2\2\u023e\u0240\7#\2\2\u023f"+
		"\u0241\7\u0085\2\2\u0240\u023f\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0242"+
		"\3\2\2\2\u0242\u02d5\5*\26\2\u0243\u0244\7q\2\2\u0244\u0245\7\21\2\2\u0245"+
		"\u0246\5*\26\2\u0246\u0247\7\22\2\2\u0247\u02d5\3\2\2\2\u0248\u0249\7"+
		"r\2\2\u0249\u024a\7\21\2\2\u024a\u024b\5*\26\2\u024b\u024f\7\22\2\2\u024c"+
		"\u024e\7\u0085\2\2\u024d\u024c\3\2\2\2\u024e\u0251\3\2\2\2\u024f\u024d"+
		"\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0252\3\2\2\2\u0251\u024f\3\2\2\2\u0252"+
		"\u0253\7\6\2\2\u0253\u0254\5&\24\2\u0254\u0260\7\7\2\2\u0255\u0259\7s"+
		"\2\2\u0256\u0258\7\u0085\2\2\u0257\u0256\3\2\2\2\u0258\u025b\3\2\2\2\u0259"+
		"\u0257\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u025c\3\2\2\2\u025b\u0259\3\2"+
		"\2\2\u025c\u025d\7\6\2\2\u025d\u025e\5&\24\2\u025e\u025f\7\7\2\2\u025f"+
		"\u0261\3\2\2\2\u0260\u0255\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u02d5\3\2"+
		"\2\2\u0262\u0263\7t\2\2\u0263\u0264\7\21\2\2\u0264\u0265\5*\26\2\u0265"+
		"\u0269\7\22\2\2\u0266\u0268\7\u0085\2\2\u0267\u0266\3\2\2\2\u0268\u026b"+
		"\3\2\2\2\u0269\u0267\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u026c\3\2\2\2\u026b"+
		"\u0269\3\2\2\2\u026c\u0278\7\6\2\2\u026d\u026f\7\u0085\2\2\u026e\u026d"+
		"\3\2\2\2\u026f\u0272\3\2\2\2\u0270\u026e\3\2\2\2\u0270\u0271\3\2\2\2\u0271"+
		"\u0273\3\2\2\2\u0272\u0270\3\2\2\2\u0273\u0274\5\32\16\2\u0274\u0275\7"+
		"l\2\2\u0275\u0276\5,\27\2\u0276\u0277\7l\2\2\u0277\u0279\3\2\2\2\u0278"+
		"\u0270\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027b\5&"+
		"\24\2\u027b\u027c\7\7\2\2\u027c\u02d5\3\2\2\2\u027d\u027e\t \2\2\u027e"+
		"\u027f\7\21\2\2\u027f\u0280\7\u0082\2\2\u0280\u0281\7\u0083\2\2\u0281"+
		"\u02d5\7\22\2\2\u0282\u0283\7\u0082\2\2\u0283\u0284\7\21\2\2\u0284\u0285"+
		"\5*\26\2\u0285\u0286\7\22\2\2\u0286\u0288\7#\2\2\u0287\u0289\7\u0085\2"+
		"\2\u0288\u0287\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028b"+
		"\5*\26\2\u028b\u02d5\3\2\2\2\u028c\u028d\7n\2\2\u028d\u028f\7\u0082\2"+
		"\2\u028e\u0290\7\u0085\2\2\u028f\u028e\3\2\2\2\u028f\u0290\3\2\2\2\u0290"+
		"\u0291\3\2\2\2\u0291\u029a\7\21\2\2\u0292\u0297\5$\23\2\u0293\u0294\7"+
		"\3\2\2\u0294\u0296\5$\23\2\u0295\u0293\3\2\2\2\u0296\u0299\3\2\2\2\u0297"+
		"\u0295\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u029b\3\2\2\2\u0299\u0297\3\2"+
		"\2\2\u029a\u0292\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029c\3\2\2\2\u029c"+
		"\u029d\7\22\2\2\u029d\u02a0\7>\2\2\u029e\u02a1\5\22\n\2\u029f\u02a1\7"+
		"w\2\2\u02a0\u029e\3\2\2\2\u02a0\u029f\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2"+
		"\u02a6\7#\2\2\u02a3\u02a5\7\u0085\2\2\u02a4\u02a3\3\2\2\2\u02a5\u02a8"+
		"\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02a9\3\2\2\2\u02a8"+
		"\u02a6\3\2\2\2\u02a9\u02bb\7\6\2\2\u02aa\u02ac\7\u0085\2\2\u02ab\u02aa"+
		"\3\2\2\2\u02ac\u02af\3\2\2\2\u02ad\u02ab\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae"+
		"\u02b0\3\2\2\2\u02af\u02ad\3\2\2\2\u02b0\u02b1\5\32\16\2\u02b1\u02b2\7"+
		"l\2\2\u02b2\u02b6\5\60\31\2\u02b3\u02b5\7\u0085\2\2\u02b4\u02b3\3\2\2"+
		"\2\u02b5\u02b8\3\2\2\2\u02b6\u02b4\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b9"+
		"\3\2\2\2\u02b8\u02b6\3\2\2\2\u02b9\u02ba\7l\2\2\u02ba\u02bc\3\2\2\2\u02bb"+
		"\u02ad\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02c6\5&"+
		"\24\2\u02be\u02bf\7x\2\2\u02bf\u02c3\5*\26\2\u02c0\u02c2\7\u0085\2\2\u02c1"+
		"\u02c0\3\2\2\2\u02c2\u02c5\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c3\u02c4\3\2"+
		"\2\2\u02c4\u02c7\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c6\u02be\3\2\2\2\u02c6"+
		"\u02c7\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02c9\7\7\2\2\u02c9\u02d5\3\2"+
		"\2\2\u02ca\u02cb\5\32\16\2\u02cb\u02cf\7l\2\2\u02cc\u02d0\5\n\6\2\u02cd"+
		"\u02d0\5\b\5\2\u02ce\u02d0\5\62\32\2\u02cf\u02cc\3\2\2\2\u02cf\u02cd\3"+
		"\2\2\2\u02cf\u02ce\3\2\2\2\u02d0\u02d1\3\2\2\2\u02d1\u02d2\7l\2\2\u02d2"+
		"\u02d5\3\2\2\2\u02d3\u02d5\5*\26\2\u02d4\u0233\3\2\2\2\u02d4\u023d\3\2"+
		"\2\2\u02d4\u0243\3\2\2\2\u02d4\u0248\3\2\2\2\u02d4\u0262\3\2\2\2\u02d4"+
		"\u027d\3\2\2\2\u02d4\u0282\3\2\2\2\u02d4\u028c\3\2\2\2\u02d4\u02ca\3\2"+
		"\2\2\u02d4\u02d3\3\2\2\2\u02d5)\3\2\2\2\u02d6\u02d7\b\26\1\2\u02d7\u02d8"+
		"\t!\2\2\u02d8\u0308\5*\26\n\u02d9\u0308\t\4\2\2\u02da\u0308\7\u0081\2"+
		"\2\u02db\u02ea\7\u0082\2\2\u02dc\u02e5\7\21\2\2\u02dd\u02e2\5*\26\2\u02de"+
		"\u02df\7\3\2\2\u02df\u02e1\5*\26\2\u02e0\u02de\3\2\2\2\u02e1\u02e4\3\2"+
		"\2\2\u02e2\u02e0\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3\u02e6\3\2\2\2\u02e4"+
		"\u02e2\3\2\2\2\u02e5\u02dd\3\2\2\2\u02e5\u02e6\3\2\2\2\u02e6\u02e7\3\2"+
		"\2\2\u02e7\u02eb\7\22\2\2\u02e8\u02e9\7\b\2\2\u02e9\u02eb\7\u0082\2\2"+
		"\u02ea\u02dc\3\2\2\2\u02ea\u02e8\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u0308"+
		"\3\2\2\2\u02ec\u02ed\t\5\2\2\u02ed\u02ee\7\21\2\2\u02ee\u02ef\7\u0083"+
		"\2\2\u02ef\u0308\7\22\2\2\u02f0\u02f1\t\6\2\2\u02f1\u02fa\7\21\2\2\u02f2"+
		"\u02f7\5*\26\2\u02f3\u02f4\7\3\2\2\u02f4\u02f6\5*\26\2\u02f5\u02f3\3\2"+
		"\2\2\u02f6\u02f9\3\2\2\2\u02f7\u02f5\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8"+
		"\u02fb\3\2\2\2\u02f9\u02f7\3\2\2\2\u02fa\u02f2\3\2\2\2\u02fa\u02fb\3\2"+
		"\2\2\u02fb\u02fc\3\2\2\2\u02fc\u0308\7\22\2\2\u02fd\u02fe\7y\2\2\u02fe"+
		"\u0300\7\21\2\2\u02ff\u0301\7\u0083\2\2\u0300\u02ff\3\2\2\2\u0300\u0301"+
		"\3\2\2\2\u0301\u0302\3\2\2\2\u0302\u0308\7\22\2\2\u0303\u0304\7\21\2\2"+
		"\u0304\u0305\5*\26\2\u0305\u0306\7\22\2\2\u0306\u0308\3\2\2\2\u0307\u02d6"+
		"\3\2\2\2\u0307\u02d9\3\2\2\2\u0307\u02da\3\2\2\2\u0307\u02db\3\2\2\2\u0307"+
		"\u02ec\3\2\2\2\u0307\u02f0\3\2\2\2\u0307\u02fd\3\2\2\2\u0307\u0303\3\2"+
		"\2\2\u0308\u0335\3\2\2\2\u0309\u030a\f\t\2\2\u030a\u030c\t\7\2\2\u030b"+
		"\u030d\7\u0085\2\2\u030c\u030b\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u030e"+
		"\3\2\2\2\u030e\u0334\5*\26\n\u030f\u0310\f\b\2\2\u0310\u0312\t\"\2\2\u0311"+
		"\u0313\7\u0085\2\2\u0312\u0311\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0314"+
		"\3\2\2\2\u0314\u0334\5*\26\t\u0315\u0316\f\7\2\2\u0316\u0318\7z\2\2\u0317"+
		"\u0319\7\u0085\2\2\u0318\u0317\3\2\2\2\u0318\u0319\3\2\2\2\u0319\u031a"+
		"\3\2\2\2\u031a\u0334\5*\26\b\u031b\u031c\f\6\2\2\u031c\u031e\t#\2\2\u031d"+
		"\u031f\7\u0085\2\2\u031e\u031d\3\2\2\2\u031e\u031f\3\2\2\2\u031f\u0320"+
		"\3\2\2\2\u0320\u0334\5*\26\7\u0321\u0322\f\5\2\2\u0322\u0324\t$\2\2\u0323"+
		"\u0325\7\u0085\2\2\u0324\u0323\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0326"+
		"\3\2\2\2\u0326\u0334\5*\26\6\u0327\u0328\f\4\2\2\u0328\u032a\7,\2\2\u0329"+
		"\u032b\7\u0085\2\2\u032a\u0329\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u032c"+
		"\3\2\2\2\u032c\u0334\5*\26\5\u032d\u032e\f\3\2\2\u032e\u0330\7\60\2\2"+
		"\u032f\u0331\7\u0085\2\2\u0330\u032f\3\2\2\2\u0330\u0331\3\2\2\2\u0331"+
		"\u0332\3\2\2\2\u0332\u0334\5*\26\4\u0333\u0309\3\2\2\2\u0333\u030f\3\2"+
		"\2\2\u0333\u0315\3\2\2\2\u0333\u031b\3\2\2\2\u0333\u0321\3\2\2\2\u0333"+
		"\u0327\3\2\2\2\u0333\u032d\3\2\2\2\u0334\u0337\3\2\2\2\u0335\u0333\3\2"+
		"\2\2\u0335\u0336\3\2\2\2\u0336+\3\2\2\2\u0337\u0335\3\2\2\2\u0338\u033c"+
		"\7\6\2\2\u0339\u033b\7\u0085\2\2\u033a\u0339\3\2\2\2\u033b\u033e\3\2\2"+
		"\2\u033c\u033a\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u033f\3\2\2\2\u033e\u033c"+
		"\3\2\2\2\u033f\u0343\7g\2\2\u0340\u0342\7\u0085\2\2\u0341\u0340\3\2\2"+
		"\2\u0342\u0345\3\2\2\2\u0343\u0341\3\2\2\2\u0343\u0344\3\2\2\2\u0344\u0347"+
		"\3\2\2\2\u0345\u0343\3\2\2\2\u0346\u0348\5\16\b\2\u0347\u0346\3\2\2\2"+
		"\u0347\u0348\3\2\2\2\u0348\u0353\3\2\2\2\u0349\u034b\7\u0085\2\2\u034a"+
		"\u0349\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u034a\3\2\2\2\u034c\u034d\3\2"+
		"\2\2\u034d\u034f\3\2\2\2\u034e\u0350\5\16\b\2\u034f\u034e\3\2\2\2\u034f"+
		"\u0350\3\2\2\2\u0350\u0352\3\2\2\2\u0351\u034a\3\2\2\2\u0352\u0355\3\2"+
		"\2\2\u0353\u0351\3\2\2\2\u0353\u0354\3\2\2\2\u0354\u0356\3\2\2\2\u0355"+
		"\u0353\3\2\2\2\u0356\u0357\5.\30\2\u0357\u035b\7\7\2\2\u0358\u035a\7\u0085"+
		"\2\2\u0359\u0358\3\2\2\2\u035a\u035d\3\2\2\2\u035b\u0359\3\2\2\2\u035b"+
		"\u035c\3\2\2\2\u035c-\3\2\2\2\u035d\u035b\3\2\2\2\u035e\u0367\7{\2\2\u035f"+
		"\u0364\7\u0082\2\2\u0360\u0361\7\3\2\2\u0361\u0363\7\u0082\2\2\u0362\u0360"+
		"\3\2\2\2\u0363\u0366\3\2\2\2\u0364\u0362\3\2\2\2\u0364\u0365\3\2\2\2\u0365"+
		"\u0368\3\2\2\2\u0366\u0364\3\2\2\2\u0367\u035f\3\2\2\2\u0367\u0368\3\2"+
		"\2\2\u0368\u036c\3\2\2\2\u0369\u036b\7\u0085\2\2\u036a\u0369\3\2\2\2\u036b"+
		"\u036e\3\2\2\2\u036c\u036a\3\2\2\2\u036c\u036d\3\2\2\2\u036d/\3\2\2\2"+
		"\u036e\u036c\3\2\2\2\u036f\u0373\7\6\2\2\u0370\u0372\7\u0085\2\2\u0371"+
		"\u0370\3\2\2\2\u0372\u0375\3\2\2\2\u0373\u0371\3\2\2\2\u0373\u0374\3\2"+
		"\2\2\u0374\u038b\3\2\2\2\u0375\u0373\3\2\2\2\u0376\u037a\t%\2\2\u0377"+
		"\u0379\7\u0085\2\2\u0378\u0377\3\2\2\2\u0379\u037c\3\2\2\2\u037a\u0378"+
		"\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u037d\3\2\2\2\u037c\u037a\3\2\2\2\u037d"+
		"\u0388\5\16\b\2\u037e\u0380\7\u0085\2\2\u037f\u037e\3\2\2\2\u0380\u0381"+
		"\3\2\2\2\u0381\u037f\3\2\2\2\u0381\u0382\3\2\2\2\u0382\u0384\3\2\2\2\u0383"+
		"\u0385\5\16\b\2\u0384\u0383\3\2\2\2\u0384\u0385\3\2\2\2\u0385\u0387\3"+
		"\2\2\2\u0386\u037f\3\2\2\2\u0387\u038a\3\2\2\2\u0388\u0386\3\2\2\2\u0388"+
		"\u0389\3\2\2\2\u0389\u038c\3\2\2\2\u038a\u0388\3\2\2\2\u038b\u0376\3\2"+
		"\2\2\u038b\u038c\3\2\2\2\u038c\u0390\3\2\2\2\u038d\u038f\7\u0085\2\2\u038e"+
		"\u038d\3\2\2\2\u038f\u0392\3\2\2\2\u0390\u038e\3\2\2\2\u0390\u0391\3\2"+
		"\2\2\u0391\u0394\3\2\2\2\u0392\u0390\3\2\2\2\u0393\u0395\5.\30\2\u0394"+
		"\u0393\3\2\2\2\u0394\u0395\3\2\2\2\u0395\u03ab\3\2\2\2\u0396\u039a\t&"+
		"\2\2\u0397\u0399\7\u0085\2\2\u0398\u0397\3\2\2\2\u0399\u039c\3\2\2\2\u039a"+
		"\u0398\3\2\2\2\u039a\u039b\3\2\2\2\u039b\u039d\3\2\2\2\u039c\u039a\3\2"+
		"\2\2\u039d\u03a8\5\16\b\2\u039e\u03a0\7\u0085\2\2\u039f\u039e\3\2\2\2"+
		"\u03a0\u03a1\3\2\2\2\u03a1\u039f\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2\u03a4"+
		"\3\2\2\2\u03a3\u03a5\5\16\b\2\u03a4\u03a3\3\2\2\2\u03a4\u03a5\3\2\2\2"+
		"\u03a5\u03a7\3\2\2\2\u03a6\u039f\3\2\2\2\u03a7\u03aa\3\2\2\2\u03a8\u03a6"+
		"\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03ac\3\2\2\2\u03aa\u03a8\3\2\2\2\u03ab"+
		"\u0396\3\2\2\2\u03ab\u03ac\3\2\2\2\u03ac\u03b0\3\2\2\2\u03ad\u03af\7\u0085"+
		"\2\2\u03ae\u03ad\3\2\2\2\u03af\u03b2\3\2\2\2\u03b0\u03ae\3\2\2\2\u03b0"+
		"\u03b1\3\2\2\2\u03b1\u03b3\3\2\2\2\u03b2\u03b0\3\2\2\2\u03b3\u03b7\7\7"+
		"\2\2\u03b4\u03b6\7\u0085\2\2\u03b5\u03b4\3\2\2\2\u03b6\u03b9\3\2\2\2\u03b7"+
		"\u03b5\3\2\2\2\u03b7\u03b8\3\2\2\2\u03b8\61\3\2\2\2\u03b9\u03b7\3\2\2"+
		"\2\u03ba\u03be\7\6\2\2\u03bb\u03bd\7\u0085\2\2\u03bc\u03bb\3\2\2\2\u03bd"+
		"\u03c0\3\2\2\2\u03be\u03bc\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\u03c1\3\2"+
		"\2\2\u03c0\u03be\3\2\2\2\u03c1\u03c5\7g\2\2\u03c2\u03c4\7\u0085\2\2\u03c3"+
		"\u03c2\3\2\2\2\u03c4\u03c7\3\2\2\2\u03c5\u03c3\3\2\2\2\u03c5\u03c6\3\2"+
		"\2\2\u03c6\u03c9\3\2\2\2\u03c7\u03c5\3\2\2\2\u03c8\u03ca\5\16\b\2\u03c9"+
		"\u03c8\3\2\2\2\u03c9\u03ca\3\2\2\2\u03ca\u03d5\3\2\2\2\u03cb\u03cd\7\u0085"+
		"\2\2\u03cc\u03cb\3\2\2\2\u03cd\u03ce\3\2\2\2\u03ce\u03cc\3\2\2\2\u03ce"+
		"\u03cf\3\2\2\2\u03cf\u03d1\3\2\2\2\u03d0\u03d2\5\16\b\2\u03d1\u03d0\3"+
		"\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03d4\3\2\2\2\u03d3\u03cc\3\2\2\2\u03d4"+
		"\u03d7\3\2\2\2\u03d5\u03d3\3\2\2\2\u03d5\u03d6\3\2\2\2\u03d6\u03d8\3\2"+
		"\2\2\u03d7\u03d5\3\2\2\2\u03d8\u03dc\7\7\2\2\u03d9\u03db\7\u0085\2\2\u03da"+
		"\u03d9\3\2\2\2\u03db\u03de\3\2\2\2\u03dc\u03da\3\2\2\2\u03dc\u03dd\3\2"+
		"\2\2\u03dd\63\3\2\2\2\u03de\u03dc\3\2\2\2\u00958<AQT\\bikotw{\u0082\u008f"+
		"\u0096\u009d\u00a2\u00a7\u00aa\u00ae\u00b2\u00bd\u00cb\u00dc\u00df\u00e3"+
		"\u00e8\u00ee\u00f4\u00fa\u0100\u0106\u010c\u010f\u0111\u011a\u011f\u0123"+
		"\u012e\u0135\u013a\u0140\u0147\u014d\u0153\u015b\u0161\u0168\u016f\u0176"+
		"\u0180\u0188\u018e\u0195\u01a2\u01ad\u01b5\u01b8\u01bf\u01cd\u01d6\u01d9"+
		"\u01dc\u01e4\u01eb\u01ef\u01f4\u01f7\u01fb\u0202\u0207\u0210\u0218\u0224"+
		"\u0229\u022c\u0230\u0239\u0240\u024f\u0259\u0260\u0269\u0270\u0278\u0288"+
		"\u028f\u0297\u029a\u02a0\u02a6\u02ad\u02b6\u02bb\u02c3\u02c6\u02cf\u02d4"+
		"\u02e2\u02e5\u02ea\u02f7\u02fa\u0300\u0307\u030c\u0312\u0318\u031e\u0324"+
		"\u032a\u0330\u0333\u0335\u033c\u0343\u0347\u034c\u034f\u0353\u035b\u0364"+
		"\u0367\u036c\u0373\u037a\u0381\u0384\u0388\u038b\u0390\u0394\u039a\u03a1"+
		"\u03a4\u03a8\u03ab\u03b0\u03b7\u03be\u03c5\u03c9\u03ce\u03d1\u03d5\u03dc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}