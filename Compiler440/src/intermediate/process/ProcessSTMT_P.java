package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Curtis Rabe
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

	public static void processPass2(Token subject) {
		// TODO Auto-generated method stub
		
	}

	public static void processPass3(Token subject)
	{
		if(subject.getChildren().get(0).getTokenName() == TokenTypes.STMT_P.name())
		{
			Token child = subject.getChildren().get(0);
			child.Pass3(child.getChildren());
		}
	}
}
