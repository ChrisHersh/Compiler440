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
		subject.getChildren().get(0).setParentClass(subject.getParentClass());
		subject.getChildren().get(0).setParentMethod(subject.getParentMethod());
		Token.pass1(subject.getChildren());
		subject.getChildren().get(0).setVisited();
	}

	/**
	 * Check that all types are valid for our children
	 * May not need to do anything?
	 */
	public static void processPass2(Token subject) 
	{
		subject.pass2(subject.getChildren());
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
	 */
	public static void processPass3(Token subject) 
	{
		//Create starting label using the ID in the method, as well as the line number
		//in order to prevent duplicate labels
		Token methId = subject.getChildren().get(2);
		subject.getCode().append(methId.getTokenName() + "_" + methId.getLineNumber() + ":");
		
		//Now let children generate intermediate code after this label
		Token.pass3(subject.getChildren());
	}
}