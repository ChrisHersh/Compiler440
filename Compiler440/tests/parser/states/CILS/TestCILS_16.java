package parser.states.CILS;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_16;
import parser.states.CILS.CILS_23;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
	 * Tests the functionality of CILS_2
	 * making sure it changes state correctly
	 * @author Shannon Lee
	 *
	 */
public class TestCILS_16 {

	

	/**
	 * Initialize the parser
	 * @author Shannon Jones
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    } 
		@Test
		public void testRightPara() throws ParserException
		{
			Parser parser = Parser.getInstance();
	    	State state = new CILS_16();
	    	Token token = new Token(")",TokenTypes.RPara.name(),1);
	    	
	    	parser.getInputStack().push(token);
	    	
	    	assertEquals(parser.getInputStack().peek(), token);
	        assertTrue(parser.getHoldStack().empty());
	        assertTrue(parser.getStateStack().empty());
	        
	        state.shiftRightPara();
	        
	        assertTrue(parser.getInputStack().empty());
	        assertFalse(parser.getHoldStack().empty());
	        assertFalse(parser.getStateStack().empty());
	        
	        assertEquals(parser.getHoldStack().peek(), token);
	        assertEquals(parser.getStateStack().peek(), state);
	        assertTrue(parser.getCurrentState() instanceof CILS_23);
		}
}
