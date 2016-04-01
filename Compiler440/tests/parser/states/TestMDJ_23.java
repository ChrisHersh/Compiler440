package parser.states;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;

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
			        
			    Token token = new Token("VAR_DECL_L", "VAR_DECL_L", 4);
			    
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

}
