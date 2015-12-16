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
		T__107=108, HLINE=109, NUM=110, ID=111, STRING=112, RESERVED=113, NL=114, 
		LINE_COMMENT=115, COMMENT=116, WS=117, ERROR_CHAR=118;
	public static final int
		RULE_sequentFile = 0, RULE_proofFile = 1, RULE_programFile = 2, RULE_sequent = 3, 
		RULE_proof = 4, RULE_proofStep = 5, RULE_formula = 6, RULE_qformula = 7, 
		RULE_justification = 8, RULE_numOrId = 9, RULE_program = 10, RULE_stmts = 11, 
		RULE_stmt = 12, RULE_lgk = 13, RULE_exp = 14, RULE_type = 15, RULE_loopInvariant = 16, 
		RULE_modifies = 17, RULE_methodDecl = 18, RULE_funDecl = 19, RULE_param = 20, 
		RULE_methodContract = 21, RULE_invariants = 22, RULE_facts = 23, RULE_factOrFunDecl = 24, 
		RULE_fact = 25;
	public static final String[] ruleNames = {
		"sequentFile", "proofFile", "programFile", "sequent", "proof", "proofStep", 
		"formula", "qformula", "justification", "numOrId", "program", "stmts", 
		"stmt", "lgk", "exp", "type", "loopInvariant", "modifies", "methodDecl", 
		"funDecl", "param", "methodContract", "invariants", "facts", "factOrFunDecl", 
		"fact"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'|-'", "'⊢'", "'{'", "'}'", "'.'", "'assume'", "'_|_'", 
		"'⊥'", "'('", "')'", "'$result'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<'", 
		"'<='", "'≤'", "'>'", "'>='", "'≥'", "'='", "'=='", "'!='", "'≠'", "'not'", 
		"'!'", "'~'", "'¬'", "'and'", "'&&'", "'∧'", "'or'", "'||'", "'∨'", "'implies'", 
		"'->'", "'→'", "'forall'", "'all'", "'A'", "'∀'", "'exists'", "'some'", 
		"'E'", "'∃'", "'|'", "'premise'", "'andi'", "'ande1'", "'ande2'", "'ori1'", 
		"'ori2'", "'ore'", "'impliesi'", "'impliese'", "'noti'", "'negi'", "'note'", 
		"'nege'", "'bottome'", "'Pbc'", "'foralli'", "'alli'", "'Ai'", "'foralle'", 
		"'alle'", "'Ae'", "'existsi'", "'somei'", "'Ei'", "'existse'", "'somee'", 
		"'Ee'", "'algebra'", "'auto'", "'import'", "'logika'", "'_'", "'\"\"\"'", 
		"'var'", "'val'", "':'", "'assert'", "'if'", "'else'", "'while'", "'readInt'", 
		"'print'", "'println'", "'+:'", "':+'", "'BigInt'", "'Z'", "'Seq'", "'Zs'", 
		"'['", "']'", "'invariant'", "'modifies'", "'def'", "'Unit'", "'return'", 
		"'requires'", "'ensures'", "'fact'"
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
		null, "HLINE", "NUM", "ID", "STRING", "RESERVED", "NL", "LINE_COMMENT", 
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
			setState(52);
			sequent();
			setState(56);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(53);
					match(NL);
					}
					} 
				}
				setState(58);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(60);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(59);
				proof();
				}
			}

			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(62);
				match(NL);
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
			setState(107);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0) || _la==NUM || _la==ID) {
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
				((SequentContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
					((SequentContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0) || _la==NUM || _la==ID) {
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
				((SequentContext)_localctx).tb = match(HLINE);
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0) || _la==NUM || _la==ID );
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
			setState(109);
			((ProofContext)_localctx).tb = match(T__3);
			setState(111);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(110);
				proofStep();
				}
			}

			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(114); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(113);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(116); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(119);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(118);
					proofStep();
					}
				}

				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			((ProofContext)_localctx).te = match(T__4);
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(127);
					match(NL);
					}
					} 
				}
				setState(132);
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
			setState(176);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				((StepContext)_localctx).tb = match(NUM);
				setState(134);
				match(T__5);
				setState(135);
				formula(0);
				setState(136);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(139);
				match(T__5);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(140);
					match(NL);
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(146);
				match(T__3);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(147);
					match(NL);
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(153);
				((SubProofContext)_localctx).assume = match(NUM);
				setState(154);
				match(T__5);
				setState(162);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(155);
					((SubProofContext)_localctx).fresh = match(ID);
					}
					break;
				case 2:
					{
					setState(157);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(156);
						((SubProofContext)_localctx).fresh = match(ID);
						}
						break;
					}
					setState(159);
					formula(0);
					setState(160);
					match(T__6);
					}
					break;
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(165); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(164);
						match(NL);
						}
						}
						setState(167); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NL );
					setState(169);
					proofStep();
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175);
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
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
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
	public static class BottomContext extends FormulaContext {
		public Token t;
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
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
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
			setState(208);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(179);
				((UnaryContext)_localctx).op = match(T__16);
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
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
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
				_localctx = new BottomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				((BottomContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
					((BottomContext)_localctx).t = (Token)_errHandler.recoverInline(this);
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
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
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
				((ParenContext)_localctx).tb = match(T__9);
				setState(190);
				formula(0);
				setState(191);
				((ParenContext)_localctx).te = match(T__10);
				}
				break;
			case 6:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				((ResultContext)_localctx).t = match(T__11);
				}
				break;
			case 7:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				((ApplyContext)_localctx).fun = match(ID);
				setState(195);
				match(T__9);
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
				((ApplyContext)_localctx).te = match(T__10);
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				((IntContext)_localctx).t = match(NUM);
				}
				break;
			case 9:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(252);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(210);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(211);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(213);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(212);
							match(NL);
							}
						}

						setState(215);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(216);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(217);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(219);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(218);
							match(NL);
							}
						}

						setState(221);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(222);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(223);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(225);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(224);
							match(NL);
							}
						}

						setState(227);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(228);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(229);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(234);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(235);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
						_errHandler.recoverInline(this);
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
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(240);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(241);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) ) {
						_errHandler.recoverInline(this);
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
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(246);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(247);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
						_errHandler.recoverInline(this);
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
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(256);
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
			setState(257);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(259); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(258);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).gVars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(261); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(263);
			match(T__48);
			setState(265);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(264);
				match(NL);
				}
			}

			setState(267);
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
		public Token orStep;
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
		public Token notStep;
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
		public Token NUM;
		public List<Token> steps = new ArrayList<Token>();
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public AlgebraContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class BottomElimContext extends JustificationContext {
		public Token tb;
		public Token falseStep;
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
		enterRule(_localctx, 16, RULE_justification);
		int _la;
		try {
			setState(392);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				((PremiseContext)_localctx).t = match(T__49);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				switch (_input.LA(1)) {
				case T__50:
					{
					setState(270);
					((AndIntroContext)_localctx).tb = match(T__50);
					}
					break;
				case T__32:
				case T__33:
					{
					setState(271);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__32 || _la==T__33) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(272);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(275);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(276);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(280);
				switch (_input.LA(1)) {
				case T__51:
				case T__52:
					{
					setState(277);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__51 || _la==T__52) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__32:
				case T__33:
					{
					setState(278);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__32 || _la==T__33) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(279);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(282);
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(286);
				switch (_input.LA(1)) {
				case T__53:
				case T__54:
					{
					setState(283);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__53 || _la==T__54) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__35:
				case T__36:
					{
					setState(284);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__35 || _la==T__36) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(285);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(288);
				((OrIntroContext)_localctx).orStep = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(292);
				switch (_input.LA(1)) {
				case T__55:
					{
					setState(289);
					((OrElimContext)_localctx).tb = match(T__55);
					}
					break;
				case T__35:
				case T__36:
					{
					setState(290);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__35 || _la==T__36) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(291);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(294);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(295);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(296);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(300);
				switch (_input.LA(1)) {
				case T__56:
					{
					setState(297);
					((ImpliesIntroContext)_localctx).tb = match(T__56);
					}
					break;
				case T__38:
				case T__39:
					{
					setState(298);
					((ImpliesIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__38 || _la==T__39) ) {
						((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(299);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(302);
				((ImpliesIntroContext)_localctx).impliesStep = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(306);
				switch (_input.LA(1)) {
				case T__57:
					{
					setState(303);
					((ImpliesElimContext)_localctx).tb = match(T__57);
					}
					break;
				case T__38:
				case T__39:
					{
					setState(304);
					((ImpliesElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__38 || _la==T__39) ) {
						((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(305);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(308);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(309);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(313);
				switch (_input.LA(1)) {
				case T__58:
				case T__59:
					{
					setState(310);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__58 || _la==T__59) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__28:
				case T__29:
				case T__30:
					{
					setState(311);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(312);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(315);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(320);
				switch (_input.LA(1)) {
				case T__60:
					{
					setState(316);
					((NegElimContext)_localctx).tb = match(T__60);
					}
					break;
				case T__61:
					{
					setState(317);
					((NegElimContext)_localctx).tb = match(T__61);
					}
					break;
				case T__28:
				case T__29:
				case T__30:
					{
					setState(318);
					((NegElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
						((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(319);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(322);
				((NegElimContext)_localctx).step = match(NUM);
				setState(323);
				((NegElimContext)_localctx).notStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(327);
				switch (_input.LA(1)) {
				case T__62:
					{
					setState(324);
					((BottomElimContext)_localctx).tb = match(T__62);
					}
					break;
				case T__7:
				case T__8:
					{
					setState(325);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__7 || _la==T__8) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((BottomElimContext)_localctx).falseStep = match(NUM);
				}
				break;
			case 11:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(330);
				((PbcContext)_localctx).tb = match(T__63);
				setState(331);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 12:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(337);
				switch (_input.LA(1)) {
				case T__64:
					{
					setState(332);
					((ForallIntroContext)_localctx).tb = match(T__64);
					}
					break;
				case T__65:
					{
					setState(333);
					((ForallIntroContext)_localctx).tb = match(T__65);
					}
					break;
				case T__66:
					{
					setState(334);
					((ForallIntroContext)_localctx).tb = match(T__66);
					}
					break;
				case T__43:
					{
					setState(335);
					((ForallIntroContext)_localctx).tb = match(T__43);
					setState(336);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(339);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(345);
				switch (_input.LA(1)) {
				case T__67:
					{
					setState(340);
					((ForallElimContext)_localctx).tb = match(T__67);
					}
					break;
				case T__68:
					{
					setState(341);
					((ForallElimContext)_localctx).tb = match(T__68);
					}
					break;
				case T__69:
					{
					setState(342);
					((ForallElimContext)_localctx).tb = match(T__69);
					}
					break;
				case T__43:
					{
					setState(343);
					((ForallElimContext)_localctx).tb = match(T__43);
					setState(344);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(347);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
				setState(349); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(348);
					formula(0);
					}
					}
					setState(351); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 14:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(353);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (T__70 - 71)) | (1L << (T__71 - 71)) | (1L << (T__72 - 71)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(354);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(356); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(355);
					formula(0);
					}
					}
					setState(358); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 15:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(360);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (T__73 - 74)) | (1L << (T__74 - 74)) | (1L << (T__75 - 74)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(361);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(362);
				((ExistsElimContext)_localctx).subproof = match(NUM);
				}
				break;
			case 16:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(364);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(365);
				((ExistsIntroContext)_localctx).tb = match(T__47);
				setState(366);
				match(ID);
				setState(367);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(369); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(368);
					formula(0);
					}
					}
					setState(371); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 17:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(373);
				((ExistsElimContext)_localctx).tb = match(T__47);
				setState(374);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(375);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(376);
				((ExistsElimContext)_localctx).subproof = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(378);
				((AlgebraContext)_localctx).tb = match(T__76);
				setState(382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(379);
					((AlgebraContext)_localctx).NUM = match(NUM);
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).NUM);
					}
					}
					setState(384);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(385);
				((AutoContext)_localctx).tb = match(T__77);
				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(386);
					((AutoContext)_localctx).numOrId = numOrId();
					((AutoContext)_localctx).stepOrFacts.add(((AutoContext)_localctx).numOrId);
					}
					}
					setState(391);
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
			setState(394);
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
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
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
		enterRule(_localctx, 20, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			_la = _input.LA(1);
			if (_la==T__78) {
				{
				setState(396);
				((ProgramContext)_localctx).tb = match(T__78);
				setState(397);
				((ProgramContext)_localctx).org = match(ID);
				setState(398);
				match(T__5);
				setState(399);
				((ProgramContext)_localctx).sireum = match(ID);
				setState(400);
				match(T__5);
				setState(401);
				match(T__79);
				setState(402);
				match(T__5);
				setState(403);
				((ProgramContext)_localctx).te = match(T__80);
				setState(405); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(404);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(407); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(414);
				switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
				case 1:
					{
					setState(409);
					lgk();
					setState(410);
					match(T__81);
					setState(411);
					facts();
					setState(412);
					((ProgramContext)_localctx).te = match(T__81);
					}
					break;
				}
				setState(416);
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
			setState(420);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__82 - 80)) | (1L << (T__83 - 80)) | (1L << (T__85 - 80)) | (1L << (T__86 - 80)) | (1L << (T__88 - 80)) | (1L << (T__90 - 80)) | (1L << (T__91 - 80)) | (1L << (T__102 - 80)) | (1L << (ID - 80)))) != 0)) {
				{
				setState(419);
				stmt();
				}
			}

			setState(432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(423); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(422);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(425); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(428);
				_la = _input.LA(1);
				if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__82 - 80)) | (1L << (T__83 - 80)) | (1L << (T__85 - 80)) | (1L << (T__86 - 80)) | (1L << (T__88 - 80)) | (1L << (T__90 - 80)) | (1L << (T__91 - 80)) | (1L << (T__102 - 80)) | (1L << (ID - 80)))) != 0)) {
					{
					setState(427);
					stmt();
					}
				}

				}
				}
				setState(434);
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
		public Token s;
		public Token te;
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public PrintStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class SeqCloneStmtContext extends StmtContext {
		public Token tb;
		public Token te;
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
			setState(564);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(435);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__82 || _la==T__83) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(436);
				match(ID);
				setState(437);
				match(T__84);
				setState(438);
				type();
				setState(439);
				match(T__23);
				setState(440);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(442);
				((AssignVarStmtContext)_localctx).tb = match(ID);
				setState(443);
				match(T__23);
				setState(444);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(445);
				((AssertStmtContext)_localctx).tb = match(T__85);
				setState(446);
				match(T__9);
				setState(447);
				exp(0);
				setState(448);
				((AssertStmtContext)_localctx).te = match(T__10);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(450);
				((IfStmtContext)_localctx).tb = match(T__86);
				setState(451);
				match(T__9);
				setState(452);
				exp(0);
				setState(453);
				match(T__10);
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(454);
					match(NL);
					}
					}
					setState(459);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(460);
				((IfStmtContext)_localctx).ttb = match(T__3);
				setState(461);
				((IfStmtContext)_localctx).ts = stmts();
				setState(462);
				((IfStmtContext)_localctx).tte = match(T__4);
				setState(463);
				match(T__87);
				setState(467);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(464);
					match(NL);
					}
					}
					setState(469);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(470);
				((IfStmtContext)_localctx).ftb = match(T__3);
				setState(471);
				((IfStmtContext)_localctx).fs = stmts();
				setState(472);
				((IfStmtContext)_localctx).fte = match(T__4);
				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(474);
				((WhileStmtContext)_localctx).tb = match(T__88);
				setState(475);
				match(T__9);
				setState(476);
				exp(0);
				setState(477);
				match(T__10);
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(478);
					match(NL);
					}
					}
					setState(483);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(484);
				((WhileStmtContext)_localctx).ltb = match(T__3);
				setState(496);
				switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
				case 1:
					{
					setState(488);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(485);
						match(NL);
						}
						}
						setState(490);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(491);
					lgk();
					setState(492);
					match(T__81);
					setState(493);
					loopInvariant();
					setState(494);
					match(T__81);
					}
					break;
				}
				setState(498);
				stmts();
				setState(499);
				((WhileStmtContext)_localctx).lte = match(T__4);
				}
				break;
			case 6:
				_localctx = new ReadIntStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(501);
				((ReadIntStmtContext)_localctx).tb = match(ID);
				setState(502);
				match(T__23);
				setState(503);
				match(T__89);
				setState(504);
				match(T__9);
				setState(506);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(505);
					match(STRING);
					}
				}

				setState(508);
				((ReadIntStmtContext)_localctx).te = match(T__10);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(509);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__90 || _la==T__91) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(510);
				match(T__9);
				setState(511);
				((PrintStmtContext)_localctx).s = match(ID);
				setState(512);
				match(STRING);
				setState(513);
				((PrintStmtContext)_localctx).te = match(T__10);
				}
				break;
			case 8:
				_localctx = new MethodInvocationStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(516);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(514);
					((MethodInvocationStmtContext)_localctx).id = match(ID);
					setState(515);
					match(T__23);
					}
					break;
				}
				setState(518);
				((MethodInvocationStmtContext)_localctx).m = match(ID);
				setState(519);
				match(T__9);
				setState(528);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__16) | (1L << T__28))) != 0) || ((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (T__94 - 95)) | (1L << (T__95 - 95)) | (1L << (T__96 - 95)) | (1L << (T__97 - 95)) | (1L << (NUM - 95)) | (1L << (ID - 95)))) != 0)) {
					{
					setState(520);
					exp(0);
					setState(525);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(521);
						match(T__0);
						setState(522);
						exp(0);
						}
						}
						setState(527);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(530);
				((MethodInvocationStmtContext)_localctx).te = match(T__10);
				}
				break;
			case 9:
				_localctx = new SeqCloneStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(531);
				((SeqCloneStmtContext)_localctx).tb = match(ID);
				setState(532);
				match(T__23);
				setState(533);
				match(ID);
				setState(534);
				match(T__5);
				setState(535);
				((SeqCloneStmtContext)_localctx).te = match(ID);
				}
				break;
			case 10:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(536);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(537);
				match(T__9);
				setState(538);
				exp(0);
				setState(539);
				match(T__10);
				setState(540);
				match(T__23);
				setState(541);
				exp(0);
				}
				break;
			case 11:
				_localctx = new SeqPendStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(543);
				((SeqPendStmtContext)_localctx).id = match(ID);
				setState(544);
				match(T__23);
				setState(545);
				exp(0);
				setState(546);
				((SeqPendStmtContext)_localctx).op = match(T__92);
				setState(547);
				((SeqPendStmtContext)_localctx).seq = match(ID);
				}
				break;
			case 12:
				_localctx = new SeqPendStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(549);
				((SeqPendStmtContext)_localctx).id = match(ID);
				setState(550);
				match(T__23);
				setState(551);
				((SeqPendStmtContext)_localctx).seq = match(ID);
				setState(552);
				((SeqPendStmtContext)_localctx).op = match(T__93);
				setState(553);
				exp(0);
				}
				break;
			case 13:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(554);
				methodDecl();
				}
				break;
			case 14:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(555);
				lgk();
				setState(556);
				match(T__81);
				setState(560);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(557);
					proof();
					}
					break;
				case 2:
					{
					setState(558);
					sequent();
					}
					break;
				case 3:
					{
					setState(559);
					invariants();
					}
					break;
				}
				setState(562);
				((LogikaStmtContext)_localctx).te = match(T__81);
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
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
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
			setState(566);
			((LgkContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__79 || _la==ID) ) {
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
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
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
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
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
			setState(598);
			switch (_input.LA(1)) {
			case T__16:
			case T__28:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(569);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__28) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(570);
				exp(7);
				}
				break;
			case NUM:
				{
				_localctx = new IntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(571);
				((IntExpContext)_localctx).t = match(NUM);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(572);
				((IdExpContext)_localctx).tb = match(ID);
				setState(579);
				switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
				case 1:
					{
					setState(573);
					match(T__9);
					setState(574);
					exp(0);
					setState(575);
					((IdExpContext)_localctx).te = match(T__10);
					}
					break;
				case 2:
					{
					setState(577);
					match(T__5);
					setState(578);
					((IdExpContext)_localctx).te = match(ID);
					}
					break;
				}
				}
				break;
			case T__94:
			case T__95:
				{
				_localctx = new BigIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(581);
				((BigIntExpContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__94 || _la==T__95) ) {
					((BigIntExpContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(582);
				match(T__9);
				setState(583);
				match(STRING);
				setState(584);
				((BigIntExpContext)_localctx).te = match(T__10);
				}
				break;
			case T__96:
			case T__97:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(585);
				((SeqExpContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__96 || _la==T__97) ) {
					((SeqExpContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(586);
				match(T__9);
				setState(587);
				exp(0);
				setState(590);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(588);
					match(T__0);
					setState(589);
					exp(0);
					}
				}

				setState(592);
				((SeqExpContext)_localctx).te = match(T__10);
				}
				break;
			case T__9:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(594);
				((ParenExpContext)_localctx).tb = match(T__9);
				setState(595);
				exp(0);
				setState(596);
				((ParenExpContext)_localctx).te = match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(638);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(636);
					switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(600);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(601);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(603);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(602);
							match(NL);
							}
						}

						setState(605);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(606);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(607);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(609);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(608);
							match(NL);
							}
						}

						setState(611);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(612);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(613);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(615);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(614);
							match(NL);
							}
						}

						setState(617);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(618);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(619);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(621);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(620);
							match(NL);
							}
						}

						setState(623);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(624);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(625);
						match(T__32);
						}
						setState(627);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(626);
							match(NL);
							}
						}

						setState(629);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(630);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(631);
						match(T__35);
						}
						setState(633);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(632);
							match(NL);
							}
						}

						setState(635);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(640);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
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
	public static class IntTypeContext extends TypeContext {
		public Token t;
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_type);
		int _la;
		try {
			setState(659);
			switch (_input.LA(1)) {
			case T__94:
			case T__95:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(641);
				((IntTypeContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__94 || _la==T__95) ) {
					((IntTypeContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case T__96:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(642);
				((IntSeqTypeContext)_localctx).tb = match(T__96);
				setState(643);
				match(T__98);
				setState(647);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(644);
					match(NL);
					}
					}
					setState(649);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(650);
				_la = _input.LA(1);
				if ( !(_la==T__94 || _la==T__95) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(654);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(651);
					match(NL);
					}
					}
					setState(656);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(657);
				((IntSeqTypeContext)_localctx).te = match(T__99);
				}
				break;
			case T__97:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(658);
				((IntSeqTypeContext)_localctx).t = match(T__97);
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
			setState(661);
			((LoopInvariantContext)_localctx).tb = match(T__3);
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
			((LoopInvariantContext)_localctx).itb = match(T__100);
			{
			setState(670);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0) || _la==NUM || _la==ID) {
				{
				setState(669);
				formula(0);
				}
			}

			setState(682);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(673); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(672);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(675); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(678);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0) || _la==NUM || _la==ID) {
					{
					setState(677);
					formula(0);
					}
				}

				}
				}
				setState(684);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(685);
			modifies();
			setState(686);
			((LoopInvariantContext)_localctx).te = match(T__4);
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
			setState(693);
			((ModifiesContext)_localctx).tb = match(T__101);
			setState(695); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(694);
				match(ID);
				}
				}
				setState(697); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(702);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(699);
					match(NL);
					}
					} 
				}
				setState(704);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
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
			setState(705);
			((MethodDeclContext)_localctx).tb = match(T__102);
			setState(706);
			match(ID);
			setState(708);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(707);
				match(NL);
				}
			}

			setState(710);
			match(T__9);
			setState(719);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(711);
				param();
				setState(716);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(712);
					match(T__0);
					setState(713);
					param();
					}
					}
					setState(718);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(721);
			match(T__10);
			setState(722);
			match(T__84);
			setState(725);
			switch (_input.LA(1)) {
			case T__94:
			case T__95:
			case T__96:
			case T__97:
				{
				setState(723);
				type();
				}
				break;
			case T__103:
				{
				setState(724);
				match(T__103);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(727);
			((MethodDeclContext)_localctx).te = match(T__23);
			setState(728);
			((MethodDeclContext)_localctx).mtb = match(T__3);
			setState(746);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				{
				setState(732);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(729);
					match(NL);
					}
					}
					setState(734);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(735);
				lgk();
				setState(736);
				match(T__81);
				setState(737);
				methodContract();
				setState(741);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(738);
					match(NL);
					}
					}
					setState(743);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(744);
				match(T__81);
				}
				break;
			}
			setState(748);
			stmts();
			setState(749);
			((MethodDeclContext)_localctx).rtb = match(T__104);
			setState(751);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__16) | (1L << T__28))) != 0) || ((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (T__94 - 95)) | (1L << (T__95 - 95)) | (1L << (T__96 - 95)) | (1L << (T__97 - 95)) | (1L << (NUM - 95)) | (1L << (ID - 95)))) != 0)) {
				{
				setState(750);
				exp(0);
				}
			}

			setState(756);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(753);
				match(NL);
				}
				}
				setState(758);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(759);
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

	public static class FunDeclContext extends ParserRuleContext {
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
		public FunDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDecl; }
	}

	public final FunDeclContext funDecl() throws RecognitionException {
		FunDeclContext _localctx = new FunDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(761);
			((FunDeclContext)_localctx).tb = match(T__102);
			setState(762);
			match(ID);
			setState(764);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(763);
				match(NL);
				}
			}

			setState(766);
			match(T__9);
			setState(767);
			param();
			setState(772);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(768);
				match(T__0);
				setState(769);
				param();
				}
				}
				setState(774);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(775);
			match(T__10);
			setState(776);
			match(T__84);
			setState(777);
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
		enterRule(_localctx, 40, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(779);
			((ParamContext)_localctx).tb = match(ID);
			setState(780);
			match(T__84);
			setState(781);
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
		enterRule(_localctx, 42, RULE_methodContract);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(783);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(787);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(784);
					match(NL);
					}
					} 
				}
				setState(789);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
			}
			setState(811);
			_la = _input.LA(1);
			if (_la==T__105) {
				{
				setState(790);
				((MethodContractContext)_localctx).rtb = match(T__105);
				setState(794);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(791);
					match(NL);
					}
					}
					setState(796);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(797);
				formula(0);
				setState(808);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(799); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(798);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(801); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(804);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0) || _la==NUM || _la==ID) {
							{
							setState(803);
							formula(0);
							}
						}

						}
						} 
					}
					setState(810);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				}
				}
			}

			setState(816);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(813);
					match(NL);
					}
					} 
				}
				setState(818);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			}
			setState(820);
			_la = _input.LA(1);
			if (_la==T__101) {
				{
				setState(819);
				modifies();
				}
			}

			setState(843);
			_la = _input.LA(1);
			if (_la==T__106) {
				{
				setState(822);
				((MethodContractContext)_localctx).rte = match(T__106);
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
				formula(0);
				setState(840);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(831); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(830);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(833); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(836);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0) || _la==NUM || _la==ID) {
							{
							setState(835);
							formula(0);
							}
						}

						}
						} 
					}
					setState(842);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
				}
				}
			}

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
		enterRule(_localctx, 44, RULE_invariants);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(853);
			((InvariantsContext)_localctx).tb = match(T__3);
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
			setState(860);
			((InvariantsContext)_localctx).itb = match(T__100);
			setState(864);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
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
				_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			}
			setState(868);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0) || _la==NUM || _la==ID) {
				{
				setState(867);
				formula(0);
				}
			}

			setState(880);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(871); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(870);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(873); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,120,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(876);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__16) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0) || _la==NUM || _la==ID) {
					{
					setState(875);
					formula(0);
					}
				}

				}
				}
				setState(882);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(883);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(887);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(884);
				match(NL);
				}
				}
				setState(889);
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

	public static class FactsContext extends ParserRuleContext {
		public Token tb;
		public Token ftb;
		public Token te;
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public List<FactOrFunDeclContext> factOrFunDecl() {
			return getRuleContexts(FactOrFunDeclContext.class);
		}
		public FactOrFunDeclContext factOrFunDecl(int i) {
			return getRuleContext(FactOrFunDeclContext.class,i);
		}
		public FactsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_facts; }
	}

	public final FactsContext facts() throws RecognitionException {
		FactsContext _localctx = new FactsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_facts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(890);
			((FactsContext)_localctx).tb = match(T__3);
			setState(894);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(891);
				match(NL);
				}
				}
				setState(896);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(897);
			((FactsContext)_localctx).ftb = match(T__107);
			setState(901);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(898);
					match(NL);
					}
					} 
				}
				setState(903);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			}
			setState(905);
			_la = _input.LA(1);
			if (_la==T__102 || _la==ID) {
				{
				setState(904);
				factOrFunDecl();
				}
			}

			setState(917);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(908); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(907);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(910); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(913);
				_la = _input.LA(1);
				if (_la==T__102 || _la==ID) {
					{
					setState(912);
					factOrFunDecl();
					}
				}

				}
				}
				setState(919);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(920);
			((FactsContext)_localctx).te = match(T__4);
			setState(924);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(921);
				match(NL);
				}
				}
				setState(926);
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

	public static class FactOrFunDeclContext extends ParserRuleContext {
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public FunDeclContext funDecl() {
			return getRuleContext(FunDeclContext.class,0);
		}
		public FactOrFunDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factOrFunDecl; }
	}

	public final FactOrFunDeclContext factOrFunDecl() throws RecognitionException {
		FactOrFunDeclContext _localctx = new FactOrFunDeclContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_factOrFunDecl);
		try {
			setState(929);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(927);
				fact();
				}
				break;
			case T__102:
				enterOuterAlt(_localctx, 2);
				{
				setState(928);
				funDecl();
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
		enterRule(_localctx, 50, RULE_fact);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(931);
			((FactContext)_localctx).tb = match(ID);
			setState(932);
			match(T__5);
			setState(933);
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
		case 8:
			return justification_sempred((JustificationContext)_localctx, predIndex);
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
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
		case 13:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3x\u03aa\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\7\29\n\2\f\2\16\2<\13\2\3\2\5\2?\n\2\3\2"+
		"\7\2B\n\2\f\2\16\2E\13\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\7"+
		"\5R\n\5\f\5\16\5U\13\5\5\5W\n\5\3\5\3\5\3\5\3\5\7\5]\n\5\f\5\16\5`\13"+
		"\5\3\5\7\5c\n\5\f\5\16\5f\13\5\3\5\3\5\6\5j\n\5\r\5\16\5k\5\5n\n\5\3\6"+
		"\3\6\5\6r\n\6\3\6\6\6u\n\6\r\6\16\6v\3\6\5\6z\n\6\7\6|\n\6\f\6\16\6\177"+
		"\13\6\3\6\3\6\7\6\u0083\n\6\f\6\16\6\u0086\13\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\7\7\u0090\n\7\f\7\16\7\u0093\13\7\3\7\3\7\7\7\u0097\n\7\f\7"+
		"\16\7\u009a\13\7\3\7\3\7\3\7\3\7\5\7\u00a0\n\7\3\7\3\7\3\7\5\7\u00a5\n"+
		"\7\3\7\6\7\u00a8\n\7\r\7\16\7\u00a9\3\7\7\7\u00ad\n\7\f\7\16\7\u00b0\13"+
		"\7\3\7\5\7\u00b3\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00be\n\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00ca\n\b\f\b\16\b\u00cd"+
		"\13\b\3\b\3\b\3\b\3\b\5\b\u00d3\n\b\3\b\3\b\3\b\5\b\u00d8\n\b\3\b\3\b"+
		"\3\b\3\b\5\b\u00de\n\b\3\b\3\b\3\b\3\b\5\b\u00e4\n\b\3\b\3\b\3\b\3\b\5"+
		"\b\u00ea\n\b\3\b\3\b\3\b\3\b\5\b\u00f0\n\b\3\b\3\b\3\b\3\b\5\b\u00f6\n"+
		"\b\3\b\3\b\3\b\3\b\5\b\u00fc\n\b\3\b\7\b\u00ff\n\b\f\b\16\b\u0102\13\b"+
		"\3\t\3\t\6\t\u0106\n\t\r\t\16\t\u0107\3\t\3\t\5\t\u010c\n\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\5\n\u0114\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u011b\n\n\3\n\3\n"+
		"\3\n\3\n\5\n\u0121\n\n\3\n\3\n\3\n\3\n\5\n\u0127\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\n\u012f\n\n\3\n\3\n\3\n\3\n\5\n\u0135\n\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u013c\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u0143\n\n\3\n\3\n\3\n\3\n\3\n\5"+
		"\n\u014a\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0154\n\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u015c\n\n\3\n\3\n\6\n\u0160\n\n\r\n\16\n\u0161\3\n\3"+
		"\n\3\n\6\n\u0167\n\n\r\n\16\n\u0168\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\6\n\u0174\n\n\r\n\16\n\u0175\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u017f"+
		"\n\n\f\n\16\n\u0182\13\n\3\n\3\n\7\n\u0186\n\n\f\n\16\n\u0189\13\n\5\n"+
		"\u018b\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u0198\n\f"+
		"\r\f\16\f\u0199\3\f\3\f\3\f\3\f\3\f\5\f\u01a1\n\f\3\f\5\f\u01a4\n\f\3"+
		"\r\5\r\u01a7\n\r\3\r\6\r\u01aa\n\r\r\r\16\r\u01ab\3\r\5\r\u01af\n\r\7"+
		"\r\u01b1\n\r\f\r\16\r\u01b4\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u01ca"+
		"\n\16\f\16\16\16\u01cd\13\16\3\16\3\16\3\16\3\16\3\16\7\16\u01d4\n\16"+
		"\f\16\16\16\u01d7\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7"+
		"\16\u01e2\n\16\f\16\16\16\u01e5\13\16\3\16\3\16\7\16\u01e9\n\16\f\16\16"+
		"\16\u01ec\13\16\3\16\3\16\3\16\3\16\3\16\5\16\u01f3\n\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u01fd\n\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u0207\n\16\3\16\3\16\3\16\3\16\3\16\7\16\u020e\n\16\f"+
		"\16\16\16\u0211\13\16\5\16\u0213\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0233\n\16\3\16"+
		"\3\16\5\16\u0237\n\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u0246\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u0251\n\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0259\n\20\3"+
		"\20\3\20\3\20\5\20\u025e\n\20\3\20\3\20\3\20\3\20\5\20\u0264\n\20\3\20"+
		"\3\20\3\20\3\20\5\20\u026a\n\20\3\20\3\20\3\20\3\20\5\20\u0270\n\20\3"+
		"\20\3\20\3\20\3\20\5\20\u0276\n\20\3\20\3\20\3\20\3\20\5\20\u027c\n\20"+
		"\3\20\7\20\u027f\n\20\f\20\16\20\u0282\13\20\3\21\3\21\3\21\3\21\7\21"+
		"\u0288\n\21\f\21\16\21\u028b\13\21\3\21\3\21\7\21\u028f\n\21\f\21\16\21"+
		"\u0292\13\21\3\21\3\21\5\21\u0296\n\21\3\22\3\22\7\22\u029a\n\22\f\22"+
		"\16\22\u029d\13\22\3\22\3\22\5\22\u02a1\n\22\3\22\6\22\u02a4\n\22\r\22"+
		"\16\22\u02a5\3\22\5\22\u02a9\n\22\7\22\u02ab\n\22\f\22\16\22\u02ae\13"+
		"\22\3\22\3\22\3\22\7\22\u02b3\n\22\f\22\16\22\u02b6\13\22\3\23\3\23\6"+
		"\23\u02ba\n\23\r\23\16\23\u02bb\3\23\7\23\u02bf\n\23\f\23\16\23\u02c2"+
		"\13\23\3\24\3\24\3\24\5\24\u02c7\n\24\3\24\3\24\3\24\3\24\7\24\u02cd\n"+
		"\24\f\24\16\24\u02d0\13\24\5\24\u02d2\n\24\3\24\3\24\3\24\3\24\5\24\u02d8"+
		"\n\24\3\24\3\24\3\24\7\24\u02dd\n\24\f\24\16\24\u02e0\13\24\3\24\3\24"+
		"\3\24\3\24\7\24\u02e6\n\24\f\24\16\24\u02e9\13\24\3\24\3\24\5\24\u02ed"+
		"\n\24\3\24\3\24\3\24\5\24\u02f2\n\24\3\24\7\24\u02f5\n\24\f\24\16\24\u02f8"+
		"\13\24\3\24\3\24\3\25\3\25\3\25\5\25\u02ff\n\25\3\25\3\25\3\25\3\25\7"+
		"\25\u0305\n\25\f\25\16\25\u0308\13\25\3\25\3\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\7\27\u0314\n\27\f\27\16\27\u0317\13\27\3\27\3\27\7"+
		"\27\u031b\n\27\f\27\16\27\u031e\13\27\3\27\3\27\6\27\u0322\n\27\r\27\16"+
		"\27\u0323\3\27\5\27\u0327\n\27\7\27\u0329\n\27\f\27\16\27\u032c\13\27"+
		"\5\27\u032e\n\27\3\27\7\27\u0331\n\27\f\27\16\27\u0334\13\27\3\27\5\27"+
		"\u0337\n\27\3\27\3\27\7\27\u033b\n\27\f\27\16\27\u033e\13\27\3\27\3\27"+
		"\6\27\u0342\n\27\r\27\16\27\u0343\3\27\5\27\u0347\n\27\7\27\u0349\n\27"+
		"\f\27\16\27\u034c\13\27\5\27\u034e\n\27\3\27\7\27\u0351\n\27\f\27\16\27"+
		"\u0354\13\27\3\27\3\27\3\30\3\30\7\30\u035a\n\30\f\30\16\30\u035d\13\30"+
		"\3\30\3\30\7\30\u0361\n\30\f\30\16\30\u0364\13\30\3\30\5\30\u0367\n\30"+
		"\3\30\6\30\u036a\n\30\r\30\16\30\u036b\3\30\5\30\u036f\n\30\7\30\u0371"+
		"\n\30\f\30\16\30\u0374\13\30\3\30\3\30\7\30\u0378\n\30\f\30\16\30\u037b"+
		"\13\30\3\31\3\31\7\31\u037f\n\31\f\31\16\31\u0382\13\31\3\31\3\31\7\31"+
		"\u0386\n\31\f\31\16\31\u0389\13\31\3\31\5\31\u038c\n\31\3\31\6\31\u038f"+
		"\n\31\r\31\16\31\u0390\3\31\5\31\u0394\n\31\7\31\u0396\n\31\f\31\16\31"+
		"\u0399\13\31\3\31\3\31\7\31\u039d\n\31\f\31\16\31\u03a0\13\31\3\32\3\32"+
		"\5\32\u03a4\n\32\3\33\3\33\3\33\3\33\3\33\2\4\16\36\34\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\37\3\2\4\5\3\2\36!\3\2\n"+
		"\13\3\2\17\21\3\2\22\23\3\2\24\31\3\2\32\35\3\2\"$\3\2%\'\3\2(*\3\2+\62"+
		"\3\2#$\3\2\66\67\3\289\3\2&\'\3\2)*\3\2=>\3\2\37!\3\2IK\3\2LN\3\2pq\3"+
		"\2UV\3\2]^\4\2RRqq\4\2\23\23\37\37\3\2ab\3\2cd\4\2\24\25\27\30\3\2\33"+
		"\34\u044c\2\66\3\2\2\2\4H\3\2\2\2\6K\3\2\2\2\bm\3\2\2\2\no\3\2\2\2\f\u00b2"+
		"\3\2\2\2\16\u00d2\3\2\2\2\20\u0103\3\2\2\2\22\u018a\3\2\2\2\24\u018c\3"+
		"\2\2\2\26\u01a3\3\2\2\2\30\u01a6\3\2\2\2\32\u0236\3\2\2\2\34\u0238\3\2"+
		"\2\2\36\u0258\3\2\2\2 \u0295\3\2\2\2\"\u0297\3\2\2\2$\u02b7\3\2\2\2&\u02c3"+
		"\3\2\2\2(\u02fb\3\2\2\2*\u030d\3\2\2\2,\u0311\3\2\2\2.\u0357\3\2\2\2\60"+
		"\u037c\3\2\2\2\62\u03a3\3\2\2\2\64\u03a5\3\2\2\2\66:\5\b\5\2\679\7t\2"+
		"\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;>\3\2\2\2<:\3\2\2\2=?\5\n"+
		"\6\2>=\3\2\2\2>?\3\2\2\2?C\3\2\2\2@B\7t\2\2A@\3\2\2\2BE\3\2\2\2CA\3\2"+
		"\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FG\7\2\2\3G\3\3\2\2\2HI\5\n\6\2IJ\7"+
		"\2\2\3J\5\3\2\2\2KL\5\26\f\2LM\7\2\2\3M\7\3\2\2\2NS\5\16\b\2OP\7\3\2\2"+
		"PR\5\16\b\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TW\3\2\2\2US\3\2\2"+
		"\2VN\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\t\2\2\2Y^\5\16\b\2Z[\7\3\2\2[]\5\16"+
		"\b\2\\Z\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_n\3\2\2\2`^\3\2\2\2ac\5"+
		"\16\b\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gi"+
		"\7o\2\2hj\5\16\b\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2m"+
		"V\3\2\2\2md\3\2\2\2n\t\3\2\2\2oq\7\6\2\2pr\5\f\7\2qp\3\2\2\2qr\3\2\2\2"+
		"r}\3\2\2\2su\7t\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2"+
		"xz\5\f\7\2yx\3\2\2\2yz\3\2\2\2z|\3\2\2\2{t\3\2\2\2|\177\3\2\2\2}{\3\2"+
		"\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0084\7\7\2\2\u0081\u0083"+
		"\7t\2\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\13\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7p\2\2"+
		"\u0088\u0089\7\b\2\2\u0089\u008a\5\16\b\2\u008a\u008b\5\22\n\2\u008b\u00b3"+
		"\3\2\2\2\u008c\u008d\7p\2\2\u008d\u0091\7\b\2\2\u008e\u0090\7t\2\2\u008f"+
		"\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0098\7\6\2\2\u0095"+
		"\u0097\7t\2\2\u0096\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009c\7p\2\2\u009c\u00a4\7\b\2\2\u009d\u00a5\7q\2\2\u009e\u00a0\7q\2"+
		"\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2"+
		"\5\16\b\2\u00a2\u00a3\7\t\2\2\u00a3\u00a5\3\2\2\2\u00a4\u009d\3\2\2\2"+
		"\u00a4\u009f\3\2\2\2\u00a5\u00ae\3\2\2\2\u00a6\u00a8\7t\2\2\u00a7\u00a6"+
		"\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ad\5\f\7\2\u00ac\u00a7\3\2\2\2\u00ad\u00b0\3\2"+
		"\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b3\7\7\2\2\u00b2\u0087\3\2\2\2\u00b2\u008c\3\2"+
		"\2\2\u00b3\r\3\2\2\2\u00b4\u00b5\b\b\1\2\u00b5\u00b6\7\23\2\2\u00b6\u00d3"+
		"\5\16\b\b\u00b7\u00b8\t\3\2\2\u00b8\u00d3\5\16\b\7\u00b9\u00d3\t\4\2\2"+
		"\u00ba\u00bd\7q\2\2\u00bb\u00bc\7\b\2\2\u00bc\u00be\7q\2\2\u00bd\u00bb"+
		"\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00d3\3\2\2\2\u00bf\u00c0\7\f\2\2\u00c0"+
		"\u00c1\5\16\b\2\u00c1\u00c2\7\r\2\2\u00c2\u00d3\3\2\2\2\u00c3\u00d3\7"+
		"\16\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c6\7\f\2\2\u00c6\u00cb\5\16\b\2\u00c7"+
		"\u00c8\7\3\2\2\u00c8\u00ca\5\16\b\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3"+
		"\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00ce\u00cf\7\r\2\2\u00cf\u00d3\3\2\2\2\u00d0\u00d3\7p"+
		"\2\2\u00d1\u00d3\5\20\t\2\u00d2\u00b4\3\2\2\2\u00d2\u00b7\3\2\2\2\u00d2"+
		"\u00b9\3\2\2\2\u00d2\u00ba\3\2\2\2\u00d2\u00bf\3\2\2\2\u00d2\u00c3\3\2"+
		"\2\2\u00d2\u00c4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3"+
		"\u0100\3\2\2\2\u00d4\u00d5\f\f\2\2\u00d5\u00d7\t\5\2\2\u00d6\u00d8\7t"+
		"\2\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00ff\5\16\b\r\u00da\u00db\f\13\2\2\u00db\u00dd\t\6\2\2\u00dc\u00de\7"+
		"t\2\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00ff\5\16\b\f\u00e0\u00e1\f\n\2\2\u00e1\u00e3\t\7\2\2\u00e2\u00e4\7"+
		"t\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00ff\5\16\b\13\u00e6\u00e7\f\t\2\2\u00e7\u00e9\t\b\2\2\u00e8\u00ea\7"+
		"t\2\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ff\5\16\b\n\u00ec\u00ed\f\6\2\2\u00ed\u00ef\t\t\2\2\u00ee\u00f0\7"+
		"t\2\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"\u00ff\5\16\b\7\u00f2\u00f3\f\5\2\2\u00f3\u00f5\t\n\2\2\u00f4\u00f6\7"+
		"t\2\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\u00ff\5\16\b\6\u00f8\u00f9\f\4\2\2\u00f9\u00fb\t\13\2\2\u00fa\u00fc\7"+
		"t\2\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00ff\5\16\b\5\u00fe\u00d4\3\2\2\2\u00fe\u00da\3\2\2\2\u00fe\u00e0\3"+
		"\2\2\2\u00fe\u00e6\3\2\2\2\u00fe\u00ec\3\2\2\2\u00fe\u00f2\3\2\2\2\u00fe"+
		"\u00f8\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2"+
		"\2\2\u0101\17\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0105\t\f\2\2\u0104\u0106"+
		"\7q\2\2\u0105\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0105\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010b\7\63\2\2\u010a\u010c\7"+
		"t\2\2\u010b\u010a\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u010e\5\16\b\2\u010e\21\3\2\2\2\u010f\u018b\7\64\2\2\u0110\u0114\7\65"+
		"\2\2\u0111\u0112\t\r\2\2\u0112\u0114\7q\2\2\u0113\u0110\3\2\2\2\u0113"+
		"\u0111\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\7p\2\2\u0116\u018b\7p\2"+
		"\2\u0117\u011b\t\16\2\2\u0118\u0119\t\r\2\2\u0119\u011b\7q\2\2\u011a\u0117"+
		"\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u018b\7p\2\2\u011d"+
		"\u0121\t\17\2\2\u011e\u011f\t\20\2\2\u011f\u0121\7q\2\2\u0120\u011d\3"+
		"\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u018b\7p\2\2\u0123"+
		"\u0127\7:\2\2\u0124\u0125\t\20\2\2\u0125\u0127\7q\2\2\u0126\u0123\3\2"+
		"\2\2\u0126\u0124\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\7p\2\2\u0129"+
		"\u012a\7p\2\2\u012a\u018b\7p\2\2\u012b\u012f\7;\2\2\u012c\u012d\t\21\2"+
		"\2\u012d\u012f\7q\2\2\u012e\u012b\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0130"+
		"\3\2\2\2\u0130\u018b\7p\2\2\u0131\u0135\7<\2\2\u0132\u0133\t\21\2\2\u0133"+
		"\u0135\7q\2\2\u0134\u0131\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\3\2"+
		"\2\2\u0136\u0137\7p\2\2\u0137\u018b\7p\2\2\u0138\u013c\t\22\2\2\u0139"+
		"\u013a\t\23\2\2\u013a\u013c\7q\2\2\u013b\u0138\3\2\2\2\u013b\u0139\3\2"+
		"\2\2\u013c\u013d\3\2\2\2\u013d\u018b\7p\2\2\u013e\u0143\7?\2\2\u013f\u0143"+
		"\7@\2\2\u0140\u0141\t\23\2\2\u0141\u0143\7q\2\2\u0142\u013e\3\2\2\2\u0142"+
		"\u013f\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\7p"+
		"\2\2\u0145\u018b\7p\2\2\u0146\u014a\7A\2\2\u0147\u0148\t\4\2\2\u0148\u014a"+
		"\7q\2\2\u0149\u0146\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b\3\2\2\2\u014b"+
		"\u018b\7p\2\2\u014c\u014d\7B\2\2\u014d\u018b\7p\2\2\u014e\u0154\7C\2\2"+
		"\u014f\u0154\7D\2\2\u0150\u0154\7E\2\2\u0151\u0152\7.\2\2\u0152\u0154"+
		"\7q\2\2\u0153\u014e\3\2\2\2\u0153\u014f\3\2\2\2\u0153\u0150\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u018b\7p\2\2\u0156\u015c\7F\2"+
		"\2\u0157\u015c\7G\2\2\u0158\u015c\7H\2\2\u0159\u015a\7.\2\2\u015a\u015c"+
		"\7q\2\2\u015b\u0156\3\2\2\2\u015b\u0157\3\2\2\2\u015b\u0158\3\2\2\2\u015b"+
		"\u0159\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015f\5\24\13\2\u015e\u0160\5"+
		"\16\b\2\u015f\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u015f\3\2\2\2\u0161"+
		"\u0162\3\2\2\2\u0162\u018b\3\2\2\2\u0163\u0164\t\24\2\2\u0164\u0166\7"+
		"p\2\2\u0165\u0167\5\16\b\2\u0166\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168"+
		"\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u018b\3\2\2\2\u016a\u016b\t\25"+
		"\2\2\u016b\u016c\5\24\13\2\u016c\u016d\7p\2\2\u016d\u018b\3\2\2\2\u016e"+
		"\u016f\6\n\t\2\u016f\u0170\7\62\2\2\u0170\u0171\7q\2\2\u0171\u0173\7p"+
		"\2\2\u0172\u0174\5\16\b\2\u0173\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175"+
		"\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u018b\3\2\2\2\u0177\u0178\7\62"+
		"\2\2\u0178\u0179\7q\2\2\u0179\u017a\5\24\13\2\u017a\u017b\7p\2\2\u017b"+
		"\u018b\3\2\2\2\u017c\u0180\7O\2\2\u017d\u017f\7p\2\2\u017e\u017d\3\2\2"+
		"\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u018b"+
		"\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u0187\7P\2\2\u0184\u0186\5\24\13\2"+
		"\u0185\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188"+
		"\3\2\2\2\u0188\u018b\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u010f\3\2\2\2\u018a"+
		"\u0113\3\2\2\2\u018a\u011a\3\2\2\2\u018a\u0120\3\2\2\2\u018a\u0126\3\2"+
		"\2\2\u018a\u012e\3\2\2\2\u018a\u0134\3\2\2\2\u018a\u013b\3\2\2\2\u018a"+
		"\u0142\3\2\2\2\u018a\u0149\3\2\2\2\u018a\u014c\3\2\2\2\u018a\u0153\3\2"+
		"\2\2\u018a\u015b\3\2\2\2\u018a\u0163\3\2\2\2\u018a\u016a\3\2\2\2\u018a"+
		"\u016e\3\2\2\2\u018a\u0177\3\2\2\2\u018a\u017c\3\2\2\2\u018a\u0183\3\2"+
		"\2\2\u018b\23\3\2\2\2\u018c\u018d\t\26\2\2\u018d\25\3\2\2\2\u018e\u018f"+
		"\7Q\2\2\u018f\u0190\7q\2\2\u0190\u0191\7\b\2\2\u0191\u0192\7q\2\2\u0192"+
		"\u0193\7\b\2\2\u0193\u0194\7R\2\2\u0194\u0195\7\b\2\2\u0195\u0197\7S\2"+
		"\2\u0196\u0198\7t\2\2\u0197\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u0197"+
		"\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u01a0\3\2\2\2\u019b\u019c\5\34\17\2"+
		"\u019c\u019d\7T\2\2\u019d\u019e\5\60\31\2\u019e\u019f\7T\2\2\u019f\u01a1"+
		"\3\2\2\2\u01a0\u019b\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2"+
		"\u01a4\5\30\r\2\u01a3\u018e\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\27\3\2\2"+
		"\2\u01a5\u01a7\5\32\16\2\u01a6\u01a5\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7"+
		"\u01b2\3\2\2\2\u01a8\u01aa\7t\2\2\u01a9\u01a8\3\2\2\2\u01aa\u01ab\3\2"+
		"\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01ae\3\2\2\2\u01ad"+
		"\u01af\5\32\16\2\u01ae\u01ad\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b1\3"+
		"\2\2\2\u01b0\u01a9\3\2\2\2\u01b1\u01b4\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b2"+
		"\u01b3\3\2\2\2\u01b3\31\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b5\u01b6\t\27\2"+
		"\2\u01b6\u01b7\7q\2\2\u01b7\u01b8\7W\2\2\u01b8\u01b9\5 \21\2\u01b9\u01ba"+
		"\7\32\2\2\u01ba\u01bb\5\36\20\2\u01bb\u0237\3\2\2\2\u01bc\u01bd\7q\2\2"+
		"\u01bd\u01be\7\32\2\2\u01be\u0237\5\36\20\2\u01bf\u01c0\7X\2\2\u01c0\u01c1"+
		"\7\f\2\2\u01c1\u01c2\5\36\20\2\u01c2\u01c3\7\r\2\2\u01c3\u0237\3\2\2\2"+
		"\u01c4\u01c5\7Y\2\2\u01c5\u01c6\7\f\2\2\u01c6\u01c7\5\36\20\2\u01c7\u01cb"+
		"\7\r\2\2\u01c8\u01ca\7t\2\2\u01c9\u01c8\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb"+
		"\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01ce\3\2\2\2\u01cd\u01cb\3\2"+
		"\2\2\u01ce\u01cf\7\6\2\2\u01cf\u01d0\5\30\r\2\u01d0\u01d1\7\7\2\2\u01d1"+
		"\u01d5\7Z\2\2\u01d2\u01d4\7t\2\2\u01d3\u01d2\3\2\2\2\u01d4\u01d7\3\2\2"+
		"\2\u01d5\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d8\3\2\2\2\u01d7\u01d5"+
		"\3\2\2\2\u01d8\u01d9\7\6\2\2\u01d9\u01da\5\30\r\2\u01da\u01db\7\7\2\2"+
		"\u01db\u0237\3\2\2\2\u01dc\u01dd\7[\2\2\u01dd\u01de\7\f\2\2\u01de\u01df"+
		"\5\36\20\2\u01df\u01e3\7\r\2\2\u01e0\u01e2\7t\2\2\u01e1\u01e0\3\2\2\2"+
		"\u01e2\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e6"+
		"\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01f2\7\6\2\2\u01e7\u01e9\7t\2\2\u01e8"+
		"\u01e7\3\2\2\2\u01e9\u01ec\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2"+
		"\2\2\u01eb\u01ed\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ed\u01ee\5\34\17\2\u01ee"+
		"\u01ef\7T\2\2\u01ef\u01f0\5\"\22\2\u01f0\u01f1\7T\2\2\u01f1\u01f3\3\2"+
		"\2\2\u01f2\u01ea\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4"+
		"\u01f5\5\30\r\2\u01f5\u01f6\7\7\2\2\u01f6\u0237\3\2\2\2\u01f7\u01f8\7"+
		"q\2\2\u01f8\u01f9\7\32\2\2\u01f9\u01fa\7\\\2\2\u01fa\u01fc\7\f\2\2\u01fb"+
		"\u01fd\7r\2\2\u01fc\u01fb\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\3\2"+
		"\2\2\u01fe\u0237\7\r\2\2\u01ff\u0200\t\30\2\2\u0200\u0201\7\f\2\2\u0201"+
		"\u0202\7q\2\2\u0202\u0203\7r\2\2\u0203\u0237\7\r\2\2\u0204\u0205\7q\2"+
		"\2\u0205\u0207\7\32\2\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207"+
		"\u0208\3\2\2\2\u0208\u0209\7q\2\2\u0209\u0212\7\f\2\2\u020a\u020f\5\36"+
		"\20\2\u020b\u020c\7\3\2\2\u020c\u020e\5\36\20\2\u020d\u020b\3\2\2\2\u020e"+
		"\u0211\3\2\2\2\u020f\u020d\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0213\3\2"+
		"\2\2\u0211\u020f\3\2\2\2\u0212\u020a\3\2\2\2\u0212\u0213\3\2\2\2\u0213"+
		"\u0214\3\2\2\2\u0214\u0237\7\r\2\2\u0215\u0216\7q\2\2\u0216\u0217\7\32"+
		"\2\2\u0217\u0218\7q\2\2\u0218\u0219\7\b\2\2\u0219\u0237\7q\2\2\u021a\u021b"+
		"\7q\2\2\u021b\u021c\7\f\2\2\u021c\u021d\5\36\20\2\u021d\u021e\7\r\2\2"+
		"\u021e\u021f\7\32\2\2\u021f\u0220\5\36\20\2\u0220\u0237\3\2\2\2\u0221"+
		"\u0222\7q\2\2\u0222\u0223\7\32\2\2\u0223\u0224\5\36\20\2\u0224\u0225\7"+
		"_\2\2\u0225\u0226\7q\2\2\u0226\u0237\3\2\2\2\u0227\u0228\7q\2\2\u0228"+
		"\u0229\7\32\2\2\u0229\u022a\7q\2\2\u022a\u022b\7`\2\2\u022b\u0237\5\36"+
		"\20\2\u022c\u0237\5&\24\2\u022d\u022e\5\34\17\2\u022e\u0232\7T\2\2\u022f"+
		"\u0233\5\n\6\2\u0230\u0233\5\b\5\2\u0231\u0233\5.\30\2\u0232\u022f\3\2"+
		"\2\2\u0232\u0230\3\2\2\2\u0232\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234"+
		"\u0235\7T\2\2\u0235\u0237\3\2\2\2\u0236\u01b5\3\2\2\2\u0236\u01bc\3\2"+
		"\2\2\u0236\u01bf\3\2\2\2\u0236\u01c4\3\2\2\2\u0236\u01dc\3\2\2\2\u0236"+
		"\u01f7\3\2\2\2\u0236\u01ff\3\2\2\2\u0236\u0206\3\2\2\2\u0236\u0215\3\2"+
		"\2\2\u0236\u021a\3\2\2\2\u0236\u0221\3\2\2\2\u0236\u0227\3\2\2\2\u0236"+
		"\u022c\3\2\2\2\u0236\u022d\3\2\2\2\u0237\33\3\2\2\2\u0238\u0239\t\31\2"+
		"\2\u0239\35\3\2\2\2\u023a\u023b\b\20\1\2\u023b\u023c\t\32\2\2\u023c\u0259"+
		"\5\36\20\t\u023d\u0259\7p\2\2\u023e\u0245\7q\2\2\u023f\u0240\7\f\2\2\u0240"+
		"\u0241\5\36\20\2\u0241\u0242\7\r\2\2\u0242\u0246\3\2\2\2\u0243\u0244\7"+
		"\b\2\2\u0244\u0246\7q\2\2\u0245\u023f\3\2\2\2\u0245\u0243\3\2\2\2\u0245"+
		"\u0246\3\2\2\2\u0246\u0259\3\2\2\2\u0247\u0248\t\33\2\2\u0248\u0249\7"+
		"\f\2\2\u0249\u024a\7r\2\2\u024a\u0259\7\r\2\2\u024b\u024c\t\34\2\2\u024c"+
		"\u024d\7\f\2\2\u024d\u0250\5\36\20\2\u024e\u024f\7\3\2\2\u024f\u0251\5"+
		"\36\20\2\u0250\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0252\3\2\2\2\u0252"+
		"\u0253\7\r\2\2\u0253\u0259\3\2\2\2\u0254\u0255\7\f\2\2\u0255\u0256\5\36"+
		"\20\2\u0256\u0257\7\r\2\2\u0257\u0259\3\2\2\2\u0258\u023a\3\2\2\2\u0258"+
		"\u023d\3\2\2\2\u0258\u023e\3\2\2\2\u0258\u0247\3\2\2\2\u0258\u024b\3\2"+
		"\2\2\u0258\u0254\3\2\2\2\u0259\u0280\3\2\2\2\u025a\u025b\f\b\2\2\u025b"+
		"\u025d\t\5\2\2\u025c\u025e\7t\2\2\u025d\u025c\3\2\2\2\u025d\u025e\3\2"+
		"\2\2\u025e\u025f\3\2\2\2\u025f\u027f\5\36\20\t\u0260\u0261\f\7\2\2\u0261"+
		"\u0263\t\6\2\2\u0262\u0264\7t\2\2\u0263\u0262\3\2\2\2\u0263\u0264\3\2"+
		"\2\2\u0264\u0265\3\2\2\2\u0265\u027f\5\36\20\b\u0266\u0267\f\6\2\2\u0267"+
		"\u0269\t\35\2\2\u0268\u026a\7t\2\2\u0269\u0268\3\2\2\2\u0269\u026a\3\2"+
		"\2\2\u026a\u026b\3\2\2\2\u026b\u027f\5\36\20\7\u026c\u026d\f\5\2\2\u026d"+
		"\u026f\t\36\2\2\u026e\u0270\7t\2\2\u026f\u026e\3\2\2\2\u026f\u0270\3\2"+
		"\2\2\u0270\u0271\3\2\2\2\u0271\u027f\5\36\20\6\u0272\u0273\f\4\2\2\u0273"+
		"\u0275\7#\2\2\u0274\u0276\7t\2\2\u0275\u0274\3\2\2\2\u0275\u0276\3\2\2"+
		"\2\u0276\u0277\3\2\2\2\u0277\u027f\5\36\20\5\u0278\u0279\f\3\2\2\u0279"+
		"\u027b\7&\2\2\u027a\u027c\7t\2\2\u027b\u027a\3\2\2\2\u027b\u027c\3\2\2"+
		"\2\u027c\u027d\3\2\2\2\u027d\u027f\5\36\20\4\u027e\u025a\3\2\2\2\u027e"+
		"\u0260\3\2\2\2\u027e\u0266\3\2\2\2\u027e\u026c\3\2\2\2\u027e\u0272\3\2"+
		"\2\2\u027e\u0278\3\2\2\2\u027f\u0282\3\2\2\2\u0280\u027e\3\2\2\2\u0280"+
		"\u0281\3\2\2\2\u0281\37\3\2\2\2\u0282\u0280\3\2\2\2\u0283\u0296\t\33\2"+
		"\2\u0284\u0285\7c\2\2\u0285\u0289\7e\2\2\u0286\u0288\7t\2\2\u0287\u0286"+
		"\3\2\2\2\u0288\u028b\3\2\2\2\u0289\u0287\3\2\2\2\u0289\u028a\3\2\2\2\u028a"+
		"\u028c\3\2\2\2\u028b\u0289\3\2\2\2\u028c\u0290\t\33\2\2\u028d\u028f\7"+
		"t\2\2\u028e\u028d\3\2\2\2\u028f\u0292\3\2\2\2\u0290\u028e\3\2\2\2\u0290"+
		"\u0291\3\2\2\2\u0291\u0293\3\2\2\2\u0292\u0290\3\2\2\2\u0293\u0296\7f"+
		"\2\2\u0294\u0296\7d\2\2\u0295\u0283\3\2\2\2\u0295\u0284\3\2\2\2\u0295"+
		"\u0294\3\2\2\2\u0296!\3\2\2\2\u0297\u029b\7\6\2\2\u0298\u029a\7t\2\2\u0299"+
		"\u0298\3\2\2\2\u029a\u029d\3\2\2\2\u029b\u0299\3\2\2\2\u029b\u029c\3\2"+
		"\2\2\u029c\u029e\3\2\2\2\u029d\u029b\3\2\2\2\u029e\u02a0\7g\2\2\u029f"+
		"\u02a1\5\16\b\2\u02a0\u029f\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02ac\3"+
		"\2\2\2\u02a2\u02a4\7t\2\2\u02a3\u02a2\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5"+
		"\u02a3\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u02a8\3\2\2\2\u02a7\u02a9\5\16"+
		"\b\2\u02a8\u02a7\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02ab\3\2\2\2\u02aa"+
		"\u02a3\3\2\2\2\u02ab\u02ae\3\2\2\2\u02ac\u02aa\3\2\2\2\u02ac\u02ad\3\2"+
		"\2\2\u02ad\u02af\3\2\2\2\u02ae\u02ac\3\2\2\2\u02af\u02b0\5$\23\2\u02b0"+
		"\u02b4\7\7\2\2\u02b1\u02b3\7t\2\2\u02b2\u02b1\3\2\2\2\u02b3\u02b6\3\2"+
		"\2\2\u02b4\u02b2\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5#\3\2\2\2\u02b6\u02b4"+
		"\3\2\2\2\u02b7\u02b9\7h\2\2\u02b8\u02ba\7q\2\2\u02b9\u02b8\3\2\2\2\u02ba"+
		"\u02bb\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02c0\3\2"+
		"\2\2\u02bd\u02bf\7t\2\2\u02be\u02bd\3\2\2\2\u02bf\u02c2\3\2\2\2\u02c0"+
		"\u02be\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1%\3\2\2\2\u02c2\u02c0\3\2\2\2"+
		"\u02c3\u02c4\7i\2\2\u02c4\u02c6\7q\2\2\u02c5\u02c7\7t\2\2\u02c6\u02c5"+
		"\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02d1\7\f\2\2\u02c9"+
		"\u02ce\5*\26\2\u02ca\u02cb\7\3\2\2\u02cb\u02cd\5*\26\2\u02cc\u02ca\3\2"+
		"\2\2\u02cd\u02d0\3\2\2\2\u02ce\u02cc\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf"+
		"\u02d2\3\2\2\2\u02d0\u02ce\3\2\2\2\u02d1\u02c9\3\2\2\2\u02d1\u02d2\3\2"+
		"\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d4\7\r\2\2\u02d4\u02d7\7W\2\2\u02d5"+
		"\u02d8\5 \21\2\u02d6\u02d8\7j\2\2\u02d7\u02d5\3\2\2\2\u02d7\u02d6\3\2"+
		"\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02da\7\32\2\2\u02da\u02ec\7\6\2\2\u02db"+
		"\u02dd\7t\2\2\u02dc\u02db\3\2\2\2\u02dd\u02e0\3\2\2\2\u02de\u02dc\3\2"+
		"\2\2\u02de\u02df\3\2\2\2\u02df\u02e1\3\2\2\2\u02e0\u02de\3\2\2\2\u02e1"+
		"\u02e2\5\34\17\2\u02e2\u02e3\7T\2\2\u02e3\u02e7\5,\27\2\u02e4\u02e6\7"+
		"t\2\2\u02e5\u02e4\3\2\2\2\u02e6\u02e9\3\2\2\2\u02e7\u02e5\3\2\2\2\u02e7"+
		"\u02e8\3\2\2\2\u02e8\u02ea\3\2\2\2\u02e9\u02e7\3\2\2\2\u02ea\u02eb\7T"+
		"\2\2\u02eb\u02ed\3\2\2\2\u02ec\u02de\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed"+
		"\u02ee\3\2\2\2\u02ee\u02ef\5\30\r\2\u02ef\u02f1\7k\2\2\u02f0\u02f2\5\36"+
		"\20\2\u02f1\u02f0\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2\u02f6\3\2\2\2\u02f3"+
		"\u02f5\7t\2\2\u02f4\u02f3\3\2\2\2\u02f5\u02f8\3\2\2\2\u02f6\u02f4\3\2"+
		"\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f9\3\2\2\2\u02f8\u02f6\3\2\2\2\u02f9"+
		"\u02fa\7\7\2\2\u02fa\'\3\2\2\2\u02fb\u02fc\7i\2\2\u02fc\u02fe\7q\2\2\u02fd"+
		"\u02ff\7t\2\2\u02fe\u02fd\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0300\3\2"+
		"\2\2\u0300\u0301\7\f\2\2\u0301\u0306\5*\26\2\u0302\u0303\7\3\2\2\u0303"+
		"\u0305\5*\26\2\u0304\u0302\3\2\2\2\u0305\u0308\3\2\2\2\u0306\u0304\3\2"+
		"\2\2\u0306\u0307\3\2\2\2\u0307\u0309\3\2\2\2\u0308\u0306\3\2\2\2\u0309"+
		"\u030a\7\r\2\2\u030a\u030b\7W\2\2\u030b\u030c\5 \21\2\u030c)\3\2\2\2\u030d"+
		"\u030e\7q\2\2\u030e\u030f\7W\2\2\u030f\u0310\5 \21\2\u0310+\3\2\2\2\u0311"+
		"\u0315\7\6\2\2\u0312\u0314\7t\2\2\u0313\u0312\3\2\2\2\u0314\u0317\3\2"+
		"\2\2\u0315\u0313\3\2\2\2\u0315\u0316\3\2\2\2\u0316\u032d\3\2\2\2\u0317"+
		"\u0315\3\2\2\2\u0318\u031c\7l\2\2\u0319\u031b\7t\2\2\u031a\u0319\3\2\2"+
		"\2\u031b\u031e\3\2\2\2\u031c\u031a\3\2\2\2\u031c\u031d\3\2\2\2\u031d\u031f"+
		"\3\2\2\2\u031e\u031c\3\2\2\2\u031f\u032a\5\16\b\2\u0320\u0322\7t\2\2\u0321"+
		"\u0320\3\2\2\2\u0322\u0323\3\2\2\2\u0323\u0321\3\2\2\2\u0323\u0324\3\2"+
		"\2\2\u0324\u0326\3\2\2\2\u0325\u0327\5\16\b\2\u0326\u0325\3\2\2\2\u0326"+
		"\u0327\3\2\2\2\u0327\u0329\3\2\2\2\u0328\u0321\3\2\2\2\u0329\u032c\3\2"+
		"\2\2\u032a\u0328\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u032e\3\2\2\2\u032c"+
		"\u032a\3\2\2\2\u032d\u0318\3\2\2\2\u032d\u032e\3\2\2\2\u032e\u0332\3\2"+
		"\2\2\u032f\u0331\7t\2\2\u0330\u032f\3\2\2\2\u0331\u0334\3\2\2\2\u0332"+
		"\u0330\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u0336\3\2\2\2\u0334\u0332\3\2"+
		"\2\2\u0335\u0337\5$\23\2\u0336\u0335\3\2\2\2\u0336\u0337\3\2\2\2\u0337"+
		"\u034d\3\2\2\2\u0338\u033c\7m\2\2\u0339\u033b\7t\2\2\u033a\u0339\3\2\2"+
		"\2\u033b\u033e\3\2\2\2\u033c\u033a\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u033f"+
		"\3\2\2\2\u033e\u033c\3\2\2\2\u033f\u034a\5\16\b\2\u0340\u0342\7t\2\2\u0341"+
		"\u0340\3\2\2\2\u0342\u0343\3\2\2\2\u0343\u0341\3\2\2\2\u0343\u0344\3\2"+
		"\2\2\u0344\u0346\3\2\2\2\u0345\u0347\5\16\b\2\u0346\u0345\3\2\2\2\u0346"+
		"\u0347\3\2\2\2\u0347\u0349\3\2\2\2\u0348\u0341\3\2\2\2\u0349\u034c\3\2"+
		"\2\2\u034a\u0348\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u034e\3\2\2\2\u034c"+
		"\u034a\3\2\2\2\u034d\u0338\3\2\2\2\u034d\u034e\3\2\2\2\u034e\u0352\3\2"+
		"\2\2\u034f\u0351\7t\2\2\u0350\u034f\3\2\2\2\u0351\u0354\3\2\2\2\u0352"+
		"\u0350\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u0355\3\2\2\2\u0354\u0352\3\2"+
		"\2\2\u0355\u0356\7\7\2\2\u0356-\3\2\2\2\u0357\u035b\7\6\2\2\u0358\u035a"+
		"\7t\2\2\u0359\u0358\3\2\2\2\u035a\u035d\3\2\2\2\u035b\u0359\3\2\2\2\u035b"+
		"\u035c\3\2\2\2\u035c\u035e\3\2\2\2\u035d\u035b\3\2\2\2\u035e\u0362\7g"+
		"\2\2\u035f\u0361\7t\2\2\u0360\u035f\3\2\2\2\u0361\u0364\3\2\2\2\u0362"+
		"\u0360\3\2\2\2\u0362\u0363\3\2\2\2\u0363\u0366\3\2\2\2\u0364\u0362\3\2"+
		"\2\2\u0365\u0367\5\16\b\2\u0366\u0365\3\2\2\2\u0366\u0367\3\2\2\2\u0367"+
		"\u0372\3\2\2\2\u0368\u036a\7t\2\2\u0369\u0368\3\2\2\2\u036a\u036b\3\2"+
		"\2\2\u036b\u0369\3\2\2\2\u036b\u036c\3\2\2\2\u036c\u036e\3\2\2\2\u036d"+
		"\u036f\5\16\b\2\u036e\u036d\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0371\3"+
		"\2\2\2\u0370\u0369\3\2\2\2\u0371\u0374\3\2\2\2\u0372\u0370\3\2\2\2\u0372"+
		"\u0373\3\2\2\2\u0373\u0375\3\2\2\2\u0374\u0372\3\2\2\2\u0375\u0379\7\7"+
		"\2\2\u0376\u0378\7t\2\2\u0377\u0376\3\2\2\2\u0378\u037b\3\2\2\2\u0379"+
		"\u0377\3\2\2\2\u0379\u037a\3\2\2\2\u037a/\3\2\2\2\u037b\u0379\3\2\2\2"+
		"\u037c\u0380\7\6\2\2\u037d\u037f\7t\2\2\u037e\u037d\3\2\2\2\u037f\u0382"+
		"\3\2\2\2\u0380\u037e\3\2\2\2\u0380\u0381\3\2\2\2\u0381\u0383\3\2\2\2\u0382"+
		"\u0380\3\2\2\2\u0383\u0387\7n\2\2\u0384\u0386\7t\2\2\u0385\u0384\3\2\2"+
		"\2\u0386\u0389\3\2\2\2\u0387\u0385\3\2\2\2\u0387\u0388\3\2\2\2\u0388\u038b"+
		"\3\2\2\2\u0389\u0387\3\2\2\2\u038a\u038c\5\62\32\2\u038b\u038a\3\2\2\2"+
		"\u038b\u038c\3\2\2\2\u038c\u0397\3\2\2\2\u038d\u038f\7t\2\2\u038e\u038d"+
		"\3\2\2\2\u038f\u0390\3\2\2\2\u0390\u038e\3\2\2\2\u0390\u0391\3\2\2\2\u0391"+
		"\u0393\3\2\2\2\u0392\u0394\5\62\32\2\u0393\u0392\3\2\2\2\u0393\u0394\3"+
		"\2\2\2\u0394\u0396\3\2\2\2\u0395\u038e\3\2\2\2\u0396\u0399\3\2\2\2\u0397"+
		"\u0395\3\2\2\2\u0397\u0398\3\2\2\2\u0398\u039a\3\2\2\2\u0399\u0397\3\2"+
		"\2\2\u039a\u039e\7\7\2\2\u039b\u039d\7t\2\2\u039c\u039b\3\2\2\2\u039d"+
		"\u03a0\3\2\2\2\u039e\u039c\3\2\2\2\u039e\u039f\3\2\2\2\u039f\61\3\2\2"+
		"\2\u03a0\u039e\3\2\2\2\u03a1\u03a4\5\64\33\2\u03a2\u03a4\5(\25\2\u03a3"+
		"\u03a1\3\2\2\2\u03a3\u03a2\3\2\2\2\u03a4\63\3\2\2\2\u03a5\u03a6\7q\2\2"+
		"\u03a6\u03a7\7\b\2\2\u03a7\u03a8\5\20\t\2\u03a8\65\3\2\2\2\u0086:>CSV"+
		"^dkmqvy}\u0084\u0091\u0098\u009f\u00a4\u00a9\u00ae\u00b2\u00bd\u00cb\u00d2"+
		"\u00d7\u00dd\u00e3\u00e9\u00ef\u00f5\u00fb\u00fe\u0100\u0107\u010b\u0113"+
		"\u011a\u0120\u0126\u012e\u0134\u013b\u0142\u0149\u0153\u015b\u0161\u0168"+
		"\u0175\u0180\u0187\u018a\u0199\u01a0\u01a3\u01a6\u01ab\u01ae\u01b2\u01cb"+
		"\u01d5\u01e3\u01ea\u01f2\u01fc\u0206\u020f\u0212\u0232\u0236\u0245\u0250"+
		"\u0258\u025d\u0263\u0269\u026f\u0275\u027b\u027e\u0280\u0289\u0290\u0295"+
		"\u029b\u02a0\u02a5\u02a8\u02ac\u02b4\u02bb\u02c0\u02c6\u02ce\u02d1\u02d7"+
		"\u02de\u02e7\u02ec\u02f1\u02f6\u02fe\u0306\u0315\u031c\u0323\u0326\u032a"+
		"\u032d\u0332\u0336\u033c\u0343\u0346\u034a\u034d\u0352\u035b\u0362\u0366"+
		"\u036b\u036e\u0372\u0379\u0380\u0387\u038b\u0390\u0393\u0397\u039e\u03a3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}