package parser.states.CILS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_10;
import parser.states.CILS.CILS_11;
import parser.states.CILS.CILS_15;
import parser.states.CILS.CILS_31;
import parser.states.CILS.CILS_32;
import parser.states.CILS.CILS_5;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test the reduce for CILS_32
 * @author Mohammed
 *
 */
public class TestCILS_32
{
	/**
	 * Initialize the Parser
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }

	/**
	 * Make sure handles reduction correctly.
	 * It should shift to CILS_5
	 */
	@Test
	public void testReduce() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CILS_32();
	    
	    ArrayList<Token> tokens = new ArrayList<Token>();
	    //the tokens that should be found to make a MAIN_CLASS token
	    tokens.add(new Token("STMT","STMT",5));
	    tokens.add(new Token(")","LPARA",5));
	    tokens.add(new Token("EXP1","EXP1",5));
	    tokens.add(new Token("(","LPARA",5));
	    tokens.add(new Token("While","While",5));
	   
	    //push the tokens on the holdStack in the order that they are expected to be found in
	    p.pushHoldStack(tokens.get(4)); 
	    p.pushHoldStack(tokens.get(3));
	    p.pushHoldStack(tokens.get(2)); 
	    p.pushHoldStack(tokens.get(1));
	    p.pushHoldStack(tokens.get(0)); 
	    //push the states that stateStack in the order that they are expected to be found in
	    p.pushStateStack(new CILS_5());
	    p.pushStateStack(new CILS_10());
	    p.pushStateStack(new CILS_11());
	    p.pushStateStack(new CILS_15());
	    p.pushStateStack(new CILS_31());
	   
	    s.invalidState();
	    
	    //test that the stacks are appropriately filled
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	
	    Token testee = new Token(TokenTypes.STMT, tokens);
	    //test that the new token is correct and stacks correctly
	    assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
	    assertEquals(p.peekInputStack().getToken(), testee.getToken());
	    assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
	    assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
	    assertEquals(p.getCurrentState().getClass(), new CILS_5().getClass());
	}
}
