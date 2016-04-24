package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Handles passing for METH_BODY
 * @author Jessica Schlesiger
 */
public class ProcessMETH_BODY {
	
	public static void processPass1(Token subject) {
		
		
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
		if(subject.getChildren().get(0).getTokenName() == TokenTypes.METH_BODY.name())
		{
			// Needs "LeftBrace" token
			ProcessVAR_DECL_L.processPass3(subject.getChildren().get(0));
			ProcessSTMT_P.processPass3(subject.getChildren().get(1));
			// Needs "return" token
			ProcessEXP1.processPass3(subject.getChildren().get(2));
			// Needs semicolon token
			// Needs RightBrace token
		}
		
	}
}
