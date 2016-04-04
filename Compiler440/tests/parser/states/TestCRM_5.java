package parser.states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import parser.Parser;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class TestCRM_5
{
	/**
     * @author TJ Renninger
     * @throws ParserException
     */
    @Test
	public void testReduce() throws ParserException
	{
    	//Test needs fixed
//	    Parser p = Parser.getInstance();
//	    State s = new CRM_5();
//	    
//	    ArrayList<Token> tokens = new ArrayList<Token>();
//	    tokens.add(new Token("}", "RightBrace", 6));
//	    tokens.add(new Token("STMT_P", "STMT_P", 5));
//	    p.pushHoldStack(tokens.get(1));
//	    p.pushHoldStack(tokens.get(0));    
//	    p.pushStateStack(new CRM_2());
//	    p.pushStateStack(new CRM_3());
//	    
//	    s.shiftRightBrace();
//	    
//	    assertFalse(p.getInputStack().empty());
//	    assertTrue(p.getHoldStack().empty());
//	    assertTrue(p.getStateStack().empty());
//	    Token testee = new Token(TokenTypes.RBrace, tokens);
//	    assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
//	    assertEquals(p.peekInputStack().getToken(), testee.getToken());
//	    assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
//	    assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
//	    assertEquals(p.getCurrentState().getClass(), new CRM_1().getClass());
	}
}
