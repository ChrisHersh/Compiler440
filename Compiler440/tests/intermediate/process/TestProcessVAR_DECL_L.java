package intermediate.process;

import java.util.ArrayList;

import org.junit.Test;

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
		//There is nothing to test for because the SymbolTable lacks the ability
		//to store information and because my code doesn't directly generate IC
		ArrayList<Token> varTokens = new ArrayList<Token>();
		Token type = new Token("int",TokenTypes.TYPE.name(),1);
		Token id = new Token("Bobby",TokenTypes.Id.name(),1);
		Token semi = new Token(";",TokenTypes.SemiColon.name(),1);
		
		varTokens.add(type);
		varTokens.add(id);
		varTokens.add(semi);
		
		Token var = new Token(TokenTypes.VAR_DECL.name(), 1, varTokens);
		
		ArrayList<Token> varDecl = new ArrayList<Token>();
		varDecl.add(var);
		
		ArrayList<Token> tokens = new ArrayList<Token>();
		Token t1 = new Token(TokenTypes.VAR_DECL_L.name(), 2, varDecl);
		tokens.add(t1);
		
		Token test = new Token(TokenTypes.VAR_DECL_L.name(), 1, tokens);
		ProcessVAR_DECL_L.processPass1(test);
	}
	
	/**
	 * This tests for Pass2. 
	 */
	@Test
	public void testProcessPass2()
	{		
		//There is nothing to test for because the SymbolTable lacks the ability
		//to store information and because my code doesn't directly generate IC
		ArrayList<Token> varTokens = new ArrayList<Token>();
		Token type = new Token("int",TokenTypes.TYPE.name(),1);
		Token id = new Token("Bobby",TokenTypes.Id.name(),1);
		Token semi = new Token(";",TokenTypes.SemiColon.name(),1);
		
		varTokens.add(type);
		varTokens.add(id);
		varTokens.add(semi);
		
		Token var = new Token(TokenTypes.VAR_DECL.name(), 1, varTokens);
		
		ArrayList<Token> varDecl = new ArrayList<Token>();
		varDecl.add(var);
		
		ArrayList<Token> tokens = new ArrayList<Token>();
		Token t1 = new Token(TokenTypes.VAR_DECL_L.name(), 2, varDecl);
		tokens.add(t1);
		
		Token test = new Token(TokenTypes.VAR_DECL_L.name(), 1, tokens);
		ProcessVAR_DECL_L.processPass2(test);
	}
	
	/**
	 * This tests for Pass3. 
	 */
	@Test
	public void testProcessPass3()
	{		
		//There is nothing to test for because the SymbolTable lacks the ability
		//to store information and because my code doesn't directly generate IC
		ArrayList<Token> varTokens = new ArrayList<Token>();
		Token type = new Token("int",TokenTypes.TYPE.name(),1);
		Token id = new Token("Bobby",TokenTypes.Id.name(),1);
		Token semi = new Token(";",TokenTypes.SemiColon.name(),1);
		
		varTokens.add(type);
		varTokens.add(id);
		varTokens.add(semi);
		
		Token var = new Token(TokenTypes.VAR_DECL.name(), 1, varTokens);
		
		ArrayList<Token> varDecl = new ArrayList<Token>();
		varDecl.add(var);
		
		ArrayList<Token> tokens = new ArrayList<Token>();
		Token t1 = new Token(TokenTypes.VAR_DECL_L.name(), 2, varDecl);
		tokens.add(t1);
		
		Token test = new Token(TokenTypes.VAR_DECL_L.name(), 1, tokens);
		ProcessVAR_DECL_L.processPass3(test);
	}
}
