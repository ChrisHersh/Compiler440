package intermediate.process;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Responsible for storing all of the correct information for VAR_DECL
 * 
 * @author Raistlin Hess
 */
public class ProcessVAR_DECL 
{
	/**
	 * Gather name and types of all vars
	 */
	public static void processPass1(Token subject) 
	{
		Token child = subject.getChildren().get(0);
		if(child.getTokenName() == TokenTypes.VAR_DECL.name())
		{
			ProcessVAR_DECL.processPass1(child);
		}
	}

	/**
	 * Check that all types are valid
	 */
	public static void processPass2(Token subject) 
	{
		Token child = subject.getChildren().get(0);
		if(child.getTokenName() == TokenTypes.VAR_DECL.name())
		{
			ProcessVAR_DECL.processPass2(child);
		}
	}

	/**
	 * Generates Intermediate code for VAR_DECL
	 */
	public static void processPass3(Token subject) 
	{
		Token child = subject.getChildren().get(0);
		PrintWriter pw = null;
		try 
		{
			FileWriter fw = new FileWriter("intermediate.txt",true);
			pw = new PrintWriter(fw);	
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		if(child.getTokenName() == TokenTypes.VAR_DECL.name())
		{
			ProcessVAR_DECL.processPass3(child);
			
			//Store the variable in a temp variable
			pw.println("STORE Tmp1 "+subject.getChildren().get(1).getTokenName());
		}
	}
}
