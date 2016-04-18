package parser.states.JMCC;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_10;
import parser.states.JMCC.JMCC_9;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Chris Hersh
 *
 */
public class TestJMCC_10
{
	/**
	 * Reset the parser
	 */
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
    /**
     * Make sure the reduce works
     * @throws ParserException
     */
    @Test
    public void testInvalidState() throws ParserException
    {
        Parser parser = Parser.getInstance();
        State state = new JMCC_10();
        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(new Token("id", TokenTypes.And.name(), 1));

        parser.pushHoldStack(tokens.get(0));

        parser.pushStateStack(new JMCC_9());

        state.invalidState();

        assertFalse(parser.getInputStack().empty());
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        Token token = new Token(TokenTypes.OP2, tokens);
        assertEquals(parser.peekInputStack().getLineNumber(), token.getLineNumber());
        assertEquals(parser.peekInputStack().getToken(), token.getToken());
        assertEquals(parser.peekInputStack().getTokenName(), token.getTokenName());
        assertEquals(parser.peekInputStack().getChildren(), token.getChildren());
        assertEquals(parser.getCurrentState().getClass(), new JMCC_9().getClass());
    }
}
