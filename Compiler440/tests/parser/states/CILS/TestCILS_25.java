package parser.states.CILS;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_25;
import parser.states.CILS.CILS_26;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Chad Nunemaker
 */
public class TestCILS_25
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
	 * Test the parsing of EXP1.
	 * @throws ParserException
	 */
	@Test
	public void testEXP1() throws ParserException
	{
		Parser parser = Parser.getInstance();
		State state = new CILS_25();
		Token token = new Token("EXP1", TokenTypes.EXP1.name(), 1);

		parser.getInputStack().push(token);

		assertEquals(parser.getInputStack().peek(), token);
		assertTrue(parser.getHoldStack().empty());
		assertTrue(parser.getStateStack().empty());

		state.shiftEXP1();

		assertTrue(parser.getInputStack().empty());
		assertFalse(parser.getHoldStack().empty());
		assertFalse(parser.getStateStack().empty());

		assertEquals(parser.getHoldStack().peek(), token);
		assertEquals(parser.getStateStack().peek(), state);
		assertTrue(parser.getCurrentState() instanceof CILS_26);
	}
}
