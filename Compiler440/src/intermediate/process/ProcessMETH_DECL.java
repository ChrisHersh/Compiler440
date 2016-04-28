package intermediate.process;
import tokenizer.Token;

/**
 * Responsible for storing all of the correct information for METH_DECL
 * 
 * @author Raistlin Hess
 */
public class ProcessMETH_DECL 
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
			subject.getChildren().get(x).setParentMethod(subject.getParentMethod());
			subject.getChildren().get(x).setVisited();
		}
		Token.pass1(subject.getChildren());
	}

	/**
	 * There are not types to check for in this state.
	 */
	public static void processPass2(Token subject) throws ProcessException
	{
		Token.pass2(subject.getChildren());
//		//Check to see if the Type returned by METH_BODY is the same Type as 
//		//the return Type in METH_DECL
//		String methType = "";
//		if(subject.getToken().equals("METH_BODY"))
//		{
//			methType = subject.getChildren().get(4).getType();
//		}
//		if(subject.getToken().equals("METH_DECL"))
//		{
//			
//		}
	}

	/**
	 * Generates intermediate code for METH_DECL
	 * More specifically, it creates a label for this method and then
	 * has its children write the rest
	 */
	public static void processPass3(Token subject) 
	{
		//Create starting label using the ID in the method, as well as the line number
		//in order to prevent duplicate labels
		Token methId = subject.getChildren().get(2);
		subject.getCode().append("Method_" + methId.getToken() + "_" + methId.getLineNumber() + ":\n");
		
		//Now let children generate intermediate code after this label
		Token.pass3(subject.getChildren());
	}
}