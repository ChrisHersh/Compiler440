package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;

public class CILS_7 extends State
{
	/**
	 * Method used to shift on left brace '(' and change to state 12
	 * @author Shannon Jones
	 */
	@Override
	public void shiftLeftPara() throws ParserException
	{
		changeToState(new CILS_12());
	}
}
