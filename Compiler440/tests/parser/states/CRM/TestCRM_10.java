package parser.states.CRM;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_10;
import parser.states.CRM.CRM_11;
import tokenizer.Token;
/**
 * Test class to check the methods of the CRM_10 class.
 * @author Jason LoBianco
 */
public class TestCRM_10 
{
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
	/**
	 * Test to check that ShiftRightBracket works correctly.
	 * @author Jason LoBianco
	 * @throws ParserException 
	 */
	@Test
	public void testShiftRightBracket() throws ParserException
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_10();
	        
	    Token token = new Token("]", "RightBracket", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftRightBracket();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_11);
	}

}
