package parser.states.CRM;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_7;
import parser.states.CRM.CRM_8;
import tokenizer.Token;
/**
 * Test class to check the methods of the CRM_7 class.
 * @author Jason LoBianco
 */
public class TestCRM_7 
{
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }

	/**
	 * Test to check that ShiftSemiColon works correctly.
	 * @author Jason LoBianco
	 * @throws ParserException 
	 */
	@Test
	public void testSemiColon() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_7();
	        
	    Token token = new Token(";", "SemiColon", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftSemiColon();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_8);
	}

}
