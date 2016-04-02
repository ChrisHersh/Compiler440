package parser.states;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;
/**
 * 
 * @author Jessica Schlesiger
 * Test cases to ensure the MDJ_17 can properly shift when reading tokens
 */
public class TestMDJ_17 {

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
	 * Tests that MDJ_17 can properly shift to MDJ_18 when reading a "id" token
	 */
	@Test
	public void testShiftClass() throws ParserException
	{
		Parser p = Parser.getInstance();
		State s = new MDJ_17();

		Token token = new Token("id", "id", 60);

		p.getInputStack().push(token);

		assertFalse(p.getInputStack().empty());
		assertEquals(p.getInputStack().peek(), token);
		assertTrue(p.getHoldStack().empty());
		assertTrue(p.getStateStack().empty());

		s.shiftId();

		assertTrue(p.getInputStack().empty());
		assertFalse(p.getHoldStack().empty());
		assertFalse(p.getStateStack().empty());

		assertEquals(p.getHoldStack().peek(), token);
		assertEquals(p.getStateStack().peek(), s);

		assertTrue(p.getCurrentState() instanceof MDJ_18);
	}

}
