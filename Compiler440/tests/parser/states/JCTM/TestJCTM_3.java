package parser.states.JCTM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;

/**
 * Test state JCTM_3
 * @author Daniel Breitigan
 *
 */
public class TestJCTM_3
{
    
  //reset parser
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }

  //Test shift Length
    @Test
    public void testLength() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_3();
        
        Token token = new Token("Length", "Length", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftLength();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_6);  
    }
    
  //Test shift Id
    @Test
    public void testId() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_3();
        
        Token token = new Token("Id", "Id", 5);
        
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
        
        assertTrue(parser.getCurrentState() instanceof JCTM_7);  
    }
}
