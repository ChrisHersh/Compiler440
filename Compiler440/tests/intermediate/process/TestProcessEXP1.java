package intermediate.process;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Chad Nunemaker
 * Test process EXP1 to test the correct processing of the tokens
 * Modeled after TestProcessEXP_R
 */
public class TestProcessEXP1
{
	/**
	 * A test to make sure EXP1 can properly run through and process its tokens
	 */
	@Test
	public void testProcessPass1()
	{
		// Handle EXP1_A -> EXP1 op1 EXP2
		Token t1 = new Token(TokenTypes.True.name(), 1, null); // Assume EXP1 = True
		Token t2 = new Token(TokenTypes.OP1.name(), 1, null);
		Token t3 = new Token(TokenTypes.True.name(), 1, null); // Assume EXP2 = True
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP1.name(), 1, tkns);
		try
		{
			ProcessEXP1.processPass1(t4);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
		
		// Handle EXP1 -> EXP2
		t1 = new Token(TokenTypes.True.name(), 1, null); // Assume EXP2 = True
		tkns = new ArrayList<Token>();
		tkns.add(t1);
		
		t2 = new Token(TokenTypes.EXP1.name(), 1, tkns);
		try
		{
			ProcessEXP1.processPass1(t2);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
	}
	
	/**
	 * test to see if the EXP1 can make it through a second pass 
	 */
	@Test
	public void testProcessPass2()
	{
		// Handle EXP1_A -> EXP1 op1 EXP2
		Token t1 = new Token(TokenTypes.True.name(), 1, null); // Assume EXP1 = True
		Token t2 = new Token(TokenTypes.OP1.name(), 1, null);
		Token t3 = new Token(TokenTypes.True.name(), 1, null); // Assume EXP2 = True
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP1.name(), 1, tkns);
		try
		{
			ProcessEXP1.processPass1(t4);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
		
		// Handle EXP1 -> EXP2
		t1 = new Token(TokenTypes.True.name(), 1, null); // Assume EXP2 = True
		tkns = new ArrayList<Token>();
		tkns.add(t1);
		
		t2 = new Token(TokenTypes.EXP1.name(), 1, tkns);
		try
		{
			ProcessEXP1.processPass1(t2);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
	}
	
	/**
	 * test to see if the EXP1 can make it through the third pass 
	 */
	@Test
	public void testProcessPass3()
	{
		// Handle EXP1_A -> EXP1 op1 EXP2
		Token t1 = new Token(TokenTypes.True.name(), 1, null); // Assume EXP1 = True
		Token t2 = new Token(TokenTypes.OP1.name(), 1, null);
		Token t3 = new Token(TokenTypes.True.name(), 1, null); // Assume EXP2 = True
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP1.name(), 1, tkns);
		try
		{
			ProcessEXP1.processPass1(t4);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
		
		// Handle EXP1 -> EXP2
		t1 = new Token(TokenTypes.True.name(), 1, null); // Assume EXP2 = True
		tkns = new ArrayList<Token>();
		tkns.add(t1);
		
		t2 = new Token(TokenTypes.EXP1.name(), 1, tkns);
		try
		{
			ProcessEXP1.processPass1(t2);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
	}
}
