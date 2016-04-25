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
 * Test JCTM_1 Class
 * @author Daniel Breitigan
 *
 */
public class TestJCTM_1
{

    //Reset parser before test
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
    //Test shift at Period
    @Test
    public void testPeriod() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_1();
        
        Token token = new Token("Period", "Period", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftPeriod();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_3);
        
    }
    
  //Test shift at LeftBrace
    @Test
    public void testLeftBrace() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_1();
        
        Token token = new Token("LBrace", "LBrace", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftLeftBrace();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_2);
        
    }
    
  //Test Reduce
    @Test
    public void testReduce() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_1();
        
        //If it sees anything other than NotEquals, Equals, or OP3 it should reduce
        
        ArrayList<Token> tokens = new ArrayList<Token>();
        //the tokens that should be found to make a MAIN_CLASS token
        tokens.add(new Token("Id","Id",5));
        //Push Tokens to Hold Stack
        p.pushHoldStack(tokens.get(0));
        //push the states that stateStack in the order that they are expected to be found in
        p.pushStateStack(new JCTM_0());
        //try to handle "bad" token to start the reduce
        s.shiftTrue();
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
