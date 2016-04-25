package parser.states.JCTM;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_15;
import parser.states.JMCC.JMCC_2;
import parser.states.JMCC.JMCC_3;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Makes sure State JCTM_28 works
 * @author Chris Hersh
 *
 */
public class TestJCTM_28 
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
     * Make sure OP1 works
     * @throws ParserException
     */
    @Test
    public void testShiftOP1() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_28();
        
        Token inpToken = new Token("op3", TokenTypes.OP1.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_3);
    }
    
    /**
     * Make sure || works
     * @throws ParserException
     */
    @Test
    public void testShiftOr() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_28();
        
        Token inpToken = new Token("!=", TokenTypes.Or.name(), 6);
        
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
        
        assertTrue(p.getCurrentState() instanceof JMCC_2);
    }
    
    /**
     * Make sure the reduce works
     * @throws ParserException
     */
    @Test
    public void testInvalidState() throws ParserException
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_28();
        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(new Token("id", TokenTypes.EXP1.name(), 1));
        tokens.add(new Token("id", TokenTypes.Not.name(), 1));

        parser.pushHoldStack(tokens.get(1));
        parser.pushHoldStack(tokens.get(0));

        parser.pushStateStack(new JCTM_0());
        parser.pushStateStack(new JCTM_27());

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
