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
 * @author Michael Zimmerman
 *
 */
public class TestMDJ_16 {
	
	/**
	 * prepares the parser from former test
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
	/**
	 * tests the reduce from MDJ_16 to MDJ_7
     * @author Michael Zimmerman
     * @throws ParserException
     */
    @Test
	public void testReduce() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new MDJ_16();
	    
	    ArrayList<Token> tokens = new ArrayList<Token>();
	    //the tokens that should be found to make a MAIN_METHOD token
	    tokens.add(new Token("M_METH_BODY","M_METH_BODY",5));
	    tokens.add(new Token(")","RPARA",5));
	    tokens.add(new Token("(","LPARA",5));
	    tokens.add(new Token("main","MAIN",5));
	    tokens.add(new Token("void","VOID",5));
	    tokens.add(new Token("static","STATIC",5));
	    tokens.add(new Token("public","PUBLIC",5));
	    //push the tokens on the holdStack in the order that they are expected to be found in
	    p.pushHoldStack(tokens.get(6)); 
	    p.pushHoldStack(tokens.get(5));
	    p.pushHoldStack(tokens.get(4)); 
	    p.pushHoldStack(tokens.get(3));
	    p.pushHoldStack(tokens.get(2)); 
	    p.pushHoldStack(tokens.get(1));
	    p.pushHoldStack(tokens.get(0)); 
	    //push the states that stateStack in the order that they are expected to be found in
	    p.pushStateStack(new MDJ_7());
	    p.pushStateStack(new MDJ_10());
	    p.pushStateStack(new MDJ_11());
	    p.pushStateStack(new MDJ_12());
	    p.pushStateStack(new MDJ_13());
	    p.pushStateStack(new MDJ_14());
	    p.pushStateStack(new MDJ_15());
	    //try to handle "bad" token to start the reduce
	    s.shiftVAR_DECL();
	    //test that the stacks are appropriately filled
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());

	    Token testee = new Token(TokenTypes.MAIN_METHOD, tokens);
	    //test that the new token is correct and stacks correctly
	    assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
	    assertEquals(p.peekInputStack().getToken(), testee.getToken());
	    assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
	    assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
	    assertEquals(p.getCurrentState().getClass(), new MDJ_7().getClass());
	}
}
