package parser.states;

import tokenizer.TokenTypes;

public class CRM_1 extends State
{
	/**
	 * Changes to state CRM_2
	 * @author Chris Kjeldgaard
	 */
	public void shiftVAR_DECL_L() throws ParserException
	{
		changeToState(new CRM_2());
	}
	
	@Override
	protected void invalidState() throws ParserException
	{
		reduceToState(this, TokenTypes.VAR_DECL_L);
	}
}
