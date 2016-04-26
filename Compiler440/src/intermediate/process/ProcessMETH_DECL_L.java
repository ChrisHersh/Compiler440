package intermediate.process;
import tokenizer.Token;

/**
 * Responsible for storing all of the correct information for METH_DECL_L
 * 
 * @author Raistlin Hess
 */
public class ProcessMETH_DECL_L 
{
	/**
	 * Pass class and method information up and down
	 */
	public static void processPass1(Token subject) 
	{
		//Give parentClass and parentMethod to all children
		for(int x = 0; x < subject.getChildren().size(); x++)
		{
			subject.getChildren().get(x).setParentClass(subject.getParentClass());
			subject.getChildren().get(x).setVisited();
		}
		Token.pass1(subject.getChildren());
	}

	/**
	 * There are no types to check for in this state
	 */
	public static void processPass2(Token subject) 
	{
		Token.pass2(subject.getChildren());
	}

	/**
	 * There is no intermediate code that this pass creates directly, only
	 * through its children
	 * 
	 */
	public static void processPass3(Token subject) 
	{
		Token.pass3(subject.getChildren());
	}
}
