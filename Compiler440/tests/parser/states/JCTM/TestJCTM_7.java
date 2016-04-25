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
import tokenizer.TokenTypes;

/**
 * Test JCTM_7
 * @author Daniel Breitigan
 *
 */
public class TestJCTM_7
{

    //Set up Parser
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
    //Test shift Left paranthesis
    @Test
    public void testShiftLPara() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_7();
        
        Token inpToken = new Token("LPara", TokenTypes.LPara.name(), 6);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        //Make the current state the one we're testing
        p.changeState(s);
        
        p.nextState();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JCTM_8);
    }
    
}
