package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Handles passing for FORMAL_R
 * @author Jessica Schlesiger
 */
public class ProcessFORMAL_R {
	public static void processPass1(Token subject) {
		// TODO Auto-generated method stub
		
	}

	public static void processPass2(Token subject) {
		// TODO Auto-generated method stub
		
	}
	/**
	* Passes up needed data, tests need wrote and codes needs finished
	* @param subject
	* @author Jessica Schlesiger
	*/
	public static void processPass3(Token subject) {
		if(subject.getChildren().get(0).getTokenName() == TokenTypes.FORMAL_R.name())
		{
			ProcessFORMAL_R.processPass3(subject.getChildren().get(0));
			// Needs comma token
			ProcessTYPE.processPass3(subject.getChildren().get(1));
		}
		
	}
}
