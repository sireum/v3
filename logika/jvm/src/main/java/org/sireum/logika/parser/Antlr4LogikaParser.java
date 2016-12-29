// Generated from /Users/robby/Repositories/Sireum/sireum-v3/logika/jvm/src/main/resources/org/sireum/logika/parser/Antlr4Logika.g4 by ANTLR 4.6
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
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

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
		T__167=168, T__168=169, T__169=170, T__170=171, HLINE=172, NUM=173, ID=174, 
		REAL=175, INT=176, RESERVED=177, NL=178, LINE_COMMENT=179, COMMENT=180, 
		TAB=181, WS=182, STRING=183, FLOAT=184, ERROR_CHAR=185;
	public static final int
		RULE_file = 0, RULE_truthTable = 1, RULE_row = 2, RULE_bool = 3, RULE_status = 4, 
		RULE_assignments = 5, RULE_sequent = 6, RULE_proof = 7, RULE_proofStep = 8, 
		RULE_primFormula = 9, RULE_formula = 10, RULE_qformula = 11, RULE_type = 12, 
		RULE_justification = 13, RULE_program = 14, RULE_impor = 15, RULE_facts = 16, 
		RULE_factOrFun = 17, RULE_fact = 18, RULE_fun = 19, RULE_funDef = 20, 
		RULE_param = 21, RULE_stmts = 22, RULE_stmt = 23, RULE_blockEnd = 24, 
		RULE_returnStmt = 25, RULE_stringOrExp = 26, RULE_primExp = 27, RULE_exp = 28, 
		RULE_loopInvariant = 29, RULE_modifies = 30, RULE_methodContract = 31, 
		RULE_invariants = 32;
	public static final String[] ruleNames = {
		"file", "truthTable", "row", "bool", "status", "assignments", "sequent", 
		"proof", "proofStep", "primFormula", "formula", "qformula", "type", "justification", 
		"program", "impor", "facts", "factOrFun", "fact", "fun", "funDef", "param", 
		"stmts", "stmt", "blockEnd", "returnStmt", "stringOrExp", "primExp", "exp", 
		"loopInvariant", "modifies", "methodContract", "invariants"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'*'", "'|'", "'T'", "'⊤'", "'F'", "'⊥'", "'-'", "':'", "'['", "']'", 
		"','", "'|-'", "'⊢'", "'{'", "'}'", "'.'", "'assume'", "'true'", "'false'", 
		"'_|_'", "'('", "')'", "'result'", "'B'", "'Z'", "'Z8'", "'Z16'", "'Z32'", 
		"'Z64'", "'N'", "'N8'", "'N16'", "'N32'", "'N64'", "'S8'", "'S16'", "'S32'", 
		"'S64'", "'U8'", "'U16'", "'U32'", "'U64'", "'R'", "'F32'", "'F64'", "'BS'", 
		"'ZS'", "'Z8S'", "'Z16S'", "'Z32S'", "'Z64S'", "'NS'", "'N8S'", "'N16S'", 
		"'N32S'", "'N64S'", "'S8S'", "'S16S'", "'S32S'", "'S64S'", "'U8S'", "'U16S'", 
		"'U32S'", "'U64S'", "'RS'", "'F32S'", "'F64S'", "'/'", "'%'", "'+'", "'+:'", 
		"':+'", "'<'", "'<='", "'≤'", "'>'", "'>='", "'≥'", "'>>'", "'>>>'", "'<<'", 
		"'='", "'=='", "'!='", "'≠'", "'not'", "'neg'", "'!'", "'~'", "'¬'", "'and'", 
		"'&'", "'^'", "'∧'", "'xor'", "'^|'", "'or'", "'V'", "'∨'", "'implies'", 
		"'->'", "'→'", "'forall'", "'all'", "'A'", "'∀'", "'exists'", "'some'", 
		"'E'", "'∃'", "'..'", "'premise'", "'andi'", "'ande1'", "'ande2'", "'ori1'", 
		"'Vi1'", "'ori2'", "'Vi2'", "'ore'", "'Ve'", "'impliesi'", "'impliese'", 
		"'noti'", "'negi'", "'note'", "'nege'", "'bottome'", "'falsee'", "'pbc'", 
		"'subst1'", "'subst2'", "'algebra'", "'foralli'", "'alli'", "'Ai'", "'foralle'", 
		"'alle'", "'Ae'", "'existsi'", "'somei'", "'Ei'", "'existse'", "'somee'", 
		"'Ee'", "'invariant'", "'fact'", "'auto'", "'import'", "'_'", "'def'", 
		"'if'", "'var'", "'val'", "'assert'", "'else'", "'while'", "'l\"\"\"'", 
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
		null, null, null, null, "HLINE", "NUM", "ID", "REAL", "INT", "RESERVED", 
		"NL", "LINE_COMMENT", "COMMENT", "TAB", "WS", "STRING", "FLOAT", "ERROR_CHAR"
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
	public static class TruthTableFileContext extends FileContext {
		public TruthTableContext truthTable() {
			return getRuleContext(TruthTableContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Antlr4LogikaParser.EOF, 0); }
		public TruthTableFileContext(FileContext ctx) { copyFrom(ctx); }
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
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new TruthTableFileContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				truthTable();
				setState(67);
				match(EOF);
				}
				break;
			case 2:
				_localctx = new SequentFileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(69);
					match(NL);
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(75);
				sequent();
				setState(79);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(76);
						match(NL);
						}
						} 
					}
					setState(81);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(82);
					proof();
					}
				}

				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(85);
					match(NL);
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(91);
				match(EOF);
				}
				break;
			case 3:
				_localctx = new ProgramFileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				program();
				setState(94);
				match(EOF);
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

	public static class TruthTableContext extends ParserRuleContext {
		public Token star;
		public Token ID;
		public List<Token> vars = new ArrayList<Token>();
		public Token bar;
		public List<TerminalNode> HLINE() { return getTokens(Antlr4LogikaParser.HLINE); }
		public TerminalNode HLINE(int i) {
			return getToken(Antlr4LogikaParser.HLINE, i);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public List<RowContext> row() {
			return getRuleContexts(RowContext.class);
		}
		public RowContext row(int i) {
			return getRuleContext(RowContext.class,i);
		}
		public StatusContext status() {
			return getRuleContext(StatusContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public TruthTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_truthTable; }
	}

	public final TruthTableContext truthTable() throws RecognitionException {
		TruthTableContext _localctx = new TruthTableContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_truthTable);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(98);
				match(NL);
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			((TruthTableContext)_localctx).star = match(T__0);
			setState(106); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(105);
				match(NL);
				}
				}
				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(110);
			match(HLINE);
			setState(112); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(111);
				match(NL);
				}
				}
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(116);
				((TruthTableContext)_localctx).ID = match(ID);
				((TruthTableContext)_localctx).vars.add(((TruthTableContext)_localctx).ID);
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(121);
			((TruthTableContext)_localctx).bar = match(T__1);
			setState(122);
			formula(0);
			setState(124); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(123);
				match(NL);
				}
				}
				setState(126); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(128);
			match(HLINE);
			setState(137);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(130); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(129);
						match(NL);
						}
						}
						setState(132); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NL );
					setState(134);
					row();
					}
					} 
				}
				setState(139);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(141); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(140);
				match(NL);
				}
				}
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(145);
			match(HLINE);
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(147); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(146);
					match(NL);
					}
					}
					setState(149); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NL );
				setState(151);
				status();
				}
				break;
			}
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(154);
				match(NL);
				}
				}
				setState(159);
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

	public static class RowContext extends ParserRuleContext {
		public BoolContext bool;
		public List<BoolContext> model = new ArrayList<BoolContext>();
		public Token bar;
		public List<BoolContext> eval = new ArrayList<BoolContext>();
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_row);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) {
				{
				{
				setState(160);
				((RowContext)_localctx).bool = bool();
				((RowContext)_localctx).model.add(((RowContext)_localctx).bool);
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(166);
			((RowContext)_localctx).bar = match(T__1);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) {
				{
				{
				setState(167);
				((RowContext)_localctx).bool = bool();
				((RowContext)_localctx).eval.add(((RowContext)_localctx).bool);
				}
				}
				setState(172);
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

	public static class BoolContext extends ParserRuleContext {
		public Token t;
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			((BoolContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) ) {
				((BoolContext)_localctx).t = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class StatusContext extends ParserRuleContext {
		public Token t;
		public AssignmentsContext assignments;
		public List<AssignmentsContext> tContingentAssignments = new ArrayList<AssignmentsContext>();
		public List<AssignmentsContext> fContingentAssignments = new ArrayList<AssignmentsContext>();
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public List<AssignmentsContext> assignments() {
			return getRuleContexts(AssignmentsContext.class);
		}
		public AssignmentsContext assignments(int i) {
			return getRuleContext(AssignmentsContext.class,i);
		}
		public StatusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_status; }
	}

	public final StatusContext status() throws RecognitionException {
		StatusContext _localctx = new StatusContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_status);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(ID);
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(176);
					match(NL);
					}
					}
					setState(179); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NL );
				setState(181);
				((StatusContext)_localctx).t = match(T__6);
				setState(182);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__3) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(183);
				match(T__7);
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(187);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(184);
							match(NL);
							}
							}
							setState(189);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(190);
						((StatusContext)_localctx).assignments = assignments();
						((StatusContext)_localctx).tContingentAssignments.add(((StatusContext)_localctx).assignments);
						}
						} 
					}
					setState(195);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(197); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(196);
					match(NL);
					}
					}
					setState(199); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NL );
				setState(201);
				match(T__6);
				setState(202);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(203);
				match(T__7);
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(207);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(204);
							match(NL);
							}
							}
							setState(209);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(210);
						((StatusContext)_localctx).assignments = assignments();
						((StatusContext)_localctx).fContingentAssignments.add(((StatusContext)_localctx).assignments);
						}
						} 
					}
					setState(215);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class AssignmentsContext extends ParserRuleContext {
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public AssignmentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignments; }
	}

	public final AssignmentsContext assignments() throws RecognitionException {
		AssignmentsContext _localctx = new AssignmentsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(T__8);
			setState(220); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(219);
				bool();
				}
				}
				setState(222); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0) );
			setState(224);
			match(T__9);
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
		enterRule(_localctx, 12, RULE_sequent);
		int _la;
		try {
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
					{
					setState(226);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(227);
						match(T__10);
						setState(228);
						((SequentContext)_localctx).formula = formula(0);
						((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
						}
						}
						setState(233);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(236);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__12) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(237);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(238);
					match(T__10);
					setState(239);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
					{
					{
					setState(245);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(250);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(251);
				match(HLINE);
				setState(253); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(252);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(255); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0) );
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
		enterRule(_localctx, 14, RULE_proof);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			((ProofContext)_localctx).tb = match(T__13);
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(260);
				proofStep();
				}
			}

			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(264); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(263);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(266); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(268);
					proofStep();
					}
				}

				}
				}
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(276);
			((ProofContext)_localctx).te = match(T__14);
			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(277);
					match(NL);
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
		enterRule(_localctx, 16, RULE_proofStep);
		int _la;
		try {
			int _alt;
			setState(337);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				match(NUM);
				setState(284);
				match(T__15);
				setState(285);
				formula(0);
				setState(286);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(289);
				match(T__15);
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(290);
					match(NL);
					}
					}
					setState(295);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(296);
				match(T__13);
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(297);
					match(NL);
					}
					}
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(303);
				((SubProofContext)_localctx).assume = match(NUM);
				setState(304);
				match(T__15);
				setState(321);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(305);
					match(ID);
					setState(308);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__7) {
						{
						setState(306);
						match(T__7);
						setState(307);
						type();
						}
					}

					}
					break;
				case 2:
					{
					setState(310);
					formula(0);
					setState(311);
					((SubProofContext)_localctx).ate = match(T__16);
					}
					break;
				case 3:
					{
					setState(313);
					match(ID);
					setState(316);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__7) {
						{
						setState(314);
						match(T__7);
						setState(315);
						type();
						}
					}

					setState(318);
					formula(0);
					setState(319);
					((SubProofContext)_localctx).ate = match(T__16);
					}
					break;
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(324); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(323);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(326); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(329);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NUM) {
						{
						setState(328);
						proofStep();
						}
					}

					}
					}
					setState(335);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(336);
				match(T__14);
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
	public static class ApplyResultContext extends PrimFormulaContext {
		public Token tb;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ApplyResultContext(PrimFormulaContext ctx) { copyFrom(ctx); }
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
		enterRule(_localctx, 18, RULE_primFormula);
		int _la;
		try {
			setState(390);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				((BooleanContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
					((BooleanContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				_localctx = new ParenContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(340);
				match(T__20);
				setState(341);
				formula(0);
				setState(342);
				match(T__21);
				}
				break;
			case 3:
				_localctx = new ApplyResultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(344);
				((ApplyResultContext)_localctx).tb = match(T__22);
				setState(345);
				match(T__20);
				setState(346);
				formula(0);
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(347);
					match(T__10);
					setState(348);
					formula(0);
					}
					}
					setState(353);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(354);
				match(T__21);
				}
				break;
			case 4:
				_localctx = new ResultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(356);
				match(T__22);
				}
				break;
			case 5:
				_localctx = new ApplyContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(357);
				match(ID);
				setState(358);
				match(T__20);
				setState(359);
				formula(0);
				setState(364);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(360);
					match(T__10);
					setState(361);
					formula(0);
					}
					}
					setState(366);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(367);
				match(T__21);
				}
				break;
			case 6:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(369);
				((VarContext)_localctx).tb = match(ID);
				}
				break;
			case 7:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(370);
				match(NUM);
				}
				break;
			case 8:
				_localctx = new IntLitContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(371);
				match(INT);
				}
				break;
			case 9:
				_localctx = new RLitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(372);
				match(REAL);
				}
				break;
			case 10:
				_localctx = new FloatLitContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(373);
				match(FLOAT);
				}
				break;
			case 11:
				_localctx = new TypeAccessContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(374);
				((TypeAccessContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0)) ) {
					((TypeAccessContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(375);
				match(T__15);
				setState(376);
				match(ID);
				}
				break;
			case 12:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(377);
				((SeqContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (T__45 - 46)) | (1L << (T__46 - 46)) | (1L << (T__47 - 46)) | (1L << (T__48 - 46)) | (1L << (T__49 - 46)) | (1L << (T__50 - 46)) | (1L << (T__51 - 46)) | (1L << (T__52 - 46)) | (1L << (T__53 - 46)) | (1L << (T__54 - 46)) | (1L << (T__55 - 46)) | (1L << (T__56 - 46)) | (1L << (T__57 - 46)) | (1L << (T__58 - 46)) | (1L << (T__59 - 46)) | (1L << (T__60 - 46)) | (1L << (T__61 - 46)) | (1L << (T__62 - 46)) | (1L << (T__63 - 46)) | (1L << (T__64 - 46)) | (1L << (T__65 - 46)) | (1L << (T__66 - 46)))) != 0)) ) {
					((SeqContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(378);
				match(T__20);
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(379);
					exp(0);
					setState(384);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(380);
						match(T__10);
						setState(381);
						exp(0);
						}
						}
						setState(386);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(389);
				match(T__21);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
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
			case T__62:
			case T__63:
			case T__64:
			case T__65:
			case T__66:
			case NUM:
			case ID:
			case REAL:
			case INT:
			case FLOAT:
				{
				_localctx = new PFormulaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(393);
				primFormula();
				setState(398);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(394);
						match(T__15);
						setState(395);
						match(ID);
						}
						} 
					}
					setState(400);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
				}
				}
				break;
			case T__6:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(401);
				((UnaryContext)_localctx).op = match(T__6);
				setState(402);
				formula(7);
				}
				break;
			case T__85:
			case T__86:
			case T__87:
			case T__88:
			case T__89:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(403);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__87 - 86)) | (1L << (T__88 - 86)) | (1L << (T__89 - 86)))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(404);
				formula(6);
				}
				break;
			case T__102:
			case T__103:
			case T__104:
			case T__105:
			case T__106:
			case T__107:
			case T__108:
			case T__109:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(405);
				qformula();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(470);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(468);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(408);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(409);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__67 || _la==T__68) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(411);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(410);
							match(NL);
							}
						}

						setState(413);
						((BinaryContext)_localctx).r = formula(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(414);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(415);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__69) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(417);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(416);
							match(NL);
							}
						}

						setState(419);
						((BinaryContext)_localctx).r = formula(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(420);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(421);
						((BinaryContext)_localctx).op = match(T__70);
						setState(423);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(422);
							match(NL);
							}
						}

						setState(425);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(426);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(427);
						((BinaryContext)_localctx).op = match(T__71);
						setState(429);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(428);
							match(NL);
							}
						}

						setState(431);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(432);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(433);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__74 - 73)) | (1L << (T__75 - 73)) | (1L << (T__76 - 73)) | (1L << (T__77 - 73)) | (1L << (T__78 - 73)) | (1L << (T__79 - 73)) | (1L << (T__80 - 73)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(435);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(434);
							match(NL);
							}
						}

						setState(437);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(438);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(439);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (T__81 - 82)) | (1L << (T__82 - 82)) | (1L << (T__83 - 82)) | (1L << (T__84 - 82)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(441);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(440);
							match(NL);
							}
						}

						setState(443);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(444);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(445);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (T__90 - 91)) | (1L << (T__91 - 91)) | (1L << (T__92 - 91)) | (1L << (T__93 - 91)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(447);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(446);
							match(NL);
							}
						}

						setState(449);
						((BinaryContext)_localctx).r = formula(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(450);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(451);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__94 || _la==T__95) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(453);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(452);
							match(NL);
							}
						}

						setState(455);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(456);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(457);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__1 || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (T__96 - 97)) | (1L << (T__97 - 97)) | (1L << (T__98 - 97)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(459);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(458);
							match(NL);
							}
						}

						setState(461);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 10:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(462);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(463);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (T__99 - 100)) | (1L << (T__100 - 100)) | (1L << (T__101 - 100)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(465);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(464);
							match(NL);
							}
						}

						setState(467);
						((BinaryContext)_localctx).r = formula(2);
						}
						break;
					}
					} 
				}
				setState(472);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
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
		public FormulaContext lo;
		public Token ll;
		public Token lh;
		public FormulaContext hi;
		public FormulaContext qf;
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public QformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qformula; }
	}

	public final QformulaContext qformula() throws RecognitionException {
		QformulaContext _localctx = new QformulaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_qformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (T__102 - 103)) | (1L << (T__103 - 103)) | (1L << (T__104 - 103)) | (1L << (T__105 - 103)) | (1L << (T__106 - 103)) | (1L << (T__107 - 103)) | (1L << (T__108 - 103)) | (1L << (T__109 - 103)))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(474);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(475);
				match(T__10);
				setState(476);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(497);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(482);
				match(T__7);
				setState(483);
				type();
				}
				break;
			case 2:
				{
				setState(484);
				match(T__7);
				setState(485);
				match(T__20);
				setState(486);
				((QformulaContext)_localctx).lo = formula(0);
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__72) {
					{
					setState(487);
					((QformulaContext)_localctx).ll = match(T__72);
					}
				}

				setState(490);
				match(T__110);
				setState(492);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__72) {
					{
					setState(491);
					((QformulaContext)_localctx).lh = match(T__72);
					}
				}

				setState(494);
				((QformulaContext)_localctx).hi = formula(0);
				setState(495);
				match(T__21);
				}
				break;
			}
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(499);
				match(NL);
				}
			}

			setState(502);
			((QformulaContext)_localctx).qf = formula(0);
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
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			((TypeContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & ((1L << (T__23 - 24)) | (1L << (T__24 - 24)) | (1L << (T__25 - 24)) | (1L << (T__26 - 24)) | (1L << (T__27 - 24)) | (1L << (T__28 - 24)) | (1L << (T__29 - 24)) | (1L << (T__30 - 24)) | (1L << (T__31 - 24)) | (1L << (T__32 - 24)) | (1L << (T__33 - 24)) | (1L << (T__34 - 24)) | (1L << (T__35 - 24)) | (1L << (T__36 - 24)) | (1L << (T__37 - 24)) | (1L << (T__38 - 24)) | (1L << (T__39 - 24)) | (1L << (T__40 - 24)) | (1L << (T__41 - 24)) | (1L << (T__42 - 24)) | (1L << (T__43 - 24)) | (1L << (T__44 - 24)) | (1L << (T__45 - 24)) | (1L << (T__46 - 24)) | (1L << (T__47 - 24)) | (1L << (T__48 - 24)) | (1L << (T__49 - 24)) | (1L << (T__50 - 24)) | (1L << (T__51 - 24)) | (1L << (T__52 - 24)) | (1L << (T__53 - 24)) | (1L << (T__54 - 24)) | (1L << (T__55 - 24)) | (1L << (T__56 - 24)) | (1L << (T__57 - 24)) | (1L << (T__58 - 24)) | (1L << (T__59 - 24)) | (1L << (T__60 - 24)) | (1L << (T__61 - 24)) | (1L << (T__62 - 24)) | (1L << (T__63 - 24)) | (1L << (T__64 - 24)) | (1L << (T__65 - 24)) | (1L << (T__66 - 24)))) != 0)) ) {
				((TypeContext)_localctx).t = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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
		enterRule(_localctx, 26, RULE_justification);
		int _la;
		try {
			setState(639);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(506);
				((PremiseContext)_localctx).t = match(T__111);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(510);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__112:
					{
					setState(507);
					((AndIntroContext)_localctx).tb = match(T__112);
					}
					break;
				case T__91:
				case T__92:
				case T__93:
					{
					setState(508);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (T__91 - 92)) | (1L << (T__92 - 92)) | (1L << (T__93 - 92)))) != 0)) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(509);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(512);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(513);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(517);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__113:
				case T__114:
					{
					setState(514);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__113 || _la==T__114) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				case T__91:
				case T__92:
				case T__93:
					{
					setState(515);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (T__91 - 92)) | (1L << (T__92 - 92)) | (1L << (T__93 - 92)))) != 0)) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(516);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(519);
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(523);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__115:
				case T__116:
				case T__117:
				case T__118:
					{
					setState(520);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & ((1L << (T__115 - 116)) | (1L << (T__116 - 116)) | (1L << (T__117 - 116)) | (1L << (T__118 - 116)))) != 0)) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				case T__1:
				case T__98:
					{
					setState(521);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__1 || _la==T__98) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(522);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(525);
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(529);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__119:
				case T__120:
					{
					setState(526);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__119 || _la==T__120) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				case T__1:
				case T__98:
					{
					setState(527);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__1 || _la==T__98) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(528);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(531);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(532);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(533);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(534);
				((ImpliesIntroContext)_localctx).tb = match(T__121);
				setState(535);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(536);
				((ImpliesElimContext)_localctx).tb = match(T__122);
				setState(537);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(538);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(539);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(540);
				((ImpliesIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__100 || _la==T__101) ) {
					((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(541);
				match(ID);
				setState(542);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(543);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				      "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n      \"e\".equals(_input.LT(2).getText())");
				setState(544);
				((ImpliesElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__100 || _la==T__101) ) {
					((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(545);
				match(ID);
				setState(546);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(547);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(548);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__123 || _la==T__124) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(549);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 11:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(550);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__125 || _la==T__126) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(551);
				((NegElimContext)_localctx).step = match(NUM);
				setState(552);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 12:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(553);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(554);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (T__87 - 88)) | (1L << (T__88 - 88)) | (1L << (T__89 - 88)))) != 0)) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(555);
				match(ID);
				setState(556);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(557);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(558);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (T__87 - 88)) | (1L << (T__88 - 88)) | (1L << (T__89 - 88)))) != 0)) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(559);
				match(ID);
				setState(560);
				((NegElimContext)_localctx).step = match(NUM);
				setState(561);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 14:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(565);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__127:
				case T__128:
					{
					setState(562);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__127 || _la==T__128) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				case T__5:
				case T__19:
					{
					setState(563);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__5 || _la==T__19) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(564);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(567);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 15:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(568);
				((PbcContext)_localctx).tb = match(T__129);
				setState(569);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 16:
				_localctx = new Subst1Context(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(570);
				((Subst1Context)_localctx).tb = match(T__130);
				setState(571);
				((Subst1Context)_localctx).eqStep = match(NUM);
				setState(572);
				((Subst1Context)_localctx).step = match(NUM);
				}
				break;
			case 17:
				_localctx = new Subst2Context(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(573);
				((Subst2Context)_localctx).tb = match(T__131);
				setState(574);
				((Subst2Context)_localctx).eqStep = match(NUM);
				setState(575);
				((Subst2Context)_localctx).step = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(576);
				((AlgebraContext)_localctx).tb = match(T__132);
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(577);
					((AlgebraContext)_localctx).NUM = match(NUM);
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).NUM);
					}
					}
					setState(582);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(583);
				((ForallIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (T__133 - 134)) | (1L << (T__134 - 134)) | (1L << (T__135 - 134)))) != 0)) ) {
					((ForallIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(584);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 20:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(585);
				((ForallElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (T__136 - 137)) | (1L << (T__137 - 137)) | (1L << (T__138 - 137)))) != 0)) ) {
					((ForallElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(586);
				((ForallElimContext)_localctx).step = match(NUM);
				setState(588); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(587);
					formula(0);
					}
					}
					setState(590); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0) );
				}
				break;
			case 21:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(592);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(593);
				((ForallIntroContext)_localctx).tb = match(T__105);
				setState(594);
				match(ID);
				setState(595);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 22:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(596);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(597);
				((ForallElimContext)_localctx).tb = match(T__105);
				setState(598);
				match(ID);
				setState(599);
				((ForallElimContext)_localctx).step = match(NUM);
				setState(601); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(600);
					formula(0);
					}
					}
					setState(603); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0) );
				}
				break;
			case 23:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(605);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 140)) & ~0x3f) == 0 && ((1L << (_la - 140)) & ((1L << (T__139 - 140)) | (1L << (T__140 - 140)) | (1L << (T__141 - 140)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(606);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(608); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(607);
					formula(0);
					}
					}
					setState(610); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0) );
				}
				break;
			case 24:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(612);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & ((1L << (T__142 - 143)) | (1L << (T__143 - 143)) | (1L << (T__144 - 143)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(613);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(614);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 25:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(615);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(616);
				((ExistsIntroContext)_localctx).tb = match(T__109);
				setState(617);
				match(ID);
				setState(618);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(620); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(619);
					formula(0);
					}
					}
					setState(622); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0) );
				}
				break;
			case 26:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(624);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(625);
				((ExistsElimContext)_localctx).tb = match(T__109);
				setState(626);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(627);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(628);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 27:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(629);
				((InvariantContext)_localctx).tb = match(T__145);
				}
				break;
			case 28:
				_localctx = new FctContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(630);
				((FctContext)_localctx).tb = match(T__146);
				setState(631);
				match(ID);
				}
				break;
			case 29:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(632);
				((AutoContext)_localctx).tb = match(T__147);
				setState(636);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(633);
					((AutoContext)_localctx).NUM = match(NUM);
					((AutoContext)_localctx).steps.add(((AutoContext)_localctx).NUM);
					}
					}
					setState(638);
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
		enterRule(_localctx, 28, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(644);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(641);
				match(NL);
				}
				}
				setState(646);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(655);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__148) {
				{
				setState(647);
				impor();
				setState(649); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(648);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(651); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(653);
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
		enterRule(_localctx, 30, RULE_impor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			((ImporContext)_localctx).tb = match(T__148);
			setState(658);
			((ImporContext)_localctx).org = match(ID);
			setState(659);
			match(T__15);
			setState(660);
			((ImporContext)_localctx).sireum = match(ID);
			setState(661);
			match(T__15);
			setState(662);
			((ImporContext)_localctx).logika = match(ID);
			setState(663);
			match(T__15);
			setState(664);
			((ImporContext)_localctx).te = match(T__149);
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
		enterRule(_localctx, 32, RULE_facts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			match(T__13);
			setState(670);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(667);
				match(NL);
				}
				}
				setState(672);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(673);
			((FactsContext)_localctx).ftb = match(T__146);
			setState(677);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(674);
				match(NL);
				}
				}
				setState(679);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(680);
			factOrFun();
			setState(691);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(682); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(681);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(684); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(687);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__150 || _la==ID) {
					{
					setState(686);
					factOrFun();
					}
				}

				}
				}
				setState(693);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(694);
			((FactsContext)_localctx).te = match(T__14);
			setState(698);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(695);
				match(NL);
				}
				}
				setState(700);
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
		enterRule(_localctx, 34, RULE_factOrFun);
		try {
			setState(703);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(701);
				fact();
				}
				break;
			case T__150:
				enterOuterAlt(_localctx, 2);
				{
				setState(702);
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
		enterRule(_localctx, 36, RULE_fact);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705);
			match(ID);
			setState(706);
			match(T__15);
			setState(707);
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
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public List<FunDefContext> funDef() {
			return getRuleContexts(FunDefContext.class);
		}
		public FunDefContext funDef(int i) {
			return getRuleContext(FunDefContext.class,i);
		}
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fun);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(709);
			((FunContext)_localctx).tb = match(T__150);
			setState(710);
			match(ID);
			setState(712);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(711);
				match(NL);
				}
			}

			setState(714);
			match(T__20);
			setState(715);
			param();
			setState(720);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(716);
				match(T__10);
				setState(717);
				param();
				}
				}
				setState(722);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(723);
			match(T__21);
			setState(724);
			match(T__7);
			setState(725);
			type();
			setState(735);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(729);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(726);
						match(NL);
						}
						}
						setState(731);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(732);
					funDef();
					}
					} 
				}
				setState(737);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
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

	public static class FunDefContext extends ParserRuleContext {
		public FormulaContext e;
		public FormulaContext c;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
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
		public FunDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDef; }
	}

	public final FunDefContext funDef() throws RecognitionException {
		FunDefContext _localctx = new FunDefContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_funDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(738);
			match(T__81);
			setState(739);
			((FunDefContext)_localctx).e = formula(0);
			setState(740);
			match(T__10);
			setState(744);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(741);
				match(NL);
				}
				}
				setState(746);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(747);
			match(T__151);
			setState(748);
			((FunDefContext)_localctx).c = formula(0);
			setState(749);
			match(T__20);
			setState(750);
			match(ID);
			setState(751);
			match(T__21);
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
		enterRule(_localctx, 42, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(753);
			match(ID);
			setState(754);
			match(T__7);
			setState(755);
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
		enterRule(_localctx, 44, RULE_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 149)) & ~0x3f) == 0 && ((1L << (_la - 149)) & ((1L << (T__148 - 149)) | (1L << (T__150 - 149)) | (1L << (T__151 - 149)) | (1L << (T__152 - 149)) | (1L << (T__153 - 149)) | (1L << (T__154 - 149)) | (1L << (T__156 - 149)) | (1L << (T__157 - 149)) | (1L << (T__159 - 149)) | (1L << (T__160 - 149)) | (1L << (T__161 - 149)) | (1L << (T__164 - 149)) | (1L << (T__165 - 149)) | (1L << (NUM - 149)) | (1L << (ID - 149)) | (1L << (REAL - 149)) | (1L << (INT - 149)) | (1L << (FLOAT - 149)))) != 0)) {
				{
				setState(757);
				stmt();
				}
			}

			setState(770);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(761); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(760);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(763); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(766);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 149)) & ~0x3f) == 0 && ((1L << (_la - 149)) & ((1L << (T__148 - 149)) | (1L << (T__150 - 149)) | (1L << (T__151 - 149)) | (1L << (T__152 - 149)) | (1L << (T__153 - 149)) | (1L << (T__154 - 149)) | (1L << (T__156 - 149)) | (1L << (T__157 - 149)) | (1L << (T__159 - 149)) | (1L << (T__160 - 149)) | (1L << (T__161 - 149)) | (1L << (T__164 - 149)) | (1L << (T__165 - 149)) | (1L << (NUM - 149)) | (1L << (ID - 149)) | (1L << (REAL - 149)) | (1L << (INT - 149)) | (1L << (FLOAT - 149)))) != 0)) {
					{
					setState(765);
					stmt();
					}
				}

				}
				}
				setState(772);
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
		public Token tt;
		public BlockEndContext ts;
		public Token tf;
		public BlockEndContext fs;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<BlockEndContext> blockEnd() {
			return getRuleContexts(BlockEndContext.class);
		}
		public BlockEndContext blockEnd(int i) {
			return getRuleContext(BlockEndContext.class,i);
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
		public Token t;
		public BlockEndContext blockEnd() {
			return getRuleContext(BlockEndContext.class,0);
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
		public MethodDeclStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class ImportStmtContext extends StmtContext {
		public ImporContext impor() {
			return getRuleContext(ImporContext.class,0);
		}
		public ImportStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class WhileStmtContext extends StmtContext {
		public Token t;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public BlockEndContext blockEnd() {
			return getRuleContext(BlockEndContext.class,0);
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
		enterRule(_localctx, 46, RULE_stmt);
		int _la;
		try {
			setState(934);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(773);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__152 || _la==T__153) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(774);
				match(ID);
				setState(775);
				match(T__7);
				setState(776);
				type();
				setState(777);
				match(T__81);
				setState(779);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(778);
					match(NL);
					}
				}

				setState(781);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(783);
				match(ID);
				setState(784);
				match(T__81);
				setState(786);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(785);
					match(NL);
					}
				}

				setState(788);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssumeStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(789);
				match(T__16);
				setState(790);
				match(T__20);
				setState(791);
				exp(0);
				setState(792);
				match(T__21);
				}
				break;
			case 4:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(794);
				match(T__154);
				setState(795);
				match(T__20);
				setState(796);
				exp(0);
				setState(797);
				match(T__21);
				}
				break;
			case 5:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(799);
				match(T__151);
				setState(800);
				match(T__20);
				setState(801);
				exp(0);
				setState(802);
				match(T__21);
				setState(806);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(803);
					match(NL);
					}
					}
					setState(808);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(809);
				((IfStmtContext)_localctx).tt = match(T__13);
				setState(810);
				((IfStmtContext)_localctx).ts = blockEnd();
				setState(820);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__155) {
					{
					setState(811);
					match(T__155);
					setState(815);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(812);
						match(NL);
						}
						}
						setState(817);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(818);
					((IfStmtContext)_localctx).tf = match(T__13);
					setState(819);
					((IfStmtContext)_localctx).fs = blockEnd();
					}
				}

				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(822);
				match(T__156);
				setState(823);
				match(T__20);
				setState(824);
				exp(0);
				setState(825);
				match(T__21);
				setState(829);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(826);
					match(NL);
					}
					}
					setState(831);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(832);
				((WhileStmtContext)_localctx).t = match(T__13);
				setState(843);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
				case 1:
					{
					setState(836);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(833);
						match(NL);
						}
						}
						setState(838);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(839);
					match(T__157);
					setState(840);
					loopInvariant();
					setState(841);
					match(T__158);
					}
					break;
				}
				setState(845);
				blockEnd();
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(847);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__159 || _la==T__160) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(848);
				match(T__20);
				setState(857);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (STRING - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(849);
					stringOrExp();
					setState(854);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(850);
						match(T__10);
						setState(851);
						stringOrExp();
						}
						}
						setState(856);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(859);
				match(T__21);
				}
				break;
			case 8:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(860);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(861);
				match(T__20);
				setState(862);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(863);
				match(T__21);
				setState(864);
				match(T__81);
				setState(866);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(865);
					match(NL);
					}
				}

				setState(868);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 9:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(872);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__161) {
					{
					setState(870);
					match(T__161);
					setState(871);
					((MethodDeclStmtContext)_localctx).helper = match(ID);
					}
				}

				setState(874);
				match(T__150);
				setState(875);
				((MethodDeclStmtContext)_localctx).id = match(ID);
				setState(877);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(876);
					match(NL);
					}
				}

				setState(879);
				match(T__20);
				setState(888);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(880);
					param();
					setState(885);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(881);
						match(T__10);
						setState(882);
						param();
						}
						}
						setState(887);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(890);
				match(T__21);
				setState(891);
				match(T__7);
				setState(894);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
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
				case T__62:
				case T__63:
				case T__64:
				case T__65:
				case T__66:
					{
					setState(892);
					type();
					}
					break;
				case T__162:
					{
					setState(893);
					match(T__162);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(896);
				match(T__81);
				setState(900);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(897);
					match(NL);
					}
					}
					setState(902);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(903);
				((MethodDeclStmtContext)_localctx).t = match(T__13);
				setState(920);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
				case 1:
					{
					setState(907);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(904);
						match(NL);
						}
						}
						setState(909);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(910);
					match(T__157);
					setState(911);
					methodContract();
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
					match(T__158);
					}
					break;
				}
				setState(922);
				blockEnd();
				}
				break;
			case 10:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(923);
				match(T__157);
				setState(928);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
				case 1:
					{
					setState(924);
					proof();
					}
					break;
				case 2:
					{
					setState(925);
					sequent();
					}
					break;
				case 3:
					{
					setState(926);
					invariants();
					}
					break;
				case 4:
					{
					setState(927);
					facts();
					}
					break;
				}
				setState(930);
				match(T__158);
				}
				break;
			case 11:
				_localctx = new ImportStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(932);
				impor();
				}
				break;
			case 12:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(933);
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

	public static class BlockEndContext extends ParserRuleContext {
		public Token t;
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public BlockEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockEnd; }
	}

	public final BlockEndContext blockEnd() throws RecognitionException {
		BlockEndContext _localctx = new BlockEndContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_blockEnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
			stmts();
			setState(944);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__163) {
				{
				setState(937);
				returnStmt();
				setState(941);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(938);
					match(NL);
					}
					}
					setState(943);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(946);
			((BlockEndContext)_localctx).t = match(T__14);
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

	public static class ReturnStmtContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(948);
			match(T__163);
			setState(950);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
				{
				setState(949);
				exp(0);
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
		enterRule(_localctx, 52, RULE_stringOrExp);
		try {
			setState(954);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(952);
				match(STRING);
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
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
			case T__62:
			case T__63:
			case T__64:
			case T__65:
			case T__66:
			case T__87:
			case T__88:
			case T__164:
			case T__165:
			case NUM:
			case ID:
			case REAL:
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(953);
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
	public static class TypeMethodCallExpContext extends PrimExpContext {
		public Token t;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TypeMethodCallExpContext(PrimExpContext ctx) { copyFrom(ctx); }
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
		enterRule(_localctx, 54, RULE_primExp);
		int _la;
		try {
			setState(993);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
			case 1:
				_localctx = new BooleanExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(956);
				((BooleanExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
					((BooleanExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				_localctx = new IntExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(957);
				match(NUM);
				}
				break;
			case 3:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(958);
				match(ID);
				}
				break;
			case 4:
				_localctx = new TypeMethodCallExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(959);
				((TypeMethodCallExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (T__45 - 46)) | (1L << (T__46 - 46)) | (1L << (T__47 - 46)) | (1L << (T__48 - 46)) | (1L << (T__49 - 46)) | (1L << (T__50 - 46)) | (1L << (T__51 - 46)) | (1L << (T__52 - 46)) | (1L << (T__53 - 46)) | (1L << (T__54 - 46)) | (1L << (T__55 - 46)) | (1L << (T__56 - 46)) | (1L << (T__57 - 46)) | (1L << (T__58 - 46)) | (1L << (T__59 - 46)) | (1L << (T__60 - 46)) | (1L << (T__61 - 46)) | (1L << (T__62 - 46)) | (1L << (T__63 - 46)) | (1L << (T__64 - 46)) | (1L << (T__65 - 46)) | (1L << (T__66 - 46)))) != 0)) ) {
					((TypeMethodCallExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(960);
				match(T__15);
				setState(961);
				match(ID);
				setState(962);
				match(T__20);
				setState(971);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(963);
					exp(0);
					setState(968);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(964);
						match(T__10);
						setState(965);
						exp(0);
						}
						}
						setState(970);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(973);
				match(T__21);
				}
				break;
			case 5:
				_localctx = new TypeAccessExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(974);
				((TypeAccessExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & ((1L << (T__23 - 24)) | (1L << (T__24 - 24)) | (1L << (T__25 - 24)) | (1L << (T__26 - 24)) | (1L << (T__27 - 24)) | (1L << (T__28 - 24)) | (1L << (T__29 - 24)) | (1L << (T__30 - 24)) | (1L << (T__31 - 24)) | (1L << (T__32 - 24)) | (1L << (T__33 - 24)) | (1L << (T__34 - 24)) | (1L << (T__35 - 24)) | (1L << (T__36 - 24)) | (1L << (T__37 - 24)) | (1L << (T__38 - 24)) | (1L << (T__39 - 24)) | (1L << (T__40 - 24)) | (1L << (T__41 - 24)) | (1L << (T__42 - 24)) | (1L << (T__43 - 24)) | (1L << (T__44 - 24)) | (1L << (T__45 - 24)) | (1L << (T__46 - 24)) | (1L << (T__47 - 24)) | (1L << (T__48 - 24)) | (1L << (T__49 - 24)) | (1L << (T__50 - 24)) | (1L << (T__51 - 24)) | (1L << (T__52 - 24)) | (1L << (T__53 - 24)) | (1L << (T__54 - 24)) | (1L << (T__55 - 24)) | (1L << (T__56 - 24)) | (1L << (T__57 - 24)) | (1L << (T__58 - 24)) | (1L << (T__59 - 24)) | (1L << (T__60 - 24)) | (1L << (T__61 - 24)) | (1L << (T__62 - 24)) | (1L << (T__63 - 24)) | (1L << (T__64 - 24)) | (1L << (T__65 - 24)) | (1L << (T__66 - 24)))) != 0)) ) {
					((TypeAccessExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(975);
				match(T__15);
				setState(976);
				match(ID);
				}
				break;
			case 6:
				_localctx = new FloatLitExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(977);
				match(FLOAT);
				}
				break;
			case 7:
				_localctx = new IntLitExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(978);
				match(INT);
				}
				break;
			case 8:
				_localctx = new RLitExpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(979);
				match(REAL);
				}
				break;
			case 9:
				_localctx = new SeqExpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(980);
				((SeqExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (T__45 - 46)) | (1L << (T__46 - 46)) | (1L << (T__47 - 46)) | (1L << (T__48 - 46)) | (1L << (T__49 - 46)) | (1L << (T__50 - 46)) | (1L << (T__51 - 46)) | (1L << (T__52 - 46)) | (1L << (T__53 - 46)) | (1L << (T__54 - 46)) | (1L << (T__55 - 46)) | (1L << (T__56 - 46)) | (1L << (T__57 - 46)) | (1L << (T__58 - 46)) | (1L << (T__59 - 46)) | (1L << (T__60 - 46)) | (1L << (T__61 - 46)) | (1L << (T__62 - 46)) | (1L << (T__63 - 46)) | (1L << (T__64 - 46)) | (1L << (T__65 - 46)) | (1L << (T__66 - 46)))) != 0)) ) {
					((SeqExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(981);
				match(T__20);
				setState(990);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(982);
					exp(0);
					setState(987);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(983);
						match(T__10);
						setState(984);
						exp(0);
						}
						}
						setState(989);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(992);
				match(T__21);
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
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1032);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				{
				_localctx = new InvokeExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(996);
				((InvokeExpContext)_localctx).tb = match(ID);
				setState(997);
				((InvokeExpContext)_localctx).t = match(T__20);
				setState(1006);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(998);
					exp(0);
					setState(1003);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(999);
						match(T__10);
						setState(1000);
						exp(0);
						}
						}
						setState(1005);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1008);
				match(T__21);
				}
				break;
			case 2:
				{
				_localctx = new PExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1009);
				primExp();
				setState(1014);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1010);
						match(T__15);
						setState(1011);
						match(ID);
						}
						} 
					}
					setState(1016);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
				}
				}
				break;
			case 3:
				{
				_localctx = new RandomIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1017);
				match(T__164);
				setState(1018);
				match(T__20);
				setState(1019);
				match(T__21);
				}
				break;
			case 4:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1020);
				match(T__165);
				setState(1021);
				match(T__20);
				setState(1023);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(1022);
					match(STRING);
					}
				}

				setState(1025);
				match(T__21);
				}
				break;
			case 5:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1026);
				match(T__20);
				setState(1027);
				exp(0);
				setState(1028);
				match(T__21);
				}
				break;
			case 6:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1030);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__87 || _la==T__88) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1031);
				exp(10);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1090);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1088);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1034);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1035);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__67 || _la==T__68) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1037);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1036);
							match(NL);
							}
						}

						setState(1039);
						((BinaryExpContext)_localctx).r = exp(10);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1040);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1041);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__69) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1043);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1042);
							match(NL);
							}
						}

						setState(1045);
						((BinaryExpContext)_localctx).r = exp(9);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1046);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1047);
						((BinaryExpContext)_localctx).op = match(T__70);
						setState(1049);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1048);
							match(NL);
							}
						}

						setState(1051);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1052);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1053);
						((BinaryExpContext)_localctx).op = match(T__71);
						setState(1055);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1054);
							match(NL);
							}
						}

						setState(1057);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1058);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1059);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__75 - 73)) | (1L << (T__76 - 73)) | (1L << (T__78 - 73)) | (1L << (T__79 - 73)) | (1L << (T__80 - 73)))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1061);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1060);
							match(NL);
							}
						}

						setState(1063);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1064);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1065);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__82 || _la==T__83) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1067);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1066);
							match(NL);
							}
						}

						setState(1069);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1070);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1071);
						((BinaryExpContext)_localctx).op = match(T__91);
						setState(1073);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1072);
							match(NL);
							}
						}

						setState(1075);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1076);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1077);
						((BinaryExpContext)_localctx).op = match(T__95);
						setState(1079);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1078);
							match(NL);
							}
						}

						setState(1081);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1082);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1083);
						((BinaryExpContext)_localctx).op = match(T__1);
						setState(1085);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1084);
							match(NL);
							}
						}

						setState(1087);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(1092);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
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
		enterRule(_localctx, 58, RULE_loopInvariant);
		int _la;
		try {
			int _alt;
			setState(1146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1093);
				((LoopInvariantContext)_localctx).tb = match(T__13);
				setState(1097);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1094);
					match(NL);
					}
					}
					setState(1099);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1100);
				modifies();
				setState(1101);
				((LoopInvariantContext)_localctx).te = match(T__14);
				setState(1105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1102);
					match(NL);
					}
					}
					setState(1107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1108);
				((LoopInvariantContext)_localctx).tb = match(T__13);
				setState(1112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1109);
					match(NL);
					}
					}
					setState(1114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1115);
				((LoopInvariantContext)_localctx).itb = match(T__145);
				setState(1119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1116);
					match(NL);
					}
					}
					setState(1121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1122);
				formula(0);
				setState(1133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1124); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1123);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1126); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,152,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(1129);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
						{
						setState(1128);
						formula(0);
						}
					}

					}
					}
					setState(1135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__166) {
					{
					setState(1136);
					modifies();
					}
				}

				setState(1139);
				((LoopInvariantContext)_localctx).te = match(T__14);
				setState(1143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1140);
					match(NL);
					}
					}
					setState(1145);
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
		enterRule(_localctx, 60, RULE_modifies);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1148);
			((ModifiesContext)_localctx).tb = match(T__166);
			setState(1149);
			match(ID);
			setState(1154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(1150);
				match(T__10);
				setState(1151);
				match(ID);
				}
				}
				setState(1156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,159,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1157);
					match(NL);
					}
					} 
				}
				setState(1162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,159,_ctx);
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
		enterRule(_localctx, 62, RULE_methodContract);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1163);
			((MethodContractContext)_localctx).tb = match(T__13);
			setState(1167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,160,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1164);
					match(NL);
					}
					} 
				}
				setState(1169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,160,_ctx);
			}
			setState(1191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__167 || _la==T__168) {
				{
				setState(1170);
				_la = _input.LA(1);
				if ( !(_la==T__167 || _la==T__168) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1171);
					match(NL);
					}
					}
					setState(1176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1177);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(1188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1179); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1178);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1181); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,162,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(1184);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
							{
							setState(1183);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(1190);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
				}
				}
			}

			setState(1196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1193);
					match(NL);
					}
					} 
				}
				setState(1198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
			}
			setState(1200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__166) {
				{
				setState(1199);
				modifies();
				}
			}

			setState(1223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__169 || _la==T__170) {
				{
				setState(1202);
				_la = _input.LA(1);
				if ( !(_la==T__169 || _la==T__170) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1203);
					match(NL);
					}
					}
					setState(1208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1209);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(1220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1211); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1210);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1213); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,169,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(1216);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
							{
							setState(1215);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(1222);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
				}
				}
			}

			setState(1228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1225);
				match(NL);
				}
				}
				setState(1230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1231);
			((MethodContractContext)_localctx).te = match(T__14);
			setState(1235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1232);
					match(NL);
					}
					} 
				}
				setState(1237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
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
		enterRule(_localctx, 64, RULE_invariants);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1238);
			((InvariantsContext)_localctx).tb = match(T__13);
			setState(1242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1239);
				match(NL);
				}
				}
				setState(1244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1245);
			match(T__145);
			setState(1249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1246);
				match(NL);
				}
				}
				setState(1251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1252);
			formula(0);
			setState(1263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1254); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1253);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1256); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
					{
					setState(1258);
					formula(0);
					}
				}

				}
				}
				setState(1265);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1266);
			((InvariantsContext)_localctx).te = match(T__14);
			setState(1270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1267);
				match(NL);
				}
				}
				setState(1272);
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
		case 10:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 13:
			return justification_sempred((JustificationContext)_localctx, predIndex);
		case 28:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u00bb\u04fc\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\7\2I\n\2\f\2\16\2L\13\2\3\2\3\2\7\2P\n\2\f"+
		"\2\16\2S\13\2\3\2\5\2V\n\2\3\2\7\2Y\n\2\f\2\16\2\\\13\2\3\2\3\2\3\2\3"+
		"\2\3\2\5\2c\n\2\3\3\7\3f\n\3\f\3\16\3i\13\3\3\3\3\3\6\3m\n\3\r\3\16\3"+
		"n\3\3\3\3\6\3s\n\3\r\3\16\3t\3\3\6\3x\n\3\r\3\16\3y\3\3\3\3\3\3\6\3\177"+
		"\n\3\r\3\16\3\u0080\3\3\3\3\6\3\u0085\n\3\r\3\16\3\u0086\3\3\7\3\u008a"+
		"\n\3\f\3\16\3\u008d\13\3\3\3\6\3\u0090\n\3\r\3\16\3\u0091\3\3\3\3\6\3"+
		"\u0096\n\3\r\3\16\3\u0097\3\3\5\3\u009b\n\3\3\3\7\3\u009e\n\3\f\3\16\3"+
		"\u00a1\13\3\3\4\7\4\u00a4\n\4\f\4\16\4\u00a7\13\4\3\4\3\4\7\4\u00ab\n"+
		"\4\f\4\16\4\u00ae\13\4\3\5\3\5\3\6\3\6\6\6\u00b4\n\6\r\6\16\6\u00b5\3"+
		"\6\3\6\3\6\3\6\7\6\u00bc\n\6\f\6\16\6\u00bf\13\6\3\6\7\6\u00c2\n\6\f\6"+
		"\16\6\u00c5\13\6\3\6\6\6\u00c8\n\6\r\6\16\6\u00c9\3\6\3\6\3\6\3\6\7\6"+
		"\u00d0\n\6\f\6\16\6\u00d3\13\6\3\6\7\6\u00d6\n\6\f\6\16\6\u00d9\13\6\5"+
		"\6\u00db\n\6\3\7\3\7\6\7\u00df\n\7\r\7\16\7\u00e0\3\7\3\7\3\b\3\b\3\b"+
		"\7\b\u00e8\n\b\f\b\16\b\u00eb\13\b\5\b\u00ed\n\b\3\b\3\b\3\b\3\b\7\b\u00f3"+
		"\n\b\f\b\16\b\u00f6\13\b\3\b\7\b\u00f9\n\b\f\b\16\b\u00fc\13\b\3\b\3\b"+
		"\6\b\u0100\n\b\r\b\16\b\u0101\5\b\u0104\n\b\3\t\3\t\5\t\u0108\n\t\3\t"+
		"\6\t\u010b\n\t\r\t\16\t\u010c\3\t\5\t\u0110\n\t\7\t\u0112\n\t\f\t\16\t"+
		"\u0115\13\t\3\t\3\t\7\t\u0119\n\t\f\t\16\t\u011c\13\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\7\n\u0126\n\n\f\n\16\n\u0129\13\n\3\n\3\n\7\n\u012d\n"+
		"\n\f\n\16\n\u0130\13\n\3\n\3\n\3\n\3\n\3\n\5\n\u0137\n\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\5\n\u013f\n\n\3\n\3\n\3\n\5\n\u0144\n\n\3\n\6\n\u0147\n\n\r"+
		"\n\16\n\u0148\3\n\5\n\u014c\n\n\7\n\u014e\n\n\f\n\16\n\u0151\13\n\3\n"+
		"\5\n\u0154\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u0160\n\13\f\13\16\13\u0163\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\7\13\u016d\n\13\f\13\16\13\u0170\13\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0181\n\13\f\13"+
		"\16\13\u0184\13\13\5\13\u0186\n\13\3\13\5\13\u0189\n\13\3\f\3\f\3\f\3"+
		"\f\7\f\u018f\n\f\f\f\16\f\u0192\13\f\3\f\3\f\3\f\3\f\3\f\5\f\u0199\n\f"+
		"\3\f\3\f\3\f\5\f\u019e\n\f\3\f\3\f\3\f\3\f\5\f\u01a4\n\f\3\f\3\f\3\f\3"+
		"\f\5\f\u01aa\n\f\3\f\3\f\3\f\3\f\5\f\u01b0\n\f\3\f\3\f\3\f\3\f\5\f\u01b6"+
		"\n\f\3\f\3\f\3\f\3\f\5\f\u01bc\n\f\3\f\3\f\3\f\3\f\5\f\u01c2\n\f\3\f\3"+
		"\f\3\f\3\f\5\f\u01c8\n\f\3\f\3\f\3\f\3\f\5\f\u01ce\n\f\3\f\3\f\3\f\3\f"+
		"\5\f\u01d4\n\f\3\f\7\f\u01d7\n\f\f\f\16\f\u01da\13\f\3\r\3\r\3\r\3\r\7"+
		"\r\u01e0\n\r\f\r\16\r\u01e3\13\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u01eb\n\r"+
		"\3\r\3\r\5\r\u01ef\n\r\3\r\3\r\3\r\5\r\u01f4\n\r\3\r\5\r\u01f7\n\r\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u0201\n\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u0208\n\17\3\17\3\17\3\17\3\17\5\17\u020e\n\17\3\17\3\17\3"+
		"\17\3\17\5\17\u0214\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0238\n\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0245\n\17"+
		"\f\17\16\17\u0248\13\17\3\17\3\17\3\17\3\17\3\17\6\17\u024f\n\17\r\17"+
		"\16\17\u0250\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u025c\n"+
		"\17\r\17\16\17\u025d\3\17\3\17\3\17\6\17\u0263\n\17\r\17\16\17\u0264\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u026f\n\17\r\17\16\17\u0270"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u027d\n\17\f\17"+
		"\16\17\u0280\13\17\5\17\u0282\n\17\3\20\7\20\u0285\n\20\f\20\16\20\u0288"+
		"\13\20\3\20\3\20\6\20\u028c\n\20\r\20\16\20\u028d\3\20\3\20\5\20\u0292"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\7\22\u029f"+
		"\n\22\f\22\16\22\u02a2\13\22\3\22\3\22\7\22\u02a6\n\22\f\22\16\22\u02a9"+
		"\13\22\3\22\3\22\6\22\u02ad\n\22\r\22\16\22\u02ae\3\22\5\22\u02b2\n\22"+
		"\7\22\u02b4\n\22\f\22\16\22\u02b7\13\22\3\22\3\22\7\22\u02bb\n\22\f\22"+
		"\16\22\u02be\13\22\3\23\3\23\5\23\u02c2\n\23\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\5\25\u02cb\n\25\3\25\3\25\3\25\3\25\7\25\u02d1\n\25\f\25\16"+
		"\25\u02d4\13\25\3\25\3\25\3\25\3\25\7\25\u02da\n\25\f\25\16\25\u02dd\13"+
		"\25\3\25\7\25\u02e0\n\25\f\25\16\25\u02e3\13\25\3\26\3\26\3\26\3\26\7"+
		"\26\u02e9\n\26\f\26\16\26\u02ec\13\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\30\5\30\u02f9\n\30\3\30\6\30\u02fc\n\30\r\30\16\30"+
		"\u02fd\3\30\5\30\u0301\n\30\7\30\u0303\n\30\f\30\16\30\u0306\13\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u030e\n\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u0315\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\7\31\u0327\n\31\f\31\16\31\u032a\13\31\3\31\3\31"+
		"\3\31\3\31\7\31\u0330\n\31\f\31\16\31\u0333\13\31\3\31\3\31\5\31\u0337"+
		"\n\31\3\31\3\31\3\31\3\31\3\31\7\31\u033e\n\31\f\31\16\31\u0341\13\31"+
		"\3\31\3\31\7\31\u0345\n\31\f\31\16\31\u0348\13\31\3\31\3\31\3\31\3\31"+
		"\5\31\u034e\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0357\n\31\f"+
		"\31\16\31\u035a\13\31\5\31\u035c\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\5\31\u0365\n\31\3\31\3\31\3\31\3\31\5\31\u036b\n\31\3\31\3\31\3\31"+
		"\5\31\u0370\n\31\3\31\3\31\3\31\3\31\7\31\u0376\n\31\f\31\16\31\u0379"+
		"\13\31\5\31\u037b\n\31\3\31\3\31\3\31\3\31\5\31\u0381\n\31\3\31\3\31\7"+
		"\31\u0385\n\31\f\31\16\31\u0388\13\31\3\31\3\31\7\31\u038c\n\31\f\31\16"+
		"\31\u038f\13\31\3\31\3\31\3\31\7\31\u0394\n\31\f\31\16\31\u0397\13\31"+
		"\3\31\3\31\5\31\u039b\n\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u03a3\n"+
		"\31\3\31\3\31\3\31\3\31\5\31\u03a9\n\31\3\32\3\32\3\32\7\32\u03ae\n\32"+
		"\f\32\16\32\u03b1\13\32\5\32\u03b3\n\32\3\32\3\32\3\33\3\33\5\33\u03b9"+
		"\n\33\3\34\3\34\5\34\u03bd\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\7\35\u03c9\n\35\f\35\16\35\u03cc\13\35\5\35\u03ce\n\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u03dc\n\35"+
		"\f\35\16\35\u03df\13\35\5\35\u03e1\n\35\3\35\5\35\u03e4\n\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\7\36\u03ec\n\36\f\36\16\36\u03ef\13\36\5\36\u03f1"+
		"\n\36\3\36\3\36\3\36\3\36\7\36\u03f7\n\36\f\36\16\36\u03fa\13\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\5\36\u0402\n\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u040b\n\36\3\36\3\36\3\36\5\36\u0410\n\36\3\36\3\36\3\36\3"+
		"\36\5\36\u0416\n\36\3\36\3\36\3\36\3\36\5\36\u041c\n\36\3\36\3\36\3\36"+
		"\3\36\5\36\u0422\n\36\3\36\3\36\3\36\3\36\5\36\u0428\n\36\3\36\3\36\3"+
		"\36\3\36\5\36\u042e\n\36\3\36\3\36\3\36\3\36\5\36\u0434\n\36\3\36\3\36"+
		"\3\36\3\36\5\36\u043a\n\36\3\36\3\36\3\36\3\36\5\36\u0440\n\36\3\36\7"+
		"\36\u0443\n\36\f\36\16\36\u0446\13\36\3\37\3\37\7\37\u044a\n\37\f\37\16"+
		"\37\u044d\13\37\3\37\3\37\3\37\7\37\u0452\n\37\f\37\16\37\u0455\13\37"+
		"\3\37\3\37\7\37\u0459\n\37\f\37\16\37\u045c\13\37\3\37\3\37\7\37\u0460"+
		"\n\37\f\37\16\37\u0463\13\37\3\37\3\37\6\37\u0467\n\37\r\37\16\37\u0468"+
		"\3\37\5\37\u046c\n\37\7\37\u046e\n\37\f\37\16\37\u0471\13\37\3\37\5\37"+
		"\u0474\n\37\3\37\3\37\7\37\u0478\n\37\f\37\16\37\u047b\13\37\5\37\u047d"+
		"\n\37\3 \3 \3 \3 \7 \u0483\n \f \16 \u0486\13 \3 \7 \u0489\n \f \16 \u048c"+
		"\13 \3!\3!\7!\u0490\n!\f!\16!\u0493\13!\3!\3!\7!\u0497\n!\f!\16!\u049a"+
		"\13!\3!\3!\6!\u049e\n!\r!\16!\u049f\3!\5!\u04a3\n!\7!\u04a5\n!\f!\16!"+
		"\u04a8\13!\5!\u04aa\n!\3!\7!\u04ad\n!\f!\16!\u04b0\13!\3!\5!\u04b3\n!"+
		"\3!\3!\7!\u04b7\n!\f!\16!\u04ba\13!\3!\3!\6!\u04be\n!\r!\16!\u04bf\3!"+
		"\5!\u04c3\n!\7!\u04c5\n!\f!\16!\u04c8\13!\5!\u04ca\n!\3!\7!\u04cd\n!\f"+
		"!\16!\u04d0\13!\3!\3!\7!\u04d4\n!\f!\16!\u04d7\13!\3\"\3\"\7\"\u04db\n"+
		"\"\f\"\16\"\u04de\13\"\3\"\3\"\7\"\u04e2\n\"\f\"\16\"\u04e5\13\"\3\"\3"+
		"\"\6\"\u04e9\n\"\r\"\16\"\u04ea\3\"\5\"\u04ee\n\"\7\"\u04f0\n\"\f\"\16"+
		"\"\u04f3\13\"\3\"\3\"\7\"\u04f7\n\"\f\"\16\"\u04fa\13\"\3\"\2\4\26:#\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2*\3"+
		"\2\5\b\3\2\5\6\3\2\7\b\3\2\16\17\4\2\5\b\24\26\3\2\32/\3\2\60E\3\2X\\"+
		"\4\2\3\3FG\4\2\t\tHH\3\2KS\3\2TW\3\2]`\3\2ab\4\2\4\4ce\3\2fh\3\2ip\3\2"+
		"\32E\3\2^`\3\2tu\3\2vy\4\2\4\4ee\3\2z{\3\2gh\3\2~\177\3\2\u0080\u0081"+
		"\3\2Z\\\3\2\u0082\u0083\4\2\b\b\26\26\3\2\u0088\u008a\3\2\u008b\u008d"+
		"\3\2\u008e\u0090\3\2\u0091\u0093\3\2\u009b\u009c\3\2\u00a2\u00a3\4\2\t"+
		"\tZ[\5\2KLNOQS\3\2UV\3\2\u00aa\u00ab\3\2\u00ac\u00ad\u05df\2b\3\2\2\2"+
		"\4g\3\2\2\2\6\u00a5\3\2\2\2\b\u00af\3\2\2\2\n\u00b1\3\2\2\2\f\u00dc\3"+
		"\2\2\2\16\u0103\3\2\2\2\20\u0105\3\2\2\2\22\u0153\3\2\2\2\24\u0188\3\2"+
		"\2\2\26\u0198\3\2\2\2\30\u01db\3\2\2\2\32\u01fa\3\2\2\2\34\u0281\3\2\2"+
		"\2\36\u0286\3\2\2\2 \u0293\3\2\2\2\"\u029c\3\2\2\2$\u02c1\3\2\2\2&\u02c3"+
		"\3\2\2\2(\u02c7\3\2\2\2*\u02e4\3\2\2\2,\u02f3\3\2\2\2.\u02f8\3\2\2\2\60"+
		"\u03a8\3\2\2\2\62\u03aa\3\2\2\2\64\u03b6\3\2\2\2\66\u03bc\3\2\2\28\u03e3"+
		"\3\2\2\2:\u040a\3\2\2\2<\u047c\3\2\2\2>\u047e\3\2\2\2@\u048d\3\2\2\2B"+
		"\u04d8\3\2\2\2DE\5\4\3\2EF\7\2\2\3Fc\3\2\2\2GI\7\u00b4\2\2HG\3\2\2\2I"+
		"L\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MQ\5\16\b\2NP\7\u00b4"+
		"\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RU\3\2\2\2SQ\3\2\2\2TV\5\20"+
		"\t\2UT\3\2\2\2UV\3\2\2\2VZ\3\2\2\2WY\7\u00b4\2\2XW\3\2\2\2Y\\\3\2\2\2"+
		"ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7\2\2\3^c\3\2\2\2_`\5\36\20"+
		"\2`a\7\2\2\3ac\3\2\2\2bD\3\2\2\2bJ\3\2\2\2b_\3\2\2\2c\3\3\2\2\2df\7\u00b4"+
		"\2\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2\2ig\3\2\2\2jl\7\3"+
		"\2\2km\7\u00b4\2\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2op\3\2\2\2p"+
		"r\7\u00ae\2\2qs\7\u00b4\2\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw"+
		"\3\2\2\2vx\7\u00b0\2\2wv\3\2\2\2xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2"+
		"\2{|\7\4\2\2|~\5\26\f\2}\177\7\u00b4\2\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u008b\7\u00ae"+
		"\2\2\u0083\u0085\7\u00b4\2\2\u0084\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\5\6"+
		"\4\2\u0089\u0084\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0090\7\u00b4"+
		"\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u009a\7\u00ae\2\2\u0094\u0096"+
		"\7\u00b4\2\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2"+
		"\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\5\n\6\2\u009a\u0095"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009f\3\2\2\2\u009c\u009e\7\u00b4\2"+
		"\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\5\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\5\b\5\2\u00a3"+
		"\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00ac\7\4\2\2\u00a9"+
		"\u00ab\5\b\5\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\7\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0"+
		"\t\2\2\2\u00b0\t\3\2\2\2\u00b1\u00da\7\u00b0\2\2\u00b2\u00b4\7\u00b4\2"+
		"\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7\t\2\2\u00b8\u00b9\t\3\2\2\u00b9"+
		"\u00c3\7\n\2\2\u00ba\u00bc\7\u00b4\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf"+
		"\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00c0\u00c2\5\f\7\2\u00c1\u00bd\3\2\2\2\u00c2\u00c5\3\2"+
		"\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c6\u00c8\7\u00b4\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9"+
		"\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00cc\7\t\2\2\u00cc\u00cd\t\4\2\2\u00cd\u00d7\7\n\2\2\u00ce\u00d0\7\u00b4"+
		"\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d6\5\f"+
		"\7\2\u00d5\u00d1\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00b3\3\2"+
		"\2\2\u00da\u00db\3\2\2\2\u00db\13\3\2\2\2\u00dc\u00de\7\13\2\2\u00dd\u00df"+
		"\5\b\5\2\u00de\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\7\f\2\2\u00e3\r\3\2\2\2"+
		"\u00e4\u00e9\5\26\f\2\u00e5\u00e6\7\r\2\2\u00e6\u00e8\5\26\f\2\u00e7\u00e5"+
		"\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00e4\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\t\5\2\2\u00ef\u00f4\5\26\f\2\u00f0"+
		"\u00f1\7\r\2\2\u00f1\u00f3\5\26\f\2\u00f2\u00f0\3\2\2\2\u00f3\u00f6\3"+
		"\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u0104\3\2\2\2\u00f6"+
		"\u00f4\3\2\2\2\u00f7\u00f9\5\26\f\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc\3"+
		"\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc"+
		"\u00fa\3\2\2\2\u00fd\u00ff\7\u00ae\2\2\u00fe\u0100\5\26\f\2\u00ff\u00fe"+
		"\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0104\3\2\2\2\u0103\u00ec\3\2\2\2\u0103\u00fa\3\2\2\2\u0104\17\3\2\2"+
		"\2\u0105\u0107\7\20\2\2\u0106\u0108\5\22\n\2\u0107\u0106\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\u0113\3\2\2\2\u0109\u010b\7\u00b4\2\2\u010a\u0109"+
		"\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u010f\3\2\2\2\u010e\u0110\5\22\n\2\u010f\u010e\3\2\2\2\u010f\u0110\3"+
		"\2\2\2\u0110\u0112\3\2\2\2\u0111\u010a\3\2\2\2\u0112\u0115\3\2\2\2\u0113"+
		"\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0116\3\2\2\2\u0115\u0113\3\2"+
		"\2\2\u0116\u011a\7\21\2\2\u0117\u0119\7\u00b4\2\2\u0118\u0117\3\2\2\2"+
		"\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\21"+
		"\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\7\u00af\2\2\u011e\u011f\7\22"+
		"\2\2\u011f\u0120\5\26\f\2\u0120\u0121\5\34\17\2\u0121\u0154\3\2\2\2\u0122"+
		"\u0123\7\u00af\2\2\u0123\u0127\7\22\2\2\u0124\u0126\7\u00b4\2\2\u0125"+
		"\u0124\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2"+
		"\2\2\u0128\u012a\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012e\7\20\2\2\u012b"+
		"\u012d\7\u00b4\2\2\u012c\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c"+
		"\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131"+
		"\u0132\7\u00af\2\2\u0132\u0143\7\22\2\2\u0133\u0136\7\u00b0\2\2\u0134"+
		"\u0135\7\n\2\2\u0135\u0137\5\32\16\2\u0136\u0134\3\2\2\2\u0136\u0137\3"+
		"\2\2\2\u0137\u0144\3\2\2\2\u0138\u0139\5\26\f\2\u0139\u013a\7\23\2\2\u013a"+
		"\u0144\3\2\2\2\u013b\u013e\7\u00b0\2\2\u013c\u013d\7\n\2\2\u013d\u013f"+
		"\5\32\16\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\3\2\2\2"+
		"\u0140\u0141\5\26\f\2\u0141\u0142\7\23\2\2\u0142\u0144\3\2\2\2\u0143\u0133"+
		"\3\2\2\2\u0143\u0138\3\2\2\2\u0143\u013b\3\2\2\2\u0144\u014f\3\2\2\2\u0145"+
		"\u0147\7\u00b4\2\2\u0146\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0146"+
		"\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014b\3\2\2\2\u014a\u014c\5\22\n\2"+
		"\u014b\u014a\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014e\3\2\2\2\u014d\u0146"+
		"\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u0152\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0154\7\21\2\2\u0153\u011d\3"+
		"\2\2\2\u0153\u0122\3\2\2\2\u0154\23\3\2\2\2\u0155\u0189\t\6\2\2\u0156"+
		"\u0157\7\27\2\2\u0157\u0158\5\26\f\2\u0158\u0159\7\30\2\2\u0159\u0189"+
		"\3\2\2\2\u015a\u015b\7\31\2\2\u015b\u015c\7\27\2\2\u015c\u0161\5\26\f"+
		"\2\u015d\u015e\7\r\2\2\u015e\u0160\5\26\f\2\u015f\u015d\3\2\2\2\u0160"+
		"\u0163\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0164\3\2"+
		"\2\2\u0163\u0161\3\2\2\2\u0164\u0165\7\30\2\2\u0165\u0189\3\2\2\2\u0166"+
		"\u0189\7\31\2\2\u0167\u0168\7\u00b0\2\2\u0168\u0169\7\27\2\2\u0169\u016e"+
		"\5\26\f\2\u016a\u016b\7\r\2\2\u016b\u016d\5\26\f\2\u016c\u016a\3\2\2\2"+
		"\u016d\u0170\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0171"+
		"\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0172\7\30\2\2\u0172\u0189\3\2\2\2"+
		"\u0173\u0189\7\u00b0\2\2\u0174\u0189\7\u00af\2\2\u0175\u0189\7\u00b2\2"+
		"\2\u0176\u0189\7\u00b1\2\2\u0177\u0189\7\u00ba\2\2\u0178\u0179\t\7\2\2"+
		"\u0179\u017a\7\22\2\2\u017a\u0189\7\u00b0\2\2\u017b\u017c\t\b\2\2\u017c"+
		"\u0185\7\27\2\2\u017d\u0182\5:\36\2\u017e\u017f\7\r\2\2\u017f\u0181\5"+
		":\36\2\u0180\u017e\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182"+
		"\u0183\3\2\2\2\u0183\u0186\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u017d\3\2"+
		"\2\2\u0185\u0186\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0189\7\30\2\2\u0188"+
		"\u0155\3\2\2\2\u0188\u0156\3\2\2\2\u0188\u015a\3\2\2\2\u0188\u0166\3\2"+
		"\2\2\u0188\u0167\3\2\2\2\u0188\u0173\3\2\2\2\u0188\u0174\3\2\2\2\u0188"+
		"\u0175\3\2\2\2\u0188\u0176\3\2\2\2\u0188\u0177\3\2\2\2\u0188\u0178\3\2"+
		"\2\2\u0188\u017b\3\2\2\2\u0189\25\3\2\2\2\u018a\u018b\b\f\1\2\u018b\u0190"+
		"\5\24\13\2\u018c\u018d\7\22\2\2\u018d\u018f\7\u00b0\2\2\u018e\u018c\3"+
		"\2\2\2\u018f\u0192\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191"+
		"\u0199\3\2\2\2\u0192\u0190\3\2\2\2\u0193\u0194\7\t\2\2\u0194\u0199\5\26"+
		"\f\t\u0195\u0196\t\t\2\2\u0196\u0199\5\26\f\b\u0197\u0199\5\30\r\2\u0198"+
		"\u018a\3\2\2\2\u0198\u0193\3\2\2\2\u0198\u0195\3\2\2\2\u0198\u0197\3\2"+
		"\2\2\u0199\u01d8\3\2\2\2\u019a\u019b\f\17\2\2\u019b\u019d\t\n\2\2\u019c"+
		"\u019e\7\u00b4\2\2\u019d\u019c\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f"+
		"\3\2\2\2\u019f\u01d7\5\26\f\20\u01a0\u01a1\f\16\2\2\u01a1\u01a3\t\13\2"+
		"\2\u01a2\u01a4\7\u00b4\2\2\u01a3\u01a2\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4"+
		"\u01a5\3\2\2\2\u01a5\u01d7\5\26\f\17\u01a6\u01a7\f\r\2\2\u01a7\u01a9\7"+
		"I\2\2\u01a8\u01aa\7\u00b4\2\2\u01a9\u01a8\3\2\2\2\u01a9\u01aa\3\2\2\2"+
		"\u01aa\u01ab\3\2\2\2\u01ab\u01d7\5\26\f\r\u01ac\u01ad\f\f\2\2\u01ad\u01af"+
		"\7J\2\2\u01ae\u01b0\7\u00b4\2\2\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2\2"+
		"\2\u01b0\u01b1\3\2\2\2\u01b1\u01d7\5\26\f\r\u01b2\u01b3\f\13\2\2\u01b3"+
		"\u01b5\t\f\2\2\u01b4\u01b6\7\u00b4\2\2\u01b5\u01b4\3\2\2\2\u01b5\u01b6"+
		"\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01d7\5\26\f\f\u01b8\u01b9\f\n\2\2"+
		"\u01b9\u01bb\t\r\2\2\u01ba\u01bc\7\u00b4\2\2\u01bb\u01ba\3\2\2\2\u01bb"+
		"\u01bc\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01d7\5\26\f\13\u01be\u01bf\f"+
		"\7\2\2\u01bf\u01c1\t\16\2\2\u01c0\u01c2\7\u00b4\2\2\u01c1\u01c0\3\2\2"+
		"\2\u01c1\u01c2\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01d7\5\26\f\b\u01c4"+
		"\u01c5\f\6\2\2\u01c5\u01c7\t\17\2\2\u01c6\u01c8\7\u00b4\2\2\u01c7\u01c6"+
		"\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01d7\5\26\f\7"+
		"\u01ca\u01cb\f\5\2\2\u01cb\u01cd\t\20\2\2\u01cc\u01ce\7\u00b4\2\2\u01cd"+
		"\u01cc\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d7\5\26"+
		"\f\6\u01d0\u01d1\f\4\2\2\u01d1\u01d3\t\21\2\2\u01d2\u01d4\7\u00b4\2\2"+
		"\u01d3\u01d2\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7"+
		"\5\26\f\4\u01d6\u019a\3\2\2\2\u01d6\u01a0\3\2\2\2\u01d6\u01a6\3\2\2\2"+
		"\u01d6\u01ac\3\2\2\2\u01d6\u01b2\3\2\2\2\u01d6\u01b8\3\2\2\2\u01d6\u01be"+
		"\3\2\2\2\u01d6\u01c4\3\2\2\2\u01d6\u01ca\3\2\2\2\u01d6\u01d0\3\2\2\2\u01d7"+
		"\u01da\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\27\3\2\2"+
		"\2\u01da\u01d8\3\2\2\2\u01db\u01dc\t\22\2\2\u01dc\u01e1\7\u00b0\2\2\u01dd"+
		"\u01de\7\r\2\2\u01de\u01e0\7\u00b0\2\2\u01df\u01dd\3\2\2\2\u01e0\u01e3"+
		"\3\2\2\2\u01e1\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01f3\3\2\2\2\u01e3"+
		"\u01e1\3\2\2\2\u01e4\u01e5\7\n\2\2\u01e5\u01f4\5\32\16\2\u01e6\u01e7\7"+
		"\n\2\2\u01e7\u01e8\7\27\2\2\u01e8\u01ea\5\26\f\2\u01e9\u01eb\7K\2\2\u01ea"+
		"\u01e9\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ee\7q"+
		"\2\2\u01ed\u01ef\7K\2\2\u01ee\u01ed\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef"+
		"\u01f0\3\2\2\2\u01f0\u01f1\5\26\f\2\u01f1\u01f2\7\30\2\2\u01f2\u01f4\3"+
		"\2\2\2\u01f3\u01e4\3\2\2\2\u01f3\u01e6\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4"+
		"\u01f6\3\2\2\2\u01f5\u01f7\7\u00b4\2\2\u01f6\u01f5\3\2\2\2\u01f6\u01f7"+
		"\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\5\26\f\2\u01f9\31\3\2\2\2\u01fa"+
		"\u01fb\t\23\2\2\u01fb\33\3\2\2\2\u01fc\u0282\7r\2\2\u01fd\u0201\7s\2\2"+
		"\u01fe\u01ff\t\24\2\2\u01ff\u0201\7\u00b0\2\2\u0200\u01fd\3\2\2\2\u0200"+
		"\u01fe\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0203\7\u00af\2\2\u0203\u0282"+
		"\7\u00af\2\2\u0204\u0208\t\25\2\2\u0205\u0206\t\24\2\2\u0206\u0208\7\u00b0"+
		"\2\2\u0207\u0204\3\2\2\2\u0207\u0205\3\2\2\2\u0208\u0209\3\2\2\2\u0209"+
		"\u0282\7\u00af\2\2\u020a\u020e\t\26\2\2\u020b\u020c\t\27\2\2\u020c\u020e"+
		"\7\u00b0\2\2\u020d\u020a\3\2\2\2\u020d\u020b\3\2\2\2\u020e\u020f\3\2\2"+
		"\2\u020f\u0282\7\u00af\2\2\u0210\u0214\t\30\2\2\u0211\u0212\t\27\2\2\u0212"+
		"\u0214\7\u00b0\2\2\u0213\u0210\3\2\2\2\u0213\u0211\3\2\2\2\u0214\u0215"+
		"\3\2\2\2\u0215\u0216\7\u00af\2\2\u0216\u0217\7\u00af\2\2\u0217\u0282\7"+
		"\u00af\2\2\u0218\u0219\7|\2\2\u0219\u0282\7\u00af\2\2\u021a\u021b\7}\2"+
		"\2\u021b\u021c\7\u00af\2\2\u021c\u0282\7\u00af\2\2\u021d\u021e\6\17\f"+
		"\2\u021e\u021f\t\31\2\2\u021f\u0220\7\u00b0\2\2\u0220\u0282\7\u00af\2"+
		"\2\u0221\u0222\6\17\r\2\u0222\u0223\t\31\2\2\u0223\u0224\7\u00b0\2\2\u0224"+
		"\u0225\7\u00af\2\2\u0225\u0282\7\u00af\2\2\u0226\u0227\t\32\2\2\u0227"+
		"\u0282\7\u00af\2\2\u0228\u0229\t\33\2\2\u0229\u022a\7\u00af\2\2\u022a"+
		"\u0282\7\u00af\2\2\u022b\u022c\6\17\16\2\u022c\u022d\t\34\2\2\u022d\u022e"+
		"\7\u00b0\2\2\u022e\u0282\7\u00af\2\2\u022f\u0230\6\17\17\2\u0230\u0231"+
		"\t\34\2\2\u0231\u0232\7\u00b0\2\2\u0232\u0233\7\u00af\2\2\u0233\u0282"+
		"\7\u00af\2\2\u0234\u0238\t\35\2\2\u0235\u0236\t\36\2\2\u0236\u0238\7\u00b0"+
		"\2\2\u0237\u0234\3\2\2\2\u0237\u0235\3\2\2\2\u0238\u0239\3\2\2\2\u0239"+
		"\u0282\7\u00af\2\2\u023a\u023b\7\u0084\2\2\u023b\u0282\7\u00af\2\2\u023c"+
		"\u023d\7\u0085\2\2\u023d\u023e\7\u00af\2\2\u023e\u0282\7\u00af\2\2\u023f"+
		"\u0240\7\u0086\2\2\u0240\u0241\7\u00af\2\2\u0241\u0282\7\u00af\2\2\u0242"+
		"\u0246\7\u0087\2\2\u0243\u0245\7\u00af\2\2\u0244\u0243\3\2\2\2\u0245\u0248"+
		"\3\2\2\2\u0246\u0244\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0282\3\2\2\2\u0248"+
		"\u0246\3\2\2\2\u0249\u024a\t\37\2\2\u024a\u0282\7\u00af\2\2\u024b\u024c"+
		"\t \2\2\u024c\u024e\7\u00af\2\2\u024d\u024f\5\26\f\2\u024e\u024d\3\2\2"+
		"\2\u024f\u0250\3\2\2\2\u0250\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0282"+
		"\3\2\2\2\u0252\u0253\6\17\20\2\u0253\u0254\7l\2\2\u0254\u0255\7\u00b0"+
		"\2\2\u0255\u0282\7\u00af\2\2\u0256\u0257\6\17\21\2\u0257\u0258\7l\2\2"+
		"\u0258\u0259\7\u00b0\2\2\u0259\u025b\7\u00af\2\2\u025a\u025c\5\26\f\2"+
		"\u025b\u025a\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025b\3\2\2\2\u025d\u025e"+
		"\3\2\2\2\u025e\u0282\3\2\2\2\u025f\u0260\t!\2\2\u0260\u0262\7\u00af\2"+
		"\2\u0261\u0263\5\26\f\2\u0262\u0261\3\2\2\2\u0263\u0264\3\2\2\2\u0264"+
		"\u0262\3\2\2\2\u0264\u0265\3\2\2\2\u0265\u0282\3\2\2\2\u0266\u0267\t\""+
		"\2\2\u0267\u0268\7\u00af\2\2\u0268\u0282\7\u00af\2\2\u0269\u026a\6\17"+
		"\22\2\u026a\u026b\7p\2\2\u026b\u026c\7\u00b0\2\2\u026c\u026e\7\u00af\2"+
		"\2\u026d\u026f\5\26\f\2\u026e\u026d\3\2\2\2\u026f\u0270\3\2\2\2\u0270"+
		"\u026e\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0282\3\2\2\2\u0272\u0273\6\17"+
		"\23\2\u0273\u0274\7p\2\2\u0274\u0275\7\u00b0\2\2\u0275\u0276\7\u00af\2"+
		"\2\u0276\u0282\7\u00af\2\2\u0277\u0282\7\u0094\2\2\u0278\u0279\7\u0095"+
		"\2\2\u0279\u0282\7\u00b0\2\2\u027a\u027e\7\u0096\2\2\u027b\u027d\7\u00af"+
		"\2\2\u027c\u027b\3\2\2\2\u027d\u0280\3\2\2\2\u027e\u027c\3\2\2\2\u027e"+
		"\u027f\3\2\2\2\u027f\u0282\3\2\2\2\u0280\u027e\3\2\2\2\u0281\u01fc\3\2"+
		"\2\2\u0281\u0200\3\2\2\2\u0281\u0207\3\2\2\2\u0281\u020d\3\2\2\2\u0281"+
		"\u0213\3\2\2\2\u0281\u0218\3\2\2\2\u0281\u021a\3\2\2\2\u0281\u021d\3\2"+
		"\2\2\u0281\u0221\3\2\2\2\u0281\u0226\3\2\2\2\u0281\u0228\3\2\2\2\u0281"+
		"\u022b\3\2\2\2\u0281\u022f\3\2\2\2\u0281\u0237\3\2\2\2\u0281\u023a\3\2"+
		"\2\2\u0281\u023c\3\2\2\2\u0281\u023f\3\2\2\2\u0281\u0242\3\2\2\2\u0281"+
		"\u0249\3\2\2\2\u0281\u024b\3\2\2\2\u0281\u0252\3\2\2\2\u0281\u0256\3\2"+
		"\2\2\u0281\u025f\3\2\2\2\u0281\u0266\3\2\2\2\u0281\u0269\3\2\2\2\u0281"+
		"\u0272\3\2\2\2\u0281\u0277\3\2\2\2\u0281\u0278\3\2\2\2\u0281\u027a\3\2"+
		"\2\2\u0282\35\3\2\2\2\u0283\u0285\7\u00b4\2\2\u0284\u0283\3\2\2\2\u0285"+
		"\u0288\3\2\2\2\u0286\u0284\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0291\3\2"+
		"\2\2\u0288\u0286\3\2\2\2\u0289\u028b\5 \21\2\u028a\u028c\7\u00b4\2\2\u028b"+
		"\u028a\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u028b\3\2\2\2\u028d\u028e\3\2"+
		"\2\2\u028e\u028f\3\2\2\2\u028f\u0290\5.\30\2\u0290\u0292\3\2\2\2\u0291"+
		"\u0289\3\2\2\2\u0291\u0292\3\2\2\2\u0292\37\3\2\2\2\u0293\u0294\7\u0097"+
		"\2\2\u0294\u0295\7\u00b0\2\2\u0295\u0296\7\22\2\2\u0296\u0297\7\u00b0"+
		"\2\2\u0297\u0298\7\22\2\2\u0298\u0299\7\u00b0\2\2\u0299\u029a\7\22\2\2"+
		"\u029a\u029b\7\u0098\2\2\u029b!\3\2\2\2\u029c\u02a0\7\20\2\2\u029d\u029f"+
		"\7\u00b4\2\2\u029e\u029d\3\2\2\2\u029f\u02a2\3\2\2\2\u02a0\u029e\3\2\2"+
		"\2\u02a0\u02a1\3\2\2\2\u02a1\u02a3\3\2\2\2\u02a2\u02a0\3\2\2\2\u02a3\u02a7"+
		"\7\u0095\2\2\u02a4\u02a6\7\u00b4\2\2\u02a5\u02a4\3\2\2\2\u02a6\u02a9\3"+
		"\2\2\2\u02a7\u02a5\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02aa\3\2\2\2\u02a9"+
		"\u02a7\3\2\2\2\u02aa\u02b5\5$\23\2\u02ab\u02ad\7\u00b4\2\2\u02ac\u02ab"+
		"\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02ac\3\2\2\2\u02ae\u02af\3\2\2\2\u02af"+
		"\u02b1\3\2\2\2\u02b0\u02b2\5$\23\2\u02b1\u02b0\3\2\2\2\u02b1\u02b2\3\2"+
		"\2\2\u02b2\u02b4\3\2\2\2\u02b3\u02ac\3\2\2\2\u02b4\u02b7\3\2\2\2\u02b5"+
		"\u02b3\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b8\3\2\2\2\u02b7\u02b5\3\2"+
		"\2\2\u02b8\u02bc\7\21\2\2\u02b9\u02bb\7\u00b4\2\2\u02ba\u02b9\3\2\2\2"+
		"\u02bb\u02be\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd#\3"+
		"\2\2\2\u02be\u02bc\3\2\2\2\u02bf\u02c2\5&\24\2\u02c0\u02c2\5(\25\2\u02c1"+
		"\u02bf\3\2\2\2\u02c1\u02c0\3\2\2\2\u02c2%\3\2\2\2\u02c3\u02c4\7\u00b0"+
		"\2\2\u02c4\u02c5\7\22\2\2\u02c5\u02c6\5\26\f\2\u02c6\'\3\2\2\2\u02c7\u02c8"+
		"\7\u0099\2\2\u02c8\u02ca\7\u00b0\2\2\u02c9\u02cb\7\u00b4\2\2\u02ca\u02c9"+
		"\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02cd\7\27\2\2"+
		"\u02cd\u02d2\5,\27\2\u02ce\u02cf\7\r\2\2\u02cf\u02d1\5,\27\2\u02d0\u02ce"+
		"\3\2\2\2\u02d1\u02d4\3\2\2\2\u02d2\u02d0\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3"+
		"\u02d5\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d5\u02d6\7\30\2\2\u02d6\u02d7\7"+
		"\n\2\2\u02d7\u02e1\5\32\16\2\u02d8\u02da\7\u00b4\2\2\u02d9\u02d8\3\2\2"+
		"\2\u02da\u02dd\3\2\2\2\u02db\u02d9\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02de"+
		"\3\2\2\2\u02dd\u02db\3\2\2\2\u02de\u02e0\5*\26\2\u02df\u02db\3\2\2\2\u02e0"+
		"\u02e3\3\2\2\2\u02e1\u02df\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2)\3\2\2\2"+
		"\u02e3\u02e1\3\2\2\2\u02e4\u02e5\7T\2\2\u02e5\u02e6\5\26\f\2\u02e6\u02ea"+
		"\7\r\2\2\u02e7\u02e9\7\u00b4\2\2\u02e8\u02e7\3\2\2\2\u02e9\u02ec\3\2\2"+
		"\2\u02ea\u02e8\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ed\3\2\2\2\u02ec\u02ea"+
		"\3\2\2\2\u02ed\u02ee\7\u009a\2\2\u02ee\u02ef\5\26\f\2\u02ef\u02f0\7\27"+
		"\2\2\u02f0\u02f1\7\u00b0\2\2\u02f1\u02f2\7\30\2\2\u02f2+\3\2\2\2\u02f3"+
		"\u02f4\7\u00b0\2\2\u02f4\u02f5\7\n\2\2\u02f5\u02f6\5\32\16\2\u02f6-\3"+
		"\2\2\2\u02f7\u02f9\5\60\31\2\u02f8\u02f7\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9"+
		"\u0304\3\2\2\2\u02fa\u02fc\7\u00b4\2\2\u02fb\u02fa\3\2\2\2\u02fc\u02fd"+
		"\3\2\2\2\u02fd\u02fb\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u0300\3\2\2\2\u02ff"+
		"\u0301\5\60\31\2\u0300\u02ff\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u0303\3"+
		"\2\2\2\u0302\u02fb\3\2\2\2\u0303\u0306\3\2\2\2\u0304\u0302\3\2\2\2\u0304"+
		"\u0305\3\2\2\2\u0305/\3\2\2\2\u0306\u0304\3\2\2\2\u0307\u0308\t#\2\2\u0308"+
		"\u0309\7\u00b0\2\2\u0309\u030a\7\n\2\2\u030a\u030b\5\32\16\2\u030b\u030d"+
		"\7T\2\2\u030c\u030e\7\u00b4\2\2\u030d\u030c\3\2\2\2\u030d\u030e\3\2\2"+
		"\2\u030e\u030f\3\2\2\2\u030f\u0310\5:\36\2\u0310\u03a9\3\2\2\2\u0311\u0312"+
		"\7\u00b0\2\2\u0312\u0314\7T\2\2\u0313\u0315\7\u00b4\2\2\u0314\u0313\3"+
		"\2\2\2\u0314\u0315\3\2\2\2\u0315\u0316\3\2\2\2\u0316\u03a9\5:\36\2\u0317"+
		"\u0318\7\23\2\2\u0318\u0319\7\27\2\2\u0319\u031a\5:\36\2\u031a\u031b\7"+
		"\30\2\2\u031b\u03a9\3\2\2\2\u031c\u031d\7\u009d\2\2\u031d\u031e\7\27\2"+
		"\2\u031e\u031f\5:\36\2\u031f\u0320\7\30\2\2\u0320\u03a9\3\2\2\2\u0321"+
		"\u0322\7\u009a\2\2\u0322\u0323\7\27\2\2\u0323\u0324\5:\36\2\u0324\u0328"+
		"\7\30\2\2\u0325\u0327\7\u00b4\2\2\u0326\u0325\3\2\2\2\u0327\u032a\3\2"+
		"\2\2\u0328\u0326\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032b\3\2\2\2\u032a"+
		"\u0328\3\2\2\2\u032b\u032c\7\20\2\2\u032c\u0336\5\62\32\2\u032d\u0331"+
		"\7\u009e\2\2\u032e\u0330\7\u00b4\2\2\u032f\u032e\3\2\2\2\u0330\u0333\3"+
		"\2\2\2\u0331\u032f\3\2\2\2\u0331\u0332\3\2\2\2\u0332\u0334\3\2\2\2\u0333"+
		"\u0331\3\2\2\2\u0334\u0335\7\20\2\2\u0335\u0337\5\62\32\2\u0336\u032d"+
		"\3\2\2\2\u0336\u0337\3\2\2\2\u0337\u03a9\3\2\2\2\u0338\u0339\7\u009f\2"+
		"\2\u0339\u033a\7\27\2\2\u033a\u033b\5:\36\2\u033b\u033f\7\30\2\2\u033c"+
		"\u033e\7\u00b4\2\2\u033d\u033c\3\2\2\2\u033e\u0341\3\2\2\2\u033f\u033d"+
		"\3\2\2\2\u033f\u0340\3\2\2\2\u0340\u0342\3\2\2\2\u0341\u033f\3\2\2\2\u0342"+
		"\u034d\7\20\2\2\u0343\u0345\7\u00b4\2\2\u0344\u0343\3\2\2\2\u0345\u0348"+
		"\3\2\2\2\u0346\u0344\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u0349\3\2\2\2\u0348"+
		"\u0346\3\2\2\2\u0349\u034a\7\u00a0\2\2\u034a\u034b\5<\37\2\u034b\u034c"+
		"\7\u00a1\2\2\u034c\u034e\3\2\2\2\u034d\u0346\3\2\2\2\u034d\u034e\3\2\2"+
		"\2\u034e\u034f\3\2\2\2\u034f\u0350\5\62\32\2\u0350\u03a9\3\2\2\2\u0351"+
		"\u0352\t$\2\2\u0352\u035b\7\27\2\2\u0353\u0358\5\66\34\2\u0354\u0355\7"+
		"\r\2\2\u0355\u0357\5\66\34\2\u0356\u0354\3\2\2\2\u0357\u035a\3\2\2\2\u0358"+
		"\u0356\3\2\2\2\u0358\u0359\3\2\2\2\u0359\u035c\3\2\2\2\u035a\u0358\3\2"+
		"\2\2\u035b\u0353\3\2\2\2\u035b\u035c\3\2\2\2\u035c\u035d\3\2\2\2\u035d"+
		"\u03a9\7\30\2\2\u035e\u035f\7\u00b0\2\2\u035f\u0360\7\27\2\2\u0360\u0361"+
		"\5:\36\2\u0361\u0362\7\30\2\2\u0362\u0364\7T\2\2\u0363\u0365\7\u00b4\2"+
		"\2\u0364\u0363\3\2\2\2\u0364\u0365\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u0367"+
		"\5:\36\2\u0367\u03a9\3\2\2\2\u0368\u0369\7\u00a4\2\2\u0369\u036b\7\u00b0"+
		"\2\2\u036a\u0368\3\2\2\2\u036a\u036b\3\2\2\2\u036b\u036c\3\2\2\2\u036c"+
		"\u036d\7\u0099\2\2\u036d\u036f\7\u00b0\2\2\u036e\u0370\7\u00b4\2\2\u036f"+
		"\u036e\3\2\2\2\u036f\u0370\3\2\2\2\u0370\u0371\3\2\2\2\u0371\u037a\7\27"+
		"\2\2\u0372\u0377\5,\27\2\u0373\u0374\7\r\2\2\u0374\u0376\5,\27\2\u0375"+
		"\u0373\3\2\2\2\u0376\u0379\3\2\2\2\u0377\u0375\3\2\2\2\u0377\u0378\3\2"+
		"\2\2\u0378\u037b\3\2\2\2\u0379\u0377\3\2\2\2\u037a\u0372\3\2\2\2\u037a"+
		"\u037b\3\2\2\2\u037b\u037c\3\2\2\2\u037c\u037d\7\30\2\2\u037d\u0380\7"+
		"\n\2\2\u037e\u0381\5\32\16\2\u037f\u0381\7\u00a5\2\2\u0380\u037e\3\2\2"+
		"\2\u0380\u037f\3\2\2\2\u0381\u0382\3\2\2\2\u0382\u0386\7T\2\2\u0383\u0385"+
		"\7\u00b4\2\2\u0384\u0383\3\2\2\2\u0385\u0388\3\2\2\2\u0386\u0384\3\2\2"+
		"\2\u0386\u0387\3\2\2\2\u0387\u0389\3\2\2\2\u0388\u0386\3\2\2\2\u0389\u039a"+
		"\7\20\2\2\u038a\u038c\7\u00b4\2\2\u038b\u038a\3\2\2\2\u038c\u038f\3\2"+
		"\2\2\u038d\u038b\3\2\2\2\u038d\u038e\3\2\2\2\u038e\u0390\3\2\2\2\u038f"+
		"\u038d\3\2\2\2\u0390\u0391\7\u00a0\2\2\u0391\u0395\5@!\2\u0392\u0394\7"+
		"\u00b4\2\2\u0393\u0392\3\2\2\2\u0394\u0397\3\2\2\2\u0395\u0393\3\2\2\2"+
		"\u0395\u0396\3\2\2\2\u0396\u0398\3\2\2\2\u0397\u0395\3\2\2\2\u0398\u0399"+
		"\7\u00a1\2\2\u0399\u039b\3\2\2\2\u039a\u038d\3\2\2\2\u039a\u039b\3\2\2"+
		"\2\u039b\u039c\3\2\2\2\u039c\u03a9\5\62\32\2\u039d\u03a2\7\u00a0\2\2\u039e"+
		"\u03a3\5\20\t\2\u039f\u03a3\5\16\b\2\u03a0\u03a3\5B\"\2\u03a1\u03a3\5"+
		"\"\22\2\u03a2\u039e\3\2\2\2\u03a2\u039f\3\2\2\2\u03a2\u03a0\3\2\2\2\u03a2"+
		"\u03a1\3\2\2\2\u03a3\u03a4\3\2\2\2\u03a4\u03a5\7\u00a1\2\2\u03a5\u03a9"+
		"\3\2\2\2\u03a6\u03a9\5 \21\2\u03a7\u03a9\5:\36\2\u03a8\u0307\3\2\2\2\u03a8"+
		"\u0311\3\2\2\2\u03a8\u0317\3\2\2\2\u03a8\u031c\3\2\2\2\u03a8\u0321\3\2"+
		"\2\2\u03a8\u0338\3\2\2\2\u03a8\u0351\3\2\2\2\u03a8\u035e\3\2\2\2\u03a8"+
		"\u036a\3\2\2\2\u03a8\u039d\3\2\2\2\u03a8\u03a6\3\2\2\2\u03a8\u03a7\3\2"+
		"\2\2\u03a9\61\3\2\2\2\u03aa\u03b2\5.\30\2\u03ab\u03af\5\64\33\2\u03ac"+
		"\u03ae\7\u00b4\2\2\u03ad\u03ac\3\2\2\2\u03ae\u03b1\3\2\2\2\u03af\u03ad"+
		"\3\2\2\2\u03af\u03b0\3\2\2\2\u03b0\u03b3\3\2\2\2\u03b1\u03af\3\2\2\2\u03b2"+
		"\u03ab\3\2\2\2\u03b2\u03b3\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03b5\7\21"+
		"\2\2\u03b5\63\3\2\2\2\u03b6\u03b8\7\u00a6\2\2\u03b7\u03b9\5:\36\2\u03b8"+
		"\u03b7\3\2\2\2\u03b8\u03b9\3\2\2\2\u03b9\65\3\2\2\2\u03ba\u03bd\7\u00b9"+
		"\2\2\u03bb\u03bd\5:\36\2\u03bc\u03ba\3\2\2\2\u03bc\u03bb\3\2\2\2\u03bd"+
		"\67\3\2\2\2\u03be\u03e4\t\6\2\2\u03bf\u03e4\7\u00af\2\2\u03c0\u03e4\7"+
		"\u00b0\2\2\u03c1\u03c2\t\b\2\2\u03c2\u03c3\7\22\2\2\u03c3\u03c4\7\u00b0"+
		"\2\2\u03c4\u03cd\7\27\2\2\u03c5\u03ca\5:\36\2\u03c6\u03c7\7\r\2\2\u03c7"+
		"\u03c9\5:\36\2\u03c8\u03c6\3\2\2\2\u03c9\u03cc\3\2\2\2\u03ca\u03c8\3\2"+
		"\2\2\u03ca\u03cb\3\2\2\2\u03cb\u03ce\3\2\2\2\u03cc\u03ca\3\2\2\2\u03cd"+
		"\u03c5\3\2\2\2\u03cd\u03ce\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf\u03e4\7\30"+
		"\2\2\u03d0\u03d1\t\23\2\2\u03d1\u03d2\7\22\2\2\u03d2\u03e4\7\u00b0\2\2"+
		"\u03d3\u03e4\7\u00ba\2\2\u03d4\u03e4\7\u00b2\2\2\u03d5\u03e4\7\u00b1\2"+
		"\2\u03d6\u03d7\t\b\2\2\u03d7\u03e0\7\27\2\2\u03d8\u03dd\5:\36\2\u03d9"+
		"\u03da\7\r\2\2\u03da\u03dc\5:\36\2\u03db\u03d9\3\2\2\2\u03dc\u03df\3\2"+
		"\2\2\u03dd\u03db\3\2\2\2\u03dd\u03de\3\2\2\2\u03de\u03e1\3\2\2\2\u03df"+
		"\u03dd\3\2\2\2\u03e0\u03d8\3\2\2\2\u03e0\u03e1\3\2\2\2\u03e1\u03e2\3\2"+
		"\2\2\u03e2\u03e4\7\30\2\2\u03e3\u03be\3\2\2\2\u03e3\u03bf\3\2\2\2\u03e3"+
		"\u03c0\3\2\2\2\u03e3\u03c1\3\2\2\2\u03e3\u03d0\3\2\2\2\u03e3\u03d3\3\2"+
		"\2\2\u03e3\u03d4\3\2\2\2\u03e3\u03d5\3\2\2\2\u03e3\u03d6\3\2\2\2\u03e4"+
		"9\3\2\2\2\u03e5\u03e6\b\36\1\2\u03e6\u03e7\7\u00b0\2\2\u03e7\u03f0\7\27"+
		"\2\2\u03e8\u03ed\5:\36\2\u03e9\u03ea\7\r\2\2\u03ea\u03ec\5:\36\2\u03eb"+
		"\u03e9\3\2\2\2\u03ec\u03ef\3\2\2\2\u03ed\u03eb\3\2\2\2\u03ed\u03ee\3\2"+
		"\2\2\u03ee\u03f1\3\2\2\2\u03ef\u03ed\3\2\2\2\u03f0\u03e8\3\2\2\2\u03f0"+
		"\u03f1\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2\u040b\7\30\2\2\u03f3\u03f8\5"+
		"8\35\2\u03f4\u03f5\7\22\2\2\u03f5\u03f7\7\u00b0\2\2\u03f6\u03f4\3\2\2"+
		"\2\u03f7\u03fa\3\2\2\2\u03f8\u03f6\3\2\2\2\u03f8\u03f9\3\2\2\2\u03f9\u040b"+
		"\3\2\2\2\u03fa\u03f8\3\2\2\2\u03fb\u03fc\7\u00a7\2\2\u03fc\u03fd\7\27"+
		"\2\2\u03fd\u040b\7\30\2\2\u03fe\u03ff\7\u00a8\2\2\u03ff\u0401\7\27\2\2"+
		"\u0400\u0402\7\u00b9\2\2\u0401\u0400\3\2\2\2\u0401\u0402\3\2\2\2\u0402"+
		"\u0403\3\2\2\2\u0403\u040b\7\30\2\2\u0404\u0405\7\27\2\2\u0405\u0406\5"+
		":\36\2\u0406\u0407\7\30\2\2\u0407\u040b\3\2\2\2\u0408\u0409\t%\2\2\u0409"+
		"\u040b\5:\36\f\u040a\u03e5\3\2\2\2\u040a\u03f3\3\2\2\2\u040a\u03fb\3\2"+
		"\2\2\u040a\u03fe\3\2\2\2\u040a\u0404\3\2\2\2\u040a\u0408\3\2\2\2\u040b"+
		"\u0444\3\2\2\2\u040c\u040d\f\13\2\2\u040d\u040f\t\n\2\2\u040e\u0410\7"+
		"\u00b4\2\2\u040f\u040e\3\2\2\2\u040f\u0410\3\2\2\2\u0410\u0411\3\2\2\2"+
		"\u0411\u0443\5:\36\f\u0412\u0413\f\n\2\2\u0413\u0415\t\13\2\2\u0414\u0416"+
		"\7\u00b4\2\2\u0415\u0414\3\2\2\2\u0415\u0416\3\2\2\2\u0416\u0417\3\2\2"+
		"\2\u0417\u0443\5:\36\13\u0418\u0419\f\t\2\2\u0419\u041b\7I\2\2\u041a\u041c"+
		"\7\u00b4\2\2\u041b\u041a\3\2\2\2\u041b\u041c\3\2\2\2\u041c\u041d\3\2\2"+
		"\2\u041d\u0443\5:\36\t\u041e\u041f\f\b\2\2\u041f\u0421\7J\2\2\u0420\u0422"+
		"\7\u00b4\2\2\u0421\u0420\3\2\2\2\u0421\u0422\3\2\2\2\u0422\u0423\3\2\2"+
		"\2\u0423\u0443\5:\36\t\u0424\u0425\f\7\2\2\u0425\u0427\t&\2\2\u0426\u0428"+
		"\7\u00b4\2\2\u0427\u0426\3\2\2\2\u0427\u0428\3\2\2\2\u0428\u0429\3\2\2"+
		"\2\u0429\u0443\5:\36\b\u042a\u042b\f\6\2\2\u042b\u042d\t\'\2\2\u042c\u042e"+
		"\7\u00b4\2\2\u042d\u042c\3\2\2\2\u042d\u042e\3\2\2\2\u042e\u042f\3\2\2"+
		"\2\u042f\u0443\5:\36\7\u0430\u0431\f\5\2\2\u0431\u0433\7^\2\2\u0432\u0434"+
		"\7\u00b4\2\2\u0433\u0432\3\2\2\2\u0433\u0434\3\2\2\2\u0434\u0435\3\2\2"+
		"\2\u0435\u0443\5:\36\6\u0436\u0437\f\4\2\2\u0437\u0439\7b\2\2\u0438\u043a"+
		"\7\u00b4\2\2\u0439\u0438\3\2\2\2\u0439\u043a\3\2\2\2\u043a\u043b\3\2\2"+
		"\2\u043b\u0443\5:\36\5\u043c\u043d\f\3\2\2\u043d\u043f\7\4\2\2\u043e\u0440"+
		"\7\u00b4\2\2\u043f\u043e\3\2\2\2\u043f\u0440\3\2\2\2\u0440\u0441\3\2\2"+
		"\2\u0441\u0443\5:\36\4\u0442\u040c\3\2\2\2\u0442\u0412\3\2\2\2\u0442\u0418"+
		"\3\2\2\2\u0442\u041e\3\2\2\2\u0442\u0424\3\2\2\2\u0442\u042a\3\2\2\2\u0442"+
		"\u0430\3\2\2\2\u0442\u0436\3\2\2\2\u0442\u043c\3\2\2\2\u0443\u0446\3\2"+
		"\2\2\u0444\u0442\3\2\2\2\u0444\u0445\3\2\2\2\u0445;\3\2\2\2\u0446\u0444"+
		"\3\2\2\2\u0447\u044b\7\20\2\2\u0448\u044a\7\u00b4\2\2\u0449\u0448\3\2"+
		"\2\2\u044a\u044d\3\2\2\2\u044b\u0449\3\2\2\2\u044b\u044c\3\2\2\2\u044c"+
		"\u044e\3\2\2\2\u044d\u044b\3\2\2\2\u044e\u044f\5> \2\u044f\u0453\7\21"+
		"\2\2\u0450\u0452\7\u00b4\2\2\u0451\u0450\3\2\2\2\u0452\u0455\3\2\2\2\u0453"+
		"\u0451\3\2\2\2\u0453\u0454\3\2\2\2\u0454\u047d\3\2\2\2\u0455\u0453\3\2"+
		"\2\2\u0456\u045a\7\20\2\2\u0457\u0459\7\u00b4\2\2\u0458\u0457\3\2\2\2"+
		"\u0459\u045c\3\2\2\2\u045a\u0458\3\2\2\2\u045a\u045b\3\2\2\2\u045b\u045d"+
		"\3\2\2\2\u045c\u045a\3\2\2\2\u045d\u0461\7\u0094\2\2\u045e\u0460\7\u00b4"+
		"\2\2\u045f\u045e\3\2\2\2\u0460\u0463\3\2\2\2\u0461\u045f\3\2\2\2\u0461"+
		"\u0462\3\2\2\2\u0462\u0464\3\2\2\2\u0463\u0461\3\2\2\2\u0464\u046f\5\26"+
		"\f\2\u0465\u0467\7\u00b4\2\2\u0466\u0465\3\2\2\2\u0467\u0468\3\2\2\2\u0468"+
		"\u0466\3\2\2\2\u0468\u0469\3\2\2\2\u0469\u046b\3\2\2\2\u046a\u046c\5\26"+
		"\f\2\u046b\u046a\3\2\2\2\u046b\u046c\3\2\2\2\u046c\u046e\3\2\2\2\u046d"+
		"\u0466\3\2\2\2\u046e\u0471\3\2\2\2\u046f\u046d\3\2\2\2\u046f\u0470\3\2"+
		"\2\2\u0470\u0473\3\2\2\2\u0471\u046f\3\2\2\2\u0472\u0474\5> \2\u0473\u0472"+
		"\3\2\2\2\u0473\u0474\3\2\2\2\u0474\u0475\3\2\2\2\u0475\u0479\7\21\2\2"+
		"\u0476\u0478\7\u00b4\2\2\u0477\u0476\3\2\2\2\u0478\u047b\3\2\2\2\u0479"+
		"\u0477\3\2\2\2\u0479\u047a\3\2\2\2\u047a\u047d\3\2\2\2\u047b\u0479\3\2"+
		"\2\2\u047c\u0447\3\2\2\2\u047c\u0456\3\2\2\2\u047d=\3\2\2\2\u047e\u047f"+
		"\7\u00a9\2\2\u047f\u0484\7\u00b0\2\2\u0480\u0481\7\r\2\2\u0481\u0483\7"+
		"\u00b0\2\2\u0482\u0480\3\2\2\2\u0483\u0486\3\2\2\2\u0484\u0482\3\2\2\2"+
		"\u0484\u0485\3\2\2\2\u0485\u048a\3\2\2\2\u0486\u0484\3\2\2\2\u0487\u0489"+
		"\7\u00b4\2\2\u0488\u0487\3\2\2\2\u0489\u048c\3\2\2\2\u048a\u0488\3\2\2"+
		"\2\u048a\u048b\3\2\2\2\u048b?\3\2\2\2\u048c\u048a\3\2\2\2\u048d\u0491"+
		"\7\20\2\2\u048e\u0490\7\u00b4\2\2\u048f\u048e\3\2\2\2\u0490\u0493\3\2"+
		"\2\2\u0491\u048f\3\2\2\2\u0491\u0492\3\2\2\2\u0492\u04a9\3\2\2\2\u0493"+
		"\u0491\3\2\2\2\u0494\u0498\t(\2\2\u0495\u0497\7\u00b4\2\2\u0496\u0495"+
		"\3\2\2\2\u0497\u049a\3\2\2\2\u0498\u0496\3\2\2\2\u0498\u0499\3\2\2\2\u0499"+
		"\u049b\3\2\2\2\u049a\u0498\3\2\2\2\u049b\u04a6\5\26\f\2\u049c\u049e\7"+
		"\u00b4\2\2\u049d\u049c\3\2\2\2\u049e\u049f\3\2\2\2\u049f\u049d\3\2\2\2"+
		"\u049f\u04a0\3\2\2\2\u04a0\u04a2\3\2\2\2\u04a1\u04a3\5\26\f\2\u04a2\u04a1"+
		"\3\2\2\2\u04a2\u04a3\3\2\2\2\u04a3\u04a5\3\2\2\2\u04a4\u049d\3\2\2\2\u04a5"+
		"\u04a8\3\2\2\2\u04a6\u04a4\3\2\2\2\u04a6\u04a7\3\2\2\2\u04a7\u04aa\3\2"+
		"\2\2\u04a8\u04a6\3\2\2\2\u04a9\u0494\3\2\2\2\u04a9\u04aa\3\2\2\2\u04aa"+
		"\u04ae\3\2\2\2\u04ab\u04ad\7\u00b4\2\2\u04ac\u04ab\3\2\2\2\u04ad\u04b0"+
		"\3\2\2\2\u04ae\u04ac\3\2\2\2\u04ae\u04af\3\2\2\2\u04af\u04b2\3\2\2\2\u04b0"+
		"\u04ae\3\2\2\2\u04b1\u04b3\5> \2\u04b2\u04b1\3\2\2\2\u04b2\u04b3\3\2\2"+
		"\2\u04b3\u04c9\3\2\2\2\u04b4\u04b8\t)\2\2\u04b5\u04b7\7\u00b4\2\2\u04b6"+
		"\u04b5\3\2\2\2\u04b7\u04ba\3\2\2\2\u04b8\u04b6\3\2\2\2\u04b8\u04b9\3\2"+
		"\2\2\u04b9\u04bb\3\2\2\2\u04ba\u04b8\3\2\2\2\u04bb\u04c6\5\26\f\2\u04bc"+
		"\u04be\7\u00b4\2\2\u04bd\u04bc\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf\u04bd"+
		"\3\2\2\2\u04bf\u04c0\3\2\2\2\u04c0\u04c2\3\2\2\2\u04c1\u04c3\5\26\f\2"+
		"\u04c2\u04c1\3\2\2\2\u04c2\u04c3\3\2\2\2\u04c3\u04c5\3\2\2\2\u04c4\u04bd"+
		"\3\2\2\2\u04c5\u04c8\3\2\2\2\u04c6\u04c4\3\2\2\2\u04c6\u04c7\3\2\2\2\u04c7"+
		"\u04ca\3\2\2\2\u04c8\u04c6\3\2\2\2\u04c9\u04b4\3\2\2\2\u04c9\u04ca\3\2"+
		"\2\2\u04ca\u04ce\3\2\2\2\u04cb\u04cd\7\u00b4\2\2\u04cc\u04cb\3\2\2\2\u04cd"+
		"\u04d0\3\2\2\2\u04ce\u04cc\3\2\2\2\u04ce\u04cf\3\2\2\2\u04cf\u04d1\3\2"+
		"\2\2\u04d0\u04ce\3\2\2\2\u04d1\u04d5\7\21\2\2\u04d2\u04d4\7\u00b4\2\2"+
		"\u04d3\u04d2\3\2\2\2\u04d4\u04d7\3\2\2\2\u04d5\u04d3\3\2\2\2\u04d5\u04d6"+
		"\3\2\2\2\u04d6A\3\2\2\2\u04d7\u04d5\3\2\2\2\u04d8\u04dc\7\20\2\2\u04d9"+
		"\u04db\7\u00b4\2\2\u04da\u04d9\3\2\2\2\u04db\u04de\3\2\2\2\u04dc\u04da"+
		"\3\2\2\2\u04dc\u04dd\3\2\2\2\u04dd\u04df\3\2\2\2\u04de\u04dc\3\2\2\2\u04df"+
		"\u04e3\7\u0094\2\2\u04e0\u04e2\7\u00b4\2\2\u04e1\u04e0\3\2\2\2\u04e2\u04e5"+
		"\3\2\2\2\u04e3\u04e1\3\2\2\2\u04e3\u04e4\3\2\2\2\u04e4\u04e6\3\2\2\2\u04e5"+
		"\u04e3\3\2\2\2\u04e6\u04f1\5\26\f\2\u04e7\u04e9\7\u00b4\2\2\u04e8\u04e7"+
		"\3\2\2\2\u04e9\u04ea\3\2\2\2\u04ea\u04e8\3\2\2\2\u04ea\u04eb\3\2\2\2\u04eb"+
		"\u04ed\3\2\2\2\u04ec\u04ee\5\26\f\2\u04ed\u04ec\3\2\2\2\u04ed\u04ee\3"+
		"\2\2\2\u04ee\u04f0\3\2\2\2\u04ef\u04e8\3\2\2\2\u04f0\u04f3\3\2\2\2\u04f1"+
		"\u04ef\3\2\2\2\u04f1\u04f2\3\2\2\2\u04f2\u04f4\3\2\2\2\u04f3\u04f1\3\2"+
		"\2\2\u04f4\u04f8\7\21\2\2\u04f5\u04f7\7\u00b4\2\2\u04f6\u04f5\3\2\2\2"+
		"\u04f7\u04fa\3\2\2\2\u04f8\u04f6\3\2\2\2\u04f8\u04f9\3\2\2\2\u04f9C\3"+
		"\2\2\2\u04fa\u04f8\3\2\2\2\u00b7JQUZbgnty\u0080\u0086\u008b\u0091\u0097"+
		"\u009a\u009f\u00a5\u00ac\u00b5\u00bd\u00c3\u00c9\u00d1\u00d7\u00da\u00e0"+
		"\u00e9\u00ec\u00f4\u00fa\u0101\u0103\u0107\u010c\u010f\u0113\u011a\u0127"+
		"\u012e\u0136\u013e\u0143\u0148\u014b\u014f\u0153\u0161\u016e\u0182\u0185"+
		"\u0188\u0190\u0198\u019d\u01a3\u01a9\u01af\u01b5\u01bb\u01c1\u01c7\u01cd"+
		"\u01d3\u01d6\u01d8\u01e1\u01ea\u01ee\u01f3\u01f6\u0200\u0207\u020d\u0213"+
		"\u0237\u0246\u0250\u025d\u0264\u0270\u027e\u0281\u0286\u028d\u0291\u02a0"+
		"\u02a7\u02ae\u02b1\u02b5\u02bc\u02c1\u02ca\u02d2\u02db\u02e1\u02ea\u02f8"+
		"\u02fd\u0300\u0304\u030d\u0314\u0328\u0331\u0336\u033f\u0346\u034d\u0358"+
		"\u035b\u0364\u036a\u036f\u0377\u037a\u0380\u0386\u038d\u0395\u039a\u03a2"+
		"\u03a8\u03af\u03b2\u03b8\u03bc\u03ca\u03cd\u03dd\u03e0\u03e3\u03ed\u03f0"+
		"\u03f8\u0401\u040a\u040f\u0415\u041b\u0421\u0427\u042d\u0433\u0439\u043f"+
		"\u0442\u0444\u044b\u0453\u045a\u0461\u0468\u046b\u046f\u0473\u0479\u047c"+
		"\u0484\u048a\u0491\u0498\u049f\u04a2\u04a6\u04a9\u04ae\u04b2\u04b8\u04bf"+
		"\u04c2\u04c6\u04c9\u04ce\u04d5\u04dc\u04e3\u04ea\u04ed\u04f1\u04f8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}