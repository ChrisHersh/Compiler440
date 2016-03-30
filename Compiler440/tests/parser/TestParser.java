package parser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import tokenizer.Token;

/**
 * Test class to ensure the proper creation and usage with
 * of the parser and the stacks that comprises it
 * @author Curtis Rabe, Michael Zimmerman, Jared Good
 */
public class TestParser
{

    /**
     * This will ensure each test is run in isolation
     */
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
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
	
	/**
	 * Test to make sure the stateStack is properly created
	 * Jared Good
	 */
	@Test
	public void testStateStackInitialization()
	{
		assertTrue(Parser.getInstance().getStateStack().empty());
	}
	
	/**
	 * Test to make sure the stateStack can successfully hold states
	 * Jared Good
	 */
	@Test
	public void testStateStackCanStoreTokens()
	{
		ExampleState state1 = new ExampleState();
		ExampleState state2 = new ExampleState();
		Parser.getInstance().getStateStack().push(state1);
		Parser.getInstance().getStateStack().push(state2);
		assertEquals(state2, Parser.getInstance().getStateStack().pop());
		assertEquals(state1, Parser.getInstance().getStateStack().pop());
	}
	
	/**
	 * Test to ensure that we properly create an Input Stack from an ArrayList
	 * Daniel Breitigan & Matt Mousetis
	 */
	@Test
	public void testCreateInputStack()
	{
	       Token tok1 = new Token();
	       Token tok2 = new Token();
	       ArrayList<Token> tok = new ArrayList<Token>();
	       tok.add(tok1);
	       tok.add(tok2);
	       
	       Parser.getInstance().createInputStack(tok);
	       assertEquals(tok1, Parser.getInstance().popInputStack());
	       assertEquals(tok2, Parser.getInstance().popInputStack());
	}
}
