package intermediate.process;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Curtis Rabe, Mike Zimmerman
 * 
 * Test class for ProcessEXP_L to test the passes
 *
 */
public class TestProcessEXP_L
{

	/**
	 * A test to make sure EXP_L can properly run through and process its tokens
	 * Note: It is my understanding that the tokens are already built, so 
	 * building them in this structure should be ok
	 */
	@Test
	public void testProcessPass1()
	{
		//first token of EXP_L
		Token t1 = new Token(TokenTypes.EXP1.name(), 1, null);
		//Tokens of EXP_R
		Token t2 = new Token(TokenTypes.Comma.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP1.name(), 1, null);
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t2);
		tkns.add(t3);
		//EXP_R, the second token of EXP_L
		Token t4 = new Token(TokenTypes.EXP_R.name(), 1, tkns);
		ArrayList<Token> tkns1 = new ArrayList<Token>();
		tkns1.add(t1);
		tkns1.add(t4);
		//The actual token of EXP_L to test
		Token t5 = new Token(TokenTypes.EXP_L.name(), 1, tkns1);
		try
		{
			ProcessEXP_L.processPass1(t5);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
	}

	/**
	 *  test to see if the EXP_L can make it through a second pass 
	 * when processing 
	 */
	@Test
	public void testProcessPass2()
	{
		// first token of EXP_L
		Token t1 = new Token(TokenTypes.EXP1.name(), 1, null);
		// Tokens of EXP_R
		Token t2 = new Token(TokenTypes.Comma.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP1.name(), 1, null);
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t2);
		tkns.add(t3);
		// EXP_R, the second token of EXP_L
		Token t4 = new Token(TokenTypes.EXP_R.name(), 1, tkns);
		ArrayList<Token> tkns1 = new ArrayList<Token>();
		tkns1.add(t1);
		tkns1.add(t4);
		// The actual token of EXP_L to test
		Token t5 = new Token(TokenTypes.EXP_L.name(), 1, tkns1);
		try 
		{
			ProcessEXP_L.processPass2(t5);
		} catch (IndexOutOfBoundsException x) 
		{
			fail("Failed on Children Creation");
		}
	}
	
	/**
	 * Test to see if the EXP_L can make it through the third pass 
	 * when processing 
	 * @author Jared Good
	 */
	@Test
	public void testProcessPass3()
	{
		// first token of EXP_L
		Token t1 = new Token(TokenTypes.EXP1.name(), 1, null);
		
		// Tokens of EXP_R
		Token t2 = new Token(TokenTypes.Comma.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP1.name(), 1, null);
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t2);
		tkns.add(t3);
		
		// EXP_R, the second token of EXP_L
		Token t4 = new Token(TokenTypes.EXP_R.name(), 1, tkns);
		ArrayList<Token> tkns1 = new ArrayList<Token>();
		tkns1.add(t1);
		tkns1.add(t4);
		
		// The actual token of EXP_L to test
		Token t5 = new Token(TokenTypes.EXP_L.name(), 1, tkns1);
		
		try 
		{
			ProcessEXP_L.processPass3(t5);
		} catch (IndexOutOfBoundsException x) 
		{
			fail("Failed on Children Creation");
		}
	}
}
