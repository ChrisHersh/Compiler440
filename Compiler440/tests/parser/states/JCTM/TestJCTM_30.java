package parser.states.JCTM;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_2;
import parser.states.JMCC.JMCC_3;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class TestJCTM_30 {

	/**
	 * Reset the parser
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
        State s = new JCTM_30();
        
        Token inpToken = new Token("op3", TokenTypes.OP1.name(), 6);
        
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
     * Make sure || works
     * @throws ParserException
     */
    @Test
    public void testShiftOr() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_30();
        
        Token inpToken = new Token("!=", TokenTypes.Or.name(), 6);
        
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
    
    /**
     * Make sure ) works
     * @throws ParserException
     */
    @Test
    public void testShiftRightPara() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_30();
        
        Token inpToken = new Token("!=", TokenTypes.RPara.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JCTM_31);
    }


}
