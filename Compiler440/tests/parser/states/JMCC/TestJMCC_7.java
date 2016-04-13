package parser.states.JMCC;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
import parser.states.JMCC.JMCC_29;
import parser.states.JMCC.JMCC_32;
import parser.states.JMCC.JMCC_33;
import parser.states.JMCC.JMCC_7;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class TestJMCC_7 
{
	/**
	 * Initialize the parser
	 * @author Jessica Schlesiger, Raistlin Hess, and Shannon Jones
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }

	/**
	 * Make sure handles this input correctly.
	 * It should shift to JMCC_7
	 */
	@Test
	public void testThis() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new JMCC_7();
    	Token token = new Token("this","THIS",1);
    	
    	parser.getInputStack().push(token);
    	
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
	
	/**
	 * Make sure handles ( input correctly.
	 * It should shift to JMCC_7
	 */
	@Test
	public void testLeftPara() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new JMCC_7();
    	Token token = new Token("^(\\()","L_PARA",1);
    	
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftLeftPara();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof JCTM_29);
	}
	
	/**
	 * Make sure handles EXP5 input correctly.
	 * It should shift to JMCC_7
	 */
	@Test
	public void testEXP5() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new JMCC_7();
    	Token token = new Token("^(\\S+)","JUNK",1);
    	
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP5();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof JMCC_33);
	}
	
	/**
	 * Test that the shift integer works correctly
	 * @author shannon jones
	 * @throws ParserException
	 */
	@Test
    public void testShiftIntLit() throws ParserException
    {
        Parser par = Parser.getInstance();
        State st = new JMCC_7();
        
        Token tok = new Token("7", TokenTypes.IntNum.name(), 3);
        
        par.getInputStack().push(tok);
        
        assertFalse(par.getInputStack().empty());
        assertEquals(par.getInputStack().peek(), tok);
        assertTrue(par.getHoldStack().empty());
        assertTrue(par.getStateStack().empty());
        
        st.shiftIntegerLiteral();
        
        assertTrue(par.getInputStack().empty());
        assertFalse(par.getHoldStack().empty());
        assertFalse(par.getStateStack().empty());
        
        assertEquals(par.getHoldStack().peek(), tok);
        assertEquals(par.getStateStack().peek(), st);
        
        assertTrue(par.getCurrentState() instanceof JCTM_18);
    }
	
	/**
	 * Tests the the shift false works correctly
	 * @author shannon jones
	 * @throws ParserException
	 */
	@Test
    public void testShiftFalse() throws ParserException
    {
        Parser par = Parser.getInstance();
        State st = new JMCC_7();
        
        Token tok = new Token("false", TokenTypes.False.name(), 3);
        
        par.getInputStack().push(tok);
        
        assertFalse(par.getInputStack().empty());
        assertEquals(par.getInputStack().peek(), tok);
        assertTrue(par.getHoldStack().empty());
        assertTrue(par.getStateStack().empty());
        
        st.shiftFalse();
        
        assertTrue(par.getInputStack().empty());
        assertFalse(par.getHoldStack().empty());
        assertFalse(par.getStateStack().empty());
        
        assertEquals(par.getHoldStack().peek(), tok);
        assertEquals(par.getStateStack().peek(), st);
        
        assertTrue(par.getCurrentState() instanceof JCTM_16);
    }
	
	/**
	 * Test that the shift id works correctly
	 * @author shannon jones
	 * @throws ParserException
	 */
	@Test
    public void testShiftId() throws ParserException
    {
        Parser par = Parser.getInstance();
        State st = new JMCC_7();
        
        Token tok = new Token("id", TokenTypes.Id.name(), 3);
        
        par.getInputStack().push(tok);
        
        assertFalse(par.getInputStack().empty());
        assertEquals(par.getInputStack().peek(), tok);
        assertTrue(par.getHoldStack().empty());
        assertTrue(par.getStateStack().empty());
        
        st.shiftId();
        
        assertTrue(par.getInputStack().empty());
        assertFalse(par.getHoldStack().empty());
        assertFalse(par.getStateStack().empty());
        
        assertEquals(par.getHoldStack().peek(), tok);
        assertEquals(par.getStateStack().peek(), st);
        
        assertTrue(par.getCurrentState() instanceof JCTM_1);
    }
	
	/**
	 * Test that the shift exclamation works correctly
	 * @author shannon jones
	 * @throws ParserException
	 */
	@Test
    public void testShiftExclamation() throws ParserException
    {
        Parser par = Parser.getInstance();
        State st = new JMCC_7();
        
        Token tok = new Token("!", TokenTypes.Not.name(), 3);
        
        par.getInputStack().push(tok);
        
        assertFalse(par.getInputStack().empty());
        assertEquals(par.getInputStack().peek(), tok);
        assertTrue(par.getHoldStack().empty());
        assertTrue(par.getStateStack().empty());
        
        st.shiftExclamation();
        
        assertTrue(par.getInputStack().empty());
        assertFalse(par.getHoldStack().empty());
        assertFalse(par.getStateStack().empty());
        
        assertEquals(par.getHoldStack().peek(), tok);
        assertEquals(par.getStateStack().peek(), st);
        
        assertTrue(par.getCurrentState() instanceof JCTM_27);
    }
	
	/**
	 * Tests Shift EXP6 works
	 * @author Jessica Schlesiger
	 */
	@Test
    public void testShiftEXP6() throws ParserException
    {
        Parser par = Parser.getInstance();
        State st = new JMCC_7();
        
        Token tok = new Token("EXP6", "EXP6", 3);
        
        par.getInputStack().push(tok);
        
        assertFalse(par.getInputStack().empty());
        assertEquals(par.getInputStack().peek(), tok);
        assertTrue(par.getHoldStack().empty());
        assertTrue(par.getStateStack().empty());
        
        st.shiftEXP6();
        
        assertTrue(par.getInputStack().empty());
        assertFalse(par.getHoldStack().empty());
        assertFalse(par.getStateStack().empty());
        
        assertEquals(par.getHoldStack().peek(), tok);
        assertEquals(par.getStateStack().peek(), st);
        
        assertTrue(par.getCurrentState() instanceof JMCC_32);
    }

	/**
	 * Tests Shift EXP7 works
	 * @author Jessica Schlesiger
	 */
	@Test
    public void testShiftEXP7() throws ParserException
    {
        Parser par = Parser.getInstance();
        State st = new JMCC_7();
        
        Token tok = new Token("EXP7", "EXP7", 3);
        
        par.getInputStack().push(tok);
        
        assertFalse(par.getInputStack().empty());
        assertEquals(par.getInputStack().peek(), tok);
        assertTrue(par.getHoldStack().empty());
        assertTrue(par.getStateStack().empty());
        
        st.shiftEXP7();
        
        assertTrue(par.getInputStack().empty());
        assertFalse(par.getHoldStack().empty());
        assertFalse(par.getStateStack().empty());
        
        assertEquals(par.getHoldStack().peek(), tok);
        assertEquals(par.getStateStack().peek(), st);
        
        assertTrue(par.getCurrentState() instanceof JMCC_29);
    }

	/**
	 * Tests Shift true works
	 * @author Jessica Schlesiger
	 */
	@Test
    public void testShiftTrue() throws ParserException
    {
        Parser par = Parser.getInstance();
        State st = new JMCC_7();
        
        Token tok = new Token("true", "TRUE", 3);
        
        par.getInputStack().push(tok);
        
        assertFalse(par.getInputStack().empty());
        assertEquals(par.getInputStack().peek(), tok);
        assertTrue(par.getHoldStack().empty());
        assertTrue(par.getStateStack().empty());
        
        st.shiftTrue();
        
        assertTrue(par.getInputStack().empty());
        assertFalse(par.getHoldStack().empty());
        assertFalse(par.getStateStack().empty());
        
        assertEquals(par.getHoldStack().peek(), tok);
        assertEquals(par.getStateStack().peek(), st);
        
        assertTrue(par.getCurrentState() instanceof JCTM_15);
    }

	/**
	 * Tests Shift new works
	 * @author Jessica Schlesiger
	 */
	@Test
    public void testShiftNew() throws ParserException
    {
        Parser par = Parser.getInstance();
        State st = new JMCC_7();
        
        Token tok = new Token("new", "NEW", 3);
        
        par.getInputStack().push(tok);
        
        assertFalse(par.getInputStack().empty());
        assertEquals(par.getInputStack().peek(), tok);
        assertTrue(par.getHoldStack().empty());
        assertTrue(par.getStateStack().empty());
        
        st.shiftNew();
        
        assertTrue(par.getInputStack().empty());
        assertFalse(par.getHoldStack().empty());
        assertFalse(par.getStateStack().empty());
        
        assertEquals(par.getHoldStack().peek(), tok);
        assertEquals(par.getStateStack().peek(), st);
        
        assertTrue(par.getCurrentState() instanceof JCTM_19);
    }
}
