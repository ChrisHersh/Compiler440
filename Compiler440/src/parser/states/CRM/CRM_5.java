package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;
/**
 * Implements the methods from state CRM_5
 * @author thepure12
 */
public class CRM_5 extends State
{
	/**
	 * Reduces to state CMR_1 and generates a new token
	 * @author thepure12
	 */
	@Override
	public void invalidState() throws ParserException
	{
		reduceNumberOfStates(4, TokenTypes.M_METH_BODY);
	}
}
