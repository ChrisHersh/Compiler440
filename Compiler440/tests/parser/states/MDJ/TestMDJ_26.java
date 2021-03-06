package parser.states.MDJ;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.MDJ.MDJ_17;
import parser.states.MDJ.MDJ_18;
import parser.states.MDJ.MDJ_20;
import parser.states.MDJ.MDJ_22;
import parser.states.MDJ.MDJ_24;
import parser.states.MDJ.MDJ_26;
import parser.states.MDJ.MDJ_3;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test all of the state shifts for MDJ_26
 * @author Raistlin Hess
 *
 */
public class TestMDJ_26
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
	 * Make sure handles reduction correctly.
	 * It should shift to MDJ_3
	 */
	@Test
	public void testInvalidState() throws ParserException
	{
		Parser parser = Parser.getInstance();
		State state = new MDJ_26();
		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token("class", TokenTypes.Class.name(),1));
		tokens.add(new Token("iAmVariable", TokenTypes.Id.name(),1));
		tokens.add(new Token("{", TokenTypes.LBrace.name(),1));
		tokens.add(new Token("VAR_DECL_L", TokenTypes.VAR_DECL_L.name(),1));
		tokens.add(new Token("METH_DECL_L", TokenTypes.METH_DECL_L.name(),1));
		tokens.add(new Token("}", TokenTypes.RBrace.name(),1));

		parser.pushHoldStack(tokens.get(5));
		parser.pushHoldStack(tokens.get(4));
		parser.pushHoldStack(tokens.get(3));
		parser.pushHoldStack(tokens.get(2));
		parser.pushHoldStack(tokens.get(1));
		parser.pushHoldStack(tokens.get(0));
		
		parser.pushStateStack(new MDJ_3());
		parser.pushStateStack(new MDJ_17());
		parser.pushStateStack(new MDJ_18());
		parser.pushStateStack(new MDJ_20());
		parser.pushStateStack(new MDJ_22());
		parser.pushStateStack(new MDJ_24());
		
		state.invalidState();
		
		assertFalse(parser.getInputStack().empty());
		assertTrue(parser.getHoldStack().empty());
		assertTrue(parser.getStateStack().empty());
		Token token = new Token(TokenTypes.CLASS_DECL, tokens);
		assertEquals(parser.peekInputStack().getLineNumber(), token.getLineNumber());
		assertEquals(parser.peekInputStack().getToken(), token.getToken());
		assertEquals(parser.peekInputStack().getTokenName(), token.getTokenName());
		assertEquals(parser.peekInputStack().getChildren(), token.getChildren());
		assertEquals(parser.getCurrentState().getClass(), new MDJ_3().getClass());
	}
}
