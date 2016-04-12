package parser.states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test class to check the methods of the CILS_18 class.
 * @author Manal Ibrahim
 *
 */
public class TestCILS_21 {
	
	/**
	 * Setup parser for CILS_18
	 */
    @Before
    public void setUp() 
    {
        Parser.resetParser();
    }
    
    /**
     * Tests reduce to CILS_21 when ; is received. 
     * @author Manal Ibrahim
     * @throws ParserException
     */
	@Test
	public void testReduce() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CILS_21();
	    
	    ArrayList<Token> tokens = new ArrayList<Token>();
	    //the tokens that should be found to make a MAIN_CLASS token
	    tokens.add(new Token("id","Id",5));
	    tokens.add(new Token("=","Assignment",5));
	    tokens.add(new Token("EXP1","EXP1",5));
	    tokens.add(new Token(";","SemiColon",5));
	   
	    //push the tokens on the holdStack in the order that they are expected to be found in
	    p.pushHoldStack(tokens.get(3));
	    p.pushHoldStack(tokens.get(2)); 
	    p.pushHoldStack(tokens.get(1));
	    p.pushHoldStack(tokens.get(0)); 
	    //push the states that stateStack in the order that they are expected to be found in
	    p.pushStateStack(new CILS_5());
	    p.pushStateStack(new CILS_9());
	    p.pushStateStack(new CILS_14());
	    p.pushStateStack(new CILS_18());
	   
	    s.invalidState();
	    
	    //test that the stacks are appropriately filled
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	
	    Token testee = new Token(TokenTypes.SemiColon, tokens);
	    //test that the new token is correct and stacks correctly
	    assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
	    assertEquals(p.peekInputStack().getToken(), testee.getToken());
	    assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
	    assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
	    assertEquals(p.getCurrentState().getClass(), new CILS_5().getClass());
	}
}
