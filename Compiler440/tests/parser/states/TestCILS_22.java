package parser.states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test class to check the methods of the CILS_22 class.
 *
 */
public class TestCILS_22 {
    @Before
    public void setUp() {
        Parser.resetParser();
    }
    

    /**
     * Tests shifting to CILS_13 when id is received. 
     * @throws ParserException
     */
	@Test
	public void shiftSemiColon() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_22();
    	Token token = new Token(";",TokenTypes.SemiColon.name(),1);
    	
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftSemiColon();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CILS_24);
	}
}
