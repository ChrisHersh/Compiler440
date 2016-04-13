package parser.states.CRM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_31;
import parser.states.CRM.CRM_32;
import parser.states.JCTM.JCTM_1;
import parser.states.JCTM.JCTM_15;
import parser.states.JCTM.JCTM_16;
import parser.states.JCTM.JCTM_17;
import parser.states.JCTM.JCTM_18;
import parser.states.JCTM.JCTM_19;
import parser.states.JCTM.JCTM_27;
import parser.states.JCTM.JCTM_29;
import parser.states.JCTM.JCTM_33;
import parser.states.JMCC.JMCC_15;
import parser.states.JMCC.JMCC_20;
import parser.states.JMCC.JMCC_32;
import parser.states.JMCC.JMCC_8;
import parser.states.JMCC.JMCC_9;
import tokenizer.Token;
/**
 * Test class to check the methods of the CRM_31 class.
 * @author Chris Kjeldgaard
 */
public class TestCRM_31 {
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
	/**
	 * checks that testShiftEXP1 works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftEXP1() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftEXP1();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_32);
	}
	/**
	 * checks that testShiftEXP2 works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftEXP3() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	    
	    assertTrue(p.getCurrentState() instanceof JMCC_15);
	}
	/**
	 * checks that testShiftEXP1 works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftEXP4() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	 * checks that testShiftEXP5 works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftEXP5() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	 * checks that testShiftEXP6 works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftEXP6() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	 * checks that testShiftEXP7 works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftEXP7() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	    
	    assertTrue(p.getCurrentState() instanceof JCTM_33);
	}
	/**
	 * checks that testShiftIntegerLiteral works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftIntegerLiteral() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	 * checks that testShiftTrue works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftTrue() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	 * checks that testshiftFalse works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testshiftFalse() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	 * checks that testshiftId works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testshiftId() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	 * checks that testshiftThis works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testshiftNew() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	 * checks that testshiftThis works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testshiftThis() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	/**
	 * checks that testShiftExclamation works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftExclamation() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	 * checks that testShiftLeftBrace works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftLeftBrace() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	    
	    assertTrue(p.getCurrentState() instanceof JCTM_29);
	}
	/**
	 * checks that testShiftEXP2 works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftEXP2() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_31();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftEXP2();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JMCC_9);
	}
}
