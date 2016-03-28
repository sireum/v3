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
		T__125=126, T__126=127, T__127=128, T__128=129, T__129=130, T__130=131, 
		T__131=132, T__132=133, T__133=134, T__134=135, T__135=136, T__136=137, 
		T__137=138, T__138=139, T__139=140, T__140=141, T__141=142, T__142=143, 
		T__143=144, T__144=145, T__145=146, T__146=147, T__147=148, T__148=149, 
		T__149=150, T__150=151, T__151=152, T__152=153, T__153=154, T__154=155, 
		T__155=156, T__156=157, T__157=158, T__158=159, T__159=160, T__160=161, 
		T__161=162, T__162=163, T__163=164, T__164=165, T__165=166, T__166=167, 
		T__167=168, T__168=169, HLINE=170, NUM=171, ID=172, REAL=173, INT=174, 
		RESERVED=175, NL=176, LINE_COMMENT=177, COMMENT=178, WS=179, STRING=180, 
		FLOAT=181, ERROR_CHAR=182;
	public static final int
		RULE_file = 0, RULE_sequent = 1, RULE_proof = 2, RULE_proofStep = 3, RULE_primFormula = 4, 
		RULE_formula = 5, RULE_qformula = 6, RULE_type = 7, RULE_justification = 8, 
		RULE_program = 9, RULE_impor = 10, RULE_facts = 11, RULE_factOrFun = 12, 
		RULE_fact = 13, RULE_fun = 14, RULE_param = 15, RULE_stmts = 16, RULE_stmt = 17, 
		RULE_stringOrExp = 18, RULE_primExp = 19, RULE_exp = 20, RULE_loopInvariant = 21, 
		RULE_modifies = 22, RULE_methodContract = 23, RULE_invariants = 24;
	public static final String[] ruleNames = {
		"file", "sequent", "proof", "proofStep", "primFormula", "formula", "qformula", 
		"type", "justification", "program", "impor", "facts", "factOrFun", "fact", 
		"fun", "param", "stmts", "stmt", "stringOrExp", "primExp", "exp", "loopInvariant", 
		"modifies", "methodContract", "invariants"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'|-'", "'⊢'", "'{'", "'}'", "'.'", "':'", "'assume'", "'true'", 
		"'T'", "'⊤'", "'false'", "'F'", "'_|_'", "'⊥'", "'('", "')'", "'result'", 
		"'B'", "'Z'", "'Z8'", "'Z16'", "'Z32'", "'Z64'", "'N'", "'N8'", "'N16'", 
		"'N32'", "'N64'", "'S8'", "'S16'", "'S32'", "'S64'", "'U8'", "'U16'", 
		"'U32'", "'U64'", "'R'", "'F32'", "'F64'", "'BS'", "'ZS'", "'Z8S'", "'Z16S'", 
		"'Z32S'", "'Z64S'", "'NS'", "'N8S'", "'N16S'", "'N32S'", "'N64S'", "'S8S'", 
		"'S16S'", "'S32S'", "'S64S'", "'U8S'", "'U16S'", "'U32S'", "'U64S'", "'RS'", 
		"'F32S'", "'F64S'", "'*'", "'/'", "'%'", "'+'", "'-'", "'+:'", "':+'", 
		"'<'", "'<='", "'≤'", "'>'", "'>='", "'≥'", "'>>'", "'>>>'", "'<<'", "'='", 
		"'=='", "'!='", "'≠'", "'not'", "'neg'", "'!'", "'~'", "'¬'", "'and'", 
		"'&'", "'^'", "'∧'", "'xor'", "'^|'", "'or'", "'|'", "'V'", "'∨'", "'implies'", 
		"'->'", "'→'", "'forall'", "'all'", "'A'", "'∀'", "'exists'", "'some'", 
		"'E'", "'∃'", "'..'", "'premise'", "'andi'", "'ande1'", "'ande2'", "'ori1'", 
		"'Vi1'", "'ori2'", "'Vi2'", "'ore'", "'Ve'", "'impliesi'", "'impliese'", 
		"'noti'", "'negi'", "'note'", "'nege'", "'bottome'", "'falsee'", "'pbc'", 
		"'subst1'", "'subst2'", "'algebra'", "'foralli'", "'alli'", "'Ai'", "'foralle'", 
		"'alle'", "'Ae'", "'existsi'", "'somei'", "'Ei'", "'existse'", "'somee'", 
		"'Ee'", "'invariant'", "'fact'", "'auto'", "'import'", "'_'", "'def'", 
		"'var'", "'val'", "'assert'", "'if'", "'else'", "'while'", "'l\"\"\"'", 
		"'\"\"\"'", "'print'", "'println'", "'@'", "'Unit'", "'return'", "'randomInt'", 
		"'readInt'", "'modifies'", "'requires'", "'pre'", "'ensures'", "'post'"
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
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "HLINE", "NUM", "ID", "REAL", "INT", "RESERVED", "NL", "LINE_COMMENT", 
		"COMMENT", "WS", "STRING", "FLOAT", "ERROR_CHAR"
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
			setState(71);
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
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
			case T__61:
			case T__66:
			case T__82:
			case T__83:
			case T__84:
			case T__85:
			case T__86:
			case T__100:
			case T__101:
			case T__102:
			case T__103:
			case T__104:
			case T__105:
			case T__106:
			case T__107:
			case HLINE:
			case NUM:
			case ID:
			case REAL:
			case INT:
			case FLOAT:
				_localctx = new SequentFileContext(_localctx);
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
				break;
			case EOF:
			case T__146:
			case NL:
				_localctx = new ProgramFileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				program();
				setState(69);
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
			setState(104);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
					{
					setState(73);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(74);
						match(T__0);
						setState(75);
						((SequentContext)_localctx).formula = formula(0);
						((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
						}
						}
						setState(80);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(83);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(84);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(85);
					match(T__0);
					setState(86);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
					{
					{
					setState(92);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(98);
				match(HLINE);
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(99);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(102); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0) );
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
			setState(106);
			((ProofContext)_localctx).tb = match(T__3);
			setState(108);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(107);
				proofStep();
				}
			}

			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(111); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(110);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(113); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(116);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(115);
					proofStep();
					}
				}

				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
			((ProofContext)_localctx).te = match(T__4);
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(124);
					match(NL);
					}
					} 
				}
				setState(129);
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
			setState(184);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(NUM);
				setState(131);
				match(T__5);
				setState(132);
				formula(0);
				setState(133);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(136);
				match(T__5);
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
				match(T__3);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(144);
					match(NL);
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(150);
				((SubProofContext)_localctx).assume = match(NUM);
				setState(151);
				match(T__5);
				setState(168);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(152);
					match(ID);
					setState(155);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(153);
						match(T__6);
						setState(154);
						type();
						}
					}

					}
					break;
				case 2:
					{
					setState(157);
					formula(0);
					setState(158);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				case 3:
					{
					setState(160);
					match(ID);
					setState(163);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(161);
						match(T__6);
						setState(162);
						type();
						}
					}

					setState(165);
					formula(0);
					setState(166);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(171); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(170);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(173); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(176);
					_la = _input.LA(1);
					if (_la==NUM) {
						{
						setState(175);
						proofStep();
						}
					}

					}
					}
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(183);
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

	public static class PrimFormulaContext extends ParserRuleContext {
		public PrimFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primFormula; }
	 
		public PrimFormulaContext() { }
		public void copyFrom(PrimFormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FloatLitContext extends PrimFormulaContext {
		public TerminalNode FLOAT() { return getToken(Antlr4LogikaParser.FLOAT, 0); }
		public FloatLitContext(PrimFormulaContext ctx) { copyFrom(ctx); }
	}
	public static class RLitContext extends PrimFormulaContext {
		public TerminalNode REAL() { return getToken(Antlr4LogikaParser.REAL, 0); }
		public RLitContext(PrimFormulaContext ctx) { copyFrom(ctx); }
	}
	public static class ApplyContext extends PrimFormulaContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ApplyContext(PrimFormulaContext ctx) { copyFrom(ctx); }
	}
	public static class VarContext extends PrimFormulaContext {
		public Token tb;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public VarContext(PrimFormulaContext ctx) { copyFrom(ctx); }
	}
	public static class TypeAccessContext extends PrimFormulaContext {
		public Token t;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public TypeAccessContext(PrimFormulaContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanContext extends PrimFormulaContext {
		public Token t;
		public BooleanContext(PrimFormulaContext ctx) { copyFrom(ctx); }
	}
	public static class IntLitContext extends PrimFormulaContext {
		public TerminalNode INT() { return getToken(Antlr4LogikaParser.INT, 0); }
		public IntLitContext(PrimFormulaContext ctx) { copyFrom(ctx); }
	}
	public static class IntContext extends PrimFormulaContext {
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public IntContext(PrimFormulaContext ctx) { copyFrom(ctx); }
	}
	public static class SeqContext extends PrimFormulaContext {
		public Token t;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SeqContext(PrimFormulaContext ctx) { copyFrom(ctx); }
	}
	public static class ParenContext extends PrimFormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ParenContext(PrimFormulaContext ctx) { copyFrom(ctx); }
	}
	public static class ResultContext extends PrimFormulaContext {
		public ResultContext(PrimFormulaContext ctx) { copyFrom(ctx); }
	}

	public final PrimFormulaContext primFormula() throws RecognitionException {
		PrimFormulaContext _localctx = new PrimFormulaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_primFormula);
		int _la;
		try {
			setState(225);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				((BooleanContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
					((BooleanContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 2:
				_localctx = new ParenContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(T__15);
				setState(188);
				formula(0);
				setState(189);
				match(T__16);
				}
				break;
			case 3:
				_localctx = new ResultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				match(T__17);
				}
				break;
			case 4:
				_localctx = new ApplyContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(192);
				match(ID);
				setState(193);
				match(T__15);
				setState(194);
				formula(0);
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(195);
					match(T__0);
					setState(196);
					formula(0);
					}
					}
					setState(201);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(202);
				match(T__16);
				}
				break;
			case 5:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				((VarContext)_localctx).tb = match(ID);
				}
				break;
			case 6:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(205);
				match(NUM);
				}
				break;
			case 7:
				_localctx = new IntLitContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(206);
				match(INT);
				}
				break;
			case 8:
				_localctx = new RLitContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(207);
				match(REAL);
				}
				break;
			case 9:
				_localctx = new FloatLitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(208);
				match(FLOAT);
				}
				break;
			case 10:
				_localctx = new TypeAccessContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(209);
				((TypeAccessContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
					((TypeAccessContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(210);
				match(T__5);
				setState(211);
				match(ID);
				}
				break;
			case 11:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(212);
				((SeqContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0)) ) {
					((SeqContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(213);
				match(T__15);
				setState(222);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (FLOAT - 163)))) != 0)) {
					{
					setState(214);
					exp(0);
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(215);
						match(T__0);
						setState(216);
						exp(0);
						}
						}
						setState(221);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(224);
				match(T__16);
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
	public static class PFormulaContext extends FormulaContext {
		public PrimFormulaContext primFormula() {
			return getRuleContext(PrimFormulaContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public PFormulaContext(FormulaContext ctx) { copyFrom(ctx); }
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			switch (_input.LA(1)) {
			case T__66:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(228);
				((UnaryContext)_localctx).op = match(T__66);
				setState(229);
				formula(7);
				}
				break;
			case T__82:
			case T__83:
			case T__84:
			case T__85:
			case T__86:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)) | (1L << (T__85 - 83)) | (1L << (T__86 - 83)))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(231);
				formula(6);
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
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
			case T__61:
			case NUM:
			case ID:
			case REAL:
			case INT:
			case FLOAT:
				{
				_localctx = new PFormulaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				primFormula();
				setState(237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(233);
						match(T__5);
						setState(234);
						match(ID);
						}
						} 
					}
					setState(239);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				}
				}
				break;
			case T__100:
			case T__101:
			case T__102:
			case T__103:
			case T__104:
			case T__105:
			case T__106:
			case T__107:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240);
				qformula();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(305);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(303);
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(243);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(244);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (T__62 - 63)) | (1L << (T__63 - 63)) | (1L << (T__64 - 63)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(246);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(245);
							match(NL);
							}
						}

						setState(248);
						((BinaryContext)_localctx).r = formula(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(249);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(250);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__65 || _la==T__66) ) {
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
						((BinaryContext)_localctx).r = formula(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(255);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(256);
						((BinaryContext)_localctx).op = match(T__67);
						setState(258);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(257);
							match(NL);
							}
						}

						setState(260);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(261);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(262);
						((BinaryContext)_localctx).op = match(T__68);
						setState(264);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(263);
							match(NL);
							}
						}

						setState(266);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(267);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(268);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)) | (1L << (T__72 - 70)) | (1L << (T__73 - 70)) | (1L << (T__74 - 70)) | (1L << (T__75 - 70)) | (1L << (T__76 - 70)) | (1L << (T__77 - 70)))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(273);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(274);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (T__78 - 79)) | (1L << (T__79 - 79)) | (1L << (T__80 - 79)) | (1L << (T__81 - 79)))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(279);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(280);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (T__87 - 88)) | (1L << (T__88 - 88)) | (1L << (T__89 - 88)) | (1L << (T__90 - 88)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(282);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(281);
							match(NL);
							}
						}

						setState(284);
						((BinaryContext)_localctx).r = formula(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(285);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(286);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__91 || _la==T__92) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(288);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(287);
							match(NL);
							}
						}

						setState(290);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(291);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(292);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (T__93 - 94)) | (1L << (T__94 - 94)) | (1L << (T__95 - 94)) | (1L << (T__96 - 94)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(294);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(293);
							match(NL);
							}
						}

						setState(296);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 10:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(297);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(298);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (T__97 - 98)) | (1L << (T__98 - 98)) | (1L << (T__99 - 98)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(300);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(299);
							match(NL);
							}
						}

						setState(302);
						((BinaryContext)_localctx).r = formula(2);
						}
						break;
					}
					} 
				}
				setState(307);
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
		enterRule(_localctx, 12, RULE_qformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & ((1L << (T__100 - 101)) | (1L << (T__101 - 101)) | (1L << (T__102 - 101)) | (1L << (T__103 - 101)) | (1L << (T__104 - 101)) | (1L << (T__105 - 101)) | (1L << (T__106 - 101)) | (1L << (T__107 - 101)))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(309);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(310);
				match(T__0);
				setState(311);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(332);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(317);
				match(T__6);
				setState(318);
				type();
				}
				break;
			case 2:
				{
				setState(319);
				match(T__6);
				setState(320);
				match(T__15);
				setState(321);
				((QformulaContext)_localctx).lo = exp(0);
				setState(323);
				_la = _input.LA(1);
				if (_la==T__69) {
					{
					setState(322);
					((QformulaContext)_localctx).ll = match(T__69);
					}
				}

				setState(325);
				match(T__108);
				setState(327);
				_la = _input.LA(1);
				if (_la==T__69) {
					{
					setState(326);
					((QformulaContext)_localctx).lh = match(T__69);
					}
				}

				setState(329);
				((QformulaContext)_localctx).hi = exp(0);
				setState(330);
				match(T__16);
				}
				break;
			}
			setState(335);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(334);
				match(NL);
				}
			}

			setState(337);
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
		public Token t;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			((TypeContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0)) ) {
				((TypeContext)_localctx).t = (Token)_errHandler.recoverInline(this);
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
		public Token subProof;
		public Token t;
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
		enterRule(_localctx, 16, RULE_justification);
		int _la;
		try {
			setState(474);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				((PremiseContext)_localctx).t = match(T__109);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(345);
				switch (_input.LA(1)) {
				case T__110:
					{
					setState(342);
					((AndIntroContext)_localctx).tb = match(T__110);
					}
					break;
				case T__88:
				case T__89:
				case T__90:
					{
					setState(343);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (T__88 - 89)) | (1L << (T__89 - 89)) | (1L << (T__90 - 89)))) != 0)) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(348);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(352);
				switch (_input.LA(1)) {
				case T__111:
				case T__112:
					{
					setState(349);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__111 || _la==T__112) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__88:
				case T__89:
				case T__90:
					{
					setState(350);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (T__88 - 89)) | (1L << (T__89 - 89)) | (1L << (T__90 - 89)))) != 0)) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(351);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(354);
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(358);
				switch (_input.LA(1)) {
				case T__113:
				case T__114:
				case T__115:
				case T__116:
					{
					setState(355);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 114)) & ~0x3f) == 0 && ((1L << (_la - 114)) & ((1L << (T__113 - 114)) | (1L << (T__114 - 114)) | (1L << (T__115 - 114)) | (1L << (T__116 - 114)))) != 0)) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__94:
				case T__96:
					{
					setState(356);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__94 || _la==T__96) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(357);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(360);
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(364);
				switch (_input.LA(1)) {
				case T__117:
				case T__118:
					{
					setState(361);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__117 || _la==T__118) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__94:
				case T__96:
					{
					setState(362);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__94 || _la==T__96) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(363);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(366);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(367);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(368);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(369);
				((ImpliesIntroContext)_localctx).tb = match(T__119);
				setState(370);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(371);
				((ImpliesElimContext)_localctx).tb = match(T__120);
				setState(372);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(373);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(374);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(375);
				((ImpliesIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__98 || _la==T__99) ) {
					((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(376);
				match(ID);
				setState(377);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(378);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				      "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n      \"e\".equals(_input.LT(2).getText())");
				setState(379);
				((ImpliesElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__98 || _la==T__99) ) {
					((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(380);
				match(ID);
				setState(381);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(382);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(383);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__121 || _la==T__122) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(384);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 11:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(385);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__123 || _la==T__124) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(386);
				((NegElimContext)_localctx).step = match(NUM);
				setState(387);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 12:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(388);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(389);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)))) != 0)) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(390);
				match(ID);
				setState(391);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(392);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(393);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)))) != 0)) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(394);
				match(ID);
				setState(395);
				((NegElimContext)_localctx).step = match(NUM);
				setState(396);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 14:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(400);
				switch (_input.LA(1)) {
				case T__125:
				case T__126:
					{
					setState(397);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__125 || _la==T__126) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__13:
				case T__14:
					{
					setState(398);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==T__14) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(399);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(402);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 15:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(403);
				((PbcContext)_localctx).tb = match(T__127);
				setState(404);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 16:
				_localctx = new Subst1Context(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(405);
				((Subst1Context)_localctx).tb = match(T__128);
				setState(406);
				((Subst1Context)_localctx).eqStep = match(NUM);
				setState(407);
				((Subst1Context)_localctx).step = match(NUM);
				}
				break;
			case 17:
				_localctx = new Subst2Context(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(408);
				((Subst2Context)_localctx).tb = match(T__129);
				setState(409);
				((Subst2Context)_localctx).eqStep = match(NUM);
				setState(410);
				((Subst2Context)_localctx).step = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(411);
				((AlgebraContext)_localctx).tb = match(T__130);
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(412);
					((AlgebraContext)_localctx).NUM = match(NUM);
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).NUM);
					}
					}
					setState(417);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(418);
				((ForallIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 132)) & ~0x3f) == 0 && ((1L << (_la - 132)) & ((1L << (T__131 - 132)) | (1L << (T__132 - 132)) | (1L << (T__133 - 132)))) != 0)) ) {
					((ForallIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(419);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 20:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(420);
				((ForallElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (T__134 - 135)) | (1L << (T__135 - 135)) | (1L << (T__136 - 135)))) != 0)) ) {
					((ForallElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(421);
				((ForallElimContext)_localctx).step = match(NUM);
				setState(423); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(422);
					formula(0);
					}
					}
					setState(425); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0) );
				}
				break;
			case 21:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(427);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(428);
				((ForallIntroContext)_localctx).tb = match(T__103);
				setState(429);
				match(ID);
				setState(430);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 22:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(431);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(432);
				((ForallElimContext)_localctx).tb = match(T__103);
				setState(433);
				match(ID);
				setState(434);
				((ForallElimContext)_localctx).step = match(NUM);
				setState(436); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(435);
					formula(0);
					}
					}
					setState(438); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0) );
				}
				break;
			case 23:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(440);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (T__137 - 138)) | (1L << (T__138 - 138)) | (1L << (T__139 - 138)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(441);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(443); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(442);
					formula(0);
					}
					}
					setState(445); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0) );
				}
				break;
			case 24:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(447);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & ((1L << (T__140 - 141)) | (1L << (T__141 - 141)) | (1L << (T__142 - 141)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(448);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(449);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 25:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(450);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(451);
				((ExistsIntroContext)_localctx).tb = match(T__107);
				setState(452);
				match(ID);
				setState(453);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(455); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(454);
					formula(0);
					}
					}
					setState(457); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0) );
				}
				break;
			case 26:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(459);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(460);
				((ExistsElimContext)_localctx).tb = match(T__107);
				setState(461);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(462);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(463);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 27:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(464);
				((InvariantContext)_localctx).tb = match(T__143);
				}
				break;
			case 28:
				_localctx = new FctContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(465);
				((FctContext)_localctx).tb = match(T__144);
				setState(466);
				match(ID);
				}
				break;
			case 29:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(467);
				((AutoContext)_localctx).tb = match(T__145);
				setState(471);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(468);
					((AutoContext)_localctx).NUM = match(NUM);
					((AutoContext)_localctx).steps.add(((AutoContext)_localctx).NUM);
					}
					}
					setState(473);
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
		enterRule(_localctx, 18, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(476);
				match(NL);
				}
				}
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(490);
			_la = _input.LA(1);
			if (_la==T__146) {
				{
				setState(482);
				impor();
				setState(484); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(483);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(486); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(488);
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
			setState(492);
			((ImporContext)_localctx).tb = match(T__146);
			setState(493);
			((ImporContext)_localctx).org = match(ID);
			setState(494);
			match(T__5);
			setState(495);
			((ImporContext)_localctx).sireum = match(ID);
			setState(496);
			match(T__5);
			setState(497);
			((ImporContext)_localctx).logika = match(ID);
			setState(498);
			match(T__5);
			setState(499);
			((ImporContext)_localctx).te = match(T__147);
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
		enterRule(_localctx, 22, RULE_facts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(T__3);
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(502);
				match(NL);
				}
				}
				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(508);
			((FactsContext)_localctx).ftb = match(T__144);
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
			setState(515);
			factOrFun();
			setState(526);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(517); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(516);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(519); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(522);
				_la = _input.LA(1);
				if (_la==T__148 || _la==ID) {
					{
					setState(521);
					factOrFun();
					}
				}

				}
				}
				setState(528);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(529);
			((FactsContext)_localctx).te = match(T__4);
			setState(533);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(530);
				match(NL);
				}
				}
				setState(535);
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
			setState(538);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(536);
				fact();
				}
				break;
			case T__148:
				enterOuterAlt(_localctx, 2);
				{
				setState(537);
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
			setState(540);
			match(ID);
			setState(541);
			match(T__5);
			setState(542);
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
			setState(544);
			((FunContext)_localctx).tb = match(T__148);
			setState(545);
			match(ID);
			setState(547);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(546);
				match(NL);
				}
			}

			setState(549);
			match(T__15);
			setState(550);
			param();
			setState(555);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(551);
				match(T__0);
				setState(552);
				param();
				}
				}
				setState(557);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(558);
			match(T__16);
			setState(559);
			match(T__6);
			setState(560);
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
			setState(562);
			match(ID);
			setState(563);
			match(T__6);
			setState(564);
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
			setState(567);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 147)) & ~0x3f) == 0 && ((1L << (_la - 147)) & ((1L << (T__146 - 147)) | (1L << (T__148 - 147)) | (1L << (T__149 - 147)) | (1L << (T__150 - 147)) | (1L << (T__151 - 147)) | (1L << (T__152 - 147)) | (1L << (T__154 - 147)) | (1L << (T__155 - 147)) | (1L << (T__157 - 147)) | (1L << (T__158 - 147)) | (1L << (T__159 - 147)) | (1L << (T__162 - 147)) | (1L << (T__163 - 147)) | (1L << (NUM - 147)) | (1L << (ID - 147)) | (1L << (REAL - 147)) | (1L << (INT - 147)) | (1L << (FLOAT - 147)))) != 0)) {
				{
				setState(566);
				stmt();
				}
			}

			setState(579);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(570); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(569);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(572); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(575);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 147)) & ~0x3f) == 0 && ((1L << (_la - 147)) & ((1L << (T__146 - 147)) | (1L << (T__148 - 147)) | (1L << (T__149 - 147)) | (1L << (T__150 - 147)) | (1L << (T__151 - 147)) | (1L << (T__152 - 147)) | (1L << (T__154 - 147)) | (1L << (T__155 - 147)) | (1L << (T__157 - 147)) | (1L << (T__158 - 147)) | (1L << (T__159 - 147)) | (1L << (T__162 - 147)) | (1L << (T__163 - 147)) | (1L << (NUM - 147)) | (1L << (ID - 147)) | (1L << (REAL - 147)) | (1L << (INT - 147)) | (1L << (FLOAT - 147)))) != 0)) {
					{
					setState(574);
					stmt();
					}
				}

				}
				}
				setState(581);
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
			setState(761);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(582);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__149 || _la==T__150) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(583);
				match(ID);
				setState(584);
				match(T__6);
				setState(585);
				type();
				setState(586);
				match(T__78);
				setState(588);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(587);
					match(NL);
					}
				}

				setState(590);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(592);
				match(ID);
				setState(593);
				match(T__78);
				setState(595);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(594);
					match(NL);
					}
				}

				setState(597);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssumeStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(598);
				match(T__7);
				setState(599);
				match(T__15);
				setState(600);
				exp(0);
				setState(601);
				match(T__16);
				}
				break;
			case 4:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(603);
				match(T__151);
				setState(604);
				match(T__15);
				setState(605);
				exp(0);
				setState(606);
				match(T__16);
				}
				break;
			case 5:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(608);
				match(T__152);
				setState(609);
				match(T__15);
				setState(610);
				exp(0);
				setState(611);
				match(T__16);
				setState(615);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(612);
					match(NL);
					}
					}
					setState(617);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(618);
				match(T__3);
				setState(619);
				((IfStmtContext)_localctx).ts = stmts();
				setState(620);
				match(T__4);
				setState(632);
				_la = _input.LA(1);
				if (_la==T__153) {
					{
					setState(621);
					match(T__153);
					setState(625);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(622);
						match(NL);
						}
						}
						setState(627);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(628);
					match(T__3);
					setState(629);
					((IfStmtContext)_localctx).fs = stmts();
					setState(630);
					match(T__4);
					}
				}

				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(634);
				match(T__154);
				setState(635);
				match(T__15);
				setState(636);
				exp(0);
				setState(637);
				match(T__16);
				setState(641);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(638);
					match(NL);
					}
					}
					setState(643);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(644);
				match(T__3);
				setState(655);
				switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
				case 1:
					{
					setState(648);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(645);
						match(NL);
						}
						}
						setState(650);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(651);
					match(T__155);
					setState(652);
					loopInvariant();
					setState(653);
					match(T__156);
					}
					break;
				}
				setState(657);
				stmts();
				setState(658);
				match(T__4);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(660);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__157 || _la==T__158) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(661);
				match(T__15);
				setState(670);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (STRING - 163)) | (1L << (FLOAT - 163)))) != 0)) {
					{
					setState(662);
					stringOrExp();
					setState(667);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(663);
						match(T__0);
						setState(664);
						stringOrExp();
						}
						}
						setState(669);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(672);
				match(T__16);
				}
				break;
			case 8:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(673);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(674);
				match(T__15);
				setState(675);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(676);
				match(T__16);
				setState(677);
				match(T__78);
				setState(679);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(678);
					match(NL);
					}
				}

				setState(681);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 9:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(685);
				_la = _input.LA(1);
				if (_la==T__159) {
					{
					setState(683);
					match(T__159);
					setState(684);
					((MethodDeclStmtContext)_localctx).helper = match(ID);
					}
				}

				setState(687);
				match(T__148);
				setState(688);
				((MethodDeclStmtContext)_localctx).id = match(ID);
				setState(690);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(689);
					match(NL);
					}
				}

				setState(692);
				match(T__15);
				setState(701);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(693);
					param();
					setState(698);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(694);
						match(T__0);
						setState(695);
						param();
						}
						}
						setState(700);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(703);
				match(T__16);
				setState(704);
				match(T__6);
				setState(707);
				switch (_input.LA(1)) {
				case T__18:
				case T__19:
				case T__20:
				case T__21:
				case T__22:
				case T__23:
				case T__24:
				case T__25:
				case T__26:
				case T__27:
				case T__28:
				case T__29:
				case T__30:
				case T__31:
				case T__32:
				case T__33:
				case T__34:
				case T__35:
				case T__36:
				case T__37:
				case T__38:
				case T__39:
				case T__40:
				case T__41:
				case T__42:
				case T__43:
				case T__44:
				case T__45:
				case T__46:
				case T__47:
				case T__48:
				case T__49:
				case T__50:
				case T__51:
				case T__52:
				case T__53:
				case T__54:
				case T__55:
				case T__56:
				case T__57:
				case T__58:
				case T__59:
				case T__60:
				case T__61:
					{
					setState(705);
					type();
					}
					break;
				case T__160:
					{
					setState(706);
					match(T__160);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(709);
				match(T__78);
				setState(713);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(710);
					match(NL);
					}
					}
					setState(715);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(716);
				match(T__3);
				setState(733);
				switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
				case 1:
					{
					setState(720);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(717);
						match(NL);
						}
						}
						setState(722);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(723);
					match(T__155);
					setState(724);
					methodContract();
					setState(728);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(725);
						match(NL);
						}
						}
						setState(730);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(731);
					match(T__156);
					}
					break;
				}
				setState(735);
				stmts();
				setState(746);
				_la = _input.LA(1);
				if (_la==T__161) {
					{
					setState(736);
					((MethodDeclStmtContext)_localctx).rtb = match(T__161);
					setState(738);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (FLOAT - 163)))) != 0)) {
						{
						setState(737);
						exp(0);
						}
					}

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
					}
				}

				setState(748);
				match(T__4);
				}
				break;
			case 10:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(750);
				match(T__155);
				setState(755);
				switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
				case 1:
					{
					setState(751);
					proof();
					}
					break;
				case 2:
					{
					setState(752);
					sequent();
					}
					break;
				case 3:
					{
					setState(753);
					invariants();
					}
					break;
				case 4:
					{
					setState(754);
					facts();
					}
					break;
				}
				setState(757);
				match(T__156);
				}
				break;
			case 11:
				_localctx = new ImportStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(759);
				impor();
				}
				break;
			case 12:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(760);
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
			setState(765);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(763);
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
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
			case T__61:
			case T__66:
			case T__84:
			case T__85:
			case T__162:
			case T__163:
			case NUM:
			case ID:
			case REAL:
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(764);
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

	public static class PrimExpContext extends ParserRuleContext {
		public PrimExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primExp; }
	 
		public PrimExpContext() { }
		public void copyFrom(PrimExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntLitExpContext extends PrimExpContext {
		public TerminalNode INT() { return getToken(Antlr4LogikaParser.INT, 0); }
		public IntLitExpContext(PrimExpContext ctx) { copyFrom(ctx); }
	}
	public static class FloatLitExpContext extends PrimExpContext {
		public TerminalNode FLOAT() { return getToken(Antlr4LogikaParser.FLOAT, 0); }
		public FloatLitExpContext(PrimExpContext ctx) { copyFrom(ctx); }
	}
	public static class TypeAccessExpContext extends PrimExpContext {
		public Token t;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public TypeAccessExpContext(PrimExpContext ctx) { copyFrom(ctx); }
	}
	public static class RLitExpContext extends PrimExpContext {
		public TerminalNode REAL() { return getToken(Antlr4LogikaParser.REAL, 0); }
		public RLitExpContext(PrimExpContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanExpContext extends PrimExpContext {
		public Token t;
		public BooleanExpContext(PrimExpContext ctx) { copyFrom(ctx); }
	}
	public static class VarExpContext extends PrimExpContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public VarExpContext(PrimExpContext ctx) { copyFrom(ctx); }
	}
	public static class IntExpContext extends PrimExpContext {
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public IntExpContext(PrimExpContext ctx) { copyFrom(ctx); }
	}
	public static class SeqExpContext extends PrimExpContext {
		public Token t;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SeqExpContext(PrimExpContext ctx) { copyFrom(ctx); }
	}

	public final PrimExpContext primExp() throws RecognitionException {
		PrimExpContext _localctx = new PrimExpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_primExp);
		int _la;
		try {
			setState(789);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
				_localctx = new BooleanExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(767);
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
				_localctx = new IntExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(768);
				match(NUM);
				}
				break;
			case ID:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(769);
				match(ID);
				}
				break;
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
				_localctx = new TypeAccessExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(770);
				((TypeAccessExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
					((TypeAccessExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(771);
				match(T__5);
				setState(772);
				match(ID);
				}
				break;
			case FLOAT:
				_localctx = new FloatLitExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(773);
				match(FLOAT);
				}
				break;
			case INT:
				_localctx = new IntLitExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(774);
				match(INT);
				}
				break;
			case REAL:
				_localctx = new RLitExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(775);
				match(REAL);
				}
				break;
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
			case T__61:
				_localctx = new SeqExpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(776);
				((SeqExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0)) ) {
					((SeqExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(777);
				match(T__15);
				setState(786);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (FLOAT - 163)))) != 0)) {
					{
					setState(778);
					exp(0);
					setState(783);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(779);
						match(T__0);
						setState(780);
						exp(0);
						}
						}
						setState(785);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(788);
				match(T__16);
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
	public static class InvokeExpContext extends ExpContext {
		public Token tb;
		public Token t;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public InvokeExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ParenExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class PExpContext extends ExpContext {
		public PrimExpContext primExp() {
			return getRuleContext(PrimExpContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public PExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class ReadIntExpContext extends ExpContext {
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public ReadIntExpContext(ExpContext ctx) { copyFrom(ctx); }
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
			setState(828);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(792);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0)) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(793);
				exp(10);
				}
				break;
			case 2:
				{
				_localctx = new InvokeExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(794);
				((InvokeExpContext)_localctx).tb = match(ID);
				setState(795);
				((InvokeExpContext)_localctx).t = match(T__15);
				setState(804);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (FLOAT - 163)))) != 0)) {
					{
					setState(796);
					exp(0);
					setState(801);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(797);
						match(T__0);
						setState(798);
						exp(0);
						}
						}
						setState(803);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(806);
				match(T__16);
				}
				break;
			case 3:
				{
				_localctx = new PExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(807);
				primExp();
				setState(812);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(808);
						match(T__5);
						setState(809);
						match(ID);
						}
						} 
					}
					setState(814);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
				}
				}
				break;
			case 4:
				{
				_localctx = new RandomIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(815);
				match(T__162);
				setState(816);
				match(T__15);
				setState(817);
				match(T__16);
				}
				break;
			case 5:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(818);
				match(T__163);
				setState(819);
				match(T__15);
				setState(821);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(820);
					match(STRING);
					}
				}

				setState(823);
				match(T__16);
				}
				break;
			case 6:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(824);
				match(T__15);
				setState(825);
				exp(0);
				setState(826);
				match(T__16);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(886);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(884);
					switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(830);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(831);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (T__62 - 63)) | (1L << (T__63 - 63)) | (1L << (T__64 - 63)))) != 0)) ) {
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
						((BinaryExpContext)_localctx).r = exp(10);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(836);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(837);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__65 || _la==T__66) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(839);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(838);
							match(NL);
							}
						}

						setState(841);
						((BinaryExpContext)_localctx).r = exp(9);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(842);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(843);
						((BinaryExpContext)_localctx).op = match(T__67);
						setState(845);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(844);
							match(NL);
							}
						}

						setState(847);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(848);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(849);
						((BinaryExpContext)_localctx).op = match(T__68);
						setState(851);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(850);
							match(NL);
							}
						}

						setState(853);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(854);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(855);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__72 - 70)) | (1L << (T__73 - 70)) | (1L << (T__75 - 70)) | (1L << (T__76 - 70)) | (1L << (T__77 - 70)))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(857);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(856);
							match(NL);
							}
						}

						setState(859);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(860);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(861);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__79 || _la==T__80) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(863);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(862);
							match(NL);
							}
						}

						setState(865);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(866);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(867);
						((BinaryExpContext)_localctx).op = match(T__88);
						setState(869);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(868);
							match(NL);
							}
						}

						setState(871);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(872);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(873);
						((BinaryExpContext)_localctx).op = match(T__92);
						setState(875);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(874);
							match(NL);
							}
						}

						setState(877);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(878);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(879);
						((BinaryExpContext)_localctx).op = match(T__94);
						setState(881);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(880);
							match(NL);
							}
						}

						setState(883);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(888);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
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
		enterRule(_localctx, 42, RULE_loopInvariant);
		int _la;
		try {
			int _alt;
			setState(942);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(889);
				((LoopInvariantContext)_localctx).tb = match(T__3);
				setState(893);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(890);
					match(NL);
					}
					}
					setState(895);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(896);
				modifies();
				setState(897);
				((LoopInvariantContext)_localctx).te = match(T__4);
				setState(901);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(898);
					match(NL);
					}
					}
					setState(903);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(904);
				((LoopInvariantContext)_localctx).tb = match(T__3);
				setState(908);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(905);
					match(NL);
					}
					}
					setState(910);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(911);
				((LoopInvariantContext)_localctx).itb = match(T__143);
				setState(915);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(912);
					match(NL);
					}
					}
					setState(917);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(918);
				formula(0);
				setState(929);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(920); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(919);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(922); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(925);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
						{
						setState(924);
						formula(0);
						}
					}

					}
					}
					setState(931);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(933);
				_la = _input.LA(1);
				if (_la==T__164) {
					{
					setState(932);
					modifies();
					}
				}

				setState(935);
				((LoopInvariantContext)_localctx).te = match(T__4);
				setState(939);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(936);
					match(NL);
					}
					}
					setState(941);
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
		enterRule(_localctx, 44, RULE_modifies);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(944);
			((ModifiesContext)_localctx).tb = match(T__164);
			setState(945);
			match(ID);
			setState(950);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(946);
				match(T__0);
				setState(947);
				match(ID);
				}
				}
				setState(952);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(956);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
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
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
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
			setState(959);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(963);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(960);
					match(NL);
					}
					} 
				}
				setState(965);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			}
			setState(987);
			_la = _input.LA(1);
			if (_la==T__165 || _la==T__166) {
				{
				setState(966);
				_la = _input.LA(1);
				if ( !(_la==T__165 || _la==T__166) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(970);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(967);
					match(NL);
					}
					}
					setState(972);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(973);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(984);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(975); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(974);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(977); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(980);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
							{
							setState(979);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(986);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
				}
				}
			}

			setState(992);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(989);
					match(NL);
					}
					} 
				}
				setState(994);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			}
			setState(996);
			_la = _input.LA(1);
			if (_la==T__164) {
				{
				setState(995);
				modifies();
				}
			}

			setState(1019);
			_la = _input.LA(1);
			if (_la==T__167 || _la==T__168) {
				{
				setState(998);
				_la = _input.LA(1);
				if ( !(_la==T__167 || _la==T__168) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
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
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(1016);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,143,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1007); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1006);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1009); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(1012);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
							{
							setState(1011);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(1018);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,143,_ctx);
				}
				}
			}

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
			setState(1027);
			((MethodContractContext)_localctx).te = match(T__4);
			setState(1031);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1028);
					match(NL);
					}
					} 
				}
				setState(1033);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
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
		enterRule(_localctx, 48, RULE_invariants);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1034);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(1038);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1035);
				match(NL);
				}
				}
				setState(1040);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1041);
			match(T__143);
			setState(1045);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1042);
				match(NL);
				}
				}
				setState(1047);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1048);
			formula(0);
			setState(1059);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1050); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1049);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1052); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,149,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1055);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
					{
					setState(1054);
					formula(0);
					}
				}

				}
				}
				setState(1061);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1062);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(1066);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1063);
				match(NL);
				}
				}
				setState(1068);
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
		case 5:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 8:
			return justification_sempred((JustificationContext)_localctx, predIndex);
		case 20:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean justification_sempred(JustificationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return ("->".equals(_input.LT(1).getText()) ||
		      "→".equals(_input.LT(1).getText())) &&
		     "i".equals(_input.LT(2).getText());
		case 11:
			return ("->".equals(_input.LT(1).getText()) ||
		      "→".equals(_input.LT(1).getText())) &&
		      "e".equals(_input.LT(2).getText());
		case 12:
			return ("!".equals(_input.LT(1).getText()) ||
		      "~".equals(_input.LT(1).getText()) ||
		      "¬".equals(_input.LT(1).getText())) &&
		     "i".equals(_input.LT(2).getText());
		case 13:
			return ("!".equals(_input.LT(1).getText()) ||
		      "~".equals(_input.LT(1).getText()) ||
		      "¬".equals(_input.LT(1).getText())) &&
		     "e".equals(_input.LT(2).getText());
		case 14:
			return "∀".equals(_input.LT(1).getText()) &&
		     "i".equals(_input.LT(2).getText());
		case 15:
			return "∀".equals(_input.LT(1).getText()) &&
		     "e".equals(_input.LT(2).getText());
		case 16:
			return "∃".equals(_input.LT(1).getText()) &&
		     "i".equals(_input.LT(2).getText());
		case 17:
			return "∃".equals(_input.LT(1).getText()) &&
		     "e".equals(_input.LT(2).getText());
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 9);
		case 19:
			return precpred(_ctx, 8);
		case 20:
			return precpred(_ctx, 7);
		case 21:
			return precpred(_ctx, 6);
		case 22:
			return precpred(_ctx, 5);
		case 23:
			return precpred(_ctx, 4);
		case 24:
			return precpred(_ctx, 3);
		case 25:
			return precpred(_ctx, 2);
		case 26:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u00b8\u0430\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\5\2=\n\2\3\2\7\2@\n\2"+
		"\f\2\16\2C\13\2\3\2\3\2\3\2\3\2\3\2\5\2J\n\2\3\3\3\3\3\3\7\3O\n\3\f\3"+
		"\16\3R\13\3\5\3T\n\3\3\3\3\3\3\3\3\3\7\3Z\n\3\f\3\16\3]\13\3\3\3\7\3`"+
		"\n\3\f\3\16\3c\13\3\3\3\3\3\6\3g\n\3\r\3\16\3h\5\3k\n\3\3\4\3\4\5\4o\n"+
		"\4\3\4\6\4r\n\4\r\4\16\4s\3\4\5\4w\n\4\7\4y\n\4\f\4\16\4|\13\4\3\4\3\4"+
		"\7\4\u0080\n\4\f\4\16\4\u0083\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5"+
		"\u008d\n\5\f\5\16\5\u0090\13\5\3\5\3\5\7\5\u0094\n\5\f\5\16\5\u0097\13"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5\u009e\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00a6"+
		"\n\5\3\5\3\5\3\5\5\5\u00ab\n\5\3\5\6\5\u00ae\n\5\r\5\16\5\u00af\3\5\5"+
		"\5\u00b3\n\5\7\5\u00b5\n\5\f\5\16\5\u00b8\13\5\3\5\5\5\u00bb\n\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00c8\n\6\f\6\16\6\u00cb\13"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00dc"+
		"\n\6\f\6\16\6\u00df\13\6\5\6\u00e1\n\6\3\6\5\6\u00e4\n\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\7\7\u00ee\n\7\f\7\16\7\u00f1\13\7\3\7\5\7\u00f4\n\7"+
		"\3\7\3\7\3\7\5\7\u00f9\n\7\3\7\3\7\3\7\3\7\5\7\u00ff\n\7\3\7\3\7\3\7\3"+
		"\7\5\7\u0105\n\7\3\7\3\7\3\7\3\7\5\7\u010b\n\7\3\7\3\7\3\7\3\7\5\7\u0111"+
		"\n\7\3\7\3\7\3\7\3\7\5\7\u0117\n\7\3\7\3\7\3\7\3\7\5\7\u011d\n\7\3\7\3"+
		"\7\3\7\3\7\5\7\u0123\n\7\3\7\3\7\3\7\3\7\5\7\u0129\n\7\3\7\3\7\3\7\3\7"+
		"\5\7\u012f\n\7\3\7\7\7\u0132\n\7\f\7\16\7\u0135\13\7\3\b\3\b\3\b\3\b\7"+
		"\b\u013b\n\b\f\b\16\b\u013e\13\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0146\n\b"+
		"\3\b\3\b\5\b\u014a\n\b\3\b\3\b\3\b\5\b\u014f\n\b\3\b\5\b\u0152\n\b\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u015c\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u0163"+
		"\n\n\3\n\3\n\3\n\3\n\5\n\u0169\n\n\3\n\3\n\3\n\3\n\5\n\u016f\n\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0193"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u01a0\n\n\f\n\16"+
		"\n\u01a3\13\n\3\n\3\n\3\n\3\n\3\n\6\n\u01aa\n\n\r\n\16\n\u01ab\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u01b7\n\n\r\n\16\n\u01b8\3\n\3\n\3\n"+
		"\6\n\u01be\n\n\r\n\16\n\u01bf\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u01ca"+
		"\n\n\r\n\16\n\u01cb\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u01d8"+
		"\n\n\f\n\16\n\u01db\13\n\5\n\u01dd\n\n\3\13\7\13\u01e0\n\13\f\13\16\13"+
		"\u01e3\13\13\3\13\3\13\6\13\u01e7\n\13\r\13\16\13\u01e8\3\13\3\13\5\13"+
		"\u01ed\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\7\r\u01fa\n\r"+
		"\f\r\16\r\u01fd\13\r\3\r\3\r\7\r\u0201\n\r\f\r\16\r\u0204\13\r\3\r\3\r"+
		"\6\r\u0208\n\r\r\r\16\r\u0209\3\r\5\r\u020d\n\r\7\r\u020f\n\r\f\r\16\r"+
		"\u0212\13\r\3\r\3\r\7\r\u0216\n\r\f\r\16\r\u0219\13\r\3\16\3\16\5\16\u021d"+
		"\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u0226\n\20\3\20\3\20\3\20"+
		"\3\20\7\20\u022c\n\20\f\20\16\20\u022f\13\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\22\5\22\u023a\n\22\3\22\6\22\u023d\n\22\r\22\16\22\u023e"+
		"\3\22\5\22\u0242\n\22\7\22\u0244\n\22\f\22\16\22\u0247\13\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u024f\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u0256"+
		"\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\7\23\u0268\n\23\f\23\16\23\u026b\13\23\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u0272\n\23\f\23\16\23\u0275\13\23\3\23\3\23\3\23\3\23"+
		"\5\23\u027b\n\23\3\23\3\23\3\23\3\23\3\23\7\23\u0282\n\23\f\23\16\23\u0285"+
		"\13\23\3\23\3\23\7\23\u0289\n\23\f\23\16\23\u028c\13\23\3\23\3\23\3\23"+
		"\3\23\5\23\u0292\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u029c"+
		"\n\23\f\23\16\23\u029f\13\23\5\23\u02a1\n\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u02aa\n\23\3\23\3\23\3\23\3\23\5\23\u02b0\n\23\3\23\3"+
		"\23\3\23\5\23\u02b5\n\23\3\23\3\23\3\23\3\23\7\23\u02bb\n\23\f\23\16\23"+
		"\u02be\13\23\5\23\u02c0\n\23\3\23\3\23\3\23\3\23\5\23\u02c6\n\23\3\23"+
		"\3\23\7\23\u02ca\n\23\f\23\16\23\u02cd\13\23\3\23\3\23\7\23\u02d1\n\23"+
		"\f\23\16\23\u02d4\13\23\3\23\3\23\3\23\7\23\u02d9\n\23\f\23\16\23\u02dc"+
		"\13\23\3\23\3\23\5\23\u02e0\n\23\3\23\3\23\3\23\5\23\u02e5\n\23\3\23\7"+
		"\23\u02e8\n\23\f\23\16\23\u02eb\13\23\5\23\u02ed\n\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u02f6\n\23\3\23\3\23\3\23\3\23\5\23\u02fc\n\23"+
		"\3\24\3\24\5\24\u0300\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\7\25\u0310\n\25\f\25\16\25\u0313\13\25\5\25"+
		"\u0315\n\25\3\25\5\25\u0318\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\7\26\u0322\n\26\f\26\16\26\u0325\13\26\5\26\u0327\n\26\3\26\3\26\3"+
		"\26\3\26\7\26\u032d\n\26\f\26\16\26\u0330\13\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\5\26\u0338\n\26\3\26\3\26\3\26\3\26\3\26\5\26\u033f\n\26\3\26"+
		"\3\26\3\26\5\26\u0344\n\26\3\26\3\26\3\26\3\26\5\26\u034a\n\26\3\26\3"+
		"\26\3\26\3\26\5\26\u0350\n\26\3\26\3\26\3\26\3\26\5\26\u0356\n\26\3\26"+
		"\3\26\3\26\3\26\5\26\u035c\n\26\3\26\3\26\3\26\3\26\5\26\u0362\n\26\3"+
		"\26\3\26\3\26\3\26\5\26\u0368\n\26\3\26\3\26\3\26\3\26\5\26\u036e\n\26"+
		"\3\26\3\26\3\26\3\26\5\26\u0374\n\26\3\26\7\26\u0377\n\26\f\26\16\26\u037a"+
		"\13\26\3\27\3\27\7\27\u037e\n\27\f\27\16\27\u0381\13\27\3\27\3\27\3\27"+
		"\7\27\u0386\n\27\f\27\16\27\u0389\13\27\3\27\3\27\7\27\u038d\n\27\f\27"+
		"\16\27\u0390\13\27\3\27\3\27\7\27\u0394\n\27\f\27\16\27\u0397\13\27\3"+
		"\27\3\27\6\27\u039b\n\27\r\27\16\27\u039c\3\27\5\27\u03a0\n\27\7\27\u03a2"+
		"\n\27\f\27\16\27\u03a5\13\27\3\27\5\27\u03a8\n\27\3\27\3\27\7\27\u03ac"+
		"\n\27\f\27\16\27\u03af\13\27\5\27\u03b1\n\27\3\30\3\30\3\30\3\30\7\30"+
		"\u03b7\n\30\f\30\16\30\u03ba\13\30\3\30\7\30\u03bd\n\30\f\30\16\30\u03c0"+
		"\13\30\3\31\3\31\7\31\u03c4\n\31\f\31\16\31\u03c7\13\31\3\31\3\31\7\31"+
		"\u03cb\n\31\f\31\16\31\u03ce\13\31\3\31\3\31\6\31\u03d2\n\31\r\31\16\31"+
		"\u03d3\3\31\5\31\u03d7\n\31\7\31\u03d9\n\31\f\31\16\31\u03dc\13\31\5\31"+
		"\u03de\n\31\3\31\7\31\u03e1\n\31\f\31\16\31\u03e4\13\31\3\31\5\31\u03e7"+
		"\n\31\3\31\3\31\7\31\u03eb\n\31\f\31\16\31\u03ee\13\31\3\31\3\31\6\31"+
		"\u03f2\n\31\r\31\16\31\u03f3\3\31\5\31\u03f7\n\31\7\31\u03f9\n\31\f\31"+
		"\16\31\u03fc\13\31\5\31\u03fe\n\31\3\31\7\31\u0401\n\31\f\31\16\31\u0404"+
		"\13\31\3\31\3\31\7\31\u0408\n\31\f\31\16\31\u040b\13\31\3\32\3\32\7\32"+
		"\u040f\n\32\f\32\16\32\u0412\13\32\3\32\3\32\7\32\u0416\n\32\f\32\16\32"+
		"\u0419\13\32\3\32\3\32\6\32\u041d\n\32\r\32\16\32\u041e\3\32\5\32\u0422"+
		"\n\32\7\32\u0424\n\32\f\32\16\32\u0427\13\32\3\32\3\32\7\32\u042b\n\32"+
		"\f\32\16\32\u042e\13\32\3\32\2\4\f*\33\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\2\'\3\2\4\5\3\2\13\21\3\2\25*\3\2+@\3\2UY\3\2AC"+
		"\3\2DE\3\2HP\3\2QT\3\2Z]\3\2^_\3\2`c\3\2df\3\2gn\3\2\25@\3\2[]\3\2rs\3"+
		"\2tw\4\2aacc\3\2xy\3\2ef\3\2|}\3\2~\177\3\2WY\3\2\u0080\u0081\3\2\20\21"+
		"\3\2\u0086\u0088\3\2\u0089\u008b\3\2\u008c\u008e\3\2\u008f\u0091\3\2\u0098"+
		"\u0099\3\2\u00a0\u00a1\4\2EEWX\5\2HIKLNP\3\2RS\3\2\u00a8\u00a9\3\2\u00aa"+
		"\u00ab\u04fc\2I\3\2\2\2\4j\3\2\2\2\6l\3\2\2\2\b\u00ba\3\2\2\2\n\u00e3"+
		"\3\2\2\2\f\u00f3\3\2\2\2\16\u0136\3\2\2\2\20\u0155\3\2\2\2\22\u01dc\3"+
		"\2\2\2\24\u01e1\3\2\2\2\26\u01ee\3\2\2\2\30\u01f7\3\2\2\2\32\u021c\3\2"+
		"\2\2\34\u021e\3\2\2\2\36\u0222\3\2\2\2 \u0234\3\2\2\2\"\u0239\3\2\2\2"+
		"$\u02fb\3\2\2\2&\u02ff\3\2\2\2(\u0317\3\2\2\2*\u033e\3\2\2\2,\u03b0\3"+
		"\2\2\2.\u03b2\3\2\2\2\60\u03c1\3\2\2\2\62\u040c\3\2\2\2\648\5\4\3\2\65"+
		"\67\7\u00b2\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29<\3\2"+
		"\2\2:8\3\2\2\2;=\5\6\4\2<;\3\2\2\2<=\3\2\2\2=A\3\2\2\2>@\7\u00b2\2\2?"+
		">\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\2\2\3"+
		"EJ\3\2\2\2FG\5\24\13\2GH\7\2\2\3HJ\3\2\2\2I\64\3\2\2\2IF\3\2\2\2J\3\3"+
		"\2\2\2KP\5\f\7\2LM\7\3\2\2MO\5\f\7\2NL\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3"+
		"\2\2\2QT\3\2\2\2RP\3\2\2\2SK\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\t\2\2\2V[\5"+
		"\f\7\2WX\7\3\2\2XZ\5\f\7\2YW\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\"+
		"k\3\2\2\2][\3\2\2\2^`\5\f\7\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2"+
		"bd\3\2\2\2ca\3\2\2\2df\7\u00ac\2\2eg\5\f\7\2fe\3\2\2\2gh\3\2\2\2hf\3\2"+
		"\2\2hi\3\2\2\2ik\3\2\2\2jS\3\2\2\2ja\3\2\2\2k\5\3\2\2\2ln\7\6\2\2mo\5"+
		"\b\5\2nm\3\2\2\2no\3\2\2\2oz\3\2\2\2pr\7\u00b2\2\2qp\3\2\2\2rs\3\2\2\2"+
		"sq\3\2\2\2st\3\2\2\2tv\3\2\2\2uw\5\b\5\2vu\3\2\2\2vw\3\2\2\2wy\3\2\2\2"+
		"xq\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}\u0081\7"+
		"\7\2\2~\u0080\7\u00b2\2\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3"+
		"\2\2\2\u0081\u0082\3\2\2\2\u0082\7\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085"+
		"\7\u00ad\2\2\u0085\u0086\7\b\2\2\u0086\u0087\5\f\7\2\u0087\u0088\5\22"+
		"\n\2\u0088\u00bb\3\2\2\2\u0089\u008a\7\u00ad\2\2\u008a\u008e\7\b\2\2\u008b"+
		"\u008d\7\u00b2\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091"+
		"\u0095\7\6\2\2\u0092\u0094\7\u00b2\2\2\u0093\u0092\3\2\2\2\u0094\u0097"+
		"\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098\u0099\7\u00ad\2\2\u0099\u00aa\7\b\2\2\u009a\u009d"+
		"\7\u00ae\2\2\u009b\u009c\7\t\2\2\u009c\u009e\5\20\t\2\u009d\u009b\3\2"+
		"\2\2\u009d\u009e\3\2\2\2\u009e\u00ab\3\2\2\2\u009f\u00a0\5\f\7\2\u00a0"+
		"\u00a1\7\n\2\2\u00a1\u00ab\3\2\2\2\u00a2\u00a5\7\u00ae\2\2\u00a3\u00a4"+
		"\7\t\2\2\u00a4\u00a6\5\20\t\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2"+
		"\u00a6\u00a7\3\2\2\2\u00a7\u00a8\5\f\7\2\u00a8\u00a9\7\n\2\2\u00a9\u00ab"+
		"\3\2\2\2\u00aa\u009a\3\2\2\2\u00aa\u009f\3\2\2\2\u00aa\u00a2\3\2\2\2\u00ab"+
		"\u00b6\3\2\2\2\u00ac\u00ae\7\u00b2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1"+
		"\u00b3\5\b\5\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2"+
		"\2\2\u00b4\u00ad\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bb\7\7"+
		"\2\2\u00ba\u0084\3\2\2\2\u00ba\u0089\3\2\2\2\u00bb\t\3\2\2\2\u00bc\u00e4"+
		"\t\3\2\2\u00bd\u00be\7\22\2\2\u00be\u00bf\5\f\7\2\u00bf\u00c0\7\23\2\2"+
		"\u00c0\u00e4\3\2\2\2\u00c1\u00e4\7\24\2\2\u00c2\u00c3\7\u00ae\2\2\u00c3"+
		"\u00c4\7\22\2\2\u00c4\u00c9\5\f\7\2\u00c5\u00c6\7\3\2\2\u00c6\u00c8\5"+
		"\f\7\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7\23"+
		"\2\2\u00cd\u00e4\3\2\2\2\u00ce\u00e4\7\u00ae\2\2\u00cf\u00e4\7\u00ad\2"+
		"\2\u00d0\u00e4\7\u00b0\2\2\u00d1\u00e4\7\u00af\2\2\u00d2\u00e4\7\u00b7"+
		"\2\2\u00d3\u00d4\t\4\2\2\u00d4\u00d5\7\b\2\2\u00d5\u00e4\7\u00ae\2\2\u00d6"+
		"\u00d7\t\5\2\2\u00d7\u00e0\7\22\2\2\u00d8\u00dd\5*\26\2\u00d9\u00da\7"+
		"\3\2\2\u00da\u00dc\5*\26\2\u00db\u00d9\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2"+
		"\2\2\u00e0\u00d8\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e4\7\23\2\2\u00e3\u00bc\3\2\2\2\u00e3\u00bd\3\2\2\2\u00e3\u00c1\3"+
		"\2\2\2\u00e3\u00c2\3\2\2\2\u00e3\u00ce\3\2\2\2\u00e3\u00cf\3\2\2\2\u00e3"+
		"\u00d0\3\2\2\2\u00e3\u00d1\3\2\2\2\u00e3\u00d2\3\2\2\2\u00e3\u00d3\3\2"+
		"\2\2\u00e3\u00d6\3\2\2\2\u00e4\13\3\2\2\2\u00e5\u00e6\b\7\1\2\u00e6\u00e7"+
		"\7E\2\2\u00e7\u00f4\5\f\7\t\u00e8\u00e9\t\6\2\2\u00e9\u00f4\5\f\7\b\u00ea"+
		"\u00ef\5\n\6\2\u00eb\u00ec\7\b\2\2\u00ec\u00ee\7\u00ae\2\2\u00ed\u00eb"+
		"\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00f4\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00f4\5\16\b\2\u00f3\u00e5\3"+
		"\2\2\2\u00f3\u00e8\3\2\2\2\u00f3\u00ea\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4"+
		"\u0133\3\2\2\2\u00f5\u00f6\f\17\2\2\u00f6\u00f8\t\7\2\2\u00f7\u00f9\7"+
		"\u00b2\2\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2"+
		"\u00fa\u0132\5\f\7\20\u00fb\u00fc\f\16\2\2\u00fc\u00fe\t\b\2\2\u00fd\u00ff"+
		"\7\u00b2\2\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\3\2\2"+
		"\2\u0100\u0132\5\f\7\17\u0101\u0102\f\r\2\2\u0102\u0104\7F\2\2\u0103\u0105"+
		"\7\u00b2\2\2\u0104\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\3\2\2"+
		"\2\u0106\u0132\5\f\7\r\u0107\u0108\f\f\2\2\u0108\u010a\7G\2\2\u0109\u010b"+
		"\7\u00b2\2\2\u010a\u0109\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2"+
		"\2\u010c\u0132\5\f\7\r\u010d\u010e\f\13\2\2\u010e\u0110\t\t\2\2\u010f"+
		"\u0111\7\u00b2\2\2\u0110\u010f\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112"+
		"\3\2\2\2\u0112\u0132\5\f\7\f\u0113\u0114\f\n\2\2\u0114\u0116\t\n\2\2\u0115"+
		"\u0117\7\u00b2\2\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118"+
		"\3\2\2\2\u0118\u0132\5\f\7\13\u0119\u011a\f\7\2\2\u011a\u011c\t\13\2\2"+
		"\u011b\u011d\7\u00b2\2\2\u011c\u011b\3\2\2\2\u011c\u011d\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u0132\5\f\7\b\u011f\u0120\f\6\2\2\u0120\u0122\t\f"+
		"\2\2\u0121\u0123\7\u00b2\2\2\u0122\u0121\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\u0124\3\2\2\2\u0124\u0132\5\f\7\7\u0125\u0126\f\5\2\2\u0126\u0128\t\r"+
		"\2\2\u0127\u0129\7\u00b2\2\2\u0128\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u0132\5\f\7\6\u012b\u012c\f\4\2\2\u012c\u012e\t\16"+
		"\2\2\u012d\u012f\7\u00b2\2\2\u012e\u012d\3\2\2\2\u012e\u012f\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u0132\5\f\7\4\u0131\u00f5\3\2\2\2\u0131\u00fb\3\2"+
		"\2\2\u0131\u0101\3\2\2\2\u0131\u0107\3\2\2\2\u0131\u010d\3\2\2\2\u0131"+
		"\u0113\3\2\2\2\u0131\u0119\3\2\2\2\u0131\u011f\3\2\2\2\u0131\u0125\3\2"+
		"\2\2\u0131\u012b\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133"+
		"\u0134\3\2\2\2\u0134\r\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0137\t\17\2"+
		"\2\u0137\u013c\7\u00ae\2\2\u0138\u0139\7\3\2\2\u0139\u013b\7\u00ae\2\2"+
		"\u013a\u0138\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d"+
		"\3\2\2\2\u013d\u014e\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\7\t\2\2\u0140"+
		"\u014f\5\20\t\2\u0141\u0142\7\t\2\2\u0142\u0143\7\22\2\2\u0143\u0145\5"+
		"*\26\2\u0144\u0146\7H\2\2\u0145\u0144\3\2\2\2\u0145\u0146\3\2\2\2\u0146"+
		"\u0147\3\2\2\2\u0147\u0149\7o\2\2\u0148\u014a\7H\2\2\u0149\u0148\3\2\2"+
		"\2\u0149\u014a\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\5*\26\2\u014c\u014d"+
		"\7\23\2\2\u014d\u014f\3\2\2\2\u014e\u013f\3\2\2\2\u014e\u0141\3\2\2\2"+
		"\u014e\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u0152\7\u00b2\2\2\u0151"+
		"\u0150\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\5\f"+
		"\7\2\u0154\17\3\2\2\2\u0155\u0156\t\20\2\2\u0156\21\3\2\2\2\u0157\u01dd"+
		"\7p\2\2\u0158\u015c\7q\2\2\u0159\u015a\t\21\2\2\u015a\u015c\7\u00ae\2"+
		"\2\u015b\u0158\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e"+
		"\7\u00ad\2\2\u015e\u01dd\7\u00ad\2\2\u015f\u0163\t\22\2\2\u0160\u0161"+
		"\t\21\2\2\u0161\u0163\7\u00ae\2\2\u0162\u015f\3\2\2\2\u0162\u0160\3\2"+
		"\2\2\u0163\u0164\3\2\2\2\u0164\u01dd\7\u00ad\2\2\u0165\u0169\t\23\2\2"+
		"\u0166\u0167\t\24\2\2\u0167\u0169\7\u00ae\2\2\u0168\u0165\3\2\2\2\u0168"+
		"\u0166\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u01dd\7\u00ad\2\2\u016b\u016f"+
		"\t\25\2\2\u016c\u016d\t\24\2\2\u016d\u016f\7\u00ae\2\2\u016e\u016b\3\2"+
		"\2\2\u016e\u016c\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\7\u00ad\2\2\u0171"+
		"\u0172\7\u00ad\2\2\u0172\u01dd\7\u00ad\2\2\u0173\u0174\7z\2\2\u0174\u01dd"+
		"\7\u00ad\2\2\u0175\u0176\7{\2\2\u0176\u0177\7\u00ad\2\2\u0177\u01dd\7"+
		"\u00ad\2\2\u0178\u0179\6\n\f\2\u0179\u017a\t\26\2\2\u017a\u017b\7\u00ae"+
		"\2\2\u017b\u01dd\7\u00ad\2\2\u017c\u017d\6\n\r\2\u017d\u017e\t\26\2\2"+
		"\u017e\u017f\7\u00ae\2\2\u017f\u0180\7\u00ad\2\2\u0180\u01dd\7\u00ad\2"+
		"\2\u0181\u0182\t\27\2\2\u0182\u01dd\7\u00ad\2\2\u0183\u0184\t\30\2\2\u0184"+
		"\u0185\7\u00ad\2\2\u0185\u01dd\7\u00ad\2\2\u0186\u0187\6\n\16\2\u0187"+
		"\u0188\t\31\2\2\u0188\u0189\7\u00ae\2\2\u0189\u01dd\7\u00ad\2\2\u018a"+
		"\u018b\6\n\17\2\u018b\u018c\t\31\2\2\u018c\u018d\7\u00ae\2\2\u018d\u018e"+
		"\7\u00ad\2\2\u018e\u01dd\7\u00ad\2\2\u018f\u0193\t\32\2\2\u0190\u0191"+
		"\t\33\2\2\u0191\u0193\7\u00ae\2\2\u0192\u018f\3\2\2\2\u0192\u0190\3\2"+
		"\2\2\u0193\u0194\3\2\2\2\u0194\u01dd\7\u00ad\2\2\u0195\u0196\7\u0082\2"+
		"\2\u0196\u01dd\7\u00ad\2\2\u0197\u0198\7\u0083\2\2\u0198\u0199\7\u00ad"+
		"\2\2\u0199\u01dd\7\u00ad\2\2\u019a\u019b\7\u0084\2\2\u019b\u019c\7\u00ad"+
		"\2\2\u019c\u01dd\7\u00ad\2\2\u019d\u01a1\7\u0085\2\2\u019e\u01a0\7\u00ad"+
		"\2\2\u019f\u019e\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3\2\2\2\u01a1"+
		"\u01a2\3\2\2\2\u01a2\u01dd\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4\u01a5\t\34"+
		"\2\2\u01a5\u01dd\7\u00ad\2\2\u01a6\u01a7\t\35\2\2\u01a7\u01a9\7\u00ad"+
		"\2\2\u01a8\u01aa\5\f\7\2\u01a9\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab"+
		"\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01dd\3\2\2\2\u01ad\u01ae\6\n"+
		"\20\2\u01ae\u01af\7j\2\2\u01af\u01b0\7\u00ae\2\2\u01b0\u01dd\7\u00ad\2"+
		"\2\u01b1\u01b2\6\n\21\2\u01b2\u01b3\7j\2\2\u01b3\u01b4\7\u00ae\2\2\u01b4"+
		"\u01b6\7\u00ad\2\2\u01b5\u01b7\5\f\7\2\u01b6\u01b5\3\2\2\2\u01b7\u01b8"+
		"\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01dd\3\2\2\2\u01ba"+
		"\u01bb\t\36\2\2\u01bb\u01bd\7\u00ad\2\2\u01bc\u01be\5\f\7\2\u01bd\u01bc"+
		"\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0"+
		"\u01dd\3\2\2\2\u01c1\u01c2\t\37\2\2\u01c2\u01c3\7\u00ad\2\2\u01c3\u01dd"+
		"\7\u00ad\2\2\u01c4\u01c5\6\n\22\2\u01c5\u01c6\7n\2\2\u01c6\u01c7\7\u00ae"+
		"\2\2\u01c7\u01c9\7\u00ad\2\2\u01c8\u01ca\5\f\7\2\u01c9\u01c8\3\2\2\2\u01ca"+
		"\u01cb\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01dd\3\2"+
		"\2\2\u01cd\u01ce\6\n\23\2\u01ce\u01cf\7n\2\2\u01cf\u01d0\7\u00ae\2\2\u01d0"+
		"\u01d1\7\u00ad\2\2\u01d1\u01dd\7\u00ad\2\2\u01d2\u01dd\7\u0092\2\2\u01d3"+
		"\u01d4\7\u0093\2\2\u01d4\u01dd\7\u00ae\2\2\u01d5\u01d9\7\u0094\2\2\u01d6"+
		"\u01d8\7\u00ad\2\2\u01d7\u01d6\3\2\2\2\u01d8\u01db\3\2\2\2\u01d9\u01d7"+
		"\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc"+
		"\u0157\3\2\2\2\u01dc\u015b\3\2\2\2\u01dc\u0162\3\2\2\2\u01dc\u0168\3\2"+
		"\2\2\u01dc\u016e\3\2\2\2\u01dc\u0173\3\2\2\2\u01dc\u0175\3\2\2\2\u01dc"+
		"\u0178\3\2\2\2\u01dc\u017c\3\2\2\2\u01dc\u0181\3\2\2\2\u01dc\u0183\3\2"+
		"\2\2\u01dc\u0186\3\2\2\2\u01dc\u018a\3\2\2\2\u01dc\u0192\3\2\2\2\u01dc"+
		"\u0195\3\2\2\2\u01dc\u0197\3\2\2\2\u01dc\u019a\3\2\2\2\u01dc\u019d\3\2"+
		"\2\2\u01dc\u01a4\3\2\2\2\u01dc\u01a6\3\2\2\2\u01dc\u01ad\3\2\2\2\u01dc"+
		"\u01b1\3\2\2\2\u01dc\u01ba\3\2\2\2\u01dc\u01c1\3\2\2\2\u01dc\u01c4\3\2"+
		"\2\2\u01dc\u01cd\3\2\2\2\u01dc\u01d2\3\2\2\2\u01dc\u01d3\3\2\2\2\u01dc"+
		"\u01d5\3\2\2\2\u01dd\23\3\2\2\2\u01de\u01e0\7\u00b2\2\2\u01df\u01de\3"+
		"\2\2\2\u01e0\u01e3\3\2\2\2\u01e1\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2"+
		"\u01ec\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e4\u01e6\5\26\f\2\u01e5\u01e7\7"+
		"\u00b2\2\2\u01e6\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e6\3\2\2\2"+
		"\u01e8\u01e9\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb\5\"\22\2\u01eb\u01ed"+
		"\3\2\2\2\u01ec\u01e4\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\25\3\2\2\2\u01ee"+
		"\u01ef\7\u0095\2\2\u01ef\u01f0\7\u00ae\2\2\u01f0\u01f1\7\b\2\2\u01f1\u01f2"+
		"\7\u00ae\2\2\u01f2\u01f3\7\b\2\2\u01f3\u01f4\7\u00ae\2\2\u01f4\u01f5\7"+
		"\b\2\2\u01f5\u01f6\7\u0096\2\2\u01f6\27\3\2\2\2\u01f7\u01fb\7\6\2\2\u01f8"+
		"\u01fa\7\u00b2\2\2\u01f9\u01f8\3\2\2\2\u01fa\u01fd\3\2\2\2\u01fb\u01f9"+
		"\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fe\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fe"+
		"\u0202\7\u0093\2\2\u01ff\u0201\7\u00b2\2\2\u0200\u01ff\3\2\2\2\u0201\u0204"+
		"\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0205\3\2\2\2\u0204"+
		"\u0202\3\2\2\2\u0205\u0210\5\32\16\2\u0206\u0208\7\u00b2\2\2\u0207\u0206"+
		"\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a"+
		"\u020c\3\2\2\2\u020b\u020d\5\32\16\2\u020c\u020b\3\2\2\2\u020c\u020d\3"+
		"\2\2\2\u020d\u020f\3\2\2\2\u020e\u0207\3\2\2\2\u020f\u0212\3\2\2\2\u0210"+
		"\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0213\3\2\2\2\u0212\u0210\3\2"+
		"\2\2\u0213\u0217\7\7\2\2\u0214\u0216\7\u00b2\2\2\u0215\u0214\3\2\2\2\u0216"+
		"\u0219\3\2\2\2\u0217\u0215\3\2\2\2\u0217\u0218\3\2\2\2\u0218\31\3\2\2"+
		"\2\u0219\u0217\3\2\2\2\u021a\u021d\5\34\17\2\u021b\u021d\5\36\20\2\u021c"+
		"\u021a\3\2\2\2\u021c\u021b\3\2\2\2\u021d\33\3\2\2\2\u021e\u021f\7\u00ae"+
		"\2\2\u021f\u0220\7\b\2\2\u0220\u0221\5\f\7\2\u0221\35\3\2\2\2\u0222\u0223"+
		"\7\u0097\2\2\u0223\u0225\7\u00ae\2\2\u0224\u0226\7\u00b2\2\2\u0225\u0224"+
		"\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0228\7\22\2\2"+
		"\u0228\u022d\5 \21\2\u0229\u022a\7\3\2\2\u022a\u022c\5 \21\2\u022b\u0229"+
		"\3\2\2\2\u022c\u022f\3\2\2\2\u022d\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022e"+
		"\u0230\3\2\2\2\u022f\u022d\3\2\2\2\u0230\u0231\7\23\2\2\u0231\u0232\7"+
		"\t\2\2\u0232\u0233\5\20\t\2\u0233\37\3\2\2\2\u0234\u0235\7\u00ae\2\2\u0235"+
		"\u0236\7\t\2\2\u0236\u0237\5\20\t\2\u0237!\3\2\2\2\u0238\u023a\5$\23\2"+
		"\u0239\u0238\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u0245\3\2\2\2\u023b\u023d"+
		"\7\u00b2\2\2\u023c\u023b\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u023c\3\2\2"+
		"\2\u023e\u023f\3\2\2\2\u023f\u0241\3\2\2\2\u0240\u0242\5$\23\2\u0241\u0240"+
		"\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0244\3\2\2\2\u0243\u023c\3\2\2\2\u0244"+
		"\u0247\3\2\2\2\u0245\u0243\3\2\2\2\u0245\u0246\3\2\2\2\u0246#\3\2\2\2"+
		"\u0247\u0245\3\2\2\2\u0248\u0249\t \2\2\u0249\u024a\7\u00ae\2\2\u024a"+
		"\u024b\7\t\2\2\u024b\u024c\5\20\t\2\u024c\u024e\7Q\2\2\u024d\u024f\7\u00b2"+
		"\2\2\u024e\u024d\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0250\3\2\2\2\u0250"+
		"\u0251\5*\26\2\u0251\u02fc\3\2\2\2\u0252\u0253\7\u00ae\2\2\u0253\u0255"+
		"\7Q\2\2\u0254\u0256\7\u00b2\2\2\u0255\u0254\3\2\2\2\u0255\u0256\3\2\2"+
		"\2\u0256\u0257\3\2\2\2\u0257\u02fc\5*\26\2\u0258\u0259\7\n\2\2\u0259\u025a"+
		"\7\22\2\2\u025a\u025b\5*\26\2\u025b\u025c\7\23\2\2\u025c\u02fc\3\2\2\2"+
		"\u025d\u025e\7\u009a\2\2\u025e\u025f\7\22\2\2\u025f\u0260\5*\26\2\u0260"+
		"\u0261\7\23\2\2\u0261\u02fc\3\2\2\2\u0262\u0263\7\u009b\2\2\u0263\u0264"+
		"\7\22\2\2\u0264\u0265\5*\26\2\u0265\u0269\7\23\2\2\u0266\u0268\7\u00b2"+
		"\2\2\u0267\u0266\3\2\2\2\u0268\u026b\3\2\2\2\u0269\u0267\3\2\2\2\u0269"+
		"\u026a\3\2\2\2\u026a\u026c\3\2\2\2\u026b\u0269\3\2\2\2\u026c\u026d\7\6"+
		"\2\2\u026d\u026e\5\"\22\2\u026e\u027a\7\7\2\2\u026f\u0273\7\u009c\2\2"+
		"\u0270\u0272\7\u00b2\2\2\u0271\u0270\3\2\2\2\u0272\u0275\3\2\2\2\u0273"+
		"\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274\u0276\3\2\2\2\u0275\u0273\3\2"+
		"\2\2\u0276\u0277\7\6\2\2\u0277\u0278\5\"\22\2\u0278\u0279\7\7\2\2\u0279"+
		"\u027b\3\2\2\2\u027a\u026f\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u02fc\3\2"+
		"\2\2\u027c\u027d\7\u009d\2\2\u027d\u027e\7\22\2\2\u027e\u027f\5*\26\2"+
		"\u027f\u0283\7\23\2\2\u0280\u0282\7\u00b2\2\2\u0281\u0280\3\2\2\2\u0282"+
		"\u0285\3\2\2\2\u0283\u0281\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0286\3\2"+
		"\2\2\u0285\u0283\3\2\2\2\u0286\u0291\7\6\2\2\u0287\u0289\7\u00b2\2\2\u0288"+
		"\u0287\3\2\2\2\u0289\u028c\3\2\2\2\u028a\u0288\3\2\2\2\u028a\u028b\3\2"+
		"\2\2\u028b\u028d\3\2\2\2\u028c\u028a\3\2\2\2\u028d\u028e\7\u009e\2\2\u028e"+
		"\u028f\5,\27\2\u028f\u0290\7\u009f\2\2\u0290\u0292\3\2\2\2\u0291\u028a"+
		"\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0294\5\"\22\2"+
		"\u0294\u0295\7\7\2\2\u0295\u02fc\3\2\2\2\u0296\u0297\t!\2\2\u0297\u02a0"+
		"\7\22\2\2\u0298\u029d\5&\24\2\u0299\u029a\7\3\2\2\u029a\u029c\5&\24\2"+
		"\u029b\u0299\3\2\2\2\u029c\u029f\3\2\2\2\u029d\u029b\3\2\2\2\u029d\u029e"+
		"\3\2\2\2\u029e\u02a1\3\2\2\2\u029f\u029d\3\2\2\2\u02a0\u0298\3\2\2\2\u02a0"+
		"\u02a1\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02fc\7\23\2\2\u02a3\u02a4\7"+
		"\u00ae\2\2\u02a4\u02a5\7\22\2\2\u02a5\u02a6\5*\26\2\u02a6\u02a7\7\23\2"+
		"\2\u02a7\u02a9\7Q\2\2\u02a8\u02aa\7\u00b2\2\2\u02a9\u02a8\3\2\2\2\u02a9"+
		"\u02aa\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab\u02ac\5*\26\2\u02ac\u02fc\3\2"+
		"\2\2\u02ad\u02ae\7\u00a2\2\2\u02ae\u02b0\7\u00ae\2\2\u02af\u02ad\3\2\2"+
		"\2\u02af\u02b0\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u02b2\7\u0097\2\2\u02b2"+
		"\u02b4\7\u00ae\2\2\u02b3\u02b5\7\u00b2\2\2\u02b4\u02b3\3\2\2\2\u02b4\u02b5"+
		"\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02bf\7\22\2\2\u02b7\u02bc\5 \21\2"+
		"\u02b8\u02b9\7\3\2\2\u02b9\u02bb\5 \21\2\u02ba\u02b8\3\2\2\2\u02bb\u02be"+
		"\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02c0\3\2\2\2\u02be"+
		"\u02bc\3\2\2\2\u02bf\u02b7\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c1\3\2"+
		"\2\2\u02c1\u02c2\7\23\2\2\u02c2\u02c5\7\t\2\2\u02c3\u02c6\5\20\t\2\u02c4"+
		"\u02c6\7\u00a3\2\2\u02c5\u02c3\3\2\2\2\u02c5\u02c4\3\2\2\2\u02c6\u02c7"+
		"\3\2\2\2\u02c7\u02cb\7Q\2\2\u02c8\u02ca\7\u00b2\2\2\u02c9\u02c8\3\2\2"+
		"\2\u02ca\u02cd\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02ce"+
		"\3\2\2\2\u02cd\u02cb\3\2\2\2\u02ce\u02df\7\6\2\2\u02cf\u02d1\7\u00b2\2"+
		"\2\u02d0\u02cf\3\2\2\2\u02d1\u02d4\3\2\2\2\u02d2\u02d0\3\2\2\2\u02d2\u02d3"+
		"\3\2\2\2\u02d3\u02d5\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d5\u02d6\7\u009e\2"+
		"\2\u02d6\u02da\5\60\31\2\u02d7\u02d9\7\u00b2\2\2\u02d8\u02d7\3\2\2\2\u02d9"+
		"\u02dc\3\2\2\2\u02da\u02d8\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02dd\3\2"+
		"\2\2\u02dc\u02da\3\2\2\2\u02dd\u02de\7\u009f\2\2\u02de\u02e0\3\2\2\2\u02df"+
		"\u02d2\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02ec\5\""+
		"\22\2\u02e2\u02e4\7\u00a4\2\2\u02e3\u02e5\5*\26\2\u02e4\u02e3\3\2\2\2"+
		"\u02e4\u02e5\3\2\2\2\u02e5\u02e9\3\2\2\2\u02e6\u02e8\7\u00b2\2\2\u02e7"+
		"\u02e6\3\2\2\2\u02e8\u02eb\3\2\2\2\u02e9\u02e7\3\2\2\2\u02e9\u02ea\3\2"+
		"\2\2\u02ea\u02ed\3\2\2\2\u02eb\u02e9\3\2\2\2\u02ec\u02e2\3\2\2\2\u02ec"+
		"\u02ed\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee\u02ef\7\7\2\2\u02ef\u02fc\3\2"+
		"\2\2\u02f0\u02f5\7\u009e\2\2\u02f1\u02f6\5\6\4\2\u02f2\u02f6\5\4\3\2\u02f3"+
		"\u02f6\5\62\32\2\u02f4\u02f6\5\30\r\2\u02f5\u02f1\3\2\2\2\u02f5\u02f2"+
		"\3\2\2\2\u02f5\u02f3\3\2\2\2\u02f5\u02f4\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7"+
		"\u02f8\7\u009f\2\2\u02f8\u02fc\3\2\2\2\u02f9\u02fc\5\26\f\2\u02fa\u02fc"+
		"\5*\26\2\u02fb\u0248\3\2\2\2\u02fb\u0252\3\2\2\2\u02fb\u0258\3\2\2\2\u02fb"+
		"\u025d\3\2\2\2\u02fb\u0262\3\2\2\2\u02fb\u027c\3\2\2\2\u02fb\u0296\3\2"+
		"\2\2\u02fb\u02a3\3\2\2\2\u02fb\u02af\3\2\2\2\u02fb\u02f0\3\2\2\2\u02fb"+
		"\u02f9\3\2\2\2\u02fb\u02fa\3\2\2\2\u02fc%\3\2\2\2\u02fd\u0300\7\u00b6"+
		"\2\2\u02fe\u0300\5*\26\2\u02ff\u02fd\3\2\2\2\u02ff\u02fe\3\2\2\2\u0300"+
		"\'\3\2\2\2\u0301\u0318\t\3\2\2\u0302\u0318\7\u00ad\2\2\u0303\u0318\7\u00ae"+
		"\2\2\u0304\u0305\t\4\2\2\u0305\u0306\7\b\2\2\u0306\u0318\7\u00ae\2\2\u0307"+
		"\u0318\7\u00b7\2\2\u0308\u0318\7\u00b0\2\2\u0309\u0318\7\u00af\2\2\u030a"+
		"\u030b\t\5\2\2\u030b\u0314\7\22\2\2\u030c\u0311\5*\26\2\u030d\u030e\7"+
		"\3\2\2\u030e\u0310\5*\26\2\u030f\u030d\3\2\2\2\u0310\u0313\3\2\2\2\u0311"+
		"\u030f\3\2\2\2\u0311\u0312\3\2\2\2\u0312\u0315\3\2\2\2\u0313\u0311\3\2"+
		"\2\2\u0314\u030c\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0316\3\2\2\2\u0316"+
		"\u0318\7\23\2\2\u0317\u0301\3\2\2\2\u0317\u0302\3\2\2\2\u0317\u0303\3"+
		"\2\2\2\u0317\u0304\3\2\2\2\u0317\u0307\3\2\2\2\u0317\u0308\3\2\2\2\u0317"+
		"\u0309\3\2\2\2\u0317\u030a\3\2\2\2\u0318)\3\2\2\2\u0319\u031a\b\26\1\2"+
		"\u031a\u031b\t\"\2\2\u031b\u033f\5*\26\f\u031c\u031d\7\u00ae\2\2\u031d"+
		"\u0326\7\22\2\2\u031e\u0323\5*\26\2\u031f\u0320\7\3\2\2\u0320\u0322\5"+
		"*\26\2\u0321\u031f\3\2\2\2\u0322\u0325\3\2\2\2\u0323\u0321\3\2\2\2\u0323"+
		"\u0324\3\2\2\2\u0324\u0327\3\2\2\2\u0325\u0323\3\2\2\2\u0326\u031e\3\2"+
		"\2\2\u0326\u0327\3\2\2\2\u0327\u0328\3\2\2\2\u0328\u033f\7\23\2\2\u0329"+
		"\u032e\5(\25\2\u032a\u032b\7\b\2\2\u032b\u032d\7\u00ae\2\2\u032c\u032a"+
		"\3\2\2\2\u032d\u0330\3\2\2\2\u032e\u032c\3\2\2\2\u032e\u032f\3\2\2\2\u032f"+
		"\u033f\3\2\2\2\u0330\u032e\3\2\2\2\u0331\u0332\7\u00a5\2\2\u0332\u0333"+
		"\7\22\2\2\u0333\u033f\7\23\2\2\u0334\u0335\7\u00a6\2\2\u0335\u0337\7\22"+
		"\2\2\u0336\u0338\7\u00b6\2\2\u0337\u0336\3\2\2\2\u0337\u0338\3\2\2\2\u0338"+
		"\u0339\3\2\2\2\u0339\u033f\7\23\2\2\u033a\u033b\7\22\2\2\u033b\u033c\5"+
		"*\26\2\u033c\u033d\7\23\2\2\u033d\u033f\3\2\2\2\u033e\u0319\3\2\2\2\u033e"+
		"\u031c\3\2\2\2\u033e\u0329\3\2\2\2\u033e\u0331\3\2\2\2\u033e\u0334\3\2"+
		"\2\2\u033e\u033a\3\2\2\2\u033f\u0378\3\2\2\2\u0340\u0341\f\13\2\2\u0341"+
		"\u0343\t\7\2\2\u0342\u0344\7\u00b2\2\2\u0343\u0342\3\2\2\2\u0343\u0344"+
		"\3\2\2\2\u0344\u0345\3\2\2\2\u0345\u0377\5*\26\f\u0346\u0347\f\n\2\2\u0347"+
		"\u0349\t\b\2\2\u0348\u034a\7\u00b2\2\2\u0349\u0348\3\2\2\2\u0349\u034a"+
		"\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u0377\5*\26\13\u034c\u034d\f\t\2\2"+
		"\u034d\u034f\7F\2\2\u034e\u0350\7\u00b2\2\2\u034f\u034e\3\2\2\2\u034f"+
		"\u0350\3\2\2\2\u0350\u0351\3\2\2\2\u0351\u0377\5*\26\t\u0352\u0353\f\b"+
		"\2\2\u0353\u0355\7G\2\2\u0354\u0356\7\u00b2\2\2\u0355\u0354\3\2\2\2\u0355"+
		"\u0356\3\2\2\2\u0356\u0357\3\2\2\2\u0357\u0377\5*\26\t\u0358\u0359\f\7"+
		"\2\2\u0359\u035b\t#\2\2\u035a\u035c\7\u00b2\2\2\u035b\u035a\3\2\2\2\u035b"+
		"\u035c\3\2\2\2\u035c\u035d\3\2\2\2\u035d\u0377\5*\26\b\u035e\u035f\f\6"+
		"\2\2\u035f\u0361\t$\2\2\u0360\u0362\7\u00b2\2\2\u0361\u0360\3\2\2\2\u0361"+
		"\u0362\3\2\2\2\u0362\u0363\3\2\2\2\u0363\u0377\5*\26\7\u0364\u0365\f\5"+
		"\2\2\u0365\u0367\7[\2\2\u0366\u0368\7\u00b2\2\2\u0367\u0366\3\2\2\2\u0367"+
		"\u0368\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u0377\5*\26\6\u036a\u036b\f\4"+
		"\2\2\u036b\u036d\7_\2\2\u036c\u036e\7\u00b2\2\2\u036d\u036c\3\2\2\2\u036d"+
		"\u036e\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0377\5*\26\5\u0370\u0371\f\3"+
		"\2\2\u0371\u0373\7a\2\2\u0372\u0374\7\u00b2\2\2\u0373\u0372\3\2\2\2\u0373"+
		"\u0374\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u0377\5*\26\4\u0376\u0340\3\2"+
		"\2\2\u0376\u0346\3\2\2\2\u0376\u034c\3\2\2\2\u0376\u0352\3\2\2\2\u0376"+
		"\u0358\3\2\2\2\u0376\u035e\3\2\2\2\u0376\u0364\3\2\2\2\u0376\u036a\3\2"+
		"\2\2\u0376\u0370\3\2\2\2\u0377\u037a\3\2\2\2\u0378\u0376\3\2\2\2\u0378"+
		"\u0379\3\2\2\2\u0379+\3\2\2\2\u037a\u0378\3\2\2\2\u037b\u037f\7\6\2\2"+
		"\u037c\u037e\7\u00b2\2\2\u037d\u037c\3\2\2\2\u037e\u0381\3\2\2\2\u037f"+
		"\u037d\3\2\2\2\u037f\u0380\3\2\2\2\u0380\u0382\3\2\2\2\u0381\u037f\3\2"+
		"\2\2\u0382\u0383\5.\30\2\u0383\u0387\7\7\2\2\u0384\u0386\7\u00b2\2\2\u0385"+
		"\u0384\3\2\2\2\u0386\u0389\3\2\2\2\u0387\u0385\3\2\2\2\u0387\u0388\3\2"+
		"\2\2\u0388\u03b1\3\2\2\2\u0389\u0387\3\2\2\2\u038a\u038e\7\6\2\2\u038b"+
		"\u038d\7\u00b2\2\2\u038c\u038b\3\2\2\2\u038d\u0390\3\2\2\2\u038e\u038c"+
		"\3\2\2\2\u038e\u038f\3\2\2\2\u038f\u0391\3\2\2\2\u0390\u038e\3\2\2\2\u0391"+
		"\u0395\7\u0092\2\2\u0392\u0394\7\u00b2\2\2\u0393\u0392\3\2\2\2\u0394\u0397"+
		"\3\2\2\2\u0395\u0393\3\2\2\2\u0395\u0396\3\2\2\2\u0396\u0398\3\2\2\2\u0397"+
		"\u0395\3\2\2\2\u0398\u03a3\5\f\7\2\u0399\u039b\7\u00b2\2\2\u039a\u0399"+
		"\3\2\2\2\u039b\u039c\3\2\2\2\u039c\u039a\3\2\2\2\u039c\u039d\3\2\2\2\u039d"+
		"\u039f\3\2\2\2\u039e\u03a0\5\f\7\2\u039f\u039e\3\2\2\2\u039f\u03a0\3\2"+
		"\2\2\u03a0\u03a2\3\2\2\2\u03a1\u039a\3\2\2\2\u03a2\u03a5\3\2\2\2\u03a3"+
		"\u03a1\3\2\2\2\u03a3\u03a4\3\2\2\2\u03a4\u03a7\3\2\2\2\u03a5\u03a3\3\2"+
		"\2\2\u03a6\u03a8\5.\30\2\u03a7\u03a6\3\2\2\2\u03a7\u03a8\3\2\2\2\u03a8"+
		"\u03a9\3\2\2\2\u03a9\u03ad\7\7\2\2\u03aa\u03ac\7\u00b2\2\2\u03ab\u03aa"+
		"\3\2\2\2\u03ac\u03af\3\2\2\2\u03ad\u03ab\3\2\2\2\u03ad\u03ae\3\2\2\2\u03ae"+
		"\u03b1\3\2\2\2\u03af\u03ad\3\2\2\2\u03b0\u037b\3\2\2\2\u03b0\u038a\3\2"+
		"\2\2\u03b1-\3\2\2\2\u03b2\u03b3\7\u00a7\2\2\u03b3\u03b8\7\u00ae\2\2\u03b4"+
		"\u03b5\7\3\2\2\u03b5\u03b7\7\u00ae\2\2\u03b6\u03b4\3\2\2\2\u03b7\u03ba"+
		"\3\2\2\2\u03b8\u03b6\3\2\2\2\u03b8\u03b9\3\2\2\2\u03b9\u03be\3\2\2\2\u03ba"+
		"\u03b8\3\2\2\2\u03bb\u03bd\7\u00b2\2\2\u03bc\u03bb\3\2\2\2\u03bd\u03c0"+
		"\3\2\2\2\u03be\u03bc\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf/\3\2\2\2\u03c0"+
		"\u03be\3\2\2\2\u03c1\u03c5\7\6\2\2\u03c2\u03c4\7\u00b2\2\2\u03c3\u03c2"+
		"\3\2\2\2\u03c4\u03c7\3\2\2\2\u03c5\u03c3\3\2\2\2\u03c5\u03c6\3\2\2\2\u03c6"+
		"\u03dd\3\2\2\2\u03c7\u03c5\3\2\2\2\u03c8\u03cc\t%\2\2\u03c9\u03cb\7\u00b2"+
		"\2\2\u03ca\u03c9\3\2\2\2\u03cb\u03ce\3\2\2\2\u03cc\u03ca\3\2\2\2\u03cc"+
		"\u03cd\3\2\2\2\u03cd\u03cf\3\2\2\2\u03ce\u03cc\3\2\2\2\u03cf\u03da\5\f"+
		"\7\2\u03d0\u03d2\7\u00b2\2\2\u03d1\u03d0\3\2\2\2\u03d2\u03d3\3\2\2\2\u03d3"+
		"\u03d1\3\2\2\2\u03d3\u03d4\3\2\2\2\u03d4\u03d6\3\2\2\2\u03d5\u03d7\5\f"+
		"\7\2\u03d6\u03d5\3\2\2\2\u03d6\u03d7\3\2\2\2\u03d7\u03d9\3\2\2\2\u03d8"+
		"\u03d1\3\2\2\2\u03d9\u03dc\3\2\2\2\u03da\u03d8\3\2\2\2\u03da\u03db\3\2"+
		"\2\2\u03db\u03de\3\2\2\2\u03dc\u03da\3\2\2\2\u03dd\u03c8\3\2\2\2\u03dd"+
		"\u03de\3\2\2\2\u03de\u03e2\3\2\2\2\u03df\u03e1\7\u00b2\2\2\u03e0\u03df"+
		"\3\2\2\2\u03e1\u03e4\3\2\2\2\u03e2\u03e0\3\2\2\2\u03e2\u03e3\3\2\2\2\u03e3"+
		"\u03e6\3\2\2\2\u03e4\u03e2\3\2\2\2\u03e5\u03e7\5.\30\2\u03e6\u03e5\3\2"+
		"\2\2\u03e6\u03e7\3\2\2\2\u03e7\u03fd\3\2\2\2\u03e8\u03ec\t&\2\2\u03e9"+
		"\u03eb\7\u00b2\2\2\u03ea\u03e9\3\2\2\2\u03eb\u03ee\3\2\2\2\u03ec\u03ea"+
		"\3\2\2\2\u03ec\u03ed\3\2\2\2\u03ed\u03ef\3\2\2\2\u03ee\u03ec\3\2\2\2\u03ef"+
		"\u03fa\5\f\7\2\u03f0\u03f2\7\u00b2\2\2\u03f1\u03f0\3\2\2\2\u03f2\u03f3"+
		"\3\2\2\2\u03f3\u03f1\3\2\2\2\u03f3\u03f4\3\2\2\2\u03f4\u03f6\3\2\2\2\u03f5"+
		"\u03f7\5\f\7\2\u03f6\u03f5\3\2\2\2\u03f6\u03f7\3\2\2\2\u03f7\u03f9\3\2"+
		"\2\2\u03f8\u03f1\3\2\2\2\u03f9\u03fc\3\2\2\2\u03fa\u03f8\3\2\2\2\u03fa"+
		"\u03fb\3\2\2\2\u03fb\u03fe\3\2\2\2\u03fc\u03fa\3\2\2\2\u03fd\u03e8\3\2"+
		"\2\2\u03fd\u03fe\3\2\2\2\u03fe\u0402\3\2\2\2\u03ff\u0401\7\u00b2\2\2\u0400"+
		"\u03ff\3\2\2\2\u0401\u0404\3\2\2\2\u0402\u0400\3\2\2\2\u0402\u0403\3\2"+
		"\2\2\u0403\u0405\3\2\2\2\u0404\u0402\3\2\2\2\u0405\u0409\7\7\2\2\u0406"+
		"\u0408\7\u00b2\2\2\u0407\u0406\3\2\2\2\u0408\u040b\3\2\2\2\u0409\u0407"+
		"\3\2\2\2\u0409\u040a\3\2\2\2\u040a\61\3\2\2\2\u040b\u0409\3\2\2\2\u040c"+
		"\u0410\7\6\2\2\u040d\u040f\7\u00b2\2\2\u040e\u040d\3\2\2\2\u040f\u0412"+
		"\3\2\2\2\u0410\u040e\3\2\2\2\u0410\u0411\3\2\2\2\u0411\u0413\3\2\2\2\u0412"+
		"\u0410\3\2\2\2\u0413\u0417\7\u0092\2\2\u0414\u0416\7\u00b2\2\2\u0415\u0414"+
		"\3\2\2\2\u0416\u0419\3\2\2\2\u0417\u0415\3\2\2\2\u0417\u0418\3\2\2\2\u0418"+
		"\u041a\3\2\2\2\u0419\u0417\3\2\2\2\u041a\u0425\5\f\7\2\u041b\u041d\7\u00b2"+
		"\2\2\u041c\u041b\3\2\2\2\u041d\u041e\3\2\2\2\u041e\u041c\3\2\2\2\u041e"+
		"\u041f\3\2\2\2\u041f\u0421\3\2\2\2\u0420\u0422\5\f\7\2\u0421\u0420\3\2"+
		"\2\2\u0421\u0422\3\2\2\2\u0422\u0424\3\2\2\2\u0423\u041c\3\2\2\2\u0424"+
		"\u0427\3\2\2\2\u0425\u0423\3\2\2\2\u0425\u0426\3\2\2\2\u0426\u0428\3\2"+
		"\2\2\u0427\u0425\3\2\2\2\u0428\u042c\7\7\2\2\u0429\u042b\7\u00b2\2\2\u042a"+
		"\u0429\3\2\2\2\u042b\u042e\3\2\2\2\u042c\u042a\3\2\2\2\u042c\u042d\3\2"+
		"\2\2\u042d\63\3\2\2\2\u042e\u042c\3\2\2\2\u009b8<AIPS[ahjnsvz\u0081\u008e"+
		"\u0095\u009d\u00a5\u00aa\u00af\u00b2\u00b6\u00ba\u00c9\u00dd\u00e0\u00e3"+
		"\u00ef\u00f3\u00f8\u00fe\u0104\u010a\u0110\u0116\u011c\u0122\u0128\u012e"+
		"\u0131\u0133\u013c\u0145\u0149\u014e\u0151\u015b\u0162\u0168\u016e\u0192"+
		"\u01a1\u01ab\u01b8\u01bf\u01cb\u01d9\u01dc\u01e1\u01e8\u01ec\u01fb\u0202"+
		"\u0209\u020c\u0210\u0217\u021c\u0225\u022d\u0239\u023e\u0241\u0245\u024e"+
		"\u0255\u0269\u0273\u027a\u0283\u028a\u0291\u029d\u02a0\u02a9\u02af\u02b4"+
		"\u02bc\u02bf\u02c5\u02cb\u02d2\u02da\u02df\u02e4\u02e9\u02ec\u02f5\u02fb"+
		"\u02ff\u0311\u0314\u0317\u0323\u0326\u032e\u0337\u033e\u0343\u0349\u034f"+
		"\u0355\u035b\u0361\u0367\u036d\u0373\u0376\u0378\u037f\u0387\u038e\u0395"+
		"\u039c\u039f\u03a3\u03a7\u03ad\u03b0\u03b8\u03be\u03c5\u03cc\u03d3\u03d6"+
		"\u03da\u03dd\u03e2\u03e6\u03ec\u03f3\u03f6\u03fa\u03fd\u0402\u0409\u0410"+
		"\u0417\u041e\u0421\u0425\u042c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}