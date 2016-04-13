package parser.states.CILS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_18;
import parser.states.CILS.CILS_21;
import parser.states.CILS.CILS_9;
import parser.states.JMCC.JMCC_2;
import tokenizer.Token;

/**
 * Test class to check the methods of the CILS_18 class.
 * @author Manal Ibrahim
 *
 */
public class TestCILS_18 {
	
	/**
	 * Setup parser for CILS_18
	 */
    @Before
    public void setUp() 
    {
        Parser.resetParser();
    }
    
    /**
     * Tests shifting to CILS_21 when [ is received. 
     * @author Manal Ibrahim
     * @throws ParserException
     */
    @Test
	public void testShiftSemiColon() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CILS_18();
	        
	    Token token = new Token(";", "SemiColon", 2);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftSemiColon();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CILS_21);
	}
    
    /**
     * Tests shifting to CILS_14 when || is received. 
     * @author Manal Ibrahim
     * @throws ParserException
     */
    @Test
	public void testshiftOP1() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CILS_9();
	        
	    Token token = new Token("||", "||", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftOP1();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JMCC_2);
	}
	
}
