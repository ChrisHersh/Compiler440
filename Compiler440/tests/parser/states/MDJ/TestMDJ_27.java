package parser.states.MDJ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_19;
import parser.states.CRM.CRM_20;
import parser.states.MDJ.MDJ_27;
import parser.states.MDJ.MDJ_28;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Tests the methods of state MDJ_27
 * @author Jason LoBianco, Shannon Jones
 */
public class TestMDJ_27 
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
	 * test shift right bracket
	 * @throws ParserException
	 */
	@Test
	public void testShiftRightBrace() throws ParserException 
	{
		 
			    Parser p = Parser.getInstance();
			    State s = new MDJ_27();
			        
			    Token token = new Token("}", TokenTypes.RBrace.name(), 4);
			    
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
			    
			    assertTrue(p.getCurrentState() instanceof MDJ_28);
	}
	
	/**
	 * checks to see that shiftMETH_DECL works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftMETH_DECL() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new MDJ_27();
	        
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
	 * checks to see that shiftPublic works correctly
     * @author Jason LoBianco
     * @throws ParserException
     */
    @Test
	public void testShiftPublic() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new MDJ_27();
	        
	    Token token = new Token("Public", "Public", 25);
	    
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
