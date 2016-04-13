package parser.states.JMCC;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_0;
import parser.states.JMCC.JMCC_20;
import parser.states.JMCC.JMCC_32;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class TestJMCC_32 {

	
	/**
	 * prepares the parser from former test
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
	/**
	 * Tests reduction of JMCC_32
	 * @throws ParserException
	 */
	@Test
	public void testReduceEXP5() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new JMCC_32();
	    
	    ArrayList<Token> tokens = new ArrayList<Token>();
	    //the tokens that should be found to make a MAIN_METHOD token
	    
	    tokens.add(new Token("exp6", "EXP6", 5));
	    
	    //push the tokens on the holdStack in the order that they are expected to be found in
	    p.pushHoldStack(tokens.get(0)); 
	    //push the states that stateStack in the order that they are expected to be found in
	    p.pushStateStack(new JMCC_0());

	    //try to handle "bad" token to start the reduce
	    s.shiftRightBrace();
	    
	    //test that the stacks are appropriately filled
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());

	    Token testee = new Token(TokenTypes.EXP5, tokens);
	    //test that the new token is correct and stacks correctly
	    assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
	    assertEquals(p.peekInputStack().getToken(), testee.getToken());
	    assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
	    assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
	    assertEquals(p.getCurrentState().getClass(), new JMCC_0().getClass());
	
	}
	
	/**
	 * Tests that JMCC_32 can shift with EXP5
	 * @throws ParserException
	 */
    @Test
    public void testShiftEXP5() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_32();
        
        Token inpToken = new Token("exp5", "EXP5", 42);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        s.shiftEXP5();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JMCC_20);
    }

}
