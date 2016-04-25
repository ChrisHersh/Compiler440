package intermediate.process;
import static org.junit.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
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
		//There is nothing to test for because the SymbolTable lacks the ability
		//to store information and because my code doesn't directly generate IC
		ArrayList<Token> varTokens = new ArrayList<Token>();
		Token type = new Token("int",TokenTypes.TYPE.name(),1);
		Token id = new Token("Bobby",TokenTypes.Id.name(),1);
		Token semi = new Token(";",TokenTypes.SemiColon.name(),1);
		
		varTokens.add(type);
		varTokens.add(id);
		varTokens.add(semi);
		
		Token test = new Token(TokenTypes.VAR_DECL.name(), 1, varTokens);
		ProcessVAR_DECL.processPass1(test);
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
		
		Token test = new Token(TokenTypes.VAR_DECL.name(), 1, varTokens);
		ProcessVAR_DECL.processPass2(test);
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
		
		Token test = new Token(TokenTypes.VAR_DECL.name(), 1, varTokens);
		ProcessVAR_DECL.processPass3(test);
		
		//Find the line that contains the variable Bobby. Then, check to see if
		//the whole line is printed in the correct syntax.
		//If it is, then pass turns out to be true. Otherwise, it is left false 
		Boolean pass = false;
		String fileName = Paths.get("intermediate.txt").toString();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) 
		{
			String line;
			while (pass == false && (line = br.readLine()) != null) 
			{
				if(line.contains(id.getTokenName()))
				{
					String check = "STORE Tmp1 " + id.getTokenName();
					if(line.equals(check))
					{
						pass = true;
					}
				}
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		assertTrue(pass);
	}
}