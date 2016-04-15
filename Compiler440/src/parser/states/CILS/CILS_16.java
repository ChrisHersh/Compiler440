package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;

/**
 * Class that handles the CILS_16 states
 * @author Shannon Jones
 *
 */
public class CILS_16 extends State
{
	/**
	 * Method used to shift on  right brace ')' and change to state 23
	 * @author Shannon Jones
	 */
	@Override
	public void shiftRightPara() throws ParserException
	{
		changeToState(new CILS_23());
	}
}
