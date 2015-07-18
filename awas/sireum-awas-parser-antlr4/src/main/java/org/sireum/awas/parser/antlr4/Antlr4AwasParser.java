// Generated from /Users/robby/Repositories/Sireum-Private/sireum-v3/awas/sireum-awas-parser-antlr4/src/main/resources/org/sireum/awas/parser/antlr4/Antlr4Awas.g4 by ANTLR 4.5.1
package org.sireum.awas.parser.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Antlr4AwasParser extends Parser {
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
            T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, T__28 = 29, T__29 = 30, INTEGER = 31,
            REAL = 32, STRING = 33, ID = 34, WS = 35, COMMENT = 36, LINE_COMMENT = 37, ERROR_CHAR = 38;
    public static final int
            RULE_modelFile = 0, RULE_model = 1, RULE_modelElement = 2, RULE_componentDecl = 3,
            RULE_connectionDecl = 4, RULE_enumDecl = 5, RULE_states = 6, RULE_transition = 7,
            RULE_dependency = 8, RULE_port = 9, RULE_property = 10, RULE_type = 11,
            RULE_basicType = 12, RULE_init = 13, RULE_mapEntry = 14;
    public static final String[] ruleNames = {
            "modelFile", "model", "modelElement", "componentDecl", "connectionDecl",
            "enumDecl", "states", "transition", "dependency", "port", "property",
            "type", "basicType", "init", "mapEntry"
    };

    private static final String[] _LITERAL_NAMES = {
            null, "'component'", "'ports'", "'dependencies'", "'properties'", "'connection'",
            "'.'", "'->'", "'enum'", "'states'", "'='", "'['", "','", "']'", "'transitions'",
            "'-['", "']->'", "'in'", "'out'", "':'", "'Set'", "'Seq'", "'Map'", "'Boolean'",
            "'Integer'", "'Real'", "'String'", "'true'", "'false'", "'('", "')'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, "INTEGER", "REAL", "STRING",
            "ID", "WS", "COMMENT", "LINE_COMMENT", "ERROR_CHAR"
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
    public ATN getATN() {
        return _ATN;
    }

    public Antlr4AwasParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class ModelFileContext extends ParserRuleContext {
        public ModelContext model() {
            return getRuleContext(ModelContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(Antlr4AwasParser.EOF, 0);
        }

        public ModelFileContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_modelFile;
        }
    }

    public final ModelFileContext modelFile() throws RecognitionException {
        ModelFileContext _localctx = new ModelFileContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_modelFile);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(30);
                model();
                setState(31);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ModelContext extends ParserRuleContext {
        public List<ModelElementContext> modelElement() {
            return getRuleContexts(ModelElementContext.class);
        }

        public ModelElementContext modelElement(int i) {
            return getRuleContext(ModelElementContext.class, i);
        }

        public ModelContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_model;
        }
    }

    public final ModelContext model() throws RecognitionException {
        ModelContext _localctx = new ModelContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_model);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(36);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__7))) != 0)) {
                    {
                        {
                            setState(33);
                            modelElement();
                        }
                    }
                    setState(38);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ModelElementContext extends ParserRuleContext {
        public ComponentDeclContext componentDecl() {
            return getRuleContext(ComponentDeclContext.class, 0);
        }

        public ConnectionDeclContext connectionDecl() {
            return getRuleContext(ConnectionDeclContext.class, 0);
        }

        public EnumDeclContext enumDecl() {
            return getRuleContext(EnumDeclContext.class, 0);
        }

        public ModelElementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_modelElement;
        }
    }

    public final ModelElementContext modelElement() throws RecognitionException {
        ModelElementContext _localctx = new ModelElementContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_modelElement);
        try {
            setState(42);
            switch (_input.LA(1)) {
                case T__0:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(39);
                    componentDecl();
                }
                break;
                case T__4:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(40);
                    connectionDecl();
                }
                break;
                case T__7:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(41);
                    enumDecl();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ComponentDeclContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(Antlr4AwasParser.ID, 0);
        }

        public StatesContext states() {
            return getRuleContext(StatesContext.class, 0);
        }

        public List<PortContext> port() {
            return getRuleContexts(PortContext.class);
        }

        public PortContext port(int i) {
            return getRuleContext(PortContext.class, i);
        }

        public List<PropertyContext> property() {
            return getRuleContexts(PropertyContext.class);
        }

        public PropertyContext property(int i) {
            return getRuleContext(PropertyContext.class, i);
        }

        public List<DependencyContext> dependency() {
            return getRuleContexts(DependencyContext.class);
        }

        public DependencyContext dependency(int i) {
            return getRuleContext(DependencyContext.class, i);
        }

        public ComponentDeclContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_componentDecl;
        }
    }

    public final ComponentDeclContext componentDecl() throws RecognitionException {
        ComponentDeclContext _localctx = new ComponentDeclContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_componentDecl);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(44);
                match(T__0);
                setState(45);
                match(ID);
                setState(62);
                _la = _input.LA(1);
                if (_la == T__1) {
                    {
                        setState(46);
                        match(T__1);
                        setState(50);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == T__16 || _la == T__17) {
                            {
                                {
                                    setState(47);
                                    port();
                                }
                            }
                            setState(52);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(60);
                        _la = _input.LA(1);
                        if (_la == T__2) {
                            {
                                setState(53);
                                match(T__2);
                                setState(57);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                while (_la == ID) {
                                    {
                                        {
                                            setState(54);
                                            dependency();
                                        }
                                    }
                                    setState(59);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                }
                            }
                        }

                    }
                }

                setState(71);
                _la = _input.LA(1);
                if (_la == T__3) {
                    {
                        setState(64);
                        match(T__3);
                        setState(68);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == ID) {
                            {
                                {
                                    setState(65);
                                    property();
                                }
                            }
                            setState(70);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

                setState(74);
                _la = _input.LA(1);
                if (_la == T__8) {
                    {
                        setState(73);
                        states();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ConnectionDeclContext extends ParserRuleContext {
        public Token from;
        public Token fromPort;
        public Token to;
        public Token toPort;

        public List<TerminalNode> ID() {
            return getTokens(Antlr4AwasParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(Antlr4AwasParser.ID, i);
        }

        public List<PropertyContext> property() {
            return getRuleContexts(PropertyContext.class);
        }

        public PropertyContext property(int i) {
            return getRuleContext(PropertyContext.class, i);
        }

        public ConnectionDeclContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_connectionDecl;
        }
    }

    public final ConnectionDeclContext connectionDecl() throws RecognitionException {
        ConnectionDeclContext _localctx = new ConnectionDeclContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_connectionDecl);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(76);
                match(T__4);
                setState(77);
                ((ConnectionDeclContext) _localctx).from = match(ID);
                setState(80);
                _la = _input.LA(1);
                if (_la == T__5) {
                    {
                        setState(78);
                        match(T__5);
                        setState(79);
                        ((ConnectionDeclContext) _localctx).fromPort = match(ID);
                    }
                }

                setState(82);
                match(T__6);
                setState(83);
                ((ConnectionDeclContext) _localctx).to = match(ID);
                setState(86);
                _la = _input.LA(1);
                if (_la == T__5) {
                    {
                        setState(84);
                        match(T__5);
                        setState(85);
                        ((ConnectionDeclContext) _localctx).toPort = match(ID);
                    }
                }

                setState(95);
                _la = _input.LA(1);
                if (_la == T__3) {
                    {
                        setState(88);
                        match(T__3);
                        setState(92);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == ID) {
                            {
                                {
                                    setState(89);
                                    property();
                                }
                            }
                            setState(94);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class EnumDeclContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(Antlr4AwasParser.ID, 0);
        }

        public EnumDeclContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_enumDecl;
        }
    }

    public final EnumDeclContext enumDecl() throws RecognitionException {
        EnumDeclContext _localctx = new EnumDeclContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_enumDecl);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(97);
                match(T__7);
                setState(98);
                match(ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StatesContext extends ParserRuleContext {
        public List<TerminalNode> ID() {
            return getTokens(Antlr4AwasParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(Antlr4AwasParser.ID, i);
        }

        public List<TransitionContext> transition() {
            return getRuleContexts(TransitionContext.class);
        }

        public TransitionContext transition(int i) {
            return getRuleContext(TransitionContext.class, i);
        }

        public StatesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_states;
        }
    }

    public final StatesContext states() throws RecognitionException {
        StatesContext _localctx = new StatesContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_states);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(100);
                match(T__8);
                setState(101);
                match(T__9);
                setState(102);
                match(T__10);
                setState(103);
                match(ID);
                setState(108);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__11) {
                    {
                        {
                            setState(104);
                            match(T__11);
                            setState(105);
                            match(ID);
                        }
                    }
                    setState(110);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(111);
                match(T__12);
                setState(119);
                _la = _input.LA(1);
                if (_la == T__13) {
                    {
                        setState(112);
                        match(T__13);
                        setState(116);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == ID) {
                            {
                                {
                                    setState(113);
                                    transition();
                                }
                            }
                            setState(118);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TransitionContext extends ParserRuleContext {
        public Token fromState;
        public Token toState;

        public List<TerminalNode> ID() {
            return getTokens(Antlr4AwasParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(Antlr4AwasParser.ID, i);
        }

        public TransitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_transition;
        }
    }

    public final TransitionContext transition() throws RecognitionException {
        TransitionContext _localctx = new TransitionContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_transition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(121);
                ((TransitionContext) _localctx).fromState = match(ID);
                setState(122);
                match(T__14);
                setState(123);
                match(T__15);
                setState(124);
                ((TransitionContext) _localctx).toState = match(ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DependencyContext extends ParserRuleContext {
        public Token fromPort;
        public Token toPort;

        public List<TerminalNode> ID() {
            return getTokens(Antlr4AwasParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(Antlr4AwasParser.ID, i);
        }

        public DependencyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dependency;
        }
    }

    public final DependencyContext dependency() throws RecognitionException {
        DependencyContext _localctx = new DependencyContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_dependency);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(126);
                ((DependencyContext) _localctx).fromPort = match(ID);
                setState(127);
                match(T__6);
                setState(128);
                ((DependencyContext) _localctx).toPort = match(ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PortContext extends ParserRuleContext {
        public Token mod;

        public TerminalNode ID() {
            return getToken(Antlr4AwasParser.ID, 0);
        }

        public PortContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_port;
        }
    }

    public final PortContext port() throws RecognitionException {
        PortContext _localctx = new PortContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_port);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(130);
                ((PortContext) _localctx).mod = _input.LT(1);
                _la = _input.LA(1);
                if (!(_la == T__16 || _la == T__17)) {
                    ((PortContext) _localctx).mod = (Token) _errHandler.recoverInline(this);
                } else {
                    consume();
                }
                setState(131);
                match(ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PropertyContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(Antlr4AwasParser.ID, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public InitContext init() {
            return getRuleContext(InitContext.class, 0);
        }

        public PropertyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_property;
        }
    }

    public final PropertyContext property() throws RecognitionException {
        PropertyContext _localctx = new PropertyContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_property);
        int _la;
        try {
            setState(143);
            switch (getInterpreter().adaptivePredict(_input, 17, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(133);
                    match(ID);
                    setState(134);
                    match(T__18);
                    setState(135);
                    type();
                    setState(138);
                    _la = _input.LA(1);
                    if (_la == T__9) {
                        {
                            setState(136);
                            match(T__9);
                            setState(137);
                            init();
                        }
                    }

                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(140);
                    match(ID);
                    setState(141);
                    match(T__9);
                    setState(142);
                    init();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TypeContext extends ParserRuleContext {
        public TypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_type;
        }

        public TypeContext() {
        }

        public void copyFrom(TypeContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class BaseTypeContext extends TypeContext {
        public BasicTypeContext basicType() {
            return getRuleContext(BasicTypeContext.class, 0);
        }

        public BaseTypeContext(TypeContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class SetTypeContext extends TypeContext {
        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public SetTypeContext(TypeContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class EnumTypeContext extends TypeContext {
        public TerminalNode ID() {
            return getToken(Antlr4AwasParser.ID, 0);
        }

        public EnumTypeContext(TypeContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class SeqTypeContext extends TypeContext {
        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public SeqTypeContext(TypeContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class MapTypeContext extends TypeContext {
        public BasicTypeContext basicType() {
            return getRuleContext(BasicTypeContext.class, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public MapTypeContext(TypeContext ctx) {
            copyFrom(ctx);
        }
    }

    public final TypeContext type() throws RecognitionException {
        TypeContext _localctx = new TypeContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_type);
        try {
            setState(164);
            switch (_input.LA(1)) {
                case T__22:
                case T__23:
                case T__24:
                case T__25:
                    _localctx = new BaseTypeContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(145);
                    basicType();
                }
                break;
                case ID:
                    _localctx = new EnumTypeContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(146);
                    match(ID);
                }
                break;
                case T__19:
                    _localctx = new SetTypeContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(147);
                    match(T__19);
                    setState(148);
                    match(T__10);
                    setState(149);
                    type();
                    setState(150);
                    match(T__12);
                }
                break;
                case T__20:
                    _localctx = new SeqTypeContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(152);
                    match(T__20);
                    setState(153);
                    match(T__10);
                    setState(154);
                    type();
                    setState(155);
                    match(T__12);
                }
                break;
                case T__21:
                    _localctx = new MapTypeContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(157);
                    match(T__21);
                    setState(158);
                    match(T__10);
                    setState(159);
                    basicType();
                    setState(160);
                    match(T__11);
                    setState(161);
                    type();
                    setState(162);
                    match(T__12);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BasicTypeContext extends ParserRuleContext {
        public BasicTypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_basicType;
        }

        public BasicTypeContext() {
        }

        public void copyFrom(BasicTypeContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class IntegerTypeContext extends BasicTypeContext {
        public IntegerTypeContext(BasicTypeContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class StringTypeContext extends BasicTypeContext {
        public StringTypeContext(BasicTypeContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class BooleanTypeContext extends BasicTypeContext {
        public BooleanTypeContext(BasicTypeContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class RealTypeContext extends BasicTypeContext {
        public RealTypeContext(BasicTypeContext ctx) {
            copyFrom(ctx);
        }
    }

    public final BasicTypeContext basicType() throws RecognitionException {
        BasicTypeContext _localctx = new BasicTypeContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_basicType);
        try {
            setState(170);
            switch (_input.LA(1)) {
                case T__22:
                    _localctx = new BooleanTypeContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(166);
                    match(T__22);
                }
                break;
                case T__23:
                    _localctx = new IntegerTypeContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(167);
                    match(T__23);
                }
                break;
                case T__24:
                    _localctx = new RealTypeContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(168);
                    match(T__24);
                }
                break;
                case T__25:
                    _localctx = new StringTypeContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(169);
                    match(T__25);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InitContext extends ParserRuleContext {
        public InitContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_init;
        }

        public InitContext() {
        }

        public void copyFrom(InitContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class IntegerContext extends InitContext {
        public TerminalNode INTEGER() {
            return getToken(Antlr4AwasParser.INTEGER, 0);
        }

        public IntegerContext(InitContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class SetContext extends InitContext {
        public List<InitContext> init() {
            return getRuleContexts(InitContext.class);
        }

        public InitContext init(int i) {
            return getRuleContext(InitContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public SetContext(InitContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class RealContext extends InitContext {
        public TerminalNode REAL() {
            return getToken(Antlr4AwasParser.REAL, 0);
        }

        public RealContext(InitContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class TrueContext extends InitContext {
        public TrueContext(InitContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class FalseContext extends InitContext {
        public FalseContext(InitContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class StringContext extends InitContext {
        public TerminalNode STRING() {
            return getToken(Antlr4AwasParser.STRING, 0);
        }

        public StringContext(InitContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class MapContext extends InitContext {
        public List<MapEntryContext> mapEntry() {
            return getRuleContexts(MapEntryContext.class);
        }

        public MapEntryContext mapEntry(int i) {
            return getRuleContext(MapEntryContext.class, i);
        }

        public BasicTypeContext basicType() {
            return getRuleContext(BasicTypeContext.class, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public MapContext(InitContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class EnumElementContext extends InitContext {
        public TerminalNode ID() {
            return getToken(Antlr4AwasParser.ID, 0);
        }

        public EnumElementContext(InitContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class SeqContext extends InitContext {
        public List<InitContext> init() {
            return getRuleContexts(InitContext.class);
        }

        public InitContext init(int i) {
            return getRuleContext(InitContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public SeqContext(InitContext ctx) {
            copyFrom(ctx);
        }
    }

    public final InitContext init() throws RecognitionException {
        InitContext _localctx = new InitContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_init);
        int _la;
        try {
            setState(234);
            switch (_input.LA(1)) {
                case T__26:
                    _localctx = new TrueContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(172);
                    match(T__26);
                }
                break;
                case T__27:
                    _localctx = new FalseContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(173);
                    match(T__27);
                }
                break;
                case INTEGER:
                    _localctx = new IntegerContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(174);
                    match(INTEGER);
                }
                break;
                case REAL:
                    _localctx = new RealContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(175);
                    match(REAL);
                }
                break;
                case STRING:
                    _localctx = new StringContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(176);
                    match(STRING);
                }
                break;
                case ID:
                    _localctx = new EnumElementContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(177);
                    match(ID);
                }
                break;
                case T__19:
                    _localctx = new SetContext(_localctx);
                    enterOuterAlt(_localctx, 7);
                {
                    setState(178);
                    match(T__19);
                    setState(183);
                    _la = _input.LA(1);
                    if (_la == T__10) {
                        {
                            setState(179);
                            match(T__10);
                            setState(180);
                            type();
                            setState(181);
                            match(T__12);
                        }
                    }

                    setState(185);
                    match(T__28);
                    setState(186);
                    init();
                    setState(191);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T__11) {
                        {
                            {
                                setState(187);
                                match(T__11);
                                setState(188);
                                init();
                            }
                        }
                        setState(193);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(194);
                    match(T__29);
                }
                break;
                case T__20:
                    _localctx = new SeqContext(_localctx);
                    enterOuterAlt(_localctx, 8);
                {
                    setState(196);
                    match(T__20);
                    setState(201);
                    _la = _input.LA(1);
                    if (_la == T__10) {
                        {
                            setState(197);
                            match(T__10);
                            setState(198);
                            type();
                            setState(199);
                            match(T__12);
                        }
                    }

                    setState(203);
                    match(T__28);
                    setState(204);
                    init();
                    setState(209);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T__11) {
                        {
                            {
                                setState(205);
                                match(T__11);
                                setState(206);
                                init();
                            }
                        }
                        setState(211);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(212);
                    match(T__29);
                }
                break;
                case T__21:
                    _localctx = new MapContext(_localctx);
                    enterOuterAlt(_localctx, 9);
                {
                    setState(214);
                    match(T__21);
                    setState(221);
                    _la = _input.LA(1);
                    if (_la == T__10) {
                        {
                            setState(215);
                            match(T__10);
                            setState(216);
                            basicType();
                            setState(217);
                            match(T__11);
                            setState(218);
                            type();
                            setState(219);
                            match(T__12);
                        }
                    }

                    setState(223);
                    match(T__28);
                    setState(224);
                    mapEntry();
                    setState(229);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T__11) {
                        {
                            {
                                setState(225);
                                match(T__11);
                                setState(226);
                                mapEntry();
                            }
                        }
                        setState(231);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(232);
                    match(T__29);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class MapEntryContext extends ParserRuleContext {
        public InitContext key;
        public InitContext value;

        public List<InitContext> init() {
            return getRuleContexts(InitContext.class);
        }

        public InitContext init(int i) {
            return getRuleContext(InitContext.class, i);
        }

        public MapEntryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_mapEntry;
        }
    }

    public final MapEntryContext mapEntry() throws RecognitionException {
        MapEntryContext _localctx = new MapEntryContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_mapEntry);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(236);
                ((MapEntryContext) _localctx).key = init();
                setState(237);
                match(T__6);
                setState(238);
                ((MapEntryContext) _localctx).value = init();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3(\u00f3\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\3\7\3" +
                    "%\n\3\f\3\16\3(\13\3\3\4\3\4\3\4\5\4-\n\4\3\5\3\5\3\5\3\5\7\5\63\n\5\f" +
                    "\5\16\5\66\13\5\3\5\3\5\7\5:\n\5\f\5\16\5=\13\5\5\5?\n\5\5\5A\n\5\3\5" +
                    "\3\5\7\5E\n\5\f\5\16\5H\13\5\5\5J\n\5\3\5\5\5M\n\5\3\6\3\6\3\6\3\6\5\6" +
                    "S\n\6\3\6\3\6\3\6\3\6\5\6Y\n\6\3\6\3\6\7\6]\n\6\f\6\16\6`\13\6\5\6b\n" +
                    "\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bm\n\b\f\b\16\bp\13\b\3\b\3\b" +
                    "\3\b\7\bu\n\b\f\b\16\bx\13\b\5\bz\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n" +
                    "\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u008d\n\f\3\f\3\f\3\f\5\f" +
                    "\u0092\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r" +
                    "\3\r\3\r\3\r\3\r\5\r\u00a7\n\r\3\16\3\16\3\16\3\16\5\16\u00ad\n\16\3\17" +
                    "\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ba\n\17\3\17" +
                    "\3\17\3\17\3\17\7\17\u00c0\n\17\f\17\16\17\u00c3\13\17\3\17\3\17\3\17" +
                    "\3\17\3\17\3\17\3\17\5\17\u00cc\n\17\3\17\3\17\3\17\3\17\7\17\u00d2\n" +
                    "\17\f\17\16\17\u00d5\13\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17" +
                    "\5\17\u00e0\n\17\3\17\3\17\3\17\3\17\7\17\u00e6\n\17\f\17\16\17\u00e9" +
                    "\13\17\3\17\3\17\5\17\u00ed\n\17\3\20\3\20\3\20\3\20\3\20\2\2\21\2\4\6" +
                    "\b\n\f\16\20\22\24\26\30\32\34\36\2\3\3\2\23\24\u010b\2 \3\2\2\2\4&\3" +
                    "\2\2\2\6,\3\2\2\2\b.\3\2\2\2\nN\3\2\2\2\fc\3\2\2\2\16f\3\2\2\2\20{\3\2" +
                    "\2\2\22\u0080\3\2\2\2\24\u0084\3\2\2\2\26\u0091\3\2\2\2\30\u00a6\3\2\2" +
                    "\2\32\u00ac\3\2\2\2\34\u00ec\3\2\2\2\36\u00ee\3\2\2\2 !\5\4\3\2!\"\7\2" +
                    "\2\3\"\3\3\2\2\2#%\5\6\4\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'" +
                    "\5\3\2\2\2(&\3\2\2\2)-\5\b\5\2*-\5\n\6\2+-\5\f\7\2,)\3\2\2\2,*\3\2\2\2" +
                    ",+\3\2\2\2-\7\3\2\2\2./\7\3\2\2/@\7$\2\2\60\64\7\4\2\2\61\63\5\24\13\2" +
                    "\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65>\3\2\2\2\66" +
                    "\64\3\2\2\2\67;\7\5\2\28:\5\22\n\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2" +
                    "\2\2<?\3\2\2\2=;\3\2\2\2>\67\3\2\2\2>?\3\2\2\2?A\3\2\2\2@\60\3\2\2\2@" +
                    "A\3\2\2\2AI\3\2\2\2BF\7\6\2\2CE\5\26\f\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2" +
                    "FG\3\2\2\2GJ\3\2\2\2HF\3\2\2\2IB\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KM\5\16\b" +
                    "\2LK\3\2\2\2LM\3\2\2\2M\t\3\2\2\2NO\7\7\2\2OR\7$\2\2PQ\7\b\2\2QS\7$\2" +
                    "\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7\t\2\2UX\7$\2\2VW\7\b\2\2WY\7$\2\2" +
                    "XV\3\2\2\2XY\3\2\2\2Ya\3\2\2\2Z^\7\6\2\2[]\5\26\f\2\\[\3\2\2\2]`\3\2\2" +
                    "\2^\\\3\2\2\2^_\3\2\2\2_b\3\2\2\2`^\3\2\2\2aZ\3\2\2\2ab\3\2\2\2b\13\3" +
                    "\2\2\2cd\7\n\2\2de\7$\2\2e\r\3\2\2\2fg\7\13\2\2gh\7\f\2\2hi\7\r\2\2in" +
                    "\7$\2\2jk\7\16\2\2km\7$\2\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq" +
                    "\3\2\2\2pn\3\2\2\2qy\7\17\2\2rv\7\20\2\2su\5\20\t\2ts\3\2\2\2ux\3\2\2" +
                    "\2vt\3\2\2\2vw\3\2\2\2wz\3\2\2\2xv\3\2\2\2yr\3\2\2\2yz\3\2\2\2z\17\3\2" +
                    "\2\2{|\7$\2\2|}\7\21\2\2}~\7\22\2\2~\177\7$\2\2\177\21\3\2\2\2\u0080\u0081" +
                    "\7$\2\2\u0081\u0082\7\t\2\2\u0082\u0083\7$\2\2\u0083\23\3\2\2\2\u0084" +
                    "\u0085\t\2\2\2\u0085\u0086\7$\2\2\u0086\25\3\2\2\2\u0087\u0088\7$\2\2" +
                    "\u0088\u0089\7\25\2\2\u0089\u008c\5\30\r\2\u008a\u008b\7\f\2\2\u008b\u008d" +
                    "\5\34\17\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u0092\3\2\2\2" +
                    "\u008e\u008f\7$\2\2\u008f\u0090\7\f\2\2\u0090\u0092\5\34\17\2\u0091\u0087" +
                    "\3\2\2\2\u0091\u008e\3\2\2\2\u0092\27\3\2\2\2\u0093\u00a7\5\32\16\2\u0094" +
                    "\u00a7\7$\2\2\u0095\u0096\7\26\2\2\u0096\u0097\7\r\2\2\u0097\u0098\5\30" +
                    "\r\2\u0098\u0099\7\17\2\2\u0099\u00a7\3\2\2\2\u009a\u009b\7\27\2\2\u009b" +
                    "\u009c\7\r\2\2\u009c\u009d\5\30\r\2\u009d\u009e\7\17\2\2\u009e\u00a7\3" +
                    "\2\2\2\u009f\u00a0\7\30\2\2\u00a0\u00a1\7\r\2\2\u00a1\u00a2\5\32\16\2" +
                    "\u00a2\u00a3\7\16\2\2\u00a3\u00a4\5\30\r\2\u00a4\u00a5\7\17\2\2\u00a5" +
                    "\u00a7\3\2\2\2\u00a6\u0093\3\2\2\2\u00a6\u0094\3\2\2\2\u00a6\u0095\3\2" +
                    "\2\2\u00a6\u009a\3\2\2\2\u00a6\u009f\3\2\2\2\u00a7\31\3\2\2\2\u00a8\u00ad" +
                    "\7\31\2\2\u00a9\u00ad\7\32\2\2\u00aa\u00ad\7\33\2\2\u00ab\u00ad\7\34\2" +
                    "\2\u00ac\u00a8\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab" +
                    "\3\2\2\2\u00ad\33\3\2\2\2\u00ae\u00ed\7\35\2\2\u00af\u00ed\7\36\2\2\u00b0" +
                    "\u00ed\7!\2\2\u00b1\u00ed\7\"\2\2\u00b2\u00ed\7#\2\2\u00b3\u00ed\7$\2" +
                    "\2\u00b4\u00b9\7\26\2\2\u00b5\u00b6\7\r\2\2\u00b6\u00b7\5\30\r\2\u00b7" +
                    "\u00b8\7\17\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b5\3\2\2\2\u00b9\u00ba\3" +
                    "\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7\37\2\2\u00bc\u00c1\5\34\17\2" +
                    "\u00bd\u00be\7\16\2\2\u00be\u00c0\5\34\17\2\u00bf\u00bd\3\2\2\2\u00c0" +
                    "\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2" +
                    "\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\7 \2\2\u00c5\u00ed\3\2\2\2\u00c6" +
                    "\u00cb\7\27\2\2\u00c7\u00c8\7\r\2\2\u00c8\u00c9\5\30\r\2\u00c9\u00ca\7" +
                    "\17\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c7\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc" +
                    "\u00cd\3\2\2\2\u00cd\u00ce\7\37\2\2\u00ce\u00d3\5\34\17\2\u00cf\u00d0" +
                    "\7\16\2\2\u00d0\u00d2\5\34\17\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2\2" +
                    "\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3" +
                    "\3\2\2\2\u00d6\u00d7\7 \2\2\u00d7\u00ed\3\2\2\2\u00d8\u00df\7\30\2\2\u00d9" +
                    "\u00da\7\r\2\2\u00da\u00db\5\32\16\2\u00db\u00dc\7\16\2\2\u00dc\u00dd" +
                    "\5\30\r\2\u00dd\u00de\7\17\2\2\u00de\u00e0\3\2\2\2\u00df\u00d9\3\2\2\2" +
                    "\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\7\37\2\2\u00e2\u00e7" +
                    "\5\36\20\2\u00e3\u00e4\7\16\2\2\u00e4\u00e6\5\36\20\2\u00e5\u00e3\3\2" +
                    "\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8" +
                    "\u00ea\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\7 \2\2\u00eb\u00ed\3\2" +
                    "\2\2\u00ec\u00ae\3\2\2\2\u00ec\u00af\3\2\2\2\u00ec\u00b0\3\2\2\2\u00ec" +
                    "\u00b1\3\2\2\2\u00ec\u00b2\3\2\2\2\u00ec\u00b3\3\2\2\2\u00ec\u00b4\3\2" +
                    "\2\2\u00ec\u00c6\3\2\2\2\u00ec\u00d8\3\2\2\2\u00ed\35\3\2\2\2\u00ee\u00ef" +
                    "\5\34\17\2\u00ef\u00f0\7\t\2\2\u00f0\u00f1\5\34\17\2\u00f1\37\3\2\2\2" +
                    "\35&,\64;>@FILRX^anvy\u008c\u0091\u00a6\u00ac\u00b9\u00c1\u00cb\u00d3" +
                    "\u00df\u00e7\u00ec";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}