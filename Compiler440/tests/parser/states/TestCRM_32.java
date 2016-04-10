package parser.states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;

public class TestCRM_32 {

	@Before
    public void setUp()
    {
        Parser.resetParser();
    }
	
	/**
	 * checks that testShiftOP1 works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftOP1() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_32();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	    
	    assertTrue(p.getCurrentState() instanceof JMCC_3);
	}
	/**
	 * checks that testShiftSemiColon works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftSemiColon() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_32();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
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
	    
	    assertTrue(p.getCurrentState() instanceof CRM_33);
	}
	/**
	 * checks that testShiftOR works correctly
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftOR() throws ParserException 
	{
		Parser p = Parser.getInstance();
	    State s = new CRM_32();
	        
	    Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftOr();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof JMCC_2);
	}

}
