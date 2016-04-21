package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

public class ProcessSTMT_P {
	public static void processPass1(Token subject) {
		// TODO Auto-generated method stub
		
	}

	public static void processPass2(Token subject) {
		// TODO Auto-generated method stub
		
	}

	public static void processPass3(Token subject) throws ProcessException
	{
		
		if(subject.getChildren().get(0).getTokenName() == TokenTypes.STMT_P.name())
		{
			ProcessSTMT_P.processPass3(subject.getChildren().get(0));
			if(subject.getChildren().get(1).getTokenName() == TokenTypes.STMT.name())
			{
				ProcessSTMT_P.processPass3(subject.getChildren().get(1));
			}
			else 
			{
				throw new ProcessException();
			}
		}
		else{
			if(subject.getChildren().get(1).getTokenName() == TokenTypes.STMT.name())
			{
				ProcessSTMT_P.processPass3(subject.getChildren().get(1));
			}
			else 
			{
				throw new ProcessException();
			}	
		}
		// TODO
		
	}
}
