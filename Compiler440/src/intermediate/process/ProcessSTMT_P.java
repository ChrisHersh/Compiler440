package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Curtis Rabe, Mike Zimmerman, Jared Good
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
		subject.setType(subject.getChildren().get(1).getType());
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
	 * Generates intermediate code for STMT_P
	 * 
	 * @author Jared Good
	 * @param subject Token to be processed
	 */
	public static void processPass3(Token subject)
	{
		if( subject.getChildren().get(0).isVisited() == false )
		{
			// Generates the code for the rule:
			// STMT_P -> STMT_P STMT
			if( subject.getChildren().get(0).getTokenName().equals( TokenTypes.STMT_P.name() ) )
			{
				// STMT_P token
				Token stmtp = subject.getChildren().get(0);
				Token stmt = subject.getChildren().get(1);
				String code;
				
				// Processes the tokens to generate their intermediate code
				Token.pass3(stmtp);
				Token.pass3(stmt);
				
				// Adds STMT_P code to the current STMT_P code
				code = stmtp.getCode().toString();
				subject.getCode().append(code);
				
				// Adds STMT code to the current STMT_P code
				code = stmt.getCode().toString();
				subject.getCode().append(code);
			}
		}
		
		subject.setVisited();
	}
}
