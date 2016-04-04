package parser.states;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;
/**
 * 
 * @author Curtis Rabe
 * Test cases to ensure the MDJ_7 can properly shift when reading tokens
 */
public class TestMDJ_7
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
	 * Tests that MDJ_7 can properly shift to MDJ_8 when reading a "MAIN_METHOD" token
	 */
	@Test
	public void testShiftMAIN_METHOD() throws ParserException
	{
		Parser p = Parser.getInstance();
		State s = new MDJ_7();

		Token token = new Token("MAIN_METHOD", "MAIN_METHOD", 15);

		p.getInputStack().push(token);

		assertFalse(p.getInputStack().empty());
		assertEquals(p.getInputStack().peek(), token);
		assertTrue(p.getHoldStack().empty());
		assertTrue(p.getStateStack().empty());

		s.shiftMAIN_METHOD();

		assertTrue(p.getInputStack().empty());
		assertFalse(p.getHoldStack().empty());
		assertFalse(p.getStateStack().empty());

		assertEquals(p.getHoldStack().peek(), token);
		assertEquals(p.getStateStack().peek(), s);

		assertTrue(p.getCurrentState() instanceof MDJ_8);
	}

}
