package parser.states.MDJ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.MDJ.MDJ_21;
import parser.states.MDJ.MDJ_23;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Tests that the shift are working correctly. 
 * For MDJ; 25,27,29,31,32
 * @author Shannon Lee
 *
 */
public class TestMDJ_21 {

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
	 * test shift left Bracket
	 * @throws ParserException
	 */
	@Test
	public void testShiftLeftBrace() throws ParserException 
	{
		 
			    Parser p = Parser.getInstance();
			    State s = new MDJ_21();
			        
			    Token token = new Token("{", TokenTypes.LBrace.name(), 4);
			    
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
			    
			    assertTrue(p.getCurrentState() instanceof MDJ_23);
	}
	
	
	
	
	

}
