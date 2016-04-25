package intermediate.process;

import java.util.ArrayList;
import org.junit.Test;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Tests to make sure ProcessMETH_DECL_L performs its passes correctly.  
 * 
 * @author Raistlin Hess
 */
public class TestProcessMETH_DECL_L 
{
	/**
	 * This tests for Pass1. 
	 */
	@Test
	public void testProcessPass1()
	{		
		//There is nothing to test for because the SymbolTable lacks the ability
		//to store information and because my code doesn't directly generate IC
		ArrayList<Token> methTokens = new ArrayList<Token>();
		Token pub = new Token("public",TokenTypes.Public.name(),1);
		Token type = new Token("type",TokenTypes.TYPE.name(),1);
		Token id = new Token("Bobby",TokenTypes.Id.name(),1);
		Token L = new Token("(",TokenTypes.LPara.name(),1);
		Token fL = new Token("FORMAL_L",TokenTypes.FORMAL_L.name(),1);
		Token R = new Token(")",TokenTypes.RPara.name(),1);
		Token mB = new Token("METH_BODY",TokenTypes.METH_BODY.name(),1);
		
		methTokens.add(pub);
		methTokens.add(type);
		methTokens.add(id);
		methTokens.add(L);
		methTokens.add(fL);
		methTokens.add(R);
		methTokens.add(mB);
		
		Token meth = new Token(TokenTypes.METHOD_DECL.name(), 1, methTokens);
		
		ArrayList<Token> methDecl = new ArrayList<Token>();
		methDecl.add(meth);
		
		ArrayList<Token> tokens = new ArrayList<Token>();
		Token t1 = new Token(TokenTypes.METH_DECL_L.name(), 2, methDecl);
		tokens.add(t1);
		
		Token test = new Token(TokenTypes.METH_DECL_L.name(), 1, tokens);
		ProcessMETH_DECL_L.processPass1(test);
	}
	
	/**
	 * This tests for Pass1. 
	 */
	@Test
	public void testProcessPass2()
	{		
		//There is nothing to test for because the SymbolTable lacks the ability
		//to store information and because my code doesn't directly generate IC
		ArrayList<Token> methTokens = new ArrayList<Token>();
		Token pub = new Token("public",TokenTypes.Public.name(),1);
		Token type = new Token("type",TokenTypes.TYPE.name(),1);
		Token id = new Token("Bobby",TokenTypes.Id.name(),1);
		Token L = new Token("(",TokenTypes.LPara.name(),1);
		Token fL = new Token("FORMAL_L",TokenTypes.FORMAL_L.name(),1);
		Token R = new Token(")",TokenTypes.RPara.name(),1);
		Token mB = new Token("METH_BODY",TokenTypes.METH_BODY.name(),1);
		
		methTokens.add(pub);
		methTokens.add(type);
		methTokens.add(id);
		methTokens.add(L);
		methTokens.add(fL);
		methTokens.add(R);
		methTokens.add(mB);
		
		Token meth = new Token(TokenTypes.METHOD_DECL.name(), 1, methTokens);
		
		ArrayList<Token> methDecl = new ArrayList<Token>();
		methDecl.add(meth);
		
		ArrayList<Token> tokens = new ArrayList<Token>();
		Token t1 = new Token(TokenTypes.METH_DECL_L.name(), 2, methDecl);
		tokens.add(t1);
		
		Token test = new Token(TokenTypes.METH_DECL_L.name(), 1, tokens);
		ProcessMETH_DECL_L.processPass2(test);
	}
	
	/**
	 * This tests for Pass1. 
	 */
	@Test
	public void testProcessPass3()
	{		
		//There is nothing to test for because the SymbolTable lacks the ability
		//to store information and because my code doesn't directly generate IC
		ArrayList<Token> methTokens = new ArrayList<Token>();
		Token pub = new Token("public",TokenTypes.Public.name(),1);
		Token type = new Token("type",TokenTypes.TYPE.name(),1);
		Token id = new Token("Bobby",TokenTypes.Id.name(),1);
		Token L = new Token("(",TokenTypes.LPara.name(),1);
		Token fL = new Token("FORMAL_L",TokenTypes.FORMAL_L.name(),1);
		Token R = new Token(")",TokenTypes.RPara.name(),1);
		Token mB = new Token("METH_BODY",TokenTypes.METH_BODY.name(),1);
		
		methTokens.add(pub);
		methTokens.add(type);
		methTokens.add(id);
		methTokens.add(L);
		methTokens.add(fL);
		methTokens.add(R);
		methTokens.add(mB);
		
		Token meth = new Token(TokenTypes.METHOD_DECL.name(), 1, methTokens);
		
		ArrayList<Token> methDecl = new ArrayList<Token>();
		methDecl.add(meth);
		
		ArrayList<Token> tokens = new ArrayList<Token>();
		Token t1 = new Token(TokenTypes.METH_DECL_L.name(), 2, methDecl);
		tokens.add(t1);
		
		Token test = new Token(TokenTypes.METH_DECL_L.name(), 1, tokens);
		ProcessMETH_DECL_L.processPass3(test);
	}
}
