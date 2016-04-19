package parser.states.CRM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_2;
import parser.states.CRM.CRM_3;
import parser.states.CRM.CRM_4;
import tokenizer.Token;

/**
 * Test class to check the methods of the CRM_2 class.
 * @author Chris Kjeldgaard, Jason LoBianco
 *
 */
public class TestCRM_2 
{
	/**
	 * Clears the parser before each test
	 */
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
    /**
     * Checks to see that shiftVAR_DECL() works correctly
     * @author Chris Kjeldgaard
     * @throws ParserException
     */
    @Test
	public void testShiftVAR_DECL() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_2();
	        
	    Token token = new Token("VAR_DECL", "VAR_DECL", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftVAR_DECL();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_3);
	}
    
    /**
     * Test to make sure that shifting on STMT_P works
     * @author TJ Renninger
     * @throws ParserException
     */
    @Test
	public void testShiftSTMT_P() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_2();
	        
	    Token token = new Token("STMT_P", "STMT_P", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftSTMT_P();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_4);
	}
    
    /**
     * Checks to see that shiftTYPE() works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftTYPE() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_2();
	        
	    Token token = new Token("TYPE", "TYPE", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftTYPE();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_6);
	}
    
    /**
     * Checks to see that shiftInt() works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftInt() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_2();
	        
	    Token token = new Token("Int", "Int", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftInt();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_9);
	}
    
    /**
     * Checks to see that shiftBoolean() works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftBoolean() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_2();
	        
	    Token token = new Token("Boolean", "Boolean", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftBoolean();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_13);
	}
    
    /**
     * Checks to see that shiftId() works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftId() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_2();
	        
	    Token token = new Token("Id", "Id", 25);
	    
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
	    
	    assertTrue(p.getCurrentState() instanceof CRM_12);
	}
    
    /**
     * Tests to see that InvalidState method works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
    public void testInvalidState() throws ParserException
    {
    	Parser p = Parser.getInstance();
	    State s = new CRM_2();
	        
	    Token token = new Token(";", "Semi", 5);
	    
	    p.getInputStack().push(token);
	    p.changeState(s);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.invalidState();
	    
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    assertTrue(p.getCurrentState() instanceof CRM_2);
    }
}
