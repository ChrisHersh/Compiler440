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
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test all of the state shifts for CILS_4
 * @author Raistlin Hess
 *
 */
public class TestCILS_4 
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
	 * It should shift to CILS_2
	 */
	@Test
	public void testInvalidState() throws ParserException
	{
		Parser parser = Parser.getInstance();
		State state = new CILS_4();
		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens.add(new Token("{", TokenTypes.LBrace.name(),1));
		tokens.add(new Token("STMT_P", TokenTypes.STMT_P.name(),1));
		tokens.add(new Token("}", TokenTypes.RBrace.name(),1));

		
		parser.pushHoldStack(tokens.get(2));
		parser.pushHoldStack(tokens.get(1));
		parser.pushHoldStack(tokens.get(0));
		
		parser.pushStateStack(new CILS_2());
		parser.pushStateStack(new CILS_6());
		parser.pushStateStack(new CILS_5());
		
		parser.changeState(new CILS_4());
		
		state.invalidState();
		
		assertFalse(parser.getInputStack().empty());
		assertTrue(parser.getHoldStack().empty());
		assertTrue(parser.getStateStack().empty());
		Token token = new Token(TokenTypes.STMT, tokens);
		assertEquals(parser.peekInputStack().getLineNumber(), token.getLineNumber());
		assertEquals(parser.peekInputStack().getToken(), token.getToken());
		assertEquals(parser.peekInputStack().getTokenName(), token.getTokenName());
		assertEquals(parser.peekInputStack().getChildren(), token.getChildren());
		assertEquals(parser.getCurrentState().getClass(), new CILS_2().getClass());
	}
}
