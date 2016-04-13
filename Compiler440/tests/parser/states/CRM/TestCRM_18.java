package parser.states.CRM;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_18;
import parser.states.CRM.CRM_19;
import parser.states.CRM.CRM_20;
import tokenizer.Token;

public class TestCRM_18 
{
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }

	/**
	 * checks that shiftMETH_DECL works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftMETH_DECL() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_18();
	        
	    Token token = new Token("METH_DECL", "METH_DECL", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftMETH_DECL();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_19);
	}

    /**
	 * checks that shiftPublic works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftPublic() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CRM_18();
	        
	    Token token = new Token("public", "Public", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftPublic();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CRM_20);
	}
}
