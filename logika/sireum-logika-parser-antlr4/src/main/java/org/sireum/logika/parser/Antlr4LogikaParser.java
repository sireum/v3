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
		T__119=120, T__120=121, INT=122, NUM=123, ID=124, STRING=125, LINE_COMMENT=126, 
		COMMENT=127, WS=128, ERROR_CHAR=129;
	public static final int
		RULE_sequent = 0, RULE_proof = 1, RULE_proofStep = 2, RULE_formula = 3, 
		RULE_qformula = 4, RULE_justification = 5, RULE_numOrId = 6, RULE_program = 7, 
		RULE_stmt = 8, RULE_exp = 9, RULE_type = 10, RULE_loopInvariant = 11, 
		RULE_modifies = 12, RULE_methodDecl = 13, RULE_param = 14, RULE_methodContract = 15, 
		RULE_invariants = 16, RULE_facts = 17, RULE_fact = 18, RULE_sequentFile = 19, 
		RULE_proofFile = 20, RULE_programFile = 21;
	public static final String[] ruleNames = {
		"sequent", "proof", "proofStep", "formula", "qformula", "justification", 
		"numOrId", "program", "stmt", "exp", "type", "loopInvariant", "modifies", 
		"methodDecl", "param", "methodContract", "invariants", "facts", "fact", 
		"sequentFile", "proofFile", "programFile"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'|-'", "'⊢'", "'{'", "'}'", "'.'", "'assume'", "'_|_'", 
		"'⊥'", "'('", "')'", "'$result'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<'", 
		"'<='", "'≤'", "'>'", "'>='", "'≥'", "'=='", "'!='", "'≠'", "'not'", "'!'", 
		"'~'", "'¬'", "'and'", "'&&'", "'∧'", "'or'", "'||'", "'∨'", "'implies'", 
		"'⇒'", "'forall'", "'all'", "'∀'", "'exists'", "'some'", "'∃'", "'|'", 
		"'premise'", "'andi'", "'&&i'", "'∧i'", "'ande1'", "'&&e1'", "'∧e1'", 
		"'ande2'", "'&&e2'", "'∧e2'", "'ori1'", "'||i1'", "'∨i1'", "'ori2'", "'||i2'", 
		"'∨i2'", "'ore'", "'||e'", "'∨e'", "'impliesi'", "'⇒i'", "'impliese'", 
		"'⇒e'", "'noti'", "'!i'", "'~i'", "'¬i'", "'note'", "'!e'", "'~e'", "'¬e'", 
		"'_|_e'", "'⊥e'", "'Pbc'", "'foalli'", "'alli'", "'∀i'", "'foalle'", "'alle'", 
		"'∀e'", "'existsi'", "'somei'", "'∃i'", "'existse'", "'somee'", "'∃e'", 
		"'algebra'", "'auto'", "'import'", "'_'", "'var'", "'val'", "':'", "'='", 
		"'assert'", "'if'", "'else'", "'while'", "'l'", "'\"\"\"'", "'readInt'", 
		"'print'", "'println'", "'s'", "'clone'", "'BigInt'", "'Seq'", "'['", 
		"']'", "'invariant'", "'modifies'", "'def'", "'return'", "'requires'", 
		"'ensures'", "'fact'"
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
		null, null, "INT", "NUM", "ID", "STRING", "LINE_COMMENT", "COMMENT", "WS", 
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
		public SequentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequent; }
	}

	public final SequentContext sequent() throws RecognitionException {
		SequentContext _localctx = new SequentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sequent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43))) != 0) || _la==INT || _la==ID) {
				{
				setState(44);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(45);
					match(T__0);
					setState(46);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(51);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(54);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(55);
			((SequentContext)_localctx).formula = formula(0);
			((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(56);
				match(T__0);
				setState(57);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				}
				}
				setState(62);
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

	public static class ProofContext extends ParserRuleContext {
		public List<ProofStepContext> proofStep() {
			return getRuleContexts(ProofStepContext.class);
		}
		public ProofStepContext proofStep(int i) {
			return getRuleContext(ProofStepContext.class,i);
		}
		public ProofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proof; }
	}

	public final ProofContext proof() throws RecognitionException {
		ProofContext _localctx = new ProofContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_proof);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__3);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3 || _la==NUM) {
				{
				{
				setState(64);
				proofStep();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
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
		public Token fresh;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
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
		enterRule(_localctx, 4, RULE_proofStep);
		int _la;
		try {
			setState(96);
			switch (_input.LA(1)) {
			case NUM:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(NUM);
				setState(73);
				match(T__5);
				setState(74);
				formula(0);
				setState(75);
				justification();
				}
				break;
			case T__3:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(T__3);
				setState(78);
				match(NUM);
				setState(79);
				match(T__5);
				setState(87);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(80);
					((SubProofContext)_localctx).fresh = match(ID);
					}
					break;
				case 2:
					{
					setState(82);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						setState(81);
						((SubProofContext)_localctx).fresh = match(ID);
						}
						break;
					}
					setState(84);
					formula(0);
					setState(85);
					match(T__6);
					}
					break;
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3 || _la==NUM) {
					{
					{
					setState(89);
					proofStep();
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(95);
				match(T__4);
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
	public static class BottomContext extends FormulaContext {
		public BottomContext(FormulaContext ctx) { copyFrom(ctx); }
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(99);
				((UnaryContext)_localctx).op = match(T__16);
				setState(100);
				formula(6);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(102);
				formula(5);
				}
				break;
			case 3:
				{
				_localctx = new BottomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
				_errHandler.recoverInline(this);
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
				setState(104);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105);
				match(T__9);
				setState(106);
				formula(0);
				setState(107);
				match(T__10);
				}
				break;
			case 6:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109);
				match(T__11);
				}
				break;
			case 7:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				((ApplyContext)_localctx).fun = match(ID);
				setState(111);
				match(T__9);
				setState(112);
				formula(0);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(113);
					match(T__0);
					setState(114);
					formula(0);
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(120);
				match(T__10);
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				match(INT);
				}
				break;
			case 9:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(147);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(126);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(127);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(128);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(129);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(130);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(131);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(132);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(133);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(134);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(135);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(136);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(137);
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(138);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(139);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(140);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(141);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(142);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(143);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(144);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(145);
						_la = _input.LA(1);
						if ( !(_la==T__36 || _la==T__37) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(146);
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		public List<Token> qVar = new ArrayList<Token>();
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public QformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qformula; }
	}

	public final QformulaContext qformula() throws RecognitionException {
		QformulaContext _localctx = new QformulaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_qformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(153);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).qVar.add(((QformulaContext)_localctx).ID);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(154);
				match(T__0);
				setState(155);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).qVar.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
			match(T__44);
			setState(162);
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
		public NumOrIdContext numOrId;
		public List<NumOrIdContext> args = new ArrayList<NumOrIdContext>();
		public List<NumOrIdContext> numOrId() {
			return getRuleContexts(NumOrIdContext.class);
		}
		public NumOrIdContext numOrId(int i) {
			return getRuleContext(NumOrIdContext.class,i);
		}
		public ForallElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ExistsIntroContext extends JustificationContext {
		public NumOrIdContext stepOrFact;
		public Token ID;
		public List<Token> args = new ArrayList<Token>();
		public NumOrIdContext numOrId() {
			return getRuleContext(NumOrIdContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public ExistsIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndIntroContext extends JustificationContext {
		public Token lStep;
		public Token rStep;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public AndIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ForallIntroContext extends JustificationContext {
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public ForallIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ImpliesElimContext extends JustificationContext {
		public Token impliesStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public ImpliesElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class PremiseContext extends JustificationContext {
		public PremiseContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndElim2Context extends JustificationContext {
		public Token andStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public AndElim2Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class OrIntro2Context extends JustificationContext {
		public Token orStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public OrIntro2Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class NegIntroContext extends JustificationContext {
		public Token step;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public NegIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class NegElimContext extends JustificationContext {
		public Token step;
		public Token notStep;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public NegElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class PbcContext extends JustificationContext {
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public PbcContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AutoContext extends JustificationContext {
		public NumOrIdContext numOrId;
		public List<NumOrIdContext> stepOrFact = new ArrayList<NumOrIdContext>();
		public List<NumOrIdContext> numOrId() {
			return getRuleContexts(NumOrIdContext.class);
		}
		public NumOrIdContext numOrId(int i) {
			return getRuleContext(NumOrIdContext.class,i);
		}
		public AutoContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class OrIntro1Context extends JustificationContext {
		public Token orStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public OrIntro1Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndElim1Context extends JustificationContext {
		public Token andStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public AndElim1Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AlgebraContext extends JustificationContext {
		public Token NUM;
		public List<Token> steps = new ArrayList<Token>();
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public AlgebraContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ExistsContext extends JustificationContext {
		public Token existsStep;
		public Token subproof;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public ExistsContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class BottomElimContext extends JustificationContext {
		public Token bottomStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public BottomElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class OrElimContext extends JustificationContext {
		public Token orStep;
		public Token lSubProof;
		public Token rSubProof;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public OrElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ImpliesIntroContext extends JustificationContext {
		public Token impliesStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public ImpliesIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}

	public final JustificationContext justification() throws RecognitionException {
		JustificationContext _localctx = new JustificationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_justification);
		int _la;
		try {
			int _alt;
			setState(226);
			switch (_input.LA(1)) {
			case T__45:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(T__45);
				}
				break;
			case T__46:
			case T__47:
			case T__48:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__46) | (1L << T__47) | (1L << T__48))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(166);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(167);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case T__49:
			case T__50:
			case T__51:
				_localctx = new AndElim1Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__49) | (1L << T__50) | (1L << T__51))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(169);
				((AndElim1Context)_localctx).andStep = match(NUM);
				}
				break;
			case T__52:
			case T__53:
			case T__54:
				_localctx = new AndElim2Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__52) | (1L << T__53) | (1L << T__54))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(171);
				((AndElim2Context)_localctx).andStep = match(NUM);
				}
				break;
			case T__55:
			case T__56:
			case T__57:
				_localctx = new OrIntro1Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__55) | (1L << T__56) | (1L << T__57))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(173);
				((OrIntro1Context)_localctx).orStep = match(NUM);
				}
				break;
			case T__58:
			case T__59:
			case T__60:
				_localctx = new OrIntro2Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(174);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__58) | (1L << T__59) | (1L << T__60))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(175);
				((OrIntro2Context)_localctx).orStep = match(NUM);
				}
				break;
			case T__61:
			case T__62:
			case T__63:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(176);
				_la = _input.LA(1);
				if ( !(((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (T__61 - 62)) | (1L << (T__62 - 62)) | (1L << (T__63 - 62)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(177);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(178);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(179);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case T__64:
			case T__65:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(180);
				_la = _input.LA(1);
				if ( !(_la==T__64 || _la==T__65) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(181);
				((ImpliesIntroContext)_localctx).impliesStep = match(NUM);
				}
				break;
			case T__66:
			case T__67:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(182);
				_la = _input.LA(1);
				if ( !(_la==T__66 || _la==T__67) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(183);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				}
				break;
			case T__68:
			case T__69:
			case T__70:
			case T__71:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(184);
				_la = _input.LA(1);
				if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (T__68 - 69)) | (1L << (T__69 - 69)) | (1L << (T__70 - 69)) | (1L << (T__71 - 69)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(185);
				((NegIntroContext)_localctx).step = match(NUM);
				}
				break;
			case T__72:
			case T__73:
			case T__74:
			case T__75:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(186);
				_la = _input.LA(1);
				if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__74 - 73)) | (1L << (T__75 - 73)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(187);
				((NegElimContext)_localctx).step = match(NUM);
				setState(188);
				((NegElimContext)_localctx).notStep = match(NUM);
				}
				break;
			case T__76:
			case T__77:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(189);
				_la = _input.LA(1);
				if ( !(_la==T__76 || _la==T__77) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(190);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case T__78:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(191);
				match(T__78);
				setState(192);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case T__79:
			case T__80:
			case T__81:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(193);
				_la = _input.LA(1);
				if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__81 - 80)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(194);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case T__82:
			case T__83:
			case T__84:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(195);
				_la = _input.LA(1);
				if ( !(((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(196);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
				setState(198); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(197);
						((ForallElimContext)_localctx).numOrId = numOrId();
						((ForallElimContext)_localctx).args.add(((ForallElimContext)_localctx).numOrId);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(200); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case T__85:
			case T__86:
			case T__87:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(202);
				_la = _input.LA(1);
				if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__87 - 86)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(203);
				((ExistsIntroContext)_localctx).stepOrFact = numOrId();
				setState(205); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(204);
					((ExistsIntroContext)_localctx).ID = match(ID);
					((ExistsIntroContext)_localctx).args.add(((ExistsIntroContext)_localctx).ID);
					}
					}
					setState(207); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				}
				break;
			case T__88:
			case T__89:
			case T__90:
				_localctx = new ExistsContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(209);
				_la = _input.LA(1);
				if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (T__88 - 89)) | (1L << (T__89 - 89)) | (1L << (T__90 - 89)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(210);
				((ExistsContext)_localctx).existsStep = match(NUM);
				setState(211);
				((ExistsContext)_localctx).subproof = match(NUM);
				}
				break;
			case T__91:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(212);
				match(T__91);
				setState(216);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(213);
						((AlgebraContext)_localctx).NUM = match(NUM);
						((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).NUM);
						}
						} 
					}
					setState(218);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				}
				break;
			case T__92:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(219);
				match(T__92);
				setState(223);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(220);
						((AutoContext)_localctx).numOrId = numOrId();
						((AutoContext)_localctx).stepOrFact.add(((AutoContext)_localctx).numOrId);
						}
						} 
					}
					setState(225);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
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
		enterRule(_localctx, 12, RULE_numOrId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
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

	public static class ProgramContext extends ParserRuleContext {
		public Token org;
		public Token sireum;
		public Token logika;
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(T__93);
			setState(231);
			((ProgramContext)_localctx).org = match(ID);
			setState(232);
			match(T__5);
			setState(233);
			((ProgramContext)_localctx).sireum = match(ID);
			setState(234);
			match(T__5);
			setState(235);
			((ProgramContext)_localctx).logika = match(ID);
			setState(236);
			match(T__5);
			setState(237);
			match(T__94);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (T__95 - 96)) | (1L << (T__96 - 96)) | (1L << (T__99 - 96)) | (1L << (T__100 - 96)) | (1L << (T__102 - 96)) | (1L << (T__103 - 96)) | (1L << (T__106 - 96)) | (1L << (T__107 - 96)) | (1L << (T__116 - 96)) | (1L << (ID - 96)))) != 0)) {
				{
				{
				setState(238);
				stmt();
				}
				}
				setState(243);
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
		public StmtContext stmt;
		public List<StmtContext> ts = new ArrayList<StmtContext>();
		public List<StmtContext> fs = new ArrayList<StmtContext>();
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class PrintStmtContext extends StmtContext {
		public Token op;
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public PrintStmtContext(StmtContext ctx) { copyFrom(ctx); }
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
		public LoopInvariantContext loopInvariant() {
			return getRuleContext(LoopInvariantContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
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
	public static class ArrayCloneStmtContext extends StmtContext {
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public ArrayCloneStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssertStmtContext extends StmtContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssertStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmt);
		int _la;
		try {
			setState(354);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__95 || _la==T__96) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(245);
				match(ID);
				setState(246);
				match(T__97);
				setState(247);
				type();
				setState(248);
				match(T__98);
				setState(249);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				match(ID);
				setState(252);
				match(T__98);
				setState(253);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(254);
				match(T__99);
				setState(255);
				match(T__9);
				setState(256);
				exp(0);
				setState(257);
				match(T__10);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(259);
				match(T__100);
				setState(260);
				match(T__9);
				setState(261);
				exp(0);
				setState(262);
				match(T__10);
				setState(263);
				match(T__3);
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (T__95 - 96)) | (1L << (T__96 - 96)) | (1L << (T__99 - 96)) | (1L << (T__100 - 96)) | (1L << (T__102 - 96)) | (1L << (T__103 - 96)) | (1L << (T__106 - 96)) | (1L << (T__107 - 96)) | (1L << (T__116 - 96)) | (1L << (ID - 96)))) != 0)) {
					{
					{
					setState(264);
					((IfStmtContext)_localctx).stmt = stmt();
					((IfStmtContext)_localctx).ts.add(((IfStmtContext)_localctx).stmt);
					}
					}
					setState(269);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(270);
				match(T__4);
				setState(271);
				match(T__101);
				setState(272);
				match(T__3);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (T__95 - 96)) | (1L << (T__96 - 96)) | (1L << (T__99 - 96)) | (1L << (T__100 - 96)) | (1L << (T__102 - 96)) | (1L << (T__103 - 96)) | (1L << (T__106 - 96)) | (1L << (T__107 - 96)) | (1L << (T__116 - 96)) | (1L << (ID - 96)))) != 0)) {
					{
					{
					setState(273);
					((IfStmtContext)_localctx).stmt = stmt();
					((IfStmtContext)_localctx).fs.add(((IfStmtContext)_localctx).stmt);
					}
					}
					setState(278);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(279);
				match(T__4);
				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(281);
				match(T__102);
				setState(282);
				match(T__9);
				setState(283);
				exp(0);
				setState(284);
				match(T__10);
				setState(285);
				match(T__3);
				setState(291);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(286);
					match(T__103);
					setState(287);
					match(T__104);
					setState(288);
					loopInvariant();
					setState(289);
					match(T__104);
					}
					break;
				}
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (T__95 - 96)) | (1L << (T__96 - 96)) | (1L << (T__99 - 96)) | (1L << (T__100 - 96)) | (1L << (T__102 - 96)) | (1L << (T__103 - 96)) | (1L << (T__106 - 96)) | (1L << (T__107 - 96)) | (1L << (T__116 - 96)) | (1L << (ID - 96)))) != 0)) {
					{
					{
					setState(293);
					stmt();
					}
					}
					setState(298);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(299);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new ReadIntStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(301);
				match(ID);
				setState(302);
				match(T__98);
				setState(303);
				match(T__105);
				setState(304);
				match(T__9);
				setState(306);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(305);
					match(STRING);
					}
				}

				setState(308);
				match(T__10);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(309);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__106 || _la==T__107) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(310);
				match(T__9);
				setState(311);
				match(T__108);
				setState(312);
				match(STRING);
				setState(313);
				match(T__10);
				}
				break;
			case 8:
				_localctx = new MethodInvocationStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(316);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(314);
					((MethodInvocationStmtContext)_localctx).l = match(ID);
					setState(315);
					match(T__98);
					}
					break;
				}
				setState(318);
				((MethodInvocationStmtContext)_localctx).r = match(ID);
				setState(319);
				match(T__9);
				setState(328);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__16) | (1L << T__27))) != 0) || ((((_la - 111)) & ~0x3f) == 0 && ((1L << (_la - 111)) & ((1L << (T__110 - 111)) | (1L << (T__111 - 111)) | (1L << (INT - 111)) | (1L << (ID - 111)))) != 0)) {
					{
					setState(320);
					exp(0);
					setState(325);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(321);
						match(T__0);
						setState(322);
						exp(0);
						}
						}
						setState(327);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(330);
				match(T__10);
				}
				break;
			case 9:
				_localctx = new ArrayCloneStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(331);
				match(ID);
				setState(332);
				match(T__98);
				setState(333);
				match(ID);
				setState(334);
				match(T__5);
				setState(335);
				match(T__109);
				}
				break;
			case 10:
				_localctx = new AssignArrayStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(336);
				match(ID);
				setState(337);
				match(T__9);
				setState(338);
				exp(0);
				setState(339);
				match(T__10);
				setState(340);
				match(T__98);
				setState(341);
				exp(0);
				}
				break;
			case 11:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(343);
				methodDecl();
				}
				break;
			case 12:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(344);
				match(T__103);
				setState(345);
				match(T__104);
				setState(350);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(346);
					proof();
					}
					break;
				case 2:
					{
					setState(347);
					sequent();
					}
					break;
				case 3:
					{
					setState(348);
					invariants();
					}
					break;
				case 4:
					{
					setState(349);
					facts();
					}
					break;
				}
				setState(352);
				match(T__104);
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
		public IdExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ParenExpContext(ExpContext ctx) { copyFrom(ctx); }
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			switch (_input.LA(1)) {
			case T__16:
			case T__27:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(357);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__27) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(358);
				exp(7);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(359);
				match(ID);
				}
				break;
			case INT:
				{
				_localctx = new IntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(360);
				match(INT);
				}
				break;
			case T__110:
				{
				_localctx = new BigIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(361);
				match(T__110);
				setState(362);
				match(T__9);
				setState(363);
				match(STRING);
				setState(364);
				match(T__10);
				}
				break;
			case T__111:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(365);
				match(T__111);
				setState(366);
				match(T__9);
				setState(367);
				exp(0);
				setState(370);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(368);
					match(T__0);
					setState(369);
					exp(0);
					}
				}

				setState(372);
				match(T__10);
				}
				break;
			case T__9:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(374);
				match(T__9);
				setState(375);
				exp(0);
				setState(376);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(400);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(398);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(380);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(381);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(382);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(383);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(384);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(385);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(386);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(387);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(388);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(389);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(390);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(391);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(392);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(393);
						match(T__31);
						}
						setState(394);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(395);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(396);
						match(T__34);
						}
						setState(397);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(402);
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
		public IntSeqTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class IntTypeContext extends TypeContext {
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		try {
			setState(408);
			switch (_input.LA(1)) {
			case T__110:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(403);
				match(T__110);
				}
				break;
			case T__111:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(404);
				match(T__111);
				setState(405);
				match(T__112);
				setState(406);
				match(T__110);
				setState(407);
				match(T__113);
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
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ModifiesContext modifies() {
			return getRuleContext(ModifiesContext.class,0);
		}
		public LoopInvariantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopInvariant; }
	}

	public final LoopInvariantContext loopInvariant() throws RecognitionException {
		LoopInvariantContext _localctx = new LoopInvariantContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_loopInvariant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(T__3);
			setState(411);
			match(T__114);
			setState(412);
			formula(0);
			setState(413);
			modifies();
			setState(414);
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
		enterRule(_localctx, 24, RULE_modifies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(T__115);
			setState(431);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(417);
					match(ID);
					}
					}
					setState(422);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(423);
				match(ID);
				setState(428);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(424);
					match(T__0);
					setState(425);
					match(ID);
					}
					}
					setState(430);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
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
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public MethodContractContext methodContract() {
			return getRuleContext(MethodContractContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
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
		enterRule(_localctx, 26, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			match(T__116);
			setState(434);
			match(ID);
			setState(435);
			match(T__9);
			setState(444);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(436);
				param();
				setState(441);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(437);
					match(T__0);
					setState(438);
					param();
					}
					}
					setState(443);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(446);
			match(T__10);
			setState(447);
			match(T__97);
			setState(448);
			type();
			setState(449);
			match(T__98);
			setState(450);
			match(T__3);
			setState(456);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(451);
				match(T__103);
				setState(452);
				match(T__104);
				setState(453);
				methodContract();
				setState(454);
				match(T__104);
				}
				break;
			}
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (T__95 - 96)) | (1L << (T__96 - 96)) | (1L << (T__99 - 96)) | (1L << (T__100 - 96)) | (1L << (T__102 - 96)) | (1L << (T__103 - 96)) | (1L << (T__106 - 96)) | (1L << (T__107 - 96)) | (1L << (T__116 - 96)) | (1L << (ID - 96)))) != 0)) {
				{
				{
				setState(458);
				stmt();
				}
				}
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(464);
			match(T__117);
			setState(466);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__16) | (1L << T__27))) != 0) || ((((_la - 111)) & ~0x3f) == 0 && ((1L << (_la - 111)) & ((1L << (T__110 - 111)) | (1L << (T__111 - 111)) | (1L << (INT - 111)) | (1L << (ID - 111)))) != 0)) {
				{
				setState(465);
				exp(0);
				}
			}

			setState(468);
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
		enterRule(_localctx, 28, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			match(ID);
			setState(471);
			match(T__97);
			setState(472);
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
		enterRule(_localctx, 30, RULE_methodContract);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			match(T__3);
			setState(477);
			_la = _input.LA(1);
			if (_la==T__118) {
				{
				setState(475);
				match(T__118);
				setState(476);
				formula(0);
				}
			}

			setState(480);
			_la = _input.LA(1);
			if (_la==T__115) {
				{
				setState(479);
				modifies();
				}
			}

			setState(484);
			_la = _input.LA(1);
			if (_la==T__119) {
				{
				setState(482);
				match(T__119);
				setState(483);
				formula(0);
				}
			}

			setState(486);
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
		enterRule(_localctx, 32, RULE_invariants);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			match(T__3);
			setState(489);
			match(T__114);
			setState(491); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(490);
				formula(0);
				}
				}
				setState(493); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43))) != 0) || _la==INT || _la==ID );
			setState(495);
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
		enterRule(_localctx, 34, RULE_facts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			match(T__3);
			setState(498);
			match(T__120);
			setState(500); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(499);
				fact();
				}
				}
				setState(502); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(504);
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
		enterRule(_localctx, 36, RULE_fact);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			match(ID);
			setState(507);
			match(T__5);
			setState(508);
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

	public static class SequentFileContext extends ParserRuleContext {
		public SequentContext sequent() {
			return getRuleContext(SequentContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Antlr4LogikaParser.EOF, 0); }
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
		enterRule(_localctx, 38, RULE_sequentFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			sequent();
			setState(512);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(511);
				proof();
				}
			}

			setState(514);
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
		enterRule(_localctx, 40, RULE_proofFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			proof();
			setState(517);
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
		enterRule(_localctx, 42, RULE_programFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			program();
			setState(520);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 9:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0083\u020d\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\5\2\67\n\2\3\2\3\2\3\2\3\2\7\2=\n\2\f\2\16\2@\13"+
		"\2\3\3\3\3\7\3D\n\3\f\3\16\3G\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4U\n\4\3\4\3\4\3\4\5\4Z\n\4\3\4\7\4]\n\4\f\4\16\4`\13\4"+
		"\3\4\5\4c\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\7\5v\n\5\f\5\16\5y\13\5\3\5\3\5\3\5\3\5\5\5\177\n\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\7\5\u0096\n\5\f\5\16\5\u0099\13\5\3\6\3\6\3\6\3\6\7\6\u009f\n"+
		"\6\f\6\16\6\u00a2\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7\u00c9\n\7\r\7\16\7\u00ca\3\7\3\7\3"+
		"\7\6\7\u00d0\n\7\r\7\16\7\u00d1\3\7\3\7\3\7\3\7\3\7\7\7\u00d9\n\7\f\7"+
		"\16\7\u00dc\13\7\3\7\3\7\7\7\u00e0\n\7\f\7\16\7\u00e3\13\7\5\7\u00e5\n"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00f2\n\t\f\t\16\t"+
		"\u00f5\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u010c\n\n\f\n\16\n\u010f\13\n\3\n\3\n\3"+
		"\n\3\n\7\n\u0115\n\n\f\n\16\n\u0118\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\5\n\u0126\n\n\3\n\7\n\u0129\n\n\f\n\16\n\u012c\13\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0135\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\5\n\u013f\n\n\3\n\3\n\3\n\3\n\3\n\7\n\u0146\n\n\f\n\16\n\u0149\13"+
		"\n\5\n\u014b\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0161\n\n\3\n\3\n\5\n\u0165\n\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0175"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u017d\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u0191\n\13\f\13\16\13\u0194\13\13\3\f\3\f\3\f\3\f\3\f\5\f\u019b"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\7\16\u01a5\n\16\f\16\16\16\u01a8"+
		"\13\16\3\16\3\16\3\16\7\16\u01ad\n\16\f\16\16\16\u01b0\13\16\5\16\u01b2"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u01ba\n\17\f\17\16\17\u01bd\13"+
		"\17\5\17\u01bf\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u01cb\n\17\3\17\7\17\u01ce\n\17\f\17\16\17\u01d1\13\17\3\17\3\17"+
		"\5\17\u01d5\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\5\21\u01e0"+
		"\n\21\3\21\5\21\u01e3\n\21\3\21\3\21\5\21\u01e7\n\21\3\21\3\21\3\22\3"+
		"\22\3\22\6\22\u01ee\n\22\r\22\16\22\u01ef\3\22\3\22\3\23\3\23\3\23\6\23"+
		"\u01f7\n\23\r\23\16\23\u01f8\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\5"+
		"\25\u0203\n\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\2\4\b\24\30"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\"\3\2\4\5\3\2\35 \3"+
		"\2\n\13\3\2\17\21\3\2\22\23\3\2\24\31\3\2\32\34\3\2!#\3\2$&\3\2\'(\3\2"+
		").\3\2\61\63\3\2\64\66\3\2\679\3\2:<\3\2=?\3\2@B\3\2CD\3\2EF\3\2GJ\3\2"+
		"KN\3\2OP\3\2RT\3\2UW\3\2XZ\3\2[]\3\2}~\3\2bc\3\2mn\4\2\23\23\36\36\4\2"+
		"\24\25\27\30\3\2\32\33\u0257\2\66\3\2\2\2\4A\3\2\2\2\6b\3\2\2\2\b~\3\2"+
		"\2\2\n\u009a\3\2\2\2\f\u00e4\3\2\2\2\16\u00e6\3\2\2\2\20\u00e8\3\2\2\2"+
		"\22\u0164\3\2\2\2\24\u017c\3\2\2\2\26\u019a\3\2\2\2\30\u019c\3\2\2\2\32"+
		"\u01a2\3\2\2\2\34\u01b3\3\2\2\2\36\u01d8\3\2\2\2 \u01dc\3\2\2\2\"\u01ea"+
		"\3\2\2\2$\u01f3\3\2\2\2&\u01fc\3\2\2\2(\u0200\3\2\2\2*\u0206\3\2\2\2,"+
		"\u0209\3\2\2\2.\63\5\b\5\2/\60\7\3\2\2\60\62\5\b\5\2\61/\3\2\2\2\62\65"+
		"\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\66.\3"+
		"\2\2\2\66\67\3\2\2\2\678\3\2\2\289\t\2\2\29>\5\b\5\2:;\7\3\2\2;=\5\b\5"+
		"\2<:\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?\3\3\2\2\2@>\3\2\2\2AE\7\6"+
		"\2\2BD\5\6\4\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH\3\2\2\2GE\3\2"+
		"\2\2HI\7\7\2\2I\5\3\2\2\2JK\7}\2\2KL\7\b\2\2LM\5\b\5\2MN\5\f\7\2Nc\3\2"+
		"\2\2OP\7\6\2\2PQ\7}\2\2QY\7\b\2\2RZ\7~\2\2SU\7~\2\2TS\3\2\2\2TU\3\2\2"+
		"\2UV\3\2\2\2VW\5\b\5\2WX\7\t\2\2XZ\3\2\2\2YR\3\2\2\2YT\3\2\2\2Z^\3\2\2"+
		"\2[]\5\6\4\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2"+
		"\2\2ac\7\7\2\2bJ\3\2\2\2bO\3\2\2\2c\7\3\2\2\2de\b\5\1\2ef\7\23\2\2f\177"+
		"\5\b\5\bgh\t\3\2\2h\177\5\b\5\7i\177\t\4\2\2j\177\7~\2\2kl\7\f\2\2lm\5"+
		"\b\5\2mn\7\r\2\2n\177\3\2\2\2o\177\7\16\2\2pq\7~\2\2qr\7\f\2\2rw\5\b\5"+
		"\2st\7\3\2\2tv\5\b\5\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2"+
		"\2yw\3\2\2\2z{\7\r\2\2{\177\3\2\2\2|\177\7|\2\2}\177\5\n\6\2~d\3\2\2\2"+
		"~g\3\2\2\2~i\3\2\2\2~j\3\2\2\2~k\3\2\2\2~o\3\2\2\2~p\3\2\2\2~|\3\2\2\2"+
		"~}\3\2\2\2\177\u0097\3\2\2\2\u0080\u0081\f\f\2\2\u0081\u0082\t\5\2\2\u0082"+
		"\u0096\5\b\5\r\u0083\u0084\f\13\2\2\u0084\u0085\t\6\2\2\u0085\u0096\5"+
		"\b\5\f\u0086\u0087\f\n\2\2\u0087\u0088\t\7\2\2\u0088\u0096\5\b\5\13\u0089"+
		"\u008a\f\t\2\2\u008a\u008b\t\b\2\2\u008b\u0096\5\b\5\n\u008c\u008d\f\6"+
		"\2\2\u008d\u008e\t\t\2\2\u008e\u0096\5\b\5\7\u008f\u0090\f\5\2\2\u0090"+
		"\u0091\t\n\2\2\u0091\u0096\5\b\5\6\u0092\u0093\f\4\2\2\u0093\u0094\t\13"+
		"\2\2\u0094\u0096\5\b\5\5\u0095\u0080\3\2\2\2\u0095\u0083\3\2\2\2\u0095"+
		"\u0086\3\2\2\2\u0095\u0089\3\2\2\2\u0095\u008c\3\2\2\2\u0095\u008f\3\2"+
		"\2\2\u0095\u0092\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\t\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\t\f\2\2"+
		"\u009b\u00a0\7~\2\2\u009c\u009d\7\3\2\2\u009d\u009f\7~\2\2\u009e\u009c"+
		"\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7/\2\2\u00a4\u00a5\5\b"+
		"\5\2\u00a5\13\3\2\2\2\u00a6\u00e5\7\60\2\2\u00a7\u00a8\t\r\2\2\u00a8\u00a9"+
		"\7}\2\2\u00a9\u00e5\7}\2\2\u00aa\u00ab\t\16\2\2\u00ab\u00e5\7}\2\2\u00ac"+
		"\u00ad\t\17\2\2\u00ad\u00e5\7}\2\2\u00ae\u00af\t\20\2\2\u00af\u00e5\7"+
		"}\2\2\u00b0\u00b1\t\21\2\2\u00b1\u00e5\7}\2\2\u00b2\u00b3\t\22\2\2\u00b3"+
		"\u00b4\7}\2\2\u00b4\u00b5\7}\2\2\u00b5\u00e5\7}\2\2\u00b6\u00b7\t\23\2"+
		"\2\u00b7\u00e5\7}\2\2\u00b8\u00b9\t\24\2\2\u00b9\u00e5\7}\2\2\u00ba\u00bb"+
		"\t\25\2\2\u00bb\u00e5\7}\2\2\u00bc\u00bd\t\26\2\2\u00bd\u00be\7}\2\2\u00be"+
		"\u00e5\7}\2\2\u00bf\u00c0\t\27\2\2\u00c0\u00e5\7}\2\2\u00c1\u00c2\7Q\2"+
		"\2\u00c2\u00e5\7}\2\2\u00c3\u00c4\t\30\2\2\u00c4\u00e5\7}\2\2\u00c5\u00c6"+
		"\t\31\2\2\u00c6\u00c8\5\16\b\2\u00c7\u00c9\5\16\b\2\u00c8\u00c7\3\2\2"+
		"\2\u00c9\u00ca\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00e5"+
		"\3\2\2\2\u00cc\u00cd\t\32\2\2\u00cd\u00cf\5\16\b\2\u00ce\u00d0\7~\2\2"+
		"\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d2\u00e5\3\2\2\2\u00d3\u00d4\t\33\2\2\u00d4\u00d5\7}\2\2\u00d5"+
		"\u00e5\7}\2\2\u00d6\u00da\7^\2\2\u00d7\u00d9\7}\2\2\u00d8\u00d7\3\2\2"+
		"\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00e5"+
		"\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00e1\7_\2\2\u00de\u00e0\5\16\b\2\u00df"+
		"\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2"+
		"\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00a6\3\2\2\2\u00e4"+
		"\u00a7\3\2\2\2\u00e4\u00aa\3\2\2\2\u00e4\u00ac\3\2\2\2\u00e4\u00ae\3\2"+
		"\2\2\u00e4\u00b0\3\2\2\2\u00e4\u00b2\3\2\2\2\u00e4\u00b6\3\2\2\2\u00e4"+
		"\u00b8\3\2\2\2\u00e4\u00ba\3\2\2\2\u00e4\u00bc\3\2\2\2\u00e4\u00bf\3\2"+
		"\2\2\u00e4\u00c1\3\2\2\2\u00e4\u00c3\3\2\2\2\u00e4\u00c5\3\2\2\2\u00e4"+
		"\u00cc\3\2\2\2\u00e4\u00d3\3\2\2\2\u00e4\u00d6\3\2\2\2\u00e4\u00dd\3\2"+
		"\2\2\u00e5\r\3\2\2\2\u00e6\u00e7\t\34\2\2\u00e7\17\3\2\2\2\u00e8\u00e9"+
		"\7`\2\2\u00e9\u00ea\7~\2\2\u00ea\u00eb\7\b\2\2\u00eb\u00ec\7~\2\2\u00ec"+
		"\u00ed\7\b\2\2\u00ed\u00ee\7~\2\2\u00ee\u00ef\7\b\2\2\u00ef\u00f3\7a\2"+
		"\2\u00f0\u00f2\5\22\n\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\21\3\2\2\2\u00f5\u00f3\3\2\2"+
		"\2\u00f6\u00f7\t\35\2\2\u00f7\u00f8\7~\2\2\u00f8\u00f9\7d\2\2\u00f9\u00fa"+
		"\5\26\f\2\u00fa\u00fb\7e\2\2\u00fb\u00fc\5\24\13\2\u00fc\u0165\3\2\2\2"+
		"\u00fd\u00fe\7~\2\2\u00fe\u00ff\7e\2\2\u00ff\u0165\5\24\13\2\u0100\u0101"+
		"\7f\2\2\u0101\u0102\7\f\2\2\u0102\u0103\5\24\13\2\u0103\u0104\7\r\2\2"+
		"\u0104\u0165\3\2\2\2\u0105\u0106\7g\2\2\u0106\u0107\7\f\2\2\u0107\u0108"+
		"\5\24\13\2\u0108\u0109\7\r\2\2\u0109\u010d\7\6\2\2\u010a\u010c\5\22\n"+
		"\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e"+
		"\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\7\7\2\2\u0111"+
		"\u0112\7h\2\2\u0112\u0116\7\6\2\2\u0113\u0115\5\22\n\2\u0114\u0113\3\2"+
		"\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117"+
		"\u0119\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011a\7\7\2\2\u011a\u0165\3\2"+
		"\2\2\u011b\u011c\7i\2\2\u011c\u011d\7\f\2\2\u011d\u011e\5\24\13\2\u011e"+
		"\u011f\7\r\2\2\u011f\u0125\7\6\2\2\u0120\u0121\7j\2\2\u0121\u0122\7k\2"+
		"\2\u0122\u0123\5\30\r\2\u0123\u0124\7k\2\2\u0124\u0126\3\2\2\2\u0125\u0120"+
		"\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u012a\3\2\2\2\u0127\u0129\5\22\n\2"+
		"\u0128\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b"+
		"\3\2\2\2\u012b\u012d\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\7\7\2\2\u012e"+
		"\u0165\3\2\2\2\u012f\u0130\7~\2\2\u0130\u0131\7e\2\2\u0131\u0132\7l\2"+
		"\2\u0132\u0134\7\f\2\2\u0133\u0135\7\177\2\2\u0134\u0133\3\2\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0165\7\r\2\2\u0137\u0138\t\36"+
		"\2\2\u0138\u0139\7\f\2\2\u0139\u013a\7o\2\2\u013a\u013b\7\177\2\2\u013b"+
		"\u0165\7\r\2\2\u013c\u013d\7~\2\2\u013d\u013f\7e\2\2\u013e\u013c\3\2\2"+
		"\2\u013e\u013f\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\7~\2\2\u0141\u014a"+
		"\7\f\2\2\u0142\u0147\5\24\13\2\u0143\u0144\7\3\2\2\u0144\u0146\5\24\13"+
		"\2\u0145\u0143\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148"+
		"\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u0142\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u0165\7\r\2\2\u014d\u014e\7~"+
		"\2\2\u014e\u014f\7e\2\2\u014f\u0150\7~\2\2\u0150\u0151\7\b\2\2\u0151\u0165"+
		"\7p\2\2\u0152\u0153\7~\2\2\u0153\u0154\7\f\2\2\u0154\u0155\5\24\13\2\u0155"+
		"\u0156\7\r\2\2\u0156\u0157\7e\2\2\u0157\u0158\5\24\13\2\u0158\u0165\3"+
		"\2\2\2\u0159\u0165\5\34\17\2\u015a\u015b\7j\2\2\u015b\u0160\7k\2\2\u015c"+
		"\u0161\5\4\3\2\u015d\u0161\5\2\2\2\u015e\u0161\5\"\22\2\u015f\u0161\5"+
		"$\23\2\u0160\u015c\3\2\2\2\u0160\u015d\3\2\2\2\u0160\u015e\3\2\2\2\u0160"+
		"\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\7k\2\2\u0163\u0165\3\2"+
		"\2\2\u0164\u00f6\3\2\2\2\u0164\u00fd\3\2\2\2\u0164\u0100\3\2\2\2\u0164"+
		"\u0105\3\2\2\2\u0164\u011b\3\2\2\2\u0164\u012f\3\2\2\2\u0164\u0137\3\2"+
		"\2\2\u0164\u013e\3\2\2\2\u0164\u014d\3\2\2\2\u0164\u0152\3\2\2\2\u0164"+
		"\u0159\3\2\2\2\u0164\u015a\3\2\2\2\u0165\23\3\2\2\2\u0166\u0167\b\13\1"+
		"\2\u0167\u0168\t\37\2\2\u0168\u017d\5\24\13\t\u0169\u017d\7~\2\2\u016a"+
		"\u017d\7|\2\2\u016b\u016c\7q\2\2\u016c\u016d\7\f\2\2\u016d\u016e\7\177"+
		"\2\2\u016e\u017d\7\r\2\2\u016f\u0170\7r\2\2\u0170\u0171\7\f\2\2\u0171"+
		"\u0174\5\24\13\2\u0172\u0173\7\3\2\2\u0173\u0175\5\24\13\2\u0174\u0172"+
		"\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\7\r\2\2\u0177"+
		"\u017d\3\2\2\2\u0178\u0179\7\f\2\2\u0179\u017a\5\24\13\2\u017a\u017b\7"+
		"\r\2\2\u017b\u017d\3\2\2\2\u017c\u0166\3\2\2\2\u017c\u0169\3\2\2\2\u017c"+
		"\u016a\3\2\2\2\u017c\u016b\3\2\2\2\u017c\u016f\3\2\2\2\u017c\u0178\3\2"+
		"\2\2\u017d\u0192\3\2\2\2\u017e\u017f\f\b\2\2\u017f\u0180\t\5\2\2\u0180"+
		"\u0191\5\24\13\t\u0181\u0182\f\7\2\2\u0182\u0183\t\6\2\2\u0183\u0191\5"+
		"\24\13\b\u0184\u0185\f\6\2\2\u0185\u0186\t \2\2\u0186\u0191\5\24\13\7"+
		"\u0187\u0188\f\5\2\2\u0188\u0189\t!\2\2\u0189\u0191\5\24\13\6\u018a\u018b"+
		"\f\4\2\2\u018b\u018c\7\"\2\2\u018c\u0191\5\24\13\5\u018d\u018e\f\3\2\2"+
		"\u018e\u018f\7%\2\2\u018f\u0191\5\24\13\4\u0190\u017e\3\2\2\2\u0190\u0181"+
		"\3\2\2\2\u0190\u0184\3\2\2\2\u0190\u0187\3\2\2\2\u0190\u018a\3\2\2\2\u0190"+
		"\u018d\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2"+
		"\2\2\u0193\25\3\2\2\2\u0194\u0192\3\2\2\2\u0195\u019b\7q\2\2\u0196\u0197"+
		"\7r\2\2\u0197\u0198\7s\2\2\u0198\u0199\7q\2\2\u0199\u019b\7t\2\2\u019a"+
		"\u0195\3\2\2\2\u019a\u0196\3\2\2\2\u019b\27\3\2\2\2\u019c\u019d\7\6\2"+
		"\2\u019d\u019e\7u\2\2\u019e\u019f\5\b\5\2\u019f\u01a0\5\32\16\2\u01a0"+
		"\u01a1\7\7\2\2\u01a1\31\3\2\2\2\u01a2\u01b1\7v\2\2\u01a3\u01a5\7~\2\2"+
		"\u01a4\u01a3\3\2\2\2\u01a5\u01a8\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7"+
		"\3\2\2\2\u01a7\u01b2\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a9\u01ae\7~\2\2\u01aa"+
		"\u01ab\7\3\2\2\u01ab\u01ad\7~\2\2\u01ac\u01aa\3\2\2\2\u01ad\u01b0\3\2"+
		"\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0"+
		"\u01ae\3\2\2\2\u01b1\u01a6\3\2\2\2\u01b1\u01a9\3\2\2\2\u01b2\33\3\2\2"+
		"\2\u01b3\u01b4\7w\2\2\u01b4\u01b5\7~\2\2\u01b5\u01be\7\f\2\2\u01b6\u01bb"+
		"\5\36\20\2\u01b7\u01b8\7\3\2\2\u01b8\u01ba\5\36\20\2\u01b9\u01b7\3\2\2"+
		"\2\u01ba\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bf"+
		"\3\2\2\2\u01bd\u01bb\3\2\2\2\u01be\u01b6\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf"+
		"\u01c0\3\2\2\2\u01c0\u01c1\7\r\2\2\u01c1\u01c2\7d\2\2\u01c2\u01c3\5\26"+
		"\f\2\u01c3\u01c4\7e\2\2\u01c4\u01ca\7\6\2\2\u01c5\u01c6\7j\2\2\u01c6\u01c7"+
		"\7k\2\2\u01c7\u01c8\5 \21\2\u01c8\u01c9\7k\2\2\u01c9\u01cb\3\2\2\2\u01ca"+
		"\u01c5\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cf\3\2\2\2\u01cc\u01ce\5\22"+
		"\n\2\u01cd\u01cc\3\2\2\2\u01ce\u01d1\3\2\2\2\u01cf\u01cd\3\2\2\2\u01cf"+
		"\u01d0\3\2\2\2\u01d0\u01d2\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d2\u01d4\7x"+
		"\2\2\u01d3\u01d5\5\24\13\2\u01d4\u01d3\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5"+
		"\u01d6\3\2\2\2\u01d6\u01d7\7\7\2\2\u01d7\35\3\2\2\2\u01d8\u01d9\7~\2\2"+
		"\u01d9\u01da\7d\2\2\u01da\u01db\5\26\f\2\u01db\37\3\2\2\2\u01dc\u01df"+
		"\7\6\2\2\u01dd\u01de\7y\2\2\u01de\u01e0\5\b\5\2\u01df\u01dd\3\2\2\2\u01df"+
		"\u01e0\3\2\2\2\u01e0\u01e2\3\2\2\2\u01e1\u01e3\5\32\16\2\u01e2\u01e1\3"+
		"\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e6\3\2\2\2\u01e4\u01e5\7z\2\2\u01e5"+
		"\u01e7\5\b\5\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e8\3\2"+
		"\2\2\u01e8\u01e9\7\7\2\2\u01e9!\3\2\2\2\u01ea\u01eb\7\6\2\2\u01eb\u01ed"+
		"\7u\2\2\u01ec\u01ee\5\b\5\2\u01ed\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef"+
		"\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f2\7\7"+
		"\2\2\u01f2#\3\2\2\2\u01f3\u01f4\7\6\2\2\u01f4\u01f6\7{\2\2\u01f5\u01f7"+
		"\5&\24\2\u01f6\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fb\7\7\2\2\u01fb%\3\2\2\2"+
		"\u01fc\u01fd\7~\2\2\u01fd\u01fe\7\b\2\2\u01fe\u01ff\5\n\6\2\u01ff\'\3"+
		"\2\2\2\u0200\u0202\5\2\2\2\u0201\u0203\5\4\3\2\u0202\u0201\3\2\2\2\u0202"+
		"\u0203\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0205\7\2\2\3\u0205)\3\2\2\2"+
		"\u0206\u0207\5\4\3\2\u0207\u0208\7\2\2\3\u0208+\3\2\2\2\u0209\u020a\5"+
		"\20\t\2\u020a\u020b\7\2\2\3\u020b-\3\2\2\2\62\63\66>ETY^bw~\u0095\u0097"+
		"\u00a0\u00ca\u00d1\u00da\u00e1\u00e4\u00f3\u010d\u0116\u0125\u012a\u0134"+
		"\u013e\u0147\u014a\u0160\u0164\u0174\u017c\u0190\u0192\u019a\u01a6\u01ae"+
		"\u01b1\u01bb\u01be\u01ca\u01cf\u01d4\u01df\u01e2\u01e6\u01ef\u01f8\u0202";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}