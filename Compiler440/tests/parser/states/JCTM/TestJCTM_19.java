package parser.states.JCTM;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;

/**
 * @author Matt Mousetis
 */
public class TestJCTM_19 {

    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
	
    @Test
    public void testId() throws ParserException 
    {
    	Parser parser = Parser.getInstance();
    	State state = new JCTM_19();
    	
    	Token token = new Token("id", "ID", 5);
    	
    	parser.getInputStack().push(token);
    	
    	assertFalse(parser.getInputStack().empty());
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftId();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_24);
        
    }

    @Test
    public void testInt() throws ParserException 
    {
    	Parser parser = Parser.getInstance();
    	State state = new JCTM_19();
    	
    	Token token = new Token("int", "INT", 5);
    	
    	parser.getInputStack().push(token);
    	
    	assertFalse(parser.getInputStack().empty());
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftInt();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_20);
        
    }
    
}
