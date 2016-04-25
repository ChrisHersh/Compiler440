package parser.states.JCTM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.*;
import tokenizer.Token;

/**
 * Test JCTM_4
 * @author Daniel Breitigan
 *
 */
public class TestJCTM_4
{

    //reset parser
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
    //Test shift RightBracket
    @Test
    public void testRightBracket() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_4();
        
        Token token = new Token("RBracket", "RBracket", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftRightBracket();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_5);  
    }
    
  //Test shift OP1
    @Test
    public void testOP1() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_4();
        
        Token token = new Token("OP1", "OP1", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftOP1();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JMCC_3);  
    }
    
  //Test shift Or
    @Test
    public void testOr() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_4();
        
        Token token = new Token("Or", "Or", 5);
        
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
