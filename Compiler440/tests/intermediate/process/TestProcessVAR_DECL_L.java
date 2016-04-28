package intermediate.process;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;

import symboltable.Class;
import symboltable.VariableType;
import symboltable.method.impl.PublicMethod;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Tests to make sure ProcessVAR_DECL_L performs its passes correctly.  
 * 
 * @author Raistlin Hess
 */
public class TestProcessVAR_DECL_L
{
	/**
	 * This tests for Pass1. 
	 */
	@Test
	public void testProcessPass1()
	{		
		ArrayList<Token> varTokens = new ArrayList<Token>();
		Token type = new Token("int",TokenTypes.TYPE.name(),1);
		Token id = new Token("Bobby",TokenTypes.Id.name(),1);
		Token semi = new Token(";",TokenTypes.SemiColon.name(),1);
		
		varTokens.add(type);
		varTokens.add(id);
		varTokens.add(semi);
		
		type.setType(VariableType.INTEGER.name());
		id.setType(VariableType.INTEGER.name());
		
		Token var = new Token(TokenTypes.VAR_DECL.name(),1,varTokens);
		Token varDeclL = new Token("VAR_DECL_L",TokenTypes.VAR_DECL_L.name(),1);
		ArrayList<Token> varDeclList = new ArrayList<Token>();
		varDeclList.add(varDeclL);
		varDeclList.add(var);
		
		Token test = new Token(TokenTypes.VAR_DECL_L.name(), 1, varDeclList);
		Class person = new Class("Person", null, null);
		PublicMethod method = new PublicMethod("dummyMethod", person, null, null);
		test.setParentClass(person);
		test.setParentMethod(method);
		ProcessVAR_DECL_L.processPass1(test);
		
		//Check all children
		for(int x = 0; x < test.getChildren().size(); x++)
		{
			assertEquals(test.getParentClass(),test.getChildren().get(x).getParentClass());
			assertEquals(test.getParentMethod(),test.getChildren().get(x).getParentMethod());
			assertTrue(test.getChildren().get(x).isVisited());
		}
	}
	
	/**
	 * There is nothing to test for pass2 
	 */
	
	/**
	 * There is nothing to test for pass2 
	 */
}
