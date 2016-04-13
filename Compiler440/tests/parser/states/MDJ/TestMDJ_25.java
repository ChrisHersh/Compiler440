package parser.states.MDJ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.MDJ.MDJ_25;
import parser.states.MDJ.MDJ_27;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class TestMDJ_25 
{

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
	 * test shift METH_DECL_L
	 * @throws ParserException
	 */
	@Test
	public void testShiftMETH_DECL_L() throws ParserException 
	{
		 
			    Parser p = Parser.getInstance();
			    State s = new MDJ_25();
			        
			    Token token = new Token("METH_DECL_L", TokenTypes.METH_DECL_L.name(), 4);
			    
			    p.getInputStack().push(token);
			    
			    assertFalse(p.getInputStack().empty());
			    assertEquals(p.getInputStack().peek(), token);
			    assertTrue(p.getHoldStack().empty());
			    assertTrue(p.getStateStack().empty());
			    
			    s.shiftMETH_DECL_L();
			   
			    assertTrue(p.getInputStack().empty());
			    assertFalse(p.getHoldStack().empty());
			    assertFalse(p.getStateStack().empty());
			    
			    assertEquals(p.getHoldStack().peek(), token);
			    assertEquals(p.getStateStack().peek(), s);
			    
			    assertTrue(p.getCurrentState() instanceof MDJ_27);
	}

}
