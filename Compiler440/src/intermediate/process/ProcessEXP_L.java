package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

public class ProcessEXP_L {
	public static void processPass1(Token subject) {
		// TODO Auto-generated method stub
		
	}

	public static void processPass2(Token subject) {
		// TODO Auto-generated method stub
		
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
