package parser.states.JCTM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_2;
import tokenizer.Token;

/**
 * 
 * @author Ian Keefer
 *
 */
public class TestJCTM_22
{
	
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
	
    @Test
    public void testOr() throws ParserException 
    {
    	Parser parser = Parser.getInstance();
    	State state = new JCTM_22();
    	
    	Token token = new Token("or", "or", 5);
    	
    	parser.getInputStack().push(token);
    	
    	assertFalse(parser.getInputStack().empty());
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftOr();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JMCC_2);
        
    }
    
}