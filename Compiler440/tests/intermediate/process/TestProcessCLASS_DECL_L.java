package intermediate.process;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.Class;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Test functionality of ProcessCLASS_DECL_L
 * @author Shannon Lee
 *
 */
public class TestProcessCLASS_DECL_L 
{

	/**
	 * Test the pass 1 for ProcessCLASS_DECL_L
	 * @author Shannon Lee
	 * 
	 */
	@Test
	public void testPass1() 
	{
		ArrayList<Token> methTokens = new ArrayList<Token>();
		Token main = new Token("CLASS_DECL_L",TokenTypes.CLASS_DECL_L.name(),1);
		Token class_decl_l = new Token("CLASS_DECL",TokenTypes.CLASS_DECL.name(),1);
		
		
		methTokens.add(main);
		methTokens.add(class_decl_l);
		
		
		Token meth = new Token(TokenTypes.CLASS_DECL_L.name(), 1, methTokens);
		
		ArrayList<Token> methDecl = new ArrayList<Token>();
		methDecl.add(meth);
		
		ArrayList<Token> tokens = new ArrayList<Token>();
		Token t1 = new Token(TokenTypes.CLASS_DECL_L.name(), 2, methDecl);
		tokens.add(t1);
		
		Token test = new Token(TokenTypes.CLASS_DECL_L.name(), 1, tokens);
		Class bob = new Class("Bobby", null, null);
		test.setParentClass(bob);
		ProcessCLASS_DECL_L.processPass1(test);
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
	 * This doesn't test anything for pass 3
	 * @author Shannon Lee
	 */
	@Test
	public void testPass3()
	{
		
	}

}
