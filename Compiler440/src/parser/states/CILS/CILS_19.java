package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;

public class CILS_19 extends State
{
	/**
	 * Method used to shift on RightBrace and change to state 20.
	 */
	@Override
	public void shiftRightBrace() throws ParserException
	{
		changeToState(new CILS_20());
	}
}
