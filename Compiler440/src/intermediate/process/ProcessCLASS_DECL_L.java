package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * 
 * @author shannon jones
 * CLASS_DECL_L­> CLASS_DECL_L CLASS_DECL
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
		
		
		
	
		
	}
	
/**
 * Pass 2 -> Check that all types are valid
 * @author sj2451
 * @param subject
 */
	public static void processPass2(Token subject) 
	{
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.CLASS_DECL_L.name()))
		{
			ProcessCLASS_DECL_L.processPass1(subject.getChildren().get(0));
			ProcessCLASS_DECL.processPass1(subject.getChildren().get(1));
			
		}
		
	}
	
/**
 * Pass 3 -> Usage Check (exists, type match, generate intermediate code)
 * @author shannon jones
 * @param subject
 */
	public static void processPass3(Token subject) 
	{
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.CLASS_DECL_L.name()))
		{
			ProcessCLASS_DECL_L.processPass1(subject.getChildren().get(0));
			ProcessCLASS_DECL.processPass1(subject.getChildren().get(1));
			
		}
		
	}
}
