package parser.states.JMCC;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_16;
import parser.states.JMCC.JMCC_17;
import parser.states.JMCC.JMCC_3;
import parser.states.JMCC.JMCC_30;
import parser.states.JMCC.JMCC_4;
import parser.states.JMCC.JMCC_5;
import parser.states.JMCC.JMCC_6;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Tests for JMCC_6
 * @author Chris Hersh & Daniel Breitigan
 *
 */
public class TestJMCC_6
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
     * Ensure that State JMCC_6 properly reduces to state JMCC_3 when it is supposed to
     * @throws ParserException
     */
    @Test
    public void testReduce() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_6();
        
        //If it sees anything other than NotEquals, Equals, or OP3 it should reduce
        
        ArrayList<Token> tokens = new ArrayList<Token>();
        //the tokens that should be found to make a MAIN_CLASS token
        tokens.add(new Token("EXP3","EXP3",5));
        tokens.add(new Token("OP2","OP2",5));
        tokens.add(new Token("EXP2","EXP2",5));
        //Push Tokens to Hold Stack
        p.pushHoldStack(tokens.get(2)); 
        p.pushHoldStack(tokens.get(1));
        p.pushHoldStack(tokens.get(0));
        //push the states that stateStack in the order that they are expected to be found in
        p.pushStateStack(new JMCC_3());
        p.pushStateStack(new JMCC_4());
        p.pushStateStack(new JMCC_5());
        //try to handle "bad" token to start the reduce
        s.shiftVAR_DECL();
        //test that the stacks are appropriately filled
        assertFalse(p.getInputStack().empty());
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        Token testee = new Token(TokenTypes.EXP2, tokens);
        //test that the new token is correct and stacks correctly
        assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
        assertEquals(p.peekInputStack().getToken(), testee.getToken());
        assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
        assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
        assertEquals(p.getCurrentState().getClass(), new JMCC_3().getClass());
    }
    
    /**
     * Make sure != works
     * @throws ParserException
     */
    @Test
    public void testShiftNotEquals() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_6();
        
        Token inpToken = new Token("||", TokenTypes.NotEquals.name(), 6);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        //Make the current state the one we're testing
        p.changeState(s);
        
        p.nextState();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JMCC_17);
    }
    
    /**
     * Make sure == works
     * @throws ParserException
     */
    @Test
    public void testShiftEquals() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_6();
        
        Token inpToken = new Token("||", TokenTypes.Equals.name(), 6);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        //Make the current state the one we're testing
        p.changeState(s);
        
        p.nextState();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JMCC_16);
    }
    
    /**
     * Make sure OP3 works
     * @throws ParserException
     */
    @Test
    public void testShiftOP3() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_6();
        
        Token inpToken = new Token("||", TokenTypes.OP3.name(), 6);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        //Make the current state the one we're testing
        p.changeState(s);
        
        p.nextState();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JMCC_30);
    }
    
    /**
     * Make sure the reduce works
     * @throws ParserException
     */
    @Test
    public void testInvalidState() throws ParserException
    {
        Parser parser = Parser.getInstance();
        State state = new JMCC_6();
        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(new Token("id", TokenTypes.EXP2.name(), 1));
        tokens.add(new Token("id", TokenTypes.OP2.name(), 1));
        tokens.add(new Token("id", TokenTypes.EXP3.name(), 1));

        parser.pushHoldStack(tokens.get(2));
        parser.pushHoldStack(tokens.get(1));
        parser.pushHoldStack(tokens.get(0));

        parser.pushStateStack(new JMCC_3());
        parser.pushStateStack(new JMCC_4());
        parser.pushStateStack(new JMCC_5());

        state.invalidState();

        assertFalse(parser.getInputStack().empty());
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        Token token = new Token(TokenTypes.EXP2, tokens);
        assertEquals(parser.peekInputStack().getLineNumber(), token.getLineNumber());
        assertEquals(parser.peekInputStack().getToken(), token.getToken());
        assertEquals(parser.peekInputStack().getTokenName(), token.getTokenName());
        assertEquals(parser.peekInputStack().getChildren(), token.getChildren());
        assertEquals(parser.getCurrentState().getClass(), new JMCC_3().getClass());
    }

}
