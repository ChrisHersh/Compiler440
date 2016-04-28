package parser.states.CILS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_15;
import parser.states.CILS.CILS_19;
import parser.states.CILS.CILS_20;
import parser.states.CILS.CILS_25;
import parser.states.CILS.CILS_26;
import parser.states.CILS.CILS_27;
import parser.states.CILS.CILS_5;
import parser.states.CILS.CILS_9;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test all of the state shifts for CILS_27.
 * @author Chad Nunemaker
 */
public class TestCILS_27
{
	/**
	 * Initialize the Parser
	 */
	@Before
	public void setUp()
	{
		Parser.resetParser();
	}

	/**
	 * Make sure it reduces correctly handling invalid state transitions.
	 * @throws ParserException a parsing error has occured
	 */
	@Test
	public void testInvalidState() throws ParserException
	{
		Parser parser = Parser.getInstance();
		State state = new CILS_27();
		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token("id", TokenTypes.Id.name(), 1));
		tokens.add(new Token("[", TokenTypes.LBrace.name(), 1));
		tokens.add(new Token("EXP1", TokenTypes.EXP1.name(), 1));
		tokens.add(new Token("]", TokenTypes.RBrace.name(), 1));
		tokens.add(new Token("=", TokenTypes.Assignment.name(), 1));
		tokens.add(new Token("EXP1", TokenTypes.EXP1.name(), 1));
		tokens.add(new Token(";", TokenTypes.SemiColon.name(), 1));

		parser.pushHoldStack(tokens.get(6));
		parser.pushHoldStack(tokens.get(5));
		parser.pushHoldStack(tokens.get(4));
		parser.pushHoldStack(tokens.get(3));
		parser.pushHoldStack(tokens.get(2));
		parser.pushHoldStack(tokens.get(1));
		parser.pushHoldStack(tokens.get(0));

		parser.pushStateStack(new CILS_5());
		parser.pushStateStack(new CILS_9());
		parser.pushStateStack(new CILS_15());
		parser.pushStateStack(new CILS_19());
		parser.pushStateStack(new CILS_20());
		parser.pushStateStack(new CILS_25());
		parser.pushStateStack(new CILS_26());

		state.invalidState();

		assertFalse(parser.getInputStack().empty());
		assertTrue(parser.getHoldStack().empty());
		assertTrue(parser.getStateStack().empty());
		Token token = new Token(TokenTypes.STMT, tokens);
		assertEquals(parser.peekInputStack().getLineNumber(), token.getLineNumber());
		assertEquals(parser.peekInputStack().getToken(), token.getToken());
		assertEquals(parser.peekInputStack().getTokenName(), token.getTokenName());
		assertEquals(parser.peekInputStack().getChildren(), token.getChildren());
		assertEquals(parser.getCurrentState().getClass(), new CILS_5().getClass());
	}
}
