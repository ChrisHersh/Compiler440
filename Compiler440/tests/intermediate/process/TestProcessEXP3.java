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
 * @author Corey Peregord
 * Test class for EXP3
 *
 */
public class TestProcessEXP3 {

	/**
	 * Test to validate that class and method are set properly
	 * @Author Corey Peregord
	 */
	@Test
	public void testProcessPass1()
	{
		Token t1 = new Token(TokenTypes.EXP3.name(), 1, null);
		Token t2 = new Token(TokenTypes.OP3.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP4.name(), 1, null);
		t3.setType("INT");
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);			
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP3.name(), 1, tkns);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t4.setParentMethod(pm);
		t4.setParentClass(c1);

		Token.pass1(t4);
		
		for(int i = 0; i < t4.getChildren().size(); i++){
			Token child = t4.getChildren().get(i);
			
			assertEquals(child.getParentClass().getName(), t4.getParentClass().getName());
			assertEquals(child.getParentMethod(), t4.getParentMethod());
		}
		
		assertEquals(t4.getType(), "INT");
	}
	
	/**
	 * Test to validate that class and method are set properly
	 * @Author Corey Peregord
	 */
	@Test
	public void testProcessPass1Other()
	{
		Token t3 = new Token(TokenTypes.EXP4.name(), 1, null);
		t3.setType("INT");
		ArrayList<Token> tkns = new ArrayList<Token>();			
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP3.name(), 1, tkns);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t4.setParentMethod(pm);
		t4.setParentClass(c1);

		Token.pass1(t4);
		
		for(int i = 0; i < t4.getChildren().size(); i++){
			Token child = t4.getChildren().get(i);
			
			assertEquals(child.getParentClass().getName(), t4.getParentClass().getName());
			assertEquals(child.getParentMethod(), t4.getParentMethod());
		}
		
		assertEquals(t4.getType(), "INT");
	}

	/**
	 * Test to validate that type checking works properly
	 * @Author Corey Peregord
	 */
	@Test
	public void testProcessPass2()
	{
		Token t1 = new Token(TokenTypes.EXP3.name(), 1, null);
		t1.setType("INT");
		Token t2 = new Token(TokenTypes.OP3.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP4.name(), 1, null);
		t3.setType("INT");
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);			
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP3.name(), 1, tkns);

		try
		{
			Token.pass2(t4);
		} catch (ProcessException x)
		{
			fail("Failed on type check");
		}
	}
	
	/**
	 * Test to validate that type checking works properly
	 * @throws ProcessException 
	 * @Author Corey Peregord
	 */
	@Test(expected=ProcessException.class)
	public void testProcessPass2Fail() throws ProcessException
	{
		Token t1 = new Token(TokenTypes.EXP3.name(), 1, null);
		t1.setType("INT");
		Token t2 = new Token(TokenTypes.OP3.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP4.name(), 1, null);
		t3.setType("CHAR");
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);			
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP3.name(), 1, tkns);

		Token.pass2(t4);

	}
	
	/**
	 * Test to validate that code is generated properly
	 * @Author Corey Peregord
	 */
	@Test
	public void testProcessPass3()
	{		
		Token t1 = new Token(TokenTypes.EXP3.name(), 1, null);
		Token t2 = new Token(TokenTypes.OP3.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP4.name(), 1, null);
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);			
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP3.name(), 1, tkns);

		Token.pass3(t4);
		
		assertEquals(t4.getCode().toString(), "OP3.getOperater(), EXP3_B.getValue() ,EXP4.getValue() , EXP3_A.setValue(result)");
		
	}
	
}
