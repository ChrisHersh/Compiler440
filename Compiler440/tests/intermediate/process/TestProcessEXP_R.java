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
	 * @author Mike Zimmerman
	 * test to see if the EXP_R can make it through a second pass when processing
	 * also checks to make sure that the type of EXP1 is sythesised up to EXP_R 
	 * @throws ProcessException this is a exception to halt the compilation since types don't match
	 */
	@Test
	public void testProcessPass2() throws ProcessException
	{
		// EXP1 token for EXP_L
		Token t1 = new Token(TokenTypes.EXP1.name(), 1, null);
		t1.setVisited();
		
		// EXP_R token for EXP_L
		Token t2 = new Token(TokenTypes.EXP_R.name(), 1, null);
		t2.setVisited();
		
		// Adds tokens to ArrayList to add to EXP_L
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		
		// The EXP_L token to test
		Token t3 = new Token(TokenTypes.EXP_L.name(), 1, tkns);

		assertFalse(t3.isVisited());
		Token.pass2(t3);
		assertTrue(t3.isVisited());
		assertEquals(t3.getType(), t3.getChildren().get(1).getType());

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
