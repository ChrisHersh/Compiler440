package parser.states;

import tokenizer.TokenTypes;

public class CRM_5 extends State
{
	/**
	 * Reduces to state CMR_1 and generates a new token
	 * @author thepure12
	 */
	@Override
	protected void invalidState() throws ParserException
	{
		reduceToState(new CRM_0(), TokenTypes.M_METH_BODY);
	}
}
