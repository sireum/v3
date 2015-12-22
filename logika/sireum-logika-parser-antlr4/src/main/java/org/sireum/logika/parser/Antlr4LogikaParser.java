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
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
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
			setState(185);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
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
				setState(169);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(153);
					match(ID);
					setState(156);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(154);
						match(T__6);
						setState(155);
						type();
						}
					}

					}
					break;
				case 2:
					{
					setState(158);
					formula(0);
					setState(159);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				case 3:
					{
					setState(161);
					match(ID);
					setState(164);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(162);
						match(T__6);
						setState(163);
						type();
						}
					}

					setState(166);
					formula(0);
					setState(167);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(172); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(171);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(174); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(177);
					_la = _input.LA(1);
					if (_la==NUM) {
						{
						setState(176);
						proofStep();
						}
					}

					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(184);
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
			setState(234);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(188);
				((UnaryContext)_localctx).op = match(T__24);
				setState(189);
				formula(6);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(191);
				formula(5);
				}
				break;
			case 3:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
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
				setState(193);
				((VarContext)_localctx).tb = match(ID);
				setState(196);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(194);
					match(T__5);
					setState(195);
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
				setState(198);
				match(T__15);
				setState(199);
				formula(0);
				setState(200);
				match(T__16);
				}
				break;
			case 6:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				match(T__17);
				}
				break;
			case 7:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				match(ID);
				setState(204);
				match(T__15);
				setState(205);
				formula(0);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(206);
					match(T__0);
					setState(207);
					formula(0);
					}
					}
					setState(212);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(213);
				match(T__16);
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215);
				match(NUM);
				}
				break;
			case 9:
				{
				_localctx = new BigIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				match(T__18);
				setState(217);
				match(T__15);
				setState(218);
				match(STRING);
				setState(219);
				match(T__16);
				}
				break;
			case 10:
				{
				_localctx = new SeqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				match(T__19);
				setState(221);
				match(T__15);
				setState(230);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (T__114 - 115)) | (1L << (NUM - 115)) | (1L << (ID - 115)))) != 0)) {
					{
					setState(222);
					exp(0);
					setState(227);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(223);
						match(T__0);
						setState(224);
						exp(0);
						}
						}
						setState(229);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(232);
				match(T__16);
				}
				break;
			case 11:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(233);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(278);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(236);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(237);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(239);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(238);
							match(NL);
							}
						}

						setState(241);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(242);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(243);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(245);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(244);
							match(NL);
							}
						}

						setState(247);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(248);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(249);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(251);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(250);
							match(NL);
							}
						}

						setState(253);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(254);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(255);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(257);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(256);
							match(NL);
							}
						}

						setState(259);
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(260);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(261);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(263);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(262);
							match(NL);
							}
						}

						setState(265);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(266);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(267);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(269);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(268);
							match(NL);
							}
						}

						setState(271);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(272);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(273);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__47) | (1L << T__48) | (1L << T__49))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(275);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(274);
							match(NL);
							}
						}

						setState(277);
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(282);
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
			setState(283);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(284);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(285);
				match(T__0);
				setState(286);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(299);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(292);
				match(T__6);
				setState(293);
				type();
				}
				break;
			case 2:
				{
				setState(294);
				match(T__6);
				setState(295);
				((QformulaContext)_localctx).lo = exp(0);
				setState(296);
				match(T__58);
				setState(297);
				((QformulaContext)_localctx).hi = exp(0);
				}
				break;
			}
			setState(301);
			match(T__59);
			setState(303);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(302);
				match(NL);
				}
			}

			setState(305);
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
			setState(310);
			switch (_input.LA(1)) {
			case T__60:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				((BooleanTypeContext)_localctx).t = match(T__60);
				}
				break;
			case T__18:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				((IntTypeContext)_localctx).t = match(T__18);
				}
				break;
			case T__19:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(309);
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
			setState(436);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				((PremiseContext)_localctx).t = match(T__61);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
				switch (_input.LA(1)) {
				case T__62:
				case T__63:
					{
					setState(313);
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
					setState(314);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__40 || _la==T__42) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(315);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(318);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(319);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(323);
				switch (_input.LA(1)) {
				case T__64:
				case T__65:
				case T__66:
				case T__67:
					{
					setState(320);
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
					setState(321);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__40 || _la==T__42) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(322);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(325);
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(329);
				switch (_input.LA(1)) {
				case T__68:
				case T__69:
				case T__70:
				case T__71:
					{
					setState(326);
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
					setState(327);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__44 || _la==T__46) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(328);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(331);
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(335);
				switch (_input.LA(1)) {
				case T__72:
				case T__73:
					{
					setState(332);
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
					setState(333);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__44 || _la==T__46) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(338);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(339);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(343);
				switch (_input.LA(1)) {
				case T__74:
					{
					setState(340);
					((ImpliesIntroContext)_localctx).tb = match(T__74);
					}
					break;
				case T__48:
				case T__49:
					{
					setState(341);
					((ImpliesIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__48 || _la==T__49) ) {
						((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(342);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(345);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(349);
				switch (_input.LA(1)) {
				case T__75:
					{
					setState(346);
					((ImpliesElimContext)_localctx).tb = match(T__75);
					}
					break;
				case T__48:
				case T__49:
					{
					setState(347);
					((ImpliesElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__48 || _la==T__49) ) {
						((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(348);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(351);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(352);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(356);
				switch (_input.LA(1)) {
				case T__76:
				case T__77:
					{
					setState(353);
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
					setState(354);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(355);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(358);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(363);
				switch (_input.LA(1)) {
				case T__78:
					{
					setState(359);
					((NegElimContext)_localctx).tb = match(T__78);
					}
					break;
				case T__79:
					{
					setState(360);
					((NegElimContext)_localctx).tb = match(T__79);
					}
					break;
				case T__36:
				case T__37:
				case T__38:
					{
					setState(361);
					((NegElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
						((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(362);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(365);
				((NegElimContext)_localctx).step = match(NUM);
				setState(366);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(370);
				switch (_input.LA(1)) {
				case T__80:
				case T__81:
					{
					setState(367);
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
					setState(368);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==T__14) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(369);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(372);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 11:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(373);
				((PbcContext)_localctx).tb = match(T__82);
				setState(374);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 12:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(380);
				switch (_input.LA(1)) {
				case T__83:
					{
					setState(375);
					((ForallIntroContext)_localctx).tb = match(T__83);
					}
					break;
				case T__84:
					{
					setState(376);
					((ForallIntroContext)_localctx).tb = match(T__84);
					}
					break;
				case T__85:
					{
					setState(377);
					((ForallIntroContext)_localctx).tb = match(T__85);
					}
					break;
				case T__53:
					{
					setState(378);
					((ForallIntroContext)_localctx).tb = match(T__53);
					setState(379);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(382);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(388);
				switch (_input.LA(1)) {
				case T__86:
					{
					setState(383);
					((ForallElimContext)_localctx).tb = match(T__86);
					}
					break;
				case T__87:
					{
					setState(384);
					((ForallElimContext)_localctx).tb = match(T__87);
					}
					break;
				case T__88:
					{
					setState(385);
					((ForallElimContext)_localctx).tb = match(T__88);
					}
					break;
				case T__53:
					{
					setState(386);
					((ForallElimContext)_localctx).tb = match(T__53);
					setState(387);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(390);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
				setState(392); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(391);
					formula(0);
					}
					}
					setState(394); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 14:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(396);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (T__89 - 90)) | (1L << (T__90 - 90)) | (1L << (T__91 - 90)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(397);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(399); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(398);
					formula(0);
					}
					}
					setState(401); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 15:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(403);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (T__92 - 93)) | (1L << (T__93 - 93)) | (1L << (T__94 - 93)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(404);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(405);
				((ExistsElimContext)_localctx).subproof = match(NUM);
				}
				break;
			case 16:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(407);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(408);
				((ExistsIntroContext)_localctx).tb = match(T__57);
				setState(409);
				match(ID);
				setState(410);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(412); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(411);
					formula(0);
					}
					}
					setState(414); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 17:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(416);
				((ExistsElimContext)_localctx).tb = match(T__57);
				setState(417);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(418);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(419);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(421);
				((AlgebraContext)_localctx).tb = match(T__95);
				setState(425);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(422);
					((AlgebraContext)_localctx).numOrId = numOrId();
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).numOrId);
					}
					}
					setState(427);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(428);
				((InvariantContext)_localctx).tb = match(T__96);
				}
				break;
			case 20:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(429);
				((AutoContext)_localctx).tb = match(T__97);
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(430);
					((AutoContext)_localctx).numOrId = numOrId();
					((AutoContext)_localctx).stepOrFacts.add(((AutoContext)_localctx).numOrId);
					}
					}
					setState(435);
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
			setState(438);
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
			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(440);
				match(NL);
				}
				}
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(472);
			_la = _input.LA(1);
			if (_la==T__98) {
				{
				setState(446);
				((ProgramContext)_localctx).tb = match(T__98);
				setState(447);
				((ProgramContext)_localctx).org = match(ID);
				setState(448);
				match(T__5);
				setState(449);
				((ProgramContext)_localctx).sireum = match(ID);
				setState(450);
				match(T__5);
				setState(451);
				match(T__99);
				setState(452);
				match(T__5);
				setState(453);
				((ProgramContext)_localctx).te = match(T__100);
				setState(455); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(454);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(457); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(469);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(459);
					lgk();
					setState(460);
					match(T__101);
					setState(461);
					facts();
					setState(462);
					((ProgramContext)_localctx).te = match(T__101);
					setState(466);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(463);
							match(NL);
							}
							} 
						}
						setState(468);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
					}
					}
					break;
				}
				setState(471);
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
			setState(474);
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
			setState(476);
			match(T__3);
			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(477);
				match(NL);
				}
				}
				setState(482);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(483);
			((FactsContext)_localctx).ftb = match(T__102);
			setState(487);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(484);
					match(NL);
					}
					} 
				}
				setState(489);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			}
			setState(491);
			_la = _input.LA(1);
			if (_la==T__103 || _la==ID) {
				{
				setState(490);
				factOrFun();
				}
			}

			setState(503);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(494); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(493);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(496); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(499);
				_la = _input.LA(1);
				if (_la==T__103 || _la==ID) {
					{
					setState(498);
					factOrFun();
					}
				}

				}
				}
				setState(505);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(506);
			((FactsContext)_localctx).te = match(T__4);
			setState(510);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(507);
				match(NL);
				}
				}
				setState(512);
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
			setState(515);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(513);
				fact();
				}
				break;
			case T__103:
				enterOuterAlt(_localctx, 2);
				{
				setState(514);
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
			setState(517);
			match(ID);
			setState(518);
			match(T__5);
			setState(519);
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
			setState(521);
			((FunContext)_localctx).tb = match(T__103);
			setState(522);
			match(ID);
			setState(524);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(523);
				match(NL);
				}
			}

			setState(526);
			match(T__15);
			setState(527);
			param();
			setState(532);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(528);
				match(T__0);
				setState(529);
				param();
				}
				}
				setState(534);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(535);
			match(T__16);
			setState(536);
			match(T__6);
			setState(537);
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
			setState(539);
			match(ID);
			setState(540);
			match(T__6);
			setState(541);
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
			setState(544);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (T__99 - 100)) | (1L << (T__103 - 100)) | (1L << (T__104 - 100)) | (1L << (T__105 - 100)) | (1L << (T__106 - 100)) | (1L << (T__107 - 100)) | (1L << (T__109 - 100)) | (1L << (T__110 - 100)) | (1L << (T__111 - 100)) | (1L << (T__114 - 100)) | (1L << (NUM - 100)) | (1L << (ID - 100)))) != 0)) {
				{
				setState(543);
				stmt();
				}
			}

			setState(556);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(547); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(546);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(549); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(552);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (T__99 - 100)) | (1L << (T__103 - 100)) | (1L << (T__104 - 100)) | (1L << (T__105 - 100)) | (1L << (T__106 - 100)) | (1L << (T__107 - 100)) | (1L << (T__109 - 100)) | (1L << (T__110 - 100)) | (1L << (T__111 - 100)) | (1L << (T__114 - 100)) | (1L << (NUM - 100)) | (1L << (ID - 100)))) != 0)) {
					{
					setState(551);
					stmt();
					}
				}

				}
				}
				setState(558);
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
			setState(720);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(559);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__104 || _la==T__105) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(560);
				match(ID);
				setState(561);
				match(T__6);
				setState(562);
				type();
				setState(563);
				match(T__31);
				setState(565);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(564);
					match(NL);
					}
				}

				setState(567);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(569);
				match(ID);
				setState(570);
				match(T__31);
				setState(572);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(571);
					match(NL);
					}
				}

				setState(574);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(575);
				match(T__106);
				setState(576);
				match(T__15);
				setState(577);
				exp(0);
				setState(578);
				match(T__16);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(580);
				match(T__107);
				setState(581);
				match(T__15);
				setState(582);
				exp(0);
				setState(583);
				match(T__16);
				setState(587);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(584);
					match(NL);
					}
					}
					setState(589);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(590);
				match(T__3);
				setState(591);
				((IfStmtContext)_localctx).ts = stmts();
				setState(592);
				match(T__4);
				setState(604);
				_la = _input.LA(1);
				if (_la==T__108) {
					{
					setState(593);
					match(T__108);
					setState(597);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(594);
						match(NL);
						}
						}
						setState(599);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(600);
					match(T__3);
					setState(601);
					((IfStmtContext)_localctx).fs = stmts();
					setState(602);
					match(T__4);
					}
				}

				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(606);
				match(T__109);
				setState(607);
				match(T__15);
				setState(608);
				exp(0);
				setState(609);
				match(T__16);
				setState(613);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(610);
					match(NL);
					}
					}
					setState(615);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(616);
				match(T__3);
				setState(628);
				switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
				case 1:
					{
					setState(620);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(617);
						match(NL);
						}
						}
						setState(622);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(623);
					lgk();
					setState(624);
					match(T__101);
					setState(625);
					loopInvariant();
					setState(626);
					match(T__101);
					}
					break;
				}
				setState(630);
				stmts();
				setState(631);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(633);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__110 || _la==T__111) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(634);
				match(T__15);
				setState(635);
				((PrintStmtContext)_localctx).s = match(ID);
				setState(636);
				match(STRING);
				setState(637);
				match(T__16);
				}
				break;
			case 7:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(638);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(639);
				match(T__15);
				setState(640);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(641);
				match(T__16);
				setState(642);
				match(T__31);
				setState(644);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(643);
					match(NL);
					}
				}

				setState(646);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 8:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(648);
				match(T__103);
				setState(649);
				match(ID);
				setState(651);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(650);
					match(NL);
					}
				}

				setState(653);
				match(T__15);
				setState(662);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(654);
					param();
					setState(659);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(655);
						match(T__0);
						setState(656);
						param();
						}
						}
						setState(661);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(664);
				match(T__16);
				setState(665);
				match(T__6);
				setState(668);
				switch (_input.LA(1)) {
				case T__18:
				case T__19:
				case T__60:
					{
					setState(666);
					type();
					}
					break;
				case T__112:
					{
					setState(667);
					match(T__112);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(670);
				match(T__31);
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
				match(T__3);
				setState(695);
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
				case 1:
					{
					setState(681);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(678);
						match(NL);
						}
						}
						setState(683);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(684);
					lgk();
					setState(685);
					match(T__101);
					setState(686);
					methodContract();
					setState(690);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(687);
						match(NL);
						}
						}
						setState(692);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(693);
					match(T__101);
					}
					break;
				}
				setState(697);
				stmts();
				setState(706);
				_la = _input.LA(1);
				if (_la==T__113) {
					{
					setState(698);
					((MethodDeclStmtContext)_localctx).rtb = match(T__113);
					setState(699);
					exp(0);
					setState(703);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(700);
						match(NL);
						}
						}
						setState(705);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(708);
				match(T__4);
				}
				break;
			case 9:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(710);
				lgk();
				setState(711);
				match(T__101);
				setState(715);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(712);
					proof();
					}
					break;
				case 2:
					{
					setState(713);
					sequent();
					}
					break;
				case 3:
					{
					setState(714);
					invariants();
					}
					break;
				}
				setState(717);
				match(T__101);
				}
				break;
			case 10:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(719);
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
			setState(771);
			switch (_input.LA(1)) {
			case T__24:
			case T__36:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(723);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__36) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(724);
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
				setState(725);
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
				setState(726);
				match(NUM);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(727);
				((IdExpContext)_localctx).tb = match(ID);
				setState(742);
				switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
				case 1:
					{
					setState(728);
					match(T__15);
					setState(737);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (T__114 - 115)) | (1L << (NUM - 115)) | (1L << (ID - 115)))) != 0)) {
						{
						setState(729);
						exp(0);
						setState(734);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__0) {
							{
							{
							setState(730);
							match(T__0);
							setState(731);
							exp(0);
							}
							}
							setState(736);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(739);
					match(T__16);
					}
					break;
				case 2:
					{
					setState(740);
					match(T__5);
					setState(741);
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
				setState(744);
				match(T__18);
				setState(745);
				match(T__15);
				setState(746);
				match(STRING);
				setState(747);
				match(T__16);
				}
				break;
			case T__19:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(748);
				match(T__19);
				setState(749);
				match(T__15);
				setState(758);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (T__114 - 115)) | (1L << (NUM - 115)) | (1L << (ID - 115)))) != 0)) {
					{
					setState(750);
					exp(0);
					setState(755);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(751);
						match(T__0);
						setState(752);
						exp(0);
						}
						}
						setState(757);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(760);
				match(T__16);
				}
				break;
			case T__114:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(761);
				match(T__114);
				setState(762);
				match(T__15);
				setState(764);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(763);
					match(STRING);
					}
				}

				setState(766);
				match(T__16);
				}
				break;
			case T__15:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(767);
				match(T__15);
				setState(768);
				exp(0);
				setState(769);
				match(T__16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(817);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(815);
					switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(773);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(774);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(776);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(775);
							match(NL);
							}
						}

						setState(778);
						((BinaryExpContext)_localctx).r = exp(8);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(779);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(780);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24 || _la==T__115) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(782);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(781);
							match(NL);
							}
						}

						setState(784);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(785);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(786);
						((BinaryExpContext)_localctx).op = match(T__115);
						setState(788);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(787);
							match(NL);
							}
						}

						setState(790);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(791);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(792);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__28) | (1L << T__29))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(794);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(793);
							match(NL);
							}
						}

						setState(796);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(797);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(798);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__32 || _la==T__33) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(800);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(799);
							match(NL);
							}
						}

						setState(802);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(803);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(804);
						((BinaryExpContext)_localctx).op = match(T__40);
						setState(806);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(805);
							match(NL);
							}
						}

						setState(808);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(809);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(810);
						((BinaryExpContext)_localctx).op = match(T__44);
						setState(812);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(811);
							match(NL);
							}
						}

						setState(814);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(819);
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
			setState(820);
			((LoopInvariantContext)_localctx).tb = match(T__3);
			setState(824);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(821);
				match(NL);
				}
				}
				setState(826);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(827);
			((LoopInvariantContext)_localctx).itb = match(T__96);
			setState(831);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(828);
					match(NL);
					}
					} 
				}
				setState(833);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			}
			setState(835);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
				{
				setState(834);
				formula(0);
				}
			}

			setState(847);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(838); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(837);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(840); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(843);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
					{
					setState(842);
					formula(0);
					}
				}

				}
				}
				setState(849);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(850);
			modifies();
			setState(851);
			((LoopInvariantContext)_localctx).te = match(T__4);
			setState(855);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(852);
				match(NL);
				}
				}
				setState(857);
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
			setState(858);
			((ModifiesContext)_localctx).tb = match(T__116);
			setState(867);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(859);
				match(ID);
				setState(864);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(860);
					match(T__0);
					setState(861);
					match(ID);
					}
					}
					setState(866);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(872);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,123,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(869);
					match(NL);
					}
					} 
				}
				setState(874);
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
			setState(875);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(879);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(876);
					match(NL);
					}
					} 
				}
				setState(881);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			}
			setState(903);
			_la = _input.LA(1);
			if (_la==T__117 || _la==T__118) {
				{
				setState(882);
				_la = _input.LA(1);
				if ( !(_la==T__117 || _la==T__118) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(886);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(883);
					match(NL);
					}
					}
					setState(888);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(889);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(900);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(891); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(890);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(893); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(896);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
							{
							setState(895);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(902);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
				}
				}
			}

			setState(908);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(905);
					match(NL);
					}
					} 
				}
				setState(910);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			}
			setState(912);
			_la = _input.LA(1);
			if (_la==T__116) {
				{
				setState(911);
				modifies();
				}
			}

			setState(935);
			_la = _input.LA(1);
			if (_la==T__119 || _la==T__120) {
				{
				setState(914);
				_la = _input.LA(1);
				if ( !(_la==T__119 || _la==T__120) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(918);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(915);
					match(NL);
					}
					}
					setState(920);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(921);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(932);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(923); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(922);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(925); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(928);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
							{
							setState(927);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(934);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
				}
				}
			}

			setState(940);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(937);
				match(NL);
				}
				}
				setState(942);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(943);
			((MethodContractContext)_localctx).te = match(T__4);
			setState(947);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(944);
					match(NL);
					}
					} 
				}
				setState(949);
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
			setState(950);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(954);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(951);
				match(NL);
				}
				}
				setState(956);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(957);
			match(T__96);
			setState(961);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(958);
					match(NL);
					}
					} 
				}
				setState(963);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			}
			setState(965);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
				{
				setState(964);
				formula(0);
				}
			}

			setState(977);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(968); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(967);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(970); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(973);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
					{
					setState(972);
					formula(0);
					}
				}

				}
				}
				setState(979);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(980);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(984);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(981);
				match(NL);
				}
				}
				setState(986);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0085\u03de\4\2\t"+
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
		"\13\7\3\7\3\7\3\7\3\7\3\7\5\7\u009f\n\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a7"+
		"\n\7\3\7\3\7\3\7\5\7\u00ac\n\7\3\7\6\7\u00af\n\7\r\7\16\7\u00b0\3\7\5"+
		"\7\u00b4\n\7\7\7\u00b6\n\7\f\7\16\7\u00b9\13\7\3\7\5\7\u00bc\n\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00c7\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\7\b\u00d3\n\b\f\b\16\b\u00d6\13\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00e4\n\b\f\b\16\b\u00e7\13\b\5\b\u00e9"+
		"\n\b\3\b\3\b\5\b\u00ed\n\b\3\b\3\b\3\b\5\b\u00f2\n\b\3\b\3\b\3\b\3\b\5"+
		"\b\u00f8\n\b\3\b\3\b\3\b\3\b\5\b\u00fe\n\b\3\b\3\b\3\b\3\b\5\b\u0104\n"+
		"\b\3\b\3\b\3\b\3\b\5\b\u010a\n\b\3\b\3\b\3\b\3\b\5\b\u0110\n\b\3\b\3\b"+
		"\3\b\3\b\5\b\u0116\n\b\3\b\7\b\u0119\n\b\f\b\16\b\u011c\13\b\3\t\3\t\3"+
		"\t\3\t\7\t\u0122\n\t\f\t\16\t\u0125\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\t\u012e\n\t\3\t\3\t\5\t\u0132\n\t\3\t\3\t\3\n\3\n\3\n\5\n\u0139\n\n\3"+
		"\13\3\13\3\13\3\13\5\13\u013f\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0146"+
		"\n\13\3\13\3\13\3\13\3\13\5\13\u014c\n\13\3\13\3\13\3\13\3\13\5\13\u0152"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u015a\n\13\3\13\3\13\3\13\3\13"+
		"\5\13\u0160\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0167\n\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u016e\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0175\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u017f\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u0187\n\13\3\13\3\13\6\13\u018b\n\13\r\13\16\13\u018c"+
		"\3\13\3\13\3\13\6\13\u0192\n\13\r\13\16\13\u0193\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\6\13\u019f\n\13\r\13\16\13\u01a0\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u01aa\n\13\f\13\16\13\u01ad\13\13\3\13\3\13"+
		"\3\13\7\13\u01b2\n\13\f\13\16\13\u01b5\13\13\5\13\u01b7\n\13\3\f\3\f\3"+
		"\r\7\r\u01bc\n\r\f\r\16\r\u01bf\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\6\r\u01ca\n\r\r\r\16\r\u01cb\3\r\3\r\3\r\3\r\3\r\7\r\u01d3\n\r\f\r"+
		"\16\r\u01d6\13\r\5\r\u01d8\n\r\3\r\5\r\u01db\n\r\3\16\3\16\3\17\3\17\7"+
		"\17\u01e1\n\17\f\17\16\17\u01e4\13\17\3\17\3\17\7\17\u01e8\n\17\f\17\16"+
		"\17\u01eb\13\17\3\17\5\17\u01ee\n\17\3\17\6\17\u01f1\n\17\r\17\16\17\u01f2"+
		"\3\17\5\17\u01f6\n\17\7\17\u01f8\n\17\f\17\16\17\u01fb\13\17\3\17\3\17"+
		"\7\17\u01ff\n\17\f\17\16\17\u0202\13\17\3\20\3\20\5\20\u0206\n\20\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\5\22\u020f\n\22\3\22\3\22\3\22\3\22\7\22"+
		"\u0215\n\22\f\22\16\22\u0218\13\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\24\5\24\u0223\n\24\3\24\6\24\u0226\n\24\r\24\16\24\u0227\3\24"+
		"\5\24\u022b\n\24\7\24\u022d\n\24\f\24\16\24\u0230\13\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u0238\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u023f\n"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u024c"+
		"\n\25\f\25\16\25\u024f\13\25\3\25\3\25\3\25\3\25\3\25\7\25\u0256\n\25"+
		"\f\25\16\25\u0259\13\25\3\25\3\25\3\25\3\25\5\25\u025f\n\25\3\25\3\25"+
		"\3\25\3\25\3\25\7\25\u0266\n\25\f\25\16\25\u0269\13\25\3\25\3\25\7\25"+
		"\u026d\n\25\f\25\16\25\u0270\13\25\3\25\3\25\3\25\3\25\3\25\5\25\u0277"+
		"\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u0287\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u028e\n\25\3\25\3"+
		"\25\3\25\3\25\7\25\u0294\n\25\f\25\16\25\u0297\13\25\5\25\u0299\n\25\3"+
		"\25\3\25\3\25\3\25\5\25\u029f\n\25\3\25\3\25\7\25\u02a3\n\25\f\25\16\25"+
		"\u02a6\13\25\3\25\3\25\7\25\u02aa\n\25\f\25\16\25\u02ad\13\25\3\25\3\25"+
		"\3\25\3\25\7\25\u02b3\n\25\f\25\16\25\u02b6\13\25\3\25\3\25\5\25\u02ba"+
		"\n\25\3\25\3\25\3\25\3\25\7\25\u02c0\n\25\f\25\16\25\u02c3\13\25\5\25"+
		"\u02c5\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u02ce\n\25\3\25\3"+
		"\25\3\25\5\25\u02d3\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\7\26\u02df\n\26\f\26\16\26\u02e2\13\26\5\26\u02e4\n\26\3\26\3\26"+
		"\3\26\5\26\u02e9\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26"+
		"\u02f4\n\26\f\26\16\26\u02f7\13\26\5\26\u02f9\n\26\3\26\3\26\3\26\3\26"+
		"\5\26\u02ff\n\26\3\26\3\26\3\26\3\26\3\26\5\26\u0306\n\26\3\26\3\26\3"+
		"\26\5\26\u030b\n\26\3\26\3\26\3\26\3\26\5\26\u0311\n\26\3\26\3\26\3\26"+
		"\3\26\5\26\u0317\n\26\3\26\3\26\3\26\3\26\5\26\u031d\n\26\3\26\3\26\3"+
		"\26\3\26\5\26\u0323\n\26\3\26\3\26\3\26\3\26\5\26\u0329\n\26\3\26\3\26"+
		"\3\26\3\26\5\26\u032f\n\26\3\26\7\26\u0332\n\26\f\26\16\26\u0335\13\26"+
		"\3\27\3\27\7\27\u0339\n\27\f\27\16\27\u033c\13\27\3\27\3\27\7\27\u0340"+
		"\n\27\f\27\16\27\u0343\13\27\3\27\5\27\u0346\n\27\3\27\6\27\u0349\n\27"+
		"\r\27\16\27\u034a\3\27\5\27\u034e\n\27\7\27\u0350\n\27\f\27\16\27\u0353"+
		"\13\27\3\27\3\27\3\27\7\27\u0358\n\27\f\27\16\27\u035b\13\27\3\30\3\30"+
		"\3\30\3\30\7\30\u0361\n\30\f\30\16\30\u0364\13\30\5\30\u0366\n\30\3\30"+
		"\7\30\u0369\n\30\f\30\16\30\u036c\13\30\3\31\3\31\7\31\u0370\n\31\f\31"+
		"\16\31\u0373\13\31\3\31\3\31\7\31\u0377\n\31\f\31\16\31\u037a\13\31\3"+
		"\31\3\31\6\31\u037e\n\31\r\31\16\31\u037f\3\31\5\31\u0383\n\31\7\31\u0385"+
		"\n\31\f\31\16\31\u0388\13\31\5\31\u038a\n\31\3\31\7\31\u038d\n\31\f\31"+
		"\16\31\u0390\13\31\3\31\5\31\u0393\n\31\3\31\3\31\7\31\u0397\n\31\f\31"+
		"\16\31\u039a\13\31\3\31\3\31\6\31\u039e\n\31\r\31\16\31\u039f\3\31\5\31"+
		"\u03a3\n\31\7\31\u03a5\n\31\f\31\16\31\u03a8\13\31\5\31\u03aa\n\31\3\31"+
		"\7\31\u03ad\n\31\f\31\16\31\u03b0\13\31\3\31\3\31\7\31\u03b4\n\31\f\31"+
		"\16\31\u03b7\13\31\3\32\3\32\7\32\u03bb\n\32\f\32\16\32\u03be\13\32\3"+
		"\32\3\32\7\32\u03c2\n\32\f\32\16\32\u03c5\13\32\3\32\5\32\u03c8\n\32\3"+
		"\32\6\32\u03cb\n\32\r\32\16\32\u03cc\3\32\5\32\u03d0\n\32\7\32\u03d2\n"+
		"\32\f\32\16\32\u03d5\13\32\3\32\3\32\7\32\u03d9\n\32\f\32\16\32\u03dc"+
		"\13\32\3\32\2\4\16*\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,"+
		".\60\62\2$\3\2\4\5\3\2&)\3\2\13\21\3\2\27\31\3\2\32\33\3\2\34!\3\2\"%"+
		"\3\2*-\3\2.\61\3\2\62\64\3\2\65<\3\2AB\4\2++--\3\2CF\3\2GJ\4\2//\61\61"+
		"\3\2KL\3\2\63\64\3\2OP\3\2\')\3\2ST\3\2\20\21\3\2\\^\3\2_a\3\2}~\4\2f"+
		"f~~\3\2kl\3\2qr\4\2\33\33\'\'\4\2\32\33vv\4\2\34\35\37 \3\2#$\3\2xy\3"+
		"\2z{\u0493\2\64\3\2\2\2\4F\3\2\2\2\6I\3\2\2\2\bk\3\2\2\2\nm\3\2\2\2\f"+
		"\u00bb\3\2\2\2\16\u00ec\3\2\2\2\20\u011d\3\2\2\2\22\u0138\3\2\2\2\24\u01b6"+
		"\3\2\2\2\26\u01b8\3\2\2\2\30\u01bd\3\2\2\2\32\u01dc\3\2\2\2\34\u01de\3"+
		"\2\2\2\36\u0205\3\2\2\2 \u0207\3\2\2\2\"\u020b\3\2\2\2$\u021d\3\2\2\2"+
		"&\u0222\3\2\2\2(\u02d2\3\2\2\2*\u0305\3\2\2\2,\u0336\3\2\2\2.\u035c\3"+
		"\2\2\2\60\u036d\3\2\2\2\62\u03b8\3\2\2\2\648\5\b\5\2\65\67\7\u0081\2\2"+
		"\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29<\3\2\2\2:8\3\2\2\2;"+
		"=\5\n\6\2<;\3\2\2\2<=\3\2\2\2=A\3\2\2\2>@\7\u0081\2\2?>\3\2\2\2@C\3\2"+
		"\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\2\2\3E\3\3\2\2\2FG\5"+
		"\n\6\2GH\7\2\2\3H\5\3\2\2\2IJ\5\30\r\2JK\7\2\2\3K\7\3\2\2\2LQ\5\16\b\2"+
		"MN\7\3\2\2NP\5\16\b\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RU\3\2\2"+
		"\2SQ\3\2\2\2TL\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\t\2\2\2W\\\5\16\b\2XY\7\3"+
		"\2\2Y[\5\16\b\2ZX\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]l\3\2\2\2^\\"+
		"\3\2\2\2_a\5\16\b\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2"+
		"db\3\2\2\2eg\7|\2\2fh\5\16\b\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2"+
		"jl\3\2\2\2kT\3\2\2\2kb\3\2\2\2l\t\3\2\2\2mo\7\6\2\2np\5\f\7\2on\3\2\2"+
		"\2op\3\2\2\2p{\3\2\2\2qs\7\u0081\2\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3"+
		"\2\2\2uw\3\2\2\2vx\5\f\7\2wv\3\2\2\2wx\3\2\2\2xz\3\2\2\2yr\3\2\2\2z}\3"+
		"\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2~\u0082\7\7\2\2\177\u0081"+
		"\7\u0081\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2"+
		"\u0082\u0083\3\2\2\2\u0083\13\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086"+
		"\7}\2\2\u0086\u0087\7\b\2\2\u0087\u0088\5\16\b\2\u0088\u0089\5\24\13\2"+
		"\u0089\u00bc\3\2\2\2\u008a\u008b\7}\2\2\u008b\u008f\7\b\2\2\u008c\u008e"+
		"\7\u0081\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2"+
		"\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0096"+
		"\7\6\2\2\u0093\u0095\7\u0081\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2"+
		"\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096"+
		"\3\2\2\2\u0099\u009a\7}\2\2\u009a\u00ab\7\b\2\2\u009b\u009e\7~\2\2\u009c"+
		"\u009d\7\t\2\2\u009d\u009f\5\22\n\2\u009e\u009c\3\2\2\2\u009e\u009f\3"+
		"\2\2\2\u009f\u00ac\3\2\2\2\u00a0\u00a1\5\16\b\2\u00a1\u00a2\7\n\2\2\u00a2"+
		"\u00ac\3\2\2\2\u00a3\u00a6\7~\2\2\u00a4\u00a5\7\t\2\2\u00a5\u00a7\5\22"+
		"\n\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a9\5\16\b\2\u00a9\u00aa\7\n\2\2\u00aa\u00ac\3\2\2\2\u00ab\u009b\3"+
		"\2\2\2\u00ab\u00a0\3\2\2\2\u00ab\u00a3\3\2\2\2\u00ac\u00b7\3\2\2\2\u00ad"+
		"\u00af\7\u0081\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b4\5\f\7\2\u00b3"+
		"\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00ae\3\2"+
		"\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00ba\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bc\7\7\2\2\u00bb\u0085\3\2"+
		"\2\2\u00bb\u008a\3\2\2\2\u00bc\r\3\2\2\2\u00bd\u00be\b\b\1\2\u00be\u00bf"+
		"\7\33\2\2\u00bf\u00ed\5\16\b\b\u00c0\u00c1\t\3\2\2\u00c1\u00ed\5\16\b"+
		"\7\u00c2\u00ed\t\4\2\2\u00c3\u00c6\7~\2\2\u00c4\u00c5\7\b\2\2\u00c5\u00c7"+
		"\7~\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00ed\3\2\2\2\u00c8"+
		"\u00c9\7\22\2\2\u00c9\u00ca\5\16\b\2\u00ca\u00cb\7\23\2\2\u00cb\u00ed"+
		"\3\2\2\2\u00cc\u00ed\7\24\2\2\u00cd\u00ce\7~\2\2\u00ce\u00cf\7\22\2\2"+
		"\u00cf\u00d4\5\16\b\2\u00d0\u00d1\7\3\2\2\u00d1\u00d3\5\16\b\2\u00d2\u00d0"+
		"\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7\23\2\2\u00d8\u00ed\3"+
		"\2\2\2\u00d9\u00ed\7}\2\2\u00da\u00db\7\25\2\2\u00db\u00dc\7\22\2\2\u00dc"+
		"\u00dd\7\177\2\2\u00dd\u00ed\7\23\2\2\u00de\u00df\7\26\2\2\u00df\u00e8"+
		"\7\22\2\2\u00e0\u00e5\5*\26\2\u00e1\u00e2\7\3\2\2\u00e2\u00e4\5*\26\2"+
		"\u00e3\u00e1\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6"+
		"\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e0\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ed\7\23\2\2\u00eb\u00ed\5"+
		"\20\t\2\u00ec\u00bd\3\2\2\2\u00ec\u00c0\3\2\2\2\u00ec\u00c2\3\2\2\2\u00ec"+
		"\u00c3\3\2\2\2\u00ec\u00c8\3\2\2\2\u00ec\u00cc\3\2\2\2\u00ec\u00cd\3\2"+
		"\2\2\u00ec\u00d9\3\2\2\2\u00ec\u00da\3\2\2\2\u00ec\u00de\3\2\2\2\u00ec"+
		"\u00eb\3\2\2\2\u00ed\u011a\3\2\2\2\u00ee\u00ef\f\f\2\2\u00ef\u00f1\t\5"+
		"\2\2\u00f0\u00f2\7\u0081\2\2\u00f1\u00f0\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u0119\5\16\b\r\u00f4\u00f5\f\13\2\2\u00f5\u00f7\t"+
		"\6\2\2\u00f6\u00f8\7\u0081\2\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2"+
		"\u00f8\u00f9\3\2\2\2\u00f9\u0119\5\16\b\f\u00fa\u00fb\f\n\2\2\u00fb\u00fd"+
		"\t\7\2\2\u00fc\u00fe\7\u0081\2\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2\2"+
		"\2\u00fe\u00ff\3\2\2\2\u00ff\u0119\5\16\b\13\u0100\u0101\f\t\2\2\u0101"+
		"\u0103\t\b\2\2\u0102\u0104\7\u0081\2\2\u0103\u0102\3\2\2\2\u0103\u0104"+
		"\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0119\5\16\b\n\u0106\u0107\f\6\2\2"+
		"\u0107\u0109\t\t\2\2\u0108\u010a\7\u0081\2\2\u0109\u0108\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u0119\5\16\b\7\u010c\u010d\f"+
		"\5\2\2\u010d\u010f\t\n\2\2\u010e\u0110\7\u0081\2\2\u010f\u010e\3\2\2\2"+
		"\u010f\u0110\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0119\5\16\b\6\u0112\u0113"+
		"\f\4\2\2\u0113\u0115\t\13\2\2\u0114\u0116\7\u0081\2\2\u0115\u0114\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0119\5\16\b\5\u0118"+
		"\u00ee\3\2\2\2\u0118\u00f4\3\2\2\2\u0118\u00fa\3\2\2\2\u0118\u0100\3\2"+
		"\2\2\u0118\u0106\3\2\2\2\u0118\u010c\3\2\2\2\u0118\u0112\3\2\2\2\u0119"+
		"\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\17\3\2\2"+
		"\2\u011c\u011a\3\2\2\2\u011d\u011e\t\f\2\2\u011e\u0123\7~\2\2\u011f\u0120"+
		"\7\3\2\2\u0120\u0122\7~\2\2\u0121\u011f\3\2\2\2\u0122\u0125\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u012d\3\2\2\2\u0125\u0123\3\2"+
		"\2\2\u0126\u0127\7\t\2\2\u0127\u012e\5\22\n\2\u0128\u0129\7\t\2\2\u0129"+
		"\u012a\5*\26\2\u012a\u012b\7=\2\2\u012b\u012c\5*\26\2\u012c\u012e\3\2"+
		"\2\2\u012d\u0126\3\2\2\2\u012d\u0128\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u0131\7>\2\2\u0130\u0132\7\u0081\2\2\u0131\u0130"+
		"\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\5\16\b\2"+
		"\u0134\21\3\2\2\2\u0135\u0139\7?\2\2\u0136\u0139\7\25\2\2\u0137\u0139"+
		"\7\26\2\2\u0138\u0135\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0137\3\2\2\2"+
		"\u0139\23\3\2\2\2\u013a\u01b7\7@\2\2\u013b\u013f\t\r\2\2\u013c\u013d\t"+
		"\16\2\2\u013d\u013f\7~\2\2\u013e\u013b\3\2\2\2\u013e\u013c\3\2\2\2\u013f"+
		"\u0140\3\2\2\2\u0140\u0141\7}\2\2\u0141\u01b7\7}\2\2\u0142\u0146\t\17"+
		"\2\2\u0143\u0144\t\16\2\2\u0144\u0146\7~\2\2\u0145\u0142\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u01b7\7}\2\2\u0148\u014c\t\20"+
		"\2\2\u0149\u014a\t\21\2\2\u014a\u014c\7~\2\2\u014b\u0148\3\2\2\2\u014b"+
		"\u0149\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u01b7\7}\2\2\u014e\u0152\t\22"+
		"\2\2\u014f\u0150\t\21\2\2\u0150\u0152\7~\2\2\u0151\u014e\3\2\2\2\u0151"+
		"\u014f\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\7}\2\2\u0154\u0155\7}\2"+
		"\2\u0155\u01b7\7}\2\2\u0156\u015a\7M\2\2\u0157\u0158\t\23\2\2\u0158\u015a"+
		"\7~\2\2\u0159\u0156\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u015b\3\2\2\2\u015b"+
		"\u01b7\7}\2\2\u015c\u0160\7N\2\2\u015d\u015e\t\23\2\2\u015e\u0160\7~\2"+
		"\2\u015f\u015c\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162"+
		"\7}\2\2\u0162\u01b7\7}\2\2\u0163\u0167\t\24\2\2\u0164\u0165\t\25\2\2\u0165"+
		"\u0167\7~\2\2\u0166\u0163\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u0168\3\2"+
		"\2\2\u0168\u01b7\7}\2\2\u0169\u016e\7Q\2\2\u016a\u016e\7R\2\2\u016b\u016c"+
		"\t\25\2\2\u016c\u016e\7~\2\2\u016d\u0169\3\2\2\2\u016d\u016a\3\2\2\2\u016d"+
		"\u016b\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\7}\2\2\u0170\u01b7\7}\2"+
		"\2\u0171\u0175\t\26\2\2\u0172\u0173\t\27\2\2\u0173\u0175\7~\2\2\u0174"+
		"\u0171\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u01b7\7}"+
		"\2\2\u0177\u0178\7U\2\2\u0178\u01b7\7}\2\2\u0179\u017f\7V\2\2\u017a\u017f"+
		"\7W\2\2\u017b\u017f\7X\2\2\u017c\u017d\78\2\2\u017d\u017f\7~\2\2\u017e"+
		"\u0179\3\2\2\2\u017e\u017a\3\2\2\2\u017e\u017b\3\2\2\2\u017e\u017c\3\2"+
		"\2\2\u017f\u0180\3\2\2\2\u0180\u01b7\7}\2\2\u0181\u0187\7Y\2\2\u0182\u0187"+
		"\7Z\2\2\u0183\u0187\7[\2\2\u0184\u0185\78\2\2\u0185\u0187\7~\2\2\u0186"+
		"\u0181\3\2\2\2\u0186\u0182\3\2\2\2\u0186\u0183\3\2\2\2\u0186\u0184\3\2"+
		"\2\2\u0187\u0188\3\2\2\2\u0188\u018a\5\26\f\2\u0189\u018b\5\16\b\2\u018a"+
		"\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2"+
		"\2\2\u018d\u01b7\3\2\2\2\u018e\u018f\t\30\2\2\u018f\u0191\7}\2\2\u0190"+
		"\u0192\5\16\b\2\u0191\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0191\3"+
		"\2\2\2\u0193\u0194\3\2\2\2\u0194\u01b7\3\2\2\2\u0195\u0196\t\31\2\2\u0196"+
		"\u0197\5\26\f\2\u0197\u0198\7}\2\2\u0198\u01b7\3\2\2\2\u0199\u019a\6\13"+
		"\t\2\u019a\u019b\7<\2\2\u019b\u019c\7~\2\2\u019c\u019e\7}\2\2\u019d\u019f"+
		"\5\16\b\2\u019e\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u019e\3\2\2\2"+
		"\u01a0\u01a1\3\2\2\2\u01a1\u01b7\3\2\2\2\u01a2\u01a3\7<\2\2\u01a3\u01a4"+
		"\7~\2\2\u01a4\u01a5\5\26\f\2\u01a5\u01a6\7}\2\2\u01a6\u01b7\3\2\2\2\u01a7"+
		"\u01ab\7b\2\2\u01a8\u01aa\5\26\f\2\u01a9\u01a8\3\2\2\2\u01aa\u01ad\3\2"+
		"\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01b7\3\2\2\2\u01ad"+
		"\u01ab\3\2\2\2\u01ae\u01b7\7c\2\2\u01af\u01b3\7d\2\2\u01b0\u01b2\5\26"+
		"\f\2\u01b1\u01b0\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3"+
		"\u01b4\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6\u013a\3\2"+
		"\2\2\u01b6\u013e\3\2\2\2\u01b6\u0145\3\2\2\2\u01b6\u014b\3\2\2\2\u01b6"+
		"\u0151\3\2\2\2\u01b6\u0159\3\2\2\2\u01b6\u015f\3\2\2\2\u01b6\u0166\3\2"+
		"\2\2\u01b6\u016d\3\2\2\2\u01b6\u0174\3\2\2\2\u01b6\u0177\3\2\2\2\u01b6"+
		"\u017e\3\2\2\2\u01b6\u0186\3\2\2\2\u01b6\u018e\3\2\2\2\u01b6\u0195\3\2"+
		"\2\2\u01b6\u0199\3\2\2\2\u01b6\u01a2\3\2\2\2\u01b6\u01a7\3\2\2\2\u01b6"+
		"\u01ae\3\2\2\2\u01b6\u01af\3\2\2\2\u01b7\25\3\2\2\2\u01b8\u01b9\t\32\2"+
		"\2\u01b9\27\3\2\2\2\u01ba\u01bc\7\u0081\2\2\u01bb\u01ba\3\2\2\2\u01bc"+
		"\u01bf\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01da\3\2"+
		"\2\2\u01bf\u01bd\3\2\2\2\u01c0\u01c1\7e\2\2\u01c1\u01c2\7~\2\2\u01c2\u01c3"+
		"\7\b\2\2\u01c3\u01c4\7~\2\2\u01c4\u01c5\7\b\2\2\u01c5\u01c6\7f\2\2\u01c6"+
		"\u01c7\7\b\2\2\u01c7\u01c9\7g\2\2\u01c8\u01ca\7\u0081\2\2\u01c9\u01c8"+
		"\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc"+
		"\u01d7\3\2\2\2\u01cd\u01ce\5\32\16\2\u01ce\u01cf\7h\2\2\u01cf\u01d0\5"+
		"\34\17\2\u01d0\u01d4\7h\2\2\u01d1\u01d3\7\u0081\2\2\u01d2\u01d1\3\2\2"+
		"\2\u01d3\u01d6\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d8"+
		"\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d7\u01cd\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8"+
		"\u01d9\3\2\2\2\u01d9\u01db\5&\24\2\u01da\u01c0\3\2\2\2\u01da\u01db\3\2"+
		"\2\2\u01db\31\3\2\2\2\u01dc\u01dd\t\33\2\2\u01dd\33\3\2\2\2\u01de\u01e2"+
		"\7\6\2\2\u01df\u01e1\7\u0081\2\2\u01e0\u01df\3\2\2\2\u01e1\u01e4\3\2\2"+
		"\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e5\3\2\2\2\u01e4\u01e2"+
		"\3\2\2\2\u01e5\u01e9\7i\2\2\u01e6\u01e8\7\u0081\2\2\u01e7\u01e6\3\2\2"+
		"\2\u01e8\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ed"+
		"\3\2\2\2\u01eb\u01e9\3\2\2\2\u01ec\u01ee\5\36\20\2\u01ed\u01ec\3\2\2\2"+
		"\u01ed\u01ee\3\2\2\2\u01ee\u01f9\3\2\2\2\u01ef\u01f1\7\u0081\2\2\u01f0"+
		"\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2"+
		"\2\2\u01f3\u01f5\3\2\2\2\u01f4\u01f6\5\36\20\2\u01f5\u01f4\3\2\2\2\u01f5"+
		"\u01f6\3\2\2\2\u01f6\u01f8\3\2\2\2\u01f7\u01f0\3\2\2\2\u01f8\u01fb\3\2"+
		"\2\2\u01f9\u01f7\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fc\3\2\2\2\u01fb"+
		"\u01f9\3\2\2\2\u01fc\u0200\7\7\2\2\u01fd\u01ff\7\u0081\2\2\u01fe\u01fd"+
		"\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2\2\2\u0200\u0201\3\2\2\2\u0201"+
		"\35\3\2\2\2\u0202\u0200\3\2\2\2\u0203\u0206\5 \21\2\u0204\u0206\5\"\22"+
		"\2\u0205\u0203\3\2\2\2\u0205\u0204\3\2\2\2\u0206\37\3\2\2\2\u0207\u0208"+
		"\7~\2\2\u0208\u0209\7\b\2\2\u0209\u020a\5\16\b\2\u020a!\3\2\2\2\u020b"+
		"\u020c\7j\2\2\u020c\u020e\7~\2\2\u020d\u020f\7\u0081\2\2\u020e\u020d\3"+
		"\2\2\2\u020e\u020f\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0211\7\22\2\2\u0211"+
		"\u0216\5$\23\2\u0212\u0213\7\3\2\2\u0213\u0215\5$\23\2\u0214\u0212\3\2"+
		"\2\2\u0215\u0218\3\2\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217"+
		"\u0219\3\2\2\2\u0218\u0216\3\2\2\2\u0219\u021a\7\23\2\2\u021a\u021b\7"+
		"\t\2\2\u021b\u021c\5\22\n\2\u021c#\3\2\2\2\u021d\u021e\7~\2\2\u021e\u021f"+
		"\7\t\2\2\u021f\u0220\5\22\n\2\u0220%\3\2\2\2\u0221\u0223\5(\25\2\u0222"+
		"\u0221\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u022e\3\2\2\2\u0224\u0226\7\u0081"+
		"\2\2\u0225\u0224\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0225\3\2\2\2\u0227"+
		"\u0228\3\2\2\2\u0228\u022a\3\2\2\2\u0229\u022b\5(\25\2\u022a\u0229\3\2"+
		"\2\2\u022a\u022b\3\2\2\2\u022b\u022d\3\2\2\2\u022c\u0225\3\2\2\2\u022d"+
		"\u0230\3\2\2\2\u022e\u022c\3\2\2\2\u022e\u022f\3\2\2\2\u022f\'\3\2\2\2"+
		"\u0230\u022e\3\2\2\2\u0231\u0232\t\34\2\2\u0232\u0233\7~\2\2\u0233\u0234"+
		"\7\t\2\2\u0234\u0235\5\22\n\2\u0235\u0237\7\"\2\2\u0236\u0238\7\u0081"+
		"\2\2\u0237\u0236\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u0239\3\2\2\2\u0239"+
		"\u023a\5*\26\2\u023a\u02d3\3\2\2\2\u023b\u023c\7~\2\2\u023c\u023e\7\""+
		"\2\2\u023d\u023f\7\u0081\2\2\u023e\u023d\3\2\2\2\u023e\u023f\3\2\2\2\u023f"+
		"\u0240\3\2\2\2\u0240\u02d3\5*\26\2\u0241\u0242\7m\2\2\u0242\u0243\7\22"+
		"\2\2\u0243\u0244\5*\26\2\u0244\u0245\7\23\2\2\u0245\u02d3\3\2\2\2\u0246"+
		"\u0247\7n\2\2\u0247\u0248\7\22\2\2\u0248\u0249\5*\26\2\u0249\u024d\7\23"+
		"\2\2\u024a\u024c\7\u0081\2\2\u024b\u024a\3\2\2\2\u024c\u024f\3\2\2\2\u024d"+
		"\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u0250\3\2\2\2\u024f\u024d\3\2"+
		"\2\2\u0250\u0251\7\6\2\2\u0251\u0252\5&\24\2\u0252\u025e\7\7\2\2\u0253"+
		"\u0257\7o\2\2\u0254\u0256\7\u0081\2\2\u0255\u0254\3\2\2\2\u0256\u0259"+
		"\3\2\2\2\u0257\u0255\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u025a\3\2\2\2\u0259"+
		"\u0257\3\2\2\2\u025a\u025b\7\6\2\2\u025b\u025c\5&\24\2\u025c\u025d\7\7"+
		"\2\2\u025d\u025f\3\2\2\2\u025e\u0253\3\2\2\2\u025e\u025f\3\2\2\2\u025f"+
		"\u02d3\3\2\2\2\u0260\u0261\7p\2\2\u0261\u0262\7\22\2\2\u0262\u0263\5*"+
		"\26\2\u0263\u0267\7\23\2\2\u0264\u0266\7\u0081\2\2\u0265\u0264\3\2\2\2"+
		"\u0266\u0269\3\2\2\2\u0267\u0265\3\2\2\2\u0267\u0268\3\2\2\2\u0268\u026a"+
		"\3\2\2\2\u0269\u0267\3\2\2\2\u026a\u0276\7\6\2\2\u026b\u026d\7\u0081\2"+
		"\2\u026c\u026b\3\2\2\2\u026d\u0270\3\2\2\2\u026e\u026c\3\2\2\2\u026e\u026f"+
		"\3\2\2\2\u026f\u0271\3\2\2\2\u0270\u026e\3\2\2\2\u0271\u0272\5\32\16\2"+
		"\u0272\u0273\7h\2\2\u0273\u0274\5,\27\2\u0274\u0275\7h\2\2\u0275\u0277"+
		"\3\2\2\2\u0276\u026e\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0278\3\2\2\2\u0278"+
		"\u0279\5&\24\2\u0279\u027a\7\7\2\2\u027a\u02d3\3\2\2\2\u027b\u027c\t\35"+
		"\2\2\u027c\u027d\7\22\2\2\u027d\u027e\7~\2\2\u027e\u027f\7\177\2\2\u027f"+
		"\u02d3\7\23\2\2\u0280\u0281\7~\2\2\u0281\u0282\7\22\2\2\u0282\u0283\5"+
		"*\26\2\u0283\u0284\7\23\2\2\u0284\u0286\7\"\2\2\u0285\u0287\7\u0081\2"+
		"\2\u0286\u0285\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u0289"+
		"\5*\26\2\u0289\u02d3\3\2\2\2\u028a\u028b\7j\2\2\u028b\u028d\7~\2\2\u028c"+
		"\u028e\7\u0081\2\2\u028d\u028c\3\2\2\2\u028d\u028e\3\2\2\2\u028e\u028f"+
		"\3\2\2\2\u028f\u0298\7\22\2\2\u0290\u0295\5$\23\2\u0291\u0292\7\3\2\2"+
		"\u0292\u0294\5$\23\2\u0293\u0291\3\2\2\2\u0294\u0297\3\2\2\2\u0295\u0293"+
		"\3\2\2\2\u0295\u0296\3\2\2\2\u0296\u0299\3\2\2\2\u0297\u0295\3\2\2\2\u0298"+
		"\u0290\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u029a\3\2\2\2\u029a\u029b\7\23"+
		"\2\2\u029b\u029e\7\t\2\2\u029c\u029f\5\22\n\2\u029d\u029f\7s\2\2\u029e"+
		"\u029c\3\2\2\2\u029e\u029d\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0\u02a4\7\""+
		"\2\2\u02a1\u02a3\7\u0081\2\2\u02a2\u02a1\3\2\2\2\u02a3\u02a6\3\2\2\2\u02a4"+
		"\u02a2\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a7\3\2\2\2\u02a6\u02a4\3\2"+
		"\2\2\u02a7\u02b9\7\6\2\2\u02a8\u02aa\7\u0081\2\2\u02a9\u02a8\3\2\2\2\u02aa"+
		"\u02ad\3\2\2\2\u02ab\u02a9\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02ae\3\2"+
		"\2\2\u02ad\u02ab\3\2\2\2\u02ae\u02af\5\32\16\2\u02af\u02b0\7h\2\2\u02b0"+
		"\u02b4\5\60\31\2\u02b1\u02b3\7\u0081\2\2\u02b2\u02b1\3\2\2\2\u02b3\u02b6"+
		"\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02b7\3\2\2\2\u02b6"+
		"\u02b4\3\2\2\2\u02b7\u02b8\7h\2\2\u02b8\u02ba\3\2\2\2\u02b9\u02ab\3\2"+
		"\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bb\u02c4\5&\24\2\u02bc"+
		"\u02bd\7t\2\2\u02bd\u02c1\5*\26\2\u02be\u02c0\7\u0081\2\2\u02bf\u02be"+
		"\3\2\2\2\u02c0\u02c3\3\2\2\2\u02c1\u02bf\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2"+
		"\u02c5\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c4\u02bc\3\2\2\2\u02c4\u02c5\3\2"+
		"\2\2\u02c5\u02c6\3\2\2\2\u02c6\u02c7\7\7\2\2\u02c7\u02d3\3\2\2\2\u02c8"+
		"\u02c9\5\32\16\2\u02c9\u02cd\7h\2\2\u02ca\u02ce\5\n\6\2\u02cb\u02ce\5"+
		"\b\5\2\u02cc\u02ce\5\62\32\2\u02cd\u02ca\3\2\2\2\u02cd\u02cb\3\2\2\2\u02cd"+
		"\u02cc\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf\u02d0\7h\2\2\u02d0\u02d3\3\2"+
		"\2\2\u02d1\u02d3\5*\26\2\u02d2\u0231\3\2\2\2\u02d2\u023b\3\2\2\2\u02d2"+
		"\u0241\3\2\2\2\u02d2\u0246\3\2\2\2\u02d2\u0260\3\2\2\2\u02d2\u027b\3\2"+
		"\2\2\u02d2\u0280\3\2\2\2\u02d2\u028a\3\2\2\2\u02d2\u02c8\3\2\2\2\u02d2"+
		"\u02d1\3\2\2\2\u02d3)\3\2\2\2\u02d4\u02d5\b\26\1\2\u02d5\u02d6\t\36\2"+
		"\2\u02d6\u0306\5*\26\n\u02d7\u0306\t\4\2\2\u02d8\u0306\7}\2\2\u02d9\u02e8"+
		"\7~\2\2\u02da\u02e3\7\22\2\2\u02db\u02e0\5*\26\2\u02dc\u02dd\7\3\2\2\u02dd"+
		"\u02df\5*\26\2\u02de\u02dc\3\2\2\2\u02df\u02e2\3\2\2\2\u02e0\u02de\3\2"+
		"\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02e4\3\2\2\2\u02e2\u02e0\3\2\2\2\u02e3"+
		"\u02db\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e5\3\2\2\2\u02e5\u02e9\7\23"+
		"\2\2\u02e6\u02e7\7\b\2\2\u02e7\u02e9\7~\2\2\u02e8\u02da\3\2\2\2\u02e8"+
		"\u02e6\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u0306\3\2\2\2\u02ea\u02eb\7\25"+
		"\2\2\u02eb\u02ec\7\22\2\2\u02ec\u02ed\7\177\2\2\u02ed\u0306\7\23\2\2\u02ee"+
		"\u02ef\7\26\2\2\u02ef\u02f8\7\22\2\2\u02f0\u02f5\5*\26\2\u02f1\u02f2\7"+
		"\3\2\2\u02f2\u02f4\5*\26\2\u02f3\u02f1\3\2\2\2\u02f4\u02f7\3\2\2\2\u02f5"+
		"\u02f3\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u02f9\3\2\2\2\u02f7\u02f5\3\2"+
		"\2\2\u02f8\u02f0\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa"+
		"\u0306\7\23\2\2\u02fb\u02fc\7u\2\2\u02fc\u02fe\7\22\2\2\u02fd\u02ff\7"+
		"\177\2\2\u02fe\u02fd\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0300\3\2\2\2\u0300"+
		"\u0306\7\23\2\2\u0301\u0302\7\22\2\2\u0302\u0303\5*\26\2\u0303\u0304\7"+
		"\23\2\2\u0304\u0306\3\2\2\2\u0305\u02d4\3\2\2\2\u0305\u02d7\3\2\2\2\u0305"+
		"\u02d8\3\2\2\2\u0305\u02d9\3\2\2\2\u0305\u02ea\3\2\2\2\u0305\u02ee\3\2"+
		"\2\2\u0305\u02fb\3\2\2\2\u0305\u0301\3\2\2\2\u0306\u0333\3\2\2\2\u0307"+
		"\u0308\f\t\2\2\u0308\u030a\t\5\2\2\u0309\u030b\7\u0081\2\2\u030a\u0309"+
		"\3\2\2\2\u030a\u030b\3\2\2\2\u030b\u030c\3\2\2\2\u030c\u0332\5*\26\n\u030d"+
		"\u030e\f\b\2\2\u030e\u0310\t\37\2\2\u030f\u0311\7\u0081\2\2\u0310\u030f"+
		"\3\2\2\2\u0310\u0311\3\2\2\2\u0311\u0312\3\2\2\2\u0312\u0332\5*\26\t\u0313"+
		"\u0314\f\7\2\2\u0314\u0316\7v\2\2\u0315\u0317\7\u0081\2\2\u0316\u0315"+
		"\3\2\2\2\u0316\u0317\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u0332\5*\26\b\u0319"+
		"\u031a\f\6\2\2\u031a\u031c\t \2\2\u031b\u031d\7\u0081\2\2\u031c\u031b"+
		"\3\2\2\2\u031c\u031d\3\2\2\2\u031d\u031e\3\2\2\2\u031e\u0332\5*\26\7\u031f"+
		"\u0320\f\5\2\2\u0320\u0322\t!\2\2\u0321\u0323\7\u0081\2\2\u0322\u0321"+
		"\3\2\2\2\u0322\u0323\3\2\2\2\u0323\u0324\3\2\2\2\u0324\u0332\5*\26\6\u0325"+
		"\u0326\f\4\2\2\u0326\u0328\7+\2\2\u0327\u0329\7\u0081\2\2\u0328\u0327"+
		"\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032a\3\2\2\2\u032a\u0332\5*\26\5\u032b"+
		"\u032c\f\3\2\2\u032c\u032e\7/\2\2\u032d\u032f\7\u0081\2\2\u032e\u032d"+
		"\3\2\2\2\u032e\u032f\3\2\2\2\u032f\u0330\3\2\2\2\u0330\u0332\5*\26\4\u0331"+
		"\u0307\3\2\2\2\u0331\u030d\3\2\2\2\u0331\u0313\3\2\2\2\u0331\u0319\3\2"+
		"\2\2\u0331\u031f\3\2\2\2\u0331\u0325\3\2\2\2\u0331\u032b\3\2\2\2\u0332"+
		"\u0335\3\2\2\2\u0333\u0331\3\2\2\2\u0333\u0334\3\2\2\2\u0334+\3\2\2\2"+
		"\u0335\u0333\3\2\2\2\u0336\u033a\7\6\2\2\u0337\u0339\7\u0081\2\2\u0338"+
		"\u0337\3\2\2\2\u0339\u033c\3\2\2\2\u033a\u0338\3\2\2\2\u033a\u033b\3\2"+
		"\2\2\u033b\u033d\3\2\2\2\u033c\u033a\3\2\2\2\u033d\u0341\7c\2\2\u033e"+
		"\u0340\7\u0081\2\2\u033f\u033e\3\2\2\2\u0340\u0343\3\2\2\2\u0341\u033f"+
		"\3\2\2\2\u0341\u0342\3\2\2\2\u0342\u0345\3\2\2\2\u0343\u0341\3\2\2\2\u0344"+
		"\u0346\5\16\b\2\u0345\u0344\3\2\2\2\u0345\u0346\3\2\2\2\u0346\u0351\3"+
		"\2\2\2\u0347\u0349\7\u0081\2\2\u0348\u0347\3\2\2\2\u0349\u034a\3\2\2\2"+
		"\u034a\u0348\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u034d\3\2\2\2\u034c\u034e"+
		"\5\16\b\2\u034d\u034c\3\2\2\2\u034d\u034e\3\2\2\2\u034e\u0350\3\2\2\2"+
		"\u034f\u0348\3\2\2\2\u0350\u0353\3\2\2\2\u0351\u034f\3\2\2\2\u0351\u0352"+
		"\3\2\2\2\u0352\u0354\3\2\2\2\u0353\u0351\3\2\2\2\u0354\u0355\5.\30\2\u0355"+
		"\u0359\7\7\2\2\u0356\u0358\7\u0081\2\2\u0357\u0356\3\2\2\2\u0358\u035b"+
		"\3\2\2\2\u0359\u0357\3\2\2\2\u0359\u035a\3\2\2\2\u035a-\3\2\2\2\u035b"+
		"\u0359\3\2\2\2\u035c\u0365\7w\2\2\u035d\u0362\7~\2\2\u035e\u035f\7\3\2"+
		"\2\u035f\u0361\7~\2\2\u0360\u035e\3\2\2\2\u0361\u0364\3\2\2\2\u0362\u0360"+
		"\3\2\2\2\u0362\u0363\3\2\2\2\u0363\u0366\3\2\2\2\u0364\u0362\3\2\2\2\u0365"+
		"\u035d\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u036a\3\2\2\2\u0367\u0369\7\u0081"+
		"\2\2\u0368\u0367\3\2\2\2\u0369\u036c\3\2\2\2\u036a\u0368\3\2\2\2\u036a"+
		"\u036b\3\2\2\2\u036b/\3\2\2\2\u036c\u036a\3\2\2\2\u036d\u0371\7\6\2\2"+
		"\u036e\u0370\7\u0081\2\2\u036f\u036e\3\2\2\2\u0370\u0373\3\2\2\2\u0371"+
		"\u036f\3\2\2\2\u0371\u0372\3\2\2\2\u0372\u0389\3\2\2\2\u0373\u0371\3\2"+
		"\2\2\u0374\u0378\t\"\2\2\u0375\u0377\7\u0081\2\2\u0376\u0375\3\2\2\2\u0377"+
		"\u037a\3\2\2\2\u0378\u0376\3\2\2\2\u0378\u0379\3\2\2\2\u0379\u037b\3\2"+
		"\2\2\u037a\u0378\3\2\2\2\u037b\u0386\5\16\b\2\u037c\u037e\7\u0081\2\2"+
		"\u037d\u037c\3\2\2\2\u037e\u037f\3\2\2\2\u037f\u037d\3\2\2\2\u037f\u0380"+
		"\3\2\2\2\u0380\u0382\3\2\2\2\u0381\u0383\5\16\b\2\u0382\u0381\3\2\2\2"+
		"\u0382\u0383\3\2\2\2\u0383\u0385\3\2\2\2\u0384\u037d\3\2\2\2\u0385\u0388"+
		"\3\2\2\2\u0386\u0384\3\2\2\2\u0386\u0387\3\2\2\2\u0387\u038a\3\2\2\2\u0388"+
		"\u0386\3\2\2\2\u0389\u0374\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u038e\3\2"+
		"\2\2\u038b\u038d\7\u0081\2\2\u038c\u038b\3\2\2\2\u038d\u0390\3\2\2\2\u038e"+
		"\u038c\3\2\2\2\u038e\u038f\3\2\2\2\u038f\u0392\3\2\2\2\u0390\u038e\3\2"+
		"\2\2\u0391\u0393\5.\30\2\u0392\u0391\3\2\2\2\u0392\u0393\3\2\2\2\u0393"+
		"\u03a9\3\2\2\2\u0394\u0398\t#\2\2\u0395\u0397\7\u0081\2\2\u0396\u0395"+
		"\3\2\2\2\u0397\u039a\3\2\2\2\u0398\u0396\3\2\2\2\u0398\u0399\3\2\2\2\u0399"+
		"\u039b\3\2\2\2\u039a\u0398\3\2\2\2\u039b\u03a6\5\16\b\2\u039c\u039e\7"+
		"\u0081\2\2\u039d\u039c\3\2\2\2\u039e\u039f\3\2\2\2\u039f\u039d\3\2\2\2"+
		"\u039f\u03a0\3\2\2\2\u03a0\u03a2\3\2\2\2\u03a1\u03a3\5\16\b\2\u03a2\u03a1"+
		"\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3\u03a5\3\2\2\2\u03a4\u039d\3\2\2\2\u03a5"+
		"\u03a8\3\2\2\2\u03a6\u03a4\3\2\2\2\u03a6\u03a7\3\2\2\2\u03a7\u03aa\3\2"+
		"\2\2\u03a8\u03a6\3\2\2\2\u03a9\u0394\3\2\2\2\u03a9\u03aa\3\2\2\2\u03aa"+
		"\u03ae\3\2\2\2\u03ab\u03ad\7\u0081\2\2\u03ac\u03ab\3\2\2\2\u03ad\u03b0"+
		"\3\2\2\2\u03ae\u03ac\3\2\2\2\u03ae\u03af\3\2\2\2\u03af\u03b1\3\2\2\2\u03b0"+
		"\u03ae\3\2\2\2\u03b1\u03b5\7\7\2\2\u03b2\u03b4\7\u0081\2\2\u03b3\u03b2"+
		"\3\2\2\2\u03b4\u03b7\3\2\2\2\u03b5\u03b3\3\2\2\2\u03b5\u03b6\3\2\2\2\u03b6"+
		"\61\3\2\2\2\u03b7\u03b5\3\2\2\2\u03b8\u03bc\7\6\2\2\u03b9\u03bb\7\u0081"+
		"\2\2\u03ba\u03b9\3\2\2\2\u03bb\u03be\3\2\2\2\u03bc\u03ba\3\2\2\2\u03bc"+
		"\u03bd\3\2\2\2\u03bd\u03bf\3\2\2\2\u03be\u03bc\3\2\2\2\u03bf\u03c3\7c"+
		"\2\2\u03c0\u03c2\7\u0081\2\2\u03c1\u03c0\3\2\2\2\u03c2\u03c5\3\2\2\2\u03c3"+
		"\u03c1\3\2\2\2\u03c3\u03c4\3\2\2\2\u03c4\u03c7\3\2\2\2\u03c5\u03c3\3\2"+
		"\2\2\u03c6\u03c8\5\16\b\2\u03c7\u03c6\3\2\2\2\u03c7\u03c8\3\2\2\2\u03c8"+
		"\u03d3\3\2\2\2\u03c9\u03cb\7\u0081\2\2\u03ca\u03c9\3\2\2\2\u03cb\u03cc"+
		"\3\2\2\2\u03cc\u03ca\3\2\2\2\u03cc\u03cd\3\2\2\2\u03cd\u03cf\3\2\2\2\u03ce"+
		"\u03d0\5\16\b\2\u03cf\u03ce\3\2\2\2\u03cf\u03d0\3\2\2\2\u03d0\u03d2\3"+
		"\2\2\2\u03d1\u03ca\3\2\2\2\u03d2\u03d5\3\2\2\2\u03d3\u03d1\3\2\2\2\u03d3"+
		"\u03d4\3\2\2\2\u03d4\u03d6\3\2\2\2\u03d5\u03d3\3\2\2\2\u03d6\u03da\7\7"+
		"\2\2\u03d7\u03d9\7\u0081\2\2\u03d8\u03d7\3\2\2\2\u03d9\u03dc\3\2\2\2\u03da"+
		"\u03d8\3\2\2\2\u03da\u03db\3\2\2\2\u03db\63\3\2\2\2\u03dc\u03da\3\2\2"+
		"\2\u00948<AQT\\bikotw{\u0082\u008f\u0096\u009e\u00a6\u00ab\u00b0\u00b3"+
		"\u00b7\u00bb\u00c6\u00d4\u00e5\u00e8\u00ec\u00f1\u00f7\u00fd\u0103\u0109"+
		"\u010f\u0115\u0118\u011a\u0123\u012d\u0131\u0138\u013e\u0145\u014b\u0151"+
		"\u0159\u015f\u0166\u016d\u0174\u017e\u0186\u018c\u0193\u01a0\u01ab\u01b3"+
		"\u01b6\u01bd\u01cb\u01d4\u01d7\u01da\u01e2\u01e9\u01ed\u01f2\u01f5\u01f9"+
		"\u0200\u0205\u020e\u0216\u0222\u0227\u022a\u022e\u0237\u023e\u024d\u0257"+
		"\u025e\u0267\u026e\u0276\u0286\u028d\u0295\u0298\u029e\u02a4\u02ab\u02b4"+
		"\u02b9\u02c1\u02c4\u02cd\u02d2\u02e0\u02e3\u02e8\u02f5\u02f8\u02fe\u0305"+
		"\u030a\u0310\u0316\u031c\u0322\u0328\u032e\u0331\u0333\u033a\u0341\u0345"+
		"\u034a\u034d\u0351\u0359\u0362\u0365\u036a\u0371\u0378\u037f\u0382\u0386"+
		"\u0389\u038e\u0392\u0398\u039f\u03a2\u03a6\u03a9\u03ae\u03b5\u03bc\u03c3"+
		"\u03c7\u03cc\u03cf\u03d3\u03da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}