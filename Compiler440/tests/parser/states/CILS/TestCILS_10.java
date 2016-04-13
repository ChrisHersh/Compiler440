package parser.states.CILS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_10;
import parser.states.CILS.CILS_11;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test the state shift for CILS_10
 * @author Mohammed
 *
 */
public class TestCILS_10
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
		 * Make sure handles LeftBrace input correctly.
		 * It should shift to CILS_11
		 */

		@Test
		public void testLeftBrace() throws ParserException
		{
			Parser parser = Parser.getInstance();
	    	State state = new CILS_10();
	    	Token token = new Token("{",TokenTypes.LBrace.name(),1);
	    	
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
	        assertTrue(parser.getCurrentState() instanceof CILS_11);
		}

}
