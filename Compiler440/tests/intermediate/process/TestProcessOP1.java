package intermediate.process;

import static org.junit.Assert.*;

import org.junit.Test;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Chad Nunemaker
 * Test process OP1 to test the correct processing of the tokens
 */
public class TestProcessOP1
{
	/**
	 * test to see if the OP1 can make it through the third pass 
	 */
	@Test
	public void testProcessPass3()
	{
		final String expected = " || ";
	
		Token t1 = new Token(TokenTypes.OP1.name(), 1, null);
		ProcessOP1.processPass3(t1);
		final String actual = t1.getCode().toString();
		
		assertEquals(expected, actual);
	}
}
