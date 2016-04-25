package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Curtis Rabe
 * 
 * Process class for STMT (the big one)
 */
public class ProcessSTMT
{
	/**
	 * Using DFS, go through the possible STMT variations to process the STMT token
	 * 
	 * @param subject the incoming token
	 */
	public static void processPass1(Token subject)
	{
		//switch on the first child.getName...
		switch(subject.getChildren().get(0).getTokenName())
		{
		//TODO - finish the stuff
			case "LBrace":
				if(subject.getChildren().get(1).getTokenName().equals(TokenTypes.STMT_P.name()))
				{
					ProcessSTMT_P.processPass1(subject.getChildren().get(1));
				}
			default:
				break;
		}
		
	}

	public static void processPass2(Token subject) {
		// TODO Auto-generated method stub
		
	}

	public static void processPass3(Token subject) {
		// TODO Auto-generated method stub
		
	}
}
