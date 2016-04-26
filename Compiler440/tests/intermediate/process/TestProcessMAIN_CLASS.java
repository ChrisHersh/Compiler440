package intermediate.process;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.Class;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test ProcessMAIN_CLASS class functionality 
 * @author Shannon Lee
 *
 */
public class TestProcessMAIN_CLASS 
{

	/**
	 * Test pass 1 in ProcessMAIN_CLASS
	 * MAIN_CLASS ­> class id { MAIN_METHOD }
	 * @author Shannon Lee
	 */
	@Test
	public void testPass1() 
	{
		ArrayList<Token> methTokens = new ArrayList<Token>();
		Token cla = new Token("class",TokenTypes.Class.name(),1);
		Token id = new Token("id",TokenTypes.Id.name(),1);
		Token lBrace = new Token("{",TokenTypes.LBrace.name(),1);
		Token main = new Token("MAIN_METHOD",TokenTypes.MAIN_METHOD.name(),1);
		Token rBrace = new Token("}",TokenTypes.RBrace.name(),1);
		
		methTokens.add(cla);
		methTokens.add(id);
		methTokens.add(lBrace);
		methTokens.add(main);
		methTokens.add(rBrace);
		
		Token meth = new Token(TokenTypes.MAIN_CLASS.name(), 1, methTokens);
		
		ArrayList<Token> methDecl = new ArrayList<Token>();
		methDecl.add(meth);
		
		ArrayList<Token> tokens = new ArrayList<Token>();
		Token t1 = new Token(TokenTypes.MAIN_CLASS.name(), 2, methDecl);
		tokens.add(t1);
		
		Token test = new Token(TokenTypes.MAIN_CLASS.name(), 1, tokens);
		Class bob = new Class("Bobby", null, null);
		test.setParentClass(bob);
		ProcessPROG.processPass1(test);
		assertEquals(test.getParentClass(), test.getChildren().get(0).getParentClass());
		assertTrue(test.getChildren().get(0).isVisited());
	}

	/**
	 * This doesn't test anything for pass 2
	 * @author Shannon Lee
	 */
	@Test
	public void testPass2()
	{
		
	}
	
	/**
	 * Test pass 3 in ProcessMAIN_CLASS
	 * Generate intermediate code 
	 * @author Shannon Lee
	 */
	@Test
	public void testPass3()
	{
		
	}
}
