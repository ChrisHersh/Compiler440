package intermediate.process;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Curtis Rabe, Mike Zimmerman
 * Test process class to test the correct processing of the tokens
 */
public class TestProcessEXP_R
{

	/**
	 * A test to make sure EXP_R can properly run through and process its tokens
	 * This test cannot fail...because EXP_R will always have these children
	 * without exception.
	 */
	@Test
	public void testProcessPass1()
	{
		Token t1 = new Token(TokenTypes.Comma.name(), 1, null);
		Token t2 = new Token(TokenTypes.EXP1.name(), 1, null);
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		
		Token t3 = new Token(TokenTypes.EXP_R.name(), 1, tkns);
		try
		{
			ProcessEXP_R.processPass1(t3);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
	}
	
	/**
	 * test to see if the EXP_R can make it through a second pass 
	 * when processing 
	 */
	@Test
	public void testProcessPass2()
	{
		Token t1 = new Token(TokenTypes.Comma.name(), 1, null);
		Token t2 = new Token(TokenTypes.EXP1.name(), 1, null);
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		
		Token t3 = new Token(TokenTypes.EXP_R.name(), 1, tkns);
		try
		{
			ProcessEXP_R.processPass2(t3);
		}
		catch (NullPointerException x)
		{
			fail("failed on not having nested childern");
		}
	}
}
