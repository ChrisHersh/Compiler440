package parser.states.CRM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_40;
import parser.states.CRM.CRM_41;
import tokenizer.Token;
/**
 * @author Chris Kjeldgaard
 */
public class TestCRM_40 {

	@Before
    public void setUp()
    {
        Parser.resetParser();
    }
	/**
	 * checks that testShiftType works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftId() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_40();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	    
	    assertTrue(p.getCurrentState() instanceof CRM_41);
	}

}
