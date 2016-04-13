package parser.states.CILS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_14;
import parser.states.CILS.CILS_15;
import parser.states.CILS.CILS_9;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test all of the state shifts for CILS_9
 * @author Raistlin Hess
 *
 */
public class TestCILS_9 
{
	/**
	 * Initialize the Parser
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }

	/**
	 * Make sure handles = input correctly.
	 * It should shift to CILS_14
	 */
	@Test
	public void testShiftEquals() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_9();
    	Token token = new Token("=",TokenTypes.Equals.name(),1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEquals();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CILS_14);
	}
	
	/**
	 * Make sure handles [ input correctly.
	 * It should shift to CILS_15
	 */
	@Test
	public void testShiftLeftBrace() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_9();
    	Token token = new Token("[",TokenTypes.LBrace.name(),1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftLeftBrace();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CILS_15);
	}
}
