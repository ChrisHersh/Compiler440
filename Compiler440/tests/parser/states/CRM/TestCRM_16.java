package parser.states.CRM;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_16;
import parser.states.CRM.CRM_18;
import tokenizer.Token;
/**
 * Test class to check the methods of the CRM_16 class.
 * @author Jason LoBianco
 */
public class TestCRM_16 
{
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
	/**
	 * checks that shiftMETH_DECL_L works correctly
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	@Test
	public void testShiftMETH_DECL_L() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_16();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftMETH_DECL_L();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_18);
	}

	/**
     * Tests to see that InvalidState method works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
    public void testInvalidState() throws ParserException
    {
    	Parser p = Parser.getInstance();
	    State s = new CRM_16();
	        
	    Token token = new Token(";", "Semi", 5);
	    
	    p.getInputStack().push(token);
	    p.changeState(s);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.invalidState();
	    
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    assertTrue(p.getCurrentState() instanceof CRM_16);
    }
}
