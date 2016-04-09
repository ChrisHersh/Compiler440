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
 * Test all of the state shifts for MDJ_24
 * @author Raistlin Hess
 *
 */
public class TestMDJ_24 
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
	 * Make sure handles } input correctly.
	 * It should shift to MDJ_26
	 */
	@Test
	public void testRightBrace() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new MDJ_24();
    	Token token = new Token("^(})","RBRACE",1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftRightBrace();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof MDJ_26);
	}
	
	/**
	 * Make sure handles METH_DECL input correctly.
	 * It should shift to CRM_35
	 */
	@Test
	public void testMETH_DECL() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new MDJ_24();
    	Token token = new Token("^(\\S+)","JUNK",1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftMETH_DECL();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CRM_35);
	}
	
	/**
	 * Make sure handles public input correctly.
	 * It should shift to CRM_36
	 */
	@Test
	public void testPublic() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new MDJ_24();
    	Token token = new Token("^(public)(\\W|\\Z)", TokenTypes.Public.name(),1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftPublic();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CRM_36);
	}
}
