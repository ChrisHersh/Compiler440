package parser.states.CRM;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;

/**
 * Tests for CRM_26
 * @author TJ Renninger
 */
public class TestCRM_26
{
	private Parser p;
	private State s;
	private int i;
	private final String[] toks = {"M_METH_BODY", "LBrace"};
	private final Object[] states = {CRM_27.class, CRM_28.class};
	
	/**
	 * Sets up everything for the tests.
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
        p = Parser.getInstance();
        s = new CRM_26();
    }
	
	/**
	 * Test that shiftM_METH_BODY() on while in CRM_26 goes to the correct state
	 * @throws ParserException
	 */
	@Test
	public void testShiftM_METH_BODY() throws ParserException
	{
		i = 0;
	    Token token = getToken();
	    checkStacksBeforeShift(token);
	    s.shiftM_METH_BODY();
	    checkStacksAfterShift(token);
	    assertTrue(p.getCurrentState().getClass() == states[i]);
	}
	
	/**
	 * Test that shiftLeftBrace() on while in CRM_26 goes to the correct state
	 * @throws ParserException
	 */
	@Test
	public void testShiftLeftBrace() throws ParserException
	{
		i = 1;
	    Token token = getToken();
	    checkStacksBeforeShift(token);
	    s.shiftLeftBrace();
	    checkStacksAfterShift(token);
	    assertTrue(p.getCurrentState().getClass() == states[i]);
	}
	
	/**
	 * @return returns the correct token for each test
	 */
	private Token getToken()
	{
		return new Token(toks[i], toks[i], 25);
	}
	
	/**
	 * Checks all the stacks before a shift
	 * @param token That is being checked
	 */
	public void checkStacksBeforeShift(Token token)
	{
		p.getInputStack().push(token);
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	}
	
	/**
	 * Checks all the stacks after a shift
	 * @param token That is being checked
	 */
	public void checkStacksAfterShift(Token token)
	{
		assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	}
}
