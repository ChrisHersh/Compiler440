package parser.states.CRM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_2;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Tests for CRM_23
 * @author TJ Renninger
 */
public class TestCRM_27
{
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
	/**
	 * checks that reducing works correctly
	 * @throws ParserException
	 */
	@Test
	public void testReduce() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_27();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
	    p.pushHoldStack(token);
	    p.pushStateStack(new JMCC_2());
	    p.pushHoldStack(token);
	    p.pushStateStack(new JMCC_2());
	    p.pushHoldStack(token);
	    p.pushStateStack(new JMCC_2());
	    p.pushHoldStack(token);
	    p.pushStateStack(new JMCC_2());
	    p.pushHoldStack(token);
	    p.pushStateStack(new JMCC_2());
	    p.pushHoldStack(token);
	    p.pushStateStack(new JMCC_2());
	    p.pushHoldStack(token);
	    p.pushStateStack(new JMCC_2());
	    assertTrue(p.getInputStack().empty());
	    
	    s.shiftEquals();
	    
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    assertEquals(p.getInputStack().peek().getToken(),TokenTypes.METH_DECL_L.name());
	    
	    assertTrue(p.getCurrentState() instanceof JMCC_2);
	}
}
