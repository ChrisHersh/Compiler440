package parser.states.MDJ;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.MDJ.MDJ_0;
import parser.states.MDJ.MDJ_5;
import parser.states.MDJ.MDJ_6;
import parser.states.MDJ.MDJ_7;
import parser.states.MDJ.MDJ_8;
import parser.states.MDJ.MDJ_9;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Michael Zimmerman
 *
 */
public class TestMDJ_9{
	
	/**
	 * prepares the parser from former test
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
	/**
	 * tests the reduce from MDJ_9 to MDJ_0
     * @author Michael Zimmerman
     * @throws ParserException
     */
    @Test
	public void testReduce() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new MDJ_9();
	    
	    ArrayList<Token> tokens = new ArrayList<Token>();
	    //the tokens that should be found to make a MAIN_CLASS token
	    tokens.add(new Token("}","RBRACE",5));
	    tokens.add(new Token("MAIN_METHOD","MAIN_METHOD",5));
	    tokens.add(new Token("{","LBRACE",5));
	    tokens.add(new Token("id","ID",5));
	    tokens.add(new Token("class","CLASS",5));
	    //push the tokens on the holdStack in the order that they are expected to be found in
	    p.pushHoldStack(tokens.get(4)); 
	    p.pushHoldStack(tokens.get(3));
	    p.pushHoldStack(tokens.get(2)); 
	    p.pushHoldStack(tokens.get(1));
	    p.pushHoldStack(tokens.get(0)); 
	    //push the states that stateStack in the order that they are expected to be found in
	    p.pushStateStack(new MDJ_0());
	    p.pushStateStack(new MDJ_5());
	    p.pushStateStack(new MDJ_6());
	    p.pushStateStack(new MDJ_7());
	    p.pushStateStack(new MDJ_8());
	    //try to handle "bad" token to start the reduce
	    s.shiftVAR_DECL();
	    //test that the stacks are appropriately filled
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	
	    Token testee = new Token(TokenTypes.MAIN_CLASS, tokens);
	    //test that the new token is correct and stacks correctly
	    assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
	    assertEquals(p.peekInputStack().getToken(), testee.getToken());
	    assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
	    assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
	    assertEquals(p.getCurrentState().getClass(), new MDJ_0().getClass());
	}
}