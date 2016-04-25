package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Curtis Rabe, Jared Good, Mike Zimmerman
 * 
 * The Process class for EXP_L (3 passes included)
 *
 */
public class ProcessEXP_L
{
	/**
	 * Using DFS, checks to make sure that the current token has children, then
	 * processes the first child of EXP_L (which is EXP1), Then processes the second child
	 * (of 2 total children) which is EXP_R. Nothing is added to the symboltable at this step,
	 * because the program would not yet have come across an addable item.
	 * 
	 * @param subject the incoming token
	 * 
	 */
	public static void processPass1(Token subject)
	{
		if(subject.getChildren() != null)
		{
			ProcessEXP1.processPass1(subject.getChildren().get(0));
			ProcessEXP_R.processPass1(subject.getChildren().get(1));
		}
		
	}

	/**
	 * the second pass for processing EXP_L
	 * @param subject
	 */
	public static void processPass2(Token subject) {
		if(subject.getChildren() != null)
		{
			ProcessEXP1.processPass2(subject.getChildren().get(0));
			ProcessEXP_R.processPass2(subject.getChildren().get(1));
		}
	}

	public static void processPass3(Token subject) 
	{
		if(subject.getChildren().get(0).getTokenName() == TokenTypes.EXP1.name())
		{
			Token child = subject.getChildren().get(0);
			child.Pass3(child.getChildren());
			
			child = subject.getChildren().get(1);
			child.Pass3(child.getChildren());
		}		
	}
}
