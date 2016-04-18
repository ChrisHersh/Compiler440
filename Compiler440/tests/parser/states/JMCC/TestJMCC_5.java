package parser.states.JMCC;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.JCTM.JCTM_1;
import parser.states.JCTM.JCTM_15;
import parser.states.JCTM.JCTM_16;
import parser.states.JCTM.JCTM_17;
import parser.states.JCTM.JCTM_18;
import parser.states.JCTM.JCTM_19;
import parser.states.JCTM.JCTM_27;
import parser.states.JCTM.JCTM_29;
import parser.states.JMCC.JMCC_20;
import parser.states.JMCC.JMCC_29;
import parser.states.JMCC.JMCC_32;
import parser.states.JMCC.JMCC_5;
import parser.states.JMCC.JMCC_6;
import parser.states.JMCC.JMCC_8;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test class to check the methods of the JMCC_5 class.
 * @author Chris Kjeldgaard, Jason LoBianco
 *
 */
public class TestJMCC_5 
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
     * Make sure EXP3 works
     * @author Ledny Joseph
     * @throws ParserException
     */
    @Test
    public void testShiftEXP3() throws ParserException
    {
    	Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("exp3", "EXP3", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftEXP3();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JMCC_6);
    }
    
    /**
     * Make sure EXP4 works
     * @throws ParserException
     */
    @Test
    public void testShiftEXP4() throws ParserException
    {
    	Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("exp4", "EXP4", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftEXP4();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
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
	    State s = new JMCC_5();
	        
	    Token token = new Token("exp5", "EXP5", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftEXP5();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JMCC_20);
    }
    
    /**
     * Make sure EXP2 works
     * @throws ParserException
     */
    @Test
    public void testShiftEXP2() throws ParserException
    {
    	Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("exp6", "EXP6", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftEXP6();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JMCC_32);
    }
	
    /**
     * Make sure { works
     * @author Chris Kjeldgaard
     * @throws ParserException
     */
    @Test
	public void testShiftLeftBrace() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("{", TokenTypes.LBrace.name(), 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    p.changeState(s);
        
        p.nextState();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JCTM_29);
	}
    
    /**
     * Make sure ! works
     * @author Chris Kjeldgaard
     * @throws ParserException
     */
    @Test
	public void testShiftExclamation() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("!", "Not", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftExclamation();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JCTM_27);
	}
    
    /**
     * Make sure new works
     * @author Chris Kjeldgaard
     * @throws ParserException
     */
    @Test
	public void testShiftNew() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("new", "New", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftNew();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JCTM_19);
	}
    
    /**
     * Make sure EXP7 works
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
    public void testShiftEXP7() throws ParserException
    {
    	Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("EXP7", "EXP7", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftEXP7();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JMCC_29);
    }
    
    /**
     * Make sure id works
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
    public void testShiftId() throws ParserException
    {
    	Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("id", "Id", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftId();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JCTM_1);
    }
    
    /**
     * Make sure integer literal works
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
    public void testShiftIntegerLiteral() throws ParserException
    {
    	Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("integerLiteral", "IntegerLiteral", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftIntegerLiteral();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JCTM_18);
    }
    
    /**
     * Test to make sure shifting on true works for JMCC_5
     * @author TJ Renninger
     * @throws ParserException
     */
    @Test
    public void testShiftTrue() throws ParserException
    {
    	Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("true", "TRUE", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftTrue();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JCTM_15);
    }
    
    /**
     * Test to make sure shifting on false works for JMCC_5
     * @author TJ Renninger
     * @throws ParserException
     */
    @Test
    public void testShiftFalse() throws ParserException
    {
    	Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("false", "FALSE", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftFalse();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JCTM_16);
    }
    
    /**
     * Test to make sure shifting on this works for JMCC_5
     * @author TJ Renninger
     * @throws ParserException
     */
    @Test
    public void testShiftThis() throws ParserException
    {
    	Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("this", "THIS", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftThis();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JCTM_17);
    }
}
