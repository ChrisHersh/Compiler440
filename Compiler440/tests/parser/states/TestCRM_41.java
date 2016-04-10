package parser.states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;
import tokenizer.TokenTypes;

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
	    
	    assertEquals(p.getInputStack().peek().getToken(),TokenTypes.METH_BODY.name());
	    
	    assertTrue(p.getCurrentState() instanceof JMCC_2);
	}

}
