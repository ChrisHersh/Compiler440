package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Handles passing for METH_BODY -> { VAR_DECL_L STMT_P return EXP1 ; }
 * @author Jessica Schlesiger
 */
public class ProcessMETH_BODY {
	/**
	 * Gather names and types of all methods
	 * @param subject info being passed in
	 * @author Jessica Schlesiger
	 */
	public static void processPass1(Token subject) {

		// Gives parentClass and parentMethod to all children
		for(int x = 0; x < subject.getChildren().size(); x++)
		{
			subject.getChildren().get(x).setParentClass(subject.getParentClass());
			subject.getChildren().get(x).setParentMethod(subject.getParentMethod());
			subject.getChildren().get(x).setVisited();
		}
		Token.pass1(subject.getChildren());
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
	 * No intermediate code for this state
	 * @param subject info being passed in
	 * @author Jessica Schlesiger
	 */
	public static void processPass3(Token subject) {

	}
}
