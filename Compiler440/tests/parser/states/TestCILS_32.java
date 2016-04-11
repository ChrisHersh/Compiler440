package parser.states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import parser.Parser;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test the reduce for CILS_32
 * @author Mohammed
 *
 */
public class TestCILS_32
{
	/**
	 * Initialize the Parser
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    }

	/**
	 * Make sure handles reduction correctly.
	 * It should shift to CILS_5
	 */
    @Test
	public void testReduceSTMT() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CILS_5();
	        
	    Token token = new Token("STMT", "STMT", 20);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.reduceSTMT();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CILS_5);
	}
}
