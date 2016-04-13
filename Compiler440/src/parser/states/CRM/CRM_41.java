package parser.states.CRM;

import parser.states.State;
import tokenizer.TokenTypes;

public class CRM_41 extends State {
	/**
	 * Reduce that puts the FORMAL_R token on the input stack
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void invalidState() {
		reduceNumberOfStates(4, TokenTypes.FORMAL_R);
	}
}
