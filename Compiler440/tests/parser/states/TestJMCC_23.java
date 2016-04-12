package parser.states;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.JCTM_1;
import parser.states.JCTM_15;
import parser.states.JCTM_16;
import parser.states.JCTM_17;
import parser.states.JCTM_18;
import parser.states.JCTM_19;
import parser.states.JCTM_27;
import parser.states.JCTM_29;
import parser.states.JMCC_23;
import parser.states.JMCC_24;
import parser.states.JMCC_29;
import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;

/**
 * 
 * @author Chad Nunemaker, Manal Ibrahim
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
    
    /**
     * Test that the state can shift to JMCC_20
     * @throws ParserException
     */
    @Test
    public void testShiftEXP5() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_23();
        
        Token inpToken = new Token("exp5", "EXP5", 42);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        s.shiftEXP5();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JMCC_20);
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
        
        s.shiftEXP6();
        
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
    
    /**
     * Test class to check the IntegerLitera methods of the JCTM_18 class.
     * @author Manal Ibrahim
     *
     */
    @Test
    public void testShiftIntegerLiteral() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_23();
        
        Token inpToken = new Token("5", "INT_NUM", 6);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        s.shiftIntegerLiteral();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JCTM_18);
    }
    /**
     * Test class to check the True methods of the JCTM_15 class.
     * @author Manal Ibrahim
     *
     */
    @Test
    public void testTrue() throws ParserException 
    {
    	Parser parser = Parser.getInstance();
    	 State s = new JMCC_23();
    	
    	Token token = new Token("true", "TRUE", 23);
    	
    	parser.getInputStack().push(token);
    	
    	assertFalse(parser.getInputStack().empty());
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        s.shiftTrue();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), s);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_15);
        
    }
    /**
     * Test class to check the False methods of the JCTM_16 class.
     * @author Manal Ibrahim
     *
     */
    @Test
    public void testFalse() throws ParserException 
    {
    	Parser parser = Parser.getInstance();
    	State state = new JMCC_23();
    	
    	Token token = new Token("false", "FALSE", 23);
    	
    	parser.getInputStack().push(token);
    	
    	assertFalse(parser.getInputStack().empty());
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftFalse();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_16);
        
    }
    

    public void testShiftNew() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_23();
        
        Token inpToken = new Token("new", "NEW", 42);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        s.shiftNew();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JCTM_19);
    }
    
    @Test
    public void testShiftExclamation() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_23();
        
        Token inpToken = new Token("!", "NOT", 42);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        s.shiftExclamation();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JCTM_27);
    }
    
    @Test
    public void testShiftLeftPara() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_23();
        
        Token inpToken = new Token("(", "LEFT_PARA", 42);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        s.shiftLeftPara();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JCTM_29);
    }
    /**
     * Mohammed
     * Make sure that the state will change to JCTM_1
     * @throws ParserException
     */
    @Test
    public void testshiftid() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_23();
        
        Token inpToken = new Token("id", "ID", 42);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        s.shiftId();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JCTM_1);
    }
    
    /**
     * Mohammed
     * Make sure that the state will change to JCTM_17
     * @throws ParserException
     */
    @Test
    public void testshiftthis() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_23();
        
        Token inpToken = new Token("this", "THIS", 42);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        s.shiftThis();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JCTM_17);
    }
}
