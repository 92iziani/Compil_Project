// Generated from expr.g4 by ANTLR 4.9.2

package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class exprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		OPERATEUR=18, CHIFFRE=19, ENTIER=20, IDENT=21, CARACTERE=22, WS=23;
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_decl_vars = 2, RULE_decl_typ = 3, 
		RULE_decl_fct = 4, RULE_param = 5, RULE_expr = 6, RULE_instruction = 7, 
		RULE_bloc = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decl", "decl_vars", "decl_typ", "decl_fct", "param", "expr", 
			"instruction", "bloc"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "','", "';'", "'struct'", "'('", "'*'", "')'", "'{'", 
			"'}'", "'->'", "'!'", "'-'", "'sizeof'", "'if'", "'else'", "'while'", 
			"'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "OPERATEUR", "CHIFFRE", "ENTIER", 
			"IDENT", "CARACTERE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public exprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(exprParser.EOF, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__3) {
				{
				{
				setState(18);
				decl();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
			match(EOF);
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

	public static class DeclContext extends ParserRuleContext {
		public Decl_typContext decl_typ() {
			return getRuleContext(Decl_typContext.class,0);
		}
		public Decl_fctContext decl_fct() {
			return getRuleContext(Decl_fctContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(28);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				decl_typ();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				decl_fct();
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

	public static class Decl_varsContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(exprParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(exprParser.IDENT, i);
		}
		public Decl_varsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_vars; }
	}

	public final Decl_varsContext decl_vars() throws RecognitionException {
		Decl_varsContext _localctx = new Decl_varsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl_vars);
		int _la;
		try {
			int _alt;
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				match(T__0);
				setState(33); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(31);
						match(IDENT);
						setState(32);
						match(T__1);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(35); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(37);
				match(IDENT);
				setState(38);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				match(T__3);
				setState(40);
				match(IDENT);
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(41);
					match(T__4);
					setState(42);
					match(T__5);
					setState(43);
					match(IDENT);
					setState(44);
					match(T__6);
					setState(45);
					match(T__1);
					}
					}
					setState(48); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__4 );
				setState(50);
				match(T__2);
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

	public static class Decl_typContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(exprParser.IDENT, 0); }
		public List<Decl_varsContext> decl_vars() {
			return getRuleContexts(Decl_varsContext.class);
		}
		public Decl_varsContext decl_vars(int i) {
			return getRuleContext(Decl_varsContext.class,i);
		}
		public Decl_typContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_typ; }
	}

	public final Decl_typContext decl_typ() throws RecognitionException {
		Decl_typContext _localctx = new Decl_typContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl_typ);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__3);
			setState(54);
			match(IDENT);
			setState(55);
			match(T__7);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__3) {
				{
				{
				setState(56);
				decl_vars();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(T__8);
			setState(63);
			match(T__2);
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

	public static class Decl_fctContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(exprParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(exprParser.IDENT, i);
		}
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public Decl_fctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_fct; }
	}

	public final Decl_fctContext decl_fct() throws RecognitionException {
		Decl_fctContext _localctx = new Decl_fctContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decl_fct);
		int _la;
		try {
			int _alt;
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(T__0);
				setState(66);
				match(IDENT);
				setState(67);
				match(T__4);
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(68);
						param();
						setState(69);
						match(T__1);
						}
						} 
					}
					setState(75);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0 || _la==T__3) {
					{
					setState(76);
					param();
					}
				}

				setState(79);
				match(T__6);
				setState(80);
				bloc();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(T__3);
				setState(82);
				match(IDENT);
				setState(83);
				match(T__5);
				setState(84);
				match(IDENT);
				setState(85);
				match(T__4);
				setState(86);
				param();
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(87);
					match(T__1);
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(93);
				match(T__6);
				setState(94);
				bloc();
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

	public static class ParamContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(exprParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(exprParser.IDENT, i);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(T__0);
				setState(99);
				match(IDENT);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				match(T__3);
				setState(101);
				match(IDENT);
				setState(102);
				match(T__5);
				setState(103);
				match(IDENT);
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode ENTIER() { return getToken(exprParser.ENTIER, 0); }
		public TerminalNode IDENT() { return getToken(exprParser.IDENT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPERATEUR() { return getToken(exprParser.OPERATEUR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(107);
				match(ENTIER);
				}
				break;
			case 2:
				{
				setState(108);
				match(IDENT);
				}
				break;
			case 3:
				{
				setState(109);
				match(IDENT);
				setState(110);
				match(T__4);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << ENTIER) | (1L << IDENT))) != 0)) {
					{
					{
					setState(111);
					expr(0);
					setState(112);
					match(T__1);
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(119);
				match(T__6);
				}
				break;
			case 4:
				{
				setState(120);
				match(T__10);
				setState(121);
				expr(5);
				}
				break;
			case 5:
				{
				setState(122);
				match(T__11);
				setState(123);
				expr(4);
				}
				break;
			case 6:
				{
				setState(124);
				match(T__12);
				setState(125);
				match(T__4);
				setState(126);
				match(T__3);
				setState(127);
				match(IDENT);
				setState(128);
				match(T__6);
				}
				break;
			case 7:
				{
				setState(129);
				match(T__4);
				setState(130);
				expr(0);
				setState(131);
				match(T__6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(143);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(141);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(135);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(136);
						match(OPERATEUR);
						setState(137);
						expr(4);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(138);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(139);
						match(T__9);
						setState(140);
						match(IDENT);
						}
						break;
					}
					} 
				}
				setState(145);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_instruction);
		try {
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				expr(0);
				setState(148);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				match(T__13);
				setState(151);
				match(T__4);
				setState(152);
				expr(0);
				setState(153);
				match(T__6);
				setState(154);
				instruction();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(156);
				match(T__13);
				setState(157);
				match(T__4);
				setState(158);
				expr(0);
				setState(159);
				match(T__6);
				setState(160);
				instruction();
				setState(161);
				match(T__14);
				setState(162);
				instruction();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(164);
				match(T__15);
				setState(165);
				match(T__4);
				setState(166);
				expr(0);
				setState(167);
				match(T__6);
				setState(168);
				instruction();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(170);
				bloc();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(171);
				match(T__16);
				setState(172);
				expr(0);
				setState(173);
				match(T__2);
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

	public static class BlocContext extends ParserRuleContext {
		public List<Decl_varsContext> decl_vars() {
			return getRuleContexts(Decl_varsContext.class);
		}
		public Decl_varsContext decl_vars(int i) {
			return getRuleContext(Decl_varsContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BlocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc; }
	}

	public final BlocContext bloc() throws RecognitionException {
		BlocContext _localctx = new BlocContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bloc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(T__7);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__3) {
				{
				{
				setState(178);
				decl_vars();
				}
				}
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__7) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << ENTIER) | (1L << IDENT))) != 0)) {
				{
				{
				setState(184);
				instruction();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(190);
			match(T__8);
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
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31\u00c3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7"+
		"\2\26\n\2\f\2\16\2\31\13\2\3\2\3\2\3\3\3\3\5\3\37\n\3\3\4\3\4\3\4\6\4"+
		"$\n\4\r\4\16\4%\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4\61\n\4\r\4\16"+
		"\4\62\3\4\5\4\66\n\4\3\5\3\5\3\5\3\5\7\5<\n\5\f\5\16\5?\13\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6J\n\6\f\6\16\6M\13\6\3\6\5\6P\n\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6[\n\6\f\6\16\6^\13\6\3\6\3\6\3\6\5\6"+
		"c\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7k\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\7\bu\n\b\f\b\16\bx\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\b\u0088\n\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0090\n\b\f\b\16"+
		"\b\u0093\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00b2"+
		"\n\t\3\n\3\n\7\n\u00b6\n\n\f\n\16\n\u00b9\13\n\3\n\7\n\u00bc\n\n\f\n\16"+
		"\n\u00bf\13\n\3\n\3\n\3\n\2\3\16\13\2\4\6\b\n\f\16\20\22\2\2\2\u00d5\2"+
		"\27\3\2\2\2\4\36\3\2\2\2\6\65\3\2\2\2\b\67\3\2\2\2\nb\3\2\2\2\fj\3\2\2"+
		"\2\16\u0087\3\2\2\2\20\u00b1\3\2\2\2\22\u00b3\3\2\2\2\24\26\5\4\3\2\25"+
		"\24\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31"+
		"\27\3\2\2\2\32\33\7\2\2\3\33\3\3\2\2\2\34\37\5\b\5\2\35\37\5\n\6\2\36"+
		"\34\3\2\2\2\36\35\3\2\2\2\37\5\3\2\2\2 #\7\3\2\2!\"\7\27\2\2\"$\7\4\2"+
		"\2#!\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'(\7\27\2\2(\66"+
		"\7\5\2\2)*\7\6\2\2*\60\7\27\2\2+,\7\7\2\2,-\7\b\2\2-.\7\27\2\2./\7\t\2"+
		"\2/\61\7\4\2\2\60+\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63"+
		"\64\3\2\2\2\64\66\7\5\2\2\65 \3\2\2\2\65)\3\2\2\2\66\7\3\2\2\2\678\7\6"+
		"\2\289\7\27\2\29=\7\n\2\2:<\5\6\4\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3"+
		"\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7\13\2\2AB\7\5\2\2B\t\3\2\2\2CD\7\3\2\2D"+
		"E\7\27\2\2EK\7\7\2\2FG\5\f\7\2GH\7\4\2\2HJ\3\2\2\2IF\3\2\2\2JM\3\2\2\2"+
		"KI\3\2\2\2KL\3\2\2\2LO\3\2\2\2MK\3\2\2\2NP\5\f\7\2ON\3\2\2\2OP\3\2\2\2"+
		"PQ\3\2\2\2QR\7\t\2\2Rc\5\22\n\2ST\7\6\2\2TU\7\27\2\2UV\7\b\2\2VW\7\27"+
		"\2\2WX\7\7\2\2X\\\5\f\7\2Y[\7\4\2\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]"+
		"\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\7\t\2\2`a\5\22\n\2ac\3\2\2\2bC\3\2\2\2"+
		"bS\3\2\2\2c\13\3\2\2\2de\7\3\2\2ek\7\27\2\2fg\7\6\2\2gh\7\27\2\2hi\7\b"+
		"\2\2ik\7\27\2\2jd\3\2\2\2jf\3\2\2\2k\r\3\2\2\2lm\b\b\1\2m\u0088\7\26\2"+
		"\2n\u0088\7\27\2\2op\7\27\2\2pv\7\7\2\2qr\5\16\b\2rs\7\4\2\2su\3\2\2\2"+
		"tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2y\u0088\7"+
		"\t\2\2z{\7\r\2\2{\u0088\5\16\b\7|}\7\16\2\2}\u0088\5\16\b\6~\177\7\17"+
		"\2\2\177\u0080\7\7\2\2\u0080\u0081\7\6\2\2\u0081\u0082\7\27\2\2\u0082"+
		"\u0088\7\t\2\2\u0083\u0084\7\7\2\2\u0084\u0085\5\16\b\2\u0085\u0086\7"+
		"\t\2\2\u0086\u0088\3\2\2\2\u0087l\3\2\2\2\u0087n\3\2\2\2\u0087o\3\2\2"+
		"\2\u0087z\3\2\2\2\u0087|\3\2\2\2\u0087~\3\2\2\2\u0087\u0083\3\2\2\2\u0088"+
		"\u0091\3\2\2\2\u0089\u008a\f\5\2\2\u008a\u008b\7\24\2\2\u008b\u0090\5"+
		"\16\b\6\u008c\u008d\f\t\2\2\u008d\u008e\7\f\2\2\u008e\u0090\7\27\2\2\u008f"+
		"\u0089\3\2\2\2\u008f\u008c\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\17\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u00b2"+
		"\7\5\2\2\u0095\u0096\5\16\b\2\u0096\u0097\7\5\2\2\u0097\u00b2\3\2\2\2"+
		"\u0098\u0099\7\20\2\2\u0099\u009a\7\7\2\2\u009a\u009b\5\16\b\2\u009b\u009c"+
		"\7\t\2\2\u009c\u009d\5\20\t\2\u009d\u00b2\3\2\2\2\u009e\u009f\7\20\2\2"+
		"\u009f\u00a0\7\7\2\2\u00a0\u00a1\5\16\b\2\u00a1\u00a2\7\t\2\2\u00a2\u00a3"+
		"\5\20\t\2\u00a3\u00a4\7\21\2\2\u00a4\u00a5\5\20\t\2\u00a5\u00b2\3\2\2"+
		"\2\u00a6\u00a7\7\22\2\2\u00a7\u00a8\7\7\2\2\u00a8\u00a9\5\16\b\2\u00a9"+
		"\u00aa\7\t\2\2\u00aa\u00ab\5\20\t\2\u00ab\u00b2\3\2\2\2\u00ac\u00b2\5"+
		"\22\n\2\u00ad\u00ae\7\23\2\2\u00ae\u00af\5\16\b\2\u00af\u00b0\7\5\2\2"+
		"\u00b0\u00b2\3\2\2\2\u00b1\u0094\3\2\2\2\u00b1\u0095\3\2\2\2\u00b1\u0098"+
		"\3\2\2\2\u00b1\u009e\3\2\2\2\u00b1\u00a6\3\2\2\2\u00b1\u00ac\3\2\2\2\u00b1"+
		"\u00ad\3\2\2\2\u00b2\21\3\2\2\2\u00b3\u00b7\7\n\2\2\u00b4\u00b6\5\6\4"+
		"\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8"+
		"\3\2\2\2\u00b8\u00bd\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bc\5\20\t\2"+
		"\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1\7\13\2\2"+
		"\u00c1\23\3\2\2\2\24\27\36%\62\65=KO\\bjv\u0087\u008f\u0091\u00b1\u00b7"+
		"\u00bd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}