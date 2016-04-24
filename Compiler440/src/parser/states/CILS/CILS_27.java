package parser.states.CILS;

import parser.states.State;
import tokenizer.TokenTypes;

/**
 * @author Chad Nunemaker
 */
public class CILS_27 extends State
{
	/**
	 * Reduce to CILS_5.
	 */
	@Override
	public void invalidState()
	{
		reduceNumberOfStates(7, TokenTypes.STMT);
	}
}
