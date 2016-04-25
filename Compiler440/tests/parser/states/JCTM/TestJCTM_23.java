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

public class TestJCTM_23 {
	
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
    @Test
    public void testInvalidState() throws ParserException
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_23();
        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(new Token("id", TokenTypes.New.name(), 1));
        tokens.add(new Token("id", TokenTypes.Int.name(), 1));
        tokens.add(new Token("id", TokenTypes.LBracket.name(), 1));
        tokens.add(new Token("id", TokenTypes.EXP1.name(), 1));
        tokens.add(new Token("id", TokenTypes.RBrace.name(), 1));

        parser.pushHoldStack(tokens.get(4));
        parser.pushHoldStack(tokens.get(3));
        parser.pushHoldStack(tokens.get(2));
        parser.pushHoldStack(tokens.get(1));
        parser.pushHoldStack(tokens.get(0));

        parser.pushStateStack(new JCTM_0());
        parser.pushStateStack(new JCTM_19());
        parser.pushStateStack(new JCTM_20());
        parser.pushStateStack(new JCTM_21());
        parser.pushStateStack(new JCTM_22());

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
