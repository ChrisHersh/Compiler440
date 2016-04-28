package parser.states.JMCC;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_1;
import parser.states.JMCC.JMCC_2;
import parser.states.JMCC.JMCC_3;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * 
 * @author Chris Hersh
 *
 */
public class TestJMCC_1
{
	/**
	 * Reset the parsers
	 */
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
    /**
     * Make sure OP1 works
     * @throws ParserException
     */
    @Test
    public void testShiftOP1() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_1();
        
        Token inpToken = new Token("op1", TokenTypes.OP1.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_3);
    }
    
    /**
     * Make sure != works
     * @throws ParserException
     */
    @Test
    public void testShiftNotEquals() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_1();
        
        Token inpToken = new Token("||", TokenTypes.Or.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_2);
    }
}
