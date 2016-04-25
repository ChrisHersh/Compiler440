package intermediate.process;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Curtis Rabe, Mike Zimmerman
 * Test class for STMT_P
 *
 */
public class TestProcessSTMT_P {

	/**
	 * A test to make sure STMT_P can properly run through and process its tokens
	 * Note: It is my understanding that the tokens are already built, so 
	 * building them in this structure should be ok
	 */
	@Test
	public void testProcessPass1()
	{
		//First token of STMT_P
		Token t1 = new Token(TokenTypes.STMT_P.name(), 1, null);
		//Children for Second token of STMT_P
		Token t2 = new Token(TokenTypes.LBrace.name(), 1, null);
		Token t3 = new Token(TokenTypes.RBrace.name(), 1, null);
		Token t12 = new Token(TokenTypes.STMT_P.name(), 1, null);
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t2);
		tkns.add(t12);			//without this, this should fail, when STMT is properly coded
		tkns.add(t3);
		//Token for STMT
		Token t4 = new Token(TokenTypes.STMT.name(), 1, tkns);
		ArrayList<Token> tkns1 = new ArrayList<Token>();
		tkns1.add(t1);
		tkns1.add(t4);
		
		//The actual token of EXP_L to test
		Token t5 = new Token(TokenTypes.EXP_L.name(), 1, tkns1);
		
		try
		{
			ProcessSTMT_P.processPass1(t5);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
	}

	/**
	 * A test to make sure that STMT_P can make it through pass 2 and process its childern
	 */
	@Test
	public void testProcessPass2()
	{
		//First token of STMT_P
		Token t1 = new Token(TokenTypes.STMT_P.name(), 1, null);
		//Children for Second token of STMT_P
		Token t2 = new Token(TokenTypes.LBrace.name(), 1, null);
		Token t3 = new Token(TokenTypes.RBrace.name(), 1, null);
		Token t12 = new Token(TokenTypes.STMT_P.name(), 1, null);
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t2);
		tkns.add(t12);			//without this, this should fail, when STMT is properly coded
		tkns.add(t3);
		//Token for STMT
		Token t4 = new Token(TokenTypes.STMT.name(), 1, tkns);
		ArrayList<Token> tkns1 = new ArrayList<Token>();
		tkns1.add(t1);
		tkns1.add(t4);
		
		//The actual token of EXP_L to test
		Token t5 = new Token(TokenTypes.EXP_L.name(), 1, tkns1);
		
		try
		{
			ProcessSTMT_P.processPass2(t5);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
	}
	
	@Test
	public void testProcessPass3()
	{		
		
		Token t1 = new Token(TokenTypes.STMT_P.name(), 1, null);
		Token t2 = new Token(TokenTypes.STMT.name(), 1, null);
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		
		Token t3 = new Token(TokenTypes.STMT_P.name(), 1, tkns);
		ProcessSTMT_P.processPass3(t3);
		
	}
	
}
