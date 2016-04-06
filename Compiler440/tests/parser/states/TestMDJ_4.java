package parser.states;

import static org.junit.Assert.*;

import org.junit.*;

import parser.Parser;
import tokenizer.Token;

/**
 * Test class to check the methods of the MDJ_1 class.
 *
 */
public class TestMDJ_4 {
	
	
	    @Before
	    public void setUp()
	    {
	        Parser.resetParser();
	    }
	    
	    /**
	     * @author Mohammed
	     * Test the reduce to MDJ_1
	     * @throws ParserException
	     */
	    @Test
		public void testReduceCLASS_DECL() throws ParserException
		{
		    Parser p = Parser.getInstance();
		    State s = new MDJ_1();
		        
		    Token token = new Token("CLASS_DECL", "CLASS_DECL", 20);
		    
		    p.getInputStack().push(token);
		    
		    assertFalse(p.getInputStack().empty());
		    assertEquals(p.getInputStack().peek(), token);
		    assertTrue(p.getHoldStack().empty());
		    assertTrue(p.getStateStack().empty());
		    
		    s.shiftCLASS_DECL();
		    
		    assertTrue(p.getInputStack().empty());
		    assertFalse(p.getHoldStack().empty());
		    assertFalse(p.getStateStack().empty());
		    
		    assertEquals(p.getHoldStack().peek(), token);
		    assertEquals(p.getStateStack().peek(), s);
		    
		    assertTrue(p.getCurrentState() instanceof MDJ_1);
		}

}
