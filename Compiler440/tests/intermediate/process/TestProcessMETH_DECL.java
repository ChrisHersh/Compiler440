package intermediate.process;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Tests to make sure ProcessMETH_DECL performs its passes correctly.  
 * 
 * @author Raistlin Hess
 */
public class TestProcessMETH_DECL
{
	/**
	 * This tests for Pass1. Make sure the correct information is passed down
	 * and that it can be retrieved successfully.
	 */
	@Test
	public void testProcessPass1()
	{		
		ArrayList<Token> tokens = new ArrayList<Token>();
		Token pub = new Token("public",TokenTypes.Public.name(),1);
		Token type = new Token("type",TokenTypes.TYPE.name(),1);
		Token id = new Token("Bobby",TokenTypes.Id.name(),1);
		Token L = new Token("(",TokenTypes.LPara.name(),1);
		Token fL = new Token("FORMAL_L",TokenTypes.FORMAL_L.name(),1);
		Token R = new Token(")",TokenTypes.RPara.name(),1);
		Token mB = new Token("METH_BODY",TokenTypes.METH_BODY.name(),1);
		
		tokens.add(pub);
		tokens.add(type);
		tokens.add(id);
		tokens.add(L);
		tokens.add(fL);
		tokens.add(R);
		tokens.add(mB);
		
		Token test = new Token(TokenTypes.METHOD_DECL.name(), 1, tokens);
		
		ProcessMETH_DECL.processPass1(test);
	}
	
	/**
	 * There is nothing to test for pass2
	 */
	
	/**
	 * This tests for Pass3. It verifies that IC was created correctly. 
	 */
	@Test
	public void testProcessPass3()
	{		
		ArrayList<Token> tokens = new ArrayList<Token>();
		Token pub = new Token("public",TokenTypes.Public.name(),1);
		Token type = new Token("type",TokenTypes.TYPE.name(),1);
		Token id = new Token("Bobby",TokenTypes.Id.name(),1);
		Token L = new Token("(",TokenTypes.LPara.name(),1);
		Token fL = new Token("FORMAL_L",TokenTypes.FORMAL_L.name(),1);
		Token R = new Token(")",TokenTypes.RPara.name(),1);
		Token mB = new Token("METH_BODY",TokenTypes.METH_BODY.name(),1);
		
		tokens.add(pub);
		tokens.add(type);
		tokens.add(id);
		tokens.add(L);
		tokens.add(fL);
		tokens.add(R);
		tokens.add(mB);
		
		Token test = new Token(TokenTypes.METHOD_DECL.name(), 1, tokens);
		
		ProcessMETH_DECL.processPass3(test);
		
		//Find the line that contains the variable Bobby. Then, check to see if
		//the whole line is printed in the correct syntax.
		//If it is, then pass turns out to be true. Otherwise, it is left false 
	}
}
