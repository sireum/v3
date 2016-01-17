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
		RULE_qformula = 5, RULE_type = 6, RULE_justification = 7, RULE_program = 8, 
		RULE_impor = 9, RULE_facts = 10, RULE_factOrFun = 11, RULE_fact = 12, 
		RULE_fun = 13, RULE_param = 14, RULE_stmts = 15, RULE_stmt = 16, RULE_stringOrExp = 17, 
		RULE_exp = 18, RULE_loopInvariant = 19, RULE_modifies = 20, RULE_methodContract = 21, 
		RULE_invariants = 22;
	public static final String[] ruleNames = {
		"file", "sequent", "proof", "proofStep", "formula", "qformula", "type", 
		"justification", "program", "impor", "facts", "factOrFun", "fact", "fun", 
		"param", "stmts", "stmt", "stringOrExp", "exp", "loopInvariant", "modifies", 
		"methodContract", "invariants"
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
		"'somei'", "'Ei'", "'existse'", "'somee'", "'Ee'", "'invariant'", "'fact'", 
		"'auto'", "'import'", "'_'", "'def'", "'var'", "'val'", "'assert'", "'if'", 
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
			setState(67);
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
				setState(46);
				sequent();
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(47);
						match(NL);
						}
						} 
					}
					setState(52);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				}
				setState(54);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(53);
					proof();
					}
				}

				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(56);
					match(NL);
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(62);
				match(EOF);
				}
				break;
			case EOF:
			case T__100:
			case NL:
				_localctx = new ProgramFileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				program();
				setState(65);
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
			setState(100);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
					{
					setState(69);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(70);
						match(T__0);
						setState(71);
						((SequentContext)_localctx).formula = formula(0);
						((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
						}
						}
						setState(76);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(79);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(80);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(81);
					match(T__0);
					setState(82);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
					{
					{
					setState(88);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(94);
				match(HLINE);
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(98); 
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
			setState(102);
			((ProofContext)_localctx).tb = match(T__3);
			setState(104);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(103);
				proofStep();
				}
			}

			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(107); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(106);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(109); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(112);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(111);
					proofStep();
					}
				}

				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
			((ProofContext)_localctx).te = match(T__4);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(120);
					match(NL);
					}
					} 
				}
				setState(125);
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
			setState(180);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(NUM);
				setState(127);
				match(T__5);
				setState(128);
				formula(0);
				setState(129);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(132);
				match(T__5);
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(133);
					match(NL);
					}
					}
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(139);
				match(T__3);
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
				((SubProofContext)_localctx).assume = match(NUM);
				setState(147);
				match(T__5);
				setState(164);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(148);
					match(ID);
					setState(151);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(149);
						match(T__6);
						setState(150);
						type();
						}
					}

					}
					break;
				case 2:
					{
					setState(153);
					formula(0);
					setState(154);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				case 3:
					{
					setState(156);
					match(ID);
					setState(159);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(157);
						match(T__6);
						setState(158);
						type();
						}
					}

					setState(161);
					formula(0);
					setState(162);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(167); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(166);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(169); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(172);
					_la = _input.LA(1);
					if (_la==NUM) {
						{
						setState(171);
						proofStep();
						}
					}

					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(179);
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
			setState(229);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(183);
				((UnaryContext)_localctx).op = match(T__24);
				setState(184);
				formula(9);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(186);
				formula(6);
				}
				break;
			case 3:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
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
				setState(188);
				((VarContext)_localctx).tb = match(ID);
				setState(191);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(189);
					match(T__5);
					setState(190);
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
				setState(193);
				match(T__15);
				setState(194);
				formula(0);
				setState(195);
				match(T__16);
				}
				break;
			case 6:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(T__17);
				}
				break;
			case 7:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				match(ID);
				setState(199);
				match(T__15);
				setState(200);
				formula(0);
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(201);
					match(T__0);
					setState(202);
					formula(0);
					}
					}
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(208);
				match(T__16);
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				match(NUM);
				}
				break;
			case 9:
				{
				_localctx = new BigIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				match(T__18);
				setState(212);
				match(T__15);
				setState(213);
				match(STRING);
				setState(214);
				match(T__16);
				}
				break;
			case 10:
				{
				_localctx = new SeqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215);
				match(T__19);
				setState(216);
				match(T__15);
				setState(225);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)))) != 0)) {
					{
					setState(217);
					exp(0);
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(218);
						match(T__0);
						setState(219);
						exp(0);
						}
						}
						setState(224);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(227);
				match(T__16);
				}
				break;
			case 11:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(279);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(231);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(232);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
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
						((BinaryContext)_localctx).r = formula(12);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(237);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(238);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
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
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(243);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(244);
						((BinaryContext)_localctx).op = match(T__26);
						setState(246);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(245);
							match(NL);
							}
						}

						setState(248);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(249);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(250);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(252);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(251);
							match(NL);
							}
						}

						setState(254);
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(255);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(256);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(258);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(257);
							match(NL);
							}
						}

						setState(260);
						((BinaryContext)_localctx).r = formula(6);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(261);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(262);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(264);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(263);
							match(NL);
							}
						}

						setState(266);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(267);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(268);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(270);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(269);
							match(NL);
							}
						}

						setState(272);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(273);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(274);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__50) | (1L << T__51) | (1L << T__52))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(276);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(275);
							match(NL);
							}
						}

						setState(278);
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(283);
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
			setState(284);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(285);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(286);
				match(T__0);
				setState(287);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(308);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(293);
				match(T__6);
				setState(294);
				type();
				}
				break;
			case 2:
				{
				setState(295);
				match(T__6);
				setState(296);
				match(T__15);
				setState(297);
				((QformulaContext)_localctx).lo = exp(0);
				setState(299);
				_la = _input.LA(1);
				if (_la==T__36) {
					{
					setState(298);
					((QformulaContext)_localctx).ll = match(T__36);
					}
				}

				setState(301);
				match(T__61);
				setState(303);
				_la = _input.LA(1);
				if (_la==T__36) {
					{
					setState(302);
					((QformulaContext)_localctx).lh = match(T__36);
					}
				}

				setState(305);
				((QformulaContext)_localctx).hi = exp(0);
				setState(306);
				match(T__16);
				}
				break;
			}
			setState(311);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(310);
				match(NL);
				}
			}

			setState(313);
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
			setState(318);
			switch (_input.LA(1)) {
			case T__62:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(315);
				((BooleanTypeContext)_localctx).t = match(T__62);
				}
				break;
			case T__18:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
				((IntTypeContext)_localctx).t = match(T__18);
				}
				break;
			case T__19:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(317);
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
		public Token step;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
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
		public Token step;
		public Token subproof;
		public Token t;
		public Token subProof;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
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
		public Token eqStep;
		public Token step;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public Subst2Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AutoContext extends JustificationContext {
		public Token tb;
		public Token NUM;
		public List<Token> steps = new ArrayList<Token>();
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public AutoContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class Subst1Context extends JustificationContext {
		public Token tb;
		public Token eqStep;
		public Token step;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public Subst1Context(JustificationContext ctx) { copyFrom(ctx); }
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
	public static class FctContext extends JustificationContext {
		public Token tb;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public FctContext(JustificationContext ctx) { copyFrom(ctx); }
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
			setState(453);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				((PremiseContext)_localctx).t = match(T__63);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				switch (_input.LA(1)) {
				case T__64:
					{
					setState(321);
					((AndIntroContext)_localctx).tb = match(T__64);
					}
					break;
				case T__43:
				case T__44:
				case T__45:
					{
					setState(322);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(323);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(326);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(327);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(331);
				switch (_input.LA(1)) {
				case T__65:
				case T__66:
					{
					setState(328);
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
					setState(329);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(337);
				switch (_input.LA(1)) {
				case T__67:
				case T__68:
				case T__69:
				case T__70:
					{
					setState(334);
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
					setState(335);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__47 || _la==T__49) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(343);
				switch (_input.LA(1)) {
				case T__71:
				case T__72:
					{
					setState(340);
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
					setState(341);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__47 || _la==T__49) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(346);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(347);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(348);
				((ImpliesIntroContext)_localctx).tb = match(T__73);
				setState(349);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(350);
				((ImpliesElimContext)_localctx).tb = match(T__74);
				setState(351);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(352);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(353);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(354);
				((ImpliesIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__51 || _la==T__52) ) {
					((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(355);
				match(ID);
				setState(356);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(357);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				      "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n      \"e\".equals(_input.LT(2).getText())");
				setState(358);
				((ImpliesElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__51 || _la==T__52) ) {
					((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(359);
				match(ID);
				setState(360);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(361);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(362);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__75 || _la==T__76) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(363);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 11:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(364);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__77 || _la==T__78) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(365);
				((NegElimContext)_localctx).step = match(NUM);
				setState(366);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 12:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(367);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(368);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(369);
				match(ID);
				setState(370);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(371);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(372);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(373);
				match(ID);
				setState(374);
				((NegElimContext)_localctx).step = match(NUM);
				setState(375);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 14:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(379);
				switch (_input.LA(1)) {
				case T__79:
				case T__80:
					{
					setState(376);
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
					setState(377);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==T__14) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(378);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(381);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 15:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(382);
				((PbcContext)_localctx).tb = match(T__81);
				setState(383);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 16:
				_localctx = new Subst1Context(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(384);
				((Subst1Context)_localctx).tb = match(T__82);
				setState(385);
				((Subst1Context)_localctx).eqStep = match(NUM);
				setState(386);
				((Subst1Context)_localctx).step = match(NUM);
				}
				break;
			case 17:
				_localctx = new Subst2Context(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(387);
				((Subst2Context)_localctx).tb = match(T__83);
				setState(388);
				((Subst2Context)_localctx).eqStep = match(NUM);
				setState(389);
				((Subst2Context)_localctx).step = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(390);
				((AlgebraContext)_localctx).tb = match(T__84);
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(391);
					((AlgebraContext)_localctx).NUM = match(NUM);
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).NUM);
					}
					}
					setState(396);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(397);
				((ForallIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__87 - 86)))) != 0)) ) {
					((ForallIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(398);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 20:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(399);
				((ForallElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (T__88 - 89)) | (1L << (T__89 - 89)) | (1L << (T__90 - 89)))) != 0)) ) {
					((ForallElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(400);
				((ForallElimContext)_localctx).step = match(NUM);
				setState(402); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(401);
					formula(0);
					}
					}
					setState(404); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 21:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(406);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(407);
				((ForallIntroContext)_localctx).tb = match(T__56);
				setState(408);
				match(ID);
				setState(409);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 22:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(410);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(411);
				((ForallElimContext)_localctx).tb = match(T__56);
				setState(412);
				match(ID);
				setState(413);
				((ForallElimContext)_localctx).step = match(NUM);
				setState(415); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(414);
					formula(0);
					}
					}
					setState(417); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 23:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(419);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (T__91 - 92)) | (1L << (T__92 - 92)) | (1L << (T__93 - 92)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(420);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(422); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(421);
					formula(0);
					}
					}
					setState(424); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 24:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(426);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (T__94 - 95)) | (1L << (T__95 - 95)) | (1L << (T__96 - 95)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(427);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(428);
				((ExistsElimContext)_localctx).subproof = match(NUM);
				}
				break;
			case 25:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(429);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(430);
				((ExistsIntroContext)_localctx).tb = match(T__60);
				setState(431);
				match(ID);
				setState(432);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(434); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(433);
					formula(0);
					}
					}
					setState(436); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 26:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(438);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(439);
				((ExistsElimContext)_localctx).tb = match(T__60);
				setState(440);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(441);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(442);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 27:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(443);
				((InvariantContext)_localctx).tb = match(T__97);
				}
				break;
			case 28:
				_localctx = new FctContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(444);
				((FctContext)_localctx).tb = match(T__98);
				setState(445);
				match(ID);
				}
				break;
			case 29:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(446);
				((AutoContext)_localctx).tb = match(T__99);
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(447);
					((AutoContext)_localctx).NUM = match(NUM);
					((AutoContext)_localctx).steps.add(((AutoContext)_localctx).NUM);
					}
					}
					setState(452);
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
		enterRule(_localctx, 16, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(455);
				match(NL);
				}
				}
				setState(460);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(469);
			_la = _input.LA(1);
			if (_la==T__100) {
				{
				setState(461);
				impor();
				setState(463); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(462);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(465); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(467);
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
		enterRule(_localctx, 18, RULE_impor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			((ImporContext)_localctx).tb = match(T__100);
			setState(472);
			((ImporContext)_localctx).org = match(ID);
			setState(473);
			match(T__5);
			setState(474);
			((ImporContext)_localctx).sireum = match(ID);
			setState(475);
			match(T__5);
			setState(476);
			((ImporContext)_localctx).logika = match(ID);
			setState(477);
			match(T__5);
			setState(478);
			((ImporContext)_localctx).te = match(T__101);
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
		public List<FactOrFunContext> factOrFun() {
			return getRuleContexts(FactOrFunContext.class);
		}
		public FactOrFunContext factOrFun(int i) {
			return getRuleContext(FactOrFunContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public FactsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_facts; }
	}

	public final FactsContext facts() throws RecognitionException {
		FactsContext _localctx = new FactsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_facts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			match(T__3);
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
			((FactsContext)_localctx).ftb = match(T__98);
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(488);
				match(NL);
				}
				}
				setState(493);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(494);
			factOrFun();
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
					_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(501);
				_la = _input.LA(1);
				if (_la==T__102 || _la==ID) {
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
		enterRule(_localctx, 22, RULE_factOrFun);
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
			case T__102:
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
		enterRule(_localctx, 24, RULE_fact);
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
		enterRule(_localctx, 26, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			((FunContext)_localctx).tb = match(T__102);
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
			match(T__15);
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
			match(T__16);
			setState(538);
			match(T__6);
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
		enterRule(_localctx, 28, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			match(ID);
			setState(542);
			match(T__6);
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
		enterRule(_localctx, 30, RULE_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & ((1L << (T__100 - 101)) | (1L << (T__102 - 101)) | (1L << (T__103 - 101)) | (1L << (T__104 - 101)) | (1L << (T__105 - 101)) | (1L << (T__106 - 101)) | (1L << (T__108 - 101)) | (1L << (T__109 - 101)) | (1L << (T__111 - 101)) | (1L << (T__112 - 101)) | (1L << (T__113 - 101)) | (1L << (T__116 - 101)) | (1L << (T__117 - 101)) | (1L << (NUM - 101)) | (1L << (ID - 101)))) != 0)) {
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
					_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(554);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & ((1L << (T__100 - 101)) | (1L << (T__102 - 101)) | (1L << (T__103 - 101)) | (1L << (T__104 - 101)) | (1L << (T__105 - 101)) | (1L << (T__106 - 101)) | (1L << (T__108 - 101)) | (1L << (T__109 - 101)) | (1L << (T__111 - 101)) | (1L << (T__112 - 101)) | (1L << (T__113 - 101)) | (1L << (T__116 - 101)) | (1L << (T__117 - 101)) | (1L << (NUM - 101)) | (1L << (ID - 101)))) != 0)) {
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
		enterRule(_localctx, 32, RULE_stmt);
		int _la;
		try {
			setState(740);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(561);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__103 || _la==T__104) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(562);
				match(ID);
				setState(563);
				match(T__6);
				setState(564);
				type();
				setState(565);
				match(T__27);
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
				match(T__27);
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
				_localctx = new AssumeStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(577);
				match(T__7);
				setState(578);
				match(T__15);
				setState(579);
				exp(0);
				setState(580);
				match(T__16);
				}
				break;
			case 4:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(582);
				match(T__105);
				setState(583);
				match(T__15);
				setState(584);
				exp(0);
				setState(585);
				match(T__16);
				}
				break;
			case 5:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(587);
				match(T__106);
				setState(588);
				match(T__15);
				setState(589);
				exp(0);
				setState(590);
				match(T__16);
				setState(594);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(591);
					match(NL);
					}
					}
					setState(596);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(597);
				match(T__3);
				setState(598);
				((IfStmtContext)_localctx).ts = stmts();
				setState(599);
				match(T__4);
				setState(611);
				_la = _input.LA(1);
				if (_la==T__107) {
					{
					setState(600);
					match(T__107);
					setState(604);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(601);
						match(NL);
						}
						}
						setState(606);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(607);
					match(T__3);
					setState(608);
					((IfStmtContext)_localctx).fs = stmts();
					setState(609);
					match(T__4);
					}
				}

				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(613);
				match(T__108);
				setState(614);
				match(T__15);
				setState(615);
				exp(0);
				setState(616);
				match(T__16);
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
				match(T__3);
				setState(634);
				switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
				case 1:
					{
					setState(627);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(624);
						match(NL);
						}
						}
						setState(629);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(630);
					match(T__109);
					setState(631);
					loopInvariant();
					setState(632);
					match(T__110);
					}
					break;
				}
				setState(636);
				stmts();
				setState(637);
				match(T__4);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(639);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__111 || _la==T__112) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(640);
				match(T__15);
				setState(649);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)) | (1L << (STRING - 117)))) != 0)) {
					{
					setState(641);
					stringOrExp();
					setState(646);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(642);
						match(T__0);
						setState(643);
						stringOrExp();
						}
						}
						setState(648);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(651);
				match(T__16);
				}
				break;
			case 8:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(652);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(653);
				match(T__15);
				setState(654);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(655);
				match(T__16);
				setState(656);
				match(T__27);
				setState(658);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(657);
					match(NL);
					}
				}

				setState(660);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 9:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(664);
				_la = _input.LA(1);
				if (_la==T__113) {
					{
					setState(662);
					match(T__113);
					setState(663);
					((MethodDeclStmtContext)_localctx).helper = match(ID);
					}
				}

				setState(666);
				match(T__102);
				setState(667);
				((MethodDeclStmtContext)_localctx).id = match(ID);
				setState(669);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(668);
					match(NL);
					}
				}

				setState(671);
				match(T__15);
				setState(680);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(672);
					param();
					setState(677);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(673);
						match(T__0);
						setState(674);
						param();
						}
						}
						setState(679);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(682);
				match(T__16);
				setState(683);
				match(T__6);
				setState(686);
				switch (_input.LA(1)) {
				case T__18:
				case T__19:
				case T__62:
					{
					setState(684);
					type();
					}
					break;
				case T__114:
					{
					setState(685);
					match(T__114);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(688);
				match(T__27);
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
				match(T__3);
				setState(712);
				switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
				case 1:
					{
					setState(699);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(696);
						match(NL);
						}
						}
						setState(701);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(702);
					match(T__109);
					setState(703);
					methodContract();
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
					match(T__110);
					}
					break;
				}
				setState(714);
				stmts();
				setState(725);
				_la = _input.LA(1);
				if (_la==T__115) {
					{
					setState(715);
					((MethodDeclStmtContext)_localctx).rtb = match(T__115);
					setState(717);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)))) != 0)) {
						{
						setState(716);
						exp(0);
						}
					}

					setState(722);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(719);
						match(NL);
						}
						}
						setState(724);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(727);
				match(T__4);
				}
				break;
			case 10:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(729);
				match(T__109);
				setState(734);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(730);
					proof();
					}
					break;
				case 2:
					{
					setState(731);
					sequent();
					}
					break;
				case 3:
					{
					setState(732);
					invariants();
					}
					break;
				case 4:
					{
					setState(733);
					facts();
					}
					break;
				}
				setState(736);
				match(T__110);
				}
				break;
			case 11:
				_localctx = new ImportStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(738);
				impor();
				}
				break;
			case 12:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(739);
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
		enterRule(_localctx, 34, RULE_stringOrExp);
		try {
			setState(744);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(742);
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
				setState(743);
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
			switch (_input.LA(1)) {
			case T__24:
			case T__33:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(747);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__33) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(748);
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
				setState(749);
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
				setState(750);
				match(NUM);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(751);
				((IdExpContext)_localctx).tb = match(ID);
				setState(766);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(752);
					((IdExpContext)_localctx).t = match(T__15);
					setState(761);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)))) != 0)) {
						{
						setState(753);
						exp(0);
						setState(758);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__0) {
							{
							{
							setState(754);
							match(T__0);
							setState(755);
							exp(0);
							}
							}
							setState(760);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(763);
					match(T__16);
					}
					break;
				case 2:
					{
					setState(764);
					match(T__5);
					setState(765);
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
				setState(768);
				match(T__18);
				setState(769);
				match(T__15);
				setState(770);
				match(STRING);
				setState(771);
				match(T__16);
				}
				break;
			case T__19:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(772);
				match(T__19);
				setState(773);
				match(T__15);
				setState(782);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)))) != 0)) {
					{
					setState(774);
					exp(0);
					setState(779);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(775);
						match(T__0);
						setState(776);
						exp(0);
						}
						}
						setState(781);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(784);
				match(T__16);
				}
				break;
			case T__116:
				{
				_localctx = new RandomIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(785);
				match(T__116);
				setState(786);
				match(T__15);
				setState(787);
				match(T__16);
				}
				break;
			case T__117:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(788);
				match(T__117);
				setState(789);
				match(T__15);
				setState(791);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(790);
					match(STRING);
					}
				}

				setState(793);
				match(T__16);
				}
				break;
			case T__15:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(794);
				match(T__15);
				setState(795);
				exp(0);
				setState(796);
				match(T__16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(844);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(842);
					switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(800);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(801);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(803);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(802);
							match(NL);
							}
						}

						setState(805);
						((BinaryExpContext)_localctx).r = exp(8);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(806);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(807);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(809);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(808);
							match(NL);
							}
						}

						setState(811);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(812);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(813);
						((BinaryExpContext)_localctx).op = match(T__26);
						setState(815);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(814);
							match(NL);
							}
						}

						setState(817);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(818);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(819);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(821);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(820);
							match(NL);
							}
						}

						setState(823);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(824);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(825);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(827);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(826);
							match(NL);
							}
						}

						setState(829);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(830);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(831);
						((BinaryExpContext)_localctx).op = match(T__43);
						setState(833);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(832);
							match(NL);
							}
						}

						setState(835);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(836);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(837);
						((BinaryExpContext)_localctx).op = match(T__47);
						setState(839);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(838);
							match(NL);
							}
						}

						setState(841);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(846);
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
		public Token te;
		public Token itb;
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
		enterRule(_localctx, 38, RULE_loopInvariant);
		int _la;
		try {
			int _alt;
			setState(900);
			switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(847);
				((LoopInvariantContext)_localctx).tb = match(T__3);
				setState(851);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(848);
					match(NL);
					}
					}
					setState(853);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(854);
				modifies();
				setState(855);
				((LoopInvariantContext)_localctx).te = match(T__4);
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
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(862);
				((LoopInvariantContext)_localctx).tb = match(T__3);
				setState(866);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(863);
					match(NL);
					}
					}
					setState(868);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(869);
				((LoopInvariantContext)_localctx).itb = match(T__97);
				setState(873);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(870);
					match(NL);
					}
					}
					setState(875);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(876);
				formula(0);
				setState(887);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(878); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(877);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(880); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(883);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
						{
						setState(882);
						formula(0);
						}
					}

					}
					}
					setState(889);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(891);
				_la = _input.LA(1);
				if (_la==T__118) {
					{
					setState(890);
					modifies();
					}
				}

				setState(893);
				((LoopInvariantContext)_localctx).te = match(T__4);
				setState(897);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(894);
					match(NL);
					}
					}
					setState(899);
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
		enterRule(_localctx, 40, RULE_modifies);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(902);
			((ModifiesContext)_localctx).tb = match(T__118);
			setState(903);
			match(ID);
			setState(908);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(904);
				match(T__0);
				setState(905);
				match(ID);
				}
				}
				setState(910);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		enterRule(_localctx, 42, RULE_methodContract);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(917);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(921);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(918);
					match(NL);
					}
					} 
				}
				setState(923);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
			}
			setState(945);
			_la = _input.LA(1);
			if (_la==T__119 || _la==T__120) {
				{
				setState(924);
				_la = _input.LA(1);
				if ( !(_la==T__119 || _la==T__120) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(928);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(925);
					match(NL);
					}
					}
					setState(930);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(931);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(942);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(933); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(932);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(935); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(938);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
							{
							setState(937);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(944);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
				}
				}
			}

			setState(950);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(947);
					match(NL);
					}
					} 
				}
				setState(952);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
			}
			setState(954);
			_la = _input.LA(1);
			if (_la==T__118) {
				{
				setState(953);
				modifies();
				}
			}

			setState(977);
			_la = _input.LA(1);
			if (_la==T__121 || _la==T__122) {
				{
				setState(956);
				_la = _input.LA(1);
				if ( !(_la==T__121 || _la==T__122) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(960);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(957);
					match(NL);
					}
					}
					setState(962);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(963);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(974);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(965); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(964);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(967); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(970);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
							{
							setState(969);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(976);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
				}
				}
			}

			setState(982);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(979);
				match(NL);
				}
				}
				setState(984);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(985);
			((MethodContractContext)_localctx).te = match(T__4);
			setState(989);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(986);
					match(NL);
					}
					} 
				}
				setState(991);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
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
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
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
			setState(992);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(996);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(993);
				match(NL);
				}
				}
				setState(998);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(999);
			match(T__97);
			setState(1003);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1000);
				match(NL);
				}
				}
				setState(1005);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1006);
			formula(0);
			setState(1017);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1008); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1007);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1010); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1013);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
					{
					setState(1012);
					formula(0);
					}
				}

				}
				}
				setState(1019);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1020);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(1024);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1021);
				match(NL);
				}
				}
				setState(1026);
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
		case 18:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0087\u0406\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\7"+
		"\2\63\n\2\f\2\16\2\66\13\2\3\2\5\29\n\2\3\2\7\2<\n\2\f\2\16\2?\13\2\3"+
		"\2\3\2\3\2\3\2\3\2\5\2F\n\2\3\3\3\3\3\3\7\3K\n\3\f\3\16\3N\13\3\5\3P\n"+
		"\3\3\3\3\3\3\3\3\3\7\3V\n\3\f\3\16\3Y\13\3\3\3\7\3\\\n\3\f\3\16\3_\13"+
		"\3\3\3\3\3\6\3c\n\3\r\3\16\3d\5\3g\n\3\3\4\3\4\5\4k\n\4\3\4\6\4n\n\4\r"+
		"\4\16\4o\3\4\5\4s\n\4\7\4u\n\4\f\4\16\4x\13\4\3\4\3\4\7\4|\n\4\f\4\16"+
		"\4\177\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0089\n\5\f\5\16\5\u008c"+
		"\13\5\3\5\3\5\7\5\u0090\n\5\f\5\16\5\u0093\13\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5\u009a\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00a2\n\5\3\5\3\5\3\5\5\5\u00a7"+
		"\n\5\3\5\6\5\u00aa\n\5\r\5\16\5\u00ab\3\5\5\5\u00af\n\5\7\5\u00b1\n\5"+
		"\f\5\16\5\u00b4\13\5\3\5\5\5\u00b7\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\5\6\u00c2\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00ce\n"+
		"\6\f\6\16\6\u00d1\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\7\6\u00df\n\6\f\6\16\6\u00e2\13\6\5\6\u00e4\n\6\3\6\3\6\5\6\u00e8\n\6"+
		"\3\6\3\6\3\6\5\6\u00ed\n\6\3\6\3\6\3\6\3\6\5\6\u00f3\n\6\3\6\3\6\3\6\3"+
		"\6\5\6\u00f9\n\6\3\6\3\6\3\6\3\6\5\6\u00ff\n\6\3\6\3\6\3\6\3\6\5\6\u0105"+
		"\n\6\3\6\3\6\3\6\3\6\5\6\u010b\n\6\3\6\3\6\3\6\3\6\5\6\u0111\n\6\3\6\3"+
		"\6\3\6\3\6\5\6\u0117\n\6\3\6\7\6\u011a\n\6\f\6\16\6\u011d\13\6\3\7\3\7"+
		"\3\7\3\7\7\7\u0123\n\7\f\7\16\7\u0126\13\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"\u012e\n\7\3\7\3\7\5\7\u0132\n\7\3\7\3\7\3\7\5\7\u0137\n\7\3\7\5\7\u013a"+
		"\n\7\3\7\3\7\3\b\3\b\3\b\5\b\u0141\n\b\3\t\3\t\3\t\3\t\5\t\u0147\n\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u014e\n\t\3\t\3\t\3\t\3\t\5\t\u0154\n\t\3\t\3\t"+
		"\3\t\3\t\5\t\u015a\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u017e\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\7\t\u018b\n\t\f\t\16\t\u018e\13\t\3\t\3\t\3\t\3\t\3\t\6\t\u0195"+
		"\n\t\r\t\16\t\u0196\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\t\u01a2\n\t"+
		"\r\t\16\t\u01a3\3\t\3\t\3\t\6\t\u01a9\n\t\r\t\16\t\u01aa\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\6\t\u01b5\n\t\r\t\16\t\u01b6\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\7\t\u01c3\n\t\f\t\16\t\u01c6\13\t\5\t\u01c8\n\t\3\n"+
		"\7\n\u01cb\n\n\f\n\16\n\u01ce\13\n\3\n\3\n\6\n\u01d2\n\n\r\n\16\n\u01d3"+
		"\3\n\3\n\5\n\u01d8\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\7\f\u01e5\n\f\f\f\16\f\u01e8\13\f\3\f\3\f\7\f\u01ec\n\f\f\f\16"+
		"\f\u01ef\13\f\3\f\3\f\6\f\u01f3\n\f\r\f\16\f\u01f4\3\f\5\f\u01f8\n\f\7"+
		"\f\u01fa\n\f\f\f\16\f\u01fd\13\f\3\f\3\f\7\f\u0201\n\f\f\f\16\f\u0204"+
		"\13\f\3\r\3\r\5\r\u0208\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u0211"+
		"\n\17\3\17\3\17\3\17\3\17\7\17\u0217\n\17\f\17\16\17\u021a\13\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\5\21\u0225\n\21\3\21\6\21\u0228"+
		"\n\21\r\21\16\21\u0229\3\21\5\21\u022d\n\21\7\21\u022f\n\21\f\21\16\21"+
		"\u0232\13\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u023a\n\22\3\22\3\22\3"+
		"\22\3\22\3\22\5\22\u0241\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0253\n\22\f\22\16\22\u0256"+
		"\13\22\3\22\3\22\3\22\3\22\3\22\7\22\u025d\n\22\f\22\16\22\u0260\13\22"+
		"\3\22\3\22\3\22\3\22\5\22\u0266\n\22\3\22\3\22\3\22\3\22\3\22\7\22\u026d"+
		"\n\22\f\22\16\22\u0270\13\22\3\22\3\22\7\22\u0274\n\22\f\22\16\22\u0277"+
		"\13\22\3\22\3\22\3\22\3\22\5\22\u027d\n\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\7\22\u0287\n\22\f\22\16\22\u028a\13\22\5\22\u028c\n\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0295\n\22\3\22\3\22\3\22\3\22"+
		"\5\22\u029b\n\22\3\22\3\22\3\22\5\22\u02a0\n\22\3\22\3\22\3\22\3\22\7"+
		"\22\u02a6\n\22\f\22\16\22\u02a9\13\22\5\22\u02ab\n\22\3\22\3\22\3\22\3"+
		"\22\5\22\u02b1\n\22\3\22\3\22\7\22\u02b5\n\22\f\22\16\22\u02b8\13\22\3"+
		"\22\3\22\7\22\u02bc\n\22\f\22\16\22\u02bf\13\22\3\22\3\22\3\22\7\22\u02c4"+
		"\n\22\f\22\16\22\u02c7\13\22\3\22\3\22\5\22\u02cb\n\22\3\22\3\22\3\22"+
		"\5\22\u02d0\n\22\3\22\7\22\u02d3\n\22\f\22\16\22\u02d6\13\22\5\22\u02d8"+
		"\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u02e1\n\22\3\22\3\22\3\22"+
		"\3\22\5\22\u02e7\n\22\3\23\3\23\5\23\u02eb\n\23\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\7\24\u02f7\n\24\f\24\16\24\u02fa\13\24\5"+
		"\24\u02fc\n\24\3\24\3\24\3\24\5\24\u0301\n\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\7\24\u030c\n\24\f\24\16\24\u030f\13\24\5\24\u0311"+
		"\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u031a\n\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u0321\n\24\3\24\3\24\3\24\5\24\u0326\n\24\3\24\3\24\3"+
		"\24\3\24\5\24\u032c\n\24\3\24\3\24\3\24\3\24\5\24\u0332\n\24\3\24\3\24"+
		"\3\24\3\24\5\24\u0338\n\24\3\24\3\24\3\24\3\24\5\24\u033e\n\24\3\24\3"+
		"\24\3\24\3\24\5\24\u0344\n\24\3\24\3\24\3\24\3\24\5\24\u034a\n\24\3\24"+
		"\7\24\u034d\n\24\f\24\16\24\u0350\13\24\3\25\3\25\7\25\u0354\n\25\f\25"+
		"\16\25\u0357\13\25\3\25\3\25\3\25\7\25\u035c\n\25\f\25\16\25\u035f\13"+
		"\25\3\25\3\25\7\25\u0363\n\25\f\25\16\25\u0366\13\25\3\25\3\25\7\25\u036a"+
		"\n\25\f\25\16\25\u036d\13\25\3\25\3\25\6\25\u0371\n\25\r\25\16\25\u0372"+
		"\3\25\5\25\u0376\n\25\7\25\u0378\n\25\f\25\16\25\u037b\13\25\3\25\5\25"+
		"\u037e\n\25\3\25\3\25\7\25\u0382\n\25\f\25\16\25\u0385\13\25\5\25\u0387"+
		"\n\25\3\26\3\26\3\26\3\26\7\26\u038d\n\26\f\26\16\26\u0390\13\26\3\26"+
		"\7\26\u0393\n\26\f\26\16\26\u0396\13\26\3\27\3\27\7\27\u039a\n\27\f\27"+
		"\16\27\u039d\13\27\3\27\3\27\7\27\u03a1\n\27\f\27\16\27\u03a4\13\27\3"+
		"\27\3\27\6\27\u03a8\n\27\r\27\16\27\u03a9\3\27\5\27\u03ad\n\27\7\27\u03af"+
		"\n\27\f\27\16\27\u03b2\13\27\5\27\u03b4\n\27\3\27\7\27\u03b7\n\27\f\27"+
		"\16\27\u03ba\13\27\3\27\5\27\u03bd\n\27\3\27\3\27\7\27\u03c1\n\27\f\27"+
		"\16\27\u03c4\13\27\3\27\3\27\6\27\u03c8\n\27\r\27\16\27\u03c9\3\27\5\27"+
		"\u03cd\n\27\7\27\u03cf\n\27\f\27\16\27\u03d2\13\27\5\27\u03d4\n\27\3\27"+
		"\7\27\u03d7\n\27\f\27\16\27\u03da\13\27\3\27\3\27\7\27\u03de\n\27\f\27"+
		"\16\27\u03e1\13\27\3\30\3\30\7\30\u03e5\n\30\f\30\16\30\u03e8\13\30\3"+
		"\30\3\30\7\30\u03ec\n\30\f\30\16\30\u03ef\13\30\3\30\3\30\6\30\u03f3\n"+
		"\30\r\30\16\30\u03f4\3\30\5\30\u03f8\n\30\7\30\u03fa\n\30\f\30\16\30\u03fd"+
		"\13\30\3\30\3\30\7\30\u0401\n\30\f\30\16\30\u0404\13\30\3\30\2\4\n&\31"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2#\3\2\4\5\3\2\"&\3\2"+
		"\13\21\3\2\27\31\3\2\32\34\3\2\36!\3\2\',\3\2-\60\3\2\61\64\3\2\65\67"+
		"\3\28?\3\2.\60\3\2DE\3\2FI\4\2\62\62\64\64\3\2JK\3\2\66\67\3\2NO\3\2P"+
		"Q\3\2$&\3\2RS\3\2\20\21\3\2XZ\3\2[]\3\2^`\3\2ac\3\2jk\3\2rs\4\2\33\33"+
		"$$\4\2\'(*+\3\2\37 \3\2z{\3\2|}\u04c8\2E\3\2\2\2\4f\3\2\2\2\6h\3\2\2\2"+
		"\b\u00b6\3\2\2\2\n\u00e7\3\2\2\2\f\u011e\3\2\2\2\16\u0140\3\2\2\2\20\u01c7"+
		"\3\2\2\2\22\u01cc\3\2\2\2\24\u01d9\3\2\2\2\26\u01e2\3\2\2\2\30\u0207\3"+
		"\2\2\2\32\u0209\3\2\2\2\34\u020d\3\2\2\2\36\u021f\3\2\2\2 \u0224\3\2\2"+
		"\2\"\u02e6\3\2\2\2$\u02ea\3\2\2\2&\u0320\3\2\2\2(\u0386\3\2\2\2*\u0388"+
		"\3\2\2\2,\u0397\3\2\2\2.\u03e2\3\2\2\2\60\64\5\4\3\2\61\63\7\u0082\2\2"+
		"\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\658\3\2\2\2\66"+
		"\64\3\2\2\2\679\5\6\4\28\67\3\2\2\289\3\2\2\29=\3\2\2\2:<\7\u0082\2\2"+
		";:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7\2\2\3"+
		"AF\3\2\2\2BC\5\22\n\2CD\7\2\2\3DF\3\2\2\2E\60\3\2\2\2EB\3\2\2\2F\3\3\2"+
		"\2\2GL\5\n\6\2HI\7\3\2\2IK\5\n\6\2JH\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2"+
		"\2\2MP\3\2\2\2NL\3\2\2\2OG\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\t\2\2\2RW\5\n"+
		"\6\2ST\7\3\2\2TV\5\n\6\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2Xg\3\2"+
		"\2\2YW\3\2\2\2Z\\\5\n\6\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3"+
		"\2\2\2_]\3\2\2\2`b\7~\2\2ac\5\n\6\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3"+
		"\2\2\2eg\3\2\2\2fO\3\2\2\2f]\3\2\2\2g\5\3\2\2\2hj\7\6\2\2ik\5\b\5\2ji"+
		"\3\2\2\2jk\3\2\2\2kv\3\2\2\2ln\7\u0082\2\2ml\3\2\2\2no\3\2\2\2om\3\2\2"+
		"\2op\3\2\2\2pr\3\2\2\2qs\5\b\5\2rq\3\2\2\2rs\3\2\2\2su\3\2\2\2tm\3\2\2"+
		"\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2y}\7\7\2\2z|\7\u0082"+
		"\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\7\3\2\2\2\177}\3\2\2"+
		"\2\u0080\u0081\7\177\2\2\u0081\u0082\7\b\2\2\u0082\u0083\5\n\6\2\u0083"+
		"\u0084\5\20\t\2\u0084\u00b7\3\2\2\2\u0085\u0086\7\177\2\2\u0086\u008a"+
		"\7\b\2\2\u0087\u0089\7\u0082\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2"+
		"\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a"+
		"\3\2\2\2\u008d\u0091\7\6\2\2\u008e\u0090\7\u0082\2\2\u008f\u008e\3\2\2"+
		"\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094"+
		"\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7\177\2\2\u0095\u00a6\7\b\2\2"+
		"\u0096\u0099\7\u0080\2\2\u0097\u0098\7\t\2\2\u0098\u009a\5\16\b\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u00a7\3\2\2\2\u009b\u009c\5\n"+
		"\6\2\u009c\u009d\7\n\2\2\u009d\u00a7\3\2\2\2\u009e\u00a1\7\u0080\2\2\u009f"+
		"\u00a0\7\t\2\2\u00a0\u00a2\5\16\b\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3"+
		"\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\5\n\6\2\u00a4\u00a5\7\n\2\2\u00a5"+
		"\u00a7\3\2\2\2\u00a6\u0096\3\2\2\2\u00a6\u009b\3\2\2\2\u00a6\u009e\3\2"+
		"\2\2\u00a7\u00b2\3\2\2\2\u00a8\u00aa\7\u0082\2\2\u00a9\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2"+
		"\2\2\u00ad\u00af\5\b\5\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b1\3\2\2\2\u00b0\u00a9\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00b7\7\7\2\2\u00b6\u0080\3\2\2\2\u00b6\u0085\3\2\2\2\u00b7\t\3\2\2\2"+
		"\u00b8\u00b9\b\6\1\2\u00b9\u00ba\7\33\2\2\u00ba\u00e8\5\n\6\13\u00bb\u00bc"+
		"\t\3\2\2\u00bc\u00e8\5\n\6\b\u00bd\u00e8\t\4\2\2\u00be\u00c1\7\u0080\2"+
		"\2\u00bf\u00c0\7\b\2\2\u00c0\u00c2\7\u0080\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00e8\3\2\2\2\u00c3\u00c4\7\22\2\2\u00c4\u00c5\5"+
		"\n\6\2\u00c5\u00c6\7\23\2\2\u00c6\u00e8\3\2\2\2\u00c7\u00e8\7\24\2\2\u00c8"+
		"\u00c9\7\u0080\2\2\u00c9\u00ca\7\22\2\2\u00ca\u00cf\5\n\6\2\u00cb\u00cc"+
		"\7\3\2\2\u00cc\u00ce\5\n\6\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf\3\2"+
		"\2\2\u00d2\u00d3\7\23\2\2\u00d3\u00e8\3\2\2\2\u00d4\u00e8\7\177\2\2\u00d5"+
		"\u00d6\7\25\2\2\u00d6\u00d7\7\22\2\2\u00d7\u00d8\7\u0086\2\2\u00d8\u00e8"+
		"\7\23\2\2\u00d9\u00da\7\26\2\2\u00da\u00e3\7\22\2\2\u00db\u00e0\5&\24"+
		"\2\u00dc\u00dd\7\3\2\2\u00dd\u00df\5&\24\2\u00de\u00dc\3\2\2\2\u00df\u00e2"+
		"\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e3\u00db\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5\u00e8\7\23\2\2\u00e6\u00e8\5\f\7\2\u00e7\u00b8\3\2\2\2\u00e7"+
		"\u00bb\3\2\2\2\u00e7\u00bd\3\2\2\2\u00e7\u00be\3\2\2\2\u00e7\u00c3\3\2"+
		"\2\2\u00e7\u00c7\3\2\2\2\u00e7\u00c8\3\2\2\2\u00e7\u00d4\3\2\2\2\u00e7"+
		"\u00d5\3\2\2\2\u00e7\u00d9\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8\u011b\3\2"+
		"\2\2\u00e9\u00ea\f\r\2\2\u00ea\u00ec\t\5\2\2\u00eb\u00ed\7\u0082\2\2\u00ec"+
		"\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u011a\5\n"+
		"\6\16\u00ef\u00f0\f\f\2\2\u00f0\u00f2\t\6\2\2\u00f1\u00f3\7\u0082\2\2"+
		"\u00f2\u00f1\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u011a"+
		"\5\n\6\r\u00f5\u00f6\f\n\2\2\u00f6\u00f8\7\35\2\2\u00f7\u00f9\7\u0082"+
		"\2\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u011a\5\n\6\13\u00fb\u00fc\f\t\2\2\u00fc\u00fe\t\7\2\2\u00fd\u00ff\7"+
		"\u0082\2\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\3\2\2\2"+
		"\u0100\u011a\5\n\6\n\u0101\u0102\f\7\2\2\u0102\u0104\t\b\2\2\u0103\u0105"+
		"\7\u0082\2\2\u0104\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\3\2\2"+
		"\2\u0106\u011a\5\n\6\b\u0107\u0108\f\6\2\2\u0108\u010a\t\t\2\2\u0109\u010b"+
		"\7\u0082\2\2\u010a\u0109\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2"+
		"\2\u010c\u011a\5\n\6\7\u010d\u010e\f\5\2\2\u010e\u0110\t\n\2\2\u010f\u0111"+
		"\7\u0082\2\2\u0110\u010f\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\3\2\2"+
		"\2\u0112\u011a\5\n\6\6\u0113\u0114\f\4\2\2\u0114\u0116\t\13\2\2\u0115"+
		"\u0117\7\u0082\2\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118"+
		"\3\2\2\2\u0118\u011a\5\n\6\5\u0119\u00e9\3\2\2\2\u0119\u00ef\3\2\2\2\u0119"+
		"\u00f5\3\2\2\2\u0119\u00fb\3\2\2\2\u0119\u0101\3\2\2\2\u0119\u0107\3\2"+
		"\2\2\u0119\u010d\3\2\2\2\u0119\u0113\3\2\2\2\u011a\u011d\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\13\3\2\2\2\u011d\u011b\3\2\2"+
		"\2\u011e\u011f\t\f\2\2\u011f\u0124\7\u0080\2\2\u0120\u0121\7\3\2\2\u0121"+
		"\u0123\7\u0080\2\2\u0122\u0120\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122"+
		"\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0136\3\2\2\2\u0126\u0124\3\2\2\2\u0127"+
		"\u0128\7\t\2\2\u0128\u0137\5\16\b\2\u0129\u012a\7\t\2\2\u012a\u012b\7"+
		"\22\2\2\u012b\u012d\5&\24\2\u012c\u012e\7\'\2\2\u012d\u012c\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\7@\2\2\u0130\u0132\7\'"+
		"\2\2\u0131\u0130\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2\2\2\u0133"+
		"\u0134\5&\24\2\u0134\u0135\7\23\2\2\u0135\u0137\3\2\2\2\u0136\u0127\3"+
		"\2\2\2\u0136\u0129\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0139\3\2\2\2\u0138"+
		"\u013a\7\u0082\2\2\u0139\u0138\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b"+
		"\3\2\2\2\u013b\u013c\5\n\6\2\u013c\r\3\2\2\2\u013d\u0141\7A\2\2\u013e"+
		"\u0141\7\25\2\2\u013f\u0141\7\26\2\2\u0140\u013d\3\2\2\2\u0140\u013e\3"+
		"\2\2\2\u0140\u013f\3\2\2\2\u0141\17\3\2\2\2\u0142\u01c8\7B\2\2\u0143\u0147"+
		"\7C\2\2\u0144\u0145\t\r\2\2\u0145\u0147\7\u0080\2\2\u0146\u0143\3\2\2"+
		"\2\u0146\u0144\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\7\177\2\2\u0149"+
		"\u01c8\7\177\2\2\u014a\u014e\t\16\2\2\u014b\u014c\t\r\2\2\u014c\u014e"+
		"\7\u0080\2\2\u014d\u014a\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u014f\3\2\2"+
		"\2\u014f\u01c8\7\177\2\2\u0150\u0154\t\17\2\2\u0151\u0152\t\20\2\2\u0152"+
		"\u0154\7\u0080\2\2\u0153\u0150\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0155"+
		"\3\2\2\2\u0155\u01c8\7\177\2\2\u0156\u015a\t\21\2\2\u0157\u0158\t\20\2"+
		"\2\u0158\u015a\7\u0080\2\2\u0159\u0156\3\2\2\2\u0159\u0157\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b\u015c\7\177\2\2\u015c\u015d\7\177\2\2\u015d\u01c8"+
		"\7\177\2\2\u015e\u015f\7L\2\2\u015f\u01c8\7\177\2\2\u0160\u0161\7M\2\2"+
		"\u0161\u0162\7\177\2\2\u0162\u01c8\7\177\2\2\u0163\u0164\6\t\n\2\u0164"+
		"\u0165\t\22\2\2\u0165\u0166\7\u0080\2\2\u0166\u01c8\7\177\2\2\u0167\u0168"+
		"\6\t\13\2\u0168\u0169\t\22\2\2\u0169\u016a\7\u0080\2\2\u016a\u016b\7\177"+
		"\2\2\u016b\u01c8\7\177\2\2\u016c\u016d\t\23\2\2\u016d\u01c8\7\177\2\2"+
		"\u016e\u016f\t\24\2\2\u016f\u0170\7\177\2\2\u0170\u01c8\7\177\2\2\u0171"+
		"\u0172\6\t\f\2\u0172\u0173\t\25\2\2\u0173\u0174\7\u0080\2\2\u0174\u01c8"+
		"\7\177\2\2\u0175\u0176\6\t\r\2\u0176\u0177\t\25\2\2\u0177\u0178\7\u0080"+
		"\2\2\u0178\u0179\7\177\2\2\u0179\u01c8\7\177\2\2\u017a\u017e\t\26\2\2"+
		"\u017b\u017c\t\27\2\2\u017c\u017e\7\u0080\2\2\u017d\u017a\3\2\2\2\u017d"+
		"\u017b\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u01c8\7\177\2\2\u0180\u0181\7"+
		"T\2\2\u0181\u01c8\7\177\2\2\u0182\u0183\7U\2\2\u0183\u0184\7\177\2\2\u0184"+
		"\u01c8\7\177\2\2\u0185\u0186\7V\2\2\u0186\u0187\7\177\2\2\u0187\u01c8"+
		"\7\177\2\2\u0188\u018c\7W\2\2\u0189\u018b\7\177\2\2\u018a\u0189\3\2\2"+
		"\2\u018b\u018e\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u01c8"+
		"\3\2\2\2\u018e\u018c\3\2\2\2\u018f\u0190\t\30\2\2\u0190\u01c8\7\177\2"+
		"\2\u0191\u0192\t\31\2\2\u0192\u0194\7\177\2\2\u0193\u0195\5\n\6\2\u0194"+
		"\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197\3\2"+
		"\2\2\u0197\u01c8\3\2\2\2\u0198\u0199\6\t\16\2\u0199\u019a\7;\2\2\u019a"+
		"\u019b\7\u0080\2\2\u019b\u01c8\7\177\2\2\u019c\u019d\6\t\17\2\u019d\u019e"+
		"\7;\2\2\u019e\u019f\7\u0080\2\2\u019f\u01a1\7\177\2\2\u01a0\u01a2\5\n"+
		"\6\2\u01a1\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3"+
		"\u01a4\3\2\2\2\u01a4\u01c8\3\2\2\2\u01a5\u01a6\t\32\2\2\u01a6\u01a8\7"+
		"\177\2\2\u01a7\u01a9\5\n\6\2\u01a8\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa"+
		"\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01c8\3\2\2\2\u01ac\u01ad\t\33"+
		"\2\2\u01ad\u01ae\7\177\2\2\u01ae\u01c8\7\177\2\2\u01af\u01b0\6\t\20\2"+
		"\u01b0\u01b1\7?\2\2\u01b1\u01b2\7\u0080\2\2\u01b2\u01b4\7\177\2\2\u01b3"+
		"\u01b5\5\n\6\2\u01b4\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b4\3\2"+
		"\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01c8\3\2\2\2\u01b8\u01b9\6\t\21\2\u01b9"+
		"\u01ba\7?\2\2\u01ba\u01bb\7\u0080\2\2\u01bb\u01bc\7\177\2\2\u01bc\u01c8"+
		"\7\177\2\2\u01bd\u01c8\7d\2\2\u01be\u01bf\7e\2\2\u01bf\u01c8\7\u0080\2"+
		"\2\u01c0\u01c4\7f\2\2\u01c1\u01c3\7\177\2\2\u01c2\u01c1\3\2\2\2\u01c3"+
		"\u01c6\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c8\3\2"+
		"\2\2\u01c6\u01c4\3\2\2\2\u01c7\u0142\3\2\2\2\u01c7\u0146\3\2\2\2\u01c7"+
		"\u014d\3\2\2\2\u01c7\u0153\3\2\2\2\u01c7\u0159\3\2\2\2\u01c7\u015e\3\2"+
		"\2\2\u01c7\u0160\3\2\2\2\u01c7\u0163\3\2\2\2\u01c7\u0167\3\2\2\2\u01c7"+
		"\u016c\3\2\2\2\u01c7\u016e\3\2\2\2\u01c7\u0171\3\2\2\2\u01c7\u0175\3\2"+
		"\2\2\u01c7\u017d\3\2\2\2\u01c7\u0180\3\2\2\2\u01c7\u0182\3\2\2\2\u01c7"+
		"\u0185\3\2\2\2\u01c7\u0188\3\2\2\2\u01c7\u018f\3\2\2\2\u01c7\u0191\3\2"+
		"\2\2\u01c7\u0198\3\2\2\2\u01c7\u019c\3\2\2\2\u01c7\u01a5\3\2\2\2\u01c7"+
		"\u01ac\3\2\2\2\u01c7\u01af\3\2\2\2\u01c7\u01b8\3\2\2\2\u01c7\u01bd\3\2"+
		"\2\2\u01c7\u01be\3\2\2\2\u01c7\u01c0\3\2\2\2\u01c8\21\3\2\2\2\u01c9\u01cb"+
		"\7\u0082\2\2\u01ca\u01c9\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2"+
		"\2\u01cc\u01cd\3\2\2\2\u01cd\u01d7\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d1"+
		"\5\24\13\2\u01d0\u01d2\7\u0082\2\2\u01d1\u01d0\3\2\2\2\u01d2\u01d3\3\2"+
		"\2\2\u01d3\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5"+
		"\u01d6\5 \21\2\u01d6\u01d8\3\2\2\2\u01d7\u01cf\3\2\2\2\u01d7\u01d8\3\2"+
		"\2\2\u01d8\23\3\2\2\2\u01d9\u01da\7g\2\2\u01da\u01db\7\u0080\2\2\u01db"+
		"\u01dc\7\b\2\2\u01dc\u01dd\7\u0080\2\2\u01dd\u01de\7\b\2\2\u01de\u01df"+
		"\7\u0080\2\2\u01df\u01e0\7\b\2\2\u01e0\u01e1\7h\2\2\u01e1\25\3\2\2\2\u01e2"+
		"\u01e6\7\6\2\2\u01e3\u01e5\7\u0082\2\2\u01e4\u01e3\3\2\2\2\u01e5\u01e8"+
		"\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e9\3\2\2\2\u01e8"+
		"\u01e6\3\2\2\2\u01e9\u01ed\7e\2\2\u01ea\u01ec\7\u0082\2\2\u01eb\u01ea"+
		"\3\2\2\2\u01ec\u01ef\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee"+
		"\u01f0\3\2\2\2\u01ef\u01ed\3\2\2\2\u01f0\u01fb\5\30\r\2\u01f1\u01f3\7"+
		"\u0082\2\2\u01f2\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f2\3\2\2\2"+
		"\u01f4\u01f5\3\2\2\2\u01f5\u01f7\3\2\2\2\u01f6\u01f8\5\30\r\2\u01f7\u01f6"+
		"\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01fa\3\2\2\2\u01f9\u01f2\3\2\2\2\u01fa"+
		"\u01fd\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fe\3\2"+
		"\2\2\u01fd\u01fb\3\2\2\2\u01fe\u0202\7\7\2\2\u01ff\u0201\7\u0082\2\2\u0200"+
		"\u01ff\3\2\2\2\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2"+
		"\2\2\u0203\27\3\2\2\2\u0204\u0202\3\2\2\2\u0205\u0208\5\32\16\2\u0206"+
		"\u0208\5\34\17\2\u0207\u0205\3\2\2\2\u0207\u0206\3\2\2\2\u0208\31\3\2"+
		"\2\2\u0209\u020a\7\u0080\2\2\u020a\u020b\7\b\2\2\u020b\u020c\5\n\6\2\u020c"+
		"\33\3\2\2\2\u020d\u020e\7i\2\2\u020e\u0210\7\u0080\2\2\u020f\u0211\7\u0082"+
		"\2\2\u0210\u020f\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0212\3\2\2\2\u0212"+
		"\u0213\7\22\2\2\u0213\u0218\5\36\20\2\u0214\u0215\7\3\2\2\u0215\u0217"+
		"\5\36\20\2\u0216\u0214\3\2\2\2\u0217\u021a\3\2\2\2\u0218\u0216\3\2\2\2"+
		"\u0218\u0219\3\2\2\2\u0219\u021b\3\2\2\2\u021a\u0218\3\2\2\2\u021b\u021c"+
		"\7\23\2\2\u021c\u021d\7\t\2\2\u021d\u021e\5\16\b\2\u021e\35\3\2\2\2\u021f"+
		"\u0220\7\u0080\2\2\u0220\u0221\7\t\2\2\u0221\u0222\5\16\b\2\u0222\37\3"+
		"\2\2\2\u0223\u0225\5\"\22\2\u0224\u0223\3\2\2\2\u0224\u0225\3\2\2\2\u0225"+
		"\u0230\3\2\2\2\u0226\u0228\7\u0082\2\2\u0227\u0226\3\2\2\2\u0228\u0229"+
		"\3\2\2\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022c\3\2\2\2\u022b"+
		"\u022d\5\"\22\2\u022c\u022b\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022f\3"+
		"\2\2\2\u022e\u0227\3\2\2\2\u022f\u0232\3\2\2\2\u0230\u022e\3\2\2\2\u0230"+
		"\u0231\3\2\2\2\u0231!\3\2\2\2\u0232\u0230\3\2\2\2\u0233\u0234\t\34\2\2"+
		"\u0234\u0235\7\u0080\2\2\u0235\u0236\7\t\2\2\u0236\u0237\5\16\b\2\u0237"+
		"\u0239\7\36\2\2\u0238\u023a\7\u0082\2\2\u0239\u0238\3\2\2\2\u0239\u023a"+
		"\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\5&\24\2\u023c\u02e7\3\2\2\2\u023d"+
		"\u023e\7\u0080\2\2\u023e\u0240\7\36\2\2\u023f\u0241\7\u0082\2\2\u0240"+
		"\u023f\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u02e7\5&"+
		"\24\2\u0243\u0244\7\n\2\2\u0244\u0245\7\22\2\2\u0245\u0246\5&\24\2\u0246"+
		"\u0247\7\23\2\2\u0247\u02e7\3\2\2\2\u0248\u0249\7l\2\2\u0249\u024a\7\22"+
		"\2\2\u024a\u024b\5&\24\2\u024b\u024c\7\23\2\2\u024c\u02e7\3\2\2\2\u024d"+
		"\u024e\7m\2\2\u024e\u024f\7\22\2\2\u024f\u0250\5&\24\2\u0250\u0254\7\23"+
		"\2\2\u0251\u0253\7\u0082\2\2\u0252\u0251\3\2\2\2\u0253\u0256\3\2\2\2\u0254"+
		"\u0252\3\2\2\2\u0254\u0255\3\2\2\2\u0255\u0257\3\2\2\2\u0256\u0254\3\2"+
		"\2\2\u0257\u0258\7\6\2\2\u0258\u0259\5 \21\2\u0259\u0265\7\7\2\2\u025a"+
		"\u025e\7n\2\2\u025b\u025d\7\u0082\2\2\u025c\u025b\3\2\2\2\u025d\u0260"+
		"\3\2\2\2\u025e\u025c\3\2\2\2\u025e\u025f\3\2\2\2\u025f\u0261\3\2\2\2\u0260"+
		"\u025e\3\2\2\2\u0261\u0262\7\6\2\2\u0262\u0263\5 \21\2\u0263\u0264\7\7"+
		"\2\2\u0264\u0266\3\2\2\2\u0265\u025a\3\2\2\2\u0265\u0266\3\2\2\2\u0266"+
		"\u02e7\3\2\2\2\u0267\u0268\7o\2\2\u0268\u0269\7\22\2\2\u0269\u026a\5&"+
		"\24\2\u026a\u026e\7\23\2\2\u026b\u026d\7\u0082\2\2\u026c\u026b\3\2\2\2"+
		"\u026d\u0270\3\2\2\2\u026e\u026c\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0271"+
		"\3\2\2\2\u0270\u026e\3\2\2\2\u0271\u027c\7\6\2\2\u0272\u0274\7\u0082\2"+
		"\2\u0273\u0272\3\2\2\2\u0274\u0277\3\2\2\2\u0275\u0273\3\2\2\2\u0275\u0276"+
		"\3\2\2\2\u0276\u0278\3\2\2\2\u0277\u0275\3\2\2\2\u0278\u0279\7p\2\2\u0279"+
		"\u027a\5(\25\2\u027a\u027b\7q\2\2\u027b\u027d\3\2\2\2\u027c\u0275\3\2"+
		"\2\2\u027c\u027d\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u027f\5 \21\2\u027f"+
		"\u0280\7\7\2\2\u0280\u02e7\3\2\2\2\u0281\u0282\t\35\2\2\u0282\u028b\7"+
		"\22\2\2\u0283\u0288\5$\23\2\u0284\u0285\7\3\2\2\u0285\u0287\5$\23\2\u0286"+
		"\u0284\3\2\2\2\u0287\u028a\3\2\2\2\u0288\u0286\3\2\2\2\u0288\u0289\3\2"+
		"\2\2\u0289\u028c\3\2\2\2\u028a\u0288\3\2\2\2\u028b\u0283\3\2\2\2\u028b"+
		"\u028c\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u02e7\7\23\2\2\u028e\u028f\7"+
		"\u0080\2\2\u028f\u0290\7\22\2\2\u0290\u0291\5&\24\2\u0291\u0292\7\23\2"+
		"\2\u0292\u0294\7\36\2\2\u0293\u0295\7\u0082\2\2\u0294\u0293\3\2\2\2\u0294"+
		"\u0295\3\2\2\2\u0295\u0296\3\2\2\2\u0296\u0297\5&\24\2\u0297\u02e7\3\2"+
		"\2\2\u0298\u0299\7t\2\2\u0299\u029b\7\u0080\2\2\u029a\u0298\3\2\2\2\u029a"+
		"\u029b\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029d\7i\2\2\u029d\u029f\7\u0080"+
		"\2\2\u029e\u02a0\7\u0082\2\2\u029f\u029e\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0"+
		"\u02a1\3\2\2\2\u02a1\u02aa\7\22\2\2\u02a2\u02a7\5\36\20\2\u02a3\u02a4"+
		"\7\3\2\2\u02a4\u02a6\5\36\20\2\u02a5\u02a3\3\2\2\2\u02a6\u02a9\3\2\2\2"+
		"\u02a7\u02a5\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02ab\3\2\2\2\u02a9\u02a7"+
		"\3\2\2\2\u02aa\u02a2\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac"+
		"\u02ad\7\23\2\2\u02ad\u02b0\7\t\2\2\u02ae\u02b1\5\16\b\2\u02af\u02b1\7"+
		"u\2\2\u02b0\u02ae\3\2\2\2\u02b0\u02af\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2"+
		"\u02b6\7\36\2\2\u02b3\u02b5\7\u0082\2\2\u02b4\u02b3\3\2\2\2\u02b5\u02b8"+
		"\3\2\2\2\u02b6\u02b4\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b9\3\2\2\2\u02b8"+
		"\u02b6\3\2\2\2\u02b9\u02ca\7\6\2\2\u02ba\u02bc\7\u0082\2\2\u02bb\u02ba"+
		"\3\2\2\2\u02bc\u02bf\3\2\2\2\u02bd\u02bb\3\2\2\2\u02bd\u02be\3\2\2\2\u02be"+
		"\u02c0\3\2\2\2\u02bf\u02bd\3\2\2\2\u02c0\u02c1\7p\2\2\u02c1\u02c5\5,\27"+
		"\2\u02c2\u02c4\7\u0082\2\2\u02c3\u02c2\3\2\2\2\u02c4\u02c7\3\2\2\2\u02c5"+
		"\u02c3\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6\u02c8\3\2\2\2\u02c7\u02c5\3\2"+
		"\2\2\u02c8\u02c9\7q\2\2\u02c9\u02cb\3\2\2\2\u02ca\u02bd\3\2\2\2\u02ca"+
		"\u02cb\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02d7\5 \21\2\u02cd\u02cf\7v"+
		"\2\2\u02ce\u02d0\5&\24\2\u02cf\u02ce\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0"+
		"\u02d4\3\2\2\2\u02d1\u02d3\7\u0082\2\2\u02d2\u02d1\3\2\2\2\u02d3\u02d6"+
		"\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d8\3\2\2\2\u02d6"+
		"\u02d4\3\2\2\2\u02d7\u02cd\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02d9\3\2"+
		"\2\2\u02d9\u02da\7\7\2\2\u02da\u02e7\3\2\2\2\u02db\u02e0\7p\2\2\u02dc"+
		"\u02e1\5\6\4\2\u02dd\u02e1\5\4\3\2\u02de\u02e1\5.\30\2\u02df\u02e1\5\26"+
		"\f\2\u02e0\u02dc\3\2\2\2\u02e0\u02dd\3\2\2\2\u02e0\u02de\3\2\2\2\u02e0"+
		"\u02df\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e3\7q\2\2\u02e3\u02e7\3\2"+
		"\2\2\u02e4\u02e7\5\24\13\2\u02e5\u02e7\5&\24\2\u02e6\u0233\3\2\2\2\u02e6"+
		"\u023d\3\2\2\2\u02e6\u0243\3\2\2\2\u02e6\u0248\3\2\2\2\u02e6\u024d\3\2"+
		"\2\2\u02e6\u0267\3\2\2\2\u02e6\u0281\3\2\2\2\u02e6\u028e\3\2\2\2\u02e6"+
		"\u029a\3\2\2\2\u02e6\u02db\3\2\2\2\u02e6\u02e4\3\2\2\2\u02e6\u02e5\3\2"+
		"\2\2\u02e7#\3\2\2\2\u02e8\u02eb\7\u0086\2\2\u02e9\u02eb\5&\24\2\u02ea"+
		"\u02e8\3\2\2\2\u02ea\u02e9\3\2\2\2\u02eb%\3\2\2\2\u02ec\u02ed\b\24\1\2"+
		"\u02ed\u02ee\t\36\2\2\u02ee\u0321\5&\24\n\u02ef\u0321\t\4\2\2\u02f0\u0321"+
		"\7\177\2\2\u02f1\u0300\7\u0080\2\2\u02f2\u02fb\7\22\2\2\u02f3\u02f8\5"+
		"&\24\2\u02f4\u02f5\7\3\2\2\u02f5\u02f7\5&\24\2\u02f6\u02f4\3\2\2\2\u02f7"+
		"\u02fa\3\2\2\2\u02f8\u02f6\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fc\3\2"+
		"\2\2\u02fa\u02f8\3\2\2\2\u02fb\u02f3\3\2\2\2\u02fb\u02fc\3\2\2\2\u02fc"+
		"\u02fd\3\2\2\2\u02fd\u0301\7\23\2\2\u02fe\u02ff\7\b\2\2\u02ff\u0301\7"+
		"\u0080\2\2\u0300\u02f2\3\2\2\2\u0300\u02fe\3\2\2\2\u0300\u0301\3\2\2\2"+
		"\u0301\u0321\3\2\2\2\u0302\u0303\7\25\2\2\u0303\u0304\7\22\2\2\u0304\u0305"+
		"\7\u0086\2\2\u0305\u0321\7\23\2\2\u0306\u0307\7\26\2\2\u0307\u0310\7\22"+
		"\2\2\u0308\u030d\5&\24\2\u0309\u030a\7\3\2\2\u030a\u030c\5&\24\2\u030b"+
		"\u0309\3\2\2\2\u030c\u030f\3\2\2\2\u030d\u030b\3\2\2\2\u030d\u030e\3\2"+
		"\2\2\u030e\u0311\3\2\2\2\u030f\u030d\3\2\2\2\u0310\u0308\3\2\2\2\u0310"+
		"\u0311\3\2\2\2\u0311\u0312\3\2\2\2\u0312\u0321\7\23\2\2\u0313\u0314\7"+
		"w\2\2\u0314\u0315\7\22\2\2\u0315\u0321\7\23\2\2\u0316\u0317\7x\2\2\u0317"+
		"\u0319\7\22\2\2\u0318\u031a\7\u0086\2\2\u0319\u0318\3\2\2\2\u0319\u031a"+
		"\3\2\2\2\u031a\u031b\3\2\2\2\u031b\u0321\7\23\2\2\u031c\u031d\7\22\2\2"+
		"\u031d\u031e\5&\24\2\u031e\u031f\7\23\2\2\u031f\u0321\3\2\2\2\u0320\u02ec"+
		"\3\2\2\2\u0320\u02ef\3\2\2\2\u0320\u02f0\3\2\2\2\u0320\u02f1\3\2\2\2\u0320"+
		"\u0302\3\2\2\2\u0320\u0306\3\2\2\2\u0320\u0313\3\2\2\2\u0320\u0316\3\2"+
		"\2\2\u0320\u031c\3\2\2\2\u0321\u034e\3\2\2\2\u0322\u0323\f\t\2\2\u0323"+
		"\u0325\t\5\2\2\u0324\u0326\7\u0082\2\2\u0325\u0324\3\2\2\2\u0325\u0326"+
		"\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u034d\5&\24\n\u0328\u0329\f\b\2\2\u0329"+
		"\u032b\t\6\2\2\u032a\u032c\7\u0082\2\2\u032b\u032a\3\2\2\2\u032b\u032c"+
		"\3\2\2\2\u032c\u032d\3\2\2\2\u032d\u034d\5&\24\t\u032e\u032f\f\7\2\2\u032f"+
		"\u0331\7\35\2\2\u0330\u0332\7\u0082\2\2\u0331\u0330\3\2\2\2\u0331\u0332"+
		"\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u034d\5&\24\b\u0334\u0335\f\6\2\2\u0335"+
		"\u0337\t\37\2\2\u0336\u0338\7\u0082\2\2\u0337\u0336\3\2\2\2\u0337\u0338"+
		"\3\2\2\2\u0338\u0339\3\2\2\2\u0339\u034d\5&\24\7\u033a\u033b\f\5\2\2\u033b"+
		"\u033d\t \2\2\u033c\u033e\7\u0082\2\2\u033d\u033c\3\2\2\2\u033d\u033e"+
		"\3\2\2\2\u033e\u033f\3\2\2\2\u033f\u034d\5&\24\6\u0340\u0341\f\4\2\2\u0341"+
		"\u0343\7.\2\2\u0342\u0344\7\u0082\2\2\u0343\u0342\3\2\2\2\u0343\u0344"+
		"\3\2\2\2\u0344\u0345\3\2\2\2\u0345\u034d\5&\24\5\u0346\u0347\f\3\2\2\u0347"+
		"\u0349\7\62\2\2\u0348\u034a\7\u0082\2\2\u0349\u0348\3\2\2\2\u0349\u034a"+
		"\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u034d\5&\24\4\u034c\u0322\3\2\2\2\u034c"+
		"\u0328\3\2\2\2\u034c\u032e\3\2\2\2\u034c\u0334\3\2\2\2\u034c\u033a\3\2"+
		"\2\2\u034c\u0340\3\2\2\2\u034c\u0346\3\2\2\2\u034d\u0350\3\2\2\2\u034e"+
		"\u034c\3\2\2\2\u034e\u034f\3\2\2\2\u034f\'\3\2\2\2\u0350\u034e\3\2\2\2"+
		"\u0351\u0355\7\6\2\2\u0352\u0354\7\u0082\2\2\u0353\u0352\3\2\2\2\u0354"+
		"\u0357\3\2\2\2\u0355\u0353\3\2\2\2\u0355\u0356\3\2\2\2\u0356\u0358\3\2"+
		"\2\2\u0357\u0355\3\2\2\2\u0358\u0359\5*\26\2\u0359\u035d\7\7\2\2\u035a"+
		"\u035c\7\u0082\2\2\u035b\u035a\3\2\2\2\u035c\u035f\3\2\2\2\u035d\u035b"+
		"\3\2\2\2\u035d\u035e\3\2\2\2\u035e\u0387\3\2\2\2\u035f\u035d\3\2\2\2\u0360"+
		"\u0364\7\6\2\2\u0361\u0363\7\u0082\2\2\u0362\u0361\3\2\2\2\u0363\u0366"+
		"\3\2\2\2\u0364\u0362\3\2\2\2\u0364\u0365\3\2\2\2\u0365\u0367\3\2\2\2\u0366"+
		"\u0364\3\2\2\2\u0367\u036b\7d\2\2\u0368\u036a\7\u0082\2\2\u0369\u0368"+
		"\3\2\2\2\u036a\u036d\3\2\2\2\u036b\u0369\3\2\2\2\u036b\u036c\3\2\2\2\u036c"+
		"\u036e\3\2\2\2\u036d\u036b\3\2\2\2\u036e\u0379\5\n\6\2\u036f\u0371\7\u0082"+
		"\2\2\u0370\u036f\3\2\2\2\u0371\u0372\3\2\2\2\u0372\u0370\3\2\2\2\u0372"+
		"\u0373\3\2\2\2\u0373\u0375\3\2\2\2\u0374\u0376\5\n\6\2\u0375\u0374\3\2"+
		"\2\2\u0375\u0376\3\2\2\2\u0376\u0378\3\2\2\2\u0377\u0370\3\2\2\2\u0378"+
		"\u037b\3\2\2\2\u0379\u0377\3\2\2\2\u0379\u037a\3\2\2\2\u037a\u037d\3\2"+
		"\2\2\u037b\u0379\3\2\2\2\u037c\u037e\5*\26\2\u037d\u037c\3\2\2\2\u037d"+
		"\u037e\3\2\2\2\u037e\u037f\3\2\2\2\u037f\u0383\7\7\2\2\u0380\u0382\7\u0082"+
		"\2\2\u0381\u0380\3\2\2\2\u0382\u0385\3\2\2\2\u0383\u0381\3\2\2\2\u0383"+
		"\u0384\3\2\2\2\u0384\u0387\3\2\2\2\u0385\u0383\3\2\2\2\u0386\u0351\3\2"+
		"\2\2\u0386\u0360\3\2\2\2\u0387)\3\2\2\2\u0388\u0389\7y\2\2\u0389\u038e"+
		"\7\u0080\2\2\u038a\u038b\7\3\2\2\u038b\u038d\7\u0080\2\2\u038c\u038a\3"+
		"\2\2\2\u038d\u0390\3\2\2\2\u038e\u038c\3\2\2\2\u038e\u038f\3\2\2\2\u038f"+
		"\u0394\3\2\2\2\u0390\u038e\3\2\2\2\u0391\u0393\7\u0082\2\2\u0392\u0391"+
		"\3\2\2\2\u0393\u0396\3\2\2\2\u0394\u0392\3\2\2\2\u0394\u0395\3\2\2\2\u0395"+
		"+\3\2\2\2\u0396\u0394\3\2\2\2\u0397\u039b\7\6\2\2\u0398\u039a\7\u0082"+
		"\2\2\u0399\u0398\3\2\2\2\u039a\u039d\3\2\2\2\u039b\u0399\3\2\2\2\u039b"+
		"\u039c\3\2\2\2\u039c\u03b3\3\2\2\2\u039d\u039b\3\2\2\2\u039e\u03a2\t!"+
		"\2\2\u039f\u03a1\7\u0082\2\2\u03a0\u039f\3\2\2\2\u03a1\u03a4\3\2\2\2\u03a2"+
		"\u03a0\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3\u03a5\3\2\2\2\u03a4\u03a2\3\2"+
		"\2\2\u03a5\u03b0\5\n\6\2\u03a6\u03a8\7\u0082\2\2\u03a7\u03a6\3\2\2\2\u03a8"+
		"\u03a9\3\2\2\2\u03a9\u03a7\3\2\2\2\u03a9\u03aa\3\2\2\2\u03aa\u03ac\3\2"+
		"\2\2\u03ab\u03ad\5\n\6\2\u03ac\u03ab\3\2\2\2\u03ac\u03ad\3\2\2\2\u03ad"+
		"\u03af\3\2\2\2\u03ae\u03a7\3\2\2\2\u03af\u03b2\3\2\2\2\u03b0\u03ae\3\2"+
		"\2\2\u03b0\u03b1\3\2\2\2\u03b1\u03b4\3\2\2\2\u03b2\u03b0\3\2\2\2\u03b3"+
		"\u039e\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03b8\3\2\2\2\u03b5\u03b7\7\u0082"+
		"\2\2\u03b6\u03b5\3\2\2\2\u03b7\u03ba\3\2\2\2\u03b8\u03b6\3\2\2\2\u03b8"+
		"\u03b9\3\2\2\2\u03b9\u03bc\3\2\2\2\u03ba\u03b8\3\2\2\2\u03bb\u03bd\5*"+
		"\26\2\u03bc\u03bb\3\2\2\2\u03bc\u03bd\3\2\2\2\u03bd\u03d3\3\2\2\2\u03be"+
		"\u03c2\t\"\2\2\u03bf\u03c1\7\u0082\2\2\u03c0\u03bf\3\2\2\2\u03c1\u03c4"+
		"\3\2\2\2\u03c2\u03c0\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03c5\3\2\2\2\u03c4"+
		"\u03c2\3\2\2\2\u03c5\u03d0\5\n\6\2\u03c6\u03c8\7\u0082\2\2\u03c7\u03c6"+
		"\3\2\2\2\u03c8\u03c9\3\2\2\2\u03c9\u03c7\3\2\2\2\u03c9\u03ca\3\2\2\2\u03ca"+
		"\u03cc\3\2\2\2\u03cb\u03cd\5\n\6\2\u03cc\u03cb\3\2\2\2\u03cc\u03cd\3\2"+
		"\2\2\u03cd\u03cf\3\2\2\2\u03ce\u03c7\3\2\2\2\u03cf\u03d2\3\2\2\2\u03d0"+
		"\u03ce\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1\u03d4\3\2\2\2\u03d2\u03d0\3\2"+
		"\2\2\u03d3\u03be\3\2\2\2\u03d3\u03d4\3\2\2\2\u03d4\u03d8\3\2\2\2\u03d5"+
		"\u03d7\7\u0082\2\2\u03d6\u03d5\3\2\2\2\u03d7\u03da\3\2\2\2\u03d8\u03d6"+
		"\3\2\2\2\u03d8\u03d9\3\2\2\2\u03d9\u03db\3\2\2\2\u03da\u03d8\3\2\2\2\u03db"+
		"\u03df\7\7\2\2\u03dc\u03de\7\u0082\2\2\u03dd\u03dc\3\2\2\2\u03de\u03e1"+
		"\3\2\2\2\u03df\u03dd\3\2\2\2\u03df\u03e0\3\2\2\2\u03e0-\3\2\2\2\u03e1"+
		"\u03df\3\2\2\2\u03e2\u03e6\7\6\2\2\u03e3\u03e5\7\u0082\2\2\u03e4\u03e3"+
		"\3\2\2\2\u03e5\u03e8\3\2\2\2\u03e6\u03e4\3\2\2\2\u03e6\u03e7\3\2\2\2\u03e7"+
		"\u03e9\3\2\2\2\u03e8\u03e6\3\2\2\2\u03e9\u03ed\7d\2\2\u03ea\u03ec\7\u0082"+
		"\2\2\u03eb\u03ea\3\2\2\2\u03ec\u03ef\3\2\2\2\u03ed\u03eb\3\2\2\2\u03ed"+
		"\u03ee\3\2\2\2\u03ee\u03f0\3\2\2\2\u03ef\u03ed\3\2\2\2\u03f0\u03fb\5\n"+
		"\6\2\u03f1\u03f3\7\u0082\2\2\u03f2\u03f1\3\2\2\2\u03f3\u03f4\3\2\2\2\u03f4"+
		"\u03f2\3\2\2\2\u03f4\u03f5\3\2\2\2\u03f5\u03f7\3\2\2\2\u03f6\u03f8\5\n"+
		"\6\2\u03f7\u03f6\3\2\2\2\u03f7\u03f8\3\2\2\2\u03f8\u03fa\3\2\2\2\u03f9"+
		"\u03f2\3\2\2\2\u03fa\u03fd\3\2\2\2\u03fb\u03f9\3\2\2\2\u03fb\u03fc\3\2"+
		"\2\2\u03fc\u03fe\3\2\2\2\u03fd\u03fb\3\2\2\2\u03fe\u0402\7\7\2\2\u03ff"+
		"\u0401\7\u0082\2\2\u0400\u03ff\3\2\2\2\u0401\u0404\3\2\2\2\u0402\u0400"+
		"\3\2\2\2\u0402\u0403\3\2\2\2\u0403/\3\2\2\2\u0404\u0402\3\2\2\2\u0096"+
		"\648=ELOW]dfjorv}\u008a\u0091\u0099\u00a1\u00a6\u00ab\u00ae\u00b2\u00b6"+
		"\u00c1\u00cf\u00e0\u00e3\u00e7\u00ec\u00f2\u00f8\u00fe\u0104\u010a\u0110"+
		"\u0116\u0119\u011b\u0124\u012d\u0131\u0136\u0139\u0140\u0146\u014d\u0153"+
		"\u0159\u017d\u018c\u0196\u01a3\u01aa\u01b6\u01c4\u01c7\u01cc\u01d3\u01d7"+
		"\u01e6\u01ed\u01f4\u01f7\u01fb\u0202\u0207\u0210\u0218\u0224\u0229\u022c"+
		"\u0230\u0239\u0240\u0254\u025e\u0265\u026e\u0275\u027c\u0288\u028b\u0294"+
		"\u029a\u029f\u02a7\u02aa\u02b0\u02b6\u02bd\u02c5\u02ca\u02cf\u02d4\u02d7"+
		"\u02e0\u02e6\u02ea\u02f8\u02fb\u0300\u030d\u0310\u0319\u0320\u0325\u032b"+
		"\u0331\u0337\u033d\u0343\u0349\u034c\u034e\u0355\u035d\u0364\u036b\u0372"+
		"\u0375\u0379\u037d\u0383\u0386\u038e\u0394\u039b\u03a2\u03a9\u03ac\u03b0"+
		"\u03b3\u03b8\u03bc\u03c2\u03c9\u03cc\u03d0\u03d3\u03d8\u03df\u03e6\u03ed"+
		"\u03f4\u03f7\u03fb\u0402";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}