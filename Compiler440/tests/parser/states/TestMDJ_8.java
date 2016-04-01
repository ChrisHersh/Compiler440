package parser.states;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;
/**
 * 
 * @author Curtis Rabe
 * Test cases to ensure the MDJ_8 can properly shift when reading tokens
 */
public class TestMDJ_8 {

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
	 * Tests that MDJ_8 can properly shift to MDJ_9 when reading a "}" token
	 */
	@Test
	public void testShiftClass() throws ParserException
	{
		Parser p = Parser.getInstance();
		State s = new MDJ_8();

		Token token = new Token("}", "}", 60);

		p.getInputStack().push(token);

		assertFalse(p.getInputStack().empty());
		assertEquals(p.getInputStack().peek(), token);
		assertTrue(p.getHoldStack().empty());
		assertTrue(p.getStateStack().empty());

		s.shiftRightBrace();

		assertTrue(p.getInputStack().empty());
		assertFalse(p.getHoldStack().empty());
		assertFalse(p.getStateStack().empty());

		assertEquals(p.getHoldStack().peek(), token);
		assertEquals(p.getStateStack().peek(), s);

		assertTrue(p.getCurrentState() instanceof MDJ_9);
	}

}
