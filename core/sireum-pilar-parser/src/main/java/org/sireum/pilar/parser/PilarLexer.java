// Generated from /Users/robby/Repositories/Sireum-Private/sireumv3/core/sireum-pilar-parser/src/main/resources/org/sireum/pilar/parser/Pilar.g4 by ANTLR 4.5
package org.sireum.pilar.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PilarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, ID=28, LIT=29, WS=30, COMMENT=31, LINE_COMMENT=32, 
		ERROR_CHAR=33;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "ID", "LIT", "WS", "COMMENT", "LINE_COMMENT", "ERROR_CHAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'global'", "','", "';'", "'def'", "'('", "')'", "'{'", "'}'", "'local'", 
		"'#'", "':'", "'call'", "':='", "'goto'", "'assert'", "'assume'", "'aext'", 
		"'if'", "'then'", "'else'", "'return'", "'switch'", "'default'", "'_'", 
		"'jext'", "'case'", "'@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "ID", "LIT", "WS", "COMMENT", "LINE_COMMENT", 
		"ERROR_CHAR"
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
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public PilarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pilar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u00fe\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\7\35"+
		"\u00ba\n\35\f\35\16\35\u00bd\13\35\3\35\3\35\6\35\u00c1\n\35\r\35\16\35"+
		"\u00c2\3\35\5\35\u00c6\n\35\3\36\3\36\6\36\u00ca\n\36\r\36\16\36\u00cb"+
		"\3\36\3\36\3\36\3\36\3\36\7\36\u00d3\n\36\f\36\16\36\u00d6\13\36\3\36"+
		"\3\36\3\36\5\36\u00db\n\36\3\37\6\37\u00de\n\37\r\37\16\37\u00df\3\37"+
		"\3\37\3 \3 \3 \3 \7 \u00e8\n \f \16 \u00eb\13 \3 \3 \3 \3 \3 \3!\3!\3"+
		"!\3!\7!\u00f6\n!\f!\16!\u00f9\13!\3!\3!\3\"\3\"\4\u00d4\u00e9\2#\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#\3\2\7\6\2&&C\\aac|\7\2&&\62;C\\aac|\4\2\13\f\16\17\5\2\13\f\16\17"+
		"\"\"\4\2\f\f\17\17\u0106\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\3E\3\2\2\2\5L\3\2\2\2\7N\3\2\2\2\tP\3\2\2\2\13T\3\2\2\2\rV\3\2\2\2"+
		"\17X\3\2\2\2\21Z\3\2\2\2\23\\\3\2\2\2\25b\3\2\2\2\27d\3\2\2\2\31f\3\2"+
		"\2\2\33k\3\2\2\2\35n\3\2\2\2\37s\3\2\2\2!z\3\2\2\2#\u0081\3\2\2\2%\u0086"+
		"\3\2\2\2\'\u0089\3\2\2\2)\u008e\3\2\2\2+\u0093\3\2\2\2-\u009a\3\2\2\2"+
		"/\u00a1\3\2\2\2\61\u00a9\3\2\2\2\63\u00ab\3\2\2\2\65\u00b0\3\2\2\2\67"+
		"\u00b5\3\2\2\29\u00c5\3\2\2\2;\u00da\3\2\2\2=\u00dd\3\2\2\2?\u00e3\3\2"+
		"\2\2A\u00f1\3\2\2\2C\u00fc\3\2\2\2EF\7i\2\2FG\7n\2\2GH\7q\2\2HI\7d\2\2"+
		"IJ\7c\2\2JK\7n\2\2K\4\3\2\2\2LM\7.\2\2M\6\3\2\2\2NO\7=\2\2O\b\3\2\2\2"+
		"PQ\7f\2\2QR\7g\2\2RS\7h\2\2S\n\3\2\2\2TU\7*\2\2U\f\3\2\2\2VW\7+\2\2W\16"+
		"\3\2\2\2XY\7}\2\2Y\20\3\2\2\2Z[\7\177\2\2[\22\3\2\2\2\\]\7n\2\2]^\7q\2"+
		"\2^_\7e\2\2_`\7c\2\2`a\7n\2\2a\24\3\2\2\2bc\7%\2\2c\26\3\2\2\2de\7<\2"+
		"\2e\30\3\2\2\2fg\7e\2\2gh\7c\2\2hi\7n\2\2ij\7n\2\2j\32\3\2\2\2kl\7<\2"+
		"\2lm\7?\2\2m\34\3\2\2\2no\7i\2\2op\7q\2\2pq\7v\2\2qr\7q\2\2r\36\3\2\2"+
		"\2st\7c\2\2tu\7u\2\2uv\7u\2\2vw\7g\2\2wx\7t\2\2xy\7v\2\2y \3\2\2\2z{\7"+
		"c\2\2{|\7u\2\2|}\7u\2\2}~\7w\2\2~\177\7o\2\2\177\u0080\7g\2\2\u0080\""+
		"\3\2\2\2\u0081\u0082\7c\2\2\u0082\u0083\7g\2\2\u0083\u0084\7z\2\2\u0084"+
		"\u0085\7v\2\2\u0085$\3\2\2\2\u0086\u0087\7k\2\2\u0087\u0088\7h\2\2\u0088"+
		"&\3\2\2\2\u0089\u008a\7v\2\2\u008a\u008b\7j\2\2\u008b\u008c\7g\2\2\u008c"+
		"\u008d\7p\2\2\u008d(\3\2\2\2\u008e\u008f\7g\2\2\u008f\u0090\7n\2\2\u0090"+
		"\u0091\7u\2\2\u0091\u0092\7g\2\2\u0092*\3\2\2\2\u0093\u0094\7t\2\2\u0094"+
		"\u0095\7g\2\2\u0095\u0096\7v\2\2\u0096\u0097\7w\2\2\u0097\u0098\7t\2\2"+
		"\u0098\u0099\7p\2\2\u0099,\3\2\2\2\u009a\u009b\7u\2\2\u009b\u009c\7y\2"+
		"\2\u009c\u009d\7k\2\2\u009d\u009e\7v\2\2\u009e\u009f\7e\2\2\u009f\u00a0"+
		"\7j\2\2\u00a0.\3\2\2\2\u00a1\u00a2\7f\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4"+
		"\7h\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7w\2\2\u00a6\u00a7\7n\2\2\u00a7"+
		"\u00a8\7v\2\2\u00a8\60\3\2\2\2\u00a9\u00aa\7a\2\2\u00aa\62\3\2\2\2\u00ab"+
		"\u00ac\7l\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7z\2\2\u00ae\u00af\7v\2\2"+
		"\u00af\64\3\2\2\2\u00b0\u00b1\7e\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3\7"+
		"u\2\2\u00b3\u00b4\7g\2\2\u00b4\66\3\2\2\2\u00b5\u00b6\7B\2\2\u00b68\3"+
		"\2\2\2\u00b7\u00bb\t\2\2\2\u00b8\u00ba\t\3\2\2\u00b9\u00b8\3\2\2\2\u00ba"+
		"\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00c6\3\2"+
		"\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c0\7b\2\2\u00bf\u00c1\n\4\2\2\u00c0"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\7b\2\2\u00c5\u00b7\3\2\2\2\u00c5"+
		"\u00be\3\2\2\2\u00c6:\3\2\2\2\u00c7\u00c9\7)\2\2\u00c8\u00ca\n\5\2\2\u00c9"+
		"\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00db\3\2\2\2\u00cd\u00ce\7$\2\2\u00ce\u00cf\7$\2\2\u00cf\u00d0"+
		"\7$\2\2\u00d0\u00d4\3\2\2\2\u00d1\u00d3\13\2\2\2\u00d2\u00d1\3\2\2\2\u00d3"+
		"\u00d6\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d7\3\2"+
		"\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7$\2\2\u00d8\u00d9\7$\2\2\u00d9\u00db"+
		"\7$\2\2\u00da\u00c7\3\2\2\2\u00da\u00cd\3\2\2\2\u00db<\3\2\2\2\u00dc\u00de"+
		"\t\5\2\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00dd\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\b\37\2\2\u00e2>\3\2\2\2"+
		"\u00e3\u00e4\7\61\2\2\u00e4\u00e5\7,\2\2\u00e5\u00e9\3\2\2\2\u00e6\u00e8"+
		"\13\2\2\2\u00e7\u00e6\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00ea\3\2\2\2"+
		"\u00e9\u00e7\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed"+
		"\7,\2\2\u00ed\u00ee\7\61\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\b \2\2\u00f0"+
		"@\3\2\2\2\u00f1\u00f2\7\61\2\2\u00f2\u00f3\7\61\2\2\u00f3\u00f7\3\2\2"+
		"\2\u00f4\u00f6\n\6\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5"+
		"\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa"+
		"\u00fb\b!\2\2\u00fbB\3\2\2\2\u00fc\u00fd\13\2\2\2\u00fdD\3\2\2\2\f\2\u00bb"+
		"\u00c2\u00c5\u00cb\u00d4\u00da\u00df\u00e9\u00f7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}