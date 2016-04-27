package parser.states.JMCC;

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
 * Test reduce works for JMCC_28
 * @author Daniel Breitigan, Ian Keefer
 *
 */
public class TestJMCC_28
{
    /**
     * Reset the parser
     */
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
    //Make sure the class properly reduces
    @Test
    public void testReduce() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_19();
        
        //If it sees anything other than NotEquals, Equals, or OP3 it should reduce
        
        ArrayList<Token> tokens = new ArrayList<Token>();
        //the tokens that should be found to make a MAIN_CLASS token
        tokens.add(new Token("EXP4","EXP7",5));
        tokens.add(new Token("OP3","OP6",5));
        tokens.add(new Token("EXP3","EXP6",5));
        //Push Tokens to Hold Stack
        p.pushHoldStack(tokens.get(2)); 
        p.pushHoldStack(tokens.get(1));
        p.pushHoldStack(tokens.get(0));
        //push the states that stateStack in the order that they are expected to be found in
        p.pushStateStack(new JMCC_23());
        p.pushStateStack(new JMCC_24());
        p.pushStateStack(new JMCC_27());
        //try to handle "bad" token to start the reduce
        s.shiftVAR_DECL();
        //test that the stacks are appropriately filled
        assertFalse(p.getInputStack().empty());
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        Token testee = new Token(TokenTypes.EXP3, tokens);
        //test that the new token is correct and stacks correctly
        assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
        assertEquals(p.peekInputStack().getToken(), testee.getToken());
        assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
        assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
        assertEquals(p.getCurrentState().getClass(), new JMCC_23().getClass());
    }
}
