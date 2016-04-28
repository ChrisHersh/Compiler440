package intermediate.process;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Corey Peregord
 * Test class for EXP4
 *
 */
public class TestProcessEXP4 {

	/**
	 * Test to validate that class and method are set properly
	 * @Author Corey Peregord
	 */
	@Test
	public void testProcessPass1()
	{
		Token t1 = new Token(TokenTypes.EXP4.name(), 1, null);
		Token t2 = new Token(TokenTypes.OP4.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP5.name(), 1, null);
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);			
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP3.name(), 1, tkns);

		try
		{
			ProcessEXP3.processPass1(t4);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
	}

	/**
	 * Test to validate that type checking works properly
	 * @Author Corey Peregord
	 */
	@Test
	public void testProcessPass2()
	{
		Token t1 = new Token(TokenTypes.EXP4.name(), 1, null);
		t1.setType("INT");
		Token t2 = new Token(TokenTypes.OP4.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP5.name(), 1, null);
		t3.setType("INT");
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);			
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP4.name(), 1, tkns);

		try
		{
			Token.pass2(t4);
		} catch (ProcessException x)
		{
			fail("Failed on type check");
		}
	}
	
	/**
	 * Test to validate that code is generated properly
	 * @Author Corey Peregord
	 */
	@Test
	public void testProcessPass3()
	{		
		Token t1 = new Token(TokenTypes.EXP4.name(), 1, null);
		Token t2 = new Token(TokenTypes.OP4.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP5.name(), 1, null);
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);			
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP4.name(), 1, tkns);

		Token.pass3(t4);
		
		assertEquals(t4.getCode().toString(), "OP4.getOperater(), EXP4_B.getValue() ,EXP5.getValue() , EXP4_A.setValue(result)");
		
	}
	
}
