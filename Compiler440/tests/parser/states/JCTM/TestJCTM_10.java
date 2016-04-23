package parser.states.JCTM;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * 
 * @author Matt Mousetis
 */

public class TestJCTM_10 {

    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
	//Tests the reduce in JCTM_10
    @Test
    public void testReduce() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_10();
        
        //If it sees anything other than NotEquals, Equals, or OP3 it should reduce
        
        ArrayList<Token> tokens = new ArrayList<Token>();
        //the tokens that should be found to make a MAIN_CLASS token
        tokens.add(new Token("id","ID",5));
        tokens.add(new Token("id","ID",5));
        tokens.add(new Token("EXP_L","EXP_L",5));
        tokens.add(new Token("RPara",")",5));
        //Push Tokens to Hold Stack
        p.pushHoldStack(tokens.get(3)); 
        p.pushHoldStack(tokens.get(2)); 
        p.pushHoldStack(tokens.get(1));
        p.pushHoldStack(tokens.get(0));
        //push the states that stateStack in the order that they are expected to be found in
        p.pushStateStack(new JCTM_0());
        p.pushStateStack(new JCTM_1());
        p.pushStateStack(new JCTM_8());
        p.pushStateStack(new JCTM_9());
        //try to handle "bad" token to start the reduce
        s.shiftLeftBrace();
        //test that the stacks are appropriately filled
        assertFalse(p.getInputStack().empty());
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        Token testee = new Token(TokenTypes.EXP7, tokens);
        //test that the new token is correct and stacks correctly
        assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
        assertEquals(p.peekInputStack().getToken(), testee.getToken());
        assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
        assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
        assertEquals(p.getCurrentState().getClass(), new JCTM_0().getClass());
    }

}
