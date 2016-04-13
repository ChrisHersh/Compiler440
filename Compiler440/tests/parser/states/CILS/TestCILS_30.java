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
import parser.states.CILS.CILS_12;
import parser.states.CILS.CILS_16;
import parser.states.CILS.CILS_23;
import parser.states.CILS.CILS_28;
import parser.states.CILS.CILS_29;
import parser.states.CILS.CILS_30;
import parser.states.CILS.CILS_5;
import parser.states.CILS.CILS_7;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test all of the state shifts for CILS_30
 * @author Raistlin Hess
 *
 */
public class TestCILS_30
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
	 * It should shift to CILS_5
	 */
	@Test
	public void testInvalidState() throws ParserException
	{
		Parser parser = Parser.getInstance();
		State state = new CILS_30();
		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token("if", TokenTypes.If.name(),1));
		tokens.add(new Token("(", TokenTypes.LPara.name(),1));
		tokens.add(new Token("EXP1", TokenTypes.EXP1.name(),1));
		tokens.add(new Token(")", TokenTypes.RPara.name(),1));
		tokens.add(new Token("STMT", TokenTypes.STMT.name(),1));
		tokens.add(new Token("else", TokenTypes.Else.name(),1));
		tokens.add(new Token("STMT", TokenTypes.STMT.name(),1));
		
		parser.pushHoldStack(tokens.get(6));
		parser.pushHoldStack(tokens.get(5));
		parser.pushHoldStack(tokens.get(4));
		parser.pushHoldStack(tokens.get(3));
		parser.pushHoldStack(tokens.get(2));
		parser.pushHoldStack(tokens.get(1));
		parser.pushHoldStack(tokens.get(0));
		
		parser.pushStateStack(new CILS_5());
		parser.pushStateStack(new CILS_7());
		parser.pushStateStack(new CILS_12());
		parser.pushStateStack(new CILS_16());
		parser.pushStateStack(new CILS_23());
		parser.pushStateStack(new CILS_28());
		parser.pushStateStack(new CILS_29());
		parser.pushStateStack(new CILS_30());
		
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
