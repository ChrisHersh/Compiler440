package parser.states.CRM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_38;
import parser.states.CRM.CRM_39;
import parser.states.JMCC.JMCC_2;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class TestCRM_38 {

	@Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
	/**
	 * checks that shiftMETH_DECL_L works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftMETH_DECL_L() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_38();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftComa();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_39);
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
	    State s = new CRM_38();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	    
	    assertEquals(p.getInputStack().peek().getToken(),TokenTypes.FORMAL_L.name());
	    
	    assertTrue(p.getCurrentState() instanceof JMCC_2);
	}

}
