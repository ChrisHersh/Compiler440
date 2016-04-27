package intermediate.process;

import static org.junit.Assert.*;

import org.junit.Test;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Chad Nunemaker
 * Test process OP2 to test the correct processing of the tokens
 */
public class TestProcessOP2
{
	/**
	 * test to see if the OP2 can make it through the third pass 
	 */
	@Test
	public void testProcessPass3()
	{
		final String expected = " && ";
		
		Token t1 = new Token(TokenTypes.OP2.name(), 1, null);
		ProcessOP2.processPass3(t1);
		final String actual = t1.getCode().toString();
		
		assertEquals(expected, actual);
	}
}
