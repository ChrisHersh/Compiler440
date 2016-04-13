package parser.states.CRM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_4;
import parser.states.CRM.CRM_5;
import tokenizer.Token;

public class TestCRM_4
{
	/**
     * Test to make sure that shifting on } works
     * @author TJ Renninger
     * @throws ParserException
     */
    @Test
	public void testShiftRightBrace() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_4();
	        
	    Token token = new Token("}", "RightBrace", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftRightBrace();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_5);
	}
}
