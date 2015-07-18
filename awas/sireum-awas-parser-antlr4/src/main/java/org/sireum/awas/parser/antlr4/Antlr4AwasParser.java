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
            T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, T__28 = 29, T__29 = 30, T__30 = 31,
            T__31 = 32, INTEGER = 33, REAL = 34, STRING = 35, ID = 36, WS = 37, COMMENT = 38, LINE_COMMENT = 39,
            ERROR_CHAR = 40;
    public static final int
            RULE_modelFile = 0, RULE_model = 1, RULE_modelElement = 2, RULE_enclosureDecl = 3,
            RULE_componentDecl = 4, RULE_connectionDecl = 5, RULE_enumDecl = 6, RULE_states = 7,
            RULE_transition = 8, RULE_dependency = 9, RULE_port = 10, RULE_property = 11,
            RULE_type = 12, RULE_basicType = 13, RULE_init = 14, RULE_mapEntry = 15;
    public static final String[] ruleNames = {
            "modelFile", "model", "modelElement", "enclosureDecl", "componentDecl",
            "connectionDecl", "enumDecl", "states", "transition", "dependency", "port",
            "property", "type", "basicType", "init", "mapEntry"
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
                setState(32);
                model();
                setState(33);
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
                setState(38);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__5) | (1L << T__8))) != 0)) {
                    {
                        {
                            setState(35);
                            modelElement();
                        }
                    }
                    setState(40);
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

        public EnclosureDeclContext enclosureDecl() {
            return getRuleContext(EnclosureDeclContext.class, 0);
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
            setState(45);
            switch (_input.LA(1)) {
                case T__1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(41);
                    componentDecl();
                }
                break;
                case T__5:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(42);
                    connectionDecl();
                }
                break;
                case T__8:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(43);
                    enumDecl();
                }
                break;
                case T__0:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(44);
                    enclosureDecl();
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

    public static class EnclosureDeclContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(Antlr4AwasParser.ID, 0);
        }

        public EnclosureDeclContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_enclosureDecl;
        }
    }

    public final EnclosureDeclContext enclosureDecl() throws RecognitionException {
        EnclosureDeclContext _localctx = new EnclosureDeclContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_enclosureDecl);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(47);
                match(T__0);
                setState(48);
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
        enterRule(_localctx, 8, RULE_componentDecl);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(50);
                match(T__1);
                setState(51);
                match(ID);
                setState(68);
                _la = _input.LA(1);
                if (_la == T__2) {
                    {
                        setState(52);
                        match(T__2);
                        setState(56);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == T__18 || _la == T__19) {
                            {
                                {
                                    setState(53);
                                    port();
                                }
                            }
                            setState(58);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(66);
                        _la = _input.LA(1);
                        if (_la == T__3) {
                            {
                                setState(59);
                                match(T__3);
                                setState(63);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                while (_la == ID) {
                                    {
                                        {
                                            setState(60);
                                            dependency();
                                        }
                                    }
                                    setState(65);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                }
                            }
                        }

                    }
                }

                setState(77);
                _la = _input.LA(1);
                if (_la == T__4) {
                    {
                        setState(70);
                        match(T__4);
                        setState(74);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == ID) {
                            {
                                {
                                    setState(71);
                                    property();
                                }
                            }
                            setState(76);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

                setState(80);
                _la = _input.LA(1);
                if (_la == T__11) {
                    {
                        setState(79);
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
        enterRule(_localctx, 10, RULE_connectionDecl);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(82);
                match(T__5);
                setState(83);
                ((ConnectionDeclContext) _localctx).from = match(ID);
                setState(86);
                _la = _input.LA(1);
                if (_la == T__6) {
                    {
                        setState(84);
                        match(T__6);
                        setState(85);
                        ((ConnectionDeclContext) _localctx).fromPort = match(ID);
                    }
                }

                setState(88);
                match(T__7);
                setState(89);
                ((ConnectionDeclContext) _localctx).to = match(ID);
                setState(92);
                _la = _input.LA(1);
                if (_la == T__6) {
                    {
                        setState(90);
                        match(T__6);
                        setState(91);
                        ((ConnectionDeclContext) _localctx).toPort = match(ID);
                    }
                }

                setState(101);
                _la = _input.LA(1);
                if (_la == T__4) {
                    {
                        setState(94);
                        match(T__4);
                        setState(98);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == ID) {
                            {
                                {
                                    setState(95);
                                    property();
                                }
                            }
                            setState(100);
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
        public Token id;
        public Token ID;
        public List<Token> supers = new ArrayList<Token>();

        public List<TerminalNode> ID() {
            return getTokens(Antlr4AwasParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(Antlr4AwasParser.ID, i);
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
        enterRule(_localctx, 12, RULE_enumDecl);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(103);
                match(T__8);
                setState(104);
                ((EnumDeclContext) _localctx).id = match(ID);
                setState(114);
                _la = _input.LA(1);
                if (_la == T__9) {
                    {
                        setState(105);
                        match(T__9);
                        setState(106);
                        ((EnumDeclContext) _localctx).ID = match(ID);
                        ((EnumDeclContext) _localctx).supers.add(((EnumDeclContext) _localctx).ID);
                        setState(111);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == T__10) {
                            {
                                {
                                    setState(107);
                                    match(T__10);
                                    setState(108);
                                    ((EnumDeclContext) _localctx).ID = match(ID);
                                    ((EnumDeclContext) _localctx).supers.add(((EnumDeclContext) _localctx).ID);
                                }
                            }
                            setState(113);
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
        enterRule(_localctx, 14, RULE_states);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(116);
                match(T__11);
                setState(117);
                match(T__12);
                setState(118);
                match(T__13);
                setState(119);
                match(ID);
                setState(124);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__10) {
                    {
                        {
                            setState(120);
                            match(T__10);
                            setState(121);
                            match(ID);
                        }
                    }
                    setState(126);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(127);
                match(T__14);
                setState(135);
                _la = _input.LA(1);
                if (_la == T__15) {
                    {
                        setState(128);
                        match(T__15);
                        setState(132);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == ID) {
                            {
                                {
                                    setState(129);
                                    transition();
                                }
                            }
                            setState(134);
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
        enterRule(_localctx, 16, RULE_transition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(137);
                ((TransitionContext) _localctx).fromState = match(ID);
                setState(138);
                match(T__16);
                setState(139);
                match(T__17);
                setState(140);
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
        enterRule(_localctx, 18, RULE_dependency);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(142);
                ((DependencyContext) _localctx).fromPort = match(ID);
                setState(143);
                match(T__7);
                setState(144);
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
        enterRule(_localctx, 20, RULE_port);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(146);
                ((PortContext) _localctx).mod = _input.LT(1);
                _la = _input.LA(1);
                if (!(_la == T__18 || _la == T__19)) {
                    ((PortContext) _localctx).mod = (Token) _errHandler.recoverInline(this);
                } else {
                    consume();
                }
                setState(147);
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
        enterRule(_localctx, 22, RULE_property);
        int _la;
        try {
            setState(159);
            switch (getInterpreter().adaptivePredict(_input, 19, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(149);
                    match(ID);
                    setState(150);
                    match(T__20);
                    setState(151);
                    type();
                    setState(154);
                    _la = _input.LA(1);
                    if (_la == T__12) {
                        {
                            setState(152);
                            match(T__12);
                            setState(153);
                            init();
                        }
                    }

                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(156);
                    match(ID);
                    setState(157);
                    match(T__12);
                    setState(158);
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
        enterRule(_localctx, 24, RULE_type);
        try {
            setState(179);
            switch (_input.LA(1)) {
                case T__24:
                case T__25:
                case T__26:
                case T__27:
                case ID:
                    _localctx = new BaseTypeContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(161);
                    basicType();
                }
                break;
                case T__21:
                    _localctx = new SetTypeContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(162);
                    match(T__21);
                    setState(163);
                    match(T__13);
                    setState(164);
                    type();
                    setState(165);
                    match(T__14);
                }
                break;
                case T__22:
                    _localctx = new SeqTypeContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(167);
                    match(T__22);
                    setState(168);
                    match(T__13);
                    setState(169);
                    type();
                    setState(170);
                    match(T__14);
                }
                break;
                case T__23:
                    _localctx = new MapTypeContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(172);
                    match(T__23);
                    setState(173);
                    match(T__13);
                    setState(174);
                    basicType();
                    setState(175);
                    match(T__10);
                    setState(176);
                    type();
                    setState(177);
                    match(T__14);
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

    public static class EnumTypeContext extends BasicTypeContext {
        public TerminalNode ID() {
            return getToken(Antlr4AwasParser.ID, 0);
        }

        public EnumTypeContext(BasicTypeContext ctx) {
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
        enterRule(_localctx, 26, RULE_basicType);
        try {
            setState(186);
            switch (_input.LA(1)) {
                case T__24:
                    _localctx = new BooleanTypeContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(181);
                    match(T__24);
                }
                break;
                case T__25:
                    _localctx = new IntegerTypeContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(182);
                    match(T__25);
                }
                break;
                case T__26:
                    _localctx = new RealTypeContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(183);
                    match(T__26);
                }
                break;
                case T__27:
                    _localctx = new StringTypeContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(184);
                    match(T__27);
                }
                break;
                case ID:
                    _localctx = new EnumTypeContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(185);
                    match(ID);
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
        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<InitContext> init() {
            return getRuleContexts(InitContext.class);
        }

        public InitContext init(int i) {
            return getRuleContext(InitContext.class, i);
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
        public BasicTypeContext basicType() {
            return getRuleContext(BasicTypeContext.class, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<MapEntryContext> mapEntry() {
            return getRuleContexts(MapEntryContext.class);
        }

        public MapEntryContext mapEntry(int i) {
            return getRuleContext(MapEntryContext.class, i);
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
        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<InitContext> init() {
            return getRuleContexts(InitContext.class);
        }

        public InitContext init(int i) {
            return getRuleContext(InitContext.class, i);
        }

        public SeqContext(InitContext ctx) {
            copyFrom(ctx);
        }
    }

    public final InitContext init() throws RecognitionException {
        InitContext _localctx = new InitContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_init);
        int _la;
        try {
            setState(253);
            switch (_input.LA(1)) {
                case T__28:
                    _localctx = new TrueContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(188);
                    match(T__28);
                }
                break;
                case T__29:
                    _localctx = new FalseContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(189);
                    match(T__29);
                }
                break;
                case INTEGER:
                    _localctx = new IntegerContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(190);
                    match(INTEGER);
                }
                break;
                case REAL:
                    _localctx = new RealContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(191);
                    match(REAL);
                }
                break;
                case STRING:
                    _localctx = new StringContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(192);
                    match(STRING);
                }
                break;
                case ID:
                    _localctx = new EnumElementContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(193);
                    match(ID);
                }
                break;
                case T__21:
                    _localctx = new SetContext(_localctx);
                    enterOuterAlt(_localctx, 7);
                {
                    setState(194);
                    match(T__21);
                    setState(199);
                    _la = _input.LA(1);
                    if (_la == T__13) {
                        {
                            setState(195);
                            match(T__13);
                            setState(196);
                            type();
                            setState(197);
                            match(T__14);
                        }
                    }

                    setState(201);
                    match(T__30);
                    setState(210);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__28) | (1L << T__29) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
                        {
                            setState(202);
                            init();
                            setState(207);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T__10) {
                                {
                                    {
                                        setState(203);
                                        match(T__10);
                                        setState(204);
                                        init();
                                    }
                                }
                                setState(209);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(212);
                    match(T__31);
                }
                break;
                case T__22:
                    _localctx = new SeqContext(_localctx);
                    enterOuterAlt(_localctx, 8);
                {
                    setState(213);
                    match(T__22);
                    setState(218);
                    _la = _input.LA(1);
                    if (_la == T__13) {
                        {
                            setState(214);
                            match(T__13);
                            setState(215);
                            type();
                            setState(216);
                            match(T__14);
                        }
                    }

                    setState(220);
                    match(T__30);
                    setState(229);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__28) | (1L << T__29) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
                        {
                            setState(221);
                            init();
                            setState(226);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T__10) {
                                {
                                    {
                                        setState(222);
                                        match(T__10);
                                        setState(223);
                                        init();
                                    }
                                }
                                setState(228);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(231);
                    match(T__31);
                }
                break;
                case T__23:
                    _localctx = new MapContext(_localctx);
                    enterOuterAlt(_localctx, 9);
                {
                    setState(232);
                    match(T__23);
                    setState(239);
                    _la = _input.LA(1);
                    if (_la == T__13) {
                        {
                            setState(233);
                            match(T__13);
                            setState(234);
                            basicType();
                            setState(235);
                            match(T__10);
                            setState(236);
                            type();
                            setState(237);
                            match(T__14);
                        }
                    }

                    setState(241);
                    match(T__30);
                    setState(250);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__28) | (1L << T__29) | (1L << INTEGER) | (1L << REAL) | (1L << STRING) | (1L << ID))) != 0)) {
                        {
                            setState(242);
                            mapEntry();
                            setState(247);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T__10) {
                                {
                                    {
                                        setState(243);
                                        match(T__10);
                                        setState(244);
                                        mapEntry();
                                    }
                                }
                                setState(249);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(252);
                    match(T__31);
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
        enterRule(_localctx, 30, RULE_mapEntry);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(255);
                ((MapEntryContext) _localctx).key = init();
                setState(256);
                match(T__7);
                setState(257);
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
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u0106\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3" +
                    "\2\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\4\3\4\3\4\3\4\5\4\60\n\4\3\5\3\5\3\5" +
                    "\3\6\3\6\3\6\3\6\7\69\n\6\f\6\16\6<\13\6\3\6\3\6\7\6@\n\6\f\6\16\6C\13" +
                    "\6\5\6E\n\6\5\6G\n\6\3\6\3\6\7\6K\n\6\f\6\16\6N\13\6\5\6P\n\6\3\6\5\6" +
                    "S\n\6\3\7\3\7\3\7\3\7\5\7Y\n\7\3\7\3\7\3\7\3\7\5\7_\n\7\3\7\3\7\7\7c\n" +
                    "\7\f\7\16\7f\13\7\5\7h\n\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bp\n\b\f\b\16\bs" +
                    "\13\b\5\bu\n\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t}\n\t\f\t\16\t\u0080\13\t\3" +
                    "\t\3\t\3\t\7\t\u0085\n\t\f\t\16\t\u0088\13\t\5\t\u008a\n\t\3\n\3\n\3\n" +
                    "\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u009d" +
                    "\n\r\3\r\3\r\3\r\5\r\u00a2\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16" +
                    "\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b6\n\16\3\17" +
                    "\3\17\3\17\3\17\3\17\5\17\u00bd\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20" +
                    "\3\20\3\20\3\20\3\20\5\20\u00ca\n\20\3\20\3\20\3\20\3\20\7\20\u00d0\n" +
                    "\20\f\20\16\20\u00d3\13\20\5\20\u00d5\n\20\3\20\3\20\3\20\3\20\3\20\3" +
                    "\20\5\20\u00dd\n\20\3\20\3\20\3\20\3\20\7\20\u00e3\n\20\f\20\16\20\u00e6" +
                    "\13\20\5\20\u00e8\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00f2" +
                    "\n\20\3\20\3\20\3\20\3\20\7\20\u00f8\n\20\f\20\16\20\u00fb\13\20\5\20" +
                    "\u00fd\n\20\3\20\5\20\u0100\n\20\3\21\3\21\3\21\3\21\3\21\2\2\22\2\4\6" +
                    "\b\n\f\16\20\22\24\26\30\32\34\36 \2\3\3\2\25\26\u0123\2\"\3\2\2\2\4(" +
                    "\3\2\2\2\6/\3\2\2\2\b\61\3\2\2\2\n\64\3\2\2\2\fT\3\2\2\2\16i\3\2\2\2\20" +
                    "v\3\2\2\2\22\u008b\3\2\2\2\24\u0090\3\2\2\2\26\u0094\3\2\2\2\30\u00a1" +
                    "\3\2\2\2\32\u00b5\3\2\2\2\34\u00bc\3\2\2\2\36\u00ff\3\2\2\2 \u0101\3\2" +
                    "\2\2\"#\5\4\3\2#$\7\2\2\3$\3\3\2\2\2%\'\5\6\4\2&%\3\2\2\2\'*\3\2\2\2(" +
                    "&\3\2\2\2()\3\2\2\2)\5\3\2\2\2*(\3\2\2\2+\60\5\n\6\2,\60\5\f\7\2-\60\5" +
                    "\16\b\2.\60\5\b\5\2/+\3\2\2\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60\7\3\2\2" +
                    "\2\61\62\7\3\2\2\62\63\7&\2\2\63\t\3\2\2\2\64\65\7\4\2\2\65F\7&\2\2\66" +
                    ":\7\5\2\2\679\5\26\f\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;D\3\2" +
                    "\2\2<:\3\2\2\2=A\7\6\2\2>@\5\24\13\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3" +
                    "\2\2\2BE\3\2\2\2CA\3\2\2\2D=\3\2\2\2DE\3\2\2\2EG\3\2\2\2F\66\3\2\2\2F" +
                    "G\3\2\2\2GO\3\2\2\2HL\7\7\2\2IK\5\30\r\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2" +
                    "LM\3\2\2\2MP\3\2\2\2NL\3\2\2\2OH\3\2\2\2OP\3\2\2\2PR\3\2\2\2QS\5\20\t" +
                    "\2RQ\3\2\2\2RS\3\2\2\2S\13\3\2\2\2TU\7\b\2\2UX\7&\2\2VW\7\t\2\2WY\7&\2" +
                    "\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\7\n\2\2[^\7&\2\2\\]\7\t\2\2]_\7&\2" +
                    "\2^\\\3\2\2\2^_\3\2\2\2_g\3\2\2\2`d\7\7\2\2ac\5\30\r\2ba\3\2\2\2cf\3\2" +
                    "\2\2db\3\2\2\2de\3\2\2\2eh\3\2\2\2fd\3\2\2\2g`\3\2\2\2gh\3\2\2\2h\r\3" +
                    "\2\2\2ij\7\13\2\2jt\7&\2\2kl\7\f\2\2lq\7&\2\2mn\7\r\2\2np\7&\2\2om\3\2" +
                    "\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2ru\3\2\2\2sq\3\2\2\2tk\3\2\2\2tu\3\2" +
                    "\2\2u\17\3\2\2\2vw\7\16\2\2wx\7\17\2\2xy\7\20\2\2y~\7&\2\2z{\7\r\2\2{" +
                    "}\7&\2\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0081\3\2" +
                    "\2\2\u0080~\3\2\2\2\u0081\u0089\7\21\2\2\u0082\u0086\7\22\2\2\u0083\u0085" +
                    "\5\22\n\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2" +
                    "\u0086\u0087\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u0082" +
                    "\3\2\2\2\u0089\u008a\3\2\2\2\u008a\21\3\2\2\2\u008b\u008c\7&\2\2\u008c" +
                    "\u008d\7\23\2\2\u008d\u008e\7\24\2\2\u008e\u008f\7&\2\2\u008f\23\3\2\2" +
                    "\2\u0090\u0091\7&\2\2\u0091\u0092\7\n\2\2\u0092\u0093\7&\2\2\u0093\25" +
                    "\3\2\2\2\u0094\u0095\t\2\2\2\u0095\u0096\7&\2\2\u0096\27\3\2\2\2\u0097" +
                    "\u0098\7&\2\2\u0098\u0099\7\27\2\2\u0099\u009c\5\32\16\2\u009a\u009b\7" +
                    "\17\2\2\u009b\u009d\5\36\20\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2" +
                    "\u009d\u00a2\3\2\2\2\u009e\u009f\7&\2\2\u009f\u00a0\7\17\2\2\u00a0\u00a2" +
                    "\5\36\20\2\u00a1\u0097\3\2\2\2\u00a1\u009e\3\2\2\2\u00a2\31\3\2\2\2\u00a3" +
                    "\u00b6\5\34\17\2\u00a4\u00a5\7\30\2\2\u00a5\u00a6\7\20\2\2\u00a6\u00a7" +
                    "\5\32\16\2\u00a7\u00a8\7\21\2\2\u00a8\u00b6\3\2\2\2\u00a9\u00aa\7\31\2" +
                    "\2\u00aa\u00ab\7\20\2\2\u00ab\u00ac\5\32\16\2\u00ac\u00ad\7\21\2\2\u00ad" +
                    "\u00b6\3\2\2\2\u00ae\u00af\7\32\2\2\u00af\u00b0\7\20\2\2\u00b0\u00b1\5" +
                    "\34\17\2\u00b1\u00b2\7\r\2\2\u00b2\u00b3\5\32\16\2\u00b3\u00b4\7\21\2" +
                    "\2\u00b4\u00b6\3\2\2\2\u00b5\u00a3\3\2\2\2\u00b5\u00a4\3\2\2\2\u00b5\u00a9" +
                    "\3\2\2\2\u00b5\u00ae\3\2\2\2\u00b6\33\3\2\2\2\u00b7\u00bd\7\33\2\2\u00b8" +
                    "\u00bd\7\34\2\2\u00b9\u00bd\7\35\2\2\u00ba\u00bd\7\36\2\2\u00bb\u00bd" +
                    "\7&\2\2\u00bc\u00b7\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bc\u00b9\3\2\2\2\u00bc" +
                    "\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\35\3\2\2\2\u00be\u0100\7\37\2" +
                    "\2\u00bf\u0100\7 \2\2\u00c0\u0100\7#\2\2\u00c1\u0100\7$\2\2\u00c2\u0100" +
                    "\7%\2\2\u00c3\u0100\7&\2\2\u00c4\u00c9\7\30\2\2\u00c5\u00c6\7\20\2\2\u00c6" +
                    "\u00c7\5\32\16\2\u00c7\u00c8\7\21\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c5" +
                    "\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00d4\7!\2\2\u00cc" +
                    "\u00d1\5\36\20\2\u00cd\u00ce\7\r\2\2\u00ce\u00d0\5\36\20\2\u00cf\u00cd" +
                    "\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2" +
                    "\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00cc\3\2\2\2\u00d4\u00d5\3\2" +
                    "\2\2\u00d5\u00d6\3\2\2\2\u00d6\u0100\7\"\2\2\u00d7\u00dc\7\31\2\2\u00d8" +
                    "\u00d9\7\20\2\2\u00d9\u00da\5\32\16\2\u00da\u00db\7\21\2\2\u00db\u00dd" +
                    "\3\2\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de" +
                    "\u00e7\7!\2\2\u00df\u00e4\5\36\20\2\u00e0\u00e1\7\r\2\2\u00e1\u00e3\5" +
                    "\36\20\2\u00e2\u00e0\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4" +
                    "\u00e5\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00df\3\2" +
                    "\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u0100\7\"\2\2\u00ea" +
                    "\u00f1\7\32\2\2\u00eb\u00ec\7\20\2\2\u00ec\u00ed\5\34\17\2\u00ed\u00ee" +
                    "\7\r\2\2\u00ee\u00ef\5\32\16\2\u00ef\u00f0\7\21\2\2\u00f0\u00f2\3\2\2" +
                    "\2\u00f1\u00eb\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00fc" +
                    "\7!\2\2\u00f4\u00f9\5 \21\2\u00f5\u00f6\7\r\2\2\u00f6\u00f8\5 \21\2\u00f7" +
                    "\u00f5\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2" +
                    "\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00f4\3\2\2\2\u00fc" +
                    "\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\7\"\2\2\u00ff\u00be\3\2" +
                    "\2\2\u00ff\u00bf\3\2\2\2\u00ff\u00c0\3\2\2\2\u00ff\u00c1\3\2\2\2\u00ff" +
                    "\u00c2\3\2\2\2\u00ff\u00c3\3\2\2\2\u00ff\u00c4\3\2\2\2\u00ff\u00d7\3\2" +
                    "\2\2\u00ff\u00ea\3\2\2\2\u0100\37\3\2\2\2\u0101\u0102\5\36\20\2\u0102" +
                    "\u0103\7\n\2\2\u0103\u0104\5\36\20\2\u0104!\3\2\2\2\"(/:ADFLORX^dgqt~" +
                    "\u0086\u0089\u009c\u00a1\u00b5\u00bc\u00c9\u00d1\u00d4\u00dc\u00e4\u00e7" +
                    "\u00f1\u00f9\u00fc\u00ff";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}