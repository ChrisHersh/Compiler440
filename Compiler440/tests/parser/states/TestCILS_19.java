package parser.states;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class TestCILS_19
{
	/**
	 * Initialize the parser
	 */
	@Before
	public void setUp()
	{
		Parser.resetParser();
	}

	/**
	 * Test the parsing of RightBrace.
	 * @throws ParserException
	 */
	@Test
	public void testRightBrace() throws ParserException
	{
		Parser parser = Parser.getInstance();
		State state = new CILS_19();
		Token token = new Token("]", TokenTypes.RBrace.name(), 1);

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
		assertTrue(parser.getCurrentState() instanceof CILS_20);
	}
}
