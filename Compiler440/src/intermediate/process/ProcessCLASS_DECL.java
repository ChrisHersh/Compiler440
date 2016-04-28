package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * 
 * @author shannon jones
 * Handle process passes for:
 * CLASS_DECL­> class id { VAR_DECL_L METH_DECL_L }
 *           ­> class id extends id { VAR_DECL_L METH_DECL_L }
 * 
 * ClassName = id.getToken()
 * VAR_DECL_L.setClassName(ClassName)
 * METH_DECL_L.setClassName(ClassName)
 * 
 */
public class ProcessCLASS_DECL 
{
	/**
	 * Pass 1 -> Gather name and type of all variables, methods, classes
	 * @author sj2451
	 * @param subject
	 */
	public static void processPass1(Token subject) 
	{
		for(int i= 0; i < subject.getChildren().size(); i++)
		{
			subject.getChildren().get(i).setParentClass(subject.getParentClass());
			subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
			Token.pass1(subject.getChildren());
			subject.getChildren().get(i).setVisited();
		}
		
	}

	/**
	 * Pass 2 -> Check that all types are valid
	 * @author sj2451
	 * @param subject
	 */
	public static void processPass2(Token subject)  throws ProcessException
	{
		subject.pass2(subject.getChildren());
		
	}

	/**
	 * Pass 3 -> Usage Check (exists, type match, generate intermediate code)
	 * @author shannon jones
	 * @param subject
	 */
	public static void processPass3(Token subject) 
	{
		Token mainMethod = subject.getChildren().get(3);
		
		String code;
		
		Token.pass3(mainMethod);
		
		code = mainMethod.getCode().toString();
		subject.getCode().append(" " + subject.getParentClass().getName() + " " + subject.getParentMethod().getMethodName() + " { " + code + " }");
		
	}
}
