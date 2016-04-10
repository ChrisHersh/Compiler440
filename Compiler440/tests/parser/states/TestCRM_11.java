package parser.states;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Test class to check the methods of the CRM_11 class.
 * @author Jason LoBianco
 */
public class TestCRM_11 
{
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
	/**
	 * checks to see that the reduce works correctly
	 * @author Jason LoBianco
	 */
	@Test
	public void testReduce() throws ParserException
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_11();
	    
	    ArrayList<Token> tokens = new ArrayList<Token>();
	    tokens.add(new Token("]","RightBracket",6));
	    tokens.add(new Token("[","LeftBracket",5));
	    tokens.add(new Token("int","INT",4));
	    p.pushHoldStack(tokens.get(2));
	    p.pushHoldStack(tokens.get(1));
	    p.pushHoldStack(tokens.get(0));    
	    p.pushStateStack(new CRM_2());
	    p.pushStateStack(new CRM_9());
	    p.pushStateStack(new CRM_10());
	    
	    s.shiftVAR_DECL();
	    
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    Token testee = new Token(TokenTypes.TYPE, tokens);
	    assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
	    assertEquals(p.peekInputStack().getToken(), testee.getToken());
	    assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
	    assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
	    assertEquals(p.getCurrentState().getClass(), new CRM_2().getClass());
	}

}
