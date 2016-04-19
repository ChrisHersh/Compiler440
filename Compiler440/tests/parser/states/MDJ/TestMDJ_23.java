package parser.states.MDJ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.MDJ.MDJ_23;
import parser.states.MDJ.MDJ_25;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class TestMDJ_23 {


	/**
	 * Initialize the parser
	 * @author Shannon Jones
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    } 
	
	/**
	 * test shift VAR_DECL_L
	 * @throws ParserException
	 */
	@Test
	public void testShiftVAR_DECL_L() throws ParserException 
	{
		 
			    Parser p = Parser.getInstance();
			    State s = new MDJ_23();
			        
			    Token token = new Token("VAR_DECL_L", TokenTypes.VAR_DECL_L.name(), 4);
			    
			    p.getInputStack().push(token);
			    
			    assertFalse(p.getInputStack().empty());
			    assertEquals(p.getInputStack().peek(), token);
			    assertTrue(p.getHoldStack().empty());
			    assertTrue(p.getStateStack().empty());
			    
			    s.shiftVAR_DECL_L();
			   
			    assertTrue(p.getInputStack().empty());
			    assertFalse(p.getHoldStack().empty());
			    assertFalse(p.getStateStack().empty());
			    
			    assertEquals(p.getHoldStack().peek(), token);
			    assertEquals(p.getStateStack().peek(), s);
			    
			    assertTrue(p.getCurrentState() instanceof MDJ_25);
	}

	/**
     * Tests to see that InvalidState method works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
    public void testInvalidState() throws ParserException
    {
    	Parser p = Parser.getInstance();
	    State s = new MDJ_23();
	        
	    Token token = new Token(";", "Semi", 5);
	    
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
	    
	    assertTrue(p.getCurrentState() instanceof MDJ_23);
    }
}
