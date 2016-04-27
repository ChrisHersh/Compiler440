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
	 * Note Note: For the test, the tokens are manipulated to have been visited,
	 * so the pass does not revisit them. At conclusion of run, itself is visited.
	 */
	@Test
	public void testProcessPass1()
	{
		//first token of EXP_L
		Token t1 = new Token(TokenTypes.EXP1.name(), 1, null);
		t1.setVisited();
		t1.setType("boolean");
		//EXP_R, the second token of EXP_L
		Token t4 = new Token(TokenTypes.EXP_R.name(), 1, null);
		t4.setVisited();
		t4.setType("int");
		ArrayList<Token> tkns1 = new ArrayList<Token>();
		tkns1.add(t1);
		tkns1.add(t4);
		//The actual token of EXP_L to test
		Token t5 = new Token(TokenTypes.EXP_L.name(), 1, tkns1);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t5.setParentMethod(pm);
		t5.setParentClass(c1);
		assertFalse(t5.isVisited());
		Token.pass1(t5);
		assertEquals(t5.getType(), t5.getChildren().get(0).getType());
		assertEquals(t5.getChildren().get(0).getParentClass(), t5.getParentClass());
		assertEquals(t5.getChildren().get(0).getParentMethod(), t5.getParentMethod());
		assertEquals(t5.getChildren().get(1).getParentClass(), t5.getParentClass());
		assertEquals(t5.getChildren().get(1).getParentMethod(), t5.getParentMethod());
		assertTrue(t5.isVisited());
	}

	/**
	 * test to see if the EXP_L can make it through a second pass 
	 * when processing 
	 */
	@Test
	public void testProcessPass2()
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
		Token.pass3(t3);
		assertTrue(t3.isVisited());
	}
	
	/**
	 * Test to see if the EXP_L can make it through the third pass 
	 * when processing 
	 * @author Jared Good
	 */
	@Test
	public void testProcessPass3()
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
		Token.pass3(t3);
		assertTrue(t3.isVisited());
		
	}
}
