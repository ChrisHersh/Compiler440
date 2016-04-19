package parser.states.MDJ;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_1;
import parser.states.MDJ.MDJ_15;
import parser.states.MDJ.MDJ_16;
import tokenizer.Token;

/**
 * @author Michael Zimmerman
 *
 */
public class TestMDJ_15 
{
    /**
     * prepares the parser from former test
     */
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
    /**
     * @author Michael Zimmerman
     * @throws ParserException
     */
    @Test
	public void testShiftM_METH_BODY() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new MDJ_15();
	        
	    Token token = new Token("M_METH_BODY", "M_METH_BODY", 4);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftM_METH_BODY();
	   
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof MDJ_16);
	}

    /**
     * checks to see that shiftLeftBrace() works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftLeftBrace() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new MDJ_15();
	        
	    Token token = new Token("{", "L_BRACE", 4);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftLeftBrace();
	   
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_1);
	}
}
