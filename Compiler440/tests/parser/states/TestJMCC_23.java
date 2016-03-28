package parser.states;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;

/**
 * 
 * @author Chad Nunemaker
 * 
 * In Ian and Chris's test style. 
 *
 */
public class TestJMCC_23
{
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
    @Test
    public void testShiftEXP6() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_23();
        
        Token inpToken = new Token("exp6", "EXP6", 42);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        s.shiftEXP7();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JMCC_24);
    }
    
    @Test
    public void testShiftEXP7() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_23();
        
        Token inpToken = new Token("exp7", "EXP7", 42);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        s.shiftEXP7();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JMCC_29);
    }
    @Test
    public void testshiftid() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_1();
        
        Token inpToken = new Token("id", "ID", 42);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        s.shiftid();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JCTM_1);
    }
    
    @Test
    public void testshiftthis() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_17();
        
        Token inpToken = new Token("this", "THIS", 42);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        s.shiftthis();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JJCTM_17);
    }
}