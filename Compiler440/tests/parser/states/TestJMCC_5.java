package parser.states;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import parser.Parser;
import tokenizer.Token;

/**
 * 
 * @author Chris Kjeldgaard
 *
 */
public class TestJMCC_5 
{
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
    @Test
	public void testShiftLeftBrace() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("{", "L_Brace", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftExclamation();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JCTM_27);
	}
    
    @Test
	public void testShiftExclamation() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("!", "Not", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftExclamation();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JCTM_27);
	}
    
    @Test
	public void testShiftNew() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new JMCC_5();
	        
	    Token token = new Token("new", "New", 5);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftNew();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JCTM_19);
	}
}
