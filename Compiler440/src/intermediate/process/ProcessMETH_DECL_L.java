package intermediate.process;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Responsible for storing all of the correct information for METH_DECL_L
 * 
 * @author Raistlin Hess
 */
public class ProcessMETH_DECL_L 
{
	/**
	 * Gather name and types of all methods
	 */
	public static void processPass1(Token subject) 
	{
		subject.getChildren().get(0).setClass(subject.getClass());
		subject.pass1(subject.getChildren());
		subject.setType(subject.getChildren().get(0));
	}

	/**
	 * Check that all types are valid
	 */
	public static void processPass2(Token subject) 
	{
		subject.pass1(subject.getChildren());
	}

	/**
	 * Generates Intermediate code for METH_DECL_L
	 * 
	 */
	public static void processPass3(Token subject) 
	{
		Token child = subject.getChildren().get(0);
			
		//Traverse down to each METHOD_DECL and generate intermediate code
		//The code is actually generated in ProcessMETH_DECL, it is only called here
		if(child.getTokenName() == TokenTypes.METH_DECL_L.name())
		{
			ProcessMETH_DECL_L.processPass3(child);
			
		}
		if(child.getTokenName() == TokenTypes.METHOD_DECL.name())
		{
			ProcessMETH_DECL.processPass3(child);
		}
	}
}
