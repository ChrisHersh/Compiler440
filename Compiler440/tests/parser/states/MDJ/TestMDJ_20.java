package parser.states.MDJ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.MDJ.MDJ_20;
import parser.states.MDJ.MDJ_22;
import tokenizer.Token;
/**
 * 
 * @author Jessica Schlesiger
 * Test cases to ensure the MDJ_20 can properly shift when reading tokens
 */
public class TestMDJ_20 {

	/**
	 * prepares the parser from former test
	 */
	@Before
	public void setUp()
	{
		Parser.resetParser();
	}

	/**
	 * @author Jessica Schlesiger
	 * @throws ParserException
	 * Tests that MDJ_20 can properly shift to MDJ_22 when reading a "VAR_DECL_L" token
	 */
	@Test
	public void testShiftClass() throws ParserException
	{
		Parser p = Parser.getInstance();
		State s = new MDJ_20();

		Token token = new Token("VAR_DECL_L", "VAR_DECL_L", 60);

		p.getInputStack().push(token);

		assertFalse(p.getInputStack().empty());
		assertEquals(p.getInputStack().peek(), token);
		assertTrue(p.getHoldStack().empty());
		assertTrue(p.getStateStack().empty());

		s.shiftVAR_DECL_L();

		assertTrue(p.getInputStack().empty());
		assertFalse(p.getHoldStack().empty());
		assertFalse(p.getStateStack().empty());

		assertEquals(p.getHoldStack().peek(), token);
		assertEquals(p.getStateStack().peek(), s);

		assertTrue(p.getCurrentState() instanceof MDJ_22);
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
	    State s = new MDJ_20();
	        
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
	    
	    assertTrue(p.getCurrentState() instanceof MDJ_20);
    }
}
