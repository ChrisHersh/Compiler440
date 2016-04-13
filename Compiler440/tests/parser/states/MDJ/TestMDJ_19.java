package parser.states.MDJ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.MDJ.MDJ_19;
import parser.states.MDJ.MDJ_21;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Test all of the state shifts for MDJ_19
 * @author Raistlin Hess
 *
 */
public class TestMDJ_19 
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
	 * Make sure handles extends input correctly.
	 * It should shift to MDJ_21
	 */
	@Test
	public void testRightBrace() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new MDJ_19();
    	Token token = new Token("^(fun)", TokenTypes.Id.name(),1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftId();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof MDJ_21);
	}
}
