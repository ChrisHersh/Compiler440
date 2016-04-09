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
public class TestMDJ_13 
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
	 * Tests that MDJ_13 can properly shift to MDJ_14 when reading a "LeftPara" token
	 */
	@Test
	public void testShiftLeftPara() throws ParserException
	{
		Parser p = Parser.getInstance();
		State s = new MDJ_13();

		Token token = new Token("LeftPara", "LeftPara", 15);

		p.getInputStack().push(token);

		assertFalse(p.getInputStack().empty());
		assertEquals(p.getInputStack().peek(), token);
		assertTrue(p.getHoldStack().empty());
		assertTrue(p.getStateStack().empty());

		s.shiftLeftPara();

		assertTrue(p.getInputStack().empty());
		assertFalse(p.getHoldStack().empty());
		assertFalse(p.getStateStack().empty());

		assertEquals(p.getHoldStack().peek(), token);
		assertEquals(p.getStateStack().peek(), s);

		assertTrue(p.getCurrentState() instanceof MDJ_14);
	}
	
}
