package parser.states;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;

/**
 * Tests the functionality of CILS_2
 * making sure it changes state correctly
 * @author Shannon Lee
 *
 */
public class TestCILS_2 {

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
	public void testIf() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_2();
    	Token token = new Token("if","IF",1);
    	
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftIf();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CILS_7);
	}

}
