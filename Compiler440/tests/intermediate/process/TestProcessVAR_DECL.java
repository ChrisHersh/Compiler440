package intermediate.process;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Tests to make sure ProcessVAR_DECL performs its passes correctly.  
 * 
 * @author Raistlin Hess
 */
public class TestProcessVAR_DECL 
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
		
		Token test = new Token(TokenTypes.VAR_DECL.name(), 1, varTokens);
		ProcessVAR_DECL.processPass1(test);
		
		//Check all children
		for(int x = 0; x < test.getChildren().size(); x++)
		{
			assertEquals(test.getParentClass(),test.getChildren().get(x).getParentClass());
			assertEquals(test.getParentMethod(),test.getChildren().get(x).getParentMethod());
			assertTrue(test.getChildren().get(x).isVisited());
		}
		assertEquals(test.getType(),test.getChildren().get(0).getType());
	}
	
	/**
	 * There is nothing to test for pass2 
	 */
	
	/**
	 * There is nothing to test for pass2 
	 */
}