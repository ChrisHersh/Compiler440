package parser.states.CRM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_0;
import parser.states.CRM.CRM_1;
import parser.states.CRM.CRM_2;
import parser.states.CRM.CRM_4;
import parser.states.CRM.CRM_5;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Test class to check the methods of the CRM_5 class.
 * @author TJ Renninger
 */
public class TestCRM_5
{
	/**
	 * checks to see that the reduce works correctly
     * @author TJ Renninger
     * @throws ParserException
     */
    @Test
	public void testReduce() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_5();
	    
	    ArrayList<Token> tokens = new ArrayList<Token>();
	    tokens.add(new Token("{", "LeftBrace", 6));
	    tokens.add(new Token("STMT_P", "STMT_P", 5));
	    tokens.add(new Token("VAR_DECL_L", "VAR_DEC_L", 6));
	    tokens.add(new Token("}", "RightBrace", 5));
	    p.pushHoldStack(tokens.get(3));
	    p.pushHoldStack(tokens.get(2));
	    p.pushHoldStack(tokens.get(1));
	    p.pushHoldStack(tokens.get(0));
    	
    	p.pushStateStack(new CRM_0());
    	p.pushStateStack(new CRM_1());
    	p.pushStateStack(new CRM_2());
    	p.pushStateStack(new CRM_4());
	    
	    s.shiftRightBrace();//shift of anything that is not given implementation
	    
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    Token testee = new Token(TokenTypes.M_METH_BODY, tokens);
	    assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
	    assertEquals(p.peekInputStack().getToken(), testee.getToken());
	    assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
	    assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
	    assertEquals(p.getCurrentState().getClass(), new CRM_0().getClass());
	}
}
