package intermediate.process;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Responsible for storing all of the correct information for VAR_DECL_L
 * 
 * @author Raistlin Hess
 */
public class ProcessVAR_DECL_L 
{
	/**
	 * Gather name and types of all methods
	 */
	public static void processPass1(Token subject) 
	{
		Token child = subject.getChildren().get(0);
		if(child.getTokenName() == TokenTypes.VAR_DECL_L.name())
		{
			ProcessVAR_DECL_L.processPass1(child);
		}
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
		if(child.getTokenName() == TokenTypes.VAR_DECL_L.name())
		{
			ProcessVAR_DECL_L.processPass1(child);
		}
		if(child.getTokenName() == TokenTypes.VAR_DECL.name())
		{
			ProcessVAR_DECL.processPass1(child);
		}
	}

	/**
	 * Generates Intermediate code for VAR_DECL_L
	 * 
	 */
	public static void processPass3(Token subject) 
	{
		Token child = subject.getChildren().get(0);
			
		//Traverse down to each VAR_DECL and generate intermediate code
		//The code is actually generated in ProcessVAR_DECL, it is only called here
		if(child.getTokenName() == TokenTypes.VAR_DECL_L.name())
		{
			ProcessVAR_DECL_L.processPass3(child);
		}
		if(child.getTokenName() == TokenTypes.VAR_DECL.name())
		{
			ProcessVAR_DECL.processPass3(child);
		}
	}
}
