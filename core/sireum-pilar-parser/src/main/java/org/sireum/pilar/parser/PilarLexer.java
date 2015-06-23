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
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
            T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24,
            T__24 = 25, T__25 = 26, LIT = 27, ID = 28, WS = 29, ERROR_CHAR = 30;
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8",
            "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16",
            "T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24",
            "T__25", "LIT", "ID", "WS", "LITIDTrailChar", "ERROR_CHAR"
    };

	private static final String[] _LITERAL_NAMES = {
            null, "'global'", "'var'", "';'", "'def'", "'('", "','", "')'", "'{'",
            "'}'", "'#'", "'call'", "':='", "'goto'", "'assert'", "'assume'", "'ext'",
            "'if'", "'then'", "'else'", "'return'", "'switch'", "'default'", "':'",
            "'jext'", "'case'", "'@'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, "LIT", "ID", "WS", "ERROR_CHAR"
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
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2 \u00e3\b\1\4\2\t" +
                    "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2" +
                    "\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3" +
                    "\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3" +
                    "\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20" +
                    "\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23" +
                    "\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25" +
                    "\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27" +
                    "\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32" +
                    "\3\32\3\33\3\33\3\34\3\34\7\34\u00b1\n\34\f\34\16\34\u00b4\13\34\3\34" +
                    "\3\34\3\34\3\34\7\34\u00ba\n\34\f\34\16\34\u00bd\13\34\3\34\5\34\u00c0" +
                    "\n\34\3\35\3\35\7\35\u00c4\n\35\f\35\16\35\u00c7\13\35\3\35\3\35\7\35" +
                    "\u00cb\n\35\f\35\16\35\u00ce\13\35\3\35\3\35\6\35\u00d2\n\35\r\35\16\35" +
                    "\u00d3\3\35\5\35\u00d7\n\35\3\36\6\36\u00da\n\36\r\36\16\36\u00db\3\36" +
                    "\3\36\3\37\3\37\3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25" +
                    "\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32" +
                    "\63\33\65\34\67\359\36;\37=\2? \3\2\n\3\2$$\4\2$$^^\6\2&&C\\aac|\7\2&" +
                    "&\62;C\\aac|\n\2##\'(,-\60\61>A``~~\u0080\u0080\5\2\13\f\16\17bb\5\2\13" +
                    "\f\16\17\"\"\r\2\13\f\16\17\"\"$%)+..==BBbb}}\177\177\u00eb\2\3\3\2\2" +
                    "\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3" +
                    "\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2" +
                    "\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2" +
                    "\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2" +
                    "\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2?\3" +
                    "\2\2\2\3A\3\2\2\2\5H\3\2\2\2\7L\3\2\2\2\tN\3\2\2\2\13R\3\2\2\2\rT\3\2" +
                    "\2\2\17V\3\2\2\2\21X\3\2\2\2\23Z\3\2\2\2\25\\\3\2\2\2\27^\3\2\2\2\31c" +
                    "\3\2\2\2\33f\3\2\2\2\35k\3\2\2\2\37r\3\2\2\2!y\3\2\2\2#}\3\2\2\2%\u0080" +
                    "\3\2\2\2\'\u0085\3\2\2\2)\u008a\3\2\2\2+\u0091\3\2\2\2-\u0098\3\2\2\2" +
                    "/\u00a0\3\2\2\2\61\u00a2\3\2\2\2\63\u00a7\3\2\2\2\65\u00ac\3\2\2\2\67" +
                    "\u00bf\3\2\2\29\u00d6\3\2\2\2;\u00d9\3\2\2\2=\u00df\3\2\2\2?\u00e1\3\2" +
                    "\2\2AB\7i\2\2BC\7n\2\2CD\7q\2\2DE\7d\2\2EF\7c\2\2FG\7n\2\2G\4\3\2\2\2" +
                    "HI\7x\2\2IJ\7c\2\2JK\7t\2\2K\6\3\2\2\2LM\7=\2\2M\b\3\2\2\2NO\7f\2\2OP" +
                    "\7g\2\2PQ\7h\2\2Q\n\3\2\2\2RS\7*\2\2S\f\3\2\2\2TU\7.\2\2U\16\3\2\2\2V" +
                    "W\7+\2\2W\20\3\2\2\2XY\7}\2\2Y\22\3\2\2\2Z[\7\177\2\2[\24\3\2\2\2\\]\7" +
                    "%\2\2]\26\3\2\2\2^_\7e\2\2_`\7c\2\2`a\7n\2\2ab\7n\2\2b\30\3\2\2\2cd\7" +
                    "<\2\2de\7?\2\2e\32\3\2\2\2fg\7i\2\2gh\7q\2\2hi\7v\2\2ij\7q\2\2j\34\3\2" +
                    "\2\2kl\7c\2\2lm\7u\2\2mn\7u\2\2no\7g\2\2op\7t\2\2pq\7v\2\2q\36\3\2\2\2" +
                    "rs\7c\2\2st\7u\2\2tu\7u\2\2uv\7w\2\2vw\7o\2\2wx\7g\2\2x \3\2\2\2yz\7g" +
                    "\2\2z{\7z\2\2{|\7v\2\2|\"\3\2\2\2}~\7k\2\2~\177\7h\2\2\177$\3\2\2\2\u0080" +
                    "\u0081\7v\2\2\u0081\u0082\7j\2\2\u0082\u0083\7g\2\2\u0083\u0084\7p\2\2" +
                    "\u0084&\3\2\2\2\u0085\u0086\7g\2\2\u0086\u0087\7n\2\2\u0087\u0088\7u\2" +
                    "\2\u0088\u0089\7g\2\2\u0089(\3\2\2\2\u008a\u008b\7t\2\2\u008b\u008c\7" +
                    "g\2\2\u008c\u008d\7v\2\2\u008d\u008e\7w\2\2\u008e\u008f\7t\2\2\u008f\u0090" +
                    "\7p\2\2\u0090*\3\2\2\2\u0091\u0092\7u\2\2\u0092\u0093\7y\2\2\u0093\u0094" +
                    "\7k\2\2\u0094\u0095\7v\2\2\u0095\u0096\7e\2\2\u0096\u0097\7j\2\2\u0097" +
                    ",\3\2\2\2\u0098\u0099\7f\2\2\u0099\u009a\7g\2\2\u009a\u009b\7h\2\2\u009b" +
                    "\u009c\7c\2\2\u009c\u009d\7w\2\2\u009d\u009e\7n\2\2\u009e\u009f\7v\2\2" +
                    "\u009f.\3\2\2\2\u00a0\u00a1\7<\2\2\u00a1\60\3\2\2\2\u00a2\u00a3\7l\2\2" +
                    "\u00a3\u00a4\7g\2\2\u00a4\u00a5\7z\2\2\u00a5\u00a6\7v\2\2\u00a6\62\3\2" +
                    "\2\2\u00a7\u00a8\7e\2\2\u00a8\u00a9\7c\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab" +
                    "\7g\2\2\u00ab\64\3\2\2\2\u00ac\u00ad\7B\2\2\u00ad\66\3\2\2\2\u00ae\u00b2" +
                    "\7)\2\2\u00af\u00b1\5=\37\2\u00b0\u00af\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2" +
                    "\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00c0\3\2\2\2\u00b4\u00b2\3\2" +
                    "\2\2\u00b5\u00bb\7$\2\2\u00b6\u00ba\n\2\2\2\u00b7\u00b8\7^\2\2\u00b8\u00ba" +
                    "\t\3\2\2\u00b9\u00b6\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb" +
                    "\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2" +
                    "\2\2\u00be\u00c0\7$\2\2\u00bf\u00ae\3\2\2\2\u00bf\u00b5\3\2\2\2\u00c0" +
                    "8\3\2\2\2\u00c1\u00c5\t\4\2\2\u00c2\u00c4\t\5\2\2\u00c3\u00c2\3\2\2\2" +
                    "\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00d7" +
                    "\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00cc\t\6\2\2\u00c9\u00cb\5=\37\2\u00ca" +
                    "\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2" +
                    "\2\2\u00cd\u00d7\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\7b\2\2\u00d0" +
                    "\u00d2\n\7\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2" +
                    "\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7\7b\2\2\u00d6" +
                    "\u00c1\3\2\2\2\u00d6\u00c8\3\2\2\2\u00d6\u00cf\3\2\2\2\u00d7:\3\2\2\2" +
                    "\u00d8\u00da\t\b\2\2\u00d9\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00d9" +
                    "\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\b\36\2\2" +
                    "\u00de<\3\2\2\2\u00df\u00e0\n\t\2\2\u00e0>\3\2\2\2\u00e1\u00e2\13\2\2" +
                    "\2\u00e2@\3\2\2\2\f\2\u00b2\u00b9\u00bb\u00bf\u00c5\u00cc\u00d3\u00d6" +
                    "\u00db\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}