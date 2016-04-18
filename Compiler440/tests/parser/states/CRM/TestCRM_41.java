package parser.states.CRM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_41;
import parser.states.JMCC.JMCC_2;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * @author Chris Kjeldgaard
 */
public class TestCRM_41 {

	@Before
    public void setUp()
    {
        Parser.resetParser();
    }

	/**
	 * checks that reducing works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testReduce() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_41();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	    
	    assertEquals(p.getInputStack().peek().getToken(),TokenTypes.FORMAL_R.name());
	    
	    assertTrue(p.getCurrentState() instanceof JMCC_2);
	}

}
