package parser.states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test for JMCC_30, the EXP4 state
 * @author Daniel Breitigan
 *
 */
public class TestJMCC_30
{

    
    /**
     * Reset the parser so each test is run in isolation
     */
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
    //Make sure it changes to JCTM_19
    @Test
    public void testShiftNew() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_30();
        
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
    
    
    //Make sure it changes to JCTM_27
    @Test
    public void testShiftExclamation() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_30();
        
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
    
    //Make sure it goes ti JCTM_29
    @Test
    public void testShiftLeftPara() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_30();
        
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
     * Make sure that the state will change to JMCC_19
     * @throws ParserException
     */
    @Test
    public void testShiftEXP4() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_30();
        
        Token inpToken = new Token("exp4", "EXP4", 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_19);
    }
    
    /**
     * Make sure that the state will change to JMCC_20
     * @throws ParserException
     */
    @Test
    public void testShiftEXP5() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_30();
        
        Token inpToken = new Token("exp5", "EXP5", 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_20);
    }
    
    /**
     * Make sure that the state will change to JMCC_32
     * @throws ParserException
     */
    @Test
    public void testShiftEXP6() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_30();
        
        Token inpToken = new Token("exp6", "EXP6", 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_32);
    }
    
    /**
     * Make sure that the state will change to JMCC_28
     * @throws ParserException
     */
    @Test
    public void testShiftEXP7() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_30();
        
        Token inpToken = new Token("exp7", TokenTypes.EXP7.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_29);
    }
    
    /**
     * Make sure that the state will change to JMCC_28
     * @throws ParserException
     */
    @Test
    public void testShiftIntegerLiteral() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_30();
        
        Token inpToken = new Token("5", TokenTypes.IntNum.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JCTM_18);
    }
    
    //Make sure state changes to JCTM_15
    @Test
    public void testTrue() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JMCC_30();
        
        Token token = new Token("true", "TRUE", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftTrue();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_15);
        
    }
    
    
    //Make sure state changes to JCTM_16
    @Test
    public void testFalse() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JMCC_30();
        
        Token token = new Token("false", "FALSE", 5);
        
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
    
    
    //Make sure state changes to JCTM_17
    @Test
    public void testThis() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JMCC_30();
        
        Token token = new Token("this", "THIS", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftThis();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_17);
        
    }
    
    //Make sure state changes to JCTM_1
    @Test
    public void testId() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JMCC_30();
        
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
        
        assertTrue(parser.getCurrentState() instanceof JCTM_1);
        
    }
}
