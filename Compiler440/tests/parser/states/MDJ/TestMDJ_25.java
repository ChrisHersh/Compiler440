package parser.states.MDJ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_12;
import parser.states.CRM.CRM_13;
import parser.states.CRM.CRM_3;
import parser.states.CRM.CRM_6;
import parser.states.CRM.CRM_9;
import parser.states.MDJ.MDJ_25;
import parser.states.MDJ.MDJ_27;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Tests the methods of class MDJ_25
 * @author Jason LoBianco, Shannon Jones
 */
public class TestMDJ_25 
{

	/**
	 * Initialize the parser
	 * @author Shannon Jones
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    } 
	
	/**
	 * test shift METH_DECL_L
	 * @throws ParserException
	 */
	@Test
	public void testShiftMETH_DECL_L() throws ParserException 
	{
		 
			    Parser p = Parser.getInstance();
			    State s = new MDJ_25();
			        
			    Token token = new Token("METH_DECL_L", TokenTypes.METH_DECL_L.name(), 4);
			    
			    p.getInputStack().push(token);
			    
			    assertFalse(p.getInputStack().empty());
			    assertEquals(p.getInputStack().peek(), token);
			    assertTrue(p.getHoldStack().empty());
			    assertTrue(p.getStateStack().empty());
			    
			    s.shiftMETH_DECL_L();
			   
			    assertTrue(p.getInputStack().empty());
			    assertFalse(p.getHoldStack().empty());
			    assertFalse(p.getStateStack().empty());
			    
			    assertEquals(p.getHoldStack().peek(), token);
			    assertEquals(p.getStateStack().peek(), s);
			    
			    assertTrue(p.getCurrentState() instanceof MDJ_27);
	}
	
	/**
	 * checks that shiftVAR_DECL works correctly
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	@Test
	public void testShiftVAR_DECL() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new MDJ_25();
	        
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
	 * checks that shiftTYPE works correctly
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	@Test
	public void testShiftTYPE() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new MDJ_25();
	        
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
	 * checks that shiftInt works correctly
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	@Test
	public void testShiftInt() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new MDJ_25();
	        
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
	 * checks that shiftBoolean works correctly
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	@Test
	public void testShiftBoolean() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new MDJ_25();
	        
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
	 * checks that shiftId works correctly
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	@Test
	public void testShiftId() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new MDJ_25();
	        
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
	    State s = new MDJ_25();
	        
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
	    
	    assertTrue(p.getCurrentState() instanceof MDJ_25);
    }

}
