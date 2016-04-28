package intermediate.process;
import tokenizer.Token;

/**
 * Responsible for storing all of the correct information for VAR_DECL
 * 
 * @author Raistlin Hess
 */
public class ProcessVAR_DECL 
{
	/**
	 * Pass class and method information up and down
	 */
	public static void processPass1(Token subject) 
	{
//		subject.getChildren().get(0).setParentClass(subject.getParentClass());
//		subject.getChildren().get(0).setParentMethod(subject.getParentMethod());
//		Token.pass1(subject.getChildren());
//		subject.getChildren().get(0).setVisited();
		
		//Give parentClass and parentMethod to all children
		for(int x = 0; x < subject.getChildren().size(); x++)
		{
			subject.getChildren().get(x).setParentClass(subject.getParentClass());
			subject.getChildren().get(x).setParentMethod(subject.getParentMethod());
			subject.getChildren().get(x).setVisited();
		}
		Token.pass1(subject.getChildren());
		subject.setType(subject.getChildren().get(0).getType());
	}

	/**
	 * There are no types to check for this state
	 */
	public static void processPass2(Token subject) throws ProcessException
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
