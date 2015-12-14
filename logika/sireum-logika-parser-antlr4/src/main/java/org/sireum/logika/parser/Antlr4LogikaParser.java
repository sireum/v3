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
		T__107=108, T__108=109, HLINE=110, INT=111, NUM=112, ID=113, STRING=114, 
		LINE_COMMENT=115, COMMENT=116, NL=117, WS=118, RESERVED=119, ERROR_CHAR=120;
	public static final int
		RULE_sequentFile = 0, RULE_proofFile = 1, RULE_programFile = 2, RULE_sequent = 3, 
		RULE_proof = 4, RULE_proofStep = 5, RULE_formula = 6, RULE_qformula = 7, 
		RULE_justification = 8, RULE_ruleIntro = 9, RULE_ruleIntro1 = 10, RULE_ruleIntro2 = 11, 
		RULE_ruleElim = 12, RULE_ruleElim1 = 13, RULE_ruleElim2 = 14, RULE_nums = 15, 
		RULE_numOrIds = 16, RULE_numOrId = 17, RULE_ids = 18, RULE_program = 19, 
		RULE_stmts = 20, RULE_stmt = 21, RULE_exp = 22, RULE_type = 23, RULE_loopInvariant = 24, 
		RULE_modifies = 25, RULE_methodDecl = 26, RULE_param = 27, RULE_methodContract = 28, 
		RULE_invariants = 29, RULE_facts = 30, RULE_fact = 31;
	public static final String[] ruleNames = {
		"sequentFile", "proofFile", "programFile", "sequent", "proof", "proofStep", 
		"formula", "qformula", "justification", "ruleIntro", "ruleIntro1", "ruleIntro2", 
		"ruleElim", "ruleElim1", "ruleElim2", "nums", "numOrIds", "numOrId", "ids", 
		"program", "stmts", "stmt", "exp", "type", "loopInvariant", "modifies", 
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
		"'impliese'", "'noti'", "'note'", "'falsee'", "'Pbc'", "'foalli'", "'alli'", 
		"'Ai'", "'foalle'", "'alle'", "'Ae'", "'existsi'", "'somei'", "'Ei'", 
		"'existse'", "'somee'", "'Ee'", "'algebra'", "'auto'", "'import'", "'_'", 
		"';'", "'var'", "'val'", "':'", "'assert'", "'if'", "'else'", "'while'", 
		"'l'", "'\"\"\"'", "'readInt'", "'print'", "'println'", "'s'", "'clone'", 
		"'BigInt'", "'Seq'", "'Boolean'", "'['", "']'", "'invariant'", "'modifies'", 
		"'def'", "'return'", "'requires'", "'ensures'", "'fact'"
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
		null, null, "HLINE", "INT", "NUM", "ID", "STRING", "LINE_COMMENT", "COMMENT", 
		"NL", "WS", "RESERVED", "ERROR_CHAR"
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
			setState(64);
			sequent();
			setState(66);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(65);
				proof();
				}
			}

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
			setState(70);
			proof();
			setState(71);
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
			setState(73);
			program();
			setState(74);
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
			setState(107);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0) || _la==INT || _la==ID) {
					{
					setState(76);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(77);
						match(T__0);
						setState(78);
						((SequentContext)_localctx).formula = formula(0);
						((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
						}
						}
						setState(83);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(86);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(87);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(88);
					match(T__0);
					setState(89);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0) || _la==INT || _la==ID) {
					{
					{
					setState(95);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(101);
				match(HLINE);
				setState(103); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(102);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(105); 
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
			setState(109);
			match(T__3);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NUM) {
				{
				{
				setState(110);
				proofStep();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
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
			setState(144);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				match(NUM);
				setState(119);
				match(T__5);
				setState(120);
				formula(0);
				setState(121);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(124);
				match(T__5);
				setState(125);
				match(T__3);
				setState(126);
				((SubProofContext)_localctx).assume = match(NUM);
				setState(127);
				match(T__5);
				setState(135);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(128);
					((SubProofContext)_localctx).fresh = match(ID);
					}
					break;
				case 2:
					{
					setState(130);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						setState(129);
						((SubProofContext)_localctx).fresh = match(ID);
						}
						break;
					}
					setState(132);
					formula(0);
					setState(133);
					match(T__6);
					}
					break;
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(137);
					proofStep();
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(143);
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
			setState(173);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(147);
				((UnaryContext)_localctx).op = match(T__20);
				setState(148);
				formula(6);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(150);
				formula(5);
				}
				break;
			case 3:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
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
				setState(152);
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
				setState(153);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				match(T__13);
				setState(155);
				formula(0);
				setState(156);
				match(T__14);
				}
				break;
			case 7:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158);
				match(T__15);
				}
				break;
			case 8:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				((ApplyContext)_localctx).fun = match(ID);
				setState(160);
				match(T__13);
				setState(161);
				formula(0);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(162);
					match(T__0);
					setState(163);
					formula(0);
					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(169);
				match(T__14);
				}
				break;
			case 9:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				match(INT);
				}
				break;
			case 10:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(196);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(175);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(176);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(177);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(178);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(179);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(180);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(181);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(182);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(183);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(184);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(185);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(186);
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(187);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(188);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(189);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(190);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(191);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__39) | (1L << T__40))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(192);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(193);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(194);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__41) | (1L << T__42) | (1L << T__43))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(195);
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
			setState(201);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(202);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).qVar.add(((QformulaContext)_localctx).ID);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(203);
				match(T__0);
				setState(204);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).qVar.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210);
			match(T__52);
			setState(211);
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
		public RuleElimContext ruleElim() {
			return getRuleContext(RuleElimContext.class,0);
		}
		public ForallElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ExistsIntroContext extends JustificationContext {
		public Token existsStep;
		public IdsContext args;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public IdsContext ids() {
			return getRuleContext(IdsContext.class,0);
		}
		public RuleIntroContext ruleIntro() {
			return getRuleContext(RuleIntroContext.class,0);
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
		public NumOrIdsContext stepOrFact;
		public NumOrIdsContext numOrIds() {
			return getRuleContext(NumOrIdsContext.class,0);
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
		public RuleElimContext ruleElim() {
			return getRuleContext(RuleElimContext.class,0);
		}
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
		public RuleElimContext ruleElim() {
			return getRuleContext(RuleElimContext.class,0);
		}
		public OrElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class FalseElimContext extends JustificationContext {
		public Token falseStep;
		public RuleElimContext ruleElim() {
			return getRuleContext(RuleElimContext.class,0);
		}
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public FalseElimContext(JustificationContext ctx) { copyFrom(ctx); }
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
			setState(336);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				match(T__53);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				switch (_input.LA(1)) {
				case T__54:
					{
					setState(214);
					match(T__54);
					}
					break;
				case T__36:
				case T__37:
					{
					setState(215);
					_la = _input.LA(1);
					if ( !(_la==T__36 || _la==T__37) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(216);
					ruleIntro();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(219);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(220);
				match(T__0);
				setState(221);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElim1Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				switch (_input.LA(1)) {
				case T__55:
					{
					setState(222);
					match(T__55);
					}
					break;
				case T__36:
				case T__37:
					{
					setState(223);
					_la = _input.LA(1);
					if ( !(_la==T__36 || _la==T__37) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(224);
					ruleElim1();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(227);
				((AndElim1Context)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new AndElim2Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(231);
				switch (_input.LA(1)) {
				case T__56:
					{
					setState(228);
					match(T__56);
					}
					break;
				case T__36:
				case T__37:
					{
					setState(229);
					_la = _input.LA(1);
					if ( !(_la==T__36 || _la==T__37) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(230);
					ruleElim2();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(233);
				((AndElim2Context)_localctx).andStep = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrIntro1Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(237);
				switch (_input.LA(1)) {
				case T__57:
					{
					setState(234);
					match(T__57);
					}
					break;
				case T__39:
				case T__40:
					{
					setState(235);
					_la = _input.LA(1);
					if ( !(_la==T__39 || _la==T__40) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(236);
					ruleIntro1();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(239);
				((OrIntro1Context)_localctx).orStep = match(NUM);
				}
				break;
			case 6:
				_localctx = new OrIntro2Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(243);
				switch (_input.LA(1)) {
				case T__58:
					{
					setState(240);
					match(T__58);
					}
					break;
				case T__39:
				case T__40:
					{
					setState(241);
					_la = _input.LA(1);
					if ( !(_la==T__39 || _la==T__40) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(242);
					ruleIntro2();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(245);
				((OrIntro2Context)_localctx).orStep = match(NUM);
				}
				break;
			case 7:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(249);
				switch (_input.LA(1)) {
				case T__59:
					{
					setState(246);
					match(T__59);
					}
					break;
				case T__39:
				case T__40:
					{
					setState(247);
					_la = _input.LA(1);
					if ( !(_la==T__39 || _la==T__40) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(248);
					ruleElim();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(251);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(252);
				match(T__0);
				setState(253);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(254);
				match(T__0);
				setState(255);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 8:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(259);
				switch (_input.LA(1)) {
				case T__60:
					{
					setState(256);
					match(T__60);
					}
					break;
				case T__42:
				case T__43:
					{
					setState(257);
					_la = _input.LA(1);
					if ( !(_la==T__42 || _la==T__43) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(258);
					ruleIntro();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(261);
				((ImpliesIntroContext)_localctx).impliesStep = match(NUM);
				}
				break;
			case 9:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(265);
				switch (_input.LA(1)) {
				case T__61:
					{
					setState(262);
					match(T__61);
					}
					break;
				case T__42:
				case T__43:
					{
					setState(263);
					_la = _input.LA(1);
					if ( !(_la==T__42 || _la==T__43) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(264);
					ruleElim();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(267);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(271);
				switch (_input.LA(1)) {
				case T__62:
					{
					setState(268);
					match(T__62);
					}
					break;
				case T__32:
				case T__33:
				case T__34:
					{
					setState(269);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(270);
					ruleIntro();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(273);
				((NegIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 11:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(277);
				switch (_input.LA(1)) {
				case T__63:
					{
					setState(274);
					match(T__63);
					}
					break;
				case T__32:
				case T__33:
				case T__34:
					{
					setState(275);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(276);
					ruleElim();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(279);
				((NegElimContext)_localctx).step = match(NUM);
				setState(280);
				match(T__0);
				setState(281);
				((NegElimContext)_localctx).notStep = match(NUM);
				}
				break;
			case 12:
				_localctx = new FalseElimContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(282);
				_la = _input.LA(1);
				if ( !(((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__9 - 10)) | (1L << (T__10 - 10)) | (1L << (T__64 - 10)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(283);
				ruleElim();
				setState(284);
				((FalseElimContext)_localctx).falseStep = match(NUM);
				}
				break;
			case 13:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(286);
				match(T__65);
				setState(287);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 14:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(293);
				switch (_input.LA(1)) {
				case T__66:
					{
					setState(288);
					match(T__66);
					}
					break;
				case T__67:
					{
					setState(289);
					match(T__67);
					}
					break;
				case T__68:
					{
					setState(290);
					match(T__68);
					}
					break;
				case T__47:
					{
					setState(291);
					match(T__47);
					setState(292);
					ruleIntro();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(295);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 15:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(301);
				switch (_input.LA(1)) {
				case T__69:
					{
					setState(296);
					match(T__69);
					}
					break;
				case T__70:
					{
					setState(297);
					match(T__70);
					}
					break;
				case T__71:
					{
					setState(298);
					match(T__71);
					}
					break;
				case T__47:
					{
					setState(299);
					match(T__47);
					setState(300);
					ruleElim();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(303);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
				setState(304);
				match(T__0);
				setState(305);
				((ForallElimContext)_localctx).args = numOrIds();
				}
				break;
			case 16:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(312);
				switch (_input.LA(1)) {
				case T__72:
					{
					setState(307);
					match(T__72);
					}
					break;
				case T__73:
					{
					setState(308);
					match(T__73);
					}
					break;
				case T__74:
					{
					setState(309);
					match(T__74);
					}
					break;
				case T__51:
					{
					setState(310);
					match(T__51);
					setState(311);
					ruleIntro();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(314);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(315);
				match(T__0);
				setState(316);
				((ExistsIntroContext)_localctx).args = ids();
				}
				break;
			case 17:
				_localctx = new ExistsContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(322);
				switch (_input.LA(1)) {
				case T__75:
					{
					setState(317);
					match(T__75);
					}
					break;
				case T__76:
					{
					setState(318);
					match(T__76);
					}
					break;
				case T__77:
					{
					setState(319);
					match(T__77);
					}
					break;
				case T__51:
					{
					setState(320);
					match(T__51);
					setState(321);
					ruleElim();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(324);
				((ExistsContext)_localctx).stepOrFact = numOrId();
				setState(325);
				match(T__0);
				setState(326);
				((ExistsContext)_localctx).subproof = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(328);
				match(T__78);
				setState(330);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(329);
					((AlgebraContext)_localctx).steps = nums();
					}
					break;
				}
				}
				break;
			case 19:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(332);
				match(T__79);
				setState(334);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(333);
					((AutoContext)_localctx).stepOrFact = numOrIds();
					}
					break;
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
			setState(338);
			((RuleIntroContext)_localctx).i = match(ID);
			setState(339);
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
			setState(341);
			((RuleIntro1Context)_localctx).i1 = match(ID);
			setState(342);
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
			setState(344);
			((RuleIntro2Context)_localctx).i2 = match(ID);
			setState(345);
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
			setState(347);
			((RuleElimContext)_localctx).e = match(ID);
			setState(348);
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
			setState(350);
			((RuleElim1Context)_localctx).e1 = match(ID);
			setState(351);
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
			setState(353);
			((RuleElim2Context)_localctx).e2 = match(ID);
			setState(354);
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
		enterRule(_localctx, 30, RULE_nums);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(NUM);
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(357);
				match(T__0);
				setState(358);
				match(NUM);
				}
				}
				setState(363);
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
		enterRule(_localctx, 32, RULE_numOrIds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			numOrId();
			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(365);
				match(T__0);
				setState(366);
				numOrId();
				}
				}
				setState(371);
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
		enterRule(_localctx, 34, RULE_numOrId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
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
		enterRule(_localctx, 36, RULE_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			match(ID);
			setState(379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(375);
				match(T__0);
				setState(376);
				match(ID);
				}
				}
				setState(381);
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
		enterRule(_localctx, 38, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(T__80);
			setState(383);
			((ProgramContext)_localctx).org = match(ID);
			setState(384);
			match(T__5);
			setState(385);
			((ProgramContext)_localctx).sireum = match(ID);
			setState(386);
			match(T__5);
			setState(387);
			((ProgramContext)_localctx).logika = match(ID);
			setState(388);
			match(T__5);
			setState(389);
			match(T__81);
			setState(390);
			stmts();
			setState(391);
			if (!( "org".equals((((ProgramContext)_localctx).org!=null?((ProgramContext)_localctx).org.getText():null)) &&
			      "sireum".equals((((ProgramContext)_localctx).sireum!=null?((ProgramContext)_localctx).sireum.getText():null)) &&
			      "logika".equals((((ProgramContext)_localctx).logika!=null?((ProgramContext)_localctx).logika.getText():null))    )) throw new FailedPredicateException(this, " \"org\".equals($org.text) &&\n      \"sireum\".equals($sireum.text) &&\n      \"logika\".equals($logika.text)    ");
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
		enterRule(_localctx, 40, RULE_stmts);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(393);
				stmt();
				}
				break;
			}
			setState(409);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(402);
					switch (_input.LA(1)) {
					case T__82:
						{
						setState(396);
						match(T__82);
						}
						break;
					case NL:
						{
						setState(398); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(397);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(400); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(405);
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
					case 1:
						{
						setState(404);
						stmt();
						}
						break;
					}
					}
					} 
				}
				setState(411);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
		enterRule(_localctx, 42, RULE_stmt);
		int _la;
		try {
			setState(519);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(412);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__83 || _la==T__84) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(413);
				match(ID);
				setState(414);
				match(T__85);
				setState(415);
				type();
				setState(416);
				match(T__27);
				setState(417);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(419);
				match(ID);
				setState(420);
				match(T__27);
				setState(421);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(422);
				match(T__86);
				setState(423);
				match(T__13);
				setState(424);
				exp(0);
				setState(425);
				match(T__14);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(427);
				match(T__87);
				setState(428);
				match(T__13);
				setState(429);
				exp(0);
				setState(430);
				match(T__14);
				setState(434);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(431);
					match(NL);
					}
					}
					setState(436);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(437);
				match(T__3);
				setState(438);
				((IfStmtContext)_localctx).ts = stmts();
				setState(439);
				match(T__4);
				setState(440);
				match(T__88);
				setState(441);
				match(T__3);
				setState(442);
				((IfStmtContext)_localctx).fs = stmts();
				setState(443);
				match(T__4);
				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(445);
				match(T__89);
				setState(446);
				match(T__13);
				setState(447);
				exp(0);
				setState(448);
				match(T__14);
				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(449);
					match(NL);
					}
					}
					setState(454);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(455);
				match(T__3);
				setState(461);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(456);
					match(T__90);
					setState(457);
					match(T__91);
					setState(458);
					loopInvariant();
					setState(459);
					match(T__91);
					}
					break;
				}
				setState(463);
				stmts();
				setState(464);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new ReadIntStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(466);
				match(ID);
				setState(467);
				match(T__27);
				setState(468);
				match(T__92);
				setState(469);
				match(T__13);
				setState(471);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(470);
					match(STRING);
					}
				}

				setState(473);
				match(T__14);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(474);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__93 || _la==T__94) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(475);
				match(T__13);
				setState(476);
				match(T__95);
				setState(477);
				match(STRING);
				setState(478);
				match(T__14);
				}
				break;
			case 8:
				_localctx = new MethodInvocationStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(481);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(479);
					((MethodInvocationStmtContext)_localctx).l = match(ID);
					setState(480);
					match(T__27);
					}
					break;
				}
				setState(483);
				((MethodInvocationStmtContext)_localctx).r = match(ID);
				setState(484);
				match(T__13);
				setState(493);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__11) | (1L << T__13) | (1L << T__20) | (1L << T__32))) != 0) || ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (T__97 - 98)) | (1L << (T__98 - 98)) | (1L << (INT - 98)) | (1L << (ID - 98)))) != 0)) {
					{
					setState(485);
					exp(0);
					setState(490);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(486);
						match(T__0);
						setState(487);
						exp(0);
						}
						}
						setState(492);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(495);
				match(T__14);
				}
				break;
			case 9:
				_localctx = new SeqCloneStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(496);
				match(ID);
				setState(497);
				match(T__27);
				setState(498);
				match(ID);
				setState(499);
				match(T__5);
				setState(500);
				match(T__96);
				}
				break;
			case 10:
				_localctx = new AssignArrayStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(501);
				match(ID);
				setState(502);
				match(T__13);
				setState(503);
				exp(0);
				setState(504);
				match(T__14);
				setState(505);
				match(T__27);
				setState(506);
				exp(0);
				}
				break;
			case 11:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(508);
				methodDecl();
				}
				break;
			case 12:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(509);
				match(T__90);
				setState(510);
				match(T__91);
				setState(515);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(511);
					proof();
					}
					break;
				case 2:
					{
					setState(512);
					sequent();
					}
					break;
				case 3:
					{
					setState(513);
					invariants();
					}
					break;
				case 4:
					{
					setState(514);
					facts();
					}
					break;
				}
				setState(517);
				match(T__91);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			switch (_input.LA(1)) {
			case T__20:
			case T__32:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(522);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__32) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(523);
				exp(7);
				}
				break;
			case T__11:
				{
				_localctx = new TrueExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(524);
				match(T__11);
				}
				break;
			case T__7:
				{
				_localctx = new FalseExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(525);
				match(T__7);
				}
				break;
			case INT:
				{
				_localctx = new IntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(526);
				match(INT);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(527);
				match(ID);
				setState(532);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(528);
					match(T__13);
					setState(529);
					exp(0);
					setState(530);
					match(T__14);
					}
					break;
				}
				}
				break;
			case T__97:
				{
				_localctx = new BigIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(534);
				match(T__97);
				setState(535);
				match(T__13);
				setState(536);
				match(STRING);
				setState(537);
				match(T__14);
				}
				break;
			case T__98:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(538);
				match(T__98);
				setState(539);
				match(T__13);
				setState(540);
				exp(0);
				setState(543);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(541);
					match(T__0);
					setState(542);
					exp(0);
					}
				}

				setState(545);
				match(T__14);
				}
				break;
			case T__13:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(547);
				match(T__13);
				setState(548);
				exp(0);
				setState(549);
				match(T__14);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(591);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(589);
					switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(553);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(554);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(556);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(555);
							match(NL);
							}
						}

						setState(558);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(559);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(560);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(562);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(561);
							match(NL);
							}
						}

						setState(564);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(565);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(566);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__25))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(568);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(567);
							match(NL);
							}
						}

						setState(570);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(571);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(572);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(574);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(573);
							match(NL);
							}
						}

						setState(576);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(577);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(578);
						match(T__36);
						}
						setState(580);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(579);
							match(NL);
							}
						}

						setState(582);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(583);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(584);
						match(T__39);
						}
						setState(586);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(585);
							match(NL);
							}
						}

						setState(588);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(593);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
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
		enterRule(_localctx, 46, RULE_type);
		int _la;
		try {
			setState(612);
			switch (_input.LA(1)) {
			case T__99:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(594);
				match(T__99);
				}
				break;
			case T__97:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(595);
				match(T__97);
				}
				break;
			case T__98:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(596);
				match(T__98);
				setState(597);
				match(T__100);
				setState(601);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(598);
					match(NL);
					}
					}
					setState(603);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(604);
				match(T__97);
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
				match(T__101);
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
		enterRule(_localctx, 48, RULE_loopInvariant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			match(T__3);
			setState(615);
			match(T__102);
			setState(616);
			formula(0);
			setState(617);
			modifies();
			setState(618);
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
		enterRule(_localctx, 50, RULE_modifies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			match(T__103);
			setState(621);
			match(ID);
			setState(626);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(622);
				match(T__0);
				setState(623);
				match(ID);
				}
				}
				setState(628);
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
		enterRule(_localctx, 52, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			match(T__104);
			setState(630);
			match(ID);
			setState(632);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(631);
				match(NL);
				}
			}

			setState(634);
			match(T__13);
			setState(643);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(635);
				param();
				setState(640);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(636);
					match(T__0);
					setState(637);
					param();
					}
					}
					setState(642);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(645);
			match(T__14);
			setState(646);
			match(T__85);
			setState(647);
			type();
			setState(648);
			match(T__27);
			setState(649);
			match(T__3);
			setState(655);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(650);
				match(T__90);
				setState(651);
				match(T__91);
				setState(652);
				methodContract();
				setState(653);
				match(T__91);
				}
				break;
			}
			setState(657);
			stmts();
			setState(658);
			match(T__105);
			setState(660);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__11) | (1L << T__13) | (1L << T__20) | (1L << T__32))) != 0) || ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (T__97 - 98)) | (1L << (T__98 - 98)) | (1L << (INT - 98)) | (1L << (ID - 98)))) != 0)) {
				{
				setState(659);
				exp(0);
				}
			}

			setState(665);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(662);
				match(NL);
				}
				}
				setState(667);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(668);
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
		enterRule(_localctx, 54, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(670);
			match(ID);
			setState(671);
			match(T__85);
			setState(672);
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
		enterRule(_localctx, 56, RULE_methodContract);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
			match(T__3);
			setState(677);
			_la = _input.LA(1);
			if (_la==T__106) {
				{
				setState(675);
				match(T__106);
				setState(676);
				formula(0);
				}
			}

			setState(680);
			_la = _input.LA(1);
			if (_la==T__103) {
				{
				setState(679);
				modifies();
				}
			}

			setState(684);
			_la = _input.LA(1);
			if (_la==T__107) {
				{
				setState(682);
				match(T__107);
				setState(683);
				formula(0);
				}
			}

			setState(686);
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
		enterRule(_localctx, 58, RULE_invariants);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(688);
			match(T__3);
			setState(689);
			match(T__102);
			setState(691); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(690);
				formula(0);
				}
				}
				setState(693); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0) || _la==INT || _la==ID );
			setState(695);
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
		enterRule(_localctx, 60, RULE_facts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			match(T__3);
			setState(698);
			match(T__108);
			setState(700); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(699);
				fact();
				}
				}
				setState(702); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(704);
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
		enterRule(_localctx, 62, RULE_fact);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			match(ID);
			setState(707);
			match(T__5);
			setState(708);
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
		case 19:
			return program_sempred((ProgramContext)_localctx, predIndex);
		case 22:
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
		      "logika".equals((((ProgramContext)_localctx).logika!=null?((ProgramContext)_localctx).logika.getText():null))    ;
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3z\u02c9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\5\2E\n\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\7\5R"+
		"\n\5\f\5\16\5U\13\5\5\5W\n\5\3\5\3\5\3\5\3\5\7\5]\n\5\f\5\16\5`\13\5\3"+
		"\5\7\5c\n\5\f\5\16\5f\13\5\3\5\3\5\6\5j\n\5\r\5\16\5k\5\5n\n\5\3\6\3\6"+
		"\7\6r\n\6\f\6\16\6u\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7\u0085\n\7\3\7\3\7\3\7\5\7\u008a\n\7\3\7\7\7\u008d\n\7\f"+
		"\7\16\7\u0090\13\7\3\7\5\7\u0093\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00a7\n\b\f\b\16\b\u00aa\13"+
		"\b\3\b\3\b\3\b\3\b\5\b\u00b0\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00c7\n\b\f\b\16\b"+
		"\u00ca\13\b\3\t\3\t\3\t\3\t\7\t\u00d0\n\t\f\t\16\t\u00d3\13\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\5\n\u00dc\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00e4\n"+
		"\n\3\n\3\n\3\n\3\n\5\n\u00ea\n\n\3\n\3\n\3\n\3\n\5\n\u00f0\n\n\3\n\3\n"+
		"\3\n\3\n\5\n\u00f6\n\n\3\n\3\n\3\n\3\n\5\n\u00fc\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\5\n\u0106\n\n\3\n\3\n\3\n\3\n\5\n\u010c\n\n\3\n\3\n\3\n"+
		"\3\n\5\n\u0112\n\n\3\n\3\n\3\n\3\n\5\n\u0118\n\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0128\n\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\n\u0130\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u013b\n\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0145\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u014d\n\n\3\n\3\n\5\n\u0151\n\n\5\n\u0153\n\n\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\7\21\u016a\n\21\f\21\16\21\u016d\13\21\3\22\3\22\3\22\7\22\u0172"+
		"\n\22\f\22\16\22\u0175\13\22\3\23\3\23\3\24\3\24\3\24\7\24\u017c\n\24"+
		"\f\24\16\24\u017f\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\5\26\u018d\n\26\3\26\3\26\6\26\u0191\n\26\r\26\16\26\u0192"+
		"\5\26\u0195\n\26\3\26\5\26\u0198\n\26\7\26\u019a\n\26\f\26\16\26\u019d"+
		"\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u01b3\n\27\f\27\16\27\u01b6\13"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7"+
		"\27\u01c5\n\27\f\27\16\27\u01c8\13\27\3\27\3\27\3\27\3\27\3\27\3\27\5"+
		"\27\u01d0\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u01da\n\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u01e4\n\27\3\27\3\27\3\27"+
		"\3\27\3\27\7\27\u01eb\n\27\f\27\16\27\u01ee\13\27\5\27\u01f0\n\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u0206\n\27\3\27\3\27\5\27\u020a\n\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0217\n\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0222\n\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\5\30\u022a\n\30\3\30\3\30\3\30\5\30\u022f\n\30\3"+
		"\30\3\30\3\30\3\30\5\30\u0235\n\30\3\30\3\30\3\30\3\30\5\30\u023b\n\30"+
		"\3\30\3\30\3\30\3\30\5\30\u0241\n\30\3\30\3\30\3\30\3\30\5\30\u0247\n"+
		"\30\3\30\3\30\3\30\3\30\5\30\u024d\n\30\3\30\7\30\u0250\n\30\f\30\16\30"+
		"\u0253\13\30\3\31\3\31\3\31\3\31\3\31\7\31\u025a\n\31\f\31\16\31\u025d"+
		"\13\31\3\31\3\31\7\31\u0261\n\31\f\31\16\31\u0264\13\31\3\31\5\31\u0267"+
		"\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u0273\n\33"+
		"\f\33\16\33\u0276\13\33\3\34\3\34\3\34\5\34\u027b\n\34\3\34\3\34\3\34"+
		"\3\34\7\34\u0281\n\34\f\34\16\34\u0284\13\34\5\34\u0286\n\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0292\n\34\3\34\3\34\3\34"+
		"\5\34\u0297\n\34\3\34\7\34\u029a\n\34\f\34\16\34\u029d\13\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\5\36\u02a8\n\36\3\36\5\36\u02ab\n"+
		"\36\3\36\3\36\5\36\u02af\n\36\3\36\3\36\3\37\3\37\3\37\6\37\u02b6\n\37"+
		"\r\37\16\37\u02b7\3\37\3\37\3 \3 \3 \6 \u02bf\n \r \16 \u02c0\3 \3 \3"+
		"!\3!\3!\3!\3!\2\4\16.\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*"+
		",.\60\62\64\668:<>@\2\31\3\2\4\5\3\2\"%\3\2\n\r\3\2\16\17\3\2\23\25\3"+
		"\2\26\27\3\2\30\35\3\2\36!\3\2&(\3\2)+\3\2,.\3\2/\66\3\2\'(\3\2*+\3\2"+
		"-.\3\2#%\4\2\f\rCC\3\2rs\3\2VW\3\2`a\4\2\27\27##\4\2\30\31\33\34\3\2\37"+
		" \u0332\2B\3\2\2\2\4H\3\2\2\2\6K\3\2\2\2\bm\3\2\2\2\no\3\2\2\2\f\u0092"+
		"\3\2\2\2\16\u00af\3\2\2\2\20\u00cb\3\2\2\2\22\u0152\3\2\2\2\24\u0154\3"+
		"\2\2\2\26\u0157\3\2\2\2\30\u015a\3\2\2\2\32\u015d\3\2\2\2\34\u0160\3\2"+
		"\2\2\36\u0163\3\2\2\2 \u0166\3\2\2\2\"\u016e\3\2\2\2$\u0176\3\2\2\2&\u0178"+
		"\3\2\2\2(\u0180\3\2\2\2*\u018c\3\2\2\2,\u0209\3\2\2\2.\u0229\3\2\2\2\60"+
		"\u0266\3\2\2\2\62\u0268\3\2\2\2\64\u026e\3\2\2\2\66\u0277\3\2\2\28\u02a0"+
		"\3\2\2\2:\u02a4\3\2\2\2<\u02b2\3\2\2\2>\u02bb\3\2\2\2@\u02c4\3\2\2\2B"+
		"D\5\b\5\2CE\5\n\6\2DC\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\7\2\2\3G\3\3\2\2\2"+
		"HI\5\n\6\2IJ\7\2\2\3J\5\3\2\2\2KL\5(\25\2LM\7\2\2\3M\7\3\2\2\2NS\5\16"+
		"\b\2OP\7\3\2\2PR\5\16\b\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TW\3"+
		"\2\2\2US\3\2\2\2VN\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\t\2\2\2Y^\5\16\b\2Z["+
		"\7\3\2\2[]\5\16\b\2\\Z\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_n\3\2\2"+
		"\2`^\3\2\2\2ac\5\16\b\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2"+
		"\2\2fd\3\2\2\2gi\7p\2\2hj\5\16\b\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2"+
		"\2\2ln\3\2\2\2mV\3\2\2\2md\3\2\2\2n\t\3\2\2\2os\7\6\2\2pr\5\f\7\2qp\3"+
		"\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\7\7\2\2w\13"+
		"\3\2\2\2xy\7r\2\2yz\7\b\2\2z{\5\16\b\2{|\5\22\n\2|\u0093\3\2\2\2}~\7r"+
		"\2\2~\177\7\b\2\2\177\u0080\7\6\2\2\u0080\u0081\7r\2\2\u0081\u0089\7\b"+
		"\2\2\u0082\u008a\7s\2\2\u0083\u0085\7s\2\2\u0084\u0083\3\2\2\2\u0084\u0085"+
		"\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\5\16\b\2\u0087\u0088\7\t\2\2"+
		"\u0088\u008a\3\2\2\2\u0089\u0082\3\2\2\2\u0089\u0084\3\2\2\2\u008a\u008e"+
		"\3\2\2\2\u008b\u008d\5\f\7\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2"+
		"\2\2\u0091\u0093\7\7\2\2\u0092x\3\2\2\2\u0092}\3\2\2\2\u0093\r\3\2\2\2"+
		"\u0094\u0095\b\b\1\2\u0095\u0096\7\27\2\2\u0096\u00b0\5\16\b\b\u0097\u0098"+
		"\t\3\2\2\u0098\u00b0\5\16\b\7\u0099\u00b0\t\4\2\2\u009a\u00b0\t\5\2\2"+
		"\u009b\u00b0\7s\2\2\u009c\u009d\7\20\2\2\u009d\u009e\5\16\b\2\u009e\u009f"+
		"\7\21\2\2\u009f\u00b0\3\2\2\2\u00a0\u00b0\7\22\2\2\u00a1\u00a2\7s\2\2"+
		"\u00a2\u00a3\7\20\2\2\u00a3\u00a8\5\16\b\2\u00a4\u00a5\7\3\2\2\u00a5\u00a7"+
		"\5\16\b\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2"+
		"\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac"+
		"\7\21\2\2\u00ac\u00b0\3\2\2\2\u00ad\u00b0\7q\2\2\u00ae\u00b0\5\20\t\2"+
		"\u00af\u0094\3\2\2\2\u00af\u0097\3\2\2\2\u00af\u0099\3\2\2\2\u00af\u009a"+
		"\3\2\2\2\u00af\u009b\3\2\2\2\u00af\u009c\3\2\2\2\u00af\u00a0\3\2\2\2\u00af"+
		"\u00a1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\u00c8\3\2"+
		"\2\2\u00b1\u00b2\f\f\2\2\u00b2\u00b3\t\6\2\2\u00b3\u00c7\5\16\b\r\u00b4"+
		"\u00b5\f\13\2\2\u00b5\u00b6\t\7\2\2\u00b6\u00c7\5\16\b\f\u00b7\u00b8\f"+
		"\n\2\2\u00b8\u00b9\t\b\2\2\u00b9\u00c7\5\16\b\13\u00ba\u00bb\f\t\2\2\u00bb"+
		"\u00bc\t\t\2\2\u00bc\u00c7\5\16\b\n\u00bd\u00be\f\6\2\2\u00be\u00bf\t"+
		"\n\2\2\u00bf\u00c7\5\16\b\7\u00c0\u00c1\f\5\2\2\u00c1\u00c2\t\13\2\2\u00c2"+
		"\u00c7\5\16\b\6\u00c3\u00c4\f\4\2\2\u00c4\u00c5\t\f\2\2\u00c5\u00c7\5"+
		"\16\b\5\u00c6\u00b1\3\2\2\2\u00c6\u00b4\3\2\2\2\u00c6\u00b7\3\2\2\2\u00c6"+
		"\u00ba\3\2\2\2\u00c6\u00bd\3\2\2\2\u00c6\u00c0\3\2\2\2\u00c6\u00c3\3\2"+
		"\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\17\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\t\r\2\2\u00cc\u00d1\7s\2\2"+
		"\u00cd\u00ce\7\3\2\2\u00ce\u00d0\7s\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d3"+
		"\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d4\u00d5\7\67\2\2\u00d5\u00d6\5\16\b\2\u00d6\21\3\2"+
		"\2\2\u00d7\u0153\78\2\2\u00d8\u00dc\79\2\2\u00d9\u00da\t\16\2\2\u00da"+
		"\u00dc\5\24\13\2\u00db\u00d8\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\3"+
		"\2\2\2\u00dd\u00de\7r\2\2\u00de\u00df\7\3\2\2\u00df\u0153\7r\2\2\u00e0"+
		"\u00e4\7:\2\2\u00e1\u00e2\t\16\2\2\u00e2\u00e4\5\34\17\2\u00e3\u00e0\3"+
		"\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u0153\7r\2\2\u00e6"+
		"\u00ea\7;\2\2\u00e7\u00e8\t\16\2\2\u00e8\u00ea\5\36\20\2\u00e9\u00e6\3"+
		"\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u0153\7r\2\2\u00ec"+
		"\u00f0\7<\2\2\u00ed\u00ee\t\17\2\2\u00ee\u00f0\5\26\f\2\u00ef\u00ec\3"+
		"\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u0153\7r\2\2\u00f2"+
		"\u00f6\7=\2\2\u00f3\u00f4\t\17\2\2\u00f4\u00f6\5\30\r\2\u00f5\u00f2\3"+
		"\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u0153\7r\2\2\u00f8"+
		"\u00fc\7>\2\2\u00f9\u00fa\t\17\2\2\u00fa\u00fc\5\32\16\2\u00fb\u00f8\3"+
		"\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\7r\2\2\u00fe"+
		"\u00ff\7\3\2\2\u00ff\u0100\7r\2\2\u0100\u0101\7\3\2\2\u0101\u0153\7r\2"+
		"\2\u0102\u0106\7?\2\2\u0103\u0104\t\20\2\2\u0104\u0106\5\24\13\2\u0105"+
		"\u0102\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0153\7r"+
		"\2\2\u0108\u010c\7@\2\2\u0109\u010a\t\20\2\2\u010a\u010c\5\32\16\2\u010b"+
		"\u0108\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u0153\7r"+
		"\2\2\u010e\u0112\7A\2\2\u010f\u0110\t\21\2\2\u0110\u0112\5\24\13\2\u0111"+
		"\u010e\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0153\7r"+
		"\2\2\u0114\u0118\7B\2\2\u0115\u0116\t\21\2\2\u0116\u0118\5\32\16\2\u0117"+
		"\u0114\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\7r"+
		"\2\2\u011a\u011b\7\3\2\2\u011b\u0153\7r\2\2\u011c\u011d\t\22\2\2\u011d"+
		"\u011e\5\32\16\2\u011e\u011f\7r\2\2\u011f\u0153\3\2\2\2\u0120\u0121\7"+
		"D\2\2\u0121\u0153\7r\2\2\u0122\u0128\7E\2\2\u0123\u0128\7F\2\2\u0124\u0128"+
		"\7G\2\2\u0125\u0126\7\62\2\2\u0126\u0128\5\24\13\2\u0127\u0122\3\2\2\2"+
		"\u0127\u0123\3\2\2\2\u0127\u0124\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129"+
		"\3\2\2\2\u0129\u0153\7r\2\2\u012a\u0130\7H\2\2\u012b\u0130\7I\2\2\u012c"+
		"\u0130\7J\2\2\u012d\u012e\7\62\2\2\u012e\u0130\5\32\16\2\u012f\u012a\3"+
		"\2\2\2\u012f\u012b\3\2\2\2\u012f\u012c\3\2\2\2\u012f\u012d\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0132\5$\23\2\u0132\u0133\7\3\2\2\u0133\u0134\5\""+
		"\22\2\u0134\u0153\3\2\2\2\u0135\u013b\7K\2\2\u0136\u013b\7L\2\2\u0137"+
		"\u013b\7M\2\2\u0138\u0139\7\66\2\2\u0139\u013b\5\24\13\2\u013a\u0135\3"+
		"\2\2\2\u013a\u0136\3\2\2\2\u013a\u0137\3\2\2\2\u013a\u0138\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013d\7r\2\2\u013d\u013e\7\3\2\2\u013e\u0153\5&\24"+
		"\2\u013f\u0145\7N\2\2\u0140\u0145\7O\2\2\u0141\u0145\7P\2\2\u0142\u0143"+
		"\7\66\2\2\u0143\u0145\5\32\16\2\u0144\u013f\3\2\2\2\u0144\u0140\3\2\2"+
		"\2\u0144\u0141\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147"+
		"\5$\23\2\u0147\u0148\7\3\2\2\u0148\u0149\7r\2\2\u0149\u0153\3\2\2\2\u014a"+
		"\u014c\7Q\2\2\u014b\u014d\5 \21\2\u014c\u014b\3\2\2\2\u014c\u014d\3\2"+
		"\2\2\u014d\u0153\3\2\2\2\u014e\u0150\7R\2\2\u014f\u0151\5\"\22\2\u0150"+
		"\u014f\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0153\3\2\2\2\u0152\u00d7\3\2"+
		"\2\2\u0152\u00db\3\2\2\2\u0152\u00e3\3\2\2\2\u0152\u00e9\3\2\2\2\u0152"+
		"\u00ef\3\2\2\2\u0152\u00f5\3\2\2\2\u0152\u00fb\3\2\2\2\u0152\u0105\3\2"+
		"\2\2\u0152\u010b\3\2\2\2\u0152\u0111\3\2\2\2\u0152\u0117\3\2\2\2\u0152"+
		"\u011c\3\2\2\2\u0152\u0120\3\2\2\2\u0152\u0127\3\2\2\2\u0152\u012f\3\2"+
		"\2\2\u0152\u013a\3\2\2\2\u0152\u0144\3\2\2\2\u0152\u014a\3\2\2\2\u0152"+
		"\u014e\3\2\2\2\u0153\23\3\2\2\2\u0154\u0155\7s\2\2\u0155\u0156\6\13\t"+
		"\3\u0156\25\3\2\2\2\u0157\u0158\7s\2\2\u0158\u0159\6\f\n\3\u0159\27\3"+
		"\2\2\2\u015a\u015b\7s\2\2\u015b\u015c\6\r\13\3\u015c\31\3\2\2\2\u015d"+
		"\u015e\7s\2\2\u015e\u015f\6\16\f\3\u015f\33\3\2\2\2\u0160\u0161\7s\2\2"+
		"\u0161\u0162\6\17\r\3\u0162\35\3\2\2\2\u0163\u0164\7s\2\2\u0164\u0165"+
		"\6\20\16\3\u0165\37\3\2\2\2\u0166\u016b\7r\2\2\u0167\u0168\7\3\2\2\u0168"+
		"\u016a\7r\2\2\u0169\u0167\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2"+
		"\2\2\u016b\u016c\3\2\2\2\u016c!\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u0173"+
		"\5$\23\2\u016f\u0170\7\3\2\2\u0170\u0172\5$\23\2\u0171\u016f\3\2\2\2\u0172"+
		"\u0175\3\2\2\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174#\3\2\2\2"+
		"\u0175\u0173\3\2\2\2\u0176\u0177\t\23\2\2\u0177%\3\2\2\2\u0178\u017d\7"+
		"s\2\2\u0179\u017a\7\3\2\2\u017a\u017c\7s\2\2\u017b\u0179\3\2\2\2\u017c"+
		"\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\'\3\2\2\2"+
		"\u017f\u017d\3\2\2\2\u0180\u0181\7S\2\2\u0181\u0182\7s\2\2\u0182\u0183"+
		"\7\b\2\2\u0183\u0184\7s\2\2\u0184\u0185\7\b\2\2\u0185\u0186\7s\2\2\u0186"+
		"\u0187\7\b\2\2\u0187\u0188\7T\2\2\u0188\u0189\5*\26\2\u0189\u018a\6\25"+
		"\17\3\u018a)\3\2\2\2\u018b\u018d\5,\27\2\u018c\u018b\3\2\2\2\u018c\u018d"+
		"\3\2\2\2\u018d\u019b\3\2\2\2\u018e\u0195\7U\2\2\u018f\u0191\7w\2\2\u0190"+
		"\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2"+
		"\2\2\u0193\u0195\3\2\2\2\u0194\u018e\3\2\2\2\u0194\u0190\3\2\2\2\u0195"+
		"\u0197\3\2\2\2\u0196\u0198\5,\27\2\u0197\u0196\3\2\2\2\u0197\u0198\3\2"+
		"\2\2\u0198\u019a\3\2\2\2\u0199\u0194\3\2\2\2\u019a\u019d\3\2\2\2\u019b"+
		"\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c+\3\2\2\2\u019d\u019b\3\2\2\2"+
		"\u019e\u019f\t\24\2\2\u019f\u01a0\7s\2\2\u01a0\u01a1\7X\2\2\u01a1\u01a2"+
		"\5\60\31\2\u01a2\u01a3\7\36\2\2\u01a3\u01a4\5.\30\2\u01a4\u020a\3\2\2"+
		"\2\u01a5\u01a6\7s\2\2\u01a6\u01a7\7\36\2\2\u01a7\u020a\5.\30\2\u01a8\u01a9"+
		"\7Y\2\2\u01a9\u01aa\7\20\2\2\u01aa\u01ab\5.\30\2\u01ab\u01ac\7\21\2\2"+
		"\u01ac\u020a\3\2\2\2\u01ad\u01ae\7Z\2\2\u01ae\u01af\7\20\2\2\u01af\u01b0"+
		"\5.\30\2\u01b0\u01b4\7\21\2\2\u01b1\u01b3\7w\2\2\u01b2\u01b1\3\2\2\2\u01b3"+
		"\u01b6\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b7\3\2"+
		"\2\2\u01b6\u01b4\3\2\2\2\u01b7\u01b8\7\6\2\2\u01b8\u01b9\5*\26\2\u01b9"+
		"\u01ba\7\7\2\2\u01ba\u01bb\7[\2\2\u01bb\u01bc\7\6\2\2\u01bc\u01bd\5*\26"+
		"\2\u01bd\u01be\7\7\2\2\u01be\u020a\3\2\2\2\u01bf\u01c0\7\\\2\2\u01c0\u01c1"+
		"\7\20\2\2\u01c1\u01c2\5.\30\2\u01c2\u01c6\7\21\2\2\u01c3\u01c5\7w\2\2"+
		"\u01c4\u01c3\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7"+
		"\3\2\2\2\u01c7\u01c9\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9\u01cf\7\6\2\2\u01ca"+
		"\u01cb\7]\2\2\u01cb\u01cc\7^\2\2\u01cc\u01cd\5\62\32\2\u01cd\u01ce\7^"+
		"\2\2\u01ce\u01d0\3\2\2\2\u01cf\u01ca\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0"+
		"\u01d1\3\2\2\2\u01d1\u01d2\5*\26\2\u01d2\u01d3\7\7\2\2\u01d3\u020a\3\2"+
		"\2\2\u01d4\u01d5\7s\2\2\u01d5\u01d6\7\36\2\2\u01d6\u01d7\7_\2\2\u01d7"+
		"\u01d9\7\20\2\2\u01d8\u01da\7t\2\2\u01d9\u01d8\3\2\2\2\u01d9\u01da\3\2"+
		"\2\2\u01da\u01db\3\2\2\2\u01db\u020a\7\21\2\2\u01dc\u01dd\t\25\2\2\u01dd"+
		"\u01de\7\20\2\2\u01de\u01df\7b\2\2\u01df\u01e0\7t\2\2\u01e0\u020a\7\21"+
		"\2\2\u01e1\u01e2\7s\2\2\u01e2\u01e4\7\36\2\2\u01e3\u01e1\3\2\2\2\u01e3"+
		"\u01e4\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\7s\2\2\u01e6\u01ef\7\20"+
		"\2\2\u01e7\u01ec\5.\30\2\u01e8\u01e9\7\3\2\2\u01e9\u01eb\5.\30\2\u01ea"+
		"\u01e8\3\2\2\2\u01eb\u01ee\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2"+
		"\2\2\u01ed\u01f0\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ef\u01e7\3\2\2\2\u01ef"+
		"\u01f0\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u020a\7\21\2\2\u01f2\u01f3\7"+
		"s\2\2\u01f3\u01f4\7\36\2\2\u01f4\u01f5\7s\2\2\u01f5\u01f6\7\b\2\2\u01f6"+
		"\u020a\7c\2\2\u01f7\u01f8\7s\2\2\u01f8\u01f9\7\20\2\2\u01f9\u01fa\5.\30"+
		"\2\u01fa\u01fb\7\21\2\2\u01fb\u01fc\7\36\2\2\u01fc\u01fd\5.\30\2\u01fd"+
		"\u020a\3\2\2\2\u01fe\u020a\5\66\34\2\u01ff\u0200\7]\2\2\u0200\u0205\7"+
		"^\2\2\u0201\u0206\5\n\6\2\u0202\u0206\5\b\5\2\u0203\u0206\5<\37\2\u0204"+
		"\u0206\5> \2\u0205\u0201\3\2\2\2\u0205\u0202\3\2\2\2\u0205\u0203\3\2\2"+
		"\2\u0205\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0208\7^\2\2\u0208\u020a"+
		"\3\2\2\2\u0209\u019e\3\2\2\2\u0209\u01a5\3\2\2\2\u0209\u01a8\3\2\2\2\u0209"+
		"\u01ad\3\2\2\2\u0209\u01bf\3\2\2\2\u0209\u01d4\3\2\2\2\u0209\u01dc\3\2"+
		"\2\2\u0209\u01e3\3\2\2\2\u0209\u01f2\3\2\2\2\u0209\u01f7\3\2\2\2\u0209"+
		"\u01fe\3\2\2\2\u0209\u01ff\3\2\2\2\u020a-\3\2\2\2\u020b\u020c\b\30\1\2"+
		"\u020c\u020d\t\26\2\2\u020d\u022a\5.\30\t\u020e\u022a\7\16\2\2\u020f\u022a"+
		"\7\n\2\2\u0210\u022a\7q\2\2\u0211\u0216\7s\2\2\u0212\u0213\7\20\2\2\u0213"+
		"\u0214\5.\30\2\u0214\u0215\7\21\2\2\u0215\u0217\3\2\2\2\u0216\u0212\3"+
		"\2\2\2\u0216\u0217\3\2\2\2\u0217\u022a\3\2\2\2\u0218\u0219\7d\2\2\u0219"+
		"\u021a\7\20\2\2\u021a\u021b\7t\2\2\u021b\u022a\7\21\2\2\u021c\u021d\7"+
		"e\2\2\u021d\u021e\7\20\2\2\u021e\u0221\5.\30\2\u021f\u0220\7\3\2\2\u0220"+
		"\u0222\5.\30\2\u0221\u021f\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0223\3\2"+
		"\2\2\u0223\u0224\7\21\2\2\u0224\u022a\3\2\2\2\u0225\u0226\7\20\2\2\u0226"+
		"\u0227\5.\30\2\u0227\u0228\7\21\2\2\u0228\u022a\3\2\2\2\u0229\u020b\3"+
		"\2\2\2\u0229\u020e\3\2\2\2\u0229\u020f\3\2\2\2\u0229\u0210\3\2\2\2\u0229"+
		"\u0211\3\2\2\2\u0229\u0218\3\2\2\2\u0229\u021c\3\2\2\2\u0229\u0225\3\2"+
		"\2\2\u022a\u0251\3\2\2\2\u022b\u022c\f\b\2\2\u022c\u022e\t\6\2\2\u022d"+
		"\u022f\7w\2\2\u022e\u022d\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u0230\3\2"+
		"\2\2\u0230\u0250\5.\30\t\u0231\u0232\f\7\2\2\u0232\u0234\t\7\2\2\u0233"+
		"\u0235\7w\2\2\u0234\u0233\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0236\3\2"+
		"\2\2\u0236\u0250\5.\30\b\u0237\u0238\f\6\2\2\u0238\u023a\t\27\2\2\u0239"+
		"\u023b\7w\2\2\u023a\u0239\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\3\2"+
		"\2\2\u023c\u0250\5.\30\7\u023d\u023e\f\5\2\2\u023e\u0240\t\30\2\2\u023f"+
		"\u0241\7w\2\2\u0240\u023f\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0242\3\2"+
		"\2\2\u0242\u0250\5.\30\6\u0243\u0244\f\4\2\2\u0244\u0246\7\'\2\2\u0245"+
		"\u0247\7w\2\2\u0246\u0245\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0248\3\2"+
		"\2\2\u0248\u0250\5.\30\5\u0249\u024a\f\3\2\2\u024a\u024c\7*\2\2\u024b"+
		"\u024d\7w\2\2\u024c\u024b\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u024e\3\2"+
		"\2\2\u024e\u0250\5.\30\4\u024f\u022b\3\2\2\2\u024f\u0231\3\2\2\2\u024f"+
		"\u0237\3\2\2\2\u024f\u023d\3\2\2\2\u024f\u0243\3\2\2\2\u024f\u0249\3\2"+
		"\2\2\u0250\u0253\3\2\2\2\u0251\u024f\3\2\2\2\u0251\u0252\3\2\2\2\u0252"+
		"/\3\2\2\2\u0253\u0251\3\2\2\2\u0254\u0267\7f\2\2\u0255\u0267\7d\2\2\u0256"+
		"\u0257\7e\2\2\u0257\u025b\7g\2\2\u0258\u025a\7w\2\2\u0259\u0258\3\2\2"+
		"\2\u025a\u025d\3\2\2\2\u025b\u0259\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u025e"+
		"\3\2\2\2\u025d\u025b\3\2\2\2\u025e\u0262\7d\2\2\u025f\u0261\7w\2\2\u0260"+
		"\u025f\3\2\2\2\u0261\u0264\3\2\2\2\u0262\u0260\3\2\2\2\u0262\u0263\3\2"+
		"\2\2\u0263\u0265\3\2\2\2\u0264\u0262\3\2\2\2\u0265\u0267\7h\2\2\u0266"+
		"\u0254\3\2\2\2\u0266\u0255\3\2\2\2\u0266\u0256\3\2\2\2\u0267\61\3\2\2"+
		"\2\u0268\u0269\7\6\2\2\u0269\u026a\7i\2\2\u026a\u026b\5\16\b\2\u026b\u026c"+
		"\5\64\33\2\u026c\u026d\7\7\2\2\u026d\63\3\2\2\2\u026e\u026f\7j\2\2\u026f"+
		"\u0274\7s\2\2\u0270\u0271\7\3\2\2\u0271\u0273\7s\2\2\u0272\u0270\3\2\2"+
		"\2\u0273\u0276\3\2\2\2\u0274\u0272\3\2\2\2\u0274\u0275\3\2\2\2\u0275\65"+
		"\3\2\2\2\u0276\u0274\3\2\2\2\u0277\u0278\7k\2\2\u0278\u027a\7s\2\2\u0279"+
		"\u027b\7w\2\2\u027a\u0279\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027c\3\2"+
		"\2\2\u027c\u0285\7\20\2\2\u027d\u0282\58\35\2\u027e\u027f\7\3\2\2\u027f"+
		"\u0281\58\35\2\u0280\u027e\3\2\2\2\u0281\u0284\3\2\2\2\u0282\u0280\3\2"+
		"\2\2\u0282\u0283\3\2\2\2\u0283\u0286\3\2\2\2\u0284\u0282\3\2\2\2\u0285"+
		"\u027d\3\2\2\2\u0285\u0286\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0288\7\21"+
		"\2\2\u0288\u0289\7X\2\2\u0289\u028a\5\60\31\2\u028a\u028b\7\36\2\2\u028b"+
		"\u0291\7\6\2\2\u028c\u028d\7]\2\2\u028d\u028e\7^\2\2\u028e\u028f\5:\36"+
		"\2\u028f\u0290\7^\2\2\u0290\u0292\3\2\2\2\u0291\u028c\3\2\2\2\u0291\u0292"+
		"\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0294\5*\26\2\u0294\u0296\7l\2\2\u0295"+
		"\u0297\5.\30\2\u0296\u0295\3\2\2\2\u0296\u0297\3\2\2\2\u0297\u029b\3\2"+
		"\2\2\u0298\u029a\7w\2\2\u0299\u0298\3\2\2\2\u029a\u029d\3\2\2\2\u029b"+
		"\u0299\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029e\3\2\2\2\u029d\u029b\3\2"+
		"\2\2\u029e\u029f\7\7\2\2\u029f\67\3\2\2\2\u02a0\u02a1\7s\2\2\u02a1\u02a2"+
		"\7X\2\2\u02a2\u02a3\5\60\31\2\u02a39\3\2\2\2\u02a4\u02a7\7\6\2\2\u02a5"+
		"\u02a6\7m\2\2\u02a6\u02a8\5\16\b\2\u02a7\u02a5\3\2\2\2\u02a7\u02a8\3\2"+
		"\2\2\u02a8\u02aa\3\2\2\2\u02a9\u02ab\5\64\33\2\u02aa\u02a9\3\2\2\2\u02aa"+
		"\u02ab\3\2\2\2\u02ab\u02ae\3\2\2\2\u02ac\u02ad\7n\2\2\u02ad\u02af\5\16"+
		"\b\2\u02ae\u02ac\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0"+
		"\u02b1\7\7\2\2\u02b1;\3\2\2\2\u02b2\u02b3\7\6\2\2\u02b3\u02b5\7i\2\2\u02b4"+
		"\u02b6\5\16\b\2\u02b5\u02b4\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b5\3"+
		"\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9\u02ba\7\7\2\2\u02ba"+
		"=\3\2\2\2\u02bb\u02bc\7\6\2\2\u02bc\u02be\7o\2\2\u02bd\u02bf\5@!\2\u02be"+
		"\u02bd\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02be\3\2\2\2\u02c0\u02c1\3\2"+
		"\2\2\u02c1\u02c2\3\2\2\2\u02c2\u02c3\7\7\2\2\u02c3?\3\2\2\2\u02c4\u02c5"+
		"\7s\2\2\u02c5\u02c6\7\b\2\2\u02c6\u02c7\5\20\t\2\u02c7A\3\2\2\2ODSV^d"+
		"kms\u0084\u0089\u008e\u0092\u00a8\u00af\u00c6\u00c8\u00d1\u00db\u00e3"+
		"\u00e9\u00ef\u00f5\u00fb\u0105\u010b\u0111\u0117\u0127\u012f\u013a\u0144"+
		"\u014c\u0150\u0152\u016b\u0173\u017d\u018c\u0192\u0194\u0197\u019b\u01b4"+
		"\u01c6\u01cf\u01d9\u01e3\u01ec\u01ef\u0205\u0209\u0216\u0221\u0229\u022e"+
		"\u0234\u023a\u0240\u0246\u024c\u024f\u0251\u025b\u0262\u0266\u0274\u027a"+
		"\u0282\u0285\u0291\u0296\u029b\u02a7\u02aa\u02ae\u02b7\u02c0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}