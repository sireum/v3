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
	public static class IntMnxContext extends FormulaContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public IntMnxContext(FormulaContext ctx) { copyFrom(ctx); }
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
			setState(232);
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
				_localctx = new IntMnxContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215);
				match(T__18);
				setState(216);
				match(T__5);
				setState(217);
				match(ID);
				}
				break;
			case 11:
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
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)))) != 0)) {
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
			case 12:
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
			setState(284);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(282);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(234);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
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
						((BinaryContext)_localctx).r = formula(12);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(240);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(241);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(11);
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
						((BinaryContext)_localctx).op = match(T__26);
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
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
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(259);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(6);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(264);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(265);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(270);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(271);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(276);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(277);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__50) | (1L << T__51) | (1L << T__52))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(279);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(278);
							match(NL);
							}
						}

						setState(281);
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(286);
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
			setState(287);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(288);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(289);
				match(T__0);
				setState(290);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(311);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(296);
				match(T__6);
				setState(297);
				type();
				}
				break;
			case 2:
				{
				setState(298);
				match(T__6);
				setState(299);
				match(T__15);
				setState(300);
				((QformulaContext)_localctx).lo = exp(0);
				setState(302);
				_la = _input.LA(1);
				if (_la==T__36) {
					{
					setState(301);
					((QformulaContext)_localctx).ll = match(T__36);
					}
				}

				setState(304);
				match(T__61);
				setState(306);
				_la = _input.LA(1);
				if (_la==T__36) {
					{
					setState(305);
					((QformulaContext)_localctx).lh = match(T__36);
					}
				}

				setState(308);
				((QformulaContext)_localctx).hi = exp(0);
				setState(309);
				match(T__16);
				}
				break;
			}
			setState(314);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(313);
				match(NL);
				}
			}

			setState(316);
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
			setState(321);
			switch (_input.LA(1)) {
			case T__62:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				((BooleanTypeContext)_localctx).t = match(T__62);
				}
				break;
			case T__18:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				((IntTypeContext)_localctx).t = match(T__18);
				}
				break;
			case T__19:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
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
			setState(456);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				((PremiseContext)_localctx).t = match(T__63);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
				switch (_input.LA(1)) {
				case T__64:
					{
					setState(324);
					((AndIntroContext)_localctx).tb = match(T__64);
					}
					break;
				case T__43:
				case T__44:
				case T__45:
					{
					setState(325);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(330);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(334);
				switch (_input.LA(1)) {
				case T__65:
				case T__66:
					{
					setState(331);
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
					setState(332);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(333);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(336);
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(340);
				switch (_input.LA(1)) {
				case T__67:
				case T__68:
				case T__69:
				case T__70:
					{
					setState(337);
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
					setState(338);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__47 || _la==T__49) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(339);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(342);
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(346);
				switch (_input.LA(1)) {
				case T__71:
				case T__72:
					{
					setState(343);
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
					setState(344);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__47 || _la==T__49) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(345);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(348);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(349);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(350);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(351);
				((ImpliesIntroContext)_localctx).tb = match(T__73);
				setState(352);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(353);
				((ImpliesElimContext)_localctx).tb = match(T__74);
				setState(354);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(355);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(356);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(357);
				((ImpliesIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__51 || _la==T__52) ) {
					((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(358);
				match(ID);
				setState(359);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(360);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				      "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n      \"e\".equals(_input.LT(2).getText())");
				setState(361);
				((ImpliesElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__51 || _la==T__52) ) {
					((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(362);
				match(ID);
				setState(363);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(364);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(365);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__75 || _la==T__76) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(366);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 11:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(367);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__77 || _la==T__78) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(368);
				((NegElimContext)_localctx).step = match(NUM);
				setState(369);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 12:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(370);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(371);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(372);
				match(ID);
				setState(373);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(374);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(375);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(376);
				match(ID);
				setState(377);
				((NegElimContext)_localctx).step = match(NUM);
				setState(378);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 14:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(382);
				switch (_input.LA(1)) {
				case T__79:
				case T__80:
					{
					setState(379);
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
					setState(380);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==T__14) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(381);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(384);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 15:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(385);
				((PbcContext)_localctx).tb = match(T__81);
				setState(386);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 16:
				_localctx = new Subst1Context(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(387);
				((Subst1Context)_localctx).tb = match(T__82);
				setState(388);
				((Subst1Context)_localctx).eqStep = match(NUM);
				setState(389);
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
				((Subst2Context)_localctx).eqStep = match(NUM);
				setState(392);
				((Subst2Context)_localctx).step = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(393);
				((AlgebraContext)_localctx).tb = match(T__84);
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(394);
					((AlgebraContext)_localctx).NUM = match(NUM);
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).NUM);
					}
					}
					setState(399);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(400);
				((ForallIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__87 - 86)))) != 0)) ) {
					((ForallIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(401);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 20:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(402);
				((ForallElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (T__88 - 89)) | (1L << (T__89 - 89)) | (1L << (T__90 - 89)))) != 0)) ) {
					((ForallElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(403);
				((ForallElimContext)_localctx).step = match(NUM);
				setState(405); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(404);
					formula(0);
					}
					}
					setState(407); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 21:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(409);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(410);
				((ForallIntroContext)_localctx).tb = match(T__56);
				setState(411);
				match(ID);
				setState(412);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 22:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(413);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(414);
				((ForallElimContext)_localctx).tb = match(T__56);
				setState(415);
				match(ID);
				setState(416);
				((ForallElimContext)_localctx).step = match(NUM);
				setState(418); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(417);
					formula(0);
					}
					}
					setState(420); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 23:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(422);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (T__91 - 92)) | (1L << (T__92 - 92)) | (1L << (T__93 - 92)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(423);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(425); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(424);
					formula(0);
					}
					}
					setState(427); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 24:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(429);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (T__94 - 95)) | (1L << (T__95 - 95)) | (1L << (T__96 - 95)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(430);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(431);
				((ExistsElimContext)_localctx).subproof = match(NUM);
				}
				break;
			case 25:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(432);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(433);
				((ExistsIntroContext)_localctx).tb = match(T__60);
				setState(434);
				match(ID);
				setState(435);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(437); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(436);
					formula(0);
					}
					}
					setState(439); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 26:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(441);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(442);
				((ExistsElimContext)_localctx).tb = match(T__60);
				setState(443);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(444);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(445);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 27:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(446);
				((InvariantContext)_localctx).tb = match(T__97);
				}
				break;
			case 28:
				_localctx = new FctContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(447);
				((FctContext)_localctx).tb = match(T__98);
				setState(448);
				match(ID);
				}
				break;
			case 29:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(449);
				((AutoContext)_localctx).tb = match(T__99);
				setState(453);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(450);
					((AutoContext)_localctx).NUM = match(NUM);
					((AutoContext)_localctx).steps.add(((AutoContext)_localctx).NUM);
					}
					}
					setState(455);
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
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(458);
				match(NL);
				}
				}
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(472);
			_la = _input.LA(1);
			if (_la==T__100) {
				{
				setState(464);
				impor();
				setState(466); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(465);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(468); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(470);
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
			setState(474);
			((ImporContext)_localctx).tb = match(T__100);
			setState(475);
			((ImporContext)_localctx).org = match(ID);
			setState(476);
			match(T__5);
			setState(477);
			((ImporContext)_localctx).sireum = match(ID);
			setState(478);
			match(T__5);
			setState(479);
			((ImporContext)_localctx).logika = match(ID);
			setState(480);
			match(T__5);
			setState(481);
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
			setState(483);
			match(T__3);
			setState(487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(484);
				match(NL);
				}
				}
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(490);
			((FactsContext)_localctx).ftb = match(T__98);
			setState(494);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(491);
				match(NL);
				}
				}
				setState(496);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(497);
			factOrFun();
			setState(508);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(499); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(498);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(501); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(504);
				_la = _input.LA(1);
				if (_la==T__102 || _la==ID) {
					{
					setState(503);
					factOrFun();
					}
				}

				}
				}
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(511);
			((FactsContext)_localctx).te = match(T__4);
			setState(515);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(512);
				match(NL);
				}
				}
				setState(517);
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
			setState(520);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(518);
				fact();
				}
				break;
			case T__102:
				enterOuterAlt(_localctx, 2);
				{
				setState(519);
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
			setState(522);
			match(ID);
			setState(523);
			match(T__5);
			setState(524);
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
			setState(526);
			((FunContext)_localctx).tb = match(T__102);
			setState(527);
			match(ID);
			setState(529);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(528);
				match(NL);
				}
			}

			setState(531);
			match(T__15);
			setState(532);
			param();
			setState(537);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(533);
				match(T__0);
				setState(534);
				param();
				}
				}
				setState(539);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(540);
			match(T__16);
			setState(541);
			match(T__6);
			setState(542);
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
			setState(544);
			match(ID);
			setState(545);
			match(T__6);
			setState(546);
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
			setState(549);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & ((1L << (T__100 - 101)) | (1L << (T__102 - 101)) | (1L << (T__103 - 101)) | (1L << (T__104 - 101)) | (1L << (T__105 - 101)) | (1L << (T__106 - 101)) | (1L << (T__108 - 101)) | (1L << (T__109 - 101)) | (1L << (T__111 - 101)) | (1L << (T__112 - 101)) | (1L << (T__113 - 101)) | (1L << (T__116 - 101)) | (1L << (T__117 - 101)) | (1L << (NUM - 101)) | (1L << (ID - 101)))) != 0)) {
				{
				setState(548);
				stmt();
				}
			}

			setState(561);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(552); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(551);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(554); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(557);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & ((1L << (T__100 - 101)) | (1L << (T__102 - 101)) | (1L << (T__103 - 101)) | (1L << (T__104 - 101)) | (1L << (T__105 - 101)) | (1L << (T__106 - 101)) | (1L << (T__108 - 101)) | (1L << (T__109 - 101)) | (1L << (T__111 - 101)) | (1L << (T__112 - 101)) | (1L << (T__113 - 101)) | (1L << (T__116 - 101)) | (1L << (T__117 - 101)) | (1L << (NUM - 101)) | (1L << (ID - 101)))) != 0)) {
					{
					setState(556);
					stmt();
					}
				}

				}
				}
				setState(563);
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
			setState(743);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(564);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__103 || _la==T__104) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(565);
				match(ID);
				setState(566);
				match(T__6);
				setState(567);
				type();
				setState(568);
				match(T__27);
				setState(570);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(569);
					match(NL);
					}
				}

				setState(572);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(574);
				match(ID);
				setState(575);
				match(T__27);
				setState(577);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(576);
					match(NL);
					}
				}

				setState(579);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssumeStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(580);
				match(T__7);
				setState(581);
				match(T__15);
				setState(582);
				exp(0);
				setState(583);
				match(T__16);
				}
				break;
			case 4:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(585);
				match(T__105);
				setState(586);
				match(T__15);
				setState(587);
				exp(0);
				setState(588);
				match(T__16);
				}
				break;
			case 5:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(590);
				match(T__106);
				setState(591);
				match(T__15);
				setState(592);
				exp(0);
				setState(593);
				match(T__16);
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
				((IfStmtContext)_localctx).ts = stmts();
				setState(602);
				match(T__4);
				setState(614);
				_la = _input.LA(1);
				if (_la==T__107) {
					{
					setState(603);
					match(T__107);
					setState(607);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(604);
						match(NL);
						}
						}
						setState(609);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(610);
					match(T__3);
					setState(611);
					((IfStmtContext)_localctx).fs = stmts();
					setState(612);
					match(T__4);
					}
				}

				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(616);
				match(T__108);
				setState(617);
				match(T__15);
				setState(618);
				exp(0);
				setState(619);
				match(T__16);
				setState(623);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(620);
					match(NL);
					}
					}
					setState(625);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(626);
				match(T__3);
				setState(637);
				switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
				case 1:
					{
					setState(630);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(627);
						match(NL);
						}
						}
						setState(632);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(633);
					match(T__109);
					setState(634);
					loopInvariant();
					setState(635);
					match(T__110);
					}
					break;
				}
				setState(639);
				stmts();
				setState(640);
				match(T__4);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(642);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__111 || _la==T__112) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(643);
				match(T__15);
				setState(652);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)) | (1L << (STRING - 117)))) != 0)) {
					{
					setState(644);
					stringOrExp();
					setState(649);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(645);
						match(T__0);
						setState(646);
						stringOrExp();
						}
						}
						setState(651);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(654);
				match(T__16);
				}
				break;
			case 8:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(655);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(656);
				match(T__15);
				setState(657);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(658);
				match(T__16);
				setState(659);
				match(T__27);
				setState(661);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(660);
					match(NL);
					}
				}

				setState(663);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 9:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(667);
				_la = _input.LA(1);
				if (_la==T__113) {
					{
					setState(665);
					match(T__113);
					setState(666);
					((MethodDeclStmtContext)_localctx).helper = match(ID);
					}
				}

				setState(669);
				match(T__102);
				setState(670);
				((MethodDeclStmtContext)_localctx).id = match(ID);
				setState(672);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(671);
					match(NL);
					}
				}

				setState(674);
				match(T__15);
				setState(683);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(675);
					param();
					setState(680);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(676);
						match(T__0);
						setState(677);
						param();
						}
						}
						setState(682);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(685);
				match(T__16);
				setState(686);
				match(T__6);
				setState(689);
				switch (_input.LA(1)) {
				case T__18:
				case T__19:
				case T__62:
					{
					setState(687);
					type();
					}
					break;
				case T__114:
					{
					setState(688);
					match(T__114);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(691);
				match(T__27);
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
				setState(698);
				match(T__3);
				setState(715);
				switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
				case 1:
					{
					setState(702);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(699);
						match(NL);
						}
						}
						setState(704);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(705);
					match(T__109);
					setState(706);
					methodContract();
					setState(710);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(707);
						match(NL);
						}
						}
						setState(712);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(713);
					match(T__110);
					}
					break;
				}
				setState(717);
				stmts();
				setState(728);
				_la = _input.LA(1);
				if (_la==T__115) {
					{
					setState(718);
					((MethodDeclStmtContext)_localctx).rtb = match(T__115);
					setState(720);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)))) != 0)) {
						{
						setState(719);
						exp(0);
						}
					}

					setState(725);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(722);
						match(NL);
						}
						}
						setState(727);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(730);
				match(T__4);
				}
				break;
			case 10:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(732);
				match(T__109);
				setState(737);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(733);
					proof();
					}
					break;
				case 2:
					{
					setState(734);
					sequent();
					}
					break;
				case 3:
					{
					setState(735);
					invariants();
					}
					break;
				case 4:
					{
					setState(736);
					facts();
					}
					break;
				}
				setState(739);
				match(T__110);
				}
				break;
			case 11:
				_localctx = new ImportStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(741);
				impor();
				}
				break;
			case 12:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(742);
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
			setState(747);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(745);
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
				setState(746);
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
	public static class IntMnxExpContext extends ExpContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public IntMnxExpContext(ExpContext ctx) { copyFrom(ctx); }
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
			setState(804);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(750);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__33) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(751);
				exp(8);
				}
				break;
			case 2:
				{
				_localctx = new BooleanExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(752);
				((BooleanExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
					((BooleanExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 3:
				{
				_localctx = new IntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(753);
				match(NUM);
				}
				break;
			case 4:
				{
				_localctx = new IntMnxExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(754);
				match(T__18);
				setState(755);
				match(T__5);
				setState(756);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(757);
				((IdExpContext)_localctx).tb = match(ID);
				setState(772);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(758);
					((IdExpContext)_localctx).t = match(T__15);
					setState(767);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)))) != 0)) {
						{
						setState(759);
						exp(0);
						setState(764);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__0) {
							{
							{
							setState(760);
							match(T__0);
							setState(761);
							exp(0);
							}
							}
							setState(766);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(769);
					match(T__16);
					}
					break;
				case 2:
					{
					setState(770);
					match(T__5);
					setState(771);
					((IdExpContext)_localctx).te = match(ID);
					}
					break;
				}
				}
				break;
			case 6:
				{
				_localctx = new BigIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(774);
				match(T__18);
				setState(775);
				match(T__15);
				setState(776);
				match(STRING);
				setState(777);
				match(T__16);
				}
				break;
			case 7:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(778);
				match(T__19);
				setState(779);
				match(T__15);
				setState(788);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__33))) != 0) || ((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (T__116 - 117)) | (1L << (T__117 - 117)) | (1L << (NUM - 117)) | (1L << (ID - 117)))) != 0)) {
					{
					setState(780);
					exp(0);
					setState(785);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(781);
						match(T__0);
						setState(782);
						exp(0);
						}
						}
						setState(787);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(790);
				match(T__16);
				}
				break;
			case 8:
				{
				_localctx = new RandomIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(791);
				match(T__116);
				setState(792);
				match(T__15);
				setState(793);
				match(T__16);
				}
				break;
			case 9:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(794);
				match(T__117);
				setState(795);
				match(T__15);
				setState(797);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(796);
					match(STRING);
					}
				}

				setState(799);
				match(T__16);
				}
				break;
			case 10:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(800);
				match(T__15);
				setState(801);
				exp(0);
				setState(802);
				match(T__16);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(850);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(848);
					switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(806);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(807);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
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
						((BinaryExpContext)_localctx).r = exp(8);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(812);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(813);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(815);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(814);
							match(NL);
							}
						}

						setState(817);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(818);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(819);
						((BinaryExpContext)_localctx).op = match(T__26);
						setState(821);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(820);
							match(NL);
							}
						}

						setState(823);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(824);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(825);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__39) | (1L << T__40))) != 0)) ) {
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
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(830);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(831);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(833);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(832);
							match(NL);
							}
						}

						setState(835);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(836);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(837);
						((BinaryExpContext)_localctx).op = match(T__43);
						setState(839);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(838);
							match(NL);
							}
						}

						setState(841);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(842);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(843);
						((BinaryExpContext)_localctx).op = match(T__47);
						setState(845);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(844);
							match(NL);
							}
						}

						setState(847);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(852);
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
			setState(906);
			switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(853);
				((LoopInvariantContext)_localctx).tb = match(T__3);
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
				modifies();
				setState(861);
				((LoopInvariantContext)_localctx).te = match(T__4);
				setState(865);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(862);
					match(NL);
					}
					}
					setState(867);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(868);
				((LoopInvariantContext)_localctx).tb = match(T__3);
				setState(872);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(869);
					match(NL);
					}
					}
					setState(874);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(875);
				((LoopInvariantContext)_localctx).itb = match(T__97);
				setState(879);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(876);
					match(NL);
					}
					}
					setState(881);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(882);
				formula(0);
				setState(893);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(884); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(883);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(886); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(889);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
						{
						setState(888);
						formula(0);
						}
					}

					}
					}
					setState(895);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(897);
				_la = _input.LA(1);
				if (_la==T__118) {
					{
					setState(896);
					modifies();
					}
				}

				setState(899);
				((LoopInvariantContext)_localctx).te = match(T__4);
				setState(903);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(900);
					match(NL);
					}
					}
					setState(905);
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
			setState(908);
			((ModifiesContext)_localctx).tb = match(T__118);
			setState(909);
			match(ID);
			setState(914);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(910);
				match(T__0);
				setState(911);
				match(ID);
				}
				}
				setState(916);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(920);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(917);
					match(NL);
					}
					} 
				}
				setState(922);
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
			setState(923);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(927);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(924);
					match(NL);
					}
					} 
				}
				setState(929);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
			}
			setState(951);
			_la = _input.LA(1);
			if (_la==T__119 || _la==T__120) {
				{
				setState(930);
				_la = _input.LA(1);
				if ( !(_la==T__119 || _la==T__120) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(934);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(931);
					match(NL);
					}
					}
					setState(936);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(937);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(948);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(939); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(938);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(941); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(944);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
							{
							setState(943);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(950);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
				}
				}
			}

			setState(956);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(953);
					match(NL);
					}
					} 
				}
				setState(958);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
			}
			setState(960);
			_la = _input.LA(1);
			if (_la==T__118) {
				{
				setState(959);
				modifies();
				}
			}

			setState(983);
			_la = _input.LA(1);
			if (_la==T__121 || _la==T__122) {
				{
				setState(962);
				_la = _input.LA(1);
				if ( !(_la==T__121 || _la==T__122) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(966);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(963);
					match(NL);
					}
					}
					setState(968);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(969);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(980);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(971); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(970);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(973); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(976);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
							{
							setState(975);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(982);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
				}
				}
			}

			setState(988);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(985);
				match(NL);
				}
				}
				setState(990);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(991);
			((MethodContractContext)_localctx).te = match(T__4);
			setState(995);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(992);
					match(NL);
					}
					} 
				}
				setState(997);
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
			setState(998);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(1002);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(999);
				match(NL);
				}
				}
				setState(1004);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1005);
			match(T__97);
			setState(1009);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1006);
				match(NL);
				}
				}
				setState(1011);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1012);
			formula(0);
			setState(1023);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1014); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1013);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1016); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1019);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0) || _la==NUM || _la==ID) {
					{
					setState(1018);
					formula(0);
					}
				}

				}
				}
				setState(1025);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1026);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(1030);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1027);
				match(NL);
				}
				}
				setState(1032);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0087\u040c\4\2\t"+
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
		"\3\6\3\6\3\6\7\6\u00e2\n\6\f\6\16\6\u00e5\13\6\5\6\u00e7\n\6\3\6\3\6\5"+
		"\6\u00eb\n\6\3\6\3\6\3\6\5\6\u00f0\n\6\3\6\3\6\3\6\3\6\5\6\u00f6\n\6\3"+
		"\6\3\6\3\6\3\6\5\6\u00fc\n\6\3\6\3\6\3\6\3\6\5\6\u0102\n\6\3\6\3\6\3\6"+
		"\3\6\5\6\u0108\n\6\3\6\3\6\3\6\3\6\5\6\u010e\n\6\3\6\3\6\3\6\3\6\5\6\u0114"+
		"\n\6\3\6\3\6\3\6\3\6\5\6\u011a\n\6\3\6\7\6\u011d\n\6\f\6\16\6\u0120\13"+
		"\6\3\7\3\7\3\7\3\7\7\7\u0126\n\7\f\7\16\7\u0129\13\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u0131\n\7\3\7\3\7\5\7\u0135\n\7\3\7\3\7\3\7\5\7\u013a\n\7\3"+
		"\7\5\7\u013d\n\7\3\7\3\7\3\b\3\b\3\b\5\b\u0144\n\b\3\t\3\t\3\t\3\t\5\t"+
		"\u014a\n\t\3\t\3\t\3\t\3\t\3\t\5\t\u0151\n\t\3\t\3\t\3\t\3\t\5\t\u0157"+
		"\n\t\3\t\3\t\3\t\3\t\5\t\u015d\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0181\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\7\t\u018e\n\t\f\t\16\t\u0191\13\t\3\t\3\t\3\t\3\t\3"+
		"\t\6\t\u0198\n\t\r\t\16\t\u0199\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6"+
		"\t\u01a5\n\t\r\t\16\t\u01a6\3\t\3\t\3\t\6\t\u01ac\n\t\r\t\16\t\u01ad\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\t\u01b8\n\t\r\t\16\t\u01b9\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u01c6\n\t\f\t\16\t\u01c9\13\t\5\t\u01cb"+
		"\n\t\3\n\7\n\u01ce\n\n\f\n\16\n\u01d1\13\n\3\n\3\n\6\n\u01d5\n\n\r\n\16"+
		"\n\u01d6\3\n\3\n\5\n\u01db\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\7\f\u01e8\n\f\f\f\16\f\u01eb\13\f\3\f\3\f\7\f\u01ef\n\f"+
		"\f\f\16\f\u01f2\13\f\3\f\3\f\6\f\u01f6\n\f\r\f\16\f\u01f7\3\f\5\f\u01fb"+
		"\n\f\7\f\u01fd\n\f\f\f\16\f\u0200\13\f\3\f\3\f\7\f\u0204\n\f\f\f\16\f"+
		"\u0207\13\f\3\r\3\r\5\r\u020b\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5"+
		"\17\u0214\n\17\3\17\3\17\3\17\3\17\7\17\u021a\n\17\f\17\16\17\u021d\13"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\5\21\u0228\n\21\3\21"+
		"\6\21\u022b\n\21\r\21\16\21\u022c\3\21\5\21\u0230\n\21\7\21\u0232\n\21"+
		"\f\21\16\21\u0235\13\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u023d\n\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u0244\n\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0256\n\22\f\22"+
		"\16\22\u0259\13\22\3\22\3\22\3\22\3\22\3\22\7\22\u0260\n\22\f\22\16\22"+
		"\u0263\13\22\3\22\3\22\3\22\3\22\5\22\u0269\n\22\3\22\3\22\3\22\3\22\3"+
		"\22\7\22\u0270\n\22\f\22\16\22\u0273\13\22\3\22\3\22\7\22\u0277\n\22\f"+
		"\22\16\22\u027a\13\22\3\22\3\22\3\22\3\22\5\22\u0280\n\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\7\22\u028a\n\22\f\22\16\22\u028d\13\22\5"+
		"\22\u028f\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0298\n\22\3\22"+
		"\3\22\3\22\3\22\5\22\u029e\n\22\3\22\3\22\3\22\5\22\u02a3\n\22\3\22\3"+
		"\22\3\22\3\22\7\22\u02a9\n\22\f\22\16\22\u02ac\13\22\5\22\u02ae\n\22\3"+
		"\22\3\22\3\22\3\22\5\22\u02b4\n\22\3\22\3\22\7\22\u02b8\n\22\f\22\16\22"+
		"\u02bb\13\22\3\22\3\22\7\22\u02bf\n\22\f\22\16\22\u02c2\13\22\3\22\3\22"+
		"\3\22\7\22\u02c7\n\22\f\22\16\22\u02ca\13\22\3\22\3\22\5\22\u02ce\n\22"+
		"\3\22\3\22\3\22\5\22\u02d3\n\22\3\22\7\22\u02d6\n\22\f\22\16\22\u02d9"+
		"\13\22\5\22\u02db\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u02e4\n"+
		"\22\3\22\3\22\3\22\3\22\5\22\u02ea\n\22\3\23\3\23\5\23\u02ee\n\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u02fd"+
		"\n\24\f\24\16\24\u0300\13\24\5\24\u0302\n\24\3\24\3\24\3\24\5\24\u0307"+
		"\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0312\n\24\f\24"+
		"\16\24\u0315\13\24\5\24\u0317\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\5\24\u0320\n\24\3\24\3\24\3\24\3\24\3\24\5\24\u0327\n\24\3\24\3\24\3"+
		"\24\5\24\u032c\n\24\3\24\3\24\3\24\3\24\5\24\u0332\n\24\3\24\3\24\3\24"+
		"\3\24\5\24\u0338\n\24\3\24\3\24\3\24\3\24\5\24\u033e\n\24\3\24\3\24\3"+
		"\24\3\24\5\24\u0344\n\24\3\24\3\24\3\24\3\24\5\24\u034a\n\24\3\24\3\24"+
		"\3\24\3\24\5\24\u0350\n\24\3\24\7\24\u0353\n\24\f\24\16\24\u0356\13\24"+
		"\3\25\3\25\7\25\u035a\n\25\f\25\16\25\u035d\13\25\3\25\3\25\3\25\7\25"+
		"\u0362\n\25\f\25\16\25\u0365\13\25\3\25\3\25\7\25\u0369\n\25\f\25\16\25"+
		"\u036c\13\25\3\25\3\25\7\25\u0370\n\25\f\25\16\25\u0373\13\25\3\25\3\25"+
		"\6\25\u0377\n\25\r\25\16\25\u0378\3\25\5\25\u037c\n\25\7\25\u037e\n\25"+
		"\f\25\16\25\u0381\13\25\3\25\5\25\u0384\n\25\3\25\3\25\7\25\u0388\n\25"+
		"\f\25\16\25\u038b\13\25\5\25\u038d\n\25\3\26\3\26\3\26\3\26\7\26\u0393"+
		"\n\26\f\26\16\26\u0396\13\26\3\26\7\26\u0399\n\26\f\26\16\26\u039c\13"+
		"\26\3\27\3\27\7\27\u03a0\n\27\f\27\16\27\u03a3\13\27\3\27\3\27\7\27\u03a7"+
		"\n\27\f\27\16\27\u03aa\13\27\3\27\3\27\6\27\u03ae\n\27\r\27\16\27\u03af"+
		"\3\27\5\27\u03b3\n\27\7\27\u03b5\n\27\f\27\16\27\u03b8\13\27\5\27\u03ba"+
		"\n\27\3\27\7\27\u03bd\n\27\f\27\16\27\u03c0\13\27\3\27\5\27\u03c3\n\27"+
		"\3\27\3\27\7\27\u03c7\n\27\f\27\16\27\u03ca\13\27\3\27\3\27\6\27\u03ce"+
		"\n\27\r\27\16\27\u03cf\3\27\5\27\u03d3\n\27\7\27\u03d5\n\27\f\27\16\27"+
		"\u03d8\13\27\5\27\u03da\n\27\3\27\7\27\u03dd\n\27\f\27\16\27\u03e0\13"+
		"\27\3\27\3\27\7\27\u03e4\n\27\f\27\16\27\u03e7\13\27\3\30\3\30\7\30\u03eb"+
		"\n\30\f\30\16\30\u03ee\13\30\3\30\3\30\7\30\u03f2\n\30\f\30\16\30\u03f5"+
		"\13\30\3\30\3\30\6\30\u03f9\n\30\r\30\16\30\u03fa\3\30\5\30\u03fe\n\30"+
		"\7\30\u0400\n\30\f\30\16\30\u0403\13\30\3\30\3\30\7\30\u0407\n\30\f\30"+
		"\16\30\u040a\13\30\3\30\2\4\n&\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\2#\3\2\4\5\3\2\"&\3\2\13\21\3\2\27\31\3\2\32\34\3\2\36!\3"+
		"\2\',\3\2-\60\3\2\61\64\3\2\65\67\3\28?\3\2.\60\3\2DE\3\2FI\4\2\62\62"+
		"\64\64\3\2JK\3\2\66\67\3\2NO\3\2PQ\3\2$&\3\2RS\3\2\20\21\3\2XZ\3\2[]\3"+
		"\2^`\3\2ac\3\2jk\3\2rs\4\2\33\33$$\4\2\'(*+\3\2\37 \3\2z{\3\2|}\u04d0"+
		"\2E\3\2\2\2\4f\3\2\2\2\6h\3\2\2\2\b\u00b6\3\2\2\2\n\u00ea\3\2\2\2\f\u0121"+
		"\3\2\2\2\16\u0143\3\2\2\2\20\u01ca\3\2\2\2\22\u01cf\3\2\2\2\24\u01dc\3"+
		"\2\2\2\26\u01e5\3\2\2\2\30\u020a\3\2\2\2\32\u020c\3\2\2\2\34\u0210\3\2"+
		"\2\2\36\u0222\3\2\2\2 \u0227\3\2\2\2\"\u02e9\3\2\2\2$\u02ed\3\2\2\2&\u0326"+
		"\3\2\2\2(\u038c\3\2\2\2*\u038e\3\2\2\2,\u039d\3\2\2\2.\u03e8\3\2\2\2\60"+
		"\64\5\4\3\2\61\63\7\u0082\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2"+
		"\2\64\65\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\679\5\6\4\28\67\3\2\2\289\3"+
		"\2\2\29=\3\2\2\2:<\7\u0082\2\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2"+
		">@\3\2\2\2?=\3\2\2\2@A\7\2\2\3AF\3\2\2\2BC\5\22\n\2CD\7\2\2\3DF\3\2\2"+
		"\2E\60\3\2\2\2EB\3\2\2\2F\3\3\2\2\2GL\5\n\6\2HI\7\3\2\2IK\5\n\6\2JH\3"+
		"\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MP\3\2\2\2NL\3\2\2\2OG\3\2\2\2OP\3"+
		"\2\2\2PQ\3\2\2\2QR\t\2\2\2RW\5\n\6\2ST\7\3\2\2TV\5\n\6\2US\3\2\2\2VY\3"+
		"\2\2\2WU\3\2\2\2WX\3\2\2\2Xg\3\2\2\2YW\3\2\2\2Z\\\5\n\6\2[Z\3\2\2\2\\"+
		"_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`b\7~\2\2ac\5\n\6\2b"+
		"a\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fO\3\2\2\2f]\3\2\2\2"+
		"g\5\3\2\2\2hj\7\6\2\2ik\5\b\5\2ji\3\2\2\2jk\3\2\2\2kv\3\2\2\2ln\7\u0082"+
		"\2\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qs\5\b\5\2rq\3\2"+
		"\2\2rs\3\2\2\2su\3\2\2\2tm\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2"+
		"\2\2xv\3\2\2\2y}\7\7\2\2z|\7\u0082\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2"+
		"\2}~\3\2\2\2~\7\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\177\2\2\u0081\u0082"+
		"\7\b\2\2\u0082\u0083\5\n\6\2\u0083\u0084\5\20\t\2\u0084\u00b7\3\2\2\2"+
		"\u0085\u0086\7\177\2\2\u0086\u008a\7\b\2\2\u0087\u0089\7\u0082\2\2\u0088"+
		"\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2"+
		"\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u0091\7\6\2\2\u008e"+
		"\u0090\7\u0082\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094"+
		"\u0095\7\177\2\2\u0095\u00a6\7\b\2\2\u0096\u0099\7\u0080\2\2\u0097\u0098"+
		"\7\t\2\2\u0098\u009a\5\16\b\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2"+
		"\u009a\u00a7\3\2\2\2\u009b\u009c\5\n\6\2\u009c\u009d\7\n\2\2\u009d\u00a7"+
		"\3\2\2\2\u009e\u00a1\7\u0080\2\2\u009f\u00a0\7\t\2\2\u00a0\u00a2\5\16"+
		"\b\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a4\5\n\6\2\u00a4\u00a5\7\n\2\2\u00a5\u00a7\3\2\2\2\u00a6\u0096\3\2"+
		"\2\2\u00a6\u009b\3\2\2\2\u00a6\u009e\3\2\2\2\u00a7\u00b2\3\2\2\2\u00a8"+
		"\u00aa\7\u0082\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00af\5\b\5\2\u00ae"+
		"\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00a9\3\2"+
		"\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b7\7\7\2\2\u00b6\u0080\3\2"+
		"\2\2\u00b6\u0085\3\2\2\2\u00b7\t\3\2\2\2\u00b8\u00b9\b\6\1\2\u00b9\u00ba"+
		"\7\33\2\2\u00ba\u00eb\5\n\6\13\u00bb\u00bc\t\3\2\2\u00bc\u00eb\5\n\6\b"+
		"\u00bd\u00eb\t\4\2\2\u00be\u00c1\7\u0080\2\2\u00bf\u00c0\7\b\2\2\u00c0"+
		"\u00c2\7\u0080\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00eb"+
		"\3\2\2\2\u00c3\u00c4\7\22\2\2\u00c4\u00c5\5\n\6\2\u00c5\u00c6\7\23\2\2"+
		"\u00c6\u00eb\3\2\2\2\u00c7\u00eb\7\24\2\2\u00c8\u00c9\7\u0080\2\2\u00c9"+
		"\u00ca\7\22\2\2\u00ca\u00cf\5\n\6\2\u00cb\u00cc\7\3\2\2\u00cc\u00ce\5"+
		"\n\6\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\7\23"+
		"\2\2\u00d3\u00eb\3\2\2\2\u00d4\u00eb\7\177\2\2\u00d5\u00d6\7\25\2\2\u00d6"+
		"\u00d7\7\22\2\2\u00d7\u00d8\7\u0086\2\2\u00d8\u00eb\7\23\2\2\u00d9\u00da"+
		"\7\25\2\2\u00da\u00db\7\b\2\2\u00db\u00eb\7\u0080\2\2\u00dc\u00dd\7\26"+
		"\2\2\u00dd\u00e6\7\22\2\2\u00de\u00e3\5&\24\2\u00df\u00e0\7\3\2\2\u00e0"+
		"\u00e2\5&\24\2\u00e1\u00df\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2"+
		"\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6"+
		"\u00de\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00eb\7\23"+
		"\2\2\u00e9\u00eb\5\f\7\2\u00ea\u00b8\3\2\2\2\u00ea\u00bb\3\2\2\2\u00ea"+
		"\u00bd\3\2\2\2\u00ea\u00be\3\2\2\2\u00ea\u00c3\3\2\2\2\u00ea\u00c7\3\2"+
		"\2\2\u00ea\u00c8\3\2\2\2\u00ea\u00d4\3\2\2\2\u00ea\u00d5\3\2\2\2\u00ea"+
		"\u00d9\3\2\2\2\u00ea\u00dc\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u011e\3\2"+
		"\2\2\u00ec\u00ed\f\r\2\2\u00ed\u00ef\t\5\2\2\u00ee\u00f0\7\u0082\2\2\u00ef"+
		"\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u011d\5\n"+
		"\6\16\u00f2\u00f3\f\f\2\2\u00f3\u00f5\t\6\2\2\u00f4\u00f6\7\u0082\2\2"+
		"\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u011d"+
		"\5\n\6\r\u00f8\u00f9\f\n\2\2\u00f9\u00fb\7\35\2\2\u00fa\u00fc\7\u0082"+
		"\2\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u011d\5\n\6\13\u00fe\u00ff\f\t\2\2\u00ff\u0101\t\7\2\2\u0100\u0102\7"+
		"\u0082\2\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2"+
		"\u0103\u011d\5\n\6\n\u0104\u0105\f\7\2\2\u0105\u0107\t\b\2\2\u0106\u0108"+
		"\7\u0082\2\2\u0107\u0106\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2"+
		"\2\u0109\u011d\5\n\6\b\u010a\u010b\f\6\2\2\u010b\u010d\t\t\2\2\u010c\u010e"+
		"\7\u0082\2\2\u010d\u010c\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2"+
		"\2\u010f\u011d\5\n\6\7\u0110\u0111\f\5\2\2\u0111\u0113\t\n\2\2\u0112\u0114"+
		"\7\u0082\2\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2\2"+
		"\2\u0115\u011d\5\n\6\6\u0116\u0117\f\4\2\2\u0117\u0119\t\13\2\2\u0118"+
		"\u011a\7\u0082\2\2\u0119\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b"+
		"\3\2\2\2\u011b\u011d\5\n\6\5\u011c\u00ec\3\2\2\2\u011c\u00f2\3\2\2\2\u011c"+
		"\u00f8\3\2\2\2\u011c\u00fe\3\2\2\2\u011c\u0104\3\2\2\2\u011c\u010a\3\2"+
		"\2\2\u011c\u0110\3\2\2\2\u011c\u0116\3\2\2\2\u011d\u0120\3\2\2\2\u011e"+
		"\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\13\3\2\2\2\u0120\u011e\3\2\2"+
		"\2\u0121\u0122\t\f\2\2\u0122\u0127\7\u0080\2\2\u0123\u0124\7\3\2\2\u0124"+
		"\u0126\7\u0080\2\2\u0125\u0123\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125"+
		"\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0139\3\2\2\2\u0129\u0127\3\2\2\2\u012a"+
		"\u012b\7\t\2\2\u012b\u013a\5\16\b\2\u012c\u012d\7\t\2\2\u012d\u012e\7"+
		"\22\2\2\u012e\u0130\5&\24\2\u012f\u0131\7\'\2\2\u0130\u012f\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134\7@\2\2\u0133\u0135\7\'"+
		"\2\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		"\u0137\5&\24\2\u0137\u0138\7\23\2\2\u0138\u013a\3\2\2\2\u0139\u012a\3"+
		"\2\2\2\u0139\u012c\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b"+
		"\u013d\7\u0082\2\2\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e"+
		"\3\2\2\2\u013e\u013f\5\n\6\2\u013f\r\3\2\2\2\u0140\u0144\7A\2\2\u0141"+
		"\u0144\7\25\2\2\u0142\u0144\7\26\2\2\u0143\u0140\3\2\2\2\u0143\u0141\3"+
		"\2\2\2\u0143\u0142\3\2\2\2\u0144\17\3\2\2\2\u0145\u01cb\7B\2\2\u0146\u014a"+
		"\7C\2\2\u0147\u0148\t\r\2\2\u0148\u014a\7\u0080\2\2\u0149\u0146\3\2\2"+
		"\2\u0149\u0147\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\7\177\2\2\u014c"+
		"\u01cb\7\177\2\2\u014d\u0151\t\16\2\2\u014e\u014f\t\r\2\2\u014f\u0151"+
		"\7\u0080\2\2\u0150\u014d\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0152\3\2\2"+
		"\2\u0152\u01cb\7\177\2\2\u0153\u0157\t\17\2\2\u0154\u0155\t\20\2\2\u0155"+
		"\u0157\7\u0080\2\2\u0156\u0153\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u0158"+
		"\3\2\2\2\u0158\u01cb\7\177\2\2\u0159\u015d\t\21\2\2\u015a\u015b\t\20\2"+
		"\2\u015b\u015d\7\u0080\2\2\u015c\u0159\3\2\2\2\u015c\u015a\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015f\7\177\2\2\u015f\u0160\7\177\2\2\u0160\u01cb"+
		"\7\177\2\2\u0161\u0162\7L\2\2\u0162\u01cb\7\177\2\2\u0163\u0164\7M\2\2"+
		"\u0164\u0165\7\177\2\2\u0165\u01cb\7\177\2\2\u0166\u0167\6\t\n\2\u0167"+
		"\u0168\t\22\2\2\u0168\u0169\7\u0080\2\2\u0169\u01cb\7\177\2\2\u016a\u016b"+
		"\6\t\13\2\u016b\u016c\t\22\2\2\u016c\u016d\7\u0080\2\2\u016d\u016e\7\177"+
		"\2\2\u016e\u01cb\7\177\2\2\u016f\u0170\t\23\2\2\u0170\u01cb\7\177\2\2"+
		"\u0171\u0172\t\24\2\2\u0172\u0173\7\177\2\2\u0173\u01cb\7\177\2\2\u0174"+
		"\u0175\6\t\f\2\u0175\u0176\t\25\2\2\u0176\u0177\7\u0080\2\2\u0177\u01cb"+
		"\7\177\2\2\u0178\u0179\6\t\r\2\u0179\u017a\t\25\2\2\u017a\u017b\7\u0080"+
		"\2\2\u017b\u017c\7\177\2\2\u017c\u01cb\7\177\2\2\u017d\u0181\t\26\2\2"+
		"\u017e\u017f\t\27\2\2\u017f\u0181\7\u0080\2\2\u0180\u017d\3\2\2\2\u0180"+
		"\u017e\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u01cb\7\177\2\2\u0183\u0184\7"+
		"T\2\2\u0184\u01cb\7\177\2\2\u0185\u0186\7U\2\2\u0186\u0187\7\177\2\2\u0187"+
		"\u01cb\7\177\2\2\u0188\u0189\7V\2\2\u0189\u018a\7\177\2\2\u018a\u01cb"+
		"\7\177\2\2\u018b\u018f\7W\2\2\u018c\u018e\7\177\2\2\u018d\u018c\3\2\2"+
		"\2\u018e\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u01cb"+
		"\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u0193\t\30\2\2\u0193\u01cb\7\177\2"+
		"\2\u0194\u0195\t\31\2\2\u0195\u0197\7\177\2\2\u0196\u0198\5\n\6\2\u0197"+
		"\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2"+
		"\2\2\u019a\u01cb\3\2\2\2\u019b\u019c\6\t\16\2\u019c\u019d\7;\2\2\u019d"+
		"\u019e\7\u0080\2\2\u019e\u01cb\7\177\2\2\u019f\u01a0\6\t\17\2\u01a0\u01a1"+
		"\7;\2\2\u01a1\u01a2\7\u0080\2\2\u01a2\u01a4\7\177\2\2\u01a3\u01a5\5\n"+
		"\6\2\u01a4\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6"+
		"\u01a7\3\2\2\2\u01a7\u01cb\3\2\2\2\u01a8\u01a9\t\32\2\2\u01a9\u01ab\7"+
		"\177\2\2\u01aa\u01ac\5\n\6\2\u01ab\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad"+
		"\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01cb\3\2\2\2\u01af\u01b0\t\33"+
		"\2\2\u01b0\u01b1\7\177\2\2\u01b1\u01cb\7\177\2\2\u01b2\u01b3\6\t\20\2"+
		"\u01b3\u01b4\7?\2\2\u01b4\u01b5\7\u0080\2\2\u01b5\u01b7\7\177\2\2\u01b6"+
		"\u01b8\5\n\6\2\u01b7\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01b7\3\2"+
		"\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01cb\3\2\2\2\u01bb\u01bc\6\t\21\2\u01bc"+
		"\u01bd\7?\2\2\u01bd\u01be\7\u0080\2\2\u01be\u01bf\7\177\2\2\u01bf\u01cb"+
		"\7\177\2\2\u01c0\u01cb\7d\2\2\u01c1\u01c2\7e\2\2\u01c2\u01cb\7\u0080\2"+
		"\2\u01c3\u01c7\7f\2\2\u01c4\u01c6\7\177\2\2\u01c5\u01c4\3\2\2\2\u01c6"+
		"\u01c9\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01cb\3\2"+
		"\2\2\u01c9\u01c7\3\2\2\2\u01ca\u0145\3\2\2\2\u01ca\u0149\3\2\2\2\u01ca"+
		"\u0150\3\2\2\2\u01ca\u0156\3\2\2\2\u01ca\u015c\3\2\2\2\u01ca\u0161\3\2"+
		"\2\2\u01ca\u0163\3\2\2\2\u01ca\u0166\3\2\2\2\u01ca\u016a\3\2\2\2\u01ca"+
		"\u016f\3\2\2\2\u01ca\u0171\3\2\2\2\u01ca\u0174\3\2\2\2\u01ca\u0178\3\2"+
		"\2\2\u01ca\u0180\3\2\2\2\u01ca\u0183\3\2\2\2\u01ca\u0185\3\2\2\2\u01ca"+
		"\u0188\3\2\2\2\u01ca\u018b\3\2\2\2\u01ca\u0192\3\2\2\2\u01ca\u0194\3\2"+
		"\2\2\u01ca\u019b\3\2\2\2\u01ca\u019f\3\2\2\2\u01ca\u01a8\3\2\2\2\u01ca"+
		"\u01af\3\2\2\2\u01ca\u01b2\3\2\2\2\u01ca\u01bb\3\2\2\2\u01ca\u01c0\3\2"+
		"\2\2\u01ca\u01c1\3\2\2\2\u01ca\u01c3\3\2\2\2\u01cb\21\3\2\2\2\u01cc\u01ce"+
		"\7\u0082\2\2\u01cd\u01cc\3\2\2\2\u01ce\u01d1\3\2\2\2\u01cf\u01cd\3\2\2"+
		"\2\u01cf\u01d0\3\2\2\2\u01d0\u01da\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d2\u01d4"+
		"\5\24\13\2\u01d3\u01d5\7\u0082\2\2\u01d4\u01d3\3\2\2\2\u01d5\u01d6\3\2"+
		"\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8"+
		"\u01d9\5 \21\2\u01d9\u01db\3\2\2\2\u01da\u01d2\3\2\2\2\u01da\u01db\3\2"+
		"\2\2\u01db\23\3\2\2\2\u01dc\u01dd\7g\2\2\u01dd\u01de\7\u0080\2\2\u01de"+
		"\u01df\7\b\2\2\u01df\u01e0\7\u0080\2\2\u01e0\u01e1\7\b\2\2\u01e1\u01e2"+
		"\7\u0080\2\2\u01e2\u01e3\7\b\2\2\u01e3\u01e4\7h\2\2\u01e4\25\3\2\2\2\u01e5"+
		"\u01e9\7\6\2\2\u01e6\u01e8\7\u0082\2\2\u01e7\u01e6\3\2\2\2\u01e8\u01eb"+
		"\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ec\3\2\2\2\u01eb"+
		"\u01e9\3\2\2\2\u01ec\u01f0\7e\2\2\u01ed\u01ef\7\u0082\2\2\u01ee\u01ed"+
		"\3\2\2\2\u01ef\u01f2\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1"+
		"\u01f3\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f3\u01fe\5\30\r\2\u01f4\u01f6\7"+
		"\u0082\2\2\u01f5\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f5\3\2\2\2"+
		"\u01f7\u01f8\3\2\2\2\u01f8\u01fa\3\2\2\2\u01f9\u01fb\5\30\r\2\u01fa\u01f9"+
		"\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fd\3\2\2\2\u01fc\u01f5\3\2\2\2\u01fd"+
		"\u0200\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0201\3\2"+
		"\2\2\u0200\u01fe\3\2\2\2\u0201\u0205\7\7\2\2\u0202\u0204\7\u0082\2\2\u0203"+
		"\u0202\3\2\2\2\u0204\u0207\3\2\2\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2"+
		"\2\2\u0206\27\3\2\2\2\u0207\u0205\3\2\2\2\u0208\u020b\5\32\16\2\u0209"+
		"\u020b\5\34\17\2\u020a\u0208\3\2\2\2\u020a\u0209\3\2\2\2\u020b\31\3\2"+
		"\2\2\u020c\u020d\7\u0080\2\2\u020d\u020e\7\b\2\2\u020e\u020f\5\n\6\2\u020f"+
		"\33\3\2\2\2\u0210\u0211\7i\2\2\u0211\u0213\7\u0080\2\2\u0212\u0214\7\u0082"+
		"\2\2\u0213\u0212\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0215\3\2\2\2\u0215"+
		"\u0216\7\22\2\2\u0216\u021b\5\36\20\2\u0217\u0218\7\3\2\2\u0218\u021a"+
		"\5\36\20\2\u0219\u0217\3\2\2\2\u021a\u021d\3\2\2\2\u021b\u0219\3\2\2\2"+
		"\u021b\u021c\3\2\2\2\u021c\u021e\3\2\2\2\u021d\u021b\3\2\2\2\u021e\u021f"+
		"\7\23\2\2\u021f\u0220\7\t\2\2\u0220\u0221\5\16\b\2\u0221\35\3\2\2\2\u0222"+
		"\u0223\7\u0080\2\2\u0223\u0224\7\t\2\2\u0224\u0225\5\16\b\2\u0225\37\3"+
		"\2\2\2\u0226\u0228\5\"\22\2\u0227\u0226\3\2\2\2\u0227\u0228\3\2\2\2\u0228"+
		"\u0233\3\2\2\2\u0229\u022b\7\u0082\2\2\u022a\u0229\3\2\2\2\u022b\u022c"+
		"\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022f\3\2\2\2\u022e"+
		"\u0230\5\"\22\2\u022f\u022e\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0232\3"+
		"\2\2\2\u0231\u022a\3\2\2\2\u0232\u0235\3\2\2\2\u0233\u0231\3\2\2\2\u0233"+
		"\u0234\3\2\2\2\u0234!\3\2\2\2\u0235\u0233\3\2\2\2\u0236\u0237\t\34\2\2"+
		"\u0237\u0238\7\u0080\2\2\u0238\u0239\7\t\2\2\u0239\u023a\5\16\b\2\u023a"+
		"\u023c\7\36\2\2\u023b\u023d\7\u0082\2\2\u023c\u023b\3\2\2\2\u023c\u023d"+
		"\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u023f\5&\24\2\u023f\u02ea\3\2\2\2\u0240"+
		"\u0241\7\u0080\2\2\u0241\u0243\7\36\2\2\u0242\u0244\7\u0082\2\2\u0243"+
		"\u0242\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u02ea\5&"+
		"\24\2\u0246\u0247\7\n\2\2\u0247\u0248\7\22\2\2\u0248\u0249\5&\24\2\u0249"+
		"\u024a\7\23\2\2\u024a\u02ea\3\2\2\2\u024b\u024c\7l\2\2\u024c\u024d\7\22"+
		"\2\2\u024d\u024e\5&\24\2\u024e\u024f\7\23\2\2\u024f\u02ea\3\2\2\2\u0250"+
		"\u0251\7m\2\2\u0251\u0252\7\22\2\2\u0252\u0253\5&\24\2\u0253\u0257\7\23"+
		"\2\2\u0254\u0256\7\u0082\2\2\u0255\u0254\3\2\2\2\u0256\u0259\3\2\2\2\u0257"+
		"\u0255\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u025a\3\2\2\2\u0259\u0257\3\2"+
		"\2\2\u025a\u025b\7\6\2\2\u025b\u025c\5 \21\2\u025c\u0268\7\7\2\2\u025d"+
		"\u0261\7n\2\2\u025e\u0260\7\u0082\2\2\u025f\u025e\3\2\2\2\u0260\u0263"+
		"\3\2\2\2\u0261\u025f\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u0264\3\2\2\2\u0263"+
		"\u0261\3\2\2\2\u0264\u0265\7\6\2\2\u0265\u0266\5 \21\2\u0266\u0267\7\7"+
		"\2\2\u0267\u0269\3\2\2\2\u0268\u025d\3\2\2\2\u0268\u0269\3\2\2\2\u0269"+
		"\u02ea\3\2\2\2\u026a\u026b\7o\2\2\u026b\u026c\7\22\2\2\u026c\u026d\5&"+
		"\24\2\u026d\u0271\7\23\2\2\u026e\u0270\7\u0082\2\2\u026f\u026e\3\2\2\2"+
		"\u0270\u0273\3\2\2\2\u0271\u026f\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0274"+
		"\3\2\2\2\u0273\u0271\3\2\2\2\u0274\u027f\7\6\2\2\u0275\u0277\7\u0082\2"+
		"\2\u0276\u0275\3\2\2\2\u0277\u027a\3\2\2\2\u0278\u0276\3\2\2\2\u0278\u0279"+
		"\3\2\2\2\u0279\u027b\3\2\2\2\u027a\u0278\3\2\2\2\u027b\u027c\7p\2\2\u027c"+
		"\u027d\5(\25\2\u027d\u027e\7q\2\2\u027e\u0280\3\2\2\2\u027f\u0278\3\2"+
		"\2\2\u027f\u0280\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0282\5 \21\2\u0282"+
		"\u0283\7\7\2\2\u0283\u02ea\3\2\2\2\u0284\u0285\t\35\2\2\u0285\u028e\7"+
		"\22\2\2\u0286\u028b\5$\23\2\u0287\u0288\7\3\2\2\u0288\u028a\5$\23\2\u0289"+
		"\u0287\3\2\2\2\u028a\u028d\3\2\2\2\u028b\u0289\3\2\2\2\u028b\u028c\3\2"+
		"\2\2\u028c\u028f\3\2\2\2\u028d\u028b\3\2\2\2\u028e\u0286\3\2\2\2\u028e"+
		"\u028f\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u02ea\7\23\2\2\u0291\u0292\7"+
		"\u0080\2\2\u0292\u0293\7\22\2\2\u0293\u0294\5&\24\2\u0294\u0295\7\23\2"+
		"\2\u0295\u0297\7\36\2\2\u0296\u0298\7\u0082\2\2\u0297\u0296\3\2\2\2\u0297"+
		"\u0298\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u029a\5&\24\2\u029a\u02ea\3\2"+
		"\2\2\u029b\u029c\7t\2\2\u029c\u029e\7\u0080\2\2\u029d\u029b\3\2\2\2\u029d"+
		"\u029e\3\2\2\2\u029e\u029f\3\2\2\2\u029f\u02a0\7i\2\2\u02a0\u02a2\7\u0080"+
		"\2\2\u02a1\u02a3\7\u0082\2\2\u02a2\u02a1\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3"+
		"\u02a4\3\2\2\2\u02a4\u02ad\7\22\2\2\u02a5\u02aa\5\36\20\2\u02a6\u02a7"+
		"\7\3\2\2\u02a7\u02a9\5\36\20\2\u02a8\u02a6\3\2\2\2\u02a9\u02ac\3\2\2\2"+
		"\u02aa\u02a8\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab\u02ae\3\2\2\2\u02ac\u02aa"+
		"\3\2\2\2\u02ad\u02a5\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02af\3\2\2\2\u02af"+
		"\u02b0\7\23\2\2\u02b0\u02b3\7\t\2\2\u02b1\u02b4\5\16\b\2\u02b2\u02b4\7"+
		"u\2\2\u02b3\u02b1\3\2\2\2\u02b3\u02b2\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5"+
		"\u02b9\7\36\2\2\u02b6\u02b8\7\u0082\2\2\u02b7\u02b6\3\2\2\2\u02b8\u02bb"+
		"\3\2\2\2\u02b9\u02b7\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02bc\3\2\2\2\u02bb"+
		"\u02b9\3\2\2\2\u02bc\u02cd\7\6\2\2\u02bd\u02bf\7\u0082\2\2\u02be\u02bd"+
		"\3\2\2\2\u02bf\u02c2\3\2\2\2\u02c0\u02be\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1"+
		"\u02c3\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c3\u02c4\7p\2\2\u02c4\u02c8\5,\27"+
		"\2\u02c5\u02c7\7\u0082\2\2\u02c6\u02c5\3\2\2\2\u02c7\u02ca\3\2\2\2\u02c8"+
		"\u02c6\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9\u02cb\3\2\2\2\u02ca\u02c8\3\2"+
		"\2\2\u02cb\u02cc\7q\2\2\u02cc\u02ce\3\2\2\2\u02cd\u02c0\3\2\2\2\u02cd"+
		"\u02ce\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf\u02da\5 \21\2\u02d0\u02d2\7v"+
		"\2\2\u02d1\u02d3\5&\24\2\u02d2\u02d1\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3"+
		"\u02d7\3\2\2\2\u02d4\u02d6\7\u0082\2\2\u02d5\u02d4\3\2\2\2\u02d6\u02d9"+
		"\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02db\3\2\2\2\u02d9"+
		"\u02d7\3\2\2\2\u02da\u02d0\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02dc\3\2"+
		"\2\2\u02dc\u02dd\7\7\2\2\u02dd\u02ea\3\2\2\2\u02de\u02e3\7p\2\2\u02df"+
		"\u02e4\5\6\4\2\u02e0\u02e4\5\4\3\2\u02e1\u02e4\5.\30\2\u02e2\u02e4\5\26"+
		"\f\2\u02e3\u02df\3\2\2\2\u02e3\u02e0\3\2\2\2\u02e3\u02e1\3\2\2\2\u02e3"+
		"\u02e2\3\2\2\2\u02e4\u02e5\3\2\2\2\u02e5\u02e6\7q\2\2\u02e6\u02ea\3\2"+
		"\2\2\u02e7\u02ea\5\24\13\2\u02e8\u02ea\5&\24\2\u02e9\u0236\3\2\2\2\u02e9"+
		"\u0240\3\2\2\2\u02e9\u0246\3\2\2\2\u02e9\u024b\3\2\2\2\u02e9\u0250\3\2"+
		"\2\2\u02e9\u026a\3\2\2\2\u02e9\u0284\3\2\2\2\u02e9\u0291\3\2\2\2\u02e9"+
		"\u029d\3\2\2\2\u02e9\u02de\3\2\2\2\u02e9\u02e7\3\2\2\2\u02e9\u02e8\3\2"+
		"\2\2\u02ea#\3\2\2\2\u02eb\u02ee\7\u0086\2\2\u02ec\u02ee\5&\24\2\u02ed"+
		"\u02eb\3\2\2\2\u02ed\u02ec\3\2\2\2\u02ee%\3\2\2\2\u02ef\u02f0\b\24\1\2"+
		"\u02f0\u02f1\t\36\2\2\u02f1\u0327\5&\24\n\u02f2\u0327\t\4\2\2\u02f3\u0327"+
		"\7\177\2\2\u02f4\u02f5\7\25\2\2\u02f5\u02f6\7\b\2\2\u02f6\u0327\7\u0080"+
		"\2\2\u02f7\u0306\7\u0080\2\2\u02f8\u0301\7\22\2\2\u02f9\u02fe\5&\24\2"+
		"\u02fa\u02fb\7\3\2\2\u02fb\u02fd\5&\24\2\u02fc\u02fa\3\2\2\2\u02fd\u0300"+
		"\3\2\2\2\u02fe\u02fc\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0302\3\2\2\2\u0300"+
		"\u02fe\3\2\2\2\u0301\u02f9\3\2\2\2\u0301\u0302\3\2\2\2\u0302\u0303\3\2"+
		"\2\2\u0303\u0307\7\23\2\2\u0304\u0305\7\b\2\2\u0305\u0307\7\u0080\2\2"+
		"\u0306\u02f8\3\2\2\2\u0306\u0304\3\2\2\2\u0306\u0307\3\2\2\2\u0307\u0327"+
		"\3\2\2\2\u0308\u0309\7\25\2\2\u0309\u030a\7\22\2\2\u030a\u030b\7\u0086"+
		"\2\2\u030b\u0327\7\23\2\2\u030c\u030d\7\26\2\2\u030d\u0316\7\22\2\2\u030e"+
		"\u0313\5&\24\2\u030f\u0310\7\3\2\2\u0310\u0312\5&\24\2\u0311\u030f\3\2"+
		"\2\2\u0312\u0315\3\2\2\2\u0313\u0311\3\2\2\2\u0313\u0314\3\2\2\2\u0314"+
		"\u0317\3\2\2\2\u0315\u0313\3\2\2\2\u0316\u030e\3\2\2\2\u0316\u0317\3\2"+
		"\2\2\u0317\u0318\3\2\2\2\u0318\u0327\7\23\2\2\u0319\u031a\7w\2\2\u031a"+
		"\u031b\7\22\2\2\u031b\u0327\7\23\2\2\u031c\u031d\7x\2\2\u031d\u031f\7"+
		"\22\2\2\u031e\u0320\7\u0086\2\2\u031f\u031e\3\2\2\2\u031f\u0320\3\2\2"+
		"\2\u0320\u0321\3\2\2\2\u0321\u0327\7\23\2\2\u0322\u0323\7\22\2\2\u0323"+
		"\u0324\5&\24\2\u0324\u0325\7\23\2\2\u0325\u0327\3\2\2\2\u0326\u02ef\3"+
		"\2\2\2\u0326\u02f2\3\2\2\2\u0326\u02f3\3\2\2\2\u0326\u02f4\3\2\2\2\u0326"+
		"\u02f7\3\2\2\2\u0326\u0308\3\2\2\2\u0326\u030c\3\2\2\2\u0326\u0319\3\2"+
		"\2\2\u0326\u031c\3\2\2\2\u0326\u0322\3\2\2\2\u0327\u0354\3\2\2\2\u0328"+
		"\u0329\f\t\2\2\u0329\u032b\t\5\2\2\u032a\u032c\7\u0082\2\2\u032b\u032a"+
		"\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u032d\3\2\2\2\u032d\u0353\5&\24\n\u032e"+
		"\u032f\f\b\2\2\u032f\u0331\t\6\2\2\u0330\u0332\7\u0082\2\2\u0331\u0330"+
		"\3\2\2\2\u0331\u0332\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u0353\5&\24\t\u0334"+
		"\u0335\f\7\2\2\u0335\u0337\7\35\2\2\u0336\u0338\7\u0082\2\2\u0337\u0336"+
		"\3\2\2\2\u0337\u0338\3\2\2\2\u0338\u0339\3\2\2\2\u0339\u0353\5&\24\b\u033a"+
		"\u033b\f\6\2\2\u033b\u033d\t\37\2\2\u033c\u033e\7\u0082\2\2\u033d\u033c"+
		"\3\2\2\2\u033d\u033e\3\2\2\2\u033e\u033f\3\2\2\2\u033f\u0353\5&\24\7\u0340"+
		"\u0341\f\5\2\2\u0341\u0343\t \2\2\u0342\u0344\7\u0082\2\2\u0343\u0342"+
		"\3\2\2\2\u0343\u0344\3\2\2\2\u0344\u0345\3\2\2\2\u0345\u0353\5&\24\6\u0346"+
		"\u0347\f\4\2\2\u0347\u0349\7.\2\2\u0348\u034a\7\u0082\2\2\u0349\u0348"+
		"\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u0353\5&\24\5\u034c"+
		"\u034d\f\3\2\2\u034d\u034f\7\62\2\2\u034e\u0350\7\u0082\2\2\u034f\u034e"+
		"\3\2\2\2\u034f\u0350\3\2\2\2\u0350\u0351\3\2\2\2\u0351\u0353\5&\24\4\u0352"+
		"\u0328\3\2\2\2\u0352\u032e\3\2\2\2\u0352\u0334\3\2\2\2\u0352\u033a\3\2"+
		"\2\2\u0352\u0340\3\2\2\2\u0352\u0346\3\2\2\2\u0352\u034c\3\2\2\2\u0353"+
		"\u0356\3\2\2\2\u0354\u0352\3\2\2\2\u0354\u0355\3\2\2\2\u0355\'\3\2\2\2"+
		"\u0356\u0354\3\2\2\2\u0357\u035b\7\6\2\2\u0358\u035a\7\u0082\2\2\u0359"+
		"\u0358\3\2\2\2\u035a\u035d\3\2\2\2\u035b\u0359\3\2\2\2\u035b\u035c\3\2"+
		"\2\2\u035c\u035e\3\2\2\2\u035d\u035b\3\2\2\2\u035e\u035f\5*\26\2\u035f"+
		"\u0363\7\7\2\2\u0360\u0362\7\u0082\2\2\u0361\u0360\3\2\2\2\u0362\u0365"+
		"\3\2\2\2\u0363\u0361\3\2\2\2\u0363\u0364\3\2\2\2\u0364\u038d\3\2\2\2\u0365"+
		"\u0363\3\2\2\2\u0366\u036a\7\6\2\2\u0367\u0369\7\u0082\2\2\u0368\u0367"+
		"\3\2\2\2\u0369\u036c\3\2\2\2\u036a\u0368\3\2\2\2\u036a\u036b\3\2\2\2\u036b"+
		"\u036d\3\2\2\2\u036c\u036a\3\2\2\2\u036d\u0371\7d\2\2\u036e\u0370\7\u0082"+
		"\2\2\u036f\u036e\3\2\2\2\u0370\u0373\3\2\2\2\u0371\u036f\3\2\2\2\u0371"+
		"\u0372\3\2\2\2\u0372\u0374\3\2\2\2\u0373\u0371\3\2\2\2\u0374\u037f\5\n"+
		"\6\2\u0375\u0377\7\u0082\2\2\u0376\u0375\3\2\2\2\u0377\u0378\3\2\2\2\u0378"+
		"\u0376\3\2\2\2\u0378\u0379\3\2\2\2\u0379\u037b\3\2\2\2\u037a\u037c\5\n"+
		"\6\2\u037b\u037a\3\2\2\2\u037b\u037c\3\2\2\2\u037c\u037e\3\2\2\2\u037d"+
		"\u0376\3\2\2\2\u037e\u0381\3\2\2\2\u037f\u037d\3\2\2\2\u037f\u0380\3\2"+
		"\2\2\u0380\u0383\3\2\2\2\u0381\u037f\3\2\2\2\u0382\u0384\5*\26\2\u0383"+
		"\u0382\3\2\2\2\u0383\u0384\3\2\2\2\u0384\u0385\3\2\2\2\u0385\u0389\7\7"+
		"\2\2\u0386\u0388\7\u0082\2\2\u0387\u0386\3\2\2\2\u0388\u038b\3\2\2\2\u0389"+
		"\u0387\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u038d\3\2\2\2\u038b\u0389\3\2"+
		"\2\2\u038c\u0357\3\2\2\2\u038c\u0366\3\2\2\2\u038d)\3\2\2\2\u038e\u038f"+
		"\7y\2\2\u038f\u0394\7\u0080\2\2\u0390\u0391\7\3\2\2\u0391\u0393\7\u0080"+
		"\2\2\u0392\u0390\3\2\2\2\u0393\u0396\3\2\2\2\u0394\u0392\3\2\2\2\u0394"+
		"\u0395\3\2\2\2\u0395\u039a\3\2\2\2\u0396\u0394\3\2\2\2\u0397\u0399\7\u0082"+
		"\2\2\u0398\u0397\3\2\2\2\u0399\u039c\3\2\2\2\u039a\u0398\3\2\2\2\u039a"+
		"\u039b\3\2\2\2\u039b+\3\2\2\2\u039c\u039a\3\2\2\2\u039d\u03a1\7\6\2\2"+
		"\u039e\u03a0\7\u0082\2\2\u039f\u039e\3\2\2\2\u03a0\u03a3\3\2\2\2\u03a1"+
		"\u039f\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2\u03b9\3\2\2\2\u03a3\u03a1\3\2"+
		"\2\2\u03a4\u03a8\t!\2\2\u03a5\u03a7\7\u0082\2\2\u03a6\u03a5\3\2\2\2\u03a7"+
		"\u03aa\3\2\2\2\u03a8\u03a6\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03ab\3\2"+
		"\2\2\u03aa\u03a8\3\2\2\2\u03ab\u03b6\5\n\6\2\u03ac\u03ae\7\u0082\2\2\u03ad"+
		"\u03ac\3\2\2\2\u03ae\u03af\3\2\2\2\u03af\u03ad\3\2\2\2\u03af\u03b0\3\2"+
		"\2\2\u03b0\u03b2\3\2\2\2\u03b1\u03b3\5\n\6\2\u03b2\u03b1\3\2\2\2\u03b2"+
		"\u03b3\3\2\2\2\u03b3\u03b5\3\2\2\2\u03b4\u03ad\3\2\2\2\u03b5\u03b8\3\2"+
		"\2\2\u03b6\u03b4\3\2\2\2\u03b6\u03b7\3\2\2\2\u03b7\u03ba\3\2\2\2\u03b8"+
		"\u03b6\3\2\2\2\u03b9\u03a4\3\2\2\2\u03b9\u03ba\3\2\2\2\u03ba\u03be\3\2"+
		"\2\2\u03bb\u03bd\7\u0082\2\2\u03bc\u03bb\3\2\2\2\u03bd\u03c0\3\2\2\2\u03be"+
		"\u03bc\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\u03c2\3\2\2\2\u03c0\u03be\3\2"+
		"\2\2\u03c1\u03c3\5*\26\2\u03c2\u03c1\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3"+
		"\u03d9\3\2\2\2\u03c4\u03c8\t\"\2\2\u03c5\u03c7\7\u0082\2\2\u03c6\u03c5"+
		"\3\2\2\2\u03c7\u03ca\3\2\2\2\u03c8\u03c6\3\2\2\2\u03c8\u03c9\3\2\2\2\u03c9"+
		"\u03cb\3\2\2\2\u03ca\u03c8\3\2\2\2\u03cb\u03d6\5\n\6\2\u03cc\u03ce\7\u0082"+
		"\2\2\u03cd\u03cc\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf\u03cd\3\2\2\2\u03cf"+
		"\u03d0\3\2\2\2\u03d0\u03d2\3\2\2\2\u03d1\u03d3\5\n\6\2\u03d2\u03d1\3\2"+
		"\2\2\u03d2\u03d3\3\2\2\2\u03d3\u03d5\3\2\2\2\u03d4\u03cd\3\2\2\2\u03d5"+
		"\u03d8\3\2\2\2\u03d6\u03d4\3\2\2\2\u03d6\u03d7\3\2\2\2\u03d7\u03da\3\2"+
		"\2\2\u03d8\u03d6\3\2\2\2\u03d9\u03c4\3\2\2\2\u03d9\u03da\3\2\2\2\u03da"+
		"\u03de\3\2\2\2\u03db\u03dd\7\u0082\2\2\u03dc\u03db\3\2\2\2\u03dd\u03e0"+
		"\3\2\2\2\u03de\u03dc\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u03e1\3\2\2\2\u03e0"+
		"\u03de\3\2\2\2\u03e1\u03e5\7\7\2\2\u03e2\u03e4\7\u0082\2\2\u03e3\u03e2"+
		"\3\2\2\2\u03e4\u03e7\3\2\2\2\u03e5\u03e3\3\2\2\2\u03e5\u03e6\3\2\2\2\u03e6"+
		"-\3\2\2\2\u03e7\u03e5\3\2\2\2\u03e8\u03ec\7\6\2\2\u03e9\u03eb\7\u0082"+
		"\2\2\u03ea\u03e9\3\2\2\2\u03eb\u03ee\3\2\2\2\u03ec\u03ea\3\2\2\2\u03ec"+
		"\u03ed\3\2\2\2\u03ed\u03ef\3\2\2\2\u03ee\u03ec\3\2\2\2\u03ef\u03f3\7d"+
		"\2\2\u03f0\u03f2\7\u0082\2\2\u03f1\u03f0\3\2\2\2\u03f2\u03f5\3\2\2\2\u03f3"+
		"\u03f1\3\2\2\2\u03f3\u03f4\3\2\2\2\u03f4\u03f6\3\2\2\2\u03f5\u03f3\3\2"+
		"\2\2\u03f6\u0401\5\n\6\2\u03f7\u03f9\7\u0082\2\2\u03f8\u03f7\3\2\2\2\u03f9"+
		"\u03fa\3\2\2\2\u03fa\u03f8\3\2\2\2\u03fa\u03fb\3\2\2\2\u03fb\u03fd\3\2"+
		"\2\2\u03fc\u03fe\5\n\6\2\u03fd\u03fc\3\2\2\2\u03fd\u03fe\3\2\2\2\u03fe"+
		"\u0400\3\2\2\2\u03ff\u03f8\3\2\2\2\u0400\u0403\3\2\2\2\u0401\u03ff\3\2"+
		"\2\2\u0401\u0402\3\2\2\2\u0402\u0404\3\2\2\2\u0403\u0401\3\2\2\2\u0404"+
		"\u0408\7\7\2\2\u0405\u0407\7\u0082\2\2\u0406\u0405\3\2\2\2\u0407\u040a"+
		"\3\2\2\2\u0408\u0406\3\2\2\2\u0408\u0409\3\2\2\2\u0409/\3\2\2\2\u040a"+
		"\u0408\3\2\2\2\u0096\648=ELOW]dfjorv}\u008a\u0091\u0099\u00a1\u00a6\u00ab"+
		"\u00ae\u00b2\u00b6\u00c1\u00cf\u00e3\u00e6\u00ea\u00ef\u00f5\u00fb\u0101"+
		"\u0107\u010d\u0113\u0119\u011c\u011e\u0127\u0130\u0134\u0139\u013c\u0143"+
		"\u0149\u0150\u0156\u015c\u0180\u018f\u0199\u01a6\u01ad\u01b9\u01c7\u01ca"+
		"\u01cf\u01d6\u01da\u01e9\u01f0\u01f7\u01fa\u01fe\u0205\u020a\u0213\u021b"+
		"\u0227\u022c\u022f\u0233\u023c\u0243\u0257\u0261\u0268\u0271\u0278\u027f"+
		"\u028b\u028e\u0297\u029d\u02a2\u02aa\u02ad\u02b3\u02b9\u02c0\u02c8\u02cd"+
		"\u02d2\u02d7\u02da\u02e3\u02e9\u02ed\u02fe\u0301\u0306\u0313\u0316\u031f"+
		"\u0326\u032b\u0331\u0337\u033d\u0343\u0349\u034f\u0352\u0354\u035b\u0363"+
		"\u036a\u0371\u0378\u037b\u037f\u0383\u0389\u038c\u0394\u039a\u03a1\u03a8"+
		"\u03af\u03b2\u03b6\u03b9\u03be\u03c2\u03c8\u03cf\u03d2\u03d6\u03d9\u03de"+
		"\u03e5\u03ec\u03f3\u03fa\u03fd\u0401\u0408";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}