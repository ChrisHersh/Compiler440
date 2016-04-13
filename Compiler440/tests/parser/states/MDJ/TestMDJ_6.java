package parser.states.MDJ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.MDJ.MDJ_6;
import parser.states.MDJ.MDJ_7;
import tokenizer.Token;
/**
 * 
 * @author Curtis Rabe
 * Test cases to ensure the MDJ_6 can properly shift when reading tokens
 */
public class TestMDJ_6
{

	/**
	 * prepares the parser from former test
	 */
	@Before
	public void setUp()
	{
		Parser.resetParser();
	}

	/**
	 * @author Curtis Rabe
	 * @throws ParserException
	 * Tests that MDJ_6 can properly shift to MDJ_7 when reading a "{" token
	 */
	@Test
	public void testShiftLeftBrace() throws ParserException
	{
		Parser p = Parser.getInstance();
		State s = new MDJ_6();

		Token token = new Token("{", "{", 6);

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

		assertTrue(p.getCurrentState() instanceof MDJ_7);
	}

}
