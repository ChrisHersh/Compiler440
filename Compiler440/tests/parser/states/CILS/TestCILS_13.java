package parser.states.CILS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_13;
import parser.states.CILS.CILS_17;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test class to check the methods of the CILS_13 class.
 *
 */
public class TestCILS_13 {
    @Before
    public void setUp() {
        Parser.resetParser();
    }
    

    /**
     * @author Corey Peregord 
     * Tests shifting to CILS_17 when EXP1 is received. 
     * @throws ParserException
     */
	@Test
	public void shiftLeftPara() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_13();
    	Token token = new Token("EXP1",TokenTypes.EXP1.name(),1);
    	
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP1();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CILS_17);
	}
}
