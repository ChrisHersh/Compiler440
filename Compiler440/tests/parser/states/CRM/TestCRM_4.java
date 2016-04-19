package parser.states.CRM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_10;
import parser.states.CILS.CILS_3;
import parser.states.CILS.CILS_6;
import parser.states.CILS.CILS_7;
import parser.states.CILS.CILS_8;
import parser.states.CILS.CILS_9;
import parser.states.CRM.CRM_4;
import parser.states.CRM.CRM_5;
import tokenizer.Token;
/**
 * Test class to check the methods of the CRM_4 class.
 * @author TJ Renninger, Jason LoBianco
 */
public class TestCRM_4
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
     * Test to make sure that shifting on } works
     * @author TJ Renninger
     * @throws ParserException
     */
    @Test
	public void testShiftRightBrace() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_4();
	        
	    Token token = new Token("}", "RightBrace", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftRightBrace();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_5);
	}
    
    /**
     * Checks to see that shiftSTMT() works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftSTMT() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_4();
	        
	    Token token = new Token("STMT", "STMT", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftSTMT();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CILS_3);
	}
    
    /**
     * Checks to see that shiftIf() works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftIf() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_4();
	        
	    Token token = new Token("If", "If", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftIf();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CILS_7);
	}
    
    /**
     * Checks to see that shiftLeftBrace() works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftLeftBrace() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_4();
	        
	    Token token = new Token("{", "L_BRACE", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftLeftBrace();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CILS_6);
	}
    
    /**
     * Checks to see that shiftWhile() works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftWhile() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_4();
	        
	    Token token = new Token("While", "While", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftWhile();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CILS_10);
	}
    
    /**
     * Checks to see that shiftSystemOutPrintln() works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftSystemOutPrintln() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_4();
	        
	    Token token = new Token("SystemOutPrintln", "SystemOutPrintln", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftSystemOutPrintln();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CILS_8);
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
	    State s = new CRM_4();
	        
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
	    
	    assertTrue(p.getCurrentState() instanceof CILS_9);
	}
}
