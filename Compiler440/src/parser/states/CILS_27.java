package parser.states;

import tokenizer.TokenTypes;

public class CILS_27 extends State
{
	/**
	 * Reduce to CILS_5.
	 */
	@Override
	public void invalidState()
	{
		reduceToState(new CILS_5(), TokenTypes.STMT);
	}
}
