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
 * Test all of the state shifts for CILS_14
 * @author Raistlin Hess
 *
 */
public class TestCILS_14
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
	 * Make sure handles EXP1 input correctly.
	 * It should shift to CILS_18
	 */
	@Test
	public void testShiftEXP1() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("EXP1",TokenTypes.EXP1.name(),1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP1();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CILS_18);
	}
	
	/**
	 * Make sure handles EXP2 input correctly.
	 * It should shift to JMCC_9
	 */
	@Test
	public void testShiftEXP2() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("EXP2",TokenTypes.EXP2.name(),1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP2();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof JMCC_9);
	}
	
	/**
	 * Make sure handles EXP3 input correctly.
	 * It should shift to JMCC_15
	 */
	@Test
	public void testShiftEXP3() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("EXP3",TokenTypes.EXP3.name(),1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP3();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof JMCC_15);
	}
	
	/**
	 * Make sure handles EXP4 input correctly.
	 * It should shift to JMCC_8
	 */
	@Test
	public void testShiftEXP4() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("EXP4",TokenTypes.EXP4.name(),1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP4();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof JMCC_8);
	}
	
	/**
	 * Make sure handles EXP5 input correctly.
	 * It should shift to JMCC_20
	 */
	@Test
	public void testShiftEXP5() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("EXP5",TokenTypes.EXP5.name(),1);
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
        assertTrue(parser.getCurrentState() instanceof JMCC_20);
	}
	
	/**
	 * Make sure handles EXP6 input correctly.
	 * It should shift to JMCC_32
	 */
	@Test
	public void testShiftEXP6() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("EXP6",TokenTypes.EXP6.name(),1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP6();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof JMCC_32);
	}
	
	/**
	 * Make sure handles EXP7 input correctly.
	 * It should shift to JMCC_33
	 */
	@Test
	public void testShiftEXP7() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("EXP7",TokenTypes.EXP7.name(),1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP7();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof JMCC_33);
	}
	
	/**
	 * Make sure handles true input correctly.
	 * It should shift to JCTM_15
	 */
	@Test
	public void testShiftTrue() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("true",TokenTypes.True.name(),1);
    	parser.getInputStack().push(token);
    	
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
	
	/**
	 * Make sure handles new input correctly.
	 * It should shift to 
	 */
	@Test
	public void testShiftNew() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("new",TokenTypes.New.name(),1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftNew();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof JCTM_19);
	}
	
	/**
	 * Make sure handles INT_LIT input correctly.
	 * It should shift to JCTM_18
	 */
	@Test
	public void testShiftINT_LIT() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("INT_LIT",TokenTypes.IntNum.name(),1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftIntegerLiteral();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof JCTM_18);
	}
	
	/**
	 * Make sure handles ! input correctly.
	 * It should shift to JCTM_27
	 */
	@Test
	public void testShiftNot() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("!",TokenTypes.Not.name(),1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftNot();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof JCTM_27);
	}
	
	/**
	 * Make sure handles false input correctly.
	 * It should shift to JCTM_16
	 */
	@Test
	public void testShiftFalse() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("false",TokenTypes.False.name(),1);
    	parser.getInputStack().push(token);
    	
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
	
	/**
	 * Make sure handles id input correctly.
	 * It should shift to JCTM_1
	 */
	@Test
	public void testShift() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("funName",TokenTypes.Id.name(),1);
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
        assertTrue(parser.getCurrentState() instanceof JCTM_1);
	}
	
	/**
	 * Make sure handles ( input correctly.
	 * It should shift to JCTM_29
	 */
	@Test
	public void testShiftLeftPara() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("(",TokenTypes.LPara.name(),1);
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
	 * Make sure handles this input correctly.
	 * It should shift to 
	 */
	@Test
	public void testShiftThis() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_14();
    	Token token = new Token("this",TokenTypes.This.name(),1);
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
}
