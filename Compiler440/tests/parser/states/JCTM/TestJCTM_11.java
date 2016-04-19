package parser.states.JCTM;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_1;
import parser.states.JMCC.JMCC_3;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class TestJCTM_11 
{

    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    //tests the shift of OP1 in JCTM_11
    @Test
    public void testShiftOP1() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_11();
        
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
  //tests the shift of comma in JCTM_11
    @Test
    public void testShiftComa() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_11();
        
        Token inpToken = new Token(",", TokenTypes.Comma.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JCTM_13);
    }
    
  //tests the shift of EXPR in JCTM_11
    @Test
    public void testShiftEXPR() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_11();
        
        Token inpToken = new Token("EXP_R", TokenTypes.EXP_R.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JCTM_12);
    }
}
