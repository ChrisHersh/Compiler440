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
import parser.states.JMCC.JMCC_11;
import parser.states.JMCC.JMCC_12;
import parser.states.JMCC.JMCC_13;
import parser.states.JMCC.JMCC_14;
import parser.states.JMCC.JMCC_19;
import parser.states.JMCC.JMCC_30;
import parser.states.JMCC.JMCC_31;
import parser.states.JMCC.JMCC_5;
import parser.states.JMCC.JMCC_6;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * A test class for JMCC_19. Ensures it always reduces/shifts to correct place
 * @author Daniel Breitigan
 *
 */

public class TestJMCC_19
{
    
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
        tokens.add(new Token("EXP4","EXP4",5));
        tokens.add(new Token("OP3","OP3",5));
        tokens.add(new Token("EXP3","EXP3",5));
        //Push Tokens to Hold Stack
        p.pushHoldStack(tokens.get(2)); 
        p.pushHoldStack(tokens.get(1));
        p.pushHoldStack(tokens.get(0));
        //push the states that stateStack in the order that they are expected to be found in
        p.pushStateStack(new JMCC_5());
        p.pushStateStack(new JMCC_6());
        p.pushStateStack(new JMCC_30());
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
        assertEquals(p.getCurrentState().getClass(), new JMCC_5().getClass());
    }
    
  //Ensure class properly shifts to the write state if it sees OP4
    @Test
    public void testShiftOP4() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_19();
        
        Token inpToken = new Token("OP4", TokenTypes.OP4.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_31);
    }
    
    //Ensure class properly shifts to the write state if it sees Gt
    @Test
    public void testShiftGt() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_19();
        
        Token inpToken = new Token(">", TokenTypes.Gt.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_11);
    }
    
  //Ensure class properly shifts to the write state if it sees Lt
    @Test
    public void testShiftLt() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_19();
        
        Token inpToken = new Token("<", TokenTypes.Lt.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_12);
    }
    
  //Ensure class properly shifts to the write state if it sees GtEquals
    @Test
    public void testShiftGtEquals() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_19();
        
        Token inpToken = new Token(">=", TokenTypes.GtEquals.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_13);
    }
    
  //Ensure class properly shifts to the write state if it sees LtEquals
    @Test
    public void testShiftLtEquals() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_19();
        
        Token inpToken = new Token("<=", TokenTypes.LtEquals.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_14);
    }
}
