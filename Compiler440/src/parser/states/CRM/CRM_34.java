package parser.states.CRM;

import parser.states.State;
import tokenizer.TokenTypes;
/**
 * @author Chris Kjeldgaard
 */
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
