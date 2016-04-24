package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Handles passing for FORMAL_L
 * @author Jessica Schlesiger
 */
public class ProcessFORMAL_L {
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
		if(subject.getChildren().get(0).getTokenName() == TokenTypes.FORMAL_L.name())
		{
			ProcessTYPE.processPass3(subject.getChildren().get(0));
			// Needs ID token
			ProcessFORMAL_R.processPass3(subject.getChildren().get(1));
		}
		
	}
}
