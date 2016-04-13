package parser.states.MDJ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.MDJ.MDJ_18;
import parser.states.MDJ.MDJ_19;
import parser.states.MDJ.MDJ_20;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * 
 * @author Jessica Schlesiger and Raistlin Hess
 * Test cases to ensure the MDJ_18 can properly shift when reading tokens
 */
public class TestMDJ_18 {

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
	 * Tests that MDJ_18 can properly shift to MDJ_20 when reading a "{" token
	 */
	@Test
	public void testShiftClass() throws ParserException
	{
		Parser p = Parser.getInstance();
		State s = new MDJ_18();

		Token token = new Token("{", "{", 60);

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

		assertTrue(p.getCurrentState() instanceof MDJ_20);
	}

	/**
	 * Make sure handles extends input correctly.
	 * It should shift to MDJ_19
	 */
	@Test
	public void testRightBrace() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new MDJ_18();
    	Token token = new Token("^(extends)(\\W|\\Z)", TokenTypes.Extends.name(),1);
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftExtends();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof MDJ_19);
	}
}
