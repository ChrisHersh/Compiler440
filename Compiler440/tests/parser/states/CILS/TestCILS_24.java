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
import parser.states.CILS.CILS_13;
import parser.states.CILS.CILS_17;
import parser.states.CILS.CILS_2;
import parser.states.CILS.CILS_22;
import parser.states.CILS.CILS_24;
import parser.states.CILS.CILS_8;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test class to check the methods of the CILS_24 class.
 *
 */
public class TestCILS_24 {
    @Before
    public void setUp() {
        Parser.resetParser();
    }
    

    /**
     * @author Corey Peregord 
     * Tests reduce to CILS_2
     * @throws ParserException
     */
    @Test
	public void testReduce() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CILS_24();
	    
	    ArrayList<Token> tokens = new ArrayList<Token>();
	    //the tokens that should be found to make a MAIN_CLASS token
	    tokens.add(new Token(";","SemiColon",5));
	    tokens.add(new Token(")","RPARA",5));
	    tokens.add(new Token("EXP1","EXP1",5));
	    tokens.add(new Token("(","LPARA",5));
	    tokens.add(new Token("System.out.println","SystemOutPrintln",5));
	    //push the tokens on the holdStack in the order that they are expected to be found in
	    p.pushHoldStack(tokens.get(4)); 
	    p.pushHoldStack(tokens.get(3));
	    p.pushHoldStack(tokens.get(2)); 
	    p.pushHoldStack(tokens.get(1));
	    p.pushHoldStack(tokens.get(0)); 
	    //push the states that stateStack in the order that they are expected to be found in
	    p.pushStateStack(new CILS_2());
	    p.pushStateStack(new CILS_8());
	    p.pushStateStack(new CILS_13());
	    p.pushStateStack(new CILS_17());
	    p.pushStateStack(new CILS_22());
	   
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
	    assertEquals(p.getCurrentState().getClass(), new CILS_2().getClass());
	}
}
