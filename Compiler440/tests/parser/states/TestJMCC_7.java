package parser.states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import parser.Parser;
import tokenizer.Token;

public class TestJMCC_7 
{
	/**
	 * Initialize the parser
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }

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
}
