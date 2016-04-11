package parser.states;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test class to check the methods of the CRM_9 class.
 * @author Jason LoBianco
 */
public class TestCRM_9 
{
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }

	/**
	 * changes to state CRM_10
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	@Test
	public void testShiftLeftBracket() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_9();
	        
	    Token token = new Token("[", "LeftBracket", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftLeftBracket();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_10);
	}

	/**
	 * Checks to see that reduce work correctly
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	@Test
	public void testReduce() throws ParserException
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_9();
	    
	    ArrayList<Token> tokens = new ArrayList<Token>();
	    tokens.add(new Token("int","INT",6));
	    p.pushHoldStack(tokens.get(0));    
	    p.pushStateStack(new CRM_2());
	    
	    s.shiftVAR_DECL();
	    
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    Token testee = new Token(TokenTypes.TYPE, tokens);
	    assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
	    assertEquals(p.peekInputStack().getToken(), testee.getToken());
	    assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
	    assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
	    assertEquals(p.getCurrentState().getClass(), new CRM_2().getClass());
	}
}
