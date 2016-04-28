package intermediate.process;

import static org.junit.Assert.*;

import org.junit.Test;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test process OP6 to test the correct processing of the tokens.
 * @author Mohammed
 */
public class TestProcessOP6
{
	/**
	 * Test to see if the OP6 can make it through the third pass .
	 */
	@Test
	public void testProcessPass3()
	{
		final String expected = " * ";
		
		Token t1 = new Token(TokenTypes.OP6.name(), 1, null);
		ProcessOP6.processPass3(t1);
		final String actual = t1.getCode().toString();
		
		assertEquals(expected, actual);
	}
}
