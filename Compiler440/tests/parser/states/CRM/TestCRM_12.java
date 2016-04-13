package parser.states.CRM;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_12;
import parser.states.CRM.CRM_2;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Test class to check the methods of the CRM_12 class.
 * @author Jason LoBianco
 */
public class TestCRM_12 
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
	    State s = new CRM_12();
	    
	    ArrayList<Token> tokens = new ArrayList<Token>();
	    tokens.add(new Token("id","ID",4));
	    p.pushHoldStack(tokens.get(0));    
	    p.pushStateStack(new CRM_2());
	    
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
