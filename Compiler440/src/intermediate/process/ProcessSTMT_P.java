package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Curtis Rabe, Mike Zimmerman
 * 
 * Class to process STMT_P
 */
public class ProcessSTMT_P
{
	/**
	 * Using DFS, checks to make sure that the current token has children, then
	 * processes the first child of STMT_P (which is STMT_P), Then processes the second child
	 * (of 2 total children) which is STMT. Nothing is added to the symboltable at this step,
	 * because the program would not yet have come across an addable item.
	 * 
	 * @param subject the incoming token
	 */
	public static void processPass1(Token subject)
	{
		if(subject.getChildren() != null)
		{
			ProcessSTMT_P.processPass1(subject.getChildren().get(0));
			ProcessSTMT.processPass1(subject.getChildren().get(1));
		}
	}

	/**
	 * the second pass of the processing of STMT_P
	 * @param subject the incoming token
	 */
	public static void processPass2(Token subject) {
		if(subject.getChildren() != null)
		{
			ProcessSTMT_P.processPass2(subject.getChildren().get(0));
			ProcessSTMT.processPass2(subject.getChildren().get(1));
		}
	}

	/**
	 * Generates intermediate code for EXP_L
	 * 
	 * @author Jared Good
	 * @param subject Token to be processed
	 */
	public static void processPass3(Token subject)
	{
		// Generates the code for the rule:
		// STMT_P -> STMT_P STMT
		if( subject.getChildren().get(0).getTokenName().equals( TokenTypes.STMT_P.name() ) )
		{
			// STMT_P token
			Token child = subject.getChildren().get(0);
			
			// Processes STMT_P to generate its intermediate code
			child.Pass3(child.getChildren());
			
			// STMT token
			child = subject.getChildren().get(1);
			
			// Processes STMT to generate its intermediate code
			child.Pass3(child.getChildren());
		}
	}
}
