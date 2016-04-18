package parser.states.CILS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_3;
import tokenizer.Token;

/**
 * Test class to check the methods of the CILS_2 class.
 * @author Jessica Schlesiger
 *
 */
public class TestCILS_3 
{
    @Before
    public void setUp() 
    {
        Parser.resetParser();
    }
    
    /**
     * Tests reducing this state.
     * @author Jessica Schlesiger
     * @throws ParserException
     */
    @Test
	public void testInvaildState() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CILS_3();
	        
	    Token token = new Token(";", "Semi", 25);
	    
	    p.getInputStack().push(token);
	    p.changeState(s);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.invalidState();
	    
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    assertTrue(p.getCurrentState() instanceof CILS_3);
	}
}
