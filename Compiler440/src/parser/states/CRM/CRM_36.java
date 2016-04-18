package parser.states.CRM;

import parser.states.State;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * @author Chris Kjeldgaard
 */
public class CRM_36 extends State {
	/**
	 * Changes to state CRM_38
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftFORMAL_R() {
		changeToState(new CRM_38());
	}

	/**
	 * Empty String reduce that puts a FORMAL_R token on the stack
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void invalidState() {
		currentParser.pushInputStack(new Token(TokenTypes.FORMAL_R.name(),
				TokenTypes.FORMAL_R.toString(), currentParser.peekInputStack()
						.getLineNumber()));
	}
}
