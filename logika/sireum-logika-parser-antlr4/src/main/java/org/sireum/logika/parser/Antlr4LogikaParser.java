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
		T__113=114, T__114=115, HLINE=116, INT=117, NUM=118, ID=119, STRING=120, 
		RESERVED=121, NL=122, LINE_COMMENT=123, COMMENT=124, WS=125, ERROR_CHAR=126, 
		INTRO=127, INTRO1=128, INTRO2=129, ELIM=130, ELIM1=131, ELIM2=132, ORG=133, 
		SIREUM=134, LOGIKA=135, L=136, S=137, CLONE=138, SIZE=139;
	public static final int
		RULE_sequentFile = 0, RULE_proofFile = 1, RULE_programFile = 2, RULE_sequent = 3, 
		RULE_proof = 4, RULE_proofStep = 5, RULE_formula = 6, RULE_qformula = 7, 
		RULE_justification = 8, RULE_numOrId = 9, RULE_program = 10, RULE_stmts = 11, 
		RULE_stmt = 12, RULE_lgk = 13, RULE_exp = 14, RULE_type = 15, RULE_loopInvariant = 16, 
		RULE_modifies = 17, RULE_methodDecl = 18, RULE_param = 19, RULE_methodContract = 20, 
		RULE_invariants = 21, RULE_facts = 22, RULE_fact = 23;
	public static final String[] ruleNames = {
		"sequentFile", "proofFile", "programFile", "sequent", "proof", "proofStep", 
		"formula", "qformula", "justification", "numOrId", "program", "stmts", 
		"stmt", "lgk", "exp", "type", "loopInvariant", "modifies", "methodDecl", 
		"param", "methodContract", "invariants", "facts", "fact"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'|-'", "'⊢'", "'{'", "'}'", "'.'", "'assume'", "'false'", 
		"'F'", "'_|_'", "'⊥'", "'true'", "'T'", "'('", "')'", "'$result'", "'*'", 
		"'/'", "'%'", "'+'", "'-'", "'<'", "'<='", "'≤'", "'>'", "'>='", "'≥'", 
		"'='", "'=='", "'!='", "'≠'", "'not'", "'!'", "'~'", "'¬'", "'and'", "'&&'", 
		"'∧'", "'or'", "'||'", "'∨'", "'implies'", "'->'", "'=>'", "'→'", "'⇒'", 
		"'forall'", "'all'", "'A'", "'∀'", "'exists'", "'some'", "'E'", "'∃'", 
		"'|'", "'premise'", "'andi'", "'ande1'", "'ande2'", "'ori1'", "'ori2'", 
		"'ore'", "'impliesi'", "'impliese'", "'noti'", "'negi'", "'note'", "'nege'", 
		"'falsee'", "'Pbc'", "'foralli'", "'alli'", "'Ai'", "'foralle'", "'alle'", 
		"'Ae'", "'existsi'", "'somei'", "'Ei'", "'existse'", "'somee'", "'Ee'", 
		"'algebra'", "'auto'", "'import'", "'_'", "'var'", "'val'", "':'", "'assert'", 
		"'if'", "'else'", "'while'", "'\"\"\"'", "'readInt'", "'print'", "'println'", 
		"'+:'", "':+'", "'BigInt'", "'Z'", "'Seq'", "'Zs'", "'Boolean'", "'B'", 
		"'['", "']'", "'invariant'", "'modifies'", "'def'", "'Unit'", "'return'", 
		"'requires'", "'ensures'", "'fact'", null, null, null, null, null, null, 
		null, null, null, null, null, "'i'", "'i1'", "'i2'", "'e'", "'e1'", "'e2'", 
		"'org'", "'sireum'", "'logika'", "'l'", "'s'", "'clone'", "'size'"
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
		null, null, null, null, null, null, null, null, "HLINE", "INT", "NUM", 
		"ID", "STRING", "RESERVED", "NL", "LINE_COMMENT", "COMMENT", "WS", "ERROR_CHAR", 
		"INTRO", "INTRO1", "INTRO2", "ELIM", "ELIM1", "ELIM2", "ORG", "SIREUM", 
		"LOGIKA", "L", "S", "CLONE", "SIZE"
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
			setState(48);
			sequent();
			setState(50);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(49);
				proof();
				}
			}

			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(52);
				match(NL);
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
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
			setState(60);
			proof();
			setState(61);
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
			setState(63);
			program();
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

	public static class SequentContext extends ParserRuleContext {
		public FormulaContext formula;
		public List<FormulaContext> premises = new ArrayList<FormulaContext>();
		public Token tb;
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
			setState(97);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==INT || _la==ID) {
					{
					setState(66);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(67);
						match(T__0);
						setState(68);
						((SequentContext)_localctx).formula = formula(0);
						((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
						}
						}
						setState(73);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(76);
				((SequentContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
					((SequentContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(77);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(78);
					match(T__0);
					setState(79);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==INT || _la==ID) {
					{
					{
					setState(85);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(91);
				((SequentContext)_localctx).tb = match(HLINE);
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(92);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(95); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==INT || _la==ID );
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
			setState(99);
			((ProofContext)_localctx).tb = match(T__3);
			setState(101);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(100);
				proofStep();
				}
			}

			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(104); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(103);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(106); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(109);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(108);
					proofStep();
					}
				}

				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
			((ProofContext)_localctx).te = match(T__4);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(117);
					match(NL);
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		public Token fresh;
		public Token te;
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
		public Token tb;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public JustificationContext justification() {
			return getRuleContext(JustificationContext.class,0);
		}
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public StepContext(ProofStepContext ctx) { copyFrom(ctx); }
	}

	public final ProofStepContext proofStep() throws RecognitionException {
		ProofStepContext _localctx = new ProofStepContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_proofStep);
		int _la;
		try {
			setState(166);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				((StepContext)_localctx).tb = match(NUM);
				setState(124);
				match(T__5);
				setState(125);
				formula(0);
				setState(126);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(129);
				match(T__5);
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
				match(T__3);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(137);
					match(NL);
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(143);
				((SubProofContext)_localctx).assume = match(NUM);
				setState(144);
				match(T__5);
				setState(152);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(145);
					((SubProofContext)_localctx).fresh = match(ID);
					}
					break;
				case 2:
					{
					setState(147);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						setState(146);
						((SubProofContext)_localctx).fresh = match(ID);
						}
						break;
					}
					setState(149);
					formula(0);
					setState(150);
					match(T__6);
					}
					break;
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(155); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(154);
						match(NL);
						}
						}
						setState(157); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NL );
					setState(159);
					proofStep();
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(165);
				((SubProofContext)_localctx).te = match(T__4);
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
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public TerminalNode SIZE() { return getToken(Antlr4LogikaParser.SIZE, 0); }
		public VarContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class ApplyContext extends FormulaContext {
		public Token fun;
		public Token te;
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
		public Token t;
		public TrueContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class FalseContext extends FormulaContext {
		public Token t;
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
		public Token t;
		public TerminalNode INT() { return getToken(Antlr4LogikaParser.INT, 0); }
		public IntContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class ParenContext extends FormulaContext {
		public Token tb;
		public Token te;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ParenContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class ResultContext extends FormulaContext {
		public Token t;
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
			setState(199);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(169);
				((UnaryContext)_localctx).op = match(T__20);
				setState(170);
				formula(6);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(172);
				formula(5);
				}
				break;
			case 3:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173);
				((FalseContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
					((FalseContext)_localctx).t = (Token)_errHandler.recoverInline(this);
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
				setState(174);
				((TrueContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__12) ) {
					((TrueContext)_localctx).t = (Token)_errHandler.recoverInline(this);
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
				setState(175);
				((VarContext)_localctx).tb = match(ID);
				setState(178);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(176);
					match(T__5);
					setState(177);
					((VarContext)_localctx).te = match(SIZE);
					}
					break;
				}
				}
				break;
			case 6:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				((ParenContext)_localctx).tb = match(T__13);
				setState(181);
				formula(0);
				setState(182);
				((ParenContext)_localctx).te = match(T__14);
				}
				break;
			case 7:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				((ResultContext)_localctx).t = match(T__15);
				}
				break;
			case 8:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				((ApplyContext)_localctx).fun = match(ID);
				setState(186);
				match(T__13);
				setState(187);
				formula(0);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(188);
					match(T__0);
					setState(189);
					formula(0);
					}
					}
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(195);
				((ApplyContext)_localctx).te = match(T__14);
				}
				break;
			case 9:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				((IntContext)_localctx).t = match(INT);
				}
				break;
			case 10:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(245);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(243);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(201);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(202);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(204);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(203);
							match(NL);
							}
						}

						setState(206);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(207);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(208);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(210);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(209);
							match(NL);
							}
						}

						setState(212);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(213);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(214);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(216);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(215);
							match(NL);
							}
						}

						setState(218);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(219);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(220);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(222);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(221);
							match(NL);
							}
						}

						setState(224);
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(225);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(226);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(228);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(227);
							match(NL);
							}
						}

						setState(230);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(231);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(232);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__39) | (1L << T__40))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(234);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(233);
							match(NL);
							}
						}

						setState(236);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(237);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(238);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(240);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(239);
							match(NL);
							}
						}

						setState(242);
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(247);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		public List<Token> gVars = new ArrayList<Token>();
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
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
			setState(248);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(250); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(249);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).gVars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(252); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(254);
			match(T__54);
			setState(256);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(255);
				match(NL);
				}
			}

			setState(258);
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
		public Token tb;
		public NumOrIdContext stepOrFact;
		public NumOrIdContext numOrId() {
			return getRuleContext(NumOrIdContext.class,0);
		}
		public TerminalNode ELIM() { return getToken(Antlr4LogikaParser.ELIM, 0); }
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
		public TerminalNode INTRO() { return getToken(Antlr4LogikaParser.INTRO, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
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
		public TerminalNode INTRO() { return getToken(Antlr4LogikaParser.INTRO, 0); }
		public AndIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ForallIntroContext extends JustificationContext {
		public Token tb;
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode INTRO() { return getToken(Antlr4LogikaParser.INTRO, 0); }
		public ForallIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ImpliesElimContext extends JustificationContext {
		public Token tb;
		public Token impliesStep;
		public Token antecedentStep;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public TerminalNode ELIM() { return getToken(Antlr4LogikaParser.ELIM, 0); }
		public ImpliesElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class PremiseContext extends JustificationContext {
		public Token t;
		public PremiseContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndElim2Context extends JustificationContext {
		public Token tb;
		public Token andStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ELIM2() { return getToken(Antlr4LogikaParser.ELIM2, 0); }
		public AndElim2Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class OrIntro2Context extends JustificationContext {
		public Token tb;
		public Token orStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode INTRO2() { return getToken(Antlr4LogikaParser.INTRO2, 0); }
		public OrIntro2Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class NegIntroContext extends JustificationContext {
		public Token tb;
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode INTRO() { return getToken(Antlr4LogikaParser.INTRO, 0); }
		public NegIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class NegElimContext extends JustificationContext {
		public Token tb;
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
	public static class OrIntro1Context extends JustificationContext {
		public Token tb;
		public Token orStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode INTRO1() { return getToken(Antlr4LogikaParser.INTRO1, 0); }
		public OrIntro1Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndElim1Context extends JustificationContext {
		public Token tb;
		public Token andStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ELIM1() { return getToken(Antlr4LogikaParser.ELIM1, 0); }
		public AndElim1Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AlgebraContext extends JustificationContext {
		public Token tb;
		public Token NUM;
		public List<Token> steps = new ArrayList<Token>();
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public AlgebraContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ExistsContext extends JustificationContext {
		public Token tb;
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
		public Token tb;
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
		public Token tb;
		public Token falseStep;
		public TerminalNode ELIM() { return getToken(Antlr4LogikaParser.ELIM, 0); }
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public FalseElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ImpliesIntroContext extends JustificationContext {
		public Token tb;
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
			setState(391);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				((PremiseContext)_localctx).t = match(T__55);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				switch (_input.LA(1)) {
				case T__56:
					{
					setState(261);
					((AndIntroContext)_localctx).tb = match(T__56);
					}
					break;
				case T__36:
				case T__37:
					{
					setState(262);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__36 || _la==T__37) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(263);
					match(INTRO);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(266);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(267);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElim1Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(271);
				switch (_input.LA(1)) {
				case T__57:
					{
					setState(268);
					((AndElim1Context)_localctx).tb = match(T__57);
					}
					break;
				case T__36:
				case T__37:
					{
					setState(269);
					((AndElim1Context)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__36 || _la==T__37) ) {
						((AndElim1Context)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(270);
					match(ELIM1);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(273);
				((AndElim1Context)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new AndElim2Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(277);
				switch (_input.LA(1)) {
				case T__58:
					{
					setState(274);
					((AndElim2Context)_localctx).tb = match(T__58);
					}
					break;
				case T__36:
				case T__37:
					{
					setState(275);
					((AndElim2Context)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__36 || _la==T__37) ) {
						((AndElim2Context)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(276);
					match(ELIM2);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(279);
				((AndElim2Context)_localctx).andStep = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrIntro1Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(283);
				switch (_input.LA(1)) {
				case T__59:
					{
					setState(280);
					((OrIntro1Context)_localctx).tb = match(T__59);
					}
					break;
				case T__39:
				case T__40:
					{
					setState(281);
					((OrIntro1Context)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__39 || _la==T__40) ) {
						((OrIntro1Context)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(282);
					match(INTRO1);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(285);
				((OrIntro1Context)_localctx).orStep = match(NUM);
				}
				break;
			case 6:
				_localctx = new OrIntro2Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(289);
				switch (_input.LA(1)) {
				case T__60:
					{
					setState(286);
					((OrIntro2Context)_localctx).tb = match(T__60);
					}
					break;
				case T__39:
				case T__40:
					{
					setState(287);
					((OrIntro2Context)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__39 || _la==T__40) ) {
						((OrIntro2Context)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(288);
					match(INTRO2);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(291);
				((OrIntro2Context)_localctx).orStep = match(NUM);
				}
				break;
			case 7:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(295);
				switch (_input.LA(1)) {
				case T__61:
					{
					setState(292);
					((OrElimContext)_localctx).tb = match(T__61);
					}
					break;
				case T__39:
				case T__40:
					{
					setState(293);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__39 || _la==T__40) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(294);
					match(ELIM);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(297);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(298);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(299);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 8:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(303);
				switch (_input.LA(1)) {
				case T__62:
					{
					setState(300);
					((ImpliesIntroContext)_localctx).tb = match(T__62);
					}
					break;
				case T__42:
				case T__43:
				case T__44:
				case T__45:
					{
					setState(301);
					((ImpliesIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
						((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(302);
					match(INTRO);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(305);
				((ImpliesIntroContext)_localctx).impliesStep = match(NUM);
				}
				break;
			case 9:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(309);
				switch (_input.LA(1)) {
				case T__63:
					{
					setState(306);
					((ImpliesElimContext)_localctx).tb = match(T__63);
					}
					break;
				case T__42:
				case T__43:
				case T__44:
				case T__45:
					{
					setState(307);
					((ImpliesElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
						((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(308);
					match(ELIM);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(311);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(312);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(317);
				switch (_input.LA(1)) {
				case T__64:
					{
					setState(313);
					((NegIntroContext)_localctx).tb = match(T__64);
					}
					break;
				case T__65:
					{
					setState(314);
					((NegIntroContext)_localctx).tb = match(T__65);
					}
					break;
				case T__32:
				case T__33:
				case T__34:
					{
					setState(315);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(316);
					match(INTRO);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(319);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 11:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(324);
				switch (_input.LA(1)) {
				case T__66:
					{
					setState(320);
					((NegElimContext)_localctx).tb = match(T__66);
					}
					break;
				case T__67:
					{
					setState(321);
					((NegElimContext)_localctx).tb = match(T__67);
					}
					break;
				case T__32:
				case T__33:
				case T__34:
					{
					setState(322);
					((NegElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
						((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(323);
					match(ELIM);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(326);
				((NegElimContext)_localctx).step = match(NUM);
				setState(327);
				((NegElimContext)_localctx).notStep = match(NUM);
				}
				break;
			case 12:
				_localctx = new FalseElimContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(328);
				((FalseElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__9 - 10)) | (1L << (T__10 - 10)) | (1L << (T__68 - 10)))) != 0)) ) {
					((FalseElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(329);
				match(ELIM);
				setState(330);
				((FalseElimContext)_localctx).falseStep = match(NUM);
				}
				break;
			case 13:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(331);
				((PbcContext)_localctx).tb = match(T__69);
				setState(332);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 14:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(338);
				switch (_input.LA(1)) {
				case T__70:
					{
					setState(333);
					((ForallIntroContext)_localctx).tb = match(T__70);
					}
					break;
				case T__71:
					{
					setState(334);
					((ForallIntroContext)_localctx).tb = match(T__71);
					}
					break;
				case T__72:
					{
					setState(335);
					((ForallIntroContext)_localctx).tb = match(T__72);
					}
					break;
				case T__49:
					{
					setState(336);
					((ForallIntroContext)_localctx).tb = match(T__49);
					setState(337);
					match(INTRO);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(340);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 15:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(346);
				switch (_input.LA(1)) {
				case T__73:
					{
					setState(341);
					((ForallElimContext)_localctx).tb = match(T__73);
					}
					break;
				case T__74:
					{
					setState(342);
					((ForallElimContext)_localctx).tb = match(T__74);
					}
					break;
				case T__75:
					{
					setState(343);
					((ForallElimContext)_localctx).tb = match(T__75);
					}
					break;
				case T__49:
					{
					setState(344);
					((ForallElimContext)_localctx).tb = match(T__49);
					setState(345);
					match(ELIM);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(348);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
				setState(350); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(349);
					formula(0);
					}
					}
					setState(352); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==INT || _la==ID );
				}
				break;
			case 16:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(359);
				switch (_input.LA(1)) {
				case T__76:
					{
					setState(354);
					((ExistsIntroContext)_localctx).tb = match(T__76);
					}
					break;
				case T__77:
					{
					setState(355);
					((ExistsIntroContext)_localctx).tb = match(T__77);
					}
					break;
				case T__78:
					{
					setState(356);
					((ExistsIntroContext)_localctx).tb = match(T__78);
					}
					break;
				case T__53:
					{
					setState(357);
					((ExistsIntroContext)_localctx).tb = match(T__53);
					setState(358);
					match(INTRO);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(361);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(363); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(362);
					formula(0);
					}
					}
					setState(365); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==INT || _la==ID );
				}
				break;
			case 17:
				_localctx = new ExistsContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(372);
				switch (_input.LA(1)) {
				case T__79:
					{
					setState(367);
					((ExistsContext)_localctx).tb = match(T__79);
					}
					break;
				case T__80:
					{
					setState(368);
					((ExistsContext)_localctx).tb = match(T__80);
					}
					break;
				case T__81:
					{
					setState(369);
					((ExistsContext)_localctx).tb = match(T__81);
					}
					break;
				case T__53:
					{
					setState(370);
					((ExistsContext)_localctx).tb = match(T__53);
					setState(371);
					match(ELIM);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(374);
				((ExistsContext)_localctx).stepOrFact = numOrId();
				setState(375);
				((ExistsContext)_localctx).subproof = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(377);
				((AlgebraContext)_localctx).tb = match(T__82);
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(378);
					((AlgebraContext)_localctx).NUM = match(NUM);
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).NUM);
					}
					}
					setState(383);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(384);
				((AutoContext)_localctx).tb = match(T__83);
				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(385);
					((AutoContext)_localctx).numOrId = numOrId();
					((AutoContext)_localctx).stepOrFacts.add(((AutoContext)_localctx).numOrId);
					}
					}
					setState(390);
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
		enterRule(_localctx, 18, RULE_numOrId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
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
		public Token te;
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
		enterRule(_localctx, 20, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			_la = _input.LA(1);
			if (_la==T__84) {
				{
				setState(395);
				((ProgramContext)_localctx).tb = match(T__84);
				setState(396);
				match(ORG);
				setState(397);
				match(T__5);
				setState(398);
				match(SIREUM);
				setState(399);
				match(T__5);
				setState(400);
				match(LOGIKA);
				setState(401);
				match(T__5);
				setState(402);
				((ProgramContext)_localctx).te = match(T__85);
				setState(403);
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
		enterRule(_localctx, 22, RULE_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			_la = _input.LA(1);
			if (((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__89 - 87)) | (1L << (T__90 - 87)) | (1L << (T__92 - 87)) | (1L << (T__95 - 87)) | (1L << (T__96 - 87)) | (1L << (T__109 - 87)) | (1L << (ID - 87)) | (1L << (LOGIKA - 87)) | (1L << (L - 87)))) != 0)) {
				{
				setState(406);
				stmt();
				}
			}

			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(410); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(409);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(412); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(415);
				_la = _input.LA(1);
				if (((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__86 - 87)) | (1L << (T__87 - 87)) | (1L << (T__89 - 87)) | (1L << (T__90 - 87)) | (1L << (T__92 - 87)) | (1L << (T__95 - 87)) | (1L << (T__96 - 87)) | (1L << (T__109 - 87)) | (1L << (ID - 87)) | (1L << (LOGIKA - 87)) | (1L << (L - 87)))) != 0)) {
					{
					setState(414);
					stmt();
					}
				}

				}
				}
				setState(421);
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
		public Token id;
		public Token m;
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
		public MethodInvocationStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class SeqAssignStmtContext extends StmtContext {
		public Token tb;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public SeqAssignStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssignVarStmtContext extends StmtContext {
		public Token tb;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public AssignVarStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class PrintStmtContext extends StmtContext {
		public Token op;
		public Token te;
		public TerminalNode S() { return getToken(Antlr4LogikaParser.S, 0); }
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public PrintStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class SeqCloneStmtContext extends StmtContext {
		public Token tb;
		public Token te;
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public TerminalNode CLONE() { return getToken(Antlr4LogikaParser.CLONE, 0); }
		public SeqCloneStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class MethodDeclStmtContext extends StmtContext {
		public MethodDeclContext methodDecl() {
			return getRuleContext(MethodDeclContext.class,0);
		}
		public MethodDeclStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class ReadIntStmtContext extends StmtContext {
		public Token tb;
		public Token te;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public ReadIntStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class IfStmtContext extends StmtContext {
		public Token tb;
		public Token ttb;
		public StmtsContext ts;
		public Token tte;
		public Token ftb;
		public StmtsContext fs;
		public Token fte;
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
	public static class WhileStmtContext extends StmtContext {
		public Token tb;
		public Token ltb;
		public Token lte;
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
		public Token te;
		public LgkContext lgk() {
			return getRuleContext(LgkContext.class,0);
		}
		public ProofContext proof() {
			return getRuleContext(ProofContext.class,0);
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
	public static class SeqPendStmtContext extends StmtContext {
		public Token id;
		public Token op;
		public Token seq;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public SeqPendStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssertStmtContext extends StmtContext {
		public Token tb;
		public Token te;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssertStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmt);
		int _la;
		try {
			setState(569);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(422);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__86 || _la==T__87) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(423);
				match(ID);
				setState(424);
				match(T__88);
				setState(425);
				type();
				setState(426);
				match(T__27);
				setState(427);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(429);
				((AssignVarStmtContext)_localctx).tb = match(ID);
				setState(430);
				match(T__27);
				setState(431);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(432);
				((AssertStmtContext)_localctx).tb = match(T__89);
				setState(433);
				match(T__13);
				setState(434);
				exp(0);
				setState(435);
				((AssertStmtContext)_localctx).te = match(T__14);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(437);
				((IfStmtContext)_localctx).tb = match(T__90);
				setState(438);
				match(T__13);
				setState(439);
				exp(0);
				setState(440);
				match(T__14);
				setState(444);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(441);
					match(NL);
					}
					}
					setState(446);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(447);
				((IfStmtContext)_localctx).ttb = match(T__3);
				setState(448);
				((IfStmtContext)_localctx).ts = stmts();
				setState(449);
				((IfStmtContext)_localctx).tte = match(T__4);
				setState(450);
				match(T__91);
				setState(451);
				((IfStmtContext)_localctx).ftb = match(T__3);
				setState(452);
				((IfStmtContext)_localctx).fs = stmts();
				setState(453);
				((IfStmtContext)_localctx).fte = match(T__4);
				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(455);
				((WhileStmtContext)_localctx).tb = match(T__92);
				setState(456);
				match(T__13);
				setState(457);
				exp(0);
				setState(458);
				match(T__14);
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(459);
					match(NL);
					}
					}
					setState(464);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(465);
				((WhileStmtContext)_localctx).ltb = match(T__3);
				setState(489);
				switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
				case 1:
					{
					setState(469);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(466);
						match(NL);
						}
						}
						setState(471);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(472);
					lgk();
					setState(473);
					match(T__93);
					setState(477);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(474);
						match(NL);
						}
						}
						setState(479);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(480);
					loopInvariant();
					setState(484);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(481);
						match(NL);
						}
						}
						setState(486);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(487);
					match(T__93);
					}
					break;
				}
				setState(491);
				stmts();
				setState(492);
				((WhileStmtContext)_localctx).lte = match(T__4);
				}
				break;
			case 6:
				_localctx = new ReadIntStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(494);
				((ReadIntStmtContext)_localctx).tb = match(ID);
				setState(495);
				match(T__27);
				setState(496);
				match(T__94);
				setState(497);
				match(T__13);
				setState(499);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(498);
					match(STRING);
					}
				}

				setState(501);
				((ReadIntStmtContext)_localctx).te = match(T__14);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(502);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__95 || _la==T__96) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(503);
				match(T__13);
				setState(504);
				match(S);
				setState(505);
				match(STRING);
				setState(506);
				((PrintStmtContext)_localctx).te = match(T__14);
				}
				break;
			case 8:
				_localctx = new MethodInvocationStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(509);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(507);
					((MethodInvocationStmtContext)_localctx).id = match(ID);
					setState(508);
					match(T__27);
					}
					break;
				}
				setState(511);
				((MethodInvocationStmtContext)_localctx).m = match(ID);
				setState(512);
				match(T__13);
				setState(521);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__20) | (1L << T__32))) != 0) || ((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (T__99 - 100)) | (1L << (T__100 - 100)) | (1L << (T__101 - 100)) | (1L << (T__102 - 100)) | (1L << (INT - 100)) | (1L << (ID - 100)))) != 0)) {
					{
					setState(513);
					exp(0);
					setState(518);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(514);
						match(T__0);
						setState(515);
						exp(0);
						}
						}
						setState(520);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(523);
				((MethodInvocationStmtContext)_localctx).te = match(T__14);
				}
				break;
			case 9:
				_localctx = new SeqCloneStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(524);
				((SeqCloneStmtContext)_localctx).tb = match(ID);
				setState(525);
				match(T__27);
				setState(526);
				match(ID);
				setState(527);
				match(T__5);
				setState(528);
				((SeqCloneStmtContext)_localctx).te = match(CLONE);
				}
				break;
			case 10:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(529);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(530);
				match(T__13);
				setState(531);
				exp(0);
				setState(532);
				match(T__14);
				setState(533);
				match(T__27);
				setState(534);
				exp(0);
				}
				break;
			case 11:
				_localctx = new SeqPendStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(536);
				((SeqPendStmtContext)_localctx).id = match(ID);
				setState(537);
				match(T__27);
				setState(538);
				exp(0);
				setState(539);
				((SeqPendStmtContext)_localctx).op = match(T__97);
				setState(540);
				((SeqPendStmtContext)_localctx).seq = match(ID);
				}
				break;
			case 12:
				_localctx = new SeqPendStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(542);
				((SeqPendStmtContext)_localctx).id = match(ID);
				setState(543);
				match(T__27);
				setState(544);
				((SeqPendStmtContext)_localctx).seq = match(ID);
				setState(545);
				((SeqPendStmtContext)_localctx).op = match(T__98);
				setState(546);
				exp(0);
				}
				break;
			case 13:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(547);
				methodDecl();
				}
				break;
			case 14:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(548);
				lgk();
				setState(549);
				match(T__93);
				setState(553);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(550);
					match(NL);
					}
					}
					setState(555);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(559);
				switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
				case 1:
					{
					setState(556);
					proof();
					}
					break;
				case 2:
					{
					setState(557);
					invariants();
					}
					break;
				case 3:
					{
					setState(558);
					facts();
					}
					break;
				}
				setState(564);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(561);
					match(NL);
					}
					}
					setState(566);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(567);
				((LogikaStmtContext)_localctx).te = match(T__93);
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

	public static class LgkContext extends ParserRuleContext {
		public Token t;
		public TerminalNode L() { return getToken(Antlr4LogikaParser.L, 0); }
		public TerminalNode LOGIKA() { return getToken(Antlr4LogikaParser.LOGIKA, 0); }
		public LgkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lgk; }
	}

	public final LgkContext lgk() throws RecognitionException {
		LgkContext _localctx = new LgkContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_lgk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			((LgkContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==LOGIKA || _la==L) ) {
				((LgkContext)_localctx).t = (Token)_errHandler.recoverInline(this);
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
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SIZE() { return getToken(Antlr4LogikaParser.SIZE, 0); }
		public IdExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExpContext extends ExpContext {
		public Token tb;
		public Token te;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ParenExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class FalseExpContext extends ExpContext {
		public Token t;
		public FalseExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class BigIntExpContext extends ExpContext {
		public Token tb;
		public Token te;
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
		public Token t;
		public TerminalNode INT() { return getToken(Antlr4LogikaParser.INT, 0); }
		public IntExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class SeqExpContext extends ExpContext {
		public Token tb;
		public Token te;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SeqExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class TrueExpContext extends ExpContext {
		public Token t;
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			switch (_input.LA(1)) {
			case T__20:
			case T__32:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(574);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__32) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(575);
				exp(7);
				}
				break;
			case T__11:
			case T__12:
				{
				_localctx = new TrueExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(576);
				((TrueExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__12) ) {
					((TrueExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case T__7:
			case T__8:
				{
				_localctx = new FalseExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(577);
				((FalseExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
					((FalseExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case INT:
				{
				_localctx = new IntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(578);
				((IntExpContext)_localctx).t = match(INT);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(579);
				((IdExpContext)_localctx).tb = match(ID);
				setState(586);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(580);
					match(T__13);
					setState(581);
					exp(0);
					setState(582);
					((IdExpContext)_localctx).te = match(T__14);
					}
					break;
				case 2:
					{
					setState(584);
					match(T__5);
					setState(585);
					((IdExpContext)_localctx).te = match(SIZE);
					}
					break;
				}
				}
				break;
			case T__99:
			case T__100:
				{
				_localctx = new BigIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(588);
				((BigIntExpContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__99 || _la==T__100) ) {
					((BigIntExpContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(589);
				match(T__13);
				setState(590);
				match(STRING);
				setState(591);
				((BigIntExpContext)_localctx).te = match(T__14);
				}
				break;
			case T__101:
			case T__102:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(592);
				((SeqExpContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__101 || _la==T__102) ) {
					((SeqExpContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(593);
				match(T__13);
				setState(594);
				exp(0);
				setState(597);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(595);
					match(T__0);
					setState(596);
					exp(0);
					}
				}

				setState(599);
				((SeqExpContext)_localctx).te = match(T__14);
				}
				break;
			case T__13:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(601);
				((ParenExpContext)_localctx).tb = match(T__13);
				setState(602);
				exp(0);
				setState(603);
				((ParenExpContext)_localctx).te = match(T__14);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(645);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(643);
					switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(607);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(608);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(610);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(609);
							match(NL);
							}
						}

						setState(612);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(613);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(614);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(616);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(615);
							match(NL);
							}
						}

						setState(618);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(619);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(620);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__25))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(622);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(621);
							match(NL);
							}
						}

						setState(624);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(625);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(626);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(628);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(627);
							match(NL);
							}
						}

						setState(630);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(631);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(632);
						match(T__36);
						}
						setState(634);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(633);
							match(NL);
							}
						}

						setState(636);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(637);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(638);
						match(T__39);
						}
						setState(640);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(639);
							match(NL);
							}
						}

						setState(642);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(647);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
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
		public Token tb;
		public Token te;
		public Token t;
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public IntSeqTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanContext extends TypeContext {
		public Token t;
		public BooleanContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class IntTypeContext extends TypeContext {
		public Token t;
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_type);
		int _la;
		try {
			setState(667);
			switch (_input.LA(1)) {
			case T__103:
			case T__104:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(648);
				((BooleanContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__103 || _la==T__104) ) {
					((BooleanContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case T__99:
			case T__100:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(649);
				((IntTypeContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__99 || _la==T__100) ) {
					((IntTypeContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case T__101:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(650);
				((IntSeqTypeContext)_localctx).tb = match(T__101);
				setState(651);
				match(T__105);
				setState(655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(652);
					match(NL);
					}
					}
					setState(657);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(658);
				_la = _input.LA(1);
				if ( !(_la==T__99 || _la==T__100) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(662);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(659);
					match(NL);
					}
					}
					setState(664);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(665);
				((IntSeqTypeContext)_localctx).te = match(T__106);
				}
				break;
			case T__102:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(666);
				((IntSeqTypeContext)_localctx).t = match(T__102);
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
		enterRule(_localctx, 32, RULE_loopInvariant);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(669);
			((LoopInvariantContext)_localctx).tb = match(T__3);
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
			((LoopInvariantContext)_localctx).itb = match(T__107);
			{
			setState(678);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==INT || _la==ID) {
				{
				setState(677);
				formula(0);
				}
			}

			setState(690);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(681); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(680);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(683); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(686);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==INT || _la==ID) {
					{
					setState(685);
					formula(0);
					}
				}

				}
				}
				setState(692);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(693);
			modifies();
			setState(694);
			((LoopInvariantContext)_localctx).te = match(T__4);
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
		enterRule(_localctx, 34, RULE_modifies);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			((ModifiesContext)_localctx).tb = match(T__108);
			setState(698); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(697);
				match(ID);
				}
				}
				setState(700); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(705);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(702);
					match(NL);
					}
					} 
				}
				setState(707);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
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
		public Token tb;
		public Token te;
		public Token mtb;
		public Token rtb;
		public Token mte;
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
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
			((MethodDeclContext)_localctx).tb = match(T__109);
			setState(709);
			match(ID);
			setState(711);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(710);
				match(NL);
				}
			}

			setState(713);
			match(T__13);
			setState(722);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(714);
				param();
				setState(719);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(715);
					match(T__0);
					setState(716);
					param();
					}
					}
					setState(721);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(724);
			match(T__14);
			setState(725);
			match(T__88);
			setState(728);
			switch (_input.LA(1)) {
			case T__99:
			case T__100:
			case T__101:
			case T__102:
			case T__103:
			case T__104:
				{
				setState(726);
				type();
				}
				break;
			case T__110:
				{
				setState(727);
				match(T__110);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(730);
			((MethodDeclContext)_localctx).te = match(T__27);
			setState(731);
			((MethodDeclContext)_localctx).mtb = match(T__3);
			setState(755);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				{
				setState(735);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(732);
					match(NL);
					}
					}
					setState(737);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(738);
				lgk();
				setState(739);
				match(T__93);
				setState(743);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(740);
					match(NL);
					}
					}
					setState(745);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(746);
				methodContract();
				setState(750);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(747);
					match(NL);
					}
					}
					setState(752);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(753);
				match(T__93);
				}
				break;
			}
			setState(757);
			stmts();
			setState(758);
			((MethodDeclContext)_localctx).rtb = match(T__111);
			setState(760);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__20) | (1L << T__32))) != 0) || ((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (T__99 - 100)) | (1L << (T__100 - 100)) | (1L << (T__101 - 100)) | (1L << (T__102 - 100)) | (1L << (INT - 100)) | (1L << (ID - 100)))) != 0)) {
				{
				setState(759);
				exp(0);
				}
			}

			setState(765);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(762);
				match(NL);
				}
				}
				setState(767);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(768);
			((MethodDeclContext)_localctx).mte = match(T__4);
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
		public Token tb;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(770);
			((ParamContext)_localctx).tb = match(ID);
			setState(771);
			match(T__88);
			setState(772);
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
		public Token tb;
		public Token rtb;
		public Token rte;
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
		enterRule(_localctx, 40, RULE_methodContract);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(774);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(778);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(775);
					match(NL);
					}
					} 
				}
				setState(780);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
			}
			setState(802);
			_la = _input.LA(1);
			if (_la==T__112) {
				{
				setState(781);
				((MethodContractContext)_localctx).rtb = match(T__112);
				setState(785);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(782);
					match(NL);
					}
					}
					setState(787);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(788);
				formula(0);
				setState(799);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(790); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(789);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(792); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(795);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==INT || _la==ID) {
							{
							setState(794);
							formula(0);
							}
						}

						}
						} 
					}
					setState(801);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				}
				}
			}

			setState(807);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(804);
					match(NL);
					}
					} 
				}
				setState(809);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			}
			setState(811);
			_la = _input.LA(1);
			if (_la==T__108) {
				{
				setState(810);
				modifies();
				}
			}

			setState(834);
			_la = _input.LA(1);
			if (_la==T__113) {
				{
				setState(813);
				((MethodContractContext)_localctx).rte = match(T__113);
				setState(817);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(814);
					match(NL);
					}
					}
					setState(819);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(820);
				formula(0);
				setState(831);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(822); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(821);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(824); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(827);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==INT || _la==ID) {
							{
							setState(826);
							formula(0);
							}
						}

						}
						} 
					}
					setState(833);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
				}
				}
			}

			setState(839);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(836);
				match(NL);
				}
				}
				setState(841);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(842);
			((MethodContractContext)_localctx).te = match(T__4);
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
		public Token itb;
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
		enterRule(_localctx, 42, RULE_invariants);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(844);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(848);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(845);
				match(NL);
				}
				}
				setState(850);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(851);
			((InvariantsContext)_localctx).itb = match(T__107);
			setState(855);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(852);
					match(NL);
					}
					} 
				}
				setState(857);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			}
			setState(859);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==INT || _la==ID) {
				{
				setState(858);
				formula(0);
				}
			}

			setState(871);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(862); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(861);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(864); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,120,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(867);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0) || _la==INT || _la==ID) {
					{
					setState(866);
					formula(0);
					}
				}

				}
				}
				setState(873);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(874);
			((InvariantsContext)_localctx).te = match(T__4);
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
		public Token tb;
		public Token ftb;
		public Token te;
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
		enterRule(_localctx, 44, RULE_facts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(876);
			((FactsContext)_localctx).tb = match(T__3);
			setState(880);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(877);
				match(NL);
				}
				}
				setState(882);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(883);
			((FactsContext)_localctx).ftb = match(T__114);
			setState(887);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(884);
					match(NL);
					}
					} 
				}
				setState(889);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			}
			setState(891);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(890);
				fact();
				}
			}

			setState(903);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
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
				if (_la==ID) {
					{
					setState(898);
					fact();
					}
				}

				}
				}
				setState(905);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(906);
			((FactsContext)_localctx).te = match(T__4);
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
		public Token tb;
		public QformulaContext qformula() {
			return getRuleContext(QformulaContext.class,0);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public FactContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fact; }
	}

	public final FactContext fact() throws RecognitionException {
		FactContext _localctx = new FactContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_fact);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(908);
			((FactContext)_localctx).tb = match(ID);
			setState(909);
			match(T__5);
			setState(910);
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
		case 14:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u008d\u0393\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\5\2\65\n\2\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\5\5M\n\5\3\5\3\5\3\5\3"+
		"\5\7\5S\n\5\f\5\16\5V\13\5\3\5\7\5Y\n\5\f\5\16\5\\\13\5\3\5\3\5\6\5`\n"+
		"\5\r\5\16\5a\5\5d\n\5\3\6\3\6\5\6h\n\6\3\6\6\6k\n\6\r\6\16\6l\3\6\5\6"+
		"p\n\6\7\6r\n\6\f\6\16\6u\13\6\3\6\3\6\7\6y\n\6\f\6\16\6|\13\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0086\n\7\f\7\16\7\u0089\13\7\3\7\3\7\7\7"+
		"\u008d\n\7\f\7\16\7\u0090\13\7\3\7\3\7\3\7\3\7\5\7\u0096\n\7\3\7\3\7\3"+
		"\7\5\7\u009b\n\7\3\7\6\7\u009e\n\7\r\7\16\7\u009f\3\7\7\7\u00a3\n\7\f"+
		"\7\16\7\u00a6\13\7\3\7\5\7\u00a9\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\b\u00b5\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00c1"+
		"\n\b\f\b\16\b\u00c4\13\b\3\b\3\b\3\b\3\b\5\b\u00ca\n\b\3\b\3\b\3\b\5\b"+
		"\u00cf\n\b\3\b\3\b\3\b\3\b\5\b\u00d5\n\b\3\b\3\b\3\b\3\b\5\b\u00db\n\b"+
		"\3\b\3\b\3\b\3\b\5\b\u00e1\n\b\3\b\3\b\3\b\3\b\5\b\u00e7\n\b\3\b\3\b\3"+
		"\b\3\b\5\b\u00ed\n\b\3\b\3\b\3\b\3\b\5\b\u00f3\n\b\3\b\7\b\u00f6\n\b\f"+
		"\b\16\b\u00f9\13\b\3\t\3\t\6\t\u00fd\n\t\r\t\16\t\u00fe\3\t\3\t\5\t\u0103"+
		"\n\t\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u010b\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u0112"+
		"\n\n\3\n\3\n\3\n\3\n\5\n\u0118\n\n\3\n\3\n\3\n\3\n\5\n\u011e\n\n\3\n\3"+
		"\n\3\n\3\n\5\n\u0124\n\n\3\n\3\n\3\n\3\n\5\n\u012a\n\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u0132\n\n\3\n\3\n\3\n\3\n\5\n\u0138\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\n\u0140\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u0147\n\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0155\n\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u015d\n\n\3\n\3\n\6\n\u0161\n\n\r\n\16\n\u0162\3\n\3\n\3\n\3\n\3"+
		"\n\5\n\u016a\n\n\3\n\3\n\6\n\u016e\n\n\r\n\16\n\u016f\3\n\3\n\3\n\3\n"+
		"\3\n\5\n\u0177\n\n\3\n\3\n\3\n\3\n\3\n\7\n\u017e\n\n\f\n\16\n\u0181\13"+
		"\n\3\n\3\n\7\n\u0185\n\n\f\n\16\n\u0188\13\n\5\n\u018a\n\n\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0197\n\f\3\r\5\r\u019a\n\r\3\r"+
		"\6\r\u019d\n\r\r\r\16\r\u019e\3\r\5\r\u01a2\n\r\7\r\u01a4\n\r\f\r\16\r"+
		"\u01a7\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u01bd\n\16\f\16\16\16\u01c0"+
		"\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u01cf\n\16\f\16\16\16\u01d2\13\16\3\16\3\16\7\16\u01d6\n\16\f\16"+
		"\16\16\u01d9\13\16\3\16\3\16\3\16\7\16\u01de\n\16\f\16\16\16\u01e1\13"+
		"\16\3\16\3\16\7\16\u01e5\n\16\f\16\16\16\u01e8\13\16\3\16\3\16\5\16\u01ec"+
		"\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u01f6\n\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0200\n\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u0207\n\16\f\16\16\16\u020a\13\16\5\16\u020c\n\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u022a\n\16"+
		"\f\16\16\16\u022d\13\16\3\16\3\16\3\16\5\16\u0232\n\16\3\16\7\16\u0235"+
		"\n\16\f\16\16\16\u0238\13\16\3\16\3\16\5\16\u023c\n\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u024d"+
		"\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0258\n\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u0260\n\20\3\20\3\20\3\20\5\20\u0265\n"+
		"\20\3\20\3\20\3\20\3\20\5\20\u026b\n\20\3\20\3\20\3\20\3\20\5\20\u0271"+
		"\n\20\3\20\3\20\3\20\3\20\5\20\u0277\n\20\3\20\3\20\3\20\3\20\5\20\u027d"+
		"\n\20\3\20\3\20\3\20\3\20\5\20\u0283\n\20\3\20\7\20\u0286\n\20\f\20\16"+
		"\20\u0289\13\20\3\21\3\21\3\21\3\21\3\21\7\21\u0290\n\21\f\21\16\21\u0293"+
		"\13\21\3\21\3\21\7\21\u0297\n\21\f\21\16\21\u029a\13\21\3\21\3\21\5\21"+
		"\u029e\n\21\3\22\3\22\7\22\u02a2\n\22\f\22\16\22\u02a5\13\22\3\22\3\22"+
		"\5\22\u02a9\n\22\3\22\6\22\u02ac\n\22\r\22\16\22\u02ad\3\22\5\22\u02b1"+
		"\n\22\7\22\u02b3\n\22\f\22\16\22\u02b6\13\22\3\22\3\22\3\22\3\23\3\23"+
		"\6\23\u02bd\n\23\r\23\16\23\u02be\3\23\7\23\u02c2\n\23\f\23\16\23\u02c5"+
		"\13\23\3\24\3\24\3\24\5\24\u02ca\n\24\3\24\3\24\3\24\3\24\7\24\u02d0\n"+
		"\24\f\24\16\24\u02d3\13\24\5\24\u02d5\n\24\3\24\3\24\3\24\3\24\5\24\u02db"+
		"\n\24\3\24\3\24\3\24\7\24\u02e0\n\24\f\24\16\24\u02e3\13\24\3\24\3\24"+
		"\3\24\7\24\u02e8\n\24\f\24\16\24\u02eb\13\24\3\24\3\24\7\24\u02ef\n\24"+
		"\f\24\16\24\u02f2\13\24\3\24\3\24\5\24\u02f6\n\24\3\24\3\24\3\24\5\24"+
		"\u02fb\n\24\3\24\7\24\u02fe\n\24\f\24\16\24\u0301\13\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\7\26\u030b\n\26\f\26\16\26\u030e\13\26\3\26"+
		"\3\26\7\26\u0312\n\26\f\26\16\26\u0315\13\26\3\26\3\26\6\26\u0319\n\26"+
		"\r\26\16\26\u031a\3\26\5\26\u031e\n\26\7\26\u0320\n\26\f\26\16\26\u0323"+
		"\13\26\5\26\u0325\n\26\3\26\7\26\u0328\n\26\f\26\16\26\u032b\13\26\3\26"+
		"\5\26\u032e\n\26\3\26\3\26\7\26\u0332\n\26\f\26\16\26\u0335\13\26\3\26"+
		"\3\26\6\26\u0339\n\26\r\26\16\26\u033a\3\26\5\26\u033e\n\26\7\26\u0340"+
		"\n\26\f\26\16\26\u0343\13\26\5\26\u0345\n\26\3\26\7\26\u0348\n\26\f\26"+
		"\16\26\u034b\13\26\3\26\3\26\3\27\3\27\7\27\u0351\n\27\f\27\16\27\u0354"+
		"\13\27\3\27\3\27\7\27\u0358\n\27\f\27\16\27\u035b\13\27\3\27\5\27\u035e"+
		"\n\27\3\27\6\27\u0361\n\27\r\27\16\27\u0362\3\27\5\27\u0366\n\27\7\27"+
		"\u0368\n\27\f\27\16\27\u036b\13\27\3\27\3\27\3\30\3\30\7\30\u0371\n\30"+
		"\f\30\16\30\u0374\13\30\3\30\3\30\7\30\u0378\n\30\f\30\16\30\u037b\13"+
		"\30\3\30\5\30\u037e\n\30\3\30\6\30\u0381\n\30\r\30\16\30\u0382\3\30\5"+
		"\30\u0386\n\30\7\30\u0388\n\30\f\30\16\30\u038b\13\30\3\30\3\30\3\31\3"+
		"\31\3\31\3\31\3\31\2\4\16\36\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\2\36\3\2\4\5\3\2\"%\3\2\n\r\3\2\16\17\3\2\23\25\3\2\26\27"+
		"\3\2\30\35\3\2\36!\3\2&(\3\2)+\3\2,\60\3\2\618\3\2\'(\3\2*+\3\2-\60\3"+
		"\2#%\4\2\f\rGG\3\2xy\3\2YZ\3\2bc\3\2\u0089\u008a\4\2\27\27##\3\2\n\13"+
		"\3\2fg\3\2hi\4\2\30\31\33\34\3\2\37 \3\2jk\u043d\2\62\3\2\2\2\4>\3\2\2"+
		"\2\6A\3\2\2\2\bc\3\2\2\2\ne\3\2\2\2\f\u00a8\3\2\2\2\16\u00c9\3\2\2\2\20"+
		"\u00fa\3\2\2\2\22\u0189\3\2\2\2\24\u018b\3\2\2\2\26\u0196\3\2\2\2\30\u0199"+
		"\3\2\2\2\32\u023b\3\2\2\2\34\u023d\3\2\2\2\36\u025f\3\2\2\2 \u029d\3\2"+
		"\2\2\"\u029f\3\2\2\2$\u02ba\3\2\2\2&\u02c6\3\2\2\2(\u0304\3\2\2\2*\u0308"+
		"\3\2\2\2,\u034e\3\2\2\2.\u036e\3\2\2\2\60\u038e\3\2\2\2\62\64\5\b\5\2"+
		"\63\65\5\n\6\2\64\63\3\2\2\2\64\65\3\2\2\2\659\3\2\2\2\668\7|\2\2\67\66"+
		"\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7\2\2\3"+
		"=\3\3\2\2\2>?\5\n\6\2?@\7\2\2\3@\5\3\2\2\2AB\5\26\f\2BC\7\2\2\3C\7\3\2"+
		"\2\2DI\5\16\b\2EF\7\3\2\2FH\5\16\b\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3"+
		"\2\2\2JM\3\2\2\2KI\3\2\2\2LD\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\t\2\2\2OT\5"+
		"\16\b\2PQ\7\3\2\2QS\5\16\b\2RP\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U"+
		"d\3\2\2\2VT\3\2\2\2WY\5\16\b\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2"+
		"\2[]\3\2\2\2\\Z\3\2\2\2]_\7v\2\2^`\5\16\b\2_^\3\2\2\2`a\3\2\2\2a_\3\2"+
		"\2\2ab\3\2\2\2bd\3\2\2\2cL\3\2\2\2cZ\3\2\2\2d\t\3\2\2\2eg\7\6\2\2fh\5"+
		"\f\7\2gf\3\2\2\2gh\3\2\2\2hs\3\2\2\2ik\7|\2\2ji\3\2\2\2kl\3\2\2\2lj\3"+
		"\2\2\2lm\3\2\2\2mo\3\2\2\2np\5\f\7\2on\3\2\2\2op\3\2\2\2pr\3\2\2\2qj\3"+
		"\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vz\7\7\2\2wy\7"+
		"|\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\13\3\2\2\2|z\3\2\2\2}~"+
		"\7x\2\2~\177\7\b\2\2\177\u0080\5\16\b\2\u0080\u0081\5\22\n\2\u0081\u00a9"+
		"\3\2\2\2\u0082\u0083\7x\2\2\u0083\u0087\7\b\2\2\u0084\u0086\7|\2\2\u0085"+
		"\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008e\7\6\2\2\u008b"+
		"\u008d\7|\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091"+
		"\u0092\7x\2\2\u0092\u009a\7\b\2\2\u0093\u009b\7y\2\2\u0094\u0096\7y\2"+
		"\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098"+
		"\5\16\b\2\u0098\u0099\7\t\2\2\u0099\u009b\3\2\2\2\u009a\u0093\3\2\2\2"+
		"\u009a\u0095\3\2\2\2\u009b\u00a4\3\2\2\2\u009c\u009e\7|\2\2\u009d\u009c"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a3\5\f\7\2\u00a2\u009d\3\2\2\2\u00a3\u00a6\3\2"+
		"\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a7\u00a9\7\7\2\2\u00a8}\3\2\2\2\u00a8\u0082\3\2\2\2"+
		"\u00a9\r\3\2\2\2\u00aa\u00ab\b\b\1\2\u00ab\u00ac\7\27\2\2\u00ac\u00ca"+
		"\5\16\b\b\u00ad\u00ae\t\3\2\2\u00ae\u00ca\5\16\b\7\u00af\u00ca\t\4\2\2"+
		"\u00b0\u00ca\t\5\2\2\u00b1\u00b4\7y\2\2\u00b2\u00b3\7\b\2\2\u00b3\u00b5"+
		"\7\u008d\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00ca\3\2\2"+
		"\2\u00b6\u00b7\7\20\2\2\u00b7\u00b8\5\16\b\2\u00b8\u00b9\7\21\2\2\u00b9"+
		"\u00ca\3\2\2\2\u00ba\u00ca\7\22\2\2\u00bb\u00bc\7y\2\2\u00bc\u00bd\7\20"+
		"\2\2\u00bd\u00c2\5\16\b\2\u00be\u00bf\7\3\2\2\u00bf\u00c1\5\16\b\2\u00c0"+
		"\u00be\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c6\7\21\2\2\u00c6"+
		"\u00ca\3\2\2\2\u00c7\u00ca\7w\2\2\u00c8\u00ca\5\20\t\2\u00c9\u00aa\3\2"+
		"\2\2\u00c9\u00ad\3\2\2\2\u00c9\u00af\3\2\2\2\u00c9\u00b0\3\2\2\2\u00c9"+
		"\u00b1\3\2\2\2\u00c9\u00b6\3\2\2\2\u00c9\u00ba\3\2\2\2\u00c9\u00bb\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00f7\3\2\2\2\u00cb"+
		"\u00cc\f\f\2\2\u00cc\u00ce\t\6\2\2\u00cd\u00cf\7|\2\2\u00ce\u00cd\3\2"+
		"\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00f6\5\16\b\r\u00d1"+
		"\u00d2\f\13\2\2\u00d2\u00d4\t\7\2\2\u00d3\u00d5\7|\2\2\u00d4\u00d3\3\2"+
		"\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00f6\5\16\b\f\u00d7"+
		"\u00d8\f\n\2\2\u00d8\u00da\t\b\2\2\u00d9\u00db\7|\2\2\u00da\u00d9\3\2"+
		"\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00f6\5\16\b\13\u00dd"+
		"\u00de\f\t\2\2\u00de\u00e0\t\t\2\2\u00df\u00e1\7|\2\2\u00e0\u00df\3\2"+
		"\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00f6\5\16\b\n\u00e3"+
		"\u00e4\f\6\2\2\u00e4\u00e6\t\n\2\2\u00e5\u00e7\7|\2\2\u00e6\u00e5\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00f6\5\16\b\7\u00e9"+
		"\u00ea\f\5\2\2\u00ea\u00ec\t\13\2\2\u00eb\u00ed\7|\2\2\u00ec\u00eb\3\2"+
		"\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f6\5\16\b\6\u00ef"+
		"\u00f0\f\4\2\2\u00f0\u00f2\t\f\2\2\u00f1\u00f3\7|\2\2\u00f2\u00f1\3\2"+
		"\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\5\16\b\5\u00f5"+
		"\u00cb\3\2\2\2\u00f5\u00d1\3\2\2\2\u00f5\u00d7\3\2\2\2\u00f5\u00dd\3\2"+
		"\2\2\u00f5\u00e3\3\2\2\2\u00f5\u00e9\3\2\2\2\u00f5\u00ef\3\2\2\2\u00f6"+
		"\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\17\3\2\2"+
		"\2\u00f9\u00f7\3\2\2\2\u00fa\u00fc\t\r\2\2\u00fb\u00fd\7y\2\2\u00fc\u00fb"+
		"\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0102\79\2\2\u0101\u0103\7|\2\2\u0102\u0101\3\2\2"+
		"\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\5\16\b\2\u0105"+
		"\21\3\2\2\2\u0106\u018a\7:\2\2\u0107\u010b\7;\2\2\u0108\u0109\t\16\2\2"+
		"\u0109\u010b\7\u0081\2\2\u010a\u0107\3\2\2\2\u010a\u0108\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\u010d\7x\2\2\u010d\u018a\7x\2\2\u010e\u0112\7<\2"+
		"\2\u010f\u0110\t\16\2\2\u0110\u0112\7\u0085\2\2\u0111\u010e\3\2\2\2\u0111"+
		"\u010f\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u018a\7x\2\2\u0114\u0118\7=\2"+
		"\2\u0115\u0116\t\16\2\2\u0116\u0118\7\u0086\2\2\u0117\u0114\3\2\2\2\u0117"+
		"\u0115\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u018a\7x\2\2\u011a\u011e\7>\2"+
		"\2\u011b\u011c\t\17\2\2\u011c\u011e\7\u0082\2\2\u011d\u011a\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u018a\7x\2\2\u0120\u0124\7?\2"+
		"\2\u0121\u0122\t\17\2\2\u0122\u0124\7\u0083\2\2\u0123\u0120\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u018a\7x\2\2\u0126\u012a\7@\2"+
		"\2\u0127\u0128\t\17\2\2\u0128\u012a\7\u0084\2\2\u0129\u0126\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\7x\2\2\u012c\u012d\7x\2"+
		"\2\u012d\u018a\7x\2\2\u012e\u0132\7A\2\2\u012f\u0130\t\20\2\2\u0130\u0132"+
		"\7\u0081\2\2\u0131\u012e\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0133\3\2\2"+
		"\2\u0133\u018a\7x\2\2\u0134\u0138\7B\2\2\u0135\u0136\t\20\2\2\u0136\u0138"+
		"\7\u0084\2\2\u0137\u0134\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\3\2\2"+
		"\2\u0139\u013a\7x\2\2\u013a\u018a\7x\2\2\u013b\u0140\7C\2\2\u013c\u0140"+
		"\7D\2\2\u013d\u013e\t\21\2\2\u013e\u0140\7\u0081\2\2\u013f\u013b\3\2\2"+
		"\2\u013f\u013c\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u018a"+
		"\7x\2\2\u0142\u0147\7E\2\2\u0143\u0147\7F\2\2\u0144\u0145\t\21\2\2\u0145"+
		"\u0147\7\u0084\2\2\u0146\u0142\3\2\2\2\u0146\u0143\3\2\2\2\u0146\u0144"+
		"\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\7x\2\2\u0149\u018a\7x\2\2\u014a"+
		"\u014b\t\22\2\2\u014b\u014c\7\u0084\2\2\u014c\u018a\7x\2\2\u014d\u014e"+
		"\7H\2\2\u014e\u018a\7x\2\2\u014f\u0155\7I\2\2\u0150\u0155\7J\2\2\u0151"+
		"\u0155\7K\2\2\u0152\u0153\7\64\2\2\u0153\u0155\7\u0081\2\2\u0154\u014f"+
		"\3\2\2\2\u0154\u0150\3\2\2\2\u0154\u0151\3\2\2\2\u0154\u0152\3\2\2\2\u0155"+
		"\u0156\3\2\2\2\u0156\u018a\7x\2\2\u0157\u015d\7L\2\2\u0158\u015d\7M\2"+
		"\2\u0159\u015d\7N\2\2\u015a\u015b\7\64\2\2\u015b\u015d\7\u0084\2\2\u015c"+
		"\u0157\3\2\2\2\u015c\u0158\3\2\2\2\u015c\u0159\3\2\2\2\u015c\u015a\3\2"+
		"\2\2\u015d\u015e\3\2\2\2\u015e\u0160\5\24\13\2\u015f\u0161\5\16\b\2\u0160"+
		"\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2"+
		"\2\2\u0163\u018a\3\2\2\2\u0164\u016a\7O\2\2\u0165\u016a\7P\2\2\u0166\u016a"+
		"\7Q\2\2\u0167\u0168\78\2\2\u0168\u016a\7\u0081\2\2\u0169\u0164\3\2\2\2"+
		"\u0169\u0165\3\2\2\2\u0169\u0166\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016b"+
		"\3\2\2\2\u016b\u016d\7x\2\2\u016c\u016e\5\16\b\2\u016d\u016c\3\2\2\2\u016e"+
		"\u016f\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u018a\3\2"+
		"\2\2\u0171\u0177\7R\2\2\u0172\u0177\7S\2\2\u0173\u0177\7T\2\2\u0174\u0175"+
		"\78\2\2\u0175\u0177\7\u0084\2\2\u0176\u0171\3\2\2\2\u0176\u0172\3\2\2"+
		"\2\u0176\u0173\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179"+
		"\5\24\13\2\u0179\u017a\7x\2\2\u017a\u018a\3\2\2\2\u017b\u017f\7U\2\2\u017c"+
		"\u017e\7x\2\2\u017d\u017c\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2"+
		"\2\2\u017f\u0180\3\2\2\2\u0180\u018a\3\2\2\2\u0181\u017f\3\2\2\2\u0182"+
		"\u0186\7V\2\2\u0183\u0185\5\24\13\2\u0184\u0183\3\2\2\2\u0185\u0188\3"+
		"\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u018a\3\2\2\2\u0188"+
		"\u0186\3\2\2\2\u0189\u0106\3\2\2\2\u0189\u010a\3\2\2\2\u0189\u0111\3\2"+
		"\2\2\u0189\u0117\3\2\2\2\u0189\u011d\3\2\2\2\u0189\u0123\3\2\2\2\u0189"+
		"\u0129\3\2\2\2\u0189\u0131\3\2\2\2\u0189\u0137\3\2\2\2\u0189\u013f\3\2"+
		"\2\2\u0189\u0146\3\2\2\2\u0189\u014a\3\2\2\2\u0189\u014d\3\2\2\2\u0189"+
		"\u0154\3\2\2\2\u0189\u015c\3\2\2\2\u0189\u0169\3\2\2\2\u0189\u0176\3\2"+
		"\2\2\u0189\u017b\3\2\2\2\u0189\u0182\3\2\2\2\u018a\23\3\2\2\2\u018b\u018c"+
		"\t\23\2\2\u018c\25\3\2\2\2\u018d\u018e\7W\2\2\u018e\u018f\7\u0087\2\2"+
		"\u018f\u0190\7\b\2\2\u0190\u0191\7\u0088\2\2\u0191\u0192\7\b\2\2\u0192"+
		"\u0193\7\u0089\2\2\u0193\u0194\7\b\2\2\u0194\u0195\7X\2\2\u0195\u0197"+
		"\5\30\r\2\u0196\u018d\3\2\2\2\u0196\u0197\3\2\2\2\u0197\27\3\2\2\2\u0198"+
		"\u019a\5\32\16\2\u0199\u0198\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u01a5\3"+
		"\2\2\2\u019b\u019d\7|\2\2\u019c\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e"+
		"\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a1\3\2\2\2\u01a0\u01a2\5\32"+
		"\16\2\u01a1\u01a0\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a4\3\2\2\2\u01a3"+
		"\u019c\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2"+
		"\2\2\u01a6\31\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8\u01a9\t\24\2\2\u01a9\u01aa"+
		"\7y\2\2\u01aa\u01ab\7[\2\2\u01ab\u01ac\5 \21\2\u01ac\u01ad\7\36\2\2\u01ad"+
		"\u01ae\5\36\20\2\u01ae\u023c\3\2\2\2\u01af\u01b0\7y\2\2\u01b0\u01b1\7"+
		"\36\2\2\u01b1\u023c\5\36\20\2\u01b2\u01b3\7\\\2\2\u01b3\u01b4\7\20\2\2"+
		"\u01b4\u01b5\5\36\20\2\u01b5\u01b6\7\21\2\2\u01b6\u023c\3\2\2\2\u01b7"+
		"\u01b8\7]\2\2\u01b8\u01b9\7\20\2\2\u01b9\u01ba\5\36\20\2\u01ba\u01be\7"+
		"\21\2\2\u01bb\u01bd\7|\2\2\u01bc\u01bb\3\2\2\2\u01bd\u01c0\3\2\2\2\u01be"+
		"\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c1\3\2\2\2\u01c0\u01be\3\2"+
		"\2\2\u01c1\u01c2\7\6\2\2\u01c2\u01c3\5\30\r\2\u01c3\u01c4\7\7\2\2\u01c4"+
		"\u01c5\7^\2\2\u01c5\u01c6\7\6\2\2\u01c6\u01c7\5\30\r\2\u01c7\u01c8\7\7"+
		"\2\2\u01c8\u023c\3\2\2\2\u01c9\u01ca\7_\2\2\u01ca\u01cb\7\20\2\2\u01cb"+
		"\u01cc\5\36\20\2\u01cc\u01d0\7\21\2\2\u01cd\u01cf\7|\2\2\u01ce\u01cd\3"+
		"\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1"+
		"\u01d3\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01eb\7\6\2\2\u01d4\u01d6\7|"+
		"\2\2\u01d5\u01d4\3\2\2\2\u01d6\u01d9\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7"+
		"\u01d8\3\2\2\2\u01d8\u01da\3\2\2\2\u01d9\u01d7\3\2\2\2\u01da\u01db\5\34"+
		"\17\2\u01db\u01df\7`\2\2\u01dc\u01de\7|\2\2\u01dd\u01dc\3\2\2\2\u01de"+
		"\u01e1\3\2\2\2\u01df\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e2\3\2"+
		"\2\2\u01e1\u01df\3\2\2\2\u01e2\u01e6\5\"\22\2\u01e3\u01e5\7|\2\2\u01e4"+
		"\u01e3\3\2\2\2\u01e5\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2"+
		"\2\2\u01e7\u01e9\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01ea\7`\2\2\u01ea"+
		"\u01ec\3\2\2\2\u01eb\u01d7\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\3\2"+
		"\2\2\u01ed\u01ee\5\30\r\2\u01ee\u01ef\7\7\2\2\u01ef\u023c\3\2\2\2\u01f0"+
		"\u01f1\7y\2\2\u01f1\u01f2\7\36\2\2\u01f2\u01f3\7a\2\2\u01f3\u01f5\7\20"+
		"\2\2\u01f4\u01f6\7z\2\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6"+
		"\u01f7\3\2\2\2\u01f7\u023c\7\21\2\2\u01f8\u01f9\t\25\2\2\u01f9\u01fa\7"+
		"\20\2\2\u01fa\u01fb\7\u008b\2\2\u01fb\u01fc\7z\2\2\u01fc\u023c\7\21\2"+
		"\2\u01fd\u01fe\7y\2\2\u01fe\u0200\7\36\2\2\u01ff\u01fd\3\2\2\2\u01ff\u0200"+
		"\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0202\7y\2\2\u0202\u020b\7\20\2\2\u0203"+
		"\u0208\5\36\20\2\u0204\u0205\7\3\2\2\u0205\u0207\5\36\20\2\u0206\u0204"+
		"\3\2\2\2\u0207\u020a\3\2\2\2\u0208\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209"+
		"\u020c\3\2\2\2\u020a\u0208\3\2\2\2\u020b\u0203\3\2\2\2\u020b\u020c\3\2"+
		"\2\2\u020c\u020d\3\2\2\2\u020d\u023c\7\21\2\2\u020e\u020f\7y\2\2\u020f"+
		"\u0210\7\36\2\2\u0210\u0211\7y\2\2\u0211\u0212\7\b\2\2\u0212\u023c\7\u008c"+
		"\2\2\u0213\u0214\7y\2\2\u0214\u0215\7\20\2\2\u0215\u0216\5\36\20\2\u0216"+
		"\u0217\7\21\2\2\u0217\u0218\7\36\2\2\u0218\u0219\5\36\20\2\u0219\u023c"+
		"\3\2\2\2\u021a\u021b\7y\2\2\u021b\u021c\7\36\2\2\u021c\u021d\5\36\20\2"+
		"\u021d\u021e\7d\2\2\u021e\u021f\7y\2\2\u021f\u023c\3\2\2\2\u0220\u0221"+
		"\7y\2\2\u0221\u0222\7\36\2\2\u0222\u0223\7y\2\2\u0223\u0224\7e\2\2\u0224"+
		"\u023c\5\36\20\2\u0225\u023c\5&\24\2\u0226\u0227\5\34\17\2\u0227\u022b"+
		"\7`\2\2\u0228\u022a\7|\2\2\u0229\u0228\3\2\2\2\u022a\u022d\3\2\2\2\u022b"+
		"\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u0231\3\2\2\2\u022d\u022b\3\2"+
		"\2\2\u022e\u0232\5\n\6\2\u022f\u0232\5,\27\2\u0230\u0232\5.\30\2\u0231"+
		"\u022e\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0230\3\2\2\2\u0232\u0236\3\2"+
		"\2\2\u0233\u0235\7|\2\2\u0234\u0233\3\2\2\2\u0235\u0238\3\2\2\2\u0236"+
		"\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u0239\3\2\2\2\u0238\u0236\3\2"+
		"\2\2\u0239\u023a\7`\2\2\u023a\u023c\3\2\2\2\u023b\u01a8\3\2\2\2\u023b"+
		"\u01af\3\2\2\2\u023b\u01b2\3\2\2\2\u023b\u01b7\3\2\2\2\u023b\u01c9\3\2"+
		"\2\2\u023b\u01f0\3\2\2\2\u023b\u01f8\3\2\2\2\u023b\u01ff\3\2\2\2\u023b"+
		"\u020e\3\2\2\2\u023b\u0213\3\2\2\2\u023b\u021a\3\2\2\2\u023b\u0220\3\2"+
		"\2\2\u023b\u0225\3\2\2\2\u023b\u0226\3\2\2\2\u023c\33\3\2\2\2\u023d\u023e"+
		"\t\26\2\2\u023e\35\3\2\2\2\u023f\u0240\b\20\1\2\u0240\u0241\t\27\2\2\u0241"+
		"\u0260\5\36\20\t\u0242\u0260\t\5\2\2\u0243\u0260\t\30\2\2\u0244\u0260"+
		"\7w\2\2\u0245\u024c\7y\2\2\u0246\u0247\7\20\2\2\u0247\u0248\5\36\20\2"+
		"\u0248\u0249\7\21\2\2\u0249\u024d\3\2\2\2\u024a\u024b\7\b\2\2\u024b\u024d"+
		"\7\u008d\2\2\u024c\u0246\3\2\2\2\u024c\u024a\3\2\2\2\u024c\u024d\3\2\2"+
		"\2\u024d\u0260\3\2\2\2\u024e\u024f\t\31\2\2\u024f\u0250\7\20\2\2\u0250"+
		"\u0251\7z\2\2\u0251\u0260\7\21\2\2\u0252\u0253\t\32\2\2\u0253\u0254\7"+
		"\20\2\2\u0254\u0257\5\36\20\2\u0255\u0256\7\3\2\2\u0256\u0258\5\36\20"+
		"\2\u0257\u0255\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025a"+
		"\7\21\2\2\u025a\u0260\3\2\2\2\u025b\u025c\7\20\2\2\u025c\u025d\5\36\20"+
		"\2\u025d\u025e\7\21\2\2\u025e\u0260\3\2\2\2\u025f\u023f\3\2\2\2\u025f"+
		"\u0242\3\2\2\2\u025f\u0243\3\2\2\2\u025f\u0244\3\2\2\2\u025f\u0245\3\2"+
		"\2\2\u025f\u024e\3\2\2\2\u025f\u0252\3\2\2\2\u025f\u025b\3\2\2\2\u0260"+
		"\u0287\3\2\2\2\u0261\u0262\f\b\2\2\u0262\u0264\t\6\2\2\u0263\u0265\7|"+
		"\2\2\u0264\u0263\3\2\2\2\u0264\u0265\3\2\2\2\u0265\u0266\3\2\2\2\u0266"+
		"\u0286\5\36\20\t\u0267\u0268\f\7\2\2\u0268\u026a\t\7\2\2\u0269\u026b\7"+
		"|\2\2\u026a\u0269\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026c\3\2\2\2\u026c"+
		"\u0286\5\36\20\b\u026d\u026e\f\6\2\2\u026e\u0270\t\33\2\2\u026f\u0271"+
		"\7|\2\2\u0270\u026f\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0272\3\2\2\2\u0272"+
		"\u0286\5\36\20\7\u0273\u0274\f\5\2\2\u0274\u0276\t\34\2\2\u0275\u0277"+
		"\7|\2\2\u0276\u0275\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0278\3\2\2\2\u0278"+
		"\u0286\5\36\20\6\u0279\u027a\f\4\2\2\u027a\u027c\7\'\2\2\u027b\u027d\7"+
		"|\2\2\u027c\u027b\3\2\2\2\u027c\u027d\3\2\2\2\u027d\u027e\3\2\2\2\u027e"+
		"\u0286\5\36\20\5\u027f\u0280\f\3\2\2\u0280\u0282\7*\2\2\u0281\u0283\7"+
		"|\2\2\u0282\u0281\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0284\3\2\2\2\u0284"+
		"\u0286\5\36\20\4\u0285\u0261\3\2\2\2\u0285\u0267\3\2\2\2\u0285\u026d\3"+
		"\2\2\2\u0285\u0273\3\2\2\2\u0285\u0279\3\2\2\2\u0285\u027f\3\2\2\2\u0286"+
		"\u0289\3\2\2\2\u0287\u0285\3\2\2\2\u0287\u0288\3\2\2\2\u0288\37\3\2\2"+
		"\2\u0289\u0287\3\2\2\2\u028a\u029e\t\35\2\2\u028b\u029e\t\31\2\2\u028c"+
		"\u028d\7h\2\2\u028d\u0291\7l\2\2\u028e\u0290\7|\2\2\u028f\u028e\3\2\2"+
		"\2\u0290\u0293\3\2\2\2\u0291\u028f\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0294"+
		"\3\2\2\2\u0293\u0291\3\2\2\2\u0294\u0298\t\31\2\2\u0295\u0297\7|\2\2\u0296"+
		"\u0295\3\2\2\2\u0297\u029a\3\2\2\2\u0298\u0296\3\2\2\2\u0298\u0299\3\2"+
		"\2\2\u0299\u029b\3\2\2\2\u029a\u0298\3\2\2\2\u029b\u029e\7m\2\2\u029c"+
		"\u029e\7i\2\2\u029d\u028a\3\2\2\2\u029d\u028b\3\2\2\2\u029d\u028c\3\2"+
		"\2\2\u029d\u029c\3\2\2\2\u029e!\3\2\2\2\u029f\u02a3\7\6\2\2\u02a0\u02a2"+
		"\7|\2\2\u02a1\u02a0\3\2\2\2\u02a2\u02a5\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a3"+
		"\u02a4\3\2\2\2\u02a4\u02a6\3\2\2\2\u02a5\u02a3\3\2\2\2\u02a6\u02a8\7n"+
		"\2\2\u02a7\u02a9\5\16\b\2\u02a8\u02a7\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9"+
		"\u02b4\3\2\2\2\u02aa\u02ac\7|\2\2\u02ab\u02aa\3\2\2\2\u02ac\u02ad\3\2"+
		"\2\2\u02ad\u02ab\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02b0\3\2\2\2\u02af"+
		"\u02b1\5\16\b\2\u02b0\u02af\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u02b3\3"+
		"\2\2\2\u02b2\u02ab\3\2\2\2\u02b3\u02b6\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b4"+
		"\u02b5\3\2\2\2\u02b5\u02b7\3\2\2\2\u02b6\u02b4\3\2\2\2\u02b7\u02b8\5$"+
		"\23\2\u02b8\u02b9\7\7\2\2\u02b9#\3\2\2\2\u02ba\u02bc\7o\2\2\u02bb\u02bd"+
		"\7y\2\2\u02bc\u02bb\3\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02bc\3\2\2\2\u02be"+
		"\u02bf\3\2\2\2\u02bf\u02c3\3\2\2\2\u02c0\u02c2\7|\2\2\u02c1\u02c0\3\2"+
		"\2\2\u02c2\u02c5\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c3\u02c4\3\2\2\2\u02c4"+
		"%\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c6\u02c7\7p\2\2\u02c7\u02c9\7y\2\2\u02c8"+
		"\u02ca\7|\2\2\u02c9\u02c8\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cb\3\2"+
		"\2\2\u02cb\u02d4\7\20\2\2\u02cc\u02d1\5(\25\2\u02cd\u02ce\7\3\2\2\u02ce"+
		"\u02d0\5(\25\2\u02cf\u02cd\3\2\2\2\u02d0\u02d3\3\2\2\2\u02d1\u02cf\3\2"+
		"\2\2\u02d1\u02d2\3\2\2\2\u02d2\u02d5\3\2\2\2\u02d3\u02d1\3\2\2\2\u02d4"+
		"\u02cc\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02d7\7\21"+
		"\2\2\u02d7\u02da\7[\2\2\u02d8\u02db\5 \21\2\u02d9\u02db\7q\2\2\u02da\u02d8"+
		"\3\2\2\2\u02da\u02d9\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02dd\7\36\2\2"+
		"\u02dd\u02f5\7\6\2\2\u02de\u02e0\7|\2\2\u02df\u02de\3\2\2\2\u02e0\u02e3"+
		"\3\2\2\2\u02e1\u02df\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e4\3\2\2\2\u02e3"+
		"\u02e1\3\2\2\2\u02e4\u02e5\5\34\17\2\u02e5\u02e9\7`\2\2\u02e6\u02e8\7"+
		"|\2\2\u02e7\u02e6\3\2\2\2\u02e8\u02eb\3\2\2\2\u02e9\u02e7\3\2\2\2\u02e9"+
		"\u02ea\3\2\2\2\u02ea\u02ec\3\2\2\2\u02eb\u02e9\3\2\2\2\u02ec\u02f0\5*"+
		"\26\2\u02ed\u02ef\7|\2\2\u02ee\u02ed\3\2\2\2\u02ef\u02f2\3\2\2\2\u02f0"+
		"\u02ee\3\2\2\2\u02f0\u02f1\3\2\2\2\u02f1\u02f3\3\2\2\2\u02f2\u02f0\3\2"+
		"\2\2\u02f3\u02f4\7`\2\2\u02f4\u02f6\3\2\2\2\u02f5\u02e1\3\2\2\2\u02f5"+
		"\u02f6\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f8\5\30\r\2\u02f8\u02fa\7"+
		"r\2\2\u02f9\u02fb\5\36\20\2\u02fa\u02f9\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb"+
		"\u02ff\3\2\2\2\u02fc\u02fe\7|\2\2\u02fd\u02fc\3\2\2\2\u02fe\u0301\3\2"+
		"\2\2\u02ff\u02fd\3\2\2\2\u02ff\u0300\3\2\2\2\u0300\u0302\3\2\2\2\u0301"+
		"\u02ff\3\2\2\2\u0302\u0303\7\7\2\2\u0303\'\3\2\2\2\u0304\u0305\7y\2\2"+
		"\u0305\u0306\7[\2\2\u0306\u0307\5 \21\2\u0307)\3\2\2\2\u0308\u030c\7\6"+
		"\2\2\u0309\u030b\7|\2\2\u030a\u0309\3\2\2\2\u030b\u030e\3\2\2\2\u030c"+
		"\u030a\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u0324\3\2\2\2\u030e\u030c\3\2"+
		"\2\2\u030f\u0313\7s\2\2\u0310\u0312\7|\2\2\u0311\u0310\3\2\2\2\u0312\u0315"+
		"\3\2\2\2\u0313\u0311\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0316\3\2\2\2\u0315"+
		"\u0313\3\2\2\2\u0316\u0321\5\16\b\2\u0317\u0319\7|\2\2\u0318\u0317\3\2"+
		"\2\2\u0319\u031a\3\2\2\2\u031a\u0318\3\2\2\2\u031a\u031b\3\2\2\2\u031b"+
		"\u031d\3\2\2\2\u031c\u031e\5\16\b\2\u031d\u031c\3\2\2\2\u031d\u031e\3"+
		"\2\2\2\u031e\u0320\3\2\2\2\u031f\u0318\3\2\2\2\u0320\u0323\3\2\2\2\u0321"+
		"\u031f\3\2\2\2\u0321\u0322\3\2\2\2\u0322\u0325\3\2\2\2\u0323\u0321\3\2"+
		"\2\2\u0324\u030f\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0329\3\2\2\2\u0326"+
		"\u0328\7|\2\2\u0327\u0326\3\2\2\2\u0328\u032b\3\2\2\2\u0329\u0327\3\2"+
		"\2\2\u0329\u032a\3\2\2\2\u032a\u032d\3\2\2\2\u032b\u0329\3\2\2\2\u032c"+
		"\u032e\5$\23\2\u032d\u032c\3\2\2\2\u032d\u032e\3\2\2\2\u032e\u0344\3\2"+
		"\2\2\u032f\u0333\7t\2\2\u0330\u0332\7|\2\2\u0331\u0330\3\2\2\2\u0332\u0335"+
		"\3\2\2\2\u0333\u0331\3\2\2\2\u0333\u0334\3\2\2\2\u0334\u0336\3\2\2\2\u0335"+
		"\u0333\3\2\2\2\u0336\u0341\5\16\b\2\u0337\u0339\7|\2\2\u0338\u0337\3\2"+
		"\2\2\u0339\u033a\3\2\2\2\u033a\u0338\3\2\2\2\u033a\u033b\3\2\2\2\u033b"+
		"\u033d\3\2\2\2\u033c\u033e\5\16\b\2\u033d\u033c\3\2\2\2\u033d\u033e\3"+
		"\2\2\2\u033e\u0340\3\2\2\2\u033f\u0338\3\2\2\2\u0340\u0343\3\2\2\2\u0341"+
		"\u033f\3\2\2\2\u0341\u0342\3\2\2\2\u0342\u0345\3\2\2\2\u0343\u0341\3\2"+
		"\2\2\u0344\u032f\3\2\2\2\u0344\u0345\3\2\2\2\u0345\u0349\3\2\2\2\u0346"+
		"\u0348\7|\2\2\u0347\u0346\3\2\2\2\u0348\u034b\3\2\2\2\u0349\u0347\3\2"+
		"\2\2\u0349\u034a\3\2\2\2\u034a\u034c\3\2\2\2\u034b\u0349\3\2\2\2\u034c"+
		"\u034d\7\7\2\2\u034d+\3\2\2\2\u034e\u0352\7\6\2\2\u034f\u0351\7|\2\2\u0350"+
		"\u034f\3\2\2\2\u0351\u0354\3\2\2\2\u0352\u0350\3\2\2\2\u0352\u0353\3\2"+
		"\2\2\u0353\u0355\3\2\2\2\u0354\u0352\3\2\2\2\u0355\u0359\7n\2\2\u0356"+
		"\u0358\7|\2\2\u0357\u0356\3\2\2\2\u0358\u035b\3\2\2\2\u0359\u0357\3\2"+
		"\2\2\u0359\u035a\3\2\2\2\u035a\u035d\3\2\2\2\u035b\u0359\3\2\2\2\u035c"+
		"\u035e\5\16\b\2\u035d\u035c\3\2\2\2\u035d\u035e\3\2\2\2\u035e\u0369\3"+
		"\2\2\2\u035f\u0361\7|\2\2\u0360\u035f\3\2\2\2\u0361\u0362\3\2\2\2\u0362"+
		"\u0360\3\2\2\2\u0362\u0363\3\2\2\2\u0363\u0365\3\2\2\2\u0364\u0366\5\16"+
		"\b\2\u0365\u0364\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u0368\3\2\2\2\u0367"+
		"\u0360\3\2\2\2\u0368\u036b\3\2\2\2\u0369\u0367\3\2\2\2\u0369\u036a\3\2"+
		"\2\2\u036a\u036c\3\2\2\2\u036b\u0369\3\2\2\2\u036c\u036d\7\7\2\2\u036d"+
		"-\3\2\2\2\u036e\u0372\7\6\2\2\u036f\u0371\7|\2\2\u0370\u036f\3\2\2\2\u0371"+
		"\u0374\3\2\2\2\u0372\u0370\3\2\2\2\u0372\u0373\3\2\2\2\u0373\u0375\3\2"+
		"\2\2\u0374\u0372\3\2\2\2\u0375\u0379\7u\2\2\u0376\u0378\7|\2\2\u0377\u0376"+
		"\3\2\2\2\u0378\u037b\3\2\2\2\u0379\u0377\3\2\2\2\u0379\u037a\3\2\2\2\u037a"+
		"\u037d\3\2\2\2\u037b\u0379\3\2\2\2\u037c\u037e\5\60\31\2\u037d\u037c\3"+
		"\2\2\2\u037d\u037e\3\2\2\2\u037e\u0389\3\2\2\2\u037f\u0381\7|\2\2\u0380"+
		"\u037f\3\2\2\2\u0381\u0382\3\2\2\2\u0382\u0380\3\2\2\2\u0382\u0383\3\2"+
		"\2\2\u0383\u0385\3\2\2\2\u0384\u0386\5\60\31\2\u0385\u0384\3\2\2\2\u0385"+
		"\u0386\3\2\2\2\u0386\u0388\3\2\2\2\u0387\u0380\3\2\2\2\u0388\u038b\3\2"+
		"\2\2\u0389\u0387\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u038c\3\2\2\2\u038b"+
		"\u0389\3\2\2\2\u038c\u038d\7\7\2\2\u038d/\3\2\2\2\u038e\u038f\7y\2\2\u038f"+
		"\u0390\7\b\2\2\u0390\u0391\5\20\t\2\u0391\61\3\2\2\2\u0083\649ILTZacg"+
		"losz\u0087\u008e\u0095\u009a\u009f\u00a4\u00a8\u00b4\u00c2\u00c9\u00ce"+
		"\u00d4\u00da\u00e0\u00e6\u00ec\u00f2\u00f5\u00f7\u00fe\u0102\u010a\u0111"+
		"\u0117\u011d\u0123\u0129\u0131\u0137\u013f\u0146\u0154\u015c\u0162\u0169"+
		"\u016f\u0176\u017f\u0186\u0189\u0196\u0199\u019e\u01a1\u01a5\u01be\u01d0"+
		"\u01d7\u01df\u01e6\u01eb\u01f5\u01ff\u0208\u020b\u022b\u0231\u0236\u023b"+
		"\u024c\u0257\u025f\u0264\u026a\u0270\u0276\u027c\u0282\u0285\u0287\u0291"+
		"\u0298\u029d\u02a3\u02a8\u02ad\u02b0\u02b4\u02be\u02c3\u02c9\u02d1\u02d4"+
		"\u02da\u02e1\u02e9\u02f0\u02f5\u02fa\u02ff\u030c\u0313\u031a\u031d\u0321"+
		"\u0324\u0329\u032d\u0333\u033a\u033d\u0341\u0344\u0349\u0352\u0359\u035d"+
		"\u0362\u0365\u0369\u0372\u0379\u037d\u0382\u0385\u0389";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}