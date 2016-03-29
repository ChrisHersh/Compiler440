package parser.states;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import parser.Parser;
import parser.states.JMCC_27;
import parser.states.JMCC_5;
import parser.states.State;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class TestState {

	@Test
	public void test() 
	{
		Parser parser = Parser.getInstance();
		State state = new JMCC_27();
		parser.pushStateStack(state);
		parser.pushStateStack(new JMCC_5());
		parser.pushStateStack(new JMCC_5());
		
		Token tok = new Token("a","a", 1);
		parser.pushHoldStack(tok);
		parser.pushHoldStack(tok);
		parser.pushHoldStack(tok);
		parser.pushHoldStack(tok);
		
		ArrayList<Token> children = new ArrayList<Token>();
		children.add(tok);
		children.add(tok);
		children.add(tok);
		
		state.reduceToState(state, TokenTypes.EXP1);
		
		assertEquals(new Token(TokenTypes.EXP1, children).getClass(), parser.peekInputStack().getClass());
		assertEquals(new Token(TokenTypes.EXP1, children).getLineNumber(), parser.peekInputStack().getLineNumber());
		assertEquals(new Token(TokenTypes.EXP1, children).getToken(), parser.peekInputStack().getToken());
		assertEquals(new Token(TokenTypes.EXP1, children).getTokenName(), parser.peekInputStack().getTokenName());
		assertEquals(new Token(TokenTypes.EXP1, children).getChildren(), parser.peekInputStack().getChildren());
		
	}

}
