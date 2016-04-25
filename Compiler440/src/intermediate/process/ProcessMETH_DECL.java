package intermediate.process;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Responsible for storing all of the correct information for METH_DECL
 * 
 * @author Raistlin Hess
 */
public class ProcessMETH_DECL 
{
	/**
	 * Gather name and types of all methods
	 */
	public static void processPass1(Token subject) 
	{
		Token child = subject.getChildren().get(0);
		if(child.getTokenName() == TokenTypes.METHOD_DECL.name())
		{
			ProcessMETH_DECL.processPass1(child);
		}
	}

	/**
	 * Check that all types are valid
	 */
	public static void processPass2(Token subject) 
	{
		Token child = subject.getChildren().get(0);
		if(child.getTokenName() == TokenTypes.METHOD_DECL.name())
		{
			ProcessMETH_DECL.processPass2(child);
		}
	}

	/**
	 * Generates Intermediate code for METH_DECL
	 * @throws IOException 
	 */
	public static void processPass3(Token subject) throws IOException 
	{
		Token child = subject.getChildren().get(0);
		PrintWriter pw = null;
		BufferedWriter bw = null;
		try 
		{
			FileWriter fw = new FileWriter("intermediate.txt",true);
			pw = new PrintWriter(fw);
			bw = new BufferedWriter(fw);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		if(subject.getTokenName() == TokenTypes.METHOD_DECL.name())
		{
//			ProcessMETH_DECL.processPass3(child);
			
			//Create starting label using the ID in the method
			pw.println(subject.getChildren().get(2).getTokenName() + "." + child.getLineNumber() + ":");
		}
		
		//IC for TYPE should be taken care of in ProcessTYPE
		if(child.getTokenName() == TokenTypes.TYPE.name())
		{
			ProcessTYPE.processPass3(child);
		}
		
		//IC for FORMAL_L should be taken care of in ProcessFORMAL_L
		if(child.getTokenName() == TokenTypes.FORMAL_L.name())
		{
			ProcessFORMAL_L.processPass3(child);
		}
		
		//IC for METH_BODY should be taken care of in ProcessMETH_BODY
		if(child.getTokenName() == TokenTypes.METH_BODY.name())
		{
			ProcessMETH_BODY.processPass3(child);
		}
	}
}