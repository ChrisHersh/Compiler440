package parser.states.CILS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_17;
import parser.states.CILS.CILS_22;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test class to check the methods of the CILS_17 class.
 *
 */
public class TestCILS_17 {
    @Before
    public void setUp() {
        Parser.resetParser();
    }
    

    /**
     * @author Corey Peregord 
     * Tests shifting to CILS_22 when ) is received. 
     * @throws ParserException
     */
	@Test
	public void shiftRightPara() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_17();
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
        assertTrue(parser.getCurrentState() instanceof CILS_22);
	}
}
