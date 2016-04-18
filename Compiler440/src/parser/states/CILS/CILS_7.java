package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;

/**
 * Class that handles the CILS_7 states
 * @author Shannon Jones
 *
 */
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
