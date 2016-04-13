package parser.states.CILS;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_20;
import parser.states.CILS.CILS_25;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class TestCILS_20
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
	 * Test the parsing of Assignment.
	 * @throws ParserException
	 */
	@Test
	public void testAssignment() throws ParserException
	{
		Parser parser = Parser.getInstance();
		State state = new CILS_20();
		Token token = new Token("=", TokenTypes.Assignment.name(), 1);

		parser.getInputStack().push(token);

		assertEquals(parser.getInputStack().peek(), token);
		assertTrue(parser.getHoldStack().empty());
		assertTrue(parser.getStateStack().empty());

		state.shiftAssignment();

		assertTrue(parser.getInputStack().empty());
		assertFalse(parser.getHoldStack().empty());
		assertFalse(parser.getStateStack().empty());

		assertEquals(parser.getHoldStack().peek(), token);
		assertEquals(parser.getStateStack().peek(), state);
		assertTrue(parser.getCurrentState() instanceof CILS_25);
	}
}
