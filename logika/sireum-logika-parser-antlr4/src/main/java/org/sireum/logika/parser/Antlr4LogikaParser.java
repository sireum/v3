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
		T__52=53, T__53=54, T__54=55, T__55=56, NOT=57, AND=58, OR=59, IMPLIES=60, 
		FORALL=61, EXISTS=62, ANDI=63, ANDE1=64, ANDE2=65, ORI1=66, ORI2=67, ORE=68, 
		IMPLIESI=69, IMPLIESE=70, NOTI=71, NOTE=72, FORALLI=73, FORALLE=74, EXISTSI=75, 
		EXISTSE=76, INT=77, NUM=78, ID=79, STRING=80, LINE_COMMENT=81, COMMENT=82, 
		WS=83, ERROR_CHAR=84;
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
		null, "','", "'|-'", "'{'", "'}'", "'.'", "'assume'", "'_|_'", "'('", 
		"')'", "'$result'", "'*'", "'/'", "'%'", "'+'", "'-'", "'>'", "'>='", 
		"'<'", "'<='", "'=='", "'!='", "'|'", "'premise'", "'_|_e'", "'Pbc'", 
		"'algebra'", "'auto'", "'import'", "'_'", "'var'", "'val'", "':'", "'='", 
		"'assert'", "'if'", "'else'", "'while'", "'l'", "'\"\"\"'", "'readInt'", 
		"'println'", "'clone'", "'BigInt'", "'Seq'", "'!'", "'&&'", "'||'", "'['", 
		"']'", "'invariant'", "'modifies'", "'def'", "'return'", "'requires'", 
		"'ensures'", "'fact'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "NOT", "AND", "OR", 
		"IMPLIES", "FORALL", "EXISTS", "ANDI", "ANDE1", "ANDE2", "ORI1", "ORI2", 
		"ORE", "IMPLIESI", "IMPLIESE", "NOTI", "NOTE", "FORALLI", "FORALLE", "EXISTSI", 
		"EXISTSE", "INT", "NUM", "ID", "STRING", "LINE_COMMENT", "COMMENT", "WS", 
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__14) | (1L << NOT) | (1L << FORALL) | (1L << EXISTS))) != 0) || _la==INT || _la==ID) {
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
			match(T__1);
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
			match(T__2);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==NUM) {
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
			match(T__3);
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
				match(T__4);
				setState(74);
				formula(0);
				setState(75);
				justification();
				}
				break;
			case T__2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(T__2);
				setState(78);
				match(NUM);
				setState(79);
				match(T__4);
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
					match(T__5);
					}
					break;
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2 || _la==NUM) {
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
				match(T__3);
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
		public TerminalNode AND() { return getToken(Antlr4LogikaParser.AND, 0); }
		public TerminalNode OR() { return getToken(Antlr4LogikaParser.OR, 0); }
		public TerminalNode IMPLIES() { return getToken(Antlr4LogikaParser.IMPLIES, 0); }
		public BinaryContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class UnaryContext extends FormulaContext {
		public Token op;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode NOT() { return getToken(Antlr4LogikaParser.NOT, 0); }
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
				((UnaryContext)_localctx).op = match(T__14);
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
				((UnaryContext)_localctx).op = match(NOT);
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
				match(T__6);
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
				match(T__7);
				setState(106);
				formula(0);
				setState(107);
				match(T__8);
				}
				break;
			case 6:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109);
				match(T__9);
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
				match(T__7);
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
				match(T__8);
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
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
						if ( !(_la==T__13 || _la==T__14) ) {
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
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
						if ( !(_la==T__19 || _la==T__20) ) {
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
						match(AND);
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
						match(OR);
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
						match(IMPLIES);
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
		public TerminalNode FORALL() { return getToken(Antlr4LogikaParser.FORALL, 0); }
		public TerminalNode EXISTS() { return getToken(Antlr4LogikaParser.EXISTS, 0); }
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
			if ( !(_la==FORALL || _la==EXISTS) ) {
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
			match(T__21);
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
		public TerminalNode FORALLE() { return getToken(Antlr4LogikaParser.FORALLE, 0); }
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
		public TerminalNode EXISTSI() { return getToken(Antlr4LogikaParser.EXISTSI, 0); }
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
		public TerminalNode ANDI() { return getToken(Antlr4LogikaParser.ANDI, 0); }
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public AndIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ForallIntroContext extends JustificationContext {
		public Token subProof;
		public TerminalNode FORALLI() { return getToken(Antlr4LogikaParser.FORALLI, 0); }
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public ForallIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ImpliesElimContext extends JustificationContext {
		public Token impliesStep;
		public TerminalNode IMPLIESE() { return getToken(Antlr4LogikaParser.IMPLIESE, 0); }
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public ImpliesElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class PremiseContext extends JustificationContext {
		public PremiseContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndElim2Context extends JustificationContext {
		public Token andStep;
		public TerminalNode ANDE2() { return getToken(Antlr4LogikaParser.ANDE2, 0); }
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public AndElim2Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class OrIntro2Context extends JustificationContext {
		public Token orStep;
		public TerminalNode ORI2() { return getToken(Antlr4LogikaParser.ORI2, 0); }
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public OrIntro2Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class NegIntroContext extends JustificationContext {
		public Token step;
		public TerminalNode NOTI() { return getToken(Antlr4LogikaParser.NOTI, 0); }
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public NegIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class NegElimContext extends JustificationContext {
		public Token step;
		public Token notStep;
		public TerminalNode NOTE() { return getToken(Antlr4LogikaParser.NOTE, 0); }
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
		public TerminalNode ORI1() { return getToken(Antlr4LogikaParser.ORI1, 0); }
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public OrIntro1Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndElim1Context extends JustificationContext {
		public Token andStep;
		public TerminalNode ANDE1() { return getToken(Antlr4LogikaParser.ANDE1, 0); }
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
		public TerminalNode EXISTSE() { return getToken(Antlr4LogikaParser.EXISTSE, 0); }
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
		public TerminalNode ORE() { return getToken(Antlr4LogikaParser.ORE, 0); }
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public OrElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ImpliesIntroContext extends JustificationContext {
		public Token impliesStep;
		public TerminalNode IMPLIESI() { return getToken(Antlr4LogikaParser.IMPLIESI, 0); }
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
			case T__22:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(T__22);
				}
				break;
			case ANDI:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(ANDI);
				setState(166);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(167);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case ANDE1:
				_localctx = new AndElim1Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(ANDE1);
				setState(169);
				((AndElim1Context)_localctx).andStep = match(NUM);
				}
				break;
			case ANDE2:
				_localctx = new AndElim2Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				match(ANDE2);
				setState(171);
				((AndElim2Context)_localctx).andStep = match(NUM);
				}
				break;
			case ORI1:
				_localctx = new OrIntro1Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				match(ORI1);
				setState(173);
				((OrIntro1Context)_localctx).orStep = match(NUM);
				}
				break;
			case ORI2:
				_localctx = new OrIntro2Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(174);
				match(ORI2);
				setState(175);
				((OrIntro2Context)_localctx).orStep = match(NUM);
				}
				break;
			case ORE:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(176);
				match(ORE);
				setState(177);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(178);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(179);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case IMPLIESI:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(180);
				match(IMPLIESI);
				setState(181);
				((ImpliesIntroContext)_localctx).impliesStep = match(NUM);
				}
				break;
			case IMPLIESE:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(182);
				match(IMPLIESE);
				setState(183);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				}
				break;
			case NOTI:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(184);
				match(NOTI);
				setState(185);
				((NegIntroContext)_localctx).step = match(NUM);
				}
				break;
			case NOTE:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(186);
				match(NOTE);
				setState(187);
				((NegElimContext)_localctx).step = match(NUM);
				setState(188);
				((NegElimContext)_localctx).notStep = match(NUM);
				}
				break;
			case T__23:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(189);
				match(T__23);
				setState(190);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case T__24:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(191);
				match(T__24);
				setState(192);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case FORALLI:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(193);
				match(FORALLI);
				setState(194);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case FORALLE:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(195);
				match(FORALLE);
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
			case EXISTSI:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(202);
				match(EXISTSI);
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
			case EXISTSE:
				_localctx = new ExistsContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(209);
				match(EXISTSE);
				setState(210);
				((ExistsContext)_localctx).existsStep = match(NUM);
				setState(211);
				((ExistsContext)_localctx).subproof = match(NUM);
				}
				break;
			case T__25:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(212);
				match(T__25);
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
			case T__26:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(219);
				match(T__26);
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
			match(T__27);
			setState(231);
			((ProgramContext)_localctx).org = match(ID);
			setState(232);
			match(T__4);
			setState(233);
			((ProgramContext)_localctx).sireum = match(ID);
			setState(234);
			match(T__4);
			setState(235);
			((ProgramContext)_localctx).logika = match(ID);
			setState(236);
			match(T__4);
			setState(237);
			match(T__28);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & ((1L << (T__29 - 30)) | (1L << (T__30 - 30)) | (1L << (T__33 - 30)) | (1L << (T__34 - 30)) | (1L << (T__36 - 30)) | (1L << (T__37 - 30)) | (1L << (T__40 - 30)) | (1L << (T__51 - 30)) | (1L << (ID - 30)))) != 0)) {
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
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
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
		public Token access;
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
			setState(362);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				((VarDeclStmtContext)_localctx).access = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__30) ) {
					((VarDeclStmtContext)_localctx).access = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(245);
				match(ID);
				setState(246);
				match(T__31);
				setState(247);
				type();
				setState(248);
				match(T__32);
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
				match(T__32);
				setState(253);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(254);
				match(T__33);
				setState(255);
				match(T__7);
				setState(256);
				exp(0);
				setState(257);
				match(T__8);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(259);
				match(T__34);
				setState(260);
				match(T__7);
				setState(261);
				exp(0);
				setState(262);
				match(T__8);
				setState(263);
				match(T__2);
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & ((1L << (T__29 - 30)) | (1L << (T__30 - 30)) | (1L << (T__33 - 30)) | (1L << (T__34 - 30)) | (1L << (T__36 - 30)) | (1L << (T__37 - 30)) | (1L << (T__40 - 30)) | (1L << (T__51 - 30)) | (1L << (ID - 30)))) != 0)) {
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
				match(T__3);
				setState(271);
				match(T__35);
				setState(272);
				match(T__2);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & ((1L << (T__29 - 30)) | (1L << (T__30 - 30)) | (1L << (T__33 - 30)) | (1L << (T__34 - 30)) | (1L << (T__36 - 30)) | (1L << (T__37 - 30)) | (1L << (T__40 - 30)) | (1L << (T__51 - 30)) | (1L << (ID - 30)))) != 0)) {
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
				match(T__3);
				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(281);
				match(T__36);
				setState(282);
				match(T__7);
				setState(283);
				exp(0);
				setState(284);
				match(T__8);
				setState(285);
				match(T__2);
				setState(291);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(286);
					match(T__37);
					setState(287);
					match(T__38);
					setState(288);
					loopInvariant();
					setState(289);
					match(T__38);
					}
					break;
				}
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & ((1L << (T__29 - 30)) | (1L << (T__30 - 30)) | (1L << (T__33 - 30)) | (1L << (T__34 - 30)) | (1L << (T__36 - 30)) | (1L << (T__37 - 30)) | (1L << (T__40 - 30)) | (1L << (T__51 - 30)) | (1L << (ID - 30)))) != 0)) {
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
				match(T__3);
				}
				break;
			case 6:
				_localctx = new ReadIntStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(301);
				match(ID);
				setState(302);
				match(T__32);
				setState(303);
				match(T__39);
				setState(304);
				match(T__7);
				setState(306);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(305);
					match(STRING);
					}
				}

				setState(308);
				match(T__8);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(309);
				match(T__40);
				setState(310);
				match(T__7);
				setState(319);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(311);
					match(ID);
					setState(316);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(312);
						match(T__0);
						setState(313);
						match(ID);
						}
						}
						setState(318);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(321);
				match(T__8);
				}
				break;
			case 8:
				_localctx = new MethodInvocationStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(324);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(322);
					((MethodInvocationStmtContext)_localctx).l = match(ID);
					setState(323);
					match(T__32);
					}
					break;
				}
				setState(326);
				((MethodInvocationStmtContext)_localctx).r = match(ID);
				setState(327);
				match(T__7);
				setState(336);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__14) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0) || _la==INT || _la==ID) {
					{
					setState(328);
					exp(0);
					setState(333);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(329);
						match(T__0);
						setState(330);
						exp(0);
						}
						}
						setState(335);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(338);
				match(T__8);
				}
				break;
			case 9:
				_localctx = new ArrayCloneStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(339);
				match(ID);
				setState(340);
				match(T__32);
				setState(341);
				match(ID);
				setState(342);
				match(T__4);
				setState(343);
				match(T__41);
				}
				break;
			case 10:
				_localctx = new AssignArrayStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(344);
				match(ID);
				setState(345);
				match(T__7);
				setState(346);
				exp(0);
				setState(347);
				match(T__8);
				setState(348);
				match(T__32);
				setState(349);
				exp(0);
				}
				break;
			case 11:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(351);
				methodDecl();
				}
				break;
			case 12:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(352);
				match(T__37);
				setState(353);
				match(T__38);
				setState(358);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(354);
					proof();
					}
					break;
				case 2:
					{
					setState(355);
					sequent();
					}
					break;
				case 3:
					{
					setState(356);
					invariants();
					}
					break;
				case 4:
					{
					setState(357);
					facts();
					}
					break;
				}
				setState(360);
				match(T__38);
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
			setState(386);
			switch (_input.LA(1)) {
			case T__14:
			case T__44:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(365);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__44) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(366);
				exp(7);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(367);
				match(ID);
				}
				break;
			case INT:
				{
				_localctx = new IntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(368);
				match(INT);
				}
				break;
			case T__42:
				{
				_localctx = new BigIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(369);
				match(T__42);
				setState(370);
				match(T__7);
				setState(371);
				match(STRING);
				setState(372);
				match(T__8);
				}
				break;
			case T__43:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(373);
				match(T__43);
				setState(374);
				match(T__7);
				setState(375);
				exp(0);
				setState(378);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(376);
					match(T__0);
					setState(377);
					exp(0);
					}
				}

				setState(380);
				match(T__8);
				}
				break;
			case T__7:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(382);
				match(T__7);
				setState(383);
				exp(0);
				setState(384);
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(408);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(406);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(388);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(389);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(390);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(391);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(392);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__13 || _la==T__14) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(393);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(394);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(395);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(396);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(397);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(398);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(399);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(400);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(401);
						match(T__45);
						}
						setState(402);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(403);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(404);
						match(T__46);
						}
						setState(405);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(410);
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
			setState(416);
			switch (_input.LA(1)) {
			case T__42:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				match(T__42);
				}
				break;
			case T__43:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				match(T__43);
				setState(413);
				match(T__47);
				setState(414);
				match(T__42);
				setState(415);
				match(T__48);
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
			setState(418);
			match(T__2);
			setState(419);
			match(T__49);
			setState(420);
			formula(0);
			setState(421);
			modifies();
			setState(422);
			match(T__3);
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
			setState(424);
			match(T__50);
			setState(439);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(428);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
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
			case 2:
				{
				setState(431);
				match(ID);
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(432);
					match(T__0);
					setState(433);
					match(ID);
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
			setState(441);
			match(T__51);
			setState(442);
			match(ID);
			setState(443);
			match(T__7);
			setState(452);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(444);
				param();
				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(445);
					match(T__0);
					setState(446);
					param();
					}
					}
					setState(451);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(454);
			match(T__8);
			setState(455);
			match(T__31);
			setState(456);
			type();
			setState(457);
			match(T__32);
			setState(458);
			match(T__2);
			setState(464);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(459);
				match(T__37);
				setState(460);
				match(T__38);
				setState(461);
				methodContract();
				setState(462);
				match(T__38);
				}
				break;
			}
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & ((1L << (T__29 - 30)) | (1L << (T__30 - 30)) | (1L << (T__33 - 30)) | (1L << (T__34 - 30)) | (1L << (T__36 - 30)) | (1L << (T__37 - 30)) | (1L << (T__40 - 30)) | (1L << (T__51 - 30)) | (1L << (ID - 30)))) != 0)) {
				{
				{
				setState(466);
				stmt();
				}
				}
				setState(471);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(472);
			match(T__52);
			setState(474);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__14) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0) || _la==INT || _la==ID) {
				{
				setState(473);
				exp(0);
				}
			}

			setState(476);
			match(T__3);
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
			setState(478);
			match(ID);
			setState(479);
			match(T__31);
			setState(480);
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
			setState(482);
			match(T__2);
			setState(485);
			_la = _input.LA(1);
			if (_la==T__53) {
				{
				setState(483);
				match(T__53);
				setState(484);
				formula(0);
				}
			}

			setState(488);
			_la = _input.LA(1);
			if (_la==T__50) {
				{
				setState(487);
				modifies();
				}
			}

			setState(492);
			_la = _input.LA(1);
			if (_la==T__54) {
				{
				setState(490);
				match(T__54);
				setState(491);
				formula(0);
				}
			}

			setState(494);
			match(T__3);
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
			setState(496);
			match(T__2);
			setState(497);
			match(T__49);
			setState(499); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(498);
				formula(0);
				}
				}
				setState(501); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__14) | (1L << NOT) | (1L << FORALL) | (1L << EXISTS))) != 0) || _la==INT || _la==ID );
			setState(503);
			match(T__3);
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
			setState(505);
			match(T__2);
			setState(506);
			match(T__55);
			setState(508); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(507);
				fact();
				}
				}
				setState(510); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(512);
			match(T__3);
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
			setState(514);
			match(ID);
			setState(515);
			match(T__4);
			setState(516);
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
			setState(518);
			sequent();
			setState(520);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(519);
				proof();
				}
			}

			setState(522);
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
			setState(524);
			proof();
			setState(525);
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
			setState(527);
			program();
			setState(528);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3V\u0215\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
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
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0135\n\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n"+
		"\u013d\n\n\f\n\16\n\u0140\13\n\5\n\u0142\n\n\3\n\3\n\3\n\5\n\u0147\n\n"+
		"\3\n\3\n\3\n\3\n\3\n\7\n\u014e\n\n\f\n\16\n\u0151\13\n\5\n\u0153\n\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u0169\n\n\3\n\3\n\5\n\u016d\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u017d\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u0185\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0199\n\13"+
		"\f\13\16\13\u019c\13\13\3\f\3\f\3\f\3\f\3\f\5\f\u01a3\n\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\7\16\u01ad\n\16\f\16\16\16\u01b0\13\16\3\16\3\16"+
		"\3\16\7\16\u01b5\n\16\f\16\16\16\u01b8\13\16\5\16\u01ba\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\7\17\u01c2\n\17\f\17\16\17\u01c5\13\17\5\17\u01c7"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u01d3\n\17"+
		"\3\17\7\17\u01d6\n\17\f\17\16\17\u01d9\13\17\3\17\3\17\5\17\u01dd\n\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\5\21\u01e8\n\21\3\21\5\21"+
		"\u01eb\n\21\3\21\3\21\5\21\u01ef\n\21\3\21\3\21\3\22\3\22\3\22\6\22\u01f6"+
		"\n\22\r\22\16\22\u01f7\3\22\3\22\3\23\3\23\3\23\6\23\u01ff\n\23\r\23\16"+
		"\23\u0200\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\5\25\u020b\n\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\2\4\b\24\30\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,\2\n\3\2\r\17\3\2\20\21\3\2\22\25\3\2\26"+
		"\27\3\2?@\3\2PQ\3\2 !\4\2\21\21//\u0261\2\66\3\2\2\2\4A\3\2\2\2\6b\3\2"+
		"\2\2\b~\3\2\2\2\n\u009a\3\2\2\2\f\u00e4\3\2\2\2\16\u00e6\3\2\2\2\20\u00e8"+
		"\3\2\2\2\22\u016c\3\2\2\2\24\u0184\3\2\2\2\26\u01a2\3\2\2\2\30\u01a4\3"+
		"\2\2\2\32\u01aa\3\2\2\2\34\u01bb\3\2\2\2\36\u01e0\3\2\2\2 \u01e4\3\2\2"+
		"\2\"\u01f2\3\2\2\2$\u01fb\3\2\2\2&\u0204\3\2\2\2(\u0208\3\2\2\2*\u020e"+
		"\3\2\2\2,\u0211\3\2\2\2.\63\5\b\5\2/\60\7\3\2\2\60\62\5\b\5\2\61/\3\2"+
		"\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\67\3\2\2\2\65\63\3\2"+
		"\2\2\66.\3\2\2\2\66\67\3\2\2\2\678\3\2\2\289\7\4\2\29>\5\b\5\2:;\7\3\2"+
		"\2;=\5\b\5\2<:\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?\3\3\2\2\2@>\3\2"+
		"\2\2AE\7\5\2\2BD\5\6\4\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH\3\2"+
		"\2\2GE\3\2\2\2HI\7\6\2\2I\5\3\2\2\2JK\7P\2\2KL\7\7\2\2LM\5\b\5\2MN\5\f"+
		"\7\2Nc\3\2\2\2OP\7\5\2\2PQ\7P\2\2QY\7\7\2\2RZ\7Q\2\2SU\7Q\2\2TS\3\2\2"+
		"\2TU\3\2\2\2UV\3\2\2\2VW\5\b\5\2WX\7\b\2\2XZ\3\2\2\2YR\3\2\2\2YT\3\2\2"+
		"\2Z^\3\2\2\2[]\5\6\4\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2"+
		"\2\2`^\3\2\2\2ac\7\6\2\2bJ\3\2\2\2bO\3\2\2\2c\7\3\2\2\2de\b\5\1\2ef\7"+
		"\21\2\2f\177\5\b\5\bgh\7;\2\2h\177\5\b\5\7i\177\7\t\2\2j\177\7Q\2\2kl"+
		"\7\n\2\2lm\5\b\5\2mn\7\13\2\2n\177\3\2\2\2o\177\7\f\2\2pq\7Q\2\2qr\7\n"+
		"\2\2rw\5\b\5\2st\7\3\2\2tv\5\b\5\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2"+
		"\2\2xz\3\2\2\2yw\3\2\2\2z{\7\13\2\2{\177\3\2\2\2|\177\7O\2\2}\177\5\n"+
		"\6\2~d\3\2\2\2~g\3\2\2\2~i\3\2\2\2~j\3\2\2\2~k\3\2\2\2~o\3\2\2\2~p\3\2"+
		"\2\2~|\3\2\2\2~}\3\2\2\2\177\u0097\3\2\2\2\u0080\u0081\f\f\2\2\u0081\u0082"+
		"\t\2\2\2\u0082\u0096\5\b\5\r\u0083\u0084\f\13\2\2\u0084\u0085\t\3\2\2"+
		"\u0085\u0096\5\b\5\f\u0086\u0087\f\n\2\2\u0087\u0088\t\4\2\2\u0088\u0096"+
		"\5\b\5\13\u0089\u008a\f\t\2\2\u008a\u008b\t\5\2\2\u008b\u0096\5\b\5\n"+
		"\u008c\u008d\f\6\2\2\u008d\u008e\7<\2\2\u008e\u0096\5\b\5\7\u008f\u0090"+
		"\f\5\2\2\u0090\u0091\7=\2\2\u0091\u0096\5\b\5\6\u0092\u0093\f\4\2\2\u0093"+
		"\u0094\7>\2\2\u0094\u0096\5\b\5\5\u0095\u0080\3\2\2\2\u0095\u0083\3\2"+
		"\2\2\u0095\u0086\3\2\2\2\u0095\u0089\3\2\2\2\u0095\u008c\3\2\2\2\u0095"+
		"\u008f\3\2\2\2\u0095\u0092\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2"+
		"\2\2\u0097\u0098\3\2\2\2\u0098\t\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b"+
		"\t\6\2\2\u009b\u00a0\7Q\2\2\u009c\u009d\7\3\2\2\u009d\u009f\7Q\2\2\u009e"+
		"\u009c\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7\30\2\2\u00a4"+
		"\u00a5\5\b\5\2\u00a5\13\3\2\2\2\u00a6\u00e5\7\31\2\2\u00a7\u00a8\7A\2"+
		"\2\u00a8\u00a9\7P\2\2\u00a9\u00e5\7P\2\2\u00aa\u00ab\7B\2\2\u00ab\u00e5"+
		"\7P\2\2\u00ac\u00ad\7C\2\2\u00ad\u00e5\7P\2\2\u00ae\u00af\7D\2\2\u00af"+
		"\u00e5\7P\2\2\u00b0\u00b1\7E\2\2\u00b1\u00e5\7P\2\2\u00b2\u00b3\7F\2\2"+
		"\u00b3\u00b4\7P\2\2\u00b4\u00b5\7P\2\2\u00b5\u00e5\7P\2\2\u00b6\u00b7"+
		"\7G\2\2\u00b7\u00e5\7P\2\2\u00b8\u00b9\7H\2\2\u00b9\u00e5\7P\2\2\u00ba"+
		"\u00bb\7I\2\2\u00bb\u00e5\7P\2\2\u00bc\u00bd\7J\2\2\u00bd\u00be\7P\2\2"+
		"\u00be\u00e5\7P\2\2\u00bf\u00c0\7\32\2\2\u00c0\u00e5\7P\2\2\u00c1\u00c2"+
		"\7\33\2\2\u00c2\u00e5\7P\2\2\u00c3\u00c4\7K\2\2\u00c4\u00e5\7P\2\2\u00c5"+
		"\u00c6\7L\2\2\u00c6\u00c8\5\16\b\2\u00c7\u00c9\5\16\b\2\u00c8\u00c7\3"+
		"\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00e5\3\2\2\2\u00cc\u00cd\7M\2\2\u00cd\u00cf\5\16\b\2\u00ce\u00d0\7Q"+
		"\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\u00e5\3\2\2\2\u00d3\u00d4\7N\2\2\u00d4\u00d5\7P\2"+
		"\2\u00d5\u00e5\7P\2\2\u00d6\u00da\7\34\2\2\u00d7\u00d9\7P\2\2\u00d8\u00d7"+
		"\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00e5\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00e1\7\35\2\2\u00de\u00e0\5"+
		"\16\b\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00a6\3\2"+
		"\2\2\u00e4\u00a7\3\2\2\2\u00e4\u00aa\3\2\2\2\u00e4\u00ac\3\2\2\2\u00e4"+
		"\u00ae\3\2\2\2\u00e4\u00b0\3\2\2\2\u00e4\u00b2\3\2\2\2\u00e4\u00b6\3\2"+
		"\2\2\u00e4\u00b8\3\2\2\2\u00e4\u00ba\3\2\2\2\u00e4\u00bc\3\2\2\2\u00e4"+
		"\u00bf\3\2\2\2\u00e4\u00c1\3\2\2\2\u00e4\u00c3\3\2\2\2\u00e4\u00c5\3\2"+
		"\2\2\u00e4\u00cc\3\2\2\2\u00e4\u00d3\3\2\2\2\u00e4\u00d6\3\2\2\2\u00e4"+
		"\u00dd\3\2\2\2\u00e5\r\3\2\2\2\u00e6\u00e7\t\7\2\2\u00e7\17\3\2\2\2\u00e8"+
		"\u00e9\7\36\2\2\u00e9\u00ea\7Q\2\2\u00ea\u00eb\7\7\2\2\u00eb\u00ec\7Q"+
		"\2\2\u00ec\u00ed\7\7\2\2\u00ed\u00ee\7Q\2\2\u00ee\u00ef\7\7\2\2\u00ef"+
		"\u00f3\7\37\2\2\u00f0\u00f2\5\22\n\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3"+
		"\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\21\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f6\u00f7\t\b\2\2\u00f7\u00f8\7Q\2\2\u00f8\u00f9\7\""+
		"\2\2\u00f9\u00fa\5\26\f\2\u00fa\u00fb\7#\2\2\u00fb\u00fc\5\24\13\2\u00fc"+
		"\u016d\3\2\2\2\u00fd\u00fe\7Q\2\2\u00fe\u00ff\7#\2\2\u00ff\u016d\5\24"+
		"\13\2\u0100\u0101\7$\2\2\u0101\u0102\7\n\2\2\u0102\u0103\5\24\13\2\u0103"+
		"\u0104\7\13\2\2\u0104\u016d\3\2\2\2\u0105\u0106\7%\2\2\u0106\u0107\7\n"+
		"\2\2\u0107\u0108\5\24\13\2\u0108\u0109\7\13\2\2\u0109\u010d\7\5\2\2\u010a"+
		"\u010c\5\22\n\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3"+
		"\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110"+
		"\u0111\7\6\2\2\u0111\u0112\7&\2\2\u0112\u0116\7\5\2\2\u0113\u0115\5\22"+
		"\n\2\u0114\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011a\7\6"+
		"\2\2\u011a\u016d\3\2\2\2\u011b\u011c\7\'\2\2\u011c\u011d\7\n\2\2\u011d"+
		"\u011e\5\24\13\2\u011e\u011f\7\13\2\2\u011f\u0125\7\5\2\2\u0120\u0121"+
		"\7(\2\2\u0121\u0122\7)\2\2\u0122\u0123\5\30\r\2\u0123\u0124\7)\2\2\u0124"+
		"\u0126\3\2\2\2\u0125\u0120\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u012a\3\2"+
		"\2\2\u0127\u0129\5\22\n\2\u0128\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a"+
		"\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d\3\2\2\2\u012c\u012a\3\2"+
		"\2\2\u012d\u012e\7\6\2\2\u012e\u016d\3\2\2\2\u012f\u0130\7Q\2\2\u0130"+
		"\u0131\7#\2\2\u0131\u0132\7*\2\2\u0132\u0134\7\n\2\2\u0133\u0135\7R\2"+
		"\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u016d"+
		"\7\13\2\2\u0137\u0138\7+\2\2\u0138\u0141\7\n\2\2\u0139\u013e\7Q\2\2\u013a"+
		"\u013b\7\3\2\2\u013b\u013d\7Q\2\2\u013c\u013a\3\2\2\2\u013d\u0140\3\2"+
		"\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0142\3\2\2\2\u0140"+
		"\u013e\3\2\2\2\u0141\u0139\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\3\2"+
		"\2\2\u0143\u016d\7\13\2\2\u0144\u0145\7Q\2\2\u0145\u0147\7#\2\2\u0146"+
		"\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\7Q"+
		"\2\2\u0149\u0152\7\n\2\2\u014a\u014f\5\24\13\2\u014b\u014c\7\3\2\2\u014c"+
		"\u014e\5\24\13\2\u014d\u014b\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3"+
		"\2\2\2\u014f\u0150\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0152"+
		"\u014a\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u016d\7\13"+
		"\2\2\u0155\u0156\7Q\2\2\u0156\u0157\7#\2\2\u0157\u0158\7Q\2\2\u0158\u0159"+
		"\7\7\2\2\u0159\u016d\7,\2\2\u015a\u015b\7Q\2\2\u015b\u015c\7\n\2\2\u015c"+
		"\u015d\5\24\13\2\u015d\u015e\7\13\2\2\u015e\u015f\7#\2\2\u015f\u0160\5"+
		"\24\13\2\u0160\u016d\3\2\2\2\u0161\u016d\5\34\17\2\u0162\u0163\7(\2\2"+
		"\u0163\u0168\7)\2\2\u0164\u0169\5\4\3\2\u0165\u0169\5\2\2\2\u0166\u0169"+
		"\5\"\22\2\u0167\u0169\5$\23\2\u0168\u0164\3\2\2\2\u0168\u0165\3\2\2\2"+
		"\u0168\u0166\3\2\2\2\u0168\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b"+
		"\7)\2\2\u016b\u016d\3\2\2\2\u016c\u00f6\3\2\2\2\u016c\u00fd\3\2\2\2\u016c"+
		"\u0100\3\2\2\2\u016c\u0105\3\2\2\2\u016c\u011b\3\2\2\2\u016c\u012f\3\2"+
		"\2\2\u016c\u0137\3\2\2\2\u016c\u0146\3\2\2\2\u016c\u0155\3\2\2\2\u016c"+
		"\u015a\3\2\2\2\u016c\u0161\3\2\2\2\u016c\u0162\3\2\2\2\u016d\23\3\2\2"+
		"\2\u016e\u016f\b\13\1\2\u016f\u0170\t\t\2\2\u0170\u0185\5\24\13\t\u0171"+
		"\u0185\7Q\2\2\u0172\u0185\7O\2\2\u0173\u0174\7-\2\2\u0174\u0175\7\n\2"+
		"\2\u0175\u0176\7R\2\2\u0176\u0185\7\13\2\2\u0177\u0178\7.\2\2\u0178\u0179"+
		"\7\n\2\2\u0179\u017c\5\24\13\2\u017a\u017b\7\3\2\2\u017b\u017d\5\24\13"+
		"\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f"+
		"\7\13\2\2\u017f\u0185\3\2\2\2\u0180\u0181\7\n\2\2\u0181\u0182\5\24\13"+
		"\2\u0182\u0183\7\13\2\2\u0183\u0185\3\2\2\2\u0184\u016e\3\2\2\2\u0184"+
		"\u0171\3\2\2\2\u0184\u0172\3\2\2\2\u0184\u0173\3\2\2\2\u0184\u0177\3\2"+
		"\2\2\u0184\u0180\3\2\2\2\u0185\u019a\3\2\2\2\u0186\u0187\f\b\2\2\u0187"+
		"\u0188\t\2\2\2\u0188\u0199\5\24\13\t\u0189\u018a\f\7\2\2\u018a\u018b\t"+
		"\3\2\2\u018b\u0199\5\24\13\b\u018c\u018d\f\6\2\2\u018d\u018e\t\4\2\2\u018e"+
		"\u0199\5\24\13\7\u018f\u0190\f\5\2\2\u0190\u0191\t\5\2\2\u0191\u0199\5"+
		"\24\13\6\u0192\u0193\f\4\2\2\u0193\u0194\7\60\2\2\u0194\u0199\5\24\13"+
		"\5\u0195\u0196\f\3\2\2\u0196\u0197\7\61\2\2\u0197\u0199\5\24\13\4\u0198"+
		"\u0186\3\2\2\2\u0198\u0189\3\2\2\2\u0198\u018c\3\2\2\2\u0198\u018f\3\2"+
		"\2\2\u0198\u0192\3\2\2\2\u0198\u0195\3\2\2\2\u0199\u019c\3\2\2\2\u019a"+
		"\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\25\3\2\2\2\u019c\u019a\3\2\2"+
		"\2\u019d\u01a3\7-\2\2\u019e\u019f\7.\2\2\u019f\u01a0\7\62\2\2\u01a0\u01a1"+
		"\7-\2\2\u01a1\u01a3\7\63\2\2\u01a2\u019d\3\2\2\2\u01a2\u019e\3\2\2\2\u01a3"+
		"\27\3\2\2\2\u01a4\u01a5\7\5\2\2\u01a5\u01a6\7\64\2\2\u01a6\u01a7\5\b\5"+
		"\2\u01a7\u01a8\5\32\16\2\u01a8\u01a9\7\6\2\2\u01a9\31\3\2\2\2\u01aa\u01b9"+
		"\7\65\2\2\u01ab\u01ad\7Q\2\2\u01ac\u01ab\3\2\2\2\u01ad\u01b0\3\2\2\2\u01ae"+
		"\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01ba\3\2\2\2\u01b0\u01ae\3\2"+
		"\2\2\u01b1\u01b6\7Q\2\2\u01b2\u01b3\7\3\2\2\u01b3\u01b5\7Q\2\2\u01b4\u01b2"+
		"\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7"+
		"\u01ba\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01ae\3\2\2\2\u01b9\u01b1\3\2"+
		"\2\2\u01ba\33\3\2\2\2\u01bb\u01bc\7\66\2\2\u01bc\u01bd\7Q\2\2\u01bd\u01c6"+
		"\7\n\2\2\u01be\u01c3\5\36\20\2\u01bf\u01c0\7\3\2\2\u01c0\u01c2\5\36\20"+
		"\2\u01c1\u01bf\3\2\2\2\u01c2\u01c5\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4"+
		"\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c6\u01be\3\2\2\2\u01c6"+
		"\u01c7\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c9\7\13\2\2\u01c9\u01ca\7"+
		"\"\2\2\u01ca\u01cb\5\26\f\2\u01cb\u01cc\7#\2\2\u01cc\u01d2\7\5\2\2\u01cd"+
		"\u01ce\7(\2\2\u01ce\u01cf\7)\2\2\u01cf\u01d0\5 \21\2\u01d0\u01d1\7)\2"+
		"\2\u01d1\u01d3\3\2\2\2\u01d2\u01cd\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d7"+
		"\3\2\2\2\u01d4\u01d6\5\22\n\2\u01d5\u01d4\3\2\2\2\u01d6\u01d9\3\2\2\2"+
		"\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01da\3\2\2\2\u01d9\u01d7"+
		"\3\2\2\2\u01da\u01dc\7\67\2\2\u01db\u01dd\5\24\13\2\u01dc\u01db\3\2\2"+
		"\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\7\6\2\2\u01df\35"+
		"\3\2\2\2\u01e0\u01e1\7Q\2\2\u01e1\u01e2\7\"\2\2\u01e2\u01e3\5\26\f\2\u01e3"+
		"\37\3\2\2\2\u01e4\u01e7\7\5\2\2\u01e5\u01e6\78\2\2\u01e6\u01e8\5\b\5\2"+
		"\u01e7\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01ea\3\2\2\2\u01e9\u01eb"+
		"\5\32\16\2\u01ea\u01e9\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ee\3\2\2\2"+
		"\u01ec\u01ed\79\2\2\u01ed\u01ef\5\b\5\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef"+
		"\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f1\7\6\2\2\u01f1!\3\2\2\2\u01f2"+
		"\u01f3\7\5\2\2\u01f3\u01f5\7\64\2\2\u01f4\u01f6\5\b\5\2\u01f5\u01f4\3"+
		"\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9\u01fa\7\6\2\2\u01fa#\3\2\2\2\u01fb\u01fc\7\5\2\2"+
		"\u01fc\u01fe\7:\2\2\u01fd\u01ff\5&\24\2\u01fe\u01fd\3\2\2\2\u01ff\u0200"+
		"\3\2\2\2\u0200\u01fe\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0202\3\2\2\2\u0202"+
		"\u0203\7\6\2\2\u0203%\3\2\2\2\u0204\u0205\7Q\2\2\u0205\u0206\7\7\2\2\u0206"+
		"\u0207\5\n\6\2\u0207\'\3\2\2\2\u0208\u020a\5\2\2\2\u0209\u020b\5\4\3\2"+
		"\u020a\u0209\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020d"+
		"\7\2\2\3\u020d)\3\2\2\2\u020e\u020f\5\4\3\2\u020f\u0210\7\2\2\3\u0210"+
		"+\3\2\2\2\u0211\u0212\5\20\t\2\u0212\u0213\7\2\2\3\u0213-\3\2\2\2\64\63"+
		"\66>ETY^bw~\u0095\u0097\u00a0\u00ca\u00d1\u00da\u00e1\u00e4\u00f3\u010d"+
		"\u0116\u0125\u012a\u0134\u013e\u0141\u0146\u014f\u0152\u0168\u016c\u017c"+
		"\u0184\u0198\u019a\u01a2\u01ae\u01b6\u01b9\u01c3\u01c6\u01d2\u01d7\u01dc"+
		"\u01e7\u01ea\u01ee\u01f7\u0200\u020a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}