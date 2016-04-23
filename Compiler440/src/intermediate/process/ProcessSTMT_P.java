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

	public static void processPass3(Token subject)
	{
		if(subject.getChildren().get(0).getTokenName() == TokenTypes.STMT_P.name())
		{
			ProcessSTMT_P.processPass3(subject.getChildren().get(0));
			ProcessSTMT.processPass3(subject.getChildren().get(1));
		}
	}
}
