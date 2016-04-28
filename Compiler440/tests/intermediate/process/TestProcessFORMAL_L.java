package intermediate.process;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import symboltable.Class;
import symboltable.SymbolTable;
import symboltable.Variable;
import symboltable.VariableType;
import symboltable.method.impl.PublicMethod;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Tests to make sure ProcessFORMAL_R passes correctly.  
 * @author Jessica Schlesiger
 */
public class TestProcessFORMAL_L 
{
	/**
	 * This tests for Pass1. 
	 *  @author Jessica Schlesiger
	 */
	@Test
	public void testProcessPass1()
	{
		SymbolTable st= SymbolTable.getInstance();
		ArrayList<Token> varTokens = new ArrayList<Token>();
		Token type = new Token("int",TokenTypes.IntNum.name(),1);
		Token id = new Token("Bobby",TokenTypes.Id.name(),1);
		Token semi = new Token(";",TokenTypes.SemiColon.name(),1);
		
		varTokens.add(type);
		varTokens.add(id);
		varTokens.add(semi);
		
		type.setType(VariableType.INTEGER.name());
		id.setType(VariableType.INTEGER.name());
		
		Token test = new Token(TokenTypes.VAR_DECL.name(), 1, varTokens);
		Class person = new Class("Person", null, null);
		PublicMethod method = new PublicMethod("dummyMethod", person, null, null);
		test.setParentClass(person);
		test.setParentMethod(method);
		
		ProcessFORMAL_L.processPass1(test);
		
		//Check all children
		for(int x = 0; x < test.getChildren().size(); x++)
		{
			assertEquals(test.getParentClass(),test.getChildren().get(x).getParentClass());
			assertEquals(test.getParentMethod(),test.getChildren().get(x).getParentMethod());
			assertTrue(test.getChildren().get(x).isVisited());
		}
		assertEquals(test.getType(),test.getChildren().get(0).getType());
		
		//Look for the variable Bobby in the SymbolTable
		ArrayList<Variable> varList = st.getVariableList("Bobby");
		
		assertEquals(VariableType.INTEGER,varList.get(0).getType());
		assertEquals("Bobby",varList.get(0).getName());
	}
	
	// There is nothing to test for pass2 and 3
}