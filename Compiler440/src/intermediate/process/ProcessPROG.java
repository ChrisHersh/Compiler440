package intermediate.process;

import tokenizer.Token;

/**
 * 
 * @author shannon jones
 * handles process passes for PROG -> MAIN_CLASS CLASS_DECL_L
 */
public class ProcessPROG 
{
	/**
	 * Pass 1 -> Gather name and type of all variables, methods, classes
	 * @author Shannon Lee
	 * @param subject
	 */
	public static void processPass1(Token subject) 
	{
		subject.getChildren().get(0).setParentClass(subject.getParentClass());
		Token.pass1(subject.getChildren());
		subject.getChildren().get(0).setVisited();
		
	}

	/**
	 * Pass 2 -> Check that all types are valid
	 * @author Shannon Lee
	 * @param subject
	 */
	public static void processPass2(Token subject) throws ProcessException
	{
		subject.pass2(subject.getChildren());
		
	}

	/**
	 * Pass 3 -> Usage Check (exists, type match, generate intermediate code)
	 * @author Shannon Lee
	 * @param subject
	 */
	public static void processPass3(Token subject) 
	{
		Token.pass3(subject.getChildren());
		
	}
}
