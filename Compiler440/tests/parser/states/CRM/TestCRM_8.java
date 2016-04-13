package parser.states.CRM;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_2;
import parser.states.CRM.CRM_6;
import parser.states.CRM.CRM_7;
import parser.states.CRM.CRM_8;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test class to check the methods of the CRM_8 class.
 * @author Jason LoBianco
 */
public class TestCRM_8 
{
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }

	/**
	 * Checks to see that the reduce works correctly
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	@Test
	public void testReduce() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_8();
	    
	    ArrayList<Token> tokens = new ArrayList<Token>();
	    tokens.add(new Token(";","SemiColon",6));
	    tokens.add(new Token("id","ID",5));
	    tokens.add(new Token("type","TYPE",4));
	    p.pushHoldStack(tokens.get(2));
	    p.pushHoldStack(tokens.get(1));
	    p.pushHoldStack(tokens.get(0));    
	    p.pushStateStack(new CRM_2());
	    p.pushStateStack(new CRM_6());
	    p.pushStateStack(new CRM_7());
	    
	    s.shiftVAR_DECL();
	    
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    Token testee = new Token(TokenTypes.VAR_DECL, tokens);
	    assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
	    assertEquals(p.peekInputStack().getToken(), testee.getToken());
	    assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
	    assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
	    assertEquals(p.getCurrentState().getClass(), new CRM_2().getClass());
	}

}
