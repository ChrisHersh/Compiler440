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
 * Tests to make sure ProcessMETH_BODY passes correctly.  
 * @author Jessica Schlesiger
 */
public class TestProcessMETH_BODY
{
	/**
	 * This tests for Pass1. 
	 *  @author Jessica Schlesiger
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
		ArrayList<Token> methBodyList = new ArrayList<Token>();
		methBodyList.add(varDeclL);
		methBodyList.add(var);
		
		Token test = new Token(TokenTypes.VAR_DECL_L.name(), 1, methBodyList);
		Class person = new Class("Person", null, null);
		PublicMethod method = new PublicMethod("dummyMethod", person, null, null);
		test.setParentClass(person);
		test.setParentMethod(method);
		ProcessMETH_BODY.processPass1(test);
		
		//Check all children
		for(int x = 0; x < test.getChildren().size(); x++)
		{
			assertEquals(test.getParentClass(),test.getChildren().get(x).getParentClass());
			assertEquals(test.getParentMethod(),test.getChildren().get(x).getParentMethod());
			assertTrue(test.getChildren().get(x).isVisited());
		}
	}
	
	/**
	 * There is nothing to test for pass2 and pass3
	 */
}
