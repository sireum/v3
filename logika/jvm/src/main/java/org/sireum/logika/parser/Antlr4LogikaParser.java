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
			setState(237);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
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
				_localctx = new ApplyResultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				((ApplyResultContext)_localctx).tb = match(T__17);
				setState(192);
				match(T__15);
				setState(193);
				formula(0);
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(194);
					match(T__0);
					setState(195);
					formula(0);
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(201);
				match(T__16);
				}
				break;
			case 4:
				_localctx = new ResultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(203);
				match(T__17);
				}
				break;
			case 5:
				_localctx = new ApplyContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				match(ID);
				setState(205);
				match(T__15);
				setState(206);
				formula(0);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(207);
					match(T__0);
					setState(208);
					formula(0);
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(214);
				match(T__16);
				}
				break;
			case 6:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(216);
				((VarContext)_localctx).tb = match(ID);
				}
				break;
			case 7:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(217);
				match(NUM);
				}
				break;
			case 8:
				_localctx = new IntLitContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(218);
				match(INT);
				}
				break;
			case 9:
				_localctx = new RLitContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(219);
				match(REAL);
				}
				break;
			case 10:
				_localctx = new FloatLitContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(220);
				match(FLOAT);
				}
				break;
			case 11:
				_localctx = new TypeAccessContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(221);
				((TypeAccessContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
					((TypeAccessContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(222);
				match(T__5);
				setState(223);
				match(ID);
				}
				break;
			case 12:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(224);
				((SeqContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0)) ) {
					((SeqContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(225);
				match(T__15);
				setState(234);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (FLOAT - 163)))) != 0)) {
					{
					setState(226);
					exp(0);
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(227);
						match(T__0);
						setState(228);
						exp(0);
						}
						}
						setState(233);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(236);
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
			setState(253);
			switch (_input.LA(1)) {
			case T__66:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(240);
				((UnaryContext)_localctx).op = match(T__66);
				setState(241);
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
				setState(242);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__82 - 83)) | (1L << (T__83 - 83)) | (1L << (T__84 - 83)) | (1L << (T__85 - 83)) | (1L << (T__86 - 83)))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(243);
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
				setState(244);
				primFormula();
				setState(249);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(245);
						match(T__5);
						setState(246);
						match(ID);
						}
						} 
					}
					setState(251);
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
				setState(252);
				qformula();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(317);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(315);
					switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(255);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(256);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (T__62 - 63)) | (1L << (T__63 - 63)) | (1L << (T__64 - 63)))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(261);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(262);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__65 || _la==T__66) ) {
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
						((BinaryContext)_localctx).r = formula(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(267);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(268);
						((BinaryContext)_localctx).op = match(T__67);
						setState(270);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(269);
							match(NL);
							}
						}

						setState(272);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(273);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(274);
						((BinaryContext)_localctx).op = match(T__68);
						setState(276);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(275);
							match(NL);
							}
						}

						setState(278);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(279);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(280);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__71 - 70)) | (1L << (T__72 - 70)) | (1L << (T__73 - 70)) | (1L << (T__74 - 70)) | (1L << (T__75 - 70)) | (1L << (T__76 - 70)) | (1L << (T__77 - 70)))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(285);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(286);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (T__78 - 79)) | (1L << (T__79 - 79)) | (1L << (T__80 - 79)) | (1L << (T__81 - 79)))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(291);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(292);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (T__87 - 88)) | (1L << (T__88 - 88)) | (1L << (T__89 - 88)) | (1L << (T__90 - 88)))) != 0)) ) {
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
						((BinaryContext)_localctx).r = formula(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(297);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(298);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__91 || _la==T__92) ) {
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
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(303);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(304);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (T__93 - 94)) | (1L << (T__94 - 94)) | (1L << (T__95 - 94)) | (1L << (T__96 - 94)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(306);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(305);
							match(NL);
							}
						}

						setState(308);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 10:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(309);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(310);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (T__97 - 98)) | (1L << (T__98 - 98)) | (1L << (T__99 - 98)))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(312);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(311);
							match(NL);
							}
						}

						setState(314);
						((BinaryContext)_localctx).r = formula(2);
						}
						break;
					}
					} 
				}
				setState(319);
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
			setState(320);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & ((1L << (T__100 - 101)) | (1L << (T__101 - 101)) | (1L << (T__102 - 101)) | (1L << (T__103 - 101)) | (1L << (T__104 - 101)) | (1L << (T__105 - 101)) | (1L << (T__106 - 101)) | (1L << (T__107 - 101)))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(321);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(322);
				match(T__0);
				setState(323);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(344);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(329);
				match(T__6);
				setState(330);
				type();
				}
				break;
			case 2:
				{
				setState(331);
				match(T__6);
				setState(332);
				match(T__15);
				setState(333);
				((QformulaContext)_localctx).lo = exp(0);
				setState(335);
				_la = _input.LA(1);
				if (_la==T__69) {
					{
					setState(334);
					((QformulaContext)_localctx).ll = match(T__69);
					}
				}

				setState(337);
				match(T__108);
				setState(339);
				_la = _input.LA(1);
				if (_la==T__69) {
					{
					setState(338);
					((QformulaContext)_localctx).lh = match(T__69);
					}
				}

				setState(341);
				((QformulaContext)_localctx).hi = exp(0);
				setState(342);
				match(T__16);
				}
				break;
			}
			setState(347);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(346);
				match(NL);
				}
			}

			setState(349);
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
			setState(351);
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
			setState(486);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(353);
				((PremiseContext)_localctx).t = match(T__109);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(357);
				switch (_input.LA(1)) {
				case T__110:
					{
					setState(354);
					((AndIntroContext)_localctx).tb = match(T__110);
					}
					break;
				case T__88:
				case T__89:
				case T__90:
					{
					setState(355);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (T__88 - 89)) | (1L << (T__89 - 89)) | (1L << (T__90 - 89)))) != 0)) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(356);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(359);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(360);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(364);
				switch (_input.LA(1)) {
				case T__111:
				case T__112:
					{
					setState(361);
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
					setState(362);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (T__88 - 89)) | (1L << (T__89 - 89)) | (1L << (T__90 - 89)))) != 0)) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
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
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(370);
				switch (_input.LA(1)) {
				case T__113:
				case T__114:
				case T__115:
				case T__116:
					{
					setState(367);
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
					setState(368);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__94 || _la==T__96) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(369);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(372);
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(376);
				switch (_input.LA(1)) {
				case T__117:
				case T__118:
					{
					setState(373);
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
					setState(374);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__94 || _la==T__96) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(375);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(378);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(379);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(380);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(381);
				((ImpliesIntroContext)_localctx).tb = match(T__119);
				setState(382);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(383);
				((ImpliesElimContext)_localctx).tb = match(T__120);
				setState(384);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(385);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(386);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(387);
				((ImpliesIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__98 || _la==T__99) ) {
					((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(388);
				match(ID);
				setState(389);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(390);
				if (!(("->".equals(_input.LT(1).getText()) ||
				      "→".equals(_input.LT(1).getText())) &&
				      "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"->\".equals(_input.LT(1).getText()) ||\n      \"→\".equals(_input.LT(1).getText())) &&\n      \"e\".equals(_input.LT(2).getText())");
				setState(391);
				((ImpliesElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__98 || _la==T__99) ) {
					((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(392);
				match(ID);
				setState(393);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(394);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(395);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__121 || _la==T__122) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(396);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 11:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(397);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__123 || _la==T__124) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(398);
				((NegElimContext)_localctx).step = match(NUM);
				setState(399);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 12:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(400);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(401);
				((NegIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)))) != 0)) ) {
					((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(402);
				match(ID);
				setState(403);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 13:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(404);
				if (!(("!".equals(_input.LT(1).getText()) ||
				      "~".equals(_input.LT(1).getText()) ||
				      "¬".equals(_input.LT(1).getText())) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "(\"!\".equals(_input.LT(1).getText()) ||\n      \"~\".equals(_input.LT(1).getText()) ||\n      \"¬\".equals(_input.LT(1).getText())) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(405);
				((NegElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (T__84 - 85)) | (1L << (T__85 - 85)) | (1L << (T__86 - 85)))) != 0)) ) {
					((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(406);
				match(ID);
				setState(407);
				((NegElimContext)_localctx).step = match(NUM);
				setState(408);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 14:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(412);
				switch (_input.LA(1)) {
				case T__125:
				case T__126:
					{
					setState(409);
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
					setState(410);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==T__14) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(411);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(414);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 15:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(415);
				((PbcContext)_localctx).tb = match(T__127);
				setState(416);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 16:
				_localctx = new Subst1Context(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(417);
				((Subst1Context)_localctx).tb = match(T__128);
				setState(418);
				((Subst1Context)_localctx).eqStep = match(NUM);
				setState(419);
				((Subst1Context)_localctx).step = match(NUM);
				}
				break;
			case 17:
				_localctx = new Subst2Context(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(420);
				((Subst2Context)_localctx).tb = match(T__129);
				setState(421);
				((Subst2Context)_localctx).eqStep = match(NUM);
				setState(422);
				((Subst2Context)_localctx).step = match(NUM);
				}
				break;
			case 18:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(423);
				((AlgebraContext)_localctx).tb = match(T__130);
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(424);
					((AlgebraContext)_localctx).NUM = match(NUM);
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).NUM);
					}
					}
					setState(429);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 19:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(430);
				((ForallIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 132)) & ~0x3f) == 0 && ((1L << (_la - 132)) & ((1L << (T__131 - 132)) | (1L << (T__132 - 132)) | (1L << (T__133 - 132)))) != 0)) ) {
					((ForallIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(431);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 20:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(432);
				((ForallElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (T__134 - 135)) | (1L << (T__135 - 135)) | (1L << (T__136 - 135)))) != 0)) ) {
					((ForallElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(433);
				((ForallElimContext)_localctx).step = match(NUM);
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0) );
				}
				break;
			case 21:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(439);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(440);
				((ForallIntroContext)_localctx).tb = match(T__103);
				setState(441);
				match(ID);
				setState(442);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 22:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(443);
				if (!("∀".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∀\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(444);
				((ForallElimContext)_localctx).tb = match(T__103);
				setState(445);
				match(ID);
				setState(446);
				((ForallElimContext)_localctx).step = match(NUM);
				setState(448); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(447);
					formula(0);
					}
					}
					setState(450); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0) );
				}
				break;
			case 23:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(452);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & ((1L << (T__137 - 138)) | (1L << (T__138 - 138)) | (1L << (T__139 - 138)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
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
			case 24:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(459);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 141)) & ~0x3f) == 0 && ((1L << (_la - 141)) & ((1L << (T__140 - 141)) | (1L << (T__141 - 141)) | (1L << (T__142 - 141)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(460);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(461);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 25:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(462);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(463);
				((ExistsIntroContext)_localctx).tb = match(T__107);
				setState(464);
				match(ID);
				setState(465);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(467); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(466);
					formula(0);
					}
					}
					setState(469); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0) );
				}
				break;
			case 26:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(471);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "e".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"e\".equals(_input.LT(2).getText())");
				setState(472);
				((ExistsElimContext)_localctx).tb = match(T__107);
				setState(473);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(474);
				((ExistsElimContext)_localctx).step = match(NUM);
				setState(475);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 27:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(476);
				((InvariantContext)_localctx).tb = match(T__143);
				}
				break;
			case 28:
				_localctx = new FctContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(477);
				((FctContext)_localctx).tb = match(T__144);
				setState(478);
				match(ID);
				}
				break;
			case 29:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(479);
				((AutoContext)_localctx).tb = match(T__145);
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM) {
					{
					{
					setState(480);
					((AutoContext)_localctx).NUM = match(NUM);
					((AutoContext)_localctx).steps.add(((AutoContext)_localctx).NUM);
					}
					}
					setState(485);
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
			setState(502);
			_la = _input.LA(1);
			if (_la==T__146) {
				{
				setState(494);
				impor();
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
					_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(500);
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
			setState(504);
			((ImporContext)_localctx).tb = match(T__146);
			setState(505);
			((ImporContext)_localctx).org = match(ID);
			setState(506);
			match(T__5);
			setState(507);
			((ImporContext)_localctx).sireum = match(ID);
			setState(508);
			match(T__5);
			setState(509);
			((ImporContext)_localctx).logika = match(ID);
			setState(510);
			match(T__5);
			setState(511);
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
			setState(513);
			match(T__3);
			setState(517);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(514);
				match(NL);
				}
				}
				setState(519);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(520);
			((FactsContext)_localctx).ftb = match(T__144);
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
			setState(527);
			factOrFun();
			setState(538);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(529); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(528);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(531); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(534);
				_la = _input.LA(1);
				if (_la==T__148 || _la==ID) {
					{
					setState(533);
					factOrFun();
					}
				}

				}
				}
				setState(540);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(541);
			((FactsContext)_localctx).te = match(T__4);
			setState(545);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(542);
				match(NL);
				}
				}
				setState(547);
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
			setState(550);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(548);
				fact();
				}
				break;
			case T__148:
				enterOuterAlt(_localctx, 2);
				{
				setState(549);
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
			setState(552);
			match(ID);
			setState(553);
			match(T__5);
			setState(554);
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
			setState(556);
			((FunContext)_localctx).tb = match(T__148);
			setState(557);
			match(ID);
			setState(559);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(558);
				match(NL);
				}
			}

			setState(561);
			match(T__15);
			setState(562);
			param();
			setState(567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(563);
				match(T__0);
				setState(564);
				param();
				}
				}
				setState(569);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(570);
			match(T__16);
			setState(571);
			match(T__6);
			setState(572);
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
			setState(574);
			match(ID);
			setState(575);
			match(T__6);
			setState(576);
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
			setState(579);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 147)) & ~0x3f) == 0 && ((1L << (_la - 147)) & ((1L << (T__146 - 147)) | (1L << (T__148 - 147)) | (1L << (T__149 - 147)) | (1L << (T__150 - 147)) | (1L << (T__151 - 147)) | (1L << (T__152 - 147)) | (1L << (T__154 - 147)) | (1L << (T__155 - 147)) | (1L << (T__157 - 147)) | (1L << (T__158 - 147)) | (1L << (T__159 - 147)) | (1L << (T__162 - 147)) | (1L << (T__163 - 147)) | (1L << (NUM - 147)) | (1L << (ID - 147)) | (1L << (REAL - 147)) | (1L << (INT - 147)) | (1L << (FLOAT - 147)))) != 0)) {
				{
				setState(578);
				stmt();
				}
			}

			setState(591);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(582); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(581);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(584); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(587);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 147)) & ~0x3f) == 0 && ((1L << (_la - 147)) & ((1L << (T__146 - 147)) | (1L << (T__148 - 147)) | (1L << (T__149 - 147)) | (1L << (T__150 - 147)) | (1L << (T__151 - 147)) | (1L << (T__152 - 147)) | (1L << (T__154 - 147)) | (1L << (T__155 - 147)) | (1L << (T__157 - 147)) | (1L << (T__158 - 147)) | (1L << (T__159 - 147)) | (1L << (T__162 - 147)) | (1L << (T__163 - 147)) | (1L << (NUM - 147)) | (1L << (ID - 147)) | (1L << (REAL - 147)) | (1L << (INT - 147)) | (1L << (FLOAT - 147)))) != 0)) {
					{
					setState(586);
					stmt();
					}
				}

				}
				}
				setState(593);
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
			setState(773);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(594);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__149 || _la==T__150) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(595);
				match(ID);
				setState(596);
				match(T__6);
				setState(597);
				type();
				setState(598);
				match(T__78);
				setState(600);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(599);
					match(NL);
					}
				}

				setState(602);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(604);
				match(ID);
				setState(605);
				match(T__78);
				setState(607);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(606);
					match(NL);
					}
				}

				setState(609);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssumeStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(610);
				match(T__7);
				setState(611);
				match(T__15);
				setState(612);
				exp(0);
				setState(613);
				match(T__16);
				}
				break;
			case 4:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(615);
				match(T__151);
				setState(616);
				match(T__15);
				setState(617);
				exp(0);
				setState(618);
				match(T__16);
				}
				break;
			case 5:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(620);
				match(T__152);
				setState(621);
				match(T__15);
				setState(622);
				exp(0);
				setState(623);
				match(T__16);
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
				match(T__3);
				setState(631);
				((IfStmtContext)_localctx).ts = stmts();
				setState(632);
				match(T__4);
				setState(644);
				_la = _input.LA(1);
				if (_la==T__153) {
					{
					setState(633);
					match(T__153);
					setState(637);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(634);
						match(NL);
						}
						}
						setState(639);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(640);
					match(T__3);
					setState(641);
					((IfStmtContext)_localctx).fs = stmts();
					setState(642);
					match(T__4);
					}
				}

				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(646);
				match(T__154);
				setState(647);
				match(T__15);
				setState(648);
				exp(0);
				setState(649);
				match(T__16);
				setState(653);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(650);
					match(NL);
					}
					}
					setState(655);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(656);
				match(T__3);
				setState(667);
				switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
				case 1:
					{
					setState(660);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(657);
						match(NL);
						}
						}
						setState(662);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(663);
					match(T__155);
					setState(664);
					loopInvariant();
					setState(665);
					match(T__156);
					}
					break;
				}
				setState(669);
				stmts();
				setState(670);
				match(T__4);
				}
				break;
			case 7:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(672);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__157 || _la==T__158) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(673);
				match(T__15);
				setState(682);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (STRING - 163)) | (1L << (FLOAT - 163)))) != 0)) {
					{
					setState(674);
					stringOrExp();
					setState(679);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(675);
						match(T__0);
						setState(676);
						stringOrExp();
						}
						}
						setState(681);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(684);
				match(T__16);
				}
				break;
			case 8:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(685);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(686);
				match(T__15);
				setState(687);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(688);
				match(T__16);
				setState(689);
				match(T__78);
				setState(691);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(690);
					match(NL);
					}
				}

				setState(693);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 9:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(697);
				_la = _input.LA(1);
				if (_la==T__159) {
					{
					setState(695);
					match(T__159);
					setState(696);
					((MethodDeclStmtContext)_localctx).helper = match(ID);
					}
				}

				setState(699);
				match(T__148);
				setState(700);
				((MethodDeclStmtContext)_localctx).id = match(ID);
				setState(702);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(701);
					match(NL);
					}
				}

				setState(704);
				match(T__15);
				setState(713);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(705);
					param();
					setState(710);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(706);
						match(T__0);
						setState(707);
						param();
						}
						}
						setState(712);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(715);
				match(T__16);
				setState(716);
				match(T__6);
				setState(719);
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
					setState(717);
					type();
					}
					break;
				case T__160:
					{
					setState(718);
					match(T__160);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(721);
				match(T__78);
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
				setState(728);
				match(T__3);
				setState(745);
				switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
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
					match(T__155);
					setState(736);
					methodContract();
					setState(740);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(737);
						match(NL);
						}
						}
						setState(742);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(743);
					match(T__156);
					}
					break;
				}
				setState(747);
				stmts();
				setState(758);
				_la = _input.LA(1);
				if (_la==T__161) {
					{
					setState(748);
					((MethodDeclStmtContext)_localctx).rtb = match(T__161);
					setState(750);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (FLOAT - 163)))) != 0)) {
						{
						setState(749);
						exp(0);
						}
					}

					setState(755);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(752);
						match(NL);
						}
						}
						setState(757);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(760);
				match(T__4);
				}
				break;
			case 10:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(762);
				match(T__155);
				setState(767);
				switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
				case 1:
					{
					setState(763);
					proof();
					}
					break;
				case 2:
					{
					setState(764);
					sequent();
					}
					break;
				case 3:
					{
					setState(765);
					invariants();
					}
					break;
				case 4:
					{
					setState(766);
					facts();
					}
					break;
				}
				setState(769);
				match(T__156);
				}
				break;
			case 11:
				_localctx = new ImportStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(771);
				impor();
				}
				break;
			case 12:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(772);
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
			setState(777);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(775);
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
				setState(776);
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
			setState(801);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				_localctx = new BooleanExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(779);
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
				setState(780);
				match(NUM);
				}
				break;
			case 3:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(781);
				match(ID);
				}
				break;
			case 4:
				_localctx = new TypeAccessExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(782);
				((TypeAccessExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0)) ) {
					((TypeAccessExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(783);
				match(T__5);
				setState(784);
				match(ID);
				}
				break;
			case 5:
				_localctx = new FloatLitExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(785);
				match(FLOAT);
				}
				break;
			case 6:
				_localctx = new IntLitExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(786);
				match(INT);
				}
				break;
			case 7:
				_localctx = new RLitExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(787);
				match(REAL);
				}
				break;
			case 8:
				_localctx = new SeqExpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(788);
				((SeqExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0)) ) {
					((SeqExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(789);
				match(T__15);
				setState(798);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (FLOAT - 163)))) != 0)) {
					{
					setState(790);
					exp(0);
					setState(795);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(791);
						match(T__0);
						setState(792);
						exp(0);
						}
						}
						setState(797);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(800);
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(840);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(804);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0)) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(805);
				exp(10);
				}
				break;
			case 2:
				{
				_localctx = new InvokeExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(806);
				((InvokeExpContext)_localctx).tb = match(ID);
				setState(807);
				((InvokeExpContext)_localctx).t = match(T__15);
				setState(816);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)))) != 0) || ((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (T__162 - 163)) | (1L << (T__163 - 163)) | (1L << (NUM - 163)) | (1L << (ID - 163)) | (1L << (REAL - 163)) | (1L << (INT - 163)) | (1L << (FLOAT - 163)))) != 0)) {
					{
					setState(808);
					exp(0);
					setState(813);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(809);
						match(T__0);
						setState(810);
						exp(0);
						}
						}
						setState(815);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(818);
				match(T__16);
				}
				break;
			case 3:
				{
				_localctx = new PExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(819);
				primExp();
				setState(824);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(820);
						match(T__5);
						setState(821);
						match(ID);
						}
						} 
					}
					setState(826);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				}
				}
				break;
			case 4:
				{
				_localctx = new RandomIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(827);
				match(T__162);
				setState(828);
				match(T__15);
				setState(829);
				match(T__16);
				}
				break;
			case 5:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(830);
				match(T__163);
				setState(831);
				match(T__15);
				setState(833);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(832);
					match(STRING);
					}
				}

				setState(835);
				match(T__16);
				}
				break;
			case 6:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(836);
				match(T__15);
				setState(837);
				exp(0);
				setState(838);
				match(T__16);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(898);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,120,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(896);
					switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(842);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(843);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (T__62 - 63)) | (1L << (T__63 - 63)) | (1L << (T__64 - 63)))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(845);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(844);
							match(NL);
							}
						}

						setState(847);
						((BinaryExpContext)_localctx).r = exp(10);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(848);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(849);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__65 || _la==T__66) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(851);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(850);
							match(NL);
							}
						}

						setState(853);
						((BinaryExpContext)_localctx).r = exp(9);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(854);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(855);
						((BinaryExpContext)_localctx).op = match(T__67);
						setState(857);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(856);
							match(NL);
							}
						}

						setState(859);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(860);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(861);
						((BinaryExpContext)_localctx).op = match(T__68);
						setState(863);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(862);
							match(NL);
							}
						}

						setState(865);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(866);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(867);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (T__69 - 70)) | (1L << (T__70 - 70)) | (1L << (T__72 - 70)) | (1L << (T__73 - 70)) | (1L << (T__75 - 70)) | (1L << (T__76 - 70)) | (1L << (T__77 - 70)))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(869);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(868);
							match(NL);
							}
						}

						setState(871);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(872);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(873);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__79 || _la==T__80) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(875);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(874);
							match(NL);
							}
						}

						setState(877);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(878);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(879);
						((BinaryExpContext)_localctx).op = match(T__88);
						setState(881);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(880);
							match(NL);
							}
						}

						setState(883);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(884);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(885);
						((BinaryExpContext)_localctx).op = match(T__92);
						setState(887);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(886);
							match(NL);
							}
						}

						setState(889);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(890);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(891);
						((BinaryExpContext)_localctx).op = match(T__94);
						setState(893);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(892);
							match(NL);
							}
						}

						setState(895);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(900);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,120,_ctx);
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
			setState(954);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(901);
				((LoopInvariantContext)_localctx).tb = match(T__3);
				setState(905);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(902);
					match(NL);
					}
					}
					setState(907);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(908);
				modifies();
				setState(909);
				((LoopInvariantContext)_localctx).te = match(T__4);
				setState(913);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(910);
					match(NL);
					}
					}
					setState(915);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(916);
				((LoopInvariantContext)_localctx).tb = match(T__3);
				setState(920);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(917);
					match(NL);
					}
					}
					setState(922);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(923);
				((LoopInvariantContext)_localctx).itb = match(T__143);
				setState(927);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(924);
					match(NL);
					}
					}
					setState(929);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(930);
				formula(0);
				setState(941);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(932); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(931);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(934); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(937);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
						{
						setState(936);
						formula(0);
						}
					}

					}
					}
					setState(943);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(945);
				_la = _input.LA(1);
				if (_la==T__164) {
					{
					setState(944);
					modifies();
					}
				}

				setState(947);
				((LoopInvariantContext)_localctx).te = match(T__4);
				setState(951);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(948);
					match(NL);
					}
					}
					setState(953);
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
			setState(956);
			((ModifiesContext)_localctx).tb = match(T__164);
			setState(957);
			match(ID);
			setState(962);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(958);
				match(T__0);
				setState(959);
				match(ID);
				}
				}
				setState(964);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(968);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(965);
					match(NL);
					}
					} 
				}
				setState(970);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
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
			setState(971);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(975);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(972);
					match(NL);
					}
					} 
				}
				setState(977);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
			}
			setState(999);
			_la = _input.LA(1);
			if (_la==T__165 || _la==T__166) {
				{
				setState(978);
				_la = _input.LA(1);
				if ( !(_la==T__165 || _la==T__166) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
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
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(996);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(987); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(986);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(989); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(992);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
							{
							setState(991);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(998);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
				}
				}
			}

			setState(1004);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1001);
					match(NL);
					}
					} 
				}
				setState(1006);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
			}
			setState(1008);
			_la = _input.LA(1);
			if (_la==T__164) {
				{
				setState(1007);
				modifies();
				}
			}

			setState(1031);
			_la = _input.LA(1);
			if (_la==T__167 || _la==T__168) {
				{
				setState(1010);
				_la = _input.LA(1);
				if ( !(_la==T__167 || _la==T__168) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1014);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1011);
					match(NL);
					}
					}
					setState(1016);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1017);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(1028);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1019); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1018);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1021); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(1024);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
							{
							setState(1023);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(1030);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
				}
				}
			}

			setState(1036);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1033);
				match(NL);
				}
				}
				setState(1038);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1039);
			((MethodContractContext)_localctx).te = match(T__4);
			setState(1043);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1040);
					match(NL);
					}
					} 
				}
				setState(1045);
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
			setState(1046);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(1050);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1047);
				match(NL);
				}
				}
				setState(1052);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1053);
			match(T__143);
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
			formula(0);
			setState(1071);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
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
					_alt = getInterpreter().adaptivePredict(_input,150,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1067);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__82 - 67)) | (1L << (T__83 - 67)) | (1L << (T__84 - 67)) | (1L << (T__85 - 67)) | (1L << (T__86 - 67)) | (1L << (T__100 - 67)) | (1L << (T__101 - 67)) | (1L << (T__102 - 67)) | (1L << (T__103 - 67)) | (1L << (T__104 - 67)) | (1L << (T__105 - 67)) | (1L << (T__106 - 67)) | (1L << (T__107 - 67)))) != 0) || ((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & ((1L << (NUM - 171)) | (1L << (ID - 171)) | (1L << (REAL - 171)) | (1L << (INT - 171)) | (1L << (FLOAT - 171)))) != 0)) {
					{
					setState(1066);
					formula(0);
					}
				}

				}
				}
				setState(1073);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1074);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(1078);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1075);
				match(NL);
				}
				}
				setState(1080);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u00b8\u043c\4\2\t"+
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
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00c7\n\6\f\6\16\6\u00ca\13\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00d4\n\6\f\6\16\6\u00d7\13\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00e8\n\6\f"+
		"\6\16\6\u00eb\13\6\5\6\u00ed\n\6\3\6\5\6\u00f0\n\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\7\7\u00fa\n\7\f\7\16\7\u00fd\13\7\3\7\5\7\u0100\n\7\3\7\3"+
		"\7\3\7\5\7\u0105\n\7\3\7\3\7\3\7\3\7\5\7\u010b\n\7\3\7\3\7\3\7\3\7\5\7"+
		"\u0111\n\7\3\7\3\7\3\7\3\7\5\7\u0117\n\7\3\7\3\7\3\7\3\7\5\7\u011d\n\7"+
		"\3\7\3\7\3\7\3\7\5\7\u0123\n\7\3\7\3\7\3\7\3\7\5\7\u0129\n\7\3\7\3\7\3"+
		"\7\3\7\5\7\u012f\n\7\3\7\3\7\3\7\3\7\5\7\u0135\n\7\3\7\3\7\3\7\3\7\5\7"+
		"\u013b\n\7\3\7\7\7\u013e\n\7\f\7\16\7\u0141\13\7\3\b\3\b\3\b\3\b\7\b\u0147"+
		"\n\b\f\b\16\b\u014a\13\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0152\n\b\3\b\3\b"+
		"\5\b\u0156\n\b\3\b\3\b\3\b\5\b\u015b\n\b\3\b\5\b\u015e\n\b\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\5\n\u0168\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u016f\n\n\3"+
		"\n\3\n\3\n\3\n\5\n\u0175\n\n\3\n\3\n\3\n\3\n\5\n\u017b\n\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u019f\n\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u01ac\n\n\f\n\16\n\u01af"+
		"\13\n\3\n\3\n\3\n\3\n\3\n\6\n\u01b6\n\n\r\n\16\n\u01b7\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\6\n\u01c3\n\n\r\n\16\n\u01c4\3\n\3\n\3\n\6\n\u01ca"+
		"\n\n\r\n\16\n\u01cb\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u01d6\n\n\r\n"+
		"\16\n\u01d7\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u01e4\n\n\f\n"+
		"\16\n\u01e7\13\n\5\n\u01e9\n\n\3\13\7\13\u01ec\n\13\f\13\16\13\u01ef\13"+
		"\13\3\13\3\13\6\13\u01f3\n\13\r\13\16\13\u01f4\3\13\3\13\5\13\u01f9\n"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\7\r\u0206\n\r\f\r\16\r"+
		"\u0209\13\r\3\r\3\r\7\r\u020d\n\r\f\r\16\r\u0210\13\r\3\r\3\r\6\r\u0214"+
		"\n\r\r\r\16\r\u0215\3\r\5\r\u0219\n\r\7\r\u021b\n\r\f\r\16\r\u021e\13"+
		"\r\3\r\3\r\7\r\u0222\n\r\f\r\16\r\u0225\13\r\3\16\3\16\5\16\u0229\n\16"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u0232\n\20\3\20\3\20\3\20\3\20"+
		"\7\20\u0238\n\20\f\20\16\20\u023b\13\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\22\5\22\u0246\n\22\3\22\6\22\u0249\n\22\r\22\16\22\u024a"+
		"\3\22\5\22\u024e\n\22\7\22\u0250\n\22\f\22\16\22\u0253\13\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u025b\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u0262"+
		"\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\7\23\u0274\n\23\f\23\16\23\u0277\13\23\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u027e\n\23\f\23\16\23\u0281\13\23\3\23\3\23\3\23\3\23"+
		"\5\23\u0287\n\23\3\23\3\23\3\23\3\23\3\23\7\23\u028e\n\23\f\23\16\23\u0291"+
		"\13\23\3\23\3\23\7\23\u0295\n\23\f\23\16\23\u0298\13\23\3\23\3\23\3\23"+
		"\3\23\5\23\u029e\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u02a8"+
		"\n\23\f\23\16\23\u02ab\13\23\5\23\u02ad\n\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u02b6\n\23\3\23\3\23\3\23\3\23\5\23\u02bc\n\23\3\23\3"+
		"\23\3\23\5\23\u02c1\n\23\3\23\3\23\3\23\3\23\7\23\u02c7\n\23\f\23\16\23"+
		"\u02ca\13\23\5\23\u02cc\n\23\3\23\3\23\3\23\3\23\5\23\u02d2\n\23\3\23"+
		"\3\23\7\23\u02d6\n\23\f\23\16\23\u02d9\13\23\3\23\3\23\7\23\u02dd\n\23"+
		"\f\23\16\23\u02e0\13\23\3\23\3\23\3\23\7\23\u02e5\n\23\f\23\16\23\u02e8"+
		"\13\23\3\23\3\23\5\23\u02ec\n\23\3\23\3\23\3\23\5\23\u02f1\n\23\3\23\7"+
		"\23\u02f4\n\23\f\23\16\23\u02f7\13\23\5\23\u02f9\n\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u0302\n\23\3\23\3\23\3\23\3\23\5\23\u0308\n\23"+
		"\3\24\3\24\5\24\u030c\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\7\25\u031c\n\25\f\25\16\25\u031f\13\25\5\25"+
		"\u0321\n\25\3\25\5\25\u0324\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\7\26\u032e\n\26\f\26\16\26\u0331\13\26\5\26\u0333\n\26\3\26\3\26\3"+
		"\26\3\26\7\26\u0339\n\26\f\26\16\26\u033c\13\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\5\26\u0344\n\26\3\26\3\26\3\26\3\26\3\26\5\26\u034b\n\26\3\26"+
		"\3\26\3\26\5\26\u0350\n\26\3\26\3\26\3\26\3\26\5\26\u0356\n\26\3\26\3"+
		"\26\3\26\3\26\5\26\u035c\n\26\3\26\3\26\3\26\3\26\5\26\u0362\n\26\3\26"+
		"\3\26\3\26\3\26\5\26\u0368\n\26\3\26\3\26\3\26\3\26\5\26\u036e\n\26\3"+
		"\26\3\26\3\26\3\26\5\26\u0374\n\26\3\26\3\26\3\26\3\26\5\26\u037a\n\26"+
		"\3\26\3\26\3\26\3\26\5\26\u0380\n\26\3\26\7\26\u0383\n\26\f\26\16\26\u0386"+
		"\13\26\3\27\3\27\7\27\u038a\n\27\f\27\16\27\u038d\13\27\3\27\3\27\3\27"+
		"\7\27\u0392\n\27\f\27\16\27\u0395\13\27\3\27\3\27\7\27\u0399\n\27\f\27"+
		"\16\27\u039c\13\27\3\27\3\27\7\27\u03a0\n\27\f\27\16\27\u03a3\13\27\3"+
		"\27\3\27\6\27\u03a7\n\27\r\27\16\27\u03a8\3\27\5\27\u03ac\n\27\7\27\u03ae"+
		"\n\27\f\27\16\27\u03b1\13\27\3\27\5\27\u03b4\n\27\3\27\3\27\7\27\u03b8"+
		"\n\27\f\27\16\27\u03bb\13\27\5\27\u03bd\n\27\3\30\3\30\3\30\3\30\7\30"+
		"\u03c3\n\30\f\30\16\30\u03c6\13\30\3\30\7\30\u03c9\n\30\f\30\16\30\u03cc"+
		"\13\30\3\31\3\31\7\31\u03d0\n\31\f\31\16\31\u03d3\13\31\3\31\3\31\7\31"+
		"\u03d7\n\31\f\31\16\31\u03da\13\31\3\31\3\31\6\31\u03de\n\31\r\31\16\31"+
		"\u03df\3\31\5\31\u03e3\n\31\7\31\u03e5\n\31\f\31\16\31\u03e8\13\31\5\31"+
		"\u03ea\n\31\3\31\7\31\u03ed\n\31\f\31\16\31\u03f0\13\31\3\31\5\31\u03f3"+
		"\n\31\3\31\3\31\7\31\u03f7\n\31\f\31\16\31\u03fa\13\31\3\31\3\31\6\31"+
		"\u03fe\n\31\r\31\16\31\u03ff\3\31\5\31\u0403\n\31\7\31\u0405\n\31\f\31"+
		"\16\31\u0408\13\31\5\31\u040a\n\31\3\31\7\31\u040d\n\31\f\31\16\31\u0410"+
		"\13\31\3\31\3\31\7\31\u0414\n\31\f\31\16\31\u0417\13\31\3\32\3\32\7\32"+
		"\u041b\n\32\f\32\16\32\u041e\13\32\3\32\3\32\7\32\u0422\n\32\f\32\16\32"+
		"\u0425\13\32\3\32\3\32\6\32\u0429\n\32\r\32\16\32\u042a\3\32\5\32\u042e"+
		"\n\32\7\32\u0430\n\32\f\32\16\32\u0433\13\32\3\32\3\32\7\32\u0437\n\32"+
		"\f\32\16\32\u043a\13\32\3\32\2\4\f*\33\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\2\'\3\2\4\5\3\2\13\21\3\2\25*\3\2+@\3\2UY\3\2AC"+
		"\3\2DE\3\2HP\3\2QT\3\2Z]\3\2^_\3\2`c\3\2df\3\2gn\3\2\25@\3\2[]\3\2rs\3"+
		"\2tw\4\2aacc\3\2xy\3\2ef\3\2|}\3\2~\177\3\2WY\3\2\u0080\u0081\3\2\20\21"+
		"\3\2\u0086\u0088\3\2\u0089\u008b\3\2\u008c\u008e\3\2\u008f\u0091\3\2\u0098"+
		"\u0099\3\2\u00a0\u00a1\4\2EEWX\5\2HIKLNP\3\2RS\3\2\u00a8\u00a9\3\2\u00aa"+
		"\u00ab\u050a\2I\3\2\2\2\4j\3\2\2\2\6l\3\2\2\2\b\u00ba\3\2\2\2\n\u00ef"+
		"\3\2\2\2\f\u00ff\3\2\2\2\16\u0142\3\2\2\2\20\u0161\3\2\2\2\22\u01e8\3"+
		"\2\2\2\24\u01ed\3\2\2\2\26\u01fa\3\2\2\2\30\u0203\3\2\2\2\32\u0228\3\2"+
		"\2\2\34\u022a\3\2\2\2\36\u022e\3\2\2\2 \u0240\3\2\2\2\"\u0245\3\2\2\2"+
		"$\u0307\3\2\2\2&\u030b\3\2\2\2(\u0323\3\2\2\2*\u034a\3\2\2\2,\u03bc\3"+
		"\2\2\2.\u03be\3\2\2\2\60\u03cd\3\2\2\2\62\u0418\3\2\2\2\648\5\4\3\2\65"+
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
		"\2\2\u00ba\u0084\3\2\2\2\u00ba\u0089\3\2\2\2\u00bb\t\3\2\2\2\u00bc\u00f0"+
		"\t\3\2\2\u00bd\u00be\7\22\2\2\u00be\u00bf\5\f\7\2\u00bf\u00c0\7\23\2\2"+
		"\u00c0\u00f0\3\2\2\2\u00c1\u00c2\7\24\2\2\u00c2\u00c3\7\22\2\2\u00c3\u00c8"+
		"\5\f\7\2\u00c4\u00c5\7\3\2\2\u00c5\u00c7\5\f\7\2\u00c6\u00c4\3\2\2\2\u00c7"+
		"\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2"+
		"\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\7\23\2\2\u00cc\u00f0\3\2\2\2\u00cd"+
		"\u00f0\7\24\2\2\u00ce\u00cf\7\u00ae\2\2\u00cf\u00d0\7\22\2\2\u00d0\u00d5"+
		"\5\f\7\2\u00d1\u00d2\7\3\2\2\u00d2\u00d4\5\f\7\2\u00d3\u00d1\3\2\2\2\u00d4"+
		"\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2"+
		"\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\7\23\2\2\u00d9\u00f0\3\2\2\2\u00da"+
		"\u00f0\7\u00ae\2\2\u00db\u00f0\7\u00ad\2\2\u00dc\u00f0\7\u00b0\2\2\u00dd"+
		"\u00f0\7\u00af\2\2\u00de\u00f0\7\u00b7\2\2\u00df\u00e0\t\4\2\2\u00e0\u00e1"+
		"\7\b\2\2\u00e1\u00f0\7\u00ae\2\2\u00e2\u00e3\t\5\2\2\u00e3\u00ec\7\22"+
		"\2\2\u00e4\u00e9\5*\26\2\u00e5\u00e6\7\3\2\2\u00e6\u00e8\5*\26\2\u00e7"+
		"\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00e4\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\7\23\2\2\u00ef\u00bc\3"+
		"\2\2\2\u00ef\u00bd\3\2\2\2\u00ef\u00c1\3\2\2\2\u00ef\u00cd\3\2\2\2\u00ef"+
		"\u00ce\3\2\2\2\u00ef\u00da\3\2\2\2\u00ef\u00db\3\2\2\2\u00ef\u00dc\3\2"+
		"\2\2\u00ef\u00dd\3\2\2\2\u00ef\u00de\3\2\2\2\u00ef\u00df\3\2\2\2\u00ef"+
		"\u00e2\3\2\2\2\u00f0\13\3\2\2\2\u00f1\u00f2\b\7\1\2\u00f2\u00f3\7E\2\2"+
		"\u00f3\u0100\5\f\7\t\u00f4\u00f5\t\6\2\2\u00f5\u0100\5\f\7\b\u00f6\u00fb"+
		"\5\n\6\2\u00f7\u00f8\7\b\2\2\u00f8\u00fa\7\u00ae\2\2\u00f9\u00f7\3\2\2"+
		"\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u0100"+
		"\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0100\5\16\b\2\u00ff\u00f1\3\2\2\2"+
		"\u00ff\u00f4\3\2\2\2\u00ff\u00f6\3\2\2\2\u00ff\u00fe\3\2\2\2\u0100\u013f"+
		"\3\2\2\2\u0101\u0102\f\17\2\2\u0102\u0104\t\7\2\2\u0103\u0105\7\u00b2"+
		"\2\2\u0104\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\u013e\5\f\7\20\u0107\u0108\f\16\2\2\u0108\u010a\t\b\2\2\u0109\u010b\7"+
		"\u00b2\2\2\u010a\u0109\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2"+
		"\u010c\u013e\5\f\7\17\u010d\u010e\f\r\2\2\u010e\u0110\7F\2\2\u010f\u0111"+
		"\7\u00b2\2\2\u0110\u010f\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\3\2\2"+
		"\2\u0112\u013e\5\f\7\r\u0113\u0114\f\f\2\2\u0114\u0116\7G\2\2\u0115\u0117"+
		"\7\u00b2\2\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2"+
		"\2\u0118\u013e\5\f\7\r\u0119\u011a\f\13\2\2\u011a\u011c\t\t\2\2\u011b"+
		"\u011d\7\u00b2\2\2\u011c\u011b\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e"+
		"\3\2\2\2\u011e\u013e\5\f\7\f\u011f\u0120\f\n\2\2\u0120\u0122\t\n\2\2\u0121"+
		"\u0123\7\u00b2\2\2\u0122\u0121\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124"+
		"\3\2\2\2\u0124\u013e\5\f\7\13\u0125\u0126\f\7\2\2\u0126\u0128\t\13\2\2"+
		"\u0127\u0129\7\u00b2\2\2\u0128\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u013e\5\f\7\b\u012b\u012c\f\6\2\2\u012c\u012e\t\f"+
		"\2\2\u012d\u012f\7\u00b2\2\2\u012e\u012d\3\2\2\2\u012e\u012f\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u013e\5\f\7\7\u0131\u0132\f\5\2\2\u0132\u0134\t\r"+
		"\2\2\u0133\u0135\7\u00b2\2\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\u0136\3\2\2\2\u0136\u013e\5\f\7\6\u0137\u0138\f\4\2\2\u0138\u013a\t\16"+
		"\2\2\u0139\u013b\7\u00b2\2\2\u013a\u0139\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013e\5\f\7\4\u013d\u0101\3\2\2\2\u013d\u0107\3\2"+
		"\2\2\u013d\u010d\3\2\2\2\u013d\u0113\3\2\2\2\u013d\u0119\3\2\2\2\u013d"+
		"\u011f\3\2\2\2\u013d\u0125\3\2\2\2\u013d\u012b\3\2\2\2\u013d\u0131\3\2"+
		"\2\2\u013d\u0137\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f"+
		"\u0140\3\2\2\2\u0140\r\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0143\t\17\2"+
		"\2\u0143\u0148\7\u00ae\2\2\u0144\u0145\7\3\2\2\u0145\u0147\7\u00ae\2\2"+
		"\u0146\u0144\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149"+
		"\3\2\2\2\u0149\u015a\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u014c\7\t\2\2\u014c"+
		"\u015b\5\20\t\2\u014d\u014e\7\t\2\2\u014e\u014f\7\22\2\2\u014f\u0151\5"+
		"*\26\2\u0150\u0152\7H\2\2\u0151\u0150\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0155\7o\2\2\u0154\u0156\7H\2\2\u0155\u0154\3\2\2"+
		"\2\u0155\u0156\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\5*\26\2\u0158\u0159"+
		"\7\23\2\2\u0159\u015b\3\2\2\2\u015a\u014b\3\2\2\2\u015a\u014d\3\2\2\2"+
		"\u015a\u015b\3\2\2\2\u015b\u015d\3\2\2\2\u015c\u015e\7\u00b2\2\2\u015d"+
		"\u015c\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\5\f"+
		"\7\2\u0160\17\3\2\2\2\u0161\u0162\t\20\2\2\u0162\21\3\2\2\2\u0163\u01e9"+
		"\7p\2\2\u0164\u0168\7q\2\2\u0165\u0166\t\21\2\2\u0166\u0168\7\u00ae\2"+
		"\2\u0167\u0164\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a"+
		"\7\u00ad\2\2\u016a\u01e9\7\u00ad\2\2\u016b\u016f\t\22\2\2\u016c\u016d"+
		"\t\21\2\2\u016d\u016f\7\u00ae\2\2\u016e\u016b\3\2\2\2\u016e\u016c\3\2"+
		"\2\2\u016f\u0170\3\2\2\2\u0170\u01e9\7\u00ad\2\2\u0171\u0175\t\23\2\2"+
		"\u0172\u0173\t\24\2\2\u0173\u0175\7\u00ae\2\2\u0174\u0171\3\2\2\2\u0174"+
		"\u0172\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u01e9\7\u00ad\2\2\u0177\u017b"+
		"\t\25\2\2\u0178\u0179\t\24\2\2\u0179\u017b\7\u00ae\2\2\u017a\u0177\3\2"+
		"\2\2\u017a\u0178\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017d\7\u00ad\2\2\u017d"+
		"\u017e\7\u00ad\2\2\u017e\u01e9\7\u00ad\2\2\u017f\u0180\7z\2\2\u0180\u01e9"+
		"\7\u00ad\2\2\u0181\u0182\7{\2\2\u0182\u0183\7\u00ad\2\2\u0183\u01e9\7"+
		"\u00ad\2\2\u0184\u0185\6\n\f\2\u0185\u0186\t\26\2\2\u0186\u0187\7\u00ae"+
		"\2\2\u0187\u01e9\7\u00ad\2\2\u0188\u0189\6\n\r\2\u0189\u018a\t\26\2\2"+
		"\u018a\u018b\7\u00ae\2\2\u018b\u018c\7\u00ad\2\2\u018c\u01e9\7\u00ad\2"+
		"\2\u018d\u018e\t\27\2\2\u018e\u01e9\7\u00ad\2\2\u018f\u0190\t\30\2\2\u0190"+
		"\u0191\7\u00ad\2\2\u0191\u01e9\7\u00ad\2\2\u0192\u0193\6\n\16\2\u0193"+
		"\u0194\t\31\2\2\u0194\u0195\7\u00ae\2\2\u0195\u01e9\7\u00ad\2\2\u0196"+
		"\u0197\6\n\17\2\u0197\u0198\t\31\2\2\u0198\u0199\7\u00ae\2\2\u0199\u019a"+
		"\7\u00ad\2\2\u019a\u01e9\7\u00ad\2\2\u019b\u019f\t\32\2\2\u019c\u019d"+
		"\t\33\2\2\u019d\u019f\7\u00ae\2\2\u019e\u019b\3\2\2\2\u019e\u019c\3\2"+
		"\2\2\u019f\u01a0\3\2\2\2\u01a0\u01e9\7\u00ad\2\2\u01a1\u01a2\7\u0082\2"+
		"\2\u01a2\u01e9\7\u00ad\2\2\u01a3\u01a4\7\u0083\2\2\u01a4\u01a5\7\u00ad"+
		"\2\2\u01a5\u01e9\7\u00ad\2\2\u01a6\u01a7\7\u0084\2\2\u01a7\u01a8\7\u00ad"+
		"\2\2\u01a8\u01e9\7\u00ad\2\2\u01a9\u01ad\7\u0085\2\2\u01aa\u01ac\7\u00ad"+
		"\2\2\u01ab\u01aa\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01e9\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b1\t\34"+
		"\2\2\u01b1\u01e9\7\u00ad\2\2\u01b2\u01b3\t\35\2\2\u01b3\u01b5\7\u00ad"+
		"\2\2\u01b4\u01b6\5\f\7\2\u01b5\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7"+
		"\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01e9\3\2\2\2\u01b9\u01ba\6\n"+
		"\20\2\u01ba\u01bb\7j\2\2\u01bb\u01bc\7\u00ae\2\2\u01bc\u01e9\7\u00ad\2"+
		"\2\u01bd\u01be\6\n\21\2\u01be\u01bf\7j\2\2\u01bf\u01c0\7\u00ae\2\2\u01c0"+
		"\u01c2\7\u00ad\2\2\u01c1\u01c3\5\f\7\2\u01c2\u01c1\3\2\2\2\u01c3\u01c4"+
		"\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01e9\3\2\2\2\u01c6"+
		"\u01c7\t\36\2\2\u01c7\u01c9\7\u00ad\2\2\u01c8\u01ca\5\f\7\2\u01c9\u01c8"+
		"\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc"+
		"\u01e9\3\2\2\2\u01cd\u01ce\t\37\2\2\u01ce\u01cf\7\u00ad\2\2\u01cf\u01e9"+
		"\7\u00ad\2\2\u01d0\u01d1\6\n\22\2\u01d1\u01d2\7n\2\2\u01d2\u01d3\7\u00ae"+
		"\2\2\u01d3\u01d5\7\u00ad\2\2\u01d4\u01d6\5\f\7\2\u01d5\u01d4\3\2\2\2\u01d6"+
		"\u01d7\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01e9\3\2"+
		"\2\2\u01d9\u01da\6\n\23\2\u01da\u01db\7n\2\2\u01db\u01dc\7\u00ae\2\2\u01dc"+
		"\u01dd\7\u00ad\2\2\u01dd\u01e9\7\u00ad\2\2\u01de\u01e9\7\u0092\2\2\u01df"+
		"\u01e0\7\u0093\2\2\u01e0\u01e9\7\u00ae\2\2\u01e1\u01e5\7\u0094\2\2\u01e2"+
		"\u01e4\7\u00ad\2\2\u01e3\u01e2\3\2\2\2\u01e4\u01e7\3\2\2\2\u01e5\u01e3"+
		"\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e8"+
		"\u0163\3\2\2\2\u01e8\u0167\3\2\2\2\u01e8\u016e\3\2\2\2\u01e8\u0174\3\2"+
		"\2\2\u01e8\u017a\3\2\2\2\u01e8\u017f\3\2\2\2\u01e8\u0181\3\2\2\2\u01e8"+
		"\u0184\3\2\2\2\u01e8\u0188\3\2\2\2\u01e8\u018d\3\2\2\2\u01e8\u018f\3\2"+
		"\2\2\u01e8\u0192\3\2\2\2\u01e8\u0196\3\2\2\2\u01e8\u019e\3\2\2\2\u01e8"+
		"\u01a1\3\2\2\2\u01e8\u01a3\3\2\2\2\u01e8\u01a6\3\2\2\2\u01e8\u01a9\3\2"+
		"\2\2\u01e8\u01b0\3\2\2\2\u01e8\u01b2\3\2\2\2\u01e8\u01b9\3\2\2\2\u01e8"+
		"\u01bd\3\2\2\2\u01e8\u01c6\3\2\2\2\u01e8\u01cd\3\2\2\2\u01e8\u01d0\3\2"+
		"\2\2\u01e8\u01d9\3\2\2\2\u01e8\u01de\3\2\2\2\u01e8\u01df\3\2\2\2\u01e8"+
		"\u01e1\3\2\2\2\u01e9\23\3\2\2\2\u01ea\u01ec\7\u00b2\2\2\u01eb\u01ea\3"+
		"\2\2\2\u01ec\u01ef\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee"+
		"\u01f8\3\2\2\2\u01ef\u01ed\3\2\2\2\u01f0\u01f2\5\26\f\2\u01f1\u01f3\7"+
		"\u00b2\2\2\u01f2\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f2\3\2\2\2"+
		"\u01f4\u01f5\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f7\5\"\22\2\u01f7\u01f9"+
		"\3\2\2\2\u01f8\u01f0\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\25\3\2\2\2\u01fa"+
		"\u01fb\7\u0095\2\2\u01fb\u01fc\7\u00ae\2\2\u01fc\u01fd\7\b\2\2\u01fd\u01fe"+
		"\7\u00ae\2\2\u01fe\u01ff\7\b\2\2\u01ff\u0200\7\u00ae\2\2\u0200\u0201\7"+
		"\b\2\2\u0201\u0202\7\u0096\2\2\u0202\27\3\2\2\2\u0203\u0207\7\6\2\2\u0204"+
		"\u0206\7\u00b2\2\2\u0205\u0204\3\2\2\2\u0206\u0209\3\2\2\2\u0207\u0205"+
		"\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u020a\3\2\2\2\u0209\u0207\3\2\2\2\u020a"+
		"\u020e\7\u0093\2\2\u020b\u020d\7\u00b2\2\2\u020c\u020b\3\2\2\2\u020d\u0210"+
		"\3\2\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0211\3\2\2\2\u0210"+
		"\u020e\3\2\2\2\u0211\u021c\5\32\16\2\u0212\u0214\7\u00b2\2\2\u0213\u0212"+
		"\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216"+
		"\u0218\3\2\2\2\u0217\u0219\5\32\16\2\u0218\u0217\3\2\2\2\u0218\u0219\3"+
		"\2\2\2\u0219\u021b\3\2\2\2\u021a\u0213\3\2\2\2\u021b\u021e\3\2\2\2\u021c"+
		"\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021f\3\2\2\2\u021e\u021c\3\2"+
		"\2\2\u021f\u0223\7\7\2\2\u0220\u0222\7\u00b2\2\2\u0221\u0220\3\2\2\2\u0222"+
		"\u0225\3\2\2\2\u0223\u0221\3\2\2\2\u0223\u0224\3\2\2\2\u0224\31\3\2\2"+
		"\2\u0225\u0223\3\2\2\2\u0226\u0229\5\34\17\2\u0227\u0229\5\36\20\2\u0228"+
		"\u0226\3\2\2\2\u0228\u0227\3\2\2\2\u0229\33\3\2\2\2\u022a\u022b\7\u00ae"+
		"\2\2\u022b\u022c\7\b\2\2\u022c\u022d\5\f\7\2\u022d\35\3\2\2\2\u022e\u022f"+
		"\7\u0097\2\2\u022f\u0231\7\u00ae\2\2\u0230\u0232\7\u00b2\2\2\u0231\u0230"+
		"\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0234\7\22\2\2"+
		"\u0234\u0239\5 \21\2\u0235\u0236\7\3\2\2\u0236\u0238\5 \21\2\u0237\u0235"+
		"\3\2\2\2\u0238\u023b\3\2\2\2\u0239\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023a"+
		"\u023c\3\2\2\2\u023b\u0239\3\2\2\2\u023c\u023d\7\23\2\2\u023d\u023e\7"+
		"\t\2\2\u023e\u023f\5\20\t\2\u023f\37\3\2\2\2\u0240\u0241\7\u00ae\2\2\u0241"+
		"\u0242\7\t\2\2\u0242\u0243\5\20\t\2\u0243!\3\2\2\2\u0244\u0246\5$\23\2"+
		"\u0245\u0244\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u0251\3\2\2\2\u0247\u0249"+
		"\7\u00b2\2\2\u0248\u0247\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u0248\3\2\2"+
		"\2\u024a\u024b\3\2\2\2\u024b\u024d\3\2\2\2\u024c\u024e\5$\23\2\u024d\u024c"+
		"\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u0250\3\2\2\2\u024f\u0248\3\2\2\2\u0250"+
		"\u0253\3\2\2\2\u0251\u024f\3\2\2\2\u0251\u0252\3\2\2\2\u0252#\3\2\2\2"+
		"\u0253\u0251\3\2\2\2\u0254\u0255\t \2\2\u0255\u0256\7\u00ae\2\2\u0256"+
		"\u0257\7\t\2\2\u0257\u0258\5\20\t\2\u0258\u025a\7Q\2\2\u0259\u025b\7\u00b2"+
		"\2\2\u025a\u0259\3\2\2\2\u025a\u025b\3\2\2\2\u025b\u025c\3\2\2\2\u025c"+
		"\u025d\5*\26\2\u025d\u0308\3\2\2\2\u025e\u025f\7\u00ae\2\2\u025f\u0261"+
		"\7Q\2\2\u0260\u0262\7\u00b2\2\2\u0261\u0260\3\2\2\2\u0261\u0262\3\2\2"+
		"\2\u0262\u0263\3\2\2\2\u0263\u0308\5*\26\2\u0264\u0265\7\n\2\2\u0265\u0266"+
		"\7\22\2\2\u0266\u0267\5*\26\2\u0267\u0268\7\23\2\2\u0268\u0308\3\2\2\2"+
		"\u0269\u026a\7\u009a\2\2\u026a\u026b\7\22\2\2\u026b\u026c\5*\26\2\u026c"+
		"\u026d\7\23\2\2\u026d\u0308\3\2\2\2\u026e\u026f\7\u009b\2\2\u026f\u0270"+
		"\7\22\2\2\u0270\u0271\5*\26\2\u0271\u0275\7\23\2\2\u0272\u0274\7\u00b2"+
		"\2\2\u0273\u0272\3\2\2\2\u0274\u0277\3\2\2\2\u0275\u0273\3\2\2\2\u0275"+
		"\u0276\3\2\2\2\u0276\u0278\3\2\2\2\u0277\u0275\3\2\2\2\u0278\u0279\7\6"+
		"\2\2\u0279\u027a\5\"\22\2\u027a\u0286\7\7\2\2\u027b\u027f\7\u009c\2\2"+
		"\u027c\u027e\7\u00b2\2\2\u027d\u027c\3\2\2\2\u027e\u0281\3\2\2\2\u027f"+
		"\u027d\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u0282\3\2\2\2\u0281\u027f\3\2"+
		"\2\2\u0282\u0283\7\6\2\2\u0283\u0284\5\"\22\2\u0284\u0285\7\7\2\2\u0285"+
		"\u0287\3\2\2\2\u0286\u027b\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0308\3\2"+
		"\2\2\u0288\u0289\7\u009d\2\2\u0289\u028a\7\22\2\2\u028a\u028b\5*\26\2"+
		"\u028b\u028f\7\23\2\2\u028c\u028e\7\u00b2\2\2\u028d\u028c\3\2\2\2\u028e"+
		"\u0291\3\2\2\2\u028f\u028d\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0292\3\2"+
		"\2\2\u0291\u028f\3\2\2\2\u0292\u029d\7\6\2\2\u0293\u0295\7\u00b2\2\2\u0294"+
		"\u0293\3\2\2\2\u0295\u0298\3\2\2\2\u0296\u0294\3\2\2\2\u0296\u0297\3\2"+
		"\2\2\u0297\u0299\3\2\2\2\u0298\u0296\3\2\2\2\u0299\u029a\7\u009e\2\2\u029a"+
		"\u029b\5,\27\2\u029b\u029c\7\u009f\2\2\u029c\u029e\3\2\2\2\u029d\u0296"+
		"\3\2\2\2\u029d\u029e\3\2\2\2\u029e\u029f\3\2\2\2\u029f\u02a0\5\"\22\2"+
		"\u02a0\u02a1\7\7\2\2\u02a1\u0308\3\2\2\2\u02a2\u02a3\t!\2\2\u02a3\u02ac"+
		"\7\22\2\2\u02a4\u02a9\5&\24\2\u02a5\u02a6\7\3\2\2\u02a6\u02a8\5&\24\2"+
		"\u02a7\u02a5\3\2\2\2\u02a8\u02ab\3\2\2\2\u02a9\u02a7\3\2\2\2\u02a9\u02aa"+
		"\3\2\2\2\u02aa\u02ad\3\2\2\2\u02ab\u02a9\3\2\2\2\u02ac\u02a4\3\2\2\2\u02ac"+
		"\u02ad\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u0308\7\23\2\2\u02af\u02b0\7"+
		"\u00ae\2\2\u02b0\u02b1\7\22\2\2\u02b1\u02b2\5*\26\2\u02b2\u02b3\7\23\2"+
		"\2\u02b3\u02b5\7Q\2\2\u02b4\u02b6\7\u00b2\2\2\u02b5\u02b4\3\2\2\2\u02b5"+
		"\u02b6\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b8\5*\26\2\u02b8\u0308\3\2"+
		"\2\2\u02b9\u02ba\7\u00a2\2\2\u02ba\u02bc\7\u00ae\2\2\u02bb\u02b9\3\2\2"+
		"\2\u02bb\u02bc\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02be\7\u0097\2\2\u02be"+
		"\u02c0\7\u00ae\2\2\u02bf\u02c1\7\u00b2\2\2\u02c0\u02bf\3\2\2\2\u02c0\u02c1"+
		"\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u02cb\7\22\2\2\u02c3\u02c8\5 \21\2"+
		"\u02c4\u02c5\7\3\2\2\u02c5\u02c7\5 \21\2\u02c6\u02c4\3\2\2\2\u02c7\u02ca"+
		"\3\2\2\2\u02c8\u02c6\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9\u02cc\3\2\2\2\u02ca"+
		"\u02c8\3\2\2\2\u02cb\u02c3\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02cd\3\2"+
		"\2\2\u02cd\u02ce\7\23\2\2\u02ce\u02d1\7\t\2\2\u02cf\u02d2\5\20\t\2\u02d0"+
		"\u02d2\7\u00a3\2\2\u02d1\u02cf\3\2\2\2\u02d1\u02d0\3\2\2\2\u02d2\u02d3"+
		"\3\2\2\2\u02d3\u02d7\7Q\2\2\u02d4\u02d6\7\u00b2\2\2\u02d5\u02d4\3\2\2"+
		"\2\u02d6\u02d9\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02da"+
		"\3\2\2\2\u02d9\u02d7\3\2\2\2\u02da\u02eb\7\6\2\2\u02db\u02dd\7\u00b2\2"+
		"\2\u02dc\u02db\3\2\2\2\u02dd\u02e0\3\2\2\2\u02de\u02dc\3\2\2\2\u02de\u02df"+
		"\3\2\2\2\u02df\u02e1\3\2\2\2\u02e0\u02de\3\2\2\2\u02e1\u02e2\7\u009e\2"+
		"\2\u02e2\u02e6\5\60\31\2\u02e3\u02e5\7\u00b2\2\2\u02e4\u02e3\3\2\2\2\u02e5"+
		"\u02e8\3\2\2\2\u02e6\u02e4\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02e9\3\2"+
		"\2\2\u02e8\u02e6\3\2\2\2\u02e9\u02ea\7\u009f\2\2\u02ea\u02ec\3\2\2\2\u02eb"+
		"\u02de\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u02f8\5\""+
		"\22\2\u02ee\u02f0\7\u00a4\2\2\u02ef\u02f1\5*\26\2\u02f0\u02ef\3\2\2\2"+
		"\u02f0\u02f1\3\2\2\2\u02f1\u02f5\3\2\2\2\u02f2\u02f4\7\u00b2\2\2\u02f3"+
		"\u02f2\3\2\2\2\u02f4\u02f7\3\2\2\2\u02f5\u02f3\3\2\2\2\u02f5\u02f6\3\2"+
		"\2\2\u02f6\u02f9\3\2\2\2\u02f7\u02f5\3\2\2\2\u02f8\u02ee\3\2\2\2\u02f8"+
		"\u02f9\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa\u02fb\7\7\2\2\u02fb\u0308\3\2"+
		"\2\2\u02fc\u0301\7\u009e\2\2\u02fd\u0302\5\6\4\2\u02fe\u0302\5\4\3\2\u02ff"+
		"\u0302\5\62\32\2\u0300\u0302\5\30\r\2\u0301\u02fd\3\2\2\2\u0301\u02fe"+
		"\3\2\2\2\u0301\u02ff\3\2\2\2\u0301\u0300\3\2\2\2\u0302\u0303\3\2\2\2\u0303"+
		"\u0304\7\u009f\2\2\u0304\u0308\3\2\2\2\u0305\u0308\5\26\f\2\u0306\u0308"+
		"\5*\26\2\u0307\u0254\3\2\2\2\u0307\u025e\3\2\2\2\u0307\u0264\3\2\2\2\u0307"+
		"\u0269\3\2\2\2\u0307\u026e\3\2\2\2\u0307\u0288\3\2\2\2\u0307\u02a2\3\2"+
		"\2\2\u0307\u02af\3\2\2\2\u0307\u02bb\3\2\2\2\u0307\u02fc\3\2\2\2\u0307"+
		"\u0305\3\2\2\2\u0307\u0306\3\2\2\2\u0308%\3\2\2\2\u0309\u030c\7\u00b6"+
		"\2\2\u030a\u030c\5*\26\2\u030b\u0309\3\2\2\2\u030b\u030a\3\2\2\2\u030c"+
		"\'\3\2\2\2\u030d\u0324\t\3\2\2\u030e\u0324\7\u00ad\2\2\u030f\u0324\7\u00ae"+
		"\2\2\u0310\u0311\t\20\2\2\u0311\u0312\7\b\2\2\u0312\u0324\7\u00ae\2\2"+
		"\u0313\u0324\7\u00b7\2\2\u0314\u0324\7\u00b0\2\2\u0315\u0324\7\u00af\2"+
		"\2\u0316\u0317\t\5\2\2\u0317\u0320\7\22\2\2\u0318\u031d\5*\26\2\u0319"+
		"\u031a\7\3\2\2\u031a\u031c\5*\26\2\u031b\u0319\3\2\2\2\u031c\u031f\3\2"+
		"\2\2\u031d\u031b\3\2\2\2\u031d\u031e\3\2\2\2\u031e\u0321\3\2\2\2\u031f"+
		"\u031d\3\2\2\2\u0320\u0318\3\2\2\2\u0320\u0321\3\2\2\2\u0321\u0322\3\2"+
		"\2\2\u0322\u0324\7\23\2\2\u0323\u030d\3\2\2\2\u0323\u030e\3\2\2\2\u0323"+
		"\u030f\3\2\2\2\u0323\u0310\3\2\2\2\u0323\u0313\3\2\2\2\u0323\u0314\3\2"+
		"\2\2\u0323\u0315\3\2\2\2\u0323\u0316\3\2\2\2\u0324)\3\2\2\2\u0325\u0326"+
		"\b\26\1\2\u0326\u0327\t\"\2\2\u0327\u034b\5*\26\f\u0328\u0329\7\u00ae"+
		"\2\2\u0329\u0332\7\22\2\2\u032a\u032f\5*\26\2\u032b\u032c\7\3\2\2\u032c"+
		"\u032e\5*\26\2\u032d\u032b\3\2\2\2\u032e\u0331\3\2\2\2\u032f\u032d\3\2"+
		"\2\2\u032f\u0330\3\2\2\2\u0330\u0333\3\2\2\2\u0331\u032f\3\2\2\2\u0332"+
		"\u032a\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u0334\3\2\2\2\u0334\u034b\7\23"+
		"\2\2\u0335\u033a\5(\25\2\u0336\u0337\7\b\2\2\u0337\u0339\7\u00ae\2\2\u0338"+
		"\u0336\3\2\2\2\u0339\u033c\3\2\2\2\u033a\u0338\3\2\2\2\u033a\u033b\3\2"+
		"\2\2\u033b\u034b\3\2\2\2\u033c\u033a\3\2\2\2\u033d\u033e\7\u00a5\2\2\u033e"+
		"\u033f\7\22\2\2\u033f\u034b\7\23\2\2\u0340\u0341\7\u00a6\2\2\u0341\u0343"+
		"\7\22\2\2\u0342\u0344\7\u00b6\2\2\u0343\u0342\3\2\2\2\u0343\u0344\3\2"+
		"\2\2\u0344\u0345\3\2\2\2\u0345\u034b\7\23\2\2\u0346\u0347\7\22\2\2\u0347"+
		"\u0348\5*\26\2\u0348\u0349\7\23\2\2\u0349\u034b\3\2\2\2\u034a\u0325\3"+
		"\2\2\2\u034a\u0328\3\2\2\2\u034a\u0335\3\2\2\2\u034a\u033d\3\2\2\2\u034a"+
		"\u0340\3\2\2\2\u034a\u0346\3\2\2\2\u034b\u0384\3\2\2\2\u034c\u034d\f\13"+
		"\2\2\u034d\u034f\t\7\2\2\u034e\u0350\7\u00b2\2\2\u034f\u034e\3\2\2\2\u034f"+
		"\u0350\3\2\2\2\u0350\u0351\3\2\2\2\u0351\u0383\5*\26\f\u0352\u0353\f\n"+
		"\2\2\u0353\u0355\t\b\2\2\u0354\u0356\7\u00b2\2\2\u0355\u0354\3\2\2\2\u0355"+
		"\u0356\3\2\2\2\u0356\u0357\3\2\2\2\u0357\u0383\5*\26\13\u0358\u0359\f"+
		"\t\2\2\u0359\u035b\7F\2\2\u035a\u035c\7\u00b2\2\2\u035b\u035a\3\2\2\2"+
		"\u035b\u035c\3\2\2\2\u035c\u035d\3\2\2\2\u035d\u0383\5*\26\t\u035e\u035f"+
		"\f\b\2\2\u035f\u0361\7G\2\2\u0360\u0362\7\u00b2\2\2\u0361\u0360\3\2\2"+
		"\2\u0361\u0362\3\2\2\2\u0362\u0363\3\2\2\2\u0363\u0383\5*\26\t\u0364\u0365"+
		"\f\7\2\2\u0365\u0367\t#\2\2\u0366\u0368\7\u00b2\2\2\u0367\u0366\3\2\2"+
		"\2\u0367\u0368\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u0383\5*\26\b\u036a\u036b"+
		"\f\6\2\2\u036b\u036d\t$\2\2\u036c\u036e\7\u00b2\2\2\u036d\u036c\3\2\2"+
		"\2\u036d\u036e\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0383\5*\26\7\u0370\u0371"+
		"\f\5\2\2\u0371\u0373\7[\2\2\u0372\u0374\7\u00b2\2\2\u0373\u0372\3\2\2"+
		"\2\u0373\u0374\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u0383\5*\26\6\u0376\u0377"+
		"\f\4\2\2\u0377\u0379\7_\2\2\u0378\u037a\7\u00b2\2\2\u0379\u0378\3\2\2"+
		"\2\u0379\u037a\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u0383\5*\26\5\u037c\u037d"+
		"\f\3\2\2\u037d\u037f\7a\2\2\u037e\u0380\7\u00b2\2\2\u037f\u037e\3\2\2"+
		"\2\u037f\u0380\3\2\2\2\u0380\u0381\3\2\2\2\u0381\u0383\5*\26\4\u0382\u034c"+
		"\3\2\2\2\u0382\u0352\3\2\2\2\u0382\u0358\3\2\2\2\u0382\u035e\3\2\2\2\u0382"+
		"\u0364\3\2\2\2\u0382\u036a\3\2\2\2\u0382\u0370\3\2\2\2\u0382\u0376\3\2"+
		"\2\2\u0382\u037c\3\2\2\2\u0383\u0386\3\2\2\2\u0384\u0382\3\2\2\2\u0384"+
		"\u0385\3\2\2\2\u0385+\3\2\2\2\u0386\u0384\3\2\2\2\u0387\u038b\7\6\2\2"+
		"\u0388\u038a\7\u00b2\2\2\u0389\u0388\3\2\2\2\u038a\u038d\3\2\2\2\u038b"+
		"\u0389\3\2\2\2\u038b\u038c\3\2\2\2\u038c\u038e\3\2\2\2\u038d\u038b\3\2"+
		"\2\2\u038e\u038f\5.\30\2\u038f\u0393\7\7\2\2\u0390\u0392\7\u00b2\2\2\u0391"+
		"\u0390\3\2\2\2\u0392\u0395\3\2\2\2\u0393\u0391\3\2\2\2\u0393\u0394\3\2"+
		"\2\2\u0394\u03bd\3\2\2\2\u0395\u0393\3\2\2\2\u0396\u039a\7\6\2\2\u0397"+
		"\u0399\7\u00b2\2\2\u0398\u0397\3\2\2\2\u0399\u039c\3\2\2\2\u039a\u0398"+
		"\3\2\2\2\u039a\u039b\3\2\2\2\u039b\u039d\3\2\2\2\u039c\u039a\3\2\2\2\u039d"+
		"\u03a1\7\u0092\2\2\u039e\u03a0\7\u00b2\2\2\u039f\u039e\3\2\2\2\u03a0\u03a3"+
		"\3\2\2\2\u03a1\u039f\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2\u03a4\3\2\2\2\u03a3"+
		"\u03a1\3\2\2\2\u03a4\u03af\5\f\7\2\u03a5\u03a7\7\u00b2\2\2\u03a6\u03a5"+
		"\3\2\2\2\u03a7\u03a8\3\2\2\2\u03a8\u03a6\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9"+
		"\u03ab\3\2\2\2\u03aa\u03ac\5\f\7\2\u03ab\u03aa\3\2\2\2\u03ab\u03ac\3\2"+
		"\2\2\u03ac\u03ae\3\2\2\2\u03ad\u03a6\3\2\2\2\u03ae\u03b1\3\2\2\2\u03af"+
		"\u03ad\3\2\2\2\u03af\u03b0\3\2\2\2\u03b0\u03b3\3\2\2\2\u03b1\u03af\3\2"+
		"\2\2\u03b2\u03b4\5.\30\2\u03b3\u03b2\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4"+
		"\u03b5\3\2\2\2\u03b5\u03b9\7\7\2\2\u03b6\u03b8\7\u00b2\2\2\u03b7\u03b6"+
		"\3\2\2\2\u03b8\u03bb\3\2\2\2\u03b9\u03b7\3\2\2\2\u03b9\u03ba\3\2\2\2\u03ba"+
		"\u03bd\3\2\2\2\u03bb\u03b9\3\2\2\2\u03bc\u0387\3\2\2\2\u03bc\u0396\3\2"+
		"\2\2\u03bd-\3\2\2\2\u03be\u03bf\7\u00a7\2\2\u03bf\u03c4\7\u00ae\2\2\u03c0"+
		"\u03c1\7\3\2\2\u03c1\u03c3\7\u00ae\2\2\u03c2\u03c0\3\2\2\2\u03c3\u03c6"+
		"\3\2\2\2\u03c4\u03c2\3\2\2\2\u03c4\u03c5\3\2\2\2\u03c5\u03ca\3\2\2\2\u03c6"+
		"\u03c4\3\2\2\2\u03c7\u03c9\7\u00b2\2\2\u03c8\u03c7\3\2\2\2\u03c9\u03cc"+
		"\3\2\2\2\u03ca\u03c8\3\2\2\2\u03ca\u03cb\3\2\2\2\u03cb/\3\2\2\2\u03cc"+
		"\u03ca\3\2\2\2\u03cd\u03d1\7\6\2\2\u03ce\u03d0\7\u00b2\2\2\u03cf\u03ce"+
		"\3\2\2\2\u03d0\u03d3\3\2\2\2\u03d1\u03cf\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2"+
		"\u03e9\3\2\2\2\u03d3\u03d1\3\2\2\2\u03d4\u03d8\t%\2\2\u03d5\u03d7\7\u00b2"+
		"\2\2\u03d6\u03d5\3\2\2\2\u03d7\u03da\3\2\2\2\u03d8\u03d6\3\2\2\2\u03d8"+
		"\u03d9\3\2\2\2\u03d9\u03db\3\2\2\2\u03da\u03d8\3\2\2\2\u03db\u03e6\5\f"+
		"\7\2\u03dc\u03de\7\u00b2\2\2\u03dd\u03dc\3\2\2\2\u03de\u03df\3\2\2\2\u03df"+
		"\u03dd\3\2\2\2\u03df\u03e0\3\2\2\2\u03e0\u03e2\3\2\2\2\u03e1\u03e3\5\f"+
		"\7\2\u03e2\u03e1\3\2\2\2\u03e2\u03e3\3\2\2\2\u03e3\u03e5\3\2\2\2\u03e4"+
		"\u03dd\3\2\2\2\u03e5\u03e8\3\2\2\2\u03e6\u03e4\3\2\2\2\u03e6\u03e7\3\2"+
		"\2\2\u03e7\u03ea\3\2\2\2\u03e8\u03e6\3\2\2\2\u03e9\u03d4\3\2\2\2\u03e9"+
		"\u03ea\3\2\2\2\u03ea\u03ee\3\2\2\2\u03eb\u03ed\7\u00b2\2\2\u03ec\u03eb"+
		"\3\2\2\2\u03ed\u03f0\3\2\2\2\u03ee\u03ec\3\2\2\2\u03ee\u03ef\3\2\2\2\u03ef"+
		"\u03f2\3\2\2\2\u03f0\u03ee\3\2\2\2\u03f1\u03f3\5.\30\2\u03f2\u03f1\3\2"+
		"\2\2\u03f2\u03f3\3\2\2\2\u03f3\u0409\3\2\2\2\u03f4\u03f8\t&\2\2\u03f5"+
		"\u03f7\7\u00b2\2\2\u03f6\u03f5\3\2\2\2\u03f7\u03fa\3\2\2\2\u03f8\u03f6"+
		"\3\2\2\2\u03f8\u03f9\3\2\2\2\u03f9\u03fb\3\2\2\2\u03fa\u03f8\3\2\2\2\u03fb"+
		"\u0406\5\f\7\2\u03fc\u03fe\7\u00b2\2\2\u03fd\u03fc\3\2\2\2\u03fe\u03ff"+
		"\3\2\2\2\u03ff\u03fd\3\2\2\2\u03ff\u0400\3\2\2\2\u0400\u0402\3\2\2\2\u0401"+
		"\u0403\5\f\7\2\u0402\u0401\3\2\2\2\u0402\u0403\3\2\2\2\u0403\u0405\3\2"+
		"\2\2\u0404\u03fd\3\2\2\2\u0405\u0408\3\2\2\2\u0406\u0404\3\2\2\2\u0406"+
		"\u0407\3\2\2\2\u0407\u040a\3\2\2\2\u0408\u0406\3\2\2\2\u0409\u03f4\3\2"+
		"\2\2\u0409\u040a\3\2\2\2\u040a\u040e\3\2\2\2\u040b\u040d\7\u00b2\2\2\u040c"+
		"\u040b\3\2\2\2\u040d\u0410\3\2\2\2\u040e\u040c\3\2\2\2\u040e\u040f\3\2"+
		"\2\2\u040f\u0411\3\2\2\2\u0410\u040e\3\2\2\2\u0411\u0415\7\7\2\2\u0412"+
		"\u0414\7\u00b2\2\2\u0413\u0412\3\2\2\2\u0414\u0417\3\2\2\2\u0415\u0413"+
		"\3\2\2\2\u0415\u0416\3\2\2\2\u0416\61\3\2\2\2\u0417\u0415\3\2\2\2\u0418"+
		"\u041c\7\6\2\2\u0419\u041b\7\u00b2\2\2\u041a\u0419\3\2\2\2\u041b\u041e"+
		"\3\2\2\2\u041c\u041a\3\2\2\2\u041c\u041d\3\2\2\2\u041d\u041f\3\2\2\2\u041e"+
		"\u041c\3\2\2\2\u041f\u0423\7\u0092\2\2\u0420\u0422\7\u00b2\2\2\u0421\u0420"+
		"\3\2\2\2\u0422\u0425\3\2\2\2\u0423\u0421\3\2\2\2\u0423\u0424\3\2\2\2\u0424"+
		"\u0426\3\2\2\2\u0425\u0423\3\2\2\2\u0426\u0431\5\f\7\2\u0427\u0429\7\u00b2"+
		"\2\2\u0428\u0427\3\2\2\2\u0429\u042a\3\2\2\2\u042a\u0428\3\2\2\2\u042a"+
		"\u042b\3\2\2\2\u042b\u042d\3\2\2\2\u042c\u042e\5\f\7\2\u042d\u042c\3\2"+
		"\2\2\u042d\u042e\3\2\2\2\u042e\u0430\3\2\2\2\u042f\u0428\3\2\2\2\u0430"+
		"\u0433\3\2\2\2\u0431\u042f\3\2\2\2\u0431\u0432\3\2\2\2\u0432\u0434\3\2"+
		"\2\2\u0433\u0431\3\2\2\2\u0434\u0438\7\7\2\2\u0435\u0437\7\u00b2\2\2\u0436"+
		"\u0435\3\2\2\2\u0437\u043a\3\2\2\2\u0438\u0436\3\2\2\2\u0438\u0439\3\2"+
		"\2\2\u0439\63\3\2\2\2\u043a\u0438\3\2\2\2\u009c8<AIPS[ahjnsvz\u0081\u008e"+
		"\u0095\u009d\u00a5\u00aa\u00af\u00b2\u00b6\u00ba\u00c8\u00d5\u00e9\u00ec"+
		"\u00ef\u00fb\u00ff\u0104\u010a\u0110\u0116\u011c\u0122\u0128\u012e\u0134"+
		"\u013a\u013d\u013f\u0148\u0151\u0155\u015a\u015d\u0167\u016e\u0174\u017a"+
		"\u019e\u01ad\u01b7\u01c4\u01cb\u01d7\u01e5\u01e8\u01ed\u01f4\u01f8\u0207"+
		"\u020e\u0215\u0218\u021c\u0223\u0228\u0231\u0239\u0245\u024a\u024d\u0251"+
		"\u025a\u0261\u0275\u027f\u0286\u028f\u0296\u029d\u02a9\u02ac\u02b5\u02bb"+
		"\u02c0\u02c8\u02cb\u02d1\u02d7\u02de\u02e6\u02eb\u02f0\u02f5\u02f8\u0301"+
		"\u0307\u030b\u031d\u0320\u0323\u032f\u0332\u033a\u0343\u034a\u034f\u0355"+
		"\u035b\u0361\u0367\u036d\u0373\u0379\u037f\u0382\u0384\u038b\u0393\u039a"+
		"\u03a1\u03a8\u03ab\u03af\u03b3\u03b9\u03bc\u03c4\u03ca\u03d1\u03d8\u03df"+
		"\u03e2\u03e6\u03e9\u03ee\u03f2\u03f8\u03ff\u0402\u0406\u0409\u040e\u0415"+
		"\u041c\u0423\u042a\u042d\u0431\u0438";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}