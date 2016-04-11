package parser.states;

import tokenizer.TokenTypes;

public class CRM_34 extends State {
	/**
	 * Reduces and places the METH_BODY token on the stack
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void invalidState()
	{
		reduceNumberOfStates(7,TokenTypes.METH_BODY);
	}
}
