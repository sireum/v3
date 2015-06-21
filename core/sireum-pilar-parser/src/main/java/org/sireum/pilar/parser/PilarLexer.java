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
		LIT=25, ID=26, WS=27, ERROR_CHAR=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "LIT", 
		"ID", "WS", "ERROR_CHAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'var'", "';'", "'def'", "'('", "','", "')'", "'{'", "'}'", "'#'", 
		"':'", "'call'", "':='", "'goto'", "'assert'", "'assume'", "'axt'", "'if'", 
		"'then'", "'else'", "'return'", "'switch'", "'case'", "'jxt'", "'@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "LIT", "ID", "WS", "ERROR_CHAR"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00ca\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\7\32\u009b\n\32\f\32\16\32\u009e\13\32\3\32\3\32\3\32\3\32\7\32\u00a4"+
		"\n\32\f\32\16\32\u00a7\13\32\3\32\5\32\u00aa\n\32\3\33\3\33\7\33\u00ae"+
		"\n\33\f\33\16\33\u00b1\13\33\3\33\3\33\6\33\u00b5\n\33\r\33\16\33\u00b6"+
		"\3\33\3\33\6\33\u00bb\n\33\r\33\16\33\u00bc\3\33\5\33\u00c0\n\33\3\34"+
		"\6\34\u00c3\n\34\r\34\16\34\u00c4\3\34\3\34\3\35\3\35\2\2\36\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36\3\2\t\r\2\13"+
		"\f\16\17\"\"$%)+..<=BBbb}}\177\177\3\2$$\4\2$$^^\6\2&&C\\aac|\7\2&&\62"+
		";C\\aac|\5\2\13\f\16\17bb\5\2\13\f\16\17\"\"\u00d3\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5?\3\2\2\2\7A\3"+
		"\2\2\2\tE\3\2\2\2\13G\3\2\2\2\rI\3\2\2\2\17K\3\2\2\2\21M\3\2\2\2\23O\3"+
		"\2\2\2\25Q\3\2\2\2\27S\3\2\2\2\31X\3\2\2\2\33[\3\2\2\2\35`\3\2\2\2\37"+
		"g\3\2\2\2!n\3\2\2\2#r\3\2\2\2%u\3\2\2\2\'z\3\2\2\2)\177\3\2\2\2+\u0086"+
		"\3\2\2\2-\u008d\3\2\2\2/\u0092\3\2\2\2\61\u0096\3\2\2\2\63\u00a9\3\2\2"+
		"\2\65\u00bf\3\2\2\2\67\u00c2\3\2\2\29\u00c8\3\2\2\2;<\7x\2\2<=\7c\2\2"+
		"=>\7t\2\2>\4\3\2\2\2?@\7=\2\2@\6\3\2\2\2AB\7f\2\2BC\7g\2\2CD\7h\2\2D\b"+
		"\3\2\2\2EF\7*\2\2F\n\3\2\2\2GH\7.\2\2H\f\3\2\2\2IJ\7+\2\2J\16\3\2\2\2"+
		"KL\7}\2\2L\20\3\2\2\2MN\7\177\2\2N\22\3\2\2\2OP\7%\2\2P\24\3\2\2\2QR\7"+
		"<\2\2R\26\3\2\2\2ST\7e\2\2TU\7c\2\2UV\7n\2\2VW\7n\2\2W\30\3\2\2\2XY\7"+
		"<\2\2YZ\7?\2\2Z\32\3\2\2\2[\\\7i\2\2\\]\7q\2\2]^\7v\2\2^_\7q\2\2_\34\3"+
		"\2\2\2`a\7c\2\2ab\7u\2\2bc\7u\2\2cd\7g\2\2de\7t\2\2ef\7v\2\2f\36\3\2\2"+
		"\2gh\7c\2\2hi\7u\2\2ij\7u\2\2jk\7w\2\2kl\7o\2\2lm\7g\2\2m \3\2\2\2no\7"+
		"c\2\2op\7z\2\2pq\7v\2\2q\"\3\2\2\2rs\7k\2\2st\7h\2\2t$\3\2\2\2uv\7v\2"+
		"\2vw\7j\2\2wx\7g\2\2xy\7p\2\2y&\3\2\2\2z{\7g\2\2{|\7n\2\2|}\7u\2\2}~\7"+
		"g\2\2~(\3\2\2\2\177\u0080\7t\2\2\u0080\u0081\7g\2\2\u0081\u0082\7v\2\2"+
		"\u0082\u0083\7w\2\2\u0083\u0084\7t\2\2\u0084\u0085\7p\2\2\u0085*\3\2\2"+
		"\2\u0086\u0087\7u\2\2\u0087\u0088\7y\2\2\u0088\u0089\7k\2\2\u0089\u008a"+
		"\7v\2\2\u008a\u008b\7e\2\2\u008b\u008c\7j\2\2\u008c,\3\2\2\2\u008d\u008e"+
		"\7e\2\2\u008e\u008f\7c\2\2\u008f\u0090\7u\2\2\u0090\u0091\7g\2\2\u0091"+
		".\3\2\2\2\u0092\u0093\7l\2\2\u0093\u0094\7z\2\2\u0094\u0095\7v\2\2\u0095"+
		"\60\3\2\2\2\u0096\u0097\7B\2\2\u0097\62\3\2\2\2\u0098\u009c\7)\2\2\u0099"+
		"\u009b\n\2\2\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u00aa\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a5\7$\2\2\u00a0\u00a4\n\3\2\2\u00a1\u00a2\7^\2\2\u00a2\u00a4\t\4\2"+
		"\2\u00a3\u00a0\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8"+
		"\u00aa\7$\2\2\u00a9\u0098\3\2\2\2\u00a9\u009f\3\2\2\2\u00aa\64\3\2\2\2"+
		"\u00ab\u00af\t\5\2\2\u00ac\u00ae\t\6\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00c0\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b2\u00b4\7\60\2\2\u00b3\u00b5\n\2\2\2\u00b4\u00b3\3"+
		"\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00c0\3\2\2\2\u00b8\u00ba\7b\2\2\u00b9\u00bb\n\7\2\2\u00ba\u00b9\3\2"+
		"\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00c0\7b\2\2\u00bf\u00ab\3\2\2\2\u00bf\u00b2\3\2"+
		"\2\2\u00bf\u00b8\3\2\2\2\u00c0\66\3\2\2\2\u00c1\u00c3\t\b\2\2\u00c2\u00c1"+
		"\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c7\b\34\2\2\u00c78\3\2\2\2\u00c8\u00c9\13\2\2"+
		"\2\u00c9:\3\2\2\2\f\2\u009c\u00a3\u00a5\u00a9\u00af\u00b6\u00bc\u00bf"+
		"\u00c4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}