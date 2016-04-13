package parser.states.CILS;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_26;
import parser.states.CILS.CILS_27;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class TestCILS_26
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
	 * Test the parsing of SemiColon.
	 * @throws ParserException
	 */
	@Test
	public void testSemiColon() throws ParserException
	{
		Parser parser = Parser.getInstance();
		State state = new CILS_26();
		Token token = new Token(";", TokenTypes.SemiColon.name(), 1);

		parser.getInputStack().push(token);

		assertEquals(parser.getInputStack().peek(), token);
		assertTrue(parser.getHoldStack().empty());
		assertTrue(parser.getStateStack().empty());

		state.shiftSemiColon();

		assertTrue(parser.getInputStack().empty());
		assertFalse(parser.getHoldStack().empty());
		assertFalse(parser.getStateStack().empty());

		assertEquals(parser.getHoldStack().peek(), token);
		assertEquals(parser.getStateStack().peek(), state);
		assertTrue(parser.getCurrentState() instanceof CILS_27);
	}
}
