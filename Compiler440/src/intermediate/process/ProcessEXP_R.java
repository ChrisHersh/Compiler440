package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Curtis Rabe, Jared Good, Mike Zimmerman
 * 
 * The 3-Pass Process class for EXP_R
 *
 */
public class ProcessEXP_R
{
	
	/**
	 * @author Curtis Rabe
	 * Processes the first child of EXP_R, but that is a comma, and
	 * I do not believe we are processing terminals. Then processes the second child
	 * (of 2 total children) which is EXP1. Nothing is added to the symboltable at this step,
	 * because the program would not yet have come across an addable item.
	 * 
	 * Note, once EXP1 traverses down to EXP7, the ids will need to be added, but currently
	 * EXP_R has no access to ids (classes, methods, or variables)
	 * 
	 * @param subject - the token input into the process
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
		subject.setVisited();
		//passes up the type of EXP1 instead of a comma
		subject.setType(subject.getChildren().get(1).getType());
		
	}

	/**
	 * the second pass of the processing of EXP_R
	 * @param subject the token that is EXP_R and all its childern
	 */
	public static void processPass2(Token subject) 
	{
//		Token child = subject.getChildren().get(1);
//		child.Pass2(child.getChildren());
		if(subject.getChildren().get(0).getTokenName().equals(TokenTypes.Comma.name()))
		{
			ProcessEXP1.processPass2(subject.getChildren().get(1));
		}
	}

	/**
	 * Generates intermediate code for EXP_R
	 * 
	 * @author Jared Good
	 * @param subject Token to be processed
	 */
	public static void processPass3(Token subject) 
	{
		if( subject.getChildren() != null ){
			// EXP1 token
			Token child = subject.getChildren().get(1);
			
			// Processes EXP1 to generate its intermediate code
			Token.pass3(child);
			
			// Adds EXP1 code to the EXP_R token
			String code = child.getCode().toString();
			subject.getCode().append(code);
			
		}
	}
}
