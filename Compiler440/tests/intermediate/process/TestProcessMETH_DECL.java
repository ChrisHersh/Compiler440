package intermediate.process;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
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
	 * This tests for Pass1. 
	 */
	@Test
	public void testProcessPass1()
	{		
		//There is nothing to test for because the SymbolTable lacks the ability
		//to store information and because my code doesn't directly generate IC
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
	 * This tests for Pass2. 
	 */
	@Test
	public void testProcessPass2()
	{		
		//There is nothing to test for because the SymbolTable lacks the ability
		//to store information and because my code doesn't directly generate IC
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
		
		ProcessMETH_DECL.processPass2(test);
	}
	
	/**
	 * This tests for Pass3. It verifies that IC was done correctly. 
	 * @throws IOException 
	 */
	@Test
	public void testProcessPass3() throws IOException
	{		
		//There is nothing to test for because the SymbolTable lacks the ability
		//to store information and because my code doesn't directly generate IC
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
		Boolean pass = false;
		String fileName = Paths.get("intermediate.txt").toString();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) 
		{
			String line;
			while (pass == false && (line = br.readLine()) != null) 
			{
				if(line.contains(id.getTokenName()))
				{
					String check = id.getTokenName() + "." + id.getLineNumber() + ":";
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
