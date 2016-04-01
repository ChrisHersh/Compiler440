package parser.states;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Test that the reduce state work correctly
 * @author Shannon Lee
 *
 */
public class TestMDJ_32 {

	/**
	 * Initialize the parser
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
	
    @Test
	public void testReduce() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new MDJ_32();
	    
	    ArrayList<Token> tokens = new ArrayList<Token>();
	   
	    /*
	     * the tokens in CLASS_DECL
	     */
	    tokens.add(new Token("}","RT_BRACKET",5));
	    tokens.add(new Token("METH_DECL_L","METH_DECL_L",5));
	    tokens.add(new Token("VAR_DECL_L","VAR_DECL_L",5));
	    tokens.add(new Token("{","LT_BRACKET",5));
	    tokens.add(new Token("id","ID",5));
	    tokens.add(new Token("extends","EXTENDS",5));
	    tokens.add(new Token("id","ID",5));
	    tokens.add(new Token("class","CLASS",5));
	    
	    /*
	     * pushes the token in stack order
	     */
	    p.pushHoldStack(tokens.get(7)); 
	    p.pushHoldStack(tokens.get(6)); 
	    p.pushHoldStack(tokens.get(5));
	    p.pushHoldStack(tokens.get(4)); 
	    p.pushHoldStack(tokens.get(3));
	    p.pushHoldStack(tokens.get(2)); 
	    p.pushHoldStack(tokens.get(1));
	    p.pushHoldStack(tokens.get(0)); 
	    
	    /*
	     * Pushes the states in stack order
	     */
	    p.pushStateStack(new MDJ_3());
	    p.pushStateStack(new MDJ_21());
	    p.pushStateStack(new MDJ_22());
	    p.pushStateStack(new MDJ_23());
	    p.pushStateStack(new MDJ_25());
	    p.pushStateStack(new MDJ_27());
	    p.pushStateStack(new MDJ_29());
	    p.pushStateStack(new MDJ_31());
	    
	    /*
	     * the invalid state for reduce
	     */
	    s.shiftVAR_DECL();
	    
	    /*
	     * test that the stacks are appropriately filled
	     */
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());

	    Token t = new Token(TokenTypes.CLASS_DECL, tokens);
	    /*
	     * check the tokens in stack are correct and the states are correct
	     */
	    assertEquals(p.peekInputStack().getLineNumber(), t.getLineNumber());
	    assertEquals(p.peekInputStack().getToken(), t.getToken());
	    assertEquals(p.peekInputStack().getTokenName(), t.getTokenName());
	    assertEquals(p.peekInputStack().getChildren(), t.getChildren());
	    assertEquals(p.getCurrentState().getClass(), new MDJ_3().getClass());
	}
}
