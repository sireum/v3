// Generated from /Users/robby/Repositories/Sireum-Private/sireumv3/core/sireum-pilar-parser/src/main/resources/org/sireum/pilar/parser/Pilar.g4 by ANTLR 4.5
package org.sireum.pilar.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PilarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24,
            T__24 = 25, T__25 = 26, ID = 27, LIT = 28, WS = 29, COMMENT = 30, LINE_COMMENT = 31,
            ERROR_CHAR = 32;
    public static final int
		RULE_model = 0, RULE_modelElement = 1, RULE_globalVarDecl = 2, RULE_procDecl = 3, 
		RULE_param = 4, RULE_procBody = 5, RULE_localVarDecl = 6, RULE_location = 7, 
		RULE_transformation = 8, RULE_action = 9, RULE_jump = 10, RULE_switchCase = 11, 
		RULE_exp = 12, RULE_prim = 13, RULE_arg = 14, RULE_lit = 15, RULE_name = 16, 
		RULE_annotation = 17;
	public static final String[] ruleNames = {
		"model", "modelElement", "globalVarDecl", "procDecl", "param", "procBody", 
		"localVarDecl", "location", "transformation", "action", "jump", "switchCase", 
		"exp", "prim", "arg", "lit", "name", "annotation"
	};

	private static final String[] _LITERAL_NAMES = {
            null, "'var'", "';'", "'def'", "'('", "','", "')'", "'{'", "'}'", "'#'",
            "':'", "'call'", "':='", "'goto'", "'assert'", "'assume'", "'aext'", "'if'",
            "'then'", "'else'", "'return'", "'switch'", "'default'", "'_'", "'jext'",
            "'case'", "'@'"
    };
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, "ID", "LIT", "WS", "COMMENT", "LINE_COMMENT", "ERROR_CHAR"
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

	@Override
	public String getGrammarFileName() { return "Pilar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PilarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ModelContext extends ParserRuleContext {
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ModelElementContext> modelElement() {
			return getRuleContexts(ModelElementContext.class);
		}
		public ModelElementContext modelElement(int i) {
			return getRuleContext(ModelElementContext.class,i);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
	}

	public final ModelContext model() throws RecognitionException {
		ModelContext _localctx = new ModelContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_model);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
                while (_la == T__25) {
                    {
				{
				setState(36); 
				annotation();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
                while (_la == T__0 || _la == T__2) {
                    {
				{
				setState(42); 
				modelElement();
				}
				}
				setState(47);
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

	public static class ModelElementContext extends ParserRuleContext {
		public GlobalVarDeclContext globalVarDecl() {
			return getRuleContext(GlobalVarDeclContext.class,0);
		}
		public ProcDeclContext procDecl() {
			return getRuleContext(ProcDeclContext.class,0);
		}
		public ModelElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelElement; }
	}

	public final ModelElementContext modelElement() throws RecognitionException {
		ModelElementContext _localctx = new ModelElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_modelElement);
		try {
			setState(50);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(48); 
				globalVarDecl();
				}
				break;
                case T__2:
                    enterOuterAlt(_localctx, 2);
				{
				setState(49); 
				procDecl();
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

	public static class GlobalVarDeclContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }
		public GlobalVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalVarDecl; }
	}

	public final GlobalVarDeclContext globalVarDecl() throws RecognitionException {
		GlobalVarDeclContext _localctx = new GlobalVarDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_globalVarDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); 
			match(T__0);
			setState(53); 
			name();
                setState(54);
                match(T__1);
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

	public static class ProcDeclContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ProcBodyContext procBody() {
			return getRuleContext(ProcBodyContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public ProcDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procDecl; }
	}

	public final ProcDeclContext procDecl() throws RecognitionException {
		ProcDeclContext _localctx = new ProcDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_procDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
                setState(56);
                match(T__2);
                setState(57);
                name();
                setState(58);
                match(T__3);
                setState(59);
                param();
                setState(64);
                _errHandler.sync(this);
			_la = _input.LA(1);
                while (_la == T__4) {
                    {
				{
                    setState(60);
                    match(T__4);
                    setState(61);
                    param();
				}
				}
                    setState(66);
                    _errHandler.sync(this);
				_la = _input.LA(1);
			}
                setState(67);
                match(T__5);
                setState(71);
                _errHandler.sync(this);
			_la = _input.LA(1);
                while (_la == T__25) {
                    {
				{
                    setState(68);
                    annotation();
				}
				}
                    setState(73);
                    _errHandler.sync(this);
				_la = _input.LA(1);
			}
                setState(76);
                switch (_input.LA(1)) {
			case T__6:
				{
                    setState(74);
                    procBody();
				}
				break;
                case T__1: {
                    setState(75);
                    match(T__1);
                }
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ParamContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
                setState(78);
                name();
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

	public static class ProcBodyContext extends ParserRuleContext {
		public List<LocalVarDeclContext> localVarDecl() {
			return getRuleContexts(LocalVarDeclContext.class);
		}
		public LocalVarDeclContext localVarDecl(int i) {
			return getRuleContext(LocalVarDeclContext.class,i);
		}
		public List<LocationContext> location() {
			return getRuleContexts(LocationContext.class);
		}
		public LocationContext location(int i) {
			return getRuleContext(LocationContext.class,i);
		}
		public ProcBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procBody; }
	}

	public final ProcBodyContext procBody() throws RecognitionException {
		ProcBodyContext _localctx = new ProcBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_procBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
                setState(80);
                match(T__6);
                setState(84);
                _errHandler.sync(this);
			_la = _input.LA(1);
                while (_la == T__0) {
                    {
				{
                    setState(81);
                    localVarDecl();
				}
				}
                    setState(86);
                    _errHandler.sync(this);
				_la = _input.LA(1);
			}
                setState(88);
                _errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
                    setState(87);
                    location();
				}
				}
                setState(90);
                _errHandler.sync(this);
				_la = _input.LA(1);
            } while (_la == T__8);
                setState(92);
                match(T__7);
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

	public static class LocalVarDeclContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }
		public LocalVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVarDecl; }
	}

	public final LocalVarDeclContext localVarDecl() throws RecognitionException {
		LocalVarDeclContext _localctx = new LocalVarDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_localVarDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
                setState(94);
                match(T__0);
                setState(95);
                name();
                setState(96);
                match(T__1);
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

	public static class LocationContext extends ParserRuleContext {
		public TransformationContext transformation() {
			return getRuleContext(TransformationContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_location);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
                setState(98);
                match(T__8);
                setState(102);
                switch (getInterpreter().adaptivePredict(_input, 8, _ctx)) {
                    case 1:
				{
                    setState(99);
                    name();
                    setState(100);
                    match(T__9);
                }
				break;
			}
                setState(107);
                _errHandler.sync(this);
			_la = _input.LA(1);
                while (_la == T__25) {
                    {
				{
                    setState(104);
                    annotation();
				}
				}
                    setState(109);
                    _errHandler.sync(this);
				_la = _input.LA(1);
			}
                setState(110);
                transformation();
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

	public static class TransformationContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PilarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PilarParser.ID, i);
		}

        public ArgContext arg() {
            return getRuleContext(ArgContext.class, 0);
        }

        public ExpContext exp() {
            return getRuleContext(ExpContext.class, 0);
        }
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public JumpContext jump() {
			return getRuleContext(JumpContext.class,0);
		}
		public TransformationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transformation; }
	}

	public final TransformationContext transformation() throws RecognitionException {
		TransformationContext _localctx = new TransformationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_transformation);
		int _la;
		try {
            setState(135);
            switch (_input.LA(1)) {
                case T__10:
                    enterOuterAlt(_localctx, 1);
				{
                    setState(112);
                    match(T__10);
                    setState(116);
                    switch (getInterpreter().adaptivePredict(_input, 10, _ctx)) {
                        case 1:
					{
                        setState(113);
                        exp(0);
                        setState(114);
                        match(T__11);
                    }
					break;
				}
                    setState(118);
                    match(ID);
                    setState(119);
                    arg();
                    setState(122);
                    _la = _input.LA(1);
                    if (_la == T__12) {
                        {
                        setState(120);
                        match(T__12);
                        setState(121);
                            match(ID);
					}
				}

                    setState(124);
                    match(T__1);
                }
				break;
                case T__3:
                case T__7:
                case T__8:
                case T__12:
                case T__13:
			case T__14:
			case T__15:
			case T__16:
                case T__19:
                case T__20:
                case T__23:
                case ID:
				enterOuterAlt(_localctx, 2);
				{
                    setState(129);
                    _errHandler.sync(this);
				_la = _input.LA(1);
                    while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << ID))) != 0)) {
                        {
					{
                        setState(126);
                        action();
					}
					}
                        setState(131);
                        _errHandler.sync(this);
					_la = _input.LA(1);
				}
                    setState(133);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__16) | (1L << T__19) | (1L << T__20) | (1L << T__23))) != 0)) {
                        {
                        setState(132);
                            jump();
					}
				}

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

	public static class ActionContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode ID() { return getToken(PilarParser.ID, 0); }
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_action);
		int _la;
		try {
            setState(179);
            switch (_input.LA(1)) {
                case T__3:
                case ID:
				enterOuterAlt(_localctx, 1);
				{
                    setState(137);
                    exp(0);
                    setState(138);
                    match(T__11);
                    setState(139);
                    exp(0);
                    setState(143);
                    _errHandler.sync(this);
				_la = _input.LA(1);
                    while (_la == T__25) {
                        {
					{
                        setState(140);
                        annotation();
					}
					}
                        setState(145);
                        _errHandler.sync(this);
					_la = _input.LA(1);
				}
                    setState(146);
                    match(T__1);
                }
				break;
                case T__13:
                    enterOuterAlt(_localctx, 2);
				{
                    setState(148);
                    match(T__13);
                    setState(149);
                    exp(0);
                    setState(153);
                    _errHandler.sync(this);
				_la = _input.LA(1);
                    while (_la == T__25) {
                        {
					{
                        setState(150);
                        annotation();
					}
					}
                        setState(155);
                        _errHandler.sync(this);
					_la = _input.LA(1);
				}
                    setState(156);
                    match(T__1);
                }
				break;
                case T__14:
                    enterOuterAlt(_localctx, 3);
				{
                    setState(158);
                    match(T__14);
                    setState(159);
                    exp(0);
                    setState(163);
                    _errHandler.sync(this);
				_la = _input.LA(1);
                    while (_la == T__25) {
                        {
					{
                        setState(160);
                        annotation();
					}
					}
                        setState(165);
                        _errHandler.sync(this);
					_la = _input.LA(1);
				}
                    setState(166);
                    match(T__1);
                }
				break;
                case T__15:
                    enterOuterAlt(_localctx, 4);
				{
                    setState(168);
                    match(T__15);
                    setState(169);
                    match(ID);
                    setState(170);
                    arg();
                    setState(174);
                    _errHandler.sync(this);
				_la = _input.LA(1);
                    while (_la == T__25) {
                        {
					{
                        setState(171);
                        annotation();
					}
					}
                        setState(176);
                        _errHandler.sync(this);
					_la = _input.LA(1);
				}
                    setState(177);
                    match(T__1);
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

	public static class JumpContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<SwitchCaseContext> switchCase() {
			return getRuleContexts(SwitchCaseContext.class);
		}
		public SwitchCaseContext switchCase(int i) {
			return getRuleContext(SwitchCaseContext.class,i);
		}
		public TerminalNode ID() { return getToken(PilarParser.ID, 0); }
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public JumpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jump; }
	}

	public final JumpContext jump() throws RecognitionException {
		JumpContext _localctx = new JumpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_jump);
		int _la;
		try {
            setState(248);
            switch (_input.LA(1)) {
                case T__12:
                    enterOuterAlt(_localctx, 1);
				{
                    setState(181);
                    match(T__12);
                    setState(182);
                    name();
                    setState(186);
                    _errHandler.sync(this);
				_la = _input.LA(1);
                    while (_la == T__25) {
                        {
					{
                        setState(183);
                        annotation();
					}
					}
                        setState(188);
                        _errHandler.sync(this);
					_la = _input.LA(1);
				}
                    setState(189);
                    match(T__1);
                }
				break;
                case T__16:
                    enterOuterAlt(_localctx, 2);
				{
                    setState(191);
                    match(T__16);
                    setState(192);
                    exp(0);
                    setState(196);
                    _errHandler.sync(this);
				_la = _input.LA(1);
                    while (_la == T__25) {
                        {
					{
                        setState(193);
                        annotation();
					}
					}
                        setState(198);
                        _errHandler.sync(this);
					_la = _input.LA(1);
				}
                    setState(199);
                    match(T__17);
                    setState(200);
                    name();
                    setState(201);
                    match(T__18);
                    setState(202);
                    name();
                    setState(203);
                    match(T__1);
                }
				break;
                case T__19:
                    enterOuterAlt(_localctx, 3);
				{
                    setState(205);
                    match(T__19);
                    setState(206);
                    exp(0);
                    setState(210);
                    _errHandler.sync(this);
				_la = _input.LA(1);
                    while (_la == T__25) {
                        {
					{
                        setState(207);
                        annotation();
					}
					}
                        setState(212);
                        _errHandler.sync(this);
					_la = _input.LA(1);
				}
                    setState(213);
                    match(T__1);
                }
				break;
                case T__20:
                    enterOuterAlt(_localctx, 4);
				{
                    setState(215);
                    match(T__20);
                    setState(216);
                    exp(0);
                    setState(220);
                    _errHandler.sync(this);
				_la = _input.LA(1);
                    while (_la == T__24) {
                        {
					{
                        setState(217);
                        switchCase();
					}
					}
                        setState(222);
                        _errHandler.sync(this);
					_la = _input.LA(1);
				}
                    setState(223);
                    match(T__21);
                    setState(224);
                    match(T__22);
                    setState(225);
                    match(T__9);
                    setState(226);
                    name();
                    setState(230);
                    _errHandler.sync(this);
				_la = _input.LA(1);
                    while (_la == T__25) {
                        {
					{
                        setState(227);
                        annotation();
					}
					}
                        setState(232);
                        _errHandler.sync(this);
					_la = _input.LA(1);
				}
                    setState(233);
                    match(T__1);
                    setState(235);
                    _la = _input.LA(1);
                    if (_la == T__25) {
                        {
                        setState(234);
                            annotation();
					}
				}

				}
				break;
                case T__23:
                    enterOuterAlt(_localctx, 5);
				{
                    setState(237);
                    match(T__23);
                    setState(238);
                    match(ID);
                    setState(239);
                    arg();
                    setState(243);
                    _errHandler.sync(this);
				_la = _input.LA(1);
                    while (_la == T__25) {
                        {
					{
                        setState(240);
                        annotation();
					}
					}
                        setState(245);
                        _errHandler.sync(this);
					_la = _input.LA(1);
				}
                    setState(246);
                    match(T__1);
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

	public static class SwitchCaseContext extends ParserRuleContext {
		public LitContext lit() {
			return getRuleContext(LitContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public SwitchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchCase; }
	}

	public final SwitchCaseContext switchCase() throws RecognitionException {
		SwitchCaseContext _localctx = new SwitchCaseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_switchCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
                setState(250);
                match(T__24);
                setState(251);
                lit();
                setState(252);
                match(T__9);
                setState(253);
                name();
                setState(257);
                _errHandler.sync(this);
			_la = _input.LA(1);
                while (_la == T__25) {
                    {
				{
                    setState(254);
                    annotation();
				}
				}
                    setState(259);
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

	public static class ExpContext extends ParserRuleContext {
		public PrimContext prim() {
			return getRuleContext(PrimContext.class,0);
		}
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode ID() { return getToken(PilarParser.ID, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
                setState(261);
                prim();
                setState(265);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 29, _ctx);
                while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
                        setState(262);
                        arg();
					}
					} 
				}
                setState(267);
                    _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 29, _ctx);
                }
			}
			_ctx.stop = _input.LT(-1);
                setState(273);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 30, _ctx);
                while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
                        setState(268);
                        if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                        setState(269);
                        match(ID);
                        setState(270);
                        exp(2);
					}
					} 
				}
                setState(275);
                    _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 30, _ctx);
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

	public static class PrimContext extends ParserRuleContext {
		public LitContext lit() {
			return getRuleContext(LitContext.class,0);
		}
		public TerminalNode ID() { return getToken(PilarParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public PrimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prim; }
	}

	public final PrimContext prim() throws RecognitionException {
		PrimContext _localctx = new PrimContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_prim);
		int _la;
		try {
            setState(289);
            switch (getInterpreter().adaptivePredict(_input, 32, _ctx)) {
                case 1:
				enterOuterAlt(_localctx, 1);
				{
                    setState(276);
                    lit();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
                    setState(277);
                    match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
                    setState(278);
                    match(T__3);
                    setState(279);
                    exp(0);
                    setState(284);
                    _errHandler.sync(this);
				_la = _input.LA(1);
                    while (_la == T__4) {
                        {
					{
                        setState(280);
                        match(T__4);
                        setState(281);
                        exp(0);
					}
					}
                        setState(286);
                        _errHandler.sync(this);
					_la = _input.LA(1);
				}
                    setState(287);
                    match(T__5);
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

	public static class ArgContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
                setState(291);
                match(T__3);
                setState(300);
                _la = _input.LA(1);
                if (_la == T__3 || _la == ID) {
                    {
                    setState(292);
                        exp(0);
                    setState(297);
                        _errHandler.sync(this);
				_la = _input.LA(1);
                    while (_la == T__4) {
                        {
					{
                        setState(293);
                        match(T__4);
                        setState(294);
                        exp(0);
					}
					}
                        setState(299);
                        _errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

                setState(302);
                match(T__5);
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

	public static class LitContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PilarParser.ID, 0); }
		public TerminalNode LIT() { return getToken(PilarParser.LIT, 0); }
		public LitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit; }
	}

	public final LitContext lit() throws RecognitionException {
		LitContext _localctx = new LitContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_lit);
		try {
			enterOuterAlt(_localctx, 1);
			{
                setState(304);
                match(ID);
                setState(305);
                match(LIT);
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PilarParser.ID, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_name);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
                setState(307);
                match(ID);
                setState(311);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 35, _ctx);
                while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
                        setState(308);
                        annotation();
					}
					} 
				}
                setState(313);
                    _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 35, _ctx);
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

	public static class AnnotationContext extends ParserRuleContext {
		public LitContext lit() {
			return getRuleContext(LitContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
                setState(314);
                match(T__25);
                setState(315);
                lit();
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
		case 12: 
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\"\u0140\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\7\2.\n\2\f\2\16\2\61\13\2\3"+
                    "\3\3\3\5\3\65\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5A\n\5\f\5" +
                    "\16\5D\13\5\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\5\3\5\5\5O\n\5\3\6\3\6\3" +
                    "\7\3\7\7\7U\n\7\f\7\16\7X\13\7\3\7\6\7[\n\7\r\7\16\7\\\3\7\3\7\3\b\3\b" +
                    "\3\b\3\b\3\t\3\t\3\t\3\t\5\ti\n\t\3\t\7\tl\n\t\f\t\16\to\13\t\3\t\3\t" +
                    "\3\n\3\n\3\n\3\n\5\nw\n\n\3\n\3\n\3\n\3\n\5\n}\n\n\3\n\3\n\3\n\7\n\u0082" +
                    "\n\n\f\n\16\n\u0085\13\n\3\n\5\n\u0088\n\n\5\n\u008a\n\n\3\13\3\13\3\13" +
                    "\3\13\7\13\u0090\n\13\f\13\16\13\u0093\13\13\3\13\3\13\3\13\3\13\3\13" +
                    "\7\13\u009a\n\13\f\13\16\13\u009d\13\13\3\13\3\13\3\13\3\13\3\13\7\13" +
                    "\u00a4\n\13\f\13\16\13\u00a7\13\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13" +
                    "\u00af\n\13\f\13\16\13\u00b2\13\13\3\13\3\13\5\13\u00b6\n\13\3\f\3\f\3" +
                    "\f\7\f\u00bb\n\f\f\f\16\f\u00be\13\f\3\f\3\f\3\f\3\f\3\f\7\f\u00c5\n\f" +
                    "\f\f\16\f\u00c8\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00d3\n\f" +
                    "\f\f\16\f\u00d6\13\f\3\f\3\f\3\f\3\f\3\f\7\f\u00dd\n\f\f\f\16\f\u00e0" +
                    "\13\f\3\f\3\f\3\f\3\f\3\f\7\f\u00e7\n\f\f\f\16\f\u00ea\13\f\3\f\3\f\5" +
                    "\f\u00ee\n\f\3\f\3\f\3\f\3\f\7\f\u00f4\n\f\f\f\16\f\u00f7\13\f\3\f\3\f" +
                    "\5\f\u00fb\n\f\3\r\3\r\3\r\3\r\3\r\7\r\u0102\n\r\f\r\16\r\u0105\13\r\3" +
                    "\16\3\16\3\16\7\16\u010a\n\16\f\16\16\16\u010d\13\16\3\16\3\16\3\16\7" +
                    "\16\u0112\n\16\f\16\16\16\u0115\13\16\3\17\3\17\3\17\3\17\3\17\3\17\7" +
                    "\17\u011d\n\17\f\17\16\17\u0120\13\17\3\17\3\17\5\17\u0124\n\17\3\20\3" +
                    "\20\3\20\3\20\7\20\u012a\n\20\f\20\16\20\u012d\13\20\5\20\u012f\n\20\3" +
                    "\20\3\20\3\21\3\21\3\21\3\22\3\22\7\22\u0138\n\22\f\22\16\22\u013b\13" +
                    "\22\3\23\3\23\3\23\3\23\2\3\32\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34" +
                    "\36 \"$\2\2\u0157\2)\3\2\2\2\4\64\3\2\2\2\6\66\3\2\2\2\b:\3\2\2\2\nP\3" +
                    "\2\2\2\fR\3\2\2\2\16`\3\2\2\2\20d\3\2\2\2\22\u0089\3\2\2\2\24\u00b5\3" +
                    "\2\2\2\26\u00fa\3\2\2\2\30\u00fc\3\2\2\2\32\u0106\3\2\2\2\34\u0123\3\2" +
                    "\2\2\36\u0125\3\2\2\2 \u0132\3\2\2\2\"\u0135\3\2\2\2$\u013c\3\2\2\2&(" +
                    "\5$\23\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*/\3\2\2\2+)\3\2\2\2" +
                    ",.\5\4\3\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\3\3\2\2\2\61" +
                    "/\3\2\2\2\62\65\5\6\4\2\63\65\5\b\5\2\64\62\3\2\2\2\64\63\3\2\2\2\65\5" +
                    "\3\2\2\2\66\67\7\3\2\2\678\5\"\22\289\7\4\2\29\7\3\2\2\2:;\7\5\2\2;<\5" +
                    "\"\22\2<=\7\6\2\2=B\5\n\6\2>?\7\7\2\2?A\5\n\6\2@>\3\2\2\2AD\3\2\2\2B@" +
                    "\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EI\7\b\2\2FH\5$\23\2GF\3\2\2\2H" +
                    "K\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JN\3\2\2\2KI\3\2\2\2LO\5\f\7\2MO\7\4\2\2" +
                    "NL\3\2\2\2NM\3\2\2\2O\t\3\2\2\2PQ\5\"\22\2Q\13\3\2\2\2RV\7\t\2\2SU\5\16" +
                    "\b\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WZ\3\2\2\2XV\3\2\2\2Y[\5\20" +
                    "\t\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\7\n\2\2_\r" +
                    "\3\2\2\2`a\7\3\2\2ab\5\"\22\2bc\7\4\2\2c\17\3\2\2\2dh\7\13\2\2ef\5\"\22" +
                    "\2fg\7\f\2\2gi\3\2\2\2he\3\2\2\2hi\3\2\2\2im\3\2\2\2jl\5$\23\2kj\3\2\2" +
                    "\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\5\22\n\2q\21\3" +
                    "\2\2\2rv\7\r\2\2st\5\32\16\2tu\7\16\2\2uw\3\2\2\2vs\3\2\2\2vw\3\2\2\2" +
                    "wx\3\2\2\2xy\7\35\2\2y|\5\36\20\2z{\7\17\2\2{}\7\35\2\2|z\3\2\2\2|}\3" +
                    "\2\2\2}~\3\2\2\2~\177\7\4\2\2\177\u008a\3\2\2\2\u0080\u0082\5\24\13\2" +
                    "\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084" +
                    "\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0088\5\26\f\2" +
                    "\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089r\3" +
                    "\2\2\2\u0089\u0083\3\2\2\2\u008a\23\3\2\2\2\u008b\u008c\5\32\16\2\u008c" +
                    "\u008d\7\16\2\2\u008d\u0091\5\32\16\2\u008e\u0090\5$\23\2\u008f\u008e" +
                    "\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092" +
                    "\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7\4\2\2\u0095\u00b6\3\2" +
                    "\2\2\u0096\u0097\7\20\2\2\u0097\u009b\5\32\16\2\u0098\u009a\5$\23\2\u0099" +
                    "\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2" +
                    "\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\7\4\2\2\u009f" +
                    "\u00b6\3\2\2\2\u00a0\u00a1\7\21\2\2\u00a1\u00a5\5\32\16\2\u00a2\u00a4" +
                    "\5$\23\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5" +
                    "\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7\4" +
                    "\2\2\u00a9\u00b6\3\2\2\2\u00aa\u00ab\7\22\2\2\u00ab\u00ac\7\35\2\2\u00ac" +
                    "\u00b0\5\36\20\2\u00ad\u00af\5$\23\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3" +
                    "\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2" +
                    "\u00b0\3\2\2\2\u00b3\u00b4\7\4\2\2\u00b4\u00b6\3\2\2\2\u00b5\u008b\3\2" +
                    "\2\2\u00b5\u0096\3\2\2\2\u00b5\u00a0\3\2\2\2\u00b5\u00aa\3\2\2\2\u00b6" +
                    "\25\3\2\2\2\u00b7\u00b8\7\17\2\2\u00b8\u00bc\5\"\22\2\u00b9\u00bb\5$\23" +
                    "\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd" +
                    "\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7\4\2\2\u00c0" +
                    "\u00fb\3\2\2\2\u00c1\u00c2\7\23\2\2\u00c2\u00c6\5\32\16\2\u00c3\u00c5" +
                    "\5$\23\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6" +
                    "\u00c7\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca\7\24" +
                    "\2\2\u00ca\u00cb\5\"\22\2\u00cb\u00cc\7\25\2\2\u00cc\u00cd\5\"\22\2\u00cd" +
                    "\u00ce\7\4\2\2\u00ce\u00fb\3\2\2\2\u00cf\u00d0\7\26\2\2\u00d0\u00d4\5" +
                    "\32\16\2\u00d1\u00d3\5$\23\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4" +
                    "\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2" +
                    "\2\2\u00d7\u00d8\7\4\2\2\u00d8\u00fb\3\2\2\2\u00d9\u00da\7\27\2\2\u00da" +
                    "\u00de\5\32\16\2\u00db\u00dd\5\30\r\2\u00dc\u00db\3\2\2\2\u00dd\u00e0" +
                    "\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0" +
                    "\u00de\3\2\2\2\u00e1\u00e2\7\30\2\2\u00e2\u00e3\7\31\2\2\u00e3\u00e4\7" +
                    "\f\2\2\u00e4\u00e8\5\"\22\2\u00e5\u00e7\5$\23\2\u00e6\u00e5\3\2\2\2\u00e7" +
                    "\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2" +
                    "\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ed\7\4\2\2\u00ec\u00ee\5$\23\2\u00ed" +
                    "\u00ec\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00fb\3\2\2\2\u00ef\u00f0\7\32" +
                    "\2\2\u00f0\u00f1\7\35\2\2\u00f1\u00f5\5\36\20\2\u00f2\u00f4\5$\23\2\u00f3" +
                    "\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2" +
                    "\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\7\4\2\2\u00f9" +
                    "\u00fb\3\2\2\2\u00fa\u00b7\3\2\2\2\u00fa\u00c1\3\2\2\2\u00fa\u00cf\3\2" +
                    "\2\2\u00fa\u00d9\3\2\2\2\u00fa\u00ef\3\2\2\2\u00fb\27\3\2\2\2\u00fc\u00fd" +
                    "\7\33\2\2\u00fd\u00fe\5 \21\2\u00fe\u00ff\7\f\2\2\u00ff\u0103\5\"\22\2" +
                    "\u0100\u0102\5$\23\2\u0101\u0100\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101" +
                    "\3\2\2\2\u0103\u0104\3\2\2\2\u0104\31\3\2\2\2\u0105\u0103\3\2\2\2\u0106" +
                    "\u0107\b\16\1\2\u0107\u010b\5\34\17\2\u0108\u010a\5\36\20\2\u0109\u0108" +
                    "\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c" +
                    "\u0113\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u010f\f\3\2\2\u010f\u0110\7\35" +
                    "\2\2\u0110\u0112\5\32\16\4\u0111\u010e\3\2\2\2\u0112\u0115\3\2\2\2\u0113" +
                    "\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\33\3\2\2\2\u0115\u0113\3\2\2" +
                    "\2\u0116\u0124\5 \21\2\u0117\u0124\7\35\2\2\u0118\u0119\7\6\2\2\u0119" +
                    "\u011e\5\32\16\2\u011a\u011b\7\7\2\2\u011b\u011d\5\32\16\2\u011c\u011a" +
                    "\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f" +
                    "\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\7\b\2\2\u0122\u0124\3\2" +
                    "\2\2\u0123\u0116\3\2\2\2\u0123\u0117\3\2\2\2\u0123\u0118\3\2\2\2\u0124" +
                    "\35\3\2\2\2\u0125\u012e\7\6\2\2\u0126\u012b\5\32\16\2\u0127\u0128\7\7" +
                    "\2\2\u0128\u012a\5\32\16\2\u0129\u0127\3\2\2\2\u012a\u012d\3\2\2\2\u012b" +
                    "\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2" +
                    "\2\2\u012e\u0126\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130" +
                    "\u0131\7\b\2\2\u0131\37\3\2\2\2\u0132\u0133\7\35\2\2\u0133\u0134\7\36" +
                    "\2\2\u0134!\3\2\2\2\u0135\u0139\7\35\2\2\u0136\u0138\5$\23\2\u0137\u0136" +
                    "\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a" +
                    "#\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013d\7\34\2\2\u013d\u013e\5 \21\2" +
                    "\u013e%\3\2\2\2&)/\64BINV\\hmv|\u0083\u0087\u0089\u0091\u009b\u00a5\u00b0" +
                    "\u00b5\u00bc\u00c6\u00d4\u00de\u00e8\u00ed\u00f5\u00fa\u0103\u010b\u0113" +
                    "\u011e\u0123\u012b\u012e\u0139";
    public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}