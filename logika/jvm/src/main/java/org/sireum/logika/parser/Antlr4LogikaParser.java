// Generated from /Users/robby/Repositories/Sireum/sireum-v3/logika/jvm/src/main/resources/org/sireum/logika/parser/Antlr4Logika.g4 by ANTLR 4.5.3
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
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

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
		WS=181, STRING=182, FLOAT=183, ERROR_CHAR=184;
	public static final int
		RULE_file = 0, RULE_truthTable = 1, RULE_row = 2, RULE_bool = 3, RULE_status = 4, 
		RULE_assignments = 5, RULE_sequent = 6, RULE_proof = 7, RULE_proofStep = 8, 
		RULE_primFormula = 9, RULE_formula = 10, RULE_qformula = 11, RULE_type = 12, 
		RULE_justification = 13, RULE_program = 14, RULE_impor = 15, RULE_facts = 16, 
		RULE_factOrFun = 17, RULE_fact = 18, RULE_fun = 19, RULE_funDef = 20, 
		RULE_param = 21, RULE_stmts = 22, RULE_stmt = 23, RULE_stringOrExp = 24, 
		RULE_primExp = 25, RULE_exp = 26, RULE_loopInvariant = 27, RULE_modifies = 28, 
		RULE_methodContract = 29, RULE_invariants = 30;
	public static final String[] ruleNames = {
		"file", "truthTable", "row", "bool", "status", "assignments", "sequent", 
		"proof", "proofStep", "primFormula", "formula", "qformula", "type", "justification", 
		"program", "impor", "facts", "factOrFun", "fact", "fun", "funDef", "param", 
		"stmts", "stmt", "stringOrExp", "primExp", "exp", "loopInvariant", "modifies", 
		"methodContract", "invariants"
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
		"NL", "LINE_COMMENT", "COMMENT", "WS", "STRING", "FLOAT", "ERROR_CHAR"
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
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new TruthTableFileContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				truthTable();
				setState(63);
				match(EOF);
				}
				break;
			case 2:
				_localctx = new SequentFileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				sequent();
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(66);
						match(NL);
						}
						} 
					}
					setState(71);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				}
				setState(73);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(72);
					proof();
					}
				}

				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(75);
					match(NL);
					}
					}
					setState(80);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(81);
				match(EOF);
				}
				break;
			case 3:
				_localctx = new ProgramFileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				program();
				setState(84);
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
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(88);
				match(NL);
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			((TruthTableContext)_localctx).star = match(T__0);
			setState(96); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(95);
				match(NL);
				}
				}
				setState(98); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(100);
			match(HLINE);
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				match(NL);
				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(107); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(106);
				((TruthTableContext)_localctx).ID = match(ID);
				((TruthTableContext)_localctx).vars.add(((TruthTableContext)_localctx).ID);
				}
				}
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(111);
			((TruthTableContext)_localctx).bar = match(T__1);
			setState(112);
			formula(0);
			setState(114); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(113);
				match(NL);
				}
				}
				setState(116); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(118);
			match(HLINE);
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(120); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(119);
						match(NL);
						}
						}
						setState(122); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NL );
					setState(124);
					row();
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(131); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(130);
				match(NL);
				}
				}
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(135);
			match(HLINE);
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(137); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(136);
					match(NL);
					}
					}
					setState(139); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NL );
				setState(141);
				status();
				}
				break;
			}
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
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) {
				{
				{
				setState(150);
				((RowContext)_localctx).bool = bool();
				((RowContext)_localctx).model.add(((RowContext)_localctx).bool);
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
			((RowContext)_localctx).bar = match(T__1);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) {
				{
				{
				setState(157);
				((RowContext)_localctx).bool = bool();
				((RowContext)_localctx).eval.add(((RowContext)_localctx).bool);
				}
				}
				setState(162);
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
			setState(163);
			((BoolContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) ) {
				((BoolContext)_localctx).t = (Token)_errHandler.recoverInline(this);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(ID);
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(166);
					match(NL);
					}
					}
					setState(169); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NL );
				setState(171);
				((StatusContext)_localctx).t = match(T__6);
				setState(172);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__3) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(173);
				match(T__7);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(174);
					((StatusContext)_localctx).assignments = assignments();
					((StatusContext)_localctx).tContingentAssignments.add(((StatusContext)_localctx).assignments);
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(181); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(180);
					match(NL);
					}
					}
					setState(183); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NL );
				setState(185);
				match(T__6);
				setState(186);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(187);
				match(T__7);
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(188);
					((StatusContext)_localctx).assignments = assignments();
					((StatusContext)_localctx).fContingentAssignments.add(((StatusContext)_localctx).assignments);
					}
					}
					setState(193);
					_errHandler.sync(this);
					_la = _input.LA(1);
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
			setState(196);
			match(T__8);
			setState(198); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(197);
				bool();
				}
				}
				setState(200); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0) );
			setState(202);
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
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
					{
					setState(204);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(205);
						match(T__10);
						setState(206);
						((SequentContext)_localctx).formula = formula(0);
						((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
						}
						}
						setState(211);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(214);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__12) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(215);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(216);
					match(T__10);
					setState(217);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
					{
					{
					setState(223);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(229);
				match(HLINE);
				setState(231); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(230);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(233); 
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
			setState(237);
			((ProofContext)_localctx).tb = match(T__13);
			setState(239);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(238);
				proofStep();
				}
			}

			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(242); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(241);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(244); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(247);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(246);
					proofStep();
					}
				}

				}
				}
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(254);
			((ProofContext)_localctx).te = match(T__14);
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(255);
					match(NL);
					}
					} 
				}
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				match(NUM);
				setState(262);
				match(T__15);
				setState(263);
				formula(0);
				setState(264);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(267);
				match(T__15);
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(268);
					match(NL);
					}
					}
					setState(273);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(274);
				match(T__13);
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(275);
					match(NL);
					}
					}
					setState(280);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(281);
				((SubProofContext)_localctx).assume = match(NUM);
				setState(282);
				match(T__15);
				setState(299);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(283);
					match(ID);
					setState(286);
					_la = _input.LA(1);
					if (_la==T__7) {
						{
						setState(284);
						match(T__7);
						setState(285);
						type();
						}
					}

					}
					break;
				case 2:
					{
					setState(288);
					formula(0);
					setState(289);
					((SubProofContext)_localctx).ate = match(T__16);
					}
					break;
				case 3:
					{
					setState(291);
					match(ID);
					setState(294);
					_la = _input.LA(1);
					if (_la==T__7) {
						{
						setState(292);
						match(T__7);
						setState(293);
						type();
						}
					}

					setState(296);
					formula(0);
					setState(297);
					((SubProofContext)_localctx).ate = match(T__16);
					}
					break;
				}
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(302); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(301);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(304); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(307);
					_la = _input.LA(1);
					if (_la==NUM) {
						{
						setState(306);
						proofStep();
						}
					}

					}
					}
					setState(313);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(314);
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
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				((BooleanContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
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
				setState(318);
				match(T__20);
				setState(319);
				formula(0);
				setState(320);
				match(T__21);
				}
				break;
			case 3:
				_localctx = new ApplyResultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(322);
				((ApplyResultContext)_localctx).tb = match(T__22);
				setState(323);
				match(T__20);
				setState(324);
				formula(0);
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(325);
					match(T__10);
					setState(326);
					formula(0);
					}
					}
					setState(331);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(332);
				match(T__21);
				}
				break;
			case 4:
				_localctx = new ResultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(334);
				match(T__22);
				}
				break;
			case 5:
				_localctx = new ApplyContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(335);
				match(ID);
				setState(336);
				match(T__20);
				setState(337);
				formula(0);
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(338);
					match(T__10);
					setState(339);
					formula(0);
					}
					}
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(345);
				match(T__21);
				}
				break;
			case 6:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(347);
				((VarContext)_localctx).tb = match(ID);
				}
				break;
			case 7:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(348);
				match(NUM);
				}
				break;
			case 8:
				_localctx = new IntLitContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(349);
				match(INT);
				}
				break;
			case 9:
				_localctx = new RLitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(350);
				match(REAL);
				}
				break;
			case 10:
				_localctx = new FloatLitContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(351);
				match(FLOAT);
				}
				break;
			case 11:
				_localctx = new TypeAccessContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(352);
				((TypeAccessContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0)) ) {
					((TypeAccessContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(353);
				match(T__15);
				setState(354);
				match(ID);
				}
				break;
			case 12:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(355);
				((SeqContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (T__45 - 46)) | (1L << (T__46 - 46)) | (1L << (T__47 - 46)) | (1L << (T__48 - 46)) | (1L << (T__49 - 46)) | (1L << (T__50 - 46)) | (1L << (T__51 - 46)) | (1L << (T__52 - 46)) | (1L << (T__53 - 46)) | (1L << (T__54 - 46)) | (1L << (T__55 - 46)) | (1L << (T__56 - 46)) | (1L << (T__57 - 46)) | (1L << (T__58 - 46)) | (1L << (T__59 - 46)) | (1L << (T__60 - 46)) | (1L << (T__61 - 46)) | (1L << (T__62 - 46)) | (1L << (T__63 - 46)) | (1L << (T__64 - 46)) | (1L << (T__65 - 46)) | (1L << (T__66 - 46)))) != 0)) ) {
					((SeqContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(356);
				match(T__20);
				setState(365);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(357);
					exp(0);
					setState(362);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(358);
						match(T__10);
						setState(359);
						exp(0);
						}
						}
						setState(364);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(367);
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
			setState(384);
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

				setState(371);
				primFormula();
				setState(376);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(372);
						match(T__15);
						setState(373);
						match(ID);
						}
						} 
					}
					setState(378);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
				}
				}
				break;
			case T__6:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(379);
				((UnaryContext)_localctx).op = match(T__6);
				setState(380);
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
				setState(381);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (T__85 - 86)) | (1L << (T__86 - 86)) | (1L << (T__87 - 86)) | (1L << (T__88 - 86)) | (1L << (T__89 - 86)))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(382);
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
				setState(383);
				qformula();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(448);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(446);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(386);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(387);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__67 || _la==T__68) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(389);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(388);
							match(NL);
							}
						}

						setState(391);
						((BinaryContext)_localctx).r = formula(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(392);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(393);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__69) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(395);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(394);
							match(NL);
							}
						}

						setState(397);
						((BinaryContext)_localctx).r = formula(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(398);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(399);
						((BinaryContext)_localctx).op = match(T__70);
						setState(401);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(400);
							match(NL);
							}
						}

						setState(403);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(404);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(405);
						((BinaryContext)_localctx).op = match(T__71);
						setState(407);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(406);
							match(NL);
							}
						}

						setState(409);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(410);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(411);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__74 - 73)) | (1L << (T__75 - 73)) | (1L << (T__76 - 73)) | (1L << (T__77 - 73)) | (1L << (T__78 - 73)) | (1L << (T__79 - 73)) | (1L << (T__80 - 73)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(413);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(412);
							match(NL);
							}
						}

						setState(415);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(416);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(417);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (T__81 - 82)) | (1L << (T__82 - 82)) | (1L << (T__83 - 82)) | (1L << (T__84 - 82)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(419);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(418);
							match(NL);
							}
						}

						setState(421);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(422);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(423);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (T__90 - 91)) | (1L << (T__91 - 91)) | (1L << (T__92 - 91)) | (1L << (T__93 - 91)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(425);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(424);
							match(NL);
							}
						}

						setState(427);
						((BinaryContext)_localctx).r = formula(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(428);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(429);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__94 || _la==T__95) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(431);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(430);
							match(NL);
							}
						}

						setState(433);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(434);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(435);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__1 || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (T__96 - 97)) | (1L << (T__97 - 97)) | (1L << (T__98 - 97)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(437);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(436);
							match(NL);
							}
						}

						setState(439);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 10:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(440);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(441);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (T__99 - 100)) | (1L << (T__100 - 100)) | (1L << (T__101 - 100)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(443);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(442);
							match(NL);
							}
						}

						setState(445);
						((BinaryContext)_localctx).r = formula(2);
						}
						break;
					}
					} 
				}
				setState(450);
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
		enterRule(_localctx, 22, RULE_qformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (T__102 - 103)) | (1L << (T__103 - 103)) | (1L << (T__104 - 103)) | (1L << (T__105 - 103)) | (1L << (T__106 - 103)) | (1L << (T__107 - 103)) | (1L << (T__108 - 103)) | (1L << (T__109 - 103)))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(452);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(453);
				match(T__10);
				setState(454);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(475);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(460);
				match(T__7);
				setState(461);
				type();
				}
				break;
			case 2:
				{
				setState(462);
				match(T__7);
				setState(463);
				match(T__20);
				setState(464);
				((QformulaContext)_localctx).lo = exp(0);
				setState(466);
				_la = _input.LA(1);
				if (_la==T__72) {
					{
					setState(465);
					((QformulaContext)_localctx).ll = match(T__72);
					}
				}

				setState(468);
				match(T__110);
				setState(470);
				_la = _input.LA(1);
				if (_la==T__72) {
					{
					setState(469);
					((QformulaContext)_localctx).lh = match(T__72);
					}
				}

				setState(472);
				((QformulaContext)_localctx).hi = exp(0);
				setState(473);
				match(T__21);
				}
				break;
			}
			setState(478);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(477);
				match(NL);
				}
			}

			setState(480);
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
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			((TypeContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & ((1L << (T__23 - 24)) | (1L << (T__24 - 24)) | (1L << (T__25 - 24)) | (1L << (T__26 - 24)) | (1L << (T__27 - 24)) | (1L << (T__28 - 24)) | (1L << (T__29 - 24)) | (1L << (T__30 - 24)) | (1L << (T__31 - 24)) | (1L << (T__32 - 24)) | (1L << (T__33 - 24)) | (1L << (T__34 - 24)) | (1L << (T__35 - 24)) | (1L << (T__36 - 24)) | (1L << (T__37 - 24)) | (1L << (T__38 - 24)) | (1L << (T__39 - 24)) | (1L << (T__40 - 24)) | (1L << (T__41 - 24)) | (1L << (T__42 - 24)) | (1L << (T__43 - 24)) | (1L << (T__44 - 24)) | (1L << (T__45 - 24)) | (1L << (T__46 - 24)) | (1L << (T__47 - 24)) | (1L << (T__48 - 24)) | (1L << (T__49 - 24)) | (1L << (T__50 - 24)) | (1L << (T__51 - 24)) | (1L << (T__52 - 24)) | (1L << (T__53 - 24)) | (1L << (T__54 - 24)) | (1L << (T__55 - 24)) | (1L << (T__56 - 24)) | (1L << (T__57 - 24)) | (1L << (T__58 - 24)) | (1L << (T__59 - 24)) | (1L << (T__60 - 24)) | (1L << (T__61 - 24)) | (1L << (T__62 - 24)) | (1L << (T__63 - 24)) | (1L << (T__64 - 24)) | (1L << (T__65 - 24)) | (1L << (T__66 - 24)))) != 0)) ) {
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
		enterRule(_localctx, 26, RULE_justification);
		int _la;
		try {
			setState(617);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(484);
				((PremiseContext)_localctx).t = match(T__111);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(488);
				switch (_input.LA(1)) {
				case T__112:
					{
					setState(485);
					((AndIntroContext)_localctx).tb = match(T__112);
					}
					break;
				case T__91:
				case T__92:
				case T__93:
					{
					setState(486);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (T__91 - 92)) | (1L << (T__92 - 92)) | (1L << (T__93 - 92)))) != 0)) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(487);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(490);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(491);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(495);
				switch (_input.LA(1)) {
				case T__113:
				case T__114:
					{
					setState(492);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__113 || _la==T__114) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__91:
				case T__92:
				case T__93:
					{
					setState(493);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (T__91 - 92)) | (1L << (T__92 - 92)) | (1L << (T__93 - 92)))) != 0)) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(494);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(497);
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(501);
				switch (_input.LA(1)) {
				case T__115:
				case T__116:
				case T__117:
				case T__118:
					{
					setState(498);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & ((1L << (T__115 - 116)) | (1L << (T__116 - 116)) | (1L << (T__117 - 116)) | (1L << (T__118 - 116)))) != 0)) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__1:
				case T__98:
					{
					setState(499);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__1 || _la==T__98) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(500);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(503);
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(507);
				switch (_input.LA(1)) {
				case T__119:
				case T__120:
					{
					setState(504);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__119 || _la==T__120) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__1:
				case T__98:
					{
					setState(505);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__1 || _la==T__98) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(506);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(509);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(510);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(511);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(512);
				((ImpliesIntroContext)_localctx).tb = match(T__121);
				setState(513);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(514);
				((ImpliesElimContext)_localctx).tb = match(T__122);
				setState(515);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(516);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(517);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(518);
				((ImpliesIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__100 || _la==T__101) ) {
					((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(519);
				match(ID);
				setState(520);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(521);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				      "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n      \"e\".equals(_input.LT(2).getText())");
				setState(522);
				((ImpliesElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__100 || _la==T__101) ) {
					((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(523);
				match(ID);
				setState(524);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(525);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(526);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__123 || _la==T__124) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(527);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 11:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(528);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__125 || _la==T__126) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(529);
				((NegElimContext)_localctx).step = match(NUM);
				setState(530);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 12:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(531);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(532);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (T__87 - 88)) | (1L << (T__88 - 88)) | (1L << (T__89 - 88)))) != 0)) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(533);
				match(ID);
				setState(534);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(535);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(536);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (T__87 - 88)) | (1L << (T__88 - 88)) | (1L << (T__89 - 88)))) != 0)) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(537);
				match(ID);
				setState(538);
				((NegElimContext)_localctx).step = match(NUM);
				setState(539);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 14:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(543);
				switch (_input.LA(1)) {
				case T__127:
				case T__128:
					{
					setState(540);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__127 || _la==T__128) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__5:
				case T__19:
					{
					setState(541);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__5 || _la==T__19) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(542);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(545);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 15:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(546);
				((PbcContext)_localctx).tb = match(T__129);
				setState(547);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 16:
				_localctx = new Subst1Context(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(548);
				((Subst1Context)_localctx).tb = match(T__130);
				setState(549);
				((Subst1Context)_localctx).eqStep = match(NUM);
				setState(550);
				((Subst1Context)_localctx).step = match(NUM);
				}
				break;
			case 17:
				_localctx = new Subst2Context(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(551);
				((Subst2Context)_localctx).tb = match(T__131);
				setState(552);
				((Subst2Context)_localctx).eqStep = match(NUM);
				setState(553);
				((Subst2Context)_localctx).step = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(554);
				((AlgebraContext)_localctx).tb = match(T__132);
				setState(558);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(555);
					((AlgebraContext)_localctx).NUM = match(NUM);
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).NUM);
					}
					}
					setState(560);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(561);
				((ForallIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (T__133 - 134)) | (1L << (T__134 - 134)) | (1L << (T__135 - 134)))) != 0)) ) {
					((ForallIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(562);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 20:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(563);
				((ForallElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (T__136 - 137)) | (1L << (T__137 - 137)) | (1L << (T__138 - 137)))) != 0)) ) {
					((ForallElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(564);
				((ForallElimContext)_localctx).step = match(NUM);
				setState(566); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(565);
					formula(0);
					}
					}
					setState(568); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0) );
				}
				break;
			case 21:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(570);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(571);
				((ForallIntroContext)_localctx).tb = match(T__105);
				setState(572);
				match(ID);
				setState(573);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 22:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(574);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(575);
				((ForallElimContext)_localctx).tb = match(T__105);
				setState(576);
				match(ID);
				setState(577);
				((ForallElimContext)_localctx).step = match(NUM);
				setState(579); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(578);
					formula(0);
					}
					}
					setState(581); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0) );
				}
				break;
			case 23:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(583);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 140)) & ~0x3f) == 0 && ((1L << (_la - 140)) & ((1L << (T__139 - 140)) | (1L << (T__140 - 140)) | (1L << (T__141 - 140)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(584);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(586); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(585);
					formula(0);
					}
					}
					setState(588); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0) );
				}
				break;
			case 24:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(590);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & ((1L << (T__142 - 143)) | (1L << (T__143 - 143)) | (1L << (T__144 - 143)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(591);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(592);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 25:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(593);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(594);
				((ExistsIntroContext)_localctx).tb = match(T__109);
				setState(595);
				match(ID);
				setState(596);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(598); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(597);
					formula(0);
					}
					}
					setState(600); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0) );
				}
				break;
			case 26:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(602);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(603);
				((ExistsElimContext)_localctx).tb = match(T__109);
				setState(604);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(605);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(606);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 27:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(607);
				((InvariantContext)_localctx).tb = match(T__145);
				}
				break;
			case 28:
				_localctx = new FctContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(608);
				((FctContext)_localctx).tb = match(T__146);
				setState(609);
				match(ID);
				}
				break;
			case 29:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(610);
				((AutoContext)_localctx).tb = match(T__147);
				setState(614);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(611);
					((AutoContext)_localctx).NUM = match(NUM);
					((AutoContext)_localctx).steps.add(((AutoContext)_localctx).NUM);
					}
					}
					setState(616);
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
			setState(622);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(619);
				match(NL);
				}
				}
				setState(624);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(633);
			_la = _input.LA(1);
			if (_la==T__148) {
				{
				setState(625);
				impor();
				setState(627); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(626);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(629); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(631);
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
			setState(635);
			((ImporContext)_localctx).tb = match(T__148);
			setState(636);
			((ImporContext)_localctx).org = match(ID);
			setState(637);
			match(T__15);
			setState(638);
			((ImporContext)_localctx).sireum = match(ID);
			setState(639);
			match(T__15);
			setState(640);
			((ImporContext)_localctx).logika = match(ID);
			setState(641);
			match(T__15);
			setState(642);
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
			setState(644);
			match(T__13);
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
			((FactsContext)_localctx).ftb = match(T__146);
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
			factOrFun();
			setState(669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(660); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(659);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(662); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(665);
				_la = _input.LA(1);
				if (_la==T__150 || _la==ID) {
					{
					setState(664);
					factOrFun();
					}
				}

				}
				}
				setState(671);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(672);
			((FactsContext)_localctx).te = match(T__14);
			setState(676);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(673);
				match(NL);
				}
				}
				setState(678);
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
			setState(681);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(679);
				fact();
				}
				break;
			case T__150:
				enterOuterAlt(_localctx, 2);
				{
				setState(680);
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
			setState(683);
			match(ID);
			setState(684);
			match(T__15);
			setState(685);
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
			setState(687);
			((FunContext)_localctx).tb = match(T__150);
			setState(688);
			match(ID);
			setState(690);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(689);
				match(NL);
				}
			}

			setState(692);
			match(T__20);
			setState(693);
			param();
			setState(698);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(694);
				match(T__10);
				setState(695);
				param();
				}
				}
				setState(700);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(701);
			match(T__21);
			setState(702);
			match(T__7);
			setState(703);
			type();
			setState(713);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
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
					funDef();
					}
					} 
				}
				setState(715);
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
			setState(716);
			match(T__81);
			setState(717);
			((FunDefContext)_localctx).e = formula(0);
			setState(718);
			match(T__10);
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
			setState(725);
			match(T__151);
			setState(726);
			((FunDefContext)_localctx).c = formula(0);
			setState(727);
			match(T__20);
			setState(728);
			match(ID);
			setState(729);
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
			setState(731);
			match(ID);
			setState(732);
			match(T__7);
			setState(733);
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
			setState(736);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 149)) & ~0x3f) == 0 && ((1L << (_la - 149)) & ((1L << (T__148 - 149)) | (1L << (T__150 - 149)) | (1L << (T__151 - 149)) | (1L << (T__152 - 149)) | (1L << (T__153 - 149)) | (1L << (T__154 - 149)) | (1L << (T__156 - 149)) | (1L << (T__157 - 149)) | (1L << (T__159 - 149)) | (1L << (T__160 - 149)) | (1L << (T__161 - 149)) | (1L << (T__164 - 149)) | (1L << (T__165 - 149)) | (1L << (NUM - 149)) | (1L << (ID - 149)) | (1L << (REAL - 149)) | (1L << (INT - 149)) | (1L << (FLOAT - 149)))) != 0)) {
				{
				setState(735);
				stmt();
				}
			}

			setState(748);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(739); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(738);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(741); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(744);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 149)) & ~0x3f) == 0 && ((1L << (_la - 149)) & ((1L << (T__148 - 149)) | (1L << (T__150 - 149)) | (1L << (T__151 - 149)) | (1L << (T__152 - 149)) | (1L << (T__153 - 149)) | (1L << (T__154 - 149)) | (1L << (T__156 - 149)) | (1L << (T__157 - 149)) | (1L << (T__159 - 149)) | (1L << (T__160 - 149)) | (1L << (T__161 - 149)) | (1L << (T__164 - 149)) | (1L << (T__165 - 149)) | (1L << (NUM - 149)) | (1L << (ID - 149)) | (1L << (REAL - 149)) | (1L << (INT - 149)) | (1L << (FLOAT - 149)))) != 0)) {
					{
					setState(743);
					stmt();
					}
				}

				}
				}
				setState(750);
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
		enterRule(_localctx, 46, RULE_stmt);
		int _la;
		try {
			setState(930);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(751);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__152 || _la==T__153) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(752);
				match(ID);
				setState(753);
				match(T__7);
				setState(754);
				type();
				setState(755);
				match(T__81);
				setState(757);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(756);
					match(NL);
					}
				}

				setState(759);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(761);
				match(ID);
				setState(762);
				match(T__81);
				setState(764);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(763);
					match(NL);
					}
				}

				setState(766);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssumeStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(767);
				match(T__16);
				setState(768);
				match(T__20);
				setState(769);
				exp(0);
				setState(770);
				match(T__21);
				}
				break;
			case 4:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(772);
				match(T__154);
				setState(773);
				match(T__20);
				setState(774);
				exp(0);
				setState(775);
				match(T__21);
				}
				break;
			case 5:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(777);
				match(T__151);
				setState(778);
				match(T__20);
				setState(779);
				exp(0);
				setState(780);
				match(T__21);
				setState(784);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(781);
					match(NL);
					}
					}
					setState(786);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(787);
				match(T__13);
				setState(788);
				((IfStmtContext)_localctx).ts = stmts();
				setState(789);
				match(T__14);
				setState(801);
				_la = _input.LA(1);
				if (_la==T__155) {
					{
					setState(790);
					match(T__155);
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
					match(T__13);
					setState(798);
					((IfStmtContext)_localctx).fs = stmts();
					setState(799);
					match(T__14);
					}
				}

				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(803);
				match(T__156);
				setState(804);
				match(T__20);
				setState(805);
				exp(0);
				setState(806);
				match(T__21);
				setState(810);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(807);
					match(NL);
					}
					}
					setState(812);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(813);
				match(T__13);
				setState(824);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
				case 1:
					{
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
					match(T__157);
					setState(821);
					loopInvariant();
					setState(822);
					match(T__158);
					}
					break;
				}
				setState(826);
				stmts();
				setState(827);
				match(T__14);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(829);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__159 || _la==T__160) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(830);
				match(T__20);
				setState(839);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (STRING - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(831);
					stringOrExp();
					setState(836);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(832);
						match(T__10);
						setState(833);
						stringOrExp();
						}
						}
						setState(838);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(841);
				match(T__21);
				}
				break;
			case 8:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(842);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(843);
				match(T__20);
				setState(844);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(845);
				match(T__21);
				setState(846);
				match(T__81);
				setState(848);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(847);
					match(NL);
					}
				}

				setState(850);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 9:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(854);
				_la = _input.LA(1);
				if (_la==T__161) {
					{
					setState(852);
					match(T__161);
					setState(853);
					((MethodDeclStmtContext)_localctx).helper = match(ID);
					}
				}

				setState(856);
				match(T__150);
				setState(857);
				((MethodDeclStmtContext)_localctx).id = match(ID);
				setState(859);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(858);
					match(NL);
					}
				}

				setState(861);
				match(T__20);
				setState(870);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(862);
					param();
					setState(867);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(863);
						match(T__10);
						setState(864);
						param();
						}
						}
						setState(869);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(872);
				match(T__21);
				setState(873);
				match(T__7);
				setState(876);
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
					setState(874);
					type();
					}
					break;
				case T__162:
					{
					setState(875);
					match(T__162);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(878);
				match(T__81);
				setState(882);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(879);
					match(NL);
					}
					}
					setState(884);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(885);
				match(T__13);
				setState(902);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
				case 1:
					{
					setState(889);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(886);
						match(NL);
						}
						}
						setState(891);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(892);
					match(T__157);
					setState(893);
					methodContract();
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
					setState(900);
					match(T__158);
					}
					break;
				}
				setState(904);
				stmts();
				setState(915);
				_la = _input.LA(1);
				if (_la==T__163) {
					{
					setState(905);
					((MethodDeclStmtContext)_localctx).rtb = match(T__163);
					setState(907);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
						{
						setState(906);
						exp(0);
						}
					}

					setState(912);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(909);
						match(NL);
						}
						}
						setState(914);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(917);
				match(T__14);
				}
				break;
			case 10:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(919);
				match(T__157);
				setState(924);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
				case 1:
					{
					setState(920);
					proof();
					}
					break;
				case 2:
					{
					setState(921);
					sequent();
					}
					break;
				case 3:
					{
					setState(922);
					invariants();
					}
					break;
				case 4:
					{
					setState(923);
					facts();
					}
					break;
				}
				setState(926);
				match(T__158);
				}
				break;
			case 11:
				_localctx = new ImportStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(928);
				impor();
				}
				break;
			case 12:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(929);
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
		enterRule(_localctx, 48, RULE_stringOrExp);
		try {
			setState(934);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(932);
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
				setState(933);
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
		enterRule(_localctx, 50, RULE_primExp);
		int _la;
		try {
			setState(973);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
			case 1:
				_localctx = new BooleanExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(936);
				((BooleanExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
					((BooleanExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 2:
				_localctx = new IntExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(937);
				match(NUM);
				}
				break;
			case 3:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(938);
				match(ID);
				}
				break;
			case 4:
				_localctx = new TypeMethodCallExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(939);
				((TypeMethodCallExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (T__45 - 46)) | (1L << (T__46 - 46)) | (1L << (T__47 - 46)) | (1L << (T__48 - 46)) | (1L << (T__49 - 46)) | (1L << (T__50 - 46)) | (1L << (T__51 - 46)) | (1L << (T__52 - 46)) | (1L << (T__53 - 46)) | (1L << (T__54 - 46)) | (1L << (T__55 - 46)) | (1L << (T__56 - 46)) | (1L << (T__57 - 46)) | (1L << (T__58 - 46)) | (1L << (T__59 - 46)) | (1L << (T__60 - 46)) | (1L << (T__61 - 46)) | (1L << (T__62 - 46)) | (1L << (T__63 - 46)) | (1L << (T__64 - 46)) | (1L << (T__65 - 46)) | (1L << (T__66 - 46)))) != 0)) ) {
					((TypeMethodCallExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(940);
				match(T__15);
				setState(941);
				match(ID);
				setState(942);
				match(T__20);
				setState(951);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(943);
					exp(0);
					setState(948);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(944);
						match(T__10);
						setState(945);
						exp(0);
						}
						}
						setState(950);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(953);
				match(T__21);
				}
				break;
			case 5:
				_localctx = new TypeAccessExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(954);
				((TypeAccessExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & ((1L << (T__23 - 24)) | (1L << (T__24 - 24)) | (1L << (T__25 - 24)) | (1L << (T__26 - 24)) | (1L << (T__27 - 24)) | (1L << (T__28 - 24)) | (1L << (T__29 - 24)) | (1L << (T__30 - 24)) | (1L << (T__31 - 24)) | (1L << (T__32 - 24)) | (1L << (T__33 - 24)) | (1L << (T__34 - 24)) | (1L << (T__35 - 24)) | (1L << (T__36 - 24)) | (1L << (T__37 - 24)) | (1L << (T__38 - 24)) | (1L << (T__39 - 24)) | (1L << (T__40 - 24)) | (1L << (T__41 - 24)) | (1L << (T__42 - 24)) | (1L << (T__43 - 24)) | (1L << (T__44 - 24)) | (1L << (T__45 - 24)) | (1L << (T__46 - 24)) | (1L << (T__47 - 24)) | (1L << (T__48 - 24)) | (1L << (T__49 - 24)) | (1L << (T__50 - 24)) | (1L << (T__51 - 24)) | (1L << (T__52 - 24)) | (1L << (T__53 - 24)) | (1L << (T__54 - 24)) | (1L << (T__55 - 24)) | (1L << (T__56 - 24)) | (1L << (T__57 - 24)) | (1L << (T__58 - 24)) | (1L << (T__59 - 24)) | (1L << (T__60 - 24)) | (1L << (T__61 - 24)) | (1L << (T__62 - 24)) | (1L << (T__63 - 24)) | (1L << (T__64 - 24)) | (1L << (T__65 - 24)) | (1L << (T__66 - 24)))) != 0)) ) {
					((TypeAccessExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(955);
				match(T__15);
				setState(956);
				match(ID);
				}
				break;
			case 6:
				_localctx = new FloatLitExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(957);
				match(FLOAT);
				}
				break;
			case 7:
				_localctx = new IntLitExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(958);
				match(INT);
				}
				break;
			case 8:
				_localctx = new RLitExpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(959);
				match(REAL);
				}
				break;
			case 9:
				_localctx = new SeqExpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(960);
				((SeqExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (T__45 - 46)) | (1L << (T__46 - 46)) | (1L << (T__47 - 46)) | (1L << (T__48 - 46)) | (1L << (T__49 - 46)) | (1L << (T__50 - 46)) | (1L << (T__51 - 46)) | (1L << (T__52 - 46)) | (1L << (T__53 - 46)) | (1L << (T__54 - 46)) | (1L << (T__55 - 46)) | (1L << (T__56 - 46)) | (1L << (T__57 - 46)) | (1L << (T__58 - 46)) | (1L << (T__59 - 46)) | (1L << (T__60 - 46)) | (1L << (T__61 - 46)) | (1L << (T__62 - 46)) | (1L << (T__63 - 46)) | (1L << (T__64 - 46)) | (1L << (T__65 - 46)) | (1L << (T__66 - 46)))) != 0)) ) {
					((SeqExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(961);
				match(T__20);
				setState(970);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(962);
					exp(0);
					setState(967);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(963);
						match(T__10);
						setState(964);
						exp(0);
						}
						}
						setState(969);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(972);
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
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1012);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				{
				_localctx = new InvokeExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(976);
				((InvokeExpContext)_localctx).tb = match(ID);
				setState(977);
				((InvokeExpContext)_localctx).t = match(T__20);
				setState(986);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(978);
					exp(0);
					setState(983);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(979);
						match(T__10);
						setState(980);
						exp(0);
						}
						}
						setState(985);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(988);
				match(T__21);
				}
				break;
			case 2:
				{
				_localctx = new PExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(989);
				primExp();
				setState(994);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(990);
						match(T__15);
						setState(991);
						match(ID);
						}
						} 
					}
					setState(996);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
				}
				}
				break;
			case 3:
				{
				_localctx = new RandomIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(997);
				match(T__164);
				setState(998);
				match(T__20);
				setState(999);
				match(T__21);
				}
				break;
			case 4:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1000);
				match(T__165);
				setState(1001);
				match(T__20);
				setState(1003);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(1002);
					match(STRING);
					}
				}

				setState(1005);
				match(T__21);
				}
				break;
			case 5:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1006);
				match(T__20);
				setState(1007);
				exp(0);
				setState(1008);
				match(T__21);
				}
				break;
			case 6:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1010);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__87 || _la==T__88) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1011);
				exp(10);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1070);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1068);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1014);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1015);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__67 || _la==T__68) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1017);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1016);
							match(NL);
							}
						}

						setState(1019);
						((BinaryExpContext)_localctx).r = exp(10);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1020);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1021);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__69) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1023);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1022);
							match(NL);
							}
						}

						setState(1025);
						((BinaryExpContext)_localctx).r = exp(9);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1026);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1027);
						((BinaryExpContext)_localctx).op = match(T__70);
						setState(1029);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1028);
							match(NL);
							}
						}

						setState(1031);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1032);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1033);
						((BinaryExpContext)_localctx).op = match(T__71);
						setState(1035);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1034);
							match(NL);
							}
						}

						setState(1037);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1038);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1039);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (T__72 - 73)) | (1L << (T__73 - 73)) | (1L << (T__75 - 73)) | (1L << (T__76 - 73)) | (1L << (T__78 - 73)) | (1L << (T__79 - 73)) | (1L << (T__80 - 73)))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1041);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1040);
							match(NL);
							}
						}

						setState(1043);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1044);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1045);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__82 || _la==T__83) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(1047);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1046);
							match(NL);
							}
						}

						setState(1049);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1050);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1051);
						((BinaryExpContext)_localctx).op = match(T__91);
						setState(1053);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1052);
							match(NL);
							}
						}

						setState(1055);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1056);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1057);
						((BinaryExpContext)_localctx).op = match(T__95);
						setState(1059);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1058);
							match(NL);
							}
						}

						setState(1061);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1062);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1063);
						((BinaryExpContext)_localctx).op = match(T__1);
						setState(1065);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1064);
							match(NL);
							}
						}

						setState(1067);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(1072);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
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
		enterRule(_localctx, 54, RULE_loopInvariant);
		int _la;
		try {
			int _alt;
			setState(1126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,154,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1073);
				((LoopInvariantContext)_localctx).tb = match(T__13);
				setState(1077);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1074);
					match(NL);
					}
					}
					setState(1079);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1080);
				modifies();
				setState(1081);
				((LoopInvariantContext)_localctx).te = match(T__14);
				setState(1085);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1082);
					match(NL);
					}
					}
					setState(1087);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1088);
				((LoopInvariantContext)_localctx).tb = match(T__13);
				setState(1092);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1089);
					match(NL);
					}
					}
					setState(1094);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1095);
				((LoopInvariantContext)_localctx).itb = match(T__145);
				setState(1099);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1096);
					match(NL);
					}
					}
					setState(1101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1102);
				formula(0);
				setState(1113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1104); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1103);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1106); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,149,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(1109);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
						{
						setState(1108);
						formula(0);
						}
					}

					}
					}
					setState(1115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1117);
				_la = _input.LA(1);
				if (_la==T__166) {
					{
					setState(1116);
					modifies();
					}
				}

				setState(1119);
				((LoopInvariantContext)_localctx).te = match(T__14);
				setState(1123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1120);
					match(NL);
					}
					}
					setState(1125);
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
		enterRule(_localctx, 56, RULE_modifies);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1128);
			((ModifiesContext)_localctx).tb = match(T__166);
			setState(1129);
			match(ID);
			setState(1134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(1130);
				match(T__10);
				setState(1131);
				match(ID);
				}
				}
				setState(1136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,156,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1137);
					match(NL);
					}
					} 
				}
				setState(1142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,156,_ctx);
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
		enterRule(_localctx, 58, RULE_methodContract);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1143);
			((MethodContractContext)_localctx).tb = match(T__13);
			setState(1147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1144);
					match(NL);
					}
					} 
				}
				setState(1149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
			}
			setState(1171);
			_la = _input.LA(1);
			if (_la==T__167 || _la==T__168) {
				{
				setState(1150);
				_la = _input.LA(1);
				if ( !(_la==T__167 || _la==T__168) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1151);
					match(NL);
					}
					}
					setState(1156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1157);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(1168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1159); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1158);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1161); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,159,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(1164);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
							{
							setState(1163);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(1170);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
				}
				}
			}

			setState(1176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1173);
					match(NL);
					}
					} 
				}
				setState(1178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			}
			setState(1180);
			_la = _input.LA(1);
			if (_la==T__166) {
				{
				setState(1179);
				modifies();
				}
			}

			setState(1203);
			_la = _input.LA(1);
			if (_la==T__169 || _la==T__170) {
				{
				setState(1182);
				_la = _input.LA(1);
				if ( !(_la==T__169 || _la==T__170) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1183);
					match(NL);
					}
					}
					setState(1188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1189);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(1200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1191); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1190);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1193); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(1196);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
							{
							setState(1195);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(1202);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
				}
				}
			}

			setState(1208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1205);
				match(NL);
				}
				}
				setState(1210);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1211);
			((MethodContractContext)_localctx).te = match(T__14);
			setState(1215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1212);
					match(NL);
					}
					} 
				}
				setState(1217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
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
		enterRule(_localctx, 60, RULE_invariants);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1218);
			((InvariantsContext)_localctx).tb = match(T__13);
			setState(1222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1219);
				match(NL);
				}
				}
				setState(1224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1225);
			match(T__145);
			setState(1229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1226);
				match(NL);
				}
				}
				setState(1231);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1232);
			formula(0);
			setState(1243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1234); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1233);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1236); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1239);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
					{
					setState(1238);
					formula(0);
					}
				}

				}
				}
				setState(1245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1246);
			((InvariantsContext)_localctx).te = match(T__14);
			setState(1250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1247);
				match(NL);
				}
				}
				setState(1252);
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
		case 26:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u00ba\u04e8\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\7\2F\n\2\f\2\16\2I\13\2\3\2\5\2L\n\2\3\2\7\2O\n\2\f\2"+
		"\16\2R\13\2\3\2\3\2\3\2\3\2\3\2\5\2Y\n\2\3\3\7\3\\\n\3\f\3\16\3_\13\3"+
		"\3\3\3\3\6\3c\n\3\r\3\16\3d\3\3\3\3\6\3i\n\3\r\3\16\3j\3\3\6\3n\n\3\r"+
		"\3\16\3o\3\3\3\3\3\3\6\3u\n\3\r\3\16\3v\3\3\3\3\6\3{\n\3\r\3\16\3|\3\3"+
		"\7\3\u0080\n\3\f\3\16\3\u0083\13\3\3\3\6\3\u0086\n\3\r\3\16\3\u0087\3"+
		"\3\3\3\6\3\u008c\n\3\r\3\16\3\u008d\3\3\5\3\u0091\n\3\3\3\7\3\u0094\n"+
		"\3\f\3\16\3\u0097\13\3\3\4\7\4\u009a\n\4\f\4\16\4\u009d\13\4\3\4\3\4\7"+
		"\4\u00a1\n\4\f\4\16\4\u00a4\13\4\3\5\3\5\3\6\3\6\6\6\u00aa\n\6\r\6\16"+
		"\6\u00ab\3\6\3\6\3\6\3\6\7\6\u00b2\n\6\f\6\16\6\u00b5\13\6\3\6\6\6\u00b8"+
		"\n\6\r\6\16\6\u00b9\3\6\3\6\3\6\3\6\7\6\u00c0\n\6\f\6\16\6\u00c3\13\6"+
		"\5\6\u00c5\n\6\3\7\3\7\6\7\u00c9\n\7\r\7\16\7\u00ca\3\7\3\7\3\b\3\b\3"+
		"\b\7\b\u00d2\n\b\f\b\16\b\u00d5\13\b\5\b\u00d7\n\b\3\b\3\b\3\b\3\b\7\b"+
		"\u00dd\n\b\f\b\16\b\u00e0\13\b\3\b\7\b\u00e3\n\b\f\b\16\b\u00e6\13\b\3"+
		"\b\3\b\6\b\u00ea\n\b\r\b\16\b\u00eb\5\b\u00ee\n\b\3\t\3\t\5\t\u00f2\n"+
		"\t\3\t\6\t\u00f5\n\t\r\t\16\t\u00f6\3\t\5\t\u00fa\n\t\7\t\u00fc\n\t\f"+
		"\t\16\t\u00ff\13\t\3\t\3\t\7\t\u0103\n\t\f\t\16\t\u0106\13\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\7\n\u0110\n\n\f\n\16\n\u0113\13\n\3\n\3\n\7\n\u0117"+
		"\n\n\f\n\16\n\u011a\13\n\3\n\3\n\3\n\3\n\3\n\5\n\u0121\n\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u0129\n\n\3\n\3\n\3\n\5\n\u012e\n\n\3\n\6\n\u0131\n\n"+
		"\r\n\16\n\u0132\3\n\5\n\u0136\n\n\7\n\u0138\n\n\f\n\16\n\u013b\13\n\3"+
		"\n\5\n\u013e\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u014a\n\13\f\13\16\13\u014d\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\7\13\u0157\n\13\f\13\16\13\u015a\13\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u016b\n\13\f\13"+
		"\16\13\u016e\13\13\5\13\u0170\n\13\3\13\5\13\u0173\n\13\3\f\3\f\3\f\3"+
		"\f\7\f\u0179\n\f\f\f\16\f\u017c\13\f\3\f\3\f\3\f\3\f\3\f\5\f\u0183\n\f"+
		"\3\f\3\f\3\f\5\f\u0188\n\f\3\f\3\f\3\f\3\f\5\f\u018e\n\f\3\f\3\f\3\f\3"+
		"\f\5\f\u0194\n\f\3\f\3\f\3\f\3\f\5\f\u019a\n\f\3\f\3\f\3\f\3\f\5\f\u01a0"+
		"\n\f\3\f\3\f\3\f\3\f\5\f\u01a6\n\f\3\f\3\f\3\f\3\f\5\f\u01ac\n\f\3\f\3"+
		"\f\3\f\3\f\5\f\u01b2\n\f\3\f\3\f\3\f\3\f\5\f\u01b8\n\f\3\f\3\f\3\f\3\f"+
		"\5\f\u01be\n\f\3\f\7\f\u01c1\n\f\f\f\16\f\u01c4\13\f\3\r\3\r\3\r\3\r\7"+
		"\r\u01ca\n\r\f\r\16\r\u01cd\13\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u01d5\n\r"+
		"\3\r\3\r\5\r\u01d9\n\r\3\r\3\r\3\r\5\r\u01de\n\r\3\r\5\r\u01e1\n\r\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u01eb\n\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u01f2\n\17\3\17\3\17\3\17\3\17\5\17\u01f8\n\17\3\17\3\17\3"+
		"\17\3\17\5\17\u01fe\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0222\n\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u022f\n\17"+
		"\f\17\16\17\u0232\13\17\3\17\3\17\3\17\3\17\3\17\6\17\u0239\n\17\r\17"+
		"\16\17\u023a\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u0246\n"+
		"\17\r\17\16\17\u0247\3\17\3\17\3\17\6\17\u024d\n\17\r\17\16\17\u024e\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u0259\n\17\r\17\16\17\u025a"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0267\n\17\f\17"+
		"\16\17\u026a\13\17\5\17\u026c\n\17\3\20\7\20\u026f\n\20\f\20\16\20\u0272"+
		"\13\20\3\20\3\20\6\20\u0276\n\20\r\20\16\20\u0277\3\20\3\20\5\20\u027c"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\7\22\u0289"+
		"\n\22\f\22\16\22\u028c\13\22\3\22\3\22\7\22\u0290\n\22\f\22\16\22\u0293"+
		"\13\22\3\22\3\22\6\22\u0297\n\22\r\22\16\22\u0298\3\22\5\22\u029c\n\22"+
		"\7\22\u029e\n\22\f\22\16\22\u02a1\13\22\3\22\3\22\7\22\u02a5\n\22\f\22"+
		"\16\22\u02a8\13\22\3\23\3\23\5\23\u02ac\n\23\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\5\25\u02b5\n\25\3\25\3\25\3\25\3\25\7\25\u02bb\n\25\f\25\16"+
		"\25\u02be\13\25\3\25\3\25\3\25\3\25\7\25\u02c4\n\25\f\25\16\25\u02c7\13"+
		"\25\3\25\7\25\u02ca\n\25\f\25\16\25\u02cd\13\25\3\26\3\26\3\26\3\26\7"+
		"\26\u02d3\n\26\f\26\16\26\u02d6\13\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\30\5\30\u02e3\n\30\3\30\6\30\u02e6\n\30\r\30\16\30"+
		"\u02e7\3\30\5\30\u02eb\n\30\7\30\u02ed\n\30\f\30\16\30\u02f0\13\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u02f8\n\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u02ff\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\7\31\u0311\n\31\f\31\16\31\u0314\13\31\3\31\3\31"+
		"\3\31\3\31\3\31\7\31\u031b\n\31\f\31\16\31\u031e\13\31\3\31\3\31\3\31"+
		"\3\31\5\31\u0324\n\31\3\31\3\31\3\31\3\31\3\31\7\31\u032b\n\31\f\31\16"+
		"\31\u032e\13\31\3\31\3\31\7\31\u0332\n\31\f\31\16\31\u0335\13\31\3\31"+
		"\3\31\3\31\3\31\5\31\u033b\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\7\31\u0345\n\31\f\31\16\31\u0348\13\31\5\31\u034a\n\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u0353\n\31\3\31\3\31\3\31\3\31\5\31\u0359\n"+
		"\31\3\31\3\31\3\31\5\31\u035e\n\31\3\31\3\31\3\31\3\31\7\31\u0364\n\31"+
		"\f\31\16\31\u0367\13\31\5\31\u0369\n\31\3\31\3\31\3\31\3\31\5\31\u036f"+
		"\n\31\3\31\3\31\7\31\u0373\n\31\f\31\16\31\u0376\13\31\3\31\3\31\7\31"+
		"\u037a\n\31\f\31\16\31\u037d\13\31\3\31\3\31\3\31\7\31\u0382\n\31\f\31"+
		"\16\31\u0385\13\31\3\31\3\31\5\31\u0389\n\31\3\31\3\31\3\31\5\31\u038e"+
		"\n\31\3\31\7\31\u0391\n\31\f\31\16\31\u0394\13\31\5\31\u0396\n\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u039f\n\31\3\31\3\31\3\31\3\31\5\31"+
		"\u03a5\n\31\3\32\3\32\5\32\u03a9\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\7\33\u03b5\n\33\f\33\16\33\u03b8\13\33\5\33\u03ba\n"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u03c8"+
		"\n\33\f\33\16\33\u03cb\13\33\5\33\u03cd\n\33\3\33\5\33\u03d0\n\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\7\34\u03d8\n\34\f\34\16\34\u03db\13\34\5\34"+
		"\u03dd\n\34\3\34\3\34\3\34\3\34\7\34\u03e3\n\34\f\34\16\34\u03e6\13\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u03ee\n\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\5\34\u03f7\n\34\3\34\3\34\3\34\5\34\u03fc\n\34\3\34\3\34\3"+
		"\34\3\34\5\34\u0402\n\34\3\34\3\34\3\34\3\34\5\34\u0408\n\34\3\34\3\34"+
		"\3\34\3\34\5\34\u040e\n\34\3\34\3\34\3\34\3\34\5\34\u0414\n\34\3\34\3"+
		"\34\3\34\3\34\5\34\u041a\n\34\3\34\3\34\3\34\3\34\5\34\u0420\n\34\3\34"+
		"\3\34\3\34\3\34\5\34\u0426\n\34\3\34\3\34\3\34\3\34\5\34\u042c\n\34\3"+
		"\34\7\34\u042f\n\34\f\34\16\34\u0432\13\34\3\35\3\35\7\35\u0436\n\35\f"+
		"\35\16\35\u0439\13\35\3\35\3\35\3\35\7\35\u043e\n\35\f\35\16\35\u0441"+
		"\13\35\3\35\3\35\7\35\u0445\n\35\f\35\16\35\u0448\13\35\3\35\3\35\7\35"+
		"\u044c\n\35\f\35\16\35\u044f\13\35\3\35\3\35\6\35\u0453\n\35\r\35\16\35"+
		"\u0454\3\35\5\35\u0458\n\35\7\35\u045a\n\35\f\35\16\35\u045d\13\35\3\35"+
		"\5\35\u0460\n\35\3\35\3\35\7\35\u0464\n\35\f\35\16\35\u0467\13\35\5\35"+
		"\u0469\n\35\3\36\3\36\3\36\3\36\7\36\u046f\n\36\f\36\16\36\u0472\13\36"+
		"\3\36\7\36\u0475\n\36\f\36\16\36\u0478\13\36\3\37\3\37\7\37\u047c\n\37"+
		"\f\37\16\37\u047f\13\37\3\37\3\37\7\37\u0483\n\37\f\37\16\37\u0486\13"+
		"\37\3\37\3\37\6\37\u048a\n\37\r\37\16\37\u048b\3\37\5\37\u048f\n\37\7"+
		"\37\u0491\n\37\f\37\16\37\u0494\13\37\5\37\u0496\n\37\3\37\7\37\u0499"+
		"\n\37\f\37\16\37\u049c\13\37\3\37\5\37\u049f\n\37\3\37\3\37\7\37\u04a3"+
		"\n\37\f\37\16\37\u04a6\13\37\3\37\3\37\6\37\u04aa\n\37\r\37\16\37\u04ab"+
		"\3\37\5\37\u04af\n\37\7\37\u04b1\n\37\f\37\16\37\u04b4\13\37\5\37\u04b6"+
		"\n\37\3\37\7\37\u04b9\n\37\f\37\16\37\u04bc\13\37\3\37\3\37\7\37\u04c0"+
		"\n\37\f\37\16\37\u04c3\13\37\3 \3 \7 \u04c7\n \f \16 \u04ca\13 \3 \3 "+
		"\7 \u04ce\n \f \16 \u04d1\13 \3 \3 \6 \u04d5\n \r \16 \u04d6\3 \5 \u04da"+
		"\n \7 \u04dc\n \f \16 \u04df\13 \3 \3 \7 \u04e3\n \f \16 \u04e6\13 \3"+
		" \2\4\26\66!\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>\2*\3\2\5\b\3\2\5\6\3\2\7\b\3\2\16\17\4\2\5\b\24\26\3\2\32/\3\2"+
		"\60E\3\2X\\\4\2\3\3FG\4\2\t\tHH\3\2KS\3\2TW\3\2]`\3\2ab\4\2\4\4ce\3\2"+
		"fh\3\2ip\3\2\32E\3\2^`\3\2tu\3\2vy\4\2\4\4ee\3\2z{\3\2gh\3\2~\177\3\2"+
		"\u0080\u0081\3\2Z\\\3\2\u0082\u0083\4\2\b\b\26\26\3\2\u0088\u008a\3\2"+
		"\u008b\u008d\3\2\u008e\u0090\3\2\u0091\u0093\3\2\u009b\u009c\3\2\u00a2"+
		"\u00a3\4\2\t\tZ[\5\2KLNOQS\3\2UV\3\2\u00aa\u00ab\3\2\u00ac\u00ad\u05ca"+
		"\2X\3\2\2\2\4]\3\2\2\2\6\u009b\3\2\2\2\b\u00a5\3\2\2\2\n\u00a7\3\2\2\2"+
		"\f\u00c6\3\2\2\2\16\u00ed\3\2\2\2\20\u00ef\3\2\2\2\22\u013d\3\2\2\2\24"+
		"\u0172\3\2\2\2\26\u0182\3\2\2\2\30\u01c5\3\2\2\2\32\u01e4\3\2\2\2\34\u026b"+
		"\3\2\2\2\36\u0270\3\2\2\2 \u027d\3\2\2\2\"\u0286\3\2\2\2$\u02ab\3\2\2"+
		"\2&\u02ad\3\2\2\2(\u02b1\3\2\2\2*\u02ce\3\2\2\2,\u02dd\3\2\2\2.\u02e2"+
		"\3\2\2\2\60\u03a4\3\2\2\2\62\u03a8\3\2\2\2\64\u03cf\3\2\2\2\66\u03f6\3"+
		"\2\2\28\u0468\3\2\2\2:\u046a\3\2\2\2<\u0479\3\2\2\2>\u04c4\3\2\2\2@A\5"+
		"\4\3\2AB\7\2\2\3BY\3\2\2\2CG\5\16\b\2DF\7\u00b4\2\2ED\3\2\2\2FI\3\2\2"+
		"\2GE\3\2\2\2GH\3\2\2\2HK\3\2\2\2IG\3\2\2\2JL\5\20\t\2KJ\3\2\2\2KL\3\2"+
		"\2\2LP\3\2\2\2MO\7\u00b4\2\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q"+
		"S\3\2\2\2RP\3\2\2\2ST\7\2\2\3TY\3\2\2\2UV\5\36\20\2VW\7\2\2\3WY\3\2\2"+
		"\2X@\3\2\2\2XC\3\2\2\2XU\3\2\2\2Y\3\3\2\2\2Z\\\7\u00b4\2\2[Z\3\2\2\2\\"+
		"_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`b\7\3\2\2ac\7\u00b4"+
		"\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2fh\7\u00ae\2\2g"+
		"i\7\u00b4\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2ln\7\u00b0"+
		"\2\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2\2pq\3\2\2\2qr\7\4\2\2rt\5\26"+
		"\f\2su\7\u00b4\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2wx\3\2\2\2x"+
		"\u0081\7\u00ae\2\2y{\7\u00b4\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2"+
		"\2}~\3\2\2\2~\u0080\5\6\4\2\177z\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177"+
		"\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0084"+
		"\u0086\7\u00b4\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0090\7\u00ae\2"+
		"\2\u008a\u008c\7\u00b4\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\5\n"+
		"\6\2\u0090\u008b\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0095\3\2\2\2\u0092"+
		"\u0094\7\u00b4\2\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\5\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u009a\5\b\5\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\u00a2\7\4\2\2\u009f\u00a1\5\b\5\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\7\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a5\u00a6\t\2\2\2\u00a6\t\3\2\2\2\u00a7\u00c4\7\u00b0\2\2\u00a8"+
		"\u00aa\7\u00b4\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\t\2\2\u00ae"+
		"\u00af\t\3\2\2\u00af\u00b3\7\n\2\2\u00b0\u00b2\5\f\7\2\u00b1\u00b0\3\2"+
		"\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b8\7\u00b4\2\2\u00b7\u00b6"+
		"\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\u00bc\7\t\2\2\u00bc\u00bd\t\4\2\2\u00bd\u00c1\7\n"+
		"\2\2\u00be\u00c0\5\f\7\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2"+
		"\2\2\u00c4\u00a9\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\13\3\2\2\2\u00c6\u00c8"+
		"\7\13\2\2\u00c7\u00c9\5\b\5\2\u00c8\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2"+
		"\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd"+
		"\7\f\2\2\u00cd\r\3\2\2\2\u00ce\u00d3\5\26\f\2\u00cf\u00d0\7\r\2\2\u00d0"+
		"\u00d2\5\26\f\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3"+
		"\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6"+
		"\u00ce\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\t\5"+
		"\2\2\u00d9\u00de\5\26\f\2\u00da\u00db\7\r\2\2\u00db\u00dd\5\26\f\2\u00dc"+
		"\u00da\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00ee\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e3\5\26\f\2\u00e2"+
		"\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e9\7\u00ae\2\2\u00e8"+
		"\u00ea\5\26\f\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3"+
		"\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00d6\3\2\2\2\u00ed"+
		"\u00e4\3\2\2\2\u00ee\17\3\2\2\2\u00ef\u00f1\7\20\2\2\u00f0\u00f2\5\22"+
		"\n\2\u00f1\u00f0\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00fd\3\2\2\2\u00f3"+
		"\u00f5\7\u00b4\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f4"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00fa\5\22\n\2"+
		"\u00f9\u00f8\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f4"+
		"\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\u0100\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0104\7\21\2\2\u0101\u0103\7"+
		"\u00b4\2\2\u0102\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2"+
		"\u0104\u0105\3\2\2\2\u0105\21\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108"+
		"\7\u00af\2\2\u0108\u0109\7\22\2\2\u0109\u010a\5\26\f\2\u010a\u010b\5\34"+
		"\17\2\u010b\u013e\3\2\2\2\u010c\u010d\7\u00af\2\2\u010d\u0111\7\22\2\2"+
		"\u010e\u0110\7\u00b4\2\2\u010f\u010e\3\2\2\2\u0110\u0113\3\2\2\2\u0111"+
		"\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0114\3\2\2\2\u0113\u0111\3\2"+
		"\2\2\u0114\u0118\7\20\2\2\u0115\u0117\7\u00b4\2\2\u0116\u0115\3\2\2\2"+
		"\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011b"+
		"\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c\7\u00af\2\2\u011c\u012d\7\22"+
		"\2\2\u011d\u0120\7\u00b0\2\2\u011e\u011f\7\n\2\2\u011f\u0121\5\32\16\2"+
		"\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u012e\3\2\2\2\u0122\u0123"+
		"\5\26\f\2\u0123\u0124\7\23\2\2\u0124\u012e\3\2\2\2\u0125\u0128\7\u00b0"+
		"\2\2\u0126\u0127\7\n\2\2\u0127\u0129\5\32\16\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\5\26\f\2\u012b\u012c\7"+
		"\23\2\2\u012c\u012e\3\2\2\2\u012d\u011d\3\2\2\2\u012d\u0122\3\2\2\2\u012d"+
		"\u0125\3\2\2\2\u012e\u0139\3\2\2\2\u012f\u0131\7\u00b4\2\2\u0130\u012f"+
		"\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133"+
		"\u0135\3\2\2\2\u0134\u0136\5\22\n\2\u0135\u0134\3\2\2\2\u0135\u0136\3"+
		"\2\2\2\u0136\u0138\3\2\2\2\u0137\u0130\3\2\2\2\u0138\u013b\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b\u0139\3\2"+
		"\2\2\u013c\u013e\7\21\2\2\u013d\u0107\3\2\2\2\u013d\u010c\3\2\2\2\u013e"+
		"\23\3\2\2\2\u013f\u0173\t\6\2\2\u0140\u0141\7\27\2\2\u0141\u0142\5\26"+
		"\f\2\u0142\u0143\7\30\2\2\u0143\u0173\3\2\2\2\u0144\u0145\7\31\2\2\u0145"+
		"\u0146\7\27\2\2\u0146\u014b\5\26\f\2\u0147\u0148\7\r\2\2\u0148\u014a\5"+
		"\26\f\2\u0149\u0147\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014e\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u014f\7\30"+
		"\2\2\u014f\u0173\3\2\2\2\u0150\u0173\7\31\2\2\u0151\u0152\7\u00b0\2\2"+
		"\u0152\u0153\7\27\2\2\u0153\u0158\5\26\f\2\u0154\u0155\7\r\2\2\u0155\u0157"+
		"\5\26\f\2\u0156\u0154\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2"+
		"\u0158\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015c"+
		"\7\30\2\2\u015c\u0173\3\2\2\2\u015d\u0173\7\u00b0\2\2\u015e\u0173\7\u00af"+
		"\2\2\u015f\u0173\7\u00b2\2\2\u0160\u0173\7\u00b1\2\2\u0161\u0173\7\u00b9"+
		"\2\2\u0162\u0163\t\7\2\2\u0163\u0164\7\22\2\2\u0164\u0173\7\u00b0\2\2"+
		"\u0165\u0166\t\b\2\2\u0166\u016f\7\27\2\2\u0167\u016c\5\66\34\2\u0168"+
		"\u0169\7\r\2\2\u0169\u016b\5\66\34\2\u016a\u0168\3\2\2\2\u016b\u016e\3"+
		"\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u0170\3\2\2\2\u016e"+
		"\u016c\3\2\2\2\u016f\u0167\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\3\2"+
		"\2\2\u0171\u0173\7\30\2\2\u0172\u013f\3\2\2\2\u0172\u0140\3\2\2\2\u0172"+
		"\u0144\3\2\2\2\u0172\u0150\3\2\2\2\u0172\u0151\3\2\2\2\u0172\u015d\3\2"+
		"\2\2\u0172\u015e\3\2\2\2\u0172\u015f\3\2\2\2\u0172\u0160\3\2\2\2\u0172"+
		"\u0161\3\2\2\2\u0172\u0162\3\2\2\2\u0172\u0165\3\2\2\2\u0173\25\3\2\2"+
		"\2\u0174\u0175\b\f\1\2\u0175\u017a\5\24\13\2\u0176\u0177\7\22\2\2\u0177"+
		"\u0179\7\u00b0\2\2\u0178\u0176\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178"+
		"\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u0183\3\2\2\2\u017c\u017a\3\2\2\2\u017d"+
		"\u017e\7\t\2\2\u017e\u0183\5\26\f\t\u017f\u0180\t\t\2\2\u0180\u0183\5"+
		"\26\f\b\u0181\u0183\5\30\r\2\u0182\u0174\3\2\2\2\u0182\u017d\3\2\2\2\u0182"+
		"\u017f\3\2\2\2\u0182\u0181\3\2\2\2\u0183\u01c2\3\2\2\2\u0184\u0185\f\17"+
		"\2\2\u0185\u0187\t\n\2\2\u0186\u0188\7\u00b4\2\2\u0187\u0186\3\2\2\2\u0187"+
		"\u0188\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u01c1\5\26\f\20\u018a\u018b\f"+
		"\16\2\2\u018b\u018d\t\13\2\2\u018c\u018e\7\u00b4\2\2\u018d\u018c\3\2\2"+
		"\2\u018d\u018e\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u01c1\5\26\f\17\u0190"+
		"\u0191\f\r\2\2\u0191\u0193\7I\2\2\u0192\u0194\7\u00b4\2\2\u0193\u0192"+
		"\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u01c1\5\26\f\r"+
		"\u0196\u0197\f\f\2\2\u0197\u0199\7J\2\2\u0198\u019a\7\u00b4\2\2\u0199"+
		"\u0198\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u01c1\5\26"+
		"\f\r\u019c\u019d\f\13\2\2\u019d\u019f\t\f\2\2\u019e\u01a0\7\u00b4\2\2"+
		"\u019f\u019e\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01c1"+
		"\5\26\f\f\u01a2\u01a3\f\n\2\2\u01a3\u01a5\t\r\2\2\u01a4\u01a6\7\u00b4"+
		"\2\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7"+
		"\u01c1\5\26\f\13\u01a8\u01a9\f\7\2\2\u01a9\u01ab\t\16\2\2\u01aa\u01ac"+
		"\7\u00b4\2\2\u01ab\u01aa\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01ad\3\2\2"+
		"\2\u01ad\u01c1\5\26\f\b\u01ae\u01af\f\6\2\2\u01af\u01b1\t\17\2\2\u01b0"+
		"\u01b2\7\u00b4\2\2\u01b1\u01b0\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3"+
		"\3\2\2\2\u01b3\u01c1\5\26\f\7\u01b4\u01b5\f\5\2\2\u01b5\u01b7\t\20\2\2"+
		"\u01b6\u01b8\7\u00b4\2\2\u01b7\u01b6\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8"+
		"\u01b9\3\2\2\2\u01b9\u01c1\5\26\f\6\u01ba\u01bb\f\4\2\2\u01bb\u01bd\t"+
		"\21\2\2\u01bc\u01be\7\u00b4\2\2\u01bd\u01bc\3\2\2\2\u01bd\u01be\3\2\2"+
		"\2\u01be\u01bf\3\2\2\2\u01bf\u01c1\5\26\f\4\u01c0\u0184\3\2\2\2\u01c0"+
		"\u018a\3\2\2\2\u01c0\u0190\3\2\2\2\u01c0\u0196\3\2\2\2\u01c0\u019c\3\2"+
		"\2\2\u01c0\u01a2\3\2\2\2\u01c0\u01a8\3\2\2\2\u01c0\u01ae\3\2\2\2\u01c0"+
		"\u01b4\3\2\2\2\u01c0\u01ba\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2\u01c0\3\2"+
		"\2\2\u01c2\u01c3\3\2\2\2\u01c3\27\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c6"+
		"\t\22\2\2\u01c6\u01cb\7\u00b0\2\2\u01c7\u01c8\7\r\2\2\u01c8\u01ca\7\u00b0"+
		"\2\2\u01c9\u01c7\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb"+
		"\u01cc\3\2\2\2\u01cc\u01dd\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01cf\7\n"+
		"\2\2\u01cf\u01de\5\32\16\2\u01d0\u01d1\7\n\2\2\u01d1\u01d2\7\27\2\2\u01d2"+
		"\u01d4\5\66\34\2\u01d3\u01d5\7K\2\2\u01d4\u01d3\3\2\2\2\u01d4\u01d5\3"+
		"\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d8\7q\2\2\u01d7\u01d9\7K\2\2\u01d8"+
		"\u01d7\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\5\66"+
		"\34\2\u01db\u01dc\7\30\2\2\u01dc\u01de\3\2\2\2\u01dd\u01ce\3\2\2\2\u01dd"+
		"\u01d0\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01e0\3\2\2\2\u01df\u01e1\7\u00b4"+
		"\2\2\u01e0\u01df\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2"+
		"\u01e3\5\26\f\2\u01e3\31\3\2\2\2\u01e4\u01e5\t\23\2\2\u01e5\33\3\2\2\2"+
		"\u01e6\u026c\7r\2\2\u01e7\u01eb\7s\2\2\u01e8\u01e9\t\24\2\2\u01e9\u01eb"+
		"\7\u00b0\2\2\u01ea\u01e7\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb\u01ec\3\2\2"+
		"\2\u01ec\u01ed\7\u00af\2\2\u01ed\u026c\7\u00af\2\2\u01ee\u01f2\t\25\2"+
		"\2\u01ef\u01f0\t\24\2\2\u01f0\u01f2\7\u00b0\2\2\u01f1\u01ee\3\2\2\2\u01f1"+
		"\u01ef\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u026c\7\u00af\2\2\u01f4\u01f8"+
		"\t\26\2\2\u01f5\u01f6\t\27\2\2\u01f6\u01f8\7\u00b0\2\2\u01f7\u01f4\3\2"+
		"\2\2\u01f7\u01f5\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u026c\7\u00af\2\2\u01fa"+
		"\u01fe\t\30\2\2\u01fb\u01fc\t\27\2\2\u01fc\u01fe\7\u00b0\2\2\u01fd\u01fa"+
		"\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\7\u00af\2"+
		"\2\u0200\u0201\7\u00af\2\2\u0201\u026c\7\u00af\2\2\u0202\u0203\7|\2\2"+
		"\u0203\u026c\7\u00af\2\2\u0204\u0205\7}\2\2\u0205\u0206\7\u00af\2\2\u0206"+
		"\u026c\7\u00af\2\2\u0207\u0208\6\17\f\2\u0208\u0209\t\31\2\2\u0209\u020a"+
		"\7\u00b0\2\2\u020a\u026c\7\u00af\2\2\u020b\u020c\6\17\r\2\u020c\u020d"+
		"\t\31\2\2\u020d\u020e\7\u00b0\2\2\u020e\u020f\7\u00af\2\2\u020f\u026c"+
		"\7\u00af\2\2\u0210\u0211\t\32\2\2\u0211\u026c\7\u00af\2\2\u0212\u0213"+
		"\t\33\2\2\u0213\u0214\7\u00af\2\2\u0214\u026c\7\u00af\2\2\u0215\u0216"+
		"\6\17\16\2\u0216\u0217\t\34\2\2\u0217\u0218\7\u00b0\2\2\u0218\u026c\7"+
		"\u00af\2\2\u0219\u021a\6\17\17\2\u021a\u021b\t\34\2\2\u021b\u021c\7\u00b0"+
		"\2\2\u021c\u021d\7\u00af\2\2\u021d\u026c\7\u00af\2\2\u021e\u0222\t\35"+
		"\2\2\u021f\u0220\t\36\2\2\u0220\u0222\7\u00b0\2\2\u0221\u021e\3\2\2\2"+
		"\u0221\u021f\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u026c\7\u00af\2\2\u0224"+
		"\u0225\7\u0084\2\2\u0225\u026c\7\u00af\2\2\u0226\u0227\7\u0085\2\2\u0227"+
		"\u0228\7\u00af\2\2\u0228\u026c\7\u00af\2\2\u0229\u022a\7\u0086\2\2\u022a"+
		"\u022b\7\u00af\2\2\u022b\u026c\7\u00af\2\2\u022c\u0230\7\u0087\2\2\u022d"+
		"\u022f\7\u00af\2\2\u022e\u022d\3\2\2\2\u022f\u0232\3\2\2\2\u0230\u022e"+
		"\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u026c\3\2\2\2\u0232\u0230\3\2\2\2\u0233"+
		"\u0234\t\37\2\2\u0234\u026c\7\u00af\2\2\u0235\u0236\t \2\2\u0236\u0238"+
		"\7\u00af\2\2\u0237\u0239\5\26\f\2\u0238\u0237\3\2\2\2\u0239\u023a\3\2"+
		"\2\2\u023a\u0238\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u026c\3\2\2\2\u023c"+
		"\u023d\6\17\20\2\u023d\u023e\7l\2\2\u023e\u023f\7\u00b0\2\2\u023f\u026c"+
		"\7\u00af\2\2\u0240\u0241\6\17\21\2\u0241\u0242\7l\2\2\u0242\u0243\7\u00b0"+
		"\2\2\u0243\u0245\7\u00af\2\2\u0244\u0246\5\26\f\2\u0245\u0244\3\2\2\2"+
		"\u0246\u0247\3\2\2\2\u0247\u0245\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u026c"+
		"\3\2\2\2\u0249\u024a\t!\2\2\u024a\u024c\7\u00af\2\2\u024b\u024d\5\26\f"+
		"\2\u024c\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u024c\3\2\2\2\u024e\u024f"+
		"\3\2\2\2\u024f\u026c\3\2\2\2\u0250\u0251\t\"\2\2\u0251\u0252\7\u00af\2"+
		"\2\u0252\u026c\7\u00af\2\2\u0253\u0254\6\17\22\2\u0254\u0255\7p\2\2\u0255"+
		"\u0256\7\u00b0\2\2\u0256\u0258\7\u00af\2\2\u0257\u0259\5\26\f\2\u0258"+
		"\u0257\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u0258\3\2\2\2\u025a\u025b\3\2"+
		"\2\2\u025b\u026c\3\2\2\2\u025c\u025d\6\17\23\2\u025d\u025e\7p\2\2\u025e"+
		"\u025f\7\u00b0\2\2\u025f\u0260\7\u00af\2\2\u0260\u026c\7\u00af\2\2\u0261"+
		"\u026c\7\u0094\2\2\u0262\u0263\7\u0095\2\2\u0263\u026c\7\u00b0\2\2\u0264"+
		"\u0268\7\u0096\2\2\u0265\u0267\7\u00af\2\2\u0266\u0265\3\2\2\2\u0267\u026a"+
		"\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u026c\3\2\2\2\u026a"+
		"\u0268\3\2\2\2\u026b\u01e6\3\2\2\2\u026b\u01ea\3\2\2\2\u026b\u01f1\3\2"+
		"\2\2\u026b\u01f7\3\2\2\2\u026b\u01fd\3\2\2\2\u026b\u0202\3\2\2\2\u026b"+
		"\u0204\3\2\2\2\u026b\u0207\3\2\2\2\u026b\u020b\3\2\2\2\u026b\u0210\3\2"+
		"\2\2\u026b\u0212\3\2\2\2\u026b\u0215\3\2\2\2\u026b\u0219\3\2\2\2\u026b"+
		"\u0221\3\2\2\2\u026b\u0224\3\2\2\2\u026b\u0226\3\2\2\2\u026b\u0229\3\2"+
		"\2\2\u026b\u022c\3\2\2\2\u026b\u0233\3\2\2\2\u026b\u0235\3\2\2\2\u026b"+
		"\u023c\3\2\2\2\u026b\u0240\3\2\2\2\u026b\u0249\3\2\2\2\u026b\u0250\3\2"+
		"\2\2\u026b\u0253\3\2\2\2\u026b\u025c\3\2\2\2\u026b\u0261\3\2\2\2\u026b"+
		"\u0262\3\2\2\2\u026b\u0264\3\2\2\2\u026c\35\3\2\2\2\u026d\u026f\7\u00b4"+
		"\2\2\u026e\u026d\3\2\2\2\u026f\u0272\3\2\2\2\u0270\u026e\3\2\2\2\u0270"+
		"\u0271\3\2\2\2\u0271\u027b\3\2\2\2\u0272\u0270\3\2\2\2\u0273\u0275\5 "+
		"\21\2\u0274\u0276\7\u00b4\2\2\u0275\u0274\3\2\2\2\u0276\u0277\3\2\2\2"+
		"\u0277\u0275\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027a"+
		"\5.\30\2\u027a\u027c\3\2\2\2\u027b\u0273\3\2\2\2\u027b\u027c\3\2\2\2\u027c"+
		"\37\3\2\2\2\u027d\u027e\7\u0097\2\2\u027e\u027f\7\u00b0\2\2\u027f\u0280"+
		"\7\22\2\2\u0280\u0281\7\u00b0\2\2\u0281\u0282\7\22\2\2\u0282\u0283\7\u00b0"+
		"\2\2\u0283\u0284\7\22\2\2\u0284\u0285\7\u0098\2\2\u0285!\3\2\2\2\u0286"+
		"\u028a\7\20\2\2\u0287\u0289\7\u00b4\2\2\u0288\u0287\3\2\2\2\u0289\u028c"+
		"\3\2\2\2\u028a\u0288\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u028d\3\2\2\2\u028c"+
		"\u028a\3\2\2\2\u028d\u0291\7\u0095\2\2\u028e\u0290\7\u00b4\2\2\u028f\u028e"+
		"\3\2\2\2\u0290\u0293\3\2\2\2\u0291\u028f\3\2\2\2\u0291\u0292\3\2\2\2\u0292"+
		"\u0294\3\2\2\2\u0293\u0291\3\2\2\2\u0294\u029f\5$\23\2\u0295\u0297\7\u00b4"+
		"\2\2\u0296\u0295\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u0296\3\2\2\2\u0298"+
		"\u0299\3\2\2\2\u0299\u029b\3\2\2\2\u029a\u029c\5$\23\2\u029b\u029a\3\2"+
		"\2\2\u029b\u029c\3\2\2\2\u029c\u029e\3\2\2\2\u029d\u0296\3\2\2\2\u029e"+
		"\u02a1\3\2\2\2\u029f\u029d\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0\u02a2\3\2"+
		"\2\2\u02a1\u029f\3\2\2\2\u02a2\u02a6\7\21\2\2\u02a3\u02a5\7\u00b4\2\2"+
		"\u02a4\u02a3\3\2\2\2\u02a5\u02a8\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a6\u02a7"+
		"\3\2\2\2\u02a7#\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a9\u02ac\5&\24\2\u02aa"+
		"\u02ac\5(\25\2\u02ab\u02a9\3\2\2\2\u02ab\u02aa\3\2\2\2\u02ac%\3\2\2\2"+
		"\u02ad\u02ae\7\u00b0\2\2\u02ae\u02af\7\22\2\2\u02af\u02b0\5\26\f\2\u02b0"+
		"\'\3\2\2\2\u02b1\u02b2\7\u0099\2\2\u02b2\u02b4\7\u00b0\2\2\u02b3\u02b5"+
		"\7\u00b4\2\2\u02b4\u02b3\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02b6\3\2\2"+
		"\2\u02b6\u02b7\7\27\2\2\u02b7\u02bc\5,\27\2\u02b8\u02b9\7\r\2\2\u02b9"+
		"\u02bb\5,\27\2\u02ba\u02b8\3\2\2\2\u02bb\u02be\3\2\2\2\u02bc\u02ba\3\2"+
		"\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02bf\3\2\2\2\u02be\u02bc\3\2\2\2\u02bf"+
		"\u02c0\7\30\2\2\u02c0\u02c1\7\n\2\2\u02c1\u02cb\5\32\16\2\u02c2\u02c4"+
		"\7\u00b4\2\2\u02c3\u02c2\3\2\2\2\u02c4\u02c7\3\2\2\2\u02c5\u02c3\3\2\2"+
		"\2\u02c5\u02c6\3\2\2\2\u02c6\u02c8\3\2\2\2\u02c7\u02c5\3\2\2\2\u02c8\u02ca"+
		"\5*\26\2\u02c9\u02c5\3\2\2\2\u02ca\u02cd\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cb"+
		"\u02cc\3\2\2\2\u02cc)\3\2\2\2\u02cd\u02cb\3\2\2\2\u02ce\u02cf\7T\2\2\u02cf"+
		"\u02d0\5\26\f\2\u02d0\u02d4\7\r\2\2\u02d1\u02d3\7\u00b4\2\2\u02d2\u02d1"+
		"\3\2\2\2\u02d3\u02d6\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5"+
		"\u02d7\3\2\2\2\u02d6\u02d4\3\2\2\2\u02d7\u02d8\7\u009a\2\2\u02d8\u02d9"+
		"\5\26\f\2\u02d9\u02da\7\27\2\2\u02da\u02db\7\u00b0\2\2\u02db\u02dc\7\30"+
		"\2\2\u02dc+\3\2\2\2\u02dd\u02de\7\u00b0\2\2\u02de\u02df\7\n\2\2\u02df"+
		"\u02e0\5\32\16\2\u02e0-\3\2\2\2\u02e1\u02e3\5\60\31\2\u02e2\u02e1\3\2"+
		"\2\2\u02e2\u02e3\3\2\2\2\u02e3\u02ee\3\2\2\2\u02e4\u02e6\7\u00b4\2\2\u02e5"+
		"\u02e4\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02e5\3\2\2\2\u02e7\u02e8\3\2"+
		"\2\2\u02e8\u02ea\3\2\2\2\u02e9\u02eb\5\60\31\2\u02ea\u02e9\3\2\2\2\u02ea"+
		"\u02eb\3\2\2\2\u02eb\u02ed\3\2\2\2\u02ec\u02e5\3\2\2\2\u02ed\u02f0\3\2"+
		"\2\2\u02ee\u02ec\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef/\3\2\2\2\u02f0\u02ee"+
		"\3\2\2\2\u02f1\u02f2\t#\2\2\u02f2\u02f3\7\u00b0\2\2\u02f3\u02f4\7\n\2"+
		"\2\u02f4\u02f5\5\32\16\2\u02f5\u02f7\7T\2\2\u02f6\u02f8\7\u00b4\2\2\u02f7"+
		"\u02f6\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fa\5\66"+
		"\34\2\u02fa\u03a5\3\2\2\2\u02fb\u02fc\7\u00b0\2\2\u02fc\u02fe\7T\2\2\u02fd"+
		"\u02ff\7\u00b4\2\2\u02fe\u02fd\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0300"+
		"\3\2\2\2\u0300\u03a5\5\66\34\2\u0301\u0302\7\23\2\2\u0302\u0303\7\27\2"+
		"\2\u0303\u0304\5\66\34\2\u0304\u0305\7\30\2\2\u0305\u03a5\3\2\2\2\u0306"+
		"\u0307\7\u009d\2\2\u0307\u0308\7\27\2\2\u0308\u0309\5\66\34\2\u0309\u030a"+
		"\7\30\2\2\u030a\u03a5\3\2\2\2\u030b\u030c\7\u009a\2\2\u030c\u030d\7\27"+
		"\2\2\u030d\u030e\5\66\34\2\u030e\u0312\7\30\2\2\u030f\u0311\7\u00b4\2"+
		"\2\u0310\u030f\3\2\2\2\u0311\u0314\3\2\2\2\u0312\u0310\3\2\2\2\u0312\u0313"+
		"\3\2\2\2\u0313\u0315\3\2\2\2\u0314\u0312\3\2\2\2\u0315\u0316\7\20\2\2"+
		"\u0316\u0317\5.\30\2\u0317\u0323\7\21\2\2\u0318\u031c\7\u009e\2\2\u0319"+
		"\u031b\7\u00b4\2\2\u031a\u0319\3\2\2\2\u031b\u031e\3\2\2\2\u031c\u031a"+
		"\3\2\2\2\u031c\u031d\3\2\2\2\u031d\u031f\3\2\2\2\u031e\u031c\3\2\2\2\u031f"+
		"\u0320\7\20\2\2\u0320\u0321\5.\30\2\u0321\u0322\7\21\2\2\u0322\u0324\3"+
		"\2\2\2\u0323\u0318\3\2\2\2\u0323\u0324\3\2\2\2\u0324\u03a5\3\2\2\2\u0325"+
		"\u0326\7\u009f\2\2\u0326\u0327\7\27\2\2\u0327\u0328\5\66\34\2\u0328\u032c"+
		"\7\30\2\2\u0329\u032b\7\u00b4\2\2\u032a\u0329\3\2\2\2\u032b\u032e\3\2"+
		"\2\2\u032c\u032a\3\2\2\2\u032c\u032d\3\2\2\2\u032d\u032f\3\2\2\2\u032e"+
		"\u032c\3\2\2\2\u032f\u033a\7\20\2\2\u0330\u0332\7\u00b4\2\2\u0331\u0330"+
		"\3\2\2\2\u0332\u0335\3\2\2\2\u0333\u0331\3\2\2\2\u0333\u0334\3\2\2\2\u0334"+
		"\u0336\3\2\2\2\u0335\u0333\3\2\2\2\u0336\u0337\7\u00a0\2\2\u0337\u0338"+
		"\58\35\2\u0338\u0339\7\u00a1\2\2\u0339\u033b\3\2\2\2\u033a\u0333\3\2\2"+
		"\2\u033a\u033b\3\2\2\2\u033b\u033c\3\2\2\2\u033c\u033d\5.\30\2\u033d\u033e"+
		"\7\21\2\2\u033e\u03a5\3\2\2\2\u033f\u0340\t$\2\2\u0340\u0349\7\27\2\2"+
		"\u0341\u0346\5\62\32\2\u0342\u0343\7\r\2\2\u0343\u0345\5\62\32\2\u0344"+
		"\u0342\3\2\2\2\u0345\u0348\3\2\2\2\u0346\u0344\3\2\2\2\u0346\u0347\3\2"+
		"\2\2\u0347\u034a\3\2\2\2\u0348\u0346\3\2\2\2\u0349\u0341\3\2\2\2\u0349"+
		"\u034a\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u03a5\7\30\2\2\u034c\u034d\7"+
		"\u00b0\2\2\u034d\u034e\7\27\2\2\u034e\u034f\5\66\34\2\u034f\u0350\7\30"+
		"\2\2\u0350\u0352\7T\2\2\u0351\u0353\7\u00b4\2\2\u0352\u0351\3\2\2\2\u0352"+
		"\u0353\3\2\2\2\u0353\u0354\3\2\2\2\u0354\u0355\5\66\34\2\u0355\u03a5\3"+
		"\2\2\2\u0356\u0357\7\u00a4\2\2\u0357\u0359\7\u00b0\2\2\u0358\u0356\3\2"+
		"\2\2\u0358\u0359\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u035b\7\u0099\2\2\u035b"+
		"\u035d\7\u00b0\2\2\u035c\u035e\7\u00b4\2\2\u035d\u035c\3\2\2\2\u035d\u035e"+
		"\3\2\2\2\u035e\u035f\3\2\2\2\u035f\u0368\7\27\2\2\u0360\u0365\5,\27\2"+
		"\u0361\u0362\7\r\2\2\u0362\u0364\5,\27\2\u0363\u0361\3\2\2\2\u0364\u0367"+
		"\3\2\2\2\u0365\u0363\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u0369\3\2\2\2\u0367"+
		"\u0365\3\2\2\2\u0368\u0360\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u036a\3\2"+
		"\2\2\u036a\u036b\7\30\2\2\u036b\u036e\7\n\2\2\u036c\u036f\5\32\16\2\u036d"+
		"\u036f\7\u00a5\2\2\u036e\u036c\3\2\2\2\u036e\u036d\3\2\2\2\u036f\u0370"+
		"\3\2\2\2\u0370\u0374\7T\2\2\u0371\u0373\7\u00b4\2\2\u0372\u0371\3\2\2"+
		"\2\u0373\u0376\3\2\2\2\u0374\u0372\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u0377"+
		"\3\2\2\2\u0376\u0374\3\2\2\2\u0377\u0388\7\20\2\2\u0378\u037a\7\u00b4"+
		"\2\2\u0379\u0378\3\2\2\2\u037a\u037d\3\2\2\2\u037b\u0379\3\2\2\2\u037b"+
		"\u037c\3\2\2\2\u037c\u037e\3\2\2\2\u037d\u037b\3\2\2\2\u037e\u037f\7\u00a0"+
		"\2\2\u037f\u0383\5<\37\2\u0380\u0382\7\u00b4\2\2\u0381\u0380\3\2\2\2\u0382"+
		"\u0385\3\2\2\2\u0383\u0381\3\2\2\2\u0383\u0384\3\2\2\2\u0384\u0386\3\2"+
		"\2\2\u0385\u0383\3\2\2\2\u0386\u0387\7\u00a1\2\2\u0387\u0389\3\2\2\2\u0388"+
		"\u037b\3\2\2\2\u0388\u0389\3\2\2\2\u0389\u038a\3\2\2\2\u038a\u0395\5."+
		"\30\2\u038b\u038d\7\u00a6\2\2\u038c\u038e\5\66\34\2\u038d\u038c\3\2\2"+
		"\2\u038d\u038e\3\2\2\2\u038e\u0392\3\2\2\2\u038f\u0391\7\u00b4\2\2\u0390"+
		"\u038f\3\2\2\2\u0391\u0394\3\2\2\2\u0392\u0390\3\2\2\2\u0392\u0393\3\2"+
		"\2\2\u0393\u0396\3\2\2\2\u0394\u0392\3\2\2\2\u0395\u038b\3\2\2\2\u0395"+
		"\u0396\3\2\2\2\u0396\u0397\3\2\2\2\u0397\u0398\7\21\2\2\u0398\u03a5\3"+
		"\2\2\2\u0399\u039e\7\u00a0\2\2\u039a\u039f\5\20\t\2\u039b\u039f\5\16\b"+
		"\2\u039c\u039f\5> \2\u039d\u039f\5\"\22\2\u039e\u039a\3\2\2\2\u039e\u039b"+
		"\3\2\2\2\u039e\u039c\3\2\2\2\u039e\u039d\3\2\2\2\u039f\u03a0\3\2\2\2\u03a0"+
		"\u03a1\7\u00a1\2\2\u03a1\u03a5\3\2\2\2\u03a2\u03a5\5 \21\2\u03a3\u03a5"+
		"\5\66\34\2\u03a4\u02f1\3\2\2\2\u03a4\u02fb\3\2\2\2\u03a4\u0301\3\2\2\2"+
		"\u03a4\u0306\3\2\2\2\u03a4\u030b\3\2\2\2\u03a4\u0325\3\2\2\2\u03a4\u033f"+
		"\3\2\2\2\u03a4\u034c\3\2\2\2\u03a4\u0358\3\2\2\2\u03a4\u0399\3\2\2\2\u03a4"+
		"\u03a2\3\2\2\2\u03a4\u03a3\3\2\2\2\u03a5\61\3\2\2\2\u03a6\u03a9\7\u00b8"+
		"\2\2\u03a7\u03a9\5\66\34\2\u03a8\u03a6\3\2\2\2\u03a8\u03a7\3\2\2\2\u03a9"+
		"\63\3\2\2\2\u03aa\u03d0\t\6\2\2\u03ab\u03d0\7\u00af\2\2\u03ac\u03d0\7"+
		"\u00b0\2\2\u03ad\u03ae\t\b\2\2\u03ae\u03af\7\22\2\2\u03af\u03b0\7\u00b0"+
		"\2\2\u03b0\u03b9\7\27\2\2\u03b1\u03b6\5\66\34\2\u03b2\u03b3\7\r\2\2\u03b3"+
		"\u03b5\5\66\34\2\u03b4\u03b2\3\2\2\2\u03b5\u03b8\3\2\2\2\u03b6\u03b4\3"+
		"\2\2\2\u03b6\u03b7\3\2\2\2\u03b7\u03ba\3\2\2\2\u03b8\u03b6\3\2\2\2\u03b9"+
		"\u03b1\3\2\2\2\u03b9\u03ba\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03d0\7\30"+
		"\2\2\u03bc\u03bd\t\23\2\2\u03bd\u03be\7\22\2\2\u03be\u03d0\7\u00b0\2\2"+
		"\u03bf\u03d0\7\u00b9\2\2\u03c0\u03d0\7\u00b2\2\2\u03c1\u03d0\7\u00b1\2"+
		"\2\u03c2\u03c3\t\b\2\2\u03c3\u03cc\7\27\2\2\u03c4\u03c9\5\66\34\2\u03c5"+
		"\u03c6\7\r\2\2\u03c6\u03c8\5\66\34\2\u03c7\u03c5\3\2\2\2\u03c8\u03cb\3"+
		"\2\2\2\u03c9\u03c7\3\2\2\2\u03c9\u03ca\3\2\2\2\u03ca\u03cd\3\2\2\2\u03cb"+
		"\u03c9\3\2\2\2\u03cc\u03c4\3\2\2\2\u03cc\u03cd\3\2\2\2\u03cd\u03ce\3\2"+
		"\2\2\u03ce\u03d0\7\30\2\2\u03cf\u03aa\3\2\2\2\u03cf\u03ab\3\2\2\2\u03cf"+
		"\u03ac\3\2\2\2\u03cf\u03ad\3\2\2\2\u03cf\u03bc\3\2\2\2\u03cf\u03bf\3\2"+
		"\2\2\u03cf\u03c0\3\2\2\2\u03cf\u03c1\3\2\2\2\u03cf\u03c2\3\2\2\2\u03d0"+
		"\65\3\2\2\2\u03d1\u03d2\b\34\1\2\u03d2\u03d3\7\u00b0\2\2\u03d3\u03dc\7"+
		"\27\2\2\u03d4\u03d9\5\66\34\2\u03d5\u03d6\7\r\2\2\u03d6\u03d8\5\66\34"+
		"\2\u03d7\u03d5\3\2\2\2\u03d8\u03db\3\2\2\2\u03d9\u03d7\3\2\2\2\u03d9\u03da"+
		"\3\2\2\2\u03da\u03dd\3\2\2\2\u03db\u03d9\3\2\2\2\u03dc\u03d4\3\2\2\2\u03dc"+
		"\u03dd\3\2\2\2\u03dd\u03de\3\2\2\2\u03de\u03f7\7\30\2\2\u03df\u03e4\5"+
		"\64\33\2\u03e0\u03e1\7\22\2\2\u03e1\u03e3\7\u00b0\2\2\u03e2\u03e0\3\2"+
		"\2\2\u03e3\u03e6\3\2\2\2\u03e4\u03e2\3\2\2\2\u03e4\u03e5\3\2\2\2\u03e5"+
		"\u03f7\3\2\2\2\u03e6\u03e4\3\2\2\2\u03e7\u03e8\7\u00a7\2\2\u03e8\u03e9"+
		"\7\27\2\2\u03e9\u03f7\7\30\2\2\u03ea\u03eb\7\u00a8\2\2\u03eb\u03ed\7\27"+
		"\2\2\u03ec\u03ee\7\u00b8\2\2\u03ed\u03ec\3\2\2\2\u03ed\u03ee\3\2\2\2\u03ee"+
		"\u03ef\3\2\2\2\u03ef\u03f7\7\30\2\2\u03f0\u03f1\7\27\2\2\u03f1\u03f2\5"+
		"\66\34\2\u03f2\u03f3\7\30\2\2\u03f3\u03f7\3\2\2\2\u03f4\u03f5\t%\2\2\u03f5"+
		"\u03f7\5\66\34\f\u03f6\u03d1\3\2\2\2\u03f6\u03df\3\2\2\2\u03f6\u03e7\3"+
		"\2\2\2\u03f6\u03ea\3\2\2\2\u03f6\u03f0\3\2\2\2\u03f6\u03f4\3\2\2\2\u03f7"+
		"\u0430\3\2\2\2\u03f8\u03f9\f\13\2\2\u03f9\u03fb\t\n\2\2\u03fa\u03fc\7"+
		"\u00b4\2\2\u03fb\u03fa\3\2\2\2\u03fb\u03fc\3\2\2\2\u03fc\u03fd\3\2\2\2"+
		"\u03fd\u042f\5\66\34\f\u03fe\u03ff\f\n\2\2\u03ff\u0401\t\13\2\2\u0400"+
		"\u0402\7\u00b4\2\2\u0401\u0400\3\2\2\2\u0401\u0402\3\2\2\2\u0402\u0403"+
		"\3\2\2\2\u0403\u042f\5\66\34\13\u0404\u0405\f\t\2\2\u0405\u0407\7I\2\2"+
		"\u0406\u0408\7\u00b4\2\2\u0407\u0406\3\2\2\2\u0407\u0408\3\2\2\2\u0408"+
		"\u0409\3\2\2\2\u0409\u042f\5\66\34\t\u040a\u040b\f\b\2\2\u040b\u040d\7"+
		"J\2\2\u040c\u040e\7\u00b4\2\2\u040d\u040c\3\2\2\2\u040d\u040e\3\2\2\2"+
		"\u040e\u040f\3\2\2\2\u040f\u042f\5\66\34\t\u0410\u0411\f\7\2\2\u0411\u0413"+
		"\t&\2\2\u0412\u0414\7\u00b4\2\2\u0413\u0412\3\2\2\2\u0413\u0414\3\2\2"+
		"\2\u0414\u0415\3\2\2\2\u0415\u042f\5\66\34\b\u0416\u0417\f\6\2\2\u0417"+
		"\u0419\t\'\2\2\u0418\u041a\7\u00b4\2\2\u0419\u0418\3\2\2\2\u0419\u041a"+
		"\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u042f\5\66\34\7\u041c\u041d\f\5\2\2"+
		"\u041d\u041f\7^\2\2\u041e\u0420\7\u00b4\2\2\u041f\u041e\3\2\2\2\u041f"+
		"\u0420\3\2\2\2\u0420\u0421\3\2\2\2\u0421\u042f\5\66\34\6\u0422\u0423\f"+
		"\4\2\2\u0423\u0425\7b\2\2\u0424\u0426\7\u00b4\2\2\u0425\u0424\3\2\2\2"+
		"\u0425\u0426\3\2\2\2\u0426\u0427\3\2\2\2\u0427\u042f\5\66\34\5\u0428\u0429"+
		"\f\3\2\2\u0429\u042b\7\4\2\2\u042a\u042c\7\u00b4\2\2\u042b\u042a\3\2\2"+
		"\2\u042b\u042c\3\2\2\2\u042c\u042d\3\2\2\2\u042d\u042f\5\66\34\4\u042e"+
		"\u03f8\3\2\2\2\u042e\u03fe\3\2\2\2\u042e\u0404\3\2\2\2\u042e\u040a\3\2"+
		"\2\2\u042e\u0410\3\2\2\2\u042e\u0416\3\2\2\2\u042e\u041c\3\2\2\2\u042e"+
		"\u0422\3\2\2\2\u042e\u0428\3\2\2\2\u042f\u0432\3\2\2\2\u0430\u042e\3\2"+
		"\2\2\u0430\u0431\3\2\2\2\u0431\67\3\2\2\2\u0432\u0430\3\2\2\2\u0433\u0437"+
		"\7\20\2\2\u0434\u0436\7\u00b4\2\2\u0435\u0434\3\2\2\2\u0436\u0439\3\2"+
		"\2\2\u0437\u0435\3\2\2\2\u0437\u0438\3\2\2\2\u0438\u043a\3\2\2\2\u0439"+
		"\u0437\3\2\2\2\u043a\u043b\5:\36\2\u043b\u043f\7\21\2\2\u043c\u043e\7"+
		"\u00b4\2\2\u043d\u043c\3\2\2\2\u043e\u0441\3\2\2\2\u043f\u043d\3\2\2\2"+
		"\u043f\u0440\3\2\2\2\u0440\u0469\3\2\2\2\u0441\u043f\3\2\2\2\u0442\u0446"+
		"\7\20\2\2\u0443\u0445\7\u00b4\2\2\u0444\u0443\3\2\2\2\u0445\u0448\3\2"+
		"\2\2\u0446\u0444\3\2\2\2\u0446\u0447\3\2\2\2\u0447\u0449\3\2\2\2\u0448"+
		"\u0446\3\2\2\2\u0449\u044d\7\u0094\2\2\u044a\u044c\7\u00b4\2\2\u044b\u044a"+
		"\3\2\2\2\u044c\u044f\3\2\2\2\u044d\u044b\3\2\2\2\u044d\u044e\3\2\2\2\u044e"+
		"\u0450\3\2\2\2\u044f\u044d\3\2\2\2\u0450\u045b\5\26\f\2\u0451\u0453\7"+
		"\u00b4\2\2\u0452\u0451\3\2\2\2\u0453\u0454\3\2\2\2\u0454\u0452\3\2\2\2"+
		"\u0454\u0455\3\2\2\2\u0455\u0457\3\2\2\2\u0456\u0458\5\26\f\2\u0457\u0456"+
		"\3\2\2\2\u0457\u0458\3\2\2\2\u0458\u045a\3\2\2\2\u0459\u0452\3\2\2\2\u045a"+
		"\u045d\3\2\2\2\u045b\u0459\3\2\2\2\u045b\u045c\3\2\2\2\u045c\u045f\3\2"+
		"\2\2\u045d\u045b\3\2\2\2\u045e\u0460\5:\36\2\u045f\u045e\3\2\2\2\u045f"+
		"\u0460\3\2\2\2\u0460\u0461\3\2\2\2\u0461\u0465\7\21\2\2\u0462\u0464\7"+
		"\u00b4\2\2\u0463\u0462\3\2\2\2\u0464\u0467\3\2\2\2\u0465\u0463\3\2\2\2"+
		"\u0465\u0466\3\2\2\2\u0466\u0469\3\2\2\2\u0467\u0465\3\2\2\2\u0468\u0433"+
		"\3\2\2\2\u0468\u0442\3\2\2\2\u04699\3\2\2\2\u046a\u046b\7\u00a9\2\2\u046b"+
		"\u0470\7\u00b0\2\2\u046c\u046d\7\r\2\2\u046d\u046f\7\u00b0\2\2\u046e\u046c"+
		"\3\2\2\2\u046f\u0472\3\2\2\2\u0470\u046e\3\2\2\2\u0470\u0471\3\2\2\2\u0471"+
		"\u0476\3\2\2\2\u0472\u0470\3\2\2\2\u0473\u0475\7\u00b4\2\2\u0474\u0473"+
		"\3\2\2\2\u0475\u0478\3\2\2\2\u0476\u0474\3\2\2\2\u0476\u0477\3\2\2\2\u0477"+
		";\3\2\2\2\u0478\u0476\3\2\2\2\u0479\u047d\7\20\2\2\u047a\u047c\7\u00b4"+
		"\2\2\u047b\u047a\3\2\2\2\u047c\u047f\3\2\2\2\u047d\u047b\3\2\2\2\u047d"+
		"\u047e\3\2\2\2\u047e\u0495\3\2\2\2\u047f\u047d\3\2\2\2\u0480\u0484\t("+
		"\2\2\u0481\u0483\7\u00b4\2\2\u0482\u0481\3\2\2\2\u0483\u0486\3\2\2\2\u0484"+
		"\u0482\3\2\2\2\u0484\u0485\3\2\2\2\u0485\u0487\3\2\2\2\u0486\u0484\3\2"+
		"\2\2\u0487\u0492\5\26\f\2\u0488\u048a\7\u00b4\2\2\u0489\u0488\3\2\2\2"+
		"\u048a\u048b\3\2\2\2\u048b\u0489\3\2\2\2\u048b\u048c\3\2\2\2\u048c\u048e"+
		"\3\2\2\2\u048d\u048f\5\26\f\2\u048e\u048d\3\2\2\2\u048e\u048f\3\2\2\2"+
		"\u048f\u0491\3\2\2\2\u0490\u0489\3\2\2\2\u0491\u0494\3\2\2\2\u0492\u0490"+
		"\3\2\2\2\u0492\u0493\3\2\2\2\u0493\u0496\3\2\2\2\u0494\u0492\3\2\2\2\u0495"+
		"\u0480\3\2\2\2\u0495\u0496\3\2\2\2\u0496\u049a\3\2\2\2\u0497\u0499\7\u00b4"+
		"\2\2\u0498\u0497\3\2\2\2\u0499\u049c\3\2\2\2\u049a\u0498\3\2\2\2\u049a"+
		"\u049b\3\2\2\2\u049b\u049e\3\2\2\2\u049c\u049a\3\2\2\2\u049d\u049f\5:"+
		"\36\2\u049e\u049d\3\2\2\2\u049e\u049f\3\2\2\2\u049f\u04b5\3\2\2\2\u04a0"+
		"\u04a4\t)\2\2\u04a1\u04a3\7\u00b4\2\2\u04a2\u04a1\3\2\2\2\u04a3\u04a6"+
		"\3\2\2\2\u04a4\u04a2\3\2\2\2\u04a4\u04a5\3\2\2\2\u04a5\u04a7\3\2\2\2\u04a6"+
		"\u04a4\3\2\2\2\u04a7\u04b2\5\26\f\2\u04a8\u04aa\7\u00b4\2\2\u04a9\u04a8"+
		"\3\2\2\2\u04aa\u04ab\3\2\2\2\u04ab\u04a9\3\2\2\2\u04ab\u04ac\3\2\2\2\u04ac"+
		"\u04ae\3\2\2\2\u04ad\u04af\5\26\f\2\u04ae\u04ad\3\2\2\2\u04ae\u04af\3"+
		"\2\2\2\u04af\u04b1\3\2\2\2\u04b0\u04a9\3\2\2\2\u04b1\u04b4\3\2\2\2\u04b2"+
		"\u04b0\3\2\2\2\u04b2\u04b3\3\2\2\2\u04b3\u04b6\3\2\2\2\u04b4\u04b2\3\2"+
		"\2\2\u04b5\u04a0\3\2\2\2\u04b5\u04b6\3\2\2\2\u04b6\u04ba\3\2\2\2\u04b7"+
		"\u04b9\7\u00b4\2\2\u04b8\u04b7\3\2\2\2\u04b9\u04bc\3\2\2\2\u04ba\u04b8"+
		"\3\2\2\2\u04ba\u04bb\3\2\2\2\u04bb\u04bd\3\2\2\2\u04bc\u04ba\3\2\2\2\u04bd"+
		"\u04c1\7\21\2\2\u04be\u04c0\7\u00b4\2\2\u04bf\u04be\3\2\2\2\u04c0\u04c3"+
		"\3\2\2\2\u04c1\u04bf\3\2\2\2\u04c1\u04c2\3\2\2\2\u04c2=\3\2\2\2\u04c3"+
		"\u04c1\3\2\2\2\u04c4\u04c8\7\20\2\2\u04c5\u04c7\7\u00b4\2\2\u04c6\u04c5"+
		"\3\2\2\2\u04c7\u04ca\3\2\2\2\u04c8\u04c6\3\2\2\2\u04c8\u04c9\3\2\2\2\u04c9"+
		"\u04cb\3\2\2\2\u04ca\u04c8\3\2\2\2\u04cb\u04cf\7\u0094\2\2\u04cc\u04ce"+
		"\7\u00b4\2\2\u04cd\u04cc\3\2\2\2\u04ce\u04d1\3\2\2\2\u04cf\u04cd\3\2\2"+
		"\2\u04cf\u04d0\3\2\2\2\u04d0\u04d2\3\2\2\2\u04d1\u04cf\3\2\2\2\u04d2\u04dd"+
		"\5\26\f\2\u04d3\u04d5\7\u00b4\2\2\u04d4\u04d3\3\2\2\2\u04d5\u04d6\3\2"+
		"\2\2\u04d6\u04d4\3\2\2\2\u04d6\u04d7\3\2\2\2\u04d7\u04d9\3\2\2\2\u04d8"+
		"\u04da\5\26\f\2\u04d9\u04d8\3\2\2\2\u04d9\u04da\3\2\2\2\u04da\u04dc\3"+
		"\2\2\2\u04db\u04d4\3\2\2\2\u04dc\u04df\3\2\2\2\u04dd\u04db\3\2\2\2\u04dd"+
		"\u04de\3\2\2\2\u04de\u04e0\3\2\2\2\u04df\u04dd\3\2\2\2\u04e0\u04e4\7\21"+
		"\2\2\u04e1\u04e3\7\u00b4\2\2\u04e2\u04e1\3\2\2\2\u04e3\u04e6\3\2\2\2\u04e4"+
		"\u04e2\3\2\2\2\u04e4\u04e5\3\2\2\2\u04e5?\3\2\2\2\u04e6\u04e4\3\2\2\2"+
		"\u00b4GKPX]djov|\u0081\u0087\u008d\u0090\u0095\u009b\u00a2\u00ab\u00b3"+
		"\u00b9\u00c1\u00c4\u00ca\u00d3\u00d6\u00de\u00e4\u00eb\u00ed\u00f1\u00f6"+
		"\u00f9\u00fd\u0104\u0111\u0118\u0120\u0128\u012d\u0132\u0135\u0139\u013d"+
		"\u014b\u0158\u016c\u016f\u0172\u017a\u0182\u0187\u018d\u0193\u0199\u019f"+
		"\u01a5\u01ab\u01b1\u01b7\u01bd\u01c0\u01c2\u01cb\u01d4\u01d8\u01dd\u01e0"+
		"\u01ea\u01f1\u01f7\u01fd\u0221\u0230\u023a\u0247\u024e\u025a\u0268\u026b"+
		"\u0270\u0277\u027b\u028a\u0291\u0298\u029b\u029f\u02a6\u02ab\u02b4\u02bc"+
		"\u02c5\u02cb\u02d4\u02e2\u02e7\u02ea\u02ee\u02f7\u02fe\u0312\u031c\u0323"+
		"\u032c\u0333\u033a\u0346\u0349\u0352\u0358\u035d\u0365\u0368\u036e\u0374"+
		"\u037b\u0383\u0388\u038d\u0392\u0395\u039e\u03a4\u03a8\u03b6\u03b9\u03c9"+
		"\u03cc\u03cf\u03d9\u03dc\u03e4\u03ed\u03f6\u03fb\u0401\u0407\u040d\u0413"+
		"\u0419\u041f\u0425\u042b\u042e\u0430\u0437\u043f\u0446\u044d\u0454\u0457"+
		"\u045b\u045f\u0465\u0468\u0470\u0476\u047d\u0484\u048b\u048e\u0492\u0495"+
		"\u049a\u049e\u04a4\u04ab\u04ae\u04b2\u04b5\u04ba\u04c1\u04c8\u04cf\u04d6"+
		"\u04d9\u04dd\u04e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}