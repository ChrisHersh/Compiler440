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
public class TestJCTM_12 {

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
        State s = new JCTM_12();
        
        //If it sees anything other than NotEquals, Equals, or OP3 it should reduce
        
        ArrayList<Token> tokens = new ArrayList<Token>();
        //the tokens that should be found to make a MAIN_CLASS token
        tokens.add(new Token("EXP1","EXP1",5));
        tokens.add(new Token("EXP_R","EXP_R",5));
        //Push Tokens to Hold Stack
        p.pushHoldStack(tokens.get(1));
        p.pushHoldStack(tokens.get(0));
        //push the states that stateStack in the order that they are expected to be found in
        p.pushStateStack(new JCTM_8());
        p.pushStateStack(new JCTM_11());
        //try to handle "bad" token to start the reduce
        s.shiftEXP_R();
        //test that the stacks are appropriately filled
        assertFalse(p.getInputStack().empty());
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        Token testee = new Token(TokenTypes.EXP_L, tokens);
        //test that the new token is correct and stacks correctly
        assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
        assertEquals(p.peekInputStack().getToken(), testee.getToken());
        assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
        assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
        assertEquals(p.getCurrentState().getClass(), new JCTM_8().getClass());
    }

}
