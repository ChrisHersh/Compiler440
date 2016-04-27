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
 * Tests for CRM_30
 * @author TJ Renninger
 */
public class TestCRM_30
{
	private Parser p;
	private State s;
	private int i;
	private final String[] toks = {"STMT", "If", "LBrace", "While", "SystemOutPrintln", "Id"};
	private final Object[] states = {CRM_3.class, CRM_7.class, CRM_6.class, CRM_10.class, CRM_8.class, CRM_9.class};
	
	/**
	 * Sets up everything for the tests.
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
        p = Parser.getInstance();
        s = new CRM_30();
    }
	
	/**
	 * Test that shiftSTMT() on while in CRM_30 goes to the correct state
	 * @throws ParserException
	 */
	@Test
	public void testShiftSTMT() throws ParserException
	{
		i = 0;
	    Token token = getToken();
	    checkStacksBeforeShift(token);
	    s.shiftSTMT();
	    checkStacksAfterShift(token);
	    assertTrue(p.getCurrentState().getClass() == states[i]);
	}
	
	/**
	 * Test that shiftIf() on while in CRM_30 goes to the correct state
	 * @throws ParserException
	 */
	@Test
	public void testShiftIf() throws ParserException
	{
		i = 1;
	    Token token = getToken();
	    checkStacksBeforeShift(token);
	    s.shiftIf();
	    checkStacksAfterShift(token);
	    assertTrue(p.getCurrentState().getClass() == states[i]);
	}
	
	/**
	 * Test that shiftLeftBrace() on while in CRM_30 goes to the correct state
	 * @throws ParserException
	 */
	@Test
	public void testShiftLeftBrace() throws ParserException
	{
		i = 2;
	    Token token = getToken();
	    checkStacksBeforeShift(token);
	    s.shiftLeftBrace();
	    checkStacksAfterShift(token);
	    assertTrue(p.getCurrentState().getClass() == states[i]);
	}
	
	/**
	 * Test that shiftWhile() on while in CRM_30 goes to the correct state
	 * @throws ParserException
	 */
	@Test
	public void testShiftWhile() throws ParserException
	{
		i = 3;
	    Token token = getToken();
	    checkStacksBeforeShift(token);
	    s.shiftWhile();
	    checkStacksAfterShift(token);
	    assertTrue(p.getCurrentState().getClass() == states[i]);
	}
	
	/**
	 * Test that shiftSystemOutPrintln() on while in CRM_30 goes to the correct state
	 * @throws ParserException
	 */
	@Test
	public void testShiftSystemOutPrintln() throws ParserException
	{
		i = 4;
	    Token token = getToken();
	    checkStacksBeforeShift(token);
	    s.shiftSystemOutPrintln();
	    checkStacksAfterShift(token);
	    assertTrue(p.getCurrentState().getClass() == states[i]);
	}
	
	/**
	 * Test that shiftId() on while in CRM_30 goes to the correct state
	 * @throws ParserException
	 */
	@Test
	public void testShiftId() throws ParserException
	{
		i = 5;
	    Token token = getToken();
	    checkStacksBeforeShift(token);
	    s.shiftId();
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
