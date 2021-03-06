package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;
/**
 * Implements the methods from state CRM_3
 * @author Chris Kjeldgaard
 */
public class CRM_3 extends State
{
	/**
	 * reduces to the CRM_1 state and generates the token VAR_DECL_L
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void invalidState() throws ParserException
	{
		reduceNumberOfStates(2, TokenTypes.VAR_DECL_L);
	}
}
