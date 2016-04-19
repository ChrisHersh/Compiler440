package parser.states.CRM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_1;
import parser.states.CRM.CRM_2;
import parser.states.CRM.CRM_3;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Test class to check the methods of the CRM_3 class.
 * @author Chris Kjeldgaard
 */
public class TestCRM_3 
{
	/**
	 * Clears the parser before each test
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
	/**
	 * Checks to see that the reduce works correctly
     * @author Chris Kjeldgaard
     * @throws ParserException
     */
    @Test
	public void testReduce() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_3();
	    
	    ArrayList<Token> tokens = new ArrayList<Token>();
	    tokens.add(new Token("VAR_DECL","VAR_DECL",6));
	    tokens.add(new Token("VAR_DECL_L","VAR_DECL_L",5));
	    p.pushHoldStack(tokens.get(1));
	    p.pushHoldStack(tokens.get(0));    
	    p.pushStateStack(new CRM_1());
	    p.pushStateStack(new CRM_2());
	    
	    s.shiftVAR_DECL();
	    
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    Token testee = new Token(TokenTypes.VAR_DECL_L, tokens);
	    assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
	    assertEquals(p.peekInputStack().getToken(), testee.getToken());
	    assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
	    assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
	    assertEquals(p.getCurrentState().getClass(), new CRM_1().getClass());
	}
}
