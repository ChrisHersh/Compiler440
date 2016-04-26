package intermediate.process;

import tokenizer.Token;

/**
 * 
 * @author shannon jones
 * Handles process passes for:  MAIN_CLASS ­> class id { MAIN_METHOD }
 * 
 * class id.setClassName(ClassName)
 * class id.setMethodName(MethodName)
 */
public class ProcessMAIN_CLASS 
{
	/**
	 * Pass 1 -> Gather name and type of all variables, methods, classes
	 * @author sj2451
	 * @param subject
	 */
	public static void processPass1(Token subject) 
	{
		for(int i = 0; i < subject.getChildren().size(); i++)
		{
			subject.getChildren().get(i).setParentClass(subject.getParentClass());
			subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
		}
		if(subject.getChildren().get(0).isVisited() == false)
		{
			Token.pass1(subject.getChildren());
		}
		subject.setType(subject.getChildren().get(1).getType());
		
	}

	/**
	 * Pass 2 -> Check that all types are valid
	 * @author sj2451
	 * @param subject
	 */
	public static void processPass2(Token subject) 
	{
		// TODO Auto-generated method stub
		
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
