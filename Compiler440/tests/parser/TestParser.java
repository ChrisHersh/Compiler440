package parser;

import static org.junit.Assert.*;

import org.junit.Test;

import tokenizer.Token;

/**
 * Test class to ensure the proper creation and usage
 * of the parser and the stacks that comprises it
 * @author Curtis Rabe
 */
public class TestParser
{

	/**
	 * Test the singleton initialization of a parser.
	 */
	@Test
	public void testInitialization()
	{
		assertNotNull(Parser.getInstance());
	}
	/**
	 * Test to make sure the holdStack is properly created
	 */
	@Test
	public void testHoldStackInitialization()
	{
		assertTrue(Parser.getInstance().getHoldStack().empty());
	}
	
	/**
	 * Test to make sure the holdStack can successfully hold tokens
	 */
	@Test
	public void testHoldStackCanStoreTokens()
	{
		Token tok1 = new Token();
		Token tok2 = new Token();
		Parser.getInstance().getHoldStack().push(tok1);
		Parser.getInstance().getHoldStack().push(tok2);
		assertEquals(tok2, Parser.getInstance().getHoldStack().pop());
		assertEquals(tok1, Parser.getInstance().getHoldStack().pop());
	}
	/**
	 * Test to make sure the inputStack is properly created
	 * Michael Zimmerman
	 */
	@Test
	public void testInputStackInitialization()
	{
		assertTrue(Parser.getInstance().getInputStack().empty());
	}
	
	/**
	 * Test to make sure the inputStack can successfully hold tokens
	 * Michael Zimmerman
	 */
	@Test
	public void testInputStackCanStoreTokens()
	{
		Token tok1 = new Token();
		Token tok2 = new Token();
		Parser.getInstance().getInputStack().push(tok1);
		Parser.getInstance().getInputStack().push(tok2);
		assertEquals(tok2, Parser.getInstance().getInputStack().pop());
		assertEquals(tok1, Parser.getInstance().getInputStack().pop());
	}
	

}
