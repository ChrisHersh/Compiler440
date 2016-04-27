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
		//Give parentClass and parentMethod to all children
		for(int x = 0; x < subject.getChildren().size(); x++)
		{
			subject.getChildren().get(x).setParentClass(subject.getParentClass());
			subject.getChildren().get(x).setParentMethod(subject.getParentMethod());
			subject.getChildren().get(x).setVisited();
		}
		Token.pass1(subject.getChildren());
	}

	/**
	 * There are no types to check for this state
	 */
	public static void processPass2(Token subject) 
	{
		Token.pass2(subject.getChildren());
	}

	/**
	 * There is no intermediate code to generate for this state
	 */
	public static void processPass3(Token subject) 
	{
		
	}
}
