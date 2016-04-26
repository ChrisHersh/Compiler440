package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Han
 * @author shannon jones
 * class for handling CLASS_DECL_L­> CLASS_DECL_L CLASS_DECL
 *
 */
public class ProcessCLASS_DECL_L 
{
	
	/**
	 * Pass 1 -> Gather name and type of all variables, methods, classes
	 * @author sj2451
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
 * @author sj2451
 * @param subject
 */
	public static void processPass2(Token subject) 
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
		Token.pass3(subject.getChildren());
		
	}
}
