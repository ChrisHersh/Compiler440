package parser.states.JCTM;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;

public class TestJCTM_20 {

    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
    @Test
    public void testInt() throws ParserException 
    {
    	Parser parser = Parser.getInstance();
    	State state = new JCTM_20();
    	
    	Token token = new Token("[", "LBrace", 5);
    	
    	parser.getInputStack().push(token);
    	
    	assertFalse(parser.getInputStack().empty());
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftLeftBrace();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_21);
        
    }

}
