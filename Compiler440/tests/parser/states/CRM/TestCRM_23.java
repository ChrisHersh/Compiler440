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
 * Tests for CRM_23
 * @author TJ Renninger
 */
public class TestCRM_23
{
	private Parser p;
	private State s;
	private int i;
	private final String[] toks = {"Id", "Int", "Boolean", "FORMAL_L", "TYPE"};
	private final Object[] states = {CRM_9.class, CRM_12.class, CRM_13.class, CRM_25.class, CRM_35.class};
	
	/**
	 * Sets up everything for the tests.
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
        p = Parser.getInstance();
        s = new CRM_23();
    }
	
	/**
	 * Test that shiftInt() on while in CRM_23 goes to the correct state
	 * @throws ParserException
	 */
	@Test
	public void testShiftInt() throws ParserException
	{
		i = 0;
	    Token token = getToken();
	    checkStacksBeforeShift(token);
	    s.shiftInt();
	    checkStacksAfterShift(token);
	    assertTrue(p.getCurrentState().getClass() == states[i]);
	}
	
	/**
	 * Test that shiftId() on while in CRM_23 goes to the correct state
	 * @throws ParserException
	 */
	@Test
	public void testShiftId() throws ParserException
	{
		i = 1;
	    Token token = getToken();
	    checkStacksBeforeShift(token);
	    s.shiftId();
	    checkStacksAfterShift(token);
	    assertTrue(p.getCurrentState().getClass() == states[i]);
	}
	
	/**
	 * Test that shiftBoolean() on while in CRM_23 goes to the correct state
	 * @throws ParserException
	 */
	@Test
	public void testShiftBoolean() throws ParserException
	{
		i = 2;
	    Token token = getToken();
	    checkStacksBeforeShift(token);
	    s.shiftBoolean();
	    checkStacksAfterShift(token);
	    assertTrue(p.getCurrentState().getClass() == states[i]);
	}
	
	/**
	 * Test that shiftFORMAL_L() on while in CRM_23 goes to the correct state
	 * @throws ParserException
	 */
	@Test
	public void testShiftFORMAL_L() throws ParserException
	{
		i = 3;
	    Token token = getToken();
	    checkStacksBeforeShift(token);
	    s.shiftFORMAL_L();
	    checkStacksAfterShift(token);
	    assertTrue(p.getCurrentState().getClass() == states[i]);
	}
	
	/**
	 * Test that shiftTYPE() on while in CRM_23 goes to the correct state
	 * @throws ParserException
	 */
	@Test
	public void testShiftTYPE() throws ParserException
	{
		i = 4;
	    Token token = getToken();
	    checkStacksBeforeShift(token);
	    s.shiftTYPE();
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
