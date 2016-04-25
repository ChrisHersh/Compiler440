package parser.states.JCTM;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_15;
import parser.states.JMCC.JMCC_20;
import parser.states.JMCC.JMCC_32;
import parser.states.JMCC.JMCC_33;
import parser.states.JMCC.JMCC_8;
import parser.states.JMCC.JMCC_9;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Makes sure JCTM_29 works
 * @author Chris Hersh
 *
 */
public class TestJCTM_29 
{
	/**
	 * Reset the parser
	 */
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
    /**
     * Make sure EXP1 works
     * @throws ParserException
     */
    @Test
    public void testShiftEXP1() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("op1", TokenTypes.EXP1.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JCTM_30);
    }
    
    /**
     * Make sure EXP2 works
     * @throws ParserException
     */
    @Test
    public void testShiftEXP2() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("op1", TokenTypes.EXP2.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_9);
    }
    
    /**
     * Make sure EXP3 works
     * @throws ParserException
     */
    @Test
    public void testShiftEXP3() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("op1", TokenTypes.EXP3.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_15);
    }
    
    /**
     * Make sure EXP4 works
     * @throws ParserException
     */
    @Test
    public void testShiftEXP4() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("op1", TokenTypes.EXP4.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_8);
    }
    
    /**
     * Make sure EXP5 works
     * @throws ParserException
     */
    @Test
    public void testShiftEXP5() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("op1", TokenTypes.EXP5.name(), 6);
        
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
     * Make sure EXP6 works
     * @throws ParserException
     */
    @Test
    public void testShiftEXP6() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("op1", TokenTypes.EXP6.name(), 6);
        
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
     * Make sure EXP7 works
     * @throws ParserException
     */
    @Test
    public void testShiftEXP7() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("op1", TokenTypes.EXP7.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_33);
    }
    
    /**
     * Make sure true works
     * @throws ParserException
     */
    @Test
    public void testShiftTrue() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("||", TokenTypes.True.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JCTM_15);
    }
    
    /**
     * Make sure this works
     * @throws ParserException
     */
    @Test
    public void testShiftThis() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("||", TokenTypes.This.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JCTM_17);
    }
    
    /**
     * Make sure ( works
     * @throws ParserException
     */
    @Test
    public void testShiftLeftPara() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("||", TokenTypes.LPara.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JCTM_29);
    }
    
    /**
     * Make sure id works
     * @throws ParserException
     */
    @Test
    public void testShiftId() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("||", TokenTypes.Id.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JCTM_1);
    }
    
    /**
     * Make sure false works
     * @throws ParserException
     */
    @Test
    public void testShiftFalse() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("||", TokenTypes.False.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JCTM_16);
    }
    
    /**
     * Make sure ! works
     * @throws ParserException
     */
    @Test
    public void testShiftNot() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("||", TokenTypes.Not.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JCTM_27);
    }
    
    /**
     * Make sure integer literal works
     * @throws ParserException
     */
    @Test
    public void testShiftIntegerLiteral() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("||", TokenTypes.IntNum.name(), 6);
        
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
    
    /**
     * Make sure new works
     * @throws ParserException
     */
    @Test
    public void testShiftNew() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_29();
        
        Token inpToken = new Token("||", TokenTypes.New.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JCTM_19);
    }
}
