package parser.states.CRM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_1;
import tokenizer.Token;
/**
 * Test class to check the methods of the CRM_0 class.
 * @author Jason LoBianco
 */
public class TestCRM_0
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
     * checks that shiftLeftBrace() works correctly
     * @author Ledny Joseph, Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftLeftBrace() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_0();
	        
	    Token token = new Token("{", "L_Brace", 24);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftLeftBrace();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_1);
	}
}
