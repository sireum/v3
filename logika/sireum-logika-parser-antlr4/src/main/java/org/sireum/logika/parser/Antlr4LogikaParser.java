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
		T__119=120, T__120=121, T__121=122, HLINE=123, NUM=124, ID=125, SSTRING=126, 
		STRING=127, RESERVED=128, NL=129, LINE_COMMENT=130, COMMENT=131, WS=132, 
		ERROR_CHAR=133;
	public static final int
		RULE_sequentFile = 0, RULE_proofFile = 1, RULE_programFile = 2, RULE_sequent = 3, 
		RULE_proof = 4, RULE_proofStep = 5, RULE_formula = 6, RULE_qformula = 7, 
		RULE_type = 8, RULE_justification = 9, RULE_numOrId = 10, RULE_program = 11, 
		RULE_facts = 12, RULE_factOrFun = 13, RULE_fact = 14, RULE_fun = 15, RULE_param = 16, 
		RULE_stmts = 17, RULE_stmt = 18, RULE_exp = 19, RULE_loopInvariant = 20, 
		RULE_modifies = 21, RULE_methodContract = 22, RULE_invariants = 23;
	public static final String[] ruleNames = {
		"sequentFile", "proofFile", "programFile", "sequent", "proof", "proofStep", 
		"formula", "qformula", "type", "justification", "numOrId", "program", 
		"facts", "factOrFun", "fact", "fun", "param", "stmts", "stmt", "exp", 
		"loopInvariant", "modifies", "methodContract", "invariants"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'|-'", "'⊢'", "'{'", "'}'", "'.'", "':'", "'assume'", "'true'", 
		"'T'", "'⊤'", "'false'", "'F'", "'_|_'", "'⊥'", "'('", "')'", "'result'", 
		"'Z'", "'ZS'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<'", "'<='", "'≤'", 
		"'>'", "'>='", "'≥'", "'='", "'=='", "'!='", "'≠'", "'not'", "'!'", "'~'", 
		"'¬'", "'and'", "'&&'", "'^'", "'∧'", "'or'", "'||'", "'V'", "'∨'", "'implies'", 
		"'->'", "'→'", "'forall'", "'all'", "'A'", "'∀'", "'exists'", "'some'", 
		"'E'", "'∃'", "'..'", "'|'", "'B'", "'premise'", "'andi'", "'^i'", "'ande1'", 
		"'^e1'", "'ande2'", "'^e2'", "'ori1'", "'Vi1'", "'ori2'", "'Vi2'", "'ore'", 
		"'Ve'", "'impliesi'", "'impliese'", "'noti'", "'negi'", "'note'", "'nege'", 
		"'bottome'", "'falsee'", "'Pbc'", "'foralli'", "'alli'", "'Ai'", "'foralle'", 
		"'alle'", "'Ae'", "'existsi'", "'somei'", "'Ei'", "'existse'", "'somee'", 
		"'Ee'", "'algebra'", "'invariant'", "'auto'", "'import'", "'logika'", 
		"'_'", "'l\"\"\"'", "'\"\"\"'", "'fact'", "'def'", "'var'", "'val'", "'assert'", 
		"'if'", "'else'", "'while'", "'print'", "'println'", "'Unit'", "'return'", 
		"'readInt'", "'+:'", "'modifies'", "'requires'", "'pre'", "'ensures'", 
		"'post'"
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
		null, null, null, "HLINE", "NUM", "ID", "SSTRING", "STRING", "RESERVED", 
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
			setState(48);
			sequent();
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(49);
					match(NL);
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(56);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(55);
				proof();
				}
			}

			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(58);
				match(NL);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
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
			setState(66);
			proof();
			setState(67);
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
			setState(69);
			program();
			setState(70);
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
			setState(103);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
					{
					setState(72);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(73);
						match(T__0);
						setState(74);
						((SequentContext)_localctx).formula = formula(0);
						((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
						}
						}
						setState(79);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(82);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(83);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(84);
					match(T__0);
					setState(85);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
					{
					{
					setState(91);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(96);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(97);
				match(HLINE);
				setState(99); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(98);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(101); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID );
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
			setState(105);
			((ProofContext)_localctx).tb = match(T__3);
			setState(107);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(106);
				proofStep();
				}
			}

			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(110); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(109);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(112); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(115);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(114);
					proofStep();
					}
				}

				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			((ProofContext)_localctx).te = match(T__4);
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(123);
					match(NL);
					}
					} 
				}
				setState(128);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
			setState(183);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(NUM);
				setState(130);
				match(T__5);
				setState(131);
				formula(0);
				setState(132);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(135);
				match(T__5);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(136);
					match(NL);
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(142);
				match(T__3);
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(143);
					match(NL);
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(149);
				((SubProofContext)_localctx).assume = match(NUM);
				setState(150);
				match(T__5);
				setState(167);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(151);
					match(ID);
					setState(154);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(152);
						match(T__6);
						setState(153);
						type();
						}
					}

					}
					break;
				case 2:
					{
					setState(156);
					formula(0);
					setState(157);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				case 3:
					{
					setState(159);
					match(ID);
					setState(162);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(160);
						match(T__6);
						setState(161);
						type();
						}
					}

					setState(164);
					formula(0);
					setState(165);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(170); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(169);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(172); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(175);
					_la = _input.LA(1);
					if (_la==NUM) {
						{
						setState(174);
						proofStep();
						}
					}

					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(182);
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
			setState(232);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(186);
				((UnaryContext)_localctx).op = match(T__24);
				setState(187);
				formula(6);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(189);
				formula(5);
				}
				break;
			case 3:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				((BooleanContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
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
				setState(191);
				((VarContext)_localctx).tb = match(ID);
				setState(194);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(192);
					match(T__5);
					setState(193);
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
				setState(196);
				match(T__15);
				setState(197);
				formula(0);
				setState(198);
				match(T__16);
				}
				break;
			case 6:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(T__17);
				}
				break;
			case 7:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(ID);
				setState(202);
				match(T__15);
				setState(203);
				formula(0);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(204);
					match(T__0);
					setState(205);
					formula(0);
					}
					}
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(211);
				match(T__16);
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				match(NUM);
				}
				break;
			case 9:
				{
				_localctx = new BigIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				match(T__18);
				setState(215);
				match(T__15);
				setState(216);
				match(STRING);
				setState(217);
				match(T__16);
				}
				break;
			case 10:
				{
				_localctx = new SeqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218);
				match(T__19);
				setState(219);
				match(T__15);
				setState(228);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & ((1L << (T__115 - 116)) | (1L << (NUM - 116)) | (1L << (ID - 116)))) != 0)) {
					{
					setState(220);
					exp(0);
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(221);
						match(T__0);
						setState(222);
						exp(0);
						}
						}
						setState(227);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(230);
				match(T__16);
				}
				break;
			case 11:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(278);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(276);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(234);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(235);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(240);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(241);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
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
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(246);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(247);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(252);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(253);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(258);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(259);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(264);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(265);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(270);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(271);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__47) | (1L << T__48) | (1L << T__49))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(273);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(272);
							match(NL);
							}
						}

						setState(275);
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(280);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
			setState(281);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(282);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(283);
				match(T__0);
				setState(284);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(297);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(290);
				match(T__6);
				setState(291);
				type();
				}
				break;
			case 2:
				{
				setState(292);
				match(T__6);
				setState(293);
				((QformulaContext)_localctx).lo = exp(0);
				setState(294);
				match(T__58);
				setState(295);
				((QformulaContext)_localctx).hi = exp(0);
				}
				break;
			}
			setState(299);
			match(T__59);
			setState(301);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(300);
				match(NL);
				}
			}

			setState(303);
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
			setState(308);
			switch (_input.LA(1)) {
			case T__60:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				((BooleanTypeContext)_localctx).t = match(T__60);
				}
				break;
			case T__18:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
				((IntTypeContext)_localctx).t = match(T__18);
				}
				break;
			case T__19:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(307);
				((IntSeqTypeContext)_localctx).t = match(T__19);
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
			setState(434);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				((PremiseContext)_localctx).t = match(T__61);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				switch (_input.LA(1)) {
				case T__62:
				case T__63:
					{
					setState(311);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__62 || _la==T__63) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__40:
				case T__42:
					{
					setState(312);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__40 || _la==T__42) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(313);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(316);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(317);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(321);
				switch (_input.LA(1)) {
				case T__64:
				case T__65:
				case T__66:
				case T__67:
					{
					setState(318);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__64 - 65)) | (1L << (T__65 - 65)) | (1L << (T__66 - 65)) | (1L << (T__67 - 65)))) != 0)) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__40:
				case T__42:
					{
					setState(319);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__40 || _la==T__42) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(327);
				switch (_input.LA(1)) {
				case T__68:
				case T__69:
				case T__70:
				case T__71:
					{
					setState(324);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (T__68 - 69)) | (1L << (T__69 - 69)) | (1L << (T__70 - 69)) | (1L << (T__71 - 69)))) != 0)) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__44:
				case T__46:
					{
					setState(325);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__44 || _la==T__46) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(333);
				switch (_input.LA(1)) {
				case T__72:
				case T__73:
					{
					setState(330);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__72 || _la==T__73) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__44:
				case T__46:
					{
					setState(331);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__44 || _la==T__46) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(332);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(335);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(336);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(337);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(341);
				switch (_input.LA(1)) {
				case T__74:
					{
					setState(338);
					((ImpliesIntroContext)_localctx).tb = match(T__74);
					}
					break;
				case T__48:
				case T__49:
					{
					setState(339);
					((ImpliesIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__48 || _la==T__49) ) {
						((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(347);
				switch (_input.LA(1)) {
				case T__75:
					{
					setState(344);
					((ImpliesElimContext)_localctx).tb = match(T__75);
					}
					break;
				case T__48:
				case T__49:
					{
					setState(345);
					((ImpliesElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__48 || _la==T__49) ) {
						((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(346);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(349);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(350);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(354);
				switch (_input.LA(1)) {
				case T__76:
				case T__77:
					{
					setState(351);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__76 || _la==T__77) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__36:
				case T__37:
				case T__38:
					{
					setState(352);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(353);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(356);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(361);
				switch (_input.LA(1)) {
				case T__78:
					{
					setState(357);
					((NegElimContext)_localctx).tb = match(T__78);
					}
					break;
				case T__79:
					{
					setState(358);
					((NegElimContext)_localctx).tb = match(T__79);
					}
					break;
				case T__36:
				case T__37:
				case T__38:
					{
					setState(359);
					((NegElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
						((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(360);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(363);
				((NegElimContext)_localctx).step = match(NUM);
				setState(364);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(368);
				switch (_input.LA(1)) {
				case T__80:
				case T__81:
					{
					setState(365);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__80 || _la==T__81) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__13:
				case T__14:
					{
					setState(366);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==T__14) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(367);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(370);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 11:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(371);
				((PbcContext)_localctx).tb = match(T__82);
				setState(372);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 12:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(378);
				switch (_input.LA(1)) {
				case T__83:
					{
					setState(373);
					((ForallIntroContext)_localctx).tb = match(T__83);
					}
					break;
				case T__84:
					{
					setState(374);
					((ForallIntroContext)_localctx).tb = match(T__84);
					}
					break;
				case T__85:
					{
					setState(375);
					((ForallIntroContext)_localctx).tb = match(T__85);
					}
					break;
				case T__53:
					{
					setState(376);
					((ForallIntroContext)_localctx).tb = match(T__53);
					setState(377);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(380);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(386);
				switch (_input.LA(1)) {
				case T__86:
					{
					setState(381);
					((ForallElimContext)_localctx).tb = match(T__86);
					}
					break;
				case T__87:
					{
					setState(382);
					((ForallElimContext)_localctx).tb = match(T__87);
					}
					break;
				case T__88:
					{
					setState(383);
					((ForallElimContext)_localctx).tb = match(T__88);
					}
					break;
				case T__53:
					{
					setState(384);
					((ForallElimContext)_localctx).tb = match(T__53);
					setState(385);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(388);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
				setState(390); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(389);
					formula(0);
					}
					}
					setState(392); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 14:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(394);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (T__89 - 90)) | (1L << (T__90 - 90)) | (1L << (T__91 - 90)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(395);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(397); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(396);
					formula(0);
					}
					}
					setState(399); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 15:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(401);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (T__92 - 93)) | (1L << (T__93 - 93)) | (1L << (T__94 - 93)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(402);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(403);
				((ExistsElimContext)_localctx).subproof = match(NUM);
				}
				break;
			case 16:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(405);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(406);
				((ExistsIntroContext)_localctx).tb = match(T__57);
				setState(407);
				match(ID);
				setState(408);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(410); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(409);
					formula(0);
					}
					}
					setState(412); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 17:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(414);
				((ExistsElimContext)_localctx).tb = match(T__57);
				setState(415);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(416);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(417);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(419);
				((AlgebraContext)_localctx).tb = match(T__95);
				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(420);
					((AlgebraContext)_localctx).numOrId = numOrId();
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).numOrId);
					}
					}
					setState(425);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(426);
				((InvariantContext)_localctx).tb = match(T__96);
				}
				break;
			case 20:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(427);
				((AutoContext)_localctx).tb = match(T__97);
				setState(431);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(428);
					((AutoContext)_localctx).numOrId = numOrId();
					((AutoContext)_localctx).stepOrFacts.add(((AutoContext)_localctx).numOrId);
					}
					}
					setState(433);
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
			setState(436);
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
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(438);
				match(NL);
				}
				}
				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(469);
			_la = _input.LA(1);
			if (_la==T__98) {
				{
				setState(444);
				((ProgramContext)_localctx).tb = match(T__98);
				setState(445);
				((ProgramContext)_localctx).org = match(ID);
				setState(446);
				match(T__5);
				setState(447);
				((ProgramContext)_localctx).sireum = match(ID);
				setState(448);
				match(T__5);
				setState(449);
				match(T__99);
				setState(450);
				match(T__5);
				setState(451);
				((ProgramContext)_localctx).te = match(T__100);
				setState(453); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(452);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(455); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(466);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(457);
					match(T__101);
					setState(458);
					facts();
					setState(459);
					((ProgramContext)_localctx).te = match(T__102);
					setState(463);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(460);
							match(NL);
							}
							} 
						}
						setState(465);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
					}
					}
					break;
				}
				setState(468);
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
		enterRule(_localctx, 24, RULE_facts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(T__3);
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
			((FactsContext)_localctx).ftb = match(T__103);
			setState(482);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(479);
					match(NL);
					}
					} 
				}
				setState(484);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			}
			setState(486);
			_la = _input.LA(1);
			if (_la==T__104 || _la==ID) {
				{
				setState(485);
				factOrFun();
				}
			}

			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(489); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(488);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(491); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(494);
				_la = _input.LA(1);
				if (_la==T__104 || _la==ID) {
					{
					setState(493);
					factOrFun();
					}
				}

				}
				}
				setState(500);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(501);
			((FactsContext)_localctx).te = match(T__4);
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(502);
				match(NL);
				}
				}
				setState(507);
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
		enterRule(_localctx, 26, RULE_factOrFun);
		try {
			setState(510);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(508);
				fact();
				}
				break;
			case T__104:
				enterOuterAlt(_localctx, 2);
				{
				setState(509);
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
		enterRule(_localctx, 28, RULE_fact);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			match(ID);
			setState(513);
			match(T__5);
			setState(514);
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
		enterRule(_localctx, 30, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			((FunContext)_localctx).tb = match(T__104);
			setState(517);
			match(ID);
			setState(519);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(518);
				match(NL);
				}
			}

			setState(521);
			match(T__15);
			setState(522);
			param();
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(523);
				match(T__0);
				setState(524);
				param();
				}
				}
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(530);
			match(T__16);
			setState(531);
			match(T__6);
			setState(532);
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
		enterRule(_localctx, 32, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			match(ID);
			setState(535);
			match(T__6);
			setState(536);
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
		enterRule(_localctx, 34, RULE_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & ((1L << (T__101 - 102)) | (1L << (T__104 - 102)) | (1L << (T__105 - 102)) | (1L << (T__106 - 102)) | (1L << (T__107 - 102)) | (1L << (T__108 - 102)) | (1L << (T__110 - 102)) | (1L << (T__111 - 102)) | (1L << (T__112 - 102)) | (1L << (T__115 - 102)) | (1L << (NUM - 102)) | (1L << (ID - 102)))) != 0)) {
				{
				setState(538);
				stmt();
				}
			}

			setState(551);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(542); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(541);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(544); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(547);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & ((1L << (T__101 - 102)) | (1L << (T__104 - 102)) | (1L << (T__105 - 102)) | (1L << (T__106 - 102)) | (1L << (T__107 - 102)) | (1L << (T__108 - 102)) | (1L << (T__110 - 102)) | (1L << (T__111 - 102)) | (1L << (T__112 - 102)) | (1L << (T__115 - 102)) | (1L << (NUM - 102)) | (1L << (ID - 102)))) != 0)) {
					{
					setState(546);
					stmt();
					}
				}

				}
				}
				setState(553);
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
		public TerminalNode SSTRING() { return getToken(Antlr4LogikaParser.SSTRING, 0); }
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
		public LoopInvariantContext loopInvariant() {
			return getRuleContext(LoopInvariantContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
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
		enterRule(_localctx, 36, RULE_stmt);
		int _la;
		try {
			setState(711);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(554);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__105 || _la==T__106) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(555);
				match(ID);
				setState(556);
				match(T__6);
				setState(557);
				type();
				setState(558);
				match(T__31);
				setState(560);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(559);
					match(NL);
					}
				}

				setState(562);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(564);
				match(ID);
				setState(565);
				match(T__31);
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
			case 3:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(570);
				match(T__107);
				setState(571);
				match(T__15);
				setState(572);
				exp(0);
				setState(573);
				match(T__16);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(575);
				match(T__108);
				setState(576);
				match(T__15);
				setState(577);
				exp(0);
				setState(578);
				match(T__16);
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
				setState(586);
				((IfStmtContext)_localctx).ts = stmts();
				setState(587);
				match(T__4);
				setState(599);
				_la = _input.LA(1);
				if (_la==T__109) {
					{
					setState(588);
					match(T__109);
					setState(592);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(589);
						match(NL);
						}
						}
						setState(594);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(595);
					match(T__3);
					setState(596);
					((IfStmtContext)_localctx).fs = stmts();
					setState(597);
					match(T__4);
					}
				}

				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(601);
				match(T__110);
				setState(602);
				match(T__15);
				setState(603);
				exp(0);
				setState(604);
				match(T__16);
				setState(608);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(605);
					match(NL);
					}
					}
					setState(610);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(611);
				match(T__3);
				setState(622);
				switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
				case 1:
					{
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
					match(T__101);
					setState(619);
					loopInvariant();
					setState(620);
					match(T__102);
					}
					break;
				}
				setState(624);
				stmts();
				setState(625);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(627);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__111 || _la==T__112) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(628);
				match(T__15);
				setState(629);
				match(SSTRING);
				setState(630);
				match(T__16);
				}
				break;
			case 7:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(631);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(632);
				match(T__15);
				setState(633);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(634);
				match(T__16);
				setState(635);
				match(T__31);
				setState(637);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(636);
					match(NL);
					}
				}

				setState(639);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 8:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(641);
				match(T__104);
				setState(642);
				match(ID);
				setState(644);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(643);
					match(NL);
					}
				}

				setState(646);
				match(T__15);
				setState(655);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(647);
					param();
					setState(652);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(648);
						match(T__0);
						setState(649);
						param();
						}
						}
						setState(654);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(657);
				match(T__16);
				setState(658);
				match(T__6);
				setState(661);
				switch (_input.LA(1)) {
				case T__18:
				case T__19:
				case T__60:
					{
					setState(659);
					type();
					}
					break;
				case T__113:
					{
					setState(660);
					match(T__113);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(663);
				match(T__31);
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
				match(T__3);
				setState(687);
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
				case 1:
					{
					setState(674);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(671);
						match(NL);
						}
						}
						setState(676);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
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
					match(T__102);
					}
					break;
				}
				setState(689);
				stmts();
				setState(698);
				_la = _input.LA(1);
				if (_la==T__114) {
					{
					setState(690);
					((MethodDeclStmtContext)_localctx).rtb = match(T__114);
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
				match(T__101);
				setState(706);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(703);
					proof();
					}
					break;
				case 2:
					{
					setState(704);
					sequent();
					}
					break;
				case 3:
					{
					setState(705);
					invariants();
					}
					break;
				}
				setState(708);
				match(T__102);
				}
				break;
			case 10:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(710);
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(762);
			switch (_input.LA(1)) {
			case T__24:
			case T__36:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(714);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__36) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(715);
				exp(8);
				}
				break;
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
				{
				_localctx = new BooleanExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(716);
				((BooleanExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
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
				setState(717);
				match(NUM);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(718);
				((IdExpContext)_localctx).tb = match(ID);
				setState(733);
				switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
				case 1:
					{
					setState(719);
					match(T__15);
					setState(728);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & ((1L << (T__115 - 116)) | (1L << (NUM - 116)) | (1L << (ID - 116)))) != 0)) {
						{
						setState(720);
						exp(0);
						setState(725);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__0) {
							{
							{
							setState(721);
							match(T__0);
							setState(722);
							exp(0);
							}
							}
							setState(727);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(730);
					match(T__16);
					}
					break;
				case 2:
					{
					setState(731);
					match(T__5);
					setState(732);
					((IdExpContext)_localctx).te = match(ID);
					}
					break;
				}
				}
				break;
			case T__18:
				{
				_localctx = new BigIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(735);
				match(T__18);
				setState(736);
				match(T__15);
				setState(737);
				match(STRING);
				setState(738);
				match(T__16);
				}
				break;
			case T__19:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(739);
				match(T__19);
				setState(740);
				match(T__15);
				setState(749);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & ((1L << (T__115 - 116)) | (1L << (NUM - 116)) | (1L << (ID - 116)))) != 0)) {
					{
					setState(741);
					exp(0);
					setState(746);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(742);
						match(T__0);
						setState(743);
						exp(0);
						}
						}
						setState(748);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(751);
				match(T__16);
				}
				break;
			case T__115:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(752);
				match(T__115);
				setState(753);
				match(T__15);
				setState(755);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(754);
					match(STRING);
					}
				}

				setState(757);
				match(T__16);
				}
				break;
			case T__15:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(758);
				match(T__15);
				setState(759);
				exp(0);
				setState(760);
				match(T__16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(808);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(806);
					switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(764);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(765);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(767);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(766);
							match(NL);
							}
						}

						setState(769);
						((BinaryExpContext)_localctx).r = exp(8);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(770);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(771);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24 || _la==T__116) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(773);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(772);
							match(NL);
							}
						}

						setState(775);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(776);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(777);
						((BinaryExpContext)_localctx).op = match(T__116);
						setState(779);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(778);
							match(NL);
							}
						}

						setState(781);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(782);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(783);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__28) | (1L << T__29))) != 0)) ) {
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
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(788);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(789);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__32 || _la==T__33) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(791);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(790);
							match(NL);
							}
						}

						setState(793);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(794);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(795);
						((BinaryExpContext)_localctx).op = match(T__40);
						setState(797);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(796);
							match(NL);
							}
						}

						setState(799);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(800);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(801);
						((BinaryExpContext)_localctx).op = match(T__44);
						setState(803);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(802);
							match(NL);
							}
						}

						setState(805);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(810);
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
		enterRule(_localctx, 40, RULE_loopInvariant);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(811);
			((LoopInvariantContext)_localctx).tb = match(T__3);
			setState(815);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(812);
				match(NL);
				}
				}
				setState(817);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(818);
			((LoopInvariantContext)_localctx).itb = match(T__96);
			setState(822);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(819);
					match(NL);
					}
					} 
				}
				setState(824);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			}
			setState(826);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
				{
				setState(825);
				formula(0);
				}
			}

			setState(838);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(829); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(828);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(831); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(834);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
					{
					setState(833);
					formula(0);
					}
				}

				}
				}
				setState(840);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(841);
			modifies();
			setState(842);
			((LoopInvariantContext)_localctx).te = match(T__4);
			setState(846);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(843);
				match(NL);
				}
				}
				setState(848);
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
		enterRule(_localctx, 42, RULE_modifies);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(849);
			((ModifiesContext)_localctx).tb = match(T__117);
			setState(858);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(850);
				match(ID);
				setState(855);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(851);
					match(T__0);
					setState(852);
					match(ID);
					}
					}
					setState(857);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(863);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,123,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(860);
					match(NL);
					}
					} 
				}
				setState(865);
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
		enterRule(_localctx, 44, RULE_methodContract);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(866);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(870);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(867);
					match(NL);
					}
					} 
				}
				setState(872);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			}
			setState(894);
			_la = _input.LA(1);
			if (_la==T__118 || _la==T__119) {
				{
				setState(873);
				_la = _input.LA(1);
				if ( !(_la==T__118 || _la==T__119) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(877);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(874);
					match(NL);
					}
					}
					setState(879);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(880);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(891);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(882); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(881);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(884); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(887);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
							{
							setState(886);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(893);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
				}
				}
			}

			setState(899);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(896);
					match(NL);
					}
					} 
				}
				setState(901);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			}
			setState(903);
			_la = _input.LA(1);
			if (_la==T__117) {
				{
				setState(902);
				modifies();
				}
			}

			setState(926);
			_la = _input.LA(1);
			if (_la==T__120 || _la==T__121) {
				{
				setState(905);
				_la = _input.LA(1);
				if ( !(_la==T__120 || _la==T__121) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(909);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(906);
					match(NL);
					}
					}
					setState(911);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(912);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(923);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(914); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(913);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(916); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(919);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
							{
							setState(918);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(925);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
				}
				}
			}

			setState(931);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(928);
				match(NL);
				}
				}
				setState(933);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(934);
			((MethodContractContext)_localctx).te = match(T__4);
			setState(938);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(935);
					match(NL);
					}
					} 
				}
				setState(940);
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
		enterRule(_localctx, 46, RULE_invariants);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(941);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(945);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(942);
				match(NL);
				}
				}
				setState(947);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(948);
			match(T__96);
			setState(952);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(949);
					match(NL);
					}
					} 
				}
				setState(954);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			}
			setState(956);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
				{
				setState(955);
				formula(0);
				}
			}

			setState(968);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(959); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(958);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(961); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(964);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
					{
					setState(963);
					formula(0);
					}
				}

				}
				}
				setState(970);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(971);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(975);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(972);
				match(NL);
				}
				}
				setState(977);
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
		case 19:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0087\u03d5\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\7\2\65\n\2\f\2\16\28\13\2\3\2\5\2;\n\2\3\2\7\2>\n\2\f\2\16\2"+
		"A\13\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\7\5N\n\5\f\5\16\5Q"+
		"\13\5\5\5S\n\5\3\5\3\5\3\5\3\5\7\5Y\n\5\f\5\16\5\\\13\5\3\5\7\5_\n\5\f"+
		"\5\16\5b\13\5\3\5\3\5\6\5f\n\5\r\5\16\5g\5\5j\n\5\3\6\3\6\5\6n\n\6\3\6"+
		"\6\6q\n\6\r\6\16\6r\3\6\5\6v\n\6\7\6x\n\6\f\6\16\6{\13\6\3\6\3\6\7\6\177"+
		"\n\6\f\6\16\6\u0082\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u008c\n\7"+
		"\f\7\16\7\u008f\13\7\3\7\3\7\7\7\u0093\n\7\f\7\16\7\u0096\13\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7\u009d\n\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a5\n\7\3\7\3"+
		"\7\3\7\5\7\u00aa\n\7\3\7\6\7\u00ad\n\7\r\7\16\7\u00ae\3\7\5\7\u00b2\n"+
		"\7\7\7\u00b4\n\7\f\7\16\7\u00b7\13\7\3\7\5\7\u00ba\n\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b\u00c5\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\7\b\u00d1\n\b\f\b\16\b\u00d4\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\7\b\u00e2\n\b\f\b\16\b\u00e5\13\b\5\b\u00e7\n\b\3\b\3"+
		"\b\5\b\u00eb\n\b\3\b\3\b\3\b\5\b\u00f0\n\b\3\b\3\b\3\b\3\b\5\b\u00f6\n"+
		"\b\3\b\3\b\3\b\3\b\5\b\u00fc\n\b\3\b\3\b\3\b\3\b\5\b\u0102\n\b\3\b\3\b"+
		"\3\b\3\b\5\b\u0108\n\b\3\b\3\b\3\b\3\b\5\b\u010e\n\b\3\b\3\b\3\b\3\b\5"+
		"\b\u0114\n\b\3\b\7\b\u0117\n\b\f\b\16\b\u011a\13\b\3\t\3\t\3\t\3\t\7\t"+
		"\u0120\n\t\f\t\16\t\u0123\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u012c\n"+
		"\t\3\t\3\t\5\t\u0130\n\t\3\t\3\t\3\n\3\n\3\n\5\n\u0137\n\n\3\13\3\13\3"+
		"\13\3\13\5\13\u013d\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0144\n\13\3\13"+
		"\3\13\3\13\3\13\5\13\u014a\n\13\3\13\3\13\3\13\3\13\5\13\u0150\n\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u0158\n\13\3\13\3\13\3\13\3\13\5\13"+
		"\u015e\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0165\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u016c\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0173\n\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u017d\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u0185\n\13\3\13\3\13\6\13\u0189\n\13\r\13\16\13\u018a"+
		"\3\13\3\13\3\13\6\13\u0190\n\13\r\13\16\13\u0191\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\6\13\u019d\n\13\r\13\16\13\u019e\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u01a8\n\13\f\13\16\13\u01ab\13\13\3\13\3\13"+
		"\3\13\7\13\u01b0\n\13\f\13\16\13\u01b3\13\13\5\13\u01b5\n\13\3\f\3\f\3"+
		"\r\7\r\u01ba\n\r\f\r\16\r\u01bd\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\6\r\u01c8\n\r\r\r\16\r\u01c9\3\r\3\r\3\r\3\r\7\r\u01d0\n\r\f\r\16\r"+
		"\u01d3\13\r\5\r\u01d5\n\r\3\r\5\r\u01d8\n\r\3\16\3\16\7\16\u01dc\n\16"+
		"\f\16\16\16\u01df\13\16\3\16\3\16\7\16\u01e3\n\16\f\16\16\16\u01e6\13"+
		"\16\3\16\5\16\u01e9\n\16\3\16\6\16\u01ec\n\16\r\16\16\16\u01ed\3\16\5"+
		"\16\u01f1\n\16\7\16\u01f3\n\16\f\16\16\16\u01f6\13\16\3\16\3\16\7\16\u01fa"+
		"\n\16\f\16\16\16\u01fd\13\16\3\17\3\17\5\17\u0201\n\17\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\5\21\u020a\n\21\3\21\3\21\3\21\3\21\7\21\u0210\n"+
		"\21\f\21\16\21\u0213\13\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23"+
		"\5\23\u021e\n\23\3\23\6\23\u0221\n\23\r\23\16\23\u0222\3\23\5\23\u0226"+
		"\n\23\7\23\u0228\n\23\f\23\16\23\u022b\13\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u0233\n\24\3\24\3\24\3\24\3\24\3\24\5\24\u023a\n\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0247\n\24\f\24"+
		"\16\24\u024a\13\24\3\24\3\24\3\24\3\24\3\24\7\24\u0251\n\24\f\24\16\24"+
		"\u0254\13\24\3\24\3\24\3\24\3\24\5\24\u025a\n\24\3\24\3\24\3\24\3\24\3"+
		"\24\7\24\u0261\n\24\f\24\16\24\u0264\13\24\3\24\3\24\7\24\u0268\n\24\f"+
		"\24\16\24\u026b\13\24\3\24\3\24\3\24\3\24\5\24\u0271\n\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0280\n\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u0287\n\24\3\24\3\24\3\24\3\24\7\24\u028d"+
		"\n\24\f\24\16\24\u0290\13\24\5\24\u0292\n\24\3\24\3\24\3\24\3\24\5\24"+
		"\u0298\n\24\3\24\3\24\7\24\u029c\n\24\f\24\16\24\u029f\13\24\3\24\3\24"+
		"\7\24\u02a3\n\24\f\24\16\24\u02a6\13\24\3\24\3\24\3\24\7\24\u02ab\n\24"+
		"\f\24\16\24\u02ae\13\24\3\24\3\24\5\24\u02b2\n\24\3\24\3\24\3\24\3\24"+
		"\7\24\u02b8\n\24\f\24\16\24\u02bb\13\24\5\24\u02bd\n\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u02c5\n\24\3\24\3\24\3\24\5\24\u02ca\n\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u02d6\n\25\f\25\16\25"+
		"\u02d9\13\25\5\25\u02db\n\25\3\25\3\25\3\25\5\25\u02e0\n\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u02eb\n\25\f\25\16\25\u02ee\13"+
		"\25\5\25\u02f0\n\25\3\25\3\25\3\25\3\25\5\25\u02f6\n\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u02fd\n\25\3\25\3\25\3\25\5\25\u0302\n\25\3\25\3\25\3"+
		"\25\3\25\5\25\u0308\n\25\3\25\3\25\3\25\3\25\5\25\u030e\n\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0314\n\25\3\25\3\25\3\25\3\25\5\25\u031a\n\25\3\25\3"+
		"\25\3\25\3\25\5\25\u0320\n\25\3\25\3\25\3\25\3\25\5\25\u0326\n\25\3\25"+
		"\7\25\u0329\n\25\f\25\16\25\u032c\13\25\3\26\3\26\7\26\u0330\n\26\f\26"+
		"\16\26\u0333\13\26\3\26\3\26\7\26\u0337\n\26\f\26\16\26\u033a\13\26\3"+
		"\26\5\26\u033d\n\26\3\26\6\26\u0340\n\26\r\26\16\26\u0341\3\26\5\26\u0345"+
		"\n\26\7\26\u0347\n\26\f\26\16\26\u034a\13\26\3\26\3\26\3\26\7\26\u034f"+
		"\n\26\f\26\16\26\u0352\13\26\3\27\3\27\3\27\3\27\7\27\u0358\n\27\f\27"+
		"\16\27\u035b\13\27\5\27\u035d\n\27\3\27\7\27\u0360\n\27\f\27\16\27\u0363"+
		"\13\27\3\30\3\30\7\30\u0367\n\30\f\30\16\30\u036a\13\30\3\30\3\30\7\30"+
		"\u036e\n\30\f\30\16\30\u0371\13\30\3\30\3\30\6\30\u0375\n\30\r\30\16\30"+
		"\u0376\3\30\5\30\u037a\n\30\7\30\u037c\n\30\f\30\16\30\u037f\13\30\5\30"+
		"\u0381\n\30\3\30\7\30\u0384\n\30\f\30\16\30\u0387\13\30\3\30\5\30\u038a"+
		"\n\30\3\30\3\30\7\30\u038e\n\30\f\30\16\30\u0391\13\30\3\30\3\30\6\30"+
		"\u0395\n\30\r\30\16\30\u0396\3\30\5\30\u039a\n\30\7\30\u039c\n\30\f\30"+
		"\16\30\u039f\13\30\5\30\u03a1\n\30\3\30\7\30\u03a4\n\30\f\30\16\30\u03a7"+
		"\13\30\3\30\3\30\7\30\u03ab\n\30\f\30\16\30\u03ae\13\30\3\31\3\31\7\31"+
		"\u03b2\n\31\f\31\16\31\u03b5\13\31\3\31\3\31\7\31\u03b9\n\31\f\31\16\31"+
		"\u03bc\13\31\3\31\5\31\u03bf\n\31\3\31\6\31\u03c2\n\31\r\31\16\31\u03c3"+
		"\3\31\5\31\u03c7\n\31\7\31\u03c9\n\31\f\31\16\31\u03cc\13\31\3\31\3\31"+
		"\7\31\u03d0\n\31\f\31\16\31\u03d3\13\31\3\31\2\4\16(\32\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\2#\3\2\4\5\3\2&)\3\2\13\21\3\2\27"+
		"\31\3\2\32\33\3\2\34!\3\2\"%\3\2*-\3\2.\61\3\2\62\64\3\2\65<\3\2AB\4\2"+
		"++--\3\2CF\3\2GJ\4\2//\61\61\3\2KL\3\2\63\64\3\2OP\3\2\')\3\2ST\3\2\20"+
		"\21\3\2\\^\3\2_a\3\2~\177\3\2lm\3\2rs\4\2\33\33\'\'\4\2\32\33ww\4\2\34"+
		"\35\37 \3\2#$\3\2yz\3\2{|\u048b\2\62\3\2\2\2\4D\3\2\2\2\6G\3\2\2\2\bi"+
		"\3\2\2\2\nk\3\2\2\2\f\u00b9\3\2\2\2\16\u00ea\3\2\2\2\20\u011b\3\2\2\2"+
		"\22\u0136\3\2\2\2\24\u01b4\3\2\2\2\26\u01b6\3\2\2\2\30\u01bb\3\2\2\2\32"+
		"\u01d9\3\2\2\2\34\u0200\3\2\2\2\36\u0202\3\2\2\2 \u0206\3\2\2\2\"\u0218"+
		"\3\2\2\2$\u021d\3\2\2\2&\u02c9\3\2\2\2(\u02fc\3\2\2\2*\u032d\3\2\2\2,"+
		"\u0353\3\2\2\2.\u0364\3\2\2\2\60\u03af\3\2\2\2\62\66\5\b\5\2\63\65\7\u0083"+
		"\2\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67:\3\2\2\2"+
		"8\66\3\2\2\29;\5\n\6\2:9\3\2\2\2:;\3\2\2\2;?\3\2\2\2<>\7\u0083\2\2=<\3"+
		"\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\7\2\2\3C\3"+
		"\3\2\2\2DE\5\n\6\2EF\7\2\2\3F\5\3\2\2\2GH\5\30\r\2HI\7\2\2\3I\7\3\2\2"+
		"\2JO\5\16\b\2KL\7\3\2\2LN\5\16\b\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2"+
		"\2\2PS\3\2\2\2QO\3\2\2\2RJ\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\t\2\2\2UZ\5\16"+
		"\b\2VW\7\3\2\2WY\5\16\b\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[j\3"+
		"\2\2\2\\Z\3\2\2\2]_\5\16\b\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a"+
		"c\3\2\2\2b`\3\2\2\2ce\7}\2\2df\5\16\b\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2"+
		"gh\3\2\2\2hj\3\2\2\2iR\3\2\2\2i`\3\2\2\2j\t\3\2\2\2km\7\6\2\2ln\5\f\7"+
		"\2ml\3\2\2\2mn\3\2\2\2ny\3\2\2\2oq\7\u0083\2\2po\3\2\2\2qr\3\2\2\2rp\3"+
		"\2\2\2rs\3\2\2\2su\3\2\2\2tv\5\f\7\2ut\3\2\2\2uv\3\2\2\2vx\3\2\2\2wp\3"+
		"\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3\2\2\2|\u0080\7\7\2"+
		"\2}\177\7\u0083\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\13\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7~\2\2\u0084"+
		"\u0085\7\b\2\2\u0085\u0086\5\16\b\2\u0086\u0087\5\24\13\2\u0087\u00ba"+
		"\3\2\2\2\u0088\u0089\7~\2\2\u0089\u008d\7\b\2\2\u008a\u008c\7\u0083\2"+
		"\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0094\7\6\2\2\u0091"+
		"\u0093\7\u0083\2\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097"+
		"\u0098\7~\2\2\u0098\u00a9\7\b\2\2\u0099\u009c\7\177\2\2\u009a\u009b\7"+
		"\t\2\2\u009b\u009d\5\22\n\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u00aa\3\2\2\2\u009e\u009f\5\16\b\2\u009f\u00a0\7\n\2\2\u00a0\u00aa\3"+
		"\2\2\2\u00a1\u00a4\7\177\2\2\u00a2\u00a3\7\t\2\2\u00a3\u00a5\5\22\n\2"+
		"\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7"+
		"\5\16\b\2\u00a7\u00a8\7\n\2\2\u00a8\u00aa\3\2\2\2\u00a9\u0099\3\2\2\2"+
		"\u00a9\u009e\3\2\2\2\u00a9\u00a1\3\2\2\2\u00aa\u00b5\3\2\2\2\u00ab\u00ad"+
		"\7\u0083\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2\2"+
		"\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00b2\5\f\7\2\u00b1\u00b0"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00ac\3\2\2\2\u00b4"+
		"\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00ba\7\7\2\2\u00b9\u0083\3\2\2\2\u00b9"+
		"\u0088\3\2\2\2\u00ba\r\3\2\2\2\u00bb\u00bc\b\b\1\2\u00bc\u00bd\7\33\2"+
		"\2\u00bd\u00eb\5\16\b\b\u00be\u00bf\t\3\2\2\u00bf\u00eb\5\16\b\7\u00c0"+
		"\u00eb\t\4\2\2\u00c1\u00c4\7\177\2\2\u00c2\u00c3\7\b\2\2\u00c3\u00c5\7"+
		"\177\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00eb\3\2\2\2\u00c6"+
		"\u00c7\7\22\2\2\u00c7\u00c8\5\16\b\2\u00c8\u00c9\7\23\2\2\u00c9\u00eb"+
		"\3\2\2\2\u00ca\u00eb\7\24\2\2\u00cb\u00cc\7\177\2\2\u00cc\u00cd\7\22\2"+
		"\2\u00cd\u00d2\5\16\b\2\u00ce\u00cf\7\3\2\2\u00cf\u00d1\5\16\b\2\u00d0"+
		"\u00ce\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7\23\2\2\u00d6"+
		"\u00eb\3\2\2\2\u00d7\u00eb\7~\2\2\u00d8\u00d9\7\25\2\2\u00d9\u00da\7\22"+
		"\2\2\u00da\u00db\7\u0081\2\2\u00db\u00eb\7\23\2\2\u00dc\u00dd\7\26\2\2"+
		"\u00dd\u00e6\7\22\2\2\u00de\u00e3\5(\25\2\u00df\u00e0\7\3\2\2\u00e0\u00e2"+
		"\5(\25\2\u00e1\u00df\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3"+
		"\u00e4\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00de\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00eb\7\23\2\2\u00e9"+
		"\u00eb\5\20\t\2\u00ea\u00bb\3\2\2\2\u00ea\u00be\3\2\2\2\u00ea\u00c0\3"+
		"\2\2\2\u00ea\u00c1\3\2\2\2\u00ea\u00c6\3\2\2\2\u00ea\u00ca\3\2\2\2\u00ea"+
		"\u00cb\3\2\2\2\u00ea\u00d7\3\2\2\2\u00ea\u00d8\3\2\2\2\u00ea\u00dc\3\2"+
		"\2\2\u00ea\u00e9\3\2\2\2\u00eb\u0118\3\2\2\2\u00ec\u00ed\f\f\2\2\u00ed"+
		"\u00ef\t\5\2\2\u00ee\u00f0\7\u0083\2\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0"+
		"\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u0117\5\16\b\r\u00f2\u00f3\f\13\2\2"+
		"\u00f3\u00f5\t\6\2\2\u00f4\u00f6\7\u0083\2\2\u00f5\u00f4\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u0117\5\16\b\f\u00f8\u00f9\f"+
		"\n\2\2\u00f9\u00fb\t\7\2\2\u00fa\u00fc\7\u0083\2\2\u00fb\u00fa\3\2\2\2"+
		"\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u0117\5\16\b\13\u00fe\u00ff"+
		"\f\t\2\2\u00ff\u0101\t\b\2\2\u0100\u0102\7\u0083\2\2\u0101\u0100\3\2\2"+
		"\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0117\5\16\b\n\u0104"+
		"\u0105\f\6\2\2\u0105\u0107\t\t\2\2\u0106\u0108\7\u0083\2\2\u0107\u0106"+
		"\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u0117\5\16\b\7"+
		"\u010a\u010b\f\5\2\2\u010b\u010d\t\n\2\2\u010c\u010e\7\u0083\2\2\u010d"+
		"\u010c\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0117\5\16"+
		"\b\6\u0110\u0111\f\4\2\2\u0111\u0113\t\13\2\2\u0112\u0114\7\u0083\2\2"+
		"\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117"+
		"\5\16\b\5\u0116\u00ec\3\2\2\2\u0116\u00f2\3\2\2\2\u0116\u00f8\3\2\2\2"+
		"\u0116\u00fe\3\2\2\2\u0116\u0104\3\2\2\2\u0116\u010a\3\2\2\2\u0116\u0110"+
		"\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\17\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c\t\f\2\2\u011c\u0121\7\177"+
		"\2\2\u011d\u011e\7\3\2\2\u011e\u0120\7\177\2\2\u011f\u011d\3\2\2\2\u0120"+
		"\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u012b\3\2"+
		"\2\2\u0123\u0121\3\2\2\2\u0124\u0125\7\t\2\2\u0125\u012c\5\22\n\2\u0126"+
		"\u0127\7\t\2\2\u0127\u0128\5(\25\2\u0128\u0129\7=\2\2\u0129\u012a\5(\25"+
		"\2\u012a\u012c\3\2\2\2\u012b\u0124\3\2\2\2\u012b\u0126\3\2\2\2\u012b\u012c"+
		"\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012f\7>\2\2\u012e\u0130\7\u0083\2"+
		"\2\u012f\u012e\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132"+
		"\5\16\b\2\u0132\21\3\2\2\2\u0133\u0137\7?\2\2\u0134\u0137\7\25\2\2\u0135"+
		"\u0137\7\26\2\2\u0136\u0133\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0135\3"+
		"\2\2\2\u0137\23\3\2\2\2\u0138\u01b5\7@\2\2\u0139\u013d\t\r\2\2\u013a\u013b"+
		"\t\16\2\2\u013b\u013d\7\177\2\2\u013c\u0139\3\2\2\2\u013c\u013a\3\2\2"+
		"\2\u013d\u013e\3\2\2\2\u013e\u013f\7~\2\2\u013f\u01b5\7~\2\2\u0140\u0144"+
		"\t\17\2\2\u0141\u0142\t\16\2\2\u0142\u0144\7\177\2\2\u0143\u0140\3\2\2"+
		"\2\u0143\u0141\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u01b5\7~\2\2\u0146\u014a"+
		"\t\20\2\2\u0147\u0148\t\21\2\2\u0148\u014a\7\177\2\2\u0149\u0146\3\2\2"+
		"\2\u0149\u0147\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u01b5\7~\2\2\u014c\u0150"+
		"\t\22\2\2\u014d\u014e\t\21\2\2\u014e\u0150\7\177\2\2\u014f\u014c\3\2\2"+
		"\2\u014f\u014d\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152\7~\2\2\u0152\u0153"+
		"\7~\2\2\u0153\u01b5\7~\2\2\u0154\u0158\7M\2\2\u0155\u0156\t\23\2\2\u0156"+
		"\u0158\7\177\2\2\u0157\u0154\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0159\3"+
		"\2\2\2\u0159\u01b5\7~\2\2\u015a\u015e\7N\2\2\u015b\u015c\t\23\2\2\u015c"+
		"\u015e\7\177\2\2\u015d\u015a\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f\3"+
		"\2\2\2\u015f\u0160\7~\2\2\u0160\u01b5\7~\2\2\u0161\u0165\t\24\2\2\u0162"+
		"\u0163\t\25\2\2\u0163\u0165\7\177\2\2\u0164\u0161\3\2\2\2\u0164\u0162"+
		"\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u01b5\7~\2\2\u0167\u016c\7Q\2\2\u0168"+
		"\u016c\7R\2\2\u0169\u016a\t\25\2\2\u016a\u016c\7\177\2\2\u016b\u0167\3"+
		"\2\2\2\u016b\u0168\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		"\u016e\7~\2\2\u016e\u01b5\7~\2\2\u016f\u0173\t\26\2\2\u0170\u0171\t\27"+
		"\2\2\u0171\u0173\7\177\2\2\u0172\u016f\3\2\2\2\u0172\u0170\3\2\2\2\u0173"+
		"\u0174\3\2\2\2\u0174\u01b5\7~\2\2\u0175\u0176\7U\2\2\u0176\u01b5\7~\2"+
		"\2\u0177\u017d\7V\2\2\u0178\u017d\7W\2\2\u0179\u017d\7X\2\2\u017a\u017b"+
		"\78\2\2\u017b\u017d\7\177\2\2\u017c\u0177\3\2\2\2\u017c\u0178\3\2\2\2"+
		"\u017c\u0179\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u01b5"+
		"\7~\2\2\u017f\u0185\7Y\2\2\u0180\u0185\7Z\2\2\u0181\u0185\7[\2\2\u0182"+
		"\u0183\78\2\2\u0183\u0185\7\177\2\2\u0184\u017f\3\2\2\2\u0184\u0180\3"+
		"\2\2\2\u0184\u0181\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u0186\3\2\2\2\u0186"+
		"\u0188\5\26\f\2\u0187\u0189\5\16\b\2\u0188\u0187\3\2\2\2\u0189\u018a\3"+
		"\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u01b5\3\2\2\2\u018c"+
		"\u018d\t\30\2\2\u018d\u018f\7~\2\2\u018e\u0190\5\16\b\2\u018f\u018e\3"+
		"\2\2\2\u0190\u0191\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192"+
		"\u01b5\3\2\2\2\u0193\u0194\t\31\2\2\u0194\u0195\5\26\f\2\u0195\u0196\7"+
		"~\2\2\u0196\u01b5\3\2\2\2\u0197\u0198\6\13\t\2\u0198\u0199\7<\2\2\u0199"+
		"\u019a\7\177\2\2\u019a\u019c\7~\2\2\u019b\u019d\5\16\b\2\u019c\u019b\3"+
		"\2\2\2\u019d\u019e\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f"+
		"\u01b5\3\2\2\2\u01a0\u01a1\7<\2\2\u01a1\u01a2\7\177\2\2\u01a2\u01a3\5"+
		"\26\f\2\u01a3\u01a4\7~\2\2\u01a4\u01b5\3\2\2\2\u01a5\u01a9\7b\2\2\u01a6"+
		"\u01a8\5\26\f\2\u01a7\u01a6\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7\3"+
		"\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01b5\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac"+
		"\u01b5\7c\2\2\u01ad\u01b1\7d\2\2\u01ae\u01b0\5\26\f\2\u01af\u01ae\3\2"+
		"\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2"+
		"\u01b5\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u0138\3\2\2\2\u01b4\u013c\3\2"+
		"\2\2\u01b4\u0143\3\2\2\2\u01b4\u0149\3\2\2\2\u01b4\u014f\3\2\2\2\u01b4"+
		"\u0157\3\2\2\2\u01b4\u015d\3\2\2\2\u01b4\u0164\3\2\2\2\u01b4\u016b\3\2"+
		"\2\2\u01b4\u0172\3\2\2\2\u01b4\u0175\3\2\2\2\u01b4\u017c\3\2\2\2\u01b4"+
		"\u0184\3\2\2\2\u01b4\u018c\3\2\2\2\u01b4\u0193\3\2\2\2\u01b4\u0197\3\2"+
		"\2\2\u01b4\u01a0\3\2\2\2\u01b4\u01a5\3\2\2\2\u01b4\u01ac\3\2\2\2\u01b4"+
		"\u01ad\3\2\2\2\u01b5\25\3\2\2\2\u01b6\u01b7\t\32\2\2\u01b7\27\3\2\2\2"+
		"\u01b8\u01ba\7\u0083\2\2\u01b9\u01b8\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb"+
		"\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01d7\3\2\2\2\u01bd\u01bb\3\2"+
		"\2\2\u01be\u01bf\7e\2\2\u01bf\u01c0\7\177\2\2\u01c0\u01c1\7\b\2\2\u01c1"+
		"\u01c2\7\177\2\2\u01c2\u01c3\7\b\2\2\u01c3\u01c4\7f\2\2\u01c4\u01c5\7"+
		"\b\2\2\u01c5\u01c7\7g\2\2\u01c6\u01c8\7\u0083\2\2\u01c7\u01c6\3\2\2\2"+
		"\u01c8\u01c9\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01d4"+
		"\3\2\2\2\u01cb\u01cc\7h\2\2\u01cc\u01cd\5\32\16\2\u01cd\u01d1\7i\2\2\u01ce"+
		"\u01d0\7\u0083\2\2\u01cf\u01ce\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01cf"+
		"\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d4"+
		"\u01cb\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d8\5$"+
		"\23\2\u01d7\u01be\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\31\3\2\2\2\u01d9\u01dd"+
		"\7\6\2\2\u01da\u01dc\7\u0083\2\2\u01db\u01da\3\2\2\2\u01dc\u01df\3\2\2"+
		"\2\u01dd\u01db\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01e0\3\2\2\2\u01df\u01dd"+
		"\3\2\2\2\u01e0\u01e4\7j\2\2\u01e1\u01e3\7\u0083\2\2\u01e2\u01e1\3\2\2"+
		"\2\u01e3\u01e6\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e8"+
		"\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e7\u01e9\5\34\17\2\u01e8\u01e7\3\2\2\2"+
		"\u01e8\u01e9\3\2\2\2\u01e9\u01f4\3\2\2\2\u01ea\u01ec\7\u0083\2\2\u01eb"+
		"\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2"+
		"\2\2\u01ee\u01f0\3\2\2\2\u01ef\u01f1\5\34\17\2\u01f0\u01ef\3\2\2\2\u01f0"+
		"\u01f1\3\2\2\2\u01f1\u01f3\3\2\2\2\u01f2\u01eb\3\2\2\2\u01f3\u01f6\3\2"+
		"\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f7\3\2\2\2\u01f6"+
		"\u01f4\3\2\2\2\u01f7\u01fb\7\7\2\2\u01f8\u01fa\7\u0083\2\2\u01f9\u01f8"+
		"\3\2\2\2\u01fa\u01fd\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc"+
		"\33\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fe\u0201\5\36\20\2\u01ff\u0201\5 \21"+
		"\2\u0200\u01fe\3\2\2\2\u0200\u01ff\3\2\2\2\u0201\35\3\2\2\2\u0202\u0203"+
		"\7\177\2\2\u0203\u0204\7\b\2\2\u0204\u0205\5\16\b\2\u0205\37\3\2\2\2\u0206"+
		"\u0207\7k\2\2\u0207\u0209\7\177\2\2\u0208\u020a\7\u0083\2\2\u0209\u0208"+
		"\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020c\7\22\2\2"+
		"\u020c\u0211\5\"\22\2\u020d\u020e\7\3\2\2\u020e\u0210\5\"\22\2\u020f\u020d"+
		"\3\2\2\2\u0210\u0213\3\2\2\2\u0211\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212"+
		"\u0214\3\2\2\2\u0213\u0211\3\2\2\2\u0214\u0215\7\23\2\2\u0215\u0216\7"+
		"\t\2\2\u0216\u0217\5\22\n\2\u0217!\3\2\2\2\u0218\u0219\7\177\2\2\u0219"+
		"\u021a\7\t\2\2\u021a\u021b\5\22\n\2\u021b#\3\2\2\2\u021c\u021e\5&\24\2"+
		"\u021d\u021c\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u0229\3\2\2\2\u021f\u0221"+
		"\7\u0083\2\2\u0220\u021f\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0220\3\2\2"+
		"\2\u0222\u0223\3\2\2\2\u0223\u0225\3\2\2\2\u0224\u0226\5&\24\2\u0225\u0224"+
		"\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0228\3\2\2\2\u0227\u0220\3\2\2\2\u0228"+
		"\u022b\3\2\2\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a%\3\2\2\2"+
		"\u022b\u0229\3\2\2\2\u022c\u022d\t\33\2\2\u022d\u022e\7\177\2\2\u022e"+
		"\u022f\7\t\2\2\u022f\u0230\5\22\n\2\u0230\u0232\7\"\2\2\u0231\u0233\7"+
		"\u0083\2\2\u0232\u0231\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0234\3\2\2\2"+
		"\u0234\u0235\5(\25\2\u0235\u02ca\3\2\2\2\u0236\u0237\7\177\2\2\u0237\u0239"+
		"\7\"\2\2\u0238\u023a\7\u0083\2\2\u0239\u0238\3\2\2\2\u0239\u023a\3\2\2"+
		"\2\u023a\u023b\3\2\2\2\u023b\u02ca\5(\25\2\u023c\u023d\7n\2\2\u023d\u023e"+
		"\7\22\2\2\u023e\u023f\5(\25\2\u023f\u0240\7\23\2\2\u0240\u02ca\3\2\2\2"+
		"\u0241\u0242\7o\2\2\u0242\u0243\7\22\2\2\u0243\u0244\5(\25\2\u0244\u0248"+
		"\7\23\2\2\u0245\u0247\7\u0083\2\2\u0246\u0245\3\2\2\2\u0247\u024a\3\2"+
		"\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024b\3\2\2\2\u024a"+
		"\u0248\3\2\2\2\u024b\u024c\7\6\2\2\u024c\u024d\5$\23\2\u024d\u0259\7\7"+
		"\2\2\u024e\u0252\7p\2\2\u024f\u0251\7\u0083\2\2\u0250\u024f\3\2\2\2\u0251"+
		"\u0254\3\2\2\2\u0252\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0255\3\2"+
		"\2\2\u0254\u0252\3\2\2\2\u0255\u0256\7\6\2\2\u0256\u0257\5$\23\2\u0257"+
		"\u0258\7\7\2\2\u0258\u025a\3\2\2\2\u0259\u024e\3\2\2\2\u0259\u025a\3\2"+
		"\2\2\u025a\u02ca\3\2\2\2\u025b\u025c\7q\2\2\u025c\u025d\7\22\2\2\u025d"+
		"\u025e\5(\25\2\u025e\u0262\7\23\2\2\u025f\u0261\7\u0083\2\2\u0260\u025f"+
		"\3\2\2\2\u0261\u0264\3\2\2\2\u0262\u0260\3\2\2\2\u0262\u0263\3\2\2\2\u0263"+
		"\u0265\3\2\2\2\u0264\u0262\3\2\2\2\u0265\u0270\7\6\2\2\u0266\u0268\7\u0083"+
		"\2\2\u0267\u0266\3\2\2\2\u0268\u026b\3\2\2\2\u0269\u0267\3\2\2\2\u0269"+
		"\u026a\3\2\2\2\u026a\u026c\3\2\2\2\u026b\u0269\3\2\2\2\u026c\u026d\7h"+
		"\2\2\u026d\u026e\5*\26\2\u026e\u026f\7i\2\2\u026f\u0271\3\2\2\2\u0270"+
		"\u0269\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0273\5$"+
		"\23\2\u0273\u0274\7\7\2\2\u0274\u02ca\3\2\2\2\u0275\u0276\t\34\2\2\u0276"+
		"\u0277\7\22\2\2\u0277\u0278\7\u0080\2\2\u0278\u02ca\7\23\2\2\u0279\u027a"+
		"\7\177\2\2\u027a\u027b\7\22\2\2\u027b\u027c\5(\25\2\u027c\u027d\7\23\2"+
		"\2\u027d\u027f\7\"\2\2\u027e\u0280\7\u0083\2\2\u027f\u027e\3\2\2\2\u027f"+
		"\u0280\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0282\5(\25\2\u0282\u02ca\3\2"+
		"\2\2\u0283\u0284\7k\2\2\u0284\u0286\7\177\2\2\u0285\u0287\7\u0083\2\2"+
		"\u0286\u0285\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u0291"+
		"\7\22\2\2\u0289\u028e\5\"\22\2\u028a\u028b\7\3\2\2\u028b\u028d\5\"\22"+
		"\2\u028c\u028a\3\2\2\2\u028d\u0290\3\2\2\2\u028e\u028c\3\2\2\2\u028e\u028f"+
		"\3\2\2\2\u028f\u0292\3\2\2\2\u0290\u028e\3\2\2\2\u0291\u0289\3\2\2\2\u0291"+
		"\u0292\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0294\7\23\2\2\u0294\u0297\7"+
		"\t\2\2\u0295\u0298\5\22\n\2\u0296\u0298\7t\2\2\u0297\u0295\3\2\2\2\u0297"+
		"\u0296\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u029d\7\"\2\2\u029a\u029c\7\u0083"+
		"\2\2\u029b\u029a\3\2\2\2\u029c\u029f\3\2\2\2\u029d\u029b\3\2\2\2\u029d"+
		"\u029e\3\2\2\2\u029e\u02a0\3\2\2\2\u029f\u029d\3\2\2\2\u02a0\u02b1\7\6"+
		"\2\2\u02a1\u02a3\7\u0083\2\2\u02a2\u02a1\3\2\2\2\u02a3\u02a6\3\2\2\2\u02a4"+
		"\u02a2\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a7\3\2\2\2\u02a6\u02a4\3\2"+
		"\2\2\u02a7\u02a8\7h\2\2\u02a8\u02ac\5.\30\2\u02a9\u02ab\7\u0083\2\2\u02aa"+
		"\u02a9\3\2\2\2\u02ab\u02ae\3\2\2\2\u02ac\u02aa\3\2\2\2\u02ac\u02ad\3\2"+
		"\2\2\u02ad\u02af\3\2\2\2\u02ae\u02ac\3\2\2\2\u02af\u02b0\7i\2\2\u02b0"+
		"\u02b2\3\2\2\2\u02b1\u02a4\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b3\3\2"+
		"\2\2\u02b3\u02bc\5$\23\2\u02b4\u02b5\7u\2\2\u02b5\u02b9\5(\25\2\u02b6"+
		"\u02b8\7\u0083\2\2\u02b7\u02b6\3\2\2\2\u02b8\u02bb\3\2\2\2\u02b9\u02b7"+
		"\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02bd\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bc"+
		"\u02b4\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02bf\7\7"+
		"\2\2\u02bf\u02ca\3\2\2\2\u02c0\u02c4\7h\2\2\u02c1\u02c5\5\n\6\2\u02c2"+
		"\u02c5\5\b\5\2\u02c3\u02c5\5\60\31\2\u02c4\u02c1\3\2\2\2\u02c4\u02c2\3"+
		"\2\2\2\u02c4\u02c3\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6\u02c7\7i\2\2\u02c7"+
		"\u02ca\3\2\2\2\u02c8\u02ca\5(\25\2\u02c9\u022c\3\2\2\2\u02c9\u0236\3\2"+
		"\2\2\u02c9\u023c\3\2\2\2\u02c9\u0241\3\2\2\2\u02c9\u025b\3\2\2\2\u02c9"+
		"\u0275\3\2\2\2\u02c9\u0279\3\2\2\2\u02c9\u0283\3\2\2\2\u02c9\u02c0\3\2"+
		"\2\2\u02c9\u02c8\3\2\2\2\u02ca\'\3\2\2\2\u02cb\u02cc\b\25\1\2\u02cc\u02cd"+
		"\t\35\2\2\u02cd\u02fd\5(\25\n\u02ce\u02fd\t\4\2\2\u02cf\u02fd\7~\2\2\u02d0"+
		"\u02df\7\177\2\2\u02d1\u02da\7\22\2\2\u02d2\u02d7\5(\25\2\u02d3\u02d4"+
		"\7\3\2\2\u02d4\u02d6\5(\25\2\u02d5\u02d3\3\2\2\2\u02d6\u02d9\3\2\2\2\u02d7"+
		"\u02d5\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02db\3\2\2\2\u02d9\u02d7\3\2"+
		"\2\2\u02da\u02d2\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc"+
		"\u02e0\7\23\2\2\u02dd\u02de\7\b\2\2\u02de\u02e0\7\177\2\2\u02df\u02d1"+
		"\3\2\2\2\u02df\u02dd\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0\u02fd\3\2\2\2\u02e1"+
		"\u02e2\7\25\2\2\u02e2\u02e3\7\22\2\2\u02e3\u02e4\7\u0081\2\2\u02e4\u02fd"+
		"\7\23\2\2\u02e5\u02e6\7\26\2\2\u02e6\u02ef\7\22\2\2\u02e7\u02ec\5(\25"+
		"\2\u02e8\u02e9\7\3\2\2\u02e9\u02eb\5(\25\2\u02ea\u02e8\3\2\2\2\u02eb\u02ee"+
		"\3\2\2\2\u02ec\u02ea\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u02f0\3\2\2\2\u02ee"+
		"\u02ec\3\2\2\2\u02ef\u02e7\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0\u02f1\3\2"+
		"\2\2\u02f1\u02fd\7\23\2\2\u02f2\u02f3\7v\2\2\u02f3\u02f5\7\22\2\2\u02f4"+
		"\u02f6\7\u0081\2\2\u02f5\u02f4\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u02f7"+
		"\3\2\2\2\u02f7\u02fd\7\23\2\2\u02f8\u02f9\7\22\2\2\u02f9\u02fa\5(\25\2"+
		"\u02fa\u02fb\7\23\2\2\u02fb\u02fd\3\2\2\2\u02fc\u02cb\3\2\2\2\u02fc\u02ce"+
		"\3\2\2\2\u02fc\u02cf\3\2\2\2\u02fc\u02d0\3\2\2\2\u02fc\u02e1\3\2\2\2\u02fc"+
		"\u02e5\3\2\2\2\u02fc\u02f2\3\2\2\2\u02fc\u02f8\3\2\2\2\u02fd\u032a\3\2"+
		"\2\2\u02fe\u02ff\f\t\2\2\u02ff\u0301\t\5\2\2\u0300\u0302\7\u0083\2\2\u0301"+
		"\u0300\3\2\2\2\u0301\u0302\3\2\2\2\u0302\u0303\3\2\2\2\u0303\u0329\5("+
		"\25\n\u0304\u0305\f\b\2\2\u0305\u0307\t\36\2\2\u0306\u0308\7\u0083\2\2"+
		"\u0307\u0306\3\2\2\2\u0307\u0308\3\2\2\2\u0308\u0309\3\2\2\2\u0309\u0329"+
		"\5(\25\t\u030a\u030b\f\7\2\2\u030b\u030d\7w\2\2\u030c\u030e\7\u0083\2"+
		"\2\u030d\u030c\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u0329"+
		"\5(\25\b\u0310\u0311\f\6\2\2\u0311\u0313\t\37\2\2\u0312\u0314\7\u0083"+
		"\2\2\u0313\u0312\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0315\3\2\2\2\u0315"+
		"\u0329\5(\25\7\u0316\u0317\f\5\2\2\u0317\u0319\t \2\2\u0318\u031a\7\u0083"+
		"\2\2\u0319\u0318\3\2\2\2\u0319\u031a\3\2\2\2\u031a\u031b\3\2\2\2\u031b"+
		"\u0329\5(\25\6\u031c\u031d\f\4\2\2\u031d\u031f\7+\2\2\u031e\u0320\7\u0083"+
		"\2\2\u031f\u031e\3\2\2\2\u031f\u0320\3\2\2\2\u0320\u0321\3\2\2\2\u0321"+
		"\u0329\5(\25\5\u0322\u0323\f\3\2\2\u0323\u0325\7/\2\2\u0324\u0326\7\u0083"+
		"\2\2\u0325\u0324\3\2\2\2\u0325\u0326\3\2\2\2\u0326\u0327\3\2\2\2\u0327"+
		"\u0329\5(\25\4\u0328\u02fe\3\2\2\2\u0328\u0304\3\2\2\2\u0328\u030a\3\2"+
		"\2\2\u0328\u0310\3\2\2\2\u0328\u0316\3\2\2\2\u0328\u031c\3\2\2\2\u0328"+
		"\u0322\3\2\2\2\u0329\u032c\3\2\2\2\u032a\u0328\3\2\2\2\u032a\u032b\3\2"+
		"\2\2\u032b)\3\2\2\2\u032c\u032a\3\2\2\2\u032d\u0331\7\6\2\2\u032e\u0330"+
		"\7\u0083\2\2\u032f\u032e\3\2\2\2\u0330\u0333\3\2\2\2\u0331\u032f\3\2\2"+
		"\2\u0331\u0332\3\2\2\2\u0332\u0334\3\2\2\2\u0333\u0331\3\2\2\2\u0334\u0338"+
		"\7c\2\2\u0335\u0337\7\u0083\2\2\u0336\u0335\3\2\2\2\u0337\u033a\3\2\2"+
		"\2\u0338\u0336\3\2\2\2\u0338\u0339\3\2\2\2\u0339\u033c\3\2\2\2\u033a\u0338"+
		"\3\2\2\2\u033b\u033d\5\16\b\2\u033c\u033b\3\2\2\2\u033c\u033d\3\2\2\2"+
		"\u033d\u0348\3\2\2\2\u033e\u0340\7\u0083\2\2\u033f\u033e\3\2\2\2\u0340"+
		"\u0341\3\2\2\2\u0341\u033f\3\2\2\2\u0341\u0342\3\2\2\2\u0342\u0344\3\2"+
		"\2\2\u0343\u0345\5\16\b\2\u0344\u0343\3\2\2\2\u0344\u0345\3\2\2\2\u0345"+
		"\u0347\3\2\2\2\u0346\u033f\3\2\2\2\u0347\u034a\3\2\2\2\u0348\u0346\3\2"+
		"\2\2\u0348\u0349\3\2\2\2\u0349\u034b\3\2\2\2\u034a\u0348\3\2\2\2\u034b"+
		"\u034c\5,\27\2\u034c\u0350\7\7\2\2\u034d\u034f\7\u0083\2\2\u034e\u034d"+
		"\3\2\2\2\u034f\u0352\3\2\2\2\u0350\u034e\3\2\2\2\u0350\u0351\3\2\2\2\u0351"+
		"+\3\2\2\2\u0352\u0350\3\2\2\2\u0353\u035c\7x\2\2\u0354\u0359\7\177\2\2"+
		"\u0355\u0356\7\3\2\2\u0356\u0358\7\177\2\2\u0357\u0355\3\2\2\2\u0358\u035b"+
		"\3\2\2\2\u0359\u0357\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u035d\3\2\2\2\u035b"+
		"\u0359\3\2\2\2\u035c\u0354\3\2\2\2\u035c\u035d\3\2\2\2\u035d\u0361\3\2"+
		"\2\2\u035e\u0360\7\u0083\2\2\u035f\u035e\3\2\2\2\u0360\u0363\3\2\2\2\u0361"+
		"\u035f\3\2\2\2\u0361\u0362\3\2\2\2\u0362-\3\2\2\2\u0363\u0361\3\2\2\2"+
		"\u0364\u0368\7\6\2\2\u0365\u0367\7\u0083\2\2\u0366\u0365\3\2\2\2\u0367"+
		"\u036a\3\2\2\2\u0368\u0366\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u0380\3\2"+
		"\2\2\u036a\u0368\3\2\2\2\u036b\u036f\t!\2\2\u036c\u036e\7\u0083\2\2\u036d"+
		"\u036c\3\2\2\2\u036e\u0371\3\2\2\2\u036f\u036d\3\2\2\2\u036f\u0370\3\2"+
		"\2\2\u0370\u0372\3\2\2\2\u0371\u036f\3\2\2\2\u0372\u037d\5\16\b\2\u0373"+
		"\u0375\7\u0083\2\2\u0374\u0373\3\2\2\2\u0375\u0376\3\2\2\2\u0376\u0374"+
		"\3\2\2\2\u0376\u0377\3\2\2\2\u0377\u0379\3\2\2\2\u0378\u037a\5\16\b\2"+
		"\u0379\u0378\3\2\2\2\u0379\u037a\3\2\2\2\u037a\u037c\3\2\2\2\u037b\u0374"+
		"\3\2\2\2\u037c\u037f\3\2\2\2\u037d\u037b\3\2\2\2\u037d\u037e\3\2\2\2\u037e"+
		"\u0381\3\2\2\2\u037f\u037d\3\2\2\2\u0380\u036b\3\2\2\2\u0380\u0381\3\2"+
		"\2\2\u0381\u0385\3\2\2\2\u0382\u0384\7\u0083\2\2\u0383\u0382\3\2\2\2\u0384"+
		"\u0387\3\2\2\2\u0385\u0383\3\2\2\2\u0385\u0386\3\2\2\2\u0386\u0389\3\2"+
		"\2\2\u0387\u0385\3\2\2\2\u0388\u038a\5,\27\2\u0389\u0388\3\2\2\2\u0389"+
		"\u038a\3\2\2\2\u038a\u03a0\3\2\2\2\u038b\u038f\t\"\2\2\u038c\u038e\7\u0083"+
		"\2\2\u038d\u038c\3\2\2\2\u038e\u0391\3\2\2\2\u038f\u038d\3\2\2\2\u038f"+
		"\u0390\3\2\2\2\u0390\u0392\3\2\2\2\u0391\u038f\3\2\2\2\u0392\u039d\5\16"+
		"\b\2\u0393\u0395\7\u0083\2\2\u0394\u0393\3\2\2\2\u0395\u0396\3\2\2\2\u0396"+
		"\u0394\3\2\2\2\u0396\u0397\3\2\2\2\u0397\u0399\3\2\2\2\u0398\u039a\5\16"+
		"\b\2\u0399\u0398\3\2\2\2\u0399\u039a\3\2\2\2\u039a\u039c\3\2\2\2\u039b"+
		"\u0394\3\2\2\2\u039c\u039f\3\2\2\2\u039d\u039b\3\2\2\2\u039d\u039e\3\2"+
		"\2\2\u039e\u03a1\3\2\2\2\u039f\u039d\3\2\2\2\u03a0\u038b\3\2\2\2\u03a0"+
		"\u03a1\3\2\2\2\u03a1\u03a5\3\2\2\2\u03a2\u03a4\7\u0083\2\2\u03a3\u03a2"+
		"\3\2\2\2\u03a4\u03a7\3\2\2\2\u03a5\u03a3\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6"+
		"\u03a8\3\2\2\2\u03a7\u03a5\3\2\2\2\u03a8\u03ac\7\7\2\2\u03a9\u03ab\7\u0083"+
		"\2\2\u03aa\u03a9\3\2\2\2\u03ab\u03ae\3\2\2\2\u03ac\u03aa\3\2\2\2\u03ac"+
		"\u03ad\3\2\2\2\u03ad/\3\2\2\2\u03ae\u03ac\3\2\2\2\u03af\u03b3\7\6\2\2"+
		"\u03b0\u03b2\7\u0083\2\2\u03b1\u03b0\3\2\2\2\u03b2\u03b5\3\2\2\2\u03b3"+
		"\u03b1\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03b6\3\2\2\2\u03b5\u03b3\3\2"+
		"\2\2\u03b6\u03ba\7c\2\2\u03b7\u03b9\7\u0083\2\2\u03b8\u03b7\3\2\2\2\u03b9"+
		"\u03bc\3\2\2\2\u03ba\u03b8\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03be\3\2"+
		"\2\2\u03bc\u03ba\3\2\2\2\u03bd\u03bf\5\16\b\2\u03be\u03bd\3\2\2\2\u03be"+
		"\u03bf\3\2\2\2\u03bf\u03ca\3\2\2\2\u03c0\u03c2\7\u0083\2\2\u03c1\u03c0"+
		"\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03c1\3\2\2\2\u03c3\u03c4\3\2\2\2\u03c4"+
		"\u03c6\3\2\2\2\u03c5\u03c7\5\16\b\2\u03c6\u03c5\3\2\2\2\u03c6\u03c7\3"+
		"\2\2\2\u03c7\u03c9\3\2\2\2\u03c8\u03c1\3\2\2\2\u03c9\u03cc\3\2\2\2\u03ca"+
		"\u03c8\3\2\2\2\u03ca\u03cb\3\2\2\2\u03cb\u03cd\3\2\2\2\u03cc\u03ca\3\2"+
		"\2\2\u03cd\u03d1\7\7\2\2\u03ce\u03d0\7\u0083\2\2\u03cf\u03ce\3\2\2\2\u03d0"+
		"\u03d3\3\2\2\2\u03d1\u03cf\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\61\3\2\2"+
		"\2\u03d3\u03d1\3\2\2\2\u0094\66:?ORZ`gimruy\u0080\u008d\u0094\u009c\u00a4"+
		"\u00a9\u00ae\u00b1\u00b5\u00b9\u00c4\u00d2\u00e3\u00e6\u00ea\u00ef\u00f5"+
		"\u00fb\u0101\u0107\u010d\u0113\u0116\u0118\u0121\u012b\u012f\u0136\u013c"+
		"\u0143\u0149\u014f\u0157\u015d\u0164\u016b\u0172\u017c\u0184\u018a\u0191"+
		"\u019e\u01a9\u01b1\u01b4\u01bb\u01c9\u01d1\u01d4\u01d7\u01dd\u01e4\u01e8"+
		"\u01ed\u01f0\u01f4\u01fb\u0200\u0209\u0211\u021d\u0222\u0225\u0229\u0232"+
		"\u0239\u0248\u0252\u0259\u0262\u0269\u0270\u027f\u0286\u028e\u0291\u0297"+
		"\u029d\u02a4\u02ac\u02b1\u02b9\u02bc\u02c4\u02c9\u02d7\u02da\u02df\u02ec"+
		"\u02ef\u02f5\u02fc\u0301\u0307\u030d\u0313\u0319\u031f\u0325\u0328\u032a"+
		"\u0331\u0338\u033c\u0341\u0344\u0348\u0350\u0359\u035c\u0361\u0368\u036f"+
		"\u0376\u0379\u037d\u0380\u0385\u0389\u038f\u0396\u0399\u039d\u03a0\u03a5"+
		"\u03ac\u03b3\u03ba\u03be\u03c3\u03c6\u03ca\u03d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}