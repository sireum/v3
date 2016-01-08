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
		T__119=120, T__120=121, T__121=122, T__122=123, T__123=124, T__124=125, 
		T__125=126, HLINE=127, NUM=128, ID=129, SSTRING=130, STRING=131, RESERVED=132, 
		NL=133, LINE_COMMENT=134, COMMENT=135, WS=136, ERROR_CHAR=137;
	public static final int
		RULE_file = 0, RULE_sequent = 1, RULE_proof = 2, RULE_proofStep = 3, RULE_formula = 4, 
		RULE_qformula = 5, RULE_type = 6, RULE_justification = 7, RULE_numOrId = 8, 
		RULE_program = 9, RULE_facts = 10, RULE_factOrFun = 11, RULE_fact = 12, 
		RULE_fun = 13, RULE_param = 14, RULE_stmts = 15, RULE_stmt = 16, RULE_exp = 17, 
		RULE_loopInvariant = 18, RULE_modifies = 19, RULE_methodContract = 20, 
		RULE_invariants = 21;
	public static final String[] ruleNames = {
		"file", "sequent", "proof", "proofStep", "formula", "qformula", "type", 
		"justification", "numOrId", "program", "facts", "factOrFun", "fact", "fun", 
		"param", "stmts", "stmt", "exp", "loopInvariant", "modifies", "methodContract", 
		"invariants"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'|-'", "'⊢'", "'{'", "'}'", "'.'", "':'", "'assume'", "'true'", 
		"'T'", "'⊤'", "'false'", "'F'", "'_|_'", "'⊥'", "'('", "')'", "'result'", 
		"'Z'", "'ZS'", "'*'", "'/'", "'%'", "'+'", "'-'", "'+:'", "':+'", "'='", 
		"'=='", "'!='", "'≠'", "'not'", "'!'", "'~'", "'¬'", "'<'", "'<='", "'≤'", 
		"'>'", "'>='", "'≥'", "'and'", "'&'", "'^'", "'∧'", "'or'", "'|'", "'V'", 
		"'∨'", "'implies'", "'->'", "'→'", "'forall'", "'all'", "'A'", "'∀'", 
		"'exists'", "'some'", "'E'", "'∃'", "'..'", "'B'", "'premise'", "'andi'", 
		"'^i'", "'ande1'", "'^e1'", "'ande2'", "'^e2'", "'ori1'", "'Vi1'", "'ori2'", 
		"'Vi2'", "'ore'", "'Ve'", "'impliesi'", "'impliese'", "'noti'", "'negi'", 
		"'note'", "'nege'", "'bottome'", "'falsee'", "'Pbc'", "'subst1'", "'subst2'", 
		"'algebra'", "'foralli'", "'alli'", "'Ai'", "'foralle'", "'alle'", "'Ae'", 
		"'existsi'", "'somei'", "'Ei'", "'existse'", "'somee'", "'Ee'", "'invariant'", 
		"'auto'", "'import'", "'logika'", "'_'", "'l\"\"\"'", "'\"\"\"'", "'fact'", 
		"'def'", "'var'", "'val'", "'assert'", "'if'", "'else'", "'while'", "'print'", 
		"'println'", "'@'", "'Unit'", "'return'", "'randomInt'", "'readInt'", 
		"'modifies'", "'requires'", "'pre'", "'ensures'", "'post'"
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
		null, null, null, null, null, null, null, "HLINE", "NUM", "ID", "SSTRING", 
		"STRING", "RESERVED", "NL", "LINE_COMMENT", "COMMENT", "WS", "ERROR_CHAR"
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
			setState(65);
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
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case HLINE:
			case NUM:
			case ID:
				_localctx = new SequentFileContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				sequent();
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(45);
						match(NL);
						}
						} 
					}
					setState(50);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				}
				setState(52);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(51);
					proof();
					}
				}

				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(54);
					match(NL);
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(60);
				match(EOF);
				}
				break;
			case EOF:
			case T__101:
			case NL:
				_localctx = new ProgramFileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				program();
				setState(63);
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
			setState(98);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0) || _la==NUM || _la==ID) {
					{
					setState(67);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(68);
						match(T__0);
						setState(69);
						((SequentContext)_localctx).formula = formula(0);
						((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
						}
						}
						setState(74);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(77);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(78);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(79);
					match(T__0);
					setState(80);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0) || _la==NUM || _la==ID) {
					{
					{
					setState(86);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(92);
				match(HLINE);
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(93);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(96); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0) || _la==NUM || _la==ID );
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
			setState(100);
			((ProofContext)_localctx).tb = match(T__3);
			setState(102);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(101);
				proofStep();
				}
			}

			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(105); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(104);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(107); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(110);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(109);
					proofStep();
					}
				}

				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			((ProofContext)_localctx).te = match(T__4);
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(118);
					match(NL);
					}
					} 
				}
				setState(123);
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
			setState(178);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(NUM);
				setState(125);
				match(T__5);
				setState(126);
				formula(0);
				setState(127);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(130);
				match(T__5);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(131);
					match(NL);
					}
					}
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(137);
				match(T__3);
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
				((SubProofContext)_localctx).assume = match(NUM);
				setState(145);
				match(T__5);
				setState(162);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(146);
					match(ID);
					setState(149);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(147);
						match(T__6);
						setState(148);
						type();
						}
					}

					}
					break;
				case 2:
					{
					setState(151);
					formula(0);
					setState(152);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				case 3:
					{
					setState(154);
					match(ID);
					setState(157);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(155);
						match(T__6);
						setState(156);
						type();
						}
					}

					setState(159);
					formula(0);
					setState(160);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(165); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(164);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(167); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(170);
					_la = _input.LA(1);
					if (_la==NUM) {
						{
						setState(169);
						proofStep();
						}
					}

					}
					}
					setState(176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(177);
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
			setState(227);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(181);
				((UnaryContext)_localctx).op = match(T__24);
				setState(182);
				formula(9);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(184);
				formula(6);
				}
				break;
			case 3:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
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
				setState(186);
				((VarContext)_localctx).tb = match(ID);
				setState(189);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(187);
					match(T__5);
					setState(188);
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
				setState(191);
				match(T__15);
				setState(192);
				formula(0);
				setState(193);
				match(T__16);
				}
				break;
			case 6:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(T__17);
				}
				break;
			case 7:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				match(ID);
				setState(197);
				match(T__15);
				setState(198);
				formula(0);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(199);
					match(T__0);
					setState(200);
					formula(0);
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(206);
				match(T__16);
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				match(NUM);
				}
				break;
			case 9:
				{
				_localctx = new BigIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				match(T__18);
				setState(210);
				match(T__15);
				setState(211);
				match(STRING);
				setState(212);
				match(T__16);
				}
				break;
			case 10:
				{
				_localctx = new SeqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				match(T__19);
				setState(214);
				match(T__15);
				setState(223);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__32))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (T__119 - 120)) | (1L << (T__120 - 120)) | (1L << (NUM - 120)) | (1L << (ID - 120)))) != 0)) {
					{
					setState(215);
					exp(0);
					setState(220);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(216);
						match(T__0);
						setState(217);
						exp(0);
						}
						}
						setState(222);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(225);
				match(T__16);
				}
				break;
			case 11:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(279);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(277);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(229);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(230);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(232);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(231);
							match(NL);
							}
						}

						setState(234);
						((BinaryContext)_localctx).r = formula(12);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(235);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(236);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(238);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(237);
							match(NL);
							}
						}

						setState(240);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(241);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(242);
						((BinaryContext)_localctx).op = match(T__26);
						setState(244);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(243);
							match(NL);
							}
						}

						setState(246);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(247);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(248);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(250);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(249);
							match(NL);
							}
						}

						setState(252);
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(253);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(254);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(256);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(255);
							match(NL);
							}
						}

						setState(258);
						((BinaryContext)_localctx).r = formula(6);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(259);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(260);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(262);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(261);
							match(NL);
							}
						}

						setState(264);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(265);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(266);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(268);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(267);
							match(NL);
							}
						}

						setState(270);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(271);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(272);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__49) | (1L << T__50) | (1L << T__51))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(274);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(273);
							match(NL);
							}
						}

						setState(276);
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(281);
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
			setState(282);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(283);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(284);
				match(T__0);
				setState(285);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(306);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(291);
				match(T__6);
				setState(292);
				type();
				}
				break;
			case 2:
				{
				setState(293);
				match(T__6);
				setState(294);
				match(T__15);
				setState(295);
				((QformulaContext)_localctx).lo = exp(0);
				setState(297);
				_la = _input.LA(1);
				if (_la==T__35) {
					{
					setState(296);
					((QformulaContext)_localctx).ll = match(T__35);
					}
				}

				setState(299);
				match(T__60);
				setState(301);
				_la = _input.LA(1);
				if (_la==T__35) {
					{
					setState(300);
					((QformulaContext)_localctx).lh = match(T__35);
					}
				}

				setState(303);
				((QformulaContext)_localctx).hi = exp(0);
				setState(304);
				match(T__16);
				}
				break;
			}
			setState(309);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(308);
				match(NL);
				}
			}

			setState(311);
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
			setState(316);
			switch (_input.LA(1)) {
			case T__61:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				((BooleanTypeContext)_localctx).t = match(T__61);
				}
				break;
			case T__18:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				((IntTypeContext)_localctx).t = match(T__18);
				}
				break;
			case T__19:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(315);
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
			setState(453);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				((PremiseContext)_localctx).t = match(T__62);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(322);
				switch (_input.LA(1)) {
				case T__63:
				case T__64:
					{
					setState(319);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__63 || _la==T__64) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__42:
				case T__44:
					{
					setState(320);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__42 || _la==T__44) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(321);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(324);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(325);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(329);
				switch (_input.LA(1)) {
				case T__65:
				case T__66:
				case T__67:
				case T__68:
					{
					setState(326);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (T__65 - 66)) | (1L << (T__66 - 66)) | (1L << (T__67 - 66)) | (1L << (T__68 - 66)))) != 0)) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__42:
				case T__44:
					{
					setState(327);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__42 || _la==T__44) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(335);
				switch (_input.LA(1)) {
				case T__69:
				case T__70:
				case T__71:
				case T__72:
					{
					setState(332);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)) | (1L << (T__72 - 70)))) != 0)) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__46:
				case T__48:
					{
					setState(333);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__46 || _la==T__48) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(341);
				switch (_input.LA(1)) {
				case T__73:
				case T__74:
					{
					setState(338);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__73 || _la==T__74) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__46:
				case T__48:
					{
					setState(339);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__46 || _la==T__48) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(340);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(343);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(344);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(345);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(346);
				((ImpliesIntroContext)_localctx).tb = match(T__75);
				setState(347);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(348);
				((ImpliesElimContext)_localctx).tb = match(T__76);
				setState(349);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(350);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(351);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(352);
				((ImpliesIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__50 || _la==T__51) ) {
					((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(353);
				match(ID);
				setState(354);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(355);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				      "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n      \"e\".equals(_input.LT(2).getText())");
				setState(356);
				((ImpliesElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__50 || _la==T__51) ) {
					((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(357);
				match(ID);
				setState(358);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(359);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(360);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__77 || _la==T__78) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(361);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 11:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(362);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__79 || _la==T__80) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(363);
				((NegElimContext)_localctx).step = match(NUM);
				setState(364);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 12:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(365);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(366);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(367);
				match(ID);
				setState(368);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(369);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(370);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(371);
				match(ID);
				setState(372);
				((NegElimContext)_localctx).step = match(NUM);
				setState(373);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 14:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(377);
				switch (_input.LA(1)) {
				case T__81:
				case T__82:
					{
					setState(374);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__81 || _la==T__82) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__13:
				case T__14:
					{
					setState(375);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==T__14) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(376);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(379);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 15:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(380);
				((PbcContext)_localctx).tb = match(T__83);
				setState(381);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 16:
				_localctx = new Subst1Context(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(382);
				((Subst1Context)_localctx).tb = match(T__84);
				setState(383);
				((Subst1Context)_localctx).eqStep = numOrId();
				setState(384);
				((Subst1Context)_localctx).step = match(NUM);
				}
				break;
			case 17:
				_localctx = new Subst2Context(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(386);
				((Subst2Context)_localctx).tb = match(T__85);
				setState(387);
				((Subst2Context)_localctx).eqStep = numOrId();
				setState(388);
				((Subst2Context)_localctx).step = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(390);
				((AlgebraContext)_localctx).tb = match(T__86);
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(391);
					((AlgebraContext)_localctx).numOrId = numOrId();
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).numOrId);
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
				if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (T__87 - 88)) | (1L << (T__88 - 88)) | (1L << (T__89 - 88)))) != 0)) ) {
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
				if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (T__90 - 91)) | (1L << (T__91 - 91)) | (1L << (T__92 - 91)))) != 0)) ) {
					((ForallElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(400);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0) || _la==NUM || _la==ID );
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
				((ForallIntroContext)_localctx).tb = match(T__55);
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
				((ForallElimContext)_localctx).tb = match(T__55);
				setState(412);
				match(ID);
				setState(413);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 23:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(419);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (T__93 - 94)) | (1L << (T__94 - 94)) | (1L << (T__95 - 94)))) != 0)) ) {
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 24:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(426);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (T__96 - 97)) | (1L << (T__97 - 97)) | (1L << (T__98 - 97)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(427);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(428);
				((ExistsElimContext)_localctx).subproof = match(NUM);
				}
				break;
			case 25:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(430);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(431);
				((ExistsIntroContext)_localctx).tb = match(T__59);
				setState(432);
				match(ID);
				setState(433);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(435); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(434);
					formula(0);
					}
					}
					setState(437); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 26:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(439);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(440);
				((ExistsElimContext)_localctx).tb = match(T__59);
				setState(441);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(442);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(443);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 27:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(445);
				((InvariantContext)_localctx).tb = match(T__99);
				}
				break;
			case 28:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(446);
				((AutoContext)_localctx).tb = match(T__100);
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(447);
					((AutoContext)_localctx).numOrId = numOrId();
					((AutoContext)_localctx).stepOrFacts.add(((AutoContext)_localctx).numOrId);
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
			setState(455);
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
		enterRule(_localctx, 18, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(457);
				match(NL);
				}
				}
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(488);
			_la = _input.LA(1);
			if (_la==T__101) {
				{
				setState(463);
				((ProgramContext)_localctx).tb = match(T__101);
				setState(464);
				((ProgramContext)_localctx).org = match(ID);
				setState(465);
				match(T__5);
				setState(466);
				((ProgramContext)_localctx).sireum = match(ID);
				setState(467);
				match(T__5);
				setState(468);
				match(T__102);
				setState(469);
				match(T__5);
				setState(470);
				((ProgramContext)_localctx).te = match(T__103);
				setState(472); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(471);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(474); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(485);
				switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
				case 1:
					{
					setState(476);
					match(T__104);
					setState(477);
					facts();
					setState(478);
					((ProgramContext)_localctx).te = match(T__105);
					setState(482);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(479);
							match(NL);
							}
							} 
						}
						setState(484);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
					}
					}
					break;
				}
				setState(487);
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
		enterRule(_localctx, 20, RULE_facts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			match(T__3);
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
			((FactsContext)_localctx).ftb = match(T__106);
			setState(501);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(498);
					match(NL);
					}
					} 
				}
				setState(503);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			}
			setState(505);
			_la = _input.LA(1);
			if (_la==T__107 || _la==ID) {
				{
				setState(504);
				factOrFun();
				}
			}

			setState(517);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(508); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(507);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(510); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(513);
				_la = _input.LA(1);
				if (_la==T__107 || _la==ID) {
					{
					setState(512);
					factOrFun();
					}
				}

				}
				}
				setState(519);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(520);
			((FactsContext)_localctx).te = match(T__4);
			setState(524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(521);
				match(NL);
				}
				}
				setState(526);
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
			setState(529);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(527);
				fact();
				}
				break;
			case T__107:
				enterOuterAlt(_localctx, 2);
				{
				setState(528);
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
			setState(531);
			match(ID);
			setState(532);
			match(T__5);
			setState(533);
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
			setState(535);
			((FunContext)_localctx).tb = match(T__107);
			setState(536);
			match(ID);
			setState(538);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(537);
				match(NL);
				}
			}

			setState(540);
			match(T__15);
			setState(541);
			param();
			setState(546);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(542);
				match(T__0);
				setState(543);
				param();
				}
				}
				setState(548);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(549);
			match(T__16);
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
			setState(553);
			match(ID);
			setState(554);
			match(T__6);
			setState(555);
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
			setState(558);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__32))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (T__104 - 105)) | (1L << (T__107 - 105)) | (1L << (T__108 - 105)) | (1L << (T__109 - 105)) | (1L << (T__110 - 105)) | (1L << (T__111 - 105)) | (1L << (T__113 - 105)) | (1L << (T__114 - 105)) | (1L << (T__115 - 105)) | (1L << (T__116 - 105)) | (1L << (T__119 - 105)) | (1L << (T__120 - 105)) | (1L << (NUM - 105)) | (1L << (ID - 105)))) != 0)) {
				{
				setState(557);
				stmt();
				}
			}

			setState(570);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(561); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(560);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(563); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(566);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__32))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (T__104 - 105)) | (1L << (T__107 - 105)) | (1L << (T__108 - 105)) | (1L << (T__109 - 105)) | (1L << (T__110 - 105)) | (1L << (T__111 - 105)) | (1L << (T__113 - 105)) | (1L << (T__114 - 105)) | (1L << (T__115 - 105)) | (1L << (T__116 - 105)) | (1L << (T__119 - 105)) | (1L << (T__120 - 105)) | (1L << (NUM - 105)) | (1L << (ID - 105)))) != 0)) {
					{
					setState(565);
					stmt();
					}
				}

				}
				}
				setState(572);
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
		public TerminalNode SSTRING() { return getToken(Antlr4LogikaParser.SSTRING, 0); }
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
			setState(741);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(573);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__108 || _la==T__109) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(574);
				match(ID);
				setState(575);
				match(T__6);
				setState(576);
				type();
				setState(577);
				match(T__27);
				setState(579);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(578);
					match(NL);
					}
				}

				setState(581);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(583);
				match(ID);
				setState(584);
				match(T__27);
				setState(586);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(585);
					match(NL);
					}
				}

				setState(588);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssumeStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(589);
				match(T__7);
				setState(590);
				match(T__15);
				setState(591);
				exp(0);
				setState(592);
				match(T__16);
				}
				break;
			case 4:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(594);
				match(T__110);
				setState(595);
				match(T__15);
				setState(596);
				exp(0);
				setState(597);
				match(T__16);
				}
				break;
			case 5:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(599);
				match(T__111);
				setState(600);
				match(T__15);
				setState(601);
				exp(0);
				setState(602);
				match(T__16);
				setState(606);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(603);
					match(NL);
					}
					}
					setState(608);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(609);
				match(T__3);
				setState(610);
				((IfStmtContext)_localctx).ts = stmts();
				setState(611);
				match(T__4);
				setState(623);
				_la = _input.LA(1);
				if (_la==T__112) {
					{
					setState(612);
					match(T__112);
					setState(616);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(613);
						match(NL);
						}
						}
						setState(618);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(619);
					match(T__3);
					setState(620);
					((IfStmtContext)_localctx).fs = stmts();
					setState(621);
					match(T__4);
					}
				}

				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(625);
				match(T__113);
				setState(626);
				match(T__15);
				setState(627);
				exp(0);
				setState(628);
				match(T__16);
				setState(632);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(629);
					match(NL);
					}
					}
					setState(634);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(635);
				match(T__3);
				setState(646);
				switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
				case 1:
					{
					setState(639);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(636);
						match(NL);
						}
						}
						setState(641);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(642);
					match(T__104);
					setState(643);
					loopInvariant();
					setState(644);
					match(T__105);
					}
					break;
				}
				setState(648);
				stmts();
				setState(649);
				match(T__4);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(651);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__114 || _la==T__115) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(652);
				match(T__15);
				setState(653);
				match(SSTRING);
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
				if (_la==T__116) {
					{
					setState(665);
					match(T__116);
					setState(666);
					((MethodDeclStmtContext)_localctx).helper = match(ID);
					}
				}

				setState(669);
				match(T__107);
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
				case T__61:
					{
					setState(687);
					type();
					}
					break;
				case T__117:
					{
					setState(688);
					match(T__117);
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
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
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
					match(T__104);
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
					match(T__105);
					}
					break;
				}
				setState(717);
				stmts();
				setState(728);
				_la = _input.LA(1);
				if (_la==T__118) {
					{
					setState(718);
					((MethodDeclStmtContext)_localctx).rtb = match(T__118);
					setState(720);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__32))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (T__119 - 120)) | (1L << (T__120 - 120)) | (1L << (NUM - 120)) | (1L << (ID - 120)))) != 0)) {
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
				match(T__104);
				setState(736);
				switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
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
				}
				setState(738);
				match(T__105);
				}
				break;
			case 11:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(740);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(795);
			switch (_input.LA(1)) {
			case T__24:
			case T__32:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(744);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__32) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(745);
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
				setState(746);
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
				setState(747);
				match(NUM);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(748);
				((IdExpContext)_localctx).tb = match(ID);
				setState(763);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(749);
					((IdExpContext)_localctx).t = match(T__15);
					setState(758);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__32))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (T__119 - 120)) | (1L << (T__120 - 120)) | (1L << (NUM - 120)) | (1L << (ID - 120)))) != 0)) {
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
				case 2:
					{
					setState(761);
					match(T__5);
					setState(762);
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
				setState(765);
				match(T__18);
				setState(766);
				match(T__15);
				setState(767);
				match(STRING);
				setState(768);
				match(T__16);
				}
				break;
			case T__19:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(769);
				match(T__19);
				setState(770);
				match(T__15);
				setState(779);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__32))) != 0) || ((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (T__119 - 120)) | (1L << (T__120 - 120)) | (1L << (NUM - 120)) | (1L << (ID - 120)))) != 0)) {
					{
					setState(771);
					exp(0);
					setState(776);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(772);
						match(T__0);
						setState(773);
						exp(0);
						}
						}
						setState(778);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(781);
				match(T__16);
				}
				break;
			case T__119:
				{
				_localctx = new RandomIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(782);
				match(T__119);
				setState(783);
				match(T__15);
				setState(784);
				match(T__16);
				}
				break;
			case T__120:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(785);
				match(T__120);
				setState(786);
				match(T__15);
				setState(788);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(787);
					match(STRING);
					}
				}

				setState(790);
				match(T__16);
				}
				break;
			case T__15:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(791);
				match(T__15);
				setState(792);
				exp(0);
				setState(793);
				match(T__16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(841);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(839);
					switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(797);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(798);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
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
						((BinaryExpContext)_localctx).r = exp(8);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(803);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(804);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(806);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(805);
							match(NL);
							}
						}

						setState(808);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(809);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(810);
						((BinaryExpContext)_localctx).op = match(T__26);
						setState(812);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(811);
							match(NL);
							}
						}

						setState(814);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(815);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(816);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__38) | (1L << T__39))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(818);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(817);
							match(NL);
							}
						}

						setState(820);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(821);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(822);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(824);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(823);
							match(NL);
							}
						}

						setState(826);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(827);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(828);
						((BinaryExpContext)_localctx).op = match(T__42);
						setState(830);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(829);
							match(NL);
							}
						}

						setState(832);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(833);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(834);
						((BinaryExpContext)_localctx).op = match(T__46);
						setState(836);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(835);
							match(NL);
							}
						}

						setState(838);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(843);
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
		enterRule(_localctx, 36, RULE_loopInvariant);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(844);
			((LoopInvariantContext)_localctx).tb = match(T__3);
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
			((LoopInvariantContext)_localctx).itb = match(T__99);
			setState(855);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,116,_ctx);
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
				_alt = getInterpreter().adaptivePredict(_input,116,_ctx);
			}
			setState(859);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0) || _la==NUM || _la==ID) {
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
					_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(867);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0) || _la==NUM || _la==ID) {
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
			modifies();
			setState(875);
			((LoopInvariantContext)_localctx).te = match(T__4);
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
		enterRule(_localctx, 38, RULE_modifies);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(882);
			((ModifiesContext)_localctx).tb = match(T__121);
			setState(891);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(883);
				match(ID);
				setState(888);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(884);
					match(T__0);
					setState(885);
					match(ID);
					}
					}
					setState(890);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(896);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(893);
					match(NL);
					}
					} 
				}
				setState(898);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
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
		enterRule(_localctx, 40, RULE_methodContract);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(899);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(903);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(900);
					match(NL);
					}
					} 
				}
				setState(905);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			}
			setState(927);
			_la = _input.LA(1);
			if (_la==T__122 || _la==T__123) {
				{
				setState(906);
				_la = _input.LA(1);
				if ( !(_la==T__122 || _la==T__123) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(910);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(907);
					match(NL);
					}
					}
					setState(912);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(913);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(924);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(915); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(914);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(917); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(920);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0) || _la==NUM || _la==ID) {
							{
							setState(919);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(926);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,129,_ctx);
				}
				}
			}

			setState(932);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(929);
					match(NL);
					}
					} 
				}
				setState(934);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			}
			setState(936);
			_la = _input.LA(1);
			if (_la==T__121) {
				{
				setState(935);
				modifies();
				}
			}

			setState(959);
			_la = _input.LA(1);
			if (_la==T__124 || _la==T__125) {
				{
				setState(938);
				_la = _input.LA(1);
				if ( !(_la==T__124 || _la==T__125) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(942);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(939);
					match(NL);
					}
					}
					setState(944);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(945);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(956);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(947); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(946);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(949); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(952);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0) || _la==NUM || _la==ID) {
							{
							setState(951);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(958);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
				}
				}
			}

			setState(964);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(961);
				match(NL);
				}
				}
				setState(966);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(967);
			((MethodContractContext)_localctx).te = match(T__4);
			setState(971);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(968);
					match(NL);
					}
					} 
				}
				setState(973);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
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
		enterRule(_localctx, 42, RULE_invariants);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(974);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(978);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(975);
				match(NL);
				}
				}
				setState(980);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(981);
			match(T__99);
			setState(985);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(982);
					match(NL);
					}
					} 
				}
				setState(987);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			}
			setState(989);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0) || _la==NUM || _la==ID) {
				{
				setState(988);
				formula(0);
				}
			}

			setState(1001);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(992); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(991);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(994); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,143,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(997);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0) || _la==NUM || _la==ID) {
					{
					setState(996);
					formula(0);
					}
				}

				}
				}
				setState(1003);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1004);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(1008);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1005);
				match(NL);
				}
				}
				setState(1010);
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
		case 17:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u008b\u03f6\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\7\2\61\n\2"+
		"\f\2\16\2\64\13\2\3\2\5\2\67\n\2\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\3"+
		"\2\3\2\3\2\5\2D\n\2\3\3\3\3\3\3\7\3I\n\3\f\3\16\3L\13\3\5\3N\n\3\3\3\3"+
		"\3\3\3\3\3\7\3T\n\3\f\3\16\3W\13\3\3\3\7\3Z\n\3\f\3\16\3]\13\3\3\3\3\3"+
		"\6\3a\n\3\r\3\16\3b\5\3e\n\3\3\4\3\4\5\4i\n\4\3\4\6\4l\n\4\r\4\16\4m\3"+
		"\4\5\4q\n\4\7\4s\n\4\f\4\16\4v\13\4\3\4\3\4\7\4z\n\4\f\4\16\4}\13\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0087\n\5\f\5\16\5\u008a\13\5\3\5\3"+
		"\5\7\5\u008e\n\5\f\5\16\5\u0091\13\5\3\5\3\5\3\5\3\5\3\5\5\5\u0098\n\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00a0\n\5\3\5\3\5\3\5\5\5\u00a5\n\5\3\5\6"+
		"\5\u00a8\n\5\r\5\16\5\u00a9\3\5\5\5\u00ad\n\5\7\5\u00af\n\5\f\5\16\5\u00b2"+
		"\13\5\3\5\5\5\u00b5\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00c0"+
		"\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00cc\n\6\f\6\16\6\u00cf"+
		"\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00dd\n\6\f"+
		"\6\16\6\u00e0\13\6\5\6\u00e2\n\6\3\6\3\6\5\6\u00e6\n\6\3\6\3\6\3\6\5\6"+
		"\u00eb\n\6\3\6\3\6\3\6\3\6\5\6\u00f1\n\6\3\6\3\6\3\6\3\6\5\6\u00f7\n\6"+
		"\3\6\3\6\3\6\3\6\5\6\u00fd\n\6\3\6\3\6\3\6\3\6\5\6\u0103\n\6\3\6\3\6\3"+
		"\6\3\6\5\6\u0109\n\6\3\6\3\6\3\6\3\6\5\6\u010f\n\6\3\6\3\6\3\6\3\6\5\6"+
		"\u0115\n\6\3\6\7\6\u0118\n\6\f\6\16\6\u011b\13\6\3\7\3\7\3\7\3\7\7\7\u0121"+
		"\n\7\f\7\16\7\u0124\13\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u012c\n\7\3\7\3\7"+
		"\5\7\u0130\n\7\3\7\3\7\3\7\5\7\u0135\n\7\3\7\5\7\u0138\n\7\3\7\3\7\3\b"+
		"\3\b\3\b\5\b\u013f\n\b\3\t\3\t\3\t\3\t\5\t\u0145\n\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\t\u014c\n\t\3\t\3\t\3\t\3\t\5\t\u0152\n\t\3\t\3\t\3\t\3\t\5\t\u0158"+
		"\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\t\u017c\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t"+
		"\u018b\n\t\f\t\16\t\u018e\13\t\3\t\3\t\3\t\3\t\3\t\6\t\u0195\n\t\r\t\16"+
		"\t\u0196\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\t\u01a2\n\t\r\t\16\t\u01a3"+
		"\3\t\3\t\3\t\6\t\u01a9\n\t\r\t\16\t\u01aa\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\6\t\u01b6\n\t\r\t\16\t\u01b7\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\7\t\u01c3\n\t\f\t\16\t\u01c6\13\t\5\t\u01c8\n\t\3\n\3\n\3\13\7\13"+
		"\u01cd\n\13\f\13\16\13\u01d0\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\6\13\u01db\n\13\r\13\16\13\u01dc\3\13\3\13\3\13\3\13\7\13\u01e3"+
		"\n\13\f\13\16\13\u01e6\13\13\5\13\u01e8\n\13\3\13\5\13\u01eb\n\13\3\f"+
		"\3\f\7\f\u01ef\n\f\f\f\16\f\u01f2\13\f\3\f\3\f\7\f\u01f6\n\f\f\f\16\f"+
		"\u01f9\13\f\3\f\5\f\u01fc\n\f\3\f\6\f\u01ff\n\f\r\f\16\f\u0200\3\f\5\f"+
		"\u0204\n\f\7\f\u0206\n\f\f\f\16\f\u0209\13\f\3\f\3\f\7\f\u020d\n\f\f\f"+
		"\16\f\u0210\13\f\3\r\3\r\5\r\u0214\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\5\17\u021d\n\17\3\17\3\17\3\17\3\17\7\17\u0223\n\17\f\17\16\17\u0226"+
		"\13\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\5\21\u0231\n\21\3"+
		"\21\6\21\u0234\n\21\r\21\16\21\u0235\3\21\5\21\u0239\n\21\7\21\u023b\n"+
		"\21\f\21\16\21\u023e\13\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0246\n"+
		"\22\3\22\3\22\3\22\3\22\3\22\5\22\u024d\n\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u025f\n\22"+
		"\f\22\16\22\u0262\13\22\3\22\3\22\3\22\3\22\3\22\7\22\u0269\n\22\f\22"+
		"\16\22\u026c\13\22\3\22\3\22\3\22\3\22\5\22\u0272\n\22\3\22\3\22\3\22"+
		"\3\22\3\22\7\22\u0279\n\22\f\22\16\22\u027c\13\22\3\22\3\22\7\22\u0280"+
		"\n\22\f\22\16\22\u0283\13\22\3\22\3\22\3\22\3\22\5\22\u0289\n\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0298"+
		"\n\22\3\22\3\22\3\22\3\22\5\22\u029e\n\22\3\22\3\22\3\22\5\22\u02a3\n"+
		"\22\3\22\3\22\3\22\3\22\7\22\u02a9\n\22\f\22\16\22\u02ac\13\22\5\22\u02ae"+
		"\n\22\3\22\3\22\3\22\3\22\5\22\u02b4\n\22\3\22\3\22\7\22\u02b8\n\22\f"+
		"\22\16\22\u02bb\13\22\3\22\3\22\7\22\u02bf\n\22\f\22\16\22\u02c2\13\22"+
		"\3\22\3\22\3\22\7\22\u02c7\n\22\f\22\16\22\u02ca\13\22\3\22\3\22\5\22"+
		"\u02ce\n\22\3\22\3\22\3\22\5\22\u02d3\n\22\3\22\7\22\u02d6\n\22\f\22\16"+
		"\22\u02d9\13\22\5\22\u02db\n\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u02e3"+
		"\n\22\3\22\3\22\3\22\5\22\u02e8\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\7\23\u02f4\n\23\f\23\16\23\u02f7\13\23\5\23\u02f9\n\23"+
		"\3\23\3\23\3\23\5\23\u02fe\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\7\23\u0309\n\23\f\23\16\23\u030c\13\23\5\23\u030e\n\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u0317\n\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u031e\n\23\3\23\3\23\3\23\5\23\u0323\n\23\3\23\3\23\3\23\3\23\5\23\u0329"+
		"\n\23\3\23\3\23\3\23\3\23\5\23\u032f\n\23\3\23\3\23\3\23\3\23\5\23\u0335"+
		"\n\23\3\23\3\23\3\23\3\23\5\23\u033b\n\23\3\23\3\23\3\23\3\23\5\23\u0341"+
		"\n\23\3\23\3\23\3\23\3\23\5\23\u0347\n\23\3\23\7\23\u034a\n\23\f\23\16"+
		"\23\u034d\13\23\3\24\3\24\7\24\u0351\n\24\f\24\16\24\u0354\13\24\3\24"+
		"\3\24\7\24\u0358\n\24\f\24\16\24\u035b\13\24\3\24\5\24\u035e\n\24\3\24"+
		"\6\24\u0361\n\24\r\24\16\24\u0362\3\24\5\24\u0366\n\24\7\24\u0368\n\24"+
		"\f\24\16\24\u036b\13\24\3\24\3\24\3\24\7\24\u0370\n\24\f\24\16\24\u0373"+
		"\13\24\3\25\3\25\3\25\3\25\7\25\u0379\n\25\f\25\16\25\u037c\13\25\5\25"+
		"\u037e\n\25\3\25\7\25\u0381\n\25\f\25\16\25\u0384\13\25\3\26\3\26\7\26"+
		"\u0388\n\26\f\26\16\26\u038b\13\26\3\26\3\26\7\26\u038f\n\26\f\26\16\26"+
		"\u0392\13\26\3\26\3\26\6\26\u0396\n\26\r\26\16\26\u0397\3\26\5\26\u039b"+
		"\n\26\7\26\u039d\n\26\f\26\16\26\u03a0\13\26\5\26\u03a2\n\26\3\26\7\26"+
		"\u03a5\n\26\f\26\16\26\u03a8\13\26\3\26\5\26\u03ab\n\26\3\26\3\26\7\26"+
		"\u03af\n\26\f\26\16\26\u03b2\13\26\3\26\3\26\6\26\u03b6\n\26\r\26\16\26"+
		"\u03b7\3\26\5\26\u03bb\n\26\7\26\u03bd\n\26\f\26\16\26\u03c0\13\26\5\26"+
		"\u03c2\n\26\3\26\7\26\u03c5\n\26\f\26\16\26\u03c8\13\26\3\26\3\26\7\26"+
		"\u03cc\n\26\f\26\16\26\u03cf\13\26\3\27\3\27\7\27\u03d3\n\27\f\27\16\27"+
		"\u03d6\13\27\3\27\3\27\7\27\u03da\n\27\f\27\16\27\u03dd\13\27\3\27\5\27"+
		"\u03e0\n\27\3\27\6\27\u03e3\n\27\r\27\16\27\u03e4\3\27\5\27\u03e8\n\27"+
		"\7\27\u03ea\n\27\f\27\16\27\u03ed\13\27\3\27\3\27\7\27\u03f1\n\27\f\27"+
		"\16\27\u03f4\13\27\3\27\2\4\n$\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,\2%\3\2\4\5\3\2\"%\3\2\13\21\3\2\27\31\3\2\32\34\3\2\36!\3"+
		"\2&+\3\2,/\3\2\60\63\3\2\64\66\3\2\67>\3\2BC\4\2--//\3\2DG\3\2HK\4\2\61"+
		"\61\63\63\3\2LM\3\2\65\66\3\2PQ\3\2RS\3\2#%\3\2TU\3\2\20\21\3\2Z\\\3\2"+
		"]_\3\2`b\3\2ce\3\2\u0082\u0083\3\2op\3\2uv\4\2\33\33##\4\2&\')*\3\2\37"+
		" \3\2}~\3\2\177\u0080\u04b5\2C\3\2\2\2\4d\3\2\2\2\6f\3\2\2\2\b\u00b4\3"+
		"\2\2\2\n\u00e5\3\2\2\2\f\u011c\3\2\2\2\16\u013e\3\2\2\2\20\u01c7\3\2\2"+
		"\2\22\u01c9\3\2\2\2\24\u01ce\3\2\2\2\26\u01ec\3\2\2\2\30\u0213\3\2\2\2"+
		"\32\u0215\3\2\2\2\34\u0219\3\2\2\2\36\u022b\3\2\2\2 \u0230\3\2\2\2\"\u02e7"+
		"\3\2\2\2$\u031d\3\2\2\2&\u034e\3\2\2\2(\u0374\3\2\2\2*\u0385\3\2\2\2,"+
		"\u03d0\3\2\2\2.\62\5\4\3\2/\61\7\u0087\2\2\60/\3\2\2\2\61\64\3\2\2\2\62"+
		"\60\3\2\2\2\62\63\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\65\67\5\6\4\2\66"+
		"\65\3\2\2\2\66\67\3\2\2\2\67;\3\2\2\28:\7\u0087\2\298\3\2\2\2:=\3\2\2"+
		"\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\7\2\2\3?D\3\2\2\2@A\5\24"+
		"\13\2AB\7\2\2\3BD\3\2\2\2C.\3\2\2\2C@\3\2\2\2D\3\3\2\2\2EJ\5\n\6\2FG\7"+
		"\3\2\2GI\5\n\6\2HF\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KN\3\2\2\2LJ\3"+
		"\2\2\2ME\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\t\2\2\2PU\5\n\6\2QR\7\3\2\2RT\5"+
		"\n\6\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2Ve\3\2\2\2WU\3\2\2\2XZ\5"+
		"\n\6\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2][\3\2\2\2^"+
		"`\7\u0081\2\2_a\5\n\6\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2"+
		"\2\2dM\3\2\2\2d[\3\2\2\2e\5\3\2\2\2fh\7\6\2\2gi\5\b\5\2hg\3\2\2\2hi\3"+
		"\2\2\2it\3\2\2\2jl\7\u0087\2\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2"+
		"np\3\2\2\2oq\5\b\5\2po\3\2\2\2pq\3\2\2\2qs\3\2\2\2rk\3\2\2\2sv\3\2\2\2"+
		"tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2\2w{\7\7\2\2xz\7\u0087\2\2yx\3\2"+
		"\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\7\3\2\2\2}{\3\2\2\2~\177\7\u0082\2"+
		"\2\177\u0080\7\b\2\2\u0080\u0081\5\n\6\2\u0081\u0082\5\20\t\2\u0082\u00b5"+
		"\3\2\2\2\u0083\u0084\7\u0082\2\2\u0084\u0088\7\b\2\2\u0085\u0087\7\u0087"+
		"\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008f\7\6"+
		"\2\2\u008c\u008e\7\u0087\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0092\u0093\7\u0082\2\2\u0093\u00a4\7\b\2\2\u0094\u0097\7\u0083\2"+
		"\2\u0095\u0096\7\t\2\2\u0096\u0098\5\16\b\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u00a5\3\2\2\2\u0099\u009a\5\n\6\2\u009a\u009b\7\n"+
		"\2\2\u009b\u00a5\3\2\2\2\u009c\u009f\7\u0083\2\2\u009d\u009e\7\t\2\2\u009e"+
		"\u00a0\5\16\b\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3"+
		"\2\2\2\u00a1\u00a2\5\n\6\2\u00a2\u00a3\7\n\2\2\u00a3\u00a5\3\2\2\2\u00a4"+
		"\u0094\3\2\2\2\u00a4\u0099\3\2\2\2\u00a4\u009c\3\2\2\2\u00a5\u00b0\3\2"+
		"\2\2\u00a6\u00a8\7\u0087\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00ad\5\b"+
		"\5\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae"+
		"\u00a7\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b5\7\7\2\2\u00b4"+
		"~\3\2\2\2\u00b4\u0083\3\2\2\2\u00b5\t\3\2\2\2\u00b6\u00b7\b\6\1\2\u00b7"+
		"\u00b8\7\33\2\2\u00b8\u00e6\5\n\6\13\u00b9\u00ba\t\3\2\2\u00ba\u00e6\5"+
		"\n\6\b\u00bb\u00e6\t\4\2\2\u00bc\u00bf\7\u0083\2\2\u00bd\u00be\7\b\2\2"+
		"\u00be\u00c0\7\u0083\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00e6\3\2\2\2\u00c1\u00c2\7\22\2\2\u00c2\u00c3\5\n\6\2\u00c3\u00c4\7"+
		"\23\2\2\u00c4\u00e6\3\2\2\2\u00c5\u00e6\7\24\2\2\u00c6\u00c7\7\u0083\2"+
		"\2\u00c7\u00c8\7\22\2\2\u00c8\u00cd\5\n\6\2\u00c9\u00ca\7\3\2\2\u00ca"+
		"\u00cc\5\n\6\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2"+
		"\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"\u00d1\7\23\2\2\u00d1\u00e6\3\2\2\2\u00d2\u00e6\7\u0082\2\2\u00d3\u00d4"+
		"\7\25\2\2\u00d4\u00d5\7\22\2\2\u00d5\u00d6\7\u0085\2\2\u00d6\u00e6\7\23"+
		"\2\2\u00d7\u00d8\7\26\2\2\u00d8\u00e1\7\22\2\2\u00d9\u00de\5$\23\2\u00da"+
		"\u00db\7\3\2\2\u00db\u00dd\5$\23\2\u00dc\u00da\3\2\2\2\u00dd\u00e0\3\2"+
		"\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e1\u00d9\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2"+
		"\2\2\u00e3\u00e6\7\23\2\2\u00e4\u00e6\5\f\7\2\u00e5\u00b6\3\2\2\2\u00e5"+
		"\u00b9\3\2\2\2\u00e5\u00bb\3\2\2\2\u00e5\u00bc\3\2\2\2\u00e5\u00c1\3\2"+
		"\2\2\u00e5\u00c5\3\2\2\2\u00e5\u00c6\3\2\2\2\u00e5\u00d2\3\2\2\2\u00e5"+
		"\u00d3\3\2\2\2\u00e5\u00d7\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6\u0119\3\2"+
		"\2\2\u00e7\u00e8\f\r\2\2\u00e8\u00ea\t\5\2\2\u00e9\u00eb\7\u0087\2\2\u00ea"+
		"\u00e9\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u0118\5\n"+
		"\6\16\u00ed\u00ee\f\f\2\2\u00ee\u00f0\t\6\2\2\u00ef\u00f1\7\u0087\2\2"+
		"\u00f0\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u0118"+
		"\5\n\6\r\u00f3\u00f4\f\n\2\2\u00f4\u00f6\7\35\2\2\u00f5\u00f7\7\u0087"+
		"\2\2\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u0118\5\n\6\13\u00f9\u00fa\f\t\2\2\u00fa\u00fc\t\7\2\2\u00fb\u00fd\7"+
		"\u0087\2\2\u00fc\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2"+
		"\u00fe\u0118\5\n\6\n\u00ff\u0100\f\7\2\2\u0100\u0102\t\b\2\2\u0101\u0103"+
		"\7\u0087\2\2\u0102\u0101\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2\2"+
		"\2\u0104\u0118\5\n\6\b\u0105\u0106\f\6\2\2\u0106\u0108\t\t\2\2\u0107\u0109"+
		"\7\u0087\2\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2"+
		"\2\u010a\u0118\5\n\6\7\u010b\u010c\f\5\2\2\u010c\u010e\t\n\2\2\u010d\u010f"+
		"\7\u0087\2\2\u010e\u010d\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2"+
		"\2\u0110\u0118\5\n\6\6\u0111\u0112\f\4\2\2\u0112\u0114\t\13\2\2\u0113"+
		"\u0115\7\u0087\2\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116"+
		"\3\2\2\2\u0116\u0118\5\n\6\5\u0117\u00e7\3\2\2\2\u0117\u00ed\3\2\2\2\u0117"+
		"\u00f3\3\2\2\2\u0117\u00f9\3\2\2\2\u0117\u00ff\3\2\2\2\u0117\u0105\3\2"+
		"\2\2\u0117\u010b\3\2\2\2\u0117\u0111\3\2\2\2\u0118\u011b\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\13\3\2\2\2\u011b\u0119\3\2\2"+
		"\2\u011c\u011d\t\f\2\2\u011d\u0122\7\u0083\2\2\u011e\u011f\7\3\2\2\u011f"+
		"\u0121\7\u0083\2\2\u0120\u011e\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120"+
		"\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0134\3\2\2\2\u0124\u0122\3\2\2\2\u0125"+
		"\u0126\7\t\2\2\u0126\u0135\5\16\b\2\u0127\u0128\7\t\2\2\u0128\u0129\7"+
		"\22\2\2\u0129\u012b\5$\23\2\u012a\u012c\7&\2\2\u012b\u012a\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012f\7?\2\2\u012e\u0130\7&\2"+
		"\2\u012f\u012e\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132"+
		"\5$\23\2\u0132\u0133\7\23\2\2\u0133\u0135\3\2\2\2\u0134\u0125\3\2\2\2"+
		"\u0134\u0127\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0137\3\2\2\2\u0136\u0138"+
		"\7\u0087\2\2\u0137\u0136\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139\3\2\2"+
		"\2\u0139\u013a\5\n\6\2\u013a\r\3\2\2\2\u013b\u013f\7@\2\2\u013c\u013f"+
		"\7\25\2\2\u013d\u013f\7\26\2\2\u013e\u013b\3\2\2\2\u013e\u013c\3\2\2\2"+
		"\u013e\u013d\3\2\2\2\u013f\17\3\2\2\2\u0140\u01c8\7A\2\2\u0141\u0145\t"+
		"\r\2\2\u0142\u0143\t\16\2\2\u0143\u0145\7\u0083\2\2\u0144\u0141\3\2\2"+
		"\2\u0144\u0142\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\7\u0082\2\2\u0147"+
		"\u01c8\7\u0082\2\2\u0148\u014c\t\17\2\2\u0149\u014a\t\16\2\2\u014a\u014c"+
		"\7\u0083\2\2\u014b\u0148\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014d\3\2\2"+
		"\2\u014d\u01c8\7\u0082\2\2\u014e\u0152\t\20\2\2\u014f\u0150\t\21\2\2\u0150"+
		"\u0152\7\u0083\2\2\u0151\u014e\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0153"+
		"\3\2\2\2\u0153\u01c8\7\u0082\2\2\u0154\u0158\t\22\2\2\u0155\u0156\t\21"+
		"\2\2\u0156\u0158\7\u0083\2\2\u0157\u0154\3\2\2\2\u0157\u0155\3\2\2\2\u0158"+
		"\u0159\3\2\2\2\u0159\u015a\7\u0082\2\2\u015a\u015b\7\u0082\2\2\u015b\u01c8"+
		"\7\u0082\2\2\u015c\u015d\7N\2\2\u015d\u01c8\7\u0082\2\2\u015e\u015f\7"+
		"O\2\2\u015f\u0160\7\u0082\2\2\u0160\u01c8\7\u0082\2\2\u0161\u0162\6\t"+
		"\n\2\u0162\u0163\t\23\2\2\u0163\u0164\7\u0083\2\2\u0164\u01c8\7\u0082"+
		"\2\2\u0165\u0166\6\t\13\2\u0166\u0167\t\23\2\2\u0167\u0168\7\u0083\2\2"+
		"\u0168\u0169\7\u0082\2\2\u0169\u01c8\7\u0082\2\2\u016a\u016b\t\24\2\2"+
		"\u016b\u01c8\7\u0082\2\2\u016c\u016d\t\25\2\2\u016d\u016e\7\u0082\2\2"+
		"\u016e\u01c8\7\u0082\2\2\u016f\u0170\6\t\f\2\u0170\u0171\t\26\2\2\u0171"+
		"\u0172\7\u0083\2\2\u0172\u01c8\7\u0082\2\2\u0173\u0174\6\t\r\2\u0174\u0175"+
		"\t\26\2\2\u0175\u0176\7\u0083\2\2\u0176\u0177\7\u0082\2\2\u0177\u01c8"+
		"\7\u0082\2\2\u0178\u017c\t\27\2\2\u0179\u017a\t\30\2\2\u017a\u017c\7\u0083"+
		"\2\2\u017b\u0178\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u017d\3\2\2\2\u017d"+
		"\u01c8\7\u0082\2\2\u017e\u017f\7V\2\2\u017f\u01c8\7\u0082\2\2\u0180\u0181"+
		"\7W\2\2\u0181\u0182\5\22\n\2\u0182\u0183\7\u0082\2\2\u0183\u01c8\3\2\2"+
		"\2\u0184\u0185\7X\2\2\u0185\u0186\5\22\n\2\u0186\u0187\7\u0082\2\2\u0187"+
		"\u01c8\3\2\2\2\u0188\u018c\7Y\2\2\u0189\u018b\5\22\n\2\u018a\u0189\3\2"+
		"\2\2\u018b\u018e\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d"+
		"\u01c8\3\2\2\2\u018e\u018c\3\2\2\2\u018f\u0190\t\31\2\2\u0190\u01c8\7"+
		"\u0082\2\2\u0191\u0192\t\32\2\2\u0192\u0194\5\22\n\2\u0193\u0195\5\n\6"+
		"\2\u0194\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197"+
		"\3\2\2\2\u0197\u01c8\3\2\2\2\u0198\u0199\6\t\16\2\u0199\u019a\7:\2\2\u019a"+
		"\u019b\7\u0083\2\2\u019b\u01c8\7\u0082\2\2\u019c\u019d\6\t\17\2\u019d"+
		"\u019e\7:\2\2\u019e\u019f\7\u0083\2\2\u019f\u01a1\5\22\n\2\u01a0\u01a2"+
		"\5\n\6\2\u01a1\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3"+
		"\u01a4\3\2\2\2\u01a4\u01c8\3\2\2\2\u01a5\u01a6\t\33\2\2\u01a6\u01a8\7"+
		"\u0082\2\2\u01a7\u01a9\5\n\6\2\u01a8\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2"+
		"\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01c8\3\2\2\2\u01ac\u01ad"+
		"\t\34\2\2\u01ad\u01ae\5\22\n\2\u01ae\u01af\7\u0082\2\2\u01af\u01c8\3\2"+
		"\2\2\u01b0\u01b1\6\t\20\2\u01b1\u01b2\7>\2\2\u01b2\u01b3\7\u0083\2\2\u01b3"+
		"\u01b5\7\u0082\2\2\u01b4\u01b6\5\n\6\2\u01b5\u01b4\3\2\2\2\u01b6\u01b7"+
		"\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01c8\3\2\2\2\u01b9"+
		"\u01ba\6\t\21\2\u01ba\u01bb\7>\2\2\u01bb\u01bc\7\u0083\2\2\u01bc\u01bd"+
		"\5\22\n\2\u01bd\u01be\7\u0082\2\2\u01be\u01c8\3\2\2\2\u01bf\u01c8\7f\2"+
		"\2\u01c0\u01c4\7g\2\2\u01c1\u01c3\5\22\n\2\u01c2\u01c1\3\2\2\2\u01c3\u01c6"+
		"\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6"+
		"\u01c4\3\2\2\2\u01c7\u0140\3\2\2\2\u01c7\u0144\3\2\2\2\u01c7\u014b\3\2"+
		"\2\2\u01c7\u0151\3\2\2\2\u01c7\u0157\3\2\2\2\u01c7\u015c\3\2\2\2\u01c7"+
		"\u015e\3\2\2\2\u01c7\u0161\3\2\2\2\u01c7\u0165\3\2\2\2\u01c7\u016a\3\2"+
		"\2\2\u01c7\u016c\3\2\2\2\u01c7\u016f\3\2\2\2\u01c7\u0173\3\2\2\2\u01c7"+
		"\u017b\3\2\2\2\u01c7\u017e\3\2\2\2\u01c7\u0180\3\2\2\2\u01c7\u0184\3\2"+
		"\2\2\u01c7\u0188\3\2\2\2\u01c7\u018f\3\2\2\2\u01c7\u0191\3\2\2\2\u01c7"+
		"\u0198\3\2\2\2\u01c7\u019c\3\2\2\2\u01c7\u01a5\3\2\2\2\u01c7\u01ac\3\2"+
		"\2\2\u01c7\u01b0\3\2\2\2\u01c7\u01b9\3\2\2\2\u01c7\u01bf\3\2\2\2\u01c7"+
		"\u01c0\3\2\2\2\u01c8\21\3\2\2\2\u01c9\u01ca\t\35\2\2\u01ca\23\3\2\2\2"+
		"\u01cb\u01cd\7\u0087\2\2\u01cc\u01cb\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce"+
		"\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01ea\3\2\2\2\u01d0\u01ce\3\2"+
		"\2\2\u01d1\u01d2\7h\2\2\u01d2\u01d3\7\u0083\2\2\u01d3\u01d4\7\b\2\2\u01d4"+
		"\u01d5\7\u0083\2\2\u01d5\u01d6\7\b\2\2\u01d6\u01d7\7i\2\2\u01d7\u01d8"+
		"\7\b\2\2\u01d8\u01da\7j\2\2\u01d9\u01db\7\u0087\2\2\u01da\u01d9\3\2\2"+
		"\2\u01db\u01dc\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01e7"+
		"\3\2\2\2\u01de\u01df\7k\2\2\u01df\u01e0\5\26\f\2\u01e0\u01e4\7l\2\2\u01e1"+
		"\u01e3\7\u0087\2\2\u01e2\u01e1\3\2\2\2\u01e3\u01e6\3\2\2\2\u01e4\u01e2"+
		"\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e7"+
		"\u01de\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01eb\5 "+
		"\21\2\u01ea\u01d1\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\25\3\2\2\2\u01ec\u01f0"+
		"\7\6\2\2\u01ed\u01ef\7\u0087\2\2\u01ee\u01ed\3\2\2\2\u01ef\u01f2\3\2\2"+
		"\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f3\3\2\2\2\u01f2\u01f0"+
		"\3\2\2\2\u01f3\u01f7\7m\2\2\u01f4\u01f6\7\u0087\2\2\u01f5\u01f4\3\2\2"+
		"\2\u01f6\u01f9\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01fb"+
		"\3\2\2\2\u01f9\u01f7\3\2\2\2\u01fa\u01fc\5\30\r\2\u01fb\u01fa\3\2\2\2"+
		"\u01fb\u01fc\3\2\2\2\u01fc\u0207\3\2\2\2\u01fd\u01ff\7\u0087\2\2\u01fe"+
		"\u01fd\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u01fe\3\2\2\2\u0200\u0201\3\2"+
		"\2\2\u0201\u0203\3\2\2\2\u0202\u0204\5\30\r\2\u0203\u0202\3\2\2\2\u0203"+
		"\u0204\3\2\2\2\u0204\u0206\3\2\2\2\u0205\u01fe\3\2\2\2\u0206\u0209\3\2"+
		"\2\2\u0207\u0205\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u020a\3\2\2\2\u0209"+
		"\u0207\3\2\2\2\u020a\u020e\7\7\2\2\u020b\u020d\7\u0087\2\2\u020c\u020b"+
		"\3\2\2\2\u020d\u0210\3\2\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f"+
		"\27\3\2\2\2\u0210\u020e\3\2\2\2\u0211\u0214\5\32\16\2\u0212\u0214\5\34"+
		"\17\2\u0213\u0211\3\2\2\2\u0213\u0212\3\2\2\2\u0214\31\3\2\2\2\u0215\u0216"+
		"\7\u0083\2\2\u0216\u0217\7\b\2\2\u0217\u0218\5\n\6\2\u0218\33\3\2\2\2"+
		"\u0219\u021a\7n\2\2\u021a\u021c\7\u0083\2\2\u021b\u021d\7\u0087\2\2\u021c"+
		"\u021b\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u021f\7\22"+
		"\2\2\u021f\u0224\5\36\20\2\u0220\u0221\7\3\2\2\u0221\u0223\5\36\20\2\u0222"+
		"\u0220\3\2\2\2\u0223\u0226\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2"+
		"\2\2\u0225\u0227\3\2\2\2\u0226\u0224\3\2\2\2\u0227\u0228\7\23\2\2\u0228"+
		"\u0229\7\t\2\2\u0229\u022a\5\16\b\2\u022a\35\3\2\2\2\u022b\u022c\7\u0083"+
		"\2\2\u022c\u022d\7\t\2\2\u022d\u022e\5\16\b\2\u022e\37\3\2\2\2\u022f\u0231"+
		"\5\"\22\2\u0230\u022f\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u023c\3\2\2\2"+
		"\u0232\u0234\7\u0087\2\2\u0233\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235"+
		"\u0233\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0238\3\2\2\2\u0237\u0239\5\""+
		"\22\2\u0238\u0237\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023b\3\2\2\2\u023a"+
		"\u0233\3\2\2\2\u023b\u023e\3\2\2\2\u023c\u023a\3\2\2\2\u023c\u023d\3\2"+
		"\2\2\u023d!\3\2\2\2\u023e\u023c\3\2\2\2\u023f\u0240\t\36\2\2\u0240\u0241"+
		"\7\u0083\2\2\u0241\u0242\7\t\2\2\u0242\u0243\5\16\b\2\u0243\u0245\7\36"+
		"\2\2\u0244\u0246\7\u0087\2\2\u0245\u0244\3\2\2\2\u0245\u0246\3\2\2\2\u0246"+
		"\u0247\3\2\2\2\u0247\u0248\5$\23\2\u0248\u02e8\3\2\2\2\u0249\u024a\7\u0083"+
		"\2\2\u024a\u024c\7\36\2\2\u024b\u024d\7\u0087\2\2\u024c\u024b\3\2\2\2"+
		"\u024c\u024d\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u02e8\5$\23\2\u024f\u0250"+
		"\7\n\2\2\u0250\u0251\7\22\2\2\u0251\u0252\5$\23\2\u0252\u0253\7\23\2\2"+
		"\u0253\u02e8\3\2\2\2\u0254\u0255\7q\2\2\u0255\u0256\7\22\2\2\u0256\u0257"+
		"\5$\23\2\u0257\u0258\7\23\2\2\u0258\u02e8\3\2\2\2\u0259\u025a\7r\2\2\u025a"+
		"\u025b\7\22\2\2\u025b\u025c\5$\23\2\u025c\u0260\7\23\2\2\u025d\u025f\7"+
		"\u0087\2\2\u025e\u025d\3\2\2\2\u025f\u0262\3\2\2\2\u0260\u025e\3\2\2\2"+
		"\u0260\u0261\3\2\2\2\u0261\u0263\3\2\2\2\u0262\u0260\3\2\2\2\u0263\u0264"+
		"\7\6\2\2\u0264\u0265\5 \21\2\u0265\u0271\7\7\2\2\u0266\u026a\7s\2\2\u0267"+
		"\u0269\7\u0087\2\2\u0268\u0267\3\2\2\2\u0269\u026c\3\2\2\2\u026a\u0268"+
		"\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026d\3\2\2\2\u026c\u026a\3\2\2\2\u026d"+
		"\u026e\7\6\2\2\u026e\u026f\5 \21\2\u026f\u0270\7\7\2\2\u0270\u0272\3\2"+
		"\2\2\u0271\u0266\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u02e8\3\2\2\2\u0273"+
		"\u0274\7t\2\2\u0274\u0275\7\22\2\2\u0275\u0276\5$\23\2\u0276\u027a\7\23"+
		"\2\2\u0277\u0279\7\u0087\2\2\u0278\u0277\3\2\2\2\u0279\u027c\3\2\2\2\u027a"+
		"\u0278\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027d\3\2\2\2\u027c\u027a\3\2"+
		"\2\2\u027d\u0288\7\6\2\2\u027e\u0280\7\u0087\2\2\u027f\u027e\3\2\2\2\u0280"+
		"\u0283\3\2\2\2\u0281\u027f\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0284\3\2"+
		"\2\2\u0283\u0281\3\2\2\2\u0284\u0285\7k\2\2\u0285\u0286\5&\24\2\u0286"+
		"\u0287\7l\2\2\u0287\u0289\3\2\2\2\u0288\u0281\3\2\2\2\u0288\u0289\3\2"+
		"\2\2\u0289\u028a\3\2\2\2\u028a\u028b\5 \21\2\u028b\u028c\7\7\2\2\u028c"+
		"\u02e8\3\2\2\2\u028d\u028e\t\37\2\2\u028e\u028f\7\22\2\2\u028f\u0290\7"+
		"\u0084\2\2\u0290\u02e8\7\23\2\2\u0291\u0292\7\u0083\2\2\u0292\u0293\7"+
		"\22\2\2\u0293\u0294\5$\23\2\u0294\u0295\7\23\2\2\u0295\u0297\7\36\2\2"+
		"\u0296\u0298\7\u0087\2\2\u0297\u0296\3\2\2\2\u0297\u0298\3\2\2\2\u0298"+
		"\u0299\3\2\2\2\u0299\u029a\5$\23\2\u029a\u02e8\3\2\2\2\u029b\u029c\7w"+
		"\2\2\u029c\u029e\7\u0083\2\2\u029d\u029b\3\2\2\2\u029d\u029e\3\2\2\2\u029e"+
		"\u029f\3\2\2\2\u029f\u02a0\7n\2\2\u02a0\u02a2\7\u0083\2\2\u02a1\u02a3"+
		"\7\u0087\2\2\u02a2\u02a1\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3\u02a4\3\2\2"+
		"\2\u02a4\u02ad\7\22\2\2\u02a5\u02aa\5\36\20\2\u02a6\u02a7\7\3\2\2\u02a7"+
		"\u02a9\5\36\20\2\u02a8\u02a6\3\2\2\2\u02a9\u02ac\3\2\2\2\u02aa\u02a8\3"+
		"\2\2\2\u02aa\u02ab\3\2\2\2\u02ab\u02ae\3\2\2\2\u02ac\u02aa\3\2\2\2\u02ad"+
		"\u02a5\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b0\7\23"+
		"\2\2\u02b0\u02b3\7\t\2\2\u02b1\u02b4\5\16\b\2\u02b2\u02b4\7x\2\2\u02b3"+
		"\u02b1\3\2\2\2\u02b3\u02b2\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02b9\7\36"+
		"\2\2\u02b6\u02b8\7\u0087\2\2\u02b7\u02b6\3\2\2\2\u02b8\u02bb\3\2\2\2\u02b9"+
		"\u02b7\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02bc\3\2\2\2\u02bb\u02b9\3\2"+
		"\2\2\u02bc\u02cd\7\6\2\2\u02bd\u02bf\7\u0087\2\2\u02be\u02bd\3\2\2\2\u02bf"+
		"\u02c2\3\2\2\2\u02c0\u02be\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c3\3\2"+
		"\2\2\u02c2\u02c0\3\2\2\2\u02c3\u02c4\7k\2\2\u02c4\u02c8\5*\26\2\u02c5"+
		"\u02c7\7\u0087\2\2\u02c6\u02c5\3\2\2\2\u02c7\u02ca\3\2\2\2\u02c8\u02c6"+
		"\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9\u02cb\3\2\2\2\u02ca\u02c8\3\2\2\2\u02cb"+
		"\u02cc\7l\2\2\u02cc\u02ce\3\2\2\2\u02cd\u02c0\3\2\2\2\u02cd\u02ce\3\2"+
		"\2\2\u02ce\u02cf\3\2\2\2\u02cf\u02da\5 \21\2\u02d0\u02d2\7y\2\2\u02d1"+
		"\u02d3\5$\23\2\u02d2\u02d1\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d7\3\2"+
		"\2\2\u02d4\u02d6\7\u0087\2\2\u02d5\u02d4\3\2\2\2\u02d6\u02d9\3\2\2\2\u02d7"+
		"\u02d5\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02db\3\2\2\2\u02d9\u02d7\3\2"+
		"\2\2\u02da\u02d0\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc"+
		"\u02dd\7\7\2\2\u02dd\u02e8\3\2\2\2\u02de\u02e2\7k\2\2\u02df\u02e3\5\6"+
		"\4\2\u02e0\u02e3\5\4\3\2\u02e1\u02e3\5,\27\2\u02e2\u02df\3\2\2\2\u02e2"+
		"\u02e0\3\2\2\2\u02e2\u02e1\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e5\7l"+
		"\2\2\u02e5\u02e8\3\2\2\2\u02e6\u02e8\5$\23\2\u02e7\u023f\3\2\2\2\u02e7"+
		"\u0249\3\2\2\2\u02e7\u024f\3\2\2\2\u02e7\u0254\3\2\2\2\u02e7\u0259\3\2"+
		"\2\2\u02e7\u0273\3\2\2\2\u02e7\u028d\3\2\2\2\u02e7\u0291\3\2\2\2\u02e7"+
		"\u029d\3\2\2\2\u02e7\u02de\3\2\2\2\u02e7\u02e6\3\2\2\2\u02e8#\3\2\2\2"+
		"\u02e9\u02ea\b\23\1\2\u02ea\u02eb\t \2\2\u02eb\u031e\5$\23\n\u02ec\u031e"+
		"\t\4\2\2\u02ed\u031e\7\u0082\2\2\u02ee\u02fd\7\u0083\2\2\u02ef\u02f8\7"+
		"\22\2\2\u02f0\u02f5\5$\23\2\u02f1\u02f2\7\3\2\2\u02f2\u02f4\5$\23\2\u02f3"+
		"\u02f1\3\2\2\2\u02f4\u02f7\3\2\2\2\u02f5\u02f3\3\2\2\2\u02f5\u02f6\3\2"+
		"\2\2\u02f6\u02f9\3\2\2\2\u02f7\u02f5\3\2\2\2\u02f8\u02f0\3\2\2\2\u02f8"+
		"\u02f9\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa\u02fe\7\23\2\2\u02fb\u02fc\7"+
		"\b\2\2\u02fc\u02fe\7\u0083\2\2\u02fd\u02ef\3\2\2\2\u02fd\u02fb\3\2\2\2"+
		"\u02fd\u02fe\3\2\2\2\u02fe\u031e\3\2\2\2\u02ff\u0300\7\25\2\2\u0300\u0301"+
		"\7\22\2\2\u0301\u0302\7\u0085\2\2\u0302\u031e\7\23\2\2\u0303\u0304\7\26"+
		"\2\2\u0304\u030d\7\22\2\2\u0305\u030a\5$\23\2\u0306\u0307\7\3\2\2\u0307"+
		"\u0309\5$\23\2\u0308\u0306\3\2\2\2\u0309\u030c\3\2\2\2\u030a\u0308\3\2"+
		"\2\2\u030a\u030b\3\2\2\2\u030b\u030e\3\2\2\2\u030c\u030a\3\2\2\2\u030d"+
		"\u0305\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u031e\7\23"+
		"\2\2\u0310\u0311\7z\2\2\u0311\u0312\7\22\2\2\u0312\u031e\7\23\2\2\u0313"+
		"\u0314\7{\2\2\u0314\u0316\7\22\2\2\u0315\u0317\7\u0085\2\2\u0316\u0315"+
		"\3\2\2\2\u0316\u0317\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u031e\7\23\2\2"+
		"\u0319\u031a\7\22\2\2\u031a\u031b\5$\23\2\u031b\u031c\7\23\2\2\u031c\u031e"+
		"\3\2\2\2\u031d\u02e9\3\2\2\2\u031d\u02ec\3\2\2\2\u031d\u02ed\3\2\2\2\u031d"+
		"\u02ee\3\2\2\2\u031d\u02ff\3\2\2\2\u031d\u0303\3\2\2\2\u031d\u0310\3\2"+
		"\2\2\u031d\u0313\3\2\2\2\u031d\u0319\3\2\2\2\u031e\u034b\3\2\2\2\u031f"+
		"\u0320\f\t\2\2\u0320\u0322\t\5\2\2\u0321\u0323\7\u0087\2\2\u0322\u0321"+
		"\3\2\2\2\u0322\u0323\3\2\2\2\u0323\u0324\3\2\2\2\u0324\u034a\5$\23\n\u0325"+
		"\u0326\f\b\2\2\u0326\u0328\t\6\2\2\u0327\u0329\7\u0087\2\2\u0328\u0327"+
		"\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032a\3\2\2\2\u032a\u034a\5$\23\t\u032b"+
		"\u032c\f\7\2\2\u032c\u032e\7\35\2\2\u032d\u032f\7\u0087\2\2\u032e\u032d"+
		"\3\2\2\2\u032e\u032f\3\2\2\2\u032f\u0330\3\2\2\2\u0330\u034a\5$\23\b\u0331"+
		"\u0332\f\6\2\2\u0332\u0334\t!\2\2\u0333\u0335\7\u0087\2\2\u0334\u0333"+
		"\3\2\2\2\u0334\u0335\3\2\2\2\u0335\u0336\3\2\2\2\u0336\u034a\5$\23\7\u0337"+
		"\u0338\f\5\2\2\u0338\u033a\t\"\2\2\u0339\u033b\7\u0087\2\2\u033a\u0339"+
		"\3\2\2\2\u033a\u033b\3\2\2\2\u033b\u033c\3\2\2\2\u033c\u034a\5$\23\6\u033d"+
		"\u033e\f\4\2\2\u033e\u0340\7-\2\2\u033f\u0341\7\u0087\2\2\u0340\u033f"+
		"\3\2\2\2\u0340\u0341\3\2\2\2\u0341\u0342\3\2\2\2\u0342\u034a\5$\23\5\u0343"+
		"\u0344\f\3\2\2\u0344\u0346\7\61\2\2\u0345\u0347\7\u0087\2\2\u0346\u0345"+
		"\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u0348\3\2\2\2\u0348\u034a\5$\23\4\u0349"+
		"\u031f\3\2\2\2\u0349\u0325\3\2\2\2\u0349\u032b\3\2\2\2\u0349\u0331\3\2"+
		"\2\2\u0349\u0337\3\2\2\2\u0349\u033d\3\2\2\2\u0349\u0343\3\2\2\2\u034a"+
		"\u034d\3\2\2\2\u034b\u0349\3\2\2\2\u034b\u034c\3\2\2\2\u034c%\3\2\2\2"+
		"\u034d\u034b\3\2\2\2\u034e\u0352\7\6\2\2\u034f\u0351\7\u0087\2\2\u0350"+
		"\u034f\3\2\2\2\u0351\u0354\3\2\2\2\u0352\u0350\3\2\2\2\u0352\u0353\3\2"+
		"\2\2\u0353\u0355\3\2\2\2\u0354\u0352\3\2\2\2\u0355\u0359\7f\2\2\u0356"+
		"\u0358\7\u0087\2\2\u0357\u0356\3\2\2\2\u0358\u035b\3\2\2\2\u0359\u0357"+
		"\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u035d\3\2\2\2\u035b\u0359\3\2\2\2\u035c"+
		"\u035e\5\n\6\2\u035d\u035c\3\2\2\2\u035d\u035e\3\2\2\2\u035e\u0369\3\2"+
		"\2\2\u035f\u0361\7\u0087\2\2\u0360\u035f\3\2\2\2\u0361\u0362\3\2\2\2\u0362"+
		"\u0360\3\2\2\2\u0362\u0363\3\2\2\2\u0363\u0365\3\2\2\2\u0364\u0366\5\n"+
		"\6\2\u0365\u0364\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u0368\3\2\2\2\u0367"+
		"\u0360\3\2\2\2\u0368\u036b\3\2\2\2\u0369\u0367\3\2\2\2\u0369\u036a\3\2"+
		"\2\2\u036a\u036c\3\2\2\2\u036b\u0369\3\2\2\2\u036c\u036d\5(\25\2\u036d"+
		"\u0371\7\7\2\2\u036e\u0370\7\u0087\2\2\u036f\u036e\3\2\2\2\u0370\u0373"+
		"\3\2\2\2\u0371\u036f\3\2\2\2\u0371\u0372\3\2\2\2\u0372\'\3\2\2\2\u0373"+
		"\u0371\3\2\2\2\u0374\u037d\7|\2\2\u0375\u037a\7\u0083\2\2\u0376\u0377"+
		"\7\3\2\2\u0377\u0379\7\u0083\2\2\u0378\u0376\3\2\2\2\u0379\u037c\3\2\2"+
		"\2\u037a\u0378\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u037e\3\2\2\2\u037c\u037a"+
		"\3\2\2\2\u037d\u0375\3\2\2\2\u037d\u037e\3\2\2\2\u037e\u0382\3\2\2\2\u037f"+
		"\u0381\7\u0087\2\2\u0380\u037f\3\2\2\2\u0381\u0384\3\2\2\2\u0382\u0380"+
		"\3\2\2\2\u0382\u0383\3\2\2\2\u0383)\3\2\2\2\u0384\u0382\3\2\2\2\u0385"+
		"\u0389\7\6\2\2\u0386\u0388\7\u0087\2\2\u0387\u0386\3\2\2\2\u0388\u038b"+
		"\3\2\2\2\u0389\u0387\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u03a1\3\2\2\2\u038b"+
		"\u0389\3\2\2\2\u038c\u0390\t#\2\2\u038d\u038f\7\u0087\2\2\u038e\u038d"+
		"\3\2\2\2\u038f\u0392\3\2\2\2\u0390\u038e\3\2\2\2\u0390\u0391\3\2\2\2\u0391"+
		"\u0393\3\2\2\2\u0392\u0390\3\2\2\2\u0393\u039e\5\n\6\2\u0394\u0396\7\u0087"+
		"\2\2\u0395\u0394\3\2\2\2\u0396\u0397\3\2\2\2\u0397\u0395\3\2\2\2\u0397"+
		"\u0398\3\2\2\2\u0398\u039a\3\2\2\2\u0399\u039b\5\n\6\2\u039a\u0399\3\2"+
		"\2\2\u039a\u039b\3\2\2\2\u039b\u039d\3\2\2\2\u039c\u0395\3\2\2\2\u039d"+
		"\u03a0\3\2\2\2\u039e\u039c\3\2\2\2\u039e\u039f\3\2\2\2\u039f\u03a2\3\2"+
		"\2\2\u03a0\u039e\3\2\2\2\u03a1\u038c\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2"+
		"\u03a6\3\2\2\2\u03a3\u03a5\7\u0087\2\2\u03a4\u03a3\3\2\2\2\u03a5\u03a8"+
		"\3\2\2\2\u03a6\u03a4\3\2\2\2\u03a6\u03a7\3\2\2\2\u03a7\u03aa\3\2\2\2\u03a8"+
		"\u03a6\3\2\2\2\u03a9\u03ab\5(\25\2\u03aa\u03a9\3\2\2\2\u03aa\u03ab\3\2"+
		"\2\2\u03ab\u03c1\3\2\2\2\u03ac\u03b0\t$\2\2\u03ad\u03af\7\u0087\2\2\u03ae"+
		"\u03ad\3\2\2\2\u03af\u03b2\3\2\2\2\u03b0\u03ae\3\2\2\2\u03b0\u03b1\3\2"+
		"\2\2\u03b1\u03b3\3\2\2\2\u03b2\u03b0\3\2\2\2\u03b3\u03be\5\n\6\2\u03b4"+
		"\u03b6\7\u0087\2\2\u03b5\u03b4\3\2\2\2\u03b6\u03b7\3\2\2\2\u03b7\u03b5"+
		"\3\2\2\2\u03b7\u03b8\3\2\2\2\u03b8\u03ba\3\2\2\2\u03b9\u03bb\5\n\6\2\u03ba"+
		"\u03b9\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03bd\3\2\2\2\u03bc\u03b5\3\2"+
		"\2\2\u03bd\u03c0\3\2\2\2\u03be\u03bc\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf"+
		"\u03c2\3\2\2\2\u03c0\u03be\3\2\2\2\u03c1\u03ac\3\2\2\2\u03c1\u03c2\3\2"+
		"\2\2\u03c2\u03c6\3\2\2\2\u03c3\u03c5\7\u0087\2\2\u03c4\u03c3\3\2\2\2\u03c5"+
		"\u03c8\3\2\2\2\u03c6\u03c4\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7\u03c9\3\2"+
		"\2\2\u03c8\u03c6\3\2\2\2\u03c9\u03cd\7\7\2\2\u03ca\u03cc\7\u0087\2\2\u03cb"+
		"\u03ca\3\2\2\2\u03cc\u03cf\3\2\2\2\u03cd\u03cb\3\2\2\2\u03cd\u03ce\3\2"+
		"\2\2\u03ce+\3\2\2\2\u03cf\u03cd\3\2\2\2\u03d0\u03d4\7\6\2\2\u03d1\u03d3"+
		"\7\u0087\2\2\u03d2\u03d1\3\2\2\2\u03d3\u03d6\3\2\2\2\u03d4\u03d2\3\2\2"+
		"\2\u03d4\u03d5\3\2\2\2\u03d5\u03d7\3\2\2\2\u03d6\u03d4\3\2\2\2\u03d7\u03db"+
		"\7f\2\2\u03d8\u03da\7\u0087\2\2\u03d9\u03d8\3\2\2\2\u03da\u03dd\3\2\2"+
		"\2\u03db\u03d9\3\2\2\2\u03db\u03dc\3\2\2\2\u03dc\u03df\3\2\2\2\u03dd\u03db"+
		"\3\2\2\2\u03de\u03e0\5\n\6\2\u03df\u03de\3\2\2\2\u03df\u03e0\3\2\2\2\u03e0"+
		"\u03eb\3\2\2\2\u03e1\u03e3\7\u0087\2\2\u03e2\u03e1\3\2\2\2\u03e3\u03e4"+
		"\3\2\2\2\u03e4\u03e2\3\2\2\2\u03e4\u03e5\3\2\2\2\u03e5\u03e7\3\2\2\2\u03e6"+
		"\u03e8\5\n\6\2\u03e7\u03e6\3\2\2\2\u03e7\u03e8\3\2\2\2\u03e8\u03ea\3\2"+
		"\2\2\u03e9\u03e2\3\2\2\2\u03ea\u03ed\3\2\2\2\u03eb\u03e9\3\2\2\2\u03eb"+
		"\u03ec\3\2\2\2\u03ec\u03ee\3\2\2\2\u03ed\u03eb\3\2\2\2\u03ee\u03f2\7\7"+
		"\2\2\u03ef\u03f1\7\u0087\2\2\u03f0\u03ef\3\2\2\2\u03f1\u03f4\3\2\2\2\u03f2"+
		"\u03f0\3\2\2\2\u03f2\u03f3\3\2\2\2\u03f3-\3\2\2\2\u03f4\u03f2\3\2\2\2"+
		"\u0095\62\66;CJMU[bdhmpt{\u0088\u008f\u0097\u009f\u00a4\u00a9\u00ac\u00b0"+
		"\u00b4\u00bf\u00cd\u00de\u00e1\u00e5\u00ea\u00f0\u00f6\u00fc\u0102\u0108"+
		"\u010e\u0114\u0117\u0119\u0122\u012b\u012f\u0134\u0137\u013e\u0144\u014b"+
		"\u0151\u0157\u017b\u018c\u0196\u01a3\u01aa\u01b7\u01c4\u01c7\u01ce\u01dc"+
		"\u01e4\u01e7\u01ea\u01f0\u01f7\u01fb\u0200\u0203\u0207\u020e\u0213\u021c"+
		"\u0224\u0230\u0235\u0238\u023c\u0245\u024c\u0260\u026a\u0271\u027a\u0281"+
		"\u0288\u0297\u029d\u02a2\u02aa\u02ad\u02b3\u02b9\u02c0\u02c8\u02cd\u02d2"+
		"\u02d7\u02da\u02e2\u02e7\u02f5\u02f8\u02fd\u030a\u030d\u0316\u031d\u0322"+
		"\u0328\u032e\u0334\u033a\u0340\u0346\u0349\u034b\u0352\u0359\u035d\u0362"+
		"\u0365\u0369\u0371\u037a\u037d\u0382\u0389\u0390\u0397\u039a\u039e\u03a1"+
		"\u03a6\u03aa\u03b0\u03b7\u03ba\u03be\u03c1\u03c6\u03cd\u03d4\u03db\u03df"+
		"\u03e4\u03e7\u03eb\u03f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}