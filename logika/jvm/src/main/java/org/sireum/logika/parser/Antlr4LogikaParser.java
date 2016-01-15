/*
 Copyright (c) 2016, Robby, Kansas State University
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met:

 1. Redistributions of source code must retain the above copyright notice, this
    list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright notice,
    this list of conditions and the following disclaimer in the documentation
    and/or other materials provided with the distribution.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

// Generated from /Users/robby/Repositories/Sireum/sireum-v3/logika/jvm/src/main/resources/org/sireum/logika/parser/Antlr4Logika.g4 by ANTLR 4.5.1
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
		T__119=120, T__120=121, T__121=122, T__122=123, HLINE=124, NUM=125, ID=126, 
		RESERVED=127, NL=128, LINE_COMMENT=129, COMMENT=130, WS=131, STRING=132, 
		ERROR_CHAR=133;
	public static final int
		RULE_file = 0, RULE_sequent = 1, RULE_proof = 2, RULE_proofStep = 3, RULE_formula = 4, 
		RULE_qformula = 5, RULE_type = 6, RULE_justification = 7, RULE_numOrId = 8, 
		RULE_program = 9, RULE_impor = 10, RULE_facts = 11, RULE_factOrFun = 12, 
		RULE_fact = 13, RULE_fun = 14, RULE_param = 15, RULE_stmts = 16, RULE_stmt = 17, 
		RULE_stringOrExp = 18, RULE_exp = 19, RULE_loopInvariant = 20, RULE_modifies = 21, 
		RULE_methodContract = 22, RULE_invariants = 23;
	public static final String[] ruleNames = {
		"file", "sequent", "proof", "proofStep", "formula", "qformula", "type", 
		"justification", "numOrId", "program", "impor", "facts", "factOrFun", 
		"fact", "fun", "param", "stmts", "stmt", "stringOrExp", "exp", "loopInvariant", 
		"modifies", "methodContract", "invariants"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'|-'", "'⊢'", "'{'", "'}'", "'.'", "':'", "'assume'", "'true'", 
		"'T'", "'⊤'", "'false'", "'F'", "'_|_'", "'⊥'", "'('", "')'", "'result'", 
		"'Z'", "'ZS'", "'*'", "'/'", "'%'", "'+'", "'-'", "'+:'", "':+'", "'='", 
		"'=='", "'!='", "'≠'", "'not'", "'neg'", "'!'", "'~'", "'¬'", "'<'", "'<='", 
		"'≤'", "'>'", "'>='", "'≥'", "'and'", "'&'", "'^'", "'∧'", "'or'", "'|'", 
		"'V'", "'∨'", "'implies'", "'->'", "'→'", "'forall'", "'all'", "'A'", 
		"'∀'", "'exists'", "'some'", "'E'", "'∃'", "'..'", "'B'", "'premise'", 
		"'andi'", "'ande1'", "'ande2'", "'ori1'", "'Vi1'", "'ori2'", "'Vi2'", 
		"'ore'", "'Ve'", "'impliesi'", "'impliese'", "'noti'", "'negi'", "'note'", 
		"'nege'", "'bottome'", "'falsee'", "'pbc'", "'subst1'", "'subst2'", "'algebra'", 
		"'foralli'", "'alli'", "'Ai'", "'foralle'", "'alle'", "'Ae'", "'existsi'", 
		"'somei'", "'Ei'", "'existse'", "'somee'", "'Ee'", "'invariant'", "'auto'", 
		"'import'", "'_'", "'fact'", "'def'", "'var'", "'val'", "'assert'", "'if'", 
		"'else'", "'while'", "'l\"\"\"'", "'\"\"\"'", "'print'", "'println'", 
		"'@'", "'Unit'", "'return'", "'randomInt'", "'readInt'", "'modifies'", 
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
		null, null, null, null, "HLINE", "NUM", "ID", "RESERVED", "NL", "LINE_COMMENT", 
		"COMMENT", "WS", "STRING", "ERROR_CHAR"
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
	public static class FileContext extends ParserRuleContext {
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
	 
		public FileContext() { }
		public void copyFrom(FileContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SequentFileContext extends FileContext {
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
		public SequentFileContext(FileContext ctx) { copyFrom(ctx); }
	}
	public static class ProgramFileContext extends FileContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Antlr4LogikaParser.EOF, 0); }
		public ProgramFileContext(FileContext ctx) { copyFrom(ctx); }
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			int _alt;
			setState(69);
			switch (_input.LA(1)) {
			case T__1:
			case T__2:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__17:
			case T__18:
			case T__19:
			case T__24:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
			case HLINE:
			case NUM:
			case ID:
				_localctx = new SequentFileContext(_localctx);
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
				break;
			case EOF:
			case T__99:
			case NL:
				_localctx = new ProgramFileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				program();
				setState(67);
				match(EOF);
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
		enterRule(_localctx, 2, RULE_sequent);
		int _la;
		try {
			setState(102);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
					{
					setState(71);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(72);
						match(T__0);
						setState(73);
						((SequentContext)_localctx).formula = formula(0);
						((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
						}
						}
						setState(78);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(81);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(82);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(83);
					match(T__0);
					setState(84);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
					{
					{
					setState(90);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96);
				match(HLINE);
				setState(98); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(97);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(100); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID );
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
		enterRule(_localctx, 4, RULE_proof);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			((ProofContext)_localctx).tb = match(T__3);
			setState(106);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(105);
				proofStep();
				}
			}

			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(109); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(108);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(111); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(114);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(113);
					proofStep();
					}
				}

				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
			((ProofContext)_localctx).te = match(T__4);
			setState(125);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(122);
					match(NL);
					}
					} 
				}
				setState(127);
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
		enterRule(_localctx, 6, RULE_proofStep);
		int _la;
		try {
			int _alt;
			setState(182);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(NUM);
				setState(129);
				match(T__5);
				setState(130);
				formula(0);
				setState(131);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(134);
				match(T__5);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(135);
					match(NL);
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(141);
				match(T__3);
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(142);
					match(NL);
					}
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(148);
				((SubProofContext)_localctx).assume = match(NUM);
				setState(149);
				match(T__5);
				setState(166);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(150);
					match(ID);
					setState(153);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(151);
						match(T__6);
						setState(152);
						type();
						}
					}

					}
					break;
				case 2:
					{
					setState(155);
					formula(0);
					setState(156);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				case 3:
					{
					setState(158);
					match(ID);
					setState(161);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(159);
						match(T__6);
						setState(160);
						type();
						}
					}

					setState(163);
					formula(0);
					setState(164);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(169); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(168);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(171); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(174);
					_la = _input.LA(1);
					if (_la==NUM) {
						{
						setState(173);
						proofStep();
						}
					}

					}
					}
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(181);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(185);
				((UnaryContext)_localctx).op = match(T__24);
				setState(186);
				formula(9);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(188);
				formula(6);
				}
				break;
			case 3:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189);
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
				setState(190);
				((VarContext)_localctx).tb = match(ID);
				setState(193);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(191);
					match(T__5);
					setState(192);
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
				setState(195);
				match(T__15);
				setState(196);
				formula(0);
				setState(197);
				match(T__16);
				}
				break;
			case 6:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(T__17);
				}
				break;
			case 7:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(ID);
				setState(201);
				match(T__15);
				setState(202);
				formula(0);
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(203);
					match(T__0);
					setState(204);
					formula(0);
					}
					}
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(210);
				match(T__16);
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				match(NUM);
				}
				break;
			case 9:
				{
				_localctx = new BigIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				match(T__18);
				setState(214);
				match(T__15);
				setState(215);
				match(STRING);
				setState(216);
				match(T__16);
				}
				break;
			case 10:
				{
				_localctx = new SeqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				match(T__19);
				setState(218);
				match(T__15);
				setState(227);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)))) != 0)) {
					{
					setState(219);
					exp(0);
					setState(224);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(220);
						match(T__0);
						setState(221);
						exp(0);
						}
						}
						setState(226);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(229);
				match(T__16);
				}
				break;
			case 11:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(283);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(281);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(233);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(234);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(12);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(239);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(240);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(245);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(246);
						((BinaryContext)_localctx).op = match(T__26);
						setState(248);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(247);
							match(NL);
							}
						}

						setState(250);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(251);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(252);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(257);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(258);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(6);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(263);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(264);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(269);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(270);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(272);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(271);
							match(NL);
							}
						}

						setState(274);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(275);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(276);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__50) | (1L << T__51) | (1L << T__52))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(278);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(277);
							match(NL);
							}
						}

						setState(280);
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(285);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
		public Token ll;
		public Token lh;
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
		enterRule(_localctx, 10, RULE_qformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(287);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(288);
				match(T__0);
				setState(289);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(310);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(295);
				match(T__6);
				setState(296);
				type();
				}
				break;
			case 2:
				{
				setState(297);
				match(T__6);
				setState(298);
				match(T__15);
				setState(299);
				((QformulaContext)_localctx).lo = exp(0);
				setState(301);
				_la = _input.LA(1);
				if (_la==T__36) {
					{
					setState(300);
					((QformulaContext)_localctx).ll = match(T__36);
					}
				}

				setState(303);
				match(T__61);
				setState(305);
				_la = _input.LA(1);
				if (_la==T__36) {
					{
					setState(304);
					((QformulaContext)_localctx).lh = match(T__36);
					}
				}

				setState(307);
				((QformulaContext)_localctx).hi = exp(0);
				setState(308);
				match(T__16);
				}
				break;
			}
			setState(313);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(312);
				match(NL);
				}
			}

			setState(315);
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
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(320);
			switch (_input.LA(1)) {
			case T__62:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				((BooleanTypeContext)_localctx).t = match(T__62);
				}
				break;
			case T__18:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
				((IntTypeContext)_localctx).t = match(T__18);
				}
				break;
			case T__19:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(319);
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
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
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
	public static class Subst2Context extends JustificationContext {
		public Token tb;
		public NumOrIdContext eqStep;
		public Token step;
		public NumOrIdContext numOrId() {
			return getRuleContext(NumOrIdContext.class,0);
		}
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public Subst2Context(JustificationContext ctx) { copyFrom(ctx); }
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
	public static class Subst1Context extends JustificationContext {
		public Token tb;
		public NumOrIdContext eqStep;
		public Token step;
		public NumOrIdContext numOrId() {
			return getRuleContext(NumOrIdContext.class,0);
		}
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public Subst1Context(JustificationContext ctx) { copyFrom(ctx); }
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
		enterRule(_localctx, 14, RULE_justification);
		int _la;
		try {
			setState(457);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				((PremiseContext)_localctx).t = match(T__63);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(326);
				switch (_input.LA(1)) {
				case T__64:
					{
					setState(323);
					((AndIntroContext)_localctx).tb = match(T__64);
					}
					break;
				case T__43:
				case T__44:
				case T__45:
					{
					setState(324);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(329);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(333);
				switch (_input.LA(1)) {
				case T__65:
				case T__66:
					{
					setState(330);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__65 || _la==T__66) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__43:
				case T__44:
				case T__45:
					{
					setState(331);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(339);
				switch (_input.LA(1)) {
				case T__67:
				case T__68:
				case T__69:
				case T__70:
					{
					setState(336);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (T__67 - 68)) | (1L << (T__68 - 68)) | (1L << (T__69 - 68)) | (1L << (T__70 - 68)))) != 0)) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__47:
				case T__49:
					{
					setState(337);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__47 || _la==T__49) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(338);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(341);
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(345);
				switch (_input.LA(1)) {
				case T__71:
				case T__72:
					{
					setState(342);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__71 || _la==T__72) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__47:
				case T__49:
					{
					setState(343);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__47 || _la==T__49) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(348);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(349);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(350);
				((ImpliesIntroContext)_localctx).tb = match(T__73);
				setState(351);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(352);
				((ImpliesElimContext)_localctx).tb = match(T__74);
				setState(353);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(354);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(355);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(356);
				((ImpliesIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__51 || _la==T__52) ) {
					((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(357);
				match(ID);
				setState(358);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(359);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				      "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n      \"e\".equals(_input.LT(2).getText())");
				setState(360);
				((ImpliesElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__51 || _la==T__52) ) {
					((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(361);
				match(ID);
				setState(362);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(363);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(364);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__75 || _la==T__76) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(365);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 11:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(366);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__77 || _la==T__78) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(367);
				((NegElimContext)_localctx).step = match(NUM);
				setState(368);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 12:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(369);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(370);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(371);
				match(ID);
				setState(372);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(373);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(374);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(375);
				match(ID);
				setState(376);
				((NegElimContext)_localctx).step = match(NUM);
				setState(377);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 14:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(381);
				switch (_input.LA(1)) {
				case T__79:
				case T__80:
					{
					setState(378);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__79 || _la==T__80) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__13:
				case T__14:
					{
					setState(379);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==T__14) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(380);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(383);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 15:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(384);
				((PbcContext)_localctx).tb = match(T__81);
				setState(385);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 16:
				_localctx = new Subst1Context(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(386);
				((Subst1Context)_localctx).tb = match(T__82);
				setState(387);
				((Subst1Context)_localctx).eqStep = numOrId();
				setState(388);
				((Subst1Context)_localctx).step = match(NUM);
				}
				break;
			case 17:
				_localctx = new Subst2Context(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(390);
				((Subst2Context)_localctx).tb = match(T__83);
				setState(391);
				((Subst2Context)_localctx).eqStep = numOrId();
				setState(392);
				((Subst2Context)_localctx).step = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(394);
				((AlgebraContext)_localctx).tb = match(T__84);
				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(395);
					((AlgebraContext)_localctx).numOrId = numOrId();
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).numOrId);
					}
					}
					setState(400);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(401);
				((ForallIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__87 - 86)))) != 0)) ) {
					((ForallIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(402);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 20:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(403);
				((ForallElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (T__88 - 89)) | (1L << (T__89 - 89)) | (1L << (T__90 - 89)))) != 0)) ) {
					((ForallElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(404);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
				setState(406); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(405);
					formula(0);
					}
					}
					setState(408); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 21:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(410);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(411);
				((ForallIntroContext)_localctx).tb = match(T__56);
				setState(412);
				match(ID);
				setState(413);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 22:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(414);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(415);
				((ForallElimContext)_localctx).tb = match(T__56);
				setState(416);
				match(ID);
				setState(417);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
				setState(419); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(418);
					formula(0);
					}
					}
					setState(421); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 23:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(423);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (T__91 - 92)) | (1L << (T__92 - 92)) | (1L << (T__93 - 92)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(424);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(426); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(425);
					formula(0);
					}
					}
					setState(428); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 24:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(430);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (T__94 - 95)) | (1L << (T__95 - 95)) | (1L << (T__96 - 95)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(431);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(432);
				((ExistsElimContext)_localctx).subproof = match(NUM);
				}
				break;
			case 25:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(434);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(435);
				((ExistsIntroContext)_localctx).tb = match(T__60);
				setState(436);
				match(ID);
				setState(437);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(439); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(438);
					formula(0);
					}
					}
					setState(441); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 26:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(443);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(444);
				((ExistsElimContext)_localctx).tb = match(T__60);
				setState(445);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(446);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(447);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 27:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(449);
				((InvariantContext)_localctx).tb = match(T__97);
				}
				break;
			case 28:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(450);
				((AutoContext)_localctx).tb = match(T__98);
				setState(454);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(451);
					((AutoContext)_localctx).numOrId = numOrId();
					((AutoContext)_localctx).stepOrFacts.add(((AutoContext)_localctx).numOrId);
					}
					}
					setState(456);
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
		enterRule(_localctx, 16, RULE_numOrId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
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
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public ImporContext impor() {
			return getRuleContext(ImporContext.class,0);
		}
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
		enterRule(_localctx, 18, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(461);
				match(NL);
				}
				}
				setState(466);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(475);
			_la = _input.LA(1);
			if (_la==T__99) {
				{
				setState(467);
				impor();
				setState(469); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(468);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(471); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ImporContext extends ParserRuleContext {
		public Token tb;
		public Token org;
		public Token sireum;
		public Token logika;
		public Token te;
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public ImporContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impor; }
	}

	public final ImporContext impor() throws RecognitionException {
		ImporContext _localctx = new ImporContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_impor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			((ImporContext)_localctx).tb = match(T__99);
			setState(478);
			((ImporContext)_localctx).org = match(ID);
			setState(479);
			match(T__5);
			setState(480);
			((ImporContext)_localctx).sireum = match(ID);
			setState(481);
			match(T__5);
			setState(482);
			((ImporContext)_localctx).logika = match(ID);
			setState(483);
			match(T__5);
			setState(484);
			((ImporContext)_localctx).te = match(T__100);
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
		enterRule(_localctx, 22, RULE_facts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			match(T__3);
			setState(490);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(487);
				match(NL);
				}
				}
				setState(492);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(493);
			((FactsContext)_localctx).ftb = match(T__101);
			setState(497);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(494);
					match(NL);
					}
					} 
				}
				setState(499);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			}
			setState(501);
			_la = _input.LA(1);
			if (_la==T__102 || _la==ID) {
				{
				setState(500);
				factOrFun();
				}
			}

			setState(513);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(504); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(503);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(506); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(509);
				_la = _input.LA(1);
				if (_la==T__102 || _la==ID) {
					{
					setState(508);
					factOrFun();
					}
				}

				}
				}
				setState(515);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(516);
			((FactsContext)_localctx).te = match(T__4);
			setState(520);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(517);
				match(NL);
				}
				}
				setState(522);
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
		enterRule(_localctx, 24, RULE_factOrFun);
		try {
			setState(525);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(523);
				fact();
				}
				break;
			case T__102:
				enterOuterAlt(_localctx, 2);
				{
				setState(524);
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
		enterRule(_localctx, 26, RULE_fact);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			match(ID);
			setState(528);
			match(T__5);
			setState(529);
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
		enterRule(_localctx, 28, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			((FunContext)_localctx).tb = match(T__102);
			setState(532);
			match(ID);
			setState(534);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(533);
				match(NL);
				}
			}

			setState(536);
			match(T__15);
			setState(537);
			param();
			setState(542);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(538);
				match(T__0);
				setState(539);
				param();
				}
				}
				setState(544);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(545);
			match(T__16);
			setState(546);
			match(T__6);
			setState(547);
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
		enterRule(_localctx, 30, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			match(ID);
			setState(550);
			match(T__6);
			setState(551);
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
		enterRule(_localctx, 32, RULE_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (T__99 - 100)) | (1L << (T__102 - 100)) | (1L << (T__103 - 100)) | (1L << (T__104 - 100)) | (1L << (T__105 - 100)) | (1L << (T__106 - 100)) | (1L << (T__108 - 100)) | (1L << (T__109 - 100)) | (1L << (T__111 - 100)) | (1L << (T__112 - 100)) | (1L << (T__113 - 100)) | (1L << (T__116 - 100)) | (1L << (T__117 - 100)) | (1L << (NUM - 100)) | (1L << (ID - 100)))) != 0)) {
				{
				setState(553);
				stmt();
				}
			}

			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(557); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(556);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(559); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(562);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (T__99 - 100)) | (1L << (T__102 - 100)) | (1L << (T__103 - 100)) | (1L << (T__104 - 100)) | (1L << (T__105 - 100)) | (1L << (T__106 - 100)) | (1L << (T__108 - 100)) | (1L << (T__109 - 100)) | (1L << (T__111 - 100)) | (1L << (T__112 - 100)) | (1L << (T__113 - 100)) | (1L << (T__116 - 100)) | (1L << (T__117 - 100)) | (1L << (NUM - 100)) | (1L << (ID - 100)))) != 0)) {
					{
					setState(561);
					stmt();
					}
				}

				}
				}
				setState(568);
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
		public List<StringOrExpContext> stringOrExp() {
			return getRuleContexts(StringOrExpContext.class);
		}
		public StringOrExpContext stringOrExp(int i) {
			return getRuleContext(StringOrExpContext.class,i);
		}
		public PrintStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class MethodDeclStmtContext extends StmtContext {
		public Token helper;
		public Token id;
		public Token rtb;
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
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
	public static class ImportStmtContext extends StmtContext {
		public ImporContext impor() {
			return getRuleContext(ImporContext.class,0);
		}
		public ImportStmtContext(StmtContext ctx) { copyFrom(ctx); }
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
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public VarDeclStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssertStmtContext extends StmtContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssertStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssumeStmtContext extends StmtContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssumeStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_stmt);
		int _la;
		try {
			setState(748);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(569);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__103 || _la==T__104) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(570);
				match(ID);
				setState(571);
				match(T__6);
				setState(572);
				type();
				setState(573);
				match(T__27);
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
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(579);
				match(ID);
				setState(580);
				match(T__27);
				setState(582);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(581);
					match(NL);
					}
				}

				setState(584);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssumeStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(585);
				match(T__7);
				setState(586);
				match(T__15);
				setState(587);
				exp(0);
				setState(588);
				match(T__16);
				}
				break;
			case 4:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(590);
				match(T__105);
				setState(591);
				match(T__15);
				setState(592);
				exp(0);
				setState(593);
				match(T__16);
				}
				break;
			case 5:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(595);
				match(T__106);
				setState(596);
				match(T__15);
				setState(597);
				exp(0);
				setState(598);
				match(T__16);
				setState(602);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(599);
					match(NL);
					}
					}
					setState(604);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(605);
				match(T__3);
				setState(606);
				((IfStmtContext)_localctx).ts = stmts();
				setState(607);
				match(T__4);
				setState(619);
				_la = _input.LA(1);
				if (_la==T__107) {
					{
					setState(608);
					match(T__107);
					setState(612);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(609);
						match(NL);
						}
						}
						setState(614);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(615);
					match(T__3);
					setState(616);
					((IfStmtContext)_localctx).fs = stmts();
					setState(617);
					match(T__4);
					}
				}

				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(621);
				match(T__108);
				setState(622);
				match(T__15);
				setState(623);
				exp(0);
				setState(624);
				match(T__16);
				setState(628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(625);
					match(NL);
					}
					}
					setState(630);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(631);
				match(T__3);
				setState(642);
				switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
				case 1:
					{
					setState(635);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(632);
						match(NL);
						}
						}
						setState(637);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(638);
					match(T__109);
					setState(639);
					loopInvariant();
					setState(640);
					match(T__110);
					}
					break;
				}
				setState(644);
				stmts();
				setState(645);
				match(T__4);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(647);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__111 || _la==T__112) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(648);
				match(T__15);
				setState(657);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)) | (1L << (STRING - 117)))) != 0)) {
					{
					setState(649);
					stringOrExp();
					setState(654);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(650);
						match(T__0);
						setState(651);
						stringOrExp();
						}
						}
						setState(656);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(659);
				match(T__16);
				}
				break;
			case 8:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(660);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(661);
				match(T__15);
				setState(662);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(663);
				match(T__16);
				setState(664);
				match(T__27);
				setState(666);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(665);
					match(NL);
					}
				}

				setState(668);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 9:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(672);
				_la = _input.LA(1);
				if (_la==T__113) {
					{
					setState(670);
					match(T__113);
					setState(671);
					((MethodDeclStmtContext)_localctx).helper = match(ID);
					}
				}

				setState(674);
				match(T__102);
				setState(675);
				((MethodDeclStmtContext)_localctx).id = match(ID);
				setState(677);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(676);
					match(NL);
					}
				}

				setState(679);
				match(T__15);
				setState(688);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(680);
					param();
					setState(685);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(681);
						match(T__0);
						setState(682);
						param();
						}
						}
						setState(687);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(690);
				match(T__16);
				setState(691);
				match(T__6);
				setState(694);
				switch (_input.LA(1)) {
				case T__18:
				case T__19:
				case T__62:
					{
					setState(692);
					type();
					}
					break;
				case T__114:
					{
					setState(693);
					match(T__114);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(696);
				match(T__27);
				setState(700);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(697);
					match(NL);
					}
					}
					setState(702);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(703);
				match(T__3);
				setState(720);
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
				case 1:
					{
					setState(707);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(704);
						match(NL);
						}
						}
						setState(709);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(710);
					match(T__109);
					setState(711);
					methodContract();
					setState(715);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(712);
						match(NL);
						}
						}
						setState(717);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(718);
					match(T__110);
					}
					break;
				}
				setState(722);
				stmts();
				setState(733);
				_la = _input.LA(1);
				if (_la==T__115) {
					{
					setState(723);
					((MethodDeclStmtContext)_localctx).rtb = match(T__115);
					setState(725);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)))) != 0)) {
						{
						setState(724);
						exp(0);
						}
					}

					setState(730);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(727);
						match(NL);
						}
						}
						setState(732);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(735);
				match(T__4);
				}
				break;
			case 10:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(737);
				match(T__109);
				setState(742);
				switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
				case 1:
					{
					setState(738);
					proof();
					}
					break;
				case 2:
					{
					setState(739);
					sequent();
					}
					break;
				case 3:
					{
					setState(740);
					invariants();
					}
					break;
				case 4:
					{
					setState(741);
					facts();
					}
					break;
				}
				setState(744);
				match(T__110);
				}
				break;
			case 11:
				_localctx = new ImportStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(746);
				impor();
				}
				break;
			case 12:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(747);
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

	public static class StringOrExpContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StringOrExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringOrExp; }
	}

	public final StringOrExpContext stringOrExp() throws RecognitionException {
		StringOrExpContext _localctx = new StringOrExpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stringOrExp);
		try {
			setState(752);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(750);
				match(STRING);
				}
				break;
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__18:
			case T__19:
			case T__24:
			case T__33:
			case T__116:
			case T__117:
			case NUM:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(751);
				exp(0);
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
		public Token t;
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
	public static class RandomIntExpContext extends ExpContext {
		public RandomIntExpContext(ExpContext ctx) { copyFrom(ctx); }
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
			setState(806);
			switch (_input.LA(1)) {
			case T__24:
			case T__33:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(755);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__33) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(756);
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
				setState(757);
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
				setState(758);
				match(NUM);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(759);
				((IdExpContext)_localctx).tb = match(ID);
				setState(774);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(760);
					((IdExpContext)_localctx).t = match(T__15);
					setState(769);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)))) != 0)) {
						{
						setState(761);
						exp(0);
						setState(766);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__0) {
							{
							{
							setState(762);
							match(T__0);
							setState(763);
							exp(0);
							}
							}
							setState(768);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(771);
					match(T__16);
					}
					break;
				case 2:
					{
					setState(772);
					match(T__5);
					setState(773);
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
				setState(776);
				match(T__18);
				setState(777);
				match(T__15);
				setState(778);
				match(STRING);
				setState(779);
				match(T__16);
				}
				break;
			case T__19:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(780);
				match(T__19);
				setState(781);
				match(T__15);
				setState(790);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)))) != 0)) {
					{
					setState(782);
					exp(0);
					setState(787);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(783);
						match(T__0);
						setState(784);
						exp(0);
						}
						}
						setState(789);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(792);
				match(T__16);
				}
				break;
			case T__116:
				{
				_localctx = new RandomIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(793);
				match(T__116);
				setState(794);
				match(T__15);
				setState(795);
				match(T__16);
				}
				break;
			case T__117:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(796);
				match(T__117);
				setState(797);
				match(T__15);
				setState(799);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(798);
					match(STRING);
					}
				}

				setState(801);
				match(T__16);
				}
				break;
			case T__15:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(802);
				match(T__15);
				setState(803);
				exp(0);
				setState(804);
				match(T__16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(852);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(850);
					switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(808);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(809);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(811);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(810);
							match(NL);
							}
						}

						setState(813);
						((BinaryExpContext)_localctx).r = exp(8);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(814);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(815);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(817);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(816);
							match(NL);
							}
						}

						setState(819);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(820);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(821);
						((BinaryExpContext)_localctx).op = match(T__26);
						setState(823);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(822);
							match(NL);
							}
						}

						setState(825);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(826);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(827);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(829);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(828);
							match(NL);
							}
						}

						setState(831);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(832);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(833);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(835);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(834);
							match(NL);
							}
						}

						setState(837);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(838);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(839);
						((BinaryExpContext)_localctx).op = match(T__43);
						setState(841);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(840);
							match(NL);
							}
						}

						setState(843);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(844);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(845);
						((BinaryExpContext)_localctx).op = match(T__47);
						setState(847);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(846);
							match(NL);
							}
						}

						setState(849);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(854);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
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
			setState(855);
			((LoopInvariantContext)_localctx).tb = match(T__3);
			setState(859);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(856);
				match(NL);
				}
				}
				setState(861);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(862);
			((LoopInvariantContext)_localctx).itb = match(T__97);
			setState(866);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(863);
					match(NL);
					}
					} 
				}
				setState(868);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
			}
			setState(870);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
				{
				setState(869);
				formula(0);
				}
			}

			setState(882);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(873); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(872);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(875); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(878);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
					{
					setState(877);
					formula(0);
					}
				}

				}
				}
				setState(884);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(885);
			modifies();
			setState(886);
			((LoopInvariantContext)_localctx).te = match(T__4);
			setState(890);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(887);
				match(NL);
				}
				}
				setState(892);
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
			setState(893);
			((ModifiesContext)_localctx).tb = match(T__118);
			setState(902);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(894);
				match(ID);
				setState(899);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(895);
					match(T__0);
					setState(896);
					match(ID);
					}
					}
					setState(901);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(907);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(904);
					match(NL);
					}
					} 
				}
				setState(909);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
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
			setState(910);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(914);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(911);
					match(NL);
					}
					} 
				}
				setState(916);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			}
			setState(938);
			_la = _input.LA(1);
			if (_la==T__119 || _la==T__120) {
				{
				setState(917);
				_la = _input.LA(1);
				if ( !(_la==T__119 || _la==T__120) ) {
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
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(935);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
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
							_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(931);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
							{
							setState(930);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(937);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
				}
				}
			}

			setState(943);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(940);
					match(NL);
					}
					} 
				}
				setState(945);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			}
			setState(947);
			_la = _input.LA(1);
			if (_la==T__118) {
				{
				setState(946);
				modifies();
				}
			}

			setState(970);
			_la = _input.LA(1);
			if (_la==T__121 || _la==T__122) {
				{
				setState(949);
				_la = _input.LA(1);
				if ( !(_la==T__121 || _la==T__122) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(953);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(950);
					match(NL);
					}
					}
					setState(955);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(956);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(967);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(958); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(957);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(960); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(963);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
							{
							setState(962);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(969);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
				}
				}
			}

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
			setState(978);
			((MethodContractContext)_localctx).te = match(T__4);
			setState(982);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(979);
					match(NL);
					}
					} 
				}
				setState(984);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
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
			setState(985);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(989);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(986);
				match(NL);
				}
				}
				setState(991);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(992);
			match(T__97);
			setState(996);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(993);
					match(NL);
					}
					} 
				}
				setState(998);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
			}
			setState(1000);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
				{
				setState(999);
				formula(0);
				}
			}

			setState(1012);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1003); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1002);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1005); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1008);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
					{
					setState(1007);
					formula(0);
					}
				}

				}
				}
				setState(1014);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1015);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(1019);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1016);
				match(NL);
				}
				}
				setState(1021);
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
		case 4:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 7:
			return justification_sempred((JustificationContext)_localctx, predIndex);
		case 19:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean justification_sempred(JustificationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return ("->".equals(_input.LT(1).getText()) ||
		      "→".equals(_input.LT(1).getText())) &&
		     "i".equals(_input.LT(2).getText());
		case 9:
			return ("->".equals(_input.LT(1).getText()) ||
		      "→".equals(_input.LT(1).getText())) &&
		      "e".equals(_input.LT(2).getText());
		case 10:
			return ("!".equals(_input.LT(1).getText()) ||
		      "~".equals(_input.LT(1).getText()) ||
		      "¬".equals(_input.LT(1).getText())) &&
		     "i".equals(_input.LT(2).getText());
		case 11:
			return ("!".equals(_input.LT(1).getText()) ||
		      "~".equals(_input.LT(1).getText()) ||
		      "¬".equals(_input.LT(1).getText())) &&
		     "e".equals(_input.LT(2).getText());
		case 12:
			return "∀".equals(_input.LT(1).getText()) &&
		     "i".equals(_input.LT(2).getText());
		case 13:
			return "∀".equals(_input.LT(1).getText()) &&
		     "e".equals(_input.LT(2).getText());
		case 14:
			return "∃".equals(_input.LT(1).getText()) &&
		     "i".equals(_input.LT(2).getText());
		case 15:
			return "∃".equals(_input.LT(1).getText()) &&
		     "e".equals(_input.LT(2).getText());
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16:
			return precpred(_ctx, 7);
		case 17:
			return precpred(_ctx, 6);
		case 18:
			return precpred(_ctx, 5);
		case 19:
			return precpred(_ctx, 4);
		case 20:
			return precpred(_ctx, 3);
		case 21:
			return precpred(_ctx, 2);
		case 22:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0087\u0401\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\7\2\65\n\2\f\2\16\28\13\2\3\2\5\2;\n\2\3\2\7\2>\n\2\f\2\16\2"+
		"A\13\2\3\2\3\2\3\2\3\2\3\2\5\2H\n\2\3\3\3\3\3\3\7\3M\n\3\f\3\16\3P\13"+
		"\3\5\3R\n\3\3\3\3\3\3\3\3\3\7\3X\n\3\f\3\16\3[\13\3\3\3\7\3^\n\3\f\3\16"+
		"\3a\13\3\3\3\3\3\6\3e\n\3\r\3\16\3f\5\3i\n\3\3\4\3\4\5\4m\n\4\3\4\6\4"+
		"p\n\4\r\4\16\4q\3\4\5\4u\n\4\7\4w\n\4\f\4\16\4z\13\4\3\4\3\4\7\4~\n\4"+
		"\f\4\16\4\u0081\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u008b\n\5\f\5"+
		"\16\5\u008e\13\5\3\5\3\5\7\5\u0092\n\5\f\5\16\5\u0095\13\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\5\u009c\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00a4\n\5\3\5\3\5\3"+
		"\5\5\5\u00a9\n\5\3\5\6\5\u00ac\n\5\r\5\16\5\u00ad\3\5\5\5\u00b1\n\5\7"+
		"\5\u00b3\n\5\f\5\16\5\u00b6\13\5\3\5\5\5\u00b9\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6\u00c4\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\7\6\u00d0\n\6\f\6\16\6\u00d3\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\7\6\u00e1\n\6\f\6\16\6\u00e4\13\6\5\6\u00e6\n\6\3\6\3\6\5"+
		"\6\u00ea\n\6\3\6\3\6\3\6\5\6\u00ef\n\6\3\6\3\6\3\6\3\6\5\6\u00f5\n\6\3"+
		"\6\3\6\3\6\3\6\5\6\u00fb\n\6\3\6\3\6\3\6\3\6\5\6\u0101\n\6\3\6\3\6\3\6"+
		"\3\6\5\6\u0107\n\6\3\6\3\6\3\6\3\6\5\6\u010d\n\6\3\6\3\6\3\6\3\6\5\6\u0113"+
		"\n\6\3\6\3\6\3\6\3\6\5\6\u0119\n\6\3\6\7\6\u011c\n\6\f\6\16\6\u011f\13"+
		"\6\3\7\3\7\3\7\3\7\7\7\u0125\n\7\f\7\16\7\u0128\13\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u0130\n\7\3\7\3\7\5\7\u0134\n\7\3\7\3\7\3\7\5\7\u0139\n\7\3"+
		"\7\5\7\u013c\n\7\3\7\3\7\3\b\3\b\3\b\5\b\u0143\n\b\3\t\3\t\3\t\3\t\5\t"+
		"\u0149\n\t\3\t\3\t\3\t\3\t\3\t\5\t\u0150\n\t\3\t\3\t\3\t\3\t\5\t\u0156"+
		"\n\t\3\t\3\t\3\t\3\t\5\t\u015c\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0180\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u018f\n\t\f\t\16\t\u0192\13\t\3\t\3\t\3"+
		"\t\3\t\3\t\6\t\u0199\n\t\r\t\16\t\u019a\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\6\t\u01a6\n\t\r\t\16\t\u01a7\3\t\3\t\3\t\6\t\u01ad\n\t\r\t\16\t"+
		"\u01ae\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\t\u01ba\n\t\r\t\16\t\u01bb"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u01c7\n\t\f\t\16\t\u01ca\13\t"+
		"\5\t\u01cc\n\t\3\n\3\n\3\13\7\13\u01d1\n\13\f\13\16\13\u01d4\13\13\3\13"+
		"\3\13\6\13\u01d8\n\13\r\13\16\13\u01d9\3\13\3\13\5\13\u01de\n\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\7\r\u01eb\n\r\f\r\16\r\u01ee\13"+
		"\r\3\r\3\r\7\r\u01f2\n\r\f\r\16\r\u01f5\13\r\3\r\5\r\u01f8\n\r\3\r\6\r"+
		"\u01fb\n\r\r\r\16\r\u01fc\3\r\5\r\u0200\n\r\7\r\u0202\n\r\f\r\16\r\u0205"+
		"\13\r\3\r\3\r\7\r\u0209\n\r\f\r\16\r\u020c\13\r\3\16\3\16\5\16\u0210\n"+
		"\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u0219\n\20\3\20\3\20\3\20"+
		"\3\20\7\20\u021f\n\20\f\20\16\20\u0222\13\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\22\5\22\u022d\n\22\3\22\6\22\u0230\n\22\r\22\16\22\u0231"+
		"\3\22\5\22\u0235\n\22\7\22\u0237\n\22\f\22\16\22\u023a\13\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u0242\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u0249"+
		"\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\7\23\u025b\n\23\f\23\16\23\u025e\13\23\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u0265\n\23\f\23\16\23\u0268\13\23\3\23\3\23\3\23\3\23"+
		"\5\23\u026e\n\23\3\23\3\23\3\23\3\23\3\23\7\23\u0275\n\23\f\23\16\23\u0278"+
		"\13\23\3\23\3\23\7\23\u027c\n\23\f\23\16\23\u027f\13\23\3\23\3\23\3\23"+
		"\3\23\5\23\u0285\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u028f"+
		"\n\23\f\23\16\23\u0292\13\23\5\23\u0294\n\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u029d\n\23\3\23\3\23\3\23\3\23\5\23\u02a3\n\23\3\23\3"+
		"\23\3\23\5\23\u02a8\n\23\3\23\3\23\3\23\3\23\7\23\u02ae\n\23\f\23\16\23"+
		"\u02b1\13\23\5\23\u02b3\n\23\3\23\3\23\3\23\3\23\5\23\u02b9\n\23\3\23"+
		"\3\23\7\23\u02bd\n\23\f\23\16\23\u02c0\13\23\3\23\3\23\7\23\u02c4\n\23"+
		"\f\23\16\23\u02c7\13\23\3\23\3\23\3\23\7\23\u02cc\n\23\f\23\16\23\u02cf"+
		"\13\23\3\23\3\23\5\23\u02d3\n\23\3\23\3\23\3\23\5\23\u02d8\n\23\3\23\7"+
		"\23\u02db\n\23\f\23\16\23\u02de\13\23\5\23\u02e0\n\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u02e9\n\23\3\23\3\23\3\23\3\23\5\23\u02ef\n\23"+
		"\3\24\3\24\5\24\u02f3\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\7\25\u02ff\n\25\f\25\16\25\u0302\13\25\5\25\u0304\n\25\3\25\3\25"+
		"\3\25\5\25\u0309\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25"+
		"\u0314\n\25\f\25\16\25\u0317\13\25\5\25\u0319\n\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u0322\n\25\3\25\3\25\3\25\3\25\3\25\5\25\u0329\n"+
		"\25\3\25\3\25\3\25\5\25\u032e\n\25\3\25\3\25\3\25\3\25\5\25\u0334\n\25"+
		"\3\25\3\25\3\25\3\25\5\25\u033a\n\25\3\25\3\25\3\25\3\25\5\25\u0340\n"+
		"\25\3\25\3\25\3\25\3\25\5\25\u0346\n\25\3\25\3\25\3\25\3\25\5\25\u034c"+
		"\n\25\3\25\3\25\3\25\3\25\5\25\u0352\n\25\3\25\7\25\u0355\n\25\f\25\16"+
		"\25\u0358\13\25\3\26\3\26\7\26\u035c\n\26\f\26\16\26\u035f\13\26\3\26"+
		"\3\26\7\26\u0363\n\26\f\26\16\26\u0366\13\26\3\26\5\26\u0369\n\26\3\26"+
		"\6\26\u036c\n\26\r\26\16\26\u036d\3\26\5\26\u0371\n\26\7\26\u0373\n\26"+
		"\f\26\16\26\u0376\13\26\3\26\3\26\3\26\7\26\u037b\n\26\f\26\16\26\u037e"+
		"\13\26\3\27\3\27\3\27\3\27\7\27\u0384\n\27\f\27\16\27\u0387\13\27\5\27"+
		"\u0389\n\27\3\27\7\27\u038c\n\27\f\27\16\27\u038f\13\27\3\30\3\30\7\30"+
		"\u0393\n\30\f\30\16\30\u0396\13\30\3\30\3\30\7\30\u039a\n\30\f\30\16\30"+
		"\u039d\13\30\3\30\3\30\6\30\u03a1\n\30\r\30\16\30\u03a2\3\30\5\30\u03a6"+
		"\n\30\7\30\u03a8\n\30\f\30\16\30\u03ab\13\30\5\30\u03ad\n\30\3\30\7\30"+
		"\u03b0\n\30\f\30\16\30\u03b3\13\30\3\30\5\30\u03b6\n\30\3\30\3\30\7\30"+
		"\u03ba\n\30\f\30\16\30\u03bd\13\30\3\30\3\30\6\30\u03c1\n\30\r\30\16\30"+
		"\u03c2\3\30\5\30\u03c6\n\30\7\30\u03c8\n\30\f\30\16\30\u03cb\13\30\5\30"+
		"\u03cd\n\30\3\30\7\30\u03d0\n\30\f\30\16\30\u03d3\13\30\3\30\3\30\7\30"+
		"\u03d7\n\30\f\30\16\30\u03da\13\30\3\31\3\31\7\31\u03de\n\31\f\31\16\31"+
		"\u03e1\13\31\3\31\3\31\7\31\u03e5\n\31\f\31\16\31\u03e8\13\31\3\31\5\31"+
		"\u03eb\n\31\3\31\6\31\u03ee\n\31\r\31\16\31\u03ef\3\31\5\31\u03f3\n\31"+
		"\7\31\u03f5\n\31\f\31\16\31\u03f8\13\31\3\31\3\31\7\31\u03fc\n\31\f\31"+
		"\16\31\u03ff\13\31\3\31\2\4\n(\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\2$\3\2\4\5\3\2\"&\3\2\13\21\3\2\27\31\3\2\32\34\3\2\36"+
		"!\3\2\',\3\2-\60\3\2\61\64\3\2\65\67\3\28?\3\2.\60\3\2DE\3\2FI\4\2\62"+
		"\62\64\64\3\2JK\3\2\66\67\3\2NO\3\2PQ\3\2$&\3\2RS\3\2\20\21\3\2XZ\3\2"+
		"[]\3\2^`\3\2ac\3\2\177\u0080\3\2jk\3\2rs\4\2\33\33$$\4\2\'(*+\3\2\37 "+
		"\3\2z{\3\2|}\u04c1\2G\3\2\2\2\4h\3\2\2\2\6j\3\2\2\2\b\u00b8\3\2\2\2\n"+
		"\u00e9\3\2\2\2\f\u0120\3\2\2\2\16\u0142\3\2\2\2\20\u01cb\3\2\2\2\22\u01cd"+
		"\3\2\2\2\24\u01d2\3\2\2\2\26\u01df\3\2\2\2\30\u01e8\3\2\2\2\32\u020f\3"+
		"\2\2\2\34\u0211\3\2\2\2\36\u0215\3\2\2\2 \u0227\3\2\2\2\"\u022c\3\2\2"+
		"\2$\u02ee\3\2\2\2&\u02f2\3\2\2\2(\u0328\3\2\2\2*\u0359\3\2\2\2,\u037f"+
		"\3\2\2\2.\u0390\3\2\2\2\60\u03db\3\2\2\2\62\66\5\4\3\2\63\65\7\u0082\2"+
		"\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67:\3\2\2\28"+
		"\66\3\2\2\29;\5\6\4\2:9\3\2\2\2:;\3\2\2\2;?\3\2\2\2<>\7\u0082\2\2=<\3"+
		"\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\7\2\2\3CH\3"+
		"\2\2\2DE\5\24\13\2EF\7\2\2\3FH\3\2\2\2G\62\3\2\2\2GD\3\2\2\2H\3\3\2\2"+
		"\2IN\5\n\6\2JK\7\3\2\2KM\5\n\6\2LJ\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2"+
		"\2OR\3\2\2\2PN\3\2\2\2QI\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\t\2\2\2TY\5\n\6"+
		"\2UV\7\3\2\2VX\5\n\6\2WU\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Zi\3\2\2"+
		"\2[Y\3\2\2\2\\^\5\n\6\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2"+
		"\2\2a_\3\2\2\2bd\7~\2\2ce\5\n\6\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2"+
		"\2\2gi\3\2\2\2hQ\3\2\2\2h_\3\2\2\2i\5\3\2\2\2jl\7\6\2\2km\5\b\5\2lk\3"+
		"\2\2\2lm\3\2\2\2mx\3\2\2\2np\7\u0082\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2"+
		"qr\3\2\2\2rt\3\2\2\2su\5\b\5\2ts\3\2\2\2tu\3\2\2\2uw\3\2\2\2vo\3\2\2\2"+
		"wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{\177\7\7\2\2|~\7\u0082"+
		"\2\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\7\3"+
		"\2\2\2\u0081\177\3\2\2\2\u0082\u0083\7\177\2\2\u0083\u0084\7\b\2\2\u0084"+
		"\u0085\5\n\6\2\u0085\u0086\5\20\t\2\u0086\u00b9\3\2\2\2\u0087\u0088\7"+
		"\177\2\2\u0088\u008c\7\b\2\2\u0089\u008b\7\u0082\2\2\u008a\u0089\3\2\2"+
		"\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0093\7\6\2\2\u0090\u0092\7\u0082\2"+
		"\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094"+
		"\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\177\2\2"+
		"\u0097\u00a8\7\b\2\2\u0098\u009b\7\u0080\2\2\u0099\u009a\7\t\2\2\u009a"+
		"\u009c\5\16\b\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u00a9\3"+
		"\2\2\2\u009d\u009e\5\n\6\2\u009e\u009f\7\n\2\2\u009f\u00a9\3\2\2\2\u00a0"+
		"\u00a3\7\u0080\2\2\u00a1\u00a2\7\t\2\2\u00a2\u00a4\5\16\b\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\5\n\6\2\u00a6"+
		"\u00a7\7\n\2\2\u00a7\u00a9\3\2\2\2\u00a8\u0098\3\2\2\2\u00a8\u009d\3\2"+
		"\2\2\u00a8\u00a0\3\2\2\2\u00a9\u00b4\3\2\2\2\u00aa\u00ac\7\u0082\2\2\u00ab"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\u00b0\3\2\2\2\u00af\u00b1\5\b\5\2\u00b0\u00af\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00ab\3\2\2\2\u00b3\u00b6\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b7\u00b9\7\7\2\2\u00b8\u0082\3\2\2\2\u00b8\u0087\3\2"+
		"\2\2\u00b9\t\3\2\2\2\u00ba\u00bb\b\6\1\2\u00bb\u00bc\7\33\2\2\u00bc\u00ea"+
		"\5\n\6\13\u00bd\u00be\t\3\2\2\u00be\u00ea\5\n\6\b\u00bf\u00ea\t\4\2\2"+
		"\u00c0\u00c3\7\u0080\2\2\u00c1\u00c2\7\b\2\2\u00c2\u00c4\7\u0080\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00ea\3\2\2\2\u00c5\u00c6\7\22"+
		"\2\2\u00c6\u00c7\5\n\6\2\u00c7\u00c8\7\23\2\2\u00c8\u00ea\3\2\2\2\u00c9"+
		"\u00ea\7\24\2\2\u00ca\u00cb\7\u0080\2\2\u00cb\u00cc\7\22\2\2\u00cc\u00d1"+
		"\5\n\6\2\u00cd\u00ce\7\3\2\2\u00ce\u00d0\5\n\6\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\7\23\2\2\u00d5\u00ea\3\2\2\2\u00d6"+
		"\u00ea\7\177\2\2\u00d7\u00d8\7\25\2\2\u00d8\u00d9\7\22\2\2\u00d9\u00da"+
		"\7\u0086\2\2\u00da\u00ea\7\23\2\2\u00db\u00dc\7\26\2\2\u00dc\u00e5\7\22"+
		"\2\2\u00dd\u00e2\5(\25\2\u00de\u00df\7\3\2\2\u00df\u00e1\5(\25\2\u00e0"+
		"\u00de\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2"+
		"\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00dd\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00ea\7\23\2\2\u00e8\u00ea\5"+
		"\f\7\2\u00e9\u00ba\3\2\2\2\u00e9\u00bd\3\2\2\2\u00e9\u00bf\3\2\2\2\u00e9"+
		"\u00c0\3\2\2\2\u00e9\u00c5\3\2\2\2\u00e9\u00c9\3\2\2\2\u00e9\u00ca\3\2"+
		"\2\2\u00e9\u00d6\3\2\2\2\u00e9\u00d7\3\2\2\2\u00e9\u00db\3\2\2\2\u00e9"+
		"\u00e8\3\2\2\2\u00ea\u011d\3\2\2\2\u00eb\u00ec\f\r\2\2\u00ec\u00ee\t\5"+
		"\2\2\u00ed\u00ef\7\u0082\2\2\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\u00f0\3\2\2\2\u00f0\u011c\5\n\6\16\u00f1\u00f2\f\f\2\2\u00f2\u00f4\t"+
		"\6\2\2\u00f3\u00f5\7\u0082\2\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2"+
		"\u00f5\u00f6\3\2\2\2\u00f6\u011c\5\n\6\r\u00f7\u00f8\f\n\2\2\u00f8\u00fa"+
		"\7\35\2\2\u00f9\u00fb\7\u0082\2\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2"+
		"\2\2\u00fb\u00fc\3\2\2\2\u00fc\u011c\5\n\6\13\u00fd\u00fe\f\t\2\2\u00fe"+
		"\u0100\t\7\2\2\u00ff\u0101\7\u0082\2\2\u0100\u00ff\3\2\2\2\u0100\u0101"+
		"\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u011c\5\n\6\n\u0103\u0104\f\7\2\2\u0104"+
		"\u0106\t\b\2\2\u0105\u0107\7\u0082\2\2\u0106\u0105\3\2\2\2\u0106\u0107"+
		"\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u011c\5\n\6\b\u0109\u010a\f\6\2\2\u010a"+
		"\u010c\t\t\2\2\u010b\u010d\7\u0082\2\2\u010c\u010b\3\2\2\2\u010c\u010d"+
		"\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u011c\5\n\6\7\u010f\u0110\f\5\2\2\u0110"+
		"\u0112\t\n\2\2\u0111\u0113\7\u0082\2\2\u0112\u0111\3\2\2\2\u0112\u0113"+
		"\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u011c\5\n\6\6\u0115\u0116\f\4\2\2\u0116"+
		"\u0118\t\13\2\2\u0117\u0119\7\u0082\2\2\u0118\u0117\3\2\2\2\u0118\u0119"+
		"\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\5\n\6\5\u011b\u00eb\3\2\2\2\u011b"+
		"\u00f1\3\2\2\2\u011b\u00f7\3\2\2\2\u011b\u00fd\3\2\2\2\u011b\u0103\3\2"+
		"\2\2\u011b\u0109\3\2\2\2\u011b\u010f\3\2\2\2\u011b\u0115\3\2\2\2\u011c"+
		"\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\13\3\2\2"+
		"\2\u011f\u011d\3\2\2\2\u0120\u0121\t\f\2\2\u0121\u0126\7\u0080\2\2\u0122"+
		"\u0123\7\3\2\2\u0123\u0125\7\u0080\2\2\u0124\u0122\3\2\2\2\u0125\u0128"+
		"\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0138\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0129\u012a\7\t\2\2\u012a\u0139\5\16\b\2\u012b\u012c\7"+
		"\t\2\2\u012c\u012d\7\22\2\2\u012d\u012f\5(\25\2\u012e\u0130\7\'\2\2\u012f"+
		"\u012e\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0133\7@"+
		"\2\2\u0132\u0134\7\'\2\2\u0133\u0132\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\u0136\5(\25\2\u0136\u0137\7\23\2\2\u0137\u0139\3"+
		"\2\2\2\u0138\u0129\3\2\2\2\u0138\u012b\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013b\3\2\2\2\u013a\u013c\7\u0082\2\2\u013b\u013a\3\2\2\2\u013b\u013c"+
		"\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\5\n\6\2\u013e\r\3\2\2\2\u013f"+
		"\u0143\7A\2\2\u0140\u0143\7\25\2\2\u0141\u0143\7\26\2\2\u0142\u013f\3"+
		"\2\2\2\u0142\u0140\3\2\2\2\u0142\u0141\3\2\2\2\u0143\17\3\2\2\2\u0144"+
		"\u01cc\7B\2\2\u0145\u0149\7C\2\2\u0146\u0147\t\r\2\2\u0147\u0149\7\u0080"+
		"\2\2\u0148\u0145\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014a\3\2\2\2\u014a"+
		"\u014b\7\177\2\2\u014b\u01cc\7\177\2\2\u014c\u0150\t\16\2\2\u014d\u014e"+
		"\t\r\2\2\u014e\u0150\7\u0080\2\2\u014f\u014c\3\2\2\2\u014f\u014d\3\2\2"+
		"\2\u0150\u0151\3\2\2\2\u0151\u01cc\7\177\2\2\u0152\u0156\t\17\2\2\u0153"+
		"\u0154\t\20\2\2\u0154\u0156\7\u0080\2\2\u0155\u0152\3\2\2\2\u0155\u0153"+
		"\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u01cc\7\177\2\2\u0158\u015c\t\21\2"+
		"\2\u0159\u015a\t\20\2\2\u015a\u015c\7\u0080\2\2\u015b\u0158\3\2\2\2\u015b"+
		"\u0159\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\7\177\2\2\u015e\u015f\7"+
		"\177\2\2\u015f\u01cc\7\177\2\2\u0160\u0161\7L\2\2\u0161\u01cc\7\177\2"+
		"\2\u0162\u0163\7M\2\2\u0163\u0164\7\177\2\2\u0164\u01cc\7\177\2\2\u0165"+
		"\u0166\6\t\n\2\u0166\u0167\t\22\2\2\u0167\u0168\7\u0080\2\2\u0168\u01cc"+
		"\7\177\2\2\u0169\u016a\6\t\13\2\u016a\u016b\t\22\2\2\u016b\u016c\7\u0080"+
		"\2\2\u016c\u016d\7\177\2\2\u016d\u01cc\7\177\2\2\u016e\u016f\t\23\2\2"+
		"\u016f\u01cc\7\177\2\2\u0170\u0171\t\24\2\2\u0171\u0172\7\177\2\2\u0172"+
		"\u01cc\7\177\2\2\u0173\u0174\6\t\f\2\u0174\u0175\t\25\2\2\u0175\u0176"+
		"\7\u0080\2\2\u0176\u01cc\7\177\2\2\u0177\u0178\6\t\r\2\u0178\u0179\t\25"+
		"\2\2\u0179\u017a\7\u0080\2\2\u017a\u017b\7\177\2\2\u017b\u01cc\7\177\2"+
		"\2\u017c\u0180\t\26\2\2\u017d\u017e\t\27\2\2\u017e\u0180\7\u0080\2\2\u017f"+
		"\u017c\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u01cc\7\177"+
		"\2\2\u0182\u0183\7T\2\2\u0183\u01cc\7\177\2\2\u0184\u0185\7U\2\2\u0185"+
		"\u0186\5\22\n\2\u0186\u0187\7\177\2\2\u0187\u01cc\3\2\2\2\u0188\u0189"+
		"\7V\2\2\u0189\u018a\5\22\n\2\u018a\u018b\7\177\2\2\u018b\u01cc\3\2\2\2"+
		"\u018c\u0190\7W\2\2\u018d\u018f\5\22\n\2\u018e\u018d\3\2\2\2\u018f\u0192"+
		"\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u01cc\3\2\2\2\u0192"+
		"\u0190\3\2\2\2\u0193\u0194\t\30\2\2\u0194\u01cc\7\177\2\2\u0195\u0196"+
		"\t\31\2\2\u0196\u0198\5\22\n\2\u0197\u0199\5\n\6\2\u0198\u0197\3\2\2\2"+
		"\u0199\u019a\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u01cc"+
		"\3\2\2\2\u019c\u019d\6\t\16\2\u019d\u019e\7;\2\2\u019e\u019f\7\u0080\2"+
		"\2\u019f\u01cc\7\177\2\2\u01a0\u01a1\6\t\17\2\u01a1\u01a2\7;\2\2\u01a2"+
		"\u01a3\7\u0080\2\2\u01a3\u01a5\5\22\n\2\u01a4\u01a6\5\n\6\2\u01a5\u01a4"+
		"\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8"+
		"\u01cc\3\2\2\2\u01a9\u01aa\t\32\2\2\u01aa\u01ac\7\177\2\2\u01ab\u01ad"+
		"\5\n\6\2\u01ac\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae"+
		"\u01af\3\2\2\2\u01af\u01cc\3\2\2\2\u01b0\u01b1\t\33\2\2\u01b1\u01b2\5"+
		"\22\n\2\u01b2\u01b3\7\177\2\2\u01b3\u01cc\3\2\2\2\u01b4\u01b5\6\t\20\2"+
		"\u01b5\u01b6\7?\2\2\u01b6\u01b7\7\u0080\2\2\u01b7\u01b9\7\177\2\2\u01b8"+
		"\u01ba\5\n\6\2\u01b9\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01b9\3\2"+
		"\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01cc\3\2\2\2\u01bd\u01be\6\t\21\2\u01be"+
		"\u01bf\7?\2\2\u01bf\u01c0\7\u0080\2\2\u01c0\u01c1\5\22\n\2\u01c1\u01c2"+
		"\7\177\2\2\u01c2\u01cc\3\2\2\2\u01c3\u01cc\7d\2\2\u01c4\u01c8\7e\2\2\u01c5"+
		"\u01c7\5\22\n\2\u01c6\u01c5\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6\3"+
		"\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01cc\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb"+
		"\u0144\3\2\2\2\u01cb\u0148\3\2\2\2\u01cb\u014f\3\2\2\2\u01cb\u0155\3\2"+
		"\2\2\u01cb\u015b\3\2\2\2\u01cb\u0160\3\2\2\2\u01cb\u0162\3\2\2\2\u01cb"+
		"\u0165\3\2\2\2\u01cb\u0169\3\2\2\2\u01cb\u016e\3\2\2\2\u01cb\u0170\3\2"+
		"\2\2\u01cb\u0173\3\2\2\2\u01cb\u0177\3\2\2\2\u01cb\u017f\3\2\2\2\u01cb"+
		"\u0182\3\2\2\2\u01cb\u0184\3\2\2\2\u01cb\u0188\3\2\2\2\u01cb\u018c\3\2"+
		"\2\2\u01cb\u0193\3\2\2\2\u01cb\u0195\3\2\2\2\u01cb\u019c\3\2\2\2\u01cb"+
		"\u01a0\3\2\2\2\u01cb\u01a9\3\2\2\2\u01cb\u01b0\3\2\2\2\u01cb\u01b4\3\2"+
		"\2\2\u01cb\u01bd\3\2\2\2\u01cb\u01c3\3\2\2\2\u01cb\u01c4\3\2\2\2\u01cc"+
		"\21\3\2\2\2\u01cd\u01ce\t\34\2\2\u01ce\23\3\2\2\2\u01cf\u01d1\7\u0082"+
		"\2\2\u01d0\u01cf\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2"+
		"\u01d3\3\2\2\2\u01d3\u01dd\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5\u01d7\5\26"+
		"\f\2\u01d6\u01d8\7\u0082\2\2\u01d7\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dc\5\""+
		"\22\2\u01dc\u01de\3\2\2\2\u01dd\u01d5\3\2\2\2\u01dd\u01de\3\2\2\2\u01de"+
		"\25\3\2\2\2\u01df\u01e0\7f\2\2\u01e0\u01e1\7\u0080\2\2\u01e1\u01e2\7\b"+
		"\2\2\u01e2\u01e3\7\u0080\2\2\u01e3\u01e4\7\b\2\2\u01e4\u01e5\7\u0080\2"+
		"\2\u01e5\u01e6\7\b\2\2\u01e6\u01e7\7g\2\2\u01e7\27\3\2\2\2\u01e8\u01ec"+
		"\7\6\2\2\u01e9\u01eb\7\u0082\2\2\u01ea\u01e9\3\2\2\2\u01eb\u01ee\3\2\2"+
		"\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ef\3\2\2\2\u01ee\u01ec"+
		"\3\2\2\2\u01ef\u01f3\7h\2\2\u01f0\u01f2\7\u0082\2\2\u01f1\u01f0\3\2\2"+
		"\2\u01f2\u01f5\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f7"+
		"\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f6\u01f8\5\32\16\2\u01f7\u01f6\3\2\2\2"+
		"\u01f7\u01f8\3\2\2\2\u01f8\u0203\3\2\2\2\u01f9\u01fb\7\u0082\2\2\u01fa"+
		"\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fc\u01fd\3\2"+
		"\2\2\u01fd\u01ff\3\2\2\2\u01fe\u0200\5\32\16\2\u01ff\u01fe\3\2\2\2\u01ff"+
		"\u0200\3\2\2\2\u0200\u0202\3\2\2\2\u0201\u01fa\3\2\2\2\u0202\u0205\3\2"+
		"\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0206\3\2\2\2\u0205"+
		"\u0203\3\2\2\2\u0206\u020a\7\7\2\2\u0207\u0209\7\u0082\2\2\u0208\u0207"+
		"\3\2\2\2\u0209\u020c\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b"+
		"\31\3\2\2\2\u020c\u020a\3\2\2\2\u020d\u0210\5\34\17\2\u020e\u0210\5\36"+
		"\20\2\u020f\u020d\3\2\2\2\u020f\u020e\3\2\2\2\u0210\33\3\2\2\2\u0211\u0212"+
		"\7\u0080\2\2\u0212\u0213\7\b\2\2\u0213\u0214\5\n\6\2\u0214\35\3\2\2\2"+
		"\u0215\u0216\7i\2\2\u0216\u0218\7\u0080\2\2\u0217\u0219\7\u0082\2\2\u0218"+
		"\u0217\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021b\7\22"+
		"\2\2\u021b\u0220\5 \21\2\u021c\u021d\7\3\2\2\u021d\u021f\5 \21\2\u021e"+
		"\u021c\3\2\2\2\u021f\u0222\3\2\2\2\u0220\u021e\3\2\2\2\u0220\u0221\3\2"+
		"\2\2\u0221\u0223\3\2\2\2\u0222\u0220\3\2\2\2\u0223\u0224\7\23\2\2\u0224"+
		"\u0225\7\t\2\2\u0225\u0226\5\16\b\2\u0226\37\3\2\2\2\u0227\u0228\7\u0080"+
		"\2\2\u0228\u0229\7\t\2\2\u0229\u022a\5\16\b\2\u022a!\3\2\2\2\u022b\u022d"+
		"\5$\23\2\u022c\u022b\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u0238\3\2\2\2\u022e"+
		"\u0230\7\u0082\2\2\u022f\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u022f"+
		"\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0234\3\2\2\2\u0233\u0235\5$\23\2\u0234"+
		"\u0233\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0237\3\2\2\2\u0236\u022f\3\2"+
		"\2\2\u0237\u023a\3\2\2\2\u0238\u0236\3\2\2\2\u0238\u0239\3\2\2\2\u0239"+
		"#\3\2\2\2\u023a\u0238\3\2\2\2\u023b\u023c\t\35\2\2\u023c\u023d\7\u0080"+
		"\2\2\u023d\u023e\7\t\2\2\u023e\u023f\5\16\b\2\u023f\u0241\7\36\2\2\u0240"+
		"\u0242\7\u0082\2\2\u0241\u0240\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0243"+
		"\3\2\2\2\u0243\u0244\5(\25\2\u0244\u02ef\3\2\2\2\u0245\u0246\7\u0080\2"+
		"\2\u0246\u0248\7\36\2\2\u0247\u0249\7\u0082\2\2\u0248\u0247\3\2\2\2\u0248"+
		"\u0249\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u02ef\5(\25\2\u024b\u024c\7\n"+
		"\2\2\u024c\u024d\7\22\2\2\u024d\u024e\5(\25\2\u024e\u024f\7\23\2\2\u024f"+
		"\u02ef\3\2\2\2\u0250\u0251\7l\2\2\u0251\u0252\7\22\2\2\u0252\u0253\5("+
		"\25\2\u0253\u0254\7\23\2\2\u0254\u02ef\3\2\2\2\u0255\u0256\7m\2\2\u0256"+
		"\u0257\7\22\2\2\u0257\u0258\5(\25\2\u0258\u025c\7\23\2\2\u0259\u025b\7"+
		"\u0082\2\2\u025a\u0259\3\2\2\2\u025b\u025e\3\2\2\2\u025c\u025a\3\2\2\2"+
		"\u025c\u025d\3\2\2\2\u025d\u025f\3\2\2\2\u025e\u025c\3\2\2\2\u025f\u0260"+
		"\7\6\2\2\u0260\u0261\5\"\22\2\u0261\u026d\7\7\2\2\u0262\u0266\7n\2\2\u0263"+
		"\u0265\7\u0082\2\2\u0264\u0263\3\2\2\2\u0265\u0268\3\2\2\2\u0266\u0264"+
		"\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0269\3\2\2\2\u0268\u0266\3\2\2\2\u0269"+
		"\u026a\7\6\2\2\u026a\u026b\5\"\22\2\u026b\u026c\7\7\2\2\u026c\u026e\3"+
		"\2\2\2\u026d\u0262\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u02ef\3\2\2\2\u026f"+
		"\u0270\7o\2\2\u0270\u0271\7\22\2\2\u0271\u0272\5(\25\2\u0272\u0276\7\23"+
		"\2\2\u0273\u0275\7\u0082\2\2\u0274\u0273\3\2\2\2\u0275\u0278\3\2\2\2\u0276"+
		"\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0279\3\2\2\2\u0278\u0276\3\2"+
		"\2\2\u0279\u0284\7\6\2\2\u027a\u027c\7\u0082\2\2\u027b\u027a\3\2\2\2\u027c"+
		"\u027f\3\2\2\2\u027d\u027b\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u0280\3\2"+
		"\2\2\u027f\u027d\3\2\2\2\u0280\u0281\7p\2\2\u0281\u0282\5*\26\2\u0282"+
		"\u0283\7q\2\2\u0283\u0285\3\2\2\2\u0284\u027d\3\2\2\2\u0284\u0285\3\2"+
		"\2\2\u0285\u0286\3\2\2\2\u0286\u0287\5\"\22\2\u0287\u0288\7\7\2\2\u0288"+
		"\u02ef\3\2\2\2\u0289\u028a\t\36\2\2\u028a\u0293\7\22\2\2\u028b\u0290\5"+
		"&\24\2\u028c\u028d\7\3\2\2\u028d\u028f\5&\24\2\u028e\u028c\3\2\2\2\u028f"+
		"\u0292\3\2\2\2\u0290\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0294\3\2"+
		"\2\2\u0292\u0290\3\2\2\2\u0293\u028b\3\2\2\2\u0293\u0294\3\2\2\2\u0294"+
		"\u0295\3\2\2\2\u0295\u02ef\7\23\2\2\u0296\u0297\7\u0080\2\2\u0297\u0298"+
		"\7\22\2\2\u0298\u0299\5(\25\2\u0299\u029a\7\23\2\2\u029a\u029c\7\36\2"+
		"\2\u029b\u029d\7\u0082\2\2\u029c\u029b\3\2\2\2\u029c\u029d\3\2\2\2\u029d"+
		"\u029e\3\2\2\2\u029e\u029f\5(\25\2\u029f\u02ef\3\2\2\2\u02a0\u02a1\7t"+
		"\2\2\u02a1\u02a3\7\u0080\2\2\u02a2\u02a0\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3"+
		"\u02a4\3\2\2\2\u02a4\u02a5\7i\2\2\u02a5\u02a7\7\u0080\2\2\u02a6\u02a8"+
		"\7\u0082\2\2\u02a7\u02a6\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02a9\3\2\2"+
		"\2\u02a9\u02b2\7\22\2\2\u02aa\u02af\5 \21\2\u02ab\u02ac\7\3\2\2\u02ac"+
		"\u02ae\5 \21\2\u02ad\u02ab\3\2\2\2\u02ae\u02b1\3\2\2\2\u02af\u02ad\3\2"+
		"\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b3\3\2\2\2\u02b1\u02af\3\2\2\2\u02b2"+
		"\u02aa\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02b5\7\23"+
		"\2\2\u02b5\u02b8\7\t\2\2\u02b6\u02b9\5\16\b\2\u02b7\u02b9\7u\2\2\u02b8"+
		"\u02b6\3\2\2\2\u02b8\u02b7\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02be\7\36"+
		"\2\2\u02bb\u02bd\7\u0082\2\2\u02bc\u02bb\3\2\2\2\u02bd\u02c0\3\2\2\2\u02be"+
		"\u02bc\3\2\2\2\u02be\u02bf\3\2\2\2\u02bf\u02c1\3\2\2\2\u02c0\u02be\3\2"+
		"\2\2\u02c1\u02d2\7\6\2\2\u02c2\u02c4\7\u0082\2\2\u02c3\u02c2\3\2\2\2\u02c4"+
		"\u02c7\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6\u02c8\3\2"+
		"\2\2\u02c7\u02c5\3\2\2\2\u02c8\u02c9\7p\2\2\u02c9\u02cd\5.\30\2\u02ca"+
		"\u02cc\7\u0082\2\2\u02cb\u02ca\3\2\2\2\u02cc\u02cf\3\2\2\2\u02cd\u02cb"+
		"\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce\u02d0\3\2\2\2\u02cf\u02cd\3\2\2\2\u02d0"+
		"\u02d1\7q\2\2\u02d1\u02d3\3\2\2\2\u02d2\u02c5\3\2\2\2\u02d2\u02d3\3\2"+
		"\2\2\u02d3\u02d4\3\2\2\2\u02d4\u02df\5\"\22\2\u02d5\u02d7\7v\2\2\u02d6"+
		"\u02d8\5(\25\2\u02d7\u02d6\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02dc\3\2"+
		"\2\2\u02d9\u02db\7\u0082\2\2\u02da\u02d9\3\2\2\2\u02db\u02de\3\2\2\2\u02dc"+
		"\u02da\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02e0\3\2\2\2\u02de\u02dc\3\2"+
		"\2\2\u02df\u02d5\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1"+
		"\u02e2\7\7\2\2\u02e2\u02ef\3\2\2\2\u02e3\u02e8\7p\2\2\u02e4\u02e9\5\6"+
		"\4\2\u02e5\u02e9\5\4\3\2\u02e6\u02e9\5\60\31\2\u02e7\u02e9\5\30\r\2\u02e8"+
		"\u02e4\3\2\2\2\u02e8\u02e5\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e8\u02e7\3\2"+
		"\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02eb\7q\2\2\u02eb\u02ef\3\2\2\2\u02ec"+
		"\u02ef\5\26\f\2\u02ed\u02ef\5(\25\2\u02ee\u023b\3\2\2\2\u02ee\u0245\3"+
		"\2\2\2\u02ee\u024b\3\2\2\2\u02ee\u0250\3\2\2\2\u02ee\u0255\3\2\2\2\u02ee"+
		"\u026f\3\2\2\2\u02ee\u0289\3\2\2\2\u02ee\u0296\3\2\2\2\u02ee\u02a2\3\2"+
		"\2\2\u02ee\u02e3\3\2\2\2\u02ee\u02ec\3\2\2\2\u02ee\u02ed\3\2\2\2\u02ef"+
		"%\3\2\2\2\u02f0\u02f3\7\u0086\2\2\u02f1\u02f3\5(\25\2\u02f2\u02f0\3\2"+
		"\2\2\u02f2\u02f1\3\2\2\2\u02f3\'\3\2\2\2\u02f4\u02f5\b\25\1\2\u02f5\u02f6"+
		"\t\37\2\2\u02f6\u0329\5(\25\n\u02f7\u0329\t\4\2\2\u02f8\u0329\7\177\2"+
		"\2\u02f9\u0308\7\u0080\2\2\u02fa\u0303\7\22\2\2\u02fb\u0300\5(\25\2\u02fc"+
		"\u02fd\7\3\2\2\u02fd\u02ff\5(\25\2\u02fe\u02fc\3\2\2\2\u02ff\u0302\3\2"+
		"\2\2\u0300\u02fe\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u0304\3\2\2\2\u0302"+
		"\u0300\3\2\2\2\u0303\u02fb\3\2\2\2\u0303\u0304\3\2\2\2\u0304\u0305\3\2"+
		"\2\2\u0305\u0309\7\23\2\2\u0306\u0307\7\b\2\2\u0307\u0309\7\u0080\2\2"+
		"\u0308\u02fa\3\2\2\2\u0308\u0306\3\2\2\2\u0308\u0309\3\2\2\2\u0309\u0329"+
		"\3\2\2\2\u030a\u030b\7\25\2\2\u030b\u030c\7\22\2\2\u030c\u030d\7\u0086"+
		"\2\2\u030d\u0329\7\23\2\2\u030e\u030f\7\26\2\2\u030f\u0318\7\22\2\2\u0310"+
		"\u0315\5(\25\2\u0311\u0312\7\3\2\2\u0312\u0314\5(\25\2\u0313\u0311\3\2"+
		"\2\2\u0314\u0317\3\2\2\2\u0315\u0313\3\2\2\2\u0315\u0316\3\2\2\2\u0316"+
		"\u0319\3\2\2\2\u0317\u0315\3\2\2\2\u0318\u0310\3\2\2\2\u0318\u0319\3\2"+
		"\2\2\u0319\u031a\3\2\2\2\u031a\u0329\7\23\2\2\u031b\u031c\7w\2\2\u031c"+
		"\u031d\7\22\2\2\u031d\u0329\7\23\2\2\u031e\u031f\7x\2\2\u031f\u0321\7"+
		"\22\2\2\u0320\u0322\7\u0086\2\2\u0321\u0320\3\2\2\2\u0321\u0322\3\2\2"+
		"\2\u0322\u0323\3\2\2\2\u0323\u0329\7\23\2\2\u0324\u0325\7\22\2\2\u0325"+
		"\u0326\5(\25\2\u0326\u0327\7\23\2\2\u0327\u0329\3\2\2\2\u0328\u02f4\3"+
		"\2\2\2\u0328\u02f7\3\2\2\2\u0328\u02f8\3\2\2\2\u0328\u02f9\3\2\2\2\u0328"+
		"\u030a\3\2\2\2\u0328\u030e\3\2\2\2\u0328\u031b\3\2\2\2\u0328\u031e\3\2"+
		"\2\2\u0328\u0324\3\2\2\2\u0329\u0356\3\2\2\2\u032a\u032b\f\t\2\2\u032b"+
		"\u032d\t\5\2\2\u032c\u032e\7\u0082\2\2\u032d\u032c\3\2\2\2\u032d\u032e"+
		"\3\2\2\2\u032e\u032f\3\2\2\2\u032f\u0355\5(\25\n\u0330\u0331\f\b\2\2\u0331"+
		"\u0333\t\6\2\2\u0332\u0334\7\u0082\2\2\u0333\u0332\3\2\2\2\u0333\u0334"+
		"\3\2\2\2\u0334\u0335\3\2\2\2\u0335\u0355\5(\25\t\u0336\u0337\f\7\2\2\u0337"+
		"\u0339\7\35\2\2\u0338\u033a\7\u0082\2\2\u0339\u0338\3\2\2\2\u0339\u033a"+
		"\3\2\2\2\u033a\u033b\3\2\2\2\u033b\u0355\5(\25\b\u033c\u033d\f\6\2\2\u033d"+
		"\u033f\t \2\2\u033e\u0340\7\u0082\2\2\u033f\u033e\3\2\2\2\u033f\u0340"+
		"\3\2\2\2\u0340\u0341\3\2\2\2\u0341\u0355\5(\25\7\u0342\u0343\f\5\2\2\u0343"+
		"\u0345\t!\2\2\u0344\u0346\7\u0082\2\2\u0345\u0344\3\2\2\2\u0345\u0346"+
		"\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u0355\5(\25\6\u0348\u0349\f\4\2\2\u0349"+
		"\u034b\7.\2\2\u034a\u034c\7\u0082\2\2\u034b\u034a\3\2\2\2\u034b\u034c"+
		"\3\2\2\2\u034c\u034d\3\2\2\2\u034d\u0355\5(\25\5\u034e\u034f\f\3\2\2\u034f"+
		"\u0351\7\62\2\2\u0350\u0352\7\u0082\2\2\u0351\u0350\3\2\2\2\u0351\u0352"+
		"\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u0355\5(\25\4\u0354\u032a\3\2\2\2\u0354"+
		"\u0330\3\2\2\2\u0354\u0336\3\2\2\2\u0354\u033c\3\2\2\2\u0354\u0342\3\2"+
		"\2\2\u0354\u0348\3\2\2\2\u0354\u034e\3\2\2\2\u0355\u0358\3\2\2\2\u0356"+
		"\u0354\3\2\2\2\u0356\u0357\3\2\2\2\u0357)\3\2\2\2\u0358\u0356\3\2\2\2"+
		"\u0359\u035d\7\6\2\2\u035a\u035c\7\u0082\2\2\u035b\u035a\3\2\2\2\u035c"+
		"\u035f\3\2\2\2\u035d\u035b\3\2\2\2\u035d\u035e\3\2\2\2\u035e\u0360\3\2"+
		"\2\2\u035f\u035d\3\2\2\2\u0360\u0364\7d\2\2\u0361\u0363\7\u0082\2\2\u0362"+
		"\u0361\3\2\2\2\u0363\u0366\3\2\2\2\u0364\u0362\3\2\2\2\u0364\u0365\3\2"+
		"\2\2\u0365\u0368\3\2\2\2\u0366\u0364\3\2\2\2\u0367\u0369\5\n\6\2\u0368"+
		"\u0367\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u0374\3\2\2\2\u036a\u036c\7\u0082"+
		"\2\2\u036b\u036a\3\2\2\2\u036c\u036d\3\2\2\2\u036d\u036b\3\2\2\2\u036d"+
		"\u036e\3\2\2\2\u036e\u0370\3\2\2\2\u036f\u0371\5\n\6\2\u0370\u036f\3\2"+
		"\2\2\u0370\u0371\3\2\2\2\u0371\u0373\3\2\2\2\u0372\u036b\3\2\2\2\u0373"+
		"\u0376\3\2\2\2\u0374\u0372\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u0377\3\2"+
		"\2\2\u0376\u0374\3\2\2\2\u0377\u0378\5,\27\2\u0378\u037c\7\7\2\2\u0379"+
		"\u037b\7\u0082\2\2\u037a\u0379\3\2\2\2\u037b\u037e\3\2\2\2\u037c\u037a"+
		"\3\2\2\2\u037c\u037d\3\2\2\2\u037d+\3\2\2\2\u037e\u037c\3\2\2\2\u037f"+
		"\u0388\7y\2\2\u0380\u0385\7\u0080\2\2\u0381\u0382\7\3\2\2\u0382\u0384"+
		"\7\u0080\2\2\u0383\u0381\3\2\2\2\u0384\u0387\3\2\2\2\u0385\u0383\3\2\2"+
		"\2\u0385\u0386\3\2\2\2\u0386\u0389\3\2\2\2\u0387\u0385\3\2\2\2\u0388\u0380"+
		"\3\2\2\2\u0388\u0389\3\2\2\2\u0389\u038d\3\2\2\2\u038a\u038c\7\u0082\2"+
		"\2\u038b\u038a\3\2\2\2\u038c\u038f\3\2\2\2\u038d\u038b\3\2\2\2\u038d\u038e"+
		"\3\2\2\2\u038e-\3\2\2\2\u038f\u038d\3\2\2\2\u0390\u0394\7\6\2\2\u0391"+
		"\u0393\7\u0082\2\2\u0392\u0391\3\2\2\2\u0393\u0396\3\2\2\2\u0394\u0392"+
		"\3\2\2\2\u0394\u0395\3\2\2\2\u0395\u03ac\3\2\2\2\u0396\u0394\3\2\2\2\u0397"+
		"\u039b\t\"\2\2\u0398\u039a\7\u0082\2\2\u0399\u0398\3\2\2\2\u039a\u039d"+
		"\3\2\2\2\u039b\u0399\3\2\2\2\u039b\u039c\3\2\2\2\u039c\u039e\3\2\2\2\u039d"+
		"\u039b\3\2\2\2\u039e\u03a9\5\n\6\2\u039f\u03a1\7\u0082\2\2\u03a0\u039f"+
		"\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2\u03a0\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3"+
		"\u03a5\3\2\2\2\u03a4\u03a6\5\n\6\2\u03a5\u03a4\3\2\2\2\u03a5\u03a6\3\2"+
		"\2\2\u03a6\u03a8\3\2\2\2\u03a7\u03a0\3\2\2\2\u03a8\u03ab\3\2\2\2\u03a9"+
		"\u03a7\3\2\2\2\u03a9\u03aa\3\2\2\2\u03aa\u03ad\3\2\2\2\u03ab\u03a9\3\2"+
		"\2\2\u03ac\u0397\3\2\2\2\u03ac\u03ad\3\2\2\2\u03ad\u03b1\3\2\2\2\u03ae"+
		"\u03b0\7\u0082\2\2\u03af\u03ae\3\2\2\2\u03b0\u03b3\3\2\2\2\u03b1\u03af"+
		"\3\2\2\2\u03b1\u03b2\3\2\2\2\u03b2\u03b5\3\2\2\2\u03b3\u03b1\3\2\2\2\u03b4"+
		"\u03b6\5,\27\2\u03b5\u03b4\3\2\2\2\u03b5\u03b6\3\2\2\2\u03b6\u03cc\3\2"+
		"\2\2\u03b7\u03bb\t#\2\2\u03b8\u03ba\7\u0082\2\2\u03b9\u03b8\3\2\2\2\u03ba"+
		"\u03bd\3\2\2\2\u03bb\u03b9\3\2\2\2\u03bb\u03bc\3\2\2\2\u03bc\u03be\3\2"+
		"\2\2\u03bd\u03bb\3\2\2\2\u03be\u03c9\5\n\6\2\u03bf\u03c1\7\u0082\2\2\u03c0"+
		"\u03bf\3\2\2\2\u03c1\u03c2\3\2\2\2\u03c2\u03c0\3\2\2\2\u03c2\u03c3\3\2"+
		"\2\2\u03c3\u03c5\3\2\2\2\u03c4\u03c6\5\n\6\2\u03c5\u03c4\3\2\2\2\u03c5"+
		"\u03c6\3\2\2\2\u03c6\u03c8\3\2\2\2\u03c7\u03c0\3\2\2\2\u03c8\u03cb\3\2"+
		"\2\2\u03c9\u03c7\3\2\2\2\u03c9\u03ca\3\2\2\2\u03ca\u03cd\3\2\2\2\u03cb"+
		"\u03c9\3\2\2\2\u03cc\u03b7\3\2\2\2\u03cc\u03cd\3\2\2\2\u03cd\u03d1\3\2"+
		"\2\2\u03ce\u03d0\7\u0082\2\2\u03cf\u03ce\3\2\2\2\u03d0\u03d3\3\2\2\2\u03d1"+
		"\u03cf\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03d4\3\2\2\2\u03d3\u03d1\3\2"+
		"\2\2\u03d4\u03d8\7\7\2\2\u03d5\u03d7\7\u0082\2\2\u03d6\u03d5\3\2\2\2\u03d7"+
		"\u03da\3\2\2\2\u03d8\u03d6\3\2\2\2\u03d8\u03d9\3\2\2\2\u03d9/\3\2\2\2"+
		"\u03da\u03d8\3\2\2\2\u03db\u03df\7\6\2\2\u03dc\u03de\7\u0082\2\2\u03dd"+
		"\u03dc\3\2\2\2\u03de\u03e1\3\2\2\2\u03df\u03dd\3\2\2\2\u03df\u03e0\3\2"+
		"\2\2\u03e0\u03e2\3\2\2\2\u03e1\u03df\3\2\2\2\u03e2\u03e6\7d\2\2\u03e3"+
		"\u03e5\7\u0082\2\2\u03e4\u03e3\3\2\2\2\u03e5\u03e8\3\2\2\2\u03e6\u03e4"+
		"\3\2\2\2\u03e6\u03e7\3\2\2\2\u03e7\u03ea\3\2\2\2\u03e8\u03e6\3\2\2\2\u03e9"+
		"\u03eb\5\n\6\2\u03ea\u03e9\3\2\2\2\u03ea\u03eb\3\2\2\2\u03eb\u03f6\3\2"+
		"\2\2\u03ec\u03ee\7\u0082\2\2\u03ed\u03ec\3\2\2\2\u03ee\u03ef\3\2\2\2\u03ef"+
		"\u03ed\3\2\2\2\u03ef\u03f0\3\2\2\2\u03f0\u03f2\3\2\2\2\u03f1\u03f3\5\n"+
		"\6\2\u03f2\u03f1\3\2\2\2\u03f2\u03f3\3\2\2\2\u03f3\u03f5\3\2\2\2\u03f4"+
		"\u03ed\3\2\2\2\u03f5\u03f8\3\2\2\2\u03f6\u03f4\3\2\2\2\u03f6\u03f7\3\2"+
		"\2\2\u03f7\u03f9\3\2\2\2\u03f8\u03f6\3\2\2\2\u03f9\u03fd\7\7\2\2\u03fa"+
		"\u03fc\7\u0082\2\2\u03fb\u03fa\3\2\2\2\u03fc\u03ff\3\2\2\2\u03fd\u03fb"+
		"\3\2\2\2\u03fd\u03fe\3\2\2\2\u03fe\61\3\2\2\2\u03ff\u03fd\3\2\2\2\u0096"+
		"\66:?GNQY_fhlqtx\177\u008c\u0093\u009b\u00a3\u00a8\u00ad\u00b0\u00b4\u00b8"+
		"\u00c3\u00d1\u00e2\u00e5\u00e9\u00ee\u00f4\u00fa\u0100\u0106\u010c\u0112"+
		"\u0118\u011b\u011d\u0126\u012f\u0133\u0138\u013b\u0142\u0148\u014f\u0155"+
		"\u015b\u017f\u0190\u019a\u01a7\u01ae\u01bb\u01c8\u01cb\u01d2\u01d9\u01dd"+
		"\u01ec\u01f3\u01f7\u01fc\u01ff\u0203\u020a\u020f\u0218\u0220\u022c\u0231"+
		"\u0234\u0238\u0241\u0248\u025c\u0266\u026d\u0276\u027d\u0284\u0290\u0293"+
		"\u029c\u02a2\u02a7\u02af\u02b2\u02b8\u02be\u02c5\u02cd\u02d2\u02d7\u02dc"+
		"\u02df\u02e8\u02ee\u02f2\u0300\u0303\u0308\u0315\u0318\u0321\u0328\u032d"+
		"\u0333\u0339\u033f\u0345\u034b\u0351\u0354\u0356\u035d\u0364\u0368\u036d"+
		"\u0370\u0374\u037c\u0385\u0388\u038d\u0394\u039b\u03a2\u03a5\u03a9\u03ac"+
		"\u03b1\u03b5\u03bb\u03c2\u03c5\u03c9\u03cc\u03d1\u03d8\u03df\u03e6\u03ea"+
		"\u03ef\u03f2\u03f6\u03fd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}