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
	 * Using DFS, processes the first child of EXP_R, but that is a comma, and
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
		if(subject.getChildren().get(0).getTokenName().equals(TokenTypes.Comma.name()))
		{
			//processing a terminal?
			//ProcessComma.processPass1(subject.getChildren().get(0));
			ProcessEXP1.processPass1(subject.getChildren().get(1));
		}
	}

	public static void processPass2(Token subject) {
		// TODO Auto-generated method stub
		
	}

	public static void processPass3(Token subject) {
		// TODO Auto-generated method stub
		
	}
}
