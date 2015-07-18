// Generated from /Users/robby/Repositories/Sireum-Private/sireum-v3/awas/sireum-awas-parser-antlr4/src/main/resources/org/sireum/awas/parser/antlr4/Antlr4Awas.g4 by ANTLR 4.5.1
package org.sireum.awas.parser.antlr4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Antlr4AwasLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
            T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24,
            T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, T__28 = 29, T__29 = 30, T__30 = 31,
            T__31 = 32, INTEGER = 33, REAL = 34, STRING = 35, ID = 36, WS = 37, COMMENT = 38, LINE_COMMENT = 39,
            ERROR_CHAR = 40;
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    public static final String[] ruleNames = {
            "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8",
            "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16",
            "T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24",
            "T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "INTEGER",
            "REAL", "STRING", "ID", "WS", "COMMENT", "LINE_COMMENT", "ERROR_CHAR"
    };

    private static final String[] _LITERAL_NAMES = {
            null, "'enclosure'", "'component'", "'ports'", "'dependencies'", "'properties'",
            "'connection'", "'.'", "'->'", "'enum'", "'extends'", "','", "'states'",
            "'='", "'['", "']'", "'transitions'", "'-['", "']->'", "'in'", "'out'",
            "':'", "'Set'", "'Seq'", "'Map'", "'Boolean'", "'Integer'", "'Real'",
            "'String'", "'true'", "'false'", "'('", "')'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, "INTEGER", "REAL",
            "STRING", "ID", "WS", "COMMENT", "LINE_COMMENT", "ERROR_CHAR"
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


    public Antlr4AwasLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "Antlr4Awas.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2*\u015b\b\1\4\2\t" +
                    "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
                    "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3" +
                    "\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4" +
                    "\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3" +
                    "\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7" +
                    "\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13" +
                    "\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16" +
                    "\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21" +
                    "\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25" +
                    "\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31" +
                    "\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33" +
                    "\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35" +
                    "\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37" +
                    "\3 \3 \3!\3!\3\"\3\"\3\"\7\"\u0108\n\"\f\"\16\"\u010b\13\"\5\"\u010d\n" +
                    "\"\3#\3#\3#\7#\u0112\n#\f#\16#\u0115\13#\5#\u0117\n#\3#\3#\6#\u011b\n" +
                    "#\r#\16#\u011c\3$\3$\3$\3$\7$\u0123\n$\f$\16$\u0126\13$\3$\3$\3%\3%\7" +
                    "%\u012c\n%\f%\16%\u012f\13%\3%\3%\6%\u0133\n%\r%\16%\u0134\3%\5%\u0138" +
                    "\n%\3&\6&\u013b\n&\r&\16&\u013c\3&\3&\3\'\3\'\3\'\3\'\7\'\u0145\n\'\f" +
                    "\'\16\'\u0148\13\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\7(\u0153\n(\f(\16(" +
                    "\u0156\13(\3(\3(\3)\3)\3\u0146\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23" +
                    "\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31" +
                    "\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*\3\2\13\3\2\63" +
                    ";\3\2\62;\3\2$$\4\2$$^^\6\2&&C\\aac|\7\2&&\62;C\\aac|\5\2\13\f\16\17b" +
                    "b\5\2\13\f\16\17\"\"\4\2\f\f\17\17\u0167\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3" +
                    "\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2" +
                    "\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35" +
                    "\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)" +
                    "\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2" +
                    "\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2" +
                    "A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3" +
                    "\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5]\3\2\2\2\7g\3\2\2\2\tm\3\2\2" +
                    "\2\13z\3\2\2\2\r\u0085\3\2\2\2\17\u0090\3\2\2\2\21\u0092\3\2\2\2\23\u0095" +
                    "\3\2\2\2\25\u009a\3\2\2\2\27\u00a2\3\2\2\2\31\u00a4\3\2\2\2\33\u00ab\3" +
                    "\2\2\2\35\u00ad\3\2\2\2\37\u00af\3\2\2\2!\u00b1\3\2\2\2#\u00bd\3\2\2\2" +
                    "%\u00c0\3\2\2\2\'\u00c4\3\2\2\2)\u00c7\3\2\2\2+\u00cb\3\2\2\2-\u00cd\3" +
                    "\2\2\2/\u00d1\3\2\2\2\61\u00d5\3\2\2\2\63\u00d9\3\2\2\2\65\u00e1\3\2\2" +
                    "\2\67\u00e9\3\2\2\29\u00ee\3\2\2\2;\u00f5\3\2\2\2=\u00fa\3\2\2\2?\u0100" +
                    "\3\2\2\2A\u0102\3\2\2\2C\u010c\3\2\2\2E\u0116\3\2\2\2G\u011e\3\2\2\2I" +
                    "\u0137\3\2\2\2K\u013a\3\2\2\2M\u0140\3\2\2\2O\u014e\3\2\2\2Q\u0159\3\2" +
                    "\2\2ST\7g\2\2TU\7p\2\2UV\7e\2\2VW\7n\2\2WX\7q\2\2XY\7u\2\2YZ\7w\2\2Z[" +
                    "\7t\2\2[\\\7g\2\2\\\4\3\2\2\2]^\7e\2\2^_\7q\2\2_`\7o\2\2`a\7r\2\2ab\7" +
                    "q\2\2bc\7p\2\2cd\7g\2\2de\7p\2\2ef\7v\2\2f\6\3\2\2\2gh\7r\2\2hi\7q\2\2" +
                    "ij\7t\2\2jk\7v\2\2kl\7u\2\2l\b\3\2\2\2mn\7f\2\2no\7g\2\2op\7r\2\2pq\7" +
                    "g\2\2qr\7p\2\2rs\7f\2\2st\7g\2\2tu\7p\2\2uv\7e\2\2vw\7k\2\2wx\7g\2\2x" +
                    "y\7u\2\2y\n\3\2\2\2z{\7r\2\2{|\7t\2\2|}\7q\2\2}~\7r\2\2~\177\7g\2\2\177" +
                    "\u0080\7t\2\2\u0080\u0081\7v\2\2\u0081\u0082\7k\2\2\u0082\u0083\7g\2\2" +
                    "\u0083\u0084\7u\2\2\u0084\f\3\2\2\2\u0085\u0086\7e\2\2\u0086\u0087\7q" +
                    "\2\2\u0087\u0088\7p\2\2\u0088\u0089\7p\2\2\u0089\u008a\7g\2\2\u008a\u008b" +
                    "\7e\2\2\u008b\u008c\7v\2\2\u008c\u008d\7k\2\2\u008d\u008e\7q\2\2\u008e" +
                    "\u008f\7p\2\2\u008f\16\3\2\2\2\u0090\u0091\7\60\2\2\u0091\20\3\2\2\2\u0092" +
                    "\u0093\7/\2\2\u0093\u0094\7@\2\2\u0094\22\3\2\2\2\u0095\u0096\7g\2\2\u0096" +
                    "\u0097\7p\2\2\u0097\u0098\7w\2\2\u0098\u0099\7o\2\2\u0099\24\3\2\2\2\u009a" +
                    "\u009b\7g\2\2\u009b\u009c\7z\2\2\u009c\u009d\7v\2\2\u009d\u009e\7g\2\2" +
                    "\u009e\u009f\7p\2\2\u009f\u00a0\7f\2\2\u00a0\u00a1\7u\2\2\u00a1\26\3\2" +
                    "\2\2\u00a2\u00a3\7.\2\2\u00a3\30\3\2\2\2\u00a4\u00a5\7u\2\2\u00a5\u00a6" +
                    "\7v\2\2\u00a6\u00a7\7c\2\2\u00a7\u00a8\7v\2\2\u00a8\u00a9\7g\2\2\u00a9" +
                    "\u00aa\7u\2\2\u00aa\32\3\2\2\2\u00ab\u00ac\7?\2\2\u00ac\34\3\2\2\2\u00ad" +
                    "\u00ae\7]\2\2\u00ae\36\3\2\2\2\u00af\u00b0\7_\2\2\u00b0 \3\2\2\2\u00b1" +
                    "\u00b2\7v\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7c\2\2\u00b4\u00b5\7p\2\2" +
                    "\u00b5\u00b6\7u\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9" +
                    "\7k\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7p\2\2\u00bb\u00bc\7u\2\2\u00bc" +
                    "\"\3\2\2\2\u00bd\u00be\7/\2\2\u00be\u00bf\7]\2\2\u00bf$\3\2\2\2\u00c0" +
                    "\u00c1\7_\2\2\u00c1\u00c2\7/\2\2\u00c2\u00c3\7@\2\2\u00c3&\3\2\2\2\u00c4" +
                    "\u00c5\7k\2\2\u00c5\u00c6\7p\2\2\u00c6(\3\2\2\2\u00c7\u00c8\7q\2\2\u00c8" +
                    "\u00c9\7w\2\2\u00c9\u00ca\7v\2\2\u00ca*\3\2\2\2\u00cb\u00cc\7<\2\2\u00cc" +
                    ",\3\2\2\2\u00cd\u00ce\7U\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7v\2\2\u00d0" +
                    ".\3\2\2\2\u00d1\u00d2\7U\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7s\2\2\u00d4" +
                    "\60\3\2\2\2\u00d5\u00d6\7O\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7r\2\2\u00d8" +
                    "\62\3\2\2\2\u00d9\u00da\7D\2\2\u00da\u00db\7q\2\2\u00db\u00dc\7q\2\2\u00dc" +
                    "\u00dd\7n\2\2\u00dd\u00de\7g\2\2\u00de\u00df\7c\2\2\u00df\u00e0\7p\2\2" +
                    "\u00e0\64\3\2\2\2\u00e1\u00e2\7K\2\2\u00e2\u00e3\7p\2\2\u00e3\u00e4\7" +
                    "v\2\2\u00e4\u00e5\7g\2\2\u00e5\u00e6\7i\2\2\u00e6\u00e7\7g\2\2\u00e7\u00e8" +
                    "\7t\2\2\u00e8\66\3\2\2\2\u00e9\u00ea\7T\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec" +
                    "\7c\2\2\u00ec\u00ed\7n\2\2\u00ed8\3\2\2\2\u00ee\u00ef\7U\2\2\u00ef\u00f0" +
                    "\7v\2\2\u00f0\u00f1\7t\2\2\u00f1\u00f2\7k\2\2\u00f2\u00f3\7p\2\2\u00f3" +
                    "\u00f4\7i\2\2\u00f4:\3\2\2\2\u00f5\u00f6\7v\2\2\u00f6\u00f7\7t\2\2\u00f7" +
                    "\u00f8\7w\2\2\u00f8\u00f9\7g\2\2\u00f9<\3\2\2\2\u00fa\u00fb\7h\2\2\u00fb" +
                    "\u00fc\7c\2\2\u00fc\u00fd\7n\2\2\u00fd\u00fe\7u\2\2\u00fe\u00ff\7g\2\2" +
                    "\u00ff>\3\2\2\2\u0100\u0101\7*\2\2\u0101@\3\2\2\2\u0102\u0103\7+\2\2\u0103" +
                    "B\3\2\2\2\u0104\u010d\7\62\2\2\u0105\u0109\t\2\2\2\u0106\u0108\t\3\2\2" +
                    "\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a" +
                    "\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u0104\3\2\2\2\u010c" +
                    "\u0105\3\2\2\2\u010dD\3\2\2\2\u010e\u0117\7\62\2\2\u010f\u0113\t\2\2\2" +
                    "\u0110\u0112\t\3\2\2\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111" +
                    "\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0116" +
                    "\u010e\3\2\2\2\u0116\u010f\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011a\7\60" +
                    "\2\2\u0119\u011b\t\3\2\2\u011a\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c" +
                    "\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011dF\3\2\2\2\u011e\u0124\7$\2\2\u011f" +
                    "\u0123\n\4\2\2\u0120\u0121\7^\2\2\u0121\u0123\t\5\2\2\u0122\u011f\3\2" +
                    "\2\2\u0122\u0120\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124" +
                    "\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0128\7$" +
                    "\2\2\u0128H\3\2\2\2\u0129\u012d\t\6\2\2\u012a\u012c\t\7\2\2\u012b\u012a" +
                    "\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e" +
                    "\u0138\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0132\7b\2\2\u0131\u0133\n\b" +
                    "\2\2\u0132\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134" +
                    "\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0138\7b\2\2\u0137\u0129\3\2" +
                    "\2\2\u0137\u0130\3\2\2\2\u0138J\3\2\2\2\u0139\u013b\t\t\2\2\u013a\u0139" +
                    "\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d" +
                    "\u013e\3\2\2\2\u013e\u013f\b&\2\2\u013fL\3\2\2\2\u0140\u0141\7\61\2\2" +
                    "\u0141\u0142\7,\2\2\u0142\u0146\3\2\2\2\u0143\u0145\13\2\2\2\u0144\u0143" +
                    "\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0147\3\2\2\2\u0146\u0144\3\2\2\2\u0147" +
                    "\u0149\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014a\7,\2\2\u014a\u014b\7\61" +
                    "\2\2\u014b\u014c\3\2\2\2\u014c\u014d\b\'\2\2\u014dN\3\2\2\2\u014e\u014f" +
                    "\7\61\2\2\u014f\u0150\7\61\2\2\u0150\u0154\3\2\2\2\u0151\u0153\n\n\2\2" +
                    "\u0152\u0151\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155" +
                    "\3\2\2\2\u0155\u0157\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u0158\b(\2\2\u0158" +
                    "P\3\2\2\2\u0159\u015a\13\2\2\2\u015aR\3\2\2\2\20\2\u0109\u010c\u0113\u0116" +
                    "\u011c\u0122\u0124\u012d\u0134\u0137\u013c\u0146\u0154\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}