package parser.states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;

/**
 * @author Jared Good
 */

public class TestMDJ_14 
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
	 * @author Jared Good
	 * @throws ParserException
	 * Tests that MDJ_14 can properly shift to MDJ_15 when reading a "RightPara" token
	 */
	@Test
	public void testShiftRightPara() throws ParserException
	{
		Parser p = Parser.getInstance();
		State s = new MDJ_14();

		Token token = new Token("RightPara", "RightPara", 15);

		p.getInputStack().push(token);

		assertFalse(p.getInputStack().empty());
		assertEquals(p.getInputStack().peek(), token);
		assertTrue(p.getHoldStack().empty());
		assertTrue(p.getStateStack().empty());

		s.shiftRightPara();

		assertTrue(p.getInputStack().empty());
		assertFalse(p.getHoldStack().empty());
		assertFalse(p.getStateStack().empty());

		assertEquals(p.getHoldStack().peek(), token);
		assertEquals(p.getStateStack().peek(), s);

		assertTrue(p.getCurrentState() instanceof MDJ_15);
	}
	
}
