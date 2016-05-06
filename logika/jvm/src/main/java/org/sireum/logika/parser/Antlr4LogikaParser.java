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
		RULE_fact = 13, RULE_fun = 14, RULE_funDef = 15, RULE_param = 16, RULE_stmts = 17, 
		RULE_stmt = 18, RULE_stringOrExp = 19, RULE_primExp = 20, RULE_exp = 21, 
		RULE_loopInvariant = 22, RULE_modifies = 23, RULE_methodContract = 24, 
		RULE_invariants = 25;
	public static final String[] ruleNames = {
		"file", "sequent", "proof", "proofStep", "primFormula", "formula", "qformula", 
		"type", "justification", "program", "impor", "facts", "factOrFun", "fact", 
		"fun", "funDef", "param", "stmts", "stmt", "stringOrExp", "primExp", "exp", 
		"loopInvariant", "modifies", "methodContract", "invariants"
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
			setState(73);
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
				break;
			case EOF:
			case T__146:
			case NL:
				_localctx = new ProgramFileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				program();
				setState(71);
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
			setState(106);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
					{
					setState(75);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					setState(80);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(76);
						match(T__0);
						setState(77);
						((SequentContext)_localctx).formula = formula(0);
						((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
						}
						}
						setState(82);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(85);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(86);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(87);
					match(T__0);
					setState(88);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
					{
					{
					setState(94);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(100);
				match(HLINE);
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(101);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(104); 
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
			setState(108);
			((ProofContext)_localctx).tb = match(T__3);
			setState(110);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(109);
				proofStep();
				}
			}

			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(113); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(112);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(115); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(118);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(117);
					proofStep();
					}
				}

				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
			((ProofContext)_localctx).te = match(T__4);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(126);
					match(NL);
					}
					} 
				}
				setState(131);
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
			setState(186);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(NUM);
				setState(133);
				match(T__5);
				setState(134);
				formula(0);
				setState(135);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(138);
				match(T__5);
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(139);
					match(NL);
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(145);
				match(T__3);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(146);
					match(NL);
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(152);
				((SubProofContext)_localctx).assume = match(NUM);
				setState(153);
				match(T__5);
				setState(170);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
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

					}
					break;
				case 2:
					{
					setState(159);
					formula(0);
					setState(160);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				case 3:
					{
					setState(162);
					match(ID);
					setState(165);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(163);
						match(T__6);
						setState(164);
						type();
						}
					}

					setState(167);
					formula(0);
					setState(168);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(173); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(172);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(175); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(178);
					_la = _input.LA(1);
					if (_la==NUM) {
						{
						setState(177);
						proofStep();
						}
					}

					}
					}
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(185);
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
		enterRule(_localctx, 8, RULE_primFormula);
		int _la;
		try {
			setState(239);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
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
				setState(189);
				match(T__15);
				setState(190);
				formula(0);
				setState(191);
				match(T__16);
				}
				break;
			case 3:
				_localctx = new ApplyResultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
				((ApplyResultContext)_localctx).tb = match(T__17);
				setState(194);
				match(T__15);
				setState(195);
				formula(0);
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(196);
					match(T__0);
					setState(197);
					formula(0);
					}
					}
					setState(202);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(203);
				match(T__16);
				}
				break;
			case 4:
				_localctx = new ResultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(205);
				match(T__17);
				}
				break;
			case 5:
				_localctx = new ApplyContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(206);
				match(ID);
				setState(207);
				match(T__15);
				setState(208);
				formula(0);
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(209);
					match(T__0);
					setState(210);
					formula(0);
					}
					}
					setState(215);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(216);
				match(T__16);
				}
				break;
			case 6:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(218);
				((VarContext)_localctx).tb = match(ID);
				}
				break;
			case 7:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(219);
				match(NUM);
				}
				break;
			case 8:
				_localctx = new IntLitContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(220);
				match(INT);
				}
				break;
			case 9:
				_localctx = new RLitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(221);
				match(REAL);
				}
				break;
			case 10:
				_localctx = new FloatLitContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(222);
				match(FLOAT);
				}
				break;
			case 11:
				_localctx = new TypeAccessContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(223);
				((TypeAccessContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
					((TypeAccessContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(224);
				match(T__5);
				setState(225);
				match(ID);
				}
				break;
			case 12:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(226);
				((SeqContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0)) ) {
					((SeqContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(227);
				match(T__15);
				setState(236);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (FLOAT - 163)))) != 0)) {
					{
					setState(228);
					exp(0);
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(229);
						match(T__0);
						setState(230);
						exp(0);
						}
						}
						setState(235);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(238);
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
			setState(255);
			switch (_input.LA(1)) {
			case T__66:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(242);
				((UnaryContext)_localctx).op = match(T__66);
				setState(243);
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
				setState(244);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)) | (1L << (T__85 - 83)) | (1L << (T__86 - 83)))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(245);
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
				setState(246);
				primFormula();
				setState(251);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(247);
						match(T__5);
						setState(248);
						match(ID);
						}
						} 
					}
					setState(253);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
				setState(254);
				qformula();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(319);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(317);
					switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(257);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(258);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (T__62 - 63)) | (1L << (T__63 - 63)) | (1L << (T__64 - 63)))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(263);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(264);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__65 || _la==T__66) ) {
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
						((BinaryContext)_localctx).r = formula(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(269);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(270);
						((BinaryContext)_localctx).op = match(T__67);
						setState(272);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(271);
							match(NL);
							}
						}

						setState(274);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(275);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(276);
						((BinaryContext)_localctx).op = match(T__68);
						setState(278);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(277);
							match(NL);
							}
						}

						setState(280);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(281);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(282);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)) | (1L << (T__72 - 70)) | (1L << (T__73 - 70)) | (1L << (T__74 - 70)) | (1L << (T__75 - 70)) | (1L << (T__76 - 70)) | (1L << (T__77 - 70)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(284);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(283);
							match(NL);
							}
						}

						setState(286);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(287);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(288);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (T__78 - 79)) | (1L << (T__79 - 79)) | (1L << (T__80 - 79)) | (1L << (T__81 - 79)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(290);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(289);
							match(NL);
							}
						}

						setState(292);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(293);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(294);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (T__87 - 88)) | (1L << (T__88 - 88)) | (1L << (T__89 - 88)) | (1L << (T__90 - 88)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(296);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(295);
							match(NL);
							}
						}

						setState(298);
						((BinaryContext)_localctx).r = formula(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(299);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(300);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__91 || _la==T__92) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(302);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(301);
							match(NL);
							}
						}

						setState(304);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(305);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(306);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (T__93 - 94)) | (1L << (T__94 - 94)) | (1L << (T__95 - 94)) | (1L << (T__96 - 94)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(308);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(307);
							match(NL);
							}
						}

						setState(310);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 10:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(311);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(312);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (T__97 - 98)) | (1L << (T__98 - 98)) | (1L << (T__99 - 98)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
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
						((BinaryContext)_localctx).r = formula(2);
						}
						break;
					}
					} 
				}
				setState(321);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
			setState(322);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & ((1L << (T__100 - 101)) | (1L << (T__101 - 101)) | (1L << (T__102 - 101)) | (1L << (T__103 - 101)) | (1L << (T__104 - 101)) | (1L << (T__105 - 101)) | (1L << (T__106 - 101)) | (1L << (T__107 - 101)))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(323);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(324);
				match(T__0);
				setState(325);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(330);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(346);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(331);
				match(T__6);
				setState(332);
				type();
				}
				break;
			case 2:
				{
				setState(333);
				match(T__6);
				setState(334);
				match(T__15);
				setState(335);
				((QformulaContext)_localctx).lo = exp(0);
				setState(337);
				_la = _input.LA(1);
				if (_la==T__69) {
					{
					setState(336);
					((QformulaContext)_localctx).ll = match(T__69);
					}
				}

				setState(339);
				match(T__108);
				setState(341);
				_la = _input.LA(1);
				if (_la==T__69) {
					{
					setState(340);
					((QformulaContext)_localctx).lh = match(T__69);
					}
				}

				setState(343);
				((QformulaContext)_localctx).hi = exp(0);
				setState(344);
				match(T__16);
				}
				break;
			}
			setState(349);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(348);
				match(NL);
				}
			}

			setState(351);
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
			setState(353);
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
			setState(488);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(355);
				((PremiseContext)_localctx).t = match(T__109);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(359);
				switch (_input.LA(1)) {
				case T__110:
					{
					setState(356);
					((AndIntroContext)_localctx).tb = match(T__110);
					}
					break;
				case T__88:
				case T__89:
				case T__90:
					{
					setState(357);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (T__88 - 89)) | (1L << (T__89 - 89)) | (1L << (T__90 - 89)))) != 0)) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(358);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(361);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(362);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(366);
				switch (_input.LA(1)) {
				case T__111:
				case T__112:
					{
					setState(363);
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
					setState(364);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (T__88 - 89)) | (1L << (T__89 - 89)) | (1L << (T__90 - 89)))) != 0)) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(365);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(368);
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(372);
				switch (_input.LA(1)) {
				case T__113:
				case T__114:
				case T__115:
				case T__116:
					{
					setState(369);
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
					setState(370);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__94 || _la==T__96) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(371);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(374);
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(378);
				switch (_input.LA(1)) {
				case T__117:
				case T__118:
					{
					setState(375);
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
					setState(376);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__94 || _la==T__96) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(377);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(380);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(381);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(382);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(383);
				((ImpliesIntroContext)_localctx).tb = match(T__119);
				setState(384);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(385);
				((ImpliesElimContext)_localctx).tb = match(T__120);
				setState(386);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(387);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(388);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(389);
				((ImpliesIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__98 || _la==T__99) ) {
					((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(390);
				match(ID);
				setState(391);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(392);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				      "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n      \"e\".equals(_input.LT(2).getText())");
				setState(393);
				((ImpliesElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__98 || _la==T__99) ) {
					((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(394);
				match(ID);
				setState(395);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(396);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(397);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__121 || _la==T__122) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(398);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 11:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(399);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__123 || _la==T__124) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(400);
				((NegElimContext)_localctx).step = match(NUM);
				setState(401);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 12:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(402);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(403);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)))) != 0)) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(404);
				match(ID);
				setState(405);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(406);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(407);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)))) != 0)) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(408);
				match(ID);
				setState(409);
				((NegElimContext)_localctx).step = match(NUM);
				setState(410);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 14:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(414);
				switch (_input.LA(1)) {
				case T__125:
				case T__126:
					{
					setState(411);
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
					setState(412);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==T__14) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(413);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(416);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 15:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(417);
				((PbcContext)_localctx).tb = match(T__127);
				setState(418);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 16:
				_localctx = new Subst1Context(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(419);
				((Subst1Context)_localctx).tb = match(T__128);
				setState(420);
				((Subst1Context)_localctx).eqStep = match(NUM);
				setState(421);
				((Subst1Context)_localctx).step = match(NUM);
				}
				break;
			case 17:
				_localctx = new Subst2Context(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(422);
				((Subst2Context)_localctx).tb = match(T__129);
				setState(423);
				((Subst2Context)_localctx).eqStep = match(NUM);
				setState(424);
				((Subst2Context)_localctx).step = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(425);
				((AlgebraContext)_localctx).tb = match(T__130);
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(426);
					((AlgebraContext)_localctx).NUM = match(NUM);
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).NUM);
					}
					}
					setState(431);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(432);
				((ForallIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 132)) & ~0x3f) == 0 && ((1L << (_la - 132)) & ((1L << (T__131 - 132)) | (1L << (T__132 - 132)) | (1L << (T__133 - 132)))) != 0)) ) {
					((ForallIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(433);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 20:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(434);
				((ForallElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (T__134 - 135)) | (1L << (T__135 - 135)) | (1L << (T__136 - 135)))) != 0)) ) {
					((ForallElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(435);
				((ForallElimContext)_localctx).step = match(NUM);
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0) );
				}
				break;
			case 21:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(441);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(442);
				((ForallIntroContext)_localctx).tb = match(T__103);
				setState(443);
				match(ID);
				setState(444);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 22:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(445);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(446);
				((ForallElimContext)_localctx).tb = match(T__103);
				setState(447);
				match(ID);
				setState(448);
				((ForallElimContext)_localctx).step = match(NUM);
				setState(450); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(449);
					formula(0);
					}
					}
					setState(452); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0) );
				}
				break;
			case 23:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(454);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (T__137 - 138)) | (1L << (T__138 - 138)) | (1L << (T__139 - 138)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(455);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(457); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(456);
					formula(0);
					}
					}
					setState(459); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0) );
				}
				break;
			case 24:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(461);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & ((1L << (T__140 - 141)) | (1L << (T__141 - 141)) | (1L << (T__142 - 141)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(462);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(463);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 25:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(464);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(465);
				((ExistsIntroContext)_localctx).tb = match(T__107);
				setState(466);
				match(ID);
				setState(467);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(469); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(468);
					formula(0);
					}
					}
					setState(471); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0) );
				}
				break;
			case 26:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(473);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(474);
				((ExistsElimContext)_localctx).tb = match(T__107);
				setState(475);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(476);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(477);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 27:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(478);
				((InvariantContext)_localctx).tb = match(T__143);
				}
				break;
			case 28:
				_localctx = new FctContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(479);
				((FctContext)_localctx).tb = match(T__144);
				setState(480);
				match(ID);
				}
				break;
			case 29:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(481);
				((AutoContext)_localctx).tb = match(T__145);
				setState(485);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(482);
					((AutoContext)_localctx).NUM = match(NUM);
					((AutoContext)_localctx).steps.add(((AutoContext)_localctx).NUM);
					}
					}
					setState(487);
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
			setState(493);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(490);
				match(NL);
				}
				}
				setState(495);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(504);
			_la = _input.LA(1);
			if (_la==T__146) {
				{
				setState(496);
				impor();
				setState(498); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(497);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(500); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(502);
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
			setState(506);
			((ImporContext)_localctx).tb = match(T__146);
			setState(507);
			((ImporContext)_localctx).org = match(ID);
			setState(508);
			match(T__5);
			setState(509);
			((ImporContext)_localctx).sireum = match(ID);
			setState(510);
			match(T__5);
			setState(511);
			((ImporContext)_localctx).logika = match(ID);
			setState(512);
			match(T__5);
			setState(513);
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
			setState(515);
			match(T__3);
			setState(519);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(516);
				match(NL);
				}
				}
				setState(521);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(522);
			((FactsContext)_localctx).ftb = match(T__144);
			setState(526);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(523);
				match(NL);
				}
				}
				setState(528);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(529);
			factOrFun();
			setState(540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(531); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(530);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(533); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(536);
				_la = _input.LA(1);
				if (_la==T__148 || _la==ID) {
					{
					setState(535);
					factOrFun();
					}
				}

				}
				}
				setState(542);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(543);
			((FactsContext)_localctx).te = match(T__4);
			setState(547);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(544);
				match(NL);
				}
				}
				setState(549);
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
			setState(552);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(550);
				fact();
				}
				break;
			case T__148:
				enterOuterAlt(_localctx, 2);
				{
				setState(551);
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
			setState(554);
			match(ID);
			setState(555);
			match(T__5);
			setState(556);
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
		enterRule(_localctx, 28, RULE_fun);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			((FunContext)_localctx).tb = match(T__148);
			setState(559);
			match(ID);
			setState(561);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(560);
				match(NL);
				}
			}

			setState(563);
			match(T__15);
			setState(564);
			param();
			setState(569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(565);
				match(T__0);
				setState(566);
				param();
				}
				}
				setState(571);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(572);
			match(T__16);
			setState(573);
			match(T__6);
			setState(574);
			type();
			setState(584);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(578);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(575);
						match(NL);
						}
						}
						setState(580);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(581);
					funDef();
					}
					} 
				}
				setState(586);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
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
		enterRule(_localctx, 30, RULE_funDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			match(T__78);
			setState(588);
			((FunDefContext)_localctx).e = formula(0);
			setState(589);
			match(T__0);
			setState(593);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(590);
				match(NL);
				}
				}
				setState(595);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(596);
			match(T__149);
			setState(597);
			((FunDefContext)_localctx).c = formula(0);
			setState(598);
			match(T__15);
			setState(599);
			match(ID);
			setState(600);
			match(T__16);
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
		enterRule(_localctx, 32, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			match(ID);
			setState(603);
			match(T__6);
			setState(604);
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
		enterRule(_localctx, 34, RULE_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 147)) & ~0x3f) == 0 && ((1L << (_la - 147)) & ((1L << (T__146 - 147)) | (1L << (T__148 - 147)) | (1L << (T__149 - 147)) | (1L << (T__150 - 147)) | (1L << (T__151 - 147)) | (1L << (T__152 - 147)) | (1L << (T__154 - 147)) | (1L << (T__155 - 147)) | (1L << (T__157 - 147)) | (1L << (T__158 - 147)) | (1L << (T__159 - 147)) | (1L << (T__162 - 147)) | (1L << (T__163 - 147)) | (1L << (NUM - 147)) | (1L << (ID - 147)) | (1L << (REAL - 147)) | (1L << (INT - 147)) | (1L << (FLOAT - 147)))) != 0)) {
				{
				setState(606);
				stmt();
				}
			}

			setState(619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(610); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(609);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(612); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(615);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 147)) & ~0x3f) == 0 && ((1L << (_la - 147)) & ((1L << (T__146 - 147)) | (1L << (T__148 - 147)) | (1L << (T__149 - 147)) | (1L << (T__150 - 147)) | (1L << (T__151 - 147)) | (1L << (T__152 - 147)) | (1L << (T__154 - 147)) | (1L << (T__155 - 147)) | (1L << (T__157 - 147)) | (1L << (T__158 - 147)) | (1L << (T__159 - 147)) | (1L << (T__162 - 147)) | (1L << (T__163 - 147)) | (1L << (NUM - 147)) | (1L << (ID - 147)) | (1L << (REAL - 147)) | (1L << (INT - 147)) | (1L << (FLOAT - 147)))) != 0)) {
					{
					setState(614);
					stmt();
					}
				}

				}
				}
				setState(621);
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
		enterRule(_localctx, 36, RULE_stmt);
		int _la;
		try {
			setState(801);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(622);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__150 || _la==T__151) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(623);
				match(ID);
				setState(624);
				match(T__6);
				setState(625);
				type();
				setState(626);
				match(T__78);
				setState(628);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(627);
					match(NL);
					}
				}

				setState(630);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(632);
				match(ID);
				setState(633);
				match(T__78);
				setState(635);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(634);
					match(NL);
					}
				}

				setState(637);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssumeStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(638);
				match(T__7);
				setState(639);
				match(T__15);
				setState(640);
				exp(0);
				setState(641);
				match(T__16);
				}
				break;
			case 4:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(643);
				match(T__152);
				setState(644);
				match(T__15);
				setState(645);
				exp(0);
				setState(646);
				match(T__16);
				}
				break;
			case 5:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(648);
				match(T__149);
				setState(649);
				match(T__15);
				setState(650);
				exp(0);
				setState(651);
				match(T__16);
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
				match(T__3);
				setState(659);
				((IfStmtContext)_localctx).ts = stmts();
				setState(660);
				match(T__4);
				setState(672);
				_la = _input.LA(1);
				if (_la==T__153) {
					{
					setState(661);
					match(T__153);
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
					match(T__3);
					setState(669);
					((IfStmtContext)_localctx).fs = stmts();
					setState(670);
					match(T__4);
					}
				}

				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(674);
				match(T__154);
				setState(675);
				match(T__15);
				setState(676);
				exp(0);
				setState(677);
				match(T__16);
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
				match(T__3);
				setState(695);
				switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
				case 1:
					{
					setState(688);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(685);
						match(NL);
						}
						}
						setState(690);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(691);
					match(T__155);
					setState(692);
					loopInvariant();
					setState(693);
					match(T__156);
					}
					break;
				}
				setState(697);
				stmts();
				setState(698);
				match(T__4);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(700);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__157 || _la==T__158) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(701);
				match(T__15);
				setState(710);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (STRING - 163)) | (1L << (FLOAT - 163)))) != 0)) {
					{
					setState(702);
					stringOrExp();
					setState(707);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(703);
						match(T__0);
						setState(704);
						stringOrExp();
						}
						}
						setState(709);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(712);
				match(T__16);
				}
				break;
			case 8:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(713);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(714);
				match(T__15);
				setState(715);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(716);
				match(T__16);
				setState(717);
				match(T__78);
				setState(719);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(718);
					match(NL);
					}
				}

				setState(721);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 9:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(725);
				_la = _input.LA(1);
				if (_la==T__159) {
					{
					setState(723);
					match(T__159);
					setState(724);
					((MethodDeclStmtContext)_localctx).helper = match(ID);
					}
				}

				setState(727);
				match(T__148);
				setState(728);
				((MethodDeclStmtContext)_localctx).id = match(ID);
				setState(730);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(729);
					match(NL);
					}
				}

				setState(732);
				match(T__15);
				setState(741);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(733);
					param();
					setState(738);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(734);
						match(T__0);
						setState(735);
						param();
						}
						}
						setState(740);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(743);
				match(T__16);
				setState(744);
				match(T__6);
				setState(747);
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
					setState(745);
					type();
					}
					break;
				case T__160:
					{
					setState(746);
					match(T__160);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(749);
				match(T__78);
				setState(753);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(750);
					match(NL);
					}
					}
					setState(755);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(756);
				match(T__3);
				setState(773);
				switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
				case 1:
					{
					setState(760);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(757);
						match(NL);
						}
						}
						setState(762);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(763);
					match(T__155);
					setState(764);
					methodContract();
					setState(768);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(765);
						match(NL);
						}
						}
						setState(770);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(771);
					match(T__156);
					}
					break;
				}
				setState(775);
				stmts();
				setState(786);
				_la = _input.LA(1);
				if (_la==T__161) {
					{
					setState(776);
					((MethodDeclStmtContext)_localctx).rtb = match(T__161);
					setState(778);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (FLOAT - 163)))) != 0)) {
						{
						setState(777);
						exp(0);
						}
					}

					setState(783);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(780);
						match(NL);
						}
						}
						setState(785);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(788);
				match(T__4);
				}
				break;
			case 10:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(790);
				match(T__155);
				setState(795);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(791);
					proof();
					}
					break;
				case 2:
					{
					setState(792);
					sequent();
					}
					break;
				case 3:
					{
					setState(793);
					invariants();
					}
					break;
				case 4:
					{
					setState(794);
					facts();
					}
					break;
				}
				setState(797);
				match(T__156);
				}
				break;
			case 11:
				_localctx = new ImportStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(799);
				impor();
				}
				break;
			case 12:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(800);
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
		enterRule(_localctx, 38, RULE_stringOrExp);
		try {
			setState(805);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(803);
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
				setState(804);
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
		enterRule(_localctx, 40, RULE_primExp);
		int _la;
		try {
			setState(844);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				_localctx = new BooleanExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(807);
				((BooleanExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
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
				setState(808);
				match(NUM);
				}
				break;
			case 3:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(809);
				match(ID);
				}
				break;
			case 4:
				_localctx = new TypeMethodCallExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(810);
				((TypeMethodCallExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0)) ) {
					((TypeMethodCallExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(811);
				match(T__5);
				setState(812);
				match(ID);
				setState(813);
				match(T__15);
				setState(822);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (FLOAT - 163)))) != 0)) {
					{
					setState(814);
					exp(0);
					setState(819);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(815);
						match(T__0);
						setState(816);
						exp(0);
						}
						}
						setState(821);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(824);
				match(T__16);
				}
				break;
			case 5:
				_localctx = new TypeAccessExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(825);
				((TypeAccessExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0)) ) {
					((TypeAccessExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(826);
				match(T__5);
				setState(827);
				match(ID);
				}
				break;
			case 6:
				_localctx = new FloatLitExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(828);
				match(FLOAT);
				}
				break;
			case 7:
				_localctx = new IntLitExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(829);
				match(INT);
				}
				break;
			case 8:
				_localctx = new RLitExpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(830);
				match(REAL);
				}
				break;
			case 9:
				_localctx = new SeqExpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(831);
				((SeqExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0)) ) {
					((SeqExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(832);
				match(T__15);
				setState(841);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (FLOAT - 163)))) != 0)) {
					{
					setState(833);
					exp(0);
					setState(838);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(834);
						match(T__0);
						setState(835);
						exp(0);
						}
						}
						setState(840);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(843);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(883);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(847);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0)) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(848);
				exp(10);
				}
				break;
			case 2:
				{
				_localctx = new InvokeExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(849);
				((InvokeExpContext)_localctx).tb = match(ID);
				setState(850);
				((InvokeExpContext)_localctx).t = match(T__15);
				setState(859);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (FLOAT - 163)))) != 0)) {
					{
					setState(851);
					exp(0);
					setState(856);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(852);
						match(T__0);
						setState(853);
						exp(0);
						}
						}
						setState(858);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(861);
				match(T__16);
				}
				break;
			case 3:
				{
				_localctx = new PExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(862);
				primExp();
				setState(867);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(863);
						match(T__5);
						setState(864);
						match(ID);
						}
						} 
					}
					setState(869);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				}
				}
				break;
			case 4:
				{
				_localctx = new RandomIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(870);
				match(T__162);
				setState(871);
				match(T__15);
				setState(872);
				match(T__16);
				}
				break;
			case 5:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(873);
				match(T__163);
				setState(874);
				match(T__15);
				setState(876);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(875);
					match(STRING);
					}
				}

				setState(878);
				match(T__16);
				}
				break;
			case 6:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(879);
				match(T__15);
				setState(880);
				exp(0);
				setState(881);
				match(T__16);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(941);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(939);
					switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(885);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(886);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (T__62 - 63)) | (1L << (T__63 - 63)) | (1L << (T__64 - 63)))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(888);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(887);
							match(NL);
							}
						}

						setState(890);
						((BinaryExpContext)_localctx).r = exp(10);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(891);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(892);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__65 || _la==T__66) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(894);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(893);
							match(NL);
							}
						}

						setState(896);
						((BinaryExpContext)_localctx).r = exp(9);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(897);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(898);
						((BinaryExpContext)_localctx).op = match(T__67);
						setState(900);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(899);
							match(NL);
							}
						}

						setState(902);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(903);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(904);
						((BinaryExpContext)_localctx).op = match(T__68);
						setState(906);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(905);
							match(NL);
							}
						}

						setState(908);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(909);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(910);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__72 - 70)) | (1L << (T__73 - 70)) | (1L << (T__75 - 70)) | (1L << (T__76 - 70)) | (1L << (T__77 - 70)))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(912);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(911);
							match(NL);
							}
						}

						setState(914);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(915);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(916);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__79 || _la==T__80) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(918);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(917);
							match(NL);
							}
						}

						setState(920);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(921);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(922);
						((BinaryExpContext)_localctx).op = match(T__88);
						setState(924);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(923);
							match(NL);
							}
						}

						setState(926);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(927);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(928);
						((BinaryExpContext)_localctx).op = match(T__92);
						setState(930);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(929);
							match(NL);
							}
						}

						setState(932);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(933);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(934);
						((BinaryExpContext)_localctx).op = match(T__94);
						setState(936);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(935);
							match(NL);
							}
						}

						setState(938);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(943);
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
		enterRule(_localctx, 44, RULE_loopInvariant);
		int _la;
		try {
			int _alt;
			setState(997);
			switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(944);
				((LoopInvariantContext)_localctx).tb = match(T__3);
				setState(948);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(945);
					match(NL);
					}
					}
					setState(950);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(951);
				modifies();
				setState(952);
				((LoopInvariantContext)_localctx).te = match(T__4);
				setState(956);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(953);
					match(NL);
					}
					}
					setState(958);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(959);
				((LoopInvariantContext)_localctx).tb = match(T__3);
				setState(963);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(960);
					match(NL);
					}
					}
					setState(965);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(966);
				((LoopInvariantContext)_localctx).itb = match(T__143);
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
				formula(0);
				setState(984);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
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
						_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(980);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
						{
						setState(979);
						formula(0);
						}
					}

					}
					}
					setState(986);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(988);
				_la = _input.LA(1);
				if (_la==T__164) {
					{
					setState(987);
					modifies();
					}
				}

				setState(990);
				((LoopInvariantContext)_localctx).te = match(T__4);
				setState(994);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(991);
					match(NL);
					}
					}
					setState(996);
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
		enterRule(_localctx, 46, RULE_modifies);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(999);
			((ModifiesContext)_localctx).tb = match(T__164);
			setState(1000);
			match(ID);
			setState(1005);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(1001);
				match(T__0);
				setState(1002);
				match(ID);
				}
				}
				setState(1007);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1011);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1008);
					match(NL);
					}
					} 
				}
				setState(1013);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
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
		enterRule(_localctx, 48, RULE_methodContract);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1014);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(1018);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1015);
					match(NL);
					}
					} 
				}
				setState(1020);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			}
			setState(1042);
			_la = _input.LA(1);
			if (_la==T__165 || _la==T__166) {
				{
				setState(1021);
				_la = _input.LA(1);
				if ( !(_la==T__165 || _la==T__166) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1025);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1022);
					match(NL);
					}
					}
					setState(1027);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1028);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(1039);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1030); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1029);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1032); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(1035);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
							{
							setState(1034);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(1041);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
				}
				}
			}

			setState(1047);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1044);
					match(NL);
					}
					} 
				}
				setState(1049);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
			}
			setState(1051);
			_la = _input.LA(1);
			if (_la==T__164) {
				{
				setState(1050);
				modifies();
				}
			}

			setState(1074);
			_la = _input.LA(1);
			if (_la==T__167 || _la==T__168) {
				{
				setState(1053);
				_la = _input.LA(1);
				if ( !(_la==T__167 || _la==T__168) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1057);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1054);
					match(NL);
					}
					}
					setState(1059);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1060);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(1071);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,149,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1062); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1061);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1064); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(1067);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
							{
							setState(1066);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(1073);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,149,_ctx);
				}
				}
			}

			setState(1079);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1076);
				match(NL);
				}
				}
				setState(1081);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1082);
			((MethodContractContext)_localctx).te = match(T__4);
			setState(1086);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,152,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1083);
					match(NL);
					}
					} 
				}
				setState(1088);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,152,_ctx);
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
		enterRule(_localctx, 50, RULE_invariants);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1089);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(1093);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1090);
				match(NL);
				}
				}
				setState(1095);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1096);
			match(T__143);
			setState(1100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1097);
				match(NL);
				}
				}
				setState(1102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1103);
			formula(0);
			setState(1114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1105); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1104);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1107); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,155,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1110);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
					{
					setState(1109);
					formula(0);
					}
				}

				}
				}
				setState(1116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1117);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(1121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1118);
				match(NL);
				}
				}
				setState(1123);
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
		case 21:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u00b8\u0467\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\7\29\n\2\f\2\16\2<\13\2\3\2\5\2?\n\2\3\2"+
		"\7\2B\n\2\f\2\16\2E\13\2\3\2\3\2\3\2\3\2\3\2\5\2L\n\2\3\3\3\3\3\3\7\3"+
		"Q\n\3\f\3\16\3T\13\3\5\3V\n\3\3\3\3\3\3\3\3\3\7\3\\\n\3\f\3\16\3_\13\3"+
		"\3\3\7\3b\n\3\f\3\16\3e\13\3\3\3\3\3\6\3i\n\3\r\3\16\3j\5\3m\n\3\3\4\3"+
		"\4\5\4q\n\4\3\4\6\4t\n\4\r\4\16\4u\3\4\5\4y\n\4\7\4{\n\4\f\4\16\4~\13"+
		"\4\3\4\3\4\7\4\u0082\n\4\f\4\16\4\u0085\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\7\5\u008f\n\5\f\5\16\5\u0092\13\5\3\5\3\5\7\5\u0096\n\5\f\5\16"+
		"\5\u0099\13\5\3\5\3\5\3\5\3\5\3\5\5\5\u00a0\n\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\5\5\u00a8\n\5\3\5\3\5\3\5\5\5\u00ad\n\5\3\5\6\5\u00b0\n\5\r\5\16\5"+
		"\u00b1\3\5\5\5\u00b5\n\5\7\5\u00b7\n\5\f\5\16\5\u00ba\13\5\3\5\5\5\u00bd"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00c9\n\6\f\6\16\6\u00cc"+
		"\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00d6\n\6\f\6\16\6\u00d9\13"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00ea"+
		"\n\6\f\6\16\6\u00ed\13\6\5\6\u00ef\n\6\3\6\5\6\u00f2\n\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\7\7\u00fc\n\7\f\7\16\7\u00ff\13\7\3\7\5\7\u0102\n\7"+
		"\3\7\3\7\3\7\5\7\u0107\n\7\3\7\3\7\3\7\3\7\5\7\u010d\n\7\3\7\3\7\3\7\3"+
		"\7\5\7\u0113\n\7\3\7\3\7\3\7\3\7\5\7\u0119\n\7\3\7\3\7\3\7\3\7\5\7\u011f"+
		"\n\7\3\7\3\7\3\7\3\7\5\7\u0125\n\7\3\7\3\7\3\7\3\7\5\7\u012b\n\7\3\7\3"+
		"\7\3\7\3\7\5\7\u0131\n\7\3\7\3\7\3\7\3\7\5\7\u0137\n\7\3\7\3\7\3\7\3\7"+
		"\5\7\u013d\n\7\3\7\7\7\u0140\n\7\f\7\16\7\u0143\13\7\3\b\3\b\3\b\3\b\7"+
		"\b\u0149\n\b\f\b\16\b\u014c\13\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0154\n\b"+
		"\3\b\3\b\5\b\u0158\n\b\3\b\3\b\3\b\5\b\u015d\n\b\3\b\5\b\u0160\n\b\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u016a\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u0171"+
		"\n\n\3\n\3\n\3\n\3\n\5\n\u0177\n\n\3\n\3\n\3\n\3\n\5\n\u017d\n\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u01a1"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u01ae\n\n\f\n\16"+
		"\n\u01b1\13\n\3\n\3\n\3\n\3\n\3\n\6\n\u01b8\n\n\r\n\16\n\u01b9\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u01c5\n\n\r\n\16\n\u01c6\3\n\3\n\3\n"+
		"\6\n\u01cc\n\n\r\n\16\n\u01cd\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u01d8"+
		"\n\n\r\n\16\n\u01d9\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u01e6"+
		"\n\n\f\n\16\n\u01e9\13\n\5\n\u01eb\n\n\3\13\7\13\u01ee\n\13\f\13\16\13"+
		"\u01f1\13\13\3\13\3\13\6\13\u01f5\n\13\r\13\16\13\u01f6\3\13\3\13\5\13"+
		"\u01fb\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\7\r\u0208\n\r"+
		"\f\r\16\r\u020b\13\r\3\r\3\r\7\r\u020f\n\r\f\r\16\r\u0212\13\r\3\r\3\r"+
		"\6\r\u0216\n\r\r\r\16\r\u0217\3\r\5\r\u021b\n\r\7\r\u021d\n\r\f\r\16\r"+
		"\u0220\13\r\3\r\3\r\7\r\u0224\n\r\f\r\16\r\u0227\13\r\3\16\3\16\5\16\u022b"+
		"\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u0234\n\20\3\20\3\20\3\20"+
		"\3\20\7\20\u023a\n\20\f\20\16\20\u023d\13\20\3\20\3\20\3\20\3\20\7\20"+
		"\u0243\n\20\f\20\16\20\u0246\13\20\3\20\7\20\u0249\n\20\f\20\16\20\u024c"+
		"\13\20\3\21\3\21\3\21\3\21\7\21\u0252\n\21\f\21\16\21\u0255\13\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\5\23\u0262\n\23\3\23"+
		"\6\23\u0265\n\23\r\23\16\23\u0266\3\23\5\23\u026a\n\23\7\23\u026c\n\23"+
		"\f\23\16\23\u026f\13\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0277\n\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u027e\n\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0290\n\24\f\24"+
		"\16\24\u0293\13\24\3\24\3\24\3\24\3\24\3\24\7\24\u029a\n\24\f\24\16\24"+
		"\u029d\13\24\3\24\3\24\3\24\3\24\5\24\u02a3\n\24\3\24\3\24\3\24\3\24\3"+
		"\24\7\24\u02aa\n\24\f\24\16\24\u02ad\13\24\3\24\3\24\7\24\u02b1\n\24\f"+
		"\24\16\24\u02b4\13\24\3\24\3\24\3\24\3\24\5\24\u02ba\n\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\7\24\u02c4\n\24\f\24\16\24\u02c7\13\24\5"+
		"\24\u02c9\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u02d2\n\24\3\24"+
		"\3\24\3\24\3\24\5\24\u02d8\n\24\3\24\3\24\3\24\5\24\u02dd\n\24\3\24\3"+
		"\24\3\24\3\24\7\24\u02e3\n\24\f\24\16\24\u02e6\13\24\5\24\u02e8\n\24\3"+
		"\24\3\24\3\24\3\24\5\24\u02ee\n\24\3\24\3\24\7\24\u02f2\n\24\f\24\16\24"+
		"\u02f5\13\24\3\24\3\24\7\24\u02f9\n\24\f\24\16\24\u02fc\13\24\3\24\3\24"+
		"\3\24\7\24\u0301\n\24\f\24\16\24\u0304\13\24\3\24\3\24\5\24\u0308\n\24"+
		"\3\24\3\24\3\24\5\24\u030d\n\24\3\24\7\24\u0310\n\24\f\24\16\24\u0313"+
		"\13\24\5\24\u0315\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u031e\n"+
		"\24\3\24\3\24\3\24\3\24\5\24\u0324\n\24\3\25\3\25\5\25\u0328\n\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0334\n\26\f\26\16"+
		"\26\u0337\13\26\5\26\u0339\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\7\26\u0347\n\26\f\26\16\26\u034a\13\26\5\26\u034c"+
		"\n\26\3\26\5\26\u034f\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27"+
		"\u0359\n\27\f\27\16\27\u035c\13\27\5\27\u035e\n\27\3\27\3\27\3\27\3\27"+
		"\7\27\u0364\n\27\f\27\16\27\u0367\13\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u036f\n\27\3\27\3\27\3\27\3\27\3\27\5\27\u0376\n\27\3\27\3\27\3"+
		"\27\5\27\u037b\n\27\3\27\3\27\3\27\3\27\5\27\u0381\n\27\3\27\3\27\3\27"+
		"\3\27\5\27\u0387\n\27\3\27\3\27\3\27\3\27\5\27\u038d\n\27\3\27\3\27\3"+
		"\27\3\27\5\27\u0393\n\27\3\27\3\27\3\27\3\27\5\27\u0399\n\27\3\27\3\27"+
		"\3\27\3\27\5\27\u039f\n\27\3\27\3\27\3\27\3\27\5\27\u03a5\n\27\3\27\3"+
		"\27\3\27\3\27\5\27\u03ab\n\27\3\27\7\27\u03ae\n\27\f\27\16\27\u03b1\13"+
		"\27\3\30\3\30\7\30\u03b5\n\30\f\30\16\30\u03b8\13\30\3\30\3\30\3\30\7"+
		"\30\u03bd\n\30\f\30\16\30\u03c0\13\30\3\30\3\30\7\30\u03c4\n\30\f\30\16"+
		"\30\u03c7\13\30\3\30\3\30\7\30\u03cb\n\30\f\30\16\30\u03ce\13\30\3\30"+
		"\3\30\6\30\u03d2\n\30\r\30\16\30\u03d3\3\30\5\30\u03d7\n\30\7\30\u03d9"+
		"\n\30\f\30\16\30\u03dc\13\30\3\30\5\30\u03df\n\30\3\30\3\30\7\30\u03e3"+
		"\n\30\f\30\16\30\u03e6\13\30\5\30\u03e8\n\30\3\31\3\31\3\31\3\31\7\31"+
		"\u03ee\n\31\f\31\16\31\u03f1\13\31\3\31\7\31\u03f4\n\31\f\31\16\31\u03f7"+
		"\13\31\3\32\3\32\7\32\u03fb\n\32\f\32\16\32\u03fe\13\32\3\32\3\32\7\32"+
		"\u0402\n\32\f\32\16\32\u0405\13\32\3\32\3\32\6\32\u0409\n\32\r\32\16\32"+
		"\u040a\3\32\5\32\u040e\n\32\7\32\u0410\n\32\f\32\16\32\u0413\13\32\5\32"+
		"\u0415\n\32\3\32\7\32\u0418\n\32\f\32\16\32\u041b\13\32\3\32\5\32\u041e"+
		"\n\32\3\32\3\32\7\32\u0422\n\32\f\32\16\32\u0425\13\32\3\32\3\32\6\32"+
		"\u0429\n\32\r\32\16\32\u042a\3\32\5\32\u042e\n\32\7\32\u0430\n\32\f\32"+
		"\16\32\u0433\13\32\5\32\u0435\n\32\3\32\7\32\u0438\n\32\f\32\16\32\u043b"+
		"\13\32\3\32\3\32\7\32\u043f\n\32\f\32\16\32\u0442\13\32\3\33\3\33\7\33"+
		"\u0446\n\33\f\33\16\33\u0449\13\33\3\33\3\33\7\33\u044d\n\33\f\33\16\33"+
		"\u0450\13\33\3\33\3\33\6\33\u0454\n\33\r\33\16\33\u0455\3\33\5\33\u0459"+
		"\n\33\7\33\u045b\n\33\f\33\16\33\u045e\13\33\3\33\3\33\7\33\u0462\n\33"+
		"\f\33\16\33\u0465\13\33\3\33\2\4\f,\34\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\2\'\3\2\4\5\3\2\13\21\3\2\25*\3\2+@\3\2UY\3\2"+
		"AC\3\2DE\3\2HP\3\2QT\3\2Z]\3\2^_\3\2`c\3\2df\3\2gn\3\2\25@\3\2[]\3\2r"+
		"s\3\2tw\4\2aacc\3\2xy\3\2ef\3\2|}\3\2~\177\3\2WY\3\2\u0080\u0081\3\2\20"+
		"\21\3\2\u0086\u0088\3\2\u0089\u008b\3\2\u008c\u008e\3\2\u008f\u0091\3"+
		"\2\u0099\u009a\3\2\u00a0\u00a1\4\2EEWX\5\2HIKLNP\3\2RS\3\2\u00a8\u00a9"+
		"\3\2\u00aa\u00ab\u053a\2K\3\2\2\2\4l\3\2\2\2\6n\3\2\2\2\b\u00bc\3\2\2"+
		"\2\n\u00f1\3\2\2\2\f\u0101\3\2\2\2\16\u0144\3\2\2\2\20\u0163\3\2\2\2\22"+
		"\u01ea\3\2\2\2\24\u01ef\3\2\2\2\26\u01fc\3\2\2\2\30\u0205\3\2\2\2\32\u022a"+
		"\3\2\2\2\34\u022c\3\2\2\2\36\u0230\3\2\2\2 \u024d\3\2\2\2\"\u025c\3\2"+
		"\2\2$\u0261\3\2\2\2&\u0323\3\2\2\2(\u0327\3\2\2\2*\u034e\3\2\2\2,\u0375"+
		"\3\2\2\2.\u03e7\3\2\2\2\60\u03e9\3\2\2\2\62\u03f8\3\2\2\2\64\u0443\3\2"+
		"\2\2\66:\5\4\3\2\679\7\u00b2\2\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2"+
		"\2\2;>\3\2\2\2<:\3\2\2\2=?\5\6\4\2>=\3\2\2\2>?\3\2\2\2?C\3\2\2\2@B\7\u00b2"+
		"\2\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FG\7\2"+
		"\2\3GL\3\2\2\2HI\5\24\13\2IJ\7\2\2\3JL\3\2\2\2K\66\3\2\2\2KH\3\2\2\2L"+
		"\3\3\2\2\2MR\5\f\7\2NO\7\3\2\2OQ\5\f\7\2PN\3\2\2\2QT\3\2\2\2RP\3\2\2\2"+
		"RS\3\2\2\2SV\3\2\2\2TR\3\2\2\2UM\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\t\2\2\2"+
		"X]\5\f\7\2YZ\7\3\2\2Z\\\5\f\7\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2"+
		"\2^m\3\2\2\2_]\3\2\2\2`b\5\f\7\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2"+
		"\2df\3\2\2\2ec\3\2\2\2fh\7\u00ac\2\2gi\5\f\7\2hg\3\2\2\2ij\3\2\2\2jh\3"+
		"\2\2\2jk\3\2\2\2km\3\2\2\2lU\3\2\2\2lc\3\2\2\2m\5\3\2\2\2np\7\6\2\2oq"+
		"\5\b\5\2po\3\2\2\2pq\3\2\2\2q|\3\2\2\2rt\7\u00b2\2\2sr\3\2\2\2tu\3\2\2"+
		"\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wy\5\b\5\2xw\3\2\2\2xy\3\2\2\2y{\3\2\2"+
		"\2zs\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177"+
		"\u0083\7\7\2\2\u0080\u0082\7\u00b2\2\2\u0081\u0080\3\2\2\2\u0082\u0085"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\7\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u0087\7\u00ad\2\2\u0087\u0088\7\b\2\2\u0088\u0089"+
		"\5\f\7\2\u0089\u008a\5\22\n\2\u008a\u00bd\3\2\2\2\u008b\u008c\7\u00ad"+
		"\2\2\u008c\u0090\7\b\2\2\u008d\u008f\7\u00b2\2\2\u008e\u008d\3\2\2\2\u008f"+
		"\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0093\u0097\7\6\2\2\u0094\u0096\7\u00b2\2\2\u0095"+
		"\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7\u00ad\2\2\u009b"+
		"\u00ac\7\b\2\2\u009c\u009f\7\u00ae\2\2\u009d\u009e\7\t\2\2\u009e\u00a0"+
		"\5\20\t\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00ad\3\2\2\2"+
		"\u00a1\u00a2\5\f\7\2\u00a2\u00a3\7\n\2\2\u00a3\u00ad\3\2\2\2\u00a4\u00a7"+
		"\7\u00ae\2\2\u00a5\u00a6\7\t\2\2\u00a6\u00a8\5\20\t\2\u00a7\u00a5\3\2"+
		"\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\5\f\7\2\u00aa"+
		"\u00ab\7\n\2\2\u00ab\u00ad\3\2\2\2\u00ac\u009c\3\2\2\2\u00ac\u00a1\3\2"+
		"\2\2\u00ac\u00a4\3\2\2\2\u00ad\u00b8\3\2\2\2\u00ae\u00b0\7\u00b2\2\2\u00af"+
		"\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b5\5\b\5\2\u00b4\u00b3\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00af\3\2\2\2\u00b7\u00ba\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba"+
		"\u00b8\3\2\2\2\u00bb\u00bd\7\7\2\2\u00bc\u0086\3\2\2\2\u00bc\u008b\3\2"+
		"\2\2\u00bd\t\3\2\2\2\u00be\u00f2\t\3\2\2\u00bf\u00c0\7\22\2\2\u00c0\u00c1"+
		"\5\f\7\2\u00c1\u00c2\7\23\2\2\u00c2\u00f2\3\2\2\2\u00c3\u00c4\7\24\2\2"+
		"\u00c4\u00c5\7\22\2\2\u00c5\u00ca\5\f\7\2\u00c6\u00c7\7\3\2\2\u00c7\u00c9"+
		"\5\f\7\2\u00c8\u00c6\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\7\23"+
		"\2\2\u00ce\u00f2\3\2\2\2\u00cf\u00f2\7\24\2\2\u00d0\u00d1\7\u00ae\2\2"+
		"\u00d1\u00d2\7\22\2\2\u00d2\u00d7\5\f\7\2\u00d3\u00d4\7\3\2\2\u00d4\u00d6"+
		"\5\f\7\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\7\23"+
		"\2\2\u00db\u00f2\3\2\2\2\u00dc\u00f2\7\u00ae\2\2\u00dd\u00f2\7\u00ad\2"+
		"\2\u00de\u00f2\7\u00b0\2\2\u00df\u00f2\7\u00af\2\2\u00e0\u00f2\7\u00b7"+
		"\2\2\u00e1\u00e2\t\4\2\2\u00e2\u00e3\7\b\2\2\u00e3\u00f2\7\u00ae\2\2\u00e4"+
		"\u00e5\t\5\2\2\u00e5\u00ee\7\22\2\2\u00e6\u00eb\5,\27\2\u00e7\u00e8\7"+
		"\3\2\2\u00e8\u00ea\5,\27\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ee\u00e6\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00f2\7\23\2\2\u00f1\u00be\3\2\2\2\u00f1\u00bf\3\2\2\2\u00f1\u00c3\3"+
		"\2\2\2\u00f1\u00cf\3\2\2\2\u00f1\u00d0\3\2\2\2\u00f1\u00dc\3\2\2\2\u00f1"+
		"\u00dd\3\2\2\2\u00f1\u00de\3\2\2\2\u00f1\u00df\3\2\2\2\u00f1\u00e0\3\2"+
		"\2\2\u00f1\u00e1\3\2\2\2\u00f1\u00e4\3\2\2\2\u00f2\13\3\2\2\2\u00f3\u00f4"+
		"\b\7\1\2\u00f4\u00f5\7E\2\2\u00f5\u0102\5\f\7\t\u00f6\u00f7\t\6\2\2\u00f7"+
		"\u0102\5\f\7\b\u00f8\u00fd\5\n\6\2\u00f9\u00fa\7\b\2\2\u00fa\u00fc\7\u00ae"+
		"\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u0102\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0102\5\16"+
		"\b\2\u0101\u00f3\3\2\2\2\u0101\u00f6\3\2\2\2\u0101\u00f8\3\2\2\2\u0101"+
		"\u0100\3\2\2\2\u0102\u0141\3\2\2\2\u0103\u0104\f\17\2\2\u0104\u0106\t"+
		"\7\2\2\u0105\u0107\7\u00b2\2\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2"+
		"\u0107\u0108\3\2\2\2\u0108\u0140\5\f\7\20\u0109\u010a\f\16\2\2\u010a\u010c"+
		"\t\b\2\2\u010b\u010d\7\u00b2\2\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2"+
		"\2\u010d\u010e\3\2\2\2\u010e\u0140\5\f\7\17\u010f\u0110\f\r\2\2\u0110"+
		"\u0112\7F\2\2\u0111\u0113\7\u00b2\2\2\u0112\u0111\3\2\2\2\u0112\u0113"+
		"\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0140\5\f\7\r\u0115\u0116\f\f\2\2\u0116"+
		"\u0118\7G\2\2\u0117\u0119\7\u00b2\2\2\u0118\u0117\3\2\2\2\u0118\u0119"+
		"\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u0140\5\f\7\r\u011b\u011c\f\13\2\2"+
		"\u011c\u011e\t\t\2\2\u011d\u011f\7\u00b2\2\2\u011e\u011d\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0140\5\f\7\f\u0121\u0122\f\n"+
		"\2\2\u0122\u0124\t\n\2\2\u0123\u0125\7\u00b2\2\2\u0124\u0123\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0140\5\f\7\13\u0127\u0128\f"+
		"\7\2\2\u0128\u012a\t\13\2\2\u0129\u012b\7\u00b2\2\2\u012a\u0129\3\2\2"+
		"\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u0140\5\f\7\b\u012d\u012e"+
		"\f\6\2\2\u012e\u0130\t\f\2\2\u012f\u0131\7\u00b2\2\2\u0130\u012f\3\2\2"+
		"\2\u0130\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0140\5\f\7\7\u0133\u0134"+
		"\f\5\2\2\u0134\u0136\t\r\2\2\u0135\u0137\7\u00b2\2\2\u0136\u0135\3\2\2"+
		"\2\u0136\u0137\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0140\5\f\7\6\u0139\u013a"+
		"\f\4\2\2\u013a\u013c\t\16\2\2\u013b\u013d\7\u00b2\2\2\u013c\u013b\3\2"+
		"\2\2\u013c\u013d\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0140\5\f\7\4\u013f"+
		"\u0103\3\2\2\2\u013f\u0109\3\2\2\2\u013f\u010f\3\2\2\2\u013f\u0115\3\2"+
		"\2\2\u013f\u011b\3\2\2\2\u013f\u0121\3\2\2\2\u013f\u0127\3\2\2\2\u013f"+
		"\u012d\3\2\2\2\u013f\u0133\3\2\2\2\u013f\u0139\3\2\2\2\u0140\u0143\3\2"+
		"\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\r\3\2\2\2\u0143\u0141"+
		"\3\2\2\2\u0144\u0145\t\17\2\2\u0145\u014a\7\u00ae\2\2\u0146\u0147\7\3"+
		"\2\2\u0147\u0149\7\u00ae\2\2\u0148\u0146\3\2\2\2\u0149\u014c\3\2\2\2\u014a"+
		"\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u015c\3\2\2\2\u014c\u014a\3\2"+
		"\2\2\u014d\u014e\7\t\2\2\u014e\u015d\5\20\t\2\u014f\u0150\7\t\2\2\u0150"+
		"\u0151\7\22\2\2\u0151\u0153\5,\27\2\u0152\u0154\7H\2\2\u0153\u0152\3\2"+
		"\2\2\u0153\u0154\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0157\7o\2\2\u0156"+
		"\u0158\7H\2\2\u0157\u0156\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\3\2"+
		"\2\2\u0159\u015a\5,\27\2\u015a\u015b\7\23\2\2\u015b\u015d\3\2\2\2\u015c"+
		"\u014d\3\2\2\2\u015c\u014f\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015f\3\2"+
		"\2\2\u015e\u0160\7\u00b2\2\2\u015f\u015e\3\2\2\2\u015f\u0160\3\2\2\2\u0160"+
		"\u0161\3\2\2\2\u0161\u0162\5\f\7\2\u0162\17\3\2\2\2\u0163\u0164\t\20\2"+
		"\2\u0164\21\3\2\2\2\u0165\u01eb\7p\2\2\u0166\u016a\7q\2\2\u0167\u0168"+
		"\t\21\2\2\u0168\u016a\7\u00ae\2\2\u0169\u0166\3\2\2\2\u0169\u0167\3\2"+
		"\2\2\u016a\u016b\3\2\2\2\u016b\u016c\7\u00ad\2\2\u016c\u01eb\7\u00ad\2"+
		"\2\u016d\u0171\t\22\2\2\u016e\u016f\t\21\2\2\u016f\u0171\7\u00ae\2\2\u0170"+
		"\u016d\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u01eb\7\u00ad"+
		"\2\2\u0173\u0177\t\23\2\2\u0174\u0175\t\24\2\2\u0175\u0177\7\u00ae\2\2"+
		"\u0176\u0173\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u01eb"+
		"\7\u00ad\2\2\u0179\u017d\t\25\2\2\u017a\u017b\t\24\2\2\u017b\u017d\7\u00ae"+
		"\2\2\u017c\u0179\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"\u017f\7\u00ad\2\2\u017f\u0180\7\u00ad\2\2\u0180\u01eb\7\u00ad\2\2\u0181"+
		"\u0182\7z\2\2\u0182\u01eb\7\u00ad\2\2\u0183\u0184\7{\2\2\u0184\u0185\7"+
		"\u00ad\2\2\u0185\u01eb\7\u00ad\2\2\u0186\u0187\6\n\f\2\u0187\u0188\t\26"+
		"\2\2\u0188\u0189\7\u00ae\2\2\u0189\u01eb\7\u00ad\2\2\u018a\u018b\6\n\r"+
		"\2\u018b\u018c\t\26\2\2\u018c\u018d\7\u00ae\2\2\u018d\u018e\7\u00ad\2"+
		"\2\u018e\u01eb\7\u00ad\2\2\u018f\u0190\t\27\2\2\u0190\u01eb\7\u00ad\2"+
		"\2\u0191\u0192\t\30\2\2\u0192\u0193\7\u00ad\2\2\u0193\u01eb\7\u00ad\2"+
		"\2\u0194\u0195\6\n\16\2\u0195\u0196\t\31\2\2\u0196\u0197\7\u00ae\2\2\u0197"+
		"\u01eb\7\u00ad\2\2\u0198\u0199\6\n\17\2\u0199\u019a\t\31\2\2\u019a\u019b"+
		"\7\u00ae\2\2\u019b\u019c\7\u00ad\2\2\u019c\u01eb\7\u00ad\2\2\u019d\u01a1"+
		"\t\32\2\2\u019e\u019f\t\33\2\2\u019f\u01a1\7\u00ae\2\2\u01a0\u019d\3\2"+
		"\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01eb\7\u00ad\2\2\u01a3"+
		"\u01a4\7\u0082\2\2\u01a4\u01eb\7\u00ad\2\2\u01a5\u01a6\7\u0083\2\2\u01a6"+
		"\u01a7\7\u00ad\2\2\u01a7\u01eb\7\u00ad\2\2\u01a8\u01a9\7\u0084\2\2\u01a9"+
		"\u01aa\7\u00ad\2\2\u01aa\u01eb\7\u00ad\2\2\u01ab\u01af\7\u0085\2\2\u01ac"+
		"\u01ae\7\u00ad\2\2\u01ad\u01ac\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af\u01ad"+
		"\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01eb\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2"+
		"\u01b3\t\34\2\2\u01b3\u01eb\7\u00ad\2\2\u01b4\u01b5\t\35\2\2\u01b5\u01b7"+
		"\7\u00ad\2\2\u01b6\u01b8\5\f\7\2\u01b7\u01b6\3\2\2\2\u01b8\u01b9\3\2\2"+
		"\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01eb\3\2\2\2\u01bb\u01bc"+
		"\6\n\20\2\u01bc\u01bd\7j\2\2\u01bd\u01be\7\u00ae\2\2\u01be\u01eb\7\u00ad"+
		"\2\2\u01bf\u01c0\6\n\21\2\u01c0\u01c1\7j\2\2\u01c1\u01c2\7\u00ae\2\2\u01c2"+
		"\u01c4\7\u00ad\2\2\u01c3\u01c5\5\f\7\2\u01c4\u01c3\3\2\2\2\u01c5\u01c6"+
		"\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01eb\3\2\2\2\u01c8"+
		"\u01c9\t\36\2\2\u01c9\u01cb\7\u00ad\2\2\u01ca\u01cc\5\f\7\2\u01cb\u01ca"+
		"\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce"+
		"\u01eb\3\2\2\2\u01cf\u01d0\t\37\2\2\u01d0\u01d1\7\u00ad\2\2\u01d1\u01eb"+
		"\7\u00ad\2\2\u01d2\u01d3\6\n\22\2\u01d3\u01d4\7n\2\2\u01d4\u01d5\7\u00ae"+
		"\2\2\u01d5\u01d7\7\u00ad\2\2\u01d6\u01d8\5\f\7\2\u01d7\u01d6\3\2\2\2\u01d8"+
		"\u01d9\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01eb\3\2"+
		"\2\2\u01db\u01dc\6\n\23\2\u01dc\u01dd\7n\2\2\u01dd\u01de\7\u00ae\2\2\u01de"+
		"\u01df\7\u00ad\2\2\u01df\u01eb\7\u00ad\2\2\u01e0\u01eb\7\u0092\2\2\u01e1"+
		"\u01e2\7\u0093\2\2\u01e2\u01eb\7\u00ae\2\2\u01e3\u01e7\7\u0094\2\2\u01e4"+
		"\u01e6\7\u00ad\2\2\u01e5\u01e4\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7\u01e5"+
		"\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01ea"+
		"\u0165\3\2\2\2\u01ea\u0169\3\2\2\2\u01ea\u0170\3\2\2\2\u01ea\u0176\3\2"+
		"\2\2\u01ea\u017c\3\2\2\2\u01ea\u0181\3\2\2\2\u01ea\u0183\3\2\2\2\u01ea"+
		"\u0186\3\2\2\2\u01ea\u018a\3\2\2\2\u01ea\u018f\3\2\2\2\u01ea\u0191\3\2"+
		"\2\2\u01ea\u0194\3\2\2\2\u01ea\u0198\3\2\2\2\u01ea\u01a0\3\2\2\2\u01ea"+
		"\u01a3\3\2\2\2\u01ea\u01a5\3\2\2\2\u01ea\u01a8\3\2\2\2\u01ea\u01ab\3\2"+
		"\2\2\u01ea\u01b2\3\2\2\2\u01ea\u01b4\3\2\2\2\u01ea\u01bb\3\2\2\2\u01ea"+
		"\u01bf\3\2\2\2\u01ea\u01c8\3\2\2\2\u01ea\u01cf\3\2\2\2\u01ea\u01d2\3\2"+
		"\2\2\u01ea\u01db\3\2\2\2\u01ea\u01e0\3\2\2\2\u01ea\u01e1\3\2\2\2\u01ea"+
		"\u01e3\3\2\2\2\u01eb\23\3\2\2\2\u01ec\u01ee\7\u00b2\2\2\u01ed\u01ec\3"+
		"\2\2\2\u01ee\u01f1\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0"+
		"\u01fa\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f2\u01f4\5\26\f\2\u01f3\u01f5\7"+
		"\u00b2\2\2\u01f4\u01f3\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f4\3\2\2\2"+
		"\u01f6\u01f7\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\5$\23\2\u01f9\u01fb"+
		"\3\2\2\2\u01fa\u01f2\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\25\3\2\2\2\u01fc"+
		"\u01fd\7\u0095\2\2\u01fd\u01fe\7\u00ae\2\2\u01fe\u01ff\7\b\2\2\u01ff\u0200"+
		"\7\u00ae\2\2\u0200\u0201\7\b\2\2\u0201\u0202\7\u00ae\2\2\u0202\u0203\7"+
		"\b\2\2\u0203\u0204\7\u0096\2\2\u0204\27\3\2\2\2\u0205\u0209\7\6\2\2\u0206"+
		"\u0208\7\u00b2\2\2\u0207\u0206\3\2\2\2\u0208\u020b\3\2\2\2\u0209\u0207"+
		"\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020c\3\2\2\2\u020b\u0209\3\2\2\2\u020c"+
		"\u0210\7\u0093\2\2\u020d\u020f\7\u00b2\2\2\u020e\u020d\3\2\2\2\u020f\u0212"+
		"\3\2\2\2\u0210\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0213\3\2\2\2\u0212"+
		"\u0210\3\2\2\2\u0213\u021e\5\32\16\2\u0214\u0216\7\u00b2\2\2\u0215\u0214"+
		"\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0215\3\2\2\2\u0217\u0218\3\2\2\2\u0218"+
		"\u021a\3\2\2\2\u0219\u021b\5\32\16\2\u021a\u0219\3\2\2\2\u021a\u021b\3"+
		"\2\2\2\u021b\u021d\3\2\2\2\u021c\u0215\3\2\2\2\u021d\u0220\3\2\2\2\u021e"+
		"\u021c\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0221\3\2\2\2\u0220\u021e\3\2"+
		"\2\2\u0221\u0225\7\7\2\2\u0222\u0224\7\u00b2\2\2\u0223\u0222\3\2\2\2\u0224"+
		"\u0227\3\2\2\2\u0225\u0223\3\2\2\2\u0225\u0226\3\2\2\2\u0226\31\3\2\2"+
		"\2\u0227\u0225\3\2\2\2\u0228\u022b\5\34\17\2\u0229\u022b\5\36\20\2\u022a"+
		"\u0228\3\2\2\2\u022a\u0229\3\2\2\2\u022b\33\3\2\2\2\u022c\u022d\7\u00ae"+
		"\2\2\u022d\u022e\7\b\2\2\u022e\u022f\5\f\7\2\u022f\35\3\2\2\2\u0230\u0231"+
		"\7\u0097\2\2\u0231\u0233\7\u00ae\2\2\u0232\u0234\7\u00b2\2\2\u0233\u0232"+
		"\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0236\7\22\2\2"+
		"\u0236\u023b\5\"\22\2\u0237\u0238\7\3\2\2\u0238\u023a\5\"\22\2\u0239\u0237"+
		"\3\2\2\2\u023a\u023d\3\2\2\2\u023b\u0239\3\2\2\2\u023b\u023c\3\2\2\2\u023c"+
		"\u023e\3\2\2\2\u023d\u023b\3\2\2\2\u023e\u023f\7\23\2\2\u023f\u0240\7"+
		"\t\2\2\u0240\u024a\5\20\t\2\u0241\u0243\7\u00b2\2\2\u0242\u0241\3\2\2"+
		"\2\u0243\u0246\3\2\2\2\u0244\u0242\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0247"+
		"\3\2\2\2\u0246\u0244\3\2\2\2\u0247\u0249\5 \21\2\u0248\u0244\3\2\2\2\u0249"+
		"\u024c\3\2\2\2\u024a\u0248\3\2\2\2\u024a\u024b\3\2\2\2\u024b\37\3\2\2"+
		"\2\u024c\u024a\3\2\2\2\u024d\u024e\7Q\2\2\u024e\u024f\5\f\7\2\u024f\u0253"+
		"\7\3\2\2\u0250\u0252\7\u00b2\2\2\u0251\u0250\3\2\2\2\u0252\u0255\3\2\2"+
		"\2\u0253\u0251\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0256\3\2\2\2\u0255\u0253"+
		"\3\2\2\2\u0256\u0257\7\u0098\2\2\u0257\u0258\5\f\7\2\u0258\u0259\7\22"+
		"\2\2\u0259\u025a\7\u00ae\2\2\u025a\u025b\7\23\2\2\u025b!\3\2\2\2\u025c"+
		"\u025d\7\u00ae\2\2\u025d\u025e\7\t\2\2\u025e\u025f\5\20\t\2\u025f#\3\2"+
		"\2\2\u0260\u0262\5&\24\2\u0261\u0260\3\2\2\2\u0261\u0262\3\2\2\2\u0262"+
		"\u026d\3\2\2\2\u0263\u0265\7\u00b2\2\2\u0264\u0263\3\2\2\2\u0265\u0266"+
		"\3\2\2\2\u0266\u0264\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0269\3\2\2\2\u0268"+
		"\u026a\5&\24\2\u0269\u0268\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u026c\3\2"+
		"\2\2\u026b\u0264\3\2\2\2\u026c\u026f\3\2\2\2\u026d\u026b\3\2\2\2\u026d"+
		"\u026e\3\2\2\2\u026e%\3\2\2\2\u026f\u026d\3\2\2\2\u0270\u0271\t \2\2\u0271"+
		"\u0272\7\u00ae\2\2\u0272\u0273\7\t\2\2\u0273\u0274\5\20\t\2\u0274\u0276"+
		"\7Q\2\2\u0275\u0277\7\u00b2\2\2\u0276\u0275\3\2\2\2\u0276\u0277\3\2\2"+
		"\2\u0277\u0278\3\2\2\2\u0278\u0279\5,\27\2\u0279\u0324\3\2\2\2\u027a\u027b"+
		"\7\u00ae\2\2\u027b\u027d\7Q\2\2\u027c\u027e\7\u00b2\2\2\u027d\u027c\3"+
		"\2\2\2\u027d\u027e\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0324\5,\27\2\u0280"+
		"\u0281\7\n\2\2\u0281\u0282\7\22\2\2\u0282\u0283\5,\27\2\u0283\u0284\7"+
		"\23\2\2\u0284\u0324\3\2\2\2\u0285\u0286\7\u009b\2\2\u0286\u0287\7\22\2"+
		"\2\u0287\u0288\5,\27\2\u0288\u0289\7\23\2\2\u0289\u0324\3\2\2\2\u028a"+
		"\u028b\7\u0098\2\2\u028b\u028c\7\22\2\2\u028c\u028d\5,\27\2\u028d\u0291"+
		"\7\23\2\2\u028e\u0290\7\u00b2\2\2\u028f\u028e\3\2\2\2\u0290\u0293\3\2"+
		"\2\2\u0291\u028f\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0294\3\2\2\2\u0293"+
		"\u0291\3\2\2\2\u0294\u0295\7\6\2\2\u0295\u0296\5$\23\2\u0296\u02a2\7\7"+
		"\2\2\u0297\u029b\7\u009c\2\2\u0298\u029a\7\u00b2\2\2\u0299\u0298\3\2\2"+
		"\2\u029a\u029d\3\2\2\2\u029b\u0299\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029e"+
		"\3\2\2\2\u029d\u029b\3\2\2\2\u029e\u029f\7\6\2\2\u029f\u02a0\5$\23\2\u02a0"+
		"\u02a1\7\7\2\2\u02a1\u02a3\3\2\2\2\u02a2\u0297\3\2\2\2\u02a2\u02a3\3\2"+
		"\2\2\u02a3\u0324\3\2\2\2\u02a4\u02a5\7\u009d\2\2\u02a5\u02a6\7\22\2\2"+
		"\u02a6\u02a7\5,\27\2\u02a7\u02ab\7\23\2\2\u02a8\u02aa\7\u00b2\2\2\u02a9"+
		"\u02a8\3\2\2\2\u02aa\u02ad\3\2\2\2\u02ab\u02a9\3\2\2\2\u02ab\u02ac\3\2"+
		"\2\2\u02ac\u02ae\3\2\2\2\u02ad\u02ab\3\2\2\2\u02ae\u02b9\7\6\2\2\u02af"+
		"\u02b1\7\u00b2\2\2\u02b0\u02af\3\2\2\2\u02b1\u02b4\3\2\2\2\u02b2\u02b0"+
		"\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02b5\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b5"+
		"\u02b6\7\u009e\2\2\u02b6\u02b7\5.\30\2\u02b7\u02b8\7\u009f\2\2\u02b8\u02ba"+
		"\3\2\2\2\u02b9\u02b2\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bb"+
		"\u02bc\5$\23\2\u02bc\u02bd\7\7\2\2\u02bd\u0324\3\2\2\2\u02be\u02bf\t!"+
		"\2\2\u02bf\u02c8\7\22\2\2\u02c0\u02c5\5(\25\2\u02c1\u02c2\7\3\2\2\u02c2"+
		"\u02c4\5(\25\2\u02c3\u02c1\3\2\2\2\u02c4\u02c7\3\2\2\2\u02c5\u02c3\3\2"+
		"\2\2\u02c5\u02c6\3\2\2\2\u02c6\u02c9\3\2\2\2\u02c7\u02c5\3\2\2\2\u02c8"+
		"\u02c0\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u0324\7\23"+
		"\2\2\u02cb\u02cc\7\u00ae\2\2\u02cc\u02cd\7\22\2\2\u02cd\u02ce\5,\27\2"+
		"\u02ce\u02cf\7\23\2\2\u02cf\u02d1\7Q\2\2\u02d0\u02d2\7\u00b2\2\2\u02d1"+
		"\u02d0\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d4\5,"+
		"\27\2\u02d4\u0324\3\2\2\2\u02d5\u02d6\7\u00a2\2\2\u02d6\u02d8\7\u00ae"+
		"\2\2\u02d7\u02d5\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9"+
		"\u02da\7\u0097\2\2\u02da\u02dc\7\u00ae\2\2\u02db\u02dd\7\u00b2\2\2\u02dc"+
		"\u02db\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02de\3\2\2\2\u02de\u02e7\7\22"+
		"\2\2\u02df\u02e4\5\"\22\2\u02e0\u02e1\7\3\2\2\u02e1\u02e3\5\"\22\2\u02e2"+
		"\u02e0\3\2\2\2\u02e3\u02e6\3\2\2\2\u02e4\u02e2\3\2\2\2\u02e4\u02e5\3\2"+
		"\2\2\u02e5\u02e8\3\2\2\2\u02e6\u02e4\3\2\2\2\u02e7\u02df\3\2\2\2\u02e7"+
		"\u02e8\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02ea\7\23\2\2\u02ea\u02ed\7"+
		"\t\2\2\u02eb\u02ee\5\20\t\2\u02ec\u02ee\7\u00a3\2\2\u02ed\u02eb\3\2\2"+
		"\2\u02ed\u02ec\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef\u02f3\7Q\2\2\u02f0\u02f2"+
		"\7\u00b2\2\2\u02f1\u02f0\3\2\2\2\u02f2\u02f5\3\2\2\2\u02f3\u02f1\3\2\2"+
		"\2\u02f3\u02f4\3\2\2\2\u02f4\u02f6\3\2\2\2\u02f5\u02f3\3\2\2\2\u02f6\u0307"+
		"\7\6\2\2\u02f7\u02f9\7\u00b2\2\2\u02f8\u02f7\3\2\2\2\u02f9\u02fc\3\2\2"+
		"\2\u02fa\u02f8\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb\u02fd\3\2\2\2\u02fc\u02fa"+
		"\3\2\2\2\u02fd\u02fe\7\u009e\2\2\u02fe\u0302\5\62\32\2\u02ff\u0301\7\u00b2"+
		"\2\2\u0300\u02ff\3\2\2\2\u0301\u0304\3\2\2\2\u0302\u0300\3\2\2\2\u0302"+
		"\u0303\3\2\2\2\u0303\u0305\3\2\2\2\u0304\u0302\3\2\2\2\u0305\u0306\7\u009f"+
		"\2\2\u0306\u0308\3\2\2\2\u0307\u02fa\3\2\2\2\u0307\u0308\3\2\2\2\u0308"+
		"\u0309\3\2\2\2\u0309\u0314\5$\23\2\u030a\u030c\7\u00a4\2\2\u030b\u030d"+
		"\5,\27\2\u030c\u030b\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u0311\3\2\2\2\u030e"+
		"\u0310\7\u00b2\2\2\u030f\u030e\3\2\2\2\u0310\u0313\3\2\2\2\u0311\u030f"+
		"\3\2\2\2\u0311\u0312\3\2\2\2\u0312\u0315\3\2\2\2\u0313\u0311\3\2\2\2\u0314"+
		"\u030a\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0316\3\2\2\2\u0316\u0317\7\7"+
		"\2\2\u0317\u0324\3\2\2\2\u0318\u031d\7\u009e\2\2\u0319\u031e\5\6\4\2\u031a"+
		"\u031e\5\4\3\2\u031b\u031e\5\64\33\2\u031c\u031e\5\30\r\2\u031d\u0319"+
		"\3\2\2\2\u031d\u031a\3\2\2\2\u031d\u031b\3\2\2\2\u031d\u031c\3\2\2\2\u031e"+
		"\u031f\3\2\2\2\u031f\u0320\7\u009f\2\2\u0320\u0324\3\2\2\2\u0321\u0324"+
		"\5\26\f\2\u0322\u0324\5,\27\2\u0323\u0270\3\2\2\2\u0323\u027a\3\2\2\2"+
		"\u0323\u0280\3\2\2\2\u0323\u0285\3\2\2\2\u0323\u028a\3\2\2\2\u0323\u02a4"+
		"\3\2\2\2\u0323\u02be\3\2\2\2\u0323\u02cb\3\2\2\2\u0323\u02d7\3\2\2\2\u0323"+
		"\u0318\3\2\2\2\u0323\u0321\3\2\2\2\u0323\u0322\3\2\2\2\u0324\'\3\2\2\2"+
		"\u0325\u0328\7\u00b6\2\2\u0326\u0328\5,\27\2\u0327\u0325\3\2\2\2\u0327"+
		"\u0326\3\2\2\2\u0328)\3\2\2\2\u0329\u034f\t\3\2\2\u032a\u034f\7\u00ad"+
		"\2\2\u032b\u034f\7\u00ae\2\2\u032c\u032d\t\5\2\2\u032d\u032e\7\b\2\2\u032e"+
		"\u032f\7\u00ae\2\2\u032f\u0338\7\22\2\2\u0330\u0335\5,\27\2\u0331\u0332"+
		"\7\3\2\2\u0332\u0334\5,\27\2\u0333\u0331\3\2\2\2\u0334\u0337\3\2\2\2\u0335"+
		"\u0333\3\2\2\2\u0335\u0336\3\2\2\2\u0336\u0339\3\2\2\2\u0337\u0335\3\2"+
		"\2\2\u0338\u0330\3\2\2\2\u0338\u0339\3\2\2\2\u0339\u033a\3\2\2\2\u033a"+
		"\u034f\7\23\2\2\u033b\u033c\t\20\2\2\u033c\u033d\7\b\2\2\u033d\u034f\7"+
		"\u00ae\2\2\u033e\u034f\7\u00b7\2\2\u033f\u034f\7\u00b0\2\2\u0340\u034f"+
		"\7\u00af\2\2\u0341\u0342\t\5\2\2\u0342\u034b\7\22\2\2\u0343\u0348\5,\27"+
		"\2\u0344\u0345\7\3\2\2\u0345\u0347\5,\27\2\u0346\u0344\3\2\2\2\u0347\u034a"+
		"\3\2\2\2\u0348\u0346\3\2\2\2\u0348\u0349\3\2\2\2\u0349\u034c\3\2\2\2\u034a"+
		"\u0348\3\2\2\2\u034b\u0343\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u034d\3\2"+
		"\2\2\u034d\u034f\7\23\2\2\u034e\u0329\3\2\2\2\u034e\u032a\3\2\2\2\u034e"+
		"\u032b\3\2\2\2\u034e\u032c\3\2\2\2\u034e\u033b\3\2\2\2\u034e\u033e\3\2"+
		"\2\2\u034e\u033f\3\2\2\2\u034e\u0340\3\2\2\2\u034e\u0341\3\2\2\2\u034f"+
		"+\3\2\2\2\u0350\u0351\b\27\1\2\u0351\u0352\t\"\2\2\u0352\u0376\5,\27\f"+
		"\u0353\u0354\7\u00ae\2\2\u0354\u035d\7\22\2\2\u0355\u035a\5,\27\2\u0356"+
		"\u0357\7\3\2\2\u0357\u0359\5,\27\2\u0358\u0356\3\2\2\2\u0359\u035c\3\2"+
		"\2\2\u035a\u0358\3\2\2\2\u035a\u035b\3\2\2\2\u035b\u035e\3\2\2\2\u035c"+
		"\u035a\3\2\2\2\u035d\u0355\3\2\2\2\u035d\u035e\3\2\2\2\u035e\u035f\3\2"+
		"\2\2\u035f\u0376\7\23\2\2\u0360\u0365\5*\26\2\u0361\u0362\7\b\2\2\u0362"+
		"\u0364\7\u00ae\2\2\u0363\u0361\3\2\2\2\u0364\u0367\3\2\2\2\u0365\u0363"+
		"\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u0376\3\2\2\2\u0367\u0365\3\2\2\2\u0368"+
		"\u0369\7\u00a5\2\2\u0369\u036a\7\22\2\2\u036a\u0376\7\23\2\2\u036b\u036c"+
		"\7\u00a6\2\2\u036c\u036e\7\22\2\2\u036d\u036f\7\u00b6\2\2\u036e\u036d"+
		"\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0370\3\2\2\2\u0370\u0376\7\23\2\2"+
		"\u0371\u0372\7\22\2\2\u0372\u0373\5,\27\2\u0373\u0374\7\23\2\2\u0374\u0376"+
		"\3\2\2\2\u0375\u0350\3\2\2\2\u0375\u0353\3\2\2\2\u0375\u0360\3\2\2\2\u0375"+
		"\u0368\3\2\2\2\u0375\u036b\3\2\2\2\u0375\u0371\3\2\2\2\u0376\u03af\3\2"+
		"\2\2\u0377\u0378\f\13\2\2\u0378\u037a\t\7\2\2\u0379\u037b\7\u00b2\2\2"+
		"\u037a\u0379\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u037c\3\2\2\2\u037c\u03ae"+
		"\5,\27\f\u037d\u037e\f\n\2\2\u037e\u0380\t\b\2\2\u037f\u0381\7\u00b2\2"+
		"\2\u0380\u037f\3\2\2\2\u0380\u0381\3\2\2\2\u0381\u0382\3\2\2\2\u0382\u03ae"+
		"\5,\27\13\u0383\u0384\f\t\2\2\u0384\u0386\7F\2\2\u0385\u0387\7\u00b2\2"+
		"\2\u0386\u0385\3\2\2\2\u0386\u0387\3\2\2\2\u0387\u0388\3\2\2\2\u0388\u03ae"+
		"\5,\27\t\u0389\u038a\f\b\2\2\u038a\u038c\7G\2\2\u038b\u038d\7\u00b2\2"+
		"\2\u038c\u038b\3\2\2\2\u038c\u038d\3\2\2\2\u038d\u038e\3\2\2\2\u038e\u03ae"+
		"\5,\27\t\u038f\u0390\f\7\2\2\u0390\u0392\t#\2\2\u0391\u0393\7\u00b2\2"+
		"\2\u0392\u0391\3\2\2\2\u0392\u0393\3\2\2\2\u0393\u0394\3\2\2\2\u0394\u03ae"+
		"\5,\27\b\u0395\u0396\f\6\2\2\u0396\u0398\t$\2\2\u0397\u0399\7\u00b2\2"+
		"\2\u0398\u0397\3\2\2\2\u0398\u0399\3\2\2\2\u0399\u039a\3\2\2\2\u039a\u03ae"+
		"\5,\27\7\u039b\u039c\f\5\2\2\u039c\u039e\7[\2\2\u039d\u039f\7\u00b2\2"+
		"\2\u039e\u039d\3\2\2\2\u039e\u039f\3\2\2\2\u039f\u03a0\3\2\2\2\u03a0\u03ae"+
		"\5,\27\6\u03a1\u03a2\f\4\2\2\u03a2\u03a4\7_\2\2\u03a3\u03a5\7\u00b2\2"+
		"\2\u03a4\u03a3\3\2\2\2\u03a4\u03a5\3\2\2\2\u03a5\u03a6\3\2\2\2\u03a6\u03ae"+
		"\5,\27\5\u03a7\u03a8\f\3\2\2\u03a8\u03aa\7a\2\2\u03a9\u03ab\7\u00b2\2"+
		"\2\u03aa\u03a9\3\2\2\2\u03aa\u03ab\3\2\2\2\u03ab\u03ac\3\2\2\2\u03ac\u03ae"+
		"\5,\27\4\u03ad\u0377\3\2\2\2\u03ad\u037d\3\2\2\2\u03ad\u0383\3\2\2\2\u03ad"+
		"\u0389\3\2\2\2\u03ad\u038f\3\2\2\2\u03ad\u0395\3\2\2\2\u03ad\u039b\3\2"+
		"\2\2\u03ad\u03a1\3\2\2\2\u03ad\u03a7\3\2\2\2\u03ae\u03b1\3\2\2\2\u03af"+
		"\u03ad\3\2\2\2\u03af\u03b0\3\2\2\2\u03b0-\3\2\2\2\u03b1\u03af\3\2\2\2"+
		"\u03b2\u03b6\7\6\2\2\u03b3\u03b5\7\u00b2\2\2\u03b4\u03b3\3\2\2\2\u03b5"+
		"\u03b8\3\2\2\2\u03b6\u03b4\3\2\2\2\u03b6\u03b7\3\2\2\2\u03b7\u03b9\3\2"+
		"\2\2\u03b8\u03b6\3\2\2\2\u03b9\u03ba\5\60\31\2\u03ba\u03be\7\7\2\2\u03bb"+
		"\u03bd\7\u00b2\2\2\u03bc\u03bb\3\2\2\2\u03bd\u03c0\3\2\2\2\u03be\u03bc"+
		"\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\u03e8\3\2\2\2\u03c0\u03be\3\2\2\2\u03c1"+
		"\u03c5\7\6\2\2\u03c2\u03c4\7\u00b2\2\2\u03c3\u03c2\3\2\2\2\u03c4\u03c7"+
		"\3\2\2\2\u03c5\u03c3\3\2\2\2\u03c5\u03c6\3\2\2\2\u03c6\u03c8\3\2\2\2\u03c7"+
		"\u03c5\3\2\2\2\u03c8\u03cc\7\u0092\2\2\u03c9\u03cb\7\u00b2\2\2\u03ca\u03c9"+
		"\3\2\2\2\u03cb\u03ce\3\2\2\2\u03cc\u03ca\3\2\2\2\u03cc\u03cd\3\2\2\2\u03cd"+
		"\u03cf\3\2\2\2\u03ce\u03cc\3\2\2\2\u03cf\u03da\5\f\7\2\u03d0\u03d2\7\u00b2"+
		"\2\2\u03d1\u03d0\3\2\2\2\u03d2\u03d3\3\2\2\2\u03d3\u03d1\3\2\2\2\u03d3"+
		"\u03d4\3\2\2\2\u03d4\u03d6\3\2\2\2\u03d5\u03d7\5\f\7\2\u03d6\u03d5\3\2"+
		"\2\2\u03d6\u03d7\3\2\2\2\u03d7\u03d9\3\2\2\2\u03d8\u03d1\3\2\2\2\u03d9"+
		"\u03dc\3\2\2\2\u03da\u03d8\3\2\2\2\u03da\u03db\3\2\2\2\u03db\u03de\3\2"+
		"\2\2\u03dc\u03da\3\2\2\2\u03dd\u03df\5\60\31\2\u03de\u03dd\3\2\2\2\u03de"+
		"\u03df\3\2\2\2\u03df\u03e0\3\2\2\2\u03e0\u03e4\7\7\2\2\u03e1\u03e3\7\u00b2"+
		"\2\2\u03e2\u03e1\3\2\2\2\u03e3\u03e6\3\2\2\2\u03e4\u03e2\3\2\2\2\u03e4"+
		"\u03e5\3\2\2\2\u03e5\u03e8\3\2\2\2\u03e6\u03e4\3\2\2\2\u03e7\u03b2\3\2"+
		"\2\2\u03e7\u03c1\3\2\2\2\u03e8/\3\2\2\2\u03e9\u03ea\7\u00a7\2\2\u03ea"+
		"\u03ef\7\u00ae\2\2\u03eb\u03ec\7\3\2\2\u03ec\u03ee\7\u00ae\2\2\u03ed\u03eb"+
		"\3\2\2\2\u03ee\u03f1\3\2\2\2\u03ef\u03ed\3\2\2\2\u03ef\u03f0\3\2\2\2\u03f0"+
		"\u03f5\3\2\2\2\u03f1\u03ef\3\2\2\2\u03f2\u03f4\7\u00b2\2\2\u03f3\u03f2"+
		"\3\2\2\2\u03f4\u03f7\3\2\2\2\u03f5\u03f3\3\2\2\2\u03f5\u03f6\3\2\2\2\u03f6"+
		"\61\3\2\2\2\u03f7\u03f5\3\2\2\2\u03f8\u03fc\7\6\2\2\u03f9\u03fb\7\u00b2"+
		"\2\2\u03fa\u03f9\3\2\2\2\u03fb\u03fe\3\2\2\2\u03fc\u03fa\3\2\2\2\u03fc"+
		"\u03fd\3\2\2\2\u03fd\u0414\3\2\2\2\u03fe\u03fc\3\2\2\2\u03ff\u0403\t%"+
		"\2\2\u0400\u0402\7\u00b2\2\2\u0401\u0400\3\2\2\2\u0402\u0405\3\2\2\2\u0403"+
		"\u0401\3\2\2\2\u0403\u0404\3\2\2\2\u0404\u0406\3\2\2\2\u0405\u0403\3\2"+
		"\2\2\u0406\u0411\5\f\7\2\u0407\u0409\7\u00b2\2\2\u0408\u0407\3\2\2\2\u0409"+
		"\u040a\3\2\2\2\u040a\u0408\3\2\2\2\u040a\u040b\3\2\2\2\u040b\u040d\3\2"+
		"\2\2\u040c\u040e\5\f\7\2\u040d\u040c\3\2\2\2\u040d\u040e\3\2\2\2\u040e"+
		"\u0410\3\2\2\2\u040f\u0408\3\2\2\2\u0410\u0413\3\2\2\2\u0411\u040f\3\2"+
		"\2\2\u0411\u0412\3\2\2\2\u0412\u0415\3\2\2\2\u0413\u0411\3\2\2\2\u0414"+
		"\u03ff\3\2\2\2\u0414\u0415\3\2\2\2\u0415\u0419\3\2\2\2\u0416\u0418\7\u00b2"+
		"\2\2\u0417\u0416\3\2\2\2\u0418\u041b\3\2\2\2\u0419\u0417\3\2\2\2\u0419"+
		"\u041a\3\2\2\2\u041a\u041d\3\2\2\2\u041b\u0419\3\2\2\2\u041c\u041e\5\60"+
		"\31\2\u041d\u041c\3\2\2\2\u041d\u041e\3\2\2\2\u041e\u0434\3\2\2\2\u041f"+
		"\u0423\t&\2\2\u0420\u0422\7\u00b2\2\2\u0421\u0420\3\2\2\2\u0422\u0425"+
		"\3\2\2\2\u0423\u0421\3\2\2\2\u0423\u0424\3\2\2\2\u0424\u0426\3\2\2\2\u0425"+
		"\u0423\3\2\2\2\u0426\u0431\5\f\7\2\u0427\u0429\7\u00b2\2\2\u0428\u0427"+
		"\3\2\2\2\u0429\u042a\3\2\2\2\u042a\u0428\3\2\2\2\u042a\u042b\3\2\2\2\u042b"+
		"\u042d\3\2\2\2\u042c\u042e\5\f\7\2\u042d\u042c\3\2\2\2\u042d\u042e\3\2"+
		"\2\2\u042e\u0430\3\2\2\2\u042f\u0428\3\2\2\2\u0430\u0433\3\2\2\2\u0431"+
		"\u042f\3\2\2\2\u0431\u0432\3\2\2\2\u0432\u0435\3\2\2\2\u0433\u0431\3\2"+
		"\2\2\u0434\u041f\3\2\2\2\u0434\u0435\3\2\2\2\u0435\u0439\3\2\2\2\u0436"+
		"\u0438\7\u00b2\2\2\u0437\u0436\3\2\2\2\u0438\u043b\3\2\2\2\u0439\u0437"+
		"\3\2\2\2\u0439\u043a\3\2\2\2\u043a\u043c\3\2\2\2\u043b\u0439\3\2\2\2\u043c"+
		"\u0440\7\7\2\2\u043d\u043f\7\u00b2\2\2\u043e\u043d\3\2\2\2\u043f\u0442"+
		"\3\2\2\2\u0440\u043e\3\2\2\2\u0440\u0441\3\2\2\2\u0441\63\3\2\2\2\u0442"+
		"\u0440\3\2\2\2\u0443\u0447\7\6\2\2\u0444\u0446\7\u00b2\2\2\u0445\u0444"+
		"\3\2\2\2\u0446\u0449\3\2\2\2\u0447\u0445\3\2\2\2\u0447\u0448\3\2\2\2\u0448"+
		"\u044a\3\2\2\2\u0449\u0447\3\2\2\2\u044a\u044e\7\u0092\2\2\u044b\u044d"+
		"\7\u00b2\2\2\u044c\u044b\3\2\2\2\u044d\u0450\3\2\2\2\u044e\u044c\3\2\2"+
		"\2\u044e\u044f\3\2\2\2\u044f\u0451\3\2\2\2\u0450\u044e\3\2\2\2\u0451\u045c"+
		"\5\f\7\2\u0452\u0454\7\u00b2\2\2\u0453\u0452\3\2\2\2\u0454\u0455\3\2\2"+
		"\2\u0455\u0453\3\2\2\2\u0455\u0456\3\2\2\2\u0456\u0458\3\2\2\2\u0457\u0459"+
		"\5\f\7\2\u0458\u0457\3\2\2\2\u0458\u0459\3\2\2\2\u0459\u045b\3\2\2\2\u045a"+
		"\u0453\3\2\2\2\u045b\u045e\3\2\2\2\u045c\u045a\3\2\2\2\u045c\u045d\3\2"+
		"\2\2\u045d\u045f\3\2\2\2\u045e\u045c\3\2\2\2\u045f\u0463\7\7\2\2\u0460"+
		"\u0462\7\u00b2\2\2\u0461\u0460\3\2\2\2\u0462\u0465\3\2\2\2\u0463\u0461"+
		"\3\2\2\2\u0463\u0464\3\2\2\2\u0464\65\3\2\2\2\u0465\u0463\3\2\2\2\u00a1"+
		":>CKRU]cjlpux|\u0083\u0090\u0097\u009f\u00a7\u00ac\u00b1\u00b4\u00b8\u00bc"+
		"\u00ca\u00d7\u00eb\u00ee\u00f1\u00fd\u0101\u0106\u010c\u0112\u0118\u011e"+
		"\u0124\u012a\u0130\u0136\u013c\u013f\u0141\u014a\u0153\u0157\u015c\u015f"+
		"\u0169\u0170\u0176\u017c\u01a0\u01af\u01b9\u01c6\u01cd\u01d9\u01e7\u01ea"+
		"\u01ef\u01f6\u01fa\u0209\u0210\u0217\u021a\u021e\u0225\u022a\u0233\u023b"+
		"\u0244\u024a\u0253\u0261\u0266\u0269\u026d\u0276\u027d\u0291\u029b\u02a2"+
		"\u02ab\u02b2\u02b9\u02c5\u02c8\u02d1\u02d7\u02dc\u02e4\u02e7\u02ed\u02f3"+
		"\u02fa\u0302\u0307\u030c\u0311\u0314\u031d\u0323\u0327\u0335\u0338\u0348"+
		"\u034b\u034e\u035a\u035d\u0365\u036e\u0375\u037a\u0380\u0386\u038c\u0392"+
		"\u0398\u039e\u03a4\u03aa\u03ad\u03af\u03b6\u03be\u03c5\u03cc\u03d3\u03d6"+
		"\u03da\u03de\u03e4\u03e7\u03ef\u03f5\u03fc\u0403\u040a\u040d\u0411\u0414"+
		"\u0419\u041d\u0423\u042a\u042d\u0431\u0434\u0439\u0440\u0447\u044e\u0455"+
		"\u0458\u045c\u0463";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}