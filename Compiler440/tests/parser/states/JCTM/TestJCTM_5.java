package parser.states.JCTM;

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
 * Test JCTM_5
 * @author Daniel Breitigan
 *
 */
public class TestJCTM_5
{

    //Reset Parser before test
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
        State state = new JCTM_5();
        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(new Token("id", TokenTypes.RBracket.name(), 1));
        tokens.add(new Token("id", TokenTypes.EXP1.name(), 1));
        tokens.add(new Token("id", TokenTypes.LBracket.name(), 1));
        tokens.add(new Token("id", TokenTypes.Id.name(), 1));

        parser.pushHoldStack(tokens.get(3));
        parser.pushHoldStack(tokens.get(2));
        parser.pushHoldStack(tokens.get(1));
        parser.pushHoldStack(tokens.get(0));

        parser.pushStateStack(new JCTM_0());
        parser.pushStateStack(new JCTM_1());
        parser.pushStateStack(new JCTM_2());
        parser.pushStateStack(new JCTM_4());

        state.invalidState();

        assertFalse(parser.getInputStack().empty());
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        Token token = new Token(TokenTypes.EXP7, tokens);
        assertEquals(parser.peekInputStack().getLineNumber(), token.getLineNumber());
        assertEquals(parser.peekInputStack().getToken(), token.getToken());
        assertEquals(parser.peekInputStack().getTokenName(), token.getTokenName());
        assertEquals(parser.peekInputStack().getChildren(), token.getChildren());
        assertEquals(parser.getCurrentState().getClass(), new JCTM_0().getClass());
    }
}
