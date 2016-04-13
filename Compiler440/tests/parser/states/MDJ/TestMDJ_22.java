package parser.states.MDJ;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_12;
import parser.states.CRM.CRM_13;
import parser.states.CRM.CRM_3;
import parser.states.CRM.CRM_33;
import parser.states.CRM.CRM_6;
import parser.states.CRM.CRM_9;
import parser.states.MDJ.MDJ_22;
import parser.states.MDJ.MDJ_24;
import tokenizer.Token;

/**
 * Test all of the state shifts for MDJ_22
 * @author Raistlin Hess
 *
 */
public class TestMDJ_22 
{
	/**
	 * Initialize the Parser
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }

	/**
	 * Make sure handles METH_DECL_L input correctly.
	 * It should shift to MDJ_24
	 */
	@Test
	public void testMETH_DECL_L() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new MDJ_22();
    	Token token = new Token("^(\\S+)","JUNK",1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftMETH_DECL_L();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof MDJ_24);
	}
	
	/**
	 * Make sure handles VAR_DECL input correctly.
	 * It should shift to CRM_3
	 */
	@Test
	public void testVAR_DECL() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new MDJ_22();
    	Token token = new Token("^(\\S+)","JUNK",1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftVAR_DECL();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CRM_3);
	}
	
	/**
	 * Make sure handles TYPE input correctly.
	 * It should shift to CRM_6
	 */
	@Test
	public void testTYPE() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new MDJ_22();
    	Token token = new Token("^(\\S+)","JUNK",1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftTYPE();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CRM_6);
	}
	
	/**
	 * Make sure handles int input correctly.
	 * It should shift to CRM_9
	 */
	@Test
	public void testInt() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new MDJ_22();
    	Token token = new Token("int","INT",1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftInt();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CRM_9);
	}
	
	/**
	 * Make sure handles boolean input correctly.
	 * It should shift to CRM_13
	 */
	@Test
	public void testBoolean() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new MDJ_22();
    	Token token = new Token("^(boolean)(\\W|\\Z)","BOOLEAN",1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftBoolean();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CRM_13);
	}
	
	/**
	 * Make sure handles id input correctly.
	 * It should shift to CRM_12
	 */
	@Test
	public void testId() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new MDJ_22();
    	Token token = new Token("^([A-Za-z]\\w*)","ID",1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftId();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CRM_12);
	}
	
	/**
	 * Make sure handles epsilon input correctly.
	 * It should shift to CRM_33
	 */
	@Test
	public void testInvalidState() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new MDJ_22();
    	Token token = new Token("^([A-Za-z]\\w*)","ID",1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.invalidState();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CRM_33);
	}
}
