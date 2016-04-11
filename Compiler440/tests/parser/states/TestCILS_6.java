package parser.states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;

/**
 * Test class to check the methods of the CILS_6 class.
 * @author Jessica Schlesiger
 *
 */
public class TestCILS_6 {
    @Before
    public void setUp() {
        Parser.resetParser();
    }
    
    /**
     * Tests shifting to CILS_5 when STMT_P is received. 
     * @author Jessica Schlesiger
     * @throws ParserException
     */
    @Test
	public void testShiftSTMP_P() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CILS_6();
	        
	    Token token = new Token("STMT_P", "STMT_P", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftSTMT_P();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CILS_5);
	}
    

}
