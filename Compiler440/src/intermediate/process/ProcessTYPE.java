package intermediate.process;

import tokenizer.Token;
/**
 * Handles passing for TYPE -> int [] || boolean || int || id
 * @author Jessica Schlesiger
 */
public class ProcessTYPE {
	/**
	 * Does nothing, no need
	 * @param subject info being passed in
	 * @author Jessica Schlesiger
	 */
	public static void processPass1(Token subject) {
		
	}

	/**
	 * No types to check for this state
	 * @param subject info being passed in
	 * @author Jessica Schlesiger
	 */
	public static void processPass2(Token subject) throws ProcessException {
		subject.pass2(subject.getChildren());
	}
	/**
	 * Passes the information
	 * @param subject info being passed in
	 * @author Jessica Schlesiger
	 */
	public static void processPass3(Token subject) {
		subject.setCode(new StringBuffer("TYPE.getType()"));
	}
}
