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
		RULE_funDefCond = 21, RULE_funDefSimple = 22, RULE_param = 23, RULE_stmts = 24, 
		RULE_stmt = 25, RULE_blockEnd = 26, RULE_returnStmt = 27, RULE_stringOrExp = 28, 
		RULE_primExp = 29, RULE_exp = 30, RULE_loopInvariant = 31, RULE_modifies = 32, 
		RULE_methodContract = 33, RULE_invariants = 34;
	public static final String[] ruleNames = {
		"file", "truthTable", "row", "bool", "status", "assignments", "sequent", 
		"proof", "proofStep", "primFormula", "formula", "qformula", "type", "justification", 
		"program", "impor", "facts", "factOrFun", "fact", "fun", "funDef", "funDefCond", 
		"funDefSimple", "param", "stmts", "stmt", "blockEnd", "returnStmt", "stringOrExp", 
		"primExp", "exp", "loopInvariant", "modifies", "methodContract", "invariants"
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
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new TruthTableFileContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				truthTable();
				setState(71);
				match(EOF);
				}
				break;
			case 2:
				_localctx = new SequentFileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(73);
					match(NL);
					}
					}
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(79);
				sequent();
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(80);
						match(NL);
						}
						} 
					}
					setState(85);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(86);
					proof();
					}
				}

				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(89);
					match(NL);
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(95);
				match(EOF);
				}
				break;
			case 3:
				_localctx = new ProgramFileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				program();
				setState(98);
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
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(102);
				match(NL);
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			((TruthTableContext)_localctx).star = match(T__0);
			setState(110); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109);
				match(NL);
				}
				}
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(114);
			match(HLINE);
			setState(116); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(115);
				match(NL);
				}
				}
				setState(118); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				((TruthTableContext)_localctx).ID = match(ID);
				((TruthTableContext)_localctx).vars.add(((TruthTableContext)_localctx).ID);
				}
				}
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(125);
			((TruthTableContext)_localctx).bar = match(T__1);
			setState(126);
			formula(0);
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(127);
				match(NL);
				}
				}
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(132);
			match(HLINE);
			setState(141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(134); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(133);
						match(NL);
						}
						}
						setState(136); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NL );
					setState(138);
					row();
					}
					} 
				}
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(145); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(144);
				match(NL);
				}
				}
				setState(147); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
			setState(149);
			match(HLINE);
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(150);
					match(NL);
					}
					}
					setState(153); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NL );
				setState(155);
				status();
				}
				break;
			}
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(158);
				match(NL);
				}
				}
				setState(163);
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
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) {
				{
				{
				setState(164);
				((RowContext)_localctx).bool = bool();
				((RowContext)_localctx).model.add(((RowContext)_localctx).bool);
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			((RowContext)_localctx).bar = match(T__1);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) {
				{
				{
				setState(171);
				((RowContext)_localctx).bool = bool();
				((RowContext)_localctx).eval.add(((RowContext)_localctx).bool);
				}
				}
				setState(176);
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
			setState(177);
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
			setState(179);
			match(ID);
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
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
				((StatusContext)_localctx).t = match(T__6);
				setState(186);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__3) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(187);
				match(T__7);
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(191);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(188);
							match(NL);
							}
							}
							setState(193);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(194);
						((StatusContext)_localctx).assignments = assignments();
						((StatusContext)_localctx).tContingentAssignments.add(((StatusContext)_localctx).assignments);
						}
						} 
					}
					setState(199);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(201); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(200);
					match(NL);
					}
					}
					setState(203); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NL );
				setState(205);
				match(T__6);
				setState(206);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(207);
				match(T__7);
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(211);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(208);
							match(NL);
							}
							}
							setState(213);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(214);
						((StatusContext)_localctx).assignments = assignments();
						((StatusContext)_localctx).fContingentAssignments.add(((StatusContext)_localctx).assignments);
						}
						} 
					}
					setState(219);
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
			setState(222);
			match(T__8);
			setState(224); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(223);
				bool();
				}
				}
				setState(226); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0) );
			setState(228);
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
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
					{
					setState(230);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(231);
						match(T__10);
						setState(232);
						((SequentContext)_localctx).formula = formula(0);
						((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
						}
						}
						setState(237);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(240);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__12) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(241);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(242);
					match(T__10);
					setState(243);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(248);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
					{
					{
					setState(249);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(254);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(255);
				match(HLINE);
				setState(257); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(256);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(259); 
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
			setState(263);
			((ProofContext)_localctx).tb = match(T__13);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(264);
				proofStep();
				}
			}

			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(268); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(267);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(270); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(272);
					proofStep();
					}
				}

				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(280);
			((ProofContext)_localctx).te = match(T__14);
			setState(284);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(281);
					match(NL);
					}
					} 
				}
				setState(286);
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
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				match(NUM);
				setState(288);
				match(T__15);
				setState(289);
				formula(0);
				setState(290);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(293);
				match(T__15);
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(294);
					match(NL);
					}
					}
					setState(299);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(300);
				match(T__13);
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(301);
					match(NL);
					}
					}
					setState(306);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(307);
				((SubProofContext)_localctx).assume = match(NUM);
				setState(308);
				match(T__15);
				setState(325);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(309);
					match(ID);
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__7) {
						{
						setState(310);
						match(T__7);
						setState(311);
						type();
						}
					}

					}
					break;
				case 2:
					{
					setState(314);
					formula(0);
					setState(315);
					((SubProofContext)_localctx).ate = match(T__16);
					}
					break;
				case 3:
					{
					setState(317);
					match(ID);
					setState(320);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__7) {
						{
						setState(318);
						match(T__7);
						setState(319);
						type();
						}
					}

					setState(322);
					formula(0);
					setState(323);
					((SubProofContext)_localctx).ate = match(T__16);
					}
					break;
				}
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(328); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(327);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(330); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(333);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NUM) {
						{
						setState(332);
						proofStep();
						}
					}

					}
					}
					setState(339);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(340);
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
			setState(394);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(343);
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
				setState(344);
				match(T__20);
				setState(345);
				formula(0);
				setState(346);
				match(T__21);
				}
				break;
			case 3:
				_localctx = new ApplyResultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(348);
				((ApplyResultContext)_localctx).tb = match(T__22);
				setState(349);
				match(T__20);
				setState(350);
				formula(0);
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(351);
					match(T__10);
					setState(352);
					formula(0);
					}
					}
					setState(357);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(358);
				match(T__21);
				}
				break;
			case 4:
				_localctx = new ResultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(360);
				match(T__22);
				}
				break;
			case 5:
				_localctx = new ApplyContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(361);
				match(ID);
				setState(362);
				match(T__20);
				setState(363);
				formula(0);
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(364);
					match(T__10);
					setState(365);
					formula(0);
					}
					}
					setState(370);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(371);
				match(T__21);
				}
				break;
			case 6:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(373);
				((VarContext)_localctx).tb = match(ID);
				}
				break;
			case 7:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(374);
				match(NUM);
				}
				break;
			case 8:
				_localctx = new IntLitContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(375);
				match(INT);
				}
				break;
			case 9:
				_localctx = new RLitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(376);
				match(REAL);
				}
				break;
			case 10:
				_localctx = new FloatLitContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(377);
				match(FLOAT);
				}
				break;
			case 11:
				_localctx = new TypeAccessContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(378);
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
				setState(379);
				match(T__15);
				setState(380);
				match(ID);
				}
				break;
			case 12:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(381);
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
				setState(382);
				match(T__20);
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(383);
					exp(0);
					setState(388);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(384);
						match(T__10);
						setState(385);
						exp(0);
						}
						}
						setState(390);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(393);
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
			setState(410);
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

				setState(397);
				primFormula();
				setState(402);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(398);
						match(T__15);
						setState(399);
						match(ID);
						}
						} 
					}
					setState(404);
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
				setState(405);
				((UnaryContext)_localctx).op = match(T__6);
				setState(406);
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
				setState(407);
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
				setState(408);
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
				setState(409);
				qformula();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(474);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(472);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(412);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(413);
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
						setState(415);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(414);
							match(NL);
							}
						}

						setState(417);
						((BinaryContext)_localctx).r = formula(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(418);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(419);
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
						setState(421);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(420);
							match(NL);
							}
						}

						setState(423);
						((BinaryContext)_localctx).r = formula(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(424);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(425);
						((BinaryContext)_localctx).op = match(T__70);
						setState(427);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(426);
							match(NL);
							}
						}

						setState(429);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(430);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(431);
						((BinaryContext)_localctx).op = match(T__71);
						setState(433);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(432);
							match(NL);
							}
						}

						setState(435);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(436);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(437);
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
						setState(439);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(438);
							match(NL);
							}
						}

						setState(441);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(442);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(443);
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
						setState(445);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(444);
							match(NL);
							}
						}

						setState(447);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(448);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(449);
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
						setState(451);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(450);
							match(NL);
							}
						}

						setState(453);
						((BinaryContext)_localctx).r = formula(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(454);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(455);
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
						setState(457);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(456);
							match(NL);
							}
						}

						setState(459);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(460);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(461);
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
						setState(463);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(462);
							match(NL);
							}
						}

						setState(465);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 10:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(466);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(467);
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
						setState(469);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(468);
							match(NL);
							}
						}

						setState(471);
						((BinaryContext)_localctx).r = formula(2);
						}
						break;
					}
					} 
				}
				setState(476);
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
			setState(477);
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
			setState(478);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(479);
				match(T__10);
				setState(480);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(485);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(501);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(486);
				match(T__7);
				setState(487);
				type();
				}
				break;
			case 2:
				{
				setState(488);
				match(T__7);
				setState(489);
				match(T__20);
				setState(490);
				((QformulaContext)_localctx).lo = formula(0);
				setState(492);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__72) {
					{
					setState(491);
					((QformulaContext)_localctx).ll = match(T__72);
					}
				}

				setState(494);
				match(T__110);
				setState(496);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__72) {
					{
					setState(495);
					((QformulaContext)_localctx).lh = match(T__72);
					}
				}

				setState(498);
				((QformulaContext)_localctx).hi = formula(0);
				setState(499);
				match(T__21);
				}
				break;
			}
			setState(504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(503);
				match(NL);
				}
			}

			setState(506);
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
			setState(508);
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
			setState(643);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(510);
				((PremiseContext)_localctx).t = match(T__111);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(514);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__112:
					{
					setState(511);
					((AndIntroContext)_localctx).tb = match(T__112);
					}
					break;
				case T__91:
				case T__92:
				case T__93:
					{
					setState(512);
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
					setState(513);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(516);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(517);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(521);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__113:
				case T__114:
					{
					setState(518);
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
					setState(519);
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
					setState(520);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(523);
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(527);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__115:
				case T__116:
				case T__117:
				case T__118:
					{
					setState(524);
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
					setState(525);
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
					setState(526);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(529);
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(533);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__119:
				case T__120:
					{
					setState(530);
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
					setState(531);
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
					setState(532);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(535);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(536);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(537);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(538);
				((ImpliesIntroContext)_localctx).tb = match(T__121);
				setState(539);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(540);
				((ImpliesElimContext)_localctx).tb = match(T__122);
				setState(541);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(542);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(543);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(544);
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
				setState(545);
				match(ID);
				setState(546);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(547);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				      "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n      \"e\".equals(_input.LT(2).getText())");
				setState(548);
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
				setState(549);
				match(ID);
				setState(550);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(551);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(552);
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
				setState(553);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 11:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(554);
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
				setState(555);
				((NegElimContext)_localctx).step = match(NUM);
				setState(556);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 12:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(557);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(558);
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
				setState(559);
				match(ID);
				setState(560);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(561);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(562);
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
				setState(563);
				match(ID);
				setState(564);
				((NegElimContext)_localctx).step = match(NUM);
				setState(565);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 14:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(569);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__127:
				case T__128:
					{
					setState(566);
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
					setState(567);
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
					setState(568);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(571);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 15:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(572);
				((PbcContext)_localctx).tb = match(T__129);
				setState(573);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 16:
				_localctx = new Subst1Context(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(574);
				((Subst1Context)_localctx).tb = match(T__130);
				setState(575);
				((Subst1Context)_localctx).eqStep = match(NUM);
				setState(576);
				((Subst1Context)_localctx).step = match(NUM);
				}
				break;
			case 17:
				_localctx = new Subst2Context(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(577);
				((Subst2Context)_localctx).tb = match(T__131);
				setState(578);
				((Subst2Context)_localctx).eqStep = match(NUM);
				setState(579);
				((Subst2Context)_localctx).step = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(580);
				((AlgebraContext)_localctx).tb = match(T__132);
				setState(584);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(581);
					((AlgebraContext)_localctx).NUM = match(NUM);
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).NUM);
					}
					}
					setState(586);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(587);
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
				setState(588);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 20:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(589);
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
				setState(590);
				((ForallElimContext)_localctx).step = match(NUM);
				setState(592); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(591);
					formula(0);
					}
					}
					setState(594); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0) );
				}
				break;
			case 21:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(596);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(597);
				((ForallIntroContext)_localctx).tb = match(T__105);
				setState(598);
				match(ID);
				setState(599);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 22:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(600);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(601);
				((ForallElimContext)_localctx).tb = match(T__105);
				setState(602);
				match(ID);
				setState(603);
				((ForallElimContext)_localctx).step = match(NUM);
				setState(605); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(604);
					formula(0);
					}
					}
					setState(607); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0) );
				}
				break;
			case 23:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(609);
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
				setState(610);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(612); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(611);
					formula(0);
					}
					}
					setState(614); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0) );
				}
				break;
			case 24:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(616);
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
				setState(617);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(618);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 25:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(619);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(620);
				((ExistsIntroContext)_localctx).tb = match(T__109);
				setState(621);
				match(ID);
				setState(622);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(624); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(623);
					formula(0);
					}
					}
					setState(626); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0) );
				}
				break;
			case 26:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(628);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(629);
				((ExistsElimContext)_localctx).tb = match(T__109);
				setState(630);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(631);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(632);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 27:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(633);
				((InvariantContext)_localctx).tb = match(T__145);
				}
				break;
			case 28:
				_localctx = new FctContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(634);
				((FctContext)_localctx).tb = match(T__146);
				setState(635);
				match(ID);
				}
				break;
			case 29:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(636);
				((AutoContext)_localctx).tb = match(T__147);
				setState(640);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(637);
					((AutoContext)_localctx).NUM = match(NUM);
					((AutoContext)_localctx).steps.add(((AutoContext)_localctx).NUM);
					}
					}
					setState(642);
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
			setState(659);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__148) {
				{
				setState(651);
				impor();
				setState(653); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(652);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(655); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(657);
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
			setState(661);
			((ImporContext)_localctx).tb = match(T__148);
			setState(662);
			((ImporContext)_localctx).org = match(ID);
			setState(663);
			match(T__15);
			setState(664);
			((ImporContext)_localctx).sireum = match(ID);
			setState(665);
			match(T__15);
			setState(666);
			((ImporContext)_localctx).logika = match(ID);
			setState(667);
			match(T__15);
			setState(668);
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
			setState(670);
			match(T__13);
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
			((FactsContext)_localctx).ftb = match(T__146);
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
			factOrFun();
			setState(695);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(686); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(685);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(688); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(691);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__150 || _la==ID) {
					{
					setState(690);
					factOrFun();
					}
				}

				}
				}
				setState(697);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(698);
			((FactsContext)_localctx).te = match(T__14);
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
			setState(707);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(705);
				fact();
				}
				break;
			case T__150:
				enterOuterAlt(_localctx, 2);
				{
				setState(706);
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
			setState(709);
			match(ID);
			setState(710);
			match(T__15);
			setState(711);
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
		public FunDefContext funDef() {
			return getRuleContext(FunDefContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(713);
			((FunContext)_localctx).tb = match(T__150);
			setState(714);
			match(ID);
			setState(716);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(715);
				match(NL);
				}
			}

			setState(718);
			match(T__20);
			setState(719);
			param();
			setState(724);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(720);
				match(T__10);
				setState(721);
				param();
				}
				}
				setState(726);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(727);
			match(T__21);
			setState(728);
			match(T__7);
			setState(729);
			type();
			setState(731);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				{
				setState(730);
				funDef();
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

	public static class FunDefContext extends ParserRuleContext {
		public FunDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDef; }
	 
		public FunDefContext() { }
		public void copyFrom(FunDefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunDefCondsContext extends FunDefContext {
		public List<FunDefCondContext> funDefCond() {
			return getRuleContexts(FunDefCondContext.class);
		}
		public FunDefCondContext funDefCond(int i) {
			return getRuleContext(FunDefCondContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public FunDefCondsContext(FunDefContext ctx) { copyFrom(ctx); }
	}
	public static class FunDefEqContext extends FunDefContext {
		public FunDefSimpleContext funDefSimple() {
			return getRuleContext(FunDefSimpleContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public FunDefEqContext(FunDefContext ctx) { copyFrom(ctx); }
	}

	public final FunDefContext funDef() throws RecognitionException {
		FunDefContext _localctx = new FunDefContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_funDef);
		int _la;
		try {
			int _alt;
			setState(758);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				_localctx = new FunDefCondsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(736);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(733);
					match(NL);
					}
					}
					setState(738);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(739);
				funDefCond();
				setState(748);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(741); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(740);
							match(NL);
							}
							}
							setState(743); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NL );
						setState(745);
						funDefCond();
						}
						} 
					}
					setState(750);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				}
				}
				break;
			case 2:
				_localctx = new FunDefEqContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(754);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(751);
					match(NL);
					}
					}
					setState(756);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(757);
				funDefSimple();
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

	public static class FunDefCondContext extends ParserRuleContext {
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
		public FunDefCondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDefCond; }
	}

	public final FunDefCondContext funDefCond() throws RecognitionException {
		FunDefCondContext _localctx = new FunDefCondContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_funDefCond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(760);
			match(T__81);
			setState(761);
			((FunDefCondContext)_localctx).e = formula(0);
			setState(762);
			match(T__10);
			setState(766);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(763);
				match(NL);
				}
				}
				setState(768);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(769);
			match(T__151);
			setState(770);
			((FunDefCondContext)_localctx).c = formula(0);
			setState(771);
			match(T__20);
			setState(772);
			match(ID);
			setState(773);
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

	public static class FunDefSimpleContext extends ParserRuleContext {
		public FormulaContext e;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public FunDefSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDefSimple; }
	}

	public final FunDefSimpleContext funDefSimple() throws RecognitionException {
		FunDefSimpleContext _localctx = new FunDefSimpleContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_funDefSimple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(775);
			match(T__81);
			setState(776);
			((FunDefSimpleContext)_localctx).e = formula(0);
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
		enterRule(_localctx, 46, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
			match(ID);
			setState(779);
			match(T__7);
			setState(780);
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
		enterRule(_localctx, 48, RULE_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(783);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 149)) & ~0x3f) == 0 && ((1L << (_la - 149)) & ((1L << (T__148 - 149)) | (1L << (T__150 - 149)) | (1L << (T__151 - 149)) | (1L << (T__152 - 149)) | (1L << (T__153 - 149)) | (1L << (T__154 - 149)) | (1L << (T__156 - 149)) | (1L << (T__157 - 149)) | (1L << (T__159 - 149)) | (1L << (T__160 - 149)) | (1L << (T__161 - 149)) | (1L << (T__164 - 149)) | (1L << (T__165 - 149)) | (1L << (NUM - 149)) | (1L << (ID - 149)) | (1L << (REAL - 149)) | (1L << (INT - 149)) | (1L << (FLOAT - 149)))) != 0)) {
				{
				setState(782);
				stmt();
				}
			}

			setState(795);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(786); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(785);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(788); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(791);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 149)) & ~0x3f) == 0 && ((1L << (_la - 149)) & ((1L << (T__148 - 149)) | (1L << (T__150 - 149)) | (1L << (T__151 - 149)) | (1L << (T__152 - 149)) | (1L << (T__153 - 149)) | (1L << (T__154 - 149)) | (1L << (T__156 - 149)) | (1L << (T__157 - 149)) | (1L << (T__159 - 149)) | (1L << (T__160 - 149)) | (1L << (T__161 - 149)) | (1L << (T__164 - 149)) | (1L << (T__165 - 149)) | (1L << (NUM - 149)) | (1L << (ID - 149)) | (1L << (REAL - 149)) | (1L << (INT - 149)) | (1L << (FLOAT - 149)))) != 0)) {
					{
					setState(790);
					stmt();
					}
				}

				}
				}
				setState(797);
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
		enterRule(_localctx, 50, RULE_stmt);
		int _la;
		try {
			setState(959);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(798);
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
				setState(799);
				match(ID);
				setState(800);
				match(T__7);
				setState(801);
				type();
				setState(802);
				match(T__81);
				setState(804);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(803);
					match(NL);
					}
				}

				setState(806);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(808);
				match(ID);
				setState(809);
				match(T__81);
				setState(811);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(810);
					match(NL);
					}
				}

				setState(813);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssumeStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(814);
				match(T__16);
				setState(815);
				match(T__20);
				setState(816);
				exp(0);
				setState(817);
				match(T__21);
				}
				break;
			case 4:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(819);
				match(T__154);
				setState(820);
				match(T__20);
				setState(821);
				exp(0);
				setState(822);
				match(T__21);
				}
				break;
			case 5:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(824);
				match(T__151);
				setState(825);
				match(T__20);
				setState(826);
				exp(0);
				setState(827);
				match(T__21);
				setState(831);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(828);
					match(NL);
					}
					}
					setState(833);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(834);
				((IfStmtContext)_localctx).tt = match(T__13);
				setState(835);
				((IfStmtContext)_localctx).ts = blockEnd();
				setState(845);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__155) {
					{
					setState(836);
					match(T__155);
					setState(840);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(837);
						match(NL);
						}
						}
						setState(842);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(843);
					((IfStmtContext)_localctx).tf = match(T__13);
					setState(844);
					((IfStmtContext)_localctx).fs = blockEnd();
					}
				}

				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(847);
				match(T__156);
				setState(848);
				match(T__20);
				setState(849);
				exp(0);
				setState(850);
				match(T__21);
				setState(854);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(851);
					match(NL);
					}
					}
					setState(856);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(857);
				((WhileStmtContext)_localctx).t = match(T__13);
				setState(868);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
				case 1:
					{
					setState(861);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(858);
						match(NL);
						}
						}
						setState(863);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(864);
					match(T__157);
					setState(865);
					loopInvariant();
					setState(866);
					match(T__158);
					}
					break;
				}
				setState(870);
				blockEnd();
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(872);
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
				setState(873);
				match(T__20);
				setState(882);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (STRING - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(874);
					stringOrExp();
					setState(879);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(875);
						match(T__10);
						setState(876);
						stringOrExp();
						}
						}
						setState(881);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(884);
				match(T__21);
				}
				break;
			case 8:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(885);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(886);
				match(T__20);
				setState(887);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(888);
				match(T__21);
				setState(889);
				match(T__81);
				setState(891);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(890);
					match(NL);
					}
				}

				setState(893);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 9:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(897);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__161) {
					{
					setState(895);
					match(T__161);
					setState(896);
					((MethodDeclStmtContext)_localctx).helper = match(ID);
					}
				}

				setState(899);
				match(T__150);
				setState(900);
				((MethodDeclStmtContext)_localctx).id = match(ID);
				setState(902);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(901);
					match(NL);
					}
				}

				setState(904);
				match(T__20);
				setState(913);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(905);
					param();
					setState(910);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(906);
						match(T__10);
						setState(907);
						param();
						}
						}
						setState(912);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(915);
				match(T__21);
				setState(916);
				match(T__7);
				setState(919);
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
					setState(917);
					type();
					}
					break;
				case T__162:
					{
					setState(918);
					match(T__162);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(921);
				match(T__81);
				setState(925);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(922);
					match(NL);
					}
					}
					setState(927);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(928);
				((MethodDeclStmtContext)_localctx).t = match(T__13);
				setState(945);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
				case 1:
					{
					setState(932);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(929);
						match(NL);
						}
						}
						setState(934);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(935);
					match(T__157);
					setState(936);
					methodContract();
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
					match(T__158);
					}
					break;
				}
				setState(947);
				blockEnd();
				}
				break;
			case 10:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(948);
				match(T__157);
				setState(953);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
				case 1:
					{
					setState(949);
					proof();
					}
					break;
				case 2:
					{
					setState(950);
					sequent();
					}
					break;
				case 3:
					{
					setState(951);
					invariants();
					}
					break;
				case 4:
					{
					setState(952);
					facts();
					}
					break;
				}
				setState(955);
				match(T__158);
				}
				break;
			case 11:
				_localctx = new ImportStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(957);
				impor();
				}
				break;
			case 12:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(958);
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
		enterRule(_localctx, 52, RULE_blockEnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(961);
			stmts();
			setState(969);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__163) {
				{
				setState(962);
				returnStmt();
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
				}
			}

			setState(971);
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
		enterRule(_localctx, 54, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(973);
			match(T__163);
			setState(975);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
				{
				setState(974);
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
		enterRule(_localctx, 56, RULE_stringOrExp);
		try {
			setState(979);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(977);
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
				setState(978);
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
		enterRule(_localctx, 58, RULE_primExp);
		int _la;
		try {
			setState(1018);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
			case 1:
				_localctx = new BooleanExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(981);
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
				setState(982);
				match(NUM);
				}
				break;
			case 3:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(983);
				match(ID);
				}
				break;
			case 4:
				_localctx = new TypeMethodCallExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(984);
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
				setState(985);
				match(T__15);
				setState(986);
				match(ID);
				setState(987);
				match(T__20);
				setState(996);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(988);
					exp(0);
					setState(993);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(989);
						match(T__10);
						setState(990);
						exp(0);
						}
						}
						setState(995);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(998);
				match(T__21);
				}
				break;
			case 5:
				_localctx = new TypeAccessExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(999);
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
				setState(1000);
				match(T__15);
				setState(1001);
				match(ID);
				}
				break;
			case 6:
				_localctx = new FloatLitExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(1002);
				match(FLOAT);
				}
				break;
			case 7:
				_localctx = new IntLitExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(1003);
				match(INT);
				}
				break;
			case 8:
				_localctx = new RLitExpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(1004);
				match(REAL);
				}
				break;
			case 9:
				_localctx = new SeqExpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(1005);
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
				setState(1006);
				match(T__20);
				setState(1015);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(1007);
					exp(0);
					setState(1012);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(1008);
						match(T__10);
						setState(1009);
						exp(0);
						}
						}
						setState(1014);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1017);
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
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1057);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
			case 1:
				{
				_localctx = new InvokeExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1021);
				((InvokeExpContext)_localctx).tb = match(ID);
				setState(1022);
				((InvokeExpContext)_localctx).t = match(T__20);
				setState(1031);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)))) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & ((1L << (T__164 - 165)) | (1L << (T__165 - 165)) | (1L << (NUM - 165)) | (1L << (ID - 165)) | (1L << (REAL - 165)) | (1L << (INT - 165)) | (1L << (FLOAT - 165)))) != 0)) {
					{
					setState(1023);
					exp(0);
					setState(1028);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(1024);
						match(T__10);
						setState(1025);
						exp(0);
						}
						}
						setState(1030);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1033);
				match(T__21);
				}
				break;
			case 2:
				{
				_localctx = new PExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1034);
				primExp();
				setState(1039);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1035);
						match(T__15);
						setState(1036);
						match(ID);
						}
						} 
					}
					setState(1041);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
				}
				}
				break;
			case 3:
				{
				_localctx = new RandomIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1042);
				match(T__164);
				setState(1043);
				match(T__20);
				setState(1044);
				match(T__21);
				}
				break;
			case 4:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1045);
				match(T__165);
				setState(1046);
				match(T__20);
				setState(1048);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(1047);
					match(STRING);
					}
				}

				setState(1050);
				match(T__21);
				}
				break;
			case 5:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1051);
				match(T__20);
				setState(1052);
				exp(0);
				setState(1053);
				match(T__21);
				}
				break;
			case 6:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1055);
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
				setState(1056);
				exp(10);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,151,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1113);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1059);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1060);
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
						setState(1062);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1061);
							match(NL);
							}
						}

						setState(1064);
						((BinaryExpContext)_localctx).r = exp(10);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1065);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1066);
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
						setState(1068);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1067);
							match(NL);
							}
						}

						setState(1070);
						((BinaryExpContext)_localctx).r = exp(9);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1071);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1072);
						((BinaryExpContext)_localctx).op = match(T__70);
						setState(1074);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1073);
							match(NL);
							}
						}

						setState(1076);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1077);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1078);
						((BinaryExpContext)_localctx).op = match(T__71);
						setState(1080);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1079);
							match(NL);
							}
						}

						setState(1082);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1083);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1084);
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
						setState(1086);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1085);
							match(NL);
							}
						}

						setState(1088);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1089);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1090);
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
						setState(1092);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1091);
							match(NL);
							}
						}

						setState(1094);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1095);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1096);
						((BinaryExpContext)_localctx).op = match(T__91);
						setState(1098);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1097);
							match(NL);
							}
						}

						setState(1100);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1101);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1102);
						((BinaryExpContext)_localctx).op = match(T__95);
						setState(1104);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1103);
							match(NL);
							}
						}

						setState(1106);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(1107);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1108);
						((BinaryExpContext)_localctx).op = match(T__1);
						setState(1110);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(1109);
							match(NL);
							}
						}

						setState(1112);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(1117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,151,_ctx);
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
		enterRule(_localctx, 62, RULE_loopInvariant);
		int _la;
		try {
			int _alt;
			setState(1171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,161,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1118);
				((LoopInvariantContext)_localctx).tb = match(T__13);
				setState(1122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1119);
					match(NL);
					}
					}
					setState(1124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1125);
				modifies();
				setState(1126);
				((LoopInvariantContext)_localctx).te = match(T__14);
				setState(1130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1127);
					match(NL);
					}
					}
					setState(1132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1133);
				((LoopInvariantContext)_localctx).tb = match(T__13);
				setState(1137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1134);
					match(NL);
					}
					}
					setState(1139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1140);
				((LoopInvariantContext)_localctx).itb = match(T__145);
				setState(1144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1141);
					match(NL);
					}
					}
					setState(1146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1147);
				formula(0);
				setState(1158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1149); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1148);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1151); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,156,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(1154);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
						{
						setState(1153);
						formula(0);
						}
					}

					}
					}
					setState(1160);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__166) {
					{
					setState(1161);
					modifies();
					}
				}

				setState(1164);
				((LoopInvariantContext)_localctx).te = match(T__14);
				setState(1168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1165);
					match(NL);
					}
					}
					setState(1170);
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
		enterRule(_localctx, 64, RULE_modifies);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1173);
			((ModifiesContext)_localctx).tb = match(T__166);
			setState(1174);
			match(ID);
			setState(1179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(1175);
				match(T__10);
				setState(1176);
				match(ID);
				}
				}
				setState(1181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1182);
					match(NL);
					}
					} 
				}
				setState(1187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
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
		enterRule(_localctx, 66, RULE_methodContract);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1188);
			((MethodContractContext)_localctx).tb = match(T__13);
			setState(1192);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1189);
					match(NL);
					}
					} 
				}
				setState(1194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
			}
			setState(1216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__167 || _la==T__168) {
				{
				setState(1195);
				_la = _input.LA(1);
				if ( !(_la==T__167 || _la==T__168) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1196);
					match(NL);
					}
					}
					setState(1201);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1202);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(1213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1204); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1203);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1206); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(1209);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
							{
							setState(1208);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(1215);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
				}
				}
			}

			setState(1221);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,170,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1218);
					match(NL);
					}
					} 
				}
				setState(1223);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,170,_ctx);
			}
			setState(1225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__166) {
				{
				setState(1224);
				modifies();
				}
			}

			setState(1248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__169 || _la==T__170) {
				{
				setState(1227);
				_la = _input.LA(1);
				if ( !(_la==T__169 || _la==T__170) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1228);
					match(NL);
					}
					}
					setState(1233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1234);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(1245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1236); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1235);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1238); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,173,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(1241);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
							{
							setState(1240);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(1247);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
				}
				}
			}

			setState(1253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1250);
				match(NL);
				}
				}
				setState(1255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1256);
			((MethodContractContext)_localctx).te = match(T__14);
			setState(1260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1257);
					match(NL);
					}
					} 
				}
				setState(1262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
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
		enterRule(_localctx, 68, RULE_invariants);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1263);
			((InvariantsContext)_localctx).tb = match(T__13);
			setState(1267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1264);
				match(NL);
				}
				}
				setState(1269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1270);
			match(T__145);
			setState(1274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1271);
				match(NL);
				}
				}
				setState(1276);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1277);
			formula(0);
			setState(1288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1279); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1278);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1281); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,181,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1284);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (NUM - 173)) | (1L << (ID - 173)) | (1L << (REAL - 173)) | (1L << (INT - 173)) | (1L << (FLOAT - 173)))) != 0)) {
					{
					setState(1283);
					formula(0);
					}
				}

				}
				}
				setState(1290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1291);
			((InvariantsContext)_localctx).te = match(T__14);
			setState(1295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1292);
				match(NL);
				}
				}
				setState(1297);
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
		case 30:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u00bb\u0515\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\7\2M\n\2\f\2\16\2P\13\2\3\2\3"+
		"\2\7\2T\n\2\f\2\16\2W\13\2\3\2\5\2Z\n\2\3\2\7\2]\n\2\f\2\16\2`\13\2\3"+
		"\2\3\2\3\2\3\2\3\2\5\2g\n\2\3\3\7\3j\n\3\f\3\16\3m\13\3\3\3\3\3\6\3q\n"+
		"\3\r\3\16\3r\3\3\3\3\6\3w\n\3\r\3\16\3x\3\3\6\3|\n\3\r\3\16\3}\3\3\3\3"+
		"\3\3\6\3\u0083\n\3\r\3\16\3\u0084\3\3\3\3\6\3\u0089\n\3\r\3\16\3\u008a"+
		"\3\3\7\3\u008e\n\3\f\3\16\3\u0091\13\3\3\3\6\3\u0094\n\3\r\3\16\3\u0095"+
		"\3\3\3\3\6\3\u009a\n\3\r\3\16\3\u009b\3\3\5\3\u009f\n\3\3\3\7\3\u00a2"+
		"\n\3\f\3\16\3\u00a5\13\3\3\4\7\4\u00a8\n\4\f\4\16\4\u00ab\13\4\3\4\3\4"+
		"\7\4\u00af\n\4\f\4\16\4\u00b2\13\4\3\5\3\5\3\6\3\6\6\6\u00b8\n\6\r\6\16"+
		"\6\u00b9\3\6\3\6\3\6\3\6\7\6\u00c0\n\6\f\6\16\6\u00c3\13\6\3\6\7\6\u00c6"+
		"\n\6\f\6\16\6\u00c9\13\6\3\6\6\6\u00cc\n\6\r\6\16\6\u00cd\3\6\3\6\3\6"+
		"\3\6\7\6\u00d4\n\6\f\6\16\6\u00d7\13\6\3\6\7\6\u00da\n\6\f\6\16\6\u00dd"+
		"\13\6\5\6\u00df\n\6\3\7\3\7\6\7\u00e3\n\7\r\7\16\7\u00e4\3\7\3\7\3\b\3"+
		"\b\3\b\7\b\u00ec\n\b\f\b\16\b\u00ef\13\b\5\b\u00f1\n\b\3\b\3\b\3\b\3\b"+
		"\7\b\u00f7\n\b\f\b\16\b\u00fa\13\b\3\b\7\b\u00fd\n\b\f\b\16\b\u0100\13"+
		"\b\3\b\3\b\6\b\u0104\n\b\r\b\16\b\u0105\5\b\u0108\n\b\3\t\3\t\5\t\u010c"+
		"\n\t\3\t\6\t\u010f\n\t\r\t\16\t\u0110\3\t\5\t\u0114\n\t\7\t\u0116\n\t"+
		"\f\t\16\t\u0119\13\t\3\t\3\t\7\t\u011d\n\t\f\t\16\t\u0120\13\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u012a\n\n\f\n\16\n\u012d\13\n\3\n\3\n\7\n"+
		"\u0131\n\n\f\n\16\n\u0134\13\n\3\n\3\n\3\n\3\n\3\n\5\n\u013b\n\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\5\n\u0143\n\n\3\n\3\n\3\n\5\n\u0148\n\n\3\n\6\n\u014b"+
		"\n\n\r\n\16\n\u014c\3\n\5\n\u0150\n\n\7\n\u0152\n\n\f\n\16\n\u0155\13"+
		"\n\3\n\5\n\u0158\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u0164\n\13\f\13\16\13\u0167\13\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\7\13\u0171\n\13\f\13\16\13\u0174\13\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0185\n\13"+
		"\f\13\16\13\u0188\13\13\5\13\u018a\n\13\3\13\5\13\u018d\n\13\3\f\3\f\3"+
		"\f\3\f\7\f\u0193\n\f\f\f\16\f\u0196\13\f\3\f\3\f\3\f\3\f\3\f\5\f\u019d"+
		"\n\f\3\f\3\f\3\f\5\f\u01a2\n\f\3\f\3\f\3\f\3\f\5\f\u01a8\n\f\3\f\3\f\3"+
		"\f\3\f\5\f\u01ae\n\f\3\f\3\f\3\f\3\f\5\f\u01b4\n\f\3\f\3\f\3\f\3\f\5\f"+
		"\u01ba\n\f\3\f\3\f\3\f\3\f\5\f\u01c0\n\f\3\f\3\f\3\f\3\f\5\f\u01c6\n\f"+
		"\3\f\3\f\3\f\3\f\5\f\u01cc\n\f\3\f\3\f\3\f\3\f\5\f\u01d2\n\f\3\f\3\f\3"+
		"\f\3\f\5\f\u01d8\n\f\3\f\7\f\u01db\n\f\f\f\16\f\u01de\13\f\3\r\3\r\3\r"+
		"\3\r\7\r\u01e4\n\r\f\r\16\r\u01e7\13\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u01ef"+
		"\n\r\3\r\3\r\5\r\u01f3\n\r\3\r\3\r\3\r\5\r\u01f8\n\r\3\r\5\r\u01fb\n\r"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u0205\n\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u020c\n\17\3\17\3\17\3\17\3\17\5\17\u0212\n\17\3\17\3"+
		"\17\3\17\3\17\5\17\u0218\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u023c"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0249"+
		"\n\17\f\17\16\17\u024c\13\17\3\17\3\17\3\17\3\17\3\17\6\17\u0253\n\17"+
		"\r\17\16\17\u0254\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u0260"+
		"\n\17\r\17\16\17\u0261\3\17\3\17\3\17\6\17\u0267\n\17\r\17\16\17\u0268"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17\u0273\n\17\r\17\16\17\u0274"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0281\n\17\f\17"+
		"\16\17\u0284\13\17\5\17\u0286\n\17\3\20\7\20\u0289\n\20\f\20\16\20\u028c"+
		"\13\20\3\20\3\20\6\20\u0290\n\20\r\20\16\20\u0291\3\20\3\20\5\20\u0296"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\7\22\u02a3"+
		"\n\22\f\22\16\22\u02a6\13\22\3\22\3\22\7\22\u02aa\n\22\f\22\16\22\u02ad"+
		"\13\22\3\22\3\22\6\22\u02b1\n\22\r\22\16\22\u02b2\3\22\5\22\u02b6\n\22"+
		"\7\22\u02b8\n\22\f\22\16\22\u02bb\13\22\3\22\3\22\7\22\u02bf\n\22\f\22"+
		"\16\22\u02c2\13\22\3\23\3\23\5\23\u02c6\n\23\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\5\25\u02cf\n\25\3\25\3\25\3\25\3\25\7\25\u02d5\n\25\f\25\16"+
		"\25\u02d8\13\25\3\25\3\25\3\25\3\25\5\25\u02de\n\25\3\26\7\26\u02e1\n"+
		"\26\f\26\16\26\u02e4\13\26\3\26\3\26\6\26\u02e8\n\26\r\26\16\26\u02e9"+
		"\3\26\7\26\u02ed\n\26\f\26\16\26\u02f0\13\26\3\26\7\26\u02f3\n\26\f\26"+
		"\16\26\u02f6\13\26\3\26\5\26\u02f9\n\26\3\27\3\27\3\27\3\27\7\27\u02ff"+
		"\n\27\f\27\16\27\u0302\13\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\32\5\32\u0312\n\32\3\32\6\32\u0315\n\32\r\32"+
		"\16\32\u0316\3\32\5\32\u031a\n\32\7\32\u031c\n\32\f\32\16\32\u031f\13"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0327\n\33\3\33\3\33\3\33\3\33"+
		"\3\33\5\33\u032e\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0340\n\33\f\33\16\33\u0343\13\33"+
		"\3\33\3\33\3\33\3\33\7\33\u0349\n\33\f\33\16\33\u034c\13\33\3\33\3\33"+
		"\5\33\u0350\n\33\3\33\3\33\3\33\3\33\3\33\7\33\u0357\n\33\f\33\16\33\u035a"+
		"\13\33\3\33\3\33\7\33\u035e\n\33\f\33\16\33\u0361\13\33\3\33\3\33\3\33"+
		"\3\33\5\33\u0367\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0370\n"+
		"\33\f\33\16\33\u0373\13\33\5\33\u0375\n\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\5\33\u037e\n\33\3\33\3\33\3\33\3\33\5\33\u0384\n\33\3\33\3\33"+
		"\3\33\5\33\u0389\n\33\3\33\3\33\3\33\3\33\7\33\u038f\n\33\f\33\16\33\u0392"+
		"\13\33\5\33\u0394\n\33\3\33\3\33\3\33\3\33\5\33\u039a\n\33\3\33\3\33\7"+
		"\33\u039e\n\33\f\33\16\33\u03a1\13\33\3\33\3\33\7\33\u03a5\n\33\f\33\16"+
		"\33\u03a8\13\33\3\33\3\33\3\33\7\33\u03ad\n\33\f\33\16\33\u03b0\13\33"+
		"\3\33\3\33\5\33\u03b4\n\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u03bc\n"+
		"\33\3\33\3\33\3\33\3\33\5\33\u03c2\n\33\3\34\3\34\3\34\7\34\u03c7\n\34"+
		"\f\34\16\34\u03ca\13\34\5\34\u03cc\n\34\3\34\3\34\3\35\3\35\5\35\u03d2"+
		"\n\35\3\36\3\36\5\36\u03d6\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\7\37\u03e2\n\37\f\37\16\37\u03e5\13\37\5\37\u03e7\n\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u03f5\n\37"+
		"\f\37\16\37\u03f8\13\37\5\37\u03fa\n\37\3\37\5\37\u03fd\n\37\3 \3 \3 "+
		"\3 \3 \3 \7 \u0405\n \f \16 \u0408\13 \5 \u040a\n \3 \3 \3 \3 \7 \u0410"+
		"\n \f \16 \u0413\13 \3 \3 \3 \3 \3 \3 \5 \u041b\n \3 \3 \3 \3 \3 \3 \3"+
		" \5 \u0424\n \3 \3 \3 \5 \u0429\n \3 \3 \3 \3 \5 \u042f\n \3 \3 \3 \3"+
		" \5 \u0435\n \3 \3 \3 \3 \5 \u043b\n \3 \3 \3 \3 \5 \u0441\n \3 \3 \3"+
		" \3 \5 \u0447\n \3 \3 \3 \3 \5 \u044d\n \3 \3 \3 \3 \5 \u0453\n \3 \3"+
		" \3 \3 \5 \u0459\n \3 \7 \u045c\n \f \16 \u045f\13 \3!\3!\7!\u0463\n!"+
		"\f!\16!\u0466\13!\3!\3!\3!\7!\u046b\n!\f!\16!\u046e\13!\3!\3!\7!\u0472"+
		"\n!\f!\16!\u0475\13!\3!\3!\7!\u0479\n!\f!\16!\u047c\13!\3!\3!\6!\u0480"+
		"\n!\r!\16!\u0481\3!\5!\u0485\n!\7!\u0487\n!\f!\16!\u048a\13!\3!\5!\u048d"+
		"\n!\3!\3!\7!\u0491\n!\f!\16!\u0494\13!\5!\u0496\n!\3\"\3\"\3\"\3\"\7\""+
		"\u049c\n\"\f\"\16\"\u049f\13\"\3\"\7\"\u04a2\n\"\f\"\16\"\u04a5\13\"\3"+
		"#\3#\7#\u04a9\n#\f#\16#\u04ac\13#\3#\3#\7#\u04b0\n#\f#\16#\u04b3\13#\3"+
		"#\3#\6#\u04b7\n#\r#\16#\u04b8\3#\5#\u04bc\n#\7#\u04be\n#\f#\16#\u04c1"+
		"\13#\5#\u04c3\n#\3#\7#\u04c6\n#\f#\16#\u04c9\13#\3#\5#\u04cc\n#\3#\3#"+
		"\7#\u04d0\n#\f#\16#\u04d3\13#\3#\3#\6#\u04d7\n#\r#\16#\u04d8\3#\5#\u04dc"+
		"\n#\7#\u04de\n#\f#\16#\u04e1\13#\5#\u04e3\n#\3#\7#\u04e6\n#\f#\16#\u04e9"+
		"\13#\3#\3#\7#\u04ed\n#\f#\16#\u04f0\13#\3$\3$\7$\u04f4\n$\f$\16$\u04f7"+
		"\13$\3$\3$\7$\u04fb\n$\f$\16$\u04fe\13$\3$\3$\6$\u0502\n$\r$\16$\u0503"+
		"\3$\5$\u0507\n$\7$\u0509\n$\f$\16$\u050c\13$\3$\3$\7$\u0510\n$\f$\16$"+
		"\u0513\13$\3$\2\4\26>%\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,"+
		".\60\62\64\668:<>@BDF\2*\3\2\5\b\3\2\5\6\3\2\7\b\3\2\16\17\4\2\5\b\24"+
		"\26\3\2\32/\3\2\60E\3\2X\\\4\2\3\3FG\4\2\t\tHH\3\2KS\3\2TW\3\2]`\3\2a"+
		"b\4\2\4\4ce\3\2fh\3\2ip\3\2\32E\3\2^`\3\2tu\3\2vy\4\2\4\4ee\3\2z{\3\2"+
		"gh\3\2~\177\3\2\u0080\u0081\3\2Z\\\3\2\u0082\u0083\4\2\b\b\26\26\3\2\u0088"+
		"\u008a\3\2\u008b\u008d\3\2\u008e\u0090\3\2\u0091\u0093\3\2\u009b\u009c"+
		"\3\2\u00a2\u00a3\4\2\t\tZ[\5\2KLNOQS\3\2UV\3\2\u00aa\u00ab\3\2\u00ac\u00ad"+
		"\u05fa\2f\3\2\2\2\4k\3\2\2\2\6\u00a9\3\2\2\2\b\u00b3\3\2\2\2\n\u00b5\3"+
		"\2\2\2\f\u00e0\3\2\2\2\16\u0107\3\2\2\2\20\u0109\3\2\2\2\22\u0157\3\2"+
		"\2\2\24\u018c\3\2\2\2\26\u019c\3\2\2\2\30\u01df\3\2\2\2\32\u01fe\3\2\2"+
		"\2\34\u0285\3\2\2\2\36\u028a\3\2\2\2 \u0297\3\2\2\2\"\u02a0\3\2\2\2$\u02c5"+
		"\3\2\2\2&\u02c7\3\2\2\2(\u02cb\3\2\2\2*\u02f8\3\2\2\2,\u02fa\3\2\2\2."+
		"\u0309\3\2\2\2\60\u030c\3\2\2\2\62\u0311\3\2\2\2\64\u03c1\3\2\2\2\66\u03c3"+
		"\3\2\2\28\u03cf\3\2\2\2:\u03d5\3\2\2\2<\u03fc\3\2\2\2>\u0423\3\2\2\2@"+
		"\u0495\3\2\2\2B\u0497\3\2\2\2D\u04a6\3\2\2\2F\u04f1\3\2\2\2HI\5\4\3\2"+
		"IJ\7\2\2\3Jg\3\2\2\2KM\7\u00b4\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2"+
		"\2\2OQ\3\2\2\2PN\3\2\2\2QU\5\16\b\2RT\7\u00b4\2\2SR\3\2\2\2TW\3\2\2\2"+
		"US\3\2\2\2UV\3\2\2\2VY\3\2\2\2WU\3\2\2\2XZ\5\20\t\2YX\3\2\2\2YZ\3\2\2"+
		"\2Z^\3\2\2\2[]\7\u00b4\2\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_"+
		"a\3\2\2\2`^\3\2\2\2ab\7\2\2\3bg\3\2\2\2cd\5\36\20\2de\7\2\2\3eg\3\2\2"+
		"\2fH\3\2\2\2fN\3\2\2\2fc\3\2\2\2g\3\3\2\2\2hj\7\u00b4\2\2ih\3\2\2\2jm"+
		"\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2np\7\3\2\2oq\7\u00b4\2"+
		"\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2st\3\2\2\2tv\7\u00ae\2\2uw\7"+
		"\u00b4\2\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2z|\7\u00b0"+
		"\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\7"+
		"\4\2\2\u0080\u0082\5\26\f\2\u0081\u0083\7\u00b4\2\2\u0082\u0081\3\2\2"+
		"\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086"+
		"\3\2\2\2\u0086\u008f\7\u00ae\2\2\u0087\u0089\7\u00b4\2\2\u0088\u0087\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008e\5\6\4\2\u008d\u0088\3\2\2\2\u008e\u0091\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0093\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0094\7\u00b4\2\2\u0093\u0092\3\2\2\2\u0094\u0095"+
		"\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u009e\7\u00ae\2\2\u0098\u009a\7\u00b4\2\2\u0099\u0098\3\2\2\2\u009a\u009b"+
		"\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009f\5\n\6\2\u009e\u0099\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a3\3\2"+
		"\2\2\u00a0\u00a2\7\u00b4\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\5\3\2\2\2\u00a5\u00a3\3\2\2\2"+
		"\u00a6\u00a8\5\b\5\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7"+
		"\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac"+
		"\u00b0\7\4\2\2\u00ad\u00af\5\b\5\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2"+
		"\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\7\3\2\2\2\u00b2\u00b0"+
		"\3\2\2\2\u00b3\u00b4\t\2\2\2\u00b4\t\3\2\2\2\u00b5\u00de\7\u00b0\2\2\u00b6"+
		"\u00b8\7\u00b4\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7"+
		"\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7\t\2\2\u00bc"+
		"\u00bd\t\3\2\2\u00bd\u00c7\7\n\2\2\u00be\u00c0\7\u00b4\2\2\u00bf\u00be"+
		"\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c6\5\f\7\2\u00c5\u00c1\3\2"+
		"\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cc\7\u00b4\2\2\u00cb\u00ca"+
		"\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d0\7\t\2\2\u00d0\u00d1\t\4\2\2\u00d1\u00db\7\n"+
		"\2\2\u00d2\u00d4\7\u00b4\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d5\3\2"+
		"\2\2\u00d8\u00da\5\f\7\2\u00d9\u00d5\3\2\2\2\u00da\u00dd\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2"+
		"\2\2\u00de\u00b7\3\2\2\2\u00de\u00df\3\2\2\2\u00df\13\3\2\2\2\u00e0\u00e2"+
		"\7\13\2\2\u00e1\u00e3\5\b\5\2\u00e2\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2"+
		"\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7"+
		"\7\f\2\2\u00e7\r\3\2\2\2\u00e8\u00ed\5\26\f\2\u00e9\u00ea\7\r\2\2\u00ea"+
		"\u00ec\5\26\f\2\u00eb\u00e9\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3"+
		"\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0"+
		"\u00e8\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\t\5"+
		"\2\2\u00f3\u00f8\5\26\f\2\u00f4\u00f5\7\r\2\2\u00f5\u00f7\5\26\f\2\u00f6"+
		"\u00f4\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2"+
		"\2\2\u00f9\u0108\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fd\5\26\f\2\u00fc"+
		"\u00fb\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2"+
		"\2\2\u00ff\u0101\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0103\7\u00ae\2\2\u0102"+
		"\u0104\5\26\f\2\u0103\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103\3"+
		"\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2\2\2\u0107\u00f0\3\2\2\2\u0107"+
		"\u00fe\3\2\2\2\u0108\17\3\2\2\2\u0109\u010b\7\20\2\2\u010a\u010c\5\22"+
		"\n\2\u010b\u010a\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u0117\3\2\2\2\u010d"+
		"\u010f\7\u00b4\2\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u010e"+
		"\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0113\3\2\2\2\u0112\u0114\5\22\n\2"+
		"\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0116\3\2\2\2\u0115\u010e"+
		"\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011e\7\21\2\2\u011b\u011d\7"+
		"\u00b4\2\2\u011c\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2"+
		"\u011e\u011f\3\2\2\2\u011f\21\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122"+
		"\7\u00af\2\2\u0122\u0123\7\22\2\2\u0123\u0124\5\26\f\2\u0124\u0125\5\34"+
		"\17\2\u0125\u0158\3\2\2\2\u0126\u0127\7\u00af\2\2\u0127\u012b\7\22\2\2"+
		"\u0128\u012a\7\u00b4\2\2\u0129\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012e\3\2\2\2\u012d\u012b\3\2"+
		"\2\2\u012e\u0132\7\20\2\2\u012f\u0131\7\u00b4\2\2\u0130\u012f\3\2\2\2"+
		"\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135"+
		"\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\7\u00af\2\2\u0136\u0147\7\22"+
		"\2\2\u0137\u013a\7\u00b0\2\2\u0138\u0139\7\n\2\2\u0139\u013b\5\32\16\2"+
		"\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0148\3\2\2\2\u013c\u013d"+
		"\5\26\f\2\u013d\u013e\7\23\2\2\u013e\u0148\3\2\2\2\u013f\u0142\7\u00b0"+
		"\2\2\u0140\u0141\7\n\2\2\u0141\u0143\5\32\16\2\u0142\u0140\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\5\26\f\2\u0145\u0146\7"+
		"\23\2\2\u0146\u0148\3\2\2\2\u0147\u0137\3\2\2\2\u0147\u013c\3\2\2\2\u0147"+
		"\u013f\3\2\2\2\u0148\u0153\3\2\2\2\u0149\u014b\7\u00b4\2\2\u014a\u0149"+
		"\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d"+
		"\u014f\3\2\2\2\u014e\u0150\5\22\n\2\u014f\u014e\3\2\2\2\u014f\u0150\3"+
		"\2\2\2\u0150\u0152\3\2\2\2\u0151\u014a\3\2\2\2\u0152\u0155\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0156\3\2\2\2\u0155\u0153\3\2"+
		"\2\2\u0156\u0158\7\21\2\2\u0157\u0121\3\2\2\2\u0157\u0126\3\2\2\2\u0158"+
		"\23\3\2\2\2\u0159\u018d\t\6\2\2\u015a\u015b\7\27\2\2\u015b\u015c\5\26"+
		"\f\2\u015c\u015d\7\30\2\2\u015d\u018d\3\2\2\2\u015e\u015f\7\31\2\2\u015f"+
		"\u0160\7\27\2\2\u0160\u0165\5\26\f\2\u0161\u0162\7\r\2\2\u0162\u0164\5"+
		"\26\f\2\u0163\u0161\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3\2\2\2\u0165"+
		"\u0166\3\2\2\2\u0166\u0168\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u0169\7\30"+
		"\2\2\u0169\u018d\3\2\2\2\u016a\u018d\7\31\2\2\u016b\u016c\7\u00b0\2\2"+
		"\u016c\u016d\7\27\2\2\u016d\u0172\5\26\f\2\u016e\u016f\7\r\2\2\u016f\u0171"+
		"\5\26\f\2\u0170\u016e\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2"+
		"\u0172\u0173\3\2\2\2\u0173\u0175\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0176"+
		"\7\30\2\2\u0176\u018d\3\2\2\2\u0177\u018d\7\u00b0\2\2\u0178\u018d\7\u00af"+
		"\2\2\u0179\u018d\7\u00b2\2\2\u017a\u018d\7\u00b1\2\2\u017b\u018d\7\u00ba"+
		"\2\2\u017c\u017d\t\7\2\2\u017d\u017e\7\22\2\2\u017e\u018d\7\u00b0\2\2"+
		"\u017f\u0180\t\b\2\2\u0180\u0189\7\27\2\2\u0181\u0186\5> \2\u0182\u0183"+
		"\7\r\2\2\u0183\u0185\5> \2\u0184\u0182\3\2\2\2\u0185\u0188\3\2\2\2\u0186"+
		"\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2"+
		"\2\2\u0189\u0181\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\3\2\2\2\u018b"+
		"\u018d\7\30\2\2\u018c\u0159\3\2\2\2\u018c\u015a\3\2\2\2\u018c\u015e\3"+
		"\2\2\2\u018c\u016a\3\2\2\2\u018c\u016b\3\2\2\2\u018c\u0177\3\2\2\2\u018c"+
		"\u0178\3\2\2\2\u018c\u0179\3\2\2\2\u018c\u017a\3\2\2\2\u018c\u017b\3\2"+
		"\2\2\u018c\u017c\3\2\2\2\u018c\u017f\3\2\2\2\u018d\25\3\2\2\2\u018e\u018f"+
		"\b\f\1\2\u018f\u0194\5\24\13\2\u0190\u0191\7\22\2\2\u0191\u0193\7\u00b0"+
		"\2\2\u0192\u0190\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0194"+
		"\u0195\3\2\2\2\u0195\u019d\3\2\2\2\u0196\u0194\3\2\2\2\u0197\u0198\7\t"+
		"\2\2\u0198\u019d\5\26\f\t\u0199\u019a\t\t\2\2\u019a\u019d\5\26\f\b\u019b"+
		"\u019d\5\30\r\2\u019c\u018e\3\2\2\2\u019c\u0197\3\2\2\2\u019c\u0199\3"+
		"\2\2\2\u019c\u019b\3\2\2\2\u019d\u01dc\3\2\2\2\u019e\u019f\f\17\2\2\u019f"+
		"\u01a1\t\n\2\2\u01a0\u01a2\7\u00b4\2\2\u01a1\u01a0\3\2\2\2\u01a1\u01a2"+
		"\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01db\5\26\f\20\u01a4\u01a5\f\16\2"+
		"\2\u01a5\u01a7\t\13\2\2\u01a6\u01a8\7\u00b4\2\2\u01a7\u01a6\3\2\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01db\5\26\f\17\u01aa\u01ab\f"+
		"\r\2\2\u01ab\u01ad\7I\2\2\u01ac\u01ae\7\u00b4\2\2\u01ad\u01ac\3\2\2\2"+
		"\u01ad\u01ae\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01db\5\26\f\r\u01b0\u01b1"+
		"\f\f\2\2\u01b1\u01b3\7J\2\2\u01b2\u01b4\7\u00b4\2\2\u01b3\u01b2\3\2\2"+
		"\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01db\5\26\f\r\u01b6"+
		"\u01b7\f\13\2\2\u01b7\u01b9\t\f\2\2\u01b8\u01ba\7\u00b4\2\2\u01b9\u01b8"+
		"\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01db\5\26\f\f"+
		"\u01bc\u01bd\f\n\2\2\u01bd\u01bf\t\r\2\2\u01be\u01c0\7\u00b4\2\2\u01bf"+
		"\u01be\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01db\5\26"+
		"\f\13\u01c2\u01c3\f\7\2\2\u01c3\u01c5\t\16\2\2\u01c4\u01c6\7\u00b4\2\2"+
		"\u01c5\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01db"+
		"\5\26\f\b\u01c8\u01c9\f\6\2\2\u01c9\u01cb\t\17\2\2\u01ca\u01cc\7\u00b4"+
		"\2\2\u01cb\u01ca\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd"+
		"\u01db\5\26\f\7\u01ce\u01cf\f\5\2\2\u01cf\u01d1\t\20\2\2\u01d0\u01d2\7"+
		"\u00b4\2\2\u01d1\u01d0\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\3\2\2\2"+
		"\u01d3\u01db\5\26\f\6\u01d4\u01d5\f\4\2\2\u01d5\u01d7\t\21\2\2\u01d6\u01d8"+
		"\7\u00b4\2\2\u01d7\u01d6\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\3\2\2"+
		"\2\u01d9\u01db\5\26\f\4\u01da\u019e\3\2\2\2\u01da\u01a4\3\2\2\2\u01da"+
		"\u01aa\3\2\2\2\u01da\u01b0\3\2\2\2\u01da\u01b6\3\2\2\2\u01da\u01bc\3\2"+
		"\2\2\u01da\u01c2\3\2\2\2\u01da\u01c8\3\2\2\2\u01da\u01ce\3\2\2\2\u01da"+
		"\u01d4\3\2\2\2\u01db\u01de\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd\3\2"+
		"\2\2\u01dd\27\3\2\2\2\u01de\u01dc\3\2\2\2\u01df\u01e0\t\22\2\2\u01e0\u01e5"+
		"\7\u00b0\2\2\u01e1\u01e2\7\r\2\2\u01e2\u01e4\7\u00b0\2\2\u01e3\u01e1\3"+
		"\2\2\2\u01e4\u01e7\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6"+
		"\u01f7\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e8\u01e9\7\n\2\2\u01e9\u01f8\5\32"+
		"\16\2\u01ea\u01eb\7\n\2\2\u01eb\u01ec\7\27\2\2\u01ec\u01ee\5\26\f\2\u01ed"+
		"\u01ef\7K\2\2\u01ee\u01ed\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0\3\2"+
		"\2\2\u01f0\u01f2\7q\2\2\u01f1\u01f3\7K\2\2\u01f2\u01f1\3\2\2\2\u01f2\u01f3"+
		"\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f5\5\26\f\2\u01f5\u01f6\7\30\2\2"+
		"\u01f6\u01f8\3\2\2\2\u01f7\u01e8\3\2\2\2\u01f7\u01ea\3\2\2\2\u01f7\u01f8"+
		"\3\2\2\2\u01f8\u01fa\3\2\2\2\u01f9\u01fb\7\u00b4\2\2\u01fa\u01f9\3\2\2"+
		"\2\u01fa\u01fb\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\5\26\f\2\u01fd"+
		"\31\3\2\2\2\u01fe\u01ff\t\23\2\2\u01ff\33\3\2\2\2\u0200\u0286\7r\2\2\u0201"+
		"\u0205\7s\2\2\u0202\u0203\t\24\2\2\u0203\u0205\7\u00b0\2\2\u0204\u0201"+
		"\3\2\2\2\u0204\u0202\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0207\7\u00af\2"+
		"\2\u0207\u0286\7\u00af\2\2\u0208\u020c\t\25\2\2\u0209\u020a\t\24\2\2\u020a"+
		"\u020c\7\u00b0\2\2\u020b\u0208\3\2\2\2\u020b\u0209\3\2\2\2\u020c\u020d"+
		"\3\2\2\2\u020d\u0286\7\u00af\2\2\u020e\u0212\t\26\2\2\u020f\u0210\t\27"+
		"\2\2\u0210\u0212\7\u00b0\2\2\u0211\u020e\3\2\2\2\u0211\u020f\3\2\2\2\u0212"+
		"\u0213\3\2\2\2\u0213\u0286\7\u00af\2\2\u0214\u0218\t\30\2\2\u0215\u0216"+
		"\t\27\2\2\u0216\u0218\7\u00b0\2\2\u0217\u0214\3\2\2\2\u0217\u0215\3\2"+
		"\2\2\u0218\u0219\3\2\2\2\u0219\u021a\7\u00af\2\2\u021a\u021b\7\u00af\2"+
		"\2\u021b\u0286\7\u00af\2\2\u021c\u021d\7|\2\2\u021d\u0286\7\u00af\2\2"+
		"\u021e\u021f\7}\2\2\u021f\u0220\7\u00af\2\2\u0220\u0286\7\u00af\2\2\u0221"+
		"\u0222\6\17\f\2\u0222\u0223\t\31\2\2\u0223\u0224\7\u00b0\2\2\u0224\u0286"+
		"\7\u00af\2\2\u0225\u0226\6\17\r\2\u0226\u0227\t\31\2\2\u0227\u0228\7\u00b0"+
		"\2\2\u0228\u0229\7\u00af\2\2\u0229\u0286\7\u00af\2\2\u022a\u022b\t\32"+
		"\2\2\u022b\u0286\7\u00af\2\2\u022c\u022d\t\33\2\2\u022d\u022e\7\u00af"+
		"\2\2\u022e\u0286\7\u00af\2\2\u022f\u0230\6\17\16\2\u0230\u0231\t\34\2"+
		"\2\u0231\u0232\7\u00b0\2\2\u0232\u0286\7\u00af\2\2\u0233\u0234\6\17\17"+
		"\2\u0234\u0235\t\34\2\2\u0235\u0236\7\u00b0\2\2\u0236\u0237\7\u00af\2"+
		"\2\u0237\u0286\7\u00af\2\2\u0238\u023c\t\35\2\2\u0239\u023a\t\36\2\2\u023a"+
		"\u023c\7\u00b0\2\2\u023b\u0238\3\2\2\2\u023b\u0239\3\2\2\2\u023c\u023d"+
		"\3\2\2\2\u023d\u0286\7\u00af\2\2\u023e\u023f\7\u0084\2\2\u023f\u0286\7"+
		"\u00af\2\2\u0240\u0241\7\u0085\2\2\u0241\u0242\7\u00af\2\2\u0242\u0286"+
		"\7\u00af\2\2\u0243\u0244\7\u0086\2\2\u0244\u0245\7\u00af\2\2\u0245\u0286"+
		"\7\u00af\2\2\u0246\u024a\7\u0087\2\2\u0247\u0249\7\u00af\2\2\u0248\u0247"+
		"\3\2\2\2\u0249\u024c\3\2\2\2\u024a\u0248\3\2\2\2\u024a\u024b\3\2\2\2\u024b"+
		"\u0286\3\2\2\2\u024c\u024a\3\2\2\2\u024d\u024e\t\37\2\2\u024e\u0286\7"+
		"\u00af\2\2\u024f\u0250\t \2\2\u0250\u0252\7\u00af\2\2\u0251\u0253\5\26"+
		"\f\2\u0252\u0251\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0252\3\2\2\2\u0254"+
		"\u0255\3\2\2\2\u0255\u0286\3\2\2\2\u0256\u0257\6\17\20\2\u0257\u0258\7"+
		"l\2\2\u0258\u0259\7\u00b0\2\2\u0259\u0286\7\u00af\2\2\u025a\u025b\6\17"+
		"\21\2\u025b\u025c\7l\2\2\u025c\u025d\7\u00b0\2\2\u025d\u025f\7\u00af\2"+
		"\2\u025e\u0260\5\26\f\2\u025f\u025e\3\2\2\2\u0260\u0261\3\2\2\2\u0261"+
		"\u025f\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u0286\3\2\2\2\u0263\u0264\t!"+
		"\2\2\u0264\u0266\7\u00af\2\2\u0265\u0267\5\26\f\2\u0266\u0265\3\2\2\2"+
		"\u0267\u0268\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u0286"+
		"\3\2\2\2\u026a\u026b\t\"\2\2\u026b\u026c\7\u00af\2\2\u026c\u0286\7\u00af"+
		"\2\2\u026d\u026e\6\17\22\2\u026e\u026f\7p\2\2\u026f\u0270\7\u00b0\2\2"+
		"\u0270\u0272\7\u00af\2\2\u0271\u0273\5\26\f\2\u0272\u0271\3\2\2\2\u0273"+
		"\u0274\3\2\2\2\u0274\u0272\3\2\2\2\u0274\u0275\3\2\2\2\u0275\u0286\3\2"+
		"\2\2\u0276\u0277\6\17\23\2\u0277\u0278\7p\2\2\u0278\u0279\7\u00b0\2\2"+
		"\u0279\u027a\7\u00af\2\2\u027a\u0286\7\u00af\2\2\u027b\u0286\7\u0094\2"+
		"\2\u027c\u027d\7\u0095\2\2\u027d\u0286\7\u00b0\2\2\u027e\u0282\7\u0096"+
		"\2\2\u027f\u0281\7\u00af\2\2\u0280\u027f\3\2\2\2\u0281\u0284\3\2\2\2\u0282"+
		"\u0280\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0286\3\2\2\2\u0284\u0282\3\2"+
		"\2\2\u0285\u0200\3\2\2\2\u0285\u0204\3\2\2\2\u0285\u020b\3\2\2\2\u0285"+
		"\u0211\3\2\2\2\u0285\u0217\3\2\2\2\u0285\u021c\3\2\2\2\u0285\u021e\3\2"+
		"\2\2\u0285\u0221\3\2\2\2\u0285\u0225\3\2\2\2\u0285\u022a\3\2\2\2\u0285"+
		"\u022c\3\2\2\2\u0285\u022f\3\2\2\2\u0285\u0233\3\2\2\2\u0285\u023b\3\2"+
		"\2\2\u0285\u023e\3\2\2\2\u0285\u0240\3\2\2\2\u0285\u0243\3\2\2\2\u0285"+
		"\u0246\3\2\2\2\u0285\u024d\3\2\2\2\u0285\u024f\3\2\2\2\u0285\u0256\3\2"+
		"\2\2\u0285\u025a\3\2\2\2\u0285\u0263\3\2\2\2\u0285\u026a\3\2\2\2\u0285"+
		"\u026d\3\2\2\2\u0285\u0276\3\2\2\2\u0285\u027b\3\2\2\2\u0285\u027c\3\2"+
		"\2\2\u0285\u027e\3\2\2\2\u0286\35\3\2\2\2\u0287\u0289\7\u00b4\2\2\u0288"+
		"\u0287\3\2\2\2\u0289\u028c\3\2\2\2\u028a\u0288\3\2\2\2\u028a\u028b\3\2"+
		"\2\2\u028b\u0295\3\2\2\2\u028c\u028a\3\2\2\2\u028d\u028f\5 \21\2\u028e"+
		"\u0290\7\u00b4\2\2\u028f\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u028f"+
		"\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0294\5\62\32\2"+
		"\u0294\u0296\3\2\2\2\u0295\u028d\3\2\2\2\u0295\u0296\3\2\2\2\u0296\37"+
		"\3\2\2\2\u0297\u0298\7\u0097\2\2\u0298\u0299\7\u00b0\2\2\u0299\u029a\7"+
		"\22\2\2\u029a\u029b\7\u00b0\2\2\u029b\u029c\7\22\2\2\u029c\u029d\7\u00b0"+
		"\2\2\u029d\u029e\7\22\2\2\u029e\u029f\7\u0098\2\2\u029f!\3\2\2\2\u02a0"+
		"\u02a4\7\20\2\2\u02a1\u02a3\7\u00b4\2\2\u02a2\u02a1\3\2\2\2\u02a3\u02a6"+
		"\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a7\3\2\2\2\u02a6"+
		"\u02a4\3\2\2\2\u02a7\u02ab\7\u0095\2\2\u02a8\u02aa\7\u00b4\2\2\u02a9\u02a8"+
		"\3\2\2\2\u02aa\u02ad\3\2\2\2\u02ab\u02a9\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac"+
		"\u02ae\3\2\2\2\u02ad\u02ab\3\2\2\2\u02ae\u02b9\5$\23\2\u02af\u02b1\7\u00b4"+
		"\2\2\u02b0\u02af\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b2"+
		"\u02b3\3\2\2\2\u02b3\u02b5\3\2\2\2\u02b4\u02b6\5$\23\2\u02b5\u02b4\3\2"+
		"\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b8\3\2\2\2\u02b7\u02b0\3\2\2\2\u02b8"+
		"\u02bb\3\2\2\2\u02b9\u02b7\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02bc\3\2"+
		"\2\2\u02bb\u02b9\3\2\2\2\u02bc\u02c0\7\21\2\2\u02bd\u02bf\7\u00b4\2\2"+
		"\u02be\u02bd\3\2\2\2\u02bf\u02c2\3\2\2\2\u02c0\u02be\3\2\2\2\u02c0\u02c1"+
		"\3\2\2\2\u02c1#\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c3\u02c6\5&\24\2\u02c4"+
		"\u02c6\5(\25\2\u02c5\u02c3\3\2\2\2\u02c5\u02c4\3\2\2\2\u02c6%\3\2\2\2"+
		"\u02c7\u02c8\7\u00b0\2\2\u02c8\u02c9\7\22\2\2\u02c9\u02ca\5\26\f\2\u02ca"+
		"\'\3\2\2\2\u02cb\u02cc\7\u0099\2\2\u02cc\u02ce\7\u00b0\2\2\u02cd\u02cf"+
		"\7\u00b4\2\2\u02ce\u02cd\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf\u02d0\3\2\2"+
		"\2\u02d0\u02d1\7\27\2\2\u02d1\u02d6\5\60\31\2\u02d2\u02d3\7\r\2\2\u02d3"+
		"\u02d5\5\60\31\2\u02d4\u02d2\3\2\2\2\u02d5\u02d8\3\2\2\2\u02d6\u02d4\3"+
		"\2\2\2\u02d6\u02d7\3\2\2\2\u02d7\u02d9\3\2\2\2\u02d8\u02d6\3\2\2\2\u02d9"+
		"\u02da\7\30\2\2\u02da\u02db\7\n\2\2\u02db\u02dd\5\32\16\2\u02dc\u02de"+
		"\5*\26\2\u02dd\u02dc\3\2\2\2\u02dd\u02de\3\2\2\2\u02de)\3\2\2\2\u02df"+
		"\u02e1\7\u00b4\2\2\u02e0\u02df\3\2\2\2\u02e1\u02e4\3\2\2\2\u02e2\u02e0"+
		"\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3\u02e5\3\2\2\2\u02e4\u02e2\3\2\2\2\u02e5"+
		"\u02ee\5,\27\2\u02e6\u02e8\7\u00b4\2\2\u02e7\u02e6\3\2\2\2\u02e8\u02e9"+
		"\3\2\2\2\u02e9\u02e7\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb"+
		"\u02ed\5,\27\2\u02ec\u02e7\3\2\2\2\u02ed\u02f0\3\2\2\2\u02ee\u02ec\3\2"+
		"\2\2\u02ee\u02ef\3\2\2\2\u02ef\u02f9\3\2\2\2\u02f0\u02ee\3\2\2\2\u02f1"+
		"\u02f3\7\u00b4\2\2\u02f2\u02f1\3\2\2\2\u02f3\u02f6\3\2\2\2\u02f4\u02f2"+
		"\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f7\3\2\2\2\u02f6\u02f4\3\2\2\2\u02f7"+
		"\u02f9\5.\30\2\u02f8\u02e2\3\2\2\2\u02f8\u02f4\3\2\2\2\u02f9+\3\2\2\2"+
		"\u02fa\u02fb\7T\2\2\u02fb\u02fc\5\26\f\2\u02fc\u0300\7\r\2\2\u02fd\u02ff"+
		"\7\u00b4\2\2\u02fe\u02fd\3\2\2\2\u02ff\u0302\3\2\2\2\u0300\u02fe\3\2\2"+
		"\2\u0300\u0301\3\2\2\2\u0301\u0303\3\2\2\2\u0302\u0300\3\2\2\2\u0303\u0304"+
		"\7\u009a\2\2\u0304\u0305\5\26\f\2\u0305\u0306\7\27\2\2\u0306\u0307\7\u00b0"+
		"\2\2\u0307\u0308\7\30\2\2\u0308-\3\2\2\2\u0309\u030a\7T\2\2\u030a\u030b"+
		"\5\26\f\2\u030b/\3\2\2\2\u030c\u030d\7\u00b0\2\2\u030d\u030e\7\n\2\2\u030e"+
		"\u030f\5\32\16\2\u030f\61\3\2\2\2\u0310\u0312\5\64\33\2\u0311\u0310\3"+
		"\2\2\2\u0311\u0312\3\2\2\2\u0312\u031d\3\2\2\2\u0313\u0315\7\u00b4\2\2"+
		"\u0314\u0313\3\2\2\2\u0315\u0316\3\2\2\2\u0316\u0314\3\2\2\2\u0316\u0317"+
		"\3\2\2\2\u0317\u0319\3\2\2\2\u0318\u031a\5\64\33\2\u0319\u0318\3\2\2\2"+
		"\u0319\u031a\3\2\2\2\u031a\u031c\3\2\2\2\u031b\u0314\3\2\2\2\u031c\u031f"+
		"\3\2\2\2\u031d\u031b\3\2\2\2\u031d\u031e\3\2\2\2\u031e\63\3\2\2\2\u031f"+
		"\u031d\3\2\2\2\u0320\u0321\t#\2\2\u0321\u0322\7\u00b0\2\2\u0322\u0323"+
		"\7\n\2\2\u0323\u0324\5\32\16\2\u0324\u0326\7T\2\2\u0325\u0327\7\u00b4"+
		"\2\2\u0326\u0325\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u0328\3\2\2\2\u0328"+
		"\u0329\5> \2\u0329\u03c2\3\2\2\2\u032a\u032b\7\u00b0\2\2\u032b\u032d\7"+
		"T\2\2\u032c\u032e\7\u00b4\2\2\u032d\u032c\3\2\2\2\u032d\u032e\3\2\2\2"+
		"\u032e\u032f\3\2\2\2\u032f\u03c2\5> \2\u0330\u0331\7\23\2\2\u0331\u0332"+
		"\7\27\2\2\u0332\u0333\5> \2\u0333\u0334\7\30\2\2\u0334\u03c2\3\2\2\2\u0335"+
		"\u0336\7\u009d\2\2\u0336\u0337\7\27\2\2\u0337\u0338\5> \2\u0338\u0339"+
		"\7\30\2\2\u0339\u03c2\3\2\2\2\u033a\u033b\7\u009a\2\2\u033b\u033c\7\27"+
		"\2\2\u033c\u033d\5> \2\u033d\u0341\7\30\2\2\u033e\u0340\7\u00b4\2\2\u033f"+
		"\u033e\3\2\2\2\u0340\u0343\3\2\2\2\u0341\u033f\3\2\2\2\u0341\u0342\3\2"+
		"\2\2\u0342\u0344\3\2\2\2\u0343\u0341\3\2\2\2\u0344\u0345\7\20\2\2\u0345"+
		"\u034f\5\66\34\2\u0346\u034a\7\u009e\2\2\u0347\u0349\7\u00b4\2\2\u0348"+
		"\u0347\3\2\2\2\u0349\u034c\3\2\2\2\u034a\u0348\3\2\2\2\u034a\u034b\3\2"+
		"\2\2\u034b\u034d\3\2\2\2\u034c\u034a\3\2\2\2\u034d\u034e\7\20\2\2\u034e"+
		"\u0350\5\66\34\2\u034f\u0346\3\2\2\2\u034f\u0350\3\2\2\2\u0350\u03c2\3"+
		"\2\2\2\u0351\u0352\7\u009f\2\2\u0352\u0353\7\27\2\2\u0353\u0354\5> \2"+
		"\u0354\u0358\7\30\2\2\u0355\u0357\7\u00b4\2\2\u0356\u0355\3\2\2\2\u0357"+
		"\u035a\3\2\2\2\u0358\u0356\3\2\2\2\u0358\u0359\3\2\2\2\u0359\u035b\3\2"+
		"\2\2\u035a\u0358\3\2\2\2\u035b\u0366\7\20\2\2\u035c\u035e\7\u00b4\2\2"+
		"\u035d\u035c\3\2\2\2\u035e\u0361\3\2\2\2\u035f\u035d\3\2\2\2\u035f\u0360"+
		"\3\2\2\2\u0360\u0362\3\2\2\2\u0361\u035f\3\2\2\2\u0362\u0363\7\u00a0\2"+
		"\2\u0363\u0364\5@!\2\u0364\u0365\7\u00a1\2\2\u0365\u0367\3\2\2\2\u0366"+
		"\u035f\3\2\2\2\u0366\u0367\3\2\2\2\u0367\u0368\3\2\2\2\u0368\u0369\5\66"+
		"\34\2\u0369\u03c2\3\2\2\2\u036a\u036b\t$\2\2\u036b\u0374\7\27\2\2\u036c"+
		"\u0371\5:\36\2\u036d\u036e\7\r\2\2\u036e\u0370\5:\36\2\u036f\u036d\3\2"+
		"\2\2\u0370\u0373\3\2\2\2\u0371\u036f\3\2\2\2\u0371\u0372\3\2\2\2\u0372"+
		"\u0375\3\2\2\2\u0373\u0371\3\2\2\2\u0374\u036c\3\2\2\2\u0374\u0375\3\2"+
		"\2\2\u0375\u0376\3\2\2\2\u0376\u03c2\7\30\2\2\u0377\u0378\7\u00b0\2\2"+
		"\u0378\u0379\7\27\2\2\u0379\u037a\5> \2\u037a\u037b\7\30\2\2\u037b\u037d"+
		"\7T\2\2\u037c\u037e\7\u00b4\2\2\u037d\u037c\3\2\2\2\u037d\u037e\3\2\2"+
		"\2\u037e\u037f\3\2\2\2\u037f\u0380\5> \2\u0380\u03c2\3\2\2\2\u0381\u0382"+
		"\7\u00a4\2\2\u0382\u0384\7\u00b0\2\2\u0383\u0381\3\2\2\2\u0383\u0384\3"+
		"\2\2\2\u0384\u0385\3\2\2\2\u0385\u0386\7\u0099\2\2\u0386\u0388\7\u00b0"+
		"\2\2\u0387\u0389\7\u00b4\2\2\u0388\u0387\3\2\2\2\u0388\u0389\3\2\2\2\u0389"+
		"\u038a\3\2\2\2\u038a\u0393\7\27\2\2\u038b\u0390\5\60\31\2\u038c\u038d"+
		"\7\r\2\2\u038d\u038f\5\60\31\2\u038e\u038c\3\2\2\2\u038f\u0392\3\2\2\2"+
		"\u0390\u038e\3\2\2\2\u0390\u0391\3\2\2\2\u0391\u0394\3\2\2\2\u0392\u0390"+
		"\3\2\2\2\u0393\u038b\3\2\2\2\u0393\u0394\3\2\2\2\u0394\u0395\3\2\2\2\u0395"+
		"\u0396\7\30\2\2\u0396\u0399\7\n\2\2\u0397\u039a\5\32\16\2\u0398\u039a"+
		"\7\u00a5\2\2\u0399\u0397\3\2\2\2\u0399\u0398\3\2\2\2\u039a\u039b\3\2\2"+
		"\2\u039b\u039f\7T\2\2\u039c\u039e\7\u00b4\2\2\u039d\u039c\3\2\2\2\u039e"+
		"\u03a1\3\2\2\2\u039f\u039d\3\2\2\2\u039f\u03a0\3\2\2\2\u03a0\u03a2\3\2"+
		"\2\2\u03a1\u039f\3\2\2\2\u03a2\u03b3\7\20\2\2\u03a3\u03a5\7\u00b4\2\2"+
		"\u03a4\u03a3\3\2\2\2\u03a5\u03a8\3\2\2\2\u03a6\u03a4\3\2\2\2\u03a6\u03a7"+
		"\3\2\2\2\u03a7\u03a9\3\2\2\2\u03a8\u03a6\3\2\2\2\u03a9\u03aa\7\u00a0\2"+
		"\2\u03aa\u03ae\5D#\2\u03ab\u03ad\7\u00b4\2\2\u03ac\u03ab\3\2\2\2\u03ad"+
		"\u03b0\3\2\2\2\u03ae\u03ac\3\2\2\2\u03ae\u03af\3\2\2\2\u03af\u03b1\3\2"+
		"\2\2\u03b0\u03ae\3\2\2\2\u03b1\u03b2\7\u00a1\2\2\u03b2\u03b4\3\2\2\2\u03b3"+
		"\u03a6\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03b5\3\2\2\2\u03b5\u03c2\5\66"+
		"\34\2\u03b6\u03bb\7\u00a0\2\2\u03b7\u03bc\5\20\t\2\u03b8\u03bc\5\16\b"+
		"\2\u03b9\u03bc\5F$\2\u03ba\u03bc\5\"\22\2\u03bb\u03b7\3\2\2\2\u03bb\u03b8"+
		"\3\2\2\2\u03bb\u03b9\3\2\2\2\u03bb\u03ba\3\2\2\2\u03bc\u03bd\3\2\2\2\u03bd"+
		"\u03be\7\u00a1\2\2\u03be\u03c2\3\2\2\2\u03bf\u03c2\5 \21\2\u03c0\u03c2"+
		"\5> \2\u03c1\u0320\3\2\2\2\u03c1\u032a\3\2\2\2\u03c1\u0330\3\2\2\2\u03c1"+
		"\u0335\3\2\2\2\u03c1\u033a\3\2\2\2\u03c1\u0351\3\2\2\2\u03c1\u036a\3\2"+
		"\2\2\u03c1\u0377\3\2\2\2\u03c1\u0383\3\2\2\2\u03c1\u03b6\3\2\2\2\u03c1"+
		"\u03bf\3\2\2\2\u03c1\u03c0\3\2\2\2\u03c2\65\3\2\2\2\u03c3\u03cb\5\62\32"+
		"\2\u03c4\u03c8\58\35\2\u03c5\u03c7\7\u00b4\2\2\u03c6\u03c5\3\2\2\2\u03c7"+
		"\u03ca\3\2\2\2\u03c8\u03c6\3\2\2\2\u03c8\u03c9\3\2\2\2\u03c9\u03cc\3\2"+
		"\2\2\u03ca\u03c8\3\2\2\2\u03cb\u03c4\3\2\2\2\u03cb\u03cc\3\2\2\2\u03cc"+
		"\u03cd\3\2\2\2\u03cd\u03ce\7\21\2\2\u03ce\67\3\2\2\2\u03cf\u03d1\7\u00a6"+
		"\2\2\u03d0\u03d2\5> \2\u03d1\u03d0\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d29"+
		"\3\2\2\2\u03d3\u03d6\7\u00b9\2\2\u03d4\u03d6\5> \2\u03d5\u03d3\3\2\2\2"+
		"\u03d5\u03d4\3\2\2\2\u03d6;\3\2\2\2\u03d7\u03fd\t\6\2\2\u03d8\u03fd\7"+
		"\u00af\2\2\u03d9\u03fd\7\u00b0\2\2\u03da\u03db\t\b\2\2\u03db\u03dc\7\22"+
		"\2\2\u03dc\u03dd\7\u00b0\2\2\u03dd\u03e6\7\27\2\2\u03de\u03e3\5> \2\u03df"+
		"\u03e0\7\r\2\2\u03e0\u03e2\5> \2\u03e1\u03df\3\2\2\2\u03e2\u03e5\3\2\2"+
		"\2\u03e3\u03e1\3\2\2\2\u03e3\u03e4\3\2\2\2\u03e4\u03e7\3\2\2\2\u03e5\u03e3"+
		"\3\2\2\2\u03e6\u03de\3\2\2\2\u03e6\u03e7\3\2\2\2\u03e7\u03e8\3\2\2\2\u03e8"+
		"\u03fd\7\30\2\2\u03e9\u03ea\t\23\2\2\u03ea\u03eb\7\22\2\2\u03eb\u03fd"+
		"\7\u00b0\2\2\u03ec\u03fd\7\u00ba\2\2\u03ed\u03fd\7\u00b2\2\2\u03ee\u03fd"+
		"\7\u00b1\2\2\u03ef\u03f0\t\b\2\2\u03f0\u03f9\7\27\2\2\u03f1\u03f6\5> "+
		"\2\u03f2\u03f3\7\r\2\2\u03f3\u03f5\5> \2\u03f4\u03f2\3\2\2\2\u03f5\u03f8"+
		"\3\2\2\2\u03f6\u03f4\3\2\2\2\u03f6\u03f7\3\2\2\2\u03f7\u03fa\3\2\2\2\u03f8"+
		"\u03f6\3\2\2\2\u03f9\u03f1\3\2\2\2\u03f9\u03fa\3\2\2\2\u03fa\u03fb\3\2"+
		"\2\2\u03fb\u03fd\7\30\2\2\u03fc\u03d7\3\2\2\2\u03fc\u03d8\3\2\2\2\u03fc"+
		"\u03d9\3\2\2\2\u03fc\u03da\3\2\2\2\u03fc\u03e9\3\2\2\2\u03fc\u03ec\3\2"+
		"\2\2\u03fc\u03ed\3\2\2\2\u03fc\u03ee\3\2\2\2\u03fc\u03ef\3\2\2\2\u03fd"+
		"=\3\2\2\2\u03fe\u03ff\b \1\2\u03ff\u0400\7\u00b0\2\2\u0400\u0409\7\27"+
		"\2\2\u0401\u0406\5> \2\u0402\u0403\7\r\2\2\u0403\u0405\5> \2\u0404\u0402"+
		"\3\2\2\2\u0405\u0408\3\2\2\2\u0406\u0404\3\2\2\2\u0406\u0407\3\2\2\2\u0407"+
		"\u040a\3\2\2\2\u0408\u0406\3\2\2\2\u0409\u0401\3\2\2\2\u0409\u040a\3\2"+
		"\2\2\u040a\u040b\3\2\2\2\u040b\u0424\7\30\2\2\u040c\u0411\5<\37\2\u040d"+
		"\u040e\7\22\2\2\u040e\u0410\7\u00b0\2\2\u040f\u040d\3\2\2\2\u0410\u0413"+
		"\3\2\2\2\u0411\u040f\3\2\2\2\u0411\u0412\3\2\2\2\u0412\u0424\3\2\2\2\u0413"+
		"\u0411\3\2\2\2\u0414\u0415\7\u00a7\2\2\u0415\u0416\7\27\2\2\u0416\u0424"+
		"\7\30\2\2\u0417\u0418\7\u00a8\2\2\u0418\u041a\7\27\2\2\u0419\u041b\7\u00b9"+
		"\2\2\u041a\u0419\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u041c\3\2\2\2\u041c"+
		"\u0424\7\30\2\2\u041d\u041e\7\27\2\2\u041e\u041f\5> \2\u041f\u0420\7\30"+
		"\2\2\u0420\u0424\3\2\2\2\u0421\u0422\t%\2\2\u0422\u0424\5> \f\u0423\u03fe"+
		"\3\2\2\2\u0423\u040c\3\2\2\2\u0423\u0414\3\2\2\2\u0423\u0417\3\2\2\2\u0423"+
		"\u041d\3\2\2\2\u0423\u0421\3\2\2\2\u0424\u045d\3\2\2\2\u0425\u0426\f\13"+
		"\2\2\u0426\u0428\t\n\2\2\u0427\u0429\7\u00b4\2\2\u0428\u0427\3\2\2\2\u0428"+
		"\u0429\3\2\2\2\u0429\u042a\3\2\2\2\u042a\u045c\5> \f\u042b\u042c\f\n\2"+
		"\2\u042c\u042e\t\13\2\2\u042d\u042f\7\u00b4\2\2\u042e\u042d\3\2\2\2\u042e"+
		"\u042f\3\2\2\2\u042f\u0430\3\2\2\2\u0430\u045c\5> \13\u0431\u0432\f\t"+
		"\2\2\u0432\u0434\7I\2\2\u0433\u0435\7\u00b4\2\2\u0434\u0433\3\2\2\2\u0434"+
		"\u0435\3\2\2\2\u0435\u0436\3\2\2\2\u0436\u045c\5> \t\u0437\u0438\f\b\2"+
		"\2\u0438\u043a\7J\2\2\u0439\u043b\7\u00b4\2\2\u043a\u0439\3\2\2\2\u043a"+
		"\u043b\3\2\2\2\u043b\u043c\3\2\2\2\u043c\u045c\5> \t\u043d\u043e\f\7\2"+
		"\2\u043e\u0440\t&\2\2\u043f\u0441\7\u00b4\2\2\u0440\u043f\3\2\2\2\u0440"+
		"\u0441\3\2\2\2\u0441\u0442\3\2\2\2\u0442\u045c\5> \b\u0443\u0444\f\6\2"+
		"\2\u0444\u0446\t\'\2\2\u0445\u0447\7\u00b4\2\2\u0446\u0445\3\2\2\2\u0446"+
		"\u0447\3\2\2\2\u0447\u0448\3\2\2\2\u0448\u045c\5> \7\u0449\u044a\f\5\2"+
		"\2\u044a\u044c\7^\2\2\u044b\u044d\7\u00b4\2\2\u044c\u044b\3\2\2\2\u044c"+
		"\u044d\3\2\2\2\u044d\u044e\3\2\2\2\u044e\u045c\5> \6\u044f\u0450\f\4\2"+
		"\2\u0450\u0452\7b\2\2\u0451\u0453\7\u00b4\2\2\u0452\u0451\3\2\2\2\u0452"+
		"\u0453\3\2\2\2\u0453\u0454\3\2\2\2\u0454\u045c\5> \5\u0455\u0456\f\3\2"+
		"\2\u0456\u0458\7\4\2\2\u0457\u0459\7\u00b4\2\2\u0458\u0457\3\2\2\2\u0458"+
		"\u0459\3\2\2\2\u0459\u045a\3\2\2\2\u045a\u045c\5> \4\u045b\u0425\3\2\2"+
		"\2\u045b\u042b\3\2\2\2\u045b\u0431\3\2\2\2\u045b\u0437\3\2\2\2\u045b\u043d"+
		"\3\2\2\2\u045b\u0443\3\2\2\2\u045b\u0449\3\2\2\2\u045b\u044f\3\2\2\2\u045b"+
		"\u0455\3\2\2\2\u045c\u045f\3\2\2\2\u045d\u045b\3\2\2\2\u045d\u045e\3\2"+
		"\2\2\u045e?\3\2\2\2\u045f\u045d\3\2\2\2\u0460\u0464\7\20\2\2\u0461\u0463"+
		"\7\u00b4\2\2\u0462\u0461\3\2\2\2\u0463\u0466\3\2\2\2\u0464\u0462\3\2\2"+
		"\2\u0464\u0465\3\2\2\2\u0465\u0467\3\2\2\2\u0466\u0464\3\2\2\2\u0467\u0468"+
		"\5B\"\2\u0468\u046c\7\21\2\2\u0469\u046b\7\u00b4\2\2\u046a\u0469\3\2\2"+
		"\2\u046b\u046e\3\2\2\2\u046c\u046a\3\2\2\2\u046c\u046d\3\2\2\2\u046d\u0496"+
		"\3\2\2\2\u046e\u046c\3\2\2\2\u046f\u0473\7\20\2\2\u0470\u0472\7\u00b4"+
		"\2\2\u0471\u0470\3\2\2\2\u0472\u0475\3\2\2\2\u0473\u0471\3\2\2\2\u0473"+
		"\u0474\3\2\2\2\u0474\u0476\3\2\2\2\u0475\u0473\3\2\2\2\u0476\u047a\7\u0094"+
		"\2\2\u0477\u0479\7\u00b4\2\2\u0478\u0477\3\2\2\2\u0479\u047c\3\2\2\2\u047a"+
		"\u0478\3\2\2\2\u047a\u047b\3\2\2\2\u047b\u047d\3\2\2\2\u047c\u047a\3\2"+
		"\2\2\u047d\u0488\5\26\f\2\u047e\u0480\7\u00b4\2\2\u047f\u047e\3\2\2\2"+
		"\u0480\u0481\3\2\2\2\u0481\u047f\3\2\2\2\u0481\u0482\3\2\2\2\u0482\u0484"+
		"\3\2\2\2\u0483\u0485\5\26\f\2\u0484\u0483\3\2\2\2\u0484\u0485\3\2\2\2"+
		"\u0485\u0487\3\2\2\2\u0486\u047f\3\2\2\2\u0487\u048a\3\2\2\2\u0488\u0486"+
		"\3\2\2\2\u0488\u0489\3\2\2\2\u0489\u048c\3\2\2\2\u048a\u0488\3\2\2\2\u048b"+
		"\u048d\5B\"\2\u048c\u048b\3\2\2\2\u048c\u048d\3\2\2\2\u048d\u048e\3\2"+
		"\2\2\u048e\u0492\7\21\2\2\u048f\u0491\7\u00b4\2\2\u0490\u048f\3\2\2\2"+
		"\u0491\u0494\3\2\2\2\u0492\u0490\3\2\2\2\u0492\u0493\3\2\2\2\u0493\u0496"+
		"\3\2\2\2\u0494\u0492\3\2\2\2\u0495\u0460\3\2\2\2\u0495\u046f\3\2\2\2\u0496"+
		"A\3\2\2\2\u0497\u0498\7\u00a9\2\2\u0498\u049d\7\u00b0\2\2\u0499\u049a"+
		"\7\r\2\2\u049a\u049c\7\u00b0\2\2\u049b\u0499\3\2\2\2\u049c\u049f\3\2\2"+
		"\2\u049d\u049b\3\2\2\2\u049d\u049e\3\2\2\2\u049e\u04a3\3\2\2\2\u049f\u049d"+
		"\3\2\2\2\u04a0\u04a2\7\u00b4\2\2\u04a1\u04a0\3\2\2\2\u04a2\u04a5\3\2\2"+
		"\2\u04a3\u04a1\3\2\2\2\u04a3\u04a4\3\2\2\2\u04a4C\3\2\2\2\u04a5\u04a3"+
		"\3\2\2\2\u04a6\u04aa\7\20\2\2\u04a7\u04a9\7\u00b4\2\2\u04a8\u04a7\3\2"+
		"\2\2\u04a9\u04ac\3\2\2\2\u04aa\u04a8\3\2\2\2\u04aa\u04ab\3\2\2\2\u04ab"+
		"\u04c2\3\2\2\2\u04ac\u04aa\3\2\2\2\u04ad\u04b1\t(\2\2\u04ae\u04b0\7\u00b4"+
		"\2\2\u04af\u04ae\3\2\2\2\u04b0\u04b3\3\2\2\2\u04b1\u04af\3\2\2\2\u04b1"+
		"\u04b2\3\2\2\2\u04b2\u04b4\3\2\2\2\u04b3\u04b1\3\2\2\2\u04b4\u04bf\5\26"+
		"\f\2\u04b5\u04b7\7\u00b4\2\2\u04b6\u04b5\3\2\2\2\u04b7\u04b8\3\2\2\2\u04b8"+
		"\u04b6\3\2\2\2\u04b8\u04b9\3\2\2\2\u04b9\u04bb\3\2\2\2\u04ba\u04bc\5\26"+
		"\f\2\u04bb\u04ba\3\2\2\2\u04bb\u04bc\3\2\2\2\u04bc\u04be\3\2\2\2\u04bd"+
		"\u04b6\3\2\2\2\u04be\u04c1\3\2\2\2\u04bf\u04bd\3\2\2\2\u04bf\u04c0\3\2"+
		"\2\2\u04c0\u04c3\3\2\2\2\u04c1\u04bf\3\2\2\2\u04c2\u04ad\3\2\2\2\u04c2"+
		"\u04c3\3\2\2\2\u04c3\u04c7\3\2\2\2\u04c4\u04c6\7\u00b4\2\2\u04c5\u04c4"+
		"\3\2\2\2\u04c6\u04c9\3\2\2\2\u04c7\u04c5\3\2\2\2\u04c7\u04c8\3\2\2\2\u04c8"+
		"\u04cb\3\2\2\2\u04c9\u04c7\3\2\2\2\u04ca\u04cc\5B\"\2\u04cb\u04ca\3\2"+
		"\2\2\u04cb\u04cc\3\2\2\2\u04cc\u04e2\3\2\2\2\u04cd\u04d1\t)\2\2\u04ce"+
		"\u04d0\7\u00b4\2\2\u04cf\u04ce\3\2\2\2\u04d0\u04d3\3\2\2\2\u04d1\u04cf"+
		"\3\2\2\2\u04d1\u04d2\3\2\2\2\u04d2\u04d4\3\2\2\2\u04d3\u04d1\3\2\2\2\u04d4"+
		"\u04df\5\26\f\2\u04d5\u04d7\7\u00b4\2\2\u04d6\u04d5\3\2\2\2\u04d7\u04d8"+
		"\3\2\2\2\u04d8\u04d6\3\2\2\2\u04d8\u04d9\3\2\2\2\u04d9\u04db\3\2\2\2\u04da"+
		"\u04dc\5\26\f\2\u04db\u04da\3\2\2\2\u04db\u04dc\3\2\2\2\u04dc\u04de\3"+
		"\2\2\2\u04dd\u04d6\3\2\2\2\u04de\u04e1\3\2\2\2\u04df\u04dd\3\2\2\2\u04df"+
		"\u04e0\3\2\2\2\u04e0\u04e3\3\2\2\2\u04e1\u04df\3\2\2\2\u04e2\u04cd\3\2"+
		"\2\2\u04e2\u04e3\3\2\2\2\u04e3\u04e7\3\2\2\2\u04e4\u04e6\7\u00b4\2\2\u04e5"+
		"\u04e4\3\2\2\2\u04e6\u04e9\3\2\2\2\u04e7\u04e5\3\2\2\2\u04e7\u04e8\3\2"+
		"\2\2\u04e8\u04ea\3\2\2\2\u04e9\u04e7\3\2\2\2\u04ea\u04ee\7\21\2\2\u04eb"+
		"\u04ed\7\u00b4\2\2\u04ec\u04eb\3\2\2\2\u04ed\u04f0\3\2\2\2\u04ee\u04ec"+
		"\3\2\2\2\u04ee\u04ef\3\2\2\2\u04efE\3\2\2\2\u04f0\u04ee\3\2\2\2\u04f1"+
		"\u04f5\7\20\2\2\u04f2\u04f4\7\u00b4\2\2\u04f3\u04f2\3\2\2\2\u04f4\u04f7"+
		"\3\2\2\2\u04f5\u04f3\3\2\2\2\u04f5\u04f6\3\2\2\2\u04f6\u04f8\3\2\2\2\u04f7"+
		"\u04f5\3\2\2\2\u04f8\u04fc\7\u0094\2\2\u04f9\u04fb\7\u00b4\2\2\u04fa\u04f9"+
		"\3\2\2\2\u04fb\u04fe\3\2\2\2\u04fc\u04fa\3\2\2\2\u04fc\u04fd\3\2\2\2\u04fd"+
		"\u04ff\3\2\2\2\u04fe\u04fc\3\2\2\2\u04ff\u050a\5\26\f\2\u0500\u0502\7"+
		"\u00b4\2\2\u0501\u0500\3\2\2\2\u0502\u0503\3\2\2\2\u0503\u0501\3\2\2\2"+
		"\u0503\u0504\3\2\2\2\u0504\u0506\3\2\2\2\u0505\u0507\5\26\f\2\u0506\u0505"+
		"\3\2\2\2\u0506\u0507\3\2\2\2\u0507\u0509\3\2\2\2\u0508\u0501\3\2\2\2\u0509"+
		"\u050c\3\2\2\2\u050a\u0508\3\2\2\2\u050a\u050b\3\2\2\2\u050b\u050d\3\2"+
		"\2\2\u050c\u050a\3\2\2\2\u050d\u0511\7\21\2\2\u050e\u0510\7\u00b4\2\2"+
		"\u050f\u050e\3\2\2\2\u0510\u0513\3\2\2\2\u0511\u050f\3\2\2\2\u0511\u0512"+
		"\3\2\2\2\u0512G\3\2\2\2\u0513\u0511\3\2\2\2\u00bbNUY^fkrx}\u0084\u008a"+
		"\u008f\u0095\u009b\u009e\u00a3\u00a9\u00b0\u00b9\u00c1\u00c7\u00cd\u00d5"+
		"\u00db\u00de\u00e4\u00ed\u00f0\u00f8\u00fe\u0105\u0107\u010b\u0110\u0113"+
		"\u0117\u011e\u012b\u0132\u013a\u0142\u0147\u014c\u014f\u0153\u0157\u0165"+
		"\u0172\u0186\u0189\u018c\u0194\u019c\u01a1\u01a7\u01ad\u01b3\u01b9\u01bf"+
		"\u01c5\u01cb\u01d1\u01d7\u01da\u01dc\u01e5\u01ee\u01f2\u01f7\u01fa\u0204"+
		"\u020b\u0211\u0217\u023b\u024a\u0254\u0261\u0268\u0274\u0282\u0285\u028a"+
		"\u0291\u0295\u02a4\u02ab\u02b2\u02b5\u02b9\u02c0\u02c5\u02ce\u02d6\u02dd"+
		"\u02e2\u02e9\u02ee\u02f4\u02f8\u0300\u0311\u0316\u0319\u031d\u0326\u032d"+
		"\u0341\u034a\u034f\u0358\u035f\u0366\u0371\u0374\u037d\u0383\u0388\u0390"+
		"\u0393\u0399\u039f\u03a6\u03ae\u03b3\u03bb\u03c1\u03c8\u03cb\u03d1\u03d5"+
		"\u03e3\u03e6\u03f6\u03f9\u03fc\u0406\u0409\u0411\u041a\u0423\u0428\u042e"+
		"\u0434\u043a\u0440\u0446\u044c\u0452\u0458\u045b\u045d\u0464\u046c\u0473"+
		"\u047a\u0481\u0484\u0488\u048c\u0492\u0495\u049d\u04a3\u04aa\u04b1\u04b8"+
		"\u04bb\u04bf\u04c2\u04c7\u04cb\u04d1\u04d8\u04db\u04df\u04e2\u04e7\u04ee"+
		"\u04f5\u04fc\u0503\u0506\u050a\u0511";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}