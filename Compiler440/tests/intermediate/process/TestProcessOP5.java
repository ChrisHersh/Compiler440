package intermediate.process;

import static org.junit.Assert.*;

import org.junit.Test;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test process OP5 to test the correct processing of the tokens.
 * @author Manal Ibrahim
 */
public class TestProcessOP5
{
	/**
	 * Test to see if the OP5 can make it through the third pass .
	 */
	@Test
	public void testProcessPass3()
	{
		final String expected1 = " + ";
		final String expected2 = " - ";
	
		Token t1 = new Token(TokenTypes.OP5.name(), 1, null);
		ProcessOP5.processPass3(t1);
		final String actual = t1.getCode().toString();
		if (expected1 == " + ") {
			assertEquals(expected1, actual);
		} else if (expected1 == " - ")
		{
			assertEquals(expected2, actual);
			}
		
	}
}
