package parser.states;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import parser.Parser;
import tokenizer.Token;

/**
 * Test class to check the methods of the JMCC_5 class.
 * @author Chris Kjeldgaard, Jason LoBianco
 *
 */
public class TestJMCC_5 
{
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
    /**
     * @author Chris Kjeldgaard
     * @throws ParserException
     */
    @Test
	public void testShiftLeftBrace() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("{", "L_Brace", 5);
	    
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
