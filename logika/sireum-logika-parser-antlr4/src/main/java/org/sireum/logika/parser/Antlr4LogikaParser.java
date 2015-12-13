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
		T__94=95, T__95=96, T__96=97, T__97=98, T__98=99, T__99=100, HLINE=101, 
		INT=102, NUM=103, ID=104, STRING=105, LINE_COMMENT=106, COMMENT=107, NL=108, 
		WS=109, RESERVED=110, ERROR_CHAR=111;
	public static final int
		RULE_sequentFile = 0, RULE_proofFile = 1, RULE_programFile = 2, RULE_sequent = 3, 
		RULE_proof = 4, RULE_proofStep = 5, RULE_formula = 6, RULE_qformula = 7, 
		RULE_justification = 8, RULE_ruleIntro = 9, RULE_ruleIntro1 = 10, RULE_ruleIntro2 = 11, 
		RULE_ruleElim = 12, RULE_ruleElim1 = 13, RULE_ruleElim2 = 14, RULE_numOrId = 15, 
		RULE_program = 16, RULE_stmts = 17, RULE_stmt = 18, RULE_exp = 19, RULE_type = 20, 
		RULE_loopInvariant = 21, RULE_modifies = 22, RULE_methodDecl = 23, RULE_param = 24, 
		RULE_methodContract = 25, RULE_invariants = 26, RULE_facts = 27, RULE_fact = 28;
	public static final String[] ruleNames = {
		"sequentFile", "proofFile", "programFile", "sequent", "proof", "proofStep", 
		"formula", "qformula", "justification", "ruleIntro", "ruleIntro1", "ruleIntro2", 
		"ruleElim", "ruleElim1", "ruleElim2", "numOrId", "program", "stmts", "stmt", 
		"exp", "type", "loopInvariant", "modifies", "methodDecl", "param", "methodContract", 
		"invariants", "facts", "fact"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'|-'", "'⊢'", "'{'", "'}'", "'.'", "'assume'", "'_|_'", 
		"'⊥'", "'('", "')'", "'$result'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<'", 
		"'<='", "'≤'", "'>'", "'>='", "'≥'", "'=='", "'!='", "'≠'", "'not'", "'!'", 
		"'~'", "'¬'", "'and'", "'&&'", "'∧'", "'or'", "'||'", "'∨'", "'implies'", 
		"'⇒'", "'=>'", "'forall'", "'all'", "'∀'", "'exists'", "'some'", "'∃'", 
		"'|'", "'premise'", "'andi'", "'ande1'", "'ande2'", "'ori1'", "'ori2'", 
		"'ore'", "'impliesi'", "'impliese'", "'noti'", "'note'", "'Pbc'", "'foalli'", 
		"'alli'", "'foalle'", "'alle'", "'existsi'", "'somei'", "'existse'", "'somee'", 
		"'algebra'", "'auto'", "'import'", "'_'", "';'", "'var'", "'val'", "':'", 
		"'='", "'assert'", "'if'", "'else'", "'while'", "'l'", "'\"\"\"'", "'readInt'", 
		"'print'", "'println'", "'s'", "'clone'", "'true'", "'false'", "'BigInt'", 
		"'Seq'", "'Boolean'", "'['", "']'", "'invariant'", "'modifies'", "'def'", 
		"'return'", "'requires'", "'ensures'", "'fact'"
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
		null, null, null, null, null, "HLINE", "INT", "NUM", "ID", "STRING", "LINE_COMMENT", 
		"COMMENT", "NL", "WS", "RESERVED", "ERROR_CHAR"
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
			setState(58);
			sequent();
			setState(60);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(59);
				proof();
				}
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
		public TerminalNode HLINE() { return getToken(Antlr4LogikaParser.HLINE, 0); }
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
		enterRule(_localctx, 6, RULE_sequent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0) || _la==INT || _la==ID) {
				{
				setState(70);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0) || _la==INT || _la==ID) {
					{
					{
					setState(72);
					_la = _input.LA(1);
					if (_la==T__0) {
						{
						setState(71);
						match(T__0);
						}
					}

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
			if ( !(_la==T__1 || _la==T__2 || _la==HLINE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(83);
			((SequentContext)_localctx).formula = formula(0);
			((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0) || _la==INT || _la==ID) {
				{
				{
				setState(85);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(84);
					match(T__0);
					}
				}

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
		enterRule(_localctx, 8, RULE_proof);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__3);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3 || _la==NUM) {
				{
				{
				setState(94);
				proofStep();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
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
		enterRule(_localctx, 10, RULE_proofStep);
		int _la;
		try {
			setState(126);
			switch (_input.LA(1)) {
			case NUM:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(NUM);
				setState(103);
				match(T__5);
				setState(104);
				formula(0);
				setState(105);
				justification();
				}
				break;
			case T__3:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(T__3);
				setState(108);
				match(NUM);
				setState(109);
				match(T__5);
				setState(117);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(110);
					((SubProofContext)_localctx).fresh = match(ID);
					}
					break;
				case 2:
					{
					setState(112);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						setState(111);
						((SubProofContext)_localctx).fresh = match(ID);
						}
						break;
					}
					setState(114);
					formula(0);
					setState(115);
					match(T__6);
					}
					break;
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3 || _la==NUM) {
					{
					{
					setState(119);
					proofStep();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(125);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(129);
				((UnaryContext)_localctx).op = match(T__16);
				setState(130);
				formula(6);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(132);
				formula(5);
				}
				break;
			case 3:
				{
				_localctx = new BottomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
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
				setState(134);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				match(T__9);
				setState(136);
				formula(0);
				setState(137);
				match(T__10);
				}
				break;
			case 6:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(T__11);
				}
				break;
			case 7:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				((ApplyContext)_localctx).fun = match(ID);
				setState(141);
				match(T__9);
				setState(142);
				formula(0);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(143);
					match(T__0);
					setState(144);
					formula(0);
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(150);
				match(T__10);
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				match(INT);
				}
				break;
			case 9:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(179);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(177);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(156);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(157);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(158);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(159);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(160);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(161);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(162);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(163);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(164);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(165);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(166);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(167);
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(168);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(169);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(170);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(171);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(172);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(173);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(174);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(175);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(176);
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(181);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		enterRule(_localctx, 14, RULE_qformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(183);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).qVar.add(((QformulaContext)_localctx).ID);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(184);
				match(T__0);
				setState(185);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).qVar.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(191);
			match(T__45);
			setState(192);
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
		public RuleElimContext ruleElim() {
			return getRuleContext(RuleElimContext.class,0);
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
		public RuleIntroContext ruleIntro() {
			return getRuleContext(RuleIntroContext.class,0);
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
		public RuleIntroContext ruleIntro() {
			return getRuleContext(RuleIntroContext.class,0);
		}
		public AndIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ForallIntroContext extends JustificationContext {
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public RuleIntroContext ruleIntro() {
			return getRuleContext(RuleIntroContext.class,0);
		}
		public ForallIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ImpliesElimContext extends JustificationContext {
		public Token impliesStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public RuleElimContext ruleElim() {
			return getRuleContext(RuleElimContext.class,0);
		}
		public ImpliesElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class PremiseContext extends JustificationContext {
		public PremiseContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndElim2Context extends JustificationContext {
		public Token andStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public RuleElim2Context ruleElim2() {
			return getRuleContext(RuleElim2Context.class,0);
		}
		public AndElim2Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class OrIntro2Context extends JustificationContext {
		public Token orStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public RuleIntro2Context ruleIntro2() {
			return getRuleContext(RuleIntro2Context.class,0);
		}
		public OrIntro2Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class NegIntroContext extends JustificationContext {
		public Token step;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public RuleIntroContext ruleIntro() {
			return getRuleContext(RuleIntroContext.class,0);
		}
		public NegIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class NegElimContext extends JustificationContext {
		public Token step;
		public Token notStep;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public RuleElimContext ruleElim() {
			return getRuleContext(RuleElimContext.class,0);
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
		public RuleIntro1Context ruleIntro1() {
			return getRuleContext(RuleIntro1Context.class,0);
		}
		public OrIntro1Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndElim1Context extends JustificationContext {
		public Token andStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public RuleElim1Context ruleElim1() {
			return getRuleContext(RuleElim1Context.class,0);
		}
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
		public RuleElimContext ruleElim() {
			return getRuleContext(RuleElimContext.class,0);
		}
		public ExistsContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class BottomElimContext extends JustificationContext {
		public Token bottomStep;
		public RuleElimContext ruleElim() {
			return getRuleContext(RuleElimContext.class,0);
		}
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
		public RuleElimContext ruleElim() {
			return getRuleContext(RuleElimContext.class,0);
		}
		public OrElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ImpliesIntroContext extends JustificationContext {
		public Token impliesStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public RuleIntroContext ruleIntro() {
			return getRuleContext(RuleIntroContext.class,0);
		}
		public ImpliesIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}

	public final JustificationContext justification() throws RecognitionException {
		JustificationContext _localctx = new JustificationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_justification);
		int _la;
		try {
			int _alt;
			setState(318);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(T__46);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				switch (_input.LA(1)) {
				case T__47:
					{
					setState(195);
					match(T__47);
					}
					break;
				case T__31:
				case T__32:
					{
					setState(196);
					_la = _input.LA(1);
					if ( !(_la==T__31 || _la==T__32) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(197);
					ruleIntro();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(200);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(201);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElim1Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				switch (_input.LA(1)) {
				case T__48:
					{
					setState(202);
					match(T__48);
					}
					break;
				case T__31:
				case T__32:
					{
					setState(203);
					_la = _input.LA(1);
					if ( !(_la==T__31 || _la==T__32) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(204);
					ruleElim1();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(207);
				((AndElim1Context)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new AndElim2Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(211);
				switch (_input.LA(1)) {
				case T__49:
					{
					setState(208);
					match(T__49);
					}
					break;
				case T__31:
				case T__32:
					{
					setState(209);
					_la = _input.LA(1);
					if ( !(_la==T__31 || _la==T__32) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(210);
					ruleElim2();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(213);
				((AndElim2Context)_localctx).andStep = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrIntro1Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(217);
				switch (_input.LA(1)) {
				case T__50:
					{
					setState(214);
					match(T__50);
					}
					break;
				case T__34:
				case T__35:
					{
					setState(215);
					_la = _input.LA(1);
					if ( !(_la==T__34 || _la==T__35) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(216);
					ruleIntro1();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(219);
				((OrIntro1Context)_localctx).orStep = match(NUM);
				}
				break;
			case 6:
				_localctx = new OrIntro2Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(223);
				switch (_input.LA(1)) {
				case T__51:
					{
					setState(220);
					match(T__51);
					}
					break;
				case T__34:
				case T__35:
					{
					setState(221);
					_la = _input.LA(1);
					if ( !(_la==T__34 || _la==T__35) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(222);
					ruleIntro2();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(225);
				((OrIntro2Context)_localctx).orStep = match(NUM);
				}
				break;
			case 7:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(229);
				switch (_input.LA(1)) {
				case T__52:
					{
					setState(226);
					match(T__52);
					}
					break;
				case T__34:
				case T__35:
					{
					setState(227);
					_la = _input.LA(1);
					if ( !(_la==T__34 || _la==T__35) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(228);
					ruleElim();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(231);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(232);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(233);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 8:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(237);
				switch (_input.LA(1)) {
				case T__53:
					{
					setState(234);
					match(T__53);
					}
					break;
				case T__37:
				case T__38:
					{
					setState(235);
					_la = _input.LA(1);
					if ( !(_la==T__37 || _la==T__38) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(236);
					ruleIntro();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(239);
				((ImpliesIntroContext)_localctx).impliesStep = match(NUM);
				}
				break;
			case 9:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(243);
				switch (_input.LA(1)) {
				case T__54:
					{
					setState(240);
					match(T__54);
					}
					break;
				case T__37:
				case T__38:
					{
					setState(241);
					_la = _input.LA(1);
					if ( !(_la==T__37 || _la==T__38) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(242);
					ruleElim();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(245);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(249);
				switch (_input.LA(1)) {
				case T__55:
					{
					setState(246);
					match(T__55);
					}
					break;
				case T__27:
				case T__28:
				case T__29:
					{
					setState(247);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(248);
					ruleIntro();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(251);
				((NegIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 11:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(255);
				switch (_input.LA(1)) {
				case T__56:
					{
					setState(252);
					match(T__56);
					}
					break;
				case T__27:
				case T__28:
				case T__29:
					{
					setState(253);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(254);
					ruleElim();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(257);
				((NegElimContext)_localctx).step = match(NUM);
				setState(258);
				((NegElimContext)_localctx).notStep = match(NUM);
				}
				break;
			case 12:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(259);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(260);
				ruleElim();
				setState(261);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 13:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(263);
				match(T__57);
				setState(264);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 14:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(269);
				switch (_input.LA(1)) {
				case T__58:
					{
					setState(265);
					match(T__58);
					}
					break;
				case T__59:
					{
					setState(266);
					match(T__59);
					}
					break;
				case T__41:
					{
					setState(267);
					match(T__41);
					setState(268);
					ruleIntro();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(271);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 15:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(276);
				switch (_input.LA(1)) {
				case T__60:
					{
					setState(272);
					match(T__60);
					}
					break;
				case T__61:
					{
					setState(273);
					match(T__61);
					}
					break;
				case T__41:
					{
					setState(274);
					match(T__41);
					setState(275);
					ruleElim();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(278);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
				setState(280); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(279);
						((ForallElimContext)_localctx).numOrId = numOrId();
						((ForallElimContext)_localctx).args.add(((ForallElimContext)_localctx).numOrId);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(282); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 16:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(288);
				switch (_input.LA(1)) {
				case T__62:
					{
					setState(284);
					match(T__62);
					}
					break;
				case T__63:
					{
					setState(285);
					match(T__63);
					}
					break;
				case T__44:
					{
					setState(286);
					match(T__44);
					setState(287);
					ruleIntro();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(290);
				((ExistsIntroContext)_localctx).stepOrFact = numOrId();
				setState(292); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(291);
					((ExistsIntroContext)_localctx).ID = match(ID);
					((ExistsIntroContext)_localctx).args.add(((ExistsIntroContext)_localctx).ID);
					}
					}
					setState(294); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				}
				break;
			case 17:
				_localctx = new ExistsContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(300);
				switch (_input.LA(1)) {
				case T__64:
					{
					setState(296);
					match(T__64);
					}
					break;
				case T__65:
					{
					setState(297);
					match(T__65);
					}
					break;
				case T__44:
					{
					setState(298);
					match(T__44);
					setState(299);
					ruleElim();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(302);
				((ExistsContext)_localctx).existsStep = match(NUM);
				setState(303);
				((ExistsContext)_localctx).subproof = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(304);
				match(T__66);
				setState(308);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(305);
						((AlgebraContext)_localctx).NUM = match(NUM);
						((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).NUM);
						}
						} 
					}
					setState(310);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				}
				break;
			case 19:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(311);
				match(T__67);
				setState(315);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(312);
						((AutoContext)_localctx).numOrId = numOrId();
						((AutoContext)_localctx).stepOrFact.add(((AutoContext)_localctx).numOrId);
						}
						} 
					}
					setState(317);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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

	public static class RuleIntroContext extends ParserRuleContext {
		public Token i;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public RuleIntroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleIntro; }
	}

	public final RuleIntroContext ruleIntro() throws RecognitionException {
		RuleIntroContext _localctx = new RuleIntroContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ruleIntro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			((RuleIntroContext)_localctx).i = match(ID);
			setState(321);
			if (!( "i".equals((((RuleIntroContext)_localctx).i!=null?((RuleIntroContext)_localctx).i.getText():null)) )) throw new FailedPredicateException(this, " \"i\".equals($i.text) ");
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

	public static class RuleIntro1Context extends ParserRuleContext {
		public Token i1;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public RuleIntro1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleIntro1; }
	}

	public final RuleIntro1Context ruleIntro1() throws RecognitionException {
		RuleIntro1Context _localctx = new RuleIntro1Context(_ctx, getState());
		enterRule(_localctx, 20, RULE_ruleIntro1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			((RuleIntro1Context)_localctx).i1 = match(ID);
			setState(324);
			if (!( "i1".equals((((RuleIntro1Context)_localctx).i1!=null?((RuleIntro1Context)_localctx).i1.getText():null)) )) throw new FailedPredicateException(this, " \"i1\".equals($i1.text) ");
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

	public static class RuleIntro2Context extends ParserRuleContext {
		public Token i2;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public RuleIntro2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleIntro2; }
	}

	public final RuleIntro2Context ruleIntro2() throws RecognitionException {
		RuleIntro2Context _localctx = new RuleIntro2Context(_ctx, getState());
		enterRule(_localctx, 22, RULE_ruleIntro2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			((RuleIntro2Context)_localctx).i2 = match(ID);
			setState(327);
			if (!( "i2".equals((((RuleIntro2Context)_localctx).i2!=null?((RuleIntro2Context)_localctx).i2.getText():null)) )) throw new FailedPredicateException(this, " \"i2\".equals($i2.text) ");
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

	public static class RuleElimContext extends ParserRuleContext {
		public Token e;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public RuleElimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleElim; }
	}

	public final RuleElimContext ruleElim() throws RecognitionException {
		RuleElimContext _localctx = new RuleElimContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ruleElim);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			((RuleElimContext)_localctx).e = match(ID);
			setState(330);
			if (!( "e".equals((((RuleElimContext)_localctx).e!=null?((RuleElimContext)_localctx).e.getText():null)) )) throw new FailedPredicateException(this, " \"e\".equals($e.text) ");
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

	public static class RuleElim1Context extends ParserRuleContext {
		public Token e1;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public RuleElim1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleElim1; }
	}

	public final RuleElim1Context ruleElim1() throws RecognitionException {
		RuleElim1Context _localctx = new RuleElim1Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_ruleElim1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			((RuleElim1Context)_localctx).e1 = match(ID);
			setState(333);
			if (!( "e1".equals((((RuleElim1Context)_localctx).e1!=null?((RuleElim1Context)_localctx).e1.getText():null)) )) throw new FailedPredicateException(this, " \"e1\".equals($e1.text) ");
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

	public static class RuleElim2Context extends ParserRuleContext {
		public Token e2;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public RuleElim2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleElim2; }
	}

	public final RuleElim2Context ruleElim2() throws RecognitionException {
		RuleElim2Context _localctx = new RuleElim2Context(_ctx, getState());
		enterRule(_localctx, 28, RULE_ruleElim2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			((RuleElim2Context)_localctx).e2 = match(ID);
			setState(336);
			if (!( "e2".equals((((RuleElim2Context)_localctx).e2!=null?((RuleElim2Context)_localctx).e2.getText():null)) )) throw new FailedPredicateException(this, " \"e2\".equals($e2.text) ");
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
		enterRule(_localctx, 30, RULE_numOrId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
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
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(T__68);
			setState(341);
			((ProgramContext)_localctx).org = match(ID);
			setState(342);
			match(T__5);
			setState(343);
			((ProgramContext)_localctx).sireum = match(ID);
			setState(344);
			match(T__5);
			setState(345);
			((ProgramContext)_localctx).logika = match(ID);
			setState(346);
			match(T__5);
			setState(347);
			match(T__69);
			setState(348);
			stmts();
			setState(349);
			if (!( "org".equals((((ProgramContext)_localctx).org!=null?((ProgramContext)_localctx).org.getText():null)) &&
			      "sireum".equals((((ProgramContext)_localctx).sireum!=null?((ProgramContext)_localctx).sireum.getText():null)) &&
			      "logika".equals((((ProgramContext)_localctx).logika!=null?((ProgramContext)_localctx).logika.getText():null)) )) throw new FailedPredicateException(this, " \"org\".equals($org.text) &&\n      \"sireum\".equals($sireum.text) &&\n      \"logika\".equals($logika.text) ");
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(351);
				stmt();
				}
				break;
			}
			setState(367);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(360);
					switch (_input.LA(1)) {
					case T__70:
						{
						setState(354);
						match(T__70);
						}
						break;
					case NL:
						{
						setState(356); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(355);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(358); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(363);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						setState(362);
						stmt();
						}
						break;
					}
					}
					} 
				}
				setState(369);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
		enterRule(_localctx, 36, RULE_stmt);
		int _la;
		try {
			setState(477);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(370);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__71 || _la==T__72) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(371);
				match(ID);
				setState(372);
				match(T__73);
				setState(373);
				type();
				setState(374);
				match(T__74);
				setState(375);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				match(ID);
				setState(378);
				match(T__74);
				setState(379);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(380);
				match(T__75);
				setState(381);
				match(T__9);
				setState(382);
				exp(0);
				setState(383);
				match(T__10);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(385);
				match(T__76);
				setState(386);
				match(T__9);
				setState(387);
				exp(0);
				setState(388);
				match(T__10);
				setState(392);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(389);
					match(NL);
					}
					}
					setState(394);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(395);
				match(T__3);
				setState(396);
				((IfStmtContext)_localctx).ts = stmts();
				setState(397);
				match(T__4);
				setState(398);
				match(T__77);
				setState(399);
				match(T__3);
				setState(400);
				((IfStmtContext)_localctx).fs = stmts();
				setState(401);
				match(T__4);
				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(403);
				match(T__78);
				setState(404);
				match(T__9);
				setState(405);
				exp(0);
				setState(406);
				match(T__10);
				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(407);
					match(NL);
					}
					}
					setState(412);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(413);
				match(T__3);
				setState(419);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(414);
					match(T__79);
					setState(415);
					match(T__80);
					setState(416);
					loopInvariant();
					setState(417);
					match(T__80);
					}
					break;
				}
				setState(421);
				stmts();
				setState(422);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new ReadIntStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(424);
				match(ID);
				setState(425);
				match(T__74);
				setState(426);
				match(T__81);
				setState(427);
				match(T__9);
				setState(429);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(428);
					match(STRING);
					}
				}

				setState(431);
				match(T__10);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(432);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__82 || _la==T__83) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(433);
				match(T__9);
				setState(434);
				match(T__84);
				setState(435);
				match(STRING);
				setState(436);
				match(T__10);
				}
				break;
			case 8:
				_localctx = new MethodInvocationStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(439);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(437);
					((MethodInvocationStmtContext)_localctx).l = match(ID);
					setState(438);
					match(T__74);
					}
					break;
				}
				setState(441);
				((MethodInvocationStmtContext)_localctx).r = match(ID);
				setState(442);
				match(T__9);
				setState(451);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__16) | (1L << T__27))) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__88 - 87)) | (1L << (T__89 - 87)) | (1L << (INT - 87)) | (1L << (ID - 87)))) != 0)) {
					{
					setState(443);
					exp(0);
					setState(448);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(444);
						match(T__0);
						setState(445);
						exp(0);
						}
						}
						setState(450);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(453);
				match(T__10);
				}
				break;
			case 9:
				_localctx = new SeqCloneStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(454);
				match(ID);
				setState(455);
				match(T__74);
				setState(456);
				match(ID);
				setState(457);
				match(T__5);
				setState(458);
				match(T__85);
				}
				break;
			case 10:
				_localctx = new AssignArrayStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(459);
				match(ID);
				setState(460);
				match(T__9);
				setState(461);
				exp(0);
				setState(462);
				match(T__10);
				setState(463);
				match(T__74);
				setState(464);
				exp(0);
				}
				break;
			case 11:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(466);
				methodDecl();
				}
				break;
			case 12:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(467);
				match(T__79);
				setState(468);
				match(T__80);
				setState(473);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(469);
					proof();
					}
					break;
				case 2:
					{
					setState(470);
					sequent();
					}
					break;
				case 3:
					{
					setState(471);
					invariants();
					}
					break;
				case 4:
					{
					setState(472);
					facts();
					}
					break;
				}
				setState(475);
				match(T__80);
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			switch (_input.LA(1)) {
			case T__16:
			case T__27:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(480);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__27) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(481);
				exp(7);
				}
				break;
			case T__86:
				{
				_localctx = new TrueExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(482);
				match(T__86);
				}
				break;
			case T__87:
				{
				_localctx = new FalseExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(483);
				match(T__87);
				}
				break;
			case INT:
				{
				_localctx = new IntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(484);
				match(INT);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(485);
				match(ID);
				setState(490);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(486);
					match(T__9);
					setState(487);
					exp(0);
					setState(488);
					match(T__10);
					}
					break;
				}
				}
				break;
			case T__88:
				{
				_localctx = new BigIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(492);
				match(T__88);
				setState(493);
				match(T__9);
				setState(494);
				match(STRING);
				setState(495);
				match(T__10);
				}
				break;
			case T__89:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(496);
				match(T__89);
				setState(497);
				match(T__9);
				setState(498);
				exp(0);
				setState(501);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(499);
					match(T__0);
					setState(500);
					exp(0);
					}
				}

				setState(503);
				match(T__10);
				}
				break;
			case T__9:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(505);
				match(T__9);
				setState(506);
				exp(0);
				setState(507);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(549);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(547);
					switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(511);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(512);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(514);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(513);
							match(NL);
							}
						}

						setState(516);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(517);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(518);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(520);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(519);
							match(NL);
							}
						}

						setState(522);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(523);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(524);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(526);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(525);
							match(NL);
							}
						}

						setState(528);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(529);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(530);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(532);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(531);
							match(NL);
							}
						}

						setState(534);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(535);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(536);
						match(T__31);
						}
						setState(538);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(537);
							match(NL);
							}
						}

						setState(540);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(541);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(542);
						match(T__34);
						}
						setState(544);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(543);
							match(NL);
							}
						}

						setState(546);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(551);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
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
		enterRule(_localctx, 40, RULE_type);
		int _la;
		try {
			setState(570);
			switch (_input.LA(1)) {
			case T__90:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(552);
				match(T__90);
				}
				break;
			case T__88:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(553);
				match(T__88);
				}
				break;
			case T__89:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(554);
				match(T__89);
				setState(555);
				match(T__91);
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(556);
					match(NL);
					}
					}
					setState(561);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(562);
				match(T__88);
				setState(566);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(563);
					match(NL);
					}
					}
					setState(568);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(569);
				match(T__92);
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
		enterRule(_localctx, 42, RULE_loopInvariant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			match(T__3);
			setState(573);
			match(T__93);
			setState(574);
			formula(0);
			setState(575);
			modifies();
			setState(576);
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
		enterRule(_localctx, 44, RULE_modifies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			match(T__94);
			setState(593);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(582);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(579);
					match(ID);
					}
					}
					setState(584);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(585);
				match(ID);
				setState(590);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(586);
					match(T__0);
					setState(587);
					match(ID);
					}
					}
					setState(592);
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
		enterRule(_localctx, 46, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			match(T__95);
			setState(596);
			match(ID);
			setState(598);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(597);
				match(NL);
				}
			}

			setState(600);
			match(T__9);
			setState(609);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(601);
				param();
				setState(606);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(602);
					match(T__0);
					setState(603);
					param();
					}
					}
					setState(608);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(611);
			match(T__10);
			setState(612);
			match(T__73);
			setState(613);
			type();
			setState(614);
			match(T__74);
			setState(615);
			match(T__3);
			setState(621);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(616);
				match(T__79);
				setState(617);
				match(T__80);
				setState(618);
				methodContract();
				setState(619);
				match(T__80);
				}
				break;
			}
			setState(623);
			stmts();
			setState(624);
			match(T__96);
			setState(626);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__16) | (1L << T__27))) != 0) || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__88 - 87)) | (1L << (T__89 - 87)) | (1L << (INT - 87)) | (1L << (ID - 87)))) != 0)) {
				{
				setState(625);
				exp(0);
				}
			}

			setState(631);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(628);
				match(NL);
				}
				}
				setState(633);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(634);
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
		enterRule(_localctx, 48, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			match(ID);
			setState(637);
			match(T__73);
			setState(638);
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
		enterRule(_localctx, 50, RULE_methodContract);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			match(T__3);
			setState(643);
			_la = _input.LA(1);
			if (_la==T__97) {
				{
				setState(641);
				match(T__97);
				setState(642);
				formula(0);
				}
			}

			setState(646);
			_la = _input.LA(1);
			if (_la==T__94) {
				{
				setState(645);
				modifies();
				}
			}

			setState(650);
			_la = _input.LA(1);
			if (_la==T__98) {
				{
				setState(648);
				match(T__98);
				setState(649);
				formula(0);
				}
			}

			setState(652);
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
		enterRule(_localctx, 52, RULE_invariants);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(654);
			match(T__3);
			setState(655);
			match(T__93);
			setState(657); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(656);
				formula(0);
				}
				}
				setState(659); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0) || _la==INT || _la==ID );
			setState(661);
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
		enterRule(_localctx, 54, RULE_facts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663);
			match(T__3);
			setState(664);
			match(T__99);
			setState(666); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(665);
				fact();
				}
				}
				setState(668); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(670);
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
		enterRule(_localctx, 56, RULE_fact);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(672);
			match(ID);
			setState(673);
			match(T__5);
			setState(674);
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
		case 9:
			return ruleIntro_sempred((RuleIntroContext)_localctx, predIndex);
		case 10:
			return ruleIntro1_sempred((RuleIntro1Context)_localctx, predIndex);
		case 11:
			return ruleIntro2_sempred((RuleIntro2Context)_localctx, predIndex);
		case 12:
			return ruleElim_sempred((RuleElimContext)_localctx, predIndex);
		case 13:
			return ruleElim1_sempred((RuleElim1Context)_localctx, predIndex);
		case 14:
			return ruleElim2_sempred((RuleElim2Context)_localctx, predIndex);
		case 16:
			return program_sempred((ProgramContext)_localctx, predIndex);
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
	private boolean ruleIntro_sempred(RuleIntroContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return  "i".equals((((RuleIntroContext)_localctx).i!=null?((RuleIntroContext)_localctx).i.getText():null)) ;
		}
		return true;
	}
	private boolean ruleIntro1_sempred(RuleIntro1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return  "i1".equals((((RuleIntro1Context)_localctx).i1!=null?((RuleIntro1Context)_localctx).i1.getText():null)) ;
		}
		return true;
	}
	private boolean ruleIntro2_sempred(RuleIntro2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return  "i2".equals((((RuleIntro2Context)_localctx).i2!=null?((RuleIntro2Context)_localctx).i2.getText():null)) ;
		}
		return true;
	}
	private boolean ruleElim_sempred(RuleElimContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return  "e".equals((((RuleElimContext)_localctx).e!=null?((RuleElimContext)_localctx).e.getText():null)) ;
		}
		return true;
	}
	private boolean ruleElim1_sempred(RuleElim1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return  "e1".equals((((RuleElim1Context)_localctx).e1!=null?((RuleElim1Context)_localctx).e1.getText():null)) ;
		}
		return true;
	}
	private boolean ruleElim2_sempred(RuleElim2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return  "e2".equals((((RuleElim2Context)_localctx).e2!=null?((RuleElim2Context)_localctx).e2.getText():null)) ;
		}
		return true;
	}
	private boolean program_sempred(ProgramContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return  "org".equals((((ProgramContext)_localctx).org!=null?((ProgramContext)_localctx).org.getText():null)) &&
		      "sireum".equals((((ProgramContext)_localctx).sireum!=null?((ProgramContext)_localctx).sireum.getText():null)) &&
		      "logika".equals((((ProgramContext)_localctx).logika!=null?((ProgramContext)_localctx).logika.getText():null)) ;
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 6);
		case 15:
			return precpred(_ctx, 5);
		case 16:
			return precpred(_ctx, 4);
		case 17:
			return precpred(_ctx, 3);
		case 18:
			return precpred(_ctx, 2);
		case 19:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3q\u02a7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\5\2?\n\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\5\5K\n\5\3\5\7\5N\n\5\f\5\16\5"+
		"Q\13\5\5\5S\n\5\3\5\3\5\3\5\5\5X\n\5\3\5\7\5[\n\5\f\5\16\5^\13\5\3\6\3"+
		"\6\7\6b\n\6\f\6\16\6e\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7s\n\7\3\7\3\7\3\7\5\7x\n\7\3\7\7\7{\n\7\f\7\16\7~\13\7\3\7\5\7"+
		"\u0081\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\7\b\u0094\n\b\f\b\16\b\u0097\13\b\3\b\3\b\3\b\3\b\5\b\u009d\n"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\7\b\u00b4\n\b\f\b\16\b\u00b7\13\b\3\t\3\t\3\t\3\t\7\t"+
		"\u00bd\n\t\f\t\16\t\u00c0\13\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u00c9\n"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u00d0\n\n\3\n\3\n\3\n\3\n\5\n\u00d6\n\n\3\n"+
		"\3\n\3\n\3\n\5\n\u00dc\n\n\3\n\3\n\3\n\3\n\5\n\u00e2\n\n\3\n\3\n\3\n\3"+
		"\n\5\n\u00e8\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00f0\n\n\3\n\3\n\3\n\3\n"+
		"\5\n\u00f6\n\n\3\n\3\n\3\n\3\n\5\n\u00fc\n\n\3\n\3\n\3\n\3\n\5\n\u0102"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0110\n\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\n\u0117\n\n\3\n\3\n\6\n\u011b\n\n\r\n\16\n\u011c\3"+
		"\n\3\n\3\n\3\n\5\n\u0123\n\n\3\n\3\n\6\n\u0127\n\n\r\n\16\n\u0128\3\n"+
		"\3\n\3\n\3\n\5\n\u012f\n\n\3\n\3\n\3\n\3\n\7\n\u0135\n\n\f\n\16\n\u0138"+
		"\13\n\3\n\3\n\7\n\u013c\n\n\f\n\16\n\u013f\13\n\5\n\u0141\n\n\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\5\23\u0163\n\23\3\23\3\23\6\23\u0167\n\23\r\23\16\23\u0168\5\23"+
		"\u016b\n\23\3\23\5\23\u016e\n\23\7\23\u0170\n\23\f\23\16\23\u0173\13\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0189\n\24\f\24\16\24\u018c\13\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24"+
		"\u019b\n\24\f\24\16\24\u019e\13\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u01a6\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u01b0\n\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u01ba\n\24\3\24\3\24\3\24"+
		"\3\24\3\24\7\24\u01c1\n\24\f\24\16\24\u01c4\13\24\5\24\u01c6\n\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u01dc\n\24\3\24\3\24\5\24\u01e0\n\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u01ed\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u01f8\n\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u0200\n\25\3\25\3\25\3\25\5\25\u0205\n\25\3"+
		"\25\3\25\3\25\3\25\5\25\u020b\n\25\3\25\3\25\3\25\3\25\5\25\u0211\n\25"+
		"\3\25\3\25\3\25\3\25\5\25\u0217\n\25\3\25\3\25\3\25\3\25\5\25\u021d\n"+
		"\25\3\25\3\25\3\25\3\25\5\25\u0223\n\25\3\25\7\25\u0226\n\25\f\25\16\25"+
		"\u0229\13\25\3\26\3\26\3\26\3\26\3\26\7\26\u0230\n\26\f\26\16\26\u0233"+
		"\13\26\3\26\3\26\7\26\u0237\n\26\f\26\16\26\u023a\13\26\3\26\5\26\u023d"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\7\30\u0247\n\30\f\30\16"+
		"\30\u024a\13\30\3\30\3\30\3\30\7\30\u024f\n\30\f\30\16\30\u0252\13\30"+
		"\5\30\u0254\n\30\3\31\3\31\3\31\5\31\u0259\n\31\3\31\3\31\3\31\3\31\7"+
		"\31\u025f\n\31\f\31\16\31\u0262\13\31\5\31\u0264\n\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0270\n\31\3\31\3\31\3\31\5\31"+
		"\u0275\n\31\3\31\7\31\u0278\n\31\f\31\16\31\u027b\13\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\5\33\u0286\n\33\3\33\5\33\u0289\n\33\3"+
		"\33\3\33\5\33\u028d\n\33\3\33\3\33\3\34\3\34\3\34\6\34\u0294\n\34\r\34"+
		"\16\34\u0295\3\34\3\34\3\35\3\35\3\35\6\35\u029d\n\35\r\35\16\35\u029e"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\2\4\16(\37\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\27\4\2\4\5gg\3\2\35 \3\2\n\13"+
		"\3\2\17\21\3\2\22\23\3\2\24\31\3\2\32\34\3\2!#\3\2$&\3\2\')\3\2*/\3\2"+
		"\"#\3\2%&\3\2()\3\2\36 \3\2ij\3\2JK\3\2UV\4\2\23\23\36\36\4\2\24\25\27"+
		"\30\3\2\32\33\u030e\2<\3\2\2\2\4B\3\2\2\2\6E\3\2\2\2\bR\3\2\2\2\n_\3\2"+
		"\2\2\f\u0080\3\2\2\2\16\u009c\3\2\2\2\20\u00b8\3\2\2\2\22\u0140\3\2\2"+
		"\2\24\u0142\3\2\2\2\26\u0145\3\2\2\2\30\u0148\3\2\2\2\32\u014b\3\2\2\2"+
		"\34\u014e\3\2\2\2\36\u0151\3\2\2\2 \u0154\3\2\2\2\"\u0156\3\2\2\2$\u0162"+
		"\3\2\2\2&\u01df\3\2\2\2(\u01ff\3\2\2\2*\u023c\3\2\2\2,\u023e\3\2\2\2."+
		"\u0244\3\2\2\2\60\u0255\3\2\2\2\62\u027e\3\2\2\2\64\u0282\3\2\2\2\66\u0290"+
		"\3\2\2\28\u0299\3\2\2\2:\u02a2\3\2\2\2<>\5\b\5\2=?\5\n\6\2>=\3\2\2\2>"+
		"?\3\2\2\2?@\3\2\2\2@A\7\2\2\3A\3\3\2\2\2BC\5\n\6\2CD\7\2\2\3D\5\3\2\2"+
		"\2EF\5\"\22\2FG\7\2\2\3G\7\3\2\2\2HO\5\16\b\2IK\7\3\2\2JI\3\2\2\2JK\3"+
		"\2\2\2KL\3\2\2\2LN\5\16\b\2MJ\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PS"+
		"\3\2\2\2QO\3\2\2\2RH\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\t\2\2\2U\\\5\16\b\2"+
		"VX\7\3\2\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2Y[\5\16\b\2ZW\3\2\2\2[^\3\2\2"+
		"\2\\Z\3\2\2\2\\]\3\2\2\2]\t\3\2\2\2^\\\3\2\2\2_c\7\6\2\2`b\5\f\7\2a`\3"+
		"\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\7\7\2\2g\13"+
		"\3\2\2\2hi\7i\2\2ij\7\b\2\2jk\5\16\b\2kl\5\22\n\2l\u0081\3\2\2\2mn\7\6"+
		"\2\2no\7i\2\2ow\7\b\2\2px\7j\2\2qs\7j\2\2rq\3\2\2\2rs\3\2\2\2st\3\2\2"+
		"\2tu\5\16\b\2uv\7\t\2\2vx\3\2\2\2wp\3\2\2\2wr\3\2\2\2x|\3\2\2\2y{\5\f"+
		"\7\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177"+
		"\u0081\7\7\2\2\u0080h\3\2\2\2\u0080m\3\2\2\2\u0081\r\3\2\2\2\u0082\u0083"+
		"\b\b\1\2\u0083\u0084\7\23\2\2\u0084\u009d\5\16\b\b\u0085\u0086\t\3\2\2"+
		"\u0086\u009d\5\16\b\7\u0087\u009d\t\4\2\2\u0088\u009d\7j\2\2\u0089\u008a"+
		"\7\f\2\2\u008a\u008b\5\16\b\2\u008b\u008c\7\r\2\2\u008c\u009d\3\2\2\2"+
		"\u008d\u009d\7\16\2\2\u008e\u008f\7j\2\2\u008f\u0090\7\f\2\2\u0090\u0095"+
		"\5\16\b\2\u0091\u0092\7\3\2\2\u0092\u0094\5\16\b\2\u0093\u0091\3\2\2\2"+
		"\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098"+
		"\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\7\r\2\2\u0099\u009d\3\2\2\2\u009a"+
		"\u009d\7h\2\2\u009b\u009d\5\20\t\2\u009c\u0082\3\2\2\2\u009c\u0085\3\2"+
		"\2\2\u009c\u0087\3\2\2\2\u009c\u0088\3\2\2\2\u009c\u0089\3\2\2\2\u009c"+
		"\u008d\3\2\2\2\u009c\u008e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2"+
		"\2\2\u009d\u00b5\3\2\2\2\u009e\u009f\f\f\2\2\u009f\u00a0\t\5\2\2\u00a0"+
		"\u00b4\5\16\b\r\u00a1\u00a2\f\13\2\2\u00a2\u00a3\t\6\2\2\u00a3\u00b4\5"+
		"\16\b\f\u00a4\u00a5\f\n\2\2\u00a5\u00a6\t\7\2\2\u00a6\u00b4\5\16\b\13"+
		"\u00a7\u00a8\f\t\2\2\u00a8\u00a9\t\b\2\2\u00a9\u00b4\5\16\b\n\u00aa\u00ab"+
		"\f\6\2\2\u00ab\u00ac\t\t\2\2\u00ac\u00b4\5\16\b\7\u00ad\u00ae\f\5\2\2"+
		"\u00ae\u00af\t\n\2\2\u00af\u00b4\5\16\b\6\u00b0\u00b1\f\4\2\2\u00b1\u00b2"+
		"\t\13\2\2\u00b2\u00b4\5\16\b\5\u00b3\u009e\3\2\2\2\u00b3\u00a1\3\2\2\2"+
		"\u00b3\u00a4\3\2\2\2\u00b3\u00a7\3\2\2\2\u00b3\u00aa\3\2\2\2\u00b3\u00ad"+
		"\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\17\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\t\f\2"+
		"\2\u00b9\u00be\7j\2\2\u00ba\u00bb\7\3\2\2\u00bb\u00bd\7j\2\2\u00bc\u00ba"+
		"\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7\60\2\2\u00c2\u00c3\5"+
		"\16\b\2\u00c3\21\3\2\2\2\u00c4\u0141\7\61\2\2\u00c5\u00c9\7\62\2\2\u00c6"+
		"\u00c7\t\r\2\2\u00c7\u00c9\5\24\13\2\u00c8\u00c5\3\2\2\2\u00c8\u00c6\3"+
		"\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\7i\2\2\u00cb\u0141\7i\2\2\u00cc"+
		"\u00d0\7\63\2\2\u00cd\u00ce\t\r\2\2\u00ce\u00d0\5\34\17\2\u00cf\u00cc"+
		"\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u0141\7i\2\2\u00d2"+
		"\u00d6\7\64\2\2\u00d3\u00d4\t\r\2\2\u00d4\u00d6\5\36\20\2\u00d5\u00d2"+
		"\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u0141\7i\2\2\u00d8"+
		"\u00dc\7\65\2\2\u00d9\u00da\t\16\2\2\u00da\u00dc\5\26\f\2\u00db\u00d8"+
		"\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u0141\7i\2\2\u00de"+
		"\u00e2\7\66\2\2\u00df\u00e0\t\16\2\2\u00e0\u00e2\5\30\r\2\u00e1\u00de"+
		"\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u0141\7i\2\2\u00e4"+
		"\u00e8\7\67\2\2\u00e5\u00e6\t\16\2\2\u00e6\u00e8\5\32\16\2\u00e7\u00e4"+
		"\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\7i\2\2\u00ea"+
		"\u00eb\7i\2\2\u00eb\u0141\7i\2\2\u00ec\u00f0\78\2\2\u00ed\u00ee\t\17\2"+
		"\2\u00ee\u00f0\5\24\13\2\u00ef\u00ec\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u0141\7i\2\2\u00f2\u00f6\79\2\2\u00f3\u00f4\t\17"+
		"\2\2\u00f4\u00f6\5\32\16\2\u00f5\u00f2\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u0141\7i\2\2\u00f8\u00fc\7:\2\2\u00f9\u00fa\t\20"+
		"\2\2\u00fa\u00fc\5\24\13\2\u00fb\u00f8\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fd\u0141\7i\2\2\u00fe\u0102\7;\2\2\u00ff\u0100\t\20"+
		"\2\2\u0100\u0102\5\32\16\2\u0101\u00fe\3\2\2\2\u0101\u00ff\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u0104\7i\2\2\u0104\u0141\7i\2\2\u0105\u0106\t\4\2"+
		"\2\u0106\u0107\5\32\16\2\u0107\u0108\7i\2\2\u0108\u0141\3\2\2\2\u0109"+
		"\u010a\7<\2\2\u010a\u0141\7i\2\2\u010b\u0110\7=\2\2\u010c\u0110\7>\2\2"+
		"\u010d\u010e\7,\2\2\u010e\u0110\5\24\13\2\u010f\u010b\3\2\2\2\u010f\u010c"+
		"\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0141\7i\2\2\u0112"+
		"\u0117\7?\2\2\u0113\u0117\7@\2\2\u0114\u0115\7,\2\2\u0115\u0117\5\32\16"+
		"\2\u0116\u0112\3\2\2\2\u0116\u0113\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u0118"+
		"\3\2\2\2\u0118\u011a\5 \21\2\u0119\u011b\5 \21\2\u011a\u0119\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0141\3\2"+
		"\2\2\u011e\u0123\7A\2\2\u011f\u0123\7B\2\2\u0120\u0121\7/\2\2\u0121\u0123"+
		"\5\24\13\2\u0122\u011e\3\2\2\2\u0122\u011f\3\2\2\2\u0122\u0120\3\2\2\2"+
		"\u0123\u0124\3\2\2\2\u0124\u0126\5 \21\2\u0125\u0127\7j\2\2\u0126\u0125"+
		"\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\u0141\3\2\2\2\u012a\u012f\7C\2\2\u012b\u012f\7D\2\2\u012c\u012d\7/\2"+
		"\2\u012d\u012f\5\32\16\2\u012e\u012a\3\2\2\2\u012e\u012b\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\7i\2\2\u0131\u0141\7i\2"+
		"\2\u0132\u0136\7E\2\2\u0133\u0135\7i\2\2\u0134\u0133\3\2\2\2\u0135\u0138"+
		"\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0141\3\2\2\2\u0138"+
		"\u0136\3\2\2\2\u0139\u013d\7F\2\2\u013a\u013c\5 \21\2\u013b\u013a\3\2"+
		"\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u00c4\3\2\2\2\u0140\u00c8\3\2"+
		"\2\2\u0140\u00cf\3\2\2\2\u0140\u00d5\3\2\2\2\u0140\u00db\3\2\2\2\u0140"+
		"\u00e1\3\2\2\2\u0140\u00e7\3\2\2\2\u0140\u00ef\3\2\2\2\u0140\u00f5\3\2"+
		"\2\2\u0140\u00fb\3\2\2\2\u0140\u0101\3\2\2\2\u0140\u0105\3\2\2\2\u0140"+
		"\u0109\3\2\2\2\u0140\u010f\3\2\2\2\u0140\u0116\3\2\2\2\u0140\u0122\3\2"+
		"\2\2\u0140\u012e\3\2\2\2\u0140\u0132\3\2\2\2\u0140\u0139\3\2\2\2\u0141"+
		"\23\3\2\2\2\u0142\u0143\7j\2\2\u0143\u0144\6\13\t\3\u0144\25\3\2\2\2\u0145"+
		"\u0146\7j\2\2\u0146\u0147\6\f\n\3\u0147\27\3\2\2\2\u0148\u0149\7j\2\2"+
		"\u0149\u014a\6\r\13\3\u014a\31\3\2\2\2\u014b\u014c\7j\2\2\u014c\u014d"+
		"\6\16\f\3\u014d\33\3\2\2\2\u014e\u014f\7j\2\2\u014f\u0150\6\17\r\3\u0150"+
		"\35\3\2\2\2\u0151\u0152\7j\2\2\u0152\u0153\6\20\16\3\u0153\37\3\2\2\2"+
		"\u0154\u0155\t\21\2\2\u0155!\3\2\2\2\u0156\u0157\7G\2\2\u0157\u0158\7"+
		"j\2\2\u0158\u0159\7\b\2\2\u0159\u015a\7j\2\2\u015a\u015b\7\b\2\2\u015b"+
		"\u015c\7j\2\2\u015c\u015d\7\b\2\2\u015d\u015e\7H\2\2\u015e\u015f\5$\23"+
		"\2\u015f\u0160\6\22\17\3\u0160#\3\2\2\2\u0161\u0163\5&\24\2\u0162\u0161"+
		"\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0171\3\2\2\2\u0164\u016b\7I\2\2\u0165"+
		"\u0167\7n\2\2\u0166\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0166\3\2"+
		"\2\2\u0168\u0169\3\2\2\2\u0169\u016b\3\2\2\2\u016a\u0164\3\2\2\2\u016a"+
		"\u0166\3\2\2\2\u016b\u016d\3\2\2\2\u016c\u016e\5&\24\2\u016d\u016c\3\2"+
		"\2\2\u016d\u016e\3\2\2\2\u016e\u0170\3\2\2\2\u016f\u016a\3\2\2\2\u0170"+
		"\u0173\3\2\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172%\3\2\2\2"+
		"\u0173\u0171\3\2\2\2\u0174\u0175\t\22\2\2\u0175\u0176\7j\2\2\u0176\u0177"+
		"\7L\2\2\u0177\u0178\5*\26\2\u0178\u0179\7M\2\2\u0179\u017a\5(\25\2\u017a"+
		"\u01e0\3\2\2\2\u017b\u017c\7j\2\2\u017c\u017d\7M\2\2\u017d\u01e0\5(\25"+
		"\2\u017e\u017f\7N\2\2\u017f\u0180\7\f\2\2\u0180\u0181\5(\25\2\u0181\u0182"+
		"\7\r\2\2\u0182\u01e0\3\2\2\2\u0183\u0184\7O\2\2\u0184\u0185\7\f\2\2\u0185"+
		"\u0186\5(\25\2\u0186\u018a\7\r\2\2\u0187\u0189\7n\2\2\u0188\u0187\3\2"+
		"\2\2\u0189\u018c\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b"+
		"\u018d\3\2\2\2\u018c\u018a\3\2\2\2\u018d\u018e\7\6\2\2\u018e\u018f\5$"+
		"\23\2\u018f\u0190\7\7\2\2\u0190\u0191\7P\2\2\u0191\u0192\7\6\2\2\u0192"+
		"\u0193\5$\23\2\u0193\u0194\7\7\2\2\u0194\u01e0\3\2\2\2\u0195\u0196\7Q"+
		"\2\2\u0196\u0197\7\f\2\2\u0197\u0198\5(\25\2\u0198\u019c\7\r\2\2\u0199"+
		"\u019b\7n\2\2\u019a\u0199\3\2\2\2\u019b\u019e\3\2\2\2\u019c\u019a\3\2"+
		"\2\2\u019c\u019d\3\2\2\2\u019d\u019f\3\2\2\2\u019e\u019c\3\2\2\2\u019f"+
		"\u01a5\7\6\2\2\u01a0\u01a1\7R\2\2\u01a1\u01a2\7S\2\2\u01a2\u01a3\5,\27"+
		"\2\u01a3\u01a4\7S\2\2\u01a4\u01a6\3\2\2\2\u01a5\u01a0\3\2\2\2\u01a5\u01a6"+
		"\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a8\5$\23\2\u01a8\u01a9\7\7\2\2\u01a9"+
		"\u01e0\3\2\2\2\u01aa\u01ab\7j\2\2\u01ab\u01ac\7M\2\2\u01ac\u01ad\7T\2"+
		"\2\u01ad\u01af\7\f\2\2\u01ae\u01b0\7k\2\2\u01af\u01ae\3\2\2\2\u01af\u01b0"+
		"\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01e0\7\r\2\2\u01b2\u01b3\t\23\2\2"+
		"\u01b3\u01b4\7\f\2\2\u01b4\u01b5\7W\2\2\u01b5\u01b6\7k\2\2\u01b6\u01e0"+
		"\7\r\2\2\u01b7\u01b8\7j\2\2\u01b8\u01ba\7M\2\2\u01b9\u01b7\3\2\2\2\u01b9"+
		"\u01ba\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\7j\2\2\u01bc\u01c5\7\f"+
		"\2\2\u01bd\u01c2\5(\25\2\u01be\u01bf\7\3\2\2\u01bf\u01c1\5(\25\2\u01c0"+
		"\u01be\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2"+
		"\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01bd\3\2\2\2\u01c5"+
		"\u01c6\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01e0\7\r\2\2\u01c8\u01c9\7j"+
		"\2\2\u01c9\u01ca\7M\2\2\u01ca\u01cb\7j\2\2\u01cb\u01cc\7\b\2\2\u01cc\u01e0"+
		"\7X\2\2\u01cd\u01ce\7j\2\2\u01ce\u01cf\7\f\2\2\u01cf\u01d0\5(\25\2\u01d0"+
		"\u01d1\7\r\2\2\u01d1\u01d2\7M\2\2\u01d2\u01d3\5(\25\2\u01d3\u01e0\3\2"+
		"\2\2\u01d4\u01e0\5\60\31\2\u01d5\u01d6\7R\2\2\u01d6\u01db\7S\2\2\u01d7"+
		"\u01dc\5\n\6\2\u01d8\u01dc\5\b\5\2\u01d9\u01dc\5\66\34\2\u01da\u01dc\5"+
		"8\35\2\u01db\u01d7\3\2\2\2\u01db\u01d8\3\2\2\2\u01db\u01d9\3\2\2\2\u01db"+
		"\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\7S\2\2\u01de\u01e0\3\2"+
		"\2\2\u01df\u0174\3\2\2\2\u01df\u017b\3\2\2\2\u01df\u017e\3\2\2\2\u01df"+
		"\u0183\3\2\2\2\u01df\u0195\3\2\2\2\u01df\u01aa\3\2\2\2\u01df\u01b2\3\2"+
		"\2\2\u01df\u01b9\3\2\2\2\u01df\u01c8\3\2\2\2\u01df\u01cd\3\2\2\2\u01df"+
		"\u01d4\3\2\2\2\u01df\u01d5\3\2\2\2\u01e0\'\3\2\2\2\u01e1\u01e2\b\25\1"+
		"\2\u01e2\u01e3\t\24\2\2\u01e3\u0200\5(\25\t\u01e4\u0200\7Y\2\2\u01e5\u0200"+
		"\7Z\2\2\u01e6\u0200\7h\2\2\u01e7\u01ec\7j\2\2\u01e8\u01e9\7\f\2\2\u01e9"+
		"\u01ea\5(\25\2\u01ea\u01eb\7\r\2\2\u01eb\u01ed\3\2\2\2\u01ec\u01e8\3\2"+
		"\2\2\u01ec\u01ed\3\2\2\2\u01ed\u0200\3\2\2\2\u01ee\u01ef\7[\2\2\u01ef"+
		"\u01f0\7\f\2\2\u01f0\u01f1\7k\2\2\u01f1\u0200\7\r\2\2\u01f2\u01f3\7\\"+
		"\2\2\u01f3\u01f4\7\f\2\2\u01f4\u01f7\5(\25\2\u01f5\u01f6\7\3\2\2\u01f6"+
		"\u01f8\5(\25\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\3\2"+
		"\2\2\u01f9\u01fa\7\r\2\2\u01fa\u0200\3\2\2\2\u01fb\u01fc\7\f\2\2\u01fc"+
		"\u01fd\5(\25\2\u01fd\u01fe\7\r\2\2\u01fe\u0200\3\2\2\2\u01ff\u01e1\3\2"+
		"\2\2\u01ff\u01e4\3\2\2\2\u01ff\u01e5\3\2\2\2\u01ff\u01e6\3\2\2\2\u01ff"+
		"\u01e7\3\2\2\2\u01ff\u01ee\3\2\2\2\u01ff\u01f2\3\2\2\2\u01ff\u01fb\3\2"+
		"\2\2\u0200\u0227\3\2\2\2\u0201\u0202\f\b\2\2\u0202\u0204\t\5\2\2\u0203"+
		"\u0205\7n\2\2\u0204\u0203\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0206\3\2"+
		"\2\2\u0206\u0226\5(\25\t\u0207\u0208\f\7\2\2\u0208\u020a\t\6\2\2\u0209"+
		"\u020b\7n\2\2\u020a\u0209\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020c\3\2"+
		"\2\2\u020c\u0226\5(\25\b\u020d\u020e\f\6\2\2\u020e\u0210\t\25\2\2\u020f"+
		"\u0211\7n\2\2\u0210\u020f\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0212\3\2"+
		"\2\2\u0212\u0226\5(\25\7\u0213\u0214\f\5\2\2\u0214\u0216\t\26\2\2\u0215"+
		"\u0217\7n\2\2\u0216\u0215\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0218\3\2"+
		"\2\2\u0218\u0226\5(\25\6\u0219\u021a\f\4\2\2\u021a\u021c\7\"\2\2\u021b"+
		"\u021d\7n\2\2\u021c\u021b\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021e\3\2"+
		"\2\2\u021e\u0226\5(\25\5\u021f\u0220\f\3\2\2\u0220\u0222\7%\2\2\u0221"+
		"\u0223\7n\2\2\u0222\u0221\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0224\3\2"+
		"\2\2\u0224\u0226\5(\25\4\u0225\u0201\3\2\2\2\u0225\u0207\3\2\2\2\u0225"+
		"\u020d\3\2\2\2\u0225\u0213\3\2\2\2\u0225\u0219\3\2\2\2\u0225\u021f\3\2"+
		"\2\2\u0226\u0229\3\2\2\2\u0227\u0225\3\2\2\2\u0227\u0228\3\2\2\2\u0228"+
		")\3\2\2\2\u0229\u0227\3\2\2\2\u022a\u023d\7]\2\2\u022b\u023d\7[\2\2\u022c"+
		"\u022d\7\\\2\2\u022d\u0231\7^\2\2\u022e\u0230\7n\2\2\u022f\u022e\3\2\2"+
		"\2\u0230\u0233\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0234"+
		"\3\2\2\2\u0233\u0231\3\2\2\2\u0234\u0238\7[\2\2\u0235\u0237\7n\2\2\u0236"+
		"\u0235\3\2\2\2\u0237\u023a\3\2\2\2\u0238\u0236\3\2\2\2\u0238\u0239\3\2"+
		"\2\2\u0239\u023b\3\2\2\2\u023a\u0238\3\2\2\2\u023b\u023d\7_\2\2\u023c"+
		"\u022a\3\2\2\2\u023c\u022b\3\2\2\2\u023c\u022c\3\2\2\2\u023d+\3\2\2\2"+
		"\u023e\u023f\7\6\2\2\u023f\u0240\7`\2\2\u0240\u0241\5\16\b\2\u0241\u0242"+
		"\5.\30\2\u0242\u0243\7\7\2\2\u0243-\3\2\2\2\u0244\u0253\7a\2\2\u0245\u0247"+
		"\7j\2\2\u0246\u0245\3\2\2\2\u0247\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0248"+
		"\u0249\3\2\2\2\u0249\u0254\3\2\2\2\u024a\u0248\3\2\2\2\u024b\u0250\7j"+
		"\2\2\u024c\u024d\7\3\2\2\u024d\u024f\7j\2\2\u024e\u024c\3\2\2\2\u024f"+
		"\u0252\3\2\2\2\u0250\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0254\3\2"+
		"\2\2\u0252\u0250\3\2\2\2\u0253\u0248\3\2\2\2\u0253\u024b\3\2\2\2\u0254"+
		"/\3\2\2\2\u0255\u0256\7b\2\2\u0256\u0258\7j\2\2\u0257\u0259\7n\2\2\u0258"+
		"\u0257\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u0263\7\f"+
		"\2\2\u025b\u0260\5\62\32\2\u025c\u025d\7\3\2\2\u025d\u025f\5\62\32\2\u025e"+
		"\u025c\3\2\2\2\u025f\u0262\3\2\2\2\u0260\u025e\3\2\2\2\u0260\u0261\3\2"+
		"\2\2\u0261\u0264\3\2\2\2\u0262\u0260\3\2\2\2\u0263\u025b\3\2\2\2\u0263"+
		"\u0264\3\2\2\2\u0264\u0265\3\2\2\2\u0265\u0266\7\r\2\2\u0266\u0267\7L"+
		"\2\2\u0267\u0268\5*\26\2\u0268\u0269\7M\2\2\u0269\u026f\7\6\2\2\u026a"+
		"\u026b\7R\2\2\u026b\u026c\7S\2\2\u026c\u026d\5\64\33\2\u026d\u026e\7S"+
		"\2\2\u026e\u0270\3\2\2\2\u026f\u026a\3\2\2\2\u026f\u0270\3\2\2\2\u0270"+
		"\u0271\3\2\2\2\u0271\u0272\5$\23\2\u0272\u0274\7c\2\2\u0273\u0275\5(\25"+
		"\2\u0274\u0273\3\2\2\2\u0274\u0275\3\2\2\2\u0275\u0279\3\2\2\2\u0276\u0278"+
		"\7n\2\2\u0277\u0276\3\2\2\2\u0278\u027b\3\2\2\2\u0279\u0277\3\2\2\2\u0279"+
		"\u027a\3\2\2\2\u027a\u027c\3\2\2\2\u027b\u0279\3\2\2\2\u027c\u027d\7\7"+
		"\2\2\u027d\61\3\2\2\2\u027e\u027f\7j\2\2\u027f\u0280\7L\2\2\u0280\u0281"+
		"\5*\26\2\u0281\63\3\2\2\2\u0282\u0285\7\6\2\2\u0283\u0284\7d\2\2\u0284"+
		"\u0286\5\16\b\2\u0285\u0283\3\2\2\2\u0285\u0286\3\2\2\2\u0286\u0288\3"+
		"\2\2\2\u0287\u0289\5.\30\2\u0288\u0287\3\2\2\2\u0288\u0289\3\2\2\2\u0289"+
		"\u028c\3\2\2\2\u028a\u028b\7e\2\2\u028b\u028d\5\16\b\2\u028c\u028a\3\2"+
		"\2\2\u028c\u028d\3\2\2\2\u028d\u028e\3\2\2\2\u028e\u028f\7\7\2\2\u028f"+
		"\65\3\2\2\2\u0290\u0291\7\6\2\2\u0291\u0293\7`\2\2\u0292\u0294\5\16\b"+
		"\2\u0293\u0292\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u0293\3\2\2\2\u0295\u0296"+
		"\3\2\2\2\u0296\u0297\3\2\2\2\u0297\u0298\7\7\2\2\u0298\67\3\2\2\2\u0299"+
		"\u029a\7\6\2\2\u029a\u029c\7f\2\2\u029b\u029d\5:\36\2\u029c\u029b\3\2"+
		"\2\2\u029d\u029e\3\2\2\2\u029e\u029c\3\2\2\2\u029e\u029f\3\2\2\2\u029f"+
		"\u02a0\3\2\2\2\u02a0\u02a1\7\7\2\2\u02a19\3\2\2\2\u02a2\u02a3\7j\2\2\u02a3"+
		"\u02a4\7\b\2\2\u02a4\u02a5\5\20\t\2\u02a5;\3\2\2\2O>JORW\\crw|\u0080\u0095"+
		"\u009c\u00b3\u00b5\u00be\u00c8\u00cf\u00d5\u00db\u00e1\u00e7\u00ef\u00f5"+
		"\u00fb\u0101\u010f\u0116\u011c\u0122\u0128\u012e\u0136\u013d\u0140\u0162"+
		"\u0168\u016a\u016d\u0171\u018a\u019c\u01a5\u01af\u01b9\u01c2\u01c5\u01db"+
		"\u01df\u01ec\u01f7\u01ff\u0204\u020a\u0210\u0216\u021c\u0222\u0225\u0227"+
		"\u0231\u0238\u023c\u0248\u0250\u0253\u0258\u0260\u0263\u026f\u0274\u0279"+
		"\u0285\u0288\u028c\u0295\u029e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}