package parser.states;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;

/**
 * Test class to check the methods of the CRM_6 class.
 * @author Jason LoBianco
 */
public class TestCRM_6 
{
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }

	/**
	 * Test to check that ShiftId works correctly.
	 * @author Jason LoBianco
	 * @throws ParserException 
	 */
	@Test
	public void testShiftId() throws ParserException 
	{
		Parser p = Parser.getInstance();
		State s = new CRM_6();
		        
		Token token = new Token("id", "ID", 25);
		    
		p.getInputStack().push(token);
		    
		assertFalse(p.getInputStack().empty());
		assertEquals(p.getInputStack().peek(), token);
		assertTrue(p.getHoldStack().empty());
		assertTrue(p.getStateStack().empty());
		    
		s.shiftId();
		    
		assertTrue(p.getInputStack().empty());
		assertFalse(p.getHoldStack().empty());
		assertFalse(p.getStateStack().empty());
		    
		assertEquals(p.getHoldStack().peek(), token);
		assertEquals(p.getStateStack().peek(), s);
		    
		assertTrue(p.getCurrentState() instanceof CRM_7);
	}

}
