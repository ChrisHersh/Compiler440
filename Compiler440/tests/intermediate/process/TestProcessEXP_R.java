package intermediate.process;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.Class;
import symboltable.VariableType;
import symboltable.method.impl.PublicMethod;
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
	 */
	@Test
	public void testProcessPass1()
	{
		Token t1 = new Token(TokenTypes.Comma.name(), 1, null);
		t1.setVisited();
		Token t2 = new Token(TokenTypes.EXP1.name(), 1, null);
		t2.setVisited();
		t2.setType("boolean");
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		
		
		Token t3 = new Token(TokenTypes.EXP_R.name(), 1, tkns);
		
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t3.setParentMethod(pm);
		t3.setParentClass(c1);
		assertFalse(t3.isVisited());

		Token.pass1(t3);
		assertEquals(t3.getType(), t3.getChildren().get(1).getType());
		assertEquals(t3.getChildren().get(0).getParentClass(), t3.getParentClass());
		assertEquals(t3.getChildren().get(0).getParentMethod(), t3.getParentMethod());
		assertEquals(t3.getChildren().get(1).getParentClass(), t3.getParentClass());
		assertEquals(t3.getChildren().get(1).getParentMethod(), t3.getParentMethod());
		assertTrue(t3.isVisited());

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
	
	/**
	 * test to see if the EXP_R can make it through the third pass 
	 * when processing 
	 * @author Jared Good
	 */
	@Test
	public void testProcessPass3()
	{
		// Children tokens for EXP_R
		Token t1 = new Token(TokenTypes.Comma.name(), 1, null);
		Token t2 = new Token(TokenTypes.EXP1.name(), 1, null);
		t1.setVisited();
		t2.setVisited();
		
		// Adds tokens to ArrayList to add to EXP_R
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		
		// EXP_R token
		Token t3 = new Token(TokenTypes.EXP_R.name(), 1, tkns);
		
		// Checks that the token properly goes through pass 3
		assertFalse(t3.isVisited());
		Token.pass3(t3);
		assertTrue(t3.isVisited());
		
	}
}
